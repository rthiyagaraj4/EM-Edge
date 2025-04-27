<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<% request.setCharacterEncoding("UTF-8");  %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
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
		if(f_query_add_mod.document.Rep2MthYrlyBedUtilization)
		{
			var fields = new Array(f_query_add_mod.document.forms[0].p_trn_date);
			if (f_query_add_mod.document.forms[0].report_type.value=='M')
			var names = new Array (	getLabel('Common.month.label','common'))
			else if (f_query_add_mod.document.forms[0].report_type.value=='Y')
			var names = new Array (	getLabel('Common.year.label','common'))
		    if(f_query_add_mod.checkFields( fields, names, messageFrame))
		    {
		    	f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
		   	 f_query_add_mod.document.forms[0].target="messageFrame";
		     f_query_add_mod.document.Rep2MthYrlyBedUtilization.submit() ;
			}
		}
}
</script>
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %> frameborder='0' scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe scrolling="no" name='f_query_add_mod' id='f_query_add_mod' src='../jsp/Rep2MthYrlyBedUtilization.jsp'  frameborder=0 style='height:80vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:40%;width:100vw'></iframe>
</html>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

