<!DOCTYPE html>
<% 
/*
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
27/07/2017		IN061891	Raja S		27/07/2017		Ramesh G		ML-MMOH-CRF-0543
------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%> 
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
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<title><fmt:message key="eCA.PersonalisePatList.label" bundle="${ca_labels}"/></title>
	</head>
	<iframe name='PatSearchCriteriaFr' id='PatSearchCriteriaFr' src='PersonalisePatListCriteria.jsp' noresize frameborder=0 SCROLLING='no'  style='height:6vh;width:100vw'></iframe>
		<iframe name='PatCriteriaFr' id='PatCriteriaFr' src='../../eCommon/html/blank.html' noresize frameborder=0 scrolling='auto' style='height:88vh;width:99vw'></iframe>
		<iframe name='PatToolbarFr' id='PatToolbarFr' src='PersonalisePatListToolbar.jsp' noresize  frameborder=0  marginheight=0 marginwidth=0 SCROLLING='no' class='normal' style='height:5%;width:100vw'></iframe>
	
</html>