package models;

import resources.CodingConcept;
import resources.Element;

// Uses MySQL and Cassandra as backing data store
// Needs two implememations - one to play.db.jpa.Model, one to play.db.nosql.Model
public interface Language extends Element {
	public CodingConcept language(); //The ISO-639-1 alpha 2 code in lower case for the language, optionally followed by a hyphen and the ISO-3166-1 alpha 2 code for the region in upper case. E.g. "en" for English, or "en-US" for American English versus "en-EN" for England English
	public CodingConcept mode(); //A value representing the person's method of expression of this language. Examples: expressed spoken, expressed written, expressed signed, received spoken, received written, received signed
	public CodingConcept proficiencyLevel(); //A code that describes how well the language is spoken
	public boolean preference(); //Indicates whether or not the Person prefers this language (over other languages he masters up a certain level)
}