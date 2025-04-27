<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
	request.setCharacterEncoding("UTF-8");
	
	
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
<title><fmt:message key="Common.ContactDetails.label" bundle="${common_labels}"/></title>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<iframe name='ContactFrame' id='ContactFrame' src="../../eMP/jsp/CommonContactDtls.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no' noresize style='height:86vh;width:100vw'></iframe>
	<iframe name='MessageFrame' id='MessageFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:5vh;width:100vw'></iframe>
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

