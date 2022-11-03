package jpa.mainrunner;

import jpa.dao.StudentDAO;
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
                    showCurrentUserClasses();
                    registerAClassMenu();
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

    private void showCurrentUserClasses() {
        out.println("My Classes:\n");
        out.printf("%5s%32s%32s\n", "ID", "Course", "Instructor");
        out.println("----------------------------------------------------------------------------");
        //int count = 1;
        for (Course c : currentStudent.getSCourses()) {
            out.printf("%5s%32s%32s\n", c.getCId(), c.getCName(), c.getCInstructorName());
            //count++;
        }
    }

    private boolean studentLogin() {
        boolean retValue = false;
        out.print("Enter your email address: ");
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
        sb.append("\n1.Register a class\n2. Logout\nPlease Enter Selection: ");
        out.print(sb.toString());
        sb.delete(0, sb.length());

        switch (sin.nextInt()) {
            case 1:
                List<Course> allCourses = courseService.getAllCourses();
                List<Course> studentCourses = studentService.getStudentCourses(currentStudent.getSEmail());
                allCourses.removeAll(studentCourses);
                out.printf("%5s%32s%32s\n", "ID", "Course", "Instructor");
                for (Course course : allCourses) {
                    out.println(course.toString());
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
                    out.printf("%5s%32s%32s\n", "ID", "Course", "Instructor");
                    out.println("----------------------------------------------------------------------------");
                    for (Course course : sCourses) {
                        out.println(course);
                    }

                    out.println("You have been signed out. Goodbye!");
                }
                break;
            case 2:
            default:
                out.println("Goodbye!");
        }
    }


}
