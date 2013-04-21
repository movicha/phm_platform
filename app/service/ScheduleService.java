package service;

import java.util.List;

import dao.CoreDaoImpl;
import models.PatientPanel;
import models.Visit;

public class ScheduleService {
	
	public static void onStartService(Visit visit) throws Exception
	{
		new CoreDaoImpl().saveOnStartService(visit);
	}
	public static void onEndService(Visit visit) throws Exception
	{
		new CoreDaoImpl().updateOnStartService(visit);
	}
	public static List<PatientPanel> patientPanelService(int providerId, int gmtDiffTime) throws Exception
	{
		return new CoreDaoImpl().patientPanelService(providerId, gmtDiffTime);
	}

}
