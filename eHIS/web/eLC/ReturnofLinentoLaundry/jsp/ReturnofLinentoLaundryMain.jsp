<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/framework/html/Tag.text"%>
<%@ page  import="com.iba.framework.core.util.Constants"%>
<ibaHTML:html>
<head>
<%
			String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? "IeStyle.css"
			: (String) session.getAttribute("PREFERRED_STYLE");
		
%>
<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>' />
<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/hashtable.js"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
	
		<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/RequestForCleaning.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/LinenIssue.js'></script>
	<Script language="JavaScript" src="<%=request.getContextPath()%>/eLC/ReturnofLinentoLaundry/js/ReturnofLinentoLaundry.js"></Script>
	
</head>
<ibaTiles:insert definition="masterlayout"></ibaTiles:insert>
<body onload="create();">

</ibaHTML:html>

