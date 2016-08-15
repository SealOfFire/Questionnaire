package questionnaire.web.action;

import java.math.BigDecimal;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import questionnaire.bll.AnswerBLL;
import questionnaire.bll.QuestionnaireBLL;
import questionnaire.bll.QuestionnairePartsBLL;
import questionnaire.web.model.Answer;
import questionnaire.web.model.Option;
import questionnaire.web.model.Question;
import questionnaire.web.model.Questionnaire;

public class ExaminationAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private String userID = null;
	private String questionnaireID = null;
	private Questionnaire questionnaire = null;
	private int timeLimit = 0;

	public String init() {
		// 开始时间
		ActionContext.getContext().getSession().put("BEGIN_DATE", new Date(new java.util.Date().getTime()));
		// 获取答题进度
		boolean[] answerProgress = new AnswerBLL().answerProgress(this.userID);
		if (!answerProgress[0]) {
			// 从第一部分开始
			this.questionnaire = new QuestionnairePartsBLL().selectPart1();
			this.questionnaireID = this.questionnaire.getQuestionnaireID();
			this.timeLimit = this.questionnaire.getTimeLimit();
		} else if (!answerProgress[1]) {
			// 从第二部分开始
			this.questionnaire = new QuestionnairePartsBLL().selectPart2();
			this.questionnaireID = this.questionnaire.getQuestionnaireID();
			this.timeLimit = this.questionnaire.getTimeLimit();
		} else if (!answerProgress[2]) {
			// 打字部分
			return "typewrite";
		}

		return SUCCESS;
	}

	public String save() {
		AnswerBLL bll = new AnswerBLL();
		if (!bll.answerProgress(this.userID, this.questionnaireID)) {
			this.questionnaire = new QuestionnaireBLL().selectIncludeQuestions(this.questionnaireID);
			HttpServletRequest request = ServletActionContext.getRequest();
			int count = 0;
			for (Question question : this.questionnaire.getQuestions()) {
				String selectedOptionID = request.getParameter("questionID" + question.getQuestionID());
				Answer answer = new Answer();
				answer.setUserID(this.userID);
				answer.setQuestionnaireID(questionnaireID);
				answer.setQuestionID(question.getQuestionID());
				answer.setBeginDate((Date) ActionContext.getContext().getSession().get("BEGIN_DATE"));
				answer.setEndDate(new Date(new java.util.Date().getTime()));
				if (selectedOptionID != null) {
					answer.setOptionID(selectedOptionID);
					answer.setAnswer(selectedOptionID);
					for (Option option : question.getOptions()) {
						if (selectedOptionID.equals(option.getOptionID())) {
							answer.setScore(option.getScore());
						}
					}
				} else {
					answer.setOptionID("00000000-0000-0000-0000-000000000000");
					answer.setAnswer("00000000-0000-0000-0000-000000000000");
					answer.setScore(BigDecimal.ZERO);
				}
				count += bll.replace(answer);
			}
		}
		return SUCCESS;
	}

	// --------------------- GETTER / SETTER METHODS ---------------------
	public String getQuestionnaireID() {
		return questionnaireID;
	}

	public void setQuestionnaireID(String questionnaireID) {
		this.questionnaireID = questionnaireID;
	}

	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}

	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public int getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}
}
