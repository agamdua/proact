(ns proact.core
  (:require [clojure.browser.repl :as repl]))

(defn template-parse [match context]
    ;; eval a match and then if it works return it
    (def res (.replace match (get (keyword (.split match #"\.") ) context)))
    res
)

(defn regex-replace [vars context]
    ;; exec the regex on a template string and then replace the results
    (def template-regex (js/RegExp "{{([^}}]+)}}"))
    (def matches (.exec template-regex vars))
    (def line (nth matches 1))
    (def html-string (template-parse line context))
    html-string
)
