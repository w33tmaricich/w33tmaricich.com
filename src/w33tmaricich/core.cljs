(ns w33tmaricich.core
  (:require [reagent.core :as reagent]
            [w33tmaricich.code :as c]
            [cljs-time.core :as t]))

(def STARTED-DEVELOPING 2012)
(def BORN 1993)
(def PERSON-INFO [{:keyword ":name"
                   :data "\"Alexander Price Maricich\""
                   :type "string"}
                  {:keyword ":age"
                   :data (- (t/year (t/now)) BORN)
                   :type "macro"}
                  {:keyword ":dev-years"
                   :data (- (t/year (t/now)) STARTED-DEVELOPING)
                   :type "macro"}
                  {:keyword ":proficient"
                   :data "#{:c :clojure :clojurescript :java :python}"
                   :type "keyword"}
                  {:keyword ":interests"
                   :data "#{:buddhism :programming :veganism}"
                   :type "keyword"}])

(defn app 
  "Root structure of our ui"
  []
  [:div
    (c/semi "; Copyright Alexander Maricich 2016")
    (c/br)
    (c/semi "; Powered with cljs and reagent")
    (c/br 2)
    (c/semi "; Site definition ----------------------------------")
    (c/br 2)
    (c/ns-require "com.w33tmaricich" [{:import "contact-information"
                                       :as "email"}
                                      {:import "notible.websites"
                                       :as "sites"}])
    (c/br 2)
    (c/semi "; About me -----------------------------------------")
    (c/br 2)
    (c/s-def "person" (c/s-atom PERSON-INFO))
    (c/br 2)
    (c/semi "; Important links ----------------------------------")
    (c/br 2)

    "(" (c/macro "defn") (c/space) "detailed-info" (c/br)
    (c/space 2) (c/st "\"Returns more information relating to the person.\"") (c/br)
    (c/space 2) "[query]" (c/br)
    (c/space 2) "(" (c/kw "case") (c/space) "query" (c/br)
    (c/space 4) (c/kw ":contact") (c/space) (c/s-email "w33tmaricich@gmail.com" "email/personal") (c/space) (c/semi "; e:w33tmaricich@gmail.com p:443.481.7120") (c/br)
    (c/space 4) (c/kw ":github") (c/space) (c/s-a "https://github.com/w33tmaricich" "sites/github") (c/br)
    (c/space 4) (c/kw ":linkedin") (c/space) (c/s-a "https://www.linkedin.com/in/amaricich" "sites/linkedin") (c/br)
    (c/space 4) (c/kw ":personal") (c/space) "{" (c/kw ":family") (c/space) (c/s-a "http://maricich.family" "sites/family") (c/br)
    (c/space 15) (c/kw ":focalframe") (c/space) (c/s-a "http://focalframe.com" "sites/focalframe") (c/br)
    (c/space 15) (c/kw ":w33tmaricich") (c/space) (c/s-a "http://w33tmaricich.com" "sites/w33tmaricich") "}" (c/br)
    (c/space 4) "@person))"])

(reagent/render [app] (js/document.querySelector "#cljs-target"))

