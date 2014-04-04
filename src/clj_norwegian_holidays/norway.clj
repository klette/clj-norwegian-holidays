(ns clj-norwegian-holidays.norway
  (:require [clj-norwegian-holidays.easter :as easter],
            [clj-time.core :as t]))

(defn public-holiday? [year month date]
  (let [
         es (easter/calculate-easter-for-year year)
         lt (t/local-date year month date)
         dt (t/local-date year (:month es) (:date es))
         eas_tue (t/minus dt (t/days 3))
         eas_fri (t/minus dt (t/days 2))
         eas_min (t/plus dt (t/days 1))
         ascencion (t/plus dt (t/days 39))
         pentecost (t/plus dt (t/weeks 7))
         pentecost_2 (t/plus pentecost (t/days 1))
         ]
    (cond
      (and (= month 12) (or (= date 25) (= date 26))) true
      (and (= month 1) (or (= date 1) (= date 26))) true
      (and (= month 5) (or (= date 1) (= date 17))) true
      (and (= month 5) (or (= date 1) (= date 17))) true
      (some #{lt} [dt eas_tue eas_fri es eas_min ascencion pentecost pentecost_2]) true
      :else false)))
