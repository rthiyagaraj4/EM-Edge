<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name				Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------------
19/03/2020 	IN070345  		Ramesh Goli											MO-CRF-20147.1
-------------------------------------------------------------------------------------------------------------------------------------
*/ 
%> 
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<script language='javascript' src='../js/DocMgmtConfig.js'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
</head>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String mode = (request.getParameter("mode")==null)?"":request.getParameter("mode");

	String sFacilityId = (request.getParameter("facilityId")==null)?"":request.getParameter("facilityId");	

%>
<iframe name="HeaderFrame" id="HeaderFrame" src="../../eCA/jsp/CADocMgmtConfigHeader.jsp?mode=<%=mode%>&facilityId=<%=sFacilityId%>" frameborder=0  noresize style="height:8vh;width:99vw"></iframe>
		<iframe name="DetailsFrame" id="DetailsFrame" src="../../eCommon/html/blank.html" frameborder=0  noresize style="height:85vh;width:99vw"></iframe>

<html>

