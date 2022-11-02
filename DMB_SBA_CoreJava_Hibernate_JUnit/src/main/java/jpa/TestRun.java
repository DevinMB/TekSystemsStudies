package jpa;

import jpa.service.StudentService;
import jpa.entitymodels.Student;

public class TestRun {

    public static void main(String[] args){

        System.out.println("Howdy");

        StudentService studentService = new StudentService();

        Student s = studentService.getStudentByEmail("devinmbutts@gmail.com");

        System.out.println(s.toString());

    }

}
