package questionnaire.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.junit.Test;

import questionnaire.dal.MySQLManager;

/** 测试数据库连接 */
public class TestMySqlConnect {

	/** 连接数据库测试 */
	@Test
	public void testConnect() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			Connection conn = DriverManager
					.getConnection("jdbc:mysql://localhost/questionnairedb?user=root&password=root");

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from questionnaire");

			if (stmt.execute("select * from questionnaire")) {
				rs = stmt.getResultSet();
			}

			int value = stmt.executeUpdate(
					"insert into questionnaire (QuestionnaireID,Title,TimeLimit) " + "values (uuid(),'title',20)",
					Statement.RETURN_GENERATED_KEYS);
			System.out.println("value");

			rs = stmt.getGeneratedKeys();

			rs.close();
			stmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/** 连接池 */
	@Test
	public void testConnectPooling() {
		Connection conn = null;
		Statement stmt = null;
		try {
			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/MySQLDB");

			conn = ds.getConnection();
			stmt = conn.createStatement();
			stmt.execute("select * from questionnaire");

			stmt.close();
			stmt = null;

			conn.close();
			conn = null;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception sqlex) {
					// ignore, as we can't do anything about it here
				}
				stmt = null;
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (Exception sqlex) {
					// ignore, as we can't do anything about it here
				}
				conn = null;
			}
		}
	}

	@Test
	public void testSelect() {
		MySQLManager manage = new MySQLManager();
		ArrayList<Object> parameters = new ArrayList<Object>();
		parameters.add("title");
		parameters.add(20);
		manage.select("select * from questionnaire where Title=? and TimeLimit=?", parameters.toArray());

		manage.select("select * from questionnaire");
	}
}
