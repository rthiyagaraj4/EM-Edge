<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
	String p_module_id		= "AM" ;
	String p_report_id		= "AMBPTCLT" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
%>
<html>
<HEAD>
<TITLE></TITLE>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</HEAD>
<script>
async function searchCode(obj,target)
	{
			var retVal = 	new String();
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";


			if(obj.name=="patienttype")
			{
				tit=getLabel("Common.patienttype.label","Common");

				sql="select patient_type, short_desc from am_patient_type";
				search_code="patient_type";
				search_desc= "short_desc";
			}

			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}
</script>
<BODY onLoad="Focusing('p_fm_patient_type')" onMouseDown="CodeArrest();" onKeyDown = "lockKey();">
<br>
<br>
<form name="repPatTypeClass" id="repPatTypeClass" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>

		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>

	<tr>

		<td width="100%" class="Border" align='center'>

				<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >
				<tr>
										<td align="center" width="35%">&nbsp;</td>
										<td class="label" width="20%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
										<td class="label" width="40%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
									</tr>

									<tr>
										<td align='right' width='30%' class="label"><fmt:message key="Common.patienttype.label" bundle="${common_labels}"/>&nbsp;</td>
										<td width='20%'  ><input type=text  name='p_fm_patient_type' id='p_fm_patient_type' size="4" maxlength="4" align="center"><input type='button' name='patienttype' id='patienttype' value='?' class='button' onclick='searchCode(this, p_fm_patient_type)'>
										</td>
										<td width='40%'> <input type=text  name='p_to_patient_type' id='p_to_patient_type' size="4" maxlength="4" align="center"><input type='button' name='patienttype' id='patienttype' value='?' class='button' onclick='searchCode(this, p_to_patient_type)'>
										</td>
								</tr>

								<tr>
									<td>&nbsp;</td>
									<Td>&nbsp;</td>
				</tr>

									<tr>
										<td align='right' width='30%' class="label"><fmt:message key="eAM.PatientTypeClass.label" bundle="${am_labels}"/>&nbsp;</td>
										<td width='20%'  ><input type=text  name='p_fm_patient_class' id='p_fm_patient_class' size="2" maxlength="2" align="center">
										</td>
										<td width='40%'> <input type=text  name='p_to_patient_class' id='p_to_patient_class' size="2" maxlength="2" align="center">
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
						<option value='1'><fmt:message key="Common.patienttype.label" bundle="${common_labels}"/>
						<option value='2'><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/>
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
<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
</form>
</BODY>
</HTML>

