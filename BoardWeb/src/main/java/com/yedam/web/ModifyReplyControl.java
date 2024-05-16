package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.vo.ReplyVO;

public class ModifyReplyControl implements Control{

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String rno= req.getParameter("rno");
		String bno = req.getParameter("bno");
		String content = req.getParameter("reply");
		ReplyVO rvo = new ReplyVO();
		rvo.setBoardNo(Integer.parseInt(bno));
		rvo.setReplyNo(Integer.parseInt(rno));
		rvo.setReply(content);
		
		ReplyService svc = new ReplyServiceImpl();
		if(svc.modifyReply(rvo)) {
			// {"retCode":"OK"}
			resp.getWriter().print("{\"retCode\":\"OK\"}");
		}else {
			// {"retCode":"NG"}
			resp.getWriter().print("{\"retCode\":\"NG\"}");
		}

	}

}