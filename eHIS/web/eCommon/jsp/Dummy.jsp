<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.io.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
			request.setCharacterEncoding("UTF-8");
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<head>
    <Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
    <Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>


<script language="JavaScript">

</script>

</head>

<BODY CLASS="MESSAGE" onKeyDown = 'lockKey()'>

<p align="left">
</p>
</BODY>

