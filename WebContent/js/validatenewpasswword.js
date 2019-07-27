 function validate1()
 
 {
	 var newpassword = document.getElementById("newpassword").value;
	 var confirmpassword= document.getElementById("confirmpassword").value;
	 
	 
	 if(newpassword=="")
		 {
		 
		 alert("New Password Field Cannot be Empty ");
     	return false;
		 
		 }
	 if(newpassword.length<8)
		 {
		 alert("password should contain atleast eight characters");
	     	return false;
		 }
	 
	 if(confirmpassword=="")
		 {
		 
		 alert("Confirm Password Field Cannot be Empty ");
     	return false;
		 
		 }
	 
	 if(confirmpassword.length<8)
	 {
	 alert("password should contain atleast eight characters");
     	return false;
	 }
	 
	 if(!(newpassword==confirmpassword))
		 {
		 
		 alert("passwords doesnt match");
	     	return false;
		 
		 }
	 
	 re=/[0-9]/;
	 
	 if(!re.test(newpassword))
		 {
		 
		 	alert("password must contain atleast one number");
		 	document.getElementById("newpassword").focus();
		 	return false;
		 	
		 }
	 
 re=/[a-z]/;
	 
	 if(!re.test(newpassword))
		 {
		 
		 	alert("password must contain atleast one lowercase letter");
		 	document.getElementById("newpassword").focus();
		 	return false;
		 	
		 }
	 
	 
 re=/[A-Z]/;
	 
	 if(!re.test(newpassword))
		 {
		 
		 	alert("password must contain atleast one uppercase letter");
		 	document.getElementById("newpassword").focus();
		 	return false;
		 	
		 }
	 
	 
	 return true;
	 
	 
 }
 
 
 
 function validateid()
 {
 	var id=document.getElementById("userId").value;
 	
 	if(id=="")
 		{
 		alert("Enter the id ");
 		return false;
 		}
 	if(isNaN(id))
 	{
 		
 		alert("Id Should be a Number ");
 		return false;
 		
 	}
 	
 	
 }
 
 
 
 
 function validatequestions()
 {
	var place= document.getElementById("birthPlace").value;
	var pet=document.getElementById("pet").value;
	
	

 	if(place=="")
 		{
 		alert("enter the birthplace ");
 		return false;
 		}
 	if(pet=="")
		{
		alert("enter the name of the pet ");
		return false;
		}
 	
 	
 	re=/[0-9]/;
	 
	 if(re.test(place))
		 {
		 
		 	alert("Answers should not be numbers");
		 	document.getElementById("newpassword").focus();
		 	return false;
		 	
		 }
	 
	 
	 
	 return true;
	 
 }