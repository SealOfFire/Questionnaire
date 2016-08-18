package questionnaire.web.action;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import questionnaire.bll.AnswerBLL;
import questionnaire.bll.InterviewBLL;
import questionnaire.bll.UserInfoBLL;
import questionnaire.web.model.Answer;
import questionnaire.web.model.Interview;
import questionnaire.web.model.ListItem;
import questionnaire.web.model.UserInfo;
import questionnaire.web.model.UserInfoQuery;

public class InterviewAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private String userID = null;
	private ArrayList<UserInfo> userInfos = null;
	private ArrayList<Interview> interviews = null;
	private String overall = null;
	private String score5 = null;

	private ArrayList<ListItem> ddlArea = null;
	private ArrayList<ListItem> ddlFrom = null;

	private UserInfoQuery userInfoQuery;

	public String list() throws Exception {
		this.initDropDownList();

		// 初始时间
		Calendar calendarStart = Calendar.getInstance();
		Calendar calendarEnd = Calendar.getInstance();
		calendarStart.setTime(new java.util.Date());
		calendarStart.set(Calendar.DAY_OF_MONTH, calendarStart.get(Calendar.DAY_OF_MONTH) - 7);
		calendarStart.set(Calendar.HOUR_OF_DAY, 0);
		calendarStart.set(Calendar.MINUTE, 0);
		calendarStart.set(Calendar.SECOND, 0);
		calendarEnd.setTime(new java.util.Date());
		calendarEnd.set(Calendar.HOUR_OF_DAY, 23);
		calendarEnd.set(Calendar.MINUTE, 59);
		calendarEnd.set(Calendar.SECOND, 59);

		if (this.userInfoQuery == null) {
			this.userInfoQuery = new UserInfoQuery();

			this.userInfoQuery.startDate = new Date(calendarStart.getTime().getTime());
			this.userInfoQuery.endDate = new Date(calendarEnd.getTime().getTime());
		} else {
			if (this.userInfoQuery.startDate == null) {
				this.userInfoQuery.startDate = new Date(calendarStart.getTime().getTime());
			}
			if (this.userInfoQuery.endDate == null) {
				this.userInfoQuery.endDate = new Date(calendarEnd.getTime().getTime());
			}
		}

		calendarStart.setTime((java.util.Date) this.userInfoQuery.startDate);
		calendarStart.set(Calendar.HOUR_OF_DAY, 0);
		calendarStart.set(Calendar.MINUTE, 0);
		calendarStart.set(Calendar.SECOND, 0);
		this.userInfoQuery.startDate = new Date(calendarStart.getTime().getTime());
		calendarEnd.setTime((java.util.Date) this.userInfoQuery.endDate);
		calendarEnd.set(Calendar.HOUR_OF_DAY, 23);
		calendarEnd.set(Calendar.MINUTE, 59);
		calendarEnd.set(Calendar.SECOND, 59);
		this.userInfoQuery.endDate = new Date(calendarEnd.getTime().getTime());

		this.userInfos = new UserInfoBLL().selectList(this.userInfoQuery);
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

		// 岗前通关得分
		// 总评
		BigDecimal val = new BigDecimal(0);
		try {
			val = new BigDecimal(this.score5);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Answer answer = new Answer();
		answer.setUserID(this.userID);
		answer.setQuestionnaireID("00000000-0000-0000-0000-000000000001");
		answer.setQuestionID("00000000-0000-0000-0000-000000000000");
		answer.setOptionID("00000000-0000-0000-0000-000000000000");
		answer.setAnswer(this.overall);
		answer.setBeginDate(new Date(new java.util.Date().getTime()));
		answer.setEndDate(new Date(new java.util.Date().getTime()));
		answer.setScore(val);
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

		ArrayList<Answer> answers2 = new AnswerBLL().select(this.userID, "00000000-0000-0000-0000-000000000001");
		for (Answer answer : answers2) {
			this.overall = answer.getAnswer();
			this.score5 = answer.getScore().toString();
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
			}
		}

		try {
			BigDecimal score = new BigDecimal(this.score5);
		} catch (Exception e) {
			addFieldError("errmsg", "通关分数不是数值类型");
		}

		if (this.overall.length() >= 500)
			addFieldError("errmsg", "综合评价不能超过500字");
	}

	public String delete() {
		new UserInfoBLL().delete(this.userID);
		return SUCCESS;
	}

	private void initDropDownList() {
		this.ddlArea = new ArrayList<ListItem>();
		this.ddlArea.add(new ListItem("", ""));
		this.ddlArea.add(new ListItem("北区中心", "北区中心"));
		this.ddlArea.add(new ListItem("西区中心", "西区中心"));
		this.ddlArea.add(new ListItem("中原中心", "中原中心"));
		this.ddlArea.add(new ListItem("南区中心", "南区中心"));
		this.ddlArea.add(new ListItem("互联网客服中心", "互联网客服中心"));
		this.ddlArea.add(new ListItem("客户回访中心", "客户回访中心"));

		this.ddlFrom = new ArrayList<ListItem>();
		this.ddlFrom.add(new ListItem("", ""));
		this.ddlFrom.add(new ListItem("社会招聘", "社会招聘"));
		this.ddlFrom.add(new ListItem("校园招聘", "校园招聘"));
		this.ddlFrom.add(new ListItem("中介渠道", "中介渠道"));
		this.ddlFrom.add(new ListItem("内部推荐", "内部推荐"));
		this.ddlFrom.add(new ListItem("机构推荐", "机构推荐"));
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

	public String getScore5() {
		return score5;
	}

	public void setScore5(String score5) {
		this.score5 = score5;
	}

	public ArrayList<ListItem> getDdlArea() {
		return ddlArea;
	}

	public void setDdlArea(ArrayList<ListItem> ddlArea) {
		this.ddlArea = ddlArea;
	}

	public ArrayList<ListItem> getDdlFrom() {
		return ddlFrom;
	}

	public void setDdlFrom(ArrayList<ListItem> ddlFrom) {
		this.ddlFrom = ddlFrom;
	}

	public UserInfoQuery getUserInfoQuery() {
		return userInfoQuery;
	}

	public void setUserInfoQuery(UserInfoQuery userInfoQuery) {
		this.userInfoQuery = userInfoQuery;
	}
}
