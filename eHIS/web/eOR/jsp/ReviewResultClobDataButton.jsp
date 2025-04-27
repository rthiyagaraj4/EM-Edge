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
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created	
27/06/2013	  IN041228		Ramesh G	 Review Results->Click on Result Hyperlink->Click on any Lab results->HTML tags displayed in Result
---------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*,java.io.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle =

		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
	<body  onKeyDown="lockKey()">
	<form>
		<table align='right'><tr><td align='right'><INPUT TYPE="button"  class="button" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick='window.close()'>
</td></tr></table>
	</form>
	</body>
</html>

