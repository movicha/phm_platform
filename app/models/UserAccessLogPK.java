package models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the user_access_log database table.
 * 
 */
@Embeddable
public class UserAccessLogPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date accesstime;

	@Column(name="user_id")
	private int userId;

	@Column(name="device_id")
	private int deviceId;

	public UserAccessLogPK() {
	}
	public java.util.Date getAccesstime() {
		return this.accesstime;
	}
	public void setAccesstime(java.util.Date accesstime) {
		this.accesstime = accesstime;
	}
	public int getUserId() {
		return this.userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getDeviceId() {
		return this.deviceId;
	}
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UserAccessLogPK)) {
			return false;
		}
		UserAccessLogPK castOther = (UserAccessLogPK)other;
		return 
			this.accesstime.equals(castOther.accesstime)
			&& (this.userId == castOther.userId)
			&& (this.deviceId == castOther.deviceId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.accesstime.hashCode();
		hash = hash * prime + this.userId;
		hash = hash * prime + this.deviceId;
		
		return hash;
	}
}