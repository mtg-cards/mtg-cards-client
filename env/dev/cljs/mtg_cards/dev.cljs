(ns ^:figwheel-no-load mtg-cards.dev
  (:require [mtg-cards.core :as core]
            [figwheel.client :as figwheel :include-macros true]))

(enable-console-print!)

(figwheel/watch-and-reload
  :websocket-url "ws://localhost:3450/figwheel-ws"
  :jsload-callback core/mount-root)

(core/init!)