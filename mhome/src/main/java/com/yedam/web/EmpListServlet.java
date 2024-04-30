package com.yedam.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.EmpDAO;

// init(최초실행) -> service(실행) -> destroy(종료시)

//http://localhost:8080/mhome/WEB-INF/classes/com/yedam/web/EmpListServlet.java

@WebServlet("/empList.action")
public class EmpListServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 넘어온 파라미터의 인코딩 설정을 UTF-8로 설정
		req.setCharacterEncoding("utf-8");
    
    	// HTML이 UTF-8 형식이라는 것을 브라우저에게 전달
		resp.setContentType("text/html; charset=utf-8");
    
    	// 서블릿을 통해 생성되는 HTML 파일의 인코딩을 UTF-8로 설정
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter(); // 출력스트림
		
		EmpDAO edao = new EmpDAO();
		List <Map<String,Object>> list = edao.empList();
		for(Map<String,Object> map : list)
		{
			System.out.println("---------------------");
			System.out.println("사원번호 : "+map.get("사원번호")+", 사원명 : "+map.get("사원명")+", 연락처 : "+map.get("연락처")+", 이메일 : "+map.get("이메일"));
			out.print("<p>" + "사원번호: " + map.get("사원번호") + "</p>");
		}
		System.out.println("end of list.");
	}
	
}
