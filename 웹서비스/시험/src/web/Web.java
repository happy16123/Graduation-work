package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.jws.WebService;

@WebService(targetNamespace="http://web.class.inje.ac.kr")
public class Web implements IWeb{

	@Override
	public int insertData(Row data) {
		Statement stmt = null;
		Connection conn = null;

		try {
			conn = DriverManager.getConnection("jdbc:mysql://192.168.152.132/web2019?user=hs&password=1234&serverTimezone=UTC&useSSL=false");
			stmt = conn.createStatement();
			String company = data.getCompany();
			String name = data.getName();
			String price = data.getPrice();
			stmt.execute("insert into t20143133(company, name, price) values('"+company+"', '"+name+"', "+price+")");
			
		} catch (SQLException e) {
			return 0;
		}
		return 1;
	}

	@Override
	public ArrayList<Row> selectData(String price) {
		Statement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		ArrayList<Row> list = null;
		
		try {
			list = new ArrayList<>();
			conn = DriverManager.getConnection("jdbc:mysql://192.168.152.132/web2019?user=hs&password=1234&serverTimezone=UTC&useSSL=false");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from t20143133 where price<"+price);
			
			while(rs.next()) {
				Row row = new Row();
				row.setCompany(rs.getString("company"));
				row.setName(rs.getString("name"));
				row.setPrice(rs.getInt("price")+"");
				list.add(row);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
