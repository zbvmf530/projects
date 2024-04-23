package co.yedam;

import java.sql.*;

// 1.ojdbc 라이브러리
// 2. Connection 객체 접속
// 3. PreparedStatement 객체 쿼리 실행
// 4. 결과 => 화면출력, 기능수행

// JDBC(java database connectivity)
public class AppTest {
	public static void main(String[] args) 
	{
		try {
			// 1.ojdbc 라이브러리
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			// 2. Connection 객체 접속
			Connection conn = DriverManager.getConnection(url,"jsp","jsp");
			String sql1="select * from emp";
			String sql2="insert into emp (emp_no, emp_name, emp_phone, email, salary)"
					+ " values(emp_seq.nextval,?,?,?,?)";
			
			// 3. PreparedStatement 객체 쿼리 실행
			PreparedStatement psmt = conn.prepareStatement(sql1);
//			psmt.setString(1, "JP");
//			psmt.setString(2, "03-3334-3325");
//			psmt.setString(3, "JPK@email");
//			psmt.setInt(4, 2000);
			
//			int r = psmt.executeUpdate();
//			System.out.println("등록된 건수 : "+r);
			
//			psmt = conn.prepareStatement(sql1);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) 
			{
				System.out.println(rs.getInt("emp_no"));
				System.out.println(rs.getString("emp_name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("end of prog.");
	}
}
