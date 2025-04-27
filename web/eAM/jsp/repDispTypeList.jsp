<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
	String p_module_id		= "AM" ;
	String p_report_id		= "AMBDNTPL" ;
	String p_passing_local_date="";
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

<BODY onLoad="Focusing('p_fm_disp_type')" onMouseDown="CodeArrest();" onKeyDown = "lockKey();">
<br>
<br>
<form name="repDispTypeList" id="repDispTypeList" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
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
						<td align='right' width='30%' class="label"><fmt:message key="Common.DispType.label" bundle="${common_labels}"/>&nbsp;</td>
						<td width='20%'  ><input type=text  name='p_fm_disp_type' id='p_fm_disp_type' size="2" maxlength="2" align="center" onblur='if(this.value !="") open_lookup(this,p_fm_disp_type,p_fm_disp)'><input type="hidden" name="p_fm_disp" id="p_fm_disp"><input type='button' name='disposition' id='disposition' value='?' class='button' onclick='open_lookup(this,p_fm_disp_type,p_fm_disp)'>
						</td>
						<td width='40%'> <input type=text  name='p_to_disp_type' id='p_to_disp_type' size="2" maxlength="2" align="center" onblur='if(this.value !="") open_lookup(this,p_to_disp_type,p_to_disp)'><input type="hidden" name="p_to_disp" id="p_to_disp"><input type='button' name='disposition' id='disposition' value='?' class='button' onclick='open_lookup(this,p_to_disp_type,p_to_disp)'>
						</td>
				</tr>

				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
								
				<tr>
					<td align='right' width='30%' class="label"><fmt:message key="Common.deceased.label" bundle="${common_labels}"/> &nbsp;</td>
					<td  width='20%' align="left">
						<select name='p_deceased' id='p_deceased'>
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
					<td align='right' width='30%' class="label"><fmt:message key="eAM.UseatVisitConclusion.label" bundle="${am_labels}"/> &nbsp;</td>
					<td  width='20%' align="left">
						<select name='p_use_at_concl_yn' id='p_use_at_concl_yn'>
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
					<td align='right' width='30%' class="label"><fmt:message key="eAM.UseatDischarge.label" bundle="${am_labels}"/> &nbsp;</td>
					<td  width='20%' align="left">
						<select name='p_use_at_disch_yn' id='p_use_at_disch_yn'>
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
						<option value='1'><fmt:message key="Common.type.label" bundle="${common_labels}"/>
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

</form>
</BODY>
</HTML>

