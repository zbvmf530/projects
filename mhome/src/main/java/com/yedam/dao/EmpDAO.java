package com.yedam.dao;

import java.sql.SQLException;
import java.util.*;
import com.yedam.common.DAO;


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
}
