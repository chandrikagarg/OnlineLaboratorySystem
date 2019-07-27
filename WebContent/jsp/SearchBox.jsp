<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="com.tcs.ilp.bean.HealthCareProvider" %>
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
<form action="<%=request.getContextPath()%>/HcpServlet" method="get">
	
	
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
HealthCareProvider hcp =(HealthCareProvider)request.getAttribute("hcpobj");
%>
<%
HealthCareProvider hc =(HealthCareProvider)request.getAttribute("hcpobj1");
%>
<body class="bg">
    
	

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <!-- Brand -->
  
  <div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <a href="<%=request.getContextPath() %>/HcpServlet?method=view">View Profile </a>
  	<a href="<%=request.getContextPath() %>/HcpServlet?method=update"">Update Profile </a>
  	<a href="#">Change Password </a>
  <a href="jsp/SearchBox.jsp">Search Patient</a>
  <a href="#">Delete Account</a>
  
 
  
</div>
<span style="font-size:30px;cursor:pointer;color:white;margin-left:48px" onclick="openNav()">&#9776; </span>
     
  <span class="navbar-brand" style="margin-left:80px">Find Lab Service</span>
  <form class="form-inline" action="/action_page.php">
    <input class="form-control" type="text" placeholder="Search">
    
    <button class="btn btn-success" type="submit">Search</button>
    
    <span style="font-size:20px;cursor:pointer;color:white;margin-left:380px"> Welcome _____ </span>
    <span style="margin-left:70px"><img alt="logout" src="../image/download.png" height="40px"> </span>
  </form>

  <!-- Links -->
  </nav>
 
<br>
<% 
if(hcp!=null)
{
%>

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
	<td> <input type="submit" name="UpdateDetails" value="UpdateHcp"> </td>
	</tr>
	
	<br><br><br>
	
	
	
	
</table>

<%} %>


<br>
<p align="center">
<table align="center" border="1">
<form action="<%=request.getContextPath() %>/HcpServlet" method="get">
 <tr>
		<td>Search</td>
		<td><input type="text" name="val" ></td>
	</tr>
	<br>
	<br>
	<br>
	<tr>
		<td><input type="submit" name="action" value="search"></td>
	<tr>
</form>
</table>
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

