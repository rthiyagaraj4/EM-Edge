<!DOCTYPE html>
<%
/*
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
09/08/2017		IN058006	Prakash C		09/08/2017		Ramesh G		ML-MMOH-CRF-0461
------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="eCA.ChartMain.label" bundle="${ca_labels}"/></title>
		<script src="../../eCA/js/SplChartGroups.js" language='javascript'></script> 
		<script src="../../eCommon/js/common.js" language='javascript'></script> 
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?";
	String param = request.getQueryString();
	String source = url+param;
	%>
	<iframe name="commontoolbarFrame" id="commontoolbarFrame" src='<%=source%>' frameborder=0 noresize scrolling='no' style='height:6vh;width:100vw'></iframe>
		<iframe name='SplChartGroupsMain' id='SplChartGroupsMain' src='../../eCA/jsp/SplChartGroupsComp.jsp' scrolling='no' frameborder=0 noresize style='height:84vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' scrolling='auto' frameborder=0 style='height:10vh;width:100vw'></iframe>		
	
</html>

