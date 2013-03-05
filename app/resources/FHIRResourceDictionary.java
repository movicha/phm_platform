package resources;

import java.util.Dictionary;

public interface FHIRResourceDictionary  {
	public Dictionary dataForResource(); //distionary of resources
	public String resourceName(); //name of resource dictionary
	public String resourceType(); //type of resource the dictionary itself is
	
	//public void setDataForKey(String key, Data id);
}
