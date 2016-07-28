package questionnaire.web.model;

import java.util.UUID;

/** 问卷 */
public class Questionnaire {

	/** 问卷ID */
	private UUID questionnaireID;

	/** 问卷标题 */
	private String title;

	/** 答卷时限 */
	private int timeLimit;

	/** 类型(性格测试/坐席素质) */
	private QuestionnaireType questionnaireType;

	public Questionnaire() {
	}

	public Questionnaire(String title, int timeLimit, QuestionnaireType questionnaireType) {
		this.questionnaireID = UUID.randomUUID();
		this.title = title;
		this.timeLimit = timeLimit;
		this.questionnaireType = questionnaireType;
	}

	public UUID getQuestionnaireID() {
		return questionnaireID;
	}

	public void setQuestionnaireID(UUID questionnaireID) {
		this.questionnaireID = questionnaireID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}

	public QuestionnaireType getQuestionnaireType() {
		return questionnaireType;
	}

	public void setQuestionnaireType(QuestionnaireType questionnaireType) {
		this.questionnaireType = questionnaireType;
	}
}
