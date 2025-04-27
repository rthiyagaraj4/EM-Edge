<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<% request.setCharacterEncoding("UTF-8");  %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function run()
{
if(f_query_add_mod.document.Rep2MthYrlyBedUtilization)
 {
	var fields = new Array(f_query_add_mod.document.forms[0].p_fm_date,f_query_add_mod.document.forms[0].p_to_date);
	if (f_query_add_mod.document.forms[0].report_type.value=='M')
	var names = new Array (	escape(getLabel("Common.FromMonth.label","Common")),escape(getLabel("Common.ToMonth.label","Common")))
	else if (f_query_add_mod.document.forms[0].report_type.value=='Y')
	var names = new Array (	escape(getLabel("eIP.FromYear.label","IP")),escape(getLabel("eIP.ToYear.label","IP")))
	else if (f_query_add_mod.document.forms[0].report_type.value=='D')
	var names = new Array (escape(getLabel("Common.fromdate.label","Common")),escape(getLabel("Common.todate.label","Common")))
	if(f_query_add_mod.checkFields( fields, names, messageFrame))
	{
		if( f_query_add_mod.CheckString(getLabel('Common.referralsource.label','common'), f_query_add_mod.document.Rep2MthYrlyBedUtilization.p_fm_ref,f_query_add_mod.document.Rep2MthYrlyBedUtilization.p_to_ref, messageFrame ))
		{
			if (f_query_add_mod.document.forms[0].report_type.value=='M')
			{
				var names1 = new Array (getLabel('Common.month.label','common'))
				if( f_query_add_mod.checkmonths(names1, f_query_add_mod.document.Rep2MthYrlyBedUtilization.p_fm_date,f_query_add_mod.document.Rep2MthYrlyBedUtilization.p_to_date,messageFrame ))
				{
				f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
				f_query_add_mod.document.forms[0].target="messageFrame";
				f_query_add_mod.document.Rep2MthYrlyBedUtilization.submit() ;
				}
			}
			if (f_query_add_mod.document.forms[0].report_type.value=='D')
			{
				if( f_query_add_mod.doDateCheck( f_query_add_mod.document.Rep2MthYrlyBedUtilization.p_fm_date,f_query_add_mod.document.Rep2MthYrlyBedUtilization.p_to_date,messageFrame ))
				{
				f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
				f_query_add_mod.document.forms[0].target="messageFrame";	
				f_query_add_mod.document.Rep2MthYrlyBedUtilization.submit() ;
				}
			}
			if (f_query_add_mod.document.forms[0].report_type.value=='Y')
			{
				var names1 = new Array (getLabel('Common.year.label','common'));
				if( f_query_add_mod.CheckString(names1, f_query_add_mod.document.Rep2MthYrlyBedUtilization.p_fm_date,f_query_add_mod.document.Rep2MthYrlyBedUtilization.p_to_date,messageFrame ))
				{
				f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
				f_query_add_mod.document.forms[0].target="messageFrame";	
				f_query_add_mod.document.Rep2MthYrlyBedUtilization.submit() ;
				}
			}
		}
	}
 }
}
function reset()
{
	f_query_add_mod.location.reload();
}
</script>
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %> frameborder='0' scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe scrolling="no" name='f_query_add_mod' id='f_query_add_mod' src='../jsp/Rep2MthYrlyAdmbyReferral.jsp'  frameborder=0 style='height:80vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:40%;width:100vw'></iframe>
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

