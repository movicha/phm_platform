package resources;

public interface HumanId extends Type {
	private IdentifierUse use; //Identifies the use for this identifier, if known
	private String label; //A label for the identifier that can be displayed to a human so they can recognise the identifier
	private Identifier identifier; //The identifier itself
	private Period period; //Time period during which identifier was valid for use
	private ResourceReference assigner; //Organisation that issued/manages the identifier

	protected enum IdentifierUse {
	    IdentifierUseUusual, // the identifier recommended for display and use in real-world interactions
	    IdentifierUseOfficial, // the identifier considered to be most trusted for the identification of this item
	    IdentifierUseTemp //A temporary identifier
	};
}
