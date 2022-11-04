package hibernate.demo.dao;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Customer;
import hibernate.demo.entity.Order;

public class CustomerDAO {

	// this is the meachanics of getting a record from the database
	public Customer findByCustomerId( Integer id ) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		String hql = "FROM Customer c where c.id = :custId";
	 	
		TypedQuery<Customer> query = session.createQuery(hql, Customer.class);
	 	query.setParameter("custId", id);
	 	
	 	Customer result = query.getSingleResult();

		t.commit();
		factory.close();
		session.close();
		
		return result;
	}
	
	// 1) create a new maven project named database-homework
	// 2) 
	
}
