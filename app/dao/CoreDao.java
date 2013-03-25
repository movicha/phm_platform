package dao;

import java.util.List;

import models.Patient;
import models.User;

interface CoreDao {
	
	public List<User> findUser(String username, String password,int userType);
	public List<Patient> findPatientByUserId(Integer userId);

}
