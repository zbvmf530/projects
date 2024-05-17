package com.yedam.service;

import java.util.List;

import com.yedam.common.SearchVO;
import com.yedam.vo.CartVO;
import com.yedam.vo.ReplyVO;

public interface ReplyService {
	List<ReplyVO> replyList(SearchVO search); // 목록
	boolean removeReply(int replyNo); // 삭제
	boolean addReply(ReplyVO rvo); // 등록
	boolean modifyReply(ReplyVO rvo); // 수정
	int getReplyCnt(int bno);
	
	
	
	// 장바구니 관련 서비스
	List<CartVO> cartList();
	boolean modifyCart(CartVO cvo);
	boolean removeCart(int no);
}
