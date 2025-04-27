<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,com.ehis.util.*,java.io.*,org.json.simple.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	Connection con	= null;
	Statement stmt 	= null;
	ResultSet rset	= null;
	ResultSet rset1	= null;
	PreparedStatement pstmt = null; //Added by Aajay Hatwate for AAKH-CRF-0179
	
	JSONObject AllowUserModifyDiscJson = new JSONObject(); 
	JSONObject PatDataJson    = new JSONObject();
	String allow_modify_disc_yn = ""; // added by mujafar for ML-MMOH-CRF-0659 END
	
	con				= ConnectionManager.getConnection(request);
	/*Below line(s) added by venkateshs against ML-MMOH-CRF-0354 [IN057191] */
	boolean siteSpecific		=eCommon.Common.CommonBean.isSiteSpecific(con, "MR","MLC_TO_MEDICO_LEGAL_CASE");
	boolean isModifyDiscTypeStatusAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"IP","MODIFY_DISC_TYPE_STATUS_YN"); // added by mujafar for ML-MMOH-CRF-0659
	/*end ML-MMOH-CRF-0354 [IN057191] */
	boolean isHeightAndBmiEnable	= eCommon.Common.CommonBean.isSiteSpecific(con, "MP", "BMI_REG_PAT_CHNGES_RH101");//Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527

	stmt			= con.createStatement();
	String locale					= (String)session.getAttribute("LOCALE");
	String bl_operational			= (String)session.getValue("bl_operational");
	String facilityId				= checkForNull((String)session.getAttribute("facility_id"));
	String locn_code				= checkForNull(request.getParameter("location_code"));
	String eid						= checkForNull(request.getParameter("encounter_id"));
	long encounterid				= Long.parseLong(eid);
	String post_mortem_req_yn		= checkForNull(request.getParameter("post_mortem_req_yn"));
	String to_ref_code				= checkForNull(request.getParameter("to_ref_code"));
	String to_specialty_code		= checkForNull(request.getParameter("to_specialty_code"));
	String to_service_code			= checkForNull(request.getParameter("to_service_code"));
	String to_locn_type				= checkForNull(request.getParameter("to_locn_type"));
	String to_locn_code				= checkForNull(request.getParameter("to_locn_code"));
	String med_lgl_case_yn			= checkForNull(request.getParameter("med_lgl_case_yn"),"N");
	String informed_to				= checkForNull(request.getParameter("informed_to"));
	String informed_date_time		= checkForNull(request.getParameter("informed_date_time")); 
	/*String informed_name			= checkForNull(request.getParameter("informed_name"));
	String pol_rep_no				= checkForNull(request.getParameter("pol_rep_no"));
	String pol_stn_id				= checkForNull(request.getParameter("pol_stn_id"));
	String pol_id					= checkForNull(request.getParameter("pol_id"));
	String discharge_narration		= checkForNull(request.getParameter("discharge_narration"));
	String reported_to				= checkForNull(request.getParameter("reported_to"));
	
	String informed_name			= (String)pageContext.getAttribute("informed_name",pageContext.SESSION_SCOPE);
	String pol_rep_no				= (String)pageContext.getAttribute("pol_rep_no",pageContext.SESSION_SCOPE);
	String pol_stn_id				= (String)pageContext.getAttribute("pol_stn_id",pageContext.SESSION_SCOPE);
	String pol_id					= (String)pageContext.getAttribute("pol_id",pageContext.SESSION_SCOPE);
	String discharge_narration		= (String)pageContext.getAttribute("discharge_narration",pageContext.SESSION_SCOPE);
	String reported_to				= (String)pageContext.getAttribute("reported_to",pageContext.SESSION_SCOPE);

	pageContext.removeAttribute("discharge_narration",pageContext.SESSION_SCOPE);
	pageContext.removeAttribute("reported_to",pageContext.SESSION_SCOPE);
	pageContext.removeAttribute("informed_name",pageContext.SESSION_SCOPE);
	pageContext.removeAttribute("pol_rep_no",pageContext.SESSION_SCOPE);
	pageContext.removeAttribute("pol_stn_id",pageContext.SESSION_SCOPE);
	pageContext.removeAttribute("pol_id",pageContext.SESSION_SCOPE);*/
	/*
	Hashtable hash					= (Hashtable)obj.parseXMLString( request ) ;
	hash							= (Hashtable)hash.get("SEARCH");
	String  function_name			= (String) hash.get("function_name")==null?"":(String) hash.get("function_name") ;
	String  discharge_narration		= (String) hash.get("discharge_narration")==null?"":(String) hash.get("discharge_narration") ;
	String  reported_to				= (String) hash.get("reported_to")==null?"":(String) hash.get("reported_to") ;
	String  informed_name			= (String) hash.get("informed_name")==null?"":(String) hash.get("informed_name") ;
	String  pol_rep_no				= (String) hash.get("pol_rep_no")==null?"":(String) hash.get("pol_rep_no") ;
	String  pol_stn_id				= (String) hash.get("pol_stn_id")==null?"":(String) hash.get("pol_stn_id") ;
	String  pol_id					= (String) hash.get("pol_id")==null?"":(String) hash.get("pol_id") ;*/
	String discharge_narration		= "";
	String reported_to				= "";
	String informed_name			= "";
	String pol_rep_no				= "";
	String pol_stn_id				= "";
	String pol_id					= "";
	
	/* Added by Ajay Hatwate for AAKH-CRF-0179 on 22/08/2023 */
	Boolean isDeathRegisterFormAppl = false;
	String enable_death_reg_form = "N";
	String death_reg_form_accession_num = "";

	isDeathRegisterFormAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "DEATH_REGISTER_FORM_APPL"); //Added by Ajay Hatwate for AAKH-CRF-0179 on 22-08-2023
	if(isDeathRegisterFormAppl){
		enable_death_reg_form	= eMP.MPCommonBean.getEnableDeathRegisterFormYN(con);	

		if(enable_death_reg_form.equals("Y")){
			try{
				pstmt = con.prepareStatement(" SELECT death_reg_form_accession_num FROM PR_ENCOUNTER WHERE FACILITY_ID=? and ENCOUNTER_ID = ?");
				pstmt.setString(1, facilityId);
				pstmt.setString(2, String.valueOf(encounterid));
				rset = pstmt.executeQuery();
				if(rset != null && rset.next()) {
					death_reg_form_accession_num	= checkForNull(rset.getString("death_reg_form_accession_num"));
				}
			if(rset != null) rset.close(); 
			if(pstmt != null) pstmt.close(); 				
			}
			catch(Exception e){
				e.printStackTrace();
		}	
	}
	}
	/* End of AAKH-CRF-0179 */
	try
	{
		rset = stmt.executeQuery("select reported_to,informed_name,pol_rep_no,pol_stn_id,pol_id,discharge_narration from ip_discharge_advice where facility_id = '"+facilityId+"' and encounter_id = '"+encounterid+"' and dis_adv_status = '0'");
		if(rset != null && rset.next()) {
			informed_name			= checkForNull(rset.getString("informed_name"));
			pol_rep_no				= checkForNull(rset.getString("pol_rep_no"));
			pol_stn_id				= checkForNull(rset.getString("pol_stn_id"));
			pol_id					= checkForNull(rset.getString("pol_id"));
			discharge_narration		= checkForNull(rset.getString("discharge_narration"));
			reported_to				= checkForNull(rset.getString("reported_to"));
		}
		if(rset != null) rset.close(); 
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	String admission_date_time		= checkForNull(request.getParameter("admission_date_time"));
	String admission_short_desc		= checkForNull(request.getParameter("admission_short_desc"));
	String specialty_short_desc		= checkForNull(request.getParameter("specialty_short_desc"));
	String practitioner_name		= checkForNull(request.getParameter("practitioner_name"));
	String patient_type_short_desc	= checkForNull(request.getParameter("patient_type_short_desc"));
	String nursing_unit_short_desc	= checkForNull(request.getParameter("nursing_unit_short_desc"));
	String service_short_desc		= checkForNull(request.getParameter("service_short_desc"));
	String bed_no					= checkForNull(request.getParameter("bed_no"));
	String room_no					= checkForNull(request.getParameter("room_no"));
	String bed_class_short_desc		= checkForNull(request.getParameter("bed_class_short_desc"));
	String patient_id				= checkForNull(request.getParameter("patient_id"));
	String bed_type_code			= checkForNull(request.getParameter("bed_type_code"));
	String bed_class_code			= checkForNull(request.getParameter("bed_class_code"));
	String practitioner_id			= checkForNull(request.getParameter("practitioner_id"));
	String specialty_code			= checkForNull(request.getParameter("specialty_code")); 
	String auth_practitioner_id		= checkForNull(request.getParameter("auth_practitioner_id"));

	//String auth_practitioner_name	= checkForNull(request.getParameter("auth_practitioner_name"));
	String auth_practitioner_name	= "";
	String nursing_unit_code		= checkForNull(request.getParameter("nursing_unit_code"));
	String service_code				= checkForNull(request.getParameter("service_code"));
	String patient_type				= checkForNull(request.getParameter("patient_type"));
	String gender					= checkForNull(request.getParameter("gender"));
	String date_of_birth			= checkForNull(request.getParameter("date_of_birth"));
	String locn_type				= checkForNull(request.getParameter("locn_type"));
	String patient_class			= checkForNull(request.getParameter("patient_class"));
	String patient_status			= checkForNull(request.getParameter("patient_status"));

    String daycare_unit_code = checkForNull(request.getParameter("daycare_unit_code")); //Added for this CRF HSA-CRF-0306.1


	String absconded_date			= checkForNull(request.getParameter("absconded_date"));
	String absconded_yn				= checkForNull(request.getParameter("absconded_yn"));
	String EXPECTED_DISCHARGE_DATE	= checkForNull(request.getParameter("EXPECTED_DISCHARGE_DATE"));
	String subservice_code          = checkForNull(request.getParameter("subservice_code"));
	 //added on 3-07-2008 for SCR 3228
	String discharge_status_code= checkForNull(request.getParameter("discharge_status_code"));
	String Type_indicator           = checkForNull(request.getParameter("indicator"));
	//String function_id		   = checkForNull(request.getParameter("function_id"));

	String bl_interfaced_yn			= checkForNull(request.getParameter("bl_interfaced_yn"));
	String dischg_chklst_app_yn		= checkForNull(request.getParameter("discharge_checklist_app_yn"));
	String bed_block_period_dis		= checkForNull(request.getParameter("bed_block_period_dis"));
	String dis_date_chk_days1		= checkForNull(request.getParameter("dis_date_chk_days"));
	String dis_date_chk_days_unit   = checkForNull(request.getParameter("dis_date_chk_days_unit"));
	String diag_update_period_max_unit  = checkForNull(request.getParameter("diag_update_period_max_unit"));
	String max_disch_period_for_predc	= checkForNull(request.getParameter("max_disch_period_for_predc"));
	String deactivate_pseudo_bed_yn = checkForNull(request.getParameter("deactivate_pseudo_bed_yn"));
	String pseudo_bed_yn			= checkForNull(request.getParameter("pseudo_bed_yn"),"N");
	String serverDate				= "";
	//String mr_mds_recorded			= "";//Maheshwaran K commented for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
	String valid					= "";
	String from_time				= "";
	String max_param_date			= "";
	String valid_date				= "";

	int discharge_after_hrs 		= 0;
	int dis_date_chk_days 			= 0;
	int max_disch_period_for_dc		= 0;

	discharge_after_hrs				= Integer.parseInt(bed_block_period_dis);	
	dis_date_chk_days				= Integer.parseInt(dis_date_chk_days1);
	max_disch_period_for_dc			= Integer.parseInt(max_disch_period_for_predc);

	//  added by mujafar for ML-MMOH-CRF-0659 start


	AllowUserModifyDiscJson =  eIP.IPCommonBean.getIPParam(con,facilityId); // added by mujafar for ML-MMOH-CRF-0659
		allow_modify_disc_yn    =   (String)AllowUserModifyDiscJson.get("allow_modify_disc_yn"); 
			String language_direction="";
			int count=0;
			String pat_dtls_unknown_yn	= "N";
			int patient_age = 0;
			stmt=con.createStatement() ;
			
		PatDataJson  = eIP.IPCommonBean.getPatientDetails(con,locale,patient_id); 
		patient_age  = (Integer)PatDataJson.get("patient_age");
		language_direction=(String)PatDataJson.get("language_direction");
	
//	String indicator				= ""; 
	String ip_Trn_Date				= ""; 
	String dis_highrisk				= "";

//Added for  ML-MMOH-CRF-1611 by lakshmanan 
	boolean isDischrgBillStatus	= eCommon.Common.CommonBean.isSiteSpecific(con, "IP", "DISCHARGE_BILL_STATUS");
	String disc_bill_exists			= ""; 
	String bill_genrt				= "";
	CallableStatement cstmt= null;
	Statement stmtbl 	= null;
	String paid_unpaid_status="";
	String check_msg="";
	if (isDischrgBillStatus) {
	try
	{
	stmtbl=con.createStatement();
	ResultSet rsetBL=null;		
	rsetBL = stmtbl.executeQuery(" SELECT BL_IP_DETAILS.GET_DISCHARGE_BILL_EXIST('"+facilityId+"','"+encounterid+"') disc_bill_exists FROM dual ");
	if(rsetBL.next())
	{
	disc_bill_exists = rsetBL.getString("disc_bill_exists");
	if(disc_bill_exists == null) disc_bill_exists = "";
		}
	if(rsetBL!=null) rsetBL.close();
	if(stmtbl != null) stmtbl.close(); 
	} catch (Exception e)
	{
		//out.println(" Exception in addModifyDischargePatientTabs.jsp : "+e);
		e.printStackTrace();
	}
	
	
	try
	{
		cstmt=con.prepareCall("{call BL_PMNT_STATUS(?,?,?,?,?)}");
		cstmt.setString(1,facilityId);// Facility
		cstmt.setString(2,patient_id);// patient_id
		cstmt.setString(3,eid);// encounter_id
		cstmt.registerOutParameter(4,Types.VARCHAR);
		cstmt.registerOutParameter(5,Types.VARCHAR);
		cstmt.execute();
		paid_unpaid_status = 	checkForNull(cstmt.getString(4));
		check_msg = 	checkForNull(cstmt.getString(5));

		cstmt.close();
	}
	catch (Exception e) 
	{
		e.printStackTrace();
	}
	finally 
	{
		try
		{
			if(cstmt!=null) 
				cstmt.close();
		}
		catch(Exception es)
		{
			es.printStackTrace();
		}
	}
	if (disc_bill_exists.equals("Y")){
		bill_genrt="Generated";
	}else {
		bill_genrt="Not Generated";
		paid_unpaid_status="NA";
	}
	}
	// end ML-MMOH-CRF-1611	by lakshmanan

%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<HEAD>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
	<script src='../../eIP/js/DischargePatient.js' language='javascript'></script>
	<script src='../../eIP/js/IPPractitionerComponent.js' language='javascript'></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<script>

function DateValidations(obj) {
	if(document.forms[0].patient_class_value.value == "IP") 	{
		if(checkUntilDate(obj))
			compareServerDate1(obj);
	} else if(document.forms[0].patient_class_value.value == "DC") {
		dayCareDateCheck(obj);
	}
}


function focusNext() {
	//document.getElementById('tab3').focus();         
}

function checkform() {
	checkBabyBed();
<%
	//Validation for Discharge Checklist on loading the page.. 
	String disch_chklist_status		="";
	StringBuffer chk_request =new StringBuffer();	
	if(Type_indicator.equals("DS")) {
%> var error = getMessage('PATIENT_DESEASED','IP');
		alert(error);
<%}	

	if(dischg_chklst_app_yn.equals("Y")) {
		chk_request.delete(0, chk_request.length());
		chk_request.append("select disch_summary_signed_yn,informed_yn,disch_chklist_status from  ");
		chk_request.append(" ip_discharge_checklist where facility_id='"+facilityId+"' and ");
		chk_request.append(" encounter_id ="+encounterid+" ");
		rset = stmt.executeQuery(chk_request.toString());
		if(rset != null && rset.next()) {
			disch_chklist_status = rset.getString("disch_chklist_status");
			if(disch_chklist_status == null) disch_chklist_status="";
		}
		if(rset != null) rset.close(); 
		if(!disch_chklist_status.equals("1")) {	
	%>   var error = getMessage('DISC_CHKLST_NOT_PREPD','IP');
			alert(error);
			window.close();
<%	}
	}	
%>
}

function enableInformName_disch() {

	if (document.forms[0].inform_to.value != "") {
		document.getElementById("im").style.visibility = 'visible';
		document.forms[0].informed_date.disabled = false;
		document.getElementById("infocalimg").disabled	= false;
		document.forms[0].informed_name.disabled = false;
	} else if (document.forms[0].inform_to.value	==	"") {
		document.getElementById("im").style.visibility = 'hidden';
		document.forms[0].informed_date.disabled	=	true;
		document.forms[0].informed_date.value		=	"";
		document.getElementById("infocalimg").disabled	=	true;
		document.forms[0].informed_name.disabled	=	true;
	}
	if (document.forms[0].inform_to.value	==	"03") {
		document.forms[0].informed_name.value		=	"";
		document.forms[0].informed_name.disabled	=	false;
	}	
	if ((document.forms[0].inform_to.value == "01") || (document.forms[0].inform_to.value == "02")) {
		var patientid = document.forms[0].patient_id.value;
		document.forms[0].informed_name.disabled	=	false;
		var informTo	= document.forms[0].inform_to.value;
		var disp_pat_name='';
		if (document.forms[0].inform_to.value == "01"){
			disp_pat_name=document.forms[0].contact1_name.value;
		}else {
			disp_pat_name=document.forms[0].contact2_name.value;
		}		
		document.forms[0].informed_name.value = disp_pat_name;
   		document.forms[0].informed_name.disabled=false;
		if(disp_pat_name!='')
			document.forms[0].informed_name.focus();
		//var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dummy_form' id='dummy_form' method='post'  action='../../eIP/jsp/DischargeValidation.jsp' ><input type='hidden' name='field1' id='field1' value='TransferOutForm'><input type='hidden' name='field2' id='field2' value='"+patientid+"'><input type='hidden' name='field3' id='field3' value='"+informTo+"'><input type='hidden' name='field4' id='field4' value='TransferOutForm'><input type='hidden' name='field5' id='field5' value='Discharge'></form></body></html>";		
		//parent.frames[4].document.write(HTMLVal);
		//parent.frames[4].document.dummy_form.submit();
	} else {
		document.forms[0].informed_name.value		=	"";
	}
}
</script>
</head>
	<%

		String meddesc 					= "";	
		String chk1						= "";
		String chk2						= "";
		String medteamid 				= checkForNull(request.getParameter("medteamid"));
		String dis_val					= "";
		String check_val				= "";
		String target_date				= "";
		String from_hcare_setting_type_code	= "";
		//added on 3-07-2008 for SCR 3228
		String contact1_name			= "";
		String contact2_name			= "";
		String cnt						= "";
	//	String override_yn				="N";
		String dead_yn					= "";
		String maternal_death_yn		= "";	
		String indicator				= checkForNull(request.getParameter("indicator"));	
		String override_yn				= "";	
		String discharge_type_desc		= "";	
		String discharge_status_desc	= "";	
		//Added for the CRF - Bru-HIMS-CRF-0157
		String disch_reason_mand_yn="N";
		String allow_late_discharge_reason="";
		String edd_crossed="N";
		String allow_muti_bedside_review_yn="N"; //Added for this CRF HSA-CRF-0263.1
		try
		{
		/*Friday, April 30, 2010 ,SRR20056-SCF-4436-IN021088 condition added returned_yn = 'N' in where clause of pr_patient_valuables*/		
			int countValue				= 0;
			int mother_status			= 0;
			//Maheshwaran K commented for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
			//String sql = "SELECT contact1_name, contact2_name,(SELECT COUNT (*) FROM ip_lodger_detail a WHERE a.facility_id = '"+facilityId+"' AND a.check_out_yn = 'N' AND a.patient_encounter_id = '"+encounterid+"') countvalue,(SELECT TO_CHAR (MAX (trn_date_time), 'dd/mm/rrrr hh24:mi') FROM ip_adt_trn WHERE facility_id = '"+facilityId+"' AND encounter_id =  '"+encounterid+"') ip_trn_date, (SELECT hcare_setting_type_code FROM sm_facility_param WHERE facility_id = '"+facilityId+"') hcare_setting_type_code,(mr_mds_recorded_yn ('"+facilityId+"','"+encounterid+"','"+patient_class+"','DA','')) mr_mds_recorded,(SELECT COUNT (*) FROM pr_patient_valuables WHERE facility_id = '"+facilityId+"' AND encounter_id = '"+encounterid+"' AND returned_yn = 'N') cnt , (select count(*)  from ip_nursing_unit_bed a, ip_open_encounter b where a.facility_id = b.facility_id and a.nursing_unit_code = b.nursing_unit_code and a.main_bed_no = b.bed_num and b.encounter_id = '"+encounterid+"'  and b.facility_id = '"+facilityId+"' and a.occupying_patient_id is not null and a.nursing_unit_code = '"+nursing_unit_code+"') m_status, am_get_desc.am_practitioner('"+auth_practitioner_id+"', '"+locale+"', 1) practitioner_name, (TO_CHAR (SYSDATE, 'dd/mm/rrrr hh24:mi')) serverDate FROM mp_pat_rel_contacts WHERE patient_id ='"+patient_id+"' " ;
			//String sql = "SELECT contact1_name, contact2_name,(SELECT COUNT (*) FROM ip_lodger_detail a WHERE a.facility_id = '"+facilityId+"' AND a.check_out_yn = 'N' AND a.patient_encounter_id = '"+encounterid+"') countvalue,(SELECT TO_CHAR (MAX (trn_date_time), 'dd/mm/rrrr hh24:mi') FROM ip_adt_trn WHERE facility_id = '"+facilityId+"' AND encounter_id =  '"+encounterid+"') ip_trn_date, (SELECT hcare_setting_type_code FROM sm_facility_param WHERE facility_id = '"+facilityId+"') hcare_setting_type_code,(SELECT COUNT (*) FROM pr_patient_valuables WHERE facility_id = '"+facilityId+"' AND encounter_id = '"+encounterid+"' AND returned_yn = 'N') cnt , (select count(*)  from ip_nursing_unit_bed a, ip_open_encounter b where a.facility_id = b.facility_id and a.nursing_unit_code = b.nursing_unit_code and a.main_bed_no = b.bed_num and b.encounter_id = '"+encounterid+"'  and b.facility_id = '"+facilityId+"' and a.occupying_patient_id is not null and a.nursing_unit_code = '"+nursing_unit_code+"') m_status, am_get_desc.am_practitioner('"+auth_practitioner_id+"', '"+locale+"', 1) practitioner_name, (TO_CHAR (SYSDATE, 'dd/mm/rrrr hh24:mi')) serverDate FROM mp_pat_rel_contacts WHERE patient_id ='"+patient_id+"' " ;
			//Below line modified for this HSA-CRF-0263.1
			String sql = "SELECT contact1_name, contact2_name,(SELECT COUNT (*) FROM ip_lodger_detail a WHERE a.facility_id = '"+facilityId+"' AND a.check_out_yn = 'N' AND a.patient_encounter_id = '"+encounterid+"') countvalue,(SELECT TO_CHAR (MAX (trn_date_time), 'dd/mm/rrrr hh24:mi') FROM ip_adt_trn WHERE facility_id = '"+facilityId+"' AND encounter_id =  '"+encounterid+"') ip_trn_date, (SELECT hcare_setting_type_code FROM sm_facility_param WHERE facility_id = '"+facilityId+"') hcare_setting_type_code,(SELECT COUNT (*) FROM pr_patient_valuables WHERE facility_id = '"+facilityId+"' AND encounter_id = '"+encounterid+"' AND returned_yn = 'N') cnt , (select count(*)  from ip_nursing_unit_bed a, ip_open_encounter b where a.facility_id = b.facility_id and a.nursing_unit_code = b.nursing_unit_code and a.main_bed_no = b.bed_num and b.encounter_id = '"+encounterid+"'  and b.facility_id = '"+facilityId+"' and a.occupying_patient_id is not null and a.nursing_unit_code = '"+nursing_unit_code+"') m_status,(select allow_muti_bedside_review_yn from ip_param where FACILITY_ID='"+facilityId+"') allow_muti_bedside_review_yn, am_get_desc.am_practitioner('"+auth_practitioner_id+"', '"+locale+"', 1) practitioner_name, (TO_CHAR (SYSDATE, 'dd/mm/rrrr hh24:mi')) serverDate FROM mp_pat_rel_contacts WHERE patient_id ='"+patient_id+"' " ;
			rset	=	stmt.executeQuery(sql);
			if(rset!=null && rset.next()){
				contact1_name			=	checkForNull(rset.getString("contact1_name"));
				contact2_name			=	checkForNull(rset.getString("contact2_name"));
				countValue				=	rset.getInt("countValue");
				ip_Trn_Date				= rset.getString("ip_trn_date");
				if (patient_class.equals("DC")) {
					from_time			= rset.getString("ip_trn_date");
				}
				from_hcare_setting_type_code = checkForNull(rset.getString("hcare_setting_type_code"));
			//	mr_mds_recorded			= checkForNull(rset.getString("mr_mds_recorded"));//Maheshwaran K commented for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
				cnt=rset.getString("cnt");
				mother_status			= rset.getInt("m_status");
				allow_muti_bedside_review_yn=checkForNull(rset.getString("allow_muti_bedside_review_yn")); //Added for this CRF HSA-CRF-0263.1
				auth_practitioner_name  = rset.getString("practitioner_name");
				serverDate				= rset.getString("serverDate");
			}
			

			// 11/5/2004 - For Day Care Issues starts
			if (patient_class.equals("DC")) {
					StringBuffer sqlBuffer = new StringBuffer();
					if (sqlBuffer.length() > 0)	sqlBuffer.delete(0, sqlBuffer.length());
					sqlBuffer.append(" SELECT TO_CHAR(TO_DATE('"+admission_date_time+"', 'dd/mm/rrrr hh24:mi')+ (1 / 24) * '"+max_disch_period_for_dc+"', 'dd/mm/rrrr hh24:mi' ) MAX_PARAM_DATE,   (CASE WHEN TRUNC (TO_DATE('"+admission_date_time+"', 'dd/mm/rrrr hh24:mi')+ (1 / 24) * '"+max_disch_period_for_dc+"') != TRUNC (TO_DATE ('"+admission_date_time+"', 'dd/mm/rrrr hh24:mi')) THEN 'N' ELSE 'Y' END ) VALID,   TO_CHAR((CASE WHEN TRUNC (  TO_DATE ('"+admission_date_time+"', 'dd/mm/rrrr hh24:mi')+ (1 / 24) * '"+max_disch_period_for_dc+"') != TRUNC (TO_DATE ('"+admission_date_time+"', 'dd/mm/rrrr hh24:mi')) THEN trunc(TO_DATE('"+admission_date_time+"', 'DD/MM/rrrr hh24:mi')) ELSE TO_DATE('"+admission_date_time+"', 'dd/mm/rrrr hh24:mi')+ (1 / 24) * '"+max_disch_period_for_dc+"' END), 'dd/mm/rrrr') VALID_DATE,to_char((sysdate+'"+max_disch_period_for_dc+"'/24),'dd/mm/rrrr hh24:mi') target_date   FROM dual");
					//IP_ADT_TRN WHERE   facility_id = '"+facilityId+"' AND encounter_id = '"+encounterid+"'");					
					rset	= stmt.executeQuery(sqlBuffer.toString());
					if ((rset != null) && (rset.next())) {
						valid			= rset.getString("VALID");
						//from_time		= rset.getString("FROM_TIME");
						max_param_date	= rset.getString("MAX_PARAM_DATE");
						valid_date		= rset.getString("VALID_DATE");
						target_date     = rset.getString("target_date");
					}
					//valid_date = valid_date+ " 23:59";
					valid_date = max_param_date; //Modified for AAKH-SCF-0093
			}

			java.text.SimpleDateFormat dateFormat1	= new java.text.SimpleDateFormat( "dd/MM/yyyy HH:mm" ) ;
			java.sql.Timestamp sdate				= new Timestamp(System.currentTimeMillis()) ;
			String Sdate							= dateFormat1.format(sdate) ;
			java.text.SimpleDateFormat dateFormat	= new java.text.SimpleDateFormat( "dd/MM/yyyy" ) ;
			java.util.Date dt						= new java.util.Date();
			String d								= dateFormat.format( dt ) ;
			String curdateWithoutTime				= d;
			String sec								= String.valueOf(dt.getMinutes());			
			if ((sec).length()==1) 
				sec="0"+sec; 
			else sec = sec;			
			d					=	d + " "+String.valueOf(dt.getHours())+":"+sec;
			int hrs				= discharge_after_hrs+dt.getHours();
			java.util.Date dt1	= new java.util.Date(dt.getYear(),dt.getMonth(),dt.getDate(),hrs,dt.getMinutes());
			String d1			= dateFormat.format( dt1 ) ;
			String sec1			= String.valueOf(dt.getMinutes());
			if ((sec1).length()==1) 
				sec1 = "0" + sec1; 
			else sec1 = sec1;

			d1  = d1 + " "+String.valueOf(dt1.getHours())+":"+sec1;
            d						    = checkForNull(request.getParameter("EXPECTED_DISCHARGE_DATE"));
			String dischargetypecode	= checkForNull(request.getParameter("discharge_type_code"));
			String dischargesummaryyn	= checkForNull(request.getParameter("discharge_summary_yn"));
			String takehomenewmedyn		= checkForNull(request.getParameter("take_home_new_med_yn"));
			String death_date_time		= checkForNull(request.getParameter("deceased_date_time"));
			
			d1						    = "";	
			
			if(dischargesummaryyn.equals("Y")) 
				chk1 = "checked";

			if(takehomenewmedyn.equals("Y"))   
				chk2 = "checked";		
	
			String exp_dis_date_display = DateUtils.convertDate(EXPECTED_DISCHARGE_DATE,"DMYHM","en",locale);
			String serverDate_display = DateUtils.convertDate(serverDate,"DMYHM","en",locale);					
			String death_date_time_display = "";
					
					if(death_date_time.equals(""))
						death_date_time_display = "";
					else
						death_date_time_display = DateUtils.convertDate(death_date_time,"DMYHM","en",locale);
			String bmi	= checkForNull(request.getParameter("bmi"));
		try
			{

				rset = stmt.executeQuery("select override_yn, deceased_yn, (IP_GET_DESC.ip_discharge_type('"+dischargetypecode+"','"+locale+"',2)) discharge_type_desc, (IP_GET_DESC.ip_discharge_status('"+discharge_status_code+"','"+locale+"',2)) discharge_status_desc,maternal_death_yn from ip_discharge_type_vw where  eff_status = 'E' and discharge_type_code='"+dischargetypecode+"' ");
				if(rset != null && rset.next()) {
					dead_yn					= checkForNull(rset.getString("deceased_yn"));
					maternal_death_yn		= checkForNull(rset.getString("maternal_death_yn"));
					discharge_type_desc		= checkForNull(rset.getString("discharge_type_desc"));
					override_yn				= checkForNull(rset.getString("override_yn"),"N");
					discharge_status_desc	= checkForNull(rset.getString("discharge_status_desc"));
				}
				if(rset != null) rset.close(); 
				if(stmt != null) stmt.close(); 
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
					
	%>
	<body onLoad="checkform();getBedBlkData();<%if(isHeightAndBmiEnable){%>calculateBmi('<%=bmi%>')<%}%>" onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name='DischargePatient_form' id='DischargePatient_form'  method="post" action="../../servlet/eIP.DischargePatientServlet" target="messageFrame">
	<a id="tab1" name="tab1" tabindex='0' ></a> 
<ul id="tablist" class="tablist">
	<li class="tablistitem" title="Discharge Details">
		<a onclick="tab_click('discharge_details')" class="tabClicked" id="discharge_details" >
			<span class="tabSpanclicked" id=""><fmt:message key="eIP.DischargeDetails.label" bundle="${ip_labels}"/></span>
		</a>
	</li>
	<li class="tablistitem" title="Additional Discharge Details">
		<a onclick="tab_click('Addl_Discharge_Details')" class="tabA" id="Addl_Discharge_Details" >
			<span class="tabAspan" id=""><fmt:message key="eIP.AdditionalDischargeDetails.label" bundle="${ip_labels}"/></span>
		</a>
	</li>
</ul>
<div style="overflow:scroll;height:380px;width:100%;overflow:auto">
	<table cellpadding="1" cellspacing=2 width="100%" border="0" >
		<td class=label width='100%'>
		
	<table cellpadding='1' cellspacing=2 width="100%" border="0" >
		<!--<tr><td class='DEFAULTBLANKROW' colspan=4 height="2"></td></tr>-->
		<tr>
			<td class='label' width='25%' nowrap><fmt:message key="eIP.AuthorizedPractitioner.label" bundle="${ip_labels}"/></td>
			<td class='fileds' width='30%' nowrap><input type='text' name='auth_pract_desc' id='auth_pract_desc' value="<%=auth_practitioner_name%>" size='25' maxlength='30' onChange="getPractitionerId(practid,this, '<%=facilityId%>');"><input type='hidden' name='practid' id='practid' value="<%=auth_practitioner_id%>" ><input type='button' name='pract_id_search' id='pract_id_search' value='?' class='button' onClick="getPractitionerId(practid,auth_pract_desc, '<%=facilityId%>');"><img src='../../eCommon/images/mandatory.gif'align='center'></img>
			</td>

			<!-- Added by Ashwini on 13-Jun-2022 for ML-MMOH-CRF-1527.1-->
			<%
			if(isHeightAndBmiEnable)
			{
				if(Type_indicator.equals("ED"))
				{%>
				<td class= 'label' width='8%'></td>
				<td class='fields' width='25%'></td>
				<%
				}
			}
			%>
			<!--End ML-MMOH-CRF-1527.1-->

			<td class='label' width='20%' nowrap><fmt:message key="eIP.DischargingPractitioner.label" bundle="${ip_labels}"/></td>
			<td class='fileds' width='25%' nowrap><input type='text' name='dischg_pract_desc' id='dischg_pract_desc'   value="<%=auth_practitioner_name%>" size='25' maxlength='30' onChange="getPractitionerId(practid,this, '<%=facilityId%>');"><input type='hidden' name='dischg_practid' id='dischg_practid' value="<%=auth_practitioner_id%>" ><input type='button' name='dischg_pract_id_search' id='dischg_pract_id_search' value='?' class='button' onClick="getPractitionerId(practid,dischg_pract_desc, '<%=facilityId%>');"><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
		</tr>
		<%
		
	
	if(isModifyDiscTypeStatusAppl && allow_modify_disc_yn.equals("Y")) // added by mujafar for ML-MMOH-CRF-0659	
			{%>		
			<tr> 
	<td class='label' width='25%' nowrap><fmt:message key="Common.dischargetype.label" bundle="${common_labels}"/></td><td class='fields' width='20%'><SELECT name='dischargetype' id='dischargetype' onchange="callValidate1(this.value);" tabindex = '5' dir='<%=language_direction%>'>
	<!--<option value='' selected>-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>-->
<%
		
		String sel="";
		
		JSONArray DischargeTypeArray	= new JSONArray();
		DischargeTypeArray = eIP.IPCommonBean.getDischargeTypes(con,locale,indicator);
		
					for(int i = 0; i < DischargeTypeArray.size(); i++)
						{
							JSONObject json = (JSONObject)DischargeTypeArray.get(i);
							String disCode	= (String) json.get("disCode");
							String disCode1	= (String) json.get("disCode1");
							String disDesc  = (String) json.get("disDesc");
							if(disCode1.equals(dischargetypecode))
								sel="selected";
							else
								sel="";
							
							out.println("<option value='"+disCode+"'" +sel+ ">"+disDesc+"</option>");
						}
%>
	</SELECT>
	<input type='hidden' name='discharge_code' id='discharge_code' value= ""  >
	<input type='hidden' name='dischage_indicator' id='dischage_indicator' value= ""  >
	<input type='hidden' name='discharge_indicator' id='discharge_indicator' value= ""  >
	
	</td>
	<input type='hidden' name='discharge_type' id='discharge_type' value='<%=dischargetypecode%>'></input>
<!-- modified on 2/07/2008 for SCR 3228 -->
<%/*"dir" Added Above Line code for this SCF[AK-SCF-0153]*/%>
	<td class='label' width='12%' nowrap><fmt:message key="eIP.DischargeStatus.label" bundle="${ip_labels}"/></td><td class='fields' width='20%' ><SELECT name='dischargestatus' id='dischargestatus' onchange='capt_value(this)' tabindex = '6' ><option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---
	
	<%
	
	
	if(!discharge_status_code.equals(""))
	{
	
	String sel_1="";
	
		JSONArray DischargeStatusArray	= new JSONArray();
		DischargeStatusArray = eIP.IPCommonBean.getDischargeStatus(con,locale,discharge_status_code);
		
					for(int i = 0; i < DischargeStatusArray.size(); i++)
						{
							JSONObject json = (JSONObject)DischargeStatusArray.get(i);
							 String StatusCode	= (String) json.get("StatusCode");
							 String StatusDesc	= (String) json.get("StatusDesc");
							
							if(StatusCode.equals(discharge_status_code))
										 sel_1="selected";
									 else
										sel_1="";									
									out.println("<option value='"+StatusCode+"'" +sel_1+ ">"+StatusDesc+"</option>");
						}
		
	}
	else
	{
		if(indicator.equals("DS"))
			{
				
				JSONArray DischargeStatusA_all_Array	= new JSONArray();
				DischargeStatusA_all_Array = eIP.IPCommonBean.getDischargeStatus_all(con,locale,"DS");
				for(int i = 0; i < DischargeStatusA_all_Array.size(); i++)
						{
							JSONObject json = (JSONObject)DischargeStatusA_all_Array.get(i);
							String code	= (String) json.get("code");
							String desc	= (String) json.get("desc");
							out.println("<option value='"+code+"' >"+desc+"</option>");
							
						}
					
			}
			else 
			{
				JSONArray DischargeStatusA_all_Array	= new JSONArray();
				DischargeStatusA_all_Array = eIP.IPCommonBean.getDischargeStatus_all(con,locale,"DS");
				for(int i = 0; i < DischargeStatusA_all_Array.size(); i++)
						{
							JSONObject json = (JSONObject)DischargeStatusA_all_Array.get(i);
							String code	= (String) json.get("code");
							String desc	= (String) json.get("desc");
							out.println("<option value='"+code+"' >"+desc+"</option>");
							
						}
				
			}

	}
		%>	
	</SELECT><img src='../../eCommon/images/mandatory.gif' align = 'center'></img>
	<input type='hidden' name='discharge_status' id='discharge_status' value= ""  >
	<input type='hidden' name='dischage_status_indicator' id='dischage_status_indicator' value= ""  ></td>
	<input type='hidden' name='discharge_stat' id='discharge_stat' value='<%=discharge_status_code%>'></input>
</tr>
	<%}
			else
			{
			%>
		<tr>
			<td class=label nowrap><fmt:message key="Common.dischargetype.label" bundle="${common_labels}"/></td>
			<td nowrap class='fileds'><input type='text' disabled name='discharge_type1' id='discharge_type1' value='<%=discharge_type_desc%>'></input></td>
			<input type='hidden' name='discharge_type' id='discharge_type' value='<%=dischargetypecode%>'></input>

			
					<input type="hidden" name="override_yn" id="override_yn" value="<%=override_yn%>"> 
					<input type="hidden"  name="indicator" id="indicator" value="<%=indicator%>">
			
			<!-- added on 3-07-2008 for SCR 3228 -->

			<!-- Added by KAMATCHI S for ML-MMOH-CRF-1527 ON 23-JUN-2020-->
			<%
			if(isHeightAndBmiEnable)
			{
				if(Type_indicator.equals("ED"))
				{%>	
				
				<td class= 'label'  width='8%' nowrap><fmt:message key="eIP.DischargeTo.label" bundle="${ip_labels}"/>
				<td class='fields' width='25%' nowrap>
				<% 
				String disc_to=eIP.IPCommonBean.getDischargeTo(con,facilityId,encounterid,patient_id,patient_class);
				%>
				<input type="text" name="discharge_to" id="discharge_to"  id='distext'  value="<%=disc_to%> "OnBlur='ChangeUpperCase(this);if(this.value != "") searchCode(discharge_to_value,this);'><input type='button' align='left' name='discharge_to_value' id='discharge_to_value' id='disbtn' value='?' class='button' onClick='searchCode(this,discharge_to)'>			
				</td>
				
				<%
				}
			}
			%>
			<!-- Added by KAMATCHI S for ML-MMOH-CRF-1527 ON 23-JUN-2020-->
			
			<td class=label nowrap><fmt:message key="eIP.DischargeStatus.label" bundle="${ip_labels}"/></td>
			<td nowrap class='fileds'><input type='text' disabled name='discharge_status' id='discharge_status' value='<%=discharge_status_desc%>'></input></td>
			<input type='hidden' name='discharge_stat' id='discharge_stat' value='<%=discharge_status_code%>'></input>
           <!-- stat_code stat_desc-->
		</tr>
		<%}%>
		<!-- Added by kishore on 8/31/2004  -->
		<tr>
			<td class=label nowrap><fmt:message key="eIP.ExpectedDischargeDateTime.label" bundle="${ip_labels}"/></td>
			<td nowrap class='fileds'><input type="text" name="expected_discharge_date_time" id="expected_discharge_date_time" value='<%=exp_dis_date_display%>' readOnly size=16 maxlength=16 ><img src="../../eCommon/images/CommonCalendar.gif"  onClick="document.forms[0].discharge_date_time.select();return showCalendar('date_of_expiry',null,'hh:mm');" disabled='true' tabindex=-1 /><img align=center src="../../eCommon/images/mandatory.gif"></img></td>

			<!-- Added by Ashwini on 13-Jun-2022 for ML-MMOH-CRF-1527.1-->
			<%
			if(isHeightAndBmiEnable)
			{
				if(Type_indicator.equals("ED"))
				{%>
				<td class= 'label' width='8%'></td>
				<td class='fields' width='25%'></td>
				<%
				}
			}
			%>
			<!--End ML-MMOH-CRF-1527.1-->

			<td class=label nowrap><fmt:message key="Common.dischargedatetime.label" bundle="${common_labels}"/></td>
			<td class='fileds' nowrap><input type="text" name="discharge_date_time" id="discharge_date_time" value="<%=serverDate_display%>" size=16 maxlength=16 onblur="DateValidations(this);validateLateDischarge();validatePatient(this,'<%=locale%>');" onKeyPress='return(ChkNumberInput1(this,event,2))'><img src="../../eCommon/images/CommonCalendar.gif"  onClick="document.forms[0].discharge_date_time.select();return showCalendar('discharge_date_time',null,'hh:mm');" tabindex=-1/><img align=center src="../../eCommon/images/mandatory.gif"></img></td>
		</tr>
		<%
			try{
				allow_late_discharge_reason=request.getParameter("allow_late_discharge_reason");
				disch_reason_mand_yn=request.getParameter("disch_reason_mand_yn");

				if (allow_late_discharge_reason == null || allow_late_discharge_reason.equals("") ){
					allow_late_discharge_reason="N";
				}
				if (allow_late_discharge_reason.equals("Y")){
					java.text.SimpleDateFormat sdf	= new java.text.SimpleDateFormat( "dd/MM/yyyy HH:mm" ) ;
					java.util.Date exp_dis_date=sdf.parse(exp_dis_date_display);
					java.util.Date server_date=sdf.parse(serverDate_display);
					if (exp_dis_date.compareTo(server_date) < 0)
					{
						edd_crossed="Y";
						%>						
						<tr id='late_reason_div' style='display:block'>
						<td class="label" width="25%" ><fmt:message key="eIP.ReasonForLateDischarge.label" bundle="${ip_labels}"/></td>
						<td>						
						<select id='late_discharge_reason' name='late_discharge_reason' id='late_discharge_reason' tabindex='0' onChange="getOtherReason();">
						<option value=''> ---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--- </option>
						<%
						stmt = con.createStatement();
						rset = stmt.executeQuery("select am_get_desc.am_contact_reason(contact_reason_code,'"+locale+"',1) Contact_Reason, Contact_Reason_Code from AM_CONTACT_REASON where REASON_FOR_LATE_DISCH_YN = 'Y' and Eff_Status = 'E' order by 1");
						if(rset!=null)
						{
							while(rset.next())
							{
								String contact_code = rset.getString("Contact_Reason_Code");
								String contact_desc = rset.getString("Contact_Reason");
								out.println("<option value='"+contact_code+"'>"+contact_desc+"</option>"); 
							}
						}
						out.println("<option value='others'>Others</option></select>"); 
						if(rset!=null) rset.close();
						if(stmt!=null) stmt.close();
						%>
						
						<%if(disch_reason_mand_yn != null && disch_reason_mand_yn.equals("Y"))
						{%>
							<img align=center src='../../eCommon/images/mandatory.gif'></img>
						<%}
						%>
						</td>
						</tr>

						<table cellpadding='1' cellspacing=0 width="100%" border=0>
						<tr id='name_div' style='display:none'>
						<td class="label" width="25%" ><fmt:message key="eIP.otherReason.label" bundle="${ip_labels}"/></td>						
						<td class='fileds'><textarea id="other_late_discharge_reason" name="other_late_discharge_reason" tabindex='0' ROWS="3" COLS="70" maxlength=200 onBlur="checkOtherReasonMaxlen(this);" style="resize: none;"></textarea></td>
						<td></td>
						</tr> 
						</table>
						
					<%}
					}
				}	
				catch(Exception e){
					e.printStackTrace();
				}
				%>
									
				<input type="hidden" name="Type_indicator" id="Type_indicator" value=<%=Type_indicator%> />
					<!-- Added by KAMATCHI S for ML-MMOH-CRF-1527 ON 23-JUN-2020-->
				<input type="hidden" name="disch_reason_mand_yn" id="disch_reason_mand_yn" value=<%=disch_reason_mand_yn%> />
				<input type="hidden" name="hid_late_dis_reason" id="hid_late_dis_reason" value='' />
				<input type="hidden" name="edd_crossed" id="edd_crossed" value=<%=edd_crossed%> />
				<input type="hidden" name="allow_late_disch_reason" id="allow_late_disch_reason" value=<%=allow_late_discharge_reason%> />
				<table cellpadding='3' cellspacing=0 width="100%" border="0"> 
					<tr>
						<!-- Added by Ashwini on 13-Jun-2022 for ML-MMOH-CRF-1527.1-->
						<%
						if(isHeightAndBmiEnable)
						{
							if(Type_indicator.equals("ED"))
							{%>
								<td class=label rowspan="3" width="18%">
							<%
							}else{%>
								<td class=label rowspan="3" width="25%">
							<%}
						}else{%>
							<td class=label rowspan="3" width="25%">
						<%}
						%>
						<!--End ML-MMOH-CRF-1527.1-->
						<fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
						<td class='fileds' rowspan="3" colspan=2 ><textarea name="discharge_remarks" ROWS="3" COLS="60"  onBlur="checkMaxlen(this);" style="resize: none;"><%=discharge_narration%></textarea></td>
						<%	// Added for  ML-MMOH-CRF-1611
						if (isDischrgBillStatus) { %>
						<td class=label ><fmt:message key="eIP.DischargeBill.label" bundle="${ip_labels}"/></td> <td class=label style="color:red;"><%=bill_genrt%></td>
					</tr>
					<tr>
						<td class=label><fmt:message key="eIP.PayementStatus.label" bundle="${ip_labels}"/></td> <td class=label style="color:red;" ><%=paid_unpaid_status%></td>
						<%}%>
					</tr> 
					<!--<tr><td class='DEFAULTBLANKROW' colspan=4 height="2"></td></tr>-->
				</table>
		 </table>

	
	<table cellpadding='3' cellspacing=0 width="100%" border=0 >
	<tr><td  colspan=4 class= "columnheader"><fmt:message key="Common.deceaseddetails.label" bundle="${common_labels}"/></td></tr>
		<tr><td class='DEFAULTBLANKROW' colspan=4 height="2"></td></tr>
	<tr>				
		<td class=label nowrap width='25%'><fmt:message key="Common.deceased.label" bundle="${common_labels}"/></td>
		<%
				
			if ((dischargetypecode != null) && (dead_yn.equals("Y")))
			{
				check_val	= "Checked";
				dis_val		= "";
			}
			else
			{
				check_val	= "";
				dis_val		= "Disabled";
			}
		%>
		<td width='30%' class='fileds'><input type="checkbox" value="Y" name="deceased_yn" id="deceased_yn" disabled <%=check_val%> ></td><td class=label nowrap width='20%'><fmt:message key="Common.deathdatetime.label" bundle="${common_labels}"/> </td>
		<td width='25%' class='fileds'><input type="text" id="deceased_date"  name="DECEASED_DATE_TIME" id="DECEASED_DATE_TIME" value="<%=death_date_time_display%>" size=16 maxlength=16 onblur="validateDateTimes(this,'DE');" onKeyPress='return(ChkNumberInput1(this,event,2))' ><img id="calcomp" src="../../eCommon/images/CommonCalendar.gif" onClick="			document.forms[0].DECEASED_DATE_TIME.select();return showCalendar('deceased_date',null,'hh:mm');" />
		<img id='deceasedimg' style='visibility:hidden;' align=center src="../../eCommon/images/mandatory.gif"></img>
		</td>
	</tr> 
	<tr>
		<%
			if ((dischargetypecode != null) && (dead_yn.equals("Y")))
				dis_val		= "";
			else
				dis_val		= "Disabled";

			if ((dischargetypecode != null) && (post_mortem_req_yn.equals("Y")))
				check_val	= "Checked";
			else
				check_val	= "";
		
		%>
		<td class=label nowrap><fmt:message key="eIP.PostMortemRequested.label" bundle="${ip_labels}"/></td>
		<td class='fileds'><input type="checkbox" value="N" name="post_mortem_request" id="post_mortem_request"  <%=dis_val%> <%=check_val%> onclick="bodyrelease(this)"></td>
		<td class=label nowrap><fmt:message key="eIP.BodyReleasedtoMortuary.label" bundle="${ip_labels}"/></td>
		<td class='fileds'>
		<input type="text" id="body_released"  name="body_released_date" id="body_released_date" <%if(dead_yn.equals("Y")){%>value="<%=serverDate_display%>"<%}else{%>value=""<%}%>size=16 maxlength=16 onblur="validateDateTimes(this,'');validateBodyReleasedDate(this);" onKeyPress='return(ChkNumberInput1(this,event,2))' ><img  id="calcomp1" src="../../eCommon/images/CommonCalendar.gif" onClick="			document.forms[0].body_released_date.select();return showCalendar('body_released',null,'hh:mm');"/><img id='bodyreleasedImg' style='visibility:hidden;' align=center src="../../eCommon/images/mandatory.gif"></img></td>
	</tr>
<%
	if (dischargetypecode != null && dead_yn.equals("Y"))
	{
		out.println("<script>document.getElementById('bodyreleasedImg').style.visibility='visible';</script>");
		out.println("<script>document.forms[0].body_released_date.disabled=false;document.getElementById('calcomp1').disabled=false;</script>");
	}
	else
	{
		out.println("<script>document.getElementById('bodyreleasedImg').style.visibility='hidden';</script>");
		out.println("<script>document.forms[0].body_released_date.disabled=true;document.getElementById('calcomp1').disabled=true;</script>");
	}
	if(dischargetypecode!=null && dischargetypecode.equals("DT"))
		dis_highrisk	=	"";
	else
		dis_highrisk	=	"Disabled";

%>
	<tr>
		<td class='label' nowrap><fmt:message key="Common.highriskbody.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type="checkbox" value="N" name="body_risk" id="body_risk" onclick="if(this.checked == true){this.value='Y'}else{this.value='N'}" <%=dis_highrisk%>></td>
	<!-- Added by Ajay Hatwate for AAKH-CRF-0179 on 22-08-2023  -->
	<% if(isDeathRegisterFormAppl && enable_death_reg_form.equals("Y") && dead_yn.equals("Y") && !death_reg_form_accession_num.equals("")){ %>
	<td class='label'>
   		<a href="javascript:getDeathRegFormAccessionNum('<%=patient_id%>','<%=encounterid%>','','<%=admission_date_time%>','<%=patient_class%>','<%=to_specialty_code%>','<%=to_locn_code%>','<%=death_reg_form_accession_num%>','');" id='deathRegFormLink'><fmt:message key="Common.DeathRegForm.label" bundle="${common_labels}"/></a>
  	</td>
	<%} %>
	</tr>
	<tr><td class='DEFAULTBLANKROW' colspan=4 height="2"></td></tr>
	<tr>
		<%
			
			String chck_val="";
			String disb_val="";
			if (med_lgl_case_yn.equals("Y")) 
			{
				chck_val = "Checked";
				disb_val = "";
			}
			else 
			{	
				chck_val = "";
				disb_val = "Disabled";
			}
		%>

	<!-- below line(s) modified by VenkateshS against ML-MMOH-CRF-0354 [IN057191] -->
	    <%if(siteSpecific){%>
		<td colspan='4' class= "COLUMNHEADER"><fmt:message key="Common.MedicalLegalCase.label" bundle="${common_labels}"/> <fmt:message key="Common.details.label" bundle="${common_labels}"/></td>
	<tr>
			<td class='label'><fmt:message key="Common.MedicalLegalCase.label" bundle="${common_labels}"/></td>
		<%}else{%>
		<td colspan='4' class= "COLUMNHEADER"><fmt:message key="Common.mlcdetails.label" bundle="${common_labels}"/></td>
	<tr>
		<td class='label'><fmt:message key="Common.mlc.label" bundle="${common_labels}"/></td>
		<%}%>
		<!--end ML-MMOH-CRF-0354 [IN057191 -->
		<td  class='fileds'><INPUT TYPE="checkbox" name="medico_legal" id="medico_legal" value="Y" <%=chck_val%>  onClick="getMedicoValues(this);enablePolice(this);" onBlur='focusNext();'><input type='hidden' name='dischgsumsigned' id='dischgsumsigned' value= "N" ></td>
		<td > </td>
		<td > </td>
	</tr>
	<tr>
		<td  class='label' ><fmt:message key="Common.PoliceReportNo.label" bundle="${common_labels}"/></td>
		<td class='fileds' colspan='3'><INPUT TYPE='text' name='pol_rep_no' id='pol_rep_no' value= "<%=pol_rep_no%>" size='20' maxlength='30'><INPUT TYPE='hidden' name='pol_rep_no_db' id='pol_rep_no_db' value= "<%=pol_rep_no%>">
		</td>
	</tr>
	<tr>
		<td class='label'  ><fmt:message key="Common.station.label" bundle="${common_labels}"/></td>
		<td class='fileds' ><INPUT TYPE='text' name='pol_stn_id' id='pol_stn_id' value="<%=pol_stn_id%>" size='20' maxlength='30'><INPUT TYPE='hidden' name='pol_stn_id_db' id='pol_stn_id_db' value= "<%=pol_stn_id%>">
		</td>
		<td class='label'><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
		<td class='fileds'><INPUT TYPE='text' name='pol_id' id='pol_id' onblur="focusNext()" value="<%=pol_id%>" size='20' maxlength='30'><INPUT TYPE='hidden' name='pol_id_db' id='pol_id_db' value= "<%=pol_id%>">
		</td>
	</tr>

<script>

	document.forms[0].pol_rep_no.disabled=true;
	document.forms[0].pol_stn_id.disabled=true;
	document.forms[0].pol_id.disabled=true;

</script>
	
	<!--<tr><td class='DEFAULTBLANKROW' colspan=4 height="4"></td></tr>-->
	<tr>
		<td colspan=2><input type="hidden" value="Y" name="new_medicine" id="new_medicine" <%=chk2%>></td>
		<td colspan=2><input type="hidden" value="Y" name="discharge_summary_signed" id="discharge_summary_signed" <%=chk1%>></td>
	</tr>

</table>
</div>
<BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>
<BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>





<a id="tab3" name="tab3" tabindex='0' onfocus="javascript:tab_click('discharge_details')"></a>
<ul id="tablist" class="tablist">
	<li class="tablistitem" title="Discharge Details">
		<a onclick="tab_click('discharge_details')" class="tabA" id="discDetails" >
			<span class="tabASpan" id=""><fmt:message key="eIP.DischargeDetails.label" bundle="${ip_labels}"/></span>
		</a>
	</li>
	<li class="tablistitem" title="Additional Discharge Details">
		<a onclick="tab_click('Addl_Discharge_Details')" class="tabClicked" id="addlDiscDetails" >
			<span class="tabSpanclicked" id=""><fmt:message key="eIP.AdditionalDischargeDetails.label" bundle="${ip_labels}"/></span>
		</a>
	</li>
</ul>

</td></tr>
</table>
<table cellpadding='1' cellspacing=0 width="100%" border = "0">

	<tr>
		<td width="97%" class='fileds'>
		<%
			if ((dead_yn.equals("Y")) || (patient_status.equals("3")) )
			{
		%>
			<input type=button class=button value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bookappointment.label","common_labels")%>' name='bookingappointment' onclick='appointment()' style="width:122" disabled>
		<%
			}else
			{
		%>
			<input type=button class=button value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bookappointment.label","common_labels")%>' name='bookingappointment' onclick='appointment()' style="width:122">
		<%
			}
		%>
		</td><td width="3%"></td>
	</tr>
</table>
	
<BR><BR><BR><BR><BR><BR> <BR><BR><BR><BR><BR><BR><BR><BR>
<BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>
<BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>
<BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>


<a id="tab2" name="tab2" tabindex='1' onfocus="javascript:tab_click('Addl_Discharge_Details')"></a>
<ul id="tablist" class="tablist" style="margin-top:-445px;">
	<li class="tablistitem" title="Discharge Details">
		<a onclick="tab_click('discharge_details1')" class="tabA" id="discharge_details1" >
			<span class="tabAspan" id=""><fmt:message key="eIP.DischargeDetails.label" bundle="${ip_labels}"/></span>
		</a>
	</li>
	<li class="tablistitem" title="Additional Discharge Details">
		<a onclick="tab_click('Addl_Discharge_Details')" class="tabClicked" id="Addl_Discharge_Details1" >
			<span class="tabSpanclicked" id=""><fmt:message key="eIP.AdditionalDischargeDetails.label" bundle="${ip_labels}"/></span>
		</a>
	</li>
</ul>


<table width='100%' cellpadding='1' cellspacing='0' BORDER='0' >
	<tr>
		<td colspan=4 width="100%" class= "COLUMNHEADER"><fmt:message key="eIP.BedBlockDetails.label" bundle="${ip_labels}"/></td>
	</tr>


<tr><td class=label colspan=4></td></tr>

<TR>
	<TD  class="label" width='25%'><fmt:message key="eIP.BlockType.label" bundle="${ip_labels}"/></TD>
	<TD   class='fileds' colspan=3><INPUT TYPE="text" name="blocking_type" id="blocking_type" readOnly maxlength="30" size="30" ><input type="hidden" name="blocking_type_code" id="blocking_type_code" value="" ></TD>
	</TR>

<TR>
	<TD class="label" ><fmt:message key="eIP.BlockPeriod.label" bundle="${ip_labels}"/></TD>
	<TD  class='fileds' ><INPUT TYPE="text" name="bed_blocking_period" id="bed_blocking_period" value="" onBlur = "validSpecialChars(this);CheckNum(this);" onKeyPress="return allowOnlyNumbers(event);" maxlength="3" size="3" ><B><span class='label'><fmt:message key="Common.hours.label" bundle="${common_labels}"/></span></B></td>
</tr>

<TR>
	<TD class="label" ><fmt:message key="eIP.BedBlockleduntil.label" bundle="${ip_labels}"/></TD>
	<TD  class='fileds' colspan=3><INPUT TYPE="text" name="bed_block_until" id="bed_block_until" readOnly maxlength="15" size="15" ></TD>
	</TR>

<TR>
	<TD class="label" ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></TD>
	<TD  colspan='3' class="fileds"><TEXTAREA name='bed_block_remarks' value="" ROWS="2" COLS="60" maxlength='60' onBlur="makeValidString(this);checkForMaximum(this.value);" style="resize: none;"></TEXTAREA></TD>
</TR>
</table>

<table width='100%' cellpadding='1' cellspacing='0' BORDER='0'>
	<tr>
	<td colspan=4 width="100%" class= "COLUMNHEADER"><fmt:message key="eIP.InformedDetails.label" bundle="${ip_labels}"/></td>
	</tr>
	<tr><td class='DEFAULTBLANKROW' colspan=4 height="4"></td></tr>
</table>
<jsp:include page="../../eIP/jsp/InformedDetails.jsp" flush="true" >
	<jsp:param name ="called_from"  value="dischage_patient" />
	<jsp:param name ="patient_id"  value="" />	
	<jsp:param name ="informed_to"  value="<%=informed_to%>" />		
	<jsp:param name ="informed_name"  value="<%=informed_name%>" />	
	<jsp:param name ="informed_date_time"  value="<%=informed_date_time%>" />	
	<jsp:param name="system_date_time" value="<%=Sdate%>" />
	<jsp:param name="encounterID" value="<%=encounterid%>" />
	<jsp:param name="admissiondatetime" value="<%=admission_date_time%>" />
</jsp:include>

<%
String abscond_details="visibility:hidden"; // added by mujafar for ML-MMOH-CRF-0659
if(Type_indicator.equals("AB"))
{
    abscond_details="visibility:visible"; // added by mujafar for ML-MMOH-CRF-0659
	
	if ((absconded_yn != null) && (absconded_yn.equals("Y")))
	{
		check_val	= "Checked";
		dis_val		= "Disabled";
	}
	else
	{
		check_val	= "";
		dis_val		= "Disabled";
	}
}
%>
<div id = 'ab_details' style="<%=abscond_details%>">  <!--  added by mujafar for ML-MMOH-CRF-0659 -->
<table width='100%' cellpadding='1' cellspacing='0' BORDER='0'>
	<tr><td class='DEFAULTBLANKROW' colspan=4 height="4"></td></tr>
	<tr><td colspan=4 width="100%" class= "COLUMNHEADER"><fmt:message key="eIP.AbscondingDetails.label" bundle="${ip_labels}"/></td></tr>
	<tr><td class='DEFAULTBLANKROW' colspan=4 height="4"></td></tr>
</table>

<jsp:include page="../../eIP/jsp/AbscondingDetails.jsp" flush="true" >
	<jsp:param name="call_function" value="Discharge_Patient"/>
	<jsp:param name ="add_reported"  value="<%=reported_to%>" />
	<jsp:param name ="dis_val"  value="<%=dis_val%>" />
	<jsp:param name ="check_val"  value="<%=check_val%>" />
	<jsp:param name ="absconded_date"  value="<%=absconded_date%>" />
	<jsp:param name ="def_val"  value="true" />			
</jsp:include>
</div>


<!--

<table width='100%' cellpadding='3' cellspacing='0' BORDER='0'>
	<tr><td class='DEFAULTBLANKROW' colspan=4 height="4"></td></tr>
	</table>
	

-->
	<BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>
	<BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>




	<!-- Added by Sridhar on 5 JUNE 2004 -->
	 
	 
	 <input type="hidden"  name="isModifyDiscTypeStatusAppl" id="isModifyDiscTypeStatusAppl" value="<%=isModifyDiscTypeStatusAppl%>"> <!--added by mujafar for ML-MMOH-CRF-0659 -->
	 <input type="hidden"  name="absconded_date" id="absconded_date" value="<%=absconded_date%>">
	 <input type="hidden" name="allow_modify_disc_yn" id="allow_modify_disc_yn" value="<%=allow_modify_disc_yn%>"> <!--added by mujafar for ML-MMOH-CRF-0659 -->
	 
	 
	 
	 <input type="hidden"  name="serverDate_display" id="serverDate_display" value="<%=serverDate_display%>">
	
	<input type="hidden"  name="admission_date_time" id="admission_date_time" value="<%=admission_date_time%>">
	<input type="hidden"  name="practitioner_short_name" id="practitioner_short_name" value="<%=practitioner_name%>">
	<input type="hidden"  name="admission_short_desc" id="admission_short_desc" value="<%=admission_short_desc%>">
	<input type="hidden"  name="specialty_short_desc" id="specialty_short_desc" value="<%=specialty_short_desc%>">
	<input type="hidden"  name="medical_team" id="medical_team" value="<%=meddesc%>">
	<input type="hidden"  name="patient_type_short_desc" id="patient_type_short_desc" value="<%=patient_type_short_desc%>">
	<input type="hidden"  name="nursing_unit_short_desc" id="nursing_unit_short_desc" value="<%=nursing_unit_short_desc%>">
	<input type="hidden"  name="service_short_desc" id="service_short_desc" value="<%=service_short_desc%>">
	<input type="hidden"  name="bed_no" id="bed_no" value="<%=bed_no%>">
	<input type="hidden"  name="room_no" id="room_no" value="<%=room_no%>">
	<input type="hidden"  name="bed_class_short_desc" id="bed_class_short_desc" value="<%=bed_class_short_desc%>">
	<input type="hidden" name="valubles" id="valubles" value=""> 
	<input type="hidden" name="recorded_by" id="recorded_by" value=""> 
	<input type="hidden" name="recorded_date" id="recorded_date" value=""> 
	<input type="hidden" name="valuble_remakrs" id="valuble_remakrs" value="">
	<input type="hidden" name="witness_desc" id="witness_desc" value="">
	<input type="hidden" name="witness_id" id="witness_id" value="">	
	<input type="hidden" name="cnt_vals" id="cnt_vals" value="<%=cnt%>"> 
	<!-- Hidden values for schedule appointment-->
	<input type="hidden" name="patient_id" id="patient_id"  value ="<%=patient_id%>" >
	<input type="hidden" name="location_type" id="location_type"  value ="<%=locn_type%>" >
	<input type="hidden" name="location_code" id="location_code"  value ="<%=locn_code%>" >
	<input type="hidden" name="i_practitioner_id" id="i_practitioner_id"  value ="<%=practitioner_id%>" >
	<input type="hidden" name="i_clinic_code" id="i_clinic_code"  value ="<%=locn_code%>" >
	<input type="hidden" name="i_appt_ref_no" id="i_appt_ref_no"  value ="">
	<input type="hidden" name="i_appt_date" id="i_appt_date"  value ="">
	<input type="hidden" name="callingMode" id="callingMode"  value ="OP">
	<!-- End of the addition of hidden values to schedule appointment-->
	<input type='hidden' name='patient_status' id='patient_status' value="<%=patient_status%>">
	<input type="hidden" name="patient_Id" id="patient_Id" value="<%=patient_id%>">
	<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounterid%>">
	<input type="hidden" name="bed_type_code" id="bed_type_code" value="<%=bed_type_code%>">
	<input type="hidden" name="bed_class_code" id="bed_class_code" value="<%=bed_class_code%>">
	<input type="hidden" name="practitioner_id" id="practitioner_id" value="<%=practitioner_id%>">
	<input type="hidden" name="specialty_code" id="specialty_code" value="<%=specialty_code%>">
	<input type="hidden" name="nursing_unit_code" id="nursing_unit_code" value="<%=nursing_unit_code%>">
	<input type="hidden" name="patient_type_code" id="patient_type_code" value="<%=patient_type%>">
	<input type="hidden" name="service_code" id="service_code" value="<%=service_code%>">
	<input type="hidden" name="subservice_code" id="subservice_code" value="<%=subservice_code%>">
	<input type="hidden" name="gender" id="gender" value="<%=gender%>">
	<input type="hidden" name="dischargeafterhrs" id="dischargeafterhrs" value="<%=discharge_after_hrs%>">
	<input type="hidden" name="sysdatetime" id="sysdatetime" value="<%=serverDate%>">
	<input type="hidden" name="curdateWithoutTime" id="curdateWithoutTime" value="<%=curdateWithoutTime%>">
	<input type="hidden" name="open_to_all_pract_yn" id="open_to_all_pract_yn" value="">
	<input type="hidden" name="from_hcare_setting_type_code" id="from_hcare_setting_type_code" value="<%=from_hcare_setting_type_code%>">	
	<input type="hidden" name="disdatechkdays" id="disdatechkdays" value="<%=dis_date_chk_days%>">	
	<input type="hidden" name="disdatechkdaysunit" id="disdatechkdaysunit" value="<%=dis_date_chk_days_unit%>">	
	<input type="hidden" name="hcare_setting_type_desc" id="hcare_setting_type_desc"  value ='' >
	<input type="hidden" name="medicalteam" id="medicalteam" value="<%=medteamid%>">
	<input type="hidden" name="locn_type_val" id="locn_type_val" value="<%=to_locn_type%>">		
	<input type="hidden" name="SickLeaveRecordFlag" id="SickLeaveRecordFlag" value="N">
	<input type="hidden" name="SickLeaveDetails" id="SickLeaveDetails" value="">
	<input type="hidden" name="SickLeaveDetails1" id="SickLeaveDetails1" value="">
	<input type="hidden" name="server_date" id="server_date" value="<%=serverDate%>">
	<input type="hidden" name="ref_code" id="ref_code" value="<%=to_ref_code%>">
	<input type="hidden" name="serv_code" id="serv_code" value="<%=to_service_code%>">
	<input type="hidden" name="locn_type" id="locn_type" value="<%=to_locn_type%>">
	<input type="hidden" name="locn_code_value" id="locn_code_value" value="<%=to_locn_code%>">
	<input type="hidden" name="to_specialty_code" id="to_specialty_code" value="<%=to_specialty_code%>">
	<input type="hidden" name="accomp_person" id="accomp_person" value="">
	<input type="hidden" name="location_val" id="location_val" value="" >
	<input type="hidden" name="location1_desc" id="location1_desc" value="" >
	<input type="hidden" name="patient_class_value" id="patient_class_value" value="<%=patient_class%>" >
	<input type="hidden" name="target_date" id="target_date" value="<%=target_date%>" >
	<input type="hidden" name="max_disch_period_for_dc" id="max_disch_period_for_dc" value="<%=max_disch_period_for_dc%>" >
	<div id = 'sep'><input type="hidden" name="seperator" id="seperator" value="abc"></div>
	<input type="hidden" name="countValue" id="countValue" value="<%=countValue%>" >
	<input type="hidden" name="ageValue" id="ageValue"  >
	<input type='hidden' name='help_function_id' id='help_function_id' value='DISCHARGE_PAT'>
	<input type='hidden' name='dead_yn' id='dead_yn' value="<%=dead_yn%>">
	<input type='hidden' name='post_mortem_req_yn' id='post_mortem_req_yn' value="<%=post_mortem_req_yn%>">
	<input type='hidden' name='maternal_death_yn' id='maternal_death_yn' value="<%=maternal_death_yn%>">
	<input type='hidden' name='diag_update_period_max_unit' id='diag_update_period_max_unit' value="<%=diag_update_period_max_unit%>">
	<input type='hidden' name='deactivate_pseudo_bed_yn' id='deactivate_pseudo_bed_yn' value="<%=deactivate_pseudo_bed_yn%>">
	<input type='hidden' name='pseudo_bed_yn' id='pseudo_bed_yn' value="<%=pseudo_bed_yn%>">
	<input type="hidden" name="mother_status" id="mother_status" value="<%=mother_status%>">
	<input type="hidden" name="mother_bed_status" id="mother_bed_status" value="">
	<input type="hidden" name="bl_operational" id="bl_operational" value="<%=bl_operational%>">
	<input type="hidden" name="bl_interfaced_yn" id="bl_interfaced_yn" value="<%=bl_interfaced_yn%>">
	<input type="hidden" name="sStyle" id="sStyle" value="<%=sStyle%>">
	<input type='hidden' name="valid" id="valid" value="<%=valid%>">
	<input type='hidden' name="from_time" id="from_time" value="<%=from_time%>">
	<input type='hidden' name="max_param_date" id="max_param_date" value="<%=max_param_date%>">
	<input type='hidden' name="valid_date" id="valid_date" value="<%=valid_date%>">
	<input type='hidden' name="proceed" id="proceed" value="Y">
	<input type='hidden' name="ip_Trn_Date" id="ip_Trn_Date" value="<%=ip_Trn_Date%>">
	<input type='hidden' name="locale1" id="locale1" value="<%=locale%>">
	<!--Maheshwaran K commented for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013-->
	<!--<input type='hidden' name='mr_mds_recorded' id='mr_mds_recorded' value="<%/*=mr_mds_recorded*/%>">-->
	<input type='hidden' name='contact1_name' id='contact1_name' value='<%=contact1_name%>'>
	<input type='hidden' name='contact2_name' id='contact2_name' value='<%=contact2_name%>'>
	<!-- Added by Dharma on Oct 29th against HSA-CRF-0181 [IN:049541] Start -->
	<input type="hidden" name="weight_on_admission" id="weight_on_admission" value="">
	<input type="hidden" name="weight_on_admission_unit" id="weight_on_admission_unit" value="">
	<!-- Added by Dharma on Oct 29th against HSA-CRF-0181 [IN:049541] End -->
	
	<!-- Added by KAMATCHI S on 23-JUN-2020 fro ML-MMOH-CRF-1527 -->
	<input type="hidden" name="height_on_admission" id="height_on_admission" value="">
	<input type="hidden" name="height_on_admission_unit" id="height_on_admission_unit" value="">
	<input type="hidden" name="bmi" id="bmi" value="">
	
	<input type="hidden"  name="isHeightAndBmiEnable" id="isHeightAndBmiEnable" value="<%=isHeightAndBmiEnable%>">
	<!-- Added by KAMATCHI S on 23-JUN-2020 fro ML-MMOH-CRF-1527 End -->

   <!--Added for this CRF HSA-CRF-0263.1 -->
	<input type="hidden" name="allow_muti_bedside_review_yn" id="allow_muti_bedside_review_yn" value="<%=allow_muti_bedside_review_yn%>">
	<!-- End HSA-CRF-0263.1 -->
	<!--Added for this CRF HSA-CRF-0306.1 -->
	<input type="hidden" name="daycare_unit_code" id="daycare_unit_code" value="<%=daycare_unit_code%>">
	<input type="hidden" name="death_reg_form_accession_num" id="death_reg_form_accession_num" value="<%=death_reg_form_accession_num%>"><!-- Added by Ajay Hatwate for AAKH-CRF-0179 -->
	<input type ='hidden' name= 'callback_mode' value="View">
		
</form>
<script>

	disableAllFields();

	if ("<%=informed_to%>" != "")
	{
		document.getElementById('im').style.visibility = "Visible";
	}
	
	// To perform Neo-natal Discharge if the patient is less than two days old.
	var date_of_birth	=	"<%=date_of_birth%>";
	var dobArray		=	new Array();
	var sysDate			=	new Date();
	var dateValue		=	sysDate.getDate();
	var monthValue		=	sysDate.getMonth();
	var yearValue		=	sysDate.getYear();
	var ageValue;
	dobArray	= date_of_birth.split("/");

	if ( (Math.abs(dobArray[2]) == Math.abs(yearValue)) && (Math.abs(dobArray[1]) == Math.abs(monthValue)) )
	{
		ageValue = eval(dateValue) - eval(dobArray[0]); 
	}
	document.forms[0].ageValue.value = Math.abs(ageValue);
	if (isNaN(document.forms[0].ageValue.value))
		document.forms[0].ageValue.value = "";

  </script>

<%
	if(Type_indicator.equals("AB"))
		out.println("<script>document.DischargePatient_form.absconding_date.disabled = true;</script>");

	/// If the value of DECEASED_YN field from ip_discharge_type table...is "Y" the referral Details are disabled as the patient is dead else Enabled ...
	if(cnt.equals("0"))
	{	
		out.println("");
		//out.println("<script>parent.frames[3].document.getElementById('valuble').disabled = true;</script>");
	}
	else if(patient_status.equals("3"))
	{	%>
		<script>
			document.forms[0].bookingappointment.disabled				= true;
			document.getElementById('calImage').disabled								= true;
		</script>
<%	}
	else if(patient_status.equals("") && Type_indicator.equals("AB"))
	{
		out.println("<script>document.getElementById('calImage').disabled=true;</script>");

	}
	else if(patient_status.equals("4"))
	{ 
		out.println("<script>document.forms[0].bookingappointment.disabled=true;</script>");
	}
	
	if(rset!=null) rset.close();
	if(rset1!=null) rset1.close();
	if(stmt!=null) stmt.close();
	//if(hash!=null) hash.clear();

	}catch(Exception e)
	{
		//out.print("Exception @ addModifyDischargePatientTabs.jsp"+e);
		e.printStackTrace();
	}	
	finally   
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
	</body>
</html>
<%!
	// By Annadurai 2/23/2004 starts., to handle NullPointerException.
	public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
	}
%>

