(defproject fe "0.1.0"
  :description "A money formatter"
  :url "https://github.com/druids/fe"
  :license {:name "MIT License"
            :url "http://opensource.org/licenses/MIT"}

  :test-paths ["test/cljs" "test/cljc"]

  :cloverage
  {:fail-threshold 90}

  :aliases {"cljs-test"
            ["with-profile" "dev" "doo" "phantom" "once"]}

  :cljsbuild {:builds
              [{:id "test"
                :source-paths ["src" "test/cljs" "test/cljc"]
                :compiler {:output-to "target/public/js/compiled/testable.js"
                           :main fe.test-runner
                           :optimizations :none}}
               {:id "min"
                :source-paths ["src"]
                :jar true
                :compiler {:main fe.core
                           :output-to "target/public/js/compiled/fe.js"
                           :output-dir "target"
                           :source-map-timestamp true
                           :optimizations :advanced
                           :closure-defines {goog.DEBUG false}
                           :parallel-build true
                           :pretty-print false}
                :warning-handlers
                [(fn [warning-type env extra]
                    (when (warning-type cljs.analyzer/*cljs-warnings*)
                      (when-let [s (cljs.analyzer/error-message warning-type extra)]
                        (binding [*out* *err*]
                          (println "WARNING:" (cljs.analyzer/message env s)))
                        (System/exit 1))))]}]}

  :doo {:build "test"}

  :profiles {:dev {:plugins [[jonase/eastwood "0.2.5"]
                             [lein-ancient "0.6.15"]
                             [lein-cljsbuild "1.1.7"]
                             [lein-cloverage "1.0.11"]
                             [lein-doo "0.1.11"]
                             [lein-kibit "0.1.6"]]

                   :dependencies [[org.clojure/clojure "1.10.0"]
                                  [org.clojure/clojurescript "1.10.520"]]}})
