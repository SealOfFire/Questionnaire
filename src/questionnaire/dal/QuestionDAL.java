package questionnaire.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import questionnaire.web.model.Question;

public class QuestionDAL extends BaseDAL {

	private static final String INSERT01 = "insert into Question(QuestionID,QuestionCategory,Caption,QuestionType) values(?,?,?,?)";
	private static final String UPDATE01 = "update Question set QuestionCategory=?,Caption=?,QuestionType=? where QuestionID=?";
	private static final String DELETE01 = "delete from Question where QuestionID=?";
	private static final String SELECT01 = "select QuestionID,QuestionCategory,Caption,QuestionType from Question";
	private static final String SELECT02 = "select Question.QuestionID,Question.QuestionCategory,Question.Caption,QuestionType,QuestionnaireQuestion.Sort from Question "
			+ " inner join QuestionnaireQuestion on Question.QuestionID=QuestionnaireQuestion.QuestionID and QuestionnaireID=?";
	private static final String SELECT03 = "SELECT * FROM Question"
			+ " where QuestionID not in(select QuestionID from questionnairequestion where QuestionnaireID=?)";

	/** 问提插入到数据库 */
	public int insert(String questionID, String caption, String questionType) {
		ArrayList<Object> parameters = new ArrayList<Object>();
		parameters.add(questionID);
		parameters.add("QuestionCategory");
		parameters.add(caption);
		parameters.add(questionType);
		return this.modify(INSERT01, parameters.toArray());
	}

	/** 问提更新 */
	public int update(String questionID, String caption, String questionType) {
		ArrayList<Object> parameters = new ArrayList<Object>();
		parameters.add("QuestionCategory");
		parameters.add(caption);
		parameters.add(questionType);
		parameters.add(questionID);
		return this.modify(UPDATE01, parameters.toArray());
	}

	/** 删除问提 */
	public int delete(String questionID) {
		ArrayList<Object> parameters = new ArrayList<Object>();
		parameters.add(questionID);
		return this.modify(DELETE01, parameters.toArray());
	}

	/** 查找问提 */
	public Question select(String questionID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Question question = new Question();
		try {

			conn = this.getConnect();
			pstmt = conn.prepareStatement(SELECT01 + " where  QuestionID=?");
			pstmt.setObject(1, questionID);

			// 执行查询
			rs = pstmt.executeQuery();

			while (rs.next()) {
				question.setQuestionID(rs.getString("QuestionID"));
				question.setCaption(rs.getString("Caption"));
				question.setQuestionType(rs.getString("QuestionType"));
				question.setQuestionType(rs.getString("QuestionType"));
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
		return question;
	}

	/** 查找问卷 */
	public ArrayList<Question> selectList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Question> questions = new ArrayList<Question>();
		try {

			conn = this.getConnect();
			pstmt = conn.prepareStatement(SELECT01);

			// 执行查询
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Question question = new Question();
				question.setQuestionID(rs.getString("QuestionID"));
				question.setCaption(rs.getString("Caption"));
				question.setQuestionType(rs.getString("QuestionType"));
				questions.add(question);
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
		return questions;
	}

	/**  */
	public ArrayList<Question> selectList(String questionnaireID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Question> questions = new ArrayList<Question>();
		try {

			conn = this.getConnect();
			pstmt = conn.prepareStatement(SELECT02);
			pstmt.setString(1, questionnaireID);

			// 执行查询
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Question question = new Question();
				question.setQuestionID(rs.getString("QuestionID"));
				question.setCaption(rs.getString("Caption"));
				question.setQuestionType(rs.getString("QuestionType"));
				question.setSort(rs.getInt("Sort"));
				questions.add(question);
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
		return questions;
	}

	/**  */
	public ArrayList<Question> selectNotAddList(String questionnaireID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Question> questions = new ArrayList<Question>();
		try {

			conn = this.getConnect();
			pstmt = conn.prepareStatement(SELECT03);
			pstmt.setString(1, questionnaireID);

			// 执行查询
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Question question = new Question();
				question.setQuestionID(rs.getString("QuestionID"));
				question.setCaption(rs.getString("Caption"));
				question.setQuestionType(rs.getString("QuestionType"));
				questions.add(question);
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
		return questions;
	}

	/** 添加问题 */
	public int insertQuestion(String questionnaireID, String questionID) {
		return 0;
	}

	/** 删除问题 */
	public int deleteQuestion(String questionnaireID, String questionID) {
		return 0;
	}
}
