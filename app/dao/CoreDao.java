package dao;

interface CoreDao {
	
	public boolean findUser(String username, String password,int userType);

}
