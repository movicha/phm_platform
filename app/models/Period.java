package models;

import java.util.Date;

import resources.Type;

// Uses MySQL and Cassandra as backing data store
// Needs two implememations - one to play.db.jpa.Model, one to play.db.nosql.Model
public interface Period extends Type {
	public Date start(); //The start of the period. The boundary is inclusive.
	public Date end(); //The end of the period. If the high is missing, it means that the period is ongoing
}
