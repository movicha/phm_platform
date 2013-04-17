package models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the provider_schedule database table.
 * 
 */
@Entity
@Table(name="provider_schedule")
public class ProviderSchedule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="schedule_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int scheduleId;

	@Column(name="max_start")
	private int maxStart;

	@Column(name="min_start")
	private int minStart;

	@Column(name="schedule_duration")
	private int scheduleDuration;

	@Column(name="schedule_time")
	private int scheduleTime;

	//bi-directional many-to-one association to PatientPanel
	@OneToMany(mappedBy="providerSchedule")
	private List<PatientPanel> patientPanels;

	public ProviderSchedule() {
	}

	public int getScheduleId() {
		return this.scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public int getMaxStart() {
		return this.maxStart;
	}

	public void setMaxStart(int maxStart) {
		this.maxStart = maxStart;
	}

	public int getMinStart() {
		return this.minStart;
	}

	public void setMinStart(int minStart) {
		this.minStart = minStart;
	}

	public int getScheduleDuration() {
		return this.scheduleDuration;
	}

	public void setScheduleDuration(int scheduleDuration) {
		this.scheduleDuration = scheduleDuration;
	}

	public int getScheduleTime() {
		return this.scheduleTime;
	}

	public void setScheduleTime(int scheduleTime) {
		this.scheduleTime = scheduleTime;
	}

	public List<PatientPanel> getPatientPanels() {
		return this.patientPanels;
	}

	public void setPatientPanels(List<PatientPanel> patientPanels) {
		this.patientPanels = patientPanels;
	}

}