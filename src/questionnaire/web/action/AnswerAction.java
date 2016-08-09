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
	private ArrayList<ListItem> ddlArea = null;

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
		} else if (answerProgress[2]) {
			// 所有题都已经答完
			return "finish";
		}

		// 开始答题
		return SUCCESS;
	}

	private void initDropDownList() {
		this.ddlSex = new ArrayList<ListItem>();
		this.ddlSex.add(new ListItem("male", "男"));
		this.ddlSex.add(new ListItem("female", "女"));

		this.ddlArea = new ArrayList<ListItem>();
		this.ddlArea.add(new ListItem("北区中心", "北区中心"));
		this.ddlArea.add(new ListItem("西区中心", "西区中心"));
		this.ddlArea.add(new ListItem("中原中心", "中原中心"));
		this.ddlArea.add(new ListItem("南区中心", "南区中心"));
		this.ddlArea.add(new ListItem("互联网客服中心", "互联网客服中心"));
		this.ddlArea.add(new ListItem("客户回访中心", "客户回访中心"));
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

	public ArrayList<ListItem> getDdlArea() {
		return ddlArea;
	}

	public void setDdlArea(ArrayList<ListItem> ddlArea) {
		this.ddlArea = ddlArea;
	}
}
