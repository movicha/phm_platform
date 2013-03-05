package resources;

public interface NodeType  {
	public String author(); //author of node
	public String name(); //name of node
	public String descriptionLong();
	public String descriptionShort(); //description of node in 2 formats
	public String nodeType(); //type of this Node

	public String getAllKnownNodeTypes();
	public void setType(String typeOfNode);
}