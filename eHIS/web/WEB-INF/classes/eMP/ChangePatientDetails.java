/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**	This File contains all the SQL SELECT queries used in the ChangePatientSubNames.jsp file.
	*	Last Modified Date 12/29/2005 10:21 AM 
	*/

package eMP;
 
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.util.*;
import java.io.*;
import eCommon.Common.CommonBean; // added by mujafar for KDAH-CRF-370.1
import webbeans.eCommon.*;

public class ChangePatientDetails implements Serializable
{
	/*	The static methos getSetupData retrives the setup data
	*	@Table mp_param, mp_alternate_id_type, mp_alternate_id_type, mp_alternate_id_type, 					mp_alternate_id_type
	*	@Returns hashMap
	*/
	public static HashMap getSetupData(String facility_id, String group, Connection con,java.util.Properties p) throws Exception
	{
		
		String locale = p.getProperty("LOCALE");

		PreparedStatement pstmt		= null;
		ResultSet rs				= null;

		StringBuffer SelectSQLBuffer = null;
		
		HashMap hashMap = null;
		String user_id=p.getProperty("login_user");

		try
		{
			SelectSQLBuffer = new StringBuffer();
			hashMap	= new HashMap();
			// Below query  is modified against GHL-CRF-0312 [IN:039856] & KDAH-CRF-0273 [IN:045012] by Saanthaakumar
			// alt_id2_accept_alphanumeric_yn, alt_id3_accept_alphanumeric_yn, alt_id4_accept_alphanumeric_yn, alt_id2_chng_allowed_yn, alt_id3_chng_allowed_yn, alt_id4_chng_allowed_yn, alt_id2_accept_oth_pat_ser_yn, alt_id3_accept_oth_pat_ser_yn, alt_id4_accept_oth_pat_ser_yn  added by Dharma on Apr 3rd 2015 against HSA-CRF-0191 [IN:049772] 
			SelectSQLBuffer.append("SELECT nvl(Alt_Id1_reqd_yn,'N'), nvl(Alt_Id2_reqd_yn,'N'), nvl(Alt_Id3_reqd_yn,'N'), nvl(Alt_Id4_reqd_yn,'N'), Alt_Id1_type, Alt_Id2_type, Alt_Id3_type, Alt_Id4_type, nvl(First_Name_Accept_Yn,'N'), nvl(First_Name_Order,'0'), nvl(First_Name_Prompt,'First Name'), nvl(Second_Name_Accept_Yn,'N'), nvl(Second_Name_Order,'0'), nvl(Second_Name_Prompt,'Second Name'), nvl(Third_Name_Accept_Yn,'N'), nvl(Third_Name_Order,'0'), nvl(Third_Name_Prompt,'Third Name'), nvl(Family_Name_Accept_Yn,'N'), nvl(Family_Name_Order,'0'), nvl(Family_Name_Prompt,'Family Name'), name_dervn_logic, nvl(Alt_Id1_length,'0'), nvl(Alt_Id2_length,'0'), nvl(Alt_Id3_length,'0'), nvl(Alt_Id4_length,'0'), nvl(name_suffix_accept_yn,'N'), nvl(name_prefix_accept_yn,'N'), nvl(name_suffix_prompt,'Name Suffix'), nvl(name_prefix_prompt,'Name Prefix'), nvl(first_name_reqd_yn,'N'), nvl(second_name_reqd_yn,'N'), nvl(third_name_reqd_yn,'N'), nvl(family_name_reqd_yn,'N'), nvl(name_suffix_reqd_yn,'N'), nvl(name_prefix_reqd_yn,'N'), nvl(family_no_link_yn,'N'), nvl(patient_id_length,0), nvl(citizen_nationality_code,'') citizen_nationality_code, nvl(Alt_Id1_Unique_yn,'N'), nvl(Alt_Id2_Unique_yn,'N'), nvl(Alt_Id3_Unique_yn,'N'), nvl(Alt_Id4_Unique_yn,'N'), decode('"+group+"','N',nat_id_pat_ser_grp,'A',alt_id_pat_ser_grp,'G',gen_pat_ser_grp), nat_id_length, nvl(ALT_ID1_LEN_VALIDATION_YN,'N') ALT_ID1_LEN_VALIDATION_YN, nvl(ALT_ID2_LEN_VALIDATION_YN,'N') ALT_ID2_LEN_VALIDATION_YN, nvl(ALT_ID3_LEN_VALIDATION_YN,'N') ALT_ID3_LEN_VALIDATION_YN, nvl(ALT_ID4_LEN_VALIDATION_YN,'N') ALT_ID4_LEN_VALIDATION_YN, alt_id1_exp_date_accept_yn, alt_id2_exp_date_accept_yn, alt_id3_exp_date_accept_yn, alt_id4_exp_date_accept_yn, alt_id1_routine_yn, alt_id1_data_source_id alt_id1_routine, alt_id2_routine_yn, alt_id2_data_source_id alt_id2_routine, alt_id3_routine_yn, alt_id3_data_source_id  alt_id3_routine, alt_id4_routine_yn, alt_id4_data_source_id  alt_id4_routine, NAT_ID_PAT_SER_GRP, nvl(ID_CHANGE_ALLOWED_FOR_SERIES,'*') ID_CHANGE_ALLOWED_FOR_SERIES, nvl(ADDL_FIELD1_PROMPT,'') ADDL_FIELD1_PROMPT, nvl(ADDL_FIELD1_LENGTH,'0') ADDL_FIELD1_LENGTH, nvl(ADDL_FIELD1_SECTION,'') ADDL_FIELD1_SECTION, nvl(ADDL_FIELD2_PROMPT,'') ADDL_FIELD2_PROMPT, nvl(ADDL_FIELD2_LENGTH ,'0') ADDL_FIELD2_LENGTH, nvl(ADDL_FIELD2_SECTION ,'') ADDL_FIELD2_SECTION, nvl(ADDL_FIELD3_PROMPT ,'') ADDL_FIELD3_PROMPT, nvl(ADDL_FIELD3_LENGTH ,'0') ADDL_FIELD3_LENGTH, nvl(ADDL_FIELD3_SECTION ,'') ADDL_FIELD3_SECTION, nvl(ADDL_FIELD4_PROMPT ,'') ADDL_FIELD4_PROMPT, nvl(ADDL_FIELD4_LENGTH,'0') ADDL_FIELD4_LENGTH, nvl(ADDL_FIELD4_SECTION ,'') ADDL_FIELD4_SECTION, nvl(ADDL_FIELD5_PROMPT,'') ADDL_FIELD5_PROMPT, nvl(ADDL_FIELD5_LENGTH ,'0') ADDL_FIELD5_LENGTH, nvl(ADDL_FIELD5_SECTION ,'') ADDL_FIELD5_SECTION, nvl(nat_id_prompt,'National Id No') nat_id_prompt, nvl(NAT_ID_CHK_LEN,'N') NAT_ID_CHK_LEN,  nat_id_check_digit_id,  alt_id1_chk_digit_scheme, alt_id2_chk_digit_scheme, alt_id3_chk_digit_scheme, alt_id4_chk_digit_scheme, nvl(NAME_PREFIX_LOC_LANG_PROMPT,'&nbsp;') NAME_PREFIX_LOC_LANG_PROMPT, nvl(FIRST_NAME_LOC_LANG_PROMPT,'&nbsp;') FIRST_NAME_LOC_LANG_PROMPT, nvl(SECOND_NAME_LOC_LANG_PROMPT,'&nbsp;') SECOND_NAME_LOC_LANG_PROMPT, nvl(THIRD_NAME_LOC_LANG_PROMPT,'&nbsp;') THIRD_NAME_LOC_LANG_PROMPT, nvl(FAMILY_NAME_LOC_LANG_PROMPT,'&nbsp;') FAMILY_NAME_LOC_LANG_PROMPT, nvl(NAME_SUFFIX_LOC_LANG_PROMPT,'&nbsp;') NAME_SUFFIX_LOC_LANG_PROMPT, name_prefix_length, first_name_length, second_name_length, third_name_length, family_name_length, name_suffix_length, accept_national_id_no_yn, nat_id_accept_alphanumeric_yn,alt_id1_accept_oth_pat_ser_yn, alt_id1_accept_alphanumeric_yn, invoke_routine, nat_data_source_id, max_patient_age, name_dervn_logic_oth_lang, pat_name_as_multipart_yn, nat_id_reqd_all_series, Accept_oth_alt_id_yn, alt_id1.long_desc alt_id1_desc, alt_id2.long_desc alt_id2_desc, alt_id3.long_desc  alt_id3_desc,  alt_id4.long_desc alt_id4_desc, ext_system_interface_yn, default_race_code, names_in_oth_lang_yn, to_char(sysdate,'dd/mm/yyyy') ServerDate, dflt_alt_id1_in_emp_id_yn, nb_mother_cutoff_age, maintain_doc_or_file,family_org_id_accept_yn,entitlement_by_pat_cat_yn,trim(org_member_relationship_code) org_member_relationship_code,mp_param.dflt_patient_name, mp_param.alt_id1_chng_allowed_yn,mp_param.accept_pw_in_chng_pat_dtl_yn,mp_param.DFLT_LANGUAGE_ID,mp_param.upt_contact_dtls_oa_yn, mp_param.DFLT_RELGN_CODE,mp_param.INV_PAT_SEARCH_IN_REG_PAT_YN, mp_param.name_pfx_reqd_for_org_mem_yn, mp_param.race_required_yn, mp_param.RELIGION_REQD_YN, mp_param.display_new_born_age_in_hrs,mp_param.single_patient_numbering_yn,(CASE WHEN org_member_relationship_code IS NOT NULL  THEN (mp_get_desc.MP_RELATIONSHIP(org_member_relationship_code,'"+locale+"',2)) END) org_member_relationship_desc,mp_param.NAME_DERVN_LOGIC_LONG,mp_param.NAME_DERVN_LOGIC_OTH_LANG_LONG,(select change_national_id_no_yn from MR_USER_ACCESS_RIGHTS where APPL_USER_ID='"+user_id+"' and facility_id='"+facility_id+"')change_national_id_no_yn,COUNTRY_REQD_YN,REGION_REQD_YN,MOBILE_NO_REQD_YN,EMAIL_ID_REQD_YN,PAT_SER_ACCESS_BY_USER_YN ,  alt_id2_accept_alphanumeric_yn, alt_id3_accept_alphanumeric_yn, alt_id4_accept_alphanumeric_yn, alt_id2_chng_allowed_yn, alt_id3_chng_allowed_yn, alt_id4_chng_allowed_yn, alt_id2_accept_oth_pat_ser_yn, alt_id3_accept_oth_pat_ser_yn, alt_id4_accept_oth_pat_ser_yn,mp_param.upd_pat_dtls_referral_yn, alt_id1_alphanum_validate_yn, alt_id2_alphanum_validate_yn, alt_id3_alphanum_validate_yn, alt_id4_alphanum_validate_yn,postal_cd_reqd_yn,area_reqd_yn,town_reqd_yn,pat_category_reqd_yn FROM mp_param_lang_vw mp_param, mp_alternate_id_type_lang_vw alt_id1, mp_alternate_id_type_lang_vw alt_id2, mp_alternate_id_type_lang_vw alt_id3, mp_alternate_id_type_lang_vw alt_id4 WHERE   mp_param.language_id=alt_id1.language_id and mp_param.language_id=alt_id2.language_id(+) and mp_param.language_id=alt_id3.language_id(+) and mp_param.language_id=alt_id4.language_id(+) and alt_id1_type = alt_id1.alt_id_type AND alt_id2_type = alt_id2.alt_id_type(+) AND alt_id3_type = alt_id3.alt_id_type(+) AND alt_id4_type = alt_id4.alt_id_type(+) and mp_param.module_id='MP' and mp_param.language_id = '"+locale+"' ");
			pstmt	= con.prepareStatement(SelectSQLBuffer.toString());
			rs		= pstmt.executeQuery();

            while(rs != null && rs.next())
			{ 
				hashMap.put("invoke_routine",		  checkForNull(rs.getString("invoke_routine")));
				hashMap.put("nat_data_source_id",	  checkForNull(rs.getString("nat_data_source_id")));
				hashMap.put("nat_id_pat_ser_grp",	  checkForNull(rs.getString("NAT_ID_PAT_SER_GRP")));
				hashMap.put("ext_system_interface_yn",checkForNull(rs.getString("ext_system_interface_yn")));
				hashMap.put("id_change_allowed_for_series",rs.getString("id_change_allowed_for_series"));
				hashMap.put("nat_id_reqd_all_series",checkForNull(rs.getString("nat_id_reqd_all_series")));
				hashMap.put("Alt_Id1_Reqd_Yn",		rs.getString(1));
				hashMap.put("Alt_Id2_Reqd_Yn",		rs.getString(2));
				hashMap.put("Alt_Id3_Reqd_Yn",		rs.getString(3));
				hashMap.put("Alt_Id4_Reqd_Yn",		rs.getString(4));
				hashMap.put("Alt_Id1_Type",			checkForNull(rs.getString(5)));
				hashMap.put("Alt_Id2_Type",			checkForNull(rs.getString(6)));
				hashMap.put("Alt_Id3_Type",			checkForNull(rs.getString(7)));
				hashMap.put("Alt_Id4_Type",			checkForNull(rs.getString(8)));
				hashMap.put("alt_id1_desc",				checkForNull(rs.getString("alt_id1_desc")));
				hashMap.put("alt_id2_desc",			checkForNull(rs.getString("alt_id2_desc")));
				hashMap.put("alt_id3_desc",			checkForNull(rs.getString("alt_id3_desc")));
				hashMap.put("alt_id4_desc",			checkForNull(rs.getString("alt_id4_desc")));
				hashMap.put("First_Name_Accept_Yn", rs.getString(9));
				hashMap.put("First_Name_Order",		rs.getString(10));
				hashMap.put("First_Name_Prompt",	rs.getString(11));
				hashMap.put("Second_Name_Accept_Yn",rs.getString(12));
				hashMap.put("Second_Name_Order",	rs.getString(13));
				hashMap.put("Second_Name_Prompt",	rs.getString(14));
				hashMap.put("Third_Name_Accept_Yn", rs.getString(15));
				hashMap.put("Third_Name_Order",		rs.getString(16));
				hashMap.put("Third_Name_Prompt",	rs.getString(17));
				hashMap.put("Family_Name_Accept_Yn",rs.getString(18));
				hashMap.put("Family_Name_Order",	rs.getString(19));
				hashMap.put("Family_Name_Prompt",	rs.getString(20));
				hashMap.put("NameDrvnLogic",		checkForNull(rs.getString(21)));
				hashMap.put("NameDrvnLogicOthLang", checkForNull(rs.getString("name_dervn_logic_oth_lang")));
				hashMap.put("Alt_Id1_length",		rs.getString(22));
				hashMap.put("Alt_Id2_length",		rs.getString(23));
				hashMap.put("Alt_Id3_length",		rs.getString(24));
				hashMap.put("Alt_Id4_length",		rs.getString(25));
				hashMap.put("Name_Suffix_Accept_Yn",rs.getString(26));
				hashMap.put("Name_Prefix_Accept_Yn",rs.getString(27));
				hashMap.put("Name_Suffix_Prompt",	rs.getString(28));
				hashMap.put("Name_Prefix_Prompt",	rs.getString(29));
				hashMap.put("First_Name_Reqd_Yn",	rs.getString(30));
				hashMap.put("Second_Name_Reqd_Yn",	rs.getString(31));    
				hashMap.put("Third_Name_Reqd_Yn",	rs.getString(32));
				hashMap.put("Family_Name_Reqd_Yn",	rs.getString(33));
				hashMap.put("Name_Suffix_Reqd_Yn",	rs.getString(34));
				hashMap.put("Name_Prefix_Reqd_Yn",	rs.getString(35));
				hashMap.put("Family_No_Link_Yn",	rs.getString(36));
				hashMap.put("Patient_Id_Length",	rs.getString(37));
				hashMap.put("Citizen_Nationality_Code", rs.getString(38));
				hashMap.put("default_race_code",		checkForNull(rs.getString("default_race_code")));
				hashMap.put("Alt_Id1_Unique_Yn",		rs.getString(39));
				hashMap.put("Alt_Id2_Unique_Yn",		rs.getString(40));
				hashMap.put("Alt_Id3_Unique_Yn",		rs.getString(41));
				hashMap.put("Alt_Id4_Unique_Yn",		rs.getString(42));
				hashMap.put("alt_id1_len_validation_yn",rs.getString("ALT_ID1_LEN_VALIDATION_YN"));
				hashMap.put("alt_id2_len_validation_yn",rs.getString("ALT_ID2_LEN_VALIDATION_YN"));
				hashMap.put("alt_id3_len_validation_yn",rs.getString("ALT_ID3_LEN_VALIDATION_YN"));
				hashMap.put("alt_id4_len_validation_yn",rs.getString("ALT_ID4_LEN_VALIDATION_YN"));
				hashMap.put("alt_id1_routine_yn",	checkForNull(rs.getString("alt_id1_routine_yn")));
				hashMap.put("alt_id2_routine_yn",	checkForNull(rs.getString("alt_id2_routine_yn")));
				hashMap.put("alt_id3_routine_yn",	checkForNull(rs.getString("alt_id3_routine_yn")));
				hashMap.put("alt_id4_routine_yn",	checkForNull(rs.getString("alt_id4_routine_yn")));
				hashMap.put("alt_id1_routine",		checkForNull(rs.getString("alt_id1_routine")));
				hashMap.put("alt_id2_routine",		checkForNull(rs.getString("alt_id2_routine")));
				hashMap.put("alt_id3_routine",		checkForNull(rs.getString("alt_id3_routine")));
				hashMap.put("alt_id4_routine",		checkForNull(rs.getString("alt_id4_routine")));
				hashMap.put("alt_id1_exp_date_accept_yn",checkForNull(rs.getString("alt_id1_exp_date_accept_yn")));
				hashMap.put("alt_id2_exp_date_accept_yn",checkForNull(rs.getString("alt_id2_exp_date_accept_yn")));
				hashMap.put("alt_id3_exp_date_accept_yn",checkForNull(rs.getString("alt_id3_exp_date_accept_yn")));
				hashMap.put("alt_id4_exp_date_accept_yn",checkForNull(rs.getString("alt_id4_exp_date_accept_yn")));
				hashMap.put("Accept_oth_alt_id_yn",checkForNull(rs.getString("Accept_oth_alt_id_yn"),"N"));
				hashMap.put("nat_id_prompt",		rs.getString("nat_id_prompt"));
				hashMap.put("nat_id_chk_len",		rs.getString("NAT_ID_CHK_LEN"));
				hashMap.put("nat_id_check_digit_id",rs.getString("nat_id_check_digit_id"));
				hashMap.put("alt_id1_chk_digit_scheme",checkForNull(rs.getString("alt_id1_chk_digit_scheme")));
				hashMap.put("alt_id2_chk_digit_scheme",checkForNull(rs.getString("alt_id2_chk_digit_scheme")));
				hashMap.put("alt_id3_chk_digit_scheme",checkForNull(rs.getString("alt_id3_chk_digit_scheme")));
				hashMap.put("alt_id4_chk_digit_scheme",checkForNull(rs.getString("alt_id4_chk_digit_scheme")));
				hashMap.put("nat_id_length",			 rs.getString("nat_id_length"));
				hashMap.put("family_name_loc_lang_prompt",rs.getString("family_name_loc_lang_prompt"));
				hashMap.put("name_suffix_loc_lang_prompt",rs.getString("name_suffix_loc_lang_prompt"));			hashMap.put("accept_national_id_no_yn",checkForNull(rs.getString("accept_national_id_no_yn"),"N"));				hashMap.put("nat_id_accept_alphanumeric_yn",checkForNull(rs.getString("nat_id_accept_alphanumeric_yn"),"N"));
				hashMap.put("name_prefix_length",checkForNull(rs.getString("name_prefix_length"),"0"));
				hashMap.put("first_name_length",checkForNull(rs.getString("first_name_length"),"0"));
				hashMap.put("second_name_length",checkForNull(rs.getString("second_name_length"),"0"));
				hashMap.put("third_name_length",checkForNull(rs.getString("third_name_length"),"0"));
				hashMap.put("family_name_length",checkForNull(rs.getString("family_name_length"),"0"));
				hashMap.put("name_suffix_length",checkForNull(rs.getString("name_suffix_length"),"0"));
				hashMap.put("alt_id1_accept_oth_pat_ser_yn",checkForNull(rs.getString("alt_id1_accept_oth_pat_ser_yn"),"N"));
				hashMap.put("alt_id1_accept_alphanumeric_yn",checkForNull(rs.getString("alt_id1_accept_alphanumeric_yn"),"N"));
				hashMap.put("max_pat_age",		checkForNull(rs.getString("max_patient_age")));
				hashMap.put("max_patient_age",	checkForNull(rs.getString("max_patient_age")));
				hashMap.put("pat_name_as_multipart_yn",checkForNull(rs.getString("pat_name_as_multipart_yn")));
				hashMap.put("addl_field1_section", rs.getString("addl_field1_section"));
				hashMap.put("addl_field1_prompt", rs.getString("addl_field1_prompt"));
				hashMap.put("addl_field1_length", rs.getString("addl_field1_length"));
				hashMap.put("addl_field2_section", rs.getString("addl_field2_section"));
				hashMap.put("addl_field2_prompt", rs.getString("addl_field2_prompt"));
				hashMap.put("addl_field2_length", rs.getString("addl_field2_length"));
				hashMap.put("addl_field3_section", rs.getString("addl_field3_section"));
				hashMap.put("addl_field3_prompt", rs.getString("addl_field3_prompt"));
				hashMap.put("addl_field3_length", rs.getString("addl_field3_length"));
				hashMap.put("addl_field4_section", rs.getString("addl_field4_section"));
				hashMap.put("addl_field4_prompt", rs.getString("addl_field4_prompt"));
				hashMap.put("addl_field4_length", rs.getString("addl_field4_length"));
				hashMap.put("addl_field5_section", rs.getString("addl_field5_section"));
				hashMap.put("addl_field5_prompt", rs.getString("addl_field5_prompt"));
				hashMap.put("addl_field5_length", rs.getString("addl_field5_length"));
				hashMap.put("first_name_loc_lang_prompt",rs.getString("FIRST_NAME_LOC_LANG_PROMPT"));
				hashMap.put("second_name_loc_lang_prompt",rs.getString("second_name_loc_lang_prompt"));
				hashMap.put("third_name_loc_lang_prompt",rs.getString("third_name_loc_lang_prompt"));
				hashMap.put("name_prefix_loc_lang_prompt",rs.getString("name_prefix_loc_lang_prompt"));
				hashMap.put("names_in_oth_lang_yn", checkForNull(rs.getString("names_in_oth_lang_yn"), "Y"));
				hashMap.put("ServerDate",	checkForNull(rs.getString("ServerDate")));
				hashMap.put("dflt_alt_id1_in_emp_id_yn",checkForNull(rs.getString("dflt_alt_id1_in_emp_id_yn"), "N"));
				hashMap.put("nb_mother_cutoff_age",checkForNull(rs.getString("nb_mother_cutoff_age"),"0"));
				hashMap.put("maintain_doc_or_file",checkForNull(rs.getString("maintain_doc_or_file"),"F"));
				hashMap.put("family_org_id_accept_yn",checkForNull(rs.getString("family_org_id_accept_yn"),"N"));
				hashMap.put("entitlement_by_pat_cat_yn",checkForNull(rs.getString("entitlement_by_pat_cat_yn"),"N"));
				hashMap.put("org_member_relationship_code",checkForNull(rs.getString("org_member_relationship_code")));
				hashMap.put("org_member_relationship_desc",checkForNull(rs.getString("org_member_relationship_desc")));
				hashMap.put("dflt_patient_name",checkForNull(rs.getString("dflt_patient_name")));
				hashMap.put("alt_id1_chng_allowed_yn",checkForNull(rs.getString("alt_id1_chng_allowed_yn"),"N"));
				hashMap.put("accept_pw_in_chng_pat_dtl_yn",checkForNull(rs.getString("accept_pw_in_chng_pat_dtl_yn"),"N"));

				hashMap.put("dflt_language_id",checkForNull(rs.getString("DFLT_LANGUAGE_ID")));
				hashMap.put("dflt_relgn_code",checkForNull(rs.getString("DFLT_RELGN_CODE")));
				hashMap.put("inv_pat_search_in_reg_pat_yn",checkForNull(rs.getString("INV_PAT_SEARCH_IN_REG_PAT_YN"),"N"));
				hashMap.put("name_pfx_reqd_for_org_mem_yn",checkForNull(rs.getString("name_pfx_reqd_for_org_mem_yn"),"N"));
				hashMap.put("race_required_yn",checkForNull(rs.getString("race_required_yn"),"N"));
				//Added by Mano on july 1st 2017 against ML-MMOH-CRF-0736
				hashMap.put("religion_reqd_yn",checkForNull(rs.getString("RELIGION_REQD_YN"),"N"));
				//End of ML-MMOH-CRF-0736
				hashMap.put("display_new_born_age_in_hrs",checkForNull(rs.getString("display_new_born_age_in_hrs"),""));
				hashMap.put("single_patient_numbering_yn",checkForNull(rs.getString("single_patient_numbering_yn"),"N"));
				//below code added for Brunei Long Name CRF Starts
				hashMap.put("name_dervn_logic_long",checkForNull(rs.getString("NAME_DERVN_LOGIC_LONG"),""));
				hashMap.put("name_dervn_logic_oth_lang_long",checkForNull(rs.getString("NAME_DERVN_LOGIC_OTH_LANG_LONG"),""));
				//below code added for Brunei Long Name CRF Ends
				hashMap.put("change_national_id_no_yn",checkForNull(rs.getString("change_national_id_no_yn"),"N"));
				hashMap.put("COUNTRY_REQD_YN",checkForNull(rs.getString("COUNTRY_REQD_YN"),"N"));
				hashMap.put("REGION_REQD_YN",checkForNull(rs.getString("REGION_REQD_YN"),"N"));
				hashMap.put("MOBILE_NO_REQD_YN",checkForNull(rs.getString("MOBILE_NO_REQD_YN"),"N"));
				hashMap.put("POSTAL_CD_REQD_YN",checkForNull(rs.getString("POSTAL_CD_REQD_YN"),"N"));
				hashMap.put("AREA_REQD_YN",checkForNull(rs.getString("AREA_REQD_YN"),"N"));
				hashMap.put("TOWN_REQD_YN",checkForNull(rs.getString("TOWN_REQD_YN"),"N")); //Added by Suji keerthi on 28-Nov-2019 for KDAH-CRF-0522
				hashMap.put("pat_category_reqd_yn",checkForNull(rs.getString("pat_category_reqd_yn"),"N")); //Added by Suji keerthi on 21-Nov-2019 for KDAH-CRF-0522
				// Newly Added against KDAH-CRF-0273 [IN:045012]  By saanthaakumar
				hashMap.put("EMAIL_ID_REQD_YN",checkForNull(rs.getString("EMAIL_ID_REQD_YN"),"N"));
				hashMap.put("PAT_SER_ACCESS_BY_USER_YN",checkForNull(rs.getString("PAT_SER_ACCESS_BY_USER_YN"),"N"));
				hashMap.put("upt_contact_dtls_oa_yn",checkForNull(rs.getString("upt_contact_dtls_oa_yn"),"N"));//added changes for HSA-CRF-0226 [IN:050599]
				
				/*Added by Dharma on Apr 3rd 2015 against HSA-CRF-0191 [IN:049772] Start */
				hashMap.put("alt_id2_accept_alphanumeric_yn",checkForNull(rs.getString("alt_id2_accept_alphanumeric_yn")));
				hashMap.put("alt_id3_accept_alphanumeric_yn",checkForNull(rs.getString("alt_id3_accept_alphanumeric_yn")));
				hashMap.put("alt_id4_accept_alphanumeric_yn",checkForNull(rs.getString("alt_id4_accept_alphanumeric_yn")));

				hashMap.put("alt_id2_chng_allowed_yn",checkForNull(rs.getString("alt_id2_chng_allowed_yn")));
				hashMap.put("alt_id3_chng_allowed_yn",checkForNull(rs.getString("alt_id3_chng_allowed_yn")));
				hashMap.put("alt_id4_chng_allowed_yn",checkForNull(rs.getString("alt_id4_chng_allowed_yn")));

				hashMap.put("alt_id2_accept_oth_pat_ser_yn",checkForNull(rs.getString("alt_id2_accept_oth_pat_ser_yn")));
				hashMap.put("alt_id3_accept_oth_pat_ser_yn",checkForNull(rs.getString("alt_id3_accept_oth_pat_ser_yn")));
				hashMap.put("alt_id4_accept_oth_pat_ser_yn",checkForNull(rs.getString("alt_id4_accept_oth_pat_ser_yn")));
				/*Added by Dharma on Apr 3rd 2015 against HSA-CRF-0191 [IN:049772] End */
				hashMap.put("upd_pat_dtls_referral_yn",checkForNull(rs.getString("upd_pat_dtls_referral_yn"),"N"));//Added by Dharma against HSA-CRF-0303 [IN:054572] on Apr 8th 2016
				/*Added By Dharma against GHL-CRF-0524.1 [IN:068022] on 25th July 2108 Start*/
				hashMap.put("alt_id1_alphanum_validate_yn",checkForNull(rs.getString("alt_id1_alphanum_validate_yn"),"N"));
				hashMap.put("alt_id2_alphanum_validate_yn",checkForNull(rs.getString("alt_id2_alphanum_validate_yn"),"N"));
				hashMap.put("alt_id3_alphanum_validate_yn",checkForNull(rs.getString("alt_id3_alphanum_validate_yn"),"N"));
				hashMap.put("alt_id4_alphanum_validate_yn",checkForNull(rs.getString("alt_id4_alphanum_validate_yn"),"N"));
				/*Added By Dharma against GHL-CRF-0524.1 [IN:068022] on 25th July 2108 End*/
			}
			
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return hashMap;
	}

	/*	The static methos getPatientData retrives the Patient Details
	*	@View mp_chg_pat_dtls_vw
	*	@Returns hashMap1
	Last Changed On : 4/25/2006  -	By Vinod 
		-> To put the Values in hasm map as names instead of numbers as earlier. Formatted the method.

	*/
	public static HashMap getPatientData(String patient_id, Connection con,java.util.Properties p) throws Exception {

		String locale = p.getProperty("LOCALE");
		boolean chkPanValidate = CommonBean.isSiteSpecific(con, "MP","PANCARD_VALIDATION"); // added by mujafar for KDAH-CRF-370.1
		boolean alterAddressApplicable = CommonBean.isSiteSpecific(con, "MP","ALTERNATE_ADDRESS_APPLICABLE"); // Added for ML-MMOH-CRF-0601	
		boolean chkAadhaarValidate = CommonBean.isSiteSpecific(con, "MP","AADHAAR_PROFILE"); // Added by Sethu for KDAH-CRF-0362
		boolean aliasnameNationalityRace = CommonBean.isSiteSpecific(con, "MP","BMI_REG_PAT_CHNGES_RH101");//Added by Suji Keerthi for ML-MMOH-CRF-1527
		boolean resiAddMailAdd = CommonBean.isSiteSpecific(con, "MP","BMI_REG_PAT_CHNGES_RH101");//Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
		//Added by Kamatchi S for ML-MMOH-CRF-1930 US004
		boolean isVirtualConsultation = false;
		isVirtualConsultation=eCommon.Common.CommonBean.isSiteSpecific(con,"OP","VIRTUAL_CONSULTATION"); 
		boolean isPractEmployeeServiceNumber = CommonBean.isSiteSpecific(con, "AM","PRACT_EMPLOYEE_SERVICE_NO");//Maheshwaran K added for MO-CRF-20183.2 as on 08-05-2023
		PreparedStatement pstmt1		= null;
		ResultSet rs33					= null;
		StringBuffer SelectSQLString	= null;
		HashMap hashMap1				= new HashMap();
		try {
			SelectSQLString = new StringBuffer();
			//Modified below query. Added 2 elements for  MYHIX integration ML-MMOH-CRF-0507.1
			// modified below query by mujafar for KDAH-CRF-370.1
			//Added national_id_no_dft for AAKH-CRF-0168
			SelectSQLString.append("SELECT patient.patient_id patient_id, patient.patient_name patient_name, patient.pat_ser_grp_code pat_ser_grp_code, (CASE WHEN patient.pat_ser_grp_code IS NOT NULL THEN (mp_get_desc.mp_pat_ser_grp(patient.pat_ser_grp_code,'"+locale+"',2)) END ) pat_ser_grp_desc, NVL(pat_ser_grp.ID_TYPE, '') ID_TYPE, pat_ser_grp.allow_family_no_yn, pat_ser_grp.pat_name_in_loc_lang_reqd_yn, patient.national_id_no national_id_no,patient.national_id_no_dft national_id_no_dft, to_char(patient.nat_id_expiry_date, 'dd/mm/yyyy')  nat_id_expiry_date,patient.pref_facility_id pref_facility_id, (CASE WHEN patient.pref_facility_id IS NOT NULL THEN (sm_get_desc.sm_facility_param(patient.pref_facility_id, '"+locale+"', 1)) END ) pref_facility_name, patient.regn_facility_id regn_facility_id, (CASE WHEN patient.regn_facility_id IS NOT NULL THEN (sm_get_desc.sm_facility_param(patient.regn_facility_id, '"+locale+"', 1)) END ) regn_facility_name, patient.alt_id1_type alt_id1_type, (CASE WHEN patient.alt_id1_type IS NOT NULL THEN (mp_get_desc.mp_alternate_id_type(patient.alt_id1_type,'"+locale+"',1)) END ) alt_id1_desc, patient.alt_id1_no alt_id1_no, to_char(patient.alt_id1_exp_date, 'dd/mm/yyyy') alt_id1_exp_date, patient.alt_id2_type alt_id2_type, (CASE WHEN patient.alt_id2_type IS NOT NULL    THEN (mp_get_desc.mp_alternate_id_type(patient.alt_id2_type,'"+locale+"',1)) END ) alt_id2_desc, patient.alt_id2_no alt_id2_no, to_char(patient.alt_id2_exp_date, 'dd/mm/yyyy') alt_id2_exp_date, patient.alt_id3_type alt_id3_type, (CASE WHEN patient.alt_id3_type IS NOT NULL THEN (mp_get_desc.mp_alternate_id_type(patient.alt_id3_type,'"+locale+"',1)) END ) alt_id3_desc, patient.alt_id3_no alt_id3_no, to_char(patient.alt_id3_exp_date, 'dd/mm/yyyy') alt_id3_exp_date, patient.alt_id4_type alt_id4_type, (CASE WHEN patient.alt_id4_type IS NOT NULL THEN (mp_get_desc.mp_alternate_id_type(patient.alt_id4_type,'"+locale+"',1)) END ) alt_id4_desc, patient.alt_id4_no alt_id4_no, to_char(patient.alt_id4_exp_date, 'dd/mm/yyyy') alt_id4_exp_date, patient.oth_alt_id_type oth_alt_id_type, (CASE WHEN patient.oth_alt_id_type IS NOT NULL THEN (mp_get_desc.mp_alternate_id_type(patient.oth_alt_id_type,'"+locale+"',1)) END ) demo_oth_alt_id_desc, patient.oth_alt_id_no demo_oth_alt_id_no, patient.family_link_no family_link_no, (CASE WHEN patient.family_link_no IS NOT NULL THEN (mp_get_desc.mp_patient(patient.family_link_no,1)) END ) head_patient_name,         patient.relationship_to_head relationship_to_head, (CASE WHEN patient.relationship_to_head IS NOT NULL THEN (mp_get_desc.mp_relationship(patient.relationship_to_head,'"+locale+"',2)) END ) relationship_name, patient.name_prefix name_prefix, patient.first_name first_name, patient.second_name second_name, patient.third_name third_name,           patient.family_name family_name, patient.name_suffix name_suffix, patient.name_prefix_loc_lang name_prefix_loc_lang, patient.first_name_loc_lang first_name_loc_lang, patient.second_name_loc_lang second_name_loc_lang, patient.third_name_loc_lang third_name_loc_lang, patient.family_name_loc_lang family_name_loc_lang, patient.name_suffix_loc_lang name_suffix_loc_lang, patient.patient_name_loc_lang patient_name_loc_lang, patient.sex sex, to_char(patient.date_of_birth, 'dd/mm/yyyy hh24:mi:ss') date_of_birth, patient.calculated_age_yn calculated_age_yn, patient.birth_place_code birth_place_code, (CASE WHEN patient.birth_place_code IS NOT NULL THEN (mp_get_desc.mp_birth_place(patient.birth_place_code,'"+locale+"',1))  END ) birth_place_desc, patient.place_of_birth place_of_birth, patient.mar_status_code mar_status_code, (CASE WHEN patient.mar_status_code IS NOT NULL THEN (mp_get_desc.mp_marital_status(patient.mar_status_code,'"+locale+"',2)) END ) mar_status_desc, patient.alias_name alias_name, patient.relgn_code relgn_code, (CASE WHEN patient.relgn_code IS NOT NULL    THEN (mp_get_desc.mp_religion(patient.relgn_code,'"+locale+"',2)) END ) relgn_desc, patient.ethnic_grp_code ethnic_grp_code, (CASE WHEN patient.ethnic_grp_code IS NOT NULL THEN (mp_get_desc.mp_ethnic_group(patient.ethnic_grp_code,'"+locale+"',2))   END ) ethnic_short_desc, (CASE WHEN patient.ethnic_grp_code IS NOT NULL THEN (mp_get_desc.mp_ethnic_group(patient.ethnic_grp_code,'"+locale+"',1)) END ) ethnic_long_desc, patient.race_code race_code, patient.citizen_yn citizen_yn, patient.legal_yn legal_yn, patient.nationality_code nationality_code, (CASE WHEN patient.nationality_code IS NOT NULL THEN (mp_get_desc.mp_country(patient.nationality_code,'"+locale+"',3)) END ) nationality_desc, patient.mother_maiden_name mother_maiden_name, patient.pat_cat_code pat_cat_code, (CASE WHEN patient.pat_cat_code IS NOT NULL THEN (mp_get_desc.mp_pat_category(patient.pat_cat_code,'"+locale+"',2)) END ) pat_cat_desc, patient.referral_facility_id referral_facility_id, patient.ref_source_code ref_source_code, NULL ref_source_desc, pat_addr.addr1_line1 resi_addr_line1, pat_addr.addr1_line2 resi_addr_line2, pat_addr.addr1_line3 resi_addr_line3, pat_addr.addr1_line4 resi_addr_line4, pat_addr.postal1_code resi_postal_code, mp_get_desc.MP_POSTAL_CODE(pat_addr.postal1_code,'"+locale+"',2) resi_postal_code_desc,  pat_addr.country1_code resi_country_code, (CASE WHEN pat_addr.country1_code IS NOT NULL THEN (mp_get_desc.mp_country(pat_addr.country1_code,'"+locale+"',1)) END ) resi_country_name, pat_addr.invalid1_yn resi_invalid1_yn, pat_addr.contact1_name resi_contact1_name, patient.res_area_code res_area_code, (CASE WHEN patient.res_area_code IS NOT NULL THEN (mp_get_desc.mp_res_area(patient.res_area_code,'"+locale+"',1)) END ) res_area_long_desc, patient.res_town_code res_town_code, (CASE WHEN patient.res_town_code IS NOT NULL THEN (mp_get_desc.mp_res_town(patient.res_town_code,'"+locale+"',1)) END ) res_town_long_desc, patient.region_code region_code,  (CASE WHEN patient.region_code IS NOT NULL THEN (mp_get_desc.mp_region(patient.region_code,'"+locale+"',1)) END ) region_long_desc, pat_addr.addr2_line1 mail_addr_line1, pat_addr.addr2_line2 mail_addr_line2, pat_addr.addr2_line3 mail_addr_line3, pat_addr.addr2_line4 mail_addr_line4, pat_addr.postal2_code mail_postal_code, mp_get_desc.MP_POSTAL_CODE(pat_addr.postal2_code,'"+locale+"',2) mail_postal_code_desc, pat_addr.country2_code mail_country_code, (CASE WHEN pat_addr.country2_code IS NOT NULL THEN (mp_get_desc.mp_country(pat_addr.country2_code,'"+locale+"',1)) END ) mail_country_name, pat_addr.invalid2_yn mail_invalid1_yn, pat_addr.contact2_name mail_contact1_name, pat_addr.res_area2_code mail_res_area, (CASE WHEN pat_addr.res_area2_code IS NOT NULL THEN (mp_get_desc.mp_res_area(pat_addr.res_area2_code,'"+locale+"',1)) END ) mail_res_area_long_desc, pat_addr.res_town2_code mail_res_town, (CASE WHEN pat_addr.res_town2_code IS NOT NULL THEN (mp_get_desc.mp_res_town(pat_addr.res_town2_code,'"+locale+"',1)) END ) mail_res_town_long_desc, pat_addr.region2_code mail_region_code, (CASE WHEN pat_addr.region2_code IS NOT NULL THEN (mp_get_desc.mp_region(pat_addr.region2_code,'"+locale+"',1)) END ) mail_region_long_desc, patient.contact1_no prn_tel_no, patient.contact2_no orn_tel_no, patient.email_id email_id, patient.contact3_mode contact3_mode, (CASE WHEN patient.contact3_mode IS NOT NULL THEN (mp_get_desc.mp_contact_mode(patient.contact3_mode,'"+locale+"',2)) END ) contact3_mode_desc, patient.contact3_no contact3_no, patient.contact4_mode contact4_mode, (CASE WHEN patient.contact4_mode IS NOT NULL THEN (mp_get_desc.mp_contact_mode(patient.contact4_mode,'"+locale+"',2)) END ) contact4_mode_desc, patient.contact4_no contact4_no, patient.contact5_mode contact5_mode, (CASE WHEN patient.contact5_mode IS NOT NULL THEN (mp_get_desc.mp_contact_mode(patient.contact5_mode,'"+locale+"',2)) END ) contact5_mode_desc, patient.contact5_no contact5_no, pat_rl_con.contact1_name nkin_contact_name, pat_rl_con.job1_title nkin_job_title, pat_rl_con.contact1_relation nkin_contact_relation, (CASE WHEN pat_rl_con.contact1_relation IS NOT NULL THEN (mp_get_desc.mp_relationship(pat_rl_con.contact1_relation,'"+locale+"',2)) END ) nkin_contact_relation_desc, to_char(pat_rl_con.contact1_birth_date, 'dd/mm/yyyy') contact1_birth_date, pat_rl_con.contact1_nat_id_no, pat_rl_con.contact1_alt_id1_type, (CASE WHEN pat_rl_con.contact1_alt_id1_type IS NOT NULL THEN (mp_get_desc.mp_alternate_id_type(pat_rl_con.contact1_alt_id1_type,'"+locale+"',1)) END ) nkin_alt_id1_desc, pat_rl_con.contact1_alt_id1_no, pat_rl_con.contact1_alt_id2_type, (CASE WHEN pat_rl_con.contact1_alt_id2_type IS NOT NULL   THEN (mp_get_desc.mp_alternate_id_type(pat_rl_con.contact1_alt_id2_type,'"+locale+"',1)) END ) nkin_alt_id2_desc, pat_rl_con.contact1_alt_id2_no, pat_rl_con.contact1_alt_id3_type, (CASE WHEN pat_rl_con.contact1_alt_id3_type IS NOT NULL   THEN (mp_get_desc.mp_alternate_id_type(pat_rl_con.contact1_alt_id3_type,'"+locale+"',1)) END ) nkin_alt_id3_desc,           pat_rl_con.contact1_alt_id3_no, pat_rl_con.contact1_alt_id4_type, (CASE WHEN pat_rl_con.contact1_alt_id4_type IS NOT NULL   THEN (mp_get_desc.mp_alternate_id_type(pat_rl_con.contact1_alt_id4_type,'"+locale+"',1)) END ) nkin_alt_id4_desc, pat_rl_con.contact1_alt_id4_no, pat_rl_con.contact1_oth_alt_id_type, (CASE WHEN pat_rl_con.contact1_oth_alt_id_type IS NOT NULL THEN (mp_get_desc.mp_alternate_id_type(pat_rl_con.contact1_oth_alt_id_type,'"+locale+"',1)) END ) nkin_oth_alt_desc, pat_rl_con.contact1_oth_alt_id_no nkin_oth_alt_id_no, pat_rl_con.addr1_line1 nkin_addr_line1,  pat_rl_con.addr1_line2 nkin_addr_line2, pat_rl_con.addr1_line3 nkin_addr_line3, pat_rl_con.addr1_line4 nkin_addr_line4, pat_rl_con.contact1_res_town_code, (CASE WHEN pat_rl_con.contact1_res_town_code IS NOT NULL THEN (mp_get_desc.mp_res_town(pat_rl_con.contact1_res_town_code,'"+locale+"',1)) END ) nkin_town_long_desc, pat_rl_con.contact1_res_area_code, (CASE WHEN pat_rl_con.contact1_res_area_code IS NOT NULL THEN (mp_get_desc.mp_res_area(pat_rl_con.contact1_res_area_code,'"+locale+"',1)) END ) nkin_area_long_desc,           pat_rl_con.contact1_region_code, (CASE WHEN pat_rl_con.contact1_region_code IS NOT NULL THEN (mp_get_desc.mp_region(pat_rl_con.contact1_region_code,'"+locale+"',1)) END ) nkin_region_long_desc, pat_rl_con.postal1_code nkin_postal_code, mp_get_desc.MP_POSTAL_CODE(pat_rl_con.postal1_code,'"+locale+"',2) nkin_postal_code_desc, pat_rl_con.country1_code nkin_country_code, (CASE WHEN pat_rl_con.country1_code IS NOT NULL THEN (mp_get_desc.mp_country(pat_rl_con.country1_code,'"+locale+"',1)) END ) nkin_country_name, pat_rl_con.res1_tel_no nkin_res_tel_no, pat_rl_con.off1_tel_no nkin_off_tel_no, pat_rl_con.contact1_mob_tel_no nkin_mob_tel_no,pat_rl_con.contact1_mob_country_code nkin_mob_country_code , pat_rl_con.contact1_email_id nkin_email_id, pat_rl_con.contact2_relation fton_contact_relation, (CASE WHEN pat_rl_con.contact2_relation IS NOT NULL THEN (mp_get_desc.mp_relationship(pat_rl_con.contact2_relation,'"+locale+"',2)) END ) fton_contact_relation_desc, pat_rl_con.contact2_name fton_contact_name, pat_rl_con.contact2_nat_id_no fton_nat_id_no, pat_rl_con.contact2_oth_alt_id_type, (CASE WHEN pat_rl_con.contact2_oth_alt_id_type IS NOT NULL THEN (mp_get_desc.mp_alternate_id_type(pat_rl_con.contact2_oth_alt_id_type,'"+locale+"',1)) END ) fton_alt_desc,           pat_rl_con.contact2_oth_alt_id_no fton_alt_id_no, pat_rl_con.job2_title fton_job_title, pat_rl_con.addr2_line1 fton_addr_line1, pat_rl_con.addr2_line2 fton_addr_line2, pat_rl_con.addr2_line3 fton_addr_line3, pat_rl_con.addr2_line4 fton_addr_line4, pat_rl_con.contact2_res_town_code, (CASE WHEN pat_rl_con.contact2_res_town_code IS NOT NULL THEN (mp_get_desc.mp_res_town(pat_rl_con.contact2_res_town_code,'"+locale+"',1)) END ) fton_town_long_desc, pat_rl_con.contact2_res_area_code, (CASE WHEN pat_rl_con.contact2_res_area_code IS NOT NULL THEN (mp_get_desc.mp_res_area(pat_rl_con.contact2_res_area_code,'"+locale+"',1)) END ) fton_area_long_desc,           pat_rl_con.contact2_region_code, (CASE WHEN pat_rl_con.contact2_region_code IS NOT NULL THEN (mp_get_desc.mp_region(pat_rl_con.contact2_region_code,'"+locale+"',1)) END ) fton_region_long_desc, pat_rl_con.postal2_code fton_postal_code, mp_get_desc.MP_POSTAL_CODE(pat_rl_con.postal2_code,'"+locale+"',2) fton_postal_code_desc, pat_rl_con.country2_code fton_country_code, (CASE WHEN pat_rl_con.country2_code IS NOT NULL THEN (mp_get_desc.mp_country(pat_rl_con.country2_code,'"+locale+"',1)) END ) fton_country_name, pat_rl_con.contact2_mob_tel_no fton_mob_tel_no, pat_rl_con.contact2_email_id fton_email_id, pat_rl_con.res2_tel_no fton_res_tel_no, pat_rl_con.off2_tel_no fton_off_tel_no, pat_rl_con.organization_name, pat_rl_con.patient_employee_id patient_employee_id, pat_rl_con.employment_status employment_status, pat_rl_con.contact3_name emplr_contact_name, pat_rl_con.job3_title emplr_job_title, pat_rl_con.contact3_relation emplr_contact_relation, (CASE WHEN pat_rl_con.contact3_relation IS NOT NULL THEN (mp_get_desc.mp_relationship(pat_rl_con.contact3_relation,'"+locale+"',2)) END ) emplr_contact_relation_desc,           pat_rl_con.ocpn_class_code, (CASE WHEN pat_rl_con.ocpn_class_code IS NOT NULL THEN (mp_get_desc.mp_occupation_class(pat_rl_con.ocpn_class_code,'"+locale+"',1)) END ) emplr_ocpn_class_desc,           pat_rl_con.ocpn_code ocpn_code, (CASE WHEN pat_rl_con.ocpn_code IS NOT NULL THEN (mp_get_desc.mp_occupation(pat_rl_con.ocpn_code,'"+locale+"',2)) END ) occupation_desc, pat_rl_con.ocpn_desc ocpn_desc, pat_rl_con.addr3_line1 emplr_addr_line1, pat_rl_con.addr3_line2 emplr_addr_line2, pat_rl_con.addr3_line3 emplr_addr_line3,  pat_rl_con.addr3_line4 emplr_addr_line4, pat_rl_con.contact3_res_town_code, (CASE WHEN pat_rl_con.contact3_res_town_code IS NOT NULL THEN (mp_get_desc.mp_res_town(pat_rl_con.contact3_res_town_code,'"+locale+"',1)) END ) emplr_town_long_desc, pat_rl_con.contact3_res_area_code, (CASE WHEN pat_rl_con.contact3_res_area_code IS NOT NULL THEN (mp_get_desc.mp_res_area(pat_rl_con.contact3_res_area_code,'"+locale+"',1)) END ) emplr_area_long_desc,           pat_rl_con.contact3_region_code, (CASE WHEN pat_rl_con.contact3_region_code IS NOT NULL THEN (mp_get_desc.mp_region(pat_rl_con.contact3_region_code,'"+locale+"',1)) END ) emplr_region_long_desc, pat_rl_con.postal3_code emplr_postal_code, mp_get_desc.MP_POSTAL_CODE(pat_rl_con.postal3_code,'"+locale+"',2) emplr_postal_code_desc, pat_rl_con.country3_code emplr_country_code, (CASE WHEN pat_rl_con.country3_code IS NOT NULL THEN (mp_get_desc.mp_country(pat_rl_con.country3_code,'"+locale+"',1)) END ) emplr_country_name, pat_rl_con.off3_tel_no emplr_off_tel_no, pat_rl_con.res3_tel_no emplr_res_tel_no, pat_rl_con.off_fax_no off_fax_no, pat_oth_dtls.living_dependency living_dependency, pat_oth_dtls.living_arrangement living_arrangement, pat_oth_dtls.blood_grp blood_grp, pat_oth_dtls.rh_factor rh_factor, pat_oth_dtls.education_level education_level, (CASE WHEN pat_oth_dtls.education_level IS NOT NULL THEN (mp_get_desc.mp_education_level(pat_oth_dtls.education_level,'"+locale+"',2)) END) educ_level_desc, pat_oth_dtls.regn_informant informant, pat_oth_dtls.regn_comments informant_remarks, pat_oth_dtls.general_remarks general_remarks, patient.suspend_yn suspend_yn,patient.known_allergy_yn known_allergy_yn,patient.eye_indicator eye_indicator,patient.myhix_consent myhix_consent,patient.MYHIX_ID myhix_pat_id,patient.status_reason_code status_reason_code, patient.status_remarks status_remarks, patient.active_yn active_yn, to_char(patient.last_contact_date, 'dd/mm/yyyy') last_contact_date, patient.deceased_yn deceased_yn, to_char(patient.deceased_date, 'dd/mm/yyyy hh24:mi:ss') deceased_date, patient.death_status_remarks death_status_remarks, patient.primary_language_id primary_language_id, pat_oth_dtls.addl_field1 addl_field1, pat_oth_dtls.addl_field2 addl_field2, pat_oth_dtls.addl_field3 addl_field3, pat_oth_dtls.addl_field4 addl_field4, pat_oth_dtls.addl_field5 addl_field5, patient.added_by_id, (CASE WHEN patient.added_by_id IS NOT NULL THEN (sm_get_desc.sm_appl_user(patient.added_by_id,'"+locale+"',1)) END) added_user_name, TO_CHAR(patient.added_date, 'DD/MM/YYYY HH24:MI') added_date, patient.added_at_ws_no, patient.added_facility_id, (CASE WHEN patient.added_facility_id IS NOT NULL THEN (sm_get_desc.sm_facility_param(patient.added_facility_id, '"+locale+"', 1)) END ) added_facility_name, patient.modified_by_id, (CASE WHEN patient.modified_by_id IS NOT NULL THEN (sm_get_desc.sm_appl_user(patient.modified_by_id,'"+locale+"',1)) END ) modified_user_name, TO_CHAR (patient.modified_date, 'DD/MM/YYYY HH24:MI') modified_date, patient.modified_at_ws_no, patient.modified_facility_id, (CASE WHEN patient.modified_facility_id IS NOT NULL THEN (sm_get_desc.sm_facility_param(patient.modified_facility_id, '"+locale+"', 1))END ) modified_facility_name, patient.pat_dtls_unknown_yn, patient.inhouse_birth_yn, patient.data_source data_source, calculate_age_hours(TO_CHAR(DATE_OF_BIRTH,'dd/mm/yyyy hh24:mi:ss'),1) ear, calculate_age_hours(TO_CHAR(DATE_OF_BIRTH,'dd/mm/yyyy hh24:mi:ss'),2) months, calculate_age_hours(TO_CHAR(DATE_OF_BIRTH,'dd/mm/yyyy hh24:mi:ss'),3) days,calculate_age_hours(TO_CHAR(DATE_OF_BIRTH,'dd/mm/yyyy hh24:mi:ss'),4) hours, MP_GET_AGE_YMDH(patient.date_of_birth,patient.deceased_date) p_age, patient.family_org_membership MembershipType, (case when patient.FAMILY_ORG_SUB_ID is not null then ( select FAMILY_ORG_SUB_NAME from MP_FAMILY_ORG_SUB_LANG_VW where FAMILY_ORG_ID = patient.FAMILY_ORG_ID and FAMILY_ORG_SUB_ID = patient.FAMILY_ORG_SUB_ID and language_id = '"+locale+"') end) OrgsubnameDesc, patient.FAMILY_ORG_SUB_ID Orgsubname, (case when patient.FAMILY_ORG_ID is not null then ( select FAMILY_ORG_NAME from MP_FAMILY_ORG_LANG_VW where FAMILY_ORG_ID = patient.FAMILY_ORG_ID and language_id = '"+locale+"') end) Orgname, patient.family_org_id family_org_id, to_char(patient.PAT_CAT_CODE_EXP_DATE,'dd/mm/yyyy') patexpirtydate,patient.language_id language_id , (CASE WHEN patient.language_id IS NOT NULL THEN (mp_get_desc.mp_language(patient.language_id,'"+locale+"',1)) END ) language_desc,patient.combined_rel_level_code combined_rel_level_code , (CASE WHEN patient.combined_rel_level_code IS NOT NULL THEN (mp_get_desc.MP_RELATIONSHIP_LEVEL(patient.combined_rel_level_code,'"+locale+"',1)) END ) combined_rel_level_desc,patient.patient_long_name,patient.patient_long_name_loc_lang,HIJRI_BIRTH_DATE,TO_CHAR(patient.REGN_DATE, 'DD/MM/YYYY HH24:MI') REGN_DATE,patient.form_60_yn,patient.downtime_regn_yn,patient.blood_donor,patient.visa_type,patient.primary_nuhdeek_yn,patient.nuhdeek_ready_yn, patient.household_monthly_income,patient.gcc "); 
		
		// added by mujafar for KDAH-CRF-370.1 start	
			if(chkPanValidate)
			{
				SelectSQLString.append(",patient.PAN_CARD_STATUS,patient.PAN_CARD_HOLDER_NAME,patient.INT_TRANSACTION_ID,patient.PAN_RELATION ");
			}

			//Below line added for this CRF ML-MMOH-CRF-0601 	
	        if(alterAddressApplicable){ 			
				SelectSQLString.append(",pat_addr.alt_addr_line1 alt_addr_line1, pat_addr.alt_addr_line2 alt_addr_line2, pat_addr.alt_addr_line3 alt_addr_line3, pat_addr.alt_addr_line4 alt_addr_line4, pat_addr.alt_postal_code alt_postal_code, mp_get_desc.MP_POSTAL_CODE(pat_addr.alt_postal_code,'"+locale+"',2) alt_postal_code_desc,  pat_addr.alt_country_code alt_country_code, (CASE WHEN pat_addr.alt_country_code IS NOT NULL THEN (mp_get_desc.mp_country(pat_addr.alt_country_code,'"+locale+"',1)) END ) alt_country_name, pat_addr.alt_invalid_yn alt_invalid_yn, pat_addr.alt_contact_name alt_contact_name,pat_addr.alt_area_code alt_area_code, (CASE WHEN pat_addr.alt_area_code IS NOT NULL THEN (mp_get_desc.mp_res_area(pat_addr.alt_area_code,'"+locale+"',1)) END ) alt_area_code_desc, pat_addr.alt_town_code alt_town_code, (CASE WHEN pat_addr.alt_town_code IS NOT NULL THEN (mp_get_desc.mp_res_town(pat_addr.alt_town_code,'"+locale+"',1)) END ) alt_town_code_desc, pat_addr.alt_region_code alt_region_code, (CASE WHEN pat_addr.alt_region_code IS NOT NULL THEN (mp_get_desc.mp_region(pat_addr.alt_region_code,'"+locale+"',1)) END ) alt_region_code_desc");	
	        }			
			//End this ML-MMOH-CRF-0601

			//aadhaar_card_status, aadhaar_trans_id Added by Sethu on 18/01/2018 for KDAH-CRF-0362 [IN063381]
			if(chkAadhaarValidate)
			{
				SelectSQLString.append(", patient.aadhaar_card_status, patient.aadhaar_trans_id ");
			}
            //Below added by Suji Keerthi for ML-MMOH-CRF-1527 US007
            if(aliasnameNationalityRace)
			{
		         SelectSQLString.append(",pat_rl_con.contact1_aliasname nkin_alias_name, pat_rl_con.contact1_nationality rel_nkin_nationality_code, (CASE WHEN pat_rl_con.contact1_nationality IS NOT NULL THEN (mp_get_desc.mp_country(pat_rl_con.contact1_nationality,'"+locale+"',3)) END ) rel_nkin_nationality_desc, pat_rl_con.contact1_race rel_nkin_race_code, (CASE WHEN pat_rl_con.contact1_race IS NOT NULL THEN (mp_get_desc.mp_race(pat_rl_con.contact1_race,'"+locale+"',1)) END ) rel_nkin_race_desc "); //Modified by Suji Keerthi for ML-MMOH-SCF-1922
			}
            //Ended by Suji Keerthi for ML-MMOH-CRF-1527 US007
            //Below added by Suji Keerthi for ML-MMOH-CRF-1527 US008
			if(resiAddMailAdd)
			{
                
				SelectSQLString.append(",pat_rl_con.nk_mail_addr_line1 n_next_addr_line1, pat_rl_con.nk_mail_addr_line2 n_ma_addr_line2, pat_rl_con.nk_mail_addr_line3 n_ma_addr_line3, pat_rl_con.nk_mail_addr_line4 n_ma_addr_line4, pat_rl_con.nk_mail_postal_code n_ma_postal_code, mp_get_desc.MP_POSTAL_CODE(pat_rl_con.nk_mail_postal_code,'"+locale+"',2) rl_nk_postal_code, pat_rl_con.nk_mail_area_code n_contact_ma_area_code, (CASE WHEN pat_rl_con.nk_mail_area_code IS NOT NULL THEN (mp_get_desc.mp_res_area(pat_rl_con.nk_mail_area_code,'"+locale+"',1)) END ) rl_nk_area_desc, pat_rl_con.nk_mail_town_code n_contact_ma_town_code, (CASE WHEN pat_rl_con.nk_mail_town_code IS NOT NULL THEN (mp_get_desc.mp_res_town(pat_rl_con.nk_mail_town_code,'"+locale+"',1)) END ) rl_nk_town_desc, pat_rl_con.nk_mail_region_code n_contac_region_code, (CASE WHEN pat_rl_con.nk_mail_region_code IS NOT NULL THEN (mp_get_desc.mp_region(pat_rl_con.nk_mail_region_code,'"+locale+"',1)) END ) rl_nk_region_desc,pat_rl_con.nk_mail_country_code nkin_m_country_desc, (CASE WHEN pat_rl_con.nk_mail_country_code IS NOT NULL THEN (mp_get_desc.mp_country(pat_rl_con.nk_mail_country_code,'"+locale+"',1)) END ) nk_mail_country_desc,pat_rl_con.nk_res_contact_name resadd_contact_name,pat_rl_con.nk_mail_contact_name mailadd_contact_name");

				SelectSQLString.append(" ,pat_rl_con.nk_contact3_mode nk_contact3_mode, (CASE WHEN pat_rl_con.nk_contact3_mode IS NOT NULL THEN (mp_get_desc.mp_contact_mode(pat_rl_con.nk_contact3_mode,'"+locale+"',2)) END ) nk_contact3_mode_desc, pat_rl_con.nk_contact3_no nk_contact3_no, pat_rl_con.nk_contact4_mode nk_contact4_mode, (CASE WHEN pat_rl_con.nk_contact4_mode IS NOT NULL THEN (mp_get_desc.mp_contact_mode(pat_rl_con.nk_contact4_mode,'"+locale+"',2)) END ) nk_contact4_mode_desc, pat_rl_con.nk_contact4_no nk_contact4_no, pat_rl_con.nk_contact5_mode nk_contact5_mode, (CASE WHEN pat_rl_con.nk_contact5_mode IS NOT NULL THEN (mp_get_desc.mp_contact_mode(pat_rl_con.nk_contact5_mode,'"+locale+"',2)) END ) nk_contact5_mode_desc, pat_rl_con.nk_contact5_no nk_contact5_no ");

				SelectSQLString.append(",pat_rl_con.fton_mail_addr_line1 fton_mail_addr_line1, pat_rl_con.fton_mail_addr_line2 fton_mail_addr_line2, pat_rl_con.fton_mail_addr_line3 fton_mail_addr_line3, pat_rl_con.fton_mail_addr_line4 fton_mail_addr_line4, pat_rl_con.fton_mail_postal_code fst_no_ma_pos_cod, mp_get_desc.MP_POSTAL_CODE(pat_rl_con.fton_mail_postal_code,'"+locale+"',2) rl_fton_postal_code, pat_rl_con.fton_mail_area_code fst_to_no_ma_area_code, (CASE WHEN pat_rl_con.fton_mail_area_code IS NOT NULL THEN (mp_get_desc.mp_res_area(pat_rl_con.fton_mail_area_code,'"+locale+"',1)) END ) rl_fton_area_desc, pat_rl_con.fton_mail_town_code fst_to_no_ma_town_code, (CASE WHEN pat_rl_con.fton_mail_town_code IS NOT NULL THEN (mp_get_desc.mp_res_town(pat_rl_con.fton_mail_town_code,'"+locale+"',1)) END ) rl_fton_town_desc, pat_rl_con.fton_mail_region_code fst_to_no_ma_reg_cod, (CASE WHEN pat_rl_con.fton_mail_region_code IS NOT NULL THEN (mp_get_desc.mp_region(pat_rl_con.fton_mail_region_code,'"+locale+"',1)) END ) rl_fton_region_desc,pat_rl_con.fton_mail_country_code fton_m_country_desc, (CASE WHEN pat_rl_con.fton_mail_country_code IS NOT NULL THEN (mp_get_desc.mp_country(pat_rl_con.fton_mail_country_code,'"+locale+"',1)) END ) fton_mail_country_desc,pat_rl_con.fton_res_contact_name fton_resadd_contact_name,pat_rl_con.fton_mail_contact_name fton_mailadd_contact_name ");

				SelectSQLString.append(" ,pat_rl_con.fton_contact3_mode fton_contact3_mode, (CASE WHEN pat_rl_con.fton_contact3_mode IS NOT NULL THEN (mp_get_desc.mp_contact_mode(pat_rl_con.fton_contact3_mode,'"+locale+"',2)) END ) fton_contact3_mode_desc, pat_rl_con.fton_contact3_no fton_contact3_no, pat_rl_con.fton_contact4_mode fton_contact4_mode, (CASE WHEN pat_rl_con.fton_contact4_mode IS NOT NULL THEN (mp_get_desc.mp_contact_mode(pat_rl_con.fton_contact4_mode,'"+locale+"',2)) END ) fton_contact4_mode_desc, pat_rl_con.fton_contact4_no fton_contact4_no, pat_rl_con.fton_contact5_mode fton_contact5_mode, (CASE WHEN pat_rl_con.fton_contact5_mode IS NOT NULL THEN (mp_get_desc.mp_contact_mode(pat_rl_con.fton_contact5_mode,'"+locale+"',2)) END ) fton_contact5_mode_desc, pat_rl_con.fton_contact5_no fton_contact5_no ");
			}
			 //Ended by Suji Keerthi for ML-MMOH-CRF-1527 US008

			if(isVirtualConsultation){
					SelectSQLString.append(" ,patient.contact2_country_code ");
			}
			//Maheshwaran K added for MO-CRF-20183.2 as on 08-05-2023
			if(isPractEmployeeServiceNumber)
				{
				SelectSQLString.append(" ,patient.employee_service_no ");	
				}

			SelectSQLString.append(" FROM mp_patient patient, mp_pat_addresses pat_addr, mp_pat_rel_contacts pat_rl_con, mp_pat_oth_dtls pat_oth_dtls, mp_pat_ser_grp pat_ser_grp WHERE patient.patient_id = pat_addr.patient_id(+) AND patient.patient_id = pat_rl_con.patient_id(+) AND patient.patient_id = pat_oth_dtls.patient_id(+) AND patient.pat_ser_grp_code = pat_ser_grp.pat_ser_grp_code AND patient.patient_id =? ");
			// added by mujafar for KDAH-CRF-370.1 end
			//Above query modified for this CRF  GDOH-CRF-0029 [IN:048764]
			//patient.form_60_yn Added by Dharma on 25th Jan 2016 for KDAH-CRF-0331 [IN058799]
			
			
			pstmt1	= con.prepareStatement(SelectSQLString.toString());
			pstmt1.setString(1,patient_id); 
			rs33	= pstmt1.executeQuery();
			if(rs33 != null && rs33.next()) { 
				
				hashMap1.put("pat_dtls_unknown_yn",	 checkForNull(rs33.getString("pat_dtls_unknown_yn"),"N"));
				hashMap1.put("pat_name_in_loc_lang_reqd_yn",rs33.getString("pat_name_in_loc_lang_reqd_yn"));
				hashMap1.put("addl_field1",				rs33.getString("addl_field1"));
				hashMap1.put("addl_field2",				rs33.getString("addl_field2"));
				hashMap1.put("addl_field3",				rs33.getString("addl_field3"));
				hashMap1.put("addl_field4",				rs33.getString("addl_field4"));
				hashMap1.put("addl_field5",				rs33.getString("addl_field5"));
				hashMap1.put("head_patient_name",	checkForNull(rs33.getString("head_patient_name")));
				hashMap1.put("oth_alt_id_type",			checkForNull(rs33.getString("oth_alt_id_type")));
				hashMap1.put("demo_oth_alt_id_no",	checkForNull(rs33.getString("DEMO_OTH_ALT_ID_NO")));
				hashMap1.put("pat_ser_grp_code",		checkForNull(rs33.getString("PAT_SER_GRP_CODE")));
				hashMap1.put("pat_ser_grp_desc",		checkForNull(rs33.getString("PAT_SER_GRP_DESC")));
				hashMap1.put("pref_facility_id",			checkForNull(rs33.getString("PREF_FACILITY_ID")));
				hashMap1.put("pref_facility_name",			checkForNull(rs33.getString("pref_facility_name")));
				hashMap1.put("id_type",					rs33.getString("id_type"));
				hashMap1.put("nationality",				checkForNull(rs33.getString("NATIONALITY_DESC")));
				hashMap1.put("national_id_no",			checkForNull(rs33.getString("NATIONAL_ID_NO")));
				hashMap1.put("national_id_no_dft",			checkForNull(rs33.getString("national_id_no_dft")));		//Added national_id_no_dft for AAKH-CRF-0168		
				hashMap1.put("nat_id_expiry_date",			checkForNull(rs33.getString("NAT_ID_EXPIRY_DATE")));
				hashMap1.put("data_source",				checkForNull(rs33.getString("DATA_SOURCE")));
				hashMap1.put("alt_id1_no",				checkForNull(rs33.getString("ALT_ID1_NO")));
				hashMap1.put("alt_id1_type",				checkForNull(rs33.getString("ALT_ID1_TYPE")));
				hashMap1.put("alt_id1_exp_date",		checkForNull(rs33.getString("ALT_ID1_EXP_DATE")));
				hashMap1.put("alt_id2_no",  				checkForNull(rs33.getString("ALT_ID2_NO")));
				hashMap1.put("alt_id2_type",  			checkForNull(rs33.getString("ALT_ID2_TYPE")));
				hashMap1.put("alt_id2_exp_date",		checkForNull(rs33.getString("ALT_ID2_EXP_DATE")));
				hashMap1.put("alt_id3_no",				checkForNull(rs33.getString("ALT_ID3_NO")));
				hashMap1.put("alt_id3_type",				checkForNull(rs33.getString("ALT_ID3_TYPE")));
				hashMap1.put("alt_id3_exp_date",		checkForNull(rs33.getString("ALT_ID3_EXP_DATE")));
				hashMap1.put("alt_id4_no" , 				checkForNull(rs33.getString("ALT_ID4_NO")));
				hashMap1.put("alt_id4_type",				checkForNull(rs33.getString("ALT_ID4_TYPE")));
				hashMap1.put("alt_id4_exp_date",		checkForNull(rs33.getString("ALT_ID4_EXP_DATE")));
				hashMap1.put("family_link_no", 			checkForNull(rs33.getString("FAMILY_LINK_NO")));
				hashMap1.put("relationship_to_head",	checkForNull(rs33.getString("RELATIONSHIP_TO_HEAD")));
				hashMap1.put("relationship_name",	checkForNull(rs33.getString("relationship_name")));
				hashMap1.put("name_prefix",				checkForNull(rs33.getString("NAME_PREFIX")));
				hashMap1.put("first_name",				checkForNull(rs33.getString("FIRST_NAME")));
				hashMap1.put("second_name",			checkForNull(rs33.getString("SECOND_NAME")));
				hashMap1.put("third_name",				checkForNull(rs33.getString("THIRD_NAME")));
				hashMap1.put("family_name",				checkForNull(rs33.getString("FAMILY_NAME")));
				hashMap1.put("name_suffix",				checkForNull(rs33.getString("NAME_SUFFIX")));
				hashMap1.put("name_suffix_loc_lang",	checkForNull(rs33.getString("name_suffix_loc_lang")));
				hashMap1.put("first_name_loc_lang",	checkForNull(rs33.getString("first_name_loc_lang")));
				hashMap1.put("second_name_loc_lang",checkForNull(rs33.getString("second_name_loc_lang")));
				hashMap1.put("third_name_loc_lang",	checkForNull(rs33.getString("third_name_loc_lang")));
				hashMap1.put("family_name_loc_lang",	checkForNull(rs33.getString("family_name_loc_lang")));
				hashMap1.put("name_prefix_loc_lang",	checkForNull(rs33.getString("name_prefix_loc_lang")));
				hashMap1.put("sex",							checkForNull(rs33.getString("SEX")));
				hashMap1.put("ear",							checkForNull(rs33.getString("EAR")));
				hashMap1.put("months",					checkForNull(rs33.getString("MONTHS")));
				hashMap1.put("days",						checkForNull(rs33.getString("DAYS")));
				hashMap1.put("hours",						checkForNull(rs33.getString("hours")));
				hashMap1.put("p_age",						checkForNull(rs33.getString("p_age")));
				hashMap1.put("date_of_birth",			checkForNull(rs33.getString("DATE_OF_BIRTH")));
				hashMap1.put("calculated_age_yn",			checkForNull(rs33.getString("calculated_age_yn"),"N"));
				hashMap1.put("birth_place_desc",		checkForNull(rs33.getString("birth_place_desc")));
				hashMap1.put("birth_place_code",		checkForNull(rs33.getString("birth_place_code")));
				hashMap1.put("place_of_birth",			checkForNull(rs33.getString("place_of_birth")));
				hashMap1.put("mar_status_code",		checkForNull(rs33.getString("MAR_STATUS_CODE")));
				hashMap1.put("mar_status_desc",		checkForNull(rs33.getString("mar_status_desc")));
				hashMap1.put("citizen_yn",				checkForNull(rs33.getString("citizen_yn")));
				hashMap1.put("legal_yn",					checkForNull(rs33.getString("legal_yn")));
				hashMap1.put("pat_cat_code",			checkForNull(rs33.getString("PAT_CAT_CODE")));
				hashMap1.put("pat_cat_desc",			checkForNull(rs33.getString("pat_cat_desc")));
				hashMap1.put("nationality_desc",		checkForNull(rs33.getString("NATIONALITY_DESC")));
				hashMap1.put("nationality_code",		checkForNull(rs33.getString("NATIONALITY_CODE")));
				hashMap1.put("race_code",				checkForNull(rs33.getString("race_code")));
				hashMap1.put("ethnic_grp_code",		checkForNull(rs33.getString("ethnic_grp_code")));
				hashMap1.put("ethnic_long_desc",		checkForNull(rs33.getString("ethnic_long_desc")));
				hashMap1.put("relgn_code",				checkForNull(rs33.getString("RELGN_CODE")));
				hashMap1.put("relgn_desc",				checkForNull(rs33.getString("relgn_desc")));
				hashMap1.put("alias_name",				checkForNull(rs33.getString("ALIAS_NAME")));
				hashMap1.put("household_monthly_income",checkForNull(rs33.getString("household_monthly_income"))); //Added by Suji Keerthi for ML-MMOH-CRF-1527
				hashMap1.put("gcc",				checkForNull(rs33.getString("gcc")));//Maheshwaran K added for AAKH-CRF-0168 as on 22-10-2022
				hashMap1.put("resi_postal_code",		checkForNull(rs33.getString("RESI_POSTAL_CODE")));
				hashMap1.put("resi_postal_code_desc",		checkForNull(rs33.getString("resi_postal_code_desc")));
				hashMap1.put("mail_postal_code",		checkForNull(rs33.getString("MAIL_POSTAL_CODE")));
				hashMap1.put("mail_postal_code_desc",		checkForNull(rs33.getString("mail_postal_code_desc")));
				hashMap1.put("nextpostalcode",			checkForNull(rs33.getString("nkin_postal_code")));
				hashMap1.put("nextpostalcode_desc",			checkForNull(rs33.getString("nkin_postal_code_desc")));
				hashMap1.put("firstpostalcode",			checkForNull(rs33.getString("FTON_POSTAL_CODE")));
				hashMap1.put("firstpostalcode_desc",			checkForNull(rs33.getString("fton_postal_code_desc")));
				hashMap1.put("resi_country_name",		checkForNull(rs33.getString("RESI_COUNTRY_NAME")));
				hashMap1.put("resi_country_code",		checkForNull(rs33.getString("RESI_COUNTRY_CODE")));
				hashMap1.put("mail_country_name",	checkForNull(rs33.getString("MAIL_COUNTRY_NAME")));
				hashMap1.put("mail_country_code",		checkForNull(rs33.getString("MAIL_COUNTRY_CODE")));
				hashMap1.put("resi_invalid1_yn",			checkForNull(rs33.getString("RESI_INVALID1_YN")));
				hashMap1.put("mail_invalid1_yn",		checkForNull(rs33.getString("MAIL_INVALID1_YN")));
				hashMap1.put("resi_contact1_name",	checkForNull(rs33.getString("RESI_CONTACT1_NAME")));
				hashMap1.put("mail_contact1_name",	checkForNull(rs33.getString("MAIL_CONTACT1_NAME")));
				hashMap1.put("prn_tel_no",				checkForNull(rs33.getString("PRN_TEL_NO")));
				hashMap1.put("orn_tel_no",				checkForNull( rs33.getString("ORN_TEL_NO")));
				hashMap1.put("email_id",					checkForNull(rs33.getString("EMAIL_ID")));
				hashMap1.put("contact3_mode",			checkForNull(rs33.getString("CONTACT3_MODE")));
				hashMap1.put("contact3_no",				checkForNull(rs33.getString("CONTACT3_NO")));
				hashMap1.put("contact4_mode",			checkForNull(rs33.getString("CONTACT4_MODE")));
				hashMap1.put("contact4_no",				checkForNull(rs33.getString("CONTACT4_NO")));
				hashMap1.put("contact5_mode",			checkForNull(rs33.getString("CONTACT5_MODE")));
				hashMap1.put("contact5_no",				checkForNull(rs33.getString("CONTACT5_NO")));
				hashMap1.put("nkin_contact_name",		checkForNull(rs33.getString("nkin_contact_name")));
				//Below Added by Suji Keerthi for ML-MMOH-CRF-1527 US007
				if(aliasnameNationalityRace){
				hashMap1.put("nkin_alias_name",		    checkForNull(rs33.getString("nkin_alias_name")));
				hashMap1.put("rel_nkin_nationality_code",		    checkForNull(rs33.getString("rel_nkin_nationality_code")));
				hashMap1.put("rel_nkin_nationality_desc",		    checkForNull(rs33.getString("rel_nkin_nationality_desc")));
				hashMap1.put("rel_nkin_race_code",		    checkForNull(rs33.getString("rel_nkin_race_code")));
				hashMap1.put("rel_nkin_race_desc",		    checkForNull(rs33.getString("rel_nkin_race_desc")));
				}
				//Ended by Suji Keerthi for ML-MMOH-CRF-1527 US007
				//Below Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
				if(resiAddMailAdd)
				{
				hashMap1.put("n_next_addr_line1",		    checkForNull(rs33.getString("n_next_addr_line1")));
				hashMap1.put("n_ma_addr_line2",		    checkForNull(rs33.getString("n_ma_addr_line2")));
                hashMap1.put("n_ma_addr_line3",		    checkForNull(rs33.getString("n_ma_addr_line3")));
				hashMap1.put("n_ma_addr_line4",		    checkForNull(rs33.getString("n_ma_addr_line4")));
				hashMap1.put("n_contact_ma_town_code",		    checkForNull(rs33.getString("n_contact_ma_town_code")));
				hashMap1.put("rl_nk_town_desc",		    checkForNull(rs33.getString("rl_nk_town_desc")));
				hashMap1.put("n_contac_region_code",		    checkForNull(rs33.getString("n_contac_region_code")));
				hashMap1.put("rl_nk_region_desc",		    checkForNull(rs33.getString("rl_nk_region_desc")));
				hashMap1.put("n_contact_ma_area_code",		    checkForNull(rs33.getString("n_contact_ma_area_code")));
				hashMap1.put("rl_nk_area_desc",		    checkForNull(rs33.getString("rl_nk_area_desc")));
				hashMap1.put("n_ma_postal_code",		    checkForNull(rs33.getString("n_ma_postal_code")));
				hashMap1.put("rl_nk_postal_code",		    checkForNull(rs33.getString("rl_nk_postal_code")));
				hashMap1.put("nk_mail_country_desc",		    checkForNull(rs33.getString("nk_mail_country_desc")));
				hashMap1.put("nkin_m_country_desc",		    checkForNull(rs33.getString("nkin_m_country_desc")));
				hashMap1.put("resadd_contact_name",		    checkForNull(rs33.getString("resadd_contact_name")));
				hashMap1.put("mailadd_contact_name",		    checkForNull(rs33.getString("mailadd_contact_name")));
				hashMap1.put("nk_contact3_mode",			checkForNull(rs33.getString("nk_contact3_mode")));
				hashMap1.put("nk_contact3_no",				checkForNull(rs33.getString("nk_contact3_no")));
				hashMap1.put("nk_contact4_mode",			checkForNull(rs33.getString("nk_contact4_mode")));
				hashMap1.put("nk_contact4_no",				checkForNull(rs33.getString("nk_contact4_no")));
				hashMap1.put("nk_contact5_mode",			checkForNull(rs33.getString("nk_contact5_mode")));
				hashMap1.put("nk_contact5_no",				checkForNull(rs33.getString("nk_contact5_no")));

				hashMap1.put("fton_mail_addr_line1",		    checkForNull(rs33.getString("fton_mail_addr_line1")));
				hashMap1.put("fton_mail_addr_line2",		    checkForNull(rs33.getString("fton_mail_addr_line2")));
                hashMap1.put("fton_mail_addr_line3",		    checkForNull(rs33.getString("fton_mail_addr_line3")));
				hashMap1.put("fton_mail_addr_line4",		    checkForNull(rs33.getString("fton_mail_addr_line4")));
				hashMap1.put("fst_to_no_ma_town_code",		    checkForNull(rs33.getString("fst_to_no_ma_town_code")));
				hashMap1.put("rl_fton_town_desc",		    checkForNull(rs33.getString("rl_fton_town_desc")));
				hashMap1.put("fst_to_no_ma_reg_cod",		    checkForNull(rs33.getString("fst_to_no_ma_reg_cod")));
				hashMap1.put("rl_fton_region_desc",		    checkForNull(rs33.getString("rl_fton_region_desc")));
				hashMap1.put("fst_to_no_ma_area_code",		    checkForNull(rs33.getString("fst_to_no_ma_area_code")));
				hashMap1.put("rl_fton_area_desc",		    checkForNull(rs33.getString("rl_fton_area_desc")));
				hashMap1.put("fst_no_ma_pos_cod",		    checkForNull(rs33.getString("fst_no_ma_pos_cod")));
				hashMap1.put("rl_fton_postal_code",		    checkForNull(rs33.getString("rl_fton_postal_code")));
				hashMap1.put("fton_mail_country_desc",		    checkForNull(rs33.getString("fton_mail_country_desc")));
				hashMap1.put("fton_m_country_desc",		    checkForNull(rs33.getString("fton_m_country_desc")));
				hashMap1.put("fton_resadd_contact_name",		    checkForNull(rs33.getString("fton_resadd_contact_name")));
				hashMap1.put("fton_mailadd_contact_name",		    checkForNull(rs33.getString("fton_mailadd_contact_name")));
				hashMap1.put("fton_contact3_mode",			checkForNull(rs33.getString("fton_contact3_mode")));
				hashMap1.put("fton_contact3_no",				checkForNull(rs33.getString("fton_contact3_no")));
				hashMap1.put("fton_contact4_mode",			checkForNull(rs33.getString("fton_contact4_mode")));
				hashMap1.put("fton_contact4_no",				checkForNull(rs33.getString("fton_contact4_no")));
				hashMap1.put("fton_contact5_mode",			checkForNull(rs33.getString("fton_contact5_mode")));
				hashMap1.put("fton_contact5_no",				checkForNull(rs33.getString("fton_contact5_no")));
				}
                //Ended by Suji Keerthi for ML-MMOH-CRF-1527 US008
				hashMap1.put("nkin_contact_relation",		checkForNull(rs33.getString("nkin_contact_relation")));
				hashMap1.put("nkin_contact_relation_desc",checkForNull(rs33.getString("nkin_contact_relation_desc")));
				hashMap1.put("contact1_nat_id_no",		checkForNull(rs33.getString("contact1_nat_id_no")));
				hashMap1.put("nkin_alt_id1_desc",			checkForNull(rs33.getString("nkin_alt_id1_desc")));
				hashMap1.put("contact1_alt_id1_type",	checkForNull(rs33.getString("contact1_alt_id1_type")));
				hashMap1.put("contact1_alt_id1_no",		checkForNull(rs33.getString("contact1_alt_id1_no")));
				hashMap1.put("nkin_alt_id2_desc",			checkForNull(rs33.getString("nkin_alt_id2_desc")));
				hashMap1.put("contact1_alt_id2_type",	checkForNull(rs33.getString("contact1_alt_id2_type")));
				hashMap1.put("contact1_alt_id2_no",		checkForNull(rs33.getString("contact1_alt_id2_no")));
				hashMap1.put("nkin_alt_id3_desc",			checkForNull(rs33.getString("nkin_alt_id3_desc")));
				hashMap1.put("contact1_alt_id3_type",	checkForNull(rs33.getString("contact1_alt_id3_type")));
				hashMap1.put("contact1_alt_id3_no",		checkForNull(rs33.getString("contact1_alt_id3_no")));
				hashMap1.put("nkin_alt_id4_desc",			checkForNull(rs33.getString("nkin_alt_id4_desc")));
				hashMap1.put("contact1_alt_id4_type",	checkForNull(rs33.getString("contact1_alt_id4_type")));
				hashMap1.put("contact1_alt_id4_no",		checkForNull(rs33.getString("contact1_alt_id4_no")));
				hashMap1.put("contact1_oth_alt_id_type",checkForNull(rs33.getString("contact1_oth_alt_id_type")));
				hashMap1.put("nkin_oth_alt_id_no",			checkForNull(rs33.getString("nkin_oth_alt_id_no")));
				hashMap1.put("contact1_birth_date",		checkForNull(rs33.getString("contact1_birth_date")));
				hashMap1.put("nkin_job_title",				checkForNull(rs33.getString("nkin_job_title")));
				hashMap1.put("nkin_country_name",		checkForNull(rs33.getString("NKIN_COUNTRY_NAME")));
				hashMap1.put("nkin_country_code",			checkForNull(rs33.getString("NKIN_COUNTRY_CODE")));
				hashMap1.put("nkin_res_tel_no",				checkForNull(rs33.getString("nkin_res_tel_no")));
				hashMap1.put("nkin_mob_tel_no",			checkForNull(rs33.getString("nkin_mob_tel_no")));
				hashMap1.put("nkin_mob_country_code",			checkForNull(rs33.getString("nkin_mob_country_code")));
				hashMap1.put("nkin_off_tel_no",				checkForNull(rs33.getString("nkin_off_tel_no")));
				hashMap1.put("nkin_email_id",				checkForNull(rs33.getString("nkin_email_id")));
				hashMap1.put("fton_contact_name",		checkForNull(rs33.getString("fton_contact_name")));
				hashMap1.put("fton_contact_relation",		checkForNull(rs33.getString("fton_contact_relation")));
				hashMap1.put("fton_contact_relation_desc",checkForNull(rs33.getString("fton_contact_relation_desc")));
				hashMap1.put("fton_nat_id_no",				checkForNull(rs33.getString("fton_nat_id_no")));
				hashMap1.put("contact2_oth_alt_id_type",checkForNull(rs33.getString("contact2_oth_alt_id_type")));
				hashMap1.put("fton_alt_id_no",				checkForNull(rs33.getString("fton_alt_id_no")));
				hashMap1.put("fton_job_title",				checkForNull(rs33.getString("fton_job_title")));
				hashMap1.put("fton_country_name",		checkForNull(rs33.getString("FTON_COUNTRY_NAME")));
				hashMap1.put("fton_country_code",		checkForNull(rs33.getString("FTON_COUNTRY_CODE")));
				hashMap1.put("fton_res_tel_no",				checkForNull(rs33.getString("fton_res_tel_no")));
				hashMap1.put("fton_mob_tel_no",			checkForNull(rs33.getString("fton_mob_tel_no")));
				hashMap1.put("fton_off_tel_no",				checkForNull(rs33.getString("fton_off_tel_no")));
				hashMap1.put("fton_email_id",				checkForNull(rs33.getString("fton_email_id")));
				hashMap1.put("organization_name",			checkForNull(rs33.getString("organization_name")));
				hashMap1.put("emplr_contact_name",		checkForNull(rs33.getString("emplr_contact_name")));
				hashMap1.put("emplr_country_name",		checkForNull(rs33.getString("EMPLR_COUNTRY_NAME")));
				hashMap1.put("emplr_country_code",		checkForNull(rs33.getString("EMPLR_COUNTRY_CODE")));
				hashMap1.put("emplr_res_tel_no",			checkForNull(rs33.getString("emplr_res_tel_no")));
				hashMap1.put("emplr_off_tel_no",			checkForNull(rs33.getString("emplr_off_tel_no")));
				hashMap1.put("patient_employee_id",		checkForNull(rs33.getString("patient_employee_id")));
				hashMap1.put("ocpn_class_code",			checkForNull(rs33.getString("ocpn_class_code")));
				hashMap1.put("emplr_ocpn_class_desc",	checkForNull(rs33.getString("emplr_ocpn_class_desc")));
				hashMap1.put("ocpn_code",					checkForNull(rs33.getString("ocpn_code")));
				hashMap1.put("occupation_desc",			checkForNull(rs33.getString("occupation_desc")));
				hashMap1.put("ocpn_desc",					checkForNull(rs33.getString("ocpn_desc")));
				hashMap1.put("employment_status",		checkForNull(rs33.getString("employment_status"))); 
				hashMap1.put("elevel",							checkForNull(rs33.getString("EDUCATION_LEVEL")));
				hashMap1.put("educ_level_desc",					checkForNull(rs33.getString("educ_level_desc")));
				hashMap1.put("informant",						checkForNull(rs33.getString("INFORMANT")));
				hashMap1.put("comments",					checkForNull(rs33.getString("INFORMANT_REMARKS")));
				hashMap1.put("gremarks",						checkForNull(rs33.getString("GENERAL_REMARKS")));
				hashMap1.put("living_dependency",			checkForNull(rs33.getString("LIVING_DEPENDENCY")));
				hashMap1.put("arrangement",					checkForNull(rs33.getString("LIVING_ARRANGEMENT")));
				hashMap1.put("added_user_name",			checkForNull(rs33.getString("ADDED_USER_NAME")));
				hashMap1.put("modified_user_name",		checkForNull(rs33.getString("MODIFIED_USER_NAME")));
				hashMap1.put("added_date",					checkForNull(rs33.getString("ADDED_DATE")));
				hashMap1.put("modified_date",				checkForNull(rs33.getString("MODIFIED_DATE")));
				hashMap1.put("added_at_ws_no",			checkForNull(rs33.getString("ADDED_AT_WS_NO")));
				hashMap1.put("modified_at_ws_no",		checkForNull(rs33.getString("MODIFIED_AT_WS_NO")));
				hashMap1.put("added_facility_name",		checkForNull(rs33.getString("ADDED_FACILITY_NAME")));
				hashMap1.put("modified_facility_name",	checkForNull(rs33.getString("MODIFIED_FACILITY_NAME")));
				hashMap1.put("patient_name",				checkForNull(rs33.getString("PATIENT_NAME")));
				hashMap1.put("patient_name_loc_lang",	rs33.getString("patient_name_loc_lang"));
				hashMap1.put("resi_addr_line1",				checkForNull(rs33.getString("RESI_ADDR_LINE1")));
				hashMap1.put("mail_addr_line1",				checkForNull(rs33.getString("MAIL_ADDR_LINE1")));
				hashMap1.put("resi_addr_line2",				checkForNull(rs33.getString("RESI_ADDR_LINE2")));
				hashMap1.put("mail_addr_line2",				checkForNull(rs33.getString("MAIL_ADDR_LINE2")));
				hashMap1.put("resi_addr_line3",				checkForNull(rs33.getString("RESI_ADDR_LINE3")));
				hashMap1.put("mail_addr_line3",				checkForNull(rs33.getString("MAIL_ADDR_LINE3")));
				hashMap1.put("resi_addr_line4",				checkForNull(rs33.getString("RESI_ADDR_LINE4")));
				hashMap1.put("mail_addr_line4",				checkForNull(rs33.getString("MAIL_ADDR_LINE4")));
				hashMap1.put("nkin_addr_line1",				checkForNull(rs33.getString("NKIN_ADDR_LINE1")));
				hashMap1.put("fton_addr_line1",				checkForNull(rs33.getString("FTON_ADDR_LINE1")));
				hashMap1.put("nkin_addr_line2",				checkForNull(rs33.getString("NKIN_ADDR_LINE2")));
				hashMap1.put("fton_addr_line2",				checkForNull(rs33.getString("FTON_ADDR_LINE2")));
				hashMap1.put("nkin_addr_line3",				checkForNull(rs33.getString("NKIN_ADDR_LINE3")));
				hashMap1.put("fton_addr_line3",				checkForNull(rs33.getString("FTON_ADDR_LINE3")));
				hashMap1.put("nkin_addr_line4",				checkForNull(rs33.getString("NKIN_ADDR_LINE4")));
				hashMap1.put("fton_addr_line4",				checkForNull(rs33.getString("FTON_ADDR_LINE4")));
				hashMap1.put("emplr_addr_line1",			checkForNull(rs33.getString("EMPLR_ADDR_LINE1")));
				hashMap1.put("emplr_addr_line2",			checkForNull(rs33.getString("EMPLR_ADDR_LINE2")));
				hashMap1.put("emplr_addr_line3",			checkForNull(rs33.getString("EMPLR_ADDR_LINE3")));
				hashMap1.put("emplr_addr_line4",			checkForNull(rs33.getString("EMPLR_ADDR_LINE4")));
				hashMap1.put("emplr_postal_code",			checkForNull(rs33.getString("EMPLR_POSTAL_CODE")));
				hashMap1.put("emplr_postal_code_desc",			checkForNull(rs33.getString("emplr_postal_code_desc")));
				hashMap1.put("res_town_long_desc",		checkForNull(rs33.getString("RES_TOWN_LONG_DESC")));
				hashMap1.put("res_town_code",				checkForNull(rs33.getString("RES_TOWN_CODE")));
				hashMap1.put("res_area_long_desc",		checkForNull(rs33.getString("RES_AREA_LONG_DESC")));
				hashMap1.put("res_area_code",				checkForNull(rs33.getString("RES_AREA_CODE")));
				hashMap1.put("region_long_desc",			checkForNull(rs33.getString("REGION_LONG_DESC")));
				hashMap1.put("region_code",					checkForNull(rs33.getString("REGION_CODE")));
				hashMap1.put("deceased_yn",				checkForNull(rs33.getString("DECEASED_YN"), "N"));
				hashMap1.put("mail_res_town_long_desc",checkForNull(rs33.getString("MAIL_RES_TOWN_LONG_DESC")));
				hashMap1.put("mail_res_town",				checkForNull(rs33.getString("MAIL_RES_TOWN")));
				hashMap1.put("mail_res_area_long_desc",checkForNull(rs33.getString("MAIL_RES_AREA_LONG_DESC")));
				hashMap1.put("mail_res_area",				checkForNull(rs33.getString("MAIL_RES_AREA")));
				hashMap1.put("mail_region_long_desc",	checkForNull(rs33.getString("MAIL_REGION_LONG_DESC")));
				hashMap1.put("mail_region_code",			checkForNull(rs33.getString("MAIL_REGION_CODE")));
				hashMap1.put("nkin_town_long_desc",		checkForNull(rs33.getString("NKIN_TOWN_LONG_DESC")));
				hashMap1.put("contact1_res_town_code",checkForNull(rs33.getString("CONTACT1_RES_TOWN_CODE")));
				hashMap1.put("nkin_area_long_desc",		checkForNull(rs33.getString("nkin_area_long_desc")));
				hashMap1.put("contact1_res_area_code",checkForNull(rs33.getString("CONTACT1_RES_AREA_CODE")));
				hashMap1.put("nkin_region_long_desc",	checkForNull(rs33.getString("nkin_region_long_desc")));
				hashMap1.put("contact1_region_code",	checkForNull(rs33.getString("CONTACT1_REGION_CODE")));
				hashMap1.put("fton_town_long_desc",		checkForNull(rs33.getString("FTON_TOWN_LONG_DESC")));
				hashMap1.put("contact2_res_town_code",checkForNull(rs33.getString("CONTACT2_RES_TOWN_CODE")));
				hashMap1.put("fton_area_long_desc",		checkForNull(rs33.getString("FTON_AREA_LONG_DESC")));
				hashMap1.put("contact2_res_area_code",checkForNull(rs33.getString("CONTACT2_RES_AREA_CODE")));
				hashMap1.put("contact2_region_code",	checkForNull(rs33.getString("contact2_region_code")));
				hashMap1.put("emplr_town_long_desc",	checkForNull(rs33.getString("EMPLR_TOWN_LONG_DESC")));
				hashMap1.put("emplr_area_long_desc",	checkForNull(rs33.getString("EMPLR_AREA_LONG_DESC")));
				hashMap1.put("emplr_region_long_desc",	checkForNull(rs33.getString("EMPLR_REGION_LONG_DESC")));
				hashMap1.put("contact3_region_code",	checkForNull(rs33.getString("CONTACT3_REGION_CODE")));
				hashMap1.put("contact3_res_town_code",checkForNull(rs33.getString("CONTACT3_RES_TOWN_CODE")));
				hashMap1.put("contact3_res_area_code",checkForNull(rs33.getString("CONTACT3_RES_AREA_CODE")));
				hashMap1.put("inhouse_birth_yn",			checkForNull(rs33.getString("inhouse_birth_yn"), "N"));
				hashMap1.put("fton_region_long_desc",	checkForNull(rs33.getString("fton_region_long_desc")));
				hashMap1.put("flag","yes");
/*Added by vinod for Organization Details - 2/22/2006*/
				hashMap1.put("MembershipType",			checkForNull(rs33.getString("MembershipType")));
				hashMap1.put("Orgsubname",					checkForNull(rs33.getString("Orgsubname")));
				hashMap1.put("OrgsubnameDesc",					checkForNull(rs33.getString("OrgsubnameDesc")));
				hashMap1.put("Orgname",						checkForNull(rs33.getString("Orgname")));
				hashMap1.put("family_org_id",				checkForNull(rs33.getString("family_org_id")));
				hashMap1.put("patexpirtydate",				checkForNull(rs33.getString("patexpirtydate")));
				hashMap1.put("pat_cat_code",				checkForNull(rs33.getString("PAT_CAT_CODE")));
				hashMap1.put("pat_language_id",				checkForNull(rs33.getString("language_id")));
				hashMap1.put("language_desc",				checkForNull(rs33.getString("language_desc")));
				hashMap1.put("combined_rel_level_code",	checkForNull(rs33.getString("combined_rel_level_code")));
				hashMap1.put("combined_rel_level_desc",	checkForNull(rs33.getString("combined_rel_level_desc")));
				hashMap1.put("blood_grp",	checkForNull(rs33.getString("blood_grp"),""));
				hashMap1.put("rh_factor",	checkForNull(rs33.getString("rh_factor"),""));
				hashMap1.put("deceased_date",	checkForNull(rs33.getString("deceased_date"),""));
				hashMap1.put("known_allergy_yn",							checkForNull(rs33.getString("known_allergy_yn")));
				hashMap1.put("eye_indicator",							checkForNull(rs33.getString("eye_indicator")));
				hashMap1.put("myhix_consent",							checkForNull(rs33.getString("myhix_consent"))); //Added for MYHIX integration ML-MMOH-CRF-0507.1
				hashMap1.put("myhix_pat_id",							checkForNull(rs33.getString("myhix_pat_id"))); //Added for MYHIX integration ML-MMOH-CRF-0507.1

				/*End Of Addition - 2/22/2006*/
				hashMap1.put("patient_long_name",							checkForNull(rs33.getString("patient_long_name")));
				hashMap1.put("patient_long_name_loc_lang",							checkForNull(rs33.getString("patient_long_name_loc_lang")));
				hashMap1.put("hijri_birth_date",							checkForNull(rs33.getString("HIJRI_BIRTH_DATE")));
				/*Below line added for this CRF  GDOH-CRF-0029 [IN:048764]*/
				
				hashMap1.put("blood_donor",							checkForNull(rs33.getString("blood_donor"),"N"));
				hashMap1.put("visa_type",							checkForNull(rs33.getString("visa_type")));
				hashMap1.put("primary_nuhdeek_yn",							checkForNull(rs33.getString("primary_nuhdeek_yn")));
				hashMap1.put("nuhdeek_ready_yn",							checkForNull(rs33.getString("nuhdeek_ready_yn")));
				hashMap1.put("regn_date",							checkForNull(rs33.getString("REGN_DATE")));
				hashMap1.put("form_60_yn",							checkForNull(rs33.getString("form_60_yn"),"N"));//Added by Dharma on 25th Jan 2016 for KDAH-CRF-0331 [IN058799]
				hashMap1.put("downtime_regn_yn",							checkForNull(rs33.getString("downtime_regn_yn")));/*Added By Dharma on Sep 9th 2016 against PMG2015-GDOH-CRF-0006.1 [IN061724]*/
				// added by mujafar for KDAH-CRF-370.1 start
				if(chkPanValidate)
				{
				hashMap1.put("pancard_status",							checkForNull(rs33.getString("PAN_CARD_STATUS")));
				hashMap1.put("pancard_holder_name",							checkForNull(rs33.getString("PAN_CARD_HOLDER_NAME")));
				hashMap1.put("pan_transaction_id",							checkForNull(rs33.getString("INT_TRANSACTION_ID")));
				hashMap1.put("pancard_relation",							checkForNull(rs33.getString("PAN_RELATION")));
				}
				// added by mujafar for KDAH-CRF-370.1 end
				
				//Added for this CRF ML-MMOh-CRF-0860.2
			 if(alterAddressApplicable){ 
				hashMap1.put("alt_addr_line1",							checkForNull(rs33.getString("alt_addr_line1")));
				hashMap1.put("alt_addr_line2",							checkForNull(rs33.getString("alt_addr_line2")));				
				hashMap1.put("alt_addr_line3",							checkForNull(rs33.getString("alt_addr_line3")));
				hashMap1.put("alt_addr_line4",							checkForNull(rs33.getString("alt_addr_line4")));
				hashMap1.put("alt_postal_code",							checkForNull(rs33.getString("alt_postal_code")));
				hashMap1.put("alt_postal_code_desc",					checkForNull(rs33.getString("alt_postal_code_desc")));
				hashMap1.put("alt_country_code",						checkForNull(rs33.getString("alt_country_code")));
				hashMap1.put("alt_country_name",						checkForNull(rs33.getString("alt_country_name")));
				hashMap1.put("alt_invalid_yn",						    checkForNull(rs33.getString("alt_invalid_yn")));
				hashMap1.put("alt_contact_name",						checkForNull(rs33.getString("alt_contact_name")));
				hashMap1.put("alt_area_code",						    checkForNull(rs33.getString("alt_area_code")));
				hashMap1.put("alt_area_code_desc",						checkForNull(rs33.getString("alt_area_code_desc")));
				hashMap1.put("alt_town_code",						    checkForNull(rs33.getString("alt_town_code")));
				hashMap1.put("alt_town_code_desc",						checkForNull(rs33.getString("alt_town_code_desc")));
				hashMap1.put("alt_region_code",						    checkForNull(rs33.getString("alt_region_code")));
				hashMap1.put("alt_region_code_desc",					checkForNull(rs33.getString("alt_region_code_desc")));
				}
				//End ML-MMOH-CRF-0860.2
				//aadhaar_card_status, aadhaar_trans_id Added by Sethu on 18/01/2018 for KDAH-CRF-0362 [IN063381]
				if(chkAadhaarValidate)
				{
					hashMap1.put("aadhaar_card_status",	checkForNull(rs33.getString("aadhaar_card_status")));
					hashMap1.put("aadhaar_trans_id", checkForNull(rs33.getString("aadhaar_trans_id")));
					hashMap1.put("national_id_no",eXH.XHUtil.getNationalID(patient_id));
				}

				if(isVirtualConsultation){
				hashMap1.put("contact2_country_code", checkForNull(rs33.getString("contact2_country_code")));
				}
				//Maheshwaran K added for MO-CRF-20183.2 as on 08-05-2023
				if(isPractEmployeeServiceNumber){
				hashMap1.put("employee_service_no", checkForNull(rs33.getString("employee_service_no")));
				}

			} else {  
				hashMap1.put("flag","no");
			}
			if(rs33 != null) rs33.close();
			if(pstmt1 != null) pstmt1.close();
		}
		catch(Exception e1) {
			e1.printStackTrace();
		}
		return hashMap1;
	}
	public static HashMap getCizntNatCode(Connection con,java.util.Properties p) throws Exception
	{

		String locale = p.getProperty("LOCALE");

		Statement stmt		= null;
		ResultSet rs		= null;
		HashMap hashMap2	= null;

		try
		{
			hashMap2 = new HashMap();
			stmt = con.createStatement();
		
			rs = stmt.executeQuery("SELECT a.citizen_nationality_code citizen_nationality_code, b.long_desc long_desc FROM mp_country_lang_vw b, mp_param_lang_vw a WHERE  a.module_id='MP' and a.language_id = '"+locale+"' and b.language_id = '"+locale+"' and b.eff_status = 'E' AND b.country_code = a.citizen_nationality_code"); 
			while(rs != null && rs.next())
			{
				hashMap2.put("def_nat_cd",checkForNull(rs.getString("citizen_nationality_code")));
				hashMap2.put("def_nat_desc",checkForNull(rs.getString("long_desc")));
			} 
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}
		return hashMap2;
	}
	public static HashMap getNBParentDtls(String patient_id, Connection con,java.util.Properties p) throws Exception
	{

		Statement stmt		= null;
		ResultSet rs		= null;
		HashMap hashMap3	= null;
		String locale = p.getProperty("LOCALE");
		try
		{
			hashMap3 = new HashMap();
			stmt = con.createStatement();
			//rs = stmt.executeQuery("SELECT mother_patient_id, mother_patient_name, mother_alt_id1_no, moth_citizenship, father_patient_id, father_patient_name, father_alt_id1_no, fath_citizenship FROM mp_nb_parent_dtls_vw WHERE patient_id = '"+patient_id+"'"); 
			rs = stmt.executeQuery("SELECT  mother_patient_id  , decode('"+locale+"', 'en', mother_patient_name, nvl(mother_patient_name_loc_lang, mother_patient_name)) mother_patient_name  , mother_alt_id1_no  ,mp_get_desc.mp_country(moth_nationality_code,'"+locale+"',1) moth_citizenship  , father_patient_id  , decode('"+locale+"', 'en', father_patient_name, nvl(father_patient_name_loc_lang, father_patient_name)) father_patient_name  , father_alt_id1_no  , mp_get_desc.mp_country(fath_nationality_code,'"+locale+"',1) fath_citizenship  FROM  mp_nb_parent_dtls_vw  WHERE patient_id = '"+patient_id+"'"); 
			if(rs != null)
			{
				while(rs.next())
				{
					hashMap3.put("mother_patient_id",	checkForNull(rs.getString("mother_patient_id")));
					hashMap3.put("mother_patient_name",checkForNull(rs.getString("mother_patient_name"),"&nbsp;"));
					hashMap3.put("mother_alt_id1_no",checkForNull(rs.getString("mother_alt_id1_no"),"&nbsp;"));
					hashMap3.put("moth_citizenship",checkForNull(rs.getString("moth_citizenship"),"&nbsp;"));
					hashMap3.put("father_patient_id",checkForNull(rs.getString("father_patient_id"),"&nbsp;"));
					hashMap3.put("father_patient_name",checkForNull(rs.getString("father_patient_name"),"&nbsp;"));
					hashMap3.put("father_alt_id1_no",checkForNull(rs.getString("father_alt_id1_no"),"&nbsp;"));
					hashMap3.put("fath_citizenship",checkForNull(rs.getString("fath_citizenship"),"&nbsp;"));
				}
				hashMap3.put("flag", "yes");
			}
			else hashMap3.put("flag", "no");
			
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		catch(Exception e3)
		{
			e3.printStackTrace();
		}
		return hashMap3;
	}
	public static HashMap getBlMPParamDtls(String param, Connection con,java.util.Properties p) throws Exception
	{
		Statement stmt		= null;
		ResultSet rs		= null;
		HashMap hashMap4	= null;

		try
		{
			hashMap4 = new HashMap();
			stmt = con.createStatement();
			if(param.equals("bl_mp_param"))
			{
				rs = stmt.executeQuery("SELECT dflt_nb_blng_grp_as_mother_yn, newborn_blng_grp_id FROM bl_mp_param"); 
				if(rs != null && rs.next())
				{
					//while(rs.next())
					//{
						hashMap4.put("dflt_nb_blng_grp_as_mother_yn",checkForNull(rs.getString("dflt_nb_blng_grp_as_mother_yn")));
						hashMap4.put("newborn_blng_grp_id",checkForNull(rs.getString("newborn_blng_grp_id")));
						hashMap4.put("flag", "yes");
					//}
				}
				else
				{
					hashMap4.put("flag", "no");
				}
				if(rs != null) rs.close();
			}	
			if(param.equals("bl_mp_param1"))
			{
				rs = stmt.executeQuery("SELECT dflt_nb_regn_blng_class dflt_regn_blng_class FROM bl_mp_param"); 
				while(rs != null && rs.next())
				{
					hashMap4.put("dflt_regn_blng_class",checkForNull(rs.getString("dflt_regn_blng_class")));
				} if(rs != null) rs.close();
			}	
			else if(param.equals("bl_mp_param2"))
			{
				rs = stmt.executeQuery("SELECT dflt_pat_regn_blng_class dflt_regn_blng_class FROM bl_mp_param"); 
				while(rs != null && rs.next())
				{
					hashMap4.put("dflt_regn_blng_class",checkForNull(rs.getString("dflt_regn_blng_class")));
				} if(rs != null) rs.close();
			}
			if(stmt != null) stmt.close();
		}
		catch(Exception e3)
		{
			e3.printStackTrace();
		}
		return hashMap4;
	}
	public static HashMap getBlBlngGrpDtls(String value, Connection con,java.util.Properties p) throws Exception
	{

		Statement stmt		= null;
		ResultSet rs		= null;
		HashMap hashMap5	= null;

		try
		{
			hashMap5 = new HashMap();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT settlement_ind FROM bl_blng_grp WHERE blng_grp_id = '"+value+"'"); 
			while(rs != null && rs.next())
			{
				hashMap5.put("settlement_ind",	checkForNull(rs.getString("settlement_ind")));
			}
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		catch(Exception e3)
		{
			e3.printStackTrace();
		}
		return hashMap5;
	}
	public static HashMap getCountryCodeDesc(Connection con,String a_nationality_code, String citizen_nationality_code,java.util.Properties p) throws Exception
	{
		String locale = p.getProperty("LOCALE");

		Statement stmt		= null;
		ResultSet rs		= null;
		HashMap hashMap6	= null;

		try
		{
			hashMap6 = new HashMap();
			stmt = con.createStatement();
			if(!a_nationality_code.equals("")) 
			{
				rs = stmt.executeQuery("SELECT country_code, long_desc FROM mp_country_lang_vw WHERE language_id = '"+locale+"' and eff_status = 'E' AND country_code = '"+a_nationality_code+"'"); 
			}
			else
			{
				rs = stmt.executeQuery("SELECT country_code, long_desc FROM mp_country_lang_vw WHERE language_id = '"+locale+"' and eff_status = 'E' AND country_code = '"+citizen_nationality_code+"'"); 
			}
			while(rs != null && rs.next())
			{
				hashMap6.put("country_code",checkForNull(rs.getString("country_code")));
				hashMap6.put("country_long_desc",checkForNull(rs.getString("long_desc")));
			} 
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}
		return hashMap6;
	}
	public static ArrayList getPatSerGrpCode(Connection con, String patient_grp, String site, String facility, String function_name,java.util.Properties p) throws Exception
	{
		
		String locale = p.getProperty("LOCALE");
		String user_id = p.getProperty("login_user");

		Statement stmt		= null;
		ResultSet rs		= null;
		ArrayList arrayList	= null;
		HashMap hashMap		= new HashMap();
		try
		{
			arrayList = new ArrayList();
			stmt = con.createStatement();

			hashMap = eMP.ChangePatientDetails.getSetupData(facility,"",con,p);
		String pat_ser_access_by_user_yn = checkForNull((String)hashMap.get("PAT_SER_ACCESS_BY_USER_YN"));


		String userAccessSql	= "";

		String usedStatusSql	="";
		String sql_one			="";
		 usedStatusSql	= " and pat_ser_grp_code IN (SELECT pat_ser_grp_code FROM mp_pat_ser_facility WHERE used_status = 'N') ";

		if(pat_ser_access_by_user_yn.equals("Y")){
			userAccessSql	= " and pat_ser_grp_code IN (SELECT pat_ser_grp_code FROM MP_PAT_SER_GRP_FOR_USER WHERE APPL_USER_ID = '"+user_id+"') ";
		}


			if(function_name.equals("PatientRegistration"))
			{

				if(!patient_grp.equals("G"))
				{ 
					
					rs = stmt.executeQuery("SELECT pat_ser_grp_code, short_desc, id_type, pat_name_in_loc_lang_reqd_yn, prefix_reqd_yn FROM mp_pat_ser_grp_lang_vw WHERE language_id = '"+locale+"' and id_type IN ('U', '"+patient_grp+"' ) AND id_type NOT IN ('X', 'R') AND gen_pat_id_yn = 'Y' AND GEN_PID_USING_ALT_ID1_RULE_YN='N' AND (pat_ser_grp_code IN (SELECT pat_ser_grp_code FROM mp_pat_ser_facility WHERE USED_STATUS = 'N' and site_or_facility_id = decode(site_or_facility,'S','"+site+"','F','"+facility+"')) OR ASSOCIATED_PAT_SER_GRP_CODE IS NOT NULL) "+userAccessSql+" UNION SELECT pat_ser_grp_code, short_desc, id_type, pat_name_in_loc_lang_reqd_yn, prefix_reqd_yn FROM mp_pat_ser_grp_lang_vw WHERE language_id = '"+locale+"' and id_type IN ('U', '"+patient_grp+"' ) AND id_type NOT IN ('X', 'R') AND gen_pat_id_yn = 'Y' AND GEN_PID_USING_ALT_ID1_RULE_YN='Y'  "+userAccessSql+"   UNION SELECT pat_ser_grp_code, short_desc, id_type, pat_name_in_loc_lang_reqd_yn, prefix_reqd_yn FROM mp_pat_ser_grp_lang_vw WHERE language_id = '"+locale+"' and id_type IN('U', '"+patient_grp+"') AND id_type NOT IN ('X', 'R') AND gen_pat_id_yn = 'N' "+usedStatusSql+" "+userAccessSql+" ORDER BY 2"); 
						/*Modified by Rameswar on 16/11/2016 for BSP-SCF-0018*/
					
				


				}
				else 
				{ 
					  sql_one="SELECT pat_ser_grp_code, short_desc, id_type, pat_name_in_loc_lang_reqd_yn, prefix_reqd_yn FROM mp_pat_ser_grp_lang_vw where language_id = '"+locale+"' and id_type NOT IN ('X', 'R') AND gen_pat_id_yn = 'Y' AND GEN_PID_USING_ALT_ID1_RULE_YN='N' AND (pat_ser_grp_code in (SELECT pat_ser_grp_code FROM mp_pat_ser_facility WHERE USED_STATUS = 'N' and site_or_facility_id = decode(site_or_facility,'S','"+site+"','F','"+facility+"')) OR ASSOCIATED_PAT_SER_GRP_CODE IS NOT NULL) "+userAccessSql+" UNION SELECT pat_ser_grp_code, short_desc, id_type, pat_name_in_loc_lang_reqd_yn, prefix_reqd_yn FROM mp_pat_ser_grp_lang_vw WHERE language_id = '"+locale+"' and id_type IN ('U', '"+patient_grp+"' ) AND id_type NOT IN ('X', 'R') AND gen_pat_id_yn = 'Y' AND GEN_PID_USING_ALT_ID1_RULE_YN='Y' "+userAccessSql+"  UNION SELECT pat_ser_grp_code, short_desc, id_type,pat_name_in_loc_lang_reqd_yn, prefix_reqd_yn FROM mp_pat_ser_grp_lang_vw WHERE language_id = '"+locale+"' and id_type NOT IN ('X', 'R') AND gen_pat_id_yn = 'N' "+usedStatusSql+" "+userAccessSql+"  ORDER BY 2";
					 	 /*Modified by Rameswar on 16/11/2016 for BSP-SCF-0018*/
				
					rs = stmt.executeQuery(sql_one); 
				}
			}
			else if(function_name.equals("RapidReg"))
			{
				if(!patient_grp.equals("G"))
				{
					
					rs = stmt.executeQuery("SELECT pat_ser_grp_code, short_desc, id_type, pat_name_in_loc_lang_reqd_yn, prefix_reqd_yn FROM mp_pat_ser_grp_lang_vw WHERE language_id = '"+locale+"' and id_type IN ('U', '"+patient_grp+"') AND id_type NOT IN ('X', 'R') AND gen_pat_id_yn = 'Y' AND (pat_ser_grp_code IN (SELECT pat_ser_grp_code FROM mp_pat_ser_facility WHERE USED_STATUS = 'N' and site_or_facility_id = decode(site_or_facility,'S','"+site+"','F','"+facility+"')) OR ASSOCIATED_PAT_SER_GRP_CODE IS NOT NULL) "+userAccessSql+" UNION SELECT pat_ser_grp_code, short_desc,id_type, pat_name_in_loc_lang_reqd_yn, prefix_reqd_yn FROM mp_pat_ser_grp_lang_vw WHERE language_id = '"+locale+"' and id_type = '"+patient_grp+"' AND gen_pat_id_yn = 'N' AND id_type NOT IN ('X', 'R') "+usedStatusSql+" "+userAccessSql+" ORDER BY 2");
					
					
				}
				else
				{
					
					rs = stmt.executeQuery("SELECT pat_ser_grp_code, short_desc, id_type, pat_name_in_loc_lang_reqd_yn, prefix_reqd_yn FROM mp_pat_ser_grp_lang_vw WHERE language_id = '"+locale+"' and id_type NOT IN ('X', 'R') AND gen_pat_id_yn = 'Y' AND (pat_ser_grp_code IN (SELECT pat_ser_grp_code FROM mp_pat_ser_facility WHERE USED_STATUS = 'N' and site_or_facility_id = decode(site_or_facility,'S','"+site+"','F','"+facility+"')) OR ASSOCIATED_PAT_SER_GRP_CODE IS NOT NULL) "+userAccessSql+" UNION SELECT pat_ser_grp_code, short_desc, id_type, pat_name_in_loc_lang_reqd_yn, prefix_reqd_yn FROM mp_pat_ser_grp_lang_vw WHERE language_id = '"+locale+"' and gen_pat_id_yn = 'N' AND id_type NOT IN ('X', 'R') "+usedStatusSql+" "+userAccessSql+" ORDER BY 2");

					
		
				}
			}
			else if(function_name.equals("EmergencyReg"))
			{
				
				rs = stmt.executeQuery("SELECT pat_ser_grp_code, short_desc,id_type, pat_name_in_loc_lang_reqd_yn, prefix_reqd_yn FROM mp_pat_ser_grp_lang_vw where   language_id = '"+locale+"' and id_type NOT IN ('X', 'R') AND gen_pat_id_yn = 'Y' AND id_type in('E','U') AND (pat_ser_grp_code in (SELECT pat_ser_grp_code FROM mp_pat_ser_facility WHERE USED_STATUS = 'N' and site_or_facility_id = decode(site_or_facility,'S','"+site+"','F','"+facility+"')) OR ASSOCIATED_PAT_SER_GRP_CODE IS NOT NULL) "+userAccessSql+" UNION select pat_ser_grp_code, short_desc,id_type, pat_name_in_loc_lang_reqd_yn, prefix_reqd_yn FROM mp_pat_ser_grp_lang_vw WHERE language_id = '"+locale+"' and id_type NOT IN ('X', 'R') AND gen_pat_id_yn = 'N' AND id_type IN ('E','U') "+usedStatusSql+" "+userAccessSql+" ORDER BY 2 ");

				
		
			}
			/*Added by Thamizh selvi on 24th July 2017 for ML-MMOH-CRF-0689 Start*/
			else if(function_name.equals("BID_REGN"))
			{
				rs = stmt.executeQuery(" SELECT pat_ser_grp_code, short_desc, id_type, pat_name_in_loc_lang_reqd_yn, prefix_reqd_yn FROM mp_pat_ser_grp_lang_vw WHERE language_id = '"+locale+"' AND gen_pat_id_yn = 'Y' AND id_type = 'R' AND pat_ser_grp_code = (SELECT pat_series_for_bid FROM mo_parameter WHERE facility_id = '"+facility+"') AND ( pat_ser_grp_code IN ( SELECT pat_ser_grp_code FROM mp_pat_ser_facility WHERE used_status = 'N' AND site_or_facility_id = DECODE (site_or_facility, 'S', '"+site+"', 'F', '"+facility+"' )) OR associated_pat_ser_grp_code IS NOT NULL ) "+userAccessSql+" UNION SELECT pat_ser_grp_code, short_desc, id_type, pat_name_in_loc_lang_reqd_yn, prefix_reqd_yn FROM mp_pat_ser_grp_lang_vw WHERE language_id = '"+locale+"' AND gen_pat_id_yn = 'N' AND id_type = 'R' AND pat_ser_grp_code = (SELECT pat_series_for_bid FROM mo_parameter WHERE facility_id = '"+facility+"') "+usedStatusSql+" "+userAccessSql+" ");	
			}
			else if(function_name.equals("EBP_REGN"))
			{
				rs = stmt.executeQuery(" SELECT pat_ser_grp_code, short_desc, id_type, pat_name_in_loc_lang_reqd_yn, prefix_reqd_yn FROM mp_pat_ser_grp_lang_vw WHERE language_id = '"+locale+"' AND gen_pat_id_yn = 'Y' AND id_type = 'R' AND pat_ser_grp_code = (SELECT pat_series_for_body_part FROM mo_parameter WHERE facility_id = '"+facility+"') AND ( pat_ser_grp_code IN ( SELECT pat_ser_grp_code FROM mp_pat_ser_facility WHERE used_status = 'N' AND site_or_facility_id = DECODE (site_or_facility, 'S', '"+site+"', 'F', '"+facility+"' )) OR associated_pat_ser_grp_code IS NOT NULL ) "+userAccessSql+" UNION SELECT pat_ser_grp_code, short_desc, id_type, pat_name_in_loc_lang_reqd_yn, prefix_reqd_yn FROM mp_pat_ser_grp_lang_vw WHERE language_id = '"+locale+"' AND gen_pat_id_yn = 'N' AND id_type = 'R' AND pat_ser_grp_code = (SELECT pat_series_for_body_part FROM mo_parameter WHERE facility_id = '"+facility+"') "+usedStatusSql+" "+userAccessSql+" ");	
			}/*End*/
			while(rs != null && rs.next())
			{
				arrayList.add(checkForNull(rs.getString("pat_ser_grp_code")));
				arrayList.add(checkForNull(rs.getString("short_desc")));
				arrayList.add(checkForNull(rs.getString("id_type")));
				arrayList.add(checkForNull(rs.getString("pat_name_in_loc_lang_reqd_yn"), "N"));
				arrayList.add(checkForNull(rs.getString("prefix_reqd_yn")));
			} 
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		catch(Exception e5)
		{
			e5.printStackTrace();
		}
		return arrayList;
	}
	public static HashMap getMPBirthRegisterCount(String value, Connection con,java.util.Properties p) throws Exception
	{
		Statement stmt		= null;
		ResultSet rs		= null;
		HashMap hashMap8	= null;

		try
		{
			hashMap8 = new HashMap();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT count(1) count FROM mp_birth_register WHERE mother_patient_id = '"+value+"'"); 
			while(rs != null && rs.next())
			{
				hashMap8.put("count",	checkForNull(rs.getString("count")));
			}
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		catch(Exception e3)
		{
			e3.printStackTrace();
		}
		return hashMap8;
	}
	public static ArrayList getResultRows(Connection con, String param,java.util.Properties p) throws Exception {

		String locale = p.getProperty("LOCALE");

		Statement stmt		= null;
		ResultSet rs		= null;
		ArrayList arrayList	= null; 
		
		try {
			arrayList = new ArrayList();
			stmt = con.createStatement();
			if(param.equals("mp_pat_ser_grp")) { 
				rs = stmt.executeQuery("SELECT pat_ser_grp_code, gen_pat_id_yn FROM mp_pat_ser_grp");
				while(rs != null && rs.next()) {
					arrayList.add(checkForNull(rs.getString("pat_ser_grp_code")));
					arrayList.add(checkForNull(rs.getString("gen_pat_id_yn")));
				} if(rs != null) rs.close();
			}
			else if(param.equals("sm_facility_param")) {   
				rs = stmt.executeQuery("SELECT facility_id, facility_name facility_name FROM sm_facility_param_lang_vw WHERE language_id = '"+locale+"' and Facility_Type = 'F' order by 2"); 
				while(rs != null && rs.next()) {
					arrayList.add(checkForNull(rs.getString("facility_id")));
					arrayList.add(checkForNull(rs.getString("facility_name")));
				} 
				if(rs != null) rs.close();
			}
			else if(param.equals("mp_alternate_id_type")) {   
				rs = stmt.executeQuery("SELECT alt_id_type, long_desc short_desc FROM mp_alternate_id_type_lang_vw where language_id = '"+locale+"' and alt_id_type NOT IN (SELECT alt_id1_type FROM mp_param where module_id='MP' UNION SELECT nvl(alt_id2_type,1) FROM mp_param where module_id='MP' UNION SELECT nvl(alt_id3_type,2) FROM mp_param where module_id='MP' UNION SELECT nvl(alt_id4_type,3) FROM mp_param where module_id='MP') AND eff_status = 'E' ORDER BY 2"); 
				while(rs != null && rs.next()) {
					arrayList.add(checkForNull(rs.getString("alt_id_type")));
					arrayList.add(checkForNull(rs.getString("short_desc")));
				} if(rs != null) rs.close();
			}
			else if(param.equals("mp_alternate_id_type1")) {				
				rs = stmt.executeQuery("select alt_id_type, long_desc short_desc FROM mp_alternate_id_type_lang_vw where language_id = '"+locale+"' AND eff_status = 'E' ORDER BY 2"); 
				while(rs != null && rs.next()) {
					arrayList.add(checkForNull(rs.getString("alt_id_type")));
					arrayList.add(checkForNull(rs.getString("short_desc")));
				} if(rs != null) rs.close();
			}
			else if(param.equals("mp_relationship")) {
				rs = stmt.executeQuery("SELECT relationship_code, INITCAP(short_desc) short_desc FROM mp_relationship_lang_vw WHERE language_id = '"+locale+"' and eff_status = 'E' ORDER BY 2"); 
										
				while(rs != null && rs.next()) {
					arrayList.add(checkForNull(rs.getString("relationship_code")));
					arrayList.add(checkForNull(rs.getString("short_desc")));
				} if(rs != null) rs.close();
			}
			else if(param.equals("mp_name_prefix")) {
				rs = stmt.executeQuery("SELECT name_prefix_loc_lang, name_prefix, prefix_sex FROM mp_name_prefix WHERE eff_status = 'E' ORDER BY name_prefix"); 
				while(rs != null && rs.next()) {
					arrayList.add(checkForNull(rs.getString("name_prefix")));
					arrayList.add(checkForNull(rs.getString("name_prefix_loc_lang")));
					arrayList.add(checkForNull(rs.getString("prefix_sex")));
				} if(rs != null) rs.close();
			}
			else if(param.equals("mp_name_prefix0")) {
				rs = stmt.executeQuery("SELECT name_prefix from mp_name_prefix WHERE eff_status = 'E' ORDER BY name_prefix"); 
				while(rs != null && rs.next()) {
					arrayList.add(checkForNull(rs.getString("name_prefix")));
				} if(rs != null) rs.close();
			}
			else if(param.equals("mp_name_prefix1")) {
				rs = stmt.executeQuery("SELECT name_prefix_loc_lang, name_prefix FROM mp_name_prefix WHERE eff_status = 'E' ORDER BY 1"); 
										
				while(rs != null && rs.next()) {
					arrayList.add(checkForNull(rs.getString("name_prefix_loc_lang")));
					arrayList.add(checkForNull(rs.getString("name_prefix")));
				} if(rs != null) rs.close();
			}
			else if(param.equals("mp_name_suffix")) {
				rs = stmt.executeQuery("SELECT name_suffix FROM mp_name_suffix WHERE eff_status = 'E'"); 
				while(rs != null && rs.next()) {
					arrayList.add(checkForNull(rs.getString("name_suffix")));
				} if(rs != null) rs.close();
			}
			else if(param.equals("mp_name_suffix1")) {
				rs = stmt.executeQuery("SELECT name_suffix_loc_lang, name_suffix FROM mp_name_suffix WHERE eff_status = 'E' ORDER BY 1"); 
				while(rs != null && rs.next()) {
					arrayList.add(checkForNull(rs.getString("name_suffix_loc_lang")));
					arrayList.add(checkForNull(rs.getString("name_suffix")));
				} if(rs != null) rs.close();
			}
			else if(param.equals("mp_name_suffix2")) {
				rs = stmt.executeQuery("SELECT name_suffix, name_suffix_loc_lang, baby_sex FROM mp_name_suffix WHERE eff_status = 'E' ORDER BY name_suffix"); 
				while(rs != null && rs.next()) {
					arrayList.add(checkForNull(rs.getString("name_suffix")));
					arrayList.add(checkForNull(rs.getString("name_suffix_loc_lang")));
					arrayList.add(checkForNull(rs.getString("baby_sex")));
				} if(rs != null) rs.close();
			}
			else if(param.equals("mp_marital_status")) {
				
				rs = stmt.executeQuery("SELECT mar_status_code, short_desc FROM mp_marital_status_lang_vw WHERE language_id = '"+locale+"' and eff_status = 'E' ORDER BY 2"); 
				while(rs != null && rs.next()) {
					arrayList.add(checkForNull(rs.getString("mar_status_code")));
					arrayList.add(checkForNull(rs.getString("short_desc")));
				} if(rs != null) rs.close();
			}
			else if(param.equals("mp_pat_category")) {
				rs = stmt.executeQuery("SELECT pat_cat_code, short_desc FROM mp_pat_category_lang_vw WHERE language_id = '"+locale+"' and eff_status = 'E' ORDER BY 2"); 
				while(rs != null && rs.next()) {
					arrayList.add(checkForNull(rs.getString("pat_cat_code")));
					arrayList.add(checkForNull(rs.getString("short_desc")));
				} if(rs != null) rs.close();
			}
			else if(param.equals("mp_race")) {
				rs = stmt.executeQuery("SELECT race_code, initcap(long_desc) long_desc FROM mp_race_lang_vw WHERE language_id = '"+locale+"' and eff_status = 'E' ORDER BY 2"); 
				while(rs != null && rs.next()) {
					arrayList.add(checkForNull(rs.getString("race_code")));
					arrayList.add(checkForNull(rs.getString("long_desc")));
				} if(rs != null) rs.close();
			}
			else if(param.equals("mp_religion")) {
				rs = stmt.executeQuery("SELECT relgn_code, short_desc FROM mp_religion_lang_vw WHERE language_id = '"+locale+"' and eff_status = 'E' ORDER BY 2"); 
				while(rs != null && rs.next()) {
					arrayList.add(checkForNull(rs.getString("relgn_code")));
					arrayList.add(checkForNull(rs.getString("short_desc")));
				} if(rs != null) rs.close();
			}
			else if(param.equals("mp_occupation_class")) {
				rs = stmt.executeQuery("SELECT ocpn_class_code, long_desc short_desc FROM mp_occupation_class_lang_vw  WHERE language_id = '"+locale+"' and eff_status = 'E' order by 2"); 
				while(rs != null && rs.next()) {
					arrayList.add(checkForNull(rs.getString("ocpn_class_code")));
					arrayList.add(checkForNull(rs.getString("short_desc")));
				} if(rs != null) rs.close();
			}
			else if(param.equals("mp_contact_mode1")) {
				rs = stmt.executeQuery("select short_desc from mp_contact_mode_lang_vw where language_id = '"+locale+"' and  contact_mode in ('PRN','ORN') order by contact_mode desc"); 
				while(rs != null && rs.next()) {
					arrayList.add(checkForNull(rs.getString("short_desc")));
				} if(rs != null) rs.close();
			}
			else if(param.equals("mp_contact_mode2")) {
				rs = stmt.executeQuery("SELECT contact_mode, short_desc FROM mp_contact_mode_lang_vw WHERE   language_id = '"+locale+"' and contact_mode not in ('PRN','ORN') ORDER BY short_desc"); 
				while(rs != null && rs.next()) {
					arrayList.add(checkForNull(rs.getString("contact_mode")));
					arrayList.add(checkForNull(rs.getString("short_desc")));
				} if(rs != null) rs.close();
			}
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		catch(Exception e3) {
			e3.printStackTrace();
		}
		return arrayList;
	}

	public static HashMap getLanguageDesc(Connection con,String language_code,java.util.Properties p) throws Exception
	{
		String locale = p.getProperty("LOCALE");

		Statement stmt		= null;
		ResultSet rs		= null;
		HashMap hashMap9	= null;

		try
		{
			hashMap9 = new HashMap();
			stmt = con.createStatement();
			if(!language_code.equals("")) 
			{
				rs = stmt.executeQuery("SELECT MP_LANGUAGE_ID LANGUAGE_ID, LONG_DESC LONG_NAME FROM MP_LANGUAGE_LANG_VW WHERE MP_LANGUAGE_ID='"+language_code+"' and LANGUAGE_ID = '"+locale+"' and eff_status = 'E' ORDER BY 2"); 
			}
		
			while(rs != null && rs.next())
			{
				hashMap9.put("language_id",checkForNull(rs.getString("LANGUAGE_ID")));
				hashMap9.put("language_desc",checkForNull(rs.getString("LONG_NAME")));				
			} 
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		catch(Exception e2)
		{
			
			e2.printStackTrace();
		}
		return hashMap9;
	}




	public static HashMap getFacilityDesc(Connection con,String pref_facility_id,java.util.Properties p) throws Exception
	{
		String locale = p.getProperty("LOCALE");

		Statement stmt		= null;
		ResultSet rs		= null;
		HashMap hashMap10	= null;

		try
		{
			hashMap10 = new HashMap();
			stmt = con.createStatement();		

			if(!pref_facility_id.equals("")) 
			{
				rs = stmt.executeQuery("SELECT facility_id, facility_name facility_name FROM sm_facility_param_lang_vw WHERE language_id = '"+locale+"' and facility_id='"+pref_facility_id+"'and Facility_Type = 'F' order by 2"); 
			}
			
			while(rs != null && rs.next())
			{
				hashMap10.put("pref_facility_id",checkForNull(rs.getString("facility_id")));
				hashMap10.put("pref_facility_desc",checkForNull(rs.getString("facility_name")));				
			} 
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}
		return hashMap10;
	}



	public static HashMap getRaceDesc(Connection con,String race_code,java.util.Properties p) throws Exception
	{
		String locale = p.getProperty("LOCALE");

		Statement stmt		= null;
		ResultSet rs		= null;
		HashMap hashMap11	= null;
        
		
		try
		{
			hashMap11 = new HashMap();
			stmt = con.createStatement();

			if(!race_code.equals("")) 
			{
			 //Below modified by Suji Keerthi for ML-MMOH-SCF-1922
				rs = stmt.executeQuery("SELECT race_code, long_desc FROM mp_race_lang_vw WHERE language_id = '"+locale+"' and race_code='"+race_code+"' and eff_status = 'E' ORDER BY 2"); 
			}
			
			while(rs != null && rs.next())
			{
				hashMap11.put("race_code",checkForNull(rs.getString("race_code")));
				hashMap11.put("race_desc",checkForNull(rs.getString("long_desc")));
			} 
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}
		return hashMap11;
	}



	public static HashMap getReligionDesc(Connection con,String relgn_code,java.util.Properties p) throws Exception
	{
		String locale = p.getProperty("LOCALE");

		Statement stmt		= null;
		ResultSet rs		= null;
		HashMap hashMap12	= null;

		try
		{
			hashMap12 = new HashMap();
			stmt = con.createStatement();

			if(!relgn_code.equals("")) 
			{
				rs = stmt.executeQuery("SELECT relgn_code, short_desc FROM mp_religion_lang_vw WHERE language_id = '"+locale+"' and relgn_code='"+relgn_code+"' and eff_status = 'E' ORDER BY 2"); 
			}
			
			while(rs != null && rs.next())
			{
				hashMap12.put("relgn_code",checkForNull(rs.getString("relgn_code")));
				hashMap12.put("relgn_desc",checkForNull(rs.getString("short_desc")));
			} 
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}
		return hashMap12;
	}



	public static ArrayList getEthnicRows(Connection con, String param,java.util.Properties p) throws Exception
	{
		String locale = p.getProperty("LOCALE");

		Statement stmt	= null;
		ResultSet rs	= null;
		ArrayList arrayList	= null; 
		
		try
		{
			arrayList = new ArrayList();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT ethnic_group_code, long_desc FROM mp_ethnic_group_LANG_VW  WHERE  race_code = '"+param+"' AND eff_status = 'E'  and language_id = '"+locale+"' order by 2"); 
			while(rs != null && rs.next())
			{
				arrayList.add(checkForNull(rs.getString("ethnic_group_code")));
				arrayList.add(checkForNull(rs.getString("long_desc")));
			}
			if(stmt!=null)stmt.close();
			if(rs != null) rs.close();
		}
		catch(Exception e4)
		{
			e4.printStackTrace();
		}

		return arrayList;
	}

	public static String getMemberPatID(String alt_id1_no, Connection con,java.util.Properties p) throws Exception
	{

		Statement stmt		= null;
		ResultSet rs		= null;
		String  rPatient_id	= "";

		try
		{
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT patient_id FROM mp_patient WHERE alt_id1_no='"+checkForNull(alt_id1_no)+"' AND family_org_membership='1'");
			if ( (rs!=null) && (rs.next()) )
			{
				rPatient_id = rs.getString("patient_id");
			}	
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		catch(Exception e3)
		{
			e3.printStackTrace();
		}
		return rPatient_id;
	}
	public static HashMap getOrgMembership(String patient_id,Connection con,java.util.Properties p){
		PreparedStatement pstmt		= null;
		ResultSet rs				= null;
		String sqlQuery = "";
		HashMap hashMap1	= new HashMap();
		try{
				sqlQuery = "SELECT patient_id, (CASE WHEN patient.family_org_sub_id IS NOT NULL THEN (SELECT family_org_sub_name FROM mp_family_org_sub_lang_vw WHERE family_org_id = patient.family_org_id  AND family_org_sub_id = patient.family_org_sub_id AND language_id = 'en') END ) orgsubnamedesc, patient.family_org_sub_id orgsubname, (CASE WHEN patient.family_org_id IS NOT NULL THEN (SELECT family_org_name FROM mp_family_org_lang_vw WHERE family_org_id = patient.family_org_id AND language_id = 'en') END ) orgname,  patient.family_org_id family_org_id FROM mp_patient patient where patient.patient_id = ?";
				pstmt = con.prepareStatement(sqlQuery);			
				pstmt.setString(1,patient_id);
				rs=pstmt.executeQuery();
				if(rs!=null && rs.next()){
					hashMap1.put("Orgsubname",checkForNull(rs.getString("Orgsubname")));
					hashMap1.put("OrgsubnameDesc",checkForNull(rs.getString("OrgsubnameDesc")));
					hashMap1.put("Orgname",checkForNull(rs.getString("Orgname")));
					hashMap1.put("family_org_id",checkForNull(rs.getString("family_org_id")));
				}
				if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
		}catch(Exception e5) {
			
			e5.printStackTrace();
		}	
		return hashMap1;	
	}	
	/*	The static methods getMRAccessRights retrives access rights
	*	@Table mr_user_access_rights
	*	@Returns int
	*/
	public static int getMRAccessRights(String facility_id, Connection con,java.util.Properties p) throws Exception
	{

		Statement stmt		= null;
		ResultSet rs		= null;
		 /* below one line was commmanted by VenkateshS,Reason is this is "unused variable" while generate checkstyle report  */
		//String  rPatient_id	= "";
		int count=0;
		String user_id=p.getProperty("login_user");

		try
		{
			stmt = con.createStatement();
			String str="select count(*)count from mr_user_access_rights where facility_id='"+facility_id+"' and appl_user_id='"+user_id+"' AND CHANGE_NATIONAL_ID_NO_YN='Y'";
			rs = stmt.executeQuery(str);
			if ( (rs!=null) && (rs.next()) )
			{
				count = rs.getInt("count");
			}	
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		catch(Exception e3)
		{
			e3.printStackTrace();
		}
		return count;
	}
	/*Below method Added for this  CRF[Bru-HIMS-CRF-177] 
	 retrives the color code from  op_visit_type table.
	*/
	
public static HashMap getColorCode(Connection con1,String facility)
    {
	   Statement stmt1 =null;ResultSet color_ind_rs=null; String colour_indicator_code="";String visite_code=""; 
	   java.util.HashMap colorhm=new java.util.HashMap ();
	  try{
	   String colour_indicator_query1="select VISIT_TYPE_CODE, COLOR_INDICATOR from op_visit_type where FACILITY_ID='"+facility+"'"; 	  
       stmt1 = con1.createStatement();				 
		color_ind_rs = stmt1.executeQuery(colour_indicator_query1);
		  while( color_ind_rs != null && color_ind_rs.next()){
				    visite_code=color_ind_rs.getString("VISIT_TYPE_CODE");
				    colour_indicator_code=color_ind_rs.getString("COLOR_INDICATOR")==null?"":color_ind_rs.getString("COLOR_INDICATOR");				
				    colorhm.put(visite_code,colour_indicator_code);									
		  }			
          if(stmt1!=null) stmt1.close();					
		  if(color_ind_rs !=null)color_ind_rs.close();
	  
	  }catch(Exception e){
	e.printStackTrace();
	}
	   return colorhm;
	}	
	 //End[Bru-HIMS-CRF-177] 
	
/*Below method added for this CRF ML-MMOH-CRF-0780*/
public static int getNextofKin(Connection con, String patientId){
      int nextOfkin=0;
	  Statement stmt=null;
	  ResultSet rs=null;
	  	  
	  String contact1_name="", contact1_relation="", contact1_nat_id_no="",contact1_alt_id1_no="", contact1_alt_id2_no="", contact1_alt_id3_no="",       contact1_alt_id4_no="", contact1_oth_alt_id_type="", contact1_oth_alt_id_no="", contact1_birth_date="", job1_title="", addr1_line1="", addr1_line2="", addr1_line3="",addr1_line4="", postal1_code="", country1_code="", contact1_mob_tel_no="",contact1_email_id="",res1_tel_no="",off1_tel_no="", contact1_res_town_code="",contact1_res_area_code="",contact1_region_code="";
	  
	  String sqlQuery="SELECT contact1_name, contact1_relation, contact1_nat_id_no,contact1_alt_id1_no, contact1_alt_id2_no, contact1_alt_id3_no,       contact1_alt_id4_no, contact1_oth_alt_id_type, contact1_oth_alt_id_no,to_char(contact1_birth_date, 'dd/mm/yyyy') contact1_birth_date, job1_title, addr1_line1, addr1_line2, addr1_line3,addr1_line4, postal1_code, country1_code, contact1_mob_tel_no,contact1_email_id,res1_tel_no,off1_tel_no, contact1_res_town_code,contact1_res_area_code,contact1_region_code FROM mp_pat_rel_contacts WHERE patient_id ='"+patientId+"'";
	  
	  
	  
	  try{
	    stmt = con.createStatement();
		rs = stmt.executeQuery(sqlQuery);
		if( rs != null && rs.next()){
		 
		        
		
				contact1_name=checkForNull(rs.getString("contact1_name")).trim();
				if(!contact1_name.equals("")) nextOfkin++;
				
				contact1_relation=checkForNull(rs.getString("contact1_relation")).trim();
				if(!contact1_relation.equals("")) nextOfkin++;
				
				contact1_nat_id_no=checkForNull(rs.getString("contact1_nat_id_no")).trim();
				if(!contact1_nat_id_no.equals("")) nextOfkin++;
				
				contact1_alt_id1_no=checkForNull(rs.getString("contact1_alt_id1_no")).trim();
				if(!contact1_alt_id1_no.equals("")) nextOfkin++;
				
				contact1_alt_id2_no=checkForNull(rs.getString("contact1_alt_id2_no")).trim();
				if(!contact1_alt_id2_no.equals("")) nextOfkin++;
				
				contact1_alt_id3_no=checkForNull(rs.getString("contact1_alt_id3_no")).trim();
				if(!contact1_alt_id3_no.equals("")) nextOfkin++;
				
				contact1_alt_id4_no=checkForNull(rs.getString("contact1_alt_id4_no")).trim();
				if(!contact1_alt_id4_no.equals("")) nextOfkin++;
				
				contact1_oth_alt_id_type=checkForNull(rs.getString("contact1_oth_alt_id_type")).trim();
				if(!contact1_oth_alt_id_type.equals("")) nextOfkin++;
				
				contact1_oth_alt_id_no=checkForNull(rs.getString("contact1_oth_alt_id_no")).trim();
				if(!contact1_oth_alt_id_no.equals("")) nextOfkin++;
				
				contact1_birth_date=checkForNull(rs.getString("contact1_birth_date")).trim();
				if(!contact1_birth_date.equals("")) nextOfkin++;
				
				job1_title=checkForNull(rs.getString("job1_title")).trim();
				if(!job1_title.equals("")) nextOfkin++;
				
				addr1_line1=checkForNull(rs.getString("addr1_line1")).trim();
				if(!addr1_line1.equals("")) nextOfkin++;
				
				addr1_line2=checkForNull(rs.getString("addr1_line2")).trim();
				if(!addr1_line2.equals("")) nextOfkin++;
				
				addr1_line3=checkForNull(rs.getString("addr1_line3")).trim();
				if(!addr1_line3.equals("")) nextOfkin++;
				
				addr1_line4=checkForNull(rs.getString("addr1_line4")).trim();
				if(!addr1_line4.equals("")) nextOfkin++;
				
				postal1_code=checkForNull(rs.getString("postal1_code")).trim();
				if(!postal1_code.equals("")) nextOfkin++;
				
				country1_code=checkForNull(rs.getString("country1_code")).trim();
				if(!country1_code.equals("")) nextOfkin++;
				
				contact1_mob_tel_no=checkForNull(rs.getString("contact1_mob_tel_no")).trim();
				if(!contact1_mob_tel_no.equals("")) nextOfkin++;
				
				contact1_email_id=checkForNull(rs.getString("contact1_email_id")).trim();
				if(!contact1_email_id.equals("")) nextOfkin++;
				
				res1_tel_no=checkForNull(rs.getString("res1_tel_no")).trim();
				if(!res1_tel_no.equals("")) nextOfkin++;
				
				off1_tel_no=checkForNull(rs.getString("off1_tel_no")).trim();
				if(!off1_tel_no.equals("")) nextOfkin++;
				
				contact1_res_town_code=checkForNull(rs.getString("contact1_res_town_code")).trim();
				if(!contact1_res_town_code.equals("")) nextOfkin++;
				
				contact1_res_area_code=checkForNull(rs.getString("contact1_res_area_code")).trim();
				if(!contact1_res_area_code.equals("")) nextOfkin++;
				
				contact1_region_code=checkForNull(rs.getString("contact1_region_code")).trim();
				if(!contact1_region_code.equals("")) nextOfkin++;
				
				
				    								
		  }			
          if(stmt!=null) stmt.close();					
		  if(rs !=null) rs.close();
	  }catch(Exception e){
	    e.printStackTrace();
	  }
	  
	  return nextOfkin;
  } 
/*End this CRF ML-MMOH-CRF-0780*/	

	public static String checkForNull(String inputString)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
	}
}
