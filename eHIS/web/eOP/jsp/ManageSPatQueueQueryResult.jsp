<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%// include file="MpatQMethods.jsp" %>

<%   
	
	request.setCharacterEncoding("UTF-8"); 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	StringBuffer sql = new StringBuffer();
	StringBuffer sql2 = new StringBuffer();
	StringBuffer sql3 = new StringBuffer();
	StringBuffer sqlmain = new StringBuffer();	
	String endOfRes = "1" ;
    StringBuffer sqlcnt=new StringBuffer();
    String str="";

	CallableStatement Cs_Lookup = null; 
	PreparedStatement pstmt=null;
    ResultSet rs                = null;  
    ResultSet rs1                = null;  //68508
    PreparedStatement pstmt1=null;  //68508
	String rfresh_param         ="";
    String Que="";
    String Vitalsign="";
    String ChkOut="";
    String p_loc_id ="";
	String p_loc_type="";
    String p_operator_station="";
    String p_emergency="";
    String facility_id			= (String) session.getValue( "facility_id" ) ;
    String login_user			= (String) session.getValue("login_user");
	String locale=(String)session.getAttribute("LOCALE"); 
	String p_gender				= "";
	String p_inc_prev_visits	= "";
	String p_appt_status		= "";
	String p_queue_date			= "";
    String p_pract_id="";
    String p_inc_check_out="";
    String p_enc_id="";
    String p_queue_no="";
    String p_patient_id="";
    String p_start_time="";
    String p_vis_type="";
    String p_speciality_code="";
	String QUEUE_ID="";
	String reason_desc="";
	String pkg_pat_yn = "N";
	String pkg_enc_yn = "N";
	String qms_call_count = "0";
	String episode_id	= "";// Added for MMS-QH-CRF-0126 [IN:041880] 
	String op_episode_visit_num	= "";// Added for MMS-QH-CRF-0126 [IN:041880] 
	//Added below line for this CRF Bru-HIMS-CRF-133
	boolean isPatEncMovement=false;
	String Sydate="";
	//End Bru-HIMS-CRF-133
	boolean isVirtConsVisit = false; //Added by Ajay Hatwate for ML-MMOH-CRF-1930
	
	/*Added by Thamizh selvi on 9th July 2018 against ML-MMOH-CRF-1058 Start*/
	String apptRemarks = "";
	boolean isIncRemarksLengthAppl = false;
	/*End*/
	String pract_id="";
	boolean chk_disp=true;
	boolean pract_val_disp=true;
	boolean room_num_disp=true;
	boolean isQMSapplicable=false;
	boolean isVIPimgpatfrontappl = false;//Added by Mujafar against ML-MMOH-CRF-1070
	String bl_install_yn = request.getParameter("bl_install_yn")==null?"N":request.getParameter("bl_install_yn");//added for Package Billing
	String package_bl_install_YN = request.getParameter("package_bl_install_YN")==null?"N":request.getParameter("package_bl_install_YN");
	String unionTwoWhereClause = request.getParameter("unionTwoWhereClause")==null?"":request.getParameter("unionTwoWhereClause");
	//String unionOneWhereClause = request.getParameter("unionOneWhereClause")==null?"":request.getParameter("unionOneWhereClause");
	
	String function_id = request.getParameter("function_id")==null?"N":request.getParameter("function_id");

	String mins1_for_wait_time = request.getParameter("mins1_for_wait_time")==null?"":request.getParameter("mins1_for_wait_time");
	
	int mins1_for_wait_time_int = Integer.parseInt(mins1_for_wait_time);

	String mins2_for_wait_time = request.getParameter("mins2_for_wait_time")==null?"":request.getParameter("mins2_for_wait_time");
	int mins2_for_wait_time_int = Integer.parseInt(mins2_for_wait_time);
	
	String action_on_pending_bill =request.getParameter("action_on_pending_bill")==null?"":request.getParameter("action_on_pending_bill");// Added For MMS-QH-CRF-0126 [IN:041880]
	
	String whereClause = request.getParameter("whereclause");
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
	String qms_interfaced_yn="N";
	String virtConsVisit = "";
	if(whereClause == null ) whereClause="";

	//if ( (whereClause == null || whereClause.equals("")) )
	//{
	p_loc_type			=	request.getParameter("loctype");
    p_loc_id             = request.getParameter("locid");
    p_pract_id           = request.getParameter("pract_id")==null?"":request.getParameter("pract_id");//added for Package Billing
    p_vis_type           = request.getParameter("vistype");	
    p_inc_check_out      = request.getParameter("checkout");	
    p_enc_id             = request.getParameter("encid")==null?"":request.getParameter("encid");
    p_queue_no           = request.getParameter("queueno")==null?"":request.getParameter("queueno");
    p_patient_id         = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
    p_speciality_code 	 =  request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code");//added for Package Billing
	
   	p_gender			 = request.getParameter("gender");
	p_inc_prev_visits	 = request.getParameter("inc_prev_visits");	
	p_appt_status        = request.getParameter("appt_status");
    p_start_time         = request.getParameter("starttime");
    p_emergency          = request.getParameter("emergency_patients_only");		
    virtConsVisit		 = request.getParameter("virtualConsultVisit"); //Added by Ajay Hatwate for ML-MMOH-CRF-1930
    
    if(p_start_time == null) p_start_time="";
    
    if(p_start_time.equals("")) p_start_time = "00:00";
    
    p_operator_station       = request.getParameter("operator_station");
    rfresh_param       = request.getParameter("refresh");  
  
    Que=request.getParameter("Que");
    Vitalsign=request.getParameter("Vitalsign");
    ChkOut = request.getParameter("ChkOut");

	//if (Vitalsign.equals("Vitalsign")  || ChkOut.equals("ChkOut"))

		 if (Vitalsign.equals("Vitalsign"))
		 {
			p_inc_check_out="N";
		 }
	/*}
	else
	{
	rfresh_param             = request.getParameter("refresh");
	Que=request.getParameter("Que");
	Vitalsign=request.getParameter("Vitalsign");
	ChkOut = request.getParameter("ChkOut");
	p_loc_type			=	request.getParameter("loctype");
	p_loc_id             = request.getParameter("locid");
	p_operator_station       = request.getParameter("operator_station");
	p_pract_id           = request.getParameter("pract_id")==null?"":request.getParameter("pract_id");  //added for Package Billing  
	p_inc_check_out          = request.getParameter("checkout");
	p_enc_id             = request.getParameter("encid")==null?"":request.getParameter("encid");//added for Package Billing
	p_queue_no           = request.getParameter("queueno")==null?"":request.getParameter("queueno");//added for Package Billing
	p_patient_id         = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");//added for Package Billing
	p_start_time         = request.getParameter("starttime");
	p_vis_type           = request.getParameter("vistype");	
	p_emergency         = request.getParameter("emergency_patients_only");
	p_speciality_code	= request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code");//added for Package Billing
	
	p_inc_prev_visits	 = request.getParameter("inc_prev_visits");	


}  */

%>

<!-- Below the jsp page is included for setting the color patterns for the Patient details shown depending on the patient class.-->

<%@include file="Color_Set.jsp"%>

<%
Connection conn = null;

try {

	conn=ConnectionManager.getConnection(request);
	isIncRemarksLengthAppl = eCommon.Common.CommonBean.isSiteSpecific(conn, "OA","INCREASE_APPT_REMARKS_LENGTH");//Added by Thamizh selvi on 9th July 2018 against ML-MMOH-CRF-1058
	
	isVIPimgpatfrontappl = eCommon.Common.CommonBean.isSiteSpecific(conn, "OA","VIP_IMG_PAT_NAME_FRONT_APPL");//Added by Mujafar against ML-MMOH-CRF-1070
	isVirtConsVisit = eCommon.Common.CommonBean.isSiteSpecific(conn, "OP","VIRTUAL_CONSULTATION");//Added by Ajay Hatwate for ML-MMOH-CRF-1930	
	
	//68508
	 String invokeMenstrualHistYN=""; 
	    pstmt1 = conn.prepareStatement("SELECT INVOKE_MENSTRUAL_HISTORY_YN FROM MP_PARAM");
	    rs1 = pstmt1.executeQuery();
	    if (rs1.next()){
	    	invokeMenstrualHistYN = rs1.getString("INVOKE_MENSTRUAL_HISTORY_YN");
	    }
	    if(pstmt1!=null) pstmt1.close();
	    if(rs1!=null) rs1.close();	
	//68508
  %>
<HTML>
<head>
<!--     <script src="../../eOP/js/menu.js" language="JavaScript1.2"></script>
 -->    <!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->


	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
	<script src="../../eOP/js/ManageSPatQueue.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>

    <script>
        var refreshparam
        var ChkOut
        var Vitalsign
    	refreshparam=<%=rfresh_param%>
		self.setInterval('callSamepage()',<%=rfresh_param%>)
		
	
		
       </script>
	</head>
	<body   onMouseDown="CodeArrest();" onKeyDown ='lockKey()'  style="overflow-y: hidden;">
	<form name='ManagePatQue' id='ManagePatQue'>
<%
try {
		
	//Added by Ajay Hatwate for MMS-DM-CRF-0210
    String hide_pat_unauth_pract = "N";
   	String access_res_pat_yn = "N";
    pstmt = conn.prepareStatement("select (select HIDE_PAT_UNAUTH_PRACT_YN from CA_PARAM_BY_FACILITY where facility_id = ?) hide_pat_unauth_pract_yn, (SELECT a.access_res_pat_yn FROM ca_access_view_restr_patient a WHERE a.practitioner_id = (SELECT func_role_id FROM sm_appl_user WHERE appl_user_id = ?) AND a.facility_id = ? AND (   (    a.access_from_date IS NULL AND a.access_to_date IS NOT NULL AND TO_DATE (SYSDATE, 'DD/MM/YYYY') <= TO_DATE (a.access_to_date, 'DD/MM/YYYY') ) OR (    a.access_from_date IS NOT NULL AND a.access_to_date IS NULL AND TO_DATE (SYSDATE, 'DD/MM/YYYY') >= TO_DATE (a.access_from_date, 'DD/MM/YYYY') ) OR (    a.access_from_date IS NOT NULL AND a.access_to_date IS NOT NULL AND TO_DATE (SYSDATE, 'DD/MM/YYYY') >= TO_DATE (a.access_from_date, 'DD/MM/YYYY') AND TO_DATE (SYSDATE, 'DD/MM/YYYY') <= TO_DATE (a.access_to_date, 'DD/MM/YYYY') ) ))access_res_pat_yn from dual ");
   	pstmt.setString(1, facility_id);
   	pstmt.setString(2, login_user);
   	pstmt.setString(3, facility_id);
   	rs = pstmt.executeQuery();
   	rs.next();
   	hide_pat_unauth_pract = checkForNull(rs.getString("hide_pat_unauth_pract_yn"),"N");
   	access_res_pat_yn = checkForNull(rs.getString("access_res_pat_yn"), "N");
    
    if(pstmt!=null) pstmt.close();
    if(rs!=null) rs.close();
	//End of MMS-DM-CRF-0210
	
	
	
		/*
		pstmt=conn.prepareStatement(" Select to_char(sysdate,'hh24:mi') from dual ");
        rs = pstmt.executeQuery();
        rs.next();
        hhmm=rs.getString(1);

		if(pstmt != null) pstmt.close();
		if(rs != null) rs.close();

		if(bl_install_yn.equals("Y")){
			pstmt=conn.prepareStatement("select PACKAGE_ENABLED_YN from bl_parameters where operating_facility_id='"+facility_id+"'");
			rs = pstmt.executeQuery();
			if(rs!=null && rs.next()){
				package_bl_install_YN=rs.getString("PACKAGE_ENABLED_YN")==null?"N":rs.getString("PACKAGE_ENABLED_YN");
			}
		}
		*/
/*Below line added for this CRF Bru-HIMS-CRF-133*/	
isPatEncMovement=eOP.QMSInterface.isSiteSpecific(conn,"OP","PATENC_MOVEMENT");	

//End Bru-HIMS-CRF-133
		//Added for the CRF - Bru-HIMS-CRF-172
	webbeans.op.PatientData patdata = new  webbeans.op.PatientData();
	patdata.setFacility_id(facility_id);
	isQMSapplicable=eOP.QMSInterface.isSiteSpecific(conn,"OP","EXT_QUEUE_NO");
	/* Below query was commented by venkatesh on 14-Nov-2012 against CRF SS-CRF-0010 [IN034516] FD 3.0 version*/
	//sqlmain.append("SELECT NVL (TO_CHAR (a.appt_time, 'hh24:mi'), ' ') appt_time, a.queue_num,  to_char(sysdate,'hh24:mi') hhmm , NVL (a.patient_id, ' ') patient_id, TO_CHAR (a.queue_date, 'dd/mm/yyyy') queue_date,a.locn_code locn_code, a.locn_type locn_type, decode('"+locale+"', 'en', a.patient_name, nvl(a.patient_name_loc_lang, a.patient_name)) patient_name, DECODE (a.locn_type, 'C', 'C', 'E', 'E') care_locn_type_ind,a.sex sex, a.date_of_birth date_of_birth, a.visit_adm_type, a.queue_status p_status,  TO_CHAR (DECODE (a.queue_status,'01', a.check_in_date_time,'02', a.arrive_date_time,'03', a.vital_signs_date_time,'04', a.cons_srvc_start_date_time, '05', NULL,'06', a.subs_arrive_date_time),'dd/mm/yyyy hh24:mi') dt, a.appt_id appt_id, TO_CHAR (SYSDATE, 'dd/mm/yyyy hh24:mi') arrival_date, a.appt_case_yn, a.visit_adm_type_ind, a.arrive_date_time arrive_date_time, a.vital_signs_date_time vital_signs_date_time, am_get_desc.am_care_locn_type (a.locn_type, '"+locale+"','1') locn_type_desc, op_get_desc.op_clinic (a.facility_id, a.locn_code, '"+locale+"','1') locn_desc,am_get_desc.am_practitioner (a.practitioner_id,'"+locale+"','1') practitioner_name, TO_CHAR (a.queue_date, 'HH24:MI') regn_date_time, a.practitioner_id,a.arrival_status,  no_show,  case_type, a.queue_status, a.queue_status queue_status_desc, 'Y' appt_confirm_yn, waiting_time, to_number(substr(lpad(waiting_time,5,'0'),1,2))*60+to_number(substr(lpad(waiting_time,5,'0'),4,2))  waitingMins, a.visit_adm_type_ind visit_type, op_get_desc.op_visit_type (a.facility_id,a.visit_adm_type,'"+locale+"','2') visit_type_desc, a.encounter_id, TRUNC (a.queue_date) - TRUNC (SYSDATE) prev_day_visit, a.room_num, a.room_num room_desc, a.pat_curr_locn_type pat_curr_locn_type,am_get_desc.am_care_locn_type(a.pat_curr_locn_type,'"+locale+"', '1') pat_curr_locn_type_desc, a.pat_curr_locn_code pat_curr_locn_code, DECODE (a.pat_curr_locn_type,'W', get_desc ('"+locale+"', 'rd_clinic_lang_vw', 'SHORT_DESC', 'CLINIC_CODE', a.pat_curr_locn_code),'O', get_desc ('"+locale+"', 'ot_oper_room_lang_vw', 'SHORT_DESC', 'OPER_ROOM_CODE', a.pat_curr_locn_code),'N', ip_get_desc.ip_nursing_unit (a.facility_id, a.pat_curr_locn_code, '"+locale+"', '1'),'R', am_get_desc.am_facility_room (a.facility_id, a.pat_curr_locn_code, '"+locale+"', '2'),op_get_desc.op_clinic (a.facility_id, a.pat_curr_locn_code, '"+locale+"', '1')) pat_curr_locn_desc,   am_get_desc.am_resource (a.facility_id,a.other_resource_id,'"+locale+"','2') other_res_desc, a.other_res_class other_res_class,a.other_resource_id other_res_code, a.referral_id ref_id,         am_get_desc.am_contact_reason (a.movement_reason_code,'"+locale+"', '2') reason_desc, a.queue_id queue_id, 'OP' patient_class,'N' package_referral, ( CASE WHEN '"+package_bl_install_YN+"' = 'Y' THEN (SELECT BLPACKAGE.GET_PKG_PAT_YN(A.FACILITY_ID,A.PATIENT_ID,A.EPISODE_ID,A.OP_EPISODE_VISIT_NUM) PAT_PAKYN FROM DUAL) END ) PKG_PAT_YN, ( CASE WHEN '"+package_bl_install_YN+"' = 'Y' THEN (SELECT BLPACKAGE.IS_PKG_OPEN_FOR_ENCOUNTER(A.FACILITY_ID, A.PATIENT_ID, 'O', A.EPISODE_ID, A.OP_EPISODE_VISIT_NUM) OPENENC_PAKYN FROM DUAL) END ) PKG_ENC_YN ");//added for Package Billing
	
	/* Below query is modified from above query by venkatesh on 14-Nov-2012 against CRF SS-CRF-0010 [IN034516] FD 3.0 version to get room short discription only*/
	/*Below query modified for this CRF  Bru-HIMS-CRF-133*/
	sqlmain.append("SELECT NVL (TO_CHAR (a.appt_time, 'hh24:mi'), ' ') appt_time, a.queue_num,  to_char(sysdate,'hh24:mi') hhmm , NVL (a.patient_id, ' ') patient_id, TO_CHAR (a.queue_date, 'dd/mm/yyyy') queue_date,a.locn_code locn_code, a.locn_type locn_type, decode('"+locale+"', 'en', a.patient_name, nvl(a.patient_name_loc_lang, a.patient_name)) patient_name, DECODE (a.locn_type, 'C', 'C', 'E', 'E') care_locn_type_ind,a.sex sex, a.date_of_birth date_of_birth, a.visit_adm_type, a.queue_status p_status,  TO_CHAR (DECODE (a.queue_status,'01', a.check_in_date_time,'02', a.arrive_date_time,'03', a.vital_signs_date_time,'04', a.cons_srvc_start_date_time, '05', NULL,'06', a.subs_arrive_date_time),'dd/mm/yyyy hh24:mi') dt, a.appt_id appt_id, TO_CHAR (SYSDATE, 'dd/mm/yyyy hh24:mi') arrival_date, a.appt_case_yn, a.visit_adm_type_ind, a.arrive_date_time arrive_date_time, a.vital_signs_date_time vital_signs_date_time, am_get_desc.am_care_locn_type (a.locn_type, '"+locale+"','1') locn_type_desc, op_get_desc.op_clinic (a.facility_id, a.locn_code, '"+locale+"','1') locn_desc,am_get_desc.am_practitioner (a.practitioner_id,'"+locale+"','1') practitioner_name, TO_CHAR (a.queue_date, 'HH24:MI') regn_date_time, a.practitioner_id,a.arrival_status,  no_show,  case_type, a.queue_status, a.queue_status queue_status_desc, 'Y' appt_confirm_yn, waiting_time, to_number(substr(lpad(waiting_time,5,'0'),1,2))*60+to_number(substr(lpad(waiting_time,5,'0'),4,2))  waitingMins, a.visit_adm_type_ind visit_type, op_get_desc.op_visit_type (a.facility_id,a.visit_adm_type,'"+locale+"','2') visit_type_desc, a.encounter_id, TRUNC (a.queue_date) - TRUNC (SYSDATE) prev_day_visit, a.room_num, am_get_desc.am_facility_room (a.facility_id, a.room_num, '"+locale+"', 2) room_desc, a.pat_curr_locn_type pat_curr_locn_type,am_get_desc.am_care_locn_type(a.pat_curr_locn_type,'"+locale+"', '1') pat_curr_locn_type_desc, a.pat_curr_locn_code pat_curr_locn_code, DECODE (a.pat_curr_locn_type,'W', get_desc ('"+locale+"', 'rd_clinic_lang_vw', 'SHORT_DESC', 'CLINIC_CODE', a.pat_curr_locn_code),'O', get_desc ('"+locale+"', 'ot_oper_room_lang_vw', 'SHORT_DESC', 'OPER_ROOM_CODE', a.pat_curr_locn_code),'N', ip_get_desc.ip_nursing_unit (a.facility_id, a.pat_curr_locn_code, '"+locale+"', '1'),'R', am_get_desc.am_facility_room (a.facility_id, a.pat_curr_locn_code, '"+locale+"', '2'),op_get_desc.op_clinic (a.facility_id, a.pat_curr_locn_code, '"+locale+"', '1')) pat_curr_locn_desc,   am_get_desc.am_resource (a.facility_id,a.other_resource_id,'"+locale+"','2') other_res_desc, a.other_res_class other_res_class,a.other_resource_id other_res_code, a.referral_id ref_id,         am_get_desc.am_contact_reason (a.movement_reason_code,'"+locale+"', '1') reason_desc, a.queue_id queue_id, 'OP' patient_class,'N' package_referral, ( CASE WHEN '"+package_bl_install_YN+"' = 'Y' THEN (SELECT BLPACKAGE.GET_PKG_PAT_YN(A.FACILITY_ID,A.PATIENT_ID,A.EPISODE_ID,A.OP_EPISODE_VISIT_NUM) PAT_PAKYN FROM DUAL) END ) PKG_PAT_YN, ( CASE WHEN '"+package_bl_install_YN+"' = 'Y' THEN (SELECT BLPACKAGE.IS_PKG_OPEN_FOR_ENCOUNTER(A.FACILITY_ID, A.PATIENT_ID, 'O', A.EPISODE_ID, A.OP_EPISODE_VISIT_NUM) OPENENC_PAKYN FROM DUAL) END ) PKG_ENC_YN, qms_call_count, a.episode_id,a.op_episode_visit_num,a.curr_locn_type, a.curr_locn_code,am_get_desc.am_care_locn_type(a.curr_locn_type,'"+locale+"', '1') patient_curr_locn_type,op_get_desc.op_clinic (a.facility_id, a.curr_locn_code, '"+locale+"', '1') patient_curr_locn_desc,to_char(sysdate,'dd/mm/yyyy') Sdate");//added for Package Billing

	 if(hide_pat_unauth_pract.equals("Y") && access_res_pat_yn.equals("N")){
		if(p_inc_check_out.equals("Y")) {
			sqlmain.append(" from op_manage_patient_queue_vw a, mp_patient m WHERE  a.facility_id = '"+facility_id+"' ");
		}else {
			sqlmain.append(" FROM op_current_patient_vw a, mp_patient m WHERE  a.facility_id = '"+facility_id+"' ");
		}
	 }else{
		 if(p_inc_check_out.equals("Y")) {
				sqlmain.append(" from op_manage_patient_queue_vw a WHERE  a.facility_id = '"+facility_id+"' ");
			}else {
				sqlmain.append(" FROM op_current_patient_vw a WHERE  a.facility_id = '"+facility_id+"' ");
			}
	 }

	//if ( (whereClause == null || whereClause.equals("")) )
//	{  
		//sql.append("  WHERE  a.facility_id = '"+facility_id+"'  ");			

		if(p_inc_check_out.equals("Y")) {
			sql.append(" and a.queue_status < '08' ");
		}
		if(!p_pract_id.equals("")) {
			sql.append(" and a.practitioner_id = '"+p_pract_id+"'");
		}
		if(!p_enc_id.equals("")) {
			sql.append(" and a.encounter_id= '"+p_enc_id+"'"); 
		}
		if(!p_queue_no.equals("")) {
			sql.append("and a.queue_num = '"+p_queue_no+"'"); 
		}		
		if(!p_patient_id.equals("")) {
			sql.append("and a.patient_id = '"+p_patient_id+"'"); 
		}
		if(!p_loc_type.equals("")) {
		  sql.append(" and a.locn_type='"+p_loc_type+"' ");
		}
		if(!p_loc_id.equals("")) {
			sql.append(" and a.locn_code='"+p_loc_id+"' "); 		
		}
		
		//Added by Ajay for ML-MMOH-CRF-1930
		if(isVirtConsVisit && function_id.equals("MANAGE_PAT_QUEUE")){
			if(virtConsVisit.equals("Y")){
				sql.append(" and a.visit_adm_type in (select visit_type_code from op_visit_type where VIRTUAL_CONSULTATION ='E' and eff_status = 'E' and visit_type_code = a.visit_adm_type )");
			}
		}
		//End ML-MMOH-CRF-1930
		//if(unionTwoWhereClause == null || unionTwoWhereClause.equals("")) {
			sql3.append(sql.toString());
		//}

		if(!p_speciality_code.equals("")) {
			sql.append("and a.speciality_code ='"+p_speciality_code+"'");
		}		 

		sql.append(" AND EXISTS ( SELECT locn_code  FROM am_os_user_locn_access_vw WHERE facility_id = a.facility_id AND locn_type = a.locn_type and locn_code = a.locn_code AND oper_stn_id = '"+p_operator_station+"'  AND appl_user_id = '"+login_user+"'"); 
 
		if( ChkOut.equals("ChkOut")) {
			sql.append(" AND checkout_pat_yn = 'Y')  ");
		}else{
			sql.append(" AND manage_queue_yn = 'Y') ");
		}
		
		//if(unionOneWhereClause == null || unionOneWhereClause.equals("")) {
			sql2.append(sql.toString());
		//}

		if (!p_gender.equals("")){
			sql.append(" and a.sex = '"+p_gender+"'");
		}

		if (!p_appt_status.equals("")) {
			if (p_appt_status.equals("Y"))				// Yet to come
			{
				sql.append(" and a.appt_confirm_yn = 'Y' and a.arrival_status not in ('O','L') and a.no_show='N' and queue_status = '00'");
			}		
			else if (p_appt_status.equals("T"))			// On Time
			{
				sql.append(" and a.arrival_status = 'O'");
			}
			else if (p_appt_status.equals("L"))			// Late
			{
				sql.append(" and a.arrival_status = 'L'");
			}
			else if (p_appt_status.equals("N"))			// No Show
			{
				sql.append(" and a.no_show = 'Y'");
			}
			else if (p_appt_status.equals("E"))			// Early
			{
				sql.append(" and a.arrival_status = 'E'");
			}
		}

		if (p_inc_prev_visits.equals("Y"))
		{		
			sql.append(" and  trunc(a.queue_date) = trunc(sysdate)-1 and to_date(to_char(a.queue_date,'HH24:MI'),'HH24:MI') >= to_date('"+p_start_time+"','HH24:MI') ");
		}
		else
		{
			sql.append(" and (trunc(a.queue_date) = trunc(sysdate) and to_date(to_char(a.queue_date,'HH24:MI'),'HH24:MI') >= to_date('"+p_start_time+"','HH24:MI')) ");
			/*
			if(package_bl_install_YN.equals("Y")) {
				sql.append(" OR EXISTS ( select 1 from op_current_patient_dtls b WHERE b.facility_id = a.facility_id AND a.encounter_id = b.encounter_id AND b.locn_code IS NOT NULL AND b.practitioner_id IS NOT NULL AND TRUNC (b.queue_date) = TRUNC (SYSDATE) AND TO_DATE (TO_CHAR (b.queue_date, 'HH24:MI'), 'HH24:MI') >= TO_DATE ('00:00', 'HH24:MI'))) ");
			}
			*/
		} 

//	} // end of where clause IF
//    else
//	{
//		sql.append(whereClause);
//	} 

	//order_by="  order by locn_type  ,case_type desc, practitioner_name  ,locn_desc  ,room_num  ,queue_num  ,appt_time "; 
	//Added by Ajay Hatwate for MMS-DM-CRF-0210 US21
	 if(hide_pat_unauth_pract.equals("Y") && access_res_pat_yn.equals("N")){
		sql.append(" and a.patient_id = m.patient_id  ");
		sql.append(" and ((m.restrict_reinstate_yn = 'N' or m.restrict_reinstate_yn is null) or (m.restrict_reinstate_yn = 'Y' and (a.queue_status <= '01' or a.practitioner_id is null))) ");
	} 
	//End of MMS-DM-CRF-0210
	
	

	
		
	sqlmain.append(sql.toString());	


	
	if(package_bl_install_YN.equals("Y") && !ChkOut.equals("ChkOut")) {
       /*  
		sqlmain.append(" UNION ALL SELECT NULL  APPT_TIME, A.QUEUE_NUM, TO_CHAR(SYSDATE,'HH24:MI') HHMM , NVL (A.PATIENT_ID, ' ') PATIENT_ID, TO_CHAR (A.QUEUE_DATE, 'DD/MM/YYYY') QUEUE_DATE, A.LOCN_CODE LOCN_CODE, A.LOCN_TYPE LOCN_TYPE, DECODE('"+locale+"', 'en', B.PATIENT_NAME, NVL(B.PATIENT_NAME_LOC_LANG, B.PATIENT_NAME)) PATIENT_NAME, DECODE (A.LOCN_TYPE, 'C', 'C', 'E', 'E') CARE_LOCN_TYPE_IND, B.SEX SEX, TO_CHAR(B.DATE_OF_BIRTH, 'DD/MM/YYYY') DATE_OF_BIRTH, A.VISIT_TYPE_CODE, A.QUEUE_STATUS P_STATUS, TO_CHAR(DECODE (A.QUEUE_STATUS,'01', A.CHECK_IN_DATE_TIME,'02', A.ARRIVE_DATE_TIME,'03', A.VITAL_SIGNS_DATE_TIME,'04', A.CONS_SRVC_START_DATE_TIME, '05', NULL,'06', A.SUBS_ARRIVE_DATE_TIME),'DD/MM/YYYY HH24:MI') DT, A.APPT_ID APPT_ID, TO_CHAR (SYSDATE, 'DD/MM/YYYY HH24:MI') ARRIVAL_DATE, NULL APPT_CASE_YN, A.VISIT_TYPE_IND, A.ARRIVE_DATE_TIME ARRIVE_DATE_TIME, A.VITAL_SIGNS_DATE_TIME VITAL_SIGNS_DATE_TIME, AM_GET_DESC.AM_CARE_LOCN_TYPE (A.LOCN_TYPE, '"+locale+"' ,'1') LOCN_TYPE_DESC, OP_GET_DESC.OP_CLINIC (A.FACILITY_ID, A.LOCN_CODE, '"+locale+"' ,'1') LOCN_DESC, AM_GET_DESC.AM_PRACTITIONER (A.PRACTITIONER_ID, '"+locale+"' ,'1') PRACTITIONER_NAME, TO_CHAR (A.QUEUE_DATE, 'HH24:MI') REGN_DATE_TIME, A.PRACTITIONER_ID, NULL ARRIVAL_STATUS, NULL NO_SHOW, NULL CASE_TYPE, A.QUEUE_STATUS, A.QUEUE_STATUS QUEUE_STATUS_DESC, 'Y' APPT_CONFIRM_YN, NULL WAITING_TIME ,null waitingMins, A.VISIT_TYPE_IND VISIT_TYPE, OP_GET_DESC.OP_VISIT_TYPE (A.FACILITY_ID,A.VISIT_TYPE_IND, '"+locale+"' ,'2') VISIT_TYPE_DESC, A.ENCOUNTER_ID, TRUNC (A.QUEUE_DATE) - TRUNC (SYSDATE) PREV_DAY_VISIT, A.ROOM_NUM, A.ROOM_NUM ROOM_DESC, A.PAT_CURR_LOCN_TYPE PAT_CURR_LOCN_TYPE, AM_GET_DESC.AM_CARE_LOCN_TYPE(A.PAT_CURR_LOCN_TYPE, '"+locale+"' , '1') PAT_CURR_LOCN_TYPE_DESC, A.PAT_CURR_LOCN_CODE PAT_CURR_LOCN_CODE, DECODE (a.pat_curr_locn_type, 'W', get_desc ('"+locale+"', 'rd_clinic_lang_vw', 'SHORT_DESC', 'CLINIC_CODE', a.pat_curr_locn_code),'O', get_desc ('"+locale+"', 'ot_oper_room_lang_vw', 'SHORT_DESC', 'OPER_ROOM_CODE', a.pat_curr_locn_code),  'N', ip_get_desc.ip_nursing_unit (a.facility_id, a.pat_curr_locn_code, '"+locale+"', '1'),     'R', am_get_desc.am_facility_room (a.facility_id, a.pat_curr_locn_code, '"+locale+"', '2'),op_get_desc.op_clinic (a.facility_id, a.pat_curr_locn_code, '"+locale+"', '1')) pat_curr_locn_desc, AM_GET_DESC.AM_RESOURCE (A.FACILITY_ID,A.OTHER_RESOURCE_ID, '"+locale+"' ,'2') OTHER_RES_DESC, A.OTHER_RES_CLASS OTHER_RES_CLASS, A.OTHER_RESOURCE_ID OTHER_RES_CODE, A.REFERRAL_ID REF_ID, AM_GET_DESC.AM_CONTACT_REASON (A.MOVEMENT_REASON_CODE, '"+locale+"' , '1') REASON_DESC, A.QUEUE_ID QUEUE_ID, 'OP' PATIENT_CLASS, 'N' PACKAGE_REFERRAL, ( CASE WHEN '"+package_bl_install_YN+"' = 'Y' THEN (SELECT BLPACKAGE.GET_PKG_PAT_YN(A.FACILITY_ID, A.PATIENT_ID, A.EPISODE_ID, A.OP_EPISODE_VISIT_NUM) PAT_PAKYN FROM DUAL) END ) PKG_PAT_YN, ( CASE WHEN '"+package_bl_install_YN+"' = 'Y' THEN (SELECT BLPACKAGE.IS_PKG_OPEN_FOR_ENCOUNTER(A.FACILITY_ID, A.PATIENT_ID, 'O', A.EPISODE_ID, A.OP_EPISODE_VISIT_NUM) OPENENC_PAKYN FROM DUAL) END ) PKG_ENC_YN,qms_call_count, a.episode_id,a.op_episode_visit_num,a.curr_locn_type, a.curr_locn_code,am_get_desc.am_care_locn_type(a.curr_locn_type,'"+locale+"', '1') patient_curr_locn_type,op_get_desc.op_clinic (a.facility_id, a.curr_locn_code, '"+locale+"', '1') patient_curr_locn_desc,        to_char(sysdate,'dd/mm/yyyy') Sdate	FROM OP_CURRENT_PATIENT A , MP_PATIENT B WHERE A.FACILITY_ID = '"+facility_id+"' AND A.PATIENT_ID = B.PATIENT_ID ");*/
		
		/*Above query modified for this CRF Bru-HIMS-CRF-133*/

		/*if(unionOneWhereClause == null || unionOneWhereClause.equals("")) {

			sql2.append(" AND EXISTS ( SELECT 1 FROM OP_CURRENT_PATIENT_DTLS B WHERE B.FACILITY_ID = A.FACILITY_ID AND A.ENCOUNTER_ID = B.ENCOUNTER_ID	AND B.LOCN_CODE IS NOT NULL AND B.PRACTITIONER_ID IS NOT NULL AND TRUNC (B.QUEUE_DATE) = TRUNC (SYSDATE) AND TO_DATE (TO_CHAR (B.QUEUE_DATE, 'HH24:MI'), 'HH24:MI') >= TO_DATE ('"+p_start_time+"', 'HH24:MI')) ");

			unionOneWhereClause = sql2.toString();

		} 
		 
		sqlmain.append(unionOneWhereClause);
		*/

		sqlmain.append("UNION ALL  SELECT null, queue_num, to_char(sysdate,'hh24:mi') hhmm , patient_id, TO_CHAR (queue_date, 'dd/mm/yyyy') queue_date, locn_code, locn_type,(select patient_name from mp_patient where patient_id = a.patient_id) patient_name, DECODE (locn_type, 'C', 'C', 'E', 'E') care_locn_type_ind, null, null, null, queue_status p_status,null, null, TO_CHAR (SYSDATE, 'dd/mm/yyyy hh24:mi') arrival_date, null, null as visit_adm_type_ind,null, null, am_get_desc.am_care_locn_type (locn_type, '"+locale+"', '1') locn_type_desc,op_get_desc.op_clinic (facility_id, locn_code, '"+locale+"', '1') locn_desc,am_get_desc.am_practitioner (practitioner_id, '"+locale+"', '1') practitioner_name,TO_CHAR (queue_date, 'HH24:MI') regn_date_time, practitioner_id, null, null, null,queue_status, queue_status queue_status_desc, 'Y' appt_confirm_yn, null, null,null, null, encounter_id,TRUNC (queue_date) - TRUNC (SYSDATE) prev_day_visit,null, null, pat_curr_locn_type,am_get_desc.am_care_locn_type(pat_curr_locn_type,'"+locale+"','1') pat_curr_locn_type_desc, pat_curr_locn_code, DECODE (a.pat_curr_locn_type,'W', get_desc ('"+locale+"', 'rd_clinic_lang_vw', 'SHORT_DESC', 'CLINIC_CODE', a.pat_curr_locn_code),'O', get_desc ('"+locale+"', 'ot_oper_room_lang_vw', 'SHORT_DESC', 'OPER_ROOM_CODE', a.pat_curr_locn_code),'N', ip_get_desc.ip_nursing_unit (a.facility_id, a.pat_curr_locn_code, '"+locale+"', '1'),        'R', am_get_desc.am_facility_room (a.facility_id, a.pat_curr_locn_code, '"+locale+"', '2'),op_get_desc.op_clinic (a.facility_id, a.pat_curr_locn_code, '"+locale+"', '1')) pat_curr_locn_desc,   null, null, null, referral_id ref_id, null, null, 'OP' patient_class,'Y' package_referral, 'N' PKG_PAT_YN, 'N' PKG_ENC_YN,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL  FROM op_current_patient_dtls a where a.facility_id='"+facility_id+"' "); 
		/*Above query modified for this CRF Bru-HIMS-CRF-133*/
			
		if(unionTwoWhereClause == null || unionTwoWhereClause.equals("")) {			

			if(!p_speciality_code.equals(""))
			{
				sql3.append("and a.specialty_code ='"+p_speciality_code+"'");
			}

			sql3.append(" AND EXISTS ( SELECT locn_code  FROM am_os_user_locn_access_vw   WHERE facility_id = a.facility_id AND locn_type=a.locn_type and locn_code = a.locn_code AND oper_stn_id = '"+p_operator_station+"'  AND appl_user_id = '"+login_user+"') and a.locn_code is not null and a.practitioner_id is not null AND TRUNC (a.queue_date) = TRUNC (SYSDATE) AND TO_DATE (TO_CHAR (a.queue_date, 'HH24:MI'), 'HH24:MI') >= TO_DATE ('00:00', 'HH24:MI') ");

			unionTwoWhereClause = sql3.toString();

			

			/*
			if(!p_enc_id.equals("")){
				unionTwoWhereClause=unionTwoWhereClause+" and encounter_id = '"+p_enc_id+"'"; 
			}
			if(!p_queue_no.equals("")){
				unionTwoWhereClause=unionTwoWhereClause+" and queue_num = '"+p_queue_no+"'"; 					
			}
			if(!p_patient_id.equals("")){
				unionTwoWhereClause=unionTwoWhereClause+" and patient_id = '"+p_patient_id+"'"; 
			}					
			if(!p_speciality_code.equals("")){
				unionTwoWhereClause=unionTwoWhereClause+" and specialty_code = '"+p_speciality_code+"'"; 
			}
			*/
		}
			
		sqlmain.append(unionTwoWhereClause);
	}

	sqlmain.append(" order by locn_type, case_type desc, practitioner_name , locn_desc , room_num, queue_num, appt_time,regn_date_time "); 
   
	int start = 0 ;
	int end = 0 ;
    
	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
		end = 20 ;
	else
		end = Integer.parseInt( to ) ;

 
	
 	pstmt=conn.prepareStatement(sqlmain.toString());

	rs = pstmt.executeQuery();  	
%>

							
<%
	int waitingMins = 0;
String p_case_type   ;
String p_no_show     ;
String p_appt_confirm_yn ;
String p_arrival_status  ;
String p_tvisit_type     ;
String p_patient_class   ;
String p_visit_type_desc ;
String p_encounter_id    ;
String p_queue_status    ;
boolean initial      = true;
String prev_val      = "";
String classValue    = "";
boolean pract_val_intial=true;
boolean room_num_initial=true;
String prev_room_num="";
String prev_pract_loc="";
String pract_loc="";

String curr_loc_type="";
String curr_loc_type_desc="";

String room_num="";
String room_desc="";
String pat_curr_locn_code="";
String pat_curr_locn_desc="";
String pat_curr_locn_type_desc="";
String curr_locn  = "";
String pat_cur_desc="";

/*Below line added for this CRF Bru-HIMS-CRF-133*/
String curr_locn_type="";
String curr_locn_code="";
String patient_curr_locn_type="";
String patient_curr_locn_desc="";
//End Bru-HIMS-CRF-133

String locn_code="";
String CARE_LOCN_TYPE_IND="";
String DATE_OF_BIRTH="";
String sex="";
String visit_adm_type="";
String p_status="";
String dt="";
String APPT_ID="";
String arrival_date="";
String curr_locn1="";
String curr_type_desc1="";
String VISIT_ADM_TYPE_IND="";
String appt_case_yn="";
String ARRIVE_DATE_TIME="";
String VITAL_SIGNS_DATE_TIME="";
String other_res_desc="";
String other_res_desc1="";

String other_res_class="";
String other_res_code="";
String ref_id="";
String appt_walk_ind="";
ResultSet rset = null;
String package_referral="";
String isInpatient=""; //Added for the CRF - Bru-HIMS-CRF-172
int tryl=1;
int i=1;
String locn_desc="";
//out.println("rs "+rs);
  	
	int p1=1;
    if ( start != 1 )
    {
	     for( int k=1; k<start; i++,k++ )
	     {
		  rs.next() ;
	     }
    }
      try{
		  StringBuffer temp=new StringBuffer();
		  StringBuffer sqlsub = new StringBuffer();
		  sqlsub.setLength(0);
    
	   
	
	

	 
int  counter = 0;
	  while (i<=end && rs.next()   )
        {	
		  
		 if(counter==0){%>
	 <table width='100%' border=0 cellspacing=0 cellpadding=0>
     <tr style="position:absolute;">
        <td align=left width='10%'>
            <table align='left' >
                <tr>
                    <td class='label' nowrap><fmt:message key="Common.LastRefreshTime.label" bundle="${common_labels}"/> <b><%=rs.getString("hhmm")%></b></td>
                </tr>
            </table>
        </td>
        <td width='72%' >
        </td>
        <td align='right'>
            <table align='right'>
                <tr>
                    <td>
		<!--Below lines are the links for navigating through pages - the next and previous links-to load the page with the existing data some parameters are passed through the query string.  -->
                        <%

							

                        if ( !(start <= 1) )

							/* The below code is commented for IN022744 on 19.july.2010 by Suresh M
                            out.println("<A HREF='../../eOP/jsp/ManageSPatQueueQueryResult.jsp?emergency_patients_only="+p_emergency+"&vistype="+p_vis_type+"&starttime="+p_start_time+"&patient_id="+p_patient_id+"&queueno="+p_queue_no+"&encid="+p_enc_id+"&checkout="+p_inc_check_out+"&pract_id="+p_pract_id+"&operator_station="+p_operator_station+"&locid="+p_loc_id+"&loctype="+p_loc_type+"&ChkOut="+ChkOut+"&inc_prev_visits="+p_inc_prev_visits+"&Vitalsign="+Vitalsign+"&Que="+Que+"&refresh="+rfresh_param+"&from="+(start-20)+"&to="+(end-20)+"&bl_install_yn="+bl_install_yn+"&package_bl_install_YN="+package_bl_install_YN+"&whereclause="+URLEncoder.encode(sql.toString())+"&unionOneWhereClause="+URLEncoder.encode(unionOneWhereClause)+"&unionTwoWhereClause="+URLEncoder.encode(unionTwoWhereClause)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
							*/
							
                            out.println("<A HREF='../../eOP/jsp/ManageSPatQueueQueryResult.jsp?action_on_pending_bill="+action_on_pending_bill+"&emergency_patients_only="+p_emergency+"&mins1_for_wait_time="+mins1_for_wait_time+"&mins2_for_wait_time="+mins2_for_wait_time+"&vistype="+p_vis_type+"&starttime="+p_start_time+"&patient_id="+p_patient_id+"&queueno="+p_queue_no+"&encid="+p_enc_id+"&checkout="+p_inc_check_out+"&pract_id="+p_pract_id+"&operator_station="+p_operator_station+"&locid="+p_loc_id+"&loctype="+p_loc_type+"&ChkOut="+ChkOut+"&inc_prev_visits="+p_inc_prev_visits+"&Vitalsign="+Vitalsign+"&Que="+Que+"&refresh="+rfresh_param+"&from="+(start-20)+"&to="+(end-20)+"&bl_install_yn="+bl_install_yn+"&package_bl_install_YN="+package_bl_install_YN+"&speciality_code="+p_speciality_code+"&gender="+p_gender+"&appt_status="+p_appt_status+"text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
							

                        if (endOfRes.equals("1") )                           
							out.println("<A id='nextval' HREF='../../eOP/jsp/ManageSPatQueueQueryResult.jsp?action_on_pending_bill="+action_on_pending_bill+"&emergency_patients_only="+p_emergency+"&mins1_for_wait_time="+mins1_for_wait_time+"&mins2_for_wait_time="+mins2_for_wait_time+"&vistype="+p_vis_type+"&starttime="+p_start_time+"&patient_id="+p_patient_id+"&queueno="+p_queue_no+"&encid="+p_enc_id+"&checkout="+p_inc_check_out+"&pract_id="+p_pract_id+"&operator_station="+p_operator_station+"&locid="+p_loc_id+"&loctype="+p_loc_type+"&ChkOut="+ChkOut+"&inc_prev_visits="+p_inc_prev_visits+"&Vitalsign="+Vitalsign+"&Que="+Que+"&refresh="+rfresh_param+"&from="+(start+20)+"&to="+(end+20)+"&bl_install_yn="+bl_install_yn+"&package_bl_install_YN="+package_bl_install_YN+"&speciality_code="+p_speciality_code+"&gender="+p_gender+"&appt_status="+p_appt_status+" text-decoration='none'>" +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");


						  //out.println("<A id='nextval' HREF='../../eOP/jsp/ManageSPatQueueQueryResult.jsp?emergency_patients_only="+p_emergency+"&vistype="+p_vis_type+"&starttime="+p_start_time+"&patient_id="+p_patient_id+"&queueno="+p_queue_no+"&encid="+p_enc_id+"&checkout="+p_inc_check_out+"&pract_id="+p_pract_id+"&operator_station="+p_operator_station+"&locid="+p_loc_id+"&loctype="+p_loc_type+"&ChkOut="+ChkOut+"&inc_prev_visits="+p_inc_prev_visits+"&Vitalsign="+Vitalsign+"&Que="+Que+"&refresh="+rfresh_param+"&from="+(start+20)+"&to="+(end+20)+"&bl_install_yn="+bl_install_yn+"&package_bl_install_YN="+package_bl_install_YN+"&whereclause="+URLEncoder.encode(sql.toString())+"&unionOneWhereClause="+URLEncoder.encode(unionOneWhereClause)+"&unionTwoWhereClause="+URLEncoder.encode(unionTwoWhereClause)+"'"+" text-decoration='none'>" +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");



                        %>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>


	<br/> <br/> 
<!-- Below lines class values moidified by Venkatesh.S  against  Bru-HIMS-CRF-303 [IN035021] on 02-April-2013-->
<div   style="height:380px;overflow:auto"> 
<table   border="1"  cellspacing=0 cellpadding=2 width="100%" >
<tr style="top:expression(this.offsetParent.scrollTop)">
<th class='columnheader' width='1%'>&nbsp;</th>
<th class='columnheader' width='5%' nowrap><fmt:message key="Common.appttime.label" bundle="${common_labels}"/></th>
<th class='columnheader' width='5%' nowrap><fmt:message key="Common.QueueNo.label" bundle="${common_labels}"/></th>
<%if(isQMSapplicable){%>
<th class='columnheader' width='5%' nowrap><fmt:message key="eOP.CallTicket.label" bundle="${op_labels}"/></th>
<%}%>
<th class='columnheader' width='5%'nowrap><fmt:message key="eOP.RegnTime.label" bundle="${op_labels}"/></th>
<th class='columnheader' width='5%'nowrap ><fmt:message key="eOP.apptstatus.label" bundle="${op_labels}"/></th>
<%-- <th class='columnheader' width='5%' nowrap ><fmt:message key="Common.isinpatient.label" bundle="${common_labels}"/></th>--%>
<% if(invokeMenstrualHistYN.equals("Y")){%>
<th class='columnheader' width='5%' nowrap ><fmt:message key="Common.GeneralInfo.label" bundle="${common_labels}"/></th>  <!-- 68508 -->
<%}else{%>
<th class='columnheader' width='5%' nowrap ><fmt:message key="Common.isinpatient.label" bundle="${common_labels}"/></th>
<%}%>
<th class='columnheader' nowrap><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></th>
<th class='columnheader' width='12%' nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
<th class='columnheader' width='5%' nowrap><fmt:message key="Common.WaitTime.label" bundle="${common_labels}"/></th>
<th class='columnheader' width='13%' nowrap><fmt:message key="Common.QueueStatus.label" bundle="${common_labels}"/></th>
<th class='columnheader' width='12%' nowrap><fmt:message key="Common.currentlocation.label" bundle="${common_labels}"/></th>
<th class='columnheader' width='13%' nowrap><fmt:message key="eOP.ReasonForMovement.label" bundle="${op_labels}"/></th>
<!--Added by Thamizh selvi on 9th July 2018 against ML-MMOH-CRF-1058 Start-->
<% if(isIncRemarksLengthAppl){ %>
	<td class='columnheader' width='13%' nowrap><fmt:message key="Common.booking.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
<% } %><!--End-->
<!-- Added by Ajay Hatwate for ML-MOH-CRF-1930 -->
<% if(isVirtConsVisit && function_id.equals("MANAGE_PAT_QUEUE")){ %>
<td class='columnheader' width='13%' nowrap><fmt:message key="Common.visittype.label" bundle="${common_labels}"/></td>
<% } %>
</tr> <br/>
		 
		 
		 <%}
			
			counter++;
 			p_case_type         = rs.getString("case_type")==null?"":rs.getString("case_type");
			p_no_show           = rs.getString("no_show")==null?"":rs.getString("no_show");
			p_appt_confirm_yn   = rs.getString("appt_confirm_yn")==null?"":rs.getString("appt_confirm_yn");
			p_arrival_status    = rs.getString("arrival_status")==null?"":rs.getString("arrival_status");
			p_tvisit_type       = rs.getString("visit_type")==null?"":rs.getString("visit_type");
			p_patient_class     = rs.getString("patient_class")==null?"":rs.getString("patient_class");
			p_visit_type_desc   = rs.getString("visit_type_desc")==null?"":rs.getString("visit_type_desc");
			p_encounter_id      = String.valueOf(rs.getLong("encounter_id"));
			p_patient_id        = rs.getString("patient_id")==null?"":rs.getString("patient_id");
			pkg_pat_yn        = rs.getString("PKG_PAT_YN")==null?"N":rs.getString("PKG_PAT_YN");
			pkg_enc_yn        = rs.getString("PKG_ENC_YN")==null?"N":rs.getString("PKG_ENC_YN");
			
			p_queue_status      = rs.getString("queue_status")==null?"":rs.getString("queue_status");

			CARE_LOCN_TYPE_IND  =rs.getString("CARE_LOCN_TYPE_IND")==null?"":rs.getString("CARE_LOCN_TYPE_IND");
		
			waitingMins  =rs.getInt("waitingMins");
			

			String colorcode = "";
			episode_id		= rs.getString("episode_id")==null?"":rs.getString("episode_id"); // Added for MMS-QH-CRF-0126 [IN:041880] 
			op_episode_visit_num	= rs.getString("op_episode_visit_num")==null?"":rs.getString("op_episode_visit_num");// Added for MMS-QH-CRF-0126 [IN:041880]

	
			

			locn_code			=rs.getString("locn_code")==null?"":rs.getString("locn_code");
			DATE_OF_BIRTH		=rs.getString("DATE_OF_BIRTH")==null?"":rs.getString("DATE_OF_BIRTH");
			sex					=rs.getString("sex")==null?"":rs.getString("sex");
			visit_adm_type		=rs.getString("visit_adm_type")==null?"":rs.getString("visit_adm_type");
           // p_status			=rs.getString("p_status")==null?"":rs.getString("p_status");
			p_status			=rs.getString("queue_status_desc")==null?"":rs.getString("queue_status_desc");

			package_referral	=rs.getString("package_referral")==null?"N":rs.getString("package_referral");

			p_queue_date		= rs.getString("queue_date"); //this line moved here for this CRF Bru-HIMS-CRF-133	
			Sydate=rs.getString("Sdate");
			if(Sydate == null) Sydate="";
			//Above line added for this CRF Bru-HIMS-CRF-133

			if(mins1_for_wait_time_int > mins2_for_wait_time_int ){				
				if((waitingMins > mins2_for_wait_time_int && mins2_for_wait_time_int!=0) && (waitingMins <= mins1_for_wait_time_int && mins1_for_wait_time_int!=0) )
					colorcode = "FFA500";    // Orange
				else if(waitingMins > mins1_for_wait_time_int)
					colorcode ="00BFFF";     //Blue		

			}else if(mins1_for_wait_time_int < mins2_for_wait_time_int ) {				
				if((waitingMins > mins1_for_wait_time_int && mins1_for_wait_time_int!=0 ) && (waitingMins <= mins2_for_wait_time_int && mins2_for_wait_time_int!=0 ))
					colorcode = "00BFFF";   //Blue
				else if(waitingMins > mins2_for_wait_time_int)
					colorcode ="FFA500";   // Orange
				
			}

		   	if(p_status.equals("00"))
			{
			p_status="";
			}else
			if(p_status.equals("01"))
			{
		    p_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.CheckedIn.label","op_labels");
			}else if(p_status.equals("02"))
			{
			/*Above condtion added for this CRF Bru-HIMS-CRF-133*/
			if(isPatEncMovement && p_queue_date.equals(Sydate)){
			    p_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.arrived.label","op_labels");
			}else{				
				p_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ArrivedAtNursStn.label","op_labels");
			}
			//End Bru-HIMS-CRF-133
			}else if(p_status.equals("03"))
			{
				p_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.VitalSignRecorded.label","op_labels");
			}else if(p_status.equals("04"))
			{
				p_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ConsultationInProgress.label","op_labels");
				colorcode = "";
				}else if(p_status.equals("05"))
			{
					p_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Treat/Invest.label","common_labels");
			}else if(p_status.equals("06"))
			{p_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.RetFrmInvest.label","op_labels");
			}else if(p_status.equals("07"))	
			{
			p_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CheckOut.label","common_labels");
			colorcode = "";
			} 
			
			String    p_status_desc=p_status; 
			p_status=URLEncoder.encode(p_status,"UTF-8");
           
			dt					=rs.getString("dt");
			if(dt == null) dt="";
			// else
				// dt=java.net.URLEncoder.encode(dt);

			APPT_ID				=rs.getString("APPT_ID");
			if(APPT_ID == null) APPT_ID="";
			arrival_date		=rs.getString("arrival_date");
			if(arrival_date ==null) arrival_date="";
			// arrival_date=java.net.URLEncoder.encode(arrival_date);

			/*Added by Thamizh selvi on 11th July 2018 against ML-MMOH-CRF-1058 Start*/
			if(isIncRemarksLengthAppl && !("").equals(APPT_ID))
				apptRemarks		= eOA.OACommonBean.getApptRemarks(conn,facility_id,APPT_ID);
			/*End*/
			
			VISIT_ADM_TYPE_IND  =rs.getString("VISIT_ADM_TYPE_IND");
			appt_case_yn		=rs.getString("appt_case_yn");
			ARRIVE_DATE_TIME    =rs.getString("ARRIVE_DATE_TIME");
			VITAL_SIGNS_DATE_TIME =rs.getString("VITAL_SIGNS_DATE_TIME");
            
			if(ARRIVE_DATE_TIME == null) ARRIVE_DATE_TIME="";
            ARRIVE_DATE_TIME=java.net.URLEncoder.encode(ARRIVE_DATE_TIME);

			if(VITAL_SIGNS_DATE_TIME == null) VITAL_SIGNS_DATE_TIME="";
			 VITAL_SIGNS_DATE_TIME =java.net.URLEncoder.encode(VITAL_SIGNS_DATE_TIME);

			other_res_desc = rs.getString("other_res_desc");
			if(other_res_desc == null) other_res_desc="";

			other_res_class = rs.getString("other_res_class");
			if(other_res_class == null) other_res_class="";

			other_res_code = rs.getString("other_res_code");
			if(other_res_code == null) other_res_code="";

			ref_id=rs.getString("ref_id");
			if(ref_id == null) ref_id="";
			
            			
			//Below line modified for thsi incident [60902]
			//if(!(ref_id.equals("") && APPT_ID.equals(""))){ 			
            if(!APPT_ID.equals("")){  				
				appt_walk_ind="A";
			}else if(!ref_id.equals("")){ 
				 appt_walk_ind="R";
			}else{ 
				 appt_walk_ind=p_case_type;
			}	 
		            			
 
			reason_desc=rs.getString("reason_desc");
			if(reason_desc == null) reason_desc="&nbsp;";
			
			QUEUE_ID=rs.getString("QUEUE_ID");
			if(QUEUE_ID == null) QUEUE_ID="";

			pat_curr_locn_type_desc=rs.getString("pat_curr_locn_type_desc");
			if(pat_curr_locn_type_desc==null)pat_curr_locn_type_desc="&nbsp;";
			 pat_curr_locn_code=rs.getString("pat_curr_locn_code");
			pat_curr_locn_desc=rs.getString("pat_curr_locn_desc");
			if(pat_curr_locn_desc ==  null) pat_curr_locn_desc = "&nbsp;";
			room_num=rs.getString("room_num");
			room_desc=rs.getString("room_desc");
			curr_loc_type=rs.getString("locn_type");
			curr_loc_type_desc=rs.getString("locn_type_desc");

			if(curr_loc_type_desc==null) curr_loc_type_desc="&nbsp;";
			curr_type_desc1=java.net.URLEncoder.encode(curr_loc_type_desc,"UTF-8");

			pract_loc=rs.getString("locn_desc");
			curr_locn=rs.getString("locn_desc");
				if(curr_locn ==  null) curr_locn = "&nbsp;";
			
			curr_locn1=java.net.URLEncoder.encode(curr_locn,"UTF-8");

			pract_id=rs.getString("practitioner_id");
			locn_desc=pract_loc;
			/*Below line added for this CRF Bru-HIMS-CRF-133*/
			curr_locn_type=rs.getString("curr_locn_type");
			if(curr_locn_type == null) curr_locn_type="";
			curr_locn_code=rs.getString("curr_locn_code");
			if(curr_locn_code == null) curr_locn_code="";			
          
		   	patient_curr_locn_type=rs.getString("patient_curr_locn_type");
			if(patient_curr_locn_type == null) patient_curr_locn_type="";
			patient_curr_locn_desc=rs.getString("patient_curr_locn_desc");
			if(patient_curr_locn_desc == null) patient_curr_locn_desc=""; 	

			           			
					
			//if(!locn_code.equals(curr_locn_code)){
			if(isPatEncMovement && p_queue_date.equals(Sydate)){	
			if(!locn_code.equals(curr_locn_code) && !curr_locn_code.equals("")){
				
				if(curr_locn_type.equals("E"))
				{				
					
                    p_status_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.GoneforInvestigation.label","op_labels");					
				}else{
					
	                p_status_desc=p_status_desc+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.AtDifferentLocation.label","op_labels");					
				}	
				
			   }
			}
			
			//End Bru-HIMS-CRF-133
           
			int cnt=0;
			while(locn_desc.indexOf("'",cnt)!=-1)
			{		
			temp.setLength(0);
			int a=locn_desc.indexOf("'",cnt);
			temp.append(locn_desc);
			temp.replace(a,a+1,"''");
			locn_desc=temp.toString();
			cnt=(a+2);
		    }

		    temp.setLength(0);
			
			int prev_day_visit = rs.getInt("prev_day_visit");

			String pract=rs.getString("practitioner_name")==null?"":rs.getString("practitioner_name");
			if (!pract.equals(""))
			    pract_loc=curr_loc_type_desc+"/"+pract_loc+"/"+other_res_desc1+rs.getString("practitioner_name");
            else
				pract_loc=curr_loc_type_desc+"/"+other_res_desc1+pract_loc;

			
			
			if((!pat_curr_locn_type_desc.equals("&nbsp;"))&&(!pat_curr_locn_desc.equals("&nbsp;"))) {
			      /*Below condition was added by venkatesh.S on 16-Nov-2012 against SS-CRF-010*/
			          if(pat_curr_locn_type_desc.equals("Room")){
					  pat_cur_desc=pat_curr_locn_type_desc+"/"+pat_curr_locn_code+" "+pat_curr_locn_desc;
					  }else{
						  pat_cur_desc=pat_curr_locn_type_desc+"/"+pat_curr_locn_desc;
						}
			}else{
				pat_cur_desc="";}
		    /*Below line added for this CRF Bru-HIMS-CRF-133*/
             if(!patient_curr_locn_type.equals("") && !patient_curr_locn_desc.equals("") && isPatEncMovement && p_queue_date.equals(Sydate)){
			 pat_cur_desc=patient_curr_locn_type+"/"+patient_curr_locn_desc;
             }			 
			//End Bru-HIMS-CRF-133

			
			String vis_type_desc_nw="";
		    String name="";
		   	name = rs.getString("patient_name");

		String Color_Class=color_set(p_case_type,p_no_show,p_appt_confirm_yn,p_arrival_status,p_tvisit_type);

		try{
			
			// The following if condition is if the particular practitioner id
			// occurs for the first time.If the next patient has the same
			// practitioner id...the pract_val_initial boolean is false and
			// hence the else condition is executed.Thus the patient for the
			// same practitioner

			if( pract_val_intial )
			{
			    pract_val_disp=false;
			    prev_pract_loc=pract_loc;
			    pract_val_intial=false;
			}
			else
			{
				
			    if(!pract_loc.equals(prev_pract_loc))
			    {
					prev_pract_loc=pract_loc;
					pract_val_disp=false;
			    }
			    else
					pract_val_disp=true;
			
			}
			if(room_num_initial)
			{
				   room_num_disp=false;
				   prev_room_num=room_num;
				   room_num_initial=false;			

			}			
			else
			{
				
				if(room_num != null)
				{
					if(!room_num.equals("null"))
					{
						if(!room_num.equals(prev_room_num))
						{
							
						   prev_room_num=room_num;
						   room_num_disp=false;
						}
						else
						{
							
						  room_num_disp=true;
						}
					}
					else
						 room_num_disp=true; 
				}
				else
					room_num_disp=true;
				
				
			}		
			
			if (p_vis_type.equals("Y"))
			{
				
			    if (initial)
			    {
					
					vis_type_desc_nw=","+p_visit_type_desc;
					chk_disp=false;
			    }
			    else
			    {	
				
				if (!p_visit_type_desc.equals(prev_val) || pract_val_disp==false || room_num_disp==false)
				{
				    vis_type_desc_nw=","+p_visit_type_desc;
				    chk_disp=false;
				}
				else
				    chk_disp=true;
			    }
			}
		}catch(Exception e){out.println("catch4"+e);}
		try{
			
			if(!chk_disp || !pract_val_disp || !room_num_disp)
			{

		
		if(p_no_show.equals("N"))
			{
			sqlsub.setLength(0);

			/*
			sqlsub.append("SELECT a.tot_fi_appt_visits+a.tot_fu_appt_visits+a.tot_rt_appt_visits+a.tot_sr_appt_visits+a.tot_cs_appt_visits + a.tot_fi_ob_appts+a.tot_fu_ob_appts+a.tot_rt_ob_appts+a.tot_sr_ob_appts+a.tot_cs_ob_appts Appt,  ");
			sqlsub.append("decode(a.locn_type,'C',a.tot_checked_in,a.tot_arrived_in) INr, a.tot_vs_checked VITAL, a.Tot_cons_srvc_started SEEN,");
			sqlsub.append("decode(a.locn_type,'C',a.tot_checked_in,a.tot_arrived_in)-a.tot_cons_srvc_started WAIT");
			sqlsub.append(" FROM  Op_patient_queue_summ a WHERE ");

			if(p_loc_id==null  || p_loc_id.equals(""))
				{
			sqlsub.append("a.locn_code = '"+locn_code+"'");
				}
		    else
				{
			sqlsub.append("a.locn_code='"+p_loc_id+"' ");
				}
			if(pract_id !=null)				
			{
				sqlsub.append("and a.practitioner_id='"+pract_id+"'");
			}
			if(room_num != null)
			{
				sqlsub.append("and a.room_num='"+room_num+"'");
			}						
			if (p_inc_prev_visits.equals("Y"))
			{
				
				sqlsub.append("and a.facility_id='"+facility_id+"'  and trunc(a.queue_date) =trunc(sysdate)-1 ");
			}
			else
			{
				
				sqlsub.append("and a.facility_id='"+facility_id+"'  and trunc(a.queue_date) =trunc(sysdate) ");
			}		
			*/
			

			sqlsub.append("SELECT SUM(DECODE(APPT_OR_WALK_IN_IND,'A',1,0)) appt, SUM(CASE WHEN QUEUE_STATUS IN ('01','02') THEN 1 ELSE 0 END ) INr, SUM(CASE WHEN CONS_SRVC_START_DATE_TIME IS NOT NULL AND CONS_SRVC_END_DATE_TIME IS NULL THEN 1 ELSE 0 END) SEEN, SUM(CASE WHEN CONS_SRVC_START_DATE_TIME IS NULL AND QUEUE_STATUS IN ('01','02') THEN 1 ELSE 0 END ) WAIT FROM OP_CURRENT_PATIENT ");			
			
			sqlsub.append(" WHERE facility_id = '"+facility_id+"' ");

			//if(p_loc_id != null || !p_loc_id.equals("") )
			if( p_loc_id.length()>0 )
			{
				sqlsub.append(" and locn_code='"+p_loc_id+"' and locn_type = '"+p_loc_type+"' ");
			}
		    else
			{	
				sqlsub.append(" and locn_code='"+rs.getString("locn_code")+"' ");
			}
			if(pract_id !=null)				
			{
				sqlsub.append("and PRACTITIONER_ID='"+pract_id+"'");
			}
			
			if (p_inc_prev_visits.equals("Y"))
			{				
				sqlsub.append(" and trunc(queue_date) =trunc(sysdate)-1 ");
			}
			else
			{				
				sqlsub.append(" and trunc(queue_date) =trunc(sysdate) ");
			}	
			
		
			pstmt=conn.prepareStatement(sqlsub.toString());
			rset=pstmt.executeQuery();
			

			String appt="";
			String inr="";
			String seen="";
			String wait="";

			if(rset.next())
			{
			    appt=rset.getString("Appt")==null?"0":rset.getString("Appt");
			    inr=rset.getString("INR")==null?"0":rset.getString("INR");
			    seen=rset.getString("Seen")==null?"0":rset.getString("Seen");
			    wait=rset.getString("Wait")==null?"0":rset.getString("Wait");
			}

		
				str= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Appointment.label","common_labels")+":"+" "+appt+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.in.label","common_labels")+":"+" "+inr+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.Seen.label","op_labels")+":"+" "+seen+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.Wait.label","op_labels")+":"+" "+wait;
				if (p_vis_type.equals("O"))
					str="";
		    }
		    else
			str="";
		%>
		    <tr>
	    <% String clinic_qms_interfaced_yn=eOP.QMSInterface.isClinicQMSInterfaced(locn_code,facility_id,conn);
			    if(room_num != null)
			    {
				    
					if(room_num.equals("*ALL")) room_num="";
				    if(!(room_num.equals("")))
				    {%>
					<!-- below line was modified by Venkatesh.S on 14-Nov-2012 against CRF SS-CRF-0010 [IN034516] FD 3.0 version  -->
					<td colspan='6'  class='CAGROUPHEADING'>&nbsp;<font size='1'><%=pract_loc+vis_type_desc_nw%>/<%=room_num%> <%=room_desc%></font>&nbsp;
					<%if(clinic_qms_interfaced_yn.equals("Y")){
						%><img src='../../eCommon/images/callNext.png' alt='Call Next Patient' onclick="callNextPatient();"/></td><%}%>
			<%	}
				else
				{	%>
					<td colspan='6'  class='CAGROUPHEADING'>&nbsp;<font size='1'><%=pract_loc+vis_type_desc_nw%></font>&nbsp;<%if(clinic_qms_interfaced_yn.equals("Y")){
						%><!-- Added for the SCF - ML-Bru-SCF-1074 --><img src='../../eCommon/images/callNext.png' alt='Call Next Patient' onclick="callNextPatient();"/></td><%}%></td>
			<%	}
			}
			else
			{
				
				%>
				<td colspan='6' class='CAGROUPHEADING'>&nbsp;<font size='1'><%=pract_loc+vis_type_desc_nw%></font><%if(clinic_qms_interfaced_yn.equals("Y")){
						%><!-- Added for the SCF - ML-Bru-SCF-1074 --><img src='../../eCommon/images/callNext.png' alt='Call Next Patient' onclick="callNextPatient();"/></td><%}%></td>
			<%}%>
				<td colspan='7' align='right' class='CAGROUPHEADING'>&nbsp;<font size='1'><%=str%>&nbsp;</font></td>
			    </tr>     
			<%
			}
		    // till here
		}catch(Exception e){out.println("catch3"+e);}
			if ( i % 2 == 0 )
			    classValue = "QRYEVEN" ;
			else
			    classValue = "QRYODD" ;
		
			
			if(Color_Class.equals("PATQRED"))
			    classValue="PATQRED";
			if(Color_Class.equals("white"))
			    Color_Class=classValue;
			%>
			
			<tr onMouseOver='hideToolTip();'>
			<%if (rs.getString("queue_num")!=null){%>	
			<td align='left' class='<%=classValue%>' class='QRY'><font size='1'><a href="javascript:viewpatmovementdetails('<%=p_encounter_id%>');">+</a></td>
			<%}else{%>
			<td align='left' class='<%=classValue%>' class='QRY'></td><font size='1'>
			<%}

			if (rs.getString("appt_time")==null)
			{
				%>
					<td class='<%=classValue%>' class='QRY'>&nbsp;</td>
				<%
			}
			else
			{
				%>
					<td class='<%=classValue%>' class='QRY'>&nbsp;<font size='1'><%=rs.getString("appt_time")%></td>
				<%
			 }
				
		
			if (rs.getString("queue_num")==null)
			{
				%>
					<td class='<%=classValue%>' class='QRY'>&nbsp;</td>
				<%
			}
			else
			{
				%>
					<td class='<%=classValue%>' class='QRY'>&nbsp;<font size='1'><%=rs.getString("queue_num")%></td>
				<%
			 }
			 qms_interfaced_yn= eOP.QMSInterface.isClinicQMSInterfaced(locn_code,facility_id,conn);
			 /*qms_call_count = rs.getString("qms_call_count")==null?"":rs.getString("qms_call_count");
			 qms_call_count=qms_call_count.equals("0")?"":qms_call_count;*/
			 qms_call_count = rs.getString("qms_call_count")==null?"":rs.getString("qms_call_count");
			 String patient_id=rs.getString("patient_id"); //68508
			 
			 
	//68508
    int existActiveMensDtlYN=0;	 
    pstmt1 = conn.prepareStatement("SELECT COUNT(*) AS existActiveMensDtlYN FROM ca_mens_his_trans_dtl WHERE patient_id = ? AND facility_id = ? AND EVENT_STATUS = 'A'");
    pstmt1.setString(1, patient_id);
    pstmt1.setString(2, facility_id);
    rs1 = pstmt1.executeQuery();
    if (rs1.next()){
    existActiveMensDtlYN = rs1.getInt("existActiveMensDtlYN");
    }
    if(pstmt1!=null) pstmt1.close();
    if(rs1!=null) rs1.close();	 
    //68508	 
			 String callRecall="Call.png";
			 String mouseOver="Call Patient";
			 int qms_call_cnt=0;
			 if(!qms_call_count.equals("")){
				qms_call_cnt=Integer.parseInt(qms_call_count);
				 if(qms_call_cnt >=1){
					callRecall="Recall.png";
					mouseOver="Recall Patient";
					qms_call_cnt=(qms_call_cnt-1)<=0?0:(qms_call_cnt-1);
						qms_call_count=String.valueOf(qms_call_cnt);
				 }else{
						 qms_call_count="";
					 }				 
			 }
			
			 
			
			 
			if(isQMSapplicable){
				if(qms_interfaced_yn.equals("Y") && !p_encounter_id.equals("0") && !p_queue_status.equals("01")){

			%>
			<td class='<%=classValue%>'  class='QRY'><img src='../../eCommon/images/<%=callRecall%>' alt='<%=mouseOver%>' onclick="callPatient('<%=p_patient_id%>','<%=p_encounter_id%>','<%=rs.getString("queue_num")%>');">&nbsp;<FONT size=1><%=qms_call_count%></td> 
			<%}else{%>
			<td class='<%=classValue%>'  class='QRY'>&nbsp;</td> 
			<%}
			}
			 if( rs.getString("regn_date_time")==null)
			{
				 %>
					<td class='<%=classValue%>' class='QRY'>&nbsp;</td>
				 <%
			 }
			 else
			{
				 %>
					<td class='<%=classValue%>' class='QRY'>&nbsp;<font size='1'><%=rs.getString("regn_date_time")%></td>
				 <%
			}
			%>
			<!--Below lines moidified by Venkatesh.S  against  Bru-HIMS-CRF-303 [IN035021] on 02-April-2013-->
			<td class='<%=classValue%>'  style = 'background-color:<%=Color_Class%>'>&nbsp</td>

			<%
			//Added for the CRF - Bru-HIMS-CRF-172
			isInpatient = patdata.CheckInPatient(conn,p_patient_id,facility_id);
			if(isInpatient.equals("CURRENTLY_IN_PATIENT")) {
				%> 				
				
				<%-- <td class='<%=classValue%>'  class='QRY'>
				<center><img src='../../eCommon/images/inpatient.gif' alt="Patient is IP/DC" style="float: left;></center>
				<center><img src='../../eCommon/images/inpatient.gif' alt="Patient is IP/DC" style="float: left;></center>
				</td>	 --%>			
				
				
	 		<td class='<%=classValue%> QRY' style="text-align: center;">
	 		<%if(invokeMenstrualHistYN.equals("Y")){ %>
            <img src='../../eCommon/images/inpatient.gif' alt="Patient is IP/DC" style="float: center; ">
            <%}else{%>
             <img src='../../eCommon/images/inpatient.gif'>
            <%}%>
            &nbsp;&nbsp;
            <% if(existActiveMensDtlYN > 0 && invokeMenstrualHistYN.equals("Y")){%>
            <img src='../../eCommon/images/Menstrual_History_Dtl.png' onClick="getMenstrualHistoryDtl('<%=patient_id%>','<%=facility_id%>');" alt="View Menstrual History Details" style="float: center;">
            <%}%>
            <input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">  <!-- 68508 -->
            </td>	
			<%  
			//68508
			}
			else
			{
			%>
			<td class='<%=classValue%>'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<% if(existActiveMensDtlYN > 0 && invokeMenstrualHistYN.equals("Y")){%>
            <img src='../../eCommon/images/Menstrual_History_Dtl.png' onClick="getMenstrualHistoryDtl('<%=patient_id%>','<%=facility_id%>');" alt="View Menstrual History Details" style="float: center;">
            <%}%>
            <input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">  <!-- 68508 -->
			</td>
			<%
			}
			if (rs.getString("queue_num")==null)
			{
				
				%>
					<td class='<%=classValue%>' class='QRY'><font size='1'>
					<%
					if(isVIPimgpatfrontappl) //Added by Mujafar against ML-MMOH-CRF-1070
					{	String pat_id = rs.getString("patient_id");
						String vip_pat_yn = eOA.OACommonBean.getVIPPatient(conn,pat_id,facility_id);
						if(vip_pat_yn.equals("TRUE"))
						{
					%>
					<img border=0 src='../../eCommon/images/PI_VIP.gif'></img>
					<%}}%>
				<%=name%></td>  
				<%
			}
			else
			{
			  if (Vitalsign.equals("Vitalsign"))
				{
				  
			     String lin="";
				lin="<a name='"+tryl+"' id='"+tryl+"' href=javascript:func1() onclick=LoadVsign('"+p_encounter_id+"','"+p_patient_class+"','"+rs.getString("patient_id")+"','"+isPatEncMovement+"','"+Sydate+"','"+p_queue_date+"')>";
	
				 if(p_queue_status.equals("07") || p_queue_status.equals("08") )
				    lin="";
				
				// Added for excluding hyperlink for Previous Day's visits.
				if (prev_day_visit < 0)
				{
					%>
						<td class='<%=classValue%>' class='QRY' nowrap><%=lin%><FONT size=1>
						<%
					if(isVIPimgpatfrontappl) //Added by Mujafar against ML-MMOH-CRF-1070
					{	String pat_id = rs.getString("patient_id");
						String vip_pat_yn = eOA.OACommonBean.getVIPPatient(conn,pat_id,facility_id);
						if(vip_pat_yn.equals("TRUE"))
						{
					%>
					<img border=0 src='../../eCommon/images/PI_VIP.gif'></img>
					<%}}%>
						<%=name%></FONT></td> 
			<%	}
				else
				{	%>
					<td class='<%=classValue%>' class='QRY' nowrap><%=lin%><FONT size=1>
					<%
					if(isVIPimgpatfrontappl) //Added by Mujafar against ML-MMOH-CRF-1070
					{	String pat_id = rs.getString("patient_id");
						String vip_pat_yn = eOA.OACommonBean.getVIPPatient(conn,pat_id,facility_id);
						if(vip_pat_yn.equals("TRUE"))
						{
					%>
					<img border=0 src='../../eCommon/images/PI_VIP.gif'></img>
					<%}}%>
					<%=name%></FONT></a></td>
			<%	}
				// end of addition
			    }
				else if (ChkOut.equals("ChkOut"))
			    {
				/*Below line modified for this CRF Bru-HIMS-CRF-133*/
				 String lin="<a name='"+tryl+"' id='"+tryl+"' href=javascript:func1() onclick=LoadChkOut('"+p_encounter_id+"','"+p_queue_date+"','"+p_patient_id+"','"+curr_loc_type+"','"+bl_install_yn+"','"+package_bl_install_YN+"','"+pkg_pat_yn+"','"+pkg_enc_yn+"','"+isPatEncMovement+"','"+Sydate+"')>";
				
				 if(p_queue_status.equals("07") || p_queue_status.equals("08") )
				      lin="";
				 %>
					 <td class='<%=classValue%>' class='QRY' nowrap><%=lin%><FONT size=1>
					 <%
					if(isVIPimgpatfrontappl) //Added by Mujafar against ML-MMOH-CRF-1070
					{	String pat_id = p_patient_id;
						String vip_pat_yn = eOA.OACommonBean.getVIPPatient(conn,pat_id,facility_id);
						if(vip_pat_yn.equals("TRUE"))
						{
					%>
					<img border=0 src='../../eCommon/images/PI_VIP.gif'></img>
					<%}}%>
					 <%=name%></FONT></a></td>
				 <%
			    }
			 else
			    {
				 					
				 String lin="";
				
				 if(p_queue_status.equals("07") || p_queue_status.equals("08") ){
				 lin="";
				  %>
					 <td class='<%=classValue%>' class='QRY' nowrap><%=lin%><FONT size=1>
					 <%
					if(isVIPimgpatfrontappl) //Added by Mujafar against ML-MMOH-CRF-1070
					{	String pat_id = p_patient_id;
						String vip_pat_yn = eOA.OACommonBean.getVIPPatient(conn,pat_id,facility_id);
						if(vip_pat_yn.equals("TRUE"))
						{
					%>
					<img border=0 src='../../eCommon/images/PI_VIP.gif'></img>
					<%}}%>
					 <%=name%></FONT></a></td>
				   <%
				 }else{
					 
					  
					  if(package_referral.equals("N")){
					  	 /*Below line modified for this incident [38281]*/
						 /*Below lines moidified by Venkatesh.S  against  Bru-HIMS-CRF-303 [IN035021] on 02-April-2013*/%>
						 <!--Below line modified for this CRF Bru-HIMS-CRF-133  -->
						 
						 <%
						 String img_temp="";
					if(isVIPimgpatfrontappl) //Added by Mujafar against ML-MMOH-CRF-1070
					{	String pat_id = p_patient_id;
						String vip_pat_yn = eOA.OACommonBean.getVIPPatient(conn,pat_id,facility_id);
						if(vip_pat_yn.equals("TRUE"))
							img_temp="<img border=0 src='../../eCommon/images/PI_VIP.gif'></img>";	
						else
							img_temp = "";
						
					
					}
					%>
					
						 
						 
						 
						  <%
						 out.println("<td  nowrap id='patname"+i+"' class='"+classValue+"'  onClick=\"displayToolTip('"+p_encounter_id+"','"+p_patient_id+"','"+visit_adm_type+"','"+locn_code+"','"+curr_loc_type+"','"+pract_id+"','"+p_queue_status+"','"+p_patient_class+"','"+CARE_LOCN_TYPE_IND+"','"+sex+"','"+DATE_OF_BIRTH+"','"+room_num+"','"+p_status+"','"+dt+"','"+APPT_ID+"','"+p_queue_date+"','"+arrival_date+"','"+curr_locn1+"','"+curr_type_desc1+"','"+VISIT_ADM_TYPE_IND+"','"+appt_case_yn+"','"+VITAL_SIGNS_DATE_TIME+"','"+ARRIVE_DATE_TIME+"','N','"+other_res_class+"','"+other_res_code+"','"+rs.getString("queue_num")+"','"+appt_walk_ind+"','"+QUEUE_ID+"','S','"+pkg_pat_yn+"','"+pkg_enc_yn+"',this,'imgArrow"+i+"','"+i+"','link"+i+"','"+episode_id+"','"+op_episode_visit_num+"','"+curr_locn_type+"','"+curr_locn_code+"','"+isPatEncMovement+"','"+Sydate+"','patname"+i+"');\" onMouseOver =\"hideToolTip(this,'imgArrow"+i+"','"+i+"');\" nowrap><a href='javascript:callDummy()' name='link"+i+"' id='link"+i+"'>"+img_temp+"<font size='1' >"+name+"<font></a><img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow"+i+"' id='imgArrow"+i+"'></td>");
						 %>
					
				<%}else{%>
					  <td class='<%=classValue%>' nowrap width='8%' onClick='openPatientChart("<%=p_encounter_id%>");' > 
					<a href="javascript:callDummy()"><FONT size=1>
					<%
					if(isVIPimgpatfrontappl) //Added by Mujafar against ML-MMOH-CRF-1070
					{	String pat_id = p_patient_id;
						String vip_pat_yn = eOA.OACommonBean.getVIPPatient(conn,pat_id,facility_id);
						if(vip_pat_yn.equals("TRUE"))
						{
					%>
					<img border=0 src='../../eCommon/images/PI_VIP.gif'></img>
					<%}}%>
					<%=name%></FONT></a>&nbsp;</td>
				  <%}
				}
			  }
			}
			
			%>
			<!--Below lines moidified by Venkatesh.S  against  Bru-HIMS-CRF-303 [IN035021] on 02-April-2013-->
			<td class='<%=classValue%>' class='QRY' nowrap>&nbsp;<font size='1'><%=rs.getString("patient_id")%></font></td>
			<td class='<%=classValue%>' class='QRY' nowrap style = 'background-color:<%=colorcode%>'>&nbsp;<font size='1'><%=rs.getString("waiting_time")==null?"":rs.getString("waiting_time")%></td>
			<td class='<%=classValue%>' class='QRY' nowrap>&nbsp;<font size='1'><%=p_status_desc%></td>

		<td class='<%=classValue%>' class='QRY' nowrap><font size='1'>&nbsp;<%=pat_cur_desc%></td>
		<td class='<%=classValue%>' class='QRY' nowrap><font size='1'>&nbsp;<%=reason_desc%></td>
		<!--Added by Thamizh selvi on 9th July 2018 against ML-MMOH-CRF-1058 Start-->
		<% if(isIncRemarksLengthAppl){ %>
			<td class='<%=classValue%>' class='QRY' nowrap>
					<% if(("").equals(apptRemarks)){ %>
						&nbsp;
					<% }else{ %>
						<font size='1'>	<a href="javascript:dispApptRemarks('<%=facility_id%>','<%=APPT_ID%>')"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Detail.label" bundle="${common_labels}"/></a></font>
					<% } %>
			</td>
		<% } %>
		<!--End-->
		<!-- Added by Ajay Hatwate for ML-MOH-CRF-1930 -->
		<% if(isVirtConsVisit && function_id.equals("MANAGE_PAT_QUEUE")){ %>
			<td class='<%=classValue%>' class='QRY' nowrap><font size='1'>&nbsp;<%=p_visit_type_desc%></td>
		<% } %>
		</tr>

		<%
			tryl++;
			prev_val = p_visit_type_desc;
			initial  = false;
			i++;
			p1++;
	} // end while
	 
   //
if (counter==0)
{ 
 out.println("<script>if(parent.searchbutton.document.forms[0].refresh.value=='Expand'){parent.searchbutton.document.forms[0].refresh.value=getLabel('Common.search.label','Common')} if(parent.frame1.document.forms[0].ChkOut.value=='ChkOut') parent.document.getElementById('frame1').style.height='34vh'; else parent.document.getElementById('frame1').style.height='38vh'; parent.document.getElementById('searchbutton').style.height='4vh';parent.document.getElementById('frame2').style.height='50vh';parent.document.getElementById('checkbox').style.height='5vh'; alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
}
boolean flag = false;
if ( counter < 20 || (!rs.next()) ) {

%>
	<script >
	
	if (document.getElementById("nextval"))
		document.getElementById("nextval").style.visibility='hidden';
	</script>
<% flag = true;
		} else {%>
	<script >
	
	if (document.getElementById("nextval"))
		document.getElementById("nextval").style.visibility='visible';
	</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%}	 
	  
	  }catch(Exception e){e.printStackTrace();}

	  if(pstmt != null) pstmt.close();
	  if(rs != null) rs.close();  

if(rs != null) rs.close();
if(pstmt != null) pstmt.close();

%>
    <input type='hidden' name='help_function_id' id='help_function_id' value='MANAGE_PAT_QUEUE'>
    <input type='hidden' name='Vitalsign' id='Vitalsign' value='<%=Vitalsign%>'>
	<input type='hidden' name='ChkOut' id='ChkOut' value='<%=ChkOut%>'>
	<input type='hidden' name='Que' id='Que' value='<%=Que%>'>
	<input type='hidden' name='rfresh_param' id='rfresh_param' value='<%=rfresh_param%>'>
	<input type='hidden' name='pkg_pat_yn' id='pkg_pat_yn' value='<%=pkg_pat_yn%>'>
	<input type='hidden' name='pkg_enc_yn' id='pkg_enc_yn' value='<%=pkg_enc_yn%>'>
	<input type='hidden' name='modalWindowOpen' id='modalWindowOpen' value='N'> <!-- added @ UAT-4 -->
	<input type='hidden' name='action_on_pending_bill' id="action_on_pending_bill" value='<%=action_on_pending_bill%>'> <!-- added for MMS-QH-CRF-0126 [IN:041880] -->
	<input type='hidden' name='bl_install_yn' id="bl_install_yn" value='<%=bl_install_yn%>'> <!-- added for MMS-QH-CRF-0126 [IN:041880] -->
	<input type='hidden' name='facility_id' id="facility_id" value='<%=facility_id%>'> <!-- added for MMS-QH-CRF-0126 [IN:041880] -->
	
	<input type="hidden" name="isPatEncMovement" id="isPatEncMovement" value="<%=isPatEncMovement%>"> <!--hidden added for this CRF Bru-HIMS-CRF-133 -->
	<input type="hidden" name="isQMSapplicable" id="isQMSapplicable" value="<%=isQMSapplicable%>">
</table>

<!-- Below lines modified by Venkatesh.S  against  Bru-HIMS-CRF-303 [IN035021] on 02-April-2013 -->
<div name='tooltiplayer' id='tooltiplayer' style=' /*width:5%;*/ visibility:hidden;' bgcolor='blue'>
 <table id='tooltiptable' cellpadding=0 cellspacing=0 border-collapse=collapse width='auto' height='100%' align='center'>
<tr><td width='100%' id='t'></td></tr>
</table>
</div>	
</div>


<br><center>

<%
// }

 sqlmain.setLength(0);
 sqlcnt.setLength(0);
 sql.setLength(0);
}
catch ( Exception e ){out.print("catch1:"+e);}

}catch(Exception e){}
finally{
	try{
	if(Cs_Lookup != null) Cs_Lookup.close();
	}catch(Exception e){}
    if(conn!=null) ConnectionManager.returnConnection(conn,request);
}
%>
</center>
 </form>
</body>
</html>
<%!
	// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equalsIgnoreCase("null"))) ? "" : inputString );
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
	}
%>

