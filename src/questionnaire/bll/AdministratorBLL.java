package questionnaire.bll;

import questionnaire.dal.AdministratorDAL;

public class AdministratorBLL {
	public boolean login(String userName, String password) {
		if (new AdministratorDAL().selectCount(userName, password) > 0) {
			return true;
		} else {
			return false;
		}
	}
}
