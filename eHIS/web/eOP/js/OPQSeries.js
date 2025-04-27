function create()
{
    f_query_add_mod.location.href = "../../eOP/jsp/addModifyOPQSeries.jsp" ;
}

function query()
{
    f_query_add_mod.location.href ="../../eOP/jsp/queryOPQSeriesCriteria.jsp";
}

function apply()
{
   
	if (! (checkIsValidForProceed()) )
    {
        messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=&err_value=0';
        return false;
    }
	
	var resetqno=f_query_add_mod.document.forms[0].reset_queue_num;
    if(resetqno.value=="") resetqno.value="";

	
	var fields = new Array (f_query_add_mod.document.forms[0].queue_id,
                        f_query_add_mod.document.forms[0].short_desc,
                        f_query_add_mod.document.forms[0].start_queue_num,
						f_query_add_mod.document.forms[0].q_prefix
                        );

	var names = new Array ( getLabel("eOP.QueueID.label","Op"),
                         getLabel("Common.description.label","Common"),
                         getLabel("eOP.StartNumber.label","Op"),
						 getLabel("eOP.QueuePrefix.label","Op")
                        );
	var field = new Array (f_query_add_mod.document.forms[0].queue_id);
	var name =  new Array (getLabel("eOP.QueueID.label","Op"));
	
	var error_page = "../../eCommon/jsp/error.jsp";

	if(f_query_add_mod.checkFields( fields, names, messageFrame))
    {
	 if(f_query_add_mod.SpecialCharCheck(field,name,messageFrame,"M",error_page))
	  {
		if(f_query_add_mod.document.forms[0].walk_in.checked==true || f_query_add_mod.document.forms[0].appts.checked==true || f_query_add_mod.document.forms[0].referrals.checked== true)
	    {
		}else
	   {
		var msg=getMessage("EITHER_WLKIN_APT_REF_SHD_BE_SELECTED","OP");
		messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg+'&err_value=0';
        return false;
	   }
                
		f_query_add_mod.document.forms[0].submit();
	  }
       
    }

}

function onSuccess()
{

   if(f_query_add_mod.document.forms[0].mode.value == "Insert")
    {
		f_query_add_mod.document.forms[0].queue_id.value  = "" ;
	    f_query_add_mod.document.forms[0].short_desc.value = "" ;
		f_query_add_mod.document.forms[0].start_queue_num.value     = "1" ;
	    f_query_add_mod.document.forms[0].next_queue_num.value  = "1" ;
		f_query_add_mod.document.forms[0].reset_queue_num.value = "" ;
		f_query_add_mod.document.forms[0].q_prefix.value = "" ;
		f_query_add_mod.document.forms[0].walk_in.checked = false ;
		f_query_add_mod.document.forms[0].appts.checked = false ;
		f_query_add_mod.document.forms[0].referrals.checked = false ;
		f_query_add_mod.document.forms[0].walk_in_yn.value = "N";
		f_query_add_mod.document.forms[0].ref_yn.value = "N";
		f_query_add_mod.document.forms[0].appt_yn.value = "N";
	}else
	{
		f_query_add_mod.location.reload() ;
	}
}

function reset()
{

    if(f_query_add_mod.location.href.indexOf("queryOPQSeriesResult.jsp")!=-1)
		     return false;
	 else
			f_query_add_mod.location.reload() ;

}

function checkIsValidForProceed()
{
 var url = f_query_add_mod.location.href;
 url = url.toLowerCase();
 if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) )
  return true;
 else
  return false;
}

function clickVal(obj)
{
	if(obj.checked)
	{
	if(obj.name == "walk_in")
	{
		document.forms[0].walk_in.value="Y";
		document.forms[0].walk_in_yn.value="Y";

	}
	else if(obj.name == "appts")
	{
		document.forms[0].appts.value="Y";
		document.forms[0].appt_yn.value="Y";
		
	}
	else if(obj.name == "referrals")
	{
		document.forms[0].referrals.value="Y";
		document.forms[0].ref_yn.value="Y";
	}else if(obj.name == "enableYN")
	{
		document.forms[0].enableYN.value="E";
		document.forms[0].enable_yn.value="E";
	}
	}else
	{
		if(obj.name == "walk_in")
	{
		document.forms[0].walk_in.value="N";
		document.forms[0].walk_in_yn.value="N";

	}
	else if(obj.name == "appts")
	{
		document.forms[0].appts.value="N";
		document.forms[0].appt_yn.value="N";
		
	}
	else if(obj.name == "referrals")
	{
		document.forms[0].referrals.value="N";
		document.forms[0].ref_yn.value="N";
	}else if(obj.name == "enableYN")
	{
		document.forms[0].enableYN.value="D";
		document.forms[0].enable_yn.value="D";
	}

	}
}

