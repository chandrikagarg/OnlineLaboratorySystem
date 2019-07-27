package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.HealthCareProvider;
import com.bean.Patient;
import com.service.HcpService;
import com.service.PatientService;


@WebServlet("/HcpServlet")
public class HcpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public HcpServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HcpService hs = new HcpService();
		RequestDispatcher rd=null; 
		String action1 = request.getParameter("method");
		 String action2 = request.getParameter("UpdateDetails");
		 String action=request.getParameter("action");
		System.out.println("action"+action);
		
		 if("update".equals(action1))
		 {
			 //these 
			 HttpSession session = request.getSession(false);
			 if(session!=null)
			 {
				 String userId=(String) session.getAttribute("userId");
				 //----------
				 
				 HealthCareProvider hcp = hs.hcp(userId);
				 System.out.println(hcp);
				 rd = request.getRequestDispatcher("jsp/ViewHcp.jsp");
				 request.setAttribute("hcpobj", hcp);
				 rd.include(request, response);
				 
				 
				 
				 
			 }
		 }
		 
		 else  if("view".equals(action1))
		 {
			 //these 
			 HttpSession session = request.getSession(false);
			 if(session!=null)
			 {
				 String userId=(String) session.getAttribute("userId");
				 //----------
				 
				 
				 HealthCareProvider hcp = hs.hcp(userId);
				 rd = request.getRequestDispatcher("jsp/ViewHcp.jsp");
				 request.setAttribute("hcpobj1", hcp);
				 rd.forward(request, response);
				 
				 
			 }
		 }
		
	  if("UpdateHcp".equals(action2))
		 {
			 String id = request.getParameter("id");
			 System.out.println(id);
			 String name = request.getParameter("name");
			 String license = request.getParameter("license");
			 System.out.println(license);
			 String address = request.getParameter("address");
			 String contact = request.getParameter("contact");
			 long contactNo = Long.parseLong(contact);
			 String alternate=request.getParameter("alternate");
			 long alternateContactNo = Long.parseLong(alternate);
			 String email = request.getParameter("email");
			 HealthCareProvider hc = new HealthCareProvider(id, name, license, address, contactNo, alternateContactNo, email);
			 boolean result = hs.updateHcp(hc);
			 if(result==true)
			 {
				 rd=request.getRequestDispatcher("jsp/Success.jsp");
					request.setAttribute("message", "update successs");
					rd.forward(request, response);
				 
			 }
		 }
	  else if("viewPatientFromHcp".equals(action1))
		 {
			 
			System.out.println("inside view patient");
			 //these 
			 HttpSession session = request.getSession(false);
			 if(session!=null)
			 {
				 String userId=(String) session.getAttribute("userId");
				 //----------
				 System.out.println("userId="+userId);
				ArrayList<Patient> temp=hs.viewPatient(userId);
				System.out.println(temp);
				 
					 rd=request.getRequestDispatcher("jsp/ViewHcp.jsp");
					 request.setAttribute("temp", temp);
					 rd.forward(request, response);
					 
				 
				 
			 }
		 }
	
	  else if ("search".equalsIgnoreCase(action))
		 {
			 
			 String value=request.getParameter("val");
			 System.out.println("vvvvv"+value);
			 Patient p=hs.SearchPatient(value);
			 System.out.println(p);
			 rd=request.getRequestDispatcher("jsp/searchViewPatient.jsp");
			 request.setAttribute("msg", p);
			 rd.forward(request, response);
		 }
		 else if("updatefromhcp".equalsIgnoreCase(action))
		 {
			 System.out.println("insideee=-------");
			 String value=request.getParameter("id");
			 System.out.println(value);
			 PatientService ser=new PatientService();
			Patient p= ser.viewPatient(value);
			 
			 System.out.println(p);
			 if(p!=null)
			 {
		 
				 rd = request.getRequestDispatcher("jsp/ViewHcp.jsp");
				 request.setAttribute("upa", p);
				 rd.forward(request, response);
				 
			 }
			 		 		 
		 }
	  
	  
		 else if("deletefromhcp".equalsIgnoreCase(action))
		 {
			 System.out.println("insideee=-------");
			 String value=request.getParameter("id");
			 System.out.println(value);
			 PatientService ser=new PatientService();
			boolean result= ser.deletePatient(value);
			 
			 System.out.println(result);
			 if(result)
				{
					
					 rd = request.getRequestDispatcher("jsp/Error.jsp");
					 request.setAttribute("msg", "Deleted Successfully and the Patient ID is " +value);
					 rd.include(request, response);
				}
				else 
				{
					rd = request.getRequestDispatcher("jsp/Error.jsp");
				 request.setAttribute("msg", "Account Cannot Be deleted Payment Pending  with userd " +value);
				 rd.include(request, response);
					
				}
			 		 		 
		 }
	  
		 
		 
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		HcpService hs = new HcpService();
		RequestDispatcher rd=null;
		 PatientService ser=new PatientService();

		String action = request.getParameter("save");
		String action1 = request.getParameter("action");
		if("Save".equals(action))
		{
			System.out.println("entered in servlet");
			String name = request.getParameter("name");
			String licenseNo = request.getParameter("licenseno");
			String address = request.getParameter("address");
			String no = request.getParameter("contactNo");
			long contactNo = Long.parseLong(no);
			String altno = request.getParameter("altcontactNo");
			long altContactNo = Long.parseLong(altno);
			String email = request.getParameter("email");
			String question1=request.getParameter("question_one");
			 String answer1=request.getParameter("q_one");	 
			 String question2=request.getParameter("question_two");	 
			 String answer2=request.getParameter("q_two");
				System.out.println("entered in servlet2");

			HealthCareProvider hcp = new HealthCareProvider(name, licenseNo, address, contactNo, altContactNo, email, question1, answer1, question2, answer2);
			boolean result = hs.registerHcp(hcp);
			if(result==true)
			{
				rd =request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
			
		}
		else if("addpatientbyhcp".equals(action1))
		{
			System.out.println("enterred hcp servlet");
			 String fName=request.getParameter("fname");
			 String lName=request.getParameter("lname");
			 String gender=request.getParameter("gender");
			 int age=Integer.parseInt(request.getParameter("age"));
			 String address=request.getParameter("address");
			 long contact=Long.parseLong(request.getParameter("contactno"));
			 String complaint=request.getParameter("medcompliant");
			 String refdoct=request.getParameter("refdoc");
			 String insurance=request.getParameter("insurancecover");
			 String healthInsuranceNo=request.getParameter("healthinsurno");
			 Patient p=new Patient(fName, lName, gender, age, address, contact, complaint, refdoct, insurance, healthInsuranceNo);
			 System.out.println(p);
			 //these 
			 HttpSession session = request.getSession(false);
			 if(session!=null)
			 {
				 String hcpId=(String) session.getAttribute("userId");
				 System.out.println("Id of hcp"+hcpId);
			
			 String[]  result=ser.addPatientByHcp(p,hcpId);
			 String username=result[0];
			 String password=result[1];
			 System.out.println("username"+username);
			 System.out.println("password"+password);
			
			 if(result !=null)
			 {
				 rd=request.getRequestDispatcher("jsp/RegistrationSuccessPatient.jsp");
			 	 
					request.setAttribute("message1", username);
					request.setAttribute("message2", password);
					rd.forward(request, response);
				 
			 }
			 else
			 {		
				 //error page
				 System.out.println("Something -------------");
			 }	 
			
		}
		}
		
		
		else  if("changepasswordhcp".equalsIgnoreCase(action1))
		 {	 
			
			 System.out.println("inside changepaswwordhcpservlet");
			 //these 
			 HttpSession session = request.getSession(false);

			 if(session!=null)
			 {
				 String hcpId=(String) session.getAttribute("userId");
				 //---------
			
			 String newPassword=request.getParameter("newpwd");
			 String confirm=request.getParameter("confirm");
			 
			 
			boolean result=hs.changePasswordHcp(hcpId, newPassword, confirm);		 
			if(result==true)
			 {
				 System.out.println("inside changepaswwordhcpservlet");
				
				PrintWriter out = response.getWriter();  
				response.setContentType("text/html");  
				out.println("<script type=\"text/javascript\">");  
				//out.println("alert('Invalid UserId');");
				out.println("if(alert('Password changed Succeessfully')){window.location = 'jsp/view1.jsp'}else{window.location = 'jsp/view1.jsp'}");
				//out.println("window.location(jsp/ForgotPassword.jsp)");
				//out.println("return false"); 
				//out.println("if(alert.accept(){${pageContext.request.contextPath}/jsp/ForgotPassword.jsp}");
				out.println("</script>");
				
				
				
				 
			 }		 
		 }
		 }
		 
		 
		
		
		
		if("loginhcp".equalsIgnoreCase(action1))
		 {
			 
			 String userName=request.getParameter("username");
			 String password=request.getParameter("password");
			 
			 
			 boolean result=hs.loginAsHCP(userName, password);
			 
			 if(result==true)
			 {
				//session create 
				 HttpSession session = request.getSession();
				 session.setAttribute("userId", userName);
				 // code end
				 
				rd=request.getRequestDispatcher("jsp/ViewHcp.jsp");
				request.setAttribute("message", "login successs");
				rd.forward(request, response);
				
			 }
			 else
			 {
				 
				 //invalid username or password
			 }
			 
		 }
		
		
	}

	}
