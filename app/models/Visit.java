package models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.*;

import models.PatientPanel;


/**
 * The persistent class for the visit database table.
 * 
 */
@Entity
@Table(name="visit")
public class Visit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String description;

	private int visit_Completed;

	private int visit_Started;

	private int visitduration;

	//bi-directional many-to-one association to PatientPanel
	@OneToMany(mappedBy="visit")
	private List<PatientPanel> patientPanels;

	//bi-directional many-to-one association to VisitNote
	@OneToMany(mappedBy="visit")
	private List<VisitNote> visitNotes;

	public Visit() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getVisit_Completed() {
		return this.visit_Completed;
	}

	public void setVisit_Completed(int visit_Completed) {
		this.visit_Completed = visit_Completed;
	}

	public int getVisit_Started() {
		return this.visit_Started;
	}

	public void setVisit_Started(int visit_Started) {
		this.visit_Started = visit_Started;
	}

	public int getVisitduration() {
		return this.visitduration;
	}

	public void setVisitduration(int visitduration) {
		this.visitduration = visitduration;
	}

	public List<PatientPanel> getPatientPanels() {
		return this.patientPanels;
	}

	public void setPatientPanels(List<PatientPanel> patientPanels) {
		this.patientPanels = patientPanels;
	}

	public List<VisitNote> getVisitNotes() {
		return this.visitNotes;
	}

	public void setVisitNotes(List<VisitNote> visitNotes) {
		this.visitNotes = visitNotes;
	}

}