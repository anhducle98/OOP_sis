package hust.edu;

public class Teacher extends Person {
    private String department;

    Teacher(String id, String name, String dateString, String department) {
        super(id, name, dateString);
        this.setDepartment(department);
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
