<!DOCTYPE html>
<!-- Function for cancelling the Discharge Advice -- 21 July 2001 --->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import= "java.util.*,java.sql.*,java.text.*,com.ehis.util.*,webbeans.eCommon.*,org.json.simple.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>

<HTML>
<%
	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue
	String locale			= (String)session.getAttribute("LOCALE");
	String bl_operational	= (String)session.getValue("bl_operational");
	String bl_interfaced_yn	= "";
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet prs = null;

	/*Added by Ashwini on 07-Mar-2018 for GHL-CRF-0505*/
	boolean isAadharCardAndRelAppl = false;
	String citizen_yn = "";
	JSONObject AadharCardAndRelJson	= new JSONObject();
	String alt_id4_type_desc = "";
	String alt_id4_type = "";
	JSONObject AltIdLengthAndTypeJson = new JSONObject();
	/*End GHL-CRF-0505*/

	String ReasonValues = "<option value=''>---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---</option>";

	con = ConnectionManager.getConnection(request);

	pstmt = con.prepareStatement(" select Contact_Reason, Contact_Reason_Code from AM_CONTACT_REASON_LANG_VW where LANGUAGE_ID = '"+locale+"' and Cancel_Discharge_Advice_Yn = 'Y' and Eff_Status = 'E' order by 1");
	prs = pstmt.executeQuery();
	if(prs!=null)
	{
		while(prs.next())
		{
			String contact_code = prs.getString("Contact_Reason_Code");
			String contact_desc = prs.getString("Contact_Reason");
			ReasonValues = ReasonValues+"<option value='"+contact_code+"'>"+contact_desc+"</option>"; 
		}
	}
	if(prs!=null) prs.close();
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<head>
<TITLE> <fmt:message key="Common.DischargeAdvice.label" bundle="${common_labels}"/> </TITLE>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
	<script src="../../eCommon/js/dchk.js" language="JavaScript"></Script>
	  
	<script src="../js/CancelDischargeAdv.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>

<script>
function CancelDisc(obj)
{
	var canval = obj.value;
	if( canval == getLabel("Common.CancelDischargeAdvice.label","Common") )
	{
		document.getElementById("u").style.visibility = 'visible';
		document.canceldischarge_form.cancel_discharge.value=getLabel("eIP.ConfirmCancellation.label","IP");
		document.canceldischarge_form.close.value=getLabel("eIP.AbortCancellation.label","IP");
		document.getElementById("u").innerHTML=""+getLabel("Common.ReasonforCancellation.label","Common");
		document.getElementById("v").innerHTML=""+"<select name='cancel_remarks' id='cancel_remarks'><%=ReasonValues%></select><img src='../../eCommon/images/mandatory.gif'align='center'></img>";
		document.canceldischarge_form.cancel_remarks.focus();
	}

	if(canval == getLabel("eIP.ConfirmCancellation.label","IP"))
	{
		if ((document.canceldischarge_form.cancel_remarks.value == "null") || (document.canceldischarge_form.cancel_remarks.value == ""))
		{
			var err = getMessage("CAN_NOT_BE_BLANK","Common");
			err = err.replace('$',getLabel("Common.ReasonforCancellation.label","Common"));
			alert(err);
		}
		else
		{
			document.forms[0].submit();
		}
	}
}
</script>

<%
	Statement stmt=null;
	ResultSet rs =null;
	Statement stmt1		= null;
	String setup_bl_dtls_in_ip_yn = "N";
	StringBuffer SqlSB = new StringBuffer();
	try
	{
	
	stmt = con.createStatement();
	String facilityID =(String)session.getValue("facility_id");
	String encounterID=request.getParameter("EncounterId");
	String fromfunction = request.getParameter("from_function")==null?"":request.getParameter("from_function");
	String function_id = request.getParameter("function_id")==null?"":request.getParameter("function_id");

	/*Added by Ashwini on 07-Mar-2018 for GHL-CRF-0505*/
	isAadharCardAndRelAppl	=	eCommon.Common.CommonBean.isSiteSpecific(con, "IP","AADHAR_CARD_RELATIONSHIP"); 
	Boolean isHeightAndBmiEnable = eCommon.Common.CommonBean.isSiteSpecific(con, "MP", "BMI_REG_PAT_CHNGES_RH101");//Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527
	AltIdLengthAndTypeJson	=	eIP.IPCommonBean.getAltIdLengthAndType(con);
	alt_id4_type_desc		=	(String)AltIdLengthAndTypeJson.get("alt_id4_type_desc");
	alt_id4_type			=	(String)AltIdLengthAndTypeJson.get("alt_id4_type");
	
	String aadhar_card_no		= "";
	String relationship_code	= "";
	String discharge_indicator	= "";
	/*End GHL-CRF-0505*/

	/* Added by Ajay Hatwate for AAKH-CRF-0179 on 22/08/2023 */
	Boolean isDeathRegisterFormAppl = false;
	String enable_death_reg_form = "N";
	String death_reg_form_accession_num = "";
	/* End of AAKH-CRF-0179 */
	/* Added by Ajay Hatwate for AAKH-CRF-0179 on 22-08-2023 */
	isDeathRegisterFormAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "DEATH_REGISTER_FORM_APPL"); //Added by Ajay Hatwate for AAKH-CRF-0179 on 22-08-2023
	if(isDeathRegisterFormAppl){
		enable_death_reg_form = eMP.MPCommonBean.getEnableDeathRegisterFormYN(con);
		if(enable_death_reg_form.equals("Y")){
			pstmt = con.prepareStatement(" SELECT death_reg_form_accession_num FROM PR_ENCOUNTER WHERE FACILITY_ID=? and ENCOUNTER_ID = ? ");
			pstmt.setString(1,facilityID);
			pstmt.setString(2,encounterID);
			prs = pstmt.executeQuery();
			if(prs!=null)
			{
				while(prs.next())
				{
					death_reg_form_accession_num = checkForNull(prs.getString("death_reg_form_accession_num"));
				}
			}
			if(pstmt!=null) pstmt.close();	
			if(prs!=null) prs.close();		
		}
	}
	/* End of AAKH-CRF-0179 */
/* Merged with ip_open_encounter query for PE - 11/05/2010
	SqlSB.append(" select setup_bl_dtls_in_ip_yn,bl_interfaced_yn from IP_PARAM where facility_id='"+facilityID+"' ");
	rs = stmt.executeQuery(SqlSB.toString());
	if(rs!=null )
	{
		while(rs.next())
		{
			setup_bl_dtls_in_ip_yn=rs.getString("setup_bl_dtls_in_ip_yn");
			bl_interfaced_yn	  =rs.getString("bl_interfaced_yn");
		}
	}
	if(rs!=null) rs.close();
	
	if (SqlSB.length() > 0)
		SqlSB.delete(0, SqlSB.length());
*/

 	String ph_charges_yn  = "";
	String admissiondatetime = "";
	String adm_date_display = "";
	String admissiontypedesc = "";
	String auth_pract_name = "";
	String bedclassshortdesc="";
	String bedno = "";
	String bedtypeshortdesc="";
	String diet_charges_yn  = "";
	String dis_adv_srl_no = "";
	String discharge_summary_yn = "";
	String ecg_charges_yn   = "";
	String expected_discharge_date = "";
	String gender = "";
	String lab_charges_yn  = "";
	String meddesc 		= "";
	String mri_charges_yn   = "";
	String nursingunitshortdesc = "";
	String patient_id="";
	String patienttype = "";
	String physio_charges_yn= "";
	String practitionerid= "";
	String practitionername = "";
	String ref_to_coroner_yn  =  "";
	String roomno = "";
	String rt_charges_yn  = "";
	String scan_charges_yn = "";
	String serviceshortdesc = "";
	String short_desc = "";
	String specialtyshortdesc = "";
	String take_home_new_med_yn  = "";
	String take_home_stk_med_yn  ="";
	String ultrasound_charges_yn = "";
	String xray_charges_yn  = "";
	String patient_class  = "";
	//Modified for INC:47208
	String nursingunitcode = "";

	/*dded by Rameswar on 22nd May 2015 Against HSA-CRF-0181.1 [IN054123] Start*/
	String WEIGHT_ON_ADMISSION="";
	String WEIGHT_ON_ADMISSION_UNIT="";
	String weight_on_admission_unit_display="";
	/*Added by Rameswar on 22nd May 2015 Against HSA-CRF-0181.1 [IN054123] End*/
	
	/*Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527*/
	String height_on_admission				= "";
	String height_on_admission_unit			= "";
	String bmi="";
	String enable_height_bmi_pat_cls="";
	/*Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527 END */

	SqlSB.append(" SELECT a.Room_num Room_No,");
	SqlSB.append(" ip_Get_desc.Ip_bed_class(a.Bed_Class_Code,?,2) Bed_Class_Short_desc,");
	SqlSB.append(" am_get_desc.AM_PRACTITIONER(a.Attend_Practitioner_Id,?,'1') practitioner_name,");
	SqlSB.append(" ip_Get_desc.Ip_bed_type(a.Bed_Type_Code,?,2) Bed_Type_Short_desc,");
	SqlSB.append(" ip_get_desc.IP_ADMISSION_TYPE(a.admission_type,?,'2') admission_short_desc, ");
	SqlSB.append(" To_char(a.Admission_Date_Time,'dd/mm/rrrr hh24:mi') admission_date_time,");
	SqlSB.append(" b.Sex Gender,");
	SqlSB.append(" Am_Get_desc.Am_speciality(a.Specialty_Code,?,2) Specialty_Short_desc,");
	SqlSB.append(" a.nurSing_Unit_Code nurSing_Unit_Code,");
	SqlSB.append(" Am_Get_desc.Am_practitioner(a.Attend_Practitioner_Id,?,1) Practitioner_Short_Name,");
	SqlSB.append(" a.Encounter_Id,");
	SqlSB.append(" a.Patient_Id,");
	SqlSB.append(" To_char(b.Date_Of_Birth,'dd/mm/rrrr hh24:mi') Date_Of_Birth,");
	SqlSB.append(" decode(?,'en', b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) Patient_Name,");
	SqlSB.append(" ip_Get_desc.Ip_nursing_unit(a.Facility_Id, a.nurSing_Unit_Code,?,2) nurSing_Unit_Short_desc,");
	SqlSB.append(" a.Bed_num Bed_No,");
	SqlSB.append(" a.Blocked_Bed_No,");
	SqlSB.append(" a.Attend_Practitioner_Id Practitioner_Id,");
	SqlSB.append(" NULL dly_Charge,");
	SqlSB.append(" NULL Patient_Type_Short_desc,");
	SqlSB.append(" AM_GET_DESC.AM_SERVICE(service_code,?,'2') service_short_desc,");
	SqlSB.append(" DECODE(Pat_Curr_Locn_Type,'N', ip_Get_desc.Ip_nursing_unit(a.Facility_Id, a.Pat_Curr_Locn_Code,?,2),");
	SqlSB.append("                           'R', a.Pat_Curr_Locn_Code,");
	SqlSB.append(" op_Get_desc.Op_clinic(a.Facility_Id, a.Pat_Curr_Locn_Code,?,1)) Location_desc,");
	SqlSB.append(" a.patient_class patient_class, AM_GET_DESC.AM_MEDICAL_TEAM(a.facility_id, a.team_id, ?,'2') team_short_desc,");
	SqlSB.append(" c.setup_bl_dtls_in_ip_yn, c.bl_interfaced_yn,");
	SqlSB.append(" to_char(d.expected_discharge_date,'dd/mm/rrrr hh24:mi') expected_discharge_date,");
	SqlSB.append(" d.dis_adv_srl_no, ip_get_desc.IP_DISCHARGE_TYPE(d.discharge_type_code, ?, '2') short_desc, d.ref_to_coroner_yn,");
	SqlSB.append(" d.discharge_summary_yn, d.take_home_new_med_yn,");
	SqlSB.append(" d.take_home_stk_med_yn, ");
	SqlSB.append(" am_get_desc.AM_PRACTITIONER(d.auth_practitioner_id,?, '1') auth_pract_name,");
	SqlSB.append(" d.lab_charges_yn, d.xray_charges_yn, d.scan_charges_yn, d.ultrasound_charges_yn, d.mri_charges_yn, d.rt_charges_yn, d.physio_charges_yn,"); SqlSB.append("d.ecg_charges_yn, d.diet_charges_yn, d.ph_charges_yn, ");
	SqlSB.append(" a.WEIGHT_ON_ADMISSION,a.WEIGHT_ON_ADMISSION_UNIT, ");//Added by Rameswar on 22nd May 2015 Against HSA-CRF-0181.1 [IN054123]
	SqlSB.append(" a.HEIGHT_ON_ADMISSION,a.BMI, ");//Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527		
	SqlSB.append(" b.alt_id4_no,d.relationship_code, e.indicator "); //Added by Ashwini on 07-Mar-2018 for GHL-CRF-0505
	SqlSB.append(" FROM   IP_OPEN_ENCOUNTER a,");
	SqlSB.append("        MP_PATIENT b, ip_param c, IP_DISCHARGE_ADVICE d, IP_DISCHARGE_TYPE e "); //Added by Ashwini on 07-Mar-2018 for GHL-CRF-0505
	SqlSB.append(" WHERE  a.facility_id = ?");
	SqlSB.append("        AND a.encounter_id = ?");
	SqlSB.append("        AND a.patient_id = b.patient_id");
	SqlSB.append("        AND a.facility_id = c.facility_id");
	SqlSB.append("        AND a.facility_id = d.facility_id");
	SqlSB.append("        AND a.encounter_id = d.encounter_id");
	SqlSB.append("        AND d.dis_adv_status='0'");
	SqlSB.append("        AND e.discharge_type_code = d.discharge_type_code"); //Added by Ashwini on 07-Mar-2018 for GHL-CRF-0505

	pstmt = con.prepareStatement(SqlSB.toString());
	pstmt.setString(1, locale);
	pstmt.setString(2, locale);
	pstmt.setString(3, locale);
	pstmt.setString(4, locale);
	pstmt.setString(5, locale);
	pstmt.setString(6, locale);
	pstmt.setString(7, locale);
	pstmt.setString(8, locale);
	pstmt.setString(9, locale);
	pstmt.setString(10, locale);
	pstmt.setString(11, locale);
	pstmt.setString(12, locale);
	pstmt.setString(13, locale);
	pstmt.setString(14, locale);
	pstmt.setString(15, facilityID);
	pstmt.setString(16, encounterID);
	
	rs = pstmt.executeQuery();
/* 	rs=stmt.executeQuery(SqlSB.toString()); */
	if(rs.next())
	{
		admissiondatetime 		= checkForNull(rs.getString("admission_date_time"));
		adm_date_display		= DateUtils.convertDate(admissiondatetime,"DMYHM","en",locale);
		admissiontypedesc 		= checkForNull(rs.getString("admission_short_desc"));
		specialtyshortdesc 		= checkForNull(rs.getString("specialty_short_desc"));
		practitionername 		= checkForNull(rs.getString("practitioner_name"));
		patienttype 			= checkForNull(rs.getString("patient_type_short_desc"));
		nursingunitcode			= checkForNull(rs.getString("nurSing_Unit_Code")); // Added for INC:47208
		nursingunitshortdesc 	= checkForNull(rs.getString("Nursing_unit_short_desc"));
		serviceshortdesc 		= checkForNull(rs.getString("service_short_desc"));
		bedno 					= checkForNull(rs.getString("bed_no"));
		roomno 					= checkForNull(rs.getString("room_no"));
		bedclassshortdesc 		= checkForNull(rs.getString("bed_class_short_desc"));
		bedtypeshortdesc 		= checkForNull(rs.getString("bed_type_short_desc"));
		gender					= checkForNull(rs.getString("gender"));
		encounterID	 			= checkForNull(rs.getString("encounter_id"));
		practitionerid			= checkForNull(rs.getString("practitioner_id"));
		patient_id				= checkForNull(rs.getString("patient_id"));
		patient_class			= checkForNull(rs.getString("patient_class"));
		meddesc					= checkForNull(rs.getString("team_short_desc"));
		setup_bl_dtls_in_ip_yn	= checkForNull(rs.getString("setup_bl_dtls_in_ip_yn"));
		bl_interfaced_yn		= checkForNull(rs.getString("bl_interfaced_yn"));
		auth_pract_name			= checkForNull(rs.getString("auth_pract_name"));			
		diet_charges_yn			= checkForNull(rs.getString("diet_charges_yn"));
		dis_adv_srl_no			= checkForNull(rs.getString("dis_adv_srl_no"));
		discharge_summary_yn	= checkForNull(rs.getString("discharge_summary_yn"));
		ecg_charges_yn			= checkForNull(rs.getString("ecg_charges_yn"));
		expected_discharge_date = checkForNull(rs.getString("expected_discharge_date"));
		lab_charges_yn			= checkForNull(rs.getString("lab_charges_yn"));
		mri_charges_yn			= checkForNull(rs.getString("mri_charges_yn"));
		ph_charges_yn			= checkForNull(rs.getString("ph_charges_yn"));
		physio_charges_yn		= checkForNull(rs.getString("physio_charges_yn"));
		ref_to_coroner_yn		= checkForNull(rs.getString("ref_to_coroner_yn"));
		rt_charges_yn			= checkForNull(rs.getString("rt_charges_yn"));
		scan_charges_yn			= checkForNull(rs.getString("scan_charges_yn"));
		short_desc				= checkForNull(rs.getString("short_desc"));
		take_home_new_med_yn	= checkForNull(rs.getString("take_home_new_med_yn"));
		take_home_stk_med_yn	= checkForNull(rs.getString("take_home_stk_med_yn"));
		ultrasound_charges_yn	= checkForNull(rs.getString("ultrasound_charges_yn"));
		xray_charges_yn			= checkForNull(rs.getString("xray_charges_yn"));
		/*Added by Rameswar on 22nd May 2015 Against HSA-CRF-0181.1 [IN054123] Start*/
		WEIGHT_ON_ADMISSION		=checkForNull(rs.getString("WEIGHT_ON_ADMISSION"));
		WEIGHT_ON_ADMISSION_UNIT		=checkForNull(rs.getString("WEIGHT_ON_ADMISSION_UNIT"));
		/*Added by Rameswar on 22nd May 2015 Against HSA-CRF-0181.1 [IN054123] End*/
		
		/*Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527*/
		height_on_admission		=checkForNull(rs.getString("HEIGHT_ON_ADMISSION"));
		bmi		=checkForNull(rs.getString("BMI"));
		enable_height_bmi_pat_cls		= checkForNull(request.getParameter("enable_height_bmi_pat_cls"));
		/*Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527 END */
		
		/*Added by Ashwini on 07-Mar-2018 for GHL-CRF-0505*/
		aadhar_card_no		= checkForNull(rs.getString("alt_id4_no"));
		relationship_code	= checkForNull(rs.getString("relationship_code"));
		discharge_indicator = checkForNull(rs.getString("indicator"));
		/*End GHL-CRF-0505*/
 	}
	if(rs !=null) rs.close();
	if(pstmt !=null) pstmt.close();

/* Merged with ip_open_encounter query for PE - 11/05/2010
	if(setup_bl_dtls_in_ip_yn.equals("Y"))
	{
		if (SqlSB.length() > 0)	SqlSB.delete(0, SqlSB.length());
		SqlSB.append(" Select to_char(expected_discharge_date,'dd/mm/rrrr hh24:mi') expected_discharge_date,a.dis_adv_srl_no,b.short_desc,a.ref_to_coroner_yn,");	SqlSB.append("a.discharge_summary_yn,a.take_home_new_med_yn,a.take_home_stk_med_yn,a.lab_charges_yn,a.xray_charges_yn,a.scan_charges_yn,a.ultrasound_charges_yn,");	SqlSB.append("a.mri_charges_yn,a.rt_charges_yn,a.physio_charges_yn,a.ecg_charges_yn,a.diet_charges_yn,a.ph_charges_yn, c.practitioner_name auth_pract_name ");
		SqlSB.append("from IP_DISCHARGE_ADVICE a , IP_DISCHARGE_TYPE_LANG_VW b, AM_PRACTITIONER_LANG_VW c ");
		SqlSB.append("where a.facility_id = '"+facilityID+"' and b.language_id = '"+locale+"' and b.language_id = c.language_id  and encounter_id= '"+encounterID+"' and a.dis_adv_status='0' ");
		SqlSB.append("and a.discharge_type_code = b.discharge_type_code and a.auth_practitioner_id = c.practitioner_id");

		rs = stmt.executeQuery(SqlSB.toString());
		if(rs.next())
		{
			auth_pract_name			= checkForNull(rs.getString("auth_pract_name"));			
			diet_charges_yn			= checkForNull(rs.getString("diet_charges_yn"));
			dis_adv_srl_no			= checkForNull(rs.getString("dis_adv_srl_no"));
			discharge_summary_yn	= checkForNull(rs.getString("discharge_summary_yn"));
			ecg_charges_yn			= checkForNull(rs.getString("ecg_charges_yn"));
			expected_discharge_date = checkForNull(rs.getString("expected_discharge_date"));
			lab_charges_yn			= checkForNull(rs.getString("lab_charges_yn"));
			mri_charges_yn			= checkForNull(rs.getString("mri_charges_yn"));
			ph_charges_yn			= checkForNull(rs.getString("ph_charges_yn"));
			physio_charges_yn		= checkForNull(rs.getString("physio_charges_yn"));
			ref_to_coroner_yn		= checkForNull(rs.getString("ref_to_coroner_yn"));
			rt_charges_yn			= checkForNull(rs.getString("rt_charges_yn"));
			scan_charges_yn			= checkForNull(rs.getString("scan_charges_yn"));
			short_desc				= checkForNull(rs.getString("short_desc"));
			take_home_new_med_yn	= checkForNull(rs.getString("take_home_new_med_yn"));
			take_home_stk_med_yn	= checkForNull(rs.getString("take_home_stk_med_yn"));
			ultrasound_charges_yn	= checkForNull(rs.getString("ultrasound_charges_yn"));
			xray_charges_yn			= checkForNull(rs.getString("xray_charges_yn"));
		}
		if(rs!=null) rs.close();	
	}
	else 
	{
		if (SqlSB.length() > 0)
			SqlSB.delete(0, SqlSB.length());
			SqlSB.append(" Select to_char(expected_discharge_date,'dd/mm/rrrr hh24:mi') expected_discharge_date,");
			SqlSB.append("a.dis_adv_srl_no,b.short_desc,a.ref_to_coroner_yn,");
			SqlSB.append("a.discharge_summary_yn,a.take_home_new_med_yn,");
			SqlSB.append("a.take_home_stk_med_yn, c.practitioner_name auth_pract_name, ");
			SqlSB.append("a.lab_charges_yn, a.xray_charges_yn, a.scan_charges_yn, a.ultrasound_charges_yn, a.mri_charges_yn, a.rt_charges_yn, a.physio_charges_yn, a.ecg_charges_yn, a.diet_charges_yn, a.ph_charges_yn ");
			SqlSB.append(" from IP_DISCHARGE_ADVICE a , IP_DISCHARGE_TYPE_LANG_VW b, AM_PRACTITIONER_LANG_VW c ");
			SqlSB.append("where a.facility_id = '"+facilityID+"' and b.language_id = '"+locale+"' and b.language_id = c.language_id and encounter_id= '"+encounterID+"' and a.dis_adv_status='0' ");
			SqlSB.append("and a.discharge_type_code = b.discharge_type_code and a.auth_practitioner_id = c.practitioner_id");

			rs = stmt.executeQuery(SqlSB.toString());
		 	if(rs.next())
			{
				expected_discharge_date = rs.getString("expected_discharge_date");
				if(expected_discharge_date == null ) expected_discharge_date = "";

				ref_to_coroner_yn  = rs.getString("ref_to_coroner_yn");
				if(ref_to_coroner_yn  == null ) ref_to_coroner_yn = "";

				discharge_summary_yn =   rs.getString("discharge_summary_yn");
				if(discharge_summary_yn == null ) discharge_summary_yn = "";

				take_home_new_med_yn =  rs.getString("take_home_new_med_yn");
				if(take_home_new_med_yn == null ) take_home_new_med_yn = "";

				take_home_stk_med_yn =  rs.getString("take_home_stk_med_yn");
				if(take_home_stk_med_yn == null ) take_home_stk_med_yn = "";
				
				dis_adv_srl_no = rs.getString("dis_adv_srl_no");
				if(dis_adv_srl_no == null) dis_adv_srl_no = "";

				short_desc = rs.getString("short_desc");
				if(short_desc == null ) short_desc = "";

				auth_pract_name = rs.getString("auth_pract_name");
				if(auth_pract_name == null ) auth_pract_name = "";

				lab_charges_yn =  rs.getString("lab_charges_yn");
				if(lab_charges_yn == null ) lab_charges_yn = "";

				xray_charges_yn =  rs.getString("xray_charges_yn");
				if(xray_charges_yn == null ) xray_charges_yn = "";

				scan_charges_yn =  rs.getString("scan_charges_yn");
				if(scan_charges_yn == null ) scan_charges_yn = "";

				ultrasound_charges_yn  = rs.getString("ultrasound_charges_yn");
				if(ultrasound_charges_yn == null ) ultrasound_charges_yn = "";

				mri_charges_yn =  rs.getString("mri_charges_yn");
				if(mri_charges_yn == null ) mri_charges_yn = "";

				rt_charges_yn =  rs.getString("rt_charges_yn");
				if(rt_charges_yn == null ) rt_charges_yn = "";

				physio_charges_yn =  rs.getString("physio_charges_yn");
				if(physio_charges_yn == null ) physio_charges_yn = "";

				ecg_charges_yn =  rs.getString("ecg_charges_yn");
				if(ecg_charges_yn == null ) ecg_charges_yn = "N";

				diet_charges_yn =  rs.getString("diet_charges_yn");
				if(diet_charges_yn == null ) diet_charges_yn = "";

				ph_charges_yn =  rs.getString("ph_charges_yn");
				if(ph_charges_yn == null ) ph_charges_yn = "";
			}
			if(rs!=null) rs.close();	
		}
*/

/* Merged with ip_open_encounter query for PE - 11/05/2010	

	if (SqlSB.length() > 0)	SqlSB.delete(0, SqlSB.length());
	SqlSB.append(" Select AM_GET_DESC.AM_MEDICAL_TEAM(facility_id,team_id, '"+locale+"','2') team_short_desc from AM_PRACT_FOR_TEAM ");
	SqlSB.append(" where facility_id = '"+facilityID+"' and (FACILITY_ID, TEAM_ID) in (select facility_id, to_pract_team_id from IP_ADT_TRN ");
	SqlSB.append(" where facility_id = '"+facilityID+"' and to_practitioner_id='"+practitionerid+"' and ");
	SqlSB.append(" trn_type='A' and encounter_id='"+encounterID+"' ) ");
	if(rs !=null) rs.close();
	stmt1 = con.createStatement();
	rs = stmt1.executeQuery(SqlSB.toString());
	if(rs!= null)
	{
		while(rs.next())
		{				
			meddesc = rs.getString("team_short_desc");										
		}			
	}	
	if(rs !=null) rs.close();
*/

weight_on_admission_unit_display=(WEIGHT_ON_ADMISSION_UNIT.equals("K"))?"Kg":(WEIGHT_ON_ADMISSION_UNIT.equals("G"))?"Gram":"";//Added by Rameswar on 22nd May 2015 Against HSA-CRF-0181.1 [IN054123]
height_on_admission_unit=(height_on_admission.equals(""))?"":"Cm";//Added by Kamatchi S for ML-MMOH-CRF-1527 on 23-jun-2020	
%>

<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='canceldischarge_form' id='canceldischarge_form' action='../../servlet/eIP.CancelDischargeAdviceServlet' method='post' target='messageFrame'>
<table border='0' cellpadding='4' cellspacing='0' width='100%' align='center'>
<tr><td colspan = '7' class='COLUMNHEADER'><fmt:message key="Common.encounterdetails.label" bundle="${common_labels}"/></td></tr>
<tr><!-- 17956 Thursday, January 07, 2010 -->
	  <td class='label' width='25%'><fmt:message key="Common.AdmissionDateTime.label" bundle="${common_labels}"/></td>
	  <td class='QUERYDATA' width='25%'><%=adm_date_display%><input type='hidden' name='admissiondatetime' id='admissiondatetime' value="<%=admissiondatetime%>">
	  </td>
	  <td class='label' nowrap  width='25%'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
	  <td class='QUERYDATA' width='25%'><%=encounterID%><input type='hidden' name='encounterID' id='encounterID' value="<%=encounterID%>">
	  </td>
</tr>
<tr>
	  <td class='label' ><fmt:message key="Common.admissiontype.label" bundle="${common_labels}"/></td>
	  <td class='QUERYDATA' ><%=admissiontypedesc%><input type='hidden' name='admissiontypedesc' id='admissiontypedesc' value="<%=admissiontypedesc%>">
	  </td>
	  <td class='label' >&nbsp;</td>
	  <td class='QUERYDATA' >&nbsp;<input type='hidden' name='patienttype' id='patienttype' value="<%=patienttype%>">
	  </td>	  
</tr>
<tr>  
  	  <td class='label' ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
	  <td class='QUERYDATA' ><%=specialtyshortdesc%>
	  	<input type='hidden' name='specialtyshortdesc' id='specialtyshortdesc' >
	  </td>
      <td class='label' ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
	  <td class='QUERYDATA' ><%=practitionername%>
	  	<input type='hidden' name='practitionername' id='practitionername'>
	  </td>
</tr>
    <tr>  <td class='label' ><fmt:message key="Common.medicalteam.label" bundle="${common_labels}"/></td>
	  <td class='QUERYDATA' colspan='3'><%=meddesc%>
      
	  </td>
</tr>
<!--Added by Rameswar on 22nd May 2015 Against HSA-CRF-0181.1 [IN054123] Start-->
<tr>
<td class='label' ><fmt:message key="eIP.WeightOnAdmission.label" bundle="${ip_labels}"/></td>
 <td class='QUERYDATA'><%=WEIGHT_ON_ADMISSION%> <%=weight_on_admission_unit_display%>
       
  	  </td>
	  <!--Added by kamatchi S for ML-MMOH-CRF-1527 ON 23-JUN-2020-->
  	  <%if(isHeightAndBmiEnable ){
  		if(enable_height_bmi_pat_cls.equals(patient_class)|| enable_height_bmi_pat_cls.equals("ID")){
  	  %>
  	  <td class='label' "><fmt:message key="eIP.HeightOnAdmission.label" bundle="${ip_labels}"/> </td>
  	  <td class='QUERYDATA' ><%=height_on_admission%> <%=height_on_admission_unit%></td>	
	  <td class='label' "><fmt:message key="Common.BMI.label" bundle="${ip_labels}"/> </td>
	  <td class='QUERYDATA' ><%=bmi%></td> 
		<%}}else{%>
	  <td class=label colspan=2 >&nbsp;</td>
	   <%}%>

	
		<!--Added by kamatchi S for ML-MMOH-CRF-1527 ON 23-JUN-2020-->
		
</tr>
<!--Added by Rameswar on 22nd May 2015 Against HSA-CRF-0181.1 [IN054123] End-->
<tr>
 </tr>
  
 <td colspan = '7' class='COLUMNHEADER'><fmt:message key="Common.NursingUnitDetails.label" bundle="${common_labels}"/></td>
 <tr>
  	  <td class='label'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
	  <td class='QUERYDATA'><%=nursingunitshortdesc%>
	  <input type='hidden' name='nursingunitshortdesc' id='nursingunitshortdesc' value="<%=nursingunitshortdesc%>">
	  <input type='hidden' name='nursingunitcode' id='nursingunitcode' value="<%=nursingunitcode%>"><!--  Added for INC:47208 -->
	  </td>
	  <td class='label'><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
	  <td class='QUERYDATA'><%=serviceshortdesc%>
	  	<input type='hidden' name='serviceshortdesc' id='serviceshortdesc'>
	  </td>
</tr>
<tr>
	  <td class='label'><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></td>
	  <td class='QUERYDATA'><%=bedno%>
	  	<input type='hidden' name='bedno' id='bedno' value="<%=bedno%>">
	  </td>
      
  	  <td class='label'><fmt:message key="Common.roomcubicleno.label" bundle="${common_labels}"/></td>
	  <td class='QUERYDATA'><%=roomno%>
	  	<input type='hidden' name='roomno' id='roomno' value="<%=roomno%>">
	  </td>
</tr>
<tr>
	  <td class='label'><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/></td>
	  <td class='QUERYDATA'><%=bedclassshortdesc%>
	  	<input type='hidden' name='bedclassshortdesc' id='bedclassshortdesc'>
	  </td>
	 	  <!--  <td colspan=2 class='label'></td> -->
	  <td class='label'><fmt:message key="Common.bedtype.label" bundle="${common_labels}"/></td>
	  <td class='QUERYDATA'><%=bedtypeshortdesc%>
	  	<input type='hidden' name='bedtypeshortdesc' id='bedtypeshortdesc'>
	  </td>
   </tr>
 </table>

 <table border='0' cellpadding='4' cellspacing='0' width='100%' align='center'>
 <td colspan='4' class='COLUMNHEADER'><fmt:message key="eIP.DischargeDetails.label" bundle="${ip_labels}"/></td>
 <tr>
<%
	String expected_discharge_date_display = "";
	if(expected_discharge_date == "" || expected_discharge_date.equals("null"))
		expected_discharge_date_display = "&nbsp;";
	else
		expected_discharge_date_display = DateUtils.convertDate(expected_discharge_date,"DMYHM","en",locale);
%>
   	  <td class='label' width='25%'><fmt:message key="eIP.ExpectedDischargeDateTime.label" bundle="${ip_labels}"/></td><td class='QUERYDATA' width='25%'><%=expected_discharge_date_display%><input type='hidden' name='expected_discharge_date' id='expected_discharge_date' value="<%=expected_discharge_date%>">
 	  </td>
 	  <td class='label' width='25%'><fmt:message key="Common.dischargetype.label" bundle="${common_labels}"/></td>
 	  <td class='QUERYDATA' width='25%'><%=short_desc%></td>
 </tr>

 <tr><td colspan=4></td></tr>
 <tr>
   	  <td class='label'><fmt:message key="eIP.AuthorizedPractitioner.label" bundle="${ip_labels}"/></td>
  	  <td class='QUERYDATA'><%=auth_pract_name%>
  	  </td>
      <td class='label'><fmt:message key="eIP.PostMortemRequested.label" bundle="${ip_labels}"/></td>
  	  <td class='QUERYDATA'>
      <%if(ref_to_coroner_yn.equals("Y")){ %>
  	  	<img src='../../eCommon/images/enabled.gif'align='center'></img>
  	  	<input type= 'hidden' name='pmrequested' id='pmrequested' value=<%=ref_to_coroner_yn%>>
  	  <% }else{%>
  	  	<img src='../../eCommon/images/RRnwd.gif'align='center'></img>
  	  	<input type= 'hidden' name='pmrequested' id='pmrequested' value=<%=ref_to_coroner_yn%>>
	    <input type= 'hidden' name='dischgsumsigned' id='dischgsumsigned' value=<%=discharge_summary_yn%>>
  	  <%}%>
  	  </td>
  </tr>
  <% if(isDeathRegisterFormAppl && enable_death_reg_form.equals("Y") && discharge_indicator.equals("DS") && !death_reg_form_accession_num.equals("")){ %>
  <tr>
  <td></td>
  <td></td>
  <td class='label'>
   <a href="javascript:getDeathRegFormAccessionNum('<%=patient_id %>','<%=encounterID%>','','<%=admissiondatetime %>','<%=patient_class %>','','<%=nursingunitcode %>','<%=death_reg_form_accession_num %>','');" id='deathRegFormLink'><fmt:message key="Common.DeathRegForm.label" bundle="${common_labels}"/></a>
  </td>
  <td></td>
  </tr>
  <%} %>

<!--Added by Ashwini on 07-Mar-2018 for GHL-CRF-0505-->
<%if(isAadharCardAndRelAppl && (!("").equals(alt_id4_type))){
	 AadharCardAndRelJson	=	eIP.IPCommonBean.getAadharCardAndRel(con, patient_id);
	 citizen_yn				=	(String)AadharCardAndRelJson.get("citizen_yn");

	 if(citizen_yn.equals("Y") && discharge_indicator.equals("DS")){
%>
		<tr>
		  <td class='label'><%=alt_id4_type_desc%></td>
		  <td class='QUERYDATA'><%=aadhar_card_no%></td>

		  <td class='label'><fmt:message key="Common.relationship.label" bundle="${common_labels}"/></td>
		  <%if(relationship_code.equals("1")){%>
		  <td class='QUERYDATA'><fmt:message key="Common.self.label" bundle="${common_labels}"/></td>
		  <%}else if(relationship_code.equals("2")){%>
		  <td class='QUERYDATA'><fmt:message key="Common.Attendant.label" bundle="${common_labels}"/></td>
		  <%}else if(relationship_code.equals("3")){%>
		  <td class='QUERYDATA'><fmt:message key="Common.Spouse.label" bundle="${common_labels}"/></td>
		  <%}%>
		</tr>

	<%}%>
<%}%>
<!--End GHL-CRF-0505-->

   <td colspan='4' class='COLUMNHEADER'><fmt:message key="eIP.TakeHomeMedicine.label" bundle="${ip_labels}"/></td>
   <tr>
       	  <td class='label'><fmt:message key="eIP.NewMedicine.label" bundle="${ip_labels}"/></td>
     	  <td class='QUERYDATA'>
     	  <% if( take_home_new_med_yn.equals("Y")){ %>
     	  <img src='../../eCommon/images/enabled.gif'align='center'></img>
     	  	<input type= 'hidden' name='newmedicine' id='newmedicine' value=<%=take_home_new_med_yn%>>
     	  <%} else { %>
     	  <img src='../../eCommon/images/RRnwd.gif'align='center'></img>
     	  	<input type= 'hidden' name='newmedicine' id='newmedicine' value=<%=take_home_new_med_yn%>>
     	  <%}%>
     	  </td>
     	  <td class='label'><fmt:message key="eIP.StockMedicine.label" bundle="${ip_labels}"/></td>
     	  <td class='QUERYDATA'>
     	  <% if( take_home_stk_med_yn.equals("Y")) {%>
     	  <img src='../../eCommon/images/enabled.gif'align='center'></img>
  	   	  <input type='hidden' name='stockmedicine' id='stockmedicine'  value= <%=take_home_stk_med_yn%>>
  	  <%} else {%>
  	  <img src='../../eCommon/images/RRnwd.gif'align='center'></img>
  	   	<input type='hidden' name='stockmedicine' id='stockmedicine'  value= <%=take_home_stk_med_yn%>>
  	  <%}%>
     	  </td>
   </tr>

   <table border='0' cellpadding='4' cellspacing='0' width='100%' align='center'>
   <td colspan='4' class='COLUMNHEADER'><fmt:message key="eIP.ChargesIncurredonDischargeDay.label" bundle="${ip_labels}"/></td>
   <tr>
          <td width='25%' class='label'><fmt:message key="Common.Lab.label" bundle="${common_labels}"/></td><td width='25%' class='QUERYDATA'>
     	  <% if( lab_charges_yn.equals("Y")){ %>
		  <img src='../../eCommon/images/enabled.gif'align='center'></img>
			<input type='hidden' name='lab' id='lab'  value= <%=lab_charges_yn%>>
		  <% } else {%>
		  <img src='../../eCommon/images/RRnwd.gif'align='center'></img>
    	  <input type='hidden' name='lab' id='lab'  value= <%=lab_charges_yn%>>
    	  <%}%>
     	  </td>
       	  <td class='label' width='25%'><fmt:message key="eIP.Xray.label" bundle="${ip_labels}"/></td>
       	  <td class='QUERYDATA' width='25%'>
       	  <% if( xray_charges_yn.equals("Y")) {%>
		  <img src='../../eCommon/images/enabled.gif'align='center'></img>
	      <input type='hidden' name='xray' id='xray'  value= <%=xray_charges_yn%>>
		  <% } else {%>
		  <img src='../../eCommon/images/RRnwd.gif'align='center'></img>
		  <input type='hidden' name='xray' id='xray'  value= <%=xray_charges_yn%>>
     	  <%}%>
     	  </td>
  </tr>
  <tr>
     	  <td class='label'><fmt:message key="eIP.Scan.label" bundle="${ip_labels}"/></td>
     	  <td class='QUERYDATA'>
     	  <% if( scan_charges_yn.equals("Y")) {%>
     	  <img src='../../eCommon/images/enabled.gif'align='center'></img>
     	  	<input type='hidden' name='scan' id='scan'  value= <%=scan_charges_yn%>>
  		  <% } else {%>
  		  <img src='../../eCommon/images/RRnwd.gif'align='center'></img>
    	  	<input type='hidden' name='scan' id='scan'  value= <%=scan_charges_yn%>>
    	  <%}%>
     	  </td>
     	  <td class='label'><fmt:message key="Common.Ultrasound.label" bundle="${common_labels}"/></td>
     	  <td class='QUERYDATA'>
     	  <% if( ultrasound_charges_yn.equals("Y")) {%>
     	  <img src='../../eCommon/images/enabled.gif'align='center'></img>
  	  	  <input type='hidden' name='scan' id='scan'  value= <%=ultrasound_charges_yn%>>
  		  <% } else {%>
  	      <img src='../../eCommon/images/RRnwd.gif'align='center'></img>
     	  <input type='hidden' name='scan' id='scan'  value= <%=ultrasound_charges_yn%>>
     	  <%}%>
     	  </td>
</tr>
<tr>	
     	  <td class='label'><fmt:message key="eIP.MRI.label" bundle="${ip_labels}"/></td>
     	  <td class='QUERYDATA'>
     	  <% if( mri_charges_yn.equals("Y")) {%>
     	  <img src='../../eCommon/images/enabled.gif'align='center'></img>
     	  <input type='hidden' name='mri' id='mri'  value= <%=mri_charges_yn%>>
		  <% } else {%>
		  <img src='../../eCommon/images/RRnwd.gif'align='center'></img>
    	  <input type='hidden' name='mri' id='mri'  value= <%=mri_charges_yn%>>
    	  <%}%>
     	  </td>     	 
          <td class='label'><fmt:message key="Common.RT.label" bundle="${common_labels}"/></td>
      	  <td class='QUERYDATA'>
      	  <% if( rt_charges_yn.equals("Y")) { %>
      	  <img src='../../eCommon/images/enabled.gif'align='center'></img>
  	      <input type='hidden' name='rt' id='rt'  value= <%=rt_charges_yn%>>
  	      <% } else {%>
  	      <img src='../../eCommon/images/RRnwd.gif'align='center'></img>
     	  <input type='hidden' name='rt' id='rt'  value= <%=rt_charges_yn%>>
     	  <%}%>
      	  </td>
</tr>
<tr>
		  <td class='label'><fmt:message key="eIP.Physio.label" bundle="${ip_labels}"/></td>
		  <td class='QUERYDATA'>
		  <% if( physio_charges_yn.equals("Y")) {%>
		  <img src='../../eCommon/images/enabled.gif'></img>
				<input type='hidden' name='physio' id='physio'  value= <%=physio_charges_yn%>>
		  <% } else {%>
		  <img src='../../eCommon/images/RRnwd.gif'></img>
      	    	<input type='hidden' name='physio' id='physio'  value= <%=physio_charges_yn%>>
      	  <%}%>
      	  </td>
      	  <td class='label'><fmt:message key="Common.ecg.label" bundle="${common_labels}"/></td>
      	  <td class='QUERYDATA'>
      	  <% 
		  if( ecg_charges_yn.equals("Y")) {
		  %>
      	  <img src='../../eCommon/images/enabled.gif'></img>
  	      <input type='hidden' name='ecg' id='ecg'  value= <%=ecg_charges_yn%>>
		  <% } else {%>
		  <img src='../../eCommon/images/RRnwd.gif'></img>
      	  <input type='hidden' name='ecg' id='ecg'  value= <%=ecg_charges_yn%>>
      	  <% }%>
      	  </td>
</tr>
<tr>
      	  <td class='label'><fmt:message key="eIP.Diet.label" bundle="${ip_labels}"/></td>
      	  <td class='QUERYDATA'>
      	  <% if( diet_charges_yn.equals("Y")){ %>
      	  <img src='../../eCommon/images/enabled.gif'align='center'></img>
  	      <input type='hidden' name='diet' id='diet'  value= <%=diet_charges_yn%>>
  	      <% } else {%>
  	      <img src='../../eCommon/images/RRnwd.gif'align='center'></img>
      	  <input type='hidden' name='diet' id='diet'  value= <%=diet_charges_yn%>>
      	  <%}%>
      	  </td>
      	  <td class='label'><fmt:message key="Common.pharmacy.label" bundle="${common_labels}"/></td>
      	  <td class='QUERYDATA'>
      	  <% if( ph_charges_yn.equals("Y")){ %>
      	  <img src='../../eCommon/images/enabled.gif'align='center'></img>
  	      <input type='hidden' name='pharmacy' id='pharmacy'  value= "<%=ph_charges_yn%>">
		  <% } else {%>
		  <img src='../../eCommon/images/RRnwd.gif'align='center'></img>
     	  <input type='hidden' name='pharmacy' id='pharmacy'  value= "<%=ph_charges_yn%>">
     	  <%}%>
      	  </td>
    </tr>
   </table>

    <table border='0' cellpadding='4' cellspacing='0' width='100%' align='center'>
    <tr>
    	  <td width="25%" class='label' id='u' nowrap>&nbsp;</td>          
    	  <td width="25%" class='label' id='v' nowrap>&nbsp;</td>          
		  <td colspan=2 nowrap>
		  </td>
	</tr>
    </table>
    <table border='0' cellpadding='4' cellspacing='0' width='100%' align='center'>			  
	<tr> 
		<td class='label' height='5' width='75%'></td>
		
		<td class='button'>
		<%if(!fromfunction.equals("PD")){%>
		<input type=button class='button' name = 'cancel_discharge' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelDischargeAdvice.label","common_labels")%>' align = 'left' onClick='CancelDisc(this)'><%}%></td>
		<td class='button' width='5%'>
		<input type=button class='button' name = 'close' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' align='left'  onClick='CloseWin(this)'></td>

	</tr>
</table>
	<input type ='hidden' name= 'dis_adv_srl_no' value="<%=dis_adv_srl_no%>">
	<input type ='hidden' name= 'patient_id' value="<%=patient_id%>">	
	<input type ='hidden' name= 'function_id' value="<%=function_id%>">	
	<input type ='hidden' name= 'patient_class' value="<%=patient_class%>">	
	<input type ='hidden' name= 'bl_interfaced_yn' value="<%=bl_interfaced_yn%>">	
	<input type ='hidden' name= 'bl_operational' value="<%=bl_operational%>">	
	<input type ='hidden' name= 'death_reg_form_accession_num' value="<%=death_reg_form_accession_num%>">	<!-- Added by Ajay Hatwate for AAKH-CRF-0179 on 22-08-2023 -->
	<input type ='hidden' name= 'callback_mode' value="View">
	
</BODY>
<%
	if (rs != null) rs.close();
	if (stmt != null) stmt.close();
	if (stmt1 != null) stmt1.close();
	if (pstmt != null) pstmt.close();
	
}catch(Exception e) 
{
/* 	out.println(e.toString()); */
e.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(con,request);
}
%>
</HTML>

<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

