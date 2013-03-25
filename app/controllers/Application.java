package controllers;

import static play.libs.Json.toJson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ObjectNode;

import models.User;
import models.Patient;
import play.Logger;
import dao.CoreDaoImpl;

import play.api.templates.Html;
import play.data.DynamicForm;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import resources.GlobalConstants;
import service.UserAuthService;
import views.html.*;

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

}
