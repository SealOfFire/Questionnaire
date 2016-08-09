package questionnaire.web.model;

public class UserInfo {
	private String userID;
	private String name;
	private String phoneNumber;
	private String IDCardNumber;
	private String sex;
	private String sexString;
	private String area;

	public boolean notSaved() {
		if (this.userID == null || this.userID.length() == 0)
			return true;
		else
			return false;
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
}
