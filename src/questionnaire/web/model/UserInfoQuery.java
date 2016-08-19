package questionnaire.web.model;

import java.sql.Date;

public class UserInfoQuery {

	public Date startDate;
	public Date endDate;
	public String name;
	public String IDCardNumber;
	public String fromSource;
	public String area;

	public String score1;
	public String score2;
	public String score3;
	public String score4;
	public String score5;

	public String getStartDate() {
		return startDate.toString();
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate.toString();
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIDCardNumber() {
		return IDCardNumber;
	}

	public void setIDCardNumber(String iDCardNumber) {
		IDCardNumber = iDCardNumber;
	}

	public String getFromSource() {
		return fromSource;
	}

	public void setFromSource(String fromSource) {
		this.fromSource = fromSource;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getScore1() {
		return score1;
	}

	public void setScore1(String score1) {
		this.score1 = score1;
	}

	public String getScore2() {
		return score2;
	}

	public void setScore2(String score2) {
		this.score2 = score2;
	}

	public String getScore3() {
		return score3;
	}

	public void setScore3(String score3) {
		this.score3 = score3;
	}

	public String getScore4() {
		return score4;
	}

	public void setScore4(String score4) {
		this.score4 = score4;
	}

	public String getScore5() {
		return score5;
	}

	public void setScore5(String score5) {
		this.score5 = score5;
	}

}
