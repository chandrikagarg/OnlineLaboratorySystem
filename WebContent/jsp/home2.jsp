<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
* {box-sizing: border-box;}

body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}
body{
background-image:url("../image/h1.jpg");
background-repeat:no-repeat;
background-size:150%;
}
.dropbtn {
    background-color: #4CAF50;
    color: white;
    padding: 16px;
    font-size: 16px;
    border: none;
}

.dropdown {
    position: relative;
    display: inline-block;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: blue;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}

.dropdown-content a:hover {background-color: #ddd}

.dropdown:hover .dropdown-content {
    display: block;
}

.dropdown:hover .dropbtn {
    background-color: orange;
}
.topnav {
  overflow: hidden;
  background-color:orange;
}

.topnav a {
  float: left;
  display: block;
  color: black;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: red;
  color: black;
}

.topnav a.active {
  background-color: #2196F3;
  color: white;
}

.topnav .search-container {
  float: right;
}

.topnav input[type=text] {
  padding: 6px;
  margin-top: 8px;
  font-size: 17px;
  border: none;
}

.topnav .search-container button {
  float: right;
  padding: 6px 10px;
  margin-top: 8px;
  margin-right: 16px;
  background: #ddd;
  font-size: 17px;
  border: none;
  cursor: pointer;
}

.topnav .search-container button:hover {
  background: #ccc;
}

@media screen and (max-width: 600px) {
  .topnav .search-container {
    float: none;
  }
  .topnav a, .topnav input[type=text], .topnav .search-container button {
    float: none;
    display: block;
    text-align: left;
    width: 100%;
    margin: 0;
    padding: 14px;
  }
  .topnav input[type=text] {
    border: 1px solid #ccc;  
  }
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

<div class="topnav">
 <!-- -  <a class="active" href="#home">Home</a>--->
  <a href="#about">About</a>
  <a href="#contact">Contact</a>
    
    <a href="#about">login</a>
    
   <div class="dropdown">
   <select><button class="dropbtn">Register</button>
 <option>Register as Patient</option>
  <option>Register as Hcp</option></select>
  
  
  
  <div class="dropdown-content">
    <a href="#">register patient</a>
    <a href="#">register HCP</a>
    
  </div>
</div> 

  
  <div class="search-container">
    <form action="/action_page.php">
      LabServices <input type="text" placeholder="Search.." name="search">
      <button type="submit"><i class="fa fa-search"></i></button>
    </form>
  </div>
</div>
  

</body>
<table align="center">
<tr align="center">
<td>
<jsp:include page="foot.jsp"></jsp:include>
</td>
</tr>
</table>
</html>
