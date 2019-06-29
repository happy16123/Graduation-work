package com.paging;

public class Paging {
	private int pageSize = 10;  //게시글 수
	private int firstPageNo;  //첫번재 페이지 번호
	private int prevPageNo;  //이전 페이지 번호
	private int startPageNo;  //시작 페이지 번호
	private int pageNo;  //페이지 번호
	private int endPageNo;  //끝 페이지 번호
	private int nextPageNo;  //다음 페이지 번호
	private int finalPageNo;  //마지막 페이지 번호
	private int totalCount;  // 게시글 전체 수
	private int startNo;
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getFirstPageNo() {
		return firstPageNo;
	}
	public void setFirstPageNo(int firstPageNo) {
		this.firstPageNo = firstPageNo;
	}
	public int getPrevPageNo() {
		return prevPageNo;
	}
	public void setPrevPageNo(int prevPageNo) {
		this.prevPageNo = prevPageNo;
	}
	public int getStartPageNo() {
		return startPageNo;
	}
	public void setStartPageNo(int startPageNo) {
		this.startPageNo = startPageNo;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getEndPageNo() {
		return endPageNo;
	}
	public void setEndPageNo(int endPageNo) {
		this.endPageNo = endPageNo;
	}
	public int getNextPageNo() {
		return nextPageNo;
	}
	public void setNextPageNo(int nextPageNo) {
		this.nextPageNo = nextPageNo;
	}
	public int getFinalPageNo() {
		return finalPageNo;
	}
	public void setFinalPageNo(int finalPageNo) {
		this.finalPageNo = finalPageNo;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public int getStartNo() {
		return startNo;
	}
	public void setStartNo(int startNo) {
		this.startNo = startNo;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		this.makePaging();
		
	}
	
	private void makePaging() {
		if(totalCount == 0)
			return;
		if(pageNo == 0)
			setPageNo(1);
		if(pageSize == 0)
			setPageSize(10);
		
		int finalPage = (totalCount + (pageSize - 1)) / pageSize;
		if(pageNo > finalPage)
			setPageNo(finalPage);
		
		if(pageNo < 0 || pageNo > finalPage)
			pageNo = 1;
		
		boolean isNowFirst = pageNo == 1 ? true : false;
		boolean isNowFinal = pageNo == finalPage ? true : false;
		
		int startPage = (pageNo - 1) / 5;
		int endPage = startPage + 5;
		setStartNo((pageNo-1)*10);
		
		if(endPage > finalPage)
			endPage = finalPage;
		
		setFirstPageNo(1);
		
		if(isNowFirst)
			setPrevPageNo(1);
		else
			setPrevPageNo(((pageNo - 1) < 1 ? 1 : (pageNo -1)));
		
		setStartPageNo(startPage);
		setEndPageNo(endPage);
		
		if(isNowFinal)
			setNextPageNo(finalPage);
		else
			setNextPageNo(((pageNo + 1) > finalPage ? finalPage : (pageNo + 1)));
		
		setFinalPageNo(finalPage);
	}
}

























;