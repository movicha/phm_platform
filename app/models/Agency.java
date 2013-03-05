package models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the agency database table.
 * 
 */
@Entity
public class Agency implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	private Date sign_Up_Date;

	private int size;

	//bi-directional many-to-one association to Address
	@ManyToOne
	private Address address;

	//bi-directional many-to-one association to AgencyCertificate
	@OneToMany(mappedBy="agency")
	private List<AgencyCertificate> agencyCertificates;

	//bi-directional many-to-many association to User
	@ManyToMany(mappedBy="agencies")
	private List<User> users;

	public Agency() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getSign_Up_Date() {
		return this.sign_Up_Date;
	}

	public void setSign_Up_Date(Date sign_Up_Date) {
		this.sign_Up_Date = sign_Up_Date;
	}

	public int getSize() {
		return this.size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<AgencyCertificate> getAgencyCertificates() {
		return this.agencyCertificates;
	}

	public void setAgencyCertificates(List<AgencyCertificate> agencyCertificates) {
		this.agencyCertificates = agencyCertificates;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}