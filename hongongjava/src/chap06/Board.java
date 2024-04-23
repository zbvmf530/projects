package chap06;

public class Board {

	String title;
	String content;
	String writer;
	String date;
	int hitcount;
	
	Board(String title, String content)
	{
		this(title,content,"로그인한 회원아이디","현재 컴퓨터 날짜",0);
	}
	Board(String title, String content, String writer)
	{
		this(title,content,writer,"현재 컴퓨터 날짜",0);
	}
	Board(String title, String content, String writer, String date)
	{
		this(title,content,writer,date,0);
		
	}
	Board(String title, String content, String writer, String date, int hitcount)
	{
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.date = date;
		this.hitcount = hitcount;
	}
	
	public void getBoardinfo() 
	{
		System.out.println("제목 : "+this.title+"\t콘텐츠 : "+this.content+"\t제작자: "+this.writer+"\t제작날짜 : "+this.date+"\thitcount : "+this.hitcount);
		System.out.println("===================================================================================================================");
	}
}
