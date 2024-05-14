package com.yedam.common;

import lombok.Data;

@Data
public class SearchVO {
	private int page;
	private String searchCondition,keyword;
	
	// 댓글관련
	private int boardNo,rpage;
}
