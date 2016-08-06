package questionnaire.web.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import questionnaire.bll.AnswerBLL;
import questionnaire.bll.UserInfoBLL;
import questionnaire.web.model.ListItem;
import questionnaire.web.model.UserInfo;

public class AnswerAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private UserInfo userInfo = null;
	private String userID = null;
	private ArrayList<ListItem> ddlSex = null;

	public String initAnswer() {
		this.initDropDownList();
		return SUCCESS;
	}

	public String register() {
		// 答题进度
		boolean[] answerProgress = { false, false, false };
		UserInfoBLL userInfoBll = new UserInfoBLL();
		// 查找用户信息
		UserInfo selectedUserInfo = userInfoBll.select(this.userInfo.getName(), this.userInfo.getIDCardNumber());
		if (selectedUserInfo.notSaved()) {
			// 不存在
			// 保存用户信息
			selectedUserInfo = userInfoBll.insert(this.userInfo);
		} else {
			// 已存在,查看答题进度
			answerProgress = new AnswerBLL().answerProgress(selectedUserInfo.getUserID());
		}
		// 用户信息添加到session
		// ActionContext.getContext().getSession().put("userInfo",
		// selectedUserInfo);
		this.userID = selectedUserInfo.getUserID();

		if (!answerProgress[0] || !answerProgress[1]) {// 跳到选择题
			return "select";
		} else if (!answerProgress[2]) {
			// 跳到打字题
			return "typewrite";
		} else {
			// 所有题都已经答完
		}

		// 开始答题
		return SUCCESS;
	}

	private void initDropDownList() {
		this.ddlSex = new ArrayList<ListItem>();
		this.ddlSex.add(new ListItem("male", "男"));
		this.ddlSex.add(new ListItem("female", "女"));
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public ArrayList<ListItem> getDdlSex() {
		return ddlSex;
	}

	public void setDdlSex(ArrayList<ListItem> ddlSex) {
		this.ddlSex = ddlSex;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
}
