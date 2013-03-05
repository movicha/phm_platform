package resources;

import utilities.Base64Binary;



public interface Image extends Element {
	public Code mimeType();
	public Base64Binary content();
}
