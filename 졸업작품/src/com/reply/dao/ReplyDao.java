package com.reply.dao;

import java.util.ArrayList;

import com.reply.dto.ReplyDto;

public interface ReplyDao {
	
	public ArrayList<ReplyDto> rList(int bseq, int startNo);
	public int rInsert(ReplyDto dto);
	public int rUpdate(ReplyDto dto);
	public int rDelete(int bseq, int replyno);
	public int getTotalCount(int bseq);
}
