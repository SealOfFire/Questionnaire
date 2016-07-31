package questionnaire.web.model;

public class Interview {
	private String questionID;
	private String title;
	private String standard;
	private String question;
	private String questionAdd;
	private int sort;

	public String getQuestionID() {
		return questionID;
	}

	public void setQuestionID(String questionID) {
		this.questionID = questionID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getQuestionAdd() {
		return questionAdd;
	}

	public void setQuestionAdd(String questionAdd) {
		this.questionAdd = questionAdd;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}
}
