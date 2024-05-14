package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.common.HttpUtils;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;

public class AddFormControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BoardService svc = new BoardServiceImpl();
		
		//req.getRequestDispatcher("WEB-INF/board/addBoard.jsp").forward(req, resp);
		//req.getRequestDispatcher("board/addBoard.tiles").forward(req, resp);

		HttpUtils.forward(req, resp, "board/addBoard.tiles");
		
	}

}
