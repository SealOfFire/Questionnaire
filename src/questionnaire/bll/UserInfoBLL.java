package questionnaire.bll;

import java.util.ArrayList;

import questionnaire.dal.UserInfoDAL;
import questionnaire.web.model.UserInfo;

public class UserInfoBLL {
	public ArrayList<UserInfo> selectList() {
		return new UserInfoDAL().selectList();
	}
}
