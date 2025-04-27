<!DOCTYPE html>

<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
12/08/2011    IN027165       Chowminya   Incident No: IN027165 - <Future order linked orders reschedule - started date update issue> 										 
---------------------------------------------------------------------------------------------------------------
-->

  <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
  
<% 
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>



<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,java.text.*, java.net.*,webbeans.eCommon.*,java.util.*,com.ehis.util.*,eCommon.XSSRequestWrapper" %>
<jsp:useBean id="patInstructionsMap" class="java.util.HashMap" scope="session"/>   
<jsp:useBean id="prcInstructionMap" class="java.util.HashMap" scope="session"/>
<html>  
<title><fmt:message key="Common.AppointmentDetails.label" bundle="${common_labels}"/></title>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
	<script src='../../eOA/js/AppointmentDetails.js' language='javascript'></script>
	<script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<% 


patInstructionsMap.clear();
prcInstructionMap.clear();
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String patInsSelectYN="";
String procInsSelectYN="";
long transfer_schedule_total_time_interval=0;
//double t_t_sche=0;
String flag=request.getParameter("flag");
if(flag == null || flag.equals("undefined")) flag="";

webbeans.op.PatientData patdata = new webbeans.op.PatientData();
String order_catalog_code="";
String rd_appt_yn="";
String group_id="";
String pat_alcn_catg_code="";
String pre_alcn_catg_code="";
String pre_alcn_criteria="";
String pre_pat_alcn_catg_code="";
String team_short_desc="";
String contactvals="";
String nationality="";
String pre_cat_grp_desc="";
String receiving_date_time_display="";
String service_code="";
String SPECIALITY_CODE="";
//String facilityid=(String)session.getValue("facility_id");
String locale=(String)session.getAttribute("LOCALE");
String clinicInsYN="N";
String orderInsYN="N";
//String orderInsStandardYN="N";

//added forBru-HIMS-CRF-380 Start
String facilityid	= request.getParameter("facility_id") ;
if(facilityid==null)
	facilityid = (String) session.getValue("facility_id");
//added forBru-HIMS-CRF-380 End



//String bl_operational= (String)session.getValue("bl_operational");
String t_from_time_arry[]=new String[2];
//String t_to_time_arry[]=new String[2];
int t_from_hour=0;
int t_from_sec=0;

Statement stmt=null;
Statement stmt1=null;
Statement stmt2=null;
Statement stmt3=null;
Statement stmt4=null;
Statement stmtgrp=null;
Statement stmt_reason=null;
PreparedStatement pstmt_pat =	null;
PreparedStatement pstmt =	null;
ResultSet Rset_Nat_Id=null;
ResultSet rs=null;
ResultSet rs1=null;
ResultSet rs2=null;
ResultSet rs3=null;
ResultSet rs4=null;
ResultSet rs_pat=null;
ResultSet rs_reason=null;
ResultSet rsgrp=null;
ResultSet rs_next=null;

Connection conn = null;
Statement stmtsd=null;
Statement stmt_next=null;
ResultSet rssd=null;
String referral_line="";
String referral_line1="";
//String to_clinic_alcYN="";
String frm_clinic_code="";
String starttime="";
String endtime="";

//String pat_alcn_catg_desc ="";
String call_function_ip =request.getParameter("call_function_ip");
if(call_function_ip==null) call_function_ip="";
String book_appt_yn = request.getParameter("book_appt_yn");
if (book_appt_yn==null) book_appt_yn="";
String book_appt_wo_pid_yn = request.getParameter("book_appt_wo_pid_yn");
if (book_appt_wo_pid_yn==null) book_appt_wo_pid_yn="";
String obook_appt_yn = request.getParameter("obook_appt_yn");
if (obook_appt_yn==null) obook_appt_yn="";
String book_appt_across_catg_yn = request.getParameter("book_appt_across_catg_yn");
if (book_appt_across_catg_yn==null) book_appt_across_catg_yn="";
String tfr_appt_yn = request.getParameter("tfr_appt_yn");
if (tfr_appt_yn==null) tfr_appt_yn="";
String tfr_appt_across_catg_yn = request.getParameter("tfr_appt_across_catg_yn");
if (tfr_appt_across_catg_yn==null) tfr_appt_across_catg_yn="";
String canc_appt_yn = request.getParameter("canc_appt_yn");
if (canc_appt_yn==null) canc_appt_yn="";
String alcn_criteria = request.getParameter("alcn_criteria");
if (alcn_criteria==null) alcn_criteria="";
String alcn_catg_code= request.getParameter("pre_pat_alcn_catg_code");
String Forced=request.getParameter("Forced");
if(Forced==null || Forced.equals("null"))
		Forced="N";

String performing_facility_id=request.getParameter("performing_facility_id");
String calling_mode=request.getParameter("calling_mode");
if(calling_mode==null) calling_mode="";
StringBuffer contactAddress=new StringBuffer();


if (alcn_catg_code==null) alcn_catg_code="";
if (performing_facility_id==null) performing_facility_id="";
if (!performing_facility_id.equals("")){
	facilityid=performing_facility_id;
}
	
try{
conn = ConnectionManager.getConnection(request);

/*Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114*/
HashMap hashdata	= eCommon.Common.CommonBean.getSiteSpecificDetails(conn, "OA","REMARKS_FOR_OTHERS");
String others_id	= (String)hashdata.get("value1");
if(others_id == null) others_id = "";
/*End ML-MMOH-CRF-1114*/

String clinic_code="";
String practitioner_id="";
String over_readonly="";
String to_over_book_yn=request.getParameter("to_over_book_yn");
if(to_over_book_yn == null || to_over_book_yn.equals("")) to_over_book_yn="N";
if(to_over_book_yn.equals("Y"))
	over_readonly="readOnly";
else
	over_readonly="";
clinic_code=request.getParameter("i_clinic_code");
practitioner_id=request.getParameter("i_practitioner_id");
String apptrefno=request.getParameter("i_appt_ref_no");
if(apptrefno == null || apptrefno.equals("undefined")) apptrefno="";
String disp_fromtime="";
String disp_totime="";
String transfer=request.getParameter("transfer");
if(transfer == null) transfer="";
String i_from_time=request.getParameter("i_from_time");
if(i_from_time == null) i_from_time="";
String i_to_time=request.getParameter("i_to_time");
if(i_to_time == null) i_to_time="";

//Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112
if(i_to_time.equals("00:00")){
	i_to_time = "23:59";
}

String order_line_num = "";
String order_id1=request.getParameter("order_id");
if(order_id1 == null) order_id1=""; //--[IN027165]--
String value13=request.getParameter("value13");
if(value13 == null) value13="";
String i_appt_date=request.getParameter("i_appt_date");
if(i_appt_date ==null ) i_appt_date="";
String over_booked=request.getParameter("over_booked");
if(over_booked == null) over_booked="";

String i_time_table_type=request.getParameter("i_time_table_type");
if(i_time_table_type == null) i_time_table_type="";
String old_date=(String)request.getParameter("old_date");
if(old_date  == null || old_date.equals("null")) old_date="";
if(apptrefno.equals("hjjh")) { apptrefno=value13; }
String old_from_time = (String)request.getParameter("old_from_time");

if( old_from_time == null) old_from_time="";
String old_to_time = request.getParameter("old_to_time");

if( old_to_time == null) old_to_time="";

String clinic_type=request.getParameter("clinic_type");

String res_type=request.getParameter("res_type");
if (clinic_type==null) clinic_type = "C";
if (res_type==null) res_type = "P";

String care_locn_ind_desc="";
if(clinic_type.equals("C")){
	care_locn_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
}else if(clinic_type.equals("E")){
	care_locn_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");
}else if(clinic_type.equals("D")){
	care_locn_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels");
}

String res_class_desc="";
String resource_class="";
String new_resource_class="";
String new_res_class_desc="";
int xsec_res=0;
/*Above Line commented for this incident [35078]*/
// Added for this incident ML-BRU-SCF-1602 [IN:055253]
if(res_type.equals("P")){
	new_res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
}else if(res_type.equals("E")){
	new_res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
}else if(res_type.equals("R")){
	new_res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
}else if(res_type.equals("O")){
	new_res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
}else if(res_type.equals("B")){
	new_res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Bed.label","common_labels");
}
// Added for this incident ML-BRU-SCF-1602 [IN:055253]

String function_mode=request.getParameter("function_mode");
if(function_mode ==null) function_mode="";

if(!function_mode.equals("")&&function_mode.equals("transfer"))new_resource_class=res_type;


String sec_resources="";
String title = request.getParameter("title")==null?"Cancellation":request.getParameter("title");
String apptrefno1="";
String clinicshortdesc="";
String practitionerid="";
String practname="";
String apptdate="";
String appttime="";
String apptslabfmtime="";
String apptslabtotime="";
String apptduration="";
String patientid="";
String prefix="";
String firstname="";
String secondname="";
String thirdname="";
String familyname="";
String suffix="";
String patientname="";
String gender="";
String genderdesc="";
String dateofbirth="";
String agey="";
String agem="";
String aged="";
String restelno="";
String othtelno="";
String emailid="";
String nationalid="";
String nat_id_prompt="";
String alternateid="";
String resaddrl1="";
String resaddrl2="";
String resaddrl3="";
String resaddrl4="";
String postalcode="";
String countrycode="";
String appttypecode="";
String overbookedyn="";
String referralcode="";
String mode="";
String modedesc="";
String reasoncode="";
String reasondesc="";
String apptremarks="";
String apptstatus="";
String visitshortdesc="";
String visitind="";
String referral_id="";
String user_name="";
String record_date="";
String team_id="";
String ETHNIC_GROUP_DESC="";
String RACE_DESC="";
String CITIZEN_YN="";
String LEGAL_YN="";
String BIRTH_PLACE_DESC="";
String receiving_date_time="";
String RES_AREA_CODE="";
String RES_AREA_DESC="";
String RES_TOWN_CODE="";
String RES_TOWN_DESC="";
String RES_REGION_CODE="";
String RES_REGION_DESC="";
String RES_COUNTRY_CODE="";
String RES_COUNTRY_NAME="";
String MAIL_ADDR_LINE1="";
String MAIL_ADDR_LINE2="";
String MAIL_ADDR_LINE3="";
String MAIL_ADDR_LINE4="";
String MAIL_AREA_CODE="";
String MAIL_AREA_DESC="";
String MAIL_TOWN_CODE="";
String MAIL_TOWN_DESC="";
String MAIL_REGION_CODE="";
String MAIL_REGION_DESC="";
String MAIL_POSTAL_CODE="";
String MAIL_COUNTRY_CODE="";
String MAIL_COUNTRY_NAME="";
String ALCN_CRITERIA_YN="";
String ALT_ID1_TYPE="";
String ALT_ID1_NO="";
String ALT_ID1_EXP_DATE="";
String ALT_ID2_TYPE="";
String ALT_ID2_NO="";
String ALT_ID2_EXP_DATE="";
String ALT_ID3_TYPE="";
String ALT_ID3_NO="";
String ALT_ID3_EXP_DATE="";
String ALT_ID4_TYPE="";
String ALT_ID4_NO="";
String ALT_ID4_EXP_DATE="";
String ALT_ID1_EXP_DATE_display="";
String ALT_ID2_EXP_DATE_display="";
String ALT_ID3_EXP_DATE_display="";
String ALT_ID4_EXP_DATE_display="";
String OTH_ALT_ID_TYPE="";
String OTH_ALT_ID_NO="";
String ALT_ID1_Desc="";
String ALT_ID2_Desc="";
String ALT_ID3_Desc="";
String ALT_ID4_Desc="";
String alt_type_desc="";
String postal_desc="";
String mail_postal_desc="";
String order_id="";
String str13="";
String str14="";
String modified_date_time="";
String inpatient_yn ="N";
String capture_fin_dtls_yn="N";
String email_appl_yn="";
String rd_oa_integration_yn="N";
String orderCatMapped="N";
String email_appl_for_appt_wo_pid_yn="";
String pat_email_appl_yn="";
String slot_appt_ctrl="";
String to_clinic_alcn="";
String entitlement_by_pat_cat_yn="";
String rule_appl_yn="N";
String rule_based_tr 	= request.getParameter("rule_based_tr")==null?"N":request.getParameter("rule_based_tr");
String prefPractYN		= request.getParameter("prefPractYN")==null?"Y":request.getParameter("prefPractYN");
/*Added by Thamizh selvi on 2nd Feb 2018 against ML-MMOH-CRF-0601 Start*/
String alt_addr_line1	= "";
String alt_addr_line2	= "";
String alt_addr_line3	= "";
String alt_addr_line4	= "";
String alt_postal_code  = "";
String alt_postal_desc  = "";
String alt_country_code = "";
String alt_country_desc = "";
String alt_area_code	= "";
String alt_area_desc	= "";
String alt_town_code	= "";
String alt_town_desc	= "";
String alt_region_code	= "";
String alt_region_desc	= "";
boolean isAlternateAddressAppl = eCommon.Common.CommonBean.isSiteSpecific(conn, "MP","ALTERNATE_ADDRESS_APPLICABLE");
/*End*/
 
String wtListControl			= request.getParameter("wtListControl")==null?"":request.getParameter("wtListControl");

int sec_cnt=0;
stmt1=conn.createStatement();
stmt_next=conn.createStatement();

ALCN_CRITERIA_YN="None";

int no_of_slots=0;

//Bru-HIMS-CRF 169 changes start
String pat_cncl_count=request.getParameter("pat_cncl_count"); 

int max_cancel_appt=0;
String pat_cancel_reason="";
//Bru-HIMS-CRF 169 changes end

if(i_time_table_type!=null && i_time_table_type.equals("1")){
String no_slots="select to_char((to_date(to_char(a.appt_slab_to_time,'dd/mm/yyyy')||'"+i_to_time+"','dd/mm/yyyy hh24:mi')-to_date(to_char(a.appt_slab_from_time,'dd/mm/yyyy')||'"+i_from_time+"','dd/mm/yyyy hh24:mi'))*a.no_of_slots+to_date(to_char(appt_slab_from_time,'dd/mm/yyyy')||'"+i_from_time+"','dd/mm/yyyy hh24:mi'),'hh24:mi') to_time, a.no_of_slots from oa_appt a  where a.facility_id='"+facilityid+"' and a.appt_ref_no='"+apptrefno+"' ";

if (rs1!=null) rs1.close();
rs1   = stmt1.executeQuery(no_slots) ;
while (rs1 !=null && rs1.next()){
no_of_slots=rs1.getInt("no_of_slots");

if (no_of_slots>1)
	i_to_time = rs1.getString("to_time");
}
}

// String sql="select (select count(appt_ref_no) seccnt from oa_resource_for_appt where appt_ref_no ='"+apptrefno+"' and FACILITY_ID='"+facilityid+"') seccnt,b.appl_user_name,to_char(a.added_date,'dd/mm/yyyy hh24:mi') added_date,to_char(appt_slab_to_time,'hh24:mi') appt_slab_to_time, a.facility_id, a.appt_ref_no, a.clinic_code,OP_GET_DESC.OP_CLINIC(a.FACILITY_ID,a.CLINIC_CODE,'"+locale+"','1') CLINIC_SHORT_DESC,a.practitioner_id,decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2')) practitioner_short_name,OP_GET_DESC.OP_VISIT_TYPE(FACILITY_ID, APPT_TYPE_CODE,'"+locale+"','2') visit_type_short_desc, a.appt_date, to_char(a.appt_time,'hh24:mi') appt_time, to_char(a.appt_slab_from_time,'hh24:mi') appt_slab_from_time, to_char(a.appt_slab_to_time,'hh24:mi') appt_slab_to_time, to_char(a.appt_duration,'hh24:mi') appt_duration, a.appt_slots, a.patient_id ,a.name_prefix, a.first_name, a.second_name, a.third_name,a.family_name, a.name_suffix,  decode('"+locale+"','en',a.patient_name, nvl(a.patient_name_loc_lang, a.patient_name)) patient_name, a.gender, a.date_of_birth, a.res_tel_no res_tel_no,a.oth_contact_no, a.national_id_no, a.res_addr_line1, a.res_addr_line2, a.res_addr_line3,  a.res_addr_line4, a.postal_code, a.country_code,MP_GET_DESC.MP_COUNTRY(a.COUNTRY_CODE,'"+locale+"','1') nationality, a.appt_type_code,( SELECT visit_type_ind  FROM op_visit_type WHERE visit_type_code = a.appt_type_code AND facility_id = a.facility_id) VISIT_TYPE_IND,a.overbooked_yn,a.referral_id, a.mode_of_contact,a.contact_reason_code,AM_GET_DESC.AM_CONTACT_REASON(a.CONTACT_REASON_CODE,'"+locale+"','1') CONTACT_REASON,a.appt_remarks, a.appt_status, a.inpatient_yn, a.encounter_id,a.email_id,a.alcn_criteria,calculate_age(to_char(a.date_of_birth,'dd/mm/yyyy'),1) year1,calculate_age(to_char(a.date_of_birth,'dd/mm/yyyy'),2) month1,calculate_age(to_char(a.date_of_birth,'dd/mm/yyyy'),3) day1 ,a.alcn_catg_code,a.referral_id,a.team_id,null team_desc,a.pat_alcn_catg_code, MP_GET_DESC.MP_ETHNIC_GROUP(a.ETHNIC_GROUP_CODE,'"+locale+"','1') ETHNIC_GROUP_DESC,MP_GET_DESC.MP_RACE(a.RACE_CODE,'"+locale+"','1') RACE_DESC, CITIZEN_YN, LEGAL_YN, MP_GET_DESC.MP_BIRTH_PLACE(a.BIRTH_PLACE_CODE,'"+locale+"','1') BIRTH_PLACE_DESC,to_char(a.receiving_date_time,'dd/mm/yyyy HH24:mi') receiving_date_time,a.RES_AREA_CODE,MP_GET_DESC.MP_RES_AREA(a.RES_AREA_CODE,'"+locale+"','1') RES_AREA_DESC, a.RES_TOWN_CODE, MP_GET_DESC.MP_RES_TOWN(a.RES_TOWN_CODE,'"+locale+"','1') RES_TOWN_DESC, a.RES_REGION_CODE, MP_GET_DESC.MP_REGION(a.RES_REGION_CODE,'"+locale+"','1') RES_REGION_DESC, a.RES_COUNTRY_CODE, MP_GET_DESC.MP_COUNTRY(a.RES_COUNTRY_CODE,'"+locale+"','1') RES_COUNTRY_NAME,a.MAIL_ADDR_LINE1, a.MAIL_ADDR_LINE2, a.MAIL_ADDR_LINE3, a.MAIL_ADDR_LINE4, a.MAIL_AREA_CODE, MP_GET_DESC.MP_RES_AREA(a.MAIL_AREA_CODE,'"+locale+"','1') MAIL_AREA_DESC, a.MAIL_TOWN_CODE, MP_GET_DESC.MP_RES_TOWN(a.MAIL_TOWN_CODE,'"+locale+"','1') MAIL_TOWN_DESC, a.MAIL_REGION_CODE, MP_GET_DESC.MP_REGION(a.MAIL_REGION_CODE,'"+locale+"','1') MAIL_REGION_DESC, a.MAIL_POSTAL_CODE, a.MAIL_COUNTRY_CODE, MP_GET_DESC.MP_COUNTRY(a.MAIL_COUNTRY_CODE,'"+locale+"','1') MAIL_COUNTRY_NAME,a.ALT_ID1_TYPE,a.ALT_ID1_NO,to_char(a.ALT_ID1_EXP_DATE,'dd/mm/yyyy') ALT_ID1_EXP_DATE ,a.ALT_ID2_TYPE,a.ALT_ID2_NO,to_char(ALT_ID2_EXP_DATE,'dd/mm/yyyy') ALT_ID2_EXP_DATE,a.ALT_ID3_TYPE,a.ALT_ID3_NO,to_char(ALT_ID3_EXP_DATE,'dd/mm/yyyy') ALT_ID3_EXP_DATE,a.ALT_ID4_TYPE,a.ALT_ID4_NO,to_char(ALT_ID4_EXP_DATE,'dd/mm/yyyy') ALT_ID4_EXP_DATE,a.OTH_ALT_ID_TYPE,a.OTH_ALT_ID_NO,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(OTH_ALT_ID_TYPE,'"+locale+"','2') alt_type_desc,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(ALT_ID1_TYPE,'"+locale+"','1') alt_id1_type_desc, MP_GET_DESC.MP_ALTERNATE_ID_TYPE(ALT_ID2_TYPE,'"+locale+"','1') alt_id2_type_desc, MP_GET_DESC.MP_ALTERNATE_ID_TYPE(ALT_ID3_TYPE,'"+locale+"','1') alt_id3_type_desc, MP_GET_DESC.MP_ALTERNATE_ID_TYPE(ALT_ID4_TYPE,'"+locale+"','1') alt_id4_type_desc,AM_GET_DESC.AM_SERVICE(a.service_code,'"+locale+"',2)service_code, a.order_id order_id,a.order_line_num,to_char(sysdate,'dd/mm/yyyy') sysdt,to_char(sysdate,'hh24:mi') systm ,(SELECT nat_id_prompt FROM mp_param_lang_vw where module_id='MP' and language_id='"+locale+"') nat_id_prompt,to_char (a.modified_date,'dd/mm/yyyy hh24:mi') modified_date ,MP_GET_DESC.mp_postal_code(POSTAL_CODE,'"+locale+"','1') postal_desc , MP_GET_DESC.mp_postal_code(MAIL_POSTAL_CODE,'"+locale+"','1') mail_postal_desc, SPECIALITY_CODE,resource_class,order_catalog_code,rd_appt_yn,group_id from oa_appt a ,SM_APPL_USER_LANG b where a.facility_id='"+facilityid+"' and a.appt_ref_no='"+apptrefno+"' and b.language_id='"+locale+"' and a.added_by_id =b.appl_user_id";
/* 'O', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2') Added for HSA-SCF-0054 By Dharma */

StringBuffer sql=new StringBuffer();
sql.append("select (select count(appt_ref_no) seccnt from oa_resource_for_appt where appt_ref_no ='"+apptrefno+"' and FACILITY_ID='"+facilityid+"') seccnt,b.appl_user_name,to_char(a.added_date,'dd/mm/yyyy hh24:mi') added_date,to_char(appt_slab_to_time,'hh24:mi') appt_slab_to_time, a.facility_id, a.appt_ref_no, a.clinic_code,OP_GET_DESC.OP_CLINIC(a.FACILITY_ID,a.CLINIC_CODE,'"+locale+"','1') CLINIC_SHORT_DESC,a.practitioner_id,decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'O', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2')) practitioner_short_name,OP_GET_DESC.OP_VISIT_TYPE(FACILITY_ID, APPT_TYPE_CODE,'"+locale+"','2') visit_type_short_desc, a.appt_date, to_char(a.appt_time,'hh24:mi') appt_time, to_char(a.appt_slab_from_time,'hh24:mi') appt_slab_from_time, to_char(a.appt_slab_to_time,'hh24:mi') appt_slab_to_time, to_char(a.appt_duration,'hh24:mi') appt_duration, a.appt_slots, a.patient_id ,a.name_prefix, a.first_name, a.second_name, a.third_name,a.family_name, a.name_suffix,  decode('"+locale+"','en',a.patient_name, nvl(a.patient_name_loc_lang, a.patient_name)) patient_name, a.gender, a.date_of_birth, a.res_tel_no res_tel_no,a.oth_contact_no, a.national_id_no, a.res_addr_line1, a.res_addr_line2, a.res_addr_line3,  a.res_addr_line4, a.postal_code, a.country_code,MP_GET_DESC.MP_COUNTRY(a.COUNTRY_CODE,'"+locale+"','1') nationality, a.appt_type_code,( SELECT visit_type_ind  FROM op_visit_type WHERE visit_type_code = a.appt_type_code AND facility_id = a.facility_id) VISIT_TYPE_IND,a.overbooked_yn,a.referral_id, a.mode_of_contact,a.contact_reason_code,AM_GET_DESC.AM_CONTACT_REASON(a.CONTACT_REASON_CODE,'"+locale+"','1') CONTACT_REASON,a.appt_remarks, a.appt_status, a.inpatient_yn, a.encounter_id,a.email_id,a.alcn_criteria,calculate_age(to_char(a.date_of_birth,'dd/mm/yyyy'),1) year1,calculate_age(to_char(a.date_of_birth,'dd/mm/yyyy'),2) month1,calculate_age(to_char(a.date_of_birth,'dd/mm/yyyy'),3) day1 ,a.alcn_catg_code,a.referral_id,a.team_id,null team_desc,a.pat_alcn_catg_code, MP_GET_DESC.MP_ETHNIC_GROUP(a.ETHNIC_GROUP_CODE,'"+locale+"','1') ETHNIC_GROUP_DESC,MP_GET_DESC.MP_RACE(a.RACE_CODE,'"+locale+"','1') RACE_DESC, CITIZEN_YN, LEGAL_YN, MP_GET_DESC.MP_BIRTH_PLACE(a.BIRTH_PLACE_CODE,'"+locale+"','1') BIRTH_PLACE_DESC,to_char(a.receiving_date_time,'dd/mm/yyyy HH24:mi') receiving_date_time,a.RES_AREA_CODE,MP_GET_DESC.MP_RES_AREA(a.RES_AREA_CODE,'"+locale+"','1') RES_AREA_DESC, a.RES_TOWN_CODE, MP_GET_DESC.MP_RES_TOWN(a.RES_TOWN_CODE,'"+locale+"','1') RES_TOWN_DESC, a.RES_REGION_CODE, MP_GET_DESC.MP_REGION(a.RES_REGION_CODE,'"+locale+"','1') RES_REGION_DESC, a.RES_COUNTRY_CODE, MP_GET_DESC.MP_COUNTRY(a.RES_COUNTRY_CODE,'"+locale+"','1') RES_COUNTRY_NAME,a.MAIL_ADDR_LINE1, a.MAIL_ADDR_LINE2, a.MAIL_ADDR_LINE3, a.MAIL_ADDR_LINE4, a.MAIL_AREA_CODE, MP_GET_DESC.MP_RES_AREA(a.MAIL_AREA_CODE,'"+locale+"','1') MAIL_AREA_DESC, a.MAIL_TOWN_CODE, MP_GET_DESC.MP_RES_TOWN(a.MAIL_TOWN_CODE,'"+locale+"','1') MAIL_TOWN_DESC, a.MAIL_REGION_CODE, MP_GET_DESC.MP_REGION(a.MAIL_REGION_CODE,'"+locale+"','1') MAIL_REGION_DESC, a.MAIL_POSTAL_CODE, a.MAIL_COUNTRY_CODE, MP_GET_DESC.MP_COUNTRY(a.MAIL_COUNTRY_CODE,'"+locale+"','1') MAIL_COUNTRY_NAME,a.alt_addr_line1, a.alt_addr_line2, a.alt_addr_line3, a.alt_addr_line4, a.alt_area_code, MP_GET_DESC.MP_RES_AREA(a.alt_area_code,'"+locale+"','1') alt_area_desc, a.alt_town_code, MP_GET_DESC.MP_RES_TOWN(a.alt_town_code,'"+locale+"','1') alt_town_desc, a.alt_region_code, MP_GET_DESC.MP_REGION(a.alt_region_code,'"+locale+"','1') alt_region_desc, a.alt_postal_code, MP_GET_DESC.mp_postal_code(a.alt_postal_code,'"+locale+"','2') alt_postal_desc, a.alt_country_code, MP_GET_DESC.MP_COUNTRY(a.alt_country_code,'"+locale+"','1') alt_country_desc, a.ALT_ID1_TYPE,a.ALT_ID1_NO,to_char(a.ALT_ID1_EXP_DATE,'dd/mm/yyyy') ALT_ID1_EXP_DATE ,a.ALT_ID2_TYPE,a.ALT_ID2_NO,to_char(ALT_ID2_EXP_DATE,'dd/mm/yyyy') ALT_ID2_EXP_DATE,a.ALT_ID3_TYPE,a.ALT_ID3_NO,to_char(ALT_ID3_EXP_DATE,'dd/mm/yyyy') ALT_ID3_EXP_DATE,a.ALT_ID4_TYPE,a.ALT_ID4_NO,to_char(ALT_ID4_EXP_DATE,'dd/mm/yyyy') ALT_ID4_EXP_DATE,a.OTH_ALT_ID_TYPE,a.OTH_ALT_ID_NO,");
sql.append("MP_GET_DESC.MP_ALTERNATE_ID_TYPE(OTH_ALT_ID_TYPE,'"+locale+"','2') alt_type_desc,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(ALT_ID1_TYPE,'"+locale+"','1') alt_id1_type_desc, MP_GET_DESC.MP_ALTERNATE_ID_TYPE(ALT_ID2_TYPE,'"+locale+"','1') alt_id2_type_desc, MP_GET_DESC.MP_ALTERNATE_ID_TYPE(ALT_ID3_TYPE,'"+locale+"','1') alt_id3_type_desc, MP_GET_DESC.MP_ALTERNATE_ID_TYPE(ALT_ID4_TYPE,'"+locale+"','1') alt_id4_type_desc,AM_GET_DESC.AM_SERVICE(a.service_code,'"+locale+"',2)service_code, a.order_id order_id,a.order_line_num,to_char(sysdate,'dd/mm/yyyy') sysdt,to_char(sysdate,'hh24:mi') systm ,(SELECT nat_id_prompt FROM mp_param_lang_vw where module_id='MP' and language_id='"+locale+"') nat_id_prompt,to_char (a.modified_date,'dd/mm/yyyy hh24:mi') modified_date ,MP_GET_DESC.mp_postal_code(POSTAL_CODE,'"+locale+"','2') postal_desc , MP_GET_DESC.mp_postal_code(MAIL_POSTAL_CODE,'"+locale+"','2') mail_postal_desc, SPECIALITY_CODE,resource_class,order_catalog_code,rd_appt_yn,group_id from oa_appt a ,SM_APPL_USER_LANG b where a.facility_id='"+facilityid+"' and a.appt_ref_no='"+apptrefno+"' and b.language_id='"+locale+"' and a.added_by_id =b.appl_user_id");//Modified by Thamizh selvi on 2nd Feb 2018 against ML-MMOH-CRF-0601

rs1=stmt1.executeQuery(sql.toString());
if(rs1 != null) 
{
	if(rs1.next()) //this block woke
	{  
		  sec_cnt=rs1.getInt("seccnt");	

		  frm_clinic_code=rs1.getString("CLINIC_CODE");
		  team_id=rs1.getString("team_id");
		  if(team_id==null)team_id="";
		  user_name=rs1.getString("appl_user_name");
		  if(user_name==null)user_name="";
		  record_date=rs1.getString("added_date");
		  if(record_date==null)record_date="";
		  team_short_desc=rs1.getString("team_desc");
		  if(team_short_desc==null)team_short_desc="";
		  referral_id=rs1.getString("referral_id");
		  if(referral_id==null)referral_id="";
		  nationality=rs1.getString("nationality");
		  if(nationality==null) nationality="";
		  agey=rs1.getString("year1");
		  if(agey==null)agey="";
		  agem=rs1.getString("month1");
		  if(agem==null)agem="";
		  aged=rs1.getString("day1");	  
		  if(aged==null)aged="";

		 apptrefno1=rs1.getString("appt_ref_no");
		 if(apptrefno1 == null )apptrefno1="";
		 clinicshortdesc=rs1.getString("clinic_short_desc");
		 if(clinicshortdesc == null) clinicshortdesc="";

		 practitionerid=rs1.getString("practitioner_id");
		 if(practitionerid == null)practitionerid="";
		 practname=rs1.getString("practitioner_short_name");
		 if(practname == null) practname="";

			modified_date_time=rs1.getString("modified_date");
			if(modified_date_time ==null) modified_date_time="";

		 visitshortdesc=rs1.getString("visit_type_short_desc");
		 if(visitshortdesc == null) visitshortdesc="";
	
		visitind=rs1.getString("VISIT_TYPE_IND");
		if(visitind == null) visitind="";

		 java.util.Date dateapd=rs1.getDate("appt_date");
		 SimpleDateFormat formatterapd = new SimpleDateFormat("dd/MM/yyyy");
		 apptdate=formatterapd.format(dateapd);
		 formatterapd = null;
		 appttime=rs1.getString("appt_time");
		 if(appttime == null) appttime="";
		 apptslabfmtime=rs1.getString("appt_slab_from_time");
		 if(apptslabfmtime == null) apptslabfmtime="";
		 apptslabtotime=rs1.getString("appt_slab_to_time");
		if(apptslabtotime == null) apptslabtotime="";
		disp_fromtime=apptslabfmtime;
		disp_totime=apptslabtotime; 
		 apptduration=rs1.getString("appt_duration");
		 if(apptduration == null) apptduration="";
		 patientid=rs1.getString("patient_id");
		 if(patientid == null) patientid="";
		 prefix=rs1.getString("name_prefix");
		 if( prefix == null) prefix="";
		 firstname=rs1.getString("first_name");
		 if(firstname== null) firstname="";
		 secondname=rs1.getString("second_name");
		 if(secondname == null) secondname="";
		 thirdname=rs1.getString("third_name");
		 if(thirdname == null) thirdname="";
		 familyname=rs1.getString("family_name");
		 if(familyname == null) familyname="";
		 suffix=rs1.getString("name_suffix");
		 if(suffix == null) suffix="";
		 patientname=rs1.getString("patient_name");
		 if(patientname == null) patientname="";
		ETHNIC_GROUP_DESC=rs1.getString("ETHNIC_GROUP_DESC");
		 if(ETHNIC_GROUP_DESC == null) ETHNIC_GROUP_DESC="";
		RACE_DESC=rs1.getString("RACE_DESC");
		 if(RACE_DESC == null) RACE_DESC="";
		CITIZEN_YN=rs1.getString("CITIZEN_YN");
		 if(CITIZEN_YN == null) CITIZEN_YN="";
		LEGAL_YN=rs1.getString("LEGAL_YN");
		 if(LEGAL_YN == null) LEGAL_YN="";
		BIRTH_PLACE_DESC=rs1.getString("BIRTH_PLACE_DESC");
		 if(BIRTH_PLACE_DESC == null) BIRTH_PLACE_DESC="";
		
		RES_AREA_CODE=rs1.getString("RES_AREA_CODE");
		 if(RES_AREA_CODE == null) RES_AREA_CODE="";
		RES_AREA_DESC=rs1.getString("RES_AREA_DESC");
		 if(RES_AREA_DESC == null) RES_AREA_DESC="";
		RES_TOWN_CODE=rs1.getString("RES_TOWN_CODE");
		 if(RES_TOWN_CODE == null) RES_TOWN_CODE="";
		RES_TOWN_DESC=rs1.getString("RES_TOWN_DESC");
		 if(RES_TOWN_DESC == null) RES_TOWN_DESC="";
		RES_REGION_CODE=rs1.getString("RES_REGION_CODE");
		 if(RES_REGION_CODE == null) RES_REGION_CODE="";
		RES_REGION_DESC=rs1.getString("RES_REGION_DESC");
		 if(RES_REGION_DESC == null) RES_REGION_DESC="";
		RES_COUNTRY_CODE=rs1.getString("RES_COUNTRY_CODE");
		 if(RES_COUNTRY_CODE == null) RES_COUNTRY_CODE="";
		RES_COUNTRY_NAME=rs1.getString("RES_COUNTRY_NAME");
		 if(RES_COUNTRY_NAME == null) RES_COUNTRY_NAME="";
		MAIL_ADDR_LINE1=rs1.getString("MAIL_ADDR_LINE1");
		 if(MAIL_ADDR_LINE1 == null) MAIL_ADDR_LINE1="";
		MAIL_ADDR_LINE2=rs1.getString("MAIL_ADDR_LINE2");
		 if(MAIL_ADDR_LINE2 == null) MAIL_ADDR_LINE2="";
		MAIL_ADDR_LINE3=rs1.getString("MAIL_ADDR_LINE3");
		 if(MAIL_ADDR_LINE3 == null) MAIL_ADDR_LINE3="";
		MAIL_ADDR_LINE4=rs1.getString("MAIL_ADDR_LINE4");
		 if(MAIL_ADDR_LINE4 == null) MAIL_ADDR_LINE4="";
		MAIL_AREA_CODE=rs1.getString("MAIL_AREA_CODE");
		 if(MAIL_AREA_CODE == null) MAIL_AREA_CODE="";
		MAIL_AREA_DESC=rs1.getString("MAIL_AREA_DESC");
		 if(MAIL_AREA_DESC == null) MAIL_AREA_DESC="";
		MAIL_TOWN_CODE=rs1.getString("MAIL_TOWN_CODE");
		 if(MAIL_TOWN_CODE == null) MAIL_TOWN_CODE="";
		MAIL_TOWN_DESC=rs1.getString("MAIL_TOWN_DESC");
		 if(MAIL_TOWN_DESC == null) MAIL_TOWN_DESC="";
		MAIL_REGION_CODE=rs1.getString("MAIL_REGION_CODE");
		 if(MAIL_REGION_CODE == null) MAIL_REGION_CODE="";
		MAIL_REGION_DESC=rs1.getString("MAIL_REGION_DESC");
		 if(MAIL_REGION_DESC == null) MAIL_REGION_DESC="";
		MAIL_POSTAL_CODE=rs1.getString("MAIL_POSTAL_CODE");
		 if(MAIL_POSTAL_CODE == null) MAIL_POSTAL_CODE="";
		MAIL_COUNTRY_CODE=rs1.getString("MAIL_COUNTRY_CODE");
		 if(MAIL_COUNTRY_CODE == null) MAIL_COUNTRY_CODE="";
		MAIL_COUNTRY_NAME=rs1.getString("MAIL_COUNTRY_NAME");
		 if(MAIL_COUNTRY_NAME == null) MAIL_COUNTRY_NAME="";
		ALT_ID1_TYPE=rs1.getString("ALT_ID1_TYPE");
		 if(ALT_ID1_TYPE == null) ALT_ID1_TYPE="";
		ALT_ID1_NO=rs1.getString("ALT_ID1_NO");
		 if(ALT_ID1_NO == null) ALT_ID1_NO="";
		ALT_ID1_EXP_DATE=rs1.getString("ALT_ID1_EXP_DATE");
		 if(ALT_ID1_EXP_DATE == null) ALT_ID1_EXP_DATE="";
		ALT_ID2_TYPE=rs1.getString("ALT_ID2_TYPE");
		 if(ALT_ID2_TYPE == null) ALT_ID2_TYPE="";
		ALT_ID2_NO=rs1.getString("ALT_ID2_NO");
		 if(ALT_ID2_NO == null) ALT_ID2_NO="";
		ALT_ID2_EXP_DATE=rs1.getString("ALT_ID2_EXP_DATE");
		 if(ALT_ID2_EXP_DATE == null) ALT_ID2_EXP_DATE="";
		ALT_ID3_TYPE=rs1.getString("ALT_ID3_TYPE");
		 if(ALT_ID3_TYPE == null) ALT_ID3_TYPE="";
		ALT_ID3_NO=rs1.getString("ALT_ID3_NO");
		 if(ALT_ID3_NO == null) ALT_ID3_NO="";
		ALT_ID3_EXP_DATE=rs1.getString("ALT_ID3_EXP_DATE");
		 if(ALT_ID3_EXP_DATE == null) ALT_ID3_EXP_DATE="";
		ALT_ID4_TYPE=rs1.getString("ALT_ID4_TYPE");
		 if(ALT_ID4_TYPE == null) ALT_ID4_TYPE="";
		ALT_ID4_NO=rs1.getString("ALT_ID4_NO");
		 if(ALT_ID4_NO == null) ALT_ID4_NO="";
		ALT_ID4_EXP_DATE=rs1.getString("ALT_ID4_EXP_DATE");
		 if(ALT_ID4_EXP_DATE == null) ALT_ID4_EXP_DATE="";
		OTH_ALT_ID_TYPE=rs1.getString("OTH_ALT_ID_TYPE");
		 if(OTH_ALT_ID_TYPE == null) OTH_ALT_ID_TYPE="";
		OTH_ALT_ID_NO=rs1.getString("OTH_ALT_ID_NO");
		 if(OTH_ALT_ID_NO == null) OTH_ALT_ID_NO="";	
		 alt_type_desc=rs1.getString("alt_type_desc");
		 if(alt_type_desc == null) alt_type_desc="";

			/*Added by Thamizh selvi on 2nd Feb 2018 against ML-MMOH-CRF-0601 Start*/
			alt_addr_line1		= checkForNull(rs1.getString("alt_addr_line1"));
			alt_addr_line2		= checkForNull(rs1.getString("alt_addr_line2"));
			alt_addr_line3		= checkForNull(rs1.getString("alt_addr_line3"));
			alt_addr_line4		= checkForNull(rs1.getString("alt_addr_line4"));
			alt_area_code		= checkForNull(rs1.getString("alt_area_code"));
			alt_area_desc		= checkForNull(rs1.getString("alt_area_desc"));
			alt_town_code		= checkForNull(rs1.getString("alt_town_code"));
			alt_town_desc		= checkForNull(rs1.getString("alt_town_desc"));
			alt_region_code		= checkForNull(rs1.getString("alt_region_code"));
			alt_region_desc		= checkForNull(rs1.getString("alt_region_desc"));
			alt_postal_code		= checkForNull(rs1.getString("alt_postal_code"));
			alt_postal_desc		= checkForNull(rs1.getString("alt_postal_desc"));
			alt_country_code	= checkForNull(rs1.getString("alt_country_code"));
			alt_country_desc	= checkForNull(rs1.getString("alt_country_desc"));
			/*End*/
     SPECIALITY_CODE=rs1.getString("SPECIALITY_CODE");
     order_catalog_code=rs1.getString("order_catalog_code")==null?"":rs1.getString("order_catalog_code");
     rd_appt_yn=rs1.getString("rd_appt_yn")==null?"N":rs1.getString("rd_appt_yn");
     group_id=rs1.getString("group_id")==null?"":rs1.getString("group_id");
	
	 /*Above Line Added for this incident[35078]*/
	 resource_class=rs1.getString("resource_class");
	 if(resource_class == null) resource_class="P";	 
	 res_type=resource_class;
	 if(resource_class.equals("P")){
	 res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
     }else if(resource_class.equals("E")){
	 res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
     }else if(resource_class.equals("R")){
	 res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
     }else if(resource_class.equals("O")){
	 res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
     }else if(resource_class.equals("B")){
	 res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Bed.label","common_labels");
     }
	 
	 //End incident[35078]
	 
     ALT_ID1_Desc=rs1.getString("alt_id1_type_desc");
	 ALT_ID2_Desc=rs1.getString("alt_id2_type_desc");
	 ALT_ID3_Desc=rs1.getString("alt_id3_type_desc");
	 ALT_ID4_Desc=rs1.getString("alt_id4_type_desc");
	 service_code=rs1.getString("service_code");
	 if(service_code==null)service_code="&nbsp;";
	 nat_id_prompt=rs1.getString("nat_id_prompt");
	 if (nat_id_prompt == null)
		{
		  nat_id_prompt= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.NationalIDNo.label","am_labels");
		}

	 if (SPECIALITY_CODE==null) SPECIALITY_CODE="";
	 if (ALT_ID1_Desc==null) ALT_ID1_Desc="";
	 if (ALT_ID2_Desc==null) ALT_ID2_Desc="";
	 if (ALT_ID3_Desc==null) ALT_ID3_Desc="";
	 if (ALT_ID4_Desc==null) ALT_ID4_Desc="";
     ALT_ID1_Desc=ALT_ID1_Desc.trim();
	 ALT_ID2_Desc=ALT_ID2_Desc.trim();
	 ALT_ID3_Desc=ALT_ID3_Desc.trim();
	 ALT_ID4_Desc=ALT_ID4_Desc.trim();

	 str13=rs1.getString("sysdt");
	  str14=rs1.getString("systm");

		order_line_num=rs1.getString("order_line_num")==null?"":rs1.getString("order_line_num");
		order_id=rs1.getString("order_id");
		if(order_id ==null) order_id="";
		receiving_date_time=rs1.getString("receiving_date_time");
		 if(receiving_date_time == null) receiving_date_time="";
		 receiving_date_time_display=DateUtils.convertDate(receiving_date_time,"DMYHM","en",locale);

		 gender=rs1.getString("gender");
		
		 if(gender.equals("M")) 
				{
				genderdesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
				}
				else if(gender.equals("F")) {
				genderdesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
				}
				else if(gender.equals("U")) {
				genderdesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
				}

	 java.util.Date date1 = rs1.getDate("date_of_birth");
	 if(date1 != null )
	{
		 SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
		 dateofbirth=formatter1.format(date1);
		 formatter1 = null;
	 }
	 else
		 dateofbirth="";
		 stmt2=conn.createStatement(); 	

	restelno=rs1.getString("res_tel_no");
	if (restelno==null)
	restelno="";
	othtelno=rs1.getString("oth_contact_no");
	if(othtelno==null)
	othtelno="";
	emailid=rs1.getString("email_id");
	if(emailid==null)
	emailid="";
	nationalid=rs1.getString("national_id_no");
	if(nationalid == null) nationalid="";
	alternateid=rs1.getString("alt_id1_no");
	if(alternateid == null) alternateid="";
	resaddrl1=rs1.getString("res_addr_line1");
	if(resaddrl1 == null) resaddrl1="";
	resaddrl2=rs1.getString("res_addr_line2");
	if(resaddrl2 == null) resaddrl2="";
	resaddrl3=rs1.getString("res_addr_line3");
	if(resaddrl3 == null) resaddrl3="";
	resaddrl4=rs1.getString("res_addr_line4");
	if(resaddrl4 == null) resaddrl4="";
	postalcode=rs1.getString("postal_code");
	if(postalcode == null) postalcode="";

	postal_desc=rs1.getString("postal_desc");
	if(postal_desc == null) postal_desc="";
	mail_postal_desc=rs1.getString("mail_postal_desc");
	if(mail_postal_desc == null) mail_postal_desc="";

		contactAddress.append(""+"^^");
		contactAddress.append(resaddrl1+"^^");
		contactAddress.append(resaddrl2+"^^");
		contactAddress.append(resaddrl3+"^^");
		contactAddress.append(resaddrl4+"^^");
		contactAddress.append(RES_TOWN_CODE+"^^");
		contactAddress.append(RES_AREA_CODE+"^^");
		contactAddress.append(postalcode+"^^");
		contactAddress.append(RES_REGION_CODE+"^^");
		contactAddress.append(RES_COUNTRY_CODE+"^^");
		contactAddress.append(""+"^^");
		contactAddress.append(""+"^^");
		contactAddress.append(""+"^^");
		contactAddress.append(MAIL_ADDR_LINE1+"^^");
		contactAddress.append(MAIL_ADDR_LINE2+"^^");
		contactAddress.append(MAIL_ADDR_LINE3+"^^");
		contactAddress.append(MAIL_ADDR_LINE4+"^^");
		contactAddress.append(MAIL_TOWN_CODE+"^^");
		contactAddress.append(MAIL_AREA_CODE+"^^");
		contactAddress.append(MAIL_POSTAL_CODE+"^^");
		contactAddress.append(MAIL_REGION_CODE+"^^");
		contactAddress.append(MAIL_COUNTRY_CODE+"^^");
		contactAddress.append(""+"^^");
		contactAddress.append(""+"^^");
		contactAddress.append(restelno+"^^");
		contactAddress.append(othtelno+"^^");
		contactAddress.append(emailid+"^^");
		contactAddress.append(""+"^^");
		contactAddress.append(RES_TOWN_DESC+"^^");
		contactAddress.append(RES_AREA_DESC+"^^");
		contactAddress.append(RES_REGION_DESC+"^^");
		contactAddress.append(MAIL_TOWN_DESC+"^^");
		contactAddress.append(MAIL_AREA_DESC+"^^");
		contactAddress.append(MAIL_REGION_DESC+"^^");
		contactAddress.append(RES_COUNTRY_NAME+"^^");
		contactAddress.append(MAIL_COUNTRY_NAME+"^^");
		contactAddress.append(postal_desc+"^^");
		contactAddress.append(mail_postal_desc+"^^");
		/*Added by Thamizh selvi on 2nd Feb 2018 against ML-MMOH-CRF-0601 Start*/
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
		contactAddress.append(alt_country_desc);
		/*End*/




	countrycode=rs1.getString("country_code");
	if(countrycode == null) countrycode="";
	contactvals=resaddrl1+"^"+resaddrl2+"^"+resaddrl3+"^"+resaddrl4+"^"+postalcode+"^"+countrycode;
	appttypecode=rs1.getString("appt_type_code");
	if(appttypecode == null) appttypecode="";
	overbookedyn=rs1.getString("overbooked_yn");
	if(overbookedyn == null) overbookedyn="";

	referralcode=rs1.getString("referral_id");
	if(referralcode == null) referralcode="";
    pre_alcn_catg_code=rs1.getString("alcn_catg_code");
   if(pre_alcn_catg_code == null)pre_alcn_catg_code="";
	mode=rs1.getString("mode_of_contact");
	if(mode==null) 
	{
		mode="";
	}
	else 
	{
		if(mode.equals("E")) {
			modedesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.email.label","common_labels");
		}
		else if(mode.equals("T")) {
			modedesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.telephone.label","common_labels");
		}
		else if(mode.equals("F")) {
			modedesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fax.label","common_labels");
		}
		else if(mode.equals("I")) {
			modedesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InPerson.label","common_labels");
	    }
	    else if(mode.equals("W")) {
			modedesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Web.label","common_labels");
	    }
	    else if(mode.equals("O")) {
			modedesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
		}
	}

	reasoncode=rs1.getString("contact_reason_code");
	if(reasoncode == null) reasoncode="";
	reasondesc=rs1.getString("contact_reason");
	if(reasondesc == null) reasondesc="";
	apptremarks=rs1.getString("appt_remarks");
	if(apptremarks==null)
	apptremarks="";
	apptstatus=rs1.getString("appt_status");
	pre_alcn_criteria=rs1.getString("alcn_criteria");
	pat_alcn_catg_code=rs1.getString("pat_alcn_catg_code");
	
	} // end of if rs.next()
	else{%>

	<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));parent.window.close();</script>
<%
	
	}
}

if(rs1 !=null) rs1.close();

 

String Bl_sql="select RULE_APPL_YN,CAPTURE_FIN_DTLS_YN,EMAIL_APPL_YN,EMAIL_APPL_FOR_APPT_WO_PID_YN,SLOT_APPT_CTRL,(select ENTITLEMENT_BY_PAT_CAT_YN from mp_param where module_id='MP')ENTITLEMENT_BY_PAT_CAT_YN ,(select 'Y' from op_catalog_for_clinic where clinic_code = '"+frm_clinic_code+"' and order_catalog_code = '"+order_catalog_code+"' and facility_id = '"+facilityid+"') orderCatMapped,rd_oa_integration_yn,PAT_CANCEL_REASON,MAX_CANCEL_APPT FROM oa_param where module_id='OA'";

if (rs1!=null) rs1.close();
rs1   = stmt1.executeQuery(Bl_sql) ;

while (rs1 !=null && rs1.next()){
rule_appl_yn=rs1.getString("RULE_APPL_YN")==null?"N":rs1.getString("RULE_APPL_YN");
capture_fin_dtls_yn=rs1.getString("CAPTURE_FIN_DTLS_YN");
slot_appt_ctrl=rs1.getString("SLOT_APPT_CTRL");
entitlement_by_pat_cat_yn=rs1.getString("ENTITLEMENT_BY_PAT_CAT_YN");
email_appl_yn=rs1.getString("EMAIL_APPL_YN")==null?"N":rs1.getString("EMAIL_APPL_YN");
email_appl_for_appt_wo_pid_yn=rs1.getString("email_appl_for_appt_wo_pid_yn")==null?"N":rs1.getString("email_appl_for_appt_wo_pid_yn");
orderCatMapped=rs1.getString("orderCatMapped")==null?"N":rs1.getString("orderCatMapped");
rd_oa_integration_yn=rs1.getString("rd_oa_integration_yn")==null?"N":rs1.getString("rd_oa_integration_yn");
//Bru-HIMS-CRf 169 changes start
pat_cancel_reason=rs1.getString("PAT_CANCEL_REASON")==null?"N":rs1.getString("PAT_CANCEL_REASON");
max_cancel_appt=rs1.getInt("max_cancel_appt");
//Bru-HIMS-CRf 169 changes End
}

if(rs1 !=null) rs1.close();

if(patientid!=null && !patientid.equals("")){
	String emailsql="select  b.EMAIL_APPL_YN PAT_EMAIL_APPL_YN, (select APPT_CANCELLED_COUNT from OA_PAT_CNCL_APPT_SUMMARY where patient_id='"+patientid+"' and facility_id='"+facilityid+"') appt_cancelled_count from mp_patient a, mp_pat_ser_grp b where  a.patient_id=? and a.pat_ser_grp_code=b.pat_ser_grp_code";//query modified for Bru-HIMS-CRF-169
	pstmt=conn.prepareStatement(emailsql) ;
	pstmt.setString(1,patientid);
	rs=pstmt.executeQuery() ;
	if(rs!=null && rs.next()){
		pat_email_appl_yn=rs.getString("PAT_EMAIL_APPL_YN");
		//BruHIMS CRf - 169 changes start
		if(pat_cncl_count==null){
		int pcnclcount=rs.getInt("appt_cancelled_count");
		pat_cncl_count=String.valueOf(pcnclcount);		
		//Bru-HIMS-CRF 169 changes end
		}
	}

}else{
}
String i_appt_date_display="";
	String record_date_display=DateUtils.convertDate(record_date,"DMYHM","en",locale);

	String apptdate_display=DateUtils.convertDate(apptdate,"DMY","en",locale);

	 i_appt_date_display=DateUtils.convertDate(i_appt_date,"DMY","en",locale);

	String dateofbirth_display=DateUtils.convertDate(dateofbirth,"DMY","en",locale);

	if (rs1 != null) rs1.close();
	
	 if(pre_alcn_criteria==null) pre_alcn_criteria="";
	 if(pat_alcn_catg_code==null) pat_alcn_catg_code="";
	 if(pre_pat_alcn_catg_code.equals("")){
		pre_pat_alcn_catg_code=pat_alcn_catg_code;
	 }
    stmtsd=conn.createStatement();

if(rssd !=null)rssd.close();
	
	 if(!(referral_id.equals(""))){
	 String sql_refral="select substr(get_referral_detail_line('"+referral_id+"','FROM','"+locale+"'),3,70) ref_line1,substr(get_referral_detail_line('"+referral_id+"','FROM','"+locale+"'),73) ref_line2 from dual";
	 rssd=stmtsd.executeQuery(sql_refral);
	 rssd.next();
	 referral_line=rssd.getString("ref_line1");
	  referral_line1=rssd.getString("ref_line2");
	   if(referral_line1 ==null) referral_line1="";
	 }else{
	 
	 }

String practitionerName="";
	
if (practitioner_id!=""){
	String ss="";
   //Added for this incident ML-BRU-SCF-1602 [IN:055253]
  if(!function_mode.equals("")&&function_mode.equals("transfer")){
	    if(new_resource_class.equals("P")){
			ss="select practitioner_name from am_practitioner_LANG_VW where practitioner_id = '"+practitioner_id+"' AND language_id='"+locale+"'";
		}else if(new_resource_class.equals("R")){
			ss="select short_desc descrip from am_facility_room_LANG_VW where room_num ='"+practitioner_id+"' and OPERATING_FACILITY_ID='"+facilityid+"'  AND language_id='"+locale+"'";
		}else {
			ss="select short_desc descrip from am_resource_LANG_VW where resource_id = '"+practitioner_id+"' and facility_id= '"+facilityid+"' and resource_Class='"+res_type+"'  AND language_id='"+locale+"' ";
		}   
   }else{
		if(res_type.equals("P")){
			ss="select practitioner_name from am_practitioner_LANG_VW where practitioner_id = '"+practitioner_id+"' AND language_id='"+locale+"'";
		}else if(res_type.equals("R")){
			ss="select short_desc descrip from am_facility_room_LANG_VW where room_num ='"+practitioner_id+"' and OPERATING_FACILITY_ID='"+facilityid+"'  AND language_id='"+locale+"'";
		}else {
			ss="select short_desc descrip from am_resource_LANG_VW where resource_id = '"+practitioner_id+"' and facility_id= '"+facilityid+"' and resource_Class='"+res_type+"'  AND language_id='"+locale+"' ";
		}
	}
	//End ML-BRU-SCF-1602 [IN:055253]
 
	

rs_next   = stmt_next.executeQuery(ss) ;
while (rs_next !=null && rs_next.next())
	practitionerName = rs_next.getString(1);

}

if (rs_next!=null) rs_next.close();
int count=0;
String sql_wait_list="select count(*) count from pr_wait_list where facility_id='"+facilityid+"' and PREFERRED_DATE_TIME=to_date('"+i_appt_date+"','dd/mm/yyyy') and LOCN_CODE ='"+clinic_code+"' and RESOURCE_ID='"+practitioner_id+"'";
rs_next   = stmt_next.executeQuery(sql_wait_list) ;
if (rs_next !=null && rs_next.next())
	{
	count = rs_next.getInt(1);
}




if (rs_next!=null) rs_next.close();
if(stmt_next !=null) stmt_next.close();
%>

<% 

// Below code was added by Venkatesh S on 11.06.2011 for SRR20056-SCF-7292 [IN:027301]
 int incr=0;
/* usage for find out interval time between two time for current appoinment.*/
 SimpleDateFormat format = new SimpleDateFormat("HH:mm"); 
java.util.Date c_date1 = format.parse(apptslabfmtime); 
 java.util.Date c_date2 = format.parse(apptslabtotime);
 long c_app_interval=(c_date2.getTime() - c_date1.getTime());

 // Code ends.

if(!flag.equals("Visit_Reg") && !flag.equals("Trans")) {   %>
<body onLoad='sh_focus();' OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onUnLoad="clearSession()">
<% } else
{
%>
<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<%
}%>


<center>
<form name='apptdetails_form' id='apptdetails_form' action='../../servlet/eOA.AppointmentDetailsServlet' method='post' target='messageFrame'>
<input type='hidden' name='help_function_id' id='help_function_id' value='CANCEL_APPOINTMENT'>
<%
			out.println("<input type='hidden' name='appt_ref_no' id='appt_ref_no' value='" + apptrefno +"'>");
%>
 <table border='0' cellpadding='3' cellspacing='0' width='98%' align='center' valign='top' >
		<%if(function_mode.equals("")) {%>		
	
	<tr>
		<td colspan='2' class='COLUMNHEADER'><fmt:message key="Common.AppointmentDetails.label" bundle="${common_labels}"/></td>
			<%if(overbookedyn.equals("Y")) {%>
		<td class='COLUMNHEADER'  nowrap colspan='2'><fmt:message key="eOA.overbooking.label" bundle="${oa_labels}"/></td>
			<%}else{%>
		<td  class='COLUMNHEADER'  nowrap colspan='2'>&nbsp;</td>						
			<%}%>
	</tr>

	
	<tr>
    	<td  class='label'  nowrap><fmt:message key="Common.apptno.label" bundle="${common_labels}"/></td>
    	<td  class='QUERYDATA' nowrap><%=apptrefno1%></td>
    	<td  class='label'  nowrap><fmt:message key="Common.apptdate.label" bundle="${common_labels}"/>/<fmt:message key="Common.appttime.label" bundle="${common_labels}"/></td>
		<td  class='QUERYDATA' nowrap><%=apptdate_display%>  <%=apptslabfmtime%> - <%=apptslabtotime%></td>
	</tr>	

	

	<tr>	
		<td  class='label'  nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
		
		<td  class='QUERYDATA' nowrap><%=care_locn_ind_desc%>/<%=clinicshortdesc%></td>

		<!--<td  class='label'  nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>

		<td  class='QUERYDATA' nowrap ><%=clinicshortdesc%></td>-->
      	<td  class='label'  nowrap><fmt:message key="Common.resource.label" bundle="${common_labels}"/></td>

		<td class='QUERYDATA' nowrap><%=res_class_desc%>/<%=practname%></td>				
	</tr>

    <tr>
		<!--<td  class='label'  nowrap><fmt:message key="Common.resource.label" bundle="${common_labels}"/></td>

		<td class='QUERYDATA' nowrap><%=res_class_desc%>/<%=practname%></td>
			
		<td  class='label'  nowrap><fmt:message key="Common.resource.label" bundle="${common_labels}"/></td>
			
		<td class='QUERYDATA' nowrap><%=practname%></td>-->
		<td  class='label'  nowrap><fmt:message key="Common.visittype.label" bundle="${common_labels}"/></td>

		<td  class='QUERYDATA' nowrap ><%=visitshortdesc%></td>
      	
		<td  class='label' nowrap width='25%'><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
		<td  class='QUERYDATA' nowrap ><%=service_code%></td>	 
	</tr>
					

	
	<!--<tr>	

		<td  class='label'  nowrap><fmt:message key="Common.visittype.label" bundle="${common_labels}"/></td>

		<td  class='QUERYDATA' nowrap ><%=visitshortdesc%></td>
      	
		<td  class='label'  nowrap colspan='2'>&nbsp;</td>			

	</tr>-->



<%}else {%>
			<tr>
    				<td  class='label'  nowrap><fmt:message key="Common.apptno.label" bundle="${common_labels}"/></td>
					
					<td class='QUERYDATA' nowrap ><%=apptrefno%></td>

					<td class='label' nowrap><fmt:message key="Common.visittype.label" bundle="${common_labels}"/></td>
					
					<td   class='QUERYDATA' nowrap ><%=visitshortdesc%></td>
			</tr>			
			
			<tr>
					<td  class='label'nowrap><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
					
					<td   class='QUERYDATA' nowrap ><%=care_locn_ind_desc%></td>
					
					<td  class='label'  nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>

					<td   class='QUERYDATA' nowrap ><%=clinicshortdesc%></td>
      				
					
    		</tr>


		<tr>
			<td  class='COLUMNHEADER' colspan='4'><fmt:message key="eOA.CurrentAppointmentDetails.label" bundle="${oa_labels}"/></td>
		</tr>

			<tr>
      				<td  class='label'  nowrap ><fmt:message key="Common.resourcetype.label" bundle="${common_labels}"/></td>
					
					<td  class='QUERYDATA'  nowrap><%=res_class_desc%></td>
					
					<td  class='label'  nowrap><fmt:message key="Common.resource.label" bundle="${common_labels}"/></td>
						
					<td  class='QUERYDATA'  nowrap><%=practname%></td>
			</tr>
	
    		<tr>
    			<td  class='label' nowrap><fmt:message key="Common.apptdate.label" bundle="${common_labels}"/></td>
				
				<td  class='QUERYDATA' nowrap><%=apptdate_display%></td>
				
				<td class='label'  nowrap><fmt:message key="Common.appttime.label" bundle="${common_labels}"/></td>
				
				<td  class='QUERYDATA'nowrap><%=apptslabfmtime%> - <%=apptslabtotime%></td>
			</tr>
								
						<%if(overbookedyn.equals("Y")) {%>
						<tr><td class='label'  colspan='4' nowrap><fmt:message key="eOA.overbooking.label" bundle="${oa_labels}"/></td> </tr>
						<%}  else { %>
						
						<%}%>
    		
  	
	<tr> 
		<td class='COLUMNHEADER' colspan='4'><fmt:message key="eOA.TransferingAppointmentDetails.label" bundle="${oa_labels}"/></td>
	</tr>
		
    	<tr>
    		<td  class='label'  nowrap><fmt:message key="Common.resourcetype.label" bundle="${common_labels}"/></td>
			
			<td  class='QUERYDATA'  nowrap><%if(!function_mode.equals("")&&function_mode.equals("transfer")){%><%=new_res_class_desc%><%}else{%><%=res_class_desc%><%}%></td>

			<td  class='label'  nowrap><fmt:message key="Common.resource.label" bundle="${common_labels}"/></td> 

			<td  class='QUERYDATA'  nowrap><%=practitionerName%></td>
      
		</tr>
    			
    	<tr>
    			<td class='label'  nowrap><fmt:message key="Common.apptdate.label" bundle="${common_labels}"/></td>
			
				<td class='QUERYDATA' nowrap><%=i_appt_date_display%></td>
				
				<td align='right' class='label' width='16%' nowrap><fmt:message key="Common.appttime.label" bundle="${common_labels}"/></td>
				
				<%if(flag.equals("Visit_Reg")) {%>
			
					<td  class='QUERYDATA'nowrap><%=apptslabfmtime%> - <%=apptslabtotime%></td>

				<%}else
				{

//Below code was added by Venkatesh S on 25.06.2011 for SRR20056-SCF-7292 [IN:027301]
				
				
String t_from_time=i_from_time;
StringTokenizer t_st1 = new StringTokenizer(t_from_time,":");
 incr=0;
 while(t_st1.hasMoreTokens())
{
t_from_time_arry[incr]=t_st1.nextToken();
incr++;
}
t_from_hour=Integer.parseInt(t_from_time_arry[0]);
t_from_sec=Integer.parseInt(t_from_time_arry[1]);
/* usage of below code find out interval time between two time for transfer schedule.*/
 SimpleDateFormat format2 = new SimpleDateFormat("HH:mm"); 
 java.util.Date date_t1 = format2.parse(i_from_time); 
 java.util.Date date_t2 = format2.parse(i_to_time);
transfer_schedule_total_time_interval=date_t2.getTime()-date_t1.getTime();
 int m=  (int)(c_app_interval/60000)%60; //to calculate minutes
int hourss   = (int) (( c_app_interval/ 1000) / 3600); // to calculate hours

//end





				
				
				if(i_time_table_type.equals("3") && ! (apptrefno == null || apptrefno.equals("null") || apptrefno.equals(""))) 
				{  
				// Below code was added by Venkatesh S on 25.06.2011 for SRR20056-SCF-7292 [IN:027301]
				
			
				
				if( c_app_interval<=transfer_schedule_total_time_interval)
                {
           java.util.Calendar calendar = new GregorianCalendar(2007,Calendar.JANUARY,2, t_from_hour, t_from_sec);
          calendar.add(Calendar.HOUR,hourss );
          calendar.add(Calendar.MINUTE,m);
		  String correct_time=format2.format(calendar.getTime());
	     i_to_time=correct_time;
// end


}

				%>
					
					<td class='fields' nowrap>
					<input type='text' name='From_timeval' id='From_timeval' <%=over_readonly%> value='<%=i_from_time %>'  size='3' maxlength='5' onBlur='CheckTime(this,"FM")' onKeyUp="javascript:formatTimePerPatient(this)"> - <input type='text' name='To_timeval' id='To_timeval'   <%=over_readonly%> size='3' maxlength='5'  value='<%=i_to_time%>' onBlur='CheckTime(this,"TO")' onKeyUp="javascript:formatTimePerPatient(this)">
					</td>

				<% } else { %>
				<% if(i_to_time == null && i_from_time == null)  { %>
				
				<td  class='QUERYDATA' nowrap><%=i_from_time%> - <%=i_to_time%></td>
				
				<% } else {%>

					<td  class='QUERYDATA' nowrap><%=i_from_time%> - <%=i_to_time%></td>
				<%	 } 
				    }
				  }	%>
				</tr>
				
						<%if(to_over_book_yn.equals("Y")) {%>
					<tr>	
							<td  class='label'  nowrap colspan='4'><fmt:message key="eOA.overbooking.label" bundle="${oa_labels}"/></td>
					</tr>
						<%}  else { %>
						<%}%>


<%}%>

<%
	if((referral_line!=null && !(referral_line.equals(""))) || (referral_line1 !=null && !(referral_line1.equals("")))){
	%>
					
	
	<td width='100%'  colspan = 4 nowrap><fmt:message key="Common.referraldetails.label" bundle="${common_labels}"/></th>
					

	<tr><td   class='QUERYDATA' nowrap colspan = 4><%=referral_line%></td></tr>
	<tr><td   class='QUERYDATA' nowrap colspan = 4><%=referral_line1%></td></tr>	
	<%
	}
	%>


  <tr><td colspan = 4 class='COLUMNHEADER' ><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/> </td></tr>
  
 
    	<tr>
    		<td class='label'  nowrap> <fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
			<td class='QUERYDATA' nowrap><%=patientid%></td>
    		<td  class='label' nowrap><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
			<td  class='QUERYDATA' nowrap><%=patientname%></td>
    	</tr>

		<tr>
				<td  class='label' nowrap ><%=nat_id_prompt%></td>
				<td  class='QUERYDATA' ><%=nationalid%></td>
				<td class='label' colspan='2'>&nbsp;</td>
		</tr>
		<tr colspan='4'>
		<tr>
<%

			if(!ALT_ID1_EXP_DATE.equals(""))
	{
	 ALT_ID1_EXP_DATE_display=DateUtils.convertDate(ALT_ID1_EXP_DATE,"DMY","en",locale);
	}
	if(!ALT_ID2_EXP_DATE.equals(""))
	{
	 ALT_ID2_EXP_DATE_display=DateUtils.convertDate(ALT_ID2_EXP_DATE,"DMY","en",locale);
	}
	if(!ALT_ID3_EXP_DATE.equals(""))
	{
	 ALT_ID3_EXP_DATE_display=DateUtils.convertDate(ALT_ID3_EXP_DATE,"DMY","en",locale);
	}
	if(!ALT_ID4_EXP_DATE.equals(""))
	{
	 ALT_ID4_EXP_DATE_display=DateUtils.convertDate(ALT_ID4_EXP_DATE,"DMY","en",locale);
	}
%>
		<%if(!ALT_ID1_Desc.equals("")){%>

			<tr>
				<td  class='label' nowrap><%=ALT_ID1_Desc%></td>
				<td   class='QUERYDATA' nowrap><%=ALT_ID1_NO%></td>
				
			<%if(!ALT_ID1_EXP_DATE.equals("")) {%>
				<td  class='label'  nowrap><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td>
				<td  class='QUERYDATA' nowrap ><%=ALT_ID1_EXP_DATE_display%></td>
			<%}else {%>
				<td class='label' colspan =2>&nbsp;</td>
			<%}%>
			</tr>
			<%}%>

		   <tr>
				<td  class='label'  nowrap><%=ALT_ID2_Desc%></td>
				<td class='QUERYDATA' nowrap><%=ALT_ID2_NO%></td>
				
					<%if(!ALT_ID2_EXP_DATE.equals("")) {%>
				<td  class='label' nowrap><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td>
				<td  class='QUERYDATA' nowrap ><%=ALT_ID2_EXP_DATE_display%></td>
					<%}else {%>
				<td  class='label'  colspan =2></td>
					<%}%>
			</tr>


			<tr>
				<td  class='label' nowrap><%=ALT_ID3_Desc%></td>
				<td  class='QUERYDATA' nowrap><%=ALT_ID3_NO%></td>
					<%if(!ALT_ID3_EXP_DATE.equals("")) {%>
				<td  class='label'  nowrap><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td>
				<td class='QUERYDATA' nowrap ><%=ALT_ID3_EXP_DATE_display%></td>
					<%}else {%>
				<td  class='label' colspan =2></td>
					<%}%>
			</tr>


			<tr>
				<td  class='label'  nowrap><%=ALT_ID4_Desc%></td>
				<td  class='QUERYDATA' nowrap><%=ALT_ID4_NO%></td>
					<%if(!ALT_ID4_EXP_DATE.equals("")) {%>
				<td  class='label' nowrap><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td>
				<td  class='QUERYDATA' nowrap ><%=ALT_ID4_EXP_DATE_display%></td>
					<%}else {%>
				<td class='label' colspan=2></td>
					<%}%>
			</tr>

			<tr>
				<td class='label'  nowrap><fmt:message key="Common.OtherAltType.label" bundle="${common_labels}"/></td>
				
				<td  class='QUERYDATA' nowrap ><%=alt_type_desc%></td>

				<td class='label'  nowrap><fmt:message key="Common.otheraltid.label" bundle="${common_labels}"/></td>
				
				<td  class='QUERYDATA' nowrap ><%=OTH_ALT_ID_NO%></td>
			</tr>
			


		<tr>
				<td class='label' nowrap ><fmt:message key="Common.birthPlace.label" bundle="${common_labels}"/></td>
				<td  class='QUERYDATA' ><%=BIRTH_PLACE_DESC%></td>
			
				<td  class="label" nowrap><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
				<td class='QUERYDATA' nowrap><%=genderdesc%></td>
				

		</tr>

		<tr>
				<td   class='label' nowrap><fmt:message key="Common.age.label" bundle="${common_labels}"/></td>
				<td   class='QUERYDATA' nowrap><%=agey%>Y&nbsp;<%=agem%>M&nbsp;<%=aged%>D&nbsp;</td>
				<td   class='label'  nowrap><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/></td>
				<td   class='QUERYDATA' nowrap><%=dateofbirth_display%></td>
		</tr>

		<tr>
					<td  class='label'  nowrap ><fmt:message key="Common.residency.label" bundle="${common_labels}"/></td>
					<td  class='QUERYDATA' >
				<%if(CITIZEN_YN.equals("Y")){%>
					<fmt:message key="Common.citizen.label" bundle="${common_labels}"/>
				<%}else{%>
					<fmt:message key="Common.noncitizen.label" bundle="${common_labels}"/>
				<%}%>
					</td>
				
					<td  class='label'  nowrap ><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
					<td  class='QUERYDATA' >
				<%if(LEGAL_YN.equals("Y")){%>
					<fmt:message key="Common.legal.label" bundle="${common_labels}"/>
				<%}else{%>
					<fmt:message key="Common.illegal.label" bundle="${common_labels}"/>
				<%}%>	
					</td>
			
			</tr>

			<tr>
					<%if(!(nationalid.equals(""))){%>
					
						<td  class='label' nowrap ><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></td>
						<td class='QUERYDATA' ><%=nationality%></td>

						<td class='label'  nowrap ><fmt:message key="Common.race.label" bundle="${common_labels}"/></td>
						<td  class='QUERYDATA' ><%=RACE_DESC%></td>
					<%}else{%>
						<td  class='label' nowrap ><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></td>
						<td   class='QUERYDATA' ><%=nationality%></td>
						
						<td class='label'  nowrap ><fmt:message key="Common.race.label" bundle="${common_labels}"/></td>
						<td  class='QUERYDATA' ><%=RACE_DESC%></td>
					<%}%>   
			</tr>			
	<% 
				//String sql1="select alcn_criteria from oa_clinic_schedule where CLINIC_CODE='"+clinic_code+"' AND NVL (practitioner_id, 'X') = NVL ('"+practitioner_id+"', NVL (practitioner_id, 'X')) and clinic_date=to_date('"+i_appt_date+"','dd/mm/yyyy')";
				/*String sql1="select alcn_criteria from oa_clinic_schedule where CLINIC_CODE='"+frm_clinic_code+"' AND NVL (practitioner_id, 'X') = NVL ('"+practitionerid+"', NVL (practitioner_id, 'X')) and clinic_date=to_date('"+apptdate+"','dd/mm/yyyy')";
				rs1=stmt1.executeQuery(sql1);
				if(rs1!=null){
					if(rs1.next()){
						alcn=rs1.getString("alcn_criteria") ;
						if(alcn==null) alcn="";
                    }
				}*/
				String sql1="select to_char(start_time,'hh24:mi') start_time,to_char(end_time,'hh24:mi') end_time, alcn_criteria from oa_clinic_schedule where CLINIC_CODE='"+clinic_code+"' AND NVL (practitioner_id, 'X') = NVL ('"+practitioner_id+"', NVL (practitioner_id, 'X')) and clinic_date=to_date('"+i_appt_date+"','dd/mm/yyyy')";
				//out.println("<script>alert('pre_alcn_criteria:"+pre_alcn_criteria+"')</script>");
				//out.println("<script>alert('pre_alcn_catg_code:"+pre_alcn_catg_code+"')</script>");
				if(rs1!=null)rs1.close();
				rs1=stmt1.executeQuery(sql1);
				if(rs1!=null){
					if(rs1.next()){
						to_clinic_alcn=rs1.getString("alcn_criteria") ;
						starttime=rs1.getString("start_time") ;
						endtime=rs1.getString("end_time") ;
						if(to_clinic_alcn==null) to_clinic_alcn="";
                    }
				}
				if((pre_alcn_criteria!=null)&&(pre_alcn_criteria!="")){
					if(pre_alcn_catg_code!=null && pre_alcn_catg_code.equals("*O")){
						pre_cat_grp_desc="Others";
					}else{
						String statGrp_sql="select STAT_GRP_DESC from AM_STAT_GROUP where STAT_GRP_ID='"+pre_alcn_catg_code+"'";
						if(rs1!=null)rs1.close();
						rs1=stmt1.executeQuery(statGrp_sql);
						if(rs1!=null&&rs1.next())
							pre_cat_grp_desc=rs1.getString("STAT_GRP_DESC");
						if(rs1!=null)rs1.close();
					}
				}
				//out.println("<script>alert('pre_cat_grp_desc:"+pre_cat_grp_desc+"')</script>");
			   %>
			

					
		
			<tr>
	             <td  class='label'  nowrap><fmt:message key="eMP.ethnicity.label" bundle="${mp_labels}"/></td>
				 <td  class='QUERYDATA'  nowrap><%=ETHNIC_GROUP_DESC%></td>
				 <td class='button' colspan='2' align='right'>
				 	<input type='button' name='ContactDetails' id='ContactDetails' value='<fmt:message key="Common.ContactDetails.label" bundle="${common_labels}"/>' onClick='Modal_Contact_Details()' class="BUTTON" >
				
				 </td>
			</tr>
			<tr>
			    <%if((pre_alcn_criteria!=null)&&(pre_alcn_criteria!="")){%>
                <td  class='label'  nowrap><fmt:message key="eOA.Allocation.label" bundle="${oa_labels}"/> <fmt:message key="Common.category1.label" bundle="${common_labels}"/></td>
				<td class='QUERYDATA'  nowrap><%=pre_cat_grp_desc%></td>
				<%}%>
            </tr>
			


<tr><td colspan =4 class='COLUMNHEADER'><fmt:message key="Common.otherDetails.label" bundle="${common_labels}"/></td></tr>
			
			<tr>
			   <td  class='label'  nowrap><fmt:message key="Common.ContactReason.label" bundle="${common_labels}"/></td>
			   <td class='QUERYDATA' nowrap colspan = 3><%=reasondesc%></td>
			</tr>
			
			<tr>
				<td class='label'  nowrap><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
				<td  class='QUERYDATA' style='word-wrap: break-word;width:930px' colspan =3><%=apptremarks%></td><!--Modified by Thamizh selvi on 9th July 2018 against ML-MMOH-CRF-1058-->
			</tr>
			
			<tr>
				<td  class='label'  nowrap><fmt:message key="Common.contactmode.label" bundle="${common_labels}"/></td>

				<td  class='QUERYDATA'   nowrap><%=modedesc%></td>

				<td align='right' class='label' nowrap><fmt:message key="Common.ReceivingDateTime.label" bundle="${common_labels}"/></td>

				<td class='QUERYDATA'  nowrap><%=receiving_date_time_display%></td>
			</tr>
			

			<tr>
				<td  class='label' nowrap id="RecordedByID"><fmt:message key="Common.RecordedBy.label" bundle="${common_labels}"/></td>

				<td   class='QUERYDATA' nowrap><%=user_name%></td>
					
				<td align='right' class='label'  nowrap><fmt:message key="Common.RecordedOn.label" bundle="${common_labels}"/></td>

				<td align='left'  class='QUERYDATA'nowrap><%=record_date_display%></td>
			</tr>			
	
	<tr>
		<td colspan =4 class='WHITE' ></td>
	</tr>
	<%
	String showInstructionsYN="N";
	ResultSet qsRs=null;
	String sql4="select count(APPT_REF_NO)count from oa_appt_pat_instructions where facility_id='"+facilityid+"' and appt_ref_no='"+apptrefno1+"'";
	qsRs = stmtsd.executeQuery(sql4);
	if ( qsRs != null ){
		if(qsRs!=null && qsRs.next()){
			int patInscount =	qsRs.getInt("count");
			if(patInscount>0)			
				showInstructionsYN="Y";					
		}
	}
	if(qsRs !=null)qsRs.close();
	if(showInstructionsYN.equals("N")){
		sql4="select  count(APPT_REF_NO)count from oa_appt_proc_instructions where facility_id='"+facilityid+"' and appt_ref_no='"+apptrefno1+"'";
		qsRs = stmtsd.executeQuery(sql4);
		if ( qsRs != null ){
			if(qsRs!=null && qsRs.next()){
				int prcInscount =	qsRs.getInt("count");	
				if(prcInscount>0)
					showInstructionsYN="Y";					
			}
		}
		if(qsRs !=null)qsRs.close();
	}

%>
	</table>
<%

   if (patientid!="")
	{
	 String In_patient_status =  patdata.CheckInPatient(conn,patientid,facilityid);
	  if (In_patient_status.equals("CURRENTLY_IN_PATIENT"))
      {
		inpatient_yn="Y";
		%>
		<script>
		var err_age3 = getMessage( "CURRENTLY_IN_PATIENT","Common");
        alert(err_age3);
		</script>
		<%
      }
	  else
      {
		inpatient_yn="N";
      }
	}
%>



	<%
String tmp_ref_no=apptrefno;
if(tmp_ref_no.equals("~")) tmp_ref_no="";

	if(!flag.equals("Visit_Reg") && !flag.equals("Trans") && (!wtListControl.equals("B")))
	{       title=title.trim();
			if ((title.equalsIgnoreCase("Cancel") || title.equalsIgnoreCase("Cancellation")))
	       {
	%>

	<table border='0' cellpadding='0' cellspacing='0' width='98%' id='revisetxt' >
	<tr>
	   <td width="100%" >
<table border='0' cellpadding='0' cellspacing='0' width='100%' align='center'>
		
		<tr>
				<td  class='label'  width='20%' nowrap><fmt:message key="Common.ReasonforCancellation.label" bundle="${common_labels}"/></td>
											
				<td class='fields'>
				<!--displayRemarksForOtherReason() Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->
				<input type='text' name='reason_code_cancel' id='reason_code_cancel' value='' onblur='reasonlookup_blur(this);displayRemarksForOtherReason(reason_for_cancellation);' size=30 maxlength=30 ><input type='button' value='?' onclick='reasonlookup();displayRemarksForOtherReason(reason_for_cancellation);' class='button' name='reasonclick' id='reasonclick'><img src='../../eCommon/images/mandatory.gif'></img></td>	

				<!--Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->
				<td class=label id='remarks_labl' style='visibility:hidden'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
				<td class="fields" id='remarks_fld' style='visibility:hidden'><textarea rows=2 cols=45 name="other_remarks" onkeyPress='checkMaxLimit(this,100)' onBlur="SPCheckMaxLen('Remarks',this,100)"></textarea><img src='../../eCommon/images/mandatory.gif' id='remarks_img' style='visibility:hidden'></td>
				<!--End ML-MMOH-CRF-1114-->
         </tr>
		 					
				   <input type='hidden' name='reason_for_cancellation' id='reason_for_cancellation' value=''>
		 
		 <!--Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->
		 <tr>
			<td class='label' colspan=4>&nbsp;</td>
		 </tr>
				
				
				
	</table>
					</td>
				</tr>
	</table>


 <%} else {
  %>
  <table border='0' cellpadding='0' cellspacing='0' width='98%' align='center'>
						<tr>
							<td  class='label' nowrap><fmt:message key="eOA.ConfirmAppointment.label" bundle="${oa_labels}"/><input type =checkbox name='CnfmyesOrNo' id='CnfmyesOrNo' value ='Y' onClick='checkBoxValue(this)'>
							</td>
						</tr>
   </table>
 <% }
	 String ref_id="";
	ref_id=(String) session.getValue("ref_id");
	if(ref_id==null) ref_id="N";%>

	<%if(ref_id.equals("N")){%>	
		<%if(sec_cnt > 0) { %>
			<table border='0' cellpadding='0' cellspacing='0' width='100%' align='right' id='allbuttons'>
				<%} else {%>
				<table border='0' cellpadding='0' cellspacing='0' width='100%' align='right' id='allbuttons'>
					<%}%>
				<tr><td class = label colspan = 5></td></tr>
				<tr>
				<%
				stmt=conn.createStatement();
				if(rs!=null)rs.close();
				boolean patInsFlag=false;
				boolean procInsFlag=false;
				String appt_pat_ins="SELECT instruction_id,instruction_desc FROM oa_appt_pat_instructions WHERE facility_id = '"+facilityid+"' AND appt_ref_no = '"+apptrefno1+"' ORDER BY display_order";
				rs=stmt.executeQuery(appt_pat_ins);
				if(rs!=null && rs.next()){
					patInsFlag=true;
				} 
				//Modified against PMG20089-CRF-0885.3 - Removed the OrderID Validations on Radiology Appointment without PatientID:
				/****Below "IF" Condition Description: 
				If it is Radiology appointment with patientid, OR If it is Normal appointment, 
				then it will check if orderid exists to show instructions button.
				If it is Radiology appointment without patientid, then it will show instructions button
				*****/
				//if(order_id.equals("")){ 
				if( (("Y".equalsIgnoreCase(rd_appt_yn)) && (patientid != "") && order_id.equals("")) || ("N".equalsIgnoreCase(rd_appt_yn) && order_id.equals("")) )
				{
				}else{
						if(rs!=null)rs.close();
						String appt_prc_ins="SELECT instruction_desc FROM oa_appt_proc_instructions WHERE facility_id = '"+facilityid+"' AND appt_ref_no = '"+apptrefno1+"'";
						rs=stmt.executeQuery(appt_prc_ins);
						if(rs!=null && rs.next()){
							procInsFlag=true;
						}						
					}
				 	if(group_id.equals("")){
					if(patInsFlag || procInsFlag){%>
						<td width='90%'><input type='button' name='patInsbutton' id='patInsbutton' value='<fmt:message key="eAM.PatInstructions.label" bundle="${am_labels}"/>' onclick="show_patinstructions('<%=apptrefno1%>')"></td>
					<%}else{%>
							<td width='90%'>&nbsp;</td>
						<%}
					}else{%>
						<td width='90%'>&nbsp;</td>
					<%}%>				
				<td>
				<input type='button' name='vaudittria' id='vaudittria'  value='<fmt:message key="eOA.Viewaudittrial.label" bundle="${oa_labels}"/>' class="BUTTON" onclick='audittrial("<%=apptrefno1%>","<%=apptdate_display%>  <%=apptslabfmtime%> - <%=apptslabtotime%>","<%=care_locn_ind_desc%>/<%=clinicshortdesc%>","<%=res_class_desc%>/<%=URLEncoder.encode(practname)%>")' >
				</td>
				<% 

				if(group_id.equals("")){
				if(Forced.equals("N") && !calling_mode.equals("CAChange") || calling_mode.equals("OP") ){
					if(!calling_mode.equals("OR")|| calling_mode.equals("OP")) {
						if(!calling_mode.equals("IP")) {%>
							<td   align='right' >
							
							<input type='button' name='revappt' id='revappt' value='<fmt:message key="eOA.RescheduleAppointment.label" bundle="${oa_labels}"/>' class="BUTTON" onclick='sh_layer1("trans")' id='hid'>
								
							</td>
						<%}else {%>
						<input type='hidden' name='revappt' id='revappt' value=''>
							<%}%>
						<%}%>
					<%}else{%>
						<input type='hidden' name='revappt' id='revappt' value=''>
					<%}
				}else{%>
					<input type='hidden' name='revappt' id='revappt' value=''>
				<%}					

				//if(Forced.equals("N") && !calling_mode.equals("CAChange")|| calling_mode.equals("OP") ) {should cancel forced appointment from day schedule page.Added by sudhakar
				if(!calling_mode.equals("CAChange")|| calling_mode.equals("OP") ) {
					if(!calling_mode.equals("OR") || calling_mode.equals("OP")) {
						if(!calling_mode.equals("IP")) {%>	
							<td   align='right' >
								
							<input type='button' name='cancelappt' id='cancelappt' value='<fmt:message key="Common.CancelAppointment.label" bundle="${common_labels}"/>'  class="BUTTON" onclick='sh_layer()' id='canhid'>
							</td>
						<%}
					}
				}%>
						

				<%if(sec_cnt>0){%>
				<td colspan=6 align=right nowrap class='label'><input type='button' name='sec res' id='sec res' value='<fmt:message key="eOA.SecondaryResources.label" bundle="${oa_labels}"/>'  class="BUTTON" onclick="javascript:show_Reference_details('<%=tmp_ref_no%>','<%=facilityid%>')" ></td>
				
				<%}%>
				<td  align='right' ><input type='button' name='close' id='close' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>'  class="BUTTON" onclick='exitwin_normal(); '>
				</td>
				
			</tr>
		<%}else{%>
			<table border='0' cellpadding='0' cellspacing='0' width='5%' align='right' id='allbuttons'>

			<tr>
			<%if(sec_cnt>0){%>

				
					<td colspan=6 align=right nowrap class='label'><input type='button' name='sec res' id='sec res' value='<fmt:message key="eOA.SecondaryResources.label" bundle="${oa_labels}"/>'  class="BUTTON" onclick="javascript:show_Reference_details('<%=tmp_ref_no%>','<%=facilityid%>')" ></td>
					
				<%}%>
			<td  align='right'><input type='button' name='close' id='close' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>'  class="BUTTON" onclick='exitwin_normal()'>
			<input type='hidden' name='cancelappt' id='cancelappt' value=''>
			<input type='hidden' name='revappt' id='revappt' value=''>
			</td>
			</tr>
		<%}%>
				
		</table>
			<%	if(call_function_ip.equals("admit"))
				{	%>
					<table border='0' cellpadding='0' cellspacing='0' width='100%' align='right' id='ip_button' class='white'>	
						<tr>
						<%if(sec_cnt>0){%>

							<td  align=right nowrap class='white'><input type='button' name='sec res' id='sec res' value='<fmt:message key="eOA.SecondaryResources.label" bundle="${oa_labels}"/>'  class="BUTTON" onclick="javascript:show_Reference_details('<%=tmp_ref_no%>','<%=facilityid%>')" ></td>
								<%}%>
								
							<td  align='right' class='white'><input type='button' name='close' id='close' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>'  class="BUTTON" onclick='exitwin_normal()'>
				</td>
						</tr>
					</table>
			<%	}	%>
					<%	if(apptstatus.equals("A"))
					{	%>
					<table border='0' cellpadding='0' cellspacing='0' width='100%' align='right' id='reg_button' class='white'>	
						<tr>
						<%if(sec_cnt>0){%>

							<td  align=right nowrap class='white'><input type='button' name='sec res' id='sec res' value='<fmt:message key="eOA.SecondaryResources.label" bundle="${oa_labels}"/>'  class="BUTTON" onclick="javascript:show_Reference_details('<%=tmp_ref_no%>','<%=facilityid%>')" ></td>
							<%}%>
								
							<td  align='right' class='white'><input type='button' name='close' id='close' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>'  class="BUTTON" onclick='exitwin_normal()'></td>
							</tr>
					</table>
				<%	}	%>

                

					
<table border='0' cellpadding='0' cellspacing='0' width='98%' align='middle' id='cancelbuttons'>
			<tr>
					<td align='right' class='WHITE' width='75%'>&nbsp;
					</td>
					
                   
					<td   align='right' class='BODYCOLORFILLED'><input type='button' name='confcancel' id='confcancel' value='<fmt:message key="Common.confirm.label" bundle="${common_labels}"/> <fmt:message key="Common.Cancellation.label" bundle="${common_labels}"/>' class="BUTTON" onclick='valcheck1(this)'>
					</td>
					<%if(!flag.equals("cancel_appt") ){%>
					<td   align='right' class='BODYCOLORFILLED'><input type='button' name='abcancel' id='abcancel' value='<fmt:message key="Common.Abort.label" bundle="${common_labels}"/><fmt:message key="Common.Cancellation.label" bundle="${common_labels}"/>'  class="BUTTON" onclick='sh_focus()'>
					</td>
					<%}%>


					<%if(sec_cnt>0){%>

				
					<td colspan=6 align=right nowrap class='label'><input type='button' name='sec res' id='sec res' value='<fmt:message key="eOA.SecondaryResources.label" bundle="${oa_labels}"/>'  class="BUTTON" onclick="javascript:show_Reference_details('<%=tmp_ref_no%>','<%=facilityid%>')" ></td>
					
				<%}%>
				

					<td  align='right' class='BODYCOLORFILLED'><input type='button' name='cancelclose' id='cancelclose' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>'  class="BUTTON" onclick='exitwin();' >
					</td>

					
				</tr>
	</table>
	<BR>
	
<%}else if(!function_mode.equals("") && flag.equals("Trans")){//Transfer Appointment Starts
	HashMap patInstructionsMapResult=new java.util.HashMap();
	HashMap prcInstructionsMapResult=new java.util.HashMap();
	String instructionID="";
	String instructionDesc="";
	String valueObject="";
	String default_linked_yn="";
	int countPatInstructions=1;
	int countProcInstructions=1;
	String clinicInstr="";
	Integer tempInteger=null;
	String visibilityStr="hidden";
	String displayStr="None";
	if(frm_clinic_code.equals(clinic_code)){
		patInsSelectYN="Y";
		procInsSelectYN="Y";
		clinicInstr="SELECT a.instruction_id,a.display_order,a.default_linked_yn,b.instruction_desc FROM op_clinic_pat_instructions a, am_pat_instructions_lang_vw b  WHERE a.facility_id = '"+facilityid+"' AND a.clinic_code = '"+frm_clinic_code+"' AND a.instruction_id = b.instruction_id AND b.language_id = '"+locale+"' AND a.instruction_id not in(SELECT  INSTRUCTION_ID FROM OA_APPT_PAT_INSTRUCTIONS WHERE facility_id = '"+facilityid+"' AND appt_ref_no='"+apptrefno+"') ORDER BY display_order";
		String appt_pat_ins="SELECT instruction_id,instruction_desc FROM oa_appt_pat_instructions WHERE facility_id = '"+facilityid+"' AND appt_ref_no = '"+apptrefno+"' ORDER BY display_order";
		stmt=conn.createStatement();
		if(rs!=null)rs.close();
		rs=stmt.executeQuery(appt_pat_ins);
		while(rs!=null && rs.next()){
			instructionID=rs.getString("instruction_id");
			instructionDesc=rs.getString("instruction_desc");
			valueObject=instructionID+"|~"+instructionDesc+"|~Y";
			tempInteger=new Integer(countPatInstructions);
			patInstructionsMapResult.put(tempInteger.toString(),valueObject);
			countPatInstructions++;
		}
		if(rs!=null)rs.close();
		rs=stmt.executeQuery(clinicInstr);
		while(rs!=null && rs.next()){
			instructionID=rs.getString("instruction_id");
			instructionDesc=rs.getString("instruction_desc");
			default_linked_yn=rs.getString("DEFAULT_LINKED_YN");
			valueObject=instructionID+"|~"+instructionDesc+"|~N";
			tempInteger=new Integer(countPatInstructions);
			patInstructionsMapResult.put(tempInteger.toString(),valueObject);
			countPatInstructions++;
		}
		if(rs!=null)rs.close();
		if(countPatInstructions > 1){
			clinicInsYN="Y";
			session.setAttribute("patInstructionsMap", patInstructionsMapResult);
		}
	}else{//Transferring Appointment to a different clinic
		clinicInstr="Select a.INSTRUCTION_ID,a.DISPLAY_ORDER,a.DEFAULT_LINKED_YN,b.INSTRUCTION_DESC from op_clinic_pat_instructions a,am_pat_instructions_lang_vw b where a.facility_id='"+facilityid+"' and a.clinic_code='"+clinic_code+"' and a.INSTRUCTION_ID =b.INSTRUCTION_ID and b.language_id='"+locale+"' order by DISPLAY_ORDER";
		patInsSelectYN="N";
		procInsSelectYN="N";
		if(rs!=null)rs.close();
		stmt=conn.createStatement();
		rs=stmt.executeQuery(clinicInstr);
		while(rs!=null && rs.next()){
			instructionID=rs.getString("instruction_id");
			instructionDesc=rs.getString("instruction_desc");
			default_linked_yn=rs.getString("DEFAULT_LINKED_YN");
			valueObject=instructionID+"|~"+instructionDesc+"|~"+default_linked_yn;
			tempInteger=new Integer(countPatInstructions);
			patInstructionsMapResult.put(tempInteger.toString(),valueObject);
			countPatInstructions++;
		}
		if(rs!=null)rs.close();
		if(countPatInstructions > 1){
			clinicInsYN="Y";
			session.setAttribute("patInstructionsMap", patInstructionsMapResult);
			patInsSelectYN="Y";
		}
	}
	//Getting order catalog instructions  from DB Start
	//Modified against PMG20089-CRF-0885.3 - Removed the OrderID Validations on Radiology Appointment without PatientID:
	/****Below "IF" Condition Description: 
	If it is Radiology appointment with patientid, OR If it is Normal appointment, 
	then it will check if orderid exists to show instructions button.
	If it is Radiology appointment without patientid, then it will show instructions button
	*****/
	//if(order_id.equals("")){
	if( (("Y".equalsIgnoreCase(rd_appt_yn)) && (patientid != "") && order_id.equals("")) || ("N".equalsIgnoreCase(rd_appt_yn) && order_id.equals("")) ){
	}else{
		if(rs!=null)rs.close();
		String appt_prc_ins="SELECT instruction_desc FROM oa_appt_proc_instructions WHERE facility_id = '"+facilityid+"' AND appt_ref_no = '"+apptrefno+"'";
		rs=stmt.executeQuery(appt_prc_ins);
		if(rs!=null && rs.next()){
			String order_stand_ins=rs.getString("INSTRUCTION_DESC");
			prcInstructionsMapResult.put("prcIns",order_stand_ins);
			prcInstructionsMapResult.put("patient_id",patientid);
			prcInstructionsMapResult.put("checked","Y");
			countProcInstructions++;
		}
		if(countProcInstructions>1){
			orderInsYN="Y";
			procInsSelectYN="Y";
			session.setAttribute("prcInstructionMap", prcInstructionsMapResult);
		}
	}
	//Getting order catalog instructions  from DB End
	if(countPatInstructions > 1 || countProcInstructions >1){
		visibilityStr="visible";
		displayStr="";
	}
%>
<table border='0' cellpadding='0' cellspacing='0' width='98%' id='revisetxt1' >
		<tr>
			<td  class='label'nowrap width='23%'><fmt:message key="Common.ReasonforRevision.label" bundle="${common_labels}"/></td>
			
			<!--displayRemarksForRev() Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->
			<td class='fields' colspan='3'>			
			<input type='text' name='reason_for_revision' id='reason_for_revision' value='' onblur='reasonlookup_revise_blur(this);displayRemarksForRev(reason_code_revision);' size=30 maxlength=30 ><input type='button' value='?' onclick='reasonlookup_revise();displayRemarksForRev(reason_code_revision);' class='button' name='reasonclick' id='reasonclick'><img src='../../eCommon/images/mandatory.gif'></img>
			<input type='hidden' name='reason_code_revision' id='reason_code_revision' value=''></td>
			
			<%if(rule_based_tr.equals("Y") && prefPractYN.equals("N")){%>

			<!--displayRemarksForOvr() Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->
			<td  class='label'nowrap width='23%'><fmt:message key="eOA.ReasonForOverride.label" bundle="${oa_labels}"/></td>			
			<td class='fields'>			
			<input type='text' name='pract_override_reason_desc' id='pract_override_reason_desc' value='' onblur="reasonForOverride(this,pract_override_reason_desc,'<%=locale%>');displayRemarksForOvr(pract_override_reason);" size='35' maxlength='30'><input type='button' class='button' value='?'  name='search_reason' id='search_reason' onClick="reasonForOverrideLookup(this,pract_override_reason_desc,'<%=locale%>');displayRemarksForOvr(pract_override_reason);"><img id = 'pract_override_reason_img' src = '../../eCommon/images/mandatory.gif'></img><input type='hidden' name='pract_override_reason' id='pract_override_reason' value=''></td>
			
			<%}%>
		</tr>
		
		<!--Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->
		<tr>
			<td class=label id='rev_remarks_labl' style='visibility:hidden'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
			<td class="fields" id='rev_remarks_fld' style='visibility:hidden'><textarea rows=2 cols=45 name="rev_other_remarks" onkeyPress='checkMaxLimit(this,100)' onBlur="SPCheckMaxLen('Remarks',this,100)"></textarea><img src='../../eCommon/images/mandatory.gif' id='rev_remarks_img' style='visibility:hidden'></td>

			<td class=label id='ovr_remarks_labl' style='visibility:hidden'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
			<td class="fields" id='ovr_remarks_fld' style='visibility:hidden'><textarea rows=2 cols=45 name="ovr_other_remarks" onkeyPress='checkMaxLimit(this,100)' onBlur="SPCheckMaxLen('Remarks',this,100)"></textarea><img src='../../eCommon/images/mandatory.gif' id='ovr_remarks_img' style='visibility:hidden'></td>
		</tr>

		<tr>
			<td class='label' colspan=4>&nbsp;</td>
		</tr>
		<!--End ML-MMOH-CRF-1114-->
</table>

<table border='0' cellpadding='0' cellspacing='0' width='98%' align='center' id='allbuttons'>
	<tr>
	<td><input type='button' name='confrev' id='confrev' value='<fmt:message key="eOA.EditInstructructions.label" bundle="${oa_labels}"/>' class="BUTTON" onclick='PatInsModalWindow("<%=frm_clinic_code%>","<%=clinic_code%>")' style='visibility:<%=visibilityStr%>;display:<%=displayStr%>'></td>
	<%
		if(sec_cnt>0){
			if(to_over_book_yn.equals("N")){
				String secsql="select visit_type_code,resource_class,resource_type,resource_criteria from op_resource_type_for_appt where facility_id='"+facilityid+"' and visit_type_code='"+appttypecode+"' and resource_class !='"+res_type+"'  order by resource_class ";
				if (rs1!=null) rs1.close();
				rs1 = stmt1.executeQuery(secsql);
				while(rs1!=null && rs1.next()){
					 sec_resources=sec_resources+rs1.getString("resource_class");
					 sec_resources=sec_resources+"*"+rs1.getString("resource_criteria")+"-";
				}
				if(sec_resources.length()>1)
					sec_resources=sec_resources.substring(0,sec_resources.length()-1);
				}
				if(! sec_resources.equals("")){%>
					<td><input type='button' name='secres' id='secres' value='<fmt:message key="eOA.SecondaryResources.label" bundle="${oa_labels}"/>' class="BUTTON" onclick="show_second()"></td>
				<%}
		}
	%>
	<td   class='button' align='right'>						
		<input type='button' name='confrev' id='confrev' value='<fmt:message key="Common.ConfirmRevision.label" bundle="${common_labels}"/>' class="BUTTON" onclick='valcheck()'>&nbsp;
		<input type='button' name='cancelclose' id='cancelclose' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>'  class="BUTTON" onclick='parent.window.close()'>
	</td><!-- Transfer Appointment Ends-->
<%}else{
	%>
	<table border='0' cellpadding='0' cellspacing='0' width='99%' align='right' id='allbuttons'>
		<tr>
		<%	
	
		if(showInstructionsYN.equals("Y")){%>	
			<td width='99%'><input type="button" class="BUTTON" name="pat_ins" id="pat_ins" value='<fmt:message key="eAM.PatInstructions.label" bundle="${am_labels}"/>' onclick="show_patinstructions('<%=apptrefno1%>')"></td>
		<%}else{%>
			<td width='75%'>&nbsp;</td>
		<%}
					
				
				if(sec_cnt>0){
					if(to_over_book_yn.equals("N")){
						String secsql="select visit_type_code,resource_class,resource_type,resource_criteria from op_resource_type_for_appt where facility_id='"+facilityid+"' and visit_type_code='"+appttypecode+"' and resource_class !='"+res_type+"'  order by resource_class ";
						if (rs1!=null) rs1.close();
							rs1 = stmt1.executeQuery(secsql);
						while(rs1!=null && rs1.next()){
							 sec_resources=sec_resources+rs1.getString("resource_class");
							 sec_resources=sec_resources+"*"+rs1.getString("resource_criteria")+"-";
						 }
						 if(sec_resources.length()>1)
							 sec_resources=sec_resources.substring(0,sec_resources.length()-1);
					}
					if(! sec_resources.equals("")){%>

				
						<td colspan=6 align=right nowrap class='label'><input type='button' name='sec res' id='sec res' value='<fmt:message key="eOA.SecondaryResources.label" bundle="${oa_labels}"/>'  class="BUTTON" onclick="javascript:show_Reference_details('<%=tmp_ref_no%>','<%=facilityid%>')" ></td>					
					<%}
						
				}%>
				<td  align='right' class='BODYCOLORFILLED'><input type='button' name='reviseclose' id='reviseclose' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>'  class="BUTTON" onclick='exitwin()' style="margin-right: 15px;">
				</td>
			</tr>
	</table>
<% } %>

<%
if(!flag.equals("Visit_Reg") )
 {

if(canc_appt_yn.equalsIgnoreCase("N")){
if(!calling_mode.equals("CA")) {
	if(!calling_mode.equals("OR")) {
		if(!calling_mode.equals("")){%>
<script>
if(document.getElementById('cancelappt'))
	document.getElementById('cancelappt').disabled=true;
</script>
<%
		}
} 
}
}else if(canc_appt_yn.equalsIgnoreCase("Y") && !calling_mode.equals("CA") ){
if(!calling_mode.equals("OR")) {
	if(!calling_mode.equals("")){%>
<script>
if(document.getElementById('cancelappt'))
	document.getElementById('cancelappt').disabled=false;
</script>
<%
	}
}
}
 }

if(tfr_appt_yn.equalsIgnoreCase("N")){
if(!flag.equals("Visit_Reg") && function_mode.equals("") )
{
	if(!calling_mode.equals("CA")) {
if(!calling_mode.equals("OR")) { %>
<script>
if(document.getElementById('revappt'))
	document.getElementById('revappt').disabled=true;
</script>
<%
}
}
}		
}else{
if(!flag.equals("Visit_Reg") && function_mode.equals("") )
{
	if(!calling_mode.equals("CA")) {
if(!calling_mode.equals("OR")) {%>
<script>
if(document.getElementById('revappt'))
	document.getElementById('revappt').disabled=false;
</script>
<%
}
	}
}
}
%>




	<input type='hidden' name='flag' id='flag' value="<%=flag%>">
	<input type='hidden' name='apptstatus' id='apptstatus' value='<%=apptstatus%>'>
	<input type='hidden' name='function1' id='function1' value=''>
	<input type='hidden' name='function_name' id='function_name' value='insert'>
	<input type='hidden' name='transfer' id='transfer' value=<%= transfer %> >
	<input type='hidden' name='value13' id='value13' value=<%= value13 %> >
	<input type='hidden' name='new_from_time' id='new_from_time' value=<%=i_from_time %> >
	<input type='hidden' name='new_to_time' id='new_to_time' value=<%=i_to_time %> >
	<input type='hidden' name='appt_date' id='appt_date'  value=<%=i_appt_date%> >
	<input type='hidden' name='clinic_code' id='clinic_code' value=<%=clinic_code%> >
	<input type='hidden' name='practitioner_id' id='practitioner_id' value=<%=practitioner_id%> >
	<input type='hidden' name='dateapd' id='dateapd' value=<%=apptdate%> >
	<input type='hidden' name='over_booked' id='over_booked' value=<%=over_booked%> >
	<input type='hidden' name='overbooked_yn' id='overbooked_yn' value=<%=overbookedyn %> >
	<input type='hidden' name='ServerDate' id='ServerDate' value='<%=str13%>'>
	<input type='hidden' name='ServerTime' id='ServerTime' value='<%=str14%>' >
	<input type='hidden' name='old_date' id='old_date' value='<%=old_date%>'>
	<input type='hidden' name='visitind' id='visitind' value='<%=visitind%>' >
	<input type='hidden' name='patientid' id='patientid' value='<%=patientid%>' >
	<input type='hidden' name='patient_id' id='patient_id' value='<%=patientid%>' > <!--Added for the CRF Bru-HIMS-CCRF-169 -->
	<input type='hidden' name='old_from_time' id='old_from_time' value='<%=old_from_time%>' >
	<input type='hidden' name='old_to_time' id='old_to_time' value='<%=old_to_time%>' >
	<input type='hidden' name='pre_alcn_criteria' id='pre_alcn_criteria' value='<%=pre_alcn_criteria%>' >
	<input type='hidden' name='alcn_criteria' id='alcn_criteria' value='<%=alcn_criteria%>' >
	<input type='hidden' name='pre_pat_alcn_catg_code' id='pre_pat_alcn_catg_code' value='<%=pre_pat_alcn_catg_code%>' >
	<input type='hidden' name='alcn_catg_code' id='alcn_catg_code' value='<%=alcn_catg_code%>' >
	<input type='hidden' name='disp_date' id='disp_date' value='<%=apptdate%>' >
	<input type='hidden' name='contactvals' id='contactvals' value="<%=contactvals%>" >
	<input type='hidden' name='disp_fromtime' id='disp_fromtime' value='<%=disp_fromtime%>' >
	<input type='hidden' name='disp_totime' id='disp_totime' value='<%=disp_totime%>' >
	<input type='hidden' name='i_time_table_type' id='i_time_table_type' value='<%=i_time_table_type%>' >
	<input type='hidden' name='tfr_appt_across_catg_yn' id='tfr_appt_across_catg_yn' value='<%=tfr_appt_across_catg_yn%>' >
	<input type='hidden' name='obook_appt_yn' id='obook_appt_yn' value='<%=obook_appt_yn%>' >
	<input type='hidden' name='team_id' id='team_id' value='<%=team_id%>' >
	<input type='hidden' name='cancel_flag' id='cancel_flag' value="">
	<input type='hidden' name='resaddrl1' id='resaddrl1' value="<%=resaddrl1%>">
	<input type='hidden' name='resaddrl2' id='resaddrl2' value="<%=resaddrl2%>">
	<input type='hidden' name='resaddrl3' id='resaddrl3' value="<%=resaddrl3%>">
	<input type='hidden' name='resaddrl4' id='resaddrl4' value="<%=resaddrl4%>">
	<input type='hidden' name='postalcode' id='postalcode' value="<%=postalcode%>">
	<input type='hidden' name='countrycode' id='countrycode' value="<%=countrycode%>">
	<input type='hidden' name='Forced' id='Forced' value="<%=Forced%>">
	<input type='hidden' name='call_function_ip' id='call_function_ip' value='<%=call_function_ip%>'>
	<input type="hidden" name="clinic_type" id="clinic_type" value="<%=clinic_type%>">
	<input type="hidden" name="res_type" id="res_type" value="<%=res_type%>">
	<input type="hidden" name="referral_id" id="referral_id" value="<%=referral_id%>">
	<input type="hidden" name="referral_value" id="referral_value" value="">
	<input type='hidden' name='order_id' id='order_id' value='<%=order_id%>'>
	<input type='hidden' name='order_line_num' id='order_line_num' value='<%=order_line_num%>'>
	<input type='hidden' name='order_id1' id='order_id1' value='<%=order_id1%>'> <!--[IN027165]-->
	<input type="hidden" name="sec_resources" id="sec_resources" value="<%=sec_resources%>">
	<input type="hidden" name="sec_sel" id="sec_sel" value="">
	<input type='hidden' name='modified_date_time' id='modified_date_time' value='<%=modified_date_time%>'>
	<input type='hidden' name='no_of_slots' id='no_of_slots' value='<%=no_of_slots%>' >
	<input type='hidden' name='inpatient_yn' id='inpatient_yn' value='<%=inpatient_yn%>' >
	<input type='hidden' name='facilityid' id='facilityid' value='<%=facilityid%>' >
	<input type='hidden' name='visitshortdesc' id='visitshortdesc' value='<%=visitshortdesc%>'>
	<input type="hidden" name="appttypecode" id="appttypecode" value="<%=appttypecode%>">
	<input type='hidden' name='clinic_name_sec' id='clinic_name_sec' value='<%=clinicshortdesc%>'>
	<input type='hidden' name='care_locn_desc_sec' id='care_locn_desc_sec' value='<%=care_locn_ind_desc%>'>
	<input type='hidden' name='res_pri_class_desc' id='res_pri_class_desc' value='<%=res_class_desc%>'>
	<input type='hidden' name='pract_name_pri' id='pract_name_pri' value='<%=practname%>'>
	<input type='hidden' name='sys_date' id='sys_date' value='<%=str13%>'>
	<input type='hidden' name='sec_value_count' id='sec_value_count' value=''>
	<input type='hidden' name='speciality_code' id='speciality_code' value='<%=SPECIALITY_CODE%>'>
	<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
	<input type='hidden' name='capture_fin_dtls_yn' id='capture_fin_dtls_yn' value='<%=capture_fin_dtls_yn%>'>
	<input type='hidden' name='email_appl_yn' id='email_appl_yn' value='<%=email_appl_yn%>'>
	<input type='hidden' name='email_appl_for_appt_wo_pid_yn' id='email_appl_for_appt_wo_pid_yn' value='<%=email_appl_for_appt_wo_pid_yn%>'>
	<input type='hidden' name='emailid' id='emailid' value='<%=emailid%>'>
	<input type='hidden' name='pat_email_appl_yn' id='pat_email_appl_yn' value='<%=pat_email_appl_yn%>'>
	<input type='hidden' name='send_email_yn' id='send_email_yn' value='N'>
	<input type="hidden" name="sec_sel222" id="sec_sel222" value="">
	<input type="hidden" name="sec_resources_number" id="sec_resources_number" value="<%=xsec_res%>">
	<input type="hidden" name="sec_resources_selected" id="sec_resources_selected" value="">
	<input type="hidden" name="sec_resources_selected_222" id="sec_resources_selected_222" value="">
	<input type='hidden' name='reason_for_cancel' id='reason_for_cancel' value=''>
	<input type='hidden' name='episode_type' id='episode_type' value=''>
	<input type='hidden' name='count_wait_list' id='count_wait_list' value='<%=count%>'>
	<input type='hidden' name='slot_appt_ctrl' id='slot_appt_ctrl' value='<%=slot_appt_ctrl%>'>
	<input type='hidden' name='to_clinic_alcn' id='to_clinic_alcn' value='<%=to_clinic_alcn%>'>
	<input type='hidden' name='to_pat_alcn_cat' id='to_pat_alcn_cat' value=''>
	<input type='hidden' name='transfer_alcn_yn' id='transfer_alcn_yn' value='N'>
	<input type='hidden' name='tfr_alcn_override_yn' id='tfr_alcn_override_yn' value='N'>
	<input type='hidden' name='appointment_ref' id='appointment_ref' value='<%=apptrefno1%>'>
	<input type='hidden' name='to_over_book_yn' id='to_over_book_yn' value='<%=to_over_book_yn%>'>
	<input type="hidden" name='clinicInsYN' id='clinicInsYN' value='<%=clinicInsYN%>'>
	<input type="hidden" name='orderInsYN' id='orderInsYN' value='<%=orderInsYN%>'>
	<input type="hidden" name='patInsSelectYN' id='patInsSelectYN' value='<%=patInsSelectYN%>'>
	<input type="hidden" name='procInsSelectYN' id='procInsSelectYN' value='<%=procInsSelectYN%>'>
	<input type="hidden" name='i_appt_date_display' id='i_appt_date_display' value='<%=i_appt_date_display%>'>
	<input type='hidden' name='starttime' id='starttime' value='<%= starttime%>'>
	<input type='hidden' name='endtime' id='endtime' value='<%=endtime%>'>
	<input type='hidden' name='calling_mode' id='calling_mode' value='<%=calling_mode%>'>
	<input type='hidden' name='entitlement_by_pat_cat_yn' id='entitlement_by_pat_cat_yn' value='<%=entitlement_by_pat_cat_yn%>'>
	<!--<input type="hidden" name='orderInsStandardYN' id='orderInsStandardYN' value=''>--> 
	<input type='hidden' name='concat_address_hidden' id='concat_address_hidden' value="<%=contactAddress.toString()%>">
	<!--Below code was added by Venkatesh S on 11.06.2011 for SRR20056-SCF-7292 [IN:027301] -->
	
	<input type='hidden' name='apptslabfmtime' id='apptslabfmtime' value='<%=c_app_interval%>'>
	<input type='hidden' name='apptslabtotime' id='apptslabtotime' value='<%=transfer_schedule_total_time_interval%>'>
	<input type='hidden' name='rule_based_tr' id='rule_based_tr' value='<%=rule_based_tr%>'>
	<input type='hidden' name='rule_appl_yn' id='rule_appl_yn' value='<%=rule_appl_yn%>'>
	<input type='hidden' name='frm_clinic_code' id='frm_clinic_code' value='<%=frm_clinic_code%>'>
	<input type='hidden' name='frm_pract_id' id='frm_pract_id' value='<%=practitionerid%>'>
	<input type='hidden' name='wtListControl' id='wtListControl' value='<%=wtListControl%>'>
	<input type='hidden' name='rd_oa_integration_yn' id='rd_oa_integration_yn' value='<%=rd_oa_integration_yn%>'>
	<input type='hidden' name='orderCatMapped' id='orderCatMapped' value='<%=orderCatMapped%>'>
	<input type='hidden' name='rd_appt_yn' id='rd_appt_yn' value='<%=rd_appt_yn%>'>
	<input type='hidden' name='group_id' id='group_id' value='<%=group_id%>'>
	<!--Added for the CRF Bru-HIMS-CRF-169 start -->
	<input type='hidden' name='pat_cncl_count' id='pat_cncl_count' value='<%=pat_cncl_count%>'>
	<input type='hidden' name='pat_cancel_reason' id='pat_cancel_reason' value='<%=pat_cancel_reason%>'>
	<input type='hidden' name='max_cancel_appt' id='max_cancel_appt' value='<%=max_cancel_appt%>'>
	<!--Added for the CRF Bru-HIMS-CRF-169 end -->
	<!--Added for this incident ML-BRU-SCF-1602 [IN:055253]-->
	<input type='hidden' name='new_resource_class' id='new_resource_class' value='<%=new_resource_class%>'>
	<input type='hidden' name='function_mode' id='function_mode' value='<%=function_mode%>'> 
	<!--End ML-BRU-SCF-1602 [IN:055253]-->
	<input type='hidden' name='isAlternateAddressAppl' id='isAlternateAddressAppl' value="<%=isAlternateAddressAppl%>"><!--Added by Thamizh selvi on 2nd Feb 2018 against ML-MMOH-CRF-0601-->
	<!--Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->
	<input type='hidden' name='others_id' id='others_id' value='<%=others_id%>'>

<!-- Code Ends -->
	
<%contactAddress.setLength(0);%>
	
</form>
<%
	if (rs1 != null) rs1.close();
	if (rs2 != null) rs2.close();
	if (rs3 != null) rs3.close();
	if (rs4 != null) rs4.close();
    if (rs!= null) rs.close();
	if (rs_pat!= null) rs_pat.close();
	if(rs_reason !=null)rs_reason.close();
	if(rsgrp !=null)rsgrp.close();
	if ( rssd !=null) rssd.close();
	if (Rset_Nat_Id!= null) Rset_Nat_Id.close();
	if(stmtgrp!=null) stmtgrp.close();	
	if(stmtsd!=null) stmtsd.close();				
	if (stmt != null) stmt.close();
	if (stmt1 != null) stmt1.close();
	if (stmt2 != null) stmt2.close();
	if (stmt3 != null) stmt3.close();
	if (stmt4 != null) stmt4.close();
	if(stmt_reason !=null)stmt_reason.close();
	if (pstmt_pat != null) pstmt_pat.close();
	if (pstmt != null) pstmt.close();

}catch(Exception e) { 

	//out.println(e.toString());
	e.printStackTrace();

}finally{

	ConnectionManager.returnConnection(conn,request);
}%>
<%!
public static String checkForNull(String inputString)
{
	return ( ((inputString == null) || (inputString.equals("null"))) ? "" : inputString );
}
%>

</body>
</html>

