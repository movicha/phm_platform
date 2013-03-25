package service;

import java.util.List;

import models.Patient;
import models.User;
import dao.CoreDaoImpl;

public class UserAuthService {
	
	public static List<User> authenticateUser(String username,String password,int userType)
	{
		return new CoreDaoImpl().findUser(username, password, userType);
	}
	
	public static List<Patient> getPatientByUser(Integer userId)
	{
		return new CoreDaoImpl().findPatientByUserId(userId);
	}

}
