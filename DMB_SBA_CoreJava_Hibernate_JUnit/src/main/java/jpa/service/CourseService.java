package jpa.service;

import jpa.dao.CourseDAO;
import jpa.entitymodels.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.TypedQuery;
import java.util.List;

public class CourseService implements CourseDAO {

    @Override
    public List<Course> getAllCourses() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        String hql = "FROM Course c";
        TypedQuery<Course> query = session.createQuery(hql);

        List<Course> result = query.getResultList();

        t.commit();
        factory.close();
        session.close();

        return result;
    }

    public Course getCourseById(Integer id){
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        String hql = "FROM Course c WHERE c.cId = :id";
        TypedQuery<Course> query = session.createQuery(hql, Course.class);
        query.setParameter("id", id);

        Course result = query.getSingleResult();

        t.commit();
        factory.close();
        session.close();

        return result;

    }

}
