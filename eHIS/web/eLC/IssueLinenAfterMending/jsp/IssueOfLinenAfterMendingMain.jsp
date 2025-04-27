<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page  import="com.iba.framework.core.util.Constants"%>
<%@ include file="/framework/html/Tag.text"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<ibaHTML:html>
<head>
<%			
			session.setAttribute("functionId",request.getParameter("function_id"));
			session.setAttribute("moduleId",request.getParameter("moduleId"));

			String loggedInUser = (String) session.getAttribute("login_user");
			
			String locale = (String)session.getValue("LOCALE");
			locale = (locale == null || locale.equals(""))?"en":locale;
			//java.util.Locale loc = new java.util.Locale(locale);
			session.setAttribute(org.apache.struts.Globals.LOCALE_KEY,new java.util.Locale(locale,""));
%>
	
	<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/core/lookup/js/Lookup.js"></script>	
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/hashtable.js"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/DynaLookup.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/IBADateValidator.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/RequestForCleaning.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/validations.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/common.js"></script>
	</script>
	
	
</head>
<ibaTiles:insert definition="lclaundrymasterlayout"></ibaTiles:insert>
<body>
</ibaHTML:html>

