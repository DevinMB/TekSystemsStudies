package jpa;

import jpa.service.StudentService;
import jpa.entitymodels.Student;

public class TestRun {

    public static void main(String[] args){

        System.out.println("Howdy");

        StudentService studentService = new StudentService();

        Student s1 = studentService.getStudentByEmail("devinmbutts@gmail.com");

        System.out.println(s1.toString());

//        studentService.registerStudentToCourse("devinmbutts@gmail.com",1);
//
//        Student s2 = studentService.getStudentByEmail("devinmbutts@gmail.com");
//
//        System.out.println(s2.toString());

    }

}
