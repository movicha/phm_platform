package resources;

public interface HumanName extends Type {
	private NameUse use; //Identifies the purpose for this name
	private String text; //a full text representation of the name
	private ArrayList family; //Family name, this is the name that links to the genealogy. In some cultures (e.g. Eritrea) the family name of a son is the first name of his father. Array of NSStrings
	private ArrayList given; //Given name. NOTE: Not to be called "first name" since given names do not always come first. Array of NSStrings
	private ArrayList prefix; //Part of the name that is acquired as a title due to academic, legal, employment or nobility status, etc. and that comes at the start of the name. Array of NSStrings
	private ArrayList suffix; //Part of the name that is acquired as a title due to academic, legal, employment or nobility status, etc. and that comes at the end of the name. Array of NSStrings
	private Period period; //Indicates the period of time when this name was valid for the named person.

	protected enum NameUse {
	    usual = 1, //Known as/conventional/the one you normally use
	    official, //The formal name as registered in an official (government) registry, but which name might not be commonly used. May be called "legal name".
	    temp, //A temporary name. A name valid time can provide more detailed information. This may also be used for temporary names assigned at birth or in emergency situations.
	    nickname, //A name that is used to address the person in an informal manner, but is not part of their formal or usual name
	    annonymous, //Anonymous assigned name, alias, or pseudonym (used to protect a person's identity for privacy reasons)
	    old, //This name is no longer in use (or was never correct, but retained for records)
	    maiden //A name used prior to marriage. Marriage naming customs vary greatly around the world. This name use is for use by applications that collect and store "maiden" names. Though the concept of maiden name is often gender specific, the use of this term is not gender specific. The use of this term does not imply any particular history for a person's name, nor should the maiden name be determined algorithmically.
	};
}
