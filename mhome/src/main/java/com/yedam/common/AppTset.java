package com.yedam.common;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.yedam.dao.EmpDAO;
import com.yedam.vo.EmpVO;

public class AppTset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EmpDAO eDao = new EmpDAO();
		/*
		 * List<EmpVO> eVO = eDao.selectList();
		 * 
		 * for(EmpVO emp : eVO) { System.out.println(emp); }
		 * 
		 * System.out.println(); EmpVO emp = new EmpVO();
		 * emp.setEmpName("VO입니다");emp.setEmpPhone("010-1111-2222");emp.setEmail(
		 * "lombok@gmail.com");emp.setHireDate("2022-02-20"); emp.setSalary(5800);
		 * 
		 * System.out.println(eDao.insertEmp(emp)); eVO = eDao.selectList(); for(EmpVO
		 * emp1 : eVO) { System.out.println(emp1); }
		 */
		
		Map<String, Integer> cntperDept = eDao.getCntperDept();
		Set<String> keySet = cntperDept.keySet();

		for (String key : keySet) {System.out.println(key + ":" + cntperDept.get(key));}
	}
}
