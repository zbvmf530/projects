package yedam;

public class Comment {
	
	int comment_no, post_no;
	String mem_id, content, write_date;
	public int getComment_no() {return comment_no;}
	
	public void setComment_no(int comment_no) {this.comment_no = comment_no;}
	
	public int getPost_no() {return post_no;}
	
	public void setPost_no(int post_no) {this.post_no = post_no;}
	
	public String getMem_id() {return mem_id;}
	
	public void setMem_id(String mem_id) {this.mem_id = mem_id;}
	
	public String getContent() {return content;}
	
	public void setContent(String content) {this.content = content;}
	
	public String getWrite_date() {return write_date;}
	
	public void setWrite_date(String write_date) {this.write_date = write_date;}
	
}
