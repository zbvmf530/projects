package com.yedam.vo;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;
import com.yedam.dao.EmpDAO;

import lombok.Data;

// value object
// lombok: 이클립스에 설치, 라이브러리 필요
@Data
public class EmpVO extends DAO{ 
	private int empNo, salary;
	private String empName, empPhone, email;
	private String hireDate;
//	private List<EmpVO> eVO;
//	public Connection conn;
//	public PreparedStatement psmt;
//	public ResultSet rs;
// 목록 List<empVO> selectList();

}

