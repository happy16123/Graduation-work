/**
 * 
 */
/**
 * @author HS
 * 데이터베이스 연결
 */
package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
	
	public Connection connect() {
		Connection conn = null;
		String url = "jdbc:mariadb://192.168.152.131:3306/web?useSSL=false&serverTimezone=Asia/Seoul";
	    String username = "hs";
	    String password = "1234";
		/*String url = "jdbc:mariadb://localhost/web?useSSL=false&serverTimezone=Asia/Seoul";
		String username = "root";
	    String password = "admin";*/
	     
	    try {
	    	Class.forName("org.mariadb.jdbc.Driver");
	    	conn = DriverManager.getConnection(url, username, password);
	    } catch(SQLException se) {
	    	se.printStackTrace();
	    } catch(Exception e) {
	    	e.printStackTrace();
	    }
	    return conn;
	}
	
	public void close(PreparedStatement pstmt, Connection conn) {
		try {
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
	    } catch(SQLException se) {
	    	se.printStackTrace();
	    } catch(Exception e) {
	    	e.printStackTrace();
	    }
	}
	
	public void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
	    } catch(SQLException se) {
	    	se.printStackTrace();
	    } catch(Exception e) {
	    	e.printStackTrace();
	    }
	}
}