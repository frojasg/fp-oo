(ns fp-oo.higher-order-functions-test
  (:require [clojure.test :refer :all])
  (:require [fp-oo.higher-order-functions :refer :all])
  )

;; Exercise 9.4.1
(deftest a-point-free-land
  (testing "trying point free land"
    (is (= (map (fn [n] (+ 2 n)) [1 2 3]) '(3 4 5)))
    (is (= (map (fn [n] (+ 2 n)) [1 2 3]) [3 4 5]))
    (is (= (map (partial + 2) [1 2 3]) [3 4 5]))))

;; Exercise 9.4.2
(deftest a-juxt-separate
  (testing "seperate with juxt"
    (is (= (separate odd? [1 2 3 4 5]) ['(1 3 5) '(2 4)]))))

;; Exercise 9.4.3
(deftest a-my-fun-test
  (testing "predict the result of typing two lines"
    (is (= (myfun) 3))))

;; Exercise 9.4.4
(deftest a-my-fun2-test
  (testing "replace let"
    (is (= (myfun2) 3))))


;; Exercise 9.4.6
(deftest a-test-always-func
  (testing "create a function that always return a cons"
    (is (= ((always 8) 1 'a :foo) 8))))

;; Exercise 9.4.7
(deftest a-test-check-sum
  (testing "checksum for a sequence"
    (is (= (checksum [4 8 9 3 2]) 69))))

;; Exercise 9.4.8
(deftest a-test-isbn?
  (testing "check for a valid isbn"
    (is (= (isbn? "1934356190") true))
    (is (= (isbn? "0977716614") false))
    (is (= (isbn? "1934356190") true))))

;; Exercise 9.4.9
(deftest a-test-checksum-upc
  (testing "checksum for upc "
    (is (= (checksum-upc [4 8 9 3 2]) 48))))

(deftest a-test-upc?
  (testing "check for a valid upc"
    (is (= (upc? "074182265830") true))
    (is (= (upc? "731124100023") true))
    (is (= (upc? "722252601404") false))))




