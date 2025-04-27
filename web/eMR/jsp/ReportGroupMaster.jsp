<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %> 

<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>
	<script language='javascript' src='../js/MRMaster.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<%
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String func = request.getParameter("function_id");
		String source = url + params ;
%>

<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' 	src='../../eCommon/html/blank.html' frameborder=0 style='height:81vh;width:100vw' ></iframe>
	<iframe name='blankFrame' id='blankFrame' 	src='../../eCommon/html/blank.html' frameborder=0 noresize style='height:0vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 scrolling='auto' noresize style='height:9vh;width:100vw'></iframe>

<script>
blankFrame.document.write("<HTML><head></head><body onKeyDown='lockKey()'><form name='tempForm' id='tempForm'><input type='text' name='func' id='func' value='<%=func%>'></form></body></HTML>");
</script>
</html>
<%!	
	private String checkForNull(String inputString){
		return (inputString==null)	?	""	:	inputString;
	}
	public static String checkForNull(String inputString, String defaultValue){
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

