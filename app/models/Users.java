package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;

@Entity
public class Users  {

	@Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer user_id;

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	@Required
	public String email;

	public String getEmail() {

		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
