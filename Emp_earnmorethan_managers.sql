SELECT e.name as Employee 
from Employee e 
INNER JOIN Employee m 
ON 
    e.managerId = m.id
Where e.salary > m.salary;

