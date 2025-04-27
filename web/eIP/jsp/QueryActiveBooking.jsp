<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8"); %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<title><fmt:message key="eIP.ActiveBooking.label" bundle="${ip_labels}"/></title>
	<script>
		function reset()
		{
			frames[1].document.forms[0].reset();
			frames[2].location.href = '../../eCommon/html/blank.html';
			frames[1].document.forms[0].search.disabled=false;
		}
	</script>
</head>
<%
		String url="../../eCommon/jsp/commonToolbar.jsp?";
		String params = request.getQueryString() ;
		String source = url + params ;
		String param=request.getParameter("param");
		if(param == null) param="";
		String function_id=request.getParameter("function_id");
		if(function_id == null) function_id="";
%>

	<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='criteria' id='criteria' src='../jsp/BookingReferenceLookupCriteria.jsp?function_id=<%=function_id%>&param=<%=param%>&call_function=AB'  frameborder=0 scrolling='no' style='height:48vh;width:100vw'></iframe>
	<iframe name='result' id='result' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:36vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>
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

