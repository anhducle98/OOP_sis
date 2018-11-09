package hust.edu;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    private static Database database = new Database();

    public static void main(String[] args) {
        // use Databases's public methods to create data
        initialize();
        printStudentData("20164844");
        System.out.println();
        printCourseData("IT3100");

        System.out.println("gv2's classes: " + database.getClassListFromTeacherId("gv2"));
        System.out.println("20164844's classes: " + database.getClassListFromStudentId("20164844"));
        System.out.println("gv6's project students: " + database.getStudentsMentoredByTeacher("gv6"));
        System.out.println("IT3100's teachers: " + database.getTeachersFromCourseId("IT3100"));
    }

    private static void initCourses() {
        database.insertCourse(new Course("IT3090", "Databases", 3));
        database.insertCourse(new Course("IT3053", "English", 2));
        database.insertCourse(new Course("IT3080", "Networking", 3));
        database.insertCourse(new Course("IT3133", "Digital Electronics", 3));
        database.insertCourse(new Course("IT3110", "Linux & Opensource softwares", 2));
        database.insertCourse(new Course("IT3100", "Object oriented programming", 3));
    }

    private static void initTeachers() {
        database.insertTeacher(new Teacher("gv1", "Nguyen Kim Anh", "1/2/1980", "CS"));
        database.insertTeacher(new Teacher("gv2", "Nguyen Thi Thu Trang", "1/2/1980", "CS"));
        database.insertTeacher(new Teacher("gv3", "Ngo Hong Son", "1/2/1980", "CS"));
        database.insertTeacher(new Teacher("gv4", "Nguyen Thi Thanh Nga", "1/2/1980", "CS"));
        database.insertTeacher(new Teacher("gv5", "Truong Thi Dieu Linh", "1/2/1980", "CS"));
        database.insertTeacher(new Teacher("gv6", "Nguyen Thanh Hung", "1/2/1980", "CS"));
    }

    private static void initClasses() {
        database.insertClass(new Class("103970", database.getCourses().get("IT3090"), database.getTeachers().get("gv1")));
        database.insertClass(new Class("103968", database.getCourses().get("IT3053"), database.getTeachers().get("gv2")));
        database.insertClass(new Class("103969", database.getCourses().get("IT3080"), database.getTeachers().get("gv3")));
        database.insertClass(new Class("103973", database.getCourses().get("IT3133"), database.getTeachers().get("gv4")));
        database.insertClass(new Class("103972", database.getCourses().get("IT3110"), database.getTeachers().get("gv5")));
        database.insertClass(new Class("103971", database.getCourses().get("IT3100"), database.getTeachers().get("gv6")));
    }

    private static void initRooms() {
        database.insertRoom(new Room("D6-104"));
        database.insertRoom(new Room("D6-102"));
    }

    private static void initSessions() {
        database.insertSession(new Session("ss1", "Monday 12:30", "Monday 15:50", database.getRooms().get("D6-104"), database.getClasses().get("103970")));
        database.insertSession(new Session("ss2", "Monday 16:00", "Monday 17:35", database.getRooms().get("D6-104"), database.getClasses().get("103968")));
        database.insertSession(new Session("ss3", "Wednesday 12:30", "Wednesday 14:05", database.getRooms().get("D6-104"), database.getClasses().get("103968")));
        database.insertSession(new Session("ss4", "Wednesday 14:15", "Wednesday 17:35", database.getRooms().get("D6-104"), database.getClasses().get("103969")));
        database.insertSession(new Session("ss5", "Thursday 12:30", "Thursday 15:00", database.getRooms().get("D6-102"), database.getClasses().get("103973")));
        database.insertSession(new Session("ss6", "Friday 12:30", "Friday 15:00", database.getRooms().get("D6-104"), database.getClasses().get("103972")));
        database.insertSession(new Session("ss7", "Friday 15:05", "Friday 17:35", database.getRooms().get("D6-104"), database.getClasses().get("103971")));
    }

    private static void initStudents() {
        database.insertStudent(new Student("20164844", "Le Anh Duc", "16/01/1998", "Computer Science"));
        database.insertStudent(new Student("20164845", "Anh Duc Le", "16/01/1998", "Computer Science"));
        database.insertStudent(new Student("20164846", "Anh Le Duc", "16/01/1998", "Computer Science"));
        database.insertStudent(new Student("20164847", "Duc Le Anh", "16/01/1998", "Computer Science"));
        database.insertStudent(new Student("20164848", "Duc Anh Le", "16/01/1998", "Computer Science"));
    }

    private static void initEnrollments() {
        // enroll all students to all classes
        List<Enrollment> enrollmentList = new ArrayList<>();
        for (Class whichClass : database.getClasses().values()) {
            for (Student student : database.getStudents().values()) {
                enrollmentList.add(new Enrollment(student, whichClass));
            }
        }
        for (Enrollment enrollment : enrollmentList) {
            database.insertEnrollment(enrollment);
        }
    }

    private static void initProjects() {
        database.insertCourse(new Project("IT3910", "Project I", 2));
        database.insertClass(new Class("103974", database.getCourses().get("IT3910"), database.getTeachers().get("gv6")));
    }

    private static void initProjectEnrollments() {
        database.insertEnrollment(new Enrollment(database.getStudents().get("20164844"), database.getClasses().get("103974")));
    }

    private static void initialize() {
        initCourses();
        initTeachers();
        initClasses();
        initRooms();
        initSessions();
        initStudents();
        initEnrollments();
        initProjects();
        initProjectEnrollments();
    }

    private static void printStudentData(String studentId) {
        Student student = database.getStudents().get(studentId);
        System.out.format("Student name: %s\nStudentId: %s\nMajor: %s\nBirthdate: %s\n", student.getName(), student.getId(), student.getMajor(), student.getBirthDate());
        System.out.println("Timetable for student " + studentId);
        database.printTimeTable(studentId);
    }

    private static void printCourseData(String courseId) {
        Course course = database.getCourses().get(courseId);
        for (Class whichClass : database.getClasses().values()) {
            if (whichClass.getCourse() == course) {
                Teacher teacher = whichClass.getTeacher();
                System.out.format("Class #%s, teacher:%s\n", whichClass.getId(), teacher.getName());
                for (Enrollment enrollment : database.getEnrollments().values()) {
                    if (enrollment.getWhichClass() == whichClass) {
                        System.out.format("\tStudent #%s - %s enrolled\n", enrollment.getStudent().getId(), enrollment.getStudent().getName());
                    }
                }
            }
        }
    }
}
