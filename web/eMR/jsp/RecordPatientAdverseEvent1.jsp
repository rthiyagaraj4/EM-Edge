<!DOCTYPE html>
<%@ page language="java"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src="../../eCommon/js/messages.js"></script>
<script language='javascript' src="../../eMR/js/DaigConfirmation.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String url="../../eCommon/jsp/commonToolbar.jsp?";
	String params = request.getQueryString() ;
	String source = url + params ;
	String call_function=request.getParameter("function_id")==null?"":request.getParameter("function_id");

%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%=source%> frameborder='0' scrolling='no' noresize style='height:8%;width:100vw'></iframe>
	<iframe scrolling="no" name='f_query_add_mod' id='f_query_add_mod' src='../../eMR/jsp/RecordAdverseEventCriteria.jsp?&call_function=<%=call_function%>' noresize frameborder=0 style='height:5%;width:100vw'></iframe><iframe scrolling="auto" name='resultFrame' id='resultFrame' src='../../eCommon/html/blank.html'  noresize frameborder=0 style='height:100vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:5%;width:100vw'></iframe>
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

