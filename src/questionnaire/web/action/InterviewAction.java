package questionnaire.web.action;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import questionnaire.bll.AnswerBLL;
import questionnaire.bll.InterviewBLL;
import questionnaire.bll.OptionBLL;
import questionnaire.bll.UserInfoBLL;
import questionnaire.web.model.Answer;
import questionnaire.web.model.Interview;
import questionnaire.web.model.UserInfo;

public class InterviewAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private String userID = null;
	private ArrayList<UserInfo> userInfos = null;
	private ArrayList<Interview> interviews = null;
	private String overall = null;

	public String list() throws Exception {
		this.userInfos = new UserInfoBLL().selectList();
		return SUCCESS;
	}

	public String save() {
		int count = 0;
		AnswerBLL bll = new AnswerBLL();
		HttpServletRequest request = ServletActionContext.getRequest();
		this.interviews = new InterviewBLL().selectList();
		for (Interview interview : this.interviews) {
			String strScore = request.getParameter(interview.getQuestionID());
			BigDecimal score = new BigDecimal(strScore);
			Answer answer = new Answer();
			answer.setUserID(this.userID);
			answer.setQuestionnaireID("00000000-0000-0000-0000-000000000000");
			answer.setQuestionID(interview.getQuestionID());
			answer.setOptionID(interview.getQuestionID());
			answer.setAnswer(strScore);
			answer.setBeginDate(new Date(new java.util.Date().getTime()));
			answer.setEndDate(new Date(new java.util.Date().getTime()));
			answer.setScore(score);
			count += bll.replace(answer);
		}
		// 总评
		Answer answer = new Answer();
		answer.setUserID(this.userID);
		answer.setQuestionnaireID("00000000-0000-0000-0000-000000000000");
		answer.setQuestionID("00000000-0000-0000-0000-000000000000");
		answer.setOptionID("00000000-0000-0000-0000-000000000000");
		answer.setAnswer(this.overall);
		answer.setBeginDate(new Date(new java.util.Date().getTime()));
		answer.setEndDate(new Date(new java.util.Date().getTime()));
		answer.setScore(new BigDecimal(0));
		count += bll.replace(answer);

		return SUCCESS;
	}

	public String score() {
		this.interviews = new InterviewBLL().selectList();
		ArrayList<Answer> answers = new AnswerBLL().select(this.userID, "00000000-0000-0000-0000-000000000000");

		for (Interview interview : this.interviews) {
			for (Answer answer : answers) {
				if (interview.getQuestionID().equals(answer.getQuestionID())) {
					interview.setScore(answer.getScore());
				}
				if (answer.getQuestionID().equals("00000000-0000-0000-0000-000000000000")) {
					this.overall = answer.getAnswer();
				}
			}
		}
		return SUCCESS;
	}

	/**  */
	public void validateSave() {
		HttpServletRequest request = ServletActionContext.getRequest();
		this.interviews = new InterviewBLL().selectList();
		ArrayList<Answer> answers = new AnswerBLL().select(this.userID, "00000000-0000-0000-0000-000000000000");
		for (Interview interview : this.interviews) {
			String strScore = request.getParameter(interview.getQuestionID());
			try {
				BigDecimal score = new BigDecimal(strScore);
			} catch (Exception e) {
				addFieldError("errmsg", "分数不是数值类型");
			}
			for (Answer answer : answers) {
				if (interview.getQuestionID().equals(answer.getQuestionID())) {
					interview.setScore(answer.getScore());
				}
				if (answer.getQuestionID().equals("00000000-0000-0000-0000-000000000000")) {
					// this.overall = answer.getAnswer();
				}
			}
		}
		if (this.overall.length() >= 500)
			addFieldError("errmsg", "综合评价不能超过500字");
	}

	public String delete() {
		new UserInfoBLL().delete(this.userID);
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

	public String getOverall() {
		return overall;
	}

	public void setOverall(String overall) {
		this.overall = overall;
	}
}
