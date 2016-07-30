package questionnaire.web.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import questionnaire.bll.OptionBLL;
import questionnaire.bll.QuestionBLL;
import questionnaire.web.model.Option;

/** 选项 */
public class OptionAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String questionID = null;
	private String optionID = null;
	private Option option = null;
	private ArrayList<Option> options = null;

	public String create() throws Exception {

		if (this.option != null)
			this.option.setQuestionID(this.questionID);

		this.option = new OptionBLL().insert(this.option);
		return SUCCESS;
	}

	public String delete() {
		new OptionBLL().delete(this.optionID);
		return SUCCESS;
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
}
