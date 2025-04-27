<!DOCTYPE html>

<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,org.json.simple.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ include file="../../eMP/jsp/PatientAddressLegends.jsp" %>
<html>
<head>

	<%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 request.setCharacterEncoding("UTF-8");

%>
    <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
    <link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<Script language="JavaScript" src="../../eCommon/js/CommonCalendar.js" ></Script>
	<script language='javascript' src='../../eCommon/js/dchk.js'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
	<script language='javascript' src='../../eMO/js/MORegisterBodyPart.js'></script>
	<script language='javascript' src='../../eCommon/js/CommonLookup.js' > </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<style>
textarea {
  resize: none;
}
</style>
	<script>
      function tab_click(objName)
		{
			if(objName=="RegDtl_tab")
			{
				//document.getElementById("tab1").scrollIntoView();
				document.getElementById('tab1').scrollIntoView({
					  block: "nearest"
					});
			}
			if(objName=="claimant_tab")
			{
				//document.getElementById("tab2").scrollIntoView();
				document.getElementById('tab2').scrollIntoView({
					  
					  block: "nearest"
					});

			}
			if(objName=="burialPermit_tab")
			{
				if((document.getElementById('postmortem_reqd_yn').checked==true)&&(document.getElementById("startendstat").value!="E"))
				return;	
				//document.getElementById("tab3").scrollIntoView();
				document.getElementById('tab3').scrollIntoView({
					
					  block: "nearest"
					});
			}
		}

		function tab_click1(id) 
		{
			selectTab(id);
			tab_click(id);
		}
	</script>
 </head>
  <%  
        Connection con							= null;
    	PreparedStatement pstmt2				= null;
       	ResultSet vrs							= null;
		java.sql.Statement vpstmt				= null;
        //PreparedStatement pstmt                 =null; 
		java.sql.Statement sstat                = null;
		//Object relationcode[]                   = null;
        //Object relationdesc[]                   = null;
		String disabledyn="";
		String remarks="";
		String checkmlc="";
        String checkpm="";
		//String Accept_oth_alt_id_yn             = "";
    	String locale		                    = (String)session.getAttribute("LOCALE");
    	String release_fac_id="";  // Added Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg
		String release_fac_desc="";		// Added Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg
		String RELEASE_TO_FACILITY="";// Added Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg
	   	String releasefacility = "visibility:hidden"; // Added Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg
		String reason_deceased_desc=""; //this line added for this CRF Bru-HIMS-CRF-366 [IN-039612]
		
		String mode                             = request.getParameter("mode")==null?"insert":request.getParameter("mode");
        
        if(mode.equals("modify")||mode.equals("viewdata"))disabledyn="disabled" ; 
	  
	  try
	  {
		String facilityId				        = checkForNull((String)session.getValue("facility_id"));
		java.util.Properties propertiesBill     = (java.util.Properties) session.getValue( "jdbc" ) ;
		String patient_id						= checkForNull(request.getParameter("patient_id"));
		//String deceased							= checkForNull(request.getParameter("deceased"));
        String patient_id_length="";

		String accept_national_id_no_yn="";
        String nat_id_length="";
        String nat_id_prompt="";
		String res_town_desc="";
        String res_area_desc="";
        String region_desc="";
   		String kcou="";        
		String patientid =checkForNull(request.getParameter("patientid"));
		String burial_permit_reqd_yn ="";//changes for 38265
        String obt_from=checkForNull(request.getParameter("obt_from"));
		
		String addrl1                      = "";
	    String addrl2                      = "";
	    String addrl3                      = "";
	    String addrl4                      = "";
	    String postal_code                      = "";
		String area_type="";
	//	String	facility_id="";        
		String	registration_no= checkForNull(request.getParameter("registration_no"));  
		String police_approval_received_by_desc="";
		String	claimant_type="";      
		String	claimant_type_code=""; 
		String	relationship="";       
		String	name="";               
		String	job_title="";          
		//String	add_line1="";          
		//String	add_line2="";          
		//String	add_line3="";          
		//String	add_line4="";     
		//String  blurData="";
		String disunclim="";
		String	zip_code="";           
		String	country_code="";       
		String	res_town_code="";      
		String	res_area_code="";      
		String	region_code="";        
		String	telephone_off="";   
		String  referral_type="";
		String body_part_obtained_from="";
		String body_claiming_date_time="";
		String	telephone_res="";      
		String	email_id="";           
		String vechile_no="";
		String	mob_tel_no="";         
		String	nat_id_no="";          
		String	organization_name="";  
		String	patient_employee_id=""; 

		String	Passport_No=""; //Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743
		String	Other_Identification=""; //Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743

       // String CLAIMANT_TYPE =""; 
		String postmortem_startend_status ="";
		String 	ref_source_code             = "";                                        
		String	referred_by                 = "";
	//	String relationship1                ="";
		String	death_manner_code           ="";
		String	body_cond_code              ="";
		String	high_risk_body_yn           =""; 
		String	unclaimed_body_yn           ="";
	//	String	death_certificate_reqd_yn   =""; 
		String	brought_by_police_yn        =""; 
		String	service_code                ="";  
		String  ocpn_class_desc             ="";
		String	area_code                   ="";
		String	bed_no                      =""; 
		String 	rfid_tag_num                      =""; 
		String	assign_date_time            ="";
        String  identification_marks        ="";
        String  place_of_death               ="";  
        String  postmortem_type              ="";
		String  postmortem_status           ="";
		String  police_details              ="";
		String  police_approval_received_yn ="";
	//	String postm_req_yn="";
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
    //    String  donar_card_no               ="";
      //  String  donar_card_details          ="";
       // String  consent_form_code2          ="";
        //String  consent_form_recieved_by2   ="";
        //String  consent_form_recieved_date2  ="";
        String  body_received_date          =""; 

		//String  fton_nat_id_no               ="";	
		//int tindex = 0;
		//String death_status_remarks="";
		//String brought_dead_yn = "Y";
		/*String  bodyregn[]=new String[9];
		 bodyregn[0]="";
		 bodyregn[1]="";
		 bodyregn[2]="";
		 bodyregn[3]="";
		 bodyregn[4]="";
		 bodyregn[5]="";
		 bodyregn[6]="";
		 bodyregn[7]="";
		 bodyregn[8]="";*/
	//	String nat_id_prompt		    = "";
	//	String accept_oth_alt_id_yn     = "";
		String deceased_date			= "";
	//	String body_release_date_time   = "";
	//	String nKin_Addr_val			= "";
	//	String Addr_val					= "";
	//	String patient_name				= "";
	//	String nationality_desc			= "";
	//	String sex						= "";
	//	String ethnic_grp_desc			= "";
	//	String race_desc				= "";
	//	String age						= "";
	//	String national_id_no			= "";
		String encounter_id			    = "";
	//	String visit_adm_date_time      = "";
	//	String patient_class = "";
	//	String location = "";
	//	String specialty_desc = "";
	//	String attend_pract_name = "";
		//String disch_pract_name = "";
		String sys_date					=  "";
    	String mlc_yn = "N";

		String regno = "";
	//	String related_Addr_val = "";
	//	String alt_id1_desc = "";
	//	String alt_id1_no = "";
	//	String alt_id2_desc = "";
	//	String alt_id2_no = "";
	//	String alt_id3_desc = "";
	//	String alt_id3_no = "";
	//	String alt_id4_desc = "";
	//	String alt_id4_no = "";
		String pol_rep_no = "";
		String pol_stn_id = "";
		String pol_id = "";
	//	String regn_allowed_in_mo_yn="";
		String regn_no="";
	//	String prevencdis="";
		String burial_permit_appr_by_name="";
		String consent_form_recd_by_name2="";
		String consent_form_recd_by_name="";
	//	int flag1=0;
	//	int flag2=0;

		String burial_perm_no="";
		String burial_perm_by="";
	//	String burial_perm_name="";
		String burial_perm_date="";
		String readText="";
	 	String disablebut="";
		String hcare_type_code="";
		String zip_code_desc="";
    	/*Below line added for this CRF ML-MMOH-CRF-0695*/
		String function_id = request.getParameter("function_id1")==null?"":request.getParameter("function_id1");
		//End this CRF ML-MMOH-CRF-0695
		
		/*Added by Thamizh selvi on 3rd Aug 2017 for ML-MMOH-CRF-0689 Start*/
		String calledFrom			= "";
		Integer count				= 0;
		String 	pol_officer_name	= ""; 
		String 	pol_contact_no		= ""; 
		String	externalBodyPartYn	= "";
		String  policeDtlsMandYn    = "";
		/*End*/
		String enable_rfid_yn = ""; // added by mujafar for ML-MMOH-CRF-0996
		String[] contact_col_names	    = null ;
		String[] contact_prompts	    = null ;
		String[] contact_fields		    = null ;
		String burial_permit_approved_date=""; //Added by Kamatchi S on 12/17/2019 for ML-MMOH-SCF-1423
		int tabIndex		            = 1;
		
        String bodypartqry="select BODY_PART_CODE,SHORT_DESC from mo_body_part_lang_vw where LANGUAGE_ID='"+locale+"' and body_part_code  not in( Select body_part_code from mo_body_part_regn where registration_no=? and facility_id=?) and eff_status='E'  order by 2";

		con = ConnectionManager.getConnection(request);
		/*Below line(s) added by venkateshs against ML-MMOH-CRF-0354 [IN057191] */
		Boolean siteSpecific = eCommon.Common.CommonBean.isSiteSpecific(con, "MR","MLC_TO_MEDICO_LEGAL_CASE");
		/*end ML-MMOH-CRF-0354 [IN057191] */
		
		/* Below line added by mano against CRF-0737 */
		boolean mlcAndInfectiousDeceBodyApplicable =  eCommon.Common.CommonBean.isSiteSpecific(con, "MO","CHANGE_MLC_AND_INFEC_DECS_BODY");

		Boolean isRemoveMandBPermitAppBy = eCommon.Common.CommonBean.isSiteSpecific(con, "MO","BURIAL_PERMIT_MANDATORY");//Added by Dharma on 2oth July against ML-MMOH-CRF-0692 [IN:062311]

		Boolean isClaimantChngsApplicable = eCommon.Common.CommonBean.isSiteSpecific(con, "MO","CLAIMANT_MNDT_FLD_RENAME"); //Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743

		Boolean refTypeBrghtByPoliceDisable = eCommon.Common.CommonBean.isSiteSpecific(con, "MO","REF_TYPE_BRGHT_BY_POLICE_DISBL"); //Added by Ashwini on 08-Aug-2017 for ML-MMOH-CRF-0748
		
	  //Below line added for this CRF ML-MMOH-CRF-0695
	   boolean datetimeofclaimingApplicable =  eCommon.Common.CommonBean.isSiteSpecific(con, "MO","DATE_TIME_OF_CLAIMING");
	   String datetimeofclaiming="";      
	  //End this CRF ML-MMOH-CRF-0695

		Boolean rearrangeTabBurlPermtClaimnt = eCommon.Common.CommonBean.isSiteSpecific(con, "MO","MO_REARRANGE_TABS"); //Added by Ashwini on 17-Oct-2017 for ML-MMOH-CRF-0696
		
		Boolean isChangeOfDateTimeClaimingAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MO","DATE_TIME_CLAIMING_CHANGE");//Added by Shanmukh on 26th-JUNE-2018 for ML-MMOH-CRF-1031
		Boolean isReceivedDateTimeAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MO","RECEIVED_DATE_TIME");// Added by Shanmukh on 26th-JUNE-2018 for ML-MMOH-CRF-1036

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
		
		/*Added by Thamizh selvi on 3rd Aug 2017 for ML-MMOH-CRF-0689 Start*/
		JSONObject json = new JSONObject();
		json			= eMO.MOCommonBean.chkForExtBidBodyPartPatient(con, patientid, facilityId);
		count			= (Integer)json.get("bodyPartCount");
		if(count == 1)
			calledFrom	= "MO_EBP_REGN";
		
		json			 = eMO.MOCommonBean.getMOParam(con, facilityId); 
		policeDtlsMandYn = (String)json.get("policeDtlsMandYn");
		/*End*/
		enable_rfid_yn = (String)json.get("enable_rfid_yn"); // added by mujafar for ML-MMOH-CRF-0996

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
   pstmt2  = con.prepareStatement("select ALT_ID1_TYPE,NAT_ID_PROMPT,ACCEPT_OTH_ALT_ID_YN ,ACCEPT_NATIONAL_ID_NO_YN,NAT_ID_LENGTH,(select burial_permit_reqd_yn from mo_parameter where facility_id='"+facilityId+"')burial_permit_reqd_yn from MP_PARAM");//changes for 38265
	vrs = pstmt2.executeQuery();
  if(vrs.next())
	{
	nat_id_prompt           =vrs.getString("nat_id_prompt")==null?"":vrs.getString("nat_id_prompt");
	nat_id_length    =vrs.getString("NAT_ID_LENGTH")==null?"":vrs.getString("NAT_ID_LENGTH");
	accept_national_id_no_yn =vrs.getString("ACCEPT_OTH_ALT_ID_YN")==null?"":vrs.getString("ACCEPT_OTH_ALT_ID_YN");
	burial_permit_reqd_yn =vrs.getString("burial_permit_reqd_yn")==null?"":vrs.getString("burial_permit_reqd_yn");//changes for 38265
	}
     if (vrs!=null) vrs.close();
	 if(pstmt2!=null) pstmt2.close();
		/*if(!(mode.equals("modify")||mode.equals("viewdata")))
		{
		  pstmt2 = con.prepareStatement("SELECT mo_get_next_regn_num('"+facilityId+"') next_regn_num FROM MO_REGN_NUM_CONTROL 	WHERE FACILITY_ID='"+facilityId+"'");
	      vrs = pstmt2.executeQuery();
		  if(vrs!=null)
			{
		      while(vrs.next())
				{
				  regno = vrs.getString(1);
				}
			}
		if(vrs!=null) vrs.close();
		     if(pstmt2!=null) pstmt2.close();
		}*/
	
	
             
			   
				    String patLength = "select PATIENT_ID_LENGTH, to_char(sysdate,'dd/mm/yyyy') from MP_PARAM";
					pstmt2   = con.prepareStatement(patLength);
					vrs = pstmt2.executeQuery();
					if(vrs!=null)
			         {
						while(vrs!=null && vrs.next())
				    	{   
						patient_id_length = vrs.getString(1)==null?"":vrs.getString(1);
						
					    } 
					 }
					if(vrs!=null) vrs.close();
					if(pstmt2!=null) pstmt2.close();
        

       if(mode.equals("modify")||mode.equals("viewdata"))
		{
		//pstmt2  = con.prepareStatement("select FACILITY_ID, REGISTRATION_NO, PATIENT_ID, decode('"+localeName+"', 'en', PATIENT_NAME,nvl(PATIENT_NAME_LOC_LANG, PATIENT_NAME)) PATIENT_NAME, DATE_OF_BIRTH, AGE, SEX, NATIONALITY_CODE, NATIONALITY_DESC, RACE_CODE, RACE_DESC, RELGN_CODE, RELIGION_DESC, ETHNIC_GRP_CODE, ETHNIC_GRP_DESC, ENCOUNTER_ID, REFERRAL_ID, REFERRAL_TYPE, REFERRAL_TYPE_DESC, REF_SOURCE_CODE, REFERRAL_DESC, REFERRED_BY, UNCLAIMED_BODY_YN, DECEASED_YN, DECEASED_DATE, BODY_RECEIVED_DATE, DEATH_STATUS_REMARKS, HIGH_RISK_BODY_YN, DEATH_MANNER_CODE, DEATH_MANNER_DESC, BODY_COND_CODE, BODY_COND_DESC, PLACE_OF_DEATH, DEATH_CERTIFICATE_REQD_YN, IDENTIFICATION_MARKS, MLC_YN, BROUGHT_BY_POLICE_YN, SERVICE_CODE, SERVICE_DESC, PM_YN, POSTMORTEM_TYPE, POSTMORTEM_TYPE_DESC, AREA_CODE, AREA_DESC, BED_NO, AREA_TYPE, AREA_TYPE_DESC, ASSIGN_DATE_TIME, POL_REP_NO, POL_STN_ID, POL_ID, POLICE_DTLS, POLICE_APPROVAL_RECEIVED_YN, POLICE_APPROVAL_RECEIVED_BY,am_get_desc.am_practitioner(POLICE_APPROVAL_RECEIVED_BY,'"+locale+"',1) POLICE_APPROVAL_RECD_BY_NAME, POLICE_APPROVAL_RECEIVED_DATE, CONSENT_GIVEN_BY, RELATIONSHIP_WITH_DECEASED, RELATION_DESC, CONSENT_FORM_CODE, TITLE, CONSENT_FORM_DESC, CONSENT_FORM_RECEIVED_BY,am_get_desc.am_practitioner(CONSENT_FORM_RECEIVED_BY,'"+locale+"',1) CONSENT_FORM_RECD_BY_NAME, CONSENT_FORM_RECEIVED_DATE, DONOR_CARD_AVAILABLE_YN, DONOR_CARD_NO, DONOR_CARD_DETAILS, CONSENT_GIVEN_BY2, RELATIONSHIP_WITH_DECEASED2, RELATION_DESC2, CONSENT_FORM_CODE2, TITLE2, CONSENT_FORM_DESC2, CONSENT_FORM_RECEIVED_BY2, CONSENT_FORM_RECD_BY_NAME2, CONSENT_FORM_RECEIVED_DATE2, POSTMORTEM_STATUS, POSTMORTEM_STATUS_DESC, POSTMORTEM_START_DATE_TIME, POSTMORTEM_END_DATE_TIME, POSTMORTEM_FINDING, BURIAL_PERMIT_NO, BURIAL_PERMIT_APPROVED_BY,am_get_desc.am_practitioner(BURIAL_PERMIT_APPROVED_BY,'"+locale+"',1) BURIAL_PERMIT_APPR_BY_NAME, BURIAL_PERMIT_APPROVED_DATE, CLAIM_DATE_TIME, VEHICLE_NUM, RELEASED_BY, RELEASED_BY_NAME, RELEASE_BODY_DATE, EXPORTATION_REQD_YN, DESTINATION, EXPORTATION_DOC_ISS_DATE, EXPORTATION_ADDRESS, EMBASSY_CERTIFICATE_NO, EXPORTATION_DOC_ISSUED_BY, PM_REQUESTED_BY, PM_REQUESTED_BY_NAME, AUTOPSY_NO, PM_CERTIFIED_BY, PM_CERTIFIED_BY_NAME, PM_PURPOSE, ORDER_ID, ORDER_CATALOG_CODE, ORD_DATE_TIME, ACTUAL_DEATH_MANNER_CODE, ACTUAL_DEATH_MANNER_DESC, SPECIMEN_COLLECTED_BY, SPECIMEN_COLLECTED_BY_NAME, SPECIMEN_HANDED_OVER_TO, SPECIMEN_HANDED_OVER_DATE, TISSUE_PROCURED_BY, TISSUE_PROCURED_BY_NAME, TISSUE_PROCURE_PERFORMED_DATE, ALT_ID1_TYPE, ALT_ID1_DESC, ALT_ID1_NO, ALT_ID2_TYPE, ALT_ID2_DESC, ALT_ID2_NO, ALT_ID3_TYPE, ALT_ID3_DESC, ALT_ID3_NO, ALT_ID4_TYPE, ALT_ID4_DESC, ALT_ID4_NO, ATTEND_PRACTITIONER_ID, ATTEND_PRACTITIONER_NAME, PATIENT_CLASS, PAT_DTLS_UNKNOWN_YN, NO_OF_DAYS_IN_MO, DISPOSE_BODY_YN, NATIONAL_ID_NO, OTH_ALT_ID_TYPE, OTH_ALT_ID_DESC, OTH_ALT_ID_NO, MAR_STATUS_CODE, MARITAL_STATUS_DESC, BODY_PART_OBTAINED_FROM, BODY_PART_OBTAINED_FROM_DESC, HCARE_SETTING_TYPE, HCARE_SETTING_TYPE_DESC, BURIAL_PERMIT_ISSUED_YN, BURIAL_PERMIT_ISSUE_DATE, RELEASE_POL_ID, RELEASE_POL_STN_ID, RELEASE_POL_OFFICER_RANK, EXPT_HEALTH_OFFICER, EXPT_HEALTH_OFFICER_DESIG, EXPT_HEALTH_OFFICER_REMARKS, BODY_FOUND_AT, BROUGHT_DEAD_YN, REMARKS, PM_PERFORMED_BY, PM_PERFORMED_BY_NAME, PM_PERFORMED_BY_DESG, ROLE_FOR_PRACTITIONER , RFID_TAG_NUM from mo_mortuary_regn_vw where registration_no = ? and facility_id='"+facilityId+"'");
		pstmt2  = con.prepareStatement("select FACILITY_ID, REGISTRATION_NO, PATIENT_ID, decode('"+localeName+"', 'en', PATIENT_NAME,nvl(PATIENT_NAME_LOC_LANG, PATIENT_NAME)) PATIENT_NAME, DATE_OF_BIRTH, AGE, SEX, NATIONALITY_CODE, NATIONALITY_DESC, RACE_CODE, RACE_DESC, RELGN_CODE, RELIGION_DESC, ETHNIC_GRP_CODE, ETHNIC_GRP_DESC, ENCOUNTER_ID, REFERRAL_ID, REFERRAL_TYPE, REFERRAL_TYPE_DESC, REF_SOURCE_CODE, REFERRAL_DESC, REFERRED_BY, UNCLAIMED_BODY_YN, DECEASED_YN, DECEASED_DATE, BODY_RECEIVED_DATE, DEATH_STATUS_REMARKS, HIGH_RISK_BODY_YN, DEATH_MANNER_CODE, DEATH_MANNER_DESC, BODY_COND_CODE, BODY_COND_DESC, PLACE_OF_DEATH, DEATH_CERTIFICATE_REQD_YN, IDENTIFICATION_MARKS, MLC_YN, BROUGHT_BY_POLICE_YN, SERVICE_CODE, SERVICE_DESC, PM_YN, POSTMORTEM_TYPE, POSTMORTEM_TYPE_DESC, AREA_CODE, AREA_DESC, BED_NO, AREA_TYPE, AREA_TYPE_DESC, ASSIGN_DATE_TIME, POL_REP_NO, POL_STN_ID, POL_ID, POLICE_DTLS, POLICE_APPROVAL_RECEIVED_YN, POLICE_APPROVAL_RECEIVED_BY,am_get_desc.am_practitioner(POLICE_APPROVAL_RECEIVED_BY,'"+locale+"',1) POLICE_APPROVAL_RECD_BY_NAME, POLICE_APPROVAL_RECEIVED_DATE, CONSENT_GIVEN_BY, RELATIONSHIP_WITH_DECEASED, RELATION_DESC, CONSENT_FORM_CODE, TITLE, CONSENT_FORM_DESC, CONSENT_FORM_RECEIVED_BY,am_get_desc.am_practitioner(CONSENT_FORM_RECEIVED_BY,'"+locale+"',1) CONSENT_FORM_RECD_BY_NAME, CONSENT_FORM_RECEIVED_DATE, DONOR_CARD_AVAILABLE_YN, DONOR_CARD_NO, DONOR_CARD_DETAILS, CONSENT_GIVEN_BY2, RELATIONSHIP_WITH_DECEASED2, RELATION_DESC2, CONSENT_FORM_CODE2, TITLE2, CONSENT_FORM_DESC2, CONSENT_FORM_RECEIVED_BY2, CONSENT_FORM_RECD_BY_NAME2, CONSENT_FORM_RECEIVED_DATE2, POSTMORTEM_STATUS, POSTMORTEM_STATUS_DESC, POSTMORTEM_START_DATE_TIME, POSTMORTEM_END_DATE_TIME, POSTMORTEM_FINDING, BURIAL_PERMIT_NO, BURIAL_PERMIT_APPROVED_BY, BURIAL_PERMIT_APPR_BY_NAME, BURIAL_PERMIT_APPROVED_DATE, CLAIM_DATE_TIME, VEHICLE_NUM, RELEASED_BY, RELEASED_BY_NAME, RELEASE_BODY_DATE, EXPORTATION_REQD_YN, DESTINATION, EXPORTATION_DOC_ISS_DATE, EXPORTATION_ADDRESS, EMBASSY_CERTIFICATE_NO, EXPORTATION_DOC_ISSUED_BY, PM_REQUESTED_BY, PM_REQUESTED_BY_NAME, AUTOPSY_NO, PM_CERTIFIED_BY, PM_CERTIFIED_BY_NAME, PM_PURPOSE,ACTUAL_DEATH_MANNER_CODE, ACTUAL_DEATH_MANNER_DESC, SPECIMEN_COLLECTED_BY, SPECIMEN_COLLECTED_BY_NAME, SPECIMEN_HANDED_OVER_TO, SPECIMEN_HANDED_OVER_DATE, TISSUE_PROCURED_BY, TISSUE_PROCURED_BY_NAME, TISSUE_PROCURE_PERFORMED_DATE, ALT_ID1_TYPE, ALT_ID1_DESC, ALT_ID1_NO, ALT_ID2_TYPE, ALT_ID2_DESC, ALT_ID2_NO, ALT_ID3_TYPE, ALT_ID3_DESC, ALT_ID3_NO, ALT_ID4_TYPE, ALT_ID4_DESC, ALT_ID4_NO, ATTEND_PRACTITIONER_ID, ATTEND_PRACTITIONER_NAME, PATIENT_CLASS, PAT_DTLS_UNKNOWN_YN, NO_OF_DAYS_IN_MO, DISPOSE_BODY_YN, NATIONAL_ID_NO, OTH_ALT_ID_TYPE, OTH_ALT_ID_DESC, OTH_ALT_ID_NO, MAR_STATUS_CODE, MARITAL_STATUS_DESC, BODY_PART_OBTAINED_FROM, BODY_PART_OBTAINED_FROM_DESC, HCARE_SETTING_TYPE, HCARE_SETTING_TYPE_DESC, BURIAL_PERMIT_ISSUED_YN, BURIAL_PERMIT_ISSUE_DATE, RELEASE_POL_ID, RELEASE_POL_STN_ID, RELEASE_POL_OFFICER_RANK, EXPT_HEALTH_OFFICER, EXPT_HEALTH_OFFICER_DESIG, EXPT_HEALTH_OFFICER_REMARKS, BODY_FOUND_AT, BROUGHT_DEAD_YN, REMARKS, PM_PERFORMED_BY, PM_PERFORMED_BY_NAME, PM_PERFORMED_BY_DESG, ROLE_FOR_PRACTITIONER , RFID_TAG_NUM, police_officer_name, police_contact_no, external_body_part_yn from mo_mortuary_regn_vw where registration_no = ? and facility_id='"+facilityId+"'");//Modified by Thamizh selvi on 3rd Aug 2017 for ML-MMOH-CRF-0689
		pstmt2.setString(1,registration_no);
		vrs = pstmt2.executeQuery();
		while(vrs.next())
			 {
		
       vechile_no=vrs.getString("VEHICLE_NUM")==null?"":vrs.getString("VEHICLE_NUM"); 	postmortem_startend_status=vrs.getString("POSTMORTEM_STATUS")==null?"":vrs.getString("POSTMORTEM_STATUS"); 	burial_permit_appr_by_name=vrs.getString("burial_permit_appr_by_name")==null?"":vrs.getString("burial_permit_appr_by_name"); 	donor_card_available_yn=vrs.getString("donor_card_available_yn")==null?"":vrs.getString("donor_card_available_yn"); 
	   body_part_obtained_from=vrs.getString("body_part_obtained_from")==null?"":vrs.getString("body_part_obtained_from");		
	    referral_type=vrs.getString("referral_type")==null?"":vrs.getString("referral_type");		
		hcare_type_code=vrs.getString("HCARE_SETTING_TYPE") == null?"":vrs.getString("HCARE_SETTING_TYPE");
		area_type=vrs.getString("area_type") == null?"":vrs.getString("area_type");	
		burial_perm_no=vrs.getString("BURIAL_PERMIT_NO")== null?"":vrs.getString("BURIAL_PERMIT_NO");
	    remarks=vrs.getString("remarks")== null?"":vrs.getString("remarks");
		body_claiming_date_time=vrs.getString("CLAIM_DATE_TIME")==null?"":vrs.getString("CLAIM_DATE_TIME"); 
		burial_perm_by=vrs.getString("BURIAL_PERMIT_APPROVED_BY") == null?"":vrs.getString("BURIAL_PERMIT_APPROVED_BY");
		burial_permit_approved_date=vrs.getString("burial_permit_approved_date")==null?"":vrs.getString("burial_permit_approved_date");//Added by Kamatchi S on 12/17/2019 for ML-MMOH-SCF-1423
		if(burial_perm_no!="")
		{
		readText="";
		disablebut="disabled";
 		
		}
		
		 body_received_date=vrs.getString("body_received_date")==null?"":vrs.getString("body_received_date");	
		 regn_no=vrs.getString("registration_no")==null?"":vrs.getString("registration_no"); 
		ref_source_code=vrs.getString("ref_source_code")==null?"":vrs.getString("ref_source_code");                                          
		referred_by= vrs.getString("referred_by")==null?"":vrs.getString("referred_by"); 
		death_manner_code=vrs.getString("death_manner_code")==null?"":vrs.getString("death_manner_code"); 
		body_cond_code=vrs.getString("body_cond_code")==null?"":vrs.getString("body_cond_code"); 
		high_risk_body_yn= vrs.getString("high_risk_body_yn")==null?"":vrs.getString("high_risk_body_yn"); 
		unclaimed_body_yn=vrs.getString("unclaimed_body_yn")==null?"":vrs.getString("unclaimed_body_yn"); 
		
	if(unclaimed_body_yn.equals("N"))disunclim="disabled";
	
		
	brought_by_police_yn= vrs.getString("brought_by_police_yn")==null?"":vrs.getString("brought_by_police_yn"); 
	mlc_yn= vrs.getString("mlc_yn")==null?"":vrs.getString("mlc_yn"); 
	service_code=  vrs.getString("service_code")==null?"":vrs.getString("service_code"); 
	area_code=vrs.getString("area_code")==null?"":vrs.getString("area_code"); 
	
	bed_no= vrs.getString("bed_no")==null?"":vrs.getString("bed_no"); 
	
	rfid_tag_num= vrs.getString("rfid_tag_num")==null?"":vrs.getString("rfid_tag_num"); 
	assign_date_time=vrs.getString("assign_date_time")==null?"":vrs.getString("assign_date_time"); 
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
consent_form_recd_by_name=vrs.getString("consent_form_recd_by_name")==null?"":vrs.getString("consent_form_recd_by_name");   	consent_form_received_date=vrs.getString("consent_form_received_date")==null?"":vrs.getString("consent_form_received_date"); 
	/*Added by Thamizh selvi on 3rd Aug 2017 for ML-MMOH-CRF-0689 Start*/
	pol_officer_name	= vrs.getString("police_officer_name")==null?"":vrs.getString("police_officer_name");   
	pol_contact_no		= vrs.getString("police_contact_no")==null?"":vrs.getString("police_contact_no");   
	externalBodyPartYn	= vrs.getString("external_body_part_yn")==null?"N":vrs.getString("external_body_part_yn");   
	/*End*/
						
			 } 
		//Added by Kamatchi S on 12/17/2019 for ML-MMOH-SCF-1423
		if(!burial_permit_approved_date.equals("")){
			burial_perm_date =burial_permit_approved_date;
		}
            if(vrs!=null) vrs.close();
            if(pstmt2!=null) pstmt2.close();

		
		/*pstmt2  = con.prepareStatement("select BODY_PART_CODE from mo_body_part_regn where registration_no = ? and facility_id='"+facilityId+"'");
		pstmt2.setString(1,regn_no);
		vrs = pstmt2.executeQuery();
		int i=0;
		while(vrs.next())
		{
		bodyregn[i]=vrs.getString("BODY_PART_CODE");
		
		i++;
		}*/
		
		
		  //Below QUERY Changed Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg

		  pstmt2  = con.prepareStatement("select FACILITY_ID, REGISTRATION_NO, CLAIMANT_TYPE_DESC, CLAIMANT_TYPE_CODE,CLAIMANT_TYPE, RELATIONSHIP, NAME, JOB_TITLE, ADD_LINE1, ADD_LINE2, ADD_LINE3, ADD_LINE4, ZIP_CODE,MP_GET_DESC.MP_POSTAL_CODE(ZIP_CODE,'"+locale+"','2') POSTAL_DESC, COUNTRY_CODE, RES_TOWN_CODE, RES_AREA_CODE, REGION_CODE, TELEPHONE_OFF, TELEPHONE_RES, EMAIL_ID, MOB_TEL_NO, NAT_ID_NO,ORGANIZATION_NAME,PATIENT_EMPLOYEE_ID,PASSPORT_NO,OTHER_IDENTIFICATION,MP_GET_DESC.MP_RES_TOWN(RES_TOWN_CODE,'"+locale+"','2') res_town_desc,MP_GET_DESC.MP_RES_AREA(RES_AREA_CODE,'"+locale+"','2') res_area_desc,MP_GET_DESC.MP_REGION(REGION_CODE,'"+locale+"','2') region_desc,RELEASE_TO_FACILITY,REASON from mo_claimant_vw where  REGISTRATION_NO = ?");
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
		zip_code_desc=vrs.getString("POSTAL_DESC")==null?"":vrs.getString("POSTAL_DESC");
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

	   RELEASE_TO_FACILITY=vrs.getString("RELEASE_TO_FACILITY")==null?"":vrs.getString("RELEASE_TO_FACILITY");//Added Aginst Bru-HIMS-CRF-366 [IN-039612]
	reason_deceased_desc= vrs.getString("REASON")==null?"":vrs.getString("REASON"); //this line Added for this CRF -Bru-HIMS-CRF-366
		

		 }
		
		
		
		
		if(claimant_type.equals("E"))
	  {
	  pstmt2  = con.prepareStatement("select b.short_desc ocpn_class_desc from mp_occupation_lang_vw a,MP_OCCUPATION_CLASS_lang_vw b,mp_pat_rel_contacts c where a.LANGUAGE_ID='"+locale+"' and a.LANGUAGE_ID=b.LANGUAGE_ID and a.OCPN_CODE=c.OCPN_CODE and  a.OCPN_CLASS_CODE=b.OCPN_CLASS_CODE and c.patient_id=?");
	  pstmt2.setString(1,patient_id);
	  vrs = pstmt2.executeQuery();
	  while(vrs.next())
	  {
	  
	  ocpn_class_desc=vrs.getString("ocpn_class_desc");
	  }
	  }
	  
	  
		
		}

		 
	//ArrayList contact_addr= fetchContactAddresses(con,out,"parent.parent.messageFrame") ;
	 
	// String Site					= (String)contact_addr.get(0) ;
	  
     
     if(body_claiming_date_time.equals(""))
	  {
	   body_claiming_date_time=sys_date;
	  }
	  
	/*Below line added for this ML-MMOH-CRF-0695*/
     if(!body_claiming_date_time.equals("")) body_claiming_date_time = DateUtils.convertDate(body_claiming_date_time,"DMYHM","en",localeName); 	
	  
    if(postmortem_status.equals("Y"))checkpm="Checked" ;else checkpm="";
	if(mlc_yn.equals("Y"))checkmlc="Checked"; else checkmlc="";

//selectRef('<%=referral_type ','<%=ref_source_code');
   
   /*Below line added for this ML-MMOH-CRF-0695*/
	if(datetimeofclaimingApplicable && !function_id.equals("Reg_Details")){
		body_claiming_date_time = DateUtils.convertDate(sys_date,"DMYHM","en",localeName); 
		datetimeofclaiming="disabled";           
	}
	if(datetimeofclaimingApplicable && function_id.equals("Reg_Details")) datetimeofclaiming="disabled";  
	//End this CRF ML-MMOH-CRF-0695

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
	
	<!--Modified by Ashwini on 08-Aug-2017 for ML-MMOH-CRF-0748-->
	 <body OnMouseDown='CodeArrest();' onKeyDown = 'lockKey();' onLoad="disableGif();assignmlc('<%=area_code%>','<%=postmortem_status%>','<%=postmortem_type%>','<%=postmortem_startend_status%>');getClaimant1('<%=claimant_type%>','<%=claimant_type_code%>');ClearClaimantValues();enableManGif(); <%if(refTypeBrghtByPoliceDisable){%> DisableBrghtByPolice(this.document.forms[0].refe_type); DisableRefTypeHlthCare(); <%}%> "  >	 <!--changes for 38265-->
	 <form name="MO_regn_form" id="MO_regn_form"  action="../../servlet/eMO.MOBodyPartRegnServlet"  method="post" target="messageFrame" >
       
<!-- 	 <a name="tab1"   onFocus='javascript:AEScrollIntoView(1);'></a><table width='95%' cellpadding='0' cellspacing='0' BORDER='0' ><tr><td width='1%' class='BODYCOLORFILLED'></td><td  class='BODYCOLORFILLED' ><a align ='left' href="javascript:AEScrollIntoView(1)" style="cursor:pointer;" >&nbsp;&nbsp;<img src='../../eMO/images/RegistrationDetailsClick.gif' border=0 ></a><a align='left' href="javascript:AEScrollIntoView(3)"  ><img src="../../eMO/images/Claimant.gif" border=0><a align='left' href="javascript:AEScrollIntoView(2)"><img   src="../../eMO/images/BurialPermit.gif" border=0  id='dis1'></a> 
	 </tr> 
	 </table>
 -->
  <a name="tab1" id='tab1'></a> 
   <table cellspacing='0' cellpadding='0' width='95%' border='0' align='center'>
       <tr><td class='white'>
		 <ul id="tablist" class="tablist" >
			<li class="tablistitem" title="Registration Details">
				<a onclick="tab_click1('RegDtl_tab')" class="tabClicked" id='RegDtl_tab' >
					<span class="tabSpanclicked" id="RegDtl_tabspan"><fmt:message key="Common.Registration.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.details.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			<!--Added by Ashwini on 17-Oct-2017 for ML-MMOH-CRF-0696-->
			<%if(rearrangeTabBurlPermtClaimnt){%>
			<li class="tablistitem" title="Burial Permit" id='bp1'>
				<a onclick="tab_click1('burialPermit_tab')" class="tabA" id="burialPermit_tab" >
					<span class="tabAspan" id="burialPermit_tabspan"><fmt:message key="eMO.BurialPermit.label" bundle="${mo_labels}"/></span>
				</a>
			</li>
			<li class="tablistitem" title="Claimant" id='clmantDis'>
				<a onclick="tab_click1('claimant_tab')" class="tabA" id="claimant_tab" >
					<span class="tabAspan" id="claimant_tabspan"><fmt:message key="eMO.Claimant.label" bundle="${mo_labels}"/></span>
				</a>
			</li>	
			<%}else{%>
			<li class="tablistitem" title="Claimant">
				<a onclick="tab_click1('claimant_tab')" class="tabA" id="claimant_tab" >
					<span class="tabAspan" id="claimant_tabspan"><fmt:message key="eMO.Claimant.label" bundle="${mo_labels}"/></span>
				</a>
			</li>
			<li class="tablistitem" title="Burial Permit" id='bp1'>
				<a onclick="tab_click1('burialPermit_tab')" class="tabA" id="burialPermit_tab" >
					<span class="tabAspan" id="burialPermit_tabspan"><fmt:message key="eMO.BurialPermit.label" bundle="${mo_labels}"/></span>
				</a>
			</li>
			<%}%>
		 </ul>
       </td></tr>
	</table>
	<table border="0" cellpadding="2" cellspacing="0" align='center' width='95%'>
 
<!-- 	<tr>
   <td width='1%' align='right' class='label' nowrap>Body Part Type&nbsp;</td>
   <td align='left' ><select name='obt_from' id='obt_from' <%=disabledyn%> onChange='changeLegent(this)'><option value=''>-------Select-------</option>
   <option value='A'>Amputated Body Part</option>
   <option value='D'>Dead Fetus</option>
   <option value='U'>Unidentified Body Part</option>
		 

  
   </select>&nbsp;<img src='../../eCommon/images/mandatory.gif' ></img></td>
   <td align='right' class='label' nowrap><label id=lab1></label>&nbsp;&nbsp;</td>
   <td align='left'><input type='text'  name='patientid' id='patientid' id='patiddis' disabled onKeyPress="return CheckForSpecChars(event);"onBlur='validatePatient(this);' value='<%=patient_id%>' size='20' maxlength='<%=patient_id_length%>'><input type='button'  disabled name=' pat' id=' pat' id='patbtn' <%=disabledyn%> class='button' value='?' onClick="callpatientsearch(this,'<%=facilityId%>',patientid)">&nbsp;<img src='../../eCommon/images/mandatory.gif' style="visibility:hidden"  id=patman></img></td>
<td >&nbsp;</td>
  </tr>
 -->
<tr>
<th align='center' colspan='3'> <fmt:message key="Common.BodyParts.label" bundle="${common_labels}"/> </th>
<th align='center' colspan='2'> <fmt:message key="Common.remarks.label" bundle="${common_labels}"/> </th>
</tr> 
	   <tr><td colspan=5 class=label height=5></td></tr>
<tr>

<td  class='fields' width='25%'>
	<select name='selectbodypart' id='selectbodypart' size='5' style="width:80%" multiple='true'>
	   <%pstmt2 = con.prepareStatement(bodypartqry);
	   pstmt2.setString(1,regn_no);
	   pstmt2.setString(2,facilityId);
	   vrs = pstmt2.executeQuery();	
	   
	   while(vrs.next())
	   {%>
			<option value='<%=vrs.getString("BODY_PART_CODE")%>'><%=vrs.getString("short_desc")%>  </option>
	  <%}%>
	</select>
</td>
<td align='center' width='25%' size='5'  ><p><input type='button' name='add' id='add' id='bt1' class='button' onclick='addBodyPart()' value='---->'>                      <br><input type='button'  id='bt2' name='add' id='add' class='button'  value='<----' onclick='removeBodyPart()'></img></p></td>



<td class='fields' width='25%'>
	<select name='addbodypart' id='addbodypart' style="width:80%" size='5' multiple='true'>
		<% pstmt2 = con.prepareStatement("select a.BODY_PART_CODE,b.short_desc  from mo_body_part_regn a,mo_body_part_lang_vw b where b.LANGUAGE_ID='"+locale+"' and a.registration_no= ?  and a.body_part_code=b.body_part_code and a.facility_id=? ");
		   pstmt2.setString(1,regn_no);
		   pstmt2.setString(2,facilityId);
		   
		   vrs = pstmt2.executeQuery();	
		   
		   while(vrs.next())
		   {%>
			<option value='<%=vrs.getString("BODY_PART_CODE")%>'><%=vrs.getString("short_desc")%>  </option>
		   <%}%>
	</select>
 </td>
<td colspan=2><TEXTAREA ROWS="5" COLS="35" name='remarks'  onBlur="checkForMaxLimit(this);" ><%=remarks%></TEXTAREA></td>
  </tr>
<tr><td colspan=5 class=label height=5></td></tr>


   <tr>
<th align='left' colspan='5'> &nbsp; </th>
</tr> 
  
</table>

 <table border="0" cellpadding="2" cellspacing="0" align='center' width='95%'>

  <tr>
   <!--Below legend name modified by Shanmukh on 26th-JUNE-2018 for ML-MMOH-CRF-1036-->
   <%if(isReceivedDateTimeAppl){%>
   <td class='LABEL' width='25%'><fmt:message key="Common.BodyPart.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.received.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.DateTime.label" bundle="${common_labels}"/>&nbsp;</td><%}else{%>
   <td class='LABEL' width='25%'><fmt:message key="eMO.BodyPartReceiptDateTime.label" bundle="${mo_labels}"/>&nbsp;</td><%}%>
   <td class='fields' width='25%' ><INPUT TYPE="text"  onBlur='validate1(this);' name="body_received_date_time" id="body_received_date_time" <%=disabledyn%> value='<%=DateUtils.convertDate(body_received_date,"DMYHM","en",locale)%>' maxlength=16 ><img src="../../eCommon/images/CommonCalendar.gif" <%=disabledyn%>  id='bodychk' onClick="document.forms[0].body_received_date_time.select();return showCalendar('body_received_date_time', null, 'hh:mm',true );" style="cursor='hand'">&nbsp;<img src='../../eCommon/images/mandatory.gif' ></img></td>
   <td class='LABEL' width='25%' ><fmt:message key="Common.service.label" bundle="${common_labels}"/>&nbsp;</td>
   <td class='fields' width='25%'><SELECT name="service_code" id="service_code" <%=disabledyn%>><option value=""> -------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
	   <% sstat = con.createStatement();
				 
	 			  //DFLT_SERVICE_CODE Added for Bru-HIMS-CRF-413 [IN:045501]
	   			  // vrs = sstat.executeQuery("select SERVICE_CODE,am_get_desc.AM_SERVICE(SERVICE_CODE,'"+locale+"',2)  short_desc from AM_FACILITY_SERVICE_VW a where OPERATING_FACILITY_ID='"+facilityId+"' and dept_code =(select dept_code from mo_parameter where facility_id=a.operating_facility_id) and eff_status='E' order by SERVICE_SHORT_DESC");
                  String DFLT_SERVICE_CODE	= "";
                  int serviceCount = 0;
	 			  vrs = sstat.executeQuery("select SERVICE_CODE,am_get_desc.AM_SERVICE(SERVICE_CODE,'"+locale+"',2)  short_desc,(select DFLT_SERVICE_CODE from mo_parameter where facility_id=a.operating_facility_id) DFLT_SERVICE_CODE from AM_FACILITY_SERVICE_VW a where OPERATING_FACILITY_ID='"+facilityId+"' and dept_code =(select dept_code from mo_parameter where facility_id=a.operating_facility_id) and eff_status='E' order by SERVICE_SHORT_DESC");
				    
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
				   }
				  
				   if(vrs!=null) vrs.close();
				   if(sstat!=null) sstat.close();
				  if(pstmt2!=null) pstmt2.close();


         
	 	 %>




   
   </SELECT>&nbsp;<img src='../../eCommon/images/mandatory.gif' ></img>
   	<script>										 
		if('<%=mode%>' == "insert" && '<%=serviceCount%>' == 1)
		  document.forms[0].service_code.options[1].selected=true;											
	</script>
   </td>
   </tr>
  <tr>
  <!--Modified by Ashwini on 08-Aug-2017 for ML-MMOH-CRF-0748-->
   <td class='LABEL' width='25%'><fmt:message key="Common.referraltype.label" bundle="${common_labels}"/></td>
   <td class='fields' width='25%' ><SELECT name="refe_type" id="refe_type" onchange='selectRef(this); <%if(refTypeBrghtByPoliceDisable){%> DisableBrghtByPolice(this) <%}%>'><option value="">-----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------- </option>
    <option value='L' ><fmt:message key="Common.loginfacility.label" bundle="${common_labels}"/></option>	
	<option value='E' ><fmt:message key="Common.enterprise.label" bundle="${common_labels}"/></option>
    <option value='X'><fmt:message key="Common.external.label" bundle="${common_labels}"/></option>
   </SELECT></td>
   <td class='LABEL' width='25%'>&nbsp;</Td> 
   <td class='LABEL' width='25%'>&nbsp;</Td> 
  
   </tr>

<tr>
	   <td class='LABEL' width='25%'><fmt:message key="Common.HealthcareSettingType.label" bundle="${common_labels}"/></td>
	   <td class='fields' width='25%' ><SELECT name="hcare_type" id="hcare_type" onchange='selectRef(this)' ><option value="">-----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------- </option>
	<%
			
			sstat = con.createStatement();
			vrs = sstat.executeQuery("SELECT hcare_setting_type_code,short_desc FROM am_hcare_setting_type_lang_vw  WHERE LANGUAGE_ID='"+locale+"' and eff_status='E' ORDER BY 2");
                   while(vrs.next())
				   {
					   if(hcare_type_code.equals(vrs.getString("hcare_setting_type_code"))){
				                   %>
				<option value='<%=vrs.getString("hcare_setting_type_code")%>' selected> <%=vrs.getString("short_desc")%></option>
				   
				<%}else{%>
				<option value='<%=vrs.getString("hcare_setting_type_code")%>'> <%=vrs.getString("short_desc")%></option>
				<%}
	            }
				   if(vrs!=null) vrs.close();
				   if(sstat!=null) sstat.close();
	%>
	</SELECT></td>
   <td class='LABEL' width='25%'>&nbsp;</Td> 
   <td class='LABEL' width='25%'>&nbsp;</Td> 
  
</tr>
<tr>
	 <td class='LABEL' width='25%'><fmt:message key="Common.referralsource.label" bundle="${common_labels}"/></td>
	 <td  class='fields' width='25%'><SELECT name="referral_source" id="referral_source" ><option value="">-----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------- </option>
	<%
		String sqlref="";
				
		if(mode.equals("modify") || mode.equals("viewdata"))
		  {
			 if(!referral_type.equals(""))
			  {
				
			  if(referral_type.equals("L"))
			  {
				  sqlref="SELECT  a.FACILITY_ID referred_to_id,a.FACILITY_NAME referred_to_id_desc  FROM sm_facility_param_lang_vw a, am_hcare_setting_type_lang_vw b  WHERE a.LANGUAGE_ID='"+locale+"' and a.LANGUAGE_ID=b.LANGUAGE_ID and a.hcare_setting_type_code = b.hcare_setting_type_code  AND a.facility_id = '"+facilityId+"' ORDER BY b.short_desc";


			  }else if(referral_type.equals("E"))
			  {
				  sqlref="SELECT  a.FACILITY_ID referred_to_id,a.FACILITY_NAME referred_to_id_desc FROM sm_facility_param_lang_vw a, am_hcare_setting_type_lang_vw b  WHERE a.LANGUAGE_ID='"+locale+"' and a.LANGUAGE_ID=b.LANGUAGE_ID and a.hcare_setting_type_code = b.hcare_setting_type_code and  a.hcare_setting_type_code =NVL('"+hcare_type_code+"',a.hcare_setting_type_code) AND a.facility_id != '"+facilityId+"' ORDER BY b.short_desc";


			  }else if(referral_type.equals("X"))
			  {
				  sqlref="Select  a.REFERRAL_CODE referred_to_id,a.SHORT_DESC referred_to_id_desc from am_referral_lang_vw a, am_hcare_setting_type_lang_vw b where a.LANGUAGE_ID='"+locale+"' and a.LANGUAGE_ID=b.LANGUAGE_ID and a.healthcare_setting_type = b.hcare_setting_type_code and nvl(a.dest_use_at_concl_yn,'N') = 'Y' and a.eff_status = 'E' and  a.healthcare_setting_type=NVL('"+hcare_type_code+"',a.healthcare_setting_type) order by a.short_desc";

			  }
				sstat = con.createStatement();
				vrs = sstat.executeQuery(sqlref);
			   while(vrs.next())
				{
					   if(ref_source_code.equals(vrs.getString("referred_to_id"))){
				                   %>
				<option value='<%=vrs.getString("referred_to_id")%>' selected> <%=vrs.getString("referred_to_id_desc")%></option>
				   
				<%}else{%>
				<option value='<%=vrs.getString("referred_to_id")%>'> <%=vrs.getString("referred_to_id_desc")%></option>
				<%}
	            }
				   if(vrs!=null) vrs.close();
				   if(sstat!=null) sstat.close();
			  }
		  }

	%>
	</SELECT></td>
	<td class='LABEL' width='25%'><fmt:message key="Common.referredby.label" bundle="${common_labels}"/></td>
	<td class='fields' width='25%'><INPUT TYPE="text" maxlength=30 size=30 name="referral_by" id="referral_by" value='<%=referred_by%>'></td>
   </tr>
   <tr>
   <td class='LABEL' width='25%'><fmt:message key="eMO.UnclaimedBodyPart.label" bundle="${mo_labels}"/></td>
   <td class='fields' width='25%'>
	<%if(unclaimed_body_yn.equals("Y"))  { %>
   <INPUT TYPE="checkbox" name="unclaimedbodyyn" id="unclaimedbodyyn" checked value="Y" onClick='ClearClaimantValues()'>
   <%}else{%>
   <INPUT TYPE="checkbox" name="unclaimedbodyyn" id="unclaimedbodyyn" value="N" onClick='ClearClaimantValues()'>
   <%}%></td>
   <!--below legend name change against ML-MMOH-CRF-0737 by Mano -->
   <%if(mlcAndInfectiousDeceBodyApplicable){%>
   <td class='LABEL' width='25%'><fmt:message key="Common.InfectiousDeceasedBodyPart.label" bundle="${common_labels}"/></td>
   <td  class='fields' width='25%'>
   <%}else{%>
   <td class='LABEL' width='25%'><fmt:message key="eMO.HighRiskBodyPart.label" bundle="${mo_labels}"/></td><!--bundle change for PAS-MO-PMG2020-TECH-CRF-0010/02-Label Name-->
   <td  class='fields' width='25%'>
   <%}%>
	<%if(high_risk_body_yn.equals("Y"))  { %>
   <INPUT TYPE="checkbox" name="highriskbodyyn" id="highriskbodyyn" value="Y" checked>
   <%}else{%>
   <INPUT TYPE="checkbox" name="highriskbodyyn" id="highriskbodyyn" value="N">
   <%}%>
 </tr>

   <tr>
   <!-- below line(s) modified by VenkateshS against ML-MMOH-CRF-0354 [IN057191] -->
   <!--below legend name change against ML-MMOH-CRF-0737 by Mano -->
   <%if(siteSpecific){%>
   <td class='LABEL' width='25%'><fmt:message key="Common.MedicalLegalCase.label" bundle="${common_labels}"/></td>
   <%}else{%>
   <%if(mlcAndInfectiousDeceBodyApplicable){%>
   <td class='LABEL' width='25%'><fmt:message key="Common.MedicoLegalCase.label" bundle="${common_labels}"/></td>
   <%}else{%>
   <td class='LABEL' width='25%'><fmt:message key="Common.mlc.label" bundle="${common_labels}"/></td
   <%}}%>
   <!--end ML-MMOH-CRF-0354 [IN057191 -->
   <td class='fields' width='25%'  >
	<%/* if(mlc_yn.equals("Y")){*/%>
   <!-- <INPUT TYPE="checkbox" name="mlc_yn" id="mlc_yn" <%=disabledyn%> checked value="Y" onClick='assignmlc();clearBed1();checkserv1();'> -->
    <%/*}else*/ if(area_type.equals("P")||area_type.equals("R")||obt_from.equals("D")||postmortem_startend_status.equals("E")||postmortem_startend_status.equals("R"))
	 {%>
   <INPUT TYPE="checkbox" name="mlc_yn" id="mlc_yn" <%=checkmlc%>  disabled value="<%=mlc_yn%>" onClick='assignmlc();clearBed1();checkserv1();'></td>
   <%}else{%>
   <INPUT TYPE="checkbox" name="mlc_yn" id="mlc_yn" <%=checkmlc%>   value="<%=mlc_yn%>" onClick='assignmlc();clearBed1();checkserv1();'></td>
   
   <%}%>
   <!--Modified by Ashwini on 08-Aug-2017 for ML-MMOH-CRF-0748-->
   <td class='LABEL' width='25%'><fmt:message key="eMO.BroughtByPolice.label" bundle="${mo_labels}"/>&nbsp;</td>
   <td class='fields' width='25%' >
	<%if(brought_by_police_yn.equals("Y")){%>
   <INPUT TYPE="checkbox" checked name="brought_by_police_yn" id="brought_by_police_yn" value="Y" <%if(refTypeBrghtByPoliceDisable){%> onclick='DisableRefTypeHlthCare()' <%}%>></td>
   <%}else{%>
	<INPUT TYPE="checkbox" name="brought_by_police_yn" id="brought_by_police_yn" value="N" <%if(refTypeBrghtByPoliceDisable){%> onclick='DisableRefTypeHlthCare()' <%}%>></td>
   <%}%> 
   </tr>
   <tr>
   	  <td  class=label colspan='3'></td>
	  <td class=label><INPUT TYPE="button" name='Police_Details'  id='Police_Details' onClick='policedetails()' style="width:100" class='button' value= '<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.PoliceDetails.label","mo_labels")%>' ></td>
   </tr>

<tr>
   <td class='LABEL' width='25%'><fmt:message key="Common.PMRequired.label" bundle="${common_labels}"/>&nbsp;</td>
   <td  class='fields' width='25%' >
<%/*	if(postmortem_status.equals("Y")){*/%>	  
  <!-- <INPUT TYPE="checkbox" name="postmortem_reqd_yn" id="postmortem_reqd_yn"  <%=disabledyn%> onClick='getService();clearpoliceconsent()' value="N"> -->
  <%/*}else*/ if(area_type.equals("R")||area_type.equals("P")||obt_from.equals("D")||postmortem_startend_status.equals("E")||postmortem_startend_status.equals("R")){%>
  <input type='checkbox' <%=checkpm%>   name="postmortem_reqd_yn"  id="postmortem_reqd_yn" value='<%=postmortem_status%>'  disabled onClick='getService();clearpoliceconsent()'>
  <%}else{%>
  <input type='checkbox' <%=checkpm%> name="postmortem_reqd_yn" id="postmortem_reqd_yn"  value='<%=postmortem_status%>'   onClick='getService();clearpoliceconsent();'>
  <%}%>
	  </td>
  <td class='LABEL' width='25%'><fmt:message key="eMO.PostmortemType.label" bundle="${mo_labels}"/>&nbsp;</td>
  <td class='fields' width='25%'><SELECT name="postmortem_type" id="postmortem_type" disabled onChange='enableConsent()'>
	<option value="">-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
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
		
	</SELECT><img id='idpttype'src='../../eCommon/images/mandatory.gif' align='center'  style='visibility:hidden' ></td>
</tr>

<tr>
   	  <td  class=label colspan='3'></td>
	  <td class=label><INPUT TYPE="button" name='Consent_forms' id='Consent_forms'  style="width:100" class='button' value= '<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Consent.label","common_labels")%>'   onclick="getConsentForm()" ></td>
</tr>

<tr><th align='center' colspan='4'><fmt:message key="Common.assignarea.label" bundle="${common_labels}"/></th></tr> 
<tr>
    
    <td class='LABEL' width='25%'><fmt:message key="Common.area.label" bundle="${common_labels}"/> </td>
	<td class='fields' width='25%'>
	<%
		
		
		if(area_type.equals("P")||area_type.equals("R")||postmortem_startend_status.equals("E")||postmortem_startend_status.equals("R")){%>
	<select name='area_type' id='area_type' <%=disabledyn%> onblur='if(this.value =="") document.getElementById("tab1").scrollIntoView(); document.forms[0].unclaimedbodyyn.focus();' onchange='clearBed()';>
	<%}else{%>
	<select name='area_type' id='area_type'  onblur='if(this.value =="") document.getElementById("tab1").scrollIntoView(); document.forms[0].unclaimedbodyyn.focus();' onchange='clearBed()';>
	<%}%>
	<option value = "">-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
	</select>
	</td>
	
	<td class='LABEL' width='25%' ><fmt:message key="Common.Location.label" bundle="${common_labels}"/>&nbsp;</td>
	<td class='fields' width='25%'><input type='text' name='bed_no' id='bed_no' size='8' maxlength='8' disabled  value="<%=bed_no%>" 
onBlur='BedCheck();' ><input type=button class=button value='?' name='bed_button' id='bed_button' disabled  onClick='searchBed(this,bed_no);' ></td>
   </tr>
	<tr>
	<td class='LABEL' width='25%'><fmt:message key="Common.assigndatetime.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td class='fields' width='25%'>
 	<input type='text'  id='assigndatetime' name="assign_date_time" id="assign_date_time"  value="<%=DateUtils.convertDate(assign_date_time,"DMYHM","en",locale)%>" maxLength='16' size='16' onBlur='doDateTimeChk1(this);'  disabled><input  id='acalendar' type="image" src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('assigndatetime', null, 'hh:mm' );" disabled>&nbsp;<img align='center' id='adatetime' style='visibility:hidden' src='../../eCommon/images/mandatory.gif'></img></td>
<%
		String disRFID = "";
		if((mode.equals("modify") && !rfid_tag_num.equals("")) || mode.equals("viewdata") )
			disRFID="disabled" ; 
		if(enable_rfid_yn.equals("Y")) // added by mujafar for ML-MMOH-CRF-0996
		{
		%>
	<td class='LABEL' width='25%' ><fmt:message key="eMO.RFIDTag.label" bundle="${mo_labels}"/>&nbsp;</td>
	<td class='fields' width='25%'><input type='text' name='RFID_Tag' id='RFID_Tag' size='20' maxlength='20' <%=disRFID%> value="<%=rfid_tag_num%>" 
onBlur='blurRFID(this);' ><input type=button class=button value='?' <%=disRFID%> name='RFID_Tag_button'  onClick='searchRFID(this,RFID_Tag);' ></td>
<%
	  }
%>

	</tr>
   <tr>
	 <td  class=label colspan='3'></td>
      <td class='label'><INPUT TYPE="button" name=portmorteme_Det id=portmorteme_Det onClick='viewpostmortemdet()'  style="width:100;visibility:hidden" class='button' value= '<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.PostMortem.label","mo_labels")%>' ></td>
  </tr>
 </table> 
 <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

  <a name="tab2" id='tab2'></a> 
   <table cellspacing='0' cellpadding='0' width='95%' style="margin-top:-413px;" border=0 align='center'>
       <tr><td class='white'>
		 <ul id="tablist" class="tablist" >
			<li class="tablistitem" title="Registration Details">
				<a onclick="tab_click1('RegDtl_tab')" class="tabA" id='RegDtl_tab' >
					<span class="tabAspan" id="RegDtl_tabspan"><fmt:message key="Common.Registration.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.details.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			<!--Added by Ashwini on 17-Oct-2017 for ML-MMOH-CRF-0696-->
			<%if(rearrangeTabBurlPermtClaimnt){%>
			<li class="tablistitem" title="Burial Permit" id='bp2'>
				<a onclick="tab_click1('burialPermit_tab')" class="tabA" id="burialPermit_tab" >
					<span class="tabAspan" id="burialPermit_tabspan"><fmt:message key="eMO.BurialPermit.label" bundle="${mo_labels}"/></span>
				</a>
			</li>
			<li class="tablistitem" title="Claimant" id='clmantDis2'>
				<a onclick="tab_click1('claimant_tab')" class="tabClicked" id="claimant_tab" >
					<span class="tabSpanclicked" id="claimant_tabspan"><fmt:message key="eMO.Claimant.label" bundle="${mo_labels}"/></span>
				</a>
			</li>
			<%}else{%>
			<li class="tablistitem" title="Claimant">
				<a onclick="tab_click1('claimant_tab')" class="tabClicked" id="claimant_tab" >
					<span class="tabSpanclicked" id="claimant_tabspan"><fmt:message key="eMO.Claimant.label" bundle="${mo_labels}"/></span>
				</a>
			</li>
			<li class="tablistitem" title="Burial Permit" id='bp2'>
				<a onclick="tab_click1('burialPermit_tab')" class="tabA" id="burialPermit_tab" >
					<span class="tabAspan" id="burialPermit_tabspan"><fmt:message key="eMO.BurialPermit.label" bundle="${mo_labels}"/></span>
				</a>
			</li>	
			<%}%>
		 </ul>
       </td></tr>
	</table>



<!-- <a name="tab2"  onFocus='javascript:AEScrollIntoView(3);'></a> 
<table width='100%' cellpadding='0'   cellspacing='0' BORDER='0'><tr><td width='1%' class='BODYCOLORFILLED'></td><td width='50%' class='BODYCOLORFILLED'>&nbsp;<a align ='left' href="javascript:AEScrollIntoView(1)"><img src="../../eMO/images/RegistrationDetails.gif" border=0></a><a align='left'  href="javascript:AEScrollIntoView(3)"   ><img src="../../eMO/images/ClaimantClick.gif" border=0 id='clmt'><a align='left' href="javascript:AEScrollIntoView(2)" ><img src="../../eMO/images/BurialPermit.gif" border=0 id=dis2></a></a></td></tr>
</table> -->
<table cellspacing='0' cellpadding='2' width='95%' border=0 align='center'>
<tr><!-- // ALIGNMENT Changed Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg -->
<td class='LABEL' width='20%'>&nbsp;&nbsp;<fmt:message key="eMO.ClaimantType.label" bundle="${mo_labels}"/></td>
<td class='fields' width='30%'><select name='CLAIMANT_TYPE' id='CLAIMANT_TYPE'   onchange="getClaimant(this,'<%=claimant_type_code%>');" onfocus="" >
			 <option value='' >--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
			 
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

			if(claimant_type.equals("U")){%>
			 <option value='U' selected><fmt:message key="eMO.UnderTaker.label" bundle="${mo_labels}"/></option>
		     <%}else{%>
			 <option value='U' ><fmt:message key="eMO.UnderTaker.label" bundle="${mo_labels}"/></option>
			 <%}
		  	if(claimant_type.equals("R")){%>
		   <option value='R' selected><fmt:message key="eMO.ReligiousOrgn.label" bundle="${mo_labels}"/></option>
		     <%}else{%>
			   <option value='R' ><fmt:message key="eMO.ReligiousOrgn.label" bundle="${mo_labels}"/></option>
			 <%}
			  
			 if(claimant_type.equals("O")){%>
			 <option value='O' selected><fmt:message key="Common.others.label" bundle="${common_labels}"/></option>
		     <%}else{%>
			<option value='O' ><fmt:message key="Common.others.label" bundle="${common_labels}"/></option>
			 <%}if(claimant_type.equals("F")){%>
					 <option value='F' selected><fmt:message key="eMO.ReleasedToOtherFacility.label" bundle="${mo_labels}"/></option>
				 <%}else{%>
					<option value='F' ><fmt:message key="eMO.ReleasedToOtherFacility.label" bundle="${mo_labels}"/></option>
				 <%}%>-->
			
     </select>
       
   </td>
 
   <td class='LABEL' width='25%'><fmt:message key="eMO.Claimant.label" bundle="${mo_labels}"/></td>
   <td class='fields' width='25%'><select name='CLAIMANT_TYPE_CODE' id='CLAIMANT_TYPE_CODE' onchange="set_values(this,'<%=patient_id%>');">
  <option value=''>&nbsp;&nbsp;&nbsp;----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----&nbsp;&nbsp;&nbsp;
  </select>&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center' id=id3 style="visibility:hidden"></img>
  </td>
  </tr>
  <tr>
	  <td class='LABEL' width='25%' colspan='3'>
	  <td class='fields' width='25%'><INPUT TYPE="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.CopyDetails.label","mo_labels")%>" name=copydet disabled onClick="copyDet('<%=patient_id%>')"class=button></td>
  </tr>
  <!--Added by Shanmukh on 25th-JUNE-2018 for ML-MMOH-CRF-1031-->		
  <%if(isChangeOfDateTimeClaimingAppl){%>
	<tr>
		<td class='LABEL' width='25%'>&nbsp;&nbsp;<fmt:message key="eMO.DateTimeOfClaiming.label" bundle="${mo_labels}"/></td>
		<td class='fields' width='25%'><input type='text' size='16' maxlength='16' name='body_claiming_date_time' id='body_claiming_date_time' <%if(mode.equals("insert")){%>value=''<%}else{%>value='<%=body_claiming_date_time%>'<%}%> onblur='validate1(this)'><img src='../../eCommon/images/CommonCalendar.gif' id='otdatetime1'  name='OTDate1' onClick="return showCalendar('body_claiming_date_time',null,'hh:mm');document.forms[0].body_claiming_date_time.select();" <%if(mode.equals("viewdata")){%>disabled <%}%>style="cursor='hand'" ><img src='../../eCommon/images/mandatory.gif'></img></td>
	</tr>
	<%}%>
	
	<table cellspacing='0' cellpadding='0' width='95%' border=0 align='center'>
	<tr><td valign=top width='50%'>
	<table cellspacing='0' cellpadding='0' width='95%' border=0 align='center'>
   <tr><td class='LABEL' width='20%'><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
   <!--Below line added for ML-MMOH-CRF-0887.1-->
 <td class='fields' width='30%'><%if(increasedaddressLength){%>
				   <textarea name='NAME' rows=3 maxlength=80 cols=45 onblur='makeValidString(this); maxLengthPaste1(this);' onkeypress='checkMaxLimit(this,80)' onkeyup='RemoveSpecialChar(this)'><%=name%></textarea>
			      <%}else{%>						
				  <input type="text" name="NAME" id="NAME"  maxlength='30' size='20'  value="<%=name%>" ></td>
				  <%}%>
				  </tr>
 <tr>
  <!-- // ALIGNMENT Changed Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg -->
  <td class='LABEL' width='20%'><fmt:message key="Common.relationship.label" bundle="${common_labels}"/></td>
	<td class='fields' width='30%'><select name='RELATIONSHIP' id='RELATIONSHIP' ><option value="">-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ----------</option>
  <% pstmt2  = con.prepareStatement("select RELATIONSHIP_CODE,SHORT_DESC from MP_RELATIONSHIP_LANG_vw where LANGUAGE_ID='"+locale+"' and eff_status='E' order by 2");
	 
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
	<!-- // ALIGNMENT Changed Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg -->
	<tr>
	<!--Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743-->
	<%if(!isClaimantChngsApplicable){%>
	<td class='LABEL' width='20%'><%=nat_id_prompt%>&nbsp;</td>
	<%}else{%>
	<td class='label'width='20%'><fmt:message key="eMO.MyKad.label" bundle="${mo_labels}"/></td>
	<%}%>
	<td class='fields' width='30%'>
	<input type="text" name="NAT_ID_NO" id="NAT_ID_NO"  maxlength='<%=nat_id_length%>' size='20'  value='<%=nat_id_no%>' >
	</td>
	</tr>	
  <%}else{%>
<input type=hidden name=NAT_ID_NO value="">
	
<%	}%>	<!-- // ALIGNMENT Changed Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg -->


<tr><td  class='LABEL' width='20%'><fmt:message key="Common.EmployeeID.label" bundle="${common_labels}"/></td>
<td class='fields' width='30%'>   <input type="text" name="PATIENT_EMPLOYEE_ID" id="PATIENT_EMPLOYEE_ID"  maxlength='20' size='20'  value='<%=patient_employee_id%>' >
</td></tr>

<%if(isClaimantChngsApplicable){%>
<tr><td  class='LABEL' width='20%'><fmt:message key="eMP.PassportNo.label" bundle="${mp_labels}"/></td>
<td class='fields' width='30%'>   <input type="text" name="PASSPORT_NO" id="PASSPORT_NO" onBlur='validSplchars(this);' onKeyPress="return SpCharChkForPassportNo(event);" maxlength='15' size='15'  value='<%=Passport_No%>' >
</td></tr>
<tr><td  class='LABEL' width='20%'><fmt:message key="eMO.OtherId.label" bundle="${mo_labels}"/></td>
<td class='fields' width='30%'>   <input type="text" name="OTHER_IDENTIFICATION" id="OTHER_IDENTIFICATION"  maxlength='60' size='30'  value='<%=Other_Identification%>' >
</td></tr>
<%}%>
  	
<!-- // ALIGNMENT Changed Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg -->
<!--Below line added for this CRF ML-MMOH-CRF-0860.2-->
<tr><td class='LABEL' width='20%'><fmt:message key="eMP.occupation.label" bundle="${mp_labels}"/></td>
<td class='fields' width='30%'><input type="text" name="JOB_TITLE" id="JOB_TITLE"  maxlength='<%=maximumLength%>' size='<%=maxsize%>'  value='<%=job_title%>' ></td>
  </tr>	
<!-- // ALIGNMENT Changed Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg -->
<!--Below line added for this CRF ML-MMOH-CRF-0860.2-->
<tr><td class='LABEL' width='20%'><fmt:message key="Common.orgName.label" bundle="${common_labels}"/></td>
<td class='fields' width='30%'><input type="text" name="ORGANIZATION_NAME" id="ORGANIZATION_NAME"  maxlength='<%=maximumLength%>' size='<%=maxsize%>'  value='<%=organization_name%>' ></td>
</tr>
<%if(!ocpn_class_desc.equals("")){%>
<!-- // ALIGNMENT Changed Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg -->
<tr><td class='LABEL' width='20%' id='hed1' ><fmt:message key="eMP.OccupationClass.label" bundle="${mp_labels}"/></td>
<td class='fields' width='30%'><label id=ocpnlab class=label><b><%=ocpn_class_desc%></b></td>
</tr>
<%}else{%><!-- // ALIGNMENT Changed Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg -->
<tr><td class='LABEL' width='20%' id='hed1' >&nbsp</td>
<td class='fields' width='30%'><label id=ocpnlab></td>
</tr>
<%} if(!mode.equals("insert") && claimant_type.equals("F")){ 
releasefacility = "visibility:visible";
}
%>
<!-- // Filed Newly Added Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg -->
<tr>
<td class="label" width='20%' id='releasefacid'style="<%=releasefacility%>"><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
<td class="fields" width='30%' id='releasefacdesc'style="<%=releasefacility%>"><select name='RELEASE_TO_FACILITY' id='RELEASE_TO_FACILITY'>
<!--option value=''>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option-->
 <% pstmt2  = con.prepareStatement("select b.FACILITY_ID facility_id ,a.FACILITY_NAME facility_name from SM_FACILITY_PARAM a,sm_modules_facility b where a.facility_id = b.facility_id and b.module_id = 'MO'and a.facility_id!='"+facilityId+"' order by 2");

				 vrs = pstmt2.executeQuery();
				 while(vrs.next())
				  {
					 release_fac_id= vrs.getString("facility_id");
					 
					 release_fac_desc= vrs.getString("facility_name");
							// out.println("<script>alert('release_fac_desc---- :"+release_fac_desc+"')</script>");%>
					 <option value='<%=release_fac_id%>'><%=release_fac_desc%> </option>		
					<%if((!mode.equals("insert"))&&release_fac_id.equals(RELEASE_TO_FACILITY))
					{%><option value='<%=release_fac_id%>' selected><%=release_fac_desc%> </option>
						 <%}
}%></select></td></tr> 
 <tr>
<td class="label" width='20%' id='remarksid' style="<%=releasefacility%>"><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>&nbsp;
<td class="fields" width='30%' id='remarksdesc' style="<%=releasefacility%>"><textarea name='reason_desc' rows='5' cols='40'  onKeyPress='checkMaxLimit(this,100);' onpaste='return maxLengthPaste(this,"100");' onBlur='return maxLength(this,"100");'>
<%=reason_deceased_desc%></textarea>
							
</td></tr>
<!--  Saanthaakumar  Bru-HIMS-CRF-366 [IN:039612] End-->
  </table>
		   </td>  
			  <td><table cellspacing='0' cellpadding='0' border='0'>
				<tr><td colspan=8 class=label height=5></td></tr>
              <table cellspacing='0' cellpadding='0' border="0">
               <tr><td colspan=8 class=label height=5></td></tr>

				<%

	ArrayList contact_addr= fetchContactAddresses(con,out,"parent.parent.messageFrame",propertiesBill) ;
	contact_col_names		= (String[])contact_addr.get(1) ;
	contact_prompts			= (String[])contact_addr.get(2) ;
    contact_fields			= (String[])contact_addr.get(3) ;
	contact_addr				= null;






   /* code for displaying address fields and postal code*/
		tabIndex++;
		out.println("<tr>") ; 
		StringBuffer sb2 = new StringBuffer() ;
		StringBuffer sb12 = new StringBuffer() ;
		StringBuffer sba2 = new StringBuffer() ;
		StringBuffer sbar2 = new StringBuffer();
        StringBuffer fieldVal2 = new StringBuffer("");
                    for(int i=0;i<contact_col_names.length; i++)
                            {
                                  String  val = contact_fields[i] ;
								  sb2.append(val);
                                   int j=0 ;
								   int j1 = 0;
                                   String old_val = "" ;
                                   String new_val = "" ;
                                     
                                     if(contact_col_names[i].equalsIgnoreCase("addr_line1_prompt"))
                                     {
                                        old_val = "r_addr_line1" ;
                                        new_val = "addr_line_1" ;
										     
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("addr_line2_prompt"))
                                     {
                                        old_val = "r_addr_line2" ;
                                        new_val = "addr_line_2" ;
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("addr_line3_prompt"))
                                     {
                                        old_val = "r_addr_line3" ;
                                        new_val = "addr_line_3" ;
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("addr_line4_prompt"))
                                     {
                                        old_val = "r_addr_line4" ;
                                        new_val = "addr_line_4" ;
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("res_town_prompt"))
                                     {
                                        old_val = "r_town_code" ;
                                        new_val = "m_town_code" ;
									 }//Added by kumar on 13/03/2003 for region 
									 else if(contact_col_names[i].equalsIgnoreCase("region_prompt"))
                                     {
                                        old_val = "r_region_code" ;
                                        new_val = "m_region_code" ;
                                     }
									 else if(contact_col_names[i].equalsIgnoreCase("res_area_prompt"))
                                     {
                                        old_val = "r_area_code" ;
                                        new_val = "m_area_code" ;
                                     }                                     
                                     else if(contact_col_names[i].equalsIgnoreCase("postal_code_prompt"))
                                     {
                                        old_val = "r_postal_code" ;
                                        new_val = "m_postal_code" ;
                                     }
									out.println("<td class='label'  >"+contact_prompts[i]+"</td>") ;	
                                    while(val.indexOf(old_val) != -1)
                                    {
                                        j = val.indexOf(old_val,j) ;
                                        sb2 = sb2.replace(j,(j+old_val.length()),new_val);
                                        val = sb2.toString();
                                    }
             // Newly added
			if(contact_col_names[i].equalsIgnoreCase("res_town_prompt")) {
				sba2.append(val);
				while(val.indexOf("r_postal_code") != -1) {
					j1 = val.indexOf("r_postal_code",j1) ;
					sba2 = sba2.replace(j1,(j1+"r_postal_code".length()),"m_postal_code");
					val = sba2.toString();
				}
			}
			if(contact_col_names[i].equalsIgnoreCase("res_area_prompt")) {
				j1 = 0;
				sbar2.append(val);
				while(val.indexOf("r_postal_code") != -1) {
					j1 = val.indexOf("r_postal_code",j1) ;
					sbar2 = sbar2.replace(j1,(j1+"r_postal_code".length()),"m_postal_code");
					val = sbar2.toString();
				}
			}
								   sb12.append(val);
									for(int z=0;z<val.length();z++)
									{
										String tempVal=sb12.substring(z,z+1);
										if(tempVal.equals("@"))
										{
											fieldVal2.append(++tabIndex);
										}
										else
										{
											fieldVal2.append(tempVal);
										}
									}
                                    val = fieldVal2.toString();
                                    out.println("<td class='fields'>"+val) ;
									
						   out.println("</td>");
						 //  out.println("<td class='label'  colspan='2'>&nbsp;</td>");
						   out.println("</tr>") ;
						   sb12.delete(0,sb12.length());
						   fieldVal2.delete(0,fieldVal2.length());
						   sb2.delete(0,sb2.length());
						   sba2.delete(0,sba2.length());
						   sbar2.delete(0,sbar2.length());
                            } 
								

					
		       %>  
	<tr>
	<%

        String sq3 = "select short_name from mp_country_lang_vw  where language_id='"+locale+"' and country_code = '"+country_code+"'";

		pstmt2  = con.prepareStatement(sq3);
        vrs = pstmt2.executeQuery();
        
		
		while( vrs.next())
		{
			kcou=checkForNull(vrs.getString("short_name"));
		
        }%>			       
   	    <tr>
		  <td class='LABEL' width='25%'><fmt:message key="Common.country.label" bundle="${common_labels}"/></td>
         <td class='fields' width='25%' ><input type='text' onBlur="searchCountry1(this,COUNTRY_DESC)" name='COUNTRY_DESC' id='COUNTRY_DESC' size='15' value="<%=kcou%>"  maxlength='15'  ><input type='button' name='cntrysrh'  value='?' id='cntrysrh' class='button' onclick="searchCountry(this,COUNTRY_DESC)" >	   </td>
          </tr>
          <tr>
              <td class='LABEL' width='25%'><fmt:message key="Common.homephoneno.label" bundle="${common_labels}"/></td>
              <td class='fields' width='25%' ><input type='text' name='TELEPHONE_RES' id='TELEPHONE_RES' maxlength='20' size='20'  onblur=''    value ="<%=telephone_res%>"></td>
		  </tr>
          <tr>
              <td class='LABEL' width='25%'><fmt:message key="eMO.MobilePhoneNo.label" bundle="${mo_labels}"/></td>
              <td class='fields' width='25%' ><input type='text' name='MOB_TEL_NO' id='MOB_TEL_NO' maxlength='20' size='20'  onblur='' value ="<%=mob_tel_no%>"></td>
		  <tr>
			  <td class='LABEL' width='25%'><fmt:message key="Common.officephoneno.label" bundle="${common_labels}"/></td>
              <td class='fields' width='25%'><input type='text' name='TELEPHONE_OFF' id='TELEPHONE_OFF' maxlength='20' size='20'  onblur=''  value ="<%=telephone_off%>"></td>
          </tr>
		  <tr>
		      <td class='LABEL' width='25%'><fmt:message key="Common.email.label" bundle="${common_labels}"/></td>
              <td class='fields' width='25%'><input type='text' name='EMAIL_ID' id='EMAIL_ID'  onBlur='document.getElementById("tab2").scrollIntoView();document.getElementById("CLAIMANT_TYPE").focus()'maxlength='50' size='30'     value = "<%=email_id%>"></td>
          </tr></td></tr>
		  <tr><td colspan=6 class=label height=5></td></tr></table></table>



  
  
  </table>

	
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

  <a name="tab3" id='tab3' ></a> 
   <table cellspacing='0' cellpadding='0' style="margin-top:-413px;" width='95%' border=0 align='center'>
       <tr><td class='white'>
		 <ul id="tablist" class="tablist" >
			<li class="tablistitem" title="Registration Details">
				<a onclick="tab_click1('RegDtl_tab')" class="tabA" id='RegDtl_tab' >
					<span class="tabAspan" id="RegDtl_tabspan"><fmt:message key="Common.Registration.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.details.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			<!--Added by Ashwini on 17-Oct-2017 for ML-MMOH-CRF-0696-->
			<%if(rearrangeTabBurlPermtClaimnt){%>
			<li class="tablistitem" title="Burial Permit" id='bp3'>
				<a onclick="tab_click1('burialPermit_tab')" class="tabClicked" id="burialPermit_tab" >
					<span class="tabSpanclicked" id="burialPermit_tabspan"><fmt:message key="eMO.BurialPermit.label" bundle="${mo_labels}"/></span>
				</a>
			</li>
			<li class="tablistitem" title="Claimant">
				<a onclick="tab_click1('claimant_tab')" class="tabA" id="claimant_tab" >
					<span class="tabAspan" id="claimant_tabspan"><fmt:message key="eMO.Claimant.label" bundle="${mo_labels}"/></span>
				</a>
			</li>
			<%}else{%>
			<li class="tablistitem" title="Claimant">
				<a onclick="tab_click1('claimant_tab')" class="tabA" id="claimant_tab" >
					<span class="tabAspan" id="claimant_tabspan"><fmt:message key="eMO.Claimant.label" bundle="${mo_labels}"/></span>
				</a>
			</li>
			<li class="tablistitem" title="Burial Permit" id='bp3'>
				<a onclick="tab_click1('burialPermit_tab')" class="tabClicked" id="burialPermit_tab" >
					<span class="tabSpanclicked" id="burialPermit_tabspan"><fmt:message key="eMO.BurialPermit.label" bundle="${mo_labels}"/></span>
				</a>
			</li>
			<%}%>
		 </ul>
       </td></tr>
	</table>

<!-- <a name='kin'></a>
<a name="tab3"  onFocus='javascript:AEScrollIntoView(3);'></a> 
<table width='100%' cellpadding='0'   cellspacing='0' BORDER='0'><tr><td width='1%' class='BODYCOLORFILLED'></td><td width='50%' class='BODYCOLORFILLED'>&nbsp;<a align ='left' href="javascript:AEScrollIntoView(1)"><img src="../../eMO/images/RegistrationDetails.gif" border=0></a><a align='left' href="javascript:AEScrollIntoView(3)"  ><img src="../../eMO/images/Claimant.gif" border=0></a><a align='left' href="javascript:AEScrollIntoView(2)" ><img src="../../eMO/images/BurialPermitClick.gif" border=0 id=dis3></a></td></tr>

</table> -->
  <table border="0" cellpadding="3" cellspacing="0" align='center' width='95%'>
  <tr><td class='LABEL' width='25%'colspan=2></td></tr>
	<%
	 if(burial_perm_no.equals("")&&(!mode.equals("viewdata"))){%>
	 <tr>
		<td class='LABEL' width='25%'><fmt:message key="eMO.GenerateBurialPermitNo.label" bundle="${mo_labels}"/></td>
		<td class='fields' width='25%'><INPUT TYPE="checkbox" name="generate_burial_permit" id="generate_burial_permit"  onClick='enterBurial(this)'> </td> 
	</tr> 
	<%}else{%>
	<INPUT TYPE="hidden" name="generate_burial_permit" id="generate_burial_permit">
	<%}%>
	<tr><!--maxlength="99" canged to max_size_burial_permit_no, Added by santhosh for ML-MMOH-CRF-1947-->
		<td class='LABEL' width='25%'><fmt:message key="eMO.BurialPermitNumber.label" bundle="${mo_labels}"/>&nbsp;</td>
		<td class='fields' width='25%'><input type='text' size='16' maxlength="<%=max_size_burial_permit_no%>" name='body_burial_permit_no' value='<%=burial_perm_no%>' onKeyPress="return CheckForSpecCharsLocal(event);" >&nbsp;<img src='../../eCommon/images/mandatory.gif' id='bdbr1'></img> </td> 
	</tr>
	<!--Below line added for this CRF ML-MMOH-CRF-0695-->
	<%if(!isChangeOfDateTimeClaimingAppl){%>
	<tr>
		<td class='LABEL' width='25%'><fmt:message key="eMO.DateTimeOfClaiming.label" bundle="${mo_labels}"/></td>
		<td class='fields' width='25%'><input type='text' size='16' maxlength='16' name='body_claiming_date_time' id='body_claiming_date_time' value='<%=body_claiming_date_time%>' onblur='validate1(this)' <%=datetimeofclaiming%>><%if(!datetimeofclaimingApplicable){%><img src='../../eCommon/images/CommonCalendar.gif' id='otdatetime1'  name='OTDate1' onClick="document.forms[0].body_claiming_date_time.select();return showCalendar('body_claiming_date_time',null,'hh:mm');" style="cursor='hand'" <%=datetimeofclaiming%> >&nbsp;<img src='../../eCommon/images/mandatory.gif' id='bdbr2'></img><%}%></td>
	</tr>
	<%}%>
	<!--End this CRF ML-MMOH-CRF-0695-->
	<tr>	
		<td class='LABEL' width='25%'><fmt:message key="eMO.VehicleNumber.label" bundle="${mo_labels}"/>&nbsp;</td>
		<td class='fields' width='25%'><INPUT TYPE="text" name="vechile_no" id="vechile_no"  maxlength=30 value='<%=vechile_no%>' ></td> 
	</tr>
	<tr>	
		<td class='LABEL' width='25%'><fmt:message key="eMO.BurialPermitApprovedBy.label" bundle="${mo_labels}"/>&nbsp;</td>
	
		<td class='fields' width='25%'>
		  <!-- isRemoveMandBPermitAppBy condition Added by Dharma on 2oth July against ML-MMOH-CRF-0692 [IN:062311]-->
		 <%if(!isRemoveMandBPermitAppBy){%>
			<input type="text" name="burial_permit_app_desc" id="burial_permit_app_desc" value="<%=burial_permit_appr_by_name%>" size="30" maxlength="30" onBlur='beforeGetPractitioner(document.forms[0].pract_id,burial_permit_app_desc);' <%=readText%>><input type='button' id='disbur' name='pract_id' id='pract_id' value='?' class='button' onclick='searchCode(this, burial_permit_app_desc)' <%=disablebut%>><input type='hidden' name='burial_permit_app_by' id='burial_permit_app_by' value ='<%=burial_perm_by%>'>&nbsp;<img src='../../eCommon/images/mandatory.gif' id='bdbr3'></img>
		<%}else{%>
			<!--Modified by Ashwini on 01-Jul-2019 for ML-MMOH-CRF-0990-->
			<input type='text' name='burial_permit_app_by' id='burial_permit_app_by' value="<%=burial_permit_appr_by_name%>" size="60" maxlength="60" <%=readText%>/>
			<input type='hidden' name="burial_permit_app_desc" id="burial_permit_app_desc" value=""/>
			<input type='hidden' name='pract_id' id='pract_id' value='' />
		<%}%>
		</td> 
	</tr>
	<tr>
		<td class='LABEL' width='25%'><fmt:message key="Common.BurialPermitApprovedDate.label" bundle="${common_labels}"/>&nbsp;</td>
		<td class='fields' width='25%'><input type='text' size='16' maxlength='16' name='burial_app_date' id='burial_app_date' onfocus='' value='<%=DateUtils.convertDate(burial_perm_date,"DMYHM","en",locale)%>' onblur='validate1(this);document.getElementById('tab3').scrollIntoView()'  <%=readText%>><img id='disburdate' src="../../eCommon/images/CommonCalendar.gif"   onClick="document.forms[0].burial_app_date.select();return showCalendar('burial_app_date', null, 'hh:mm' )"; <%=disablebut%> style="cursor='hand'">&nbsp;<img src='../../eCommon/images/mandatory.gif' id='bdbr4'></img></td>	
		</tr>
  <tr><td class='LABEL' width='25%'colspan=2></td></tr>
</table>

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>



<input type='hidden' name='mode' id='mode' value = '<%=mode%>'>
<input type='hidden' name='facilityId' id='facilityId' value="<%=facilityId%>">
<input type='hidden' name='regno' id='regno' value='<%=regno%>'>
<input type='hidden' name='patient_class' id='patient_class' value='EM'>
<input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>'>

<input type='hidden' name='pol_rep_no' id='pol_rep_no' value='<%=pol_rep_no%>'>
<input type='hidden' name='pol_stn_id' id='pol_stn_id' value='<%=pol_stn_id%>'>
<input type='hidden' name='pol_id' id='pol_id' value='<%=pol_id%>'>
<input type='hidden' name='police_details' id='police_details' value="<%=police_details%>">
<input type='hidden' name='police_approval_received_yn' id='police_approval_received_yn' value='<%=police_approval_received_yn%>'>
<input type='hidden' name='police_received_by' id='police_received_by' value='<%=police_received_by%>'>
<input type='hidden' name='police_received_date' id='police_received_date' value='<%=police_received_date%>'>
<!--Added by Thamizh selvi on 3rd Aug 2017 for ML-MMOH-CRF-0689 Start-->
<input type='hidden' name='pol_officer_name' id='pol_officer_name' value='<%=pol_officer_name%>'>
<input type='hidden' name='pol_contact_no' id='pol_contact_no' value='<%=pol_contact_no%>'>
<input type='hidden' name='externalBodyPartYn' id='externalBodyPartYn' value='<%=externalBodyPartYn%>'>
<input type='hidden' name='calledFrom' id='calledFrom' value='<%=calledFrom%>'>
<input type='hidden' name='policeDtlsMandYn' id='policeDtlsMandYn' value='<%=policeDtlsMandYn%>'>
<!--End-->

<!-- <input type='hidden' name='bodypart' id='bodypart' value=""> -->		 
<input type='hidden' name='consent_form_code' id='consent_form_code' value='<%=consent_form_code%>'>
<input type='hidden' name='consent_desc' id='consent_desc' value=''>


<input type='hidden' name='conscentgivenby' id='conscentgivenby' value='<%=consent_given_by%>'>
<input type='hidden' name='deceasedrelationship' id='deceasedrelationship' value='<%=relationship_with_deceased%>'>		 
<input type='hidden' name='consent_received_by' id='consent_received_by' value='<%=consent_form_received_by%>'>
<input type='hidden' name='consent_received_date' id='consent_received_date' value="<%=consent_form_received_date%>">
<input type='hidden' name='system_date' id='system_date' value="<%=sys_date%>">
             <!-- donar details -->

<!-- //consent for donar -->






<input type='hidden' name='consent_form_code1' id='consent_form_code1' value="<%=consent_form_code1%>">
<input type='hidden' name='consent_desc1' id='consent_desc1' value=''>		 
	<!-- <input type='hidden' name='RELATIONSHIP' id='RELATIONSHIP' value='<%=relationship%>'>		  -->
	
<input type='hidden' name='conscentgivenby1' id='conscentgivenby1' value="<%=conscentgivenby1%>">
<input type='hidden' name='deceasedrelationship1' id='deceasedrelationship1' value="<%=deceasedrelationship1%>">
<input type='hidden' name='consent_received_by1' id='consent_received_by1' value="<%=consent_received_by1%>">
<input type='hidden' name='consent_received_date1' id='consent_received_date1' value="<%=consent_received_date1%>">
<input type='hidden' name='ZIP_CODE' id='ZIP_CODE' value="<%=zip_code%>">
<input type='hidden' name='COUNTRY_CODE' id='COUNTRY_CODE' value="<%=country_code%>">
<input type='hidden' name='regn_no' id='regn_no' value="<%=regn_no%>">
<input type='hidden' name='consent_received_desc2' id='consent_received_desc2' value="<%=consent_form_recd_by_name2%>">
<input type='hidden' name='consent_received_desc' id='consent_received_desc' value="<%=consent_form_recd_by_name%>">
<input type='hidden' name='deceased_date' id='deceased_date' value="<%=deceased_date%>">
<input type='hidden' name='startendstat' id='startendstat' value="<%=postmortem_startend_status%>">
<input type='hidden' name='police_approval_received_by_desc' id='police_approval_received_by_desc' value="<%=police_approval_received_by_desc%>">
<input type='hidden' name='encounter_id' id='encounter_id' value="<%=encounter_id%>">
<input type='hidden' name='organ' id='organ' value="">
<input type='hidden' name='area1' id='area1' value='<%=res_area_code%>'>
<input type='hidden' name='town1' id='town1' value='<%=res_town_code%>'>
<input type='hidden' name='region1' id='region1' value='<%=region_code%>'>
<input type='hidden' name='obt_from' id='obt_from' value='<%=obt_from%>'>
<input type='hidden' name='patientid' id='patientid' value='<%=patientid%>'>
<input type='hidden' name='burial_permit_reqd_yn' id='burial_permit_reqd_yn' value='<%=burial_permit_reqd_yn%>'>



 <input type='hidden' name='m_town' id='m_town' value='<%=res_town_code%>'>
<input type='hidden' name='m_area' id='m_area' value='<%=res_area_code%>'>
<input type='hidden' name='m_region' id='m_region' value='<%=region_code%>'>
<input type='hidden' name='m_postal_code' id='m_postal_code' value='<%=postal_code%>'>

<INPUT TYPE="hidden" name="town_code1" id="town_code1">
<INPUT TYPE="hidden" name="area_code1" id="area_code1">
<INPUT TYPE="hidden" name="region_code1" id="region_code1">
<!-- <INPUT TYPE="hidden" name="postal_code" id="postal_code" value=''> -->
<input type='hidden' name='isRemoveMandBPermitAppBy' id='isRemoveMandBPermitAppBy' value ='<%=isRemoveMandBPermitAppBy%>'> <!--Added by Dharma on 2oth July against ML-MMOH-CRF-0692 [IN:062311]-->

<!--Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743-->
<input type='hidden' name='isClaimantChngsApplicable' id='isClaimantChngsApplicable' value ='<%=isClaimantChngsApplicable%>'>
<!--Below line added for this CRF ML-MMOH-CRF-0695-->
<input type='hidden' name='datetimeofclaimingApplicable' id='datetimeofclaimingApplicable' value ='<%=datetimeofclaimingApplicable%>'> 
<!--End this CRF ML-MMOH-CRF-0695-->	      

<!--Added by Ashwini on 08-Aug-2017 for ML-MMOH-CRF-0748-->
<input type='hidden' name='refTypeBrghtByPoliceDisable' id='refTypeBrghtByPoliceDisable' value ='<%=refTypeBrghtByPoliceDisable%>'>

<!--Added by Ashwini on 17-Oct-2017 for ML-MMOH-CRF-0696-->
<input type='hidden' name='rearrangeTabBurlPermtClaimnt' id='rearrangeTabBurlPermtClaimnt' value ='<%=rearrangeTabBurlPermtClaimnt%>'> 
<!--Added by Shanmukh on 25th-JUNE-2018 for ML-MMOH-CRF-1031-->	
<input type='hidden' name='isChangeOfDateTimeClaimingAppl' id='isChangeOfDateTimeClaimingAppl' value ='<%=isChangeOfDateTimeClaimingAppl%>'>         
<input type='hidden' name='isReceivedDateTimeAppl' id='isReceivedDateTimeAppl' value ='<%=isReceivedDateTimeAppl%>'> 

<!--Added by Ashwini on 11-Oct-2018 for ML-MMOH-CRF-1095-->
<input type='hidden' name='function_id' id='function_id' value ='<%=function_id%>'> 
<input type='hidden' name='claimant_type_mstr' id='claimant_type_mstr' value='<%=claimant_type%>'>
      
	
 
<%
	if(mode.equals("modify") || mode.equals("viewdata"))
    {%>
	<script>
	  onloadpopulate('<%=referral_type%>','<%=ref_source_code%>');
    </script>

     <script>
			  if(document.getElementById('m_town_code'))
			  document.getElementById('m_town_code').value='<%=res_town_desc%>';

		   if(document.getElementById('m_area_code'))
			  document.getElementById('m_area_code').value='<%=res_area_desc%>';

		    if(document.getElementById('m_region_code'))
			  document.getElementById('m_region_code').value='<%=region_desc%>';
				
				 if(document.getElementById('m_postal_code1'))
			  document.getElementById('m_postal_code1').value='<%=zip_code_desc%>';


			 if(document.getElementById('addr_line_1'))
			  document.getElementById('addr_line_1').value='<%=addrl1%>';

			  if(document.getElementById('addr_line_2'))
			  document.getElementById('addr_line_2').value='<%=addrl2%>';

			   if(document.getElementById('addr_line_3'))
			  document.getElementById('addr_line_3').value='<%=addrl3%>';

			    if(document.getElementById('addr_line_4'))
			  document.getElementById('addr_line_4').value='<%=addrl4%>';

			
	 </script>



<%
		}
   if(vpstmt!=null) vpstmt.close();
   if(sstat!=null) sstat.close();
   if(pstmt2!=null)  pstmt2.close();
   if(vrs!=null) vrs.close(); 
		  
		  
		  
		  
		
		  
		  }catch(Exception e)
    {
        out.print("Exceptin in File MORegisterAttnResult.jsp"+e.toString());
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
 function maxLengthPaste(obj)
 { 
	var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
	if (obj.getAttribute && obj.value.length>mlength)
	{
    	var errors1 = getMessage("EXCEED_MAX_LENGTH", "Sm",null);
        alert(errors1);	
		obj.value=obj.value.substring(0,mlength);
	}
 }
	/*Bru-HIMS-CRF-366 [IN:039612] */
	</script>

