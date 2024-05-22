package com.yedam.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.vo.BoardVO;
import com.yedam.vo.ProductVO;



public interface BoardMapper {
	List<BoardVO> boardList();
	
	List<Map<String,String>> getMainCategory();
	List<String> getSubCategory(String mainCategory);
	List<Map<String,Integer>> getBestSeller();

	ProductVO getProduct(int productCode);
}
