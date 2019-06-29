package com.reply.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.database.DBConnection;
import com.reply.dto.ReplyDto;

public class ReplyDaoImpl implements ReplyDao {

	@Override
	public ArrayList<ReplyDto> rList(int bseq, int startNo) {
		ArrayList<ReplyDto> list = new ArrayList<ReplyDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBConnection db = new DBConnection();
		
		try {
			conn = db.connect();
			String sql = "select * from reply where bseq = " + bseq + " order by replyno desc limit " + startNo + ", 10";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ReplyDto dto = new ReplyDto();
				dto.setBseq(rs.getInt("bseq"));
				dto.setReplyNo(rs.getInt("replyno"));
				dto.setReplyText(rs.getString("content"));
				dto.setReplyWriter(rs.getString("regid"));
				dto.setRegDate(rs.getString("regdate"));
				dto.setUpdateDate(rs.getString("updatedate"));
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
	public int rInsert(ReplyDto dto) {
		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		DBConnection db = new DBConnection();
		
		try {
			conn = db.connect();
			String sql = "insert into reply (bseq, content, regid, regdate, updatedate) values(?,?,?,default,default)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getBseq());
			pstmt.setString(2, dto.getReplyText());
			pstmt.setString(3, dto.getReplyWriter());
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
	public int rUpdate(ReplyDto dto) {
		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		DBConnection db = new DBConnection();
		
		try {
			conn = db.connect();
			String sql = "update reply set content = ?, updatedate = now() where bseq = ? and replyno = ?";
			pstmt  = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getReplyText());
			pstmt.setInt(2, dto.getBseq());
			pstmt.setInt(3, dto.getReplyNo());
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
	public int rDelete(int bseq, int replyno) {
		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		DBConnection db = new DBConnection();
		
		try {
			conn = db.connect();
			String sql = "delete from reply where bseq = ? and replyno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bseq);
			pstmt.setInt(2, replyno);
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
	public int getTotalCount(int bseq) {
		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBConnection db = new DBConnection();
		
		try {
			conn = db.connect();
			String sql = "select count(bseq) from reply where bseq = " + bseq;
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
