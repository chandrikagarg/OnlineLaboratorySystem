<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body, button{
  background: #F5F1E3;
  font-family: 'Armata', sans-serif;
}
body{
background-image:url("../image/ss3.png");
background-repeat:no-repeat;
background-size:100%;
}

@mixin scaleTransistion($val){
  -ms-transform: scale($val);
  -moz-transform:  scale($val);
  -webkit-transform:  scale($val);
  transform:  scale($val);
}
.errorModule{
  margin:40px auto 20px;
  text-align:center;
  color: #A80000;
  .errorIcon{
    font-size:100px;
    margin: 15px;
    animation: animateIcon 5s infinite;
  }
  .errorMsg{
    font-size:100px;
  }
  @keyframes animateIcon{
    0% { @include scaleTransistion(1)}
    50% { @include scaleTransistion(2);  }
    100% { @include scaleTransistion(1)}
  }
}
</style>
</head>
<body>
<table align="center">
<tr align="center">
<td>
<p color="yellow"><jsp:include page="head.jsp"></jsp:include>
</p>
</td>
</tr>
</table>
<div class="errorModule">
  <div class="errorIcon">
    <i class="fa fa-unlink"></i>
  </div>
  <div class="errorMsg"><h4>Oops! Something went Wrong. Try Again</h4></div>
</div>

</body>
<table align="center">
<tr align="center" color="pink">
<td>
<jsp:include page="foot.jsp"></jsp:include>
</td>
</tr>
</table>
</html>