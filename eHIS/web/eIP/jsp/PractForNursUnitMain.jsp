<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");  %>
<html>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	request.setCharacterEncoding("UTF-8");
	//String url    = "../../eCommon/jsp/MstCodeToolbar.jsp?"; 
	//String params = request.getQueryString() ;
	//String source = url + params ;
	String function_id = request.getParameter("function_id");
%>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../js/NursUnitPract.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
		<iframe name='HeaderFrame' id='HeaderFrame' src='../jsp/PractForNursUnitHeader.jsp?function_id=<%=function_id%>' frameborder=0 scrolling='no' noresize style='height:5vh;width:100vw'></iframe>
		<iframe name='NurUtPractQueryFrame' id='NurUtPractQueryFrame'  src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize style='height:28vh;width:100vw'></iframe>
		<iframe name='NurUtPractResultFrame' id='NurUtPractResultFrame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:68vh;width:100vw'></iframe>
		<iframe name='Dummy' id='Dummy' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize style='height:0vh;width:100vw'></iframe>
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

