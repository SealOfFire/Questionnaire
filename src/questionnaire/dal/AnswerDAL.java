package questionnaire.dal;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AnswerDAL extends BaseDAL {
	private static final String SELECT01 = "select count(*) from Answer where UserID=? and QuestionnaireID=?";
	private static final String REPLACE01 = "replace into Answer(UserID,QuestionnaireID,QuestionID,OptionID,Answer,BeginDate,EndDate,Score) values(?,?,?,?,?,?,?,?)";

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
}
