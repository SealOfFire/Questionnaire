package questionnaire.web.action;

import com.opensymphony.xwork2.ActionSupport;

public class TypewriteAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private String comments = null;

	public String list() throws Exception {

		return SUCCESS;
	}

	public String save() throws Exception {

		return SUCCESS;
	}

	public String edit() throws Exception {

		return SUCCESS;
	}

	public String create() throws Exception {

		return SUCCESS;
	}

	public String delete() {
		return SUCCESS;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
}