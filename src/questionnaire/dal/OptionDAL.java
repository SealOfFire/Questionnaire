package questionnaire.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import questionnaire.web.model.Option;

public class OptionDAL extends BaseDAL {

	private static final String INSERT01 = "insert into `Option`(OptionID,QuestionID,Caption,Score,Sort) values(?,?,?,?,?)";
	private static final String UPDATE01 = "update `Option` set Caption=?,Score=?,Sort=? where OptionID=?";
	private static final String DELETE01 = "delete from `Option` where OptionID=?";
	private static final String SELECT01 = "select OptionID,QuestionID,Caption,Score,Sort from `Option` where QuestionID=? order by Sort";
	private static final String SELECT02 = "select max(Sort) from `Option` where QuestionID=?";

	public Option insert(String optionID, String questionID, String caption, int score) {
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		int sort = 0;
		int value = 0;
		Option option = new Option();
		try {

			conn = this.getConnect();
			pstmt1 = conn.prepareStatement(SELECT02);
			pstmt1.setObject(1, questionID);
			rs = pstmt1.executeQuery();
			while (rs.next()) {
				sort = rs.getInt(1) + 1;
			}

			pstmt2 = conn.prepareStatement(INSERT01);
			pstmt2.setString(1, optionID);
			pstmt2.setString(2, questionID);
			pstmt2.setString(3, caption);
			pstmt2.setInt(4, score);
			pstmt2.setInt(5, sort);
			value = pstmt2.executeUpdate();

			option.setOptionID(optionID);
			option.setQuestionID(questionID);
			option.setCaption(caption);
			option.setScore(score);
			option.setSort(sort);

			rs.close();
			rs = null;
			pstmt1.close();
			pstmt1 = null;
			pstmt2.close();
			pstmt2 = null;
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

			if (pstmt1 != null) {
				try {
					pstmt1.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				pstmt1 = null;
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
		return option;
	}

	public ArrayList<Option> selectList(String questionID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Option> options = new ArrayList<Option>();
		try {

			conn = this.getConnect();
			pstmt = conn.prepareStatement(SELECT01);
			pstmt.setString(1, questionID);

			// 执行查询
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Option option = new Option();
				option.setOptionID(rs.getString("OptionID"));
				option.setQuestionID(rs.getString("QuestionID"));
				option.setCaption(rs.getString("Caption"));
				option.setScore(rs.getInt("Score"));
				option.setSort(rs.getInt("Sort"));
				options.add(option);
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
		return options;
	}

	public int delete(String optionID) {
		ArrayList<Object> parameters = new ArrayList<Object>();
		parameters.add(optionID);
		return this.modify(DELETE01, parameters.toArray());
	}

}
