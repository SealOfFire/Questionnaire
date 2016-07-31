package questionnaire.bll;

import java.util.ArrayList;
import java.util.UUID;

import questionnaire.dal.QuestionDAL;
import questionnaire.web.model.Question;

public class QuestionBLL {

	public Question select(String questionID) {
		Question question = new QuestionDAL().select(questionID);
		return question;
	}

	public ArrayList<Question> selectList(String questionnaireID) {
		return new QuestionDAL().selectList(questionnaireID);
	}

	public ArrayList<Question> selectList() {
		return new QuestionDAL().selectList();
	}

	public ArrayList<Question> selectNotAddList(String questionnaireID) {
		return new QuestionDAL().selectNotAddList(questionnaireID);
	}

	public int delete(String questionID) {
		return new QuestionDAL().delete(questionID);
	}

	/** 插入数据 */
	public Question insert(Question question) {
		question.setQuestionID(UUID.randomUUID().toString());
		new QuestionDAL().insert(question.getQuestionID(), question.getCaption(), question.getQuestionType());
		return question;
	}

	/** 更新数据 */
	public Question update(Question question) {
		new QuestionDAL().update(question.getQuestionID(), question.getCaption(), question.getQuestionType());
		return question;
	}
}
