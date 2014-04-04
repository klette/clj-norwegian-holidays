(ns clj-norwegian-holidays.norway_test
  (:require [clojure.test :refer :all]
            [clj-norwegian-holidays.norway :refer :all]))


(deftest test-calculation-of-easter-sundays
  (testing "norwegian public holidays"
    (is (= (public-holiday? 2014 12 24) false))
    (is (= (public-holiday? 2014 12 25) true))
    (is (= (public-holiday? 2014 12 26) true))
    (is (= (public-holiday? 2014 12 27) false))
    (is (= (public-holiday? 2014 1 1) true))
    (is (= (public-holiday? 2014 4 17) true))
    (is (= (public-holiday? 2014 4 18) true))
    (is (= (public-holiday? 2014 4 20) true))
    (is (= (public-holiday? 2014 4 21) true))
    (is (= (public-holiday? 2014 5 1) true))
    (is (= (public-holiday? 2014 6 8) true))
    (is (= (public-holiday? 2014 6 9) true))
   ))

"
SELECT ok(is_non_work_day('2013-01-01'), '2013 - Første nyttårsdag');
SELECT ok(is_non_work_day('2013-03-28'), '2013 - Skjærtorsdag');
SELECT ok(is_non_work_day('2013-03-29'), '2013 - Langfredag');
SELECT ok(is_non_work_day('2013-03-31'), '2013 - Første påskedag');
SELECT ok(is_non_work_day('2013-04-01'), '2013 - Andre påskedag');
SELECT ok(is_non_work_day('2013-05-01'), '2013 - Arbeidernes dag');
SELECT ok(is_non_work_day('2013-05-09'), '2013 - Kristi Himmelfartsdag');
SELECT ok(is_non_work_day('2013-05-17'), '2013 - Grunnlovsdagen');
SELECT ok(is_non_work_day('2013-05-20'), '2013 - Annen pinsedag');
SELECT ok(is_non_work_day('2013-12-25'), '2013 - Første juledag');
SELECT ok(is_non_work_day('2013-12-26'), '2013 - Andre juledag');

SELECT ok(is_non_work_day('2014-01-01'), '2014 - Første nyttårsdag');
SELECT ok(is_non_work_day('2014-04-17'), '2014 - Skjærtorsdag');
SELECT ok(is_non_work_day('2014-04-18'), '2014 - Langfredag');
SELECT ok(is_non_work_day('2014-04-20'), '2014 - Første påskedag');
SELECT ok(is_non_work_day('2014-04-21'), '2014 - Første påskedag');
SELECT ok(is_non_work_day('2014-05-01'), '2014 - Arbeidernes dag');
SELECT ok(is_non_work_day('2014-05-29'), '2014 - Kristi Himmelfartsdag');
SELECT ok(is_non_work_day('2014-05-17'), '2014 - Grunnlovsdagen');
SELECT ok(is_non_work_day('2014-06-08'), '2014 - Annen pinsedag');
SELECT ok(is_non_work_day('2014-06-09'), '2014 - Annen pinsedag');
SELECT ok(is_non_work_day('2014-12-25'), '2014 - Første juledag');
SELECT ok(is_non_work_day('2014-12-26'), '2014 - Andre juledag');
"