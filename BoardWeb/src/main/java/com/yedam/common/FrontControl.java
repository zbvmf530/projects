package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.web.AddBoardControl;
import com.yedam.web.AddFormControl;
import com.yedam.web.AddReplyControl;
import com.yedam.web.BoardInfoControl;
import com.yedam.web.CartList;
import com.yedam.web.DelCart;
import com.yedam.web.EditCart;
import com.yedam.web.LogOutControl;
import com.yedam.web.LoginControl;
import com.yedam.web.LoginForm;
import com.yedam.web.MainControl;
import com.yedam.web.MemberListControl;
import com.yedam.web.ModifyControl;
import com.yedam.web.ModifyFormControl;
import com.yedam.web.ModifyReplyControl;
import com.yedam.web.ProductListControl;
import com.yedam.web.RemoveControl;
import com.yedam.web.RemoveFormControl;
import com.yedam.web.RemoveReplyControl;
import com.yedam.web.ReplyListControl;
import com.yedam.web.TotalCountControl;



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
		map.put("/addForm.do", new AddFormControl()); //글등록화면
		map.put("/addBoard.do", new AddBoardControl());
		map.put("/boardInfo.do", new BoardInfoControl());
		//글수정
		map.put("/modBoardForm.do", new ModifyFormControl());
		map.put("/updateBoard.do", new ModifyControl());
		//글삭제
		map.put("/romoveBoardForm.do", new RemoveFormControl());
		map.put("/deleteBoard.do", new RemoveControl());
		
		// 회원관련
		map.put("/logForm.do", new LoginForm());
		map.put("/login.do", new LoginControl());
		map.put("/logout.do", new LogOutControl());
		
		// 댓글관련
		map.put("/replyList.do", new ReplyListControl());
		map.put("/removeReply.do", new RemoveReplyControl());
		map.put("/addReply.do", new AddReplyControl());
		map.put("/getTotalCnt.do", new TotalCountControl());
		map.put("/modifyReply.do", new ModifyReplyControl());
		
		// 관리자권한
		map.put("/memberList.do", new MemberListControl());
		
		// 상품관련
		map.put("/productList.do", new ProductListControl());
		
		// 장바구니 관련
		map.put("/cartList.do", new CartList());
		map.put("/editCart.do", new EditCart());
		map.put("/delCart.do", new DelCart());
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
