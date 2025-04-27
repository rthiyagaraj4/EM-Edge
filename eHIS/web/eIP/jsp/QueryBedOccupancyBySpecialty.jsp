<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8"); %>

<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<title><fmt:message key="eIP.BedOccupancybySpecialty.label" bundle="${ip_labels}"/></title>
	<script>
		function reset()
		{
			frames[1].location.reload();
			frames[2].location.href='../../eCommon/html/blank.html';
			//added on 20-10-2003 by dhanasekaran
			//frames[1].document.forms[0].search.disabled=false;
		}
	</script>
</head>
<%
		String url="../../eCommon/jsp/commonToolbar.jsp?";
		String params = request.getQueryString() ;
		String source = url + params ;
		String param=request.getParameter("param");
		if(param == null) param="";
%>

 	<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src="<%= source %>" frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
		<iframe src="../../eIP/jsp/QueryBedOccupancyCriteria.jsp" name="criteria" id="criteria" frameborder=0 scrolling='no' noresize style='height:13vh;width:100vw'></iframe>
		<iframe src="../../eCommon/html/blank.html" name="result" id="result" frameborder=0 scrolling='auto' noresize style='height:67vh;width:100vw'></iframe>
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

