package models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the devices database table.
 * 
 */
@Entity
@Table(name="devices")
public class Device implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int device_Unique_ID;

	private String device_ID;

	//bi-directional many-to-one association to DevicesType
	@ManyToOne
	@JoinColumn(name="Device_Type_Id")
	private DevicesType devicesType;

	//bi-directional many-to-many association to User
	@ManyToMany(mappedBy="devices")
	private List<User> users;

	//bi-directional many-to-one association to UserAccessLog
	@OneToMany(mappedBy="device")
	private List<UserAccessLog> userAccessLogs;

	public Device() {
	}

	public int getDevice_Unique_ID() {
		return this.device_Unique_ID;
	}

	public void setDevice_Unique_ID(int device_Unique_ID) {
		this.device_Unique_ID = device_Unique_ID;
	}

	public String getDevice_ID() {
		return this.device_ID;
	}

	public void setDevice_ID(String device_ID) {
		this.device_ID = device_ID;
	}

	public DevicesType getDevicesType() {
		return this.devicesType;
	}

	public void setDevicesType(DevicesType devicesType) {
		this.devicesType = devicesType;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<UserAccessLog> getUserAccessLogs() {
		return this.userAccessLogs;
	}

	public void setUserAccessLogs(List<UserAccessLog> userAccessLogs) {
		this.userAccessLogs = userAccessLogs;
	}

}