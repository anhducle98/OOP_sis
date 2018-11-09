package hust.edu;

public class Course extends HustObject {
    private String name;
    private int credit;

    Course(String id, String name, int credit) {
        super(id);
        this.setName(name);
        this.setCredit(credit);
    }

    @Override
    public String toString() {
        return name;
    }

    public boolean isProject() {
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
}
