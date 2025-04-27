
<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,com.ehis.util.*,eCommon.XSSRequestWrapper" %>   


<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<% 
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
Map hash = new HashMap();
hash = (Map)obj.parseXMLString( request ) ;
hash = (Map)hash.get("SEARCH") ;
webbeans.op.PatientData patdata = new webbeans.op.PatientData();
Connection conn			=ConnectionManager.getConnection(request);
String facilityid		=(String)session.getValue("facility_id");
request.setCharacterEncoding("UTF-8");	

String ref_id=(String)hash.get("ref_id");
if(ref_id==null || ref_id.equals("null"))
ref_id="";
String p_speciality_code=(String)hash.get("p_speciality_code");
String pract_id=(String)hash.get("pract_id");
String calledFor=(String)hash.get("calledFor");

String apptrefno=(String)hash.get("apptrefno");
if(apptrefno ==null) apptrefno="";
String from_page=(String)hash.get("from_page");
if(from_page==null) from_page="";
String wait_list_num=(String)hash.get("wait_list_num");
if(wait_list_num==null || wait_list_num.equals("null"))
wait_list_num="";
String req_id=(String)hash.get("req_id");
if(req_id ==null) req_id="";
String alcn_criteria_pop=(String)hash.get("alcn_criteria_pop");
if(alcn_criteria_pop!=null) alcn_criteria_pop="";
String locale=(String)session.getAttribute("LOCALE");
String receiving_date_time_display="";
String reason_for_transfer="";
String receiving_date_time="";
String appt_remarks="";
String mode_of_contact="";
String contact_reason_code = "";


String to_pract_id		="",alt_id1_exp_date	="",alt_id2_exp_date	="",alt_id3_exp_date	="",alt_id4_exp_date	="",appt_num="",remarks="",contact_rea="",visit_type_desc="",recieve_date_time="",visit_ind="",ref_id_value="",cont_res_code="";

String alt_id1_exp_date_display="";
String alt_id2_exp_date_display="";
String alt_id3_exp_date_display="";
String alt_id4_exp_date_display="";
String dateofbirth_greg="";

int no_slots_val=0;

String c_name_prefix_accept_yn="",c_first_name_accept_yn="",c_second_name_accept_yn="",c_third_name_accept_yn="",c_family_name_accept_yn="",c_name_suffix_accept_yn="",ref_priority="";

String	BIRTH_PLACE_DESC="",CITIZEN_YN="",LEGAL_ILLEGAL_YN="",RACE_CODE="",RACE_DESC="",ETHNIC_GRP_CODE="",ETHNIC_GROUP_DESC="",BIRTH_PLACE_CODE="",birth_place_description="",NATIONALITY_CODE="",NATIONALITY="",ADDR_LINE1="",ADDR_LINE2="",ADDR_LINE3="",ADDR_LINE4="",REGION_CODE="",REGION_DESC="",RES_AREA_CODE="",RES_AREA_DESC="",RES_TOWN_CODE="",RES_TOWN_DESC="";

String	POSTAL_CODE="",COUNTRY_CODE="",COUNTRY_NAME="",CONTACT1_NO="",CONTACT2_NO="",EMAIL_ID="",MAIL_ADDR_LINE1="",MAIL_ADDR_LINE2="",MAIL_ADDR_LINE3="",MAIL_ADDR_LINE4="",MAIL_REGION_CODE="",MAIL_REGION_DESC="",MAIL_RES_AREA_CODE="",MAIL_AREA_DESC="",MAIL_RES_TOWN_CODE="",MAIL_RES_TOWN_DESC="",MAIL_POSTAL_CODE="",MAIL_COUNTRY_CODE="",MAIL_COUNTRY_NAME ="",OTH_ALT_ID_NO="",OTH_ALT_TYPE="",appt_clinic_code="",POSTAL_CODE_DESC="",MAIL_POSTAL_CODE_DESC="";

String alt_addr_line1="", alt_addr_line2="", alt_addr_line3="", alt_addr_line4="", alt_town_code="", alt_area_code="", alt_region_code="", alt_postal_code="", alt_country_code="", alt_area_desc="", alt_town_desc="", alt_region_desc="", alt_postal_desc="", alt_country_desc="";//Added by Thamizh selvi on 6th Feb 2018 against ML-MMOH-CRF-0601

boolean count_referral	=false;
String prm_res_class = (String)hash.get("prm_res_class");
if(prm_res_class ==null) prm_res_class="";

Statement stmt			=conn.createStatement();
Statement stmtap		=conn.createStatement();
Statement c_stmtn=conn.createStatement();
Statement stmt3=null,stmtpat=null,stmtc_p=null,stmt_wait_sec=null,stmt12=null;


ResultSet rsc_p=null,rset=null,rs=null,rs3=null,rsap=null,c_rs=null,rspat=null,rs12=null,rsappt=null,rs_wait_sec=null,rsappt_visit=null,rset_wtlt=null;
String pat_cat_code="",order_wtlt_code="",nationality_code="";

java.lang.StringBuffer sqlm=new java.lang.StringBuffer();
count_referral=true;
boolean valid_patient=true;
			String patient_cat_code="";
			String patient_cat_desc="";
try{	

	if(count_referral){
		if(to_pract_id!=null && to_pract_id.equals(pract_id)){
			count_referral=true;			
		}
		if(count_referral){				

			c_rs=c_stmtn.executeQuery("select name_prefix_accept_yn, first_name_accept_yn,second_name_accept_yn,third_name_accept_yn,family_name_accept_yn,name_suffix_accept_yn from mp_param");
			c_rs.next();
			c_name_prefix_accept_yn=c_rs.getString("name_prefix_accept_yn");
			c_first_name_accept_yn=c_rs.getString("first_name_accept_yn");
			c_second_name_accept_yn=c_rs.getString("second_name_accept_yn");
			c_third_name_accept_yn=c_rs.getString("third_name_accept_yn");
			c_family_name_accept_yn=c_rs.getString("family_name_accept_yn");
			c_name_suffix_accept_yn=c_rs.getString("name_suffix_accept_yn");
			if(c_rs !=null) c_rs.close();
			if(calledFor.equals("Referal")){
				sqlm.append("SELECT PATIENT_ID, PATIENT_NAME, NAME_PREFIX, FIRST_NAME, SECOND_NAME, THIRD_NAME, FAMILY_NAME, NAME_SUFFIX, SEX, DATE_OF_BIRTH, BIRTH_PLACE_CODE, MP_GET_DESC.MP_BIRTH_PLACE(BIRTH_PLACE_CODE,'"+locale+"','1') BIRTH_PLACE_DESC,  CITIZEN_YN, LEGAL_ILLEGAL_YN, RACE_CODE, MP_GET_DESC.MP_RACE(RACE_CODE,'"+locale+"','1') RACE_DESC, ETHNIC_GRP_CODE, MP_GET_DESC.MP_ETHNIC_GROUP(ETHNIC_GRP_CODE,'"+locale+"','1') ETHNIC_GROUP_DESC, NATIONALITY_CODE, MP_GET_DESC.MP_COUNTRY(NATIONALITY_CODE,'"+locale+"','3') NATIONALITY, ADDR_LINE1 ADDRESS, ADDR_LINE2, ADDR_LINE3, ADDR_LINE4, REGION_CODE, MP_GET_DESC.MP_REGION(REGION_CODE,'"+locale+"','1') REGION_DESC, RES_AREA_CODE, MP_GET_DESC.MP_RES_AREA(RES_AREA_CODE,'"+locale+"','1') RES_AREA_DESC, RES_TOWN_CODE, MP_GET_DESC.MP_RES_TOWN(RES_TOWN_CODE,'"+locale+"','1') RES_TOWN_DESC, POSTAL_CODE,MP_GET_DESC.MP_POSTAL_CODE(POSTAL_CODE,'"+locale+"','2') POSTAL_CODE_DESC, COUNTRY_CODE, MP_GET_DESC.MP_COUNTRY(COUNTRY_CODE,'"+locale+"','1') COUNTRY_NAME, CONTACT1_NO, CONTACT2_NO, EMAIL_ID, MAIL_ADDR_LINE1, MAIL_ADDR_LINE2, MAIL_ADDR_LINE3, MAIL_ADDR_LINE4, MAIL_REGION_CODE, MP_GET_DESC.MP_REGION(MAIL_REGION_CODE,'"+locale+"','1')MAIL_REGION_DESC, MAIL_RES_AREA_CODE, MP_GET_DESC.MP_RES_AREA(MAIL_RES_AREA_CODE,'"+locale+"','1') MAIL_AREA_DESC, MAIL_RES_TOWN_CODE, MP_GET_DESC.MP_RES_TOWN(MAIL_RES_TOWN_CODE,'"+locale+"','1') MAIL_RES_TOWN_DESC, MAIL_POSTAL_CODE,MP_GET_DESC.MP_POSTAL_CODE(MAIL_POSTAL_CODE,'"+locale+"','2') MAIL_POSTAL_CODE_DESC, MAIL_COUNTRY_CODE, MP_GET_DESC.MP_COUNTRY(MAIL_COUNTRY_CODE,'"+locale+"','1') MAIL_COUNTRY_NAME, alt_addr_line1, alt_addr_line2, alt_addr_line3, alt_addr_line4, alt_area_code, MP_GET_DESC.MP_RES_AREA(alt_area_code,'"+locale+"','1') alt_area_desc, alt_town_code, MP_GET_DESC.MP_RES_TOWN(alt_town_code,'"+locale+"','1') alt_town_desc, alt_region_code, MP_GET_DESC.MP_REGION(alt_region_code,'"+locale+"','1') alt_region_desc, alt_postal_code, MP_GET_DESC.mp_postal_code(alt_postal_code,'"+locale+"','2') alt_postal_desc, alt_country_code, MP_GET_DESC.MP_COUNTRY(alt_country_code,'"+locale+"','1') alt_country_desc, REFERRAL_PRIORITY, ALT_ID1_NO, ALT_ID2_NO, ALT_ID3_NO, ALT_ID3_NO, ALT_ID4_NO, NATIONAL_ID_NO,	TO_CHAR(ALT_ID1_DATE,'DD/MM/YYYY') ALT_ID1_EXP_DATE, TO_CHAR(ALT_ID2_DATE,'DD/MM/YYYY') ALT_ID2_EXP_DATE, TO_CHAR(ALT_ID3_DATE,'DD/MM/YYYY') ALT_ID3_EXP_DATE, TO_CHAR(ALT_ID4_DATE,'DD/MM/YYYY') ALT_ID4_EXP_DATE, OTH_ALT_ID_NO, OTH_ALT_ID_TYPE,NAME_PREFIX_LOC_LANG,FIRST_NAME_LOC_LANG,SECOND_NAME_LOC_LANG,THIRD_NAME_LOC_LANG,FAMILY_NAME_LOC_LANG,NAME_SUFFIX_LOC_LANG,PATIENT_NAME_LOC_LANG,patient_long_name,patient_long_name_loc_lang FROM PR_REFERRAL_REGISTER WHERE TO_FACILITY_ID='"+facilityid+"' AND  REFERRAL_ID='"+ref_id+"' ");//Modified by Thamizh selvi on 6th Feb 2018 against ML-MMOH-CRF-0601
				
				sqlm.append("AND STATUS IN('O','D') AND TO_SPECIALITY_CODE ='"+p_speciality_code+"'");
				

			}else if(calledFor.equals("WaitList") && !wait_list_num.equals("") ){
				sqlm.append("SELECT PATIENT_ID, PATIENT_NAME, NAME_PREFIX, FIRST_NAME, SECOND_NAME, THIRD_NAME, FAMILY_NAME, NAME_SUFFIX, GENDER SEX, DATE_OF_BIRTH, BIRTH_PLACE_CODE, MP_GET_DESC.MP_BIRTH_PLACE(BIRTH_PLACE_CODE,'"+locale+"','1') BIRTH_PLACE_DESC,  CITIZEN_YN, LEGAL_YN,  RACE_CODE, MP_GET_DESC.MP_RACE(RACE_CODE,'"+locale+"','1') RACE_DESC, ETHNIC_GROUP_CODE ETHNIC_GRP_CODE, MP_GET_DESC.MP_ETHNIC_GROUP(ETHNIC_GROUP_CODE,'"+locale+"','1') ETHNIC_GROUP_DESC, RES_COUNTRY_CODE, MP_GET_DESC.MP_COUNTRY(RES_COUNTRY_CODE,'"+locale+"','1') RES_COUNTRY_NAME, NATIONALITY_CODE, MP_GET_DESC.MP_COUNTRY(nationality_code,'"+locale+"','3') NATIONALITY, RES_ADDR_LINE1 ADDRESS, RES_ADDR_LINE2 ADDR_LINE2, RES_ADDR_LINE3 ADDR_LINE3, RES_ADDR_LINE4 ADDR_LINE4, RES_REGION_CODE REGION_CODE, MP_GET_DESC.MP_REGION(RES_REGION_CODE,'"+locale+"','1') REGION_DESC, RES_AREA_CODE, MP_GET_DESC.MP_RES_AREA(RES_AREA_CODE,'"+locale+"','1') RES_AREA_DESC, RES_TOWN_CODE, MP_GET_DESC.MP_RES_TOWN(RES_TOWN_CODE,'"+locale+"','1') RES_TOWN_DESC, RES_POSTAL_CODE POSTAL_CODE,MP_GET_DESC.MP_POSTAL_CODE(RES_POSTAL_CODE,'"+locale+"','2') POSTAL_CODE_DESC, MAIL_COUNTRY_CODE , MP_GET_DESC.MP_COUNTRY(MAIL_COUNTRY_CODE,'"+locale+"','1') MAIL_COUNTRY_NAME, RES_TEL_NO CONTACT1_NO, OTH_CONTACT_NO CONTACT2_NO, EMAIL_ID, MAIL_ADDR_LINE1, MAIL_ADDR_LINE2, MAIL_ADDR_LINE3, MAIL_ADDR_LINE4, MAIL_REGION_CODE, MP_GET_DESC.MP_REGION(MAIL_REGION_CODE,'"+locale+"','1')MAIL_REGION_DESC, MAIL_AREA_CODE MAIL_RES_AREA_CODE, MP_GET_DESC.MP_RES_AREA(MAIL_AREA_CODE,'"+locale+"','1') MAIL_AREA_DESC, MAIL_TOWN_CODE MAIL_RES_TOWN_CODE, MP_GET_DESC.MP_RES_TOWN(MAIL_TOWN_CODE,'"+locale+"','1') MAIL_RES_TOWN_DESC, MAIL_POSTAL_CODE,MP_GET_DESC.MP_POSTAL_CODE(MAIL_POSTAL_CODE,'"+locale+"','2') MAIL_POSTAL_CODE_DESC,'1' REFERRAL_PRIORITY, ALT_ID1_NO, ALT_ID2_NO, ALT_ID3_NO, ALT_ID3_NO, ALT_ID4_NO, NATIONAL_ID_NO,	TO_CHAR(ALT_ID1_EXP_DATE,'DD/MM/YYYY') ALT_ID1_EXP_DATE, TO_CHAR(ALT_ID2_EXP_DATE,'DD/MM/YYYY') ALT_ID2_EXP_DATE, TO_CHAR(ALT_ID3_EXP_DATE,'DD/MM/YYYY') ALT_ID3_EXP_DATE, TO_CHAR(ALT_ID4_EXP_DATE,'DD/MM/YYYY') ALT_ID4_EXP_DATE, OTH_ALT_ID_NO, OTH_ALT_ID_TYPE, BOOKING_REF_NO ,ORDER_CATALOG_CODE,NAME_PREFIX_LOC_LANG,FIRST_NAME_LOC_LANG,SECOND_NAME_LOC_LANG,THIRD_NAME_LOC_LANG,FAMILY_NAME_LOC_LANG,NAME_SUFFIX_LOC_LANG,PATIENT_NAME_LOC_LANG,patient_long_name,patient_long_name_loc_lang, alt_addr_line1, alt_addr_line2, alt_addr_line3, alt_addr_line4, alt_area_code, MP_GET_DESC.MP_RES_AREA(alt_area_code,'"+locale+"','1') alt_area_desc, alt_town_code, MP_GET_DESC.MP_RES_TOWN(alt_town_code,'"+locale+"','1') alt_town_desc, alt_region_code, MP_GET_DESC.MP_REGION(alt_region_code,'"+locale+"','1') alt_region_desc, alt_postal_code, MP_GET_DESC.mp_postal_code(alt_postal_code,'"+locale+"','2') alt_postal_desc, alt_country_code, MP_GET_DESC.MP_COUNTRY(alt_country_code,'"+locale+"','1') alt_country_desc FROM PR_WAIT_LIST WHERE FACILITY_ID='"+facilityid+"' AND  WAIT_LIST_NO='"+wait_list_num+"'");//Modified by Thamizh selvi on 6th Feb 2018 against ML-MMOH-CRF-0601

				
			}else if(calledFor.equals("modify_appt"))
			{
				sqlm.append("select PATIENT_ID,ORDER_CATALOG_CODE, PATIENT_NAME,NAME_PREFIX,FIRST_NAME,SECOND_NAME,THIRD_NAME,FAMILY_NAME,NAME_SUFFIX,NATIONAL_ID_NO,ALT_ID1_TYPE,ALT_ID1_NO,ALT_ID2_TYPE,ALT_ID2_NO,ALT_ID3_TYPE,ALT_ID3_NO,ALT_ID4_TYPE,ALT_ID4_NO,OTH_ALT_ID_TYPE,OTH_ALT_ID_NO,GENDER SEX,RACE_CODE,MP_GET_DESC.MP_RACE(RACE_CODE,'"+locale+"','1') RACE_DESC,ETHNIC_GROUP_CODE,MP_GET_DESC.MP_ETHNIC_GROUP(ETHNIC_GROUP_CODE,'"+locale+"','1') ETHNIC_DESC,BIRTH_PLACE_CODE,MP_GET_DESC.MP_BIRTH_PLACE(BIRTH_PLACE_CODE,'"+locale+"','1') BIRTH_PLACE_DESC,CITIZEN_YN,LEGAL_YN,RES_ADDR_LINE1 ADDRESS ,RES_ADDR_LINE2 ADDR_LINE2,RES_ADDR_LINE3 ADDR_LINE3,RES_ADDR_LINE4 ADDR_LINE4,RES_TOWN_CODE,MP_GET_DESC.MP_RES_TOWN(RES_TOWN_CODE,'"+locale+"','1') RES_TOWN_DESC,RES_AREA_CODE,POSTAL_CODE,MP_GET_DESC.MP_POSTAL_CODE(POSTAL_CODE,'"+locale+"','2') POSTAL_CODE_DESC,COUNTRY_CODE,MP_GET_DESC.MP_COUNTRY(COUNTRY_CODE,'"+locale+"','1') NATIONALITY_DESC,MP_GET_DESC.MP_RES_AREA(RES_AREA_CODE,'"+locale+"','1') RES_AREA_DESC,RES_REGION_CODE REGION_CODE, MP_GET_DESC.MP_REGION(RES_REGION_CODE,'"+locale+"','1') REGION_DESC,MAIL_ADDR_LINE1,MAIL_ADDR_LINE2,MAIL_ADDR_LINE3,MAIL_ADDR_LINE4,MAIL_TOWN_CODE MAIL_RES_TOWN_CODE,MP_GET_DESC.MP_RES_TOWN(MAIL_TOWN_CODE,'"+locale+"','1') MAIL_RES_TOWN_DESC,MAIL_AREA_CODE MAIL_RES_AREA_CODE, MP_GET_DESC.MP_RES_AREA(MAIL_AREA_CODE,'"+locale+"','1')  MAIL_AREA_DESC,MAIL_REGION_CODE,MP_GET_DESC.MP_REGION(MAIL_REGION_CODE,'"+locale+"','1') MAIL_REGION_DESC,MAIL_POSTAL_CODE,MP_GET_DESC.MP_POSTAL_CODE(MAIL_POSTAL_CODE,'"+locale+"','2') MAIL_POSTAL_CODE_DESC,MAIL_COUNTRY_CODE,MP_GET_DESC.MP_COUNTRY(MAIL_COUNTRY_CODE,'"+locale+"','1')MAIL_COUNTRY_NAME,referral_priority,alt_id1_no,alt_id2_no,alt_id3_no,alt_id3_no,alt_id4_no,national_id_no,to_char(ALT_ID1_EXP_DATE,'dd/mm/yyyy')alt_id1_exp_date,to_char(ALT_ID2_EXP_DATE,'dd/mm/yyyy') alt_id2_exp_date,to_char(ALT_ID3_EXP_DATE,'dd/mm/yyyy') alt_id3_exp_date,to_char(ALT_ID4_EXP_DATE,'dd/mm/yyyy') alt_id4_exp_date,date_of_birth,RES_TEL_NO CONTACT1_NO,OTH_CONTACT_NO CONTACT2_NO ,EMAIL_ID ,NAME_PREFIX_LOC_LANG,FIRST_NAME_LOC_LANG,SECOND_NAME_LOC_LANG,THIRD_NAME_LOC_LANG,FAMILY_NAME_LOC_LANG,NAME_SUFFIX_LOC_LANG,PATIENT_NAME_LOC_LANG,patient_long_name,patient_long_name_loc_lang ,RES_COUNTRY_CODE , MP_GET_DESC.MP_COUNTRY(RES_COUNTRY_CODE,'"+locale+"','1') RES_COUNTRY_NAME,AM_GET_DESC.AM_CONTACT_REASON(CONTACT_REASON_CODE,'"+locale+"','1') CONTACT_REASON,to_char(RECEIVING_DATE_TIME,'dd/mm/yyyy hh24:mi') RECEIVING_DATE_TIME,APPT_REMARKS,MODE_OF_CONTACT,contact_reason_code, alt_addr_line1, alt_addr_line2, alt_addr_line3, alt_addr_line4, alt_area_code, MP_GET_DESC.MP_RES_AREA(alt_area_code,'"+locale+"','1') alt_area_desc, alt_town_code, MP_GET_DESC.MP_RES_TOWN(alt_town_code,'"+locale+"','1') alt_town_desc, alt_region_code, MP_GET_DESC.MP_REGION(alt_region_code,'"+locale+"','1') alt_region_desc, alt_postal_code, MP_GET_DESC.mp_postal_code(alt_postal_code,'"+locale+"','2') alt_postal_desc, alt_country_code, MP_GET_DESC.MP_COUNTRY(alt_country_code,'"+locale+"','1') alt_country_desc from oa_appt where appt_ref_no='"+apptrefno+"' and FACILITY_ID='"+facilityid+"'");//Modified by Thamizh selvi on 6th Feb 2018 against ML-MMOH-CRF-0601
			}
			/*else if(calledFor.equals("Mr_appt"))
			{
				sqlm="select PATIENT_ID, PATIENT_NAME,NAME_PREFIX,FIRST_NAME,SECOND_NAME,THIRD_NAME,FAMILY_NAME,NAME_SUFFIX,NATIONAL_ID_NO,ALT_ID1_TYPE,ALT_ID1_NO,ALT_ID2_TYPE,ALT_ID2_NO,ALT_ID3_TYPE,ALT_ID3_NO,ALT_ID4_TYPE,ALT_ID4_NO,OTH_ALT_ID_TYPE,OTH_ALT_ID_NO,SEX,GENDER,RACE_CODE,RACE_DESC,ETHNIC_GRP_CODE,ETHNIC_DESC,BIRTH_PLACE_CODE,BIRTH_PLACE_DESC,CITIZEN_YN,LEGAL_ILLEGAL_YN,RES_ADDR_LINE1,RES_ADDR_LINE2,RES_ADDR_LINE3,RES_ADDR_LINE4,RES_TOWN_CODE,RES_TOWN_SHORT_DESC,RES_AREA_CODE,RES_AREA_SHORT_DESC,RES_REGION_CODE,RES_REGION_SHORT_DESC,RES_POSTAL_CODE,RES_POSTAL_SHORT_DESC,RES_COUNTRY_CODE,RES_COUNTRY_LONG_DESC,MAIL_ADDR_LINE1,MAIL_ADDR_LINE2,MAIL_ADDR_LINE3,MAIL_ADDR_LINE4,MAIL_TOWN_CODE,MAIL_TOWN_SHORT_DESC,MAIL_AREA_CODE,MAIL_AREA_SHORT_DESC,MAIL_REGION_CODE,MAIL_REGION_SHORT_DESC,MAIL_POSTAL_CODE,MAIL_POSTAL_SHORT_DESC,MAIL_COUNTRY_CODE,MAIL_COUNTRY_LONG_DESC,APPL_RES_TEL_NO,APPL_MOB_TEL_NO,APPL_EMAIL_ID,alt_id1_no,alt_id2_no,alt_id3_no,alt_id3_no,alt_id4_no,national_id_no,		to_char(ALT_ID1_EXP_DATE,'dd/mm/yyyy')alt_id1_exp_date,to_char(ALT_ID2_EXP_DATE,'dd/mm/yyyy') alt_id2_exp_date,to_char(ALT_ID3_EXP_DATE,'dd/mm/yyyy') alt_id3_exp_date,to_char(ALT_ID4_EXP_DATE,'dd/mm/yyyy') alt_id4_exp_date,NATIONALITY_CODE,date_of_birth from MR_REPORT_REQUEST_HDR_VW where request_id='"+req_id+"' and FACILITY_ID='"+facilityid+"' ";
			}*/

			if(!sqlm.toString().equals("")){
			rset=stmt.executeQuery(sqlm.toString());

			if(rset!=null) {
			if(rset.next()){
			String patientid=rset.getString("patient_id");
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
					var err_age2 = getMessage( "SUSPENDED_NOT_ALLOWED" ,"OA") ;
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
					var err_age3 = getMessage( "INVALID_PATIENT" ,"MP") ;
					alert("hi"+err_age3);
					clear_all_fun1("R");
			<% }
		}	
		
		if((patientid.equals("")&&(valid_patient))||((!patientid.equals(""))&&(valid_patient))) {
				String patientname=rset.getString("patient_name");
				String patientname_local_lang =rset.getString("PATIENT_NAME_LOC_LANG");
				String patient_long_name =rset.getString("patient_long_name")==null?"":rset.getString("patient_long_name");
				String patient_long_name_loc_lang =rset.getString("patient_long_name_loc_lang")==null?"":rset.getString("patient_long_name_loc_lang");
				if(patientname_local_lang ==null) patientname_local_lang="";
				if(!calledFor.equals("modify_appt")){
					nationality_code=rset.getString("nationality_code");
				}else
				{
					nationality_code=rset.getString("country_code");
				}
			 if(nationality_code==null)	 nationality_code="";
				

			String nationalid=null;
			String alternateid=null;
			String alternateid1=null;
			String alternateid3=null;
			String alternateid4=null;
			String prefix=rset.getString("name_prefix");
			String firstname=rset.getString("first_name");
			ref_priority	=rset.getString("referral_priority");
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

			if(calledFor.equals("Referal")){
						LEGAL_ILLEGAL_YN=rset.getString("LEGAL_ILLEGAL_YN");
			}else
			{
				LEGAL_ILLEGAL_YN=rset.getString("LEGAL_YN");
			}
			 if(LEGAL_ILLEGAL_YN==null) LEGAL_ILLEGAL_YN="";


			RACE_CODE=rset.getString("RACE_CODE");
			 if(RACE_CODE==null) RACE_CODE="";
			RACE_DESC=rset.getString("RACE_DESC");
			 if(RACE_DESC==null) RACE_DESC="";
			
		if(!calledFor.equals("modify_appt")){

			ETHNIC_GRP_CODE=rset.getString("ETHNIC_GRP_CODE");
			 if(ETHNIC_GRP_CODE==null) ETHNIC_GRP_CODE="";
			ETHNIC_GROUP_DESC=rset.getString("ETHNIC_GROUP_DESC");
			 if(ETHNIC_GROUP_DESC==null) ETHNIC_GROUP_DESC="";
		}else
		{
			
			ETHNIC_GRP_CODE=rset.getString("ETHNIC_GROUP_CODE");
			 if(ETHNIC_GRP_CODE==null) ETHNIC_GRP_CODE="";
			//ETHNIC_GROUP_DESC=rset.getString("ETHNIC_GROUP_DESC");
			// if(ETHNIC_GROUP_DESC==null) ETHNIC_GROUP_DESC="";
		}

			BIRTH_PLACE_CODE=rset.getString("BIRTH_PLACE_CODE");
			 if(BIRTH_PLACE_CODE==null) BIRTH_PLACE_CODE="";
			birth_place_description=rset.getString("BIRTH_PLACE_DESC");
			 if(birth_place_description==null) birth_place_description="";

if(!calledFor.equals("modify_appt")){
			NATIONALITY_CODE=rset.getString("NATIONALITY_CODE");
			 if(NATIONALITY_CODE==null) NATIONALITY_CODE="";
			NATIONALITY=rset.getString("NATIONALITY");
			if(NATIONALITY==null) NATIONALITY="";
}else
{
	NATIONALITY_CODE=rset.getString("COUNTRY_CODE");
			 if(NATIONALITY_CODE==null) NATIONALITY_CODE="";
			NATIONALITY=rset.getString("NATIONALITY_DESC");
			if(NATIONALITY==null) NATIONALITY="";
}
		 
			ADDR_LINE1=rset.getString("address");
			 if(ADDR_LINE1==null) ADDR_LINE1="";
			ADDR_LINE2=rset.getString("ADDR_LINE2");
			 if(ADDR_LINE2==null) ADDR_LINE2="";
			ADDR_LINE3=rset.getString("ADDR_LINE3");
			 if(ADDR_LINE3==null) ADDR_LINE3="";
			ADDR_LINE4=rset.getString("ADDR_LINE4");
			 if(ADDR_LINE4==null) ADDR_LINE4="";
			
			REGION_CODE=rset.getString("REGION_CODE");
			 if(REGION_CODE==null) REGION_CODE="";
			REGION_DESC=rset.getString("REGION_DESC");
			 if(REGION_DESC==null) REGION_DESC="";
			
			RES_AREA_CODE=rset.getString("RES_AREA_CODE");
			 if(RES_AREA_CODE==null) RES_AREA_CODE="";
			RES_AREA_DESC=rset.getString("RES_AREA_DESC");
			 if(RES_AREA_DESC==null) RES_AREA_DESC="";
			
			RES_TOWN_CODE=rset.getString("RES_TOWN_CODE");
			 if(RES_TOWN_CODE==null) RES_TOWN_CODE="";
			RES_TOWN_DESC=rset.getString("RES_TOWN_DESC");
			 if(RES_TOWN_DESC==null) RES_TOWN_DESC="";
			POSTAL_CODE=rset.getString("POSTAL_CODE");
			 if(POSTAL_CODE==null) POSTAL_CODE="";

			 POSTAL_CODE_DESC=rset.getString("POSTAL_CODE_DESC");
			 if(POSTAL_CODE_DESC==null) POSTAL_CODE_DESC="";
			
			if(calledFor.equals("WaitList") ||calledFor.equals("modify_appt")){
			COUNTRY_CODE=rset.getString("RES_COUNTRY_CODE");	
			order_wtlt_code= rset.getString("ORDER_CATALOG_CODE");
			if(order_wtlt_code ==null) order_wtlt_code="";
			}else
			{
			COUNTRY_CODE=rset.getString("COUNTRY_CODE");
			}
			 if(COUNTRY_CODE==null) COUNTRY_CODE="";
			if(calledFor.equals("WaitList") || calledFor.equals("modify_appt") ){
			COUNTRY_NAME=rset.getString("RES_COUNTRY_NAME");
			}else
			{
				COUNTRY_NAME=rset.getString("COUNTRY_NAME");
			}

			 if(COUNTRY_NAME==null) COUNTRY_NAME="";
			CONTACT1_NO=rset.getString("CONTACT1_NO");
			 if(CONTACT1_NO==null) CONTACT1_NO="";
			CONTACT2_NO=rset.getString("CONTACT2_NO");
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
			MAIL_REGION_DESC=rset.getString("MAIL_REGION_DESC");
			 if(MAIL_REGION_DESC==null) MAIL_REGION_DESC="";
			MAIL_RES_AREA_CODE=rset.getString("MAIL_RES_AREA_CODE");
			 if(MAIL_RES_AREA_CODE==null) MAIL_RES_AREA_CODE="";
			MAIL_AREA_DESC=rset.getString("MAIL_AREA_DESC");
			 if(MAIL_AREA_DESC==null) MAIL_AREA_DESC="";
			MAIL_RES_TOWN_CODE=rset.getString("MAIL_RES_TOWN_CODE");
			 if(MAIL_RES_TOWN_CODE==null) MAIL_RES_TOWN_CODE="";
			MAIL_RES_TOWN_DESC=rset.getString("MAIL_RES_TOWN_DESC");
			 if(MAIL_RES_TOWN_DESC==null) MAIL_RES_TOWN_DESC="";
			MAIL_POSTAL_CODE=rset.getString("MAIL_POSTAL_CODE");
			 if(MAIL_POSTAL_CODE==null) MAIL_POSTAL_CODE="";

			  MAIL_POSTAL_CODE_DESC=rset.getString("MAIL_POSTAL_CODE_DESC");
			 if(MAIL_POSTAL_CODE_DESC==null) MAIL_POSTAL_CODE_DESC="";

			MAIL_COUNTRY_CODE=rset.getString("MAIL_COUNTRY_CODE");
			 if(MAIL_COUNTRY_CODE==null) MAIL_COUNTRY_CODE="";
			MAIL_COUNTRY_NAME =rset.getString("MAIL_COUNTRY_NAME");
			 if(MAIL_COUNTRY_NAME==null) MAIL_COUNTRY_NAME="";

			alt_id1_exp_date = rset.getString("alt_id1_exp_date");		
			if (alt_id1_exp_date==null) alt_id1_exp_date="";
			alternateid = rset.getString("alt_id1_no");
			if (alternateid==null) alternateid="";
	
			alt_id2_exp_date = rset.getString("alt_id2_exp_date");
			if (alt_id2_exp_date==null) alt_id2_exp_date="";
			alternateid1 = rset.getString("alt_id2_no");
			if (alternateid1==null) alternateid1="";
			alt_id3_exp_date = rset.getString("alt_id3_exp_date");
			if (alt_id3_exp_date==null) alt_id3_exp_date="";
			alternateid3 = rset.getString("alt_id3_no");
			if (alternateid3==null) alternateid3="";

			alt_id4_exp_date = rset.getString("alt_id4_exp_date");
			if (alt_id4_exp_date==null) alt_id4_exp_date="";
			alternateid4 = rset.getString("alt_id4_no");
			if (alternateid4==null) alternateid4="";

			nationalid= rset.getString("national_id_no");
			if (nationalid==null) nationalid="";

			OTH_ALT_ID_NO= rset.getString("OTH_ALT_ID_NO");
			if (OTH_ALT_ID_NO==null) OTH_ALT_ID_NO="";
			OTH_ALT_TYPE= rset.getString("OTH_ALT_ID_TYPE");
			if (OTH_ALT_TYPE==null) OTH_ALT_TYPE="";
			String suffix=rset.getString("name_suffix");

			String gender=rset.getString("sex");

			String restelno=rset.getString("contact1_no");
			if(restelno==null)
				 restelno="";
			String othtelno=rset.getString("contact2_no");
			if(othtelno==null)
				 othtelno="";

			
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

if(calledFor.equals("modify_appt"))
{
contact_reason_code=rset.getString("contact_reason_code");
			if(contact_reason_code ==null) contact_reason_code="";

reason_for_transfer=rset.getString("CONTACT_REASON");
			if(reason_for_transfer ==null) reason_for_transfer="";
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
}
			java.util.Date date1 = rset.getDate("date_of_birth");

			SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
			String dateofbirth=formatter1.format(date1);
			formatter1 = null;
			dateofbirth_greg = dateofbirth;
			
			dateofbirth=DateUtils.convertDate(dateofbirth,"DMY","en",locale);

			stmt3=conn.createStatement();

			//for wt list

			if(calledFor.equals("WaitList")){

				 appt_num = rset.getString("BOOKING_REF_NO");
				

				String sqlappt= "select APPT_REMARKS, clinic_code, AM_GET_DESC.AM_CONTACT_REASON(CONTACT_REASON_CODE,'"+locale+"','1') CONTACT_REASON, OP_GET_DESC.OP_VISIT_TYPE(FACILITY_ID, APPT_TYPE_CODE,'"+locale+"','2') VISIT_TYPE_SHORT_DESC, RECEIVING_DATE_TIME, (SELECT VISIT_TYPE_IND FROM OP_VISIT_TYPE WHERE FACILITY_ID = '"+facilityid+"' AND VISIT_TYPE_CODE = APPT_TYPE_CODE) VISIT_TYPE_IND, REFERRAL_ID, NO_OF_SLOTS, CONTACT_REASON_CODE from oa_appt where appt_ref_no ='"+appt_num+"' and facility_id = '"+facilityid+"'";
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
					appt_clinic_code=rsappt.getString("clinic_code");
					if(appt_clinic_code ==null) appt_clinic_code="";
					
				
				}
				String visit_type_code="";
				String sql_visit_type="select visit_type_code from op_visit_type_for_clinic_vw where facility_id='"+facilityid+"' and visit_type_short_desc ='"+visit_type_desc+"' and visit_type_ind ='"+visit_ind+"' and eff_status='E' and clinic_code='"+appt_clinic_code+"' and visit_type_ind != 'E'";

				rsappt_visit=stmt3.executeQuery(sql_visit_type);

				if(rsappt_visit !=null && rsappt_visit.next())
				{
					visit_type_code=rsappt_visit.getString("visit_type_code");
					if(visit_type_code ==null) visit_type_code="";
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
					document.getElementById("SecResource").disabled=false;
					document.getElementById("SecResCheck").value='Y';
				<%}else{%>
					document.getElementById("SecResource").disabled=true;
					document.getElementById("SecResCheck").value='N';
				<%}%>
				document.forms[0].sec_req.value="<%=sec_resources%>";
				document.forms[0].sec_sel.value="";
				<%	

			}//wait list

			if(calledFor.equals("WaitList")  )
			{ %>
				document.forms[0].order_catalog_criteria.value="<%=order_wtlt_code%>";
			<% }

			// edn wt lst

			rs3=stmt3.executeQuery("select calculate_age('"+dateofbirth_greg+"',1) year ,calculate_age('"+dateofbirth_greg+"',2) month ,calculate_age('"+dateofbirth_greg+"',3) day from dual");
			rs3.next();
			String agey=rs3.getString("year");
			String agem=rs3.getString("month");
			String aged=rs3.getString("day");


			if (nationality_code!=""){
				if(!alcn_criteria_pop.equals("NG")){
					pat_cat_code = "*O";
				}	
			}else{
				pat_cat_code = "*O";
			}

			if(!patientid.equals("")){
				if(rs3!=null)rs3.close();
				rs3=stmt3.executeQuery("select PAT_CAT_CODE,mp_get_desc.MP_PAT_CATEGORY(PAT_CAT_CODE,'"+locale+"',2) pat_cat_desc from mp_patient where patient_id='"+patientid+"'");
				if(rs3!=null && rs3.next()){
					patient_cat_code=rs3.getString("PAT_CAT_CODE")==null?"":rs3.getString("PAT_CAT_CODE");
					patient_cat_desc=rs3.getString("pat_cat_desc")==null?"":rs3.getString("pat_cat_desc");
				}				
			}

			if(ref_priority!=null){%>
				document.forms[0].ref_priority.value="<%=ref_priority%>";					
				<%	
			}
			
			%>
			//document.forms[0].patient_SecurityLevel.value="<%//=security_level%>";
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
<%if(patientname_local_lang!=null){%>		
				document.getElementById("patient_name_local_lang1").innerHTML="<%=patientname_local_lang%>";
				document.getElementById("patient_name_local_lang").value="<%=patientname_local_lang%>";
			<%}else{%>
				
			<%}%>
			<%if(patient_long_name!=null){%>					 
				document.getElementById("patient_name_long").value="<%=patient_long_name%>";
			<%}else{%>
				
			<%}%>

			<%if(patient_long_name_loc_lang!=null){%>					 
				document.getElementById("patient_name_loc_lang_long").value="<%=patient_long_name_loc_lang%>";
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
			<% } %>

			<% if(c_first_name_accept_yn.equals("Y")){ %>
			  if(document.forms[0].first_name) {
				 document.forms[0].first_name.value="<%=firstname%>";
				 document.forms[0].first_name.disabled=true;
				 if(document.forms[0].bf)
				 document.forms[0].bf.disabled=true;//added by  munisekhar  for [IN:046231]
				}
			<% } %>

			<% if(c_second_name_accept_yn.equals("Y")){%>
				 if(document.forms[0].second_name) {
					document.forms[0].second_name.value="<%=secondname%>";
					document.forms[0].second_name.disabled=true;
					if(document.forms[0].bs)
					document.forms[0].bs.disabled=true;//added by  munisekhar  for [IN:046231]
				}
			<% } %>

			<% if(c_third_name_accept_yn.equals("Y")){ %>
				if(document.forms[0].third_name) {
					document.forms[0].third_name.value="<%=thirdname%>"; 				
					document.forms[0].third_name.disabled=true;
					if(document.forms[0].bt)
					document.forms[0].bt.disabled=true;//added by  munisekhar  for [IN:046231]
				}
			<% } 
			/** Friday, February 12, 2010 IN000244 Start 
			*/
 %>
    <%if(c_family_name_accept_yn.equals("Y")){ %>
			if(document.forms[0].family_name) {
				document.forms[0].family_name.value="<%=familyname%>";
			    document.forms[0].family_name.disabled=true;
				if(document.forms[0].bfam)
				document.forms[0].bfam.disabled=true;
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

		<%
				if(name_prefix_oth_lang!=null) {%>
					if(document.forms[0].name_prefix_oth_lang){
					document.forms[0].name_prefix_oth_lang.value="<%=name_prefix_oth_lang%>";
					document.forms[0].name_prefix_oth_lang.disabled=true;
					}
				<%}else {%>
				if(document.forms[0].name_prefix_oth_lang){
					document.forms[0].name_prefix_oth_lang.value='';
					document.forms[0].name_prefix_oth_lang.disabled=true;
					}
				<%} /** END*/%>
				
			


		<%	if(firstname_local_lang!=null) {%>
				if(document.forms[0].first_name_oth_lang){
					document.forms[0].first_name_oth_lang.value="<%=firstname_local_lang%>";
					document.forms[0].first_name_oth_lang.disabled=true;
					if(document.forms[0].bfo)
					document.forms[0].bfo.disabled=true;
					}
				<% }else {%>
				if(document.forms[0].first_name_oth_lang){
					document.forms[0].first_name_oth_lang.value='';
					document.forms[0].first_name_oth_lang.disabled=true;
					if(document.forms[0].bfo)
					document.forms[0].bfo.disabled=true;
					}
				<%}%>
				
	<%	if(secondname_local_lang!=null) {%>
					if(document.forms[0].second_name_oth_lang){
					document.forms[0].second_name_oth_lang.value="<%=secondname_local_lang%>";
					document.forms[0].second_name_oth_lang.disabled=true;
					if(document.forms[0].bso)
					document.forms[0].bso.disabled=true;
					}
				<% }else {%>
					if(document.forms[0].second_name_oth_lang){
					document.forms[0].second_name_oth_lang.value='';
					document.forms[0].second_name_oth_lang.disabled=true;
					if(document.forms[0].bso)
					document.forms[0].bso.disabled=true;
					}
				<%}%>


	<%	if(thirdname_local_lang!=null) {%>
					if(document.forms[0].third_name_oth_lang){
					document.forms[0].third_name_oth_lang.value="<%=thirdname_local_lang%>";
					document.forms[0].third_name_oth_lang.disabled=true;
					if(document.forms[0].bto)
					document.forms[0].bto.disabled=true;
					}
				<% }else {%>
					if(document.forms[0].third_name_oth_lang){
					document.forms[0].third_name_oth_lang.value='';
					document.forms[0].third_name_oth_lang.disabled=true;
					if(document.forms[0].bto)
					document.forms[0].bto.disabled=true;
					}
				<%}%>

	<%	if(familyname_local_lang!=null) {%>
					if(document.forms[0].family_name_oth_lang){
					document.forms[0].family_name_oth_lang.value="<%=familyname_local_lang%>";
					document.forms[0].family_name_oth_lang.disabled=true;
					if(document.forms[0].bfamo)
					document.forms[0].bfamo.disabled=true;
					}
				<% }else {%>
					if(document.forms[0].family_name_oth_lang){
					document.forms[0].family_name_oth_lang.value='';
					document.forms[0].family_name_oth_lang.disabled=true;
					if(document.forms[0].bfamo)
					document.forms[0].bfamo.disabled=true;
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
			
			


		document.forms[0].sex.value="<%=gender%>";
		document.forms[0].sex.disabled=true;
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

		document.forms[0].r_postal_code_desc.value="<%=POSTAL_CODE_DESC%>"
		document.forms[0].m_postal_code_desc.value="<%=MAIL_POSTAL_CODE_DESC%>"

		document.forms[0].region_desc.value = "<%=REGION_DESC%>";
		document.forms[0].country_code.value = "<%=COUNTRY_CODE%>";
		document.forms[0].country_desc.value = "<%=COUNTRY_NAME%>";
		document.forms[0].mail_addr_line1.value = "<%=MAIL_ADDR_LINE1%>";
		document.forms[0].mail_addr_line2.value = "<%=MAIL_ADDR_LINE2%>";
		document.forms[0].mail_addr_line3.value = "<%=MAIL_ADDR_LINE3%>";
		document.forms[0].mail_addr_line4.value = "<%=MAIL_ADDR_LINE4%>";
		document.forms[0].mail_res_town_code.value = "<%=MAIL_RES_TOWN_CODE%>";
		document.forms[0].mail_res_town_desc.value = "<%=MAIL_RES_TOWN_DESC%>";
		document.forms[0].mail_res_area_code.value = "<%=MAIL_RES_AREA_CODE%>";
		document.forms[0].mail_res_area_desc.value ="<%=MAIL_AREA_DESC%>";
		document.forms[0].mail_postal_code.value = "<%=MAIL_POSTAL_CODE%>";
		document.forms[0].mail_region_code.value = "<%=MAIL_REGION_CODE%>";
		document.forms[0].mail_region_desc.value = "<%=MAIL_REGION_DESC%>";
		document.forms[0].mail_country_code.value = "<%=MAIL_COUNTRY_CODE%>";
		document.forms[0].mail_country_desc.value = "<%=MAIL_COUNTRY_NAME%>";
		document.forms[0].contact1_no.value ="<%=CONTACT1_NO%>";
		document.forms[0].contact2_no.value ="<%=CONTACT2_NO%>";
		document.forms[0].email.value ="<%=EMAIL_ID%>";

		document.forms[0].Birth_place_code.value ="<%=BIRTH_PLACE_CODE%>";
		document.forms[0].birth_place.value ="<%=birth_place_description%>";
		
		document.forms[0].place_of_birth.value ="<%=birth_place_description%>";
		document.forms[0].place_of_birth.disabled = true;
		document.forms[0].nationality_code1.value = "<%=NATIONALITY_CODE%>";
		document.forms[0].nationality_desc.value = "<%=NATIONALITY%>";
		document.forms[0].nationality_desc.disabled = true;
		document.forms[0].nationality_id.disabled = true;
		document.forms[0].birth_place.disabled = true;
		document.forms[0].b_birth.disabled = true;

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

		if('<%=CITIZEN_YN%>'=='Y'){
			document.forms[0].citizen_yn[0].checked = true;

		}else{
			document.forms[0].citizen_yn[1].checked = true;
			//document.getElementById("eth_gif").style.visibility='hidden';
			//document.getElementById("race_yn").value = 'N';
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
				opt.text = "<%=ETHNIC_GROUP_DESC%>";
				opt.value=  "<%=ETHNIC_GRP_CODE%>";
					
				document.forms[0].ethnic_group.add(opt);
				//document.forms[0].ethnic_group.value="<%=ETHNIC_GRP_CODE%>";
			}else{
				
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

		document.forms[0].date_of_birth.value="<%=dateofbirth%>";
		document.forms[0].date_of_birth.disabled=true;
		
		document.forms[0].b_age.value="<%=agey%>";
		document.forms[0].b_age.disabled=true;
		document.forms[0].b_months.value="<%=agem%>";
		document.forms[0].b_months.disabled=true;
		document.forms[0].b_days.value="<%=aged%>";
		document.forms[0].b_days.disabled=true;
		if(document.forms[0].pat_cat_code){	
			if('<%=patient_cat_code%>' !=''){				
				document.forms[0].pat_cat_code.value="<%=patient_cat_code%>";
				document.forms[0].pat_cat_desc.value="<%=patient_cat_desc%>";
				document.forms[0].pat_cat_desc.disabled = true;
				document.forms[0].pat_cat_code_id.disabled = true;
			}else{				
				document.forms[0].pat_cat_code.value='';
				document.forms[0].pat_cat_desc.value='';
			}			
		}
			<%if(calledFor.equals("modify_appt"))
			{%>				
			document.forms[0].reason.value="<%=reason_for_transfer%>";							
			document.forms[0].reason_for_contact.value="<%=contact_reason_code%>";							
			document.forms[0].rec_date.value="<%=receiving_date_time_display%>";
			document.forms[0].remarks.value="<%=appt_remarks%>";
			document.forms[0].mode.value="<%=mode_of_contact%>";
			<%}%>
				
		<%		

		if (!patientid.equals("")){
			

			String alt_status1 = patdata.CheckAlternateId(conn,patientid,locale);
			
			
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
					
					String val1=alt_status1.substring(2,alt_status1.length());	out.println("alert(\""+val1+"\");");
				}
			}
		}
	}else{
		if (valid_patient){%>  
		alert("hi 1033");
			alert(getMessage('INVALID_REF_ID','OP'));
			document.forms[0].source.value='';
			//document.forms[0].search.disabled = false;

			clearAll1()
		<%
		}
	}
}else{
	if(valid_patient){%>  
	alert("hi 1044");
		alert(getMessage('INVALID_REF_ID','OP'));
		document.forms[0].source.value='';
		//document.forms[0].search.disabled = false; 
		clearAll1()
	<%
	}
}
}
			}
if(rset !=null) rset.close();
}//referral
}
	if(rs3 !=null) rs3.close();
	if(c_rs != null) c_rs.close();
	if(rs != null) rs.close();
	if(rs12 !=null) rs12.close();
	if(rspat != null) rspat.close();
	if(rset_wtlt !=null)rset_wtlt.close();
	if(rsc_p != null) rsc_p.close();
	if(rset != null) rset.close();
	if(rsap != null) rsap.close();
	if(stmt != null) stmt.close();
	if(stmtap != null) stmtap.close();
	if(stmtpat != null) stmtpat.close();
	if(stmtc_p != null) stmtc_p.close();
	if(stmt3 != null) stmt3.close();
	if(c_stmtn !=null) c_stmtn.close();
	if(stmt12 !=null) stmt12.close();
	hash.clear();
}catch(Exception e) {
	String error = e.toString();
	error = error.replace('\n',',');
	%>
	alert('<%=error%>');	
	clear_fun_all();
	<%
}finally{
	
	ConnectionManager.returnConnection(conn,request);
}
%>
<%!

public static String checkForNull(String inputString)
{
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
}

%>

