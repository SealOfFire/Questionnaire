package questionnaire.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDAL {
	private final static String connectionString = "jdbc:mysql://localhost/questionnairedb?user=root&password=root&characterEncoding=utf8&useSSL=false";
	private final static String className = "com.mysql.cj.jdbc.Driver";

	/**  */
	public BaseDAL() {
		try {
			Class.forName(className).newInstance();
		} catch (Exception e) {
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

	/** 修改数据库 */
	public String modify(String query, Object[] parameters) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String id = null;
		try {

			conn = this.getConnect();
			pstmt = conn.prepareStatement(query);
			for (int i = 0; i < parameters.length; i++) {
				pstmt.setObject(i + 1, parameters[i]);
			}

			// 执行查询
			int value = pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();

			rs.close();
			// 关闭连接
			pstmt.close();
			pstmt = null;
			conn.close();
			conn = null;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 出错时关闭连接
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				rs = null;
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				pstmt = null;
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				conn = null;
			}
		}

		return id;
	}
}
