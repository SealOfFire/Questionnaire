package questionnaire.web.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import questionnaire.bll.OptionBLL;
import questionnaire.bll.QuestionBLL;
import questionnaire.web.enumeration.QuestionnaireType;
import questionnaire.web.model.ListItem;
import questionnaire.web.model.Option;
import questionnaire.web.model.Question;

/** 问题 */
public class QuestionAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String questionID = null;
	private Question question = null;
	private ArrayList<Question> questions = null;
	private ArrayList<ListItem> ddlQuestionType = null;
	private Option option = null;
	private ArrayList<Option> options = null;

	/** 获取所有问题 */
	public String getList() throws Exception {
		// 查询所有问题
		this.questions = new QuestionBLL().selectAll();
		return SUCCESS;
	}

	/** 保存 */
	public String save() throws Exception {
		this.initDropDownList();
		if (this.question.notSaved()) {
			// 保存到数据库
			this.question = new QuestionBLL().insert(this.question);
			this.questionID = this.question.getQuestionID();
		} else {
			// 编辑
			this.question = new QuestionBLL().update(this.question);
			this.questionID = this.question.getQuestionID();
		}

		return SUCCESS;
	}

	/** 编辑问题 */
	public String edit() throws Exception {
		// 初始化下拉框数据
		this.initDropDownList();

		// 获取问题数据
		this.question = new QuestionBLL().select(this.questionID);

		//
		this.options = new OptionBLL().selectList(this.questionID);
		return SUCCESS;
	}

	/** 新建 */
	public String create() throws Exception {
		this.initDropDownList();
		this.questionID = null;
		return SUCCESS;
	}

	/** 删除问题 */
	public String delete() {
		new QuestionBLL().delete(this.questionID);
		return SUCCESS;
	}

	/** 初始化下拉框的值 */
	private void initDropDownList() {
		this.ddlQuestionType = new ArrayList<ListItem>();
		this.ddlQuestionType.add(new ListItem(QuestionnaireType.TemperamentTest, "性格测试"));
		this.ddlQuestionType.add(new ListItem(QuestionnaireType.SeatQuality, "坐席素质"));
	}

	public String getQuestionID() {
		return questionID;
	}

	public void setQuestionID(String questionID) {
		this.questionID = questionID;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public ArrayList<ListItem> getDdlQuestionType() {
		return ddlQuestionType;
	}

	public void setDdlQuestionType(ArrayList<ListItem> ddlQuestionType) {
		this.ddlQuestionType = ddlQuestionType;
	}

	public ArrayList<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(ArrayList<Question> questions) {
		this.questions = questions;
	}

	public Option getOption() {
		return option;
	}

	public void setOption(Option option) {
		this.option = option;
	}

	public ArrayList<Option> getOptions() {
		return options;
	}

	public void setOptions(ArrayList<Option> options) {
		this.options = options;
	}

}
