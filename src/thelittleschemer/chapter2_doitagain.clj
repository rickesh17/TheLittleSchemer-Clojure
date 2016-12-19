(ns thelittleschemer.chapter2-doitagain
  (:require [thelittleschemer.chapter1-toys :as toys]))

;; Define a lat?
(def lat?
  (fn [l]
    (cond
      (toys/null? l) true
      (and (seq? l)
           (toys/atom? (first l))) (lat? (rest l))
      true false)))

;; Define member?
(def member?
  (fn [a lat]
    (cond
      (toys/null? lat) false
      true (or
             (= (first lat) a)
             (member? a (rest lat))))))

;; Examples: (run in REPL)
(lat? '(Jack Sprat could eat no chicken fat))
(lat? '(bacon and eggs))
(lat? '(bacon (and eggs)))
(member? "tea" '("coffee" "and" "tea"))
(member? "meat" '("mashed" "potatoes" "and" "meat" "gravy"))
(member? "liver" '("bagels" "and" "lox"))
