package co.yedam;

import java.util.Date;

public class Employee {
	private String empName, phone, email, hireDate;
	private int empNo, salary;
	public void setEmpNo(int empNo) {this.empNo = empNo;}
	
	public String getEmpName() {return empName;}
	public int getEmpNo() {return empNo;}
	
	public String getPhone() {return phone;}
	
	public String getEmail() {return email;}
	
	public void setEmpName(String empName) {this.empName = empName;}
	
	public void setPhone(String phone) {this.phone = phone;}
	
	public void setEmail(String email) {this.email = email;}
	
	public void setHireDate(String hireDate) {this.hireDate = hireDate;}
	
	public void setSalary(int salary) {this.salary = salary;}
	
	public String getHireDate() {return hireDate;}
	
	public int getSalary() {return salary;}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%3d\t%-10s\t%-13s\t%d\n",this.getEmpNo(),this.getEmpName(),this.getPhone(),this.getSalary());
	}
}
