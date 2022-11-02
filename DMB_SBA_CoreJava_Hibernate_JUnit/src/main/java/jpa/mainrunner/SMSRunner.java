package jpa.mainrunner;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import jpa.service.CourseService;
import jpa.service.StudentService;

import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class SMSRunner {


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

    /**
     * @param args
     */
    public static void main(String[] args) {

        SMSRunner sms = new SMSRunner();
        sms.run();
    }

    private void run() {
        // Login or quit
        switch (menu1()) {
            case 1:
                if (studentLogin()) {
                    registerMenu();
                }
                break;
            case 2:
                out.println("Goodbye!");
                break;

            default:

        }
    }

    private int menu1() {
        sb.append("\n1.Student Login\n2. Quit Application\nPlease Enter Selection: ");
        out.print(sb.toString());
        sb.delete(0, sb.length());

        return sin.nextInt();
    }

    private boolean studentLogin() {
        boolean retValue = false;
        out.print("Enter your email address: ");
        String email = sin.next();
        out.print("Enter your password: ");
        String password = sin.next();

        //TODO: modify this so that when login is called it verify's user is in db, then pulls user from db. Lot of weird code here.
        List<Student> students = studentService.getAllStudents();
        if (students != null) {
            currentStudent = students.get(0);
        }

        if (currentStudent != null & currentStudent.getSPass().equals(password)) {
            List<Course> courses = studentService.getStudentCourses(email);
            out.println("MyClasses");
            for (Course course : courses) {
                out.println(course);
            }
            retValue = true;
        } else {
            out.println("User Validation failed. GoodBye!");
        }
        return retValue;
    }

    private void registerMenu() {
        sb.append("\n1.Register a class\n2. Logout\nPlease Enter Selection: ");
        out.print(sb.toString());
        sb.delete(0, sb.length());

        switch (sin.nextInt()) {
            case 1:
                List<Course> allCourses = courseService.getAllCourses();
                List<Course> studentCourses = studentService.getStudentCourses(currentStudent.getSEmail());
                allCourses.removeAll(studentCourses);
                out.printf("%5s%15S%15s\n", "ID", "Course", "Instructor");
                for (Course course : allCourses) {
                    out.println(course);
                }
                out.println();
                out.print("Enter Course Number: ");
                int number = sin.nextInt();
                Course newCourse = courseService.getCourseById(number);

                if (newCourse != null) {
                    studentService.registerStudentToCourse(currentStudent.getSEmail(), newCourse.getCId());
                    Student temp = studentService.getStudentByEmail(currentStudent.getSEmail());

                    StudentService scService = new StudentService();
                    List<Course> sCourses = scService.getStudentCourses(temp.getSEmail());


                    out.println("MyClasses");
                    for (Course course : sCourses) {
                        out.println(course);
                    }
                }
                break;
            case 2:
            default:
                out.println("Goodbye!");
        }
    }



}
