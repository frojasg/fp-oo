(ns fp-oo.higher-order-functions
  (:gen-class))

;; Exercise 9.4.2

(def separate (juxt filter remove))

;; Exercise 9.4.3
(def myfun (let [x 3]
  (fn [] x)))

;; Exercise 9.4.4
(def myfun2 (
  (fn [x]
    (fn [] x)
  ) 3))

;; Exercise 9.4.6
(def always
  (fn [constant]
    (fn [& params] constant)))


;; Exercise 9.4.7
(def checksum
  (fn [numbers]
    (apply + (map *
      numbers
      (range 1 (inc (count numbers)))))))


;; Exercise 9.4.8
(def reversed-digits
  (fn [string]
    (map (fn [digit-char]
      (-> digit-char str Integer.))
        (reverse string))))

;;(def isbn?
;;  (fn [isbn]
;;    (zero? (rem (-> isbn reversed-digits checksum) 11))))

;; Exercise 9.4.9
(def checksum-upc
  (fn [numbers]
    (apply + (map *
      numbers
      (map (fn [number]
          (if (odd? number) 1 3))
        (range 1 (inc (count numbers))))
      ))))


;;(def upc?
;;  (fn [isbn]
;;    (zero? (rem (-> isbn reversed-digits checksum-upc) 10))))


;; Exercise 9.4.10
(def number-checker
  (fn [digit-function divisor]
    (fn [candidate]
      (let[digits (reversed-digits candidate)
           check-sum (apply +
              (map digit-function
                (range 1 (inc (count digits)))
                digits))]
      (zero? (rem check-sum divisor))))))


(def isbn? (number-checker * 11))

(def upc? (number-checker
  (fn [number digit]
    (* digit
      (if (odd? number) 1 3)))
  10))



