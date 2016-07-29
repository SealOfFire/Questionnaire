package questionnaire.web.enumeration;

public enum QuestionType {

	TemperamentTest("性格测试"), SeatQuality("坐席素质");

	private final String value;

	QuestionType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
