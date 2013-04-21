package controllers;

import static play.libs.Json.toJson;

import java.util.List;

import models.PatientPanel;




import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;


import service.DemographicsService;


public class CassandraCntrls extends Controller {

    @Transactional
    public static Result createPatient(String patientname) {
        return ok(DemographicsService.createPatient(patientname));
    }

    @Transactional(readOnly = true)
    public static Result getPatient(String patientId) {
		return ok(toJson(DemographicsService.getPatient(patientId)));
    }
}





/*package controllers;

import static play.libs.Json.toJson;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;

import models.Address;
import models.PatientDemographics;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import resources.GlobalConstants;

import service.DemographicsService;

*//**
 *  Simple Controller for Kundera requests
 *//*
public class CassandraCntrls extends Controller {

    @Transactional
    public static Result createPatient(String patientname) {
        return ok(DemographicsService.createPatient(patientname));
    }

    @Transactional(readOnly = true)
    public static Result getPatientList(String patientIdList) {
		return ok(toJson(DemographicsService.getPatientList(patientIdList)));
    }
    
    @Transactional(readOnly = true)
    public static Result getPatient(String patientId) {
		return ok(toJson(DemographicsService.getPatient(patientId)));
    }
}
*/