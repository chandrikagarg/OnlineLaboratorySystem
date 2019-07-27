package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.Forgotservice;
import com.service.PatientService;

import sun.nio.ch.WindowsAsynchronousChannelProvider;

/**
 * Servlet implementation class ForgotPasswordServlet
 */
@WebServlet("/ForgotPasswordServlet")
public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		 String action=request.getParameter("action");
		 Forgotservice ser=new Forgotservice();
		 RequestDispatcher rd=null;
		 
		 
		 if("validate".equalsIgnoreCase(action))
		 {
			 
			 
			String id= request.getParameter("userId");	
			String role=ser.validate(id);
			
			if(role==null)
			{				
				PrintWriter out = response.getWriter();  
				response.setContentType("text/html");  
				out.println("<script type=\"text/javascript\">");  
				//out.println("alert('Invalid UserId');");
				out.println("if(confirm('Invalid UserId')){window.location = 'jsp/ForgotPassword.jsp'}else{window.location = 'jsp/Login.jsp'}");
				//out.println("window.location(jsp/ForgotPassword.jsp)");
				//out.println("return false"); 
				//out.println("if(alert.accept(){${pageContext.request.contextPath}/jsp/ForgotPassword.jsp}");
				out.println("</script>");	
				
			}
			else if(role.equalsIgnoreCase("patient")||role.equalsIgnoreCase("hcp"))
			{
				  
				 rd=request.getRequestDispatcher("jsp/SecurityQuestions.jsp"); 
			   	request.setAttribute("message1", id);
			   	request.setAttribute("message2", role);
				rd.forward(request, response);
				
				
			}
			 	 
			 
		 }
		 
		 else if("match".equalsIgnoreCase(action))
			 {
				 String id=request.getParameter("id");
				 String role=request.getParameter("role");
				 
				String answer1=request.getParameter("birthPlace");
				String answer2=request.getParameter("pet");
				System.out.println("id=== "+id);
				String[]  result=null;
				if(role.equalsIgnoreCase("patient")){
				  result=ser.matchQuestionAndGetAnswers(id);
				}
				else{
					
					  result=ser.matchQuestionAndGetAnswersForHcp(id);
				}
				
				System.out.println("----inside match----");
					System.out.println(answer1);
					System.out.println(answer2);
				System.out.println("ans1"+result[0]);
				System.out.println("ans2"+result[1]);
				 
				 boolean matches=ser.match(answer1, answer2, result);
				 System.out.println("matches"+matches);
				
			if(matches==true)
			{
				 rd=request.getRequestDispatcher("jsp/ChangePassword.jsp"); 
				 request.setAttribute("message1", id);
				 request.setAttribute("message2", role);
				 rd.forward(request, response);	
			}
			else
			{
				
				PrintWriter out = response.getWriter();  
				response.setContentType("text/html");  
				out.println("<script type=\"text/javascript\">");  
				//out.println("alert('Invalid UserId');");
				out.println("if(confirm('Invalid answers')){window.location = 'jsp/ForgotPassword.jsp'}else{window.location = 'jsp/Login.jsp'}");
				//out.println("window.location(jsp/ForgotPassword.jsp)");
				//out.println("return false"); 
				//out.println("if(alert.accept(){${pageContext.request.contextPath}/jsp/ForgotPassword.jsp}");
				out.println("</script>");
				
				
				
				
				
			}
			
			
		}		 
		 
		 else if("change".equalsIgnoreCase(action))
		 {
			 
			 System.out.println("inside change");
			 String id=request.getParameter("idd");
			 String role=request.getParameter("role");
			 
			 String newpassword=request.getParameter("newpassword");
			 boolean results=false;
			 if(role.equalsIgnoreCase("patient"))
			 {
			 		 
			results =ser.forgotpassword(id, newpassword);	
			 
			 }
			 else
			 {
				 results=ser.forgotpasswordforHcp(id, newpassword);
				 
			 }
			 
			 if(results==true)
			 {
				 
				 rd=request.getRequestDispatcher("jsp/Success.jsp"); 
				
				 rd.forward(request, response);
				 
			 }
			 
			 
			 
			 
			 
		 }
		 
		
		
		
		
		
		
		
		
		
		
		
		doGet(request, response);
	}

}
