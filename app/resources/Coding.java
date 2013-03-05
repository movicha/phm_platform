package resources;

import utilities.Uri;

//A reference to a code defined by a terminology system
public interface Coding extends Type {
	public Uri system(); //The identification of the system that defines the meaning of the symbol in the code. Can be a simple list of enumerations, a list of codes with meanings or all the way to a complex semantic web such as SNOMED-CT, whether classification, terminology, or ontology
	public Code code(); //A symbol in syntax defined by the system. The symbol may be a predefined code or an expression in a syntax defined by the coding system
	public String display(); //A representation of the meaning of the code in the system, following the rules laid out by the system.
}
