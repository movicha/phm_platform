package cassandramodels;

import java.io.Serializable;

import javax.inject.Singleton;
import javax.persistence.*;

import com.clouidio.orm.api.base.anno.NoSqlEntity;
import com.clouidio.orm.api.base.anno.NoSqlId;

import java.util.List;


/**
 * The persistent class for the address database table.
 *
 */
@Singleton
@NoSqlEntity
public class PatientAddress implements Serializable {
	private static final long serialVersionUID = 1L;

	@NoSqlId
	private int id;

	private String city;

	private String country;

	private String elevation;

	private String geosphereradius;

	private String position;

	private String state;

	//@Column(name="street_1")
	private String street1;

	//@Column(name="street_2")
	private String street2;

	//@Column(name="street_3")
	private String street3;

	private String zip;

	//@OneToMany
	//private List<PatientDemographics> patient;

/*	//bi-directional many-to-one association to Agency
	@OneToMany(mappedBy="address")
	private List<Agency> agencies;
	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="address")
	private List<User> users;
*/

	public PatientAddress() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getElevation() {
		return this.elevation;
	}

	public void setElevation(String elevation) {
		this.elevation = elevation;
	}

	public String getGeosphereradius() {
		return this.geosphereradius;
	}

	public void setGeosphereradius(String geosphereradius) {
		this.geosphereradius = geosphereradius;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreet1() {
		return this.street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	public String getStreet2() {
		return this.street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getStreet3() {
		return this.street3;
	}

	public void setStreet3(String street3) {
		this.street3 = street3;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

/*	public List<Agency> getAgencies() {
		return this.agencies;
	}

	public void setAgencies(List<Agency> agencies) {
		this.agencies = agencies;
	}

	public List<PatientDemographics> getPatient() {
		return this.patient;
	}

	public void setUsers(List<PatientDemographics> patient) {
		this.patient = patient;
	}
*/
}