package models;

import java.util.Date;

import resources.CodeableConcept;
import resources.Identifier;
import utilities.Uri;

// Uses MySQL as backing data store
// Needs play.db.jpa.Model implementation
public interface IDevice {
	// This resource identifies a manufactured entity that is used in the provision of healthcare. The device may be a machine, an insert, a computer, an application, etc.
    // Allows agencies to track their devices.
	public CodeableConcept type();    // Describes what kind of device that this
	                                  // CodeableConcept from DeviceKind
	public String manufacturer();     // The name of the manufacturer
	public String model(); 		      // The "model" - an identifier assigned by the manufacturer to identify the product by it's type. This number is shared by the all devices sold as the same type
	public String version(); 		  // The version of the device, if the device has multiple releases under the same model, or if the device is software or carries firmware
	public Identity identity();	      // Universal Device Id fields
								      // In order to carry UDI (US regulations, but being adopted across the world)

	public Resource owner();		  // The organization that is responsible for the provision and ongoing maintenance of the device
	public Identifier assignedId();   // Identifiers assigned to this device by various organizations (unless other specific fields exist for them)
									  // Often fixed to the device as a barcode. May include names given to the device in local usage
	public Resource location();		  // The resource may be found in a literal location (i.e. GPS coordinates), a logical place (i.e. "in/with the patient"), or a coded location
	public Resource patient();		  // If the resource is affixed to a person
	public Contact contact();		  // Contact details for an organization or a particular human that is responsible for the device
									  // used for troubleshooting etc.
	public Uri url();				  // A network address on which the device may be contacted directly
									  // if the device is running a FHIR server, the network address should be the root URL from which a conformance statement may be retrieved

	public interface Identity {       //	Universal Device Id fields
								      //	In order to carry UDI (US regulations, but being adopted across the world)
		public String gtin(); 		  //	The number assigned to this device by an authorised issuer of Device GITNs
									  //	This is a 14 digit number that may include leading 0s
		public String lot();		  //	Lot number of manufacture
									  //	Alphanumeric Maximum 20
		public String serialNumber(); //	The serial number assigned by the organisation when the device was manufactured
									  //	Alphanumeric Maximum 20
		public Date expiry();		  //	Date of expiry of this device (if applicable)
	}
}