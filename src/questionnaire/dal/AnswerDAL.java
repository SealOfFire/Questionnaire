package questionnaire.dal;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import questionnaire.web.model.Answer;

public class AnswerDAL extends BaseDAL {
	private static final String SELECT01 = "select count(*) from Answer where UserID=? and QuestionnaireID=?";
	private static final String SELECT02 = "select * from Answer where UserID=? and QuestionnaireID=?";
	private static final String SELECT03 = "select QuestionnaireID,sum(score) from Answer where userID=? group by QuestionnaireID";
	private static final String REPLACE01 = "replace into Answer(UserID,QuestionnaireID,QuestionID,OptionID,Answer,BeginDate,EndDate,Score) values(?,?,?,?,?,?,?,?)";

	public ArrayList<Answer> select(String userID, String questionnaireID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Answer> answers = new ArrayList<Answer>();
		try {

			conn = this.getConnect();
			pstmt = conn.prepareStatement(SELECT02);
			pstmt.setObject(1, userID);
			pstmt.setObject(2, questionnaireID);

			// 执行查询
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Answer answer = new Answer();
				answer.setAnswer(rs.getString("Answer"));
				answer.setBeginDate(rs.getDate("BeginDate"));
				answer.setEndDate(rs.getDate("EndDate"));
				answer.setOptionID(rs.getString("OptionID"));
				answer.setQuestionID(rs.getString("QuestionID"));
				answer.setQuestionnaireID(rs.getString("QuestionnaireID"));
				answer.setScore(rs.getBigDecimal("Score"));
				answer.setUserID(rs.getString("UserID"));
				answers.add(answer);
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
		return answers;
	}

	/**  */
	public int selectCount(String userID, String questionnaireID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = -1;
		try {

			conn = this.getConnect();
			pstmt = conn.prepareStatement(SELECT01);
			pstmt.setString(1, userID);
			pstmt.setString(2, questionnaireID);

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

	/**  */
	public int replace(String userID, String questionnaireID, String questionID, String optionID, String answer,
			Date beginDate, Date endDate, BigDecimal score) {
		ArrayList<Object> parameters = new ArrayList<Object>();
		parameters.add(userID);
		parameters.add(questionnaireID);
		parameters.add(questionID);
		parameters.add(optionID);
		parameters.add(answer);
		parameters.add(beginDate);
		parameters.add(endDate);
		parameters.add(score);
		return this.modify(REPLACE01, parameters.toArray());
	}

	public Map<String, BigDecimal> selectScoreSum(String userID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, BigDecimal> result = new HashMap<String, BigDecimal>();
		try {
			conn = this.getConnect();
			pstmt = conn.prepareStatement(SELECT03);
			pstmt.setObject(1, userID);
			// 执行查询
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String questionnaireID = rs.getString(1);
				BigDecimal score = rs.getBigDecimal("Score");
				result.put(questionnaireID, score);
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
		return result;
	}
}
