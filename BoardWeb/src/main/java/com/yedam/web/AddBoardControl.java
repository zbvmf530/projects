package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class AddBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String title = req.getParameter("title");
		String writer = req.getParameter("writer");
		String content = req.getParameter("content");

		BoardVO brd = new BoardVO();
		brd.setTitle(title);
		brd.setWriter(writer);
		brd.setContent(content);
		
		BoardService svc = new BoardServiceImpl();
		if(svc.addBoard(brd)) {
			System.out.println("등록성공!");
			resp.sendRedirect("main.do");}
		else {
			System.out.println("등록실패!");
			resp.sendRedirect("addForm.do");
		}

	}

}
