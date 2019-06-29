package com.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.board.dto.BoardDto;
import com.database.DBConnection;

public class BoardImpl implements BoardDao {

	@Override
	public ArrayList<BoardDto> bList(int startNo) {		
		ArrayList<BoardDto> list = new ArrayList<BoardDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBConnection db = new DBConnection();
		
		try {
			conn = db.connect();
			//String sql = "select * from board";
			String sql = "select * from board where bseq > 0 order by bseq desc, regdate desc limit " + startNo + ", 10";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {	
				BoardDto dto = new BoardDto();
				dto.setBseq(rs.getInt("bseq"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setRegid(rs.getString("regid"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setViewCnt(rs.getInt("viewcnt"));
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
	public BoardDto bSelect(int bseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBConnection db = new DBConnection();
		BoardDto dto = new BoardDto();
		
		try {
			conn = db.connect();
			String viewcnt = "update board set viewcnt=viewcnt+1 where bseq = ?";
			pstmt = conn.prepareStatement(viewcnt);
			pstmt.setInt(1, bseq);
			pstmt.executeUpdate();
			
			String sql = "select * from board where bseq = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bseq);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setBseq(rs.getInt("bseq"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setRegid(rs.getString("regid"));
				dto.setRegdate(rs.getString("regdate"));
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
	public int bDelete(int bseq) {
		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		DBConnection db = new DBConnection();
		
		try {
			conn = db.connect();
			String sql = "delete from board where bseq = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bseq);
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
	public int bUpdate(BoardDto dto) {
		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		DBConnection db = new DBConnection();
		
		try {
			conn = db.connect();
			String sql = "update board set title = ?, content = ? where bseq = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setInt(3, dto.getBseq());
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
	public int bInsert(BoardDto dto) {
		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		DBConnection db = new DBConnection();
		
		try {
			conn = db.connect();
			String sql = "insert into board (title, content, regid)" + "values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getRegid());
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
			String sql = "select count(bseq) from board";
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
