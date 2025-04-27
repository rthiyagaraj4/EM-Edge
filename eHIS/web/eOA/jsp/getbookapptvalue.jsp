
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,com.ehis.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>          
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%   
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
Map hash = (Map)obj.parseXMLString( request ) ;
hash = (Map)hash.get("SEARCH") ;
webbeans.op.PatientData patdata = new webbeans.op.PatientData();
Connection conn			=null;
String facilityid		=(String)session.getValue("facility_id");
String wait_list_num=(String)hash.get("wait_list_num");
String locale=(String)session.getAttribute("LOCALE");
String appt_clinic_code=(String)hash.get("clinic_id");
String pract_id=(String)hash.get("pract_id");
String alcn_criteria_pop=(String)hash.get("alcn_criteria_pop");
if(alcn_criteria_pop ==null) alcn_criteria_pop="";
String prm_res_class = (String)hash.get("prm_res_class");
if(prm_res_class ==null) prm_res_class="";
String req_id=(String)hash.get("req_id");
if(req_id ==null) req_id="";
String apptrefno=(String)hash.get("apptrefno");
if(apptrefno ==null) apptrefno="";
String callingMode=(String)hash.get("callingMode");
if(callingMode ==null) callingMode="";
String function_name=(String)hash.get("steps");
if(function_name ==null) function_name="";
String to_pract_id		="";
String alt_id1_exp_date	="";
String alt_id2_exp_date	="";
String alt_id3_exp_date	="";
String alt_id4_exp_date	="";

String c_name_prefix_accept_yn="";
String c_first_name_accept_yn="";
String c_second_name_accept_yn="";
String c_third_name_accept_yn="";
String c_family_name_accept_yn="";
String c_name_suffix_accept_yn="";
String wait_priority="";
String reason_for_transfer="";
String receiving_date_time="";
String contact_reason_code="";
String appt_remarks="";
String service_code="";
String mode_of_contact="";

String	BIRTH_PLACE_DESC="";
String	CITIZEN_YN="";
String	LEGAL_ILLEGAL_YN="";
String	RACE_CODE="";
String	RACE_DESC="";
String	ETHNIC_GRP_CODE="";
String	ETHNIC_GROUP_DESC="";
String	BIRTH_PLACE_CODE="";
String	birth_place_description="";
String	NATIONALITY_CODE="";
String patient_cat_code="";
String pat_cat_desc="";
String	NATIONALITY="";
String	ADDR_LINE1="";
String	ADDR_LINE2="";
String	ADDR_LINE3="";
String	ADDR_LINE4="";
String	REGION_CODE="";
String	REGION_DESC="";
String RES_COUNTRY_DESC="";
String	RES_AREA_CODE="";
String	RES_AREA_DESC="";
String	RES_TOWN_CODE="";
String	RES_TOWN_DESC="";
String	POSTAL_CODE="";
String	COUNTRY_CODE="";
String	COUNTRY_NAME="";
String	CONTACT1_NO="";
String	CONTACT2_NO="";
String	EMAIL_ID="";
String	MAIL_ADDR_LINE1="";
String	MAIL_ADDR_LINE2="";
String	MAIL_ADDR_LINE3="";
String	MAIL_ADDR_LINE4="";
String	MAIL_REGION_CODE="";
String	MAIL_REGION_DESC="";
String	MAIL_RES_AREA_CODE="";
String	MAIL_AREA_DESC="";
String	MAIL_RES_TOWN_CODE="";
String	MAIL_RES_TOWN_DESC="";
String	MAIL_POSTAL_CODE="";
String	MAIL_COUNTRY_CODE="";
String	MAIL_COUNTRY_NAME ="";
String	OTH_ALT_ID_NO="";
String	OTH_ALT_TYPE="";
/*Added by Thamizh selvi on 5th Feb 2018 against ML-MMOH-CRF-0601 Start*/
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
/*End*/

String alt_id1_exp_date_display="";
String alt_id2_exp_date_display="";
String alt_id3_exp_date_display="";
String alt_id4_exp_date_display="";
String receiving_date_time_display="";
String dateofbirth_display="";

String POSTAL_CODE_DESC="";
String MAIL_POSTAL_CODE_DESC="";

boolean count_referral	=false;
Statement stmt			=null;
int ip_bkgs = 0;
int rad_bkgs = 0;

Statement stmtap		=null;
Statement c_stmtn=null;
Statement stmt3=null;
Statement stmtpat=null;
Statement stmtc_p=null;
Statement stmt_wait_sec=null;
ResultSet rsc_p=null;
ResultSet rset=null;
ResultSet rs=null;
ResultSet rs3=null;
ResultSet rsap=null;
ResultSet c_rs=null;
ResultSet rspat=null;
ResultSet rs12=null;	
ResultSet rsappt=null;
ResultSet rs_wait_sec=null;
ResultSet rsappt_visit=null;
Statement stmt12=null;		

String patientid="";
String pat_cat_code="";
count_referral=true;
boolean valid_patient=true;
	String sqlm="";
	String appt_num = "";
	String language_id ="";
	String language_desc="";	
try{	
		conn			=ConnectionManager.getConnection(request);
		 stmtap		=conn.createStatement();
		 stmt			=conn.createStatement();
	 c_stmtn=conn.createStatement();
	if(count_referral){
		if(to_pract_id!=null && to_pract_id.equals(pract_id)){
			count_referral=true;			
		}
		if(count_referral){				
			String nationality_code="";

			c_rs=c_stmtn.executeQuery("select name_prefix_accept_yn, first_name_accept_yn,second_name_accept_yn,third_name_accept_yn,family_name_accept_yn,name_suffix_accept_yn from mp_param where module_id='MP'");
			c_rs.next();
			c_name_prefix_accept_yn=c_rs.getString(1);
			c_first_name_accept_yn=c_rs.getString(2);
			c_second_name_accept_yn=c_rs.getString(3);
			c_third_name_accept_yn=c_rs.getString(4);
			c_family_name_accept_yn=c_rs.getString(5);
			c_name_suffix_accept_yn=c_rs.getString(6);

			stmt=conn.createStatement();
			

			if(function_name.equals("Mr_appt"))
			{

				 sqlm="select PATIENT_ID, PATIENT_NAME,NAME_PREFIX,FIRST_NAME,SECOND_NAME,THIRD_NAME,FAMILY_NAME,NAME_SUFFIX,NATIONAL_ID_NO,ALT_ID1_TYPE,ALT_ID1_NO,ALT_ID2_TYPE,ALT_ID2_NO,ALT_ID3_TYPE,ALT_ID3_NO,ALT_ID4_TYPE,ALT_ID4_NO,OTH_ALT_ID_TYPE,OTH_ALT_ID_NO,GENDER,RACE_CODE,MP_GET_DESC.MP_RACE(RACE_CODE,'"+locale+"','1') RACE_DESC,ETHNIC_GRP_CODE,MP_GET_DESC.MP_ETHNIC_GROUP(ETHNIC_GRP_CODE,'"+locale+"','1') ETHNIC_DESC,BIRTH_PLACE_CODE,MP_GET_DESC.MP_BIRTH_PLACE(BIRTH_PLACE_CODE,'"+locale+"','1') BIRTH_PLACE_DESC,CITIZEN_YN,LEGAL_ILLEGAL_YN,RES_ADDR_LINE1,RES_ADDR_LINE2,RES_ADDR_LINE3,RES_ADDR_LINE4,RES_TOWN_CODE,MP_GET_DESC.MP_RES_TOWN(RES_TOWN_CODE,'"+locale+"','1') RES_TOWN_SHORT_DESC,RES_AREA_CODE,MP_GET_DESC.MP_RES_AREA(RES_AREA_CODE,'"+locale+"','1') RES_AREA_SHORT_DESC,RES_REGION_CODE, MP_GET_DESC.MP_REGION(RES_REGION_CODE,'"+locale+"','1') RES_REGION_SHORT_DESC,RES_POSTAL_CODE,MP_GET_DESC.MP_POSTAL_CODE(RES_POSTAL_CODE,'"+locale+"','2') POSTAL_CODE_DESC,MAIL_ADDR_LINE1,MAIL_ADDR_LINE2,MAIL_ADDR_LINE3,MAIL_ADDR_LINE4,MAIL_TOWN_CODE,MP_GET_DESC.MP_RES_TOWN(MAIL_TOWN_CODE,'"+locale+"','1') MAIL_TOWN_SHORT_DESC,MAIL_AREA_CODE, MP_GET_DESC.MP_RES_AREA(MAIL_AREA_CODE,'"+locale+"','1')  MAIL_AREA_SHORT_DESC,MAIL_REGION_CODE,MP_GET_DESC.MP_REGION(MAIL_REGION_CODE,'"+locale+"','1') MAIL_REGION_SHORT_DESC,MAIL_POSTAL_CODE,MP_GET_DESC.MP_POSTAL_CODE(MAIL_POSTAL_CODE,'"+locale+"','2') MAIL_POSTAL_CODE_DESC,MAIL_COUNTRY_CODE,MP_GET_DESC.MP_COUNTRY(MAIL_COUNTRY_CODE,'"+locale+"','1')MAIL_COUNTRY_LONG_DESC,MP_GET_DESC.MP_COUNTRY(RES_COUNTRY_CODE,'"+locale+"','1') RES_COUNTRY_DESC,APPL_RES_TEL_NO,APPL_MOB_TEL_NO,alt_id1_no,alt_id2_no,alt_id3_no,alt_id3_no,alt_id4_no,national_id_no,		to_char(ALT_ID1_EXP_DATE,'dd/mm/yyyy')alt_id1_exp_date,to_char(ALT_ID2_EXP_DATE,'dd/mm/yyyy') alt_id2_exp_date,to_char(ALT_ID3_EXP_DATE,'dd/mm/yyyy') alt_id3_exp_date,to_char(ALT_ID4_EXP_DATE,'dd/mm/yyyy') alt_id4_exp_date,NATIONALITY_CODE,MP_GET_DESC.MP_COUNTRY(NATIONALITY_CODE,'"+locale+"','1') NATIONALITY_DESC,date_of_birth,RES_TEL_NO,OTH_CONTACT_NO,EMAIL_ID ,NAME_PREFIX_LOC_LANG,FIRST_NAME_LOC_LANG,SECOND_NAME_LOC_LANG,THIRD_NAME_LOC_LANG,FAMILY_NAME_LOC_LANG,NAME_SUFFIX_LOC_LANG,PATIENT_NAME_LOC_LANG, alt_addr_line1, alt_addr_line2, alt_addr_line3, alt_addr_line4, alt_area_code, MP_GET_DESC.MP_RES_AREA(alt_area_code,'"+locale+"','1') alt_area_desc, alt_town_code, MP_GET_DESC.MP_RES_TOWN(alt_town_code,'"+locale+"','1') alt_town_desc, alt_region_code, MP_GET_DESC.MP_REGION(alt_region_code,'"+locale+"','1') alt_region_desc, alt_postal_code, MP_GET_DESC.mp_postal_code(alt_postal_code,'"+locale+"','2') alt_postal_desc, alt_country_code, MP_GET_DESC.MP_COUNTRY(alt_country_code,'"+locale+"','1') alt_country_desc from MR_REPORT_REQUEST_HDR where request_id='"+req_id+"' and FACILITY_ID='"+facilityid+"' ";//Modified by Thamizh selvi on 5th Jan 2018 against ML-MMOH-CRF-0601
				
			}else if(function_name.equals("OA_Modify_Appt") && (!callingMode.equals("RSCAPPT")))
			{
				sqlm="select PATIENT_ID, PATIENT_NAME,NAME_PREFIX,FIRST_NAME,SECOND_NAME,THIRD_NAME,FAMILY_NAME,NAME_SUFFIX,NATIONAL_ID_NO,ALT_ID1_TYPE,ALT_ID1_NO,ALT_ID2_TYPE,ALT_ID2_NO,ALT_ID3_TYPE,ALT_ID3_NO,ALT_ID4_TYPE,ALT_ID4_NO,OTH_ALT_ID_TYPE,OTH_ALT_ID_NO,GENDER,RACE_CODE,MP_GET_DESC.MP_RACE(RACE_CODE,'"+locale+"','1') RACE_DESC,ETHNIC_GROUP_CODE,MP_GET_DESC.MP_ETHNIC_GROUP(ETHNIC_GROUP_CODE,'"+locale+"','1') ETHNIC_DESC,BIRTH_PLACE_CODE,MP_GET_DESC.MP_BIRTH_PLACE(BIRTH_PLACE_CODE,'"+locale+"','1') BIRTH_PLACE_DESC,CITIZEN_YN,LEGAL_YN,RES_ADDR_LINE1,RES_ADDR_LINE2,RES_ADDR_LINE3,RES_ADDR_LINE4,RES_TOWN_CODE,MP_GET_DESC.MP_RES_TOWN(RES_TOWN_CODE,'"+locale+"','1') RES_TOWN_SHORT_DESC,RES_AREA_CODE,POSTAL_CODE,MP_GET_DESC.MP_POSTAL_CODE(POSTAL_CODE,'"+locale+"','2') POSTAL_CODE_DESC,COUNTRY_CODE,MP_GET_DESC.MP_COUNTRY(COUNTRY_CODE,'"+locale+"','1') NATIONALITY_DESC,MP_GET_DESC.MP_RES_AREA(RES_AREA_CODE,'"+locale+"','1') RES_AREA_SHORT_DESC,RES_REGION_CODE, MP_GET_DESC.MP_REGION(RES_REGION_CODE,'"+locale+"','1') RES_REGION_SHORT_DESC,MAIL_ADDR_LINE1,MAIL_ADDR_LINE2,MAIL_ADDR_LINE3,MAIL_ADDR_LINE4,MAIL_TOWN_CODE,MP_GET_DESC.MP_RES_TOWN(MAIL_TOWN_CODE,'"+locale+"','1') MAIL_TOWN_SHORT_DESC,MAIL_AREA_CODE, MP_GET_DESC.MP_RES_AREA(MAIL_AREA_CODE,'"+locale+"','1')  MAIL_AREA_SHORT_DESC,MAIL_REGION_CODE,MP_GET_DESC.MP_REGION(MAIL_REGION_CODE,'"+locale+"','1') MAIL_REGION_SHORT_DESC,MAIL_POSTAL_CODE,MP_GET_DESC.MP_POSTAL_CODE(MAIL_POSTAL_CODE,'"+locale+"','2') MAIL_POSTAL_CODE_DESC,MAIL_COUNTRY_CODE,MP_GET_DESC.MP_COUNTRY(MAIL_COUNTRY_CODE,'"+locale+"','1') MAIL_COUNTRY_LONG_DESC,MP_GET_DESC.MP_COUNTRY(RES_COUNTRY_CODE,'"+locale+"','1') RES_COUNTRY_DESC,alt_id1_no,alt_id2_no,alt_id3_no,alt_id3_no,alt_id4_no,national_id_no,		to_char(ALT_ID1_EXP_DATE,'dd/mm/yyyy')alt_id1_exp_date,to_char(ALT_ID2_EXP_DATE,'dd/mm/yyyy') alt_id2_exp_date,to_char(ALT_ID3_EXP_DATE,'dd/mm/yyyy') alt_id3_exp_date,to_char(ALT_ID4_EXP_DATE,'dd/mm/yyyy') alt_id4_exp_date,date_of_birth,RES_TEL_NO,OTH_CONTACT_NO,EMAIL_ID ,NAME_PREFIX_LOC_LANG,FIRST_NAME_LOC_LANG,SECOND_NAME_LOC_LANG,THIRD_NAME_LOC_LANG,FAMILY_NAME_LOC_LANG,NAME_SUFFIX_LOC_LANG,PATIENT_NAME_LOC_LANG,AM_GET_DESC.AM_CONTACT_REASON(CONTACT_REASON_CODE,'"+locale+"','1') CONTACT_REASON,CONTACT_REASON_CODE,to_char(RECEIVING_DATE_TIME,'dd/mm/yyyy hh24:mi') RECEIVING_DATE_TIME,APPT_REMARKS,MODE_OF_CONTACT,SERVICE_CODE,patient_cat_code,mp_get_desc.MP_PAT_CATEGORY(patient_cat_code,'"+locale+"',2) pat_cat_desc,language_id,mp_get_desc.MP_LANGUAGE(language_id,'"+locale+"',1)language_desc, alt_addr_line1, alt_addr_line2, alt_addr_line3, alt_addr_line4, alt_area_code, MP_GET_DESC.MP_RES_AREA(alt_area_code,'"+locale+"','1') alt_area_desc, alt_town_code, MP_GET_DESC.MP_RES_TOWN(alt_town_code,'"+locale+"','1') alt_town_desc, alt_region_code, MP_GET_DESC.MP_REGION(alt_region_code,'"+locale+"','1') alt_region_desc, alt_postal_code, MP_GET_DESC.mp_postal_code(alt_postal_code,'"+locale+"','2') alt_postal_desc, alt_country_code, MP_GET_DESC.MP_COUNTRY(alt_country_code,'"+locale+"','1') alt_country_desc from oa_appt where APPT_REF_NO='"+apptrefno+"' and FACILITY_ID='"+facilityid+"'";//Modified by Thamizh selvi on 5th Jan 2018 against ML-MMOH-CRF-0601
			}else if(callingMode.equals("RSCAPPT")){
				sqlm="select PATIENT_ID, PATIENT_NAME,NAME_PREFIX,FIRST_NAME,SECOND_NAME,THIRD_NAME,FAMILY_NAME,NAME_SUFFIX,NATIONAL_ID_NO,ALT_ID1_TYPE,ALT_ID1_NO,ALT_ID2_TYPE,ALT_ID2_NO,ALT_ID3_TYPE,ALT_ID3_NO,ALT_ID4_TYPE,ALT_ID4_NO,OTH_ALT_ID_TYPE,OTH_ALT_ID_NO,GENDER,RACE_CODE,MP_GET_DESC.MP_RACE(RACE_CODE,'"+locale+"','1') RACE_DESC,ETHNIC_GROUP_CODE,MP_GET_DESC.MP_ETHNIC_GROUP(ETHNIC_GROUP_CODE,'"+locale+"','1') ETHNIC_DESC,BIRTH_PLACE_CODE,MP_GET_DESC.MP_BIRTH_PLACE(BIRTH_PLACE_CODE,'"+locale+"','1') BIRTH_PLACE_DESC,CITIZEN_YN,LEGAL_YN,RES_ADDR_LINE1,RES_ADDR_LINE2,RES_ADDR_LINE3,RES_ADDR_LINE4,RES_TOWN_CODE,MP_GET_DESC.MP_RES_TOWN(RES_TOWN_CODE,'"+locale+"','1') RES_TOWN_SHORT_DESC,RES_AREA_CODE,POSTAL_CODE,MP_GET_DESC.MP_POSTAL_CODE(POSTAL_CODE,'"+locale+"','2') POSTAL_CODE_DESC,COUNTRY_CODE,MP_GET_DESC.MP_COUNTRY(COUNTRY_CODE,'"+locale+"','1') NATIONALITY_DESC,MP_GET_DESC.MP_RES_AREA(RES_AREA_CODE,'"+locale+"','1') RES_AREA_SHORT_DESC,RES_REGION_CODE, MP_GET_DESC.MP_REGION(RES_REGION_CODE,'"+locale+"','1') RES_REGION_SHORT_DESC,MAIL_ADDR_LINE1,MAIL_ADDR_LINE2,MAIL_ADDR_LINE3,MAIL_ADDR_LINE4,MAIL_TOWN_CODE,MP_GET_DESC.MP_RES_TOWN(MAIL_TOWN_CODE,'"+locale+"','1') MAIL_TOWN_SHORT_DESC,MAIL_AREA_CODE, MP_GET_DESC.MP_RES_AREA(MAIL_AREA_CODE,'"+locale+"','1')  MAIL_AREA_SHORT_DESC,MAIL_REGION_CODE,MP_GET_DESC.MP_REGION(MAIL_REGION_CODE,'"+locale+"','1') MAIL_REGION_SHORT_DESC,MAIL_POSTAL_CODE,MP_GET_DESC.MP_POSTAL_CODE(MAIL_POSTAL_CODE,'"+locale+"','2') MAIL_POSTAL_CODE_DESC,MAIL_COUNTRY_CODE,MP_GET_DESC.MP_COUNTRY(MAIL_COUNTRY_CODE,'"+locale+"','1') MAIL_COUNTRY_LONG_DESC,MP_GET_DESC.MP_COUNTRY(RES_COUNTRY_CODE,'"+locale+"','1') RES_COUNTRY_DESC,alt_id1_no,alt_id2_no,alt_id3_no,alt_id3_no,alt_id4_no,national_id_no,		to_char(ALT_ID1_EXP_DATE,'dd/mm/yyyy')alt_id1_exp_date,to_char(ALT_ID2_EXP_DATE,'dd/mm/yyyy') alt_id2_exp_date,to_char(ALT_ID3_EXP_DATE,'dd/mm/yyyy') alt_id3_exp_date,to_char(ALT_ID4_EXP_DATE,'dd/mm/yyyy') alt_id4_exp_date,date_of_birth,RES_TEL_NO,OTH_CONTACT_NO,EMAIL_ID ,NAME_PREFIX_LOC_LANG,FIRST_NAME_LOC_LANG,SECOND_NAME_LOC_LANG,THIRD_NAME_LOC_LANG,FAMILY_NAME_LOC_LANG,NAME_SUFFIX_LOC_LANG,PATIENT_NAME_LOC_LANG,AM_GET_DESC.AM_CONTACT_REASON(CONTACT_REASON_CODE,'"+locale+"','1') CONTACT_REASON,CONTACT_REASON_CODE,to_char(RECEIVING_DATE_TIME,'dd/mm/yyyy hh24:mi') RECEIVING_DATE_TIME,APPT_REMARKS,MODE_OF_CONTACT,SERVICE_CODE,patient_cat_code,mp_get_desc.MP_PAT_CATEGORY(patient_cat_code,'"+locale+"',2) pat_cat_desc,language_id,mp_get_desc.MP_LANGUAGE(language_id,'"+locale+"',1)language_desc, alt_addr_line1, alt_addr_line2, alt_addr_line3, alt_addr_line4, alt_area_code, MP_GET_DESC.MP_RES_AREA(alt_area_code,'"+locale+"','1') alt_area_desc, alt_town_code, MP_GET_DESC.MP_RES_TOWN(alt_town_code,'"+locale+"','1') alt_town_desc, alt_region_code, MP_GET_DESC.MP_REGION(alt_region_code,'"+locale+"','1') alt_region_desc, alt_postal_code, MP_GET_DESC.mp_postal_code(alt_postal_code,'"+locale+"','2') alt_postal_desc, alt_country_code, MP_GET_DESC.MP_COUNTRY(alt_country_code,'"+locale+"','1') alt_country_desc from oa_appt_del_tr where APPT_REF_NO='"+apptrefno+"' and FACILITY_ID='"+facilityid+"'";//Modified by Thamizh selvi on 5th Jan 2018 against ML-MMOH-CRF-0601
			}else
			
			{
			sqlm="select patient_id,patient_name,name_prefix,first_name,second_name,third_name,family_name,			name_suffix,GENDER,date_of_birth,BIRTH_PLACE_CODE,MP_GET_DESC.MP_BIRTH_PLACE(BIRTH_PLACE_CODE,'"+locale+"','1') BIRTH_PLACE_DESC,birth_place_description,CITIZEN_YN,LEGAL_YN,RACE_CODE,MP_GET_DESC.MP_ETHNIC_GROUP(ETHNIC_GROUP_CODE,'"+locale+"','1') ETHNIC_GROUP_DESC ,ETHNIC_GROUP_CODE,MP_GET_DESC.MP_RACE(RACE_CODE,'"+locale+"','1') RACE_DESC,NATIONALITY,RES_ADDR_LINE1,RES_ADDR_LINE2,RES_ADDR_LINE3,RES_ADDR_LINE4,RES_REGION_CODE,MP_GET_DESC.MP_REGION(RES_REGION_CODE,'"+locale+"','1') RES_REGION_DESC,RES_AREA_CODE,MP_GET_DESC.MP_RES_AREA(RES_AREA_CODE,'"+locale+"','1') RES_AREA_DESC,RES_TOWN_CODE, MP_GET_DESC.MP_RES_TOWN(RES_TOWN_CODE,'"+locale+"','1') RES_TOWN_DESC,RES_POSTAL_CODE,MP_GET_DESC.MP_POSTAL_CODE(RES_POSTAL_CODE,'"+locale+"','2') POSTAL_CODE_DESC,COUNTRY_CODE,		RES_TEL_NO,OTH_CONTACT_NO,EMAIL_ID,MAIL_ADDR_LINE1,MAIL_ADDR_LINE2,MAIL_ADDR_LINE3,MAIL_ADDR_LINE4,MAIL_REGION_CODE,MP_GET_DESC.MP_REGION(MAIL_REGION_CODE,'"+locale+"','1') MAIL_REGION_DESC,MAIL_TOWN_CODE,MP_GET_DESC.MP_RES_TOWN(MAIL_TOWN_CODE,'"+locale+"','1') MAIL_TOWN_DESC,MP_GET_DESC.MP_RES_AREA(MAIL_AREA_CODE,'"+locale+"','1')  MAIL_AREA_DESC,MAIL_POSTAL_CODE,MP_GET_DESC.MP_POSTAL_CODE(MAIL_POSTAL_CODE,'"+locale+"','2') MAIL_POSTAL_CODE_DESC,MP_GET_DESC.MP_COUNTRY(RES_COUNTRY_CODE,'"+locale+"','1') RES_COUNTRY_DESC,MAIL_COUNTRY_CODE,MP_GET_DESC.MP_COUNTRY(MAIL_COUNTRY_CODE,'"+locale+"','1') MAIL_COUNTRY_NAME,WAIT_LIST_PRIORITY,alt_id1_no,alt_id2_no,alt_id3_no,alt_id3_no,alt_id4_no,national_id_no,		to_char(ALT_ID1_EXP_DATE,'dd/mm/yyyy')alt_id1_exp_date,to_char(ALT_ID2_EXP_DATE,'dd/mm/yyyy') alt_id2_exp_date,to_char(ALT_ID3_EXP_DATE,'dd/mm/yyyy') alt_id3_exp_date,to_char(ALT_ID4_EXP_DATE,'dd/mm/yyyy') alt_id4_exp_date,OTH_ALT_ID_NO,OTH_ALT_ID_TYPE,BOOKING_REF_NO,NAME_PREFIX_LOC_LANG,FIRST_NAME_LOC_LANG,SECOND_NAME_LOC_LANG,THIRD_NAME_LOC_LANG,FAMILY_NAME_LOC_LANG,NAME_SUFFIX_LOC_LANG,PATIENT_NAME_LOC_LANG, alt_addr_line1, alt_addr_line2, alt_addr_line3, alt_addr_line4, alt_area_code, MP_GET_DESC.MP_RES_AREA(alt_area_code,'"+locale+"','1') alt_area_desc, alt_town_code, MP_GET_DESC.MP_RES_TOWN(alt_town_code,'"+locale+"','1') alt_town_desc, alt_region_code, MP_GET_DESC.MP_REGION(alt_region_code,'"+locale+"','1') alt_region_desc, alt_postal_code, MP_GET_DESC.mp_postal_code(alt_postal_code,'"+locale+"','2') alt_postal_desc, alt_country_code, MP_GET_DESC.MP_COUNTRY(alt_country_code,'"+locale+"','1') alt_country_desc from PR_WAIT_LIST where Facility_id='"+facilityid+"' and  WAIT_LIST_NO='"+wait_list_num+"'";//Modified by Thamizh selvi on 5th Jan 2018 against ML-MMOH-CRF-0601
		
			}
			
			rset=stmt.executeQuery(sqlm);

			if(rset!=null) {
			if(rset.next()){
			patientid=rset.getString("patient_id");
			if (patientid==null) patientid="";

			if(!patientid.equals("")) {
				String chkst=patdata.CheckStatus(conn,patientid);
				if(chkst.equals("DECEASED")) {
					valid_patient=false;
					%>
					var err_age1 = getMessage( "DECEASED_NOT_ALLOWED","OA" ) ;	
					alert(err_age1);
					clear_all_fun1("R");
					<%
				}else if(chkst.equals("SUSPENDED")) {
					valid_patient=false;
					%>
					var err_age2 = getMessage( "SUSPENDED_NOT_ALLOWED","OA" ) ;
					alert(err_age2);
					clear_all_fun1("R");
					<%
			    }else if(chkst.equals("INACTIVE")) {
					valid_patient=false;
					%>
					var err_age3 = getMessage( "INACTIVE_PATIENT","OA" ) ;
					alert(err_age3);
					clear_all_fun1("R");
					<%
			   }else if(chkst.equals("INVALID_PATIENT")) {
					valid_patient=false;
					%>
					var err_age3 = getMessage( "INVALID_PATIENT","MP" ) ;
					alert(err_age3);
					clear_all_fun1("R");
			<% }
		}	

	if(function_name.equals("wt_list"))
			{

		if(!patientid.equals("")){
		stmtc_p =conn.createStatement();
		String sqlch = "select count(1) cnt from op_clinic a where clinic_code ='"+appt_clinic_code+"' and  ((age_group_code is null ) or ((age_group_code is not null) and  exists (select age_group.age_group_code from am_age_group age_group,PR_WAIT_LIST patient where patient.wait_list_no ='"+wait_list_num+"' and age_group.age_group_code=a.age_group_code and nvl(age_group.gender,patient.gender)=patient.gender and trunc(sysdate)-trunc(patient.date_of_birth) between decode(age_group.age_unit,'Y',365,'M',30,1)*age_group.min_age and decode(age_group.age_unit,'Y',365,'M',30,1)*age_group.max_age and age_group.eff_status='E' ))) and facility_id = '"+facilityid+"'" ;
		
		rsc_p=stmtc_p.executeQuery(sqlch);
		int cnt =0;

		if(rsc_p.next()) {
		cnt = rsc_p.getInt("cnt");
			if (cnt==0){
				valid_patient=false;
				%>
		var err_age = getMessage( "AGE_GENDER_NOT_MATCH","OA" ) ;
			alert(err_age);
				clear_all_fun1("R");
				<%
				valid_patient=false;
				
			}
		}

		if (rsc_p !=null) rsc_p.close();
		}
			}

		if((patientid.equals("")&&(valid_patient))||((!patientid.equals(""))&&(valid_patient))) {

			String patientname=rset.getString("patient_name");
			String patientname_local_lang =rset.getString("PATIENT_NAME_LOC_LANG");
			if(patientname_local_lang ==null) patientname_local_lang="";
			if(patientname == null) patientname="";
			if(function_name.equals("wt_list") || function_name.equals("OA_Modify_Appt") || callingMode.equals("RSCAPPT"))
			{
			nationality_code=rset.getString("country_Code");

			}else
			{
				nationality_code=rset.getString("NATIONALITY_CODE");
			}
			 if(nationality_code==null)	 nationality_code="";
			String dis_facility="";
			String pref_facility_id="";
			
			String SEX="";
			String nationalid=null;
			String alternateid=null;
			String alternateid1=null;
			String alternateid3=null;
			String alternateid4=null;
			String prefix=rset.getString("name_prefix");
			String firstname=rset.getString("first_name");

			if(function_name.equals("wt_list"))
			{

			 appt_num = rset.getString("BOOKING_REF_NO");
			 wait_priority	=rset.getString("WAIT_LIST_PRIORITY");

			}
			if(firstname==null)	 
				firstname="";
			String secondname=rset.getString("second_name");
			if(secondname==null)
				secondname="";
			String thirdname=rset.getString("third_name");
			if(thirdname==null)
				thirdname="";

			String familyname=rset.getString("family_name");
			 if(familyname==null) familyname="";
			
			BIRTH_PLACE_DESC=rset.getString("BIRTH_PLACE_DESC");
			 if(BIRTH_PLACE_DESC==null) BIRTH_PLACE_DESC="";

			CITIZEN_YN=rset.getString("CITIZEN_YN");
			 if(CITIZEN_YN==null) CITIZEN_YN="";
			if(function_name.equals("wt_list")  || function_name.equals("OA_Modify_Appt") || callingMode.equals("RSCAPPT"))
			{
			LEGAL_ILLEGAL_YN=rset.getString("LEGAL_YN");
			}else
			{
				LEGAL_ILLEGAL_YN=rset.getString("LEGAL_ILLEGAL_YN");
			}
			 if(LEGAL_ILLEGAL_YN==null) LEGAL_ILLEGAL_YN="";

			RACE_CODE=rset.getString("RACE_CODE");
			 if(RACE_CODE==null) RACE_CODE="";

			RACE_DESC=rset.getString("RACE_DESC");
			 if(RACE_DESC==null) RACE_DESC="";
			if(function_name.equals("wt_list") || function_name.equals("OA_Modify_Appt") || callingMode.equals("RSCAPPT"))
			{
			ETHNIC_GRP_CODE=rset.getString("ETHNIC_GROUP_CODE");
			}else
			{
			ETHNIC_GRP_CODE=rset.getString("ETHNIC_GRP_CODE");
			}
			 if(ETHNIC_GRP_CODE==null) ETHNIC_GRP_CODE="";

			if(function_name.equals("wt_list") )
			{
			ETHNIC_GROUP_DESC=rset.getString("ETHNIC_GROUP_DESC");
			}else if(function_name.equals("Mr_appt") || function_name.equals("OA_Modify_Appt") || callingMode.equals("RSCAPPT"))
			{
			ETHNIC_GROUP_DESC=rset.getString("ETHNIC_DESC");
			}

			 if(ETHNIC_GROUP_DESC==null) ETHNIC_GROUP_DESC="";
			BIRTH_PLACE_CODE=rset.getString("BIRTH_PLACE_CODE");
			 if(BIRTH_PLACE_CODE==null) BIRTH_PLACE_CODE="";

			if(function_name.equals("wt_list"))
			{
			birth_place_description=rset.getString("birth_place_description");
			}else	
			{
			birth_place_description=rset.getString("BIRTH_PLACE_DESC");
			}
			 if(birth_place_description==null) birth_place_description="";

			if(function_name.equals("wt_list"))
			{
			NATIONALITY_CODE=rset.getString("country_code");
			NATIONALITY=rset.getString("NATIONALITY");
			 if(NATIONALITY==null) NATIONALITY="";
			}else if(function_name.equals("Mr_appt"))
			{
				NATIONALITY_CODE=rset.getString("NATIONALITY_CODE");
				NATIONALITY=rset.getString("NATIONALITY_DESC");
				COUNTRY_NAME=rset.getString("NATIONALITY_DESC");
			}else if(function_name.equals("OA_Modify_Appt") || callingMode.equals("RSCAPPT"))
			{
					
					NATIONALITY_CODE = rset.getString("country_code")==null?"":rset.getString("country_code");
					NATIONALITY = rset.getString("NATIONALITY_DESC")==null?"":rset.getString("NATIONALITY_DESC");
			}
							if(NATIONALITY_CODE==null) NATIONALITY_CODE="";
			


			ADDR_LINE1=rset.getString("RES_ADDR_LINE1");
			 if(ADDR_LINE1==null) ADDR_LINE1="";

			ADDR_LINE2=rset.getString("RES_ADDR_LINE2");
			 if(ADDR_LINE2==null) ADDR_LINE2="";

			ADDR_LINE3=rset.getString("RES_ADDR_LINE3");
			 if(ADDR_LINE3==null) ADDR_LINE3="";

			ADDR_LINE4=rset.getString("RES_ADDR_LINE4");
			 if(ADDR_LINE4==null) ADDR_LINE4="";

			REGION_CODE=rset.getString("RES_REGION_CODE");
			 if(REGION_CODE==null) REGION_CODE="";
			if(function_name.equals("wt_list"))
			{
			REGION_DESC=rset.getString("RES_REGION_DESC");
			}else
			{
			REGION_DESC=rset.getString("RES_REGION_SHORT_DESC");
			}
			 if(REGION_DESC==null) REGION_DESC="";

			RES_AREA_CODE=rset.getString("RES_AREA_CODE");
			 if(RES_AREA_CODE==null) RES_AREA_CODE="";
			if(function_name.equals("wt_list"))
			{
			RES_AREA_DESC=rset.getString("RES_AREA_DESC");
			}else
			{
			RES_AREA_DESC=rset.getString("RES_AREA_SHORT_DESC");
			}
			 if(RES_AREA_DESC==null) RES_AREA_DESC="";

			RES_TOWN_CODE=rset.getString("RES_TOWN_CODE");
			 if(RES_TOWN_CODE==null) RES_TOWN_CODE="";
			if(function_name.equals("wt_list"))
			{
			RES_TOWN_DESC=rset.getString("RES_TOWN_DESC");
			}else
			{
			RES_TOWN_DESC=rset.getString("RES_TOWN_SHORT_DESC");
			}
		 if(RES_TOWN_DESC==null) RES_TOWN_DESC="";
			if(function_name.equals("OA_Modify_Appt") || callingMode.equals("RSCAPPT"))
			{
			POSTAL_CODE=rset.getString("POSTAL_CODE");
			 if(POSTAL_CODE==null) POSTAL_CODE="";

			 POSTAL_CODE_DESC=rset.getString("POSTAL_CODE_DESC");
			 if(POSTAL_CODE_DESC==null) POSTAL_CODE_DESC="";

			}else
			{
				POSTAL_CODE=rset.getString("RES_POSTAL_CODE");
			 if(POSTAL_CODE==null) POSTAL_CODE="";
			}
			if(function_name.equals("wt_list"))
			{
			COUNTRY_CODE=rset.getString("COUNTRY_CODE");
			 if(COUNTRY_CODE==null) COUNTRY_CODE="";
			
			COUNTRY_NAME=rset.getString("Nationality");//doubt
			 if(COUNTRY_NAME==null) COUNTRY_NAME="";
			}else if(function_name.equals("Mr_appt"))
			{
			COUNTRY_CODE=rset.getString("NATIONALITY_CODE");
			}else if(function_name.equals("OA_Modify_Appt") || callingMode.equals("RSCAPPT"))
			{
				COUNTRY_CODE=rset.getString("COUNTRY_CODE");
			 if(COUNTRY_CODE==null) COUNTRY_CODE="";
			}
			CONTACT1_NO=rset.getString("RES_TEL_NO");
			
			 if(CONTACT1_NO==null) CONTACT1_NO="";
			
			CONTACT2_NO=rset.getString("OTH_CONTACT_NO");
			 if(CONTACT2_NO==null) CONTACT2_NO="";

			
			EMAIL_ID=rset.getString("EMAIL_ID");
			
			 if(EMAIL_ID==null) EMAIL_ID="";

		
			MAIL_ADDR_LINE1=rset.getString("MAIL_ADDR_LINE1");
			 if(MAIL_ADDR_LINE1==null) MAIL_ADDR_LINE1="";
			MAIL_ADDR_LINE2=rset.getString("MAIL_ADDR_LINE2");
			 if(MAIL_ADDR_LINE2==null) MAIL_ADDR_LINE2="";
			MAIL_ADDR_LINE3=rset.getString("MAIL_ADDR_LINE3");
			 if(MAIL_ADDR_LINE3==null) MAIL_ADDR_LINE3="";
			MAIL_ADDR_LINE4=rset.getString("MAIL_ADDR_LINE4");
			 if(MAIL_ADDR_LINE4==null) MAIL_ADDR_LINE4="";
			MAIL_REGION_CODE=rset.getString("MAIL_REGION_CODE");
			 if(MAIL_REGION_CODE==null) MAIL_REGION_CODE="";
			if(function_name.equals("wt_list"))
			{
			MAIL_REGION_DESC=rset.getString("MAIL_REGION_DESC");
			}else
			{
			MAIL_REGION_DESC=rset.getString("MAIL_REGION_SHORT_DESC");
			}
			 if(MAIL_REGION_DESC==null) MAIL_REGION_DESC="";

			// Modified by Muthu on 12/03/2010 Issue :- Records are not getting saved during modify appointment 	
			//MAIL_RES_AREA_CODE=rset.getString("RES_REGION_CODE");
			MAIL_RES_AREA_CODE=rset.getString("MAIL_AREA_CODE");
			// End of Comment
			 if(MAIL_RES_AREA_CODE==null) MAIL_RES_AREA_CODE="";
			if(function_name.equals("wt_list"))
			{
			MAIL_AREA_DESC=rset.getString("MAIL_AREA_DESC");
			}else
			{
			MAIL_AREA_DESC=rset.getString("MAIL_AREA_SHORT_DESC");
			}
			 if(MAIL_AREA_DESC==null) MAIL_AREA_DESC="";
			MAIL_RES_TOWN_CODE=rset.getString("MAIL_TOWN_CODE"); //Modified by Suji Keerthi for PMG2020-COMN-CRF-0084-US001 on 22-Jan-2021
			 if(MAIL_RES_TOWN_CODE==null) MAIL_RES_TOWN_CODE="";
			if(function_name.equals("wt_list"))
			{
			MAIL_RES_TOWN_DESC=rset.getString("MAIL_TOWN_DESC"); //Modified by Suji Keerthi for PMG2020-COMN-CRF-0084-US001 on 22-Jan-2021
			}else
			{
			MAIL_RES_TOWN_DESC=rset.getString("MAIL_TOWN_SHORT_DESC"); //Modified by Suji Keerthi for PMG2020-COMN-CRF-0084-US001 on 22-Jan-2021
			}
			 if(MAIL_RES_TOWN_DESC==null) MAIL_RES_TOWN_DESC="";

			MAIL_POSTAL_CODE=rset.getString("MAIL_POSTAL_CODE");
			 if(MAIL_POSTAL_CODE==null) MAIL_POSTAL_CODE="";

			 MAIL_POSTAL_CODE_DESC=rset.getString("MAIL_POSTAL_CODE_DESC");
			 if(MAIL_POSTAL_CODE_DESC==null) MAIL_POSTAL_CODE_DESC="";

			MAIL_COUNTRY_CODE=rset.getString("MAIL_COUNTRY_CODE");
			 if(MAIL_COUNTRY_CODE==null) MAIL_COUNTRY_CODE="";
			 if(function_name.equals("wt_list"))
			{
			MAIL_COUNTRY_NAME =rset.getString("MAIL_COUNTRY_NAME");
			}else
			{
			MAIL_COUNTRY_NAME =rset.getString("MAIL_COUNTRY_LONG_DESC");
			RES_COUNTRY_DESC=rset.getString("RES_COUNTRY_DESC");
			SEX = rset.getString("gender");
			}
			 if(MAIL_COUNTRY_NAME==null) MAIL_COUNTRY_NAME="";
			  if(RES_COUNTRY_DESC==null) RES_COUNTRY_DESC="";

			/*Added by Thamizh selvi on 2nd Feb 2018 against ML-MMOH-CRF-0601 Start*/
			alt_addr_line1		= checkForNull(rset.getString("alt_addr_line1"));
			alt_addr_line2		= checkForNull(rset.getString("alt_addr_line2"));
			alt_addr_line3		= checkForNull(rset.getString("alt_addr_line3"));
			alt_addr_line4		= checkForNull(rset.getString("alt_addr_line4"));
			alt_area_code		= checkForNull(rset.getString("alt_area_code"));
			alt_area_desc		= checkForNull(rset.getString("alt_area_desc"));
			alt_town_code		= checkForNull(rset.getString("alt_town_code"));
			alt_town_desc		= checkForNull(rset.getString("alt_town_desc"));
			alt_region_code		= checkForNull(rset.getString("alt_region_code"));
			alt_region_desc		= checkForNull(rset.getString("alt_region_desc"));
			alt_postal_code		= checkForNull(rset.getString("alt_postal_code"));
			alt_postal_desc		= checkForNull(rset.getString("alt_postal_desc"));
			alt_country_code	= checkForNull(rset.getString("alt_country_code"));
			alt_country_desc	= checkForNull(rset.getString("alt_country_desc"));
			/*End*/
			
			alternateid = rset.getString("alt_id1_no");
			if (alternateid==null) alternateid="";

			alternateid1 = rset.getString("alt_id2_no");
			if (alternateid1==null) alternateid1="";

			alternateid3 = rset.getString("alt_id3_no");
			if (alternateid3==null) alternateid3="";

			alternateid4 = rset.getString("alt_id4_no");
			if (alternateid4==null) alternateid4="";

			alt_id1_exp_date = rset.getString("alt_id1_exp_date");		
			if (alt_id1_exp_date==null) alt_id1_exp_date="";

			alt_id2_exp_date = rset.getString("alt_id2_exp_date");
			if (alt_id2_exp_date==null) alt_id2_exp_date="";

			alt_id3_exp_date = rset.getString("alt_id3_exp_date");
			if (alt_id3_exp_date==null) alt_id3_exp_date="";

			alt_id4_exp_date = rset.getString("alt_id4_exp_date");
			if (alt_id4_exp_date==null) alt_id4_exp_date="";

			nationalid= rset.getString("national_id_no");
			if (nationalid==null) nationalid="";

			OTH_ALT_ID_NO= rset.getString("OTH_ALT_ID_NO");
			if (OTH_ALT_ID_NO==null) OTH_ALT_ID_NO="";
			OTH_ALT_TYPE= rset.getString("OTH_ALT_ID_TYPE");
			if (OTH_ALT_TYPE==null) OTH_ALT_TYPE="";
		
			String suffix=rset.getString("name_suffix");
				if(suffix==null) suffix="";
			String gender=rset.getString("gender");
			if(gender==null) gender="";
				
				String name_prefix_oth_lang=rset.getString("NAME_PREFIX_LOC_LANG");
			if(name_prefix_oth_lang ==null) name_prefix_oth_lang="";
			String firstname_local_lang=rset.getString("FIRST_NAME_LOC_LANG");
			if(firstname_local_lang ==null) firstname_local_lang="";
			String secondname_local_lang=rset.getString("SECOND_NAME_LOC_LANG");
			if(secondname_local_lang ==null) secondname_local_lang="";
			String thirdname_local_lang=rset.getString("THIRD_NAME_LOC_LANG");
			if(thirdname_local_lang ==null) thirdname_local_lang="";
			String familyname_local_lang=rset.getString("FAMILY_NAME_LOC_LANG");
			if(familyname_local_lang ==null) familyname_local_lang="";
			String name_suffix_oth_lang	=rset.getString("NAME_SUFFIX_LOC_LANG");
			if(name_suffix_oth_lang ==null) name_suffix_oth_lang="";


			if(!alt_id1_exp_date.equals(""))
	{
	 alt_id1_exp_date_display=DateUtils.convertDate(alt_id1_exp_date,"DMY","en",locale);
	}
	if(!alt_id2_exp_date.equals(""))
	{
	 alt_id2_exp_date_display=DateUtils.convertDate(alt_id2_exp_date,"DMY","en",locale);
	}
	if(!alt_id3_exp_date.equals(""))
	{
	 alt_id3_exp_date_display=DateUtils.convertDate(alt_id3_exp_date,"DMY","en",locale);
	}
	if(!alt_id4_exp_date.equals(""))
	{
	 alt_id4_exp_date_display=DateUtils.convertDate(alt_id4_exp_date,"DMY","en",locale);
	}


if(function_name.equals("OA_Modify_Appt") || callingMode.equals("RSCAPPT"))
{
reason_for_transfer=rset.getString("CONTACT_REASON");
			if(reason_for_transfer ==null) reason_for_transfer="";
contact_reason_code=rset.getString("CONTACT_REASON_CODE");
			if(contact_reason_code ==null) contact_reason_code="";
service_code=rset.getString("service_code");
			if(service_code ==null) service_code="";

pat_cat_desc=rset.getString("pat_cat_desc");
			if(pat_cat_desc ==null) pat_cat_desc="";

patient_cat_code=rset.getString("patient_cat_code");
			if(patient_cat_code ==null) patient_cat_code="";

receiving_date_time=rset.getString("RECEIVING_DATE_TIME");
			if(receiving_date_time ==null) receiving_date_time="";
if(!receiving_date_time.equals(""))
	{
	 receiving_date_time_display=DateUtils.convertDate(receiving_date_time,"DMYHM","en",locale);
	}
appt_remarks=rset.getString("APPT_REMARKS");
			if(appt_remarks ==null) appt_remarks="";
mode_of_contact=rset.getString("MODE_OF_CONTACT");
			if(mode_of_contact ==null) mode_of_contact="";
			language_id = rset.getString("language_id")==null?"":rset.getString("language_id");
			language_desc = rset.getString("language_desc")==null?"":rset.getString("language_desc");
}
			String dateofbirth="";
			java.util.Date date1 = rset.getDate("date_of_birth");
			SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
			if(date1 !=null)
			{
			dateofbirth=formatter1.format(date1);

			dateofbirth_display=DateUtils.convertDate(dateofbirth,"DMY","en",locale);

			}else
			{
			if(dateofbirth ==null) dateofbirth="";

			}

			formatter1 = null;
			String remarks="";
			String contact_rea="";
			String visit_type_desc="";
			String recieve_date_time="";
			String visit_ind="";
			String ref_id_value="";
			String cont_res_code="";
			int no_slots_val=0;
			stmt3=conn.createStatement();

			String visit_type_code="";
			if(function_name.equals("wt_list") || callingMode.equals("RSCAPPT"))
			{
				String sqlappt="";
				if(callingMode.equals("RSCAPPT")){
					sqlappt= "select a.APPT_REMARKS ,AM_GET_DESC.AM_CONTACT_REASON(a.CONTACT_REASON_CODE,'"+locale+"','1') CONTACT_REASON,OP_GET_DESC.OP_VISIT_TYPE(a.FACILITY_ID, a.APPT_TYPE_CODE,'"+locale+"','2') visit_type_short_desc,a.RECEIVING_DATE_TIME,(CASE  WHEN a.appt_type_code IS NOT NULL THEN (SELECT visit_type_ind         FROM op_visit_type WHERE visit_type_code = a.appt_type_code AND facility_id = a.facility_id)  END) visit_type_ind,REFERRAL_ID,NO_OF_SLOTS,CONTACT_REASON_CODE,appt_type_code visit_type_code from oa_appt_del_tr a where a.appt_ref_no ='"+apptrefno+"' and a.facility_id='"+facilityid+"'";
				}else{				
					sqlappt= "select a.APPT_REMARKS ,AM_GET_DESC.AM_CONTACT_REASON(a.CONTACT_REASON_CODE,'"+locale+"','1') CONTACT_REASON,OP_GET_DESC.OP_VISIT_TYPE(a.FACILITY_ID, a.APPT_TYPE_CODE,'"+locale+"','2') visit_type_short_desc,a.RECEIVING_DATE_TIME,(CASE  WHEN a.appt_type_code IS NOT NULL THEN (SELECT visit_type_ind         FROM op_visit_type WHERE visit_type_code = a.appt_type_code AND facility_id = a.facility_id)  END) visit_type_ind,REFERRAL_ID,NO_OF_SLOTS,CONTACT_REASON_CODE,appt_type_code visit_type_code from oa_appt a where a.appt_ref_no ='"+appt_num+"' and a.facility_id='"+facilityid+"'";
				}
				rsappt=stmt3.executeQuery(sqlappt);
			if(rsappt !=null && rsappt.next())
			{
				remarks=rsappt.getString("APPT_REMARKS");
				if(remarks ==null) remarks="";
				contact_rea=rsappt.getString("CONTACT_REASON");
				if(contact_rea ==null) contact_rea="";
				visit_type_desc=rsappt.getString("VISIT_TYPE_SHORT_DESC");
				if (visit_type_desc ==null) visit_type_desc="";
				recieve_date_time =rsappt.getString("RECEIVING_DATE_TIME");
				if (recieve_date_time ==null) recieve_date_time="";
				visit_ind=rsappt.getString("VISIT_TYPE_IND");
				if(visit_ind ==null) visit_ind="";
				ref_id_value=rsappt.getString("REFERRAL_ID");
				if(ref_id_value ==null) ref_id_value="";
				no_slots_val=rsappt.getInt("NO_OF_SLOTS");
				cont_res_code=rsappt.getString("CONTACT_REASON_CODE");
				if(cont_res_code ==null) cont_res_code="";
				
				visit_type_code=rsappt.getString("visit_type_code");
				if(visit_type_code ==null) visit_type_code="";
			}

			}
			if(!callingMode.equals("RSCAPPT")){
				String sql_visit_type="select a.visit_type_code from op_visit_type_for_clinic a, op_visit_type_lang_vw b where a.facility_id='"+facilityid+"' and a.facility_id = b.facility_id and a.visit_type_code = b.visit_type_Code  and b.visit_type_ind ='"+visit_ind+"' and a.eff_status='E' and a.clinic_code='"+appt_clinic_code+"' and b.visit_type_ind != 'E'";
				rsappt_visit=stmt3.executeQuery(sql_visit_type);
				if(rsappt_visit !=null && rsappt_visit.next())
				{
					visit_type_code=rsappt_visit.getString("visit_type_code");
					if(visit_type_code ==null) visit_type_code="";
				}
			}
			if(rsappt !=null) rsappt.close();
			if(rsappt_visit !=null) rsappt_visit.close();
	String sec_resources="";


	String sql_wait_sec  = "select resource_class,resource_type,resource_criteria from op_resource_type_for_appt where facility_id='"+facilityid+"' and visit_type_code='"+visit_type_code+"' and resource_class !='"+prm_res_class+"'  order by resource_class ";
stmt_wait_sec=conn.createStatement();


	rs_wait_sec = stmt_wait_sec.executeQuery(sql_wait_sec);

	while(rs_wait_sec!=null && rs_wait_sec.next()){
		 sec_resources=sec_resources+rs_wait_sec.getString("resource_class");
		 sec_resources=sec_resources+"*"+rs_wait_sec.getString("resource_criteria")+"-";
	 }

	 if (rs_wait_sec!=null) rs_wait_sec.close();
	 if (stmt_wait_sec !=null) stmt_wait_sec.close();
	
	 if(sec_resources.length()>1)
		 sec_resources=sec_resources.substring(0,sec_resources.length()-1);

	 if(sec_resources.length()>1){%>
		 //document.getElementById("sec").style.visibility="visible";
	 document.getElementById("SecResource").disabled=false;
	  document.getElementById("SecResCheck").value='Y';
	 <%}else{%>
		 document.getElementById("SecResource").disabled=true;
		document.getElementById("SecResCheck").value='N';
		 //document.getElementById("sec").style.visibility="hidden";
	 <%}%>
	document.forms[0].sec_req.value="<%=sec_resources%>";
	document.forms[0].sec_sel.value="";
	<%

	

			rs3=stmt3.executeQuery("select calculate_age('"+dateofbirth+"',1),calculate_age('"+dateofbirth+"',2),calculate_age('"+dateofbirth+"',3) from dual");
			rs3.next();
			String agey=rs3.getString(1);
			String agem=rs3.getString(2);
			String aged=rs3.getString(3);
			String restelno="";
			if(function_name.equals("wt_list") || function_name.equals("OA_Modify_Appt"))
			{	
			restelno=rset.getString("RES_TEL_NO");
			}else
			{
			restelno=rset.getString("APPL_RES_TEL_NO");
			}
			if(restelno==null)
				 restelno="";
			String othtelno="";
			if(function_name.equals("wt_list") || function_name.equals("OA_Modify_Appt"))
			{
			othtelno=rset.getString("OTH_CONTACT_NO");
			}else
			{
			othtelno=rset.getString("APPL_MOB_TEL_NO");
			}
			if(othtelno==null)
				 othtelno="";

			if (rs3 !=null) rs3.close();

			int maxRecord1 = 0;
			if(patientid!=null &&(!patientid.equals(""))){
				rspat=null;
				if(alcn_criteria_pop!=null && (alcn_criteria_pop.equals("NG") || alcn_criteria_pop.equals("BG"))){
					stmtpat=conn.createStatement();
					rspat=stmtpat.executeQuery("select nvl(GET_PAT_CAT_CODE('"+patientid+"'),'*O') alcn_catg_code from dual");

					if(rspat!=null) {
						if(rspat.next()) {
						   pat_cat_code = rspat.getString("alcn_catg_code");
						   if (pat_cat_code==""||pat_cat_code==null) 
							   pat_cat_code = "*O";
						}else{
							pat_cat_code = "*O";
						}
					}
				}else{
					pat_cat_code = "*O";
				}
	if(rspat !=null)rspat.close();
				if(pref_facility_id.equals("") || pref_facility_id.equals(facilityid)){
				}else{
					%>
					alert(getMessage("PATIENT_DESIG_FACILITY","OA")+'<%=dis_facility%>');
					<%
				}
	
				rsap=stmtap.executeQuery("select count(*) as total from oa_appt where patient_id='"+patientid+"' and trunc(Appt_date)>=trunc(sysdate) and nvl(appt_status,1)!='A' order by appt_date,appt_slab_from_time");
				rsap.next();
				maxRecord1 = rsap.getInt("total");


if(rsap !=null) rsap.close();
				String ip_installed_yn = "";
				String sqlip="select nvl(install_yn,'N') install_yn from sm_module where module_id = 'IP'";

				rsap=stmtap.executeQuery(sqlip);
				if(rsap!=null){
				if(rsap.next())
					ip_installed_yn = rsap.getString("install_yn");
				else
					ip_installed_yn = "N";
				}else{
					ip_installed_yn = "N";
				}

if(rsap !=null) rsap.close();

				if(ip_installed_yn.equals("Y")){
					rsap=stmtap.executeQuery("select count(1) as total from ip_booking_list where patient_id is not null and patient_id='"+patientid+"' and trunc(preferred_date)>=trunc(sysdate) and nvl(booking_status,1)=1");
					if(rsap.next())
						ip_bkgs = rsap.getInt("total");
				}

if(rsap !=null) rsap.close();

				String radiology_installed_yn = "";
				String sqlrad="select nvl(install_yn,'N') install_yn from sm_module where module_id = 'RD'";
				rsap = stmtap.executeQuery(sqlrad);
				if(rsap!=null){
				if(rsap.next())
					radiology_installed_yn = rsap.getString("install_yn");
				else
					radiology_installed_yn = "N";
				}else{
					radiology_installed_yn = "N";
				}
if(rsap !=null) rsap.close();

				if(radiology_installed_yn.equals("Y")){
					rsap = stmtap.executeQuery("SELECT count(1) as total FROM RD_APPT where patient_id='"+patientid+"'");
					if(rsap.next())
						rad_bkgs = rsap.getInt("total");
				}
		
			}else if (nationality_code!=""){
				
				if(alcn_criteria_pop.equals("NG")){
					//stmtpat=conn.createStatement();
					rspat=stmtpat.executeQuery("SELECT STAT_GRP_ID alcn_catg_code FROM AM_STAT_GRP_DETAIL WHERE MEMBER_ID = '"+nationality_code+"'");
					if(rspat!=null) {
						if(rspat.next()) {
						   pat_cat_code = rspat.getString("alcn_catg_code");
						   

						   if (pat_cat_code==""||pat_cat_code==null) pat_cat_code = "*O";
						  

						}else
						   pat_cat_code = "*O";
					}
				}else{
				

					pat_cat_code = "*O";
				}	
			}else{
				

				pat_cat_code = "*O";
			}
if(rspat !=null) rspat.close();
			//if(wait_priority!=null){%>
				//document.forms[0].wait_priority.value="<%=wait_priority%>";					
				<%	
			//}
			
			//String sqlsec = "select nvl(security_level,0) pat_security_level from mp_patient //where patient_id= '"+patientid+"' and added_facility_id  = '"+facilityid+"'";
			//stmt12 = conn.createStatement();
			//rs12 = stmt12.executeQuery(sqlsec);

			//String security_level="";
			//if (rs12!=null){
				//if(rs12.next()){
					//security_level=rs12.getString("pat_security_level");

				//}
			//}
			%>
			//document.forms[0].patient_SecurityLevel.value="<%//=security_level%>";
			if('<%=remarks%>' !="")
			{
				document.forms[0].remarks.value="<%=remarks%>";
				document.forms[0].remarks.disabled=true;
			}
			/*Added by Rameswar on  19-10-2016 for ML-MMOH-SCF-0530 End*/
			if('<%=cont_res_code%>' !="" && '<%=callingMode%>'!='RSCAPPT')
			{
				document.forms[0].reason.value="<%=contact_rea%>";
				document.forms[0].reason_for_contact.value="<%=cont_res_code%>";
				if('<%=callingMode%>'!='RSCAPPT')
					document.forms[0].reason.disabled=true;
			}
			if('<%=visit_type_desc%>' !="" && '<%=callingMode%>'=='RSCAPPT')
			{
				if('<%=callingMode%>'!='RSCAPPT'){
					while(document.forms[0].visit_type_short_desc.options.length>0)
					{
						document.forms[0].visit_type_short_desc.remove(document.forms[0].visit_type_short_desc.options[0])
					}
					opt = document.createElement("OPTION");
					opt.text = "<%=visit_type_desc%>";
					opt.value= "<%=visit_type_code%>~<%=visit_ind%>";
					document.forms[0].visit_type_short_desc.add(opt);
					document.forms[0].visit_type_short_desc.options.selectedIndex=0;
				}else{
					document.forms[0].visit_type_short_desc.value="<%=visit_type_code%>~<%=visit_ind%>";
				}
				if('<%=callingMode%>'!='RSCAPPT')
					document.forms[0].visit_type_short_desc.disabled=true;
			}
			if('<%=recieve_date_time%>' !="")
			{
				document.forms[0].rec_date.value="<%=recieve_date_time%>";
				document.forms[0].rec_date.disabled=true;
			}
			if('<%=ref_id_value%>' !="")
			{
				document.forms[0].source.value="<%=ref_id_value%>";
				document.forms[0].source.disabled=true;
			}
			
			if('<%=no_slots_val%>' !=0)
			{
				
				opt = document.createElement("OPTION");
				opt.text = "<%=no_slots_val%>";
				opt.value=  "<%=no_slots_val%>";
					
				document.forms[0].no_slots.add(opt);
				document.forms[0].no_slots.value="<%=no_slots_val%>";
				document.forms[0].no_slots.disabled=true;
			}
			<%
				
			if(patientid!=null){%>
				
				document.forms[0].patient_id.value="<%=patientid%>";			
				document.forms[0].patient_id.disabled=true;
			<%}else{%>
				document.forms[0].patient_id.disabled=false;
			<%}%>
		
			<%if(patientname!=null){%>		
				document.getElementById("patient_name1").innerHTML="<%=patientname%>";
				document.getElementById("patient_name").value="<%=patientname%>";
			<%}else{%>
				
			<%}%>

			<%if(nationalid!=null) {%>
				if	(document.forms[0].national_id_no) 		document.forms[0].national_id_no.value="<%=nationalid%>";
			<%}else {%>
				 if	(document.forms[0].national_id_no) 
					document.forms[0].national_id_no.value='';	
			<%}%>
		
			if	(document.forms[0].national_id_no) 
			document.forms[0].national_id_no.disabled=true;
		
			if (document.forms[0].alt_id1_no) {
				<%if(alternateid!=null) {%>
					document.forms[0].alt_id1_no.value="<%=alternateid%>";	
				<%}else {%>
					document.forms[0].alt_id1_no.value='';
				<%}%>	
				document.forms[0].alt_id1_no.disabled=true;
			}
		
			if (document.forms[0].alt_id1_exp_date) {
				<%if(alt_id1_exp_date!=null) {%>
					document.forms[0].alt_id1_exp_date.value="<%=alt_id1_exp_date_display%>";	
				<%}else {%>
					document.forms[0].alt_id1_exp_date.value='';
				<%}%>	
				document.forms[0].alt_id1_exp_date.disabled=true;
			}

			if (document.forms[0].alt_id2_no) {
				<%if(alternateid1!=null) {%>
					document.forms[0].alt_id2_no.value="<%=alternateid1%>";	
				<%}else {%>
					document.forms[0].alt_id2_no.value='';
				<%}%>	
				document.forms[0].alt_id2_no.disabled=true;
			}
		
			if (document.forms[0].alt_id2_exp_date) {
				<%if(alt_id2_exp_date!=null) {%>
					document.forms[0].alt_id2_exp_date.value="<%=alt_id2_exp_date_display%>";	
				<%}else {%>
					document.forms[0].alt_id2_exp_date.value='';
				<%}%>	
				document.forms[0].alt_id2_exp_date.disabled=true;
			}

		
			if (document.forms[0].alt_id3_no) {
				<%if(alternateid3!=null) {%>
					document.forms[0].alt_id3_no.value="<%=alternateid3%>";	
				<%}else {%>
					document.forms[0].alt_id3_no.value='';
				<%}%>	
				document.forms[0].alt_id3_no.disabled=true;
			}
		
			if (document.forms[0].alt_id3_exp_date) {
				<%if(alt_id3_exp_date!=null) {%>
					document.forms[0].alt_id3_exp_date.value="<%=alt_id3_exp_date_display%>";	
				<%}else {%>
					document.forms[0].alt_id3_exp_date.value='';
				<%}%>	
				document.forms[0].alt_id3_exp_date.disabled=true;
			}
		
			if (document.forms[0].alt_id4_no) {
				<%if(alternateid4!=null) {%>
					document.forms[0].alt_id4_no.value="<%=alternateid4%>";	
				<%}else {%>
					document.forms[0].alt_id4_no.value='';
				<%}%>	
				document.forms[0].alt_id4_no.disabled=true;
			}
		
			if (document.forms[0].alt_id4_exp_date) {
				<%if(alt_id4_exp_date!=null) {%>
					document.forms[0].alt_id4_exp_date.value="<%=alt_id4_exp_date_display%>";	
				<%}else {%>
					document.forms[0].alt_id4_exp_date.value='';
				<%}%>	
				document.forms[0].alt_id4_exp_date.disabled=true;
			}

			<%if(c_name_prefix_accept_yn.equals("Y")){
				if(prefix!=null) {%>
					document.forms[0].name_prefix.value="<%=prefix%>";
				<%}else {%>
					document.forms[0].name_prefix.value='';
				<%}%>
				document.forms[0].name_prefix.disabled=true;
			<% }  %>


			<% if(c_first_name_accept_yn.equals("Y")){ %>
			  if(document.forms[0].first_name) {
				 document.forms[0].first_name.value="<%=firstname%>";
				 document.forms[0].first_name.disabled=true;
				}
			<% } %>

			<% if(c_second_name_accept_yn.equals("Y")){%>
				 if(document.forms[0].second_name) {
					document.forms[0].second_name.value="<%=secondname%>";
					document.forms[0].second_name.disabled=true;
				}
			<% } %>

			<% if(c_third_name_accept_yn.equals("Y")){ %>
				if(document.forms[0].third_name) {
					document.forms[0].third_name.value="<%=thirdname%>"; 				
					document.forms[0].third_name.disabled=true;
				}
			<% } %>

     <%if(c_family_name_accept_yn.equals("Y")){ %>
			if(document.forms[0].family_name) {
				document.forms[0].family_name.value="<%=familyname%>";
			    document.forms[0].family_name.disabled=true;
			}
		<% } %>

		<% if(c_name_suffix_accept_yn.equals("Y")){
			if(suffix!=null) {%>
				document.forms[0].name_suffix.value="<%=suffix%>";
				document.forms[0].name_suffix.disabled=true;
				document.forms[0].name_suffix.disabled=true;
				document.forms[0].name_suffix.value="<%=suffix%>";
			<% }else {%>
				document.forms[0].name_suffix.value='';
			<%}%>
				document.forms[0].name_suffix.disabled=true;
		<% } %>


 <%if(patientname_local_lang!=null){%>		
				document.getElementById("patient_name_local_lang1").innerHTML="<%=patientname_local_lang%>";
				document.getElementById("patient_name_local_lang").value="<%=patientname_local_lang%>";
			<%}else{%>
				
			<%}%>
			<%
				if(name_prefix_oth_lang!=null) {%>
					if(document.forms[0].name_prefix_oth_lang)
					{
					document.forms[0].name_prefix_oth_lang.value="<%=name_prefix_oth_lang%>";
					document.forms[0].name_prefix_oth_lang.disabled=true;
					}
				<%}else {%>
					if(document.forms[0].name_prefix_oth_lang)
					{
					
					document.forms[0].name_prefix_oth_lang.value='';
					document.forms[0].name_prefix_oth_lang.disabled=true;
					}
				<%}%>
				
			


		<%	if(firstname_local_lang!=null) {%>
					if(document.forms[0].first_name_oth_lang)
					{
					document.forms[0].first_name_oth_lang.value="<%=firstname_local_lang%>";
					document.forms[0].first_name_oth_lang.disabled=true;
					}
				<% }else {%>
					if(document.forms[0].first_name_oth_lang)
					{
					document.forms[0].first_name_oth_lang.value='';
					document.forms[0].first_name_oth_lang.disabled=true;
					}
				<%}%>
				
	<%	if(secondname_local_lang!=null) {%>
					if(document.forms[0].second_name_oth_lang){
					document.forms[0].second_name_oth_lang.value="<%=secondname_local_lang%>";
					document.forms[0].second_name_oth_lang.disabled=true;
					}
				<% }else {%>
					if(document.forms[0].second_name_oth_lang){
					document.forms[0].second_name_oth_lang.value='';
					document.forms[0].second_name_oth_lang.disabled=true;
					}
				<%}%>


	<%	if(thirdname_local_lang!=null) {%>
					if(document.forms[0].third_name_oth_lang){
					document.forms[0].third_name_oth_lang.value="<%=thirdname_local_lang%>";
					document.forms[0].third_name_oth_lang.disabled=true;
					}
				<% }else {%>
					if(document.forms[0].third_name_oth_lang){
					document.forms[0].third_name_oth_lang.value='';
					document.forms[0].third_name_oth_lang.disabled=true;
					}
				<%}%>

	<%	if(familyname_local_lang!=null) {%>
					if(document.forms[0].family_name_oth_lang){
					document.forms[0].family_name_oth_lang.value="<%=familyname_local_lang%>";
					document.forms[0].family_name_oth_lang.disabled=true;
					}
				<% }else {%>
					if(document.forms[0].family_name_oth_lang){
					document.forms[0].family_name_oth_lang.value='';
					document.forms[0].family_name_oth_lang.disabled=true;
					}
				<%}%>

<% 	if(name_suffix_oth_lang!=null) {%>
				if(document.forms[0].name_suffix_oth_lang){
				document.forms[0].name_suffix_oth_lang.value="<%=name_suffix_oth_lang%>";
				document.forms[0].name_suffix_oth_lang.disabled=true;
				//document.forms[0].name_suffix_oth_lang.disabled=true;
				//document.forms[0].name_suffix_oth_lang.value="<%=name_suffix_oth_lang%>";
				}
			<% }else {%>
				if(document.forms[0].name_suffix_oth_lang){
				document.forms[0].name_suffix_oth_lang.value='';
				document.forms[0].name_suffix_oth_lang.disabled=true;
				}
			<%}%>
			







		<%if(function_name.equals("wt_list")) {%>
		document.forms[0].sex.value="<%=gender%>";
		document.forms[0].sex.disabled=true;
		<%}else {%>
		document.forms[0].sex.value="<%=SEX%>";
		document.forms[0].sex.disabled=true;
			<%}%>
		document.forms[0].gen.value="<%=gender%>";
		document.forms[0].sex.disabled=true;
	

		document.forms[0].addr_line1.value = "<%=ADDR_LINE1%>";
		document.forms[0].addr_line2.value = "<%=ADDR_LINE2%>";
		document.forms[0].addr_line3.value = "<%=ADDR_LINE3%>";
		document.forms[0].addr_line4.value = "<%=ADDR_LINE4%>";
		document.forms[0].res_town_code.value = "<%=RES_TOWN_CODE%>";
		document.forms[0].res_town_desc.value = "<%=RES_TOWN_DESC%>";
		document.forms[0].res_area_code.value = "<%=RES_AREA_CODE%>";
		document.forms[0].res_area_desc.value = "<%=RES_AREA_DESC%>";
		document.forms[0].postal_code.value = "<%=POSTAL_CODE%>";
		document.forms[0].region_code.value = "<%=REGION_CODE%>";
		document.forms[0].region_desc.value = "<%=REGION_DESC%>";
		document.forms[0].country_code.value = "<%=COUNTRY_CODE%>";
		//document.forms[0].country_desc.value = "";
		document.forms[0].mail_addr_line1.value = "<%=MAIL_ADDR_LINE1%>"
		document.forms[0].mail_addr_line2.value ="<%=MAIL_ADDR_LINE2%>"
		document.forms[0].mail_addr_line3.value = "<%=MAIL_ADDR_LINE3%>"
		document.forms[0].mail_addr_line4.value = "<%=MAIL_ADDR_LINE4%>"
		document.forms[0].mail_res_town_code.value = "<%=MAIL_RES_TOWN_CODE%>"
		document.forms[0].mail_res_town_desc.value = "<%=MAIL_RES_TOWN_DESC%>"
		document.forms[0].mail_res_area_code.value = "<%=MAIL_RES_AREA_CODE%>"
		document.forms[0].mail_res_area_desc.value = "<%=MAIL_AREA_DESC%>"
		document.forms[0].mail_postal_code.value = "<%=MAIL_POSTAL_CODE%>"

		document.forms[0].r_postal_code_desc.value="<%=POSTAL_CODE_DESC%>"
		document.forms[0].m_postal_code_desc.value="<%=MAIL_POSTAL_CODE_DESC%>"

		document.forms[0].country_desc.value = "<%=RES_COUNTRY_DESC%>"
		
		document.forms[0].mail_region_code.value = "<%=MAIL_REGION_CODE%>"
		document.forms[0].mail_region_desc.value = "<%=MAIL_REGION_DESC%>"
		document.forms[0].mail_country_code.value = "<%=MAIL_COUNTRY_CODE%>"
		document.forms[0].mail_country_desc.value = "<%=MAIL_COUNTRY_NAME%>"

		document.forms[0].contact1_no.value ="<%=CONTACT1_NO%>"
		document.forms[0].contact2_no.value ="<%=CONTACT2_NO%>"
		document.forms[0].email.value ="<%=EMAIL_ID%>"

		document.forms[0].alt_addr_line1.value = "<%=alt_addr_line1%>"
		document.forms[0].alt_addr_line2.value ="<%=alt_addr_line2%>"
		document.forms[0].alt_addr_line3.value = "<%=alt_addr_line3%>"
		document.forms[0].alt_addr_line4.value = "<%=alt_addr_line4%>"
		document.forms[0].alt_area_code.value = "<%=alt_area_code%>"
		document.forms[0].alt_area_desc.value = "<%=alt_area_desc%>"
		document.forms[0].alt_town_code.value = "<%=alt_town_code%>"
		document.forms[0].alt_town_desc.value = "<%=alt_town_desc%>"
		document.forms[0].alt_region_code.value = "<%=alt_region_code%>"
		document.forms[0].alt_region_desc.value = "<%=alt_region_desc%>"
		document.forms[0].alt_postal_code.value = "<%=alt_postal_code%>"
		document.forms[0].alt_postal_desc.value = "<%=alt_postal_desc%>"
		document.forms[0].alt_country_code.value = "<%=alt_country_code%>"
		document.forms[0].alt_country_desc.value = "<%=alt_country_desc%>"

		document.forms[0].Birth_place_code.value ="<%=BIRTH_PLACE_CODE%>"
		document.forms[0].birth_place.value ="<%=BIRTH_PLACE_DESC%>"
		
		document.forms[0].place_of_birth.value ="<%=birth_place_description%>"
		document.forms[0].place_of_birth.disabled = true

		document.forms[0].nationality_code1.value = "<%=NATIONALITY_CODE%>"

		document.forms[0].nationality_desc.value = "<%=NATIONALITY%>"

		document.forms[0].nationality_desc.disabled = true
		document.forms[0].nationality_id.disabled = true
		
		<%if(function_name.equals("OA_Modify_Appt")) {%>
		document.forms[0].pat_cat_code.value = "<%=patient_cat_code%>"
		document.forms[0].pat_cat_desc.value = "<%=pat_cat_desc%>"		
		document.forms[0].pat_cat_desc.disabled = true
		document.forms[0].pat_cat_code_id.disabled = true
		<%}%>

		document.forms[0].birth_place.disabled = true
		document.forms[0].b_birth.disabled = true


		if('<%=CITIZEN_YN%>'=='Y'){
			document.forms[0].citizen_yn[0].checked = true
			//if(document.getElementById("eth_gif")!=null)
				//document.getElementById("eth_gif").style.visibility = 'visible';
			
		}else{
			document.forms[0].citizen_yn[1].checked = true
			//if(document.getElementById("eth_gif")!=null)
				//document.getElementById("eth_gif").style.visibility = 'hidden';
		}

		if('<%=LEGAL_ILLEGAL_YN%>'=='Y'){
			document.forms[0].legal_yn[0].checked = true
		}else{
			document.forms[0].legal_yn[1].checked = true
		}

		document.forms[0].citizen_yn[0].disabled = true
		document.forms[0].citizen_yn[1].disabled = true
		document.forms[0].legal_yn[0].disabled = true
		document.forms[0].legal_yn[1].disabled = true
		document.forms[0].search.disabled = true
		document.forms[0].dob.disabled = true

	
		if(document.forms[0].other_alt_type){
			document.forms[0].other_alt_type.value="<%=OTH_ALT_TYPE%>";
			document.forms[0].other_alt_type.disabled=true;

		}
		if(document.forms[0].other_alt_Id){
			document.forms[0].other_alt_Id.value="<%=OTH_ALT_ID_NO%>";
			document.forms[0].other_alt_Id.disabled=true;
		}

		if(document.getElementById("alt_id_exp_dt1"))
			document.getElementById("alt_id_exp_dt1").disabled=true;

		if(document.getElementById("alt_id_exp_dt2"))
			document.getElementById("alt_id_exp_dt2").disabled=true;

		if(document.forms[0].ethnic_group ){	
			if('<%=ETHNIC_GRP_CODE%>' !=''){
				opt = document.createElement("OPTION");
				opt.text ="<%=ETHNIC_GROUP_DESC%>";
				opt.value= "<%=ETHNIC_GRP_CODE%>";
					
				document.forms[0].ethnic_group.add(opt);
				document.forms[0].ethnic_group.value="<%=ETHNIC_GRP_CODE%>";
			}else{
				opt = document.createElement("OPTION");
				opt.text = '--- Select ---';
				opt.value=  '';
					
				document.forms[0].ethnic_group.add(opt);
				document.forms[0].ethnic_group.value='';
			}

			document.forms[0].ethnic_group.disabled = true
		}
		
		if(document.forms[0].race_desc){	
			if('<%=RACE_DESC%>' !=''){			
				document.forms[0].race_code.value="<%=RACE_CODE%>";
				document.forms[0].race_desc.value="<%=RACE_DESC%>";
				document.forms[0].race_desc.disabled = true;
				document.forms[0].race_desc_id.disabled = true;
			}else{	
				document.forms[0].race_code.value='';
				document.forms[0].race_desc.value='';
			}			
		}
		

		document.forms[0].date_of_birth.value="<%=dateofbirth_display%>";
		document.forms[0].date_of_birth.disabled=true;
		
		document.forms[0].b_age.value="<%=agey%>";
		document.forms[0].b_age.disabled=true;
		document.forms[0].b_months.value="<%=agem%>";
		document.forms[0].b_months.disabled=true;
		document.forms[0].b_days.value="<%=aged%>";
		document.forms[0].b_days.disabled=true;	
	
		if(document.forms[0].alcn_criteria.value=='NG' || document.forms[0].alcn_criteria.value=='BG' ){
			<%if(pat_cat_code !=""&&pat_cat_code !=null){%>
				document.forms[0].pat_cat.value="<%=pat_cat_code%>";  
				if (document.forms[0].pat_cat.value=="")
					document.forms[0].pat_cat.value="*O";

				<%if (!pat_cat_code.equals("*O"))%>											
					document.forms[0].pat_cat.disabled=true;
				<%else%>											
					document.forms[0].pat_cat.disabled=true;

				document.forms[0].pat_cat.disabled=false;
				<%
			}%>
		}
				
		document.forms[0].maxrecord.value="<%=maxRecord1%>";
		document.forms[0].ipbookings.value="<%=ip_bkgs%>";
		<%if(maxRecord1 !=0 || ip_bkgs!=0 || rad_bkgs!=0 ) {%>
			document.forms[0].ipbookings.value="1";
			alert(getMessage("PAT_FUTURE_APPT_EXISTS","OA"));
			
			document.forms[0].chk_for_oth_appt.value="Y"
			parent.frames[2].document.forms[0].OtherAppts.disabled=false;
			parent.frames[2].document.getElementById("other_id1").style.visibility='visible';
			parent.frames[2].document.forms[0].previous_encounter.disabled=false;
			//document.forms[0].last_visits.disabled=false;
		<%}%>
			<%if(function_name.equals("OA_Modify_Appt"))
			{%>	
		
			document.forms[0].reason.value="<%=reason_for_transfer%>";
			document.forms[0].reason_for_contact.value="<%=contact_reason_code%>";
			document.forms[0].rec_date.value="<%=receiving_date_time_display%>";
			document.forms[0].remarks.value="<%=appt_remarks%>";
			document.forms[0].sel_service_code.value="<%=service_code%>";
			document.forms[0].mode.value="<%=mode_of_contact%>";
			if(document.forms[0].language_desc){
				document.forms[0].language_desc.value = "<%=language_desc%>";
				document.forms[0].language_id.value = 	"<%=language_id%>";
			}
			<%}%>
		<%

		String sql1="";

		sql1 = "select encounter_id from pr_encounter  where patient_id = '"+patientid+"'  and facility_id = '"+facilityid+"'"; 
		stmt12 = conn.createStatement();
		rs12 = stmt12.executeQuery(sql1);
		if (rs12!=null){
			if(rs12.next()){%>
				parent.frames[2].document.getElementById("previous_encounter").disabled = false;
				document.getElementById("last_service_encounter_id").value="<%=rs12.getString(1)%>";		     
			<%}else{%>
			parent.frames[2].document.getElementById("previous_encounter").disabled = true;
			<%}
		}else{%>
			parent.frames[2].document.getElementById("previous_encounter").disabled = true;
		<%}

		

		if (!patientid.equals("")){
			String In_patient_status =  patdata.CheckInPatient(conn,patientid,facilityid);

			if (In_patient_status.equals("CURRENTLY_IN_PATIENT")) {%>
				var err_age3 = getMessage( "CURRENTLY_IN_PATIENT","Common");
				alert(err_age3);
				document.forms[0].inpatient_yn.value='Y';
			<%}else{%>
				document.forms[0].inpatient_yn.value='N';
			<%}

			String alt_status1 = patdata.CheckAlternateId(conn,patientid,locale);
			//char alt_stat1 = 'Y';
			
			
				if(!alt_status1.equals(""))
			   {
				char val=alt_status1.charAt(0);
				
				if(val == 'W')
				{
					String val1=alt_status1.substring(2,alt_status1.length());
					out.println("var contyn = confirm(\""+val1+"\");  if(!contyn) clear_all_fun1('R');");
				}else if(val =='C')
				{			
					
						String val1=alt_status1.substring(1,alt_status1.length());
					out.println("alert(\""+val1+"\");clear_all_fun1('R');");
				}else 
				{
					String val1=alt_status1.substring(2,alt_status1.length());
						out.println("alert(\""+val1+"\");");
				}
			}
		}
	}else{
		if (valid_patient){%>
			alert(getMessage('INVALID_REF_ID','OP'));
			document.forms[0].source.value='';
			document.forms[0].search.disabled = false;

			clearAll1()
		<%
		}
	}
}else{
	if(valid_patient){%>   

		alert(getMessage('INVALID_REF_ID','OP'));
		document.forms[0].source.value='';
		document.forms[0].search.disabled = false; 
		clearAll1()
	<%
	}
}
}
if(rset !=null) rset.close();
}//referral
}

if(c_rs != null) c_rs.close();
if(stmt != null) stmt.close();
if(stmtap != null) stmtap.close();
if(stmtpat != null) stmtpat.close();
if(stmt3 != null) stmt3.close();
	if(stmtc_p != null) stmtc_p.close();
}catch(Exception e) {
	String error = e.toString();
	error = error.replace('\n',',');
		//System.err.println("Exception in getbookapptvalue.jsp - "+e.getMessage());
			e.printStackTrace();
	%>
	alert('<%=error%>');	
	clear_fun_all();
	<%
}finally{
	if(c_rs != null) c_rs.close();
	if(rs != null) rs.close();
	if(rspat != null) rspat.close();
	if(rs3 != null) rs3.close();
	if(rsc_p != null) rsc_p.close();
	if(rset != null) rset.close();
	if(rsap != null) rsap.close();
	if(stmt != null) stmt.close();
	if(stmtap != null) stmtap.close();
	if(stmt != null) stmt.close();
	if(stmtpat != null) stmtpat.close();
	if(stmtc_p != null) stmtc_p.close();
	if(stmt3 != null) stmt3.close();
	if(c_stmtn !=null) c_stmtn.close();
	if(rs12 !=null) rs12.close();
	if(stmt12 !=null) stmt12.close();
	hash.clear();
	ConnectionManager.returnConnection(conn,request);
}
%>
<%!

public static String checkForNull(String inputString)
{
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
}

%>
