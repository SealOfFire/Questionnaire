package questionnaire.web.action;

import com.opensymphony.xwork2.ActionSupport;

public class QuestionAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	/** 获取所有问题 */
	public String getList() throws Exception {

		return SUCCESS;
	}
}
