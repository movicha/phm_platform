package resources;

public interface Identifier extends Type {
	private String Uri system; //Establishes the namespace in which set of possible id values is unique.
	private String idNumber; //The portion of the identifier typically displayed to the user and which is unique within the context of the system.
}
