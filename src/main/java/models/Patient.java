package models;

import resources.*;

// Uses MySQL and Cassandra as backing data store
// Needs two implememations - one to play.db.jpa.Model, one to play.db.nosql.Model
public interface Patient extends Resource {
	private Integer getResourceType; //override method. Returns integer of specified type, in this case Patient
	private FHIRResourceDictionary patientDictionary;
	private ArrayList link; //THIS ARRAY IS FILLED WITH "ResourceReference" OBJECTS ONLY. A linked patient record is a record that concerns the same patient. Records are linked after it is realized that at least one was created in error.
	private boolean active; //Whether the patient record is in use, or has been removed from active use
	private ArrayList identifier; //THIS ARRAY IS FILLED WITH "HumanId" OBJECTS ONLY.. An identifier that applies to this person as a patient
	private Demographics details; //Patient Demographic details
	private ResourceReference provider; //The provider for whom this is a patient record
	private CodeableConcept diet; //Dietary restrictions for the patient
	private CodeableConcept confidentiality; //Confidentiality of the patient records
	private CodeableConcept recordLocation; //The location of the paper record for the patient, if there is one
}
