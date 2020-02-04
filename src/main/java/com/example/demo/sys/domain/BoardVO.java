package com.example.demo.sys.domain;

public class BoardVO {

	private int tosyo_number;
	private String tosyo_num;
	private String tosyo_name;
	private String tosyo_daibunrui;
	private String tosyo_cyubunrui;
	private int tosyo_count;

	public int gettosyo_number() {
		return tosyo_number;
	}

	public void settosyo_number(int tosyo_number) {
		this.tosyo_number = tosyo_number;
	}

	public String gettosyo_num() {
		return tosyo_num;
	}

	public void settosyo_num(String tosyo_num) {
		this.tosyo_num = tosyo_num;
	}

	public String gettosyo_name() {
		return tosyo_name;
	}

	public void settosyo_name(String tosyo_name) {
		this.tosyo_name = tosyo_name;
	}

	public String gettosyo_daibunrui() {
		return tosyo_daibunrui;
	}

	public void settosyo_daibunrui(String tosyo_daibunrui) {
		this.tosyo_daibunrui = tosyo_daibunrui;
	}

	public String gettosyo_cyubunrui() {
		return tosyo_cyubunrui;
	}

	public void settosyo_cyubunrui(String tosyo_cyubunrui) {
		this.tosyo_cyubunrui = tosyo_cyubunrui;
	}
	public int gettosyo_count() {
		return tosyo_count;
	}

	public void settosyo_count(int tosyo_count) {
		this.tosyo_count = tosyo_count;
	}
	
	//Paging ADD
	private int totalcount;//전체 게시물 개수
    private int countlist;
    private int pagenum;//첫페이지를 표시하기 위함, 페이지 번호를 나타낸다
    private int contentnum;//한페이지에 몇개 보일지
    private int startpage=1;//beginpage 디폴트 1
    private int endpage=5;//endpage 디폴트 5
    private boolean prev=false;//이전 페이지 화살표
    private boolean next;//다음 페이지 화살표
    private int currentblock=1;
    private int lastblock;

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
 
    public int getstartpage() {
        return startpage;
    }
 
    public void setstartpage(int currentblock) {
        this.startpage = (currentblock*5)-4;
        //한 페이지에 5개씩 보여지므로
        //현재 페이지 블록의 번호 * 블록당 페이지의 개수(5) - 4를 하면 시작 페이지 번호를 정할 수 있다
    }
 
    public int getendpage() {
        return endpage;
    }
 
    public void setendpage(int getlastblock,int getcurrentblock) {
        if (getlastblock==getcurrentblock) {
            this.endpage = calcpage(gettotalcount(), getcontentnum());
        }
        else {
            this.endpage = getstartpage()+4;
        }
        //기본 시작페이지 +4
        //조건 , 마지막 페이지 블록이면 마지막 페이지 번호
    }
    
 
    public int getcurrentblock() {
        return currentblock;
    }
 
    public void setcurrentblock(int pagenum) {//현재 페이지 블록의 번호가 몇번인지 지정해주는 함수
//        페이지번호 / 페이지 그룹 안의 페이지 개수(5)
//        ->나머지 있으면 더하기 1한다. -> 이 결과를 현재 블록 번호라고 부른다. cblock
 
        this.currentblock = pagenum/5;
        if (pagenum%5>0) {
            this.currentblock++;
        }
    }
 
    public int getlastblock() {
        return lastblock;
    }
 
    public void setlastblock(int totalcount) {//마지막 페이지 블록의 번호가 뭔지 지정해주는 함수
        //전체 글 개수를 사용해서 지정한다
        this.lastblock = totalcount / (5*this.contentnum);
        if (totalcount%(5*this.contentnum)>0) {
            this.lastblock++;
        }
//        전체 글 개수(128) / 페이지 그룹 안의 페이지 개수(5) * 한페이지당 글 개수(10)
//        ->나머지 있으면 더하기 1한다. -> 이 결과를 마지막 블록 번호라고 부른다. last block
    }
 
    public void prevnext(int pagenum) {
        
        if (pagenum>0 && pagenum<6) {
            setprev(false);
            setnext(true);
        }
        else if(getlastblock()==getcurrentblock()) {//5개씩 페이지의 그룹번호를 지정한다.
            //그룹 번호가 3이라는 것은 해당 페이지 그룹이 마지막이라는 것이기에 이전 화살표만 활성화한다 
            //이 두개가 같다면 마지막 블록이므로 이전만 있고 이후가 없다.

            setprev(true);
            setnext(false);        
        }
        else {
            setprev(true);
            setnext(true);
        }
    }
    public int calcpage(int totalcount,int contentnum) {//전체 몇페이지까지 있을지 함수로 계산한다
        int totalpage = totalcount/contentnum;//전체 게시물 수를 한 페이지당 몇개 보이는지로 나눈다
        if (totalcount % contentnum>0) {//그리고 나머지가 있다면 1을 더해서 한 페이지 증가 시킨다
            totalpage++;
        }
        if (totalpage<this.pagenum) {
            this.pagenum=totalpage;
        }
        return totalpage;//페이지 개수를 리턴한다
    }
    
    public int gettotalcount() {
        return totalcount;
    }
 
    public void settotalcount(int totalcount) {
        this.totalcount = totalcount;
    }
    public int getcountlist() {
        return countlist;
    }
 
    public void setcountlist(int countlist) {
        this.countlist = countlist;
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
    
    //Search ADD
    private String searchtype;
	private String keyword;	
			
	public String getsearchtype() {
		return searchtype;
	}
	
	public void setsearchtype(String searchtype) {
		this.searchtype = searchtype;
	}
	
	public String getkeyword() {
		return keyword;
	}

	public void setkeyword(String keyword) {
		this.keyword = keyword;
	}
}