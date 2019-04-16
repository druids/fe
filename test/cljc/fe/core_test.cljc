(ns fe.core-test
  (:require #?(:clj [clojure.test :as t]
               :cljs [cljs.test :as t :include-macros true])
            [fe.core :as fe]))

(t/deftest fmr-test
  (t/testing "should format a money"
    (t/are [expected amount opts] (= expected (fe/fmt amount
                                                      "EUR"
                                                      opts))
      "10 000.00 EUR" 10000 {}
      "10 EUR" 10 {:decimal-num 0}
      "10 000,00 EUR" 10000 {:decimal-sep ","}
      "10,000.00 EUR" 10000 {:decimal-sep ".", :part-sep ","}
      "EUR10 000.00" 10000 {:currency-pos :prefix}
      "10 000 EUR" 10000.000009 {:decimal-num 0})))
