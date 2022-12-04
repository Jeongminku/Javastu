package school;

import java.util.ArrayList;

public class School {
	private static School instance = new School();
	private String School_Name = "goodSchool";
	private ArrayList<Student> studentList = new ArrayList<Student>();
	private ArrayList<Subject> subjectList = new ArrayList<Subject>();
	
	private School() {
		
	}
	
	public static School getInstance() {
		if(instance == null) {
			instance = new School();
		}
		return instance;
	}
	
	public void addStudent(Student student) {
		studentList.add(student);
	}
	
	
	
	public ArrayList<Student> getStudentList() {
		return studentList;
	}

	public void addSubject(Subject subject) {
		subjectList.add(subject);
	}

	public ArrayList<Subject> getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(ArrayList<Subject> subjectList) {
		this.subjectList = subjectList;
	}
	
	
	
}
