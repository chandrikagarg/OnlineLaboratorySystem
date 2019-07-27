 function validate()
            {
	 			var name = document.getElementById("hcpname").value;
	 			if(name=="")
                {
                	alert("Name cannot be empty");
                	return false;
                }
                if(name.length >30)
                {
                     alert("Name length cannot exceed 30 characters");
                 	return false;
        		}
                if(!name.match(/^[a-zA-Z]+$/))
                {
                	alert("Name invalid");
                	return false;

                }
	 			var license = document.getElementById("hcplicense").value;
	 			if(license=="")
                {
                	alert("license cannot be empty");
                	return false;
                }
	 			if(!license.match(/^[1-9]+$/))
	 			{
	 			   alert("Invalid License No");
               	return false;

	 			}
	 			var address = document.getElementById("address").value;
	 			if(address=="")
	 			{
	 				alert("Adress Cannot Be Empty");
                	return false;
	 			}
	 			if(address.length>100)
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
	 			var alternateNo = document.getElementById("altcontactNo").value;
	 			if(alternateNo=="")
	 			{
	 				alert("AlterNate  ContactNo cannot be empty");
                	return false;

	 			}
	 			if(!alternateNo.match(/^[1-9]+$/))
	 			{
	 				alert("AlterNate  ContactNo should always be in Digit");
                	return false;

	 			}
	 			if(!alternateNo.length>10)
	 			{
	 				alert("Contact No should be of 10 digits only");
                	return false;

	 			}
	 			var email = document.getElementById("email").value;
	 				
	 			if(!email.match(/^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/))
	 			{
	 				alert("Invalid email address");
                	return false;

	 			}
	 			if(email=="")
	 			{
	 				alert("email cannot be empty");
                	return false;

	 			}
	 			var ansone = document.getElementById("answerone").value;
	 			if(ansone=="")
	 				{
	 				alert("answer one cannot be empty");
                	return false;
	 				}
	 			var anstwo = document.getElementById("answertwo").value;
	 			if(anstwo=="")
 				{
 				alert("answer two cannot be empty");
            	return false;
 				}


            }

