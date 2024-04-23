package co.yedam;

import java.sql.*;
import java.util.*;

public class MemberDAO {
	private String Query;
	Connection conn;
	ResultSet rs;
	PreparedStatement psmt;
	
	// DB 접속 후 Connection
	private void getConn() 
	{
		try {
			// 1.ojdbc 라이브러리
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url,"jsp","jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
	}
	
	// 사원 목록 출력 메소드
	List<Member> memberList() 
	{
		getConn();
		List<Member> list = new ArrayList<>();
		String sql = "select * from member order by no";
		try {
			psmt = conn.prepareStatement(sql);
			rs=psmt.executeQuery();
			while(rs.next())
			{
				Member mem = new Member();
				mem.setNo(rs.getInt("no"));
				mem.setName(rs.getString("name"));
				mem.setPhone(rs.getString("phone"));
				mem.setBirth(rs.getDate("birth").toString());
				mem.setGender(rs.getString("gender"));
				list.add(mem);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	// 회원 등록 메소드
	boolean insertMember(Member member) 
	{
		getConn();
		String sql = "insert into member (no, name, phone, birth, gender)"
				+ " values(mem_seq.nextval,?,?,?,?)";
		try 
		{
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getName());
			psmt.setString(2, member.getPhone());
			psmt.setString(3, member.getBirth());
			psmt.setString(4, member.getGender());
			
			int r = psmt.executeUpdate();
			if(r>0) {return true;}
		}catch(Exception e) 
		{
			return false;
		}
		return false;
	}
	// 회원 정보 수정 메소드
	boolean updateMember(Member mem) 
	{
		getConn();
		String sql = "update member";
		sql += " set phone = ?";
		sql += " where no = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mem.getPhone());
			psmt.setInt(2, mem.getNo());
			int r = psmt.executeUpdate();
			if(r>0) {return true;}
			else {return false;}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	// 회원 삭제 메소드
	boolean deleteMember(int no) 
	{
		getConn();
		String sql = "delete from member";
			   sql += " where no = ?";
		try 
		{
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, no);
			int r = psmt.executeUpdate();
			if(r>0) {return true;}
			else {return false;}
		}catch(Exception e) 
		{
			e.printStackTrace();
		}	
		return false;
	}
	//String showDetail() {}
}
