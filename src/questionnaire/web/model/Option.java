package questionnaire.web.model;

import java.math.BigDecimal;

public class Option {

	private String optionID;
	private String questionID;
	private String caption;
	private BigDecimal score;
	private String scoreString;
	private int sort;

	public String getOptionID() {
		return optionID;
	}

	public void setOptionID(String optionID) {
		this.optionID = optionID;
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

	public BigDecimal getScore() {
		return score;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getScoreString() {
		this.scoreString = this.score.toString();
		return scoreString;
	}

	public void setScoreString(String scoreString) {
		this.scoreString = scoreString;
		try {
			this.score = new BigDecimal(scoreString);
		} catch (Exception e) {
			this.score = new BigDecimal(0);
		}
	}
}
