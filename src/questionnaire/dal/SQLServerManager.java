package questionnaire.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLServerManager {
	private static String connectionString = "jdbc:sqlserver://(LocalDB);" + "database=SurveyDB;" + "user=sa;"
			+ "password=123456;";

	/** 构造函数 */
	public SQLServerManager() {
		/*
		 * try { //
		 * Class.forName("com.microsoft.sqlserver.jdbc.Driver").newInstance(); }
		 * catch (InstantiationException | IllegalAccessException |
		 * ClassNotFoundException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
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
