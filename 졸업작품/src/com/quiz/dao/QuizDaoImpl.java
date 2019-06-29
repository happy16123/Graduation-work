package com.quiz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.database.DBConnection;
import com.quiz.dto.QuizDto;

public class QuizDaoImpl implements QuizDao {

	@Override
	public ArrayList<QuizDto> qList(int startNo) {
		ArrayList<QuizDto> list = new ArrayList<QuizDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBConnection db = new DBConnection();
		
		try {
			conn = db.connect();
			String sql = "select * from quiz where codeno > 0 order by codeno desc limit " + startNo + ", 10";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				QuizDto dto = new QuizDto();
				dto.setCodeno(rs.getInt("codeno"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setCodeframe(rs.getString("codeframe"));
				dto.setAnswerClassName(rs.getString("answerclassname"));
				dto.setTestClassName(rs.getString("testclassname"));
				dto.setSuccess(rs.getInt("success"));
				dto.setFail(rs.getInt("fail"));
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
	public ArrayList<QuizDto> qList(int startNo, String regid) {
		ArrayList<QuizDto> list = new ArrayList<QuizDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBConnection db = new DBConnection();
		
		try {
			conn = db.connect();
			String sql = "select * from testcode where regid=\""+regid+"\" and codeno > 0 order by codeno desc, regdate desc limit " + startNo + ", 10";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {	
				QuizDto dto = new QuizDto();
				dto.setCodeno(rs.getInt("codeno"));
				dto.setResult(rs.getString("result"));
				dto.setTitle(rs.getString("title"));
				dto.setRegid(rs.getString("regid"));
				dto.setRegdate(rs.getString("regdate"));
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
	public QuizDto qSelect(int codeno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBConnection db = new DBConnection();
		QuizDto dto = new QuizDto();
		
		try {
			conn = db.connect();
			String sql = "select * from quiz where codeno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, codeno);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {	
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setAnswerClassName(rs.getString("answerclassname"));
				dto.setTestClassName(rs.getString("testclassname"));
				dto.setCodeframe(rs.getString("codeframe"));
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
	public int qUpdate(int codeno, String result) {
		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		DBConnection db = new DBConnection();
		String sql = "";
		
		try {
			conn = db.connect();
			if(result.equals("SUCCESS!!"))
				sql = "update quiz set success = success + 1 where codeno = ?";
			else
				sql = "update quiz set fail = fail + 1 where codeno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, codeno);
			pstmt.execute();
			
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
	public int qInsert(QuizDto dto) {
		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		DBConnection db = new DBConnection();
		try {
			conn = db.connect();
			String sql = "insert into quiz(title, content, codeframe, answerclassname, testclassname) value(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getCodeframe());
			pstmt.setString(4, dto.getAnswerClassName());
			pstmt.setString(5, dto.getTestClassName());
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
	public int qInsert(QuizDto dto, String regid) {
		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		DBConnection db = new DBConnection();
		try {
			conn = db.connect();
			String sql = "insert into testcode(title, result, regid) value(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getResult());
			pstmt.setString(3, regid);
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
			String sql = "select count(codeno) from quiz";
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
			String sql = "select count(" + regid + ") from testcode";
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
