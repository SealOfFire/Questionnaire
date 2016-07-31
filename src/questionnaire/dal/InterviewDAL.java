package questionnaire.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import questionnaire.web.model.Interview;

public class InterviewDAL extends BaseDAL {
	private static final String SELECT01 = "select QuestionID,Title,Standard,Question,QuestionAdd,Sort from Interview order by Sort asc";

	public ArrayList<Interview> selectList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Interview> interviews = new ArrayList<Interview>();
		try {

			conn = this.getConnect();
			pstmt = conn.prepareStatement(SELECT01);

			// 执行查询
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Interview interview = new Interview();
				interview.setQuestionID(rs.getString("QuestionID"));
				interview.setTitle(rs.getString("Title"));
				interview.setStandard(rs.getString("Standard"));
				interview.setQuestion(rs.getString("Question"));
				interview.setQuestionAdd(rs.getString("QuestionAdd"));
				interview.setSort(rs.getInt("Sort"));
				interviews.add(interview);
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
		return interviews;
	}
}
