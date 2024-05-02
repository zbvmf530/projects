package com.yedam.vo;

import com.yedam.common.DAO;

import lombok.Data;

// value object
// lombok: 이클립스에 설치, 라이브러리 필요

@Data
public class EmpVO extends DAO{ 
	private int empNo, salary;
	private String empName, empPhone, email;
	private String hireDate;

}

