<!DOCTYPE html>
<%@ page import="java.sql.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
    request.setCharacterEncoding("UTF-8");	
	String p_module_id		= "CA" ;
	String p_report_id		= "CABNOTYP" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
//	Properties p = (Properties)session.getValue("jdbc");
//	String locale	= (String) p.getProperty("LOCALE");

%>
<html>
<HEAD>
<TITLE></TITLE>

<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src='../../eCA/js/repResetRunList.js' language='javascript'></script> 
<script language='javascript' src='../../eCommon/js/CommonLookup.js' > </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<BODY class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()' onload='FocusFirstElement()'>
<br>
<br>
<form name="repNoteType" id="repNoteType" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>

		<th align='left'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>

	<tr>

		<td width="100%" class="Border" align='center'>

				<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >

					<tr>
						<td align="center" width="35%">&nbsp;</td>
						<td class="label" width="20%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
						<td align='left' width='10%' >&nbsp;
						</td>
						<td class="label" width="40%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					</tr>

					<tr>
						<td align='left' width='30%' class="label"><fmt:message key="Common.NoteType.label" bundle="${common_labels}"/>&nbsp;</td>
						<td width='20%'  ><input type=text  name='p_fr_note_type1' id='p_fr_note_type1'  onblur='search_Codefornotetype(this, p_fr_note_type1)' size="15" maxlength="25" align="center"><input type='hidden'  name='p_fr_note_type' id='p_fr_note_type' value=''><input type='button' name='locn' id='locn' value='?' class='button' onclick='search_Codefornotetype(this, p_fr_note_type1)'>
						</td>
						<td align='left' width='10%' >&nbsp;
						</td>
						<td width='40%'><input type=text  name='p_to_note_type1' id='p_to_note_type1' size="15" maxlength="25" align="center" onblur='search_Codefornotetype(this, p_to_note_type1)'><input type='hidden'  name='p_to_note_type' id='p_to_note_type' value=''><input type='button' name='locn1' id='locn1' value='?' class='button' onclick='search_Codefornotetype(this, p_to_note_type1)'>
						</td>
				</tr>

				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>


				<tr>
					<td align='left' width='30%' class="label"><fmt:message key="Common.Nature.label" bundle="${common_labels}"/> &nbsp;</td>
					<td  width='20%' align="left">
						<select name='p_nature' id='p_nature'>
						<option value="B"><fmt:message key="Common.Both.label" bundle="${common_labels}"/> 
						<option value="E"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/> 
						<option value="D"><fmt:message key="Common.Disabled.label" bundle="${common_labels}"/> 
						</select>
					</td>
				</tr>

<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
				<tr>
					<td align='left' width='30%' class="label">
						<fmt:message key="Common.orderBy.label" bundle="${common_labels}"/> &nbsp;
					</td>
					<td  width='20%' align="left">
						<select name='p_order_by' id='p_order_by'>
						<option value='1'><fmt:message key="Common.code.label" bundle="${common_labels}"/>
						<option value='2'><fmt:message key="Common.description.label" bundle="${common_labels}"/>
						</select>
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
		</table>
	</td>
</tr>
</table>
<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
<input type="hidden" name="p_user_name" id="p_user_name"		value="<%= p_user_name %>">
</form>
</BODY>
</HTML>

