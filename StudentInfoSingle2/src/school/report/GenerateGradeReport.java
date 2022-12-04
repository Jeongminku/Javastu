package school.report;

import java.util.ArrayList;

import grade.BasicEvalutation;
import grade.GradeEvalutation;
import grade.MajorEvalutation;
import school.*;
import utils.Define;

public class GenerateGradeReport {
	School school = School.getInstance();
	
	public static final String TITLE = "수강생 학점 \t\t\n";
	public static final String HEADER = "이름  |  학번  | 필수과목  |  점수 \n";
	public static final String LINE = "===============================\n";
	private StringBuffer buffer = new StringBuffer();
	
	public String getReport() {
		
		ArrayList<Subject> subjectList = school.getSubjectList();
		for (Subject subject : subjectList) {
			makeHeader(subject);
			makeBody(subject);
			makeFooter();
		}
		return buffer.toString();
	}
	
	
	public void makeHeader(Subject subject) {
		buffer.append(LINE);
		buffer.append("\t"+ subject.getSubjectName());
		buffer.append(TITLE);
		buffer.append(HEADER);
		buffer.append(LINE);
	}
	public void makeBody(Subject subject) {
		ArrayList<Student> studentList = subject.getStudentList();
		for (int i = 0; i<studentList.size(); i++) {
			Student student = studentList.get(i);
			buffer.append(student.getStudentName());
			buffer.append(" | ");
			buffer.append(student.getStudentId());
			buffer.append(" | ");
			buffer.append(student.getMajorSubject().getSubjectId());
			buffer.append(" | ");
			
			addScoreForStudent(student, subject.getSubjectId());
			
			buffer.append("\n");
			buffer.append(LINE);
		}
	}
	public void makeFooter() {
		buffer.append("\n");
	}
	
	public void addScoreForStudent(Student student, int subjectId) {
		ArrayList<Score> scoreList = student.getScoreList();
		int majorId = student.getMajorSubject().getSubjectId();
		GradeEvalutation[] gradeEvalutations = {new BasicEvalutation(), new MajorEvalutation()};
		
		for (int i = 0; i < scoreList.size(); i++) {
			Score score = scoreList.get(i);
			if(score.getSubject().getSubjectId() == subjectId) {
				String grade;
				if(score.getSubject().getSubjectId() == majorId) {
					grade = gradeEvalutations[Define.SAB_TYPE].getGrade(score.getPoint());
				}else {
					grade = gradeEvalutations[Define.AB_TYPE].getGrade(score.getPoint());
				}
				
				buffer.append(score.getPoint());
				buffer.append(" : ");
				buffer.append(grade);
				buffer.append(" | ");
				
				
				
			}
		}
	}
	
}
