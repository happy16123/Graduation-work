/**
 * 
 */
/**
 * @author HS
 *
 */
package com.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.database.DBConnection;
import com.member.dto.MemberDto;

public class MemberDaoImpl implements MemberDao{

	@Override
	public boolean userCheck(String id, String password) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBConnection db = new DBConnection();
		
		boolean isUserCheck = false;
		
		try {
			conn = db.connect();
			String sql = "select id, password from member where id = ? and password = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			
			if(rs.next() == true) {
				isUserCheck = true;
			} else {
				isUserCheck = false;
			}
		} catch(Exception e) {
			db.close(rs, pstmt, conn);
		} finally {
			db.close(rs, pstmt, conn);
		}
		return isUserCheck;
	}

	@Override
	public int userInsert(MemberDto dto) {
		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		DBConnection db = new DBConnection();
		
		try {
			conn = db.connect();
			String sql = "insert into member (id, password)"
					+ "values(?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPassword());
			res = pstmt.executeUpdate();
		} catch(SQLException se) {
			se.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt, conn);
		}
		return res;
	}

	@Override
	public int userUpdate(MemberDto dto) {
		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		DBConnection db = new DBConnection();
		
		try {
			conn = db.connect();
			String sql = "update member set password = ? where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPassword());
			pstmt.setString(2, dto.getId());
			res = pstmt.executeUpdate();
		} catch(SQLException se) {
			se.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt, conn);
		}
		return res;
	}

	@Override
	public int userDelete(String id) {
		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		DBConnection db = new DBConnection();
		
		try {
			conn = db.connect();
			String sql = "delete from member where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
		} catch(SQLException se) {
			se.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt, conn);
		}
		return res;
	}

	@Override
	public MemberDto getMember(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBConnection db = new DBConnection();
		MemberDto dto = new MemberDto();
		
		try {
			conn = db.connect();
			String sql = "select * from member where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			rs.next();
			dto.setId(rs.getString("id"));
			dto.setPassword(rs.getString("password"));
			
		} catch(SQLException se) {
			se.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs, pstmt, conn);
		}
		return dto;
	}
	
}