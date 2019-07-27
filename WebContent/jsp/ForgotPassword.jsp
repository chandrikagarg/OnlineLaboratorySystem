  <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Sign Up Form</title>
        <link rel="stylesheet" href="css/normalize.css">
        <link href='https://fonts.googleapis.com/css?family=Nunito:400,300' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/addfile.css">
         <style>
    body{
background-image:url("../image/f2.jpg");
background-repeat:no-repeat;
background-size:100%;
}
    </style>
    </head>
    <script  type="text/javascript" src="<%=request.getContextPath() %>/js/validatenewpasswword.js"></script>
<table align="center">
<tr align="center">
<td>
<jsp:include page="head.jsp"></jsp:include>
</td>
</tr>
</table>
    <body>

     <form class="form-inline" action="<%=request.getContextPath()%>/ForgotPasswordServlet" method="post">
      
        <h1>Validate your user Id :</h1>
       
 
        <fieldset>
         
          <label for="userId">Enter your user Id:</label>
           <input type="text" name="userId" id="userId">
           
        </fieldset>
        
        <button type="submit" name="action" value="validate"  onclick="return validateid();" > Submit </button>
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