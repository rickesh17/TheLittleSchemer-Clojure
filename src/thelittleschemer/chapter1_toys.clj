(ns thelittleschemer.chapter1-toys)

; Defining an atom
(defn atom?
  (fn [x]
    (not (seq? x))))

; Lists are already defined in Clojure. Remember to use '(x y z) as your list
; If you just used (x y z) the you would calling x as a function and y,z as it's arguments
'(a b c)

; The equivalent of "car" is the function "first"
(first '(x y z))
; Output: x

; The equivalent of "cdr" is the function "rest"
(rest '(x y z))
; Output: (y z)

; "cons" has the same functionality
(cons "a" ())
; Output: ("a")

; Defining null?
(def null?
  (fn [a]
    (or
      (nil? a)
      (= () a))))

; The equivalent of "eq?" is the function "="
(= 1 (- 2 1))
; Output: true
(= (str "hello") (str "hel" "lo"))
; Output: true
(= 5 (+ 1 5))
; Output: false