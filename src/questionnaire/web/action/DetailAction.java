package questionnaire.web.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import questionnaire.bll.AnswerBLL;
import questionnaire.bll.QuestionnaireBLL;
import questionnaire.bll.UserInfoBLL;
import questionnaire.web.model.Answer;
import questionnaire.web.model.Question;
import questionnaire.web.model.Questionnaire;
import questionnaire.web.model.UserInfo;

public class DetailAction extends ActionSupport {

	private static final long serialVersionUID = -8836922274793713498L;

	private String userID;
	private String questionnaireID;
	private Questionnaire questionnaire;
	private UserInfo userInfo;

	@Override
	public String execute() {
		this.userInfo = new UserInfoBLL().select(userID);

		this.questionnaire = new QuestionnaireBLL().selectIncludeQuestions(this.questionnaireID);
		ArrayList<Answer> answerList = new AnswerBLL().select(this.userID, this.questionnaireID);

		for (Question question : this.questionnaire.getQuestions()) {
			for (Answer answer : answerList) {
				if (question.getQuestionID().equals(answer.getQuestionID())) {
					question.setSelectedValue(answer.getAnswer());
				}
			}
		}

		return SUCCESS;
	}

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

	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}

	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

}
