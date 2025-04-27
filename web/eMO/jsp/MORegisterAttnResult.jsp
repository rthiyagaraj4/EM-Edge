<!DOCTYPE html>

<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.Common.*,org.json.simple.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ include file="../../eMP/jsp/PatientAddressLegends.jsp" %>
<html>

<head>
	<%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 request.setCharacterEncoding("UTF-8");


	 String user_id = (String) session.getValue("login_user");
	 Properties p		= (java.util.Properties) session.getValue("jdbc");
 
%>

    <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<Script language="JavaScript" src="../../eCommon/js/CommonCalendar.js" ></Script>
	<script language='javascript' src='../../eCommon/js/dchk.js'></script>	
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
	<script src='../../eMP/js/MPStillBirthDetails.js' language='javascript'></script>
	<script language='javascript' src='../../eMO/js/MORegisterAttn.js'></script>	
	<script language='javascript' src='../../eCommon/js/CommonLookup.js' > </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
 </head>
  <% 
        Connection con							= null;
    	PreparedStatement pstmt2				= null;
       	ResultSet vrs							= null;
		java.sql.Statement vpstmt				= null;
        PreparedStatement pstmt                 =null; 
		java.sql.Statement sstat                = null;
		String body_found_at="";
		String ocpn_class_desc="";
		String checkmlc="N";
		String checkpm="N";
		String disabledyn="";
		String release_fac_id="";  // Added Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg
		String release_fac_desc="";		// Added Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg
		String RELEASE_TO_FACILITY = "";// Added Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg
		String releasefacility = "visibility:hidden"; // Added Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg
		
		String reason_deceased_desc=""; //this line added for this CRF Bru-HIMS-CRF-366 [IN-039612]
	 	String mode                             = request.getParameter("mode")==null?"insert":request.getParameter("mode");
		/*Below line(s) added by Venkatesh.S on 12-Nov-2013 against Bru-HIMS-CRF-365 [IN:039572]*/
		String death_after_potmrtm_yn="";
		String death_after_potmrtm="";
		 	 
		 
        if(mode.equals("modify")||mode.equals("viewdata"))
		{	disabledyn="disabled" ; 
		    
		} else{death_after_potmrtm_yn="disabled";}
	  try
	  {
		String facilityId				        = checkForNull((String)session.getValue("facility_id"));
		String patient_id						= checkForNull(request.getParameter("patient_id"));
	    String accept_national_id_no_yn="";
        String nat_id_length="";
        String nat_id_prompt="";
		String addrl1                      = "";
	    String addrl2                      = "";
	    String addrl3                      = "";
	    String addrl4                      = "";
	    String postal_code                 = "";
		String res_town_desc="";
        String res_area_desc="";
        String region_desc="";
        String area_type="";  
		String relgn_code="";
		String relgn_desc="";
		String	claimant_type="";      
		String	claimant_type_code=""; 
		String	relationship="";       
		String	name="";               
		String	job_title="";          
		String  blurData="";
		String disunclim="";
		String	zip_code="";           
		String	country_code="";       
		String	res_town_code="";      
		String	res_area_code="";      
		String	region_code="";        
		String	telephone_off="";      
		String	telephone_res="";      
		String	email_id="";           
		String vechile_no="";
		String	mob_tel_no="";         
		String	nat_id_no="";          
		String	organization_name="";  
		String	patient_employee_id=""; 

		String	Passport_No=""; //Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743
		String	Other_Identification=""; //Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743

     	String body_claiming_date_time="";
     	String body_claiming_date_time_cnv="";
		String postmortem_startend_status ="";
	//	String hcare_type_code="";
		
		String	referred_by                 = "";
		String	death_manner_code           ="";
		String	body_cond_code              ="";
		String	high_risk_body_yn           =""; 
		String	unclaimed_body_yn           ="";
		String	death_certificate_reqd_yn   =""; 
		String	brought_by_police_yn        =""; 
		String	service_code                ="";  
		String	area_code                   ="";
		String	bed_no                      =""; 
		String	 rfid_tag_num           =""; 
		String	assign_date_time            ="";
		String	assign_date_time_cnv            ="";
        String  identification_marks        ="";
        String  place_of_death               ="";  
        String  postmortem_type              ="";
		String  postmortem_status           ="";
		String  referral_type="";
        String kcou ="";
		String hcare_setting_type=""; 
		String hcare_setting_type_desc="";
		String ref_source_code="";
		String referral_desc="";
		String referral_type_desc=""; 
		String  police_details              ="";
		String  police_approval_received_yn ="";
		String 	police_received_by          =""; 
		String 	police_received_date        =""; 
		String  consent_given_by            ="";  
        String  relationship_with_deceased  ="";
        String  consent_form_code           ="";
        String  consent_form_received_by    ="";
        String  consent_form_received_date  ="";
        String  consent_form_code1          ="";
        String  conscentgivenby1            =""; 
        String  deceasedrelationship1       =""; 
        String donor_card_available_yn="";
		String  consent_received_by1        ="";
        String  consent_received_date1      =""; 
        String  donar_card_no               ="";
        String  donar_card_details          ="";
        String  body_received_date          =""; 
        String  body_received_date_cnv      =""; 
		String police_approval_received_by_desc="";		
		String brought_dead_yn = "N";	
		String deceased_date			= "";
		String body_release_date_time   = "";	
		String encounter_id			    = "";
		String burial_permit_reqd_yn			    = "Y";   //Changes introduced for Bru-HIMS-CRF-161 [IN:030280] and KDAH-CRF-0038 [IN:029002] on 13.03.2012 by Suresh M
		String visit_adm_date_time      = "";
		String patient_class = "";
		String location = "";
	//	String specialty_desc = "";
//		String attend_pract_name = "";	
		String sys_date					=  "";
		String sys_date_cnv					=  "";
    	String mlc_yn = "N";
        String deathcseregby="";
		String regno = "";	
		String pol_rep_no = "";
		String pol_stn_id = "";
		String pol_id = "";
		String regn_allowed_in_mo_yn="";
		String regn_no="";
		String prevencdis="";
		String burial_permit_appr_by_name="";
		String consent_form_recd_by_name2="";
		String consent_form_recd_by_name="";
		String func_role_id="";	
		String burial_perm_no="";
		String burial_perm_by="";	
		String burial_perm_date="";
		String burial_perm_date_cnv="";
		String readText="";
	 	String disablebut="";
		String deceased_date_cnv = "";
		String body_release_date_time_cnv = "";
		String date_of_birth = "";
		String sex = "";
		String splty_code = "";		
		String pract_type = "";		
		String role_pract_type = "";		
		String locn_code = "";		
		String locn_type = "";
		/*Added by Thamizh selvi on 25th July 2017 for ML-MMOH-CRF-0689 Start*/
		String extBidYnFrmVw	= "";
		String pol_officer_name	= ""; 
		String pol_contact_no	= "";
		String calledFrom		= request.getParameter("calledFrom")==null?"":request.getParameter("calledFrom");
		String externalBidYn	= request.getParameter("externalBidYn")==null?"N":request.getParameter("externalBidYn");
		/*End*/
		/*Below line added for this CRF ML-MMOH-CRF-0695*/
		String function_id = request.getParameter("function_id1")==null?"":request.getParameter("function_id1");
		//End this CRF ML-MMOH-CRF-0695
        String functionid = request.getParameter("function_id")==null?"":request.getParameter("function_id");//Added by Shanmukh on 26th-JUNE-2018 for ML-ML-MMOH-CRF-1031
		String external=request.getParameter("external")==null?"N":request.getParameter("external");
		String dec_fac_id="";
		String dec_enc_id="";
		String dec_dt_time="";
		String burial_permit_approved_date=""; //Added by Kamatchi S on 12/10/2019 for ML-MMOH-SCF-1423
		boolean IsViewClaimantHistoryDisplay	= false;//Added For Bru-HIMS-CRF-0368 By Dharma on 18th Dec 2013 
		con = ConnectionManager.getConnection(request);
		/*Below line(s) added by venkateshs against ML-MMOH-CRF-0354 [IN057191] */
		Boolean siteSpecific = eCommon.Common.CommonBean.isSiteSpecific(con, "MR","MLC_TO_MEDICO_LEGAL_CASE");
		/*end ML-MMOH-CRF-0354 [IN057191] */
		Boolean isRemoveMandBPermitAppBy = eCommon.Common.CommonBean.isSiteSpecific(con, "MO","BURIAL_PERMIT_MANDATORY");//Added by Dharma on 2oth July against ML-MMOH-CRF-0692 [IN:062311]
		
		Boolean isClaimantChngsApplicable = eCommon.Common.CommonBean.isSiteSpecific(con, "MO","CLAIMANT_MNDT_FLD_RENAME"); //Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743

	   //Below line added for this CRF ML-MMOH-CRF-0695
	   boolean datetimeofclaimingApplicable =  eCommon.Common.CommonBean.isSiteSpecific(con, "MO","DATE_TIME_OF_CLAIMING");

	   Boolean rearrangeTabBurlPermtClaimnt = eCommon.Common.CommonBean.isSiteSpecific(con, "MO","MO_REARRANGE_TABS"); //Added by Ashwini on 17-Oct-2017 for ML-MMOH-CRF-0696

	   //Below line added against ML-MMOH-CRF-0737 by Mano
	   boolean mlcAndInfectiousDeceBodyApplicable =  eCommon.Common.CommonBean.isSiteSpecific(con, "MO","CHANGE_MLC_AND_INFEC_DECS_BODY");
	   String datetimeofclaiming="";
       //String disdatetimeofclaiming=""; 	   Commented for checkstyle 
	   //End this CRF ML-MMOH-CRF-0695
	   
	   /*Added by Ashwini on 11-Oct-2018 for ML-MMOH-CRF-1095*/
		JSONArray ClaimantTypeJsonArr = new JSONArray();
		ClaimantTypeJsonArr = eMO.MOCommonBean.getClaimantType(con,function_id);
		/*End ML-MMOH-CRF-1095*/
	   
	   //Added for this CRF ML-MMOH-CRF-0860.2
	   String maxsize="30";
	   String maximumLength="30";
       Boolean increasedaddressLength = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","INCREASED_ADDRESS_LINE_LENGTH");
	   if(increasedaddressLength){
	     maximumLength="50";
		 maxsize="64";
	   }
	  //End ML-MMOH-CRF-0860.2
	  
	  Boolean isChangeOfDateTimeClaimingAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MO","DATE_TIME_CLAIMING_CHANGE");//Added by Shanmukh on 25th-JUNE-2018 for ML-MMOH-CRF-1031
	  Boolean isReceivedDateTimeAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MO","RECEIVED_DATE_TIME");// Added by Shanmukh on 26th-JUNE-2018 for ML-MMOH-CRF-1036
	  Boolean isDateTimeOfDeathAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MO","DATE_TIME_OF_DEATH_APPL");// Added by Shanmukh  for ML-MMOH-CRF-1183
	  
	  //Added by Santhosh for ML-MMOH-CRF-1948
	  String date_time_of_climing ="";
	  String datetime_claim_mand ="";
	  Boolean datetimeOfClaimingAppl = false;
	  
	  datetimeOfClaimingAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MO","DATETIME_OF_CLAIMING");
	  pstmt2  = con.prepareStatement("select DATETIME_CLAIM_MAND from MO_PARAMETER where facility_id = '"+facilityId+"' ");		
		vrs = pstmt2.executeQuery();
		if((vrs!=null) && vrs.next()){
			datetime_claim_mand= checkForNull(vrs.getString("DATETIME_CLAIM_MAND"));
		}

		if(pstmt2 != null) {
			pstmt2.close();
		}
		if(vrs != null) {
			vrs.close();
		}
		//END
	   

	   Boolean siteCheck = eCommon.Common.CommonBean.isSiteSpecific(con,"MO","CAUSE_OF_DEATH"); //Added by Ashwin K for ML-MMOH-CRF-1891
 
		/*Below line added for this CRF  Bru-HIMS-CRF-407 [IN:045167]*/
		int regCount=0;
		String register_no=request.getParameter("register_no")==null?"":request.getParameter("register_no"); 
			  String sqlQuery="SELECT COUNT (*) reg_count  FROM or_order_line WHERE order_id in (SELECT order_id FROM or_order_line_mo  WHERE registration_no = '"+register_no+"' AND facility_id = '"+facilityId+"') and ORDER_LINE_STATUS Not in ('CN','DC')";			  
		      pstmt2=con.prepareStatement(sqlQuery); 
		      vrs=pstmt2.executeQuery();
		      if(vrs!=null && vrs.next()){
		           regCount=vrs.getInt("reg_count");
		      }		
		
		if(vrs!=null) vrs.close();
		if(pstmt2!=null)pstmt2.close();
		
		//End Bru-HIMS-CRF-407 [IN:045167]
         
		if(external.equals("Y") || mode.equals("viewdata")){
			/*pstmt2=con.prepareStatement("select DECEASED_FACILITY_ID,DECEASED_ENCOUNTER_ID,to_char(DECEASED_DATE,'dd/mm/yyyy hh24:mi') deceased_date,RELGN_CODE,mp_get_desc.mp_religion(relgn_code,'"+localeName+"',2) RELGN_DESC from mp_patient where patient_id=? and DECEASED_DATE is not null ");*/
			
			/*Above line commented and Below line added for this incident[65303]*/
			pstmt2=con.prepareStatement("select DECEASED_FACILITY_ID,DECEASED_ENCOUNTER_ID,to_char(DECEASED_DATE,'dd/mm/yyyy hh24:mi') deceased_date,RELGN_CODE,mp_get_desc.mp_religion(relgn_code,'"+localeName+"',2) RELGN_DESC from mp_patient where patient_id=?");
			
			pstmt2.setString(1,patient_id);
			vrs = pstmt2.executeQuery();

			if (vrs!=null && vrs.next())	{
				dec_fac_id=checkForNull(vrs.getString("DECEASED_FACILITY_ID"));
				dec_enc_id=checkForNull(vrs.getString("DECEASED_ENCOUNTER_ID"));
				dec_dt_time=checkForNull(vrs.getString("deceased_date"));
				relgn_code=checkForNull(vrs.getString("RELGN_CODE"));
				relgn_desc=checkForNull(vrs.getString("RELGN_DESC"));
			}
			
			

			if(vrs!=null) vrs.close();
			if(pstmt2!=null)pstmt2.close();

			
		}
		
			
		
		pstmt2  = con.prepareStatement("select count(*) from pr_encounter where facility_id= ?  and patient_id= ?");	
		
        if(external.equals("Y")){
			pstmt2.setString(1,dec_fac_id);
		}else{
			pstmt2.setString(1,facilityId);
		}
		pstmt2.setString(2,patient_id);
		
		vrs = pstmt2.executeQuery();
            if(vrs.next())
            {
           prevencdis="";
				
            }else
			 {
			   prevencdis="disabled";
			 }
        if (vrs!=null) vrs.close();
		 if(pstmt2!=null) pstmt2.close();

		
				JSONObject json = new JSONObject(); // added by mujafar for ML-MMOH-CRF-0996 start
				json			 = eMO.MOCommonBean.getMOParam(con, facilityId); 
				String enable_rfid_yn = (String)json.get("enable_rfid_yn"); // added by mujafar for ML-MMOH-CRF-0996 end
		
		
		
		
		pstmt2  = con.prepareStatement("select to_char(sysdate,'dd/mm/yyyy hh24:mi') from dual");
        vrs = pstmt2.executeQuery();
        if (vrs!=null)
        {
            while (vrs.next())
            {
                sys_date = vrs.getString(1);
				burial_perm_date=sys_date;
            }
        }if (vrs!=null) vrs.close();
		 if(pstmt2!=null) pstmt2.close();

		if(sys_date!=null && !sys_date.equals(""))
		{
			sys_date_cnv = DateUtils.convertDate(sys_date,"DMYHM","en",localeName); 	
		}

		//pstmt2 = con.prepareStatement("select func_role_id from sm_appl_user where appl_user_id = ? ");
		pstmt2 = con.prepareStatement("select a.func_role_id func_role_id, b.pract_type pract_type from sm_appl_user a, am_practitioner b where 		a.appl_user_id = ? and a.func_role_id=b.practitioner_id");
		pstmt2.setString(1,user_id);
		vrs = pstmt2.executeQuery();	
		
		while(vrs.next())
			 {							
				func_role_id		= checkForNull(vrs.getString("func_role_id"));				
				role_pract_type		= vrs.getString("pract_type");
			 }
			 
		
		//pstmt2  = con.prepareStatement("select PATIENT_ID, PATIENT_NAME, SEX, DATE_OF_BIRTH, AGE, DECEASED_DATE, DEATH_STATUS_REMARKS, RELGN_CODE, RELGN_DESC, CITIZEN_YN, FACILITY_ID, ENCOUNTER_ID, VISIT_ADM_DATE_TIME, PATIENT_CLASS, ASSIGN_CARE_LOCN_TYPE, ASSIGN_CARE_LOCN_CODE, LOCATION, TREATMENT_AREA_CODE, TREATMENT_AREA_DESC, ASSIGN_ROOM_NUM, ASSIGN_BED_NUM, DISCHARGE_DATE_TIME, SPECIALTY_CODE, SPECIALTY_DESC, ATTEND_PRACTITIONER_ID, ATTEND_PRACT_NAME, DISCH_PRACTITIONER_ID, DISCH_PRACT_NAME, MLC_YN, PM_YN, HIGH_RISK_YN, POL_REP_NO, POL_STN_ID, POL_ID, BODY_RELEASE_DATE_TIME, BROUGHT_DEAD_YN, REGN_ALLOWED_IN_MO_YN, BURIAL_PERMIT_NO, REFERRAL_ID, REFERRAL_TYPE, REFERRAL_TYPE_DESC, HCARE_SETTING_TYPE, HCARE_SETTING_TYPE_DESC, REF_SOURCE_CODE, REFERRAL_DESC, REFERRED_BY from MO_ENCOUNTER_DTLS_VW where patient_id = ?");

		if(external.equals("Y") && dec_enc_id.equals("")){
			

			pstmt2  = con.prepareStatement("select BURIAL_PERMIT_REQD_YN from MO_PARAMETER where facility_id = '"+facilityId+"' ");		
			vrs = pstmt2.executeQuery();
			if((vrs!=null) && vrs.next()){
				burial_permit_reqd_yn= checkForNull(vrs.getString("BURIAL_PERMIT_REQD_YN"));
			}

			if(pstmt2 != null) {
				pstmt2.close();
			}
			if(vrs != null) {
				vrs.close();
			}
		}
		String enc_query="";
		/*Added For Bru-HIMS-CRF-0368 By Dharma on 29th Nov 2013 Start*/
		
		
		/*if(external.equals("Y") && !dec_enc_id.equals("")){
			enc_query="select a.PATIENT_ID, DECEASED_DATE, DATE_OF_BIRTH , SEX, SPECIALTY_CODE , RELGN_CODE,mp_get_desc.mp_religion(relgn_code,'"+localeName+"',2) RELGN_DESC, ENCOUNTER_ID, VISIT_ADM_DATE_TIME, PATIENT_CLASS, ASSIGN_CARE_LOCN_TYPE, assign_care_locn_code, DECODE(assign_care_locn_type,'N', IP_GET_DESC.IP_NURSING_UNIT(facility_id, assign_care_locn_code,'"+localeName+"',1), OP_GET_DESC.OP_CLINIC(facility_id, assign_care_locn_code,'"+localeName+"',1)) LOCATION,MLC_YN, DISCH_PRACTITIONER_ID,(select PRACT_TYPE from am_practitioner where practitioner_id=a.DISCH_PRACTITIONER_ID) DISCH_PRACT_TYPE, am_get_desc.AM_PRACTITIONER(disch_practitioner_id,'"+localeName+"',2) DISCH_PRACT_NAME,  PM_YN, HIGH_RISK_YN, POL_REP_NO, POL_STN_ID, POL_ID, BODY_RELEASE_DATE_TIME, BROUGHT_DEAD_YN, '' REGN_ALLOWED_IN_MO_YN, '' BURIAL_PERMIT_NO, '' REFERRAL_TYPE, ''REFERRAL_TYPE_DESC,'' HCARE_SETTING_TYPE, ''  HCARE_SETTING_TYPE_DESC,'' REF_SOURCE_CODE, '' REFERRAL_DESC ,( select BURIAL_PERMIT_REQD_YN from MO_PARAMETER where facility_id = '"+facilityId+"')burial_permit_reqd_yn, '' REFERRED_BY from PR_ENCOUNTER a,mp_patient b where a.patient_id = ? and a.patient_id=b.patient_id and a.facility_id='"+dec_fac_id+"' and a.encounter_id="+dec_enc_id;
		}else{
			enc_query="select PATIENT_ID, DECEASED_DATE, DATE_OF_BIRTH , SEX, SPECIALTY_CODE , RELGN_CODE,mp_get_desc.mp_religion(relgn_code,'"+localeName+"',2) RELGN_DESC, ENCOUNTER_ID, VISIT_ADM_DATE_TIME, PATIENT_CLASS, ASSIGN_CARE_LOCN_TYPE, assign_care_locn_code, DECODE(assign_care_locn_type,'N',IP_GET_DESC.IP_NURSING_UNIT(facility_id, assign_care_locn_code,'"+localeName+"',1), OP_GET_DESC.OP_CLINIC(facility_id,assign_care_locn_code,'"+localeName+"',1)) LOCATION, DISCH_PRACTITIONER_ID, DISCH_PRACT_TYPE, am_get_desc.AM_PRACTITIONER(disch_practitioner_id,'"+localeName+"',2) DISCH_PRACT_NAME, MLC_YN, PM_YN, HIGH_RISK_YN, POL_REP_NO, POL_STN_ID, POL_ID, BODY_RELEASE_DATE_TIME, BROUGHT_DEAD_YN, REGN_ALLOWED_IN_MO_YN, BURIAL_PERMIT_NO, REFERRAL_TYPE, REFERRAL_TYPE REFERRAL_TYPE_DESC, HCARE_SETTING_TYPE, am_get_desc.AM_HCARE_SETTING_TYPE(HCARE_SETTING_TYPE,'"+localeName+"',2) HCARE_SETTING_TYPE_DESC, REF_SOURCE_CODE, am_get_desc.AM_REFERRAL(REF_SOURCE_CODE,'"+localeName+"',2) REFERRAL_DESC ,( select BURIAL_PERMIT_REQD_YN from MO_PARAMETER where facility_id = '"+facilityId+"')burial_permit_reqd_yn,  REFERRED_BY from MO_ENCOUNTER_DTLS_VW where patient_id = ?";
		}*/

		String external_rec_exists	= "N";
		String latest_facility_id	= "";
		
			String qry_latest_facility_id	= "select a.FACILITY_ID from mo_mortuary_regn a  where   a.patient_id=? order by a.ADDED_DATE desc";
			pstmt2  = con.prepareStatement(qry_latest_facility_id);
			pstmt2.setString(1,patient_id);
			vrs = pstmt2.executeQuery();
			if(vrs!=null){
				if(vrs.next()){
					latest_facility_id	= vrs.getString("FACILITY_ID");
				}
			}
					
			if(pstmt2 != null) {
				pstmt2.close();
			}
			if(vrs != null) {
				vrs.close();
			}
			int external_rec_count	= 0; 
			String latest_claiment_fac_id	= "";
			String latest_claiment_regn_no	= "";
		
			String qry_external_rec_exists	= "select  a.FACILITY_ID,b.REGISTRATION_NO from mo_mortuary_regn a,mo_claimant b where a.REGISTRATION_NO=b.REGISTRATION_NO and  a.patient_id=? order by a.ADDED_DATE desc";
			pstmt2  = con.prepareStatement(qry_external_rec_exists);
			pstmt2.setString(1,patient_id);
			vrs = pstmt2.executeQuery();
			if(vrs!=null){
				while(vrs.next()){
					external_rec_exists	= "Y";
					external_rec_count++;
					if(external_rec_count==1){
						latest_claiment_fac_id	= vrs.getString("FACILITY_ID");
						latest_claiment_regn_no	= vrs.getString("REGISTRATION_NO");
					}
				}
			}
			
			if(pstmt2 != null) {
				pstmt2.close();
			}
			if(vrs != null) {
				vrs.close();
			}

		
		

		if(external_rec_exists.equals("Y") && external.equals("Y")){
			enc_query="select PATIENT_ID, DECEASED_DATE, DATE_OF_BIRTH , SEX, SPECIALTY_CODE , RELGN_CODE,mp_get_desc.mp_religion(relgn_code,'"+localeName+"',2) RELGN_DESC, ENCOUNTER_ID, VISIT_ADM_DATE_TIME, PATIENT_CLASS, ASSIGN_CARE_LOCN_TYPE, assign_care_locn_code, DECODE(assign_care_locn_type,'N',IP_GET_DESC.IP_NURSING_UNIT(facility_id, assign_care_locn_code,'"+localeName+"',1), OP_GET_DESC.OP_CLINIC(facility_id,assign_care_locn_code,'"+localeName+"',1)) LOCATION, DISCH_PRACTITIONER_ID, DISCH_PRACT_TYPE, am_get_desc.AM_PRACTITIONER(disch_practitioner_id,'"+localeName+"',1) DISCH_PRACT_NAME, MLC_YN, PM_YN, HIGH_RISK_YN, POL_REP_NO, POL_STN_ID, POL_ID, BODY_RELEASE_DATE_TIME, BROUGHT_DEAD_YN, REGN_ALLOWED_IN_MO_YN, BURIAL_PERMIT_NO, REFERRAL_TYPE, REFERRAL_TYPE REFERRAL_TYPE_DESC, HCARE_SETTING_TYPE, am_get_desc.AM_HCARE_SETTING_TYPE(HCARE_SETTING_TYPE,'"+localeName+"',2) HCARE_SETTING_TYPE_DESC, REF_SOURCE_CODE, am_get_desc.AM_REFERRAL(REF_SOURCE_CODE,'"+localeName+"',2) REFERRAL_DESC ,( select BURIAL_PERMIT_REQD_YN from MO_PARAMETER where facility_id = '"+facilityId+"')burial_permit_reqd_yn,  REFERRED_BY from MO_ENCOUNTER_DTLS_VW where patient_id = ? ";
		}
		else if(external.equals("Y") && !dec_enc_id.equals("")){
			enc_query="select a.PATIENT_ID, DECEASED_DATE, DATE_OF_BIRTH , SEX, SPECIALTY_CODE , RELGN_CODE,mp_get_desc.mp_religion(relgn_code,'"+localeName+"',2) RELGN_DESC, ENCOUNTER_ID, VISIT_ADM_DATE_TIME, PATIENT_CLASS, ASSIGN_CARE_LOCN_TYPE, assign_care_locn_code, DECODE(assign_care_locn_type,'N', IP_GET_DESC.IP_NURSING_UNIT(facility_id, assign_care_locn_code,'"+localeName+"',1), OP_GET_DESC.OP_CLINIC(facility_id, assign_care_locn_code,'"+localeName+"',1)) LOCATION,MLC_YN, DISCH_PRACTITIONER_ID,(select PRACT_TYPE from am_practitioner where practitioner_id=a.DISCH_PRACTITIONER_ID) DISCH_PRACT_TYPE, am_get_desc.AM_PRACTITIONER(disch_practitioner_id,'"+localeName+"',1) DISCH_PRACT_NAME,  PM_YN, HIGH_RISK_YN, POL_REP_NO, POL_STN_ID, POL_ID, BODY_RELEASE_DATE_TIME, BROUGHT_DEAD_YN, '' REGN_ALLOWED_IN_MO_YN, '' BURIAL_PERMIT_NO, '' REFERRAL_TYPE, ''REFERRAL_TYPE_DESC,'' HCARE_SETTING_TYPE, ''  HCARE_SETTING_TYPE_DESC,'' REF_SOURCE_CODE, '' REFERRAL_DESC ,( select BURIAL_PERMIT_REQD_YN from MO_PARAMETER where facility_id = '"+facilityId+"')burial_permit_reqd_yn, '' REFERRED_BY from PR_ENCOUNTER a,mp_patient b where a.patient_id = ? and a.patient_id=b.patient_id and a.facility_id='"+dec_fac_id+"' and a.encounter_id="+dec_enc_id;
		}else{
			enc_query="select PATIENT_ID, DECEASED_DATE, DATE_OF_BIRTH , SEX, SPECIALTY_CODE , RELGN_CODE,mp_get_desc.mp_religion(relgn_code,'"+localeName+"',2) RELGN_DESC, ENCOUNTER_ID, VISIT_ADM_DATE_TIME, PATIENT_CLASS, ASSIGN_CARE_LOCN_TYPE, assign_care_locn_code, DECODE(assign_care_locn_type,'N',IP_GET_DESC.IP_NURSING_UNIT(facility_id, assign_care_locn_code,'"+localeName+"',1), OP_GET_DESC.OP_CLINIC(facility_id,assign_care_locn_code,'"+localeName+"',1)) LOCATION, DISCH_PRACTITIONER_ID, DISCH_PRACT_TYPE, am_get_desc.AM_PRACTITIONER(disch_practitioner_id,'"+localeName+"',1) DISCH_PRACT_NAME, MLC_YN, PM_YN, HIGH_RISK_YN, POL_REP_NO, POL_STN_ID, POL_ID, BODY_RELEASE_DATE_TIME, BROUGHT_DEAD_YN, REGN_ALLOWED_IN_MO_YN, BURIAL_PERMIT_NO, REFERRAL_TYPE, REFERRAL_TYPE REFERRAL_TYPE_DESC, HCARE_SETTING_TYPE, am_get_desc.AM_HCARE_SETTING_TYPE(HCARE_SETTING_TYPE,'"+localeName+"',2) HCARE_SETTING_TYPE_DESC, REF_SOURCE_CODE, am_get_desc.AM_REFERRAL(REF_SOURCE_CODE,'"+localeName+"',2) REFERRAL_DESC ,( select BURIAL_PERMIT_REQD_YN from MO_PARAMETER where facility_id = '"+facilityId+"')burial_permit_reqd_yn,  REFERRED_BY from MO_ENCOUNTER_DTLS_VW where patient_id = ?";
		}//Modified by Ashwini on 01-Jul-2019 for ML-MMOH-CRF-0990
		
		/*Added For Bru-HIMS-CRF-0368 By Dharma on 29th Nov 2013 End*/

		pstmt2  = con.prepareStatement(enc_query);

		
		pstmt2.setString(1,patient_id);
		vrs = pstmt2.executeQuery();
		if(vrs!=null)
		 {
			while(vrs.next())
			 {
	
				encounter_id			= checkForNull(vrs.getString("encounter_id"));
				visit_adm_date_time		= checkForNull(vrs.getString("visit_adm_date_time"));
				date_of_birth			= checkForNull(vrs.getString("DATE_OF_BIRTH"));
				sex					    = checkForNull(vrs.getString("SEX"));
				splty_code				= checkForNull(vrs.getString("SPECIALTY_CODE"));
				patient_class			= checkForNull(vrs.getString("patient_class"));
				location				= checkForNull(vrs.getString("location"));			
				locn_code				= checkForNull(vrs.getString("assign_care_locn_code"));			
				locn_type				= checkForNull(vrs.getString("ASSIGN_CARE_LOCN_TYPE"));			
				burial_permit_appr_by_name= checkForNull(vrs.getString("disch_pract_name"));
				burial_permit_reqd_yn= checkForNull(vrs.getString("BURIAL_PERMIT_REQD_YN"));

				burial_perm_by = checkForNull(vrs.getString("disch_practitioner_id"));
				//dis_pract_type = checkForNull(vrs.getString("DISCH_PRACT_TYPE"));
	
				deceased_date			= checkForNull(vrs.getString("deceased_date"));	
				if(deceased_date!=null && !deceased_date.equals(""))
				{
					deceased_date_cnv = DateUtils.convertDate(deceased_date,"DMYHM","en",localeName); 	
				}
				mlc_yn					= checkForNull(vrs.getString("mlc_yn"),"N");
				high_risk_body_yn       = checkForNull(vrs.getString("HIGH_RISK_YN"),"N");
				postmortem_status			= checkForNull(vrs.getString("PM_YN"),"N");
				
				pol_rep_no				= checkForNull(vrs.getString("pol_rep_no"));
				pol_stn_id				= checkForNull(vrs.getString("pol_stn_id"));
				pol_id					= checkForNull(vrs.getString("pol_id"));
				body_release_date_time  = checkForNull(vrs.getString("body_release_date_time"));

				if(body_release_date_time!=null && !body_release_date_time.equals(""))
				{
					body_release_date_time_cnv = DateUtils.convertDate(body_release_date_time,"DMYHM","en",localeName); 	
				}

				referral_type           =checkForNull(vrs.getString("referral_type"));
				referral_type_desc      =checkForNull(vrs.getString("referral_type_desc"));

				if( referral_type_desc!=null && !referral_type_desc.equals("") && referral_type_desc.equals("L"))
				{
					referral_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.loginfacility.label","common_labels");
				}
				else if(referral_type_desc!=null && !referral_type_desc.equals("") && referral_type_desc.equals("E"))
				{
					referral_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enterprise.label","common_labels");
				}
				else if(referral_type_desc!=null && !referral_type_desc.equals("") && referral_type_desc.equals("X"))
				{
					referral_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels");
				}

				hcare_setting_type      =checkForNull(vrs.getString("hcare_setting_type"));
				hcare_setting_type_desc =checkForNull(vrs.getString("hcare_setting_type_desc"));
				ref_source_code         =checkForNull(vrs.getString("ref_source_code"));
				referral_desc           =checkForNull(vrs.getString("referral_desc"));
				referred_by   	        =checkForNull(vrs.getString("referred_by"));
                relgn_code=checkForNull(vrs.getString("RELGN_CODE"));
				relgn_desc=checkForNull(vrs.getString("RELGN_DESC"));		
				
				brought_dead_yn			= checkForNull(vrs.getString("brought_dead_yn"),"N");
			    regn_allowed_in_mo_yn=checkForNull(vrs.getString("regn_allowed_in_mo_yn"));
				//Commented below line and added it out of this while loop (for patients without encounter)
			    //if (mode.equals("modify")||mode.equals("viewdata"))regn_allowed_in_mo_yn="Y";				
				
				if(func_role_id==null||func_role_id=="") 
				{
					deathcseregby	=	burial_perm_by;
					pract_type		=	checkForNull(vrs.getString("DISCH_PRACT_TYPE"));
				}
				else
				{
					deathcseregby = func_role_id;
					pract_type    = role_pract_type;
				}

				/*
				if(brought_dead_yn.equals("Y"))
				{
					burial_perm_by="";
				}
				*/
			}
		}
		if(vrs!=null) vrs.close();
		if(pstmt2!=null) pstmt2.close();
		if (mode.equals("modify")||mode.equals("viewdata"))regn_allowed_in_mo_yn="Y";//Added by Thamizh selvi on 19th Sep 2017 against [IN:065280]
	//if(mode.equals("modify")||mode.equals("viewdata")).
	/*Modified For Bru-HIMS-CRF-0368 By Dharma on 29th Nov 2013*/
	if(mode.equals("modify")||mode.equals("viewdata") || (external.equals("Y")))	
	{
	//pstmt2  = con.prepareStatement("select REGISTRATION_NO, UNCLAIMED_BODY_YN, BODY_RECEIVED_DATE, HIGH_RISK_BODY_YN, DEATH_MANNER_CODE, BODY_COND_CODE, PLACE_OF_DEATH, DEATH_CERTIFICATE_REQD_YN, IDENTIFICATION_MARKS, MLC_YN, BROUGHT_BY_POLICE_YN, SERVICE_CODE, PM_YN, POSTMORTEM_TYPE, AREA_CODE, BED_NO, AREA_TYPE, ASSIGN_DATE_TIME, POL_REP_NO, POL_STN_ID, POL_ID, POLICE_DTLS, POLICE_APPROVAL_RECEIVED_YN, POLICE_APPROVAL_RECEIVED_BY, POLICE_APPROVAL_RECD_BY_NAME, POLICE_APPROVAL_RECEIVED_DATE, CONSENT_GIVEN_BY, RELATIONSHIP_WITH_DECEASED, CONSENT_FORM_CODE, CONSENT_FORM_RECEIVED_BY, CONSENT_FORM_RECD_BY_NAME, CONSENT_FORM_RECEIVED_DATE, DONOR_CARD_AVAILABLE_YN, DONOR_CARD_NO, DONOR_CARD_DETAILS, CONSENT_GIVEN_BY2, RELATIONSHIP_WITH_DECEASED2, CONSENT_FORM_CODE2, CONSENT_FORM_RECEIVED_BY2, CONSENT_FORM_RECD_BY_NAME2, CONSENT_FORM_RECEIVED_DATE2, POSTMORTEM_STATUS, BURIAL_PERMIT_NO, BURIAL_PERMIT_APPROVED_BY, BURIAL_PERMIT_APPR_BY_NAME, CLAIM_DATE_TIME, VEHICLE_NUM,     BODY_FOUND_AT from mo_mortuary_regn_vw where patient_id = ?");

	 /*Below  line(s) DEATH_CODE_AFTER_POSTMRM column added by Venkatesh.S on 12-Nov-2013 against Bru-HIMS-CRF-365 [IN:039572]*/
	
	 
	 //pstmt2  = con.prepareStatement("select REGISTRATION_NO, UNCLAIMED_BODY_YN, BODY_RECEIVED_DATE, HIGH_RISK_BODY_YN, DEATH_MANNER_CODE, BODY_COND_CODE, PLACE_OF_DEATH, DEATH_CERTIFICATE_REQD_YN, IDENTIFICATION_MARKS, MLC_YN, BROUGHT_BY_POLICE_YN, SERVICE_CODE, PM_YN, POSTMORTEM_TYPE, AREA_CODE, BED_NO,RFID_TAG_NUM, AREA_TYPE, ASSIGN_DATE_TIME, POL_REP_NO, POL_STN_ID, POL_ID, POLICE_DTLS, POLICE_APPROVAL_RECEIVED_YN, POLICE_APPROVAL_RECEIVED_BY, am_get_desc.AM_PRACTITIONER(police_approval_received_by,'"+localeName+"',2) POLICE_APPROVAL_RECD_BY_NAME, POLICE_APPROVAL_RECEIVED_DATE, CONSENT_GIVEN_BY, RELATIONSHIP_WITH_DECEASED, CONSENT_FORM_CODE, CONSENT_FORM_RECEIVED_BY,    am_get_desc.AM_PRACTITIONER(consent_form_received_by,'"+localeName+"',2) CONSENT_FORM_RECD_BY_NAME, CONSENT_FORM_RECEIVED_DATE,    DONOR_CARD_AVAILABLE_YN, DONOR_CARD_NO, DONOR_CARD_DETAILS, CONSENT_GIVEN_BY2, RELATIONSHIP_WITH_DECEASED2, CONSENT_FORM_CODE2, CONSENT_FORM_RECEIVED_BY2, am_get_desc.AM_PRACTITIONER(CONSENT_FORM_RECEIVED_BY2,'"+localeName+"',2) CONSENT_FORM_RECD_BY_NAME2, CONSENT_FORM_RECEIVED_DATE2, POSTMORTEM_STATUS, BURIAL_PERMIT_NO, BURIAL_PERMIT_APPROVED_BY,     am_get_desc.AM_PRACTITIONER(BURIAL_PERMIT_APPROVED_BY,'"+localeName+"',2) BURIAL_PERMIT_APPR_BY_NAME, CLAIM_DATE_TIME, VEHICLE_NUM, BODY_FOUND_AT,ACTUAL_DEATH_MANNER_CODE from mo_mortuary_regn_vw where patient_id = ?");
	
	 /* FACILITY_ID Added For Bru-HIMS-CRF-0368 By Dharma on 3rd Dec 2013*/
	 pstmt2  = con.prepareStatement("select REGISTRATION_NO, UNCLAIMED_BODY_YN, BODY_RECEIVED_DATE, HIGH_RISK_BODY_YN, DEATH_MANNER_CODE, BODY_COND_CODE, PLACE_OF_DEATH, DEATH_CERTIFICATE_REQD_YN, IDENTIFICATION_MARKS, MLC_YN, BROUGHT_BY_POLICE_YN, SERVICE_CODE, PM_YN, POSTMORTEM_TYPE, AREA_CODE, BED_NO,RFID_TAG_NUM, AREA_TYPE, ASSIGN_DATE_TIME, POL_REP_NO, POL_STN_ID, POL_ID, POLICE_DTLS, POLICE_APPROVAL_RECEIVED_YN, POLICE_APPROVAL_RECEIVED_BY, am_get_desc.AM_PRACTITIONER(police_approval_received_by,'"+localeName+"',2) POLICE_APPROVAL_RECD_BY_NAME, POLICE_APPROVAL_RECEIVED_DATE, CONSENT_GIVEN_BY, RELATIONSHIP_WITH_DECEASED, CONSENT_FORM_CODE, CONSENT_FORM_RECEIVED_BY,    am_get_desc.AM_PRACTITIONER(consent_form_received_by,'"+localeName+"',2) CONSENT_FORM_RECD_BY_NAME, CONSENT_FORM_RECEIVED_DATE,    DONOR_CARD_AVAILABLE_YN, DONOR_CARD_NO, DONOR_CARD_DETAILS, CONSENT_GIVEN_BY2, RELATIONSHIP_WITH_DECEASED2, CONSENT_FORM_CODE2, CONSENT_FORM_RECEIVED_BY2, am_get_desc.AM_PRACTITIONER(CONSENT_FORM_RECEIVED_BY2,'"+localeName+"',2) CONSENT_FORM_RECD_BY_NAME2, CONSENT_FORM_RECEIVED_DATE2, POSTMORTEM_STATUS, BURIAL_PERMIT_NO, BURIAL_PERMIT_APPROVED_BY, BURIAL_PERMIT_APPR_BY_NAME, CLAIM_DATE_TIME, VEHICLE_NUM, BODY_FOUND_AT,ACTUAL_DEATH_MANNER_CODE,external_bid_yn,police_officer_name, police_contact_no,BURIAL_PERMIT_APPROVED_DATE from mo_mortuary_regn_vw where patient_id = ? and FACILITY_ID=?");//Modified by Thamizh selvi on 1st Aug 2017 for ML-MMOH-CRF-0689
	 //Modified by Ashwini on 01-Jul-2019 for ML-MMOH-CRF-0990
	 //Modified by Kamatchi S on 12/10/2019 for ML-MMOH-SCF-1423


	pstmt2.setString(1,patient_id);
	/*Added For Bru-HIMS-CRF-0368 By Dharma on 3rd Dec 2013 Start*/
	
	if(external.equals("Y") && mode.equals("insert")){
		pstmt2.setString(2,latest_facility_id);	
	}else{
		pstmt2.setString(2,facilityId);	
	}
	/*Added For Bru-HIMS-CRF-0368 By Dharma on 3rd Dec 2013 End*/
	vrs = pstmt2.executeQuery();
	while(vrs.next())
		 {
	regn_no=vrs.getString("registration_no")==null?"":vrs.getString("registration_no"); 	
	vechile_no=vrs.getString("VEHICLE_NUM")==null?"":vrs.getString("VEHICLE_NUM"); 	
	if(!mode.equals("insert")){
		postmortem_startend_status 	= vrs.getString("POSTMORTEM_STATUS")==null?"":vrs.getString("POSTMORTEM_STATUS"); 
	}else{
		postmortem_startend_status	= "";
	}
	
	burial_permit_appr_by_name=vrs.getString("burial_permit_appr_by_name")==null?"":vrs.getString("burial_permit_appr_by_name"); 	donor_card_available_yn=vrs.getString("donor_card_available_yn")==null?"":vrs.getString("donor_card_available_yn"); 
	body_claiming_date_time=vrs.getString("CLAIM_DATE_TIME")==null?"":vrs.getString("CLAIM_DATE_TIME"); 

	burial_perm_no=vrs.getString("BURIAL_PERMIT_NO")== null?"":vrs.getString("BURIAL_PERMIT_NO");
    body_found_at=vrs.getString("BODY_FOUND_AT")== null?"":vrs.getString("BODY_FOUND_AT");
	burial_perm_by=vrs.getString("BURIAL_PERMIT_APPROVED_BY") == null?"":vrs.getString("BURIAL_PERMIT_APPROVED_BY");
	area_type=vrs.getString("area_type") == null?"":vrs.getString("area_type");
	/* Below line(s) added by Venkatesh.S on 12-Nov-2013 against Bru-HIMS-CRF-365 [IN:039572] and 45192*/
	death_after_potmrtm=vrs.getString("ACTUAL_DEATH_MANNER_CODE") == null?"":vrs.getString("ACTUAL_DEATH_MANNER_CODE");
	/*Added by Thamizh selvi on 1st Aug 2017 for ML-MMOH-CRF-0689 Start*/
	extBidYnFrmVw		= vrs.getString("external_bid_yn");
	pol_officer_name	= vrs.getString("police_officer_name") == null?"":vrs.getString("police_officer_name");
	pol_contact_no		= vrs.getString("police_contact_no") == null?"":vrs.getString("police_contact_no");
	/*End*/
	if(death_after_potmrtm.equals(""))  
	  {death_after_potmrtm_yn="disabled";}
	if(burial_perm_no!="")
	{
	readText="readOnly";
	disablebut="disabled";
	
	}else
	{
	blurData="onBlur=document.getElementById('body_burial_permit_no').focus();";
	}
	body_received_date=vrs.getString("body_received_date")==null?"":vrs.getString("body_received_date");

	if(body_received_date!=null && !body_received_date.equals(""))
	{
		body_received_date_cnv = DateUtils.convertDate(body_received_date,"DMYHM","en",localeName); 	
	}
	
	death_manner_code=vrs.getString("death_manner_code")==null?"":vrs.getString("death_manner_code"); 
	body_cond_code=vrs.getString("body_cond_code")==null?"":vrs.getString("body_cond_code"); 
	high_risk_body_yn= vrs.getString("high_risk_body_yn")==null?"":vrs.getString("high_risk_body_yn"); 
	unclaimed_body_yn=vrs.getString("unclaimed_body_yn")==null?"":vrs.getString("unclaimed_body_yn"); 
	if(unclaimed_body_yn.equals("N"))disunclim="disabled";
	death_certificate_reqd_yn= vrs.getString("death_certificate_reqd_yn")==null?"":vrs.getString("death_certificate_reqd_yn"); 
	brought_by_police_yn= vrs.getString("brought_by_police_yn")==null?"":vrs.getString("brought_by_police_yn"); 
	mlc_yn= vrs.getString("mlc_yn")==null?"":vrs.getString("mlc_yn"); 
	

	//Below condition Added For Bru-HIMS-CRF-0368 By Dharma on 16th Dec 2013
	if(!external.equals("Y") || !mode.equals("insert")){
		service_code=  vrs.getString("service_code")==null?"":vrs.getString("service_code");
		area_code=vrs.getString("area_code")==null?"":vrs.getString("area_code");
		bed_no= vrs.getString("bed_no")==null?"":vrs.getString("bed_no"); 
		rfid_tag_num= vrs.getString("RFID_TAG_NUM")==null?"":vrs.getString("RFID_TAG_NUM"); 
		assign_date_time=vrs.getString("assign_date_time")==null?"":vrs.getString("assign_date_time"); 
	}

	if(assign_date_time!=null && !assign_date_time.equals(""))
	{
		assign_date_time_cnv = DateUtils.convertDate(assign_date_time,"DMYHM","en",localeName); 	
	}

	pol_rep_no				= checkForNull(vrs.getString("pol_rep_no"));
	pol_stn_id				= checkForNull(vrs.getString("pol_stn_id"));
	pol_id					= checkForNull(vrs.getString("pol_id"));
	police_approval_received_yn	= checkForNull(vrs.getString("police_approval_received_yn"));
	police_received_by					= checkForNull(vrs.getString("police_approval_received_by"));
	police_approval_received_by_desc=checkForNull(vrs.getString("POLICE_APPROVAL_RECD_BY_NAME"));
	police_received_date					= checkForNull(vrs.getString("police_approval_received_date"));

	if(police_received_date!=null && !police_received_date.equals(""))
	{
		police_received_date = DateUtils.convertDate(police_received_date,"DMYHM","en",localeName); 	
	}
				
	police_details=vrs.getString("police_dtls")==null?"":vrs.getString("police_dtls");   identification_marks=vrs.getString("identification_marks")==null?"":vrs.getString("identification_marks");   
	place_of_death=vrs.getString("place_of_death")==null?"":vrs.getString("place_of_death");    
	postmortem_type= vrs.getString("postmortem_type")==null?"":vrs.getString("postmortem_type"); postmortem_status=vrs.getString("PM_YN")==null?"":vrs.getString("PM_YN"); 
	consent_given_by =vrs.getString("consent_given_by")==null?"":vrs.getString("consent_given_by");           
	relationship_with_deceased= vrs.getString("relationship_with_deceased")==null?"":vrs.getString("relationship_with_deceased"); 
	consent_form_code= vrs.getString("consent_form_code")==null?"":vrs.getString("consent_form_code"); 
		  
	consent_form_received_by = vrs.getString("consent_form_received_by")==null?"":vrs.getString("consent_form_received_by");   
	consent_form_received_date=vrs.getString("consent_form_received_date")==null?"":vrs.getString("consent_form_received_date"); 

	consent_form_code1=vrs.getString("CONSENT_FORM_CODE2")==null?"":vrs.getString("CONSENT_FORM_CODE2");
	conscentgivenby1=vrs.getString("CONSENT_GIVEN_BY2")==null?"":vrs.getString("CONSENT_GIVEN_BY2");
	deceasedrelationship1=vrs.getString("RELATIONSHIP_WITH_DECEASED2")==null?"":vrs.getString("RELATIONSHIP_WITH_DECEASED2");
	consent_received_by1=vrs.getString("CONSENT_FORM_RECEIVED_BY2")==null?"":vrs.getString("CONSENT_FORM_RECEIVED_BY2");
	consent_received_date1=vrs.getString("CONSENT_FORM_RECEIVED_DATE2")==null?"":vrs.getString("CONSENT_FORM_RECEIVED_DATE2");
	donar_card_no=vrs.getString("DONOR_CARD_NO")==null?"":vrs.getString("DONOR_CARD_NO");
    donar_card_details=vrs.getString("DONOR_CARD_DETAILS")==null?"":vrs.getString("DONOR_CARD_DETAILS");
	consent_form_recd_by_name2=vrs.getString("consent_form_recd_by_name2")==null?"":vrs.getString("consent_form_recd_by_name2");
	consent_form_recd_by_name=vrs.getString("consent_form_recd_by_name")==null?"":vrs.getString("consent_form_recd_by_name");
	burial_permit_approved_date=vrs.getString("burial_permit_approved_date")==null?"":vrs.getString("burial_permit_approved_date"); //Added by Kamatchi S on 12/10/2019 for ML-MMOH-SCF-1423
			 } 
		}
		   if(vrs!=null) vrs.close();
		   if(pstmt2!=null) pstmt2.close();

	
	pstmt2  = con.prepareStatement("select ALT_ID1_TYPE,NAT_ID_PROMPT,ACCEPT_OTH_ALT_ID_YN ,ACCEPT_NATIONAL_ID_NO_YN,NAT_ID_LENGTH from MP_PARAM");
	vrs = pstmt2.executeQuery();
	 	 
   if(vrs.next())
	{
	
	nat_id_prompt           =vrs.getString("nat_id_prompt")==null?"":vrs.getString("nat_id_prompt");
	nat_id_length    =vrs.getString("NAT_ID_LENGTH")==null?"":vrs.getString("NAT_ID_LENGTH");
	accept_national_id_no_yn =vrs.getString("ACCEPT_OTH_ALT_ID_YN")==null?"":vrs.getString("ACCEPT_OTH_ALT_ID_YN");
	}
	  
	  
	  
	  
	//  if(mode.equals("modify")||mode.equals("viewdata") )
/*Modified For Bru-HIMS-CRF-0368 By Dharma on 29th Nov 2013*/
		
		//Added for Default Previous Claimant Details start 
		String default_claimant_type			= "";
		String default_claimant_type_code		= "";
		String default_relationship				= "";
		String default_name						= "";
		String default_job_title				= "";
		String default_addrl1					= "";
		String default_addrl2					= "";
		String default_addrl3					= "";
		String default_addrl4					= "";
		String default_postal_code				= "";
		String default_country_desc				= "";
		String default_country_code				= "";
		String default_zip_code					= "";
		String default_res_town_code			= "";
		String default_res_area_code			= "";
		String default_region_code				= "";
		String default_res_town_desc			= "";
		String default_res_area_desc			= "";
		String default_region_desc				= "";
		String default_telephone_off			= "";
		String default_telephone_res			= "";
		String default_email_id					= "";
		String default_mob_tel_no				= "";
		String default_nat_id_no				= "";
		String default_organization_name		= "";
		String default_patient_employee_id		= "";

		//Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743
		String default_Passport_No				= "";
		String default_Other_Identification		= "";

		String default_RELEASE_TO_FACILITY		= "";
		String default_reason_deceased_desc		= "";
		
		
		
		if(external_rec_exists.equals("Y") && external.equals("Y")){
			  pstmt2  = con.prepareStatement("select FACILITY_ID, REGISTRATION_NO, CLAIMANT_TYPE,CLAIMANT_TYPE_CODE, RELATIONSHIP, NAME, JOB_TITLE, ADD_LINE1, ADD_LINE2, ADD_LINE3, ADD_LINE4, ZIP_CODE, COUNTRY_CODE, RES_TOWN_CODE, RES_AREA_CODE, REGION_CODE, TELEPHONE_OFF, TELEPHONE_RES, EMAIL_ID, MOB_TEL_NO, NAT_ID_NO,ORGANIZATION_NAME,PATIENT_EMPLOYEE_ID,PASSPORT_NO,OTHER_IDENTIFICATION, REGION_DESC,RES_AREA_DESC,RES_TOWN_DESC,RELEASE_TO_FACILITY,REASON from mo_claimant_vw where  REGISTRATION_NO = ?");
			  pstmt2.setString(1,latest_claiment_regn_no);
			  vrs = pstmt2.executeQuery();
			  if(vrs.next()) {
				 
				  default_claimant_type				= vrs.getString("CLAIMANT_TYPE")==null?"":vrs.getString("CLAIMANT_TYPE"); 
				  default_claimant_type_code		= vrs.getString("claimant_type_code")==null?"":vrs.getString("claimant_type_code");
				  default_relationship				= vrs.getString("relationship")==null?"":vrs.getString("relationship");
				  default_name						= vrs.getString("name")==null?"":vrs.getString("name");
				  default_job_title					= vrs.getString("job_title")==null?"":vrs.getString("job_title"); 
				  default_addrl1					= vrs.getString("add_line1")==null?"":vrs.getString("add_line1");
				  default_addrl2					= vrs.getString("add_line2")==null?"":vrs.getString("add_line2"); 
				  default_addrl3					= vrs.getString("add_line3")==null?"":vrs.getString("add_line3");
				  default_addrl4					= vrs.getString("add_line4")==null?"":vrs.getString("add_line4");
				  default_postal_code				= vrs.getString("zip_code")==null?"":vrs.getString("zip_code");
				  default_country_code				= vrs.getString("country_code")==null?"":vrs.getString("country_code");
				  default_zip_code					= postal_code;
				  default_res_town_code				= vrs.getString("res_town_code")==null?"":vrs.getString("res_town_code"); 
				  default_res_area_code				= vrs.getString("res_area_code")==null?"":vrs.getString("res_area_code");
				  default_region_code				= vrs.getString("region_code")==null?"":vrs.getString("region_code");
				  default_res_town_desc				= vrs.getString("res_town_desc")==null?"":vrs.getString("res_town_desc"); 
				  default_res_area_desc				= vrs.getString("res_area_desc")==null?"":vrs.getString("res_area_desc");
				  default_region_desc				= vrs.getString("region_desc")==null?"":vrs.getString("region_desc");
				  default_telephone_off				= vrs.getString("telephone_off")==null?"":vrs.getString("telephone_off"); 
				  default_telephone_res				= vrs.getString("telephone_res")==null?"":vrs.getString("telephone_res");
				  default_email_id					= vrs.getString("email_id")==null?"":vrs.getString("email_id");
				  default_mob_tel_no				= vrs.getString("mob_tel_no")==null?"":vrs.getString("mob_tel_no"); 
				  default_nat_id_no					= vrs.getString("nat_id_no")==null?"":vrs.getString("nat_id_no");
				  default_organization_name			= vrs.getString("organization_name")==null?"":vrs.getString("organization_name");
				  default_patient_employee_id		= vrs.getString("patient_employee_id")==null?"":vrs.getString("patient_employee_id"); 

				  //Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743
				  default_Passport_No				= vrs.getString("Passport_No")==null?"":vrs.getString("Passport_No");
				  default_Other_Identification		= vrs.getString("Other_Identification")==null?"":vrs.getString("Other_Identification");

				  default_RELEASE_TO_FACILITY		= vrs.getString("RELEASE_TO_FACILITY")==null?"":vrs.getString("RELEASE_TO_FACILITY");
				  default_reason_deceased_desc		= vrs.getString("REASON")==null?"":vrs.getString("REASON");
				}
			   if(vrs!=null) vrs.close();
			   if(pstmt2!=null) pstmt2.close();
			   if(!default_country_code.equals("")){
				  	String sqlcountry = "select short_name from mp_country_lang_vw where language_id = '"+localeName+"' and country_code = '"+default_country_code+"'";
	
					pstmt2  = con.prepareStatement(sqlcountry);
			        vrs = pstmt2.executeQuery();
			    	while( vrs.next()){
			    		default_country_desc=checkForNull(vrs.getString("short_name"));
					}
					if(vrs!=null) vrs.close();
					if(pstmt2!=null) pstmt2.close();
			   }
			   
			   
		}
		//Added for Default Previous Claimant Details End	
		if(mode.equals("modify")||mode.equals("viewdata") || (external_rec_exists.equals("N") && external.equals("Y"))){	
		  /*Below query modified for this CRF Bru-HIMS-CRF-366*/    

		  pstmt2  = con.prepareStatement("select FACILITY_ID, REGISTRATION_NO, CLAIMANT_TYPE,CLAIMANT_TYPE_CODE, RELATIONSHIP, NAME, JOB_TITLE, ADD_LINE1, ADD_LINE2, ADD_LINE3, ADD_LINE4, ZIP_CODE, COUNTRY_CODE, RES_TOWN_CODE, RES_AREA_CODE, REGION_CODE, TELEPHONE_OFF, TELEPHONE_RES, EMAIL_ID, MOB_TEL_NO, NAT_ID_NO,ORGANIZATION_NAME,PATIENT_EMPLOYEE_ID,PASSPORT_NO,OTHER_IDENTIFICATION,REGION_DESC,RES_AREA_DESC,RES_TOWN_DESC,RELEASE_TO_FACILITY,REASON from mo_claimant_vw where  REGISTRATION_NO = ?");
		  
		  
		  pstmt2.setString(1,regn_no);
		  vrs = pstmt2.executeQuery();
		  while(vrs.next())
		 {
		
		claimant_type=vrs.getString("CLAIMANT_TYPE")==null?"":vrs.getString("CLAIMANT_TYPE"); 
	    claimant_type_code=vrs.getString("claimant_type_code")==null?"":vrs.getString("claimant_type_code");
		relationship=vrs.getString("relationship")==null?"":vrs.getString("relationship");
		name=vrs.getString("name")==null?"":vrs.getString("name");
		job_title=vrs.getString("job_title")==null?"":vrs.getString("job_title"); 
		addrl1=vrs.getString("add_line1")==null?"":vrs.getString("add_line1");
		addrl2=vrs.getString("add_line2")==null?"":vrs.getString("add_line2"); 
		addrl3=vrs.getString("add_line3")==null?"":vrs.getString("add_line3");
		addrl4=vrs.getString("add_line4")==null?"":vrs.getString("add_line4");
		
		
		postal_code=vrs.getString("zip_code")==null?"":vrs.getString("zip_code");
		
		country_code=vrs.getString("country_code")==null?"":vrs.getString("country_code");
		zip_code=postal_code;
		res_town_code=vrs.getString("res_town_code")==null?"":vrs.getString("res_town_code"); 
		res_area_code=vrs.getString("res_area_code")==null?"":vrs.getString("res_area_code");
		region_code=vrs.getString("region_code")==null?"":vrs.getString("region_code");
		
		res_town_desc=vrs.getString("res_town_desc")==null?"":vrs.getString("res_town_desc"); 
		res_area_desc=vrs.getString("res_area_desc")==null?"":vrs.getString("res_area_desc");
		region_desc=vrs.getString("region_desc")==null?"":vrs.getString("region_desc");
		
		telephone_off=vrs.getString("telephone_off")==null?"":vrs.getString("telephone_off"); 
		telephone_res=vrs.getString("telephone_res")==null?"":vrs.getString("telephone_res");
		email_id=vrs.getString("email_id")==null?"":vrs.getString("email_id");
		mob_tel_no=vrs.getString("mob_tel_no")==null?"":vrs.getString("mob_tel_no"); 
		nat_id_no=vrs.getString("nat_id_no")==null?"":vrs.getString("nat_id_no");
	   
		organization_name=vrs.getString("organization_name")==null?"":vrs.getString("organization_name");
	   patient_employee_id=vrs.getString("patient_employee_id")==null?"":vrs.getString("patient_employee_id"); 

	   //Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743
	   Passport_No=vrs.getString("Passport_No")==null?"":vrs.getString("Passport_No");
	   Other_Identification=vrs.getString("Other_Identification")==null?"":vrs.getString("Other_Identification");

		RELEASE_TO_FACILITY = vrs.getString("RELEASE_TO_FACILITY")==null?"":vrs.getString("RELEASE_TO_FACILITY");
		
		reason_deceased_desc= vrs.getString("REASON")==null?"":vrs.getString("REASON"); //this line Added for this CRF -Bru-HIMS-CRF-366


		 }
		  
	  if(vrs!=null) vrs.close();
     if(pstmt2!=null) pstmt2.close();

	 if(claimant_type.equals("E"))
	  {
	  pstmt2  = con.prepareStatement("select b.short_desc ocpn_class_desc from mp_occupation a, MP_OCCUPATION_CLASS_LANG_VW b, mp_pat_rel_contacts c where a.OCPN_CODE=c.OCPN_CODE and  a.OCPN_CLASS_CODE=b.OCPN_CLASS_CODE and c.patient_id=?");
	  pstmt2.setString(1,patient_id);
	  vrs = pstmt2.executeQuery();
	  while(vrs.next())
	  {
	  
	  ocpn_class_desc=vrs.getString("ocpn_class_desc");
	  }
	  }
	  
	  }
	  
	  


	  if(body_claiming_date_time.equals(""))
	  {
		body_claiming_date_time=sys_date;
	  }

		if(external.equals("Y") || mode.equals("viewdata")){//modified against [IN:068178]
			regn_allowed_in_mo_yn="Y";

			deceased_date_cnv = DateUtils.convertDate(dec_dt_time,"DMYHM","en",localeName); 	
			
		}
				
	
	 	 
	  if(regn_allowed_in_mo_yn.equals("Y") )
	  {
        if(encounter_id!="") {

		if(external.equals("Y")){%>
			<script>
			parent.frames[1].location.href = "../../eCommon/jsp/pline.jsp?EncounterId=<%=dec_enc_id%>&Facility_Id=<%=dec_fac_id%>" ;  
			</script>

		<%}else{%>

			<script>
			parent.frames[1].location.href = "../../eCommon/jsp/pline.jsp?EncounterId=<%=encounter_id%>&Facility_Id=<%=facilityId%>" ;  
			</script>
		<%} %>

	    
	  <%}else {
		  if(external.equals("Y") && ! dec_enc_id.equals("")){
			%>
			<script>
			parent.frames[1].location.href = "../../eCommon/jsp/pline.jsp?EncounterId=<%=dec_enc_id%>&Facility_Id=<%=dec_fac_id%>" ;  
			</script>

		<%}else{%>
			<script>       
				parent.frames[1].location.href = "../../eCommon/jsp/pline.jsp?Patient_ID=<%=patient_id%>" ;  
			</script>
	   
	   <%}
		}
		
  
		int maxrecord = 0;

		//Added by Kamatchi S on 12/10/2019 for ML-MMOH-SCF-1423
		if(!burial_permit_approved_date.equals("")){
			burial_perm_date =burial_permit_approved_date;
		}


		if((postmortem_status.equals("N") || postmortem_status.equals("")|| postmortem_startend_status.equals("E"))&& (burial_perm_no.equals("")))
		  {
			pstmt2=con.prepareStatement("select BURIAL_PERMIT_NO,BURIAL_PERMIT_APPROVED_BY, BURIAL_PERMIT_APPROVED_BY_NAME, BURIAL_PERMIT_APPROVED_DATE from MO_BURIAL_PERMIT_VW where patient_id='"+patient_id+"'",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			//Modified by Ashwini on 01-Jul-2019 for ML-MMOH-CRF-0990
			vrs = pstmt2.executeQuery();
			if(vrs != null)
			  {
				 vrs.last();
				 maxrecord=vrs.getRow();
			
				 if(maxrecord == 0)
				  {
					 readText="";
					 disablebut="";
				  }
				 else
				 {
					readText="readOnly";
					disablebut="disabled";
 				    vrs.beforeFirst();
				while(vrs.next())
				 {
				burial_perm_no=vrs.getString("BURIAL_PERMIT_NO");
						
				burial_perm_by=vrs.getString("BURIAL_PERMIT_APPROVED_BY")==null?burial_perm_by:vrs.getString("BURIAL_PERMIT_APPROVED_BY");
				burial_permit_appr_by_name=vrs.getString("BURIAL_PERMIT_APPROVED_BY_NAME")==null?burial_permit_appr_by_name:vrs.getString("BURIAL_PERMIT_APPROVED_BY_NAME");
				burial_perm_date=vrs.getString("BURIAL_PERMIT_APPROVED_DATE");
					  }

				 }
			  }
			  if(vrs != null) vrs.close();
			  if(pstmt2 != null) pstmt2.close();
		   }


	  		   
     if(postmortem_status.equals("Y"))checkpm="Checked" ;else checkpm="";
	if(mlc_yn.equals("Y"))checkmlc="Checked"; else checkmlc="";
/*
	//Added by Ashwin K for ML-MMOH-CRF-1891
String finalize_yn = "";

String finalize_query = "SELECT    c.finalize_yn as finalize_yn FROM pr_encounter a,mp_patient b,    mr_death_register_hdr c where b.patient_id  = a.patient_id  and a.encounter_id = c.encounter_id  and a.facility_id = '"+facilityId+"' and a.facility_id =c.facility_id AND  a.patient_id like '"+patient_id+"'";

 System.err.println("finalize_query "+finalize_query);

	pstmt2=con.prepareStatement(finalize_query);
	vrs = pstmt2.executeQuery();
	if(vrs != null)
	{
		while(vrs.next())
		{
		finalize_yn=vrs.getString("finalize_yn");
		}
	}

	if(vrs != null) vrs.close();
	if(pstmt2 != null) pstmt2.close();

	 if(finalize_yn.equals(""))
		  {
		 finalize_yn="N" ;
		  }

		  System.err.println("finalize_yn "+finalize_yn);


//Ended by Ashwin K for ML-MMOH-CRF-1891

*/
/*Added by santhosh for ML-MMOH-CRF-1947 Start*/
	Boolean maxSizeBurialPermitAppl = false;
	 maxSizeBurialPermitAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MO","MAX_SIZE_BURIAL_PERMIT");
	 String max_size_burial_permit_no = "";
		sstat = con.createStatement();
		vrs = sstat.executeQuery("select NVL(MAX_SIZE_BURIAL_PERMIT_NO,0) MAX_SIZE_BURIAL_PERMIT_NO from mo_parameter a where  a.facility_id='"+facilityId+"' ");
		while(vrs.next())
		{
		   max_size_burial_permit_no = (maxSizeBurialPermitAppl)?vrs.getString("MAX_SIZE_BURIAL_PERMIT_NO"):"16";
		}
		if(vrs!=null) vrs.close();
		if(sstat!=null) sstat.close();
		
	/*END*/



	 %>
	 <body OnMouseDown='CodeArrest()' onLoad="assignmlc();enableService();enableservices('<%=area_code%>','<%=postmortem_status%>','<%=postmortem_type%>','<%=postmortem_startend_status%>');getClaimant1('<%=claimant_type%>','<%=claimant_type_code%>');clearBed();ClearClaimantValues();enableManGif('<%=burial_permit_reqd_yn%>');EnableFields();" onKeyDown="lockKey()" onSelect='codeArrestThruSelect();' >	 
	 <form name="MO_regn_form" id="MO_regn_form"  action="../../servlet/eMO.MOMortuaryRegnServlet"  method="post" target="messageFrame" >
	<!--Added For [IN:046059] By Lenin on 02-Jan-2013 Start-->
	 <div id = 'REGDETAILS'>
	 <a name="tab1" id="tab1"></a>	
    <!--Added For [IN:046059] By Lenin on 02-Jan-2013 End-->
			<table cellspacing='0' cellpadding='0' width='100%' border='0' align='center'> 
				<tr>
					<td class='white' align='right'> 
						<INPUT TYPE="button" value='<fmt:message key="Common.Demographics.label" bundle="${common_labels}"/><fmt:message key="Common.details.label" bundle="${common_labels}"/>'  class='button' onClick="viewPatientDetails('<%=patient_id%>')"><INPUT TYPE="button" 
						value='<fmt:message key="Common.PreviousEncounters.label" bundle="${common_labels}"/>' onClick="showPrevEncounter('<%=patient_id%>');"class=button>
					</td>
				</tr>	
				<tr><td class='white'>&nbsp;</td></tr>
			</table>

			<ul id="tablist" class="tablist">
					<li class="tablistitem" title="RegnDtls">
						<a onclick="javascript:tab_enable('regn_dtls_tab')" id="regn_dtls_tab" class="tabClicked">
						<span class="tabSpanclicked" id="regn_dtls_tabspan"><fmt:message key="eMO.RegistrationDtls.label" bundle="${mo_labels}"/></span>
						</a>
					</li>
					<li class="tablistitem" title="OrganDonation">
						<a  onclick="javascript:tab_enable('organ_dtn_tab')" id="organ_dtn_tab" class="tabA">
						<span class="tabAspan" id="organ_dtn_tabspan"><fmt:message key="eMO.OrganDonation.label" bundle="${mo_labels}"/></span><!--bundle change for PAS-MO-PMG2020-TECH-CRF-0010/02-Label Name-->
						</a>
					</li>	
					<!--Added by Ashwini on 17-Oct-2017 for ML-MMOH-CRF-0696-->
					<%if(rearrangeTabBurlPermtClaimnt){%>
					<li class="tablistitem" title="BurialPermit" id='dis'>
						<a onclick="javascript:tab_enable('burial_prmt_tab')" id="burial_prmt_tab" class="tabA">
						<span class="tabAspan" id="burial_prmt_tabspan"><fmt:message key="eMO.BurialPermit.label" bundle="${mo_labels}"/></span><!--bundle change for PAS-MO-PMG2020-TECH-CRF-0010/02-Label Name-->
						</a>
					</li>
					<li class="tablistitem" title="Claimant" id='claimantDis'>
						<a  onclick="javascript:tab_enable('claimant_tab')" id="claimant_tab" class="tabA">
						<span class="tabAspan" id="claimant_tabspan"><fmt:message key="eMO.Claimant.label" bundle="${mo_labels}"/></span><!--bundle change for PAS-MO-PMG2020-TECH-CRF-0010/02-Label Name-->
						</a>
					</li>	
					<%}else{%>
					<li class="tablistitem" title="Claimant">
						<a  onclick="javascript:tab_enable('claimant_tab')" id="claimant_tab" class="tabA">
						<span class="tabAspan" id="claimant_tabspan"><fmt:message key="eMO.Claimant.label" bundle="${mo_labels}"/></span><!--bundle change for PAS-MO-PMG2020-TECH-CRF-0010/02-Label Name-->
						</a>
					</li>	
					<li class="tablistitem" title="BurialPermit" id='dis'>
						<a onclick="javascript:tab_enable('burial_prmt_tab')" id="burial_prmt_tab" class="tabA">
						<span class="tabAspan" id="burial_prmt_tabspan"><fmt:message key="eMO.BurialPermit.label" bundle="${mo_labels}"/></span><!--bundle change for PAS-MO-PMG2020-TECH-CRF-0010/02-Label Name-->
						</a>
					</li>	
					<%}%>
			</ul>	
	

	  <table border="0" cellpadding="0" cellspacing="0" align='center' width='100%'> 
	  <tr>
		<td>
			<table border="0" cellpadding="0" cellspacing="0" align='center' width='100%'> 
				<tr>
					<td class='COLUMNHEADER'><fmt:message key="Common.referraldetails.label" bundle="${common_labels}"/></td>
				</tr> 
			</table>
		</td>
	  </tr>	
	  <tr>
		<td>
			<table border="0" cellpadding="3" cellspacing="0" align='center' width='100%'> 
				<tr>
					  <td class=label width='25%'><fmt:message key="Common.referraltype.label" bundle="${common_labels}"/></td>
					  <td class='querydata' width='25%'><%=referral_type_desc%></td>
					  <td class='label' width='20%'><fmt:message key="Common.referralsource.label" bundle="${common_labels}"/></td>
					  <td class='querydata' width='30%'><%=referral_desc%></td>	
				</tr>	  
				<tr>
					  <td class='label'><fmt:message key="Common.HealthcareSettingType.label" bundle="${common_labels}"/></td>
					  <td class='querydata'><%=hcare_setting_type_desc%></td>
					  <td class='label' ><fmt:message key="Common.referredby.label" bundle="${common_labels}"/></td>
					  <td class='querydata'><%=referred_by%></td>
				</tr>
			</table>
		</td>
	  </tr>		  
	 <input type=hidden name='referral_source' id='referral_source' value='<%=ref_source_code %>'>
	 <input type=hidden name='referral_by' id='referral_by' value='<%=referred_by%>'>
	 <input type=hidden name='refe_type' id='refe_type' value='<%=referral_type%>'>
	 <input type=hidden name='hcare_type' id='hcare_type' value='<%=hcare_setting_type%>'>
	
	  <tr>
		<td>
			<table border="0" cellpadding="0" cellspacing="0" align='center' width='100%'> 
				<tr>
					<td class='COLUMNHEADER'><fmt:message key="Common.deceaseddetails.label" bundle="${common_labels}"/></td>
				</tr> 
			</table>
		</td>
	  </tr>		
	  <tr>
		<td>
			<table border="0" cellpadding="3" cellspacing="0" align='center' width='100%'> 
				<tr>
					 <td class='label' width='25%'><fmt:message key="Common.broughtdead.label" bundle="${common_labels}"/>
					 <%if(brought_dead_yn.equals("Y")){%>
					 <td class='QUERYDATA' width='25%'><fmt:message key="Common.yes.label" bundle="${common_labels}"/></td>
					 <%}else{%>
					 <td class='QUERYDATA'><fmt:message key="Common.no.label" bundle="${common_labels}"/></td>
					 <%}%>
					 <td class='label' width='20%'><fmt:message key="Common.religion.label" bundle="${common_labels}"/></td>
					 <td class='fields' width='30%'>
					 <%if(relgn_code.equals("")){%>	 
					 <INPUT TYPE="text" name="relgn_desc" id="relgn_desc" onblur='searchReligion1(relgn_desc,relgn_code,"<%=localeName%>");' value=''><input type='button' class='button' value='?' name='relg_button' id='relg_button' onClick='searchReligion(relgn_desc,relgn_code,"<%=localeName%>");' ><img src='../../eCommon/images/mandatory.gif'></img>
					 <input type=hidden name='relflagyn' id='relflagyn' value='Y'>
					 <%}else%>
					 <b><%=relgn_desc%></b>
					 </td>
					 <input type=hidden name='relgn_code' id='relgn_code' value='<%=relgn_code%>'>	
				</tr>			
					
				<tr>
					 <td class='label'><fmt:message key="eMO.UnclaimedBody.label" bundle="${mo_labels}"/></td> 
					 <td class='fields'>
					 <%if(unclaimed_body_yn.equals("Y")){%>
					 <INPUT TYPE="checkbox" name="unclaimedbodyyn" id="unclaimedbodyyn" onClick='ClearClaimantValues()' value="Y" checked>
					 <%}else{%>
					 <INPUT TYPE="checkbox" name="unclaimedbodyyn" id="unclaimedbodyyn"   onClick='ClearClaimantValues()'>
					 <%}%>
					 </td> 
					 <%if(mlcAndInfectiousDeceBodyApplicable){%>
					 <td class='label'><fmt:message key="Common.InfectiousDeceasedBody.label" bundle="${common_labels}"/></td> <!--below legend name change against ML-MMOH-CRF-0737 by Mano -->
					 <%}else{%>
					 <td class='label'><fmt:message key="Common.highriskbody.label" bundle="${common_labels}"/></td>
					 <%}%>
					 <td class='label'>
					 <%if(high_risk_body_yn.equals("Y")){%> 
					 <INPUT TYPE="checkbox" name="highriskbodyyn" id="highriskbodyyn" value="Y" checked>
					 <%}else{%>
					 <INPUT TYPE="checkbox" name="highriskbodyyn" id="highriskbodyyn">
					 <%}%>
					 </td>
				</tr>  
				<tr> <!--Below line(s) added by Venkatesh.S on 12-Nov-2013 against Bru-HIMS-CRF-365 [IN:039572]-->
					<td class='label'><fmt:message key="eMO.MannerofDeathuponReceipt.label" bundle="${mo_labels}"/></td>
					<td class='fields'><select name='manner_of_death' id='manner_of_death'  >
					<option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
					<% pstmt2 = con.prepareStatement("select death_manner_code,short_desc from mo_manner_of_death_lang_vw where eff_status='E' and language_id='"+localeName+"' order by 2");
					   vrs = pstmt2.executeQuery();
					  while(vrs.next())
						  {
							if(death_manner_code.equals(vrs.getString("death_manner_code"))){%>
							<option value='<%=vrs.getString("death_manner_code")%>' selected><%=vrs.getString("short_desc")%></option>
							<%}else{%>
							<option value='<%=vrs.getString("death_manner_code")%>'><%=vrs.getString("short_desc")%></option>
							<%}%>
						<%}%>
						</select><img src='../../eCommon/images/mandatory.gif'></img>
				        </td><A HREF=""></A>
				       <td class='label'><fmt:message key="Common.PlaceofDeath.label" bundle="${common_labels}"/></td>
					   <td class='fields'><input type='text' name='place_of_death' id='place_of_death' size=36 maxlength=100  value='<%=place_of_death%>'></td> 
				</tr>
				 <!--Below line(s) added by Venkatesh.S on 12-Nov-2013 against Bru-HIMS-CRF-365 [IN:039572]-->
				  <%if(mode.equals("modify") || mode.equals("viewdata")){%><!--Modified by Thamizh selvi on 19th Sep 2017 against [IN:065280]-->
				<td class='label'><fmt:message key="eMO.MannerofDeathafterPostmortem.label" bundle="${mo_labels}"/></td>
				<td class='fields'><select name='manner_of_death_after_potmrtm' id='manner_of_death_after_potmrtm' <%=death_after_potmrtm_yn%> >
				<option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
				 <%
				          vrs = pstmt2.executeQuery();
						   while(vrs.next()){ 
						   if(death_after_potmrtm.equals(vrs.getString("death_manner_code"))){%>
						   <option value='<%=vrs.getString("death_manner_code")%>' selected><%=vrs.getString("short_desc")%></option>
						   <%}else{%>
						    <option value='<%=vrs.getString("death_manner_code")%>'><%=vrs.getString("short_desc")%></option>
                           <%} }
						   if(vrs!=null) vrs.close();
						   if(pstmt2!=null) pstmt2.close();
						   %>
				</select> 
				<td class='label' width='20%'><fmt:message key="eMO.BodyFoundAt.label" bundle="${mo_labels}"/></td> 
					 <td class='fields'><INPUT TYPE="text" name="bodyfounddat" id="bodyfounddat" maxlength=100 value='<%=body_found_at%>'></td> 
				
				 <!--end Bru-HIMS-CRF-365 [IN:039572]-->
				<%}%>
			</table>
		</td>
	</tr>		
		
	<tr>
		<td>
			<table border="0" cellpadding="3" cellspacing="0" align='center' width='100%'> 
				<tr>
					 <td class='label' width='25%'><fmt:message key="Common.deceaseddatetime.label" bundle="${common_labels}"/></td>
						<!--Added by Thamizh selvi on 25th July 2017 for ML-MMOH-CRF-0689 Start-->
						<!--modified against [IN:068178] -->
						<% if(calledFrom.equals("MO_BID_REGN") || extBidYnFrmVw.equals("Y")){ %>
							<td class='fields' width='25%'><INPUT TYPE="text" maxlength=16 size=16 name="deceased_date" id="deceased_date" value='<%=deceased_date_cnv%>' <%if(mode.equals("viewdata")){%> disabled <%}%>onblur="if(validDateObj(this,'DMYHM',localeName))chkWithSysDt(this); disDeathDate1(this); "><input type="image" src="../../eCommon/images/CommonCalendar.gif" id='decdate' <%if(mode.equals("viewdata")){%> disabled <%}%> onClick="document.forms[0].deceased_date.select();return showCalendar('deceased_date', null, 'hh:mm' );"><img src='../../eCommon/images/mandatory.gif' ></img>
						<% }else{ %><!--End-->
							 <%if(!brought_dead_yn.equals("Y")){%>
							 <td class='QUERYDATA' width='25%'><%=deceased_date_cnv%>
							 <input type='hidden' name='deceased_date' id='deceased_date' value="<%=deceased_date_cnv%>">
							 <%}else{%>
							 <td class='fields' width='25%'><INPUT TYPE="text" maxlength=16 size=16 name="deceased_date" id="deceased_date" value='<%=deceased_date_cnv%>' <%if(mode.equals("viewdata")){%> disabled <%}%> onblur="if(validDateObj(this,'DMYHM',localeName))chkWithSysDt(this); disDeathDate1(this);"><input type="image" src="../../eCommon/images/CommonCalendar.gif" id='decdate' <%if(mode.equals("viewdata")){%> disabled <%}%>onClick="document.forms[0].deceased_date.select();return showCalendar('deceased_date', null, 'hh:mm' );"><img src='../../eCommon/images/mandatory.gif' ></img>			
							 <%}%>
						<% } %>
					 <!--Below condition added by Venkatesh.S on 12-Nov-2013 against Bru-HIMS-CRF-365 [IN:039572]-->
					  <%if(mode.equals("insert")){%>
					<td class='label' width='20%'><fmt:message key="eMO.BodyFoundAt.label" bundle="${mo_labels}"/></td> 
					<td class='fields'><INPUT TYPE="text" name="bodyfounddat" id="bodyfounddat" maxlength=100 value='<%=body_found_at%>'></td>
					 <%}%>
					
					 <td class='button'>
					 <!-- Added siteCheck below by Ashwin K for ML-MMOH-CRF-1891-->
					<%if(! external.equals("Y")){%>
						<input type="button" name="death_cause" id="death_cause" style="width:95" class='BUTTON' value='<fmt:message key="Common.CauseofDeath.label" bundle="${common_labels}"/>'   onclick="deathCause('<%=encounter_id%>','<%=patient_id%>','<%=deathcseregby%>','<%=mode%>','<%=date_of_birth%>',
						'<%=sex%>','<%=splty_code%>','<%=patient_class%>','<%=pract_type%>','<%=locn_code%>','<%=locn_type%>','<%=siteCheck%>','<%=facilityId%>');">
					<%}%>
					 </td>
				</tr> 
			</table>
		</td>
  </tr>	
  
<tr>
		<td>
			<table border="0" cellpadding="0" cellspacing="0" align='center' width='100%'> 
				<tr>
					<!--Modified by Ashwini on 25-Jul-2019 for ML-MMOH-CRF-0991-->
					<td class='COLUMNHEADER'><fmt:message key="eMO.Body.label" bundle="${mo_labels}"/>&nbsp;<%if(isReceivedDateTimeAppl){%><fmt:message key="Common.received.label" bundle="${common_labels}"/><%}else{%><fmt:message key="eMO.Receipt.label" bundle="${mo_labels}"/><%}%>&nbsp;<fmt:message key="Common.details.label" bundle="${common_labels}"/></td>
				</tr> 
			</table>
		</td>
	</tr>	
	<tr>
		<td>
			<table border="0" cellpadding="3" cellspacing="0" align='center' width='100%'> 
				<tr>
						<td class='label' width='25%'><fmt:message key="eMO.BodyRelDateTimefromSource.label" bundle="${mo_labels}"/></td>
						<td class='QUERYDATA' width='25%'><%=body_release_date_time_cnv%></td>
						<!--Below label Modified by Shanmukh on 26th-JUNE-2018 for ML-ML-MMOH-CRF-1036-->
						<%if(isReceivedDateTimeAppl){%>
						<td class='LABEL' width='25%'><fmt:message key="eMO.Body.label" bundle="${mo_labels}"/>&nbsp;<fmt:message key="Common.received.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Date/Time.label" bundle="${common_labels}"/>&nbsp;</td><%}else{%>
						<td class='label' width='20%'><fmt:message key="eMO.BodyReceipt.label" bundle="${mo_labels}"/></td><%}%>
						<td class='fields' width='30%'>
					    <%	// if(mode.equals("modify")||mode.equals("viewdata"))
						/*Added For Bru-HIMS-CRF-0368 By Dharma on 29th Nov 2013*/
						if(mode.equals("modify")||mode.equals("viewdata") || (external_rec_exists.equals("Y") && external.equals("Y")))	
							  {%>
						 <input type='text' size='16' maxlength='16' id='body_received_date_time' <%=disabledyn%> name='body_received_date_time' onfocus='' value='<%=body_received_date_cnv%>' onblur="if(validDateObj(this,'DMYHM',localeName)){chkWithSysDt(this);chkWithDates(this,'BRD');}" ><img src="../../eCommon/images/CommonCalendar.gif"  disabled id='bodychk' onClick="document.forms[0].body_received_date_time.select();return showCalendar('body_received_date_time', null, 'hh:mm' );"style="cursor='hand'"><img src='../../eCommon/images/mandatory.gif' ></img>		 
						 <%}else{%>
						 <input type='text' size='16' maxlength='16' id='body_received_date_time' <%=disabledyn%> name='body_received_date_time' onfocus='' value='<%=sys_date_cnv%>' onblur="if(validDateObj(this,'DMYHM',localeName)){chkWithSysDt(this);chkWithDates(this,'BRD');}" ><input type="image" src="../../eCommon/images/CommonCalendar.gif" id='bodychk' onClick="document.forms[0].body_received_date_time.select();return showCalendar('body_received_date_time', null, 'hh:mm' );"><img src='../../eCommon/images/mandatory.gif'></img>
						 <%}%>	
						 </td>
				</tr> 
				<tr>
						<td class='label'><fmt:message key="eMO.BodyCondition.label" bundle="${mo_labels}"/></td>
						<td class='fields'><select name='body_condition_code' id='body_condition_code' >
						<option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
						<%
						 pstmt2 = con.prepareStatement("select body_cond_code,short_desc from mo_body_condition_lang_vw where eff_status='E' and language_id='"+localeName+"'order by 2");
						vrs = pstmt2.executeQuery();
						while(vrs.next())
						{if(body_cond_code.equals(vrs.getString("body_cond_code"))){%>
						%>
						<option value='<%=vrs.getString("body_cond_code")%>' selected ><%=vrs.getString("short_desc")%></option>
						<%}else{%>
						<option value='<%=vrs.getString("body_cond_code")%>' ><%=vrs.getString("short_desc")%></option>
						
						<%}
						} if(vrs!=null) vrs.close();
						  if(pstmt2!=null) pstmt2.close();
						%>
					  </select><img src='../../eCommon/images/mandatory.gif'></img></td>
					  <td class='label'><fmt:message key="eMO.IdentificationMarks.label" bundle="${mo_labels}"/></td>
					  <td class='fields'><textarea name='identification_marks' id='identification_marks' cols='20' rows='2' onKeyPress='' onBlur='' ><%=identification_marks%></textarea>
					  </td>						
				</tr>
			</table>
		</td>
	</tr>		
	<tr>
		<td>
			<table border="0" cellpadding="0" cellspacing="0" align='center' width='100%'> 
				<tr>
				<!-- below line(s) modified by VenkateshS against ML-MMOH-CRF-0354 [IN057191] -->
				  <%if(siteSpecific){%>
				  <td class='COLUMNHEADER'><fmt:message key="Common.MedicalLegalCase.label" bundle="${common_labels}"/> <fmt:message key="Common.details.label" bundle="${common_labels}"/></td>
				  <%}else{%>
					<td class='COLUMNHEADER'><fmt:message key="Common.mlcdetails.label" bundle="${common_labels}"/></td>
					<%}%>
					<!--end ML-MMOH-CRF-0354 [IN057191 -->
				</tr> 
			</table> 
		</td>
	</tr>	
	<tr>
		<td>
			<table border="0" cellpadding="3" cellspacing="0" align='center' width='100%'> 
				<tr>
				<!--below legend name change against ML-MMOH-CRF-0737 by Mano-->
				<!-- below line(s) modified by VenkateshS against ML-MMOH-CRF-0354 [IN057191] -->
				        <%if(siteSpecific){%>
					   <td class='label' width='25%'><fmt:message key="Common.MedicalLegalCase.label" bundle="${common_labels}"/>
					   <%}else{%>
					   <%if(mlcAndInfectiousDeceBodyApplicable){%> 
					   <td class='label' width='25%'><fmt:message key="Common.MedicoLegalCase.label" bundle="${common_labels}"/>
					   <%}else{%>
					   <td class='label' width='25%'><fmt:message key="Common.mlc.label" bundle="${common_labels}"/>
					   <%}}%>
					   <!--end ML-MMOH-CRF-0354 [IN057191 -->
					   <td class='fields' width='25%'> 
					   <% 				
						 
						 if(area_type.equals("P")||area_type.equals("R")||postmortem_startend_status.equals("E")||postmortem_startend_status.equals("R")){%>
						 <input type='checkbox'   name="mlc_yn" id="mlc_yn" <%=disabledyn%> value='<%=mlc_yn%>' onClick='assignmlc();enableservices();clearBed1();checkserv1()' <%=checkmlc%>>
						 <%}else{%>
						 <input type='checkbox' <%=checkmlc%>  name="mlc_yn" id="mlc_yn" value="<%=mlc_yn%>"   onClick='enableservices();clearPoliceDtls();'><!--Modified by Thamizh selvi on 4th Aug 2017 for ML-MMOH-CRF-0689-->
						 <%}%>
							</td>
						 <td class='label' width='20%'><fmt:message key="eMO.BroughtByPolice.label" bundle="${mo_labels}"/></td>
						 <td class='fields' id="treat_area">
						  <%if(brought_by_police_yn.equals("Y")){%>	 
						  <input type='checkbox'  value='Y'  name="brought_by_police_yn" id="brought_by_police_yn" checked onclick='policevalue()' >
						  <%}else{%>
						  <input type='checkbox'  value='N'  name="brought_by_police_yn" id="brought_by_police_yn" onclick='policevalue()' >
						   <%}%>	
						   </td>
						   <td class='button' align='right'><input type="button" name="Police_Details" id="Police_Details" style="width:90" value='<fmt:message key="eMO.PoliceDetails.label" bundle="${mo_labels}"/>' class='BUTTON' onclick='policedetails()'><input type='hidden' name='police_details' id='police_details' value="<%=police_details%>">	
						 </td> 
				</tr>
			</table>
		</td>
	</tr>	  
 	<tr>
		<td>
			<table border="0" cellpadding="0" cellspacing="0" align='center' width='100%'> 
				<tr>
					<td class='COLUMNHEADER'><fmt:message key="eMO.PostmortemDtls.label" bundle="${mo_labels}"/></td>
				</tr> 
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<table border="0" cellpadding="3" cellspacing="0" align='center' width='100%'> 
				<tr>
			
						<td class='label' width='25%'><fmt:message key="Common.PMRequired.label" bundle="${common_labels}"/></td>
						<td class='fields' id="treat_area" width='25%'>						
						<% //Below line modified for this CRF  Bru-HIMS-CRF-407 [IN:045167]	
                        						
						 if(area_type.equals("R")||area_type.equals("P")|| regCount>0){%>
						<input type='checkbox'  <%=checkpm%> name="postmortem_reqd_yn"  <%=disabledyn%> value='<%=postmortem_status%>' onclick='clearArea();enableservices();clearBed1();clearpoliceconsent();'>
						<%}else
							{%>
						<input type='checkbox'  name="postmortem_reqd_yn" id="postmortem_reqd_yn" <%=checkpm%> value='<%=postmortem_status%>'   onclick='clearArea();enableservices();clearBed1();clearpoliceconsent();'>
						
						<%}%>
						</td>
						<td class='label' width='20%'><fmt:message key="eMO.PostmortemType.label" bundle="${mo_labels}"/></td>
						<td class='fields'><SELECT name="postmortem_type" id="postmortem_type" disabled onChange='enableConsent()'>
						<option value="">------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
						  <% if(postmortem_type.equals("C")){
							%>
						<option value='C' selected><fmt:message key="eMO.Clinical.label" bundle="${mo_labels}"/></option> 
						<%}else{%>
						<option value='C' ><fmt:message key="eMO.Clinical.label" bundle="${mo_labels}"/></option> 
							<%}%>
						<% if(postmortem_type.equals("M")){
							%>
						<option value='M' selected><fmt:message key="eMO.MedicoLegal.label" bundle="${mo_labels}"/></option>
						<%}else{%>
						<option value='M'><fmt:message key="eMO.MedicoLegal.label" bundle="${mo_labels}"/></option>
							<%}%>
							
						</SELECT><img id='idpttype'src='../../eCommon/images/mandatory.gif' align='center'  
						style='visibility:hidden' ></td>
						<td class='button' align="right""><input type="button" name="Consent_forms" id="Consent_forms" style="width:90"  class='BUTTON' value='<fmt:message key="Common.ConsentForm.label" bundle="${common_labels}"/>' onclick="getConsentForm()">
						</td>
					</tr>
			</table>
		</td>
	</tr>	
	<tr>
		<td>
			<table border="0" cellpadding="0" cellspacing="0" align='center' width='100%'> 
				<tr>
					<td class='COLUMNHEADER'><fmt:message key="Common.assignarea.label" bundle="${common_labels}"/></td>
				</tr> 
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<table border="0" cellpadding="3" cellspacing="0" align='center' width='100%'> 
					<tr>
						    <td class='label' width='25%'><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
							<td class='fields' width='25%' ><select <%=disabledyn%> name='service_code' id='service_code'   >
							<option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
									<%
										int serviceCount = 0;
										sstat = con.createStatement();
										String DFLT_SERVICE_CODE	= "";
									   //vrs = sstat.executeQuery("select SERVICE_CODE, am_get_desc.AM_SERVICE(SERVICE_CODE,'"+localeName+"',2) short_desc from AM_FACILITY_SERVICE_VW a where OPERATING_FACILITY_ID='"+facilityId+"' and dept_code =(select dept_code from mo_parameter where facility_id=a.operating_facility_id) and eff_status='E' order by short_desc");
									   //DFLT_SERVICE_CODE Added for Bru-HIMS-CRF-413 [IN:045501]
										vrs = sstat.executeQuery("select SERVICE_CODE, am_get_desc.AM_SERVICE(SERVICE_CODE,'"+localeName+"',2) short_desc,(select DFLT_SERVICE_CODE from mo_parameter where facility_id=a.operating_facility_id) DFLT_SERVICE_CODE from AM_FACILITY_SERVICE_VW a where OPERATING_FACILITY_ID='"+facilityId+"' and dept_code =(select dept_code from mo_parameter where facility_id=a.operating_facility_id) and eff_status='E' order by short_desc");
									   while(vrs.next())
									   {
								
										 	  DFLT_SERVICE_CODE	= vrs.getString("DFLT_SERVICE_CODE");
										   
										   if(!service_code.equals("")){  
											   if(service_code.equals(vrs.getString("SERVICE_CODE"))){
													   %>
													<option value='<%=vrs.getString("SERVICE_CODE")%>' selected> <%=vrs.getString("short_desc")%></option>
										   
													<%}else{%>
													<option value='<%=vrs.getString("SERVICE_CODE")%>'> <%=vrs.getString("short_desc")%></option>
												<%}
										   }else{
											   
											   if(vrs.getString("SERVICE_CODE").equals(DFLT_SERVICE_CODE)){
												   %>
												<option value='<%=vrs.getString("SERVICE_CODE")%>' selected> <%=vrs.getString("short_desc")%></option>
									   
												<%}else{%>
												<option value='<%=vrs.getString("SERVICE_CODE")%>'> <%=vrs.getString("short_desc")%></option>
											<%}
											
										   
											   
										   }
										   
										   
										   
									serviceCount++;
									} %>

									<script>										 
										if('<%=mode%>' == "insert" && '<%=serviceCount%>' == 1)
										  document.forms[0].service_code.options(1).selected=true;											
										</script><%
									   if(vrs!=null) vrs.close();
									   if(sstat!=null) sstat.close();
									  if(pstmt2!=null) pstmt2.close();%>

								</select><img src='../../eCommon/images/mandatory.gif' ></img></td>
							<td class='label' width='20%'><fmt:message key="Common.area.label" bundle="${common_labels}"/></td>
							<td class='fields' width='30%'>	<select name='area_type' id='area_type'  onblur='if(this.value =="")document.getElementById("tab1").scrollIntoView();document.forms[0].unclaimedbodyyn.focus();' onchange='clearBed();enableareagif();'>
							<option value = "">------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
							</select>
							</td>
				</tr>							
				<tr>
					  <td class='label'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
					  <td class='fields'><input type='text' name='bed_no' id='bed_no' size='8' maxlength='8'  value="<%=bed_no%>" 
					  onBlur='BedCheck();' ><input type=button class=button value='?' name='bed_button' id='bed_button' disabled  onClick='searchBed(this,bed_no);' ></td>
					  <td class='label'><fmt:message key="Common.assigndatetime.label" bundle="${common_labels}"/></td>
					  <td class='fields'><input type='text' id='assigndatetime' name="assign_date_time" id="assign_date_time"  value="<%=assign_date_time_cnv%>" maxLength='16' size='16' onBlur="if(validDateObj(this,'DMYHM',localeName)){chkAssignDate(this,'ASD')}else{this.value='';};document.forms[0].unclaimedbodyyn.focus();"  disabled><input  id='acalendar' type="image" src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('assigndatetime', null, 'hh:mm' );" disabled><img align='center' id='adatetime' style='visibility:hidden' src='../../eCommon/images/mandatory.gif'></img>
					  <input type="button" name="postmortem_det" id="postmortem_det" class=BUTTON  style="width:90;visibility:hidden"  value='<fmt:message key="eMO.PostMortem.label" bundle="${mo_labels}"/>' onclick="viewPostmortemDet()"></td>
				 </tr> 
				<%  
						String disRFID = "";

						if((mode.equals("modify") && !rfid_tag_num.equals("")) || mode.equals("viewdata") )
							disRFID="disabled" ; 
						
				if(enable_rfid_yn.equals("Y")) // added by mujafar for ML-MMOH-CRF-0996
				{
									%>
				 <tr>
				 <td class='LABEL' width='25%' ><fmt:message key="eMO.RFIDTag.label" bundle="${mo_labels}"/>&nbsp;</td>
				<td class='fields' width='25%'><input type='text' <%=disRFID%> name='RFID_Tag' size='20' maxlength='20' value="<%=rfid_tag_num%>" onBlur='blurRFID(this);' ><input type=button class=button value='?' <%=disRFID%> name='RFID_Tag_button' onClick='searchRFID(this,RFID_Tag);' ></td>

	</tr>
				<%
				}
				%>
			</table>
		</td>
	</tr>
</table> 
</div>
	<!--Added For [IN:046059] By Lenin on 02-Jan-2013 Start-->
	<div id = 'BURIAL' style = 'display:none'>
	<a name="tab4"></a>
	<!--Added For [IN:046059] By Lenin on 02-Jan-2013 End-->
			   <table cellspacing='0' cellpadding='0' width='100%' border='0' align='center'> 
					<tr>
						<td class='white' align='right'> 
							<INPUT TYPE="button" value='<fmt:message key="Common.Demographics.label" bundle="${common_labels}"/><fmt:message key="Common.details.label" bundle="${common_labels}"/>'  class='button' onClick="viewPatientDetails('<%=patient_id%>')"><INPUT TYPE="button" 
							value='<fmt:message key="Common.PreviousEncounters.label" bundle="${common_labels}"/>' onClick="showPrevEncounter('<%=patient_id%>');"class=button>
						</td>
					</tr>	
					<tr><td class='white'>&nbsp;</td></tr>
				</table>

				<ul id="tablist" class="tablist">
					<li class="tablistitem" title="RegnDtls">
						<a onclick="javascript:tab_enable('regn_dtls_tab')" id="regn_dtls_tab" class="tabA">
						<span class="tabAspan" id="regn_dtls_tabspan"><fmt:message key="eMO.RegistrationDtls.label" bundle="${mo_labels}"/></span>
						</a>
					</li>
					<li class="tablistitem" title="OrganDonation">
						<a onclick="javascript:tab_enable('organ_dtn_tab')" id="organ_dtn_tab" class="tabA">
						<span class="tabAspan" id="organ_dtn_tabspan"><fmt:message key="eMO.OrganDonation.label" bundle="${mo_labels}"/></span><!--bundle change for PAS-MO-PMG2020-TECH-CRF-0010/02-Label Name-->
						</a>
					</li>
					<!--Added by Ashwini on 17-Oct-2017 for ML-MMOH-CRF-0696-->
					<%if(rearrangeTabBurlPermtClaimnt){%>
					<li class="tablistitem" title="BurialPermit" id='dis4'>
						<a onclick="javascript:tab_enable('burial_prmt_tab')" id="burial_prmt_tab" class="tabClicked">
						<span class="tabSpanclicked" id="burial_prmt_tabspan"><fmt:message key="eMO.BurialPermit.label" bundle="${mo_labels}"/></span><!--bundle change for PAS-MO-PMG2020-TECH-CRF-0010/02-Label Name-->
						</a>
					</li>
					<li class="tablistitem" title="Claimant" >
						<a onclick="javascript:tab_enable('claimant_tab')" id="claimant_tab" class="tabA">
						<span class="tabAspan" id="claimant_tabspan"><fmt:message key="eMO.Claimant.label" bundle="${mo_labels}"/></span><!--bundle change for PAS-MO-PMG2020-TECH-CRF-0010/02-Label Name-->
						</a>
					</li>	
					<%}else{%>
					<li class="tablistitem" title="Claimant">
						<a onclick="javascript:tab_enable('claimant_tab')" id="claimant_tab" class="tabA">
						<span class="tabAspan" id="claimant_tabspan"><fmt:message key="eMO.Claimant.label" bundle="${mo_labels}"/></span><!--bundle change for PAS-MO-PMG2020-TECH-CRF-0010/02-Label Name-->
						</a>
					</li>	
					<li class="tablistitem" title="BurialPermit" id='dis4'>
						<a onclick="javascript:tab_enable('burial_prmt_tab')" id="burial_prmt_tab" class="tabClicked">
						<span class="tabSpanclicked" id="burial_prmt_tabspan"><fmt:message key="eMO.BurialPermit.label" bundle="${mo_labels}"/></span><!--bundle change for PAS-MO-PMG2020-TECH-CRF-0010/02-Label Name-->
						</a>
					</li>	
					<%}%>
				</ul>				
	

	<table border="0" cellpadding="3" cellspacing="0" align='center' width='100%'>

	<% 
		if(body_claiming_date_time!=null && !body_claiming_date_time.equals(""))
		{
			body_claiming_date_time_cnv = DateUtils.convertDate(body_claiming_date_time,"DMYHM","en",localeName); 	
		}
		if(burial_perm_date!=null && !burial_perm_date.equals(""))
		{
			burial_perm_date_cnv = DateUtils.convertDate(burial_perm_date,"DMYHM","en",localeName); 	
		}
		
		
	//  Added against IN:45900 by Dharma on 23rd Dec 2013 Start
	String disable_date_of_claiming			= "";
	String disable_vehicle_no				= "";	
	String disable_burial_permit_app_by		= "";
	String disable_burial_permit_app_date	= "";
	
	if(external.equals("Y") && mode.equals("insert")) {	
		if(!body_claiming_date_time_cnv.equals("")){
			disable_date_of_claiming			= "disabled";
		}
		
		if(!vechile_no.equals("")){
			disable_vehicle_no			= "disabled";
		}
		
		if(!burial_perm_by.equals("")){
			disable_burial_permit_app_by			= "disabled";
		}
		
		if(!burial_perm_date_cnv.equals("")){
			disable_burial_permit_app_date			= "disabled";
		}
	}
	
	//  Added against IN:45900 by Dharma on 23rd Dec 2013 End
	
	/*Below line added for this ML-MMOH-CRF-0695*/
	if(datetimeofclaimingApplicable && !function_id.equals("Reg_Details")){
		   body_claiming_date_time_cnv = DateUtils.convertDate(sys_date,"DMYHM","en",localeName); 
		   datetimeofclaiming="disabled";
           disable_date_of_claiming= "";		   
	}else{
		   datetimeofclaiming=disablebut;
	}
	//End this CRF ML-MMOH-CRF-0695
	
	
	%>	

<%	if(burial_perm_no.equals("")&&(!mode.equals("viewdata"))){%>
	<tr>
		<td class='label' width='25%'><fmt:message key="eMO.GenerateBurialPermitNo.label" bundle="${mo_labels}"/></td>
		<td class='fields' width='25%'><INPUT TYPE="checkbox" name="generate_burial_permit" id="generate_burial_permit"  onClick='enterBurial(this)'></td>
		<td colspan='2'>&nbsp;</td>
	</tr>
	<%}else{%>
	<INPUT TYPE="hidden" name="generate_burial_permit" id="generate_burial_permit">
	<%}%>
	<tr><!--maxlength="16" canged to max_size_burial_permit_no, Added by santhosh for ML-MMOH-CRF-1947-->
		<td class='label' width='25%'><fmt:message key="eMO.BurialPermitNumber.label" bundle="${mo_labels}"/>&nbsp;</td>
		<td class='fields' width='25%'><input type='text' size='16' maxlength="<%=max_size_burial_permit_no%>" name='body_burial_permit_no' id='body_burial_permit_no' onKeyPress="return CheckForSpecCharsLocal(event);" <%=disablebut%> value='<%=burial_perm_no%>'><img id = 'burMan' src='../../eCommon/images/mandatory.gif'  ></img> </td> 
		<td colspan='2'>&nbsp;</td>
	</tr>
	
	<!--Below code modified by Shanmukh for CRF ML-MMOH-CRF-1183-->
	<%if(isDateTimeOfDeathAppl){%>
	<tr>
	       <td class='label'><fmt:message key="eMO.DateTimeOfDeath.label" bundle="${mo_labels}"/></td>
		   <%if(calledFrom.equals("MO_BID_REGN") || extBidYnFrmVw.equals("Y") || brought_dead_yn.equals("Y")){%>
		   <td class='fields' width='25%'><input type='text' name='disDeathDate' id='disDeathDate' value ='<%=deceased_date_cnv%>' disabled></td><%}else{%>
		   <td class='QUERYDATA' width='25%'><%=deceased_date_cnv%></td> <%}%>
	</tr><%}%><!--  !datetimeOfClaimingAppl condition Added by Santhosh for ML-MMOH-CRF-1948-->
	<%if(!isChangeOfDateTimeClaimingAppl && !datetimeOfClaimingAppl){%><!--Condition is to hide label, For ML-ML-MMOH-CRF-1031-->
	<!--Below line modified for this CRF ML-MMOH-CRF-0695-->
	<tr>
	
		<td class='label'><fmt:message key="eMO.DateTimeOfClaiming.label" bundle="${mo_labels}"/></td>
		<td class='fields'><input type='text' size='16' maxlength='16' name='body_claiming_date_time' id='body_claiming_date_time'  value='<%=body_claiming_date_time_cnv%>' onblur="if(validDateObj(this,'DMYHM',localeName))chkAssignDate(this,'CLD')" <%=datetimeofclaiming%> <%=disable_date_of_claiming%> >
		<%if(!datetimeofclaimingApplicable){%><img src='../../eCommon/images/CommonCalendar.gif' id='otdatetime1'  name='OTDate1' onClick="document.forms[0].body_claiming_date_time.select();return showCalendar('body_claiming_date_time',null,'hh:mm');" <%=datetimeofclaiming%> style="cursor='hand'"  ><img id = 'burMan1' src='../../eCommon/images/mandatory.gif' ></img><%}%></td>
		<td colspan='2'>&nbsp;</td>
	</tr>
	<%}%>
     <!--End this CRF ML-MMOH-CRF-0695-->	
	<tr>	
		<td class='label'><fmt:message key="eMO.VehicleNumber.label" bundle="${mo_labels}"/></td>
		<td class='fields'><INPUT TYPE="text" name="vechile_no" id="vechile_no"  maxlength=30 value='<%=vechile_no%>' <%=disable_vehicle_no%> ></td> 
		<td colspan='2'>&nbsp;</td>
		</tr>	
	<tr>

	<td class='label'><fmt:message key="eMO.BurialPermitApprovedBy.label" bundle="${mo_labels}"/></td>
	<td class='fields'>
	<%
		  if(brought_dead_yn.equals("Y")&&mlc_yn.equals("Y")&&postmortem_status.equals("Y"))
		  {	
	%>
	<!--Modified by Ashwini on 01-Jul-2019 for ML-MMOH-CRF-0990-->
	<%if(!isRemoveMandBPermitAppBy){%>
		<input type="text" name="burial_permit_app_desc" id="burial_permit_app_desc" value="<%=burial_permit_appr_by_name%>" size="30" maxlength="30" onBlur='beforeGetPractitioner(document.forms[0].pract_id,burial_permit_app_desc);' <%=disablebut%> <%=disable_burial_permit_app_by%>><input type='button' name='pract_id' id='pract_id' value='?' class='button' onclick='searchCode(this, burial_permit_app_desc)' <%=disablebut%>>
		<input type='hidden' name='burial_permit_app_by' id='burial_permit_app_by' value ='<%=burial_perm_by%>'><img id = 'burMan2' src='../../eCommon/images/mandatory.gif' ></img>
	<%}else{%>
		<input type='text' name='burial_permit_app_by' id='burial_permit_app_by' value="<%=burial_permit_appr_by_name%>" size="60" maxlength="60" <%=disablebut%>>
		<input type=hidden name='pract_id' id='pract_id'>
		<input type='hidden' name='burial_permit_app_desc' id='burial_permit_app_desc' value =''>
	<%}%>
	
	<%}else if(mlc_yn.equals("Y")||postmortem_status.equals("Y"))
	 {%>
	
	<%if(!isRemoveMandBPermitAppBy){%>
		 <input type="text" name="burial_permit_app_desc" id="burial_permit_app_desc" value="<%=burial_permit_appr_by_name%>" size="30" maxlength="30" onBlur='beforeGetPractitioner(document.forms[0].pract_id,burial_permit_app_desc);' <%=disablebut%> <%=disable_burial_permit_app_by%>><input type='button'  name='pract_id' id='pract_id' value='?' class='button' onclick='searchCode(this, burial_permit_app_desc)' <%=disablebut%>>
		   <input type='hidden' name='burial_permit_app_by' id='burial_permit_app_by' value ='<%=burial_perm_by%>'><img id = 'burMan2' src='../../eCommon/images/mandatory.gif' ></img>
	<%}else{%>
		<input type='text' name='burial_permit_app_by' id='burial_permit_app_by' value="<%=burial_permit_appr_by_name%>" size="60" maxlength="60" <%=disablebut%>>
		<input type=hidden name='pract_id' id='pract_id'>
		<input type='hidden' name='burial_permit_app_desc' id='burial_permit_app_desc' value =''>
	<%}%>
	 
	 <%}
    else if(brought_dead_yn.equals("N")&&(mlc_yn.equals("Y")||postmortem_status.equals("Y")))
		  {%>
		<%if(!isRemoveMandBPermitAppBy){%>
			<input type="text" name="burial_permit_app_desc" id="burial_permit_app_desc" value="<%=burial_permit_appr_by_name%>" size="30" maxlength="30" onBlur='beforeGetPractitioner(document.forms[0].pract_id,burial_permit_app_desc);' <%=disablebut%> <%=disable_burial_permit_app_by%>><input type='button'   name='pract_id' id='pract_id' value='?' class='button' onclick='searchCode(this, burial_permit_app_desc)' <%=disablebut%>>
		   <input type='hidden' name='burial_permit_app_by' id='burial_permit_app_by' value ='<%=burial_perm_by%>'><img id = 'burMan2' src='../../eCommon/images/mandatory.gif' ></img>
		<%}else{%>
			<input type='text' name='burial_permit_app_by' id='burial_permit_app_by' value="<%=burial_permit_appr_by_name%>" size="60" maxlength="60" <%=disablebut%>>
			<input type=hidden name='pract_id' id='pract_id'>
			<input type='hidden' name='burial_permit_app_desc' id='burial_permit_app_desc' value =''>
		<%}%>
		  
		  <%}
		else if(brought_dead_yn.equals("N")&&(!(mlc_yn.equals("Y")&&postmortem_status.equals("Y"))))
		  {%>
		  <%if(!isRemoveMandBPermitAppBy){%>
				<input type="text" name="burial_permit_app_desc" id="burial_permit_app_desc" value="<%=burial_permit_appr_by_name%>" size="30" maxlength="30" onBlur='beforeGetPractitioner(document.forms[0].pract_id,burial_permit_app_desc);' <%=disablebut%> <%=disable_burial_permit_app_by%>><input type='button'   name='pract_id' id='pract_id' value='?' class='button' onclick='searchCode(this, burial_permit_app_desc)' <%=disablebut%>>
			   <input type='hidden' name='burial_permit_app_by' id='burial_permit_app_by' value ='<%=burial_perm_by%>'><img id = 'burMan2' src='../../eCommon/images/mandatory.gif' ></img>
		 <%}else{%>
			<input type='text' name='burial_permit_app_by' id='burial_permit_app_by' value="<%=burial_permit_appr_by_name%>" size="60" maxlength="60" <%=disablebut%>>
			<input type=hidden name='pract_id' id='pract_id'>
			<input type='hidden' name='burial_permit_app_desc' id='burial_permit_app_desc' value =''>
		<%}%>
		 <%}	  
	  else{ %>
  <%if(!isRemoveMandBPermitAppBy){%>
	<input type="text" name="burial_permit_app_desc" id="burial_permit_app_desc" value="<%=burial_permit_appr_by_name%>" size="15" maxlength="15"  <%=disablebut%> <%=disable_burial_permit_app_by%>><input type='button'   style="visibility:hidden;width='0%'" name='pract_id' id='pract_id' value='' class='button'>
	<input type='hidden' name='burial_permit_app_by' id='burial_permit_app_by' value ='<%=burial_perm_by%>'>
	<img id = 'burMan2' src='../../eCommon/images/mandatory.gif' ></img>
	
	 <%}else{%>
			<input type='text' name='burial_permit_app_by' id='burial_permit_app_by' value="<%=burial_permit_appr_by_name%>" size="60" maxlength="60" <%=disablebut%>>
			<input type=hidden name='pract_id' id='pract_id'>
			<input type='hidden' name='burial_permit_app_desc' id='burial_permit_app_desc' value =''>
		<%}%>
	<%}%>
	</td> 
	<td colspan='2'>&nbsp;</td>
	</tr>
	<tr>
		<td class='label'><fmt:message key="Common.BurialPermitApprovedDate.label" bundle="${common_labels}"/></td>
		<td><input type='text' size='16' maxlength='16' name='burial_app_date' id='burial_app_date' onfocus='' value='<%=burial_perm_date_cnv%>' onblur="if(validDateObj(this,'DMYHM',localeName))chkAssignDate(this,'CLD')"  <%=readText%> <%=disablebut%> <%=disable_burial_permit_app_date%>><input type="image" id='buraprdt' src="../../eCommon/images/CommonCalendar.gif"   onClick="document.forms[0].burial_app_date.select();return showCalendar('burial_app_date', null, 'hh:mm' );" <%=disablebut%> style="cursor='hand'"><img id = 'burMan3' src='../../eCommon/images/mandatory.gif' ></img></td>
		<td colspan='2'>&nbsp;</td>
	</tr>
	
	</table>
</div>
	  <!-- table close of mortuary services ***************** -->
	  	<!--Added For [IN:046059] By Lenin on 02-Jan-2013 Start-->
  <div id = 'CLAIMANT' style = 'display:none'>
  <a name="tab3"></a>
	    <!--Added For [IN:046059] By Lenin on 02-Jan-2013 End-->
				<table cellspacing='0' cellpadding='0' width='100%' border='0' align='center'> 
					<tr>
						<td class='white' align='right'> 
							<INPUT TYPE="button" value='<fmt:message key="Common.Demographics.label" bundle="${common_labels}"/><fmt:message key="Common.details.label" bundle="${common_labels}"/>'  class='button' onClick="viewPatientDetails('<%=patient_id%>')"><INPUT TYPE="button" 
							value='<fmt:message key="Common.PreviousEncounters.label" bundle="${common_labels}"/>' onClick="showPrevEncounter('<%=patient_id%>');"class=button>
						</td>
					</tr>	
					<tr><td class='white'>&nbsp;</td></tr>
				</table>

				<ul id="tablist" class="tablist">
					<li class="tablistitem" title="RegnDtls">
						<a onclick="javascript:tab_enable('regn_dtls_tab')" id="regn_dtls_tab" class="tabA">
						<span class="tabAspan" id="regn_dtls_tabspan"><fmt:message key="eMO.RegistrationDtls.label" bundle="${mo_labels}"/></span>
						</a>
					</li>
					<li class="tablistitem" title="OrganDonation">
						<a onclick="javascript:tab_enable('organ_dtn_tab')" id="organ_dtn_tab" class="tabA">
						<span class="tabAspan" id="organ_dtn_tabspan"><fmt:message key="eMO.OrganDonation.label" bundle="${mo_labels}"/></span><!--bundle change for PAS-MO-PMG2020-TECH-CRF-0010/02-Label Name-->
						</a>
					</li>
					<!--Added by Ashwini on 17-Oct-2017 for ML-MMOH-CRF-0696-->
					<%if(rearrangeTabBurlPermtClaimnt){%>
					<li class="tablistitem" title="BurialPermit" id='dis1'>
						<a onclick="javascript:tab_enable('burial_prmt_tab')" id="burial_prmt_tab" class="tabA">
						<span class="tabAspan" id="burial_prmt_tabspan"><fmt:message key="eMO.BurialPermit.label" bundle="${mo_labels}"/></span><!--bundle change for PAS-MO-PMG2020-TECH-CRF-0010/02-Label Name-->
						</a>
					</li>
					<li class="tablistitem" title="Claimant" id='clmt'>
						<a onclick="javascript:tab_enable('claimant_tab')" id="claimant_tab" class="tabClicked">
						<span class="tabSpanclicked" id="claimant_tabspan"><fmt:message key="eMO.Claimant.label" bundle="${mo_labels}"/></span><!--bundle change for PAS-MO-PMG2020-TECH-CRF-0010/02-Label Name-->
						</a>
					</li>	
					<%}else{%>
					<li class="tablistitem" title="Claimant" id='clmt'>
						<a onclick="javascript:tab_enable('claimant_tab')" id="claimant_tab" class="tabClicked">
						<span class="tabSpanclicked" id="claimant_tabspan"><fmt:message key="eMO.Claimant.label" bundle="${mo_labels}"/></span><!--bundle change for PAS-MO-PMG2020-TECH-CRF-0010/02-Label Name-->
						</a>
					</li>	
					<li class="tablistitem" title="BurialPermit" id='dis1'>
						<a onclick="javascript:tab_enable('burial_prmt_tab')" id="burial_prmt_tab" class="tabA">
						<span class="tabAspan" id="burial_prmt_tabspan"><fmt:message key="eMO.BurialPermit.label" bundle="${mo_labels}"/></span><!--bundle change for PAS-MO-PMG2020-TECH-CRF-0010/02-Label Name-->
						</a>
					</li>
					<%}%>
				</ul>	
			
			<table border="0" cellpadding="0" cellspacing="0" align='center' width='100%'> 
				<!--Added For Bru-HIMS-CRF-0368 By Dharma on 4th Dec 2013 Start-->
				<%
				
				if(external_rec_exists.equals("Y") && external.equals("Y") && mode.equals("insert")){	%>
					<tr><td class='fields' colspan="2"><a  href="javascript:FnDefaultPreviousClaimantDetails();" ><fmt:message key="eMO.DefaultPreviousClaimantDetails.label" bundle="${mo_labels}"/></a></td></tr>
				<%}%>
				<!--Added For Bru-HIMS-CRF-0368 By Dharma on 4th Dec 2013 End-->
				<tr><!-- // ALIGNMENT Changes Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg -->
					<td class='label' width="20%"><fmt:message key="eMO.Claimant.label" bundle="${mo_labels}"/> <fmt:message key="Common.type.label" bundle="${common_labels}"/></td>&nbsp;			
					<td class='fields' width="30%">&nbsp;<select name='CLAIMANT_TYPE' id='CLAIMANT_TYPE'   onchange="getClaimant(this,'<%=claimant_type_code%>');" onBlur='' >
								 <option value='' >------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
							
							 <!--Added by Ashwini on 11-Oct-2018 for ML-MMOH-CRF-1095-->
							  <%
								for(int i = 0 ; i < ClaimantTypeJsonArr.size() ; i++) 
								{
									JSONObject ClaimantTypeJson	= (JSONObject)ClaimantTypeJsonArr.get(i);
									String claimant_type_mstr_code = (String) ClaimantTypeJson.get("claimant_type_mstr_code");
									String claimant_short_desc = (String) ClaimantTypeJson.get("short_desc");
									out.println("<option value='"+claimant_type_mstr_code+"'>"+claimant_short_desc+"</option>");	
								}
							  %>
							
							<!--<%if(claimant_type.equals("K")){%>
								 <option value='K' selected><fmt:message key="Common.nextofkin.label" bundle="${common_labels}"/></option>
								 <%}else{%>
								 <option value='K' ><fmt:message key="Common.nextofkin.label" bundle="${common_labels}"/></option>
								 <%}			
								 if(claimant_type.equals("E")){%>
								 <option value='E' selected><fmt:message key="Common.employer.label" bundle="${common_labels}"/></option>
								 <%}else{%>
								 <option value='E' ><fmt:message key="Common.employer.label" bundle="${common_labels}"/></option>
								 <%}
								if(claimant_type.equals("M")){%>
								 <option value='M' selected><fmt:message key="eMO.EmbassyCountry.label" bundle="${mo_labels}"/></option>
								 <%}else{%>
								 <option value='M' ><fmt:message key="eMO.EmbassyCountry.label" bundle="${mo_labels}"/></option>
								 <%}
								if(claimant_type.equals("W")){%>
								 <option value='W' selected><fmt:message key="eMO.WelfareAssociations.label" bundle="${mo_labels}"/></option>
								 <%}else{%>
								 <option value='W' ><fmt:message key="eMO.WelfareAssociations.label" bundle="${mo_labels}"/></option>
								 <%}
								if(claimant_type.equals("R")){%>
							   <option value='R' selected><fmt:message key="eMO.ReligiousOrgn.label" bundle="${mo_labels}"/></option>
								 <%}else{%>
								   <option value='R' ><fmt:message key="eMO.ReligiousOrgn.label" bundle="${mo_labels}"/></option>
								 <%}
							   if(claimant_type.equals("U")){%>
							   <option value='U' selected><fmt:message key="eMO.UnderTaker.label" bundle="${mo_labels}"/></option>
							   <%}else{%>
							   <option value='U' ><fmt:message key="eMO.UnderTaker.label" bundle="${mo_labels}"/></option>
								<%}
								 if(claimant_type.equals("F")){%>
								 <option value='F' selected><fmt:message key="eMO.ReleasedToOtherFacility.label" bundle="${mo_labels}"/></option>
								 <%}else{%>
								<option value='F' ><fmt:message key="eMO.ReleasedToOtherFacility.label" bundle="${mo_labels}"/></option>
								 <%}
								 if(claimant_type.equals("O")){%>
								 <option value='O' selected><fmt:message key="Common.others.label" bundle="${common_labels}"/></option>
								 <%}else{%>
								<option value='O' ><fmt:message key="Common.others.label" bundle="${common_labels}"/></option>
								 <%}%>	-->							
						 </select></td>	
						 <!-- // ALIGNMENT Changes Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg -->				 
					   <td class='label' width='20%'><fmt:message key="eMO.Claimant.label" bundle="${mo_labels}"/>&nbsp;</td>
					   <td class='fields'>&nbsp;<select name='CLAIMANT_TYPE_CODE' id='CLAIMANT_TYPE_CODE' onchange="set_values(this,'<%=patient_id%>');"  disabled><option value=''>------<fmt:message key="Common.defaultSelect.label" 
					   bundle="${common_labels}"/>------</select><img src='../../eCommon/images/mandatory.gif'align='center' id=id3 style="visibility:hidden"></img>
					  </td>
					 <td class='button'><INPUT TYPE="button" value='<fmt:message key="eMO.CopyDetails.label" bundle="${mo_labels}"/>' name=copydet disabled onClick="copyDet('<%=patient_id%>')"class=button></td>
	<tr>				  </tr>
		<td colspan='1'>&nbsp;</td>
	</tr>
	<!-- Added by Santhosh for ML-MMOH-CRF-1948-->
	<%if(datetimeOfClaimingAppl){%>	
   <tr>
	<td class='label'><fmt:message key="eMO.DateTimeOfClaiming.label" bundle="${mo_labels}"/></td>
	<td class='fields'><input type='text' size="16" maxlength="16" name='body_claiming_date_time' id='body_claiming_date_time' <%if(mode.equals("insert")){%>value=''<%}else{%>value='<%=body_claiming_date_time%>'<%}%> onblur='dtchk(this);'><img src="../../eCommon/images/CommonCalendar.gif"  onClick="document.forms[0].body_claiming_date_time.select();return showCalendar('body_claiming_date_time', null, 'hh:mm' );" style="cursor='hand'"><%if( datetime_claim_mand.equals("D")){%><img src='../../eCommon/images/mandatory.gif'align='center'></img><%}%> </td>
	</tr><!--END-->
	<%}else if(isChangeOfDateTimeClaimingAppl){%>	 <!--Added by Shanmukh on 25th-JUNE-2018 for ML-MMOH-CRF-1031	-->		
	<tr>
		<td class='label'><fmt:message key="eMO.DateTimeOfClaiming.label" bundle="${mo_labels}"/></td>
		<td class='fields'><input type='text' size='16' maxlength='16' name='body_claiming_date_time' id='body_claiming_date_time'  <%if(mode.equals("insert")){%>value=''<%}else{%>value='<%=body_claiming_date_time%>'<%}%>  onblur="if(validDateObj(this,'DMYHM',localeName))chkAssignDate(this,'CLD')"><img src='../../eCommon/images/CommonCalendar.gif' id='otdatetime1'  name='OTDate1' onClick="return showCalendar('body_claiming_date_time',null,'hh:mm');"<%if(functionid.equals("MO_REGN_DTLS_QUERY")){%> disabled <%}%>style="cursor='hand'"  ><img  src='../../eCommon/images/mandatory.gif' ></img></td>
		
	</tr>
	<%}%>
	<!--End-->
	
</table>
			
<table cellspacing='0' cellpadding='0' width='100%' border='0' align='center'>
	<tr>
		<td valign='top' width='50%'>
			<table cellspacing='0' cellpadding='3' width='100%' border='0' align='center'>
				<tr><!-- // ALIGNMENT Changes Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg -->
				     <!--Below line added for ML-MMOH-CRF-0887.1-->
					<td class='label' width='20%'><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
					<td class='fields' width='30%'><%if(increasedaddressLength){%>
				   <textarea name='NAME' rows=3 maxlength=80 cols=45 onblur='makeValidString(this); maxLengthPaste1(this);' onkeypress='checkMaxLimit(this,80)' onkeyup='RemoveSpecialChar(this)'><%=name%></textarea>
			      <%}else{%>						
					<input type="text" name="NAME" id="NAME"  maxlength='30' size='20'  value="<%=name%>" ></td>
				 <%}%>
				</tr>
				<tr>  <!-- // ALIGNMENT Changes Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg -->
				<td class='label'width='20%'><fmt:message key="Common.relationship.label" bundle="${common_labels}"/></td>
				<td class='fields'width='30%'><select name='RELATIONSHIP' id='RELATIONSHIP' ><option value="">-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ----------</option>
				 <% pstmt2  = con.prepareStatement("select RELATIONSHIP_CODE,SHORT_DESC from MP_RELATIONSHIP_LANG_VW where language_id='"+localeName+"' and eff_status='E' order by 2");
	 
				 vrs = pstmt2.executeQuery();
				 while(vrs.next())
				  {
					 if(vrs.getString("RELATIONSHIP_CODE").equals(relationship))
					  {%>
						 <option value='<%=vrs.getString("RELATIONSHIP_CODE")%>' selected ><%=vrs.getString("SHORT_DESC")%> </option>
						  <%}else
						  {%>
						<option value='<%=vrs.getString("RELATIONSHIP_CODE")%>' ><%=vrs.getString("SHORT_DESC")%> </option>
						 <%}
						  
							  
				  }%>  
				</td>
			</tr>	
	<%	if(accept_national_id_no_yn.equals("Y")){%>

	<tr><!-- // ALIGNMENT Changes Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg -->

		<!--Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743-->
		<%if(!isClaimantChngsApplicable){%>
		<td class='label'width='20%'><%=nat_id_prompt%></td>
		<%}else{%>
		<td class='label'width='20%'><fmt:message key="eMO.MyKad.label" bundle="${mo_labels}"/></td>
		<%}%>	
		<td class='fields'width='30%'><input type="text" name="NAT_ID_NO" id="NAT_ID_NO"  maxlength='<%=nat_id_length%>' size='20'  value='<%=nat_id_no%>' >
		</td>
	</tr>	
  <%}else{%>
		<input type=hidden name=NAT_ID_NO value="">
	
	<%	}%>	
	
	<tr><!-- // ALIGNMENT Changes Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg -->
		<td class='label'width='20%'><fmt:message key="Common.EmployeeID.label" bundle="${common_labels}"/></td>
		<td class='fields'width='30%'><input type="text" name="PATIENT_EMPLOYEE_ID" id="PATIENT_EMPLOYEE_ID"  maxlength='20' size='20'  value='<%=patient_employee_id%>' >
		</td>
    </tr>
	<%if(isClaimantChngsApplicable){%>
	<tr><td  class='LABEL' width='20%'><fmt:message key="eMP.PassportNo.label" bundle="${mp_labels}"/></td>
	<td class='fields' width='30%'>   <input type="text" name="PASSPORT_NO" id="PASSPORT_NO" onBlur='validSplchars(this);' onKeyPress="return SpCharChkForPassportNo(event);" maxlength='15' size='15'  value='<%=Passport_No%>' >
	</td></tr>
	<tr><td  class='LABEL' width='20%'><fmt:message key="eMO.OtherId.label" bundle="${mo_labels}"/></td>
	<td class='fields' width='30%'>   <input type="text" name="OTHER_IDENTIFICATION" id="OTHER_IDENTIFICATION"  maxlength='60' size='30'  value='<%=Other_Identification%>' >
	</td></tr>
	<%}%>
       <!--Below line added for this CRF ML-MMOH-CRF-0860.2-->
	<tr><!-- // ALIGNMENT Changes Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg -->
		<td class='label' width='20%'><fmt:message key="eMP.occupation.label" bundle="${mp_labels}"/></td>
		<td class='fields' width='30%'><input type="text" name="JOB_TITLE" id="JOB_TITLE"  maxlength='<%=maximumLength%>' size='<%=maxsize%>'  value='<%=job_title%>' ></td>
    </tr>
   <tr><!-- // ALIGNMENT Changes Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg -->
        <!--Below line added for this CRF ML-MMOH-CRF-0860.2-->
		<td class='label'width='20%'><fmt:message key="Common.orgName.label" bundle="${common_labels}"/></td>
		<td class='fields'width='30%'><input type="text" name="ORGANIZATION_NAME" id="ORGANIZATION_NAME"  maxlength='<%=maximumLength%>' size='<%=maxsize%>'  value='<%=organization_name%>' ></td>
   </tr>
<%if(!ocpn_class_desc.equals("")){%>
<!-- // ALIGNMENT Changes Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg -->	
<tr><td class='label' id='hed1'width='20%'><fmt:message key="eMP.OccupationClass.label" bundle="${mp_labels}"/></td>
<td><label id=ocpnlab class='querydata'width='30%'><b><%=ocpn_class_desc%></b></td>
</tr>
<%}else{%><!-- // ALIGNMENT Changes Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg -->
<tr><td class='label' id='hed1'width='20%'>&nbsp;</td>
<td><label id='ocpnlab'width='30%'></td>
</tr>
<%}if(!mode.equals("insert") && claimant_type.equals("F")){ 
releasefacility = "visibility:visible";
}%>
<!--  Added Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg-->
<tr>
<td class="label" width='20%' id='releasefacid'style="<%=releasefacility%>"><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>&nbsp;
<td class="fields" width='30%' id='releasefacdesc'style="<%=releasefacility%>"><select name='RELEASE_TO_FACILITY' id='RELEASE_TO_FACILITY'>
<!--option value='' selected>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option-->
 <% pstmt2  = con.prepareStatement("select b.FACILITY_ID facility_id ,a.FACILITY_NAME facility_name from SM_FACILITY_PARAM a,sm_modules_facility b where a.facility_id = b.facility_id and b.module_id = 'MO' and a.facility_id!='"+facilityId+"'order by 2");
				 vrs = pstmt2.executeQuery();
				 while(vrs.next())
				  {
					 release_fac_id= vrs.getString("facility_id");
					 
					 release_fac_desc= vrs.getString("facility_name");
							// out.println("<script>alert('release_fac_desc---- :"+release_fac_desc+"')</script>");
					 %>
						 
						  <%if((!mode.equals("insert"))&&release_fac_id.equals(RELEASE_TO_FACILITY))
						 {%>
						<option value='<%=release_fac_id%>'selected><%=release_fac_desc%> </option>
						 <%}else{%>
						 <option value='<%=release_fac_id%>'><%=release_fac_desc%> </option>
						 <%} 
						  
							  
				  }%> 		 </select></td>
<!--  Saanthaakumar  Bru-HIMS-CRF-366 [IN:039612] End-->
	 </tr> 
	 <!--Below line Added for this CRF Bru-HIMS-CRF-366 [IN:039612] -->
	 <tr>
<td class="label" width='20%' id='remarksid' style="<%=releasefacility%>"><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>&nbsp;
<td class="fields" width='30%' id='remarksdesc' style="<%=releasefacility%>"><textarea name='reason_desc' rows='5' cols='40'  onKeyPress='checkMaxLimit(this,100);' onpaste='return maxLengthPaste(this,"100");' onBlur='return maxLength(this,"100");'>
<%=reason_deceased_desc%></textarea>
							
</td></tr>
 </table>
</td>  
<td>
     <table cellspacing='0' cellpadding='3' border='0'>              
      

				<%
 String[] address1_fld_names={"addr_line_1","addr_line_2","addr_line_3","addr_line_4","region","area","town","postal_code"};
String[] address_col_names=	{"ADDR_LINE1_PROMPT","ADDR_LINE2_PROMPT","ADDR_LINE3_PROMPT","ADDR_LINE4_PROMPT","REGION_PROMPT","RES_AREA_PROMPT","RES_TOWN_PROMPT","POSTAL_CODE_PROMPT"};


	

String[] address_fld_values=	{addrl1,addrl2,addrl3,addrl4,region_desc,res_area_desc,res_town_desc,postal_code};	      
ArrayList contact_addr= fetchContactAddresses(con,out,"parent.parent.messageFrame",p) ;
String[]	contact_col_names		        = (String[])contact_addr.get(1) ;
String[]	 contact_prompts			    = (String[])contact_addr.get(2) ;
//String[]  contact_fields					= (String[])contact_addr.get(3) ;
 contact_addr				    = null;
int k=0;
int l=1;




for(int i=0;i<contact_col_names.length;i++) 
 {
// if( !( contact_col_names[i].equalsIgnoreCase("REGION_PROMPT") ||contact_col_names[i].equalsIgnoreCase("RES_AREA_PROMPT") || contact_col_names[i].equalsIgnoreCase("RES_TOWN_PROMPT")) )
  //{
   out.println("<tr><td class='label' width='20%'>"+contact_prompts[i]+"</td>") ;		
   for(int j=0; j<address_col_names.length; j++)
     {
	if(address_col_names[j].equalsIgnoreCase(contact_col_names[i]))
	 {%>
		   <input type=hidden name=claim<%=j%> value="<%=address1_fld_names[j]%>" >	
	 <%	  if(address_col_names[j].equalsIgnoreCase("REGION_PROMPT"))
		   {
			 out.println("<td class='fields' width='30%'><input type='text' name='"+address1_fld_names[j]+"' id='"+address1_fld_names[j]+"' value=\""+ecis.utils.HTMLUtilities.getDisplayString(address_fld_values[j])+"\"	maxLength='30' size='30'  onBlur='searchCountry1(this,region)'  onKeyPress='return CheckForSpecChars(event)'><input type='button' name='reg_search' id='reg_search' class='BUTTON'  id='rgnsrh' value='?'   onClick=searchCountry(this,region) ></td>") ;  			
		   }else if(address_col_names[j].equalsIgnoreCase("RES_AREA_PROMPT"))
		   {
			 out.println("<td class='fields' width='30%'><input type='text' name='"+address1_fld_names[j]+"' id='"+address1_fld_names[j]+"' value=\""+ecis.utils.HTMLUtilities.getDisplayString(address_fld_values[j])+"\"	maxLength='30' size='30' onBlur='searchCountry1(this,area)'  onKeyPress='return CheckForSpecChars(event)'><input type='button' name='areasrch' id='areasrch' class='BUTTON'  id='areasrch' value='?'   onClick=searchCountry(this,area) ></td>") ;  			
		   }else if(address_col_names[j].equalsIgnoreCase("RES_TOWN_PROMPT"))
		   {
			 out.println("<td class='fields' width='30%'><input type='text' name='"+address1_fld_names[j]+"' id='"+address1_fld_names[j]+"' value=\""+ecis.utils.HTMLUtilities.getDisplayString(address_fld_values[j])+"\"	maxLength='30' size='30'  onBlur='searchCountry1(this,town)' onKeyPress='return CheckForSpecChars(event)'><input type='button' name='twnsearch' id='twnsearch' class='BUTTON'  id='twnsrch' value='?'   onClick=searchCountry(this,town) ></td>") ;  			
		   }else 	
	       if(address_col_names[j].equalsIgnoreCase("POSTAL_CODE_PROMPT"))
		   {
			 out.println("<td class='fields' width='30%'><input type='text' name='"+address1_fld_names[j]+"' id='"+address1_fld_names[j]+"' value='"+ecis.utils.HTMLUtilities.getDisplayString(address_fld_values[j])+"'	maxLength='8' size='8' onBlur='blurPostalSearch(this,town)'   onKeyPress='return CheckForSpecChars(event)'><input type='button' name='postal_search' id='postal_search' class='BUTTON'  id='pstsrh' value='?'   onClick='callPostalSearch("+address1_fld_names[j]+");' ></td>") ;  			
		   }
		   else
		   {
		      
			  
			 //Below line added for this CRF ML-MMOH-CRF-0860
			 /*String addressLength="30";
			 if(address1_fld_names[j].equalsIgnoreCase("addr_line_1") || address1_fld_names[j].equalsIgnoreCase("addr_line_2") || address1_fld_names[j].equalsIgnoreCase("addr_line_3") ) {
			       addressLength="100";
			 }*/    
            //End this CRF ML-MMOH-CRF-0860 
			
		//Below line added for this CRF ML-MMOH-CRF-0860.2
        if(increasedaddressLength){
			 if(address1_fld_names[j].equalsIgnoreCase("addr_line_1")){ %>
			 <td class='fields' width='30%'><textarea name='<%=address1_fld_names[j]%>' id='<%=address1_fld_names[j]%>' rows='3' maxlength='100' cols='50' onblur='makeValidString(this); maxLengthPaste1(this);' onkeypress='checkMaxLimit(this,100)'><%=address_fld_values[j]%></textarea></td>
			 <%}else if(address1_fld_names[j].equalsIgnoreCase("addr_line_2")){%>
			 <td class='fields' width='30%'><textarea name='<%=address1_fld_names[j]%>' id='<%=address1_fld_names[j]%>' rows='3' maxlength='100 ' cols='50' onblur='makeValidString(this); maxLengthPaste1(this);'  onkeypress='checkMaxLimit(this,100)'><%=address_fld_values[j]%></textarea></td>
			 <%}else if(address1_fld_names[j].equalsIgnoreCase("addr_line_3")){%>
			 <td class='fields' width='30%'><textarea name='<%=address1_fld_names[j]%>' id='<%=address1_fld_names[j]%>' rows='3' maxlength='100' cols='50' onblur='makeValidString(this); maxLengthPaste1(this);'  onkeypress='checkMaxLimit(this,100)'><%=address_fld_values[j]%></textarea></td>
			<% }else if(address1_fld_names[j].equalsIgnoreCase("addr_line_4")){
		out.println("<td class='fields' width='30%'><input type='text' name='"+address1_fld_names[j]+"' id='"+address1_fld_names[j]+"' value=\""+ecis.utils.HTMLUtilities.getDisplayString(address_fld_values[j])+"\" maxLength='30' size='32' onBlur='makeValidString(this)' > </td>");
			 }			 
		 }else{
			out.println("<td class='fields' width='30%'><input type='text' name='"+address1_fld_names[j]+"' id='"+address1_fld_names[j]+"' value=\""+ecis.utils.HTMLUtilities.getDisplayString(address_fld_values[j])+"\"		maxLength='30' size='32'  onBlur='makeValidString(this)' > </td>") ; 
		  }	
		  //End  ML-MMOH-CRF-0860.2	
					  
		}
						
	}
	k=j;
				
   }   
			
   
   out.println("</td></tr>");
    l++;
   }

        String sq3 = "select short_name from mp_country_lang_vw where language_id = '"+localeName+"' and country_code = '"+country_code+"'";

		pstmt2  = con.prepareStatement(sq3);
        vrs = pstmt2.executeQuery();
        
		
		while( vrs.next())
		{
			kcou=checkForNull(vrs.getString("short_name"));
		
	//	}     


}%>			       
      	 <tr>
		 <td class='label' width='20%'><fmt:message key="Common.country.label" bundle="${common_labels}"/></td>
         <td class='fields' ><input type='text' onBlur="searchCountry1(this,COUNTRY_DESC)" name='COUNTRY_DESC' id='COUNTRY_DESC' size='15' value="<%=kcou%>"  maxlength='15'  ><input type='button' name='cntrysrh'  value='?' id='cntrysrh' class='button' onclick="searchCountry(this,COUNTRY_DESC)" ></td>
          </tr>
          <tr>
              <td class='label'><fmt:message key="Common.homephoneno.label" bundle="${common_labels}"/></td>
              <td class='fields'><input type='text' name='TELEPHONE_RES' id='TELEPHONE_RES' maxlength='20' size='20'  onblur=''    value ="<%=telephone_res%>"></td>
		  </tr>
          <tr>
              <td class='label'><fmt:message key="eMO.MobilePhoneNo.label" bundle="${mo_labels}"/></td>
              <td class='fields'><input type='text' name='MOB_TEL_NO' id='MOB_TEL_NO' maxlength='20' size='20'  onblur='' value ="<%=mob_tel_no%>"></td>
		  <tr>
			  <td class='label'><fmt:message key="Common.officephoneno.label" bundle="${common_labels}"/></td>
              <td class='fields'><input type='text' name='TELEPHONE_OFF' id='TELEPHONE_OFF' maxlength='20' size='20'  onblur=''  value ="<%=telephone_off%>"></td>
          </tr>
		  <tr>
		      <td class='label'><fmt:message key="Common.email.label" bundle="${common_labels}"/></td>
              <td class='fields'><input type='text' name='EMAIL_ID' id='EMAIL_ID'  onBlur='document.getElementById("tab2").scrollIntoView();document.getElementById("CLAIMANT_TYPE").focus()'maxlength='50' size='30'     value = "<%=email_id%>">
			 </td>
          </tr>
		  </table>
		</td>
	</tr>
				<!--Added For Bru-HIMS-CRF-0368 By Dharma on 4th Dec 2013 Start-->
				
				<%
				
				if(external_rec_exists.equals("Y") && external_rec_count > 1){ 
					IsViewClaimantHistoryDisplay	= true;
				}else if(external_rec_exists.equals("Y") && external_rec_count==1 && !facilityId.equals(latest_claiment_fac_id)){
					IsViewClaimantHistoryDisplay	= true;
				}
				if(IsViewClaimantHistoryDisplay){
				%>
					<tr><td class='fields' colspan="2"><a  href="javascript:FnViewClaimantHistory();" ><fmt:message key="eMO.ViewClaimantHistory.label" bundle="${mo_labels}"/></a></td></tr>
				<%}%>
				<!--Added For Bru-HIMS-CRF-0368 By Dharma on 4th Dec 2013 End-->
 </table>
</div>
		<!--Added For [IN:046059] By Lenin on 02-Jan-2013 Start-->
<div id = 'ORGDONATION' style = 'display:none'>
<a name="tab2"></a>
	    <!--Added For [IN:046059] By Lenin on 02-Jan-2013 End-->
				<table cellspacing='0' cellpadding='0' width='100%' border='0' align='center'> 
					<tr>
						<td class='white' align='right'> 
							<INPUT TYPE="button" value='<fmt:message key="Common.Demographics.label" bundle="${common_labels}"/><fmt:message key="Common.details.label" bundle="${common_labels}"/>'  class='button' onClick="viewPatientDetails('<%=patient_id%>')"><INPUT TYPE="button" 
							value='<fmt:message key="Common.PreviousEncounters.label" bundle="${common_labels}"/>' onClick="showPrevEncounter('<%=patient_id%>');"class=button>
						</td>
					</tr>	
					<tr><td class='white'>&nbsp;</td></tr>
				</table>

				<ul id="tablist" class="tablist">
					<li class="tablistitem" title="RegnDtls">
						<a onclick="javascript:tab_enable('regn_dtls_tab')" id="regn_dtls_tab" class="tabA">
						<span class="tabAspan" id="regn_dtls_tabspan"><fmt:message key="eMO.RegistrationDtls.label" bundle="${mo_labels}"/></span>
						</a>
					</li>
					<li class="tablistitem" title="OrganDonation">
						<a onclick="javascript:tab_enable('organ_dtn_tab')" id="organ_dtn_tab" class="tabClicked">
						<span class="tabSpanclicked" id="organ_dtn_tabspan"><fmt:message key="eMO.OrganDonation.label" bundle="${mo_labels}"/></span><!--bundle change for PAS-MO-PMG2020-TECH-CRF-0010/02-Label Name-->
						</a>
					</li>	
					<!--Added by Ashwini on 17-Oct-2017 for ML-MMOH-CRF-0696-->
					<%if(rearrangeTabBurlPermtClaimnt){%>
					<li class="tablistitem" title="BurialPermit" id='dis3'>
						<a onclick="javascript:tab_enable('burial_prmt_tab')" id="burial_prmt_tab" class="tabA">
						<span class="tabAspan" id="burial_prmt_tabspan"><fmt:message key="eMO.BurialPermit.label" bundle="${mo_labels}"/></span><!--bundle change for PAS-MO-PMG2020-TECH-CRF-0010/02-Label Name-->
						</a>
					</li>
					<li class="tablistitem" title="Claimant" id="claimantDis3">
						<a onclick="javascript:tab_enable('claimant_tab')" id="claimant_tab" class="tabA">
						<span class="tabAspan" id="claimant_tabspan"><fmt:message key="eMO.Claimant.label" bundle="${mo_labels}"/></span><!--bundle change for PAS-MO-PMG2020-TECH-CRF-0010/02-Label Name-->
						</a>
					</li>	
					<%}else{%>
					<li class="tablistitem" title="Claimant">
						<a onclick="javascript:tab_enable('claimant_tab')" id="claimant_tab" class="tabA">
						<span class="tabAspan" id="claimant_tabspan"><fmt:message key="eMO.Claimant.label" bundle="${mo_labels}"/></span><!--bundle change for PAS-MO-PMG2020-TECH-CRF-0010/02-Label Name-->
						</a>
					</li>	
					<li class="tablistitem" title="BurialPermit" id='dis3'>
						<a onclick="javascript:tab_enable('burial_prmt_tab')" id="burial_prmt_tab" class="tabA">
						<span class="tabAspan" id="burial_prmt_tabspan"><fmt:message key="eMO.BurialPermit.label" bundle="${mo_labels}"/></span><!--bundle change for PAS-MO-PMG2020-TECH-CRF-0010/02-Label Name-->
						</a>
					</li>	
					<%}%>
				</ul>	



<table cellspacing='0' cellpadding='0' width='100%' border='0' align='center'>
	<tr>
		<td>
			<table cellspacing='0' cellpadding='0' width='100%' border='0' align='center'>
				<tr>
					<td class='COLUMNHEADER'><fmt:message key="eMO.TissueProcmntRegn.label" bundle="${mo_labels}"/></td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<table cellspacing='0' cellpadding='3' width='100%' border='0' align='center'>
				<tr>
						<td class='label' width='25%'><fmt:message key="eMO.DonorCardAvlbl.label" bundle="${mo_labels}"/></td>	
						<td class='fields' width='25%'>
						<%String disabledonor="";
							if(postmortem_startend_status.equals("E")||postmortem_startend_status.equals("S"))
								disabledonor="disabled";
						  if(donor_card_available_yn.equals("Y"))
						 {%>
						<INPUT TYPE="checkbox" onClick='enableService()'NAME="donor_card_available_yn" ID="donor_card_available_yn" value="Y" <%=disabledonor%> checked></td>	
						 <%}else{%>
						<INPUT TYPE="checkbox" onClick='enableService()'NAME="donor_card_available_yn" ID="donor_card_available_yn" <%=disabledonor%> > </td>	
						<%}%>							
						<td class='button' colspan='2' align='right'><INPUT TYPE="button" name="donar_card_info" id="donar_card_info" onClick='donarcardInfo()'class="button" value='<fmt:message key="eMO.DonorCardInfo.label" bundle="${mo_labels}"/>'><INPUT TYPE="button" name="Concent1" id="Concent1" value='<fmt:message key="Common.Consent.label" bundle="${common_labels}"/>'  onclick="getConsentFormforDonar()" class="button"></td>	
					</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<table cellspacing='0' cellpadding='0' width='100%' border='0' align='center'>
				<tr>
					<td class='COLUMNHEADER'><fmt:message key="eMO.ListoforganforDonation.label" bundle="${mo_labels}"/></td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<table cellspacing='0' cellpadding='3' width='100%' border='0' align='center'>
				<%	int i=0;
					String viewdisdata="";
					//pstmt = con.prepareStatement("select a.ORGAN_CODE, a.SHORT_DESC,case when b.ORGAN_CODE=a.ORGAN_CODE then 'Y' else 'N' end checkedyn  from MO_ORGAN_FOR_DONATION_LANG_VW a,mo_organ_donation_regn b  where a.ORGAN_CODE=b.ORGAN_CODE(+) and a.eff_status='E' and b.facility_id(+)='"+facilityId+"' and language_id = '"+localeName+"' and b.registration_no(+)='"+ regn_no+"' order by 2  ");
					//facility_id removed for Bru-HIMS-CRF-0368 By Dharma on 11th Dec 2013 
					pstmt = con.prepareStatement("select a.ORGAN_CODE, a.SHORT_DESC,case when b.ORGAN_CODE=a.ORGAN_CODE then 'Y' else 'N' end checkedyn  from MO_ORGAN_FOR_DONATION_LANG_VW a,mo_organ_donation_regn b  where a.ORGAN_CODE=b.ORGAN_CODE(+) and a.eff_status='E' and language_id = '"+localeName+"' and b.registration_no(+)='"+ regn_no+"' order by 2  ");
					vrs=pstmt.executeQuery();

					if(mode.equals("viewdata")||postmortem_startend_status.equals("E")||postmortem_startend_status.equals("S"))
					 viewdisdata="disabled";
					while(vrs.next())
					{ %>	
					  
					<tr>
					<td class='label' width='25%'><%=vrs.getString("SHORT_DESC")%></td>
					<td class='fields' width='25%'>
					<%if(vrs.getString("checkedyn").equals("Y")){%>
					<INPUT TYPE="checkbox"   <%=viewdisdata%> NAME="org<%=i%>"   checked value='<%=vrs.getString("ORGAN_CODE")%>'> 
					<%}else{%>
					<INPUT TYPE="checkbox" <%=viewdisdata%> NAME="org<%=i%>"   value='<%=vrs.getString("ORGAN_CODE")%>'><%} %> 
					</td>
					<td colspan='2'>&nbsp;</td>
					</tr>

					<%i++;}%>
			</table>
		</td>
	</tr>
</table>
	
</div>
<!--Added by Thamizh selvi on 25th July 2017 for ML-MMOH-CRF-0689 Start-->
<input type='hidden' name='calledFrom' id='calledFrom' value = '<%=calledFrom%>'>
<input type='hidden' name='externalBidYn' id='externalBidYn' value = '<%=externalBidYn%>'>
<input type='hidden' name='pol_officer_name' id='pol_officer_name' value = '<%=pol_officer_name%>'>
<input type='hidden' name='extBidYnFrmVw' id='extBidYnFrmVw' value = '<%=extBidYnFrmVw%>'>
<input type='hidden' name='pol_contact_no' id='pol_contact_no' value = '<%=pol_contact_no%>'>
<!--End-->
<input type='hidden' name='mode' id='mode' value = '<%=mode%>'>
<input type='hidden' name='facilityId' id='facilityId' value="<%=facilityId%>">
<input type='hidden' name='dec_fac_id' id='dec_fac_id' value="<%=dec_fac_id%>">
<input type='hidden' name='dec_enc_id' id='dec_enc_id' value="<%=dec_enc_id%>">
<input type='hidden' name='external' id='external' value="<%=external%>">
<input type='hidden' name='regno' id='regno' value='<%=regno%>'>
<input type='hidden' name='patient_class' id='patient_class' value='<%=patient_class%>'>
<input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>'>

<input type='hidden' name='pol_rep_no' id='pol_rep_no' value='<%=pol_rep_no%>'>
<input type='hidden' name='pol_stn_id' id='pol_stn_id' value='<%=pol_stn_id%>'>
<input type='hidden' name='pol_id' id='pol_id' value='<%=pol_id%>'>


<input type='hidden' name='police_approval_received_yn' id='police_approval_received_yn' value='<%=police_approval_received_yn%>'>
<input type='hidden' name='police_received_by' id='police_received_by' value='<%=police_received_by%>'>
<input type='hidden' name='police_received_date' id='police_received_date' value='<%=police_received_date%>'>
	


<!-- <input type='hidden' name='bodypart' id='bodypart' value=""> -->		 
<input type='hidden' name='consent_form_code' id='consent_form_code' value='<%=consent_form_code%>'>
<input type='hidden' name='consent_desc' id='consent_desc' value=''>


<input type='hidden' name='enable_rfid_yn' id='enable_rfid_yn' value='<%=enable_rfid_yn%>'> <!-- added by mujafar for ML-MMOH-CRF-0996 -->

<input type='hidden' name='area1' id='area1' value='<%=res_area_code%>'>
<input type='hidden' name='town1' id='town1' value='<%=res_town_code%>'>
<input type='hidden' name='region1' id='region1' value='<%=region_code%>'>

<input type='hidden' name='conscentgivenby' id='conscentgivenby' value='<%=consent_given_by%>'>
<input type='hidden' name='deceasedrelationship' id='deceasedrelationship' value='<%=relationship_with_deceased%>'>		 
<input type='hidden' name='consent_received_by' id='consent_received_by' value='<%=consent_form_received_by%>'>
<input type='hidden' name='consent_received_date' id='consent_received_date' value="<%=consent_form_received_date%>">
<input type='hidden' name='system_date' id='system_date' value="<%=sys_date%>">
<input type='hidden' name='system_date_cnv' id='system_date_cnv' value="<%=sys_date_cnv%>">
             <!-- donar details -->

<input type='hidden' name='donar_card_no' id='donar_card_no' value="<%=donar_card_no%>">
<input type='hidden' name='donardetails' id='donardetails' value="<%=donar_card_details%>">
<input type='hidden' name='organcnt' id='organcnt' value="<%=i%>">
<input type='hidden' name='maxrecord_count' id='maxrecord_count' value="<%=maxrecord%>">
<input type='hidden' name='donatedorgan' id='donatedorgan' value="">
<!-- //consent for donar -->






<input type='hidden' name='consent_form_code1' id='consent_form_code1' value="<%=consent_form_code1%>">
<input type='hidden' name='consent_desc1' id='consent_desc1' value=''>		 
<!-- <input type='hidden' name='RELATIONSHIP' id='RELATIONSHIP' value='<%=relationship%>'> -->
	
<input type='hidden' name='conscentgivenby1' id='conscentgivenby1' value="<%=conscentgivenby1%>">
<input type='hidden' name='deceasedrelationship1' id='deceasedrelationship1' value="<%=deceasedrelationship1%>">
<input type='hidden' name='consent_received_by1' id='consent_received_by1' value="<%=consent_received_by1%>">
<input type='hidden' name='consent_received_date1' id='consent_received_date1' value="<%=consent_received_date1%>">
<input type='hidden' name='ZIP_CODE' id='ZIP_CODE' value="<%=zip_code%>">
<input type='hidden' name='COUNTRY_CODE' id='COUNTRY_CODE' value="<%=country_code%>">
<input type='hidden' name='regn_no' id='regn_no' value="<%=regn_no%>">
<input type='hidden' name='consent_received_desc2' id='consent_received_desc2' value="<%=consent_form_recd_by_name2%>">
<input type='hidden' name='consent_received_desc' id='consent_received_desc' value="<%=consent_form_recd_by_name%>">
<input type='hidden' name='area_codedum' id='area_codedum' value="<%=area_code%>">
<input type='hidden' name='burial_permit_appr_by_name1' id='burial_permit_appr_by_name1' value="<%=burial_permit_appr_by_name%>"> <!-- IN018776 Tuesday, February 09, 2010 Venkat S -->

<input type='hidden' name='startendstat' id='startendstat' value="<%=postmortem_startend_status%>">
	<input type='hidden' name='brought_dead_yn' id='brought_dead_yn' value="<%=brought_dead_yn%>">
	
	<input type='hidden' name='areatype' id='areatype' value="<%=area_type%>">
<input type='hidden' name='encounter_id' id='encounter_id' value="<%=encounter_id%>">
<input type='hidden' name='police_approval_received_by_desc' id='police_approval_received_by_desc' value="<%=police_approval_received_by_desc%>">
<input type='hidden' name='burial_permit_reqd_yn' id='burial_permit_reqd_yn' value="<%=burial_permit_reqd_yn%>">

<!-- Added For Bru-HIMS-CRF-0368 By Dharma on 3rd Dec 2013 Start-->
<input type='hidden' name='external_rec_exists' id='external_rec_exists' value='<%=external_rec_exists%>' >
<input type='hidden' name='default_claimant_type' id='default_claimant_type' value='<%=default_claimant_type%>' >
<input type='hidden' name='default_claimant_type_code' id='default_claimant_type_code' value='<%=default_claimant_type_code%>' >
<input type='hidden' name='default_relationship' id='default_relationship' value='<%=default_relationship%>' >
<input type='hidden' name='default_name' id='default_name' value='<%=default_name%>' >
<input type='hidden' name='default_job_title' id='default_job_title' value='<%=default_job_title%>' >
<input type='hidden' name='default_addrl1' id='default_addrl1' value='<%=default_addrl1%>' >
<input type='hidden' name='default_addrl2' id='default_addrl2' value='<%=default_addrl2%>' >
<input type='hidden' name='default_addrl3' id='default_addrl3' value='<%=default_addrl3%>' >
<input type='hidden' name='default_addrl4' id='default_addrl4' value='<%=default_addrl4%>' >
<input type='hidden' name='default_postal_code' id='default_postal_code' value='<%=default_postal_code%>' >
<input type='hidden' name='default_country_code' id='default_country_code' value='<%=default_country_code%>' >
<input type='hidden' name='default_zip_code' id='default_zip_code' value='<%=default_zip_code%>' >
<input type='hidden' name='default_res_town_code' id='default_res_town_code' value='<%=default_res_town_code%>' >
<input type='hidden' name='default_res_area_code' id='default_res_area_code' value='<%=default_res_area_code%>' >
<input type='hidden' name='default_region_code' id='default_region_code' value='<%=default_region_code%>' >
<input type='hidden' name='default_res_town_desc' id='default_res_town_desc' value='<%=default_res_town_desc%>' >
<input type='hidden' name='default_res_area_desc' id='default_res_area_desc' value='<%=default_res_area_desc%>' >
<input type='hidden' name='default_region_desc' id='default_region_desc' value='<%=default_region_desc%>' >
<input type='hidden' name='default_telephone_off' id='default_telephone_off' value='<%=default_telephone_off%>' >
<input type='hidden' name='default_telephone_res' id='default_telephone_res' value='<%=default_telephone_res%>' >
<input type='hidden' name='default_email_id' id='default_email_id' value='<%=default_email_id%>' >
<input type='hidden' name='default_mob_tel_no' id='default_mob_tel_no' value='<%=default_mob_tel_no%>' >
<input type='hidden' name='default_nat_id_no' id='default_nat_id_no' value='<%=default_nat_id_no%>' >
<input type='hidden' name='default_organization_name' id='default_organization_name' value='<%=default_organization_name%>' >
<input type='hidden' name='default_patient_employee_id' id='default_patient_employee_id' value='<%=default_patient_employee_id%>' >

<!--Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743-->
<input type='hidden' name='default_Passport_No' id='default_Passport_No' value='<%=default_Passport_No%>' >
<input type='hidden' name='default_Other_Identification' id='default_Other_Identification' value='<%=default_Other_Identification%>' >

<input type='hidden' name='default_RELEASE_TO_FACILITY' id='default_RELEASE_TO_FACILITY' value='<%=default_RELEASE_TO_FACILITY%>' >
<input type='hidden' name='default_reason_deceased_desc' id='default_reason_deceased_desc' value='<%=default_reason_deceased_desc%>' >
<input type='hidden' name='default_country_desc' id='default_country_desc' value='<%=default_country_desc%>' >
<input type='hidden' name='isRemoveMandBPermitAppBy' id='isRemoveMandBPermitAppBy' value='<%=isRemoveMandBPermitAppBy%>' >

<!-- Added For Bru-HIMS-CRF-0368 By Dharma on 3rd Dec 2013 End-->

<!--Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743-->
<input type='hidden' name='isClaimantChngsApplicable' id='isClaimantChngsApplicable' value ='<%=isClaimantChngsApplicable%>'>

<!--Below line added for this CRF ML-MMOH-CRF-0695-->
<input type='hidden' name='datetimeofclaimingApplicable' id='datetimeofclaimingApplicable' value ='<%=datetimeofclaimingApplicable%>'> 
<!--End this CRF ML-MMOH-CRF-0695 -->

<!--Added by Ashwini on 17-Oct-2017 for ML-MMOH-CRF-0696-->
<input type='hidden' name='rearrangeTabBurlPermtClaimnt' id='rearrangeTabBurlPermtClaimnt' value ='<%=rearrangeTabBurlPermtClaimnt%>'> 
<!--Added by Shanmukh on 25th-JUNE-2018 for ML-MMOH-CRF-1031-->	
<input type='hidden' name='isChangeOfDateTimeClaimingAppl' id='isChangeOfDateTimeClaimingAppl' value ='<%=isChangeOfDateTimeClaimingAppl%>'>
<input type='hidden' name='isReceivedDateTimeAppl' id='isReceivedDateTimeAppl' value ='<%=isReceivedDateTimeAppl%>'>
<input type='hidden' name='isDateTimeOfDeathAppl' id='isDateTimeOfDeathAppl' value ='<%=isDateTimeOfDeathAppl%>'>  

<!--Added by Ashwini on 11-Oct-2018 for ML-MMOH-CRF-1095-->
<input type='hidden' name='function_id' id='function_id' value ='<%=function_id%>'> 
<input type='hidden' name='claimant_type_mstr' id='claimant_type_mstr' value='<%=claimant_type%>'>

<!--Added by Santhosh for ML-MMOH-CRF-1948-->
<input type='hidden' name='datetime_claim_mand' id='datetime_claim_mand' value='<%=datetime_claim_mand%>'>
<input type='hidden' name='datetimeOfClaimingAppl' id='datetimeOfClaimingAppl' value='<%=datetimeOfClaimingAppl%>'>
<!--END-->

<%
   if(vpstmt!=null) vpstmt.close();
   if(sstat!=null) sstat.close();
   if(pstmt2!=null)  pstmt2.close();
   if(vrs!=null) vrs.close(); 
 }else
  {
		    out.println("<script>alert(getMessage('REGN_NOT_ALLOWED','MO'));</script>");
			out.println("<script>parent.frames[0].document.forms[0].patient_id.value='';parent.frames[0].document.forms[0].patient_id.disabled=false;parent.frames[0].document.forms[0].patient_search.disabled=false;</script>");
            out.println("<script>parent.dummyframe.document.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=' ;</script>");
 }
		  
		  
		  
		  
		
		  
	}catch(Exception e)
    {
       e.printStackTrace();

    }
    finally
    {
       
		
		 ConnectionManager.returnConnection(con,request);
    }
%>
 </form>
 <script>
 //enableservices();
 //Below IF clause modified by Shanmukh on 27th-JUNE-2018 for ML-ML-MMOH-CRF-1031
if(document.forms[0].burial_permit_reqd_yn.value=="N" && document.forms[0].body_burial_permit_no.value==""){// Suresh M
	if(document.forms[0].isChangeOfDateTimeClaimingAppl.value=="false"){
		document.forms[0].body_claiming_date_time.value = "";
		document.forms[0].body_claiming_date_time.disabled=false;
	}
	document.forms[0].burial_permit_appr_by_name1.value = "";
	document.forms[0].burial_app_date.value = "";
	document.forms[0].burial_permit_app_by.value = "";
	document.forms[0].burial_permit_app_desc.value = "";
	//Added for the incident - 46080 - start
	document.forms[0].burial_app_date.disabled=false;
	//Added for the incident - 46080 - end
} // Suresh M Ends
 </script>
 </body>
</html>

<%!
public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
}
%>
<script>
	
/* Below line was added this CRF Bru-HIMS-CRF-366 [IN:039612]  */

 function maxLength(field,maxChars)
 {
       //if(field.value.length >= maxChars) {
	   if(field.value.length > maxChars) {
	      alert(getMessage("EXCEED_MAX_LENGTH", "Sm",null));
           // event.returnValue=false;	
              field.select();
              field.focus();		  
          return false;
       }
	   else{
	     return true;
	   }
 }  

 function maxLengthPaste(field,maxChars)
 {
       event.returnValue=false;
       if((field.value.length +  window.clipboardData.getData("Text").length) > maxChars) {	 
	     var errors1 = getMessage('REASON_EXCEED_MAX_LEN','MO');
		   alert(errors1);         	  
         return false;
       }
       event.returnValue=true;
 }
	/*Bru-HIMS-CRF-366 [IN:039612] */
	function FnDefaultPreviousClaimantDetails(){
		document.forms[0].CLAIMANT_TYPE.value = document.forms[0].default_claimant_type.value ;
		if(document.forms[0].default_claimant_type.value!=""){
			getClaimant1(document.forms[0].default_claimant_type.value,document.forms[0].default_claimant_type_code.value);
			if(document.forms[0].addr_line_1!=null){
				document.forms[0].addr_line_1.value	= document.forms[0].default_addrl1.value; 
			}
			if(document.forms[0].addr_line_2!=null){
				document.forms[0].addr_line_2.value	= document.forms[0].default_addrl2.value; 
			}
			if(document.forms[0].addr_line_3!=null){
				document.forms[0].addr_line_3.value	= document.forms[0].default_addrl3.value; 
			}
			if(document.forms[0].addr_line_4!=null){
				document.forms[0].addr_line_4.value	= document.forms[0].default_addrl4.value; 
			}
			if(document.forms[0].town!=null){
				document.forms[0].town.value	= document.forms[0].default_res_town_desc.value; 
				document.forms[0].town1.value	= document.forms[0].default_res_town_code.value;
			}
			if(document.forms[0].area!=null){
				document.forms[0].area.value	= document.forms[0].default_res_area_desc.value; 
				document.forms[0].area1.value	= document.forms[0].default_res_area_code.value;
			}
			if(document.forms[0].region!=null){
				document.forms[0].region.value	= document.forms[0].default_region_desc.value; 
				document.forms[0].region1.value	= document.forms[0].default_region_code.value;
			}
			
			if(document.forms[0].postal_code!=null){
				document.forms[0].postal_code.value	= document.forms[0].default_postal_code.value; 
			}
			
			
			document.forms[0].COUNTRY_DESC.value	= document.forms[0].default_country_desc.value;
			document.forms[0].COUNTRY_CODE.value	= document.forms[0].default_country_code.value;
			document.forms[0].TELEPHONE_RES.value	= document.forms[0].default_telephone_res.value;
			document.forms[0].TELEPHONE_OFF.value   = document.forms[0].default_telephone_off.value;
			document.forms[0].MOB_TEL_NO.value	= document.forms[0].default_mob_tel_no.value;
			document.forms[0].EMAIL_ID.value	= document.forms[0].default_email_id.value;
			
			if(document.forms[0].default_relationship.value!="")
				document.forms[0].RELATIONSHIP.value	= document.forms[0].default_relationship.value;
			document.forms[0].NAME.value	= document.forms[0].default_name.value;
			document.forms[0].NAT_ID_NO.value	= document.forms[0].default_nat_id_no.value;
			document.forms[0].PATIENT_EMPLOYEE_ID.value	= document.forms[0].default_patient_employee_id.value;
			
			//Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743
			document.forms[0].PASSPORT_NO.value	= document.forms[0].default_Passport_No.value;
			document.forms[0].OTHER_IDENTIFICATION.value = document.forms[0].default_Other_Identification.value;

			document.forms[0].JOB_TITLE.value	= document.forms[0].default_job_title.value;
			document.forms[0].ORGANIZATION_NAME.value	= document.forms[0].default_organization_name.value;
		
			if(document.forms[0].default_claimant_type.value=='F'){
				document.getElementById("releasefacid").style.visibility='visible';	
				document.getElementById("releasefacdesc").style.visibility='visible';	
				document.getElementById("remarksid").style.visibility='visible';		
				document.getElementById("remarksdesc").style.visibility='visible';
				if(document.forms[0].default_RELEASE_TO_FACILITY.value!="")
				document.forms[0].RELEASE_TO_FACILITY.value	= document.forms[0].default_RELEASE_TO_FACILITY.value;
				
				document.forms[0].reason_desc.value	= document.forms[0].default_reason_deceased_desc.value;
			}
		}
		EnableFields();
	}
	
	function FnViewClaimantHistory(){
		var regn_no		= document.forms[0].regn_no.value;
		var patient_id	= document.forms[0].patient_id.value;
		var encounter_id	=  document.forms[0].encounter_id.value;
		var title = getLabel("eMO.ViewClaimantHistory.label","MO");
		var dialogHeight= "40" ;
		var dialogWidth	= "75" ;
		var dialogTop= "50";
		var dialogLeft= "50";
		var prev="prev";
		var display="display";
		var features= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
		window.showModalDialog('../../eMO/jsp/ViewClaimantHistoryFrames.jsp?title='+title+'&patient_id='+patient_id+'&display='+display+"&EncounterId="+encounter_id,arguments,features);
		
	}
	function EnableFields(){
		
		if(document.forms[0].mode.value=='modify' && document.forms[0].CLAIMANT_TYPE.value!="")	{
			document.forms[0].NAT_ID_NO.disabled=false;
			document.forms[0].JOB_TITLE.disabled=false;
			document.forms[0].MOB_TEL_NO.disabled=false;
		}
	}
//ML-MMOH-CRF-0860.2
function maxLengthPaste1(obj)
 { 
	var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
	if (obj.getAttribute && obj.value.length>mlength)
	{
    	var errors1 = getMessage("EXCEED_MAX_LENGTH", "Sm",null);
        alert(errors1);	
		obj.value=obj.value.substring(0,mlength);
	}
 }
//End ML-MMOH-CRF-0860.2
function disDeathDate1(obj)
{ 
	var isDateTimeOfDeathAppl=document.forms[0].isDateTimeOfDeathAppl.value;
	if(isDateTimeOfDeathAppl=="true"){
		 document.forms[0].disDeathDate.value=obj.value;
	}
}
	</script>

