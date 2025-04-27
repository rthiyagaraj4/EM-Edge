function apply()
{
	cnt=f_query_add_mod.document.forms[0].i.value;
	for(i=0;i<cnt;i++)
	{
	eval("f_query_add_mod.document.forms[0].default11"+i).disabled=false
	eval("f_query_add_mod.document.forms[0].week11"+i).disabled=false
	eval("f_query_add_mod.document.forms[0].week21"+i).disabled=false
	eval("f_query_add_mod.document.forms[0].week31"+i).disabled=false
	eval("f_query_add_mod.document.forms[0].week41"+i).disabled=false
	eval("f_query_add_mod.document.forms[0].week51"+i).disabled=false
	}
	f_query_add_mod.document.dayoftheweek.action="../../servlet/eSM.DayoftheWeekServlet";
	f_query_add_mod.document.dayoftheweek.target="messageFrame";
	f_query_add_mod.document.dayoftheweek.method="post";		
	f_query_add_mod.document.dayoftheweek.submit();
	
}

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

/*function onSuccess1(error_value)
{
		var error_id;
	if(error_value =='0')
	{
		error_id=getMessage("NO_CHANGE_TO_SAVE");
		document.forms[0];
		//messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error_id ;
		messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=' +error_id;
		//alert(messageFrame.location.name);
	}else
	{
		error_id=getMessage("RECORD_INSERTED");
		messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=' +error_id;
	}
}*/




