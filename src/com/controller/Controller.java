package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action=request.getParameter("action");
		RequestDispatcher rd=null;
		if("view".equals(action)){
			rd=request.getRequestDispatcher("jsp/vi.jsp");
			//request.setAttribute("message","gjhjhkl;opiiopuioyuiyufkjnhkluiofhggjkhjgj");
			rd.forward(request, response);
		}
			
		//String action1=request.getParameter("action");
	else if("create".equals(action)){
		
		rd=request.getRequestDispatcher("jsp/vi2.jsp");
		rd.forward(request, response);
	}
	
				
		
		
		
		
		
		
		
	}		

}
