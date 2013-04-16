package cassandramodels;



import javax.inject.Singleton;

import com.clouidio.orm.api.base.anno.NoSqlEntity;
import com.clouidio.orm.api.base.anno.NoSqlId;
import com.clouidio.orm.api.base.anno.NoSqlIndexed;



@Singleton
@NoSqlEntity
public class PatientDemographics  {


	@NoSqlId
	private int patientid;

	@NoSqlIndexed
	private String patientfirstname;

	@NoSqlIndexed
	private String patientlastname;

	
	@NoSqlIndexed
	private String patientgender;
	// @OneToMany(mappedBy="AddressId")
	// @ManyToOne
	private int addressid;
	// private Address address;

	private String phonenum;

	private String maritalstatus;

	//private Date dateOfBirth;
	private String dateOfBirth;

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public int getPatientid() {
		return patientid;
	}

	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}

	// public String getPatientname() {
	// return patientname;
	// }
	//
	//
	// public void setPatientname(String patientname) {
	// this.patientname = patientname;
	// }

	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}

	public String getPatientfirstname() {
		return patientfirstname;
	}

	public void setPatientfirstname(String patientfirstname) {
		this.patientfirstname = patientfirstname;
	}

	public String getPatientlastname() {
		return patientlastname;
	}

	public void setPatientlastname(String patientlastname) {
		this.patientlastname = patientlastname;
	}

	public String getPatientgender() {
		return patientgender;
	}

	public void setPatientgender(String patientgender) {
		this.patientgender = patientgender;
	}

	public String getMaritalstatus() {
		return maritalstatus;
	}

	public void setMaritalstatus(String maritalstatus) {
		this.maritalstatus = maritalstatus;
	}

	public int getAddressid() {
		return addressid;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
}