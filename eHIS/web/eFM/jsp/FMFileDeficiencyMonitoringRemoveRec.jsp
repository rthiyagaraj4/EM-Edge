<!DOCTYPE html>
<%@ page import ="java.util.*,java.sql.*, java.text.*,webbeans.eCommon.*, webbeans.eFM.FileDeficiencyMonitoring" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="recordSetDeficiency" scope="session" class="webbeans.eFM.FileDeficiencyMonitoring"/>

<html>
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	
	%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body OnMouseDown='CodeArrest()' class='message' onKeyDown = 'lockKey();'>
<form name='DeficiencyMonitoringRemove_form' id='DeficiencyMonitoringRemove_form'>
<%
	int index = Integer.parseInt(request.getParameter("Indval"));

	recordSetDeficiency.removeObject(index);
%>
</form>
<script> 
	parent.frames[3].location.reload(); 
</script> 
</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString == "") ||(inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

