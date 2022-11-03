package jpa.service;


import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

public class StudentServiceTest {

    //TODO:Not sure how to do an insert test without messing up database

    @ParameterizedTest()
    @CsvFileSource(resources = {"/testdata/student.csv"}, delimiter = ',', numLinesToSkip = 1)
    protected void getStudentByIdTest(String email, String name, String password) {
        Student expectedStudent = new Student();
        expectedStudent.setSEmail(email);
        expectedStudent.setSName(name);
        expectedStudent.setSPass(password);

        StudentService studentService = new StudentService();

        Student testStudent = studentService.getStudentByEmail(email);

        Assertions.assertEquals(expectedStudent, testStudent);
    }

    @ParameterizedTest()
    @CsvFileSource(resources = {"/testdata/student.csv"}, delimiter = ',', numLinesToSkip = 1)
    protected void getAllStudentsTest(String email, String name, String password) {

        Student expectedStudent = new Student();
        expectedStudent.setSEmail(email);
        expectedStudent.setSName(name);
        expectedStudent.setSPass(password);

        StudentService studentService = new StudentService();

        List<Student> testStudents = studentService.getAllStudents();

        Student testStudent = new Student();

        for (Student s : testStudents) {
            if (s.getSEmail().equals(expectedStudent.getSEmail())) {
                testStudent = s;
            }
        }
        Assertions.assertEquals(expectedStudent, testStudent);
    }


    @ParameterizedTest()
    @CsvFileSource(resources = {"/testdata/student.csv"}, delimiter = ',', numLinesToSkip = 1)
    protected void validateStudentTest(String email, String name, String password) {
        Student expectedStudent = new Student();
        expectedStudent.setSEmail(email);
        expectedStudent.setSName(name);
        expectedStudent.setSPass(password);

        StudentService studentService = new StudentService();

        boolean testStudent = studentService.validateStudent(email, password);

        Assertions.assertTrue(testStudent);

    }

//    //    registerStudentToCourse
//    @ParameterizedTest()
//    @CsvSource({"/testdata/student.csv"})
//    @Test
//    protected void registerStudentToCourseTest(){
//
//        StudentService studentService = new StudentService();
//
//        String testStudentEmail = "devinmbutts@gmail.com";
//
//        Student testStudent = studentService.getStudentByEmail(testStudentEmail);
//
//        CourseService courseService = new CourseService();
//
//        Course courseToAdd = courseService.getCourseById(1);
//
//        testStudent.getSCourses().add(courseToAdd);
//
//
//
//
//
//
//    }

    @ParameterizedTest()
    @CsvFileSource(resources = {"/testdata/aiannitti7Courses.csv"}, delimiter = ',', numLinesToSkip = 1)
    protected void getStudentCoursesTest(String email, Integer courseId) {

        Integer expectedCourseId = courseId;


        StudentService studentService = new StudentService();

        Student testStudent = studentService.getStudentByEmail(email);

        boolean success = false;

        for (Course c : testStudent.getSCourses()){
            if(c.getCId() == expectedCourseId){
                success = true;
            }
        }

        Assertions.assertTrue(success);

    }


}
