package questionnaire.bll;

import questionnaire.dal.AnswerDAL;
import questionnaire.dal.QuestionnairePartsDAL;
import questionnaire.web.model.Answer;

public class AnswerBLL {

	/** 答题进度 */
	public boolean[] answerProgress(String userID) {
		boolean[] result = { false, false, false };
		for (int i = 0; i < result.length; i++) {
			String questionnaireID = new QuestionnairePartsDAL().select(i);
			if (new AnswerDAL().selectCount(userID, questionnaireID) > 0) {
				result[i] = true;
			}
		}
		return result;
	}

	public boolean answerProgress(String userID, String questionnaireID) {
		if (new AnswerDAL().selectCount(userID, questionnaireID) > 0) {
			return true;
		} else {
			return false;
		}
	}

	public int replace(Answer answer) {
		return new AnswerDAL().replace(answer.getUserID(), answer.getQuestionnaireID(), answer.getQuestionID(),
				answer.getQptionID(), answer.getAnswer(), answer.getBeginDate(), answer.getEndDate(),
				answer.getScore());
	}
}
