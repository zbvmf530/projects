package yedam;

public class Board {
//	--게시글 // 게시글 번호, 작성자 id, 제목, 내용, 작성일자
//	--post_no, mem_id, title, content, write_date
	
	private String mem_id,title,content;

	public String getMem_id() {return mem_id;}

	public void setMem_id(String mem_id) {this.mem_id = mem_id;}

	public String getTitle() {return title;}

	public void setTitle(String title) {this.title = title;}

	public String getContent() {return content;}

	public void setContent(String content) {this.content = content;}
	
}
