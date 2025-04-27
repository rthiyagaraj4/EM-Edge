<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*,java.lang.Math.*, java.text.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat,com.ehis.util.*,org.json.simple.parser.JSONParser,org.json.simple.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>   
  <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
  <link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
  <link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
  <script language='javascript' src='../../eCommon/js/common.js'></script>
  <Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
  <script language='javascript' src='../../eCommon/js/dchk.js'></script>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
  <script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
  <script language='javascript' src='../../eAE/js/AESecondaryTriage.js'></script>
  <script language='javascript' src='../../eCommon/js/CommonLookup.js' > </script>
 <script language='javascript' src='../../eCommon/js/DateUtils.js'> </script> 
 <script language='javascript' src='../../eAE/js/AEPractitionerComponent.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 <!--This line added for this CRF  AAKH-CRF-0010 [IN038535] -->
 <script> 
  <%! 
  public String specialCharacter(String single){
				int i=0;
				
				
		if(( single.indexOf('\'', i)!=-1)){
			single=(String)single.replace('\'',' ');
		}
	

		return single ; 
			
			}	

%>
function agecheck(obj,ca_install,patage,max,min,sex)
{	
	if(ca_install=="Y")
	{
		if(obj.name=="circumference")
		{
			if((trimCheck(min) <= patage) && sex =="F")
			{
			}else
			{
			   AEScrollIntoView();
			}
		}else{
		if(patage <= max)
		{
		}else if((trimCheck(min) <= patage) && sex =="F")
		{
		}else
		{
			AEScrollIntoView();
		}
	  }
	}
}

/*
  function tab_click(objName)
	{
	
		   if(objName=="Triage_tab")
			{
				document.getElementById('tab1').scrollIntoView();
			}
			if(objName=="assess_tab")
			{
				document.getElementById('tabCA').scrollIntoView();
				showCAChart();
			}
	}

	function tab_click1(id) 
		{
			selectTab(id);
			tab_click(id);
		}

		function tab_click2(id,idval){
		
				selectTab(idval);
				tab_click22(idval);
		} 

		function tab_click22(Object)
		{
					
			if(Object=='patCond_tab')
			{
				 document.getElementById('tab1').scrollIntoView();
			}
			if(Object=='others_tab')
			{
				   document.getElementById('sub2').scrollIntoView();
			}
		}

*/
				function expandCollapse(calledFrom) {	
					/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 6th 2014 Start*/
					var five_level_triage_appl_yn	= "N";
					var function_id	= document.forms[0].function_id.value;
					var modify_flag	= document.forms[0].modify_flag.value;
					if(document.getElementById("five_level_triage_appl_yn")!=null){
						five_level_triage_appl_yn	= document.getElementById("five_level_triage_appl_yn").value; 
					}
					if(modify_flag!='Y'){
						parent.TriageButtonsFrame.document.SecondaryTriageButtonsForm.Record.disabled = false;
					}
					/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 6th 2014 End*/

					if(calledFrom == 'Triage_Details_tab') {

						document.getElementById('Triage_Details').style.display = 'inline';
						document.getElementById('Assessment').style.display = 'none';									
						document.getElementById('Others').style.display = 'none';
						
					} else if(calledFrom == 'Assessment_tab') {
						if(modify_flag!='Y' && five_level_triage_appl_yn=='Y')
							parent.TriageButtonsFrame.document.SecondaryTriageButtonsForm.Record.disabled = true;
						////Commented by Dharma against HSA-SCF-0273 [IN:056357] on Aug 5th 2015 Start
						/*document.getElementById("Triage_Details").style.display = 'none';
						document.getElementById("Assessment").style.display = 'inline';					
					    document.getElementById("Others").style.display = 'none';*/
						////Commented by Dharma against HSA-SCF-0273 [IN:056357]  on Aug 5th 2015 End

					    /*Below Condition For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 6th 2014 Start*/ 

					    /*Modified By Dharma against AAKH-SCF-0247 [IN:058739] on Dec 28th 2015 Start*/

						/*if(five_level_triage_appl_yn!="Y" || function_id=='query')
					   		showCAChart();*/
						if(five_level_triage_appl_yn!="Y" || function_id=='query'){
					   		showCAChart();					  
						}else{
							document.getElementById('Triage_Details').style.display = 'none';
							document.getElementById('Assessment').style.display = 'inline';					
							document.getElementById('Others').style.display = 'none';
						}
					    /*Modified By Dharma against AAKH-SCF-0247 [IN:058739] on Dec 28th 201 End*/ 
					} else if(calledFrom == 'Condition_tab') {

						document.getElementById('Triage_Details').style.display = 'inline';
						document.getElementById('Assessment').style.display = 'none';								
						document.getElementById('Others').style.display = 'none';						
					
					} else if(calledFrom == 'others_tab') {

						document.getElementById('Triage_Details').style.display = 'none';
						document.getElementById('Assessment').style.display = 'none';								
						document.getElementById('Others').style.display = 'inline';						
					} 
					/*Added by Thamizh selvi on 10th Apr 2018 against ML-MMOH-CRF-0655 Start*/
					else if(calledFrom == 'allergy_dtls'){
						recAllergyDet();

						document.getElementById('Triage_Details').style.display = 'inline';
						document.getElementById('Assessment').style.display = 'none';								
						document.getElementById('Others').style.display = 'none';	
					}/*End*/
				}
	
	</Script>
</head>
<%
Connection con				      = null;  
PreparedStatement pstmt		      = null;
ResultSet rset				      = null;
PreparedStatement pstmt1	      = null;
ResultSet rset1				      = null;
PreparedStatement pstmt_date	  = null;
ResultSet rs_date			      = null;
PreparedStatement pstmtEncounter  = null; 
ResultSet rsetEncounter			  = null;
ResultSet rsetCA		  = null;
PreparedStatement pstmtCA	      = null;
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");

String locale			= (String)session.getAttribute("LOCALE");

String bed_no = "";
String dis_regn_ref = "";
/** for Other Details Tab Added on 04/02/2005 **/
String ca_install_yn = "";
String ECGProp			="";
String FBCProp		    ="";
String DressProp        ="";
String SpO2Prop 		="";
String capBloodSugProp  ="";
String order_catalog_code1  ="";
String order_catalog_code2  ="";
String order_catalog_code3  ="";
String order_catalog_code4  ="";
String order_catalog_code5  ="";
String order_catalog_code6  ="";
String fbccheck  ="";
String fbccheck_val  ="";
String modifyYN  = "Y";
/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 28th 2014*/
String priority_zone_code	= "";
String priority_zone_desc	= "";
String priority_zone_color	= "";
String priority_zone_order	= "";
String priority_zone_hidden_fileds	= "";
String patient_class		= "";
/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 28th 2014*/
int countECG =0;
int countDerss=0;
int countSpO2=0;
int countCapBlood=0;
String facilityId			= (String)session.getValue("facility_id");
String loginUser			= checkForNull((String)session.getValue("login_user"));
String patient_id			= request.getParameter("patient_id");

String fbc_yn			= request.getParameter("fbc_yn")==null?"N":request.getParameter("fbc_yn"); 

/*Below line added for this CRF AAKH-CRF-0010 [IN038535]*/
String open_to_all_pract_yn=checkForNull(request.getParameter("open_to_all_pract_yn"));
String open_to_all_prac_for_clinic_yn=checkForNull(request.getParameter("open_to_all_prac_for_clinic_yn"));
//End AAKH-CRF-0010 [IN038535]

	if(fbc_yn.equals("Y")) {
		fbccheck="Checked";
		fbccheck_val="Y";
	} else {
		fbccheck="";
		fbccheck_val="N";
	}
// for Frame reference changes
String called_from_ca = request.getParameter("called_from_ca");
if((called_from_ca==null) || (called_from_ca.equals("null")) || (called_from_ca=="") || (called_from_ca.equals("")))
	called_from_ca= "N";
String query_string = checkForNull(request.getParameter("query_string"));
String params		 = request.getQueryString() ;




StringBuffer sbBuff = null;
sbBuff = new StringBuffer();
String clinic_code			= request.getParameter("clinic_code")==null?"":request.getParameter("clinic_code"); 
String priority			    = checkForNull(request.getParameter("priority_zone"));
String brought_dead			=  checkForNull(request.getParameter("brought_dead"));
String rec_date_time		= checkForNull(request.getParameter("rec_date_time"));
//Below condtion added for this [IN:051341]
if(rec_date_time.equals("null")) rec_date_time="";

String encounter_id			= checkForNull(request.getParameter("encounter_id"));
String sys_date_time        = checkForNull(request.getParameter("sys_date_time"));
String sys_date_time1        = checkForNull(request.getParameter("sys_date_time1"));
String treat_code			= checkForNull(request.getParameter("treatment_area_code"));
String patient_gender       = checkForNull(request.getParameter("patient_gender"));
String practitioner_id      = checkForNull(request.getParameter("practitioner_id"));
String speciality_code      = checkForNull(request.getParameter("speciality_code"));
String modify_flag			= request.getParameter("modify_flag")==null?"N":request.getParameter("modify_flag"); 
String function_id = checkForNull(request.getParameter("function_id"));
String year_value1			= request.getParameter("year_value")==null?"":request.getParameter("year_value"); 
String year_value		="";
String min_age_for_lmp				="";
String heightDesc				= "";
String weightDesc				= "";
String circumDesc				= "";
String sex						= "";
String date_of_birth			= "";
String menstrual_status			= "false";
String pediatric_status			= "false";
String disabled					= "disabled";
String visit_date				= "";
String priorityStatus1			= "";
String priorityStatus2			= "";
String priorityStatus3			= "";
String priority_no				= "4";
String a_status				    = "";
String complaint_code           = "";
String complaint                = "";
String disaster_yn				= "";
String medical_yn               = "";
String surgical_yn				= "";
String checkedSur               = "";
String checkedMed               = "";
String mech_injr_code			= "";
String mech_injr_subcat_code	= "";
String checked1					= "";
String checked2					= "";
String checked3					= "";
String checked4					= "";
String checked5					= "";
String checked6					= "";
String checked7					= "";
String checked8					= "";
String checked9					= "";
String optSelected				= "";
String vehicle_invlovedcode		= "";
String vehicle_invlovedcode1	= "";
//Added by Ashwini on 04-Apr-2017 for GDOH-CFR-0004.3
String Vehicle_Reg_No1			= "";
String Vehicle_Reg_No2			= "";
String protective_device_code	= "";
String pat_position_code		= "";
String oscc_yn					= "";
String mlc_yn					= "";
//String mlc_case_yn					= "";
String police_rep_no			= "";
String police_station_dtls		= "";
String  immunization_status		= "";
String selected					= "";
String selected1				= "";
String selected2				= "";
String att_given				= "";
String dev_mile_stone			= "";
String imm_date					= "";
String circumference			= "";
String height					= "";
String weight					= "";
String  menarche_yn				= "";
String disaster_town_code		= "";
String lmp_date					= "";
String disPriority				= "";
String disTreatArea				= "";
String pregnant_yn				= "";
String disabled11				= "";
String mech_injury_subcatg_code	= "";
String disable3					= "";
String disabled111				= "";
String disabled12				= "";
String disabled13				= "";
String sqlDate					= "";
String disabled99				= "";
String disabled991				= "";
String disabledPre				= "";
String disMenarche				= "";
String disBed					= "";
String disBed1					= "";
String disDisaster				= "";
String pat_priority             = ""; 
String trauma_yn                = ""; 
String dis_area                 = "";
String dis1						= "";
String dis2						= "";
String dis3					    = "";
String dis5					    = "";
String dis6					    = "";
String dis7					    = "";
String dis8					    = "";
String dis9					    = "";
String dis10					= "";
String dis11				    = "";
String dis12				    = "";
String dis13				    = "";
String dis14				    = "";
String dis15				    = "";
String disHeight				= "";
String disWeight				= "";
String disCir				    = "";
String disImm					= "";
String triage_remarks           = "";
String disMed					= "";
String disSur					= "";
String disOscc					= "";
String disMLC					= "";
String optSelectedTreat			= "";
String immobilization			= "";
String disImmobil				= "";
String disaster_type_code       = "";
String sys_date                 = "";
String priority_code            = "";
String episode_id               = "";
String visit_num                = "";
String pat_dtls_unknown_yn      = "";
String referral_id				= "";
String disRefID                 = "";
//String speciality_code          = "";
String date_time_of_accident    = "";
String place_of_accident        = "";
String disDateAcci				= "";
String disPlaceAcci				= "";
String enable_rights_yn="";
String sel_triage_yn="";
String sel_cons_yn="";

/*--Added by k v shanmukh on 2nd-Apr-2018 against ML-MMOH-CRF-0656 Start-->*/

String dis_triage_record_date_time="";
String display_triage_record_date_time="";

/*END*/

//Added By Shanmukh for MMS-DM-CRF-0147
String sql2="";
Boolean isPriorityZoneAppl			= false;

/* below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] */
String color                  ="";
String  sql                   ="";
String  green                 ="";
String  red                   ="";
String  yellow                ="";


/* CRF  SKR-CRF-0021 [IN028173] end  */


int  patient_age				= 0;
int min_age_pregnancy			= 0;
int nb_mother_min_age           = 0;
int min_age_pregnancy1			= 0;
int max_age_paediatric			= 0;
int	 tindex                     = 0;
 int minageforlmp=0;
 int yearvalue=0;
 int ca_encntr_cnt = 0;

// Tuesday, May 04, 2010 PE_EXE venkat s

String dis_yn="";
String dis_town_code="";
String dis_type_code="";
String dis_complaint_code="";


/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 28th 2014 Start*/
String prioritynewdisabled		= ""; 
String priority_selected		= "";
String five_level_triage_appl_yn	= "N";
String ca_chart_rec_status			= "";
String clinical_notes_status		= "";
String sys_date_qry					= "";
/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 28th 2014 End*/

/*Below line added for this CRF AAKH-CRF-0010 [IN038535] Senthil*/
String leveloftriage_visibility = "visibility:hidden";
String attend_practitioner_id="",attend_practitioner_name="";
String dis16				    = "";

//End AAKH-CRF-0010

//Below line added for this CRF ML-MMOH-CRF-0654
Boolean modeofarrival=false;
String transport_mode_code="",arrival_code="",accompanied_by_code="";
String accompanied_by_dis = "";
//End ML-MMOH-CRF-0654

/*Added by Thamizh selvi on 8th Mar 2018 against ML-MMOH-CRF-645 Start*/
Boolean isCaseDtlsRadioBtnAppl	= false;
String OandGYn					= "N";
String disOandGYn				= "";
String checkedOandGYn			= "";
/*End*/

Boolean isMechInjLabelChngAppl	= false;//Added by Thamizh selvi on 29th Mar 2018 against ML-MMOH-CRF-649

//Added by Ashwini on 18-Jan-2021 for ML-MMOH-CRF-1409
Boolean isReconfirmCOTAppl = false;
String reconf_cot_param = "";

/*Added by Thamizh selvi on 9th Apr 2018 against ML-MMOH-CRF-0655 Start*/
Boolean isChngBtnPositionAppl = false;
int countRecEnc				=  0;
double prev_visit_hrs		= 0d;
String EncounterProp	= "";
String VisitProp		= "";
/*End*/

/*Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651 Start*/
Boolean isOrderCatalogChngAppl	= false;
String orderCatalogCode6		= "";
String cbdProp					= "";
String initialMgmtLblName		= "";
String dressingLblName			= "";
String medication				= "";
String intialMgmtOthers			= "";
String disIntialMgmtOthers		= "";
String disMedication			= "";
int countCBD					= 0;
/*End*/

/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
String called_from	= checkForNull(request.getParameter("called_from"));
String RepDb		= checkForNull(request.getParameter("RepDb"));
if(called_from.equals("CDR"))
	facilityId	= checkForNull(request.getParameter("facility_id"));
String sqlFinal		= "";
/*End*/

Boolean isMLCAppl = false;//Added by Ajay Hatwate for GHL-CRF-0650 on 12/07/2023
String mlcQuery = "";
String disMLCDeath ="disabled";
String disOutMLCDet = "disabled";
String disDateOfCapt = "disabled";
String disMLCRemark = "disabled";
String MLC_REMARKS="";
String MLC_NO_OUTSIDE_DTLS="";
String MLC_DEATH_YN ="";
String MLC_CAPTURE_DATE ="";
String pol_rep_no_mx_size = "20";
String pol_stn_det_mx_size = "30";
String visit_date_time = "";
//Added by Ajay Hatwate for ML-MMOH-CRf-1653
String caseTypeYn = "", caseTypeMandYn = "", caseType = "", caseTypeDisable = "";
//Added by Ajay Hawtate for ML-MMOH-CRF-2103
String tickMlcOnOsccChecked = "", disaster_category_yn = "";//Added by Ajay Hatwate for ML-MMOH-CRf-2111
		
// Added by Ajay Hatwate for ML-MMOH-CRF-2069
boolean isSecondaryTriageQueueNum = false;
String queue_secondary_triage = "", queue_appl_priority_zone = "" , queue_num_mandatory = "", queue_max_num_allowed = "", dis_queue_no = "disabled", queue_no = "";


try
 {
        con = ConnectionManager.getConnection(request);	
		/*Below line(s) added by venkateshs against ML-MMOH-CRF-0354 [IN057191] */
		boolean siteSpecific		=eCommon.Common.CommonBean.isSiteSpecific(con, "MR","MLC_TO_MEDICO_LEGAL_CASE"); 
		/*end ML-MMOH-CRF-0354 [IN057191] */
		/*Below query modified for this CRF AAKH-CRF-0010 [IN038535]*/
		Boolean isLabelChngAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AE","LABEL_CHG_BR_DEAD_PLACE_ACCDNT"); //Added by Ashwini on 18-Jan-2017 for GDOH-CRF-0131
		/*Below query modified for this CRF ML-MMOH-CRF-0644 [IN:062162]*/
		boolean allowSplChar =eCommon.Common.CommonBean.isSiteSpecific(con, "AE","ALLOW_SPLCHAR_DISASTERREF");  
		//Added by Mano on 20-jan-2017 for MMOH-CRF-0644
		Boolean isPlaceOfOccuurrence = eCommon.Common.CommonBean.isSiteSpecific(con, "AE","PLACE_OF_OCCURRENCE");  // Added by mujafar for ML-MMOH-CRF-0647
				
		//Below line added for this CRF ML-MMOH-CRF-0654
		 modeofarrival = eCommon.Common.CommonBean.isSiteSpecific(con, "AE","SECONDARY_TRIAGE");  

		 Boolean isReplacePresntngPrblmByChiefComp = eCommon.Common.CommonBean.isSiteSpecific(con, "AE","REPLACE_PRE_PROB_BY_CHF_COMPL"); //Added by Ashwini on 22-May-2017 for ML-MMOH-CRF-0650
		
		isCaseDtlsRadioBtnAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AE","SEC_TRIAGE_CASE_DETAILS");//Added by Thamizh selvi on 8th Mar 2018 against ML-MMOH-CRF-645

		isMechInjLabelChngAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AE","RENAME_MECH_INJ_SUB_INJ");//Added by Thamizh selvi on 29th Mar 2018 against ML-MMOH-CRF-649
		
		Boolean isSecTrgBackDateTimeAppl=eCommon.Common.CommonBean.isSiteSpecific(con, "AE","SEC_TRG_BACK_DATE_APPL");// Added by Shanmukh on 6th-Apr-2018 for ML-MMOH-CRF-0656

		isChngBtnPositionAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AE","DIAGNOSIS_DTLS_IN_24HRS_VISIT");//Added by Thamizh selvi on 9th Apr 2018 against ML-MMOH-CRF-0655

		isOrderCatalogChngAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AE","SEC_TRIAGE_ORDER_CATALOG");//Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651
		
		isPriorityZoneAppl			= eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "PRIORITY_ZONE");//Added By Shanmukh for MMS-DM-CRF-0147

		isMLCAppl 			=eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "MLC_DTLS");//Added by Ajay Hatwate for GHL-CRF-0650
		if(isMLCAppl){
			pol_rep_no_mx_size = "100";
			pol_stn_det_mx_size = "100";
		}
		
		//Added by Ajay Hatwate for ML-MMOH-CRF-2069
		isSecondaryTriageQueueNum = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "SECONDARY_TRIAGE_QNUM");
		
		
		
		//Added by Ashwini on 18-Jan-2021 for ML-MMOH-CRF-1409
		isReconfirmCOTAppl		= eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "RECONFIRM_CASE_OF_TRAUMA");
		JSONObject aeParamJson	= new JSONObject();
		aeParamJson				= eAE.AECommonBean.getAEParam(con, facilityId);
		reconf_cot_param		= (String)aeParamJson.get("reconfirm_case_of_trauma");	
		
		String qry=" SELECT a.min_age_for_lmp,a.enable_accs_rights_in_queue,a.min_age_for_preg_dtl, a.FIVE_LEVEL_TRIAGE_APPL_YN,a.max_age_for_paed_dtl,a.ORDER_CATALOG_CODE1,a.ORDER_CATALOG_CODE2,a.order_catalog_code3,a.ORDER_CATALOG_CODE4,a.ORDER_CATALOG_CODE5,a.ORDER_CATALOG_CODE6,calculate_age(to_char(b.date_of_birth,'dd/mm/yyyy'),1) YEAR,b.sex,to_char(b.date_of_birth, 'dd/mm/yyyy') date_of_birth, b.pat_dtls_unknown_yn, (select install_yn from sm_module ##REPDB## where module_id='CA' ) ca_install_yn, a.DRESSING_LABEL_CONFIG, a.INITIAL_MGMT_LABEL_CONFIG, a.case_type_yn, a.case_type_mand_yn, a.TICK_MLC_IF_OSCC_IS_TICKED_YN, a.ENABLE_DISASTER_CATEG,a.queue_secondary_triage,a.queue_appl_priority_zone,a.queue_num_mandatory,a.queue_max_num_allowed FROM  mp_patient ##REPDB## b,ae_param ##REPDB## a WHERE  b.patient_id =?  and a.operating_facility_id =? ";//Modified by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651
		//Modified above query by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
		
		qry = qry.replaceAll("##REPDB##",RepDb);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
        pstmt			=	con.prepareStatement(qry);
		pstmt.setString	(	2,	facilityId		);
		pstmt.setString	(	1,	patient_id		);
		rset = pstmt.executeQuery();
		
		if(rset!= null &&  rset.next() )
		{
			min_age_for_lmp=rset.getString("min_age_for_lmp")==null?"":rset.getString("min_age_for_lmp");
			enable_rights_yn		= rset.getString("enable_accs_rights_in_queue")==null?"":rset.getString("enable_accs_rights_in_queue");
			year_value=rset.getString("YEAR")==null?"":rset.getString("YEAR");
			min_age_pregnancy1 = rset.getInt("min_age_for_preg_dtl");
			
			/*Below line added for this CRF AAKH-CRF-0010 [IN038535]*/
			five_level_triage_appl_yn		= rset.getString("FIVE_LEVEL_TRIAGE_APPL_YN")==null?"N":rset.getString("FIVE_LEVEL_TRIAGE_APPL_YN");
			if(five_level_triage_appl_yn.equals("Y"))leveloftriage_visibility="visibility:visible";
			
			max_age_paediatric = rset.getInt("max_age_for_paed_dtl");
			order_catalog_code1 = checkForNull(rset.getString("ORDER_CATALOG_CODE1"));	
			order_catalog_code2 = checkForNull(rset.getString("ORDER_CATALOG_CODE2"));	
			order_catalog_code3  = checkForNull(rset.getString("order_catalog_code3"));
			order_catalog_code4 = checkForNull(rset.getString("ORDER_CATALOG_CODE4"));	
			order_catalog_code5 = checkForNull(rset.getString("ORDER_CATALOG_CODE5"));	
			order_catalog_code6 = checkForNull(rset.getString("ORDER_CATALOG_CODE6"));	
			patient_age = rset.getInt("YEAR");
			sex	=  rset.getString("sex")==null?"":rset.getString("sex");
			date_of_birth = rset.getString("date_of_birth");
			pat_dtls_unknown_yn = rset.getString("pat_dtls_unknown_yn");			
			ca_install_yn = rset.getString("ca_install_yn");			
			/*Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651 Start*/
			dressingLblName		= checkForNull(rset.getString("DRESSING_LABEL_CONFIG"));			
			initialMgmtLblName	= checkForNull(rset.getString("INITIAL_MGMT_LABEL_CONFIG"));	
			/*End*/
			caseTypeYn 			= checkForNull(rset.getString("case_type_yn"));
			caseTypeMandYn 			= checkForNull(rset.getString("case_type_mand_yn"));
			tickMlcOnOsccChecked 	= rset.getString("TICK_MLC_IF_OSCC_IS_TICKED_YN")==null?"Y":rset.getString("TICK_MLC_IF_OSCC_IS_TICKED_YN");
			disaster_category_yn = rset.getString("ENABLE_DISASTER_CATEG")==null?"N":rset.getString("ENABLE_DISASTER_CATEG");//Added by Ajay Hatwate for ML-MMOH-CRf-2111
			
			//Added by Ajay Hatwate for ML-MMOH-CRF-2069 on 08/07/2024
			
		  	queue_secondary_triage = rset.getString("queue_secondary_triage")==null?"N":rset.getString("queue_secondary_triage");
			queue_appl_priority_zone = rset.getString("queue_appl_priority_zone")==null?"N":rset.getString("queue_appl_priority_zone");
			queue_num_mandatory = rset.getString("queue_num_mandatory")==null?"N":rset.getString("queue_num_mandatory");
			queue_max_num_allowed = rset.getString("queue_max_num_allowed")==null?"N":rset.getString("queue_max_num_allowed");

			//System.out.println(five_level_triage_appl_yn + " : five_level_triage_appl_yn " +queue_secondary_triage + " : queue_secondary_triage " + queue_appl_priority_zone + " : queue_appl_priority_zone " + queue_num_mandatory + " : queue_num_mandatory " + queue_max_num_allowed + " : queue_max_num_allowed"  );
			
			
			//End of ML-MMOH-CRF-2069
		} 
		/*Below Condition Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 28th 2014*/
		if(!five_level_triage_appl_yn.equals("Y")){
		/* below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] */
		    
	        sql="SELECT PRIORITY_ZONE,PRIORITY_ZONE_DESC FROM AE_PRIORITY_ZONE_LANG_VW ##REPDB## WHERE LANGUAGE_ID= ? and EFF_STATUS='E'";//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				
				sql = sql.replaceAll("##REPDB##",RepDb);//Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
			    
				pstmt   = con.prepareStatement(sql.toString());
				pstmt.setString(1,locale) ;
			    rset    = pstmt.executeQuery();
				while(rset!=null && rset.next())
				{
				 color      =rset.getString("PRIORITY_ZONE");
				 if (color.equals("G")) {green=rset.getString("PRIORITY_ZONE_DESC");}
				 if (color.equals("R")){red=rset.getString("PRIORITY_ZONE_DESC");}
				 if (color.equals("Y")){yellow=rset.getString("PRIORITY_ZONE_DESC");}
				}
		    
			
	/* CRF  SKR-CRF-0021 [IN028173] end  */
	
	
		}/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 28th 2014*/
		
		
		
		
		
		  if(rset!=null) rset.close();
		  if(pstmt!=null) pstmt.close();

			String pract_type="";		
			
			if(enable_rights_yn.equals("Y")){
			String pract_sql="select  b.pract_type pract_type from sm_appl_user ##REPDB## a,am_practitioner ##REPDB## b where a.appl_user_id = ? and a.func_role_id = b.practitioner_id";//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
			
			pract_sql = pract_sql.replaceAll("##REPDB##",RepDb);//Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
		
			pstmt=con.prepareStatement(pract_sql);
			pstmt.setString(1,loginUser);
			rset								= pstmt.executeQuery();
			
			if(rset!=null  && rset.next()){
			pract_type =rset.getString("pract_type")==null?"":rset.getString("pract_type");
			}
			if(rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();

			if(!(pract_type.equals(""))){
			String access_rights_sql="select SEC_TRIAG_YN,CONS_YN from AE_ACCS_RIGHTS_BY_PRAC_TYPE ##REPDB## where pract_type =?";//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
			access_rights_sql = access_rights_sql.replaceAll("##REPDB##",RepDb);//Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1

			pstmt=con.prepareStatement(access_rights_sql);
			pstmt.setString	(1,pract_type);
			rset = pstmt.executeQuery();
			if(rset!= null &&  rset.next() ){
				sel_triage_yn=rset.getString("SEC_TRIAG_YN")==null?"":rset.getString("SEC_TRIAG_YN");
				sel_cons_yn=rset.getString("CONS_YN")==null?"":rset.getString("CONS_YN");
			}
			if(rset!=null) rset.close();
			if(pstmt!=null)pstmt.close();
			}
			}

			if(ca_install_yn.equals("Y")) { 	
				//pstmtCA = con.prepareStatement("select count(*) cnt from CA_ENCNTR_DISCR_MSR where FACILITY_ID = '"+facilityId+"' and ENCOUNTER_ID = '"+encounter_id+"' and PATIENT_ID = '"+patient_id+"' and TO_CHAR(TEST_OBSERV_DT_TM,'DD/MM/YYYY HH24:MI') = TO_CHAR(to_date('"+rec_date_time+"','DD/MM/YYYY HH24:MI:SS'),'DD/MM/YYYY HH24:MI')");
				//Commented above line and added below code against MMS-DM-CRF-0115.3
				String caSql = "select count(*) cnt from CA_ENCNTR_DISCR_MSR ##REPDB## where FACILITY_ID = '"+facilityId+"' and ENCOUNTER_ID = '"+encounter_id+"' and PATIENT_ID = '"+patient_id+"' and TO_CHAR(TEST_OBSERV_DT_TM,'DD/MM/YYYY HH24:MI') = TO_CHAR(to_date('"+rec_date_time+"','DD/MM/YYYY HH24:MI:SS'),'DD/MM/YYYY HH24:MI')";
				caSql = caSql.replaceAll("##REPDB##",RepDb);
				pstmtCA = con.prepareStatement(caSql);
				/*End*/
				rsetCA = pstmtCA.executeQuery();
				
				if(rsetCA!=null  && rsetCA.next()) {
					ca_encntr_cnt		= rsetCA.getInt("cnt");
				}
				if(rsetCA!=null) rsetCA.close();
				if(pstmtCA!=null) pstmtCA.close(); 
		     }		

			 if(ca_encntr_cnt>0) {
				modifyYN = "N";
			 }
 try
     { 
		StringBuffer PREncount = new StringBuffer();
		PREncount.append("select to_char(trunc(visit_adm_date_time),'dd/mm/yyyy'),to_char(sysdate,'dd/mm/yyyy hh24:mi') sys,to_char(sysdate,'dd/mm/yyyy hh24:mi:ss') sys1,");
		PREncount.append("EPISODE_ID,OP_EPISODE_VISIT_NUM , ");
		PREncount.append(" to_char(sysdate,'dd/mm/yyyy')  sqlDate,REFERRAL_ID,MLC_YN, ");
		PREncount.append(" to_char(DATE_TIME_OF_ACCIDENT,'dd/mm/yyyy hh24:mi') date_time_of_accident,");
		PREncount.append(" PLACE_OF_ACCIDENT, ");
		PREncount.append(" disaster_yn, disaster_town_code, disaster_type_code,disaster_category_code,complaint_code ");
		PREncount.append(", ATTEND_PRACTITIONER_ID, am_get_desc.am_practitioner ##REPDB##(ATTEND_PRACTITIONER_ID,'"+locale+"',1 ) practitioner_name ");
		//above line added CRF AAKH-CRF-0010 [IN038535]

		/*Added by Rameswar on 28-Nov-15 for GDOH-CRF-0004.1 */
		
		//Below line modified by Ashwini on 04-Apr-2017 for GDOH-CFR-0004.3
		PREncount.append(",VEHICLE_INVOLVED1_CODE,VEHICLE_INVOLVED2_CODE,VEHICLE_REG_NO1,VEHICLE_REG_NO2,PAT_POSITION_CODE");


		/*Added by Rameswar on 04-Oct-16 for GDOH-CRF-0004.2 */
		PREncount.append(",TRAUMA_YN,OSCC_YN,MEDICAL_YN,SURGICAL_YN,MECH_INJURY_CATG_CODE,MECH_INJURY_SUBCATG_CODE,PROTECTIVE_DEVICE_CODE,TRANSPORT_MODE, ARRIVAL_CODE, ACCOMPANIED_BY_CODE, O_AND_G_YN, CASE_TYPE");  //Added by Sangeetha for ML-MMOH-CRF-0654 on 17/may/17
		//Modified above query by Thamizh selvi against ML-MMOH-CRF-0645
		//Added by Ajay Hatwate for GHL-CRF-0650
				if(isMLCAppl){
					PREncount.append(",to_char(visit_adm_date_time,'DD/MM/YYYY HH24:MI:SS') visit_adm_date_time ,MLC_REMARKS, MLC_NO_OUTSIDE_DTLS, MLC_DEATH_YN, to_char(MLC_CAPTURE_DATE,'DD/MM/YYYY HH24:MI:SS') MLC_CAPTURE_DATE, POL_REP_NO, POL_STN_ID");	
				}
		
				//Added by Ajay Hatwate for ML-MMOH-CRF-2069
				if(isSecondaryTriageQueueNum){
					PREncount.append(", SECONDARY_TRIAGE_QUEUE_NO ");
				}
		
		PREncount.append(" from  PR_ENCOUNTER ##REPDB## where ENCOUNTER_ID=? and FACILITY_ID=? ");
		//Modified above query by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
		
		/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
		sqlFinal = PREncount.toString();
		sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
		/*End*/
		pstmt_date = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
		pstmt_date.setString	(1,	encounter_id);
		pstmt_date.setString	(2,	facilityId);

		rs_date = pstmt_date.executeQuery();
		

		if (rs_date!=null)
		{
			while(rs_date.next())
			{
				visit_date               = rs_date.getString(1);	
			//	sys_date                 = rs_date.getString("sys");
				sys_date            = rs_date.getString("sys1");
				sys_date_qry             = rs_date.getString("sys");
				episode_id               = rs_date.getString("EPISODE_ID");
                visit_num                = rs_date.getString("OP_EPISODE_VISIT_NUM");
				sqlDate                  = rs_date.getString("sqlDate");
				referral_id              = checkForNull(rs_date.getString("REFERRAL_ID"));
				mlc_yn			         = checkForNull(rs_date.getString("MLC_YN"));
				date_time_of_accident    = checkForNull(rs_date.getString("date_time_of_accident"));
                place_of_accident        = checkForNull(rs_date.getString("place_of_accident"));
				
	//  Tuesday, May 04, 2010 PE_EXE Venkat s
                dis_yn        = checkForNull(rs_date.getString("disaster_yn"));
                dis_town_code        = checkForNull(rs_date.getString("disaster_town_code"));
                dis_type_code        = checkForNull(rs_date.getString("disaster_type_code"));
                dis_category_code        = checkForNull(rs_date.getString("disaster_category_code"));
                dis_complaint_code        = checkForNull(rs_date.getString("complaint_code"));
				
				/*below line added for this CRF RF AAKH-CRF-0010 [IN038535]*/
				attend_practitioner_id = checkForNull(rs_date.getString("ATTEND_PRACTITIONER_ID"));
				attend_practitioner_name= checkForNull(rs_date.getString("practitioner_name"));

				/*Added by Rameswar on 28-Nov-15 for GDOH-CRF-0004.1*/
				vehicle_invlovedcode= checkForNull(rs_date.getString("VEHICLE_INVOLVED1_CODE"));
				vehicle_invlovedcode1= checkForNull(rs_date.getString("VEHICLE_INVOLVED2_CODE"));
				
				//Added by Ashwini on 04-Apr-2017 for GDOH-CFR-0004.3
				Vehicle_Reg_No1= checkForNull(rs_date.getString("VEHICLE_REG_NO1"));
				Vehicle_Reg_No2= checkForNull(rs_date.getString("VEHICLE_REG_NO2"));
				
				pat_position_code= checkForNull(rs_date.getString("PAT_POSITION_CODE"));

				/*Added by Rameswar on 04-Oct-16 for GDOH-CRF-0004.2*/
				trauma_yn= checkForNull(rs_date.getString("TRAUMA_YN"));
				oscc_yn= checkForNull(rs_date.getString("OSCC_YN"));
				medical_yn= checkForNull(rs_date.getString("MEDICAL_YN"));
				surgical_yn= checkForNull(rs_date.getString("SURGICAL_YN"));
				mech_injr_code= checkForNull(rs_date.getString("MECH_INJURY_CATG_CODE"));
				mech_injr_subcat_code= checkForNull(rs_date.getString("MECH_INJURY_SUBCATG_CODE"));
				protective_device_code= checkForNull(rs_date.getString("PROTECTIVE_DEVICE_CODE"));
				/*Added by Rameswar on 04-Oct-16 for GDOH-CRF-0004.2*/
				
				//Added by Sangeetha for ML-MMOH-CRF-0654 on 17/may/17
				transport_mode_code=checkForNull(rs_date.getString("transport_mode"));
				arrival_code=checkForNull(rs_date.getString("arrival_code"));
				accompanied_by_code=checkForNull(rs_date.getString("accompanied_by_code"));

				OandGYn = checkForNull(rs_date.getString("O_AND_G_YN"));//Added by Thamizh selvi for ML-MMOH-CRF-0645
				caseType = checkForNull(rs_date.getString("case_type"));//Added by Ajay Hatwate for ML-MMOH-CRF-1653
				queue_no = checkForNull(rs_date.getString("SECONDARY_TRIAGE_QUEUE_NO"));//Added by Ajay Hatwate for ML-MMOH-CRF-2069

				 /*Added by Ajay Hawtate for GHL-CRF-0650 */
				if(isMLCAppl){
					MLC_REMARKS=checkForNull(rs_date.getString("MLC_REMARKS"));
					MLC_NO_OUTSIDE_DTLS=checkForNull(rs_date.getString("MLC_NO_OUTSIDE_DTLS"));
					MLC_DEATH_YN =rs_date.getString("MLC_DEATH_YN")==null?"N":rs_date.getString("MLC_DEATH_YN");
					MLC_CAPTURE_DATE =checkForNull(rs_date.getString("MLC_CAPTURE_DATE"));
					police_rep_no = checkForNull(rs_date.getString("POL_REP_NO"));
					police_station_dtls = checkForNull(rs_date.getString("POL_STN_ID"));
					visit_date_time = checkForNull(rs_date.getString("visit_adm_date_time"));
					MLC_REMARKS = escapeHTML(MLC_REMARKS);
					MLC_NO_OUTSIDE_DTLS = escapeHTML(MLC_NO_OUTSIDE_DTLS);
					police_rep_no = escapeHTML(police_rep_no);
					police_station_dtls = escapeHTML(police_station_dtls);
					if(MLC_DEATH_YN.equals("Y")){
						disMLCDeath = "";
					}
				}

			}
		}
			if(sys_date_time.equals("")) sys_date_time = sys_date;

	    if(!a_status.equals("")) dis1 = disabled;
		if (rs_date != null)   rs_date.close();
		if (pstmt_date != null) pstmt_date.close();
		if((PREncount != null) && (PREncount.length() > 0))
		{
			PREncount.delete(0,PREncount.length());
		}
		if (referral_id.equals(""))
				 disRefID ="";
		else
				 disRefID="disabled";

     }
     catch(Exception e) { e.printStackTrace();}
	 /*Added by Thamizh selvi against ML-MMOH-CRF-0655 Start*/
	 try
	  {	
	   StringBuffer sqlPr = new StringBuffer();
       sqlPr.append("select count(*) from pr_encounter ##REPDB## where ");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
	   sqlPr.append("facility_id= ?  and patient_id= ? and encounter_id !=? ");
		/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
		sqlFinal = sqlPr.toString();
		sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
		/*End*/
	   pstmtEncounter = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
       pstmtEncounter.setString(1,facilityId );
	   pstmtEncounter.setString(2,patient_id );
	   pstmtEncounter.setString(3,encounter_id );

	   rsetEncounter = pstmtEncounter.executeQuery();
		  while(rsetEncounter!=null && rsetEncounter.next())
				 {
				  countRecEnc=rsetEncounter.getInt(1);
				 }
		  if(rsetEncounter!=null) rsetEncounter.close();
		  if(pstmtEncounter!=null) pstmtEncounter.close();
		  if((sqlPr != null) && (sqlPr.length() > 0))
		  {
			sqlPr.delete(0,sqlPr.length());
		  }
		  if (countRecEnc==0)
		  {
			  EncounterProp = "disabled";
		  }else
		  {
			  EncounterProp ="";
		  }
	  }catch(Exception e) {e.printStackTrace();}

	   try
	  {	
	   StringBuffer prevEnc = new StringBuffer();
	   prevEnc.append("SELECT (SYSDATE - MAX (VISIT_STATUS_SET_ON_DATE)) ");
	   prevEnc.append(" * 24  PREV_VISIT_HRS FROM PR_ENCOUNTER ##REPDB## WHERE  ");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
	   prevEnc.append(" facility_id = ?  AND patient_id = ?  ");
	   prevEnc.append(" AND VISIT_STATUS in ('07', '09')   ");
	   /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
		sqlFinal = prevEnc.toString();
		sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
		/*End*/
	   pstmtEncounter = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
       pstmtEncounter.setString(1, facilityId);
	   pstmtEncounter.setString(2, patient_id);

	   rsetEncounter = pstmtEncounter.executeQuery();
			  while(rsetEncounter!=null && rsetEncounter.next())
				 {
				  prev_visit_hrs = rsetEncounter.getDouble(1);
				 }
		  if(rsetEncounter!=null) rsetEncounter.close();
		  if(pstmtEncounter!=null) pstmtEncounter.close();
		  if((prevEnc != null) && (prevEnc.length() > 0))
		  {
			prevEnc.delete(0,prevEnc.length());
		  }
		  if(prev_visit_hrs > 24 || prev_visit_hrs == 0) {
			  VisitProp = "disabled";
		  }else if(prev_visit_hrs > 0 && prev_visit_hrs <= 24)
		  {
			  VisitProp ="";
		  }
	  }catch(Exception e) {e.printStackTrace();}
	  /*End*/
  try{
        StringBuffer  emerdetails = new StringBuffer();
		emerdetails.append("select COMPLAINT_CODE, ");
		emerdetails.append("MECH_INJURY_CATG_CODE,MECH_INJURY_SUBCATG_CODE,");
		emerdetails.append(" VEHICLE_INVOLVED1_CODE,VEHICLE_INVOLVED2_CODE, ");
		//Added by Ashwini on 04-Apr-2017 for GDOH-CFR-0004.3
		emerdetails.append(" VEHICLE_REG_NO1,VEHICLE_REG_NO2, ");
		emerdetails.append(" PROTECTIVE_DEVICE_CODE,PAT_POSITION_CODE, ");
		emerdetails.append(" OSCC_YN,FBC_YN,");
		emerdetails.append(" IMMUNIZATION_STATUS,ATT_GIVEN_YN,DEVP_MILESTONE_AGE_YN,");
		emerdetails.append(" IM_UPTO_DATE_YN,MENARCHE_YN,HEIGHT,WEIGHT,");
		emerdetails.append(" CIRCUMFERENCE, ");
		emerdetails.append(" to_char(LMP_DATE,'dd/mm/yyyy') LMP_DATE,PREGNANT_YN,");
		emerdetails.append(" MECH_INJURY_SUBCATG_CODE,PAT_PRIORITY,TRAUMA_YN,");
		emerdetails.append(" REMARKS,MEDICAL_YN,SURGICAL_YN,IMMOBILIZATION_CODE,"); 
		emerdetails.append(" TREATMENT_AREA_CODE ,PRIORITY_ZONE,BED_NO, PAT_PRIORITY,"); 
		emerdetails.append(" POL_STN_ID,POL_REP_NO,DISASTER_YN,DISASTER_TOWN_CODE,");
		emerdetails.append(" to_char(DATE_TIME_OF_ACCIDENT,'dd/mm/yyyy hh24:mi') DATE_TIME_OF_ACCIDENT,");
		emerdetails.append(" PLACE_OF_ACCIDENT, ");
		//Modified for CRF ML-MMOH-CRF-0654 by Ajay Hatwate
		if(isMLCAppl){
			emerdetails.append(" mlc_death_yn, MLC_REMARKS, MLC_CAPTURE_DATE, MLC_NO_OUTSIDE_DTLS, ");	
		}
		//Added by Ajay Hatwate for ML-MMOH-CRF-2069
		if(isSecondaryTriageQueueNum){
			emerdetails.append(" SECONDARY_TRIAGE_QUEUE_NO, ");
		}
		emerdetails.append(" DISASTER_TYPE_CODE,disaster_category_code,AMBULATORY_STATUS,transport_mode,arrival_code,accompanied_by_code, O_AND_G_YN, INITIAL_MGMT_MEDICATION, INITIAL_MGMT_OTHERS, CASE_TYPE from ");//Modified by Thamizh selvi against ML-MMOH-CRF-0645, ML-MMOH-CRF-0651	
		emerdetails.append(" AE_PAT_EMERGENCY_DETAIL ##REPDB## where ENCOUNTER_ID= ? AND ");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
		emerdetails.append(" FACILITY_ID=? and ");
		emerdetails.append(" recorded_date=to_date(?,'dd/mm/yyyy hh24:mi:ss') " );  
	//	emerdetails.append(" to_char(RECORDED_DATE,'dd/mm/yyyy hh24:mi:ss')=? " );     

		StringBuffer  sqltreatment2 = new StringBuffer();
		sqltreatment2.append("select TREATMENT_AREA_CODE ,PRIORITY_ZONE,REFERRAL_ID,AE_BED_NO, PAT_PRIORITY,DIS_REGN_REFERENCE,patient_class from ");
		sqltreatment2.append(" op_patient_queue ##REPDB## where ENCOUNTER_ID =? and  ");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
		sqltreatment2.append(" FACILITY_ID=? ");
		/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
		String treatmentSql = sqltreatment2.toString();
		treatmentSql = treatmentSql.replaceAll("##REPDB##",RepDb);
		/*End*/

   /*       
		StringBuffer  sqlaeage = new StringBuffer();
		sqlaeage.append("select MIN_AGE_FOR_PREG_DTL, MAX_AGE_FOR_PAED_DTL,ORDER_CATALOG_CODE3 ");
		sqlaeage.append(" from ae_param where OPERATING_FACILITY_ID= ? ");
				
		StringBuffer  sqltreatment1 = new StringBuffer();
		sqltreatment1.append("select TREATMENT_AREA_CODE ,PRIORITY_ZONE,BED_NO, PAT_PRIORITY from ");
		sqltreatment1.append(" ae_pat_emergency_detail where ENCOUNTER_ID =? and  ");
		sqltreatment1.append(" FACILITY_ID=? and recorded_date=to_date(?,'dd/mm/yyyy hh24:mi:ss')");
		 
	    StringBuffer  sqlAge = new StringBuffer();
		sqlAge.append("select Calculate_Age(TO_CHAR(date_of_birth, ");
		sqlAge.append(" 'dd/mm/yyyy'),1), sex,to_char(DATE_OF_BIRTH,'dd/mm/yyyy') ");
		sqlAge.append("date_of_birth,pat_dtls_unknown_yn from mp_patient where patient_id = ?  ");

		StringBuffer sqlComplaint = new StringBuffer();
		sqlComplaint.append("select COMPLAINT_CODE,COMPLAINT_DESC from AM_COMPLAINT_LANG_VW  where language_id='"+locale+"' and EFF_STATUS='E' order by COMPLAINT_DESC ");

 

  */
		StringBuffer sqlUnit = new StringBuffer();
		sqlUnit.append(" select UNIT_OF_LENGTH_NB,UNIT_OF_WT_NB,");
		sqlUnit.append(" UNIT_OF_CIRCUM_NB,NB_MOTHER_CUTOFF_AGE from MP_PARAM ##REPDB## ");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
 

		
        StringBuffer sqlAmbulatory = new StringBuffer();
		sqlAmbulatory.append(" select AMBULATORY_STATUS,SHORT_DESC from ");
		sqlAmbulatory.append(" AM_AMBULATORY_STATUS_LANG_VW ##REPDB## where ");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1   
		sqlAmbulatory.append(" language_id='"+locale+"'  and EFF_STATUS='E' and ");
		sqlAmbulatory.append(" nvl(eff_date_from,sysdate) >= sysdate ");
		sqlAmbulatory.append(" and nvl(eff_date_to,sysdate) <= sysdate ");
		sqlAmbulatory.append(" order by SHORT_DESC ");
		
		/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
		String AmbulatorySql = sqlAmbulatory.toString();
		AmbulatorySql = AmbulatorySql.replaceAll("##REPDB##",RepDb);
		/*End*/
	   
		StringBuffer  sqlPosition = new StringBuffer();
		//sqlPosition.append("select PAT_POSITION_CODE,SHORT_DESC from AE_PAT_POSITION_LANG_VW  where language_id='"+locale+"' and EFF_STATUS='E' order by SHORT_DESC");
		sqlPosition.append("SELECT a.PAT_POSITION_CODE, a.SHORT_DESC FROM AE_PAT_POSITION_LANG_VW ##REPDB## a WHERE a.language_id = '"+locale+"' AND a.EFF_STATUS = 'E' AND a.pat_position_code like '%%' ORDER BY a.SHORT_DESC");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
		
		/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
		String PositionSql = sqlPosition.toString();
		PositionSql = PositionSql.replaceAll("##REPDB##",RepDb);

		sqlFinal = sqlUnit.toString();
		sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
		/*End*/
                       pstmt = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				       rset = pstmt.executeQuery();
					   
					   while(rset!=null && rset.next())
					   {
                             heightDesc = rset.getString("UNIT_OF_LENGTH_NB");
							 weightDesc = rset.getString("UNIT_OF_WT_NB");
							 circumDesc = rset.getString("UNIT_OF_CIRCUM_NB");
							 nb_mother_min_age = rset.getInt("NB_MOTHER_CUTOFF_AGE");
					   }                      

					     if(nb_mother_min_age>0) 
							 min_age_pregnancy=nb_mother_min_age;                              
						else
                             min_age_pregnancy=min_age_pregnancy1;
					
   					   if(rset!=null) rset.close();
					   if(pstmt!=null) pstmt.close();
                       if((sqlUnit != null) && (sqlUnit.length() > 0))
					   {
							sqlUnit.delete(0,sqlUnit.length());
					   }
					   if(heightDesc!=null && heightDesc.equalsIgnoreCase("C"))
							heightDesc = "CM";
					   else if(heightDesc!=null && heightDesc.equalsIgnoreCase("I"))
							heightDesc = "Inch";
					   if(weightDesc!=null && weightDesc.equalsIgnoreCase("K"))
							weightDesc = "KG";
					   else if(weightDesc!=null && weightDesc.equalsIgnoreCase("L"))
							weightDesc = "LB";
					   if(circumDesc!=null && circumDesc.equalsIgnoreCase("C"))
							circumDesc = "CM";
					   else if(circumDesc!=null && circumDesc.equalsIgnoreCase("I"))
							circumDesc = "Inch";	
					/*	
                       pstmt = con.prepareStatement(sqlaeage.toString());
					   pstmt.setString(1,facilityId);

				       rset = pstmt.executeQuery();
					   
					   while(rset!=null && rset.next())
					   {
                             min_age_pregnancy1 = rset.getInt(1);
							 max_age_paediatric = rset.getInt(2);
                             order_catalog_code3  = checkForNull(rset.getString("order_catalog_code3"));

					   } 
					  
					  if(rset!=null) rset.close();
					  if(pstmt!=null) pstmt.close();
					  if((sqlaeage != null) && (sqlaeage.length() > 0))
					  {
							sqlaeage.delete(0,sqlaeage.length());
					  }
					*/
				
     			  if(modify_flag.equals("Y")) {
					  try {
                        if (!rec_date_time.equals("")) {
							   /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
								sqlFinal = emerdetails.toString();
								sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
								/*End*/
								mlcQuery = sqlFinal;
							   pstmt1 = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1					   
							   pstmt1.setString	(1,	encounter_id);
							   pstmt1.setString	(2,	facilityId);
							   pstmt1.setString	(3,	rec_date_time);
							   
							   display_triage_record_date_time=rec_date_time; // Added for ML-MMOH-0656 by shanmukh on 4th-Apr-2018
							   rset1 = pstmt1.executeQuery();
							   
							   while(rset1!=null && rset1.next()) {
									 complaint_code=checkForNull(rset1.getString("COMPLAINT_CODE")); 
									 mech_injr_code=checkForNull(rset1.getString("MECH_INJURY_CATG_CODE"));
									 mech_injr_subcat_code=checkForNull(rset1.getString("MECH_INJURY_SUBCATG_CODE"));
									 vehicle_invlovedcode=checkForNull(rset1.getString("VEHICLE_INVOLVED1_CODE"));
									 vehicle_invlovedcode1=checkForNull(rset1.getString("VEHICLE_INVOLVED2_CODE"));

								//Added by Ashwini on 04-Apr-2017 for GDOH-CFR-0004.3
									Vehicle_Reg_No1=checkForNull(rset1.getString("VEHICLE_REG_NO1"));
									 Vehicle_Reg_No2=checkForNull(rset1.getString("VEHICLE_REG_NO2"));
									 protective_device_code=checkForNull(rset1.getString("PROTECTIVE_DEVICE_CODE"));
									 pat_position_code=checkForNull(rset1.getString("PAT_POSITION_CODE"));
									 oscc_yn=checkForNull(rset1.getString("OSCC_YN"));
									 immunization_status=checkForNull(rset1.getString("IMMUNIZATION_STATUS"));
									 att_given=checkForNull(rset1.getString("ATT_GIVEN_YN"));
									 dev_mile_stone=checkForNull(rset1.getString("DEVP_MILESTONE_AGE_YN"));
									 emerdetails.append(" IM_UPTO_DATE_YN,MENARCHE_YN,HEIGHT,WEIGHT,");
									 imm_date=checkForNull(rset1.getString("IM_UPTO_DATE_YN"));
									 menarche_yn=checkForNull(rset1.getString("MENARCHE_YN"));
									 height=checkForNull(rset1.getString("HEIGHT"));
									 weight=checkForNull(rset1.getString("WEIGHT"));
									 circumference=checkForNull(rset1.getString("CIRCUMFERENCE"));
									 lmp_date=checkForNull(rset1.getString("LMP_DATE"));
									 pregnant_yn=checkForNull(rset1.getString("PREGNANT_YN"));
									 mech_injury_subcatg_code=checkForNull(rset1.getString("MECH_INJURY_SUBCATG_CODE"));
									 pat_priority       =checkForNull(rset1.getString("PAT_PRIORITY"));
									 trauma_yn          =checkForNull(rset1.getString("TRAUMA_YN"));
									 triage_remarks     =checkForNull(rset1.getString("REMARKS"));
									 treat_code = rset1.getString("TREATMENT_AREA_CODE")==null?"":rset1.getString("TREATMENT_AREA_CODE"); 
									 priority = rset1.getString("PRIORITY_ZONE")==null?"":rset1.getString("PRIORITY_ZONE"); 
									 bed_no= rset1.getString("BED_NO")==null?"":rset1.getString("BED_NO");
									 priority_code= rset1.getString("PAT_PRIORITY")==null?"":rset1.getString("PAT_PRIORITY");
									 surgical_yn        =checkForNull(rset1.getString("SURGICAL_YN"));
									 medical_yn         =checkForNull(rset1.getString("MEDICAL_YN"));
									 immobilization     =checkForNull(rset1.getString("IMMOBILIZATION_CODE"));									 
									 police_rep_no      =checkForNull(rset1.getString("POL_REP_NO"));
									 police_station_dtls=checkForNull(rset1.getString("POL_STN_ID"));
									 a_status		    =checkForNull(rset1.getString("AMBULATORY_STATUS"));
									 date_time_of_accident    = checkForNull(rset1.getString("DATE_TIME_OF_ACCIDENT"));
									 place_of_accident        = checkForNull(rset1.getString("PLACE_OF_ACCIDENT"));
									 fbc_yn        = checkForNull(rset1.getString("FBC_YN"));
									 //Below line added for this CRF ML-MMOH-CRF-0654
									 transport_mode_code=checkForNull(rset1.getString("transport_mode"));
									 arrival_code=checkForNull(rset1.getString("arrival_code"));
									 accompanied_by_code=checkForNull(rset1.getString("accompanied_by_code"));

									 //End this CRF ML-MMOH-CRF-0654

									 OandGYn = checkForNull(rset1.getString("O_AND_G_YN"));//Added by Thamizh selvi against ML-MMOH-CRF-0645
									 
									 /*Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651 Start*/
									 medication			= checkForNull(rset1.getString("INITIAL_MGMT_MEDICATION"));
									 intialMgmtOthers	= checkForNull(rset1.getString("INITIAL_MGMT_OTHERS"));
									 /*End*/

									 //Added by Ajay Hatwate for GHL-CRF-0650 on 18/07/2023
									 if(isMLCAppl){
										 MLC_REMARKS = checkForNull(rset1.getString("MLC_REMARKS")); 
										 MLC_CAPTURE_DATE = checkForNull(rset1.getString("MLC_CAPTURE_DATE")); 
										 MLC_NO_OUTSIDE_DTLS = checkForNull(rset1.getString("MLC_NO_OUTSIDE_DTLS")); 
										 MLC_DEATH_YN = checkForNull(rset1.getString("mlc_death_yn")); 
										MLC_REMARKS = escapeHTML(MLC_REMARKS);
										MLC_NO_OUTSIDE_DTLS = escapeHTML(MLC_NO_OUTSIDE_DTLS);
										police_rep_no = escapeHTML(police_rep_no);
										police_station_dtls = escapeHTML(police_station_dtls);
									 }
									 caseType = checkForNull(rset1.getString("case_type"));//Added by Ajay Hatwate for ML-MMOH-CRF-1653					
									 caseTypeDisable =" disabled ";//Added by Ajay Hatwate for ML-MMOH-CRF-1653
				queue_no = checkForNull(rset1.getString("SECONDARY_TRIAGE_QUEUE_NO"));
				dis_queue_no = " disabled ";
											// System.out.println(caseType + " case Type " + caseTypeDisable + " isCTDisabled " + queue_no + " queue_no ");
									if(fbc_yn.equals("Y")) {
										 fbccheck="Checked";
										 fbccheck_val="Y";
							        } else {
										fbccheck="";
										fbccheck_val="N";
									}
							    }
								
								 if(rset1!=null) rset1.close();
								 if(pstmt1!=null) pstmt1.close();
								 if((emerdetails != null) && (emerdetails.length() > 0)) {
									emerdetails.delete(0,emerdetails.length());
								 }	
								 
								 
								 disaster_yn=dis_yn;
								 disaster_town_code=dis_town_code;
								 disaster_type_code=dis_type_code;
								 disaster_category_code=dis_category_code;
								 referral_id=referral_id;
				 							 
		/*	 Tuesday, May 04, 2010 PE_EXE Venkat s
								 StringBuffer sqlTiage1 = new StringBuffer();
								 sqlTiage1.append("select disaster_yn,disaster_town_code,disaster_type_code,disaster_category_code,referral_id  from pr_encounter where encounter_id ='"+encounter_id+"'  and facility_id ='"+facilityId+"' ");								
								 pstmt1 = con.prepareStatement(sqlTiage1.toString());
								 rset1 = pstmt1.executeQuery();
								 
								 while(rset1!=null && rset1.next()) {								
									 disaster_yn=checkForNull(rset1.getString("disaster_yn"));
									 disaster_town_code =checkForNull(rset1.getString("disaster_town_code"));
									 disaster_type_code =checkForNull(rset1.getString("disaster_type_code"));
									 disaster_category_code =checkForNull(rset1.getString("disaster_category_code"));
									 referral_id=checkForNull(rset1.getString("referral_id"));
								}
								if(rset1!=null) rset1.close();
								if(pstmt1!=null) pstmt1.close();
								if((sqlTiage1 != null) && (sqlTiage1.length() > 0)) {
								    sqlTiage1.delete(0,sqlTiage1.length());
								} 
								*/
					
           			      } else {

								 disaster_yn=dis_yn;
								 disaster_town_code=dis_town_code;
								 disaster_type_code=dis_type_code;
								 disaster_category_code=dis_category_code;
								 referral_id=referral_id;
							/* Tuesday, May 04, 2010 PE_EXE Venkat s
								StringBuffer sqlTiage1 = new StringBuffer();
								sqlTiage1.append("select disaster_yn,disaster_town_code,disaster_type_code,disaster_category_code,referral_id  from pr_encounter where encounter_id ='"+encounter_id+"'  and facility_id ='"+facilityId+"' ");
							  
								pstmt1 = con.prepareStatement(sqlTiage1.toString());
								rset1 = pstmt1.executeQuery();
								
								while(rset1!=null && rset1.next())
								{							
								 disaster_yn=checkForNull(rset1.getString("disaster_yn"));
								 disaster_town_code =checkForNull(rset1.getString("disaster_town_code"));
								 disaster_type_code =checkForNull(rset1.getString("disaster_type_code"));
								 disaster_category_code =checkForNull(rset1.getString("disaster_category_code"));
								 referral_id=checkForNull(rset1.getString("referral_id"));
								}
								if(rset1!=null) rset1.close();
								if(pstmt1!=null) pstmt1.close();
								if((sqlTiage1 != null) && (sqlTiage1.length() > 0))
								 {
									sqlTiage1.delete(0,sqlTiage1.length());
								 }
           			    	  */
						  }

					
					 }catch(Exception e) {
							e.printStackTrace();
					 }
                     dis1    = disabled;
					 dis3    = disabled;
                     disMed  = disabled;
                     disSur  = disabled;
					 dis2    = "readonly";
					 dis5    = disabled;
                     disOscc = disabled;
					 dis6    = disabled; 
					 dis7    = disabled;
					 dis8    = disabled;
					 dis9    = disabled;
					 dis10    = disabled;
					 dis11   = disabled;
                     disMLC  = disabled;
					 dis12   = disabled;
					 dis13   = disabled;
					 dis14   = disabled;
					 dis15   = disabled;
					 disabled991   = disabled;
					 disabled99    = disabled;
					 disImm = disabled;
					 disMenarche = disabled;
					 disHeight= disabled;
					 disWeight = disabled;
					 disCir = disabled;
					 disabledPre = disabled;
					 disabled111=disabled;
					 disabled13=disabled;
					 disabled12=disabled;
					 disPriority=disabled;
					 disTreatArea=disabled;
					 disBed=disabled;
					 disBed1=disabled;
					 disDisaster=disabled;
					 disabled11=disabled;
					 disImmobil=disabled;
					 disRefID =disabled;
					 FBCProp  ="disabled";
					 disDateAcci = disabled;
					 disPlaceAcci = disabled;
					 
					 dis_triage_record_date_time=disabled; // Added for ML-MMOH-0656 by shanmukh

					 
					 dis16 = disabled; //AAKH-CRF-0010 [IN:038535]	
					 
					 accompanied_by_dis=disabled; //Added for this CRF ML-MMOH-CRF-0654

					 disOandGYn = disabled;//Added by Thamizh selvi against ML-MMOH-CRF-0645

					 /*Added by Thamizh selvi on 13th Apr 2018 against ML-MMOH-CRF-0651 Start*/
					 disIntialMgmtOthers	= disabled;
					 disMedication			= disabled;
					 /*End*/
					 

					 prioritynewdisabled = "disabled";
				   }else if(modify_flag.equals("N"))
	                {



								 disaster_yn=dis_yn;
								 disaster_town_code=dis_town_code;
								 disaster_type_code=dis_type_code;
								 disaster_category_code=dis_category_code;
								 referral_id=referral_id;
								 complaint_code=dis_complaint_code;
									/* Tuesday, May 04, 2010 PE_EXE Venkat s
									StringBuffer sqlTiage1 = new StringBuffer();
									sqlTiage1.append("select disaster_yn,disaster_town_code,disaster_type_code,disaster_category_code,referral_id,complaint_code  from pr_encounter where encounter_id ='"+encounter_id+"'  and facility_id ='"+facilityId+"' ");

									pstmt1 = con.prepareStatement(sqlTiage1.toString());
									//  pstmt1.setString(1,encounter_id);
									///	  pstmt1.setString(2,facilityId);

									rset1 = pstmt1.executeQuery();
									
									while(rset1!=null && rset1.next())
									{
									disaster_yn=checkForNull(rset1.getString("disaster_yn"));
									disaster_town_code=checkForNull(rset1.getString("disaster_town_code"));
									disaster_type_code =checkForNull(rset1.getString("disaster_type_code"));
									disaster_category_code =checkForNull(rset1.getString("disaster_category_code"));
									referral_id=checkForNull(rset1.getString("referral_id"));
									complaint_code=checkForNull(rset1.getString("complaint_code"));
									}
									if(rset1!=null) rset1.close();
									if(rset1!=null) rset1.close();
									if(pstmt1!=null) pstmt1.close();
									if((sqlTiage1 != null) && (sqlTiage1.length() > 0))
									{
									sqlTiage1.delete(0,sqlTiage1.length());
									}
									*/
           			    }



              if(medical_yn.equals("Y")) {
		          checkedMed="checked";
			  }else{
                     checkedMed="";
			  }
			 if(surgical_yn.equals("Y")) {
		             checkedSur="checked";
			   }else{
                     checkedSur="";
               } 
			 if(disaster_yn.equals("Y")) {
		            checked1="checked";
			  } else {
                    checked1="";
					disabled11="disabled";
              }
			 if(oscc_yn.equals("Y")) {        
				 checked2="checked";
	  			  disable3="disabled";
	         } else {
				 checked2="";
	         }    
			 if(mlc_yn.equals("Y")) {		
		          checked3="checked";
				  dis12   = "";
				  dis13   = "";
				  disMLCDeath = "";
				  disOutMLCDet = "";
				  disDateOfCapt = "";
				  disMLCRemark = "";
             }else{
                  checked3="";
				  dis12   = "disabled";
				  dis13   = "disabled";
				  disMLCDeath = "disabled";
				  disOutMLCDet = "disabled";
				  disDateOfCapt = "disabled";
				  disMLCRemark = "disabled";
            }
			  /*Added by Thamizh selvi against ML-MMOH-CRF-0645*/
			  if(OandGYn.equals("Y"))
		          checkedOandGYn = "checked";
			  else
                  checkedOandGYn = "";
			  /*End*/
				    


                if(immunization_status.equals("F"))
	             {
				          selected="selected" ;
						  dis14 = disabled;
	             }
                else if(immunization_status.equals("P"))
	            {
                          selected1="selected" ;
						  dis14 = disabled;
                }
                else if(immunization_status.equals("U"))
	            {
                         selected2="selected" ;
						 dis14 = disabled;
                } 

                if(att_given.equals("Y"))
	            {
				         checked4="checked" ;
						 dis15 = disabled;
                }
			    else
	            { 
                         checked4="" ;
                }
				if(dev_mile_stone.equals("Y"))
	             {
				          checked5="checked" ;
						  disabled99="disabled";
						  disabled991="disabled";

                 }
				else
	            {
                          checked5="" ;	
                }
				if(imm_date.equals("Y")){
				          checked6="checked" ;
						  disImm = disabled;
				}

				else{
                          checked6="" ;	
				}
				if(menarche_yn.equals("Y"))
				{	
				          checked7="checked" ;
						  checked8="checked";
						  disMenarche=disabled;
		        }
						  
			    else
				{
                          checked7="" ;	
						  checked8="" ;
				}
                if(sex.equalsIgnoreCase("M"))
	            {
					disMenarche=disabled;
				} 
			    if(pregnant_yn.equals("Y"))
	             {
				
				          checked8="checked" ;
						  disabledPre=disabled;
				
                 }
				  
			    else
	             {
                       checked8="" ;
                 }
              if(trauma_yn.equals("Y")){
				
				
				          checked9="checked" ;
						 // dis5 = disabled; 	/*commented by Rameswar on 04-Oct-16 for GDOH-CRF-0004.2*/
			  }
			    else
	           {
                          checked9="" ;
               } 

	
		 if (!rec_date_time.equals(""))
	     {

	/*		 
             pstmt1 = con.prepareStatement(sqltreatment1.toString());
			
			 pstmt1.setString	(1,	encounter_id);
			 pstmt1.setString	(2,	facilityId);
			 pstmt1.setString	(3,	rec_date_time);

			 rset1 = pstmt1.executeQuery();
			 
			
			 while(rset1!=null && rset1.next())
			 {
			  
			 treat_code = rset1.getString("TREATMENT_AREA_CODE")==null?"":rset1.getString("TREATMENT_AREA_CODE"); 
			 priority = rset1.getString("PRIORITY_ZONE")==null?"":rset1.getString("PRIORITY_ZONE"); 
			 bed_no= rset1.getString("BED_NO")==null?"":rset1.getString("BED_NO");
			 priority_code= rset1.getString("PAT_PRIORITY")==null?"":rset1.getString("PAT_PRIORITY");
			 }
			 if(rset1!=null) rset1.close();
			 if(pstmt1!=null) pstmt1.close();
   */		
			pstmt1 = con.prepareStatement(treatmentSql);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
			pstmt1.setString	(1,	encounter_id);
			pstmt1.setString	(2,	facilityId);
			rset1 = pstmt1.executeQuery();
			
			while(rset1!=null && rset1.next())
			{
	  
			dis_regn_ref= rset1.getString("DIS_REGN_REFERENCE")==null?"":rset1.getString("DIS_REGN_REFERENCE");
			referral_id= rset1.getString("REFERRAL_ID")==null?"":rset1.getString("REFERRAL_ID");
			patient_class	= rset1.getString("patient_class")==null?"":rset1.getString("patient_class");

			}
			
		    if(rset1!=null) rset1.close();
			if(pstmt1!=null) pstmt1.close();

		 } else {
					pstmt1 = con.prepareStatement(treatmentSql);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
					pstmt1.setString	(1,	encounter_id);
					pstmt1.setString	(2,	facilityId);
					rset1 = pstmt1.executeQuery();
					while(rset1!=null && rset1.next()){				  
						 treat_code = rset1.getString("TREATMENT_AREA_CODE")==null?"":rset1.getString("TREATMENT_AREA_CODE"); 
						 priority = rset1.getString("PRIORITY_ZONE")==null?"":rset1.getString("PRIORITY_ZONE"); 
						 bed_no= rset1.getString("AE_BED_NO")==null?"":rset1.getString("AE_BED_NO");
						 priority_code= rset1.getString("PAT_PRIORITY")==null?"":rset1.getString("PAT_PRIORITY");
						 dis_regn_ref= rset1.getString("DIS_REGN_REFERENCE")==null?"":rset1.getString("DIS_REGN_REFERENCE");
						 referral_id= rset1.getString("REFERRAL_ID")==null?"":rset1.getString("REFERRAL_ID");
						 patient_class	= rset1.getString("patient_class")==null?"":rset1.getString("patient_class");
					}			
					 if(rset1!=null) rset1.close();
					 if(pstmt1!=null) pstmt1.close();
			      }
		 /*Below Condition Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 28th 2014*/
		 
			if(!five_level_triage_appl_yn.equals("Y")){
		 
				  if (priority.equals("R")) priorityStatus1="checked";
				  else if (priority.equals("Y")) priorityStatus2="checked";
				  else if (priority.equals("G")) priorityStatus3="checked";
				  if (priority.equals("R")) priority_no="1";
				  else if (priority.equals("Y")) priority_no="3";
				  else if (priority.equals("G")) priority_no="2";
				  else if (priority.equals("U")) priority_no="4";
		
				  if (priority.equals("R")) {  
					 priorityStatus1="checked";
					 disabled12="disabled";
					 disabled13="disabled";								   
				  } else if (priority.equals("Y")) {
					 priorityStatus2="checked";
					 disabled111="disabled";
					 disabled13="disabled";
				  } else if (priority.equals("G")) {
					  priorityStatus3="checked";
					  disabled111="disabled";
					  disabled12="disabled";
				  }
			}else{
				/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 7th 2014 Start*/	
			  	sql="select get_task_applicability ##REPDB##('CA_CHART_REC',(select dflt_privilege_status from  ca_appl_task ##REPDB## where APPL_TASK_ID = 'CA_CHART_REC'),'CA','','"+facilityId+"','"+episode_id+"','"+patient_id+"') ca_chart_rec_status from dual";//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1

				/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
				sqlFinal = sql.toString();
				sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
				/*End*/
			  	pstmt   = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
			  	rset    = pstmt.executeQuery();
				while(rset!=null && rset.next()){
					ca_chart_rec_status		= (rset.getString("ca_chart_rec_status")==null || rset.getString("ca_chart_rec_status")=="")?"":rset.getString("ca_chart_rec_status");
				}
				if(pstmt!=null) pstmt.close();
				if(rset!=null) rset.close();
			
				sql="select get_task_applicability ##REPDB##('CLINICAL_NOTES',(select dflt_privilege_status from  ca_appl_task ##REPDB## where APPL_TASK_ID = 'CLINICAL_NOTES'),'CA','','"+facilityId+"','"+episode_id+"','"+patient_id+"') clinical_notes_status from dual";//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				
				/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
				sqlFinal = sql.toString();
				sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
				/*End*/
			  	pstmt   = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
			  	rset    = pstmt.executeQuery();
				while(rset!=null && rset.next()){
					clinical_notes_status		= (rset.getString("clinical_notes_status")==null || rset.getString("clinical_notes_status")=="")?"":rset.getString("clinical_notes_status");
				}
				if(pstmt!=null) pstmt.close();
				if(rset!=null) rset.close();
				/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 7th 2014 End*/
				
			
			}
		          
	  StringBuffer sqlarea = new StringBuffer();
	  sqlarea.append("select LONG_DESC from mp_res_town_lang_vw ##REPDB## where  language_id='"+locale+"'  and res_town_code=?");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
		
	/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
	sqlFinal = sqlarea.toString();
	sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
	/*End*/
	  pstmt1 = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
      pstmt1.setString(1,disaster_town_code);
	   
	  rset1 = pstmt1.executeQuery();
	  
		 while(rset1!=null && rset1.next())
		 {
		 dis_area = rset1.getString("LONG_DESC");
		 }
		 if(rset1!=null) rset1.close();
		 if(pstmt1!=null) pstmt1.close();
		 if((sqlarea != null) && (sqlarea.length() > 0))
		 {
			sqlarea.delete(0,sqlarea.length());
		 }


     /**  If CA Installed New Tab Other Details Added on 03/02/2005 **/ 
%>

		 <%
				
				  StringBuffer sqlComplaint1 = new StringBuffer();
	              sqlComplaint1.append("select COMPLAINT_DESC from AM_COMPLAINT_LANG_VW ##REPDB## where  language_id='"+locale+"'  and COMPLAINT_CODE=?");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				
				/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
				sqlFinal = sqlComplaint1.toString();
				sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
				/*End*/
				  pstmt1 = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				  pstmt1.setString(1,complaint_code);
				   
				  rset1 = pstmt1.executeQuery();
				    
					 while(rset1!=null && rset1.next())
					 {
					 complaint = rset1.getString("COMPLAINT_DESC")==null?"":rset1.getString("COMPLAINT_DESC");
					 }
					 if(rset1!=null) rset1.close();
					 if(pstmt1!=null) pstmt1.close();
					 if((sqlComplaint1 != null) && (sqlComplaint1.length() > 0))
					 {
						sqlComplaint1.delete(0,sqlComplaint1.length());
					 }
				 

					//Added By Krishna Pranay regarding ML-MMOH-CRF-1759.1 start
					 pstmt1 = con.prepareStatement("SELECT INVOKE_MENSTRUAL_HISTORY_YN FROM MP_PARAM");
					 rset1 = pstmt1.executeQuery();
					    if (rset1.next()){
					    	invokeMenstrualHistYN = rset1.getString("INVOKE_MENSTRUAL_HISTORY_YN");
					    }
					    if(pstmt1!=null) pstmt1.close();
					    if(rset1!=null) rset1.close();	
					
					 
					   pstmt1 = con.prepareStatement("SELECT EVENT_STATUS FROM ( SELECT EVENT_STATUS, ROW_NUMBER() OVER (ORDER BY ADDED_DATE DESC) AS rn FROM CA_MENS_HIS_TRANS_DTL WHERE PATIENT_ID = ? ) ranked WHERE rn = 1");
					   pstmt1.setString(1, patient_id);
					   rset1 = pstmt1.executeQuery();
					   if (rset1.next()){
					   latestMensDtlStatus = rset1.getString("EVENT_STATUS")==null?"":rset1.getString("EVENT_STATUS");
					   }
					   if(pstmt1!=null) pstmt1.close();
					   if(rset1!=null) rset1.close();	 
					   
					   
					   if ("Y".equals(invokeMenstrualHistYN) && "A".equals(latestMensDtlStatus)) {
							rec_view_lmp_details_label = "eMP.ViewModifyMenstrualHistoryDetails.label";
							MensdisabledPre=disabled;
					   }
					   else
					   {
						   rec_view_lmp_details_label = "eMP.RecordMenstrualHistoryDetails.label";
					   }
					 //Added By Krishna Pranay regarding ML-MMOH-CRF-1759.1 end
			  %>

 <body OnMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad='clearBed();enableMandatory();'>
	
 
 <form name='AESecondaryTriage_form' id='AESecondaryTriage_form' action='../../servlet/eAE.AESecondaryTriageServlet' method='post' target='messageFrame' >
<input type='hidden' name='diabled_pract' id='diabled_pract' value='<%=dis16%>'> <!--Added CRF AAKH-CRF-0010 [IN038535] -->
 <%
if(!function_id.equals("query"))
{%>

<jsp:include page="../../eAE/jsp/AESecondaryTriageInclude.jsp" ><jsp:param name="flush" value="true" />	 	

	<jsp:param name="ca_install_yn"  value='<%=ca_install_yn%>'/> 
	<jsp:param name="isSecTrgBackDateTimeAppl"  value='<%=isSecTrgBackDateTimeAppl%>'/> 
	<jsp:param name="sys_date_time"  value='<%=sys_date_time%>'/> 
	<jsp:param name="dis_triage_record_date_time"  value='<%=dis_triage_record_date_time%>'/> 
	<jsp:param name="VisitProp"  value='<%=VisitProp%>'/> 
	<jsp:param name="EncounterProp"  value='<%=EncounterProp%>'/> 
	<jsp:param name="facilityId"  value='<%=facilityId%>'/> 
	<jsp:param name="RepDb"  value='<%=RepDb%>'/> 
	<jsp:param name="sqlDate"  value='<%=sqlDate%>'/> 
	<jsp:param name="priority"  value='<%=priority%>'/> 
	<jsp:param name="five_level_triage_appl_yn"  value='<%=five_level_triage_appl_yn%>'/> 
	<jsp:param name="isPriorityZoneAppl"  value='<%=isPriorityZoneAppl%>'/> 
	<jsp:param name="disPriority"  value='<%=disPriority%>'/> 
	<jsp:param name="optSelected"  value='<%=optSelected%>'/> 
	<jsp:param name="priorityStatus1"  value='<%=priorityStatus1%>'/> 
	<jsp:param name="priorityStatus2"  value='<%=priorityStatus2%>'/> 
	<jsp:param name="priorityStatus3"  value='<%=priorityStatus3%>'/> 
	<jsp:param name="disabled111"  value='<%=disabled111%>'/> 
	<jsp:param name="disabled11"  value='<%=disabled11%>'/> 
	<jsp:param name="disabled12"  value='<%=disabled12%>'/> 
	<jsp:param name="disabled13"  value='<%=disabled13%>'/> 
	<jsp:param name="red"  value='<%=red%>'/> 
	<jsp:param name="yellow"  value='<%=yellow%>'/> 
	<jsp:param name="green"  value='<%=green%>'/> 
	<jsp:param name="prioritynewdisabled"  value='<%=prioritynewdisabled%>'/> 
	<jsp:param name="priority_zone_code"  value='<%=priority_zone_code%>'/> 
	<jsp:param name="priority_zone_desc"  value='<%=priority_zone_desc%>'/> 
	<jsp:param name="priority_zone_order"  value='<%=priority_zone_order%>'/> 
	<jsp:param name="priority_zone_color"  value='<%=priority_zone_color%>'/> 
	<jsp:param name="priority_zone_hidden_fileds"  value='<%=priority_zone_hidden_fileds%>'/> 
	<jsp:param name="priority_selected"  value='<%=priority_selected%>'/> 
	<jsp:param name="priority_no"  value='<%=priority_no%>'/> 
	<jsp:param name="dis_regn_ref"  value='<%=dis_regn_ref%>'/> 
	<jsp:param name="disaster_category_yn"  value='<%=disaster_category_yn%>'/> 
	<jsp:param name="disaster_type_code"  value='<%=disaster_type_code%>'/> 
	<jsp:param name="sqlAmbulatory"  value='<%=sqlAmbulatory%>'/> 
	<jsp:param name="AmbulatorySql"  value='<%=AmbulatorySql%>'/>
	 
	<jsp:param name="modify_flag"  value='<%=modify_flag%>'/> 
	<jsp:param name="modifyYN"  value='<%=modifyYN%>'/> 
	<jsp:param name="dis_area"  value='<%=dis_area%>'/> 
	<jsp:param name="display_triage_record_date_time"  value='<%=display_triage_record_date_time%>'/> 
	<jsp:param name="encounter_id"  value='<%=encounter_id%>'/> 
	<jsp:param name="locale"  value='<%=locale%>'/> 
	<jsp:param name="priority_code"  value='<%=priority_code%>'/> 
	<jsp:param name="queue_appl_priority_zone"  value='<%=queue_appl_priority_zone%>'/> 
	<jsp:param name="queue_max_num_allowed"  value='<%=queue_max_num_allowed%>'/> 
	<jsp:param name="queue_no"  value='<%=queue_no%>'/> 
	<jsp:param name="dis_queue_no"  value='<%=dis_queue_no%>'/> 
	<jsp:param name="queue_num_mandatory"  value='<%=queue_num_mandatory%>'/> 
	<jsp:param name="patient_id"  value='<%=patient_id%>'/> 
	<jsp:param name="clinic_code"  value='<%=clinic_code%>'/> 
	<jsp:param name="patient_gender"  value='<%=patient_gender%>'/> 
	<jsp:param name="treat_code"  value='<%=treat_code%>'/> 
	<jsp:param name="optSelectedTreat"  value='<%=optSelectedTreat%>'/> 
	<jsp:param name="disTreatArea"  value='<%=disTreatArea%>'/> 
	<jsp:param name="bed_no"  value='<%=bed_no%>'/> 
	<jsp:param name="disBed"  value='<%=disBed%>'/> 
	<jsp:param name="bedBed1"  value='<%=disBed1%>'/> 
	<jsp:param name="checked1"  value='<%=checked1%>'/> 
	<jsp:param name="checked2"  value='<%=checked2%>'/> 
	<jsp:param name="checked3"  value='<%=checked3%>'/> 
	<jsp:param name="checked5"  value='<%=checked5%>'/> 
	<jsp:param name="checked6"  value='<%=checked6%>'/> 
	<jsp:param name="checked7"  value='<%=checked7%>'/> 
	<jsp:param name="checked9"  value='<%=checked9%>'/> 
	<jsp:param name="disDisaster"  value='<%=disDisaster%>'/> 
	<jsp:param name="visit_date"  value='<%=visit_date%>'/> 
	<jsp:param name="dis1"  value='<%=dis1%>'/> 
	<jsp:param name="dis2"  value='<%=dis2%>'/> 
	<jsp:param name="dis3"  value='<%=dis3%>'/> 
	<jsp:param name="dis5"  value='<%=dis5%>'/> 
	<jsp:param name="dis7"  value='<%=dis7%>'/> 
	<jsp:param name="dis16"  value='<%=dis16%>'/> 
	<jsp:param name="disMed"  value='<%=disMed%>'/> 
	<jsp:param name="disMLC"  value='<%=disMLC%>'/> 
	<jsp:param name="disSur"  value='<%=disSur%>'/> 
	<jsp:param name="disOandGYn"  value='<%=disOandGYn%>'/> 
	<jsp:param name="disOscc"  value='<%=disOscc%>'/> 
	<jsp:param name="disable3"  value='<%=disable3%>'/> 
	<jsp:param name="a_status"  value='<%=a_status%>'/> 
	<jsp:param name="leveloftriage_visibility"  value='<%=leveloftriage_visibility%>'/> 
	<jsp:param name="attend_practitioner_name"  value='<%=attend_practitioner_name%>'/> 
	<jsp:param name="attend_practitioner_id"  value='<%=attend_practitioner_id%>'/> 
	<jsp:param name="transport_mode_code"  value='<%=transport_mode_code%>'/> 
	<jsp:param name="accompanied_by_code"  value='<%=accompanied_by_code%>'/> 
	<jsp:param name="accompanied_by_dis"  value='<%=accompanied_by_dis%>'/> 
	<jsp:param name="pat_dtls_unknown_yn"  value='<%=pat_dtls_unknown_yn%>'/> 
	<jsp:param name="referral_id"  value='<%=referral_id%>'/> 
	<jsp:param name="disRefID"  value='<%=disRefID%>'/> 
	<jsp:param name="complaint"  value='<%=complaint%>'/> 
	<jsp:param name="triage_remarks"  value='<%=triage_remarks%>'/> 
	<jsp:param name="checkedMed"  value='<%=checkedMed%>'/> 
	<jsp:param name="checkedSur"  value='<%=checkedSur%>'/> 
	<jsp:param name="checkedOandGYn"  value='<%=checkedOandGYn%>'/> 
	<jsp:param name="oscc_yn"  value='<%=oscc_yn%>'/> 
	<jsp:param name="medical_yn"  value='<%=medical_yn%>'/> 
	<jsp:param name="surgical_yn"  value='<%=surgical_yn%>'/> 
	<jsp:param name="queue_secondary_triage"  value='<%=queue_secondary_triage%>'/> 
	<jsp:param name="disaster_category_code"  value='<%=disaster_category_code%>'/> 
	<jsp:param name="disaster_category_yn"  value='<%=disaster_category_yn%>'/> 
	<jsp:param name="called_from_ca"  value='<%=called_from_ca%>'/> 

	<jsp:param name="caseType"  value='<%=caseType%>'/> 
	<jsp:param name="caseTypeDisable"  value='<%=caseTypeDisable%>'/> 
	<jsp:param name="caseTypeMandYn"  value='<%=caseTypeMandYn%>'/> 
	<jsp:param name="caseTypeYn"  value='<%=caseTypeYn%>'/> 
	<jsp:param name="date_time_of_accident"  value='<%=date_time_of_accident%>'/> 
	<jsp:param name="localeName"  value='<%=localeName%>'/> 
	
	<jsp:param name="disDateAcci"  value='<%=disDateAcci%>'/> 
	<jsp:param name="place_of_accident"  value='<%=place_of_accident%>'/> 
	<jsp:param name="disPlaceAcci"  value='<%=disPlaceAcci%>'/> 
	<jsp:param name="dis6"  value='<%=dis6%>'/> 
	<jsp:param name="dis8"  value='<%=dis8%>'/> 
	<jsp:param name="dis9"  value='<%=dis9%>'/> 
	<jsp:param name="dis10"  value='<%=dis10%>'/> 
	<jsp:param name="dis11"  value='<%=dis11%>'/> 
	<jsp:param name="dis12"  value='<%=dis12%>'/> 
	<jsp:param name="dis13"  value='<%=dis13%>'/> 
	<jsp:param name="mech_injury_subcatg_code"  value='<%=mech_injury_subcatg_code%>'/> 
	<jsp:param name="vehicle_invlovedcode"  value='<%=vehicle_invlovedcode%>'/> 
	<jsp:param name="Vehicle_Reg_No1"  value='<%=Vehicle_Reg_No1%>'/> 
	<jsp:param name="protective_device_code"  value='<%=protective_device_code%>'/> 
	<jsp:param name="pat_position_code"  value='<%=pat_position_code%>'/> 
	<jsp:param name="MLC_DEATH_YN"  value='<%=MLC_DEATH_YN%>'/> 
	<jsp:param name="disMLCDeath"  value='<%=disMLCDeath%>'/> 
	<jsp:param name="pol_rep_no_mx_size"  value='<%=pol_rep_no_mx_size%>'/> 
	<jsp:param name="pol_stn_det_mx_size"  value='<%=pol_stn_det_mx_size%>'/> 
	<jsp:param name="police_station_dtls"  value='<%=police_station_dtls%>'/> 
	<jsp:param name="police_rep_no"  value='<%=police_rep_no%>'/> 
	<jsp:param name="MLC_NO_OUTSIDE_DTLS"  value='<%=MLC_NO_OUTSIDE_DTLS%>'/> 
	<jsp:param name="disOutMLCDet"  value='<%=disOutMLCDet%>'/> 
	<jsp:param name="MLC_CAPTURE_DATE"  value='<%=MLC_CAPTURE_DATE%>'/> 
	<jsp:param name="disDateOfCapt"  value='<%=disDateOfCapt%>'/> 
	<jsp:param name="disMLCRemark"  value='<%=disMLCRemark%>'/> 
	<jsp:param name="MLC_REMARKS"  value='<%=MLC_REMARKS%>'/> 
	<jsp:param name="initialMgmtLblName"  value='<%=initialMgmtLblName%>'/> 
	<jsp:param name="order_catalog_code1"  value='<%=order_catalog_code1%>'/> 
	<jsp:param name="order_catalog_code2"  value='<%=order_catalog_code2%>'/> 
	<jsp:param name="order_catalog_code3"  value='<%=order_catalog_code3%>'/> 
	<jsp:param name="order_catalog_code4"  value='<%=order_catalog_code4%>'/> 
	<jsp:param name="order_catalog_code5"  value='<%=order_catalog_code5%>'/> 
	<jsp:param name="order_catalog_code6"  value='<%=order_catalog_code6%>'/> 
	<jsp:param name="FBCProp"  value='<%=FBCProp%>'/> 
	<jsp:param name="ECGProp"  value='<%=ECGProp%>'/> 
	<jsp:param name="DressProp"  value='<%=DressProp%>'/> 
	<jsp:param name="SpO2Prop"  value='<%=SpO2Prop%>'/> 
	<jsp:param name="dressingLblName"  value='<%=dressingLblName%>'/> 
	<jsp:param name="intialMgmtOthers"  value='<%=intialMgmtOthers%>'/> 
	<jsp:param name="disIntialMgmtOthers"  value='<%=disIntialMgmtOthers%>'/> 
	<jsp:param name="disImmobil"  value='<%=disImmobil%>'/> 
	<jsp:param name="immobilization"  value='<%=immobilization%>'/> 
	<jsp:param name="dis14"  value='<%=dis14%>'/> 
	<jsp:param name="dis15"  value='<%=dis15%>'/> 
	<jsp:param name="selected"  value='<%=selected%>'/> 
	<jsp:param name="selected1"  value='<%=selected1%>'/> 
	<jsp:param name="selected2"  value='<%=selected2%>'/> 
	<jsp:param name="checked4"  value='<%=checked4%>'/> 
	<jsp:param name="checked8"  value='<%=checked8%>'/> 
	<jsp:param name="patient_age"  value='<%=patient_age%>'/> 
	<jsp:param name="max_age_paediatric"  value='<%=max_age_paediatric%>'/> 
	<jsp:param name="min_age_pregnancy"  value='<%=min_age_pregnancy%>'/> 
	<jsp:param name="sex"  value='<%=sex%>'/> 
	<jsp:param name="pediatric_status"  value='<%=pediatric_status%>'/> 
	<jsp:param name="disabled991"  value='<%=disabled991%>'/> 
	<jsp:param name="disImm"  value='<%=disImm%>'/> 
	<jsp:param name="disMenarche"  value='<%=disMenarche%>'/> 
	<jsp:param name="disHeight"  value='<%=disHeight%>'/> 
	<jsp:param name="disWeight"  value='<%=disWeight%>'/> 
	<jsp:param name="height"  value='<%=height%>'/> 
	<jsp:param name="weight"  value='<%=weight%>'/> 
	<jsp:param name="circumference"  value='<%=circumference%>'/> 
	<jsp:param name="capBloodSugProp"  value='<%=capBloodSugProp%>'/> 
	<jsp:param name="cbdProp"  value='<%=cbdProp%>'/> 
	<jsp:param name="medication"  value='<%=medication%>'/> 
	<jsp:param name="disMedication"  value='<%=disMedication%>'/> 
	<jsp:param name="capBloodSugProp"  value='<%=capBloodSugProp%>'/> 
	<jsp:param name="fbccheck"  value='<%=fbccheck%>'/> 
	<jsp:param name="fbccheck_val"  value='<%=fbccheck_val%>'/> 
	<jsp:param name="disCir"  value='<%=disCir%>'/> 
	<jsp:param name="disabled"  value='<%=disabled%>'/> 
	<jsp:param name="menstrual_status"  value='<%=menstrual_status%>'/> 
	<jsp:param name="disabledPre"  value='<%=disabledPre%>'/> 
	<jsp:param name="min_age_for_lmp"  value='<%=min_age_for_lmp%>'/> 
	<jsp:param name="year_value"  value='<%=year_value%>'/> 
	<jsp:param name="minageforlmp"  value='<%=minageforlmp%>'/> 
	<jsp:param name="lmp_date"  value='<%=lmp_date%>'/> 
	<jsp:param name="clinical_notes_status"  value='<%=clinical_notes_status%>'/> 
	<jsp:param name="episode_id"  value='<%=episode_id%>'/> 
	<jsp:param name="patient_class"  value='<%=patient_class%>'/> 
	<jsp:param name="loginUser"  value='<%=loginUser%>'/> 
	<jsp:param name="ca_chart_rec_status"  value='<%=ca_chart_rec_status%>'/> 
	<jsp:param name="sys_date_qry"  value='<%=sys_date_qry%>'/> 
	<jsp:param name="sqlPosition"  value='<%=sqlPosition%>'/> 
	<jsp:param name="Vehicle_Reg_No2"  value='<%=Vehicle_Reg_No2%>'/> 
	<jsp:param name="vehicle_invlovedcode1"  value='<%=vehicle_invlovedcode1%>'/> 
	<jsp:param name="mech_injr_code"  value='<%=mech_injr_code%>'/> 
	<jsp:param name="PositionSql"  value='<%=PositionSql%>'/> 
	<jsp:param name="invokeMenstrualHistYN"  value='<%=invokeMenstrualHistYN%>'/><!-- Added by krishna Pranay ML-MMOH-CRF-1759.1 -->
	<jsp:param name="latestMensDtlStatus"  value='<%=latestMensDtlStatus%>'/><!-- Added by krishna Pranay ML-MMOH-CRF-1759.1 -->
	<jsp:param name="rec_view_lmp_details_label"  value='<%=rec_view_lmp_details_label%>'/><!-- Added by krishna Pranay ML-MMOH-CRF-1759.1 -->
	<jsp:param name="function_id"  value='<%=function_id%>'/><!-- Added by krishna Pranay ML-MMOH-CRF-1759.1 -->
	<jsp:param name="MensdisabledPre"  value='<%=MensdisabledPre%>'/><!-- Added by krishna Pranay ML-MMOH-CRF-1759.1 -->
	

</jsp:include>

<%}
else
 {
%>

<div id='Triage_Details'>
	 <table cellspacing='0' cellpadding='0' width='100%' border=0 align='center'>
            <tr><td class='white'>

		<ul id="tablist" class="tablist" >
			<li class="tablistitem" title="Triage Details">
				<a  class="tabClicked" id='Triage_Details_tab' >
					<span class="tabSpanclicked" onClick='javascript:expandCollapse("Triage_Details_tab")' id="Triage_tabspan"><fmt:message key="Common.TriageDetails.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			<%if(ca_install_yn.equals("Y")){%>
			<li class="tablistitem" title="Assessment">
				<a class="tabA" id='Assessment_tab' >
					<span class="tabAspan" onClick='javascript:expandCollapse("Assessment_tab")' id="assess_tabspan"><fmt:message key="Common.Assessment.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			<%}%> 
		</ul>
    </td></tr>
    </table>
	<table cellspacing='0' cellpadding='0' width='100%' border=0 align='center'>
      <tr><td class='white'>
			<ul id="tablist" class="tablist">
				<li class="tablistitem" title="Condition / Case">
					<a  class="tabClicked" id="Condition_tab" >
						<span class="tabSpanclicked" onClick='javascript:expandCollapse("Condition_tab")' id="patCond_tabspan"><fmt:message key="eAE.ConditionCase.label" bundle="${ae_labels}"/></span>
					</a>
				</li>
				<!--Added by Thamizh selvi on 10th Apr 2018 against ML-MMOH-CRF-0655 Start-->
				<% if(isChngBtnPositionAppl){ %>
				<li class="tablistitem" title="Allergy Details">
					<a  class="tabA" id="allergy_dtls" >
						<span class="tabAspan" onClick='javascript:expandCollapse("allergy_dtls")' id="allergyDtls_tabspan"><fmt:message key="Common.AllergyDetails.label" bundle="${common_labels}"/></span>
					</a>
				</li>
				<% } %><!--End-->
				<li class="tablistitem" title="Others">
					<a class="tabA" id="others_tab" >
						<span class="tabAspan" onClick='javascript:expandCollapse("others_tab")' id="others_tabspan"><fmt:message key="Common.others.label" bundle="${common_labels}"/></span>
					</a>
				</li>
			</ul>
       </td></tr>
</table>
<!--Added by k v shanmukh on 2nd-Apr-2018 against ML-MMOH-CRF-0656 Start-->
<%if(isSecTrgBackDateTimeAppl){%>
<table border="0" cellpadding="0" cellspacing="0" align='center' width='100%'>
	<tr>
		<td class='LABEL'   width='25%' ><fmt:message key="eAE.Triage.label" bundle="${common_labels}"/> <fmt:message key="Common.datetime.label" bundle="${common_labels}"/></td> 
		<% if(display_triage_record_date_time.equals("")){%>
			<td class='fields' width='34%' tabindex='<%=++tindex%>'>
			<input type='text'  id='triage_record_date_time1' name='triage_record_date_time1' id='triage_record_date_time1' value="<%=sys_date_time%>" maxLength='19' size='16' tabindex=''onBlur='triageRecordDate(this);'<%=dis_triage_record_date_time%>>
			<img src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('triage_record_date_time1', null, 'hh:mm:ss' );" style='cursor:pointer'   /> <img src='../../eCommon/images/mandatory.gif' ></img>
			</td>
		<%}else {%>
			<td class='fields' width='34%' tabindex='<%=++tindex%>'>
			<input type='text'  id='triage_record_date_time1' name='triage_record_date_time1' id='triage_record_date_time1' value="<%=display_triage_record_date_time%>" maxLength='19' size='16' tabindex=''<%=dis_triage_record_date_time%>>
			</td>
		<%}%>
		<!--Added by Thamizh selvi on 9th Apr 2018 against ML-MMOH-CRF-0655 Start-->
		<% if(isChngBtnPositionAppl){ %>
			<td class='fields' width='20%' tabindex='<%=++tindex%>'>
				<input type="button" name="visit_24hr" id="visit_24hr" class="BUTTON" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.VisitWithin24Hrs.label","ae_labels")%>' onClick="showLastVisitDetails('LastVisit24');" <%=VisitProp%>>
			</td>
			<td class='fields' width='21%' tabindex='<%=++tindex%>'>
				<input type="button" name="PrevEncounter" id="PrevEncounter" class="BUTTON" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PreviousEncounters.label","common_labels")%>' onClick="showPrevEncounter();"  <%=EncounterProp%> >
			</td>
		<% } %>
		<!--End-->
	</tr>
</table>
<%}else if(isChngBtnPositionAppl){ %><!--Added by Thamizh selvi on 9th Apr 2018 against ML-MMOH-CRF-0655 Start-->
<table border="0" cellpadding="0" cellspacing="0" align='center' width='100%'>
	<tr>
		<td colspan='2'>&nbsp;</td>
		<td class='fields' width='15%' tabindex='<%=++tindex%>'>
			<input type="button" name="visit_24hr" id="visit_24hr" class="BUTTON" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.VisitWithin24Hrs.label","ae_labels")%>' onClick="showLastVisitDetails('LastVisit24');" <%=VisitProp%>>
		</td>
		<td class='fields' width='15%' tabindex='<%=++tindex%>'>
			<input type="button" name="PrevEncounter" id="PrevEncounter" class="BUTTON" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PreviousEncounters.label","common_labels")%>' onClick="showPrevEncounter();"  <%=EncounterProp%> >
		</td>
	</tr>
</table>
<% } %>
<!--End-->	
	
	<%
	
			String secTrgRecDateTimeList=eAE.AECommonBean.getAETrgRecDateTime(con,facilityId,encounter_id,RepDb);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1	 	
	%>
	<input type='hidden' name='secTrgRecDateTimeList' id='secTrgRecDateTimeList' value='<%=secTrgRecDateTimeList%>'>
	
<table border="0" cellpadding="2" cellspacing="0" align='center' width='100%'>
      <input type='hidden' name='sysdate' id='sysdate' value='<%=sqlDate%>'>
	  <tr>
		<td class='COLUMNHEADER' colspan='4' ><fmt:message key="Common.PatientCondition.label" bundle="${common_labels}"/></td>
	  </tr>

     <tr><input type="hidden" name='hddpriority' id='hddpriority'value=<%=priority%>>
              <td class='label' width='25%' ><fmt:message key="Common.PriorityZone.label" bundle="${common_labels}"/></td>
	    <%/*Below Condition Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 28th 2014*/
		if(!five_level_triage_appl_yn.equals("Y")){%>
	          <%
		  
		  if(isPriorityZoneAppl){%><!--Added by Shanmukh on 10th-SEPT-2018 for MMS-DM-CRF-0147-->
		  <td class='fields' width='25%'>
			<select name='Priority_Zone_Type' id='Priority_Zone_Type' onchange='setPriority(this);setTreatment(this);'<%=disPriority%>>
			<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------
						
		<%
		try{
		sql2="SELECT PRIORITY_ZONE,PRIORITY_ZONE_DESC FROM AE_PRIORITY_ZONE_LANG_VW WHERE LANGUAGE_ID= ? and EFF_STATUS='E' and PRIORITY_ZONE not in('B','W') order by PRIORITY_ZONE_ORDER";
				
			    pstmt   = con.prepareStatement(sql2);
				pstmt.setString(1,locale) ;
				rset    = pstmt.executeQuery();
				 while(rset!=null && rset.next())
				{
					if(rset.getString("PRIORITY_ZONE").equals(priority))
							   {
                                    optSelected="selected";
							   }
							   else
								   optSelected="";
							   
					out.println("<option value='"+rset.getString("PRIORITY_ZONE")+"'"+optSelected+">"+rset.getString("PRIORITY_ZONE_DESC")+""); 
				}
		    }catch(Exception e){e.printStackTrace();}
						%>
					</select>
			</td>
		  <%}else{%>	
	     <% if(!five_level_triage_appl_yn.equals("Y")){%>     
	          <td class='label'   width='25%' >	<%=red%><input type="checkbox" name='priorityR' id='priorityR'   onClick='setPriority(this);setTreatment(this);' <%=priorityStatus1%> <%=disabled111%>> </td>
			  <td class='label'   width='25%' ><%=yellow%><input type="checkbox" name='priorityY' id='priorityY'    onClick='setPriority(this);setTreatment(this);' <%=priorityStatus2%> <%=disabled12%>></td> 
			  <td class='label'   width='25%' ><%=green%><input type="checkbox" name='priorityG' id='priorityG' <%=priorityStatus3%> onClick='setPriority(this);setTreatment(this);'<%=disabled13%>></td>
		<%}else{%>
			  <td class='fields'   width='25%' tabindex='<%=++tindex%>'>
	  		  <select name='prioritynew' id='prioritynew' id='prioritynew' style='' onchange='setPriority(this.value);setTreatment(this);' <%=prioritynewdisabled%>> 
	    		<option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------
	    		<% 
	    		String sql1="SELECT PRIORITY_ZONE,PRIORITY_ZONE_DESC,PRIORITY_ZONE_COLOR,PRIORITY_ZONE_ORDER FROM AE_PRIORITY_ZONE_LANG_VW ##REPDB## WHERE LANGUAGE_ID=? and EFF_STATUS='E' order by PRIORITY_ZONE_ORDER asc";//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
				sqlFinal = sql1.toString();
				sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
				/*End*/
				pstmt   = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				pstmt.setString(1,locale) ;
				rset1    = pstmt.executeQuery();
				while(rset1!=null && rset1.next()){
					priority_zone_code	= rset1.getString("PRIORITY_ZONE");
					priority_zone_desc	= rset1.getString("PRIORITY_ZONE_DESC");
					priority_zone_order	=(rset1.getString("PRIORITY_ZONE_ORDER")==null || rset1.getString("PRIORITY_ZONE_ORDER")=="")?"":rset1.getString("PRIORITY_ZONE_ORDER");
					priority_zone_color = (rset1.getString("PRIORITY_ZONE_COLOR")==null || rset1.getString("PRIORITY_ZONE_COLOR")=="")?"":rset1.getString("PRIORITY_ZONE_COLOR");
					priority_zone_hidden_fileds	= priority_zone_hidden_fileds+"<input type='hidden' name='priority_zone_order_by_"+priority_zone_code+"' id='priority_zone_order_by_"+priority_zone_code+"' value='"+priority_zone_order+"'>";
					if(priority.equals(priority_zone_code)){
						priority_selected	= "selected";
						priority_no			= priority_zone_order;
					}else{
						priority_selected	= "";
					}
				%>
					<option value='<%=priority_zone_code%>' style='background-color:<%=priority_zone_color%>;' <%=priority_selected%>><%=priority_zone_desc%></option>
				
				<%}%>
	  	  </select><%if(prioritynewdisabled.equals("")){ %><img align='center' src='../../eCommon/images/mandatory.gif'></img><%}%>
	  	  </td>
	    <%
		 if(rset1!=null) rset1.close();
		 if(pstmt1!=null) pstmt1.close();
	    	
	    } %>		  
		            </tr>  
					<tr> 
					<td class='label' width='25%' > <fmt:message key="Common.priority.label" bundle="${common_labels}"/> </td> 
					 <td class='fields' width='25%' ><select name='priority11' id='priority11' tabindex='65' <%=disPriority%>>
					 <option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------
                  <%
					   
                       StringBuffer sqlpriority = new StringBuffer();
					   sqlpriority.append("select PRIORITY_CODE,SHORT_DESC from ");
					   sqlpriority.append("ae_pat_priority_lang_vw ##REPDB## where language_id='"+locale+"'  and PRIORITY_ZONE=? and EFF_STATUS='E'");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
	                     	
					   /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
						sqlFinal = sqlpriority.toString();
						sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
						/*End*/
						 pstmt = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
						 pstmt.setString(1,priority);
					     rset = pstmt.executeQuery();
						 
						 while(rset!=null && rset.next())
						   {
							   if(rset.getString(1).equals(priority_code))
							   {
                                    optSelected="selected";
							   }
							   else
								   optSelected="";

							   out.println("<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+" ");
							  
						   }
						 if(pstmt!=null) pstmt.close();
						 if(rset!=null) rset.close();
						 if((sqlpriority != null) && (sqlpriority.length() > 0))
						 {
							sqlpriority.delete(0,sqlpriority.length());
						 }
					   %>  
					</select>
		  </td>
		  
		  
		  <!-- 	Added by Ajay Hatwate for ML-MMOH-2069  -->
		            
		             <%
		             //System.out.println(isSecondaryTriageQueueNum + " isSecondaryTriageQueueNum ");
		             if(priority.equals(queue_appl_priority_zone)){
		            	 dis_queue_no = " ";
		             }
		             if(isSecondaryTriageQueueNum && queue_secondary_triage.equals("Y")){ %>
		             <%-- <input type='hidden' name='queue_appl_priority_zone' id='queue_appl_priority_zone' value='<%=queue_appl_priority_zone %>' >
		             <input type='hidden' name='queue_num_mandatory' id='queue_num_mandatory' value='<%=queue_num_mandatory %>' > --%>
		             <td class='label' width='25%' > <fmt:message key="Common.QueueNo.label" bundle="${common_labels}"/> </td> 
					 <td class='fields' width='25%' ><input type='number' id='queue_no1' name='queue_no1' id='queue_no1' onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='validateQueueNo(this)' maxLength='16' size='16' value='<%=queue_no %>' tabindex='66' <%=dis_queue_no %>>
		             <% 
		             String queue_no_mand_img_dis = " disabled ";
					 if(queue_num_mandatory.equals("Y") && !modify_flag.equals("Y") && !priority.equals("U")){ 
						 queue_no_mand_img_dis = " ";
					 }%> 
		             <img src='../../eCommon/images/mandatory.gif' id='queue_no_mand_img' align='center' style='visibility:hidden' ></img>
		             <%
		             
		             int ex_queue_count = 0;
		             StringBuffer sqlTreatA = new StringBuffer();
					 sqlTreatA.append(" select count(*) count from  ae_queue_no_audit where PATIENT_ID=?  and encounter_id=? order by ADDED_DATE desc ");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
					/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
					sqlFinal = sqlTreatA.toString();
					sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
					/*End*/
					 pstmt = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
					 pstmt.setString(1,patient_id);
					 pstmt.setString(2,encounter_id);
					
					 rset = pstmt.executeQuery();
					 
					 while(rset!=null && rset.next())
					   {
						 ex_queue_count =rset.getInt("count");
						}
					 if(pstmt!=null) pstmt.close();
					 if(rset!=null) rset.close();
					 if((sqlTreatA != null) && (sqlTreatA.length() > 0))
					 {
						sqlTreatA.delete(0,sqlTreatA.length());
					 }
		             
		             
		             if(ex_queue_count > 1){ %>
		             
		             <input type=button class=button value='<fmt:message key="Common.AuditTrail.label" bundle="${common_labels}"/>' onClick="callSecQueueAudit();">
		             
		             <% }
		             
		             
		             } %>
		             <!-- End of ML-MMOH-CRF-2069 -->
		  
		  
					  </tr> 
		   
		<tr> 
		
			  <td class='LABEL'  width='25%' ><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/></td>
			  <td class='fields' width='25%' tabindex='<%=++tindex%>'>
			   <%
			     
		        
				 StringBuffer sqlTreatA = new StringBuffer();
				 sqlTreatA.append("SELECT treatment_area_code, short_desc FROM ae_tmt_area_for_clinic_lang_vw ##REPDB## WHERE language_id='"+locale+"'  and facility_id = ? AND clinic_code = ?  AND priority_zone = ?  AND  (gender = ? OR gender IS NULL) ");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
				sqlFinal = sqlTreatA.toString();
				sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
				/*End*/
				 pstmt = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				 pstmt.setString(1,facilityId);
				 pstmt.setString(2,clinic_code);
				 pstmt.setString(3,priority);
				 pstmt.setString(4,patient_gender);
				
				 rset = pstmt.executeQuery();
				 
				 while(rset!=null && rset.next())
				   {
					 String code =rset.getString(1);
					 String desc =specialCharacter(rset.getString(2));
					 if (code.equals("null") || code==null) 
						 code="";
					  if (desc.equals("null") || desc==null) 
						 desc="";
					  if(code.equals(treat_code))
					   {
							optSelectedTreat="selected";
					   }
					   else
						   optSelectedTreat="";
			   
					   sbBuff.append("<option value=\""+code+"\" "+optSelectedTreat+">"+desc+"</option>");
				  }
				 if(pstmt!=null) pstmt.close();
				 if(rset!=null) rset.close();
				 if((sqlTreatA != null) && (sqlTreatA.length() > 0))
				 {
					sqlTreatA.delete(0,sqlTreatA.length());
				 }
				 
			   %> 
			   <select name='treat_area' id='treat_area'  <%=disTreatArea%> onChange='clearBed();clearBed1();'>
				<option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
				<%=sbBuff.toString()%>
			    </select>
			 </td>
			 
				   <!-- onblur="ChangeUpperCase(this);checkForValidBed(this.value);" -->
			 <td class='label' width='25%'><fmt:message key="eAE.BedBayNo.label" bundle="${ae_labels}"/></td>
			 <td class='fields' width='25%' tabindex='<%=++tindex%>'><input type='text' name='bed_bay_no' id='bed_bay_no' size='8' maxlength='8'  readonly onblur="ChangeUpperCase(this);" onKeyPress="return(CheckForSpecChars(event))"  value ='<%=bed_no%>' <%=disBed%>><input type=button class=button value='?' name='bed_button' id='bed_button'  onClick="callBedAvailChart();" <%=disBed1%>>
             </td>
		  </tr>
          <tr> 
             <td class='label' ><fmt:message key="Common.Disaster.label" bundle="${common_labels}"/></td>
			 <td class='fields' width='25%' tabindex='<%=++tindex%>'><input type="checkbox" name='Disaster_YN' id='Disaster_YN'  onClick='setDisaster(this)'<%=checked1%> <%=disDisaster%>></td>
			 
			 <%
			 if(allowSplChar)
			 {
			 %>
		   <td class='label' ><fmt:message key="eAE.DisasterReference.label" bundle="${ae_labels}"/></td>
			 <td class='fields' width='25%' tabindex='<%=++tindex%>'><input type="text" name='Disaster_Reference' id='Disaster_Reference'  onKeyPress="return CheckForSpecChar(event)"
			  value="<%=dis_regn_ref%>" maxLength="15" <%=disabled11%> ></td>
             <td class='label' colspan='2'>&nbsp;</td>
			 <%
			 }
			 else
			 {
			 %>
			  <td class='label' ><fmt:message key="eAE.DisRegnReference.label" bundle="${ae_labels}"/></td>
			 <td class='fields' width='25%' tabindex='<%=++tindex%>'><input type="text" name='Disaster_Reference' id='Disaster_Reference'   onKeyPress="return CheckForSpecChars(event)"  value='<%=dis_regn_ref%>' maxLength='15' <%=disabled11%> ></td>
			 <td class='label' colspan='2'>&nbsp;</td>
			 <%
			 }
			 %>
			 
		  </tr> 
		  <tr>
			 <td class='label' width='25%'><fmt:message key="eAE.DisasterArea.label" bundle="${ae_labels}"/></td>
			 <td class='fields' width='25%' tabindex='<%=++tindex%>'><input type='text'  name="disaster_area1" id="disaster_area1" value="<%=dis_area%>" maxLength='10' onblur='if(this.value !="")searchDisasterArea(this,disaster_area1);'  <%=disabled11%>><input type='button' name='disaster' id='disaster' value='?' class='button'  tabindex='<%=++tindex%>' onclick='searchDisasterArea(this,disaster_area1);' <%=disabled11%> >
             </td>
<!--            Added by Ajay Hatwate ML-MMOH-CRF-2111 -->
           <%if(disaster_category_yn.equals("Y")){ %>
           <tr>
             <td class='LABEL' width='25%'><fmt:message key="Common.Disaster.label" bundle="${common_labels}"/> <fmt:message key="Common.category1.label" bundle="${common_labels}"/></td>
			 <td class='fields' width='25%' tabindex='<%=++tindex%>'>
				 <select name='disaster_category' id='disaster_category' onChange="remVal(document.forms[0].disaster_type);setDisasterType(this);" tabindex='63' <%=disabled11%>>
				  <option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
				  <%
				try {	
					pstmt = con.prepareStatement("select disaster_category_code, short_desc from ae_disaster_category where eff_status = 'E'");
					rset = pstmt.executeQuery();
					while(rset!=null && rset.next()) {
						if(rset.getString(1).equals(disaster_category_code)){
							out.println("<option value='"+rset.getString(1)+"' selected>"+rset.getString(2)+" ");
						}else{
							out.println("<option value='"+rset.getString(1)+"'>"+rset.getString(2)+" ");
						}
					}
				    if(pstmt!=null) pstmt.close();
 			        if(rset!=null) rset.close();
				}catch (Exception e) {e.printStackTrace();}
				
			%>
				  </select>
				  </td>  
				    <%} %>
				  <td class='LABEL' width='25%'><fmt:message key="eAE.DisasterType.label" bundle="${ae_labels}"/></td>
			 <td class='fields' width='25%'>
				 <select name='disaster_type' id='disaster_type' tabindex='63' <%=disabled11%>>
				  <option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
				  
				  <%if(modifyYN.equals("Y")){  
	                  try
					  {	
					   PreparedStatement pstmtTrans = null;
					   ResultSet rsetTrans = null;
					   optSelected="";
					  sqlFinal = "SELECT DISASTER_TYPE_CODE,SHORT_DESC FROM  AE_DISASTER_TYPE ##REPDB## WHERE DISASTER_CATEGORY_CODE=? AND EFF_STATUS='E' ORDER BY 2";
					  sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
	                  pstmtTrans = con.prepareStatement(sqlFinal);
	                  pstmtTrans.setString(1, disaster_category_code);
					   rsetTrans = pstmtTrans.executeQuery();
					   
					   while(rsetTrans!=null && rsetTrans.next())
						{
						  if(rsetTrans.getString(1).equals(disaster_type_code))
								   {
	                                    out.println("<option value='"+rsetTrans.getString("disaster_type_code")+"'  selected >"+rsetTrans.getString("short_desc")+""); 
								   }
						}
	                  if(rsetTrans!=null) rsetTrans.close();
					  if(pstmtTrans!=null) pstmtTrans.close();
					  }catch(Exception e) {e.printStackTrace();}
				  }%>
				  
				  </select>
				  </td>
           </tr>
        
<!--            End of ML-MMOH-CRF-2111		 -->
           </tr>
	      <tr>
			 <input type='hidden' id='regndatetime' name="visit_date_time" id="visit_date_time"  value='<%=visit_date%>'>
			 <%if(modify_flag.equals("Y")) { %>
		      <td class='LABEL'  width='25%' tabindex='<%=++tindex%>' ><fmt:message key="Common.ambulatorystatus.label" bundle="${common_labels}"/></td>
  		      <td class='fields' width='25%' tabindex='<%=++tindex%>'>
				 <select name='ambulatory_status' id='ambulatory_status' tabindex='63' <%=dis1%>>
				  <option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------
					   <%
						   pstmt = con.prepareStatement(AmbulatorySql);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
					       rset = pstmt.executeQuery();
						    
						   optSelected="";
						   while(rset!=null && rset.next())
						   {
							   if(rset.getString(1).equals(a_status))
							   {
                                    optSelected="selected";
							
							   }
							   else
							   {
								   optSelected="";
							      
							   }
							  
                              out.println("<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+" ");
						   }
						   if(pstmt!=null) pstmt.close();
						   if(rset!=null) rset.close();
						   if((sqlAmbulatory != null) && (sqlAmbulatory.length() > 0))
							 {
								sqlAmbulatory.delete(0,sqlAmbulatory.length());
							 }

					   %>
                 </select>
              </td>
			   <!--Bewlow line added for this CRF AAKH-CRF-0010 [IN038535]-->
			
		<td class='LABEL' width='25%' style='<%=leveloftriage_visibility%>'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
		<td class='fields' width='25%' style='<%=leveloftriage_visibility%>'>
		<input type=text  name=practitioner_desc id=practitioner_desc size=30 maxlength=30 value="<%=attend_practitioner_name%>" onBlur="beforeGetPractitioner(document.forms[0].pract_button,practitioner_desc);" <%=dis16%>><input type=button class=button value='?' name=pract_button id=pract_button   onclick="aegetPractitioner(this,practitioner_desc);" <%=dis16%>><input type=hidden value="<%=attend_practitioner_id%>" name="attend_pract_id" id="attend_pract_id"><input type=hidden value="<%=attend_practitioner_id%>" name="prev_pract_id" id="prev_pract_id"></td>
		   <!--End AAKH-CRF-0010 [IN038535]-->
             <%
		     }
			 if(modify_flag.equals("N")) {
		     %>
              <td class='LABEL'  width='25%' ><fmt:message key="Common.ambulatorystatus.label" bundle="${common_labels}"/></td>
  		      <td  class='fields' width='25%' tabindex='<%=++tindex%>'>
				 <select name='ambulatory_status' id='ambulatory_status' tabindex='63' >
				  <option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------
					   <%
						   pstmt = con.prepareStatement(AmbulatorySql);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
					       rset = pstmt.executeQuery();
						   
						   optSelected="";
						   while(rset!=null && rset.next())
						   {
							  
                              out.println("<option value='"+rset.getString(1)+"'>"+rset.getString(2)+" ");
						   }
						   if(pstmt!=null) pstmt.close();
						   if(rset!=null) rset.close();
						   if((sqlAmbulatory != null) && (sqlAmbulatory.length() > 0))
							 {
								sqlAmbulatory.delete(0,sqlAmbulatory.length());
							 }
					   %>
                 </select>
              </td>
			  <%}%>
              </td>		  
			 
			 <!--Bewlow line added for this CRF AAKH-CRF-0010 [IN038535]-->
			 
			
		<td class='LABEL' width='25%' style='<%=leveloftriage_visibility%>'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
		<td class='fields' width='25%' style='<%=leveloftriage_visibility%>'>
		<input type=text  name=practitioner_desc size=30 maxlength=30 value="<%=attend_practitioner_name%>" onBlur="beforeGetPractitioner(document.forms[0].pract_button,practitioner_desc);" <%=dis16%>><input type=button class=button value='?' name=pract_button   onclick="aegetPractitioner(this,practitioner_desc);" <%=dis16%>><input type=hidden value="<%=attend_practitioner_id%>" name="attend_pract_id" id="attend_pract_id"><input type=hidden value="<%=attend_practitioner_id%>" name="prev_pract_id" id="prev_pract_id"></td>
		   <!--End AAKH-CRF-0010 [IN038535]-->
          </tr>
		  
		   <!--Below line added for this CRF ML-MMOH-CRF-0654-->
		   
		  <%if(modeofarrival){
		  %>		   
		   <tr>
		    <td class='LABEL' width='25%' ><fmt:message key="Common.ModeofArrival.label" bundle="${common_labels}"/></td>
			<td class='fields'  colspan='3'>
				   <select name='transport_mode' id='transport_mode' onChange="remVal(document.forms[0].mode_of_arrival);setTransMode(this);" >
				    	<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------
                <%  
				   PreparedStatement pstmtTrans = null;
				   ResultSet rsetTrans = null;
				   optSelected="";
				   StringBuffer sqlAMTrans = new StringBuffer();
                   sqlAMTrans.append("SELECT transport_mode, short_desc FROM am_transport_mode_lang_vw ##REPDB## WHERE language_id='"+locale+"' and PATIENT_RELATED_YN='Y' AND eff_status = 'E' ORDER BY 2 ");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				   /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
					sqlFinal = sqlAMTrans.toString();
					sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
					/*End*/
                   pstmtTrans = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1				
				   rsetTrans = pstmtTrans.executeQuery();
				  while(rsetTrans!=null && rsetTrans.next()){	
				  
						if(rsetTrans.getString(1).equals(transport_mode_code)){
							optSelected="selected";								
						}else{
							optSelected="";							      
						}							  
                       out.println("<option value='"+rsetTrans.getString(1)+"'"+optSelected+">"+rsetTrans.getString(2)+" ");
					 					
				  }
				  if(pstmtTrans!=null) pstmtTrans.close();
				  if(rsetTrans!=null) rsetTrans.close();
				  if((sqlAMTrans != null) && (sqlAMTrans.length() > 0))
				  {
						sqlAMTrans.delete(0,sqlAMTrans.length());
				   }
	            %>
				   </select>
                   <select name='mode_of_arrival' id='mode_of_arrival' >
						 <option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------
				   </select>
		    </td> 
		    </td> 
          </tr>	
          <tr>
            <td class='LABEL'  width='25%' ><fmt:message key="eAE.AccompaniedBy.label" bundle="${ae_labels}"/></td>
			<td class='fields'  width='25%'>
				 <select name='accompany_by' id='accompany_by' <%=accompanied_by_dis%>>
					<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---
				<%  
				   PreparedStatement pstmtAccom = null;
				   ResultSet rsetAccom = null;
				   optSelected="";	
				   StringBuffer sqlAMEsc = new StringBuffer();
                   sqlAMEsc.append("SELECT ESCORT_TYPE_CODE, SHORT_DESC  FROM  AM_ESCORT_TYPE_LANG_VW ##REPDB## WHERE language_id='"+locale+"' AND EFF_STATUS='E' ORDER BY 2 ");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				   /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
					sqlFinal = sqlAMEsc.toString();
					sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
					/*End*/

				   pstmtAccom = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				   rsetAccom = pstmtAccom.executeQuery();
				   while(rsetAccom!=null && rsetAccom.next()){
					 
						if(rsetAccom.getString(1).equals(accompanied_by_code)){
							optSelected="selected";								
						}else{
							optSelected="";							      
						}							  
						   out.println("<option value='"+rsetAccom.getString(1)+"'"+optSelected+">"+rsetAccom.getString(2)+" ");
										
					}
				   if(rsetAccom!=null) rsetAccom.close();
				   if(pstmtAccom!=null) pstmtAccom.close(); 
				   if((sqlAMEsc != null) && (sqlAMEsc.length() > 0))
					{
						sqlAMEsc.delete(0,sqlAMEsc.length());
					}
	             %> 
				 </select>
			</td>
			<td class='label'  colspan='2'>&nbsp;</td> 
          </tr>		  
		  <%}%>
		  <!--End ML-MMOH-CRF-0654-->
		   
		  <!-- <%if(modeofarrival && modify_flag.equals("N")){%>		   
		   <tr>
		    <td class='LABEL' width='25%' ><fmt:message key="Common.ModeofArrival.label" bundle="${common_labels}"/></td>
			<td class='fields'  colspan='3'>
				   <select name='transport_mode' id='transport_mode' onChange="remVal(document.forms[0].mode_of_arrival);setTransMode(this);" >
				    	<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------
                <%  
				   PreparedStatement pstmtTrans = null;
				   ResultSet rsetTrans = null;
				   StringBuffer sqlAMTrans = new StringBuffer();
                   sqlAMTrans.append("SELECT transport_mode, short_desc FROM am_transport_mode_lang_vw WHERE language_id='"+locale+"' and PATIENT_RELATED_YN='Y' AND eff_status = 'E' ORDER BY 2 ");
                   pstmtTrans = con.prepareStatement(sqlAMTrans.toString());
					
				   rsetTrans = pstmtTrans.executeQuery();
				  while(rsetTrans!=null && rsetTrans.next())
					 {
					out.println("<option value='"+rsetTrans.getString(1)+"'>"+rsetTrans.getString(2)+""); 
					 }
				  if(pstmtTrans!=null) pstmtTrans.close();
				  if(rsetTrans!=null) rsetTrans.close();
				  if((sqlAMTrans != null) && (sqlAMTrans.length() > 0))
				  {
						sqlAMTrans.delete(0,sqlAMTrans.length());
				   }
	            %>
				   </select>
                   <select name='mode_of_arrival' id='mode_of_arrival' >
						 <option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------
				   </select>
		    </td> 
		    </td> 
          </tr>	
          <tr>
            <td class='LABEL'  width='25%' ><fmt:message key="eAE.AccompaniedBy.label" bundle="${ae_labels}"/></td>
			<td class='fields'  width='25%'>
				 <select name='accompany_by' id='accompany_by' >
					<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---
				<%  
				   PreparedStatement pstmtAccom = null;
				   ResultSet rsetAccom = null;
				   StringBuffer sqlAMEsc = new StringBuffer();
                   sqlAMEsc.append("SELECT ESCORT_TYPE_CODE, SHORT_DESC  FROM  AM_ESCORT_TYPE_LANG_VW WHERE language_id='"+locale+"' AND EFF_STATUS='E' ORDER BY 2 ");
				   pstmtAccom = con.prepareStatement(sqlAMEsc.toString());
				   rsetAccom = pstmtAccom.executeQuery();
				   while(rsetAccom!=null && rsetAccom.next())
					 {
					out.println("<option value='"+rsetAccom.getString(1)+"'>"+rsetAccom.getString(2)+""); 
					 }
				   if(rsetAccom!=null) rsetAccom.close();
				   if(pstmtAccom!=null) pstmtAccom.close(); 
				   if((sqlAMEsc != null) && (sqlAMEsc.length() > 0))
					{
						sqlAMEsc.delete(0,sqlAMEsc.length());
					}
	             %> 
				 </select>
			</td>
			<td class='label'  colspan='2'>&nbsp;</td> 
          </tr>		  
		  <%}%>  -->
		  <!--End ML-MMOH-CRF-0654-->
		  
		  
		  <tr> 
			  <td class='label'   width='25%'><fmt:message key="Common.referralid.label" bundle="${common_labels}"/></td> 
			 <%if(pat_dtls_unknown_yn.equals("N")){%>
				  <td class='fields' width='25%' 
				  tabindex='<%=++tindex%>'><input type='text' name='referral_id' id='referral_id' value="<%=referral_id%>" maxlength='14' size='14'  onBlur='searchPatient(document.forms[0].referral_id);' <%=disRefID%>><input type='button' class='button' value='?' name='ref_id_search' id='ref_id_search'   onClick='getReferralID()' <%=disRefID%>></td>
			<%}else if(pat_dtls_unknown_yn.equals("Y")) {%>
				<td  class='fields' width='25%'><input type='text' name='referral_id' id='referral_id' value='' maxlength='14' size='14'  onBlur=''  align='left' disabled><input type='button' class='button' value='?' name='ref_id_search' id='ref_id_search' onClick='getReferralID()' disabled></td>
		   <%}%>
	     <input type='hidden' name='injury_3' id='injury_3' value=''>

			<!--Added by Ashwini on 22-May-2017 for ML-MMOH-CRF-0650-->
			<%if(!isReplacePresntngPrblmByChiefComp){ %>
				<td class='LABEL' width='25%' ><fmt:message key="Common.PresentingProblem.label" bundle="${common_labels}"/></td>
				<td class='fields' width='25%' tabindex='<%=++tindex%>'><input type='text'  name="complaint_desc" id="complaint_desc" value="<%=complaint%>" onblur='if(this.value !="")searchComplaintType(this,complaint_desc);' tabindex='65' <%=dis3%>><input type='button' name='Complainttype' id='Complainttype' value='?' class='button' onclick='searchComplaintType(this,complaint_desc);' <%=dis3%>>
				</td>	
			<%}else{%>
				<td></td>
				<td>
					<input type=button name='ChiefComplaints' id='ChiefComplaints' value= '<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ChiefComplaints.label","ca_labels")%>'   onClick='ChiefComplaints_type()'  class='Button'  > 
				</td>
			<%}%>
		 </tr>
		 <tr> 
					<td class='LABEL' width='25%' ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
					<td class='fields' width='25%' colspan='3' tabindex='<%=++tindex%>'><textarea name='triage_remarks' cols='50'   align='left'  onblur='makeValidString(this);checkMaxLen(this);' onkeypress='checkMaxLimit(this,250);' <%=dis2%>><%=triage_remarks%></textarea>
		  </td>
		  </tr>  

		 <tr>
					<td class='COLUMNHEADER' colspan='4' ><fmt:message key="eAE.CaseDetails.label" bundle="${ae_labels}"/></td>
		 </tr>
		 <!--Added by Thamizh selvi on 8th Mar 2018 against ML-MMOH-CRF-0645 Start-->
		 <% if(isCaseDtlsRadioBtnAppl){ %>
		<tr>
		<td colspan=4>
		<table border='0' cellpadding='0' cellspacing='0' width='100%'>		
			<tr>
				<td class='label' width='17%'>
					<!--Modified by Ashwini on 18-Jan-2021 for ML-MMOH-CRF-1409-->
					<fmt:message key="Common.CaseofTrauma.label" bundle="${common_labels}"/>
				</td>
				<td class='fields' width='7%'>
					<input type='radio' name='caseDetails' id='caseDetails' tabindex='<%=++tindex%>' id='trauma' value='N' onClick='caseDetailsOnChange(this);' <%=checked9%> <%=dis5%>></input>
				</td>
				<td class='label' width='10%'>
					<fmt:message key="Common.oscc.label" bundle="${common_labels}"/>
				</td>
				<td class='fields' width='7%'>
					<input type='radio' name='caseDetails' id='caseDetails' tabindex='<%=++tindex%>' id='oscc' value='N' onClick='caseDetailsOnChange(this);' <%=disOscc%> <%=checked2%>></input>
				</td>
				<td class='label' width='10%'>
					<span id='osccTypeLabel' style="visibility:hidden"><fmt:message key="Common.oscc.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.type.label" bundle="${common_labels}"/></span>
				</td>
				<td class='fields' width='16%'>
					<select name='osccType' id='osccType' style="visibility:hidden" tabindex='<%=++tindex%>' <%=dis7%>>
						<option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------
						<%
								JSONArray osccTypeJsonArr	= new JSONArray();
								osccTypeJsonArr  = eAE.AECommonBean.getOSCCTypeList(con,locale,RepDb);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1	
									
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
				<td class='label'  width='17%'>
					<fmt:message key="Common.medical.label" bundle="${common_labels}"/>
				</td>
				<td class='fields' width='7%'>
					<input type='radio' tabindex='<%=++tindex%>' name="caseDetails" id='medical' value='N' onClick='caseDetailsOnChange(this);' <%=checkedMed%> <%=disMed%>></input>
				</td>
				<td class='label' width='10%'>
					<fmt:message key="Common.Surgical.label" bundle="${common_labels}"/>
				</td>
				<td class='fields' width='7%'> 
					<input type='radio' tabindex='<%=++tindex%>' name="caseDetails" id='surgical' value='N' onClick='caseDetailsOnChange(this);' <%=checkedSur%> <%=disSur%>></input> 
				</td>
			</tr>
			<tr>
				<td class='label'  width='17%'>
					<fmt:message key="eAE.OandG.label" bundle="${ae_labels}"/>
				</td>
				<td class='fields' width='7%' tabindex='<%=++tindex%>' >
					<input type='radio' name="caseDetails" id="caseDetails" id='OandG' value='N' onClick='caseDetailsOnChange(this);' <%=checkedOandGYn%> <%=disOandGYn%>></input>
				</td>
			</tr>
		</table>
		</td>
		</tr>
			<input type='hidden' name='oscc_yn' id='oscc_yn' value='<%=oscc_yn%>'>
			<input type='hidden' name='medical_yn' id='medical_yn' value='<%=medical_yn%>'>
			<input type='hidden' name='surgical_yn' id='surgical_yn' value='<%=surgical_yn%>'>
		 <% }else{ %>
		 <!--End-->
		 <tr>  
			        <td class='label' width='25%'><fmt:message key="Common.CaseofTrauma.label" bundle="${common_labels}"/></td>
			        <td class='fields' width='25%' tabindex='<%=++tindex%>'><input type='checkbox'   name="CaseofTrauma" id="CaseofTrauma" value='N' onClick='checktrauma(this);setMechInj1(this);' <%=checked9%> <%=dis5%>>
					</td>	
					<td class='label' width='25%'><fmt:message key="Common.oscc.label" bundle="${common_labels}"/></td>
                    <td class='fields' width='25%' tabindex='<%=++tindex%>'><input type='checkbox'  name="oscc_yn" id="oscc_yn"   value='<%=oscc_yn%>' onClick='chkOsccValue(this);remVal(document.forms[0].mechan_injury);setMechInj();' <%=disOscc%> tabindex='' <%=checked2%>>
					<!-- <%=checked2%> <%=disable3%> --> </td>
         </tr>
		 <tr> 
					<td class='label'  width='25%'><fmt:message key="Common.medical.label" bundle="${common_labels}"/></td>
					<td class='fields' width='25%' tabindex='<%=++tindex%>'><input type='checkbox'  name="medical_yn" id="medical_yn" value='N' onClick='chkMedicalValue(this);' <%=checkedMed%> <%=disMed%>></td>
					<td class='label'  width='25%' ><fmt:message key="Common.Surgical.label" bundle="${common_labels}"/></td>
					<td class='fields' width='25%' tabindex='<%=++tindex%>'> <input type='checkbox'  name="surgical_yn" id="surgical_yn"   value='N' onClick='chkSurgValue(this);' <%=checkedSur%> <%=disSur%>> 
					</td>
		 </tr>
		 <% } %>
				<input type='hidden' name='patient_id' id='patient_id' value=<%=patient_id%>>
				<input type='hidden' name='called_from_ca' id='called_from_ca' value=<%=called_from_ca%>>
		 <% if(isCaseDtlsRadioBtnAppl){ %>
		 <tbody id='placeOfOccMechInjFieldsDisplay' style="display:none;">
		 <% } %>
		 <tr>
		 	<!-- if else added by mujafar for ML-MMOH-CRF-0647 -->
			<%if(isPlaceOfOccuurrence == true){%>
			<td class='LABEL'  width='25%' ><fmt:message key="eAE.DateTimeOfOccurrence.label" bundle="${ae_labels}"/></td>
			<%}else{%>
	          <td class='label' width='25%'><fmt:message key="eAE.DateTimeOfAccident.label" bundle="${ae_labels}"/></td>
			<%}%>
  		      <td class='fields' width='25%' tabindex='<%=++tindex%>'>
			  <input type='text'  id='accidentdatetime' name='accidentdatetime'  maxLength='16' size='16' tabindex=''
			  value="<%=DateUtils.convertDate(date_time_of_accident,"DMYHM","en",localeName)%>"  onBlur='doDate(this);' <%=disDateAcci%>>
<%-- 			  <img src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('accidentdatetime', null, 'hh:mm' );" style='cursor:pointer' <%=disDateAcci%> ></img>
 --%>			  <img src='../../eCommon/images/CommonCalendar.gif'  onClick="if (!document.getElementById('accidentdatetime').disabled) {return showCalendar('accidentdatetime', null, 'hh:mm' )}"  <%=disDateAcci%>>
			  <img src='../../eCommon/images/mandatory.gif' id='dateOfOccurImg' style="visibility:hidden" align='center'></td><!--Added mandatory image for ML-MMOH-CRF-0648 on 5th Apr 2018 by Thamizh selvi-->
	
			  	<!--Added by Ashwini on 19-Jan-2017 for GDOH-CRF-0131-->
				<!-- if else added by mujafar for ML-MMOH-CRF-0647 -->
				<!--Modified by Ashwini on 17-Aug-2017 for GDOH-CRF-0161-->
				 <%if(isLabelChngAppl == true){ %>
			  <td class='label' width='25%'><fmt:message key="eAE.PlaceOfAccident.label" bundle="${ae_labels}"/>/<fmt:message key="eAE.PickupPlace.label" bundle="${ae_labels}"/></td>
			  <%}
			  else if(isPlaceOfOccuurrence == true){
			  %>
			  <td class='LABEL' width='25%' ><fmt:message key="eAE.PlaceOfOccurrence.label" bundle="${ae_labels}"/></td>
			  <%
			  }
			  else{
				%><td class='label' width='25%' ><fmt:message key="eAE.PlaceOfAccident.label" bundle="${ae_labels}"/></td>
				<%} %>

			<%if(isPlaceOfOccuurrence == false){%>
			  <td class='fields' width='25%' tabindex='<%=++tindex%>'><input type='text' name="place_of_accident" id="place_of_accident"  maxLength='30' size='25'  tabindex='' value="<%=place_of_accident%>" onBlur="makeValidString(this)" <%=disPlaceAcci%>></td>
			<%}
			else{	
			%>
			
			 <td class='fields' width='25%'><select name='place_of_accident' id='place_of_accident' <%=disPlaceAcci%> >
			   <option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option> 
                <%  
                  try 
				  {	
				   PreparedStatement pstmtTrans1 = null;
				   ResultSet rsetTrans1 = null;
                   //pstmtTrans1 = con.prepareStatement("select PLACE_OCCURRENCE_TYPE_CODE, short_desc from AE_PLACE_OF_OCCURRENCE where  eff_status='E' order by short_desc");
				   /*Above line commented and below code added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
					sqlFinal = "select PLACE_OCCURRENCE_TYPE_CODE, short_desc from AE_PLACE_OF_OCCURRENCE ##REPDB## where  eff_status='E' order by short_desc";
					sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
					pstmtTrans1 = con.prepareStatement(sqlFinal);
					/*End*/
					
				   rsetTrans1 = pstmtTrans1.executeQuery();
				   
				   while(rsetTrans1!=null && rsetTrans1.next())
					{ 
						 if(rsetTrans1.getString(1).equals(place_of_accident))
							   {
                                    optSelected="selected";
							
							   }
							   else
							   {
								   optSelected="";
							      
							   }
					  out.println("<option value='"+rsetTrans1.getString("PLACE_OCCURRENCE_TYPE_CODE")+"' "+optSelected+" >"+rsetTrans1.getString("short_desc")+""); 
					  
					}
                  if(rsetTrans1!=null) rsetTrans1.close();
				  if(pstmtTrans1!=null) pstmtTrans1.close();
				  }catch(Exception e) {/* out.println("Exception in Place of Occurrence="+e);	 */		e.printStackTrace();}
	            %>
				</select><img src='../../eCommon/images/mandatory.gif' id='placeOfOccurImg' style="visibility:hidden" align='center'><!--Added mandatory image for ML-MMOH-CRF-0648 on 5th Apr 2018 by Thamizh selvi-->
				</td>
			
			
			
			
			
			
			<%}%>
	     </tr>
	     <tr>	
		           <td class='LABEL' width='25%' >
						<!--Added by Thamizh selvi on 29th Mar 2018 against ML-MMOH-CRF-0649 Start-->
						<% if(isMechInjLabelChngAppl){ %>
							<fmt:message key="eAE.MechOfMainInj.label" bundle="${ae_labels}"/>
						<% }else{ %><!--End-->
							<fmt:message key="Common.MechanismofInjury.label" bundle="${common_labels}"/>
						<% } %>
				   </td>
				   <% if(isMechInjLabelChngAppl){ %><!--Added by Thamizh selvi on 29th Mar 2018 against ML-MMOH-CRF-0649-->
  						<td class='fields' width='25%' tabindex='<%=++tindex%>'>
				   <% }else{ %>
						<td class='fields' width='25%' colspan='2' tabindex='<%=++tindex%>'>
				   <% } %>
				   <select name='mechan_injury' id='mechan_injury' onChange='setInjury(this)' <%=dis6%>> 
				    <option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------
					   <%
					  //if(modify_flag.equals("Y")) {
						 StringBuffer sqlMechaInjury = new StringBuffer();
						 sqlMechaInjury.append("SELECT INJ_CATEGORY_CODE,SHORT_DESC FROM AE_INJURY_CATEGORY_LANG_VW ##REPDB##  WHERE language_id='"+locale+"'  and EFF_STATUS='E' and   oscc_yn=  '"+oscc_yn+"'  ORDER BY 2 ");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
						 	/*modify_flag is commented and above query is modifed by Rameswar on 04-Oct-16 for GDOH-CRF-0004.2*/

						/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
						sqlFinal = sqlMechaInjury.toString();
						sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
						/*End*/
						 pstmt = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
					     rset = pstmt.executeQuery();
						 
						 	 optSelected="";
						 while(rset!=null && rset.next())
						   {
							   if(rset.getString("INJ_CATEGORY_CODE").equals(mech_injr_code))
							   {
                                    optSelected="selected";
															
							   }
							   else
								   optSelected="";

                              out.println("<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+" ");
						   }
						 if(pstmt!=null) pstmt.close();
						 if(rset!=null) rset.close();
						 if((sqlMechaInjury != null) && (sqlMechaInjury.length() > 0))
						 {
							sqlMechaInjury.delete(0,sqlMechaInjury.length());
						 }
					  // } 
					   %>  
                 </select><img src='../../eCommon/images/mandatory.gif' id='mand4' style="visibility:hidden" align='center'></img>
				 <% if(!isMechInjLabelChngAppl){ %><!--Added by Thamizh selvi on 29th Mar 2018 against ML-MMOH-CRF-0649-->
					<font  class='label'></font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.and.label" bundle="${common_labels}"/>
				 <% } %>
              </td>
			  <!--Added by Thamizh selvi on 29th Mar 2018 against ML-MMOH-CRF-0649 Start-->
			  <% if(isMechInjLabelChngAppl){ %>
				<td class='LABEL' width='25%'><fmt:message key="eAE.MechaofSubInjury.label" bundle="${ae_labels}"/></td>
			  <% } %><!--End-->
  		      <input type='hidden' name='mech_sub_code' id='mech_sub_code' value=<%=mech_injury_subcatg_code%> >
			 <td class='fields' width='25%' tabindex='<%=++tindex%>'>
				<select name='injury' id='injury' tabindex='68' <%=dis7%>>
				  <option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------
				</select><img src='../../eCommon/images/mandatory.gif' id='mand5' style="visibility:hidden" align='center'></img>
              </td> 
	  </tr>
	  <% if(isCaseDtlsRadioBtnAppl){ %>
	  </tbody>
	  <% } %>
	  <tr>	
		      <td class='LABEL' width='25%' ><fmt:message key="Common.VehiclesInvolved.label" bundle="${common_labels}"/></td>
  		      <td class='fields' width='25%' colspan='2' tabindex='<%=++tindex%>'>
				 <select name='vehicle_invol' id='vehicle_invol' <%=dis8%>>
				  <option value='' >--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------
					   <%
						 StringBuffer sqlVehicleInv = new StringBuffer();
						// sqlVehicleInv.append("select ARRIVAL_CODE, SHORT_DESC ARRIVAL_SHORT_DESC from am_arrival_lang_vw where language_id='"+locale+"'  and EFF_STATUS='E' and facility_id='"+facilityId+"'  order by 2");

						 sqlVehicleInv.append("select ARRIVAL_CODE, SHORT_DESC ARRIVAL_SHORT_DESC from am_arrival_lang_vw ##REPDB## where language_id='"+locale+"'  and EFF_STATUS='E' and facility_id='"+facilityId+"' and ARRIVAL_CODE like '%%' order by 2");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
						 /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
						sqlFinal = sqlVehicleInv.toString();
						sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
						/*End*/
						 pstmt = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
					     rset = pstmt.executeQuery();
						 
						 optSelected="";
						 while(rset!=null && rset.next())
						   {
							   if(rset.getString(1).equals(vehicle_invlovedcode))
							   {
                                    optSelected="selected";
															
							   }
							   else
								   optSelected="";
                              out.println("<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+" ");
						   }
						 if(pstmt!=null) pstmt.close();
						 if(rset!=null) rset.close();
					   %>
                 </select><font  class='label'></font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				 <fmt:message key="Common.and.label" bundle="${common_labels}"/>
              </td>
			  <td class='fields' width='25%' tabindex='<%=++tindex%>'>
				<select name='vehicle_invol1' id='vehicle_invol1' tabindex='68' <%=dis9%>>
				  <option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------
				<%
						 pstmt = con.prepareStatement(sqlFinal);
					     rset = pstmt.executeQuery();
						  
						 optSelected="";
						 while(rset!=null && rset.next())
						   {
							   if(rset.getString(1).equals(vehicle_invlovedcode1))
							   {
                                    optSelected="selected";
															
							   }
							   else
								   optSelected="";
                              out.println("<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+" ");
						   }
						 if(pstmt!=null) pstmt.close();
						 if(rset!=null) rset.close();
						 if((sqlVehicleInv != null) && (sqlVehicleInv.length() > 0))
						 {
							sqlVehicleInv.delete(0,sqlVehicleInv.length());
						 }
					   %>
				</select>
              </td> 			   
	   </tr>

<!--Added by Ashwini on 04-Apr-2017 for GDOH-CFR-0004.3-->
	<tr>
	 <td class='LABEL' width='25%' ><fmt:message key="eAE.VehicleRegNo.label" bundle="${ae_labels}"/></td>
		<td class='fields' width='25%' colspan='2' >
			<input type='text' name="Vehicle_Reg_No1" id="Vehicle_Reg_No1"  maxLength='15' size='20' value="<%=Vehicle_Reg_No1%>" onKeyPress="return SpCharChkForMotorVecRegNo(event);" <%=dis8%>> <font  class='label'></font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.and.label" bundle="${common_labels}"/> 
		</td>
		<td class='fields' width='25%'>
			<input type='text' name="Vehicle_Reg_No2" id="Vehicle_Reg_No2"  maxLength='15' size='20' value="<%=Vehicle_Reg_No2%>" onKeyPress="return SpCharChkForMotorVecRegNo(event);" <%=dis8%>>
		</td>
	</tr>

	   <tr>	
		      <td class='LABEL' width='25%' ><fmt:message key="Common.ProtectiveDeviceUsed.label" bundle="${common_labels}"/></td>
  		      <td class='fields' width='25%' tabindex='<%=++tindex%>'>
				 <select name='protective_device' id='protective_device' <%=dis10%>>
				   <option value=''>---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------
			   <%
			   StringBuffer sqlProtect = new StringBuffer();
			  // sqlProtect.append("SELECT PROTECTIVE_DEVICE_CODE, SHORT_DESC FROM  AE_PROTECTIVE_DEVICE_LANG_VW WHERE language_id='"+locale+"'  and EFF_STATUS ='E' ORDER BY 2");
			   sqlProtect.append("SELECT PROTECTIVE_DEVICE_CODE, SHORT_DESC FROM  AE_PROTECTIVE_DEVICE_LANG_VW ##REPDB## WHERE language_id='"+locale+"'  and EFF_STATUS ='E' and PROTECTIVE_DEVICE_CODE like '%%' ORDER BY 2");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
			   /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
				sqlFinal = sqlProtect.toString();
				sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
				/*End*/

			   pstmt = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
			   rset = pstmt.executeQuery();
			    
			   optSelected="";
			   while(rset!=null && rset.next())
			   {
					if(rset.getString(1).equals(protective_device_code))
				   {
						optSelected="selected";
												
				   }
				   else
					   optSelected="";

				   
				  out.println("<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+" ");
			   }
			   if(pstmt!=null) pstmt.close();
			   if(rset!=null) rset.close();
			   if((sqlProtect != null) && (sqlProtect.length() > 0))
				 {
					sqlProtect.delete(0,sqlProtect.length());
				 }
			   %>
                 </select>
               </td>
			   <td class='LABEL' width='25%' ><fmt:message key="Common.PositionDuringIncident.label" bundle="${common_labels}"/>
               </td>
			   <td class='fields' width='25%' tabindex='<%=++tindex%>'>
				   <select name='affected_site' id='affected_site' tabindex='' <%=dis11%>>
				   <option value=''>---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------
					   <%
						   pstmt = con.prepareStatement(PositionSql);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
					       rset = pstmt.executeQuery();
						   
						   optSelected="";
						   while(rset!=null && rset.next())
						   {
							  if(rset.getString(1).equals(pat_position_code))
							   {
                                    optSelected="selected";
															
							   }
							   else
								   optSelected="";
                              out.println("<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+" ");
						   }
						   if(pstmt!=null) pstmt.close();
						   if(rset!=null) rset.close();
						   if((sqlPosition != null) && (sqlPosition.length() > 0))
							{
								sqlPosition.delete(0,sqlPosition.length());
							}
					   %>
                 </select>
              </td>
	  </tr> 
	 <tr><!-- below line(s) modified by VenkateshS against ML-MMOH-CRF-0354 [IN057191] -->
	         <%if(siteSpecific){%>
			  <td class='COLUMNHEADER' colspan='4' ><fmt:message key="Common.MedicalLegalCase.label" bundle="${common_labels}"/> <fmt:message key="Common.details.label" bundle="${common_labels}"/></td>
			 <%}else {%>
		    <td class='COLUMNHEADER' colspan='4' ><fmt:message key="Common.mlcdetails.label" bundle="${common_labels}"/></td>
			<%}%>
	 </tr>
	 <tr>	 <%if(siteSpecific){%>
	          <td class='label' width='25%'><fmt:message key="Common.MedicalLegalCase.label" bundle="${common_labels}"/></td>
	           <%}else{%>
		      <td class='label' width='25%'><fmt:message key="Common.mlc.label" bundle="${common_labels}"/></td>
               <%}%>
			   <!--end ML-MMOH-CRF-0354 [IN057191 -->
		     <td class='fields' width='25%' tabindex='<%=++tindex%>'><input type='checkbox'  name="mlc_case_yn" id="mlc_case_yn"  onclick='chkMlcValue(this)' <%=checked3%>   <%=disMLC%>></td>
             <% if(isMLCAppl){ %>
             <td class='LABEL' width='25%' ><fmt:message key="Common.MlcDeath.label" bundle="${common_labels}"/></td>
					<td class='fields' width='25%'><input type="checkbox" name='mlc_death' id='mlc_death' value='<%=MLC_DEATH_YN %>' onclick='updateSelf(this)' <%=disMLCDeath %> <%=MLC_DEATH_YN.equals("Y")?" Checked ":"" %> ></td></td>
             <%}else{ %>
             <td class='LABEL' width='25%' colspan='2'>&nbsp;</td>
             <% }%>
      </tr> 
	  <tr>
	          <td class='label' width='25%'><fmt:message key="Common.PoliceReportNo.label" bundle="${common_labels}"/></td>
  		      <td class='fields' width='25%' tabindex='<%=++tindex%>'>
			  <input type='text'  name='police_rep_no1' id='police_rep_no1'   maxLength='<%=pol_rep_no_mx_size %>' <% if(isMLCAppl){ %> onpaste="maxLengthPaste(this, '100')" <%} %> size='15' tabindex='' value="<%=police_rep_no%>"  <%=dis12%>></td>
			  <td class='label' width='25%'><fmt:message key="Common.PoliceStationDetails.label" bundle="${common_labels}"/></td>
			  <td class='fields' width='25%' tabindex='<%=++tindex%>'><input type='text' name="police_stat_detail" id="police_stat_detail"  maxLength='<%=pol_stn_det_mx_size %>' <% if(isMLCAppl){ %> onpaste="maxLengthPaste(this, '100')" <%} %> size='25' tabindex='' value='<%=police_station_dtls%>'  <%=dis13%>></td>
	  </tr>
	  <!-- Added by Ajay Hatwate for GHL-CRF-0650  -->
	  <% if(isMLCAppl){ %>
	   <tr>
		<td class='LABEL' width='25%' ><fmt:message key="Common.OutMlcNoDtls.label" bundle="${common_labels}"/></td>
					<td class='fields' width='25%'><input type='text' name="outside_mlc_dtls" id="outside_mlc_dtls" value='<%=MLC_NO_OUTSIDE_DTLS %>' maxlength='100' onpaste="maxLengthPaste(this, '100')" <%=disOutMLCDet %> ></td></td>	
		<td class='LABEL' width='25%' ><fmt:message key="Common.DateOfMlcCapture.label" bundle="${common_labels}"/></td>
					<td class='fields' width='25%'>
					<input type='text'  id='dateofmlccapture' name="date_of_mlc_capture" id="date_of_mlc_capture" onBlur="validateMlcCapture(this)" maxLength='19' size='19' value='<%=MLC_CAPTURE_DATE %>' <%=disDateOfCapt %>><img src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('dateofmlccapture','dd/mm/yyyy' ,'hh:mm:ss',null );" style='cursor:pointer'></img>
					</td></td>				
	</tr>
	<tr>
		<td class='LABEL' width='25%' ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
					<td class='fields' width='25%'>
					<textarea name='mlc_remarks' rows=3 maxlength=12 cols=45 onKeyPress="checkMaxLimit(this, 500)" onpaste="maxLengthPaste(this, '500')" <%=disMLCRemark %>><%=MLC_REMARKS%></textarea>
					</td></td>				
	</tr>
	  <%} %>
	  <!-- End of GHL-CRF-0650  -->
     <tr><td colspan=4 class=label height=5></td></tr>
  </table>
</div>
	<div id='Others' style = 'display:none' >
	 <table cellspacing='0' cellpadding='0' width='100%' border=0 align='center'>
            <tr><td class='white'>

		<ul id="tablist" class="tablist" >
			<li class="tablistitem" title="Triage Details">
				<a  class="tabClicked" id='Triage_Details_tab' >
					<span class="tabSpanclicked" onClick='javascript:expandCollapse("Triage_Details_tab")' id="Triage_tabspan"><fmt:message key="Common.TriageDetails.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			<%if(ca_install_yn.equals("Y")){%>
			<li class="tablistitem" title="Assessment">
				<a class="tabA" id='Assessment_tab' >
					<span class="tabAspan" onClick='javascript:expandCollapse("Assessment_tab")' id="assess_tabspan"><fmt:message key="Common.Assessment.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			<%}%> 
		</ul>
    </td></tr>
    </table>
	<table cellspacing='0' cellpadding='0' width='100%' border=0 align='center'>
      <tr><td class='white'>
			<ul id="tablist" class="tablist">
				<li class="tablistitem" title="Condition / Case">
					<a  class="tabA" id="Condition_tab" >
						<span class="tabAspan" onClick='javascript:expandCollapse("Condition_tab")' id="patCond_tabspan"><fmt:message key="eAE.ConditionCase.label" bundle="${ae_labels}"/></span>
					</a>
				</li>
				<!--Added by Thamizh selvi on 10th Apr 2018 against ML-MMOH-CRF-0655 Start-->
				<% if(isChngBtnPositionAppl){ %>
				<li class="tablistitem" title="Allergy Details">
					<a  class="tabA" id="allergy_dtls" >
						<span class="tabAspan" onClick='javascript:expandCollapse("allergy_dtls")' id="allergyDtls_tabspan"><fmt:message key="Common.AllergyDetails.label" bundle="${common_labels}"/></span>
					</a>
				</li>
				<% } %><!--End-->
				<li class="tablistitem" title="Others">
					<a class="tabClicked" id="others_tab" >
						<span class="tabSpanclicked" onClick='javascript:expandCollapse("others_tab")' id="others_tabspan"><fmt:message key="Common.others.label" bundle="${common_labels}"/></span>
					</a>
				</li>
			</ul>
       </td></tr>
</table>
<!--Added by k v shanmukh on 2nd-Apr-2018 against ML-MMOH-CRF-0656 Start-->
<%if(isSecTrgBackDateTimeAppl){%>
<table border="0" cellpadding="2" cellspacing="0" align='center' width='100%'>
	<tr>
		<td class='LABEL'   width='25%' ><fmt:message key="eAE.Triage.label" bundle="${common_labels}"/> <fmt:message key="Common.datetime.label" bundle="${common_labels}"/></td> 
		<% if(display_triage_record_date_time.equals("")){%>
			<td class='fields' width='34%' tabindex='<%=++tindex%>'>
			<input type='text'  id='other_triage_record_date_time' name='triage_record_date_time' id='triage_record_date_time' value="<%=sys_date_time%>" maxLength='19' size='16' tabindex=''onBlur='triageRecordDate(this);'<%=dis_triage_record_date_time%>>
			<img src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('other_triage_record_date_time', null, 'hh:mm:ss' );" style='cursor:pointer'   /> <img src='../../eCommon/images/mandatory.gif' ></img>
			</td>
		<%}else {%>
			<td class='fields' width='34%' tabindex='<%=++tindex%>'>
			 <input type='text'  id='other_triage_record_date_time' name='triage_record_date_time' id='triage_record_date_time' value="<%=display_triage_record_date_time%>" maxLength='19' size='16' tabindex='' <%=dis_triage_record_date_time%>>
			</td>
		<%}%>
		<!--Added by Thamizh selvi on 9th Apr 2018 against ML-MMOH-CRF-0655 Start-->
		<% if(isChngBtnPositionAppl){ %>
			<td class='fields' width='20%' tabindex='<%=++tindex%>'>
				<input type="button" name="visit_24hr" id="visit_24hr" class="BUTTON" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.VisitWithin24Hrs.label","ae_labels")%>' onClick="showLastVisitDetails('LastVisit24');" <%=VisitProp%>>
			</td>
			<td class='fields' width='21%' tabindex='<%=++tindex%>'>
				<input type="button" name="PrevEncounter" id="PrevEncounter" class="BUTTON" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PreviousEncounters.label","common_labels")%>' onClick="showPrevEncounter();"  <%=EncounterProp%> >
			</td>
		<% } %>
		<!--End-->
	</tr>
</table>
<%}else if(isChngBtnPositionAppl){ %><!--Added by Thamizh selvi on 9th Apr 2018 against ML-MMOH-CRF-0655 Start-->
<table border="0" cellpadding="2" cellspacing="0" align='center' width='100%'>
	<tr>
		<td colspan='2'>&nbsp;</td>
		<td class='fields' width='15%' tabindex='<%=++tindex%>'>
			<input type="button" name="visit_24hr" id="visit_24hr" class="BUTTON" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.VisitWithin24Hrs.label","ae_labels")%>' onClick="showLastVisitDetails('LastVisit24');" <%=VisitProp%>>
		</td>
		<td class='fields' width='15%' tabindex='<%=++tindex%>'>
			<input type="button" name="PrevEncounter" id="PrevEncounter" class="BUTTON" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PreviousEncounters.label","common_labels")%>' onClick="showPrevEncounter();"  <%=EncounterProp%> >
		</td>
	</tr>
</table>
<% } %>
<!--End-->	

 <table border="0" cellpadding="3" cellspacing="0" align='center' colspan=8 width="100%">
	 <tr>
			<!--Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651 Start-->
			<% if(isOrderCatalogChngAppl && !initialMgmtLblName.trim().equals("")){ %>
				<td class='COLUMNHEADER' colspan='4' ><%=initialMgmtLblName%></td>
			<% }else{ %><!--End-->
				<td class='COLUMNHEADER' colspan='4' ><fmt:message key="eAE.InitialManagement.label" bundle="${ae_labels}"/></td>
			<% } %>
	 </tr>

	<%if(ca_install_yn.equals("Y")){
	if (order_catalog_code3.equals("")){ FBCProp		  ="disabled";}
    try
	 {	
				   StringBuffer sqlECG1 = new StringBuffer();
				   StringBuffer sqlECG3 = new StringBuffer();
				   StringBuffer sqlECG4 = new StringBuffer();
				   StringBuffer sqlECG5 = new StringBuffer();
				   StringBuffer sqlOrderCatalog6 = new StringBuffer();//Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651
				//   sqlECG1.append("select count(*)  from or_order ##REPDB## a, or_order_line ##REPDB## b, ae_param ##REPDB## c where a.ORDERING_FACILITY_ID='"+facilityId+"' and a.patient_id='"+patient_id+"' and  a.ENCOUNTER_ID='"+encounter_id+"' and a.order_id=b.order_id and a.ORDERING_FACILITY_ID=c.OPERATING_FACILITY_ID ");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				   sqlECG1.append("select count(*)  from or_order ##REPDB## a, or_order_line ##REPDB## b  where a.ORDERING_FACILITY_ID='"+facilityId+"' and a.patient_id='"+patient_id+"' and  a.ENCOUNTER_ID='"+encounter_id+"' and a.order_id=b.order_id  ");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				   sqlECG3.append(sqlECG1);
				   sqlECG4.append(sqlECG1);
				   sqlECG5.append(sqlECG1);
				   sqlOrderCatalog6.append(sqlECG1);//Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651
				   StringBuffer s1 = new StringBuffer();
				   StringBuffer s3 = new StringBuffer();
				   StringBuffer s4 = new StringBuffer();
				   StringBuffer s5 = new StringBuffer();
				   StringBuffer s6 = new StringBuffer();//Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651
				/*   s1.append(" and b.ORDER_CATALOG_CODE=c.ORDER_CATALOG_CODE2");
				   s3.append(" and b.ORDER_CATALOG_CODE=c.ORDER_CATALOG_CODE4");
				   s4.append(" and b.ORDER_CATALOG_CODE=c.ORDER_CATALOG_CODE1");
				   s5.append(" and b.ORDER_CATALOG_CODE=c.ORDER_CATALOG_CODE5");
				   s6.append(" and b.ORDER_CATALOG_CODE=c.ORDER_CATALOG_CODE6");//Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651
				   */
				   s1.append(" and b.ORDER_CATALOG_CODE='"+order_catalog_code2+"'");
				   s3.append(" and b.ORDER_CATALOG_CODE='"+order_catalog_code4+"'");
				   s4.append(" and b.ORDER_CATALOG_CODE='"+order_catalog_code1+"'");
				   s5.append(" and b.ORDER_CATALOG_CODE='"+order_catalog_code5+"'");
				   s6.append(" and b.ORDER_CATALOG_CODE='"+order_catalog_code6+"'");//Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651

				   /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
				   sqlFinal = sqlECG1.append(s1).toString();
				   sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
				   /*End*/
				   pstmtEncounter = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				   rsetEncounter = pstmtEncounter.executeQuery();
				   while(rsetEncounter!=null && rsetEncounter.next())
					 {
						      countECG=rsetEncounter.getInt(1);
					 }
				  if(rsetEncounter!=null){ rsetEncounter.close(); rsetEncounter=null; }
				  if(pstmtEncounter!=null){ pstmtEncounter.close(); pstmtEncounter=null; }

					  if (countECG>0)
					  {
						  ECGProp = "checked";
					  }else
					  {
						  ECGProp ="";
					  }

				   /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
				   sqlFinal = sqlECG3.append(s3).toString();
				   sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
				   /*End*/
				   pstmtEncounter = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				   rsetEncounter = pstmtEncounter.executeQuery();
				   while(rsetEncounter!=null && rsetEncounter.next())
					 {
						      countDerss=rsetEncounter.getInt(1);
					 }
				  if(rsetEncounter!=null){ rsetEncounter.close(); rsetEncounter=null; }
				  if(pstmtEncounter!=null){ pstmtEncounter.close(); pstmtEncounter=null; }
					  if (countDerss>0)
					  {
						  DressProp = "checked";
					  }else
					  {
						  DressProp ="";
					  }

				   /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
				   sqlFinal = sqlECG4.append(s4).toString();
				   sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
				   /*End*/
				   pstmtEncounter = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				   rsetEncounter = pstmtEncounter.executeQuery();
				   while(rsetEncounter!=null && rsetEncounter.next())
					 {
						      countSpO2=rsetEncounter.getInt(1);
					 }
				  if(rsetEncounter!=null){ rsetEncounter.close(); rsetEncounter=null; }
				  if(pstmtEncounter!=null){ pstmtEncounter.close(); pstmtEncounter=null; }
					  if (countSpO2>0)
					  {
						  SpO2Prop = "checked";
					  }else
					  {
						  SpO2Prop ="";
					  }
					/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
				   sqlFinal = sqlECG5.append(s5).toString();
				   sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
				   /*End*/
				   pstmtEncounter = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				   rsetEncounter = pstmtEncounter.executeQuery();
				   while(rsetEncounter!=null && rsetEncounter.next())
					 {
						      countCapBlood=rsetEncounter.getInt(1);
					 }
				  if(rsetEncounter!=null){ rsetEncounter.close(); rsetEncounter=null; }
				  if(pstmtEncounter!=null){ pstmtEncounter.close(); pstmtEncounter=null; }
					  if (countCapBlood>0)
					  {
						  capBloodSugProp = "checked";
					  }else
					  {
						  capBloodSugProp ="";
					  }
				/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
				sqlFinal = sqlOrderCatalog6.append(s6).toString();
				sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
				/*End*/

				/*Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651 Start*/
				pstmtEncounter = con.prepareStatement(sqlFinal);
				rsetEncounter = pstmtEncounter.executeQuery();
				while(rsetEncounter!=null && rsetEncounter.next()){
				      countCBD = rsetEncounter.getInt(1);
				}
		  	    if(rsetEncounter!=null){ rsetEncounter.close(); rsetEncounter=null; }
				if(pstmtEncounter!=null){ pstmtEncounter.close(); pstmtEncounter=null; }
				if (countCBD > 0){
					cbdProp = "checked";
				}else{
					cbdProp ="";
				}/*End*/

	}catch(Exception e) {e.printStackTrace();}
				  

  %>
	 <tr><td colspan=4 class=label height=5></td></tr>
    <tr >
		<!--Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651 Start-->
		<% if(isOrderCatalogChngAppl){ %>
				<td class='LABEL'   width='25%' >
					<fmt:message key="eAE.CBD.label" bundle="${ae_labels}"/>
				</td>
				<td class='fields' width='25%' tabindex='<%=++tindex%>'>
					<input type="checkbox" name='cbd' id='cbd' <%=cbdProp%>  disabled>
				</td>
				<td class='LABEL'   width='25%' >
					<fmt:message key="Common.Medication.label" bundle="${ae_labels}"/>
				</td>
				<td class='fields' width='25%' tabindex='<%=++tindex%>'> 
					<input type=text  name='medication' id='medication'  onKeyPress="return CheckSpecCharOnKeyPress(event)" onPaste = "return false;" value="<%=medication%>" size="30" maxlength="30" <%=disMedication%> >
				</td>
		<% }else{ %><!--End-->
			 <td class='LABEL'   width='25%' ><fmt:message key="eAE.CapBloodSugar.label" bundle="${ae_labels}"/></td>
			 <td class='fields' width='25%' tabindex='<%=++tindex%>'><input type="checkbox" name='cap_bloodSugar' id='cap_bloodSugar'  <%=capBloodSugProp%>  disabled>
			 <td class='LABEL'   width='25%' ><fmt:message key="eAE.SpO2.label" bundle="${ae_labels}"/></td>
			 <td class='fields' width='25%' tabindex='<%=++tindex%>'> 
			  <input type="checkbox" name='spo2' id='spo2'   <%=SpO2Prop%> disabled >
			 </td>
		<% } %>
	</tr>
	 <tr>
	     <td class='LABEL'   width='25%' >		 
		 <fmt:message key="eAE.FBC.label" bundle="${ae_labels}"/></td>
		 <td class='fields' width='25%' tabindex='<%=++tindex%>'> 
		 <input type="checkbox" name='fbc' id='fbc' onClick='chkOrderCat3(this);' <%=FBCProp%> <%=fbccheck%> value="<%=fbccheck_val%>">
		 </td>
		 <td class='LABEL'   width='25%' ><fmt:message key="Common.ecg.label" bundle="${common_labels}"/></td>
		 <td class='fields' width='25%' tabindex='<%=++tindex%>'> 
		 <input type="checkbox" name='ecg' id='ecg' <%=ECGProp%> disabled> 
         </td>
	 </tr>
	 <tr>
		<!--Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651 Start-->
		<% if(isOrderCatalogChngAppl){ %>
			 <td class='label' width='25%'>
				<% if(!dressingLblName.trim().equals("")){ %>
					<%=dressingLblName%>
				<% }else{%>
					<fmt:message key="Common.Compression.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Dressing.label" bundle="${common_labels}"/>
				<% } %>
				</td>
			 <td class='fields' width='25%' tabindex='<%=++tindex%>'> 
				<input type="checkbox" name='dressing' id='dressing'   <%=DressProp%> disabled>
			 </td>
			 <td class='label' width='25%'>
				<fmt:message key="Common.others.label" bundle="${common_labels}"/>
			 </td>
			 <td class='fields' width='25%' tabindex='<%=++tindex%>'> 
				<input type=text  name='initial_mgmt_others' id='initial_mgmt_others'  onKeyPress="return CheckSpecCharOnKeyPress(event)" onPaste = "return false;" value="<%=intialMgmtOthers%>" size="30" maxlength="30" <%=disIntialMgmtOthers%> >
			 </td>
		<% }else{ %><!--End-->
			 <td class='label' width='25%'><fmt:message key="Common.Dressing.label" bundle="${common_labels}"/>
			 <td class='fields' width='25%' tabindex='<%=++tindex%>'> 
			  <input type="checkbox" name='dressing' id='dressing'   <%=DressProp%> disabled>
			 </td>
			 <td class='LABEL' colspan=2>&nbsp;</td>
		<% } %>
	 </tr>
    <%}%>
	 <tr>
  		 <td class='LABEL' width='25%'><fmt:message key="eAE.Immobilization.label" bundle="${ae_labels}"/></td>
         <td class='fields' colspan='2' tabindex='<%=++tindex%>'>
				 <select name='immobilization' id='immobilization' onChange='' <%=disImmobil%> >
					<Option value=''>&nbsp;------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----&nbsp;</Option>
					 <%
			          try{
			               StringBuffer sqlImmob = new StringBuffer();
                           sqlImmob.append("select immobilization_code,short_desc from ae_immobilization_lang_vw ##REPDB## where language_id='"+locale+"' and eff_status='E'");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
						   /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
						   sqlFinal = sqlImmob.toString();
						   sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
						   /*End*/
			               pstmt=con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
						   rset = pstmt.executeQuery();
						   while(rset!=null && rset.next())
						   {
							   if(rset.getString(1).equals(immobilization))
							   {
                                    optSelected="selected";
							   }
							   else
								   optSelected="";

							    out.println( "<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+""); 
						   }
						   if(rset!=null) rset.close();
						   if(pstmt!=null) pstmt.close();
						   if((sqlImmob != null) && (sqlImmob.length() > 0))
							 {
								sqlImmob.delete(0,sqlImmob.length());
							 }
						  }catch(Exception e){e.printStackTrace();}
                 %>
                 </select> 
         </td>
		 <td colspan=2 class='LABEL' >&nbsp;</td>  

  </tr>
 <tr><td colspan=4 class=label height=5></td></tr>
  <tr>
		<td class='COLUMNHEADER' colspan='4' ><fmt:message key="Common.ATTImmunizationDetails.label" bundle="${common_labels}"/></td>
  </tr>
 <tr><td colspan=4 class=label height=5></td></tr>
  <tr>				 
		      <td class='LABEL' ><fmt:message key="Common.ImmunizationStatus.label" bundle="${common_labels}"/></td>
  		      <td class='fields' width='25%' tabindex='<%=++tindex%>'>
				 <select name='immunization_stat' id='immunization_stat' onChange='' <%=dis14%>>
					       <Option value=''>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</Option>
                           <Option value='F'<%=selected%> ><fmt:message key="Common.FullyImmunized.label" bundle="${common_labels}"/></option>
                           <Option value='P'<%=selected1%>  ><fmt:message key="Common.PartiallyImmunized.label" bundle="${common_labels}"/></option>
                           <Option value='U'<%=selected2%>  ><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
				 </select>
              </td>
  		      <td class='LABEL'  width='25%'><fmt:message key="Common.ATTGiven.label" bundle="${common_labels}"/></td>
		      <td class='fields' width='25%' tabindex='<%=++tindex%>'><input type='checkbox'  name="att_given" id="att_given"   value='' <%=checked4%> <%=dis15%> onblur="agecheck(this,'<%=ca_install_yn%>','<%=patient_age%>','<%=max_age_paediatric%>','<%=min_age_pregnancy%>','<%=sex%>');">
			  </td>
	 </tr>
	 <tr><td colspan=4 class=label height=5></td></tr>
	 </table>
		<% if (patient_age <= max_age_paediatric){
				   pediatric_status = "true";	%>

		<table  border="0" cellpadding="3" cellspacing="0" align='center' colspan=12 width="100%">
	    <tr>
		    <td class='COLUMNHEADER' colspan='8' ><fmt:message key="Common.PediatricDetail.label" bundle="${common_labels}"/></td>
	   </tr>
	 <tr><td colspan=4 class=label height=5></td></tr>
	   <tr>	
         <td class='LABEL'  width="25%" ><fmt:message key="Common.Growth/DevelMilestoneAge.label" bundle="${common_labels}"/></td>
  		 <td class='fields'  width="25%" tabindex='<%=++tindex%>'><input type='checkbox'  name="growth_age" id="growth_age"  <%=checked5%> onclick='chkhwc(event);' <%=disabled991%> <%=disabled99%>></td>
		 <td class='LABEL' width="25%"><fmt:message key="Common.Immunizationuptodate.label" bundle="${common_labels}"/></td>
		 <td class='fields'  width="25%" tabindex='<%=++tindex%>'>
		 <input type='checkbox' align='left' name="immun_date" id="immun_date"    <%=checked6%> <%=disImm%> >
         </td>
     </tr>
     <tr>
 		 <td class='LABEL' width="25%"><fmt:message key="Common.Menarche.label" bundle="${common_labels}"/></td>
		 <td  class='fields'  width="25%" tabindex='<%=++tindex%>'><input type='checkbox'  name="menarche" id="menarche"    onclick='checkmenstrual(this);' <%=checked7%> <%=disMenarche%>></td>
		 <td class='LABEL' ><fmt:message key="Common.height.label" bundle="${common_labels}"/></td>
  		 <td class='fields' tabindex='<%=++tindex%>'><input type='text'  name="height" id="height" <%=disHeight%> id='height'size="5" maxlength='6' value="<%=height%>"onKeyPress='return( allowValidNumber(this,event,3,2)); return(ChkNumberInput(this,event,0)); '
		 onBlur='SPCheckPositiveNumber(this);'>&nbsp;<fmt:message key="Common.cm.label" bundle="${common_labels}"/></td>
         
	   </tr>
       <tr>	
		 <td class='LABEL' ><fmt:message key="Common.weight.label" bundle="${common_labels}"/></td>
  		 <td class='fields' tabindex='<%=++tindex%>'><input type='text'  name="weight" id="weight" size="5" maxlength='7' value="<%=weight%>" onKeyPress='return( allowValidNumber(this,event,2,3));return(ChkNumberInput(this,event,0))'
		 onBlur='SPCheckPositiveNumber(this);'<%=disWeight%>>&nbsp;<fmt:message key="Common.kg.label" bundle="${common_labels}"/></td>
 		 <td class='LABEL' ><fmt:message key="Common.Circumference.label" bundle="${common_labels}"/></td>
  		 <td class='fields' tabindex='<%=++tindex%>'><input type='text'  name="circumference" id="circumference" size="5" maxlength='6'value="<%=circumference%>"onKeyPress='return( allowValidNumber(this,event,3,2));return(ChkNumberInput(this,event,0))'onBlur="SPCheckPositiveNumber(this);if(this.readOnly==false)agecheck(this,'<%=ca_install_yn%>','<%=patient_age%>','<%=max_age_paediatric%>','<%=min_age_pregnancy%>','<%=sex%>');"<%=disCir%>>&nbsp;&nbsp;<fmt:message key="Common.cm.label" bundle="${common_labels}"/></td>
	  </tr> 
	 <tr><td colspan=4 class=label height=5></td></tr>
 </table>
 <% } else{
			
			  disabled="";
		 }%>
   
 <%
	

		if ((sex.equalsIgnoreCase("F") && (patient_age >= min_age_pregnancy)) || (sex.equalsIgnoreCase("F") && (patient_age >= Integer.parseInt(min_age_for_lmp))) ){
				 menstrual_status = "true"; %>
				
     <table border="0" cellpadding="3" cellspacing="0" align='center' width='100%'>
	 <tr>
		    <td class='COLUMNHEADER' colspan='4' ><fmt:message key="Common.MenstrualHistory.label" bundle="${common_labels}"/></td>
	 </tr>
	 <tr><td colspan=4 class=label height=5></td></tr>
     <tr>		
     

		    <td class='LABEL' width="25%" ><fmt:message key="Common.PregnantatPresent.label" bundle="${common_labels}"/></td>
            <td class='fields' width='25%' tabindex='<%=++tindex%>'>
	         <input type='checkbox'  name="pregnant_at_present_yn_val" id="pregnant_at_present_yn_val" <%=checked8%> onClick='checkPregnant(this);if(this.checked ==false){nmdesig.innerHTML="";nmdesig1.innerHTML="";eddesig.innerHTML=""};if(this.checked ==true  ){calculateEDD(),calculateNoOfDays();}' <%=disabledPre%>></td>
			 <%
		
			 if((min_age_for_lmp!=null)&&(year_value!=null))
			 {
				minageforlmp=Integer.parseInt( min_age_for_lmp);
                yearvalue=Integer.parseInt( year_value);
              if(yearvalue>=minageforlmp)
				 {
				   %>
			<td class='LABEL' width='25%' size='20' ><fmt:message key="eAE.LMPDate.label" bundle="${ae_labels}"/></td>
            <td class='fields' width='25%' tabindex='<%=++tindex%>'><input type="text" name="lmp_date" id="lmp_date"  id="lmpdate" maxlength="10" size="8"  onblur='makeValidString(this);doDate1(this);if(this.value==""){nmdesig.innerHTML="";nmdesig1.innerHTML="";} checkPregnantDate(this);if(pregnant_at_present_yn_val.checked==true)calculateEDD(),calculateNoOfDays();'  value = "<%=DateUtils.convertDate(lmp_date,"DMY","en",localeName)%>" ><img src='../../eCommon/images/CommonCalendar.gif' name="lmp_calendar" onClick="return showCalendar('lmpdate');"  style='cursor:pointer'><img src='../../eCommon/images/mandatory.gif' id='mand2' style="visibility:hidden" align='center'></img></td> 

			<%}else{%>

			<td class='LABEL' width='25%' size='20' ><fmt:message key="eAE.LMPDate.label" bundle="${ae_labels}"/></td>
            <td class='fields' width='25%' tabindex='<%=++tindex%>'><input type="text" name="lmp_date" id="lmp_date" disabled id="lmpdate" maxlength="10" size="8"  onblur='makeValidString(this);doDate1(this); checkPregnantDate(this);calculateEDD();calculateNoOfDays();'  value = "<%=DateUtils.convertDate(lmp_date,"DMY","en",localeName)%>" ><img src='../../eCommon/images/CommonCalendar.gif' name="lmp_calendar" onClick="return showCalendar('lmpdate');" disabled    style='cursor:pointer'><img src='../../eCommon/images/mandatory.gif' id='mand2' style="visibility:hidden" align='center'></img></td> 

		<%}}%>
       </tr>
	   

	   <tr>		
          	<td class='LABEL' width='25%' ><fmt:message key="Common.POA.label" bundle="${common_labels}"/>
   		       &nbsp;
		       <font name="weekVal" id='nmdesig' class='label'></font>&nbsp;<fmt:message key="Common.weeks.label" bundle="${common_labels}"/>&nbsp;
		       <font id='nmdesig1' class='label'></font>&nbsp;<fmt:message key="Common.days.label" bundle="${common_labels}"/></td>
		       <td class='LABEL' align='left' ><fmt:message key="Common.EDD.label" bundle="${common_labels}"/>
   		       &nbsp;
		       <font name="eddVal" id='eddesig' class='label'></font> 
		    </td>
			<td colspan=2 class='LABEL' >&nbsp;</td>  
	</tr> 
   	 <tr><td colspan=4 class=label height=5></td></tr>
 </table>
<script>
/* code for calculating POA -- Weeks and Days as well as EDD values onload */

calculateNoOfDays();
calculateEDD();
 </script>
 <%  } %>

</div>


<!-- New Tab Other Details Added on 04/02/2005  -->
<%if(ca_install_yn.equals("Y")){%>
 <div id='Assessment' style= 'display:none'>
		<table cellspacing='0' cellpadding='0' width='100%' border=0 align='center'>
            <tr><td class='white'>

		<ul id="tablist" class="tablist" >
			<li class="tablistitem" title="Triage Details">
				<a class="tabA" id='Triage_tab' >
					<span class="tabAspan" onClick='javascript:expandCollapse("Triage_Details_tab")' id="Triage_tabspan"><fmt:message key="Common.TriageDetails.label" bundle="${common_labels}"/></span>
				</a>
			</li>			
			<li class="tablistitem" title="Assessment">
				<a class="tabClicked" id="assess_tab" >
					<span class="tabSpanclicked" onClick='javascript:expandCollapse("Assessment_tab")' id="assess_tabspan"><fmt:message key="Common.Assessment.label" bundle="${common_labels}"/></span>
				</a>
			</li>		
		</ul>
	</td></tr></table>
	<!-- Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 6th 2014 Start -->
	<%if(five_level_triage_appl_yn.equals("Y")){ %>
		 <table border="0" cellspacing='0' cellpadding='3'  align='center' width='100%'>
			 <tr><td class='COLUMNHEADER' colspan='4' ><fmt:message key="Common.Assessment.label" bundle="${common_labels}"/></td></tr>
			<%if(clinical_notes_status.equals("A")){%>
			
			 	<tr><td   colspan='4' ><a href="javascript:FnProceedClicnicalNotes('<%=patient_id%>','<%=episode_id%>','<%=patient_class%>','','','','<%=encounter_id%>','<%=facilityId%>','<%=loginUser%>')"><fmt:message key="Common.record.label" bundle="${common_labels}"/> <fmt:message key="Common.ClinicalNotes.label" bundle="${common_labels}"/></a></td></tr>
			<%}else{ %>
				<tr><td   colspan='4' ><a href="javascript:FnNotApplicable();"><fmt:message key="Common.record.label" bundle="${common_labels}"/> <fmt:message key="Common.ClinicalNotes.label" bundle="${common_labels}"/></a></td></tr>
			  <%}
			  if(ca_chart_rec_status.equals("A")){%>
			 	<tr><td   colspan='4' ><a href="javascript:FnProceedCARecordChart('<%=patient_id%>','<%=sys_date_qry%>','','<%=episode_id%>','<%=encounter_id%>','<%=facilityId%>')">CA <fmt:message key="eOT.RecordChart.Label" bundle="${ot_labels}"/></a></td></tr>
			<%}else{ %>
				<tr><td   colspan='4' ><a href="javascript:FnNotApplicable();">CA <fmt:message key="eOT.RecordChart.Label" bundle="${ot_labels}"/></a></td></tr>
			<%} %>
			<tr><td  colspan='4' ><a href="javascript:FnProceedRegisterPatientReferral('<%=encounter_id%>','<%=patient_id%>');"><fmt:message key="eMP.RegisterPatientReferral.label" bundle="${mp_labels}"/></a></td></tr>
		 </table>
	 <%} %>
	 <!-- Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 6th 2014 End -->
</div>
<%}	
}
else
 {
%>

<div id='Triage_Details'>
	 <table cellspacing='0' cellpadding='0' width='100%' border=0 align='center'>
            <tr><td class='white'>

		<ul id="tablist" class="tablist" >
			<li class="tablistitem" title="Triage Details">
				<a  class="tabClicked" id='Triage_Details_tab' >
					<span class="tabSpanclicked" onClick='javascript:expandCollapse("Triage_Details_tab")' id="Triage_tabspan"><fmt:message key="Common.TriageDetails.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			<%if(ca_install_yn.equals("Y")){%>
			<li class="tablistitem" title="Assessment">
				<a class="tabA" id='Assessment_tab' >
					<span class="tabAspan" onClick='javascript:expandCollapse("Assessment_tab")' id="assess_tabspan"><fmt:message key="Common.Assessment.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			<%}%> 
		</ul>
    </td></tr>
    </table>
	<table cellspacing='0' cellpadding='0' width='100%' border=0 align='center'>
      <tr><td class='white'>
			<ul id="tablist" class="tablist">
				<li class="tablistitem" title="Condition / Case">
					<a  class="tabClicked" id="Condition_tab" >
						<span class="tabSpanclicked" onClick='javascript:expandCollapse("Condition_tab")' id="patCond_tabspan"><fmt:message key="eAE.ConditionCase.label" bundle="${ae_labels}"/></span>
					</a>
				</li>
				<li class="tablistitem" title="Others">
					<a class="tabA" id="others_tab" >
						<span class="tabAspan" onClick='javascript:expandCollapse("others_tab")' id="others_tabspan"><fmt:message key="Common.others.label" bundle="${common_labels}"/></span>
					</a>
				</li>
			</ul>
       </td></tr>
</table>

<table border="0" cellpadding="2" cellspacing="0" align='center' width='100%'>
      <input type='hidden' name='sysdate' id='sysdate' value='<%=sqlDate%>'>
	  <tr>
		<td class='COLUMNHEADER' colspan='4' ><fmt:message key="Common.PatientCondition.label" bundle="${common_labels}"/></td>
	  </tr>
     <tr><input type="hidden" name='hddpriority' id='hddpriority'value=<%=priority%>>
    	
          <td class='label' width='25%' ><fmt:message key="Common.PriorityZone.label" bundle="${common_labels}"/></td>
		  <!--Added by Shanmukh on 10th-SEPT-2018 for MMS-DM-CRF-0147-->
		  <%if(isPriorityZoneAppl){%>
		  <td class='fields' width='25%'>
			<select name='Priority_Zone_Type' id='Priority_Zone_Type' onchange='setPriority(this);setTreatment(this)'<%=disPriority%>>
			<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------
						 
		<%
		try{
		sql2="SELECT PRIORITY_ZONE,PRIORITY_ZONE_DESC FROM AE_PRIORITY_ZONE_LANG_VW WHERE LANGUAGE_ID= ? and EFF_STATUS='E' and PRIORITY_ZONE not in('B','W') order by PRIORITY_ZONE_ORDER";
				
			    pstmt   = con.prepareStatement(sql2);
				pstmt.setString(1,locale) ;
				rset    = pstmt.executeQuery();
				 while(rset!=null && rset.next())
				{
					
					if(rset.getString("PRIORITY_ZONE").equals(priority))
							   {
                                    optSelected="selected";
							   }
							   else
								   optSelected="";
							   
					out.println("<option value='"+rset.getString("PRIORITY_ZONE")+"'"+optSelected+">"+rset.getString("PRIORITY_ZONE_DESC")+""); 
				}
		    }catch(Exception e){e.printStackTrace();}
						%>
					</select>
			</td>
		  <%}else{%>	
	     <% if(!five_level_triage_appl_yn.equals("Y")){%>     
	          <td class='label'   width='25%' >	<%=red%><input type="checkbox" name='priorityR' id='priorityR'   onClick='setPriority(this);setTreatment(this);' <%=priorityStatus1%> <%=disabled111%>> </td>
			  <td class='label'   width='25%' ><%=yellow%><input type="checkbox" name='priorityY' id='priorityY'    onClick='setPriority(this);setTreatment(this);' <%=priorityStatus2%> <%=disabled12%>></td> 
			  <td class='label'   width='25%' ><%=green%><input type="checkbox" name='priorityG' id='priorityG' <%=priorityStatus3%> onClick='setPriority(this);setTreatment(this);'<%=disabled13%>></td>
		<%}else{%>
			  <td class='fields'   width='25%' tabindex='<%=++tindex%>'>
	  		  <select name='prioritynew' id='prioritynew' id='prioritynew' style='' onchange='setPriority(this.value);setTreatment(this);' <%=prioritynewdisabled%>> 
	    		<option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------
	    		<% 
	    		String sql1="SELECT PRIORITY_ZONE,PRIORITY_ZONE_DESC,PRIORITY_ZONE_COLOR,PRIORITY_ZONE_ORDER FROM AE_PRIORITY_ZONE_LANG_VW ##REPDB## WHERE LANGUAGE_ID=? and EFF_STATUS='E' order by PRIORITY_ZONE_ORDER asc";//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
		       
				sql1 = sql1.replaceAll("##REPDB##",RepDb);//Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				pstmt   = con.prepareStatement(sql1.toString());
				pstmt.setString(1,locale) ;
				rset1    = pstmt.executeQuery();
				while(rset1!=null && rset1.next()){
					priority_zone_code	= rset1.getString("PRIORITY_ZONE");
					priority_zone_desc	= rset1.getString("PRIORITY_ZONE_DESC");
					priority_zone_order	=(rset1.getString("PRIORITY_ZONE_ORDER")==null || rset1.getString("PRIORITY_ZONE_ORDER")=="")?"":rset1.getString("PRIORITY_ZONE_ORDER");
					priority_zone_color = (rset1.getString("PRIORITY_ZONE_COLOR")==null || rset1.getString("PRIORITY_ZONE_COLOR")=="")?"":rset1.getString("PRIORITY_ZONE_COLOR");
					priority_zone_hidden_fileds	= priority_zone_hidden_fileds+"<input type='hidden' name='priority_zone_order_by_"+priority_zone_code+"' id='priority_zone_order_by_"+priority_zone_code+"' id='priority_zone_order_by_"+priority_zone_code+"' value='"+priority_zone_order+"'>";
					if(priority.equals(priority_zone_code)){
						priority_selected	= "selected";
						priority_no			= priority_zone_order;
					}else{
						priority_selected	= "";
					}
				%>
					<option value='<%=priority_zone_code%>' style='background-color:<%=priority_zone_color%>;' <%=priority_selected%>><%=priority_zone_desc%></option>
				
				<%}%>
	  	 	 </select>
	  	  </td>
		<%} %>	 
	<%}%>	
		</tr> 
		              <tr>
					  <td class='label' width='25%' ><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
					   <td class='fields' width='25%' ><select name='priority11' id='priority11' <%=disPriority%>>
				  <option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------
                  <%
					   
                       StringBuffer sqlpriority = new StringBuffer();
					   sqlpriority.append("select PRIORITY_CODE,SHORT_DESC from ");
					   sqlpriority.append("ae_pat_priority_lang_vw ##REPDB## where language_id='"+locale+"'  and PRIORITY_ZONE=? and EFF_STATUS='E'");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1

					   /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
					   sqlFinal = sqlpriority.toString();
					   sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
					   /*End*/
	                     				
						 pstmt = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
						 pstmt.setString(1,priority);
					     rset = pstmt.executeQuery();
						 
						 while(rset!=null && rset.next())
						   {
							   if(rset.getString(1).equals(priority_code))
							   {
                                    optSelected="selected";
							   }
							   else
								   optSelected="";

							   out.println("<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+" ");
							  
						   }
						 if(pstmt!=null) pstmt.close();
						 if(rset!=null) rset.close();
						 if((sqlpriority != null) && (sqlpriority.length() > 0))
						 {
							sqlpriority.delete(0,sqlpriority.length());
						 }
					   %>  
					</select>
		  </td>
					  </tr> 
		   
		<tr> 
			  <td class='LABEL'  width='25%' ><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/></td>
			  <td class='fields' width='25%' >
			   <%
				 StringBuffer sqlTreatA = new StringBuffer();
				 sqlTreatA.append("SELECT treatment_area_code, short_desc FROM ae_tmt_area_for_clinic_lang_vw ##REPDB## WHERE language_id='"+locale+"'  and facility_id = ? AND clinic_code = ?  AND priority_zone = ?  AND  (gender = ? OR gender IS NULL) ");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1

				 /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
				 sqlFinal = sqlTreatA.toString();
				 sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
				 /*End*/
				 pstmt = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				 pstmt.setString(1,facilityId);
				 pstmt.setString(2,clinic_code);
				 pstmt.setString(3,priority);
				 pstmt.setString(4,patient_gender);

				 rset = pstmt.executeQuery();
				 
				 while(rset!=null && rset.next())
				   {
					 String code =rset.getString(1);
					 String desc =specialCharacter(rset.getString(2));
					 if (code.equals("null") || code==null) 
						 code="";
					  if (desc.equals("null") || desc==null) 
						 desc="";
					  if(code.equals(treat_code))
					   {
							optSelectedTreat="selected";
					   }
					   else
						   optSelectedTreat="";
			   
					   sbBuff.append("<option value=\""+code+"\" "+optSelectedTreat+">"+desc+"</option>");
				  }
				 if(pstmt!=null) pstmt.close();
				 if(rset!=null) rset.close();
				 if((sqlTreatA != null) && (sqlTreatA.length() > 0))
				 {
					sqlTreatA.delete(0,sqlTreatA.length());
				 }
			   %> 
			   <select name='treat_area' id='treat_area'  <%=disTreatArea%> onChange='clearBed();'>
				<option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
				<%=sbBuff.toString()%>
			    </select>
			 </td>
				   <!-- onblur="ChangeUpperCase(this);checkForValidBed(this.value);" -->
			 <td class='label' width='25%'><fmt:message key="eAE.BedBayNo.label" bundle="${ae_labels}"/></td>
			 <td class='fields' width='25%' ><input type='text' name='bed_bay_no' id='bed_bay_no' size='8' maxlength='8' onblur="ChangeUpperCase(this);" onKeyPress="return(CheckForSpecChars(event))"  value ='<%=bed_no%>' <%=disBed%>><input type=button class=button value='?' name='bed_button' id='bed_button'  onClick="callBedAvailChart();" <%=disBed1%>>
             </td>
		  </tr>
          <tr> 
             <td class='label' ><fmt:message key="Common.Disaster.label" bundle="${common_labels}"/></td>
			 <td class='fields' width='25%' ><input type="checkbox" name='Disaster_YN' id='Disaster_YN'  onClick='setDisaster(this)'<%=checked1%> <%=disDisaster%>></td>
			 <%
			 if(allowSplChar)
			 {
			 %>
			 <td class='label' ><fmt:message key="eAE.DisasterReference.label" bundle="${ae_labels}"/></td>
			 <td class='fields' width='25%' tabindex='<%=++tindex%>'><input type="text" name='Disaster_Reference' id='Disaster_Reference'  onKeyPress="return CheckForSpecChar(event)"
			  value="<%=dis_regn_ref%>" maxLength="15" <%=disabled11%> ></td>
             <td class='label' colspan='2'>&nbsp;</td>
			 <%
			 }
			 else
			 {
			%>
			 <td class='label' ><fmt:message key="eAE.DisRegnReference.label" bundle="${ae_labels}"/></td>
			 <td class='fields' width='25%' tabindex='<%=++tindex%>'><input type="text" name='Disaster_Reference' id='Disaster_Reference'   onKeyPress="return CheckForSpecChars(event)" 
           value='<%=dis_regn_ref%>' maxLength='15' <%=disabled11%> ></td>
             <td class='label' colspan='2'>&nbsp;</td>
			 <%
			 }
			 %>
			 
		  </tr> 
		  <tr>
			 <td class='label' width='25%'><fmt:message key="eAE.DisasterArea.label" bundle="${ae_labels}"/></td>
			 <td class='fields' width='25%'  ><input type='text'  name="disaster_area1" id="disaster_area1" value="<%=dis_area%>" maxLength='10' onblur='if(this.value !="")searchDisasterArea(this,disaster_area1);'  <%=disabled11%>><input type='button' name='disaster' id='disaster' value='?' class='button'   onclick='searchDisasterArea(this,disaster_area1);' <%=disabled11%> >
             </td>
		      <td class='LABEL' width='25%'><fmt:message key="eAE.DisasterType.label" bundle="${ae_labels}"/></td>
			 <td class='fields' width='25%' >
				 <select name='disaster_type' id='disaster_type' <%=disabled11%>>
				  <option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------
			<%  
                  try
				  {	
				   PreparedStatement pstmtTrans = null;
				   ResultSet rsetTrans = null;
				   optSelected="";
                   //pstmtTrans = con.prepareStatement("select disaster_type_code, short_desc from ae_disaster_type_lang_vw  where language_id='"+locale+"'  and  eff_status='E' order by short_desc");
				   /*Above line commented and below code added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
				   sqlFinal = "select disaster_type_code, short_desc from ae_disaster_type_lang_vw ##REPDB## where language_id='"+locale+"'  and  eff_status='E' order by short_desc";
				   sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
				   pstmtTrans = con.prepareStatement(sqlFinal);
				   /*End*/
				
				   rsetTrans = pstmtTrans.executeQuery();
				   
				   while(rsetTrans!=null && rsetTrans.next())
					{
					  if(rsetTrans.getString(1).equals(disaster_type_code))
							   {
                                    optSelected="selected";
							
							   }
							   else
							   {
								   optSelected="";
							      
							   }
					  out.println("<option value='"+rsetTrans.getString("disaster_type_code")+"' "+optSelected+" >"+rsetTrans.getString("short_desc")+""); 
					}
                  if(rsetTrans!=null) rsetTrans.close();
				  if(pstmtTrans!=null) pstmtTrans.close();
				  }catch(Exception e) {e.printStackTrace();}
	            %>
                 </select>
              </td>
           </tr>
	      <tr>
			 <input type='hidden' id='regndatetime' name="visit_date_time" id="visit_date_time"  value='<%=visit_date%>'>
			 <%if(modify_flag.equals("Y")) { %>
		      <td class='LABEL'  width='25%' tabindex='<%=++tindex%>' ><fmt:message key="Common.ambulatorystatus.label" bundle="${common_labels}"/></td>
  		      <td class='fields' width='25%' >
				 <select name='ambulatory_status' id='ambulatory_status' <%=dis1%>>
				  <option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------
					   <%
						   pstmt = con.prepareStatement(AmbulatorySql);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
					       rset = pstmt.executeQuery();
						   
						   optSelected="";
						   while(rset!=null && rset.next())
						   {
							   if(rset.getString(1).equals(a_status))
							   {
                                    optSelected="selected";
							
							   }
							   else
							   {
								   optSelected="";
							      
							   }
							  
                              out.println("<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+" ");
						   }
						   if(pstmt!=null) pstmt.close();
						   if(rset!=null) rset.close();
						   if((sqlAmbulatory != null) && (sqlAmbulatory.length() > 0))
							 {
								sqlAmbulatory.delete(0,sqlAmbulatory.length());
							 }

					   %>
                 </select>
              </td>
			   <!--Bewlow line added for this CRF AAKH-CRF-0010 [IN038535]-->
			
		<td class='LABEL' width='25%' style='<%=leveloftriage_visibility%>'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
		<td class='fields' width='25%' style='<%=leveloftriage_visibility%>'>
		<input type=text  name=practitioner_desc size=30 maxlength=30 value="<%=attend_practitioner_name%>" onBlur="beforeGetPractitioner(document.forms[0].pract_button,practitioner_desc);" <%=dis16%>><input type=button class=button value='?' name=pract_button   onclick="aegetPractitioner(this,practitioner_desc);" <%=dis16%>><input type=hidden value="<%=attend_practitioner_id%>" name="attend_pract_id" id="attend_pract_id"><input type=hidden value="<%=attend_practitioner_id%>" name="prev_pract_id" id="prev_pract_id"></td>
		   <!--End AAKH-CRF-0010 [IN038535]-->
             <%
		     } if(modify_flag.equals("N")) {
		     %>
              <td class='LABEL'  width='25%' ><fmt:message key="Common.ambulatorystatus.label" bundle="${common_labels}"/></td>
  		      <td  class='fields' width='25%' >
				 <select name='ambulatory_status' id='ambulatory_status' >
				  <option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------
					   <%
						   pstmt = con.prepareStatement(AmbulatorySql);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
					       rset = pstmt.executeQuery();
						   
						   optSelected="";
						   while(rset!=null && rset.next())
						   {
							  
                              out.println("<option value='"+rset.getString(1)+"'>"+rset.getString(2)+" ");
						   }
						   if(pstmt!=null) pstmt.close();
						   if(rset!=null) rset.close();
						   if((sqlAmbulatory != null) && (sqlAmbulatory.length() > 0))
							 {
								sqlAmbulatory.delete(0,sqlAmbulatory.length());
							 }
					   %>
                 </select>
              </td>
			  <%}%>
              </td>
			  <td class='LABEL' width='25%' colspan='2'></td>

          </tr>	 
		  <!--Below line added for this CRF ML-MMOH-CRF-0654-->
		   
		  <%if(modeofarrival){%>		   
		   <tr>
		    <td class='LABEL' width='25%' ><fmt:message key="Common.ModeofArrival.label" bundle="${common_labels}"/></td>
			<td class='fields'  colspan='3'>
				   <select name='transport_mode' id='transport_mode' onChange="remVal(document.forms[0].mode_of_arrival);setTransMode(this);" >
				    	<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------
                <%  
				   PreparedStatement pstmtTrans = null;
				   ResultSet rsetTrans = null;
				   optSelected="";
				   StringBuffer sqlAMTrans = new StringBuffer();
                   sqlAMTrans.append("SELECT transport_mode, short_desc FROM am_transport_mode_lang_vw ##REPDB## WHERE language_id='"+locale+"' and PATIENT_RELATED_YN='Y' AND eff_status = 'E' ORDER BY 2 ");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1

				   /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
				   sqlFinal = sqlAMTrans.toString();
				   sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
				   /*End*/
                   pstmtTrans = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1					
				   rsetTrans = pstmtTrans.executeQuery();
				  while(rsetTrans!=null && rsetTrans.next()){	
				  
						if(rsetTrans.getString(1).equals(transport_mode_code)){
							optSelected="selected";								
						}else{
							optSelected="";							      
						}							  
                       out.println("<option value='"+rsetTrans.getString(1)+"'"+optSelected+">"+rsetTrans.getString(2)+" ");
					 					
				  }
				  if(pstmtTrans!=null) pstmtTrans.close();
				  if(rsetTrans!=null) rsetTrans.close();
				  if((sqlAMTrans != null) && (sqlAMTrans.length() > 0))
				  {
						sqlAMTrans.delete(0,sqlAMTrans.length());
				   }
	            %>
				   </select>
                   <select name='mode_of_arrival' id='mode_of_arrival' >
						 <option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------
				   </select>
		    </td> 
		    </td> 
          </tr>	
          <tr>
            <td class='LABEL'  width='25%' ><fmt:message key="eAE.AccompaniedBy.label" bundle="${ae_labels}"/></td>
			<td class='fields'  width='25%'>
				 <select name='accompany_by' id='accompany_by' <%=accompanied_by_dis%>>
					<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---
				<%  
				   PreparedStatement pstmtAccom = null;
				   ResultSet rsetAccom = null;
				   optSelected="";	
				   StringBuffer sqlAMEsc = new StringBuffer();
                   sqlAMEsc.append("SELECT ESCORT_TYPE_CODE, SHORT_DESC  FROM  AM_ESCORT_TYPE_LANG_VW ##REPDB## WHERE language_id='"+locale+"' AND EFF_STATUS='E' ORDER BY 2 ");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1

				   /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
				   sqlFinal = sqlAMEsc.toString();
				   sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
				   /*End*/
				   pstmtAccom = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				   rsetAccom = pstmtAccom.executeQuery();
				   while(rsetAccom!=null && rsetAccom.next()){
					 
						if(rsetAccom.getString(1).equals(accompanied_by_code)){
							optSelected="selected";								
						}else{
							optSelected="";							      
						}							  
						   out.println("<option value='"+rsetAccom.getString(1)+"'"+optSelected+">"+rsetAccom.getString(2)+" ");
										
					}
				   if(rsetAccom!=null) rsetAccom.close();
				   if(pstmtAccom!=null) pstmtAccom.close(); 
				   if((sqlAMEsc != null) && (sqlAMEsc.length() > 0))
					{
						sqlAMEsc.delete(0,sqlAMEsc.length());
					}
	             %> 
				 </select>
			</td>
			<td class='label'  colspan='2'>&nbsp;</td> 
          </tr>		  
		  <%}%>
		  <!--End ML-MMOH-CRF-0654-->
		   
		 <!-- <%if(modeofarrival && modify_flag.equals("N")){%>		   
		   <tr>
		    <td class='LABEL' width='25%' ><fmt:message key="Common.ModeofArrival.label" bundle="${common_labels}"/></td>
			<td class='fields'  colspan='3'>
				   <select name='transport_mode' id='transport_mode' onChange="remVal(document.forms[0].mode_of_arrival);setTransMode(this);" >
				    	<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------
                <%  
				   PreparedStatement pstmtTrans = null;
				   ResultSet rsetTrans = null;
				   StringBuffer sqlAMTrans = new StringBuffer();
                   sqlAMTrans.append("SELECT transport_mode, short_desc FROM am_transport_mode_lang_vw WHERE language_id='"+locale+"' and PATIENT_RELATED_YN='Y' AND eff_status = 'E' ORDER BY 2 ");
                   pstmtTrans = con.prepareStatement(sqlAMTrans.toString());
					
				   rsetTrans = pstmtTrans.executeQuery();
				  while(rsetTrans!=null && rsetTrans.next())
					 {
					out.println("<option value='"+rsetTrans.getString(1)+"'>"+rsetTrans.getString(2)+""); 
					 }
				  if(pstmtTrans!=null) pstmtTrans.close();
				  if(rsetTrans!=null) rsetTrans.close();
				  if((sqlAMTrans != null) && (sqlAMTrans.length() > 0))
				  {
						sqlAMTrans.delete(0,sqlAMTrans.length());
				   }
	            %>
				   </select>
                   <select name='mode_of_arrival' id='mode_of_arrival' >
						 <option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------
				   </select>
		    </td> 
		    </td> 
          </tr>	
          <tr>
            <td class='LABEL'  width='25%' ><fmt:message key="eAE.AccompaniedBy.label" bundle="${ae_labels}"/></td>
			<td class='fields'  width='25%'>
				 <select name='accompany_by' id='accompany_by' >
					<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---
				<%  
				   PreparedStatement pstmtAccom = null;
				   ResultSet rsetAccom = null;
				   StringBuffer sqlAMEsc = new StringBuffer();
                   sqlAMEsc.append("SELECT ESCORT_TYPE_CODE, SHORT_DESC  FROM  AM_ESCORT_TYPE_LANG_VW WHERE language_id='"+locale+"' AND EFF_STATUS='E' ORDER BY 2 ");
				   pstmtAccom = con.prepareStatement(sqlAMEsc.toString());
				   rsetAccom = pstmtAccom.executeQuery();
				   while(rsetAccom!=null && rsetAccom.next())
					 {
					out.println("<option value='"+rsetAccom.getString(1)+"'>"+rsetAccom.getString(2)+""); 
					 }
				   if(rsetAccom!=null) rsetAccom.close();
				   if(pstmtAccom!=null) pstmtAccom.close(); 
				   if((sqlAMEsc != null) && (sqlAMEsc.length() > 0))
					{
						sqlAMEsc.delete(0,sqlAMEsc.length());
					}
	             %> 
				 </select>
			</td>
			<td class='label'  colspan='2'>&nbsp;</td> 
          </tr>		  
		  <%}%> -->
		  <!--End ML-MMOH-CRF-0654-->
		  
		  
		  
		  <tr> 
			  <td class='label'   width='25%'><fmt:message key="Common.referralid.label" bundle="${common_labels}"/></td> 
			 <%if(pat_dtls_unknown_yn.equals("N")){%>
				  <td class='fields' width='25%' ><input type='text' name='referral_id' id='referral_id' value="<%=referral_id%>" maxlength='14' size='14'  onBlur='searchPatient(document.forms[0].referral_id);' <%=disRefID%>><input type='button' class='button' value='?' name='ref_id_search' id='ref_id_search'   onClick='getReferralID()' <%=disRefID%>></td>
			<%}else if(pat_dtls_unknown_yn.equals("Y")) {%>
				<td  class='fields' width='25%'><input type='text' name='referral_id' id='referral_id' value='' maxlength='14' size='14'  onBlur=''  align='left' disabled><input type='button' class='button' value='?' name='ref_id_search' id='ref_id_search' onClick='getReferralID()' disabled></td>
		   <%}%>
	     <input type='hidden' name='injury_3' id='injury_3' value=''>

			<!--Added by Ashwini on 22-May-2017 for ML-MMOH-CRF-0650-->
			<%if(!isReplacePresntngPrblmByChiefComp){ %>
			  <td class='LABEL' width='25%' ><fmt:message key="Common.PresentingProblem.label" bundle="${common_labels}"/></td>
			  <td class='fields' width='25%' ><input type='text'  name="complaint_desc" id="complaint_desc" value="<%=complaint%>" onblur='if(this.value !="")searchComplaintType(this,complaint_desc);' <%=dis3%>><input type='button' name='Complainttype' id='Complainttype' value='?' class='button' onclick='searchComplaintType(this,complaint_desc);' <%=dis3%>>
			  </td>	
			<%}%>
		 </tr> 
		 <tr> 
					<td class='LABEL' width='25%' ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
					<td class='fields' width='25%' colspan='3' ><textarea name='triage_remarks' cols='50'   align='left'  onblur='makeValidString(this);checkMaxLen(this);' onkeypress='checkMaxLimit(this,250);' <%=dis2%>><%=triage_remarks%></textarea>
		  </td>
		  </tr>  

		 <tr>
					<td class='COLUMNHEADER' colspan='4' ><fmt:message key="eAE.CaseDetails.label" bundle="${ae_labels}"/></td>
		 </tr>
	 <!--Added by Thamizh selvi on 8th Mar 2018 against ML-MMOH-CRF-0645 Start-->
	 <% if(isCaseDtlsRadioBtnAppl){ %>
		<tr>
		<td colspan=4>
		<table border='0' cellpadding='0' cellspacing='0' width='100%'>		
			<tr>
				<td class='label' width='17%'>
					<!--Modified by Ashwini on 18-Jan-2021 for ML-MMOH-CRF-1409-->
					<fmt:message key="Common.CaseofTrauma.label" bundle="${common_labels}"/>
				</td>
				<td class='fields' width='7%'>
					<input type='radio' name='caseDetails' id='caseDetails' tabindex='<%=++tindex%>' id='trauma' value='N' onClick='caseDetailsOnChange(this);' <%=checked9%> <%=dis5%>></input>
				</td>
				<td class='label' width='10%'>
					<fmt:message key="Common.oscc.label" bundle="${common_labels}"/>
				</td>
				<td class='fields' width='7%'>
					<input type='radio' name='caseDetails' id='caseDetails' tabindex='<%=++tindex%>' id='oscc' value='N' onClick='caseDetailsOnChange(this);' <%=disOscc%> <%=checked2%>></input>
				</td>
				<td class='label' width='10%'>
					<span id='osccTypeLabel' style="visibility:hidden"><fmt:message key="Common.oscc.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.type.label" bundle="${common_labels}"/></span>
				</td>
				<td class='fields' width='16%'>
					<select name='osccType' id='osccType' style="visibility:hidden" tabindex='<%=++tindex%>' <%=dis7%>>
						<option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------
						<%
								JSONArray osccTypeJsonArr	= new JSONArray();
								osccTypeJsonArr  = eAE.AECommonBean.getOSCCTypeList(con,locale,RepDb);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1	
									
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
				<td class='label'  width='17%'>
					<fmt:message key="Common.medical.label" bundle="${common_labels}"/>
				</td>
				<td class='fields' width='7%'>
					<input type='radio' tabindex='<%=++tindex%>' name="caseDetails" id='medical' value='N' onClick='caseDetailsOnChange(this);' <%=checkedMed%> <%=disMed%>></input>
				</td>
				<td class='label' width='10%'>
					<fmt:message key="Common.Surgical.label" bundle="${common_labels}"/>
				</td>
				<td class='fields' width='7%'> 
					<input type='radio' tabindex='<%=++tindex%>' name="caseDetails" id='surgical' value='N' onClick='caseDetailsOnChange(this);' <%=checkedSur%> <%=disSur%>></input> 
				</td>
			</tr>
			<tr>
				<td class='label'  width='17%'>
					<fmt:message key="eAE.OandG.label" bundle="${ae_labels}"/>
				</td>
				<td class='fields' width='7%' tabindex='<%=++tindex%>' >
					<input type='radio' name="caseDetails" id="caseDetails" id='OandG' value='N' onClick='caseDetailsOnChange(this);' <%=checkedOandGYn%> <%=disOandGYn%>></input>
				</td>
			</tr>
		</table>
		</td>
		</tr>
		<input type='hidden' name='oscc_yn' id='oscc_yn' value='<%=oscc_yn%>'>
		<input type='hidden' name='medical_yn' id='medical_yn' value='<%=medical_yn%>'>
		<input type='hidden' name='surgical_yn' id='surgical_yn' value='<%=surgical_yn%>'>
	 <% }else{ %>
	 <!--End-->
		 <tr>  
			        <td class='label' width='25%'><fmt:message key="Common.CaseofTrauma.label" bundle="${common_labels}"/></td>
			        <td class='fields' width='25%' ><input type='checkbox'   name="CaseofTrauma" id="CaseofTrauma"  onClick='checktrauma(this);setMechInj1(this);' <%=checked9%> <%=dis5%>>
					</td>	
					<td class='label' width='25%'><fmt:message key="Common.oscc.label" bundle="${common_labels}"/></td>
                    <td class='fields' width='25%' ><input type='checkbox'  name="oscc_yn" id="oscc_yn"   value='<%=oscc_yn%>' onClick='chkOsccValue(this);remVal(document.forms[0].mechan_injury);setMechInj();' <%=disOscc%> <%=checked2%>>
					<!-- <%=checked2%> <%=disable3%> --> </td>
         </tr>
		 <tr> 
					<td class='label'  width='25%'><fmt:message key="Common.medical.label" bundle="${common_labels}"/></td>
					<td class='fields' width='25%' ><input type='checkbox'  name="medical_yn" id="medical_yn"  onClick='chkMedicalValue(this);' <%=checkedMed%> <%=disMed%>></td>
					<td class='label'  width='25%' ><fmt:message key="Common.Surgical.label" bundle="${common_labels}"/></td>
					<td class='fields' width='25%' > <input type='checkbox'  name="surgical_yn" id="surgical_yn"   value='' onClick='chkSurgValue(this);' <%=checkedSur%> <%=disSur%>> 
					</td>
		 </tr>
		 <% } %>
				<input type='hidden' name='patient_id' id='patient_id' value=<%=patient_id%>>
				<input type='hidden' name='called_from_ca' id='called_from_ca' value=<%=called_from_ca%>>
				<!-- Added by Ajay Hatwate for ML-MMOH-CRf-1653 -->

		<% if(caseTypeYn.equals("Y")){ %>
		 <tr>	
	      <td class='LABEL' width='25%' ><fmt:message key="eAE.CaseType.label" bundle="${ae_labels}"/></td>
		      <td class='fields' width='25%' >
			 <select name='case_type' id='case_type' <%=caseTypeDisable%>>
			 <option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------
			  <%
			   StringBuffer sqlCaseType = new StringBuffer();
			 	 
			 
			   sqlCaseType.append("SELECT case_type_code, short_desc FROM ae_case_type WHERE EFF_STATUS ='E' ORDER BY 2");

			   pstmt = con.prepareStatement(sqlCaseType.toString());
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
		
				
				
		 <tr>
		 <% if(isCaseDtlsRadioBtnAppl){ %>
		 <tbody id='placeOfOccMechInjFieldsDisplay' style="display:none;">
		 <% } %>
		 <!-- if else added by mujafar for ML-MMOH-CRF-0647 -->
			<%if(isPlaceOfOccuurrence == true){%>
	          <td class='label' width='25%'><fmt:message key="eAE.DateTimeOfOccurrence.label" bundle="${ae_labels}"/></td>
			 <%
			}else{%>
			<td class='label' width='25%'><fmt:message key="eAE.DateTimeOfAccident.label" bundle="${ae_labels}"/></td>
			<%}%>
			
			  
  		      <td class='fields' width='25%' >
			  <input type='text'  id='accidentdatetime' name='date_time_accident' id='date_time_accident'   maxLength='16' size='16' 
			  value="<%=DateUtils.convertDate(date_time_of_accident,"DMYHM","en",localeName)%>"  onBlur='doDate(this);' <%=disDateAcci%>><img src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('accidentdatetime', null, 'hh:mm' );" style='cursor:pointer' <%=disDateAcci%> ></img><img src='../../eCommon/images/mandatory.gif' id='dateOfOccurImg' style="visibility:hidden" align='center'></td><!--Added mandatory image for ML-MMOH-CRF-0648 on 5th Apr 2018 by Thamizh selvi-->
<%-- 			  <img src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('accidentdatetime', null, 'hh:mm' );" style='cursor:pointer' <%=disDateAcci%> ></img> --%>
			  <img src='../../eCommon/images/CommonCalendar.gif'  onClick="if (!document.getElementById('accidentdatetime').disabled) {return showCalendar('accidentdatetime', null, 'hh:mm' )}"  <%=disDateAcci%>>
			  <img src='../../eCommon/images/mandatory.gif' id='dateOfOccurImg' style="visibility:hidden" align='center'></td><!--Added mandatory image for ML-MMOH-CRF-0648 on 5th Apr 2018 by Thamizh selvi-->

			<!--Added by Ashwini on 19-Jan-2017 for GDOH-CRF-0131-->
			<!-- if else added by mujafar for ML-MMOH-CRF-0647 -->
			<!--Modified by Ashwini on 17-Aug-2017 for GDOH-CRF-0161-->
			  <%if(isLabelChngAppl == true){ %>
			  <td class='label' width='25%'><fmt:message key="eAE.PlaceOfAccident.label" bundle="${ae_labels}"/>/<fmt:message key="eAE.PickupPlace.label" bundle="${ae_labels}"/></td>
			  <%}
			  else if(isPlaceOfOccuurrence == true){
			  %>
			  <td class='LABEL' width='25%' ><fmt:message key="eAE.PlaceOfOccurrence.label" bundle="${ae_labels}"/></td>
			  <%
			  }
			  else{
				%><td class='label' width='25%' ><fmt:message key="eAE.PlaceOfAccident.label" bundle="${ae_labels}"/></td>
				<%} %>

			<%if(isPlaceOfOccuurrence == false){%>
			  <td class='fields' width='25%' ><input type='text' name="place_of_accident" id="place_of_accident"  maxLength='30' size='25'   value="<%=place_of_accident%>" onBlur="makeValidString(this)" <%=disPlaceAcci%>></td>
			<%}
			else
			{%> 
			 <td class='fields' width='25%'><select name='place_of_accident' id='place_of_accident' <%=disPlaceAcci%> >
			   <option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option> 
                <%  
                   try
				  {	
				   PreparedStatement pstmtTrans = null;
				   ResultSet rsetTrans = null;
				   optSelected="";
                   //pstmtTrans = con.prepareStatement("select PLACE_OCCURRENCE_TYPE_CODE, short_desc from AE_PLACE_OF_OCCURRENCE where  eff_status='E' order by short_desc");
				   /*Above line commented and below line added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
				   sqlFinal = "select PLACE_OCCURRENCE_TYPE_CODE, short_desc from AE_PLACE_OF_OCCURRENCE ##REPDB## where  eff_status='E' order by short_desc";
				   sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
				   pstmtTrans = con.prepareStatement(sqlFinal);
				   /*End*/
				
				   rsetTrans = pstmtTrans.executeQuery();
				   
				   while(rsetTrans!=null && rsetTrans.next())
					{
					  if(rsetTrans.getString(1).equals(place_of_accident))
							   {
                                    optSelected="selected";
							
							   }
							   else
							   {
								   optSelected="";
							      
							   }
					  out.println("<option value='"+rsetTrans.getString("PLACE_OCCURRENCE_TYPE_CODE")+"' "+optSelected+" >"+rsetTrans.getString("short_desc")+""); 
					}
                  if(rsetTrans!=null) rsetTrans.close();
				  if(pstmtTrans!=null) pstmtTrans.close();
				  }catch(Exception e) {/* out.println("Exception in Place of Occurrence="+e); */			e.printStackTrace();}
	            %>
				</select><img src='../../eCommon/images/mandatory.gif' id='placeOfOccurImg' style="visibility:hidden" align='center'><!--Added mandatory image for ML-MMOH-CRF-0648 on 5th Apr 2018 by Thamizh selvi-->
				</td>
		
			<%}%>
	     </tr>
	     <tr>	
		           <td class='LABEL' width='25%' >
						<!--Added by Thamizh selvi on 29th Mar 2018 against ML-MMOH-CRF-0649 Start-->
						<% if(isMechInjLabelChngAppl){ %>
							<fmt:message key="eAE.MechOfMainInj.label" bundle="${ae_labels}"/>
						<% }else{ %><!--End-->
							<fmt:message key="Common.MechanismofInjury.label" bundle="${common_labels}"/>
						<% } %>
				   </td>
				<!--Added by Thamizh selvi on 29th Mar 2018 against ML-MMOH-CRF-0649 Start-->
				<% if(isMechInjLabelChngAppl){ %>
  					<td class='fields' width='25%'>
				<% }else{ %><!--End-->
					<td class='fields' width='25%' colspan='2' >	
				<% } %>
				   <select name='mechan_injury' id='mechan_injury' onChange='setInjury(this)' <%=dis6%>> 
				    <option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------
					   <%
					 // if(modify_flag.equals("Y")) {
						 StringBuffer sqlMechaInjury = new StringBuffer();
						 sqlMechaInjury.append("SELECT INJ_CATEGORY_CODE,SHORT_DESC FROM AE_INJURY_CATEGORY_LANG_VW ##REPDB## WHERE language_id='"+locale+"'  and EFF_STATUS='E' and   oscc_yn=  '"+oscc_yn+"'  ORDER BY 2 ");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
						 /*modify_flag is commented and above query is modifed by Rameswar on 04-Oct-16 for GDOH-CRF-0004.2*/

						 /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
						 sqlFinal = sqlMechaInjury.toString();
						 sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
						 /*End*/
						 pstmt = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
					     rset = pstmt.executeQuery();
						 	 optSelected="";
						 while(rset!=null && rset.next())
						   {
							   if(rset.getString("INJ_CATEGORY_CODE").equals(mech_injr_code))
							   {
                                    optSelected="selected";
															
							   }
							   else
								   optSelected="";

                              out.println("<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+" ");
						   }
						 if(pstmt!=null) pstmt.close();
						 if(rset!=null) rset.close();
						 if((sqlMechaInjury != null) && (sqlMechaInjury.length() > 0))
						 {
							sqlMechaInjury.delete(0,sqlMechaInjury.length());
						 }
					//   }  
						 %>  
                 </select><img src='../../eCommon/images/mandatory.gif' id='mand4' style="visibility:hidden" align='center'></img>
				 <% if(!isMechInjLabelChngAppl){ %><!--Added by Thamizh selvi on 29th Mar 2018 against ML-MMOH-CRF-0649-->
				 <font  class='label'></font>&nbsp;&nbsp;&nbsp;<fmt:message key="Common.and.label" bundle="${common_labels}"/>
				 <% } %>
              </td>
			  <!--Added by Thamizh selvi on 29th Mar 2018 against ML-MMOH-CRF-0649 Start-->
			  <% if(isMechInjLabelChngAppl){ %>
				<td class='LABEL' width='25%'><fmt:message key="eAE.MechaofSubInjury.label" bundle="${ae_labels}"/></td>
			  <% } %><!--End-->
  		      <input type='hidden' name='mech_sub_code' id='mech_sub_code' value=<%=mech_injury_subcatg_code%> >
			 <td class='fields' width='25%' >
				<select name='injury' id='injury'  <%=dis7%>>
				  <option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------
				</select><img src='../../eCommon/images/mandatory.gif' id='mand5' style="visibility:hidden" align='center'></img>
              </td> 
	  </tr>
	  <% if(isCaseDtlsRadioBtnAppl){ %>
	  </tbody>
	  <% } %>
	  <tr>	
		      <td class='LABEL' width='25%' ><fmt:message key="Common.VehiclesInvolved.label" bundle="${common_labels}"/></td>
  		      <td class='fields' width='25%' colspan='2' >
				 <select name='vehicle_invol' id='vehicle_invol' <%=dis8%>>
				  <option value='' >--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------
					   <%
						 StringBuffer sqlVehicleInv = new StringBuffer();
						 //sqlVehicleInv.append("select ARRIVAL_CODE, SHORT_DESC ARRIVAL_SHORT_DESC from am_arrival_lang_vw where language_id='"+locale+"'  and EFF_STATUS='E' and facility_id='"+facilityId+"'  order by 2");

						 sqlVehicleInv.append("select ARRIVAL_CODE, SHORT_DESC ARRIVAL_SHORT_DESC from am_arrival_lang_vw ##REPDB## where language_id='"+locale+"'  and EFF_STATUS='E' and facility_id='"+facilityId+"' and ARRIVAL_CODE like '%%' order by 2");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
							
						 /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
						 sqlFinal = sqlVehicleInv.toString();
						 sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
						 /*End*/
						 pstmt = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
					     rset = pstmt.executeQuery();
						 optSelected="";
						 while(rset!=null && rset.next())
						   {
							   if(rset.getString(1).equals(vehicle_invlovedcode))
							   {
                                    optSelected="selected";
															
							   }
							   else
								   optSelected="";
                              out.println("<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+" ");
						   }
						 if(pstmt!=null) pstmt.close();
						 if(rset!=null) rset.close();
					   %>
                 </select><font  class='label'></font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.and.label" bundle="${common_labels}"/>
              </td>
			  <td class='fields' width='25%' >
				<select name='vehicle_invol1' id='vehicle_invol1' <%=dis9%>>
				  <option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------
				<%
						 pstmt = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
					     rset = pstmt.executeQuery();
						 optSelected="";
						 while(rset!=null && rset.next())
						   {
							   if(rset.getString(1).equals(vehicle_invlovedcode1))
							   {
                                    optSelected="selected";
															
							   }
							   else
								   optSelected="";
                              out.println("<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+" ");
						   }
						 if(pstmt!=null) pstmt.close();
						 if(rset!=null) rset.close();
						 if((sqlVehicleInv != null) && (sqlVehicleInv.length() > 0))
						 {
							sqlVehicleInv.delete(0,sqlVehicleInv.length());
						 }
					   %>
				</select>
              </td> 			   
	   </tr>

	 <!--Added by Ashwini on 04-Apr-2017 for GDOH-CFR-0004.3-->
	 <tr>
	 <td class='LABEL' width='25%' ><fmt:message key="eAE.VehicleRegNo.label" bundle="${ae_labels}"/></td>
		<td class='fields' width='25%' colspan='2'>
			<input type='text' name="Vehicle_Reg_No1" id="Vehicle_Reg_No1"  maxLength='15' size='20' value="<%=Vehicle_Reg_No1%>" onKeyPress="return SpCharChkForMotorVecRegNo(event);" <%=dis8%>><font  class='label'></font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<fmt:message key="Common.and.label" bundle="${common_labels}"/> 
		</td>
		<td class='fields' width='25%'>
			<input type='text' name="Vehicle_Reg_No2" id="Vehicle_Reg_No2"  maxLength='15' size='20' value="<%=Vehicle_Reg_No2%>" onKeyPress="return SpCharChkForMotorVecRegNo(event);" <%=dis8%>>
		</td>
	</tr>

	   <tr>	
		      <td class='LABEL' width='25%' ><fmt:message key="Common.ProtectiveDeviceUsed.label" bundle="${common_labels}"/></td>
  		      <td class='fields' width='25%' >
				 <select name='protective_device' id='protective_device' <%=dis10%>>
				   <option value=''>---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------
			   <%
			   StringBuffer sqlProtect = new StringBuffer();
			   //sqlProtect.append("SELECT PROTECTIVE_DEVICE_CODE, SHORT_DESC FROM  AE_PROTECTIVE_DEVICE_LANG_VW WHERE language_id='"+locale+"'  and EFF_STATUS ='E' ORDER BY 2");
			   sqlProtect.append("SELECT PROTECTIVE_DEVICE_CODE, SHORT_DESC FROM  AE_PROTECTIVE_DEVICE_LANG_VW ##REPDB## WHERE language_id='"+locale+"'  and EFF_STATUS ='E' and PROTECTIVE_DEVICE_CODE like '%%' ORDER BY 2");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
			   /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
			   sqlFinal = sqlProtect.toString();
			   sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
			   /*End*/
			   pstmt = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
			   rset = pstmt.executeQuery();
			   optSelected="";
			   while(rset!=null && rset.next())
			   {
					if(rset.getString(1).equals(protective_device_code))
				   {
						optSelected="selected";
												
				   }
				   else
					   optSelected="";

				   
				  out.println("<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+" ");
			   }
			   if(pstmt!=null) pstmt.close();
			   if(rset!=null) rset.close();
			   if((sqlProtect != null) && (sqlProtect.length() > 0))
				 {
					sqlProtect.delete(0,sqlProtect.length());
				 }
			   %>
                 </select>
               </td>
			   <td class='LABEL' width='25%' ><fmt:message key="Common.PositionDuringIncident.label" bundle="${common_labels}"/>
               </td>
			   <td class='fields' width='25%' >
				   <select name='affected_site' id='affected_site' <%=dis11%>>
				   <option value=''>---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------
					   <%
						   pstmt = con.prepareStatement(PositionSql);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
					       rset = pstmt.executeQuery();
						   optSelected="";
						   while(rset!=null && rset.next())
						   {
							  if(rset.getString(1).equals(pat_position_code))
							   {
                                    optSelected="selected";
															
							   }
							   else
								   optSelected="";
                              out.println("<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+" ");
						   }
						   if(pstmt!=null) pstmt.close();
						   if(rset!=null) rset.close();
						   if((sqlPosition != null) && (sqlPosition.length() > 0))
							{
								sqlPosition.delete(0,sqlPosition.length());
							}
					   %>
                 </select>
              </td>
	  </tr> 
	 <tr><!-- below line(s) modified by VenkateshS against ML-MMOH-CRF-0354 [IN057191] -->
	          <%if(siteSpecific){%>
			    <td class='COLUMNHEADER' colspan='4' ><fmt:message key="Common.MedicalLegalCase.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.details.label" bundle="${common_labels}"/></td>
			  <%}else{%>
		    <td class='COLUMNHEADER' colspan='4' ><fmt:message key="Common.mlcdetails.label" bundle="${common_labels}"/></td>
			<%}%>
			  <!--end ML-MMOH-CRF-0354 [IN057191 -->
	 </tr>
	 <tr>	<!-- below line(s) modified by VenkateshS against ML-MMOH-CRF-0354 [IN057191] -->
	            <%if(siteSpecific){%>
				<td class='label' width='25%'><fmt:message key="Common.MedicalLegalCase.label" bundle="${common_labels}"/></td>
				<%}else{%>
		      <td class='label' width='25%'><fmt:message key="Common.mlc.label" bundle="${common_labels}"/></td>
			  <%}%>
			  <!--end ML-MMOH-CRF-0354 [IN057191 -->
		     <td class='fields' width='25%' ><input type='checkbox'  name="mlc_case_yn" id="mlc_case_yn"  onclick='chkMlcValue(this)' <%=checked3%>  <%=disMLC%>></td>
               <% if(isMLCAppl){ %>
             <td class='LABEL' width='25%' ><fmt:message key="Common.MlcDeath.label" bundle="${common_labels}"/></td>
					<td class='fields' width='25%'><input type="checkbox" name='mlc_death' id='mlc_death' value='<%=MLC_DEATH_YN %>' onclick='updateSelf(this);' <%=disMLCDeath %> <%=MLC_DEATH_YN.equals("Y")?" Checked ":"" %>></td></td>
             <%}else{ %>
             <td class='LABEL' width='25%' colspan='2'>&nbsp;</td>
             <% }%>
      </tr> 
	  <tr>
	          <td class='label' width='25%'><fmt:message key="Common.PoliceReportNo.label" bundle="${common_labels}"/></td>
  		      <td class='fields' width='25%' >
			  <input type='text'  name='police_rep_no1' id='police_rep_no1'  maxLength='<%=pol_rep_no_mx_size %>' <% if(isMLCAppl){ %> onpaste="maxLengthPaste(this, '100')" <%} %> size='15' value="<%=police_rep_no%>"  <%=dis12%>></td>
			  <td class='label' width='25%'><fmt:message key="Common.PoliceStationDetails.label" bundle="${common_labels}"/></td>
			  <td class='fields' width='25%' ><input type='text' name="police_stat_detail" id="police_stat_detail"  maxLength='<%=pol_stn_det_mx_size %>' <% if(isMLCAppl){ %> onpaste="maxLengthPaste(this, '100')" <%} %> size='25'  value='<%=police_station_dtls%>'  <%=dis13%>></td>
	  </tr>
	  <!-- Added by Ajay Hatwate for GHL-CRF-0650  -->
	  <% if(isMLCAppl){ %>
	   <tr>
		<td class='LABEL' width='25%' ><fmt:message key="Common.OutMlcNoDtls.label" bundle="${common_labels}"/></td>
					<td class='fields' width='25%'><input type='text' name="outside_mlc_dtls" id="outside_mlc_dtls" maxlength='100' value='<%=MLC_NO_OUTSIDE_DTLS %>' onpaste="maxLengthPaste(this, '100')" <%=disOutMLCDet %> disabled></td></td>	
		<td class='LABEL' width='25%' ><fmt:message key="Common.DateOfMlcCapture.label" bundle="${common_labels}"/></td>
					<td class='fields' width='25%'>
					<input type='text'  id='dateofmlccapture' name="date_of_mlc_capture" id="date_of_mlc_capture" onBlur="validateMlcCapture(this)" maxLength='19' size='19' value='<%=MLC_CAPTURE_DATE %>' <%=disDateOfCapt %>><img src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('dateofmlccapture','dd/mm/yyyy' ,'hh:mm:ss',null );" style='cursor:pointer'></img>
					</td></td>				
	</tr>
	<tr>
		<td class='LABEL' width='25%' ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
					<td class='fields' width='25%'>
					<textarea name='mlc_remarks' rows=3 maxlength=12 cols=45 onKeyPress="checkMaxLimit(this, 500)" onpaste="maxLengthPaste(this, '500')" <%=disMLCRemark %>> <%=MLC_REMARKS%> </textarea>
					</td></td>				
	</tr>
	  <%} %>
	  <!-- End of GHL-CRF-0650  -->
     <tr><td colspan=4 class=label height=5></td></tr>
  </table>
</div> 
	</div>
	<div id='Others' style = 'display:none' >
	 <table cellspacing='0' cellpadding='0' width='100%' border=0 align='center'>
            <tr><td class='white'>

		<ul id="tablist" class="tablist" >
			<li class="tablistitem" title="Triage Details">
				<a  class="tabClicked" id='Triage_Details_tab' >
					<span class="tabSpanclicked" onClick='javascript:expandCollapse("Triage_Details_tab")' id="Triage_tabspan"><fmt:message key="Common.TriageDetails.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			<%if(ca_install_yn.equals("Y")){%>
			<li class="tablistitem" title="Assessment">
				<a class="tabA" id='Assessment_tab' >
					<span class="tabAspan" onClick='javascript:expandCollapse("Assessment_tab")' id="assess_tabspan"><fmt:message key="Common.Assessment.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			<%}%> 
		</ul>
    </td></tr>
    </table>
	<table cellspacing='0' cellpadding='0' width='100%' border=0 align='center'>
      <tr><td class='white'>
			<ul id="tablist" class="tablist">
				<li class="tablistitem" title="Condition / Case">
					<a  class="tabA" id="Condition_tab" >
						<span class="tabAspan" onClick='javascript:expandCollapse("Condition_tab")' id="patCond_tabspan"><fmt:message key="eAE.ConditionCase.label" bundle="${ae_labels}"/></span>
					</a>
				</li>
				<li class="tablistitem" title="Others">
					<a class="tabClicked" id="others_tab" >
						<span class="tabSpanclicked" onClick='javascript:expandCollapse("others_tab")' id="others_tabspan"><fmt:message key="Common.others.label" bundle="${common_labels}"/></span>
					</a>
				</li>
			</ul>
       </td></tr>
</table>

 <table border="0" cellpadding="3" cellspacing="0" align='center' colspan=8 width="100%">
	 <tr>
		    <!--Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651 Start-->
			<% if(isOrderCatalogChngAppl && !initialMgmtLblName.equals("")){ %>
				<td class='COLUMNHEADER' colspan='4' ><%=initialMgmtLblName%></td>
			<% }else{ %><!--End-->
				<td class='COLUMNHEADER' colspan='4' ><fmt:message key="eAE.InitialManagement.label" bundle="${ae_labels}"/></td>
			<% } %>
	 </tr>

	<%
		
		if(ca_install_yn.equals("Y")){
	if (order_catalog_code3.equals("")){ FBCProp		  ="disabled";}
    try
	 {	
				   StringBuffer sqlECG1 = new StringBuffer();
				   StringBuffer sqlECG3 = new StringBuffer();
				   StringBuffer sqlECG4 = new StringBuffer();
				   StringBuffer sqlECG5 = new StringBuffer();
				   StringBuffer sqlOrderCatalog6 = new StringBuffer();//Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651
			//	   sqlECG1.append("select count(*)  from or_order ##REPDB## a, or_order_line ##REPDB## b, ae_param ##REPDB## c where a.ORDERING_FACILITY_ID='"+facilityId+"' and a.patient_id='"+patient_id+"' and  a.ENCOUNTER_ID='"+encounter_id+"' and a.order_id=b.order_id and a.ORDERING_FACILITY_ID=c.OPERATING_FACILITY_ID ");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 
				   sqlECG1.append("select count(*)  from or_order ##REPDB## a, or_order_line ##REPDB## b where a.ORDERING_FACILITY_ID='"+facilityId+"' and a.patient_id='"+patient_id+"' and  a.ENCOUNTER_ID='"+encounter_id+"' and a.order_id=b.order_id  ");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 
				   sqlECG3.append(sqlECG1);
				   sqlECG4.append(sqlECG1);
				   sqlECG5.append(sqlECG1);
				   sqlOrderCatalog6.append(sqlECG1);//Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651
				   StringBuffer s1 = new StringBuffer();
				   StringBuffer s3 = new StringBuffer();
				   StringBuffer s4 = new StringBuffer();
				   StringBuffer s5 = new StringBuffer();
				   StringBuffer s6 = new StringBuffer();//Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651
				/* s1.append(" and b.ORDER_CATALOG_CODE=c.ORDER_CATALOG_CODE2");
				   s3.append(" and b.ORDER_CATALOG_CODE=c.ORDER_CATALOG_CODE4");
				   s4.append(" and b.ORDER_CATALOG_CODE=c.ORDER_CATALOG_CODE1");
				   s5.append(" and b.ORDER_CATALOG_CODE=c.ORDER_CATALOG_CODE5");
				   s6.append(" and b.ORDER_CATALOG_CODE=c.ORDER_CATALOG_CODE6");//Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651
					*/
					s1.append(" and b.ORDER_CATALOG_CODE='"+order_catalog_code2+"'");
				   s3.append(" and b.ORDER_CATALOG_CODE='"+order_catalog_code4+"'");
				   s4.append(" and b.ORDER_CATALOG_CODE='"+order_catalog_code1+"'");
				   s5.append(" and b.ORDER_CATALOG_CODE='"+order_catalog_code5+"'");
				   s6.append(" and b.ORDER_CATALOG_CODE='"+order_catalog_code6+"'");//Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651
				   /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
				   sqlFinal = sqlECG1.append(s1).toString();
				   sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
				   /*End*/
				   pstmtEncounter = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				   rsetEncounter = pstmtEncounter.executeQuery();
				   while(rsetEncounter!=null && rsetEncounter.next())
					 {
						      countECG=rsetEncounter.getInt(1);
					 }
				  if(rsetEncounter!=null){ rsetEncounter.close(); rsetEncounter=null; }
				  if(pstmtEncounter!=null){ pstmtEncounter.close(); pstmtEncounter=null; }

					  if (countECG>0)
					  {
						  ECGProp = "checked";
					  }else
					  {
						  ECGProp ="";
					  }
				   /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
				   sqlFinal = sqlECG3.append(s3).toString();
				   sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
				   /*End*/
				   pstmtEncounter = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				   rsetEncounter = pstmtEncounter.executeQuery();
				   while(rsetEncounter!=null && rsetEncounter.next())
					 {
						      countDerss=rsetEncounter.getInt(1);
					 }
				  if(rsetEncounter!=null){ rsetEncounter.close(); rsetEncounter=null; }
				  if(pstmtEncounter!=null){ pstmtEncounter.close(); pstmtEncounter=null; }
					  if (countDerss>0)
					  {
						  DressProp = "checked";
					  }else
					  {
						  DressProp ="";
					  }
					/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
				   sqlFinal = sqlECG4.append(s4).toString();
				   sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
				   /*End*/
				   pstmtEncounter = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				   rsetEncounter = pstmtEncounter.executeQuery();
				   while(rsetEncounter!=null && rsetEncounter.next())
					 {
						      countSpO2=rsetEncounter.getInt(1);
					 }
				  if(rsetEncounter!=null){ rsetEncounter.close(); rsetEncounter=null; }
				  if(pstmtEncounter!=null){ pstmtEncounter.close(); pstmtEncounter=null; }
					  if (countSpO2>0)
					  {
						  SpO2Prop = "checked";
					  }else
					  {
						  SpO2Prop ="";
					  }
				   /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
				   sqlFinal = sqlECG5.append(s5).toString();
				   sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
				   /*End*/
				   pstmtEncounter = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				   rsetEncounter = pstmtEncounter.executeQuery();
				   while(rsetEncounter!=null && rsetEncounter.next())
					 {
						      countCapBlood=rsetEncounter.getInt(1);
					 }
				  if(rsetEncounter!=null){ rsetEncounter.close(); rsetEncounter=null; }
				  if(pstmtEncounter!=null){ pstmtEncounter.close(); pstmtEncounter=null; }
					  if (countCapBlood>0)
					  {
						  capBloodSugProp = "checked";
					  }else
					  {
						  capBloodSugProp ="";
					  }
					/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
				   sqlFinal = sqlOrderCatalog6.append(s6).toString();
				   sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
				   /*End*/

					/*Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651 Start*/
					pstmtEncounter = con.prepareStatement(sqlFinal);
					rsetEncounter = pstmtEncounter.executeQuery();
					while(rsetEncounter!=null && rsetEncounter.next()){
						  countCBD = rsetEncounter.getInt(1);
					}
					if(rsetEncounter!=null){ rsetEncounter.close(); rsetEncounter=null; }
					if(pstmtEncounter!=null){ pstmtEncounter.close(); pstmtEncounter=null; }
					if (countCBD > 0){
						cbdProp = "checked";
					}else{
						cbdProp ="";
					}/*End*/
				  
		}catch(Exception e) {e.printStackTrace();}

  %>
	 <tr><td colspan=4 class=label height=5></td></tr>
    <tr >
		<!--Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651 Start-->
		<% if(isOrderCatalogChngAppl){ %>
				<td class='LABEL'   width='25%' >
					<fmt:message key="eAE.CBD.label" bundle="${ae_labels}"/>
				</td>
				<td class='fields' width='25%' tabindex='<%=++tindex%>'>
					<input type="checkbox" name='cbd' id='cbd' <%=cbdProp%>  disabled>
				</td>
				<td class='LABEL'   width='25%' >
					<fmt:message key="Common.Medication.label" bundle="${ae_labels}"/>
				</td>
				<td class='fields' width='25%' tabindex='<%=++tindex%>'> 
					<input type=text  name='medication' id='medication'  onKeyPress="return CheckForSpecChar(event)" onPaste = "return false;" value="<%=medication%>" size="30" maxlength="30" disabled>
				</td>
		<% }else{ %><!--End-->
			 <td class='LABEL'   width='25%' ><fmt:message key="eAE.CapBloodSugar.label" bundle="${ae_labels}"/></td>
			 <td class='fields' width='25%' ><input type="checkbox" name='cap_bloodSugar' id='cap_bloodSugar'  <%=capBloodSugProp%>  disabled>
			 <td class='LABEL'   width='25%' ><fmt:message key="eAE.SpO2.label" bundle="${ae_labels}"/></td>
			 <td class='fields' width='25%' > 
			  <input type="checkbox" name='spo2' id='spo2'   <%=SpO2Prop%> disabled >
			 </td>
		<% } %>
	</tr>
	 <tr>
	     <td class='LABEL'   width='25%' >		 
		 <fmt:message key="eAE.FBC.label" bundle="${ae_labels}"/></td>
		 <td class='fields' width='25%' > 
		 <input type="checkbox" name='fbc' id='fbc' onClick='chkOrderCat3(this);' <%=FBCProp%>  <%=fbccheck%>  value="<%=fbccheck_val%>" >
		 </td>
		 <td class='LABEL'   width='25%' ><fmt:message key="Common.ecg.label" bundle="${common_labels}"/></td>
		 <td class='fields' width='25%' > 
		 <input type="checkbox" name='ecg' id='ecg' <%=ECGProp%> disabled> 
         </td>
	 </tr>
	 <tr>
		<!--Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651 Start-->
		<% if(isOrderCatalogChngAppl){ %>
			 <td class='label' width='25%'>
				<% if(!dressingLblName.equals("")){ %>
					<%=dressingLblName%>
				<% }else{%>
					<fmt:message key="Common.Compression.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Dressing.label" bundle="${common_labels}"/>
				<% } %>
				</td>
			 <td class='fields' width='25%' tabindex='<%=++tindex%>'> 
				<input type="checkbox" name='dressing' id='dressing'   <%=DressProp%> disabled>
			 </td>
			 <td class='label' width='25%'>
				<fmt:message key="Common.others.label" bundle="${common_labels}"/>
			 </td>
			 <td class='fields' width='25%' tabindex='<%=++tindex%>'> 
				<input type=text  name='initial_mgmt_others' id='initial_mgmt_others'  onKeyPress="return CheckForSpecChar(event)" onPaste = "return false;" value="<%=intialMgmtOthers%>" size="30" maxlength="30" disabled>
			 </td>
		<% }else{ %><!--End-->
			 <td class='label' width='25%'><fmt:message key="Common.Dressing.label" bundle="${common_labels}"/>
			 <td class='fields' width='25%' > 
			  <input type="checkbox" name='dressing' id='dressing'   <%=DressProp%> disabled>
			 </td>
			 <td class='LABEL' colspan=2>&nbsp;</td>
		<% } %>
	 </tr>
    <%}%>
	 <tr>
  		 <td class='LABEL' width='25%'><fmt:message key="eAE.Immobilization.label" bundle="${ae_labels}"/></td>
         <td class='fields' colspan='2' >
				 <select name='immobilization' id='immobilization' onChange='' <%=disImmobil%> >
					<Option value=''>&nbsp;------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----&nbsp;</Option>
					 <%
			          try{
			               StringBuffer sqlImmob = new StringBuffer();
                           sqlImmob.append("select immobilization_code,short_desc from ae_immobilization_lang_vw ##REPDB## where language_id='"+locale+"' and eff_status='E'");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 
						   
						   /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
						   sqlFinal = sqlImmob.toString();
						   sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
						   /*End*/
			               pstmt=con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
						   rset = pstmt.executeQuery();
						   
						   while(rset!=null && rset.next())
						   {
							   if(rset.getString(1).equals(immobilization))
							   {
                                    optSelected="selected";
							   }
							   else
								   optSelected="";

							    out.println( "<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+""); 
						   }
						   if(rset!=null) rset.close();
						   if(pstmt!=null) pstmt.close();
						   if((sqlImmob != null) && (sqlImmob.length() > 0))
							 {
								sqlImmob.delete(0,sqlImmob.length());
							 }
						  }catch(Exception e){e.printStackTrace();}
                 %>
                 </select> 
         </td>
		 <td colspan=2 class='LABEL' >&nbsp;</td>  

  </tr>
 <tr><td colspan=4 class=label height=5></td></tr>
  <tr>
		<td class='COLUMNHEADER' colspan='4' ><fmt:message key="Common.ATTImmunizationDetails.label" bundle="${common_labels}"/></td>
  </tr>
 <tr><td colspan=4 class=label height=5></td></tr>
  <tr>				 
		      <td class='LABEL' ><fmt:message key="Common.ImmunizationStatus.label" bundle="${common_labels}"/></td>
  		      <td class='fields' width='25%' >
				 <select name='immunization_stat' id='immunization_stat' onChange='' <%=dis14%>>
					       <Option value=''>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</Option>
                           <Option value='F'<%=selected%> ><fmt:message key="Common.FullyImmunized.label" bundle="${common_labels}"/></option>
                           <Option value='P'<%=selected1%>  ><fmt:message key="Common.PartiallyImmunized.label" bundle="${common_labels}"/></option>
                           <Option value='U'<%=selected2%>  ><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
				 </select>
              </td>
  		      <td class='LABEL'  width='25%'><fmt:message key="Common.ATTGiven.label" bundle="${common_labels}"/></td>
		      <td class='fields' width='25%' ><input type='checkbox'  name="att_given" id="att_given"   value='' <%=checked4%> <%=dis15%> onblur="agecheck(this,'<%=ca_install_yn%>','<%=patient_age%>','<%=max_age_paediatric%>','<%=min_age_pregnancy%>','<%=sex%>');">
			  </td>
	 </tr>
	 <tr><td colspan=4 class=label height=5></td></tr>
	 </table>
		<% if (patient_age <= max_age_paediatric){
				   pediatric_status = "true";	%>

		<table  border="0" cellpadding="3" cellspacing="0" align='center' colspan=12 width="100%">
	    <tr>
		    <td class='COLUMNHEADER' colspan='8' ><fmt:message key="Common.PediatricDetail.label" bundle="${common_labels}"/></td>
	   </tr>
	 <tr><td colspan=4 class=label height=5></td></tr>
	   <tr>	
         <td class='LABEL'  width="25%" ><fmt:message key="Common.Growth/DevelMilestoneAge.label" bundle="${common_labels}"/></td>
  		 <td class='fields'  width="25%" ><input type='checkbox'  name="growth_age" id="growth_age"  <%=checked5%> onclick='chkhwc(event);' <%=disabled991%> <%=disabled99%>></td>
		 <td class='LABEL' width="25%"><fmt:message key="Common.Immunizationuptodate.label" bundle="${common_labels}"/></td>
		 <td class='fields'  width="25%" >
		 <input type='checkbox' align='left' name="immun_date" id="immun_date"    <%=checked6%> <%=disImm%> >
         </td>
     </tr>
     <tr>
 		 <td class='LABEL' width="25%"><fmt:message key="Common.Menarche.label" bundle="${common_labels}"/></td>
		 <td  class='fields'  width="25%" ><input type='checkbox'  name="menarche" id="menarche"    onclick='checkmenstrual(this);' <%=checked7%> <%=disMenarche%>></td>
		 <td class='LABEL' ><fmt:message key="Common.height.label" bundle="${common_labels}"/></td>
  		 <td class='fields' ><input type='text'  name="height" id="height" <%=disHeight%> id='height'size="5" maxlength='6' value="<%=height%>"onKeyPress='return( allowValidNumber(this,event,3,2)); return(ChkNumberInput(this,event,0)); '
		 onBlur='SPCheckPositiveNumber(this);'>&nbsp;<fmt:message key="Common.cm.label" bundle="${common_labels}"/></td>
         
	   </tr>
       <tr>	
		 <td class='LABEL' ><fmt:message key="Common.weight.label" bundle="${common_labels}"/></td>
  		 <td class='fields' ><input type='text'  name="weight" id="weight" size="5" maxlength='7' value="<%=weight%>" onKeyPress='return( allowValidNumber(this,event,2,3));return(ChkNumberInput(this,event,0))'
		 onBlur='SPCheckPositiveNumber(this);'<%=disWeight%>>&nbsp;<fmt:message key="Common.kg.label" bundle="${common_labels}"/></td>
 		 <td class='LABEL' ><fmt:message key="Common.Circumference.label" bundle="${common_labels}"/></td>
  		 <td class='fields' ><input type='text'  name="circumference" id="circumference" size="5" maxlength='6'value="<%=circumference%>"onKeyPress='return( allowValidNumber(this,event,3,2));return(ChkNumberInput(this,event,0))'onBlur="SPCheckPositiveNumber(this);if(this.readOnly==false)agecheck(this,'<%=ca_install_yn%>','<%=patient_age%>','<%=max_age_paediatric%>','<%=min_age_pregnancy%>','<%=sex%>');"<%=disCir%>>&nbsp;&nbsp;<fmt:message key="Common.cm.label" bundle="${common_labels}"/></td>
	  </tr> 
	 <tr><td colspan=4 class=label height=5></td></tr>
 </table>
 <% } else{
			
			  disabled="";
		 }%>
    <%if (sex.equalsIgnoreCase("F") && (patient_age >= min_age_pregnancy)) {
				 menstrual_status = "true"; %>
				
     <table border="0" cellpadding="3" cellspacing="0" align='center' width='100%'>
	 <tr>
		    <td class='COLUMNHEADER' colspan='4' ><fmt:message key="Common.MenstrualHistory.label" bundle="${common_labels}"/></td>
	 </tr>
	 <tr><td colspan='4' class=label height='5'></td></tr>
     <tr>				 
		    <td class='LABEL' width="25%" ><fmt:message key="Common.PregnantatPresent.label" bundle="${common_labels}"/></td>
            <td class='fields' width='25%' >
	         <input type='checkbox'  name="pregnant_at_present_yn_val" id="pregnant_at_present_yn_val" <%=checked8%> onClick='checkmenstrual(this); checkPregnant(this);' onBlur='if(this.checked ==false)AEScrollIntoView(1);' <%=disabledPre%>></td>
			
			<td class='LABEL' width='25%' size='20' ><fmt:message key="eAE.LMPDate.label" bundle="${ae_labels}"/></td>
            <td class='fields' width='25%' ><input type="text" name="lmp_date" id="lmp_date" disabled id="lmpdate" maxlength="10" size="8"  onblur='makeValidString(this);doDate1(this); checkPregnantDate(this);calculateEDD();calculateNoOfDays();'   value = "<%=DateUtils.convertDate(lmp_date,"DMY","en",localeName)%>" ><img src='../../eCommon/images/CommonCalendar.gif' name="lmp_calendar" onClick="return showCalendar('lmpdate');" disabled    style='cursor:pointer'><img src='../../eCommon/images/mandatory.gif' id='mand2' style="visibility:hidden" align='center'></img></td> 
       </tr>
	   <tr>		
          	<td class='LABEL' width='25%' ><fmt:message key="Common.POA.label" bundle="${common_labels}"/>
   		       &nbsp;
		       <font name="weekVal" id='nmdesig' class='label'></font>&nbsp;<fmt:message key="Common.weeks.label" bundle="${common_labels}"/>&nbsp;
		       <font id='nmdesig1' class='label'></font>&nbsp;<fmt:message key="Common.days.label" bundle="${common_labels}"/></td>
		       <td class='LABEL' align='left' ><fmt:message key="Common.EDD.label" bundle="${common_labels}"/>
   		       &nbsp;
		       <font name="eddVal" id='eddesig' class='label'></font> 
		    </td>
			<td colspan=2 class='LABEL' >&nbsp;</td>  
	</tr> 
   	 <tr><td colspan=4 class=label height=5></td></tr>
 </table>
<script>
/* code for calculating POA -- Weeks and Days as well as EDD values onload */
calculateNoOfDays();
calculateEDD();
</script>
<% } %> 
</div>
<%if(ca_install_yn.equals("Y")){%>
 <div id='Assessment' style= 'display:none'>
		<table cellspacing='0' cellpadding='0' width='100%' border=0 align='center'>
            <tr><td class='white'>

		<ul id="tablist" class="tablist" >
			<li class="tablistitem" title="Triage Details">
				<a class="tabA" id='Triage_tab' >
					<span class="tabAspan" onClick='javascript:expandCollapse("Triage_Details_tab")' id="Triage_tabspan"><fmt:message key="Common.TriageDetails.label" bundle="${common_labels}"/></span>
				</a>
			</li>			
			<li class="tablistitem" title="Assessment">
				<a class="tabClicked" id="assess_tab" >
					<span class="tabSpanclicked" onClick='javascript:expandCollapse("Assessment_tab")' id="assess_tabspan"><fmt:message key="Common.Assessment.label" bundle="${common_labels}"/></span>
				</a>
			</li>		
		</ul>
	</td></tr></table>
</div>
<%}
 }
 %>
<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
<input type='hidden' name='speciality_code' id='speciality_code' value='<%=speciality_code%>'>
<input type='hidden' name='episode_id' id='episode_id' value='<%=episode_id%>'>
<input type='hidden' name='visit_num' id='visit_num' value='<%=visit_num%>'>
<input type='hidden' name='hdddob' id='hdddob' value=<%=date_of_birth%>>
<input type='hidden' name='bed_no' id='bed_no' value='<%=bed_no%>'>
<input type='hidden' name='encounter_id' id='encounter_id' value=<%=encounter_id%>>
<input type='hidden' name='treat_code' id='treat_code' value='<%=treat_code%>'> 
<input type='hidden' name='menstrual_status' id='menstrual_status' value=<%=menstrual_status%>>
<input type='hidden' name='pediatric_status' id='pediatric_status' value=<%=pediatric_status%>>
<input type='hidden' name="mech_injr_subcat_code" id="mech_injr_subcat_code" value="<%=mech_injr_subcat_code%>">
<input type='hidden' name='facility_id' id='facility_id' value=<%=facilityId%>>
<input type='hidden' name='RepDb' id='RepDb' value=<%=RepDb%>><!--Added by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1-->

<input type='hidden' name='clinic_code' id='clinic_code' value='<%=clinic_code%>'>
<input type='hidden' name='priority_zone' id='priority_zone' value=<%=priority%>>
<input type='hidden' name='brought_dead' id='brought_dead' value=<%=brought_dead%>>
<input type='hidden' name='pat_priority' id='pat_priority' value=<%=pat_priority%>>
<input type='hidden' name='CaseofTrauma_val' id='CaseofTrauma_val' value='<%=trauma_yn%>'><!--Modified by Thamizh selvi against ML-MMOH-CRF-0645-->
<input type='hidden' name='disaster_area' id='disaster_area' value='<%=disaster_town_code%>'>
<input type='hidden' name='complaint_code' id='complaint_code' value="<%=complaint_code%>">
<input type='hidden' name='rec_date_time' id='rec_date_time' value='<%=rec_date_time%>'>
<input type='hidden' name='sys_date_time' id='sys_date_time' value='<%=sys_date_time%>'>
<!-- <input type='hidden' name='sys_date_time1' id='sys_date_time1' value='<%=sys_date%>'> -->
<input type='hidden' name='sys_date_time1' id='sys_date_time1' value='<%=sys_date_time1%>'>

<!--Below line added for this CRF ML-MMOH-CRF-0654-->
<input type='hidden' name='mode_of_arrival_code' id='mode_of_arrival_code' value='<%=arrival_code%>'> 
<!--End this CRF ML-MMOH-CRF-0654-->

<input type='hidden' name='gender' id='gender' value='<%=patient_gender%>'>
<input type='hidden' name='patient_age' id='patient_age' value='<%=patient_age%>'>
<input type='hidden' name='query_string' id='query_string' value='<%=query_string%>'>
<input type='hidden' name='params' id='params' value='<%=params%>'>
<input type='hidden' name='sys_date' id='sys_date' value='<%=sys_date%>'>
<input type='hidden' name='enable_rights_yn' id='enable_rights_yn' value='<%=enable_rights_yn%>'>
<input type='hidden' name='sel_triage_yn' id='sel_triage_yn' value='<%=sel_triage_yn%>'>
<input type='hidden' name='sel_cons_yn' id='sel_cons_yn' value='<%=sel_cons_yn%>'>
<input type='hidden' name='practitioner_id' id='practitioner_id' value='<%=practitioner_id%>'>
<input type='hidden' name='order_catalog_code1' id='order_catalog_code1' value='<%=order_catalog_code1%>'>
<input type='hidden' name='order_catalog_code2' id='order_catalog_code2' value='<%=order_catalog_code2%>'>
<input type='hidden' name='order_catalog_code3' id='order_catalog_code3' value='<%=order_catalog_code3%>'>
<input type='hidden' name='order_catalog_code4' id='order_catalog_code4' value='<%=order_catalog_code4%>'>
<input type='hidden' name='order_catalog_code5' id='order_catalog_code5' value='<%=order_catalog_code5%>'>
<input type='hidden' name='order_id' id='order_id' value=''>
<input type='hidden' name='function_id' id='function_id' value='<%=function_id%>'>
<input type='hidden' name='sex' id='sex' value='<%=sex%>'>
<input type='hidden' name='modify_flag' id='modify_flag' value='<%=modify_flag%>'>
<input type='hidden' name='min_age_for_lmp' id='min_age_for_lmp' value='<%=min_age_for_lmp%>'>
<input type='hidden' name='year_value' id='year_value' value='<%=year_value1%>'>
<input type='hidden' name='fbc_yn' id='fbc_yn' value='<%=fbc_yn%>'>
<input type='hidden' name='modifyYN' id='modifyYN' value='<%=modifyYN%>'>

<!--Added by Thamizh selvi on 12th Mar 2018 against ML-MMOH-CRF-0645 Start-->
<input type='hidden' name='isCaseDtlsRadioBtnAppl' id='isCaseDtlsRadioBtnAppl' value='<%=isCaseDtlsRadioBtnAppl%>'>
<input type='hidden' name='OandG_yn' id='OandG_yn' value='<%=OandGYn%>'>
<input type='hidden' name='mech_injr_code' id='mech_injr_code' value='<%=mech_injr_code%>'>
<!--End-->

<!--Below line added for this CRF AAKH-CRF-0010 [IN038535]-->
<input type='hidden' name='open_to_all_pract_yn' id='open_to_all_pract_yn' value='<%=open_to_all_pract_yn%>'>
<input type='hidden' name='open_to_all_prac_for_clinic_yn' id='open_to_all_prac_for_clinic_yn' value='<%=open_to_all_prac_for_clinic_yn%>'>
<input type='hidden' name='five_level_triage_appl_yn' id='five_level_triage_appl_yn' value='<%=five_level_triage_appl_yn%>'>
<%=priority_zone_hidden_fileds%>

<input type='hidden' name='isMechInjLabelChngAppl' id='isMechInjLabelChngAppl' value="<%=isMechInjLabelChngAppl%>"><!--Added by Thamizh selvi on 29th Mar 2018 against ML-MMOH-CRF-0649-->

<!--Added by Ashwini on 18-Jan-2021 for ML-MMOH-CRF-1409-->
<input type='hidden' name='isReconfirmCOTAppl' id='isReconfirmCOTAppl' value='<%=isReconfirmCOTAppl%>'>
<input type='hidden' name='reconf_cot_param' id='reconf_cot_param' value='<%=reconf_cot_param%>'>

<!--Added by k v shanmukh on 6th-Apr-2018 against ML-MMOH-CRF-0656 -->
<input type='hidden' name='isSecTrgBackDateTimeAppl' id='isSecTrgBackDateTimeAppl' value='<%=isSecTrgBackDateTimeAppl%>'>

<!--Added by Ashwini on 10-Apr-2018 for ML-MMOH-CRF-0652-->
<input type='hidden' name='isDiagDtlsSectionAppl' id='isDiagDtlsSectionAppl' value='<%=isChngBtnPositionAppl%>'>

<!--end-->

<input type='hidden' name='isPriorityZoneAppl' id='isPriorityZoneAppl' value='<%=isPriorityZoneAppl%>'>	
<input type='hidden' name='isMLCAppl' id='isMLCAppl' value='<%=isMLCAppl%>'> <!-- Added by Ajay Hatwate for GHL-CRF-0650 -->
<input type='hidden' name='visit_adm_date_time' id='visit_adm_date_time' value='<%=visit_date_time%>'> <!-- Added by Ajay Hatwate for GHL-CRF-0650 -->
<!-- Added by Ajay Hatwate for ML-MMOH-CRF-1653 -->
<input type='hidden' name='caseTypeYn' id='caseTypeYn' value='<%=caseTypeYn%>'> 
<input type='hidden' name='caseTypeMandYn' id='caseTypeMandYn' value='<%=caseTypeMandYn%>'>
<!-- End of ML-MMOH-CRF-1653 -->
<!-- Added by Ajay Hatwate for ML-MMOH-CRf-2103 -->
<input type='hidden' name='tick_mlc_if_oscc_checked_yn' id='tick_mlc_if_oscc_checked_yn' value='<%=tickMlcOnOsccChecked%>'>
<!-- End of ML-MMOH-CRf-2103 -->

<!-- Added by Ajay Hatwate for ML-MMOH-CRF-2069 -->
<input type='hidden' name='isSecondaryTriageQueueNum' id='isSecondaryTriageQueueNum' value='<%=isSecondaryTriageQueueNum %>' >
 <input type='hidden' name='queue_appl_priority_zone' id='queue_appl_priority_zone' value='<%=queue_appl_priority_zone %>' >
 <input type='hidden' name='queue_num_mandatory' id='queue_num_mandatory' value='<%=queue_num_mandatory %>' >
 <input type='hidden' name='queue_secondary_triage' id='queue_secondary_triage' value='<%=queue_secondary_triage %>' >
 <input type='hidden' name='queue_max_num_allowed' id='queue_max_num_allowed' value='<%=queue_max_num_allowed %>' >
 <input type='hidden' name='queue_no' id='queue_no' value='<%=queue_no%>' >
  <input type='hidden' name='latestMensDtlStatus' id='latestMensDtlStatus' value='<%=latestMensDtlStatus %>' ><!-- added by krishna Pranay ML-MMOH-CRF-1759.1 -->
 <input type='hidden' name='invokeMenstrualHistYN' id='invokeMenstrualHistYN' value='<%=invokeMenstrualHistYN %>' ><!-- added by krishna Pranay ML-MMOH-CRF-1759.1 -->
 <input type='hidden' name='rec_view_lmp_details_label' id='rec_view_lmp_details_label' value='<%=rec_view_lmp_details_label%>' ><!-- added by krishna Pranay ML-MMOH-CRF-1759.1 -->
<!-- End of ML-MMOH-CRF-2069 -->


</form> 
<%}catch(Exception e){ e.toString(); e.printStackTrace();}
}catch(Exception e){ e.toString(); e.printStackTrace();}
	finally {
		           ConnectionManager.returnConnection(con,request);  
		    }
%>
<script>
/* code for populating values onload in treatmentarea and mechanical injury sub category list boxes Added on 02/12/2004*/
if(document.forms[0])
setInjury(document.forms[0].mechan_injury);
/*Added by Thamizh selvi against ML-MMOH-CRF-0645 Start*/
if(document.forms[0].isCaseDtlsRadioBtnAppl.value == "true"){
	if(document.forms[0].CaseofTrauma_val.value != "Y" && document.forms[0].oscc_yn.value != "Y" && document.forms[0].surgical_yn.value != "Y" && document.forms[0].OandG_yn.value != "Y"){
		document.forms[0].medical.checked	= true;
		document.forms[0].medical_yn.value	= "Y";
	}
	onLoadCaseDtlsChk();
}/*End*/
 //window.setTimeout('setTreatment(document.forms[0].priority_zone)',200);
//Below line added for this CRF ML-MMOH-CRF-0654 
if("<%=modeofarrival%>"=="true"){
if(document.forms[0])
setTimeout("setTransMode(document.forms[0].transport_mode)",50);// setTrans(document.forms[0].transport_mode);
}
//En dthis CRF ML-MMOH-CRF-0654 
</script>
</body>
<%!
	// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equals(""))) ? "" : inputString );
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
%>


</html>

