<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<TITLE> <fmt:message key="Common.CancelTransfer.label" bundle="${common_labels}"/> </TITLE>

	
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eIP/js/IPCancelTransfer.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	request.setCharacterEncoding("UTF-8");
    String params = request.getQueryString() ;
%>
</head>
				
	<iframe name='searchCriteria' id='searchCriteria' src='../../eIP/jsp/IPCancelTrfDialog.jsp?<%=params%>' frameborder=0  scrolling='auto' style='height:80vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>
</html>

