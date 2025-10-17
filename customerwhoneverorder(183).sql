select e.name as Customers e left join  Orders m 
on e.id = m.customerId where e.customerId is null;