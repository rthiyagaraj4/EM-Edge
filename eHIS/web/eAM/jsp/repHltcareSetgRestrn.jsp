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
	String p_report_id		= "AMHCSTRS" ;
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
<script src="../../eAM/js/SearchPopup.js" language="JavaScript"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</HEAD>

<BODY onLoad="Focusing('p_fm_hcare')" onMouseDown="CodeArrest();" onKeyDown = "lockKey();">
<br>
<br>
<form name="repHcareRestrnList" id="repHcareRestrnList" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='50%' align='center' valign='top'>

		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>

	<tr>

		<td width="100%" class="Border" align='center'>

				<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >

					<tr>
						<td align='right' class="label"><fmt:message key="eAM.FromHealthCareSettingType.label" bundle="${am_labels}"/>&nbsp;</td>
						<td ><input type=text  name='p_fm_hcare' id='p_fm_hcare' size="6" maxlength="6" align="center" onblur='if(this.value !="") open_lookup(this,p_fm_hcare,p_fm_hcare_desc)'><input type="hidden" name="p_fm_hcare_desc" id="p_fm_hcare_desc" ><input type='button' name='hlthcare' id='hlthcare' value='?' class='button' onclick='open_lookup(this,p_fm_hcare,p_fm_hcare_desc)'>
						</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
						<td align='right' class="label"><fmt:message key="eAM.ToHealthCareSettingType.label" bundle="${am_labels}"/>&nbsp;</td>
						<td ><input type=text  name='p_to_hcare' id='p_to_hcare' size="6" maxlength="6" align="center" onblur='if(this.value !="") open_lookup(this,p_to_hcare,p_to_hcare_desc)'><input type="hidden" name="p_to_hcare_desc" id="p_to_hcare_desc" ><input type='button' name='hlthcare' id='hlthcare' value='?' class='button' onclick='open_lookup(this,p_to_hcare,p_to_hcare_desc)'>
						</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td align='right' class="label"><fmt:message key="eAM.InpatientReferral.label" bundle="${am_labels}"/>&nbsp;</td>
					<td  align="left">
						<select name='p_ip_referral' id='p_ip_referral'>
						<option value="">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---
						<option value="Y"><fmt:message key="Common.yes.label" bundle="${common_labels}"/>
						<option value="N"><fmt:message key="Common.no.label" bundle="${common_labels}"/>
						</select>
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td align='right' class="label"><fmt:message key="eAM.OutpatientReferral.label" bundle="${am_labels}"/>&nbsp;</td>
					<td  align="left">
						<select name='p_op_referral' id='p_op_referral'>
						<option value="">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---
						<option value="Y"><fmt:message key="Common.yes.label" bundle="${common_labels}"/>
						<option value="N"><fmt:message key="Common.no.label" bundle="${common_labels}"/>
						</select>
					</td>

				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>

		</table>
	</td>
</tr>
</table>
<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
<input type="hidden" name="p_user_name" id="p_user_name"		value="<%= p_user_name %>">
<input type='hidden' name='locale' id='locale' value='<%=locale%>'>

</form>
</BODY>
</HTML>

