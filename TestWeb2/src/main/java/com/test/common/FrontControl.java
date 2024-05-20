package com.test.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.web.MainControl;





public class FrontControl extends HttpServlet{

Map<String, Control> map;
	
	// 생성자
	public FrontControl() {
		map = new HashMap<>();
	}
	// init
	@Override
	public void init(ServletConfig config) throws ServletException {
		// url패턴과 실행할 Control 구현클래스 정의.
		map.put("/main.do", new MainControl());
		System.out.println("컨트롤 실행!");
		/*
		 * map.put("/addForm.do", new AddFormControl()); //글등록화면 map.put("/addBoard.do",
		 * new AddBoardControl()); map.put("/boardInfo.do", new BoardInfoControl());
		 * //글수정 map.put("/modBoardForm.do", new ModifyFormControl());
		 * map.put("/updateBoard.do", new ModifyControl()); //글삭제
		 * map.put("/romoveBoardForm.do", new RemoveFormControl());
		 * map.put("/deleteBoard.do", new RemoveControl());
		 * 
		 * // 회원관련 map.put("/logForm.do", new LoginForm()); map.put("/login.do", new
		 * LoginControl()); map.put("/logout.do", new LogOutControl());
		 * 
		 * // 댓글관련 map.put("/replyList.do", new ReplyListControl());
		 * map.put("/removeReply.do", new RemoveReplyControl()); map.put("/addReply.do",
		 * new AddReplyControl()); map.put("/getTotalCnt.do", new TotalCountControl());
		 * // 관리자권한 map.put("/memberList.do", new MemberListControl());
		 * 
		 * // 상품관련 map.put("/productList.do", new ProductListControl());
		 */
	}
	
	// service
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// filter에서 이미 처리함
		//resp.setContentType("text/html; charset=utf-8");
		//resp.setCharacterEncoding("utf-8");
		//req.setCharacterEncoding("utf-8");
		
		String uri = req.getRequestURI();
		String context = req.getContextPath();
		System.out.println("uri : "+uri+", context : "+context);
		String path = uri.substring(context.length());
		System.out.println("path : "+path);
		
		Control control = map.get(path);
		control.exec(req,resp);
	}
	
	// destroy
	@Override
	public void destroy() {
		System.out.println("destroy 호출됨. :: 인스턴스가 메모리에 사라질 때 호출.");
	}
}
