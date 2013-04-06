package service;

import dao.CoreDaoImpl;
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

}
