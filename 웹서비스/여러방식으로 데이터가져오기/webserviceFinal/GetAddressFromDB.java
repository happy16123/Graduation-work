package webserviceFinal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class GetAddressFromDB extends PersonManager {

	private Connection connection;

	public GetAddressFromDB(Connection connection, MyEventListener listener) throws Exception {
		super();
		this.connection = connection;
		this.listener = listener;
	}

	public void run() {
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select hakbun,name,tel,jumin,address from address");

			while (result.next()) {
				Person person = new Person();
				person.setData("hakbun", result.getString(1));
				person.setData("name", result.getString(2));
				person.setData("tel", result.getString(3));
				person.setData("jumin", result.getString(4));
				person.setData("address", result.getString(5));
				address.put(result.getString(2), person);
			}
			complete(new ArrayList<Person>(address.values()));
			
		} catch (Exception e) {
		}
	}
}
