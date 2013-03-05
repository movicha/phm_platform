package utilities;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Map;

import resources.NodeType;

public interface XhtmlNode {
	public NodeType node(); //decides node type
	public String name(); //name variable
	public Dictionary attributes();
	public Map attributes1(); //Map<String, String> Atributes = new HashMap<String, String>();
	public ArrayList childNodes(); //array of XhtmlNodes
	public String content(); //content of this XhtmlNode

	public String getNodeType(); //NodeType value
	public void setNodeType(String nodeType); //set NodeType value
	public void setContent(String content);
	public XhtmlNode addTag(String name);
	public XhtmlNode addTag(Integer index, String name);
	public XhtmlNode addComment(String content);
	public XhtmlNode addDocType(String content);
	public XhtmlNode addInstruction(String content);
	public XhtmlNode addText(String content);
	public XhtmlNode addText(Integer index, String content);
	public boolean allChildrenAreText();
	public XhtmlNode getElement(String name);
	public String allText();
	public void attribute(String name, String value);
	public String getAttribute(String name);
	public void setAttribute(String name, String value);
}