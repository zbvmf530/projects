package com.yedam.service;

import java.util.List;

import com.yedam.vo.BoardVO;
import com.yedam.vo.MemberVO;
// 비즈니스 로직
public interface BoardService {
	List<BoardVO> boardList(int page);
	int getTotal();
	boolean addBoard(BoardVO brd);
	BoardVO getBoard(int boardNo);
	int addViewCnt(int boardNo);
	
	boolean modifyBoard(BoardVO board);
	boolean removeBoard(int boardNo);
	
	MemberVO login(String id, String pw);
	MemberVO checkMember(String id);
}
