<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.iba.framework.core.util.Constants"%>
<%@ include file="/framework/html/Tag.text"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<ibaHTML:html>
<head>
<%
			
      	String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? "IeStyle.css"
			: (String) session.getAttribute("PREFERRED_STYLE");
		
			String locale = (String)session.getValue("LOCALE");
			locale = (locale == null || locale.equals(""))?"en":locale;
			session.setAttribute(org.apache.struts.Globals.LOCALE_KEY,new java.util.Locale(locale,""));
%>
<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>' />	<script type="text/javascript" src="<%=request.getContextPath()%>/core/lookup/js/Lookup.js"></script>	
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/hashtable.js"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/DynaLookup.js'></script>
	
	<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/validations.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/common.js"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/ReceiveLinen.js'></script>
	<Script Language="JavaScript" src="<%=request.getContextPath()%>/eLC/ReceiveLinenAtLaundry/js/ReceiveLinenAtLaundry1.js">
	</Script>
	

</head>
<ibaTiles:insert definition="masterlayout"></ibaTiles:insert>
<body onload="create();">
</ibaHTML:html>

