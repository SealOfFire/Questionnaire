package questionnaire.dal;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import questionnaire.web.model.UserInfo;
import questionnaire.web.model.UserInfoQuery;

public class UserInfoDAL extends BaseDAL {
	private static final String SELECT01 = "select * from userinfo";
	private static final String SELECT02 = "select * from userinfo where name=? and IDCardNumber=?";
	private static final String SELECT04 = "select * from userinfo where UserID=?";
	private static final String SELECT03 = "select questionnaireparts.sort,Answer.QuestionnaireID,sum(score) from Answer left join questionnaireparts on Answer.QuestionnaireID=questionnaireparts.QuestionnaireID where userID=? group by Answer.QuestionnaireID order by sort";
	private static final String INSERT01 = "insert into  userinfo(userID,name,phoneNumber,IDCardNumber,sex,area,FromSource,InsertDate) values(?,?,?,?,?,?,?,now())";
	private static final String DELETE01 = "delete from userinfo where userid=?";
	private static final String SELECT05 = "select * from(select UserInfo.*,if(s1.score is null,0,s1.score) score1,if(s2.score is null,0,s2.score) score2,if(s3.score is null,0,s3.score) score3,if(s4.score is null,0,s4.score) score4,if(s1.score is null,0,s1.score)+if(s2.score is null,0,s2.score)+if(s3.score is null,0,s3.score)+if(s4.score is null,0,s4.score) score5 from UserInfo left join (select Answer.UserID,sum(score) score from Answer left join questionnaireparts on Answer.QuestionnaireID=questionnaireparts.QuestionnaireID where questionnaireparts.sort=0 group by Answer.UserID,Answer.QuestionnaireID) s1 on UserInfo.UserID=s1.UserID left join (select Answer.UserID,sum(score) score from Answer left join questionnaireparts on Answer.QuestionnaireID=questionnaireparts.QuestionnaireID where questionnaireparts.sort=1 group by Answer.UserID,Answer.QuestionnaireID) s2 on UserInfo.UserID=s1.UserID and s1.UserID=s2.UserID left join (select Answer.UserID,sum(score) score from Answer left join questionnaireparts on Answer.QuestionnaireID=questionnaireparts.QuestionnaireID where questionnaireparts.sort=2 group by Answer.UserID,Answer.QuestionnaireID) s3 on UserInfo.UserID=s1.UserID and s1.UserID=s3.UserID left join (select Answer.UserID,sum(score) score from Answer left join questionnaireparts on Answer.QuestionnaireID=questionnaireparts.QuestionnaireID where Answer.QuestionnaireID='00000000-0000-0000-0000-000000000000' group by Answer.UserID,Answer.QuestionnaireID) s4 on UserInfo.UserID=s1.UserID and s1.UserID=s4.UserID) t";

	public ArrayList<UserInfo> selectList(UserInfoQuery query) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		ArrayList<UserInfo> userInfos = new ArrayList<UserInfo>();
		try {

			String sql = SELECT05 + " where 1=1 ";

			ArrayList<Object> params = new ArrayList<Object>();
			if (query.startDate != null) {
				sql += " and InsertDate>=?";
				params.add(query.startDate);
			}

			if (query.endDate != null) {
				sql += " and InsertDate<=?";
				params.add(query.endDate);
			}

			if (query.name != null && query.name.length() > 0) {
				sql += " and Name like ? ";
				params.add("%" + query.name + "%");
			}

			if (query.IDCardNumber != null && query.IDCardNumber.length() > 0) {
				sql += " and Name = ? ";
				params.add(query.IDCardNumber);
			}

			if (query.area != null && query.area.length() > 0) {
				sql += " and Area = ? ";
				params.add(query.area);
			}

			if (query.fromSource != null && query.fromSource.length() > 0) {
				sql += " and FromSource = ? ";
				params.add(query.fromSource);
			}

			sql += this.getScore(query.score1, "score1", params);
			sql += this.getScore(query.score2, "score2", params);
			sql += this.getScore(query.score3, "score3", params);
			sql += this.getScore(query.score4, "score4", params);
			sql += this.getScore(query.score5, "score5", params);

			conn = this.getConnect();
			pstmt = conn.prepareStatement(sql);

			int i = 0;
			for (Object p : params) {
				i++;
				pstmt.setObject(i, p);
			}

			// 执行查询
			rs = pstmt.executeQuery();

			while (rs.next()) {
				UserInfo userInfo = new UserInfo();
				userInfo.setUserID(rs.getString("UserID"));
				userInfo.setName(rs.getString("Name"));
				userInfo.setPhoneNumber(rs.getString("PhoneNumber"));
				userInfo.setIDCardNumber(rs.getString("IDCardNumber"));
				userInfo.setSex(rs.getString("Sex"));
				userInfo.setArea(rs.getString("Area"));
				userInfo.setFrom(rs.getString("FromSource"));
				userInfo.setInsertDate(rs.getDate("InsertDate"));
				// 分数
				pstmt2 = conn.prepareStatement(SELECT03);
				pstmt2.setString(1, userInfo.getUserID());
				rs2 = pstmt2.executeQuery();
				while (rs2.next()) {
					BigDecimal score = rs2.getBigDecimal(3);
					if (rs2.getString(1) == null) {
						if (rs2.getString(2).equals("00000000-0000-0000-0000-000000000001"))
							userInfo.setScore5(score);
						else if (rs2.getString(2).equals("00000000-0000-0000-0000-000000000000"))
							userInfo.setScore4(score);
					} else if (rs2.getString(1).equals("0")) {
						userInfo.setScore1(score);
						userInfo.setQuestionnaireID1(rs2.getString(2));
					} else if (rs2.getString(1).equals("1")) {
						userInfo.setScore2(score);
						userInfo.setQuestionnaireID2(rs2.getString(2));
					} else if (rs2.getString(1).equals("2")) {
						userInfo.setScore3(score);
						userInfo.setQuestionnaireID3(rs2.getString(2));
					} else {

					}
				}
				userInfos.add(userInfo);
			}

			rs.close();
			rs = null;
			if (rs2 != null) {
				rs2.close();
				rs2 = null;
			}
			pstmt.close();
			pstmt = null;
			if (pstmt2 != null) {
				pstmt2.close();
				pstmt2 = null;
			}
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

			if (pstmt2 != null) {
				try {
					pstmt2.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				pstmt2 = null;
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

	public int insert(String userID, String name, String phoneNumber, String IDCardNumber, String sex, String area,
			String from) {
		ArrayList<Object> parameters = new ArrayList<Object>();
		parameters.add(userID);
		parameters.add(name);
		parameters.add(phoneNumber);
		parameters.add(IDCardNumber);
		parameters.add(sex);
		parameters.add(area);
		parameters.add(from);
		return this.modify(INSERT01, parameters.toArray());
	}

	public UserInfo select(String name, String IDCardNumber) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserInfo userInfo = new UserInfo();
		try {

			conn = this.getConnect();
			pstmt = conn.prepareStatement(SELECT02);
			pstmt.setString(1, name);
			pstmt.setString(2, IDCardNumber);

			// 执行查询
			rs = pstmt.executeQuery();

			while (rs.next()) {
				userInfo.setUserID(rs.getString("UserID"));
				userInfo.setName(rs.getString("Name"));
				userInfo.setPhoneNumber(rs.getString("PhoneNumber"));
				userInfo.setIDCardNumber(rs.getString("IDCardNumber"));
				userInfo.setSex(rs.getString("Sex"));
				userInfo.setArea(rs.getString("Area"));
				userInfo.setFrom(rs.getString("FromSource"));
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

	public UserInfo select(String userID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserInfo userInfo = new UserInfo();
		try {

			conn = this.getConnect();
			pstmt = conn.prepareStatement(SELECT04);
			pstmt.setString(1, userID);

			// 执行查询
			rs = pstmt.executeQuery();

			while (rs.next()) {
				userInfo.setUserID(rs.getString("UserID"));
				userInfo.setName(rs.getString("Name"));
				userInfo.setPhoneNumber(rs.getString("PhoneNumber"));
				userInfo.setIDCardNumber(rs.getString("IDCardNumber"));
				userInfo.setSex(rs.getString("Sex"));
				userInfo.setArea(rs.getString("Area"));
				userInfo.setFrom(rs.getString("FromSource"));
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

	public int delete(String userID) {
		ArrayList<Object> parameters = new ArrayList<Object>();
		parameters.add(userID);
		return this.modify(DELETE01, parameters.toArray());
	}

	private BigDecimal getValue(String value) {
		try {
			return new BigDecimal(value);
		} catch (Exception e) {
			e.printStackTrace();
			return BigDecimal.ZERO;
		}
	}

	private String getScore(String score, String column, ArrayList<Object> params) {
		String sql = "";
		if (score != null && score.length() > 0) {
			if (score.indexOf(">=") >= 0) {
				sql = " and " + column + " >= ? ";
				params.add(this.getValue(score.replace(">=", "")));
			} else if (score.indexOf("<=") >= 0) {
				sql = " and " + column + " <= ? ";
				params.add(this.getValue(score.replace("<=", "")));
			} else if (score.indexOf("<") >= 0) {
				sql = " and " + column + " < ? ";
				params.add(this.getValue(score.replace("<", "")));
			} else if (score.indexOf(">") >= 0) {
				sql = " and " + column + " > ? ";
				params.add(this.getValue(score.replace(">", "")));
			} else if (score.indexOf("=") >= 0) {
				sql = " and " + column + " = ? ";
				params.add(this.getValue(score.replace("=", "")));
			}
		}
		return sql;
	}
}
