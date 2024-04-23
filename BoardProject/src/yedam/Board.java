package yedam;

public class Board {
//	--게시글 // 게시글 번호, 작성자 id, 제목, 내용, 작성일자
//	--post_no, mem_id, title, content, write_date

	// fields
	private String mem_id,title,content,write_date;
	private int post_no;
	
	
	
	
	// methods
	public String getWrite_date() {return write_date;}

	public void setWrite_date(String write_date) {this.write_date = write_date;}

	public int getPost_no() {return post_no;}

	public void setPost_no(int post_no) {this.post_no = post_no;}

	public String getMem_id() {return mem_id;}

	public void setMem_id(String mem_id) {this.mem_id = mem_id;}

	public String getTitle() {return title;}

	public void setTitle(String title) {this.title = title;}

	public String getContent() {return content;}

	public void setContent(String content) {this.content = content;}
	
	//1 - | 제목 | 내용 |
	public String getOwnedElement() {return String.format("%3d\t|%s\t|%s\t|", post_no,title,content);}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		// 1 - | 제목 | 내용 | 작성자 | 댓글 수 | 작성일자 |
		return String.format("%3d\t|%s\t|%s\t|%s\t|%s\t|", post_no, mem_id, title, content, write_date);
	}
	
}
