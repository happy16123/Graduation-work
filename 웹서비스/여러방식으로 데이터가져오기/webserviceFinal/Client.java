package webserviceFinal;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;


public class Client implements MyEventListener {

	public static void main(String args[]) throws Exception {

		Client client = new Client();
		
		URL url = new URL("http://192.168.152.132/hello/HelloWorld");
		PersonManagerDelegator soap = new PersonManagerDelegator(url, client);
		soap.start();

		/*PersonManagerDelegator text = new PersonManagerDelegator("address.txt", client);
		text.start();*/
		/*Connection connection = DriverManager.getConnection("jdbc:mysql://203.241.251.177/com2019?user=guest&password=guest&serverTimezone=UTC&useSSL=false");
		PersonManagerDelegator db = new PersonManagerDelegator(connection, client);
		db.start();*/
	}

	public void complete(String message) {
		System.out.println(message);
	}

	public void complete(Object object) {
		PersonManager manager = (PersonManager)object;
		System.out.println(manager.getKeys().length);
		Person person = manager.getPerson("이성계");
		System.out.println(person.getGender());

		String keys[] = manager.getKeys();
		for(int i=0;i<keys.length;i++)
			System.out.println(manager.getPerson(keys[i]).getData("name"));
	}
	
	public void complete(ArrayList<Person> list) {
		
		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i).getData("name"));

	}

}