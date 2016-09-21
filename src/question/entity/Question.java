package question.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/** 问题 */
@Entity()
@Table(name = "tbl_Question")
public class Question extends BaseEntity {

	/** 问题id */
	@Id
	@Column(name = "question_id", length = 36)
	// @Column(name = "question_id", columnDefinition = "char(36)")
	// @Column(name = "question_id", columnDefinition = "binary(16)")
	// @GeneratedValue(generator = "uuid")
	// @GenericGenerator(name = "uuid", strategy = "uuid")
	@org.hibernate.annotations.Type(type = "char")
	private UUID questionId;

	/** 标题 */
	@Column(name = "title", length = 100)
	@org.hibernate.annotations.Type(type = "nstring")
	private String title;

	/** 正文 */
	@Column(name = "text", length = 100)
	@org.hibernate.annotations.Type(type = "nstring")
	private String text;

	/** 构造函数 */
	public Question() {
		super();
		this.questionId = UUID.randomUUID();
	}

	/* ----------------------------- get/set ----------------------------- */

	public UUID getQuestionId() {
		return questionId;
	}

	public void setQuestionId(UUID questionId) {
		this.questionId = questionId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
