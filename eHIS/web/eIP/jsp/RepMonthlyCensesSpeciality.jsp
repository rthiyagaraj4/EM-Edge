<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");  %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	String module_id=request.getParameter("module_id");
	if(module_id.equals("IP"))
		{%>
		<script src='../../eIP/js/Rep2MasterList.js' language='javascript'></script>
		<%}
	else{%>
		<script src='../../eIP/js/Rep2MasterListAll.js' language='javascript'></script>
		<%}%>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js" language='JavaScript'></script>
<script src="../../eCommon/js/common.js" language='JavaScript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


    <iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %> frameborder='0' scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<%if(module_id.equals("IP"))
		{%>	
	<iframe scrolling="no" name='f_query_add_mod' id='f_query_add_mod' src='../../eIP/jsp/Rep2MonthlyCensesSpeciality.jsp'  frameborder=0 style='height:84vh;width:100vw'></iframe>
		<%}
	else
		{
		%>	
	<iframe scrolling="no" name='f_query_add_mod' id='f_query_add_mod' src='../../eIP/jsp/Rep2MonthlyCensesSpeciality_PD104B.jsp'  frameborder=0 style='height:84vh;width:100vw'></iframe>
		<%
		}
		%>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:8vh;width:100vw'></iframe>
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

