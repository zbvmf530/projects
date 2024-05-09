package com.yedam.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.ibatis.session.SqlSession;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;
//import com.yedam.common.DataSource;
//import com.yedam.mapper.EmpMapper;
//import com.yedam.vo.EmployeeVO;

public class MainControl implements Control{
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
		BoardService svc = new BoardServiceImpl();
		List<BoardVO>list = svc.boardList();
		
		//jsp 페이지에 정보 전달
		req.setAttribute("boardList", list);
		req.getRequestDispatcher("WEB-INF/board/boardList.jsp").forward(req, resp);
	}
}
