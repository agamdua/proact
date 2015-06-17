(ns proact.core
  (:require [clojure.browser.repl :as repl]))

(defn regex-replace [html-string context]
    ;; exec the regex on a template string and then replace the results
    (def template-regex (js/RegExp "{{([^}}]+)}}"))
    (def matches (.exec template-regex html-string))
    (def word (nth matches 1)) ;; the word to lookup
    (def parsed-string (.replace html-string template-regex (get context (keyword word))))
    parsed-string
)
