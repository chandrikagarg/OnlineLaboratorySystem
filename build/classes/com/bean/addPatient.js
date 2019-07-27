 



function validate()
            {
	 			var firstName = document.getElementById("hcpfirstname").value;
	 			if(firstName=="")
                {
                	alert("First name cannot be empty");
                	return false;
                }
                if(firstName.length >30)
                {
                     alert("First name length cannot exceed 30 characters");
                 	return false;
        		}
                if(!firstName.match(/^[a-zA-Z]+$/))
                {
                	alert("First name invalid");
                	return false;

                }
                
                var lastName = document.getElementById("hcplastname").value;
	 			if(lastName=="")
                {
                	alert("Last name cannot be empty");
                	return false;
                }
                if(lastName.length >30)
                {
                     alert("Last name length cannot exceed 30 characters");
                 	return false;
        		}
                if(!lastName.match(/^[a-zA-Z]+$/))
                {
                	alert("Last name invalid");
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
	 			
	 			
	 			var contactNo = document.getElementById("contactno").value;
	 			if(contactNo=="")
	 			{
	 				alert("Contact No cannot be empty");
                	return false;

	 			}
	 			if(!contactNo.match(/^[0-9]+$/))
	 			{
	 				alert("Contact No invalid");
                	return false;

	 			}
	 			if(contactNo.length!=10)
	 			{
	 				alert("Contact No should be of 10 digits only");
                	return false;

	 			}
	 			
	 			
	 			var complaint = document.getElementById("complain").value;
	 			if(complaint=="")
	 			{
	 				alert("Complain cannot be empty");
                	return false;

	 			}
	 			 if(!complaint.match(/^[a-zA-Z]+$/))
	                {
	                	alert("Complain format is not valid");
	                	return false;

	                }
	 			
	 			
	 			 var ReferredBy = document.getElementById("ReferredBy").value;
		 			if(ReferredBy=="")
	                {
	                	alert("Doctor name cannot be empty");
	                	return false;
	                }
	                if(ReferredBy.length >30)
	                {
	                     alert("Doctor name length cannot exceed 30 characters");
	                 	return false;
	        		}
	                if(!ReferredBy.match(/^[a-zA-Z]+$/))
	                {
	                	alert("Doctor name invalid");
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
	 			
	 			
		 			var ansone = document.getElementById("ans_one").value;
		 			if(ansone=="")
		 				{
		 				alert("answer one cannot be empty");
	                	return false;
		 				}
		 			if(!ansone.match(/^[a-zA-Z]+$/))
	                {
	                	alert("Invalid answer one");
	                	return false;

	                }
		 			var anstwo = document.getElementById("ans_two").value;
		 			if(anstwo=="")
	 				{
	 				alert("answer two cannot be empty");
	            	return false;
	 				}
		 			if(!anstwo.match(/^[a-zA-Z]+$/))
	                {
	                	alert("Invalid answer two");
	                	return false;

	                }


            }

