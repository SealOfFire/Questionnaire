package questionnaire.test;

import java.sql.SQLException;

import org.junit.Test;

import questionnaire.dal.SQLiteManager;

public class TestSQLiteConnect {
	@Test
	public void asdf() {
		try {
			SQLiteManager manager = new SQLiteManager();
			manager.getConnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
