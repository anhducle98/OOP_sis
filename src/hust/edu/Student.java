package hust.edu;

public class Student extends Person {
    private String major;

    Student(String id, String name, String dateString, String major) {
        super(id, name, dateString);
        this.setMajor(major);
    }

    @Override
    public String toString() {
        return "(student#" + this.getId() + ":" + this.getName() + ")";
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
