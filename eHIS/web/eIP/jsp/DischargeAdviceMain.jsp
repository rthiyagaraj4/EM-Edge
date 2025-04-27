<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,eCommon.XSSRequestWrapper" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'</link>
	<script language='javascript' src='../js/CancelAdmission.js'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue 
	String locale			= (String)session.getAttribute("LOCALE");
	
	Connection con			=	null;
	Statement stmt			=	null;
	ResultSet rs			=	null;
	StringBuffer SqlSB = new StringBuffer();
	String facilityID		= (String)session.getValue("facility_id");
	String encounterid		= checkForNull(request.getParameter("encounterId"));
	String patient_Id		= checkForNull(request.getParameter("patientId"));
	String leave_exp_dt_flag= checkForNull(request.getParameter("leave_exp_dt_flag"));
	String function_id= checkForNull(request.getParameter("function_id"));
	String setup_bl_dtls_in_ip_yn			= checkForNull(request.getParameter("setup_bl_dtls_in_ip_yn"));
	String bl_interfaced_yn						= checkForNull(request.getParameter("bl_interfaced_yn"));
	String allow_discharge_date_predc	= checkForNull(request.getParameter("allow_discharge_date_predc"));
	String max_disch_period_for_predc	= checkForNull(request.getParameter("max_disch_period_for_predc"));
	String mother_cut_off_age_pda		= checkForNull(request.getParameter("mother_cut_off_age_pda"));
	String mother_max_age_pda				= checkForNull(request.getParameter("mother_max_age_pda"));
	String pat_dtls_unknown_yn_pda		= checkForNull(request.getParameter("pat_dtls_unknown_yn_pda"));
	String contact1_name_pda				= checkForNull(request.getParameter("contact1_name_pda"));
	String contact2_name_pda				= checkForNull(request.getParameter("contact2_name_pda"));
	String admissiondatetime	= "";
	String admissiontypedesc	= "";
	String specialtyshortdesc	= "";
	String practitionername		= "";
	String nursingunitshortdesc = "";
	String serviceshortdesc		= "";
	String bedno				= "";
	String roomno				= "";
	String bedclassshortdesc	= "";
	String bed_type_desc		= "";
	String practitioner_id		= "";
	int patient_age				= 0;
	String spltycode			= "";
	String patienttype 			= "";
	String nursingunitcode 		= "";
	String gender				= "";
	String DOB					= "";
	String expdischargedatetime = "";
	String patient_class		= "";
	String patient_status		= "";
	String pol_rep_no_vw		= "";
	String pol_stn_id_vw		= ""; 
	String pol_id_vw			= "";
	String mlc_yn				= "";
	String modified_date_val	= "" ;

	/*Added By Dharma on Oct 29th 2014 against HSA-CRF-0181 [IN:049541]  Start*/
	String age								= "";
	String weight_on_admission				= "";
	String weight_on_admission_unit			= "";
	String weight_on_admission_unit_display	= "";
	String weight_on_admn_mandatory			= checkForNull(request.getParameter("weight_on_admn_mandatory"));
	String is_value_already_captured		= "";
	int no_of_days							= 0;
	/*Added By Dharma on Oct 29th 2014 against HSA-CRF-0181 [IN:049541]  End*/
	
	/*Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527*/
	String height_on_admission				= "";
	String height_on_admission_unit			= "";
	String height_on_admn_mandatory         = "";
	String enable_height_bmi_pat_cls        = "";
	String bmi="";
	String is_value_already_captured_height="";
	/*Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527  END*/

	try
	{
		con = ConnectionManager.getConnection(request);
		stmt=con.createStatement();

		SqlSB.append(" SELECT TO_CHAR(a.admission_date_time,'dd/mm/rrrr HH24:mi') admission_date_time,");
		SqlSB.append(" b.sex gender, ");
		SqlSB.append(" TO_CHAR (a.exp_discharge_date_time,'dd/mm/rrrr HH24:mi') exp_discharge_date_time,");
		SqlSB.append(" IP_GET_DESC.IP_ADMISSION_TYPE(a.admission_type,'"+locale+"','2') admission_short_desc, a.specialty_code, ");
		SqlSB.append(" AM_GET_DESC.AM_SPECIALITY(a.specialty_code,'"+locale+"','2') specialty_short_desc, ");
		SqlSB.append(" a.attend_practitioner_id practitioner_id, AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,'"+locale+"','1') practitioner_name, null patient_type_short_desc,");
		SqlSB.append(" a.nursing_unit_code, IP_GET_DESC.IP_NURSING_UNIT(a.FACILITY_ID, a.NURSING_UNIT_CODE,'"+locale+"','2') nursing_unit_short_desc, ");
		SqlSB.append(" AM_GET_DESC.AM_SERVICE(a.service_code,'"+locale+"','2') service_short_desc, a.bed_num bed_no, a.room_num room_no, a.patient_class, a.oth_adt_status, ");
		SqlSB.append(" to_char(b.date_of_birth,'dd/mm/rrrr') date_of_birth,");
		SqlSB.append(" calculate_age(TO_CHAR(b.date_of_birth,'dd/mm/rrrr'),1) patient_age,");
		SqlSB.append(" IP_GET_DESC.IP_BED_TYPE(a.bed_type_code,'"+locale+"','2') bed_type_short_desc, IP_GET_DESC.IP_BED_CLASS(a.bed_class_code,'"+locale+"','2') bed_class_short_desc, ");
		SqlSB.append(" a.pol_rep_no, a.pol_stn_id, a.pol_id, a.mlc_yn ");
		SqlSB.append(" , to_char(a.modified_date,'dd/mm/rrrr hh24:mi') modified_date  ");
		SqlSB.append(" ,a.height_on_admission,a.bmi ");//Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527
		SqlSB.append(" , get_age(b.DATE_OF_BIRTH) age,a.weight_on_admission,a.weight_on_admission_unit,trunc (sysdate) - trunc (b.DATE_OF_BIRTH) no_of_days  ");//Added By Dharma on Oct 29th 2014 against HSA-CRF-0181 [IN:049541] 
		
		SqlSB.append(" FROM ");
		SqlSB.append(" IP_OPEN_ENCOUNTER a, mp_patient b ");
		SqlSB.append(" WHERE ");
		SqlSB.append(" a.facility_id = '"+facilityID+"' ");
		SqlSB.append(" AND a.encounter_id ='"+encounterid+"' ");
		SqlSB.append(" AND a.patient_id = b.patient_id ");

		rs=stmt.executeQuery(SqlSB.toString());
		if(rs.next())
		{
			admissiondatetime 	= checkForNull(rs.getString("admission_date_time"));
			admissiontypedesc 	= checkForNull(rs.getString("admission_short_desc"));
			specialtyshortdesc 	= checkForNull(rs.getString("specialty_short_desc"));
			practitionername 	= checkForNull(rs.getString("practitioner_name"));
			nursingunitshortdesc= checkForNull(rs.getString("Nursing_unit_short_desc"));
			serviceshortdesc 	= checkForNull(rs.getString("service_short_desc"));
			bedno 				= checkForNull(rs.getString("bed_no"));
			roomno 				= checkForNull(rs.getString("room_no"));
			bedclassshortdesc 	= checkForNull(rs.getString("bed_class_short_desc"));
			bed_type_desc		= checkForNull(rs.getString("bed_type_short_desc"));
				session.putValue("practitioner_name",practitionername);
			practitioner_id		= checkForNull(rs.getString("practitioner_id"));
			patient_age			= Integer.parseInt(rs.getString("patient_age"))	;
			spltycode			= checkForNull(rs.getString("specialty_code"));
			patienttype 		= checkForNull(rs.getString("patient_type_short_desc"));
			nursingunitcode 	= checkForNull(rs.getString("nursing_unit_code"));
			gender				= checkForNull(rs.getString("gender"));
			DOB					= checkForNull(rs.getString("date_of_birth"));
			expdischargedatetime= checkForNull(rs.getString("exp_discharge_date_time"));
			patient_class		= checkForNull(rs.getString("patient_class"));
			patient_status		= checkForNull(rs.getString("OTH_ADT_STATUS"));
			mlc_yn				= checkForNull(rs.getString("MLC_YN"),"N");
			pol_rep_no_vw		= checkForNull(rs.getString("POL_REP_NO"));
			pol_stn_id_vw		= checkForNull(rs.getString("POL_STN_ID"));
			pol_id_vw			= checkForNull(rs.getString("POL_ID"));
			modified_date_val   = checkForNull(rs.getString("modified_date"));
			
			/*Added By Dharma on Oct 29th 2014 against HSA-CRF-0181 [IN:049541]  Start*/
			age  				= checkForNull(rs.getString("age"));
			weight_on_admission			= checkForNull(rs.getString("weight_on_admission"));
			weight_on_admission_unit	= checkForNull(rs.getString("weight_on_admission_unit"));
			no_of_days					= rs.getInt("no_of_days");
			/*Added By Dharma on Oct 29th 2014 against HSA-CRF-0181 [IN:049541]  End*/

			/*Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527*/
			height_on_admission			= checkForNull(rs.getString("height_on_admission"));
			bmi			= checkForNull(rs.getString("bmi"));
			/*Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527 END*/
		}
		if (rs != null)		rs.close();
		if (stmt != null)	stmt.close();
		/*Added By Dharma on Oct 29th 2014 against HSA-CRF-0181 [IN:049541]  Start*/

		if(weight_on_admn_mandatory.equals("")){//If discharge advise called from CA.
			stmt=con.createStatement();
			rs=stmt.executeQuery("select WEIGHT_ON_ADMN_MANDATORY from ip_param where facility_id = '"+facilityID+"'");
			if(rs.next()){
				weight_on_admn_mandatory	= checkForNull(rs.getString("weight_on_admn_mandatory"));
			}
			
		}
		if (rs != null)		rs.close();
		if (stmt != null)	stmt.close();
		
		String is_validate_weight_on_admission	= (weight_on_admn_mandatory.equals("P")?"Y":"N");
		
		
		
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

		/*Added by KAMATCHI S on 23-JUN-2020 fro ML-MMOH-CRF-1527  Start*/
		if(height_on_admn_mandatory.equals("")||enable_height_bmi_pat_cls.equals("")){//If discharge advise called from CA.
			stmt=con.createStatement();
			rs=stmt.executeQuery("select HEIGHT_ON_ADMN_MANDATORY,ENABLE_HEIGHT_BMI_PAT_CLS from ip_param where facility_id = '"+facilityID+"'");
			if(rs.next()){
				 height_on_admn_mandatory	= checkForNull(rs.getString("height_on_admn_mandatory"));
				 enable_height_bmi_pat_cls	= checkForNull(rs.getString("enable_height_bmi_pat_cls"));
			}
		}
		if (rs != null)		rs.close();
		if (stmt != null)	stmt.close();
		String is_validate_height_on_admission = (height_on_admn_mandatory.equals("P")?"Y":"N");
		if(height_on_admission.equals("") && height_on_admission_unit.equals("")){
			height_on_admission_unit	= ("Cm");
		}
		else{
			is_value_already_captured_height	= "Y";
		}
		/*Added by KAMATCHI S on 23-JUN-2020 fro ML-MMOH-CRF-1527  End*/

%>

<title><fmt:message key="eIP.PrepareDischargeAdvice.label" bundle="${ip_labels}"/></title>


<iframe name='PLINE' id='PLINE' SRC='../../eCommon/jsp/pline.jsp?EncounterId=<%=java.net.URLEncoder.encode(encounterid)%>&Facility_Id=<%=facilityID%>' noresize  frameborder=no scrolling='no' style='height:8vh;width:100vw'></iframe><iframe name='f_query_add_mod_display' id='f_query_add_mod_display' 	 src='addmodifyDischargeAdvice.jsp?jsp_name=&win_height=1&win_width=33&EncounterId=<%=java.net.URLEncoder.encode(encounterid)%>&patient_class=<%=java.net.URLEncoder.encode(patient_class)%>&patient_Id=<%=java.net.URLEncoder.encode(patient_Id)%>&admissiondatetime=<%=java.net.URLEncoder.encode(admissiondatetime)%>&admissiontypedesc=<%=java.net.URLEncoder.encode(admissiontypedesc,"UTF-8")%>&specialtyshortdesc=<%=java.net.URLEncoder.encode(specialtyshortdesc,"UTF-8")%>&practitionername=<%=java.net.URLEncoder.encode(practitionername,"UTF-8")%>&nursingunitshortdesc=<%=java.net.URLEncoder.encode(nursingunitshortdesc,"UTF-8")%>&serviceshortdesc=<%=java.net.URLEncoder.encode(serviceshortdesc,"UTF-8")%>&bedno=<%=java.net.URLEncoder.encode(bedno,"UTF-8")%>&roomno=<%=java.net.URLEncoder.encode(roomno,"UTF-8")%>&bedclassshortdesc=<%=java.net.URLEncoder.encode(bedclassshortdesc,"UTF-8")%>&bed_type_desc=<%=java.net.URLEncoder.encode(bed_type_desc,"UTF-8")%>&weight_on_admission=<%=weight_on_admission%>&weight_on_admission_unit=<%=weight_on_admission_unit%>&weight_on_admission_unit_display=<%=weight_on_admission_unit_display%>&is_validate_weight_on_admission=<%=is_validate_weight_on_admission%>&is_value_already_captured=<%=is_value_already_captured%>&height_on_admission=<%=height_on_admission%>&height_on_admission_unit=<%=height_on_admission_unit%>&is_validate_height_on_admission=<%=is_validate_height_on_admission%>&bmi=<%=bmi%>&enable_height_bmi_pat_cls=<%=enable_height_bmi_pat_cls%>&is_value_already_captured_height=<%=is_value_already_captured_height%>' frameborder=0 scrolling='no' noresize style='height:33vh;width:100vw'></iframe> 
	<!--Maheshwaran K added patient_Id for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013--><!-- Added by KAMATCHI S for ML-MMOH-CRF-1527 ON 23-JUN-2020-->
	<iframe name='f_query_add_mod' id='f_query_add_mod' 	 src='AddModifyDischargeAdvTabs.jsp?jsp_name=&win_height=1&win_width=40&EncounterId=<%=java.net.URLEncoder.encode(encounterid)%>&patient_Id=<%=java.net.URLEncoder.encode(patient_Id)%>&leave_exp_dt_flag=<%=leave_exp_dt_flag%>&admissiondatetime=<%=java.net.URLEncoder.encode(admissiondatetime)%>&admissiontypedesc=<%=java.net.URLEncoder.encode(admissiontypedesc,"UTF-8")%>&specialtyshortdesc=<%=java.net.URLEncoder.encode(specialtyshortdesc,"UTF-8")%>&practitionername=<%=java.net.URLEncoder.encode(practitionername,"UTF-8")%>&nursingunitshortdesc=<%=java.net.URLEncoder.encode(nursingunitshortdesc,"UTF-8")%>&serviceshortdesc=<%=java.net.URLEncoder.encode(serviceshortdesc,"UTF-8")%>&bedno=<%=java.net.URLEncoder.encode(bedno,"UTF-8")%>&roomno=<%=java.net.URLEncoder.encode(roomno,"UTF-8")%>&bedclassshortdesc=<%=java.net.URLEncoder.encode(bedclassshortdesc,"UTF-8")%>&bed_type_desc=<%=java.net.URLEncoder.encode(bed_type_desc,"UTF-8")%>&practitioner_id=<%=java.net.URLEncoder.encode(practitioner_id)%>&spltycode=<%=java.net.URLEncoder.encode(spltycode)%>&patienttype=<%=java.net.URLEncoder.encode(patienttype)%>&nursingunitcode=<%=java.net.URLEncoder.encode(nursingunitcode)%>&gender=<%=java.net.URLEncoder.encode(gender)%>&DOB=<%=java.net.URLEncoder.encode(DOB)%>&expdischargedatetime=<%=java.net.URLEncoder.encode(expdischargedatetime)%>&patient_class=<%=java.net.URLEncoder.encode(patient_class)%>&patient_status=<%=java.net.URLEncoder.encode(patient_status)%>&patient_age=<%=patient_age%>&&mlc_yn=<%=java.net.URLEncoder.encode(mlc_yn)%>&pol_rep_no_vw=<%=java.net.URLEncoder.encode(pol_rep_no_vw)%>&pol_stn_id_vw=<%=java.net.URLEncoder.encode(pol_stn_id_vw)%>&pol_id_vw=<%=java.net.URLEncoder.encode(pol_id_vw)%>&function_id=<%=function_id%>&modified_date_val=<%=java.net.URLEncoder.encode(modified_date_val)%>&setup_bl_dtls_in_ip_yn=<%=setup_bl_dtls_in_ip_yn%>&bl_interfaced_yn=<%=bl_interfaced_yn%>&allow_discharge_date_predc=<%=allow_discharge_date_predc%>&max_disch_period_for_predc=<%=max_disch_period_for_predc%>&mother_cut_off_age_pda=<%=mother_cut_off_age_pda%>&mother_max_age_pda=<%=mother_max_age_pda%>&pat_dtls_unknown_yn_pda=<%=pat_dtls_unknown_yn_pda%>&contact1_name_pda=<%=contact1_name_pda%>&contact2_name_pda=<%=contact2_name_pda%>&bmi=<%=bmi%>' frameborder=0 scrolling='no' noresize style='height:54vh;width:100vw'></iframe> 

	<iframe name='f_query_add_mod_button' id='f_query_add_mod_button' 	    src='AddModifyDischargeAdvButtons.jsp?jsp_name=&win_height=1&win_width=40&patient_Id=<%=java.net.URLEncoder.encode(patient_Id)%>&nursingunitcode=<%=java.net.URLEncoder.encode(nursingunitcode)%>' frameborder=0 scrolling='no' noresize style='height:5vh;width:100vw'></iframe>
	
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:0vh;width:100vw'></iframe>
	<iframe name='messageFrame1' id='messageFrame1' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:0vh;width:100vw'></iframe>
	
</html>

<%
	}catch(Exception e) 
	{
		out.println(e.toString());
		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>

<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
	}
%>

