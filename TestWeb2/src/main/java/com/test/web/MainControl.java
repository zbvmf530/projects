package com.test.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.common.Control;

public class MainControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("실행!");
		req.getRequestDispatcher("views/main.tiles").forward(req, resp);
		//req.getRequestDispatcher("layouts/classic.tiles").forward(req, resp);
	}

}
