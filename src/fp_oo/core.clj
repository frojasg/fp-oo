(ns fp-oo.core
  (:gen-class))

(def sum
   (fn [& args]
     (apply + args)))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  ;; work around dangerous default behaviour in Clojure
  (alter-var-root #'*read-eval* (constantly false))
  (println "Hello, World!"))
