<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body{
background-image:url("../image/e4.png");
background-repeat:no-repeat;
background-size:100%;
}
</style>
</head>
<table align="center">
<tr align="center">
<td>
<p color="yellow"><jsp:include page="head.jsp"></jsp:include>
</p>
</td>
</tr>
</table>
<body>
<form action="<%=request.getContextPath()%>/HomeController" method="post">

<h1 align = "center" style="color: red;" ><%=request.getAttribute("msg") %></h1>
<table align="center">
<tr align="center" colspan="2">
<td>
<tr><td><input  type="submit" name="action"  value="Home"></td>
<td><input type="submit" name="action"  value="Back"></td></tr>


</table>
</form>

</body>
<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
<table align="center">
<tr align="center" color="pink">
<td>
<jsp:include page="foot.jsp"></jsp:include>
</td>
</tr>
</table>
</html>