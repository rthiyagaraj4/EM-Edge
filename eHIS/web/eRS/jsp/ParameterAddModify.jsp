<!DOCTYPE html>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:
*	Created By		:	Suchilagna Panigrahi
*	Created On		:	29th Dec 2004
-->

<!--ParameterAddModify.jsp-->

<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%-- Mandatory declarations end --%>
<%
	String mode = request.getParameter("mode");
	String facility_id="";
	String operation_type="";
	String facility_name="";
	String sparams=(String)session.getAttribute("sparams");
	String readOnly="";
%>
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<!-- <script language="JavaScript" src="../../eCommon/js/MstCodeCommon.js"></script>
 --><script src='../../eCommon/js/common.js' language='javascript'></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../js/Parameter.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body  onload='FocusFirstElement();ModifyDisplay();' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name='form_ParameterAddModify' id='form_ParameterAddModify' action='../../servlet/eRS.ParameterServlet' method='POST' target='messageFrame'>
<%
		if(mode.equals("1"))
		{
			operation_type="insert";

			String sql1="";
			Vector facility_list=new Vector();

			Connection conn = null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;

		try 
		{
			conn = ConnectionManager.getConnection();

			//sql1="select facility_id,facility_name from sm_facility_param order by facility_name";
			sql1="select facility_id,facility_name from sm_facility_param_lang_vw where language_id = ? order by facility_name";
			pstmt=conn.prepareStatement(sql1);
			pstmt.setString(1,locale);
			rs=pstmt.executeQuery();
			 while(rs.next()){
				facility_list.add(rs.getString("facility_id"));
				facility_list.add(rs.getString("facility_name"));
			 }
			  if (pstmt != null) pstmt.close();
			  if (rs != null)   rs.close();

		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
		  if (pstmt != null) pstmt.close();
		  if (rs != null)   rs.close();
		  ConnectionManager.returnConnection(conn,request);
		}
%>
		<table cellpadding=0 cellspacing=0 border=0 width="100%" align='center'>
			<tr>
				<td  width="50%"class="label"><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
				<td>&nbsp;&nbsp;&nbsp;<select name="facility_id" id="facility_id">
<%
				for(int i=0;i<facility_list.size();i+=2){
%>
					<option value='<%=facility_list.get(i)%>'><%= (String)facility_list.get(i+1)%> </option>
<%
				}
%>
				</select>  </td>
				<td></td>
			</tr>
			<tr>
				<td  width="50%" class="label"><fmt:message key="eRS.AllowOverlapofShiftsinaWorkplace.label" bundle="${rs_labels}"/></td>
				<td>&nbsp;&nbsp;&nbsp;<input type=checkbox name="overlap_shifts_in_workplace_yn" id="overlap_shifts_in_workplace_yn"  onclick="checkActive(this)"></td>
				<td></td>
			</tr>
			<tr>
				<td  width="50%" class="label"><fmt:message key="eRS.WorkCycleBasis.label" bundle="${rs_labels}"/></td>
				<td>&nbsp;&nbsp;
				<select name='work_cycle_basis' id='work_cycle_basis'>
					<option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
					<option value='1W'>1 <fmt:message key="Common.weekly.label" bundle="${common_labels}"/></option>
				</select>&nbsp;<img src="../../eCommon/images/mandatory.gif">&nbsp;
				</td>
				<td></td>
			</tr>
			<tr>
				<td  width="50%" class="label"><fmt:message key="eRS.PeriodaheadforWorkSchedulecreation.label" bundle="${rs_labels}"/></td>
				<td class='label'>&nbsp;&nbsp;<input type='text' name='period_for_work_schedule_gen' id='period_for_work_schedule_gen' size='2' maxlength='3' onkeypress="return allowPositiveNumber1()" value='' onblur='checkForZero(this);'><font color='navy'>&nbsp;&nbsp;<fmt:message key="Common.days.label"bundle="${common_labels}"/></font>&nbsp;<img src="../../eCommon/images/mandatory.gif">&nbsp;</td>
				<td></td>
			</tr>
			<tr>
				<td  width="50%" class="label"><fmt:message key="eRS.Maximumcontinuousdurationstaffcanwork.label" bundle="${rs_labels}"/></td>
				<td class='label'>&nbsp;
				<input type=text size=1 maxlength=2 name='max_continuous_work_duration1' id='max_continuous_work_duration1' onblur='CheckForHours(this)' onkeypress="return allowPositiveNumber()"> : 
					<input type=text size=1 maxlength=2 name='max_continuous_work_duration2' id='max_continuous_work_duration2' onblur='CheckForMinutes(this,max_continuous_work_duration1);' onkeypress="return allowPositiveNumber()">&nbsp;(hh:mi)&nbsp;<img src="../../eCommon/images/mandatory.gif">&nbsp;</td>
					<td>&nbsp;</td>
			</tr>
			<tr>	
				<td  width="40%" class="label"><fmt:message key="eRS.StaffSubstitutionBasis.label" bundle="${rs_labels}"/>:</td>
				<td class='label'>&nbsp;&nbsp;<input type='checkbox' name='staff_subs_same_grade_yn' id='staff_subs_same_grade_yn' onclick="checkActive(this)"  value=''><fmt:message key="eRS.WithinsameGrade.label" bundle="${rs_labels}"/></td><td>&nbsp;</td>
			</tr>
			<tr>
				<td width='50%'>&nbsp;</td>
				<td class="label">&nbsp;&nbsp;<input type='checkbox' name='staff_subs_high_to_low_yn' id='staff_subs_high_to_low_yn' onclick="checkActive(this)"><fmt:message key="eRS.LowtoHighGrade.label" bundle="${rs_labels}"/></td><td>&nbsp;</td>
			</tr>
			<tr>
				<td width='50%'>&nbsp;</td>
				<td class="label">&nbsp;&nbsp;<input type='checkbox' name='staff_subs_low_to_high_yn' id='staff_subs_low_to_high_yn' onclick="checkActive(this)"><fmt:message key="eRS.HightoLowGrade.label" bundle="${rs_labels}"/></td><td>&nbsp;</td>
			</tr>
			<tr>
				<td  width="50%" class="label"><fmt:message key="eRS.AttendanceFeatureRequired.label" bundle="${rs_labels}"/></td>
				<td>&nbsp;&nbsp;&nbsp;<input type='checkbox' name='attendance_feature_reqd_yn' id='attendance_feature_reqd_yn' onclick="checkActive1(this, max_durn_to_mark_attendance1, max_durn_to_mark_attendance2, Max_Durn_Mandatory);">
				<td></td>
			</tr>
			<tr>
				<td  width="50%" class="label"><fmt:message key="eRS.Maxdurationfromstartofshifttomarkattendance.label" bundle="${rs_labels}"/></td><td class='label'>&nbsp;&nbsp;&nbsp;<input type=text size=1 maxlength=2 name='max_durn_to_mark_attendance1' id='max_durn_to_mark_attendance1' onblur='CheckForHours(this)' onkeypress="return allowPositiveNumber()" readonly>&nbsp;:&nbsp;<input type=text size=1 maxlength=2 name='max_durn_to_mark_attendance2' id='max_durn_to_mark_attendance2' onblur='CheckForMinutes(this,max_durn_to_mark_attendance1);checkForblank(this,max_durn_to_mark_attendance1);' onkeypress="return allowPositiveNumber()" readonly>&nbsp;(hh:mi)&nbsp;<img id="Max_Durn_Mandatory" src="../../eCommon/images/mandatory.gif" style="visibility:hidden"></td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td  width="50%" class="label"><fmt:message key="eRS.ValidatestaffaccessrightsbyAttendance.label" bundle="${rs_labels}"/></td>
				<td>&nbsp;&nbsp;&nbsp;<input type='checkbox' name='vald_staff_acc_by_work_sch_yn' id='vald_staff_acc_by_work_sch_yn' onclick="checkActive(this)">
				<td></td>
			</tr>
			
			<tr>
				<td  width="50%" class="label"><fmt:message key="eRS.ValidatestaffaccessrightsbyWorkSchedule.label" bundle="${rs_labels}"/></td>
				<td>&nbsp;&nbsp;&nbsp;<input type='checkbox' name='vald_staff_acc_by_att_yn' id='vald_staff_acc_by_att_yn' onclick="checkActive(this)">
				<td></td>
			</tr>
			</table>
			<table cellpadding=0 cellspacing=0 border=0 width="100%" align='center'>
			<tr >
				<td class='label' width='35%'><b><fmt:message key="eRS.Activitiesallowedonactiveshift.label" bundle="${rs_labels}"/>:</b></td>
				<td width='20%' ></td>
				<td class='label' width='40%'><b><fmt:message key="eRS.Durationfromstartofshift.label" bundle="${rs_labels}"/>&nbsp;(hh:mi)</td>
			</tr>
			<tr><td>&nbsp;</td>
				<td class='label' width='20%'><fmt:message key="eRS.Allocate.label" bundle="${rs_labels}"/>&nbsp&nbsp&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='checkbox' name='curr_shift_allocation_yn' id='curr_shift_allocation_yn' onclick="checkActive1(this, durn_for_allocation_from_sos1, durn_for_allocation_from_sos2, Allocate_Mandatory);" ></td>
				<td class='label' width='45%'>&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;<input type=text size=1 maxlength=2 name='durn_for_allocation_from_sos1' id='durn_for_allocation_from_sos1' onblur='CheckForHours(this)' onkeypress="return allowPositiveNumber()" readonly> : <input type=text size=1 maxlength=2 name='durn_for_allocation_from_sos2' id='durn_for_allocation_from_sos2' onblur='CheckForMinutes(this,durn_for_allocation_from_sos1);' onkeypress="return allowPositiveNumber()" readonly>&nbsp;<img id="Allocate_Mandatory" src="../../eCommon/images/mandatory.gif" style="visibility:hidden">&nbsp;</td>	



				<!-- <td class='label'>&nbsp;&nbsp;<input type='checkbox' name='staff_subs_same_grade_yn' id='staff_subs_same_grade_yn' onclick="checkActive(this)" align='center' value=''> -->


			</tr>

			<tr><td>&nbsp;</td>
				<td class='label' width='20%'><fmt:message key="Common.change.label" bundle="${common_labels}"/>&nbsp&nbsp&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='checkbox' name='curr_shift_change_yn' id='curr_shift_change_yn' onclick="checkActive1(this, durn_for_change_from_sos1, durn_for_change_from_sos2,Change_Mandatory);"></td>
				<td class='label' width='45%'>&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;<input type=text size=1 maxlength=2 name='durn_for_change_from_sos1' id='durn_for_change_from_sos1' onblur='CheckForHours(this)' onkeypress="return allowPositiveNumber()" readonly> : 	<input type=text size=1 maxlength=2 name='durn_for_change_from_sos2' id='durn_for_change_from_sos2' onblur='CheckForMinutes(this,durn_for_change_from_sos1)' onkeypress="return allowPositiveNumber()" readonly>&nbsp;<img id="Change_Mandatory" src="../../eCommon/images/mandatory.gif" style="visibility:hidden">&nbsp;</td>	
			</tr>
			<tr><td>&nbsp;</td>
				<td class='label' width='20%'><fmt:message key="Common.Transfer.label" bundle="${common_labels}"/>&nbsp&nbsp&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='checkbox' name='curr_shift_transfer_yn' id='curr_shift_transfer_yn' onclick="checkActive1(this, durn_for_transfer_from_sos1, durn_for_transfer_from_sos2, Transfer_Mandatory);"></td>
				<td class='label' width='45%'>&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;<input type=text size=1 maxlength=2 name='durn_for_transfer_from_sos1' id='durn_for_transfer_from_sos1' onblur='CheckForHours(this)' onkeypress="return allowPositiveNumber()" readonly> : 	<input type=text size=1 maxlength=2 name='durn_for_transfer_from_sos2' id='durn_for_transfer_from_sos2' onblur='CheckForMinutes(this,durn_for_transfer_from_sos1)' onkeypress="return allowPositiveNumber()" readonly>&nbsp;<img id="Transfer_Mandatory" src="../../eCommon/images/mandatory.gif" style="visibility:hidden">&nbsp;</td>	
			</tr>

			<tr><td>&nbsp;</td>
				<td class='label' width='20%'><fmt:message key="eRS.Swap.label" bundle="${rs_labels}"/>&nbsp&nbsp&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='checkbox' name='curr_shift_swap_yn' id='curr_shift_swap_yn' onclick="checkActive1(this, durn_for_swap_from_sos1, durn_for_swap_from_sos2, Swap_Mandatory);"></td>
				<td class='label' width='45%'>&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;<input type=text size=1 maxlength=2 name='durn_for_swap_from_sos1' id='durn_for_swap_from_sos1' onblur='CheckForHours(this)' onkeypress="return allowPositiveNumber()" readonly> : <input type=text size=1 maxlength=2 name='durn_for_swap_from_sos2' id='durn_for_swap_from_sos2' onblur='CheckForMinutes(this,durn_for_swap_from_sos1)' onkeypress="return allowPositiveNumber()" readonly>&nbsp;<img id="Swap_Mandatory" src="../../eCommon/images/mandatory.gif" style="visibility:hidden">&nbsp;</td>	
			</tr>
			<tr><td>&nbsp;</td>
				<td class='label' width='20%'><fmt:message key="eRS.Overtime.label" bundle="${rs_labels}"/>&nbsp&nbsp&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type='checkbox' name='curr_shift_overtime_yn' id='curr_shift_overtime_yn' onclick="checkActive1(this, durn_for_overtime_from_sos1, durn_for_overtime_from_sos2, Overtime_Mandatory);"></td>
				<td class='label' width='45%'>&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;<input type=text size=1 maxlength=2 name='durn_for_overtime_from_sos1' id='durn_for_overtime_from_sos1' onblur='CheckForHours(this)' onkeypress="return allowPositiveNumber()" readonly> : <input type=text size=1 maxlength=2 name='durn_for_overtime_from_sos2' id='durn_for_overtime_from_sos2' onblur='CheckForMinutes(this,durn_for_overtime_from_sos1)' onkeypress="return allowPositiveNumber()" readonly>&nbsp;<img id="Overtime_Mandatory" src="../../eCommon/images/mandatory.gif" style="visibility:hidden">&nbsp;</td>	
     		</tr>
			<tr><td>&nbsp;</td>
				<td class='label' width='20%'><fmt:message key="Common.Leave.label" bundle="${common_labels}"/>&nbsp&nbsp&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;<input type='checkbox' name='curr_shift_leave_yn' id='curr_shift_leave_yn' onclick="checkActive1(this, durn_for_leave_from_sos1, durn_for_leave_from_sos2, Leave_Mandatory);"></td>
				<td class='label' width='45%'>&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;<input type=text size=1 maxlength=2 name='durn_for_leave_from_sos1' id='durn_for_leave_from_sos1' onblur='CheckForHours(this)' onkeypress="return allowPositiveNumber()" readonly> : 	<input type=text size=1 maxlength=2 name='durn_for_leave_from_sos2' id='durn_for_leave_from_sos2' onblur='CheckForMinutes(this,durn_for_leave_from_sos1);' onkeypress="return allowPositiveNumber()" readonly>&nbsp;<img id="Leave_Mandatory" src="../../eCommon/images/mandatory.gif" style="visibility:hidden">&nbsp;</td>	
			</tr>
			<tr><td>&nbsp;</td>
				<td class='label' width='20%'><fmt:message key="Common.cancel.label" bundle="${common_labels}"/>&nbsp&nbsp&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='checkbox' name='curr_shift_cancellation_yn' id='curr_shift_cancellation_yn' onclick="checkActive1(this, durn_for_cancel_from_sos1, durn_for_cancel_from_sos2, Cancel_Mandatory);"></td>
				<td class='label' width='45%'>&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;<input type=text size=1 maxlength=2 name='durn_for_cancel_from_sos1' id='durn_for_cancel_from_sos1' onblur='CheckForHours(this)' onkeypress="return allowPositiveNumber()"> : <input type=text size=1 maxlength=2 name='durn_for_cancel_from_sos2' id='durn_for_cancel_from_sos2' onblur='CheckForMinutes(this,durn_for_cancel_from_sos1);' onkeypress="return allowPositiveNumber()">&nbsp;<img id="Cancel_Mandatory" src="../../eCommon/images/mandatory.gif" style="visibility:hidden">&nbsp;</td>	
			</tr>
<%	}
		else{
			if(mode.equals("2")){
 				
				//out.println("QueryString-------->"+request.getQueryString());
 				//out.println("facility_name-------->"+ java.net.URLDecoder.decode(new String(request.getParameter("facility_name").getBytes("8859_1"),"UTF8"), "UTF-8"));

				operation_type="modify";
				facility_id=request.getParameter("facility_id") == null ? "":request.getParameter("facility_id");
				facility_name=request.getParameter("facility_name") == null ? "":request.getParameter("facility_name");
			    facility_name=java.net.URLDecoder.decode(new String( facility_name.getBytes("8859_1"),"UTF-8"));
			 	
				String overlap_shifts_in_workplace_yn=request.getParameter("overlap_shifts_in_workplace_yn") == null ? "":request.getParameter("overlap_shifts_in_workplace_yn");
				String work_cycle_basis=request.getParameter("work_cycle_basis") == null ? "":request.getParameter("work_cycle_basis");
				String period_for_work_schedule_gen=request.getParameter("period_for_work_schedule_gen") == null ? "":request.getParameter("period_for_work_schedule_gen");
				String max_continuous_work_duration=request.getParameter("max_continuous_work_duration") == null ? "":request.getParameter("max_continuous_work_duration");
				String staff_subs_same_grade_yn=request.getParameter("staff_subs_same_grade_yn") == null ? "":request.getParameter("staff_subs_same_grade_yn");
				String staff_subs_high_to_low_yn=request.getParameter("staff_subs_high_to_low_yn") == null ? "":request.getParameter("staff_subs_high_to_low_yn");
				String staff_subs_low_to_high_yn=request.getParameter("staff_subs_low_to_high_yn") == null ? "":request.getParameter("staff_subs_low_to_high_yn");
				String attendance_feature_reqd_yn=request.getParameter("attendance_feature_reqd_yn") == null ? "":request.getParameter("attendance_feature_reqd_yn");
				String max_durn_to_mark_attendance=request.getParameter("max_durn_to_mark_attendance") == null ? "":request.getParameter("max_durn_to_mark_attendance");
				String vald_staff_acc_by_work_sch_yn=request.getParameter("vald_staff_acc_by_work_sch_yn") == null ? "":request.getParameter("vald_staff_acc_by_work_sch_yn");
				String vald_staff_acc_by_att_yn=request.getParameter("vald_staff_acc_by_att_yn") == null ? "":request.getParameter("vald_staff_acc_by_att_yn");
				String curr_shift_allocation_yn=request.getParameter("curr_shift_allocation_yn") == null ? "":request.getParameter("curr_shift_allocation_yn");
				String curr_shift_change_yn=request.getParameter("curr_shift_change_yn") == null ? "":request.getParameter("curr_shift_change_yn");
				String curr_shift_cancellation_yn=request.getParameter("curr_shift_cancellation_yn") == null ? "":request.getParameter("curr_shift_cancellation_yn");
				String curr_shift_transfer_yn=request.getParameter("curr_shift_transfer_yn") == null ? "":request.getParameter("curr_shift_transfer_yn");
				String curr_shift_swap_yn=request.getParameter("curr_shift_swap_yn") == null ? "":request.getParameter("curr_shift_swap_yn");
				String curr_shift_overtime_yn=request.getParameter("curr_shift_overtime_yn") == null ? "":request.getParameter("curr_shift_overtime_yn");
				String curr_shift_leave_yn=request.getParameter("curr_shift_leave_yn") == null ? "":request.getParameter("curr_shift_leave_yn");
				String durn_for_allocation_from_sos=request.getParameter("durn_for_allocation_from_sos") == null ? "":request.getParameter("durn_for_allocation_from_sos");
				String durn_for_change_from_sos=request.getParameter("durn_for_change_from_sos") == null ? "":request.getParameter("durn_for_change_from_sos");
				String durn_for_transfer_from_sos=request.getParameter("durn_for_transfer_from_sos") == null ? "":request.getParameter("durn_for_transfer_from_sos");
				String durn_for_swap_from_sos=request.getParameter("durn_for_swap_from_sos") == null ? "":request.getParameter("durn_for_swap_from_sos");
				String durn_for_overtime_from_sos=request.getParameter("durn_for_overtime_from_sos") == null ? "":request.getParameter("durn_for_overtime_from_sos");
				String durn_for_leave_from_sos=request.getParameter("durn_for_leave_from_sos") == null ? "":request.getParameter("durn_for_leave_from_sos");
				String durn_for_cancel_from_sos=request.getParameter("durn_for_cancel_from_sos") == null ? "":request.getParameter("durn_for_cancel_from_sos");

				String max_continuous_work_duration1="";
				String max_continuous_work_duration2="";
				String durn_for_allocation_from_sos1="";
				String durn_for_allocation_from_sos2="";
				String durn_for_change_from_sos1="";
				String durn_for_change_from_sos2="";
				String durn_for_transfer_from_sos1="";
				String durn_for_transfer_from_sos2="";
				String durn_for_swap_from_sos1="";
				String durn_for_swap_from_sos2="";
				String durn_for_overtime_from_sos1="";
				String durn_for_overtime_from_sos2="";
				String durn_for_leave_from_sos1="";
				String durn_for_leave_from_sos2="";
				String durn_for_cancel_from_sos1="";
				String durn_for_cancel_from_sos2="";
				String max_durn_to_mark_attendance1="";
				String max_durn_to_mark_attendance2="";
				String selected="";
%>
				<table cellpadding=3 cellspacing=0 border=0 width="100%" align='center'>

					<tr>
						<td  width="50%" class="label"><fmt:message key="Common.facility.label" bundle="${common_labels}"/> </td>
						<td>&nbsp;&nbsp;<input type='text' name='facility_name' id='facility_name' value='<%=facility_name%>' readonly size='20'></td>
							<td></td>
							<input type='hidden' name='facility_id' id='facility_id' value=<%=facility_id%>>
					</tr>
					<tr>
						<td  width="50%" class="label"><fmt:message key="eRS.AllowOverlapofShiftsinaWorkplace.label" bundle="${rs_labels}"/></td>
<%
						if(overlap_shifts_in_workplace_yn.equalsIgnoreCase("Y")){
%>
							<td>&nbsp;<input type=checkbox name="overlap_shifts_in_workplace_yn" id="overlap_shifts_in_workplace_yn"  onclick="checkActive(this)" checked value=<%=overlap_shifts_in_workplace_yn%>    ></td>
<%
						}
						else{
%>
							<td>&nbsp;<input type=checkbox name="overlap_shifts_in_workplace_yn" id="overlap_shifts_in_workplace_yn"  onclick="checkActive(this)"  value=<%=overlap_shifts_in_workplace_yn%>    ></td>
<%
						}
%>
						<td></td>
						</tr>
						<tr>
							<td  width="50%" class="label"><fmt:message key="eRS.WorkCycleBasis.label" bundle="${rs_labels}"/></td>
							<td>&nbsp;
							<select name='work_cycle_basis' id='work_cycle_basis'>

								<option value=''>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
<% 
								selected=work_cycle_basis.equalsIgnoreCase("1W")?"selected":"";
%>
								<option value='1W' <%=selected%>>1 <fmt:message key="Common.weekly.label" bundle="${common_labels}"/></option>
							</select>&nbsp;<img src="../../eCommon/images/mandatory.gif">&nbsp;
							</td>
							<td></td>
						</tr>
						<tr>
							<td  width="50%" class="label"><fmt:message key="eRS.PeriodaheadforWorkSchedulecreation.label" bundle="${rs_labels}"/></td>
							<td class='label'>&nbsp;&nbsp;&nbsp;<input type='text' name='period_for_work_schedule_gen' id='period_for_work_schedule_gen' size='2' maxlength='3' value='<%=period_for_work_schedule_gen%>' onkeypress="return allowPositiveNumber()" onblur='checkForZero(this);'><font color='navy'><fmt:message key="Common.days.label"bundle="${common_labels}"/></font>&nbsp;<img src="../../eCommon/images/mandatory.gif">&nbsp;</td>
							<td></td>
						</tr>
						<tr>
							<td  width="50%" class="label"><fmt:message key="eRS.Maximumcontinuousdurationstaffcanwork.label" bundle="${rs_labels}"/></td>
							<td class='label'>&nbsp;&nbsp;
<%
							if(max_continuous_work_duration.equals("")){
									max_continuous_work_duration1="";
									max_continuous_work_duration2="";

							}else{
								max_continuous_work_duration1=max_continuous_work_duration.substring(0,2);
								max_continuous_work_duration2=max_continuous_work_duration.substring(3);
							}
%>
							<input type=text size=1 maxlength=2 name='max_continuous_work_duration1' id='max_continuous_work_duration1' onblur='CheckForHours(this)' value='<%=max_continuous_work_duration1%>' onkeypress="return allowPositiveNumber()"> : 
					
							<input type=text size=1 maxlength=2 name='max_continuous_work_duration2' id='max_continuous_work_duration2' onblur='CheckForMinutes(this,max_continuous_work_duration1)' value='<%=max_continuous_work_duration2%>' onkeypress="return allowPositiveNumber()">(hh:mi)&nbsp;<img src="../../eCommon/images/mandatory.gif">&nbsp;</td>
							<td></td>
						</tr>
						<tr>	
<%
						if(staff_subs_same_grade_yn.equalsIgnoreCase("Y")){
%>	
							<td  width="50%" class="label"><fmt:message key="eRS.StaffSubstitutionBasis.label" bundle="${rs_labels}"/>:</td>
							<td class='label'>&nbsp;&nbsp;<input type='checkbox' name='staff_subs_same_grade_yn' id='staff_subs_same_grade_yn' onclick="checkActive(this)" checked value='<%=staff_subs_same_grade_yn%>'><fmt:message key="eRS.WithinsameGrade.label" bundle="${rs_labels}"/></td>
							<td></td>
<%
						}
						else{
%>
							<td  width="50%" class="label"><fmt:message key="eRS.StaffSubstitutionBasis.label" bundle="${rs_labels}"/>:</td>
							<td class='label'>&nbsp;&nbsp;<input type='checkbox' name='staff_subs_same_grade_yn' id='staff_subs_same_grade_yn' onclick="checkActive(this)" value='<%=staff_subs_same_grade_yn%>'><fmt:message key="eRS.WithinsameGrade.label" bundle="${rs_labels}"/></td>
							<td></td>
<%
						}
						if(staff_subs_high_to_low_yn.equalsIgnoreCase("Y")){
%>
							</tr>
							<tr>
								<td width='50%'>&nbsp;</td>
								<td class="label">&nbsp;&nbsp;<input type='checkbox' name='staff_subs_high_to_low_yn' id='staff_subs_high_to_low_yn' onclick="checkActive(this)" checked value='<%=staff_subs_high_to_low_yn%>'><fmt:message key="eRS.LowtoHighGrade.label" bundle="${rs_labels}"/></td>
								<td></td>
<%
						}
						else{
%>
							</tr>
							<tr>
								<td width='50%'>&nbsp;</td>
								<td class="label">&nbsp;&nbsp;<input type='checkbox' name='staff_subs_high_to_low_yn' id='staff_subs_high_to_low_yn' onclick="checkActive(this)" value='<%=staff_subs_high_to_low_yn%>'><fmt:message key="eRS.LowtoHighGrade.label" bundle="${rs_labels}"/></td>
								<td></td>
<%
						}
						if(staff_subs_high_to_low_yn.equalsIgnoreCase("Y")){
%>
							</tr>
							<tr>
								<td width='50%'>&nbsp;</td>				
								<td class="label">&nbsp;&nbsp;<input type='checkbox' name='staff_subs_low_to_high_yn' id='staff_subs_low_to_high_yn' onclick="checkActive(this)" checked value='<%=staff_subs_low_to_high_yn%>'><fmt:message key="eRS.HightoLowGrade.label" bundle="${rs_labels}"/></td>
								<td></td>
<%
						}
						else{
%>
							</tr>
							<tr>
								<td width='50%'>&nbsp;</td>
								<td class="label">&nbsp;&nbsp;<input type='checkbox' name='staff_subs_low_to_high_yn' id='staff_subs_low_to_high_yn' onclick="checkActive(this)" value='<%=staff_subs_low_to_high_yn%>'><fmt:message key="eRS.HightoLowGrade.label" bundle="${rs_labels}"/></td>
								<td></td>
<%
						}
%>
						</tr>
						<tr>
							<td  width="50%" class="label"><fmt:message key="eRS.AttendanceFeatureRequired.label" bundle="${rs_labels}"/></td>
<%
							if(attendance_feature_reqd_yn.equalsIgnoreCase("Y")){
%>
								<td>&nbsp;&nbsp;<input type='checkbox' name='attendance_feature_reqd_yn' id='attendance_feature_reqd_yn' onclick="checkActive1(this, max_durn_to_mark_attendance1, max_durn_to_mark_attendance2, Max_Durn_Mandatory);" checked value='<%=attendance_feature_reqd_yn%>'>
<%
							}
							else{
%>
								<td>&nbsp;&nbsp;<input type='checkbox' name='attendance_feature_reqd_yn' id='attendance_feature_reqd_yn' onclick="checkActive1(this, max_durn_to_mark_attendance1, max_durn_to_mark_attendance2, Max_Durn_Mandatory);" value='<%=attendance_feature_reqd_yn%>'>
<%
							}
%>
							<td></td>
						</tr>
						<tr>
<%
						if(max_durn_to_mark_attendance.equals("")){
								max_durn_to_mark_attendance1="";
								max_durn_to_mark_attendance2="";

						}else{
							max_durn_to_mark_attendance1=max_durn_to_mark_attendance.substring(0,2);
							max_durn_to_mark_attendance2=max_durn_to_mark_attendance.substring(3);
						}
%>
				<td  width="50%" class="label"><fmt:message key="eRS.Maxdurationfromstartofshifttomarkattendance.label" bundle="${rs_labels}"/></td><td class='label'>&nbsp;&nbsp;&nbsp;<input type=text size=1 maxlength=2 name='max_durn_to_mark_attendance1' id='max_durn_to_mark_attendance1' onblur='CheckForHours(this)' onkeypress="return allowPositiveNumber()" value='<%=max_durn_to_mark_attendance1%>'>&nbsp;:&nbsp;<input type=text size=1 maxlength=2 name='max_durn_to_mark_attendance2' id='max_durn_to_mark_attendance2' onblur='CheckForMinutes(this,max_durn_to_mark_attendance2);checkForblank(this, max_durn_to_mark_attendance1);' onkeypress="return allowPositiveNumber()" value='<%=max_durn_to_mark_attendance2%>'>(hh:mi)&nbsp;<img id="Max_Durn_Mandatory" src="../../eCommon/images/mandatory.gif" style="display:none" <%=readOnly%>></td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td  width="50%" class="label"><fmt:message key="eRS.ValidatestaffaccessrightsbyAttendance.label" bundle="${rs_labels}"/></td>
<%
				if(vald_staff_acc_by_work_sch_yn.equalsIgnoreCase("Y")){
%>
					<td>&nbsp;&nbsp;<input type='checkbox' name='vald_staff_acc_by_work_sch_yn' id='vald_staff_acc_by_work_sch_yn' onclick="checkActive(this)" checked value='<%=vald_staff_acc_by_work_sch_yn%>'>
<%
				}
				else{
%>
					<td>&nbsp;&nbsp;<input type='checkbox' name='vald_staff_acc_by_work_sch_yn' id='vald_staff_acc_by_work_sch_yn' onclick="checkActive(this)" value='<%=vald_staff_acc_by_work_sch_yn%>'>
<%
				}
%>
				<td></td>
			</tr>
			
			<tr>
				<td  width="50%" class="label"><fmt:message key="eRS.ValidatestaffaccessrightsbyWorkSchedule.label" bundle="${rs_labels}"/></td>
<%
				if(vald_staff_acc_by_att_yn.equalsIgnoreCase("Y")){
%>
					<td>&nbsp;&nbsp;<input type='checkbox' name='vald_staff_acc_by_att_yn' id='vald_staff_acc_by_att_yn' onclick="checkActive(this)" checked value='<%=vald_staff_acc_by_att_yn%>'>
<%
				}
				else{
%>
					<td>&nbsp;&nbsp;<input type='checkbox' name='vald_staff_acc_by_att_yn' id='vald_staff_acc_by_att_yn' onclick="checkActive(this)" value='<%=vald_staff_acc_by_att_yn%>'>
<%
				}
%>
				<td></td>
			</tr>
			</table>
			<table cellpadding=3 cellspacing=0 border=0 width="100%" align='center'>
			<tr >
				<td class='label' width='35%' ><b><fmt:message key="eRS.Activitiesallowedonactiveshift.label" bundle="${rs_labels}"/>:</b></td>
				<td width='20%' >&nbsp;</td>
				<td class='label' width='65%'><b><fmt:message key="eRS.Durationfromstartofshift.label" bundle="${rs_labels}"/>&nbsp;&nbsp;(hh:mi)</td>
			<tr><td>&nbsp;</td>
<%
			if(curr_shift_allocation_yn.equalsIgnoreCase("Y")){
				readOnly="";
%>
				<td class='label'><fmt:message key="eRS.Allocate.label" bundle="${rs_labels}"/>&nbsp&nbsp&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='checkbox' name='curr_shift_allocation_yn' id='curr_shift_allocation_yn' onclick="ModifycheckActive(this, durn_for_allocation_from_sos1, durn_for_allocation_from_sos2, Allocate_Mandatory);" checked value='<%=curr_shift_allocation_yn%>'></td>
<%
			}
			else{
				readOnly="readonly";
%>
				<td class='label'><fmt:message key="eRS.Allocate.label" bundle="${rs_labels}"/>&nbsp&nbsp&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='checkbox' name='curr_shift_allocation_yn' id='curr_shift_allocation_yn' onclick="ModifycheckActive(this, durn_for_allocation_from_sos1, durn_for_allocation_from_sos2, Allocate_Mandatory);" value='<%=curr_shift_allocation_yn%>' ></td>
<%
			}
%>
			<td class='label' width='45%'>&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;
<%
			if(durn_for_allocation_from_sos.equals("")){ 	
				 durn_for_allocation_from_sos1="";
				 durn_for_allocation_from_sos2="";
			}else{ 
				durn_for_allocation_from_sos1=durn_for_allocation_from_sos.substring(0,2);
				durn_for_allocation_from_sos2=durn_for_allocation_from_sos.substring(3);
			}
%>
			<input type=text size=1 maxlength=2 name='durn_for_allocation_from_sos1' id='durn_for_allocation_from_sos1' onblur='CheckForHours(this)' value='<%=durn_for_allocation_from_sos1%>' onkeypress="return allowPositiveNumber()" <%=readOnly%>> : 
			<input type=text size=1 maxlength=2 name='durn_for_allocation_from_sos2' id='durn_for_allocation_from_sos2' onblur='CheckForMinutes(this,durn_for_change_from_sos1);' value='<%=durn_for_allocation_from_sos2%>' onkeypress="return allowPositiveNumber()" <%=readOnly%>>&nbsp;<img id="Allocate_Mandatory" src="../../eCommon/images/mandatory.gif" style="display:none" <%=readOnly%>>&nbsp;</td>	
			</tr>
			<tr><td>&nbsp;</td>
<%
			if(curr_shift_change_yn.equalsIgnoreCase("Y")){
				readOnly="";
%>
				<td class='label' width='20%'><fmt:message key="Common.change.label" bundle="${common_labels}"/>&nbsp&nbsp&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='checkbox' name='curr_shift_change_yn' id='curr_shift_change_yn' value='<%=curr_shift_change_yn%>' checked onclick="ModifycheckActive(this, durn_for_change_from_sos1, durn_for_change_from_sos2, Change_Mandatory);"></td>
<%
			}
			else{
				readOnly="readOnly";
%>
				<td class='label' width='20%'><fmt:message key="Common.change.label" bundle="${common_labels}"/>&nbsp&nbsp&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='checkbox' name='curr_shift_change_yn' id='curr_shift_change_yn' value='<%=curr_shift_change_yn%>' onclick="ModifycheckActive(this, durn_for_change_from_sos1, durn_for_change_from_sos2, Change_Mandatory);"></td>
<%
			}
%>
			<td class='label' width='45%'>&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;
<%
			if(durn_for_change_from_sos.equals("")){	
				durn_for_change_from_sos1="";
				durn_for_change_from_sos2="";
			}else{  	
				durn_for_change_from_sos1=durn_for_change_from_sos.substring(0,2);
				durn_for_change_from_sos2=durn_for_change_from_sos.substring(3);
			}
%>
			<input type=text size=1 maxlength=2 name='durn_for_change_from_sos1' id='durn_for_change_from_sos1' onblur='CheckForHours(this)' value='<%=durn_for_change_from_sos1%>' onkeypress="return allowPositiveNumber()" <%=readOnly%>> : 
			<input type=text size=1 maxlength=2 name='durn_for_change_from_sos2' id='durn_for_change_from_sos2' onblur='CheckForMinutes(this,durn_for_change_from_sos1);' value='<%=durn_for_change_from_sos2%>' onkeypress="return allowPositiveNumber()" <%=readOnly%> >&nbsp;<img id="Change_Mandatory" src="../../eCommon/images/mandatory.gif" style="display:none">&nbsp;</td>	
			</tr>
			<tr><td>&nbsp;</td>
<%
			if(curr_shift_transfer_yn.equalsIgnoreCase("Y")){
				readOnly="";
%>
				<td class='label' width='20%'><fmt:message key="Common.Transfer.label" bundle="${common_labels}"/>&nbsp&nbsp&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='checkbox' name='curr_shift_transfer_yn' id='curr_shift_transfer_yn' onclick="ModifycheckActive(this, durn_for_transfer_from_sos1, durn_for_transfer_from_sos2, Transfer_Mandatory);" checked value='<%=curr_shift_transfer_yn%>'></td>
<%
			}
			else{
				readOnly="readOnly";
%>
				<td class='label' width='20%'><fmt:message key="Common.Transfer.label" bundle="${common_labels}"/>&nbsp&nbsp&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='checkbox' name='curr_shift_transfer_yn' id='curr_shift_transfer_yn' onclick="ModifycheckActive(this, durn_for_transfer_from_sos1, durn_for_transfer_from_sos2, Transfer_Mandatory);" value='<%=curr_shift_transfer_yn%>'></td>
<%
			}
%>					
			<td class='label' width='45%'>&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;
<%
			if(durn_for_transfer_from_sos.equals("")){
				durn_for_transfer_from_sos1="";
				durn_for_transfer_from_sos2="";
			}else{
				durn_for_transfer_from_sos1=durn_for_transfer_from_sos.substring(0,2);
				durn_for_transfer_from_sos2=durn_for_transfer_from_sos.substring(3);
			}
%>
			<input type=text size=1 maxlength=2 name='durn_for_transfer_from_sos1' id='durn_for_transfer_from_sos1' onblur='CheckForHours(this)' value='<%=durn_for_transfer_from_sos1%>' onkeypress="return allowPositiveNumber()" <%=readOnly%>> : 
			<input type=text size=1 maxlength=2 name='durn_for_transfer_from_sos2' id='durn_for_transfer_from_sos2' onblur='CheckForMinutes(this,durn_for_transfer_from_sos1);' value='<%=durn_for_transfer_from_sos2%>' onkeypress="return allowPositiveNumber()" <%=readOnly%>>&nbsp;<img id="Transfer_Mandatory" src="../../eCommon/images/mandatory.gif" style="display:none">&nbsp;</td>	
			</tr>
			<tr><td>&nbsp;</td>
<%
			if(curr_shift_swap_yn.equalsIgnoreCase("Y")){
				readOnly="";
%>
				<td class='label' width='20%'><fmt:message key="eRS.Swap.label" bundle="${rs_labels}"/>&nbsp&nbsp&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='checkbox' onclick="ModifycheckActive(this, durn_for_swap_from_sos1, durn_for_swap_from_sos2, Swap_Mandatory);" name='curr_shift_swap_yn' id='curr_shift_swap_yn' checked value='<%=curr_shift_swap_yn%>'></td>
<%
			}
			else{
				readOnly="readOnly";
%>
				<td class='label' width='20%'><fmt:message key="eRS.Swap.label" bundle="${rs_labels}"/>&nbsp&nbsp&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='checkbox' onclick="ModifycheckActive(this, durn_for_swap_from_sos1, durn_for_swap_from_sos2, Swap_Mandatory);" name='curr_shift_swap_yn' id='curr_shift_swap_yn' value='<%=curr_shift_swap_yn%>'></td>
<%
			}
%>
			<td class='label' width='45%'>&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;
<%
			if(durn_for_swap_from_sos.equals(""))	{
				durn_for_swap_from_sos1="";
				durn_for_swap_from_sos2="";
			}else{	
				 durn_for_swap_from_sos1=durn_for_swap_from_sos.substring(0,2);
				durn_for_swap_from_sos2=durn_for_swap_from_sos.substring(3);
			}
%>
			<input type=text size=1 maxlength=2 name='durn_for_swap_from_sos1' id='durn_for_swap_from_sos1' onblur='CheckForHours(this)' value='<%=durn_for_swap_from_sos1%>' onkeypress="return allowPositiveNumber()" <%=readOnly%>> : 
			<input type=text size=1 maxlength=2 name='durn_for_swap_from_sos2' id='durn_for_swap_from_sos2' onblur='CheckForMinutes(this,durn_for_swap_from_sos1);' value='<%=durn_for_swap_from_sos2%>' onkeypress="return allowPositiveNumber()" <%=readOnly%>>&nbsp;<img id="Swap_Mandatory" src="../../eCommon/images/mandatory.gif" style="display:none">&nbsp;</td>	
			</tr>
			<tr><td>&nbsp;</td>
<%
			if(curr_shift_overtime_yn.equalsIgnoreCase("Y")){
				readOnly="";
%>
				<td class='label' width='20%'><fmt:message key="eRS.Overtime.label" bundle="${rs_labels}"/>&nbsp&nbsp&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='checkbox' onclick="ModifycheckActive(this, durn_for_overtime_from_sos1, durn_for_overtime_from_sos2, Overtime_Mandatory);" name='curr_shift_overtime_yn' id='curr_shift_overtime_yn' checked value='<%=curr_shift_overtime_yn%>'></td>
<%
			}
			else{
				readOnly="readOnly";
%>
				<td class='label' width='20%'><fmt:message key="eRS.Overtime.label" bundle="${rs_labels}"/>&nbsp&nbsp&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='checkbox' onclick="ModifycheckActive(this, durn_for_overtime_from_sos1, durn_for_overtime_from_sos2, Overtime_Mandatory);" name='curr_shift_overtime_yn' id='curr_shift_overtime_yn' value='<%=curr_shift_overtime_yn%>'></td>
<%
			}
%>
			<td class='label' width='45%'>&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;
<%
			if(durn_for_overtime_from_sos.equals("")){
				durn_for_overtime_from_sos1="";
				durn_for_overtime_from_sos2="";
			}else{
				durn_for_overtime_from_sos1=durn_for_overtime_from_sos.substring(0,2);
				durn_for_overtime_from_sos2=durn_for_overtime_from_sos.substring(3);
			}
%>
			<input type=text size=1 maxlength=2 name='durn_for_overtime_from_sos1' id='durn_for_overtime_from_sos1' onblur='CheckForHours(this)' value='<%=durn_for_overtime_from_sos1%>' onkeypress="return allowPositiveNumber()" <%=readOnly%>> : 
			<input type=text size=1 maxlength=2 name='durn_for_overtime_from_sos2' id='durn_for_overtime_from_sos2' onblur='CheckForMinutes(this,durn_for_overtime_from_sos1);' value='<%=durn_for_overtime_from_sos2%>' onkeypress="return allowPositiveNumber()" <%=readOnly%>>&nbsp;<img id="Overtime_Mandatory" src="../../eCommon/images/mandatory.gif" style="display:none">&nbsp;</td>	
			</tr>
			<tr><td>&nbsp;</td>
<%
			if(curr_shift_leave_yn.equalsIgnoreCase("Y")){
				readOnly="";
%>
				<td class='label' width='20%'><fmt:message key="Common.Leave.label" bundle="${common_labels}"/>&nbsp&nbsp&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;<input type='checkbox' name='curr_shift_leave_yn' id='curr_shift_leave_yn'  onclick="ModifycheckActive(this, durn_for_leave_from_sos1, durn_for_leave_from_sos2, Leave_Mandatory);" value='<%=curr_shift_leave_yn%>' checked></td>
<%
			}
			else{
				readOnly="readOnly";
%>
				<td class='label' width='20%'><fmt:message key="Common.Leave.label" bundle="${common_labels}"/>&nbsp&nbsp&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;<input type='checkbox' name='curr_shift_leave_yn' id='curr_shift_leave_yn'  onclick="ModifycheckActive(this, durn_for_leave_from_sos1, durn_for_leave_from_sos2, Leave_Mandatory);" value='<%=curr_shift_leave_yn%>'></td>
<%
			}
%>
				<td class='label' width='45%'>&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;
<%
			if(durn_for_leave_from_sos.equals("")){
				 durn_for_leave_from_sos1="";
				 durn_for_cancel_from_sos2="";
			}else{				
				durn_for_leave_from_sos1=durn_for_leave_from_sos.substring(0,2);
				durn_for_leave_from_sos2=durn_for_leave_from_sos.substring(3);
			}
%>
			<input type=text size=1 maxlength=2 name='durn_for_leave_from_sos1' id='durn_for_leave_from_sos1' onblur='CheckForHours(this)' value='<%=durn_for_leave_from_sos1%>' onkeypress="return allowPositiveNumber()" <%=readOnly%>> : 
			<input type=text size=1 maxlength=2 name='durn_for_leave_from_sos2' id='durn_for_leave_from_sos2' onblur='CheckForMinutes(this,durn_for_leave_from_sos1);' value='<%=durn_for_leave_from_sos2%>' onkeypress="return allowPositiveNumber()" <%=readOnly%>>&nbsp;<img id="Leave_Mandatory" src="../../eCommon/images/mandatory.gif" style="display:none" >&nbsp;</td>	
			</tr>
			<tr><td>&nbsp;</td>
<%
			if(curr_shift_cancellation_yn.equalsIgnoreCase("Y")){
				readOnly="";
%>
				<td class='label' width='20%'><fmt:message key="Common.cancel.label" bundle="${common_labels}"/>&nbsp&nbsp&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='checkbox' name='curr_shift_cancellation_yn' id='curr_shift_cancellation_yn' onclick="ModifycheckActive(this, durn_for_cancel_from_sos1, durn_for_cancel_from_sos2, Cancel_Mandatory);" value='<%=curr_shift_cancellation_yn%>' checked></td>
<%
			}
			else{
				readOnly="readOnly";
%>
				<td class='label' width='20%'><fmt:message key="Common.cancel.label" bundle="${common_labels}"/>&nbsp&nbsp&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='checkbox' name='curr_shift_cancellation_yn' id='curr_shift_cancellation_yn' onclick="ModifycheckActive(this, durn_for_cancel_from_sos1, durn_for_cancel_from_sos2, Cancel_Mandatory);" value='<%=curr_shift_cancellation_yn%>'></td>
<%
			}
%>
			<td class='label' width='45%'>&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;
<%
			if(durn_for_cancel_from_sos.equals("")){
				 durn_for_cancel_from_sos1="";
				 durn_for_cancel_from_sos2="";
			}else{				
				 durn_for_cancel_from_sos1=durn_for_cancel_from_sos.substring(0,2);
				 durn_for_cancel_from_sos2=durn_for_cancel_from_sos.substring(3);
			}
%>
			<input type=text size=1 maxlength=2 name='durn_for_cancel_from_sos1' id='durn_for_cancel_from_sos1' onblur='CheckForHours(this)' value='<%=durn_for_cancel_from_sos1%>' onkeypress="return allowPositiveNumber()" <%=readOnly%>> : 
			<input type=text size=1 maxlength=2 name='durn_for_cancel_from_sos2' id='durn_for_cancel_from_sos2' onblur='CheckForMinutes(this,durn_for_cancel_from_sos1);' value='<%=durn_for_cancel_from_sos2%>' onkeypress="return allowPositiveNumber()" <%=readOnly%>>&nbsp;<img id="Cancel_Mandatory" src="../../eCommon/images/mandatory.gif" style="display:none">&nbsp;</td>	
			</tr>
<%
		}
		else{
			operation_type="delete";
		}
	}
%>
</table>
<input type='hidden' name='operation_type' id='operation_type' value='<%=operation_type%>'>
<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
<input type='hidden' name='sparams' id='sparams' value='<%=sparams%>'>
</form>
</body>
</html>

