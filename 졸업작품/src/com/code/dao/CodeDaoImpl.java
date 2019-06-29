package com.code.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.code.dto.CodeDto;
import com.database.DBConnection;

public class CodeDaoImpl implements CodeDao {

	@Override
	public ArrayList<CodeDto> cList(int startNo) {
		ArrayList<CodeDto> list = new ArrayList<CodeDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBConnection db = new DBConnection();
		
		try {
			conn = db.connect();
			String sql = "select * from allcode where codeno > 0 order by codeno desc, regdate desc limit "  + startNo + ", 10";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {	
				CodeDto dto = new CodeDto();
				dto.setCode(rs.getString("content"));
				dto.setLanguage(rs.getString("language"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setCodeno(rs.getInt("codeno"));
				dto.setTitle(rs.getString("title"));
				list.add(dto);
			}
		} catch(SQLException se) {
			se.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs, pstmt, conn);
		}
		return list;
	}
	
	@Override
	public ArrayList<CodeDto> cList(int startNo, String regid) {
		ArrayList<CodeDto> list = new ArrayList<CodeDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBConnection db = new DBConnection();
		
		try {
			conn = db.connect();
			String sql = "select * from indivcode where regid=\""+regid+"\" and codeno > 0 order by codeno desc, regdate desc limit " + startNo + ", 10";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {	
				CodeDto dto = new CodeDto();
				dto.setCode(rs.getString("content"));
				dto.setTitle(rs.getString("title"));
				dto.setLanguage(rs.getString("language"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setCodeno(rs.getInt("codeno"));
				list.add(dto);
			}
		} catch(SQLException se) {
			se.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs, pstmt, conn);
		}
		return list;
	}
	
	@Override
	public CodeDto cSelect(int codeno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBConnection db = new DBConnection();
		CodeDto dto = new CodeDto();
		
		try {
			conn = db.connect();
			String sql = "select * from allcode where codeno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, codeno);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {	
				dto.setCode(rs.getString("content"));
				dto.setLanguage(rs.getString("language"));
			}
		} catch(SQLException se) {
			se.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs, pstmt, conn);
		}
		return dto;
	}
	
	@Override
	public CodeDto cSelect(int codeno, String regid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBConnection db = new DBConnection();
		CodeDto dto = new CodeDto();
		
		try {
			conn = db.connect();
			String sql = "select * from indivcode where codeno = ? and regid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, codeno);
			pstmt.setString(2, regid);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {	
				dto.setCode(rs.getString("content"));
				dto.setLanguage(rs.getString("language"));
			}
		} catch(SQLException se) {
			se.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs, pstmt, conn);
		}
		return dto;
	}

	@Override
	public int cInsert(CodeDto dto) {
		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		DBConnection db = new DBConnection();
		
		try {
			conn = db.connect();
			String sql = "insert into allcode(content, language, title) values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCode());
			pstmt.setString(2, dto.getLanguage());
			pstmt.setString(3, dto.getTitle());
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
	public int cInsert(CodeDto dto, String regid) {
		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		DBConnection db = new DBConnection();
		
		try {
			conn = db.connect();
			String sql = "insert into indivcode(content, language, regid, title) values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCode());
			pstmt.setString(2, dto.getLanguage());
			pstmt.setString(3, dto.getRegid());
			pstmt.setString(4, dto.getTitle());
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
	public int cDelete(int codeno, String regid) {
		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		DBConnection db = new DBConnection();
		
		try {
			conn = db.connect();
			String sql = "delete from indivcode where codeno = ? and regid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, codeno);
			pstmt.setString(2, regid);
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
	public int getTotalCount() {
		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBConnection db = new DBConnection();
		
		try {
			conn = db.connect();
			String sql = "select count(codeno) from allcode";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				res = rs.getInt(1);
			}
			
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
	public int getTotalCount(String regid) {
		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBConnection db = new DBConnection();
		
		try {
			conn = db.connect();
			String sql = "select count(" + regid + ") from indivcode";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				res = rs.getInt(1);
			}
			
		} catch(SQLException se) {
			se.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt, conn);
		}
		return res;
	}

}
