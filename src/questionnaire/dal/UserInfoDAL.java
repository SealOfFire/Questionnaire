package questionnaire.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.UUID;

import questionnaire.web.model.UserInfo;

public class UserInfoDAL extends BaseDAL {
	private static final String SELECT01 = "select * from userinfo";
	private static final String SELECT02 = "select * from userinfo where name=? and IDCardNumber=?";
	private static final String INSERT01 = "insert into  userinfo(userID,name,phoneNumber,IDCardNumber,sex) values(?,?,?,?,?)";

	public ArrayList<UserInfo> selectList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<UserInfo> userInfos = new ArrayList<UserInfo>();
		try {

			conn = this.getConnect();
			pstmt = conn.prepareStatement(SELECT01);

			// 执行查询
			rs = pstmt.executeQuery();

			while (rs.next()) {
				UserInfo userInfo = new UserInfo();
				userInfo.setUserID(rs.getString("UserID"));
				userInfo.setName(rs.getString("Name"));
				userInfo.setPhoneNumber(rs.getString("PhoneNumber"));
				userInfo.setIDCardNumber(rs.getString("IDCardNumber"));
				userInfo.setSex(rs.getString("Sex"));
				userInfos.add(userInfo);
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
		return userInfos;
	}

	public int insert(String userID, String name, String phoneNumber, String IDCardNumber, String sex) {
		ArrayList<Object> parameters = new ArrayList<Object>();
		parameters.add(userID);
		parameters.add(name);
		parameters.add(phoneNumber);
		parameters.add(IDCardNumber);
		parameters.add(sex);
		return this.modify(INSERT01, parameters.toArray());
	}

	public UserInfo select(String name, String IDCardNumber) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserInfo userInfo = new UserInfo();
		try {

			conn = this.getConnect();
			pstmt = conn.prepareStatement(SELECT01);

			// 执行查询
			rs = pstmt.executeQuery();

			while (rs.next()) {
				userInfo.setUserID(rs.getString("UserID"));
				userInfo.setName(rs.getString("Name"));
				userInfo.setPhoneNumber(rs.getString("PhoneNumber"));
				userInfo.setIDCardNumber(rs.getString("IDCardNumber"));
				userInfo.setSex(rs.getString("Sex"));
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
		return userInfo;
	}
}
