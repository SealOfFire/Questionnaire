package questionnaire.bll;

import questionnaire.dal.QuestionDAL;
import questionnaire.dal.QuestionnaireDAL;
import questionnaire.dal.QuestionnairePartsDAL;
import questionnaire.dal.TypewriteDAL;
import questionnaire.web.model.Question;
import questionnaire.web.model.Questionnaire;
import questionnaire.web.model.Typewrite;

public class QuestionnairePartsBLL {

	/**  */
	public int updatePart1(String questionnaireID) {
		return new QuestionnairePartsDAL().update(questionnaireID, 0);
	}

	/**  */
	public int updatePart2(String questionnaireID) {
		return new QuestionnairePartsDAL().update(questionnaireID, 1);
	}

	/**  */
	public int updatePart3(String questionID) {
		return new QuestionnairePartsDAL().update(questionID, 2);
	}

	/**  */
	public Questionnaire selectPart1() {
		String questionnaireID = new QuestionnairePartsDAL().select(0);
		Questionnaire questionnaire = new QuestionnaireDAL().select(questionnaireID);
		questionnaire.setQuestions(new QuestionBLL().selectList(questionnaire.getQuestionnaireID()));
		for (Question question : questionnaire.getQuestions()) {
			question.setOptions(new OptionBLL().selectList(question.getQuestionID()));
		}
		return questionnaire;
	}

	/**  */
	public Questionnaire selectPart2() {
		String questionnaireID = new QuestionnairePartsDAL().select(1);
		Questionnaire questionnaire = new QuestionnaireDAL().select(questionnaireID);
		questionnaire.setQuestions(new QuestionBLL().selectList(questionnaire.getQuestionnaireID()));
		for (Question question : questionnaire.getQuestions()) {
			question.setOptions(new OptionBLL().selectList(question.getQuestionID()));
		}
		return questionnaire;
	}

	/**  */
	public Typewrite selectPart3() {
		String questionnaireID = new QuestionnairePartsDAL().select(2);
		Typewrite typewrite = new TypewriteDAL().select(questionnaireID);
		return typewrite;
	}
}
