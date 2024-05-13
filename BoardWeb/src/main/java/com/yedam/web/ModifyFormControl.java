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
		req.setCharacterEncoding("utf-8");
		BoardService svc = new BoardServiceImpl();
		
		BoardVO brd = svc.getBoard(Integer.parseInt(req.getParameter("bno")));
		
		req.setAttribute("bno", brd);
		req.setAttribute("page", req.getParameter("page"));
		req.setAttribute("searchCondition", req.getParameter("searchCondition"));
		req.setAttribute("keyword", req.getParameter("keyword"));
//		System.out.println(brd);
//		System.out.println(req.getParameter("page"));
//		System.out.println(req.getParameter("searchCondition"));
//		System.out.println(req.getParameter("keyword"));
		
//		req.getRequestDispatcher("WEB-INF/board/editBoard.jsp").forward(req, resp);
		req.getRequestDispatcher("board/editBoard.tiles").forward(req, resp);
	}

}
