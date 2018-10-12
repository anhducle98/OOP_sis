package hust.edu;

import java.text.SimpleDateFormat;
import java.util.*;

public class Database {
    private Map<String, Class> classes;
    private Map<String, Course> courses;
    private Map<String, Enrollment> enrollments;
    private Map<String, Room> rooms;
    private Map<String, Session> sessions;
    private Map<String, Student> students;
    private Map<String, Teacher> teachers;

    Database() {
        classes = new HashMap<>();
        courses = new HashMap<>();
        enrollments = new HashMap<>();
        rooms = new HashMap<>();
        sessions = new HashMap<>();
        students = new HashMap<>();
        teachers = new HashMap<>();
    }

    private void insert(Map map, HustObject object) {
        map.put(object.getId(), object);
    }

    public void insertCourse(Course course) {
        insert(courses, course);
    }
    public void insertTeacher(Teacher teacher) {
        insert(teachers, teacher);
    }
    public void insertClass(Class whichClass) {
        insert(classes, whichClass);
    }
    public void insertRoom(Room room) {
        insert(rooms, room);
    }
    public void insertSession(Session session) {
        insert(sessions, session);
    }
    public void insertEnrollment(Enrollment enrollment) {
        insert(enrollments, enrollment);
    }
    public void insertStudent(Student student) {
        insert(students, student);
    }

    public Map<String, Class> getClasses() {
        return classes;
    }

    public Map<String, Course> getCourses() {
        return courses;
    }

    public Map<String, Enrollment> getEnrollments() {
        return enrollments;
    }

    public Map<String, Room> getRooms() {
        return rooms;
    }

    public Map<String, Session> getSessions() {
        return sessions;
    }

    public Map<String, Student> getStudents() {
        return students;
    }

    public Map<String, Teacher> getTeachers() {
        return teachers;
    }

    public void printTimeTable(String studentId) {
        Student student = students.get(studentId);
        List<Session> sessionList = new ArrayList<>();
        for (Enrollment enrollment : enrollments.values()) {
            if (enrollment.getStudent() == student) {
                Class whichClass = enrollment.getWhichClass();
                for (Session session : sessions.values()) {
                    if (session.getWhichClass() == whichClass) {
                        sessionList.add(session);
                    }
                }
            }
        }
        Collections.sort(sessionList);
        for (Session session : sessionList) {
            String day = (new SimpleDateFormat("E")).format(session.getStart());
            String startHour = (new SimpleDateFormat("HH:mm").format(session.getStart()));
            String endHour = (new SimpleDateFormat("HH:mm").format(session.getEnd()));
            Class whichClass = session.getWhichClass();
            System.out.format("%s %s - %s\tRoom:%s\tClassId:%s\tCourseId:%s\t%s - Teacher:%s\n", day, startHour, endHour, session.getRoom().getId(), whichClass.getId(), whichClass.getCourse().getId(), whichClass.getCourse().getName(), whichClass.getTeacher().getName());
        }
    }
}
