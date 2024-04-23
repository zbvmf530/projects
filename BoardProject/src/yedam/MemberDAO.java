package yedam;

import java.sql.*;
import java.util.*;


public class MemberDAO {

	// fields
	ArrayList<Member> memberList = new ArrayList<>();
	private String id, pw;
	private boolean login;

	// methods
	public String getId() {return id;}

	public String getPw() {return pw;}

	public boolean isLogin() {return login;}

	public void setId(String id) {this.id = id;}

	public void setPw(String pw) {this.pw = pw;}

	public void setLogin(boolean login) {this.login = login;}
	
	private String Query;
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
	
	// 회원 목록 출력 메소드
	List<Member> memList() 
	{
		getConn();
		List<Member> list = new ArrayList<>();
		String sql = "select * from member";
		try {
			psmt = conn.prepareStatement(sql);
			rs=psmt.executeQuery();
			while(rs.next())
			{
				Member mem = new Member();
				mem.setId(rs.getString("mem_id"));
				mem.setPw(rs.getString("mem_pw"));
				mem.setName(rs.getString("name"));
				mem.setEmail(rs.getString("email"));
				list.add(mem);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	public boolean loginCheck(String id, String pw) {
		// TODO Auto-generated method stub
		List<Member> list = this.memList();
		for(Member ele : list) 
		{
			if(id.equals(ele.getId()) && pw.equals(ele.getPw())) 
			{
				this.setId(id);
				this.setPw(pw);
				return true;
			}
		}
		return false;
	}
	// 회원 가입 메소드
	boolean insertMember(Member mem) 
	{
		getConn();
		String sql = "insert into member (mem_id, mem_pw, name, email)"
				+ " values(?,?,?,?)";
		try 
		{
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mem.getId());
			psmt.setString(2, mem.getPw());
			psmt.setString(3, mem.getName());
			psmt.setString(4, mem.getEmail());
			int r = psmt.executeUpdate();
			if(r>0) {return true;}
		}catch(Exception e) 
		{
			return false;
		}
		return false;
	}
	String findId(String name,String email) 
	{
		getConn();
		String sql =   "select mem_id from member ";
			   sql +=  " where name = ? ";
			   sql +=  " and email = ? ";
		try 
		{
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			psmt.setString(2, email);
			rs = psmt.executeQuery();
			if(rs.next()) {return rs.getString("mem_id");}
			else return "";
		}catch(Exception e) 
		{
			return "";
		}
	}
	String findPw(String id) 
	{
		getConn();
		String sql =   "select mem_pw from member ";
			   sql +=  " where mem_id = ? ";
		try 
		{
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) {return rs.getString("mem_pw");}
			else return "";
		}catch(Exception e) 
		{
			return "";
		}
	}
//	// 사원 정보 수정 메소드
//	boolean updateEmp(Employee emp) 
//	{
//		getConn();
//		ResultSet defaultEmail;
//		String sql;
//		
//		
//		try 
//		{
//			if(emp.getEmail().equals("")) 
//			{
//				sql = "update emp";
//				sql += " set salary = ?";
//				sql += " where emp_no = ?";
//				psmt = conn.prepareStatement(sql);
//				psmt.setInt(1, emp.getSalary());
//				psmt.setInt(2, emp.getEmpNo());
//			}
//			else {
//				sql = "update emp";
//				sql += " set salary = ?";
//				sql += ",email = ?";
//				sql += " where emp_no = ?";
//				psmt = conn.prepareStatement(sql);
//				psmt.setInt(1, emp.getSalary());
//				psmt.setString(2, emp.getEmail());
//				psmt.setInt(3, emp.getEmpNo());
//			}
//			
//			int r = psmt.executeUpdate();
//			if(r>0) {return true;}
//			else {return false;}
//		}catch(Exception e) 
//		{
//			e.printStackTrace();
//		}
//		return false;
//	}
//	// 사원 삭제 메소드
//	boolean deleteEmp(Employee emp) 
//	{
//		getConn();
//		String sql = "delete from emp";
//			   sql += " where emp_no = ?";
//		try 
//		{
//			psmt = conn.prepareStatement(sql);
//			psmt.setInt(1, emp.getEmpNo());
//			int r = psmt.executeUpdate();
//			if(r>0) {return true;}
//			else {return false;}
//		}catch(Exception e) 
//		{
//			e.printStackTrace();
//		}	
//		return false;
//	}

	
}
