package com.yedam.common;

import java.util.List;

import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class BoardTest {
	public static void main(String[] args) {
		BoardService svc = new BoardServiceImpl();
		
		
		//BoardVO brd = svc.getBoard(3);
		//if(brd!=null){System.out.println(brd);}
		//else {System.out.println("조회실패!");}
		
		
		/*
		 * BoardVO brd = new BoardVO(); brd.setTitle("test2");
		 * brd.setContent("testcontent2"); brd.setBoardNo(3);
		 * System.out.println(svc.modifyBoard(brd));
		 */
//		if(svc.modifyBoard(brd)) {System.out.println("업데이트성공!");}
		//else {System.out.println("업데이트실패!");}
//		brd.setTitle("test2");
//		brd.setWriter("testwriter2");
//		brd.setContent("testcontent2");
//		if(svc.addBoard(brd)) {System.out.println("등록성공!");}
//		else {System.out.println("등록실패!");}
		
		svc.boardList(3).forEach(item->System.out.println(item));
	
		
	}
}
