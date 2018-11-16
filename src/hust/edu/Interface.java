package hust.edu;

public class Interface {
	private static IO io;
	private Database database;

	Interface(Database database) {
		this.database = database;
	}

	public void readNewStudent() {
		String id = io.readString("Student-id: ");
		String name = io.readString("Student name: ");
		String dateString = io.readString("Date of birth: ");
		String major = io.readString("Major: ");
		Student student = new Student(id, name, dateString, major);
		database.insertStudent(student);
	}

	public void readNewTeacher() {
		String id = io.readString("Teacher id: ");
		String name = io.readString("Teacher name: ");
		String dateString = io.readString("Date of birth: ");
		String department = io.readString("Department: ");
		Teacher teacher = new Teacher(id, name, dateString, department);
		database.insertTeacher(teacher);
	}

	public void readNewClass() {
		String id = io.readString("Class id: ");
		String courseId = io.readString("Course id: ");
		String teacherId = io.readString("Teacher id: ");
		Course course = database.getCourses().get(courseId);
		Teacher teacher = database.getTeachers().get(teacherId);
		Class whichClass = new Class(id, course, teacher);
		database.insertClass(whichClass);
	}

	public void readNewCourse() {
		String id = io.readString("Course id: ");
		String name = io.readString("Course name: ");
		int credit = io.readInt("Credit: ");
		Course course = new Course(id, name, credit);
		database.insertCourse(course);
	}

	public void listStudentByClassId(String classId) {
		io.println(database.getStudentsFromClassId(classId));
	}

	public void listAllStudents() {
		io.println(database.getStudents().values());
	}
	public void listAllCourses() {
		io.println(database.getCourses().values());
	}
	public void listAllClasses() {
		io.println(database.getClasses().values());
	}
	public void listAllTeachers() {
		io.println(database.getTeachers().values());
	}

	public void listStudentByTeacherId(String teacherId) {
		io.println(database.getStudentsMentoredByTeacher(teacherId));
	}

	public void menu() {
		while (true) {
			System.out.println("-----------MENU--------------");
			System.out.println("Press 1 to add new student : ");
			System.out.println("Press 2 to add new teacher : ");
			System.out.println("Press 3 to add new course: ");
			System.out.println("Press 4 to add new class: ");
			System.out.println("Press 5 to view all students: ");
			System.out.println("Press 6 to view all teachers: ");
			System.out.println("Press 7 to view all courses: ");
			System.out.println("Press 8 to view all classes: ");
			System.out.println("Press 9 to list student by classId");
			System.out.println("Press 10 to list student by teacherId");
			System.out.println("-----------------------------");
			int type = io.readInt("Your choice : ");
			switch (type) {
				case 1:
					readNewStudent();
					break;
				case 2:
					readNewTeacher();
					break;
				case 3:
					readNewCourse();
					break;
				case 4:
					readNewClass();
					break;
				case 5:
					listAllStudents();
					break;
				case 6:
					listAllTeachers();
					break;
				case 7:
					listAllCourses();
					break;
				case 8:
					listAllClasses();
					break;
				case 9:
					listStudentByClassId(io.readString("Class id: "));
					break;
				case 10:
					listStudentByTeacherId(io.readString("Teacher id: "));
					break;

			}
		}
	}
}
