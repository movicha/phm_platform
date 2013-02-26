package models;

// Uses MySQL as backing data store
// Needs play.db.jpa.Model implementation
public interface Provider {
	private Identifier identifier; //An identifier that applies to this person in this role
	private Demographics details; //Demographic details
	private Resource organization; //The organisation that is being represented
	private CodeableConcept role; //The way in which the person represents the organisation - what role do they have?
	private CodeableConcept specialty; //A specific specialty within the healthcare facility under which the agent acts
	private Period period; //The time period during which the agent was/is authorised to represent the organisation.
}