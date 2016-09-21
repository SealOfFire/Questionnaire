package questionnaire.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BaseDAL {
	private static String connectionString = "jdbc:mysql://192.168.50.192/questionnairedb?user=root&password=root&characterEncoding=utf8&useSSL=false&serverTimezone=GMT";
	private static String className = "com.mysql.cj.jdbc.Driver";
	private DataSource ds;

	/**  */
	public BaseDAL() {
		try {
			InitialContext initCtx = new InitialContext();
			this.ds = (DataSource) initCtx.lookup("java:comp/env/jdbc/mysql");
			// Connection conn = ds.getConnection();

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
		// Connection connection =
		// DriverManager.getConnection(connectionString);
		Connection connection = this.ds.getConnection();
		return connection;
	}

	/** 修改数据库 */
	public int modify(String query, Object[] parameters) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		int value = -1;
		try {

			conn = this.getConnect();
			pstmt = conn.prepareStatement(query);
			for (int i = 0; i < parameters.length; i++) {
				pstmt.setObject(i + 1, parameters[i]);
			}

			// 执行查询
			value = pstmt.executeUpdate();

			// 关闭连接
			pstmt.close();
			pstmt = null;
			conn.close();
			conn = null;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 出错时关闭连接
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				resultSet = null;
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
		return value;
	}

	/** 检索数据 */
	public void select(String query, Object[] parameters) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			conn = this.getConnect();
			pstmt = conn.prepareStatement(query);
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
			rs = null;
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
