/**
 * 
 */
/**
 * @author HS
 *
 */
package com.board.dto;

public class BoardDto{
	private int bseq;
	private String title;
	private String content;
	private String regId;
	private String regDate ;
	private int viewCnt;
	
	public int getBseq() {
		return bseq;
	}
	public void setBseq(int bseq) {
		this.bseq = bseq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegid() {
		return regId;
	}
	public void setRegid(String regid) {
		this.regId = regid;
	}
	public String getRegdate() {
		return regDate;
	}
	public void setRegdate(String regdate) {
		this.regDate = regdate;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
}