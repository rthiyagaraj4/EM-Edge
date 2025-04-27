<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page  import="com.iba.framework.core.util.Constants"%>
<%@ include file="/framework/html/Tag.text"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<ibaHTML:html>
<head>
<%
			String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? "IeStyle.css"
			: (String) session.getAttribute("PREFERRED_STYLE");
			String function_id = (String)request.getParameter("function_id");
			request.setAttribute("function_id1",function_id);
			//String function_id2=(String)request.getAttribute("function_id1");
			//out.println("function_id::"+function_id2);
		
%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/hashtable.js"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/DynaLookup.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/validations.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/common.js'></script>
	<Script Language="JavaScript" src="<%=request.getContextPath()%>/eLC/WriteOffLinen/js/WriteOffLinen.js"></Script>
</head>
<ibaTiles:insert definition="masterlayout"></ibaTiles:insert>
<body onload="create();"> 
<input type="hidden" name="function_id" id="function_id" value="<%=function_id%>">
</body>
</ibaHTML:html>

