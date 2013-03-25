package models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the patient database table.
 * 
 */
@Entity
public class Patient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="patient_id")
	private int patientId;

	private String location;
	
	//private String name;

	@Column(name="first_name")
	private String firstname;
	
	

	@Column(name="last_name")
	private String lastname;


	//bi-directional many-to-one association to PatientUser
	@OneToMany(mappedBy="patient")
	private List<PatientUser> patientUsers;

	public Patient() {
	}

	public int getPatientId() {
		return this.patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public List<PatientUser> getPatientUsers() {
		return this.patientUsers;
	}

	public void setPatientUsers(List<PatientUser> patientUsers) {
		this.patientUsers = patientUsers;
	}

}