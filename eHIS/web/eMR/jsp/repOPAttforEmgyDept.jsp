<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
</head>
<script src='../js/Rep2MasterList.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function reset()
{
f_query_add_mod.document.location.reload();
}

function run()
{
		if(f_query_add_mod.document.repOPAttforEmgyDeptForm)
		{
			var fields = new Array ( f_query_add_mod.document.forms[0].p_clinic_code,f_query_add_mod.document.forms[0].p_fm_Date,f_query_add_mod.document.forms[0].p_to_Date);
		var reptype=f_query_add_mod.document.getElementById("p_type").value;
	
if(reptype=="M")
		{		
		var names  = new Array ( getLabel("Common.emergency.label","Common")+' '+getLabel("Common.clinic.label","Common"),getLabel("Common.from.label","Common")+' '+getLabel("Common.month.label","Common"),getLabel("Common.to.label","Common")+' '+getLabel("Common.month.label","Common"));
		}
		else if(reptype=="Y")
		{
		var names  = new Array ( getLabel("Common.emergency.label","Common")+' '+getLabel("Common.clinic.label","Common"),getLabel("Common.from.label","Common")+' '+getLabel("Common.year.label","Common"),getLabel("Common.to.label","Common")+' '+getLabel("Common.year.label","Common"));
		}
		else
		{
			var names  = new Array ( getLabel("Common.emergency.label","Common")+' '+getLabel("Common.clinic.label","Common"),getLabel("Common.fromdate.label","Common"),getLabel("Common.todate.label","Common"));
		}
		if(reptype=="M")
		{		
		var names1  = new Array ( getLabel("Common.month.label","Common"));
		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		    {
	     if( f_query_add_mod.checkmonths( names1,f_query_add_mod.document.forms[0].p_fm_Date, f_query_add_mod.document.forms[0].p_to_Date, messageFrame ) )
	    	 f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
			f_query_add_mod.document.forms[0].target="messageFrame";
		     f_query_add_mod.document.repOPAttforEmgyDeptForm.submit() ;
			}	
		}
		else if(reptype=="Y")
		{
		var names1  = new Array ( getLabel("Common.year.label","Common"));
		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		    {
		if( f_query_add_mod.CheckString( names1,f_query_add_mod.document.forms[0].p_fm_Date, f_query_add_mod.document.forms[0].p_to_Date, messageFrame ) )
			f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
		f_query_add_mod.document.forms[0].target="messageFrame";
		     f_query_add_mod.document.repOPAttforEmgyDeptForm.submit() ;
			}
		}
		else
		{
			if(f_query_add_mod.checkFields( fields, names, messageFrame))
		    {
		   if( f_query_add_mod.doDateCheck(f_query_add_mod.document.forms[0].p_fm_Date, f_query_add_mod.document.forms[0].p_to_Date, messageFrame ) )
			   f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
			f_query_add_mod.document.forms[0].target="messageFrame";
		     f_query_add_mod.document.repOPAttforEmgyDeptForm.submit() ;
			}
		}
		
		}

		}

</script>
<%
	request.setCharacterEncoding("UTF-8");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %> frameborder='0' scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe scrolling="no" name='f_query_add_mod' id='f_query_add_mod' src='../jsp/repOPAttforEmgyDeptForm.jsp' frameborder=0 style='height:83vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
</html>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

