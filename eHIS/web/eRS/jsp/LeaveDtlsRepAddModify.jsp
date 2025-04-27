<!DOCTYPE html>
<!-- Created on 19 August 2009 -- Shyampriya -->

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.sql.*, webbeans.eCommon.*, java.util.*, eRS.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<HTML>
	<HEAD>
<%

		    request.setCharacterEncoding("UTF-8");
			String locale			= (String)session.getAttribute("LOCALE");
		    String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

			<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

			<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
			<!-- import the calendar script -->
			<SCRIPT LANGUAGE="Javascript" src="../../eCommon/js/DateUtils.js"></SCRIPT>
			<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
			<SCRIPT LANGUAGE="javascript" src="../../eCommon/js/CommonCalendar.js"></SCRIPT>
			<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
			<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
			<!-- <SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT> -->
			<SCRIPT LANGUAGE="javascript" SRC="../../eRS/js/LeaveDtlsReport.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</HEAD>
	<BODY>
		<FORM name="formLeaveDtlsReport" id="formLeaveDtlsReport" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame">
			<TABLE WIDTH="98%" ALIGN="center" CELLPADDING="0" CELLSPACING="0" BORDER="0">
				<TH WIDTH="100%" COLSPAN="4" ALIGN="left"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
				<tr ><td>&nbsp</td></tr>
				<tr>
					<td align="right" class="label" width="15%"><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
					<td align="left" class="label" width="30%"><input type=text size=20 maxlength='20' name='txt_locn_type1' id='txt_locn_type1' onblur='showLocationTypeLookup("T",txt_locn_type1);'><input type=button class='button' value="?" onclick='showLocationTypeLookup("B",txt_locn_type1);'>
					<input type=hidden name='txt_locn_type' id='txt_locn_type' value=''>
					</td>
					<td align="right" class="label" width="15%"><fmt:message key="eRS.WorkPlace.label" bundle="${rs_labels}"/></td>
					<td align="left" class="label" width="55%"><input type=text size=35 maxlength='30' name='txt_work_place1' id='txt_work_place1' onblur='showWorkplaceLookup("T",txt_work_place1);'><input type=button class='button' value="?" onclick='showWorkplaceLookup("B",txt_work_place1);'>
					<input type=hidden name='txt_work_place' id='txt_work_place' value=''>
					</td>
				</tr>

				<tr><td>&nbsp</td></tr>

				<tr>
					<td align="right" class="label" width="15%"><fmt:message key="Common.RoleType.label" bundle="${common_labels}"/></td>
					<td align="left" class="label" width="30%">
						<select name="slt_role_type" id="slt_role_type" onchange="populateStaffType1();">
							<option value="" selected>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ----- </option>
							<option value="P"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>
							<option value="O"><fmt:message key="Common.OtherStaff.label" bundle="${common_labels}"/></option>
						</select>
					</td>			
					<td align="right" class="label" width="15%"><fmt:message key="eRS.StaffType.label" bundle="${rs_labels}"/></td>
					<td align="left" class="label" width="55%">
						<select name="slt_staff_type" id="slt_staff_type" onchange="clearPositionStaff();">
							<option value="">----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ----- </option>
						</select>
					</td>
				</tr>

				<tr><td>&nbsp</td></tr>

				<tr>
					<td align="right" class="label" width="15%"><fmt:message key="Common.Position.label" bundle="${common_labels}"/></td>
					<td align="left" class="label" width="30%"><input type=text name="txt_position" id="txt_position" size='20' maxlength='20' onblur='viewPosition("T",txt_position);'><input type=button class=button value='?' name='position_lookup' id='position_lookup' onclick='viewPosition("B",txt_position);'>
					<input type=hidden name="p_position_code" id="p_position_code" value="">
					<td class="label" width="15%"  align="right" ><fmt:message key="eRS.Staff.label" bundle="${rs_labels}"/></td>
					<td class="label" width="55%" align="left"><input type=text name="txt_staff1" id="txt_staff1" value="" size="36" readonly><input class='button' type=button name="stafflookup_button" id="stafflookup_button" value="?"  onClick='showStaff(txt_staff1)'>
					<input type='hidden' name='txt_staff' id='txt_staff' value=''>
					
				</tr>

				<tr><td>&nbsp</td></tr>

				<tr>
					<td   class="label" width="15%" align="right"><fmt:message key="Common.fromdate.label" bundle="${common_labels}"/>
					<td class="label" width="30%" align="left"><input type="text" name="txt_from_date" id="txt_from_date" value="" maxlength="12" size="8" onBlur="validDateFormat(this,'<%=locale%>');" onKeyPress='return AllowDateFormat();'><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('txt_from_date'); " >&nbsp;<img src="../../eCommon/images/mandatory.gif"  ></img></td>
					<td   class="label" width="15%" align="right"><fmt:message key="Common.todate.label" bundle="${common_labels}"/></td>
					<td class="label" width="55%" align="left"><input type="text" name="txt_to_date" id="txt_to_date"   value="" maxlength="12" size="8" onBlur="validDateFormat(this,'<%=locale%>');" onKeyPress='return AllowDateFormat();'><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('txt_to_date'); " >&nbsp;<img src="../../eCommon/images/mandatory.gif"  ></img>
					</td>
				</tr>


			</TABLE>
			<input TYPE='hidden' name='locale' id='locale' value='<%=locale%>'>
			<input TYPE='hidden' name='p_date_from' id='p_date_from' value=''>
			<input TYPE='hidden' name='p_date_to' id='p_date_to' value=''>
			<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="RS">
			<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="RSLEAVEDET">
			<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
			<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
			<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
		</FORM>
	</BODY>
</HTML>

