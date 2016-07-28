package questionnaire.web.model;

public enum QuestionnaireType {

	TemperamentTest("性格测试"), SeatQuality("坐席素质");

	private final String value;

	QuestionnaireType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
