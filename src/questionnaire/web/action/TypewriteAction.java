package questionnaire.web.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import questionnaire.bll.QuestionBLL;
import questionnaire.bll.TypewriteBLL;
import questionnaire.web.model.Typewrite;

public class TypewriteAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private String questionID = null;
	private String comments = null;
	private String hidImg = null;
	private Typewrite typewrite = null;
	private ArrayList<Typewrite> typewrites = null;

	public String list() throws Exception {
		this.typewrites = new TypewriteBLL().selectList();
		return SUCCESS;
	}

	public String save() throws Exception {
		if (this.typewrite.notSaved()) {
			// 保存到数据库
			this.typewrite = new TypewriteBLL().insert(this.typewrite);
			this.questionID = this.typewrite.getQuestionID();
		} else {
			// 编辑
			this.typewrite = new TypewriteBLL().update(this.typewrite);
			this.questionID = this.typewrite.getQuestionID();
		}

		return SUCCESS;
	}

	public void validateSave() {
		if (this.typewrite.getTimeLimit() == 0)
			addFieldError("errmsg", "时限的格式不正确");
	}

	public String edit() throws Exception {
		this.typewrite = new TypewriteBLL().select(this.questionID);
		return SUCCESS;
	}

	public String create() throws Exception {
		this.questionID = null;
		return SUCCESS;
	}

	public String delete() {
		new QuestionBLL().delete(this.questionID);
		return SUCCESS;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getHidImg() {
		return hidImg;
	}

	public void setHidImg(String hidImg) {
		this.hidImg = hidImg;
	}

	public Typewrite getTypewrite() {
		return typewrite;
	}

	public void setTypewrite(Typewrite typewrite) {
		this.typewrite = typewrite;
	}

	public ArrayList<Typewrite> getTypewrites() {
		return typewrites;
	}

	public void setTypewrites(ArrayList<Typewrite> typewrites) {
		this.typewrites = typewrites;
	}

	public String getQuestionID() {
		return questionID;
	}

	public void setQuestionID(String questionID) {
		this.questionID = questionID;
	}
}