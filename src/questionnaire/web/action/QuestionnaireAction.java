package questionnaire.web.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import questionnaire.web.enumeration.QuestionnaireType;
import questionnaire.web.model.ListItem;
import questionnaire.web.model.Questionnaire;

public class QuestionnaireAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String questionnaireID = null;
	private Questionnaire questionnaire = null;
	private ArrayList<Questionnaire> questionnaires = null;
	private ArrayList<ListItem> ddlQuestionnaireType = null;
	// private Map<String, String> ddlQuestionnaireType = null;

	/** 获取所有问卷 */
	public String getList() throws Exception {

		this.questionnaires = new ArrayList<Questionnaire>();
		this.questionnaires.add(new Questionnaire("title1", 1, QuestionnaireType.TemperamentTest));
		this.questionnaires.add(new Questionnaire("title2", 2, QuestionnaireType.SeatQuality));
		this.questionnaires.add(new Questionnaire("title3", 3, QuestionnaireType.TemperamentTest));

		return SUCCESS;
	}

	/** 创建问卷 */
	public String create() throws Exception {
		this.questionnaireID = null;
		this.initDDLQuestionnaireType();
		return SUCCESS;
	}

	/** 编辑问卷 */
	public String edit() throws Exception {
		this.initDDLQuestionnaireType();
		if (this.questionnaireID == null) {
			// 创建问卷

			// 问卷信息保存到数据库
			
		} else {
			// 编辑问卷

		}

		return SUCCESS;
	}

	/** 删除问卷 */
	public String delete() throws Exception {

		return SUCCESS;
	}

	/** 初始化下拉框的值 */
	private void initDDLQuestionnaireType() {
		this.ddlQuestionnaireType = new ArrayList<ListItem>();
		this.ddlQuestionnaireType.add(new ListItem(QuestionnaireType.TemperamentTest));
		this.ddlQuestionnaireType.add(new ListItem(QuestionnaireType.SeatQuality));

		// this.ddlQuestionnaireType = new HashMap<String, String>();
		// this.ddlQuestionnaireType.put("TemperamentTest", "性格测试");
		// this.ddlQuestionnaireType.put("SeatQuality", "坐席素质");
	}

	public String getQuestionnaireID() {
		return questionnaireID;
	}

	public void setQuestionnaireID(String questionnaireID) {
		this.questionnaireID = questionnaireID;
	}

	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}

	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}

	public ArrayList<Questionnaire> getQuestionnaires() {
		return questionnaires;
	}

	public void setQuestionnaires(ArrayList<Questionnaire> questionnaires) {
		this.questionnaires = questionnaires;
	}

	public ArrayList<ListItem> getDdlQuestionnaireType() {
		return ddlQuestionnaireType;
	}

	public void setDdlQuestionnaireType(ArrayList<ListItem> ddlQuestionnaireType) {
		this.ddlQuestionnaireType = ddlQuestionnaireType;
	}

}
