-- 175. Combine Two Tables
-- # Write your oracle query statement below

select e.firstName , e.lastName , f.city, f.state
from Person e join Address f
on e.personId = f.personId ;
