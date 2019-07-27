  <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Sign Up Form</title>
        <link rel="stylesheet" href="css/normalize.css">
        <link href='https://fonts.googleapis.com/css?family=Nunito:400,300' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="<%=request.getContextPath() %>/css/addfile.css">
        <script  type="text/javascript" src="<%=request.getContextPath()%>/js/validatenewpasswword.js"></script>
    </head>
    
    <% String iid=(String)request.getAttribute("message1"); %>
    <%String k=iid; %>
    <%String role=(String)request.getAttribute("message2"); %>
    <table align="center">
<tr align="center">
<td>
<jsp:include page="head.jsp"></jsp:include>
</td>
</tr>
</table>
    <body>

     <form action="<%=request.getContextPath()%>/ForgotPasswordServlet?id=<%=k %>" method="post">
      
        <h1>Security Questions</h1>
        
        <fieldset>
          <label for="birthcity"> What is you birth place :</label>
          <input type="text" name="birthPlace" id="birthPlace">
          
     
          
           <label for="firstpet">What is your first pet name : </label>
          <input type="text" name="pet" id="pet">
          
         
 <input type="hidden" name="role" value="<%=role %>">
        
        </fieldset>
        <button type="submit" name="action" value="match" onclick="return validatequestions();">Submit</button>
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