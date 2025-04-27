<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import="java.sql.*, java.util.*, java.text.*, webbeans.eCommon.*,com.ehis.util.*,org.json.simple.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<html>
<head>
<% 
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String sStyle	=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<!-- <script src='../../eOP/js/dchk.js' language='javascript'></script> -->
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<script language='javascript' src='../../eOP/js/PatCheckout.js'></script>
	<script language='javascript' src='../../eOP/js/OPPractitionerComponent.js'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script language='javascript' src='../../eCA/js/CAMenu.js'></script>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<!--  <script src='../../eCommon/js/dchk.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
  -->
	</head>
	
<style>
textarea {
  resize: none;
}
</style>	

<%Connection conn=null;
	PreparedStatement pstmt   =null;		
	PreparedStatement pstmt1   =null;

	PreparedStatement pstmt2  =null;
	//Maheshwaran K added for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013

	Statement stmt_mds        = null;  //Added by Sangeetha for ML-MMOH-CRF-0630
	ResultSet rs_mds          = null;
	ResultSet rset            = null;
	ResultSet rs            = null;
	ResultSet rs1            = null;
	ResultSet rs2            = null;
	
	PreparedStatement prepstmt = null;
	ResultSet rsset = null;
	
	/*Added by Thamizh selvi on 26th Mar 2018 against ML-MMOH-CRF-646 Start*/
	Boolean isCaseDtlsRadioBtnAppl	= false;
	String OandGYn					= "N";
	String traumaYn					= "N";
	String osccYn					= "N";
	String nonEmergYn				= "N";
	String checkedOandGYn			= "";
	String checkedTraumaYn			= "";
	String checkedOsccYn			= "";
	String checkedNonEmergYn		= "";
	String mechInjCatgCode			= "";
	String mechInjSubCatgCode		= "";
	/*End*/
	String DispositionType          = "";//Added by Shanmukh for ML-MMOH-CRF-0626 on 17-04-2018

	//Added by Ashwini on 18-Jan-2021 for ML-MMOH-CRF-1409
	Boolean isReconfirmCOTAppl = false;
	String reconf_cot_param = "";
	Boolean isDeathRegisterFormAppl = false;//Added by Ajay Hatwate for AAKH-CRF-0179 on 07/08/2023

	//Added by Ashwini on 08-Jul-2024 for ML-MMOH-CRF-2114.1
	Boolean isMDSForMainProcAppl = false;
	Boolean rcmApplicable = false;
	String mr_mainproc_recorded = "";

	//Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742
	Boolean isDeceasedDiagClassDeathRegAppl = false;
	String primary_diag_class = "";
	String pri_mand_postmortem_op_yn = "N";
	String pri_mand_postmortem_ae_yn = "N";
	String pri_mand_non_postmortem_op_yn = "N";
	String pri_mand_non_postmortem_ae_yn = "N";
	String secondary_diag_class = "";
	String sec_mand_postmortem_op_yn = "N";
	String sec_mand_postmortem_ae_yn = "N";
	String sec_mand_non_postmortem_op_yn = "N";
	String sec_mand_non_postmortem_ae_yn = "N";
	String practitioner_type = "";
	String date_of_birth = "";

   try{

	conn=ConnectionManager.getConnection (request);
	/*Below line(s) added by venkateshs against ML-MMOH-CRF-0354 [IN057191] */
	boolean siteSpecific		=eCommon.Common.CommonBean.isSiteSpecific(conn, "MR","MLC_TO_MEDICO_LEGAL_CASE"); 
	/*end ML-MMOH-CRF-0354 [IN057191] */
	
	Boolean isLabelChngAppl =eCommon.Common.CommonBean.isSiteSpecific(conn, "AE","LABEL_CHG_BR_DEAD_PLACE_ACCDNT"); //Added by Ashwini on 18-Jan-2017 for GDOH-CRF-0123 

	Boolean enableBIDOnCheckout  =eCommon.Common.CommonBean.isSiteSpecific(conn, "AE","ENABLE_BID_ON_CHECKOUT");  //Added by Sangeetha on 05/may/17 for ML-MMOH-CRF-0628

	Boolean isDIDCallNtAroundAppl = eCommon.Common.CommonBean.isSiteSpecific(conn, "AE","DID_CALLNOTAROUND_NOT_REQ_DGN"); //Added by Thamizh selvi on 27th Nov 2017 against ML-MM0H-CRF-0783

	isCaseDtlsRadioBtnAppl = eCommon.Common.CommonBean.isSiteSpecific(conn, "AE","SEC_TRIAGE_CASE_DETAILS");//Added by Thamizh selvi on 26th Mar 2018 against ML-MMOH-CRF-646
	
	Boolean isAutoCompDispTypeAppl = eCommon.Common.CommonBean.isSiteSpecific(conn, "OP","AUTO_COMP_DISP_TYPE"); //Added by Shanmukh on 17-Apr-2018 against ML-MMOH-CRF-0626

	Boolean isDischargeClearanceAppl = eCommon.Common.CommonBean.isSiteSpecific(conn, "BL","BL_AE_DISC_CLEAR_YN"); //Added by Ashwini on 22-Oct-2018 for GHL-CRF-0514 

	//Added by Ashwini on 18-Jan-2021 for ML-MMOH-CRF-1409
	isReconfirmCOTAppl = eCommon.Common.CommonBean.isSiteSpecific(conn, "AE", "RECONFIRM_CASE_OF_TRAUMA");
	isDeathRegisterFormAppl = eCommon.Common.CommonBean.isSiteSpecific(conn, "AE", "DEATH_REGISTER_FORM_APPL"); //Added by Ajay Hatwate for AAKH-CRF-0179 on 08-08-2023

	//Added by Ashwini on 08-Jul-2024 for ML-MMOH-CRF-2114.1
	isMDSForMainProcAppl = eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","MDS_FOR_MAIN_PROCEDURE");
	
	rcmApplicable = eCommon.Common.CommonBean.isSiteSpecific(conn,"BL","RCM_TRANS_FIELDS_MOH");

	isDeceasedDiagClassDeathRegAppl = eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","DECEASED_DIAG_CLASS_DEATH_REG");//Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742
		
	String locale=(String)session.getAttribute("LOCALE"); 
	StringBuffer sql               = new StringBuffer();
	StringBuffer sql1              = new StringBuffer();
	String userid                  = (String) session.getValue("login_user");
    String practitioner_name       = "";
	String  service_desc="";
	String open_to_all_prac_for_clinic_yn	= request.getParameter("open_to_all_prac_for_clinic_yn");
	if(open_to_all_prac_for_clinic_yn == null)	
		open_to_all_prac_for_clinic_yn = "";
    String open_to_all_pract_yn	= request.getParameter("open_to_all_pract_yn");
	if(open_to_all_pract_yn == null)	
		open_to_all_pract_yn = "N";

	String treatment_area_code	= request.getParameter("treatment_area_code");
	if(treatment_area_code == null || treatment_area_code.equals("null"))	
		treatment_area_code = "";
    String episode_type="";
	String visit_type_code="";
	String diagrecord="";
	String notesrecord="";
	String diagReqd="N";
	String notesReqd="N";
	String dispReqd="N";
	String OsVal = "";
	String modified_date="";
	String vital_signs_date_time="";
	String arrive_date_time="";
	String close_pat_chart_on_checkout_yn="";
	String fac_id       = (String) session.getValue( "facility_id" ) ;
	String called_from=request.getParameter("called_from");
	String five_level_triage_appl_yn = "N";
	String rec_diag_not_mdt_absconded = "N";   //Added by Sangeetha for ML-MMOH-CRF-0630
	String rec_diag_not_mdt_bid = "N";   //Added by Sangeetha for ML-MMOH-CRF-0624

	/*Added by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657*/
	JSONObject aeParamJson		= new JSONObject();
	aeParamJson					= eAE.AECommonBean.getAEParam(conn, fac_id);
	String invokeRecallForAE	= (String)aeParamJson.get("invokeRecallForAE");
	/*End ML-MMOH-CRF-0657*/
	//Added by Ashwini on 18-Jan-2021 for ML-MMOH-CRF-1409
	reconf_cot_param			= (String)aeParamJson.get("reconfirm_case_of_trauma");

	/*Added by Thamizh selvi on 28th Nov 2017 against ML-MMOH-CRF-0783 Start*/
	String recDiagNotMdtFrDid			= "N";
	String recDiagNtMdtFrCallNtAround	= "N";
	/*End*/

		/*Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742*/
		String sqlmrparam = " SELECT b.primary_diag_class, b.pri_mand_postmortem_op_yn, b.pri_mand_postmortem_ae_yn, b.pri_mand_non_postmortem_op_yn, b.pri_mand_non_postmortem_ae_yn, b.secondary_diag_class, b.sec_mand_postmortem_op_yn, b.sec_mand_postmortem_ae_yn, b.sec_mand_non_postmortem_op_yn, b.sec_mand_non_postmortem_ae_yn FROM mr_parameter b ";

		prepstmt = conn.prepareStatement(sqlmrparam);
		rsset = prepstmt.executeQuery();
		
		if ((rsset != null) && (rsset.next())) {

			primary_diag_class = rsset.getString("primary_diag_class");
		    if(primary_diag_class == null) primary_diag_class = "";

			pri_mand_postmortem_op_yn = rsset.getString("pri_mand_postmortem_op_yn");
		    if(pri_mand_postmortem_op_yn == null) pri_mand_postmortem_op_yn = "N";

			pri_mand_postmortem_ae_yn = rsset.getString("pri_mand_postmortem_ae_yn");
		    if(pri_mand_postmortem_ae_yn == null) pri_mand_postmortem_ae_yn = "N";

			pri_mand_non_postmortem_op_yn = rsset.getString("pri_mand_non_postmortem_op_yn");
		    if(pri_mand_non_postmortem_op_yn == null) pri_mand_non_postmortem_op_yn = "N";

			pri_mand_non_postmortem_ae_yn = rsset.getString("pri_mand_non_postmortem_ae_yn");
		    if(pri_mand_non_postmortem_ae_yn == null) pri_mand_non_postmortem_ae_yn = "N";

			secondary_diag_class = rsset.getString("secondary_diag_class");
		    if(secondary_diag_class == null) secondary_diag_class = "";

			sec_mand_postmortem_op_yn = rsset.getString("sec_mand_postmortem_op_yn");
		    if(sec_mand_postmortem_op_yn == null) sec_mand_postmortem_op_yn = "N";

			sec_mand_postmortem_ae_yn = rsset.getString("sec_mand_postmortem_ae_yn");
		    if(sec_mand_postmortem_ae_yn == null) sec_mand_postmortem_ae_yn = "N";

			sec_mand_non_postmortem_op_yn = rsset.getString("sec_mand_non_postmortem_op_yn");
		    if(sec_mand_non_postmortem_op_yn == null) sec_mand_non_postmortem_op_yn = "N";

			sec_mand_non_postmortem_ae_yn = rsset.getString("sec_mand_non_postmortem_ae_yn");
		    if(sec_mand_non_postmortem_ae_yn == null) sec_mand_non_postmortem_ae_yn = "N";
		}

		if(prepstmt!=null) prepstmt.close();
		if(rsset!=null) rsset.close();

		/*End ML-MMOH-CRF-1742*/
	
	String caseTypeYn = "";
	String caseTypeMandYn = "";
	String caseType="";
	
	if(called_from == null || called_from.equals("null") ) called_from="";
	
	String sqlqry1	= "select five_level_triage_appl_yn, REC_DIAG_NOT_MDT_ABSCONDED, REC_DIAG_NOT_MDT_BID, REC_DIAG_NOT_MDT_DID_YN, REC_DIAG_MDT_CALLNOTAROUND_YN, case_type_yn, case_type_mand_yn from ae_param where OPERATING_FACILITY_ID='"+fac_id+"'"; //Modified by Sangeetha or ML-MMOH-CRF-0624
	pstmt = conn.prepareStatement(sqlqry1);
	rset = pstmt.executeQuery();
	
	while(rset!=null && rset.next()){
		five_level_triage_appl_yn			=	(rset.getString("five_level_triage_appl_yn")==null || rset.getString("five_level_triage_appl_yn")=="")?"N":rset.getString("five_level_triage_appl_yn");

		rec_diag_not_mdt_absconded			=	(rset.getString("rec_diag_not_mdt_absconded")==null || rset.getString("rec_diag_not_mdt_absconded")=="")?"N":rset.getString("rec_diag_not_mdt_absconded");   //Added by Sangeetha for ML-MMOH-CRF-0630

		rec_diag_not_mdt_bid			=	(rset.getString("rec_diag_not_mdt_bid")==null || rset.getString("rec_diag_not_mdt_bid")=="")?"N":rset.getString("rec_diag_not_mdt_bid");   //Added by Sangeetha for ML-MMOH-CRF-0624
		/*Added by Thamizh selvi on 28th Nov 2017 against ML-MMOH-CRF-0783 Start*/
		recDiagNotMdtFrDid				=	(rset.getString("REC_DIAG_NOT_MDT_DID_YN")==null || rset.getString("REC_DIAG_NOT_MDT_DID_YN").equals("")) ? "N" : rset.getString("REC_DIAG_NOT_MDT_DID_YN");
		recDiagNtMdtFrCallNtAround		=	(rset.getString("REC_DIAG_MDT_CALLNOTAROUND_YN")==null || rset.getString("REC_DIAG_MDT_CALLNOTAROUND_YN")=="") ? "N" : rset.getString("REC_DIAG_MDT_CALLNOTAROUND_YN");
		/*End*/
		/* Added by Ajay Hatwate for ML-MMOH-CRF-1653 */
		caseTypeYn = (rset.getString("case_type_yn")==null || rset.getString("case_type_yn")=="") ? "N" : rset.getString("case_type_yn");
		caseTypeMandYn = (rset.getString("case_type_mand_yn")==null || rset.getString("case_type_mand_yn")=="") ? "N" : rset.getString("case_type_mand_yn");
		/* End of ML-MMOH-CRF-1653 */
	}
	if(pstmt!=null) pstmt.close();
	if(rset!=null) rset.close();

	
	
	
	
	
	    /*Below line added for this CRF Bru-HIMS-CRF-133*/		
		 String isPatientEncMovement = request.getParameter("isPatientEncMovement")==null?"":request.getParameter("isPatientEncMovement");
		 String Sydate = request.getParameter("Sydate")==null?"":request.getParameter("Sydate");
		 //End Bru-HIMS-CRF-133

	String ca_practitioner_id="";
	String ca_pract_type="";
	String mr_mds_recorded = "N";//Maheshwaran K added for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
	String allow_chkout_with_bill_stmt_yn  = request.getParameter("allow_chkout_with_bill_stmt_yn");
	if(allow_chkout_with_bill_stmt_yn== null)    allow_chkout_with_bill_stmt_yn = "N";

    String p_episode_id					= request.getParameter("episode_id");
	if(p_episode_id== null)    p_episode_id = "";

	 String bed_no					= request.getParameter("bed_no");
	if(bed_no== null)    bed_no = "";

	String ae_bed_calYN					= request.getParameter("ae_bed_calYN");
	if(ae_bed_calYN== null)    ae_bed_calYN = "";
	


	if(called_from.equals("CA"))
	{
		ca_practitioner_id=(String) session.getValue("ca_practitioner_id") ;
	    if(ca_practitioner_id == null)ca_practitioner_id="";
	}	
	
	String P_encounter_id=request.getParameter("encounterid");
	String P_practitioner_id = request.getParameter("practitionerid");
	if(P_practitioner_id== null)    P_practitioner_id = "";
	if(P_practitioner_id.equals("null"))    P_practitioner_id = "" ;

	String P_locn_code = request.getParameter("locationcode");
	if(P_locn_code==null)   P_locn_code = "" ;
	if(P_locn_code.equals("null"))   P_locn_code = "" ;
	String P_patient_id = (request.getParameter("patientid") == null)?"":request.getParameter("patientid");
	String bl_install_yn=(String) session.getValue( "bl_operational" ) ;	

	String P_locn_type = request.getParameter("locationtype");	
	String visit_id = request.getParameter("visit_id")==null?"":request.getParameter("visit_id");	

	String p_queue_date="";
	if(P_locn_type==null)   P_locn_type = "" ;
	if(P_locn_type.equals("null"))   P_locn_type = "" ;     
	String P_module_id = request.getParameter("module_id");
	if(P_module_id == null) P_module_id = "OP" ;
	if(P_module_id.equals(""))  P_module_id = "OP" ;	
	
	String p_calling_function    = request.getParameter("p_calling_function");
	p_calling_function           = (p_calling_function==null)?"":p_calling_function;
	
	String P_ae_brought_dead_yn = request.getParameter("ae_brought_dead_yn");

	if(P_ae_brought_dead_yn == null)    P_ae_brought_dead_yn = "N" ;
	String P_ae_treatment_area_code = request.getParameter("ae_treatment_area_code");
	if(P_ae_treatment_area_code == null || P_ae_treatment_area_code.equals("null"))    P_ae_treatment_area_code = "";/*null is checked for String by Rameswar for ML-MMOH-SCF-0446 on 10-Aug-16*/
	if(P_ae_treatment_area_code.equals(" "))    P_ae_treatment_area_code = "";
	String disable_all = ( P_ae_brought_dead_yn.equals("Y")?"disabled":"");
	String patient_class="";
	int mother_cut_off_age=0;
	int mother_max_age=0;
	int mother_min_age=0; 	
	String appt_id="";
	String visit_adm_type_ind="";
	   
	String X_visit_type_desc    ="";
	String X_attend_prac_id     ="";
	String X_episode_id ="";	
	String system_date="";
	String system_time="";
	String systemdatetime="";
	String visit_adm_date_time="";
	String check_out_yn="";
	String oper_stn_id=request.getParameter("oper_id")==null?"":request.getParameter("oper_id");
	String episode_visit_num="";
	String specl_code ="";
	String systemdatetime_display = "";
	
	String system_datetime=""; //Added for this incident [62496]

	String qms_interfaced_yn = "";
	String queue_num = "";
	String room_num = "";
	//Maheshwaran K added for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
	//Start
	int mds_chk=0;
	String mode="";
	if(patient_class.equals("EM"))
	mode="EC";
	if(patient_class.equals("OP"))
	mode="OC";
	//End
	if(called_from.equals("CA"))
	 {   
		
		    String sql_new = "Select AM_OPER_STN_ACCESS_CHECK('"+fac_id+"','"+userid+"','X','','CHECKOUT_PAT_YN') FROM dual" ;  
            
			pstmt=conn.prepareStatement(sql_new);
            rs=pstmt.executeQuery();
            rs.next();
	        OsVal=rs.getString(1);
        
			if((!OsVal.equals("1")) && (!OsVal.equals("2")) && (!OsVal.equals("3")) && (!OsVal.equals("4")) && (!OsVal.equals("5")))
	        {
			   check_out_yn="Y";
			   
            }else
				{
				check_out_yn="N";
				}
	
		
	 }else
	 {
		 check_out_yn="Y";
	 }

	/*Added by Ashwini on 22-Oct-2018 for GHL-CRF-0514*/
	String retVal = "";
	CallableStatement cstmt = null;

	if(P_module_id.equals("AE") && isDischargeClearanceAppl)
	{
		try
		{
			cstmt = conn.prepareCall("{ call bl_ip_details.check_fin_clear_dur_ae_trx(?,?,?,?) }");
			cstmt.setString(1,"AE_CHECK_OUT");
			cstmt.setString(2,fac_id);
			cstmt.setString(3,p_episode_id);
			cstmt.registerOutParameter(4,java.sql.Types.VARCHAR);
			cstmt.execute();
			
			retVal = cstmt.getString(4);

				if (retVal == null) retVal = "";	

				if(retVal.equals(""))
				{
					check_out_yn = "Y";
				}
				else
				{				
					check_out_yn = "N";
					%><script>alert(getMessage('<%=retVal%>','BL'));
					window.close();
					history.go(-1);
					</script><%
				}

				if(cstmt != null) cstmt.close();
		}
		catch(Exception e) {
			//out.println(e.toString());
			e.printStackTrace();
		}
	}
	/*End GHL-CRF-0514*/

	String referral_id = "";	
	int patientage=0;
	String patientgender="";
	
	String X_pract_assigned_yn = "N";
	String mlc_yn="";
    String 	mlcchkval="";
	String pract_type="";
  
	String deceased_time="";
	String body_release_deceased_time="";
	String dronly="";
	String ddis="";
	String medical_yn="";
	String surgical_yn="";
	String spec_code="";
	int aecnt=0;
	String create_wait_list_yn="N";
	String modify_wait_list_yn="N";
	String create_wait_dis="disabled";
	String modify_wait_dis="disabled";
	String wait_list_no="";
	String reg_reff_chkout_yn="";
	String disposition_type="";	
	String install_yn="";	
	String waitlist_category_appl_yn="";				 
	String waitlist_category_reqd_yn="";
	String restrict_wl_cat_agst_splty_yn="";
	String customer_id="";
	String mr_mds_recorded_style="";//Maheshwaran K added for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
	String diag_recording_not_mndt="N"; //Added by Sangeetha for ML-MMOH-CRF-0547
	customer_id=(String)session.getAttribute("CUSTOMER_ID");
	String enable_death_reg_form = "N";//Added by Ajay Hatwate for AAKH-CRF-0179
	String death_reg_form_accession_num = "";//Added by Ajay Hatwate for AAKH-CRF-0179
	
	String multi_speciality_yn="N";
		try
		{
		  if(check_out_yn.equals("Y"))
		  {

/*
			pstmt=conn.prepareStatement("select install_yn from sm_module where module_id='CA'");
			rs=pstmt.executeQuery();
    		if(rs!=null && rs.next()) {			
				cainstall=rs.getString("install_yn");           
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();				
			if( cainstall.equals("Y"))
			CRF-362 AE bed charges start	
			String sql_ae_bed="SELECT NVL(AE_BED_CHARGE_APPL_YN,'N') ae_bed_charge FROM Bl_parameters Where  operating_facility_id = ?";
			pstmt=conn.prepareStatement(sql_ae_bed);
			pstmt.setString(1,fac_id);
			rs=pstmt.executeQuery();
			while(rs.next()){
				ae_bed_charge_appl_yn=rs.getString(1);
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();	
			CRF-362 AE bed charges complete
			pstmt = conn.prepareStatement("select MR_MDS_RECORDED_YN('"+fac_id+"','"+P_encounter_id+"','"+patient_class+"',null,'OC',null) from dual");
			rs=pstmt.executeQuery();
			if(rs != null && rs.next()){
				mr_mds_recorded = rs.getString(1) == null ? "N":rs.getString(1);
			}			
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
	*/		              
		/*Below query modified for this incident[62496]*/	
		sql.append("SELECT  a.SERVICE_CODE,am_get_desc.am_service(a.SERVICE_CODE,'"+locale+"',2)SERVICE_desc,  TO_CHAR(a.queue_date,'dd/mm/yyyy hh24:mi') visit_adm_date_time,a.patient_class ,a.LOCN_CODE assign_care_locn_code ,a.LOCN_TYPE assign_care_locn_type  ,a.VISIT_TYPE_CODE adm_type  ,op_get_desc.OP_VISIT_TYPE(facility_id,a.VISIT_TYPE_CODE,'"+locale+"',2) visit_type ,DECODE(a.practitioner_id,'*ALL','',a. practitioner_id) prac_id ,a.referral_id  ,CALCULATE_AGE(TO_CHAR(c.DATE_OF_BIRTH,'DD/MM/YYYY'),1)age ,TO_CHAR (c.date_of_birth, 'dd/mm/rrrr') date_of_birth, c.sex,a.arrive_date_time arrive_date_time ,a.vital_signs_date_time vital_signs_date_time,a.VISIT_TYPE_IND visit_adm_type_ind,a.appt_id appt_id  ,a.episode_id episode_id,a.OP_EPISODE_VISIT_NUM episode_visit_num,a.treatment_area_code treatment_area_code  ,(select mlc_yn from pr_encounter where encounter_id='"+P_encounter_id+"' and facility_id='"+fac_id+"') mlc_yn,(select case_type from pr_encounter where encounter_id='"+P_encounter_id+"' and facility_id='"+fac_id+"') case_type    ,TO_CHAR(c.DECEASED_DATE,'dd/mm/yyyy hh24:mi') deceased_time  ,a.medical_yn medical_yn  ,a.surgical_yn surgical_yn  ,a.trauma_yn, a.oscc_yn, a.o_and_g_yn, a.non_emerg_yn, a.mech_injury_catg_code, a.mech_injury_subcatg_code, a.SPECIALITY_CODE SPECIALTY_CODE,TO_CHAR(a.queue_date,'dd/mm/yyyy') queue_date,TO_CHAR(SYSDATE,'dd/mm/yyyy hh24:mi') sydate,  TO_CHAR(SYSDATE,'dd/mm/yyyy hh24:mi:ss') systemdate,am_get_desc.AM_PRACTITIONER(a.practitioner_id,'"+locale+"',1) practitioner_name,(select to_char(modified_date,'dd/mm/yyyy hh24:mi:ss') from pr_encounter where encounter_id='"+P_encounter_id+"' and facility_id='"+fac_id+"')modified_date,queue_num,room_num,(select multi_speciality_yn from op_clinic where CLINIC_CODE=a.LOCN_CODE and FACILITY_ID='"+fac_id+"') multi_speciality_yn, (SELECT DIAG_RECORDING_MAND_YN FROM op_clinic WHERE facility_id ='"+fac_id+"' AND clinic_code =a.LOCN_CODE) DIAG_RECORDING_MAND_YN");
	if(isDeathRegisterFormAppl){
		sql.append(", (select death_reg_form_accession_num from pr_encounter where facility_id = '"+fac_id+"' and encounter_id = "+ P_encounter_id +") accession_num ");
	}
	sql.append(" FROM  op_patient_queue a ,mp_patient c WHERE a.facility_id = '"+fac_id+"' AND a.encounter_id = '"+P_encounter_id+"' AND a.patient_id=c.patient_id");   // Modified by Sangeetha for ML-MMOH-CRF-0547
			//Modified above query by Thamizh selvi on 26th Mar 2018 against ML-MMOH-CRF-0646
			
			
			//sql.append("Select to_char(a.queue_date,'dd/mm/yyyy hh24:mi') visit_adm_date_time,a.patient_class,decode(a.patient_class,'EM','Emergency','OP','OutPatient') Nature, a.LOCN_CODE assign_care_locn_code, a.LOCN_TYPE assign_care_locn_type, ");
			//sql.append(" a.VISIT_TYPE_CODE adm_type,  b.short_desc visit_type, decode(a. practitioner_id,'*ALL','',a. practitioner_id) 	prac_id,a.referral_id,CALCULATE_AGE(TO_CHAR(c.DATE_OF_BIRTH,'DD/MM/YYYY'),1)age,c.sex,a.arrive_date_time arrive_date_time,a.vital_signs_date_time vital_signs_date_time,a.VISIT_TYPE_IND visit_adm_type_ind,a.appt_id appt_id,a.episode_id episode_id,a.OP_EPISODE_VISIT_NUM  episode_visit_num,a.treatment_area_code treatment_area_code,a.mlc_yn mlc_yn,to_char(c.DECEASED_DATE,'dd/mm/yyyy hh24:mi') deceased_time,a.medical_yn medical_yn,a.surgical_yn surgical_yn,a.SPECIALITY_CODE SPECIALTY_CODE,to_char(a.queue_date,'dd/mm/yyyy') queue_date, to_char(sysdate,'dd/mm/yyyy hh24:mi') sydate, d.practitioner_name from op_patient_queue a, OP_VISIT_TYPE b,mp_patient c, am_practitioner d");
			//sql.append(" where a.facility_id = '"+fac_id+"' and a.encounter_id = '"+P_encounter_id+"' and a.facility_id=b.facility_id and a.visit_type_code = b.visit_type_code and a.patient_id=c.patient_id and a.practitioner_id=d.practitioner_id(+)");			
			pstmt=conn.prepareStatement(sql.toString());
            rs = pstmt.executeQuery();
			if(rs!=null && rs.next())
			{                  
                       
				if(isDeathRegisterFormAppl){
					death_reg_form_accession_num = (rs.getString("accession_num")==null)?"":rs.getString("accession_num");
				}
				X_visit_type_desc = (rs.getString("visit_type") == null)?"":rs.getString("visit_type");
				X_attend_prac_id = (rs.getString("prac_id") == null)?"":rs.getString("prac_id");
				practitioner_name = (rs.getString("practitioner_name") == null)?"":rs.getString("practitioner_name");

				if(X_attend_prac_id == null)
					X_attend_prac_id="";
				
				P_locn_code = rs.getString("assign_care_locn_code") ;
				if(P_locn_code==null)   P_locn_code = "" ;
				P_locn_type = rs.getString("ASSIGN_CARE_LOCN_TYPE") ;
				if(P_locn_type==null)   P_locn_type = "" ;
                 service_desc=rs.getString("service_desc")==null?"":rs.getString("service_desc");
				referral_id = rs.getString("referral_id");
				if(referral_id == null || referral_id.equals("null")) referral_id = "";
				patient_class=(rs.getString("patient_class")== null)?"":rs.getString("patient_class");
				if(patient_class.equals("EM"))
				episode_type="E";	
				else
                episode_type="O";	 
				
				patientage=Integer.parseInt(rs.getString("age"));
				patientgender=(rs.getString("sex") == null)?"":rs.getString("sex");
				date_of_birth = (rs.getString("date_of_birth") == null)?"":rs.getString("date_of_birth");
				arrive_date_time= (rs.getString("arrive_date_time") == null)?"":rs.getString("arrive_date_time");
				vital_signs_date_time=(rs.getString("vital_signs_date_time") == null)?"":rs.getString("vital_signs_date_time");
				visit_adm_type_ind=(rs.getString("visit_adm_type_ind") == null)?"":rs.getString("visit_adm_type_ind");
				appt_id=(rs.getString("appt_id") == null)?"":rs.getString("appt_id");
				X_episode_id=(rs.getString("episode_id") == null)?"":rs.getString("episode_id");
				visit_type_code=(rs.getString("adm_type") == null)?"":rs.getString("adm_type");
				episode_visit_num =(rs.getString("episode_visit_num") == null)?"":rs.getString("episode_visit_num");
				modified_date =(rs.getString("modified_date") == null)?"":rs.getString("modified_date");
				queue_num =(rs.getString("queue_num") == null)?"":rs.getString("queue_num");
				room_num =(rs.getString("room_num") == null)?"":rs.getString("room_num");
				multi_speciality_yn =(rs.getString("multi_speciality_yn") == null)?"N":rs.getString("multi_speciality_yn");
				diag_recording_not_mndt=rs.getString("DIAG_RECORDING_MAND_YN");  //Added by Sangeetha for ML-MMOH-CRF-0547

				qms_interfaced_yn=eOP.QMSInterface.isClinicQMSInterfaced(P_locn_code,fac_id,conn);
				if(P_ae_treatment_area_code.equals(""))
				{
					P_ae_treatment_area_code=(rs.getString("treatment_area_code") == null)?"":rs.getString("treatment_area_code");
				}
				
				P_practitioner_id=X_attend_prac_id;

				mlc_yn=rs.getString("mlc_yn");
				if(mlc_yn == null) mlc_yn="N";
				
				caseType = rs.getString("case_type");
				if(caseType == null) caseType="";

				deceased_time=rs.getString("deceased_time");
				deceased_time=DateUtils.convertDate(deceased_time,"DMYHM","en",locale);
				if(deceased_time == null) deceased_time="";

				if(!deceased_time.equals(""))
				{
					dronly="";
					ddis="";
					body_release_deceased_time=deceased_time;
				}
				else
				{
					dronly="readOnly";
					ddis="disabled";
				}
				
				medical_yn=rs.getString("medical_yn");
				if(medical_yn == null) medical_yn="N";

				surgical_yn=rs.getString("surgical_yn");
				if(surgical_yn == null) surgical_yn="N";

				/*Added by Thamizh selvi against ML-MMOH-CRF-0645 Start*/
				traumaYn			= checkForDefault(rs.getString("trauma_yn"),"N");
				osccYn				= checkForDefault(rs.getString("oscc_yn"),"N");
				OandGYn				= checkForDefault(rs.getString("o_and_g_yn"),"N");
				nonEmergYn			= checkForDefault(rs.getString("non_emerg_yn"),"N");
				mechInjCatgCode		= checkForNull(rs.getString("mech_injury_catg_code"));
				mechInjSubCatgCode	= checkForNull(rs.getString("mech_injury_subcatg_code"));
				/*End*/

				visit_adm_date_time=rs.getString("visit_adm_date_time");
				if(visit_adm_date_time == null) visit_adm_date_time="";
				spec_code=rs.getString("SPECIALTY_CODE");
				if(spec_code == null) spec_code="";
				p_queue_date=rs.getString("queue_date");
				if(p_queue_date == null) p_queue_date="";
				systemdatetime = rs.getString("sydate");
  			    system_date = systemdatetime.substring(0,10);	
			    system_time = systemdatetime.substring(11,16);

				systemdatetime_display=DateUtils.convertDate(systemdatetime,"DMYHM","en",locale);				
                
				/*Below line added for this incident[62496]*/
                system_datetime	= rs.getString("systemdate");	
               // system_datetime = DateUtils.convertDate(system_datetime,"DMYHMS","en",locale);				
				
			}			
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();		
				sql.setLength(0);	

			/*Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742*/
			String sqlpract = " select pract_type, practitioner_name from AM_PRACTITIONER_LANG_VW where practitioner_id = '"+P_practitioner_id+"' and language_id = '"+locale+"' ";

			prepstmt = conn.prepareStatement(sqlpract);
			rsset = prepstmt.executeQuery();
			
			if ((rsset != null) && (rsset.next())) {
				practitioner_type = rsset.getString("pract_type");
			}

			if(prepstmt!=null) prepstmt.close();
			if(rsset!=null) rsset.close();
			/*End ML-MMOH-CRF-1742*/

				//Modified by Shanmukh for ML-MMOH-CRF-0626 on 17-04-2018
				//Maheshwaran K modified MR_MDS_RECORDED_YN for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
				StringBuffer sqlquery = new StringBuffer(); // sathya sai migrated issue Wednesday, June 09, 2010 Venkat s
				sqlquery.append("Select nvl(a.DISP_REQD_FOR_MDS_YN,'N') DISP_YN, nvl(a.DIAG_REQD_FOR_MDS_YN,'N') DIAG_YN, nvl(a.NOTES_REQD_FOR_MDS_YN,'N') NOTES_YN,a.REG_REFERRAL_ON_CHECKOUT_YN ,a.DISP_TYPE_FOR_CHECKOUT,a.DISP_TYPE_FOR_AUTO_VISIT_COMPL,a.close_pat_chart_on_checkout_yn, (select NVL(b.AE_BED_CHARGE_APPL_YN,'N') ae_bed_charge from Bl_parameters b where b.operating_facility_id='"+fac_id+"') ae_bed_charge, MR_MDS_RECORDED_YN('"+fac_id+"','"+P_encounter_id+"','"+patient_class+"',null,'"+mode+"',null) mr_mds_recorded, d.waitlist_category_appl_yn,d.waitlist_category_reqd_yn, d.restrict_wl_cat_agst_splty_yn,(select OPERATIONAL_YN from sm_modules_facility where module_id='OR' and facility_id=?) install_yn ");
				sqlquery.append(", c.ENBL_DEATH_REG_FORM_DECEASED ");//Added by Ajay Hatwate for AAKH-CRF-0179
				if (!patient_class.equals("EM")) {
					sqlquery.append(",AM_OPER_STN_ACCESS_CHECK('"+fac_id+"','"+userid+"','X','','CREATE_WAIT_LIST_YN') create_wait_list_yn, AM_OPER_STN_ACCESS_CHECK('"+fac_id+"','"+userid+"','X','','MODIFY_WAIT_LIST_YN') modify_wait_list_yn");
				 }
				if(patientgender.equals("F")) {
					sqlquery.append(",c.nb_mother_cutoff_age mother_cut_off_age, c.nb_mother_upper_age mother_max_age,c.nb_mother_min_age mother_min_age ");
				}
				sqlquery.append(" from OP_PARAM a , mp_param c , oa_param d where  a.operating_facility_id = ? and c.module_id = 'MP' and d.module_id = 'OA'  ");
			    String ae_bed_charge_appl_yn="";

				pstmt=conn.prepareStatement(sqlquery.toString());
				pstmt.setString(1,fac_id);
				pstmt.setString(2,fac_id);
				rs=pstmt.executeQuery();
				if(rs!=null  && rs.next())
				{	
					//Added by Shanmukh for ML-MMOH-CRF-0626 on 17-04-2018
					DispositionType=rs.getString("DISP_TYPE_FOR_AUTO_VISIT_COMPL");              
						if(DispositionType==null)		DispositionType="";
						
						//END
					dispReqd=rs.getString("DISP_YN");
					diagReqd=rs.getString("DIAG_YN");
					notesReqd=rs.getString("NOTES_YN");
		            reg_reff_chkout_yn=rs.getString("REG_REFERRAL_ON_CHECKOUT_YN");
			        disposition_type=rs.getString("DISP_TYPE_FOR_CHECKOUT");
				    ae_bed_charge_appl_yn=rs.getString("ae_bed_charge");		 
					install_yn=rs.getString("install_yn")==null?"N":rs.getString("install_yn");						
					waitlist_category_appl_yn=rs.getString("WAITLIST_CATEGORY_APPL_YN")==null?"N":rs.getString("WAITLIST_CATEGORY_APPL_YN");	 
					waitlist_category_reqd_yn=rs.getString("WAITLIST_CATEGORY_REQD_YN")==null?"N":rs.getString("WAITLIST_CATEGORY_REQD_YN");	
					restrict_wl_cat_agst_splty_yn=	rs.getString("RESTRICT_WL_CAT_AGST_SPLTY_YN")==null?"N":rs.getString("RESTRICT_WL_CAT_AGST_SPLTY_YN");	
					close_pat_chart_on_checkout_yn=rs.getString("close_pat_chart_on_checkout_yn")==null?"N":rs.getString("close_pat_chart_on_checkout_yn");				
					mr_mds_recorded = rs.getString("mr_mds_recorded") == null ? "N":rs.getString("mr_mds_recorded");//Maheshwaran K modified for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
					if(patientgender.equals("F")) {
						mother_cut_off_age=(rs.getString("mother_cut_off_age")	== null)?Integer.parseInt("0"):							Integer.parseInt(rs.getString("mother_cut_off_age"));
						mother_max_age=(rs.getString("mother_max_age")	== null)?Integer.parseInt("0"):Integer.parseInt(rs.getString("mother_max_age"));
						mother_min_age=(rs.getString("mother_min_age")	== null)?Integer.parseInt("0"):Integer.parseInt(rs.getString("mother_min_age"));
					}
					if (!patient_class.equals("EM")) {
						create_wait_list_yn = rs.getString("create_wait_list_yn");
						modify_wait_list_yn=rs.getString("modify_wait_list_yn");			
					}
				    if(disposition_type==null)disposition_type="";
				    enable_death_reg_form = rs.getString("ENBL_DEATH_REG_FORM_DECEASED")==null?"N":rs.getString("ENBL_DEATH_REG_FORM_DECEASED");//Added by Ajay Hatwate for AAKH-CRF-0179
				}				
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				
				if(diagReqd.equals("Y"))
				{
					String diagrecqry=" select 1 from  pr_problem where ONSET_FACILITY_ID='"+fac_id+"' and ONSET_ENCOUNTER_ID='"+P_encounter_id+"'";
					pstmt=conn.prepareStatement(diagrecqry);
					rs=pstmt.executeQuery();
					if(rs!=null && rs.next()) 
					{
						diagrecord=rs.getString("1");  
					}
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
	
				}

				if(notesReqd.equals("Y"))
				{
					String notesrecqry="SELECT 'Y' FROM CA_ENCNTR_NOTE WHERE FACILITY_ID='"+fac_id+"' AND ENCOUNTER_ID='"+ P_encounter_id+"' AND EVENT_STATUS!='9'";
					pstmt=conn.prepareStatement(notesrecqry);
					rs=pstmt.executeQuery();
					if(rs!=null && rs.next())	
					{
						notesrecord=rs.getString(1);  //notesRecorded
					} 
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
				}			
            if (!patient_class.equals("EM")) {									
				  if((!create_wait_list_yn.equals("1")) && (!create_wait_list_yn.equals("2")) && (!create_wait_list_yn.equals("3")) && (!create_wait_list_yn.equals("4"))) {
					  create_wait_list_yn="Y";
				  } else {
					 create_wait_list_yn="N";
				  }
				  if((!modify_wait_list_yn.equals("1")) && (!modify_wait_list_yn.equals("2")) && (!modify_wait_list_yn.equals("3")) && (!modify_wait_list_yn.equals("4"))) {
					 modify_wait_list_yn ="Y";						 
			     } else {
					 modify_wait_list_yn ="N";
				 }					
				 if(create_wait_list_yn.equals("Y") && modify_wait_list_yn.equals("Y")) {
					pstmt = conn.prepareStatement("SELECT wait_list_no FROM pr_wait_list WHERE facility_id = '"+fac_id+"' AND patient_id = '"+P_patient_id+"' AND wait_list_status='O' and specialty_code='"+spec_code+"' AND (preferred_date_time IS NULL OR preferred_date_time  >= SYSDATE) and rownum < 2 ");
					rs=pstmt.executeQuery();					
					if(rs != null) {
						if(rs.next()) {
							wait_list_no=rs.getString(1);							
						  }
					 }
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
				}
	      }
			if(create_wait_list_yn.equals("Y") && wait_list_no.equals(""))
			{
				create_wait_dis="";
				modify_wait_dis="disabled";
				
			}else if((modify_wait_list_yn.equals("Y")) && (!wait_list_no.equals("")))
			{
				create_wait_dis="disabled";
				modify_wait_dis="";
				
			}
		    if(P_module_id.equals("AE"))
  	        {
				create_wait_dis="disabled";
			}
			String msenable="disabled";
			String mscheck1="";
			String mscheck2="";
			String bdeaddis=""; 
	 if(P_module_id.equals("AE")) {
		 msenable="";
		 if(medical_yn.equals("Y"))
			 mscheck1="checked";
		 else
			 mscheck1="";
		 if(surgical_yn.equals("Y"))
			 mscheck2="checked";
		 else
			 mscheck2="";
		if(P_ae_brought_dead_yn.equals("Y")){
			//Added by Sangeetha for ML-MMOH-CRF-0628 on 8/may/17
			 if(enableBIDOnCheckout)
			 bdeaddis="";
			 else
			 bdeaddis="disabled";
		}
		else
			 bdeaddis="disabled";
		
		/*Added by Thamizh selvi against ML-MMOH-CRF-0645 Start*/
		if(traumaYn.equals("Y"))
			checkedTraumaYn		= "checked";
		else
			checkedTraumaYn		= "";
		if(osccYn.equals("Y"))
			checkedOsccYn		= "checked";
		else
			checkedOsccYn		= "";
		if(OandGYn.equals("Y"))
			checkedOandGYn		= "checked";
		else
			checkedOandGYn		= "";
		if(nonEmergYn.equals("Y"))
			checkedNonEmergYn	= "checked";
		else
			checkedNonEmergYn	= "";
		/*End*/
	  }
	  else
	  {
		  msenable="disabled";
		  if(medical_yn.equals("Y"))
			 mscheck1="checked";
		 else
			 mscheck1="";

		 if(surgical_yn.equals("Y"))
			 mscheck2="checked";
		 else
			 mscheck2="";
		bdeaddis="disabled";
	  }
	
	if(mlc_yn.equals("Y"))
	{
		mlcchkval="checked";
	}
	else
	{
		mlcchkval="";
	}
	//Maheshwaran K modified for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
	//Start
	try
		{
		//String sql_mds="select count(*) as cnt from mr_mds_for_patient_class where MANDATORY_FOR_"+patient_class+"_YN='Y'";
		String sql_mds_code="select MDS_CODE from mr_mds_for_patient_class where MANDATORY_FOR_"+patient_class+"_YN='Y'";  //Added by Sangeetha for ML-MMOH-CRF-0630

		//stmt=conn.createStatement();
		//rset=stmt.executeQuery(sql_mds);
		stmt_mds =conn.createStatement();    //Added by Sangeetha for ML-MMOH-CRF-0630
		rs_mds=stmt_mds.executeQuery(sql_mds_code);

		/*if(rset.next())
			{
			mds_chk=rset.getInt("cnt");
			}*/

        //Added by Sangeetha for ML-MMOH-CRF-0630
		while(rs_mds.next())
			{
			mds_chk++;
			out.println("<script>mds_code_arr[count]='"+rs_mds.getString("MDS_CODE")+"';count++;</script>"); 
			}

		if(stmt_mds!=null) stmt_mds.close();
		if(rs_mds!=null) rs_mds.close();
		}
	catch(Exception e)	
		{
		e.printStackTrace();
		}
	//End	
	%>
	<% if(P_module_id.equals("AE")){ %>
	<body onload="setTimeout('FocusFirstElement()',300);checkRecordButton();procedureUnitCheck();<%if(isDeathRegisterFormAppl  && enable_death_reg_form.equals("Y")){%> updDeathRegForm();<%} %>" onKeyDown ='lockKey()'>   <!--Modified by Sangeetha for ML-MMOH-CRF-0624 --> <!-- Modified by Ajay Hatwate for AAKH-CRF-0179 -->
	<% } else { %>
	<body onload="setTimeout('FocusFirstElement()',300);procedureUnitCheck()" onKeyDown ='lockKey()'> 
	<% } %>

	<form name="Checkout_form" id="Checkout_form" action='../../servlet/eOP.PatCheckoutServlet' method='post' target="Dummy_frame">
	<input type='hidden' name='help_function_id' id='help_function_id' value='CHECK_OUT'>

			<table border='0' align=center cellpadding='0' cellspacing='0' width='98%'  >
					
				<tr><td colspan=4>&nbsp;</td></tr>
				<tr>
				<td    class="label" width='25%'align="left"><fmt:message key="Common.visittype.label" bundle="${common_labels}"/></td>
				<td   class ='label'  width='49%' align="left" nowrap><b><%=X_visit_type_desc%></b>  </td>
				
					<%   
						if(called_from.equals("CA") && patient_class.equals("EM"))
						{
							pstmt=conn.prepareStatement("select PRACT_TYPE from am_practitioner where practitioner_id='"+ca_practitioner_id+"'");
							rs=pstmt.executeQuery();
							if(rs != null && rs.next())
							{
								ca_pract_type=rs.getString("PRACT_TYPE");
							}

							
							if(rs != null) rs.close();
							if(pstmt != null) pstmt.close();
						}
						if((!X_attend_prac_id.equals("") && !patient_class.equals("EM"))  || ((called_from.equals("CA") && !patient_class.equals("EM")) || ((called_from.equals("CA") && patient_class.equals("EM")) && (!ca_pract_type.equals("MD") && !ca_pract_type.equals("SG") && !ca_pract_type.equals("PS") && !ca_pract_type.equals("DN")))))
						{

							P_practitioner_id = X_attend_prac_id;
                            
							sql.append("select practitioner_name, am_get_desc.am_pract_type(pract_type,'"+locale+"','1')pract_type_desc from am_practitioner_lang_vw where practitioner_id = '"+X_attend_prac_id+"' and language_id='"+locale+"'");
                            pstmt=conn.prepareStatement(sql.toString());
                            rs = pstmt.executeQuery();                           
                                         
                            if(rs.next() )
                            {					
							  out.println("<td  class='label' width='15%' align='left'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+"</td>");
							  
                              out.println("<td class = querydata nowrap width='10%' align='right'><b>"+rs.getString( "practitioner_name" )+"/"+rs.getString( "pract_type_desc" )+"</b>");								
                                out.println(" <input type='hidden' name= 'attending_practitioner' id= 'attending_practitioner'  size='15' maxlength='15' value='"+X_attend_prac_id+"' readonly></td>");
                               
                            }   

							if(rs != null) rs.close();
							if(pstmt != null) pstmt.close();
							sql.setLength(0);
						}
						else
						{
							X_pract_assigned_yn = "Y";			

							if(P_module_id.equals("AE"))
							{
						
								if(!P_ae_treatment_area_code.equals(""))
								{
									sql.append("SELECT a.open_to_all_pract_yn open_to_all_pract_yn, a.pract_type,a.speciality_code,b.open_to_all_prac_for_clinic_yn open_to_all_prac_for_clinic_yn ,a.primary_resource_class primary_resource_class FROM op_clinic a, AE_TMT_AREA_FOR_CLINIC b WHERE a.facility_id = '"+fac_id+"' AND a.clinic_code ='"+P_locn_code+"' AND a.facility_id = b.facility_id AND b.CLINIC_CODE = a.clinic_code	AND B.TREATMENT_AREA_CODE = '"+P_ae_treatment_area_code+"'");
								}
								else
								{
									sql.append("SELECT a.open_to_all_pract_yn open_to_all_pract_yn, a.pract_type,a.speciality_code,a.primary_resource_class primary_resource_class FROM op_clinic a	WHERE a.facility_id ='"+fac_id+"' 	AND a.clinic_code ='"+P_locn_code+"'");
								}
					
							}
							else
							{

							sql.append("Select open_to_all_pract_yn, pract_type, speciality_code, primary_resource_class from OP_CLINIC where facility_id = '"+fac_id+"' and clinic_code = '"+P_locn_code+"' ");
							}
							pstmt=conn.prepareStatement(sql.toString());
							rs = pstmt.executeQuery();
							if(rs != null && rs.next())
							{

								String open_to_all_pract = (rs.getString("open_to_all_pract_yn") == null)?"N":rs.getString("open_to_all_pract_yn");
								if(open_to_all_pract_yn.equals("N"))
								{
									open_to_all_pract_yn=open_to_all_pract;
								}
					
								if(P_module_id.equals("AE") && open_to_all_prac_for_clinic_yn.equals(""))
								{
								 
									 if(!P_ae_treatment_area_code.equals(""))
									{
										 open_to_all_prac_for_clinic_yn=(rs.getString("open_to_all_prac_for_clinic_yn") == null)?"":rs.getString("open_to_all_prac_for_clinic_yn");
									}     
								
								}
								specl_code = rs.getString("speciality_code");
								 pract_type = rs.getString("pract_type");
									if(pract_type ==null) pract_type="";
								String primary_resource_class = rs.getString("primary_resource_class");
								if(!primary_resource_class.equals("P"))
								{
									pract_type = "";
								}
                                
								if(pract_type == null)  pract_type = ""; 
								out.println("<td class='label' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+"</td>");
         
								if(called_from.equals("CA")){
								out.println("<input type=hidden name=attending_practitioner >"); 
								}

								if(P_module_id.equals("AE"))
								{								%>
							        <td nowrap><input type=text name="practitioner_desc" id="practitioner_desc"  size=20 maxlength=30 value="<%=practitioner_name%>" onBlur="beforeGetPractitioner(practitioner_id,practitioner_desc);"><input type=hidden name=practitioner_id value="<%=X_attend_prac_id%>"><%if(!called_from.equals("CA")){%><input type=hidden name=attending_practitioner value='<%=X_attend_prac_id%>'><%}%><input type=button class=button value='?' name=Practitioner_lookup_button onClick="getPract(practitioner_id,practitioner_desc);"><input type='hidden' name='prev_pract_name' id='prev_pract_name' value=""><%
									
								}// E.o Module ID = "AE"
								else
								{	
									%><INPUT TYPE='hidden' name='open_to_all_pract' id='open_to_all_pract' value='<%=open_to_all_pract%>'><!-- <input type='hidden' name='pract_type' id='pract_type' value='<%=pract_type%>'> -->
							        <td nowrap><input type=text name="practitioner_desc" id="practitioner_desc"  size=20 maxlength=30 value="" onBlur="beforeGetPractitionerOP(practitioner_id,practitioner_desc);" ><input type=hidden name=practitioner_id value=""><input type=hidden name=attending_practitioner ><input type=button class=button value='?' name=Practitioner_lookup_button onClick="getPractitionerOP1(this,practitioner_desc);"><input type='hidden' name='prev_pract_name' id='prev_pract_name' value=""><%
								}
								if(called_from.equals("CA") && patient_class.equals("EM"))
								{						

									if(ca_pract_type.equals("MD") || ca_pract_type.equals("SG") || ca_pract_type.equals("PS") || ca_pract_type.equals("DN"))
									{
										%>
											<script>	
												document.forms[0].attending_practitioner.value="<%=ca_practitioner_id%>";
											</script>
										<%
									}					

								}						
								out.println("<img src='../../eCommon/images/mandatory.gif'></td>");						
									
							}

							if(rs != null) rs.close();
							if(pstmt != null) pstmt.close();
							sql.setLength(0);
						}
							%>
							
						<%
						out.println("</tr>");
						out.println("<tr style='heigth:10px'></tr>");
						out.println("<tr style='heigth:10px'></tr>");
						%>
					</td>
				</tr>
				<tr style='heigth:10px'></tr>
			
           		<th class='columnheader' colspan=4 align="left"><fmt:message key="Common.Disposition.label" bundle="${common_labels}"/></td>

							<tr >
							
								<td   class="label"><fmt:message key="Common.date.label" bundle="${common_labels}"/>/<fmt:message key="Common.time.label" bundle="${common_labels}"/></td>
						<%
						try
						{	
							out.println("<td  class = 'label' width='15%' align='left'><input type='hidden' name='disposition_date_time' id='disposition_date_time'  value='"+systemdatetime+"'><b>"+systemdatetime_display+"</b></td>"); 
				        	out.println("<td class='label' width='15%' align='left' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.type.label","common_labels")+"</td>");
					      //  out.println("<td ><select name= 'disposition_type' onChange='disableFields(this);dischange(this);BidChange(this);absChange(this)'>");  //Modified by Sangeetha for ML-MMOH-CRF-0624
						if(P_module_id.equals("AE")){
						out.println("<td ><select name= 'disposition_type' onChange='disableFields(this);dischange(this);checkRecordButton()'>"); 
						}else {
						out.println("<td ><select name= 'disposition_type' onChange='disableFields(this);dischange(this)'>"); 
						}

					       out.println("<option value=''>--------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" --------");
                         /*
						  if(!disposition_type.equals("")){
						 // out.println( "<option value='" +disposition_type+"' > "+disposition_type+);
						  out.println("<option value='"+disposition_type+"' selected>"+disposition_type+"</option>");
						  }
						  */	

						  //Modified by Sangeetha for ML-MMOH-CRF-0628 on 8/may/17
						  //Modified by Shanmukh for ML-MMOH-CRF-0626 on 17-Apr-2018
						  
						  	if(P_ae_brought_dead_yn.equals("Y") && (!enableBIDOnCheckout))
							{	
						           
									sql1.append("Select short_desc, disp_type, deceased_yn, ABSCONDED_YN, CALLNOTAROUND_YN from AM_DISPOSITION_TYPE_LANG_VW where eff_status='E' and (deceased_yn ='Y' and use_at_concl_yn = 'Y') and language_id='"+locale+"'"); //Modified by Sangeetha on 24/01/2017
								
								if(customer_id.equals("SS") && !disposition_type.equals("") ){
									sql1.append(" and disp_type!= '"+disposition_type+"' order by short_desc ");
								}else{
									sql1.append(" order by short_desc ");
								}

							}
							else
							{
				                if(!DispositionType.equals("") && isAutoCompDispTypeAppl){
									
									sql1.append("Select short_desc, disp_type, deceased_yn, ABSCONDED_YN, CALLNOTAROUND_YN from AM_DISPOSITION_TYPE_lang_vw "+" where disp_type not in '"+DispositionType+"' and language_id='"+locale+"' and eff_status='E' and (use_at_concl_yn = 'Y' "); 
									 
								}else{
									sql1.append("Select short_desc, disp_type, deceased_yn, ABSCONDED_YN, CALLNOTAROUND_YN from AM_DISPOSITION_TYPE_lang_vw "+" where language_id='"+locale+"' and eff_status='E' and (use_at_concl_yn = 'Y' "); //Modified by Sangeetha on 9-Jan-17 for ML-MMOH-CRF-0630
									
								}
								if(patientgender.equals("F"))
								{
									if(mother_cut_off_age > 0)
									{
										if(mother_max_age > 0)
										{
											if((patientage >= mother_cut_off_age)&&(patientage <= mother_max_age))
											{
												sql1.append(" or use_at_disch_yn = 'Y' ");
											}
										}
										else
										{
											if(patientage >= mother_cut_off_age)
											{
												sql1.append(" or use_at_disch_yn = 'Y' ");
											}
										}
									}
									else if(mother_min_age > 0)
									{
										if(mother_max_age > 0)
										{
											if((patientage >= mother_min_age)&&(patientage <= mother_max_age))
											{
												sql1.append(" or use_at_disch_yn = 'Y' ");
											}
										}
										else
										{					
											if(patientage >= mother_min_age)
											{
												sql1.append(" or use_at_disch_yn = 'Y' ");
											}
										}
									}
									else
									{	
										if(mother_max_age > 0)
										{
											if(patientage <= mother_max_age)
											{
												sql1.append(" or use_at_disch_yn = 'Y' ");
											}
										}
										else
										{
											sql1.append(" or use_at_disch_yn = 'Y' ");
										}
									}		
								}
								//order by added by sathish on Tuesday, April 12, 2011
							if(customer_id.equals("SS") && !disposition_type.equals("")){
								sql1.append(") and disp_type!= '"+disposition_type+"' order by short_desc");
							}else{
								sql1.append(") order by short_desc ");
							}
						}								
	
						pstmt1=conn.prepareStatement(sql1.toString());
						rs1 = pstmt1.executeQuery();         

						if( rs1 != null )
						{
							while( rs1.next() )
							{
								 String disptype = rs1.getString( "disp_type" ) ;
								 String shortdesc = rs1.getString( "short_desc" ) ;
								 out.println( "<option value='" + disptype + "' > "+ shortdesc);
								 out.println("<script>absconded_ind_arr[cnt]='"+rs1.getString("ABSCONDED_YN")+"';</script>");  //Added by Sangeetha on 9-Jan-17 for ML-MMOH-CRF-0630
								 out.println("<script>call_not_around_arr[cnt]='"+rs1.getString("CALLNOTAROUND_YN")+"';</script>");//Added by Thamizh selvi on 28th Nov 2017 against ML-MMOH-CRF-0783
								 out.println("<script>deceased_ind_arr[cnt]='"+rs1.getString("deceased_yn")+"';cnt++;</script>");
							}
						}
			 
						if(rs1 != null) rs1.close();
						if(pstmt1!= null) pstmt1.close();
						sql1.setLength(0);
					
				}catch ( Exception e ){ 
					e.printStackTrace();
				}
								out.println("</select><img src='../../eCommon/images/mandatory.gif'></td>");
								%>	
				</tr>	
									<tr><td ></td></tr>
							<tr><td ></td></tr>
				
			
			<tr><th  colspan=4 class='columnheader' align="left"><fmt:message key="eOP.CaseDefinitions.label" bundle="${op_labels}"/></td></tr>
		<!--Added by Thamizh selvi on 26th Mar 2018 against ML-MMOH-CRF-0646 Start-->
		<% if(isCaseDtlsRadioBtnAppl && P_module_id.equals("AE")){ %>
		<tr>
			<td class='label' width='19%'>
				<!--Modified by Ashwini on 18-Jan-2021 for ML-MMOH-CRF-1409-->
				<fmt:message key="Common.CaseofTrauma.label" bundle="${common_labels}"/>
			</td>
			<td>
			<table border='0' cellpadding='0' cellspacing='0' width='100%'>	
				<tr>
					<td class='fields' width='15%'>
						<input type='radio' name='caseDetails' id='caseDetails' id='trauma' value='<%=traumaYn%>' onClick='caseDetailsOnChange(this);' <%=checkedTraumaYn%> ></input>
					</td>
					<td class='label' width='15%'>
						<fmt:message key="Common.oscc.label" bundle="${common_labels}"/>
					</td>
					<td class='fields' width='13%'>
						<input type='radio' name='caseDetails' id='caseDetails' id='oscc' value='<%=osccYn%>' onClick='caseDetailsOnChange(this);' <%=checkedOsccYn%>></input>
					</td>
				</tr>
			</table>
			</td>
			<td class='label'  width='19%'>
				<span id='osccTypeLabel' style="visibility:hidden"><fmt:message key="Common.oscc.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.type.label" bundle="${common_labels}"/></span>
			</td>
			<td class='fields' width='19%'>
				<select name='osccType' id='osccType' style="visibility:hidden">
					<option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------
					<%
						JSONArray osccTypeJsonArr	= new JSONArray();
						osccTypeJsonArr  = eAE.AECommonBean.getOSCCTypeList(conn,locale,"");	
							
						for(int i = 0 ; i < osccTypeJsonArr.size() ; i++) 
						{
							JSONObject osccTypejson		= (JSONObject)osccTypeJsonArr.get(i);
							String injCategoryCode		= (String) osccTypejson.get("injCategoryCode");
							String injSubCategoryCode	= (String) osccTypejson.get("injSubCategoryCode");
							String subCategoryShortDesc	= (String) osccTypejson.get("subCategoryShortDesc");
												
							out.println("<option value="+injCategoryCode+","+injSubCategoryCode+">"+subCategoryShortDesc+"</option>");
									
						}
									
					%>
				</select>
				<img src='../../eCommon/images/mandatory.gif' id='osccTypeMandImg' style="visibility:hidden" align='center'></img>
			</td>
		</tr>

		<tr>
			<td class='label' width='19%'>
				<fmt:message key="Common.medical.label" bundle="${common_labels}"/>
			</td>
			<td>
				<table border='0' cellpadding='0' cellspacing='0' width='100%'>	
					<tr>
						<td class='fields' width='15%'>
							<input type='radio' name="caseDetails" id="caseDetails" id='medical' value='<%=medical_yn%>' onClick='caseDetailsOnChange(this);' <%=mscheck1%> ></input>
						</td>
						<td class='label' width='15%'>
							<fmt:message key="Common.Surgical.label" bundle="${common_labels}"/>
						</td>
						<td class='fields' width='13%'>
							<input type='radio' name="caseDetails" id="caseDetails" id='surgical' value='<%=surgical_yn%>' onClick='caseDetailsOnChange(this);' <%=mscheck2%> ></input> 
						</td>
					</tr>
				</table>
			</td>
			<td colspan=2>&nbsp;</td>
		</tr>
		
		<tr>
			<td class='label' width='19%'>
				<fmt:message key="eAE.OandG.label" bundle="${ae_labels}"/>
			</td>
			<td>
				<table border='0' cellpadding='0' cellspacing='0' width='100%'>	
					<tr>
						<td class='fields' width='15%'>
							<input type='radio' name="caseDetails" id="caseDetails" id='OandG' value='<%=OandGYn%>' onClick='caseDetailsOnChange(this);' <%=checkedOandGYn%> ></input>
						</td>
						<td class='label' width='15%'>
							<fmt:message key="eAE.NonEmergency.label" bundle="${ae_labels}"/>
						</td>
						<td class='fields' width='13%'>
							<input type='radio' name="caseDetails" id="caseDetails" id='NonEmerg' value='<%=nonEmergYn%>' onClick='caseDetailsOnChange(this);' <%=checkedNonEmergYn%> ></input> 
						</td>
					</tr>
				</table>
			</td>
			<td colspan=2>&nbsp;</td>
		</tr>
		<% }else{ %>
		<!--End-->
			<!--Added by Ashwini on 18-Jan-2021 for ML-MMOH-CRF-1409-->
			<%if(isReconfirmCOTAppl && P_module_id.equals("AE")){%>
			<tr>
				<td class='label' width='25%'><fmt:message key="Common.CaseofTrauma.label" bundle="${common_labels}"/></td>
				<td class='fields' width='25%'><input type='checkbox' name="CaseofTrauma" id="CaseofTrauma" <%=checkedTraumaYn%> align="left" value='<%=traumaYn%>' onClick='chkval(this);'></td>
			</tr>
			<%}%>
			<!--End ML-MMOH-CRF-1409-->
			<tr>       
			<td   class="label" nowrap><fmt:message key="Common.medical.label" bundle="${common_labels}"/><td><input type='checkbox' name='medical' id='medical' <%=msenable%> <%=mscheck1%>  align="left"  value='<%=medical_yn%>' onClick='chkval(this);'></td><td   class="label" nowrap><fmt:message key="Common.Surgical.label" bundle="${common_labels}"/></td><td><input type='checkbox' name='surgical' id='surgical' align="left"<%=msenable%> <%=mscheck2%>  value='<%=surgical_yn%>' onClick='chkval(this);'></td>
			</tr>
			<% } %>
			
			<!-- Added by Ajay Hatwate for ML-MMOH-CRf-1653 -->

		<% if(caseTypeYn.equals("Y")){ %>
		 <tr>		
	      <td class='label' nowrap ><fmt:message key="eAE.CaseType.label" bundle="${ae_labels}"/></td>
		      <td colspan='2' >
			 <select name='case_type' id='case_type' caseTypeDisable>
			 <option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------
			  <%
			   StringBuffer sqlCaseType = new StringBuffer();
			   sqlCaseType.append("SELECT case_type_code, short_desc FROM ae_case_type WHERE EFF_STATUS ='E' ORDER BY 2");
			   pstmt = conn.prepareStatement(sqlCaseType.toString());
			   rset = pstmt.executeQuery();
			   while(rset!=null && rset.next())
			   {
				   if(caseType.equals(rset.getString(1))){
				  	out.println("<option value='"+rset.getString(1)+"' selected >"+rset.getString(2)+" ");
				   }else{
					   out.println("<option value='"+rset.getString(1)+"' >"+rset.getString(2)+" ");   
				   }
			   }
			   if(pstmt!=null) pstmt.close();
			   if(rset!=null)	rset.close();
			   if((sqlCaseType != null) && (sqlCaseType.length() > 0))
				 {
				   sqlCaseType.delete(0,sqlCaseType.length());
				 } 
			   %>
			 </select>
			 <%if(caseTypeMandYn.equals("Y")){ %>
			  <img src='../../eCommon/images/mandatory.gif' align='center'></img>
			 <%} %>
			 </td>
		 </tr>
		 <%} %>
			<!-- End of ML-MMOH-CRF-1653 -->
			
			         <tr> <td  align='left' class='label'  nowrap><fmt:message key="Common.CircumstanceofInjury.label" bundle="${common_labels}"/></td><td colspan=3><select name= 'circumstance_of_injury' >
					<option value=''>-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------                 
                            
<%
						pstmt=conn.prepareStatement("Select short_desc, circumstance_of_injury_code from AM_CIRCUM_OF_INJURY_LANG_VW where language_id='"+locale+"' and eff_status = 'E' order by short_desc ");
						rs = pstmt.executeQuery();

						if( rs != null )
						{
							while( rs.next() )
							{
								 String cirofinj = rs.getString( "circumstance_of_injury_code" ) ;
								 String shortdesc = rs.getString( "short_desc" ) ;
								 out.println( "<option value='" + cirofinj + "' > "+ shortdesc);
							}
						}

						if(rs != null) rs.close();
						if(pstmt != null) pstmt.close();
                        out.println("</td> ");
						%>
					</tr>
				
			
			
            
			<th colspan=4 class='COLUMNHEADER' align="left"><fmt:message key="eOP.IntheEventofDeath.label" bundle="${op_labels}"/></td>
                <tr >
			
			<!--below changes added by Mano against ML-MMOH-CRF-0783-->
					<% if(isDIDCallNtAroundAppl && P_module_id.equals("AE")){ %>
					<tr>
						<td class='label'><fmt:message key="Common.DeathInDepartment.label" bundle="${common_labels}"/></td>
						<td class='fields'><input type='checkbox' name='did_yn' id='did_yn' value='' disabled  onClick='chkval(this);checkRecordButton();'></td>
						</tr>
					<% } %><input type='hidden' name='did_hid' id='did_hid' value='N'><!--End-->
			
			<td   class="label" nowrap>
			<!--Below line modified by Ashwini on 18-Jan-2017 for GDOH-CRF-0123--> 
			<%if(isLabelChngAppl == false){ %>
				<%if(!five_level_triage_appl_yn.equals("Y") ){ %> 
					<fmt:message key="Common.broughtdead.label" bundle="${common_labels}"/>
				 <%}else{ %>	
					<fmt:message key="eAE.DeadOnArrival.label" bundle="${ae_labels}"/><!--bundle change for PAS-MP-PMG2020-TECH-CRF-0010/01-Label Name-->
				<%} %>
			<%}else{ %>
				<%if(P_module_id.equals("AE")){ %>
					<fmt:message key="eAE.DeadOnArrival.label" bundle="${ae_labels}"/><!--bundle change for PAS-MP-PMG2020-TECH-CRF-0010/01-Label Name-->
				<%} else { %>
				<fmt:message key="Common.broughtdead.label" bundle="${common_labels}"/> <% } %>
			<%} %>
			</td>
					<% if(P_ae_brought_dead_yn.equals("Y")){%>
					<td  class='FIELDS' nowrap><input type='checkbox' name='bdead' id='bdead' value='Y' checked <%=bdeaddis%> onClick='chkval(this);checkRecordButton()'>  <!-- Modified by Sangetha for ML-MMOH-CRF-0628 on 10/may/17-->
					<input type='hidden' name='bdead_yn' id='bdead_yn' value='Y'>
					<%}else{
					 if(P_module_id.equals("AE")){ %>
					<td  class='FIELDS' nowrap><input type='checkbox' name='bdead' id='bdead' value='' <%=bdeaddis%> onClick='chkval(this);checkRecordButton()'></img><input type='hidden' name='bdead_yn' id='bdead_yn' value='N'>    <!-- Modified by Sangetha for ML-MMOH-CRF-0624 -->
					<% } else { %>
					<td  class='FIELDS' nowrap><input type='checkbox' name='bdead' id='bdead' value='' <%=bdeaddis%> onClick='chkval(this);'></img><input type='hidden' name='bdead_yn' id='bdead_yn' value='N'> 
					<%}	%>
					<%}	%>
					<!-- below line(s) modified by VenkateshS against ML-MMOH-CRF-0354 [IN057191] -->
					<%if(siteSpecific){%>
		<td   class="label" align="left" width="15%"><fmt:message key="Common.MedicalLegalCase.label" bundle="${common_labels}"/></td>
		<%}else {%>
		<td  class="label" align="left" width="15%"><fmt:message key="Common.mlc.label" bundle="${common_labels}"/></td>
		<%}%>
		<!--end ML-MMOH-CRF-0354 [IN057191 -->
		<td><input type='checkbox' name='mlc' id='mlc' value='<%=mlc_yn%>' <%=mlcchkval%> onClick='chkval(this);'></td>
			</tr>
			<tr>
		<td  class='label' nowrap>		
		<fmt:message key="Common.PMRequired.label" bundle="${common_labels}"/></td>
        <td  align="left" class="Fields" nowrap><input type='checkbox' name='postmortem' id='postmortem' value='N' onClick='chkval(this);' disabled><td   class="label" width='24%'>
		<fmt:message key="Common.highriskbody.label" bundle="${common_labels}"/><td class='Fields' ><input type='checkbox' name='high_risk' id='high_risk' value='N' onclick='chkval(this);' disabled></td>
		<input type='hidden' name='medical_yn' id='medical_yn' value='N'>
		</tr>
		<tr>
        <td   class='label' nowrap><fmt:message key="Common.deceaseddatetime.label" bundle="${common_labels}"/></td>
		<td class='Fields'><input type='text'  name='deceased_date_time' id='deceased_date_time' size='16' maxlength='16' onBlur='validDateObj(this,"DMYHM",localeName);if(document.forms[0].released_date_time.value == "" && !document.forms[0].released_date_time.readOnly){document.forms[0].released_date_time.value=document.forms[0].deceased_date_time.value;} if(document.forms[0].released_date_time.value != "" && !document.forms[0].released_date_time.readOnly){document.forms[0].released_date_time.value=document.forms[0].deceased_date_time.value;}'   value='<%=deceased_time%>' <%=dronly%>>
<%--  		<img id='dec_img' src='../../eCommon/images/CommonCalendar.gif' onClick="deceasedDateTime('deceased_date_time',null,'hh:mm')" <%=ddis%> style="pointer-events: <%=ddis == 'disabled' ? 'none' : 'auto'%>; opacity: <%=ddis == 'disabled' ? '0.5' : '1'%>;">
 --%>	
 <img id="dec_img" 
     src="../../eCommon/images/CommonCalendar.gif" 
     onClick="deceasedDateTime('deceased_date_time', null, 'hh:mm')" 
     <%= ddis %> 
     style="pointer-events: <%= "disabled".equals(ddis) ? "none" : "auto" %>; opacity: <%= "disabled".equals(ddis) ? "0.5" : "1" %>;">
 
 
    	<img src='../../eCommon/images/mandatory.gif' style='visibility:hidden' id='gifpopdec'>
		<%if(isDeathRegisterFormAppl && enable_death_reg_form.equals("Y")){ %>
		<a href="javascript:getDeathRegFormAccessionNum('<%=P_patient_id%>', '<%=P_encounter_id%>', '<%=X_episode_id%>', '<%=visit_adm_date_time%>', '<%=patient_class%>', '<%=spec_code%>', '<%=P_locn_code%>', '<%=death_reg_form_accession_num%>', '');" id='deathRegFormLink' style='visibility:hidden'><fmt:message key="Common.DeathRegForm.label" bundle="${common_labels}"/></a>
		<% }%>
		</td> 
		<input type='hidden' name='high_risk_yn' id='high_risk_yn' value='N'>
		<td   class='label'  width="25%" nowrap><fmt:message key="Common.BodyReleaseDateTime.label" bundle="${common_labels}"/></td>
		<td class='Fields'align="left" width="25%" ><input type='text'  name='released_date_time' id='released_date_time' size='16' maxlength='16' value='<%=body_release_deceased_time%>' onBlur='validDateObj(this,"DMYHM",localeName);' <%=dronly%>>
		<%-- <img  src='../../eCommon/images/CommonCalendar.gif' id='rel_img' onClick="releasedDateTime('released_date_time',null,'hh:mm')" <%=ddis%>> --%>
		<img src='../../eCommon/images/CommonCalendar.gif' 
     id='rel_img' 
     onClick="releasedDateTime('released_date_time', null, 'hh:mm')" 
     <%= ddis %> 
     style="pointer-events: <%= "disabled".equals(ddis) ? "none" : "auto" %>; opacity: <%= "disabled".equals(ddis) ? "0.5" : "1" %>;">
		
		<img src='../../eCommon/images/mandatory.gif' style='visibility:hidden' id='gifpopbody'></td>
		<input type='hidden' name='surgical_yn' id='surgical_yn' value='<%=surgical_yn%>'>
		<input type='hidden' name='mlc_yn' id='mlc_yn' value='<%=mlc_yn%>'>
		<input type='hidden' name='postmortem_yn' id='postmortem_yn' value='<%=medical_yn%>'>
		
		</tr>
<tr><td ></td></tr>
							<tr><td ></td></tr>
		
		</td>
        </tr>
	


	<th class='COLUMNHEADER' colspan=4 align="left"><fmt:message key="eOP.RecallDetails.label" bundle="${op_labels}"/></td>
	<tr>
	<td>
		
			<tr>
			<!--Added by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657-->
			<%if(P_module_id.equals("AE") && invokeRecallForAE.equals("Y")){%>
			<td  class='label' nowrap><fmt:message key="eAE.ToComeAgain.label" bundle="${ae_labels}"/> </td>
			<%}else{%>
			<td  class='label' nowrap><fmt:message key="eOP.ComeBack.label" bundle="${op_labels}"/> </td>
			<%}%>
			<!--End ML-MMOH-CRF-0657-->
			<td  class='Fields'>
			<input type='checkbox' name='tocomeback' id='tocomeback' value="Y" onClick='enable_recall()' <%=disable_all%>></td><td class=label><fmt:message key="Common.After.label" bundle="${common_labels}"/> </td><td>

			 <input type='hidden' name='comebackon' id='comebackon' size='10' maxlength='10'  ></input> 
			<!-- <input type='hidden' name='comebackon' id='comebackon' size='10' maxlength='10' onBlur="CheckDate(this);CheckDates(this,'<%=system_date%>',null)" ></input> -->
			
			<!--Added by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657-->
			<%if(P_module_id.equals("AE") && invokeRecallForAE.equals("Y")){%>
			<input type="hidden" name="days_unit" id="days_unit" value ="">
			<input 'text' id='dateAgain' name='dat_val' id='dat_val' value='' size='16' maxlength='16' onblur="if(validDateObj(this,'DMYHM',localeName)){chkWithSysDt(this);}" onkeypress="return Valid_DT(event)"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('dateAgain',null,'hh:mm');"></img>
			<%}else{%>
			<input type='text' name='dat_val' id='dat_val' onkeypress="return call2functions(this,event)"   onblur='OffsetDate("<%=system_date%>");valid_dat(this);'  onclick='' size=3 maxlength=3 >					<select name='days_unit' id='days_unit' onchange='OffsetDate("<%=system_date%>")'>
			<option value='D'><fmt:message key="Common.days.label" bundle="${common_labels}"/> </option>
			<option value='W'><fmt:message key="Common.weeks.label" bundle="${common_labels}"/> </option>
			<option value='M'><fmt:message key="Common.months.label" bundle="${common_labels}"/> </option>
			</select>
			<%}%>
			<!--End ML-MMOH-CRF-0657-->
			<img name='mandatory' id='mandatory' style='visibility: hidden' src='../../eCommon/images/mandatory.gif'>
			</td>
			</tr>
			<tr>
			
			<td  align="right"colspan=4 > <input type=button class=button value='<fmt:message key="Common.bookappointment.label" bundle="${common_labels}"/> ' name='bookingappointment' onclick='appointment(false);' disabled></td>                                    
			</tr>
			<tr>
				<td  class='label'   ><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
				<td  nowrap> 
					<Select name='reason' id='reason' 	><option value=''>---------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------------</option>
					<%
					pstmt=conn.prepareStatement("select contact_reason_code,contact_reason from am_contact_reason_lang_vw where nvl(REASON_FOR_RECALL_YN,'N') = 'Y' and eff_status='E' and language_id='"+locale+"' order by contact_reason");
					rs=pstmt.executeQuery();
					if(rs != null)
					{
						while(rs.next())
						{
							String Value  = rs.getString("contact_reason_code");
							String Label  = rs.getString("contact_reason");
							%>
								<option value='<%=Value%>'><%=Label%>
							<%
						}
					}
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					%>										
					</select> 
					</td>		
					<td  class='label'  width='25' valign=top><fmt:message key="Common.Instructions.label" bundle="${common_labels}"/></td>
					<td width='25%' align='left' > <textarea name='instructionsrecall' rows=2 cols=30 onblur='makeValidString(this);checkMaxLen(this);'></textarea> </td>
			</tr>                            
			<!--Maheshwaran K added for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013-->
			<!--Start-->
			<%if(mds_chk!=0)
			{
			if(!mr_mds_recorded.equals("Y")){
				
				mr_mds_recorded_style="disabled";
				
				//Added by Ashwini on 08-Jul-2024 for ML-MMOH-CRF-2114.2
				if(isMDSForMainProcAppl){
					if(mr_mds_recorded.equals("####CNM_PROCEED")){
						mr_mds_recorded_style = "";
					}
				}
			}
			%>
			<tr>
				<td  class='label' ><fmt:message key="eMR.MDS.label" bundle="${mr_labels}"/></td>
				<%if(mr_mds_recorded.equals("Y"))
					{%>
				<td  class='QUERYDATA'><font color='RED'><fmt:message key="Common.CriteriaMet.label" bundle="${common_labels}"/></font></td>
				<%}
				else{%>
				<td  class='QUERYDATA'><font color='RED'><fmt:message key="Common.CriteriaNotMet.label" bundle="${common_labels}"/></font>&nbsp;<font color='blue'><a href='javascript:onclick=MDSCompliance(document.forms[0].mr_mds_recorded.value)' style='text-decoration:underline'><fmt:message key="Common.Check.label" bundle="${common_labels}"/></a></font></td>
				<script>	</script>
				<%
				
				}%>	
			</tr>	
			<%}%>
		<!--End-->	
	</td>
<tr><td colspan=4> &nbsp;</td></tr>
</tr> 

</table>
<table  border='0'cellpadding='0' cellspacing='10' align=center width='50%'  >

<tr><td  class=WHITE></td></tr> 



	
<tr>
		<%								
		if(!referral_id.equals(""))
		{
		%>			
			<td width='65%' class='fields'><input type='button' class='button' name='view_referral' id='view_referral' value='<fmt:message key="Common.referraldetails.label" bundle="${common_labels}"/>' onClick="ViewRefDetails('<%=referral_id%>');"></td>
		<%	
		}
		else
			out.println("<td width='5%' class='label'></td>");						
		%>
			<td class='label'></td>
			<td width='13%' class='label'><input type='button' class='Button' name='record' id='record' <%=mr_mds_recorded_style%> onClick="Apply()" value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' > </td>
			<td width='13%' class='label'><input type='button' class='Button' name='cancel' id='cancel' onClick="Closewin()" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>'></td>
			<td width='19%' class='label'><input type='button' class='Button' name='cnl_episode' id='cnl_episode'  onClick="Concldepisode('<%=service_desc%>','<%=visit_adm_date_time%>','<%=systemdatetime%>')" value='<fmt:message key="eOP.ConcludeEpisode.label" bundle="${op_labels}"/>'></td>
			<td width='17%' class='label'><input type='button' class='Button' name='create_wait_list' id='create_wait_list' onClick="WaitList(this)" value='<fmt:message key="Common.CreateWaitList.label" bundle="${common_labels}"/>' <%=create_wait_dis%>></td>
			<td width='15%' class='label'><input type='button' class='Button' name='modify_wait_list' id='modify_wait_list' onClick="WaitList(this)" value='<fmt:message key="Common.ModifyWaitList.label" bundle="${common_labels}"/>' <%=modify_wait_dis%>></td> 
			<!-- <td width='15%' class='label'><input type='button' class='Button' name='sickLeave' id='sickLeave' onClick="OpenSickLeave()" value='<fmt:message key="Common.certificate.label" bundle="${common_labels}"/>' disabled></td> -->
			
			<!--Added by Ashwini on 08-Jul-2024 for ML-MMOH-CRF-2114.1-->
			<%if(isMDSForMainProcAppl){

				if(mds_chk!=0)
				{
					if(mr_mds_recorded.equals("Y")){
						mr_mainproc_recorded = "disabled";
					}else{
						if(mr_mds_recorded.endsWith("#")){
							mr_mainproc_recorded = "disabled";
						}else{
							mr_mainproc_recorded = "";
						}
					}
				}else{
					mr_mainproc_recorded = "";
				}
			%>
				<td width='15%' class='label'>
					<input type='button' class='button' name = 'main_procedure' id = 'main_procedure' <%=mr_mainproc_recorded%> value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.main.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Procedure.label","common_labels")%>' onclick="callCAMainProcedure();">
				</td>
			<%}%>

		</tr>	

		<tr>
			<td ></td>
		</tr>
	</table>
	<table id='billingLinktable' cellpadding=0 cellspacing=0 border='0' align='center' style="visibility:hidden" >
	<tr>
			<td ></td>
	</tr>
	<tr>
	   <td class='label' nowrap><a href="javascript:callbilling();"  name='bl_call'><fmt:message key="eAE.OutstandingBillsSettlement.label" bundle="${ae_labels}"/></td>
	</tr>
	</table>
	

	<input type="hidden" name="open_to_all_prac_for_clinic_yn" id="open_to_all_prac_for_clinic_yn"  value ="<%=open_to_all_prac_for_clinic_yn%>" >
	<input type="hidden" name="practitioner_name1" id="practitioner_name1"  value ="<%=practitioner_name%>" >
		<input type="hidden" name="practitioner_id1" id="practitioner_id1"  value ="<%=X_attend_prac_id%>" >
		<input type="hidden" name="specl_code" id="specl_code"  value ="<%=specl_code%>" >
	<input type="hidden" name="Encounter" id="Encounter"  value ="<%=P_encounter_id%>" >
	<input type="hidden" name="patient_id" id="patient_id"  value ="<%=P_patient_id%>" >
	<input type="hidden" name="location_type" id="location_type"  value ="<%=P_locn_type%>" >
	<input type="hidden" name="location_code" id="location_code"  value ="<%=P_locn_code%>" >
	<input type="hidden" name="i_practitioner_id" id="i_practitioner_id"  value ="<%=P_practitioner_id%>" >
	<input type="hidden" name="i_clinic_code" id="i_clinic_code"  value ="<%=P_locn_code%>" >
	<input type="hidden" name="i_appt_ref_no" id="i_appt_ref_no"  value ="<%=appt_id%>">
	<input type="hidden" name="i_appt_date" id="i_appt_date"  value ="">
	<input type="hidden" name="xxxx" id="xxxx"  value ="">
	<input type="hidden" name="xx" id="xx"  value ="">
	<input type="hidden" name="P_patient_id" id="P_patient_id"  value ="<%=P_patient_id%>" >
	<input type="hidden" name="P_locn_type" id="P_locn_type"  value ="<%=P_locn_type%>" >
	<input type="hidden" name="P_locn_code" id="P_locn_code"  value ="<%=P_locn_code%>" >
	<input type='hidden' name='arrive_date_time' id='arrive_date_time' value='<%=arrive_date_time%>'>
	<input type='hidden' name='vital_signs_date_time' id='vital_signs_date_time' value='<%=vital_signs_date_time%>'>
	<input type="hidden" name="ae_count" id="ae_count"  value ="<%=aecnt%>" >
	<input type="hidden" name="P_practitioner_id" id="P_practitioner_id"  value ="<%=P_practitioner_id%>" >
	<input type="hidden" name="pract_assigned_yn" id="pract_assigned_yn"  value ="<%=X_pract_assigned_yn%>" >
	<input type="hidden" name="conclude" id="conclude"  value ="">
	<input type="hidden" name="concludenotes" id="concludenotes"  value ="">
	<input type="hidden" name="sdate" id="sdate"  value ="<%=system_date%>" >
	<input type="hidden" name="stime" id="stime"  value ="<%=system_time%>" >
	<input type="hidden" name="referral_text" id="referral_text"  value ='' >
	<input type="hidden" name="hcare_setting_type_desc" id="hcare_setting_type_desc"  value ='' >
	<input type="hidden" name="open_to_all_pract_yn" id="open_to_all_pract_yn"  value ='<%=open_to_all_pract_yn%>' >
	<input type="hidden" name="to_hcare_setting_type" id="to_hcare_setting_type"  value ='' > 
	<input type="hidden" name="location1_desc" id="location1_desc"  value ='' >
	<input type="hidden" name="practitioner_name" id="practitioner_name"  value ='' >
	<input type="hidden" name="module_id" id="module_id"  value ="<%=P_module_id%>" > 
	<input type="hidden" name="diagrecord" id="diagrecord"  value ="<%=diagrecord%>" > 
	<input type="hidden" name="diagReqd" id="diagReqd"  value ="<%=diagReqd%>" > 
	<input type="hidden" name="notesrecord" id="notesrecord"  value ="<%=notesrecord%>" > 
	<input type="hidden" name="notesReqd" id="notesReqd"  value ="<%=notesReqd%>" > 
	<input type="hidden" name="dispReqd" id="dispReqd"  value ="<%=dispReqd%>" > 
	<input type='hidden' name="P_ae_brought_dead_yn" id="P_ae_brought_dead_yn" value="<%=P_ae_brought_dead_yn%>">
	<input type='hidden' name='visit_adm_type_ind' id='visit_adm_type_ind' value='<%=visit_adm_type_ind%>'>
	<input type="hidden" name="ae_treatment_area_code" id="ae_treatment_area_code"  value ="<%=P_ae_treatment_area_code%>" > 
	<input type="hidden" name="inv_ordered1" id="inv_ordered1" value=''>
	<input type="hidden" name="inv_ordered2" id="inv_ordered2" value=''>
	<input type="hidden" name="inv_ordered3" id="inv_ordered3" value=''>
	<input type="hidden" name="p_queue_date" id="p_queue_date" value="<%=p_queue_date%>">
	<input type="hidden" name="called_from" id="called_from" value="<%=called_from%>">
	<input type="hidden" name="SickLeaveRecordFlag" id="SickLeaveRecordFlag" value="N">
	<input type="hidden" name="SickLeaveDetails" id="SickLeaveDetails" value="">
	<input type="hidden" name="recall_date" id="recall_date" value="">
	<input type="hidden" name="DECEASED_YN" id="DECEASED_YN" value="N">
	<input type="hidden" name="referred_to1" id="referred_to1" value="">				
	<input type='hidden' name='referral_source1' id='referral_source1' value=''>	
	<input type="hidden" name="from_fac_id" id="from_fac_id" value="">
	<input type="hidden" name="bl_install_yn" id="bl_install_yn" value="<%=bl_install_yn%>" >
	<input type="hidden" name="install_yn" id="install_yn" value="<%=install_yn%>" >
	<input type="hidden" name="waitlist_category_appl_yn" id="waitlist_category_appl_yn" value="<%=waitlist_category_appl_yn%>" >
	<input type="hidden" name="waitlist_category_reqd_yn" id="waitlist_category_reqd_yn" value="<%=waitlist_category_reqd_yn%>" >
	<input type="hidden" name="restrict_wl_cat_agst_splty_yn" id="restrict_wl_cat_agst_splty_yn" value="<%=restrict_wl_cat_agst_splty_yn%>" >		
	 <input type='hidden' name='pract_type' id='pract_type' value='<%=pract_type%>'> 
	<input type='hidden' name='pract_speciality' id='pract_speciality' value=''>
	<input type='hidden' name='system_date' id='system_date' value='<%=systemdatetime%>'>
	<input type='hidden' name='visit_adm_date_time' id='visit_adm_date_time' value='<%=visit_adm_date_time%>'>
	<input type='hidden' name='spec_code' id='spec_code' value='<%=spec_code%>'>
	<input type='hidden' name='episode_id' id='episode_id' value='<%=X_episode_id%>'>
	<input type='hidden' name='episode_visit_num' id='episode_visit_num' value='<%=episode_visit_num%>'>
	
	<input type='hidden' name='create_wait_list_yn' id='create_wait_list_yn' value='<%=create_wait_list_yn%>'>
	<input type='hidden' name='modify_wait_list_yn' id='modify_wait_list_yn' value='<%=modify_wait_list_yn%>'>
	<input type='hidden' name='wait_list_no' id='wait_list_no' value='<%=wait_list_no%>'> 
	<input type='hidden' name='userid' id='userid' value='<%=userid%>'>
	<input type='hidden' name='oper_stn_id' id='oper_stn_id' value='<%=oper_stn_id%>'>
	<input type='hidden' name='facility_id' id='facility_id' value='<%=fac_id%>'>
	<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
	<input type='hidden' name='visit_type_code' id='visit_type_code' value='<%=visit_type_code%>'>
	<input type='hidden' name='episode_type' id='episode_type' value='<%=episode_type%>'>
	<input type='hidden' name='mr_mds_recorded' id='mr_mds_recorded' value='<%=mr_mds_recorded%>'><!--Maheshwaran K modified for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013-->
	<input type='hidden' name='reg_reff_chkout_yn' id='reg_reff_chkout_yn' value='<%=reg_reff_chkout_yn%>'>
	<input type='hidden' name='cls_pat_chart_on_chkout_yn' id='cls_pat_chart_on_chkout_yn' value='<%=close_pat_chart_on_checkout_yn%>'>
	<input type='hidden' name='visit_id' id='visit_id' value='<%=visit_id%>'>
	<!-- <input type='hidden' name='disposition_date_time1' id='disposition_date_time1' value='<%=systemdatetime_display%>'> -->
	<!--Below line modified for this incident [62496] -->
	 <input type='hidden' name='disposition_date_time1' id='disposition_date_time1' value='<%=system_datetime%>'> 


    <input type='hidden' name='allow_chkout_with_bill_stmt_yn' id='allow_chkout_with_bill_stmt_yn' value='<%=allow_chkout_with_bill_stmt_yn%>'>
	<input type='hidden' name='settle_outstanding_bills_yn' id='settle_outstanding_bills_yn' value=''>
	<input type='hidden' name='p_err_msg' id='p_err_msg' value=''>
	<input type='hidden' name='p_error_level' id='p_error_level' value=''>
	<input type='hidden' name='p_error_text' id='p_error_text' value=''>

	<!--CRF-362 AE bed charge -->
	<input type='hidden' name='ae_bed_charge_appl_yn' id='ae_bed_charge_appl_yn' value='<%=ae_bed_charge_appl_yn%>'>
	<input type='hidden' name='charge_net_amt' id='charge_net_amt' value=''>
	<input type='hidden' name='patientPayble' id='patientPayble' value=''>
	<input type='hidden' name='bed_no' id='bed_no' value='<%=bed_no%>'>
	<input type='hidden' name='ae_bed_calYN' id='ae_bed_calYN' value='<%=ae_bed_calYN%>'>
	<input type='hidden' name='modified_date_old' id='modified_date_old' value='<%=modified_date%>'>
	<input type='hidden' name='customer_id' id='customer_id' value='<%=customer_id%>'>
	<input type='hidden' name='qms_interfaced_yn' id='qms_interfaced_yn' value='<%=qms_interfaced_yn%>'>
	<input type='hidden' name='room_num' id='room_num' value='<%=room_num%>'>
	<input type='hidden' name='queue_num' id='queue_num' value='<%=queue_num%>'>
	<input type='hidden' name='multi_speciality_yn' id='multi_speciality_yn' value='<%=multi_speciality_yn%>'>
	<!--Below line added for this CRF Bru-HIMS-CRF-133 -->	
	<input type='hidden' name='isPatientEncMovement' id='isPatientEncMovement' value='<%=isPatientEncMovement%>'>
	<input type='hidden' name='Sydate' id='Sydate' value='<%=Sydate%>'>
	<input type='hidden' name='patient_class' id='patient_class' value='<%=patient_class%>'>
	<!--End this CRF Bru-HIMS-CRF-133 -->
	<input type='hidden' name='rec_diag_not_mdt_absconded' id='rec_diag_not_mdt_absconded' value='<%=rec_diag_not_mdt_absconded%>'>   <!-- Added by Sangeetha for ML-MMOH-CR-0630-->
	<input type='hidden' name='rec_diag_not_mdt_bid' id='rec_diag_not_mdt_bid' value='<%=rec_diag_not_mdt_bid%>'>   <!-- Added by Sangeetha for ML-MMOH-CR-0624-->
	<input type='hidden' name='diag_recording_not_mndt' id='diag_recording_not_mndt' value='<%=diag_recording_not_mndt%>'>  <!-- Added by Sangeetha for ML-MMOH-CRF-0547-->

	<input type='hidden' name='enableBIDOnCheckout' id='enableBIDOnCheckout' value='<%=enableBIDOnCheckout%>'>  <!-- Added by Sangeetha on 8/may/17 for ML-MMOH-CRF-0628-->
	<!--Added by Thamizh selvi on 27th Nov 2017 against ML-MMOH-CRF-0783 Start-->
	<input type='hidden' name='isDIDCallNtAroundAppl' id='isDIDCallNtAroundAppl' value='<%=isDIDCallNtAroundAppl%>'>  
	<input type='hidden' name='recDiagNotMdtFrDid' id='recDiagNotMdtFrDid' value='<%=recDiagNotMdtFrDid%>'>
	<input type='hidden' name='recDiagNtMdtFrCallNtAround' id='recDiagNtMdtFrCallNtAround' value='<%=recDiagNtMdtFrCallNtAround%>'>
	<!--End-->

	<!--Added by Thamizh selvi on 26th Mar 2018 against ML-MMOH-CRF-0646 Start-->
	<input type='hidden' name='isCaseDtlsRadioBtnAppl' id='isCaseDtlsRadioBtnAppl' value='<%=isCaseDtlsRadioBtnAppl%>'>
	<input type='hidden' name='OandG_yn' id='OandG_yn' value='<%=OandGYn%>'>
	<input type='hidden' name='oscc_yn' id='oscc_yn' value='<%=osccYn%>'>
	<input type='hidden' name='trauma_yn' id='trauma_yn' value='<%=traumaYn%>'>
	<input type='hidden' name='non_emerg_yn' id='non_emerg_yn' value='<%=nonEmergYn%>'>
	<input type='hidden' name='mechInjCatgCode' id='mechInjCatgCode' value='<%=mechInjCatgCode%>'>
	<input type='hidden' name='mechInjSubCatgCode' id='mechInjSubCatgCode' value='<%=mechInjSubCatgCode%>'>
	<!--End-->

	<!--Added by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657-->
	<input type='hidden' name='invokeRecallForAE' id='invokeRecallForAE' value='<%=invokeRecallForAE%>'>
	<!--End ML-MMOH-CRF-0657-->

	<!--Added by Ashwini on 18-Jan-2021 for ML-MMOH-CRF-1409-->
	<input type='hidden' name='isReconfirmCOTAppl' id='isReconfirmCOTAppl' value='<%=isReconfirmCOTAppl%>'>
	<input type='hidden' name='reconf_cot_param' id='reconf_cot_param' value='<%=reconf_cot_param%>'>
	<input type='hidden' name='isDeathRegisterFormAppl' id='isDeathRegisterFormAppl' value='<%=isDeathRegisterFormAppl%>'><!-- Added by Ajay Hatwate for AAKH-CRF-0179 on 07-08-2023 -->
	<input type='hidden' name='enable_death_reg_form' id='enable_death_reg_form' value='<%=enable_death_reg_form%>'><!-- Added by Ajay Hatwate for AAKH-CRF-0179 on 07-08-2023 -->
	<input type='hidden' name='death_reg_form_accession_num' id='death_reg_form_accession_num' value='<%=death_reg_form_accession_num%>'><!-- Added by Ajay Hatwate for AAKH-CRF-0179 on 07-08-2023 -->
	<input type='hidden' name='callback_mode' id='callback_mode' value='Add'><!-- Added by Ajay Hatwate for AAKH-CRF-0179 on 01-09-2023 -->
	<input type='hidden' name='caseTypeYn' id='caseTypeYn' value='<%=caseTypeYn %>'><!-- Added by Ajay Hatwate for ML-MMOH-CRF-1653-->
	<input type='hidden' name='caseTypeMandYn' id='caseTypeMandYn' value='<%=caseTypeMandYn %>'><!-- Added by Ajay Hatwate for ML-MMOH-CRF-1653 -->

	<!--Added by Ashwini on 08-Jul-2024 for ML-MMOH-CRF-2114.1-->
	<input type='hidden' name='mds_chk' id='mds_chk' value='<%=mds_chk %>'>
	
	<input type='hidden' name='rcmApplicable' id='rcmApplicable' value='<%=rcmApplicable %>'>

	<!--Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742-->
	<input type="hidden" name="isDeceasedDiagClassDeathRegAppl" id="isDeceasedDiagClassDeathRegAppl" value="<%=isDeceasedDiagClassDeathRegAppl%>">
	<input type="hidden" name="primary_diag_class" id="primary_diag_class" value="<%=primary_diag_class%>">
	<input type="hidden" name="pri_mand_postmortem_op_yn" id="pri_mand_postmortem_op_yn" value="<%=pri_mand_postmortem_op_yn%>">
	<input type="hidden" name="pri_mand_postmortem_ae_yn" id="pri_mand_postmortem_ae_yn" value="<%=pri_mand_postmortem_ae_yn%>">
	<input type="hidden" name="pri_mand_non_postmortem_op_yn" id="pri_mand_non_postmortem_op_yn" value="<%=pri_mand_non_postmortem_op_yn%>">
	<input type="hidden" name="pri_mand_non_postmortem_ae_yn" id="pri_mand_non_postmortem_ae_yn" value="<%=pri_mand_non_postmortem_ae_yn%>">
	<input type="hidden" name="secondary_diag_class" id="secondary_diag_class" value="<%=secondary_diag_class%>">
	<input type="hidden" name="sec_mand_postmortem_op_yn" id="sec_mand_postmortem_op_yn" value="<%=sec_mand_postmortem_op_yn%>">
	<input type="hidden" name="sec_mand_postmortem_ae_yn" id="sec_mand_postmortem_ae_yn" value="<%=sec_mand_postmortem_ae_yn%>">
	<input type="hidden" name="sec_mand_non_postmortem_op_yn" id="sec_mand_non_postmortem_op_yn" value="<%=sec_mand_non_postmortem_op_yn%>">
	<input type="hidden" name="sec_mand_non_postmortem_ae_yn" id="sec_mand_non_postmortem_ae_yn" value="<%=sec_mand_non_postmortem_ae_yn%>">
	<input type="hidden" name="practitioner_type" id="practitioner_type" value="<%=practitioner_type%>">
	<input type="hidden" name="date_of_birth" id="date_of_birth" value="<%=date_of_birth%>">
	<input type="hidden" name="patientgender" id="patientgender" value="<%=patientgender%>">

	<script>
	/*Added by Thamizh selvi against ML-MMOH-CRF-0646 Start*/
	if(document.forms[0].isCaseDtlsRadioBtnAppl.value == "true" && document.forms[0].module_id.value == "AE"){
		if(document.forms[0].trauma_yn.value != "Y" && document.forms[0].oscc_yn.value != "Y" && document.forms[0].surgical_yn.value != "Y" && document.forms[0].OandG_yn.value != "Y" && document.forms[0].non_emerg_yn.value != "Y"){
			document.forms[0].medical.checked	= true;
			document.forms[0].medical_yn.value	= "Y"
		}
		onLoadCaseDtlsChk();
	}/*End*/
	<%
		if(called_from.equals("CA"))
		{
		%>
			document.forms[0].cancel.disabled=true;
		<%
		}
		%>
	</script>
	<%
	if(P_ae_brought_dead_yn.equals("Y"))
	{
		out.println("<script>disableFields();</script>");
	}		

	%>

</form>
<script>
if ("<%=P_module_id%>"=="AE")
{
	document.getElementById("cnl_episode").disabled=true;
}
else
{
	
	if("<%=X_episode_id%>" == "")
	{					
		document.getElementById("cnl_episode").disabled=true; 		
		   
	}
	else
	{					
		document.getElementById("cnl_episode").disabled=false;				
	}
}
disableRecallDtlsOnAE();
disable();
//Modified by Shanmukh for ML-MMOH-CRF-0626 on 17-Apr-2018
if(document.forms[0].disposition_type){// Wednesday, March 17, 2010 20090 Venkat s
	var disposition_type='<%=disposition_type%>';
	var DispositionType='<%=DispositionType%>';
	if("<%=P_ae_brought_dead_yn%>"=="Y") {
		document.forms[0].disposition_type.value='';
    }else{		
			if(document.forms[0].customer_id.value!= 'SS'){
			   if(<%=isAutoCompDispTypeAppl%>){  
			     if(disposition_type!=DispositionType){
				     document.forms[0].disposition_type.value='<%=disposition_type%>';
				    } 
			    }else
			    document.forms[0].disposition_type.value='<%=disposition_type%>'; 
		    }  
		}
}
</script>
</body>
</html>
<%
 }else
{
      %>
	<script>
	alert(getMessage("MANAGE_QUEUE_NOT_ALL_CHECKOUT","OP"));
	window.close();
	history.go(-1);
	</script>
<%
 }
}catch ( Exception e ){ 
	//out.println(e);
	e.printStackTrace();
	}
finally
{
	try
	{
		if(pstmt !=null) pstmt.close();
		if(pstmt1 != null) pstmt1.close();
		if(pstmt2 != null) pstmt2.close();
		if(rs != null) rs.close();
		if(rs1 != null) rs1.close();
		if(rs2 != null) rs2.close();
	}catch(Exception ce){
		//out.println(ce);
		ce.printStackTrace();
		}

	ConnectionManager.returnConnection(conn,request);
}
}catch(Exception e)
{
e.printStackTrace();}
%>
<%!
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equals("null"))) ? "" : inputString );
	}

	public static String checkForDefault(String inputString, String defaultValue){
		return(((inputString == null) || (inputString.equals("null")) || (inputString.equals("")) ) ? defaultValue : inputString);
	}
%>

