package jpa.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

public class CourseServiceTest {
//TODO:FillOutCSVFILESOURCE


    @ParameterizedTest
    @CsvFileSource(resources = {"../../../resources/course.csv"},delimiter = ',',numLinesToSkip = 1)
    protected void getAllCoursesTest(Integer id, String name, String instructor){



    }

    //TODO:complete getCourseById test
    //getCourseById




}
