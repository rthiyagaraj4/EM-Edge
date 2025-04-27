<!DOCTYPE html>
<%@ page import="java.sql.*" %>
<%
	String p_module_id		= "MR" ;
	String p_report_id		= "QABDISCI" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
%>
<html>
<HEAD>
<%String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eQA/js/QAResetrunList.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY onMouseDown='CodeArrest()'   onKeyDown = 'lockKey()'>
<br><br>
<form name="repDiscipline" id="repDiscipline" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>
	<th align='left'> Report Criteria</th>
	<tr><td width="80%" class="Border" align='center'>
	<table width='80%' cellPadding="0" cellSpacing="0" align='center'>
	<tr>
		<td align="center" class='label' width="35%" >&nbsp;</td>
		<td  width="20%" class='label' align="left">From</td>
		<td class='label' width="30%" align="left">To</td>
	</tr>
	<tr>
		<td align="right" class='label' >Discipline Code &nbsp;</td>
		<td width="20%"><input type=text  name='p_fm_ind_dis_id' id='p_fm_ind_dis_id' size="4" maxlength="4"	onKeyPress="return CheckForSpecChars(event)" onBlur='ChangeUpperCase(this);parent.validSplchars(this,"Discipline Id")'><input type='button' name='Discipline Id' id='Discipline Id' tabindex=-1 value='?' class='button' onclick='searchCode(this,p_fm_ind_dis_id)'>
		</td>
		<td width="40%"><input type=text  name='p_to_ind_dis_id' id='p_to_ind_dis_id' size="4" maxlength="4" onBlur='ChangeUpperCase(this);parent.validSplchars(this,"Discipline Id")' onKeyPress="return CheckForSpecChars(event)" ><input type='button' name='Discipline Id' id='Discipline Id' value='?' class='button' tabindex=-1 onclick='searchCode(this, p_to_ind_dis_id)'>
		</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td align="right" class='label'>Nature  &nbsp;</td>
		<td >
			<select name='p_nature' id='p_nature'>
			<option value="">Both
			<option value="E">Enabled
			<option value="D">Disabled
			</select>
		</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td align="right" class='label'>Order By&nbsp;	</td>
		<td >
			<select name='p_order_by' id='p_order_by'>
			<option value='1'>Discipline Code
			<option value='2'>Discipline Desc
			</select>
		</td>
	</tr>
	<tr><td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
</table>
</td>
</tr>
</table>
<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
</form>
</body>
</html>

