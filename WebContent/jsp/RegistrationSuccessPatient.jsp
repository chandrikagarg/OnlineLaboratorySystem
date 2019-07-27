<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<table align="center">
<tr align="center">
<td>
<jsp:include page="head.jsp"></jsp:include>
</td>
</tr>
</table>
<body>
<center>
<h1>REGISTERED SUCCESSFULLY</h1>
<form action="<%=request.getContextPath() %>/PatientServlet" method="get">
 UserName=<%=request.getAttribute("message1") %><br>
 Password=<%=request.getAttribute("message2") %><br>
 <input type="submit" name="action" value="OK" >
 </center>
 </form>
</body>
<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
<br/><br/><br/><br/><br/>
<table align="center">
<tr align="center">
<td>
<jsp:include page="foot.jsp"></jsp:include>
</td>
</tr>
</table>
</html>