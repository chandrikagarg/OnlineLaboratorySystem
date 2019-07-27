<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
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
  <script  type="text/javascript" src="../js/addPatient.js"></script>  
  <script  type="text/javascript" src="<%=request.getContextPath()%>/js/validatenewpasswword.js"></script>
<title>Change Password</title>
  <style>
body{
background-image:url("../image/ll.jpg");
background-repeat:no-repeat;
background-size:100%;
}</style>
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
input[type=text]:focus {
    border: 3px solid #555;
}
table tr td input {
margin-top: 20px;
}
textarea{
margin-top: 20px;
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

<body class="bg">
     

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <!-- Brand -->
  
  <div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <a href="<%=request.getContextPath() %>/PatientServlet?method=view">View Profile </a>
  	<a href="<%=request.getContextPath() %>/PatientServlet?method=update">Update Profile </a>
  	<a href="<%=request.getContextPath() %>/jsp/ChangePasswordPatient.jsp">Change Password </a>
  <a href="#">Add Dependents</a>
  <a href="#">Delete Account</a>
  
 
  
</div>
<span style="font-size:30px;cursor:pointer;color:white;margin-left:48px" onclick="openNav()">&#9776; </span>
     
  <span class="navbar-brand" style="margin-left:100px">Find Lab Service</span>
  <form class="form-inline" action="<%=request.getContextPath() %>/PatientServlet" method="post">
    <input class="form-control" type="text" placeholder="Search">
    
    <button class="btn btn-success" type="submit">Search</button>
    
    <span style="font-size:20px;cursor:pointer;color:white;margin-left:380px"> Welcome</span>
    <span style="margin-left:70px"><img alt="logout" src="<%=request.getContextPath() %>/image/download.png" height="40px"> </span>
  </form>
<br>
  <!-- Links -->
</nav>
<br>
<br>


	<p align="center">
<center><h2>Change Password</h2></center>
<form action="<%=request.getContextPath() %>/PatientServlet" method="post">
<table align="center" border="0" >
<tr>
	<td>New Password*</td>
	<td><input  type="text"  name = "newpwd" id="newpassword"></td>
</tr>
<tr>
	<td>Confirm new Password*</td>
	<td><input type="text" name="confirm" id="confirmpassword" > </td>
</tr>
<tr>
	
		<td colspan="2" style="text-align: center;padding-top: 10px"> <button type="submit" name="action" value="changepasswordpatient" onclick="return validate1();">Change Password</button> </td>
</tr>
</table>
</form>

</body></html>