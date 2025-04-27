<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import="java.sql.*, java.util.*, java.text.*, java.net.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
request.setCharacterEncoding("UTF-8");  %> 
<html> 
<title><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></title>
<head>
	
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
	
</head>
<body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
	<form name='remarks' id='remarks'>
		<table border='0' cellpadding='0' cellspacing='0' width='100%' align='center' valign='top' >
		<%
			String reason=request.getParameter("remarks");
		%>
			<tr><td class=label><textarea cols=53 rows=6 readonly><%=reason%></textarea></td></tr>
			<tr><td class='white'>&nbsp;</td></tr>
			<tr><td class=white align='right'><input type=button class='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' onclick='parent.window.close();' name='close'></td></tr>   
		</table>
	</form>
</body>
</html>
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

