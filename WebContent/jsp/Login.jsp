<!DOCTYPE html>
<html lang="en" >

<head>
  <meta charset="UTF-8">
  <title>Login Form</title>
  <link href="../css/normal.css" rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="../css/normalize-min.css"> 
      
      <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

  <style>
    body{
background-image:url("../image/ll.jpg");
background-repeat:no-repeat;
background-size:100%;
}
    </style>
    
</head>
<table align="center">
<tr align="center">
<td>
<jsp:include page="head.jsp"></jsp:include>
</td>
</tr>
</table>

<body>

  <div class="form">
      
      <ul class="tab-group">
        <li class="tab active"><a href="#signup">Login as Patient</a></li>
        <li class="tab"><a href="#login">Login as HCP</a></li>
      </ul>
      
      <div class="tab-content">
        <div id="signup">   
          <h1>Welcome !</h1>
          
         <div><center><font color="white">
         <%if(request.getAttribute("message")!=null){ %>
         <%=request.getAttribute("message") %>
         <%} %></font>
         </center>
         <br>
         
         
       
         
         </div>
         
          <form action="<%=request.getContextPath() %>/PatientServlet" method="post">
          
         

          <div class="field-wrap">
            <label>
              Patient ID<span class="req">*</span>
            </label>
            <input name="username"type="text"required autocomplete="off"/>
          </div>
          
          <div class="field-wrap">
            <label>
              Password<span class="req">*</span>
            </label>
            <input name="password" type="password"required autocomplete="off"/>
          </div>
          <input type="hidden" name="role" value="patient">
                    <p class="forgot"><a href="ForgotPassword.jsp">Forgot Password?</a></p>
          
          <button type="submit" name="action" value="loginpatient" class="button button-block"  />Login</button>
          
          </form>

        </div>
        
        <div id="login">   
          <h1>Welcome Back!</h1>
          
          <form action="<%=request.getContextPath() %>/HcpServlet" method="post">
          
           
          <div class="field-wrap">
            <label>
              HCP ID<span class="req">*</span>
            </label>
            <input name="username"type="text"required autocomplete="off"/>
          </div>
          
          <div class="field-wrap">
            <label>
              Password<span class="req">*</span>
            </label>
            <input name="password" type="password"required autocomplete="off"/>
          </div>
          
          <p class="forgot"><a href="ForgotPassword.jsp">Forgot Password?</a></p>
          
          <button name="action" value="loginhcp" class="button button-block"/>Login</button>
        
          </form>

        </div>
        
      </div><!-- tab-content -->
      
</div> <!-- /form -->
  <script src='../js/min.js'></script>

  

    <script  src="../js/index.js"></script>




</body>
<table align="center">
<tr align="center">
<td>
<jsp:include page="foot.jsp"></jsp:include>
</td>
</tr>
</table>

</html>
