# Write your MySQL query statement below
select * from cinema 
where id%2=1
AND description !="boring"
Order By rating desc;