package com.yedam.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.common.PageDTO;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class ModifyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BoardVO brd = new BoardVO();
		BoardService svc = new BoardServiceImpl();
		brd.setTitle(req.getParameter("title"));
		brd.setContent(req.getParameter("content"));
		brd.setBoardNo(Integer.parseInt(req.getParameter("bno")));

		// 파라미터 받아서 서비스 실행, 목록으로 이동
		if (svc.modifyBoard(brd) == true) {
			System.out.println("업데이트성공!");
		} else {
			System.out.println("업데이트실패!");
		}
		String page = req.getParameter("page");
		PageDTO pageDTO = new PageDTO(Integer.parseInt(page),svc.getTotal());
		req.setAttribute("paging", pageDTO);
		List<BoardVO> list = svc.boardList(Integer.parseInt(page));

		// jsp 페이지에 정보 전달
		req.setAttribute("boardList", list);
		//page=32
		//req.setAttribute("paging", );
		req.getRequestDispatcher("WEB-INF/board/boardList.jsp").forward(req, resp);
	}

}
