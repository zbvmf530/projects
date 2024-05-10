package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class BoardInfoControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BoardService svc = new BoardServiceImpl();
		
		BoardVO brd = svc.getBoard(Integer.parseInt(req.getParameter("bno")));
		svc.addViewCnt(Integer.parseInt(req.getParameter("bno")));
		String page = req.getParameter("page");
		
		req.setAttribute("result", brd);
		req.setAttribute("page", page);
		
//		if(brd!=null){System.out.println(brd);}
//		else {System.out.println("조회실패!");}
		
		req.getRequestDispatcher("WEB-INF/board/board.jsp").forward(req, resp);
	}

}
