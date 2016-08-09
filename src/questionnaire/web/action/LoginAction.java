package questionnaire.web.action;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private String userName = null;
	private String password = null;

	public String login() {
		if (this.userName.equals(this.password) && this.userName.equals("admin"))
			return LOGIN;
		else
			return ERROR;
	}

	/**  */
	@Override
	public void validate() {
		if (!this.userName.equals(this.password) || !this.userName.equals("admin"))
			addFieldError("userName", "用户名或密码错误");
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
