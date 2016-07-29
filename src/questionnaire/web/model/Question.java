package questionnaire.web.model;

import java.util.UUID;

import questionnaire.web.enumeration.QuestionType;

/** 问题 */
public class Question {

	/** 问题ID */
	private String questionID;

	/** 題目 */
	private String caption;

	/** 类型(性格测试/坐席素质) */
	private QuestionType questionType;

	public Question() {
	}

	public Question(String caption, QuestionType questionType) {
		this.questionID = UUID.randomUUID().toString();
		this.caption = caption;
		this.questionType = questionType;
	}

	public String getQuestionID() {
		return questionID;
	}

	/** 是否保存 */
	public boolean notSaved() {
		if (this.questionID == null || this.questionID.length() == 0)
			return true;
		else
			return false;
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

	public QuestionType getQuestionType() {
		return questionType;
	}

	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}
}
