

 function create() 
  {
	f_query_add_mod.location.href = "../../eIP/jsp/AddModifyBedBkgSrlCtrl.jsp" ;
  }
 function query()
  {
  	f_query_add_mod.location.href="../../eIP/jsp/BedBkgSrlCtrlQueryResult.jsp";
  }
  function checkIsValidForProceed(){
	var url = f_query_add_mod.location.href;
    url = url.toLowerCase();
    if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) )
        return true;
    else
        return false;
}
 function apply()
 { 	
     
	   if (! (checkIsValidForProceed())){
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
		return false;
	}else{
	   var fields=new Array();
       var MSG_result ='0'

		fields[0]= f_query_add_mod.document.bedbkg_form.booking_type; 	
		fields[1]= f_query_add_mod.document.bedbkg_form.nxt_srl_no; 	
		fields[2]= f_query_add_mod.document.bedbkg_form.max_srl_no; 			
		var names = new Array (	getLabel('eIP.BookingType.label','IP'),	getLabel('Common.nextsrlno.label','common'),getLabel('Common.maxserialno.label','common'));
	

	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
	{
		//if(f_query_add_mod.document.bedbkg_form.gen_srl_num.checked == true)
		{
			var max = parseInt(f_query_add_mod.document.bedbkg_form.max_srl_no.value) ;
			var next = parseInt(f_query_add_mod.document.bedbkg_form.nxt_srl_no.value);
			var prev_max =parseInt(f_query_add_mod.document.bedbkg_form.prev_max_srlno.value);
			
			if(parseInt(next) > parseInt(max))
			{
				var msg= parent.parent.frames[0].getMessage("NEXT_NUM_GR_MAX_NUM","common");
				MSG_result = 1;
			}
			//if(f_query_add_mod.document.bedbkg_form.gen_srl_num.disabled==true)
			{
				if(parseInt(prev_max) > parseInt(max))
				{
					var msg=parent.parent.frames[0].getMessage("MAX_NOT_LT_PREV_MAX","IP");
					MSG_result = 1;
				}
			}
			
		}  
		
		if(MSG_result == '0')
			f_query_add_mod.document.bedbkg_form.submit();		
		else
			messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+msg+'&err_value=0' ;
	}
 }
		
  }
  
  
  function deleterecord()
  {
  	if(f_query_add_mod.document.bedbkg_form.function_name.value!="insert")
  	{   	   	 
  		f_query_add_mod.document.bedbkg_form.function_name.value="delete";		
  		f_query_add_mod.document.bedbkg_form.submit();			  		
  	}
  	else
  	{
  		messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="
  	}
}

function onSuccess() 
 { 
       if(f_query_add_mod.document.bedbkg_form.function_name.value=="insert")
        {
		f_query_add_mod.document.bedbkg_form.booking_type.value	= "" ;
		f_query_add_mod.document.bedbkg_form.gen_srl_num.value	= "" ;
		f_query_add_mod.document.bedbkg_form.nxt_srl_no.value	= "" ;
		f_query_add_mod.document.bedbkg_form.max_srl_no.value	= "" ;
		f_query_add_mod.document.bedbkg_form.booking_type.focus();
		
	}
}

function reset()
{
   if (! (checkIsValidForProceed())){
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
		return false;
	}else
	{
   if(f_query_add_mod.document.bedbkg_form.function_name.value=="insert")
		f_query_add_mod.document.forms[0].reset() ;
   else
		f_query_add_mod.document.location.reload();
	}
}
