package question.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/** 问题 */
@Entity(name = "tbl_Question")
// @Table(name = "tbl_Question")
public class Question extends BaseEntity {

	/** 问题id */
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "Question_ID", strategy = "increment")
	private String questionId;

	/** 标题 */
	@Column(name = "EVENT_DATE")
	private String title;

	/** 正文 */
	private String text;
}
