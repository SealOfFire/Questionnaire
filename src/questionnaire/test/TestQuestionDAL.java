package questionnaire.test;

import org.junit.Test;

import questionnaire.dal.QuestionDAL;
import questionnaire.web.model.Question;

public class TestQuestionDAL {

	@Test
	public void testInsert() {
		Question question = new Question();
		new QuestionDAL().insert(question);
	}
}
