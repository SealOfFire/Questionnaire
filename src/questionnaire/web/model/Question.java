package questionnaire.web.model;

import java.util.ArrayList;

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

	private int sort;

	private ArrayList<Option> options;

	private String selectedValue;

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

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public ArrayList<Option> getOptions() {
		return options;
	}

	public void setOptions(ArrayList<Option> options) {
		this.options = options;
	}

	public String getSelectedValue() {
		return selectedValue;
	}

	public void setSelectedValue(String selectedValue) {
		this.selectedValue = selectedValue;
	}
}
