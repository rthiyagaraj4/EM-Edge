<!DOCTYPE html>
<%@ page language="java" import="java.util.*,com.iba.framework.core.vo.UserPreferences,com.iba.framework.cache.pojo.business.Cache,com.iba.framework.cache.pojo.business.CacheManager,com.iba.framework.core.util.Constants,com.iba.framework.core.util.IBADate" pageEncoding="ISO-8859-1"%>
<%@ include file="/framework/html/Tag.text"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<ibaHTML:html>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
<head>
<%
			String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? "IeStyle.css"
			: (String) session.getAttribute("PREFERRED_STYLE");
%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>
	<script type='text/javascript'
		src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
	<script type='text/javascript'
		src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
	<script type='text/javascript'
		src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/IBADateValidator.js'></script>
	<script type='text/javascript'
		src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
	<Script Language="JavaScript" src="<%=request.getContextPath()%>/framework/js/common.js"></Script>
<Script Language="JavaScript" src="<%=request.getContextPath()%>/framework/js/validations.js"></Script>
<Script Language="JavaScript" src="<%=request.getContextPath()%>/eLC/SetupParameter/js/SetupParameter.js"></Script>
</head>
<ibaTiles:insert definition="masterlayout"></ibaTiles:insert>
<body onload="create();">
</ibaHTML:html>

