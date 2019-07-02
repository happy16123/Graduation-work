package webserviceFinal;
import java.net.Socket;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;

public class PersonManagerDelegator {

	private PersonManager personManager;
	private MyEventListener listener;


	public PersonManagerDelegator(ArrayList<String> list, MyEventListener listener) {
		this.listener=listener;
		//personManager = new GetAddressFromArrayList(list, listener);
	}

	public PersonManagerDelegator(String filename, MyEventListener listener) throws Exception {
		this.listener=listener;
		personManager = new GetAddressFromFile(filename,listener);
	}

	public PersonManagerDelegator(Socket socket, MyEventListener listener) throws Exception {
		this.listener=listener;
		//personManager = new GetAddressFromSocket(socket,listener);
	}

	public PersonManagerDelegator(Connection connection, MyEventListener listener) throws Exception {
		this.listener=listener;
		personManager = new GetAddressFromDB(connection,listener);
	}
	
	public PersonManagerDelegator(URL url, MyEventListener listener) throws Exception{
		this.listener = listener;
		personManager = new GetAddressFromWeb(url, listener);
	}

	public void start() {
		try{
			personManager.start();
		}catch(Exception e){}
	}
}





