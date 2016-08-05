package questionnaire.web.enumeration;

public enum QuestionType {

	TemperamentTest("TemperamentTest"), SeatQuality("SeatQuality");

	private final String value;

	QuestionType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
