package jpa.dao;

import jpa.entitymodels.Course;

import java.util.List;

public interface CourseDAO {

    /**
     * pulls all courses from the database
     * @return a list of ALL courses
     */
    List<Course> getAllCourses();



}
