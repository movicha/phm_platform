package controllers;

import static play.libs.Json.toJson;

import java.util.HashMap;
import java.util.Map;

import play.data.DynamicForm;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import service.UserAuthService;
import views.html.*;

public class Application extends Controller {

	@Transactional
	public static Result index() {

		return ok(index.render("Your new application is ready."));

	}

	public static Result getlogin() {
		return ok(main.render("Welcome to PhmHealth"));
	}

	@Transactional
	public static Result login() {
		// Users user = JPA.em("default").find(Users.class, 1);
		DynamicForm requestData = new DynamicForm().bindFromRequest();
		String username = requestData.get("name");
		System.out.println("<<<<<<<<<<<<<<<<<<<<" + username);
		String password = requestData.get("password");
		String userType = requestData.get("usertype");

		boolean test = UserAuthService.authenticateUser(username, password,
				Integer.parseInt(userType));
		if (test) {
			Map<String, String> d = new HashMap<String, String>();
			d.put("user", username);
			d.put("status", "authenticated");
			Map<String, Map> m = new HashMap<String, Map>();
			m.put("AutenticationResponse", d);
			return ok(toJson(m));
		} else {
			Map<String, String> d = new HashMap<String, String>();
			d.put("user", username);
			d.put("status", "Notauthenticated");
			Map<String, Map> m = new HashMap<String, Map>();
			m.put("AutenticationResponse", d);
			return ok(toJson(m));
		}
		// if(user.getEmail().equals(name))
		// return ok("Congrats");
		// else
		// return ok("sorry");
	}

}
