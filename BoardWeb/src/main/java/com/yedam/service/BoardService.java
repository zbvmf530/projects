package com.yedam.service;

import java.util.List;

import com.yedam.vo.BoardVO;
// 비즈니스 로직
public interface BoardService {
	List<BoardVO> boardList();
	boolean addBoard(BoardVO brd);
	BoardVO getBoard(int boardNo);
	int addViewCnt(int boardNo);
	
	boolean modifyBoard(BoardVO board);
	boolean removeBoard(int boardNo);
}
