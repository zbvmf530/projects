package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.common.HttpUtils;

public class LoginForm implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

//		req.getRequestDispatcher("WEB-INF/member/loginForm.jsp").forward(req, resp);
		//req.getRequestDispatcher("member/loginForm.tiles").forward(req, resp);
		HttpUtils.forward(req, resp, "member/loginForm.tiles");
	}

}
