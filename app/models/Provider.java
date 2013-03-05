package models;

import resources.CodingConcept;
import resources.Identifier;

// Uses MySQL as backing data store
// Needs play.db.jpa.Model implementation
public interface Provider {
	public Identifier identifier(); //An identifier that applies to this person in this role
	public Demographics details(); //Demographic details
	public Resource organization(); //The organisation that is being represented
	public CodingConcept role(); //The way in which the person represents the organisation - what role do they have?
	public CodingConcept specialty(); //A specific specialty within the healthcare facility under which the agent acts
	public Period period(); //The time period during which the agent was/is authorised to represent the organisation.
}