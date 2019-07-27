<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.tcs.ilp.bean.HealthCareProvider" %>
     <%@ page import="java.util.ArrayList" %>
          <%@ page import="java.util.ArrayList" %>
     <%@ page import="java.util.*" %>
     
    <%@ page import="com.tcs.ilp.bean.Laboratory" %>
    <%@ page import="com.tcs.ilp.bean.Patient" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/vendors/bootstrap/css/bootstrap.min.css">
<link href="<%=request.getContextPath() %>/css/main.css" type="text/css" rel="stylesheet">
<script src="<%=request.getContextPath() %>/vendors/bootstrap/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath() %>/vendors/jquery/jquery.min.js"></script>
<title>Insert title here</title>
</head>
	
	
	<style>
	.profile-data table tr {
    background:#eee;
}
.profile-data table tr td:first-child {
    width:200px;
    background:#ff7f00;
    border-left:4px solid #35415f;
}
.profile-data table tr:hover,
.profile-data table tr:hover td:first-child {
    color:#fff;
    background:#35415f;
}
tr{text-align: center;
}
	tr:nth-child(even){background-color: #f2f2f2}

th {
    background-color: #4CAF50;
    color: white;
    text-align: center;
}
 {
    font-family: "Lato", sans-serif;
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
Patient p =(Patient)request.getAttribute("pa");
%>

<%
Patient up =(Patient)request.getAttribute("upa");
%>
<%
ArrayList<Laboratory>list =(ArrayList<Laboratory>)request.getAttribute("list");
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
  <a href="<%=request.getContextPath() %>/PatientServlet?method=view">View Profile </a>
  	<a href="<%=request.getContextPath() %>/PatientServlet?method=update">Update Profile </a>
  	<a href="<%=request.getContextPath() %>/jsp/ChangePasswordPatient.jsp">Change Password </a>
  <a href="jsp/AddDependents.jsp">Add Dependents</a>
  <a href="<%=request.getContextPath() %>/PatientServlet?action=delete"">Delete Account</a>
   
 
  
</div>
<span style="font-size:30px;cursor:pointer;color:white;margin-left:48px" onclick="openNav()">&#9776; </span>
     
  <span class="navbar-brand" style="margin-left:100px">Find Lab Service</span>
  <form class="form-inline"  action="<%=request.getContextPath()%>/SearchServlet" method="post">
    <input class="form-control" type="text"name="searchbox" placeholder="City,TestName">
    
    <button class="btn btn-success" type="submit" name="search" value="search2">Search</button>
    
    <span style="font-size:20px;cursor:pointer;color:white;margin-left:380px"> Welcome <%=p.getFirstName() %></span>
    <span style="margin-left:70px"><img alt="logout" src="<%=request.getContextPath() %>/image/download.png" height="40px"> </span>
  </form>
<br>
  <!-- Links -->
</nav>
<br>
<br>


<p align="center">
<% 
if(p!=null)
{
%>
	
<div class="container">
<div class="table table-resonsive profile-data">
	<table class="table table-responsive table-bordered" align="center">
			<tr> <td> Patient Id </td>
				<td> <%=p.getPatientId() %></td>
				</tr>
				<tr>
				<td> First Name </td>
				<td>    <%=p.getFirstName() %> </td>
				</tr>
				<tr>
				<td> Last Name </td>
				<td><%=p.getLastName() %></td>
				</tr>
				<tr>
				<td> Gender </td>
				<td><%=p.getGender() %></td>
				</tr>
				<tr>
				<td>Age</td>
				<td> <%=  p.getAge()%></td>
				</tr>
				<tr>
				<td>Address</td>
				<td><%= p.getAddress()%></td>
				</tr>
				<tr>
				<td>Contact No</td>
				<td><%=p.getContactNumber() %></td>
				</tr>
				<tr>
				<td>Medical Complaint</td>
				<td><%= p.getMedicalComplaint()%></td>
				</tr>
				
		
	</table>
	</div>
	</div>
	
	
	<% 
}
%>

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
	
</p>

</body>
<table align="center">
<tr align="center">
<td>
<jsp:include page="foot.jsp"></jsp:include>
</td>
</tr>
</table>