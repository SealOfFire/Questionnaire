package questionnaire.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdministratorDAL extends BaseDAL {
	private final static String SELECT01 = "select count(*) from Administrator where UserName=? and Password=?";

	/**  */
	public int selectCount(String userName, String password) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = -1;
		try {

			conn = this.getConnect();
			pstmt = conn.prepareStatement(SELECT01);
			pstmt.setString(1, userName);
			pstmt.setString(2, password);

			// 执行查询
			rs = pstmt.executeQuery();

			while (rs.next()) {
				count = rs.getInt(1);
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
		return count;
	}
}
