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
		<title><fmt:message key="eCA.AvailableComponentList.label" bundle="${ca_labels}"/></title>		
		<script src='../../eCA/js/GlobalArray.js' language='javascript'></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
		
	</head>
	<iframe name='selectedCompFrame' id='selectedCompFrame' src='../../eCA/jsp/blank.jsp'  frameborder=0 style='height:62%;width:100vw'></iframe>
		<iframe name='addCompCriteriaFrame' id='addCompCriteriaFrame' src='../../eCA/jsp/EncSummGroupCompAddCompCriteria.jsp?<%=queryString%>' frameborder='0' scrolling='no' noresize style='height:8%;width:100vw'></iframe>
		<iframe name='addCompFrame' id='addCompFrame' src='../../eCA/jsp/blank.jsp' frameborder='0' scrolling='no' noresize style='height:100vh;width:100vw'></iframe>
		<iframe name='removeCompFrame' id='removeCompFrame' src='../../eCommon/html/blank.html' frameborder=0 style='height:0%;width:100vw'></iframe>
		<iframe name='BlankFrame' id='BlankFrame' src='../../eCommon/html/blank.html' frameborder=0 style='height:0%;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' scrolling='no' frameborder=0 noresize style='height:5%;width:100vw'></iframe>
		
</html> 

