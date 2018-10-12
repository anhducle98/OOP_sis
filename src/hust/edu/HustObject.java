package hust.edu;

public abstract class HustObject {
    private String id;

    public HustObject(String id) {
        this.setId(id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
