package models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the visit_notes database table.
 * 
 */
@Entity
@Table(name="visit_notes")
public class VisitNote implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private VisitNotePK id;

	private String note;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	//bi-directional many-to-one association to Visit
	@ManyToOne
	private Visit visit;

	public VisitNote() {
	}

	public VisitNotePK getId() {
		return this.id;
	}

	public void setId(VisitNotePK id) {
		this.id = id;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Visit getVisit() {
		return this.visit;
	}

	public void setVisit(Visit visit) {
		this.visit = visit;
	}

}