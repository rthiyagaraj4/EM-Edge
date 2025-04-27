<!DOCTYPE html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/framework/html/Tag.text"%>
<%@ page import="com.iba.framework.core.util.Constants"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<ibaHTML:html>
<head>
		<Script language ="JavaScript" src ='<%=request.getContextPath()%>/core/lookup/js/Lookup.js'></Script>  
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/MessageReader.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwrds/interface/function.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/IBADateValidator.js'></script>
		<Script Language="JavaScript" src="<%=request.getContextPath()%>/framework/js/common.js"></Script>
		<Script Language="JavaScript" src="<%=request.getContextPath()%>/framework/js/validations.js"></Script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
		<Script language ="JavaScript" src ='<%=request.getContextPath()%>/core/lookup/js/Lookup.js'></Script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/DynaLookup.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
		<Script language="JavaScript" src="<%=request.getContextPath()%>/eLC/RepWrittenoffLinen/js/WrittenoffLinen.js"></Script>
	<%
		String locale = (String)session.getValue("LOCALE");
		locale = (locale == null || locale.equals(""))?"en":locale;
		//java.util.Locale loc = new java.util.Locale(locale);
		session.setAttribute(org.apache.struts.Globals.LOCALE_KEY,new java.util.Locale(locale,""));

		//out.println(request.getLocale());
	%>
	
</head>
<ibaTiles:insert definition="masterlayout"></ibaTiles:insert>
<body>
	<script>
			content.location.href=contextPath+"/RepWrittenoffLinenAction.do?method="+loadMethod;	
	</script>
</body>
</ibaHTML:html>

