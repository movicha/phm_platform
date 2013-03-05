package models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the visit database table.
 * 
 */
@Entity
public class Visit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int address_id;

	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	private Date max_Start;

	@Temporal(TemporalType.TIMESTAMP)
	private Date min_Start;

	private int patient_ID;

	private int provider_ID;

	@Temporal(TemporalType.TIMESTAMP)
	private Date scheduled_date;

	private int scheduled_Duration;

	@Temporal(TemporalType.TIMESTAMP)
	private Date visit_Completed;

	@Temporal(TemporalType.TIMESTAMP)
	private Date visit_Started;

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

	public int getAddress_id() {
		return this.address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getMax_Start() {
		return this.max_Start;
	}

	public void setMax_Start(Date max_Start) {
		this.max_Start = max_Start;
	}

	public Date getMin_Start() {
		return this.min_Start;
	}

	public void setMin_Start(Date min_Start) {
		this.min_Start = min_Start;
	}

	public int getPatient_ID() {
		return this.patient_ID;
	}

	public void setPatient_ID(int patient_ID) {
		this.patient_ID = patient_ID;
	}

	public int getProvider_ID() {
		return this.provider_ID;
	}

	public void setProvider_ID(int provider_ID) {
		this.provider_ID = provider_ID;
	}

	public Date getScheduled_date() {
		return this.scheduled_date;
	}

	public void setScheduled_date(Date scheduled_date) {
		this.scheduled_date = scheduled_date;
	}

	public int getScheduled_Duration() {
		return this.scheduled_Duration;
	}

	public void setScheduled_Duration(int scheduled_Duration) {
		this.scheduled_Duration = scheduled_Duration;
	}

	public Date getVisit_Completed() {
		return this.visit_Completed;
	}

	public void setVisit_Completed(Date visit_Completed) {
		this.visit_Completed = visit_Completed;
	}

	public Date getVisit_Started() {
		return this.visit_Started;
	}

	public void setVisit_Started(Date visit_Started) {
		this.visit_Started = visit_Started;
	}

	public List<VisitNote> getVisitNotes() {
		return this.visitNotes;
	}

	public void setVisitNotes(List<VisitNote> visitNotes) {
		this.visitNotes = visitNotes;
	}

}