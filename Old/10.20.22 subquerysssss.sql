



SELECT * FROM products WHERE productCode in (select productCode from orders where status = 'Shipped');

select * from orderdetails;
select * from products;

-- per order
-- all products that have the largest qty in each order. show product name, order number and quantity ordered
-- order


-- largest qty by product


-- bad because it only gives you one row for each order, some orders have the same amount
select 
	orderNumber
	,( select productCode from orderdetails where orderNumber = o.orderNumber order by quantityOrdered desc	limit 1	) AS largestOrderedProductCode
    ,( select quantityOrdered from orderdetails	where orderNumber = o.orderNumber order by quantityOrdered desc	limit 1	) AS maxQuantity
    ,p.productName
from orders o
left join products p on p.productCode = (
	select 
		productCode
	from 
		orderdetails 
	where orderNumber = o.orderNumber
	order by quantityOrdered desc
	limit 1
	)
-- where orderNumber = 10401
order by 1;

-- good!! very good!
select od.ordernumber, p.productName, od.quantityOrdered
from products p 
left join orderDetails od on od.productCode = p.productCode
where od.quantityOrdered = (select max(quantityOrdered) from orderDetails where od.orderNumber =  orderNumber)
order by 1;
























