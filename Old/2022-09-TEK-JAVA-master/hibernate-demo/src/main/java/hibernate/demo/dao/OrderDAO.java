package hibernate.demo.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Order;

public class OrderDAO {
	
	// this is the meachanics of getting a record from the database
	public Order findByOrderNumber( Integer orderNumber ) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		String hql = "FROM Order o where o.orderNumber = :orderNo";
	 	
		TypedQuery<Order> query = session.createQuery(hql, Order.class);
	 	query.setParameter("orderNo", orderNumber);
	 	
	 	Order result = query.getSingleResult();

		t.commit();
		factory.close();
		session.close();
		
		return result;
	}
	
	public List<Order> findByStatus( String status ) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		String hql = "FROM Order o where o.status = :stat";
	 	
		TypedQuery<Order> query = session.createQuery(hql, Order.class);
	 	query.setParameter("stat", status);
	 	
	 	// by using getResultList .. it will return a list of Order objects that represent the 
	 	// rows in the database.
	 	List<Order> result = query.getResultList();

		t.commit();
		factory.close();
		session.close();
		
		return result;
	}
	
	public void insert(Order order ) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		session.save(order);

		t.commit();
		factory.close();
		session.close();
	}
	
	
	public void update(Order order ) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		session.merge(order);

		t.commit();
		factory.close();
		session.close();
	}
	
}
