package questionnaire.dal;

import java.util.ArrayList;

import questionnaire.web.model.Question;
import questionnaire.web.model.Questionnaire;

public class QuestionDAL extends BaseDAL {

	private static final String INSERT01 = "insert into Question(QuestionID,QuestionCategory,Caption,QuestionType) values(uuid(),?,?,?)";
	private static final String UPDATE01 = "update Question set QuestionCategory=?,Caption=?,QuestionType=? where QuestionID=?";
	private static final String DELETE01 = "delete from Question where QuestionID=?";
	private static final String SELECT01 = "select QuestionID,QuestionCategory,Caption,QuestionType from Question";

	/** 问卷插入到数据库 */
	public int insert(Question question) {
		ArrayList<Object> parameters = new ArrayList<Object>();
		// parameters.add(question.getQuestionID());
		parameters.add("QuestionCategory");
		parameters.add(question.getCaption());
		parameters.add(question.getQuestionType());
		String id = this.modify(INSERT01, parameters.toArray());
		return 0;
	}

	/** 问卷更新 */
	public int update(Question question) {
		ArrayList<Object> parameters = new ArrayList<Object>();
		parameters.add("QuestionCategory");
		parameters.add(question.getCaption());
		parameters.add(question.getQuestionType());
		parameters.add(question.getQuestionID());
		String id = this.modify(UPDATE01, parameters.toArray());
		return 0;
	}

	/** 添加问题 */
	public int insertQuestion(String questionnaireID, String questionID) {
		return 0;
	}

	/** 删除问题 */
	public int deleteQuestion(String questionnaireID, String questionID) {
		return 0;
	}

	/** 删除问卷 */
	public int delete(String questionnaireID) {
		return 0;
	}

	/** 查找问卷 */
	public void select(String questionnaireID) {

	}

	/** 查找问卷 */
	public void selectList() {

	}
}
