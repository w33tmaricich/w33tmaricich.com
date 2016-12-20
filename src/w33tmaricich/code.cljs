(ns w33tmaricich.code
  (:require [goog.string :as gstring]))

(defn space ([] (space 1))
  ([number]
   (for [n (range number)]
     (gstring/unescapeEntities "&nbsp;"))))

(defn br ([] (br 1))
  ([number]
   (for [n (range number)]
     [:br])))

(defn s-div
  "stylized div tag based on class"
  [c text]
  [:div {:class c} text])

(defn semi
  "This is a stylized comment block"
  [text]
  (s-div "comment" text))

(defn macro
  "This is a stylized marco item"
  [text]
  (s-div "macro" text))

(defn kw
  "This is a stylized keyword item"
  [text]
  (s-div "keyword" text))

(defn st
  "This is a stylized string item"
  [text]
  (s-div "string" text))

(defn special
  "This is a special item"
  [text]
  (s-div "special" text))

(defn ns-require
  "Creates a namespace with reqiured tags"
  [nspace requires]
  (list
   [:div "(" (macro "ns") (space) nspace]
   (br)
   [:div (space 2) "(" (kw ":require")]
   [:div (space) "[" (:import (first requires)) (space) (kw ":as") (space) (:as (first requires)) "]"]
   (for [req (rest requires)]
     [:br (space 12) "[" (:import req) (space) (kw ":as") (space) (:as req) "]"])
   "))"))

(defn s-def
  "stylized def"
  [symb text]
  [:div "(" (special "def") (space) symb (space) text ")"])

(defn s-atom
  "stylized atom"
  [hashmap]
  (list
    [:div "(" (special "atom") (space) "{"]
    (for [item hashmap]
      (if (= (first hashmap) item)
        (list
          (kw (:keyword item)) (space) (s-div (:type item) (:data item)))
        (list
          (br)
          (space 19)
          (kw (:keyword item)) (space) (s-div (:type item) (:data item)))))
    [:div "}"]))

(defn s-a
  "Creates a stylized anchor tag"
  [href text]
  [:a {:href href} text])

(defn s-email
  "Creates a stylized anchor tag"
  [href text]
  [:a {:href (str "mailto:" href)} text])
