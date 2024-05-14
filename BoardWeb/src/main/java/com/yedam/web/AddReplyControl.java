package com.yedam.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.vo.ReplyVO;

public class AddReplyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/json;charset=utf-8");
		// 원본글, 댓글작성자, 댓글내용
		String brdNo = req.getParameter("bno");
		String writer = req.getParameter("replyer");
		String content = req.getParameter("reply");
		//String writer = req.getParameter("");
		
		ReplyService svc = new ReplyServiceImpl();
		ReplyVO rvo = new ReplyVO();
		rvo.setBoardNo(Integer.parseInt(brdNo));
		rvo.setReplyer(writer);
		rvo.setReply(content);
		
		Map<String, Object> result = new HashMap<>();
		/*
		 * Gson gson = new GsonBuilder().create(); String json = gson.toJson(rvo);
		 * if(svc.addReply(rvo)) { resp.getWriter().print(json); } else {
		 * resp.getWriter().print("null"); }
		 */
		
		  if(svc.addReply(rvo)) { 
			  // {"retCode":"OK"}
			  result.put("retCode", "OK");
			  result.put("retVal", rvo);
		  
		  }else { 
			  // {"retCode":"NG"} 
			  result.put("retCode", "NG");
			  result.put("retVal", rvo);
			
		  }
		  Gson gson = new GsonBuilder().setPrettyPrinting().create(); 
		  String json = gson.toJson(result);
		  resp.getWriter().print(json);
		 
}

}
