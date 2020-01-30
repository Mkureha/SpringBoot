package com.example.demo.sys.domain;

public class Paging {
	private int totalcount; // 총 게시물수
	private int pagenum; // 현재 페이지 번호
	private int contentnum=10; // 전 페이지 표시 개수
	private int startpage; // 현재 페이지 블록 시작페이지
	private int endpage; // 현재 페이지 블록 마지막 페이지
	private boolean prev; // 이전 페이지 가는 화살표
	private boolean next; // 다음 페이지 가는 화살표
	private int currentblock;// 현제 페이지 블록
	private int lastblock; // 마지막 페이지 블록
	
	public void prevnext(int pagenum) {
		if(pagenum>0 && pagenum<6) {
			setprev(false);
			setnext(true);
		}
		else if (getlastblock() == getcurrentblock()) {
			setprev(true);
			setnext(false);
		}
		else {
			setprev(true);
			setnext(false);
		}
	}

	public int calcpage(int totalcount, int contentnum) { // 전체 페이지수 계산
		int totalpage = totalcount / contentnum;
		if (totalcount % contentnum > 0) {
			totalpage++;
		}
		return totalpage;
	}

	public int gettotalcount() {
		return totalcount;
	}

	public void settotalcount(int totalcount) {
		this.totalcount = totalcount;
	}

	public int getpagenum() {
		return pagenum;
	}

	public void setpagenum(int pagenum) {
		this.pagenum = pagenum;
	}

	public int getcontentnum() {
		return contentnum;
	}

	public void setcontentnum(int contentnum) {
		this.contentnum = contentnum;
	}

	public int getstartpage() {
		return startpage;
	}

	public void setstartpage(int currentblock) {
		this.startpage = (currentblock * 5) - 4;
	}

	public int getendpage() {
		return endpage;
	}

	public void setendpage(int getlastblock, int getcurrentblock) {
		if (getlastblock == getcurrentblock) {
			this.endpage = calcpage(gettotalcount(), getcontentnum());
		} else {
			this.endpage = getstartpage() + 4;
		}
	}

	public boolean isprev() {
		return prev;
	}

	public void setprev(boolean prev) {
		this.prev = prev;
	}

	public boolean isnext() {
		return next;
	}

	public void setnext(boolean next) {
		this.next = next;
	}

	public int getcurrentblock() {
		return currentblock;
	}

	public void setcurrentblock(int pagenum) {
		this.currentblock = pagenum/5;
		if(pagenum%5>0) {
			this.currentblock++;
		}
	}

	public int getlastblock() {
		return lastblock;
	}

	public void setlastblock(int totalcount) {
		this.lastblock = totalcount / (5*this.contentnum);
		if(totalcount % (5*this.contentnum)>0) {
			this.lastblock++;
		}
	}
}
