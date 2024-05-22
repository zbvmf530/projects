package com.yedam.service;

import java.util.List;
import java.util.Map;

import com.yedam.vo.BoardVO;
import com.yedam.vo.ProductVO;
// 비즈니스 로직
public interface BoardService {
	List<BoardVO> boardList();
	ProductVO getProduct(int product_code);
	List<Map<String,String>> getMainCat();
	List<String> getSubCat(String mainCat);
	List<Map<String,Integer>> getBestSeller();
}
