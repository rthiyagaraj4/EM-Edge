<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.net.*, webbeans.eCommon.*,eCommon.Common.*,eDS.Common.JSONObject,eDS.Common.JSONArray" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%

Connection con=null;
con=ConnectionManager.getConnection(request);
String specialityListsJsonArr				= "";
String locale								= (String)session.getAttribute("LOCALE");
String facilityID							= (String)session.getValue("facility_id");
try{
	request.setCharacterEncoding("UTF-8");

		String alIdLegendsJsonArr			= "";
		alIdLegendsJsonArr					= eOA.PatientPortalBean.getAltIdLegends(con,locale);	
		JSONObject altIdLegendsObj			= new JSONObject(alIdLegendsJsonArr);
		String alt_id1_type_desc			= altIdLegendsObj.getString("alt_id1_type_desc");
		String alt_id2_type_desc			= altIdLegendsObj.getString("alt_id2_type_desc");
		String alt_id3_type_desc			= altIdLegendsObj.getString("alt_id3_type_desc");
		String alt_id4_type_desc			= altIdLegendsObj.getString("alt_id4_type_desc");
		String nat_id_prompt				= altIdLegendsObj.getString("nat_id_prompt");
		String accept_national_id_no_yn		= altIdLegendsObj.getString("accept_national_id_no_yn");
		String mode							= "insert";


		String max_appt_patient_per_day		= "";
		String adv_max_appt_limits			= "";   
		String adv_min_appt_limits			= ""; 
		String nat_id_enabled_yn			= "N";  
		String alt_id1_enabled_yn			= "N";                
		String alt_id2_enabled_yn			= "N";                
		String alt_id3_enabled_yn			= "N";                
		String alt_id4_enabled_yn			= "N";  
		String isRowAvailable				= "";

		String booking_reason					= ""; 
		String rescheduling_reason				= ""; 
		String cancelling_reason				= ""; 
		String booking_reason_change_yn			= "N"; 
		String rescheduling_reason_change_yn	= "N"; 
		String cancelling_reason_change_yn		= "N"; 
		String max_appt_per_patient				= ""; 


		String portalBookingCtrlsJsonArr	= "";
		portalBookingCtrlsJsonArr			= eOA.PatientPortalBean.getBookingCtrlsData(con);
		JSONObject portalBookingCtrlsObj	= new JSONObject(portalBookingCtrlsJsonArr);
		isRowAvailable						= portalBookingCtrlsObj.getString("isRowAvailable");
		if(isRowAvailable.equals("Y")){
			max_appt_patient_per_day		= portalBookingCtrlsObj.getString("max_appt_patient_per_day");
		    adv_max_appt_limits				= portalBookingCtrlsObj.getString("adv_max_appt_limits"); 
			adv_min_appt_limits				= portalBookingCtrlsObj.getString("adv_min_appt_limits"); 
			nat_id_enabled_yn				= portalBookingCtrlsObj.getString("nat_id_enabled_yn");
			alt_id1_enabled_yn				= portalBookingCtrlsObj.getString("alt_id1_enabled_yn");
			alt_id2_enabled_yn				= portalBookingCtrlsObj.getString("alt_id2_enabled_yn");
			alt_id3_enabled_yn				= portalBookingCtrlsObj.getString("alt_id3_enabled_yn");
			alt_id4_enabled_yn				= portalBookingCtrlsObj.getString("alt_id4_enabled_yn");
			booking_reason					= portalBookingCtrlsObj.getString("booking_reason"); 
			rescheduling_reason				= portalBookingCtrlsObj.getString("rescheduling_reason");
			cancelling_reason				= portalBookingCtrlsObj.getString("cancelling_reason");
			booking_reason_change_yn		= portalBookingCtrlsObj.getString("booking_reason_change_yn");
			rescheduling_reason_change_yn	= portalBookingCtrlsObj.getString("rescheduling_reason_change_yn");
			cancelling_reason_change_yn		= portalBookingCtrlsObj.getString("cancelling_reason_change_yn");
			max_appt_per_patient			= portalBookingCtrlsObj.getString("max_appt_per_patient");

			mode							= "modify";
		}

	
		
		String bookingReasonListsJsonArr	= eOA.PatientPortalBean.getReason(con,locale,"booking");
		JSONObject bookingReasonListsObj	= new JSONObject(bookingReasonListsJsonArr);
		JSONArray bookingReasonListsArray 	= bookingReasonListsObj.getJSONArray("results");
		
		String reschedulingReasonListsJsonArr	= eOA.PatientPortalBean.getReason(con,locale,"reschedule");
		JSONObject reschedulingReasonListsObj	= new JSONObject(reschedulingReasonListsJsonArr);
		JSONArray reschedulingReasonListsArray 	= reschedulingReasonListsObj.getJSONArray("results");
		
		String cancellingReasonListsJsonArr	= eOA.PatientPortalBean.getReason(con,locale,"cancel");
		JSONObject cancellingReasonListsObj	= new JSONObject(cancellingReasonListsJsonArr);
		JSONArray cancellingReasonListsArray 	= cancellingReasonListsObj.getJSONArray("results");






%>		 
	<head>	
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%><script src='../../eOA/js/PortalBookingCtrls.js' language='javascript'></script>
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eOA/patientportal/Style.css'></link>


	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<script>
		$( document ).ready(function() {
		 $('select.autowidth')
        .bind('click', function () {
            $(this).toggleClass('autowidth-clicked');
        } )
        .bind('change', function () {
            if( $(this).find('option:selected').text().length > 32){
				$(this).addClass('autowidth-expand');
				$(this).removeClass('autowidth-clicked');
			}
        } )
       .bind('mouseout', function () {
            if (!$(this).hasClass('autowidth-clicked')) {
                $(this).removeClass('autowidth-expand');
            }
        } )
        .bind('blur', function () {
            $(this).removeClass('autowidth-expand autowidth-clicked');
        } );

		});

	</script>
	<style>
		select.autowidth {
		width: 200px; 
		}

		select.autowidth.autowidth-expand {
		width: auto;
		z-index: 9999;
		position: absolute;
		}
	
	</style>
	</head>
	<body OnMouseDown="CodeArrest();" onKeyDown = 'lockKey()'>
	<form name="config_form" id="config_form" id="config_form"  method="post" >
	<span id="width_tmp"></span>
	<table cellpadding='7' cellspacing='0' width='100%' border='0'>
	<tr>
		<th colspan='4' class='COLUMNHEADER' align='left' style='color:white'><fmt:message key="eOA.AppointmentBookingControls.label" bundle="${oa_labels}"/></th>
	</tr>
  
		<tr>
			<td class = 'label'  width = '15%' nowrap><fmt:message key="eOA.MaxBookingPerPatient.label" bundle="${oa_labels}"/></td>
				<td width='85%' class='fields' colspan='3' >
					<input type='text' name="maxBookingPerPatient" id="maxBookingPerPatient" id="maxBookingPerPatient" maxlength="2" onKeyPress='return allowValidNumber(this,event,3,0);' onblur="return isNumber(this)" size='5' value="<%=max_appt_per_patient%>"/>
					<img align='center' src='../../eCommon/images/mandatory.gif'></img>
			</td>
		</tr>
		<tr>
			<td class = 'label'  width = '15%' nowrap><fmt:message key="eOA.MAxBookingPerPatientPerDay.label" bundle="${oa_labels}"/></td>
				<td width='85%' class='fields' colspan='3' >
					<input type='text' name="maxBookingPerPatientPerDay" id="maxBookingPerPatientPerDay" id="maxBookingPerPatientPerDay" maxlength="1" onKeyPress='return allowValidNumber(this,event,3,0);' onblur="return isNumber(this)" size='5' value="<%=max_appt_patient_per_day%>"/>
					<img align='center' src='../../eCommon/images/mandatory.gif'></img>
			</td>
		</tr>
		<tr>
			<td class = 'label'  width = '15%' nowrap><fmt:message key="eOA.AdvanceBookinglimits.label" bundle="${oa_labels}"/>&nbsp;(<fmt:message key="Common.Minimum.label" bundle="${common_labels}"/>)</td>
			<td width='85%' class='fields' colspan='3' >
				<input type='text' name="advanceBookinglimitsMin" id="advanceBookinglimitsMin" id="advanceBookinglimitsMin" maxlength="1" onKeyPress='return allowValidNumber(this,event,1,0);' onblur="return isNumber(this)" size='5' value="<%=adv_min_appt_limits%>"/><img align='center' src='../../eCommon/images/mandatory.gif'></img>
			</td>
		</tr>
		<tr>
			<td class = 'label'  width = '15%' nowrap><fmt:message key="eOA.AdvanceBookinglimits.label" bundle="${oa_labels}"/>&nbsp;(<fmt:message key="Common.maximum.label" bundle="${common_labels}"/>)</td>
			<td width='85%' class='fields' colspan='3' >
				<input type='text' name="advanceBookinglimitsMax" id="advanceBookinglimitsMax" id="advanceBookinglimitsMax" maxlength="2" onKeyPress='return allowValidNumber(this,event,2,0);' onblur="return isNumber(this)" size='5'  value="<%=adv_max_appt_limits%>"/><img align='center' src='../../eCommon/images/mandatory.gif'></img>
			</td>
		</tr>
		<tr>
			<th colspan='4' class='COLUMNHEADER' align='left' style='color:white'><fmt:message key="eOA.AlternateIDsToValidateForPatientMapping.label" bundle="${oa_labels}"/></th>
		</tr>
		<%if(!alt_id1_type_desc.equals("")){%>
			<tr>
				<td class = 'label'  width = '15%' nowrap><%=alt_id1_type_desc%></td>
				<td width='85%' class='fields' colspan='3' >
					<input type="checkbox" name="alt_id1_yn" id="alt_id1_yn" id="alt_id1_yn" <%if(alt_id1_enabled_yn.equals("Y")){%> checked="checked"<%}%>/>
				</td>
			</tr>
		<%}

		 if(!alt_id2_type_desc.equals("")){%>
			<tr>
				<td class = 'label'  width = '15%' nowrap><%=alt_id2_type_desc%></td>
				<td width='85%' class='fields' colspan='3' >
					<input type="checkbox" name="alt_id2_yn" id="alt_id2_yn" id="alt_id2_yn" <%if(alt_id2_enabled_yn.equals("Y")){%> checked="checked"<%}%> />
				</td>
			</tr>
		<%}
		if(!alt_id3_type_desc.equals("")){%>

			<tr>
				<td class = 'label'  width = '15%' nowrap><%=alt_id3_type_desc%></td>
				<td width='85%' class='fields' colspan='3' >
					<input type="checkbox" name="alt_id3_yn" id="alt_id3_yn" id="alt_id3_yn" <%if(alt_id3_enabled_yn.equals("Y")){%> checked="checked"<%}%> />
				</td>
			</tr>
		<%}

		 if(!alt_id4_type_desc.equals("")){%>

			<tr>
				<td class = 'label'  width = '15%' nowrap><%=alt_id4_type_desc%></td>
				<td width='85%' class='fields' colspan='3' >
					<input type="checkbox" name="alt_id4_yn" id="alt_id4_yn" id="alt_id4_yn" <%if(alt_id4_enabled_yn.equals("Y")){%> checked="checked"<%}%> />
				</td>
			</tr>
		<%}
		if(!nat_id_prompt.equals("") && accept_national_id_no_yn.equals("Y")){%>

			<tr>
				<td class = 'label'  width = '15%' nowrap><%=nat_id_prompt%></td>
				<td width='85%' class='fields' colspan='3' >
					<input type="checkbox" name="nat_id_prompt_yn" id="nat_id_prompt_yn" id="nat_id_prompt_yn" <%if(nat_id_enabled_yn.equals("Y")){%> checked="checked"<%}%> />
				</td>
			</tr>
		<%}%>

	<tr>
		<th colspan='4' class='COLUMNHEADER' align='left' style='color:white'><fmt:message key="eOA.DefaultReasons.label" bundle="${oa_labels}"/></th>
	</tr>
	<tr>
		<td class = 'label'  width = '15%' nowrap> <fmt:message key="eOA.ReasonForBookingAppointment.label" bundle="${oa_labels}"/>
		<td width='30%' class='fields'>
			<select id="booking_reason" class="autowidth">

				<option value=''>------------ Select ------------</option>
			   <%
				for(int i = 0 ; i < bookingReasonListsArray.length() ; i++){
					String code					= bookingReasonListsArray.getJSONObject(i).getString("code");
					String description			= bookingReasonListsArray.getJSONObject(i).getString("description");%>
					<option value="<%=code%>" <%if(booking_reason.equals(code)){%>selected<%}%> ><%=description%></option>
				<%}%>
			</select> <img align='center' src='../../eCommon/images/mandatory.gif'></img>
		</td>
		<td width='15%' class='label'>
			<fmt:message key="eOA.AllowPatientToChange.label" bundle="${oa_labels}"/>
		</td>
		<td width='40%' class='fields'>
			<input type="checkbox" name="booking_reason_change_yn" id="booking_reason_change_yn" id="booking_reason_change_yn" <%if(booking_reason_change_yn.equals("Y")){%> checked="checked"<%}%> />
		</td>
	</tr>
	<tr>
		<td class = 'label'  width = '15%' nowrap> <fmt:message key="eOA.ReasonForReschedulingAppointment.label" bundle="${oa_labels}"/>
		<td width='30%' class='fields'>
			<select id="rescheduling_reason"  class="autowidth">
				<option value=''>------------ Select ------------</option>
			   <%
				for(int i = 0 ; i < reschedulingReasonListsArray.length() ; i++){
					String code					= reschedulingReasonListsArray.getJSONObject(i).getString("code");
					String description			= reschedulingReasonListsArray.getJSONObject(i).getString("description");%>
					<option value="<%=code%>" <%if(rescheduling_reason.equals(code)){%>selected<%}%> ><%=description%></option>
				<%}%>
			</select> <img align='center' src='../../eCommon/images/mandatory.gif'></img>
		</td>
		<td width='15%' class='label'>
			<fmt:message key="eOA.AllowPatientToChange.label" bundle="${oa_labels}"/>
		</td>
		<td width='40%' class='fields'>
			<input type="checkbox" name="rescheduling_reason_change_yn" id="rescheduling_reason_change_yn" id="rescheduling_reason_change_yn"  <%if(rescheduling_reason_change_yn.equals("Y")){%> checked="checked"<%}%> />
		</td>
	</tr>
	<tr>
		<td class = 'label'  width = '15%' nowrap> <fmt:message key="eOA.ReasonForCancellingAppointment.label" bundle="${oa_labels}"/>
		<td width='30%' class='fields'>
			<select id="cancelling_reason"   class="autowidth">
				<option value=''>------------ Select ------------</option>
			   <%
				for(int i = 0 ; i < cancellingReasonListsArray.length() ; i++){
					String code					= cancellingReasonListsArray.getJSONObject(i).getString("code");
					String description			= cancellingReasonListsArray.getJSONObject(i).getString("description");%>
					<option value="<%=code%>" <%if(cancelling_reason.equals(code)){%>selected<%}%> ><%=description%></option>
				<%}%>
			</select> <img align='center' src='../../eCommon/images/mandatory.gif'></img>
		</td>
		<td width='15%' class='label'>
			<fmt:message key="eOA.AllowPatientToChange.label" bundle="${oa_labels}"/>
		</td>
		<td width='40%' class='fields'>
			<input type="checkbox" name="cancelling_reason_change_yn" id="cancelling_reason_change_yn" id="cancelling_reason_change_yn" <%if(cancelling_reason_change_yn.equals("Y")){%> checked="checked"<%}%> />
		</td>
	</tr>
		
	</table>
	<input type='hidden' name='mode' id='mode' id='mode' value='<%=mode%>' />
</form> 
 	
<%}catch(Exception e){
	e.printStackTrace();
}finally{ 
	if(con != null) {
		ConnectionManager.returnConnection(con,request);
	}
}%>

</body>
</html>


