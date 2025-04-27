<!DOCTYPE html>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>	

<html> 

<head>
<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat,blopin.*,eOR.*,eBL.*,eOR.Common.*,eCommon.Common.*,eCommon.Common.*,eOP.*,org.json.simple.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%
request.setCharacterEncoding("UTF-8"); 
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");      
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String bean_id = "refusalOrdersBean" ;
String bean_name = "eOR.RefusalOrdersBean";
boolean iSPractVisitLoad=false;//added by munisekhar for MMS-QH-CRF-0167 [IN:044923]
Boolean isImproveReferralProcessAppl = false; 
RefusalOrdersBean Orderables = (RefusalOrdersBean)getBeanObject( bean_id,bean_name,request) ;

Orderables.clearObject();
Properties p=(java.util.Properties) session.getValue("jdbc"); //Added for this CRF GDOH-CRF-0129
//Start - Added for GDOH-CRF-149
	session.removeAttribute("str_clinic_code");
	session.removeAttribute("classTypChangeAuthYnPatId");
//End - Added for GDOH-CRF-149
%>


<STYLE TYPE="text/CSS">


/* This style is used for locking the table's heading  */

div#order_ctlg_tbl {
width: 1020px;
height: 85px;
overflow: auto;
position: absolute;
}

thead th, thead th.locked	{
position:relative;
}

thead th {
top: expression(document.getElementById("order_ctlg_tbl").scrollTop-2); 
z-index: 20;
}
div.label{
	COLOR:#444444;  
	background-color:#FFFFFF;
	FONT-SIZE: 8pt;
	TEXT-ALIGN: LEFT;   
	PADDING-LEFT:5px;
	PADDING-RIGHT:5px
}

</STYLE>

<meta http-equiv="Expires" content="0">
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script language='javascript' src='../../eCommon/js/dchk.js'></script>
<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
<Script src="../../eMP/js/PatientRegistration.js" language="JavaScript"></Script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'> </script> 
<Script src="../../eOP/js/VisitRegistrationQuery.js" language="JavaScript"></Script> 
<Script src="../../eOP/js/VisitRegistration.js" language="JavaScript"></Script>	 
<Script src="../../eOP/js/VisitRegistration1.js" language="JavaScript"></Script>	 
<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src='../../eOP/js/OPPractitionerComponent.js' language='javascript'></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'> </script> 
<script language="javascript" src="../../eOP/js/Checkblockscheduleforpract.js"></script><!--  Added for JD-CRF-0183 [IN:041353] By Dharma on 27th Nov 2013-->
<script src='../../eBL/js/AddModifyPatFinDetails.js' language='Javascript'></script>
<script language='javascript' src='../../eCommon/js/jquery.js'></script> <!-- added by mujafar for AMRI-CRF-0357 -->

<!--Added by Ashwini on 23-Sep-2022 for TH-KW-CRF-0020.1-->
<script src='../../eXH/js/ExternalApplication.js' language='Javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
$(document).ready(function(){ 	
 var isPractoApptYn = document.getElementById('isPractoApptYn');
 if(isPractoApptYn) {
	 isPractoApptYn=isPractoApptYn.value;
 }
 if(isPractoApptYn=="Y"){
	 parent.parent.frames[0].document.forms[0].apply.click();
 }
});

</script>

<%
StringBuffer servsql=new StringBuffer();
String short_desc="";
String service_code="";
String room_type="";
String rm_no="";
String to_ser_code="";
String l_encounter_id="";
String open_to_all_pract_yn="";
String register_visit_walkin="";
String register_visit_referral="";
String org_type_data="";
String Pat_Details="";
String dob="";
String seclevel="";
String to_speciality_code = "";
int reccnt=0;
String protectionind="";
double outst_amt=0;
String outst_amt1 = "0";
String gen_file_yn="";
String visit_charge_stage="";
String order_id="";
String sys_date="";
String resource_class=request.getParameter("resource_class")==null?"":request.getParameter("resource_class");
String entitlement_by_cat_yn=request.getParameter("entitlement_by_cat_yn")==null?"":request.getParameter("entitlement_by_cat_yn");
String isPractoApptYn=request.getParameter("isPractoApptYn")==null?"":request.getParameter("isPractoApptYn");
String virtualConsultEnable=request.getParameter("virtualConsultEnable")==null?"":request.getParameter("virtualConsultEnable"); // Added by Lakshmanan ML-MMOH-CRF-1930
System.err.println("isPractoApptYn 107 VisitRegistrationResult.jsp==>"+isPractoApptYn);

//Below line added for this CRF GDOH-CRF-0129
String assigncare_location_code="",assigncare_location_desc="",assigncareloctype="";
Boolean isReferral=false;
Boolean isCurrentEncounter=false;
ArrayList arrIPList=null;
ArrayList arrOPList=null; 
String referralforcurrentencounter="";
//End GDOH-CRF-0129

String res_pract_id="";
//String entitlement_by_cat_yn="";
String regfromquery="Y";
String display_button3="";
String display_button1="";
String HcExpired="";
String episode_close_days_fu="";
String  vis_det_temp_yn="";
String upt_contact_dtls_oa_yn=request.getParameter("upt_contact_dtls_oa_yn")==null?"":request.getParameter("upt_contact_dtls_oa_yn");
String reason_code=request.getParameter("contact_reason_code")==null?"":request.getParameter("contact_reason_code");
String reason=request.getParameter("reason")==null?"":request.getParameter("reason");
String facilityid  = checkForNull((String) session.getValue("facility_id"));
String userid      = checkForNull((String) session.getValue("login_user"));
String emer_regn_allow_yn=request.getParameter("emer_regn_allow_yn")==null?"":request.getParameter("emer_regn_allow_yn");
String invitation_no=request.getParameter("invitation_no")==null?"":request.getParameter("invitation_no");
String bl_interface_yn=request.getParameter("bl_interface_yn")==null?"":request.getParameter("bl_interface_yn");

String inv_splty_code=request.getParameter("inv_splty_code")==null?"":request.getParameter("inv_splty_code");
String q_appt_ref_no=request.getParameter("q_appt_ref_no")==null?"":request.getParameter("q_appt_ref_no");
String q_practitioner_name=request.getParameter("q_practitioner_name")==null?"":request.getParameter("q_practitioner_name");
String oa_install_yn=request.getParameter("oa_install_yn")==null?"":request.getParameter("oa_install_yn");
String or_install_yn=request.getParameter("or_install_yn")==null?"":request.getParameter("or_install_yn");
String referal_id=request.getParameter("referral_id")==null?"":request.getParameter("referral_id");
String query_string=request.getParameter("query_String")==null?"":request.getParameter("query_String");
String Rpractitioner_name=request.getParameter("Rpractitioner_name")==null?"":request.getParameter("Rpractitioner_name");

String from_reg=request.getParameter("from_reg")==null?"":request.getParameter("from_reg");
String dischargedatetime=request.getParameter("dischargedatetime")==null?"":request.getParameter("dischargedatetime");
String bed_num=request.getParameter("bed_num")==null?"":request.getParameter("bed_num");

String nat_id_prompt=request.getParameter("nat_id_prompt")==null?"":request.getParameter("nat_id_prompt");

String register_pat_yn=request.getParameter("register_pat_yn")==null?"":request.getParameter("register_pat_yn");
String reg_vis_param=request.getParameter("reg_vis_param")==null?"":request.getParameter("reg_vis_param");
String q_visit_adm_type_ind=request.getParameter("q_visit_adm_type_ind")==null?"":request.getParameter("q_visit_adm_type_ind");
String episode_close_days_wo_fu=request.getParameter("episode_close_days_wo_fu")==null?"":request.getParameter("episode_close_days_wo_fu");
String ChgToVisitorGrp=request.getParameter("ChgToVisitorGrp")==null?"":request.getParameter("ChgToVisitorGrp");
String patientFlag=request.getParameter("patientFlag")==null?"":request.getParameter("patientFlag");
String pres_class=request.getParameter("pres_class")==null?"":request.getParameter("pres_class");
String q_clinic_desc=request.getParameter("q_clinic_desc")==null?"":request.getParameter("q_clinic_desc");
String q_clinic_code=request.getParameter("q_clinic_code")==null?"":request.getParameter("q_clinic_code");


String q_visit_adm_type_desc=request.getParameter("q_visit_adm_type_desc")==null?"":request.getParameter("q_visit_adm_type_desc");
String q_visit_adm_type=request.getParameter("q_visit_adm_type")==null?"":request.getParameter("q_visit_adm_type");
String q_practitioner_id=request.getParameter("q_practitioner_id")==null?"":request.getParameter("q_practitioner_id");
String q_practitioner_id1=request.getParameter("q_practitioner_id1")==null?"":request.getParameter("q_practitioner_id1");


String CheckinIdent=request.getParameter("CheckinIdent")==null?"":request.getParameter("CheckinIdent");
String functionId=request.getParameter("functionId")==null?"":request.getParameter("functionId");
String menu_function_id=request.getParameter("menu_function_id")==null?"":request.getParameter("menu_function_id");
String res_name=request.getParameter("res_name")==null?"":request.getParameter("res_name");
String res_id=request.getParameter("res_id")==null?"":request.getParameter("res_id");
String order_catalog_code=request.getParameter("order_catalog_code")==null?"":request.getParameter("order_catalog_code");
String order_catalog_desc=request.getParameter("order_catalog_desc")==null?"":request.getParameter("order_catalog_desc");
String episodeReqd=request.getParameter("episodeReqd")==null?"":request.getParameter("episodeReqd");
//Added Incident [52854]
String episode=request.getParameter("episode")==null?"":request.getParameter("episode");
if(episode.equals(""))episode="N";
//End //Added Incident [52854]	
String record=request.getParameter("record")==null?"":request.getParameter("record");
String patient=request.getParameter("patient")==null?"":request.getParameter("patient");
String locale = checkForNull((String)session.getAttribute("LOCALE"));
String bl_install_yn = checkForNull((String)session.getValue("bl_operational"));

String wait_flag=request.getParameter("wait_list_inv")==null?"":request.getParameter("wait_list_inv");
String build_episode_rule=request.getParameter("build_episode_rule")==null?"":request.getParameter("build_episode_rule");
String oper_stn_id=request.getParameter("oper_stn_id")==null?"":request.getParameter("oper_stn_id");
String call_from=request.getParameter("call_from")==null?"":request.getParameter("call_from");

StringBuffer concat_address_hidden=new StringBuffer();
episodeReqd=build_episode_rule;
String curepisodeid="";
String q_appt_time = request.getParameter("q_appt_time")==null?"":request.getParameter("q_appt_time");
String locn_ind = request.getParameter("locn_ind")==null?"":request.getParameter("locn_ind");
String visit_for_inpat_yn = request.getParameter("visit_for_inpat_yn")==null?"N":request.getParameter("visit_for_inpat_yn");  

//String practitioner = request.getParameter("pract_id")==null?"":request.getParameter("pract_id");

String accept_dis_inv_no=(request.getParameter("accept_dis_inv_no") == null)?"":request.getParameter("accept_dis_inv_no");

/*Below line Added for this CRF  Bru-HIMS-CRF-165.1 [IN:035659]*/
String appt_order=(request.getParameter("appt_order") == null)?"":request.getParameter("appt_order");
String rec_no=(request.getParameter("rec_no") == null)?"":request.getParameter("rec_no");//Added for this incident [52415]
String blflag_op_yn=(request.getParameter("blflag_op_yn") == null)?"":request.getParameter("blflag_op_yn");//Added for this incident [52415]
String from_head=(request.getParameter("from_head") == null)?"":request.getParameter("from_head");//Added for this incident [52619]
String waitlist_status=(request.getParameter("waitlist_status") == null)?"":request.getParameter("waitlist_status");//Added for this incident [52619]

String multi_speciality_yn=(request.getParameter("multi_speciality_yn") == null)?"N":request.getParameter("multi_speciality_yn");//Added for the CRF - Bru-HIMS-CRF-0198
String gif_style="visibility:hidden";
String disable_pract="";
if(multi_speciality_yn.equals("Y")){
	disable_pract="disabled";
}

int serviceCount = 0;

Connection con = null;
PreparedStatement pstmt=null;
String id_type="";
String pref_fac="";
ResultSet rs=null;
String OP_APPL_YN="N";
String IP_APPL_YN="N";
String DC_APPL_YN="N";
String EM_APPL_YN="N";
String assign_q_num_by = "";

String vst_regn_date = "";
String vst_regn_date_new = "";//for incident no 29368 by Srinivasarao Yeluri on 22/02/12
String override_pract_for_appt_yn="";
String override_vtype_on_epsd_yn="";
String visit_backdate_days = "";
int visit_backdate_days_val=0;
String visit_back_yn = "";
String allowed_date = "";
String loctype = "";
String loctypedesc  = "";  
String ref_dtls  = "";  
String dis_value =""; 
String continueYN = "Y";
String disableVisitTemplate = "";
String auth_win_reqd_yn = "N";
String speciality_code = "";
String pat_ser_grp_code = "";
String visit_type_derv_rule = "S";
String action_on_pract_schedule	= "N";//Added for JD-CRF-0183 [IN:041353] By Dharma on 27th Nov 2013
int pr_ent_cnt = 0;
String others_id = ""; //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114

int order_count_select=0;//this CRFBru-HIMS-CRF-165.1 [IN:035659]
int sec_res_count = 0;//Added for the CRF - Bru-HIMS-CRF-0198

boolean isAlternateAddressAppl = false;//Added by Thamizh selvi on 25th Jan 2018 against ML-MMOH-CRF-0601
boolean isUHID_valid_appl =false; // Added by mujafar for AMRI-CRF-0357
Boolean isNationalIdValidationAppl = false; //Added by Ashwini on 06-Mar-2019 for MO-CRF-20148
boolean isNatIdOrAltIdMandVisaType = false; //Added by Dharma on 25th Mar 2019 NMC-JD-CRF-0018 [IN:069750] 
boolean isNatIdAltIdMandVisaType = false;  	//Maheshwaran added  for AAKH-CRF-0145 as on 22-04-2022
boolean isRoomMandatoryRegVisit = false; //Added by Mujafar on 27th Jun 2019 NMC-JD-CRF-0025
boolean isAllowRegForSameService = false; // Added by mujafar for ML-MMOH-CRF-1437
boolean isVirtualConsultationVisit=false; // added by Lakshmanan for ML-MMOH-CRF-1930 US008
//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
isImproveReferralProcessAppl = false;

//Added by Ashwini on 23-Sep-2022 for TH-KW-CRF-0020.1
Boolean isQMSInOPVisitRegAppl = false;
String patient_name = "";

//Added by Santhosh for MMS-DM-CRF-0209.4-US005
boolean isClinicCategory = false;
String firstVisitList=""; 
String followUpVisitList="";
String isReferalId ="";
String referral_req_yn="";

String gen_remark ="";



try{
	/******************************added for package billing to clear the bean object******************************/
		String bean_id1		= "PkgSubsBean";
		String bean_name1	= "eBL.PkgSubsBean";
		PkgSubsBean bean			= (PkgSubsBean)getBeanObject( bean_id1, bean_name1, request ) ;
		bean.clearBean();
/******************************end******************************/

	if(!query_string.equals(""))
		{	
			session.putValue("queryString",query_string) ;
		}

	con = ConnectionManager.getConnection(request);
	//Added for ML-MMOH-CRF-1802
		if(!patient.equals("")){
			try{
    			pstmt   = con.prepareStatement("select patient_remarks from mp_patient_remarks where patient_id=?");
			pstmt.setString(1, patient);
    			rs    = pstmt.executeQuery();
			if(rs!=null && rs.next())
				{
    gen_remark = checkForNull(rs.getString("patient_remarks"));
				}
    if(pstmt != null) pstmt.close();
    if(rs != null) rs.close();
			}
		catch(Exception e)
			{
			e.printStackTrace();
			}
		}
	isClinicCategory = CommonBean.isSiteSpecific(con, "OP","CLINIC_CATEGORY");//Added by Santhosh for MMS-DM-CRF-0209.4-US005
	boolean isMohbr = CommonBean.isSiteSpecific(con, "OP","DFLT_APPT_VISIT_TYPE");	//Added for the CRF - PMG2013-BRU-CRF-0002 [IN045555]
	boolean isOrderCtlgAmtCalc = CommonBean.isSiteSpecific(con, "OP","ORDER_CTLG_AMT_CALC");
	boolean downtimePatient =CommonBean.isDownTimePatient(con,patient);//Rameswar
	isRoomMandatoryRegVisit =CommonBean.isSiteSpecific(con, "OP", "ROOM_FOR_CLINIC_PROCUNIT_APPL");//Added by Mujafar on 27th Jun 2019 NMC-JD-CRF-0025
	isAlternateAddressAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","ALTERNATE_ADDRESS_APPLICABLE");//Added by Thamizh selvi on 25th Jan 2018 against ML-MMOH-CRF-0601
	 isUHID_valid_appl = CommonBean.isSiteSpecific(con, "MP","UHID_VALID_DAYS_APPL"); // Added by mujafar for AMRI-CRF-0357
	 isNationalIdValidationAppl = CommonBean.isSiteSpecific(con, "MP", "NATIONAL_ID_VALIDATION"); //Added by Ashwini on 06-Mar-2019 for MO-CRF-20148
	 isNatIdOrAltIdMandVisaType = CommonBean.isSiteSpecific(con, "MP", "MP_RES_VAL_VISA_TYPE");//Added by Dharma on 25th Mar 2019 NMC-JD-CRF-0018 [IN:069750] 
	isNatIdAltIdMandVisaType = CommonBean.isSiteSpecific(con, "MP", "MP_VAL_VISA_TYPE"); 	//Maheshwaran added  for AAKH-CRF-0145 as on 22-04-2022
	boolean isInvokeChngPatDtls = CommonBean.isSiteSpecific(con, "MP", "MP_RESIDENCY_NAT_ALT1_ID_MAND"); //Added by Dharma on 24th Apr 2019 against MMS-DM-CRF-0152.1 [IN:070226]

	boolean isCountryRegionValAppl = CommonBean.isSiteSpecific(con, "MP", "CHECK_COUNTRY_REGION");//Added by Ashwini on 02-Feb-2021 for AAKH-CRF-0128.1
	
	isAllowRegForSameService = eCommon.Common.CommonBean.isSiteSpecific(con, "OP", "ALLOW_VISIT_SAME_SER");//Added by Mujafar  for GHL-CRF-0527
	//STARTS -  added for GDOH-CRF-149	
	boolean defFinDtls=false;
	boolean isChkMPParamMandFlds = CommonBean.isSiteSpecific(con, "MP", "MP_CHK_MAND_FLDS"); /*Added by Dharma on 12th May 2020 against KDAH-CRF-0522.1*/

	//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
	isImproveReferralProcessAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"OP","IMPROVE_REFERRAL_PROCESS"); 
	
	//Added by Ashwini on 23-Sep-2022 for TH-KW-CRF-0020.1
	isQMSInOPVisitRegAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"OP","QMS_IN_OP_VISIT_REG");
	
	isVirtualConsultationVisit=CommonBean.isSiteSpecific(con,"OP","VIRTUAL_CONSULTATION"); // added by Lakshmanan for ML-MMOH-CRF-1930 US008
	try
	{
		
		defFinDtls = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","DISP_FIN_CLASS_DTLS_BLANK");

	}catch(Exception e)
	{
		e.printStackTrace();
		System.err.println("Exception in site specific "+e);
	}
	//ENDS -  added for GDOH-CRF-149
	Boolean isForm60Available	= CommonBean.isSiteSpecific(con, "MP","REG_PAT_ALT_ID3_PAN_CARD");//Added by Dharma on 3rd Feb 2016 for KDAH-CRF-0331 [IN058799]
	
	Boolean validationForPanCardAvail	= CommonBean.isSiteSpecific(con, "MP","GENERATE_FORM_60"); //Added by Sangeetha on  10/apr/17 for KDAH-CRF-0347

	/*Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114*/
	HashMap hashdata	= eCommon.Common.CommonBean.getSiteSpecificDetails(con, "OA","REMARKS_FOR_OTHERS");
	others_id	= (String)hashdata.get("value1");
	if(others_id == null) others_id = "";
	/*End ML-MMOH-CRF-1114*/
	
  //Below line added for this GDOH-CRF-0129
  isReferral=CommonBean.isSiteSpecific(con, "IP","REGISTER_REFERRAL");  
	 if(isReferral){
		arrIPList=(ArrayList)ReferralCurrentEncounterDetails.getIPCurrentEncounterDetails(con,patient,facilityid,p);
			 for(int ip=0; ip<arrIPList.size(); ip++){
					ReferralCurrentEncounterDetailsBean ipEncounterDetails=(ReferralCurrentEncounterDetailsBean)arrIPList.get(ip); 
					assigncare_location_code=ipEncounterDetails.getAssigncareloccode();
					assigncare_location_desc=ipEncounterDetails.getAssigncarelocdesc();
					assigncareloctype=ipEncounterDetails.getAssigncareloctype();
					referralforcurrentencounter="disabled";
					isCurrentEncounter=true;
					
			 }
	 if(arrIPList.size()==0){
		arrOPList=(ArrayList)ReferralCurrentEncounterDetails.getOPCurrentEncounterDetails(con,patient,facilityid,p);
			 for(int op=0; op<arrOPList.size(); op++){
					ReferralCurrentEncounterDetailsBean opEncounterDetails=(ReferralCurrentEncounterDetailsBean)arrOPList.get(op); 
					assigncare_location_code=opEncounterDetails.getAssigncareloccode();
					assigncare_location_desc=opEncounterDetails.getAssigncarelocdesc();
					assigncareloctype=opEncounterDetails.getAssigncareloctype();
					referralforcurrentencounter="disabled";
					isCurrentEncounter=true;
			}
		  }
	 }
 //End GDOH-CRF-0129	
	

	/*Added by Dharma on May 25th 2016 against KAUH-SCF-0261 [IN:059835] Start*/
	  String reg_date_time =CommonBean.getRegistrationDateTime(con,patient);//Dharma May 24,2016
	  if(!reg_date_time.equals("")){
		  reg_date_time = DateUtils.convertDate(reg_date_time,"DMYHMS","en",locale);
	  }
	 /*Added by Dharma on May 25th 2016 against KAUH-SCF-0261 [IN:059835] End*/


	if(!q_appt_ref_no.equals("") || !invitation_no.equals("")) {		
		//continueYN = check_patient_id(out,patient,facilityid,con,visit_for_inpat_yn,call_from,locale);
		/* Modified By Dharma for Non-Citizen Validation on 6th Jan 2014 */
			//Maheshwaran added -isNatIdAltIdMandVisaType for AAKH-CRF-0145 as on 22-04-2022
		continueYN = check_patient_id(out,patient,facilityid,con,visit_for_inpat_yn,call_from,locale,q_appt_ref_no,referal_id,isNationalIdValidationAppl,isUHID_valid_appl,bl_install_yn,isNatIdOrAltIdMandVisaType,isInvokeChngPatDtls,isChkMPParamMandFlds,isCountryRegionValAppl,isNatIdAltIdMandVisaType); //Modified by Ashwini on 06-Mar-2019 for MO-CRF-20148
	}
	
	if(continueYN.equals("Y")) {

	if((!q_appt_ref_no.equals("")) || (!referal_id.equals(""))) {
		concat_address_hidden = getContactDetails("",patient,referal_id,q_appt_ref_no,con,facilityid,locale);
	}


	 /*Below line Added for this CRF Bru-HIMS-CRF-165.1 [IN:035659] */	
	String select_order="SELECT count(*) order_record_count FROM  or_order_catalog a, OR_APPT_REF_CATALOG b where APPT_REF_NO='"+q_appt_ref_no+"' and FACILITY_ID ='"+facilityid+"' and a.ORDER_CATALOG_CODE =b.ORDER_CATALOG_CODE";		
	pstmt=con.prepareStatement(select_order);
	rs = pstmt.executeQuery();
	if(rs.next()) {	  	
		order_count_select=rs.getInt("order_record_count");	
	}
	if(rs != null) rs.close();		
	if(pstmt!=null)pstmt.close();	
  /*End this CRF Bru-HIMS-CRF-165.1 [IN:035659] */
	
	
	//pstmt=con.prepareStatement("select ASSIGN_QUEUE_NUM_BY,use_template_in_vis_regn_yn, to_char(sysdate,'dd/mm/yyyy hh24:mi:ss') sys,to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_new, OVERRIDE_PRACT_FOR_APPT_YN, OVERRIDE_VTYPE_ON_EPSD_YN,VISIT_BACKDATE_DAYS, to_char((sysdate - NVL(VISIT_BACKDATE_DAYS,0)),'dd/mm/yyyy hh24:mi:ss') sys1,VISIT_TYPE_DERV_RULE from op_param where operating_facility_id='"+facilityid+"'");//modified by Srinivasrao Yeluri on 22/02/2012 for Incident no 29368
pstmt=con.prepareStatement("select action_on_pract_schedule,ASSIGN_QUEUE_NUM_BY,use_template_in_vis_regn_yn, to_char(sysdate,'dd/mm/yyyy hh24:mi:ss') sys,to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_new, OVERRIDE_PRACT_FOR_APPT_YN, OVERRIDE_VTYPE_ON_EPSD_YN,VISIT_BACKDATE_DAYS, to_char((sysdate - NVL(VISIT_BACKDATE_DAYS,0)),'dd/mm/yyyy hh24:mi:ss') sys1,VISIT_TYPE_DERV_RULE, REFERRAL_REQ_YN from op_param where operating_facility_id='"+facilityid+"'");//modified for JD-CRF-0183 [IN:041353] By Dharma on 27th Nov 2013
	rs = pstmt.executeQuery();

	if(rs.next()) {	  		
		action_on_pract_schedule	= rs.getString("action_on_pract_schedule");//Added for JD-CRF-0183 [IN:041353] By Dharma on 27th Nov 2013
		assign_q_num_by = checkForNull(rs.getString("ASSIGN_QUEUE_NUM_BY"));
		vst_regn_date = checkForNull(rs.getString("sys"));
		vst_regn_date_new =  checkForNull(rs.getString("sys_new")); // for incident 29368
		override_pract_for_appt_yn = checkForNull(rs.getString("OVERRIDE_PRACT_FOR_APPT_YN"));		
		override_vtype_on_epsd_yn = rs.getString("OVERRIDE_VTYPE_ON_EPSD_YN") == null? "N" : rs.getString("OVERRIDE_VTYPE_ON_EPSD_YN");	
		visit_backdate_days = rs.getString("VISIT_BACKDATE_DAYS") == null? "" : rs.getString("VISIT_BACKDATE_DAYS");
		allowed_date = rs.getString("sys1") == null? "" : rs.getString("sys1");
		vis_det_temp_yn = rs.getString( "use_template_in_vis_regn_yn" ) == null? "N" : rs.getString("use_template_in_vis_regn_yn");
		visit_type_derv_rule = rs.getString( "VISIT_TYPE_DERV_RULE" ) == null? "S" : rs.getString("VISIT_TYPE_DERV_RULE");
		referral_req_yn = rs.getString( "REFERRAL_REQ_YN" ) == null? "N" : rs.getString("REFERRAL_REQ_YN");
		
	}	

	
	if(rs != null) rs.close();		
	if(pstmt!=null)pstmt.close();

	if(!q_appt_ref_no.equals("") || !invitation_no.equals("") || !vis_det_temp_yn.equals("Y")) {
		disableVisitTemplate = "disabled";
	} else {
		disableVisitTemplate = "";
	}

    if(!( visit_backdate_days ==null || visit_backdate_days.equals("") ))
		visit_backdate_days_val =Integer.parseInt(visit_backdate_days);

    if (visit_backdate_days_val > 0) {
		visit_back_yn = "Y";
	}
	vst_regn_date = DateUtils.convertDate(vst_regn_date,"DMYHMS","en",locale);//format changed by Srinivasrao Yeluri for incident  no 29368

	vst_regn_date_new = DateUtils.convertDate(vst_regn_date_new,"DMYHM","en",locale);
	
	if(q_appt_ref_no.equals("") && referal_id.equals("")) {

		pstmt = con.prepareStatement("SELECT addr1_type, addr1_line1, addr1_line2, addr1_line3, addr1_line4,postal1_code, MP_GET_DESC.MP_POSTAL_CODE(postal1_code,'"+locale+"','2') postaldesc1,country1_code,(select long_desc from mp_country_lang_vw where language_id='"+locale+"' and country_code=a.country1_code) country1_desc,contact1_name,invalid1_yn,(select long_desc from mp_res_area_lang_vw  where language_id='"+locale+"' and res_area_code=b.res_area_code) res_area,b.res_area_code ,(select long_desc from mp_res_town_lang_vw  where language_id='"+locale+"' and res_town_code= b.res_town_code) res_town,b.res_town_code ,(select short_desc from mp_region_lang_vw where language_id='"+locale+"' and region_code=b.region_code) region,b.region_code, addr2_type,addr2_line1,addr2_line2, addr2_line3,addr2_line4,postal2_code,MP_GET_DESC.MP_POSTAL_CODE(postal2_code,'"+locale+"','2')postal2_desc,country2_code,(select short_name from mp_country_lang_vw where language_id='"+locale+"' and country_code=a.country2_code) country2_desc,contact2_name,invalid2_yn, (select short_desc from mp_res_area_lang_vw where language_id='"+locale+"' and  res_area_code=a.res_area2_code ) res_area2,a.res_area2_code, (select short_desc from mp_res_town_lang_vw  where language_id='"+locale+"' and res_town_code=res_town2_code) res_town2, res_town2_code,(select short_desc from mp_region_lang_vw  where language_id='"+locale+"' and region_code=region2_code) region2_desc,region2_code, CONTACT1_NO, CONTACT2_NO, EMAIL_ID, nvl(pref_facility_id,'') pref_facility_id, nvl(EMEG_REGN_YN,'N') emer_regn_yn, b.pat_ser_grp_code pat_ser_grp_code , c.id_type, (select count(*) from pr_encounter where facility_id='"+facilityid+"' and patient_id='"+patient+"') pr_ent_cnt,0 sec_res_count, alt_addr_type, alt_addr_line1, alt_addr_line2, alt_addr_line3, alt_addr_line4, alt_postal_code, mp_get_desc.mp_postal_code (alt_postal_code, '"+locale+"', '2' ) alt_postal_desc, alt_country_code, (select short_name from mp_country_lang_vw where language_id = '"+locale+"' and country_code = a.alt_country_code) alt_country_desc, alt_contact_name, alt_invalid_yn, (select short_desc from mp_res_area_lang_vw where language_id = '"+locale+"' and res_area_code = a.alt_area_code) alt_area_desc, a.alt_area_code, (select short_desc from mp_res_town_lang_vw where language_id = '"+locale+"' and res_town_code = a.alt_town_code) alt_town_desc, alt_town_code, (select short_desc from mp_region_lang_vw where language_id = '"+locale+"' and region_code = alt_region_code) alt_region_desc, alt_region_code, b.patient_name FROM mp_pat_addresses a , MP_PATIENT b, mp_pat_ser_grp c WHERE b.PATIENT_ID = a.PATIENT_ID and  b.patient_id='"+patient+"' and c.pat_ser_grp_code = b.pat_ser_grp_code "); //Modified by Thamizh selvi on 25th Jan 2018 against ML-MMOH-CRF-0601

	} else {

		pstmt = con.prepareStatement("select nvl(pref_facility_id,'') pref_facility_id, nvl(EMEG_REGN_YN,'N') emer_regn_yn, a.pat_ser_grp_code pat_ser_grp_code, b.id_type, (select count(*) from pr_encounter where facility_id='"+facilityid+"' and patient_id='"+patient+"') pr_ent_cnt,(select count(*) from oa_resource_for_appt where facility_id='"+facilityid+"' and APPT_REF_NO='"+q_appt_ref_no+"') sec_res_count, a.patient_name from mp_patient a, mp_pat_ser_grp b where patient_id = '"+patient+"' and a.pat_ser_grp_code = b.pat_ser_grp_code");
	}

    rs = pstmt.executeQuery();
    if(rs!=null && rs.next())
	{		  
		id_type = (rs.getString("id_type") == null)?"":rs.getString("id_type");
		pref_fac=rs.getString("pref_facility_id")==null?"":rs.getString("pref_facility_id"); 
		pat_ser_grp_code = rs.getString("pat_ser_grp_code")==null?"":rs.getString("pat_ser_grp_code");
		pr_ent_cnt = rs.getInt("pr_ent_cnt");
		//Added for the CRF - Bru-HIMS-CRF-0198 - start
		sec_res_count = rs.getInt("sec_res_count");
		if((!q_appt_ref_no.equals("")) && sec_res_count > 0 && multi_speciality_yn.equals("Y")){
			gif_style="visibility:visible";
		}
		//Added for the CRF - Bru-HIMS-CRF-0198 - end
		
		//Added by Ashwini on 23-Sep-2022 for TH-KW-CRF-0020.1
		patient_name = (rs.getString("patient_name") == null)?"":rs.getString("patient_name");
		
		if(q_appt_ref_no.equals("") && referal_id.equals("")) {

			String a_res_addr_line1 = "",a_res_addr_line2="",a_res_addr_line3="";
			String a_res_addr_line4 = "",a_country_code="",a_postal_code="";
			String a_res_area			= "",a_res_area_code="",a_res_town2_code="";
			String a_res_town2_desc = "",a_res_region_code="";
			String a_res_region_desc = "" ,m_res_addr_line1="",m_res_addr_line2="";
			String m_res_addr_line3 = "" ,m_res_addr_line4="",m_postal_code="";
			String m_country_code  = "",m_res_area_code="",m_res_area_desc="";
			String m_res_town2_code = "",m_res_town2_desc="",m_res_region_code="";
			String m_res_region_desc = "",strPrimaryResNo="",strOtherResNo="";
			String 	strEmail			= "",country1_desc="",country2_desc="",postal2_desc="",postaldesc1="";
			StringBuffer contactAddress=new StringBuffer();

			/*Added by Thamizh selvi on 25th Jan 2018 against ML-MMOH-CRF-0601 Start*/
			String alt_addr_line1 = "",alt_addr_line2="",alt_addr_line3="";
			String alt_addr_line4 = "",alt_country_code="", alt_country_desc="", alt_postal_code="";
			String alt_postal_desc = "", alt_area_desc	= "", alt_area_code="",alt_town_code="";
			String alt_town_desc = "",alt_region_code="", alt_region_desc = ""; 
			alt_addr_line1 = checkForNull(rs.getString("alt_addr_line1"));
			alt_addr_line2 = checkForNull(rs.getString("ALT_ADDR_LINE2"));
			alt_addr_line3 = checkForNull(rs.getString("ALT_ADDR_LINE3"));
			alt_addr_line4 = checkForNull(rs.getString("ALT_ADDR_LINE4"));
			alt_country_code  = checkForNull(rs.getString("ALT_COUNTRY_CODE"));
			alt_country_desc  = checkForNull(rs.getString("ALT_COUNTRY_DESC"));
			alt_postal_code    = checkForNull(rs.getString("ALT_POSTAL_CODE"));
			alt_postal_desc    = checkForNull(rs.getString("ALT_POSTAL_DESC"));
			alt_area_code = checkForNull(rs.getString("ALT_AREA_CODE"));
			alt_area_desc = checkForNull(rs.getString("ALT_AREA_DESC"));			
			alt_town_code = checkForNull(rs.getString("ALT_TOWN_CODE"));
			alt_town_desc = checkForNull(rs.getString("ALT_TOWN_DESC"));
			alt_region_code = checkForNull(rs.getString("ALT_REGION_CODE"));
			alt_region_desc = checkForNull(rs.getString("ALT_REGION_DESC"));
			/*End*/

			a_res_addr_line1 = rs.getString("addr1_line1");
			a_res_addr_line2 = rs.getString("addr1_line2");
			a_res_addr_line3 = rs.getString("addr1_line3");
			a_res_addr_line4 = rs.getString("addr1_line4");
			a_country_code  = rs.getString("country1_code");
			a_postal_code    = rs.getString("postal1_code");
			a_res_area_code = rs.getString("res_area_code");
			a_res_area = rs.getString("res_area");			
			a_res_town2_code = rs.getString("res_town_code");
			a_res_town2_desc = rs.getString("res_town");
			a_res_region_code = rs.getString("region_code");
			a_res_region_desc = rs.getString("region");			
			m_res_addr_line1 = rs.getString("addr2_line1");
			m_res_addr_line2 = rs.getString("addr2_line2");
			m_res_addr_line3 = rs.getString("addr2_line3");
			m_res_addr_line4 = rs.getString("addr2_line4");
			m_postal_code    = rs.getString("postal2_code");
			m_country_code  = rs.getString("country2_code");
			m_res_area_code = rs.getString("res_area2_code");
			m_res_area_desc = rs.getString("res_area2");
			m_res_town2_code = rs.getString("res_town2_code");
			m_res_town2_desc = rs.getString("res_town2");
			m_res_region_code = rs.getString("region2_code");
			m_res_region_desc = rs.getString("region2_desc");
			strPrimaryResNo  = rs.getString("CONTACT1_NO");
			strOtherResNo    = rs.getString("CONTACT2_NO");
			strEmail	   = rs.getString("EMAIL_ID");	
			country1_desc	   = rs.getString("country1_desc");	
			country2_desc	   = rs.getString("country2_desc");	
			postaldesc1= rs.getString("postaldesc1");	
			postal2_desc= rs.getString("postal2_desc"); 

			if(a_res_addr_line1 == null)a_res_addr_line1="";
			if(a_res_addr_line2 == null)a_res_addr_line2="";
			if(a_res_addr_line3 == null)a_res_addr_line3="";
			if(a_res_addr_line4 == null)a_res_addr_line4="";
			if(a_country_code == null)a_country_code="";
			if(a_postal_code == null)a_postal_code="";
			if(a_res_area_code == null)a_res_area_code="";
			if(a_res_area == null)a_res_area="";
			if(a_res_town2_code == null)a_res_town2_code="";
			if(a_res_town2_desc == null)a_res_town2_desc="";
			if(a_res_region_code == null)a_res_region_code="";
			if(a_res_region_desc == null)a_res_region_desc="";
			if(m_res_addr_line1 == null)m_res_addr_line1="";
			if(m_res_addr_line2 == null)m_res_addr_line2="";
			if(m_res_addr_line3 == null)m_res_addr_line3="";
			if(m_res_addr_line4 == null)m_res_addr_line4="";
			if(m_postal_code == null)m_postal_code="";
			if(m_country_code == null)m_country_code="";
			if(m_res_area_desc == null)m_res_area_desc="";
			if(m_res_town2_code == null)m_res_town2_code="";
			if(m_res_town2_desc == null)m_res_town2_desc="";
			if(m_res_region_code == null)m_res_region_code="";
			if(m_res_region_desc == null)m_res_region_desc="";
			if(strPrimaryResNo == null)strPrimaryResNo="";
			if(strOtherResNo == null)strOtherResNo="";
			if(strEmail == null)strEmail="";
			if(country1_desc == null)country1_desc="";
			if(country2_desc == null)country2_desc="";
			if(postaldesc1==null)postaldesc1="";
			if(postal2_desc==null)postal2_desc="";
			if(m_res_area_code==null)m_res_area_code="";
			
			contactAddress.append(""+"^^");
			contactAddress.append(a_res_addr_line1+"^^");
			contactAddress.append(a_res_addr_line2+"^^");
			contactAddress.append(a_res_addr_line3+"^^");
			contactAddress.append(a_res_addr_line4+"^^");
			contactAddress.append(a_res_town2_code+"^^");
			contactAddress.append(a_res_area_code+"^^");
			contactAddress.append(a_postal_code+"^^");
			contactAddress.append(a_res_region_code+"^^");
			contactAddress.append(a_country_code+"^^");
			contactAddress.append(""+"^^");
			contactAddress.append(""+"^^");
			contactAddress.append(""+"^^");
			contactAddress.append(m_res_addr_line1+"^^");
			contactAddress.append(m_res_addr_line2+"^^");
			contactAddress.append(m_res_addr_line3+"^^");
			contactAddress.append(m_res_addr_line4+"^^");
			contactAddress.append(m_res_town2_code+"^^");
			contactAddress.append(m_res_area_code+"^^");
			contactAddress.append(m_postal_code+"^^");
			contactAddress.append(m_res_region_code+"^^");
			contactAddress.append(m_country_code+"^^");
			contactAddress.append(""+"^^");
			contactAddress.append(""+"^^");
			contactAddress.append(strPrimaryResNo+"^^");
			contactAddress.append(strOtherResNo+"^^");
			contactAddress.append(strEmail+"^^");
			contactAddress.append(""+"^^");
			contactAddress.append(a_res_town2_desc+"^^");
			contactAddress.append(a_res_area+"^^");
			contactAddress.append(a_res_region_desc+"^^");
			contactAddress.append(m_res_town2_desc+"^^");
			contactAddress.append(m_res_area_desc+"^^");
			contactAddress.append(m_res_region_desc+"^^");
			contactAddress.append(country1_desc+"^^");
			contactAddress.append(country2_desc+"^^");
			contactAddress.append(postaldesc1+"^^");
			contactAddress.append(postal2_desc);
			/*Added by Thamizh selvi on 25th Jan 2018 against ML-MMOH-CRF-0601 Start*/
			contactAddress.append(""+"^^");
			contactAddress.append(alt_addr_line1+"^^");
			contactAddress.append(alt_addr_line2+"^^");
			contactAddress.append(alt_addr_line3+"^^");
			contactAddress.append(alt_addr_line4+"^^");
			contactAddress.append(alt_town_code+"^^");
			contactAddress.append(alt_area_code+"^^");
			contactAddress.append(alt_postal_code+"^^");
			contactAddress.append(alt_region_code+"^^");
			contactAddress.append(alt_country_code+"^^");
			contactAddress.append(alt_town_desc+"^^");
			contactAddress.append(alt_area_desc+"^^");
			contactAddress.append(alt_postal_desc+"^^");
			contactAddress.append(alt_region_desc+"^^");
			contactAddress.append(alt_country_desc+"^^");
			/*End*/

			concat_address_hidden = contactAddress;
		}

	}
	if(rs != null) rs.close();		
	if(pstmt!=null)pstmt.close();
	
	//Added by Santhosh for MMS-DM-CRF-0209.4-US005
	pstmt = con.prepareStatement("SELECT VISIT_TYPE_CODE FROM OP_VISIT_TYPE WHERE VISIT_TYPE_IND='F' AND EFF_STATUS='E'");
	
    rs = pstmt.executeQuery();
    if(rs!=null){
		while(rs.next()){
			firstVisitList = (firstVisitList=="" || firstVisitList.equals(""))?checkForNull(rs.getString("VISIT_TYPE_CODE")):firstVisitList+","+checkForNull(rs.getString("VISIT_TYPE_CODE"));
		}
	}
	if(rs != null) rs.close();		
	if(pstmt!=null)pstmt.close();
	
	pstmt = con.prepareStatement("SELECT VISIT_TYPE_CODE FROM OP_VISIT_TYPE WHERE VISIT_TYPE_IND='L' AND EFF_STATUS='E'");
	
    rs = pstmt.executeQuery();
    if(rs!=null){
		while(rs.next()){
			followUpVisitList = (followUpVisitList=="" || followUpVisitList.equals(""))?checkForNull(rs.getString("VISIT_TYPE_CODE")):followUpVisitList+","+checkForNull(rs.getString("VISIT_TYPE_CODE"));
		}
	}
	if(rs != null) rs.close();		
	if(pstmt!=null)pstmt.close();
	
	pstmt = con.prepareStatement("select REFERRAL_ID from PR_REFERRAL_REGISTER where PATIENT_ID='"+patient+"'");
    rs = pstmt.executeQuery();
    if(rs!=null && rs.next()) {
		isReferalId = (rs.getString("REFERRAL_ID") == null)?"":rs.getString("REFERRAL_ID");
	}
	if(rs != null) rs.close();		
	if(pstmt!=null)pstmt.close();
	
	System.err.println("firstVisitList============"+firstVisitList);
if(emer_regn_allow_yn.equals("N")&&id_type.equals("E"))
	{%>
	<script>alert(getMessage('OP_EMERG_PAT_NOT_ALLOWED','OP'));
         parent.parent.frames[0].document.getElementById("reset").click();
    </SCRIPT>
	<%}else{

if(!facilityid.equals(pref_fac))
   {%>
<script>     
	alert(getMessage('PREF_FCY_NOT_LOG_FCY','MP'));	  
 </SCRIPT>
	


<%}%>

<%
if(call_from.equals("CA"))
{
%>
 <SCRIPT>
	parent.frames[2].location.href='../../eCommon/jsp/pline.jsp?Patient_Id=<%=patient%>'
 </SCRIPT>
<%
}
else
{
%>
 <SCRIPT>
	             
	parent.parent.frames[1].frames[2].location.href='../../eCommon/jsp/pline.jsp?Patient_Id=<%=patient%>'
 </SCRIPT>
 <%
 }
 %>
<!--displayRemarksForOtherReason() Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->
<body onLoad='populateContactDetails();enableGif();PatVisHid(1);displayRemarksForOtherReason(document.forms[0].contact_reason_code);<%if(isImproveReferralProcessAppl){%>populateRefTab(document.forms[0].assign_care_locn_code.value);<%}%>' onMouseDown="CodeArrest();" onKeyDown ='lockKey()' onSelect="codeArrestThruSelect();" class='content'  >
<form name='visit_registration' id='visit_registration' method='post' action='../../servlet/eOP.VisitRegistrationServlet' target="messageFrame">

<%
  
 if (bl_interface_yn.equals("Y") && bl_install_yn.equals("Y") && regfromquery.equals("Y"))
  {
	
	CallableStatement call = con.prepareCall("{ ? = call  BLCOMMON.IS_AUTH_WINDOW_REQUIRED('"+facilityid+"', '"+patient+"','O',?)}");

	call.registerOutParameter(1, java.sql.Types.VARCHAR);
	call.registerOutParameter(2, java.sql.Types.VARCHAR); 	
	call.execute(); 
	
	auth_win_reqd_yn = checkForNull(call.getString(1));
	outst_amt = call.getDouble(2);	
	
	outst_amt1 = ""+outst_amt;
	
    CurrencyFormat cf1 = new CurrencyFormat();
    outst_amt1 = cf1.formatCurrency(outst_amt1, 2);
	
	reccnt = 1;
    record="Y";	

	if(call!=null)
		call.close();

   }%> 	 

<script>prevTabObj="visit_tab"</script>

<table cellspacing='0' cellpadding='0' width='100%' border='0' align='center' >
<tr>
 
<%
	if(bl_install_yn.equals("Y"))
	{
%> 
	<td  class="white"  width='70%' align='left'>
		<ul id="tablist" class="tablist"  style=padding-left:0px;>
			<li class="tablistitem" title="Visit">
				<a onclick="tab_clickQuery('visit_tab')" class="tabClicked" id="visit_tab" >
					<span class="tabSpanclicked" id="visit_tabspan"><fmt:message key="eOP.Visits.label" bundle="${op_labels}"/></span>
				</a>
			</li>
			<li class="tablistitem" title="Financial">
				<a onclick="javascript:tab_clickQuery('financial_tab')" class="tabA" id="financial_tab" >
					<span class="tabAspan" id="financial_tabspan"><fmt:message key="Common.financialdetails.label" bundle="${common_labels}"/></span>
				</a>
			</li>
		</ul>
	</td>
 
<%} else { %>
	<td class="white"  width='70%' align='left'>&nbsp;</td>
<% } %>
   <td id='button_item4' width='10%' class='button'></td><td id='button_item1' width='10%' class='button'></td>
</tr>
</table>
	
<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'> 
<a name='demo' ></a>

<%
	    if(!referal_id.equals("")) {
			pstmt  = con.prepareStatement("select get_referral_detail_line('"+referal_id+"','FROM','"+locale+"') from dual");
			rs = pstmt.executeQuery() ;
			rs.next() ; 
			//ref_dtls = (rs.getString(1).substring(2));
			ref_dtls = checkForNull(rs.getString(1));
			if(!ref_dtls.equals(""))
				ref_dtls = ref_dtls.substring(2);
		}
	
%>

<tr>
		<td class='label' width='18%' > <fmt:message key="Common.referraldetails.label" bundle="${common_labels}"/></td>
		<td id='refdetails' style='position:relative;' class="data" colspan='3' ><b><%=ref_dtls%></b></td><!-- <td colspan='4'></td> -->
</tr>

	<%
	   if(rs != null) rs.close();
	   if(pstmt != null) pstmt.close(); 
	 %> 	 



<tr>

<td class='label'  width='18%'><fmt:message key="Common.AppointmentDetails.label" bundle="${common_labels}"/></td>
<td id='refdetails' style='position:relative;' class="label" width = '34%'>
	<%
		if(!q_appt_ref_no.equals("")) {
	%>
		<b><%=q_appt_ref_no%> / <%=q_appt_time%></b>
	<%
		to_ser_code = request.getParameter("service_code")==null?"":request.getParameter("service_code");
		}
	%>
</td>

<!--modified below by Kamatchi S for ML-MMOH-CRF-1609--> 
<td class='label'  width='18%'>     
	<fmt:message key="Common.outstandingamount.label" bundle="${common_labels}"/>&nbsp;
</td> 
<td class='fields' style='position:relative;' width='30%'>
<% if (bl_install_yn.equals("Y")&&(outst_amt > 0)) {%>
	<b><%=outst_amt1%></b>
<% } %>
</td>
</tr>	

<tr>

<td class='label' width='18%'><fmt:message key="Common.VisitDateTime.label" bundle="${common_labels}"/></td>
		<td class='fields' width='34%'>		
		<% if (visit_back_yn.equalsIgnoreCase("Y")) { %>

		    <input type='text'  id='regndatetime' name="vst_regn_date_time" id="vst_regn_date_time"  value="<%=vst_regn_date%>" maxLength='19' size='19' onBlur='chkFromToTime2(this);' ><img src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('regndatetime','dd/mm/yyyy' ,'hh:mm:ss',null );" style='cursor:pointer'></img>&nbsp;<img src='../../eCommon/images/mandatory.gif' ></img>
			<input type='hidden' name='AllowedDate' id='AllowedDate' value="<%=allowed_date%>"></input>
			<input type='hidden' name='sysDateSer' id='sysDateSer' value="<%=vst_regn_date%>"></input>
			<input type='hidden' name="vst_regn_date_time_new" id="vst_regn_date_time_new"  value="<%=vst_regn_date_new%>"></input>
		<%}else {%>
				
			<input type='hidden' name="vst_regn_date_time" id="vst_regn_date_time"  value="<%=vst_regn_date%>" ></input>	
			<input type='text' name="vst_regn_date_time_new" id="vst_regn_date_time_new"  value="<%=vst_regn_date_new%>" maxLength='16' size='16' readonly> <!-- created by Srinivasrao Yeluri for incident no 29368 --> 				
        </td> 
		<%}%>
			<td  class='label' width = '18%'><fmt:message key="eOP.VisitDtlsTemplate.label" bundle="${op_labels}"/></td>
		<td   class='fields' width = '30%'>
			<INPUT TYPE="text" name="vis_det_temp_desc" id="vis_det_temp_desc" onBlur="onBlurgetVisdetails('<%=facilityid %>',document.forms[0].vis_det_temp_desc)" onchange='clearVisitDtls();'        <%=disableVisitTemplate%> ><input type="button" name="vis_det_temp_btn" id="vis_det_temp_btn" value="?" class="button" onClick="getVisdetails('<%=facilityid %>',document.forms[0].vis_det_temp_desc)"  <%=disableVisitTemplate%> ><input type="hidden" name="vis_det_temp_code" id="vis_det_temp_code" value="" >

			<!--Added by Ashwini on 23-Sep-2022 for TH-KW-CRF-0020.1-->
			<%if(isQMSInOPVisitRegAppl){%>
				&nbsp;&nbsp;<fmt:message key="eOP.QueuePKID.label" bundle="${op_labels}"/>
				&nbsp;&nbsp;<input type="text" name="qms_queue_pkid" id="qms_queue_pkid" maxlength=8 size=12 onKeyPress="return CheckForSpecCharsValidation2(event);" OnBlur="CheckSplCharsforIdValidation(this);getCommonQueueDtls(this,'<%=facilityid%>','OnBlur');">
			<%}%>

		</td>

 
</tr>
<% if (!q_visit_adm_type.equals("")) {       
	pstmt   = con.prepareStatement( "select short_desc from op_visit_type_lang_vw where visit_type_code = ? and facility_id=? and language_id='"+locale+"'"); pstmt.setString(1,q_visit_adm_type); 
	pstmt.setString(2,facilityid); 
	rs =  pstmt.executeQuery(); 
	if (rs!=null) 
	{ 
		while(rs.next()) 
		{ 
			q_visit_adm_type_desc = checkForNull(rs.getString(1)); 
		} 
	} 
	if (rs != null)   
		rs.close(); 
	if (pstmt != null) 
		pstmt.close();     
	}    

if(!order_catalog_code.equals("")) 
{ 
	pstmt=con.prepareStatement("select long_desc from or_order_catalog where order_catalog_code='"+order_catalog_code+"'"); 
	rs=pstmt.executeQuery(); 
	if(rs != null) 
	{ 
		if(rs.next()) 
		{ 
			order_catalog_desc=checkForNull(rs.getString(1)); 
		} 
	} 
	if(rs != null) 
		rs.close(); 
	if(pstmt != null) 
		pstmt.close(); 
}	

if(!q_practitioner_id.equals("")) 
{ 
	q_practitioner_id   = request.getParameter("q_practitioner_id")==null?"":request.getParameter("q_practitioner_id");

pstmt   = con.prepareStatement( "select practitioner_name from am_practitioner_lang_vw where practitioner_id = '"+q_practitioner_id+"' and language_id='"+locale+"'");

            rs =  pstmt.executeQuery();
            if (rs!=null)
            {
              while(rs.next())
              {
                q_practitioner_name = checkForNull(rs.getString(1));              
              }
            }
			if (rs != null)   rs.close();
            if (pstmt != null) pstmt.close();
              
             
      }	
	  
	  if(!q_appt_ref_no.equals(""))
	 {
		   if(!resource_class.equals("P") && !resource_class.equals("") && multi_speciality_yn.equals("N"))
		   {			   
		   	     q_practitioner_name="";
		   }
		   if(resource_class.equals("E") || resource_class.equals("O"))
		   {
				res_name=Rpractitioner_name;
				res_id=q_practitioner_id;
				

		   }

	 }
	  



	 %>  
	 

	  
	<tr>

	<td class='label' width='18%' nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
	<% if (!locn_ind.equals(""))  {%>
	<td class='fields' width='34%' nowrap><select name="locn_type" id="locn_type" onchange='clearLocnVal();displayRemarksForOtherReason(document.forms[0].contact_reason_code);' disabled>
	<%}else{%>
		<td class='fields' width='30%' nowrap><select name="locn_type" id="locn_type" onchange='clearLocnVal(this);displayRemarksForOtherReason(document.forms[0].contact_reason_code);'>
			<%}%>
			<option value="">------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ------
	<%

		try{
			String sql_locn = "select locn_type,short_desc from am_care_locn_type_lang_vw where care_locn_type_ind in ('C','E') and locn_type in ('C','E') and SYS_USER_DEF_IND='S' and language_id='"+localeName+"' order by short_desc ";	
							
			pstmt=con.prepareStatement(sql_locn);
			rs=pstmt.executeQuery();
			if(rs != null)
			{
				while(rs.next())
				{
					loctype=checkForNull(rs.getString("locn_type"));
					loctypedesc=checkForNull(rs.getString("short_desc"));
					if(loctype.equals(locn_ind)) {
            %>
           <OPTION VALUE='<%=loctype%>' selected><%=loctypedesc%>
            <%}else{ %>
			<OPTION VALUE='<%=loctype%>'><%=loctypedesc%>
			<%} }				
		       }	
		
			if(rs != null ) rs.close();
			if(pstmt != null ) pstmt.close();							
		} catch(Exception e) {
			e.printStackTrace();
		}


	%>
				
	</select>
	&nbsp;/&nbsp;	
 <%
	 	
 iSPractVisitLoad=eOP.QMSInterface.isSiteSpecific(con,"OP","PRACT_VISIT_LOAD");//added by munisekhar for MMS-QH-CRF-0167 [IN:044923] 
	// naren - to be checked
	if(!referal_id.equals(""))
	{
	pstmt   = con.prepareStatement("Select TO_SPECIALITY_CODE,TO_SERVICE_CODE  from PR_REFERRAL_REGISTER where REFERRAL_ID = ? ");
	pstmt.setString(1,referal_id);
	
	rs = pstmt.executeQuery();
	while( rs.next() )
		{
		
	to_speciality_code = rs.getString("TO_SPECIALITY_CODE")==null?"":rs.getString("TO_SPECIALITY_CODE");
	to_ser_code        = rs.getString("to_service_code")==null?"":rs.getString("to_service_code");
	
		}
	}
	 if(rs != null) rs.close();
	 if(pstmt != null) pstmt.close();
 	  

   if (q_clinic_code.equals(""))
    { 	
  %>
   <INPUT TYPE="text" name="assign_care_locn_desc" id="assign_care_locn_desc"  onBlur="onBlurgetLoc('<%=invitation_no%>','<%=referal_id%>','<%=register_visit_referral%>','<%=to_speciality_code%>','<%=register_visit_walkin%>','<%=functionId%>','<%=patient%>','<%=facilityid%>','<%=oper_stn_id%>','<%=userid%>',document.forms[0].assign_care_locn_desc);displayRemarksForOtherReason(document.forms[0].contact_reason_code);<%if(isImproveReferralProcessAppl){%>populateRefTab(document.forms[0].assign_care_locn_code.value);<%}%>"><input type="button" id="qloc_butt_id" name="qloc_butt" id="qloc_butt" value="?" class="button" onClick="getLocn('<%=invitation_no%>','<%=referal_id%>','<%=register_visit_referral%>','<%=to_speciality_code%>','<%=register_visit_walkin%>','<%=functionId%>','<%=patient%>','<%=facilityid%>','<%=oper_stn_id%>','<%=userid%>',document.forms[0].assign_care_locn_desc);displayRemarksForOtherReason(document.forms[0].contact_reason_code);<%if(isImproveReferralProcessAppl){%>populateRefTab(document.forms[0].assign_care_locn_code.value);<%}%>" ><input type="hidden" name="assign_care_locn_code" id="assign_care_locn_code"><img src='../../eCommon/images/mandatory.gif'>
   <!--added by munisekhar for MMS-QH-CRF-0167 [IN:044923] -->
   <%if(iSPractVisitLoad){%>
   <img  align='center' style="visibility:hidden" id="loc_name" src='../../eCommon/images/PatVisitLoad.png' onClick="getPatientQueue(document.forms[0].assign_care_locn_code.value)"/>
   <%}%>
   
<%}else{	
     pstmt   = con.prepareStatement( "select open_to_all_pract_yn,ident_at_checkin,primary_resource_class,long_desc, OP_APPL_YN, DC_APPL_YN, IP_APPL_YN, EM_APPL_YN,SPECIALITY_CODE from op_clinic_lang_vw where clinic_code='"+q_clinic_code+"' and language_id='"+locale+"' and facility_id='"+facilityid+"'");
     
	 rs = pstmt.executeQuery();
     if(rs != null)
      {
        while (rs.next())
	    { 
		CheckinIdent = checkForNull(rs.getString("ident_at_checkin")); 
		pres_class = checkForNull(rs.getString("primary_resource_class"));
		OP_APPL_YN = checkForNull(rs.getString( "OP_APPL_YN" ));
		IP_APPL_YN = checkForNull(rs.getString( "IP_APPL_YN" ));
		DC_APPL_YN = checkForNull(rs.getString( "DC_APPL_YN" ));
		EM_APPL_YN = checkForNull(rs.getString( "EM_APPL_YN" ));	
		open_to_all_pract_yn=rs.getString("open_to_all_pract_yn")==null?"N":rs.getString("open_to_all_pract_yn");
		q_clinic_desc=rs.getString("long_desc");
		speciality_code =  rs.getString("SPECIALITY_CODE")==null?"":rs.getString("SPECIALITY_CODE");
	    }
      }
	if(rs != null) rs.close();
	if(pstmt != null) pstmt.close();
	if(!invitation_no.equals("")){  //If condition added by S.Sathish for PMG20089-CRF-0850 on Friday, July 02, 2010
%>
	<INPUT TYPE="text" name="assign_care_locn_desc" id="assign_care_locn_desc"  value="<%=q_clinic_desc%>" onBlur="onBlurgetLoc('<%=invitation_no%>','<%=referal_id%>','<%=register_visit_referral%>','<%=to_speciality_code%>','<%=register_visit_walkin%>','<%=functionId%>','<%=patient%>','<%=facilityid%>','<%=oper_stn_id%>','<%=userid%>',document.forms[0].assign_care_locn_desc);displayRemarksForOtherReason(document.forms[0].contact_reason_code);<%if(isImproveReferralProcessAppl){%>populateRefTab(document.forms[0].assign_care_locn_code.value);<%}%>"><input type="button" id="qloc_butt_id" name="qloc_butt" id="qloc_butt" value="?" class="button" onClick="getLocn('<%=invitation_no%>','<%=referal_id%>','<%=register_visit_referral%>','<%=to_speciality_code%>','<%=register_visit_walkin%>','<%=functionId%>','<%=patient%>','<%=facilityid%>','<%=oper_stn_id%>','<%=userid%>',document.forms[0].assign_care_locn_desc);displayRemarksForOtherReason(document.forms[0].contact_reason_code);<%if(isImproveReferralProcessAppl){%>populateRefTab(document.forms[0].assign_care_locn_code.value);<%}%>" ><input type="hidden" name="assign_care_locn_code" id="assign_care_locn_code" value="<%=q_clinic_code%>"><img src='../../eCommon/images/mandatory.gif'>
	<!--added by munisekhar for MMS-QH-CRF-0167 [IN:044923] -->
	<%if(iSPractVisitLoad){%>
	<img  align='center' style="visibility:hidden" id="loc_name" src='../../eCommon/images/PatVisitLoad.png' onClick="getPatientQueue(document.forms[0].assign_care_locn_code.value)"/>
	<%}%>
<%}else{%>
    <input type="text" name='assign_care_locn_desc' id='assign_care_locn_desc' maxlength='20' size='20' value="<%=q_clinic_desc%>" readonly><img src='../../eCommon/images/mandatory.gif'>
	<!--added by munisekhar for MMS-QH-CRF-0167 [IN:044923] -->
	<%if(iSPractVisitLoad){%>
	<img  align='center' style="visibility:hidden" id="loc_name" src='../../eCommon/images/PatVisitLoad.png' onClick="getPatientQueue(document.forms[0].assign_care_locn_code.value)"/>
	<%}%>
    <input type='hidden' name='assign_care_locn_code' id='assign_care_locn_code' value="<%=q_clinic_code%>"></td>
 <%}}%>
 </td>


<td class = 'label'  width = '18%' ><fmt:message key="Common.room.label" bundle="${common_labels}"/></td>
	<td width = '34%' colspan = '2'>
	<select name='room_no' id='room_no' onChange = 'populateRoomDesc(this)'><option value = "">------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------------------</option>
	<%
	// query tuning.. modified by venkat S
 String  room_desc = "" ;
 String  selected = "" ;
 boolean flagvalue=false;  // added by mujafar for NMC-JD-CRF-0025
 String dis_room_value = "style='visibility:hidden;'";
   if (!q_clinic_code.equals(""))
    { 
		
		
	   if(q_practitioner_id1.equals(""))
		   q_practitioner_id1=q_practitioner_id;
	   
	   String sqlQuery =  "select a.practitioner_id ROOM_NO,b.room_type room_type,b.short_desc room_desc, CASE WHEN a.practitioner_id = '"+q_practitioner_id1+"' THEN 'selected=\"selected\"'  END AS selected from op_pract_for_clinic a, am_facility_room b where a.facility_id='"+facilityid+"' and a.clinic_code='"+q_clinic_code+"' and a.eff_status='E' and a.resource_class='R' and a.practitioner_id=b.room_num  AND a.facility_id=b.OPERATING_FACILITY_ID";
		
	   pstmt   = con.prepareStatement(sqlQuery);
	

	   
     rs = pstmt.executeQuery();
     while( rs.next())
      {
		  flagvalue=true;
        rm_no   = checkForNull(rs.getString( "ROOM_NO" ));
		room_type = checkForNull(rs.getString( "room_type" ));		
		room_desc = checkForNull(rs.getString( "room_desc" ));	
		selected = checkForNull(rs.getString( "selected" ));	
		
		
       %>
	   <!--below line was modified by Venkatesh.S on 08-Nov-2012 against 36090 -->
 		<option value = '<%=rm_no%>' <%=selected%>><%=rm_no%> <%=room_desc%>
	<%}}
	
	if(isRoomMandatoryRegVisit && flagvalue) // added by mujafar for NMC-JD-CRF-0025
		dis_room_value = "style='visibility:visible;'";
	   
	   
	   %>
  </select>
  
   <img <%=dis_room_value%>  id='room_img' src='../../eCommon/images/mandatory.gif'>
	
   
   <div id = 'roomDesc' style='position:absolute' class="label" ></div><%

  if(!room_desc.equals("") && !selected.equals("")){%>
	<script> 
	/* this line was commentd by venkatesh.s on 09/Nov/2012 agaings CRF SS-CRF-0010 [IN034516] FD 3.0 version */
	//parent.frames[3].document.getElementById("roomDesc").innerHTML='&nbsp;/&nbsp;'+'<%=room_desc%>';
				 
  </script>
	<%}%>
   </td>
 </tr>	
<tr> 
<td   class='label' width = '18%'><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
<td   class='fields' width = '34%'>
<select   name=service_code id=service_code onChange="popSubservice(this);">
<option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
 <%  
    servsql.setLength(0);
	
	if (!q_clinic_code.equals("")) {
    servsql.append("select service_code,short_desc from am_service_lang_vw where language_id='"+locale+"' and eff_status = 'E' and service_code in (select service_code from op_clinic where clinic_code ='"+q_clinic_code+"' and facility_id='"+facilityid+"' union SELECT b.service_code FROM OP_CLINIC_FOR_SERVICE b WHERE b.clinic_code ='"+q_clinic_code+"' AND b.facility_id='"+facilityid+"'"); 
	if(functionId.equals("VISIT_REGISTRATION"))
     {
      servsql.append( " and b.care_locn_type_ind = 'C')");
     }
    else if(functionId.equals("PROCD_REGISTRATION"))
          {
               servsql.append( " and b.care_locn_type_ind = 'E')");
          }
	pstmt   = con.prepareStatement(servsql.toString());
    rs = pstmt.executeQuery();
	
	
    while( rs.next())
    {
	  serviceCount++;		
	  service_code = checkForNull(rs.getString( "service_code" ));
	  short_desc   = checkForNull(rs.getString( "short_desc" ));
      if(to_ser_code.equals(service_code)){%>
      <option value = "<%=service_code%>" selected><%=short_desc%></option>
      <%}else{%>
      <option value = "<%=service_code%>" ><%=short_desc%></option>
      <%
	  }	
    }
	// The below code is newly added for CRF PMG20089-CRF-0855 [IN:024101] by Suresh M on 30.11.2010.
	  if(serviceCount == 1){%>
		 <script>document.forms[0].service_code.options[1].selected = true	;</script><%
	  }else{%>
		<script>document.forms[0].service_code.options[1].selected = false</script><%
	  }
	}
	%>



 </select><img src='../../eCommon/images/mandatory.gif'>
</td>
 <td  class='label' nowrap width = '18%'><fmt:message key="Common.subservice.label" bundle="${common_labels}"/></td>
 <td    class='fields' width = '30%'>
 <select   name=subservice_code id=subservice_code  >
 <option value=''>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option></select>
 </td>
</tr>
  
 <tr>
 <td  class = 'label'  width = '18%' nowrap> <fmt:message key="Common.visittype.label" bundle="${common_labels}"/></td>
 <td  class='fields' width = '34%' >
 <!-- Modified against PMG2014-TTM-CRF-0001 [IN:048624] -->
 <input type='hidden' name='isMohbr' id='isMohbr' value="<%=isMohbr%>">
 <%
if(visit_type_derv_rule.equals("S")){
	if(isMohbr){//The if condition added for the CRF - PMG2013-BRU-CRF-0002 [IN045555]
		if (q_visit_adm_type.equals(""))
	  {%> <select name='visit_adm_type' id='visit_adm_type' onChange="ChangeObj2(this,'<%=oa_install_yn%>');enableGif()"  disabled><option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</select><img src='../../eCommon/images/mandatory.gif'><%
	  }else{%>
	  
	  <input type="text" name='visit_adm_type_text1' id='visit_adm_type_text1' maxlength='20' size='18' value="<%=q_visit_adm_type_desc%>" disabled><img src='../../eCommon/images/mandatory.gif'></img>
	     <input type='hidden' name='visit_adm_type' id='visit_adm_type' value="<%=q_visit_adm_type%>"><%
		}
	}else{
   //if (q_visit_adm_type.equals(""))//Commented for the MMS-SCF-0010 
  //{%>
    <select name='visit_adm_type' id='visit_adm_type' onChange="ChangeObj2(this,'<%=oa_install_yn%>');enableGif()"  disabled>
	
	<%if(!q_visit_adm_type.equals("")){%><option value='<%=q_visit_adm_type%>' selected><%=q_visit_adm_type_desc%></option>
	<%}else{%><option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------<%}%>
	</select><img src='../../eCommon/images/mandatory.gif'>
<%//}//else{//Commented for the MMS-SCF-0010 - start%>
      
    <!--  <input type="text" name='visit_adm_type_text1' id='visit_adm_type_text1' maxlength='20' size='18' value="<%=q_visit_adm_type_desc%>" readonly><img src='../../eCommon/images/mandatory.gif'></img>
     <input type='hidden' name='visit_adm_type' id='visit_adm_type' value="<%=q_visit_adm_type%>"> --><!--Commented for the MMS-SCF-0010 -->
   <%//}
	 } 
}else if(visit_type_derv_rule.equals("P") && isPractoApptYn.equals("Y") && !q_visit_adm_type.equals("")){%>
	<input type="text" name='visit_adm_type_text1' id='visit_adm_type_text1' maxlength='20' size='18' value="<%=q_visit_adm_type_desc%>" disabled><img src='../../eCommon/images/mandatory.gif'></img>
	     <input type='hidden' name='visit_adm_type' id='visit_adm_type' value="<%=q_visit_adm_type%>">

<%}else{%>
			  <select name='visit_adm_type' id='visit_adm_type' onChange="ChangeObj2(this,'<%=oa_install_yn%>');enableGif()"  disabled><option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------
				</select><img src='../../eCommon/images/mandatory.gif'>
	<% }%>
</td>
<% if(!locn_ind.equals("E"))
	   dis_value="disabled";
	   else
		   dis_value="";
	   %>
	  


<td class='label' width = '18%'><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
<td class='fields' width = '30%'>
<select name='pat_class' id='pat_class' <%=dis_value%>>
<option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------

<%
	
if (!q_clinic_code.equals("")){
  // {

      pstmt   = con.prepareStatement( "Select Patient_Class, Short_Desc from AM_PATIENT_CLASS_lang_vw WHERE language_id='"+locale+"' and PATIENT_CLASS in(		decode(?,'Y','OP'),decode(?,'Y','IP'),decode(?,'Y','EM'),decode(?,'Y','DC'))");
	  
				
				pstmt.setString(1,OP_APPL_YN);
				pstmt.setString(2,IP_APPL_YN);
				pstmt.setString(3,EM_APPL_YN);
				pstmt.setString(4,DC_APPL_YN);
				rs = pstmt.executeQuery();
				while( rs.next())
				{%>
					<option value='<%=checkForNull(rs.getString("Patient_Class"))%>'> <%=checkForNull(rs.getString("Short_Desc"))%></option>
   				<%}
   }
  %>
</select>
</td> 	
   



<tr>	
	<td  class='label' width = '18%'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
	<td  align='left' width = '34%'>
<%

if(visit_type_derv_rule.equals("S") || visit_type_derv_rule.equals("B")){
   if(q_practitioner_id.equals("") && q_appt_ref_no.equals("")) {	%> 
	<input type="text" name="pract_name" id="pract_name"  readonly maxlength="30" size="30"  onblur='onBlurCallPractitionerSearchQuery(document.forms[0].pract_butt,pract_name);' ><input type="button" name="pract_butt" id="pract_butt" value="?" disabled class="button" onClick="callPractSearchQuery(this,pract_name);">
	<img id="gifpop" style='visibility:hidden' src='../../eCommon/images/mandatory.gif'></img>
	
	<input type='hidden' name='attend_practitioner_id' id='attend_practitioner_id' value=""><input type='hidden' name='prev_pract_name' id='prev_pract_name' value=""></td>
	<%
	} else { 
	if(override_pract_for_appt_yn.equals("Y")){%> 
		<input type="text" name="pract_name" id="pract_name" maxlength="30" size="30" value="<%=q_practitioner_name%>"  <%=disable_pract %> onblur='onBlurCallPractitionerSearchQuery(document.forms[0].pract_butt,pract_name);' ><input type="button" name="pract_butt" id="pract_butt" value="?" class="button" <%=disable_pract %> onClick="callPractSearchQuery(this,pract_name);">
		<img id="gifpop" style='visibility:hidden' src='../../eCommon/images/mandatory.gif'></img><img id="sec_res_gif" style='<%=gif_style%>' src='../../eCommon/images/SecRes.png' onclick='showSecondaryResource();'>
	   <%if((!q_appt_ref_no.equals("")) && (!resource_class.equals("P")) && multi_speciality_yn.equals("N")) {%>
			<input type='hidden' name='attend_practitioner_id' id='attend_practitioner_id' value="">
       <%}else{%>
			<input type='hidden' name='attend_practitioner_id' id='attend_practitioner_id' value="<%=q_practitioner_id%>">
			<input type='hidden' name='appt_practitioner_id' id='appt_practitioner_id' value="<%=q_practitioner_id%>">
		<%}%>
		<input type='hidden' name='prev_pract_name' id='prev_pract_name' value="">		
		</td>	<%
	 }else{ if(q_practitioner_name.equals("") ) {%>
		<input type="text" name="pract_name" id="pract_name" maxlength="30" size="30" value="<%=q_practitioner_name%>" <%=disable_pract %> onblur='onBlurCallPractitionerSearchQuery(document.forms[0].pract_butt,pract_name);' ><input type="button" name="pract_butt" id="pract_butt" value="?" class="button" <%=disable_pract %>  onClick="callPractSearchQuery(this,pract_name);">
		<img id="gifpop" style='visibility:hidden' src='../../eCommon/images/mandatory.gif'></img><img id="sec_res_gif" style='<%=gif_style%>' src='../../eCommon/images/SecRes.png' onclick='showSecondaryResource();'><%} else{ 	%>
	 <div id= 'enablelookup'>
		<input type="text" name='pract_name' id='pract_name' maxlength='30' size='30' value="<%=q_practitioner_name%>"  <%=disable_pract %> readonly><img id="gifpop" src='../../eCommon/images/mandatory.gif'></img><img id="sec_res_gif" style='<%=gif_style%>' src='../../eCommon/images/SecRes.png' onclick='showSecondaryResource();'></div>
		<%}
		if((!q_appt_ref_no.equals("")) && (!resource_class.equals("P")) && multi_speciality_yn.equals("N")){%>
			<input type='hidden' name='attend_practitioner_id' id='attend_practitioner_id' value="">
       <%}else{%>
			<input type='hidden' name='attend_practitioner_id' id='attend_practitioner_id' value="<%=q_practitioner_id%>">
		<%}
		%><input type='hidden' name='prev_pract_name' id='prev_pract_name' value="">
		</td>
		<%
		}	
	  }      
}else{// below IF condition is modified by Srinivas.Y for IN:35753
		if(q_practitioner_id.equals("") && q_appt_ref_no.equals("") && referal_id.equals("")) {	%> 
	<input type="text" name="pract_name" id="pract_name"  readonly <%=disable_pract %> maxlength="30" size="30"  onblur='onBlurCallPractitionerSearchQuery(document.forms[0].pract_butt,pract_name);' ><input type="button" name="pract_butt" id="pract_butt" value="?" disabled class="button" onClick="callPractSearchQuery(this,pract_name);">
	<img id="gifpoppract" src='../../eCommon/images/mandatory.gif'></img>	
	<input type='hidden' name='attend_practitioner_id' id='attend_practitioner_id' value=""><input type='hidden' name='prev_pract_name' id='prev_pract_name' value=""></td>
<%
} else { 
	if(override_pract_for_appt_yn.equals("Y")){%> 
		<input type="text" name="pract_name" id="pract_name" maxlength="30" size="30" value="<%=q_practitioner_name%>" <%=disable_pract %> onblur='onBlurCallPractitionerSearchQuery(document.forms[0].pract_butt,pract_name);' ><input type="button"  name="pract_butt" id="pract_butt" value="?" class="button" <%=disable_pract %>  onClick="callPractSearchQuery(this,pract_name);">
		<img id="gifpoppract" src='../../eCommon/images/mandatory.gif'></img><img id="sec_res_gif" style='<%=gif_style%>' src='../../eCommon/images/SecRes.png' onclick='showSecondaryResource();'>
	   <%if((!q_appt_ref_no.equals("")) && (!resource_class.equals("P")) && multi_speciality_yn.equals("N")) {%>
			<input type='hidden' name='attend_practitioner_id' id='attend_practitioner_id' value="">
       <%}else{%>
			<input type='hidden' name='attend_practitioner_id' id='attend_practitioner_id' value="<%=q_practitioner_id%>">
			<input type='hidden' name='appt_practitioner_id' id='appt_practitioner_id' value="<%=q_practitioner_id%>">
		<%}%>
		<input type='hidden' name='prev_pract_name' id='prev_pract_name' value="">		
		</td>	<%
	 }else{ if(q_practitioner_name.equals("") ) {%>
		<input type="text" name="pract_name" id="pract_name" maxlength="30" size="30" value="<%=q_practitioner_name%>" <%=disable_pract %> onblur='onBlurCallPractitionerSearchQuery(document.forms[0].pract_butt,pract_name);' ><input type="button" name="pract_butt" id="pract_butt" value="?" <%=disable_pract %> class="button" onClick="callPractSearchQuery(this,pract_name);">
		<img id="gifpoppract" src='../../eCommon/images/mandatory.gif'></img><img id="sec_res_gif" style='<%=gif_style%>' src='../../eCommon/images/SecRes.png' onclick='showSecondaryResource();'><%} else{ 	%>
	 <div id= 'enablelookup'>
		<input type="text" name='pract_name' id='pract_name' maxlength='30' size='30' value="<%=q_practitioner_name%>" readonly><img id="gifpoppract" src='../../eCommon/images/mandatory.gif'></img></div>
		<%}
		if((!q_appt_ref_no.equals("")) && (!resource_class.equals("P"))){%>
			<input type='hidden' name='attend_practitioner_id' id='attend_practitioner_id' value="">
       <%}else{%>
			<input type='hidden' name='attend_practitioner_id' id='attend_practitioner_id' value="<%=q_practitioner_id%>">
		<%}
		%><input type='hidden' name='prev_pract_name' id='prev_pract_name' value="">
		</td>
		<%
		}	
     }
  }
%>


  <td  class='label' nowrap width = '18%'><fmt:message key="eOP.OtherResource.label" bundle="${op_labels}"/></td>
  <td  align='left' nowrap width = '30%'>
  <select name='other_res_type' id='other_res_type' onChange='clearResourceVal(this);'>
  <option value=''>-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>

  <% if(resource_class.equals("E")){%>
  <option value='E' selected><fmt:message key="Common.equipment.label" bundle="${common_labels}"/></option>
  <option value='O'><fmt:message key="Common.others.label" bundle="${common_labels}"/></option>
  <%}else if(resource_class.equals("O")){ %>
    <option value='E'><fmt:message key="Common.equipment.label" bundle="${common_labels}"/></option>
	<option value='O' selected><fmt:message key="Common.others.label" bundle="${common_labels}"/></option>
  <%}else{%>
	<option value='E'><fmt:message key="Common.equipment.label" bundle="${common_labels}"/></option>
	<option value='O'><fmt:message key="Common.others.label" bundle="${common_labels}"/></option>
  <%}%>
  </select> 
  &nbsp;/&nbsp;	
  <input type='text' name='other_res_txt' id='other_res_txt' maxlength='15' size='16'  value='<%=res_name%>' ><input type='button' class='button' name='other_res_butt' id='other_res_butt' value='?' onClick='otherResourceLookUp(this,other_res_txt);' >
  <input type='hidden' name='other_res_code' id='other_res_code' value='<%=res_id%>'>
  </td>
</tr>

<tr>
	<td   class='label' nowrap width = '18%'><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
	<td  id='ordcat' width = '34%'>
	 <%	
	if(!order_catalog_code.equals("")) { %>
	<input type="text" name="order_cat_txt" id="order_cat_txt" maxlength="40" size="25"  value='<%=order_catalog_desc%>'readOnly><input type="button" name="order_cat_butt" id="order_cat_butt" value="?" class="button" disabled onClick="CallCatalogSearch(this,order_cat_txt);" ><img id="gifpopord" src='../../eCommon/images/mandatory.gif' style="visibility:hidden" ></img><%}else{ if(!q_appt_ref_no.equals("")){%><input type="text" name="order_cat_txt" id="order_cat_txt"  maxlength="40" size="25"  onblur="onBlurCallCatalogSearch(document.forms[0].order_cat_butt,order_cat_txt);" ><input type="button" name="order_cat_butt" id="order_cat_butt" value="?" class="button" onClick="CallCatalogSearch(this,order_cat_txt);" ><img id="gifpopord" src='../../eCommon/images/mandatory.gif' style="visibility:hidden" ></img><%} else {%><input type="text" name="order_cat_txt" id="order_cat_txt" readOnly maxlength="40" size="25"  onblur="onBlurCallCatalogSearch(document.forms[0].order_cat_butt,order_cat_txt);" ><input type="button" disabled name="order_cat_butt" id="order_cat_butt" value="?" class="button" onClick="CallCatalogSearch(this,order_cat_txt);" ><img id="gifpopord" src='../../eCommon/images/mandatory.gif' style="visibility:hidden" ></img><%} }

%>


	<input type='hidden' name='order_cat_txt_hidd' id='order_cat_txt_hidd' value=''>
	<input type='hidden' name='order_cat_code' id='order_cat_code' value='<%=order_catalog_code%>' >
	<input type='hidden' name='order_category_code' id='order_category_code' value='' >
	<input type='hidden' name='order_type_code' id='order_type_code' value='' >
	<input type='hidden' name='ordering_facility_id' id='ordering_facility_id' value='' >
	<input type='hidden' name='order_id' id='order_id' value='' >
	<input type='hidden' name='order_line_num' id='order_line_num' value='' >	
	</td>
<%
/*Below line added for this CRF GDOH-CRF-0129*/
if(isReferral){
     if(isCurrentEncounter){%>
	 <td  class='label' NOWRAP width = '18%'><fmt:message key="Common.Referralfrom.label" bundle="${common_labels}"/></td>
     <td  class='Fields' width = '30%'><input type="text" name="assigncare_location_desc" id="assigncare_location_desc" maxlength="40" size="25" value="<%=assigncare_location_desc%>" <%=referralforcurrentencounter%> >
     </td>	 
	 <%}else{%>
     <td  class='label' NOWRAP width = '18%'><fmt:message key="Common.Referralfrom.label" bundle="${common_labels}"/></td>
	 <!--displayRemarksForOtherReason() Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->
     <td  class='Fields' width = '30%'><input type="text" name="contact_reason_txt" id="contact_reason_txt" maxlength="40" size="25" value="<%=reason%>" onblur="onBlurCallContactReasonSearch(document.forms[0].contact_reason_butt,contact_reason_txt,'<%=q_appt_ref_no%>');displayRemarksForOtherReason(document.forms[0].contact_reason_code);" ><input type="button" name="contact_reason_butt" id="contact_reason_butt" value="?" class="button" onClick="CallContactReasonSearch(this,contact_reason_txt,'<%=q_appt_ref_no%>');displayRemarksForOtherReason(document.forms[0].contact_reason_code);" >
     </td>
<%}%>
 <input type="hidden" name="contact_reason_txt_hidd" id="contact_reason_txt_hidd" value="">
 <input type="hidden" name="contact_reason_code" id="contact_reason_code" value="<%=reason_code%>">

<%}else{%>
<td  class='label' NOWRAP width = '18%'><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
<td   class='Fields' width = '30%'>
	<%

	
// naren - contact reason to be passed and accessing oa_appt to be removed.

/*if (!q_appt_ref_no.equals("Null") || q_appt_ref_no !="")
{ 
pstmt   = con.prepareStatement("select am_get_desc.am_contact_reason(CONTACT_REASON_CODE,'"+locale+"',1)  reason,CONTACT_REASON_CODE from oa_appt where appt_ref_no='"+q_appt_ref_no+"' and facility_id='"+facilityid+"'");
rs= pstmt.executeQuery();
  if (rs!=null)
 {
  while (rs.next())
      {
       reason = rs.getString("reason");
      reason_code=rs.getString("CONTACT_REASON_CODE");
	  }
 }                           
}*/%>
<!--displayRemarksForOtherReason() Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->
<input type="text" name="contact_reason_txt" id="contact_reason_txt" maxlength="40" size="25" value="<%=reason%>" onblur="onBlurCallContactReasonSearch(document.forms[0].contact_reason_butt,contact_reason_txt,'<%=q_appt_ref_no%>');displayRemarksForOtherReason(contact_reason_code);" ><input type="button" name="contact_reason_butt" id="contact_reason_butt" value="?" class="button" onClick="CallContactReasonSearch(this,contact_reason_txt,'<%=q_appt_ref_no%>');displayRemarksForOtherReason(contact_reason_code);" >
<input type='hidden' name='contact_reason_txt_hidd' id='contact_reason_txt_hidd' value=''>
<input type='hidden' name='contact_reason_code' id='contact_reason_code' value='<%=reason_code%>' >
</td>
<%}
 //End this GDOH-CRF-0129
%>
	</tr>
<%if(!others_id.equals("")){%>
<!--Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->
<tr>
	<td class=label id='remarks_labl' style='visibility:hidden'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
	<td class="fields" id='remarks_fld' style='visibility:hidden'><textarea rows=2 cols=45 name="other_remarks" onkeyPress='checkMaxLimit(this,100)' onBlur="SPCheckMaxLen('Remarks',this,100)"></textarea><img src='../../eCommon/images/mandatory.gif' id='remarks_img' style='visibility:hidden'></td>
</tr>
<!--End ML-MMOH-CRF-1114-->
<%}%>
<!--Added by Santhosh for MMS-DM-CRF-0209.4-US005-->
<tr id="reqReff" style='visibility:hidden'>
<td  class='label' NOWRAP width = '18%'>Referal Required</td>
<td nowrap><input type="checkbox" name="Referal_Required" id='Referal_Required' onclick="getReferralReqID(this)"> </td>
</tr>
<!--END-->
<input  type='hidden' name='emergency_details' id='emergency_details'>    
</table>     

<div id='order_ctlg_tbl'>
</div>


      <!--Start--Hidden Fields for Billing Interface-->
    <%
		
    if((episode.equals("Y") && record.equals("Y")) || (episode.equals("N") && record.equals("Y")))
    {
    %>
		<% 
		if((!q_appt_ref_no.equals("")))
			{
		%>
				 <jsp:include page="../../eBL/jsp/BLFinDetHiddenFlds.jsp" ><jsp:param name="flush" value="true" />
				 <jsp:param name="patient_id" value="<%=patient%>" />
			     <jsp:param name="episode" value="<%=episode%>" />
			     <jsp:param name="record" value="<%=record%>" />
			     <jsp:param name="calling_module" value="OP" />
			     <jsp:param name="episode_type" value="O" />
			     <jsp:param name="calling_function_id" value="<%=functionId%>" />
			     <jsp:param name="apptrefno" value="<%=q_appt_ref_no%>" />
			     </jsp:include>
		<%			
			}
			else {
		%>	
        <jsp:include page="../../eBL/jsp/BLFinDetHiddenFlds.jsp" ><jsp:param name="flush" value="true" />
        <jsp:param name="patient_id" value="<%=patient%>" />
        <jsp:param name="episode" value="<%=episode%>" />
        <jsp:param name="record" value="<%=record%>" />
		<jsp:param name="calling_module" value="OP" />
        <jsp:param name="episode_type" value="O" />
        <jsp:param name="calling_function_id" value="<%=functionId%>" />		
        </jsp:include>
    <%
			}
    }
    else {
    
    %>
    <input type='hidden' name='billing_group' id='billing_group' value=""></input>
    <input type='hidden' name='billing_class' id='billing_class' value=""></input>
    <input type='hidden' name='employer_code' id='employer_code' value=""></input>
    <input type='hidden' name='cash_set_type1' id='cash_set_type1' value=""></input>
    <input type='hidden' name='cash_insmt_ref1' id='cash_insmt_ref1' value=""></input>
    <input type='hidden' name='cash_insmt_date1' id='cash_insmt_date1' value=""></input>
    <input type='hidden' name='cash_insmt_rmks1' id='cash_insmt_rmks1' value=""></input>
    <input type='hidden' name='cust_1' id='cust_1' value=""></input>
    <input type='hidden' name='credit_doc_ref1' id='credit_doc_ref1' value=""></input>
    <input type='hidden' name='credit_doc_date1' id='credit_doc_date1' value=""></input>
    <input type='hidden' name='cust_2' id='cust_2' value=""></input>
    <input type='hidden' name='credit_doc_ref2' id='credit_doc_ref2' value=""></input>
    <input type='hidden' name='credit_doc_date2' id='credit_doc_date2' value=""></input>
    <input type='hidden' name='cust_3' id='cust_3' value=""></input>
    <input type='hidden' name='policy_type' id='policy_type' value=""></input>
    <input type='hidden' name='policy_no' id='policy_no' value=""></input>
    <input type='hidden' name='policy_expiry_date' id='policy_expiry_date' value=""></input>
    <input type='hidden' name='non_insur_blng_grp' id='non_insur_blng_grp' value=""></input>
    <input type='hidden' name='cash_set_type2' id='cash_set_type2' value=""></input>
    <input type='hidden' name='cash_insmt_ref2' id='cash_insmt_ref2' value=""></input>
    <input type='hidden' name='cash_insmt_date2' id='cash_insmt_date2' value=""></input>
    <input type='hidden' name='cash_insmt_rmks2' id='cash_insmt_rmks2' value=""></input>
    <input type='hidden' name='cust_4' id='cust_4' value=""></input>
    <input type='hidden' name='credit_doc_ref3' id='credit_doc_ref3' value=""></input>
    <input type='hidden' name='credit_doc_date3' id='credit_doc_date3' value=""></input>
    <input type='hidden' name='setlmt_ind' id='setlmt_ind' value=""></input>
    <input type='hidden' name='upd_fin_dtls' id='upd_fin_dtls' value=""></input>
    <input type='hidden' name='billing_mode' id='billing_mode' value="Add"></input>
    <input type='hidden' name='credit_auth_date' id='credit_auth_date' value=''></input>
    <input type='hidden' name='app_days' id='app_days' value=''></input>
    <input type='hidden' name='app_amount' id='app_amount' value=''></input>
	
	
<!-- Added for Billing Enhancements -->    
	<input type='hidden' name='health_card_expired_yn' id='health_card_expired_yn' value=''></input>
    <input type='hidden' name='annual_income' id='annual_income' value=''></input>
    <input type='hidden' name='family_asset' id='family_asset' value=''></input>
    <input type='hidden' name='no_of_dependants' id='no_of_dependants' value=''></input>
    <input type='hidden' name='resp_for_payment' id='resp_for_payment' value=''></input>
    <input type='hidden' name='credit_doc_reqd_yn1' id='credit_doc_reqd_yn1' value=''></input>
    <input type='hidden' name='credit_doc_reqd_yn2' id='credit_doc_reqd_yn2' value=''></input>
<!-- End for Billing Enhancements -->
    <input type='hidden' name='eff_frm_date' id='eff_frm_date' value=''></input>
   
		<input type='hidden' name='gl_holder_name' id='gl_holder_name' value="">
				<input type='hidden' name='gl_holder_reln' id='gl_holder_reln' value="">
    <%}
    %>
    <!--End--Hidden Fields for Billing Interface-->
    <input type='hidden' name='new_op_episode_yn' id='new_op_episode_yn' value=''></input>
	<input type='hidden' name='user_id' id='user_id' value='<%=userid%>'></input>
	<input type='hidden' name='remarks' id='remarks' value=''></input>   
    <input type='hidden' name='upd_user_flag' id='upd_user_flag' value=''></input>
    <input type='hidden' name='reccnt' id='reccnt' value="<%=reccnt%>"></input>
    <!-- Hidden fields for Visit Charge Calculation  -->
    <input type='hidden' name='pkg_bill_doc_type' id='pkg_bill_doc_type' value=""></input>
    <input type='hidden' name='pkg_bill_doc_num' id='pkg_bill_doc_num' value=""></input>
    <input type='hidden' name='policy_type_code' id='policy_type_code' value=""></input>
    <input type='hidden' name='effective_date' id='effective_date' value=""></input>
    <input type='hidden' name='credit_auth_ref' id='credit_auth_ref' value=""></input>
    <input type='hidden' name='approved_days' id='approved_days' value=""></input>
    <input type='hidden' name='base_qty' id='base_qty' value=""></input>
    <input type='hidden' name='base_rate' id='base_rate' value=""></input>
    <input type='hidden' name='base_charge_amt' id='base_charge_amt' value=""></input>
    <input type='hidden' name='gross_charge_amt' id='gross_charge_amt' value=""></input>
    <input type='hidden' name='disc_amt' id='disc_amt' value=""></input>
    <input type='hidden' name='net_charge_amt' id='net_charge_amt' value=""></input>
    <input type='hidden' name='pat_base_qty' id='pat_base_qty' value=""></input>
    <input type='hidden' name='pat_base_rate' id='pat_base_rate' value=""></input>
    <input type='hidden' name='pat_serv_qty' id='pat_serv_qty' value=""></input>
    <input type='hidden' name='pat_base_charge_amt' id='pat_base_charge_amt' value=""></input>
    <input type='hidden' name='pat_gross_charge_amt' id='pat_gross_charge_amt' value=""></input>
    <input type='hidden' name='pat_disc_amt' id='pat_disc_amt' value=""></input>
    <input type='hidden' name='pat_net_charge_amt' id='pat_net_charge_amt' value=""></input>
    <input type='hidden' name='cust_base_qty' id='cust_base_qty' value=""></input>
    <input type='hidden' name='cust_base_rate' id='cust_base_rate' value=""></input>
    <input type='hidden' name='cust_serv_qty' id='cust_serv_qty' value=""></input>
    <input type='hidden' name='cust_base_charge_amt' id='cust_base_charge_amt' value=""></input>
    <input type='hidden' name='cust_gross_charge_amt' id='cust_gross_charge_amt' value=""></input>
    <input type='hidden' name='cust_disc_amt' id='cust_disc_amt' value=""></input>
    <input type='hidden' name='cust_net_charge_amt' id='cust_net_charge_amt' value=""></input>
    <input type='hidden' name='split_yn' id='split_yn' value=""></input>
    <input type='hidden' name='pkg_ins_pat_ind' id='pkg_ins_pat_ind' value=""></input>
    <input type='hidden' name='req_pkg_qty' id='req_pkg_qty' value=""></input>
    <input type='hidden' name='req_addl_qty' id='req_addl_qty' value=""></input>
    <input type='hidden' name='req_std_qty' id='req_std_qty' value=""></input>
    <input type='hidden' name='curr_availed' id='curr_availed' value=""></input>
    <input type='hidden' name='canadj_alert_ind' id='canadj_alert_ind' value=""></input>
    <input type='hidden' name='pkg_serv_code' id='pkg_serv_code' value=""></input>
    <input type='hidden' name='visit_charge_stage' id='visit_charge_stage' value="<%=visit_charge_stage%>"></input>
    <input type='hidden' name='day_type_code' id='day_type_code' value=""></input>  
    <input type='hidden' name='time_type_code' id='time_type_code' value=""></input>     
    <input type='hidden' name='disc_perc' id='disc_perc' value=""></input>  
    <input type='hidden' name='addl_fctr' id='addl_fctr' value=""></input>
  
	<input type='hidden' name='order_catalog_code' id='order_catalog_code' value="<%=order_catalog_code%>"></input>
	<input type='hidden' name='order_catalog_desc' id='order_catalog_desc' value="<%=order_catalog_desc%>"></input>
	<input type='hidden' name='orderId' id='orderId' value="<%=order_id%>">
	<input type='hidden' name='call_from' id='call_from' value="<%=call_from%>">
	<input type='hidden' name='populate_visit_type' id='populate_visit_type' value="">
	
		
    

    <!-- End of Hidden fields for Visit Charge Calculation  -->
    <input type='hidden' name='sys_date' id='sys_date' value="<%=sys_date%>"></input> 
	<input type='hidden' name='pkg_sel' id='pkg_sel' value=""></input>    
    <input type='hidden' name='pkg_bill_type' id='pkg_bill_type' value=""></input>  
    <input type='hidden' name='pkg_bill_no' id='pkg_bill_no' value=""></input>
		<input type='hidden' name='resource_class' id='resource_class' value='<%=resource_class%>'>
	<input type='hidden' name='res_pract_id' id='res_pract_id' value='<%=res_pract_id%>'>


	<input type='hidden' name='cred_start_dt1' id='cred_start_dt1' value=""></input>  
    <input type='hidden' name='cred_start_dt2' id='cred_start_dt2' value=""></input>  
    <input type='hidden' name='cred_start_dt3' id='cred_start_dt3' value=""></input> 

	
	<input type='hidden' name='entitlement_by_cat_yn' id='entitlement_by_cat_yn' value="<%=entitlement_by_cat_yn%>"></input> 
	<input type='hidden' name='isOrderCtlgAmtCalc' id='isOrderCtlgAmtCalc' value="<%=isOrderCtlgAmtCalc%>" />
	<input type='hidden' name='isPractoApptYn' id='isPractoApptYn' value="<%=isPractoApptYn%>" />
		
  <%
     //Added for biling  
  // for scrum code added 
	
      if (bl_interface_yn.equals("Y") && bl_install_yn.equals("Y") )
      {
		    /*
		    if(rs!=null)
				rs.close();
			if(pstmt!=null)
				pstmt.close();

			String auth_win_reqd_yn = "N";
			
			pstmt = con.prepareStatement("select BLCOMMON.IS_AUTH_WINDOW_REQUIRED('"+facilityid+"', '"+patient+"','O') from dual");

			rs = pstmt.executeQuery();

			if(rs!=null && rs.next()) {
				auth_win_reqd_yn = rs.getString(1);
			}

			*/

			if((auth_win_reqd_yn.equals("Y")|| !gen_remark.equals("") ) && !blflag_op_yn.equals("Y") ) { //Added for this CRF incident [52415]
           
			%>
              <script>dispAuth(<%=+outst_amt%>,'<%=patient%>');</script>
			<%  

			}
			else
		  {
				/*
				  Below code added for Scrum 10638
				*/
				%>
				 <script>funPatRegCharges('<%=patient%>');</script>
				<%
		  }				
		
			if(regfromquery.equals("Y"))
			{
			PreparedStatement pstmtBillingRem= null;
			ResultSet rsetBillingRem = null;
			String episode_type = "O";
			String bl_show_remarks_yn = "N";
			long episode_id = 0;
			long visit_id = 0;
			String calling_module_id = "OP";
			String calling_function_id = functionId;

			pstmtBillingRem = con.prepareStatement("Select blcommon.BL_SHOW_BLNG_REMARKS_YN(?,?,?,?,?,?,?) from dual");
			pstmtBillingRem.setString(1,facilityid);
			pstmtBillingRem.setString(2,calling_module_id);
			pstmtBillingRem.setString(3,calling_function_id);
			pstmtBillingRem.setString(4,patient);
			pstmtBillingRem.setString(5,episode_type);
			pstmtBillingRem.setLong(6,episode_id);
			pstmtBillingRem.setLong(7,visit_id);
			rsetBillingRem = pstmtBillingRem.executeQuery();
			while(rsetBillingRem.next())
			{
				bl_show_remarks_yn = checkForNull(rsetBillingRem.getString(1));
			}
			
			rsetBillingRem.close();
			pstmtBillingRem.close();
			out.println("<input type='hidden' name='module_id' id='module_id' value='"+calling_module_id+"'>");
			out.println("<input type='hidden' name='calling_function_id' id='calling_function_id' value='"+calling_function_id+"'>");
			out.println("<input type='hidden' name='episode_type' id='episode_type' value='"+episode_type+"'>");
			out.println("<input type='hidden' name='bl_show_remarks_yn' id='bl_show_remarks_yn' value='"+bl_show_remarks_yn+"'>");
			out.println("<input type='hidden' name='episode_id' id='episode_id' value='"+episode_id+"'>");
			out.println("<input type='hidden' name='visit_id' id='visit_id' value='"+visit_id+"'>");
			out.println("<input type='hidden' name='patId' id='patId' value='"+patient+"'>");
			if (bl_show_remarks_yn.equalsIgnoreCase("Y"))
			{
				out.println("<script>showBillingRemarks();</script>");
			}
			}
		

			//<<billing_remarks#02>>End

		if(rs != null) rs.close();		
		if(pstmt!=null)pstmt.close();

	if(!referal_id.equals(""))
	{

		pstmt=con.prepareStatement("select b.org_type from PR_REFERRAL_REGISTER a, AM_REFERRAL b where a.referral_id = '"+referal_id+"' and a.from_ref_code = b.referral_code ");
		rs = pstmt.executeQuery();

			if(rs.next()) 
			{
				org_type_data = checkForNull(rs.getString("org_type"));
				if(org_type_data == null) org_type_data = "";

				if(org_type_data.equals("P"))  		
					org_type_data="P";
				else
					org_type_data="G";
			}
			else
			{
				org_type_data="G";
			}
			if(rs != null)rs.close(); if(pstmt != null) pstmt.close();									
	}
      }
      // End of Billing
				
    display_button3 = "<input type='button' name='prev_visit' id='prev_visit'  Value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PreviousEncounters.label","common_labels")+"'  class='Button' onClick=show_last_visit_details('"+patient+"') >";
	display_button1 = "<input type='button' class='button' name='contact_details' id='contact_details' value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ContactDetails.label","common_labels")+"'  onclick='Modal_Contact_Details(this);'id = '' >";


%>
<script>
/** Commented by Smita Unnikrishnan on 02-03-04 while changing the layout design for Visit registration**/
if(document.getElementById("button_item1")  != null)
	document.getElementById("button_item1").innerHTML="<%=display_button1%>";

if(document.getElementById("button_item4") != null)
	document.getElementById("button_item4").innerHTML="<%=display_button3%>";

if(<%=pr_ent_cnt%> == 0) {
	if(document.forms[0].prev_visit != null) {
		document.forms[0].prev_visit.disabled=true;
	}
} else {
	if(document.forms[0].prev_visit != null) {
		document.forms[0].prev_visit.disabled=false;
	}
} 
	
</script> 	
	
	<input type='hidden' name='pat_ser_grp_code' id='pat_ser_grp_code' value="<%=pat_ser_grp_code%>">	
	<input type='hidden' name='exceded_max_walkin' id='exceded_max_walkin' value="false">	
	<input type='hidden' name='no_of_multi_orders' id='no_of_multi_orders' value="1">	
	<input type='hidden' name='override_walkin_yn' id='override_walkin_yn' value="">
	<input type='hidden' name='queueNo' id='queueNo' value=''>		 
	<input type='hidden' name='waitTime' id='waitTime' value=''>	
	<!-- <input type='hidden' name='call_from' id='call_from' value="<%=call_from%>"> -->

	<input type='hidden' name='inv_splty_code' id='inv_splty_code' value="<%=inv_splty_code%>">	
	<input type='hidden' name='patient_id' id='patient_id' value="<%=patient%>">
	<input type='hidden' name='override_pract_for_appt' id='override_pract_for_appt' value="<%=override_pract_for_appt_yn%>">	
	<input type='hidden' name='assign_q_num_by' id='assign_q_num_by' value="<%=assign_q_num_by%>">	
	<input type='hidden' name='bl_patient_id' id='bl_patient_id' value="<%=patient%>">	
	<input type='hidden' name='oa_install_yn' id='oa_install_yn' value='<%=oa_install_yn%>'>	
	<input type='hidden' name='patFlag' id='patFlag' value="<%=patientFlag%>">	
	<input type='hidden' name='sStyle' id='sStyle' value="<%=sStyle%>">
	<input type='hidden' name='pat_details' id='pat_details' value='<%=Pat_Details%>'>
	<input type='hidden' name='date_of_birth' id='date_of_birth' value='<%=dob%>'>
	<input type='hidden' name='sec_level' id='sec_level' value='<%=seclevel%>'>
	<input type='hidden' name='protection_ind' id='protection_ind' value='<%=protectionind%>'>
	<input type='hidden' name='outst_amt' id='outst_amt' value="<%=outst_amt%>">
	<input type='hidden' name='pract_type' id='pract_type' value="">
	<input type='hidden' name='last_visit_date' id='last_visit_date'>
	<input type='hidden' name='open_to_all_pract_yn' id='open_to_all_pract_yn' value="<%=open_to_all_pract_yn%>">
	<input type='hidden' name='no_practitioner_for_appt' id='no_practitioner_for_appt' value="N">
	<input type='hidden' name='ident_at_checkin' id='ident_at_checkin' value='<%=CheckinIdent%>'>
	<input type='hidden' name='h_visit_type_ind' id='h_visit_type_ind'>
	<input type='hidden' name='gen_file_yn' id='gen_file_yn' value="<%=gen_file_yn%>">
	<input type='hidden' name='build_episode_rule' id='build_episode_rule' value='<%=build_episode_rule%>'> 
	<input type='hidden' name='or_install_yn' id='or_install_yn' value="<%=or_install_yn%>" >
	<input type='hidden' name='bl_install_yn' id='bl_install_yn' value="<%=bl_install_yn%>"> 
	<input type='hidden' name='function' id='function' value='Generate_File'>
	<input type='hidden' name='function_name' id='function_name' value='Generate_File'>
	<input type='hidden' name='Chg_to_Visitor_Grp' id='Chg_to_Visitor_Grp' value="<%=ChgToVisitorGrp%>">
	<!-- Added for Billing validation on 16/8/2002 -->
	<input type='hidden' name='health_card_expired_yn1' id='health_card_expired_yn1' value='<%=HcExpired%>'>
	<input type='hidden' name='bl_success' id='bl_success' value="N">
	<input type='hidden' name='override_vtype_on_epsd_yn' id='override_vtype_on_epsd_yn' value="<%=override_vtype_on_epsd_yn%>">
	<input type='hidden' name='episode_close_days_fu' id='episode_close_days_fu' value="<%=episode_close_days_fu%>">
	<input type='hidden' name='episode_close_days_wo_fu' id='episode_close_days_wo_fu' value="<%=episode_close_days_wo_fu%>">  
	<input type='hidden' name='dur_for_fu_vsts_in_days' id='dur_for_fu_vsts_in_days' value="">  
	<input type='hidden' name='no_of_fu_visits_allowed' id='no_of_fu_visits_allowed' value="">  
	<input type='hidden' name='ct_patient_id' id='ct_patient_id' value=''>
	<input type='hidden' name='error' id='error' value=''>
	<input type='hidden' name='old_op_episode_id' id='old_op_episode_id' value=''>
	<input type='hidden' name='old_op_episode_visit_num' id='old_op_episode_visit_num' value=''>
	<input type='hidden' name='oper_stn_id' id='oper_stn_id' value='<%=oper_stn_id%>'>
	<input type='hidden' name='l_encounter_id' id='l_encounter_id' value="<%=l_encounter_id%>"> 
	<input type='hidden' name='new_episode_yn' id='new_episode_yn' value="">
	<input type='hidden' name='referral_code' id='referral_code' value="<%=referal_id%>">
	<input type='hidden' name='reg_vis_param' id='reg_vis_param' value='<%=reg_vis_param%>'>
	<input type='hidden' name='facilityId' id='facilityId' value="<%=facilityid%>">
	<input type='hidden' name='visit_adm_type_ind' id='visit_adm_type_ind' value="R">
	<input type='hidden'  name='old_episode_no' id='old_episode_no'>
    <input type='hidden' style='text-align:right' name='op_episode_id' id='op_episode_id'  >
	<input type='hidden' style='text-align:right' name='cur_episode_id' id='cur_episode_id'  value="<%=curepisodeid%>" size='12' maxlength='12'>
    <input type='hidden' style='text-align:right' name='op_episode_visit_num' id='op_episode_visit_num' >
	<input type='hidden' name='register_pat_yn' id='register_pat_yn' value="<%=register_pat_yn%>">
	<input type='hidden' name='wait_list_flag' id='wait_list_flag' value="<%=wait_flag%>">
	<input type='hidden' name='DispAlert' id='DispAlert' value="Y">
	<input type='hidden' name='nat_id_prompt' id='nat_id_prompt' value="<%=nat_id_prompt%>">
	<!-- *********added on 11/12/2003 , pass referral_id  to financila details******* -->
	<input type='hidden' name='financial_detail_ref_id' id='financial_detail_ref_id' value='<%=referal_id%>'> 
	<input type='hidden' name='org_type' id='org_type' value='<%=org_type_data%>'>
	<input type="hidden" name="room_type" id="room_type" value="<%=room_type%>"  >
	<input type="hidden" name="rm_no" id="rm_no" value="<%=rm_no%>"  >
	<input type="hidden" name="q_visit_adm_type_ind" id="q_visit_adm_type_ind" value="<%=q_visit_adm_type_ind%>"  >
	<input type="hidden" name="q_visit_adm_type" id="q_visit_adm_type" value="<%=q_visit_adm_type%>"  ><!--Included for the MMS-SCF-0010 -->
	<!-- *****added for inclusion of contact details**** -->
	<input type='hidden' name='change_address' id='change_address' value=''>
    <input type='hidden' name='concat_address_hidden' id='concat_address_hidden' value="<%=concat_address_hidden.toString()%>">	<input type='hidden' name='concat_NatIdDetails_hidden' id='concat_NatIdDetails_hidden' value=''>		
	<input type='hidden' name='addr1_type' id='addr1_type' value="">
	<input type='hidden' name='addr_line1' id='addr_line1' value="" >
	<input type='hidden' name='addr_line2' id='addr_line2' value="" >
	<input type='hidden' name='addr_line3' id='addr_line3' value="" >
	<input type='hidden' name='addr_line4' id='addr_line4' value="" >
	<input type='hidden' name='res_town_code' id='res_town_code' value="" >
	<input type='hidden' name='res_town_desc' id='res_town_desc' value="" >
	<input type='hidden' name='res_area_code' id='res_area_code' value="">
	<input type='hidden' name='res_area_desc' id='res_area_desc' value="">
	<input type='hidden' name='postal_code' id='postal_code' value="" >	
	<input type='hidden' name='region_code' id='region_code' value="" >	
	<input type='hidden' name='region_desc' id='region_desc' value="" >	
	<input type='hidden' name='country_code' id='country_code' value="" >
	<input type='hidden' name='contact1_name' id='contact1_name' value="">
	<input type='hidden' name='invalid1_yn' id='invalid1_yn' value="">
	<input type='hidden' name='addr2_type' id='addr2_type' value="">
	<input type='hidden' name='mail_addr_line1' id='mail_addr_line1'value="">
	<input type='hidden' name='mail_addr_line2' id='mail_addr_line2' value="">
	<input type='hidden' name='mail_addr_line3' id='mail_addr_line3' value="" >
	<input type='hidden' name='mail_addr_line4' id='mail_addr_line4' value="">
	<input type='hidden' name='mail_res_town_code' id='mail_res_town_code' value="">
	<input type='hidden' name='mail_res_town_desc' id='mail_res_town_desc' value="">
	<input type='hidden' name='mail_res_area_code' id='mail_res_area_code' value="">
	<input type='hidden' name='mail_res_area_desc' id='mail_res_area_desc' value="" >
	<input type='hidden' name='mail_postal_code' id='mail_postal_code' value="" >
	<input type='hidden' name='mail_region_code' id='mail_region_code' value="">
	<input type='hidden' name='mail_region_desc' id='mail_region_desc' value="" >
	<input type='hidden' name='mail_country_code' id='mail_country_code' value="" >
	<input type='hidden' name='r_postal_code1' id='r_postal_code1' value='' >
    <input type='hidden' name='m_postal_code1' id='m_postal_code1' value=''>

	<!--Added by Thamizh selvi on 25th Jan 2018 against ML-MMOH-CRF-0601 Start-->
	<input type='hidden' name='addr3_type' id='addr3_type' value="">
	<input type='hidden' name='alt_addr_line1' id='alt_addr_line1' value="">
	<input type='hidden' name='alt_addr_line2' id='alt_addr_line2' value="">
	<input type='hidden' name='alt_addr_line3' id='alt_addr_line3' value="">
	<input type='hidden' name='alt_addr_line4' id='alt_addr_line4' value="">
	<input type='hidden' name='alt_town_code' id='alt_town_code' value="">
	<input type='hidden' name='alt_town_desc' id='alt_town_desc' value="">
	<input type='hidden' name='alt_area_code' id='alt_area_code' value="">
	<input type='hidden' name='alt_area_desc' id='alt_area_desc' value="">
	<input type='hidden' name='alt_postal_code' id='alt_postal_code' value="">
	<input type='hidden' name='alt_postal_code1' id='alt_postal_code1' value="">
	<input type='hidden' name='alt_region_code' id='alt_region_code' value="">
	<input type='hidden' name='alt_region_desc' id='alt_region_desc' value="">
	<input type='hidden' name='alt_country_code' id='alt_country_code' value="">
	<input type='hidden' name='alt_country_desc' id='alt_country_desc' value="">
	<!--End-->
	
	<input type='hidden' name='query_string' id='query_string' value="<%=query_string%>">
	<input type='hidden' name='contact2_name' id='contact2_name' value="">
	<input type='hidden' name='invalid2_yn' id='invalid2_yn' value="">
	<input type='hidden' name='country_desc' id='country_desc' value="" maxlength='6'>
	<input type='hidden' name='mail_country_desc' id='mail_country_desc' value="" maxlength='6'>
	<input type='hidden' name='bed_num' id='bed_num' value='<%=bed_num%>'>
	<input type='hidden' name='discharge_date_time' id='discharge_date_time' value='<%=dischargedatetime%>'>
	<input type='hidden' name='functionId' id='functionId' value='<%=functionId%>'>
	<input type='hidden' name='menu_function_id' id='menu_function_id' value='<%=menu_function_id%>'>
	<input type='hidden' name='bl_interface_yn' id='bl_interface_yn' value='<%=bl_interface_yn%>'>
	<input type="hidden" name="appt_ref_no_2" id="appt_ref_no_2" value="<%=q_appt_ref_no%>"  >
	<input type="hidden" name="appt_ref_no" id="appt_ref_no" value="<%=q_appt_ref_no%>"  >
	<input type='hidden' name='clptype' id='clptype' value="">
	<input type='hidden' name='order_req' id='order_req' value="">
	<input type='hidden' name='help_function_id' id='help_function_id' value='<%=functionId%>'>
	<input type='hidden' name='contact1_no' id='contact1_no' value="">
	<input type='hidden' name='contact2_no' id='contact2_no' value="">
	<input type='hidden' name='email' id='email' value="">
	<input type='hidden' name='locationSpeciality' id='locationSpeciality' value="<%=speciality_code%>">
	<input type='hidden' name='from_reg' id='from_reg' value='<%=from_reg%>'>
	<input type='hidden' name='new_file_no' id='new_file_no' value=''>
	<input type='hidden' name='dummy_visit_type' id='dummy_visit_type' value=''>			
	<input type='hidden' name='dummy_locn_code' id='dummy_locn_code' value=''>		
	<input type='hidden' name='dummy_visit_dttime' id='dummy_visit_dttime' value=''>		
	<input type='hidden' name='episodeReqd' id='episodeReqd' value='S'>		 
	
	<input type='hidden' name='bl_enter_yn' id='bl_enter_yn' value='N'>	
	<input type='hidden' name='facilityid' id='facilityid' value='<%=facilityid%>'>	
	<input type='hidden' name='invitation_no' id='invitation_no' value='<%=invitation_no%>'>	
	<input type='hidden' name='room_no1' id='room_no1' value=''>	
	<input type='hidden' name='frame_ref' id='frame_ref' value="parent.frames[1].frames[3].">
	<input type=hidden name='locale' id='locale' value='<%=locale%>'> 
	<input type=hidden name='iSPractVisitLoad' id='iSPractVisitLoad' value='<%=iSPractVisitLoad%>'><!--added by munisekhar for MMS-QH-CRF-0167 [IN:044923] --> 
    <input type=hidden name='isAllowRegForSameService' id='isAllowRegForSameService' value='<%=isAllowRegForSameService%>'>    <!-- Added by mujafar for ML-MMOH-CRF-1437 -->
	<!-- Senthil Added for MMS-QH-CRF-0162.1 Linked incident Added for this incident [52415]-->
	<input type=hidden name='q_appt_time' id='q_appt_time' value='<%=q_appt_time%>'>
	<input type=hidden name='rec_no' id='rec_no' value='<%=rec_no%>'>
	<input type=hidden name='visit_for_inpat_yn' id='visit_for_inpat_yn' value='<%=visit_for_inpat_yn%>'> 
	<input type=hidden name='auth_win_reqd_yn' id='auth_win_reqd_yn' value='<%=auth_win_reqd_yn%>'>  
    <!--Added for this incident [52619] -->	
	<!--Below hidden field added for this incident [52854]-->
	<input type=hidden name="episode" id="episode" value="<%=episode%>">
	<input type=hidden name="record" id="record" value="<%=record%>">
	<!--End incident [52854] -->
	<input type=hidden name='from_head' id='from_head' value='<%=from_head%>'> 
	<input type=hidden name='locn_ind' id='locn_ind' value='<%=locn_ind%>'> 
	<input type=hidden name='waitlist_status' id='waitlist_status' value='<%=waitlist_status%>'> 
		

		<input type='hidden' name='p_hosp_main' id='p_hosp_main' value=''>
		<input type='hidden' name='p_hosp_sub' id='p_hosp_sub' value=''>
		<input type='hidden' name='p_card_id' id='p_card_id' value=''>
		<input type='hidden' name='p_expiry_date' id='p_expiry_date' value=''>
		<input type='hidden' name='p_privl_type_code' id='p_privl_type_code' value=''>	 
		<input type='hidden' name='p_all_services' id='p_all_services' value=''>

		<input type='hidden' name='bean_id' id='bean_id' value='<%=bean_id%>'>
		<input type='hidden' name='bean_name' id='bean_name' value='<%=bean_name%>'>
		<input type='hidden' name='multiple_orders_yn' id='multiple_orders_yn' value='N'>

		<input type='hidden' name='accept_dis_inv_no' id='accept_dis_inv_no' value='<%=accept_dis_inv_no%>'>
		<input type='hidden' name='visit_type_derv_rule' id='visit_type_derv_rule' value='<%=visit_type_derv_rule%>'>
		<input type='hidden' name='visit_back_yn' id='visit_back_yn' value='<%=visit_back_yn%>'>
		<input type='hidden' name='vst_type_ind' id='vst_type_ind' value=''><!--added for the CRF MMS-QH-CRF 41.1-->
		<input type='hidden' name='multi_speciality_yn' id='multi_speciality_yn' value='<%=multi_speciality_yn%>'><!--added for the CRF Bru-HIMS-CRF 0198-->

	    <!--  Below hidden added for this CRF Bru-HIMS-CRF-165.1 [IN:035659]-->
		<input type="hidden" name="appt_order" id="appt_order" value="<%=appt_order%>">
		<input type="hidden" name="order_count_select" id="order_count_select" value="<%=order_count_select%>">

		<!--  Below hidden added for this SCF - MMS-SCF-0082 [IN0 042800]-->
		<input type="hidden" name="blng_grp_id" id="blng_grp_id"  value="">
		<input type="hidden" name="cust_grp_code" id="cust_grp_code" value="">
		<input type="hidden" name="cust_code" id="cust_code" value="">
		<input type="hidden" name="policy_type_code" id="policy_type_code" value="">
		<input type="hidden" name="proceed_visit_regn" id="proceed_visit_regn" value=""><!--added for the MMS-SCF-0167 -->
		<input type="hidden" name="upt_contact_dtls_oa_yn" id="upt_contact_dtls_oa_yn" value="<%=upt_contact_dtls_oa_yn%>">
		<input type="hidden" name="downtimePatient" id="downtimePatient" value="<%=downtimePatient%>">

		<!--Added by Dharma on 3rd Feb 2016 for KDAH-CRF-0331 [IN058799] Start-->
		<input type = 'hidden' name = 'isForm60Available' value="<%=isForm60Available%>">  
		<!--Added by Dharma on 3rd Feb 2016 for KDAH-CRF-0331 [IN058799] End-->

		<input type='hidden' name='reg_date_time' id='reg_date_time' value="<%=reg_date_time%>"><!--Added by Dharma on May 25th 2016 against KAUH-SCF-0261 [IN:059835] -->
		
		<!-- START Added by Sangeetha for KDAH-CRF-0347-->
		<input type="hidden" name="validationForPanCardAvail" id="validationForPanCardAvail" value="<%=validationForPanCardAvail%>"> 
		<input type="hidden" name="form60_YN" id="form60_YN" value="">
		<!-- END KDAH-CRF-0347-->
		
		<input type="hidden" name="defFinDtls" id="defFinDtls" value="<%=defFinDtls%>">
		<input type='hidden' name='assign_care_locn_desc_prev' id='assign_care_locn_desc_prev' value="">
		<input type='hidden' name='apptrefno' id='apptrefno' value="<%=q_appt_ref_no%>" >
		
		
		<input type='hidden' name='isRoomMandatoryRegVisit' id='isRoomMandatoryRegVisit' value="<%=isRoomMandatoryRegVisit%>" > <!-- added by mujafar for NMC-JD-CRF-0025 -->
		
		  <script>
	 if(document.forms[0].assign_care_locn_code.length<=1)
      alert(getMessage('NO_CLINIC_ACCESS','OP'));
	  </script>
		<%
	 }//below IF condition is modified by Srinivas.Y for IN:35753
	  if(!q_appt_ref_no.equals("") || !referal_id.equals("")) { 
		 
		%>
		<script>
			if(document.getElementById("visit_adm_type")) { 
                var ispract=document.getElementById("isPractoApptYn");			
				if(document.getElementById("visit_type_derv_rule").value =="P"  && ispract.value =="N")
				  defaultVisitType();
				else if(document.getElementById("visit_type_derv_rule").value =="B")//Added for the SCF - MMS-SCF-0134
					populateVisitTypeForBillingInsurance('<%=q_visit_adm_type%>');
				else
					ChangeObj2(document.getElementById("visit_adm_type"),'<%=oa_install_yn%>');								
			}
		</script>
		<%
	 }
	}
}
catch(Exception e)
{
	e.printStackTrace();
	if(con!=null) {
		ConnectionManager.returnConnection(con,request);
	}
} finally {
	if(con!=null) {
		ConnectionManager.returnConnection(con,request);
	}
}

			%>

<%!
public StringBuffer getContactDetails(String from,String P_fromValue,String refer_id,String appt_ref_no,Connection con,String facility_id,String locale) throws Exception
{
	PreparedStatement		pstmt1		 = null ;
	ResultSet						resultSet  = null ;
	String sqlContact="";
	String fromValue=P_fromValue;
	String a_res_addr_line1 = "",a_res_addr_line2="",a_res_addr_line3="";
	String a_res_addr_line4 = "",a_country_code="",a_postal_code="";
	String a_res_area			= "",a_res_area_code="",a_res_town2_code="";
	String a_res_town2_desc = "",a_res_region_code="";
	String a_res_region_desc = "" ,m_res_addr_line1="",m_res_addr_line2="";
	String m_res_addr_line3 = "" ,m_res_addr_line4="",m_postal_code="";
	String m_country_code  = "",m_res_area_code="",m_res_area_desc="";
	String m_res_town2_code = "",m_res_town2_desc="",m_res_region_code="";
	String m_res_region_desc = "",strPrimaryResNo="",strOtherResNo="";
	String 	strEmail			= "",country1_desc="",country2_desc="",postal2_desc="",postaldesc1="";
	/*Added by Thamizh selvi on 25th Jan 2018 against ML-MMOH-CRF-0601 Start*/
	String alt_addr_line1 = "",alt_addr_line2="",alt_addr_line3="";
	String alt_addr_line4 = "",alt_country_code="", alt_country_desc="", alt_postal_code="";
	String alt_postal_desc = "", alt_area_desc	= "", alt_area_code="",alt_town_code="";
	String alt_town_desc = "",alt_region_code="", alt_region_desc = ""; 
	/*End*/
	StringBuffer contactAddress=new StringBuffer();
	if(!appt_ref_no.equals("")){
		sqlContact="SELECT res_addr_line1 addr1_line1, res_addr_line2 addr1_line2, res_addr_line3 addr1_line3, res_addr_line4 addr1_line4, res_town_code, (SELECT long_desc  FROM mp_res_town_lang_vw   WHERE language_id='"+locale+"' and res_town_code = a.res_town_code) res_town, res_area_code,       (SELECT long_desc          FROM mp_res_area_lang_vw    WHERE language_id='"+locale+"' and res_area_code = a.res_area_code) res_area,       res_region_code region_code,       (SELECT short_desc          FROM mp_region_lang_vw   WHERE language_id='"+locale+"' and  region_code = a.res_region_code) region,       country_code country1_code,(select long_desc from mp_country_lang_vw where language_id='"+locale+"' and  country_code=a.country_code) country1_desc, postal_code postal1_code,MP_GET_DESC.MP_POSTAL_CODE(postal_code,'"+locale+"','2')postaldesc1,       mail_addr_line1 addr2_line1, mail_addr_line2 addr2_line2,       mail_addr_line3 addr2_line3, mail_addr_line4 addr2_line4,       mail_town_code res_town2_code,       (SELECT short_desc          FROM mp_res_town_lang_vw     WHERE language_id='"+locale+"' and  res_town_code = a.mail_town_code) res_town2,       mail_area_code res_area2_code,       (SELECT short_desc          FROM mp_res_area_lang_vw          WHERE language_id='"+locale+"' and  res_area_code = a.mail_area_code) res_area2,       mail_region_code region2_code,       (SELECT short_desc          FROM mp_region_lang_vw   WHERE language_id='"+locale+"' and  region_code = a.mail_region_code) region2_desc, mail_country_code country2_code,(select short_name from mp_country_lang_vw  where language_id='"+locale+"' and  country_code=a.mail_country_code ) country2_desc, mail_postal_code postal2_code,MP_GET_DESC.MP_POSTAL_CODE(mail_postal_code,'"+locale+"','2')postal2_desc ,     res_tel_no CONTACT1_NO, oth_contact_no CONTACT2_NO, email_id, ALT_ADDR_LINE1, ALT_ADDR_LINE2, ALT_ADDR_LINE3 , ALT_ADDR_LINE4, ALT_TOWN_CODE, (SELECT long_desc FROM mp_res_town_lang_vw WHERE language_id = '"+locale+"' AND res_town_code = a.ALT_TOWN_CODE) ALT_TOWN_DESC, ALT_AREA_CODE, (SELECT long_desc FROM mp_res_area_lang_vw WHERE language_id = '"+locale+"' AND res_area_code = a.ALT_AREA_CODE) ALT_AREA_DESC, ALT_REGION_CODE, (SELECT short_desc FROM mp_region_lang_vw WHERE language_id = '"+locale+"' AND region_code = a.ALT_REGION_CODE) ALT_REGION_DESC, ALT_COUNTRY_CODE, (SELECT short_name FROM mp_country_lang_vw WHERE language_id = '"+locale+"' AND country_code = a.ALT_COUNTRY_CODE) ALT_COUNTRY_DESC, ALT_POSTAL_CODE, mp_get_desc.mp_postal_code (ALT_POSTAL_CODE, '"+locale+"', '2') ALT_POSTAL_DESC  FROM oa_appt a WHERE appt_ref_no=? and facility_id='"+facility_id+"'";//Modified by Thamizh selvi on 25th Jan 2018 against ML-MMOH-CRF-0601

		fromValue=appt_ref_no;
	} else if(!refer_id.equals("")) {		 
		sqlContact = "SELECT addr_line1 addr1_line1,addr_line2 addr1_line2,addr_line3 addr1_line3,addr_line4 addr1_line4,res_town_code,(SELECT long_desc  FROM mp_res_town_lang_vw WHERE language_id='"+locale+"' and res_town_code = a.res_town_code) res_town,res_area_code, (SELECT long_desc FROM mp_res_area_lang_vw       WHERE language_id='"+locale+"' and res_area_code = a.res_area_code) res_area,region_code,(SELECT short_desc FROM  mp_region_lang_vw WHERE language_id='"+locale+"' and region_code = a.region_code ) region,country_code country1_code,(select long_desc from mp_country_lang_vw where language_id='"+locale+"' and country_code=a.country_code) country1_desc,postal_code postal1_code, MP_GET_DESC.MP_POSTAL_CODE(postal_code,'"+locale+"','2') postaldesc1, mail_addr_line1 addr2_line1, mail_addr_line2 addr2_line2, mail_addr_line3 addr2_line3,mail_addr_line4 addr2_line4,mail_res_town_code res_town2_code, (SELECT short_desc FROM mp_res_town_lang_vw WHERE language_id='"+locale+"' and res_town_code = a.mail_res_town_code) res_town2,mail_res_area_code res_area2_code,(SELECT short_desc FROM mp_res_area_lang_vw WHERE language_id='"+locale+"' and res_area_code = a.mail_res_area_code) res_area2,mail_region_code region2_code,(SELECT short_desc          FROM mp_region_lang_vw WHERE language_id='"+locale+"' and  region_code = a.mail_region_code) region2_desc,mail_country_code country2_code,(select short_name from mp_country_lang_vw where language_id='"+locale+"' and country_code=a.mail_country_code) country2_desc,mail_postal_code postal2_code,MP_GET_DESC.MP_POSTAL_CODE(mail_postal_code,'"+locale+"','2')postal2_desc,contact1_no, contact2_no,email_id, ALT_ADDR_LINE1, ALT_ADDR_LINE2, ALT_ADDR_LINE3 , ALT_ADDR_LINE4, ALT_TOWN_CODE, (SELECT long_desc FROM mp_res_town_lang_vw WHERE language_id = '"+locale+"' AND res_town_code = a.ALT_TOWN_CODE) ALT_TOWN_DESC, ALT_AREA_CODE, (SELECT long_desc FROM mp_res_area_lang_vw WHERE language_id = '"+locale+"' AND res_area_code = a.ALT_AREA_CODE) ALT_AREA_DESC, ALT_REGION_CODE, (SELECT short_desc FROM mp_region_lang_vw WHERE language_id = '"+locale+"' AND region_code = a.ALT_REGION_CODE) ALT_REGION_DESC, ALT_COUNTRY_CODE, (SELECT short_name FROM mp_country_lang_vw WHERE language_id = '"+locale+"' AND country_code = a.ALT_COUNTRY_CODE) ALT_COUNTRY_DESC, ALT_POSTAL_CODE, mp_get_desc.mp_postal_code (ALT_POSTAL_CODE, '"+locale+"', '2') ALT_POSTAL_DESC FROM pr_referral_register a WHERE  referral_id = ? ";//Modified by Thamizh selvi on 25th Jan 2018 against ML-MMOH-CRF-0601
	
		fromValue=refer_id;
	}
	
try { 
		
		pstmt1 = con.prepareStatement(sqlContact) ;
		
		pstmt1.setString( 1, fromValue);
		resultSet = pstmt1.executeQuery() ;
	if(resultSet != null)
	{
		while(resultSet.next())
		{
			a_res_addr_line1 = resultSet.getString("addr1_line1");
			a_res_addr_line2 = resultSet.getString("addr1_line2");
			a_res_addr_line3 = resultSet.getString("addr1_line3");
			a_res_addr_line4 = resultSet.getString("addr1_line4");
			a_country_code  = resultSet.getString("country1_code");
			a_postal_code    = resultSet.getString("postal1_code");
			a_res_area_code = resultSet.getString("res_area_code");
			a_res_area = resultSet.getString("res_area");			
			a_res_town2_code = resultSet.getString("res_town_code");
			a_res_town2_desc = resultSet.getString("res_town");
			a_res_region_code = resultSet.getString("region_code");
			a_res_region_desc = resultSet.getString("region");			
			m_res_addr_line1 = resultSet.getString("addr2_line1");
			m_res_addr_line2 = resultSet.getString("addr2_line2");
			m_res_addr_line3 = resultSet.getString("addr2_line3");
			m_res_addr_line4 = resultSet.getString("addr2_line4");
			m_postal_code    = resultSet.getString("postal2_code");
			m_country_code  = resultSet.getString("country2_code");
			m_res_area_code = resultSet.getString("res_area2_code");
			m_res_area_desc = resultSet.getString("res_area2");
		    m_res_town2_code = resultSet.getString("res_town2_code");
		    m_res_town2_desc = resultSet.getString("res_town2");
		    m_res_region_code = resultSet.getString("region2_code");
		    m_res_region_desc = resultSet.getString("region2_desc");
		    strPrimaryResNo  = resultSet.getString("CONTACT1_NO");
			strOtherResNo    = resultSet.getString("CONTACT2_NO");
			strEmail	   = resultSet.getString("EMAIL_ID");	
			country1_desc	   = resultSet.getString("country1_desc");	
			country2_desc	   = resultSet.getString("country2_desc");	
		    postaldesc1= resultSet.getString("postaldesc1");	
			postal2_desc= resultSet.getString("postal2_desc");	
			
			/*Added by Thamizh selvi on 25th Jan 2018 against ML-MMOH-CRF-0601 Start*/
			alt_addr_line1 = checkForNull(resultSet.getString("alt_addr_line1"));
			alt_addr_line2 = checkForNull(resultSet.getString("ALT_ADDR_LINE2"));
			alt_addr_line3 = checkForNull(resultSet.getString("ALT_ADDR_LINE3"));
			alt_addr_line4 = checkForNull(resultSet.getString("ALT_ADDR_LINE4"));
			alt_country_code  = checkForNull(resultSet.getString("ALT_COUNTRY_CODE"));
			alt_country_desc  = checkForNull(resultSet.getString("ALT_COUNTRY_DESC"));
			alt_postal_code    = checkForNull(resultSet.getString("ALT_POSTAL_CODE"));
			alt_postal_desc    = checkForNull(resultSet.getString("ALT_POSTAL_DESC"));
			alt_area_code = checkForNull(resultSet.getString("ALT_AREA_CODE"));
			alt_area_desc = checkForNull(resultSet.getString("ALT_AREA_DESC"));			
			alt_town_code = checkForNull(resultSet.getString("ALT_TOWN_CODE"));
			alt_town_desc = checkForNull(resultSet.getString("ALT_TOWN_DESC"));
			alt_region_code = checkForNull(resultSet.getString("ALT_REGION_CODE"));
			alt_region_desc = checkForNull(resultSet.getString("ALT_REGION_DESC"));
			/*End*/

		
		}
	}
	if(resultSet != null) resultSet.close();
	if(pstmt1 != null) pstmt1.close();
	if(a_res_addr_line1 == null)a_res_addr_line1="";
			if(a_res_addr_line2 == null)a_res_addr_line2="";
			if(a_res_addr_line3 == null)a_res_addr_line3="";
			if(a_res_addr_line4 == null)a_res_addr_line4="";
			if(a_country_code == null)a_country_code="";
			if(a_postal_code == null)a_postal_code="";
			if(a_res_area_code == null)a_res_area_code="";
			if(a_res_area == null)a_res_area="";
			if(a_res_town2_code == null)a_res_town2_code="";
			if(a_res_town2_desc == null)a_res_town2_desc="";
			if(a_res_region_code == null)a_res_region_code="";
			if(a_res_region_desc == null)a_res_region_desc="";
			if(m_res_addr_line1 == null)m_res_addr_line1="";
			if(m_res_addr_line2 == null)m_res_addr_line2="";
			if(m_res_addr_line3 == null)m_res_addr_line3="";
			if(m_res_addr_line4 == null)m_res_addr_line4="";
			if(m_postal_code == null)m_postal_code="";
			if(m_country_code == null)m_country_code="";
			if(m_res_area_desc == null)m_res_area_desc="";
			if(m_res_town2_code == null)m_res_town2_code="";
			if(m_res_town2_desc == null)m_res_town2_desc="";
			if(m_res_region_code == null)m_res_region_code="";
			if(m_res_region_desc == null)m_res_region_desc="";
			if(strPrimaryResNo == null)strPrimaryResNo="";
			if(strOtherResNo == null)strOtherResNo="";
			if(strEmail == null)strEmail="";
			if(country1_desc == null)country1_desc="";
			if(country2_desc == null)country2_desc="";
			if(postaldesc1==null)postaldesc1="";
			if(postal2_desc==null)postal2_desc="";
		contactAddress.append(""+"^^");
		contactAddress.append(a_res_addr_line1+"^^");
		contactAddress.append(a_res_addr_line2+"^^");
		contactAddress.append(a_res_addr_line3+"^^");
		contactAddress.append(a_res_addr_line4+"^^");
		contactAddress.append(a_res_town2_code+"^^");
		contactAddress.append(a_res_area_code+"^^");
		contactAddress.append(a_postal_code+"^^");
		contactAddress.append(a_res_region_code+"^^");
		contactAddress.append(a_country_code+"^^");
		contactAddress.append(""+"^^");
		contactAddress.append(""+"^^");
		contactAddress.append(""+"^^");
		contactAddress.append(m_res_addr_line1+"^^");
		contactAddress.append(m_res_addr_line2+"^^");
		contactAddress.append(m_res_addr_line3+"^^");
		contactAddress.append(m_res_addr_line4+"^^");
		contactAddress.append(m_res_town2_code+"^^");
		contactAddress.append(m_res_area_code+"^^");
		contactAddress.append(m_postal_code+"^^");
		contactAddress.append(m_res_region_code+"^^");
		contactAddress.append(m_country_code+"^^");
		contactAddress.append(""+"^^");
		contactAddress.append(""+"^^");
		contactAddress.append(strPrimaryResNo+"^^");
		contactAddress.append(strOtherResNo+"^^");
		contactAddress.append(strEmail+"^^");
		contactAddress.append(""+"^^");
		contactAddress.append(a_res_town2_desc+"^^");
		contactAddress.append(a_res_area+"^^");
		contactAddress.append(a_res_region_desc+"^^");
		contactAddress.append(m_res_town2_desc+"^^");
		contactAddress.append(m_res_area_desc+"^^");
		contactAddress.append(m_res_region_desc+"^^");
		contactAddress.append(country1_desc+"^^");
		contactAddress.append(country2_desc+"^^");
		contactAddress.append(postaldesc1+"^^");
		contactAddress.append(postal2_desc);
		/*Added by Thamizh selvi on 25th Jan 2018 against ML-MMOH-CRF-0601 Start*/
		contactAddress.append(""+"^^");
		contactAddress.append(alt_addr_line1+"^^");
		contactAddress.append(alt_addr_line2+"^^");
		contactAddress.append(alt_addr_line3+"^^");
		contactAddress.append(alt_addr_line4+"^^");
		contactAddress.append(alt_town_code+"^^");
		contactAddress.append(alt_area_code+"^^");
		contactAddress.append(alt_postal_code+"^^");
		contactAddress.append(alt_region_code+"^^");
		contactAddress.append(alt_country_code+"^^");
		contactAddress.append(alt_town_desc+"^^");
		contactAddress.append(alt_area_desc+"^^");
		contactAddress.append(alt_postal_desc+"^^");
		contactAddress.append(alt_region_desc+"^^");
		contactAddress.append(alt_country_desc+"^^");
		/*End*/

	}catch ( Exception e ){            
            e.printStackTrace() ; }
        finally {      if(resultSet!=null)     resultSet.close();
                       if(pstmt1!=null) pstmt1.close();
                     //  ConnectionManager.returnConnection(con,request);
				 }
		return contactAddress;
}

%>


<%!
//String check_patient_id(javax.servlet.jsp.JspWriter out,String patient_id,String fac_id,Connection con,String visit_for_inpat_yn,String call_from,String locale)
/* Modified By Dharma for Non-Citizen Validation on 6th Jan 2014 */
//isNationalIdValidationAppl Added by Ashwini on 06-Mar-2019 for MO-CRF-20148
//Maheshwaran added -isNatIdAltIdMandVisaType for AAKH-CRF-0145 as on 22-04-2022
String check_patient_id(javax.servlet.jsp.JspWriter out,String patient_id,String fac_id,Connection con,String visit_for_inpat_yn,String call_from,String locale,String q_appt_ref_no,String referal_id,boolean isNationalIdValidationAppl,boolean isUHID_valid_appl,String bl_install_yn,boolean isNatIdOrAltIdMandVisaType,boolean isInvokeChngPatDtls,boolean isChkMPParamMandFlds,boolean isCountryRegionValAppl,boolean isNatIdAltIdMandVisaType)
{  
		String alt_status="";
		String continue_yn="Y";		
		char alert_yn='Y';
		String warning_text="";
		String valid_patient_id=patient_id;	
		String in_pat_status = "";
		String result_pr_enc_ref_man	= "Y";/* Added By Dharma for Non-Citizen Validation on 30th Dec 2013 Start*/
		PreparedStatement pstmt1=null;
		Statement stmt1    = null;
		ResultSet rs1    = null;
		
        try { 
                       
			webbeans.op.PatientData patdata = new  webbeans.op.PatientData();
			patdata.setFacility_id(fac_id);
			

			String pat_status = patdata.CheckStatus(con,patient_id);			
			
	        if (pat_status.equals("SUSPENDED")) {
                out.println("<script>alert(parent.frames[1].getMessage('PAT_SUSPENDED_NOT_ALLOWED','MP'));");
		        out.println("parent.parent.frames[0].document.getElementById('reset').click();</script>");
				alert_yn = 'N';  continue_yn = "N";	 	            
				valid_patient_id="";
	        } else if (pat_status.equals("DECEASED")) {
				out.println("<script>alert(parent.frames[1].getMessage('PAT_DECEASED_NOT_ALLOWED','MP'));");	out.println("parent.parent.frames[0].document.getElementById('reset').click();</script>");
				alert_yn = 'N';  continue_yn = "N";					
		        valid_patient_id="";		
	        } else if (pat_status.equals("SECURED")) {
       	        out.println("<script>alert(parent.frames[1].getMessage('SECURED_NOT_ALLOWED','COMMON'));");
    	        out.println("parent.parent.frames[0].document.getElementById('reset').click();</script>");
				alert_yn = 'N';  continue_yn = "N";
                valid_patient_id="";
	        } else if (pat_status.equals("INACTIVE")) {
		        out.println("<script>alert(parent.frames[1].getMessage('PAT_INACTIVE_NOT_ALLOWED','MP'));");
		        out.println("parent.parent.frames[0].document.getElementById('reset').click();</script>");
				alert_yn = 'N';  continue_yn = "N";
				valid_patient_id="";
         	} else if ( pat_status.equals("INVALID_PATIENT") || alt_status.equals("INVALID_PATIENT") )	{
				out.println("<script>alert(parent.frames[1].getMessage('INVALID_PATIENT','MP'));");
				out.println("parent.parent.frames[0].document.getElementById('reset').click();</script>");
				alert_yn = 'N';  continue_yn = "N";				  
				valid_patient_id="";
			} else if (pat_status.equals("BLACKLISTED_PATIENT")) {
				out.println("<script>alert(parent.frames[1].getMessage('BLACKLISTED_PATIENT','MP'));");
				out.println("parent.frames[1].document.forms[0].clear1.click();</script>");
				alert_yn = 'N';  continue_yn = "N";	  
				valid_patient_id="";
			} else if (pat_status.indexOf("PATIENT_MERGED_VALID")>=0 ) {
				StringTokenizer token=new StringTokenizer(pat_status,"$");
				valid_patient_id = token.nextToken(); 
				valid_patient_id = token.nextToken();
				
				alert_yn = 'N';  
				continue_yn = "N"; 		
				out.println("<script>var msg =parent.frames[1].getMessage('PATIENT_MERGED_VALID','MP')");
				out.println("msg = msg.replace('#','"+valid_patient_id+"');alert(msg);");
				out.println("parent.frames[1].document.forms[0].pat_id1.value='"+valid_patient_id+"';</script>"); 
				patient_id=valid_patient_id;
			} else if (pat_status != "") {
				warning_text=warning_text+pat_status+ "<br>";
			}
	        
	        /* Added By Dharma for Non-Citizen Validation on 30th Dec 2013 Start*/
		
		  	  if((!valid_patient_id.equals("") && referal_id.equals(""))){
		  		  
		  			  	if(pstmt1 != null) pstmt1.close();
		  				if(rs1  != null) rs1.close();
		  				String PrEncRefManSql =  "select  PR_ENC_REF_MAN(?,?,?,?) from dual";
		  				pstmt1 = con.prepareStatement(PrEncRefManSql);
		  				pstmt1.setString(1,fac_id);
		  				pstmt1.setString(2,valid_patient_id);
		  				pstmt1.setString(3,q_appt_ref_no);
		  				pstmt1.setString(4,"OP");
		  				rs1 = pstmt1.executeQuery();
		  			 try{
		  				 if(rs1!=null && rs1.next()){
		  					 result_pr_enc_ref_man	= rs1.getString(1);
		  				 }

		  				
		  				 if(result_pr_enc_ref_man.equals("N")){
		  					out.println("<script>alert(parent.frames[1].getMessage('PATIENT_IS_NOT_A_CITIZEN','COMMON'));</script>");
		  					out.println("<script>parent.parent.frames[0].document.getElementById('reset').click();</script>");
		  			 		 alert_yn	= 'N';
		  			 		valid_patient_id="";
							continue_yn = "N";
		  				 }
		  			  } catch(Exception e1) {
		  					e1.printStackTrace();
		  			  } finally{
		  				 if(pstmt1 != null) pstmt1.close();
		  				 if(rs1  != null) rs1.close();
		  				}
		  	
		  	  }
		  	  /* Added By Dharma for Non-Citizen Validation on 30th Dec 2013 End*/ 
	        
	    /*Added by Ashwini on 06-Mar-2019 for MO-CRF-20148*/
		if(isNationalIdValidationAppl && alert_yn != 'N')
		{
			JSONObject valJSONObj	= new JSONObject();
			valJSONObj				= eMP.MPCommonBean.getNationalIdValidationYN(con, patient_id, fac_id, "OP");
			String validate_yn		= (String)valJSONObj.get("validate_yn");
			String national_id		= (String)valJSONObj.get("national_id");
			String chk_citizen_yn	= (String)valJSONObj.get("citizen_yn");

			if(validate_yn.equals("Y") && national_id.equals("") && chk_citizen_yn.equals("Y"))
			{	
				out.println("<script>");
				out.println("alert(getMessage('VALIDATE_NATIONAL_ID','MP'))");
				out.println("parent.parent.frames[0].document.getElementById('reset').click();");
				out.println("</script>");
				alert_yn = 'N';  
				continue_yn = "N";
				valid_patient_id = "";
			}else
			{
				alert_yn = 'Y';
			}

			if(alert_yn == 'N')
			{
				alt_status = "";
				in_pat_status = "";
			}
		}
		/*End MO-CRF-20148*/
			
			// added by mujafar for AMRI-CRF-0357 START
			
			//if(isUHID_valid_appl && bl_install_yn.equals("Y") && alert_yn != 'N'  )
		if(isUHID_valid_appl && alert_yn != 'N'   )
		{
							String UHIDValidCount = "0";
							String UHIDValidCount_tmp = "";
							String pat_ser_grp_code = "";
					try{
							
							
						 UHIDValidCount_tmp	= eMP.MPCommonBean.getUHIDValidCount(con,patient_id,fac_id);
						 
						String arr_temp[] = UHIDValidCount_tmp.split("~~");
						UHIDValidCount = arr_temp[0];
						if(arr_temp.length>1)
							pat_ser_grp_code = arr_temp[1];
						
					
						
						if(UHIDValidCount.equals("0"))
						{
							 
					out.println("<script>");		 
					out.println("if(confirm(getMessage('UHID_EXPIRED','MP'))){	");
					out.println("var check = blUHIDBillchk('"+patient_id+"','VISIT_REGISTRATION','OP','"+pat_ser_grp_code+"');");
					out.println("if(check == 'Y'){");
					
					out.println("parent.parent.frames[1].frames[1].document.forms[0].srch_code.disabled=false;");
					out.println("parent.parent.frames[1].frames[1].document.forms[0].srch_code.click();");
					out.println("parent.parent.frames[1].frames[1].document.forms[0].srch_code.disabled=true;");
					out.println("}else{");
					alert_yn = 'N';  continue_yn = "N";
					valid_patient_id="";
					out.println("parent.parent.frames[0].document.getElementById('reset').click();");
					
					out.println("}");
					
					out.println("}else{");
					 alert_yn = 'N';  continue_yn = "N";
					valid_patient_id="";
					
					
					out.println("parent.parent.frames[0].document.getElementById('reset').click();");
					out.println("}");	 
					out.println("</script>");	
						}
						else
						{
							 
							
							 
						}
						
							}
							catch(Exception e1) {
										e1.printStackTrace();
								 } 
								 
								 
							
				
			if(alert_yn == 'N')
			{
					alt_status = "";
					in_pat_status="";
					
			}
			
		}
			
	        // added by mujafar for AMRI-CRF-0357 end
		/* isNatIdOrAltIdMandVisaType Added by Dharma on 25th Mar 2019 NMC-JD-CRF-0018 [IN:069750] Start*/
		JSONObject patDtlsObj	= new JSONObject();
			
			String natId					= "";
			String altId1					= "";
			String altId2					= "";
			String pat_dtls_unknown_yn		= "";
			String citizen_yn				= "";
			String visa_type				= "";
			String altId1Desc				= "";
			String altId2Desc				= "";
			String natIdPrompt				= "";
			String errMsg					= "";
			String showAlert				= "N";
			//Maheshwaran added -isNatIdAltIdMandVisaType for AAKH-CRF-0145 as on 22-04-2022
		if((isNatIdOrAltIdMandVisaType || isNatIdAltIdMandVisaType || isInvokeChngPatDtls) && alert_yn != 'N'){
			patDtlsObj						= eMP.MPCommonBean.chkNatIDAltIDAvail(con, patient_id,locale);
			natId					= (String)patDtlsObj.get("national_id_no");
			altId1					= (String)patDtlsObj.get("alt_id1_no");
			altId2					= (String)patDtlsObj.get("alt_id2_no");
			pat_dtls_unknown_yn		= (String)patDtlsObj.get("pat_dtls_unknown_yn");
			citizen_yn				= (String)patDtlsObj.get("citizen_yn");
			visa_type				= (String)patDtlsObj.get("visa_type"); //Maheshwaran added  for AAKH-CRF-0145 as on 22-04-2022
			altId1Desc				= (String)patDtlsObj.get("alt_id1_type_desc");
			altId2Desc				= (String)patDtlsObj.get("alt_id2_type_desc");
			natIdPrompt				= (String)patDtlsObj.get("nat_id_prompt");
			showAlert				= (String)patDtlsObj.get("showAlert");
			//Maheshwaran added  for AAKH-CRF-0145 as on 22-04-2022
			if(visa_type.equals(""))
			visa_type="W";
		}
		if(isNatIdOrAltIdMandVisaType && alert_yn != 'N'){
			if(pat_dtls_unknown_yn.equals("N") && showAlert.equals("Y")){
				if(citizen_yn.equals("Y") && natId.equals("")){
					errMsg	= natIdPrompt;
				}else if(citizen_yn.equals("N") && altId1.equals("") && altId2.equals("") ){
					errMsg	= altId1Desc+"/"+altId2Desc;
				}
				/*if(!errMsg.equals("")){
					out.println("<script>");
					out.println("var message=getMessage('NATID_ALTID_NOT_AVAILABLE','MP'); alert(message.replace('#','"+errMsg+"'));");
					out.println("parent.parent.frames[0].document.getElementById('reset').click();");
					out.println("</script>");
					alert_yn	= 'N';
					continue_yn = "N";
				}else{
					alert_yn = 'Y';
				}
				if(alert_yn == 'N') {
					alt_status = "";
					in_pat_status = "";
				}*/
			}
		}
		/*Added by Dharma on 25th Mar 2019 NMC-JD-CRF-0018 [IN:069750] End*/
/*Added By Dharma on 14th May 2020 against KDAH-CRF-0522.1 Start*/
	String strMPParamMandFlds	= "";
	if(isChkMPParamMandFlds && alert_yn != 'N'){
		strMPParamMandFlds = eMP.MPCommonBean.chkMPMandFieldsForEncCreation(con, patient_id,locale);
		if(!strMPParamMandFlds.equals("Y")){
			errMsg	= strMPParamMandFlds;
		}
	}
	if((isNatIdOrAltIdMandVisaType || isChkMPParamMandFlds) && alert_yn != 'N' && !errMsg.equals("")){
		if(!errMsg.equals("")){
			out.println("<script>");
			out.println("var message=getMessage('NATID_ALTID_NOT_AVAILABLE','MP'); alert(message.replace('#','"+errMsg+"'));");
			out.println("parent.parent.frames[0].document.getElementById('reset').click();");
			out.println("</script>");
			alert_yn	= 'N';
			continue_yn = "N";
		}else{
			alert_yn = 'Y';
		}
		if(alert_yn == 'N') {
			alt_status = "";
			in_pat_status = "";
		}
	}
	/*Added By Dharma on 14th May 2020 against KDAH-CRF-0522.1 End*/
 /*Added by Dharma on 24th Apr against MMS-DM-CRF-0152.1 [IN:070226] Start*/ 
 	//Maheshwaran added -isNatIdAltIdMandVisaType for AAKH-CRF-0145 as on 22-04-2022
		if((isInvokeChngPatDtls || isNatIdAltIdMandVisaType ) && alert_yn != 'N'){
				if(pat_dtls_unknown_yn.equals("N")  && showAlert.equals("Y") ){
					if(isInvokeChngPatDtls)
						{
						if(citizen_yn.equals("Y") && natId.equals("")){
						errMsg	= natIdPrompt;
						}else if(citizen_yn.equals("N") && altId1.equals("")  ){
						errMsg	= altId1Desc;
						}
						}
					//Maheshwaran added -isNatIdAltIdMandVisaType for AAKH-CRF-0145 as on 22-04-2022	
					if(isNatIdAltIdMandVisaType)
						{
						if(citizen_yn.equals("Y") && natId.equals("")){
							errMsg	= natIdPrompt;
							}	
							else if(citizen_yn.equals("N") && (visa_type.equals("W")) && natId.equals("") ){
							errMsg	= natIdPrompt;
							}
							else if(citizen_yn.equals("N") && (visa_type.equals("V")) && altId1.equals("") && !altId2.equals("") ){
							errMsg	= altId1Desc;	
							}
							else if(citizen_yn.equals("N") && (visa_type.equals("V")) && !altId1.equals("") && altId2.equals("")){
							errMsg	= altId2Desc;	
							}
							else if(citizen_yn.equals("N") && (visa_type.equals("V")) && altId1.equals("") && altId2.equals("")){
							errMsg	= altId1Desc+"/"+altId2Desc;	
							}								
						}
					if(!errMsg.equals("")){
					out.println("<script>");
						out.println("async function alt (){var message= getMessage('NATID_ALTID_NOT_AVAILABLE_UPDATE','MP'); message = message.replace('#','"+errMsg+"');");
						out.println("if(confirm(message)){");
						out.println("var dialogTop   = '40px'");
						out.println("var dialogHeight    = '400px'") ; 
						out.println("var dialogWidth = '700px'") ;
						out.println("var features  = 'dialogTop:' + dialogTop + '; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';status=no; scroll=no'");
						out.println("var arguments = '' ");
						out.println("var retVal = '';");
						out.println("var url='../../eMP/jsp/ChangePatientDetails.jsp?step=1&menu_id=MP&called_from_newborn=N&module_id=MP&function_id=CHG_PAT_DTLS&function_name=Change Patient Details&function_type=F&home_required_yn=N&access=NYNNN&Patient_ID="+patient_id+"';");
						out.println("retVal = await window.showModalDialog(url,arguments,features);");
						out.println("if(retVal){");
						out.println("if( retVal != null || retVal.length != 0)");
						out.println("parent.close();");
						out.println("parent.parent.frames[1].frames[1].document.forms[0].srch_code.disabled=false;"); 
						out.println("parent.parent.frames[1].frames[1].document.forms[0].srch_code.click();");
						out.println("parent.parent.frames[1].frames[1].document.forms[0].srch_code.disabled=true;");

						out.println("}else{");
						out.println("parent.parent.frames[0].document.getElementById('reset').click();");
						out.println("}");
						out.println("}else{");
						out.println("parent.parent.frames[0].document.getElementById('reset').click();");
						out.println("}}");
					out.println("</script>");
					alert_yn	= 'N';
					continue_yn = "N";
					}else{
						alert_yn = 'Y';
					}
					
					if(alert_yn == 'N') {
						alt_status = "";
						in_pat_status = "";
					}
				}
		}
	    /*Added by Dharma on 24th Apr against MMS-DM-CRF-0152.1 [IN:070226] End*/   
			
		/*Added by Ashwini on 02-Feb-2021 for AAKH-CRF-0128.1*/
		if(isCountryRegionValAppl && alert_yn != 'N'){

			JSONObject SMSiteJSONObj = new JSONObject();
			SMSiteJSONObj = eSM.SMCommonBean.getSMSiteParamDetails(con);
			String region_prompt = (String)SMSiteJSONObj.get("region_prompt");

			JSONObject MPParamJSONObj = new JSONObject();
			MPParamJSONObj = eMP.MPCommonBean.getMPAuditTrailDetails(con);
			String country_reqd_yn = (String)MPParamJSONObj.get("country_reqd_yn");
			String region_reqd_yn = (String)MPParamJSONObj.get("region_reqd_yn");

			JSONObject PatAddrJSONObj = new JSONObject();
			PatAddrJSONObj = eMP.MPCommonBean.getMPPatContactDetails(con,patient_id);
			String country_code = (String)PatAddrJSONObj.get("country_code");	
			String region_code = (String)PatAddrJSONObj.get("region_code");

			String dispMsg = "";

			if(country_code.equals("") || region_code.equals(""))
			{
				if(country_reqd_yn.equals("Y") && region_reqd_yn.equals("N") && country_code.equals(""))
				{
					dispMsg = "Y";
					out.println("<script>");
					out.println("var message = getMessage('MAND_VALIDATION_TRANS','MP'); message = message.replace('#',getLabel('Common.country.label','Common'));");
					out.println("</script>");
				}
				else if(country_reqd_yn.equals("N") && region_reqd_yn.equals("Y") && region_code.equals(""))
				{
					dispMsg = "Y";
					out.println("<script>");
					out.println("var message = getMessage('MAND_VALIDATION_TRANS','MP'); message = message.replace('#','"+region_prompt+"');");
					out.println("</script>");
				}
				else if(country_reqd_yn.equals("Y") && region_reqd_yn.equals("Y"))
				{
					if(country_code.equals("") && region_code.equals(""))
					{
						dispMsg = "Y";
						out.println("<script>");
						out.println("var cr_prompt = getLabel('Common.country.label','Common')+' '+getLabel('Common.and.label','Common')+' '+'"+region_prompt+"';");
						out.println("var message = getMessage('MAND_VALIDATION_TRANS','MP'); message = message.replace('#',cr_prompt);");
						out.println("</script>");
					}
					else if(country_code.equals("") && !region_code.equals(""))
					{
						dispMsg = "Y";
						out.println("<script>");
						out.println("var message = getMessage('MAND_VALIDATION_TRANS','MP'); message = message.replace('#',getLabel('Common.country.label','Common'));");
						out.println("</script>");
					}
					else if(!country_code.equals("") && region_code.equals(""))
					{
						dispMsg = "Y";
						out.println("<script>");
						out.println("var message = getMessage('MAND_VALIDATION_TRANS','MP'); message = message.replace('#','"+region_prompt+"');");
						out.println("</script>");
					}
				}else
				{
					dispMsg = "";
				}
			}
			
			if(!dispMsg.equals("")){
					out.println("<script>");
					out.println("if(confirm(message)){");
					out.println("var dialogTop   = '65'");
					out.println("var dialogHeight    = '44'") ; 
					out.println("var dialogWidth = '65'") ;
					out.println("var features  = 'dialogTop:' + dialogTop + '; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';status=no; scroll=no'");
					out.println("var arguments = '' ");
					out.println("var retVal = '';");
					out.println("var url='../../eMP/jsp/ChangePatientDetails.jsp?step=1&menu_id=MP&called_from_newborn=N&module_id=MP&function_id=CHG_PAT_DTLS&function_name=Change Patient Details&function_type=F&home_required_yn=N&access=NYNNN&load_tab=CONTACT_ADDR_TAB&Patient_ID="+patient_id+"';");
					out.println("retVal = window.showModalDialog(url,arguments,features);");
					out.println("if(retVal){");
					out.println("if( retVal != null || retVal.length != 0)");
					out.println("parent.close();");
					out.println("parent.parent.frames[1].frames[1].document.forms[0].srch_code.disabled=false;"); 
					out.println("parent.parent.frames[1].frames[1].document.forms[0].srch_code.click();");
					out.println("parent.parent.frames[1].frames[1].document.forms[0].srch_code.disabled=true;");

					out.println("}else{");
					out.println("parent.parent.frames[0].document.getElementById('reset').click();");
					out.println("}");
					out.println("}else{");
					out.println("parent.parent.frames[0].document.getElementById('reset').click();");
					out.println("}");
					out.println("</script>");
				alert_yn	= 'N';
				continue_yn = "N";
				}else{
					alert_yn = 'Y';
				}
				
				if(alert_yn == 'N') {
					alt_status = "";
					in_pat_status = "";
				}
		}
		/*End AAKH-CRF-0128.1*/

			if(alert_yn != 'N')
			{
				in_pat_status = patdata.CheckInPatient(con,patient_id,fac_id);
				alt_status = patdata.CheckAlternateId(con,patient_id,locale);
				  
				if(in_pat_status.equals("CURRENTLY_IN_PATIENT")) {
					if(visit_for_inpat_yn.equals("Y")){	
						out.println("<script>alert(parent.frames[1].getMessage('CURRENTLY_IN_PATIENT','COMMON'));</script>");
					} else {						
						out.println("<script>alert(parent.frames[1].getMessage('VIS_REGN_NOT_ALLOWED_FOR_CURR_INPAT','OP'));");		
						if(!call_from.equals("CA")){
							out.println("parent.parent.frames[0].document.getElementById('reset').click();</script>");
						}else{
							out.println("window.close();</script>");
						}
						alert_yn = 'N';  continue_yn = "N";
						valid_patient_id="";
					}
				}
				out.println("<script>setTimeout('PatVisHid(4)',200);</script>");// added by munisekhar for MMS-QH-CRF-0162
				
			} 	
		
		    if(!alt_status.equals("")) {
				
				char val=alt_status.charAt(0);
				if(val == 'W') {
					String val1=alt_status.substring(2,alt_status.length());
					out.println("<script>contyn = confirm(\""+val1+"\");  if(!contyn) setValue();</script>"); 
				} else if(val =='C') {			
					String val1=alt_status.substring(1,alt_status.length());
					out.println("<script>alert(\""+val1+"\");setValue();</script>");					
				} else {
					String val1=alt_status.substring(2,alt_status.length());
					out.println("<script>alert(\""+val1+"\");</script>");
				}
			}
	 
	
		} catch (Exception ce){
			try{out.println("check_patient_id:"+ce);}catch(Exception e){e.printStackTrace();}
		}	
	
		return continue_yn;  
}

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
async function getPatientQueue(clinic_code)
		{ 
		    var dialogHeight = "35" ;
			var dialogWidth	= "45" ;
			var dialogTop = "160" ;
			var center = "1" ;
			var status="no";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
			var arguments	= "" ; 
			await window.showModalDialog("../../eOP/jsp/PatientQueueFrames.jsp?clinic_code="+clinic_code,arguments,features);
			
		}

		var alternate_id_cont_yn = "Y";
		function setValue()	{
			alternate_id_cont_yn = "N";
			parent.frames[1].document.forms[0].clear1.click();
		}
		<!--Below line Added for this CRF  Bru-HIMS-CRF-165.1 [IN:035659] -->
		
			if('<%=order_count_select%>'>0)
			{
			var ordercatbutt=document.forms[0].order_cat_butt;
			var ordercattxt=document.forms[0].order_cat_txt;
			//SelectOrderCatalogSearch(document.forms[0].order_cat_butt,document.forms[0].order_cat_txt);	
			setTimeout("SelectOrderCatalogSearch('"+ordercatbutt+"','"+ordercattxt+"');",1000); //this line added for this incident[IN43474]
		}
		<!--End Bru-HIMS-CRF-165.1 [IN:035659] -->
	</script>
	<!-- Added for JD-CRF-0183 [IN:041353] By Dharma on 25th Nov 2013 Start-->
	<input type="hidden" name="is_prac_blocked" id='is_prac_blocked' value="">
	<input type="hidden" name="action_on_pract_schedule" id='action_on_pract_schedule' value="<%=action_on_pract_schedule%>">
	<!-- Added for JD-CRF-0183 [IN:041353] By Dharma on 25th Nov 2013 End-->	
	<!--Below line added for this CRF GDOH-CRF-0129-->
	<input type="hidden" name="assigncare_loctype_ind" id="assigncare_loctype_ind" value="<%=assigncareloctype%>">
	<input type="hidden" name="assigncare_locacode" id="assigncare_locacode" value="<%=assigncare_location_code%>">
	<input type="hidden" name="isReferral" id="isReferral" value="<%=isReferral%>"> 
	<!--End GDOH-CRF-0129-->
	 <input type='hidden' name='isAlternateAddressAppl' id='isAlternateAddressAppl' value="<%=isAlternateAddressAppl%>"><!--Added by Thamizh selvi on 25th Jan 2018 against ML-MMOH-CRF-0601-->
	 <!--Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->
	 <input type='hidden' name='others_id' id='others_id' value='<%=others_id%>'>
	 <!--Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187-->
	 <input type='hidden' name='isImproveReferralProcessAppl' id='isImproveReferralProcessAppl' value='<%=isImproveReferralProcessAppl%>'>
	 <input type='hidden' name='referral_clicked_yn' id='referral_clicked_yn' value='N'>
	 
	 <!--Added by Ashwini on 23-Sep-2022 for TH-KW-CRF-0020.1-->
	 <input type='hidden' name='isQMSInOPVisitRegAppl' id='isQMSInOPVisitRegAppl' value='<%=isQMSInOPVisitRegAppl%>'>
	 <input type='hidden' name='patient_name' id='patient_name' value='<%=patient_name%>'>
	 <input type='hidden' name='visit_date' id='visit_date' value='<%=vst_regn_date%>'>
	 <input type='hidden' name='common_queue_status' id='common_queue_status' value=''>
	 <input type='hidden' name='common_queue_status_msg' id='common_queue_status_msg' value=''>
	 <input type='hidden' name='common_queue_id' id='common_queue_id' value=''>
	 <input type='hidden' name='common_queue_no' id='common_queue_no' value=''>
	 <input type='hidden' name='common_queue_issue_dt_tm' id='common_queue_issue_dt_tm' value=''>
	 <input type='hidden' name='common_queue_called_dt_tm' id='common_queue_called_dt_tm' value=''>
	 <input type='hidden' name='virtual_queue_status' id='virtual_queue_status' value=''>
	 <input type='hidden' name='virtual_queue_status_msg' id='virtual_queue_status_msg' value=''>
	 <input type='hidden' name='virtual_queue_id' id='virtual_queue_id' value=''>
	 <input type='hidden' name='virtual_queue_no' id='virtual_queue_no' value=''>
	 <input type='hidden' name='virtual_queue_issue_dt_tm' id='virtual_queue_issue_dt_tm' value=''>
	 <input type='hidden' name='virtual_queue_called_dt_tm' id='virtual_queue_called_dt_tm' value=''>
	 
	 <!--Added by Santhosh for MMS-DM-CRF-0209.4-US005-->
	 <input type='hidden' name='category' id='category' value=''>
	 <input type='hidden' name='isClinicCategory' id='isClinicCategory' value='<%=isClinicCategory%>'>
	 <input type='hidden' name='firstVisitList' id='firstVisitList' value='<%=firstVisitList%>'>
	 <input type='hidden' name='followUpVisitList' id='followUpVisitList' value='<%=followUpVisitList%>'>
	 <input type='hidden' name='isReferalId' id='isReferalId' value='<%=isReferalId%>'>
	 <input type='hidden' name='referral_req_yn' id='referral_req_yn' value='<%=referral_req_yn%>'>
	 
	 <!-- added by Lakshmanan for ML-MMOH-CRF-1930 US008 -->
	 <input type='hidden' name='virtualConsultEnable' id='virtualConsultEnable' value='<%=virtualConsultEnable%>'>
	 <input type='hidden' name='isVirtualConsultationVisit' id='isVirtualConsultationVisit' value='<%=isVirtualConsultationVisit%>'>

	 

</form>
</body>
</html>

<% // The below condition serviceCount is newly added for CRF PMG20089-CRF-0855 [IN:024101] by Suresh M on 30.11.2010.
	if((!q_appt_ref_no.equals("") || !to_ser_code.equals("") || serviceCount == 1) && !visit_type_derv_rule.equals("P") ) {
		//out.println("<script>setTimeout('popSubservice(document.forms[0].service_code)',1500);</script>");
		out.println("<script>if(document.forms[0])popSubservice(document.forms[0].service_code);</script>");
	}	
%>

