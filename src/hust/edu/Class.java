package hust.edu;

public class Class extends HustObject {
    private Course course;
    private Teacher teacher;

    Class(String id, Course course, Teacher teacher) {
        super(id);
        this.setCourse(course);
        this.setTeacher(teacher);
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
