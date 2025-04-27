<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"
	import="java.sql.*,webbeans.eCommon.*,java.util.StringTokenizer,java.util.*,com.ehis.util.*,java.io.* ,eCommon.Common.*,eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
Connection con = null;
try{
	 con = ConnectionManager.getConnection(request);
} catch(Exception e)
{
	e.printStackTrace();

}
String locale			= (String)session.getAttribute("LOCALE");
String patient			= request.getParameter("Patient_ID");
String function_id		= request.getParameter("function_id");
String Facility_Id = (String) session.getValue("facility_id"); 


String disp_dup_pat_dtls=checkForNull(request.getParameter("disp_dup_pat_dtls"));
String group_status=checkForNull(request.getParameter("group_status")) ; 

String Patient_id="";

String Pat_Ser_Grp_Desc ="";
String Pref_Facility_Name ="";
String accept_national_id_no_yn ="";
String nat_id_prompt ="";
String National_Id_No ="";
String accept_oth_alt_id_yn ="";
String demo_oth_alt_id_desc ="";
String demo_oth_alt_id_no ="";
String Alt_Id1_Type ="";
String Alt_Id1_No ="";
String alt_id1_exp_date_accept_yn ="";
String Alt_Id1_Exp_Date ="";
String Alt_Id2_Type ="";
String Alt_Id2_No ="";
String alt_id2_exp_date_accept_yn="";
String Alt_Id2_Exp_Date ="";
String Alt_Id3_Type ="";
String Alt_Id3_No ="";
String alt_id3_exp_date_accept_yn ="";
String Alt_Id3_Exp_Date ="";
String Alt_Id4_Type ="";
String Alt_Id4_No ="";
String alt_id4_exp_date_accept_yn ="";
String Alt_Id4_Exp_Date ="";
String family_org_id_accept_yn ="";
String MembershipType ="";
String header_width="25%";	
String data_width ="25%";
String data_word_wrap="";
String Orgsubname ="";
String Orgname ="";
String Family_No_Link_Yn="";
String Family_Link_No="";
String head_patient_name="";
String Relationship_Name="";

String First_Name_Accept_Yn ="";
int First_Name_Order=0;
String First_Name_Prompt ="";
String Second_Name_Accept_Yn ="";
int Second_Name_Order =0;
String Second_Name_Prompt ="";
String Third_Name_Accept_Yn ="";
int Third_Name_Order =0;
String Third_Name_Prompt ="";
String Family_Name_Accept_Yn ="";
int Family_Name_Order =0;
String Family_Name_Prompt ="";
String Name_Suffix_Accept_Yn ="";
String Name_Suffix_Prompt ="";
String Name_Prefix_Accept_Yn = "";
String Name_Prefix_Prompt = "";

String Name_Prefix     ="";
String First_Name      ="";
String Second_Name    ="";
String Third_Name     ="";
String Family_Name    ="";
String Name_Suffix   ="";

String names_in_oth_lang_yn="";
String language_direction="";

String name_prefix_loc_lang_prompt  ="" ;
String first_name_loc_lang_prompt   ="" ;
String second_name_loc_lang_prompt  ="" ;
String third_name_loc_lang_prompt   ="" ;
String family_name_loc_lang_prompt  ="" ;
String name_suffix_loc_lang_prompt  ="" ;

String name_prefix_loc_lang  =""   ;
String first_name_loc_lang      =""  ;
String second_name_loc_lang=""    ; 
String third_name_loc_lang    =""    ;
String family_name_loc_lang  =""   ;
String name_suffix_loc_lang   =""  ;
String patient_name_loc_lang=""    ;

String Sex          ="";
String blood_grp_desc="";
String rh_factor_desc="";
String age_value = "";
String Date_Of_Birth  ="";
String Place_Of_Birth ="";
String hijri_birth_date="";
Boolean hijirisitespecifApplicable = CommonBean.isSiteSpecific(con, "MP","CAL_HIJ_APP");

String Mar_Status_Desc="";
String birth_place_code="";
String birth_place_desc="";
String Pat_Cat_Desc="";
String entitlement_by_pat_cat_yn="";
String patexpirtydate="";
String citizen_yn="";
String legal_yn="";
String Nationality_Desc="";
String race_long_desc="";
String ethnic_long_desc="";
String Relgn_Desc="";
String language_name="";
String Alias_Name="";

String data_source="";
String Age="";

String Prn_Tel_No="";
String Orn_Tel_No="";
String contactModeOne="";
String contactModeTwo="";
String old_Prn_Tel_No="";
String old_Orn_Tel_No="";

StringBuffer sql=new StringBuffer();
PreparedStatement pstmt = null;
ResultSet rs=null;

sql.append("SELECT nvl(Alt_Id1_reqd_yn,'N') Alt_Id1_reqd_yn, nvl(Alt_Id2_reqd_yn,'N') Alt_Id2_reqd_yn, nvl(Alt_Id3_reqd_yn,'N') Alt_Id3_reqd_yn, nvl(Alt_Id4_reqd_yn,'N') Alt_Id4_reqd_yn, Alt_Id1_type, Alt_Id2_type, Alt_Id3_type, Alt_Id4_type, nvl(First_Name_Accept_Yn,'N') First_Name_Accept_Yn , nvl(First_Name_Order,'0') First_Name_Order, nvl(First_Name_Prompt,'First Name') First_Name_Prompt, nvl(Second_Name_Accept_Yn,'N') Second_Name_Accept_Yn, nvl(Second_Name_Order,'0') Second_Name_Order, nvl(Second_Name_Prompt,'Second Name') Second_Name_Prompt, nvl(Third_Name_Accept_Yn,'N') Third_Name_Accept_Yn, nvl(Third_Name_Order,'0') Third_Name_Order, nvl(Third_Name_Prompt,'Third Name') Third_Name_Prompt, nvl(Family_Name_Accept_Yn,'N') Family_Name_Accept_Yn, nvl(Family_Name_Order,'0') Family_Name_Order, nvl(Family_Name_Prompt,'Family Name') Family_Name_Prompt, name_dervn_logic, nvl(Alt_Id1_length,'0') Alt_Id1_length, nvl(Alt_Id2_length,'0') Alt_Id2_length, nvl(Alt_Id3_length,'0') Alt_Id3_length, nvl(Alt_Id4_length,'0') Alt_Id4_length, nvl(name_suffix_accept_yn,'N') name_suffix_accept_yn, nvl(name_prefix_accept_yn,'N') name_prefix_accept_yn, nvl(name_suffix_prompt,'Name Suffix') name_suffix_prompt, nvl(name_prefix_prompt,'Name Prefix') name_prefix_prompt, nvl(first_name_reqd_yn,'N') first_name_reqd_yn, nvl(second_name_reqd_yn,'N') second_name_reqd_yn, nvl(third_name_reqd_yn,'N') third_name_reqd_yn, nvl(family_name_reqd_yn,'N') family_name_reqd_yn, nvl(name_suffix_reqd_yn,'N') name_suffix_reqd_yn, nvl(name_prefix_reqd_yn,'N') name_prefix_reqd_yn, nvl(family_no_link_yn,'N') family_no_link_yn, nvl(patient_id_length,0) patient_id_length, nvl(citizen_nationality_code,'') citizen_nationality_code, nvl(Alt_Id1_Unique_yn,'N') Alt_Id1_Unique_yn, nvl(Alt_Id2_Unique_yn,'N') Alt_Id2_Unique_yn, nvl(Alt_Id3_Unique_yn,'N') Alt_Id3_Unique_yn, nvl(Alt_Id4_Unique_yn,'N') Alt_Id4_Unique_yn, nat_id_length, nvl(ALT_ID1_LEN_VALIDATION_YN,'N') ALT_ID1_LEN_VALIDATION_YN, nvl(ALT_ID2_LEN_VALIDATION_YN,'N') ALT_ID2_LEN_VALIDATION_YN, nvl(ALT_ID3_LEN_VALIDATION_YN,'N') ALT_ID3_LEN_VALIDATION_YN, nvl(ALT_ID4_LEN_VALIDATION_YN,'N') ALT_ID4_LEN_VALIDATION_YN, alt_id1_exp_date_accept_yn, alt_id2_exp_date_accept_yn, alt_id3_exp_date_accept_yn, alt_id4_exp_date_accept_yn, alt_id1_routine_yn, alt_id1_data_source_id alt_id1_routine, alt_id2_routine_yn, alt_id2_data_source_id alt_id2_routine, alt_id3_routine_yn, alt_id3_data_source_id  alt_id3_routine, alt_id4_routine_yn, alt_id4_data_source_id  alt_id4_routine, NAT_ID_PAT_SER_GRP, nvl(ID_CHANGE_ALLOWED_FOR_SERIES,'*') ID_CHANGE_ALLOWED_FOR_SERIES, nvl(ADDL_FIELD1_PROMPT,'') ADDL_FIELD1_PROMPT, nvl(ADDL_FIELD1_LENGTH,'0') ADDL_FIELD1_LENGTH, nvl(ADDL_FIELD1_SECTION,'') ADDL_FIELD1_SECTION, nvl(ADDL_FIELD2_PROMPT,'') ADDL_FIELD2_PROMPT, nvl(ADDL_FIELD2_LENGTH ,'0') ADDL_FIELD2_LENGTH, nvl(ADDL_FIELD2_SECTION ,'') ADDL_FIELD2_SECTION, nvl(ADDL_FIELD3_PROMPT ,'') ADDL_FIELD3_PROMPT, nvl(ADDL_FIELD3_LENGTH ,'0') ADDL_FIELD3_LENGTH, nvl(ADDL_FIELD3_SECTION ,'') ADDL_FIELD3_SECTION, nvl(ADDL_FIELD4_PROMPT ,'') ADDL_FIELD4_PROMPT, nvl(ADDL_FIELD4_LENGTH,'0') ADDL_FIELD4_LENGTH, nvl(ADDL_FIELD4_SECTION ,'') ADDL_FIELD4_SECTION, nvl(ADDL_FIELD5_PROMPT,'') ADDL_FIELD5_PROMPT, nvl(ADDL_FIELD5_LENGTH ,'0') ADDL_FIELD5_LENGTH, nvl(ADDL_FIELD5_SECTION ,'') ADDL_FIELD5_SECTION, nvl(nat_id_prompt,'National Id No') nat_id_prompt, nvl(NAT_ID_CHK_LEN,'N') NAT_ID_CHK_LEN, nat_id_check_digit_id,  alt_id1_chk_digit_scheme, alt_id2_chk_digit_scheme, alt_id3_chk_digit_scheme, alt_id4_chk_digit_scheme, nvl(NAME_PREFIX_LOC_LANG_PROMPT,'&nbsp;') NAME_PREFIX_LOC_LANG_PROMPT, nvl(FIRST_NAME_LOC_LANG_PROMPT,'&nbsp;') FIRST_NAME_LOC_LANG_PROMPT, nvl(SECOND_NAME_LOC_LANG_PROMPT,'&nbsp;') SECOND_NAME_LOC_LANG_PROMPT, nvl(THIRD_NAME_LOC_LANG_PROMPT,'&nbsp;') THIRD_NAME_LOC_LANG_PROMPT, nvl(FAMILY_NAME_LOC_LANG_PROMPT,'&nbsp;') FAMILY_NAME_LOC_LANG_PROMPT, nvl(NAME_SUFFIX_LOC_LANG_PROMPT,'&nbsp;') NAME_SUFFIX_LOC_LANG_PROMPT, accept_national_id_no_yn, alt_id1_accept_oth_pat_ser_yn, alt_id1_accept_alphanumeric_yn, invoke_routine, nat_data_source_id, max_patient_age, name_dervn_logic_oth_lang, pat_name_as_multipart_yn, nat_id_reqd_all_series, Accept_oth_alt_id_yn, alt_id1.long_desc alt_id1_desc, alt_id2.long_desc alt_id2_desc, alt_id3.long_desc alt_id3_desc, alt_id4.long_desc alt_id4_desc, ext_system_interface_yn, default_race_code, names_in_oth_lang_yn, to_char(sysdate,'dd/mm/yyyy') ServerDate, dflt_alt_id1_in_emp_id_yn, nb_mother_cutoff_age,create_file_yn,maintain_doc_or_file,family_org_id_accept_yn,entitlement_by_pat_cat_yn FROM mp_param_lang_vw, mp_alternate_id_type_lang_vw alt_id1, mp_alternate_id_type_lang_vw alt_id2, mp_alternate_id_type_lang_vw alt_id3, mp_alternate_id_type_lang_vw alt_id4 WHERE alt_id1_type = alt_id1.alt_id_type AND alt_id2_type = alt_id2.alt_id_type(+) AND alt_id3_type = alt_id3.alt_id_type(+) AND alt_id4_type = alt_id4.alt_id_type(+) and alt_id1.language_id(+) = '"+locale+"' and alt_id2.language_id(+) = '"+locale+"' and alt_id3.language_id(+) = '"+locale+"' and alt_id4.language_id(+) = '"+locale+"' and mp_param_lang_vw.language_id = '"+locale+"'" );

pstmt = con.prepareStatement(sql.toString());
rs=pstmt.executeQuery(); 

if(rs != null) {
    if(rs.next()) {
        Alt_Id1_Type = rs.getString("Alt_Id1_Type")==null ? "" : rs.getString("alt_id1_desc");
        Alt_Id2_Type = rs.getString("Alt_Id2_Type")==null ? "" : rs.getString("alt_id2_desc");
        Alt_Id3_Type = rs.getString("Alt_Id3_Type")==null ? "" : rs.getString("alt_id3_desc");
        Alt_Id4_Type = rs.getString("Alt_Id4_Type")==null ? "" : rs.getString("alt_id4_desc");
		
		alt_id1_exp_date_accept_yn = rs.getString("alt_id1_exp_date_accept_yn")==null ? "" : rs.getString("alt_id1_exp_date_accept_yn");

		alt_id2_exp_date_accept_yn = rs.getString("alt_id2_exp_date_accept_yn")==null ? "" : rs.getString("alt_id2_exp_date_accept_yn");
			
		alt_id3_exp_date_accept_yn = rs.getString("alt_id3_exp_date_accept_yn")==null ? "" : rs.getString("alt_id3_exp_date_accept_yn");

		alt_id4_exp_date_accept_yn = rs.getString("alt_id4_exp_date_accept_yn")==null ? "" : rs.getString("alt_id4_exp_date_accept_yn");

		accept_oth_alt_id_yn = rs.getString("accept_oth_alt_id_yn")==null ? "" : rs.getString("accept_oth_alt_id_yn");
		names_in_oth_lang_yn = rs.getString("names_in_oth_lang_yn")==null ? "N" : rs.getString("names_in_oth_lang_yn");

		First_Name_Accept_Yn = rs.getString("First_Name_Accept_Yn")==null ? "N" : rs.getString("First_Name_Accept_Yn");
        First_Name_Order = rs.getInt("First_Name_Order");
        First_Name_Prompt = rs.getString("First_Name_Prompt") == null ? "" : rs.getString("First_Name_Prompt");
        Second_Name_Accept_Yn = rs.getString("Second_Name_Accept_Yn")==null ? "N" : rs.getString("Second_Name_Accept_Yn");
        Second_Name_Order = rs.getInt("Second_Name_Order");
        Second_Name_Prompt = rs.getString("Second_Name_Prompt") == null ? "" : rs.getString("Second_Name_Prompt");
        Third_Name_Accept_Yn = rs.getString("Third_Name_Accept_Yn")==null ? "N" : rs.getString("Third_Name_Accept_Yn");
        Third_Name_Order = rs.getInt("Third_Name_Order");
        Third_Name_Prompt = rs.getString("Third_Name_Prompt") == null ? "" : rs.getString("Third_Name_Prompt");
        Family_Name_Accept_Yn = rs.getString("Family_Name_Accept_Yn")==null ? "N" : rs.getString("Family_Name_Accept_Yn");
        Family_Name_Order = rs.getInt("Family_Name_Order");
        Family_Name_Prompt = rs.getString("Family_Name_Prompt")== null ? "" : rs.getString("Family_Name_Prompt");

        Name_Prefix_Accept_Yn = rs.getString("Name_Prefix_Accept_Yn");
        Name_Suffix_Accept_Yn = rs.getString("Name_Suffix_Accept_Yn");
        Name_Prefix_Prompt = rs.getString("Name_Prefix_Prompt");
        Name_Suffix_Prompt = rs.getString("Name_Suffix_Prompt");

        Family_No_Link_Yn = rs.getString("family_no_link_yn");
        
        /* cust_fields[0] = rs.getString("addl_field1_section")+"`"+rs.getString("ADDL_FIELD1_PROMPT");
        cust_fields[1] = rs.getString("addl_field2_section")+"`"+rs.getString("ADDL_FIELD2_PROMPT");
        cust_fields[2] = rs.getString("addl_field3_section")+"`"+rs.getString("ADDL_FIELD3_PROMPT");
        cust_fields[3] = rs.getString("addl_field4_section")+"`"+rs.getString("ADDL_FIELD4_PROMPT");
        cust_fields[4] = rs.getString("addl_field5_section")+"`"+rs.getString("ADDL_FIELD5_PROMPT"); */
        nat_id_prompt = rs.getString("nat_id_prompt");
        
        name_prefix_loc_lang_prompt     =rs.getString("name_prefix_loc_lang_prompt");
        first_name_loc_lang_prompt      =rs.getString("first_name_loc_lang_prompt");
        second_name_loc_lang_prompt     =rs.getString("second_name_loc_lang_prompt");
        third_name_loc_lang_prompt      =rs.getString("third_name_loc_lang_prompt");
        family_name_loc_lang_prompt     =rs.getString("family_name_loc_lang_prompt");
        name_suffix_loc_lang_prompt     =rs.getString("name_suffix_loc_lang_prompt");
        /* doc_or_file						=rs.getString("maintain_doc_or_file"); */
		
		//Newly added on 13/02/2012 by Saanthaakumar  ---> SCF NO : RUT-SCF-0062 [30973]
		/* create_file_yn					=rs.getString("create_file_yn"); */
		
		
        accept_national_id_no_yn		=rs.getString("accept_national_id_no_yn");
        family_org_id_accept_yn			=rs.getString("family_org_id_accept_yn")==null?"":rs.getString("family_org_id_accept_yn");
        entitlement_by_pat_cat_yn		=rs.getString("entitlement_by_pat_cat_yn")==null?"":rs.getString("entitlement_by_pat_cat_yn");	
    }
}

StringBuffer sql2=new StringBuffer();
sql2.append("SELECT patient.patient_name Patient_Name, patient.MYHIX_ID unique_no , patient.pat_ser_grp_code pat_ser_grp_code, (CASE WHEN patient.pat_ser_grp_code IS NOT NULL THEN (mp_get_desc.mp_pat_ser_grp(patient.pat_ser_grp_code,'"+locale+"',2)) END ) pat_ser_grp_desc, NVL(pat_ser_grp.ID_TYPE, '') ID_TYPE, pat_ser_grp.allow_family_no_yn, pat_ser_grp.pat_name_in_loc_lang_reqd_yn, patient.national_id_no national_id_no, patient.pref_facility_id pref_facility_id, (CASE WHEN patient.pref_facility_id IS NOT NULL THEN (sm_get_desc.sm_facility_param(patient.pref_facility_id, '"+locale+"', 1)) END ) pref_facility_name, patient.regn_facility_id regn_facility_id, (CASE WHEN patient.regn_facility_id IS NOT NULL THEN (sm_get_desc.sm_facility_param(patient.regn_facility_id, '"+locale+"', 1)) END ) regn_facility_name, patient.alt_id1_type alt_id1_type, (CASE WHEN patient.alt_id1_type IS NOT NULL THEN (mp_get_desc.mp_alternate_id_type(patient.alt_id1_type,'"+locale+"',1)) END ) alt_id1_desc, patient.alt_id1_no alt_id1_no, to_char(patient.alt_id1_exp_date,'dd/mm/yyyy') alt_id1_exp_date, patient.alt_id2_type alt_id2_type, (CASE WHEN patient.alt_id2_type IS NOT NULL THEN (mp_get_desc.mp_alternate_id_type(patient.alt_id2_type,'"+locale+"',2)) END ) alt_id2_desc, patient.alt_id2_no alt_id2_no, to_char(patient.alt_id2_exp_date,'dd/mm/yyyy') alt_id2_exp_date, patient.alt_id3_type alt_id3_type, (CASE WHEN patient.alt_id3_type IS NOT NULL THEN (mp_get_desc.mp_alternate_id_type(patient.alt_id3_type,'"+locale+"',2)) END ) alt_id3_desc, patient.alt_id3_no alt_id3_no, to_char(patient.alt_id3_exp_date,'dd/mm/yyyy') alt_id3_exp_date, patient.alt_id4_type alt_id4_type, (CASE WHEN patient.alt_id4_type IS NOT NULL THEN (mp_get_desc.mp_alternate_id_type(patient.alt_id4_type,'"+locale+"',2)) END ) alt_id4_desc, patient.alt_id4_no alt_id4_no, to_char(patient.alt_id4_exp_date,'dd/mm/yyyy') alt_id4_exp_date, patient.oth_alt_id_type oth_alt_id_type, (CASE WHEN patient.oth_alt_id_type IS NOT NULL THEN (mp_get_desc.mp_alternate_id_type(patient.oth_alt_id_type,'"+locale+"',1)) END ) demo_oth_alt_id_desc, patient.oth_alt_id_no demo_oth_alt_id_no, patient.family_link_no family_link_no, (CASE WHEN patient.family_link_no IS NOT NULL THEN (mp_get_desc.mp_patient(patient.family_link_no,1)) END ) head_patient_name, patient.relationship_to_head relationship_to_head, (CASE WHEN patient.relationship_to_head IS NOT NULL THEN (mp_get_desc.mp_relationship(patient.relationship_to_head,'"+locale+"',2)) END ) relationship_name, patient.name_prefix name_prefix, patient.first_name first_name, patient.second_name second_name, patient.third_name third_name, patient.family_name family_name, patient.name_suffix name_suffix, patient.name_prefix_loc_lang name_prefix_loc_lang, patient.first_name_loc_lang first_name_loc_lang, patient.second_name_loc_lang second_name_loc_lang, patient.third_name_loc_lang third_name_loc_lang, patient.family_name_loc_lang family_name_loc_lang, patient.name_suffix_loc_lang name_suffix_loc_lang, patient.patient_name_loc_lang patient_name_loc_lang, patient.sex sex, to_char(patient.date_of_birth, 'dd/mm/yyyy') date_of_birth, patient.calculated_age_yn calculated_age_yn, patient.birth_place_code birth_place_code, (CASE WHEN patient.birth_place_code IS NOT NULL THEN (mp_get_desc.mp_birth_place(patient.birth_place_code,'"+locale+"',1))  END ) birth_place_desc, patient.place_of_birth place_of_birth, patient.mar_status_code mar_status_code, (CASE WHEN patient.mar_status_code IS NOT NULL THEN (mp_get_desc.mp_marital_status(patient.mar_status_code,'"+locale+"',2)) END ) mar_status_desc, patient.alias_name alias_name, patient.relgn_code relgn_code, (CASE WHEN patient.relgn_code IS NOT NULL THEN (mp_get_desc.mp_religion(patient.relgn_code,'"+locale+"',2)) END ) relgn_desc, patient.ethnic_grp_code ethnic_grp_code, (CASE WHEN patient.ethnic_grp_code IS NOT NULL THEN (mp_get_desc.mp_ethnic_group(patient.ethnic_grp_code,'"+locale+"',2)) END ) ethnic_short_desc, (CASE WHEN patient.ethnic_grp_code IS NOT NULL THEN (mp_get_desc.mp_ethnic_group(patient.ethnic_grp_code,'"+locale+"',1)) END ) ethnic_long_desc, patient.race_code race_code, (CASE WHEN patient.race_code IS NOT NULL THEN (mp_get_desc.mp_race(patient.race_code,'"+locale+"',2)) END ) race_short_desc, (CASE WHEN patient.race_code IS NOT NULL THEN (mp_get_desc.mp_race(patient.race_code,'"+locale+"',1)) END ) race_long_desc, patient.citizen_yn CITIZEN_YN, patient.legal_yn LEGAL_YN, patient.nationality_code nationality_code, (CASE WHEN patient.nationality_code IS NOT NULL THEN (mp_get_desc.mp_country(patient.nationality_code,'"+locale+"',3)) END ) nationality_desc, patient.mother_maiden_name mother_maiden_name, patient.pat_cat_code pat_cat_code, (CASE WHEN patient.pat_cat_code IS NOT NULL THEN (mp_get_desc.mp_pat_category(patient.pat_cat_code,'"+locale+"',2)) END ) pat_cat_desc, patient.referral_facility_id referral_facility_id, patient.ref_source_code ref_source_code, NULL ref_source_desc, pat_addr.addr1_line1 resi_addr_line1, pat_addr.addr1_line2 resi_addr_line2, pat_addr.addr1_line3 resi_addr_line3, pat_addr.addr1_line4 resi_addr_line4, mp_get_desc.mp_postal_code(pat_addr.postal1_code,'"+locale+"',2) resi_postal_code, pat_addr.country1_code resi_country_code, (CASE WHEN pat_addr.country1_code IS NOT NULL THEN (mp_get_desc.mp_country(pat_addr.country1_code,'"+locale+"',1)) END ) resi_country_name, pat_addr.invalid1_yn resi_invalid1_yn, pat_addr.contact1_name resi_contact1_name, patient.res_area_code res_area_code, (CASE WHEN patient.res_area_code IS NOT NULL THEN (mp_get_desc.mp_res_area(patient.res_area_code,'"+locale+"',2)) END ) res_area_desc, (CASE WHEN patient.res_area_code IS NOT NULL THEN (mp_get_desc.mp_res_area(patient.res_area_code,'"+locale+"',1)) END ) res_area_long_desc, patient.res_town_code res_town_code, (CASE WHEN patient.res_town_code IS NOT NULL  THEN (mp_get_desc.mp_res_town(patient.res_town_code,'"+locale+"',2)) END ) res_town_desc, (CASE WHEN patient.res_town_code IS NOT NULL THEN (mp_get_desc.mp_res_town(patient.res_town_code,'"+locale+"',1)) END ) res_town_long_desc, patient.region_code region_code, (CASE WHEN patient.region_code IS NOT NULL THEN (mp_get_desc.mp_region(patient.region_code,'"+locale+"',2)) END ) region_desc, (CASE WHEN patient.region_code IS NOT NULL THEN (mp_get_desc.mp_region(patient.region_code,'"+locale+"',1)) END ) region_long_desc, pat_addr.addr2_line1 mail_addr_line1, pat_addr.addr2_line2 mail_addr_line2, pat_addr.addr2_line3 mail_addr_line3, pat_addr.addr2_line4 mail_addr_line4, mp_get_desc.mp_postal_code(pat_addr.postal2_code,'"+locale+"',2) mail_postal_code, pat_addr.country2_code mail_country_code, (CASE WHEN pat_addr.country2_code IS NOT NULL THEN (mp_get_desc.mp_country(pat_addr.country2_code,'"+locale+"',1)) END ) mail_country_name, pat_addr.invalid2_yn mail_invalid1_yn, pat_addr.contact2_name mail_contact1_name, pat_addr.res_area2_code mail_res_area, (CASE WHEN pat_addr.res_area2_code IS NOT NULL THEN (mp_get_desc.mp_res_area(pat_addr.res_area2_code,'"+locale+"',2)) END ) mail_res_area_desc, (CASE WHEN pat_addr.res_area2_code IS NOT NULL THEN (mp_get_desc.mp_res_area(pat_addr.res_area2_code,'"+locale+"',1)) END ) mail_res_area_long_desc, pat_addr.res_town2_code mail_res_town, (CASE WHEN pat_addr.res_town2_code IS NOT NULL THEN (mp_get_desc.mp_res_town(pat_addr.res_town2_code,'"+locale+"',2)) END ) mail_res_town_desc, (CASE WHEN pat_addr.res_town2_code IS NOT NULL THEN (mp_get_desc.mp_res_town(pat_addr.res_town2_code,'"+locale+"',1))            END ) mail_res_town_long_desc, pat_addr.region2_code mail_region_code, (CASE WHEN pat_addr.region2_code IS NOT NULL  THEN (mp_get_desc.mp_region(pat_addr.region2_code,'"+locale+"',2)) END ) mail_region_desc, (CASE WHEN pat_addr.region2_code IS NOT NULL THEN (mp_get_desc.mp_region(pat_addr.region2_code,'"+locale+"',1)) END ) mail_region_long_desc, patient.contact1_no prn_tel_no, patient.contact2_no orn_tel_no, patient.email_id email_id, patient.contact3_mode contact3_mode, (CASE WHEN patient.contact3_mode IS NOT NULL THEN (mp_get_desc.mp_contact_mode(patient.contact3_mode,'"+locale+"',2)) END ) contact3_mode_desc, patient.contact3_no contact3_no, patient.contact4_mode contact4_mode, (CASE WHEN patient.contact4_mode IS NOT NULL THEN (mp_get_desc.mp_contact_mode(patient.contact4_mode,'"+locale+"',2)) END ) contact4_mode_desc, patient.contact4_no contact4_no, patient.contact5_mode contact5_mode, (CASE WHEN patient.contact5_mode IS NOT NULL THEN (mp_get_desc.mp_contact_mode(patient.contact5_mode,'"+locale+"',2)) END ) contact5_mode_desc, patient.contact5_no contact5_no, pat_rl_con.contact1_name nkin_contact_name, pat_rl_con.job1_title nkin_job_title, pat_rl_con.contact1_relation nkin_contact_relation, (CASE WHEN pat_rl_con.contact1_relation IS NOT NULL THEN (mp_get_desc.mp_relationship(pat_rl_con.contact1_relation,'"+locale+"',2)) END ) nkin_contact_relation_desc,  to_char(pat_rl_con.contact1_birth_date, 'dd/mm/yyyy') contact1_birth_date, pat_rl_con.contact1_nat_id_no, pat_rl_con.contact1_alt_id1_type, (CASE WHEN pat_rl_con.contact1_alt_id1_type IS NOT NULL THEN (mp_get_desc.mp_alternate_id_type(pat_rl_con.contact1_alt_id1_type,'"+locale+"',2)) END ) nkin_alt_id1_desc, pat_rl_con.contact1_alt_id1_no, pat_rl_con.contact1_alt_id2_type, (CASE WHEN pat_rl_con.contact1_alt_id2_type IS NOT NULL THEN (mp_get_desc.mp_alternate_id_type(pat_rl_con.contact1_alt_id2_type,'"+locale+"',2)) END ) nkin_alt_id2_desc, pat_rl_con.contact1_alt_id2_no, pat_rl_con.contact1_alt_id3_type, (CASE WHEN pat_rl_con.contact1_alt_id3_type IS NOT NULL THEN (mp_get_desc.mp_alternate_id_type(pat_rl_con.contact1_alt_id3_type,'"+locale+"',2)) END ) nkin_alt_id3_desc,  pat_rl_con.contact1_alt_id3_no, pat_rl_con.contact1_alt_id4_type, (CASE WHEN pat_rl_con.contact1_alt_id4_type IS NOT NULL   THEN (mp_get_desc.mp_alternate_id_type(pat_rl_con.contact1_alt_id4_type,'"+locale+"',2)) END ) nkin_alt_id4_desc, pat_rl_con.contact1_alt_id4_no, pat_rl_con.contact1_oth_alt_id_type, (CASE WHEN pat_rl_con.contact1_oth_alt_id_type IS NOT NULL THEN (mp_get_desc.mp_alternate_id_type(pat_rl_con.contact1_oth_alt_id_type,'"+locale+"',1)) END ) nkin_oth_alt_desc, pat_rl_con.contact1_oth_alt_id_no nkin_oth_alt_id_no, pat_rl_con.addr1_line1 nkin_addr_line1,  pat_rl_con.addr1_line2 nkin_addr_line2, pat_rl_con.addr1_line3 nkin_addr_line3, pat_rl_con.addr1_line4 nkin_addr_line4, pat_rl_con.contact1_res_town_code, (CASE WHEN pat_rl_con.contact1_res_town_code IS NOT NULL THEN (mp_get_desc.mp_res_town(pat_rl_con.contact1_res_town_code,'"+locale+"',2)) END ) nkin_town_desc, (CASE WHEN pat_rl_con.contact1_res_town_code IS NOT NULL THEN (mp_get_desc.mp_res_town(pat_rl_con.contact1_res_town_code,'"+locale+"',1)) END ) nkin_town_long_desc, pat_rl_con.contact1_res_area_code, (CASE WHEN pat_rl_con.contact1_res_area_code IS NOT NULL THEN (mp_get_desc.mp_res_area(pat_rl_con.contact1_res_area_code,'"+locale+"',2)) END ) nkin_area_desc, (CASE WHEN pat_rl_con.contact1_res_area_code IS NOT NULL THEN (mp_get_desc.mp_res_area(pat_rl_con.contact1_res_area_code,'"+locale+"',1)) END ) nkin_area_long_desc, pat_rl_con.contact1_region_code, (CASE WHEN pat_rl_con.contact1_region_code IS NOT NULL THEN (mp_get_desc.mp_region(pat_rl_con.contact1_region_code,'"+locale+"',2)) END ) nkin_region_desc, (CASE WHEN pat_rl_con.contact1_region_code IS NOT NULL THEN (mp_get_desc.mp_region(pat_rl_con.contact1_region_code,'"+locale+"',1)) END ) nkin_region_long_desc,mp_get_desc.mp_postal_code(pat_rl_con.postal1_code,'"+locale+"',2)  nkin_postal_code, pat_rl_con.country1_code nkin_country_code, (CASE WHEN pat_rl_con.country1_code IS NOT NULL THEN (mp_get_desc.mp_country(pat_rl_con.country1_code,'"+locale+"',1))  END ) nkin_country_name, pat_rl_con.res1_tel_no nkin_res_tel_no, pat_rl_con.off1_tel_no nkin_off_tel_no, pat_rl_con.contact1_mob_tel_no nkin_mob_tel_no, pat_rl_con.contact1_email_id nkin_email_id, pat_rl_con.contact2_relation fton_contact_relation, (CASE WHEN pat_rl_con.contact2_relation IS NOT NULL THEN (mp_get_desc.mp_relationship(pat_rl_con.contact2_relation,'"+locale+"',2)) END ) fton_contact_relation_desc,  pat_rl_con.contact2_name fton_contact_name, pat_rl_con.contact2_nat_id_no fton_nat_id_no, pat_rl_con.contact2_oth_alt_id_type, (CASE WHEN pat_rl_con.contact2_oth_alt_id_type IS NOT NULL THEN (mp_get_desc.mp_alternate_id_type(pat_rl_con.contact2_oth_alt_id_type,'"+locale+"',1)) END ) fton_alt_desc, pat_rl_con.contact2_oth_alt_id_no fton_alt_id_no, pat_rl_con.job2_title fton_job_title, pat_rl_con.addr2_line1 fton_addr_line1, pat_rl_con.addr2_line2 fton_addr_line2, pat_rl_con.addr2_line3 fton_addr_line3, pat_rl_con.addr2_line4 fton_addr_line4, pat_rl_con.contact2_res_town_code, (CASE WHEN pat_rl_con.contact2_res_town_code IS NOT NULL THEN (mp_get_desc.mp_res_town(pat_rl_con.contact2_res_town_code,'"+locale+"',2)) END ) fton_town_desc, (CASE WHEN pat_rl_con.contact2_res_town_code IS NOT NULL THEN (mp_get_desc.mp_res_town(pat_rl_con.contact2_res_town_code,'"+locale+"',1)) END ) fton_town_long_desc, pat_rl_con.contact2_res_area_code, (CASE WHEN pat_rl_con.contact2_res_area_code IS NOT NULL THEN (mp_get_desc.mp_res_area(pat_rl_con.contact2_res_area_code,'"+locale+"',2)) END ) fton_area_desc, (CASE WHEN pat_rl_con.contact2_res_area_code IS NOT NULL THEN (mp_get_desc.mp_res_area(pat_rl_con.contact2_res_area_code,'"+locale+"',1)) END ) fton_area_long_desc, pat_rl_con.contact2_region_code, (CASE WHEN pat_rl_con.contact2_region_code IS NOT NULL THEN (mp_get_desc.mp_region(pat_rl_con.contact2_region_code,'"+locale+"',2)) END ) fton_region_desc, (CASE WHEN pat_rl_con.contact2_region_code IS NOT NULL THEN (mp_get_desc.mp_region(pat_rl_con.contact2_region_code,'"+locale+"',1)) END ) fton_region_long_desc, mp_get_desc.mp_postal_code(pat_rl_con.postal2_code,'"+locale+"',2) fton_postal_code, pat_rl_con.country2_code fton_country_code,          (CASE WHEN pat_rl_con.country2_code IS NOT NULL THEN (mp_get_desc.mp_country(pat_rl_con.country2_code,'"+locale+"',1)) END ) fton_country_name, pat_rl_con.contact2_mob_tel_no fton_mob_tel_no, pat_rl_con.contact2_email_id fton_email_id, pat_rl_con.res2_tel_no fton_res_tel_no, pat_rl_con.off2_tel_no fton_off_tel_no, pat_rl_con.organization_name,   pat_rl_con.patient_employee_id patient_employee_id,pat_rl_con.employment_status employment_status, pat_rl_con.contact3_name emplr_contact_name, pat_rl_con.job3_title emplr_job_title, pat_rl_con.contact3_relation emplr_contact_relation, (CASE WHEN pat_rl_con.contact3_relation IS NOT NULL THEN (mp_get_desc.mp_relationship(pat_rl_con.contact3_relation,'"+locale+"',2)) END ) emplr_contact_relation_desc,           pat_rl_con.ocpn_class_code, (CASE WHEN pat_rl_con.ocpn_class_code IS NOT NULL THEN (mp_get_desc.mp_occupation_class(pat_rl_con.ocpn_class_code,'"+locale+"',1)) END ) emplr_ocpn_class_desc,           pat_rl_con.ocpn_code ocpn_code, (CASE WHEN pat_rl_con.ocpn_code IS NOT NULL THEN (mp_get_desc.mp_occupation(pat_rl_con.ocpn_code,'"+locale+"',2))  ELSE ocpn_desc END ) occupation_desc,   pat_rl_con.addr3_line1 emplr_addr_line1, pat_rl_con.addr3_line2 emplr_addr_line2, pat_rl_con.addr3_line3 emplr_addr_line3,  pat_rl_con.addr3_line4 emplr_addr_line4, pat_rl_con.contact3_res_town_code, (CASE WHEN pat_rl_con.contact3_res_town_code IS NOT NULL THEN (mp_get_desc.mp_res_town(pat_rl_con.contact3_res_town_code,'"+locale+"',2)) END ) emplr_town_desc, (CASE WHEN pat_rl_con.contact3_res_town_code IS NOT NULL THEN (mp_get_desc.mp_res_town(pat_rl_con.contact3_res_town_code,'"+locale+"',1)) END ) emplr_town_long_desc, pat_rl_con.contact3_res_area_code, (CASE WHEN pat_rl_con.contact3_res_area_code IS NOT NULL THEN (mp_get_desc.mp_res_area(pat_rl_con.contact3_res_area_code,'"+locale+"',2)) END ) emplr_area_desc, (CASE WHEN pat_rl_con.contact3_res_area_code IS NOT NULL THEN (mp_get_desc.mp_res_area(pat_rl_con.contact3_res_area_code,'"+locale+"',1)) END ) emplr_area_long_desc, pat_rl_con.contact3_region_code, (CASE WHEN pat_rl_con.contact3_region_code IS NOT NULL THEN (mp_get_desc.mp_region(pat_rl_con.contact3_region_code,'"+locale+"',2)) END ) emplr_region_desc, (CASE WHEN pat_rl_con.contact3_region_code IS NOT NULL THEN (mp_get_desc.mp_region(pat_rl_con.contact3_region_code,'"+locale+"',1))    END ) emplr_region_long_desc,mp_get_desc.mp_postal_code(pat_rl_con.postal3_code,'"+locale+"',2)  emplr_postal_code, pat_rl_con.country3_code emplr_country_code, (CASE WHEN pat_rl_con.country3_code IS NOT NULL THEN (mp_get_desc.mp_country(pat_rl_con.country3_code,'"+locale+"',1))            END ) emplr_country_name, pat_rl_con.off3_tel_no emplr_off_tel_no, pat_rl_con.res3_tel_no emplr_res_tel_no, pat_rl_con.off_fax_no off_fax_no,pat_oth_dtls.living_dependency living_dependency, pat_oth_dtls.living_arrangement living_arrangement, mr_get_desc.mr_blood_grp(pat_oth_dtls.blood_grp,'"+locale+"',2) blood_grp_desc, mr_get_desc.mr_rhesus_factor(pat_oth_dtls.rh_factor,'"+locale+"',2) rh_factor_desc, pat_oth_dtls.education_level education_level, (CASE WHEN pat_oth_dtls.education_level IS NOT NULL THEN (mp_get_desc.mp_education_level(pat_oth_dtls.education_level,'"+locale+"',2)) END ) educ_level_desc, pat_oth_dtls.regn_informant informant, pat_oth_dtls.regn_comments informant_remarks, pat_oth_dtls.general_remarks general_remarks, patient.suspend_yn suspend_yn ,patient.hijri_birth_date hijri_birth_date, patient.status_reason_code status_reason_code, (CASE WHEN patient.status_reason_code IS NOT NULL THEN (mp_get_desc.mp_pat_susp_reason(patient.status_reason_code,'"+locale+"',2)) END ) status_reason_desc, patient.status_remarks status_remarks, patient.active_yn active_yn, to_char(patient.last_contact_date,'dd/mm/yyyy') last_contact_date, patient.deceased_yn deceased_yn, to_char(patient.deceased_date,'dd/mm/yyyy') deceased_date, patient.death_status_remarks death_status_remarks, patient.primary_language_id primary_language_id, patient.language_id pat_language_id,(CASE WHEN patient.language_id IS NOT NULL THEN (mp_get_desc.mp_language(patient.language_id,'"+locale+"',1)) END ) language_name,  pat_oth_dtls.addl_field1 addl_field1, (CASE WHEN pat_oth_dtls.addl_field1 IS NOT NULL THEN (SELECT addl_field1_prompt FROM mp_param_lang_vw where module_id = 'MP' and language_id = '"+locale+"') END ) addl_field1_prompt, (CASE WHEN pat_oth_dtls.addl_field2 IS NOT NULL THEN (SELECT addl_field2_prompt FROM mp_param_lang_vw where module_id = 'MP' and language_id = '"+locale+"') END ) addl_field2_prompt, pat_oth_dtls.addl_field2 addl_field2, (CASE WHEN pat_oth_dtls.addl_field3 IS NOT NULL THEN (SELECT addl_field3_prompt FROM mp_param_lang_vw where module_id = 'MP' and language_id = '"+locale+"') END ) addl_field3_prompt, pat_oth_dtls.addl_field3 addl_field3, (CASE WHEN pat_oth_dtls.addl_field4 IS NOT NULL THEN (SELECT addl_field4_prompt FROM mp_param_lang_vw where module_id = 'MP' and language_id = '"+locale+"') END ) addl_field4_prompt, pat_oth_dtls.addl_field4 addl_field4, (CASE WHEN pat_oth_dtls.addl_field5 IS NOT NULL THEN (SELECT addl_field5_prompt FROM mp_param_lang_vw where module_id = 'MP' and language_id = '"+locale+"') END ) addl_field5_prompt, pat_oth_dtls.addl_field5 addl_field5, patient.added_by_id, (CASE WHEN patient.added_by_id IS NOT NULL THEN (sm_get_desc.sm_appl_user(patient.added_by_id,'"+locale+"',1)) END ) added_user_name, TO_CHAR (patient.added_date, 'DD/MM/YYYY HH24:MI') added_date, patient.added_at_ws_no, patient.added_facility_id, (CASE WHEN patient.added_facility_id IS NOT NULL THEN (sm_get_desc.sm_facility_param(patient.added_facility_id, '"+locale+"', 1))  END ) added_facility_name, patient.modified_by_id, (CASE WHEN patient.modified_by_id IS NOT NULL THEN (sm_get_desc.sm_appl_user(patient.modified_by_id,'"+locale+"',1)) END ) modified_user_name, TO_CHAR (patient.modified_date, 'DD/MM/YYYY HH24:MI') modified_date, patient.modified_at_ws_no, patient.modified_facility_id, (CASE WHEN patient.modified_facility_id IS NOT NULL THEN (sm_get_desc.sm_facility_param(patient.modified_facility_id, '"+locale+"', 1))END ) modified_facility_name, patient.pat_dtls_unknown_yn, patient.inhouse_birth_yn, patient.data_source data_source, MP_GET_AGE_YMDH(patient.date_of_birth,patient.deceased_date) age,/*  CALCULATE_AGE_HOURS(to_char(Date_Of_Birth,'dd/mm/yyyy hh24:mi:ss'),1)||'Y'|| CALCULATE_AGE_HOURS(to_char(Date_Of_Birth,'dd/mm/yyyy hh24:mi:ss'),2)||'M'||CALCULATE_AGE_HOURS(to_char(Date_Of_Birth,'dd/mm/yyyy hh24:mi:ss'),3)||'D'||CALCULATE_AGE_HOURS(to_char(Date_Of_Birth,'dd/mm/yyyy hh24:mi:ss'),4)||'H' age,*/ patient.FAMILY_ORG_MEMBERSHIP MembershipType, ( case when patient.FAMILY_ORG_SUB_ID is not null then (select FAMILY_ORG_SUB_NAME from mp_family_org_sub_lang_vw where FAMILY_ORG_ID = patient.FAMILY_ORG_ID and FAMILY_ORG_SUB_ID= patient.FAMILY_ORG_SUB_ID and language_id = '"+locale+"') end) Orgsubname, (case when patient.FAMILY_ORG_ID is not null then ( select FAMILY_ORG_NAME from MP_FAMILY_ORG_lang_vw where FAMILY_ORG_ID= patient.FAMILY_ORG_ID and language_id = '"+locale+"') end) Orgname, to_char(patient.PAT_CAT_CODE_EXP_DATE,'dd/mm/yyyy') patexpirtydate, ");  

if(group_status.equals("")) {   
	  if(disp_dup_pat_dtls.equals("Duplicate")) {
		    sql2.append("(select count(file_no) from mr_pat_file_index WHERE facility_id = '"+Facility_Id+"' AND patient_id = patient.valid_patient_id) file_cnt, ");
			sql2.append(" patient.DUPLICATE_PATIENT_ID Patient_id FROM DR_MP_PATIENT patient, DR_MP_PAT_ADDRESSES pat_addr, DR_MP_PAT_REL_CONTACTS pat_rl_con, DR_MP_PAT_OTH_DTLS pat_oth_dtls, mp_pat_ser_grp pat_ser_grp,mp_pat_documents f WHERE patient.DUPLICATE_PATIENT_ID = pat_addr.DUPLICATE_PATIENT_ID(+) AND patient.DUPLICATE_PATIENT_ID = pat_rl_con.DUPLICATE_PATIENT_ID(+) AND patient.DUPLICATE_PATIENT_ID = pat_oth_dtls.DUPLICATE_PATIENT_ID(+) AND patient.DUPLICATE_PATIENT_ID = f.patient_id(+) AND patient.pat_ser_grp_code = pat_ser_grp.pat_ser_grp_code AND patient.DUPLICATE_PATIENT_ID = ? ");	
	  } else {
		  sql2.append("(select count(file_no) from mr_pat_file_index WHERE facility_id = '"+Facility_Id+"' AND patient_id = patient.patient_id) file_cnt, ");
			sql2.append(" patient.patient_id Patient_id FROM mp_patient patient, mp_pat_addresses pat_addr, mp_pat_rel_contacts pat_rl_con, mp_pat_oth_dtls pat_oth_dtls, mp_pat_ser_grp pat_ser_grp,mp_pat_documents f WHERE patient.patient_id = pat_addr.patient_id(+) AND patient.patient_id = pat_rl_con.patient_id(+) AND patient.patient_id = pat_oth_dtls.patient_id(+) AND patient.patient_id = f.patient_id(+) AND patient.pat_ser_grp_code = pat_ser_grp.pat_ser_grp_code AND patient.patient_id = ? ");
	  }
} else if(!group_status.equals("")) {
	if(disp_dup_pat_dtls.equals("Duplicate") && group_status.equals("S") ) {
			 sql2.append("(select count(file_no) from mr_pat_file_index WHERE facility_id = '"+Facility_Id+"' AND patient_id = patient.valid_patient_id) file_cnt, ");
			sql2.append(" patient.DUPLICATE_PATIENT_ID Patient_id FROM DR_MP_PATIENT patient, DR_MP_PAT_ADDRESSES pat_addr, DR_MP_PAT_REL_CONTACTS pat_rl_con, DR_MP_PAT_OTH_DTLS pat_oth_dtls, mp_pat_ser_grp pat_ser_grp,mp_pat_documents f WHERE patient.DUPLICATE_PATIENT_ID = pat_addr.DUPLICATE_PATIENT_ID(+) AND patient.DUPLICATE_PATIENT_ID = pat_rl_con.DUPLICATE_PATIENT_ID(+) AND patient.DUPLICATE_PATIENT_ID = pat_oth_dtls.DUPLICATE_PATIENT_ID(+) AND patient.DUPLICATE_PATIENT_ID = f.patient_id(+) AND patient.pat_ser_grp_code = pat_ser_grp.pat_ser_grp_code AND patient.DUPLICATE_PATIENT_ID = ? ");	
	} else {
		  sql2.append("(select count(file_no) from mr_pat_file_index WHERE facility_id = '"+Facility_Id+"' AND patient_id = patient.patient_id) file_cnt, ");
		  sql2.append(" patient.patient_id Patient_id FROM mp_patient patient, mp_pat_addresses pat_addr, mp_pat_rel_contacts pat_rl_con, mp_pat_oth_dtls pat_oth_dtls, mp_pat_ser_grp pat_ser_grp,mp_pat_documents f  WHERE patient.patient_id = pat_addr.patient_id(+) AND patient.patient_id = pat_rl_con.patient_id(+) AND patient.patient_id = pat_oth_dtls.patient_id(+) AND patient.patient_id = f.patient_id(+) AND patient.pat_ser_grp_code = pat_ser_grp.pat_ser_grp_code AND patient.patient_id = ? ");	
	       
	}
}

 pstmt = con.prepareStatement(sql2.toString());
 pstmt.setString(1, patient); 
rs=pstmt.executeQuery(); 

if(rs != null) {
    if(rs.next()) {
   	Patient_id=rs.getString("Patient_id");
 	  //Added for MMS-QH-CRF-0145
 	  
	hijri_birth_date =rs.getString("hijri_birth_date"); 
	if(hijri_birth_date==null)hijri_birth_date=""; 
  	
  	citizen_yn=rs.getString("CITIZEN_YN");
	legal_yn=rs.getString("LEGAL_YN");

	if (citizen_yn == null) citizen_yn="&nbsp; ";
	if (legal_yn == null) legal_yn="&nbsp; ";
	
	Pat_Ser_Grp_Desc  =rs.getString("pat_ser_grp_desc") ;
	
	National_Id_No  =rs.getString("national_id_no");
	National_Id_No = eXH.XHUtil.getNationalID(Patient_id);
	if(National_Id_No ==null)National_Id_No ="&nbsp; ";

	Pref_Facility_Name =rs.getString("pref_facility_name");
    if(Pref_Facility_Name==null)Pref_Facility_Name="&nbsp; "; 

     Alt_Id1_No    =rs.getString("alt_id1_no") ;
    if(Alt_Id1_No ==null){Alt_Id1_No ="&nbsp; ";}

    Alt_Id1_Exp_Date  =rs.getString("alt_id1_exp_date");
	if(Alt_Id1_Exp_Date!=null){
		Alt_Id1_Exp_Date=DateUtils.convertDate(Alt_Id1_Exp_Date,"DMY","en",locale); 
	}
	else
		Alt_Id1_Exp_Date="&nbsp;";
		
		
	Alt_Id2_No   =rs.getString("alt_id2_no");
    if(Alt_Id2_No==null){Alt_Id2_No="&nbsp; ";}

    Alt_Id2_Exp_Date =rs.getString("alt_id2_exp_date");
  	if(Alt_Id2_Exp_Date!=null){
		Alt_Id2_Exp_Date=DateUtils.convertDate(Alt_Id2_Exp_Date,"DMY","en",locale); 
	}
	else
		Alt_Id2_Exp_Date="&nbsp;";

    Alt_Id3_No     =rs.getString("alt_id3_no");
    if(Alt_Id3_No ==null){Alt_Id3_No ="&nbsp; ";}

    Alt_Id3_Exp_Date  =rs.getString("alt_id3_exp_date");

	if(Alt_Id3_Exp_Date!=null){
		Alt_Id3_Exp_Date=DateUtils.convertDate(Alt_Id3_Exp_Date,"DMY","en",locale); 
	}
	else
		Alt_Id3_Exp_Date="&nbsp;";

    Alt_Id4_No     =rs.getString("alt_id4_no");
    if(Alt_Id4_No  ==null){Alt_Id4_No  ="&nbsp; ";}
	

    Alt_Id4_Exp_Date =rs.getString("alt_id4_exp_date");
	if(Alt_Id4_Exp_Date!=null){
		Alt_Id4_Exp_Date=DateUtils.convertDate(Alt_Id4_Exp_Date,"DMY","en",locale); 
	}
	else
		Alt_Id4_Exp_Date="&nbsp;"; 
		
	Family_Link_No    =rs.getString("family_link_no");
    if(Family_Link_No ==null)Family_Link_No ="&nbsp; ";
    
    Relationship_Name  =rs.getString("relationship_name");
    if(Relationship_Name==null)Relationship_Name="&nbsp; ";
    
    Name_Prefix     =rs.getString("name_prefix");
    if(Name_Prefix ==null)Name_Prefix ="&nbsp; ";

    First_Name      =rs.getString("first_name");
    if(First_Name==null)First_Name="&nbsp; ";

    Second_Name    =rs.getString("second_name");

    if(Second_Name==null)Second_Name="&nbsp; ";

    Third_Name     =rs.getString("third_name");
    if(Third_Name ==null)Third_Name ="&nbsp; ";

    Family_Name    =rs.getString("family_name");
    if(Family_Name==null)Family_Name="&nbsp; ";

    Name_Suffix   =rs.getString("name_suffix");
    if(Name_Suffix ==null)Name_Suffix ="&nbsp; ";

    name_prefix_loc_lang   =rs.getString("name_prefix_loc_lang");
    if(name_prefix_loc_lang ==null)name_prefix_loc_lang ="&nbsp; ";

    first_name_loc_lang   =rs.getString("first_name_loc_lang");
    if(first_name_loc_lang ==null)first_name_loc_lang =" &nbsp;";

    second_name_loc_lang   =rs.getString("second_name_loc_lang");
    if(second_name_loc_lang ==null)second_name_loc_lang =" &nbsp;";

    third_name_loc_lang   =rs.getString("third_name_loc_lang");
    if(third_name_loc_lang ==null)third_name_loc_lang =" &nbsp;";

    family_name_loc_lang   =rs.getString("family_name_loc_lang");
   
	if(family_name_loc_lang ==null)family_name_loc_lang ="&nbsp; ";

    name_suffix_loc_lang   =rs.getString("name_suffix_loc_lang");
    if(name_suffix_loc_lang ==null)name_suffix_loc_lang =" &nbsp;";

    patient_name_loc_lang   =rs.getString("patient_name_loc_lang");
    if(patient_name_loc_lang ==null)patient_name_loc_lang =" &nbsp;";
    
    head_patient_name = rs.getString("head_patient_name");
    if(head_patient_name == null)   head_patient_name = "&nbsp;" ;
    
    race_long_desc = rs.getString("race_long_desc");
    if(race_long_desc == null)   race_long_desc = "&nbsp;" ;
    
    ethnic_long_desc = rs.getString("ethnic_long_desc");
    if(ethnic_long_desc == null)   ethnic_long_desc = "&nbsp;" ;
    
    Sex          =rs.getString("sex");
    if(Sex==null)Sex="";

	blood_grp_desc = rs.getString("blood_grp_desc");
	if(blood_grp_desc==null)
		blood_grp_desc="&nbsp; ";
		
	rh_factor_desc = rs.getString("rh_factor_desc");
	if(rh_factor_desc==null)
		rh_factor_desc="&nbsp; ";


    Date_Of_Birth  =rs.getString("date_of_birth");
    if(Date_Of_Birth==null){
		Date_Of_Birth=""; 
    }
	else 
	{
		Date_Of_Birth=Date_Of_Birth.substring(0,10);
		Date_Of_Birth=DateUtils.convertDate(Date_Of_Birth,"DMY","en",locale); 
	}
    
    Place_Of_Birth =rs.getString("place_of_birth");
    if(Place_Of_Birth==null)Place_Of_Birth="";

	birth_place_code = rs.getString("birth_place_code");
	if(birth_place_code==null)birth_place_code="";

	birth_place_desc = rs.getString("birth_place_desc");
	if(birth_place_desc==null) birth_place_desc="";
	
	Alias_Name   =rs.getString("alias_name");
    if(Alias_Name ==null)Alias_Name ="";

    Relgn_Desc   =rs.getString("relgn_desc");
    if(Relgn_Desc ==null)Relgn_Desc ="";

    Nationality_Desc  =rs.getString("nationality_desc");
    if(Nationality_Desc ==null)Nationality_Desc ="";

	language_name = rs.getString("language_name");
	if(language_name==null)language_name="";

    Pat_Cat_Desc    =rs.getString("pat_cat_desc");
    if(Pat_Cat_Desc  ==null)Pat_Cat_Desc  ="";

    data_source = rs.getString("data_source");
	if (data_source==null) data_source="";
	Age = rs.getString("age");
	if (Age==null) Age="";

    
	
	if(!Age.equals("")) {

		StringTokenizer st = new StringTokenizer(Age," ");

			while ( st.hasMoreTokens() ) {

						String date_elmnt = st.nextToken();						

						char ymdh_char = date_elmnt.charAt(date_elmnt.length()-1);							

						String ymdh_elmnt = date_elmnt.substring(0,(date_elmnt.length()-1));				

						if(ymdh_char=='Y') {
							if(!ymdh_elmnt.equals("0"))
								age_value = age_value+ymdh_elmnt+"Y ";								
						} else if (ymdh_char=='M') {
							if(!ymdh_elmnt.equals("0"))
								age_value = age_value+ymdh_elmnt+"M ";								
						} else if (ymdh_char=='D') {
							if(!ymdh_elmnt.equals("0"))
								age_value = age_value+ymdh_elmnt+"D ";								
						} else if (ymdh_char=='H') {
								age_value = age_value+ymdh_elmnt+"H ";
						}
					}	
	}
	
	MembershipType=rs.getString("MembershipType");
    if(MembershipType==null)MembershipType="";
    
	Orgsubname=rs.getString("Orgsubname");
    if(Orgsubname==null)Orgsubname="";
	
    Orgname=rs.getString("Orgname");
    if(Orgname==null)Orgname="";
	
    patexpirtydate=rs.getString("patexpirtydate");
    if(patexpirtydate!=null)
	{
		patexpirtydate=DateUtils.convertDate(patexpirtydate,"DMY","en",locale);
	}
	else
		patexpirtydate="";
    
    Prn_Tel_No=rs.getString("prn_tel_no");
    if(Prn_Tel_No==null)Prn_Tel_No="";
	old_Prn_Tel_No = Prn_Tel_No;
	

    Orn_Tel_No=rs.getString("orn_tel_no");
    if(Orn_Tel_No==null)Orn_Tel_No="";
	old_Orn_Tel_No = Orn_Tel_No;
	
    
	
    }
}

String sql_sel="select short_desc,contact_mode from mp_contact_mode_lang_vw where language_id='"+locale+"' and contact_mode in ('PRN','ORN') order by contact_mode desc";
		  pstmt = con.prepareStatement(sql_sel);
		  rs=pstmt.executeQuery();
		  while (rs.next()) {
			  if(rs.getString("contact_mode").equals("PRN")) {
				  contactModeOne = rs.getString("short_desc");
			  } else if(rs.getString("contact_mode").equals("ORN")) {
				  contactModeTwo = rs.getString("short_desc");
			  }
		  }
          if(pstmt != null) pstmt.close();
		  if(rs != null) rs.close();
%>

<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
<link rel='stylesheet' type='text/css'
	href='../../eCommon/html/Tabs.css'></link>
<link rel='stylesheet' type='text/css'
	href='../../eCommon/html/<%=sStyle%>'></link>
<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<Script src="../../eMP/js/json02.js"></Script>
<Script src="../../eMP/js/jquery.min.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
	<form name='ChangePatPhone' id='ChangePatPhone' method='post'
		action='../../servlet/eMP.PatientRegistrationServlet'
		target='messageFrame'>
		<table border='0' cellpadding='3' cellspacing='0' width="100%"
			align="center">

			<tr>
				<td class='label' width='24%'>Patient Id</td>
				<td class='data' width='24%'><%=Patient_id%></td>
			</tr>

			<tr>
				<td class='label' width='24%'><fmt:message
						key="eMP.PatientSeries.label" bundle="${mp_labels}" /></td>
				<td class='data' width='24%'><%=Pat_Ser_Grp_Desc %></td>
				<td class='label' width='24%'><fmt:message
						key="eMP.PrefFacility.label" bundle="${mp_labels}" /></td>
				<td class='data' width='24%'><%=Pref_Facility_Name%></td>
			</tr>
			<tr>
				<td class="COLUMNHEADER" colspan='4' width='24%'><fmt:message
						key="eMP.identitydetails.label" bundle="${mp_labels}" /></td>
			</tr>
			<tr>
				<%if(accept_national_id_no_yn.equals("Y")){ %>
				<td class='label' width='24%'><%=nat_id_prompt%></td>
				<td class='data' width='24%'><%=National_Id_No%></td>
				<%} else {%>
				<td colspan=2 class='data'></td>
				<%}%>

				<%if(accept_oth_alt_id_yn.equals("Y")) {%>
				<td class='label' width='25%'><fmt:message
						key="eMP.OtherAltNo.label" bundle="${mp_labels}" /></td>
				<td class='data' width='25%'><%=demo_oth_alt_id_desc%>&nbsp;&nbsp;&nbsp;<%=demo_oth_alt_id_no%></td>
				<%} else {%>
				<td colspan=2 class='data'></td>
				<%}%>
			</tr>
			<tr>
				<td class='label'><%=Alt_Id1_Type%></td>
				<td class='data'><%=Alt_Id1_No%></td>
				<% if(alt_id1_exp_date_accept_yn.equals("Y")) {%>
				<td class='label'><fmt:message key="Common.expiryDate.label"
						bundle="${common_labels}" /></td>
				<td class='data'><%=Alt_Id1_Exp_Date%></td>
				<% } else{%>
				<td colspan=2>&nbsp;</td>
				<% } %>
			</tr>

			<% if(Alt_Id2_Type != "") { %>
			<tr>
				<td class='label'><%=Alt_Id2_Type%></td>
				<td class='data'><%=Alt_Id2_No%></td>
				<%if(alt_id2_exp_date_accept_yn.equals("Y")) { %>
				<td class='label'><fmt:message key="Common.expiryDate.label"
						bundle="${common_labels}" /></td>
				<td class='data'><%=Alt_Id2_Exp_Date%></td>
				<%}else{%>
				<td colspan=2>&nbsp;</td>
				<%}%>
			</tr>
			<%} %>

			<% if(Alt_Id3_Type != "") { %>
			<tr>
				<td class='label'><%=Alt_Id3_Type%></td>
				<td class='data'><%=Alt_Id3_No%></td>

				<%if(alt_id3_exp_date_accept_yn.equals("Y"))
			 {  %>
				<td class='label'><fmt:message key="Common.expiryDate.label"
						bundle="${common_labels}" /></td>
				<td class='data'><%=Alt_Id3_Exp_Date%></td>
				<%}else{%>
				<td colspan=2>&nbsp;</td>
				<%}%>
			</tr>
			<%}%>


			<% if(Alt_Id4_Type != "") {	%>
			<tr>
				<td class='label'><%=Alt_Id4_Type%></td>
				<td class='data'><%=Alt_Id4_No%></td>

				<%if(alt_id4_exp_date_accept_yn.equals("Y")) {  %>
				<td class='label'><fmt:message key="Common.expiryDate.label"
						bundle="${common_labels}" /></td>
				<td class='data'><%=Alt_Id4_Exp_Date%></td>
				<%}else{%>
				<td class='label' colspan='2'>&nbsp;</td>
				<%}%>
			</tr>
			<%}%>

			<%if(family_org_id_accept_yn.equals("Y")) {%>
			<tr>
				<td class="COLUMNHEADER" colspan='4'><fmt:message
						key="eMP.headfamilydetails.label" bundle="${mp_labels}" /></td>
			</tr>

			<tr>
				<td class='label' width='24%'><fmt:message
						key="eMP.membership.label" bundle="${mp_labels}" /></td>

				<td class='data' width='24%'>
					<%if(MembershipType.equals("1")){%> <fmt:message
						key="eMP.organizationmember.label" bundle="${mp_labels}" /> <%}else if (MembershipType.equals("2")){%>
					<fmt:message key="eMP.relatedmemberfamily.label"
						bundle="${mp_labels}" /> <%}else if(MembershipType.equals("3")){%>
					<fmt:message key="eMP.relatedmembernonfamily.label"
						bundle="${mp_labels}" /> <%}else if(MembershipType.equals("4")){%>
					<fmt:message key="eMP.nonorganizationmember.label"
						bundle="${mp_labels}" /> <%}%>
				</td>
				<td class='label' width='<%=header_width%>'><fmt:message
						key="Common.Organization.label" bundle="${common_labels}" /></td>
				<td class='data' width='<%=data_width%>' style='<%=data_word_wrap%>'><%=Orgname%>&nbsp;
					<%if(!Orgname.equals("") && !Orgsubname.equals("")){ %>/&nbsp;<%}%><%=Orgsubname%></td>
			</tr>
			<%}else{%>
			<tr>
				<td colspan=4 class='label'>&nbsp;</td>
			</tr>
			<%}%>

			<%if(Family_No_Link_Yn.equals("Y"))
		 {%>
			<tr>
				<td class='label'><fmt:message key="eMP.HeadPatientID.label"
						bundle="${mp_labels}" /></td>
				<td class='data'><%=Family_Link_No%> <!-- <%if(family_org_id_accept_yn.equals("Y"))
				{%>
					 <td colspan=1 align='left' class='data' >
				<%}
				else 
				{%>
					  <td colspan=2 align='left' class='data' >
			   <%}%> --> <%=head_patient_name%></td>
				<td class='label'><fmt:message
						key="eMP.RelationshiptoHeadofFamily.label" bundle="${mp_labels}" /></td>
				<td class='data'><%=Relationship_Name%></td>
			</tr>
			<%}
		 else
		 {%>
			<tr>
				<td colspan=4 class='data' width='45%'>&nbsp;</td>
			</tr>
			<%}%>

			<tr>
				<td width="100%" class="BORDER" colspan='4'>
					<table cellpadding='3' cellspacing='0' border='0' width="100%">
						<tr>
							<td class="COLUMNHEADER" colspan='6'><fmt:message
									key="eMP.names.label" bundle="${mp_labels}" /></td>
						</tr>
						<tr>
							<%
if ( Name_Prefix_Accept_Yn.equals("Y") )
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">"+Name_Prefix_Prompt+"</td>");

if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==1 ) {
        out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">"+ First_Name_Prompt + "</td>");
}
else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 ) {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">" + Second_Name_Prompt + "</td>");
}
else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==1 )  {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">" + Third_Name_Prompt + "</td>");

}
else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==1 ) {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">" + Family_Name_Prompt + "</td>");
}

if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==2 ) {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">"+ First_Name_Prompt + "</td>");
}
else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==2 ) {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">" + Second_Name_Prompt + "</td>");
}
else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==2 )  {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">" + Third_Name_Prompt + "</td>");
}
else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==2 ) {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">" + Family_Name_Prompt + "</td>");
}

if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==3 ) {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">"+ First_Name_Prompt + "</td>");
}
else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==3 ) {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">" + Second_Name_Prompt + "</td>");
}
else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==3 )  {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">" + Third_Name_Prompt + "</td>");
}
else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==3 ) {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">" + Family_Name_Prompt + "</td>");
}

if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==4 ) {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">"+ First_Name_Prompt + "</td>");
}
else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==4 ) {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">" + Second_Name_Prompt + "</td>");
}
    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==4 )  {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">" + Third_Name_Prompt + "</td>");
}
else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4 ) {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">" + Family_Name_Prompt + "</td>");
}


if ( Name_Suffix_Accept_Yn.equals("Y") )
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">"+Name_Suffix_Prompt+"</td>");
%>
						</tr>
						<tr>
							<% if ( Name_Prefix_Accept_Yn.equals("Y") )
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">"+Name_Prefix+"</td>");

if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==1 ) {
        out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">"+ First_Name + "</td>");
}
else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 ) {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + Second_Name + "</td>");
}
else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==1 )  {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + Third_Name + "</td>");

}
else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==1 ) {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + Family_Name + "</td>");
}

if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==2 ) {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">"+ First_Name + "</td>");
}
else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==2 ) {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + Second_Name + "</td>");
}
else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==2 )  {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + Third_Name + "</td>");
}
else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==2 ) {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + Family_Name + "</td>");
}

if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==3 ) {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">"+ First_Name + "</td>");
}
else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==3 ) {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + Second_Name + "</td>");
}
else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==3 )  {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + Third_Name + "</td>");
}
else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==3 ) {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + Family_Name + "</td>");
}

if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==4 ) {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">"+ First_Name + "</td>");
}
else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==4 ) {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + Second_Name + "</td>");
}
    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==4 )  {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + Third_Name + "</td>");
}
else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4 ) {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + Family_Name + "</td>");
}


if ( Name_Suffix_Accept_Yn.equals("Y") )
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">"+Name_Suffix+"</td>");

%>
						</tr>

						<%

try
{
	if(names_in_oth_lang_yn.equals("Y")) {  %>
						<tr>
							<% if(!language_direction.equals("R")) {
       
		 if ( Name_Prefix_Accept_Yn.equals("Y") )
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">"+name_prefix_loc_lang_prompt+"</td>");

       if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==1 ) {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">"+ first_name_loc_lang_prompt + "</td>");
        }
        else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 ) {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + second_name_loc_lang_prompt + "</td>");
        }
            else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==1 )  {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + third_name_loc_lang_prompt + "</td>");
        }
        else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==1 ) {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + family_name_loc_lang_prompt + "</td>");
        }

//start
        if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==2 ) {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">"+ first_name_loc_lang_prompt + "</td>");
        }
        else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==2 ) {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + second_name_loc_lang_prompt + "</td>");
        }
        else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==2 )  {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + third_name_loc_lang_prompt + "</td>");
        }
        else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==2 ) {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + family_name_loc_lang_prompt + "</td>");
        }
//3
        if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==3 ) {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">"+ first_name_loc_lang_prompt + "</td>");
        }
        else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==3 ) {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + second_name_loc_lang_prompt + "</td>");
        }
        else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==3)  {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + third_name_loc_lang_prompt + "</td>");
        }
        else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==3) {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + family_name_loc_lang_prompt + "</td>");
        }
//2
        if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==4 ) {
                out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">"+ first_name_loc_lang_prompt + "</td>");
        }
        else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==4 ) {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + second_name_loc_lang_prompt + "</td>");
        }
        else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==4 )  {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + third_name_loc_lang_prompt + "</td>");

        }
        else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4 ) {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + family_name_loc_lang_prompt + "</td>");
        }
//1
		 if ( Name_Suffix_Accept_Yn.equals("Y") )
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">"+name_suffix_loc_lang_prompt+"</td>");
       
        %>
						</tr>
						<tr>
							<%
          
			if ( Name_Prefix_Accept_Yn.equals("Y") )
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">"+name_prefix_loc_lang+"</td>");        

            if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==1 ) {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">"+ first_name_loc_lang + "</td>");
            }
            else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 ) {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + second_name_loc_lang + "</td>");
            }
                else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==1 )  {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + third_name_loc_lang + "</td>");
            }
            else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==1 ) {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + family_name_loc_lang + "</td>");
            }

//start
            if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==2 ) {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">"+ first_name_loc_lang + "</td>");
            }
            else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==2 ) {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + second_name_loc_lang + "</td>");
            }
            else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==2 )  {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + third_name_loc_lang + "</td>");
            }
            else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==2 ) {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + family_name_loc_lang + "</td>");
            }
//3
            if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==3) {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">"+ first_name_loc_lang + "</td>");
            }
            else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==3 ) {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + second_name_loc_lang + "</td>");
            }
            else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==3 )  {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + third_name_loc_lang + "</td>");
            }
            else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==3 ) {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + family_name_loc_lang + "</td>");
            }
//1
            if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==4 ) {
                    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">"+ first_name_loc_lang + "</td>");
            }
            else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==4) {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + second_name_loc_lang + "</td>");
            }
            else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==4 )  {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + third_name_loc_lang + "</td>");

            }
            else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4 ) {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + family_name_loc_lang + "</td>");
            }
			
			  if ( Name_Suffix_Accept_Yn.equals("Y") )
                out.println("<td  width='16%' class='data'  style=\"border-right-style: solid; border-right-color: white\">"+name_suffix_loc_lang+"</td>");

		}
		else if(language_direction.equals("R"))
		{

	
		if ( Name_Suffix_Accept_Yn.equals("Y") )
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">"+name_suffix_loc_lang_prompt+"</td>");


	  if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==4 ) {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">"+ first_name_loc_lang_prompt + "</td>");
        }
        else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==4 ) {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + second_name_loc_lang_prompt + "</td>");
        }
        else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==4 )  {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + third_name_loc_lang_prompt + "</td>");

        }
        else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4 ) {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + family_name_loc_lang_prompt + "</td>");
        }



		
		if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==3 ) {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">"+ first_name_loc_lang_prompt + "</td>");
        }
        else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==3 ) {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + second_name_loc_lang_prompt + "</td>");
        }
        else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==3)  {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + third_name_loc_lang_prompt + "</td>");
        }
        else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==3) {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + family_name_loc_lang_prompt + "</td>");
        }



		if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==2 ) {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">"+ first_name_loc_lang_prompt + "</td>");
        }
        else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==2 ) {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + second_name_loc_lang_prompt + "</td>");
        }
        else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==2 )  {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + third_name_loc_lang_prompt + "</td>");
        }
        else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==2 ) {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + family_name_loc_lang_prompt + "</td>");
        }


			

       if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==1 ) {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">"+ first_name_loc_lang_prompt + "</td>");
        }
        else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 ) {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + second_name_loc_lang_prompt + "</td>");
        }
            else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==1 )  {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + third_name_loc_lang_prompt + "</td>");
        }
        else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==1 ) {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + family_name_loc_lang_prompt + "</td>");
        }


		if ( Name_Prefix_Accept_Yn.equals("Y") )
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">"+name_prefix_loc_lang_prompt+"</td>");
		
       
        %>
						</tr>
						<tr>
							<%
          
			if ( Name_Suffix_Accept_Yn.equals("Y") )
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>"+name_suffix_loc_lang+"</b></td>");

			if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==4 ) {
                    out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>"+ first_name_loc_lang + "</b></td>");
            }
            else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==4) {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>" + second_name_loc_lang + "</b></td>");
            }
            else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==4 )  {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>" + third_name_loc_lang + "</b></td>");

            }
            else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4 ) {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>" + family_name_loc_lang + "</b></td>");
            }



			if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==3) {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>"+ first_name_loc_lang + "</b></td>");
            }
            else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==3 ) {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>" + second_name_loc_lang + "</b></td>");
            }
            else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==3 )  {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>" + third_name_loc_lang + "</b></td>");
            }
            else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==3 ) {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>" + family_name_loc_lang + "</b></td>");
            }


			
			if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==2 ) {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>"+ first_name_loc_lang + "</b></td>");
            }
            else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==2 ) {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>" + second_name_loc_lang + "</b></td>");
            }
            else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==2 )  {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>" + third_name_loc_lang + "</b></td>");
            }
            else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==2 ) {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>" + family_name_loc_lang + "</b></td>");
            }

			

            if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==1 ) {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>"+ first_name_loc_lang + "</b></td>");
            }
            else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 ) {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>" + second_name_loc_lang + "</b></td>");
            }
                else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==1 )  {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>" + third_name_loc_lang + "</b></td>");
            }
            else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==1 ) {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>" + family_name_loc_lang + "</b></td>");
            }

			if ( Name_Prefix_Accept_Yn.equals("Y") )
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>"+name_prefix_loc_lang+"</b></td>"); 

		}
            
		}
}
catch(Exception e){
	//out.println(e);
e.printStackTrace();
}
%>
						</tr>
					</table>
				</td>
			</tr>

			<tr>
				<td class="COLUMNHEADER" colspan='4'><fmt:message
						key="eMP.personaldetails.label" bundle="${mp_labels}" /></td>
			</tr>

			<tr>
				<td class="label" width="24%"><fmt:message
						key="Common.gender.label" bundle="${common_labels}" /></td>
				<td class='data' width="24%">
					<%if(Sex.equals("M"))
			{  %> <fmt:message key="Common.male.label" bundle="${common_labels}" />
					<%}else if(Sex.equals("F")){%> <fmt:message key="Common.female.label"
						bundle="${common_labels}" /> <%}else if(Sex.equals("U")){%> <fmt:message
						key="Common.unknown.label" bundle="${common_labels}" /> <%}%>
				</td>
				<td class="label" width="24%"><fmt:message
						key="Common.bloodgroup.label" bundle="${common_labels}" />/<fmt:message
						key="Common.RhFactor.label" bundle="${common_labels}" /></td>
				<td class='data' width="24%"><%=blood_grp_desc%> /<%=rh_factor_desc%></td>

			</tr>

			<tr>
				<td class="label" width="24%"><fmt:message
						key="Common.age.label" bundle="${common_labels}" /></td>
				<td class='data' width="24%"><%=age_value%></td>
				<td width="24%" class="label"><fmt:message
						key="Common.birthDate.label" bundle="${common_labels}" /></td>
				<td width="25%" class="label"><b><%=Date_Of_Birth%></b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%if(hijirisitespecifApplicable){%><fmt:message
						key="eMP.Hijri.label" bundle="${mp_labels}" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><span
						id="hiji_date_display"><%=hijri_birth_date%></span></b> <%}%></td>
			</tr>
			<!--above line added for this CRF MMS-QH-CRF-0145 -->

			<tr>
				<td width="24%" class="label"><fmt:message
						key="eMP.maritalstatus.label" bundle="${mp_labels}" /></td>
				<td class='data' width="15%"><%=Mar_Status_Desc%></td>
				<td width="24%" class="label"><fmt:message
						key="Common.birthPlace.label" bundle="${common_labels}" /></td>
				<td class='data' width="25%">
					<%
			if(!(Place_Of_Birth==null))	
			out.println(Place_Of_Birth);
			if(!(birth_place_code==null))
			out.println(birth_place_desc);	
			%>
				</td>
			</tr>

			<tr>
				<td class="label"><fmt:message key="Common.category.label"
						bundle="${common_labels}" /></td>
				<td class="data"><%=Pat_Cat_Desc%></td>
				<%if(entitlement_by_pat_cat_yn.equals("Y")){%>
				<td class="label"><fmt:message key="Common.expiryDate.label"
						bundle="${common_labels}" /></td>
				<td class="data">
					<%if(!patexpirtydate.equals("")){%> <%}%><%=patexpirtydate%>
				</td>
				<%}else {%>
				<td class="label" colspan='2'>&nbsp;</td>
				<%}%>
			</tr>



			<tr>
				<td class="label"><fmt:message key="Common.residency.label"
						bundle="${common_labels}" /></td>
				<td class="data">
					<%
					if(citizen_yn.equals("Y")) { %><fmt:message
						key="Common.citizen.label" bundle="${common_labels}" /> <% }
					else if(citizen_yn.equals("N")) { %><fmt:message
						key="Common.noncitizen.label" bundle="${common_labels}" /> <% } %>

				</td>
				<td class="label"><fmt:message key="Common.status.label"
						bundle="${common_labels}" /></td>
				<td class="data">
					<%
					if(legal_yn.equals("Y")){ %><fmt:message key="Common.legal.label"
						bundle="${common_labels}" /> <% }
					else if(legal_yn.equals("N")){ %><fmt:message
						key="Common.illegal.label" bundle="${common_labels}" /> <% } %>

				</td>
			</tr>

			<tr>
				<td class="label"><fmt:message key="Common.nationality.label"
						bundle="${common_labels}" /></td>
				<td class="data"><%=Nationality_Desc%></td>
				<td class="label"><fmt:message key="Common.race.label"
						bundle="${common_labels}" /></td>
				<td class="data"><%=race_long_desc%>&nbsp;</td>
			</tr>

			<tr>
				<td class="label"><fmt:message key="eMP.ethnicity.label"
						bundle="${mp_labels}" /></td>
				<td class="data"><%=ethnic_long_desc%>&nbsp;</td>
				<td class="label"><fmt:message key="Common.religion.label"
						bundle="${common_labels}" /></td>
				<td class="data"><%=Relgn_Desc%>&nbsp;</td>

			</tr>
			<tr>
				<td class="label"><fmt:message key="Common.Language.label"
						bundle="${common_labels}" /></td>
				<td class='data'><%=language_name%>&nbsp;</td>
				<td class="label"><fmt:message key="eMP.AliasName.label"
						bundle="${mp_labels}" /></td>
				<td class='data'><%=Alias_Name%>&nbsp;</td>

			</tr>

			<tr>
				<td class="COLUMNHEADER" colspan='4'>Contact Modes</td>
			</tr>

			<tr>
				<td class="label" width="24%"><%=contactModeOne%></td>
				<td class='data' width="24%"><input type='text'
					name='contact1_no' id='contact1_no' size='20' maxlength='20'
					value="<%= Prn_Tel_No%>"></td>
				<td class="label" width="24%"><%=contactModeTwo%></td>
				<td class='data' width="24%"><input type='text'
					name='contact2_no' id='contact2_no' size='20' maxlength='20'
					value="<%= Orn_Tel_No%>"></td>

			</tr>

		</table>
		<input type='hidden' name='operation' id='operation' value='update_phone_no'>
		<input type='hidden' name='national_id_no' id='national_id_no' value='<%=National_Id_No%>'>
		<input type='hidden' name='function_id' id='function_id' value='<%=function_id%>'>
		<input type='hidden' name='Patient_id' id='Patient_id' value='<%=Patient_id%>'>
		<input type='hidden' name='old_contact1_no' id='old_contact1_no' value='<%=old_Prn_Tel_No%>'>
		<input type='hidden' name='old_contact2_no' id='old_contact2_no' value='<%=old_Orn_Tel_No%>'>
	</form>
</body>
</html>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

