(ns clj-norwegian-holidays.easter
  (:require [clojure.math.numeric-tower :as math]))

(defn calculate-easter-for-year [year]
  "Calculates and returns the date of easter for the given year."
  (let [a (mod year 19)
        century (/ year 100)
        c (mod year 100)
        d (math/round (/ century 4))
        e (mod century 4)
        f (math/floor (/ (+ century 8) 25))
        g (math/floor (/ (+ 1 (- century f)) 3))
        h (mod (+ (- (+ (* 19 a) century) d g) 15) 30)
        i (math/floor (/ c 4))
        k (mod c 4)
        l (mod (- (+ 32 (* 2 e) (* 2 i)) h k) 7)
        m (math/floor (/ (+ a (* 11 h) (* 22 l)) 451))
        month (/ (+ (- (+ h l) (* 7 m)) 114) 31)
        date (+ (mod (+ (- (+ h l) (* 7 m)) 114) 31) 1)]
    {:month (math/floor month)
     :date (math/floor date)}))