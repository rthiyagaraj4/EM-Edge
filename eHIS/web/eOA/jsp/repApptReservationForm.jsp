<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="com.ehis.util.*,java.util.*,java.sql.*,java.text.*,webbeans.eCommon.*,org.json.simple.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 


<html>
<HEAD>
<TITLE></TITLE>
<%
          String sStyle =
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		  
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src="../js/repApptReservation.js" language="JavaScript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</HEAD>
<%
     request.setCharacterEncoding("UTF-8");
	String p_module_id		= "OA" ;
	String p_report_id		= "OAAPTRES" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
%>
<body OnMouseDown='CodeArrest()' onKeyDown='lockKey()' onload='FocusFirstElement()'>
<form name="repApptReservationForm" id="repApptReservationForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
                <br>
                <br>
				<table width='10%' align='center' valign='top' border='0'>
			    <tr>
				        <td class="label" nowrap><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					    <td align='center' class="label"><fmt:message key="Common.Summary.label" bundle="${common_labels}"/></td>
						<td width='5%'><input type='radio' id='sum_id' name='p_sum_dtl_yn'  value = 'S' checked onClick="reporttypeselec(this,user_label,user_text,user_button,orderby_label,orderby_opt); reportopt(this);"></td>
						<td align='center' class="label"><fmt:message key="Common.Detail.label" bundle="${common_labels}"/></td>
						<td><input type='radio' id='detail_id' name='p_sum_dtl_yn' value = 'D'  onClick="reporttypeselec(this,user_label,user_text,user_button,orderby_label,orderby_opt); reportopt(this);"></td>
               
			    </tr>
	            </table>
				<table width='80%' align='center' valign='top' >
	<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
	<tr>
		<td width="100%" class="Border" align='center'>
			<table width='80%' cellPadding="0" cellSpacing="0"  align='center' border='0'>
				<tr>
					<td align="center" width="15%">&nbsp;</td>
					<td class="querydata" width="20%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td class="querydata" width="40%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>

		<tr>
			<td class="label"><fmt:message key="Common.apptdate.label" bundle="${common_labels}"/></td>

			<td class='fields'>
				<input type="text" id='apptdatefrom' name="p_fm_appt_date" id="p_fm_appt_date" size="10" maxlength="10" onBlur="ValidateDate(this);"><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('apptdatefrom');">
				<img src='../../eCommon/images/mandatory.gif'></img>
			</td>


			<td class='fields'>
				<input type="text" id='apptdateto' name="p_to_appt_date" id="p_to_appt_date" size="10" maxlength="10" onBlur="DateCompare_apply(p_fm_appt_date,this);DateCompare1(p_fm_appt_date,p_to_appt_date); ValidateDate(this);"><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('apptdateto');DateCompare_apply(p_fm_appt_date,this);DateCompare1(p_fm_appt_date,p_to_appt_date);">
				<img src='../../eCommon/images/mandatory.gif'></img>
			</td>

			<tr>
			<td>&nbsp;</td>
		 	</tr>
				
	        <tr>
	          <td class='label'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
              <td class='fields'>
                 <input type=text  name='p_rep_facility_value' id='p_rep_facility_value' id='fac_text' size="15" maxlength="15" align="center" onblur='if(this.value !="") searchCode(rep_facility1,this)'><input type='button' name='rep_facility1' id='rep_facility1' id='fac_button' value='?' class='button' onclick='searchCode(this,p_rep_facility_value)'>
              </td>			
	        </tr>
	       <tr>
	       <td>&nbsp;</td>
	       </tr>
		   <tr>
				<td align='left' class="label" id='stafftype_label'><fmt:message key="Common.StaffType.label" bundle="${common_labels}"/></td>
				<td width='10%'><select name="p_staff_type" id="p_staff_type" id='stafftype_opt' onchange="OthStaffType(this,oth_staff_type,p_oth_staff_type,oth_label,oth_mand);" >
				<option value="">-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----
				<option value="A"><fmt:message key="Common.OtherStaff.label" bundle="${common_labels}"/></option>
				<option value="B"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>
				</select><img src='../../eCommon/images/mandatory.gif' id='oth_mand1'></img></td>

				<td class="label" nowrap id='oth_label' style="visibility:hidden"><fmt:message key="Common.OtherStaffType.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <input type="text" name="p_oth_staff_type" id="p_oth_staff_type" style="visibility:hidden" id='oth_text' size="30" OnBlur='ChangeUpperCase(this);if(this.value != "") searchCode(oth_staff_type,this);'><input type='button' align='left' id='oth_button' name="oth_staff_type" id="oth_staff_type" style="visibility:hidden" value='?' class='button' onclick='searchCode(this,p_oth_staff_type)'><img src='../../eCommon/images/mandatory.gif' id='oth_mand' style="visibility:hidden"></img>
                </td>
		   </tr>

		   <tr>
	       <td>&nbsp;</td>
	       </tr>

           <tr>
				<td width='20%' class="label" id='user_label' style="visibility:hidden"><fmt:message key="Common.user.label" bundle="${sm_labels}"/></td>
				<td width='10%' class='fields'><input type="text" name="p_user" id='user_text' size="30" OnBlur='ChangeUpperCase(this);if(this.value != "") searchCode(p_sm_user,this,p_staff_type);' style="visibility:hidden"><input type='button' align='left' name='p_sm_user' id='user_button' style="visibility:hidden" value='?' class='button' onclick='searchCode(this,p_user,p_staff_type)'></td>
		   </tr>

		   <tr>
		   <td>&nbsp;</td>
		   </tr>
           
		   <tr>
                <td class='label' id='orderby_label' style="visibility:hidden"><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
				<td width='10%'><select name='p_order_by' id='orderby_opt' style="visibility:hidden">
			    <option value="1"><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/>
				<option value="2"><fmt:message key="Common.AppointmentDate.label" bundle="${common_labels}"/>
				</select></td>
		   </tr>
		</tr>
			</table>	
                
		<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
		<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
		<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
		<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
           
</form>
</body>
</html>

