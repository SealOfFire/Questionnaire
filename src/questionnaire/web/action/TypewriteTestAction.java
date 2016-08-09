package questionnaire.web.action;

import java.math.BigDecimal;
import java.sql.Date;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import questionnaire.bll.AnswerBLL;
import questionnaire.bll.QuestionnairePartsBLL;
import questionnaire.web.model.Answer;
import questionnaire.web.model.Typewrite;

public class TypewriteTestAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private String userID = null;
	private String questionnaireID = null;
	private String questionID = null;
	private Typewrite typewrite = null;
	private String text = null;

	public String init() {
		// 开始时间
		ActionContext.getContext().getSession().put("BEGIN_DATE", new Date(new java.util.Date().getTime()));
		// 获取答题进度
		boolean[] answerProgress = new AnswerBLL().answerProgress(this.userID);
		if (!answerProgress[0] || !answerProgress[1]) {
			// 从第一部分开始
			return "select";
		} else if (!answerProgress[2]) {
			// 打字部分
			this.typewrite = new QuestionnairePartsBLL().selectPart3();
			this.questionnaireID = this.typewrite.getQuestionID();
			this.questionID = this.typewrite.getQuestionID();
		} else if (answerProgress[2]) {
			return "finish";
		}

		return SUCCESS;
	}

	public String save() {
		boolean[] answerProgress = new AnswerBLL().answerProgress(this.userID);
		if (!answerProgress[2]) {
			int count = 0;
			Answer answer = new Answer();
			answer.setUserID(this.userID);
			answer.setQuestionnaireID(this.questionnaireID);
			answer.setQuestionID(this.questionID);
			answer.setOptionID(this.questionID);
			answer.setAnswer(this.text);
			answer.setBeginDate((Date) ActionContext.getContext().getSession().get("BEGIN_DATE"));
			answer.setEndDate(new Date(new java.util.Date().getTime()));
			answer.setScore(new BigDecimal(0));
			count += new AnswerBLL().replace(answer);
		}
		return SUCCESS;
	}

	// --------------------- GETTER / SETTER METHODS --------------------
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getQuestionnaireID() {
		return questionnaireID;
	}

	public void setQuestionnaireID(String questionnaireID) {
		this.questionnaireID = questionnaireID;
	}

	public Typewrite getTypewrite() {
		return typewrite;
	}

	public void setTypewrite(Typewrite typewrite) {
		this.typewrite = typewrite;
	}

	public String getQuestionID() {
		return questionID;
	}

	public void setQuestionID(String questionID) {
		this.questionID = questionID;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
