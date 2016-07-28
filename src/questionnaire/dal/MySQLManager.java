package questionnaire.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

/** 数据库操作管理 */
public class MySQLManager {

	private static String connectionString = "jdbc:mysql://localhost/questionnairedb?user=root&password=root&characterEncoding=utf8&useSSL=false";

	/** 构造函数 */
	public MySQLManager() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
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

	/** 检索数据 */
	public void select(String query) {
		Object[] parameters = new Object[0];
		this.select(query, parameters);
	}

	/** 检索数据 */
	public void select(String query, Object[] parameters) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			conn = this.getConnect();
			pstmt = conn.prepareStatement(query);
			ParameterMetaData pmd = pstmt.getParameterMetaData();
			for (int i = 0; i < parameters.length; i++) {
				pstmt.setObject(i + 1, parameters[i]);
			}

			// 执行查询
			rs = pstmt.executeQuery();

			// TODO 测试代码
			while (rs.next()) {
				System.out.println(rs.getString("QuestionnaireID"));
			}

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
	}

}
