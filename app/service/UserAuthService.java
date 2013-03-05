package service;

import dao.CoreDaoImpl;

public class UserAuthService {
	
	public static boolean authenticateUser(String username,String password,int userType)
	{
		return new CoreDaoImpl().findUser(username, password, userType);
	}

}
