package questionnaire.bll;

import java.util.ArrayList;

import questionnaire.dal.InterviewDAL;
import questionnaire.web.model.Interview;

public class InterviewBLL {

	/**  */
	public ArrayList<Interview> selectList() {
		return new InterviewDAL().selectList();
	}
}
