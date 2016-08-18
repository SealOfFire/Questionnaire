package questionnaire.bll;

import java.util.ArrayList;
import java.util.UUID;

import questionnaire.dal.UserInfoDAL;
import questionnaire.web.model.UserInfo;
import questionnaire.web.model.UserInfoQuery;

public class UserInfoBLL {
	public ArrayList<UserInfo> selectList(UserInfoQuery query) {
		// ArrayList<UserInfo> userInfo = new UserInfoDAL().selectList();
		return new UserInfoDAL().selectList(query);
	}

	public UserInfo insert(UserInfo userInfo) {
		userInfo.setUserID(UUID.randomUUID().toString());
		new UserInfoDAL().insert(userInfo.getUserID(), userInfo.getName(), userInfo.getPhoneNumber(),
				userInfo.getIDCardNumber(), userInfo.getSex(), userInfo.getArea(), userInfo.getFrom());
		return userInfo;
	}

	public UserInfo select(String name, String IDCardNumber) {
		return new UserInfoDAL().select(name, IDCardNumber);
	}

	public UserInfo select(String userID) {
		return new UserInfoDAL().select(userID);
	}

	public int delete(String userID) {
		return new UserInfoDAL().delete(userID);
	}
}
