package service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import models.PatientPanel;

import play.Logger;
import play.db.jpa.Transactional;

import com.clouidio.orm.api.base.NoSqlEntityManager;
import com.clouidio.play.NoSql;
//import com.clouidio.orm.models.test.Address;
import cassandramodels.*;



import resources.GlobalConstants;


public class DemographicsService {




	public static String createPatient(String patientname) {
		//EntityManager em = JPA.em();
		NoSqlEntityManager em = NoSql.em(); 
		String result = "";
		for(int i=0;i<11;i++)
		{
			PatientDemographics patient = new PatientDemographics();
			patient.setPatientid(i);
			PatientAddress addr = new PatientAddress();
			addr.setId(i);
			if(i == 1)
			{
				patient.setPatientfirstname("John");
				patient.setPatientlastname("Wang");
				patient.setPhonenum("5107983454");
				patient.setDateOfBirth("01-01-2008");
				addr.setStreet1(" Stevenon Blvd");
				addr.setStreet2("Apt 303 ");
				addr.setCity("Fremont");
				addr.setState("CA");
				addr.setCountry("USA");
				addr.setZip("94538");
				addr.setElevation("10"+i);
			}
			else if(i ==2)
			{
				patient.setPatientfirstname("Craig");
				patient.setPatientlastname("White");
				patient.setPhonenum("4087349810");
				patient.setDateOfBirth("01-01-2000");
				addr.setStreet1("655 Fair oaks Ave");
				addr.setStreet2("");
				addr.setCity("Sunnyvale");
				addr.setState("CA");
				addr.setCountry("USA");
				addr.setZip("94086");
			}
			else if(i == 3)
			{
				patient.setPatientfirstname("Henriques");
				patient.setPatientlastname("Moises");
				patient.setPhonenum("7323698954");
				patient.setDateOfBirth("01-01-1998");
				addr.setStreet1("Oak Tree Road");
				addr.setStreet2("");
				addr.setCity("Edison");
				addr.setState("NJ");
				addr.setCountry("USA");
				addr.setZip("08820");
			}else if(i == 10)
			{
				//Address addr = new Address();
				patient.setPatientid(1001);
				addr.setId(1001);
				patient.setPatientfirstname("John");
				patient.setPatientlastname("Dew");
				addr.setStreet1("Stevenon Blvd");
				addr.setStreet2("Apt 303 ");
				addr.setCity("San Jose");
				addr.setState("CA");
				addr.setCountry("USA");
				addr.setZip("94538");
				addr.setElevation("10");
				patient.setPhonenum("4082309719");
				patient.setDateOfBirth("01-02-1981");
				//patient.setAddressid(addr.getId());
				//System.out.println(" patient.getAddressid() "+patient.getAddressid());
				//em.persist(patient);
			}
			else
			{
				patient.setPatientfirstname(patientname);
				patient.setPatientlastname(patientname+"ln");
				addr.setStreet1(" street  "+i);
				addr.setStreet2("street 2 "+i);
				addr.setCity("Fremont");
				addr.setState("CA");
				addr.setCountry("USA");
				addr.setZip("9455"+i);
				patient.setPhonenum("4082309719");
				patient.setDateOfBirth("01-02-2008");
			}
			if(i%2==0)
			{
				patient.setPatientgender("male");
				patient.setMaritalstatus("Married");

			}
			else
			{
				patient.setPatientgender("female");
				patient.setMaritalstatus("Single");
			}
			addr.setElevation("10"+i);
			em.put(addr);
			em.flush();
			//em.persist(addr);
			System.out.println(" address count "+addr.getId());
			patient.setAddressid(addr.getId());
			System.out.println(" patient.getAddressid() "+patient.getAddressid());
			em.put(patient);
			em.flush();
			//em.persist(patient);
			result +="Created Patient: " + patient.getPatientid() + ": " + patientname+" :"+patient.getAddressid()+"\n";
		}

		return result;
	}

	// public static Map<String ,Map<String,Object>> getPatient(String patientId) {
	public static Map<String ,Object> getPatient(String patientId) {
		NoSqlEntityManager em = NoSql.em(); 
		//PatientDemographics patient = JPA.em().find(PatientDemographics.class, Integer.parseInt(patientId));
		//PatientDemographics patientDemographics = new PatientDemographics();
		//patientDemographics.setPatientid(Integer.parseInt(patientId));
		PatientDemographics patient = em.find(PatientDemographics.class,Integer.parseInt(patientId) );

		Map<String, Object> pMap = new HashMap<String, Object>();
		pMap.put(GlobalConstants.PATIENTID, patient.getPatientid());
		pMap.put(GlobalConstants.PATIENTFIRSTNAME, patient.getPatientfirstname());
		pMap.put(GlobalConstants.PATIENTLASTNAME, patient.getPatientlastname());
		pMap.put(GlobalConstants.PATIENT_GENDER, patient.getPatientgender());
		pMap.put(GlobalConstants.PATIENT_PHONE, patient.getPhonenum());
		pMap.put(GlobalConstants.PATIENT_MARITAL_STATUS, patient.getMaritalstatus());
		pMap.put(GlobalConstants.PATIENT_DATEOFBIRTH, patient.getDateOfBirth());
		int addr1 = patient.getAddressid();
		//for(Address addr:patient.getAddress())

		System.out.println(" address count "+addr1);
		if(addr1 > 0)
		{
			PatientAddress addr = em.find(PatientAddress.class, addr1);
			pMap.put(GlobalConstants.PATIENT_STREETADDR, addr.getStreet1());
			pMap.put(GlobalConstants.PATIENT_CITY, addr.getCity());
			pMap.put(GlobalConstants.PATIENT_STATE, addr.getState());
			pMap.put(GlobalConstants.PATIENT_COUNTRY, addr.getCountry());
			pMap.put(GlobalConstants.PATIENT_ZIPCODE, addr.getZip());
			//break;
		}
		return pMap;
	}

	public static Map<String, List<Map<String, Object>>> getPatientList(List<PatientPanel> patientPanelList, int gmtOffSet) {
		Map<String, Object> pMap = new HashMap<String, Object>();
		List<Map<String, Object>> strPatienlist = new ArrayList<Map<String, Object>>();

		for(int count=0;count<patientPanelList.size();count++)
		{
			PatientPanel panel = patientPanelList.get(count);
			int patientId =  panel.getPatientId();
			pMap = getPatient(""+patientId);
			long scheduleTime = (long)(panel.getProviderSchedule().getScheduleTime()-gmtOffSet) * 1000;
			Date sDate = new Date(scheduleTime);
	        DateFormat format = new SimpleDateFormat("MMM dd HH:mm");
	        String formatted = format.format(sDate);
	        Logger.debug( "formatted date "+formatted+" schedule time "+scheduleTime+" gmtOffset "+gmtOffSet+" actual time "+panel.getProviderSchedule().getScheduleTime());

		    //Logger.debug(" In  GetPatientDemographics : patientId "+patientId+" schedule "+scheduleTime+" sch time "+formatted);
			pMap.put(GlobalConstants.SCHEDULE_TIME, formatted);
			pMap.put(GlobalConstants.SCHEDULE_DURATION, panel.getProviderSchedule().getScheduleDuration());
			pMap.put(GlobalConstants.SCHEDULE_ID, panel.getProviderSchedule().getScheduleId());
			strPatienlist.add(pMap);
		}	
		
		//Map<String ,Map<String,Object>> patientMap = new HashMap<String, Map<String,Object>>();
		Map<String, List<Map<String, Object>>> patienMap = new HashMap<String, List<Map<String, Object>>>();
		patienMap.put(GlobalConstants.PATIENTS, strPatienlist);
		return patienMap;
		//return pMap;
	}
}













