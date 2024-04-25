package yedam;

public class Board {
//	--게시글 // 게시글 번호, 작성자 id, 제목, 내용, 작성일자
//	--post_no, mem_id, title, content, write_date

	// fields
	private String mem_id,title,content,write_date;
	private int post_no, count;
	
	
	//count(c.comment_no) 필드 추가
	
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
	public String getOwnedElement() {
		String coptitle = title;
		if(title.length()<10) {
			for(int i=0;i<10-title.length();i++)
			{coptitle+=" ";}
		}
		return String.format(" %3d | %-5s |%-10s\t |", post_no, coptitle, content.substring(0,7)+"...");
		}
	
	public int getCount() {return count;}
	
	public void setCount(int count) {this.count = count;}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		// 1 - | 제목 | 내용 | 작성자 | 댓글 수 | 작성일자 |
		String coptitle = title;
		if(title.length()<10) {
			for(int i=0;i<10-title.length();i++)
			{coptitle+=" ";}
		}
		else {coptitle = coptitle.substring(0,7)+"...";}
		return String.format("%3s | %-5s | %-10s | %-10s | %5.3s | %s |", String.valueOf(post_no), coptitle, content.substring(0,7)+"...", mem_id, String.valueOf(count), write_date);
	}

	
}
