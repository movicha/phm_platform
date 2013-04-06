package models;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the patient_users database table.
 * 
 */
@Entity
@Table(name="patient_users")
public class PatientUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PatientUserPK id;

	private byte approved;

	@Column(name="approved_method")
	private String approvedMethod;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="authorization_request")
	private Date authorizationRequest;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="User_id")
	private User user;

	public PatientUser() {
	}

	public PatientUserPK getId() {
		return this.id;
	}

	public void setId(PatientUserPK id) {
		this.id = id;
	}

	public byte getApproved() {
		return this.approved;
	}

	public void setApproved(byte approved) {
		this.approved = approved;
	}

	public String getApprovedMethod() {
		return this.approvedMethod;
	}

	public void setApprovedMethod(String approvedMethod) {
		this.approvedMethod = approvedMethod;
	}

	public Date getAuthorizationRequest() {
		return this.authorizationRequest;
	}

	public void setAuthorizationRequest(Date authorizationRequest) {
		this.authorizationRequest = authorizationRequest;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}