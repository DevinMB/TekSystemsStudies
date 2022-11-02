package jpa.dao;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

import java.util.List;

public interface StudentDAO {

    /**
     * pulls all students from the database
     * @return a list of ALL students
     */
    List<Student> getAllStudents();

    /**
     * pulls a requested student from the database including a list of courses
     * @param email of requested student
     * @return the requested student object
     */
    Student getStudentByEmail(String email);

    /**
     * validates the student credentials to the database
     * @param sEmail email of student to validate existence
     * @param sPassword password of student to validate existence
     * @return a boolean true if exists and false if combination is invalid or does not exist
     */
    boolean validateStudent(String sEmail, String sPassword);

    /**
     * adds a course to the requested student in the database
     * @param sEmail students email
     * @param cId course's id
     */
    void registerStudentToCourse(String sEmail, int cId);

    /**
     * gets the students courses from the database
     * @param sEmail students email
     * @return a list of courses for the requested student
     */
    List<Course> getStudentCourses(String sEmail);

}
