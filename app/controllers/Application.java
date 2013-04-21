package controllers;

import static play.libs.Json.toJson;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.User;
import models.Visit;

import org.codehaus.jackson.JsonNode;

import play.Logger;
import play.db.jpa.Transactional;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import resources.GlobalConstants;
import service.ScheduleService;
import service.UserAuthService;
import views.html.index;
import dao.CoreDaoImpl;
import views.html.*;

public class Application extends Controller {

	@Transactional
	public static Result index() {

		try {
			new CoreDaoImpl().patientPanelService(1, 9000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ok(index.render("Your new application is ready."));



	}

	//	public static Result getlogin()
	//	{
	//		return ok(main.render("Welcome to PhmHealth"));
	//	}
	/**
	 * 
	{
		"username" : "abc",
		"password" : "encrypted_password", // What is the encoding used on the server? 
		"usertype" : "1|2"
	}
	 * @return
	 */
	@Transactional
	@BodyParser.Of(BodyParser.Json.class)
	public static Result login()
	{

		JsonNode json = request().body().asJson();
		Logger.debug("login json "+json);
		String username = json.findPath(GlobalConstants.USERNAME).getTextValue();
		String password = json.findPath(GlobalConstants.PASSWORD).getTextValue();
		int gmtOffSet  = (int)(json.findPath(GlobalConstants.GMT_OFFSET).getIntValue())*60;
		Integer userType = Integer.parseInt(json.findPath(GlobalConstants.USERTYPE).getTextValue());
		Logger.debug("username "+username+"password *******"+"userType "+userType+" gmtoffset "+gmtOffSet);
		List<User> userRes = UserAuthService.authenticateUser(username, password, userType);
		List<Integer> patientList = null;
		
		if(userRes!=null&&userRes.size()>0)
		{
			int userId= userRes.get(0).getId();
			patientList = UserAuthService.getPatientByUser(userId);
			//System.out.println(Json.toJson(patientList));
			List<Map<String,Object>> strPatienlist = new ArrayList<Map<String,Object>>();

			
			if(patientList.size()>0)
			{
				return ok(UserAuthService.getPatientJson(userId, gmtOffSet));
			}else
			{
				Map<String ,List<Map<String,Object>>> patienMap = new HashMap<String, List<Map<String,Object>>>();
				patienMap.put(GlobalConstants.PATIENTS, strPatienlist);
				return ok(toJson(patienMap));
			}

			//return this to forntend
		}else
		{
			Map<String,String> failRes = new HashMap<String,String>();
			failRes.put(GlobalConstants.USERNAME,username);
			failRes.put(GlobalConstants.STATUS,GlobalConstants.STATUSINFO);
			Map<String ,Map> finalMap= new HashMap<String, Map>();
			finalMap.put(GlobalConstants.STATUSHEADER, failRes);
			return ok(toJson(finalMap));
			//in this case user not valid
		}

	}
	/**
	 * 
	{
		"providerid" : "1",
		"patientid" : "1", // What is the encoding used on the server? 
		"scheduleid":1

	}
	 * @return
	 */
	@Transactional
	@BodyParser.Of(BodyParser.Json.class)
	public static Result starttimer()
	{

		JsonNode json = request().body().asJson();
		String userid = json.findPath(GlobalConstants.PROVIDERID).getTextValue();
		String patientid = json.findPath(GlobalConstants.PATIENTID).getTextValue();
		String scheduleid = json.findPath(GlobalConstants.SCHEDULEID).getTextValue();
		Logger.debug("userid "+userid+" patientid"+patientid+" scheduleid"+scheduleid);
		try{
			Visit visit = new Visit();
			int startTime =(int) ((System.currentTimeMillis())/1000);
			visit.setVisit_Started(startTime);

			ScheduleService.onStartService(visit);
			Map<String , Integer> pPanel = new HashMap<String, Integer>();
			pPanel.put(GlobalConstants.PATIENTID,Integer.parseInt(patientid));
			pPanel.put(GlobalConstants.SCHEDULEID,Integer.parseInt(scheduleid));
			pPanel.put(GlobalConstants.PROVIDERID,Integer.parseInt(userid));
			pPanel.put(GlobalConstants.VISITID,visit.getId());
			ScheduleService.updateVisitId(pPanel,visit);
			Map<String,Object> failRes = new HashMap<String,Object>();
			failRes.put(GlobalConstants.VISITID,visit.getId());
			failRes.put(GlobalConstants.VISITSTARTED,GlobalConstants.SUCCESS);
			Map<String ,Map> finalMap= new HashMap<String, Map>();
			finalMap.put(GlobalConstants.STARTSERVICERESPONSE, failRes);
			return ok(toJson(finalMap));
		}catch(Exception e)
		{
			e.printStackTrace();
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
		"providerid" : "1",
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
		String userid = json.findPath(GlobalConstants.PROVIDERID).getTextValue();
		String patientid = json.findPath(GlobalConstants.PATIENTID).getTextValue();
		String visitid = json.findPath(GlobalConstants.VISITID).getTextValue();
		String duration = json.findPath(GlobalConstants.DURATION).getTextValue();
		//Integer userType = Integer.parseInt(json.findPath(GlobalConstants.USERTYPE).getTextValue());
		Logger.debug("userid "+userid+" patientid"+patientid);
		try{
			Visit visit = new Visit();
			visit.setId(Integer.parseInt(visitid));
			visit.setVisitduration(Integer.parseInt(duration));
			int endTime =(int) ((System.currentTimeMillis())/1000);
			visit.setVisit_Completed(endTime);

			ScheduleService.onEndService(visit);
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

	@Transactional
	@BodyParser.Of(BodyParser.Json.class)
	public static Result getPatientPanel()
	{

		JsonNode json = request().body().asJson();
		int userId = json.findPath(GlobalConstants.USERID).getIntValue();
		int gmtOffSet  = json.findPath(GlobalConstants.GMT_OFFSET).getIntValue();
		Logger.debug("getPatientPanel : userId "+userId+" gmtOffSet "+gmtOffSet);
		
		if(userId>0)
		{
				return ok(UserAuthService.getPatientJson(userId, gmtOffSet));
		}else
		{
			Map<String,String> failRes = new HashMap<String,String>();
			failRes.put(GlobalConstants.USERID,""+userId);
			failRes.put(GlobalConstants.STATUS,GlobalConstants.STATUSINFO);
			Map<String ,Map> finalMap= new HashMap<String, Map>();
			finalMap.put(GlobalConstants.STATUSHEADER, failRes);
			return ok(toJson(finalMap));
			//in this case user not valid
		}

	}

	
	
}
