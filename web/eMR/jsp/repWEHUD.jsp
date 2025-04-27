<!DOCTYPE html>
<%
/**
MODULE			:	Medical Records..(MR)
Function Name	:	WEHU - D1 / D2
Developer		:	SRIDHAR R
Created On		:	11 JAN 2005
**/
%>
<%@ page contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>

<script src="../../eMR/js/MRReports.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function reset() 
{
	f_query_add_mod.document.search_form.reset();
	f_query_add_mod.document.search_form.clear.onclick();
	f_query_add_mod.document.search_form.alt_id1_exp_date.value = f_query_add_mod.document.search_form.SystemDate.value;
	f_query_add_mod.document.search_form.alt_id2_exp_date.value = f_query_add_mod.document.search_form.SystemDate.value;
}
</script>

</head>
<%
	request.setCharacterEncoding("UTF-8");
	String url="../../eCommon/jsp/commonToolbar.jsp?";
	String params = request.getQueryString() ;
	String source = url + params ;
	String call_function=request.getParameter("function_id")==null?"":request.getParameter("function_id");
%>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%=source%> frameborder='0' scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
		<iframe scrolling="no" name='f_query_add_mod' id='f_query_add_mod' src='../../eMR/jsp/repWEHUADRequestCriteria.jsp?call_function=<%=call_function%>' noresize frameborder=0 style='height:200%;width:100vw'></iframe><iframe scrolling="auto" name='content' id='content' src='../../eCommon/html/blank.html'  noresize frameborder=0 style='height:100vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:50%;width:100vw'></iframe>
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

