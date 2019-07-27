<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update HCP</title>
</head>
<table align="center">
<tr align="center">
<td>
<jsp:include page="head.jsp"></jsp:include>
</td>
</tr>
</table>
<body bgcolor="#10d1d8">
<center><h2>Update HCP PROFILE</h2></center>

<table align="center" border="0">
	<tr>
		<td>HCP ID</td>
		<td><input type="text" name="id" > </td>
	</tr>
	
	<tr>
		<td>Name</td>
		<td><input type="text" name="name" ></td>
	</tr>
	
	<tr>
		<td>License No</td>
		<td><input type="text" name="license"></td>
	</tr>
	
	<tr>
		<td>Address</td>
		<td><textarea name="address"></textarea></td>
		
	<tr>
	
	<tr>
		<td>Contact No</td>
		<td><input type="text" name="contact" ></td>
	</tr>
	
	<tr>
		<td>Alternate Contact No</td>
		<td><input type="text" name="alternate"></td>
	</tr>
	
	<tr>
		<td>Email</td>
		<td><input type="text" name="email"></td>
	</tr>
	
	<br><br><br>
	
	
	
	
</table>
<br>
<br>
<center>
<tr>
	<td><input type="submit" name="action" value="Update"></td>
	</tr>
	</center>

</body>
<table align="center">
<tr align="center">
<td>
<jsp:include page="foot.jsp"></jsp:include>
</td>
</tr>
</table>
</html>