-- Homework 
-- 1) The sales manager wants to see all orders that have an average price that is greater than $50
-- you do not need to include the quantity ordered in the average price calculation
-- the manager wants to see the order number, and the average price rounded to 2 decimal places
-- HINT - this will use a HAVING part of the SQL

SELECT 
	 orderNumber
    ,Round(AVG(priceEach),50) AS totalAvgPrice
FROM orderdetails
GROUP BY orderNumber
HAVING totalAvgPrice > 50;


-- 2) Do the same report above, however use the average of (quantity ordered * the price) and 
-- show orders with an average price greater than $500.   Format the report the same way

SELECT 
	 orderNumber
    ,Round(AVG(quantityOrdered * priceEach),2) AS totalAvgPrice
FROM orderdetails
GROUP BY orderNumber
HAVING Round(AVG(quantityOrdered * priceEach),2) > 500;


-- 3) Using the query above in #2, show the first and last name of each employee that goes with the order and the average price
-- of (quantity ordered * the price).   Also, include the total number of items ordered.  use a left join
-- no nulls
SELECT 
	 od.orderNumber
	,e.firstName
    ,e.lastName
    ,AVG(quantityOrdered * priceEach) AS totalAvgPrice
    ,sum(quantityOrdered) AS totalQtyOrded
FROM 
	orderdetails od
	LEFT JOIN orders o on o.orderNumber = od.orderNumber
	LEFT JOIN customers c on c.customerNumber = o.customerNumber
	LEFT JOIN employees e on c.salesRepEmployeeNumber = e.employeeNumber
GROUP BY orderNumber
Having totalAvgPrice > 500;

-- nulls
SELECT 
	 od.orderNumber
	,e.firstName
    ,e.lastName
    ,IFNULL(AVG(quantityOrdered * priceEach),0) AS totalAvgPrice
    ,sum(quantityOrdered) AS totalQtyOrded
FROM 
    employees e 
    LEFT JOIN customers c on c.salesRepEmployeeNumber = e.employeeNumber
	LEFT JOIN orders o on c.customerNumber = o.customerNumber
    LEFT JOIN orderdetails od on o.orderNumber = od.orderNumber
GROUP BY orderNumber, e.employeeNumber
Having totalAvgPrice = 0 or totalAvgPrice > 500;


-- 4) Use a case statement to show the margin (MSRP - buyPrice) of the products.  We want to assign a rating to the margin.
-- if the margin is greater than 80 then output excelent, if greater or equal to 50 output good, if less than 50 output poor
-- report should include the product name, MSRP, buyPrice, margin, and rating.
-- HINT - research how to use a MySQL case statement

SELECT 
	 productName
    ,MSRP
    ,buyPrice
	,((MSRP - buyPrice)/MSRP) AS margin
    ,CASE 
		WHEN ((MSRP - buyPrice)/MSRP) > .80 THEN 'excelent'
        WHEN ((MSRP - buyPrice)/MSRP) between .50 and .79 THEN 'good'
        WHEN ((MSRP - buyPrice)/MSRP) < .50 THEN 'poor' end AS rating
FROM 
	products;


select * from orders;
select * from orderdetails;
select * from customers;
select * from employees;
select * from products;


-- 5) Do problem #4, #9, #12 on page https://www.w3resource.com/sql-exercises/sql-subqueries-exercises.php
-- #25 is really a great example of an SBA question
-- 4
SELECT 
	 employee_id
    ,first_name 
    ,last_name  
FROM employees  
WHERE 
	salary >  ( SELECT AVG(salary)  FROM employees );

-- 9
SELECT 
	* 
FROM 
	employees 
WHERE 
	salary BETWEEN 1000 and 3000;
    
-- 12
SELECT 
	* 
FROM 
	employees 
WHERE 
	employee_id IN (
		SELECT 
			employee_id 
		FROM 
			employees 
		WHERE 
			salary = (SELECT MAX(salary) FROM employees WHERE salary < (SELECT MAX(salary) FROM employees)));

-- 6) Do #6 on https://www.w3resource.com/sql-exercises/union/sql-union.php

SELECT 
	 salesman.salesman_id
    ,name
    ,cust_name
    ,commission
FROM 
	salesman, customer
WHERE salesman.city = customer.city
UNION
(SELECT salesman_id, name, 'NO MATCH', commission
FROM salesman
WHERE NOT city = ANY
	(SELECT city
        FROM customer))
ORDER BY 2 DESC


-- 7) aditional exercises - https://www.hackerrank.com/challenges/harry-potter-and-wands/problem
-- focus on using left join and also left join as a subquery