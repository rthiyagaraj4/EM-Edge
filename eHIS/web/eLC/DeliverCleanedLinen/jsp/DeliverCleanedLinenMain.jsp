<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page  import="com.iba.framework.core.util.Constants"%>
<%@ include file="/framework/html/Tag.text"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<ibaHTML:html>
<head>
<%
			String facilityId=(String)session.getAttribute("facility_id");
			String functionId = (String) request.getParameter("functionId");
			String moduleId = (String) request.getParameter("moduleId");
			session.setAttribute("facilityId",facilityId);
			session.setAttribute("moduleId",moduleId);
			String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? "IeStyle.css"
			: (String) session.getAttribute("PREFERRED_STYLE");

			
			String locale = (String)session.getValue("LOCALE");
			locale = (locale == null || locale.equals(""))?"en":locale;
			//java.util.Locale loc = new java.util.Locale(locale);
			session.setAttribute(org.apache.struts.Globals.LOCALE_KEY,new java.util.Locale(locale,""));
		
%>
	<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>'></link>	<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/core/lookup/js/Lookup.js"></script>	
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/hashtable.js"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/DynaLookup.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/LinenRequest.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/validations.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/common.js"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/RequestForCleaning.js'></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/eLC/DeliverCleanedLinen/js/DeliverCleanedLinen.js"></script>
</head>
<ibaTiles:insert definition="masterlayout"></ibaTiles:insert>
<body onload="create();">
</ibaHTML:html>

