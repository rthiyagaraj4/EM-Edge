<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,eCommon.XSSRequestWrapper" %>
<%
request.setCharacterEncoding("UTF-8");
//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue 
String locale			= (String)session.getAttribute("LOCALE");
 %>
<html>
	<head>
	<title><fmt:message key="eIP.CancelDischargePatient.label" bundle="${ip_labels}"/></title><script src='../../eIP/js/CancelDischarge.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	<style>
		body {
			display: block;
		    margin: 0px;
		}
	</style>
	</head>
<%
	String facilityId = (String)session.getValue("facility_id");
	String encounterid				= checkForNull(request.getParameter("encounterId"));
	String patient_id				= checkForNull(request.getParameter("patientId"));
	String practitioner_id			= checkForNull(request.getParameter("Practitioner_Id"));
	//String call_function			= checkForNull(request.getParameter("call_function"));
	String function_id				= checkForNull(request.getParameter("function_id"));
	
	String  auth_practitioner_id	= "";
	String  auth_practitioner_name	= "";
	String specialty_code			= "";
	String bed_type_desc			= "";
	String locn_type				= "";
	String admission_date_time		= "";
	String admission_short_desc		= ""; 
	String specialty_short_desc		= ""; 
	String practitioner_name		= "";
	String patient_type_short_desc	= "";
	String nursing_unit_short_desc	= "";
	String service_short_desc		= "";
	String bed_no					= "";
	String room_no					= "";
	String bed_class_short_desc		= "";
	String bed_type_code			= "";
	String bed_class_code			= "";
	String nursing_unit_code		= "";
	String service_code				= "";
	String patient_type				= "";
	String gender					= "";
	String to_ref_code				= "";
	String to_specialty_code		= "";
	String to_service_code			= "";
	String to_locn_type				= "";
	String to_locn_code				= "";
	String post_mortem_req_yn		= "";
	String med_lgl_case_yn			= "";
	String informed_to				= "";
	String informed_date_time		= "";
	String informed_name			= "";
	String pol_rep_no				= "";
	String pol_stn_id				= "";
	String pol_id					= "";
	String discharge_narration		= "";
	String date_of_birth			= "";
	String patient_class			= "";
	String patient_status			= "";
	String absconded_date			= "";
	String absconded_yn				= "";
	String reported_to				= "";
	String EXPECTED_DISCHARGE_DATE  = "";
	String discharge_date_time		= "";
	String	discharge_type_desc		= "";
	String medteamdesc 				= "";
	String medteamid 				= "";
	String deceased_date_time		= "";
	String discharge_summary_yn		= "";
	String take_home_new_med_yn     = "";
	String discharge_type_code      = "";
	String last_encounter_inform_to	= "";
	String last_encounter_inform_name	= "";
	String last_encounter_inform_date_time	= "";
	//String last_encounter_absconded_date = "";
	//String bed_block_date_time		= "";
	String blocking_type_code		= "";
	String high_risk_body_yn		= "";
	String body_release_date_time	= "";
	String discharge_date			= "";
	String assign_care_locn_type	= "";
	String admission_type			= "";
	String referral_id				= "";
	String disposition_type			= "";
	String discharge_status_code    = "";

	/*Added by Rameswar on 22nd May 2015 Against HSA-CRF-0181.1 [IN054123] Start*/
	String weight_on_admission		="";
	String weight_on_admission_unit	="";
	String weight_on_admission_unit_display		="";
	/*Added by Rameswar on 22nd May 2015 Against HSA-CRF-0181.1 [IN054123] End*/
	
	/*Added by KAMATCHI S on 23-JUN-2020 for ML-MMOH-CRF-1527*/
	String height_on_admission		="";
	String height_on_admission_unit	="";
	String bmi		="";
	/*Added by KAMATCHI S on 23-JUN-2020 for ML-MMOH-CRF-1527 End*/

	StringBuffer stringBuffer = new StringBuffer();
	Connection con	= null;
	Statement stmt 	= null;
	ResultSet rset	= null;
	
try
{
	con		= ConnectionManager.getConnection(request);

	//stringBuffer.append(" SELECT d.deceased_yn deceased_yn,  TO_CHAR (admission_date_time,'dd/mm/rrrr hh24:mi') admission_date_time, ip_get_desc.ip_admission_type(a.ADMISSION_TYPE, '"+locale+"',2) admission_short_desc,  am_get_desc.am_speciality(a.specialty_code,'"+locale+"',2) specialty_short_desc,   am_get_desc.am_practitioner(a.attend_practitioner_id, '"+locale+"', 1) practitioner_name,  am_get_desc.am_practitioner(a.Admit_practitioner_id, '"+locale+"', 1) practitioner_short_name,  null patient_type_short_desc,        ip_get_desc.ip_nursing_unit(a.facility_id, a.nursing_unit_code,'"+locale+"',2) nursing_unit_short_desc, am_get_desc.am_service(a.service_code,'"+locale+"',2) service_short_desc, a.bed_num bed_no,   a.room_num room_no, ip_get_desc.ip_bed_class(a.bed_class_code,'"+locale+"',2) bed_class_short_desc,   NULL dly_charge, a.patient_id patient_id,    a.bed_type_code bed_type_code, ip_get_desc.ip_bed_type(a.bed_type_code,'"+locale+"',2) bed_type_short_desc, a.bed_class_code bed_class_code, a.attend_practitioner_id practitioner_id,    a.specialty_code, a.nursing_unit_code, a.service_code, null patient_type,     b.sex gender, TO_CHAR (b.date_of_birth, 'dd/mm/rrrr') date_of_birth,  'N' locn_type,   TO_CHAR (c.expected_discharge_date, 'dd/mm/rrrr hh24:mi' ) expected_discharge_date,  TO_CHAR (a.discharge_date_time, 'dd/mm/rrrr hh24:mi' ) discharge_date_time, c.auth_practitioner_id cauth_practitioner_id, (case when c.auth_practitioner_id is not null then   am_get_desc.am_practitioner(c.auth_practitioner_id, '"+locale+"', 1) end) auth_practitioner_name, c.referred_yn, c.to_hcare_setting_type, c.to_ref_type, c.to_ref_code,   c.referral_priority,  TO_CHAR (c.preferred_treatment_date,'dd/mm/rrrr') preferred_treatment_date, c.to_specialty_code, c.to_service_code, c.to_locn_type,c.post_mortem_req_yn, c.to_locn_code, c.to_pract_id, c.to_pract_name,c.med_lgl_case_yn, c.informed_to,  TO_CHAR (c.informed_date_time,'dd/mm/rrrr hh24:mi') informed_date_time, c.informed_name, c.pol_rep_no, c.pol_stn_id, c.pol_id, c.discharge_narration,  c.to_locn_desc, c.referred_for_ip, a.patient_class, c.ref_notes,  TO_CHAR (c.absconded_date, 'dd/mm/rrrr hh24:mi') absconded_date,  c.absconded_yn, c.reported_to, a.team_id, am_get_desc.am_medical_team(a.facility_id, a.team_id, '"+locale+"', 2) team_short_desc,tO_CHAR (c.DECEASED_DATE_TIME,'dd/mm/rrrr hh24:mi') DECEASED_DATE_TIME, c.discharge_summary_yn, c.take_home_new_med_yn, c.discharge_type_code, ip_get_desc.ip_discharge_type(a.DISCHARGE_TYPE_CODE,'"+locale+"',2) discharge_type_desc FROM IP_PATIENT_LAST_ENCOUNTER a, MP_PATIENT b, IP_DISCHARGE_ADVICE c, IP_DISCHARGE_TYPE d  WHERE a.facility_id = '"+facilityId+"'    AND a.encounter_id = '"+encounterid+"'    AND a.patient_id = b.patient_id AND a.facility_id = c.facility_id    AND a.encounter_id = c.encounter_id    AND c.dis_Adv_srl_no like '%%'AND c.dis_adv_status = '1' AND c.discharge_type_code = d.discharge_type_code ");

	
	stringBuffer.append(" SELECT ");
	stringBuffer.append(" d.deceased_yn deceased_yn ");
	stringBuffer.append(" , TO_CHAR (a.visit_adm_date_time,'dd/mm/rrrr hh24:mi') admission_date_time ");
	stringBuffer.append(" , a.visit_adm_type admission_type");
	stringBuffer.append(" , ip_get_desc.ip_admission_type(a.visit_adm_type, '"+locale+"',2) admission_short_desc ");
	stringBuffer.append(" , am_get_desc.am_speciality(a.specialty_code,'"+locale+"',2) specialty_short_desc ");
	//stringBuffer.append(" , am_get_desc.am_practitioner(a.attend_practitioner_id,'"+locale+"',1) practitioner_name ");
	stringBuffer.append(" , am_get_desc.am_practitioner(a.disch_practitioner_id,'"+locale+"',1) practitioner_name ");
	stringBuffer.append(" , am_get_desc.am_practitioner(a.Admit_practitioner_id, '"+locale+"', 1) practitioner_short_name ");
	stringBuffer.append(" , null patient_type_short_desc ");
	stringBuffer.append(" , ip_get_desc.ip_nursing_unit(a.facility_id, a.assign_care_locn_code,'"+locale+"',2) nursing_unit_short_desc ");
	stringBuffer.append(" , am_get_desc.am_service(a.service_code,'"+locale+"',2) service_short_desc ");
	stringBuffer.append(" , a.assign_bed_num bed_no ");
	stringBuffer.append(" , a.assign_room_num room_no ");
	stringBuffer.append(" , ip_get_desc.ip_bed_class(a.assign_bed_class_code,'"+locale+"',2) bed_class_short_desc ");
	stringBuffer.append(" , NULL dly_charge ");
	stringBuffer.append(" , a.patient_id patient_id ");
	stringBuffer.append(" , a.assign_bed_type_code bed_type_code ");
	stringBuffer.append(" , ip_get_desc.ip_bed_type(a.assign_bed_type_code,'"+locale+"',2) bed_type_short_desc ");
	stringBuffer.append(" , a.assign_bed_class_code bed_class_code ");
	//stringBuffer.append(" , a.attend_practitioner_id practitioner_id ");
	stringBuffer.append(" , a.disch_practitioner_id practitioner_id ");
	stringBuffer.append(" , a.specialty_code ");
	stringBuffer.append(" , a.assign_care_locn_type ");
	stringBuffer.append(" , a.assign_care_locn_code nursing_unit_code");
	stringBuffer.append(" , a.service_code ");
	stringBuffer.append(" , null patient_type ");
	stringBuffer.append(" , b.sex gender ");
	stringBuffer.append(" , TO_CHAR (b.date_of_birth, 'dd/mm/rrrr') date_of_birth ");
	stringBuffer.append(" , 'N' locn_type ");
	stringBuffer.append(" , TO_CHAR (c.expected_discharge_date, 'dd/mm/rrrr hh24:mi' ) expected_discharge_date ");
	stringBuffer.append(" , TO_CHAR (a.discharge_date_time, 'dd/mm/rrrr hh24:mi' ) discharge_date_time ");
	stringBuffer.append(" , TO_CHAR (a.discharge_date_time, 'dd/mm/rrrr' ) discharge_date ");
	stringBuffer.append(" , c.auth_practitioner_id cauth_practitioner_id ");
	stringBuffer.append(" , ( CASE WHEN c.auth_practitioner_id IS not null THEN ");
	stringBuffer.append(" am_get_desc.am_practitioner(c.auth_practitioner_id, '"+locale+"', 1)  ");
	stringBuffer.append(" END) auth_practitioner_name ");
	stringBuffer.append(" , TO_CHAR (c.absconded_date, 'dd/mm/rrrr hh24:mi') absconded_date ");
	stringBuffer.append(" , TO_CHAR (c.informed_date_time,'dd/mm/rrrr hh24:mi') informed_date_time ");
	stringBuffer.append(" , TO_CHAR (c.preferred_treatment_date,'dd/mm/rrrr') preferred_treatment_date ");
	stringBuffer.append(" , TO_CHAR (a.BODY_RELEASE_DATE_TIME,'dd/mm/rrrr hh24:mi') body_release_date_time");	
	stringBuffer.append(" , a.patient_class ");
	stringBuffer.append(" , a.team_id ");
	stringBuffer.append(" , am_get_desc.am_medical_team(a.facility_id, a.team_id, '"+locale+"', 2) team_short_desc ");
	stringBuffer.append(" , a.high_risk_yn ");	
	stringBuffer.append(" , c.absconded_yn ");
	stringBuffer.append(" , c.discharge_narration ");
	stringBuffer.append(" , c.discharge_summary_yn ");
	stringBuffer.append(" , c.discharge_type_code ");
	stringBuffer.append(" , c.informed_name ");
	stringBuffer.append(" , c.informed_to ");
	stringBuffer.append(" , c.pol_id ");
	stringBuffer.append(" , c.pol_rep_no ");
	stringBuffer.append(" , c.pol_stn_id ");
	stringBuffer.append(" , c.ref_notes ");
	stringBuffer.append(" , c.referral_priority ");
	stringBuffer.append(" , c.referred_for_ip ");
	stringBuffer.append(" , c.referred_yn ");
	stringBuffer.append(" , c.reported_to ");
	stringBuffer.append(" , c.take_home_new_med_yn ");
	stringBuffer.append(" , c.to_hcare_setting_type ");
	stringBuffer.append(" , c.to_locn_code ");
	stringBuffer.append(" , c.to_locn_desc ");
	stringBuffer.append(" , c.to_locn_type ");
	stringBuffer.append(" , c.to_pract_id ");
	stringBuffer.append(" , c.to_pract_name ");
	stringBuffer.append(" , c.to_ref_code ");
	stringBuffer.append(" , c.to_ref_type ");
	stringBuffer.append(" , c.to_service_code ");
	stringBuffer.append(" , c.to_specialty_code ");
	stringBuffer.append(" , ip_get_desc.ip_discharge_type(a.disposition_type,'"+locale+"',2)discharge_type_desc ");
	stringBuffer.append(" ,TO_CHAR (c.DECEASED_DATE_TIME,'dd/mm/rrrr hh24:mi') DECEASED_DATE_TIME ");
	stringBuffer.append(" ,c.med_lgl_case_yn ");
	//stringBuffer.append(" ,c.post_mortem_req_yn ");
	stringBuffer.append(" ,a.pm_yn post_mortem_req_yn ");
	stringBuffer.append(" ,a.disposition_type ");
	stringBuffer.append(" ,a.discharge_status_code ");
	stringBuffer.append(" ,a.referral_id ");	

	/*Added by Rameswar on 22nd May 2015 Against HSA-CRF-0181.1 [IN054123] Start*/
	stringBuffer.append(" ,a.weight_on_admission");
	stringBuffer.append(" ,a.weight_on_admission_unit");
	/*Added by Rameswar on 22nd May 2015 Against HSA-CRF-0181.1 [IN054123] End*/
	
	/*Added by KAMATCHI S on 23-JUN-2020 for ML-MMOH-CRF-1527*/
	stringBuffer.append(" ,a.height_on_admission");
	stringBuffer.append(" ,a.bmi");
	/*Added by KAMATCHI S on 23-JUN-2020 for ML-MMOH-CRF-1527 End*/

	stringBuffer.append(" FROM ");
	stringBuffer.append(" PR_ENCOUNTER a ");
	stringBuffer.append(" , MP_PATIENT b ");
	stringBuffer.append(" , IP_DISCHARGE_ADVICE c ");
	stringBuffer.append(" , IP_DISCHARGE_TYPE d  ");
	stringBuffer.append(" WHERE a.facility_id = '"+facilityId+"' ");
	stringBuffer.append(" AND a.encounter_id = '"+encounterid+"' ");
	stringBuffer.append(" AND a.patient_id = b.patient_id  ");
	stringBuffer.append(" AND a.facility_id = c.facility_id  ");
	stringBuffer.append(" AND a.encounter_id = c.encounter_id  ");
	stringBuffer.append(" AND c.dis_adv_status = '1'  ");
	stringBuffer.append(" AND c.discharge_type_code = d.discharge_type_code ");



	/*stringBuffer.append(" SELECT ");
	stringBuffer.append(" d.deceased_yn deceased_yn ");
	stringBuffer.append(" , TO_CHAR (admission_date_time,'dd/mm/rrrr hh24:mi') admission_date_time ");
	stringBuffer.append(" , ip_get_desc.ip_admission_type(a.ADMISSION_TYPE, '"+locale+"',2) admission_short_desc ");
	stringBuffer.append(" , am_get_desc.am_speciality(a.specialty_code,'"+locale+"',2) specialty_short_desc ");
	stringBuffer.append(" , am_get_desc.am_practitioner(a.attend_practitioner_id,'"+locale+"',1) practitioner_name ");
	stringBuffer.append(" , am_get_desc.am_practitioner(a.Admit_practitioner_id, '"+locale+"', 1) practitioner_short_name ");
	stringBuffer.append(" , null patient_type_short_desc ");
	stringBuffer.append(" , ip_get_desc.ip_nursing_unit(a.facility_id, a.nursing_unit_code,'"+locale+"',2) nursing_unit_short_desc ");
	stringBuffer.append(" , am_get_desc.am_service(a.service_code,'"+locale+"',2) service_short_desc ");
	stringBuffer.append(" , a.bed_num bed_no ");
	stringBuffer.append(" , a.room_num room_no ");
	stringBuffer.append(" , ip_get_desc.ip_bed_class(a.bed_class_code,'"+locale+"',2) bed_class_short_desc ");
	stringBuffer.append(" , NULL dly_charge ");
	stringBuffer.append(" , a.patient_id patient_id ");
	stringBuffer.append(" , a.bed_type_code bed_type_code ");
	stringBuffer.append(" , ip_get_desc.ip_bed_type(a.bed_type_code,'"+locale+"',2) bed_type_short_desc ");
	stringBuffer.append(" , a.bed_class_code bed_class_code ");
	stringBuffer.append(" , a.attend_practitioner_id practitioner_id ");
	stringBuffer.append(" , a.specialty_code ");
	stringBuffer.append(" , a.nursing_unit_code ");
	stringBuffer.append(" , a.service_code ");
	stringBuffer.append(" , null patient_type ");
	stringBuffer.append(" , b.sex gender ");
	stringBuffer.append(" , TO_CHAR (b.date_of_birth, 'dd/mm/rrrr') date_of_birth ");
	stringBuffer.append(" , 'N' locn_type ");
	stringBuffer.append(" , TO_CHAR (c.expected_discharge_date, 'dd/mm/rrrr hh24:mi' ) expected_discharge_date ");
	stringBuffer.append(" , TO_CHAR (a.discharge_date_time, 'dd/mm/rrrr hh24:mi' ) discharge_date_time ");
	stringBuffer.append(" , c.auth_practitioner_id cauth_practitioner_id ");
	stringBuffer.append(" , ( CASE WHEN c.auth_practitioner_id IS not null THEN ");
	stringBuffer.append(" am_get_desc.am_practitioner(c.auth_practitioner_id, '"+locale+"', 1)  ");
	stringBuffer.append(" END) auth_practitioner_name ");
	stringBuffer.append(" , TO_CHAR (c.absconded_date, 'dd/mm/rrrr hh24:mi') absconded_date ");
	stringBuffer.append(" , TO_CHAR (c.informed_date_time,'dd/mm/rrrr hh24:mi') informed_date_time ");
	stringBuffer.append(" , TO_CHAR (c.preferred_treatment_date,'dd/mm/rrrr') preferred_treatment_date ");
	stringBuffer.append(" , a.patient_class ");
	stringBuffer.append(" , a.team_id ");
	stringBuffer.append(" , am_get_desc.am_medical_team(a.facility_id, a.team_id, '"+locale+"', 2) team_short_desc ");
	stringBuffer.append(" , c.absconded_yn ");
	stringBuffer.append(" , c.discharge_narration ");
	stringBuffer.append(" , c.discharge_summary_yn ");
	stringBuffer.append(" , c.discharge_type_code ");
	stringBuffer.append(" , c.informed_name ");
	stringBuffer.append(" , c.informed_to ");
	stringBuffer.append(" , c.pol_id ");
	stringBuffer.append(" , c.pol_rep_no ");
	stringBuffer.append(" , c.pol_stn_id ");
	stringBuffer.append(" , c.ref_notes ");
	stringBuffer.append(" , c.referral_priority ");
	stringBuffer.append(" , c.referred_for_ip ");
	stringBuffer.append(" , c.referred_yn ");
	stringBuffer.append(" , c.reported_to ");
	stringBuffer.append(" , c.take_home_new_med_yn ");
	stringBuffer.append(" , c.to_hcare_setting_type ");
	stringBuffer.append(" , c.to_locn_code ");
	stringBuffer.append(" , c.to_locn_desc ");
	stringBuffer.append(" , c.to_locn_type ");
	stringBuffer.append(" , c.to_pract_id ");
	stringBuffer.append(" , c.to_pract_name ");
	stringBuffer.append(" , c.to_ref_code ");
	stringBuffer.append(" , c.to_ref_type ");
	stringBuffer.append(" , c.to_service_code ");
	stringBuffer.append(" , c.to_specialty_code ");
	stringBuffer.append(" , ip_get_desc.ip_discharge_type(a.DISCHARGE_TYPE_CODE,'"+locale+"',2)discharge_type_desc ");
	stringBuffer.append(" ,TO_CHAR (c.DECEASED_DATE_TIME,'dd/mm/rrrr hh24:mi') DECEASED_DATE_TIME ");
	stringBuffer.append(" ,c.med_lgl_case_yn ");
	stringBuffer.append(" ,c.post_mortem_req_yn ");
	stringBuffer.append(" FROM ");
	stringBuffer.append(" IP_PATIENT_LAST_ENCOUNTER a ");
	stringBuffer.append(" , MP_PATIENT b ");
	stringBuffer.append(" , IP_DISCHARGE_ADVICE c ");
	stringBuffer.append(" , IP_DISCHARGE_TYPE d  ");
	stringBuffer.append(" WHERE a.facility_id = '"+facilityId+"' ");
	stringBuffer.append(" AND a.encounter_id = '"+encounterid+"' ");
	stringBuffer.append(" AND a.patient_id = b.patient_id  ");
	stringBuffer.append(" AND a.facility_id = c.facility_id  ");
	stringBuffer.append(" AND a.encounter_id = c.encounter_id  ");
	stringBuffer.append(" AND c.dis_adv_status = '1'  ");
	stringBuffer.append(" AND c.discharge_type_code = d.discharge_type_code ");
*/
	

	
	stmt = con.createStatement();
	rset	 =	 stmt.executeQuery(stringBuffer.toString());
	
	if(rset != null && rset.next())
	{
		EXPECTED_DISCHARGE_DATE		= checkForNull(rset.getString("expected_discharge_date"));//
		absconded_date				= checkForNull(rset.getString("ABSCONDED_DATE"));
		absconded_yn				= checkForNull(rset.getString("ABSCONDED_YN"));
		admission_date_time			= checkForNull(rset.getString("admission_date_time"));
		admission_short_desc		= checkForNull(rset.getString("admission_short_desc"));
		auth_practitioner_id 		= checkForNull(rset.getString("cauth_practitioner_id"), practitioner_id);
		auth_practitioner_name		= checkForNull(rset.getString("auth_practitioner_name"), practitioner_name);//
		bed_class_code				= checkForNull(rset.getString("bed_class_code"));
		bed_class_short_desc		= checkForNull(rset.getString("bed_class_short_desc"));
		bed_no						= checkForNull(rset.getString("bed_no"));
		bed_type_code				= checkForNull(rset.getString("bed_type_code"));
		bed_type_desc				= checkForNull(rset.getString("bed_type_short_desc"));
		date_of_birth				= checkForNull(rset.getString("date_of_birth"));
		deceased_date_time			= checkForNull(rset.getString("DECEASED_DATE_TIME"));
		discharge_date_time			= checkForNull(rset.getString("discharge_date_time"));//
		discharge_narration			= checkForNull(rset.getString("discharge_narration"));
		discharge_summary_yn		= checkForNull(rset.getString("discharge_summary_yn"));
		discharge_type_code         = checkForNull(rset.getString("discharge_type_code"));
		discharge_type_desc			= checkForNull(rset.getString("discharge_type_desc"));//
		gender						= checkForNull(rset.getString("gender"));
		informed_date_time			= checkForNull(rset.getString("informed_date_time")); 
		informed_name				= checkForNull(rset.getString("informed_name"));
		informed_to					= checkForNull(rset.getString("informed_to"));
		locn_type					= checkForNull(rset.getString("locn_type"));
		med_lgl_case_yn				= checkForNull(rset.getString("med_lgl_case_yn"));
		medteamdesc                 = checkForNull(rset.getString("team_short_desc"));
		medteamid	                = checkForNull(rset.getString("team_id"));
		nursing_unit_code			= checkForNull(rset.getString("nursing_unit_code"));
		nursing_unit_short_desc		= checkForNull(rset.getString("nursing_unit_short_desc"));
		patient_class				= checkForNull(rset.getString("patient_class"));
		patient_id					= checkForNull(rset.getString("patient_id"));
		patient_type				= checkForNull(rset.getString("patient_type"));
		patient_type_short_desc		= checkForNull(rset.getString("patient_type_short_desc"));
		pol_id						= checkForNull(rset.getString("pol_id"));
		pol_rep_no					= checkForNull(rset.getString("pol_rep_no"));
		pol_stn_id					= checkForNull(rset.getString("pol_stn_id"));
		post_mortem_req_yn			= checkForNull(rset.getString("post_mortem_req_yn"));
		practitioner_id				= checkForNull(rset.getString("practitioner_id"));
		practitioner_name			= checkForNull(rset.getString("practitioner_name"));//
		reported_to					= checkForNull(rset.getString("REPORTED_TO"));
		room_no						= checkForNull(rset.getString("room_no"));
		service_code				= checkForNull(rset.getString("service_code"));
		service_short_desc			= checkForNull(rset.getString("service_short_desc"));
		specialty_code				= checkForNull(rset.getString("specialty_code")); 
		specialty_short_desc		= checkForNull(rset.getString("specialty_short_desc"));
		take_home_new_med_yn		= checkForNull(rset.getString("take_home_new_med_yn"));
		to_locn_code				= checkForNull(rset.getString("to_locn_code"));
		to_locn_type				= checkForNull(rset.getString("to_locn_type"));
		to_ref_code					= checkForNull(rset.getString("to_ref_code"));
		to_service_code				= checkForNull(rset.getString("to_service_code"));
		to_specialty_code			= checkForNull(rset.getString("to_specialty_code"));
		high_risk_body_yn			= checkForNull(rset.getString("high_risk_yn"));
		body_release_date_time		= checkForNull(rset.getString("body_release_date_time"));
		discharge_date				= checkForNull(rset.getString("discharge_date"));
		assign_care_locn_type		= checkForNull(rset.getString("assign_care_locn_type"));
		admission_type				= checkForNull(rset.getString("admission_type"));
		disposition_type 			= checkForNull(rset.getString("disposition_type"));
		referral_id		 			= checkForNull(rset.getString("referral_id"));
		discharge_status_code		= checkForNull(rset.getString("discharge_status_code"));

		/*Added by Rameswar on 22nd May 2015 Against HSA-CRF-0181.1 [IN054123] Start*/
		weight_on_admission			= checkForNull(rset.getString("weight_on_admission"));
		weight_on_admission_unit	= checkForNull(rset.getString("weight_on_admission_unit"));
		/*Added by Rameswar on 22nd May 2015 Against HSA-CRF-0181.1 [IN054123] End*/
		
		/*Added by KAMATCHI S on 23-JUN-2020 for ML-MMOH-CRF-1527*/
		height_on_admission			= checkForNull(rset.getString("height_on_admission"));
		bmi	= checkForNull(rset.getString("bmi"));
		/*Added by KAMATCHI S on 23-JUN-2020 for ML-MMOH-CRF-1527 End*/

		
	}
		if(rset != null) rset.close(); 
		if(stmt != null) stmt.close();
			/*
			pageContext.setAttribute("discharge_narration",discharge_narration,pageContext.SESSION_SCOPE);
			pageContext.setAttribute("reported_to",reported_to,pageContext.SESSION_SCOPE);
			pageContext.setAttribute("informed_name",informed_name,pageContext.SESSION_SCOPE);
			pageContext.setAttribute("pol_rep_no",pol_rep_no,pageContext.SESSION_SCOPE);
			pageContext.setAttribute("pol_stn_id",pol_stn_id,pageContext.SESSION_SCOPE);
			pageContext.setAttribute("pol_id",pol_id,pageContext.SESSION_SCOPE);
			pageContext.setAttribute("blocking_remarks",blocking_remarks,pageContext.SESSION_SCOPE);
			*/
	
		weight_on_admission_unit_display=(weight_on_admission_unit.equals("K"))?"Kg":(weight_on_admission_unit.equals("G"))?"Gram":""; //Added by Rameswar on 22nd May 2015 Against HSA-CRF-0181.1 [IN054123]
		height_on_admission_unit=(height_on_admission.equals(""))?"":"Cm";//Added by KAMATCHI S on 23-JUN-2020 for ML-MMOH-CRF-1527
	%>	
		<!-- IP_17591  <frameset id='cancel_discharge_frame' rows='2.5,8,14,2,2' border=0> Wednesday, December 23, 2009	-->
		<iframe name="PatientLine_frame" id="PatientLine_frame" src="../../eCommon/jsp/pline.jsp?EncounterId=<%=encounterid%>&<%=request.getQueryString()%>" scrolling='no' noresize style='height:8vh;width:100vw'></iframe>

		<!--<frame name="Transfer_frame_display" id="Transfer_frame_display" src="addModifyDischargePatient.jsp?encounter_id=<%=java.net.URLEncoder.encode(encounterid,"UTF-8")%>&<%=request.getQueryString()%>&admission_date_time=<%=java.net.URLEncoder.encode(admission_date_time,"UTF-8")%>&admission_short_desc=<%=java.net.URLEncoder.encode(admission_short_desc,"UTF-8")%>&specialty_short_desc=<%=java.net.URLEncoder.encode(specialty_short_desc,"UTF-8")%>&practitioner_name=<%=java.net.URLEncoder.encode(practitioner_name,"UTF-8")%>&nursing_unit_short_desc=<%=java.net.URLEncoder.encode(nursing_unit_short_desc,"UTF-8")%>&service_short_desc=<%=java.net.URLEncoder.encode(service_short_desc,"UTF-8")%>&bed_no=<%=java.net.URLEncoder.encode(bed_no,"UTF-8")%>&room_no=<%=java.net.URLEncoder.encode(room_no,"UTF-8")%>&bed_class_short_desc=<%=java.net.URLEncoder.encode(bed_class_short_desc,"UTF-8")%>&practitioner_id=<%=java.net.URLEncoder.encode(practitioner_id,"UTF-8")%>&bed_type_desc=<%=java.net.URLEncoder.encode(bed_type_desc,"UTF-8")%>&medteamid=<%=java.net.URLEncoder.encode(medteamid,"UTF-8")%>&medteamdesc=<%=java.net.URLEncoder.encode(medteamdesc,"UTF-8")%>" scrolling='no' noresize>-->
		<!--Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527-->
		<!--Modified by Rameswar on 22nd May 2015 Against HSA-CRF-0181.1 [IN054123] Start-->
		<iframe name="Transfer_frame_display" id="Transfer_frame_display" src="addModifyDischargePatient.jsp?encounter_id=<%=java.net.URLEncoder.encode(encounterid,"UTF-8")%>&<%=request.getQueryString()%>&admission_date_time=<%=java.net.URLEncoder.encode(admission_date_time,"UTF-8")%>&admission_short_desc=<%=java.net.URLEncoder.encode(admission_short_desc,"UTF-8")%>&specialty_short_desc=<%=java.net.URLEncoder.encode(specialty_short_desc,"UTF-8")%>&practitioner_name=<%=java.net.URLEncoder.encode(practitioner_name,"UTF-8")%>&nursing_unit_short_desc=<%=java.net.URLEncoder.encode(nursing_unit_short_desc,"UTF-8")%>&service_short_desc=<%=java.net.URLEncoder.encode(service_short_desc,"UTF-8")%>&bed_no=<%=java.net.URLEncoder.encode(bed_no,"UTF-8")%>&room_no=<%=java.net.URLEncoder.encode(room_no,"UTF-8")%>&bed_class_short_desc=<%=java.net.URLEncoder.encode(bed_class_short_desc,"UTF-8")%>&practitioner_id=<%=java.net.URLEncoder.encode(practitioner_id,"UTF-8")%>&bed_type_desc=<%=java.net.URLEncoder.encode(bed_type_desc,"UTF-8")%>&medteamid=<%=java.net.URLEncoder.encode(medteamid,"UTF-8")%>&medteamdesc=<%=java.net.URLEncoder.encode(medteamdesc,"UTF-8")%>&weight_on_admission=<%=weight_on_admission%>&patient_class=<%=patient_class%>&weight_on_admission_unit=<%=weight_on_admission_unit%>&weight_on_admission_unit_display=<%=weight_on_admission_unit_display%>&height_on_admission=<%=height_on_admission%>&height_on_admission_unit=<%=height_on_admission_unit%>&bmi=<%=bmi%>" scrolling='auto' noresize style='height:33vh;width:100vw'></iframe>
		<!--Modified by Rameswar on 22nd May 2015 Against HSA-CRF-0181.1 [IN054123] End-->
		<!--Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527-->
		<iframe name="Transfer_frame" id="Transfer_frame" src="addModifyCancelDischargePatientTabs.jsp?encounter_id=<%=encounterid%>&to_ref_code=<%=to_ref_code%>&to_specialty_code=<%=to_specialty_code%>&to_service_code=<%=to_service_code%>&to_locn_type=<%=to_locn_type%>&post_mortem_req_yn=<%=post_mortem_req_yn%>&to_locn_code=<%=to_locn_code%>&med_lgl_case_yn=<%=med_lgl_case_yn%>&informed_to=<%=java.net.URLEncoder.encode(informed_to,"UTF-8")%>&informed_date_time=<%=java.net.URLEncoder.encode(informed_date_time,"UTF-8")%>&admission_date_time=<%=java.net.URLEncoder.encode(admission_date_time,"UTF-8")%>&admission_short_desc=<%=java.net.URLEncoder.encode(admission_short_desc,"UTF-8")%>&specialty_short_desc=<%=java.net.URLEncoder.encode(specialty_short_desc,"UTF-8")%>&practitioner_name=<%=java.net.URLEncoder.encode(practitioner_name,"UTF-8")%>&patient_type_short_desc=<%=java.net.URLEncoder.encode(patient_type_short_desc,"UTF-8")%>&nursing_unit_short_desc=<%=java.net.URLEncoder.encode(nursing_unit_short_desc,"UTF-8")%>&service_short_desc=<%=java.net.URLEncoder.encode(service_short_desc,"UTF-8")%>&bed_no=<%=bed_no%>&room_no=<%=room_no%>&bed_class_short_desc=<%=java.net.URLEncoder.encode(bed_class_short_desc,"UTF-8")%>&patient_id=<%=patient_id%>&bed_type_code=<%=bed_type_code%>&bed_class_code=<%=bed_class_code%>&practitioner_id=<%=practitioner_id%>&bed_type_desc=<%=java.net.URLEncoder.encode(bed_type_desc,"UTF-8")%>&specialty_code=<%=specialty_code%>&auth_practitioner_id=<%=auth_practitioner_id%>&auth_practitioner_name=<%=java.net.URLEncoder.encode(auth_practitioner_name,"UTF-8")%>&nursing_unit_code=<%=nursing_unit_code%>&discharge_type_desc=<%=discharge_type_desc%>&service_code=<%=service_code%>&patient_type=<%=patient_type%>&gender=<%=gender%>&date_of_birth=<%=java.net.URLEncoder.encode(date_of_birth,"UTF-8")%>&locn_type=<%=locn_type%>&patient_class=<%=patient_class%>&patient_status=<%=patient_status%>&absconded_date=<%=java.net.URLEncoder.encode(absconded_date,"UTF-8")%>&absconded_yn=<%=absconded_yn%>&discharge_date_time=<%=java.net.URLEncoder.encode(discharge_date_time,"UTF-8")%>&EXPECTED_DISCHARGE_DATE=<%=java.net.URLEncoder.encode(EXPECTED_DISCHARGE_DATE,"UTF-8")%>&medteamid=<%=medteamid%>&medteamdesc=<%=java.net.URLEncoder.encode(medteamdesc,"UTF-8")%>&deceased_date_time=<%=java.net.URLEncoder.encode(deceased_date_time,"UTF-8")%>&discharge_summary_yn=<%=discharge_summary_yn%>&take_home_new_med_yn=<%=take_home_new_med_yn%>&discharge_type_code=<%=discharge_type_code%>&last_encounter_inform_to=<%=last_encounter_inform_to%>&last_encounter_inform_name=<%=java.net.URLEncoder.encode(last_encounter_inform_name,"UTF-8")%>&last_encounter_inform_date_time=<%=java.net.URLEncoder.encode(last_encounter_inform_date_time,"UTF-8")%>&blocking_type_code=<%=blocking_type_code%>&high_risk_body_yn=<%=high_risk_body_yn%>&body_release_date_time=<%=java.net.URLEncoder.encode(body_release_date_time,"UTF-8")%>&discharge_date=<%=java.net.URLEncoder.encode(discharge_date,"UTF-8")%>&assign_care_locn_type=<%=assign_care_locn_type%>&admission_type=<%=admission_type%>&disposition_type=<%=disposition_type%>&referral_id=<%=referral_id%>&discharge_status_code=<%=discharge_status_code%>&function_id=<%=function_id%>" scrolling='auto' noresize style='height:40vh;width:100vw'></iframe>

		<iframe name="Transfer_frame_buttons" id="Transfer_frame_buttons" src="addModifyDischargePatientButtons.jsp?encounter_id=encounterid&<%=request.getQueryString()%>" scrolling='no' noresize style='height:5vh;width:100vw'></iframe>
		<iframe src="../../eCommon/jsp/error.jsp" name="message_frame" id="message_frame" scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
		<!--<frame src="../../eCommon/jsp/error.jsp" name="msg_frame" id="msg_frame" scrolling='yes' noresize>-->
</html>
<%	}catch(Exception e)
	{
		out.print("Exception "+e);
	}	
	finally   
	{
		ConnectionManager.returnConnection(con,request);
	}
%>




<%!
	// By Sridhar R  March 8th 2005, to handle NullPointerException.
	public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
	}
%>

