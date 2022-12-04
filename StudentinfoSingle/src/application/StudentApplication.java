package application;

import school.*;
import school.report.GenerateGradeReport;
import utils.Define;


public class StudentApplication {

	School goodSchool = School.getInstance();
	Subject korean;
	Subject math;
	
	GenerateGradeReport gradeReport = new GenerateGradeReport();
	
	public static void main(String[] args) {
	StudentApplication test = new StudentApplication();
	test.createSubject();
	test.createStudent();
	
	String report = test.gradeReport.getReport();
	System.out.println(report);
	}

	
	
	
	public void createSubject() {
		korean = new Subject("국어", Define.KOREAN);
		math = new Subject("수학", Define.MATH);
		
		goodSchool.addSubject(korean);
		goodSchool.addSubject(math);
	}
	
	public void createStudent() {
		Student student1 = new Student(111111, "손흥민", korean);
		Student student2 = new Student(222222, "호날두", math);
		Student student3 = new Student(333333, "벤투", korean);
		
		
	//학생을 학교에 등록하기.
	goodSchool.addStudent(student1);
	goodSchool.addStudent(student2);
	goodSchool.addStudent(student3);
	//학생을 국어과목에 배정.
	korean.register(student1);
	korean.register(student2);
	korean.register(student3);
	//학생을 수학과목에 배정.
	math.register(student1);
	math.register(student2);
	math.register(student3);
	
	addScoreForStudent(student1, korean, 97);
	addScoreForStudent(student2, korean, 87);
	addScoreForStudent(student3, korean, 77);
	
	addScoreForStudent(student1, math, 77);
	addScoreForStudent(student2, math, 87);
	addScoreForStudent(student3, math, 97);
	}
	
	public void addScoreForStudent(Student student, Subject subject, int point) {
		Score score = new Score(student.getStudentId(), subject, point);
		student.addSubjectScore(score);
	}
	
}
