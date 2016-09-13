(ns mtg-cards.prod
  (:require [mtg-cards.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
