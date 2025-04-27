<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8"  import= "java.util.*,java.sql.*,java.text.*,java.net.*,webbeans.eCommon.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
	<title><fmt:message key="eIP.ChangeAdmissionDetails.label" bundle="${ip_labels}"/></title>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'</link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	function onSuccess(){
		self.frames[1].disableFields();
	}
	</script>

</head>
<%
		request.setCharacterEncoding("UTF-8");
        String facility				= (String) session.getValue( "facility_id" );
        String encounterid	 		= checkForNull(request.getParameter("encounterId"));        
		String patientid			= checkForNull(request.getParameter("patientId"));        
		String bl_install			= checkForNull(request.getParameter("bl_instal"));
		String call_function		= checkForNull(request.getParameter("call_function"));
		String deactivate_pseudo_bed_yn		= checkForNull(request.getParameter("deactivate_pseudo_bed_yn"));
		String pat_check_in_allowed_yn		= checkForNull(request.getParameter("pat_check_in_allowed_yn"));
		String oper_stn_id					=  checkForNull(request.getParameter("oper_stn_id"));
		String bl_interfaced_yn				=  checkForNull(request.getParameter("bl_interfaced_yn"));
		String cutt_off_time				=  checkForNull(request.getParameter("cutt_off_time"));
		String change_adm_dtls_duration		=  checkForNull(request.getParameter("change_adm_dtls_duration"));
		String max_disch_period_for_dc		=  checkForNull(request.getParameter("max_disch_period_for_dc"));



%>


	<iframe name='PLINE' id='PLINE' src='../../eCommon/jsp/pline.jsp?P_MODULE_ID=IP&P_FUNCTION_ID=MODIFY_SERVICE_FOR_INPATIENT&EncounterId=<%=encounterid%>&Facility_Id=<%=facility%>'  frameborder=no scrolling='no' style='height:10vh ;width:99vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' 	 src='ChangeAdmissionDetails.jsp?function_id=MODIFY_SERVICE_FOR_INPATIENT&encounter_id=<%=encounterid%>&patient_id=<%=patientid%>&bl_instal=<%=bl_install%>&call_function=<%=call_function%>&oper_stn_id=<%=oper_stn_id%>&deactivate_pseudo_bed_yn=<%=deactivate_pseudo_bed_yn%>&pat_check_in_allowed_yn=<%=pat_check_in_allowed_yn%>&bl_interfaced_yn=<%=bl_interfaced_yn%>&cutt_off_time=<%=cutt_off_time%>&change_adm_dtls_duration=<%=change_adm_dtls_duration%>&max_disch_period_for_dc=<%=max_disch_period_for_dc%>' frameborder=0  style='height:80vh ;width:99vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' 	 src='../../eCommon/jsp/error.jsp' frameborder=0 scrolling='auto' style='height:4vh;width:99vw'></iframe>

</html>
<%!
	public static String checkForNull(String inputString){
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue){
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

