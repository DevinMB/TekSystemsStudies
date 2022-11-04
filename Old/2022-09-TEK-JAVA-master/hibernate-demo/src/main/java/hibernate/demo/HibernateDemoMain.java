package hibernate.demo;

import java.util.Date;
import java.util.List;

import hibernate.demo.dao.CustomerDAO;
import hibernate.demo.dao.EmployeeDAO;
import hibernate.demo.dao.OrderDAO;
import hibernate.demo.entity.Customer;
import hibernate.demo.entity.Employee;
import hibernate.demo.entity.Order;

public class HibernateDemoMain {

	public static void main(String[] args) {
		// this represents my business logic
		OrderDAO orderDao = new OrderDAO();
		
		System.out.println("------------------ single row -------------------------");
		
		Order x = orderDao.findByOrderNumber(10100);
		
		System.out.println("------------------ update row -------------------------");
			
		System.out.println(x.toString());
		
		x.setStatus("PENDING");
		x.setShippedDate(new Date());
		
		orderDao.update(x);
		
		System.out.println("------------------ query multiple rows -------------------------");
		
		List<Order> orders = orderDao.findByStatus("Cancelled");
		for ( Order order : orders ) {
			System.out.println(order);
		}
		
		System.out.println("------------------ insert -------------------------");
		
		Order newOrder = new Order();
		
		newOrder.setOrderNumber(1010000);
		newOrder.setOrderDate(new Date());
		newOrder.setRequiredDate(new Date());
		//newOrder.setShippedDate(new Date());
		newOrder.setStatus("WHATEVER");
		newOrder.setComments("Some comments about the order");
		newOrder.setCustomerNumber(103);
		
		//orderDao.insert(newOrder);
		
		System.out.println("********************* customer query with employee object returned *********************");
		
		CustomerDAO customerDao = new CustomerDAO();
		
		Customer customer = customerDao.findByCustomerId(114);
		
		System.out.println("customer number = " + customer.getId());
		Employee salesRep=  customer.getSalesRep();
		System.out.println("employee (sales rep) first name = " + salesRep.getFirstName());
		
		System.out.println("********************* query employee with a list of customers *********************");
		
		EmployeeDAO employeeDao = new EmployeeDAO();
		
		Employee e = employeeDao.findByEmployeeId(1165);
		System.out.println("employee number = " + e.getEmployeeNumber() + " first name = " + e.getFirstName());
		
		
		// this is the same as doing this query
		// select c.* from employees e, customers c where
		// e.employeeNumber = c.salesRepEmployeeNumber
		// and e.employeeNumber = 1165;	
		// you could do this same query in the customer dao w
		for( Customer c : e.getCustomers() ) {
			System.out.println("c.customerNumber = " + c.getId() + 
					" | name = " + c.getFirstName() + " | last name = " + 
					c.getLastName() + " sales rep  | " +
					c.getSalesRep().getFirstName() );
		}
		
		
		System.out.println("========================== below here is bonus =========================================");
		
		
		Employee emp = employeeDao.findByCustomerNumber(112);
		System.out.println(emp.getEmployeeNumber());
		
 	}
}
