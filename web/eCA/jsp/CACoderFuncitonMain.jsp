<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		          Rev.Date		 Rev.Name		        Description
--------------------------------------------------------------------------------------------------------------
03/08/2020	IN073540		chandrashekar raju											AAKH-CRF-0122.1

---------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*,webbeans.eCommon.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	java.util.Properties property = (java.util.Properties) session.getAttribute( "jdbc" ) ;
	String locale = (String) property.getProperty("LOCALE");

	
%>
<head>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
        <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script> 
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<title></title>
</head>
<iframe name="coderSearchCriteriaFrame" id="coderSearchCriteriaFrame"   noresize scrolling='no' src="../../eCA/jsp/CACoderFunctionSearchCriteria.jsp" style='height:20%;width:100vw'></iframe>
	<iframe name="coderSearchResultFrame" id="coderSearchResultFrame"   noresize scrolling='auto' src="../../eCommon/html/blank.html" style='height:*%;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0  style='height:0%;width:100vw'></iframe>>

</html>

