package hust.edu;

public class Student extends Person {
    private String major;

    Student(String id, String name, String dateString, String major) {
        super(id, name, dateString);
        this.setMajor(major);
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
