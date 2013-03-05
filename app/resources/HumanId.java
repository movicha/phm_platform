package resources;

import models.Period;

public interface HumanId extends Type {
	public IdentifierUse use(); //Identifies the use for this identifier, if known
	public String label(); //A label for the identifier that can be displayed to a human so they can recognise the identifier
	public Identifier identifier(); //The identifier itself
	public Period period(); //Time period during which identifier was valid for use
	public ResourceReference assigner(); //Organisation that issued/manages the identifier

	public enum IdentifierUse {
	    IdentifierUseUusual, // the identifier recommended for display and use in real-world interactions
	    IdentifierUseOfficial, // the identifier considered to be most trusted for the identification of this item
	    IdentifierUseTemp //A temporary identifier
	};
}
