package questionnaire.web.model;

/** 打字问题 */
public class Typewrite {
	private String questionID;
	private String title;
	private String captionText;
	private String captionImage;

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

	public String getCaptionText() {
		return captionText;
	}

	public void setCaptionText(String captionText) {
		this.captionText = captionText;
	}

	public String getCaptionImage() {
		return captionImage;
	}

	public void setCaptionImage(String captionImage) {
		this.captionImage = captionImage;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
