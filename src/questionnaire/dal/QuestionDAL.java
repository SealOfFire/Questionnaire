package questionnaire.dal;

import questionnaire.web.model.Questionnaire;

public class QuestionDAL {

	private static final String INSERT01 = "inset into Question(QuestionID,QuestionCategory,Caption,QuestionType) values(uuid(),?,?,?)";
	private static final String UPDATE01 = "update Question set QuestionCategory=?,Caption=?,QuestionType=?";
	private static final String DELETE01 = "delete from Question where QuestionID=?";
	private static final String SELECT01 = "select QuestionID,QuestionCategory,Caption,QuestionType from Question";

	/** 问卷插入到数据库 */
	public int insert(Questionnaire questionnaire) {
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

	/** 问卷更新 */
	public int update(Questionnaire questionnaire) {
		return 0;
	}

	/** 查找问卷 */
	public void select(String questionnaireID) {

	}

	/** 查找问卷 */
	public void selectList() {

	}
}
