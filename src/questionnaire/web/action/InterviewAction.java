package questionnaire.web.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import questionnaire.bll.InterviewBLL;
import questionnaire.bll.UserInfoBLL;
import questionnaire.web.model.Interview;
import questionnaire.web.model.UserInfo;

public class InterviewAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private String userID = null;
	private ArrayList<UserInfo> userInfos = null;
	private ArrayList<Interview> interviews = null;

	public String list() throws Exception {
		this.userInfos = new UserInfoBLL().selectList();
		return SUCCESS;
	}

	public String score() {

		this.interviews = new InterviewBLL().selectList();
		return SUCCESS;
	}

	public ArrayList<UserInfo> getUserInfos() {
		return userInfos;
	}

	public void setUserInfos(ArrayList<UserInfo> userInfos) {
		this.userInfos = userInfos;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public ArrayList<Interview> getInterviews() {
		return interviews;
	}

	public void setInterviews(ArrayList<Interview> interviews) {
		this.interviews = interviews;
	}
}
