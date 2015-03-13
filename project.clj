(defproject com.stuartsierra/dependency "0.1.3.2-SANDBAGS"
  :description "A data structure for representing dependency graphs"
  :url "https://github.com/stuartsierra/dependency"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :jar-exclusions [#"\.cljx|\.swp|\.swo|\.DS_Store"]
  :dependencies [[org.clojure/clojure "1.6.0"]]
  :profiles {:dev {:plugins [[com.keminglabs/cljx "0.6.0"]
                             [lein-cljsbuild "1.0.3"]]
                   :prep-tasks [["cljx" "once"] "javac" "compile"]
                   :auto-clean false
                   :cljx {:builds [{:source-paths ["src/cljx"]
                                    :output-path "target/classes"
                                    :rules :clj}
                                   {:source-paths ["src/cljx"]
                                    :output-path "target/classes"
                                    :rules :cljs}
                                   {:source-paths ["test/cljx"]
                                    :output-path "target/classes"
                                    :rules :clj}
                                   {:source-paths ["test/cljx"]
                                    :output-path "target/classes"
                                    :rules :cljs}]}
                   :hooks [cljx.hooks]}
             :clj-1.5.1 {:dependencies [[org.clojure/clojure "1.5.1"]]}
             :clj-1.4.0 {:dependencies [[org.clojure/clojure "1.4.0"]]}
             :clj-1.3.0 {:dependencies [[org.clojure/clojure "1.3.0"]]}}
  :cljsbuild {:dev {:source-paths ["src/cljx" "target/classes"]
                    :compiler {:output-to "target/main.js"
                               :optimizations :whitespace
                               :pretty-print true}}
              :test {:source-paths ["test/cljx"
                                    "target/classes"]
                     :compiler {:output-to "target/unit-test.js"
                                :optimizations :whitespace
                                :pretty-print true}}}
  )
