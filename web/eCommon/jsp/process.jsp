
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	String locale = (String)session.getValue("LOCALE");
	locale = (locale == null || locale.equals(""))?"en":locale;
	java.util.Locale loc = new java.util.Locale(locale);

	java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);
%>

<html>
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>

<body onKeyDown = 'lockKey()' class="COMMON_TOOLBAR" text="navy">
<!--
<img src="/eCIS/common/images/busy.gif">&nbsp;&nbsp;&nbsp;
-->

<h3><%=common_labels.getString("Common.processing.label")%></h3>
</body>
</html>

