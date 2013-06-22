(ns fp-oo.recursion-test
  (:require [clojure.test :refer :all]
            [fp-oo.recursion :refer :all]))


(deftest a-factorial-test
  (testing "factorial with the first pattern"
    (is (= (factorial 5) 120))
    (is (= (factorial 0) 1))
    (is (= (factorial 1) 1))))

(deftest a-factorial-2-test
  (testing "factorial with the second pattern"
    (is (= (factorial-2 5 1) 120))
    (is (= (factorial-2 0 1) 1))
    (is (= (factorial-2 1 1) 1))))

(deftest a-test-for-recursive-function
  (testing "recursive function to sum secuences"
    (is (= (recursive-function [1 2 3 4] 0) 10))))

(deftest a-test-for-recursive-function-2
  (testing "recursive function to multiply secuences"
    (is (= (recursive-function-2 [1 2 3 4] 1) 24))))

(deftest a-test-for-reduce-function
  (testing "recursive function to reduce secuences "
    (is (= (reduce-function * [1 2 3 4] 1) 24))
    (is (= (reduce-function + [1 2 3 4] 0) 10))))

(deftest a-silly-test-for-exercise-6-4-5
  (testing "try to pass a map to the reduce-function"
    (is (= (reduce-function (fn [so-far elt]
                           (assoc so-far elt 0))
                         [:a :b :c]
                         {}) {:a 0, :b 0, :c 0}))))

