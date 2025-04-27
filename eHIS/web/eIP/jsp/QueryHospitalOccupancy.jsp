<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<title><fmt:message key="eIP.HospitalOccupancy.label" bundle="${ip_labels}"/></title>
	<script>
		function reset()
		{
			frames[1].document.forms[0].search.disabled=false;
			frames[1].location.reload();
			frames[2].location.href = '../../eCommon/html/blank.html';
		}
	</script>
</head>
<%
		request.setCharacterEncoding("UTF-8");
		String url="../../eCommon/jsp/commonToolbar.jsp?";
		String params = request.getQueryString() ;
		String source = url + params ;
		String param=request.getParameter("param");
		if(param == null) param="";
%>

 	<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src="<%= source %>" frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
		<iframe src="../../eIP/jsp/QueryHospitalOccupancyCriteria.jsp" name="criteria" id="criteria" frameborder=0 scrolling='no' noresize style='height:15vh;width:100vw'></iframe>
		<iframe src="../../eCommon/html/blank.html" name="result" id="result" frameborder=0 scrolling='auto' noresize style='height:65vh;width:100vw'></iframe>
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

