<!DOCTYPE html>
<% 
/*
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History		Name					Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
22/01/2018	IN063931		Prakash C	23/01/2018		Ramesh		KDAH-CRF-0431(Copy previous section)	
------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<title>Recording Previous Section Search</title>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<iframe name="RecPreviousSectionSrchCriteriaFrame" id="RecPreviousSectionSrchCriteriaFrame" frameborder="no" scrolling="no" noresize src="../../eCA/jsp/RecPreviousSectionSrchCriteria.jsp?<%=request.getQueryString()%>" style="height:8%;width:100vw"></iframe>
	<iframe name="RecPreviousSectionSrchResultsFrame" id="RecPreviousSectionSrchResultsFrame" frameborder="no" scrolling="no" noresize src="../../eCommon/html/blank.html" style="height:36%;width:100vw"></iframe>
	<iframe name="RecPreviousSectionSelsectedResultDtlFrame" id="RecPreviousSectionSelsectedResultDtlFrame" frameborder="no" scrolling="auto" noresize src="../../eCommon/html/blank.html" style="height:48%;width:100vw"></iframe>
	<iframe name="RecPreviousSectionToolbarFrame" id="RecPreviousSectionToolbarFrame" frameborder="no" scrolling="no" noresize src="../../eCA/jsp/RecPreviousSectionToolbar.jsp" style="height:8%;width:100vw"></iframe>


</html>

