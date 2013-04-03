package controllers;

import static play.libs.Json.toJson;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.User;
import models.Patient;
import models.Visit;

import dao.CoreDaoImpl;

import play.Logger;
import play.data.DynamicForm;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import resources.GlobalConstants;
// import service.ScheduleService;
import service.UserAuthService;
import views.html.*;
import org.codehaus.jackson.JsonNode;
import play.mvc.BodyParser;


public class Application extends Controller {

	@Transactional
	public static Result index() {

		new CoreDaoImpl().findPatientByUserId(101);

		return ok(index.render("Your new application is ready."));

	}

	@Transactional
	@BodyParser.Of(BodyParser.Json.class)
	public static Result login() {

		JsonNode json = request().body().asJson();
		String username = json.findPath(GlobalConstants.USERNAME)
				.getTextValue();
		String password = json.findPath(GlobalConstants.PASSWORD)
				.getTextValue();
		Integer userType = Integer.parseInt(json.findPath(
				GlobalConstants.USERTYPE).getTextValue());
		Logger.debug("username " + username + "password *******" + "userType "
				+ userType);
		List<User> userRes = UserAuthService.authenticateUser(username,
				password, userType);
		List<Patient> patientList = null;
		if (userRes != null && userRes.size() > 0) {
			patientList = UserAuthService.getPatientByUser(userRes.get(0)
					.getId());
			// System.out.println(Json.toJson(patientList));
			List<Map<String, Object>> strPatienlist = new ArrayList<Map<String, Object>>();

			for (Patient p : patientList) {
				Map<String, Object> pMap = new HashMap<String, Object>();
				pMap.put(GlobalConstants.PATIENTID, p.getPatientId());
				pMap.put(GlobalConstants.PATIENTFIRSTNAME, p.getFirstname());
				pMap.put(GlobalConstants.PATIENTLASTNAME, p.getLastname());
				pMap.put(GlobalConstants.PATIENTLOC, p.getLocation());
				strPatienlist.add(pMap);
			}
			Map<String, List<Map<String, Object>>> patienMap = new HashMap<String, List<Map<String, Object>>>();
			patienMap.put(GlobalConstants.PATIENTS, strPatienlist);
			return ok(toJson(patienMap));

		} else {

			Map<String, String> failRes = new HashMap<String, String>();
			failRes.put(GlobalConstants.USERNAME, username);
			failRes.put(GlobalConstants.STATUS, GlobalConstants.STATUSINFO);
			Map<String, Map> finalMap = new HashMap<String, Map>();
			finalMap.put(GlobalConstants.STATUSHEADER, failRes);
			return ok(toJson(finalMap));

		}

	}
	/**
	 * 
	{
		"doctorid" : "1",
		"patientid" : "1", // What is the encoding used on the server? 
		
	}
	 * @return
	 */
	@Transactional
	@BodyParser.Of(BodyParser.Json.class)
	public static Result starttimer()
	{

		JsonNode json = request().body().asJson();
		String userid = json.findPath(GlobalConstants.DOCTORID).getTextValue();
		String patientid = json.findPath(GlobalConstants.PATIENTID).getTextValue();
		//Integer userType = Integer.parseInt(json.findPath(GlobalConstants.USERTYPE).getTextValue());
		Logger.debug("userid "+userid+" patientid"+patientid);
		try{
			Visit visit = new Visit();
			visit.setPatient_ID(Integer.parseInt(patientid));
			visit.setProvider_ID(Integer.parseInt(userid));
			visit.setScheduled_date(new Date(System.currentTimeMillis()));
			visit.setScheduled_Duration(30);
			visit.setVisit_Started(new Date(System.currentTimeMillis()));

			// ScheduleService.onStartService(visit);
			Map<String,Object> failRes = new HashMap<String,Object>();
			failRes.put(GlobalConstants.VISITID,visit.getId());
			failRes.put(GlobalConstants.VISITSTARTED,GlobalConstants.SUCCESS);
			Map<String ,Map> finalMap= new HashMap<String, Map>();
			finalMap.put(GlobalConstants.STARTSERVICERESPONSE, failRes);
			return ok(toJson(finalMap));
		}catch(Exception e)
		{

			Map<String,Object> failRes = new HashMap<String,Object>();
			failRes.put(GlobalConstants.VISITID,0);
			failRes.put(GlobalConstants.VISITSTARTED,GlobalConstants.FAILURE);
			Map<String ,Map> finalMap= new HashMap<String, Map>();
			finalMap.put(GlobalConstants.STARTSERVICERESPONSE, failRes);
			return ok(toJson(finalMap));
			//in this case user not valid
		}

	}
	
	/**
	 * 
	{
		"doctorid" : "1",
		"patientid" : "1",
		"visitid":"1",
		"duration":"30"
		 // What is the encoding used on the server? 
		
	}
	 * @return
	 */
	@Transactional
	@BodyParser.Of(BodyParser.Json.class)
	public static Result endtimer()
	{

		JsonNode json = request().body().asJson();
		String userid = json.findPath(GlobalConstants.DOCTORID).getTextValue();
		String patientid = json.findPath(GlobalConstants.PATIENTID).getTextValue();
		String visitid = json.findPath(GlobalConstants.VISITID).getTextValue();
		String duration = json.findPath(GlobalConstants.DURATION).getTextValue();
		//Integer userType = Integer.parseInt(json.findPath(GlobalConstants.USERTYPE).getTextValue());
		Logger.debug("userid "+userid+" patientid"+patientid);
		try{
			Visit visit = new Visit();
			visit.setId(Integer.parseInt(visitid));
			visit.setPatient_ID(Integer.parseInt(patientid));
			visit.setProvider_ID(Integer.parseInt(userid));
			// visit.setScheduled_date(new Date(System.currentTimeMillis()));
			visit.setScheduled_Duration(Integer.parseInt(duration));
			visit.setVisit_Completed(new Date(System.currentTimeMillis()));

			// ScheduleService.onEndService(visit);
			Map<String,Object> failRes = new HashMap<String,Object>();
			failRes.put(GlobalConstants.VISITID,visit.getId());
			failRes.put(GlobalConstants.VISITENDED,GlobalConstants.SUCCESS);
			Map<String ,Map> finalMap= new HashMap<String, Map>();
			finalMap.put(GlobalConstants.ENDSERVICERESPONSE, failRes);
			return ok(toJson(finalMap));
		}catch(Exception e)
		{

			Map<String,Object> failRes = new HashMap<String,Object>();
			failRes.put(GlobalConstants.VISITID,0);
			failRes.put(GlobalConstants.VISITENDED,GlobalConstants.FAILURE);
			Map<String ,Map> finalMap= new HashMap<String, Map>();
			finalMap.put(GlobalConstants.ENDSERVICERESPONSE, failRes);
			return ok(toJson(finalMap));
			//in this case user not valid
		}

	}


}
