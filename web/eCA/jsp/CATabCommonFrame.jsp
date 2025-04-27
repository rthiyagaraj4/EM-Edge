<!DOCTYPE html>
<%
/*
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
*/
/* 
------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History      		Name        		Rev.Date				Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------------------------------
25/01/2019		IN057997			Kamalakannan G	  		25/01/2019				Ramesh G.		AAKH-CRF-0079
------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>

<%@page contentType="text/html;charset=UTF-8" import="java.util.*, eCA.*, eCA.Common.*, eCommon.Common.*,java.text.DecimalFormat,java.sql.*,webbeans.eCommon.*" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<title><fmt:message key="eCA.InsuranceAuthorizationForm.label" bundle="${ca_labels}"/></title>
	<head>
	<%
		request.setCharacterEncoding("UTF-8");
	 %>
		<iframe name="frame0" id="frame0" frameborder="0" scrolling="no" noresize src="eCA/jsp/CATabInsuranceAuthorizationFormMain.jsp" style="height:100vh;width:100vw"></iframe>		
</html>

