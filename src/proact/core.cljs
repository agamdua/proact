(ns proact.core
  (:require [clojure.browser.repl :as repl]))

(defn template-parse [match context]
    ;; eval a match and then if it works return it
    (def res (.replace match (get (keyword (.split match #"\.") ) context)))
    res
)

(defn regex-replace [vars context]
    ;; exec the regex on a template string and then replace the results
    (def parse_vars (js/RegExp "{{([^}}]+)}}"))
    (def matches (.exec parse_vars vars))
    (def line (nth matches 1))
    (def final_vars (template-parse line context))
    final_vars
)
