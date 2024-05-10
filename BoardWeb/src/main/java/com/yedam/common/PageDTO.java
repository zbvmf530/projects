package com.yedam.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//Data Transfer Object
@Getter
@ToString
public class PageDTO {
	// 현재, (현재페이지기준)시작, (현재페이지기준)끝페이지
	private int page, startPage, endPage;
	// 이전, 이후 페이지 체크
	private boolean prev, next; 
	
	public PageDTO(int page, int totalCnt) {
		int realEnd = (int)Math.ceil(totalCnt/5.0);
		
		this.page=page;
		this.endPage = (int)Math.ceil(page/5.0)*5;
		this.startPage = this.endPage-4;
		this.endPage = this.endPage>realEnd?realEnd:this.endPage;
		
		this.prev = this.startPage>1;
		this.next = this.endPage<realEnd?true:false;
		
	}
}
