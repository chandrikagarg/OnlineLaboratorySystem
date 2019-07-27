package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Laboratory;
import com.bean.Schedule;
import com.service.LaboratoryService;


@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public SearchServlet() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=null;

		String name = request.getParameter("name");
		String testname=request.getParameter("testname");
		LaboratoryService ls = new LaboratoryService();
		ArrayList<Schedule> scList = ls.getSchedule(name, testname);
		System.out.println(scList);
		rd=request.getRequestDispatcher("index.jsp");
		request.setAttribute("listsc", scList);
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=null;
		LaboratoryService ls = new LaboratoryService();
		String action = request.getParameter("search");
		
		if("search".equals(action))
		{	
			String value = request.getParameter("searchbox");
			System.out.println(value);
			ArrayList<Laboratory> lablist = ls.getLaboratory(value);
			System.out.println(lablist);
			rd=request.getRequestDispatcher("index.jsp");
			request.setAttribute("list", lablist);
			rd.forward(request, response);

		}
		if("search1".equals(action))
		{	
			String value = request.getParameter("searchbox");
			System.out.println(value);
			ArrayList<Laboratory> lablist = ls.getLaboratory(value);
			System.out.println(lablist);
			rd=request.getRequestDispatcher("jsp/ViewHcp.jsp");
			request.setAttribute("list", lablist);
			rd.forward(request, response);

		}
		if("search2".equals(action))
		{	
			String value = request.getParameter("searchbox");
			System.out.println(value);
			ArrayList<Laboratory> lablist = ls.getLaboratory(value);
			System.out.println(lablist);
			rd=request.getRequestDispatcher("jsp/view1.jsp");
			request.setAttribute("list", lablist);
			rd.forward(request, response);

		}
	}

}
