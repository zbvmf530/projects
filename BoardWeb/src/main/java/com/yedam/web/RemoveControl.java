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

public class RemoveControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		BoardService svc = new BoardServiceImpl();
		int bno = Integer.parseInt(req.getParameter("bno"));

		// 파라미터 받아서 서비스 실행, 목록으로 이동
		if (svc.removeBoard(bno) == true) {
			System.out.println("삭제성공!");
			System.out.println(req.getParameter("page"));
		} else {
			System.out.println("삭제실패!");
		}
		String page = req.getParameter("page");
		//PageDTO pageDTO = new PageDTO(Integer.parseInt(page),svc.getTotal());
		//req.setAttribute("paging", pageDTO);
		//List<BoardVO> list = svc.boardList(Integer.parseInt(page));

		// jsp 페이지에 정보 전달
		//req.setAttribute("boardList", list);
		req.getRequestDispatcher("WEB-INF/board/boardList.jsp").forward(req, resp);
	}

}
