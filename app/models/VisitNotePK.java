package models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the visit_notes database table.
 * 
 */
@Embeddable
public class VisitNotePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int visit_ID;

	private int user_ID;

	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date note_Date;

	public VisitNotePK() {
	}
	public int getVisit_ID() {
		return this.visit_ID;
	}
	public void setVisit_ID(int visit_ID) {
		this.visit_ID = visit_ID;
	}
	public int getUser_ID() {
		return this.user_ID;
	}
	public void setUser_ID(int user_ID) {
		this.user_ID = user_ID;
	}
	public java.util.Date getNote_Date() {
		return this.note_Date;
	}
	public void setNote_Date(java.util.Date note_Date) {
		this.note_Date = note_Date;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof VisitNotePK)) {
			return false;
		}
		VisitNotePK castOther = (VisitNotePK)other;
		return 
			(this.visit_ID == castOther.visit_ID)
			&& (this.user_ID == castOther.user_ID)
			&& this.note_Date.equals(castOther.note_Date);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.visit_ID;
		hash = hash * prime + this.user_ID;
		hash = hash * prime + this.note_Date.hashCode();
		
		return hash;
	}
}