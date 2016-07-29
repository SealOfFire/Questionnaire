package questionnaire.test;

import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import questionnaire.dal.SQLiteManager;

public class TestSQLiteConnect {

	@Test
	public void testCreateDatabase() {
		Statement stmt = null;
		try {
			SQLiteManager manager = new SQLiteManager();
			stmt = manager.getConnect().createStatement();

			stmt.executeUpdate("DROP TABLE IF EXISTS `Questionnaire`;");
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS `Questionnaire` (" + "`QuestionnaireID` CHAR(36) NOT NULL,"
					+ "`Title` NVARCHAR(50) NULL DEFAULT ''," + "`TimeLimit` INT NULL DEFAULT 0,"
					+ "`QuestionnaireType` NVARCHAR(20) NULL," + "PRIMARY KEY (`QuestionnaireID`))");

			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

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
