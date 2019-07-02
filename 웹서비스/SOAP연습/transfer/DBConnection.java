package transfer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBConnection {
	
	public ArrayList<Person> getDb() {
		Statement stmt = null;
		ArrayList<Person> list = null;
		Connection conn = null;
		ResultSet rs = null;

		try {
			list = new ArrayList<Person>();
			conn = DriverManager.getConnection("jdbc:mysql://192.168.152.132/web2019?user=hs&password=1234&serverTimezone=UTC&useSSL=false");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from address");

			while (rs.next()) {
				Person person = new Person();
				person.setName(rs.getString("name"));
				person.setAge(rs.getString("age"));
				person.setAddress(rs.getString("address"));
				list.add(person);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void putDb(ArrayList<Person> list) {
		Statement stmt = null;
		Connection conn = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection("jdbc:mysql://192.168.152.132/web2019?user=hs&password=1234&serverTimezone=UTC&useSSL=false");
			stmt = conn.createStatement();
			for(int i=0; i<list.size(); i++) {
				String name = list.get(i).getName();
				String age = list.get(i).getAge();
				String address = list.get(i).getAddress();
				stmt.execute("insert into address(name, age, address) values('"+name+"', "+age+", '"+address+"')");
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateData(String name, String age, String address) {
		Statement stmt = null;
		Connection conn = null;

		try {
			conn = DriverManager.getConnection("jdbc:mysql://192.168.152.132/web2019?user=hs&password=1234&serverTimezone=UTC&useSSL=false");
			stmt = conn.createStatement();
			stmt.execute("update address set age='"+age+"', address='"+address+"' where name='"+name+"'");		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteData(String name) {
		Statement stmt = null;
		Connection conn = null;

		try {
			conn = DriverManager.getConnection("jdbc:mysql://192.168.152.132/web2019?user=hs&password=1234&serverTimezone=UTC&useSSL=false");
			stmt = conn.createStatement();
			stmt.execute("delete from address where name='"+name+"'");		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
