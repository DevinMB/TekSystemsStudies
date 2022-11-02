package jpa.service;

import jpa.dao.StudentDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.TypedQuery;
import java.util.List;

public class StudentService implements StudentDAO {
    //TODO finish all methods

    @Override
    public Student getStudentByEmail(String email) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        String hql = "FROM Student s WHERE s.sEmail = :id";
        TypedQuery<Student> query = session.createQuery(hql, Student.class);
        query.setParameter("id", email);

        Student result = query.getSingleResult();

        t.commit();
        factory.close();
        session.close();

        return result;
    }

    @Override
    public List<Student> getAllStudents() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        String hql = "FROM Student s";
        TypedQuery<Student> query = session.createQuery(hql);

        List<Student> result = query.getResultList();

        t.commit();
        factory.close();
        session.close();

        return result;
    }

    @Override
    public boolean validateStudent(String sEmail, String sPassword) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        String hql = "FROM Student s WHERE s.sEmail = :email AND s.sPass = :pass";
        TypedQuery<Student> query = session.createQuery(hql,Student.class);
        query.setParameter("email",  sEmail);
        query.setParameter("pass", sPassword);

        Student result = new Student();
        boolean success = false;

        try {
            result = query.getSingleResult();
            success = true;
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        t.commit();
        factory.close();
        session.close();

        return success;
    }

    @Override
    public void registerStudentToCourse(String sEmail, int cId) {


    }

    @Override
    public List<Course> getStudentCourses(String sEmail) {
        Student requestedStudent = getStudentByEmail(sEmail);
        return requestedStudent.getSCourses();
    }

}
