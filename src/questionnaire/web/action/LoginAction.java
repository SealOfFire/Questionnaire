package questionnaire.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import questionnaire.bll.AdministratorBLL;

public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private String userName = null;
	private String password = null;

	public String login() {
		if (new AdministratorBLL().login(this.userName, this.password)) {
			ActionContext.getContext().getSession().put("user", this.userName);
			ActionContext.getContext().getSession().put("pass", this.password);
		} else {
			addFieldError("userName", "用户名或密码错误");
			return INPUT;
		}
		return LOGIN;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
