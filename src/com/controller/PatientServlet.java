package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Dependent;
import com.bean.Patient;
import com.service.PatientService;



@WebServlet("/PatientServlet")
public class PatientServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientServlet() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		
		 String action=request.getParameter("action");
		 PatientService ser=new PatientService();
		 RequestDispatcher rd=null;
		 if("OK".equalsIgnoreCase(action))
		 {
			 
			 rd=request.getRequestDispatcher("index.jsp");
			 rd.forward(request, response);
			 
		 }
		 String action1 = request.getParameter("method");
		 if("view".equals(action1))
		 {
			 
			 //these 
			 HttpSession session = request.getSession(false);
			 if(session!=null)
			 {
				 String userId=(String) session.getAttribute("userId");
				 //----------
				 System.out.println("session User Id");
				 System.out.println(userId);
				 Patient p =ser.viewPatient(userId);
				 System.out.println("inside view servlet");
				 System.out.println(p);
				 rd = request.getRequestDispatcher("jsp/view1.jsp");
				 request.setAttribute("pa", p);
				 rd.include(request, response);
				 
				 
			 }
		 }
		 if("update".equalsIgnoreCase(action1))
		 {
			 System.out.println("_____________________here");
			 HttpSession session = request.getSession(false);
			 if(session!=null)
			 {
				 String userId=(String) session.getAttribute("userId");
				 
				 //----
				 Patient p =null;
				 p= ser.viewPatient(userId);
				 rd=request.getRequestDispatcher("jsp/UpdatePatient.jsp");
				 request.setAttribute("pa", p);
				 rd.forward(request, response);
			 }
		 }
		 if("delete".equalsIgnoreCase(action))
		 {
			 System.out.println("Enterred delete ");
			 //these 
			 HttpSession session = request.getSession(false);
			 if(session!=null)
			 {
				 String userId=(String) session.getAttribute("userId");
				 System.out.println(userId);
				boolean result =ser.deletePatient(userId);
				System.out.println(result);
				if(result)
				{
					
					 rd = request.getRequestDispatcher("jsp/Error.jsp");
					 request.setAttribute("msg", "Deleted Successfully and the Patient ID is " +userId);
					 rd.include(request, response);
				}
				else 
				{
					rd = request.getRequestDispatcher("jsp/Error.jsp");
				 request.setAttribute("msg", "Account Cannot Be deleted Payment Pending  with userd " +userId);
				 rd.include(request, response);
					
				}
			 }
		 }
	}

				 
			

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		 String action=request.getParameter("action");
		 PatientService ser=new PatientService();
		 RequestDispatcher rd=null;
		 
		 if("addpatient".equalsIgnoreCase(action))
		 {
			 
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
			 String question1=request.getParameter("question_one");
			 String answer1=request.getParameter("q_one");	 
			 String question2=request.getParameter("question_two");	 
			 String answer2=request.getParameter("q_two");
			 
			 
			 Patient p=new Patient(fName, lName, gender, age, address, contact, complaint, refdoct, insurance, healthInsuranceNo,question1,answer1,question2,answer2);
			 
			 String[]  result=ser.addPatient(p);
			 String username=result[0];
			 String password=result[1];
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
		 if("updatepatient".equalsIgnoreCase(action))
		 {
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
			 String pId=request.getParameter("prodId");
			 
			System.out.println(pId +" ----"+fName+" ----"+ lName+" ----"+ gender+" ----"+ age+" ----"+ address+" ----"+ contact+" ----"+ complaint);		 
			 Patient p1=new Patient(fName, lName, gender, age, address, contact, complaint, refdoct, insurance, healthInsuranceNo, " ", " ", " ", " ");
			 boolean updatepat=ser.updatePatientDetails(p1,pId);
			 if(updatepat)
			 {
				 System.out.println("Successfully Updated");
			 }
			 else
			 {
				 System.out.println("Some error is there in your record");
			 }
		 }
		 if("adddependent".equalsIgnoreCase(action))
		 {
			 
			 System.out.println("Here----------------------");
			String fName=request.getParameter("fname"); 
			String lName=request.getParameter("lname");
			String relation=request.getParameter("relation");
			String gender=request.getParameter("gender");
			int age=Integer.parseInt(request.getParameter("age"));
			String address=request.getParameter("address");
			long contact=Long.parseLong(request.getParameter("contactno"));
			String insurance=request.getParameter("insurancecover");
			String insuranceNo=request.getParameter("healthinsurno");
			
			System.out.println(fName+" "+lName+" "+relation+" "+gender+" "+age+" "+address+" "+contact+" "+insurance+" "+insuranceNo);
			
			Dependent d=new Dependent(fName, lName, relation, gender, age, address, contact, insurance, insuranceNo);
			 HttpSession session = request.getSession(false);
			 if(session!=null)
			 {
				 String userId=(String) session.getAttribute("userId");
				 boolean addDepen=ser.addDependentDetails(userId,d);
				 System.out.println(userId);
				 if(addDepen)
				 {
					 System.out.println("Successful");
				 }
			 
			 }
		 } 
		 
		 if("changepasswordpatient".equalsIgnoreCase(action))
		 {
			 
			
			 
			 //these 
			 HttpSession session = request.getSession(false);
			 if(session!=null)
			 {
				 String patientId=(String) session.getAttribute("userId");
				 //---------
			
			 String newPassword=request.getParameter("newpwd");
			 String confirm=request.getParameter("confirm");
			 
			 
			boolean result=ser.changePassword(patientId, newPassword, confirm);		 
			if(result==true)
			 {
				 
				
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
		 
		 
		 
		 
		 if("forgotpassword".equalsIgnoreCase(action))
		 {
			 
			 String patientId=request.getParameter("patientid");
			 String answer1=request.getParameter("answer1");
			 String answer2=request.getParameter("answer2");
			 		 	 
		 }
		 if("loginpatient".equalsIgnoreCase(action))
		 {
			 
			 String userName=request.getParameter("username");
			 String password=request.getParameter("password");
			 boolean result=ser.loginAsPatient(userName, password);
			 if(result==true)
			 {
				 //session create
				 HttpSession session = request.getSession();
				 session.setAttribute("userId", userName);
				 session.setAttribute("password", password);
				 
				rd=request.getRequestDispatcher("jsp/view1.jsp");
				request.setAttribute("message", "login successs");
				rd.forward(request, response);
				
			 }
			 else
			 {
				
				 	rd=request.getRequestDispatcher("jsp/Login.jsp");
				 	 
					request.setAttribute("message", "invalid username or password");
					rd.forward(request, response);
					
			 } 
		 }	 
		 
		doGet(request, response);
	}

}