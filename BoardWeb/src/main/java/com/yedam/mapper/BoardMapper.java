package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.BoardVO;

public interface BoardMapper {
	List<BoardVO> boardList();
	int insertBrd(BoardVO evo);
//	int deleteEmp(int employeeId);
	BoardVO selectBoard(int boardNo);
	int updateViewCnt(int boardNo);
	int updateBoard(BoardVO board);
	int deleteBoard(int boardNo);
}
