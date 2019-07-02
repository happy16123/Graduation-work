package soapTest;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class SOAPDataManager extends RemoteDataManager {

	private String urlString;
	private SOAPMaker soapMaker;
	private Element rootNode;

	public SOAPDataManager(String urlString, RemoteDataHandler handler) throws Exception {
		super();
		this.urlString=urlString;
		this.handler=handler;
		soapMaker = new SOAPMaker();
	}

	public void setNamespace(String namespace) {
		soapMaker.setServiceNamespace(namespace);
	}

	public void setOperationName(String name) {
		soapMaker.setOperationName(name);
	}

	public void setParameterArrayListObject(String sequence, ArrayList<DataObject> objects) throws Exception {
		soapMaker.setParameterArrayListObject(sequence,objects);
	}
	
	public void setParameter(String sequence, String value) throws Exception{
		soapMaker.setParameter(sequence, value);
	}
	public void setParameter(String sequence, DataObject object) {
		soapMaker.setParameter(sequence, object);
	}

	public void run() {
		try{
			URL url = new URL(urlString);
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");

			connection.setRequestProperty("Content-Type","text/xml; charset=\"utf-8\"");
			connection.setRequestProperty("Target-Host",urlString);

			OutputStream out = connection.getOutputStream();

			byte data[] = soapMaker.getRequestMessage().getBytes("utf-8");
			out.write(data,0,data.length);
			out.flush();
			out.close();

			this.soapMessageParser(connection.getInputStream());
		}catch(Exception e) {}
	}

	private void soapMessageParser(InputStream in) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder parser = factory.newDocumentBuilder();
		Document doc = parser.parse(in);
		rootNode=doc.getDocumentElement();

		Node returnNode = this.getNode("return");
		while(returnNode!=null) {
			if(returnNode.getNodeType()==Node.ELEMENT_NODE) {
				this.datas.add(new DataObject(returnNode));
			}
			returnNode=returnNode.getNextSibling();
		}
		complete(this);
	}

	private Node getNode(String nodeName) {
		Node node = rootNode;

		while((node=getFirstChildNodeTypeNode(node))!=null) {
			if(node.getNodeName().equals(nodeName))
				return node;
		}

		return null;
	}

	private Node getFirstChildNodeTypeNode(Node node) {
		if(node.getChildNodes().getLength()<1)
			return null;

		node=node.getFirstChild();
		while(node.getNodeType()!=Node.ELEMENT_NODE)
			node=node.getNextSibling();

		return node;
	}
}

