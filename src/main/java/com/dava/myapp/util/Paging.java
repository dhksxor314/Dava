package com.dava.myapp.util;

public class Paging {
	private int start=1;
	private int end;
	private int nowPage=1;
	private int nowBlock=0;
	private int recordPerPage=10;
	private int totalRecord;
	private int totalPage;
	private int totalBlock;
	private int pagePerBlock=5;
	
	Search search;
	
	
	public Paging(){}
	public Paging(int totalRecord, int nowBlock){
		this.totalRecord=totalRecord;
		totalPage=(int)Math.ceil((double)totalRecord/(double)recordPerPage);
		totalBlock=(int)Math.ceil((double)totalPage/(double)pagePerBlock)-1;
		setStartEnd(nowBlock);
	}
	
	
	public void setStartEnd(int nowBlock){
		start=start+(nowBlock*pagePerBlock);
		end=start+pagePerBlock-1;
		if(end>totalPage){
			end=totalPage;
		}
	}
	
	public void setNowPage(int nowPage){
		this.nowPage=nowPage;
	}
	
	public void setNowBlock(int nowBlock){
		this.nowBlock=nowBlock;
	}
	
	public void setRecordPerPage(int recordPerPage){
		this.recordPerPage=recordPerPage;
	}
	
	
	public int getStart(){
		return start;
	}
	
	public int getEnd(){
		return end;
	}
	
	public int getNowBlock(){
		return nowBlock;
	}
	
	public int getTotalBlock(){
		return totalBlock;
	}

	public int getRecordPerPage(){
		return recordPerPage;
	}
	
	public int getPagePerBlock(){
		return pagePerBlock;
	}
	
	public int getNowPage(){
		return nowPage;
	}
	
	public Search getSearch() {
		return search;
	}
	public void setSearch(Search search) {
		this.search = search;
	}
	
	
	
}
