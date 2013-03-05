package models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_access_log database table.
 * 
 */
@Entity
@Table(name="user_access_log")
public class UserAccessLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserAccessLogPK id;

	private float lat;

	private float lng;

	//bi-directional many-to-one association to Device
	@ManyToOne
	@JoinColumn(name="device_id",insertable=false,updatable=false)
	private Device device;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id" ,insertable=false,updatable=false)
	private User user;

	public UserAccessLog() {
	}

	public UserAccessLogPK getId() {
		return this.id;
	}

	public void setId(UserAccessLogPK id) {
		this.id = id;
	}

	public float getLat() {
		return this.lat;
	}

	public void setLat(float lat) {
		this.lat = lat;
	}

	public float getLng() {
		return this.lng;
	}

	public void setLng(float lng) {
		this.lng = lng;
	}

	public Device getDevice() {
		return this.device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}