package questionnaire.web.model;

import java.math.BigDecimal;

public class UserInfo {
	private String userID;
	private String name;
	private String phoneNumber;
	private String IDCardNumber;
	private String sex;
	private String sexString;
	private String area;
	private String from;
	private BigDecimal score1;
	private BigDecimal score2;
	private BigDecimal score3;
	private BigDecimal score4;
	private BigDecimal score5;

	public boolean notSaved() {
		if (this.userID == null || this.userID.length() == 0)
			return true;
		else
			return false;
	}

	public UserInfo() {
		this.score1 = new BigDecimal(0);
		this.score2 = new BigDecimal(0);
		this.score3 = new BigDecimal(0);
		this.score4 = new BigDecimal(0);
		this.score5 = new BigDecimal(0);
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getIDCardNumber() {
		return IDCardNumber;
	}

	public void setIDCardNumber(String iDCardNumber) {
		IDCardNumber = iDCardNumber;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSexString() {
		switch (this.sex) {
		case "male":
			this.sexString = "男";
			break;
		case "female":
			this.sexString = "女";
			break;
		default:
			this.sexString = "";
			break;
		}
		return this.sexString;
	}

	public void setSexString(String sexString) {
		this.sexString = sexString;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public BigDecimal getScore1() {
		return score1;
	}

	public void setScore1(BigDecimal score1) {
		this.score1 = score1;
	}

	public BigDecimal getScoreSum() {
		return this.score1.add(this.score2);
	}

	public BigDecimal getScore2() {
		return score2;
	}

	public void setScore2(BigDecimal score2) {
		this.score2 = score2;
	}

	public BigDecimal getScore3() {
		return score3;
	}

	public void setScore3(BigDecimal score3) {
		this.score3 = score3;
	}

	public BigDecimal getScore4() {
		return score4;
	}

	public void setScore4(BigDecimal score4) {
		this.score4 = score4;
	}

	public BigDecimal getScore5() {
		return score5;
	}

	public void setScore5(BigDecimal score5) {
		this.score5 = score5;
	}

	public BigDecimal getSumALLScore() {
		return this.score1.add(this.score2).add(this.score3).add(this.score4);
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}
}
