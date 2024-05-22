package com.yedam.template;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.tiles.Attribute;
import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.PreparerException;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;

import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;

public class HeaderPreparer implements ViewPreparer{

	@Override
	public void execute(Request tilesContext, AttributeContext attributeContext) throws PreparerException{
		// TODO Auto-generated method stub
		// 쿼리로 대분류, 소분류 가져오기
//		BoardService svc = new BoardServiceImpl();
//		List<BoardVO>list = svc.boardList();
		//Map<String,String> maincat = svc.getMainCat();
		
		//System.out.println(maincat);
		BoardService svc = new BoardServiceImpl();
//		List<BoardVO>list = svc.boardList();
		List<Map<String,String>> maincat = svc.getMainCat();
		List<String>catList = new ArrayList<>();
		for (Map<String, String> cat : maincat) {
			System.out.println(cat.get("MAIN_CATEGORY"));
			catList.add(cat.get("MAIN_CATEGORY"));
		}
		System.out.println(catList);
		attributeContext.putAttribute("menus", 	new Attribute(catList),false);
	}

}
