package grade;

public class MajorEvalu implements GradeEvaluation {

	@Override
	public String getGrade(int point) {
		String Grade;
		if (100 >= point || point >= 95) {
			Grade = "S";
		} else if (94 >= point || point >= 90) {
			Grade = "A";
		} else if (89 >= point || point >= 70) {
			Grade = "B";
		} else if (79 >= point || point >= 60) {
			Grade = "C";
		} else if (69 >= point || point >= 60) {
			Grade = "D";
		} else {
			Grade = "F";
		}
		return Grade;

	}
}
