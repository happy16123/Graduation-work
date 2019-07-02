package test;

import org.w3c.dom.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;

import org.w3c.dom.Node;


public class DataObject implements Serializable {
	private HashMap<String, String> objects;

	public DataObject() {
		objects = new HashMap<String,String>();
	}
	
	public DataObject(Node rootNode) {
		this();
		Node node = rootNode;
		if(rootNode.getChildNodes().getLength() > 1) {
			node = rootNode.getFirstChild();
			while(node.getNodeType() != Node.ELEMENT_NODE)
				node = node.getNextSibling();
		}
		
		while(node != null) {
			if(node.getNodeType() == Node.ELEMENT_NODE && node.getChildNodes().getLength() > 0) 
				objects.put(node.getNodeName(), node.getFirstChild().getNodeValue());
			node = node.getNextSibling();
		}
	}

	public String[] getKeys() {
		Set<String> keySet = objects.keySet();
		String keys[] = (String [])keySet.toArray(new String[0]);
		return keys;
	}
	
	public void setData(String key, String value) {
		objects.put(key,value);
	}
	
	public String getValue(String key) {
		return objects.get(key);
	}
	
	public HashMap<String,String> getObject(){
		return objects;
	}
}