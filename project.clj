(defproject w33tmaricich "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :main helloworld.core
  :plugins [[lein-cljsbuild "1.0.6"]
            [lein-figwheel "0.3.7"]]
  :cljsbuild {:builds [{:id "dev"
                        :source-paths ["src"]
                        :figwheel true
                        :compiler {:optimizations :none
                                   :output-to "resources/public/javascripts/dev.js"
                                   :output-dir "resources/public/javascripts/cljs-dev/"
                                   :pretty-print true
                                   :source-map true}}
                       {:id "prod"
                        :source-paths ["src"]
                        :figwheel false
                        :compiler {:optimizations :advanced
                                   :output-to "resources/public/javascripts/dev.js"
                                   :output-dir "resources/public/javascripts/cljs-prod/"
                                   :pretty-print false
                                   :source-map false}}]}
  :figwheel {:css-dirs ["resources/public/css"]} 
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "0.0-3308"]
                 [reagent "0.5.0"]
                 [com.andrewmcveigh/cljs-time "0.4.0"]
                 [org.clojure/core.async "0.1.346.0-17112a-alpha"]])
