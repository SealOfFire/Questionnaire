package questionnaire.web.enumeration;

public enum QuestionnaireType {

	TemperamentTest("TemperamentTest"), SeatQuality("SeatQuality");

	private final String value;

	QuestionnaireType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
