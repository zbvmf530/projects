package chap13;

public class Board {
	String subject;
	String content;
	String writer;
	
	
	public Board() 
	{
	}
	public Board(String subject, String content) 
	{
		this(subject,content,"");
	}
	public Board(String subject, String content, String writer) 
	{
		this.subject = subject;
		this.content = content;
		this.writer = writer;
	}
	
	public String getTitle() {return subject;}
	public String getContent() {return content;}
}
