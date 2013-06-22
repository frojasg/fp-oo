(ns fp-oo.recursion
  (:gen-class))

;; Exercise 6.4.1

(def factorial
  (fn [n]
    (if (<= n 1)
      1
    (* n (factorial (dec n))))))

;;(prn (factorial 5))

;;Exercise 6.4.2
(def factorial-2
  (fn [n so-far]
    (if (<= n 1)
     so-far
    (factorial-2 (dec n) (* n so-far)))))

;;Exercise 6.4.3
(def recursive-function
  (fn [numbers so-far]
    (if (empty? numbers)
      so-far
    (recursive-function (rest numbers) (+ so-far (first numbers))))))


(def recursive-function-2
  (fn [numbers so-far]
    (if (empty? numbers)
      so-far
    (recursive-function-2 (rest numbers) (* so-far (first numbers))))))

;;Exercise 6.4.4
(def reduce-function
  (fn [combiner numbers so-far]
    (if (empty? numbers)
      so-far
    (reduce-function combiner (rest numbers) (combiner so-far (first numbers))))))
