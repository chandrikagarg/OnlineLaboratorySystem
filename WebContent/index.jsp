<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.tcs.ilp.bean.Laboratory" %>
<%@ page import="com.tcs.ilp.bean.Schedule" %>

<!DOCTYPE html>
<html>
<title>Index</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/w3.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/w3-theme-teal.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/font.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/min.css">
 <style>
 th {
    background-color: #4CAF50;
    color: white;
    text-align: center;
}
 {
    font-family: "Lato", sans-serif;
}
tr{text-align: center;
}
	tr:nth-child(even){background-color: aqua;}
</style>

<%
ArrayList<Laboratory>list =(ArrayList<Laboratory>)request.getAttribute("list");
%>
<%
ArrayList<Schedule>schlist =(ArrayList<Schedule>)request.getAttribute("listsc");
%>
<body>

<nav class="w3-sidebar w3-bar-block w3-collapse w3-animate-left w3-card" style="z-index:3;width:250px;" id="mySidebar">
  <a class="w3-bar-item w3-button w3-hide-large w3-large" href="javascript:void(0)" onclick="w3_close()">Close <i class="fa fa-remove"></i></a>
  <a class="w3-bar-item w3-button w3-teal" href="<%=request.getContextPath()%>/jsp/AboutUs.jsp">About Us</a>
  <a class="w3-bar-item w3-button" href="<%=request.getContextPath()%>/jsp/ContactUs.jsp">Contact Us</a>
 
  <div>
    <a class="w3-bar-item w3-button" onclick="myAccordion('demo')" href="javascript:void(0)">Register</a>
    <div id="demo" class="w3-hide">
      <a class="w3-bar-item w3-button" href="<%=request.getContextPath()%>/jsp/AddPatient.jsp">Register as Patient</a>
      <a class="w3-bar-item w3-button" href="<%=request.getContextPath()%>/jsp/AddHcp.jsp">Register as HCP</a>
    </div>
  </div>
    <a class="w3-bar-item w3-button" href="<%=request.getContextPath()%>/jsp/Login.jsp">Login</a>
  
</nav>

<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" id="myOverlay"></div>

<div class="w3-main" style="margin-left:250px;">

<div id="myTop" class="w3-container w3-top w3-theme w3-large">
  <p><i class="fa fa-bars w3-button w3-teal w3-hide-large w3-xlarge" onclick="w3_open()"></i>
  <span id="myIntro" class="w3-hide">Online laboratory Services</span></p>
</div>

<header class="w3-container w3-theme" style="padding:30px 32px">
  <h1 class="w3-xxxlarge"> Online Laboratory Services </h1>
</header>

<div class="w3-container" style="padding:12px">
<form action="<%=request.getContextPath()%>/SearchServlet" method="post">
<p align="right">
<b>
<font style="color: #ffffff; background-color: blue">
Find laboratory Services</font></b> &nbsp; &nbsp;<input type="text" name="searchbox" placeholder="City,TestName"> 
  <input type = "submit" name="search" value="search"></p>
  </form>
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
				<td><a href="<%=request.getContextPath()%>/SearchServlet?name=<%=l.getLabName()%>&testname=<%=l.getTestName()%>"><%=l.getTestName() %></a></td>
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
if(schlist!=null)
{
%>
<table align="center" border="1" width="80%">
		<tr>
			<th>LAB ID</th>
			<th>TEST CODE</th>
			<th>TEST NAME</th>
			<th>SLOTS AVAILAIBLE</th>
			
		</tr>
		<%
			for(Schedule s:schlist) {
		%>
			<tr>
				<td><%= s.getLabId()%></td>
				<td><%=s.getTestCode() %></td>
				<td><%=s.getTestName() %></td>
				<td><%= s.getSlotsAvailaible()%></td>
			</tr>
		<%
			}
		%>
	</table>
	<% }%>


<div class="w3-container w3-sand w3-leftbar">

</div>

</div>

</div>

<script>
// Open and close the sidebar on medium and small screens
function w3_open() {
    document.getElementById("mySidebar").style.display = "block";
    document.getElementById("myOverlay").style.display = "block";
}
function w3_close() {
    document.getElementById("mySidebar").style.display = "none";
    document.getElementById("myOverlay").style.display = "none";
}

// Change style of top container on scroll
window.onscroll = function() {myFunction()};
function myFunction() {
    if (document.body.scrollTop > 80 || document.documentElement.scrollTop > 80) {
        document.getElementById("myTop").classList.add("w3-card-4", "w3-animate-opacity");
        document.getElementById("myIntro").classList.add("w3-show-inline-block");
    } else {
        document.getElementById("myIntro").classList.remove("w3-show-inline-block");
        document.getElementById("myTop").classList.remove("w3-card-4", "w3-animate-opacity");
    }
}

// Accordions
function myAccordion(id) {
    var x = document.getElementById(id);
    if (x.className.indexOf("w3-show") == -1) {
        x.className += " w3-show";
        x.previousElementSibling.className += " w3-theme";
    } else { 
        x.className = x.className.replace("w3-show", "");
        x.previousElementSibling.className = 
        x.previousElementSibling.className.replace(" w3-theme", "");
    }
}
</script>
     
</body>
<table align="center">
<tr align="center">
<td>

</td>
</tr>
</table>
</html> 
