package com.yedam.vo;

import lombok.Data;

@Data
public class EmployeeVO {
	private int employeeId,salary;
	private String firstName, lastName,email,jobId,managerId,departmentId,phoneNumber;
	 //HIRE_DATE, , COMMISSION_PCT,
}
