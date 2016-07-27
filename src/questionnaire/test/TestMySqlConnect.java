package questionnaire.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

/** 测试数据库连接 */
public class TestMySqlConnect {
	@Test
	public void testPlus() {
		// puls.plus(1, 1);
		// assertEquals(2, puls.getresult());
		int debug = 0;
		debug++;
	}

	/** 连接数据库测试 */
	@Test
	public void testConnect() {
		try {
			Connection conn = DriverManager
					.getConnection("jdbc:mysql://localhost/test?" + "user=minty&password=greatsqldb");

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT foo FROM bar");

			if (stmt.execute("SELECT foo FROM bar")) {
				rs = stmt.getResultSet();
			}

			stmt.executeUpdate(
					"INSERT INTO autoIncTutorial (dataField) " + "values ('Can I Get the Auto Increment Field?')",
					Statement.RETURN_GENERATED_KEYS);

			rs = stmt.getGeneratedKeys();

			rs.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
