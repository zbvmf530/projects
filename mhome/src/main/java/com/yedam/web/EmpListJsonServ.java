package com.yedam.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.dao.EmpDAO;
import com.yedam.vo.EmpVO;

@WebServlet("/empJson.json")
public class EmpListJsonServ extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 사원목록을 json문자열로 출력
		//gson 라이브러리를 사용한 예제
		resp.setContentType("text/json;charset=utf-8");
		
		EmpDAO edao = new EmpDAO();
		Gson lib = new GsonBuilder().create();
		List<EmpVO> test = edao.selectList();
		String json = lib.toJson(test);
		System.out.println(lib);
		resp.getWriter().println(json);
	}
}
