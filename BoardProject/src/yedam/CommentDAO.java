package yedam;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
public class CommentDAO {

	// field
	Connection conn;
	ResultSet rs;
	PreparedStatement psmt;
	Statement stmt;

	
	// methods
	private void getConn() 
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@192.168.0.10:1521:xe";
			conn = DriverManager.getConnection(url,"jsb","1234");
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
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
			String titleHeader = "";
			String content = "";
			List<String> replies = new ArrayList<>();

			String sql = "select b.title, b.mem_id , b.content, b.write_date , c.mem_id, c.content, c.write_date"
					   + " from board b left join reply c on b.post_no = c.post_no "
					   + " where b.mem_id = ? "
					   + " and b.post_no = ? "
					   + " order by c.write_date "; 
			
			SimpleDateFormat fmt=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			try {
				psmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

				psmt.setString(1, id);
				psmt.setInt(2, brdNo);
				rs=psmt.executeQuery();
	
				ResultSetMetaData rsmd = rs.getMetaData();
				if(rsmd.getColumnCount()>0)
				{
					String copy="\n글내용\n";
					rs.next();
					titleHeader = String.format("\n|제목 : %s|작성자 : %s|작성일 : %s|\n----------------------------------------------------------\n", rs.getString(1),rs.getString(2),fmt.format(rs.getDate(4)).toString());
					content = rs.getString(3);
					if(content.length()/30<2)
					{
						copy += content.substring(0,content.length())+"\n";
					}
						
					for(int i = 0; i<content.length()/30;i++)
					{
						// 줄단위 서브스트링 추가
						// 30글자 단위로 한줄
						if(content.substring(i*30).length()>29) 
						{							
							copy += content.substring(i*30,(i*30)+29)+"\n";
						}
						else 
						{
							copy += content.substring(i*30, (i*30) + content.substring(i*30).length())+"\n";
						}
						
					}
					titleHeader += copy;
					titleHeader += "\n----------------------------------------------------------";
					rs.previous();
				}
				while(rs.next())
				{
//					글제목 : 공백 포함 30자
//					글내용 : 공백 포함 30자씩 한줄 최대 다섯줄 (= 150)
					
					
					
					if(rs.getString(6) != null) 
					{						
						replies.add(String.format("댓글 : %s|작성자 : %s|작성일 : %s", rs.getString(6),rs.getString(5),fmt.format(rs.getDate(7)).toString()));
						replies.add("----------------------------------------------------------");
					}
				}
//				for(String str : replies) 
//				{
//					System.out.println(str);
//				}
				replies.addFirst(titleHeader);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("조회실패!");
				e.printStackTrace();
			}
			return replies;
		}
	
}
