select * from orderdetails;

select * from products where productCode = 'S18_1749';

select p.productCode, od.productCode, od.orderNumber, p.productName, od.quantityOrdered, od.priceEach, (od.quantityOrdered * od.priceEach) as totalPrice
from orderdetails od, products p
where od.productCode = p.productCode
order by orderNumber;


-- inclass PM request #1
select c.customerNumber, o.orderNumber, o.orderDate, c.customerName
from 
orders o
left join customers c on  c.customerNumber = o.customerNumber
order by orderNumber;

-- inclass PM reuqest #2
select c.customerNumber, o.orderNumber, o.orderDate, c.customerName, o.status
from 
orders o
left join customers c on  c.customerNumber = o.customerNumber
where o.status like 'In Process'
order by o.orderDate; 

-- payments -> customers -> employees
-- the sales department is analyzing trends for each sales person and they would like to know how much revenue each sales person created each year.
-- they want to see the sales persons first and last name, the year, the total amount in payments, as well as the total number payments.and
select  
-- first, last, year, total amt paid, number of payments
	 e.firstName
    ,e.lastName
    ,year(p.paymentDate) 	as 'Year'
    ,sum(p.amount) 			as 'Total Paid'
    ,count(p.checkNumber)	as '# of Payments'
from
	employees e
	left join customers c on c.salesRepEmployeeNumber = e.employeeNumber
	left join payments p on c.customerNumber = p.customerNumber
group by 
	e.employeeNumber;

-- Question 3
-- the sales department also wants to know which items each sales person has sold.  They would like to see the item name, the item number, the sales person's first
-- and last name. There can be no duplicates and orderd by the sales persons last name alphabetially

select  
	 e.firstName as 'First Name'
    ,e.lastName as 'Last Name'
    ,p.productName as 'Product Name'
    ,p.productCode as  'Product Code'
    ,count(p.productName) as ItemsSold
from
    orderdetails od
    left join products p on p.productCode = od.productCode -- item name 
	left join orders o  on od.orderNumber = o.orderNumber -- need this to get to customer
	left join customers c on o.customerNumber = c.customerNumber -- need this to get to employees
	left join employees e on c.salesRepEmployeeNumber = e.employeeNumber -- emp first last
group by 
	 p.productCode
    ,e.employeeNumber
order by e.lastName;











