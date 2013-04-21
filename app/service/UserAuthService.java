package service;

import static play.libs.Json.toJson;

import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.PatientPanel;
import models.PatientUser;
import models.User;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;

import play.libs.WS;
import play.libs.WS.Response;
import resources.GlobalConstants;
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

	public static JsonNode getPatientJson(int userId, int gmtOffSet)
	{
//		ObjectMapper mapper = new ObjectMapper();
//		StringBuffer sb = new StringBuffer();
//		for(Integer p :patientList)
//		{
//			sb.append(p+"-");
//		}
		try{
			//JsonNode rootNode = toJson(DemographicsService.getPatientList(sb.toString()));
			
			List<PatientPanel> patientPanelList = ScheduleService.patientPanelService(userId, gmtOffSet);

			Map<String, List<Map<String, Object>>> patientMap = DemographicsService.getPatientList(patientPanelList, gmtOffSet);

			JsonNode rootNode = toJson(patientMap);
			//JsonNode rootNode = mapper.readTree(promise.get().getBody());
			((ObjectNode)rootNode).put("userid", userId);
			return rootNode;
		}catch(Exception e)
		{
			Map<String,String> failRes = new HashMap<String,String>();
			failRes.put(GlobalConstants.USERNAME,""+userId);
			failRes.put(GlobalConstants.STATUS,"Error in geting Patients");
			return toJson(failRes);
		}

	}

}
