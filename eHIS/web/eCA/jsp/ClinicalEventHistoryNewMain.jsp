<!DOCTYPE html>
<% 
/*
---------------------------------------------------------------------------------------------
Date       	Edit History   	Name        		Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------
07/01/2019	IN069243	sivabagyam M 	07/01/2019		Ramesh G		MO-CRF-20101.2
---------------------------------------------------------------------------------------------
*/
%>
<%@ page contentType="text/html;charset=UTF-8"  import="java.sql.*,java.net.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<TITLE></TITLE>
<head>
<SCRIPT src="../../eCommon/js/common.js"			language="javascript"></SCRIPT>
<SCRIPT src="../../eCommon/js/ValidateControl.js" language="javascript"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<body marginwidth="1" marginheight="1" style="border: 2px solid;border-color: black;">
	<iframe src="../../eCA/jsp/ClinicalEventHistoryCriteriaNew.jsp?<%=request.getQueryString()%>" name="ClinicalEventHistoryCriteriaFrame"  scrolling="no" frameborder="0" noresize style="height:8vh;width:99vw"></iframe>
	<iframe src="../../eCommon/html/blank.html" name="ClinicialEventHistoryDetailsFrame" id="ClinicialEventHistoryDetailsFrame"  scrolling="yes" frameborder="1" noresize style="height:88vh;width:99vw"></iframe>
	<iframe src="../../eCommon/jsp/error.jsp" name="messageFrame" id="messageFrame"  scrolling="yes" frameborder="0" noresize style="height:0vh;width:99vw;display:none;"></iframe>
	<iframe src="../../eCommon/html/blank.html" name="addToGroupsFrame" id="addToGroupsFrame"  scrolling="no" frameborder="0" noresize style="height:0vh;width:99vw;display:none;"></iframe>

</body>

</html>

