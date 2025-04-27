<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
	String p_module_id	= "AM" ;
	String p_report_id		= "AMBAGLST" ;
	String p_passing_local_date="";

	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name	= (String) session.getValue( "login_user" ) ;
	String locale = (String)session.getAttribute("LOCALE");
		if(locale.equals("th"))
		{
			p_passing_local_date="Y";
		}else 
		{
			p_passing_local_date="N";
		}

%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
	<head>
	<title></title>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src="../../eCommon/js/ValidateControl.js"></script>
 	<script src="../js/SearchPopup.js" language="JavaScript"></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	</HEAD>

	<BODY OnMouseDown='CodeArrest()'  onLoad="Focusing('p_fm_age_group_code')" onKeyDown = 'lockKey()'>
	<br>
	<br>
	<form name="repAgeGroupList" id="repAgeGroupList" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
	<table width='80%' align='center' valign='top'>

			<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
			</th>

		<tr>

			<td width="100%" class="Border" align='center'>

					<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >

						<tr>
							<td align="center" width="35%">&nbsp;</td>
							<td class="fields" width="20%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
							<td class="fields" width="40%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
						</tr>

		
					<tr>
							<td align='right' width='30%' class="label"><fmt:message key="Common.agegroupcode.label" bundle="${common_labels}"/>&nbsp;</td>
							<td width='20%'  ><input type=text  name='p_fm_age_group_code' id='p_fm_age_group_code' size="2" maxlength="2" align="center" onblur='if(this.value !="") open_lookup(this,p_fm_age_group_code,p_fm_age_group)'><input type="hidden" name="p_fm_age_group" id="p_fm_age_group"><input type='button' name='agegroup' id='agegroup' value='?' class='button' onclick='open_lookup(this,p_fm_age_group_code,p_fm_age_group)'>						
							</td>
							<td width='40%'> <input type=text  name='p_to_age_group_code' id='p_to_age_group_code' size="2" maxlength="2" align="center" onblur='if(this.value !="") open_lookup(this,p_to_age_group_code,p_to_age_group)'><input type="hidden" name="p_to_age_group" id="p_to_age_group"><input type='button' name='agegroup' id='agegroup' value='?' class='button' onclick='open_lookup(this,p_to_age_group_code,p_to_age_group)'>
							</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<Td>&nbsp;</td>
					</tr>
					<tr>
						<td align='right' width='30%' class="label"><fmt:message key="Common.gender.label" bundle="${common_labels}"/> &nbsp;</td>
						<td  width='20%' align="left">
							<select name='p_gender' id='p_gender'>
							<option value="">-- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-- 
							<option value="F"><fmt:message key="Common.female.label" bundle="${common_labels}"/>
							<option value="M"><fmt:message key="Common.male.label" bundle="${common_labels}"/>
							<option value="U"><fmt:message key="Common.unknown.label" bundle="${common_labels}"/>
							</select>
						</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<Td>&nbsp;</td>
					</tr>
					<tr>
						<td align='right' width='30%' class="label"><fmt:message key="Common.AgeUnit.label" bundle="${common_labels}"/> &nbsp;</td>
						<td  width='20%' align="left">
							<select name='p_age_unit' id='p_age_unit'>
							<option value="">-- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-- 
							<option value="D"><fmt:message key="Common.day.label" bundle="${common_labels}"/>
							<option value="M"><fmt:message key="Common.month.label" bundle="${common_labels}"/>
							<option value="Y"><fmt:message key="Common.year.label" bundle="${common_labels}"/>
							</select>
						</td>
					</tr>
				
					<tr>
						<td>&nbsp;</td>
						<Td>&nbsp;</td>
					</tr>
					<tr>
						<td align='right' width='30%' class="label"><fmt:message key="Common.Nature.label" bundle="${common_labels}"/> &nbsp;</td>
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
						<td align='right' width='30%' class="label">
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
	<input type='hidden' name='locale' id='locale'       value='<%=locale%>'>
	

	</form>
	</BODY>
</HTML>

