<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
	String p_passing_local_date="";
	String p_module_id		= "AM" ;
	String p_report_id		= "AMBSTGPM" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String locale = (String)session.getAttribute("LOCALE");

	if(locale.equals("th"))
		{
			p_passing_local_date="Y";
		}else 
		{
			p_passing_local_date="N";
		}
%>
<html>
<HEAD>
<TITLE></TITLE>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../js/SearchPopup.js" language="JavaScript"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</HEAD>

<BODY onLoad="Focusing('p_fm_mod');" onMouseDown="CodeArrest();" onKeyDown = "lockKey();">
<br>
<br>
<form name="reppgmstatgrp" id="reppgmstatgrp" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>

		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>

	<tr>

		<td width="100%" class="Border" align='center'>

				<table width='100%' cellPadding="0" cellSpacing="0"  align='center' >

					<tr>
						<td align="center" width="20%">&nbsp;</td>
						<td class="fields" width="40%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
						<td class="fields" width="40%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					</tr>

					<tr>
						<td align='right' width='20%' class="label"><fmt:message key="Common.Module.label" bundle="${common_labels}"/>&nbsp;</td>
						<td width='40%'  ><input type=text  name='p_fm_mod' id='p_fm_mod' size="6" maxlength="6" align="center" onblur='if(this.value !="") open_lookup(this,p_fm_mod,p_fm_mod_desc)'><input type="hidden" name="p_fm_mod_desc" id="p_fm_mod_desc"><input type='button' name='module' id='module' value='?' class='button' onclick='open_lookup(this,p_fm_mod,p_fm_mod_desc)'>
						</td>
						<td width='40%'> <input type=text  name='p_to_mod' id='p_to_mod' size="6" maxlength="6" align="center" onblur='if(this.value !="") open_lookup(this,p_to_mod,p_to_mod_desc)'><input type="hidden" name="p_to_mod_desc" id="p_to_mod_desc"><input type='button' name='module' id='module' value='?' class='button' onclick='open_lookup(this,p_to_mod,p_to_mod_desc)'>
						</td>
				</tr>

				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
				<tr>
						<td align='right' width='20%' class="label"><fmt:message key="eAM.ProgramType.label" bundle="${am_labels}"/>&nbsp;</td>
						<td width='40%' colspan='2' >
							<select name="p_prog_type" id="p_prog_type" onChange="setValues(this.value);">
							<option value="">----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----- </option>
							<option value="F"><fmt:message key="Common.Function.label" bundle="${common_labels}"/></option>
							<option value="R"><fmt:message key="Common.report.label" bundle="${common_labels}"/></option>
						</td>
				</tr>

				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
				<tr>
						<td align='right' width='20%' class="label"><fmt:message key="eAM.ProgramID.label" bundle="${am_labels}"/>&nbsp;</td>
						<td width='40%'  ><input type=text  name='p_fm_program_id' id='p_fm_program_id' size="30" maxlength="30" align="center" onblur='if(this.value !="") open_lookup(this,p_fm_program_id,p_fm_program_id_desc)' disabled><input type="hidden" name="p_fm_program_id_desc" id="p_fm_program_id_desc"><input type='button' name='Program_but1' id='Program_but1' value='?' class='button' onclick='open_lookup(this,p_fm_program_id,p_fm_program_id_desc)' disabled>
						</td>
						<td width='40%'> <input type=text  name='p_to_program_id' id='p_to_program_id' size="30" maxlength="30" align="center" onblur='if(this.value !="") open_lookup(this,p_to_program_id,p_to_program_id_desc)' disabled><input type="hidden" name="p_to_program_id_desc" id="p_to_program_id_desc"><input type='button' name='Program_but2' id='Program_but2' value='?' class='button' onclick='open_lookup(this,p_to_program_id,p_to_program_id_desc)' disabled>
						</td>
				</tr>

				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
				<tr>
						<td align='right' width='20%' class="label"><fmt:message key="Common.StatisticsGroup.label" bundle="${common_labels}"/>&nbsp;</td>
						<td width='40%'  ><input type=text  name='p_fm_stat_grp' id='p_fm_stat_grp' size="6" maxlength="6" align="center" onblur='if(this.value !="") open_lookup(this,p_fm_stat_grp,p_fm_stat_grp_desc)'><input type="hidden" name="p_fm_stat_grp_desc" id="p_fm_stat_grp_desc"><input type='button' name='Statistics' id='Statistics' value='?' class='button' onclick='open_lookup(this,p_fm_stat_grp,p_fm_stat_grp_desc)'>
						</td>
						<td width='40%'> <input type=text  name='p_to_stat_grp' id='p_to_stat_grp' size="6" maxlength="6" align="center" onblur='if(this.value !="") open_lookup(this,p_to_stat_grp,p_to_stat_grp_desc)'><input type="hidden" name="p_to_stat_grp_desc" id="p_to_stat_grp_desc"><input type='button' name='Statistics' id='Statistics' value='?' class='button' onclick='open_lookup(this,p_to_stat_grp,p_to_stat_grp_desc)'>
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
<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
<!-- <input type='hidden' name='p_language_id' id='p_language_id' value='<%=locale%>'>
<input type='hidden' name='p_passing_local_date' id='p_passing_local_date' value='<%=p_passing_local_date%>'> -->

</form>
</BODY>
</HTML>

