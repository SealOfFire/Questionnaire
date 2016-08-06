package questionnaire.bll;

import questionnaire.dal.AnswerDAL;
import questionnaire.dal.QuestionnairePartsDAL;

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
}
