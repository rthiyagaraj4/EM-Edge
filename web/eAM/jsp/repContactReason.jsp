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
	String p_report_id		= "AMBCONRN" ;
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
<BODY onLoad="Focusing('p_fm_reason_code')" onMouseDown="CodeArrest();" onKeyDown = "lockKey();">
<br>
<br>
<form name="repContactReason" id="repContactReason" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>
		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>
	<tr>
		<td width="100%" class="Border" >
				<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >
					<tr>
						<td align="center" width="10%">&nbsp;</td>
						<td class="fields" width="40%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
						<td class="fields" width="60%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
						<td align="center" width="10%">&nbsp;</td>
					</tr>
					<tr>
						<td width='30%' class="label"><fmt:message key="eAM.ContactReasonCode.label" bundle="${am_labels}"/>&nbsp;</td>
						<td width='40%'  class="fields"><input type=text  name='p_fm_reason_code' id='p_fm_reason_code' size="8" maxlength="8" align="center" onblur='if(this.value !="") open_lookup(this,p_fm_reason_code,p_fm_reason)'><input type="hidden" name="p_fm_reason" id="p_fm_reason"><input type='button' name='contactreason' id='contactreason' value='?' class='button' onclick='open_lookup(this,p_fm_reason_code,p_fm_reason)'>
						</td>
						<td width='60%'class="fields"> <input type=text  name='p_to_reason_code' id='p_to_reason_code' size="8" maxlength="8" align="center" onblur='if(this.value !="") open_lookup(this,p_to_reason_code,p_to_reason)'><input type="hidden" name="p_to_reason" id="p_to_reason"><input type='button' name='contactreason' id='contactreason' value='?' class='button' onclick='open_lookup(this,p_to_reason_code,p_to_reason)'>
						</td>
						<td align="center" width="20%">&nbsp;</td>
					</tr>

				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>				
				<tr>
					<td width='30%' class="label"><fmt:message key="Common.bookappointment.label" bundle="${common_labels}"/> &nbsp;</td>
					<td  width='20%' class="fields">
						<select name='p_book_appt_yn' id='p_book_appt_yn'>
						<option value="B"><fmt:message key="Common.Both.label" bundle="${common_labels}"/>
						<option value="Y"><fmt:message key="Common.yes.label" bundle="${common_labels}"/>
						<option value="N"><fmt:message key="Common.no.label" bundle="${common_labels}"/>
						</select>
					</td>
					<td width='30%' class="label"><fmt:message key="Common.TransferAppointment.label" bundle="${common_labels}"/> &nbsp;</td>
					<td  width='20%' class="fields">
						<select name='p_transfer_appt_yn' id='p_transfer_appt_yn'>
						<option value="B"><fmt:message key="Common.Both.label" bundle="${common_labels}"/>
						<option value="Y"><fmt:message key="Common.yes.label" bundle="${common_labels}"/>
						<option value="N"><fmt:message key="Common.no.label" bundle="${common_labels}"/>
						</select>
					</td>
				</tr>

				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>				
				<tr>
					<td width='30%' class="label"><fmt:message key="Common.CancelAppointment.label" bundle="${common_labels}"/> &nbsp;</td>
					<td  width='20%' class="fields">
						<select name='p_cancel_appt_yn' id='p_cancel_appt_yn'>
						<option value="B"><fmt:message key="Common.Both.label" bundle="${common_labels}"/>
						<option value="Y"><fmt:message key="Common.yes.label" bundle="${common_labels}"/>
						<option value="N"><fmt:message key="Common.no.label" bundle="${common_labels}"/>
						</select>
					</td>
					<td width='30%' class="label"><fmt:message key="eAM.BlockSchedule.label" bundle="${am_labels}"/> &nbsp;</td>
					<td  width='20%'class="fields">
						<select name='p_block_sch_yn' id='p_block_sch_yn'>
						<option value="B"><fmt:message key="Common.Both.label" bundle="${common_labels}"/>
						<option value="Y"><fmt:message key="Common.yes.label" bundle="${common_labels}"/>
						<option value="N"><fmt:message key="Common.no.label" bundle="${common_labels}"/>
						</select>
					</td>
				</tr>

				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>				
				<tr>
					<td width='30%' class="label"><fmt:message key="eAM.LiftBlockonSchedule.label" bundle="${am_labels}"/> &nbsp;</td>
					<td  width='20%' class="fields">
						<select name='p_lift_blcok_sch_yn' id='p_lift_blcok_sch_yn'>
						<option value="B"><fmt:message key="Common.Both.label" bundle="${common_labels}"/>
						<option value="Y"><fmt:message key="Common.yes.label" bundle="${common_labels}"/>
						<option value="N"><fmt:message key="Common.no.label" bundle="${common_labels}"/>
						</select>
					</td>
					<td width='30%' class="label"><fmt:message key="Common.TransferSchedule.label" bundle="${common_labels}"/> &nbsp;</td>
					<td  width='20%' class="fields">
						<select name='p_transfer_sch_yn' id='p_transfer_sch_yn'>
						<option value="B"><fmt:message key="Common.Both.label" bundle="${common_labels}"/>
						<option value="Y"><fmt:message key="Common.yes.label" bundle="${common_labels}"/>
						<option value="N"><fmt:message key="Common.no.label" bundle="${common_labels}"/>
						</select>
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>				
				<tr>
					<td width='30%' class="label"><fmt:message key="Common.CancelSchedule.label" bundle="${common_labels}"/> &nbsp;</td>
					<td  width='20%' class="fields">
						<select name='p_cancel_sch_yn' id='p_cancel_sch_yn'>
						<option value="B"><fmt:message key="Common.Both.label" bundle="${common_labels}"/>
						<option value="Y"><fmt:message key="Common.yes.label" bundle="${common_labels}"/>
						<option value="N"><fmt:message key="Common.no.label" bundle="${common_labels}"/>
						</select>
					</td>
					<td width='30%' class="label"><fmt:message key="Common.RegisterVisit.label" bundle="${common_labels}"/> &nbsp;</td>
					<td  width='20%' class="fields">
						<select name='p_register_visit_yn' id='p_register_visit_yn'>
						<option value="B"><fmt:message key="Common.Both.label" bundle="${common_labels}"/>
						<option value="Y"><fmt:message key="Common.yes.label" bundle="${common_labels}"/>
						<option value="N"><fmt:message key="Common.no.label" bundle="${common_labels}"/>
						</select>
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>				
				<tr>
					<td width='30%' class="label"><fmt:message key="Common.ReviseVisit.label" bundle="${common_labels}"/> &nbsp;</td>
					<td  width='20%' class="fields">
						<select name='p_revise_visit_yn' id='p_revise_visit_yn'>
						<option value="B"><fmt:message key="Common.Both.label" bundle="${common_labels}"/>
						<option value="Y"><fmt:message key="Common.yes.label" bundle="${common_labels}"/>
						<option value="N"><fmt:message key="Common.no.label" bundle="${common_labels}"/>
						</select>
					</td>
					<td width='30%' class="label"><fmt:message key="eAM.CancelVisit.label" bundle="${am_labels}"/> &nbsp;</td>
					<td  width='20%' class="fields">
						<select name='p_cancel_visit_yn' id='p_cancel_visit_yn'>
						<option value="B"><fmt:message key="Common.Both.label" bundle="${common_labels}"/>
						<option value="Y"><fmt:message key="Common.yes.label" bundle="${common_labels}"/>
						<option value="N"><fmt:message key="Common.no.label" bundle="${common_labels}"/>
						</select>
					</td>
				</tr>

				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>				
												
					<tr>
					<td width='30%' class="label"><fmt:message key="Common.Nature.label" bundle="${common_labels}"/> &nbsp;</td>
					<td  width='20%' class="fields" colspan="3">
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
					<td width='30%' class="label">
						<fmt:message key="Common.orderBy.label" bundle="${common_labels}"/> &nbsp;
					</td>
					<td  width='20%' class="fields" colspan="3">
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
	<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
	<!-- <input type='hidden' name='p_language_id' id='p_language_id' value='<%=locale%>'>
	<input type='hidden' name='p_passing_local_date' id='p_passing_local_date' value='<%=p_passing_local_date%>'> -->

</form>
</BODY>
</HTML>

