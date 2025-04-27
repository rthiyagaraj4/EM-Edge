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
	<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>'></link>
	<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/RequestForCleaning.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/LinenIssue.js'></script>
	<script type="text/javascript" src='<%=request.getContextPath()%>/eLC/ReceiveLoanedLinen/js/ReceiveLoanedLinen.js'>
	</script>

</head>
<ibaTiles:insert definition="masterlayout"></ibaTiles:insert>
<body>

</ibaHTML:html>

