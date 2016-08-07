package questionnaire.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import questionnaire.web.model.Typewrite;

public class TypewriteDAL extends BaseDAL {
	private static final String INSERT01 = "insert into TypewriteQuestion(QuestionID,Title,CaptionText,CaptionImage,TimeLimit) values(?,?,?,?,?)";
	private static final String UPDATE01 = "update TypewriteQuestion set Title=?,CaptionText=?,CaptionImage=?,TimeLimit=? where QuestionID=?";
	private static final String DELETE01 = "delete from TypewriteQuestion where QuestionID=?";
	private static final String SELECT01 = "select * from TypewriteQuestion";

	public int insert(String questionID, String title, String captionText, String captionImage, int timeLimit) {
		ArrayList<Object> parameters = new ArrayList<Object>();
		parameters.add(questionID);
		parameters.add(title);
		parameters.add(captionText);
		parameters.add(captionImage);
		parameters.add(timeLimit);
		return this.modify(INSERT01, parameters.toArray());
	}

	public int update(String questionID, String title, String captionText, String captionImage, int timeLimit) {
		ArrayList<Object> parameters = new ArrayList<Object>();
		parameters.add(title);
		parameters.add(captionText);
		parameters.add(captionImage);
		parameters.add(timeLimit);
		parameters.add(questionID);
		return this.modify(UPDATE01, parameters.toArray());
	}

	public int delete(String questionID) {
		ArrayList<Object> parameters = new ArrayList<Object>();
		parameters.add(questionID);
		return this.modify(DELETE01, parameters.toArray());
	}

	public Typewrite select(String questionID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Typewrite typewrite = new Typewrite();
		try {

			conn = this.getConnect();
			pstmt = conn.prepareStatement(SELECT01 + " where  QuestionID=?");
			pstmt.setObject(1, questionID);

			// 执行查询
			rs = pstmt.executeQuery();

			while (rs.next()) {
				typewrite.setQuestionID(rs.getString("QuestionID"));
				typewrite.setTitle(rs.getString("Title"));
				typewrite.setCaptionText(rs.getString("CaptionText"));
				typewrite.setCaptionImage(rs.getString("CaptionImage"));
				typewrite.setTimeLimit(rs.getInt("TimeLimit"));
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
		return typewrite;
	}

	public ArrayList<Typewrite> selectList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Typewrite> typewrites = new ArrayList<Typewrite>();
		try {

			conn = this.getConnect();
			pstmt = conn.prepareStatement(SELECT01);

			// 执行查询
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Typewrite typewrite = new Typewrite();
				typewrite.setQuestionID(rs.getString("QuestionID"));
				typewrite.setTitle(rs.getString("Title"));
				// 文本过长时截取文本
				String text = rs.getString("CaptionText");
				if (text.length() > 10) {
					typewrite.setCaptionText(text.substring(0, 10) + "...");
				} else {
					typewrite.setCaptionText(rs.getString("CaptionText"));
				}
				typewrite.setCaptionImage(rs.getString("CaptionImage"));
				typewrite.setTimeLimit(rs.getInt("TimeLimit"));
				typewrites.add(typewrite);
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
		return typewrites;
	}
}
