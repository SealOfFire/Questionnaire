package questionnaire.web.model;

import java.util.ArrayList;
import java.util.UUID;

import questionnaire.web.enumeration.QuestionnaireType;

/** 问卷 */
public class Questionnaire {

	/** 问卷ID */
	private String questionnaireID;

	/** 问卷标题 */
	private String title;

	/** 描述 */
	private String description;

	/** 答卷时限 */
	private int timeLimit;

	/** 类型(性格测试/坐席素质) */
	private String questionnaireType;

	private String questionnaireTypeString;

	private ArrayList<Question> questions;

	public Questionnaire() {
	}

	public Questionnaire(String title, int timeLimit, QuestionnaireType questionnaireType) {
		this.questionnaireID = UUID.randomUUID().toString();
		this.title = title;
		this.timeLimit = timeLimit;
		this.questionnaireType = questionnaireType.toString();
	}

	/** 是否保存 */
	public boolean notSaved() {
		if (this.questionnaireID == null || this.questionnaireID.length() == 0)
			return true;
		else
			return false;
	}

	public String getQuestionnaireID() {
		return questionnaireID;
	}

	public void setQuestionnaireID(String questionnaireID) {
		this.questionnaireID = questionnaireID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}

	public String getQuestionnaireType() {
		return questionnaireType;
	}

	public void setQuestionnaireType(String questionnaireType) {
		this.questionnaireType = questionnaireType;
	}

	public String getQuestionnaireTypeString() {
		switch (this.questionnaireType) {
		case "TemperamentTest":
			this.questionnaireTypeString = "性格测试";
			break;
		case "SeatQuality":
			this.questionnaireTypeString = "坐席素质";
			break;
		default:
			this.questionnaireTypeString = "";
			break;
		}
		return this.questionnaireTypeString;
	}

	public void setQuestionnaireTypeString(String questionnaireTypeString) {
		this.questionnaireTypeString = questionnaireTypeString;
	}

	public ArrayList<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(ArrayList<Question> questions) {
		this.questions = questions;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
