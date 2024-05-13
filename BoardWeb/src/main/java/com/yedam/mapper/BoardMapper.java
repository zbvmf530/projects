package com.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.common.SearchVO;
import com.yedam.vo.BoardVO;
import com.yedam.vo.MemberVO;

public interface BoardMapper {
	List<BoardVO> boardList();
	List<BoardVO> boardListPaging(SearchVO searchitem);
	int getTotalCnt(SearchVO search); // 전체건수 계산
	int insertBrd(BoardVO evo);
//	int deleteEmp(int employeeId);
	BoardVO selectBoard(int boardNo);
	int updateViewCnt(int boardNo);
	int updateBoard(BoardVO board);
	int deleteBoard(int boardNo);
	
	// 사용자id, pw 확인
	MemberVO selectMember(@Param("id") String id, @Param("pw") String pw);
	MemberVO selectMember2(String id);
}
