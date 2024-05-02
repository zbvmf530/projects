package com.yedam.dao;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import com.yedam.common.DAO;
import com.yedam.vo.EmpVO;


public class EmpDAO extends DAO{

	public List<Map<String,Object>> empList(){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		conn();
		try {
			psmt = conn.prepareStatement("select * from emp");
			rs=psmt.executeQuery();
			while(rs.next()) 
			{
				Map<String,Object> map = new HashMap();
				map.put("사원번호", rs.getString("emp_no"));
				map.put("사원명", rs.getString("EMP_NAME"));
				map.put("연락처", rs.getString("EMP_PHONE"));
				map.put("이메일", rs.getString("EMAIL"));
				list.add(map);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {disCon();}
		return list;
	}
	
	public List<EmpVO> selectList(){
		List<EmpVO> list = new ArrayList<>();
		conn();
		try {
			psmt = conn.prepareStatement("select * from emp");
			rs=psmt.executeQuery();
			while(rs.next()) 
			{
				SimpleDateFormat fmt=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				
				EmpVO emp = new EmpVO();
				emp.setEmpNo(rs.getInt("EMP_NO"));
				emp.setEmpName(rs.getString("EMP_NAME"));
				emp.setEmpPhone(rs.getString("EMP_PHONE"));
				emp.setEmail(rs.getString("EMAIL"));
				emp.setHireDate(fmt.format(rs.getDate("HIRE_DATE")));
				emp.setSalary(rs.getInt("SALARY"));
				list.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {disCon();}
		return list;
	}
	
	public EmpVO selectEmp(int empNo) {
		conn();
		try {
			psmt = conn.prepareStatement("select * from emp where emp_no = ?");
			psmt.setInt(1, empNo);
			rs = psmt.executeQuery();

			SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			if (rs.next()) {
				EmpVO emp = new EmpVO();
				emp.setEmpNo(rs.getInt("EMP_NO"));
				emp.setEmpName(rs.getString("EMP_NAME"));
				emp.setEmpPhone(rs.getString("EMP_PHONE"));
				emp.setEmail(rs.getString("EMAIL"));
				emp.setHireDate(fmt.format(rs.getDate("HIRE_DATE")));
				emp.setSalary(rs.getInt("SALARY"));
				return emp;
			}
			else {return null;}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {disCon();}
		return null;
	}
	// 등록 boolean insertEmp(EmpVO evo);
	
	
	public boolean insertEmp(EmpVO evo){
		List<EmpVO> list = new ArrayList<>();
		conn();
		String sql = "insert into EMP(EMP_NO, EMP_NAME, EMP_PHONE, EMAIL, HIRE_DATE, SALARY) values(?,?,?,?,?,?)";
		String seqSql = "select emp_seq.nextval from dual";
			
		int seq = 0;
		try 
		{
			psmt= conn.prepareStatement(seqSql);
			rs = psmt.executeQuery();
			rs.next();
			seq = rs.getInt(1);
			evo.setEmpNo(seq);
			System.out.println(seq);
			
			psmt = conn.prepareStatement(sql);			
			psmt.setInt(1, evo.getEmpNo());
			psmt.setString(2, evo.getEmpName());
			psmt.setString(3, evo.getEmpPhone());
			psmt.setString(4, evo.getEmail());
			psmt.setString(5, evo.getHireDate());
			psmt.setInt(6, evo.getSalary());
			int r = psmt.executeUpdate();
			if(r>0) {return true;}
		}catch(Exception e) 
		{
			System.out.println(e);
			return false;
		}
		finally {disCon();}
		return false;
	}
	
	// 수정 boolean updateEmp(int EmpNo); // 이메일, 급여 변경
	public boolean updateEmp(EmpVO evo) {
		conn();
		String sql = "update emp";//
		sql += "      set email=?";//
		sql += "      ,salary=?";//
		sql += "      where emp_no=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, evo.getEmail());
			psmt.setInt(2, evo.getSalary());
			psmt.setInt(3, evo.getEmpNo());
			int r = psmt.executeUpdate();
			if (r > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disCon();
		}
		return false;
	}
	
	// 삭제 boolean deleteEmp(int EmpNo);	
	public boolean deleteEmp(int empNo) {
		conn();
		String sql = "delete from emp";//
		sql += "      where emp_no=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, empNo);
			int r = psmt.executeUpdate();
			if (r > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disCon();
		}
		return false;
	}
}
