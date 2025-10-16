
-- 182 Duplicate Emails

-- using group by 
select email from person group by email having count(*) >1;

--using distinct 

select distinct p1.email from Person p1, person p2 where p1.id<>p2.id AND p1.email = p2.email;