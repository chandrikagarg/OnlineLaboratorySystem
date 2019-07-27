  <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Sign Up Form</title>
        <link rel="stylesheet" href="css/normalize.css">
        <link href='https://fonts.googleapis.com/css?family=Nunito:400,300' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="../css/addfile.css">
        <script  type="text/javascript" src="../js/addhcp.js"></script>
        <style>
body{
background-image:url("../image/hh.jpg");
background-repeat:no-repeat;
background-size:220%;
}</style>
    </head>
    <table align="center">
<tr align="center">
<td>
<jsp:include page="head.jsp"></jsp:include>
</td>
</tr>
</table>
<body>
         

     <form action="<%=request.getContextPath()%>/HcpServlet" method="post" >
      
        <h1>Register As HCP</h1>
        
        <fieldset>
          <legend>Your basic info</legend>
          <label for="name">Name:</label>
          <input type="text" name="name" id="hcpname">
          
        <label for="name">License No:</label>
          <input type="text" name="licenseno" id="hcplicense">
          
          <label for="address">Address:</label>
          <textarea id="address" name="address" id = "address"></textarea>
     
       	  <label for="age">Contact No:</label>
          <input type="text" name="contactNo" id="contactNo">
          
          <label for="address">AlterNate Contact No:</label>
          <input type="text" name="altcontactNo" id="altcontactNo">
       
       
       	  <label for="age">Email:</label>
         <input type="text" name="email" id="email">
         
       

      <label for="security1">Question One:</label>
        <select id="job" name="question_one">
        <option>----SELECT----</option>
            <option value="What is the name of the First pet">What is the name of the First Pet</option>
            <option value="What is the birth_place">What is the birth_place</option>
        </select>
        
         <label for="question_one">Answer:</label>
          <input type="text" name="q_one" id="answerone" >
          
        <label for="security2">Question Two:</label>
        <select id="job" name="question_two">
         <option>----SELECT----</option>
            <option value="What is the name of the First pet">What is the name of the First Pet</option>
            <option value="What is the birth_place">What is the birth_place</option>
        </select>
        
        <label for="question_two">Answer:</label>
          <input type="text" name="q_two" id="answertwo" >
        
        </fieldset>
        <button type="submit" name="save" value="Save" onclick="return validate()">Register HCP</button>
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