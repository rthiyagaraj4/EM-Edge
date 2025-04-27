<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*, com.ehis.util.*,eCommon.XSSRequestWrapper" %>
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
	<head><title> <fmt:message key="Common.DischargePatient.label" bundle="${common_labels}"/></title></head>
<%
	String facilityId = (String)session.getValue("facility_id");
	String encounterid				= checkForNull(request.getParameter("encounterId"));
	String patient_id				= checkForNull(request.getParameter("patientId"));

	String practitioner_id			= checkForNull(request.getParameter("Practitioner_Id"));
//	String function_id				= checkForNull(request.getParameter("function_id"));

	//String call_function			= checkForNull(request.getParameter("call_function"));
	
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
	String medteamdesc 				= "";
	String medteamid 				= "";
	String deceased_date_time		= "";
	String discharge_summary_yn		= "";
	String take_home_new_med_yn     = "";
	String discharge_type_code      = "";
	String subservice_code          = "";
    //added on for 3-07-2008 SCR 3228
	String discharge_status_code    = "";
	String indicator                = "";
//	String discharge_type_desc		= "";
	String pseudo_bed_yn			= "";
	String disch_reason_mand_yn=checkForNull(request.getParameter("disch_reason_mand_yn"));
	String allow_late_discharge_reason=checkForNull(request.getParameter("allow_late_discharge_reason"));
	
	String daycare_unit_code=""; //Added for this CRF HSa-CRF-0306.1
	StringBuffer stringBuffer		= new StringBuffer();
	Connection con					= null;
	Statement stmt 					= null;
	ResultSet rset					= null;
	
	/*Added By Dharma on Oct 29th 2014 against HSA-CRF-0181 [IN:049541]  Start*/
	String age								= "";
	String weight_on_admission				= "";
	String weight_on_admission_unit			= "";
	String weight_on_admission_unit_display	= "";
	String weight_on_admn_mandatory			= checkForNull(request.getParameter("weight_on_admn_mandatory"));
	String is_validate_weight_on_admission	= (weight_on_admn_mandatory.equals("D")?"Y":"N");
	String is_value_already_captured		= "";
	int no_of_days							= 0;
	/*Added By Dharma on Oct 29th 2014 against HSA-CRF-0181 [IN:049541]  End*/
	
	/*Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527*/
	String height_on_admission				= "";
	String height_on_admission_unit			= "";
	String bmi	= "";
	String is_value_already_captured_height="";
	String height_on_admn_mandatory			= checkForNull(request.getParameter("height_on_admn_mandatory"));
	String enable_height_bmi_pat_cls		= checkForNull(request.getParameter("enable_height_bmi_pat_cls"));
	String is_validate_height_on_admission	= (height_on_admn_mandatory.equals("D")?"Y":"N");
	/*Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527 END */
	
	try
	{
try
	{
	con		= ConnectionManager.getConnection(request);

	 //c.discharge_status_code added in query on 3-07-2008 SCR 3228 
	 stringBuffer.append("SELECT d.deceased_yn deceased_yn,d.indicator indicator,  TO_CHAR (admission_date_time,'dd/mm/rrrr hh24:mi') admission_date_time, ip_get_desc.ip_admission_type(a.ADMISSION_TYPE, '"+locale+"',2) admission_short_desc,  am_get_desc.am_speciality(a.specialty_code,'"+locale+"',2) specialty_short_desc,   am_get_desc.am_practitioner(a.attend_practitioner_id, '"+locale+"', 1) practitioner_name,  am_get_desc.am_practitioner(a.Admit_practitioner_id, '"+locale+"', 1) practitioner_short_name,  null patient_type_short_desc,        ip_get_desc.ip_nursing_unit(a.facility_id, a.nursing_unit_code,'"+locale+"',2) nursing_unit_short_desc, am_get_desc.am_service(a.service_code,'"+locale+"',2) service_short_desc, a.bed_num bed_no,   a.room_num room_no, ip_get_desc.ip_bed_class(a.bed_class_code,'"+locale+"',2) bed_class_short_desc,   NULL dly_charge, a.patient_id patient_id,    a.bed_type_code bed_type_code, ip_get_desc.ip_bed_type(a.bed_type_code,'"+locale+"',2) bed_type_short_desc,       a.bed_class_code bed_class_code, a.attend_practitioner_id practitioner_id,    a.specialty_code, a.nursing_unit_code,a.dc_unit_code, a.service_code, a.subservice_code,null patient_type,     b.sex gender, TO_CHAR (b.date_of_birth, 'dd/mm/rrrr') date_of_birth,  'N' locn_type,   TO_CHAR (c.expected_discharge_date, 'dd/mm/rrrr hh24:mi' ) expected_discharge_date,   c.auth_practitioner_id cauth_practitioner_id, (case when c.auth_practitioner_id is not null then   am_get_desc.am_practitioner(c.auth_practitioner_id, '"+locale+"', 1) end) auth_practitioner_name, c.referred_yn, c.to_hcare_setting_type, c.to_ref_type, c.to_ref_code,   c.referral_priority,  TO_CHAR (c.preferred_treatment_date,'dd/mm/rrrr') preferred_treatment_date, c.to_specialty_code, c.to_service_code, c.to_locn_type,c.post_mortem_req_yn, c.to_locn_code, c.to_pract_id, c.to_pract_name,c.med_lgl_case_yn, c.informed_to,  TO_CHAR (c.informed_date_time,'dd/mm/rrrr hh24:mi') informed_date_time, c.informed_name, c.pol_rep_no, c.pol_stn_id, c.pol_id, c.discharge_narration,  c.to_locn_desc, c.referred_for_ip, a.patient_class, a.ip_leave_status, c.ref_notes,  TO_CHAR (c.absconded_date, 'dd/mm/rrrr hh24:mi') absconded_date,  c.absconded_yn, c.reported_to, a.team_id, am_get_desc.am_medical_team(a.facility_id, a.team_id, '"+locale+"', 2) team_short_desc,tO_CHAR (c.DECEASED_DATE_TIME,'dd/mm/rrrr hh24:mi') DECEASED_DATE_TIME, c.discharge_summary_yn, c.take_home_new_med_yn,");
	 /*Monday, September 13, 2010 , SRR20056-SCF-5155 [IN:023680]*/
	stringBuffer.append(" (select pseudo_bed_yn from ip_nursing_unit_bed where  facility_id = a.facility_id and  nursing_unit_code = a.nursing_unit_code and bed_no = a.bed_num) pseudo_bed_yn " );
	 //age,weight_on_admission & weight_on_admission_unit Added By Dharma on Oct 29th 2014 against HSA-CRF-0181 [IN:049541]
	 //bmi,height_on_admission Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527
	 stringBuffer.append(", c.discharge_type_code,c.discharge_status_code,a.weight_on_admission,a.weight_on_admission_unit,a.height_on_admission,a.bmi,get_age(b.DATE_OF_BIRTH) age,trunc (sysdate) - trunc (b.DATE_OF_BIRTH) no_of_days FROM IP_OPEN_ENCOUNTER a, MP_PATIENT b, IP_DISCHARGE_ADVICE c, IP_DISCHARGE_TYPE d  WHERE a.facility_id = '"+facilityId+"'    AND a.encounter_id = '"+encounterid+"'    AND a.patient_id = b.patient_id    AND a.facility_id = c.facility_id    AND a.encounter_id = c.encounter_id    AND c.dis_Adv_srl_no like '%%'AND c.dis_adv_status = '0' AND c.discharge_type_code = d.discharge_type_code");

	stmt = con.createStatement();	
	rset	 =	 stmt.executeQuery(stringBuffer.toString());

	
	if(rset != null && rset.next())
	{
		to_ref_code					= checkForNull(rset.getString("to_ref_code"));
		to_specialty_code			= checkForNull(rset.getString("to_specialty_code"));
		to_service_code				= checkForNull(rset.getString("to_service_code"));
		to_locn_type				= checkForNull(rset.getString("to_locn_type"));
		to_locn_code				= checkForNull(rset.getString("to_locn_code"));
		post_mortem_req_yn			= checkForNull(rset.getString("post_mortem_req_yn"));
		med_lgl_case_yn				= checkForNull(rset.getString("med_lgl_case_yn"));
		informed_to					= checkForNull(rset.getString("informed_to"));
		informed_date_time			= checkForNull(rset.getString("informed_date_time")); 
		informed_name				= checkForNull(rset.getString("informed_name"));
		pol_rep_no					= checkForNull(rset.getString("pol_rep_no"));
		pol_stn_id					= checkForNull(rset.getString("pol_stn_id"));
		pol_id						= checkForNull(rset.getString("pol_id"));
		discharge_narration			= checkForNull(rset.getString("discharge_narration"));
		admission_date_time			= checkForNull(rset.getString("admission_date_time"));//
		admission_short_desc		= checkForNull(rset.getString("admission_short_desc"));//
		specialty_short_desc		= checkForNull(rset.getString("specialty_short_desc"));//
		practitioner_name			= checkForNull(rset.getString("practitioner_name"));//
		patient_type_short_desc		= checkForNull(rset.getString("patient_type_short_desc"));
		nursing_unit_short_desc		= checkForNull(rset.getString("nursing_unit_short_desc"));//
		service_short_desc			= checkForNull(rset.getString("service_short_desc"));//
		bed_no						= checkForNull(rset.getString("bed_no"));//
		room_no						= checkForNull(rset.getString("room_no"));//
		bed_class_short_desc		= checkForNull(rset.getString("bed_class_short_desc"));//
		patient_id					= checkForNull(rset.getString("patient_id"));
		bed_type_code				= checkForNull(rset.getString("bed_type_code"));
		bed_class_code				= checkForNull(rset.getString("bed_class_code"));
		practitioner_id				= checkForNull(rset.getString("practitioner_id"));//
		bed_type_desc				= checkForNull(rset.getString("bed_type_short_desc"));//
		specialty_code				= checkForNull(rset.getString("specialty_code")); 
		auth_practitioner_id 		= checkForNull(rset.getString("cauth_practitioner_id"), practitioner_id);
		auth_practitioner_name		= checkForNull(rset.getString("auth_practitioner_name"), practitioner_name);
		nursing_unit_code			= checkForNull(rset.getString("nursing_unit_code"));
		daycare_unit_code           = checkForNull(rset.getString("dc_unit_code")); //Added for this CRF HSA-CRF-0306.1
		service_code				= checkForNull(rset.getString("service_code"));
		patient_type				= checkForNull(rset.getString("patient_type"));
		gender						= checkForNull(rset.getString("gender"));
		date_of_birth				= checkForNull(rset.getString("date_of_birth"));
		locn_type					= checkForNull(rset.getString("locn_type"));
		patient_class				= checkForNull(rset.getString("patient_class"));
		patient_status				= checkForNull(rset.getString("IP_LEAVE_STATUS"));
		absconded_date				= checkForNull(rset.getString("ABSCONDED_DATE"));
		absconded_yn				= checkForNull(rset.getString("ABSCONDED_YN"));
		reported_to					= checkForNull(rset.getString("REPORTED_TO"));
		EXPECTED_DISCHARGE_DATE		= checkForNull(rset.getString("expected_discharge_date"));
		medteamid	                = checkForNull(rset.getString("team_id"));
		medteamdesc                 = checkForNull(rset.getString("team_short_desc"));
		deceased_date_time			= checkForNull(rset.getString("DECEASED_DATE_TIME"));
		discharge_summary_yn		= checkForNull(rset.getString("discharge_summary_yn"));
		take_home_new_med_yn		= checkForNull(rset.getString("take_home_new_med_yn"));
		discharge_type_code         = checkForNull(rset.getString("discharge_type_code"));
		subservice_code				= checkForNull(rset.getString("subservice_code"));
		indicator					= checkForNull(rset.getString("indicator"));
	  //added on  3-07-2008 SCR 3228
		discharge_status_code       = checkForNull(rset.getString("discharge_status_code"));
		pseudo_bed_yn			    = checkForNull(rset.getString("pseudo_bed_yn"),"N");
		
		/*Added By Dharma on Oct 29th 2014 against HSA-CRF-0181 [IN:049541]  Start*/
		age  						= checkForNull(rset.getString("age"));
		weight_on_admission			= checkForNull(rset.getString("weight_on_admission"));
		weight_on_admission_unit	= checkForNull(rset.getString("weight_on_admission_unit"));
		no_of_days					= rset.getInt("no_of_days");

	
		/*Added By Dharma on Oct 29th 2014 against HSA-CRF-0181 [IN:049541]  End*/
		
		/*Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527*/
		height_on_admission			= checkForNull(rset.getString("height_on_admission"));
		bmi	= checkForNull(rset.getString("bmi"));
		/*Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527 END */
	}
		if(rset != null) rset.close(); 
		if(stmt != null) stmt.close();
		
		
		/*Added By Dharma on Oct 29th 2014 against HSA-CRF-0181 [IN:049541]  Start*/
		if(weight_on_admission.equals("") && weight_on_admission_unit.equals("")){
			/*String lastchar	="";
			int calculate_age	= 0;
			if (age.length() > 0 ){
				lastchar		= age.substring(age.length() - 1);
				if (!age.contains("Y"))
					calculate_age	= Integer.parseInt(age.substring(0, age.length()-1));
			}
			weight_on_admission_unit	= (lastchar.equals("D")?(calculate_age >30 ? "K":"G"):"K");*/
			weight_on_admission_unit	= (no_of_days >30 ? "K":"G");
		}else{
			is_value_already_captured	= "Y";
		}
		weight_on_admission_unit_display	= (weight_on_admission_unit.equals("G")?"Gram":"Kg");
		/*Added By Dharma on Oct 29th 2014 against HSA-CRF-0181 [IN:049541]  End*/
		
		/*Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527*/
		if(height_on_admission.equals("") || height_on_admission_unit.equals("")){
						height_on_admission_unit	= "Cm";
		}else{
			is_value_already_captured_height	= "Y";
		}
		
		/*Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527 END*/
		
		/*stmt = con.createStatement();		
		rset = stmt.executeQuery("select indicator, override_yn, deceased_yn, (IP_GET_DESC.ip_discharge_type('"+discharge_type_code+"','"+locale+"',2)) discharge_type_desc, (IP_GET_DESC.ip_discharge_status('"+discharge_status_code+"','"+locale+"',2)) discharge_status_desc,maternal_death_yn from ip_discharge_type_vw where  eff_status = 'E' and discharge_type_code='"+discharge_type_code+"' ");
		if(rset != null && rset.next()) {
			indicator					= checkForNull(rset.getString("indicator"));
			dead_yn					= checkForNull(rset.getString("deceased_yn"));
			maternal_death_yn					= checkForNull(rset.getString("maternal_death_yn"));
			discharge_type_desc					= checkForNull(rset.getString("discharge_type_desc"));
			override_yn					= checkForNull(rset.getString("override_yn"));
			discharge_status_desc					= checkForNull(rset.getString("discharge_status_desc"));
		}
		if(rset != null) rset.close(); 
		if(stmt != null) stmt.close();*/
	/*
	pageContext.setAttribute("discharge_narration",discharge_narration,pageContext.SESSION_SCOPE);
	pageContext.setAttribute("reported_to",reported_to,pageContext.SESSION_SCOPE);
	pageContext.setAttribute("informed_name",informed_name,pageContext.SESSION_SCOPE);
	pageContext.setAttribute("pol_rep_no",pol_rep_no,pageContext.SESSION_SCOPE);
	pageContext.setAttribute("pol_stn_id",pol_stn_id,pageContext.SESSION_SCOPE);
	pageContext.setAttribute("pol_id",pol_id,pageContext.SESSION_SCOPE);
	*/
	}catch(Exception e)
	{
		e.printStackTrace();
	}	

	
%>
		<iframe name="PatientLine_frame" id="PatientLine_frame" src="../../eCommon/jsp/pline.jsp?EncounterId=<%=encounterid%>&<%=request.getQueryString()%>" scrolling='no' noresize  style='height:8vh;width:98vw'></iframe>
		<!--Maheshwaran K added patient_Id for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013--><!--Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527-->
		
		<iframe name="Transfer_frame_display" id="Transfer_frame_display" src="addModifyDischargePatient.jsp?encounter_id=<%=java.net.URLEncoder.encode(encounterid,"UTF-8")%>&<%=request.getQueryString()%>&admission_date_time=<%=java.net.URLEncoder.encode(admission_date_time,"UTF-8")%>&admission_short_desc=<%=java.net.URLEncoder.encode(admission_short_desc,"UTF-8")%>&specialty_short_desc=<%=java.net.URLEncoder.encode(specialty_short_desc,"UTF-8")%>&patient_class=<%=java.net.URLEncoder.encode(patient_class)%>&practitioner_name=<%=java.net.URLEncoder.encode(practitioner_name,"UTF-8")%>&nursing_unit_short_desc=<%=java.net.URLEncoder.encode(nursing_unit_short_desc,"UTF-8")%>&service_short_desc=<%=java.net.URLEncoder.encode(service_short_desc,"UTF-8")%>&bed_no=<%=java.net.URLEncoder.encode(bed_no,"UTF-8")%>&room_no=<%=java.net.URLEncoder.encode(room_no,"UTF-8")%>&bed_class_short_desc=<%=java.net.URLEncoder.encode(bed_class_short_desc,"UTF-8")%>&practitioner_id=<%=java.net.URLEncoder.encode(practitioner_id,"UTF-8")%>&bed_type_desc=<%=java.net.URLEncoder.encode(bed_type_desc,"UTF-8")%>&medteamid=<%=java.net.URLEncoder.encode(medteamid,"UTF-8")%>&medteamdesc=<%=java.net.URLEncoder.encode(medteamdesc,"UTF-8")%>&weight_on_admission=<%=weight_on_admission%>&weight_on_admission_unit=<%=weight_on_admission_unit%>&weight_on_admission_unit_display=<%=weight_on_admission_unit_display%>&is_validate_weight_on_admission=<%=is_validate_weight_on_admission%>&is_value_already_captured=<%=is_value_already_captured%>&height_on_admission=<%=height_on_admission%>&height_on_admission_unit=<%=height_on_admission_unit%>&bmi=<%=bmi%>&is_validate_height_on_admission=<%=is_validate_height_on_admission%>&is_value_already_captured_height=<%=is_value_already_captured_height%>&enable_height_bmi_pat_cls=<%=enable_height_bmi_pat_cls%>" scrolling='auto' noresize tabindex='-1' style='height:18.5vh;width:98vw'></iframe>

		<!--  discharge_status_code added in queryString on 3-07-2008 SCR 3228 -->
		<iframe name="Transfer_frame" id="Transfer_frame" src="addModifyDischargePatientTabs.jsp?<%=request.getQueryString()%>&encounter_id=<%=encounterid%>&to_ref_code=<%=to_ref_code%>&to_specialty_code=<%=to_specialty_code%>&to_service_code=<%=to_service_code%>&to_locn_type=<%=to_locn_type%>&post_mortem_req_yn=<%=post_mortem_req_yn%>&to_locn_code=<%=to_locn_code%>&med_lgl_case_yn=<%=med_lgl_case_yn%>&informed_to=<%=informed_to%>&informed_date_time=<%=java.net.URLEncoder.encode(informed_date_time,"UTF-8")%>&admission_date_time=<%=java.net.URLEncoder.encode(admission_date_time,"UTF-8")%>&practitioner_name=<%=java.net.URLEncoder.encode(practitioner_name,"UTF-8")%>&patient_type_short_desc=<%=java.net.URLEncoder.encode(patient_type_short_desc,"UTF-8")%>&bed_no=<%=bed_no%>&room_no=<%=room_no%>&patient_id=<%=patient_id%>&bed_type_code=<%=bed_type_code%>&bed_class_code=<%=bed_class_code%>&practitioner_id=<%=practitioner_id%>&specialty_code=<%=specialty_code%>&auth_practitioner_id=<%=auth_practitioner_id%>&nursing_unit_code=<%=nursing_unit_code%>&service_code=<%=service_code%>&patient_type=<%=patient_type%>&gender=<%=gender%>&date_of_birth=<%=date_of_birth%>&locn_type=<%=locn_type%>&patient_class=<%=patient_class%>&patient_status=<%=patient_status%>&absconded_date=<%=absconded_date%>&absconded_yn=<%=absconded_yn%>&EXPECTED_DISCHARGE_DATE=<%=java.net.URLEncoder.encode(EXPECTED_DISCHARGE_DATE,"UTF-8")%>&medteamid=<%=medteamid%>&deceased_date_time=<%=java.net.URLEncoder.encode(deceased_date_time,"UTF-8")%>&discharge_summary_yn=<%=discharge_summary_yn%>&take_home_new_med_yn=<%=take_home_new_med_yn%>&discharge_type_code=<%=discharge_type_code%>&subservice_code=<%=subservice_code%>&discharge_status_code=<%=discharge_status_code%>&indicator=<%=indicator%>&pseudo_bed_yn=<%=pseudo_bed_yn%>&allow_late_discharge_reason=<%=allow_late_discharge_reason%>&disch_reason_mand_yn=<%=disch_reason_mand_yn%>&daycare_unit_code=<%=daycare_unit_code%>&bmi=<%=bmi%>" scrolling='no' noresize  style='height:64vh;width:98vw'></iframe>
		
		
		<iframe name="Transfer_frame_buttons" id="Transfer_frame_buttons" src="addModifyDischargePatientButtons.jsp?encounter_id=<%=java.net.URLEncoder.encode(encounterid)%>&<%=request.getQueryString()%>" scrolling='auto' noresize style='height:4vh;width:98vw'></iframe>

		<iframe src="../../eCommon/jsp/error.jsp" name="Dummy_frame" id="Dummy_frame" scrolling='yes' noresize style='height:0vh;width:98vw'></iframe>
		<iframe src="../../eCommon/jsp/error.jsp" name="submit_frame" id="submit_frame" scrolling='yes' noresize style='height:0vh;width:98vw'></iframe>
		


</html>
<%	}catch(Exception e)
	{
		out.print("Exception PaintDischargePatient :"+e);
		e.printStackTrace();
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

