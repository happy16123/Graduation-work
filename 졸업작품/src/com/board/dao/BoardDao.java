/**
 * 
 */
/**
 * @author HS
 *
 */
package com.board.dao;

import java.util.ArrayList;

import com.board.dto.BoardDto;
import com.paging.Paging;

public interface BoardDao{
	public ArrayList<BoardDto> bList(int startNo);
	public BoardDto bSelect(int bseq);
	public int bDelete(int bseq);
	public int bUpdate(BoardDto dto);
	public int bInsert(BoardDto dto);
	public int getTotalCount();
}