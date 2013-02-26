package models;

// Uses MySQL and Cassandra as backing data store
// Needs two implememations - one to play.db.jpa.Model, one to play.db.nosql.Model
public interface Resource extends Element {
	private ArrayList extensions; //an array of extension objects
	private Narrative text; //contents of resource
	private ResourceType resourceType; //type designation of resource
}