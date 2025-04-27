<!DOCTYPE html>
<%--Author  Archna Kumari Dhal Created on 4/3/2009 --%>
<%@page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>

	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		
		
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script language="javascript" src="../js/MedRecAdminAlert.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<iframe name="MedRecAdminAlertTreeFrame" id="MedRecAdminAlertTreeFrame" src="../../eCA/jsp/MedRecAdminAlertTree.jsp?<%=request.getQueryString()%>"  frameborder=0 scrolling=no noresize></iframe>
	<iframe name="MedRecAdminAlertResultFrame" id="MedRecAdminAlertResultFrame" src="../../eCA/jsp/MedRecAdminAlertResult.jsp?<%=request.getQueryString()%>"  frameborder=0 scrolling=no noresize></iframe>

</html>

