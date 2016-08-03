package questionnaire.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class QuestionnairePartsDAL extends BaseDAL {
	private final static String SELECE01 = "select QuestionnaireID from QuestionnaireParts where Sort=?";
	private final static String UPDATE01 = "update QuestionnaireParts set QuestionnaireID=? where Sort=?";

	public int update(String questionnaireID, int sort) {
		ArrayList<Object> parameters = new ArrayList<Object>();
		parameters.add(questionnaireID);
		parameters.add(sort);
		return this.modify(UPDATE01, parameters.toArray());
	}

	public String select(int sort) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String QuestionnaireID = "";
		try {

			conn = this.getConnect();
			pstmt = conn.prepareStatement(SELECE01);
			pstmt.setInt(1, sort);

			// 执行查询
			rs = pstmt.executeQuery();

			while (rs.next()) {
				QuestionnaireID = rs.getString("QuestionnaireID");
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
		return QuestionnaireID;
	}
}
