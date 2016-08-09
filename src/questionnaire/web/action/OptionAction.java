package questionnaire.web.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import questionnaire.bll.OptionBLL;
import questionnaire.web.enumeration.QuestionnaireType;
import questionnaire.web.model.ListItem;
import questionnaire.web.model.Option;
import questionnaire.web.model.Question;

/** 选项 */
public class OptionAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String questionID = null;
	private String optionID = null;
	private Option option = null;
	private Question question = null;
	private ArrayList<Option> options = null;
	private ArrayList<ListItem> ddlQuestionType = null;

	public String create() throws Exception {

		if (this.option != null)
			this.option.setQuestionID(this.questionID);

		this.option = new OptionBLL().insert(this.option);
		return SUCCESS;
	}

	/*
	 * public void validateCreate() { this.initDropDownList(); this.options =
	 * new OptionBLL().selectList(this.questionID); addFieldError("errmsg2",
	 * "时限的格式不正确"); }
	 */

	public String delete() {
		new OptionBLL().delete(this.optionID);
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

	public String getOptionID() {
		return optionID;
	}

	public void setOptionID(String optionID) {
		this.optionID = optionID;
	}

	public ArrayList<ListItem> getDdlQuestionType() {
		return ddlQuestionType;
	}

	public void setDdlQuestionType(ArrayList<ListItem> ddlQuestionType) {
		this.ddlQuestionType = ddlQuestionType;
	}

}
