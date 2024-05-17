package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;

public class DelCart implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String cno= req.getParameter("no");
		
		ReplyService svc = new ReplyServiceImpl();
		if(svc.removeCart(Integer.parseInt(cno))) {
			// {"retCode":"OK"}
			resp.getWriter().print("{\"retCode\":\"OK\"}");
		}else {
			// {"retCode":"NG"}
			resp.getWriter().print("{\"retCode\":\"NG\"}");
		}
	}

}
