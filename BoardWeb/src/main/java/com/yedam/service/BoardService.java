package com.yedam.service;

import java.util.List;

import com.yedam.common.SearchVO;
import com.yedam.vo.BoardVO;
import com.yedam.vo.MemberVO;
// 비즈니스 로직
public interface BoardService {
	List<BoardVO> boardList(SearchVO search);
	int getTotal(SearchVO search);
	boolean addBoard(BoardVO brd);
	BoardVO getBoard(int boardNo);
	int addViewCnt(int boardNo);
	
	boolean modifyBoard(BoardVO board);
	boolean removeBoard(int boardNo);
	
	MemberVO login(String id, String pw);
	MemberVO checkMember(String id);
}
