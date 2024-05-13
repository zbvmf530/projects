package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class AddBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// multipart 요청처리를 위한 처리 -> 필요정보 : 1. request정보 2.저장경로 3.파일 최대크기 4. 인코딩방식 5. 리네임정책(중복이름파일처리)
		String savePath = req.getServletContext().getRealPath("images");
		System.out.println(savePath);
		int maxSize = 5 * 1024 *1024;//5mb
		
		MultipartRequest mr = new MultipartRequest(req, savePath,maxSize,"utf-8",
				new DefaultFileRenamePolicy());
		
		String title = mr.getParameter("title");
		String writer = mr.getParameter("writer");
		String content = mr.getParameter("content");
		String img = mr.getFilesystemName("myImg");
		
		BoardVO brd = new BoardVO();
		brd.setTitle(title);
		brd.setWriter(writer);
		brd.setContent(content);
		brd.setImg(img);
		
		BoardService svc = new BoardServiceImpl();
		
		if(svc.checkMember(writer)==null) 
		{
			req.setAttribute("message", "권한이 없습니다.");
//			req.getRequestDispatcher("WEB-INF/board/addBoard.jsp").forward(req, resp);
			req.getRequestDispatcher("board/addBoard.tiles").forward(req, resp);
			return;
		}
		
		if(svc.addBoard(brd)) {
			System.out.println("등록성공!");
			resp.sendRedirect("main.do");}
		else {
			System.out.println("등록실패!");
			resp.sendRedirect("addForm.do");
		}

	}

}
