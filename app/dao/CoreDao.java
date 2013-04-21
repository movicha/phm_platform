package dao;

import java.util.List;

import models.PatientPanel;
import models.PatientUser;
import models.User;
import models.Visit;

interface CoreDao {
	
	public List<User> findUser(String username, String password,int userType);
	public List<PatientUser> findPatientByUserId(Integer userId);
	
	public void saveOnStartService(Visit visit) throws Exception;
	public void updateOnStartService(Visit visit) throws Exception;
	
	public List<PatientPanel> patientPanelService(int providerId,int gmtDiffTime) throws Exception;

}
