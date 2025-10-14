/* Write your PL/SQL query statement below */

-- consecutive Numbers 

-- Solution 1: Self-Join

SELECT DISTINCT l1.num AS ConsecutiveNums
  FROM logs l1
  JOIN logs l2 ON l2.id = l1.id + 1 AND l2.num = l1.num
  JOIN logs l3 ON l3.id = l2.id + 1 AND l3.num = l2.num;


--   Solution 2: Lead-lag

SELECT DISTINCT lo.num ConsecutiveNums
    FROM (SELECT l.num, 
    lead(num) OVER (ORDER BY id) lead_num,
    lag(num) OVER (ORDER BY id) lag_num
    FROM logs l) lo
    WHERE lo.num = lo.lead_num
            AND
        lo.num = lo.lag_num;