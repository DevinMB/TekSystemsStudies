package com.DMB.controller;

import com.DMB.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class FindingUser {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SessionFactory factory = new    Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Integer USER_ID = 3;

        User u = session.load(User.class, USER_ID);
        System.out.println("FullName: " + u.getFullname());
        System.out.println("Email: " + u.getEmail());
        System.out.println("password: " + u.getPassword());

        //Close resources
        tx.commit();
        factory.close();
        session.close();
    }
}
