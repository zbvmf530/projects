package co.yedam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO {
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
	List<Employee> empList() 
	{
		getConn();
		List<Employee> list = new ArrayList<>();
		String sql = "select * from emp order by emp_no";
		try {
			psmt = conn.prepareStatement(sql);
			rs=psmt.executeQuery();
			while(rs.next())
			{
				Employee emp = new Employee();
				emp.setEmpNo(rs.getInt("emp_no"));
				emp.setEmpName(rs.getString("emp_name"));
				emp.setPhone(rs.getString("emp_phone"));
				emp.setSalary(rs.getInt("salary"));
				list.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	// 사원 등록 메소드
	boolean insertEmployee(Employee emp) 
	{
		getConn();
		String sql = "insert into emp (emp_no, emp_name, emp_phone, email, salary,hire_date)"
				+ " values(emp_seq.nextval,?,?,?,?,?)";
		try 
		{
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, emp.getEmpName());
			psmt.setString(2, emp.getPhone());
			psmt.setString(3, emp.getEmail());
			psmt.setInt(4, emp.getSalary());
			
			psmt.setString(5, emp.getHireDate());
			int r = psmt.executeUpdate();
			if(r>0) {return true;}
		}catch(Exception e) 
		{
			return false;
		}
		return false;
	}
	// 사원 정보 수정 메소드
	boolean updateEmp(Employee emp) 
	{
		getConn();
		ResultSet defaultEmail;
		String sql;
		
		
		try 
		{
			if(emp.getEmail().equals("")) 
			{
				sql = "update emp";
				sql += " set salary = ?";
				sql += " where emp_no = ?";
				psmt = conn.prepareStatement(sql);
				psmt.setInt(1, emp.getSalary());
				psmt.setInt(2, emp.getEmpNo());
			}
			else {
				sql = "update emp";
				sql += " set salary = ?";
				sql += ",email = ?";
				sql += " where emp_no = ?";
				psmt = conn.prepareStatement(sql);
				psmt.setInt(1, emp.getSalary());
				psmt.setString(2, emp.getEmail());
				psmt.setInt(3, emp.getEmpNo());
			}
			
			int r = psmt.executeUpdate();
			if(r>0) {return true;}
			else {return false;}
		}catch(Exception e) 
		{
			e.printStackTrace();
		}
		return false;
	}
	// 사원 삭제 메소드
	boolean deleteEmp(Employee emp) 
	{
		getConn();
		String sql = "delete from emp";
			   sql += " where emp_no = ?";
		try 
		{
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, emp.getEmpNo());
			int r = psmt.executeUpdate();
			if(r>0) {return true;}
			else {return false;}
		}catch(Exception e) 
		{
			e.printStackTrace();
		}	
		return false;
	}
}
