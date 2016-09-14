(ns mtg-cards.common)

(defn replace-several [content & replacements]
  (let [replacement-list (partition 2 replacements)]
    (reduce #(apply clojure.string/replace %1 %2) content replacement-list)))

(defn render-mana-icons [text]
  (if text
    (replace-several text
                     "{U}" "<img class=\"mana-icon\" src=\"/images/blue.png\">"
                     "{R}" "<img class=\"mana-icon\" src=\"/images/red.png\">"
                     "{W}" "<img class=\"mana-icon\" src=\"/images/white.png\">"
                     "{G}" "<img class=\"mana-icon\" src=\"/images/green.png\">"
                     "{B}" "<img class=\"mana-icon\" src=\"/images/black.png\">"
                     "{T}" "<img class=\"mana-icon\" src=\"/images/tap.png\">"
                     "{" ""
                     "}" "")))
