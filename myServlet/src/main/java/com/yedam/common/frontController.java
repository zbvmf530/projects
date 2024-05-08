package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.web.*;

// 한파일로 프로젝트 내부 서블릿 관리
public class frontController extends HttpServlet{
	
	
	Map<String, Control> map;
	
	// 생성자
	public frontController() {
		map = new HashMap<>();
	}
	// init
	@Override
	public void init(ServletConfig config) throws ServletException {
		// url패턴과 실행할 Control 구현클래스 정의.
		map.put("/abc.do", new ABCControl());
		map.put("/info.do", new InfoControl());
		map.put("/addEmp.do", new AddEmpControl());
		map.put("/registerEmp.do", new RegisterControl());
		
	}
	
	// service
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8"); //요청정보의 한글처리
		
		String uri = req.getRequestURI();
		String context = req.getContextPath();
		System.out.println("uri : "+uri+", context : "+context);
		String path = uri.substring(context.length());
		System.out.println("path : "+path);
		
		Control control = map.get(path);
		control.exec(req,resp);
	}
	
	// destroy
	@Override
	public void destroy() {
		System.out.println("destroy 호출됨. :: 인스턴스가 메모리에 사라질 때 호출.");
	}
}
