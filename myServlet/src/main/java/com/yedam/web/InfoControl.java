package com.yedam.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.Control;
import com.yedam.common.DataSource;
import com.yedam.mapper.EmpMapper;
import com.yedam.vo.EmployeeVO;

public class InfoControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("info 호출됨.");
		// 서블릿의 정보 -> jsp 페이지 출력
		
		// HttpServletRequest : 사용자 요청정보
		// 전달해야할 값을 req라는 이름으로 설정해서 저장
		req.setAttribute("req", req);
		req.setAttribute("name", "홍길동");
		
		SqlSession session = DataSource.getInstance().openSession(true); // factory
		EmpMapper mapper = session.getMapper(EmpMapper.class);
		List<EmployeeVO>list = mapper.selectEmp();
		
		req.setAttribute("emplist", list);
		//System.out.println("address:"+req);
		// 지정할 페이지 설정
		RequestDispatcher rd = req.getRequestDispatcher("info.jsp"); 
		// info.do -> info.jsp 요청 재지정 (RequestDispatcher.forward)
		rd.forward(req, resp);
	}
}
