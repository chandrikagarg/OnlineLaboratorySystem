  <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Sign Up Form</title>
        <link rel="stylesheet" href="css/normalize.css">
        <link href='https://fonts.googleapis.com/css?family=Nunito:400,300' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="../css/addfile.css">
        <style>
body{
background-image:url("../image/r1.jpg");
background-repeat:no-repeat;
background-size:220%;
}</style>
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

      <form action="<%=request.getContextPath() %>/PatientServlet" method="post">
      
        <h1>Register Dependent</h1>
        
        <fieldset>
          <legend> Basic info</legend>
          <label for="name">First Name:</label>
          <input type="text" name="fname" id="depfirstname" >
          
          <label for="name">Last Name:</label>
          <input type="text" name="lname" id="deplastname">
          
          
           <label for="name">Relationship:
         Spouse <input type="radio" name="relation" id="relationship" value="spouse">
         Child <input type="radio" name="relation" id="relationship" value="child">
         Parent<input type="radio" name="relation" id="relationship" value="parent"></label>
          
          <label>Gender:</label>
          <input type="radio" name="gender"  value="male" id="male"><label for="male" class="light">Male</label><br>
          <input type="radio" name="gender"  value="female" id="female"><label for="female" class="light">Female</label><br><br>
       
       	  <label for="age">Age:</label>
          <input type="text" name="age" id="age">
          
          <label for="address">Address:</label>
          <input type="text" name="address" id="address">
       
       
       	  <label for="contactno">Contact No:</label>
         <input type="text" name="contactno" >
          
     
         
      <label for="insurancecover">Insurance Cover:
         Yes <input type="checkbox" name="insurancecover" id="incover" onclick="validate()">
        </label>
       
          
         <label for="address" id="healthno" style="display:none">Health Insurance Number:
          <input type="text" name="healthinsurno" id = "healthno"></label>
    
       
        
        </fieldset>
        <button type="submit" name="action" value="adddependent">Register</button>
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