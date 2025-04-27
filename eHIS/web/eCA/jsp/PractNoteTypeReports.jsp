<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
    request.setCharacterEncoding("UTF-8");
	String p_facility_id = (String)session.getValue("facility_id");
	String p_login_user  = (String)session.getValue("login_user");
	if(p_facility_id == null)p_facility_id="";
	if(p_login_user == null)p_login_user="";
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
%>
<html>
<head><title></title>
<%

String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src="../../eCommon/js/CommonLookup.js"></script>
<script src="../../eCA/js/PractNoteTypeReports.js"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
<form name='practNoteTypeReports' id='practNoteTypeReports' action="../../eCommon/jsp/report_options.jsp" target="messageFrame" >
<br><br><br><br>
<table align='center' cellpadding='0' cellspacing='0' width='90%' border='0'>
<th align='left' colspan='4'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
<tr><td colspan='4'>&nbsp;</td></tr>
<tr>
    <td class='label' align='right'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
    <td align='left' width='30%'>&nbsp;<input type='text' name='fm_pract1' id='fm_pract1' onblur='search_Code(this,fm_pract1)' size="30" maxlength="30" value=""><input type='hidden'  name='fm_pract' id='fm_pract' value=''><input type='button' name='fm_pract_src' id='fm_pract_src' class='button' value='?' onclick='search_Code(this,fm_pract1)'></td>
    <td class='label'><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
    <td align='left'>&nbsp;<input type='text' name='to_pract1' id='to_pract1' value="" size="30" maxlength="30" onblur='search_Code(this,to_pract1)'><input type='hidden'  name='to_pract' id='to_pract' value=''><input type='button' name='to_pract_src' id='to_pract_src' class='button' value='?' onclick='search_Code(this,to_pract1)'></td>
</tr>
<tr><td colspan='4'>&nbsp;</td></tr>
<tr>
    <td class='label' align='right'><fmt:message key="Common.NoteType.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
    <td align='left'>&nbsp;<input type='text' name='fm_noteType1' id='fm_noteType1' size="30" maxlength="30" onblur='search_Code(this,fm_noteType1)' value=""><input type='hidden'  name='fm_noteType' id='fm_noteType' value=''><input type='button' name='fm_noteType_src' id='fm_noteType_src' class='button' value='?' onclick='search_Code(this,fm_noteType1)'></td>
    <td class='label' align='right'><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
    <td align='left'>&nbsp;<input type='text' name='to_noteType1' id='to_noteType1' value="" size="30" maxlength="30"onblur='search_Code(this,to_noteType1)'><input type='hidden' name='locale' id='locale' value='<%=locale%>'><input type='hidden'  name='to_noteType' id='to_noteType' value=''><input type='button' name='to_noteType_src' id='to_noteType_src' class='button' value='?' onclick='search_Code(this,to_noteType1)'></td>
</tr>
<tr><td colspan='4'>&nbsp;</td></tr>
<tr>
	<td  class='label' align='right'><fmt:message key="Common.groupby.label" bundle="${common_labels}"/></td>
	<td class='fields'>&nbsp;<select name='p_grp_by' id='p_grp_by'><option value='PRACTITIONER_NAME'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option><option value='NOTE_TYPE_DESC'><fmt:message key="Common.NoteType.label" bundle="${common_labels}"/></option></select></td>
	<td colspan='4'>&nbsp;</td>
</tr>
<tr><td colspan='4'>&nbsp;</td></tr>
</table>

<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=p_facility_id%>">
<input type="hidden" name="p_user_name" id="p_user_name"		value="<%=p_login_user%>">
<input type="hidden" name="p_module_id" id="p_module_id" 	value="CA">
<input type="hidden" name="p_report_id" id="p_report_id" 	value="CAPRANOT">

</form>
</body>
</html>

