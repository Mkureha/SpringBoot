package com.example.demo.sys.domain;

public class Paging {
	private int totalcount; // 총 게시물수
	private int pagenum; // 현재 페이지 번호
	private int contentnum=10; // 전 페이지 표시 개수
	private int startpage=1; // 현재 페이지 블록 시작페이지
	private int endpage=5; // 현재 페이지 블록 마지막 페이지
	private boolean prev=false; // 이전 페이지 가는 화살표
	private boolean next; // 다음 페이지 가는 화살표
	private int currentblock;// 현제 페이지 블록
	private int lastblock; // 마지막 페이지 블록
	
	public void prevnext(int pagenum) {
		if(pagenum>0 && pagenum<6) {
			setPrev(false);
			setNext(true);
		}
		else if (getLastblock() == getCurrentblock()) {
			setPrev(true);
			setNext(false);
		}
		else {
			setPrev(true);
			setNext(false);
		}
	}

	public int calcpage(int totalcount, int contentnum) { // 전체 페이지수 계산
		int totalpage = totalcount / contentnum;
		if (totalcount % contentnum > 0) {
			totalpage++;
		}
		return totalpage;
	}

	public int getTotalcount() {
		return totalcount;
	}

	public void setTotalcount(int totalcount) {
		this.totalcount = totalcount;
	}

	public int getPagenum() {
		return pagenum;
	}

	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}

	public int getContentnum() {
		return contentnum;
	}

	public void setContentnum(int contentnum) {
		this.contentnum = contentnum;
	}

	public int getStartpage() {
		return startpage;
	}

	public void setStartpage(int currentblock) {
		this.startpage = (currentblock * 5) - 4;
	}

	public int getEndpage() {
		return endpage;
	}

	public void setEndpage(int getlastblock, int getcurrentblock) {
		if (getlastblock == getcurrentblock) {
			this.endpage = calcpage(getTotalcount(), getContentnum());
		} else {
			this.endpage = getStartpage() + 4;
		}
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getCurrentblock() {
		return currentblock;
	}

	public void setCurrentblock(int pagenum) {
		this.currentblock = pagenum/5;
		if(pagenum%5>0) {
			this.currentblock++;
		}
	}

	public int getLastblock() {
		return lastblock;
	}

	public void setLastblock(int totalcount) {
		this.lastblock = totalcount / (5*this.contentnum);
		if(totalcount % (5*this.contentnum)>0) {
			this.lastblock++;
		}
	}
}
