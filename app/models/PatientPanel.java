package models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the patient_panel database table.
 * 
 */
@Entity
@Table(name="patient_panel")
public class PatientPanel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="panel_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int panelId;

	@Column(name="address_id")
	private int addressId;

	@Column(name="patient_id")
	private int patientId;

	//bi-directional many-to-one association to Visit
	@ManyToOne
	private Visit visit;

	//bi-directional many-to-one association to ProviderSchedule
	@ManyToOne
	@JoinColumn(name="schedule_id")
	private ProviderSchedule providerSchedule;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="provider_id")
	private User user;

	public PatientPanel() {
	}

	public int getPanelId() {
		return this.panelId;
	}

	public void setPanelId(int panelId) {
		this.panelId = panelId;
	}

	public int getAddressId() {
		return this.addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public int getPatientId() {
		return this.patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public Visit getVisit() {
		return this.visit;
	}

	public void setVisit(Visit visit) {
		this.visit = visit;
	}

	public ProviderSchedule getProviderSchedule() {
		return this.providerSchedule;
	}

	public void setProviderSchedule(ProviderSchedule providerSchedule) {
		this.providerSchedule = providerSchedule;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}