package hust.edu;

public class Project extends Course {
	Project(String id, String name, int credit) {
		super(id, name, credit);
	}

	@Override
	public boolean isProject() {
		return true;
	}
}
