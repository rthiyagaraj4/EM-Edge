<!DOCTYPE html>

<%@page import="java.sql.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
//	java.util.Properties property = (java.util.Properties) session.getAttribute( "jdbc" ) ;
%>
<head>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
        <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<title></title>

</head>
<iframe name="QryTempDataResultCriteriaBtnFrm" id="QryTempDataResultCriteriaBtnFrm" frameborder="0"  noresize scrolling='auto' src="../../eCA/jsp/QueryTemplateDataFunctionCriteriaButton1.jsp?<%=request.getQueryString()%>" style='height:4vh;width:100vw'></iframe>
	<iframe name="QryTempDataResultFrm" id="QryTempDataResultFrm" frameborder="1"  noresize scrolling='auto' src="../../eCA/jsp/QueryTemplateDataFunctionResult.jsp?<%=request.getQueryString()%>" style='height:82vh;width:100vw'></iframe>
	<iframe name="QryTempDataResultBtnFrm" id="QryTempDataResultBtnFrm" frameborder="0"  noresize scrolling='no' src="../../eCA/jsp/blank.jsp?" style='height:4vh;width:100vw'></iframe>

</html>

