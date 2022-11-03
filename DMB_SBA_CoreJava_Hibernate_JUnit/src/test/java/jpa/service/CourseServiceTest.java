package jpa.service;

import jpa.entitymodels.Course;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.List;

public class CourseServiceTest {

    @ParameterizedTest()
    @CsvFileSource(resources = {"/testdata/course.csv"},delimiter = ',',numLinesToSkip = 1)
    protected void getAllCoursesTest(Integer id, String name, String instructor){
        Course expectedCourse = new Course();
        expectedCourse.setCId(id);
        expectedCourse.setCName(name);
        expectedCourse.setCInstructorName(instructor);

        CourseService courseService = new CourseService();

        List<Course> testCourses = courseService.getAllCourses();

        Course testCourse = new Course();

        for (Course c : testCourses){
            if(c.getCId()==expectedCourse.getCId()){
                testCourse = c;
            }
        }

        Assertions.assertEquals(expectedCourse,testCourse);
    }

    @ParameterizedTest()
    @CsvFileSource(resources = {"/testdata/course.csv"},delimiter = ',',numLinesToSkip = 1)
    protected void getCourseByIdTest(Integer id, String name, String instructor){
        Course expectedCourse = new Course();
        expectedCourse.setCId(id);
        expectedCourse.setCName(name);
        expectedCourse.setCInstructorName(instructor);

        CourseService courseService = new CourseService();

        Course testCourse = courseService.getCourseById(id);

        Assertions.assertEquals(expectedCourse,testCourse);
    }


}
