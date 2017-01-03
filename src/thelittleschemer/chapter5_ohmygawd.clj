(ns thelittleschemer.chapter5-ohmygawd
  (:require [thelittleschemer.chapter1-toys :as toys]))

; Define not_
(def not_
  (fn [b]
    (cond
      b false
      true true)))

; Define non-atom?
(def non-atom?
  (fn [s]
    (not_ (toys/atom? s))))

; Define left
(def left
  (fn [l]
    (println "(left " l)
    (println (non-atom? l))
    (cond
      (toys/null? l) '()
      (non-atom? (first l)) (left (first l))
      true (first l))))

; Define rember*
(def rember*
  (fn [a l]
    (cond
      (toys/null? l) '()
      (non-atom? (first l))
      (cons (rember* a (first l))
            (rember* a (rest l)))
      true (cond
             (= (first l) a) (rember* a (rest l))
             true (cons (first l) (rember* a (rest l)))))))

; Define insertR*
(def insertR*
  (fn [new old l]
    (cond
      (toys/null? l) '()
      (non-atom? (first l))
      (cons (insertR* new old (first l))
            (insertR* new old (rest l)))
      true (cond
             (= (first l) old) (cons old (cons new (insertR* new old (rest l))))
             true (cons (first l) (insertR* new old (rest l)))))))

; Define occur*
(def occur*
  (fn [a l]
    (cond
      (null? l) 0
      (non-atom? (first l)) (+_ (occur* a (first l)) (occur* a (rest l)))
      true (cond
             (= (first l) a) (add1 (occur* a (rest l)))
             true (occur* a (rest l))))))

; Define subst*
(def subst*
  (fn [new old l]
    (cond
      (null? l) '()
      (non-atom? (first l)) (cons (subst* new old (first l)) (subst* new old (rest l)))
      true (cond
             (= (first l) old) (cons new (subst* new old (rest l)))
             true (cons (first l) (subst* new old (rest l)))))))

; Define insertL*
(def insertL*
  (fn [new old l]
    (cond
      (null? l) '()
      (non-atom? (first l))
      (cons
        (insertL* new old (first l))
        (insertL* new old (rest l)))
      true (cond
             (= (first l) old)
             (cons new
                   (cons old
                         (insertL*
                           new old (rest l))))
             true (cons (first l)
                        (insertL*
                          new old (rest l)))))))

; Define member*
(def member*
  (fn [a l]
    (cond
      (null? l) '()
      (atom? (first l))
      (or
        (= (first l) a)
        (member* a (rest l)))
      true (or
             (member* a (first l))
             (member* a (rest l))))))

; Define eqlist?
(def eqlist?
  (fn [l1 l2]
    (cond
      (and (null? l1) (null? l2)) true
      (or (null? l1) (null? l2)) false
      (and (non-atom? (first l1)) (non-atom? (first l2)))
      (and (eqlist? (first l1) (first l2))
           (eqlist? (rest l1) (rest l2)))
      (or (non-atom? (first l1)) (non-atom? (first l2))) false
      true (and
             (eqan? (first l1) (first l2))
             (eqlist? (rest l1) (rest l2))))))

; Define insertL*
(def insertL*
  (fn [new old l]
    (cond
      (null? l) '()
      (non-atom? (first l))
      (cons
        (insertL* new old (first l))
        (insertL* new old (rest l)))
      (= (first l) old)
      (cons new
            (cons old
                  (insertL*
                    new old (rest l))))
      true (cons (first l)
                 (insertL*
                   new old (rest l))))))

