  <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Sign Up Form</title>
        <link rel="stylesheet" href="css/normalize.css">
        <link href='https://fonts.googleapis.com/css?family=Nunito:400,300' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/addfile.css">
        <script  type="text/javascript" src="../js/addPatient.js"></script>    
    </head> 
    
    
    <script>
    function validate() {
    var checkBox = document.getElementById("incover");
    var text = document.getElementById("healthno");
    if (checkBox.checked == true){

    	 text.style.display = "block";
    } else {
       text.style.display = "none";
    }
    </script>
    
    <table align="center">
<tr align="center">
<td>
<jsp:include page="head.jsp"></jsp:include>
</td>
</tr>
</table>
    <body>
      <form action="<%=request.getContextPath() %>/HcpServlet" method="post">
      
        <h1>Register As Patient</h1>
        
        <fieldset>
          <legend>Your basic info</legend>
          <label for="name">First Name:</label>
          <input type="text" name="fname" id="patientfirstname">
          
          <label for="name">Last Name:</label>
          <input type="text" name="lname" id="patientlastname">
          
          
          
          <label>Gender:</label>
          <input type="radio" name="gender"  value="male" id="male"><label for="male" class="light" onclick="validate()">Male</label><br>
          <input type="radio" name="gender"  value="female" id="female"><label for="female" class="light" onclick="validate()">Female</label><br><br>
       
       	  <label for="age">Age:</label>
          <input type="text" name="age" id="age">
          
          <label for="address">Address:</label>
          <input type="text" name="address" id="address">
       
       
       	  <label for="address">Contact No:</label>
         <input type="text" name="contactno" id = "contactno" >
          
     
          <label for="complaint">Medical Complaint:</label>
          <input type="text" name="medcompliant" id = "complain">
          
          <label for="doctor">Referred Doctor:</label>
          <input type="text" name="refdoc" id = "ReferredBy" >
       
           <label for="insurance">Insurance Cover:
         Yes <input type="radio" name="insurancecover" id="incover">
        
        </label>
       
     <label for="healthInsurance">Health Insurance Number:</label>
          <input type="text" name="healthinsurno" id="healthno">

        </fieldset>
        <button type="submit" name="action" value="addpatientbyhcp" onclick="return validate()">Register Patient</button>
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