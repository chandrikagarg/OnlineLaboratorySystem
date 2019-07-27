<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="com.tcs.ilp.bean.HealthCareProvider" %>
     <%@ page import="java.util.ArrayList" %>
<%@ page import="com.tcs.ilp.bean.Laboratory" %>
<%@ page import="com.tcs.ilp.bean.Patient" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/vendors/bootstrap/css/bootstrap.min.css">
<link href="<%=request.getContextPath() %>/css/main.css" type="text/css" rel="stylesheet">
<script src="<%=request.getContextPath() %>/vendors/bootstrap/css/bootstrap.min.js"></script>
<script src="<%=request.getContextPath() %>/vendors/jquery/jquery.min.js"></script>
<title>Insert title here</title>
</head>
	<%
ArrayList<Laboratory>list =(ArrayList<Laboratory>)request.getAttribute("list");
%>
	<%
ArrayList<Patient> list1 =(ArrayList<Patient>)request.getAttribute("temp");
%>

<%
Patient up =(Patient)request.getAttribute("upa");
%>
	
		<style>
	.profile-data table tr {
    background:#eee;
}
.profile-data table tr td:first-child {
    width:200px;
    background:#ff7f00;
    border-left:4px solid #35415f;
}
.profile-data table tr:hover
{
    width:200px;

}
.profile-data table tr:hover td:first-child {
    color:#fff;
    background:#35415f;
}
	
 {
    font-family: "Lato", sans-serif;
}
p.one {
    border-style: solid;
    border-height: 1px;
}

.sidenav {
    height: 100%;
    width: 0;
    position: fixed;
    z-index: 1;
    top: 0;
    left: 0;
    background-color: #111;
    overflow-x: hidden;
    transition: 0.5s;
    padding-top: 60px;
}

.sidenav a {
    padding: 10px 0px 8px 32px;
    text-decoration: none;
    font-size: 16px;
    color: #818181;
    display: block;
    transition: 0.3s;
     margin-top:20px;
}

.sidenav a:hover {
    color: #f1f1f1;
}

.sidenav .closebtn {
    position: absolute;
    top: 0;
    right: 25px;
    font-size: 36px;
    margin-left: 50px;
   
}

@media screen and (max-height: 450px) {
  .sidenav {padding-top: 15px;}
  .sidenav a {font-size: 18px;}
}
</style>

<script>
function openNav() {
    document.getElementById("mySidenav").style.width = "170px";
}

function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
}
</script>

<%
HealthCareProvider hcp =(HealthCareProvider)request.getAttribute("hcpobj");
%>
<%
HealthCareProvider hc =(HealthCareProvider)request.getAttribute("hcpobj1");
%>
<table align="center">
<tr align="center">
<td>
<jsp:include page="head.jsp"></jsp:include>
</td>
</tr>
</table>
<body class="bg">
     

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <!-- Brand -->
  
  <div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <a href="<%=request.getContextPath() %>/HcpServlet?method=view">View Profile </a>
  	<a href="<%=request.getContextPath() %>/HcpServlet?method=update">Update Profile </a>
  	<a href="<%=request.getContextPath() %>/jsp/ChangePasswordHcp.jsp">Change Password </a>
  	<a href="jsp/AddPatientByHcp.jsp">Add Patient</a>
  	<a href="<%=request.getContextPath()%>/HcpServlet?method=viewPatientFromHcp">View Registered Patient</a>
  	  <a href="jsp/SearchBox.jsp">Search Patient</a>
  
  
 
  
</div>
<span style="font-size:30px;cursor:pointer;color:white;margin-left:48px" onclick="openNav()">&#9776; </span>
     
  <span class="navbar-brand" style="margin-left:80px">Find Lab Service</span>
  <form class="form-inline" action="<%=request.getContextPath()%>/SearchServlet" method="post">
    <input class="form-control" type="text"  name="searchbox" placeholder="City,TestName">
    
    <button class="btn btn-success" type="submit" name="search" value="search1">Search</button>
    
    <span style="font-size:20px;cursor:pointer;color:white;margin-left:380px"> Welcome _____ </span>
    <span style="margin-left:70px"><img alt="logout" src="../image/download.png" height="40px"> </span>
  </form>

  <!-- Links -->
  </nav>
 
<br>
<p class="one">
<% 
if(hcp!=null)
{
%>
<form action="<%=request.getContextPath() %>/HcpServlet" method="get">

<table align="center" border="0">
	<tr>
		<td>HCP ID</td>
		<td><input type="text" name="id" value="<%=hcp.getHcpId() %>" > </td>
	</tr>
	
	<tr>
		<td>Name</td>
		<td><input type="text" name="name" value="<%=hcp.getHcpName() %>" ></td>
	</tr>
	
	<tr>
		<td>License No</td>
		<td><input type="text" name="license" value="<%=hcp.getLicenseNo()%>"></td>
	</tr>
	
	<tr>
		<td>Address</td>
		<td><textarea name="address"><%=hcp.getAddress()%></textarea></td>
		
	<tr>
	
	<tr>
		<td>Contact No</td>
		<td><input type="text" name="contact" value="<%=hcp.getContactNo()%>" ></td>
	</tr>
	
	<tr>
		<td>Alternate Contact No</td>
		<td><input type="text" name="alternate" value="<%=hcp.getAlternateContactNo()%>"></td>
	</tr>
	
	<tr>
		<td>Email</td>
		<td><input type="text" name="email" value="<%=hcp.getEmailId()%>"></td>
	</tr>
	
	<tr>
	<td> <input type="submit" name="UpdateDetails" value="UpdateHcp" > </td>
	</tr>
	
	<br><br><br>
	
	
	
	
</table>
</form>
</p>
<%} %>


<br>
<p align="center">
<% 
if(hc!=null)
{
%>
	
<div class="container">
<div class="table table-resonsive profile-data">
	<table class="table table-responsive table-bordered" align="center" >
			<tr> <td> HCP Id </td>
				<td> <%=hc.getHcpId() %></td>
				</tr>
				<tr>
				<td>  Name </td>
				<td>    <%=hc.getHcpName() %> </td>
				</tr>
				<tr>
				<td> License No </td>
				<td><%=hc.getLicenseNo()%></td>
				</tr>
				<tr>
				<td> Address </td>
				<td><%=hc.getAddress()%></td>
				</tr>
				<tr>
				<td>Contact No</td>
				<td> <%=hc.getContactNo()%></td>
				</tr>
				<tr>
				<td>Alternate No</td>
				<td><%=hc.getAlternateContactNo()%></td>
				</tr>
				<tr>
				<td>Email </td>
				<td><%=hc.getEmailId()%></td>
				</tr>
				
				
		
	</table>
	</div>
	</div>
	
	
	<% 
}
%>
<br>
<%
if(list!=null)
{
%>
<table align="center" border="1" width="80%">
		<tr>
			<th>NAME</th>
			<th>ADDRESS</th>
			<th>ZIPCODE</th>
			<th>STATE</th>
			<th>CITY</th>
			<th>TESTNAME</th>
			<th>TESTCODE</th>
			<th>TESTDESC</th>
			<th>COST</th>
			
		</tr>
		<%
			for(Laboratory l:list) {
		%>
			<tr>
				<td><%=l.getLabName() %></td>
				<td><%=l.getLabAddress() %></td>
				<td><%=l.getLabZipCode() %></td>
				<td><%=l.getLabState() %></td>
				<td><%=l.getLabCity() %></td>
				<td><%=l.getLabName() %></td>
				<td><%=l.getTestCode() %></td>
				<td><%=l.getTestDescription() %></td>
				<td><%=l.getTotalCost() %></td>
					</tr>
		
		<%
			}
		%>
	</table>
	<% }%>



<%
if(list1!=null)
{
%>
<table align="center" border="1" width="80%">
		<tr>
			<th>Patient ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Gender</th>
			<th>Age</th>
			<th>Address</th>
			<th>Contact No</th>
			<th>Medical Complaint</th>
			<th>Referred Doctor</th>
			<th>Insurance Cover</th>
			<th>Health Insurance Cover</th>
			<th>Action</th>
			
		</tr>
		<%
			for(Patient x:list1) {
		%>
			<tr>
				<td><%=x.getPatientId() %></td>
				<td><%=x.getFirstName() %></td>
				<td><%=x.getLastName() %></td>
				<td><%=x.getGender() %></td>
				<td><%=x.getAge() %></td>
				<td><%=x.getAddress() %></td>
				<td><%=x.getContactNumber() %></td>
				<td><%=x.getMedicalComplaint() %></td>
				<td><%=x.getReferredDoctor() %></td>			
				<td><%=x.getInsuranceCover() %></td>
				<td><%=x.getHealthInsuranceNo() %></td>
				<td><a href="<%=request.getContextPath()%>/HcpServlet?action=updatefromhcp&id=<%=x.getPatientId()%>">Update</a>
				
				<a href="<%=request.getContextPath()%>/HcpServlet?action=deletefromhcp&id=<%=x.getPatientId()%>">Delete</a></td>
			</tr>
		<%
			}
		%>
	</table>
	<% }%>
	

<% 
if(up!=null)
{
%>
<center><h2>Update Patient Profile</h2></center>
<form action="<%=request.getContextPath() %>/PatientServlet" method="post">
<table align="center" border="0" >
<tr>
	<td>Product Id:</td>
	<td><input readonly="readonly" type="text" value="<%=up.getPatientId() %>" name = "prodId"></td>
</tr>
<tr>
	<td>First Name</td>
	<td><input type="text" name="fname" id="hcpfirstname" value="<%=up.getFirstName()%>"> </td>
</tr>
<tr>
	<td>Last Name</td>
	<td><input type="text" name="lname" id="hcplastname" value="<%=up.getLastName()%>"></td>
</tr>
<tr>
	<td>Gender</td>
     <%if (up.getGender()=="female") 
     {
     %>
	<td><input type="radio" name="gender" value="Male">Male 
	<input type="radio" name="gender" value="Female" checked>&nbsp;Female</td>
	<%} 
     else 
     {
     %>
     <td><input type="radio" name="gender" value="Male" checked>Male 
	<input type="radio" name="gender" value="Female" checked>&nbsp;Female</td>
     <% } %>
</tr>
<tr>
	<td>Age</td>
	<td><input type="text" name="age" id="age" value="<%= up.getAge() %>"> 
</tr>
	
<tr>
	<td>Address</td>
	<td> <input type="text" name="address" id="address" value="<%= up.getAddress() %>"> </td>
	</tr>
	
	<tr>
	<td>Contact No</td>
	<td><input type="text" name="contactno" id="contactno" value="<%= up.getContactNumber() %>"></td>
	</tr>
	<tr>
	<td> Insurance Cover </td>
	<td><input type="checkbox" name="insurance" value="Yes">Yes<br>
	</td>
</tr>
<%if(up.getHealthInsuranceNo()==null)
	{
		up.setHealthInsuranceNo(" ");
	}
	%>
<tr>
	<td>Health Insurance Number</td>
	<td><input type="text" name="healthinsurno" id="healthno" value="<%=up.getHealthInsuranceNo() %>"></td>
</tr>
<tr>
	<td>Medical Complaint</td>
	<td><input type="text" name="medcompliant" value="<%= up.getMedicalComplaint() %>"></td>
</tr>
<tr>
	<td>Referred Doctor</td>
	<%if(up.getReferredDoctor()==null)
	{
		up.setReferredDoctor(" ");
	}
	%>
	<td><input type="text" name="refdoc" value="<%= up.getReferredDoctor() %>"></td>
</tr>
<tr>
		<td colspan="2" style="text-align: center;padding-top: 10px"> <button type="submit" name="action" value="updatepatient" onclick="return validate()">Update Patient</button> </td>
</tr>
</table>
</form>
	<% 
}
%>




</p>

<br>


























































<br>





</body>
<table align="center">
<tr align="center">
<td>
<jsp:include page="Footer.jsp"></jsp:include>
</td>
</tr>
</table>