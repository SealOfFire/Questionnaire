package questionnaire.bll;

import java.util.ArrayList;
import java.util.UUID;

import questionnaire.dal.UserInfoDAL;
import questionnaire.web.model.UserInfo;

public class UserInfoBLL {
	public ArrayList<UserInfo> selectList() {
		return new UserInfoDAL().selectList();
	}

	public UserInfo insert(UserInfo userInfo) {
		userInfo.setUserID(UUID.randomUUID().toString());
		new UserInfoDAL().insert(userInfo.getUserID(), userInfo.getName(), userInfo.getPhoneNumber(),
				userInfo.getIDCardNumber(), userInfo.getSex(), userInfo.getArea());
		return userInfo;
	}

	public UserInfo select(String name, String IDCardNumber) {
		return new UserInfoDAL().select(name, IDCardNumber);
	}
}
