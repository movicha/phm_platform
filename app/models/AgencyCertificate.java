package models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the agency_certificate database table.
 * 
 */
@Entity
@Table(name="agency_certificate")
public class AgencyCertificate implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AgencyCertificatePK id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date validForm;

	@Temporal(TemporalType.TIMESTAMP)
	private Date validTo;

	//bi-directional many-to-one association to Agency
	@ManyToOne
	@JoinColumn(name="AgencyID")
	private Agency agency;

	public AgencyCertificate() {
	}

	public AgencyCertificatePK getId() {
		return this.id;
	}

	public void setId(AgencyCertificatePK id) {
		this.id = id;
	}

	public Date getValidForm() {
		return this.validForm;
	}

	public void setValidForm(Date validForm) {
		this.validForm = validForm;
	}

	public Date getValidTo() {
		return this.validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	public Agency getAgency() {
		return this.agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}

}