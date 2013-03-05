package models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the agency_certificate database table.
 * 
 */
@Embeddable
public class AgencyCertificatePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int agencyID;

	private String certification;

	public AgencyCertificatePK() {
	}
	public int getAgencyID() {
		return this.agencyID;
	}
	public void setAgencyID(int agencyID) {
		this.agencyID = agencyID;
	}
	public String getCertification() {
		return this.certification;
	}
	public void setCertification(String certification) {
		this.certification = certification;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AgencyCertificatePK)) {
			return false;
		}
		AgencyCertificatePK castOther = (AgencyCertificatePK)other;
		return 
			(this.agencyID == castOther.agencyID)
			&& this.certification.equals(castOther.certification);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.agencyID;
		hash = hash * prime + this.certification.hashCode();
		
		return hash;
	}
}