<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/framework/html/Tag.text"%>
<%@ page import="com.iba.ehis.core.vo.AppVO"%>
<%@ page import="com.iba.framework.core.util.Constants"%>
<%@ page import="com.iba.framework.cache.pojo.business.CacheManager"%>

<%
String flag = " ";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<ibaHTML:html>
<head>

	<title>MessageFrame</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<link rel='stylesheet' type='text/css'
			href='/eHIS-DS/core/css/IeStyle.css'></link>
</head>
<body class='CONTENT'>
	<ibaBean:message key="com.iba.ehis.ds.core.resources.header1"
		bundle="dsMesages" />
	<ul>
		<ibaHTML:messages message="true" id="message">
			<li>
				<ibaBean:message name="com.iba.ehis.ds.core.resources.value1"
					bundle="dsMesages" />
			</li>
		</ibaHTML:messages>
	</ul>
</body>
</ibaHTML:html>
