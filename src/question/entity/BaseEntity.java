package question.entity;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/** 实体基类 */
public class BaseEntity {

	@Column(name = "insert_date")
	@Temporal(TemporalType.TIMESTAMP)
	@Generated(value = "insert")
	protected Date insertDate;

	@Column(name = "update_date")
	@Temporal(TemporalType.TIMESTAMP)
	@Generated(value = "always")
	protected Date updateDate;

	/** 构造函数 */
	public BaseEntity() {
		this.insertDate = new Date();
		this.updateDate = new Date();
	}
}
