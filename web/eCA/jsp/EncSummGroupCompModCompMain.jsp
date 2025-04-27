<!DOCTYPE html>
<!--
Created By: D. Sethuraman
-->
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String queryString = request.getQueryString();			
%>
<html>
	<head>
		<title><fmt:message key="Common.ComponentDefinition.label" bundle="${common_labels}"/></title>		
		<script src='../../eCA/js/GlobalArray.js' language='javascript'></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>		
		<script language='javascript' src='../../eCA/js/EncSummGroupComp.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<iframe name='modCompCriteriaFrame' id='modCompCriteriaFrame' src='../../eCA/jsp/EncSummGroupCompModCompPage.jsp?<%=queryString%>' frameborder='0' scrolling='no' noresize style='height:100vh;width:100vw'></iframe>		
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' scrolling='no' frameborder=0 noresize style='height:0%;width:100vw'></iframe>
		
</html> 

