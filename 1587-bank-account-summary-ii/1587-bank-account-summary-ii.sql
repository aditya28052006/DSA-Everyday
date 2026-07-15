# Write your MySQL query statement below
select u.name as Name,SUM(e.amount) AS balance from users u
join transactions e
on u.account=e.account
group by e.account
having sum(e.amount)>10000;