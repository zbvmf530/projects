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
	List<Board> retrieveboardList() 
	{
		//post_no, mem_id, title, content, write_date
		getConn();
		List<Board> list = new ArrayList<>();
		String sql = "select * from board order by post_no";
		SimpleDateFormat fmt=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			psmt = conn.prepareStatement(sql);
			
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
}
