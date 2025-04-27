<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" import ="java.sql.*,webbeans.eCommon.*"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<jsp:useBean id="accessRightRecSet" class="webbeans.eCommon.RecordSet" scope="session"/> 

<%
	request.setCharacterEncoding("UTF-8");
    accessRightRecSet.clearAll();
%>
<html>
	<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
		<script language='javascript' src='../js/ICDCodeForTabList.js'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
			<script language='javascript' src='../js/ICDCodeForTabList.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
	<form name="parentForm" id="parentForm" action="">
		<iframe name='queryCriteria' id='queryCriteria' src="../../eMR/jsp/ICDCodeForTabListQueryCriteria.jsp"  frameborder=0 scrolling='no' style='height:30vh;width:100vw'></iframe>
		<iframe name='queryResult' id='queryResult' src="../../eCommon/html/blank.html" frameborder=0 noresize scrolling='auto' style='height:70vh;width:100vw'></iframe>
		<iframe name='dummyFrame' id='dummyFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:0%;width:100vw'></iframe>
		<input type="hidden" name="flag" id="flag" >
	</form>
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

