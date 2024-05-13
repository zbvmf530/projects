package com.yedam.common;

import lombok.Data;

@Data
public class SearchVO {
	private int page;
	private String searchCondition,keyword;
}
