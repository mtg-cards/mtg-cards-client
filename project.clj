(defproject mtg-cards "0.1.0-SNAPSHOT"
  :description "Magic the Gathering card search front-end"
  :url "http://mtg.arturgajewski.com"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.8.0"]
                 [ring-server "0.4.0"]
                 [reagent "0.6.0-rc"]
                 [reagent-forms "0.5.25"]
                 [reagent-utils "0.2.0"]
                 [ring "1.5.0"]
                 [ring/ring-defaults "0.2.1"]
                 [compojure "1.5.1"]
                 [hiccup "1.0.5"]
                 [cljs-uuid "0.0.4"]
                 [yogthos/config "0.8"]
                 [org.clojure/clojurescript "1.9.216"
                  :scope "provided"]
                 [secretary "1.2.3"]
                 [cljs-http "0.1.39"]
                 [venantius/accountant "0.1.7"
                  :exclusions [org.clojure/tools.reader]]]

  :plugins [[lein-environ "1.0.2"]
            [lein-cljsbuild "1.1.1"]
            [lein-asset-minifier "0.2.7"
             :exclusions [org.clojure/clojure]]]

  :ring {:handler mtg-cards.handler/app
         :uberwar-name "mtg-cards.war"}

  :min-lein-version "2.5.0"

  :uberjar-name "mtg-cards.jar"

  :main mtg-cards.server

  :clean-targets ^{:protect false}
  [:target-path
   [:cljsbuild :builds :app :compiler :output-dir]
   [:cljsbuild :builds :app :compiler :output-to]]

  :source-paths ["src/clj"]
  :resource-paths ["resources" "target/cljsbuild"]

  :minify-assets
  {:assets
   {"resources/public/css/site.min.css" "resources/public/css/site.css"}}

  :cljsbuild
  {:builds {:min
            {:source-paths ["src/cljs" "env/prod/cljs"]
             :compiler
             {:output-to "target/cljsbuild/public/js/app.js"
              :output-dir "target/uberjar"
              :optimizations :advanced
              :pretty-print  false}}
            :app
            {:source-paths ["src/cljs" "env/dev/cljs"]
             :compiler
             {:main "mtg-cards.dev"
              :asset-path "/js/out"
              :output-to "target/cljsbuild/public/js/app.js"
              :output-dir "target/cljsbuild/public/js/out"
              :source-map true
              :optimizations :none
              :pretty-print  true}}}}

  :figwheel
  {:http-server-root "public"
   :server-port 3450
   :nrepl-port 7002
   :nrepl-middleware ["cemerick.piggieback/wrap-cljs-repl"
                      ]
   :css-dirs ["resources/public/css"]
   :ring-handler mtg-cards.handler/app}

  :profiles {:dev {:repl-options {:init-ns mtg-cards.repl}

                   :dependencies [[ring/ring-mock "0.3.0"]
                                  [ring/ring-devel "1.5.0"]
                                  [prone "1.1.1"]
                                  [figwheel-sidecar "0.5.4-7"]
                                  [org.clojure/tools.nrepl "0.2.12"]
                                  [com.cemerick/piggieback "0.2.2-SNAPSHOT"]
                                  [pjstadig/humane-test-output "0.8.1"]
                                  ]

                   :source-paths ["env/dev/clj"]
                   :plugins [[lein-figwheel "0.5.4-7"]]

                   :injections [(require 'pjstadig.humane-test-output)
                                (pjstadig.humane-test-output/activate!)]

                   :env {:dev true}}

             :uberjar {:hooks [minify-assets.plugin/hooks]
                       :source-paths ["env/prod/clj"]
                       :prep-tasks ["compile" ["cljsbuild" "once" "min"]]
                       :env {:production true}
                       :aot :all
                       :omit-source true}})
