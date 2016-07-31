package questionnaire.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import questionnaire.web.model.Questionnaire;

/** 问卷数据库操作 */
public class QuestionnaireDAL extends BaseDAL {

	private static final String INSERT01 = "insert into Questionnaire(QuestionnaireID,Title,TimeLimit,QuestionnaireType) values(?,?,?,?)";
	private static final String INSERT02 = "insert into QuestionnaireQuestion(QuestionnaireID,QuestionID,Sort) values(?,?,?)";
	private static final String UPDATE01 = "update Questionnaire set Title=?,TimeLimit=?,QuestionnaireType=? where QuestionnaireID=?";
	private static final String DELETE01 = "delete from Questionnaire where QuestionnaireID=?";
	private static final String DELETE02 = "delete from QuestionnaireQuestion where QuestionnaireID=? and QuestionID=?";
	private static final String SELECT01 = "select QuestionnaireID,Title,TimeLimit,QuestionnaireType from questionnaire";
	private static final String SELECT02 = "select max(sort) from QuestionnaireQuestion where QuestionnaireID=?";

	/** 插入到数据库 */
	public int insert(String questionnaireID, String title, int timeLimit, String questionnaireType) {
		ArrayList<Object> parameters = new ArrayList<Object>();
		parameters.add(questionnaireID);
		parameters.add(title);
		parameters.add(timeLimit);
		parameters.add(questionnaireType);
		return this.modify(INSERT01, parameters.toArray());
	}

	/** 更新 */
	public int update(String questionnaireID, String title, int timeLimit, String questionnaireType) {
		ArrayList<Object> parameters = new ArrayList<Object>();
		parameters.add(title);
		parameters.add(timeLimit);
		parameters.add(questionnaireType);
		parameters.add(questionnaireID);
		return this.modify(UPDATE01, parameters.toArray());
	}

	/** 删除问卷 */
	public int delete(String questionnaireID) {
		ArrayList<Object> parameters = new ArrayList<Object>();
		parameters.add(questionnaireID);
		return this.modify(DELETE01, parameters.toArray());
	}

	/** 查找问卷 */
	public Questionnaire select(String questionnaireID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Questionnaire questionnaire = new Questionnaire();
		try {

			conn = this.getConnect();
			pstmt = conn.prepareStatement(SELECT01 + " where  QuestionnaireID=?");
			pstmt.setObject(1, questionnaireID);

			// 执行查询
			rs = pstmt.executeQuery();

			while (rs.next()) {
				questionnaire.setQuestionnaireID(rs.getString("QuestionnaireID"));
				questionnaire.setTitle(rs.getString("Title"));
				questionnaire.setTimeLimit(rs.getInt("TimeLimit"));
				questionnaire.setQuestionnaireType(rs.getString("QuestionnaireType"));
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
		return questionnaire;
	}

	/** 查找问卷 */
	public ArrayList<Questionnaire> selectList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Questionnaire> questionnaires = new ArrayList<Questionnaire>();
		try {

			conn = this.getConnect();
			pstmt = conn.prepareStatement(SELECT01);

			// 执行查询
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Questionnaire questionnaire = new Questionnaire();
				questionnaire.setQuestionnaireID(rs.getString("QuestionnaireID"));
				questionnaire.setTitle(rs.getString("Title"));
				questionnaire.setTimeLimit(rs.getInt("TimeLimit"));
				questionnaire.setQuestionnaireType(rs.getString("QuestionnaireType"));
				questionnaires.add(questionnaire);
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
		return questionnaires;
	}

	public int addQuestion(String questionnaireID, String questionID) {
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		int sort = 0;
		int value = 0;
		try {

			conn = this.getConnect();
			pstmt1 = conn.prepareStatement(SELECT02);
			pstmt1.setObject(1, questionnaireID);
			rs = pstmt1.executeQuery();
			while (rs.next()) {
				sort = rs.getInt(1) + 1;
			}

			pstmt2 = conn.prepareStatement(INSERT02);
			pstmt2.setString(1, questionnaireID);
			pstmt2.setString(2, questionID);
			pstmt2.setInt(3, sort);
			value = pstmt2.executeUpdate();

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
		return value;
	}

	public int deleteQuestion(String questionnaireID, String questionID) {
		ArrayList<Object> parameters = new ArrayList<Object>();
		parameters.add(questionnaireID);
		parameters.add(questionID);
		return this.modify(DELETE02, parameters.toArray());
	}
}
