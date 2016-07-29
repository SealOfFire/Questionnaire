package questionnaire.dal;

import java.util.UUID;

import questionnaire.web.model.Questionnaire;

/** 问卷数据库操作 */
public class QuestionnaireDAL {

	private static final String INSERT01 = "inset into ";
	private static final String UPDATE01 = "update ";
	private static final String DELETE01 = "";
	private static final String SELECT01 = "";

	/** 问卷插入到数据库 */
	public int insert(Questionnaire questionnaire) {
		return 0;
	}

	/** 添加问题 */
	public int insertQuestion(UUID questionnaireID, UUID questionID) {
		return 0;
	}

	/** 删除问题 */
	public int deleteQuestion(UUID questionnaireID, UUID questionID) {
		return 0;
	}

	/** 删除问卷 */
	public int delete(UUID questionnaireID) {
		return 0;
	}

	/** 问卷更新 */
	public int update(Questionnaire questionnaire) {
		return 0;
	}

	/** 查找问卷 */
	public void select(UUID questionnaireID) {

	}
}
