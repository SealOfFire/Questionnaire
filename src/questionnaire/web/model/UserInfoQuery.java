package questionnaire.web.model;

import java.sql.Date;

public class UserInfoQuery {

	public Date startDate;
	public Date endDate;
	public String name;
	public String IDCardNumber;
	public String fromSource;
	public String area;

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

}
