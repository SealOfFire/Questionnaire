package questionnaire.web.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import questionnaire.bll.OptionBLL;
import questionnaire.bll.QuestionBLL;
import questionnaire.bll.QuestionnaireBLL;
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
		this.questionnaires = new QuestionnaireBLL().selectList();
		return SUCCESS;
	}

	/** 创建问卷 */
	public String create() throws Exception {
		this.questionnaireID = null;
		this.initDropDownList();
		return SUCCESS;
	}

	/** 编辑问卷 */
	public String save() throws Exception {
		this.initDropDownList();
		if (this.questionnaire.notSaved()) {
			// 保存到数据库
			this.questionnaire = new QuestionnaireBLL().insert(this.questionnaire);
			this.questionnaireID = this.questionnaire.getQuestionnaireID();
		} else {
			// 编辑
			this.questionnaire = new QuestionnaireBLL().update(this.questionnaire);
			this.questionnaireID = this.questionnaire.getQuestionnaireID();
		}

		return SUCCESS;
	}

	/** 编辑问题 */
	public String edit() throws Exception {
		// 初始化下拉框数据
		this.initDropDownList();
		// 获取问题数据
		this.questionnaire = new QuestionnaireBLL().select(this.questionnaireID);
		return SUCCESS;
	}

	/** 删除问卷 */
	public String delete() throws Exception {
		new QuestionnaireBLL().delete(this.questionnaireID);
		return SUCCESS;
	}

	/** 初始化下拉框的值 */
	private void initDropDownList() {
		this.ddlQuestionnaireType = new ArrayList<ListItem>();
		this.ddlQuestionnaireType.add(new ListItem(QuestionnaireType.TemperamentTest, "性格测试"));
		this.ddlQuestionnaireType.add(new ListItem(QuestionnaireType.SeatQuality, "坐席素质"));

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
