<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head> 
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link>

<script src="../js/MRReports.js" language='javascript'></script>
<script src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>

function reset()
{
	f_query_add_mod.location.reload();
}

function run()
{ 
	if(f_query_add_mod.document.MRBLABRG)
	{	 
		var errors = ""; 
		var names  = new Array(getLabel("Common.Order.label","Common")+' '+getLabel("Common.fromdate.label","Common"),getLabel("Common.Order.label","Common")+' '+getLabel("Common.todate.label","Common"));
		var fields = new Array (f_query_add_mod.document.MRBLABRG.p_fm_Date,f_query_add_mod.document.MRBLABRG.p_to_Date);

		if(f_query_add_mod.checkFields(fields, names, messageFrame))
		{
			//if( f_query_add_mod.doDateCheck(f_query_add_mod.document.MRBLABRG.p_fm_Date,f_query_add_mod.document.MRBLABRG.p_to_Date, messageFrame )  )
			f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
			f_query_add_mod.document.forms[0].target="messageFrame";
				f_query_add_mod.document.MRBLABRG.submit();
		}

		//var reptype= f_query_add_mod.document.MRBLABRG.report_type.value;
		
		/*if(reptype=="M")
		{		
		var names  = new Array ( "From Month","To Month","Report For");
		}
		else if(reptype=="Y")
		{
		var names  = new Array ( "From Year","To Year","Report For");
		}
		else
		{
			var names  = new Array ( "From Date","To Date","Report For");
		}

		if(reptype=="M")
		{					  
			var names1  = new Array ( " Month");
			if(f_query_add_mod.checkFields( fields, names, messageFrame))
			{
				if( f_query_add_mod.checkmonths( names1,f_query_add_mod.document.forms[0].p_fm_Date, f_query_add_mod.document.forms[0].p_to_Date, messageFrame ) )
				 
				
					f_query_add_mod.document.MRBLABRG.submit() ;
			}	
		}
		else if(reptype=="Y")
		{
			var names1  = new Array ( "Year");
			if(f_query_add_mod.checkFields( fields, names, messageFrame))
			{
				if( f_query_add_mod.CheckString( names1,f_query_add_mod.document.forms[0].p_fm_Date, f_query_add_mod.document.forms[0].p_to_Date, messageFrame ) )
				 
				
				   f_query_add_mod.document.MRBLABRG.submit() ;
			}
		}
		else
		{
		   if(f_query_add_mod.checkFields( fields, names, messageFrame))
		   {
			   if( f_query_add_mod.doDateCheck(f_query_add_mod.document.forms[0].p_fm_Date, f_query_add_mod.document.forms[0].p_to_Date, messageFrame ) )
				
				   f_query_add_mod.document.MRBLABRG.submit() ;
			}
		}*/
	}
}
</script>
</head>

<%
	request.setCharacterEncoding("UTF-8");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %> frameborder='0' scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe scrolling="no" name='f_query_add_mod' id='f_query_add_mod' src='../../eMR/jsp/repRadRegisterForm.jsp'  noresize frameborder=0 style='height:83vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
</html>

