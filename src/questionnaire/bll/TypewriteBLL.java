package questionnaire.bll;

import java.util.ArrayList;
import java.util.UUID;

import questionnaire.dal.TypewriteDAL;
import questionnaire.web.model.Typewrite;

public class TypewriteBLL {
	public Typewrite select(String questionID) {
		Typewrite typewrite = new TypewriteDAL().select(questionID);
		return typewrite;
	}

	public ArrayList<Typewrite> selectList() {
		return new TypewriteDAL().selectList();
	}

	public int delete(String questionID) {
		return new TypewriteDAL().delete(questionID);
	}

	public Typewrite insert(Typewrite typewrite) {
		typewrite.setQuestionID(UUID.randomUUID().toString());
		new TypewriteDAL().insert(typewrite.getQuestionID(), typewrite.getTitle(), typewrite.getCaptionText(),
				typewrite.getCaptionImage(), typewrite.getTimeLimit());
		return typewrite;
	}

	public Typewrite update(Typewrite typewrite) {
		new TypewriteDAL().update(typewrite.getQuestionID(), typewrite.getTitle(), typewrite.getCaptionText(),
				typewrite.getCaptionImage(), typewrite.getTimeLimit());
		return typewrite;
	}
}