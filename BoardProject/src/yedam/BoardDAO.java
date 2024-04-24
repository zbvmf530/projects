package yedam;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class BoardDAO {

	// 필드
	private ArrayList<Board> boardList = new ArrayList<>();
	// 메소드

	public ArrayList<Board> getBoardList() {return boardList;}

	public void setBoardList(ArrayList<Board> boardList) {this.boardList = boardList;}

	Connection conn;
	ResultSet rs;
	PreparedStatement psmt;
	
	// DB 접속 후 Connection
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
	
	// 게시판 목록 출력 메소드
	List<Board> retrieveboardList(String inputID) 
	{
		//post_no, mem_id, title, content, write_date
		getConn();
		List<Board> list = new ArrayList<>();
		
		String sql;
		if(inputID.equals("")) 
		{
			sql = "select b.post_no, b.mem_id, b.title, b.content, COUNT(c.comment_no) as 댓글수, b.write_date "
					   + " from board b left join reply c on b.post_no = c.post_no "
	                   + " group by b.post_no, b.mem_id, b.title, b.content, b.write_date "
	                   + " order by post_no ";
		}
		else 
		{
			sql = "select b.post_no, b.mem_id, b.title, b.content, COUNT(c.comment_no) as 댓글수, b.write_date "
					   + " from board b left join reply c on b.post_no = c.post_no "
					   + " where b.mem_id = ?"
	                   + " group by b.post_no, b.mem_id, b.title, b.content, b.write_date "
	                   + " order by post_no ";
		}
		SimpleDateFormat fmt=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			psmt = conn.prepareStatement(sql);
			if(!inputID.equals("")){psmt.setString(1,inputID);}
			rs=psmt.executeQuery();
			while(rs.next())
			{
				Board board = new Board();
				board.setPost_no(rs.getInt(1));
				board.setMem_id(rs.getString(2));
				board.setTitle(rs.getString(3));
				board.setContent(rs.getString(4));
				board.setCount(rs.getInt(5));
				board.setWrite_date(fmt.format(rs.getDate(6)));
				list.add(board);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		
			e.printStackTrace();
		}
		return list;
		
	}
	
	// 본인글 조회 메소드
	List<Board> getOwnedboardList(String id)
	{
		getConn();
		List<Board> list = new ArrayList<>();
		String sql = "select * from board where mem_id = ? order by post_no";
		SimpleDateFormat fmt=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,id);
			rs=psmt.executeQuery();
			while(rs.next())
			{
				Board board = new Board();
				board.setPost_no(rs.getInt("post_no"));
				board.setMem_id(rs.getString("mem_id"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWrite_date(fmt.format(rs.getDate("write_date")));
				list.add(board);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	// 게시글 작성 메소드
	public boolean insertBoard(String id, String title, String content) {
		getConn();
		String sql = "insert into board (post_no, mem_id, title, content)"
				+ " values(board_seq.nextval,?,?,?)";
		try 
		{
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, title);
			psmt.setString(3, content);
			int r = psmt.executeUpdate();
			if(r>0) {return true;}
		}catch(Exception e) 
		{
			return false;
		}
		return false;
	}
	// 글 수정 메소드
	public boolean updateBoard(Board brd,String id, int command) {
		getConn();
		String sql ="";
		
		int r = 0;
		switch(command) 
		{
		// 제목만 수정 쿼리
		case 1:
			sql = "update board set title = ? "
					+ " where mem_id = ? "
					+ " and post_no = ?";
			try 
			{
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, brd.getTitle());
				psmt.setString(2, id);
				psmt.setInt(3, brd.getPost_no());
				System.out.println("쿼리 실행전");
				r = psmt.executeUpdate();
				System.out.println("쿼리 실행후");
				
			}catch(Exception e) 
			{
				System.out.println("게시글 제목 수정 오류!");
			}
			break;
		// 내용만 수정 쿼리
		case 2:
			sql = "update board set content = ? "
					+ " where mem_id = ? "
					+ " and post_no = ?"; 
			try 
			{
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, brd.getContent());
				psmt.setString(2, id);
				psmt.setInt(3, brd.getPost_no());
				System.out.println("쿼리 실행전");
				r = psmt.executeUpdate();
				System.out.println("쿼리 실행후");
				
			}catch(Exception e) 
			{
				System.out.println("게시글 수정 오류!");
			}
			break;
		// 제목,내용 수정쿼리
		case 3:
//			update board 
			 
//			where mem_id='ab12' and post_no=1;
			sql = "update board "
				+ " set title = ?,"
				+ " content = ?"
				+ " where mem_id = ? "
				+ " and post_no = ? "; 
			try 
			{
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, brd.getTitle());
				psmt.setString(2, brd.getContent());
				psmt.setString(3, id);
				psmt.setInt(4, brd.getPost_no());
				System.out.println("쿼리 실행전");
				r = psmt.executeUpdate();
				System.out.println("쿼리 실행후");
				
			}catch(Exception e) 
			{
				System.out.println("게시글 수정 오류!");
			}
			break;
		default:
			break;
		}
		
		
		if(r>0) {
			
			return true;
			}
		else {return false;}
		
	}// end of updateBoard
}
