<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import= "webbeans.eCommon.*,com.ehis.util.*,java.util.*,java.sql.*,java.text.*,org.json.simple.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" >
<HTML>
<HEAD>
<TITLE> <fmt:message key="Common.DischargeAdvice.label" bundle="${common_labels}"/> </TITLE>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></script>
<script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></script>
<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<Script src="../../eCommon/js/locale.js" language="JavaScript"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/dchk.js" language="JavaScript"></Script>
<script src='../../eMR/js/SickLeave.js' language='javascript'></script>
<script src='../../eCA/js/CAMainMenu.js' language='javascript'></script>
<script src="../js/DischargeAdvice.js" language="JavaScript"></Script>
<script src="../js/IPPractitionerComponent.js" language="JavaScript"></Script>
<script src="../js/CancelAdmission.js" language="JavaScript"></Script>

<script>

function enablePolice(obj)
{
	if(document.forms[0].medico_legal.checked==true)
	{
		document.forms[0].pol_rep_no.disabled=false;
		document.forms[0].pol_stn_id.disabled=false;
		document.forms[0].pol_id.disabled=false;
	}
	else
	{
		document.forms[0].pol_rep_no.value='';
		document.forms[0].pol_rep_no.disabled=true;
		document.forms[0].pol_stn_id.value='';
		document.forms[0].pol_stn_id.disabled=true;
		document.forms[0].pol_id.value='';
		document.forms[0].pol_id.disabled=true;
	}
}

function DateValidations(obj)
{
	if(document.forms[0].patient_class_value.value == "IP")
		validateDateTimes(obj,'A');
	else if(document.forms[0].patient_class_value.value == "DC")
	{
			if(validDateObj(obj,"DMYHM", localeName))
				dayCareDateCheck(obj);
	}
}

function expandCollapse(calledFrom) 
{					
	if(calledFrom == 'Discharge_Details_tab') 
	{
		document.getElementById("Discharge_Details").style.display = 'inline';
		document.getElementById("Other_Details").style.display = 'none';						
	} 
	else if(calledFrom == 'Other_Details_tab') 
	{
		document.getElementById("Discharge_Details").style.display = 'none';
		document.getElementById("Other_Details").style.display = 'inline';						
	}
}

function LoadRecordButton()
{
	//Added by Kamatchi S for ML-MMOH-SCF-1643
	if(parent.frames[1].document.forms[0].weight_on_admission)
		//parent.frames[1].document.forms[0].weight_on_admission.value=parent.frames[2].document.forms[0].weight_on_admission_load.value;
		parent.frames[1].document.forms[0].weight_on_admission.value=parent.f_query_add_mod.document.getElementById("weight_on_admission_load").value;
	if(parent.frames[1].document.forms[0].height_on_admission)
		//parent.frames[1].document.forms[0].height_on_admission.value=parent.frames[2].document.forms[0].height_on_admission_load.value;
		parent.frames[1].document.forms[0].height_on_admission.value=parent.f_query_add_mod.document.getElementById("height_on_admission_load").value;
	if(parent.frames[1].document.forms[0].bmi)
		//parent.frames[1].document.forms[0].bmi.value=parent.frames[2].document.forms[0].bmi_load.value;
		parent.frames[1].document.forms[0].bmi.value=parent.f_query_add_mod.document.getElementById("bmi_load").value;	
}

</script>
<!--FD-PMG20089-CRF-0547-IP
<script language="vbscript">
function myMessageBox(title, prompt, buttons)
myMessageBox = MsgBox(prompt, buttons, title)
end function
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

-->
</HEAD>

<%
	

	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue
	String locale			= (String)session.getAttribute("LOCALE");
	String bl_operational	= (String)session.getValue("bl_operational");
	Connection con			=	null;
	Statement stmt			=	null;
	ResultSet rs			=	null;
	PreparedStatement pstmt		=	null;//Added by Ajay Hatwate for AAKH-CRF-0179
	String facilityID		= (String)session.getValue("facility_id");
	String patient_Id		= request.getParameter("patient_Id");
	String encounterID		= checkForNull(request.getParameter("EncounterId"));
	String is_ca_yn			= checkForNull(request.getParameter("is_ca_yn"));
    String chck_val			= checkForNull(request.getParameter("chck_val"));
    String function_id		= checkForNull(request.getParameter("function_id"));
	
	if(function_id.equals("")) function_id = "PRE_DIS_ADVICE";
	String dead_yn			= "";
	String informed_to		= "";
	String informed_name	= "";
	String informed_date	= "";
	String pol_rep_no		= "";	
	String pol_stn_id		= "";	
	String pol_id			= "";
	String absdate			= "";
	String reported_to		= "";
	int mother_cut_off_age	= 0;
	int mother_max_age		= 0;
	int maxrecord			=0;
	String pol_rep_no_vw	= "";
	String pol_stn_id_vw	= ""; 
	String pol_id_vw		= "";
	String mlc_yn			= "";
	String disabled_yn		= "N";
	String valid			= "";
	String from_time		= "";
	String max_param_date	= "";
	String valid_date		= "";
	String ip_Trn_Date		= "";	
	// By Annadurai 11/5/2004  - For DC module Starts
	
	/*Added by Ashwini on 07-Mar-2018 for GHL-CRF-0505*/
	boolean isAadharCardAndRelAppl = false;
	String citizen_yn = "";
	String aadhar_card_no = "";
	JSONObject AadharCardAndRelJson	= new JSONObject();
	String alt_id4_length = "";
	String alt_id4_alphanum_yn = "";
	String alt_id4_type_desc = "";
	String alt_id4_type = "";
	JSONObject AltIdLengthAndTypeJson = new JSONObject(); 
	/*End GHL-CRF-0505*/
	//Added by KAMATCHI S for ML-MMOH-CRF-1527 on 23-JUN-2020
	boolean isHeightAndBmiEnable =false;

	String target_date				= "";
	int max_disch_period_for_dc		= 0;
	String system_date_time			= "";
	String leave_exp_dt_flag		= "";
	String pat_dtls_unknown_yn		= "N";
	String setup_bl_dtls_in_ip_yn	= "N";
	int dis_date_chk_days			= 0;
	String	login_pract_id			= (String)session.getValue("ca_practitioner_id");
	String	login_pract_type		= "";
	String	login_pract_name		= "";
	String sql_adap					= "";
	String adap_func_ref			= "";
	String adap_func_name			= "";
	String adap_exec_name			= "";
	String bl_interfaced_yn			= "";
	boolean record_exists			= false;
	String contact1_name			= "";
	String contact2_name			= "";
	java.text.SimpleDateFormat dateFormat	=	new java.text.SimpleDateFormat( "dd/MM/yyyy" ) ;
	java.util.Date dt						=	new java.util.Date();
	String Sdate							=	dateFormat.format( dt ) ;
	Sdate	=	Sdate + " "+String.valueOf(dt.getHours())+":"+String.valueOf(dt.getMinutes());
	StringBuffer sqlSB = new StringBuffer();
	String admissiondatetime		= checkForNull(request.getParameter("admissiondatetime"));
	String admissiondatedisplay		= "" ;
	String practitionername			= checkForNull(request.getParameter("practitionername"));
	String bedno					= checkForNull(request.getParameter("bedno"));
	String roomno					= checkForNull(request.getParameter("roomno"));
	String practitioner_id			= checkForNull(request.getParameter("practitioner_id"));
	String spltycode				= checkForNull(request.getParameter("spltycode"));
	String nursingunitcode 			= checkForNull(request.getParameter("nursingunitcode"));
	String gender					= checkForNull(request.getParameter("gender"));
	String DOB						= checkForNull(request.getParameter("DOB"));
	String expdischargedatetime		= checkForNull(request.getParameter("expdischargedatetime"));
	String query_string				= checkForNull(request.getParameter("query_string"));
	String modified_date_val		= checkForNull(request.getParameter("modified_date_val"));
	String exp_date_display			= "";
	if(expdischargedatetime == null || expdischargedatetime.equals("null"))
	{
		exp_date_display = "&nbsp;";
	}else
	{
		exp_date_display			= DateUtils.convertDate(expdischargedatetime,"DMYHM","en",locale);
	}
	if(admissiondatetime == null || admissiondatetime.equals("null"))
	{
		admissiondatedisplay = "&nbsp;";
	}else
	{
		admissiondatedisplay		= DateUtils.convertDate(admissiondatetime,"DMYHM","en",locale);
	}
	String patient_class			= checkForNull(request.getParameter("patient_class"));
	String patient_status			= checkForNull(request.getParameter("patient_status"));
	leave_exp_dt_flag				= checkForNull(request.getParameter("leave_exp_dt_flag"),"N");
	int patient_age = 0;
	String patient_age_str			= checkForNull(request.getParameter("patient_age"));
	if(!patient_age_str.equals(""))
	{
			patient_age = Integer.parseInt(patient_age_str);
	}
// added for sathya sai migrated Wednesday, June 09, 2010 Venkat S
	String max_disch_period_for_predc=request.getParameter("max_disch_period_for_predc");
		if((max_disch_period_for_predc==null || max_disch_period_for_predc.equals("")))
		max_disch_period_for_predc ="0";
	String mother_cut_off_age_pda=request.getParameter("mother_cut_off_age_pda");
		if((mother_cut_off_age_pda==null || mother_cut_off_age_pda.equals("")))
		mother_cut_off_age_pda ="0";
	String mother_max_age_pda=request.getParameter("mother_max_age_pda");
		if((mother_max_age_pda==null || mother_max_age_pda.equals("")))
		mother_max_age_pda ="0";
	
	//Added by Ajay Hatwate for AAKH-CRF-0179 on 07/08/2023
	Boolean isDeathRegisterFormAppl = false;
	String enable_death_reg_form = "N";
	String death_reg_form_accession_num = "";
	//End of AAKH-CRF-0179
	try
	{
		con = ConnectionManager.getConnection(request);
		/*Below line(s) added by venkateshs against ML-MMOH-CRF-0354 [IN057191] */
		boolean siteSpecific		=eCommon.Common.CommonBean.isSiteSpecific(con, "MR","MLC_TO_MEDICO_LEGAL_CASE"); 
		/*end ML-MMOH-CRF-0354 [IN057191] */

		isDeathRegisterFormAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "DEATH_REGISTER_FORM_APPL"); //Added by Ajay Hatwate for AAKH-CRF-0179 on 08-08-2023
		
		enable_death_reg_form = eMP.MPCommonBean.getEnableDeathRegisterFormYN(con);
	
		
		isHeightAndBmiEnable	= eCommon.Common.CommonBean.isSiteSpecific(con, "MP", "BMI_REG_PAT_CHNGES_RH101");//Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527
		/*Added by Ashwini on 07-Mar-2018 for GHL-CRF-0505*/
		isAadharCardAndRelAppl	=	eCommon.Common.CommonBean.isSiteSpecific(con, "IP","AADHAR_CARD_RELATIONSHIP"); 

		AadharCardAndRelJson	=	eIP.IPCommonBean.getAadharCardAndRel(con, patient_Id);
		citizen_yn				=	(String)AadharCardAndRelJson.get("citizen_yn");
		aadhar_card_no			=	(String)AadharCardAndRelJson.get("aadhar_card_no");

		AltIdLengthAndTypeJson	=	eIP.IPCommonBean.getAltIdLengthAndType(con);
		alt_id4_length			=	(String)AltIdLengthAndTypeJson.get("alt_id4_length");
		alt_id4_alphanum_yn		=	(String)AltIdLengthAndTypeJson.get("alt_id4_alphanum_yn");
		alt_id4_type_desc		=	(String)AltIdLengthAndTypeJson.get("alt_id4_type_desc");
		alt_id4_type			=	(String)AltIdLengthAndTypeJson.get("alt_id4_type");
		/*End GHL-CRF-0505*/

		stmt=con.createStatement();
		if(isDeathRegisterFormAppl){
			if (sqlSB.length() > 0)
			{
				sqlSB.delete(0, sqlSB.length());
			}

			if(enable_death_reg_form.equals("Y")){
				if (sqlSB.length() > 0)
				{
					sqlSB.delete(0, sqlSB.length());
				}
				sqlSB.append(" SELECT death_reg_form_accession_num FROM PR_ENCOUNTER WHERE FACILITY_ID=? and ENCOUNTER_ID = ?");
				pstmt = con.prepareStatement(sqlSB.toString());
				pstmt.setString(1, facilityID);
				pstmt.setString(2, encounterID);
				rs		= pstmt.executeQuery();
				if ((rs != null) && (rs.next())){
					death_reg_form_accession_num	=	checkForNull(rs.getString("death_reg_form_accession_num"));
				}
			}
		}
		/*sqlSB.append(" Select dis_date_chk_days, dis_date_chk_days_unit, to_char(sysdate - decode( dis_date_chk_days_unit,'H', dis_date_chk_days/24, dis_date_chk_days),'dd/mm/rrrr hh24:mi') allow_discharge_date, setup_bl_dtls_in_ip_yn, max_disch_period_for_dc,bl_interfaced_yn from IP_PARAM where facility_id='"+facilityID+"' ");
		rs		=	stmt.executeQuery(sqlSB.toString());
		if(rs!=null )
		{
			while(rs.next())
			{
				setup_bl_dtls_in_ip_yn	= rs.getString("setup_bl_dtls_in_ip_yn");
				Sdate					= rs.getString("allow_discharge_date");
				max_disch_period_for_dc	= rs.getInt("max_disch_period_for_dc"); 
				bl_interfaced_yn		= rs.getString("bl_interfaced_yn"); 
			}
		}
		if (rs != null)		rs.close();
		*/
		/* Added For PE On 5/5/2010 
			Above Query was commented and the values are getting from the Result page from same IP Param table
		*/	
		setup_bl_dtls_in_ip_yn	= checkForNull(request.getParameter("setup_bl_dtls_in_ip_yn"));
		Sdate					= checkForNull(request.getParameter("allow_discharge_date_predc"));
		try{
			max_disch_period_for_dc = Integer.parseInt(request.getParameter("max_disch_period_for_predc")==null?"0":request.getParameter("max_disch_period_for_predc"));

		}catch (Exception e) {

			out.println(e.toString());
			e.printStackTrace();
		}
		bl_interfaced_yn		= checkForNull(request.getParameter("bl_interfaced_yn"));		 
		// added for sathya sai migrated Wednesday, June 09, 2010 Venkat S mother_cut_off_age = Integer.parseInt(request.getParameter("mother_cut_off_age_pda")==null?"0":request.getParameter("mother_cut_off_age_pda"));
		//mother_max_age			= Integer.parseInt(request.getParameter("mother_max_age_pda")==null?"0":request.getParameter("mother_max_age_pda"));
		mother_cut_off_age			= Integer.parseInt(mother_cut_off_age_pda);
		mother_max_age				= Integer.parseInt(mother_max_age_pda);
		pat_dtls_unknown_yn		= checkForNull(request.getParameter("pat_dtls_unknown_yn_pda"));
		contact1_name			= checkForNull(request.getParameter("contact1_name_pda"));
		contact2_name			= checkForNull(request.getParameter("contact2_name_pda"));
		disabled_yn				= checkForNull(request.getParameter("disabled_yn"));
		mlc_yn					= checkForNull(request.getParameter("mlc_yn"));
		pol_rep_no_vw			= checkForNull(request.getParameter("pol_rep_no"));
		pol_stn_id_vw			= checkForNull(request.getParameter("pol_stn_id"));
		pol_id_vw				= checkForNull(request.getParameter("pol_id"));
		String bmi= checkForNull(request.getParameter("bmi")); /*Added by KAMATCHI S on 23-JUN-2020 foR ML-MMOH-CRF-1527*/
		if (sqlSB.length() > 0)
		{
			sqlSB.delete(0, sqlSB.length());
		}
		sqlSB.append(" select to_char(absconding_date,'dd/mm/rrrr HH24:mi') absconding_date, reported_to, pol_rep_no, pol_stn_id, pol_id, informed_to, informed_name, to_char (informed_date_time, 'dd/mm/rrrr hh24:mi')informed_date_time from IP_LEAVE_DETAIL where facility_id = '"+facilityID+"' and encounter_id = '"+encounterID+"' and leave_status='"+patient_status+"' order by srl_no desc ");
		rs		= stmt.executeQuery(sqlSB.toString());
		if ((rs != null) && (rs.next())){
			informed_to			=	checkForNull(rs.getString("INFORMED_TO"));
			informed_name		=	checkForNull(rs.getString("INFORMED_NAME"));
			informed_date		=	checkForNull(rs.getString("INFORMED_DATE_TIME"));
			if(patient_status.equals("4"))
			{
				reported_to		=	checkForNull(rs.getString("reported_to"));
				absdate			=	checkForNull(rs.getString("ABSCONDING_DATE"));
				pol_rep_no		=	checkForNull(rs.getString("POL_REP_NO"));
				pol_stn_id		=	checkForNull(rs.getString("POL_STN_ID"));
				pol_id			=	checkForNull(rs.getString("POL_ID"));
			}
		}
		if(mlc_yn.equals("Y"))
		{
			if(pol_rep_no.equals("") && pol_stn_id.equals("") && pol_id.equals(""))
			{
				if(!pol_rep_no_vw.equals("") || !pol_stn_id_vw.equals("") || !pol_id_vw.equals(""))
				{
					pol_rep_no	= pol_rep_no_vw ;
					pol_stn_id	= pol_stn_id_vw ; 
					pol_id		= pol_id_vw ;
					disabled_yn = "Y";
				}
			}
		}
		if (rs != null)		rs.close();
		if (sqlSB.length() > 0){sqlSB.delete(0, sqlSB.length());}

		if(patient_class.equals("DC"))
		{
				/* Commented and merged with below query for PE on 10/05/2010

				sqlSB.append(" select to_char((sysdate+");
				sqlSB.append(max_disch_period_for_dc);
				sqlSB.append("/24),'dd/mm/rrrr hh24:mi') target_date, to_char(sysdate,'dd/mm/rrrr hh24:mi') system_date_time, to_char(sysdate,'dd/mm/rrrr') system_date from DUAL ");
				rs		= stmt.executeQuery(sqlSB.toString());
				if ((rs != null) && (rs.next())){
					target_date				= rs.getString("target_date");
					system_date_time	= rs.getString("system_date_time");
				}
				if (sqlSB.length() > 0){sqlSB.delete(0, sqlSB.length());}
				if (rs!=null) rs.close();*/
				sqlSB.append(" select to_char((sysdate+");
				sqlSB.append(max_disch_period_for_dc);
				sqlSB.append("/24),'dd/mm/rrrr hh24:mi') target_date,"); 
				
				/* This query commented by Venkatesh.S on 30-Aug-2012 against SS-SCF-0674 [IN:034278] */
				
				/*sqlSB.append("  to_char(sysdate,'dd/mm/rrrr hh24:mi') system_date_time, to_char(sysdate,'dd/mm/rrrr') system_date, TO_CHAR((SELECT MAX (trn_date_time) FROM IP_ADT_TRN WHERE facility_id = '"+facilityID+"' AND encounter_id = '"+encounterID+"' ), 'dd/mm/rrrr hh24:mi') FROM_TIME, TO_CHAR(TO_DATE('"+admissiondatetime+"', 'dd/mm/rrrr hh24:mi')+ (1 / 24) * '"+max_disch_period_for_dc+"', 'dd/mm/rrrr hh24:mi' ) MAX_PARAM_DATE, (CASE WHEN TRUNC (TO_DATE('"+admissiondatetime+"', 'dd/mm/rrrr hh24:mi')+ (1 / 24) * '"+max_disch_period_for_dc+"') != TRUNC (TO_DATE ('"+admissiondatetime+"', 'dd/mm/rrrr hh24:mi')) THEN 'N' ELSE 'Y' END ) VALID, TO_CHAR((CASE WHEN TRUNC (  TO_DATE ('"+admissiondatetime+"', 'dd/mm/rrrr hh24:mi')+ (1 / 24) * '"+max_disch_period_for_dc+"') != TRUNC (TO_DATE ('"+admissiondatetime+"', 'dd/mm/rrrr hh24:mi')) THEN trunc(TO_DATE('"+admissiondatetime+"', 'DD/MM/rrrr hh24:mi')) ELSE TO_DATE('"+admissiondatetime+"', 'dd/mm/rrrr hh24:mi')+ (1 / 24) * '"+max_disch_period_for_dc+"' END), 'dd/mm/rrrr') VALID_DATE  from dual" );*/
				
				/* In Below query  last two lines only added by Venkatesh.S against SS-SCF-0674 [IN:034278]  on 30-Aug-2012 to get recent trn_date_time */
				
				sqlSB.append("  to_char(sysdate,'dd/mm/rrrr hh24:mi') system_date_time, to_char(sysdate,'dd/mm/rrrr') system_date, TO_CHAR((SELECT MAX (trn_date_time) FROM IP_ADT_TRN WHERE facility_id = '"+facilityID+"' AND encounter_id = '"+encounterID+"' ), 'dd/mm/rrrr hh24:mi') FROM_TIME, TO_CHAR(TO_DATE('"+admissiondatetime+"', 'dd/mm/rrrr hh24:mi')+ (1 / 24) * '"+max_disch_period_for_dc+"', 'dd/mm/rrrr hh24:mi' ) MAX_PARAM_DATE, (CASE WHEN TRUNC (TO_DATE('"+admissiondatetime+"', 'dd/mm/rrrr hh24:mi')+ (1 / 24) * '"+max_disch_period_for_dc+"') != TRUNC (TO_DATE ('"+admissiondatetime+"', 'dd/mm/rrrr hh24:mi')) THEN 'N' ELSE 'Y' END ) VALID, TO_CHAR((CASE WHEN TRUNC (  TO_DATE ('"+admissiondatetime+"', 'dd/mm/rrrr hh24:mi')+ (1 / 24) * '"+max_disch_period_for_dc+"') != TRUNC (TO_DATE ('"+admissiondatetime+"', 'dd/mm/rrrr hh24:mi')) THEN trunc(TO_DATE('"+admissiondatetime+"', 'DD/MM/rrrr hh24:mi')) ELSE TO_DATE('"+admissiondatetime+"', 'dd/mm/rrrr hh24:mi')+ (1 / 24) * '"+max_disch_period_for_dc+"' END), 'dd/mm/rrrr') VALID_DATE , TO_CHAR((SELECT MAX (trn_date_time) FROM ip_adt_trn WHERE facility_id='"+facilityID+"' AND encounter_id ='"+encounterID+"'),'dd/mm/rrrr hh24:mi') ip_trn_date from dual" );
				
				
				rs		= stmt.executeQuery(sqlSB.toString());
				if ((rs != null) && (rs.next())){
					valid			 = rs.getString("VALID");
					from_time		 = rs.getString("FROM_TIME");
					max_param_date	 = rs.getString("MAX_PARAM_DATE");
					valid_date		 = rs.getString("VALID_DATE");
					valid_date		 = DateUtils.convertDate(valid_date,"DMY","en",locale);
					target_date		 = rs.getString("target_date");
					system_date_time = rs.getString("system_date_time");
					
					/* Below one line added by Venkatesh.S on 30-Aug-2012 against SS-SCF-0674 [IN:034278] */
					ip_Trn_Date       =rs.getString("ip_trn_date");
					
				}
				//valid_date = valid_date+ " 23:59";
				valid_date = max_param_date; //Modified for AAKH-SCF-0093
		}
		if(patient_class.equals("IP"))
		{
				if (sqlSB.length() > 0){sqlSB.delete(0, sqlSB.length());}
				sqlSB.append(" SELECT to_char(sysdate,'dd/mm/rrrr hh24:mi') system_date_time, to_char(MAX(trn_date_time),'dd/mm/rrrr hh24:mi') ip_trn_date FROM IP_ADT_TRN WHERE facility_id = '"+facilityID+"' AND encounter_id = '"+encounterID+"' ");
				rs		= stmt.executeQuery(sqlSB.toString());
				if ((rs != null) && (rs.next())){
					ip_Trn_Date		= rs.getString("ip_Trn_Date");
					system_date_time= rs.getString("system_date_time");
				}
				if (rs!=null) rs.close();
		}
		
		if (rs!=null) rs.close();
		/*Thursday, May 06, 2010 , IN021214*/
		/*
		if(!( system_date_time==null || system_date_time.equals("")))
			system_date_time_display=DateUtils.convertDate(system_date_time,"DMYHM","en",locale);
			*/
		// By Annadurai 11/5/2004 - For Day Care Issues end.
		if (sqlSB.length() > 0){sqlSB.delete(0, sqlSB.length());}
		/*
			Commented On 5/5/2010 for PE both Quries are merged to Single @ line 311.
		*/
		/*
		sqlSB.append("select pat_dtls_unknown_yn from MP_PATIENT where patient_id = '");
		sqlSB.append(patient_Id);
		sqlSB.append("' ");
		rs	 = stmt.executeQuery(sqlSB.toString());
		if ((rs != null) && (rs.next())){
		pat_dtls_unknown_yn	= rs.getString("pat_dtls_unknown_yn");
		}
		if (rs!=null) rs.close();
		if (sqlSB.length() > 0)	sqlSB.delete(0, sqlSB.length()); 
		sqlSB.append( "select nb_mother_cutoff_age mother_cut_off_age, nb_mother_upper_age mother_max_age from MP_PARAM" );
        
		rs		= stmt.executeQuery(sqlSB.toString());

		if ((rs != null) && (rs.next()))
		{
		mother_cut_off_age	= rs.getInt("mother_cut_off_age");
		mother_max_age		= rs.getInt("mother_max_age");
		}
		sqlSB.append(" SELECT A.PAT_DTLS_UNKNOWN_YN,B.CONTACT1_NAME,B.CONTACT2_NAME FROM MP_PATIENT A ,MP_PAT_REL_CONTACTS B WHERE A.PATIENT_ID = '"+patient_Id+"' AND A.PATIENT_ID=B.PATIENT_ID");
		rs		= stmt.executeQuery(sqlSB.toString());
		while(rs.next()){
			pat_dtls_unknown_yn	= rs.getString("PAT_DTLS_UNKNOWN_YN");
//			mother_cut_off_age	 	= rs.getInt("MOTHER_CUT_OFF_AGE");
//			mother_max_age			= rs.getInt("MOTHER_MAX_AGE");
			contact1_name				= checkForNull(rs.getString("CONTACT1_NAME"));
			contact2_name				= checkForNull(rs.getString("CONTACT2_NAME"));

		}
		if (rs!=null) rs.close();*/
		if(is_ca_yn.equals(""))
			login_pract_id = practitioner_id;

			if (sqlSB.length() > 0)
			sqlSB.delete(0, sqlSB.length()); 
			sqlSB.append( " select pract_type, practitioner_name from AM_PRACTITIONER_LANG_VW where practitioner_id = '"+login_pract_id+"' and language_id = '"+locale+"' ");
			rs		= stmt.executeQuery(sqlSB.toString());
			if ((rs != null) && (rs.next())){
				login_pract_type	= rs.getString("pract_type");
				login_pract_name	= rs.getString("practitioner_name");
			}
			if(login_pract_type.equals("MD") || login_pract_type.equals("PS") ||login_pract_type.equals("SG") || login_pract_type.equals("DN")){
				practitioner_id = login_pract_id;
				practitionername = login_pract_name;
			}
			if (rs!=null) rs.close();
		/*
		COMMENTED ON 5/5/2010  THE QUERY WAS MERGED @LINE 311 
		try{
			mp_pat_rel_contacts.append(" select contact1_name,contact2_name from mp_pat_rel_contacts where patient_id ='"+patient_Id+"' ");
			//stmt = con.createStatement();    
			rs = stmt.executeQuery(mp_pat_rel_contacts.toString());

				if(rs != null && rs.next())
				{
					contact1_name	=	checkForNull(rs.getString("contact1_name"));
					contact2_name	=	checkForNull(rs.getString("contact2_name"));
				}
		}
		catch(Exception e)
		{
			out.println("Exception in getting mp_pat_rel_contacts:"+e.toString());
		}	
		if(rs !=null) rs.close(); //if(stmt != null) stmt.close();
		if (mp_pat_rel_contacts.length() > 0)
				mp_pat_rel_contacts.delete(0, mp_pat_rel_contacts.length());
	 */
			
			/*Added Below Line code for [AK-SCF-0153] by Senthil */
			String language_direction="";
			int count=0;
			stmt=con.createStatement() ;
			//preparedStatement pstmt1 = con.prepareStatement( "select count(*) as total from sm_language where language_direction='R' and eff_status='E'" ) ;
			
		   rs = stmt.executeQuery("select count(*) as total from sm_language where language_direction='R' and eff_status='E' and LANGUAGE_ID='"+locale+"'" ) ;
				 
			 if ( rs != null && rs.next() ) 
			 {
			 count = rs.getInt("total");
			 }

			if ( count==1 ) 
			{
				 language_direction = "RTL" ;
			}else
			{
				 language_direction = "LTR" ;
			}
			
			if(rs!=null)rs.close();
			/*Added Above Line code for [AK-SCF-0153] by Senthil */
%>

<BODY onload="LoadRecordButton();document.forms[0].expecteddischargedate.focus();disableFields();<%if(isHeightAndBmiEnable){%>calculateBmi('<%=bmi%>')<%}%>" onMouseDown="CodeArrest()" onKeyDown="lockKey();setShift();">
<form name='dischargeadvice_form' id='dischargeadvice_form' action='../../servlet/eIP.DischargeAdviceServlet' method='post' target='messageFrame' onSelect = "lockKey()">
<div id = 'Discharge_Details'>
<!-- <a name="tab1" tabindex='0'></a>   -->
<ul id="tablist" class="tablist">
	<li class="tablistitem" title="Discharge Details">
		<a class="tabClicked" id="discDetails" >
			<span class="tabSpanclicked" id="firstkinspan" onClick='javascript:expandCollapse("Discharge_Details_tab")'><fmt:message key="eIP.DischargeDetails.label" bundle="${ip_labels}"/></span>
		</a>
	</li>
	<li class="tablistitem" title="Other Details">
		<a class="tabA" id="otherDetails" >
			<span class="tabAspan" id="firstkin1span" onClick='javascript:expandCollapse("Other_Details_tab")'><fmt:message key="Common.otherDetails.label" bundle="${common_labels}"/></span>
		</a>
	</li>
</ul>
	<table border='0' id='other_table' cellpadding='2' cellspacing='0' width='100%' >
		<input type='hidden' name='encounterID' id='encounterID' value="<%=encounterID%>">
		<input type='hidden' name='nursingunitcode' id='nursingunitcode' value="<%=nursingunitcode%>">
		<input type='hidden' name='bedno' id='bedno' value="<%=bedno%>">
		<input type='hidden' name='roomno' id='roomno' value="<%=roomno%>">	 
		<input type='hidden' name='admissiondatetime' id='admissiondatetime' value="<%=admissiondatetime%>">
		<input type='hidden' name='admissiondatedisplay' id='admissiondatedisplay' value="<%=admissiondatedisplay%>">
		<input type="hidden" name="system_date_time" id="system_date_time" value="<%=system_date_time%>" >
		<tr>
			<td class='label' width='25%'><fmt:message key="Common.AuthorizingPractitioner.label" bundle="${common_labels}"/></td><td class='fields' width='25%'><input type='hidden' name='practid' id='practid' value="<%=practitioner_id%>" ><input type='text' name='auth_pract_desc' id='auth_pract_desc'   value="<%=practitionername%>" size='30' maxlength='30' onChange="getPractitionerLocal(practid,auth_pract_desc, '<%=facilityID%>');" onkeydown="shift_tab();" tabindex = '1'><input type='button' name='pract_id_search' id='pract_id_search' value='?' class='button' onClick="getPractitionerLocal(practid,auth_pract_desc, '<%=facilityID%>');" onkeydown="shift_tab();" tabindex = '2'><img src='../../eCommon/images/mandatory.gif'align='center'></img>
			</td>
			<td class='label' width='25%'><fmt:message key="eIP.ExpectedDischargeDateTime.label" bundle="${ip_labels}"/></td>
			<td class='fields' width='25%'><input type='text' name='expecteddischargedate' id='expecteddischargedate'  onKeyPress='return(ChkNumberInput1(this,event,2));'  value="<%=exp_date_display%>" size='15' maxlength='16' onblur="DateValidations(this);compare_death_exptDisch();" onkeydown="shift_tab();" tabindex = '3'><img src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].expecteddischargedate.select();return showCalendar('expecteddischargedate',null,'hh:mm');" id="calendrGif" tabindex = '4'><img src='../../eCommon/images/mandatory.gif'align='center' ></img>
			</td>
		</tr>
	</table>
	<table border='0' cellpadding='2' cellspacing='0' width='100%' >
	<tr> 
	<td class='label' width='25%'><fmt:message key="Common.dischargetype.label" bundle="${common_labels}"/></td><td class='fields' width='20%'><SELECT name='dischargetype' id='dischargetype' onchange="callValidate(this.value);" tabindex = '5' dir='<%=language_direction%>'><option value='' selected>-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----
<%/*"dir" Added Above Line code for [AK-SCF-0153] by Senthil */

			StringBuffer dischgtype_Sql	=new StringBuffer();
		dischgtype_Sql.append("SELECT deceased_yn, discharge_type_code||'='||indicator  discharge_type_code , short_desc from "); 
		dischgtype_Sql.append(" IP_DISCHARGE_TYPE_LANG_VW where language_id = '"+locale+"' and eff_status='E' ");

		if(pat_dtls_unknown_yn.equals("Y"))
			dischgtype_Sql.append(" and ( indicator in('DS','ED') ");
		else if(!patient_status.equals("3") && !patient_status.equals("4") && leave_exp_dt_flag.equals("Y"))
			dischgtype_Sql.append(" and ( indicator in('AB','AO','DS') ");
		else if(patient_status.equals("1") && leave_exp_dt_flag.equals("Y"))
			dischgtype_Sql.append(" and ( indicator in('AB','AO') ");
		else if(patient_status.equals("1") && leave_exp_dt_flag.equals("N"))
			dischgtype_Sql.append(" and ( indicator not in('NS','LE') ");
		else if(patient_status.equals("3"))
			dischgtype_Sql.append(" and ( indicator in('AB','AO','DS') ");
		else if(patient_status.equals("4"))
			dischgtype_Sql.append(" and ( indicator in('AB','AO','DS') ");
		else
			dischgtype_Sql.append(" and ( indicator not in('NS','LE') ");

		if(gender.equals("F")) // gender specific indicators..
		{		
			if((patient_age >= mother_cut_off_age)&&(patient_age <= mother_max_age))
			{
				dischgtype_Sql.append(" or maternal_death_yn = 'Y' ) ");
			}
			else
			{
				dischgtype_Sql.append(" and maternal_death_yn = 'N' ) ");
			}
		}
		else
		{
			dischgtype_Sql.append(" and maternal_death_yn = 'N' ) ");
		}
		
			dischgtype_Sql.append(" order by short_desc");
		String disCode="";
		String disDesc="";	
     	
		rs= stmt.executeQuery(dischgtype_Sql.toString());
		if(rs!= null)
		{
			while(rs.next())
			{
				disCode = checkForNull(rs.getString("discharge_type_code"));
				disDesc = checkForNull(rs.getString("short_desc"));
		%>
				<OPTION VALUE = "<%=disCode%>" ><%=disDesc%></OPTION>
		<%	}
		}
		if (rs!=null) rs.close();
%>
	</SELECT><img src='../../eCommon/images/mandatory.gif' align = 'center'></img>
	<input type='hidden' name='discharge_code' id='discharge_code' value= ""  >
	<input type='hidden' name='dischage_indicator' id='dischage_indicator' value= ""  >
	</td>
<!-- modified on 2/07/2008 for SCR 3228 -->

	<!-- Added by KAMATCHI S for ML-MMOH-CRF-1527 ON 23-JUN-2020-->
	<%if(isHeightAndBmiEnable){%>
	<td class= 'label' id='dislabel' nowrap>
	<td class='fields' width='3%' nowrap>
	<input type="text" name="discharge_to"  id='distext' style='display:none' OnBlur='ChangeUpperCase(this);if(this.value != "") searchCode(discharge_to_value,this);'><input type='button' align='left' name='discharge_to_value' id='disbtn' style='display:none' value='?' class='button' onClick='searchCode(this,discharge_to)'>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</td>
	<%}%>
	<!-- Added by KAMATCHI S for ML-MMOH-CRF-1527 ON 23-JUN-2020-->

<%/*"dir" Added Above Line code for this SCF[AK-SCF-0153]*/%>
	<td class='label' width='12%' nowrap><fmt:message key="eIP.DischargeStatus.label" bundle="${ip_labels}"/></td><td class='fields' width='20%' ><SELECT name='dischargestatus' id='dischargestatus' onchange='capt_value(this)' tabindex = '6' ><option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---
	
	</SELECT><img src='../../eCommon/images/mandatory.gif' align = 'center'></img>
	<input type='hidden' name='discharge_status' id='discharge_status' value= ""  >
	<input type='hidden' name='dischage_status_indicator' id='dischage_status_indicator' value= ""  >
	
	<td class='label' id='deathlable' nowrap></td>
	<td class='fields'><input type='text' name='death_date' id="death_id" style='visibility:hidden' disabled onKeyPress='return(ChkNumberInput1(this,event,2));' size='15' maxlength='16' onblur="validateDateTimes(this,'A');dayCareDateCheck(this);compare_death_exptDisch();" tabindex = '7'><img name="calImage1" src="../../eCommon/images/CommonCalendar.gif" id='selcalimg'  style='visibility:hidden' onClick="calender();" tabindex = '8'/><img id="deathimg"align='center' src='../../eCommon/images/mandatory.gif'>
	<!--above one line is modified by venkatesh.s on 09/Aug/2012 against SS-SCF-0674 [IN:034278]-->
	<%if(isDeathRegisterFormAppl && enable_death_reg_form.equals("Y")){ %>
		<a href="javascript:getDeathRegFormAccessionNum('<%=patient_Id%>','<%=encounterID%>','','<%=admissiondatetime%>','<%=patient_class%>','<%=spltycode%>','','<%=death_reg_form_accession_num%>','IP');" id='deathRegFormLink'  style='visibility:hidden'><fmt:message key="Common.DeathRegForm.label" bundle="${common_labels}"/></a>
	<%}%>

</td>
</tr>

<!--Added by Ashwini on 07-Mar-2018 for GHL-CRF-0505-->
<%if(isAadharCardAndRelAppl && citizen_yn.equals("Y") && (!("").equals(alt_id4_type))){
	
	String aadhar_card_en_dis = "";

	if(!aadhar_card_no.equals("")) {
		aadhar_card_en_dis = "disabled";
	}
%>
<tbody id='AadharCardAndRel' style='display:none'>
	<tr>
		<td class='label'><%=alt_id4_type_desc%></td>
		<td class='fields'><input type='text' name='aadhar_card' id='aadhar_card' size='20' maxlength='<%=alt_id4_length%>' value='<%=aadhar_card_no%>' onKeyPress='return SpecialCharRestriction(event)' onBlur='fnChkAlphaNumericForAadharCard(this,"<%=alt_id4_alphanum_yn%>");makeValidString(this);checkUniqueForAadharCard(this);' <%=aadhar_card_en_dis%>><img align='center' src='../../eCommon/images/mandatory.gif'></td>

		<td class='label'><fmt:message key="Common.relationship.label" bundle="${common_labels}"/></td>
		<td class='fields'>
			<select name="relationship" id="relationship">
				<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
				<option value="1"><fmt:message key="Common.self.label" bundle="${common_labels}"/></option>
				<option value="2"><fmt:message key="Common.Attendant.label" bundle="${common_labels}"/></option>
				<option value="3"><fmt:message key="Common.Spouse.label" bundle="${common_labels}"/></option>
			</select>
			<img src='../../eCommon/images/mandatory.gif'align='center'></img>
		</td>
	</tr>
</tbody>

<%}%>
<!--End GHL-CRF-0505-->

</table>

<table border='0' cellpadding='2' cellspacing='0' width='100%' >
	<tr>
		<td class='label' width='25%'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
		<td class='fields'><textarea NAME="remarks" ROWS="3" COLS="70" maxlength='200' onBlur="checkForMaximum(this.value);" tabindex = '9' style="resize: none;"></textarea>
		</td>
		<td class='label' id='postmortlable'></td>
	<td class='fields'><input type='checkbox' style='visibility:hidden' id='post_check' name='post_mortem_request' id='post_mortem_request' value= "Y"></td>
	<input type='hidden' name='dischgsumsigned' id='dischgsumsigned' value= "N"  >

<div style='position:relative;dispaly:none'>
</div>
	</tr>
</table>


<table border='0' cellpadding='2' cellspacing='0' width='100%' >
<!-- below line(s) modified by VenkateshS against ML-MMOH-CRF-0354 [IN057191] -->
<%if(siteSpecific){%>
<td colspan='6' class='COLUMNHEADER'><fmt:message key="Common.MedicalLegalCase.label" bundle="${common_labels}"/> <fmt:message key="Common.details.label" bundle="${common_labels}"/></td>
<tr>
<td class='label' width='25%'><fmt:message key="Common.MedicalLegalCase.label" bundle="${common_labels}"/></td>
<%}else{%>
<td colspan='6' class='COLUMNHEADER'><fmt:message key="Common.mlcdetails.label" bundle="${common_labels}"/></td>
<tr>
<td class='label' width='25%'><fmt:message key="Common.mlc.label" bundle="${common_labels}"/></td>
<%}%>
<!--end ML-MMOH-CRF-0354 [IN057191 -->
<td  class='fields'><INPUT TYPE="checkbox" name="medico_legal" id="medico_legal" value="Y" <%=chck_val%>  onClick="getMedicoValues(this);enablePolice(this);" onBlur='focusNext();' tabindex = '10' ><input type='hidden' name='dischgsumsigned' id='dischgsumsigned' value= "N" ></td>
</tr>

</table>
<table border='0' cellpadding='2' cellspacing='0' width='100%' >
	<tr height='1'>
		<td width='25%'> </td>
		<td width='25%'> </td>
		<td width='25%'> </td>
		<td width='25%'> </td>
</tr>
<tr>
	<td class='label' ><fmt:message key="Common.PoliceReportNo.label" bundle="${common_labels}"/></td>
	<td class='fields' width='' colspan='3'><INPUT TYPE='text' name='pol_rep_no' id='pol_rep_no' value= "" size='20' maxlength='30' tabindex = '11'>
	</td>
</tr>
<tr>
	<td class='label' width=''><fmt:message key="Common.station.label" bundle="${common_labels}"/></td>
	<td class='fields' width=''><INPUT TYPE='text' name='pol_stn_id' id='pol_stn_id' value="" size='20' maxlength='30' tabindex = '12'>
	</td>
	<td class='label'><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
	<td class='fields'><INPUT TYPE='text' name='pol_id' id='pol_id' onblur="focusNext()" value="" size='20' maxlength='30' tabindex = '13'>
	</td>
</tr>
</table>


<table border='0' cellpadding='2' cellspacing='0' width='100%' >
<tr><td class='COLUMNHEADER'><fmt:message key="eIP.InformedDetails.label" bundle="${ip_labels}"/></td></tr>
</table>

<jsp:include page="../../eIP/jsp/InformedDetails.jsp" flush="true">
	<jsp:param name="patient_id" value="" />
	<jsp:param name="called_from" value="Discharge_Advice" />
	<jsp:param name="informed_to" value="<%=informed_to%>" />
	<jsp:param name="informed_name" value="<%=informed_name%>" />
	<jsp:param name="informed_date_time" value="<%=informed_date%>"/>
	<jsp:param name="admissiondatetime" value="<%=admissiondatetime%>"/>
	<jsp:param name="encounterID" value="<%=encounterID%>" />
	<jsp:param name="system_date_time" value="<%=system_date_time%>"/>
</jsp:include>

<div id = 'ab_details' style="visibility:hidden">
<table border='0' cellpadding='2' cellspacing='0' width='100%' >
<tr><td colspan='4' class='COLUMNHEADER' ><fmt:message key="eIP.AbscondingDetails.label" bundle="${ip_labels}"/></td></tr>
</table>

<jsp:include page="../../eIP/jsp/AbscondingDetails.jsp" flush="true">
	<jsp:param name="call_function" value="Discharge_Advice"/>
	<jsp:param name="absconded_date" value="<%=absdate%>"/>
	<jsp:param name="reported_to" value="<%=reported_to%>"/>
</jsp:include>
</div>

<%	
int size = 0;
HashMap data_map		 = new HashMap();
HashMap result_map    = new HashMap();
HashMap records_map =null;
/*Commented On 5/5/2010 for PE 
	The same tables are getting called twice one for count and data.
*/
//String sql_adap_cnt = "select count(*) from SM_QUICK_LINK_ADPT_MNU_DTL a,SM_QUICK_LINK_ADPT_MNU b where a.L_ADPT_FUNCTION_REF=b.ADPT_FUNCTION_REF AND A.S_ADPT_FUNCTION_REF='IP_PRE_DIS_ADVICE' AND a.EFF_STATUS='E' ORDER BY A.DISPLAY_ORDER ";
 sql_adap="select a.L_ADPT_FUNCTION_REF,b.ADPT_FUNCTION_NAME,b.ADPT_EXECUTABLE_NAME from SM_QUICK_LINK_ADPT_MNU_DTL a,SM_QUICK_LINK_ADPT_MNU b where a.L_ADPT_FUNCTION_REF=b.ADPT_FUNCTION_REF AND A.S_ADPT_FUNCTION_REF='IP_PRE_DIS_ADVICE' AND a.EFF_STATUS='E' ORDER BY A.DISPLAY_ORDER desc";
 rs= stmt.executeQuery(sql_adap);
 int key=0;
while(rs.next()){
	records_map =new HashMap();
	String adpt_function_ref		= rs.getString(1);
	String adpt_function_name	 = rs.getString(2);
	String adpt_executable_name= rs.getString(3);
	records_map.put("L_ADPT_FUNCTION_REF",adpt_function_ref);
	records_map.put("ADPT_FUNCTION_NAME",adpt_function_name);
	records_map.put("ADPT_EXECUTABLE_NAME",adpt_executable_name);
	data_map.put(key,records_map);
	key++;
}
if(rs != null) rs.close ();
size = data_map.size();

//Modified by Ashwini on 02-Jul-2018 for ML-MMOH-CRF-1047
int top=5;
/*
int top=0;
if(is_ca_yn  == "Y" || is_ca_yn.equals("Y")){
	top=350;
}else{
	top=360;
}
if(size>2){
	for(int j=3;j<=size;j++){
		top=top-20;
	}
}*/
 /*sql_adap="select a.L_ADPT_FUNCTION_REF,b.ADPT_FUNCTION_NAME,b.ADPT_EXECUTABLE_NAME from SM_QUICK_LINK_ADPT_MNU_DTL a,SM_QUICK_LINK_ADPT_MNU b where a.L_ADPT_FUNCTION_REF=b.ADPT_FUNCTION_REF AND A.S_ADPT_FUNCTION_REF='IP_PRE_DIS_ADVICE' AND a.EFF_STATUS='E' ORDER BY A.DISPLAY_ORDER desc";
 rs= stmt.executeQuery(sql_adap);*/
%>
<!-- To Freeze  Above Form elements <div id="TestDiv"> used and Display the Adaptive Menu <div id=TestDiv1> uesed -->
<div  id='TestDiv'  style="visibility:hidden;z-index:5;position:absolute;top:0px;width:100vw;height:600px;background-color:#CCCCCC;filter:alpha(opacity=80);" >
	<!-- Construction Of Adaptive Menu Starts  -->

	<!--<div  id='TestDiv1' style=" z-index:2;position:absolute;top:<%=top%>px;left:750px;width:190px;height:40px;visibility:hidden;filter:alpha(opacity=100);" >
	
	<table width='100%' height='100%' style="background-color:black" style="padding: 5px;">	-->

	<!--Modified by Ashwini on 02-Jul-2018 for ML-MMOH-CRF-1047-->
	<div  id='TestDiv1' style=" z-index:2;position:absolute;top:<%=top%>px;left:400px;width:250px;height:100px;visibility:hidden;filter:alpha(opacity=100);border-style:solid;border-color:#5f5f5f;border-width:1px;">	

		<table width='100%' height='100%' style="background-color:#FFFFFF" style="padding:5px;">		
		<%		
			int i=0;	
			String bg_color="";
				for(int kk=0;kk<data_map.size();kk++){
					maxrecord++;
					record_exists=true;
					result_map=(HashMap)data_map.get(kk);
					adap_func_ref		= (String)result_map.get("L_ADPT_FUNCTION_REF");
					adap_func_name	= (String)result_map.get("ADPT_FUNCTION_NAME");
					adap_exec_name	= (String)result_map.get("ADPT_EXECUTABLE_NAME");
					if(i==size-1){
						//Modified by Ashwini on 02-Jul-2018 for ML-MMOH-CRF-1047
						//bg_color="background-color:#595959";
						bg_color="background-color:#ebebeb";
					}
					%>
					<tr>				
						<td id="TD<%=i%>" style="<%=bg_color%>" >
							&nbsp;&nbsp;&nbsp;<img src='../../eCommon/images/tree_handlerightmiddle.gif' align='center'></img>&nbsp;&nbsp;<a href="javascript:ShowWindow('<%=encounterID%>','<%=patient_Id%>','<%=adap_func_ref%>','<%=adap_exec_name%>');" id='linkID<%=i%>' name="Regstr" onkeydown="NextItem('<%=i%>');" onmouseover="MouseClick('<%=i%>')"  style='cursor:pointer' > <font color="#000000"><%=adap_func_name%></font></a>
						</td>				
					</tr>
					<% i++;
				}
		%>
		</table>
	</div>
</div>
<input type='hidden' name="max_record" id="max_record" value="<%=maxrecord%>">
<input type='hidden' name="record_exists" id="record_exists" value="<%=record_exists%>">
<input type='hidden' name="top" id="top" value="<%=top%>">
<input type='hidden' name="size" id="size" value="<%=size%>">
<!-- 	<div  id='TestDiv1' style=" z-index:2;position:absolute;top:320px;left:750px;width:190px;visibility:hidden;filter:alpha(opacity=100);" >
		<table width='100%' style="background-color:#25383C" style="padding: 5px;">
			
			<tr><td id="Td1" style="background-color:#595959" ><a href="javascript:RegisterMoreReferral('encounterID','patient_Id');" id='linkID' name="Regstr" onkeydown="NextItem(this);" onmouseover="MouseClick(this)"  style='cursor:pointer' ><font color="white">Register Refferal</font></a></td></tr>
			<tr><td id="Td2" ><a href="#" style='cursor:pointer'  id='linkID1' name="Order" onkeydown="NextItem(this);" onkeyup="PrevItem(this);" onmouseover="MouseClick(this)" ><font color="white">Place Orders</font></a></td></tr>
			<tr><td id="Td3" ><a href="#" id='linkID2' name="RcrdDiag" onkeyup='PrevItem(this);' onmouseover="MouseClick(this)" style='cursor:pointer' ><font color="white">Record Diagnosis</font></a></td></tr>
		</table>
	</div> -->

<!-- 					<ul style="margin: 0; padding: 0; list-style-type: none; list-style-image: none; ">
						<li style="padding: 5px;"><font color='blue'><a href="" id='linkID' name="Regstr" onkeydown="NextItem(this);" >Register Refferal</a></font></li>
						<li  style="padding: 5px;"><font color='blue'><a href="" id='linkID1' name="Order" onkeydown="NextItem(this);"  onkeyup="PrevItem(this);">Place Orders</a></font></li>
						<li  style="padding: 5px;"><font color='blue'><a href="" id='linkID2' name="RcrdDiag" onkeyup='PrevItem(this);'>Record Diagnosis</a></font></li>
					</ul> -->
<!-- 					<img src="C:\Documents and Settings\chiranjeevic\Desktop\MenuIcon.gif"/>
 -->		
 </div>
<!-- <BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>
<BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR> -->
 <!-- <a name="tab2" tabindex='0' ></a> -->
<!--<table width='100%' cellpadding='0' cellspacing='0' BORDER='0'>
	<tr>
		<td width='50%' class='BODYCOLORFILLED'><a align='left' href="javascript:tab_click('other_details')" tabindex='-1'><img  src="../../eIP/images/Discharge_click.gif" border=0></a><a align='left' href="javascript:tab_click('others_details')"><img  src="../../eIP/images/Other Details_click.gif" border=0></a></td>
	</tr>
</table>	 --> 
<div id = 'Other_Details' style = 'display:none'>
<ul id="tablist" class="tablist">
	<li class="tablistitem" title="Discharge Details">
		<a class="tabA" id="discDetails1" >
			<span class="tabASpan" id="firstkinspan"  onClick='javascript:expandCollapse("Discharge_Details_tab")'><fmt:message key="eIP.DischargeDetails.label" bundle="${ip_labels}"/></span>
		</a>
	</li>
	<li class="tablistitem" title="Other Details">
		<a class="tabClicked" id="otherDetails1" >
			<span class="tabSpanclicked" id="firstkin1span"  onClick='javascript:expandCollapse("Other_Details_tab")'><fmt:message key="Common.otherDetails.label" bundle="${common_labels}"/></span>
		</a>
	</li>
</ul>

<!-- <BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>
<BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>

<a name="tab3" tabindex='0' ></a>

<ul id="tablist" class="tablist">
	<li class="tablistitem" title="Discharge Details">
		<a class="tabA" id="discDetails" >
			<span class="tabAspan" id="firstkinspan"><fmt:message key="eIP.DischargeDetails.label" bundle="${ip_labels}"/></span>
		</a>
	</li>
	<li class="tablistitem" title="Other Details">
		<a class="tabClicked" id="otherDetails" >
			<span class="tabSpanclicked" id="firstkin1span"><fmt:message key="Common.otherDetails.label" bundle="${common_labels}"/></span>
		</a>
	</li>
</ul> -->
<jsp:include page="../../eIP/jsp/AddModifyDischargeAdvTabs1.jsp" flush="true" ></jsp:include>
</div>

<!-- <BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>
<BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR> -->
<%
	if(setup_bl_dtls_in_ip_yn.equals("Y"))
		out.println("<Script>if(document.getElementById('bl_field')){document.getElementById('bl_field').style.visibility='visible';}</Script>");

	if(stmt	!=	null) stmt.close();
	if(rs!= null) rs.close();

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
	<!-- By Annadurai 11/5/2004  - for DC identification Starts-->
	<input type='hidden' name='dead_yndt' id='dead_yndt' value="<%=dead_yn%>">
	<input type="hidden" name="patient_class_value" id="patient_class_value" value="<%=patient_class%>" >
	<input type="hidden" name="target_date" id="target_date" value="<%=target_date%>" >
	<input type="hidden" name="max_disch_period_for_dc" id="max_disch_period_for_dc" value="<%=max_disch_period_for_dc%>" >
	<!-- By Annadurai 11/5/2004  - for DC identification End-->
	<input type='hidden' name='currdate' id='currdate' value="<%=Sdate%>">
	<input type='hidden' name='dis_date_chk_days' id='dis_date_chk_days' value="<%=dis_date_chk_days%>">
	<input type="hidden" name="SickLeaveRecordFlag" id="SickLeaveRecordFlag" value="N">
	<input type="hidden" name="SickLeaveDetails" id="SickLeaveDetails" value="">
	<input type="hidden" name="SickLeaveDetails1" id="SickLeaveDetails1" value="">
	<input type='hidden' name='setup_bl_dtls_in_ip_yn' id='setup_bl_dtls_in_ip_yn' value="<%=setup_bl_dtls_in_ip_yn%>">
	<input type='hidden' name='patient_id' id='patient_id' value="<%=patient_Id%>">
	<input type='hidden' name='is_ca_yn' id='is_ca_yn' value="<%=is_ca_yn%>">
	<input type='hidden' name='SplCode' id='SplCode' value="<%=spltycode%>">
	<input type='hidden' name='close_val' id='close_val' value="N">
	<input type='hidden' name='patient_status' id='patient_status' value="<%=patient_status%>">
	<input type='hidden' name='absdate' id='absdate' value="<%=absdate%>">
	<input type='hidden' name='locale1' id='locale1' value="<%=locale%>">
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">

	<input type='hidden' name='check_death_date' id='check_death_date' value="">
	<input type="hidden" name="hcare_setting_type_desc" id="hcare_setting_type_desc"  value ='' >
	<input type="hidden" name="open_to_all_pract_yn" id="open_to_all_pract_yn" value="">
	<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounterID%>">
	<input type="hidden" name="practitioner_id" id="practitioner_id" value="<%=practitioner_id%>">
	<input type="hidden" name="practitioner_type" id="practitioner_type" value="<%=login_pract_type%>">
	<input type="hidden" name="curdateWithoutTime" id="curdateWithoutTime" value="<%=Sdate%>">
	<input type='hidden' name='help_function_id' id='help_function_id' value='PREP_DISCH_ADVICE'>
	<input type='hidden' name="pat_dtls_unknown_yn" id="pat_dtls_unknown_yn" value="<%=pat_dtls_unknown_yn%>">
	<input type='hidden' name="gender" id="gender" value="<%=gender%>">
	<input type='hidden' name="DOB" id="DOB" value="<%=DOB%>">
	<input type='hidden' name='contact1_name' id='contact1_name' value='<%=contact1_name%>'>
	<input type='hidden' name='contact2_name' id='contact2_name' value='<%=contact2_name%>'>
	<input type='hidden' name="valid" id="valid" value="<%=valid%>">
	<input type='hidden' name="from_time" id="from_time" value="<%=from_time%>">
	<input type='hidden' name="max_param_date" id="max_param_date" value="<%=max_param_date%>">
	<input type='hidden' name="valid_date" id="valid_date" value="<%=valid_date%>">
	<input type='hidden' name="ip_Trn_Date" id="ip_Trn_Date" value="<%=ip_Trn_Date%>">
	<input type='hidden' name="proceed" id="proceed" value="Y">
	<input type='hidden' name="query_string" id="query_string" value="<%=query_string%>">
	<input type='hidden' name="practitionername" id="practitionername" value="<%=practitionername%>">
	<input type='hidden' name="bl_interfaced_yn" id="bl_interfaced_yn" value="<%=bl_interfaced_yn%>">
	<input type='hidden' name="bl_operational" id="bl_operational" value="<%=bl_operational%>">
	<input type='hidden' name="function_id" id="function_id" value="<%=function_id%>">
	<input type="hidden" name="pol_rep_no_db" id="pol_rep_no_db" value="<%=pol_rep_no%>">
	<input type="hidden" name="pol_stn_id_db" id="pol_stn_id_db" value="<%=pol_stn_id%>">
	<input type="hidden" name="pol_id_db" id="pol_id_db" value="<%=pol_id%>">
	<input type="hidden" name="modified_date_val" id="modified_date_val" value="<%=modified_date_val%>">
	<!-- Added by Dharma on Oct 29th against HSA-CRF-0181 [IN:049541] Start -->
	<input type="hidden" name="weight_on_admission" id="weight_on_admission" value="">
	<input type="hidden" name="weight_on_admission_unit" id="weight_on_admission_unit" value="">
	<!-- Added by Dharma on Oct 29th against HSA-CRF-0181 [IN:049541] End -->

	<!-- Added by KAMATCHI S on 23-JUN-2020 fro ML-MMOH-CRF-1527 -->
	<input type="hidden" name="height_on_admission" id="height_on_admission" value="">
	<input type="hidden" name="height_on_admission_unit" id="height_on_admission_unit" value="">
	<input type="hidden" name="bmi" id="bmi" value=""> 
	<input type="hidden" name="isHeightAndBmiEnable" id="isHeightAndBmiEnable" value="<%=isHeightAndBmiEnable%>">
	<!-- Added by KAMATCHI S on 23-JUN-2020 fro ML-MMOH-CRF-1527 End -->


	<!--Added by Ashwini on 07-Mar-2018 for GHL-CRF-0505-->
	<input type="hidden" name="isAadharCardAndRelAppl" id="isAadharCardAndRelAppl" value="<%=isAadharCardAndRelAppl%>">
	<input type="hidden" name="citizen_yn" id="citizen_yn" value="<%=citizen_yn%>">
	<input type="hidden" name="alt_id4_type_desc" id="alt_id4_type_desc" value="<%=alt_id4_type_desc%>">
	<input type="hidden" name="alt_id4_type" id="alt_id4_type" value="<%=alt_id4_type%>">
	<!-- Added by Ajay Hatwate for AAKH-CRF-0179 on 08-08-2023  -->
	<input type="hidden" name="isDeathRegisterFormAppl" id="isDeathRegisterFormAppl" value="<%=isDeathRegisterFormAppl%>">
	<input type="hidden" name="enable_death_reg_form" id="enable_death_reg_form" value="<%=enable_death_reg_form%>">
	<input type="hidden" name="death_reg_form_accession_num" id="death_reg_form_accession_num" value="<%=death_reg_form_accession_num%>">
	<input type ='hidden' name= 'callback_mode' value="Add">
	<!--End GHL-CRF-0505-->
	<!--Added by Kamatchi s for ML-MMOH-SCF-1643-->
			<input type='hidden' name='weight_on_admission_load' id='weight_on_admission_load' value=''>
			<input type='hidden' name='height_on_admission_load' id='height_on_admission_load' value=''>
			<input type='hidden' name='bmi_load' id='bmi_load' value=''>
	
	<script>document.forms[0].absconding_rep_to.value="<%=reported_to%>";</script>

<%	if(bedno.equals(""))
	{	%>
		<script>
			alert(getMessage('BED_NOT_ASSIGNED','IP'));
			if(document.forms[0].is_ca_yn.value == "Y")
			{
				document.location.href='../../eCommon/html/blank.html';parent.frames[2].document.location.href='../../eCommon/html/blank.html';parent.frames[1].document.location.href = '../../eCommon/html/blank.html';parent.frames[3].document.location.href = '../../eCommon/html/blank.html';
			}
			else
			{
				parent.window.close(); 
			}
		</script>
<%	}	%>


</form>

</BODY>
</HTML>

<%	
	/// Added by Sridhar R on 4/25/2005 - will validate MLC details based on values fetched from ip_open_encounter table...
	if(mlc_yn.equals("Y"))
	{	%>
		<script>
			document.forms[0].medico_legal.checked	=	true;
			document.forms[0].medico_legal.value	=	"Y";
			document.forms[0].medico_legal.disabled	=	true;
		</script>
<%	}

	if(disabled_yn.equals("Y"))
	{
		if(!pol_rep_no_vw.equals("") || !pol_stn_id_vw.equals("") || !pol_id_vw.equals(""))
		{	
			%>
			<script>
				document.forms[0].pol_rep_no.disabled	=	true;
				document.forms[0].pol_stn_id.disabled	=	true;
				document.forms[0].pol_id.disabled		=	true;
			</script>
<%		}
	}
%>
	<script>
		if(document.forms[0].medico_legal.checked == false)
		{
			
			document.forms[0].pol_rep_no.disabled	=	true;
			document.forms[0].pol_stn_id.disabled	=	true;
			document.forms[0].pol_id.disabled		=	true;
		}
	// End of addition on 4/25/2005 by Sridhar R ...
	</script>

<%	

	if(patient_status.equals("4"))
	{	%>
		<script>
			document.forms[0].absconding_yn.checked	= true;
			document.forms[0].absconding_yn.disabled	= true;
			document.forms[0].absconding_yn.value	= 'Y';
			document.getElementById("AbsImg").style.visibility = "Visible";
			document.forms[0].absconding_date.disabled= true;
			document.getElementById("calImage").disabled		= true;
		    document.forms[0].absconding_rep_to.disabled	= true;
		</script>
<%	}	

	if(patient_status.equals("3"))
	{	%>
		<script>
			document.forms[0].absconding_yn.checked	= false;
			document.forms[0].absconding_yn.disabled	= true;
			document.forms[0].absconding_yn.value		= '';
			document.forms[0].absconding_date.disabled	= true;
			document.forms[0].absconding_date.value		= '';
			document.getElementById("AbsImg").style.visibility		= "hidden";
			document.getElementById("calImage").disabled				= true;
			document.forms[0].absconding_rep_to.disabled		= true;
			document.forms[0].absconding_rep_to.value			= '';
		</script>
<%	}
		

	if(patient_status.equals("3") || patient_status.equals("4"))
	{	%>
		<script>
			document.dischargeadvice_form.newmedicine.checked=false;
			document.dischargeadvice_form.newmedicine.disabled=true;
			document.dischargeadvice_form.stockmedicine.checked=false;
			document.dischargeadvice_form.stockmedicine.disabled=true;
			document.dischargeadvice_form.lab.checked=false;
			document.dischargeadvice_form.lab.disabled=true;
			document.dischargeadvice_form.xray.checked=false;
			document.dischargeadvice_form.xray.disabled=true;
			document.dischargeadvice_form.scan.checked=false;
			document.dischargeadvice_form.scan.disabled=true;
			document.dischargeadvice_form.ultrasound.checked=false;
			document.dischargeadvice_form.ultrasound.disabled=true;
			document.dischargeadvice_form.mri.checked=false;
			document.dischargeadvice_form.mri.disabled=true;
			document.dischargeadvice_form.rt.checked=false;
			document.dischargeadvice_form.rt.disabled=true;
			document.dischargeadvice_form.physio.checked=false;
			document.dischargeadvice_form.physio.disabled=true;
			document.dischargeadvice_form.ecg.checked=false;
			document.dischargeadvice_form.ecg.disabled=true;
			document.dischargeadvice_form.diet.checked=false;
			document.dischargeadvice_form.diet.disabled=true;
			document.dischargeadvice_form.pharmacy.disabled=true;
		</script>
		
<%	}	
	out.println("<script>document.forms[0].absconding_date.disabled= true;</script>");
%>


<%!
// By Annadurai 12/5/2004  - To handle NullPointerException
public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null"))) ? "" : inputString);
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
}
%>

