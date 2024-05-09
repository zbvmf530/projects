package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class ModifyFormControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BoardService svc = new BoardServiceImpl();
		
		BoardVO brd = svc.getBoard(Integer.parseInt(req.getParameter("bno")));
		
		req.setAttribute("bno", brd);
		req.getRequestDispatcher("WEB-INF/board/editBoard.jsp").forward(req, resp);
	}

}
