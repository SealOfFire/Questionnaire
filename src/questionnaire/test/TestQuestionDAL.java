package questionnaire.test;

import java.util.UUID;

import org.junit.Test;

import questionnaire.dal.QuestionDAL;
import questionnaire.web.model.Question;

public class TestQuestionDAL {

	@Test
	public void testInsert() {
		new QuestionDAL().insert(UUID.randomUUID().toString(), "问题一", "作息素质");
	}

	@Test
	public void testUpdate() {
		new QuestionDAL().update("4db1d750-55a1-11e6-9b47-14dae927c846", "aaa一", "bbb素质");
	}
}
