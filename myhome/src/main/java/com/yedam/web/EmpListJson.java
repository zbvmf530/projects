package com.yedam.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.yedam.dao.EmpDAO;

@WebServlet("/empList.json")
public class EmpListJson extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		// 서버->클라이언트 데이터 전달시 문자열로 넘겨주는것이 처리가 편함
		// {"name": "홍길동","age": 20}
		//"[{\"name\": \"홍길동\",\"age\": 20},{\"name\": \"박길동\",\"age\": 21}]"; // {}->객체,[]->배열
		EmpDAO edao = new EmpDAO();
		List<Map<String,Object>> list = edao.empList();
		String json="[";
		for(int i = 0; i< list.size();i++) 
		{
			Map<String,Object> map = list.get(i);
			if(i+1==list.size()) 
			{
				//사원명 연락처 이메일
				json+="{\"empNo\":"+map.get("사원번호")
						+",\"empName\":\""+map.get("사원명")
						+"\",\"empPhone\":\""+map.get("연락처")
						+"\",\"email\":\""+map.get("이메일")+"\"}"
						;
			}
			else 
			{
				json+="{\"empNo\":"+map.get("사원번호")
						+",\"empName\":\""+map.get("사원명")
						+"\",\"empPhone\":\""+map.get("연락처")
						+"\",\"email\":\""+map.get("이메일")+"\"},";
			}
			
		}
		json+="]";
		resp.getWriter().print(json);
	}
}
