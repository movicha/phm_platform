package models;

// Uses MySQL and Cassandra as backing data store
// Needs two implememations - one to play.db.jpa.Model, one to play.db.nosql.Model
public interface Demographics extends Type {
	private ArrayList name; //A name associated with the individual. Array of "HumanName" in case name has changed over time.
	private ArrayList telecom; //A contact detail (e.g. a telephone number or an email address) by which the individual may be contacted. Array of "Contact" in case multiple forms of contact. 
	private Coding gender; //Administrative Gender - the gender that the patient is considered to have for administration / record keeping purposes
	private Date birthDate; //The birth date for the individual, to the degre of precision now
	private boolean deceased; //Indicates if the individual is deceased or not	
	private ArrayList address; //One or more addresses for the individual
	private CodeableConcept maritalStatus; //This field contains a patient's marital (civil) status.
	private ArrayList language; //A language spoken by the person, with proficiency. Array contains Languages only
}