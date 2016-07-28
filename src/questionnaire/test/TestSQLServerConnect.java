package questionnaire.test;

import java.sql.SQLException;

import org.junit.Test;

import questionnaire.dal.SQLServerManager;

public class TestSQLServerConnect {
	@Test
	public void asdf() {
		try {
			SQLServerManager manager = new SQLServerManager();
			manager.getConnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
