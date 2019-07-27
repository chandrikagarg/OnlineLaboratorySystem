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
    <style>
    body{
background-image:url("../image/r1.jpg");
background-repeat:no-repeat;
background-size:200%;
}
    </style>
    
    <table align="center">
<tr align="center">
<td>
<jsp:include page="head.jsp"></jsp:include>
</td>
</tr>
</table>
    <body>
      <form action="<%=request.getContextPath() %>/PatientServlet" method="post">
      
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
          
         <label for="healthNo" id="healthno" style="display:none">Health Insurance Number:
          <input type="text" name="healthinsurno" ></label>
          <label for="security1">Question One:</label>
    
        <select id="job" name="question_one">
        <option>----SELECT----</option>
            <option value="What is the name of the First pet">What is the name of the First Pet</option>
            <option  value="What is the birth_place">What is the birth_place</option>
        </select>
        
         <label for="question_one">Answer:</label>
          <input type="text" name="q_one" id ="ans_one">
          
        <label for="security2">Question Two:</label>
        <select id="job" name="question_two">
         <option>----SELECT----</option>
            <option value="What is the name of the First pet">What is the name of the First Pet</option>
            <option value="What is the birth_place">What is the birth_place</option>
        </select>   
        <label for="question_two">Answer:</label>
          <input type="text" name="q_two" id = "ans_two">
        </fieldset>
        <button type="submit" name="action" value="addpatient" onclick="return validate()">Register Patient</button>
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