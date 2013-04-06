package service;

import java.util.ArrayList;
import java.util.List;

import models.PatientUser;
import models.User;
import dao.CoreDaoImpl;

public class UserAuthService {
	
	public static List<User> authenticateUser(String username,String password,int userType)
	{
		return new CoreDaoImpl().findUser(username, password, userType);
	}
	
	public static List<Integer> getPatientByUser(Integer userId)
	{
		List<PatientUser> patientUser = new CoreDaoImpl().findPatientByUserId(userId);
		List<Integer> patienIdList    = new ArrayList<Integer>();
		for(PatientUser pUser : patientUser)
		{
			patienIdList.add(pUser.getId().getPatientId());
		}
		
		return patienIdList;
	}

}
