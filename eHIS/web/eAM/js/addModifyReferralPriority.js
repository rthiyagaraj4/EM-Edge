	function reset()
	{   
		if(f_query_add_mod.document.forms[0])
			 f_query_add_mod.document.location.reload() ;	
			
		messageFrame.location.href='../../eCommon/html/blank.html'
	}


	function onSuccess()
	{  
		f_query_add_mod.document.location.reload();
	}



	function apply()
	{
	
		var priority_Desc0 = f_query_add_mod.document.getElementById('priority_Desc0').value;
		var priority_Desc1 = f_query_add_mod.document.getElementById('priority_Desc1').value;
		var priority_Desc2 = f_query_add_mod.document.getElementById('priority_Desc2').value;
        if(priority_Desc0=="" || priority_Desc1=="" || priority_Desc2=="")
        	{ 
				var msg = getMessage("REFERRAL_PRIORITY","AM");
				var messageFrame = frames[2]; 
				var error_page = "../../eCommon/jsp/MstCodeError.jsp";
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
				return false;
			}
		f_query_add_mod.document.referral_priority.action="../../servlet/eAM.ReferralPriorityServlet";
		f_query_add_mod.document.referral_priority.target="messageFrame";
		f_query_add_mod.document.referral_priority.method="post";		
		f_query_add_mod.document.referral_priority.submit();
		
}


	








