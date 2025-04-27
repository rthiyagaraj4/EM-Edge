
<!DOCTYPE html>
<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); 
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff"); %>
<html>
<% 
int adm_date_chk_days_int = 0;
String max_disch_period_for_dc	= checkForNull((String)request.getParameter("max_disch_period_for_dc"));
String back_date				= checkForNull((String)request.getParameter("back_date"));
String callfunc					= checkForNull((String)request.getParameter("P_call_func"));
String returnvalue				= checkForNull((String)request.getParameter("P_retval"));
String patientid				= checkForNull((String)request.getParameter("patient_id"));
String f_nursing_unit			= checkForNull((String)request.getParameter("f_nursing_unit"));
String oper_stn_id				= checkForNull((String)request.getParameter("oper_stn_id"));
String register_pat_in_admn_yn	= checkForNull((String)request.getParameter("register_pat_in_admn_yn"));
String bl_interfaced_yn			= checkForNull((String)request.getParameter("bl_interfaced_yn"));	
String nurs_unt_auth_val		= checkForNull((String)request.getParameter("nurs_unt_auth_val"));	
String backdated_admission_yn	= checkForNull((String)request.getParameter("backdated_admission_yn"));	
String deactivate_pseudo_bed_yn	= checkForNull((String)request.getParameter("deactivate_pseudo_bed_yn"));	
String allowed_admission_type	= checkForNull((String)request.getParameter("allowed_admission_type"));	
String adm_date_chk_days		= checkForNull((String)request.getParameter("adm_date_chk_days"));	

if(!adm_date_chk_days.equals(""))
	adm_date_chk_days_int = Integer.parseInt(adm_date_chk_days);

String adm_date_chk_days_type	= checkForNull((String)request.getParameter("adm_date_chk_days_type"));	
String bkg_grace_period			= checkForNull((String)request.getParameter("bkg_grace_period"));	
String pat_checkin_yn			= checkForNull((String)request.getParameter("pat_checkin_yn"));	
String called_from			= checkForNull((String)request.getParameter("called_from"));	
String noshow_bkng_period   = checkForNull(request.getParameter("noshow_bkng_period"));//Added for Bru-HIMS-CRF-153 [IN:030273] by Srinivas
//below code added for ABM CRF 643.1 ICN:36736
String from_adv_bed_mgmt			= checkForNull((String)request.getParameter("from_adv_bed_mgmt"),"N");//modified for the incident 41661
String bedNo			= checkForNull((String)request.getParameter("bedNo"));
String nursing_unit			= checkForNull((String)request.getParameter("nursing_unit"));
String appl_patient_class			= checkForNull((String)request.getParameter("appl_patient_class"));

	/*Below line Added for this CRF  Bru-HIMS-CRF-261*/
	String quick_admission_type	= checkForNull((String)request.getParameter("quick_admission_type"));
	String quick_adm_referralid	= checkForNull((String)request.getParameter("quick_adm_referralid"));
	String quick_adm= checkForNull((String)request.getParameter("quick_adm"));
	String ref_encounter_id=checkForNull((String)request.getParameter("ref_encounter_id"));
	
String reason_reqd_Flag = checkForNull((String)request.getParameter("reason_reqd_Flag")); //Modified against MMS-QH-CRF-0144
%>	
<head>
<script language='javascript' src='../../eCommon/js/showModalDialog.js'></script>
</head>
<iframe name="Select_frame" id="Select_frame" src="../jsp/AdmitPatientSelect.jsp?P_call_func=<%=callfunc%>&P_retval=<%=returnvalue%>&patient_id=<%=patientid%>&oper_stn_id=<%=oper_stn_id%>&register_pat_in_admn_yn=<%=register_pat_in_admn_yn%>&bkg_grace_period=<%=bkg_grace_period%>&allowed_admission_type=<%=allowed_admission_type%>&called_from=<%=called_from%>&bl_interfaced_yn=<%=bl_interfaced_yn%>&noshow_bkng_period=<%=noshow_bkng_period%>&from_adv_bed_mgmt=<%=from_adv_bed_mgmt%>&bedNo=<%=bedNo%>&nursing_unit=<%=nursing_unit%>&appl_patient_class=<%=appl_patient_class%>&quick_admission_type=<%=quick_admission_type%>&quick_adm_referralid=<%=quick_adm_referralid%>&quick_adm=<%=quick_adm%>&ref_encounter_id=<%=ref_encounter_id%>" frameborder=0 noresize scrolling=NO style="height:17vh;width:98vw"></iframe>
<iframe src="../../eCommon/html/blank.html" name="Pline_frame" id="Pline_frame" frameborder=0 noresize scrolling=NO style="height:10vh;width:98vw;/* margin-top:0px; margin-bottom:0px;padding-top:0px; padding-bottom:0px"  */></iframe>
	<!-- modified for MMS-QH-CRF-0144 : passing reason_reqd_Flag parameter-- style="height:3%;width:98vw"> -->

	<iframe name="Main_frame" id="Main_frame"  src="addModifyAdmitPatient.jsp?P_call_func=<%=callfunc%>&P_retval=<%=returnvalue%>&patient_id=<%=patientid%>&max_disch_period_for_dc=<%=max_disch_period_for_dc%>&f_nursing_unit=<%=f_nursing_unit%>&oper_stn_id=<%=oper_stn_id%>&bl_interfaced_yn=<%=bl_interfaced_yn%>&adm_date_chk_days=<%=adm_date_chk_days_int%>&adm_date_chk_days_type=<%=adm_date_chk_days_type%>&bkg_grace_period=<%=bkg_grace_period%>&pat_checkin_yn=<%=pat_checkin_yn%>&nurs_unt_auth_val=<%=nurs_unt_auth_val%>&backdated_admission_yn=<%=backdated_admission_yn%>&deactivate_pseudo_bed_yn=<%=deactivate_pseudo_bed_yn%>&back_date=<%=java.net.URLEncoder.encode(back_date)%>&from_adv_bed_mgmt=<%=from_adv_bed_mgmt%>&bedNo=<%=bedNo%>&nursing_unit=<%=nursing_unit%>&appl_patient_class=<%=appl_patient_class%>&quick_admission_type=<%=quick_admission_type%>&quick_adm_referralid=<%=quick_adm_referralid%>&quick_adm=<%=quick_adm%>&ref_encounter_id=<%=ref_encounter_id%>&reason_reqd_Flag=<%=reason_reqd_Flag%>"  frameborder=0 noresize scrolling=no style="height:97vh;width:98vw"></iframe>
	<iframe src="../jsp/AdmitPatientButtons.jsp" name="Buttons_frame" id="Buttons_frame" frameborder=0 noresize scrolling=NO style="height:5vh;width:98vw"></iframe>
	<iframe src="../../eCommon/html/blank.html" name="dummy" id="dummy" frameborder=0 noresize scrolling=NO style="height:0vh;width:98vw"></iframe>

</html>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}

%>

