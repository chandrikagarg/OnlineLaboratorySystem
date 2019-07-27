
 function validate()
            {
	 			var fname = document.getElementById("depfirstname").value;
	 			if(fname=="")
                {
                	alert("Name cannot be empty");
                	return false;
                }
                if(fname.length >30)
                {
                     alert("Name length cannot exceed 30 characters");
                 	return false;
        		}
                if(!fname.match(/^[a-zA-Z]+$/))
                {
                	alert("Name invalid");
                	return false;

                }
                
                var lname = document.getElementById("deplastname").value;
	 			if(lname=="")
                {
                	alert("Name cannot be empty");
                	return false;
                }
                if(lname.length >30)
                {
                     alert("Name length cannot exceed 30 characters");
                 	return false;
        		}
                if(!lname.match(/^[a-zA-Z]+$/))
                {
                	alert("Name invalid");
                	return false;

                }
                
                var Age = document.getElementById("age").value;
	 			if(Age=="")
                {
                	alert("Age cannot be empty");
                	return false;
                }
                if(Age <=0  )
                {
                     alert("Age should be greater than zero");
                 	return false;
        		}
                if(!Age.match(/^[1-9]+$/))
                {
                	alert("Invalid age");
                	return false;

                }
                if(Age >=130)
                {
                	alert("Invalid age");
                	return false;

                }
                
                var address1 = document.getElementById("address").value;
	 			if(address1=="")
	 			{
	 				alert("Adress Cannot Be Empty");
                	return false;
	 			}
	 			if(address1.length>100)
	 			{
	 				alert("Adress cannot exceed 100 characters");
                	return false;
	 			}
	 			
                
                
	 			
	 			var contactNo = document.getElementById("contactNo").value;
	 			if(contactNo=="")
	 			{
	 				alert("Contact No cannot be empty");
                	return false;

	 			}
	 			if(!contactNo.match(/^[1-9]+$/))
	 			{
	 				alert("Contact No should always be in Digit");
                	return false;

	 			}
	 			if(contactNo.length>10 && contactNo<10)
	 			{
	 				alert("Contact No should be of 10 digits only");
                	return false;

	 			}
	 			
	 			
	 			  var healthNo = document.getElementById("healthno").value;
		 			if(healthNo==" ")
	                {
	                	alert("license cannot be empty");
	                	return false;
	                }
		 			if(!healthNo.match(/^[1-9]+$/))
		 			{
		 			   alert("Invalid License No");
	               	return false;

		 			}

            }

