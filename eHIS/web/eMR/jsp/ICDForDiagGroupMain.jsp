<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" import ="webbeans.eCommon.*"%>
<jsp:useBean id="icdforDiagGroup" class="webbeans.eCommon.RecordSet" scope="session"/>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	request.setCharacterEncoding("UTF-8");
    icdforDiagGroup.clearAll();
%>
<html>
	<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
		<script language='javascript' src='../js/ICDForDiagGroup.js'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<iframe name='queryCriteria' id='queryCriteria' src="../../eMR/jsp/ICDForDiagGroupCriteria.jsp"  frameborder=0 scrolling='no' style='height:32%;width:100vw'></iframe><iframe name='queryResult' id='queryResult' src="../../eCommon/html/blank.html" frameborder=0 noresize scrolling='no' style='height:100vh;width:100vw'></iframe>
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

