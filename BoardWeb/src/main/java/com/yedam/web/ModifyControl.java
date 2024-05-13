package com.yedam.web;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Control;
import com.yedam.common.PageDTO;
import com.yedam.common.SearchVO;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class ModifyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		String savePath = req.getServletContext().getRealPath("images");
		System.out.println(savePath);
		int maxSize = 5 * 1024 *1024;//5mb
		
		MultipartRequest mr = new MultipartRequest(req, savePath,maxSize,"utf-8",
				new DefaultFileRenamePolicy());
		BoardVO brd = new BoardVO();
		BoardService svc = new BoardServiceImpl();
		brd.setTitle(req.getParameter("title"));
		brd.setContent(req.getParameter("content"));
		brd.setBoardNo(Integer.parseInt(req.getParameter("bno")));
		String img = mr.getFilesystemName("myImg");
		brd.setImg(img);
		
		
		
		SearchVO sch = new SearchVO();
		String page = req.getParameter("page");
		String searchCondition = req.getParameter("searchCondition");
		String keyword = req.getParameter("keyword");
		sch.setPage(Integer.parseInt(page));
		sch.setKeyword(keyword);
		sch.setSearchCondition(searchCondition);
		req.setAttribute("searchCondition", searchCondition);
		req.setAttribute("keyword", keyword);
		
		// 파라미터 받아서 서비스 실행, 목록으로 이동
		if (svc.modifyBoard(brd) == true) {
			System.out.println("업데이트성공!");
			String encodeKW = URLEncoder.encode(keyword,"UTF-8");
			resp.sendRedirect("main.do?page="+page+"&searchCondition="+searchCondition+"&keyword"+encodeKW);
		} else {
			System.out.println("업데이트실패!");
		}
		
		
//		List<BoardVO> list = svc.boardList(sch);
//		PageDTO pageDTO = new PageDTO(Integer.parseInt(page),svc.getTotal(sch));
//		req.setAttribute("paging", pageDTO);
//
//		// jsp 페이지에 정보 전달
//		req.setAttribute("boardList", list);
		

		//page=32
		//req.setAttribute("paging", );
//		req.getRequestDispatcher("WEB-INF/board/boardList.jsp").forward(req, resp);
//		req.getRequestDispatcher("board/boardList.tiles").forward(req, resp);
		
	}

}
