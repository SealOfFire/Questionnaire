package questionnaire.web.action;

import com.opensymphony.xwork2.ActionSupport;

import questionnaire.bll.QuestionnaireBLL;
import questionnaire.web.model.Question;
import questionnaire.web.model.Questionnaire;

public class ExaminationAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	// localhost:8080/Questionnaire/ExaminationInit?questionnaireID=618f7ee9-8447-4244-9838-10770fc317ab
	private String questionnaireID = null;
	private Questionnaire questionnaire = null;

	public String init() {
		this.questionnaire = new QuestionnaireBLL().selectIncludeQuestions(this.questionnaireID);

		return SUCCESS;
	}

	public String save() {
		this.questionnaire = new QuestionnaireBLL().selectIncludeQuestions(this.questionnaireID);
		/*for (Question question : this.questionnaire.getQuestions()) {
			System.out.println(request.getParameter("questionID" + question.getQuestionID()));
		}
		for (int i = 0; i < s.length; i++) {

		}*/
		return SUCCESS;
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
}
