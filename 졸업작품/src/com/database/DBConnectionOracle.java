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

public class DBConnectionOracle {
	
	public Connection connect() {
		Connection conn = null;
	    String url = "jdbc:oracle:thin:@localhost:1521:xe";
	    String username = "scott";
	    String password = "tiger";
	     
	    try {
	    	DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
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