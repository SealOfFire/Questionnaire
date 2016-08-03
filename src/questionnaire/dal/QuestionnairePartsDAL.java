package questionnaire.dal;

import java.util.ArrayList;

public class QuestionnairePartsDAL extends BaseDAL {
	private final static String SELECE01 = "select * from QuestionnaireParts where Sort=?";
	private final static String UPDATE01 = "update QuestionnaireParts QuestionnaireID=? set where Sort=?";

	public int update(String questionnaireID, int sort) {
		ArrayList<Object> parameters = new ArrayList<Object>();
		parameters.add(questionnaireID);
		parameters.add(sort);
		return this.modify(UPDATE01, parameters.toArray());
	}

	public String select(int sort) {
		return "";
	}
}
