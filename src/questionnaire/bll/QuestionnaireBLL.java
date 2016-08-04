package questionnaire.bll;

import java.util.ArrayList;
import java.util.UUID;

import questionnaire.dal.QuestionnaireDAL;
import questionnaire.web.model.Question;
import questionnaire.web.model.Questionnaire;

public class QuestionnaireBLL {

	public Questionnaire select(String questionnaireID) {
		Questionnaire questionnaire = new QuestionnaireDAL().select(questionnaireID);
		return questionnaire;
	}

	/**  */
	public Questionnaire selectIncludeQuestions(String questionnaireID) {
		Questionnaire questionnaire = new QuestionnaireDAL().select(questionnaireID);
		questionnaire.setQuestions(new QuestionBLL().selectList(questionnaire.getQuestionnaireID()));
		for (Question question : questionnaire.getQuestions()) {
			question.setOptions(new OptionBLL().selectList(question.getQuestionID()));
		}
		return questionnaire;
	}

	public ArrayList<Questionnaire> selectList() {
		return new QuestionnaireDAL().selectList();
	}

	public int delete(String questionnaireID) {
		return new QuestionnaireDAL().delete(questionnaireID);
	}

	/** 插入数据 */
	public Questionnaire insert(Questionnaire questionnaire) {
		questionnaire.setQuestionnaireID(UUID.randomUUID().toString());
		new QuestionnaireDAL().insert(questionnaire.getQuestionnaireID(), questionnaire.getTitle(),
				questionnaire.getDescription(), questionnaire.getTimeLimit(), questionnaire.getQuestionnaireType());
		return questionnaire;
	}

	/** 更新数据 */
	public Questionnaire update(Questionnaire questionnaire) {
		new QuestionnaireDAL().update(questionnaire.getQuestionnaireID(), questionnaire.getTitle(),
				questionnaire.getDescription(), questionnaire.getTimeLimit(), questionnaire.getQuestionnaireType());
		return questionnaire;
	}

	public int addQuestion(String questionnaireID, String questionID) {
		return new QuestionnaireDAL().addQuestion(questionnaireID, questionID);
	}

	public int deleteQuestion(String questionnaireID, String questionID) {
		return new QuestionnaireDAL().deleteQuestion(questionnaireID, questionID);
	}
}
