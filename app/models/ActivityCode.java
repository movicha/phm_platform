package models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the activity_codes database table.
 * 
 */
@Entity
@Table(name="activity_codes")
public class ActivityCode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="activity_code_id")
	private int activityCodeId;

	private String code;

	private String description;

	public ActivityCode() {
	}

	public int getActivityCodeId() {
		return this.activityCodeId;
	}

	public void setActivityCodeId(int activityCodeId) {
		this.activityCodeId = activityCodeId;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}