(ns proact.core
  (:require [clojure.browser.repl :as repl]))
;; (repl/connect "http://localhost:9000/repl")

(defn replace_match [match context]
    ;; eval a match and then if it works return it
    (def res (.replace match (get (keyword (.split match #"\.") ) context)))
    res
)

(defn kirtify [vars context]
    (def parse_vars (js/RegExp "{{([^}}]+)}}"))
    (def matches (.exec parse_vars vars))
    (def line (nth matches 1))
    (def final_vars (replace_match line context))
    final_vars
)
