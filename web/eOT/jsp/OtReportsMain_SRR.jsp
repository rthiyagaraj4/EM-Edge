<!DOCTYPE html>
 
<%@ page import= "java.text.*,java.sql.Types,java.sql.Statement,java.sql.CallableStatement,java.sql.Connection,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ page language="java"%>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src="../../eOT/js/OtReports.js" ></script>
	<script src="../../eCommon/js/dchk.js" ></script>
	<script src="../../eCommon/js/common.js" ></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script src="../../eOT/js/OTCommon.js" ></script>
	<script src="../../eCommon/js/ValidateControl.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String function_id = request.getParameter("function_id");
	String source = url + params ;
	String url_name = "";
	String facility_id  = (String) session.getValue("facility_id");
	Connection con=null;
	CallableStatement cstmt = null;
	String modules_list = "";
	String ca_module_yn="";

	try{
		con = ConnectionManager.getConnection(request);
	// Check for CA Module Existence
		cstmt=con.prepareCall("{call GET_OPERATIONAL_MODULES(?,?)}");
		cstmt.setString(1,facility_id);
		cstmt.registerOutParameter(2,Types.VARCHAR);
		cstmt.execute();
		modules_list=cstmt.getString(2);
		if(modules_list.indexOf("OR|")>=0)
			ca_module_yn="Y";	// When CA is  Operational
		else
			ca_module_yn="N";	// When CA is not Operational
	}catch(Exception e){
		out.println(e);
	}finally { 
		if(cstmt !=null) cstmt.close();
		ConnectionManager.returnConnection(con,request);
	}
	String ca_alert_required_yn = "N";

	if(function_id.equals("OT_OPERATION_LIST")){
		ca_alert_required_yn = "Y";
		url_name = "OperationListReports.jsp";
	}else if(function_id.equals("OT_RGSTR_OPER")){
		ca_alert_required_yn="Y";
		url_name = "OperationRegisterReports.jsp";
	}else if(function_id.equals("OT_OPER_BY_OT_ROOM")){
		ca_alert_required_yn="Y";
		url_name = "OperationByOtRoomReports.jsp";
	}else if(function_id.equals("OT_OPER_BY_SURGEON")){
		ca_alert_required_yn="Y";
		url_name = "OperationBySurgeonReports.jsp";
	}else if(function_id.equals("OT_OPER_BY_ANAESTHETIST")){
		ca_alert_required_yn="Y";
		url_name = "OperationByAnaesthetistReports.jsp";
	}else if(function_id.equals("OT_IMPLANT_REGISTRY")){
		ca_alert_required_yn="Y";
		url_name = "ImplantRegistryReports.jsp";
	}else if(function_id.equals("OT_REGISTRY_BDY_PART_SPECIMEN")){
		ca_alert_required_yn="Y";
		url_name = "RegistryBodyPartsNonSpecimenReports.jsp";
	}else if(function_id.equals("OT_SPECIMEN_REGISTER")){
		ca_alert_required_yn="Y";
		url_name = "SpecimenRegisterReports_SRR.jsp";
	}else if(function_id.equals("OT_EMERGENCY_OPERATIONS")){
		ca_alert_required_yn="Y";
		url_name = "EmergencyOperationsReports_SRR.jsp";
	}else if(function_id.equals("OT_OPERATION_NOTES")){
		ca_alert_required_yn="Y";
		url_name = "OperationNotesReports.jsp";
	}else if(function_id.equals("OT_TH_BKG_STAT_OTROOM")){
		url_name = "TheatreBkgStatByOtRoomReports.jsp";
	}else if(function_id.equals("OT_TH_BKG_STAT_SURGEON")){
		url_name = "TheatreBkgStatByOtSurgeonReports.jsp";
	}else if(function_id.equals("OT_TH_BKGS_BY_SURGEON")){
		url_name = "TheatreBookingsBySurgeonReports.jsp";
	}else if(function_id.equals("OT_TH_BKGS_BY_OTROOM")){
		url_name = "TheatreBookingsByOtRoomReports.jsp";
	}else if(function_id.equals("OT_PAT_TOBE_ADMITTED")){
		url_name = "PatientsToBeAdmittedForOperReports.jsp";
	}else if(function_id.equals("OT_WAITLIST_REPORT_BY_DSS")){
		url_name = "WaitlistReports.jsp";
	}else if(function_id.equals("OT_CANCELLED_BOOKINGS")){
		url_name = "CancelledBookingsReports.jsp";
	}else if(function_id.equals("OT_SMRY_OF_OPER_BY_SURGEON")){
		ca_alert_required_yn="Y";
		url_name = "SummaryOfOperBySurgeonReports.jsp";
	}else if(function_id.equals("OT_WAITING_TIME_BYSURGEON")){
		url_name = "WaitingTimeBySurgeonReports.jsp";
	}else if(function_id.equals("OT_SMRY_OF_OPER_BY_ANAESTH")){
		ca_alert_required_yn="Y";
		url_name = "SmryOfOperByAnaesthetistReports.jsp";
	}else if(function_id.equals("OT_SUR_AVG_TIME")){
		ca_alert_required_yn="Y";
		url_name = "SurgeonsOperTimeStatReports.jsp";
	}else if(function_id.equals("OT_BOOKING_SUMMARY")){
		url_name = "BookingSummaryReport.jsp";
	}else if(function_id.equals("OT_OPER_WITHOUT_OPER_DTLS")){
		ca_alert_required_yn="Y";
		url_name = "OperWithoutPostOperDtlsReports.jsp";
	}else if(function_id.equals("OT_OPERATIVE_MORTALITY")){
		ca_alert_required_yn="Y";
		url_name = "OperativeMortalityReports.jsp";
	}else if(function_id.equals("OT_NOTIF_LIST_BY_OTROOM")){
		url_name = "NotifListByOtRoomReports.jsp";
	}else if(function_id.equals("OT_NOTIF_LIST_BY_WARD")){
		url_name = "NotifListByWardReports.jsp";
	}else if(function_id.equals("OT_STAT_BY_SPECIALITY")){
		ca_alert_required_yn="Y";
		url_name = "StatBySpecialityReports.jsp";
	}else if(function_id.equals("OT_STAT_BY_OPER_TYPES")){
		ca_alert_required_yn="Y";
		url_name = "StatByOperationTypesReports.jsp";
	}else if(function_id.equals("OT_STAT_BY_OPER_DURATION")){
		ca_alert_required_yn="Y";
		url_name = "StatByOperDurationReports.jsp";
	}else if(function_id.equals("OT_ANESTH_TYPE_PROC")){
		ca_alert_required_yn="Y";
		url_name = "AnesthGivenForSurgeryTypeReports.jsp";
	}else if(function_id.equals("OT_ANESTH_REGISTRY")){
		ca_alert_required_yn="Y";
		url_name = "AnesthesiaRegistryReports_SRR.jsp";
	}else if(function_id.equals("OT_STAT_BY_OPER_TYPE_SPLTY")){
		ca_alert_required_yn="Y";
		url_name = "StatbyOperTypeSpltyReports.jsp";
	}else if(function_id.equals("OT_ICU_BED_REQUIRED")){
		url_name = "IcdBedReservationsReports.jsp";
	}else if(function_id.equals("OT_OTMS_BY_SURGERY_TYPE")){
		ca_alert_required_yn="Y";
		url_name = "OtmsBySurgeryTypeReports.jsp";
	}else if(function_id.equals("OT_OTMS_BY_OPER_TYPE")){
		ca_alert_required_yn="Y";
		url_name = "OtmsByOperationTypeReports.jsp";
	}else if(function_id.equals("OT_BCP_REPORTS")){
		ca_alert_required_yn="Y";
		url_name = "OtBcpReports.jsp";
	}else if(function_id.equals("OT_CANCELLED_REGISTRATIONS")){
		ca_alert_required_yn="Y";
		url_name = "CancelledRegistrationsReports_SRR.jsp";
	}else if(function_id.equals("OT_SURG_AVG_OPRTG_TIME")){
		ca_alert_required_yn="Y";
		url_name = "SurgeonsAvgOperatingTimeReports_SRR.jsp";
	}else if(function_id.equals("OT_SMRY_OF_OPER_BY_OTROOM")){
		ca_alert_required_yn="Y";
		url_name = "SummaryOfOperByOtRoomReports_SRR.jsp";
	}else if(function_id.equals("OT_THEATER_UTILIZATION")){
		ca_alert_required_yn="Y";
		url_name = "TheatreUtilizationReports_SRR.jsp";
	}else if(function_id.equals("OT_AVG_TIME_FOR_PROCEDURE")){
		ca_alert_required_yn="Y";
		url_name = "AvgTimeTakenForProceduresReports_SRR.jsp";
	}else if(function_id.equals("OT_TYPE_OF_ANAESTHESIA")){
		ca_alert_required_yn="Y";
		url_name = "OTScheduleReports.jsp";
	}else if(function_id.equals("OT_SMRY_OPER_BY_NURSE")){
		ca_alert_required_yn="Y";
		url_name = "SummaryOfOperByNurseReports.jsp";
	}else if(function_id.equals("OT_UNSCHOPERATION_LIST")){
		ca_alert_required_yn="Y";
		url_name = "UnscheduledOperationReports.jsp";
	}else if(function_id.equals("OT_UNUSUAL_OCCURRENCE")){
		ca_alert_required_yn="Y";
		url_name = "UnusualOccurrenceReports.jsp";
	}else if(function_id.equals("OT_WAITING_TIME_BY_ADMIT")){
		ca_alert_required_yn="Y";
		url_name = "OTWaitingTimeByAdmitReports.jsp";
	}else if(function_id.equals("OT_WAITING_TIME_IN_OR")){
		ca_alert_required_yn="Y";
		url_name = "OTWaitingTimeInORtReports.jsp";
	}
	url_name="../../eOT/jsp/"+url_name+"?"+params;

%>
    <iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %> scrolling='no' noresize style="height:8vh;width:100vw" frameborder='0'>
	<%
		if(function_id.equals("CASE_SLIP")){
	%>
			<iframe scrolling="no" name='f_query_rep' id='f_query_rep' src='../../eOT/jsp/CaseSlipReports.jsp'  style="height:85vh;width:100vw" frameborder='0'></iframe>
	<%
		}else if(ca_module_yn.equals("N") && ca_alert_required_yn.equals("Y")){
	%>
		<script>
			alert(getMessage("CA_NOT_INSTALLED","Common"));
			window.location.href = "../../eCommon/jsp/dmenu.jsp";
		</script>
	<%
		}else{
	%>
			<iframe scrolling="no" name='f_query_rep' id='f_query_rep' src=<%=url_name%>  style="height:85vh;width:100vw" frameborder='0'></iframe>					
	<%
		}
	%>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' noresize scrolling='auto' style="height:7vh;width:100vw" frameborder='0'></iframe>
		<!-- added on 2/18/2011 by Anitha-->
	<iframe name='dummy_rep_frame' id='dummy_rep_frame' src="../../eCommon/html/blank.html" noresize scrolling='no' style="height:0vh;width:100vw" frameborder='0'></iframe>


</html>

