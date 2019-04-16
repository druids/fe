(ns fe.test-runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [fe.core-test]))

(enable-console-print!)

(doo-tests 'fe.core-test)
