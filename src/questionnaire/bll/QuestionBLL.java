package questionnaire.bll;

import java.util.ArrayList;

import questionnaire.web.enumeration.QuestionType;
import questionnaire.web.model.Question;

public class QuestionBLL {

	public Question select(String questionID) {
		// TODO
		Question question = new Question();
		question.setQuestionID(questionID);
		return question;
	}

	public ArrayList<Question> selectAll() {
		// TODO
		ArrayList<Question> questions = new ArrayList<Question>();
		questions.add(new Question("title1", QuestionType.TemperamentTest));
		questions.add(new Question("title2", QuestionType.SeatQuality));
		questions.add(new Question("title3", QuestionType.TemperamentTest));

		return questions;
	}

	public Question insert(Question question) {
		// TODO
		return question;
	}

	public Question update(Question question) {
		// TODO
		return question;
	}
}
