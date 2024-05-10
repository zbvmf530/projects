package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class RemoveFormControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BoardService svc = new BoardServiceImpl();
		
		BoardVO brd = svc.getBoard(Integer.parseInt(req.getParameter("bno")));
		System.out.println(brd);
		req.setAttribute("bno", brd);
		req.setAttribute("page", req.getParameter("page"));
		req.getRequestDispatcher("WEB-INF/board/removeBoard.jsp").forward(req, resp);
	}

}
