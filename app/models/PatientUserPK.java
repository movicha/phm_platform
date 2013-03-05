package models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the patient_users database table.
 * 
 */
@Embeddable
public class PatientUserPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="patient_id")
	private int patientId;

	@Column(name="user_id")
	private int userId;

	public PatientUserPK() {
	}
	public int getPatientId() {
		return this.patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public int getUserId() {
		return this.userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PatientUserPK)) {
			return false;
		}
		PatientUserPK castOther = (PatientUserPK)other;
		return 
			(this.patientId == castOther.patientId)
			&& (this.userId == castOther.userId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.patientId;
		hash = hash * prime + this.userId;
		
		return hash;
	}
}