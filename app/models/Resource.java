package models;

import java.util.ArrayList;

import resources.Element;
import resources.ResourceType;

// Uses MySQL and Cassandra as backing data store
// Needs two implememations - one to play.db.jpa.Model, one to play.db.nosql.Model
public interface Resource extends Element {
	public ArrayList extensions(); //an array of extension objects
	public Narrative text(); //contents of resource
	public ResourceType resourceType(); //type designation of resource
}