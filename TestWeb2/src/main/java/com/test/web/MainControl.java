package com.test.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.ProductVO;

public class MainControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		BoardService svc = new BoardServiceImpl();
		List<Map<String,String>> maincat = svc.getMainCat();

		// 주문수 많은 순으로 상품코드 가져오는 코드
		List<Map<String,Integer>> bestsellers = svc.getBestSeller();  
		List<Integer> bestItems = new ArrayList<>();
		for(Map<String,Integer> bs : bestsellers) {bestItems.add(Integer.parseInt(String.valueOf(bs.get("PRODUCT_CODE"))));}
		
		
		// 주문수 많은 상품코드로 상품정보 불러오는 코드
		List<ProductVO> bestProducts = new ArrayList<>(); 
		for(Integer prodCode: bestItems) 
		{bestProducts.add(svc.getProduct(prodCode));}
		bestProducts.forEach(item->System.out.println(item));
		
		// 상단 네비메뉴 구성용 코드
		List<String>catList = new ArrayList<>();
		for (Map<String, String> cat : maincat) {
			catList.add(cat.get("MAIN_CATEGORY"));
		}
		
		Map<String,List<String>> TotalList = new HashMap<>();
		
		for(String main: catList) {
			List<String> subcategory = svc.getSubCat(main);
			TotalList.put(main, subcategory);
		}
		
		
		// 카테고리 이름이 
		req.setAttribute("totalList", TotalList);
		req.setAttribute("bestProducts", bestProducts);
		
		System.out.println("실행!");
		req.getRequestDispatcher("views/main.tiles").forward(req, resp);
	}

}
