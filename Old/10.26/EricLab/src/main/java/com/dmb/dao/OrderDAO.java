package com.dmb.dao;

import com.dmb.model.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.TypedQuery;
import java.util.List;

public class OrderDAO {

    public Order findByOrderNumber(Integer orderNumber){

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        String hql = "FROM Order o where o.orderNumber = :orderNumber";
        TypedQuery<Order> query = session.createQuery(hql, Order.class);
        query.setParameter("orderNumber", orderNumber);

        Order result = query.getSingleResult();

        return result;
    }

    public List<Order> findByStatus(String status){

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        String hql = "FROM Order o where o.status = :status";
        TypedQuery<Order> query = session.createQuery(hql, Order.class);
        query.setParameter("status", status);

        List<Order> results = query.getResultList();

        return results;
    }


    public void save(Order order){

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        Transaction t = session.beginTransaction();

        session.merge(order);

        t.commit();
        factory.close();
        session.close();

    }

}
