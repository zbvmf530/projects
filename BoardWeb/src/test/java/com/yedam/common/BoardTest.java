package com.yedam.common;

import org.apache.ibatis.session.SqlSession;

import com.yedam.mapper.BoardMapper;
import com.yedam.mapper.ReplyMapper;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.vo.ReplyVO;

public class BoardTest {
	public static void main(String[] args) {
		BoardService svc = new BoardServiceImpl();
		SqlSession session = DataSource.getInstance().openSession(true);
		ReplyMapper mapper = session.getMapper(ReplyMapper.class);
		
		int cnt = mapper.getReplyCnt(515);
		System.out.println(cnt);
		//mapper.replyList(14656).forEach(reply->System.out.println(reply));
		
		
//		ReplyVO rvo = new ReplyVO();
//		ReplyService svc2 = new ReplyServiceImpl();
//		rvo.setBoardNo(14656);
//		rvo.setReplyer("user02");
//		rvo.setReply("test comment");
//		if(svc2.addReply(rvo)) {
//			System.out.println("등록성공");
//			mapper.replyList(14656).forEach(reply->System.out.println(reply));
//		}
//		else {
//			System.out.println("실패!");
//		}
		
		/*
		 * SearchVO sch = new SearchVO(); sch.setBoardNo(14698); sch.setRpage(2);
		 * mapper.replyListPaging(sch).forEach( reply->{System.out.println(reply);} );
		 */
//		SearchVO sch = new SearchVO();
//		sch.setSearchCondition("TW");
//		sch.setKeyword("준오");
//		sch.setPage(5);
//		mapper.boardListPaging(sch).forEach(item->System.out.println(item));
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
		
		//svc.boardList(3).forEach(item->System.out.println(item));
	
		
	}
}
