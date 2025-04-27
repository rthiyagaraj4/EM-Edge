<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/* 
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name        		Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
22/01/2018  	IN062606            Sharanraj         01/02/2018              Ramesh G        ML-MMOH-CRF-0726
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<script src='../js/MyRefToPerform.js' language='javascript'></script>
	<title>My Referral Not Seen</title>
	
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		Properties p = (Properties)session.getValue("jdbc");
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<iframe src="../../eCA/jsp/MyRefNotSeenCriteria.jsp?<%=request.getQueryString()%>"  name="MyRefNotSeenCriteriaFrame" border=0 scrolling=no noresize> 
	<iframe src="../../eCA/jsp/MyRefNotSeenDetails.jsp?<%=request.getQueryString()%>" name="MyRefNotSeenDetailsFrame" border=0 scrolling=auto noresize>
	<iframe name='MyRefResultFr' id='MyRefResultFr' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:15%;width:100vw'></iframe>

</html>

