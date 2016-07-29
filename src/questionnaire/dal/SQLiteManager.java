package questionnaire.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteManager {
	private static String connectionString = "jdbc:sqlite:QuestionnaireDB.db";

	/** 构造函数 */
	public SQLiteManager() {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取数据库连接
	 * 
	 * @throws SQLException
	 */
	public Connection getConnect() throws SQLException {
		Connection connection = DriverManager.getConnection(connectionString);
		return connection;
	}
}
