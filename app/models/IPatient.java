package models;

import java.util.ArrayList;

import resources.CodeableConcept;
import resources.FHIRResourceDictionary;
import resources.ResourceReference;
import resources.ResourceType;

// Uses MySQL and Cassandra as backing data store
// Needs two implememations - one to play.db.jpa.Model, one to play.db.nosql.Model
public interface IPatient extends Resource {
	public ResourceType getResourceType(); //override method. Returns integer of specified type, in this case Patient
	public FHIRResourceDictionary patientDictionary();
	public ArrayList link(); //THIS ARRAY IS FILLED WITH "ResourceReference" OBJECTS ONLY. A linked patient record is a record that concerns the same patient. Records are linked after it is realized that at least one was created in error.
	public boolean active(); //Whether the patient record is in use, or has been removed from active use
	public ArrayList identifier(); //THIS ARRAY IS FILLED WITH "HumanId" OBJECTS ONLY.. An identifier that applies to this person as a patient
	public Demographics details(); //Patient Demographic details
	public ResourceReference provider(); //The provider for whom this is a patient record
	public CodeableConcept diet(); //Dietary restrictions for the patient
	public CodeableConcept confidentiality(); //Confidentiality of the patient records
	public CodeableConcept recordLocation(); //The location of the paper record for the patient, if there is one
}
