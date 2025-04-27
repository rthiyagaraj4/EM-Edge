<!DOCTYPE html>

<%@page import="java.sql.*,webbeans.eCommon.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	java.util.Properties property = (java.util.Properties) session.getAttribute( "jdbc" ) ;
	String locale = (String) property.getProperty("LOCALE");
//	String qryString = request.getQueryString();
	String curr_sys_date			= "";
	String to_date			= "";
	String from_date				= "";	
	curr_sys_date = com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
    from_date = com.ehis.util.DateUtils.minusDate(curr_sys_date,"DMY",locale,30,"d");
    to_date = com.ehis.util.DateUtils.plusDate(curr_sys_date,"DMY",locale,0,"d");
%>
<head>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
        <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<title></title>

</head>
<iframe name="QryTempDataMainFrm" id="QryTempDataMainFrm"  frameborder="0" noresize scrolling='no' src="../../eCA/jsp/QueryTemplateDataFunctionCriteria1.jsp" style='height:5vh;width:100vw'></iframe>
	<iframe name="QryTempDataCriteriaFrm" id="QryTempDataCriteriaFrm" frameborder="0"  noresize scrolling='no' src="../../eCA/jsp/blank.jsp" style='height:100vh;width:100vw'></iframe>
	<iframe name="QryTempDataResultFrm" id="QryTempDataResultFrm" frameborder="0"  noresize scrolling='no' src="../../eCA/jsp/blank.jsp" style='height:100vh;width:100vw'></iframe>

</html>

