<!DOCTYPE html>
<%
/* 
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
11/06/2015     		1   		Sethuraman      Created
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<script language='javascript' src='../js/DocMgmtConfig.js'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
</head>
<%
	
	String mode = (request.getParameter("mode")==null)?"":request.getParameter("mode");

	String sFacilityId = (request.getParameter("facilityId")==null)?"":request.getParameter("facilityId");	

	String source = "../../eMP/jsp/DocMgmtConfigHeader.jsp?mode="+mode+"&facilityId="+sFacilityId;


%>
<iframe name="HeaderFrame" id="HeaderFrame" src=<%=source%> frameborder=0  noresize style="height:10vh;width:100vw"></iframe>
		<iframe name="DetailsFrame" id="DetailsFrame" src="../../eCommon/html/blank.html" frameborder=0  noresize style="height:90vh;width:100vw"></iframe>

<html>

