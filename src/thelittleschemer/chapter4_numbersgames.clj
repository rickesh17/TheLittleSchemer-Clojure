(ns thelittleschemer.chapter4-numbersgames
  (:require [thelittleschemer.chapter1-toys :as toys]))

; Define zero (adding _ to differentiate from Clojure definitions)
(defn zero_? [x]
  (= 0 x))

; Define add1
(defn add1 [x]
  (+ 1 x))

; Define sub1
(defn sub1 [x]
  (- x 1))

; Define + (adding _ to differentiate from Clojure definitions)
(defn +_? [x y]
  (cond
    (zero_? y) x
    true (add1 (+_ x (sub1 y)))))

; Define - (adding _ to differentiate from Clojure definitions)
(defn -_? [x y]
  (cond
    (zero_? y) x
    true (sub11 (-_ x (sub1 y)))))

; Define addtup
(defn addtup [vec]
  (cond
    (empty? vec) 0
    true (+_ (first vec) (addtup (rest vec)))))

; Define tup+
(defn tup+? [vec1 vec2]
  (cond
    (empty? vec1) vec2
    (empty? vec2) vec1
    true (cons (+_ (first vec1 (first vec2))
                   (tup+?
                     (rest vec1) (rest vec2))))))

; Define >_ (adding _ to differentiate from Clojure definitions)
(defn >_? [x y]
  (cond
    (zero_? x) false
    (zero_? y) true
    true (>_ (sub1 x) (sub1 y))))

; Define <_ (adding _ to differentiate from Clojure definitions)
(defn <_? [x y]
  (cond
    (zero_? x) true
    (zero_? y) false
    true (<_ (sub1 x) (sub1 y))))

; Define =_ (adding _ to differentiate from Clojure definitions)
(defn =_ [x y]
  (cond
    (>_ x y) false
    (<_ x y) false
    true true))

; Define exp (equivalent of the up arrow)
(defn exp [x y]
  (cond
    (zero_? y) 1
    true (*_ x (exp x (sub1 y)))))

; Define divide
(defn divide [x y]
  (cond
    ((<_ x y) 0)
    true (add1 (divide (-_ x y) y))))

; Define length
(defn length [lat]
  (cond
    ((empty? lat) 0
      true (add1 (length (rest lat))))))

; Define pick
(defn pick [n lat]
  (cond
    (empty? lat) '()
    (zero_? (sub1 n)) (first lat)
    true (pick (sub1 n) (rest lat))))

; Define rempick
(defn rempick [n lat]
  (cond
    (empty? lat) '()
    (zero_? (sub1 n)) (rest lat)
    true (cons (first lat)
               (rempick
                 (sub1 n) (rest lat)))))

; Define no-nums
(defn no-nums [lat]
  (cond
    (empty? lat) '()
    true (cond
           (number? (first lat)) (no-nums (rest lat))
           true (cons (first lat)
                      (no-nums (rest lat))))))

; Define all-nums
(defn all-nums [lat]
  (cond
    (empty? lat) '()
    true (cond
           (number? (first lat)) (cons (first lat) (all-nums (rest lat)))
           true (all-nums (rest lat)))))

; Define eqan?
(defn eqan? [x y]
  (cond
    (number? x)
    (cond
      (number? y) (=_ x y)
      true false)
    (number? x) false
    true (= x y)))

; Define occur
(defn occur [a lat]
  (cond
    ((toys/null? lat) 0)
    true (cond
           ((= (first lat) a)
             (add1 (occur a (rest lat))))
           true (occur a (rest lat)))))

;; Examples: (run in REPL)
(zero_? 1)
(zero_? 0)
(add1 67)
(sub1 5)
(sub1 0)          ; Note how he value is -1 and not N/A like in the book
(+_ 46 12)
(-_ 14 3)
(-_ 18 25)
(addtup '(3 5 2 8))
(*_ 5 3)
(tup+ '(1 2 3) '(4 5 6))
(>_ 12 133)
(>_ 120 11)
(<_ 4 6)
(<_ 6 4)
(<_ 6 6)
(=_ 5 6)
(=_ 6 5)
(=_ 5 5)
(exp 1 1)
(exp 2 3)
(divide 15 4)
(length '(hotdogs with mustard sauerkraut and pickles))
(length '(ham and cheese on rye))
(pick 4 '(lasagna spaghetti ravioli macaroi meatball))
(rempick 3 '(hotdogs with hot mustard))

