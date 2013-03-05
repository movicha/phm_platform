package models;

import java.util.ArrayList;

import resources.Element;
import utilities.XhtmlNode;

// Uses MySQL and Cassandra as backing data store
// Needs two implememations - one to play.db.jpa.Model, one to play.db.nosql.Model
public interface Narrative extends Element {
	public NarrativeStatus status(); //The status of the narrative - whether it's entirely generated (from just the defined data or the extensions too), or whether a human authored it and it may contain additional data
	public  XhtmlNode div(); //The actual narrative content, a stripped down version of XHTML
	public ArrayList image(); //array of images referred to directly in the xhtml

	public enum NarrativeStatus {
	    NarrativeStatusGenerated , // The contents of the narrative are entirely generated from the structured data in the resource.
	    NarrativeStatusExtensions, //The contents of the narrative are entirely generated from the structured data in the resource and some of the content is generated from extensions
	    NarrativeStatusAdditional, //The contents of the narrative contain additional information not found in the structured data
	    NarrativeStatusEmpty //the contents of the narrative are some equivalent of "No human readable text provided for this resource"
	}
}