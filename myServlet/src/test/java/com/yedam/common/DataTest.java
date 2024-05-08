package com.yedam.common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.mapper.EmpMapper;
import com.yedam.vo.EmployeeVO;

public class DataTest {

	public static void main(String[] args) {
		SqlSessionFactory factory = DataSource.getInstance(); // sqlSessionFactory 반환
		SqlSession session = factory.openSession(true); // false :자동커밋 허용안함, true : 자동커밋
		//xml id와 interface 이름 일치시키면 자동으로 일대일매칭이 됌
		EmpMapper mapper = session.getMapper(EmpMapper.class);
		/*
		 * EmployeeVO evo = new EmployeeVO(); evo.setEmployeeId(998);
		 * evo.setFirstName("길동e"); evo.setLastName("홍"); evo.setEmail("hong@email.");
		 * evo.setJobId("IT_PROG"); int r = mapper.insertEmp(evo);
		 * System.out.println(r+"건 처리");
		 */
		//session.commit(); // 커밋
		//List<EmployeeVO> list = session.selectList("com.yedam.mapper.EmpMapper.selectEmp"); //namespace.id
		
		 int del = mapper.deleteEmp(109); 
		 System.out.println(del+"건 처리");
		 
		//xml id와 interface 이름 일치시키면 자동으로 일대일매칭이 됌
		List<EmployeeVO> list = mapper.selectEmp();
		System.out.println(list.size());
		for(EmployeeVO emp : list) {System.out.println(emp);}
		
		EmployeeVO evo = mapper.getEmployee(112);
		System.out.println(evo);
	}
}
