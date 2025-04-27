<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,eCommon.XSSRequestWrapper" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html> 
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script language='javascript' src='../js/MarkEncounter.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js' ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String url="../../eCommon/jsp/commonToolbar.jsp?";
	String params = request.getQueryString() ;	
	String source = url + params ;
	

%>
</head>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
		<iframe name='f_query_add_mod' id='f_query_add_mod' 	src='../jsp/MedRecRequestCriteria.jsp?call_function=MARK_MLC_OSCC&function_id=MARK_MLC_OSCC' frameborder=0 scrolling='no' noresize style='height:39vh;width:100vw'></iframe>
		<iframe scrolling="auto" name='resultFrame' id='resultFrame' src='../../eCommon/html/blank.html'  noresize frameborder=0 style='height:42vh;width:100vw'></iframe>
		<!-- <iframe scrolling="no" name='f_select' id='f_select' src='../../eMR/jsp/MedRecRequestButton.jsp'  noresize frameborder=0> -->
		<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='no' noresize style='height:9vh;width:100vw'></iframe>
		<iframe name='errFrame' id='errFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:1vh;width:100vw'></iframe>
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

