<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8"  import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></head>
<%
	request.setCharacterEncoding("UTF-8");
	String params = request.getQueryString() ;	
%>
<title><fmt:message key="Common.ContactDetails.label" bundle="${common_labels}"/></title>
<iframe name='f_query_add_mod' id='f_query_add_mod' 	src='../jsp/MedicalRequestorAddress.jsp?<%=params%>' frameborder=0 scrolling='no' noresize style='height:95vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0  scrolling='no' noresize style='height:5vh;width:100vw'></iframe>

</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	? "" : inputString;
	}

	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	? defaultValue : inputString;
	}
%>

