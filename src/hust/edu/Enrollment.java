package hust.edu;

public class Enrollment extends HustObject {
    private Student student;
    private Class whichClass;
    private double score;

    Enrollment(Student student, Class whichClass) {
        super(student.getId() + "-" + whichClass.getId());
        this.setWhichClass(whichClass);
        this.setStudent(student);
    }

    public Class getWhichClass() {
        return whichClass;
    }

    public void setWhichClass(Class whichClass) {
        this.whichClass = whichClass;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
