<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,com.ehis.util.*"   contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html> 
<title><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></title>
<style>
.table-data{
 width:100%;
 height: 600px;
 overflow:scroll;
}
</style>
<style>
textarea {
  resize: none;
}
</style>
<head>
 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>


	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
    <link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
    <%@ include file="../../eMP/jsp/PatientAddressLegends.jsp"%>
    <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
  	<script language='javascript' src='../../eCommon/js/common.js'></script>
    <script language='javascript' src='../../eCommon/js/dchk.js'></script>
    <script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
    <script language='javascript' src='../../eAE/js/AEPatientHistory.js'></script>
  <script language='javascript' src='../../eCommon/js/DateUtils.js'> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 

	  <script>
  function tab_click(objName)
	{
		   if(objName=="addVisit_tab")
			{
				document.getElementById('tab1').scrollIntoView();
			}
		   if(objName=="arrival_tab")
			{
				document.getElementById('tab2').scrollIntoView();
			}
			if(objName=="rlcnts_tab")
			{
				document.getElementById('tab3').scrollIntoView();
			}
			if(objName=="#kin1") 
			{

				document.getElementById('kin1').scrollIntoView();
			}
			if(objName=="#empyr")
			{
				document.getElementById('empyr').scrollIntoView();
			}
	}
	function tab_click1(id) 
		{
			selectTab(id);
			tab_click(id);
		}

		function tab_click2(id,idval){
				selectTab(idval);
				tab_click22(id);
		}

		function tab_click22(Object)
		{
			if(Object=='#kin')
			{
				 document.getElementById('tab3').scrollIntoView();
			}
			if(Object=='#kin1')
			{
				   document.getElementById('kin1').scrollIntoView();
			}
			if(Object=='#empyr')
			{
				  document.getElementById('empyr').scrollIntoView();
			}
		}


  </script>

</head> 
 
<%
        Connection con					=	null;
		PreparedStatement pstmt		=	null;
        ResultSet rset						=	null;
		//String locale				= (String)session.getAttribute("LOCALE");
   try{
	   	request.setCharacterEncoding("UTF-8");
	    String locale			= (String)session.getAttribute("LOCALE");
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String[] contact_col_names		=	null;
		String[] contact_prompts		=	null;
		//String[] contact_fields			=	null;
		String[] address_col_names=	{"ADDR_LINE1_PROMPT","ADDR_LINE2_PROMPT","ADDR_LINE3_PROMPT","ADDR_LINE4_PROMPT","RES_AREA_PROMPT","RES_TOWN_PROMPT","REGION_PROMPT","POSTAL_CODE_PROMPT"};
		con = ConnectionManager.getConnection(request);
		ArrayList contact_addr = fetchContactAddresses(con, out,"parent.parent.messageframe",p) ;
		
		/*Below line(s) added by venkateshs against ML-MMOH-CRF-0354 [IN057191] */
	     boolean siteSpecific		=eCommon.Common.CommonBean.isSiteSpecific(con, "MR","MLC_TO_MEDICO_LEGAL_CASE"); 
	   /*end ML-MMOH-CRF-0354 [IN057191] */ 
		 Boolean isLabelChngAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AE","LABEL_CHG_BR_DEAD_PLACE_ACCDNT"); //Added by Ashwini on 18-Jan-2017 for GDOH-CRF-0131 and GDOH-CRF-0123
		 Boolean isAENextofKinchngAppl   = eCommon.Common.CommonBean.isSiteSpecific(con, "AE","AE_NEXT_OF_KIN_CHNG_APPL"); // Added by mujafar for ML-MMOH-CRF-0632
		 
		//Added by Ajay Hatwate for GHL-CRF-0650		
		Boolean isMLCAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"AE", "MLC_DTLS");
	   //Added for this CRF ML-MMOH-CRF-0860.2
	   String tab_width="97%";	  
       String header_width="25%";	
	   String data_width ="25%";	
       String data_word_wrap="";
       String header_data_word_wrap="";	
       String tab_width1="100%";
	   
	   String data_width1="";
	   String data_word_wrap1="";
	   
	   Boolean increasedaddressLength = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","INCREASED_ADDRESS_LINE_LENGTH");	   
	   if(increasedaddressLength){
	     tab_width="500px";
		 tab_width1="500px";
		 header_width="150px";
         data_width="350px";
		 data_word_wrap="word-wrap: break-word;width:350px";
		 header_data_word_wrap="word-wrap: break-word;width:150px";
		 
		 data_width1="600px";
		 data_word_wrap1="word-wrap: break-word;width:600px";
		   
		 
       }	   
	   //End ML-MMOH-CRF-0860.2
		 
		 
 
		try{
			for(int ij=0;ij<contact_addr.size();ij++){
				ij++;
				contact_col_names = (String[])contact_addr.get(ij) ;
												
				ij++;
				contact_prompts   = (String[])contact_addr.get(ij) ;								
				ij++;
			}
		}catch(Exception ex){
			out.println("Exception " + ex);
			ex.printStackTrace();
			
		}

		contact_addr = null;

		String nat_id_prompt            ="";
		String res2_tel_no ="";	
		String nationality				 ="";
		String national_id				 ="";
		String alternate_id				 ="";
		String blood_grp				 ="";
		String rh_factor				 ="";
		String clinic_name				 ="";
		String service					 ="";
		String visit_adm_date_time		 ="";
		String visit_type				 ="";
		String sub_service				 ="";
		String enc_type					 ="";
		String priority_zone			 = "";
		String priority_zone_desc		 = "";
		String treatment_area_code       = "";
		String treatment_area_code_desc  = "";
		String oth_alt_id_desc           = "";
		String oth_alt_id_no			 = "";
		String alt_id1_desc				 = "";	
		String legal_status              = "";
		String residency			     = "";	
		String bed_no				     = "";
		String disaster_yn               = "";
		String disaster_area_desc        = "";
		String contact1_birth_date       = "";	
		String disaster_type_desc        = "";
    /* below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] */
/*	String sql              ="";
	String color            ="";
	String green            ="";
	String red              ="";
    String yellow           ="";
    String unassigned       ="";*/	
	/* CRF  SKR-CRF-0021 [IN028173] end  */
        // variables for arrival details
		String facilityId			 = (String)session.getValue("facility_id");
		String patient_id			 = checkForNull(request.getParameter("Patient_ID"));
		String encounter_id			 = checkForNull(request.getParameter("EncounterId"));
		String arrival_mode			 = "";
		String brought_dead			 = "";
		String mlc_case				 = "";
		String escort_type			 ="";
		String escort_name			 ="";
		String relation				 ="";
		String escort_add_ln1		 ="";
		String escort_add_ln2		 ="";
		String escort_add_ln3		 ="";
		String escort_add_ln4		 ="";
		String escort_add_postal_code="";
		String escort_add_postal_desc="";
		String escort_tel_no		 ="";
		String escort_mv_reg_no		 ="";
		String escort_remarks		 ="";

        //variables for related contacts
		String relationship			 ="";
		String name					 ="";
		String employer_name		 ="";
		String first_to_notify_name	 ="";
		String job1_title			 ="";
		String job2_title			 ="";
		String addr1_line1			 ="";
		String addr1_line2			 ="";
		String addr1_line3			 ="";
		String addr1_line4			 ="";
		String addr2_line1			 ="";
		String addr2_line2			 ="";
		String addr2_line3			 ="";
		String addr2_line4			 ="";
		String addr3_line1			 ="";
		String addr3_line2			 ="";
		String addr3_line3			 ="";
		String addr3_line4			 ="";
		String postal1_code			 ="";
		String postal2_code			 =""; 
		String postal3_code			 ="";
		String postal1_desc			 ="";
		String postal2_desc		     ="";
		String postal3_desc		     ="";
		String country1_code		 ="";
		String country2_code		 ="";
		String country3_code		 ="";
		String res1_tel_no			 ="";
		String res3_tel_no			 ="";
		String off1_tel_no			 ="";
		String off2_tel_no			 ="";
		String off3_tel_no			 ="";
		String patient_employee_id	 ="";
		String ocpn_desc			 ="";
		String employee_status		 ="";
		String rel_pat_id            =""; // Added by mujafar for ML-MMOH-CRF-0632
         
	    //variables for A&E Details
		String escort_contcode       ="";
		String contact3_name         ="";
		//String height_unit			 ="";
		//String weight_unit			 ="";
		//String circumference_unit	 ="";
		String acc_desc		= "";
		String escort_oth_alt_id_no		= "";
		String ESCORT_NATIONAL_ID_NO		= "";
		String contact1_national_id_no		= "";
		String esc_region_desc		= "";
		String esc_town_desc		= "";
		String esc_area_desc		= "";
		String esc_oth_alt_id_desc		= "";
		String CONTACT1_MOB_TEL_NO		= "";
		String CONTACT1_EMAIL_ID		= "";
		String next_town		= "";
		String next_area		= "";
		String next_region		= "";
		String first_relation		= "";
		String CONTACT2_NATIONAL_ID_NO		= "";
		String first_region ="";
		String first_town ="";
		String first_area ="";
		String emp_town ="";
		String emp_area ="";
		String emp_region ="";
		String CONTACT2_MOB_TEL_NO ="";
		String CONTACT2_EMAIL_ID ="";
		String occ_desc ="";
		String occ_class ="";
		String referral_id   = "";
		String pat_priority  = "";
		
		/* Added by Ajay Hatwate for GHL-CRF-0650 */
		String mlcRem = "";
		String mlcCaptDate = "";
		String mlcOutDtls = "";
		String polRepNo = "";
		String polStnId = "";
		String mlcDeathYn = "";
		/* End of GHL-CRF-0650 */
		String five_level_triage_appl_yn	= "N";
		String sqlqry1	= "select five_level_triage_appl_yn from ae_param where OPERATING_FACILITY_ID='"+facilityId+"'";
		pstmt = con.prepareStatement(sqlqry1);
		rset = pstmt.executeQuery();
		
		while(rset!=null && rset.next()){
			five_level_triage_appl_yn			=	checkForNull(rset.getString("five_level_triage_appl_yn"));
		}
		if(pstmt!=null) pstmt.close();
		if(rset!=null) rset.close();

		
		
		StringBuffer  bloodDisp = new StringBuffer();
		bloodDisp.append("select patient_id, MR_GET_DESC.MR_BLOOD_GRP(BLOOD_GRP,'"+locale+"','2')  BLOOD_GRP_DESC, MR_GET_DESC.MR_RHESUS_FACTOR(RH_FACTOR,'"+locale+"','2') rh_factor_desc  from MP_PAT_OTH_DTLS  where PATIENT_ID =?");
    	 pstmt = con.prepareStatement(bloodDisp.toString());
		 pstmt.setString(1,patient_id);
		 rset = pstmt.executeQuery();
		 while(rset!=null && rset.next())
		 {
		  blood_grp			=	checkForNull(rset.getString("blood_grp_desc"));
		  rh_factor			=	checkForNull(rset.getString("rh_factor_desc"));
          }
		 if(pstmt!=null) pstmt.close();
		 if(rset!=null) rset.close();
		 if((bloodDisp != null) && (bloodDisp.length() > 0))
		 {
			bloodDisp.delete(0,bloodDisp.length());
		 } 

		StringBuffer sqlAddVisit2 = new StringBuffer();
		//sqlAddVisit2.append("select B.NATIONAL_ID_NO,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(b.alt_id1_type,'"+locale+"','1') ALT_ID1_DESC,B.NATIONALITY_CODE,MP_GET_DESC.MP_COUNTRY(B.NATIONALITY_CODE,'"+locale+"','3') NATIONALITY, B.ALT_ID1_NO,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(b.oth_alt_id_type,'"+locale+"','1') OTH_ALT_ID_DESC,B.OTH_ALT_ID_NO,A.PRIORITY_ZONE,A.TREATMENT_AREA_CODE,A.AE_BED_NO ASSIGN_BED_NUM ,B.CITIZEN_YN RESIDENCY, B.LEGAL_YN  LEGAL_STATUS,OP_GET_DESC.OP_CLINIC(A.FACILITY_ID,A.LOCN_CODE,'"+locale+"','1') clinic_name,AM_GET_DESC.AM_SERVICE(A.SERVICE_CODE,'"+locale+"','2') SERVICE_DESC,to_char(A.QUEUE_DATE,'dd/mm/yyyy hh24:mi') visit_adm_date_time,OP_GET_DESC.OP_VISIT_TYPE(A.FACILITY_ID,A.VISIT_TYPE_CODE,'"+locale+"','2') VISIT_TYPE_DESC,AM_GET_DESC.AM_SUBSERVICE(A.SERVICE_CODE,A.SUBSERVICE_CODE,'"+locale+"','2') subservice_desc,A.referral_id,C.ESCORT_NATIONAL_ID_NO,C.ESCORT_OTH_ALT_ID_NO,C.ESCORT_OTH_ALT_ID_TYPE, MP_GET_DESC.MP_ALTERNATE_ID_TYPE( C.ESCORT_OTH_ALT_ID_TYPE,'"+locale+"','1') esc_oth_alt_id_desc, C.accompanied_by_code,AM_GET_DESC.AM_ESCORT_TYPE( C.accompanied_by_code,'"+locale+"','2')  acc_desc, C.ESCORT_REGION_CODE,MP_GET_DESC.MP_REGION(C.ESCORT_REGION_CODE,'"+locale+"','1') esc_region_desc,C.RES_AREA_CODE,MP_GET_DESC.MP_RES_AREA(C.RES_AREA_CODE,'"+locale+"','1') esc_area_desc,C.RES_TOWN_CODE,MP_GET_DESC.MP_RES_TOWN(c.RES_TOWN_CODE,'"+locale+"','1') esc_town_desc, AM_GET_DESC.AM_ARRIVAL(C.OPERATING_FACILITY_ID, C.ARRIVAL_CODE,'"+locale+"','2') ARRIVAL_DESC,A.BROUGHT_DEAD_YN, A.MLC_YN, C.ESCORT_TYPE,C.ESCORT_NAME,C.ESCORT_ADD_LN1, C.ESCORT_ADD_LN2, C.ESCORT_ADD_LN3, C.ESCORT_ADD_LN4,  C.ESCORT_ADD_POSTAL_CODE, MP_GET_DESC.MP_POSTAL_CODE(C.ESCORT_ADD_POSTAL_CODE,'"+locale+"','2') ESCORT_ADD_POSTAL_DESC ,  C.ESCORT_TEL_NUM,C.ESCORT_COUNTRY_CODE,MP_GET_DESC.MP_COUNTRY(C.ESCORT_COUNTRY_CODE,'1','"+locale+"') ESCORT_COUNTRY_DESC,C.ESCORT_MV_REG_NO, C.ESCORT_REMARKS,C.RELATION_TO_PATIENT,A.DISASTER_YN,MP_GET_DESC.MP_RES_TOWN(a.disaster_town_code,'"+locale+"','1')  RES_TOWN_DESC,AE_GET_DESC.AE_DISASTER_TYPE( A.DISASTER_TYPE_CODE,'"+locale+"','2') DISASTER_TYPE_DESC,AE_GET_DESC.AE_PAT_PRIORITY(A.PAT_PRIORITY,'"+locale+"','2') PAT_PRIORITY  FROM OP_PATIENT_QUEUE A, MP_PATIENT B, PR_ENCOUNTER_OTHER_DETAIL C where a.FACILITY_ID =?  AND a.encounter_id = ? and a.patient_id=b.patient_id and a.FACILITY_ID = C.OPERATING_FACILITY_ID and a.ENCOUNTER_ID = c.ENCOUNTER_ID ");
		sqlAddVisit2.append("select B.NATIONAL_ID_NO,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(b.alt_id1_type,'"+locale+"','1') ALT_ID1_DESC,B.NATIONALITY_CODE,MP_GET_DESC.MP_COUNTRY(B.NATIONALITY_CODE,'"+locale+"','3') NATIONALITY, B.ALT_ID1_NO,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(b.oth_alt_id_type,'"+locale+"','1') OTH_ALT_ID_DESC,B.OTH_ALT_ID_NO,A.PRIORITY_ZONE,A.TREATMENT_AREA_CODE,A.AE_BED_NO ASSIGN_BED_NUM ,B.CITIZEN_YN RESIDENCY, B.LEGAL_YN  LEGAL_STATUS,OP_GET_DESC.OP_CLINIC(A.FACILITY_ID,A.LOCN_CODE,'"+locale+"','1') clinic_name,AM_GET_DESC.AM_SERVICE(A.SERVICE_CODE,'"+locale+"','2') SERVICE_DESC,to_char(A.QUEUE_DATE,'dd/mm/yyyy hh24:mi') visit_adm_date_time,OP_GET_DESC.OP_VISIT_TYPE(A.FACILITY_ID,A.VISIT_TYPE_CODE,'"+locale+"','2') VISIT_TYPE_DESC,AM_GET_DESC.AM_SUBSERVICE(A.SERVICE_CODE,A.SUBSERVICE_CODE,'"+locale+"','2') subservice_desc,A.referral_id,C.ESCORT_NATIONAL_ID_NO,C.ESCORT_OTH_ALT_ID_NO,C.ESCORT_OTH_ALT_ID_TYPE, MP_GET_DESC.MP_ALTERNATE_ID_TYPE( C.ESCORT_OTH_ALT_ID_TYPE,'"+locale+"','1') esc_oth_alt_id_desc, C.accompanied_by_code,AM_GET_DESC.AM_ESCORT_TYPE( C.accompanied_by_code,'"+locale+"','2')  acc_desc, C.ESCORT_REGION_CODE,MP_GET_DESC.MP_REGION(C.ESCORT_REGION_CODE,'"+locale+"','1') esc_region_desc,C.RES_AREA_CODE,MP_GET_DESC.MP_RES_AREA(C.RES_AREA_CODE,'"+locale+"','1') esc_area_desc,C.RES_TOWN_CODE,MP_GET_DESC.MP_RES_TOWN(c.RES_TOWN_CODE,'"+locale+"','1') esc_town_desc, AM_GET_DESC.AM_ARRIVAL(C.OPERATING_FACILITY_ID, C.ARRIVAL_CODE,'"+locale+"','2') ARRIVAL_DESC,A.BROUGHT_DEAD_YN, C.ESCORT_TYPE,C.ESCORT_NAME,C.ESCORT_ADD_LN1, C.ESCORT_ADD_LN2, C.ESCORT_ADD_LN3, C.ESCORT_ADD_LN4,  C.ESCORT_ADD_POSTAL_CODE, MP_GET_DESC.MP_POSTAL_CODE(C.ESCORT_ADD_POSTAL_CODE,'"+locale+"','2') ESCORT_ADD_POSTAL_DESC ,  C.ESCORT_TEL_NUM,C.ESCORT_COUNTRY_CODE,MP_GET_DESC.MP_COUNTRY(C.ESCORT_COUNTRY_CODE,'1','"+locale+"') ESCORT_COUNTRY_DESC,C.ESCORT_MV_REG_NO, C.ESCORT_REMARKS,C.RELATION_TO_PATIENT,A.DISASTER_YN,MP_GET_DESC.MP_RES_TOWN(a.disaster_town_code,'"+locale+"','1')  RES_TOWN_DESC,AE_GET_DESC.AE_DISASTER_TYPE( A.DISASTER_TYPE_CODE,'"+locale+"','2') DISASTER_TYPE_DESC,AE_GET_DESC.AE_PAT_PRIORITY(A.PAT_PRIORITY,'"+locale+"','2') PAT_PRIORITY,(SELECT PRIORITY_ZONE_DESC FROM AE_PRIORITY_ZONE_LANG_VW WHERE LANGUAGE_ID= '"+locale+"' and EFF_STATUS='E' and PRIORITY_ZONE=A.PRIORITY_ZONE) PRIORITY_ZONE_DESC ");
		//Added by Ajay Hatwate for GHL-CRF-0650
		if(isMLCAppl){
			sqlAddVisit2.append(", (select MLC_NO_OUTSIDE_DTLS from pr_encounter where facility_id = a.facility_id and encounter_id = a.encounter_id) MLC_NO_OUTSIDE_DTLS");
			sqlAddVisit2.append(", (select to_char(MLC_CAPTURE_DATE,'DD/MM/YYYY HH24:MI:SS') from pr_encounter where facility_id = a.facility_id and encounter_id = a.encounter_id) MLC_CAPTURE_DATE");
			sqlAddVisit2.append(", (select MLC_REMARKS from pr_encounter where facility_id = a.facility_id and encounter_id = a.encounter_id) MLC_REMARKS");
			sqlAddVisit2.append(", (select POL_REP_NO from pr_encounter where facility_id = a.facility_id and encounter_id = a.encounter_id) POL_REP_NO");
			sqlAddVisit2.append(", (select POL_STN_ID from pr_encounter where facility_id = a.facility_id and encounter_id = a.encounter_id) POL_STN_ID");
			sqlAddVisit2.append(", (select mlc_death_yn from pr_encounter where facility_id = a.facility_id and encounter_id = a.encounter_id) mlc_death_yn ");
			sqlAddVisit2.append(", (select mlc_yn from pr_encounter where facility_id = a.facility_id and encounter_id = a.encounter_id) mlc_yn ");
		}else{
			sqlAddVisit2.append(", A.MLC_YN ");	
		}

		sqlAddVisit2.append("FROM OP_PATIENT_QUEUE A, MP_PATIENT B, PR_ENCOUNTER_OTHER_DETAIL C where a.FACILITY_ID =?  AND a.encounter_id = ? and a.patient_id=b.patient_id and a.FACILITY_ID = C.OPERATING_FACILITY_ID and a.ENCOUNTER_ID = c.ENCOUNTER_ID ");
		//End of GHL-CRF-0650

         pstmt = con.prepareStatement(sqlAddVisit2.toString());
		pstmt.setString(1, facilityId);
		pstmt.setString(2, encounter_id);
		rset = pstmt.executeQuery();
		while(rset!=null && rset.next()) 
		{
		clinic_name			=	checkForNull(rset.getString("clinic_name"));
		service				=	checkForNull(rset.getString("service_desc"));
		visit_adm_date_time	=	checkForNull(rset.getString("visit_adm_date_time"));
		visit_type			=	checkForNull(rset.getString("visit_type_desc"));
		sub_service			=	checkForNull(rset.getString("subservice_desc"));
		//enc_type			=	checkForNull(rset.getString("ae_encounter_type"));
		referral_id			=   checkForNull(rset.getString("referral_id"));
          
		nationality			=	checkForNull(rset.getString("NATIONALITY"));		
		national_id			=	checkForNull(rset.getString("NATIONAL_ID_NO"));	
		alternate_id		=	checkForNull(rset.getString("ALT_ID1_NO"));		
		alt_id1_desc		=	checkForNull(rset.getString("ALT_ID1_DESC"));	
		oth_alt_id_desc		=	checkForNull(rset.getString("OTH_ALT_ID_DESC"));	
		oth_alt_id_no		=	checkForNull(rset.getString("OTH_ALT_ID_NO"));

        priority_zone		=   checkForNull(rset.getString("PRIORITY_ZONE"));
		treatment_area_code	=   checkForNull(rset.getString("TREATMENT_AREA_CODE"));
		bed_no				=   checkForNull(rset.getString("ASSIGN_BED_NUM"));
        
		legal_status	= checkForNull(rset.getString("LEGAL_STATUS"));
		residency		= checkForNull(rset.getString("RESIDENCY"));

		acc_desc			     =	checkForNull(rset.getString("acc_desc"));
		esc_oth_alt_id_desc     =	checkForNull(rset.getString("esc_oth_alt_id_desc"));
		esc_region_desc		 =	checkForNull(rset.getString("esc_region_desc"));
		esc_area_desc			 =	checkForNull(rset.getString("esc_area_desc"));
		ESCORT_NATIONAL_ID_NO	 =	checkForNull(rset.getString("ESCORT_NATIONAL_ID_NO"));
		escort_oth_alt_id_no	 =	checkForNull(rset.getString("escort_oth_alt_id_no"));
		arrival_mode			 =	checkForNull(rset.getString("arrival_desc"));
		brought_dead			 =	checkForNull(rset.getString("brought_dead_yn"));
		mlc_case				 =	checkForNull(rset.getString("mlc_yn"));
		escort_type			 =	checkForNull(rset.getString("escort_type"));
		escort_contcode		 =	checkForNull(rset.getString("ESCORT_COUNTRY_CODE"));
		escort_name			 =	checkForNull(rset.getString("escort_name"));
		relation				 =	checkForNull(rset.getString("relation_to_patient"));
		escort_add_ln1			 =	checkForNull(rset.getString("escort_add_ln1"));
		escort_add_ln2			 =	checkForNull(rset.getString("escort_add_ln2"));
		escort_add_ln3			 =	checkForNull(rset.getString("escort_add_ln3"));
		escort_add_ln4			 =	checkForNull(rset.getString("escort_add_ln4"));
		escort_add_postal_code	 =	checkForNull(rset.getString("escort_add_postal_code"));
		escort_add_postal_desc   =	checkForNull(rset.getString("escort_add_postal_desc"));
		escort_tel_no			 =	checkForNull(rset.getString("escort_tel_num"));
		escort_mv_reg_no		 =	checkForNull(rset.getString("escort_mv_reg_no"));
		escort_remarks			 =	checkForNull(rset.getString("escort_remarks"));
		disaster_yn             =  checkForNull(rset.getString("disaster_yn"));
		disaster_area_desc      =  checkForNull(rset.getString("RES_TOWN_DESC"));
		disaster_type_desc      =  checkForNull(rset.getString("DISASTER_TYPE_DESC"));
		esc_town_desc           =  checkForNull(rset.getString("esc_town_desc"));
        pat_priority            =  checkForNull(rset.getString("pat_priority"));
        priority_zone_desc		= checkForNull(rset.getString("PRIORITY_ZONE_DESC"));
   		//height_unit				=	checkForNull(rset.getString("height_unit"));
		//weight_unit				=	checkForNull(rset.getString("weight_unit"));
        //circumference_unit		=	checkForNull(rset.getString("circumference_unit"));

        //Added by Ajay Hatwate for GHL-CRF-0650 
        if(isMLCAppl){
	        mlcRem = checkForNull(rset.getString("MLC_REMARKS"));
			mlcCaptDate = checkForNull(rset.getString("MLC_CAPTURE_DATE"));
			mlcOutDtls = checkForNull(rset.getString("MLC_NO_OUTSIDE_DTLS"));
			polRepNo = checkForNull(rset.getString("POL_REP_NO"));
			polStnId = checkForNull(rset.getString("POL_STN_ID"));
			mlcDeathYn = checkForNull(rset.getString("MLC_DEATH_YN"));
			mlcRem = addSpaces(escapeHTML(mlcRem), 50);
			mlcOutDtls = addSpaces(escapeHTML(mlcOutDtls), 50);
			polRepNo = addSpaces(escapeHTML(polRepNo), 50);
			polStnId = addSpaces(escapeHTML(polStnId), 50);
	     }
		}
		if(pstmt!=null) pstmt.close();
		if(rset!=null) rset.close();  
		if((sqlAddVisit2 != null) && (sqlAddVisit2.length() > 0))
		{
			sqlAddVisit2.delete(0,sqlAddVisit2.length());
		}

		if(enc_type.equals("E") ) { enc_type ="Emergency "; }
		if(enc_type.equals("A") ) { enc_type ="Accident "; }

		StringBuffer sqlP = new StringBuffer();	
		sqlP.append("SELECT TREATMENT_AREA_CODE, SHORT_DESC FROM AE_TMT_AREA_FOR_CLINIC_LANG_VW WHERE language_id='"+locale+"'  and EFF_STATUS='E' AND FACILITY_ID= ? ORDER BY 2");
		pstmt = con.prepareStatement(sqlP.toString());
		pstmt.setString(1, facilityId);
		rset=pstmt.executeQuery();
		if(rset!=null)
		{
		   while(rset.next())
		   {
			 String Desc = checkForNull(rset.getString("SHORT_DESC"));
			 String treatCode = checkForNull(rset.getString("TREATMENT_AREA_CODE"));

			 if(treatment_area_code.equals(treatCode))
			   { treatment_area_code_desc = Desc; }
		   }
		}
		if(pstmt!=null) pstmt.close();
		if(rset!=null) rset.close();
		if((sqlP != null) && (sqlP.length() > 0))
		 {
			sqlP.delete(0,sqlP.length());
		 }
		//for Obtaining priority description//
		
		
       /* below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] */
		
	     /*sql="SELECT PRIORITY_ZONE,PRIORITY_ZONE_DESC FROM AE_PRIORITY_ZONE_LANG_VW WHERE LANGUAGE_ID= ? and EFF_STATUS='E'";
				
			    pstmt   = con.prepareStatement(sql.toString());
				pstmt.setString(1,locale) ;
			    rset    = pstmt.executeQuery();
				while(rset!=null && rset.next())
				{
				 color      =rset.getString("PRIORITY_ZONE");
				 if (color.equals("G")) {green=rset.getString("PRIORITY_ZONE_DESC");}
				 if (color.equals("R")) {red=rset.getString("PRIORITY_ZONE_DESC");}
				 if (color.equals("Y")) {yellow=rset.getString("PRIORITY_ZONE_DESC");}
				 if (color.equals("U")) {unassigned=rset.getString("PRIORITY_ZONE_DESC");}
				
				}
		    
			
		if(pstmt!=null) pstmt.close();
		if(rset!=null) rset.close();*/
		
		
		 
		//if(priority_zone.equals("R")) priority_zone_desc = red; //com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Red.label","common_labels");
		//if(priority_zone.equals("G")) priority_zone_desc = green;   //com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Green.label","common_labels");
		//if(priority_zone.equals("Y")) priority_zone_desc = yellow; //com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Yellow.label","common_labels");
		//if(priority_zone.equals("U")) priority_zone_desc = unassigned; //com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nonurgent.label","common_labels");
		
		/* CRF  SKR-CRF-0021 [IN028173] end  */
		
		//Obtaining priority description ends here

		// Arrival Details tab  select alt_id_type,short_desc SHORT_DESC from "+ "mp_alternate_id_type
		StringBuffer sqlRelation = new StringBuffer();
		
        sqlRelation.append("select RELATIONSHIP_CODE,SHORT_DESC from MP_RELATIONSHIP_LANG_VW   where language_id='"+locale+"'  and EFF_STATUS='E' and nvl(eff_date_from,sysdate) >= sysdate and nvl(eff_date_to,sysdate) <= sysdate order by SHORT_DESC");
		
		if(escort_type.equals("N") ) { escort_type ="Next of Kin"; }
		if(escort_type.equals("P") ) { escort_type ="Police"; }
		if(escort_type.equals("O") ) { escort_type ="Others"; }

									
		//Related Contacts 
		StringBuffer sqlCountry = new StringBuffer();
		
		sqlCountry.append(" select COUNTRY_CODE,LONG_NAME SHORT_NAME from MP_COUNTRY_LANG_VW  where language_id='"+locale+"'  and EFF_STATUS='E'  and nvl(eff_date_from,sysdate) >= sysdate and nvl(eff_date_to,sysdate) <= sysdate order by SHORT_NAME ");
        StringBuffer sqlRelated = new StringBuffer();
		/*sqlRelated.append("select OCPN_CLASS_CODE,OCPN_DESC, MP_GET_DESC.MP_OCCUPATION_CLASS(OCPN_CLASS_CODE,'"+locale+"','1')  occ_class, CONTACT2_EMAIL_ID,CONTACT2_MOB_TEL_NO, CONTACT2_TOWN_CODE,MP_GET_DESC.MP_RES_TOWN(CONTACT2_TOWN_CODE,'"+locale+"','1')  first_town, CONTACT2_AREA_CODE, CONTACT2_REGION_CODE,CONTACT3_TOWN_CODE, MP_GET_DESC.MP_RES_TOWN(CONTACT3_TOWN_CODE,'"+locale+"','1')   emp_town,CONTACT3_AREA_CODE,CONTACT3_REGION_CODE,  MP_GET_DESC.MP_REGION(CONTACT2_REGION_CODE,'"+locale+"','1') first_region,  MP_GET_DESC.MP_RES_AREA(CONTACT2_AREA_CODE,'"+locale+"','1')  first_area,  MP_GET_DESC.MP_REGION(CONTACT3_REGION_CODE,'"+locale+"','1') emp_region,  MP_GET_DESC.MP_RES_AREA(CONTACT3_AREA_CODE,'"+locale+"','1')  emp_area,CONTACT2_NATIONAL_ID_NO,  CONTACT1_EMAIL_ID,CONTACT1_MOB_TEL_NO,  CONTACT1_TOWN_CODE,MP_GET_DESC.MP_RES_TOWN(CONTACT1_TOWN_CODE,'"+locale+"','1')  next_town,CONTACT1_AREA_CODE,CONTACT2_RELATION,  MP_GET_DESC.MP_RELATIONSHIP(CONTACT2_RELATION,'"+locale+"','2') first_relation,CONTACT1_REGION_CODE,  MP_GET_DESC.MP_RES_AREA(CONTACT1_AREA_CODE,'"+locale+"','1') next_area,  MP_GET_DESC.MP_REGION(CONTACT1_REGION_CODE,'"+locale+"','1') next_region,  to_char(contact1_birth_date,'dd/mm/rrrr')   contact1_birth_date, contact1_national_id_no,contact1_relation,substr(contact3_name,1,15)|| '\n' || substr(contact3_name,16,30)contact3_name,substr(contact1_name,1,15)|| '\n' || substr(contact1_name,16,30)contact1_name,  job1_title,addr1_line1,addr1_line2,  addr1_line3,addr1_line4,postal1_code,MP_GET_DESC.MP_POSTAL_CODE(postal1_code,'"+locale+"','2')  postal1_desc,country1_code,res1_tel_no,  off1_tel_no,employer_name,job2_title, addr2_line1,addr2_line2,addr2_line3, addr2_line4,postal2_code,MP_GET_DESC.MP_POSTAL_CODE(postal2_code,'"+locale+"','2')  postal2_desc,country2_code, off2_tel_no,off2_fax_no, first_to_notify_name,job3_title, addr3_line1,addr3_line2,addr3_line3, addr3_line4,postal3_code, MP_GET_DESC.MP_POSTAL_CODE(postal3_code,'"+locale+"','2')  postal3_desc,country3_code,res2_tel_no, res3_tel_no,off3_tel_no, patient_employee_id,employment_status, MP_GET_DESC.MP_OCCUPATION(ocpn_code,'"+locale+"','2')  short_desc from ae_pat_related_contacts  where facility_id =? and  encounter_id=? "); */
		
		sqlRelated.append("select OCPN_CLASS_CODE,OCPN_DESC, MP_GET_DESC.MP_OCCUPATION_CLASS(OCPN_CLASS_CODE,'"+locale+"','1')  occ_class, CONTACT2_EMAIL_ID,CONTACT2_MOB_TEL_NO, CONTACT2_TOWN_CODE,MP_GET_DESC.MP_RES_TOWN(CONTACT2_TOWN_CODE,'"+locale+"','1')  first_town, CONTACT2_AREA_CODE, CONTACT2_REGION_CODE,CONTACT3_TOWN_CODE, MP_GET_DESC.MP_RES_TOWN(CONTACT3_TOWN_CODE,'"+locale+"','1')   emp_town,CONTACT3_AREA_CODE,CONTACT3_REGION_CODE,  MP_GET_DESC.MP_REGION(CONTACT2_REGION_CODE,'"+locale+"','1') first_region,  MP_GET_DESC.MP_RES_AREA(CONTACT2_AREA_CODE,'"+locale+"','1')  first_area,  MP_GET_DESC.MP_REGION(CONTACT3_REGION_CODE,'"+locale+"','1') emp_region,  MP_GET_DESC.MP_RES_AREA(CONTACT3_AREA_CODE,'"+locale+"','1')  emp_area,CONTACT2_NATIONAL_ID_NO,  CONTACT1_EMAIL_ID,CONTACT1_MOB_TEL_NO,  CONTACT1_TOWN_CODE,MP_GET_DESC.MP_RES_TOWN(CONTACT1_TOWN_CODE,'"+locale+"','1')  next_town,CONTACT1_AREA_CODE,CONTACT2_RELATION,  MP_GET_DESC.MP_RELATIONSHIP(CONTACT2_RELATION,'"+locale+"','2') first_relation,CONTACT1_REGION_CODE,  MP_GET_DESC.MP_RES_AREA(CONTACT1_AREA_CODE,'"+locale+"','1') next_area,  MP_GET_DESC.MP_REGION(CONTACT1_REGION_CODE,'"+locale+"','1') next_region,  to_char(contact1_birth_date,'dd/mm/rrrr')   contact1_birth_date, contact1_national_id_no,contact1_relation,substr(contact3_name,1,15)|| '\n' || substr(contact3_name,16,30)contact3_name,contact1_name,  job1_title,addr1_line1,addr1_line2,  addr1_line3,addr1_line4,postal1_code,MP_GET_DESC.MP_POSTAL_CODE(postal1_code,'"+locale+"','2')  postal1_desc,country1_code,res1_tel_no,  off1_tel_no,employer_name,job2_title, addr2_line1,addr2_line2,addr2_line3, addr2_line4,postal2_code,MP_GET_DESC.MP_POSTAL_CODE(postal2_code,'"+locale+"','2')  postal2_desc,country2_code, off2_tel_no,off2_fax_no, first_to_notify_name,job3_title, addr3_line1,addr3_line2,addr3_line3, addr3_line4,postal3_code, MP_GET_DESC.MP_POSTAL_CODE(postal3_code,'"+locale+"','2')  postal3_desc,country3_code,res2_tel_no, res3_tel_no,off3_tel_no, patient_employee_id,employment_status, MP_GET_DESC.MP_OCCUPATION(ocpn_code,'"+locale+"','2')  short_desc,REL_PATIENT_ID from ae_pat_related_contacts  where facility_id =? and  encounter_id=? "); // MODIFIED by mujafar for ML-MMOH-CRF-0632
		
		pstmt = con.prepareStatement(sqlRelated.toString());
		pstmt.setString(1, facilityId);
		pstmt.setString(2, encounter_id);
		rset=pstmt.executeQuery();
		while(rset!=null && rset.next())
		{ 
		contact1_national_id_no			=   checkForNull(rset.getString("contact1_national_id_no"));
		contact1_birth_date				=	checkForNull(rset.getString("contact1_birth_date"));

		occ_class						=	checkForNull(rset.getString("occ_class"));
		occ_desc						=	checkForNull(rset.getString("OCPN_DESC"));
		CONTACT2_EMAIL_ID				=	checkForNull(rset.getString("CONTACT2_EMAIL_ID"));
		CONTACT2_MOB_TEL_NO				=	checkForNull(rset.getString("CONTACT2_MOB_TEL_NO"));
		emp_town						=	checkForNull(rset.getString("emp_town"));
        first_town						=	checkForNull(rset.getString("first_town"));
        next_town						=	checkForNull(rset.getString("next_town"));
		first_region			  		=	checkForNull(rset.getString("first_region"));
		first_area						=	checkForNull(rset.getString("first_area"));
		emp_area						=	checkForNull(rset.getString("emp_area"));
		emp_region						=	checkForNull(rset.getString("emp_region"));
		CONTACT2_NATIONAL_ID_NO			=	checkForNull(rset.getString("CONTACT2_NATIONAL_ID_NO"));
		first_relation					=	checkForNull(rset.getString("first_relation"));
		next_area						=	checkForNull(rset.getString("next_area"));
		next_region						=	checkForNull(rset.getString("next_region"));
		CONTACT1_MOB_TEL_NO				=	checkForNull(rset.getString("CONTACT1_MOB_TEL_NO"));
		CONTACT1_EMAIL_ID				=	checkForNull(rset.getString("CONTACT1_EMAIL_ID"));
		relationship					=	checkForNull(rset.getString("contact1_relation"));
		name							=   checkForNull(rset.getString("contact1_name"));
		contact3_name					=   checkForNull(rset.getString("contact3_name"));
		employer_name					=	checkForNull(rset.getString("employer_name"));
		first_to_notify_name			=	checkForNull(rset.getString("first_to_notify_name"));
		job1_title						=	checkForNull(rset.getString("job1_title"));
		job2_title						=	checkForNull(rset.getString("job2_title"));
		addr1_line1						=	checkForNull(rset.getString("addr1_line1"));
		addr1_line2						=	checkForNull(rset.getString("addr1_line2"));
		addr1_line3						=	checkForNull(rset.getString("addr1_line3"));
		addr1_line4						=	checkForNull(rset.getString("addr1_line4"));
		addr2_line1						=	checkForNull(rset.getString("addr2_line1"));
		addr2_line2						=	checkForNull(rset.getString("addr2_line2"));
		addr2_line3						=	checkForNull(rset.getString("addr2_line3"));
		addr2_line4						=	checkForNull(rset.getString("addr2_line4"));
		addr3_line1						=	checkForNull(rset.getString("addr3_line1"));
		addr3_line2						=	checkForNull(rset.getString("addr3_line2"));
		addr3_line3						=	checkForNull(rset.getString("addr3_line3"));
		addr3_line4						=	checkForNull(rset.getString("addr3_line4"));
		postal1_code					=	checkForNull(rset.getString("postal1_code"));
		postal2_code					=	checkForNull(rset.getString("postal2_code"));
		postal3_code					=	checkForNull(rset.getString("postal3_code"));
		postal1_desc					=	checkForNull(rset.getString("postal1_desc"));		postal2_desc					=	checkForNull(rset.getString("postal2_desc"));
		postal3_desc		  			=	checkForNull(rset.getString("postal3_desc"));
		country1_code					=	checkForNull(rset.getString("country1_code"));
		country2_code					=	checkForNull(rset.getString("country2_code"));
		country3_code					=	checkForNull(rset.getString("country3_code"));
		res1_tel_no						=	checkForNull(rset.getString("res1_tel_no"));	
		res3_tel_no						=	checkForNull(rset.getString("res3_tel_no"));
		res2_tel_no						=	checkForNull(rset.getString("res2_tel_no"));
		off1_tel_no						=	checkForNull(rset.getString("off1_tel_no"));
		off2_tel_no						=	checkForNull(rset.getString("off2_tel_no"));
		off3_tel_no						=	checkForNull(rset.getString("off3_tel_no"));
		patient_employee_id				=	checkForNull(rset.getString("patient_employee_id"));
		ocpn_desc						=	checkForNull(rset.getString("short_desc"));
		employee_status					=	checkForNull(rset.getString("employment_status"));
		rel_pat_id                      =   checkForNull(rset.getString("REL_PATIENT_ID")); // Added by mujafar for ML-MMOH-CRF-0632
		}
		if(pstmt!=null) pstmt.close();
		if(rset!=null) rset.close();
		if((sqlRelated != null) && (sqlRelated.length() > 0))
		 {
			sqlRelated.delete(0,sqlRelated.length());
		 }
		if(employee_status.equals("FE"))
			employee_status	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.FullTimeEmployed.label","mp_labels");
		if(employee_status.equals("FS"))
			employee_status	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.FullTimeStudent.label","mp_labels");
		if(employee_status.equals("NA"))
			employee_status	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");
		if(employee_status.equals("PE"))
			employee_status	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PartTimeEmployed.label","mp_labels");
		if(employee_status.equals("PS"))
			employee_status	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PartTimeStudent.label","mp_labels");
		if(employee_status.equals("SE"))
			employee_status	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.SelfEmployed.label","mp_labels");
		if(employee_status.equals("UE"))
			employee_status	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Unemployed.label","mp_labels");
		if(employee_status.equals("UK"))
			employee_status	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

	  StringBuffer sqlUnit = new StringBuffer();
	  sqlUnit.append(" select  ");
	  sqlUnit.append(" NAT_ID_PROMPT ");
	  sqlUnit.append(" from MP_PARAM  where module_id='MP' ");
	                   // To display the alternate id 

	   pstmt = con.prepareStatement(sqlUnit.toString());
	   rset = pstmt.executeQuery();
	   while(rset!=null && rset.next())
	   {
			 nat_id_prompt				= checkForNull(rset.getString("NAT_ID_PROMPT"));
	   }
	   if(pstmt!=null) pstmt.close();
	   if(rset!=null) rset.close();
	   if((sqlUnit != null) && (sqlUnit.length() > 0))
		 {
			sqlUnit.delete(0,sqlUnit.length());
		 }
		/*if(height_unit!=null && height_unit.equalsIgnoreCase("C"))
		height_unit = "CM";
		else if(height_unit!=null && height_unit.equalsIgnoreCase("I"))
		height_unit = "Inch";
		if(weight_unit!=null && weight_unit.equalsIgnoreCase("K"))
		weight_unit = "KG";
		else if(weight_unit!=null && weight_unit.equalsIgnoreCase("L"))
		weight_unit = "LB";
		if(circumference_unit!=null && circumference_unit.equalsIgnoreCase("C"))
		circumference_unit = "CM";
		else if(circumference_unit!=null && circumference_unit.equalsIgnoreCase("I"))
		circumference_unit = "Inch";*/		

%>

     <body onSelect="codeArrestThruSelect()"  OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
	 <form name="ae_pathistory_result_form" id="ae_pathistory_result_form">
	 <!-- <a name="tab1" ></a>  -->
	 <a name="tab1" id="tab1"></a>
		<table cellspacing='0' cellpadding='0' width='97%' border=0 align='center'>
            <tr><td class='white'>

		<ul id="tablist" class="tablist" >
			<li class="tablistitem" title="Add Visit">
				<a onclick="tab_click1('addVisit_tab')" class="tabClicked" id='addVisit_tab' >
					<span class="tabSpanclicked" id="addVisit_tabspan"><fmt:message key="Common.VisitDetail.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			<li class="tablistitem" title="Arrival">
				<a onclick="tab_click1('arrival_tab')" class="tabA" id="arrival_tab" >
					<span class="tabAspan" id="arrival_tabspan"><fmt:message key="Common.arrival.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			<li class="tablistitem" title="Related Contact details">
				<a onclick="tab_click1('rlcnts_tab')" class="tabA" id="rlcnts_tab" >
					<span class="tabAspan" id="rlcnts_tabspan"><fmt:message key="eMP.relatedcontacts.label" bundle="${mp_labels}"/></span>
				</a>
			</li>	
		</ul>
	</td></tr></table>

		<div class="table-data">
		<table border="0" cellpadding="1" cellspacing="0" align='center' width='97%'>
		<tr>
			<td class='COLUMNHEADER' colspan='4' ><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></td>
		</tr>
  		<tr>
		      <td class='LABEL' colspan='4'>&nbsp;</td>
	    </tr>	
		<tr>
		      <td class='LABEL'  width='25%' nowrap>
			      <% if(!nat_id_prompt.equals("")){  %> <%=nat_id_prompt%>
  		      			  </td>
				<td class='QUERYDATA' >&nbsp;
 				<%=ecis.utils.HTMLUtilities.getDisplayString(national_id)%>
				  <% } else {  %>
					 <td>&nbsp;
				  <% } %>
                </td>
			    <td class='LABEL'  nowrap> 
				<% if(! alt_id1_desc.equals("")){  %> <%= alt_id1_desc%>
				    <td class='QUERYDATA' >&nbsp;
 			  	           <%=alternate_id%>
                    </td>
				<% } else{ %>
				<td class='QUERYDATA' >&nbsp;   </td>
                        <% }%>
		</tr>
        <tr><td class='LABEL'  colspan='4'>&nbsp;</td></tr>	
        <tr>
             <td class='LABEL'  width='25%' nowrap><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></td>
  		     <td class='QUERYDATA'  width='25%'>
 				<%=ecis.utils.HTMLUtilities.getDisplayString(nationality)%>
 		     </td>
             <td class='LABEL' align='RIGHT' width='5%' nowrap>
		       <%if (! oth_alt_id_desc.equals("")){%> <%=oth_alt_id_desc%>  
					 <td class='QUERYDATA' align='left' >&nbsp;
 			  	           <%=oth_alt_id_no%>
                           </td><% } else{ %>
							   <td class='QUERYDATA' align='left' width='20%'>&nbsp;   </td>
                          <% }%>
			  </td>
        </tr>
		<tr>
		      <td class='LABEL' colspan='4'>&nbsp;</td>
	    </tr>

		<tr>
		      <td class='LABEL'  nowrap><fmt:message key="Common.residency.label" bundle="${common_labels}"/></td>
			  <td class='QUERYDATA' ><% if(residency.equals("Y")){ %> <fmt:message key="Common.citizen.label" bundle="${common_labels}"/><% } else { %><fmt:message key="Common.noncitizen.label" bundle="${common_labels}"/> <% } %>
              </td>
              <td class='LABEL' nowrap><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
			  <td class='QUERYDATA' ><% if(legal_status.equals("Y")){ %>&nbsp;<fmt:message key="Common.legal.label" bundle="${common_labels}"/><% } else { %>&nbsp;<fmt:message key="Common.illegal.label" bundle="${common_labels}"/> <% } %>
              </td>
	      </tr>	
        <tr><td class='LABEL'  colspan='4'>&nbsp;</td></tr>	
        <tr>
    	     <td class='LABEL'  nowrap><fmt:message key="Common.bloodgroup.label" bundle="${common_labels}"/></td>
              <td class='QUERYDATA' >&nbsp;&nbsp;<%=blood_grp%></td>
			  <input type='hidden'  name="blood_group" id="blood_group"  value="<%=blood_grp%>">
			  <td class='LABEL' align='left' width='20%' nowrap><fmt:message key="Common.RhFactor.label" bundle="${common_labels}"/></td><td class='QUERYDATA' ><%=rh_factor%></td>
		</tr>
        <tr>
		      <td class='LABEL' colspan='4'>&nbsp;</td>
	   </tr>
	   <tr>
			<td class='LABEL' ><fmt:message key="Common.referralid.label" bundle="${common_labels}"/></td>
			<td class='QUERYDATA' ><B><%=referral_id%>&nbsp;</B></td>
            <td class='LABEL' colspan='2' >&nbsp;</td>
          </tr>
          <tr>
		      <td class='LABEL' colspan='4'>&nbsp;</td>
	    </tr>
		<tr>
			<td class='COLUMNHEADER' colspan='4' ><fmt:message key="Common.VisitDetail.label" bundle="${common_labels}"/></td>
		</tr>
        <tr>
		      <td class='LABEL' colspan='4'>&nbsp;</td>
	    </tr>
		<tr><%visit_adm_date_time=DateUtils.convertDate(visit_adm_date_time,"DMYHM","en",locale);%>
    	      <td class='LABEL' nowrap><fmt:message key="Common.VisitDateTime.label" bundle="${common_labels}"/></td>
  		      <td class='QUERYDATA' ><%=visit_adm_date_time%>&nbsp;</td> 
			  <td class='LABEL' colspan='2'>&nbsp;</td>
        </tr>
		<tr>
		      <td class='LABEL' colspan='4' >&nbsp;</td>
	    </tr>

		<tr>
		      <td class='LABEL' nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
			  <td class='QUERYDATA' ><%=clinic_name%>&nbsp;</td>
			  <td class='LABEL' nowrap><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
  		      <td class='QUERYDATA'  nowrap><%=service%>&nbsp;</td>
	      </tr>
  		  <tr>
		      <td class='LABEL'  colspan='4'>&nbsp;</td>
	      </tr>

		  <tr>
		      <td class='LABEL'  nowrap><fmt:message key="eAE.RegistrationType.label" bundle="${ae_labels}"/></td>
  		      <td class='QUERYDATA' ><%=visit_type%>&nbsp;</td>
			  <td class='LABEL' nowrap><fmt:message key="Common.subservice.label" bundle="${common_labels}"/></td>
  		      <td class='QUERYDATA'  nowrap><%=sub_service%>&nbsp;</td>
          </tr>
		  <tr>
		      <td class='LABEL' width='5%' colspan='6'>&nbsp;</td>
	      </tr>	
          <tr>
		      <td class='LABEL' ><fmt:message key="Common.ModeofArrival.label" bundle="${common_labels}"/></td>
  		      <td class='QUERYDATA' ><%=arrival_mode%>&nbsp;
 		      </td>
              <td class='LABEL' colspan='2'>&nbsp;</td>
          </tr>
		  <tr>
		      <td class='LABEL' colspan='4'>&nbsp;</td>
	      </tr>	
		 <tr>
		 	<%if(!five_level_triage_appl_yn.equals("Y")  && (isLabelChngAppl == false) ){ %> 
              <td class='LABEL' ><fmt:message key="Common.broughtdead.label" bundle="${common_labels}"/></td>
	  		 <%}else{ %>
			 	<td class='LABEL'   ><fmt:message key="eAE.DeadOnArrival.label" bundle="${common_labels}"/></td>
			 <%} %>
	  		  <td class='QUERYDATA' ><% if(brought_dead.equals("N")){ %> <fmt:message key="Common.no.label" bundle="${common_labels}"/><% } else { %><fmt:message key="Common.yes.label" bundle="${common_labels}"/> <% } %>
              </td>
              <% if(!isMLCAppl){ %>
			  <%if(siteSpecific){%>
			 <td class='LABEL' ><fmt:message key="Common.MedicalLegalCase.label" bundle="${common_labels}"/></td>
			<%}else{%>
			  <td class='LABEL' ><fmt:message key="Common.mlc.label" bundle="${common_labels}"/></td>
			  <%}%>
			  
	  		  <td class='QUERYDATA' ><% if(mlc_case.equals("N")){ %> <fmt:message key="Common.no.label" bundle="${common_labels}"/><% } else { %><fmt:message key="Common.yes.label" bundle="${common_labels}"/> <% } %>
              </td>
              <% }%>
          </tr>
		  <tr>
		      <td class='LABEL' colspan='4'>&nbsp;</td>
	      </tr>	
		  <tr>
		      <td class='LABEL' ><fmt:message key="Common.PriorityZone.label" bundle="${common_labels}"/></td>
              <td class='QUERYDATA' ><%=priority_zone_desc%></td>	
			  <td class='LABEL' ><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
              <td class='QUERYDATA' ><%=pat_priority%>&nbsp;</td>
          </tr>
         <tr>
		      <td class='LABEL' colspan='4'>&nbsp;</td>
	     </tr>
		  <tr>
			  <td class='LABEL' nowrap><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/></td>
			  <td class='QUERYDATA'  nowrap><%=treatment_area_code_desc%></td>
			  <td class='LABEL' nowrap><fmt:message key="eAE.BedBayNo.label" bundle="${ae_labels}"/></td>
			  <td class='QUERYDATA' ><%=ecis.utils.HTMLUtilities.getDisplayString(bed_no)%></td>
	      </tr>	
           <tr>
		      <td class='LABEL' colspan='4'>&nbsp;</td>
	       </tr>
		  <tr>
		      <td class='LABEL' nowrap><fmt:message key="Common.Disaster.label" bundle="${common_labels}"/></td>
			  <td class='QUERYDATA' width='25%' nowrap><% if(disaster_yn.equals("N")){ %> <fmt:message key="Common.no.label" bundle="${common_labels}"/><% } else { %><fmt:message key="Common.yes.label" bundle="${common_labels}"/> <% } %>
              </td>
			  <td class='LABEL'  nowrap><fmt:message key="eAE.DisasterArea.label" bundle="${ae_labels}"/></td>
			  <td class='QUERYDATA'  nowrap>
			  <%=ecis.utils.HTMLUtilities.getDisplayString(disaster_area_desc)%></td>
		  </tr>
		  <tr>
		      <td class='LABEL' width='5%' colspan='4'>&nbsp;</td>
	      </tr>
           <tr>
		      <td class='LABEL' nowrap><fmt:message key="eAE.DisasterType.label" bundle="${ae_labels}"/></td>
			  <td class='QUERYDATA'  nowrap>
			  <%=ecis.utils.HTMLUtilities.getDisplayString(disaster_type_desc)%></td>
			  <td class='LABEL' colspan='2'>&nbsp;</td>
		  </tr>
          <tr>
		      <td class='LABEL'  colspan='6'>&nbsp;</td>
	      </tr>
	      <!-- Added by Ajay Hatwate for GHL-CRF-0650 -->
	      <% if(isMLCAppl){ %>
		    <tr>
				<td class='COLUMNHEADER' colspan='4' ><fmt:message key="Common.mlcdetails.label" bundle="${common_labels}"/></td>
			</tr>
	        <tr>
			      <td class='LABEL' colspan='4'>&nbsp;</td>
		    </tr>
		   <tr>
		      <td class='LABEL' nowrap><fmt:message key="Common.mlc.label" bundle="${common_labels}"/></td>
			  <td class='QUERYDATA' width='25%' nowrap><% if(mlc_case.equals("N")){ %> <fmt:message key="Common.no.label" bundle="${common_labels}"/><% } else { %><fmt:message key="Common.yes.label" bundle="${common_labels}"/> <% } %>
              </td>
			  <td class='LABEL'  nowrap><fmt:message key="Common.MlcDeath.label" bundle="${ae_labels}"/></td>
			  <td class='QUERYDATA'  nowrap>
			  	<% if(mlcDeathYn.equals("N")){ %> <fmt:message key="Common.no.label" bundle="${common_labels}"/><% } else { %><fmt:message key="Common.yes.label" bundle="${common_labels}"/> <% } %>
			  </td>
		  </tr>
		  <tr>
			      <td class='LABEL' colspan='4'>&nbsp;</td>
		  </tr>
		  <tr>
		      <td class='LABEL' nowrap><fmt:message key="Common.PoliceReportNo.label" bundle="${common_labels}"/></td>
			  <td class='QUERYDATA' width='25%' ><%=polRepNo %></td>
			  <td class='LABEL'  nowrap><fmt:message key="Common.PoliceStationDetails.label" bundle="${ae_labels}"/></td>
			  <td class='QUERYDATA' width='25%' >
					<%=polStnId %>
			  </td>
		  </tr>
		  <tr>
			      <td class='LABEL' colspan='4'>&nbsp;</td>
		  </tr>
		  <tr>
		      <td class='LABEL' nowrap><fmt:message key="Common.OutMlcNoDtls.label" bundle="${common_labels}"/></td>
			  <td class='QUERYDATA' width='25%' ><%=mlcOutDtls %></td>
			  <td class='LABEL'  nowrap><fmt:message key="Common.DateOfMlcCapture.label" bundle="${ae_labels}"/></td>
			  <td class='QUERYDATA'  nowrap>
					<%=mlcCaptDate %>
			  </td>
		  </tr>
		  <tr>
			      <td class='LABEL' colspan='4'>&nbsp;</td>
		  </tr>

		  <tr>
		      <td class='LABEL' nowrap><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
			  <td class='QUERYDATA' width='25%' > <%=mlcRem %></td>
		  </tr>
		  <tr>
			      <td class='LABEL' colspan='4'>&nbsp;</td>
		  </tr>
	    <%} %>
	      
	      
       </table>
       <br><br><br><br><br><br><br>
       </div>
	 <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

  <!-- <a name="tab2" id="tab2" tabindex='15' ></a> -->
<a name="tab2" id="tab2"></a>
	<table cellspacing='0' cellpadding='0' width='97%' border=0 align='center'>
        <tr><td class='white'>
				<ul id="tablist" class="tablist" >
						<li class="tablistitem" title="Add Visit">
							<a onclick="tab_click1('addVisit_tab')" class="tabA" id='addVisit_tab' >
								<span class="tabAspan" id="addVisit_tabspan"><fmt:message key="Common.VisitDetail.label" bundle="${common_labels}"/></span>
							</a>
						</li>
						<li class="tablistitem" title="Arrival">
							<a onclick="tab_click1('arrival_tab')" class="tabClicked" id="arrival_tab" >
								<span class="tabSpanclicked" id="arrival_tabspan"><fmt:message key="Common.arrival.label" bundle="${common_labels}"/></span>
							</a>
						</li>
						<li class="tablistitem" title="Related Contact details">
							<a onclick="tab_click1('rlcnts_tab')" class="tabA" id="rlcnts_tab" >
								<span class="tabAspan" id="rlcnts_tabspan"><fmt:message key="eMP.relatedcontacts.label" bundle="${mp_labels}"/></span>
							</a>
						</li>	
			</ul>
	</td></tr></table>
		<table border="0" cellpadding="3" cellspacing="0" align='center' width='97%'>
		<tr>
			<td class='COLUMNHEADER' colspan='4' ><fmt:message key="eAE.EscortDetail.label" bundle="${ae_labels}"/></td>
		</tr>
		 
    	<tr>
			<td class='LABEL' width='25%'></td>
			<td class='LABEL' width='25%'></td>
			<td class='LABEL' width='25%'></td>
			<td class='LABEL' width='25%'></td>
		</tr> 
    	<tr>
		       <td class='LABEL' nowrap><fmt:message key="eAE.AccompaniedBy.label" bundle="${ae_labels}"/></td>
  		      <td class='QUERYDATA' ><%=acc_desc%>&nbsp;</td>
			  <td colspan='2' class='label' >&nbsp;</td>
		  </tr>	
          <tr><td colspan='4' class='label' height='5'></td></tr>
		  <tr>
			   <td class='LABEL' ><fmt:message key="Common.relationship.label" bundle="${common_labels}"/></td>
			<%
			  pstmt = con.prepareStatement(sqlRelation.toString());

			rset = pstmt.executeQuery();
			while(rset!=null && rset.next())
			{
			if(relation!=null && relation.equalsIgnoreCase(rset.getString(1)))
				 relation= rset.getString(2);
			}
			if(pstmt!=null) pstmt.close();
			if(rset!=null) rset.close();
			%>
  		      <td class='QUERYDATA' ><%=relation%>&nbsp;
              <td colspan='2' class='label' >&nbsp;</td>
		  </tr>
		  <tr><td colspan='4' class='label' height='5'></td></tr>
		  <tr>
				  <td class='LABEL' nowrap><fmt:message key="Common.otheraltid.label" bundle="${common_labels}"/></td>
		          <td class='QUERYDATA' colspan=3><%=esc_oth_alt_id_desc%>/<%=escort_oth_alt_id_no%>
 		          &nbsp;</td>
		  </tr>
		  <tr><td colspan='4' class='label' height='5'></td></tr>
		  <tr>
		      <td class='LABEL' nowrap><%=nat_id_prompt%>&nbsp;</td>
		      <td class='QUERYDATA' align='left' width='40%'><%=ESCORT_NATIONAL_ID_NO%>&nbsp;
 		      </td>
			  <td colspan='2' class='label'>&nbsp;</td>
		 </tr>
         <tr><td colspan='4' class='label' height='5'></td></tr>
	  <%
	
		String[] escort_address_fld_values=	{escort_add_ln1,escort_add_ln2,escort_add_ln3,escort_add_ln4,esc_area_desc,esc_town_desc,esc_region_desc,escort_add_postal_desc};
		
		for(int i=0;i<contact_col_names.length;i++) 
		{
			out.println("<tr>");
			out.println("<td class='LABEL'  nowrap>"+contact_prompts[i]+"</td>") ;		

			for(int j=0; j<address_col_names.length; j++)
			{
				if(address_col_names[j].equals(contact_col_names[i]))
				{
			
					if(address_col_names[j].equals("POSTAL_CODE_PROMPT"))
					{
					/*Below line modified for ML-MMOH-CRF-0860.2*/
					out.println("<td class='QUERYDATA' width='"+data_width1+"' style='"+data_word_wrap1+"' >"+escort_address_fld_values[j]+"&nbsp;</td>") ;  
					out.println("<td class='LABEL' colspan='2'>&nbsp;</td></tr>");
					out.println("<tr><td colspan='4' class='label' height='5'></td></tr>");
					}
					else
					{
					/*Below line modified for ML-MMOH-CRF-0860.2*/
					out.println("<td class='QUERYDATA' width='"+data_width1+"' style='"+data_word_wrap1+"' >"+escort_address_fld_values[j]+"&nbsp;</td>") ;
					out.println("<td class='LABEL' colspan='2'>&nbsp;</td></tr>");
					out.println("<tr><td colspan='4' class='label' height='5'></td></tr>");
					}
				}
				
			}   
	}
		   %>
		   <tr>
		<%
			  pstmt = con.prepareStatement(sqlCountry.toString());
			  rset = pstmt.executeQuery();
			  while(rset!=null && rset.next())
			  {
			  if(escort_contcode !=null && escort_contcode .equalsIgnoreCase(rset.getString(1)))
				    escort_contcode= 	rset.getString(2);
			  }
						   if(pstmt!=null) pstmt.close();
						   if(rset!=null) rset.close();
						   if(escort_contcode==null||escort_contcode.equals("null"))escort_contcode="";
		  %>
		      <td class='LABEL' ><fmt:message key="Common.country.label" bundle="${common_labels}"/></td>
			  <td class='QUERYDATA' ><%=escort_contcode %>&nbsp;</td>
   			 <td class='LABEL'  colspan='2'>&nbsp;</td>
	  </tr>
	  <tr><td colspan='4' class='label' height='5'></td></tr>
		 <tr>
		      <td class='LABEL' nowrap><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
  		      <td class='fields'  colspan='3' >&nbsp;<textarea cols='60' rows='2' readonly tabindex='-1'><%=escort_remarks%></textarea>
 			  </td>
	      </tr>	
		  <tr>
				<td class='COLUMNHEADER' colspan='4' ><fmt:message key="eAE.AmbulanceDetails.label" bundle="${ae_labels}"/></td>
		  </tr>
		  <tr><td colspan='4' class='label' height='5'></td></tr>
		  <tr>
			  <td class='LABEL' nowrap><fmt:message key="eAE.NameofEscortService.label" bundle="${ae_labels}"/></td>
  		      <td class='QUERYDATA' ><%=escort_name%>&nbsp;</td>
			  <td class='LABEL' colspan='2'>&nbsp;</td>
	     </tr>	
	  <tr><td colspan='4' class='label' height='5'></td></tr>
		 <tr>
			  <td class='LABEL'  nowrap><fmt:message key="eAE.EscAmbulanceContNo.label" bundle="${ae_labels}"/></td>
  		      <td class='QUERYDATA' ><%=escort_tel_no%>&nbsp;</td> 
			  <td class='LABEL' colspan='2'>&nbsp;</td>
	     </tr>	
	  <tr><td colspan='4' class='label' height='5'></td></tr>
		  <tr>
			  <td class='LABEL' nowrap><fmt:message key="eAE.VehicleRegNo.label" bundle="${ae_labels}"/></td>
  		      <td class='QUERYDATA' ><%=escort_mv_reg_no%>&nbsp;</td> 
			  <td class='LABEL' colspan='2'>&nbsp;</td>
	     </tr>	
	  <tr><td colspan='4' class='label' ></td></tr>
     </table>

	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br><br>
     <!--  <a name="tab3" ></a>  -->
 <a name="tab3" id="tab3" ></a> 
	  <table cellspacing='0' cellpadding='0' width='97%' border=0 align='center'>
        <tr><td class='white'>
				  <ul id="tablist" class="tablist" >
						<li class="tablistitem" title="Add Visit">
							<a onclick="tab_click1('addVisit_tab')" class="tabA" id='addVisit_tab' >
								<span class="tabAspan" id="addVisit_tabspan"><fmt:message key="Common.VisitDetail.label" bundle="${common_labels}"/></span>
							</a>
						</li>
						<li class="tablistitem" title="Arrival">
							<a onclick="tab_click1('arrival_tab')" class="tabA" id="arrival_tab" >
								<span class="tabAspan" id="arrival_tabspan"><fmt:message key="Common.arrival.label" bundle="${common_labels}"/></span>
							</a>
						</li>
						<li class="tablistitem" title="Related Contact details">
							<a onclick="tab_click1('rlcnts_tab')" class="tabClicked" id="rlcnts_tab" >
								<span class="tabSpanclicked" id="rlcnts_tabspan"><fmt:message key="eMP.relatedcontacts.label" bundle="${mp_labels}"/></span>
							</a>
						</li>	
			</ul>
	 </td></tr></table>
	<table cellspacing='0' cellpadding='0' width='97%' border=0 align='center'>
      <tr><td class='white'>
	  	<a name='kin' id='kin'></a>
			<ul id="tablist" class="tablist">
				<li class="tablistitem" title="Next of kin">
					<a onclick="tab_click2('#kin','firstkin')" class="tabClicked" id="firstkin" >
						<span class="tabSpanclicked" id="firstkinspan"><fmt:message key="Common.nextofkin.label" bundle="${common_labels}"/></span>
					</a>
				</li>
				<li class="tablistitem" title="Contact Mode and Address details">
					<a onclick="tab_click2('#kin1','firstkin1')" class="tabA" id="firstkin1" >
						<span class="tabAspan" id="firstkin1span"><fmt:message key="Common.firsttonotify.label" bundle="${common_labels}"/></span>
					</a>
				</li>
				<li class="tablistitem" title="Employment Details">
					<a onclick="tab_click2('#empyr','firstempyr')" class="tabA" id="firstempyr" >
						<span class="tabAspan" id="firstempyrspan"><fmt:message key="Common.employmentdetails.label" bundle="${common_labels}"/></span>
					</a>
				</li>	
			</ul>
          </td></tr>
</table>

	<table border="0" cellpadding="3" cellspacing="0" align='center' width='97%'>
	<tr>
		<td class='COLUMNHEADER' colspan='4' ><fmt:message key="Common.nextofkin.label" bundle="${common_labels}"/></td>
	</tr>

     <tr><td colspan='4' class='label' height='5'></td></tr>
	 <%if(isAENextofKinchngAppl) // Added by mujafar for ML-MMOH-CRF-0632
	 {	 
	 %>
	  <tr>
		  <td class='LABEL'  width="25%"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
  		  <td class='QUERYDATA' width='500px' style="word-wrap: break-word;width:500px" ><%=rel_pat_id%>&nbsp;</td> 
			 <td class='LABEL' colspan='2'>&nbsp;</td>
     </tr>
	 <%}%>
	 
	 <tr>
		  <td class='LABEL'  width="25%"><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
  		  <td class='QUERYDATA' width='500px' style="word-wrap: break-word;width:500px" ><%=name%>&nbsp;</td> 
			 <td class='LABEL' colspan='2'>&nbsp;</td>
     </tr>
	 <tr><td colspan='4' class='label' height='5'></td></tr>
	 <tr>
			<td class='LABEL'><fmt:message key="Common.relationship.label" bundle="${common_labels}"/></td>
			<%
			pstmt = con.prepareStatement(sqlRelation.toString());
			rset = pstmt.executeQuery();
			while(rset!=null && rset.next())
			{
			if(relationship!=null && relationship.equalsIgnoreCase(rset.getString(1)))
				 relationship= rset.getString(2);
			}
			if(pstmt!=null) pstmt.close();
			if(rset!=null) rset.close();
			if((sqlRelation != null) && (sqlRelation.length() > 0))
		    {
				sqlRelation.delete(0,sqlRelation.length());
		    }
			%>
  		     <td class='QUERYDATA'  ><%=relationship%>&nbsp;</td>
   			 <td class='LABEL' align='RIGHT' colspan='2'>&nbsp;</td>
	  </tr>
		 <tr><td colspan='4' class='label' height='5'></td></tr>
		   <tr>
		      <td class='LABEL' ><%=nat_id_prompt%>&nbsp;</td>
  		      <td class='QUERYDATA' ><%=contact1_national_id_no%></td>
   			  <td class='LABEL'  colspan='2'>&nbsp;</td>
	  </tr>
	  <tr><td colspan='4' class='label' height='5'></td></tr>
	  <tr>
		      <td class='LABEL' ><fmt:message key="eMP.occupation.label" bundle="${mp_labels}"/></td>
  		      <td class='QUERYDATA' ><%=job1_title%></td>
			  <td class='LABEL'  colspan='2'>&nbsp;</td>
	  </tr>
	  <tr><td colspan='4' class='label' height='5'></td></tr>
	  <%contact1_birth_date=DateUtils.convertDate(contact1_birth_date,"DMY","en",locale);%>
	  <tr>
		      <td class='LABEL' ><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/></td>
  		      <td class='QUERYDATA' ><%=contact1_birth_date%> </td>
   			  <td class='LABEL' colspan='2'>&nbsp;</td>
	  </tr>
	  <tr><td colspan='4' class='label' height='5'></td></tr>
	<%
	
	String[] address1_fld_values=	{addr1_line1,addr1_line2,addr1_line3,addr1_line4,next_area,next_town,next_region,postal1_desc};
	String[]address2_fld_values=	{addr2_line1,addr2_line2,addr2_line3,addr2_line4,first_area,first_town,first_region,postal2_desc};
	String[]address3_fld_values=			{addr3_line1,addr3_line2,addr3_line3,addr3_line4,emp_area,emp_town,emp_region,postal3_desc};

	
	for(int i=0;i<contact_col_names.length;i++) 
	{
			out.println("<tr>");
			out.println("<td class='LABEL'>"+contact_prompts[i]+"</td>") ;		
				

			for(int j=0; j<address_col_names.length; j++)
			{
				
				if(address_col_names[j].equals(contact_col_names[i]))
				{
					if(address_col_names[j].equals("POSTAL_CODE_PROMPT"))
					{
				
                    //Below line modified for ML-MMOH-CRF-0860.2
					out.println("<td class='QUERYDATA' width='"+data_width1+"' style='"+data_word_wrap1+"' >"+address1_fld_values[j]+"&nbsp;</td>"); 
					out.println("<td <td class='LABEL' colspan='2'>&nbsp;</td></tr>");
                    out.println("<tr><td colspan='4' class='label' height='5'></td></tr>");
					}
					else
					{
					//Below line modified for ML-MMOH-CRF-0860.2
					out.println("<td class='QUERYDATA' width='"+data_width1+"' style='"+data_word_wrap1+"' >"+address1_fld_values[j]+"&nbsp;</td>"); 
					out.println("<td <td class='LABEL' colspan='2'>&nbsp;</td></tr>");
					out.println("<tr><td colspan='4' class='label' height='5'></td></tr>");
					}
					
				} 
			}   
	}
			  pstmt = con.prepareStatement(sqlCountry.toString());
			  rset = pstmt.executeQuery();
			  while(rset!=null && rset.next())
			  {
			  if(country1_code!=null && country1_code.equalsIgnoreCase(rset.getString(1)))
				    country1_code	=	rset.getString(2);
			  if(country2_code!=null && country2_code.equalsIgnoreCase(rset.getString(1)))
				    country2_code	=	rset.getString(2);
			   if(country3_code!=null && country3_code.equalsIgnoreCase(rset.getString(1)))
				    country3_code	=	rset.getString(2);
			  }
						   if(pstmt!=null) pstmt.close();
						   if(rset!=null) rset.close();
						   if((sqlCountry != null) && (sqlCountry.length() > 0))
							 {
								sqlCountry.delete(0,sqlCountry.length());
							 }
		  %>
      <tr>
		      <td class='LABEL' ><fmt:message key="Common.country.label" bundle="${common_labels}"/></td>
			  <td class='QUERYDATA' ><%=country1_code%>&nbsp;</td>
   			  <td class='LABEL' align='RIGHT' colspan='2'>&nbsp;</td>

	  </tr>
	  <tr><td colspan='4' class='label' height='5'></td></tr>
	  <tr>
		      <td class='LABEL' nowrap><fmt:message key="Common.homephoneno.label" bundle="${common_labels}"/></td>  		      
			  <td class='QUERYDATA'><%=res1_tel_no%>&nbsp;</td> 
		      <td class='LABEL' colspan='2'>&nbsp;</td>
	  </tr>
	  <tr><td colspan='4' class='label' height='5'></td></tr>
	  <tr> 
		      <td class='LABEL'  nowrap><fmt:message key="Common.MobileNo.label" bundle="${common_labels}"/></td>  		      
			  <td class='QUERYDATA'  ><%=CONTACT1_MOB_TEL_NO%>&nbsp;</td>
   			 <td class='LABEL' colspan='2'>&nbsp;</td>
	  </tr>
	  <tr><td colspan='4' class='label' height='5'></td></tr>
	  <tr>
		      <td class='LABEL' ><fmt:message key="Common.officephoneno.label" bundle="${common_labels}"/></td>
			  <td class='QUERYDATA' ><%=off1_tel_no%></td>
		      <td class='LABEL'  colspan='2'>&nbsp;</td>
	  </tr>
	  <tr><td colspan='4' class='label' height='5'></td></tr>
	  <tr>
			  <td class='LABEL' nowrap><fmt:message key="Common.email.label" bundle="${common_labels}"/></td>  		      
			  <td class='QUERYDATA' ><%=CONTACT1_EMAIL_ID%></td>
   			  <td class='LABEL'  colspan='2'>&nbsp;</td>
	  </tr> 
	 <tr><td colspan='4' class='label' height='5'></td></tr>
     </table>
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
		<br><br><br><br><br><br><br><br><br><br><br>

  <a name="kin1" id='kin1' ></a> 
  <table cellspacing='0' cellpadding='0' width='97%' border=0 align='center'>
    <tr><td class='white'>
		<ul id="tablist" class="tablist">
					<li class="tablistitem" title="Add Visit">
						<a onclick="tab_click1('addVisit_tab')" class="tabA" id='addVisit_tab' >
							<span class="tabAspan" id="addVisit_tabspan"><fmt:message key="Common.VisitDetail.label" bundle="${common_labels}"/></span>
						</a>
					</li>
					<li class="tablistitem" title="Arrival">
						<a onclick="tab_click1('arrival_tab')" class="tabA" id="arrival_tab" >
							<span class="tabAspan" id="arrival_tabspan"><fmt:message key="Common.arrival.label" bundle="${common_labels}"/></span>
						</a>
					</li>
					<li class="tablistitem" title="Related Contact details">
						<a onclick="tab_click1('rlcnts_tab')" class="tabClicked" id="rlcnts_tab" >
							<span class="tabSpanclicked" id="rlcnts_tabspan"><fmt:message key="eMP.relatedcontacts.label" bundle="${mp_labels}"/></span>
						</a>
					</li>	
		</ul>
	</td></tr></table>
	<table cellspacing='0' cellpadding='0' width='97%' border=0 align='center'>
       <tr >
		   <td class='white'>
				<ul id="tablist" class="tablist" >
					<li class="tablistitem" title="Next of kin">
						<a onclick="tab_click2('#kin','secondkin')" class="tabA" id="secondkin" >
							<span class="tabAspan" id="secondkinspan"><fmt:message key="Common.nextofkin.label" bundle="${common_labels}"/></span>
						</a>
					</li>
					<li class="tablistitem" title="Contact Mode and Address details">
						<a onclick="tab_click2('#kin1','secondkin1')" class="tabClicked" id="secondkin1" >
							<span class="tabSpanclicked" id="secondkin1span"> <fmt:message key="Common.firsttonotify.label" bundle="${common_labels}"/></span>
						</a>
					</li>

					<li class="tablistitem" title="Employment Details">
						<a onclick="tab_click2('#empyr','secondempr')" class="tabA" id="secondempr" >
							<span class="tabAspan" id="secondemprspan"><fmt:message key="Common.employmentdetails.label" bundle="${common_labels}"/></span>
						</a>
					</li>	
			   </ul>
	       </td>
	   </tr>
     </table>

	  <table border="0" cellpadding="3" cellspacing="0" align='center' width='97%'>
	  <tr>
		<td class='COLUMNHEADER' colspan='4' ><fmt:message key="Common.firsttonotify.label" bundle="${common_labels}"/></td>
	  </tr>
	  <tr><td colspan='4' class='label' height='5'></td></tr>
	  <tr>
             <td class='LABEL'  width="25%"><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
  		     <td class='QUERYDATA' nowrap><font   size=1><%=first_to_notify_name%></font></td>
   			 <td class='LABEL'  colspan='2'>&nbsp;</td>
	  </tr>
	  <tr><td colspan='4' class='label' height='5'></td></tr>
	  <tr>
			  <td class='LABEL'  width="25%"><fmt:message key="Common.relationship.label" bundle="${common_labels}"/></td>
  		      <td class='QUERYDATA' nowrap><font   size=1><%=first_relation%></font></td>
   			  <td class='LABEL' colspan='2'>&nbsp;</td>
	  </tr>
	  <tr><td colspan='4' class='label' height='5'></td></tr>
	  <tr>
		      <td class='LABEL' ><%=nat_id_prompt%></td>
  		      <td class='QUERYDATA' ><%=CONTACT2_NATIONAL_ID_NO%>&nbsp;</td>
   			 <td class='LABEL' colspan='2'>&nbsp;</td>
	  </tr>
	  <tr><td colspan='4' class='label' height='5'></td></tr>
	  <tr>
		   <td class='LABEL' ><fmt:message key="eMP.occupation.label" bundle="${mp_labels}"/></td>
  		   <td class='QUERYDATA'><%=job2_title%></td>
   		   <td class='LABEL' colspan='2'>&nbsp;</td>
	  </tr>
 <tr><td colspan='4' class='label' height='5'></td></tr>
<%
	for(int i=0;i<contact_col_names.length;i++) 
	{
			out.println("<tr>") ;		
			out.println("<td class='LABEL' nowrap>"+contact_prompts[i]+"</td>") ;		
				
			for(int j=0; j<address_col_names.length; j++)
			{
				if(address_col_names[j].equals(contact_col_names[i]))
				{
					if(address_col_names[j].equals("POSTAL_CODE_PROMPT"))
					{
					/*Below line added for ML-MMOH-CRF-0860.2*/
					out.println("<td class='QUERYDATA' width='"+data_width1+"' style='"+data_word_wrap1+"' >"+address2_fld_values[j]+"&nbsp;</td>"); 
					out.println("<td <td class='LABEL' colspan='2'>&nbsp;</td></tr>");
					out.println("<tr><td colspan='4' class='label' height='5'></td></tr>");
					}
					else
					{
					/*Below line added for ML-MMOH-CRF-0860.2*/
					out.println("<td class='QUERYDATA' width='"+data_width1+"' style='"+data_word_wrap1+"' >"+address2_fld_values[j]+"&nbsp;</td>"); 
					out.println("<td <td class='LABEL' colspan='2'>&nbsp;</td></tr>");
					out.println("<tr><td colspan='4' class='label' height='5'></td></tr>");
					}
				} 
			}   
	}
	%>
	  <tr>  
		      <td class='LABEL'><fmt:message key="Common.country.label" bundle="${common_labels}"/></td>
			  <td class='QUERYDATA' ><%=country2_code%></td>
   			  <td class='LABEL'  colspan='2'></td>

	  </tr>
	  <tr><td colspan='4' class='label' height='5'></td></tr>
	  <tr>
		      <td class='LABEL' nowrap><fmt:message key="Common.homephoneno.label" bundle="${common_labels}"/></td>  		      
			  <td class='QUERYDATA'  ><%=res2_tel_no%></td>
   			 <td class='LABEL' colspan='2'></td>
    </tr>
       <tr><td colspan='4' class='label' height='5'></td></tr>
	  <tr>
		      <td class='LABEL' nowrap><fmt:message key="Common.officephoneno.label" bundle="${common_labels}"/></td>  		      
			  <td class='QUERYDATA' ><%=off2_tel_no%></td>
   			 <td class='LABEL' colspan='2'>&nbsp;</td>
	  </tr>  
	  <tr><td colspan='4' class='label' height='5'></td></tr>
	  <tr>
		      <td class='LABEL'  nowrap><fmt:message key="Common.MobileNo.label" bundle="${common_labels}"/></td>  		      
			  <td class='QUERYDATA' ><%=CONTACT2_MOB_TEL_NO%></font></td>
   			 <td class='LABEL' colspan='2'>&nbsp;</td>
	  </tr>  
	  <tr><td colspan='4' class='label' height='5'></td></tr>
	  <tr>
		      <td class='LABEL'nowrap><fmt:message key="Common.email.label" bundle="${common_labels}"/></td>  		      
			  <td class='QUERYDATA'><%=CONTACT2_EMAIL_ID%></td>
   			 <td class='LABEL' colspan='2'>&nbsp;</td>
	  </tr>
	  <tr><td colspan='4' class='label' height='5'></td></tr>
    </table>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
		<br><br><br><br><br><br><br><br><br><br><br>


 <a name="empyr"  id="empyr"></a> 
  <table cellspacing='0' cellpadding='0' width='97%' border=0 align='center'>
    <tr><td class='white'>
		  <ul id="tablist" class="tablist">
				<li class="tablistitem" title="Add Visit">
					<a onclick="tab_click1('addVisit_tab')" class="tabA" id='addVisit_tab' >
						<span class="tabAspan" id="addVisit_tabspan"><fmt:message key="Common.VisitDetail.label" bundle="${common_labels}"/></span>
					</a>
				</li>
				<li class="tablistitem" title="Arrival">
					<a onclick="tab_click1('arrival_tab')" class="tabA" id="arrival_tab" >
						<span class="tabAspan" id="arrival_tabspan"><fmt:message key="Common.arrival.label" bundle="${common_labels}"/></span>
					</a>
				</li>
				<li class="tablistitem" title="Related Contact details">
					<a onclick="tab_click1('rlcnts_tab')" class="tabClicked" id="rlcnts_tab" >
						<span class="tabSpanclicked" id="rlcnts_tabspan"><fmt:message key="eMP.relatedcontacts.label" bundle="${mp_labels}"/></span>
					</a>
				</li>	
		 </ul>
	</td></tr></table>
	<table cellspacing='0' cellpadding='0' width='97%' border=0 align='center'>
        <tr><td class='white'>

	<ul id="tablist" class="tablist" >
			<li class="tablistitem" title="Next of kin">
				<a onclick="tab_click2('#kin','thirdkin')" class="tabA" id="thirdkin" >
					<span class="tabAspan" id="thirdkinspan"><fmt:message key="Common.nextofkin.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			<li class="tablistitem" title="Contact Mode and Address details">
				<a onclick="tab_click2('#kin1','thirdkin1')" class="tabA" id="thirdkin1" >
					<span class="tabAspan" id="thirdkin1span"> <fmt:message key="Common.firsttonotify.label" bundle="${common_labels}"/></span>
				</a>
			</li>

			
			<li class="tablistitem" title="Employment Details">
				<a onclick="tab_click2('#empyr','thirdempr')" class="tabClicked" id="thirdempr" >
					<span class="tabSpanclicked" id="thirdemprspan"><fmt:message key="Common.employmentdetails.label" bundle="${common_labels}"/></span>
				</a>
			</li>	
		</ul>
	</td></tr></table>
    <!--Below line added for ML-MMOH-CRF-0860.2-->
	<table border="0" cellpadding="3" cellspacing="0" align='center' width='<%=tab_width%>'>
				<table cellspacing='0' cellpadding='3' width='<%=tab_width%>' border='0' align='center'>
				<tr>
                   <td align='center' class='COLUMNHEADER' ><fmt:message key="Common.employerdetails.label" bundle="${common_labels}"/></td>
				   <td align='center' class='COLUMNHEADER' ><fmt:message key="Common.employeedetails.label" bundle="${common_labels}"/></td>
                </tr>
				<tr>
				<td><table cellspacing='0' cellpadding='3' width='<%=tab_width%>' border='0' align='center'>
				<tr><td colspan=4 class=label height=5></td></tr>
				<tr>

				  <td class='LABEL' width='<%=header_width%>'><fmt:message key="Common.orgName.label" bundle="${common_labels}"/></td>
				  <td class='QUERYDATA' width='<%=data_width%>' style='<%=data_word_wrap%>' ><%=employer_name%>&nbsp;</td>
				  
	  </tr>
      <tr><td colspan=4 class=label height=5></td></tr>
	  <tr>
		      <td class='LABEL' width='<%=header_width%>' ><fmt:message key="eMP.ContactPersonName.label" bundle="${mp_labels}"/></td>
  		      <td class='QUERYDATA' width='<%=data_width%>' ><%=contact3_name%>&nbsp;</td>
	  </tr>
      <tr><td colspan=4 class=label height=5></td></tr>
	  <%	
	
	for(int i=0;i<contact_col_names.length;i++) 
	{
			out.println("<tr>");
			out.println("<td class='LABEL' width='"+header_width+"' >"+contact_prompts[i]+"</td>") ;					
			for(int j=0; j<address_col_names.length;j++)
			{
				if(address_col_names[j].equals(contact_col_names[i]))
				{
					if(address_col_names[j].equals("POSTAL_CODE_PROMPT"))
					{
					out.println("<td class='QUERYDATA' width='"+data_width+"' style='"+data_word_wrap+"' >"+ address3_fld_values[j]+ "</td>"); 
					out.println("</tr>"); 
					out.println("<tr><td colspan='4' class='label' height='5'></td></tr>");
					}
					else
					{
					out.println("<td class='QUERYDATA' width='"+data_width+"' style='"+data_word_wrap+"' >"+address3_fld_values[j]+"&nbsp;</td>"); 
					out.println("</tr>"); 
					out.println("<tr><td colspan='4' class='label' height='5'></td></tr>");
					}
				} 
			}   
	}
	%>
    <tr>
		      <td class='LABEL' width='<%=header_width%>' ><fmt:message key="Common.country.label" bundle="${common_labels}"/></td>
			  <td class='QUERYDATA' align='left' width='<%=data_width%>' ><%=country3_code%>&nbsp;</td>

	  </tr>
		  <tr><td colspan='4' class='label' height='5'></td></tr>
 	  <tr>
		      <td class='LABEL' width='<%=header_width%>' ><fmt:message key="Common.homephoneno.label" bundle="${common_labels}"/></td>
			  <td class='QUERYDATA'  width='<%=data_width%>' ><%=res3_tel_no%>&nbsp;</td>
	  </tr> 
	  <tr><td colspan='4' class='label' height='5'></td></tr>
	  <tr>
		      <td class='LABEL' width='<%=header_width%>'><fmt:message key="Common.officephoneno.label" bundle="${common_labels}"/></td>  		      
			  <td class='QUERYDATA'  width='<%=data_width%>' ><%=off3_tel_no%>&nbsp;</td>
               </tr><tr><td colspan=4 class=label height=5></td></tr>
			   </table></td>
			   <td valign=top>
		        <table cellspacing='1' cellpadding='0' width='<%=tab_width1%>' border=0>
			   <tr><td colspan=2 class=label height=5></td></tr>
			 <tr>
			 <td class='LABEL' width='<%=header_width%>' ><fmt:message key="Common.employmentid.label" bundle="${common_labels}"/></td>				
	         <td class='QUERYDATA' width='<%=data_width%>' ><%=patient_employee_id%>&nbsp;</td>
	 </tr>  
	 <tr><td colspan='2' class='label' height='5'></td></tr> 
	 <tr>
          <td class='LABEL' width='<%=header_width%>' ><fmt:message key="eMP.OccupationClass.label" bundle="${mp_labels}"/></td>
          <td class='QUERYDATA'  width='<%=data_width%>' ><%=occ_class%>&nbsp;</td>
	 </tr>
	 <tr><td colspan=4 class=label height=5></td></tr>
     <tr>
          <td class='LABEL' width='<%=header_width%>' ><fmt:message key="eMP.OccupationofthePerson.label" bundle="${mp_labels}"/></td>
          <td class='QUERYDATA'  width='<%=data_width%>' style='<%=data_word_wrap%>' ><%=ocpn_desc%>&nbsp;</td>
	 </tr>
	 <tr><td colspan='4' class='label' height='5'></td></tr>
	 <tr>
			<td class='LABEL' width='<%=header_width%>' ><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
			<td class='QUERYDATA' width='<%=data_width%>' ><%=employee_status%>&nbsp;</td>
	</tr>			 
  </td>
	</tr>
	<!--End ML-MMOH-CRF-0860.2 -->
</table></table>

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>	  

		 </form>
	 </body>  
<%
    }
    catch(Exception e)
    {
        //out.print(e.toString());
		e.printStackTrace();
    }
    finally
    {
		if(con!=null)		
	    ConnectionManager.returnConnection(con,request);
    }
%>
<%!
	// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equalsIgnoreCase("null"))) ? "" : inputString );
	}
//To handle HTML Special characters for GHL-CRF-0650 by Ajay Hatwate
public static String escapeHTML(String s) {
    StringBuilder procStr = new StringBuilder(Math.max(16, s.length()));
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (c > 127 || c == '"' || c == '\'' || c == '<' || c == '>' || c == '&') {
        	procStr.append("&#");
        	procStr.append((int) c);
        	procStr.append(';');
        } else {
        	procStr.append(c);
        }
    }
    return procStr.toString();
}

public static String addSpaces(String s, int position){
	String procStr = "";
	int bi = 0;
	if(s.length() > position){
			for(int i = 1; i < s.length(); i++){
				if(i%position == 0){
					procStr = procStr+" " + s.substring(bi, i);
					bi = i+1;
				}
			}
			procStr = procStr+" " + s.substring(bi, s.length());
	}else{
		procStr = s;
	}
	return procStr;
}
%>
</html>

