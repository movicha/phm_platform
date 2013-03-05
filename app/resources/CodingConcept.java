package resources;

import java.util.ArrayList;

// A concept that may be defined by a formal reference to a terminology or ontology or may be provided by text
public interface CodingConcept extends Type {
	public ArrayList coding(); //A reference to a code defined by a terminology system. Contains "coding" objects only.
	public String text(); //A human language representation of the concept as seen/selected/uttered by the user who entered the data and/or which represents the intended meaning of the user or concept
	public String primary(); //Indicates which of the codes in the codings was chosen by a user, if one was chosen directly
}