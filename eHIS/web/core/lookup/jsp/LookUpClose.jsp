<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@ page import="com.iba.framework.core.util.Constants" %>
<%@ include file="/framework/html/Tag.text"%>

<ibaHTML:html locale="true">
<head>
	<%String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
				.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE")
				:"IeStyle.css" ;
				if(sStyle==null)sStyle="IeStyle.css";

			%>
	<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>'></link>
</head>
<body>
	<p align="right">
				<input type="button" name="close" id="close" value="Close" class="button" onclick="top.close();"/>
</p>
</body>
</ibaHTML:html>

