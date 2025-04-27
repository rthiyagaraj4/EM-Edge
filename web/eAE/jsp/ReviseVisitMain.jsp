<!DOCTYPE html>
 
 <%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,com.ehis.util.*,org.json.simple.*,eCommon.XSSRequestWrapper"   contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head> 
<%@ include file="../../eMP/jsp/PatientAddressLegends.jsp" %>

 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 
  <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
  <link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
  <link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
  <script language='javascript' src='../../eCommon/js/common.js'></script>
  <Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
  <script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
  <script language='javascript' src='../../eAE/js/AEReviseVisit.js'></script> 
  <script language='javascript' src='../../eCommon/js/DateUtils.js'> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
  <script>
/*
    function tab_click(objName)
	{
		   if(objName=="addVisit_tab")
			{
				document.getElementById("tab1").scrollIntoView();
				//document.forms[0].referal_id.focus();
			}
		   if(objName=="arrival_tab")
			{
			   	document.getElementById("tab2").scrollIntoView();
				document.forms[0].accompany_by.focus();
				//alert("accompany_by "+document.forms[0].accompany_by.value);
				//if (!document.forms[0].accompany_by.disabled) 
					
			}
			if(objName=="rlcnts_tab")
			{
				document.getElementById("kin").scrollIntoView();
				if(document.forms[0].next_contact_name.disabled==false)
					 document.forms[0].next_contact_name.focus();
			}
			if(objName=="#kin") 
			{
				document.getElementById("kin").scrollIntoView();
				document.getElementById("next_contact_name").focus();
			}
			if(objName=="#kin1") 
			{
				document.getElementById("kin1").scrollIntoView();
				document.getElementById("notify_name").focus();
			}
			if(objName=="#empyr")
			{
				document.getElementById("empyr").scrollIntoView();
				document.getElementById("organization_name").focus();
			}
	}

	function tab_click1(id) 
		{
			selectTab(id);
			tab_click(id);
		}

	function tab_click2(id,idval)
		{
				selectTab(idval);
				tab_click22(id);
		}

	function tab_click22(Object)
		{
			if(Object=='#kin')
			{

			 	if(document.getElementById("next_contact_name")!=null&&document.getElementById("next_contact_name").disabled==false)
				document.getElementById("next_contact_name").focus();
				else
				 document.getElementById("kin").scrollIntoView();
			}
			if(Object=='#kin1')
			{
				if(document.getElementById("notify_name")!=null&&document.getElementById("notify_name").disabled==false)
				document.getElementById("notify_name").focus();
				 else
				   document.getElementById("kin1").scrollIntoView();
			}
			if(Object=='#empyr')
			{
				if(document.getElementById("organization_name")!=null&&document.getElementById("organization_name").disabled==false)
				document.getElementById("organization_name").focus();
				else
				  document.getElementById("empyr").scrollIntoView();

			}
		} */

function onTabClickOf(obj) {
    if (obj !== 'addVisit_tab') {
        document.getElementById("addVisit_tab").className = "tabA";
        document.getElementById("addVisit_tabspan").className = "tabAspan";
    }

    if (obj === 'addVisit_tab') {
        selectTab(obj);
        document.getElementById("VisitTab").style.display = 'inline';
        document.getElementById("ArriveTab").style.display = 'none';
        document.getElementById("Relatedtab").style.display = 'none';
        document.getElementById("nextOfKin").style.display = 'none';
        document.getElementById("Addressdetails").style.display = 'none';
        document.getElementById("EmploymentDetails").style.display = 'none';
    } else if (obj === 'arrival_tab') {
        selectTab(obj);
        document.getElementById("VisitTab").style.display = 'none';
        document.getElementById("ArriveTab").style.display = 'inline';
        document.getElementById("Relatedtab").style.display = 'none';
        document.getElementById("nextOfKin").style.display = 'none';
        document.getElementById("Addressdetails").style.display = 'none';
        document.getElementById("EmploymentDetails").style.display = 'none';
    } else if (obj === 'rlcnts_tab') {
        selectTab(obj);
        document.getElementById("VisitTab").style.display = 'none';
        document.getElementById("ArriveTab").style.display = 'none';
        document.getElementById("Relatedtab").style.display = 'inline';
        document.getElementById("nextOfKin").style.display = 'inline';
        document.getElementById("Addressdetails").style.display = 'none';
        document.getElementById("EmploymentDetails").style.display = 'none';
    } else if (obj === 'firstkin') {
        selectTab(obj);
        document.getElementById("VisitTab").style.display = 'none';
        document.getElementById("ArriveTab").style.display = 'none';
        document.getElementById("Relatedtab").style.display = 'inline';
        document.getElementById("nextOfKin").style.display = 'inline';
        document.getElementById("Addressdetails").style.display = 'none';
        document.getElementById("EmploymentDetails").style.display = 'none';
    } else if (obj === 'firstkin1') {
        selectTab(obj);
        document.getElementById("VisitTab").style.display = 'none';
        document.getElementById("ArriveTab").style.display = 'none';
        document.getElementById("Relatedtab").style.display = 'inline';
        document.getElementById("nextOfKin").style.display = 'none';
        document.getElementById("Addressdetails").style.display = 'inline';
        document.getElementById("EmploymentDetails").style.display = 'none';
    } else if (obj === 'firstempyr') {
        selectTab(obj);
        document.getElementById("VisitTab").style.display = 'none';
        document.getElementById("ArriveTab").style.display = 'none';
        document.getElementById("Relatedtab").style.display = 'inline';
        document.getElementById("nextOfKin").style.display = 'none';
        document.getElementById("Addressdetails").style.display = 'none';
        document.getElementById("EmploymentDetails").style.display = 'inline';
    }
}
  </script>

  </head>

<%   
        Connection con					    = null;
		PreparedStatement pstmt				= null;
    	PreparedStatement oth_stmt			= null;
		PreparedStatement pstmtR		    = null;
        ResultSet rset					    = null ;
        ResultSet rsetR					    = null ;
        ResultSet oth_rset			        = null ;
		/*Added by Thamizh selvi on 7th Aug 2018 against ML-MMOH-CRF-1177 Start*/
		Boolean isAutoPopulateNOKDOBAppl = false;
		String natInvokeRoutine = "";
		String natDataSourceId = "";
		/*End*/
		Boolean isPriorityZoneAppl			=	false;//Added By Shanmukh for MMS-DM-CRF-0147
   try{
        
		String[] contact_col_names			= null ;
		String[] contact_prompts			= null ;
		String[] contact_fields				= null ;
        request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");

	    String locale						= (String)session.getAttribute("LOCALE");
		java.util.Properties p				= (java.util.Properties) session.getValue( "jdbc" ) ;
		con = ConnectionManager.getConnection(request);
	/*Below line(s) added by venkateshs against ML-MMOH-CRF-0354 [IN057191] */
		boolean siteSpecific		=eCommon.Common.CommonBean.isSiteSpecific(con, "MR","MLC_TO_MEDICO_LEGAL_CASE"); 
		/*end ML-MMOH-CRF-0354 [IN057191] */
		Boolean isLabelChngAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AE","LABEL_CHG_BR_DEAD_PLACE_ACCDNT"); //Added by Ashwini on 18-Jan-2017 for GDOH-CRF-0131 and GDOH-CRF-0123
		Boolean isAENextofKinchngAppl   = false; // Added by mujafar for ML-MMOH-CRF-0632
		isAENextofKinchngAppl  = eCommon.Common.CommonBean.isSiteSpecific(con, "AE","AE_NEXT_OF_KIN_CHNG_APPL"); // Added by mujafar for ML-MMOH-CRF-0632
		isAutoPopulateNOKDOBAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","AUTO_POPULATE_NOK_DOB");//Added by Thamizh selvi on 7th Aug 2018 against ML-MMOH-CRF-1177
		isPriorityZoneAppl			= eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "PRIORITY_ZONE");//Added By Shanmukh for MMS-DM-CRF-0147

		//Added by Ashwini on 12-Feb-2020 for AAKH-CRF-0079.11
		Boolean isInvokeUploadDocAppl =  eCommon.Common.CommonBean.isSiteSpecific(con,"MP","INVOKE_UPLOAD_DOCUMENT");

		//Added for this CRF ML-MMOH-CRF-0860.2
	String maxsize="30";	
	String maximumLength="30";
	Boolean increasedaddressLength = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","INCREASED_ADDRESS_LINE_LENGTH");
	if(increasedaddressLength){	  
	  maximumLength="50";
	 // maxsize="58";
	    maxsize="64";
	}
	//End this ML-MMOH-CRF-0860.2
		
	 	
		ArrayList contact_addr				= fetchContactAddresses(con, out,"parent.parent.messageFrame",p) ;
		contact_col_names					= (String[])contact_addr.get(1) ;
		contact_prompts						= (String[])contact_addr.get(2) ;
		contact_fields						= (String[])contact_addr.get(3) ;
		contact_addr						= null;
		String referral_id					= "";
		String nat_id_prompt				= "";
		String accept_national_id_no_yn		= "";
		String nat_id_accept_alphanumeric_yn= "";
		String accompany_by					= "";
		String nat_id_length				= "";
		String accept_oth_alt_id_yn			= "";
		String contact1_res_area_desc		= "";
		String contact1_email_id			= "";
		String blood_group					= "";
		String rh_factor					= "";
		String sysDateWithoutTime			= "";
		String nationality_id				= "";
		String nationality					= "";
		String alt_id1_type                 ="";
		String alt_id2_type                 ="";
		String alt_id3_type                 ="";
		String alt_id4_type                 ="";
		String alt_id1_no			     	= "";
		String alt_id2_no				    = "";
		String alt_id3_no				    = "";
		String alt_id4_no				    = "";
		String heightVal					= "";
		String weightVal					= "";
		String circumVal					= "";
		String start_date					= "";
		String paediatric_yn				= "";
		String gynaec_yn					= "";
		String legal_status					= "";
		String residency					= "";	
		String oth_alt_id_desc				= "";
		String oth_alt_id_no				= "";	
		String alt_id1_desc					= "";
		String alt_id2_desc					= "";
		String alt_id3_desc					= "";
		String alt_id4_desc					= "";
		String pat_dtls_unknown_yn			= "";
		String treatment_area_code_desc		= "";
		String priority_zone				= "";
		String priority_zone_desc			= "";
		String arr_res_town_desc			= "";
		String bed_no						= "";
		String disaster_yn					= "";
		String disaster_area_desc			= "";
		String assign_care_locn_code		= "";
		String visit_type_code				= "";
        String service_code					= "";
		String speciality_code				= "";
		String disaster_type_desc           = "";
	    // For Arrival
		String service_desc					= "";
		String visit_adm_date_time			= "";
		String visit_type_desc				= "";
		String location1					= "";
		String subservice_desc				= "";
		String mode_of_arrival				= "";
		String transport_mode				= "";
		String brought_dead_yn				= "";
		String mlc_case_yn					= "";
		String medico_legal_details			= "";
		String escort_type					= "";
		String escort_name					= "";
		String escort_add_ln1				= "";
		String escort_add_ln2				= "";
		String escort_add_ln3				= "";
		String escort_add_ln4				= "";	
		String escort_tel_num				= "";
		String escort_mv_reg_no				= "";
		String relation_to_patient			= "";
		String escort_remarks				= "";
		String disRefID						= "";
		// For AE Related Contacts
		String contact1_relation			= "";
		String contact1_name				= "";
		String addr1_line1					= "";	
		String addr1_line2					= "";
		String addr1_line3					= "";
		String addr1_line4					= "";
		String postal1_code					= "";
		String country1_code				= "";
		String countryescort_code			= "";
		String res1_tel_no					= "";
		String off1_tel_no					= "";
		String employer_name				= "";
		String job2_title					= "";
		String escort_contcode				= "";
		String contact2_add_l1				= "";
		String contact2_add_l2				= "";
		String contact2_add_l3				= "";
		String contact2_add_l4				= "";
		String contact2_town_code			= "";
		String contact2_res_town_desc		= "";
		String contact3_res_town_desc		= "";
		String contact2_res_area_desc		= "";
		String contact3_res_area_desc		= "";
		String contact2_area_code			= "";
		String contact3_area_code			= "";
		String contact2_country_code		= "";
		String contact2_reg_code			= "";
		String contact3_reg_code			= "";
		String contact3_town_code			= "";
		String contact3_org_name			= "";
		String contact2_region_desc			= "";
		String contact3_region_desc			= "";
		String country2_code_desc			= "";
		String country3_code_desc			= "";
		String postal2_code					= "";
		String first_to_notify_name			= "";
		String addr3_line1					= "";
		String addr3_line2					= "";
		String addr3_line3					= "";
		String addr3_line4					= "";
		String postal3_code					= "";        
		String country3_code				= "";
		String res3_tel_no					= "";
		String off3_tel_no					= "";
		String ocpn_code					= "";
		String ocpn_class_code				= "";
		String ocpn_desc					= "";	       
		String patient_employee_id			= "";
		String employment_status			= "";
		String contact1_res_town			= "";
		String ESCORT_ADD_POSTAL_CODE		= "";
		String RES_TOWN_CODE				= "";
		String arr_region_desc				= "";
		String arr_res_area_desc			= "";
		String contact1_res_area_code		= "";
		String contact1_region_code			= "";
		String contact1_region_desc			= "";
		String contact1_res_town_desc		= "";
		String country1_code_desc			= "";
		String res1_mbo_tel_no				= "";
		String contact2_res_tel_no			= "";
		String contact2_mob_tel_no			= "";
		String contact2_off_tel_no			= "";
		String contact2_mail_id				= "";
		String contact2_relation			= "";
		String contact2_nat_id				= "";
		String ESCORT_REGION_CODE			= "";
		String ESCORT_ADD_POSTAL_DESC       = "";
    	String RES_AREA_CODE				= "";
    	String CONTACT1_NATIONAL_ID_NO      = "";
    	String ESCORT_OTH_ALT_ID_NO			= "";
		String ESCORT_OTH_ALT_ID_TYPE       = "";
    	String ESCORT_NATIONAL_ID_NO		= "";
    	String CONTACT1_BIRTH_DATE			= "";
    	String JOB1_TITLE					= "";
		String NAT_ID_PROMPT1				= "";
		String NAT_ID_LENGTH1				= "";
		String nat_id_check_digit_id        = "";
	    String nat_id_chk_len               = "";
		String nat_id_onKeyPress            = "";
		String postal1_desc					= "";
		String postal2_desc					= "";
		String postal3_desc					= "";
		String pat_priority                 = "";
		String patient_id_length	 = ""; // added by mujafar for ML-MMOH-CRF-0632
		String rel_patient_id        = ""; // added by mujafar for ML-MMOH-CRF-0632
		String pat_critical_case_yn	="";//Added by Shanmukh for MMS-DM-CRF-0147
     /* below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] */
	    String sql                          ="";
	    String color                        =""; 
	    String green                        ="";
	    String red                          ="";
        String yellow                       ="";
        String unassigned                   ="";
	   
	  /* CRF  SKR-CRF-0021 [IN028173] end  */
	  //Below line Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 14th 2014
		String five_level_triage_appl_yn =	(request.getParameter("five_level_triage_appl_yn")==null || request.getParameter("five_level_triage_appl_yn")=="")?"N":request.getParameter("five_level_triage_appl_yn");
		
		
		Object relationcode[]               = null;
		Object relationdesc[]               = null;
		String sel                          = "";
		String function_name=request.getParameter("function_name")==null?"":request.getParameter("function_name");
		int	 tindex							= 0;
		String facilityId					= checkForNull((String)session.getValue("facility_id"));
		String patient_id					= checkForNull(request.getParameter("patient_id"));

		String oper_stn_id					= checkForNull(request.getParameter("oper_stn_id"));
		String encounter_id					= checkForNull(request.getParameter("encounter_id"));
		String params						= checkForNull(request.getParameter("params"));
		start_date                          = checkForNull(request.getParameter("start_date"));
		ArrayList codes =null;
		ArrayList descs =null;
                                 

		StringBuffer sqlRelat = new StringBuffer();
		sqlRelat.append("select RELATIONSHIP_CODE,SHORT_DESC from MP_RELATIONSHIP_LANG_VW where LANGUAGE_ID='"+locale+"' and EFF_STATUS='E' order by SHORT_DESC ");
		
		StringBuffer sqlCountry = new StringBuffer();
		sqlCountry.append("select COUNTRY_CODE,LONG_NAME SHORT_NAME from MP_COUNTRY_LANG_VW where LANGUAGE_ID='"+locale+"'  and EFF_STATUS='E' order by SHORT_NAME ");

		StringBuffer sqlUnit = new StringBuffer();
		sqlUnit.append("select ");
		sqlUnit.append("MP_GET_DESC.MP_ALTERNATE_ID_TYPE(ALT_ID1_TYPE,'"+locale+"','1') ALT_ID1_DESC,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(ALT_ID2_TYPE,'"+locale+"','1') ALT_ID2_DESC,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(ALT_ID3_TYPE,'"+locale+"','1') ALT_ID3_DESC,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(ALT_ID4_TYPE,'"+locale+"','1') ALT_ID4_DESC,");
		sqlUnit.append("NAT_ID_PROMPT,ACCEPT_OTH_ALT_ID_YN ,");
		sqlUnit.append("ACCEPT_NATIONAL_ID_NO_YN,NAT_ID_ACCEPT_ALPHANUMERIC_YN,NAT_ID_LENGTH,nat_id_check_digit_id,nat_id_chk_len,patient_id_length,invoke_routine,nat_data_source_id  from MP_PARAM_lang_vw  WHERE module_id='MP' and  language_id = '"+locale+"'"); // modified by mujafar for ML-MMOH-CRF-0632
		//Modified above query by Thamizh selvi on 7th Aug 2018 against ML-MMOH-CRF-1177
		StringBuffer sqlEscort = new StringBuffer();
		//(SELECT PRIORITY_ZONE_DESC FROM AE_PRIORITY_ZONE_LANG_VW WHERE LANGUAGE_ID= '"+locale+"' and EFF_STATUS='E' and PRIORITY_ZONE=A.PRIORITY_ZONE) PRIORITY_ZONE_DESC Added for  AAKH-CRF-0010 [IN:038535] By Dharma on Mar 14th 2014
		//sqlEscort.append("SELECT a.patient_id, to_char(A.QUEUE_DATE,'dd/mm/yyyy hh24:mi') VISIT_ADM_DATE_TIME, A.VISIT_TYPE_CODE VISIT_ADM_TYPE, OP_GET_DESC.OP_VISIT_TYPE(A.FACILITY_ID,A.VISIT_TYPE_CODE,'"+locale+"','2') VISIT_TYPE_DESC , A.LOCN_TYPE ASSIGN_CARE_LOCN_TYPE, A.LOCN_CODE ASSIGN_CARE_LOCN_CODE, OP_GET_DESC.OP_CLINIC(A.FACILITY_ID,A.LOCN_CODE,'"+locale+"','1') LOCATION, A.SERVICE_CODE,AM_GET_DESC.AM_SERVICE(A.SERVICE_CODE,'"+locale+"','2') SERVICE_DESC, SUBSERVICE_CODE,AM_GET_DESC.AM_SUBSERVICE(A.SERVICE_CODE,A.SUBSERVICE_CODE,'"+locale+"','2') SUBSERVICE_DESC, A.MLC_YN,A.SPECIALITY_CODE, A.DISASTER_YN, MP_GET_DESC.MP_RES_TOWN(A.DISASTER_TOWN_CODE,'"+locale+"','1') RES_TOWN_DESC,A.REFERRAL_ID, B.NATIONAL_ID_NO,B.NATIONALITY_CODE, MP_GET_DESC.MP_COUNTRY(B.NATIONALITY_CODE,'"+locale+"','3') NATIONALITY,B.ALT_ID1_NO,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(b.oth_alt_id_type,'"+locale+"','1') OTH_ALT_ID_DESC, B.OTH_ALT_ID_NO,B.SEX, ROUND ((SYSDATE - B.date_of_birth) / 365, 0) PATIENT_AGE,  B.CITIZEN_YN RESIDENCY, B.LEGAL_YN  LEGAL_STATUS, B.DECEASED_YN,B.PAT_DTLS_UNKNOWN_YN, to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date, to_char(sysdate,'dd/mm/yyyy') sys_date1, A.PRIORITY_ZONE,AE_GET_DESC.AE_PAT_PRIORITY(A.PAT_PRIORITY,'"+locale+"','2') PAT_PRIORITY,A.TREATMENT_AREA_CODE, AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC(a.FACILITY_ID,A.LOCN_CODE,TREATMENT_AREA_CODE,'"+locale+"','2') TREATMENT_AREA_DESC, AE_GET_DESC.AE_DISASTER_TYPE(A.DISASTER_TYPE_CODE,'"+locale+"','2') DISASTER_TYPE_DESC, A.AE_BED_NO, C.ACCOMPANIED_BY_CODE,C.ESCORT_OTH_ALT_ID_NO, C.ESCORT_OTH_ALT_ID_TYPE,C.ARRIVAL_CODE, AM_GET_DESC.AM_ARRIVAL(C.OPERATING_FACILITY_ID, C.ARRIVAL_CODE,'"+locale+"','2') ARRIVAL_DESC, C.TRANSPORT_MODE, AM_GET_DESC.AM_TRANSPORT_MODE(C.TRANSPORT_MODE,'"+locale+"','2') TRANSPORT_MODE_DESC, C.ESCORT_TYPE, C.ESCORT_NAME, C.ESCORT_ADD_POSTAL_CODE, MP_GET_DESC.MP_POSTAL_CODE(C.ESCORT_ADD_POSTAL_CODE,'"+locale+"','2') ESCORT_ADD_POSTAL_DESC ,  C.ESCORT_COUNTRY_CODE, C.ESCORT_REGION_CODE,C.RES_TOWN_CODE, MP_GET_DESC.MP_RES_TOWN(C.RES_TOWN_CODE,'"+locale+"','1') arr_res_town_desc, C.RES_AREA_CODE, MP_GET_DESC.MP_RES_AREA(C.RES_AREA_CODE,'"+locale+"','1') arr_res_area_desc, MP_GET_DESC.MP_REGION(C.ESCORT_REGION_CODE,'"+locale+"','1') arr_region_desc, MP_GET_DESC.MP_COUNTRY(C.ESCORT_COUNTRY_CODE,'1','"+locale+"') ESCORT_COUNTRY_DESC, C.ESCORT_TEL_NUM, C.ESCORT_MV_REG_NO, C.ENCOUNTER_TYPE, C.RELATION_TO_PATIENT, C.ESCORT_REMARKS,C.ESCORT_NATIONAL_ID_NO, C.ESCORT_ADD_LN1, C.ESCORT_ADD_LN2, C.ESCORT_ADD_LN3, C.ESCORT_ADD_LN4, d.contact1_name, d.contact1_relation, d.CONTACT1_NATIONAL_ID_NO, to_char(d.contact1_birth_date,'dd/mm/rrrr') contact1_birth_date,d.job1_title, d.addr1_line1, d.addr1_line2,d.addr1_line3, d.addr1_line4,d.CONTACT1_TOWN_CODE, MP_GET_DESC.MP_RES_TOWN(D.CONTACT1_TOWN_CODE,'"+locale+"','1') contact1_res_town_desc, d.CONTACT1_AREA_CODE, MP_GET_DESC.MP_RES_AREA(d.CONTACT1_AREA_CODE,'"+locale+"','1') contact1_res_area_desc,  d.contact1_region_code, MP_GET_DESC.MP_REGION(d.contact1_region_code,'"+locale+"','1') contact1_region_desc, d.postal1_code,MP_GET_DESC.MP_POSTAL_CODE(d.postal1_code,'"+locale+"','2') postal1_desc , d.country1_code, MP_GET_DESC.MP_COUNTRY(d.country1_code,'"+locale+"','1') country1_code_desc,d.res1_tel_no, d.contact1_mob_tel_no,d.off1_tel_no,  d.contact1_email_id,d.contact2_relation, d.CONTACT2_NATIONAL_ID_NO, d.job2_title, d.CONTACT2_TOWN_CODE, MP_GET_DESC.MP_RES_TOWN(d.CONTACT2_TOWN_CODE,'"+locale+"','1') contact2_res_town_desc, d.res2_tel_no, d.contact2_mob_tel_no, d.off2_tel_no, d.contact2_email_id, d.addr2_line1, d.addr2_line2, d.addr2_line3, d.addr2_line4, d.CONTACT2_AREA_CODE, MP_GET_DESC.MP_RES_AREA(d.CONTACT2_AREA_CODE,'"+locale+"','1') contact2_res_area_desc, d.contact2_region_code, MP_GET_DESC.MP_REGION(d.contact2_region_code,'"+locale+"','1') contact2_region_desc, d.postal2_code,MP_GET_DESC.MP_POSTAL_CODE(d.postal2_code,'"+locale+"','2') postal2_desc , d.country2_code, MP_GET_DESC.MP_COUNTRY(d.country2_code,'"+locale+"','1')country2_code_desc, d.EMPLOYER_NAME, d.contact3_name, d.addr3_line1, d.addr3_line2,  d.addr3_line3,d.addr3_line4,d.CONTACT3_TOWN_CODE,  MP_GET_DESC.MP_RES_TOWN(D.CONTACT3_TOWN_CODE,'"+locale+"','1') contact3_res_town_desc, d.CONTACT3_AREA_CODE, MP_GET_DESC.MP_RES_AREA(d.CONTACT3_AREA_CODE,'"+locale+"','1') contact3_res_area_desc, d.contact3_region_code, MP_GET_DESC.MP_REGION(d.contact3_region_code,'"+locale+"','1') contact3_region_desc,d.postal3_code,MP_GET_DESC.MP_POSTAL_CODE(d.postal3_code,'"+locale+"','2') postal3_desc ,  d.country3_code, MP_GET_DESC.MP_COUNTRY(d.country3_code,'"+locale+"','1') country3_code_desc, d.res3_tel_no, d.off3_tel_no, d.patient_employee_id, d.ocpn_class_code, d.ocpn_code, d.ocpn_desc, d.employment_status,d.FIRST_TO_NOTIFY_NAME, E.BLOOD_GRP, MR_GET_DESC.MR_BLOOD_GRP(E.BLOOD_GRP,'"+locale+"','2') BLOOD_GRP_DESC, E.RH_FACTOR, MR_GET_DESC.MR_RHESUS_FACTOR(E.RH_FACTOR,'"+locale+"','2') rh_factor_desc FROM AE_CURRENT_PATIENT A, MP_PATIENT B, PR_ENCOUNTER_OTHER_DETAIL C, AE_PAT_RELATED_CONTACTS D, MP_PAT_OTH_DTLS E where a.FACILITY_ID = ? AND a.encounter_id = ?  and a.patient_id=b.patient_id and a.FACILITY_ID = C.OPERATING_FACILITY_ID and a.ENCOUNTER_ID = c.ENCOUNTER_ID AND a.FACILITY_ID = D.FACILITY_ID and a.ENCOUNTER_ID = D.ENCOUNTER_ID AND b.PATIENT_ID=E.PATIENT_ID");
		//(SELECT PRIORITY_ZONE_DESC FROM AE_PRIORITY_ZONE_LANG_VW WHERE LANGUAGE_ID= '"+locale+"' and EFF_STATUS='E' and PRIORITY_ZONE=A.PRIORITY_ZONE) PRIORITY_ZONE_DESC Added for  AAKH-CRF-0010 [IN:038535] By Dharma on Mar 14th 2014
		sqlEscort.append("SELECT a.patient_id, to_char(A.QUEUE_DATE,'dd/mm/yyyy hh24:mi') VISIT_ADM_DATE_TIME, A.VISIT_TYPE_CODE VISIT_ADM_TYPE, OP_GET_DESC.OP_VISIT_TYPE(A.FACILITY_ID,A.VISIT_TYPE_CODE,'"+locale+"','2') VISIT_TYPE_DESC , A.LOCN_TYPE ASSIGN_CARE_LOCN_TYPE, A.LOCN_CODE ASSIGN_CARE_LOCN_CODE, OP_GET_DESC.OP_CLINIC(A.FACILITY_ID,A.LOCN_CODE,'"+locale+"','1') LOCATION, A.SERVICE_CODE,AM_GET_DESC.AM_SERVICE(A.SERVICE_CODE,'"+locale+"','2') SERVICE_DESC, SUBSERVICE_CODE,AM_GET_DESC.AM_SUBSERVICE(A.SERVICE_CODE,A.SUBSERVICE_CODE,'"+locale+"','2') SUBSERVICE_DESC, A.MLC_YN,A.SPECIALITY_CODE, A.DISASTER_YN, MP_GET_DESC.MP_RES_TOWN(A.DISASTER_TOWN_CODE,'"+locale+"','1') RES_TOWN_DESC,A.REFERRAL_ID, B.NATIONAL_ID_NO,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(b.alt_id1_type,'"+locale+"','1') ALT_ID1_DESC,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(b.alt_id2_type,'"+locale+"','1') ALT_ID2_DESC,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(b.alt_id3_type,'"+locale+"','1') ALT_ID3_DESC,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(b.alt_id4_type,'"+locale+"','1') ALT_ID4_DESC,B.NATIONALITY_CODE, MP_GET_DESC.MP_COUNTRY(B.NATIONALITY_CODE,'"+locale+"','3') NATIONALITY,B.ALT_ID1_NO,B.ALT_ID2_NO,B.ALT_ID3_NO,B.ALT_ID4_NO,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(b.oth_alt_id_type,'"+locale+"','1') OTH_ALT_ID_DESC, B.OTH_ALT_ID_NO,B.SEX, ROUND ((SYSDATE - B.date_of_birth) / 365, 0) PATIENT_AGE,  B.CITIZEN_YN RESIDENCY, B.LEGAL_YN  LEGAL_STATUS, B.DECEASED_YN,B.PAT_DTLS_UNKNOWN_YN, to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date, to_char(sysdate,'dd/mm/yyyy') sys_date1, A.PRIORITY_ZONE,AE_GET_DESC.AE_PAT_PRIORITY(A.PAT_PRIORITY,'"+locale+"','2') PAT_PRIORITY,(SELECT PRIORITY_ZONE_DESC FROM AE_PRIORITY_ZONE_LANG_VW WHERE LANGUAGE_ID= '"+locale+"' and EFF_STATUS='E' and PRIORITY_ZONE=A.PRIORITY_ZONE) PRIORITY_ZONE_DESC ,A.TREATMENT_AREA_CODE, AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC(a.FACILITY_ID,A.LOCN_CODE,TREATMENT_AREA_CODE,'"+locale+"','2') TREATMENT_AREA_DESC, AE_GET_DESC.AE_DISASTER_TYPE(A.DISASTER_TYPE_CODE,'"+locale+"','2') DISASTER_TYPE_DESC, A.AE_BED_NO, C.ACCOMPANIED_BY_CODE,C.ESCORT_OTH_ALT_ID_NO, C.ESCORT_OTH_ALT_ID_TYPE,C.ARRIVAL_CODE, AM_GET_DESC.AM_ARRIVAL(C.OPERATING_FACILITY_ID, C.ARRIVAL_CODE,'"+locale+"','2') ARRIVAL_DESC, C.TRANSPORT_MODE, AM_GET_DESC.AM_TRANSPORT_MODE(C.TRANSPORT_MODE,'"+locale+"','2') TRANSPORT_MODE_DESC, C.ESCORT_TYPE, C.ESCORT_NAME, C.ESCORT_ADD_POSTAL_CODE, MP_GET_DESC.MP_POSTAL_CODE(C.ESCORT_ADD_POSTAL_CODE,'"+locale+"','2') ESCORT_ADD_POSTAL_DESC ,  C.ESCORT_COUNTRY_CODE, C.ESCORT_REGION_CODE,C.RES_TOWN_CODE, MP_GET_DESC.MP_RES_TOWN(C.RES_TOWN_CODE,'"+locale+"','1') arr_res_town_desc, C.RES_AREA_CODE, MP_GET_DESC.MP_RES_AREA(C.RES_AREA_CODE,'"+locale+"','1') arr_res_area_desc, MP_GET_DESC.MP_REGION(C.ESCORT_REGION_CODE,'"+locale+"','1') arr_region_desc, MP_GET_DESC.MP_COUNTRY(C.ESCORT_COUNTRY_CODE,'1','"+locale+"') ESCORT_COUNTRY_DESC, C.ESCORT_TEL_NUM, C.ESCORT_MV_REG_NO, C.ENCOUNTER_TYPE, C.RELATION_TO_PATIENT, C.ESCORT_REMARKS,C.ESCORT_NATIONAL_ID_NO, C.ESCORT_ADD_LN1, C.ESCORT_ADD_LN2, C.ESCORT_ADD_LN3, C.ESCORT_ADD_LN4, d.contact1_name, d.contact1_relation, d.CONTACT1_NATIONAL_ID_NO, to_char(d.contact1_birth_date,'dd/mm/rrrr') contact1_birth_date,d.job1_title, d.addr1_line1, d.addr1_line2,d.addr1_line3, d.addr1_line4,d.CONTACT1_TOWN_CODE, MP_GET_DESC.MP_RES_TOWN(D.CONTACT1_TOWN_CODE,'"+locale+"','1') contact1_res_town_desc, d.CONTACT1_AREA_CODE, MP_GET_DESC.MP_RES_AREA(d.CONTACT1_AREA_CODE,'"+locale+"','1') contact1_res_area_desc,  d.contact1_region_code, MP_GET_DESC.MP_REGION(d.contact1_region_code,'"+locale+"','1') contact1_region_desc, d.postal1_code,MP_GET_DESC.MP_POSTAL_CODE(d.postal1_code,'"+locale+"','2') postal1_desc , d.country1_code, MP_GET_DESC.MP_COUNTRY(d.country1_code,'"+locale+"','1') country1_code_desc,d.res1_tel_no, d.contact1_mob_tel_no,d.off1_tel_no,  d.contact1_email_id,d.contact2_relation, d.CONTACT2_NATIONAL_ID_NO, d.job2_title, d.CONTACT2_TOWN_CODE, MP_GET_DESC.MP_RES_TOWN(d.CONTACT2_TOWN_CODE,'"+locale+"','1') contact2_res_town_desc, d.res2_tel_no, d.contact2_mob_tel_no, d.off2_tel_no, d.contact2_email_id, d.addr2_line1, d.addr2_line2, d.addr2_line3, d.addr2_line4, d.CONTACT2_AREA_CODE, MP_GET_DESC.MP_RES_AREA(d.CONTACT2_AREA_CODE,'"+locale+"','1') contact2_res_area_desc, d.contact2_region_code, MP_GET_DESC.MP_REGION(d.contact2_region_code,'"+locale+"','1') contact2_region_desc, d.postal2_code,MP_GET_DESC.MP_POSTAL_CODE(d.postal2_code,'"+locale+"','2') postal2_desc , d.country2_code, MP_GET_DESC.MP_COUNTRY(d.country2_code,'"+locale+"','1')country2_code_desc, d.EMPLOYER_NAME, d.contact3_name, d.addr3_line1, d.addr3_line2,  d.addr3_line3,d.addr3_line4,d.CONTACT3_TOWN_CODE,  MP_GET_DESC.MP_RES_TOWN(D.CONTACT3_TOWN_CODE,'"+locale+"','1') contact3_res_town_desc, d.CONTACT3_AREA_CODE, MP_GET_DESC.MP_RES_AREA(d.CONTACT3_AREA_CODE,'"+locale+"','1') contact3_res_area_desc, d.contact3_region_code, MP_GET_DESC.MP_REGION(d.contact3_region_code,'"+locale+"','1') contact3_region_desc,d.postal3_code,MP_GET_DESC.MP_POSTAL_CODE(d.postal3_code,'"+locale+"','2') postal3_desc ,  d.country3_code, MP_GET_DESC.MP_COUNTRY(d.country3_code,'"+locale+"','1') country3_code_desc, d.res3_tel_no, d.off3_tel_no, d.patient_employee_id, d.ocpn_class_code, d.ocpn_code, d.ocpn_desc, d.employment_status,d.FIRST_TO_NOTIFY_NAME, E.BLOOD_GRP, MR_GET_DESC.MR_BLOOD_GRP(E.BLOOD_GRP,'"+locale+"','2') BLOOD_GRP_DESC, E.RH_FACTOR, MR_GET_DESC.MR_RHESUS_FACTOR(E.RH_FACTOR,'"+locale+"','2') rh_factor_desc,d.REL_PATIENT_ID rel_patient_id,a.PAT_CRITICAL_CASE_YN FROM AE_CURRENT_PATIENT A, MP_PATIENT B, PR_ENCOUNTER_OTHER_DETAIL C, AE_PAT_RELATED_CONTACTS D, MP_PAT_OTH_DTLS E where a.FACILITY_ID = ? AND a.encounter_id = ?  and a.patient_id=b.patient_id and a.FACILITY_ID = C.OPERATING_FACILITY_ID and a.ENCOUNTER_ID = c.ENCOUNTER_ID AND a.FACILITY_ID = D.FACILITY_ID and a.ENCOUNTER_ID = D.ENCOUNTER_ID AND b.PATIENT_ID=E.PATIENT_ID"); // modified by mujafar for ML-MMOH-CRF-0632
		
	    pstmt = con.prepareStatement(sqlEscort.toString());
		pstmt.setString(1, facilityId);
		pstmt.setString(2, encounter_id);
		rset = pstmt.executeQuery();
			while(rset!=null && rset.next())
			{

				visit_adm_date_time =checkForNull(rset.getString("VISIT_ADM_DATE_TIME"));
				visit_type_desc =checkForNull(rset.getString("VISIT_TYPE_DESC"));
				assign_care_locn_code =checkForNull(rset.getString("ASSIGN_CARE_LOCN_CODE"));
				visit_type_code=checkForNull(rset.getString("VISIT_ADM_TYPE"));
				service_code=checkForNull(rset.getString("SERVICE_CODE"));
				location1 =checkForNull(rset.getString("LOCATION"));
				service_desc =checkForNull(rset.getString("SERVICE_DESC"));
				subservice_desc =checkForNull(rset.getString("SUBSERVICE_DESC"));
				speciality_code=checkForNull(rset.getString("SPECIALITY_CODE"));
				mlc_case_yn =checkForNull(rset.getString("MLC_YN"));
				disaster_yn =checkForNull(rset.getString("DISASTER_YN"));
				disaster_area_desc =checkForNull(rset.getString("RES_TOWN_DESC"));
				referral_id =checkForNull(rset.getString("REFERRAL_ID"));
				nationality_id  = checkForNull(rset.getString("NATIONAL_ID_NO"));
				nationality	  = checkForNull(rset.getString("NATIONALITY"));	
				alt_id1_no = checkForNull(rset.getString("ALT_ID1_NO"));
				alt_id2_no = checkForNull(rset.getString("ALT_ID2_NO"));
				alt_id3_no = checkForNull(rset.getString("ALT_ID3_NO"));
				alt_id4_no = checkForNull(rset.getString("ALT_ID4_NO"));
				oth_alt_id_desc = checkForNull(rset.getString("OTH_ALT_ID_DESC"));
				oth_alt_id_no   = checkForNull(rset.getString("OTH_ALT_ID_NO"));
				legal_status = checkForNull(rset.getString("LEGAL_STATUS")); 
				residency = checkForNull(rset.getString("RESIDENCY"));
				brought_dead_yn = checkForNull(rset.getString("DECEASED_YN"));
				pat_dtls_unknown_yn= checkForNull(rset.getString("PAT_DTLS_UNKNOWN_YN"));
				sysDateWithoutTime	= rset.getString("sys_date1");
				priority_zone = checkForNull(rset.getString("PRIORITY_ZONE"));
				pat_priority  = checkForNull(rset.getString("PAT_PRIORITY"));
				bed_no = checkForNull(rset.getString("AE_BED_NO"));
				treatment_area_code_desc = checkForNull(rset.getString("TREATMENT_AREA_DESC"));
				disaster_type_desc = checkForNull(rset.getString("DISASTER_TYPE_DESC"));

				RES_TOWN_CODE           = checkForNull(rset.getString("RES_TOWN_CODE")); 
				RES_AREA_CODE           = checkForNull(rset.getString("RES_AREA_CODE"));  
				arr_region_desc         = checkForNull(rset.getString("arr_region_desc"));
				arr_res_area_desc       = checkForNull(rset.getString("arr_res_area_desc")); 
				ESCORT_REGION_CODE      = checkForNull(rset.getString("ESCORT_REGION_CODE"));
				arr_res_town_desc       = checkForNull(rset.getString("arr_res_town_desc"));  
				ESCORT_ADD_POSTAL_CODE  = checkForNull(rset.getString("ESCORT_ADD_POSTAL_CODE"));  
				ESCORT_ADD_POSTAL_DESC  = checkForNull(rset.getString("ESCORT_ADD_POSTAL_DESC"));  
				ESCORT_REGION_CODE      = checkForNull(rset.getString("ESCORT_REGION_CODE"));
				ESCORT_OTH_ALT_ID_NO    = checkForNull(rset.getString("ESCORT_OTH_ALT_ID_NO"));
				ESCORT_OTH_ALT_ID_TYPE  = checkForNull(rset.getString("ESCORT_OTH_ALT_ID_TYPE")); 
				accompany_by            = checkForNull(rset.getString("ACCOMPANIED_BY_CODE"));
				ESCORT_NATIONAL_ID_NO   = checkForNull(rset.getString("ESCORT_NATIONAL_ID_NO"));    
				mode_of_arrival         = checkForNull(rset.getString("ARRIVAL_DESC"));
				transport_mode          = checkForNull(rset.getString("TRANSPORT_MODE_DESC"));
				escort_type				= checkForNull(rset.getString("ESCORT_TYPE"));
				if(escort_type!=null &&  escort_type.equals("N"))
				escort_type				= "Next of Kin";
				else if(escort_type!=null &&  escort_type.equals("P"))
				escort_type				= "Police";
				else if(escort_type!=null &&  escort_type.equals("O"))
				escort_type				= "Others";
				escort_contcode			= checkForNull(rset.getString("ESCORT_COUNTRY_CODE"));
				escort_name				= checkForNull(rset.getString("ESCORT_NAME"));
				escort_add_ln1			= checkForNull(rset.getString("ESCORT_ADD_LN1"));
				escort_add_ln2			= checkForNull(rset.getString("ESCORT_ADD_LN2"));
				escort_add_ln3			= checkForNull(rset.getString("ESCORT_ADD_LN3"));
				escort_add_ln4			= checkForNull(rset.getString("ESCORT_ADD_LN4"));
				escort_tel_num			= checkForNull(rset.getString("ESCORT_TEL_NUM"));
				escort_mv_reg_no		= checkForNull(rset.getString("ESCORT_MV_REG_NO"));
				relation_to_patient		= checkForNull(rset.getString("RELATION_TO_PATIENT"));
				escort_remarks			= checkForNull(rset.getString("ESCORT_REMARKS"));
				CONTACT1_BIRTH_DATE		= checkForNull(rset.getString("CONTACT1_BIRTH_DATE"));
				CONTACT1_NATIONAL_ID_NO	= checkForNull(rset.getString("CONTACT1_NATIONAL_ID_NO"));
				JOB1_TITLE				= checkForNull(rset.getString("JOB1_TITLE"));
				contact1_relation		= checkForNull(rset.getString("CONTACT1_RELATION"));
				contact1_name			= checkForNull(rset.getString("contact1_name"));
				addr1_line1				= checkForNull(rset.getString("ADDR1_LINE1"));
				addr1_line2				= checkForNull(rset.getString("ADDR1_LINE2"));
				addr1_line3				= checkForNull(rset.getString("ADDR1_LINE3"));
				addr1_line4				= checkForNull(rset.getString("ADDR1_LINE4"));
				contact1_res_town		= checkForNull(rset.getString("CONTACT1_TOWN_CODE"));
				contact1_res_town_desc  = checkForNull(rset.getString("contact1_res_town_desc"));
				contact1_region_code	= checkForNull(rset.getString("CONTACT1_REGION_CODE"));
				contact1_region_desc	= checkForNull(rset.getString("contact1_region_desc"));
				contact1_res_area_code	= checkForNull(rset.getString("CONTACT1_AREA_CODE"));
				contact1_res_area_desc  = checkForNull(rset.getString("contact1_res_area_desc"));
				postal1_code			= checkForNull(rset.getString("POSTAL1_CODE"));
				postal1_desc			= checkForNull(rset.getString("postal1_desc"));
				country1_code			= checkForNull(rset.getString("COUNTRY1_CODE"));
				country1_code_desc		= checkForNull(rset.getString("country1_code_desc"));
				res1_tel_no				= checkForNull(rset.getString("RES1_TEL_NO"));
				res1_mbo_tel_no			= checkForNull(rset.getString("CONTACT1_MOB_TEL_NO"));
				off1_tel_no				= checkForNull(rset.getString("OFF1_TEL_NO"));
				contact1_email_id		= checkForNull(rset.getString("CONTACT1_EMAIL_ID"));
				first_to_notify_name	= checkForNull(rset.getString("FIRST_TO_NOTIFY_NAME"));
				contact2_relation		= checkForNull(rset.getString("contact2_relation"));
				contact2_nat_id			= checkForNull(rset.getString("CONTACT2_NATIONAL_ID_NO"));
				job2_title				= checkForNull(rset.getString("JOB2_TITLE"));
				contact2_res_tel_no		= checkForNull(rset.getString("RES2_TEL_NO"));
				contact2_mob_tel_no		= checkForNull(rset.getString("CONTACT2_MOB_TEL_NO"));
				contact2_off_tel_no		= checkForNull(rset.getString("OFF2_TEL_NO"));
				contact2_mail_id		= checkForNull(rset.getString("CONTACT2_EMAIL_ID"));
				contact2_add_l1			= checkForNull(rset.getString("ADDR2_LINE1"));
				contact2_add_l2			= checkForNull(rset.getString("ADDR2_LINE2"));
				contact2_add_l3			= checkForNull(rset.getString("ADDR2_LINE3"));
				contact2_add_l4			= checkForNull(rset.getString("ADDR2_LINE4"));
				contact2_town_code		= checkForNull(rset.getString("CONTACT2_TOWN_CODE"));
				contact2_res_town_desc	= checkForNull(rset.getString("contact2_res_town_desc"));
				contact2_area_code		= checkForNull(rset.getString("CONTACT2_AREA_CODE"));
				contact2_res_area_desc	= checkForNull(rset.getString("contact2_res_area_desc"));
				contact2_reg_code		= checkForNull(rset.getString("CONTACT2_REGION_CODE"));
				contact2_region_desc	= checkForNull(rset.getString("contact2_region_desc"));
				postal2_code			= checkForNull(rset.getString("POSTAL2_CODE"));
				postal2_desc			= checkForNull(rset.getString("postal2_desc"));
				contact2_country_code	= checkForNull(rset.getString("COUNTRY2_CODE"));
				country2_code_desc		= checkForNull(rset.getString("country2_code_desc"));
				contact3_org_name		= checkForNull(rset.getString("EMPLOYER_NAME"));
				employer_name			= checkForNull(rset.getString("CONTACT3_NAME"));
				addr3_line1				= checkForNull(rset.getString("ADDR3_LINE1"));
				addr3_line2				= checkForNull(rset.getString("ADDR3_LINE2"));
				addr3_line3				= checkForNull(rset.getString("ADDR3_LINE3"));
				addr3_line4				= checkForNull(rset.getString("ADDR3_LINE4"));
				contact3_town_code		= checkForNull(rset.getString("CONTACT3_TOWN_CODE"));
				contact3_res_town_desc	= checkForNull(rset.getString("contact3_res_town_desc"));
				contact3_reg_code		= checkForNull(rset.getString("CONTACT3_REGION_CODE"));
				contact3_region_desc	= checkForNull(rset.getString("contact3_region_desc"));
				contact3_area_code		= checkForNull(rset.getString("CONTACT3_AREA_CODE"));
				contact3_res_area_desc	= checkForNull(rset.getString("contact3_res_area_desc"));
				postal3_code			= checkForNull(rset.getString("postal3_code"));
				postal3_desc			= checkForNull(rset.getString("postal3_desc"));
				country3_code			= checkForNull(rset.getString("COUNTRY3_CODE"));
				country3_code_desc		= checkForNull(rset.getString("country3_code_desc"));
				res3_tel_no				= checkForNull(rset.getString("RES3_TEL_NO"));
				off3_tel_no				= checkForNull(rset.getString("OFF3_TEL_NO"));
				patient_employee_id		= checkForNull(rset.getString("PATIENT_EMPLOYEE_ID"));
				ocpn_class_code			= checkForNull(rset.getString("OCPN_CLASS_CODE"));
				ocpn_code				= checkForNull(rset.getString("OCPN_CODE"));
				ocpn_desc				= checkForNull(rset.getString("OCPN_DESC"));
				employment_status		= checkForNull(rset.getString("EMPLOYMENT_STATUS"));

				blood_group				= checkForNull(rset.getString("blood_grp_desc"));
				rh_factor				= checkForNull(rset.getString("rh_factor_desc"));
				priority_zone_desc		= checkForNull(rset.getString("PRIORITY_ZONE_DESC"));
				rel_patient_id          = checkForNull(rset.getString("rel_patient_id"));
				pat_critical_case_yn		= checkForNull(rset.getString("PAT_CRITICAL_CASE_YN"));

			}
			if(pstmt!=null) pstmt.close();
			if(rset!=null) rset.close();
			if((sqlEscort != null) && (sqlEscort.length() > 0))
			  {
				sqlEscort.delete(0,sqlEscort.length());
			  }
			 visit_adm_date_time=DateUtils.convertDate(visit_adm_date_time,"DMYHM","en",locale);
		    if (!CONTACT1_BIRTH_DATE.equals("")){	CONTACT1_BIRTH_DATE=DateUtils.convertDate(CONTACT1_BIRTH_DATE,"DMY","en",locale);
			}
	       
		   /* below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] */
		   
		     /*  sql="SELECT PRIORITY_ZONE,PRIORITY_ZONE_DESC FROM AE_PRIORITY_ZONE_LANG_VW WHERE LANGUAGE_ID= ? and EFF_STATUS='E'";
				pstmt   = con.prepareStatement(sql.toString());
				pstmt.setString(1,locale) ;
			    rset    = pstmt.executeQuery();
				while(rset!=null && rset.next())
				{
				 color      =rset.getString("PRIORITY_ZONE");
				 if (color.equals("G")) {green=rset.getString("PRIORITY_ZONE_DESC");}
				 if (color.equals("R")){red=rset.getString("PRIORITY_ZONE_DESC");}
				 if (color.equals("Y")){yellow=rset.getString("PRIORITY_ZONE_DESC");}
				 if (color.equals("U")){unassigned=rset.getString("PRIORITY_ZONE_DESC");}
				 }
		    
			
		    if(pstmt!=null) pstmt.close();
			if(rset!=null) rset.close();*/
		 
		  /* CRF  SKR-CRF-0021 [IN028173] end  */
		   
		   
		   /* below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] */
		/* if(priority_zone.equals("R")) priority_zone_desc =red;
		 if(priority_zone.equals("G")) priority_zone_desc =green;
		 if(priority_zone.equals("Y")) priority_zone_desc =yellow;
		 if(priority_zone.equals("U")) priority_zone_desc =unassigned;*/
		   /* CRF  SKR-CRF-0021 [IN028173] end  */
		   
		  
    /*	if(priority_zone.equals("R")) priority_zone_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Red.label","common_labels");
		if(priority_zone.equals("G")) priority_zone_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Green.label","common_labels");
		if(priority_zone.equals("Y")) priority_zone_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Yellow.label","common_labels");
		if(priority_zone.equals("U")) priority_zone_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Unassigned.label","common_labels");*/

		if (referral_id.equals(""))
			disRefID ="";
		else
			disRefID="disabled";
		//Added by Shanmukh for MMS-DM-CRF-0147
		if(pat_critical_case_yn.equals("Y")){
			pat_critical_case_yn=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels");
		}else{
			pat_critical_case_yn=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels");
		}
%>
	 <body OnMouseDown='CodeArrest()' onLoad='enableocpn();' onKeyDown = 'lockKey()' onSelect="codeArrestThruSelect()">
	 <form name="ae_reg_attn_result_form" id="ae_reg_attn_result_form"  action="../../servlet/eAE.AEReviseVisitServlet"  method="post" target="messageFrame">
  	 <!-- <a name="tab1" onblur="tab_click1('arrival_tab')"></a>  -->
		<table cellspacing='0' cellpadding='0' width='95%' border=0 align='center'>
            <tr><td class='white'>

		 <ul id="tablist" class="tablist" >
			<li class="tablistitem" title="Add Visit">
				<a onclick="onTabClickOf('addVisit_tab')" class="tabClicked" id='addVisit_tab' >
					<span class="tabSpanclicked" id="addVisit_tabspan"><fmt:message key="Common.VisitDetail.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			<li class="tablistitem" title="Arrival">
				<a onclick="onTabClickOf('arrival_tab')" class="tabA" id="arrival_tab" >
					<span class="tabAspan" id="arrival_tabspan"><fmt:message key="Common.arrival.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			<li class="tablistitem" title="Related Contact details">
				<a onclick="onTabClickOf('rlcnts_tab')" class="tabA" id="rlcnts_tab" >
					<span class="tabAspan" id="rlcnts_tabspan"><fmt:message key="eMP.relatedcontacts.label" bundle="${mp_labels}"/></span>
				</a>
			</li>	
    </ul>
	
   </td></tr></table>
   
<div id ='VisitTab' style='display:inline'>
	   <table border="0" cellpadding="0" cellspacing="0" align='center' width='95%'>
		<tr>
			<td class='COLUMNHEADER' colspan='4' ><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></td>
		</tr>
 	   <tr>
	    <td class='label' colspan='4'>&nbsp;</td>
	    </tr>	 
			 <%
	                   // To display the alternate id and to display the legend like height,weight,etc
					   pstmt = con.prepareStatement(sqlUnit.toString());	
				       rset = pstmt.executeQuery();
					   while(rset!=null && rset.next())
	                   {         
							     accept_oth_alt_id_yn     = checkForNull(rset.getString("ACCEPT_OTH_ALT_ID_YN"));
								 accept_national_id_no_yn = checkForNull(rset.getString("ACCEPT_NATIONAL_ID_NO_YN"));
								 nat_id_accept_alphanumeric_yn = checkForNull(rset.getString("NAT_ID_ACCEPT_ALPHANUMERIC_YN"));
								 nat_id_length			  = checkForNull(rset.getString("NAT_ID_LENGTH"));
								 nat_id_prompt			  = checkForNull(rset.getString("NAT_ID_PROMPT"));
								 nat_id_check_digit_id	  = checkForNull( rset.getString("nat_id_check_digit_id"));
								 nat_id_chk_len		      = checkForNull( rset.getString("nat_id_chk_len"));
								 alt_id1_desc	          = checkForNull(rset.getString("ALT_ID1_DESC"));	
				                 alt_id2_desc	          = checkForNull(rset.getString("ALT_ID2_DESC"));	
				                 alt_id3_desc	          = checkForNull(rset.getString("ALT_ID3_DESC"));	
				                 alt_id4_desc	           = checkForNull(rset.getString("ALT_ID4_DESC"));	
								 patient_id_length        = rset.getString("patient_id_length");
								 /*Added by Thamizh selvi on 7th Aug 2018 against ML-MMOH-CRF-1177 Start*/
								 natInvokeRoutine		= checkForNull( rset.getString("invoke_routine"));
								 natDataSourceId		    = checkForNull( rset.getString("nat_data_source_id"));
								 /*End*/
								 
					   }
					   NAT_ID_PROMPT1 = nat_id_prompt;
					   NAT_ID_LENGTH1 = nat_id_length;
					   if(pstmt!=null) pstmt.close();
					   if(rset!=null) rset.close();
					   if((sqlUnit != null) && (sqlUnit.length() > 0))
						 {
							sqlUnit.delete(0,sqlUnit.length());
						 } 
						 					 
			%>
			<tr>
			<td class='label' width='25%'  ><fmt:message key="Common.referralid.label" bundle="${common_labels}"/></td>
			<%if(pat_dtls_unknown_yn.equals("N")){%>
               <td class='fields'  width='25%'><input type='text' name='referal_id' id='referal_id' value="<%=referral_id%>" maxlength='14' size='14'  onBlur='searchPatient(document.forms[0].referal_id);'  <%=disRefID%> ><input type='button' class='button' value='?' name='ref_id_search' id='ref_id_search'   onClick='getReferralID()' <%=disRefID%> ></td>
            <%}else if(pat_dtls_unknown_yn.equals("Y")) {%>
				<td class='fields'  width='25%'><input type='text' name='referal_id' id='referal_id' value='' maxlength='14' size='14'  onBlur='' disabled><input type='button' class='button' value='?' name='ref_id_search' id='ref_id_search' onClick='getReferralID()' disabled></td>
			<%}%>

			<!--Added by Ashwini on 12-Feb-2020 for AAKH-CRF-0079.11-->
			<%
			int ins_count = eMP.MPCommonBean.getInsuranceCount(con,encounter_id,patient_id);

			if(isInvokeUploadDocAppl && ins_count > 0){%>
				<td class='CAGROUPHEADING' colspan='2' nowrap><a href="javascript:UploadDocument();"><b><fmt:message key="Common.UploadInsDoc.label" bundle="${common_labels}"/>&nbsp;</b></a></td>
			<%}else{%>
				<td class='label' colspan='2'>&nbsp;</td>
			<%}%>

	       </tr>
		<tr>
	    <td class='label'  colspan='4'>&nbsp;</td>
	    </tr>	

		<tr>
			   <% if(!nat_id_prompt.equals("")){  %>
					  <td class='LABEL'  width='25%' ><%=nat_id_prompt%> </td>
					  <td class='QUERYDATA'  width='25%'>
 				      <%=ecis.utils.HTMLUtilities.getDisplayString(nationality_id)%></td>
			   <% } else {  %>
						  <td class='LABEL'  width='25%' >&nbsp;</td>
						  <td class='LABEL'> &nbsp;</td>
			   <% } %>
			   <% if(!alt_id1_desc.equals("")){  %>
                      <td class='LABEL' width='25%'><%= alt_id1_desc%></td>
				      <td class='QUERYDATA'  width='25%' ><%=alt_id1_no%>&nbsp;</td>
			    <% } else{ %>
					  <td class='LABEL' width='25%'>&nbsp;</td>
					  <td class='QUERYDATA' width='25%'>&nbsp;</td>
                <% }%>
          </tr> 
          <tr><td colspan=4 class=label height=5></td></tr>
          <tr>
		      <td class='label' width='5%' colspan='4'>&nbsp;</td>
	      </tr>
		  <tr>
			   <% if(!alt_id2_desc.equals("")){  %>
					  <td class='LABEL'  width='25%' ><%=alt_id2_desc%> </td>
					  <td class='QUERYDATA'  width='25%' ><%=alt_id2_no%>&nbsp;</td>
 				     
			   <% } else {  %>
						  <td class='LABEL'  width='25%' >&nbsp;</td>
						  <td class='LABEL'> &nbsp;</td>
			   <% } %>
			   <% if(!alt_id3_desc.equals("")){  %>
                      <td class='LABEL' width='25%'><%= alt_id3_desc%></td>
				      <td class='QUERYDATA'  width='25%' ><%=alt_id3_no%>&nbsp;</td>
			    <% } else{ %>
					  <td class='LABEL' width='25%'>&nbsp;</td>
					  <td class='QUERYDATA' width='25%'>&nbsp;</td>
                <% }%>
          </tr> 
          <tr><td colspan=4 class=label height=5></td></tr>
          <tr>
		      <td class='label' width='5%' colspan='4'>&nbsp;</td>
	      </tr>
		   <tr>
			   <% if(!alt_id4_desc.equals("")){  %>
					  <td class='LABEL'  width='25%' ><%=alt_id4_desc%> </td>
					  <td class='QUERYDATA'  width='25%' ><%=alt_id4_no%>&nbsp;</td>
 				     
			   <% } else {  %>
						  <td class='LABEL'  width='25%' >&nbsp;</td>
						  <td class='LABEL'> &nbsp;</td>
			   <% } %>
          </tr> 
          <tr><td colspan=4 class=label height=5></td></tr>
          <tr>
		      <td class='label' width='5%' colspan='4'>&nbsp;</td>
	      </tr>
		  <tr>
              <td class='LABEL'  width='25%' ><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></td>
  		      <td class='QUERYDATA' width='25%'>
 				<%=ecis.utils.HTMLUtilities.getDisplayString(nationality)%>
 		      </td>
			  
		       <%if (! oth_alt_id_desc.equals("")){%>
			          <td class='LABEL'  width='25%' > <%=oth_alt_id_desc%> </td>
					  <td class='QUERYDATA' >
 			  	           <%=oth_alt_id_no%>&nbsp;</td>
			   <% } else{ %>
					   <td class='QUERYDATA' align='left' width='25%'>&nbsp;</td>
					   <td class='label' width='25%' >&nbsp;</td>
               <% }%>
			 
          </tr> 
          <tr>
		      <td class='label' width='5%' colspan='4'>&nbsp;</td>
	      </tr>
		  <tr>
		      <td class='LABEL' width='25%' ><fmt:message key="Common.residency.label" bundle="${common_labels}"/></td>
			  <td class='QUERYDATA' ><% if(residency.equals("Y")){ %> <fmt:message key="Common.citizen.label" bundle="${common_labels}"/><% } else { %><fmt:message key="Common.noncitizen.label" bundle="${common_labels}"/> <% } %>
              </td>
              <td class='LABEL' width='25%' ><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
			 <td class='QUERYDATA' ><% if(legal_status.equals("Y")){ %> <fmt:message key="Common.legal.label" bundle="${common_labels}"/><% } else { %><fmt:message key="Common.illegal.label" bundle="${common_labels}"/> <% } %>
              </td>
	      </tr>	
		  <tr>
		      <td class='label' width='5%' colspan='4'>&nbsp;</td>
	      </tr>
		  <tr>
              <td class='LABEL'  width='25%' ><fmt:message key="Common.bloodgroup.label" bundle="${common_labels}"/></td>
  		      <td class='QUERYDATA' width='25%'><%=blood_group%>&nbsp;</td>
			  <input type='hidden'  name="blood_group" id="blood_group"  value="<%=blood_group%>">
			  <td class='LABEL'  width='25%' ><fmt:message key="Common.RhFactor.label" bundle="${common_labels}"/></td> 
			  <td class='QUERYDATA' width='25%'><%=rh_factor%>&nbsp;</td>
	    </tr>
        <tr>
		      <td class='label' width='5%' colspan='4'>&nbsp;</td>
	    </tr>
		<tr>
			<td class='COLUMNHEADER' colspan='4' ><fmt:message key="Common.VisitDetail.label" bundle="${common_labels}"/></td>
		</tr>
	    <tr>
			 <td class='label' width='25%' colspan='4'>&nbsp;</td>
	    </tr>
		<tr>
		      <td class='LABEL' width='25%' ><fmt:message key="Common.VisitDateTime.label" bundle="${common_labels}"/></td>
  		      <td class='QUERYDATA' width='25%'>
 				     <%=ecis.utils.HTMLUtilities.getDisplayString(visit_adm_date_time)%>&nbsp;			    
              </td> 
			  <td class='label' colspan='2'>&nbsp;</td>
          </tr>
		  <tr>
		      <td class='label' width='25%' colspan='4'>&nbsp;</td>
	      </tr>
		  <tr>
		      <td class='LABEL'  width='25%' ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
			  <td class='QUERYDATA' width='25%'>
	 				   <%=ecis.utils.HTMLUtilities.getDisplayString(location1)%>&nbsp;			    
              </td>
			  <td class='LABEL' width='25%' ><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
			  <td class='QUERYDATA' width='25%' >
					  <%=ecis.utils.HTMLUtilities.getDisplayString(service_desc)%>&nbsp;			   
              </td>
	      </tr>
  		  <tr>
		      <td class='label' width='5%' colspan='4'>&nbsp;</td>
	      </tr>
		  <tr>
		      <td class='LABEL' width='25%' ><fmt:message key="eAE.RegistrationType.label" bundle="${ae_labels}"/></td>
			  <td class='QUERYDATA'  width='25%'>
					  <%=ecis.utils.HTMLUtilities.getDisplayString(visit_type_desc)%>&nbsp;		    
		      </td>
			  <td class='LABEL' width='25%' ><fmt:message key="Common.subservice.label" bundle="${common_labels}"/></td>
			  <td class='QUERYDATA'  width='25%' >
				  <%=ecis.utils.HTMLUtilities.getDisplayString(subservice_desc)%>&nbsp;			    
              </td>
          </tr>
		  <tr>
		      <td class='label' width='5%' colspan='4'>&nbsp;</td>
	      </tr>	
          <tr>
		      <td class='LABEL'  width='25%'><fmt:message key="Common.ModeofArrival.label" bundle="${common_labels}"/></td>
              <td class='QUERYDATA'>
						<%=ecis.utils.HTMLUtilities.getDisplayString(transport_mode)%>
						
						<%=ecis.utils.HTMLUtilities.getDisplayString(mode_of_arrival)%>
			  </td>
			  <%if(isPriorityZoneAppl){%>
			  <!--Added by Shanmukh for MMS-DM-CRF-0147-->
			 <td class='LABEL'  width='25%'><fmt:message key="Common.Critical.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eST.Patient.label" bundle="${st_labels}"/>&nbsp;<fmt:message key="eMO.Case.label" bundle="${mo_labels}"/></td>
			 <td class='QUERYDATA'><%=pat_critical_case_yn%> </td>
			  <%}%>
	      </tr>
          <tr>
		      <td class='label' width='25%' colspan='4'>&nbsp;</td>
	      </tr>	
		 <tr>
             <%if(!five_level_triage_appl_yn.equals("Y")  && (isLabelChngAppl == false)){ %> 
              	<td class='LABEL' ><fmt:message key="Common.broughtdead.label" bundle="${common_labels}"/></td>
	  		  <%}else{ %>
			 	<td class='LABEL'   ><fmt:message key="eAE.DeadOnArrival.label" bundle="${common_labels}"/></td>
			 <%}%>
	  		 
	  		  <td class='QUERYDATA' ><% if(brought_dead_yn.equals("N")){ %> <fmt:message key="Common.no.label" bundle="${common_labels}"/><% } else { %><fmt:message key="Common.yes.label" bundle="${common_labels}"/> <% } %>
              </td>
			  <!-- below line(s) modified by VenkateshS against ML-MMOH-CRF-0354 [IN057191] -->
			    <%if(siteSpecific){%>
				 <td class='LABEL' ><fmt:message key="Common.MedicalLegalCase.label" bundle="${common_labels}"/></td>
				<%}else {%>
			  <td class='LABEL' ><fmt:message key="Common.mlc.label" bundle="${common_labels}"/></td>
			  <%}%>
			  <!--end ML-MMOH-CRF-0354 [IN057191 -->
	  		  <td class='QUERYDATA' ><% if(mlc_case_yn.equals("N")){ %> <fmt:message key="Common.no.label" bundle="${common_labels}"/><% } else { %><fmt:message key="Common.yes.label" bundle="${common_labels}"/> <% } %>
              </td>
          </tr>
          <tr>
		      <td class='label' width='25%' colspan='4'>&nbsp;</td>
	      </tr>	
		  <tr>
		      <td class='LABEL' width='25%'><fmt:message key="Common.PriorityZone.label" bundle="${common_labels}"/></td>
              <td class='QUERYDATA'  width='25%'>
			  <%=ecis.utils.HTMLUtilities.getDisplayString(priority_zone_desc)%>&nbsp; </td>
			  <td class='LABEL' ><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
              <td class='QUERYDATA' ><%=ecis.utils.HTMLUtilities.getDisplayString(pat_priority)%>&nbsp; </td>
          </tr>
          <tr>
		      <td class='label' width='25%' colspan='4'>&nbsp;</td>
	      </tr>	
		  <tr>
			  <td class='LABEL'  width='25%' ><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/></td>
			  <td class='QUERYDATA'  width='25%' >
			  <%=ecis.utils.HTMLUtilities.getDisplayString(treatment_area_code_desc)%>&nbsp;</td>
			   <td class='LABEL' align='RIGHT' width='10%' ><fmt:message key="eAE.BedBayNo.label" bundle="${ae_labels}"/></td>
              <td class='QUERYDATA' >
			  <%=ecis.utils.HTMLUtilities.getDisplayString(bed_no)%>&nbsp;</td>
	      </tr>	
          <tr>
		      <td class='label' colspan='4'>&nbsp;</td>
	      </tr>	
		  <tr>
		      <td class='LABEL'   width='25%' ><fmt:message key="Common.Disaster.label" bundle="${common_labels}"/></td>
			  <td class='QUERYDATA' width='25%' ><% if(disaster_yn.equals("N")){ %> <fmt:message key="Common.no.label" bundle="${common_labels}"/><% } else { %><fmt:message key="Common.yes.label" bundle="${common_labels}"/> <% } %>
              </td>
			  <td class='LABEL' width='25%' ><fmt:message key="eAE.DisasterArea.label" bundle="${ae_labels}"/></td>
			  <td class='QUERYDATA'  width='25%' >
			  <%=ecis.utils.HTMLUtilities.getDisplayString(disaster_area_desc)%>&nbsp;</td>
		  </tr>
		  <tr>
		      <td class='label' colspan='4'>&nbsp;</td>
	      </tr>
		  <tr>
		      <td class='LABEL'  ><fmt:message key="eAE.DisasterType.label" bundle="${ae_labels}"/></td>
			  <td class='QUERYDATA'  >
			  <%=ecis.utils.HTMLUtilities.getDisplayString(disaster_type_desc)%>&nbsp;</td>
			  <td class='label' colspan='2'>&nbsp;</td>
          </tr>
		  <tr>
		      <td class='label' width='5%' colspan='4'>&nbsp;</td>
	      </tr>
      </table>
 </div>
 <!-- <a name="tab2"  ></a>
	<table cellspacing='0' cellpadding='0' width='95%' border=0 align='center'>
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
	</td></tr></table> -->
	<div id ='ArriveTab' style='display:none'>
	   <table border="0" cellpadding="0" cellspacing="0" align='center' width='95%'>
		<tr>
			<td class='COLUMNHEADER' colspan='4' ><fmt:message key="eAE.EscortDetail.label" bundle="${ae_labels}"/></td>
		</tr>
		<tr>
		      <td class='LABEL'  width='25%' ><fmt:message key="eAE.AccompaniedBy.label" bundle="${ae_labels}"/></td>
			  <td class='fields'  width='25%'>
				 <select name='accompany_by' id='accompany_by' >
					<option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------
				 <%  
				   PreparedStatement pstmtAccom = null;	
				   ResultSet rsetAccom = null;
				   StringBuffer escortBuf = new StringBuffer();
				   
                   escortBuf.append("SELECT ESCORT_TYPE_CODE, SHORT_DESC FROM AM_ESCORT_TYPE_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND EFF_STATUS='E' ORDER BY 2 ");
				   pstmtAccom = con.prepareStatement(escortBuf.toString());
				   rsetAccom = pstmtAccom.executeQuery();
				   while(rsetAccom!=null && rsetAccom.next())
					 {
					   if(accompany_by!=null && accompany_by.equalsIgnoreCase(rsetAccom.getString(1)))
					   out.println("<option value=\""+rsetAccom.getString(1)+"\" SELECTED >"+rsetAccom.getString(2)+" </option>");
					   else
					out.println("<option value=\""+rsetAccom.getString(1)+"\">"+rsetAccom.getString(2)+""); 
					 }
				   if(rsetAccom!=null) rsetAccom.close();
				   if(pstmtAccom!=null) pstmtAccom.close();
				   if((escortBuf != null) && (escortBuf.length() > 0))
					{
						escortBuf.delete(0,escortBuf.length());
					} 
             %> 
				 </select>
			</td>
			<td class='LABEL'  colspan='2'>&nbsp;</td>
			</tr>
			<tr>
			  <td class='LABEL'  width='25%'><fmt:message key="Common.relationship.label" bundle="${common_labels}"/></td>

  		      <td class='fields'  width='25%'>
			   <select name='relation_val' id='relation_val'  >
				  <option value=''>---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option> 
					   <%
					   pstmt = con.prepareStatement(sqlRelat.toString());
					   rset = pstmt.executeQuery();
 						while(rset!=null && rset.next())
						   {
										  
						      if(relation_to_patient!=null && relation_to_patient.equalsIgnoreCase(rset.getString(1)))
							   out.println("<option value=\""+rset.getString(1)+"\" SELECTED >"+rset.getString(2)+" </option>");
						
							    else 
								  out.println("<option value=\""+rset.getString(1)+"\">"+rset.getString(2)+" </option>");
						   }
						 
						 %>
						<script>
							var relation2patient="<%=relation_to_patient%>";
						   var index=document.forms[0].relation_val.options.selectedIndex;
						   
						   if(relation2patient!="" && document.forms[0].relation_val.options[index].value==relation2patient)
								document.forms[0].relation_val.disabled=false;
								
							else
								document.forms[0].relation_val.disabled=false;
						</script> 
						 <%
				   
						   if(pstmt!=null) pstmt.close();
						   if(rset!=null) rset.close();
						   if((sqlRelat != null) && (sqlRelat.length() > 0))
							 {
								sqlRelat.delete(0,sqlRelat.length());
							 } 
					   %>
                  </select>
              </td>
			  <td class='label' colspan='2'>&nbsp;</td>
 	         </tr>	
			 <tr>	
            <%if(accept_oth_alt_id_yn.equals("Y")){ %>
				<td class='LABEL' width='25%' ><fmt:message key="Common.otheraltid.label" bundle="${common_labels}"/></td>
				<td class='fields'  colspan='2' >
					  <select name='other_alt_id' id='other_alt_id'  onchange='ClearAltID();' >
						 <option value='' >--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------
					     <%
						   
							 StringBuffer sqlAlt = new StringBuffer();
                            //sqlAlt.append("select alt_id_type,LONG_DESC SHORT_DESC from mp_alternate_id_type_lang_vw where language_id='"+locale+"' and alt_id_type not in (select alt_id1_type from mp_param union select  nvl(alt_id2_type,1) from mp_param union select nvl(alt_id3_type,2) from mp_param union select nvl(alt_id4_type,3) from mp_param) and eff_status='E' order by 2"); Thursday, May 20, 2010 PE_EXE Venkat s
                             sqlAlt.append("select alt_id_type,LONG_DESC SHORT_DESC from mp_alternate_id_type_lang_vw where language_id='"+locale+"' and alt_id_type not in (select alt_id1_type from mp_param union all select  nvl(alt_id2_type,1) from mp_param union all select nvl(alt_id3_type,2) from mp_param union all select nvl(alt_id4_type,3) from mp_param) and eff_status='E' order by 2");
						     PreparedStatement pstmtAlt = null;
				             ResultSet rsetAlt = null;
						     pstmtAlt = con.prepareStatement(sqlAlt.toString());
					         rsetAlt = pstmtAlt.executeQuery();
							 while(rsetAlt!=null && rsetAlt.next())
						      {
								  if(ESCORT_OTH_ALT_ID_TYPE!=null &&   ESCORT_OTH_ALT_ID_TYPE.equalsIgnoreCase(rsetAlt.getString(1)))
							        out.println("<option value=\""+rsetAlt.getString(1)+"\" SELECTED >"+rsetAlt.getString(2)+" </option>");
							      else
				                    out.println("<option value=\""+rsetAlt.getString(1)+"\">"+rsetAlt.getString(2)+" ");
						      }
						      if(pstmtAlt!=null) pstmtAlt.close();
						      if(rsetAlt!=null) rsetAlt.close();
                              if((sqlAlt != null) && (sqlAlt.length() > 0))
								{
									sqlAlt.delete(0,sqlAlt.length());
								} 
				            %>  
                  </select>
                 <input type='text'  name="oth_alt_id" id="oth_alt_id"  value="<%=ESCORT_OTH_ALT_ID_NO%>" maxLength='15' size='15'  ></td>
               <%}else {%>
				  <td class='label' width='25%' colspan='2'></td>
              <% }%>
			      <td class='label' width='25%' >&nbsp;</td> 
				</tr>		 

				 <%String nat_on_blurfn_st = "";
				   String nat_on_blurfn_st_nok = "";//Added by Thamizh selvi on 8th Aug 2018 against ML-MMOH-CRF-1177
					 if(accept_national_id_no_yn.equals("Y"))
					 {
						 nat_on_blurfn_st = "makeValidString(this);CheckSplCharsNatID(this)";
						 /*Added by Thamizh selvi on 8th Aug 2018 against ML-MMOH-CRF-1177 Start*/
						 if(isAutoPopulateNOKDOBAppl && natDataSourceId.equals("NRIC"))
							nat_on_blurfn_st_nok = "makeValidString(this);if(CheckSplCharsNatID(this)){validateNOKNatIDWithDOB(this);}";
						 else
							nat_on_blurfn_st_nok = "makeValidString(this);CheckSplCharsNatID(this)";
						 /*End*/

						 /*
						 icn :20409 on blur we remove logic below part code.
						  nat_on_blurfn_st = "makeValidString(this); validateNationalID(this,'"+nat_id_check_digit_id+"','"+nat_id_chk_len+"','"+nat_id_prompt+"');";
						
						 if ( nat_id_check_digit_id.equals("M11") )
							nat_id_onKeyPress = "return CheckForCharsNatID(event);";
						 else
							nat_id_onKeyPress = "return allowValidNumber(this,event,2, 0);";
						*/

						if(nat_id_accept_alphanumeric_yn.equals("Y"))
						{
							nat_id_onKeyPress = "CheckForAlphaCharsNatID(event);";
						}
						else
						{
							if(nat_id_check_digit_id.equals("M11"))
								nat_id_onKeyPress = "CheckForCharsNatID(event);";
							else
								nat_id_onKeyPress = "allowValidNumber(this,event,2, 0);";
						}

                        %>
					 <tr>
	    				<td class='LABEL'  width='25%' ><%=nat_id_prompt%>&nbsp;</td>
						<td class='fields'  width='25%'><input type='text'  name="nat_id_no" id="nat_id_no"  value="<%=ESCORT_NATIONAL_ID_NO%>" maxlength='<%= nat_id_length%>' onkeypress="return <%=nat_id_onKeyPress%>" onblur="<%=nat_on_blurfn_st%>" size='20' >
		    	        </td> 
						<td class='label' colspan='2'>&nbsp;</td>
						</tr>
				<%}else{%>
                            <td class='label' colspan='4'>&nbsp;</td></tr>
                <% } %>

			
			<input type='hidden' name='m_town' id='m_town' value=''>
			<input type='hidden' name='r_region_code' id='r_region_code' value=''>
			<input type='hidden' name='r_town_code' id='r_town_code' value=''>
			<input type='hidden' name='r_town' id='r_town' value='' >
			<input type='hidden' name='n_town' id='n_town' value='' >
			<input type='hidden' name='f_town' id='f_town' value='' >
			<input type='hidden' name='e_town' id='e_town' value='' >
			<input type='hidden' name='r_area' id='r_area' value=''>
			<input type='hidden' name='m_area' id='m_area' value=''>
			<input type='hidden' name='n_area' id='n_area' value=''>
			<input type='hidden' name='f_area' id='f_area' value=''>
			<input type='hidden' name='e_area' id='e_area' value=''>
			<input type='hidden' name='r_region' id='r_region' value=''>
			<input type='hidden' name='m_region' id='m_region' value=''>
			<input type='hidden' name='n_region' id='n_region' value=''>
			<input type='hidden' name='f_region' id='f_region' value=''>
			<input type='hidden' name='e_region' id='e_region' value=''>
			<input type='hidden' name='r_area_code' id='r_area_code' value=''>
			<input type='hidden' name='r_postal_code' id='r_postal_code' value=''>

			<!-- added new -->
            <input type='hidden' name='employ_postal_code' id='employ_postal_code' value=''> 
			<input type='hidden' name='m_postal_code' id='m_postal_code' value=''>
			<input type='hidden' name='next_postal_code' id='next_postal_code' value=''>
			<input type='hidden' name='first_postal_code' id='first_postal_code' value=''>
	  <%
		tindex	=	8;
		out.println("<tr>") ; 
		StringBuffer sb2 = new StringBuffer() ;
		StringBuffer sb12 = new StringBuffer() ;
		StringBuffer sba2 = new StringBuffer() ;
		StringBuffer sbar2 = new StringBuffer();
        StringBuffer fieldVal2 = new StringBuffer("");
        for(int i=0;i<contact_col_names.length; i++) {
			String  val = contact_fields[i] ;
			sb2.append(val);
            int j=0 ;
			int j1=0 ;
            String old_val = "" ;
            String new_val = "" ;
                                     
            if(contact_col_names[i].equalsIgnoreCase("addr_line1_prompt")) {
				old_val = "r_addr_line1" ;
                new_val = "e_addr_line1" ;
			}else if(contact_col_names[i].equalsIgnoreCase("addr_line2_prompt")) {
				old_val = "r_addr_line2" ;
                new_val = "e_addr_line2" ;
            } else if(contact_col_names[i].equalsIgnoreCase("addr_line3_prompt")) {
	            old_val = "r_addr_line3" ;
                new_val = "e_addr_line3" ;
            } else if(contact_col_names[i].equalsIgnoreCase("addr_line4_prompt")) {
				old_val = "r_addr_line4" ;
                new_val = "e_addr_line4" ;
            } else if(contact_col_names[i].equalsIgnoreCase("res_town_prompt")) {
				old_val = "r_town_code" ;
                new_val = "m_town_code" ;
			}//Added by kumar on 13/03/2003 for region 
			else if(contact_col_names[i].equalsIgnoreCase("region_prompt")) {
				old_val = "r_region_code" ;
                new_val = "m_region_code" ;
            } else if(contact_col_names[i].equalsIgnoreCase("res_area_prompt")) {
				old_val = "r_area_code" ;
                new_val = "m_area_code" ;
            } else if(contact_col_names[i].equalsIgnoreCase("postal_code_prompt")) {
				old_val = "r_postal_code" ;
                new_val = "m_postal_code" ;
            }
			out.println("<td class='label' width='25%' >"+contact_prompts[i]+"&nbsp;</td>") ;	
            while(val.indexOf(old_val) != -1)  {
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
			for(int z=0;z<val.length();z++) {
				String tempVal=sb12.substring(z,z+1);
				if(tempVal.equals("@")) {
					fieldVal2.append(++tindex);
				} else {
					fieldVal2.append(tempVal);
				}
			}
			
            val = fieldVal2.toString();
            out.println("<td class='fields'  width='25%'>"+val) ;
			out.println("</td>");
			out.println("<td class='label' colspan='2'>&nbsp;</td>");
			out.println("</tr>") ;
			sb12.delete(0,sb12.length());
			fieldVal2.delete(0,fieldVal2.length());
			sb2.delete(0,sb2.length());
			sba2.delete(0,sba2.length());
			sbar2.delete(0,sbar2.length());
        }
%>            
<script>
				        // Added on 7/05/2004 for assigning values to dynamically generated address related fields..
						if(document.forms[0].e_addr_line1)
						   document.forms[0].e_addr_line1.value = "<%=escort_add_ln1%>" ;
						if(document.forms[0].e_addr_line2)
						   document.forms[0].e_addr_line2.value = "<%=escort_add_ln2%>" ;
						if(document.forms[0].e_addr_line3)
						   document.forms[0].e_addr_line3.value = "<%=escort_add_ln3%>" ;
						if(document.forms[0].e_addr_line4)
						   document.forms[0].e_addr_line4.value = "<%=escort_add_ln4%>" ;

						if(document.forms[0].m_town_code)
						{
						 document.forms[0].m_town_code.value = "<%= arr_res_town_desc%>";
						 document.forms[0].m_town.value = "<%=RES_TOWN_CODE%>";
						}
						if(document.forms[0].m_region_code)
						{
					     document.forms[0].m_region_code.value = "<%=arr_region_desc%>";
						 document.forms[0].m_region.value = "<%=ESCORT_REGION_CODE%>"; 	
                        }
						if(document.forms[0].m_area_code)
						{
                		document.forms[0].m_area_code.value = "<%=arr_res_area_desc%>";
						document.forms[0].m_area.value = "<%=RES_AREA_CODE%>"; 
						}
						if(document.forms[0].m_postal_code1){
						   document.forms[0].m_postal_code.value = "<%=ESCORT_ADD_POSTAL_CODE%>";
						   document.forms[0].m_postal_code1.value = "<%=ESCORT_ADD_POSTAL_DESC%>";
						}
			
       						// End of addition on 7/05/2004 for assigning values to dynamically generated address related fields..
						 </script>	
          <tr>

		      <td class='LABEL'  width='25%'><fmt:message key="Common.country.label" bundle="${common_labels}"/></td>
  		      <td class='fields'  width='25%'>
			  <select name='next_country1' id='next_country1' >
				 <option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------
				   <%
			  // pstmt = con.prepareStatement(sqlCountry.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY ); Thursday, May 20, 2010 PE_EXE Venkat s
			   pstmt = con.prepareStatement(sqlCountry.toString());
		       rset = pstmt.executeQuery();
			   while(rset!=null && rset.next())
			   {
				countryescort_code=rset.getString(1);
				 if(countryescort_code!=null && countryescort_code.equalsIgnoreCase(escort_contcode))
				   {
					out.println("<option value=\""+rset.getString(1)+"\" SELECTED >"+rset.getString(2)+" ");
				out.println("<script>document.forms[0].next_country1.disabled=false</script>");
				   }
				 else
				   {
				   out.println("<option value=\""+rset.getString(1)+"\">"+rset.getString(2)+" ");
			   }
			   }
			   if(rset!=null) rset.close();
    		   if(pstmt!=null) pstmt.close();
			   %>
                     </select>
              </td>
			  <td class='LABEL'  colspan='2'>&nbsp;</td>
	  </tr>
	  <tr>
		    
		      <td class='LABEL'  width='25%' ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
  		      <td class='fields'  width='25%' colspan='3'>
				<% if(!escort_remarks.equals("")) { %>	
 				   <textarea name='arrival_remarks' cols='60' rows='3' align='left'  onKeyPress="checkMaxLen(this);"  onBlur='makeValidString(this);return(callCheckMaxLen(this,2000,"Remarks"));'  readonly><%=java.net.URLDecoder.decode( escort_remarks, "UTF-8" )%></textarea>
				<%}else{%>
					<textarea name='arrival_remarks' cols='60' rows='3' align='left'  onKeyPress="checkMaxLimit(this,2000);"  onBlur='makeValidString(this);'  ></textarea>
                <%}%>
		      </td>
	      </tr>	
		  <tr>
				<td class='COLUMNHEADER' colspan='4' ><fmt:message key="eAE.AmbulanceDetails.label" bundle="${ae_labels}"/></td>
		  </tr>
         <tr>
				<td class='LABEL'  width='25%' ><fmt:message key="eAE.NameofEscortService.label" bundle="${ae_labels}"/></td>
  		        <td class='fields'  width='25%'>
                 <% if(!escort_name.equals("")) {
				 
				 %>	
				 <input type='text'  name="name_of_escort" id="name_of_escort"  value ="<%=ecis.utils.HTMLUtilities.getDisplayString(escort_name)%>" maxLength='30' size='25'  onBlur="makeValidString(this)" readonly>
             <%}else{%>
                 <input type='text'  name="name_of_escort" id="name_of_escort"  value ="" maxLength='30' size='25'  onBlur="makeValidString(this)" >
              <%}%>
		      </td>
			  <td class='label' colspan='2'>&nbsp;</td>
         </tr>
		<tr>
			  <td class='LABEL' width='25%' ><fmt:message key="eAE.EscAmbulanceContNo.label" bundle="${ae_labels}"/></td>
  		      <td class='fields'  width='25%'>
		     <% if(!escort_tel_num.equals("")) { %>	
 				   <input type='text'  name="ambulance_contact_no" id="ambulance_contact_no"  value="<%=ecis.utils.HTMLUtilities.getDisplayString(escort_tel_num)%>"  maxLength='18' size='18'  onBlur="makeValidString(this)"  readonly>
             <%}else{%>
                 <input type='text'  name="ambulance_contact_no" id="ambulance_contact_no"  value=""  maxLength='18' size='18'  onBlur="makeValidString(this)" >
              <%}%>
		      </td>
              <td class='label' colspan='2'>&nbsp;</td>
		</tr>
        <tr>
			  <td class='LABEL'  width='25%' ><fmt:message key="eAE.VehicleRegNo.label" bundle="${ae_labels}"/></td>
  		      <td class='fields'  width='25%'>
              <% if(!escort_mv_reg_no.equals("")) { %>	
 				   <input type='text'  name="motor_vehicle_reg_no" id="motor_vehicle_reg_no" value="<%=ecis.utils.HTMLUtilities.getDisplayString(escort_mv_reg_no)%>"  maxLength='15' size='15'  onBlur='makeValidString(this);' >
              <%}else{ %>
				<input type='text'  name="motor_vehicle_reg_no" id="motor_vehicle_reg_no"  value=""  maxLength='15' size='15'  onBlur="makeValidString(this)" >
              <%}%>
		      </td><td class='label' colspan='2'>&nbsp;</td>
        </tr>
       </table>
	 </div>
      <!-- <a name="tab3" ></a> 
	  <table cellspacing='0' cellpadding='0' width='95%' border=0 align='center'>
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
	 </td></tr></table> -->
	 <div id ='Relatedtab' style = 'display:none'>
<table cellspacing='0' cellpadding='0' width='95%' border=0 align='center'>
      <tr><td class='white'>
	  	<a name='kin'></a>
			<ul id="tablist" class="tablist">
				<li class="tablistitem" title="Next of kin">
					<a onclick="onTabClickOf('firstkin')" class="tabClicked" id="firstkin" >
						<span class="tabSpanclicked" id="firstkinspan"><fmt:message key="Common.nextofkin.label" bundle="${common_labels}"/></span>
					</a>
				</li>
				<li class="tablistitem" title="Contact Mode and Address details">
					<a onclick="onTabClickOf('firstkin1')" class="tabA" id="firstkin1" >
						<span class="tabAspan" id="firstkin1span"><fmt:message key="Common.firsttonotify.label" bundle="${common_labels}"/></span>
					</a>
				</li>
				<li class="tablistitem" title="Employment Details">
					<a onclick="onTabClickOf('firstempyr')" class="tabA" id="firstempyr" >
						<span class="tabAspan" id="firstempyrspan"><fmt:message key="Common.employmentdetails.label" bundle="${common_labels}"/></span>
					</a>
				</li>	
			</ul>
          </td></tr>
</table>
</div>
	
<div id = 'nextOfKin'  style='display:none'>

      <table cellspacing='0' cellpadding='0' width='95%' border=0 align='center'>
		 <tr><td valign=top width='50%'><table cellspacing='0' cellpadding='0' width='100%' border='0' align='center'>
				  <!--@@@@@@@@@@@@@ Next of Kin.................start @@@@@@@@@@@-->
			<tr>
				<td colspan=4 class=label height=5></td>
			</tr>
			<%if(isAENextofKinchngAppl) //  added by mujafar for ML-MMOH-CRF-0632
			{%>
			<tr>
				<td  class='label' width='25%' >
				<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>&nbsp;&nbsp;<span class='field'><td class='fields' width='25%'><input type='text'  name="patient_id1" id="patient_id1"  value="<%=rel_patient_id%>" maxLength='<%=patient_id_length%>' size='20' onKeyPress="return(CheckForSpecChars(event))" 
			onBlur='changeCase(this);searchPatient1(document.forms[0].patient_id1);'>&nbsp;<input type="button" name="patient_search" id="patient_search" class=BUTTON value="?" onChange='disReset();' onClick="if(document.forms[0].patient_id1.value==''){callPatientSearch1()}" ></td></span>	
             <input type='hidden' name='patient_id1_val' id='patient_id1_val' value='<%=rel_patient_id%>'>
            </td>
			
			</tr>
			
			<tr>
               <%
                   if (!NAT_ID_PROMPT1.equals("")){%>  
		 		       <td class='label'><%=NAT_ID_PROMPT1%></td>
			           <td class='fields'>
				         <input type='text' name='contact1_new_nat_id_no' id='contact1_new_nat_id_no' maxlength='<%= NAT_ID_LENGTH1%>' size='20'  onblur="<%=nat_on_blurfn_st_nok%>" value="<%=CONTACT1_NATIONAL_ID_NO%>"  onkeypress="return <%=nat_id_onKeyPress%>"></td><!--Modified by Thamizh selvi on 7th Aug 2018 against ML-MMOH-CRF-1177-->
			   <%}else {%>  
						<td class='label' colspan='2'>&nbsp;</td> 
               <%}%>   
		  </tr>
			
		
			<%}%>
			
			
			
			
			
			
			<tr>
				<td  class='label' width='25%'><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
				<td class='fields'  width='25%'>
				<% /*Below line added for ML-MMOH-CRF-0887.1*/
					if(increasedaddressLength){%>
					<textarea name='next_contact_name' rows=3 maxlength=80 cols=45 onblur='makeValidString(this); maxLengthPaste(this);' onkeypress='checkMaxLimit(this,80)' onkeyup='RemoveSpecialChar(this)'><%=contact1_name%></textarea>
					<%}else{%>				
				    <input type="text" name="next_contact_name" id="next_contact_name"  maxlength='30' size='30'  value="<%=contact1_name%>">
				<%}%>
				</td>
			</tr>
				 <%
					StringBuffer MPRelBuff = new StringBuffer();
				
                    MPRelBuff.append("select relationship_code,short_desc from mp_relationship_lang_vw where language_id='"+locale+"' and eff_status='E' order by 2 ");
				   codes =new ArrayList();
				   descs =new ArrayList();
				
				   oth_stmt = con.prepareStatement(MPRelBuff.toString());
				   oth_rset = oth_stmt.executeQuery();	
				   while( oth_rset.next() )
				   {
					 codes.add(oth_rset.getString(1)) ;
					 descs.add(oth_rset.getString(2)) ;
				   }
				   relationcode = codes.toArray();   
				   relationdesc = descs.toArray();

				   codes = null; 
				   descs = null;
			       if(oth_rset!=null) oth_rset.close();
			       if(oth_stmt!=null) oth_stmt.close();
			 %>
			<tr>
				 <td class='label' width='50%' ><fmt:message key="Common.relationship.label" bundle="${common_labels}"/></td>
			     <td class='fields'  width='50%'>
				     <select name='next_contact_relation' id='next_contact_relation' >
                     <option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
                 <%
				   String relcode = contact1_relation;
					pstmtR = con.prepareStatement(MPRelBuff.toString());
                    rsetR=pstmtR.executeQuery();
					if(rsetR!=null)
					{
					   while(rsetR.next())
					   {
							String relationDesc = rsetR.getString("short_desc");
							String relationCode = rsetR.getString("relationship_code");
						
							if(relcode.equals(relationCode))
								sel = "selected";
							else
								sel="";
				
							out.println("<option value=\""+relationCode+"\" "+sel+">"+relationDesc+"</option>");
						}
					}
					if(rsetR!=null) rsetR.close();
    		        if(pstmtR!=null) pstmtR.close();
                    %>
                    </select>
				</td>
		  </tr>	
		  <%if(!isAENextofKinchngAppl)
			{%>
		  <tr>
               <%
                   if (!NAT_ID_PROMPT1.equals("")){%>  
		 		       <td class='label'><%=NAT_ID_PROMPT1%></td>
			           <td class='fields'>
				         <input type='text' name='contact1_new_nat_id_no' id='contact1_new_nat_id_no' maxlength='<%= NAT_ID_LENGTH1%>' size='20'  onblur="<%=nat_on_blurfn_st_nok%>" value="<%=CONTACT1_NATIONAL_ID_NO%>"  onkeypress="return <%=nat_id_onKeyPress%>"></td><!--Modified by Thamizh selvi on 7th Aug 2018 against ML-MMOH-CRF-1177-->
			   <%}else {%>  
						<td class='label' colspan='2'>&nbsp;</td> 
               <%}%>   
		  </tr>
		 <%}%>
		  <tr>
			   <td  class='label'><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/></td>
               <td class='fields'>
                  <input type='text' name='contact1_birth_date' id='contact1_birth_date' id='birthdate1' maxlength='10' size='10'   value="<%=CONTACT1_BIRTH_DATE%>"  onBlur = 'makeValidString(this);doDate(this);'><img src='../../eCommon/images/CommonCalendar.gif' id="birthdate"  onClick="document.forms[0].contact1_birth_date.select();return showCalendar('birthdate1');"  style='cursor:pointer'></img>
                </td>
		  </tr>	
		  <tr>
				<td  class='label'><fmt:message key="eMP.occupation.label" bundle="${mp_labels}"/></td>
                <td class='fields'>
                  <input type='text' name='next_job_title' id='next_job_title' maxlength='30' size='30'  onblur='makeValidString(this);' value ='<%=JOB1_TITLE%>'>
				</td>
		  </tr>
		</table>
			  </td>  
			  <td><table cellspacing='0' cellpadding='0' border='0'>
              <table cellspacing='0' cellpadding='0' border="0">
                <%
					out.println("<tr><td colspan=4 class=label height=5></td></tr>");
					out.println("<tr>") ;
					StringBuffer sb7 = new StringBuffer() ;
					StringBuffer sb17 = new StringBuffer() ;
					StringBuffer sba7 = new StringBuffer() ;
					StringBuffer sbar7 = new StringBuffer() ;
                    StringBuffer fieldVal7 = new StringBuffer("");
                    for(int i=0;i<contact_col_names.length; i++) {   
						String  val = contact_fields[i] ;
						sb7.append(val);
						//StringBuffer sb = new StringBuffer(val) ;
                        int j=0 ;
						int j1=0;
                        String old_val = "" ;
                        String new_val = "" ;
                                  
                        if(contact_col_names[i].equalsIgnoreCase("addr_line1_prompt")) {
							old_val = "r_addr_line1" ;
                            new_val = "next_addr_line1" ;
						} else if(contact_col_names[i].equalsIgnoreCase("addr_line2_prompt")) {     	old_val = "r_addr_line2" ;
                            new_val = "next_addr_line2" ;
                        } else if(contact_col_names[i].equalsIgnoreCase("addr_line3_prompt")) {
							old_val = "r_addr_line3" ;
                            new_val = "next_addr_line3" ;
					    } else if(contact_col_names[i].equalsIgnoreCase("addr_line4_prompt")) {     	old_val = "r_addr_line4" ;
                            new_val = "next_addr_line4" ;
                        } else if(contact_col_names[i].equalsIgnoreCase("res_town_prompt")) {
							old_val = "r_town_code" ;
                            new_val = "contact1_res_town_code" ;
						} else if(contact_col_names[i].equalsIgnoreCase("region_prompt")) {
							old_val = "r_region_code" ;
                            new_val = "contact1_region_code" ;
						} else if(contact_col_names[i].equalsIgnoreCase("res_area_prompt")) {
							old_val = "r_area_code" ;
                            new_val = "contact1_res_area_code" ;
                        } else if(contact_col_names[i].equalsIgnoreCase("postal_code_prompt")) {    	old_val = "r_postal_code" ;
                            new_val = "next_postal_code" ;
                        }
						out.println("<td class='label'  >"+contact_prompts[i]+"&nbsp;</td>") ;	
                        while(val.indexOf(old_val) != -1) {
							j = val.indexOf(old_val,j) ;
                            sb7 = sb7.replace(j,(j+old_val.length()),new_val);
                            val = sb7.toString();
						}

                     // Newly added
					if(contact_col_names[i].equalsIgnoreCase("res_town_prompt")) {
						sba7.append(val);
						while(val.indexOf("r_postal_code") != -1) {
							j1 = val.indexOf("r_postal_code",j1) ;
							sba7 = sba7.replace(j1,(j1+"r_postal_code".length()),"next_postal_code");
							val = sba7.toString();
						}
					}
					if(contact_col_names[i].equalsIgnoreCase("res_area_prompt")) {
						j1 = 0;
						sbar7.append(val);
						while(val.indexOf("r_postal_code") != -1) {
							j1 = val.indexOf("r_postal_code",j1) ;
							sbar7 = sbar7.replace(j1,(j1+"r_postal_code".length()),"next_postal_code");
							val = sbar7.toString();
						}
					}
						sb17.append(val);
						for(int z=0;z<val.length();z++) {
							String tempVal=sb17.substring(z,z+1);
							if(tempVal.equals("@")) {
							fieldVal7.append(++tindex);
							}else {
							fieldVal7.append(tempVal);
							}
						}
						val = fieldVal7.toString();
						out.println("<td class='fields'>"+val) ;
						out.println("</td>");
						out.println("</tr>") ;
						sb17.delete(0,sb17.length());
						fieldVal7.delete(0,fieldVal7.length());
						sb7.delete(0,sb7.length());
						sba7.delete(0,sba7.length());
						sbar7.delete(0,sbar7.length());
                    }
                %> 

					<script>
						
				        // Added on 7/05/2004 for assigning values to dynamically generated address related fields..
						if(document.forms[0].next_addr_line1)
						   document.forms[0].next_addr_line1.value = "<%=addr1_line1%>" ;
						if(document.forms[0].next_addr_line2)
						   document.forms[0].next_addr_line2.value = "<%=addr1_line2%>" ;
						if(document.forms[0].next_addr_line3)
						   document.forms[0].next_addr_line3.value = "<%=addr1_line3%>" ;
						if(document.forms[0].next_addr_line4)
						   document.forms[0].next_addr_line4.value = "<%=addr1_line4%>" ;
						if(document.forms[0].contact1_res_town_code)
						{
						 document.forms[0].contact1_res_town_code.value = "<%=contact1_res_town_desc%>";
						  document.forms[0].n_town.value = "<%=contact1_res_town%>";
						 
						}
						if(document.forms[0].contact1_region_code)
						{
					     document.forms[0].contact1_region_code.value = "<%=contact1_region_desc%>";
						 document.forms[0].n_region.value = "<%=contact1_region_code%>"; 

                        }
						if(document.forms[0].contact1_res_area_code)
						{
                		document.forms[0].contact1_res_area_code.value = "<%=contact1_res_area_desc%>";
						document.forms[0].n_area.value = "<%=contact1_res_area_code%>";
						}
						

						if(document.forms[0].next_postal_code1){
						   document.forms[0].next_postal_code.value = "<%=postal1_code%>"; 
						   document.forms[0].next_postal_code1.value = "<%=postal1_desc%>"; 
						   }
					
						// End of addition on 7/05/2004 for assigning values to dynamically generated address related fields..
						 </script> 
		
      	    <tr>
			   <td  class='label'><fmt:message key="Common.country.label" bundle="${common_labels}"/></td>
			   <td class='fields'>
				   <input align='left' type='text' name='next_country_desc' id='next_country_desc'                       size='15' maxlength='15' onblur='if(this.value !="")searchCountry(contry_code[0],next_country_desc);'          value = "<%=country1_code_desc%>" ><input type='button' name='contry_code' id='contry_code' value='?' class='button' onclick='searchCountry(this,next_country_desc)' >
				   <input type='hidden' name='next_country_code' id='next_country_code' >
					<script>
					   if(document.forms[0].next_country_code)
						  document.forms[0].next_country_code.value = "<%=country1_code%>";
					   if(document.forms[0].next_country_desc)
						  document.forms[0].next_country_desc.value = "<%=country1_code_desc%>";
					</script>
                </td>
          </tr> 
          <tr>
              <td class='label'><fmt:message key="Common.homephoneno.label" bundle="${common_labels}"/></td>
              <td class='fields'>
				  <input type='text' name='next_res_tel_no' id='next_res_tel_no' maxlength='20' size='20'  onblur='makeValidString(this);' value ="<%=res1_tel_no%>">
              </td>
		  </tr>
          <tr>
              <td  class='label' ><fmt:message key="Common.MobileNo.label" bundle="${common_labels}"/></td>
              <td class='fields'><input type='text' name='contact1_mob_tel_no' id='contact1_mob_tel_no' maxlength='20' size='20'  onblur='makeValidString(this);' value ="<%=res1_mbo_tel_no%>">
              </td>
		  <tr>
			  <td  class='label'><fmt:message key="Common.officephoneno.label" bundle="${common_labels}"/></td>
              <td class='fields'>
				  <input type='text' name='next_off_tel_no' id='next_off_tel_no' maxlength='20' size='20'  onblur='makeValidString(this);' value ="<%=off1_tel_no%>">
              </td>
          </tr>
		  <tr>
		      <td class='label'><fmt:message key="Common.email.label" bundle="${common_labels}"/></td>
              <td class='fields'><input type='text' name='contact1_email_id' id='contact1_email_id' maxlength='50' size='42'  onblur="makeValidString(this);"  value = "<%=contact1_email_id%>">

             <!--  <td class='fields'><input type='text' name='contact1_email_id' id='contact1_email_id' maxlength='50' size='42' tabIndex onblur="makeValidString(this);tab_click2('#kin1','firstkin1');"  -->
              </td>
          </tr></td></tr>
		  <tr><td colspan=4 class=label height=5></td></tr></table></table>
	 </div>
 <!--  <a name="kin1" ></a> 
  <table cellspacing='0' cellpadding='0' width='95%' border=0 align='center'>
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
	<table cellspacing='0' cellpadding='0' width='95%' border=0 align='center'>
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

       -->
	   <div id = 'Addressdetails' style='display:none'>
    <table cellspacing='0' cellpadding='0' width='95%' align='center'>
	  <tr>
				<td class='label' width='25%'><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
				<td class='fields'  width='25%'>
					<input type='text' name='notify_name' id='notify_name'  value="<%=first_to_notify_name%>" onblur='makeValidString(this);' maxlength='30' size ='30'>
				</td>
				<td class='label' width='25%' colspan='2'>&nbsp;</td>
	  </tr>
  	  <tr>
				<td  class='label' width='25%'><fmt:message key="Common.relationship.label" bundle="${common_labels}"/></td>
				<td class='fields'  width='25%'>
						<select name='first_contact_relation' id='first_contact_relation' >
							 <option value=''>--------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------------</option>
								<%
								   relcode = contact2_relation;
								   pstmtR = con.prepareStatement(MPRelBuff.toString());
								   rsetR=pstmtR.executeQuery();
								   if(rsetR!=null)
								   {
										   while(rsetR.next())
											{
												String relationDesc = rsetR.getString("short_desc");
												String relationCode = rsetR.getString("relationship_code");
											
												if(relcode.equals(relationCode))
													sel = "selected";
												else
													sel="";
									
												out.println("<option value=\""+relationCode+"\" "+sel+">"+relationDesc+"</option>");
											}
									}
									if(rsetR!=null) rsetR.close();
									if(pstmtR!=null) pstmtR.close();
									if((MPRelBuff != null) && (MPRelBuff.length() > 0))
									{
										MPRelBuff.delete(0,MPRelBuff.length());
									} 
								%>
					 </select>
				 </td>
				 <td class='label' width='25%' colspan='2'>&nbsp;</td>
	  </tr>
		<%if(accept_national_id_no_yn.equals("Y")){%>
			 <tr>
				  <td class='LABEL' width='25%'><%=nat_id_prompt%>&nbsp;</td>
				  <td class='fields' width='25%'><input type='text'  name="contact2_nat_id_no" id="contact2_nat_id_no"   value = "<%=contact2_nat_id%>" maxlength='<%= nat_id_length%>'  size='20'  onkeypress="return <%=nat_id_onKeyPress%>" onblur="<%=nat_on_blurfn_st%>" ></td>
				  <td class='label'  colspan='2'>&nbsp;</td> 
			</tr>	
		<% } %>

	  <tr>
				<td class='label'><fmt:message key="eMP.occupation.label" bundle="${mp_labels}"/></td>
				<td  class='fields' >
							<input type='text' name='first_job_title' id='first_job_title' maxlength='30' size='30'  onblur='makeValidString(this);' value="<%=job2_title%>">
							
				</td>
				<td class='label' width='25%' colspan='2'>&nbsp;</td>
	   </tr>
	   <tr>
				 <td class='label' ><fmt:message key="Common.homephoneno.label" bundle="${common_labels}"/></td>
				 <td class='fields' >
					   <input type='text' name='first_res_tel_no' id='first_res_tel_no' maxlength='20' size='20'  onblur='makeValidString(this);' value ="<%=contact2_res_tel_no%>">
				 </td>
				<td class='label' width='25%' colspan='2'>&nbsp;</td>
	   </tr>
	   <tr>
				<td class='label'><fmt:message key="Common.MobileNo.label" bundle="${common_labels}"/></td>
				<td class='fields'>
					  <input type='text' name='contact2_mob_tel_no' id='contact2_mob_tel_no' maxlength='20' size='20'  onblur='makeValidString(this);' value = "<%=contact2_mob_tel_no%>">
				</td>
				<td class='label' width='25%' colspan='2'>&nbsp;</td>
	   </tr>
	   <tr>
				<td class='label' ><fmt:message key="Common.officephoneno.label" bundle="${common_labels}"/></td>
				<td class='fields'>
					  <input type='text' name='first_off_tel_no' id='first_off_tel_no' maxlength='20' size='20'  onblur='makeValidString(this);' value = "<%=contact2_off_tel_no%>">
				</td>
				<td class='label' width='25%' colspan='2'>&nbsp;</td>
	   </tr>
	   <tr>
				<td  class='label'><fmt:message key="Common.email.label" bundle="${common_labels}"/></td>
				<td class='fields'>
					  <input type='text' name='contact2_email_id' id='contact2_email_id' maxlength='50' size='45'  onblur='makeValidString(this);' value = "<%=contact2_mail_id%>">
				</td>
				<td class='label' width='25%' colspan='2'>&nbsp;</td>
	   </tr>	 
              <%  
				  out.println("<tr>") ;
						//int counter1=0;
						StringBuffer sb8 = new StringBuffer() ;
						StringBuffer sb18 = new StringBuffer() ;
						StringBuffer sba8 = new StringBuffer() ;
						StringBuffer sbar8 = new StringBuffer() ;
						StringBuffer fieldVal8 = new StringBuffer("");
                    for(int i=0;i<contact_col_names.length; i++)
                            {
                                                                   
									out.println("<td class='label'  >"+contact_prompts[i]+"</td>") ;

                                    String val = contact_fields[i] ;
									sb8.append(val);
                                    int j=0 ;
									int j1=0;
                                    String old_val = "" ;
                                    String new_val = "" ;
                                     
                                     if(contact_col_names[i].equalsIgnoreCase("addr_line1_prompt"))
                                     {
                                        old_val = "r_addr_line1" ;
                                        new_val = "first_addr_line2" ;
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("addr_line2_prompt"))
                                     {
                                        old_val = "r_addr_line2" ;
                                        new_val = "first_addr_line1" ;
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("addr_line3_prompt"))
                                     {
                                        old_val = "r_addr_line3" ;
                                        new_val = "first_addr_line3" ;
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("addr_line4_prompt"))
                                     {
                                        old_val = "r_addr_line4" ;
                                        new_val = "first_addr_line4" ;
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("res_town_prompt"))
                                     {
                                        old_val = "r_town_code" ;
                                        new_val = "contact2_res_town_code" ;
                                     }
									 else if(contact_col_names[i].equalsIgnoreCase("region_prompt"))
                                     {
                                        old_val = "r_region_code" ;
                                        new_val = "contact2_region_code" ;
                                     }
									 else if(contact_col_names[i].equalsIgnoreCase("res_area_prompt"))
                                     {
                                        old_val = "r_area_code" ;
                                        new_val = "contact2_res_area_code" ;
                                     }                                     
                                     else if(contact_col_names[i].equalsIgnoreCase("postal_code_prompt"))
                                     {
                                        old_val = "r_postal_code" ;
                                        new_val = "first_postal_code" ;
                                     }

                                    while(val.indexOf(old_val) != -1)
                                    {
                                        j = val.indexOf(old_val,j) ;
                                        sb8 = sb8.replace(j,(j+old_val.length()),new_val);
                                        val = sb8.toString();
                                    }
                      // Newly added
					if(contact_col_names[i].equalsIgnoreCase("res_town_prompt")) {
						sba8.append(val);
						while(val.indexOf("r_postal_code") != -1) {
							j1 = val.indexOf("r_postal_code",j1) ;
							sba8 = sba8.replace(j1,(j1+"r_postal_code".length()),"first_postal_code");
							val = sba8.toString();
						}
					}
					if(contact_col_names[i].equalsIgnoreCase("res_area_prompt")) {
						j1 = 0;
						sbar8.append(val);
						while(val.indexOf("r_postal_code") != -1) {
							j1 = val.indexOf("r_postal_code",j1) ;
							sbar8 = sbar8.replace(j1,(j1+"r_postal_code".length()),"first_postal_code");
							val = sbar8.toString();
						}
					}
									sb18.append(val);
									for(int z=0;z<val.length();z++)
									{
										String tempVal=sb18.substring(z,z+1);
										if(tempVal.equals("@"))
										{
											fieldVal8.append(++tindex);
										}
										else
										{
											fieldVal8.append(tempVal);
										}
									}
                                  	val = fieldVal8.toString();
                                    out.println("<td class='fields'>"+val) ;
								    out.println("</td><td class='label' colspan='2'>&nbsp;</td>");
						            out.println("</tr>") ;
									sb18.delete(0,sb18.length());
									fieldVal8.delete(0,fieldVal8.length());
									sb8.delete(0,sb8.length());
									sba8.delete(0,sba8.length());
									sbar8.delete(0,sbar8.length());
                            }
                %> 
				
	 
					<script>
				        // Added on 7/05/2004 for assigning values to dynamically generated address related fields..
						if(document.forms[0].first_addr_line1)
						   document.forms[0].first_addr_line1.value = "<%=contact2_add_l1%>" ;
						if(document.forms[0].first_addr_line2)
						   document.forms[0].first_addr_line2.value = "<%=contact2_add_l2%>" ;
						if(document.forms[0].first_addr_line3)
						   document.forms[0].first_addr_line3.value = "<%=contact2_add_l3%>" ;
						if(document.forms[0].first_addr_line4)
						   document.forms[0].first_addr_line4.value = "<%=contact2_add_l4%>" ;
						if(document.forms[0].contact2_res_town_code)
						{
						 document.forms[0].contact2_res_town_code.value = "<%=contact2_res_town_desc%>";
						 document.forms[0].f_town.value = "<%=contact2_town_code%>";

						}
						if(document.forms[0].contact2_region_code)
						{
					     document.forms[0].contact2_region_code.value = "<%=contact2_region_desc%>";
						 document.forms[0].f_region.value = "<%=contact2_reg_code%>"; 

                        }
						if(document.forms[0].contact2_res_area_code)
						{

                		document.forms[0].contact2_res_area_code.value = "<%=contact2_res_area_desc%>";
						document.forms[0].f_area.value = "<%=contact2_area_code%>";

						}
						if(document.forms[0].first_postal_code1){
						   document.forms[0].first_postal_code.value = "<%=postal2_code%>";
						   document.forms[0].first_postal_code1.value = "<%=postal2_desc%>";
						   }
					
						// End of addition on 7/05/2004 for assigning values to dynamically generated address related fields..
						 </script> 
       <tr>
				  <td  class='label'><fmt:message key="Common.country.label" bundle="${common_labels}"/></td>
				  <td class='fields'>
						<input align='left' type='text' name='first_country_desc' id='first_country_desc'  size='15' maxlength='15' onblur='if(this.value !="")searchCountry(contry_code[0],first_country_desc);'  value ="<%=country2_code_desc%>" ><input type='button' name='contry_code' id='contry_code' value='?' class='button' onclick='searchCountry(this,first_country_desc)' >
						<input type='hidden' name='first_country_code' id='first_country_code' value=''>
				   <script>
						if(document.forms[0].first_country_code)
						   document.forms[0].first_country_code.value = "<%=contact2_country_code%>";
						if(document.forms[0].first_country_desc)
						   document.forms[0].first_country_desc.value = "<%=country2_code_desc%>";
				  </script>
				</td>
				<td class='label' width='25%' colspan='2'>&nbsp;</td>
	   </tr>	 
	  <tr>
		  <td colspan=4 class=label height=5></td>
	  </tr>
  </table>
  </div>
 <!-- <a name="empyr" ></a> 
  <table cellspacing='0' cellpadding='0' width='95%' border=0 align='center'>
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
	<table cellspacing='0' cellpadding='0' width='95%' border=0 align='center'>
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
  </td></tr></table> -->
  <div id = 'EmploymentDetails' style='display:none'>
            <table cellspacing='0' cellpadding='0' width='95%' border= 0 align='center'>
				<tr>
					<td align='center' class='COLUMNHEADER' ><fmt:message key="Common.employerdetails.label" bundle="${common_labels}"/></td>
				   <td align='center' class='COLUMNHEADER' ><fmt:message key="Common.employeedetails.label" bundle="${common_labels}"/></td>
                </tr>

				<tr><td>
						<table cellspacing='0' cellpadding='0' width='95%' border=0 >
							<tr><td colspan=2 class=label height=5></td></tr>
							<!--Below line added for this ML-MMOH-CRF-0860.2-->
							<tr> 
					              <td class='label'   width='50%' ><fmt:message key="Common.orgName.label" bundle="${common_labels}"/></td>
								  <td class='fields' width='50%' ><input type='text' name='organization_name' id='organization_name' maxlength='<%=maximumLength%>'  
								  size='<%=maxsize%>' onblur='makeValidString(this);'  value ="<%=contact3_org_name%>"></input>
								  </td>	
							</tr>
							<!--End this ML-MMOH-CRF-0860.2-->
							<tr>  
								  <td class='label'  width='50%' ><fmt:message key="eMP.ContactPersonName.label" bundle="${mp_labels}"/></td>
								  <td class='fields' width='50%' > <input type='text' name='empyr_contact_name' id='empyr_contact_name' maxlength='30' size='30'  onblur='makeValidString(this);' value = "<%=employer_name%>" ></input>
								  </td>
							</tr>
						
							<%
								out.println("<tr>") ; 
								StringBuffer sb9 = new StringBuffer() ;
								StringBuffer  sb19 = new StringBuffer() ;
								StringBuffer sba9 = new StringBuffer() ;
								StringBuffer sbar9 = new StringBuffer() ;
								StringBuffer fieldVal9 = new StringBuffer("");
								for(int i=0;i<contact_col_names.length; i++)  {     
									out.println("<td class='label'   width='40%' >"+contact_prompts[i]+"</td>") ;	
	                                String val = contact_fields[i] ;
									sb9.append(val);
									int j=0 ;
									int j1=0;
                                    String old_val = "" ;
                                    String new_val = "" ;
									if(contact_col_names[i].equalsIgnoreCase("addr_line1_prompt")) {
										old_val = "r_addr_line1" ;
                                        new_val = "employ_addr_line1" ;
							        } 
									else  if(contact_col_names[i].equalsIgnoreCase("addr_line2_prompt")) {
										old_val = "r_addr_line2" ;
                                        new_val = "employ_addr_line2" ;
									}
                                    else if(contact_col_names[i].equalsIgnoreCase("addr_line3_prompt")) {
										old_val = "r_addr_line3" ;
                                        new_val = "employ_addr_line3" ;
                                    }
                                    else if(contact_col_names[i].equalsIgnoreCase("addr_line4_prompt")) {
                                        old_val = "r_addr_line4" ;
                                        new_val = "employ_addr_line4" ;
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("res_town_prompt"))
                                     {
                                        old_val = "r_town_code" ;
                                        new_val = "contact3_res_town_code" ;
                                     } 
									 else if(contact_col_names[i].equalsIgnoreCase("region_prompt"))
                                     {
                                        old_val = "r_region_code" ;
                                        new_val = "contact3_region_code" ;
                                     }
									 else if(contact_col_names[i].equalsIgnoreCase("res_area_prompt"))
                                     {
                                        old_val = "r_area_code" ;
                                        new_val = "contact3_res_area_code" ;
                                     }                                     
                                     else if(contact_col_names[i].equalsIgnoreCase("postal_code_prompt"))
                                     {
                                        old_val = "r_postal_code" ;
                                        new_val = "employ_postal_code" ;
                                     }
                                    while(val.indexOf(old_val) != -1)
                                    {
							             j = val.indexOf(old_val,j) ;
							            sb9 = sb9.replace(j,(j+old_val.length()),new_val);
							            val = sb9.toString();
                                    }
					// Newly added
					if(contact_col_names[i].equalsIgnoreCase("res_town_prompt")) {
						sba9.append(val);
						while(val.indexOf("r_postal_code") != -1) {
							j1 = val.indexOf("r_postal_code",j1) ;
							sba9 = sba9.replace(j1,(j1+"r_postal_code".length()),"employ_postal_code");
							val = sba9.toString();
						}
					}
					if(contact_col_names[i].equalsIgnoreCase("res_area_prompt")) {
						j1 = 0;
						sbar9.append(val);
						while(val.indexOf("r_postal_code") != -1) {
							j1 = val.indexOf("r_postal_code",j1) ;
							sbar9 = sbar9.replace(j1,(j1+"r_postal_code".length()),"employ_postal_code");
							val = sbar9.toString();
						}
					}


                                sb19.append(val);
								for(int z=0;z<val.length();z++)
									{
										String tempVal=sb19.substring(z,z+1);
										if(tempVal.equals("@"))
										{
											fieldVal9.append(++tindex);
										}
										else
										{
											fieldVal9.append(tempVal);
										}
									}
                                    val = fieldVal9.toString();
									out.println("<td class='fields' >"+val+"</td>") ;
						   out.println("</tr>") ;
						   sb19.delete(0,sb19.length());
							fieldVal9.delete(0,fieldVal9.length());
						   sb9.delete(0,sb9.length());
						   sba9.delete(0,sba9.length());
						   sbar9.delete(0,sbar9.length());
                            }
							 
				%> 
				 <script>
				        // Added on 7/05/2004 for assigning values to dynamically generated address related fields..
						if(document.forms[0].employ_addr_line1)
						   document.forms[0].employ_addr_line1.value = "<%=addr3_line1%>" ;
						if(document.forms[0].employ_addr_line2)
						   document.forms[0].employ_addr_line2.value = "<%=addr3_line2%>" ;
						if(document.forms[0].employ_addr_line3)
						   document.forms[0].employ_addr_line3.value = "<%=addr3_line3%>" ;
						if(document.forms[0].employ_addr_line4)
						   document.forms[0].employ_addr_line4.value = "<%=addr3_line4%>" ;
						if(document.forms[0].contact3_res_town_code)
						{
						 document.forms[0].contact3_res_town_code.value = "<%=contact3_res_town_desc%>";
						 document.forms[0].e_town.value = "<%=contact3_town_code%>";
						}
						if(document.forms[0].contact3_region_code)
						{
					     document.forms[0].contact3_region_code.value = "<%=contact3_region_desc%>";
						 document.forms[0].e_region.value = "<%=contact3_reg_code%>"; 	
                        }
						if(document.forms[0].contact3_res_area_code)
						{

						document.forms[0].contact3_res_area_code.value = "<%=contact3_res_area_desc%>";
						document.forms[0].e_area.value = "<%=contact3_area_code%>"; 
						}
						if(document.forms[0].employ_postal_code1){
						   document.forms[0].employ_postal_code.value = "<%=postal3_code%>";
						   document.forms[0].employ_postal_code1.value = "<%=postal3_desc%>";
						}

       						// End of addition on 7/05/2004 for assigning values to dynamically generated address related fields..
						 </script>	
                <tr>
                    <td  class='label' width='50%'><fmt:message key="Common.country.label" bundle="${common_labels}"/></td>

                    <td class='fields' width='50%'>
						    <input align='left' type='text' name='empyr_country_desc' id='empyr_country_desc'                       size='15' maxlength='15' onblur='if(this.value !="")searchCountry(contry_code[0],empyr_country_desc);' value = "<%=country3_code_desc%>" ><input type='button' name='contry_code' id='contry_code' value='?' class='button' onclick='searchCountry(this,empyr_country_desc)' >
							<input type='hidden' name='empyr_country_code' id='empyr_country_code' value=''>
							<script>
							   if(document.forms[0].empyr_country_code)
							     document.forms[0].empyr_country_code.value = "<%=country3_code%>";
							   if(document.forms[0].empyr_country_desc)
							     document.forms[0].empyr_country_desc.value = "<%=country3_code_desc%>";
				           </script>
                   </td>
               </tr>
               <tr>
                   <td  class='label' width='50%'><fmt:message key="Common.homephoneno.label" bundle="${common_labels}"/></td>
                   <td class='fields' width='50%'>
					    <input type='text' name='res3_tel_no' id='res3_tel_no' size='20' maxlength='20'  onblur='makeValidString(this);' value ="<%=res3_tel_no%>" >
                   </td>
               </tr>
			   <tr>
                    <td  class='label' width='50%' nowrap><fmt:message key="Common.officephoneno.label" bundle="${common_labels}"/></td>
                   <td class='fields' width='50%'><input type='text' name='empyr_off_tel_no' id='empyr_off_tel_no' size='20' maxlength='20'  onblur='makeValidString(this);' value ="<%=off3_tel_no%>">
                   </td>
               
               </tr><tr><td colspan=8 class=label height=5></td></tr>
			   </table>
				   </td>

				<td valign=top><table cellspacing='1' cellpadding='0' width='95%' border=0>
			   <tr><td colspan=8 class=label height=5></td></tr>
			   <tr><td class='label' ><fmt:message key="Common.employmentid.label" bundle="${common_labels}"/></td>
                   <td class='fields'>
                        <input type='text' name='empyr_eid' id='empyr_eid' maxlength='15' size='15'  onblur='makeValidString(this);' value = "<%=patient_employee_id%>" ></input>
                    </td>
			   </tr>
			   <tr>
					<td class='label'  ><fmt:message key="eMP.OccupationClass.label" bundle="${mp_labels}"/></td>
					<td class='fields'><select name='occ_class' id='occ_class'  onchange='setOccOfPerson();'>
                        <option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option>
						<%
						String occpnC = ocpn_class_code;
                        StringBuffer ocupatCodeBuff = new StringBuffer();
                        
                        ocupatCodeBuff.append("select OCPN_CLASS_CODE,LONG_DESC  from mp_occupation_class_lang_vw where language_id='"+locale+"'  and EFF_STATUS='E' order by 2 ");
                        oth_stmt = con.prepareStatement(ocupatCodeBuff.toString());
						oth_rset = oth_stmt.executeQuery();	
						while(oth_rset.next())
						{
						   String occuDesc = checkForNull(oth_rset.getString("LONG_DESC"));
						   String occuCode = checkForNull(oth_rset.getString("OCPN_CLASS_CODE"));
						   if(occpnC.equals(occuCode))
								sel = "selected";
						   else
								sel="";
				    	   out.println("<option value=\""+occuCode+"\" "+sel+">"+occuDesc+"</option>");
						}
                        while(oth_rset.next())
						{
						   out.println("<Option value=\"" + oth_rset.getString("OCPN_CLASS_CODE") + "\">" + oth_rset.getString("LONG_DESC")+"</option>");
						}
					   if(oth_rset!= null) oth_rset.close() ;
					   if(oth_stmt!= null) oth_stmt.close() ;
					   if((ocupatCodeBuff != null) && (ocupatCodeBuff.length() > 0))
						{
							ocupatCodeBuff.delete(0,ocupatCodeBuff.length());
						} 
						%>
                        </select></td>
						</tr>
				<tr>
			        <td class='label' ><fmt:message key="eMP.OccupationofthePerson.label" bundle="${mp_labels}"/></td>
                    <td class='fields'>
                        <select name='occ_of_per' id='occ_of_per' onChange= "enableocpn();"   >
                            <option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option>
							<%
						StringBuffer ocupatCodeBuff1 = new StringBuffer();
						
                        ocupatCodeBuff1.append("select ocpn_code,SHORT_DESC from mp_occupation_lang_vw where language_id='"+locale+"' and EFF_STATUS='E' order by 2");
						String occ_of_per = ocpn_code;
                        oth_stmt = con.prepareStatement(ocupatCodeBuff1.toString());
						oth_rset = oth_stmt.executeQuery();	
						while(oth_rset.next())
						{
						   String occuDesc1 = oth_rset.getString("SHORT_DESC");
						   String occuCode1 = oth_rset.getString("ocpn_code");
						   if(occ_of_per.equals(occuCode1))
								sel = "selected";
						   else
								sel="";
				    	   out.println("<option value=\""+occuCode1+"\" "+sel+">"+occuDesc1+"</option>");
						}
						 while(oth_rset.next())
						{
						   out.println("<Option value=\"" + oth_rset.getString("ocpn_code") + "\">" + oth_rset.getString("Short_Desc")+"</option>");
						}
                           if(oth_rset!= null) oth_rset.close() ;
						   if(oth_stmt!= null) oth_stmt.close() ;
						   if((ocupatCodeBuff1 != null) && (ocupatCodeBuff1.length() > 0))
							{
								ocupatCodeBuff1.delete(0,ocupatCodeBuff1.length());
							} 
						%>
						 </select>&nbsp;&nbsp;<input type='text' name='occu_of_per_desc' id='occu_of_per_desc' size='<%=maxsize%>' maxlength='<%=maximumLength%>' onblur=''  onblur='makeValidString(this);' value="<%=ocpn_desc%>"></td>
			        </tr>
					<!--Above line added for ML-MMOH-CRF-0860.2-->
			    <tr>
				    <td class='label' ><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
                    <td class='fields'>
                        <select name='empyr_employment_status' id='empyr_employment_status'  onchange=''>
						<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------&nbsp;&nbsp;&nbsp;</option>
						<% String emp_stat_code =employment_status;
					       String emp_stat_desc = "";
					      if (emp_stat_code.equals("FE"))
		                  	   emp_stat_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.FullTimeEmployed.label","mp_labels");
                          else if  (emp_stat_code.equals("FS"))
							   emp_stat_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.FullTimeStudent.label","mp_labels");
						  else if  (emp_stat_code.equals("NA"))
							   emp_stat_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");
						  else if  (emp_stat_code.equals("PE"))
							   emp_stat_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PartTimeEmployed.label","mp_labels");
    					  else if  (emp_stat_code.equals("PS"))
							   emp_stat_desc =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PartTimeStudent.label","mp_labels");
						  else if  (emp_stat_code.equals("SE"))
							   emp_stat_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.SelfEmployed.label","mp_labels");
						  else if  (emp_stat_code.equals("UE"))
							   emp_stat_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Unemployed.label","mp_labels");
						  else if  (emp_stat_code.equals("UK"))
							   emp_stat_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
						  if (employment_status != ""){
                          %>
						  <option value="<%=employment_status%>" selected><%=emp_stat_desc%></option>
                         <%}%>
                            <option value='FE'><fmt:message key="eMP.FullTimeEmployed.label" bundle="${mp_labels}"/></option>
								<option value='FS'><fmt:message key="eMP.FullTimeStudent.label" bundle="${mp_labels}"/></option>
								<option value='NA'><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>					
								<option value='PE'><fmt:message key="eMP.PartTimeEmployed.label" bundle="${mp_labels}"/></option>
								<option value='PS'><fmt:message key="eMP.PartTimeStudent.label" bundle="${mp_labels}"/></option>
								<option value='SE'><fmt:message key="eMP.SelfEmployed.label" bundle="${mp_labels}"/></option>
								<option value='UE'><fmt:message key="eMP.Unemployed.label" bundle="${mp_labels}"/></option>
								<option value='UK'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
                        </select>	
			</td>
			</tr> 
		</table></table>
		
		  <input type='hidden' name='open_to_all_pract_yn' id='open_to_all_pract_yn' value="">
   		  <input type='hidden' name='patient_id' id='patient_id' value="<%=patient_id%>">
   		  <input type='hidden' name='function_name' id='function_name' value="<%=function_name%>">
		  <input type='hidden' name='location_code' id='location_code' value="<%=assign_care_locn_code%>">
          <input type='hidden' name='visit_type_code' id='visit_type_code' value="<%=visit_type_code%>">
		  <input type='hidden' name='service_code' id='service_code' value="<%=service_code%>">
		  <input type='hidden' name='speciality_code' id='speciality_code' value="<%=speciality_code%>">
 		  <input type='hidden' name='encounter_id' id='encounter_id' value="<%=encounter_id%>">
   		  <input type='hidden' name='mode' id='mode' value='ReviseVisit'>
		  <input type='hidden' name='start_date' id='start_date' value="<%=start_date%>">
          <input type='hidden' name='oper_stn_id' id='oper_stn_id' value="<%=oper_stn_id%>">
		  <input type='hidden' name='sysDateWithoutTime' id='sysDateWithoutTime' value="<%=sysDateWithoutTime%>">
		 <input type='hidden' name='params' id='params' value="<%=params%>">
		 <input type='hidden' name='resorce_type' id='resorce_type' value=''>
          <input type='hidden' name='accident_type_val' id='accident_type_val' value="">
          <input type='hidden' name='rta_val' id='rta_val' value="">
		  <input type='hidden' name='mlc_details_val' id='mlc_details_val' value="<%=ecis.utils.HTMLUtilities.getDisplayString(medico_legal_details)%>">
		 
   		  <input type='hidden' name='accident_type_val' id='accident_type_val' value=''>		     
   		  <input type='hidden' name='sys_date' id='sys_date' value="<%=sysDateWithoutTime%>">		     
		  <input type='hidden' name='vaccinated_yn' id='vaccinated_yn' value=''>		     
		  <input type='hidden' name='heightVal' id='heightVal' value="<%=heightVal%>">
		  <input type='hidden' name='weightVal' id='weightVal' value="<%=weightVal%>">
		  <input type='hidden' name='circumVal' id='circumVal' value="<%=circumVal%>">
		  <input type='hidden' name='paediatric_yn' id='paediatric_yn' value="<%=paediatric_yn%>">
   		  <input type='hidden' name='gynaec_yn' id='gynaec_yn' value="<%=gynaec_yn%>">



			<input type='hidden' name='nat_id_check_digit_id' id='nat_id_check_digit_id' value='<%= nat_id_check_digit_id%>'>
			<input type='hidden' name='nat_id_chk_len' id='nat_id_chk_len' value='<%= nat_id_chk_len%>'>
			<input type='hidden' name='nat_id_prompt' id='nat_id_prompt' value='<%= nat_id_prompt%>'>
			<input type="hidden" name="isAENextofKinchngAppl" id="isAENextofKinchngAppl" value="<%=isAENextofKinchngAppl%>"> <!-- added by mujafar for ML-MMOH-CRF-0632 -->
			<input type='hidden' name='nat_id_accept_alphanumeric_yn' id='nat_id_accept_alphanumeric_yn' value="<%=nat_id_accept_alphanumeric_yn%>">
			<!--Added by Thamizh selvi on 7th Aug 2018 against ML-MMOH-CRF-1177 Start-->
			<input type="hidden" name='isAutoPopulateNOKDOBAppl' id='isAutoPopulateNOKDOBAppl' value="<%=isAutoPopulateNOKDOBAppl%>">
			<input type='hidden' name='natInvokeRoutine' id='natInvokeRoutine' value='<%=natInvokeRoutine%>'>
			<input type='hidden' name='natDataSourceId' id='natDataSourceId' value='<%=natDataSourceId%>'>
			<!--End-->
		 </div>
	 </form>
	 </body>
<%
	}catch(Exception e)
    {
        out.print(e.toString());
		e.printStackTrace();
    }
    finally
    {
	    ConnectionManager.returnConnection(con,request);
    }
%>
<%!
	// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equals(""))) ? "" : inputString );
	}
%>
</html>	

