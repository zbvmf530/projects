package yedam;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
public class CommentDAO {

	// field
	Connection conn;
	ResultSet rs;
	PreparedStatement psmt;
	// methods
	private void getConn() 
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url,"jsb","1234");
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
	
		// 전체 댓글 목록 출력 메소드
		List<Comment> retrieveCommentList() 
		{
			//comment_no, mem_id, post_no, content, write_date
			getConn();
			List<Comment> list = new ArrayList<>();
			String sql = "select * from reply order by post_no";
			SimpleDateFormat fmt=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			try {
				psmt = conn.prepareStatement(sql);
				
				rs=psmt.executeQuery();
				while(rs.next())
				{
					Comment reply = new Comment();
					reply.setComment_no(rs.getInt("comment_no"));
					reply.setPost_no(rs.getInt("post_no"));
					reply.setMem_id(rs.getString("mem_id"));
					reply.setContent(rs.getString("content"));
					reply.setWrite_date(fmt.format(rs.getDate("write_date")));
					list.add(reply);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
			
				e.printStackTrace();
			}
			return list;	
		}
		
		// 댓글 작성 메소드
		public boolean insertReply(String id, int post_no, String content) {
			getConn();
			String sql = "insert into reply (COMMENT_NO, MEM_ID, POST_NO, CONTENT)"
					+ " values(reply_seq.nextval,?,?,?)";
			try 
			{
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, id);
				psmt.setInt(2, post_no);
				psmt.setString(3, content);
				int r = psmt.executeUpdate();
				if(r>0) {return true;}
			}catch(Exception e) 
			{
				return false;
			}
			return false;
		}

		public List<String> retrieveContent(String id, int brdNo) {
			getConn();
			List<Board> list = new ArrayList<>();
			String content = "";
			List<String> replies = new ArrayList<>();
//			-- 가져올 내용
//			 -- 글제목, 글 작성자, 글내용, 글 작성일자, 
//			 -- 댓글 작성자, 댓글 내용, 댓글 작성일자
			
			
			String sql = "select b.title, b.mem_id , b.content, b.write_date , c.mem_id, c.content, c.write_date"
					   + " from board b left join reply c on b.post_no = c.post_no "
	                   + " where c.post_no is not null "
					   + " and b.mem_id = ? "
					   + " and b.post_no = ? "
					   + " order by c.write_date ";
			SimpleDateFormat fmt=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			try {
				psmt = conn.prepareStatement(sql);
				//System.out.println(id);
				//System.out.println(brdNo);
				psmt.setString(1, id);
				psmt.setInt(2, brdNo);
				//System.out.println("쿼리 실행전");
				rs=psmt.executeQuery();
				//System.out.println("쿼리 실행후");
				while(rs.next())
				{
					//System.out.println("1");
					//System.out.println(String.format("%s\t|%s|%s\n%s\n", rs.getString(1),rs.getString(2),fmt.format(rs.getDate(4)).toString(),rs.getString(3)));
					content = String.format("%s\t|%s|%s\n%s\n", rs.getString(1),rs.getString(2),fmt.format(rs.getDate(4)).toString(),rs.getString(3));
					replies.add(String.format("%s\t|%s|%s", rs.getString(5),rs.getString(6),fmt.format(rs.getDate(7)).toString()));
				}
//				for(String str : replies) 
//				{
//					System.out.println(str);
//				}
				replies.addFirst(content);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("조회실패!");
				e.printStackTrace();
			}
			return replies;
		}
	
}
