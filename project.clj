(defproject fe "0.0.0"
  :description "A money formatter"
  :url "https://github.com/druids/fe"
  :license {:name "MIT License"
            :url "http://opensource.org/licenses/MIT"}

  :cloverage
  {:fail-threshold 90}

  :profiles {:dev {:plugins [[lein-ancient "0.6.15"]
                             [lein-cloverage "1.0.11"]
                             [lein-kibit "0.1.6"]
                             [jonase/eastwood "0.2.5"]]

                   :dependencies [[org.clojure/clojure "1.10.0"]
                                  [org.clojure/clojurescript "1.10.520"]]}})
