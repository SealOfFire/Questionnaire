package questionnaire.web.model;

import questionnaire.web.enumeration.QuestionType;

/** 问题 */
public class Question {

	/** 问题ID */
	private String questionID;

	/** 題目 */
	private String caption;

	/** 类型(性格测试/坐席素质) */
	private String questionType;

	private String questionTypeString;

	public Question() {
		this.caption = "";
		this.questionType = QuestionType.TemperamentTest.toString();
	}

	public Question(String caption, QuestionType questionType) {
		this.caption = caption;
		this.questionType = questionType.toString();
	}

	/** 是否保存 */
	public boolean notSaved() {
		if (this.questionID == null || this.questionID.length() == 0)
			return true;
		else
			return false;
	}

	public String getQuestionID() {
		return questionID;
	}

	public void setQuestionID(String questionID) {
		this.questionID = questionID;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public String getQuestionTypeString() {
		switch (this.questionType) {
		case "TemperamentTest":
			this.questionTypeString = "性格测试";
			break;
		case "SeatQuality":
			this.questionTypeString = "坐席素质";
			break;
		default:
			this.questionTypeString = "";
			break;
		}
		return this.questionTypeString;
	}

	public void setQuestionTypeString(String questionTypeString) {
		this.questionTypeString = questionTypeString;
	}
}
