package com.yedam.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.dao.EmpDAO;
import com.yedam.vo.EmpVO;

@WebServlet("/empsave.json")
public class EmpJson extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 추가(add), 수정(edit), 삭제(delete)
		String job = req.getParameter("job");
		EmpDAO edao = new EmpDAO();
		String eno = req.getParameter("empNo");
		String c = req.getParameter("email");
		String d = req.getParameter("salary");
		EmpVO emp = new EmpVO();
		
		Map<String,Object> map = new HashMap<>();
		Gson gson = new GsonBuilder().create();
		
		if (job.equals("add")) 
		{   
			String a = req.getParameter("name");
			String b = req.getParameter("phone");
			String e = req.getParameter("hire");
			emp.setEmpName(a);emp.setEmpPhone(b);emp.setEmail(c);
			emp.setSalary(Integer.parseInt(d));emp.setHireDate(e);
			
			if(edao.insertEmp(emp)) 
			{
				map.put("retCode", "OK");
				map.put("retVal", emp);
//				resp.getWriter().print("{\"retCode\": \"OK\"}");
				resp.getWriter().print(gson.toJson(map));
			}
			else 
			{
//				resp.getWriter().print("{\"retCode\": \"NG\"}");
				map.put("retCode", "NG");
				map.put("retVal", null);
				resp.getWriter().print(gson.toJson(map));
			}
		} 
		else if (job.equals("edit")) 
		{
			
			emp.setEmpNo(Integer.parseInt(eno));
			emp.setSalary(Integer.parseInt(d));
			emp.setEmail(c);
			
			if(edao.updateEmp(emp)) {
				emp = edao.selectEmp(emp.getEmpNo());
				map.put("retCode", "OK");
				map.put("retVal", emp);
				resp.getWriter().print(gson.toJson(map));
				}
			else {
				map.put("retCode", "NG");
				map.put("retVal", null);
				resp.getWriter().print(gson.toJson(map));
				}
			//resp.getWriter().print(gson.toJson(map));
		} 
		else if (job.equals("delete")) 
		{
			
			// {"retCode": "OK"}
			if (edao.deleteEmp(Integer.parseInt(eno))) {resp.getWriter().print("{\"retCode\": \"OK\"}");}
			// {"retCode": "NG"}
			else {resp.getWriter().print("{\"retCode\": \"NG\"}");}
		}

	}

}
