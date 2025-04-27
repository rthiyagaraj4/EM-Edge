<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
	String readonly = request.getParameter("readonly");
	if(readonly==null)	readonly="";

%>
<html>
<head>

	<title><fmt:message key="Common.ResultTemplate.label" bundle="${common_labels}"/></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
 	<script language="JavaScript" src="../js/ResultEntry.js"></script>

 	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body style='background-color:#E2E3F0;'  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<FORM name='result_entry_template_btn' id='result_entry_template_btn' METHOD=POST ACTION="">
<table cellpadding=3 cellspacing=0 border=0 align=center width='100%'>
<tr>
<tr>
	<td class='button'>
	<%if(readonly.equals("")){%>
		<INPUT TYPE="button" name="Select" id="Select" class="button" value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' onClick='addTemplateText()'>
		<INPUT TYPE="button" name="Ok" id="Ok" class="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick='saveResultData()'>
		<INPUT TYPE="button" name="Close" id="Close" class="button" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick='parent.window.close()'>
	<%}else{%>
		<INPUT TYPE="button" name="Close" id="Close" class="button" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick='parent.window.close()'>
	<%}%>
	</td>
</tr>
</table>
</FORM>
</BODY>
</HTML>

