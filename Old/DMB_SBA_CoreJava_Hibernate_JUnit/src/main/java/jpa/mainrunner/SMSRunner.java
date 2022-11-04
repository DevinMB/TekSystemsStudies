package jpa.mainrunner;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import jpa.service.CourseService;
import jpa.service.StudentService;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class SMSRunner {
    //TODO: Add input error handling!

    private Scanner sin;
    private StringBuilder sb;

    private CourseService courseService;
    private StudentService studentService;
    private Student currentStudent;

    public SMSRunner() {
        sin = new Scanner(System.in);
        sb = new StringBuilder();
        courseService = new CourseService();
        studentService = new StudentService();
    }

    public static void main(String[] args) {

        SMSRunner sms = new SMSRunner();
        sms.run();

    }

    private void run() {
        // Login or quit
        switch (menu1()) {
            case 1:
                if (studentLogin()) {
                    showCurrentUserClasses();
                    registerAClassMenu();
                }else{
                    out.println("No user found with these credentials, try again...");
                    run();
                    break;
                }
                break;
            case 2:
                out.println("Goodbye!");
                break;
            case 3:
                out.println("\nSay what?? Try again. ");
                run();
                break;
            default:
                out.println("\nSay what?? Try again.");
                run();
                break;
        }
    }

    private int menu1() {
        sb.append("\n1. Student Login\n2. Quit Application\nPlease Enter Selection: ");
        out.print(sb);
        sb.delete(0, sb.length());
        int input;
        try{
            input = sin.nextInt();
        }catch (InputMismatchException e){
            sin.next();
            return 3;
        }
        return input;
    }

    private void showCurrentUserClasses() {
        out.println("My Classes:\n");
        out.printf("%5s%32s%32s\n", "ID", "Course", "Instructor");
        out.println("----------------------------------------------------------------------------");
        for (Course c : currentStudent.getSCourses()) {
            out.printf("%5s%32s%32s\n", c.getCId(), c.getCName(), c.getCInstructorName());
        }
    }

    private boolean studentLogin() {
        out.print("\nEnter your email address: ");
        String email = sin.next();
        out.print("Enter your password: ");
        String password = sin.next();

        //VALIDATE
        StudentService studentService = new StudentService();
        if (studentService.validateStudent(email, password)) {
            currentStudent = studentService.getStudentByEmail(email);
            return true;
        } else {
            return false;
        }
    }

    private void registerAClassMenu() {
        sb.append("\n1. Register a class\n2. Logout\nPlease Enter Selection: ");
        out.print(sb);
        sb.delete(0, sb.length());

        switch (sin.nextInt()) {
            case 1:
                List<Course> allCourses = courseService.getAllCourses();
                List<Course> studentCourses = studentService.getStudentCourses(currentStudent.getSEmail());
                allCourses.removeAll(studentCourses);
                out.println("Available Courses: ");
                out.printf("%5s%32s%32s\n", "ID", "Course", "Instructor");
                for (Course course : allCourses) {
                    out.println(course.toString());
                }


                out.println();
                out.print("Enter Course Number: ");
                int number = sin.nextInt();
                Course newCourse = courseService.getCourseById(number);

                if (newCourse != null) {
                    if(!studentCourses.contains(newCourse)) {
                        studentService.registerStudentToCourse(currentStudent.getSEmail(), newCourse.getCId());

                        Student temp = studentService.getStudentByEmail(currentStudent.getSEmail());

                        StudentService scService = new StudentService();
                        List<Course> sCourses = scService.getStudentCourses(temp.getSEmail());

                        out.println("MyClasses");
                        out.printf("%5s%32s%32s\n", "ID", "Course", "Instructor");
                        out.println("----------------------------------------------------------------------------");
                        for (Course course : sCourses) {
                            out.println(course);
                        }

                        out.println("You have been signed out. Goodbye!");
                    }else{
                        out.println("You are already registered in that course!");
                        showCurrentUserClasses();
                        registerAClassMenu();
                    }
                }
                break;
            case 2:
            default:
                out.println("Goodbye!");
        }
    }
}
