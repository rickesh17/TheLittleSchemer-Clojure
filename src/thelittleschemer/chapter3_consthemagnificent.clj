(ns thelittleschemer.chapter3-consthemagnificent
  (:require [thelittleschemer.chapter1-toys :as toys]))

;; Define rember
(def rember
  (fn [ a lat]
    (cond
      (toys/null? lat) '()
      true (cond
             (= (first lat) a) (rest lat)
             true (cons (first lat)
                        (rember
                          a (rest lat)))))))

;; Define firsts
(def firsts
  (fn [l]
    (cond
      (toys/null? l) '()
      true (cons (first (first l))
                 (firsts (rest l))))))

;; Examples: (run in REPL)
(rember "mint" '("lamb" "chops" "and" "jelly"))
(rember "mint" '("lamb" "chops" "and" "mint" "flavoured" "jelly"))
(rember "cup" '("coffee" "cup" "tea" "cup" "and" "hick" "cup"))
(firsts '((a b) (c d) (e f)))
(firsts '((five plums) (four) (eleven green oranges)))