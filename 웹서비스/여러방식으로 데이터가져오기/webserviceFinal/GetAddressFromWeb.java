package webserviceFinal;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


public class GetAddressFromWeb extends PersonManager {
	
	private URL url;
	
	public GetAddressFromWeb(URL url, MyEventListener listener) throws Exception {
		super();
		this.url = url;
		this.listener = listener;
	}
	
	public void run() {
		try {
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type","text/xml; charset=\"utf-8\"");
			
			SOAPMaker maker = new SOAPMaker();
			maker.setServiceNamespace("http://webservice.class.inje.ac.kr");
			maker.setOperationName("getPersons");
			
			String message = maker.getRequestMessage();
			
			OutputStream out = conn.getOutputStream();
			out.write(message.getBytes("utf-8"));
			out.flush();
			
			InputStream in = conn.getInputStream();
			maker.soapMessageParser(in);
			ArrayList<DataObject> list = maker.getData();
			for(int i=0; i<list.size(); i++) {
				Person person = new Person();
				person.setData("name", list.get(i).getValue("name"));
				person.setData("age", list.get(i).getValue("age"));
				address.put(list.get(i).getValue("name"), person);
			}
			complete(new ArrayList<Person>(address.values()));
		} catch(Exception e) {}
	}

}
