(ns fp-oo.core-test
  (:require [clojure.test :refer :all]
            [fp-oo.core :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 1 1))))

(deftest test-sum
  (testing "it should sum all the numbers"
    (is (= (sum 1 2) 3))))
