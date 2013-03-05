package resources;

import utilities.Uri;

public interface Identifier extends Type {
	public  Uri system(); //Establishes the namespace in which set of possible id values is unique.
	public String idNumber(); //The portion of the identifier typically displayed to the user and which is unique within the context of the system.
}
