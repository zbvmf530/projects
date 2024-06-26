package com.yedam.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.ibatis.session.SqlSession;

import com.yedam.common.Control;
import com.yedam.common.HttpUtils;
import com.yedam.common.PageDTO;
import com.yedam.common.SearchVO;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;
//import com.yedam.common.DataSource;
//import com.yedam.mapper.EmpMapper;
//import com.yedam.vo.EmployeeVO;

public class MainControl implements Control{
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String page = req.getParameter("page");
		String searchCondition = req.getParameter("searchCondition");
		String keyword = req.getParameter("keyword");
				
		SearchVO search = new SearchVO();
		page = page==null?"1":page; // page파라미터가 없을 경우에는 1페이지 출력
		
		search.setPage(Integer.parseInt(page));
		search.setSearchCondition(searchCondition);
		search.setKeyword(keyword);
		
		BoardService svc = new BoardServiceImpl();
		List<BoardVO>list = svc.boardList(search);
		
		//jsp 페이지에 정보 전달
		req.setAttribute("boardList", list);
		PageDTO pageDTO = new PageDTO(Integer.parseInt(page),svc.getTotal(search));
		req.setAttribute("paging", pageDTO);
		
		req.setAttribute("searchCondition", searchCondition);
		req.setAttribute("keyword", keyword);
//		req.getRequestDispatcher("WEB-INF/board/boardList.jsp").forward(req, resp);
		//req.getRequestDispatcher("board/boardList.tiles").forward(req, resp);
		
		HttpUtils.forward(req, resp, "board/boardList.tiles");
	}
}
