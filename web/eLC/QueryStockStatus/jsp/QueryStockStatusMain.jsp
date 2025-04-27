<!DOCTYPE html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="com.iba.framework.core.util.Constants" %>
<%@ include file="/framework/html/Tag.text"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<ibaHTML:html>
<head>    
	<%
		String locale = (String)session.getValue("LOCALE");
		locale = (locale == null || locale.equals(""))?"en":locale;
		session.setAttribute(org.apache.struts.Globals.LOCALE_KEY,new java.util.Locale(locale,""));
		String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE")
			:"IeStyle.css" ;
			if(sStyle==null)sStyle="IeStyle.css";
	%>
<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>' />		
<Script language="JavaScript" src="<%=request.getContextPath()%>/eLC/QueryStockStatus/js/QueryStockStatus.js">
		</Script> 
</head>
<ibaTiles:insert definition="masterlayout"></ibaTiles:insert>
<body onload="create();">
</ibaHTML:html>

