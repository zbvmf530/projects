package com.yedam.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.test.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;
import com.yedam.vo.ProductVO;

public class BoardServiceImpl implements BoardService{
	SqlSession session = DataSource.getInstance().openSession(true);
	BoardMapper mapper = session.getMapper(BoardMapper.class);
	

	@Override
	public List<BoardVO> boardList() {
		return mapper.boardList();
	}


	@Override
	public List<Map<String, String>> getMainCat() {
		// TODO Auto-generated method stub
		List<Map<String,String>> catList = mapper.getMainCategory();
		return catList;
	}


	@Override
	public List<String> getSubCat(String mainCat) {
		// TODO Auto-generated method stub
		return mapper.getSubCategory(mainCat);
	}


	@Override
	public List<Map<String,Integer>> getBestSeller() {
		// TODO Auto-generated method stub
		return mapper.getBestSeller();
	}


	@Override
	public ProductVO getProduct(int product_code) {
		// TODO Auto-generated method stub
		return mapper.getProduct(product_code);
	}


}
