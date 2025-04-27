<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
 <%
    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../js/DefineHeader.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	String mode			= "";
	String status		= "";
	String header_id	= "";
	String long_desc	= "";
	String short_desc	= "";
	String eff_status	= "";
	String header_type	= "";

	mode = request.getParameter("mode") == null ? "insert" : request.getParameter("mode");
	header_id = request.getParameter("header_id") == null ? "" : request.getParameter("header_id");
	long_desc = request.getParameter("long_desc") == null ? "" : request.getParameter("long_desc");
	short_desc = request.getParameter("short_desc") == null ? "" : request.getParameter("short_desc");
	eff_status = request.getParameter("eff_status") == null ? "D" : request.getParameter("eff_status");
	header_type = request.getParameter("header_type") == null ? "" : request.getParameter("header_type");

%>
</head>
<body  class='CONTENT' OnMouseDown="CodeArrest()" onload='FocusFirstElement()' onKeyDown="lockKey()">
<form name="NoteHeader_form" id="NoteHeader_form" action="" method="post" target="messageFrame">
<br><br>
<table border=0 cellspacing=0 cellpadding='3' width='75%' align='center'>
<tr>
	<td class=label ><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
	<%if(mode.trim().equalsIgnoreCase("update")) {status="disabled" ;}else{status="";}%>
	<td colspan="2" class='fields' ><input type="text" name="header_id" id="header_id" value="<%=header_id%>" <%=status%>
	size=4 maxlength=4 onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this)" ><img src='../../eCommon/images/mandatory.gif'></td>
</tr>

<tr>
	<td class=label><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
	<td colspan="2" class='fields'><input type='text' name='long_desc' id='long_desc' value='<%=long_desc%>' size='40' maxlength='40'  onBlur="makeValidString(this)" onkeypress='return CheckForSpecCharsNoCaps(event)'><img src='../../eCommon/images/mandatory.gif'></td>
</tr>
<tr>
	<td width='40%' class='label' ><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
	<td width='60%' class='fields'><INPUT TYPE='text' name='short_desc' id='short_desc' size='30' value='<%=short_desc%>' maxlength ='30'><img SRC='../../eCommon/images/mandatory.gif'></td>
</tr> 
<tr>
	<%if(mode.trim().equalsIgnoreCase("update")) {status="disabled" ;}else{status="";}%>
	<td class=label ><fmt:message key="eCA.HeaderType.label" bundle="${ca_labels}"/></td>
	<td class='fields' colspan="2"><select name='header_type' id='header_type' onchange='clearInfo(this)'>
		<option value = '' >------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
		<option value = 'NH' <%if(header_type!=null && header_type.equals("NH")) { %> selected <% } %>><fmt:message key="eCA.NoteHeader.label" bundle="${ca_labels}"/></option> 
		<option value = 'RH' <%if(header_type!=null && header_type.equals("RH")) { %> selected <% } %>><fmt:message key="eCA.ReportHeader.label" bundle="${ca_labels}"/></option>
	</td>
</tr>
<tr>
	<td class=label ><fmt:message key="eCA.DefineHeader.label" bundle="${ca_labels}"/></td>
	<td colspan="2" class='fields'><input type="button" class="button" name="header" id="header" value="E" id='header' onClick="openNoteHeaderEditor(document.NoteHeader_form.header_type)" disabled></td>
</tr>
<tr>
	<td class=label ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
	<td colspan="2" class='fields'><input type="checkbox" name="eff_status" id="eff_status" value="E"></td>
</tr>

<input type=hidden name="mode" id="mode" value="<%=mode%>">
<input type=hidden name="html_format" id="html_format" value="">

</form>

</body>
</html>

