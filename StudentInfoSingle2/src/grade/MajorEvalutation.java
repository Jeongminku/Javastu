package grade;

public class MajorEvalutation implements GradeEvalutation {

	@Override
	public String getGrade(int point) {

		String grade;
		if (100 >= point && point >= 95) {
			grade = "S";
		} else if (94 >= point && point >= 90) {
			grade = "A";
		} else if (89 >= point && point >= 80) {
			grade = "B";
		} else if (79 >= point && point >= 70) {
			grade = "C";
		} else if (69 >= point && point >= 60) {
			grade = "D";
		} else {
			grade = "F";
		}
		return grade;
	}
}
