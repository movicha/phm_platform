package models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String email;

	private String first_Name;

	private String last_Name;

	private String username;
	
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	//bi-directional many-to-one association to PatientUser
	@OneToMany(mappedBy="user")
	private List<PatientUser> patientUsers;

	//bi-directional many-to-one association to Address
	@ManyToOne
	private Address address;

	//bi-directional many-to-many association to Agency
	@ManyToMany
	@JoinTable(
		name="agency_users"
		, joinColumns={
			@JoinColumn(name="user_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="AgencyID")
			}
		)
	private List<Agency> agencies;

	//bi-directional many-to-many association to Device
	@ManyToMany
	@JoinTable(
		name="user_devices"
		, joinColumns={
			@JoinColumn(name="user_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="device_id")
			}
		)
	private List<Device> devices;

	//bi-directional many-to-one association to UserType
	@ManyToOne
	@JoinColumn(name="User_type_id")
	private UserType userType;

	//bi-directional many-to-one association to UserAccessLog
	@OneToMany(mappedBy="user")
	private List<UserAccessLog> userAccessLogs;

	//bi-directional many-to-one association to VisitNote
	@OneToMany(mappedBy="user")
	private List<VisitNote> visitNotes;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirst_Name() {
		return this.first_Name;
	}

	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}

	public String getLast_Name() {
		return this.last_Name;
	}

	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<PatientUser> getPatientUsers() {
		return this.patientUsers;
	}

	public void setPatientUsers(List<PatientUser> patientUsers) {
		this.patientUsers = patientUsers;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Agency> getAgencies() {
		return this.agencies;
	}

	public void setAgencies(List<Agency> agencies) {
		this.agencies = agencies;
	}

	public List<Device> getDevices() {
		return this.devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

	public UserType getUserType() {
		return this.userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public List<UserAccessLog> getUserAccessLogs() {
		return this.userAccessLogs;
	}

	public void setUserAccessLogs(List<UserAccessLog> userAccessLogs) {
		this.userAccessLogs = userAccessLogs;
	}

	public List<VisitNote> getVisitNotes() {
		return this.visitNotes;
	}

	public void setVisitNotes(List<VisitNote> visitNotes) {
		this.visitNotes = visitNotes;
	}

}