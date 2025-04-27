<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<title><fmt:message key="eOR.PrivilegeExceptionHead.label" bundle="${or_labels}"/></title>

<%
	
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../js/OrCommon.js"></script>
<script language="JavaScript" src="../js/PrivilegeExceptionGrp.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String function_id	=	request.getParameter("function_id");
	String mode = request.getParameter("mode");
	String exception_type = "", oc_select = "", ot_select = "", or_select = "" , disabled="";
	if(mode==null)mode="1";
	if(mode.equals("2")){
		exception_type = request.getParameter("exception_type");
		disabled = "disabled";	
		exception_type = exception_type.trim();
		if(exception_type.equals("OC"))
			oc_select = "selected";
		else if(exception_type.equals("OT"))
			ot_select = "selected";
		else if(exception_type.equals("OR"))
			or_select = "selected";
	}
	
	if(mode.equals("1")){
	%>
		<body onLoad="document.formPrivilegeExpGrpHdr.exception_type.focus()" onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
	<%
	}else if(mode.equals("2")){
	%>
		<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<%
	}
%>
<form name="formPrivilegeExpGrpHdr" id="formPrivilegeExpGrpHdr">
<table border="0" cellspacing="0" cellpadding="3" width="100%" height='100%' align="center">
<tr>
	<td class="label" width='27%' colspan='2'>
	<% /*Exception Type */ %> <fmt:message key="eOR.PrivilegeLevel.label" bundle="${or_labels}"/></td>
	<td class="fields"  colspan='3'><select name="exception_type" id="exception_type" onChange="loadDtlFrame(this);" <%=disabled%>><option value=""> ---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--- </option><option value="OC" <%=oc_select%>><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></option><option value="OT" <%=ot_select%>><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></option><option value="OR" <%=or_select%>><fmt:message key="Common.Orderable.label" bundle="${common_labels}"/></option></select><img src="../../eCommon/images/mandatory.gif" align=center></img></td>
</tr>
</table>
<input type="hidden" name="function_id" id="function_id" value="<%=function_id%>">
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
</form>
</body>
</html>

