  <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Sign Up Form</title>
        <link rel="stylesheet" href="css/normalize.css">
        <link href='https://fonts.googleapis.com/css?family=Nunito:400,300' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="<%=request.getContextPath() %>/css/addfile.css">
        <script  type="text/javascript" src="<%=request.getContextPath() %>/js/validatenewpasswword.js"></script>
         <style>
body{
background-image:url("../image/ll.jpg");
background-repeat:no-repeat;
background-size:100%;
}</style>
    </head>
    
     
    <% String iid=(String)request.getAttribute("message1"); %>
    <table align="center">
<tr align="center">
<td>
<jsp:include page="head.jsp"></jsp:include>
</td>
</tr>
</table>
    
     <% String role=(String)request.getAttribute("message2"); %>
<body>
         

     <form action="<%=request.getContextPath()%>/ForgotPasswordServlet" method="post" >
      
        <h1> Change Password </h1>
        
        <fieldset>
          <label for="name">New Password:</label>
          <input type="password" name="newpassword" id="newpassword">
          
        <label for="name">Confirm Password:</label>
          <input type="password" name="confirmpassword" id="confirmpassword">

        <input type="hidden" value="<%=iid %>" name="idd">
        <input type="hidden" value="<%=role %>" name="role">
        </fieldset>
        <button type="submit" name="action" value="change" onclick="return validate1()">Save</button>
      </form>
      
    </body>
    <table align="center">
<tr align="center">
<td>
<jsp:include page="foot.jsp"></jsp:include>
</td>
</tr>
</table>
</html>