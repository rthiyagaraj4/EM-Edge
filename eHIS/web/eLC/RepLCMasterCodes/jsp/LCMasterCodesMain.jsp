<!DOCTYPE html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/framework/html/Tag.text"%>
<%@ page import="com.iba.framework.core.util.Constants" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<ibaHTML:html>
<head>
		<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>	
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/DynaLookup.js'></script>
		<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>
		<Script language="JavaScript" src="<%=request.getContextPath()%>/eLC/RepLCMasterCodes/js/LinenMasterCodes.js"></Script>
		<%
			String locale = (String)session.getValue("LOCALE");
			locale = (locale == null || locale.equals(""))?"en":locale;
			session.setAttribute(org.apache.struts.Globals.LOCALE_KEY,new java.util.Locale(locale,""));
			String functionId = (String)request.getParameter("functionId");

		%>
</head>
<ibaTiles:insert definition="masterlayout"></ibaTiles:insert>
<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<script>
		 var Mode = "master";
			content.location.href = contextPath + "/RepLinenMasterCodesAction.do?method=" + loadMethod+"&mode="+Mode;
			</script>
</body>
</ibaHTML:html>

