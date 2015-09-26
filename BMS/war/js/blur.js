	function regex(emailField)
	{
	        var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;

	       if(reg.test(emailField) == false) 
	        {
	            alert('Invalid Email Address');
	           
	    	   }
	}
	function validate(mobileno)
	{
		var inp =/^(\+91[\-\s]?)?[89]\d{9}$/;
		if(inp.test(mobileno)== false)
		{
            alert('Invalid mobile no');
          
    	  }
	}
	function alertmsg()
	{
		alert('Fill all the details')
	}