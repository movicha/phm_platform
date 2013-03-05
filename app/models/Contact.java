package models;

import resources.Type;



// Uses MySQL as backing data store
// Needs play.db.jpa.Model implementation
public interface Contact extends Type  {
	public ContactSystem system(); //What kind of contact this is - what communications system is required to make use of the contact
	public ContactUse use(); //The actual contact details, in a form that is meaningful to the designated communication system (i.e. phone number or email address).
	public String value();//Identifies the context for the address
	public Period period(); //Time period when the contact was/is in use

	public enum ContactSystem {
	    ContactSystemPhone, //The value is a telephone number used for voice calls. Use of full international numbers starting with + is recommended to enable automatic dialing support but not required.
	    ContactSystemFax, //The value is a fax machine. Use of full international numbers starting with + is recommended to enable automatic dialing support but not required.
	    ContactSystemEmail, //The value is an email address
	    ContactSystemUrl //The value is a url. This is intended for various personal contacts including blogs, Twitter, Facebook, etc. Do not use for email addresses
	};

	public enum ContactUse {
	    ContactUseHome , //A communication contact at a home; attempted contacts for business purposes might intrude privacy and chances are one will contact family or other household members instead of the person one wishes to call. Typically used with urgent cases, or if no other contacts are available.
	    ContactUseWork, //An office contact. First choice for business related contacts during business hours.
	    ContactUseTemp, //A temporary contact. The period can provide more detailed information.
	    ContactUseOld, //This contact is no longer in use (or was never correct, but retained for records)
	    ContactUseMobile //A telecommunication device that moves and stays with its owner. May have characteristics of all other use codes, suitable for urgent matters, not the first choice for routine business
	};
}

