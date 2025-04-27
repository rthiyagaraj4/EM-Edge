/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**	This File contains all the SQL SELECT queries used in the MaintainBirthRegisterMain.jsp & 			NewbornRegistrationMain.jsp files.
  *	Last Modified Date 1/2/2006 4:13 PM 
  */

package eMP; 

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Properties;
import java.util.ArrayList;
import java.io.Serializable;
import webbeans.eCommon.ConnectionManager;

public class NewbornDetails implements Serializable
{
   /*	The static methos getNewbornData retrives Newborn Baby Mother Details.
	*	@Table mp_birth_register
	*	@Returns hashMap
	*	@Throws Exception
	*/
	
	public static HashMap getNewbornData(String motherid, Connection con, Properties p) throws Exception{
   // public static HashMap getNewbornData(String motherid, Connection con, Properties p,String mother_patient_id,String finalized_mult_birth_yn) throws Exception	{   
		PreparedStatement pstmt		= null;
		ResultSet rs				= null;	
		StringBuffer SelectSQLBuffer = null;
		
		HashMap hashMap = null;
		String locale = p.getProperty("LOCALE");
	    
		try
		{
			SelectSQLBuffer = new StringBuffer();
			hashMap	= new HashMap();
			
			/*Below query modified for this CRF ML-MMOH-CRF-0621*/
			
			SelectSQLBuffer.append("SELECT a.patient_id, a.pat_ser_grp_code, mp_get_desc.mp_pat_ser_grp(a.pat_ser_grp_code,?,2)  pat_ser_grp_desc, a.mother_patient_id, a.encounter_facility_id, a.mother_encounter_id, a.nb_sex, a.bba_yn, a.outcome, a.indicator_mark, to_char(a.time_of_birth,'hh24:mi') time_of_birth, to_char(a.time_of_birth,'dd/mm/yyyy') birth_date, to_char(a.time_of_birth,'dd/mm/yyyy hh24:mi') date_of_birth, a.weight, a.weight_unit, a.circumference, a.circumference_unit, a.length, a.length_unit, a.gestational_period, a.gestational_period_in_days, a.gestational_unit, a.apgar_score, a.umbilical_cord_status, a.patency_of_anus_yn, a.patency_of_anus_checked_by, am_get_desc.am_practitioner(a.patency_of_anus_checked_by,?,1) patency_of_anus_chkby_desc, a.multiple_birth_yn, a.birth_order, a.name_suffix, a.umb_cord_cut_by, am_get_desc.am_practitioner(a.umb_cord_cut_by,?,1) umb_cord_cut_by_desc, a.nod_type, (select delivery_indicator from mp_nod_type where nod_type = a.nod_type) delivery_indicator, a.gravida, a.bcg_yn, a.vitamin_k_yn, a.hepb_yn, a.parity, a.cong_anomalies_code, mp_get_desc.mp_cong_anomalies(a.cong_anomalies_code,?,2) cong_anomalies_desc, a.administered_by, a.administered_designation, a.feeding, a.stools, a.complications, a.community_nurse_id, a.attend_physician_id, am_get_desc.am_practitioner(a.attend_physician_id,?,1) attend_physician_desc, a.attend_midwife_id, am_get_desc.am_practitioner(a.attend_midwife_id,?,1) attend_midwife_desc,  a.father_patient_id, a.father_name, a.compln_dely_code, mp_get_desc.mp_compln_delivery(a.compln_dely_code,?,2) compln_dely_desc, a.nb_compln_dely_code, mp_get_desc.mp_compln_delivery(a.nb_compln_dely_code,?,2) nb_compln_dely_desc, a.remarks, a.born_at, a.chest_circumference, a.apgar_score_in_5_mins, a.apgar_score_in_10_mins, a.father_national_id_no, a.father_oth_alt_id_type, a.father_oth_alt_id_no, a.father_nationality_code, MP_GET_DESC.MP_COUNTRY(a.father_nationality_code,?,'3') father_nationality_desc,  a.father_ethnic_group_code, MP_GET_DESC.MP_RACE(a.father_ethnic_group_code,?,'1') father_ethnic_group_desc, a.father_gove_employee_yn, a.father_religion_code, MP_GET_DESC.MP_RELIGION(a.father_religion_code,?,'2') q_father_religion_desc,   a.father_ocpn_class_code, a.mother_pmi_no, a.dely_ind_code, mp_get_desc.mp_dlvry_indication(a.dely_ind_code,?,2) dely_ind_desc, a.proc_class_code, mp_get_desc.mp_proc_classification(a.proc_class_code,?,2) proc_class_desc, a.vaginal_dely_type_code, mp_get_desc.mp_vaginal_dely_type(a.vaginal_dely_type_code,?,2) vaginal_dely_type_desc, a.dely_surg_class_code, mp_get_desc.mp_dely_surg_clfn(a.dely_surg_class_code,?,2) dely_surg_class_desc, a.birth_place_code, mp_get_desc.mp_birth_place(a.birth_place_code,?,1) birth_place_desc, a.birth_certificate_no, a.father_ocpn_code, a.father_remarks, a.father_ocpn_desc, a.vaccination_site, a.vitak_vacc_site,  a.vitak_administered_by, a.vitak_administered_desig, a.hepb_vacc_site, a.hepb_administered_by,  a.hepb_administered_desig, to_char(a.bcg_vacc_admn_date,'dd/mm/yyyy hh24:mi') bcg_vacc_admn_date, to_char(a.vitk_vacc_admn_date,'dd/mm/yyyy hh24:mi') vitk_vacc_admn_date, to_char(a.hepb_vacc_admn_date,'dd/mm/yyyy hh24:mi') hepb_vacc_admn_date, a.born_at_locn_type, a.born_at_locn_code, a.father_alt_id1_type, a.father_alt_id1_no, a.father_alt_id2_no, a.father_alt_id3_no, a.father_alt_id4_no,a.mother_encounter_id, a.ant_care_gvn_at, a.ant_care_locn_type, a.ant_care_locn_code, a.antenatal_care_yn, a.no_of_births, a.nb_name_prefix, a.nb_first_name, a.nb_second_name, a.nb_third_name, a.nb_family_name, a.nb_name_suffix, a.nb_patient_name, a.nb_name_prefix_loc_lang, a.nb_first_name_loc_lang, a.nb_second_name_loc_lang, a.nb_third_name_loc_lang, a.nb_family_name_loc_lang, a.nb_name_suffix_loc_lang, a.nb_patient_name_loc_lang, a.father_name_prefix, a.father_first_name, a.father_second_name, a.father_third_name, a.father_family_name, a.father_name_suffix, a.father_patient_name, a.father_name_prefix_loc_lang, a.father_first_name_loc_lang, a.father_second_name_loc_lang, a.father_third_name_loc_lang, a.father_family_name_loc_lang, a.father_name_suffix_loc_lang, a.father_patient_name_loc_lang, a.compln_pregnancy_code, mp_get_desc.mp_compln_pregnancy(a.compln_pregnancy_code,?,2) compln_pregnancy_desc, a.complns_1st_stage_labour_code, a.complns_2nd_stage_labour_code, a.complns_3rd_stage_labour_code, a.compln_nr_pregnancy_code, mp_get_desc.mp_compln_pregnancy(a.compln_nr_pregnancy_code,?,2) compln_nr_pregnancy_desc, a.heart_rate_in_1_min, a.heart_rate_in_5_min, a.heart_rate_in_10_min, a.breathing_in_1_min, a.breathing_in_5_min, a.breathing_in_10_min, a.grimace_in_1_min, a.grimace_in_5_min, a.grimace_in_10_min, a.activity_in_1_min, a.activity_in_5_min, a.activity_in_10_min, a.appearance_in_1_min, a.appearance_in_5_min, a.appearance_in_10_min, a.finalized_yn, to_char(a.lmp,'dd/mm/yyyy') lmp, a.mc_cycle_no, b.relationship_to_head relation_code, mp_get_desc.mp_relationship(b.relationship_to_head,?,2) relation_desc, b.pat_cat_code pat_cat_code, b.family_org_sub_id, b.family_org_id, b.family_org_membership, b.alt_id1_no, b.family_link_no, c.blood_grp, c.rh_factor,a.father_pat_long_name father_pat_long_name,a.father_pat_long_name_loc_lang father_pat_long_name_loc_lang,a.hijri_birth_date hijri_birth_date,a.ACCESSION_NUM,a.parity_on_admission, a.resuscitated_pract_id, am_get_desc.am_practitioner(a.resuscitated_pract_id,?,1) resuscitated_pract_desc, a.EMER_REGN_NB_YN,a.MOTHER_WITNESSED_BY1 ,a.MOTHER_WITNESSED_BY2,a.MOTHER_ALIVE_YN,a.ACCESSION_NUM_NB_NOTE, mp_get_desc.mp_compln_pregnancy(a.compln_pregnancy_code,?,1) compln_pregnancy_long_desc, mp_get_desc.mp_compln_pregnancy(a.compln_nr_pregnancy_code,?,1) compln_nr_pregnancy_long_desc, mp_get_desc.mp_compln_delivery(a.compln_dely_code,?,1) compln_dely_long_desc, mp_get_desc.mp_compln_delivery(a.nb_compln_dely_code,?,1) nb_compln_del_long_desc, mp_get_desc.mp_dlvry_indication(a.dely_ind_code,?,1) dely_ind_long_desc, mp_get_desc.mp_proc_classification(a.proc_class_code,?,1) proc_class_long_desc, mp_get_desc.mp_vaginal_dely_type(a.vaginal_dely_type_code,?,1) vaginal_del_type_long_desc, mp_get_desc.mp_dely_surg_clfn(a.dely_surg_class_code,?,1) dely_surg_class_long_desc, mp_get_desc.mp_cong_anomalies(a.cong_anomalies_code,?,1) cong_anomalies_long_desc,parity1 FROM mp_birth_register a, mp_patient b, mp_pat_oth_dtls c WHERE a.patient_id = ? and a.patient_id = b.patient_id and a.patient_id = c.patient_id ");
			//Modified by Sangeetha for ML-MMOH-CRF-0631 on 14/Aug/17
			//Modified by Rameswar on 20-Jan-16 for ML-MMOH-CRF-0382
			//Modified by Ashwini on 03-Nov-2016 for MO-CRF-20108
			//Modified by Ashwini on 01-Feb-2019 for ML-MMOH-CRF-1109
			
			pstmt	= con.prepareStatement(SelectSQLBuffer.toString());
			pstmt.setString(1,locale);
			pstmt.setString(2,locale);
			pstmt.setString(3,locale);
			pstmt.setString(4,locale);
			pstmt.setString(5,locale);
			pstmt.setString(6,locale);
			pstmt.setString(7,locale);
			pstmt.setString(8,locale);
			pstmt.setString(9,locale);
			pstmt.setString(10,locale);
			pstmt.setString(11,locale);
			pstmt.setString(12,locale);
			pstmt.setString(13,locale);
			pstmt.setString(14,locale);
			pstmt.setString(15,locale);
			pstmt.setString(16,locale);
			pstmt.setString(17,locale);
			pstmt.setString(18,locale);
			pstmt.setString(19,locale);			
			pstmt.setString(20,locale); //Added for this CRF ML-MMOH-CRF-0621	
			/*Added by Ashwini on 01-Feb-2019 for ML-MMOH-CRF-1109*/
			pstmt.setString(21,locale);	
			pstmt.setString(22,locale);	
			pstmt.setString(23,locale);	
			pstmt.setString(24,locale);	
			pstmt.setString(25,locale);	
			pstmt.setString(26,locale);	
			pstmt.setString(27,locale);	
			pstmt.setString(28,locale);	
			pstmt.setString(29,locale);	
			/*End ML-MMOH-CRF-1109*/
			pstmt.setString(30,motherid);

            rs		= pstmt.executeQuery();

            while(rs != null && rs.next()) { 

				hashMap.put("ant_care_gvn_at",			checkForNull(rs.getString("ant_care_gvn_at")));
				hashMap.put("ant_care_locn_type",			checkForNull(rs.getString("ant_care_locn_type")));
				hashMap.put("ant_care_locn_code",			checkForNull(rs.getString("ant_care_locn_code")));
				hashMap.put("antenatal_care_yn",			checkForNull(rs.getString("antenatal_care_yn")));
				hashMap.put("q_accession_num",			checkForNull(rs.getString("accession_num"))); //Added by Ashwini for MO-CRF-20108
				hashMap.put("q_patient_id",			checkForNull(rs.getString("patient_id")));
				hashMap.put("q_pat_ser_grp_code",	checkForNull(rs.getString("pat_ser_grp_code")));
				hashMap.put("q_pat_ser_grp_desc",	checkForNull(rs.getString("pat_ser_grp_desc")));
				hashMap.put("q_mother_patient_id",	checkForNull(rs.getString("mother_patient_id")));
				hashMap.put("q_nb_sex",				checkForNull(rs.getString("nb_sex")));
				hashMap.put("q_bba_yn",				checkForNull(rs.getString("bba_yn")));
				hashMap.put("q_Umb_cord_cut_by",	rs.getString("umb_cord_cut_by"));
				hashMap.put("q_umb_cord_cut_by_desc",	rs.getString("umb_cord_cut_by_desc"));
				hashMap.put("q_outcome",			checkForNull(rs.getString("outcome")));
				hashMap.put("q_mother_pmi_no",		checkForNull(rs.getString("mother_pmi_no")));
				hashMap.put("q_delivery_indication",checkForNull(rs.getString("dely_ind_code")));
				hashMap.put("q_dely_ind_desc",checkForNull(rs.getString("dely_ind_desc")));
				hashMap.put("q_proc_class_code",	checkForNull(rs.getString("proc_class_code")));
				hashMap.put("q_proc_class_desc",	checkForNull(rs.getString("proc_class_desc")));
				hashMap.put("q_vaginal_del_type_code",checkForNull(rs.getString("vaginal_dely_type_code")));
				hashMap.put("q_vaginal_dely_type_desc",checkForNull(rs.getString("vaginal_dely_type_desc")));
				hashMap.put("q_del_serv_class",	checkForNull(rs.getString("dely_surg_class_code")));
				hashMap.put("q_dely_surg_class_desc",	rs.getString("dely_surg_class_desc"));
				hashMap.put("q_Birth_place_code",	checkForNull(rs.getString("birth_place_code")));
				hashMap.put("q_birth_place_desc",	rs.getString("birth_place_desc"));
				hashMap.put("q_birth_cert_no",	checkForNull(rs.getString("birth_certificate_no")));
				hashMap.put("q_indicator_mark",		checkForNull(rs.getString("indicator_mark")));
				hashMap.put("q_weight",				checkForNull(rs.getString("weight")));
				hashMap.put("q_circumference",		checkForNull(rs.getString("circumference")));
				hashMap.put("q_COMPLN_DELY_CODE",	checkForNull(rs.getString("compln_dely_code")));
				hashMap.put("q_compln_dely_desc",	checkForNull(rs.getString("compln_dely_desc")));
				hashMap.put("q_length",				checkForNull(rs.getString("length")));
				hashMap.put("q_gestational_period",	checkForNull(rs.getString("gestational_period")));
				hashMap.put("q_gestational_period_days",	checkForNull(rs.getString("gestational_period_in_days")));
				hashMap.put("q_apgar_score",		checkForNull(rs.getString("apgar_score")));
				hashMap.put("q_umbilical_cord_status",checkForNull(rs.getString("umbilical_cord_status")));
				hashMap.put("q_patency_of_anus_yn",	checkForNull(rs.getString("patency_of_anus_yn")));
				//Added by Rameswar on 20-Jan-16 for ML-MMOH-CRF-0382
				hashMap.put("patency_of_anus_checked_by_id",	checkForNull(rs.getString("patency_of_anus_checked_by")));
				hashMap.put("patency_of_anus_checked_by_desc",	checkForNull(rs.getString("patency_of_anus_chkby_desc")));
				//Added by Rameswar on 20-Jan-16 for ML-MMOH-CRF-0382
				hashMap.put("q_type_delivery",		checkForNull(rs.getString("nod_type")));
				hashMap.put("q_multiple_birth_yn",	checkForNull(rs.getString("multiple_birth_yn")));
				hashMap.put("q_birth_order",		checkForNull(rs.getString("birth_order")));
				hashMap.put("q_cong_anomalies_code",checkForNull(rs.getString("cong_anomalies_code")));
				hashMap.put("q_cong_anomalies_desc",checkForNull(rs.getString("cong_anomalies_desc")));
				hashMap.put("q_administered_by",	checkForNull(rs.getString("administered_by")));
				hashMap.put("q_vitak_administered_by",checkForNull(rs.getString("vitak_administered_by")));
				hashMap.put("q_hepb_administered_by",checkForNull(rs.getString("hepb_administered_by")));
				hashMap.put("q_administered_designation",checkForNull(rs.getString("administered_designation")));
				hashMap.put("q_vitak_administered_designation",checkForNull(rs.getString("vitak_administered_desig")));
				hashMap.put("q_hepb_administered_designation",checkForNull(rs.getString("hepb_administered_desig")));
				hashMap.put("q_bcg_datetime",		checkForNull(rs.getString("bcg_vacc_admn_date")));
				hashMap.put("q_vitk_datetime",		checkForNull(rs.getString("vitk_vacc_admn_date")));
				hashMap.put("q_hepb_datetime",		checkForNull(rs.getString("hepb_vacc_admn_date")));
				hashMap.put("q_born_at_locn_type",	checkForNull(rs.getString("born_at_locn_type")));
				hashMap.put("q_born_at_locn_code",	checkForNull(rs.getString("born_at_locn_code")));
				hashMap.put("q_nod_type",			checkForNull(rs.getString("nod_type")));
				hashMap.put("q_delivery_indicator",	checkForNull(rs.getString("delivery_indicator")));
				hashMap.put("q_gravida",			checkForNull(rs.getString("gravida")));
				hashMap.put("q_parity",				checkForNull(rs.getString("parity")));
				hashMap.put("q_feeding",			checkForNull(rs.getString("feeding")));
				hashMap.put("q_stools",				checkForNull(rs.getString("stools")));
				hashMap.put("q_vaccination_site",	checkForNull(rs.getString("vaccination_site")));
				hashMap.put("q_vitak_vaccination_site",	checkForNull(rs.getString("vitak_vacc_site")));
				hashMap.put("q_hepb_vaccination_site",	checkForNull(rs.getString("hepb_vacc_site")));
				hashMap.put("q_bcg_given_yn",			checkForNull(rs.getString("bcg_yn")));
				hashMap.put("q_vitak_given_yn",			checkForNull(rs.getString("vitamin_k_yn")));
				hashMap.put("q_hep_given_yn",			checkForNull(rs.getString("hepb_yn")));
				hashMap.put("q_complications_delivery_nb",checkForNull(rs.getString("nb_compln_dely_code")));
				hashMap.put("q_nb_compln_dely_desc",checkForNull(rs.getString("nb_compln_dely_desc")));
				hashMap.put("q_attend_physician_id", rs.getString("attend_physician_id"));
				hashMap.put("q_attend_physician_desc", rs.getString("attend_physician_desc"));
				hashMap.put("q_attend_midwife_id",	checkForNull(rs.getString("attend_midwife_id")));
				hashMap.put("q_attend_midwife_desc",	rs.getString("attend_midwife_desc"));
				hashMap.put("q_father_patient_id",	checkForNull(rs.getString("father_patient_id")));
				hashMap.put("q_father_name",		checkForNull(rs.getString("father_name")));
				hashMap.put("q_father_name_long",		checkForNull(rs.getString("father_pat_long_name")));
				hashMap.put("q_father_name_long_loc_lang",		checkForNull(rs.getString("father_pat_long_name_loc_lang")));

				hashMap.put("q_FATHER_NATIONAL_ID_NO",checkForNull(rs.getString("father_national_id_no")));	hashMap.put("q_FATHER_OTH_ALT_ID_TYPE",checkForNull(rs.getString("father_oth_alt_id_type")));
				hashMap.put("q_FATHER_OTH_ALT_ID_NO",checkForNull(rs.getString("father_oth_alt_id_no")));
				hashMap.put("q_FATHER_NATIONALITY_CODE",checkForNull(rs.getString("father_nationality_code")));
				hashMap.put("q_father_nationality_desc",checkForNull(rs.getString("father_nationality_desc")));
				hashMap.put("q_FATHER_ETHNIC_GROUP_CODE",checkForNull(rs.getString("father_ethnic_group_code")));
				hashMap.put("q_father_ethnic_group_desc",checkForNull(rs.getString("father_ethnic_group_desc")));
				hashMap.put("q_FATHER_GOVE_EMPLOYEE_YN",checkForNull(rs.getString("father_gove_employee_yn")));
				hashMap.put("q_FATHER_RELIGION_CODE",checkForNull(rs.getString("father_religion_code")));
				hashMap.put("q_father_religion_desc",checkForNull(rs.getString("q_father_religion_desc")));
				hashMap.put("q_FATHER_OCPN_CLASS_CODE",checkForNull(rs.getString("father_ocpn_class_code")));
				hashMap.put("q_FATHER_OCPN_CODE",	checkForNull(rs.getString("father_ocpn_code")));
				hashMap.put("q_FATHER_REMARKS",		checkForNull(rs.getString("father_remarks")));
				hashMap.put("q_FATHER_OCPN_DESC",	checkForNull(rs.getString("father_ocpn_desc")));
				hashMap.put("q_remarks",			checkForNull(rs.getString("remarks")));
				hashMap.put("q_chest_circumference", checkForNull(rs.getString("chest_circumference")));
				hashMap.put("q_apgar_score_in_5_mins",checkForNull(rs.getString("apgar_score_in_5_mins")));
				hashMap.put("q_apgar_score_in_10_mins",checkForNull(rs.getString("apgar_score_in_10_mins")));
				hashMap.put("q_date_of_birth", checkForNull(rs.getString("date_of_birth")));
				hashMap.put("q_father_alt_id1_type", checkForNull(rs.getString("father_alt_id1_type")));
				hashMap.put("q_father_alt_id1_no",	 checkForNull(rs.getString("father_alt_id1_no")));
				hashMap.put("q_father_alt_id2_no",	 checkForNull(rs.getString("father_alt_id2_no")));
				hashMap.put("q_father_alt_id3_no",	 checkForNull(rs.getString("father_alt_id3_no")));
				hashMap.put("q_father_alt_id4_no",	 checkForNull(rs.getString("father_alt_id4_no")));
				hashMap.put("q_mother_encounter_id",	 checkForNull(rs.getString("mother_encounter_id")));
				hashMap.put("q_no_of_birth",	checkForNull(rs.getString("no_of_births"), "0"));

				hashMap.put("nb_name_prefix",	checkForNull(rs.getString("nb_name_prefix"), ""));
				hashMap.put("nb_first_name",	checkForNull(rs.getString("nb_first_name"), ""));
				hashMap.put("nb_second_name",	checkForNull(rs.getString("nb_second_name"), ""));
				hashMap.put("nb_third_name",	checkForNull(rs.getString("nb_third_name"), ""));
				hashMap.put("nb_family_name",	checkForNull(rs.getString("nb_family_name"), ""));
				hashMap.put("nb_name_suffix",	checkForNull(rs.getString("nb_name_suffix"), ""));
				hashMap.put("nb_patient_name",	checkForNull(rs.getString("nb_patient_name"), ""));
				hashMap.put("nb_name_prefix_loc_lang",	checkForNull(rs.getString("nb_name_prefix_loc_lang"), ""));
				hashMap.put("nb_first_name_loc_lang",	checkForNull(rs.getString("nb_first_name_loc_lang"), ""));
				hashMap.put("nb_second_name_loc_lang",	checkForNull(rs.getString("nb_second_name_loc_lang"), ""));
				hashMap.put("nb_third_name_loc_lang",	checkForNull(rs.getString("nb_third_name_loc_lang"), ""));
				hashMap.put("nb_family_name_loc_lang",	checkForNull(rs.getString("nb_family_name_loc_lang"), ""));
				hashMap.put("nb_name_suffix_loc_lang",	checkForNull(rs.getString("nb_name_suffix_loc_lang"), ""));
				hashMap.put("nb_patient_name_loc_lang",	checkForNull(rs.getString("nb_patient_name_loc_lang"), ""));
				hashMap.put("father_name_prefix",	checkForNull(rs.getString("father_name_prefix"), ""));
				hashMap.put("father_first_name",	checkForNull(rs.getString("father_first_name"), ""));
				hashMap.put("father_second_name",	checkForNull(rs.getString("father_second_name"), ""));
				hashMap.put("father_third_name",	checkForNull(rs.getString("father_third_name"), ""));
				hashMap.put("father_family_name",	checkForNull(rs.getString("father_family_name"), ""));
				hashMap.put("father_name_suffix",	checkForNull(rs.getString("father_name_suffix"), ""));
				hashMap.put("father_patient_name",	checkForNull(rs.getString("father_patient_name"), ""));
				hashMap.put("father_name_prefix_loc_lang",	checkForNull(rs.getString("father_name_prefix_loc_lang"), ""));
				hashMap.put("father_first_name_loc_lang",	checkForNull(rs.getString("father_first_name_loc_lang"), ""));
				hashMap.put("father_second_name_loc_lang",	checkForNull(rs.getString("father_second_name_loc_lang"), ""));
				hashMap.put("father_third_name_loc_lang",	checkForNull(rs.getString("father_third_name_loc_lang"), ""));
				hashMap.put("father_family_name_loc_lang",	checkForNull(rs.getString("father_family_name_loc_lang"), ""));
				hashMap.put("father_name_suffix_loc_lang",	checkForNull(rs.getString("father_name_suffix_loc_lang"), ""));
				hashMap.put("father_patient_name_loc_lang",	checkForNull(rs.getString("father_patient_name_loc_lang"), ""));

				hashMap.put("q_compln_pregnancy_code", rs.getString("compln_pregnancy_code"));
				hashMap.put("q_compln_pregnancy_desc", rs.getString("compln_pregnancy_desc"));
				hashMap.put("q_compln_nr_pregnancy_code", rs.getString("compln_nr_pregnancy_code"));
				hashMap.put("q_compln_nr_pregnancy_desc", rs.getString("compln_nr_pregnancy_desc"));


				hashMap.put("complns_1st_stage_labour_code", checkForNull(rs.getString("complns_1st_stage_labour_code"),""));
				hashMap.put("complns_2nd_stage_labour_code", checkForNull(rs.getString("complns_2nd_stage_labour_code"),""));
				hashMap.put("complns_3rd_stage_labour_code", checkForNull(rs.getString("complns_3rd_stage_labour_code"),""));

				hashMap.put("q_finalized_yn", checkForNull(rs.getString("finalized_yn"),"N"));
				hashMap.put("heart_rate_in_1_min", checkForNull(rs.getString("heart_rate_in_1_min"),""));
				hashMap.put("heart_rate_in_5_min", checkForNull(rs.getString("heart_rate_in_5_min"),""));
				hashMap.put("heart_rate_in_10_min", checkForNull(rs.getString("heart_rate_in_10_min"),""));
				hashMap.put("breathing_in_1_min", checkForNull(rs.getString("breathing_in_1_min"),""));
				hashMap.put("breathing_in_5_min", checkForNull(rs.getString("breathing_in_5_min"),""));
				hashMap.put("breathing_in_10_min", checkForNull(rs.getString("breathing_in_10_min"),""));
				hashMap.put("grimace_in_1_min", checkForNull(rs.getString("grimace_in_1_min"),""));
				hashMap.put("grimace_in_5_min", checkForNull(rs.getString("grimace_in_5_min"),""));
				hashMap.put("grimace_in_10_min", checkForNull(rs.getString("grimace_in_10_min"),""));
				hashMap.put("activity_in_1_min", checkForNull(rs.getString("activity_in_1_min"),""));
				hashMap.put("activity_in_5_min", checkForNull(rs.getString("activity_in_5_min"),""));
				hashMap.put("activity_in_10_min", checkForNull(rs.getString("activity_in_10_min"),""));
				hashMap.put("appearance_in_1_min", checkForNull(rs.getString("appearance_in_1_min"),""));
				hashMap.put("appearance_in_5_min", checkForNull(rs.getString("appearance_in_5_min"),""));
				hashMap.put("appearance_in_10_min", checkForNull(rs.getString("appearance_in_10_min"),""));
				hashMap.put("q_lmp", checkForNull(rs.getString("lmp"),""));
				hashMap.put("q_mc_cycle_no", checkForNull(rs.getString("mc_cycle_no"),"0"));
				hashMap.put("relation_code", checkForNull(rs.getString("relation_code")));
				hashMap.put("relation_desc", checkForNull(rs.getString("relation_desc")));
				hashMap.put("pat_cat_code", checkForNull(rs.getString("pat_cat_code")));

				hashMap.put("family_org_sub_id", checkForNull(rs.getString("family_org_sub_id")));
				hashMap.put("family_org_id", checkForNull(rs.getString("family_org_id")));
				hashMap.put("family_org_membership", checkForNull(rs.getString("family_org_membership")));
				hashMap.put("alt_id1_no", checkForNull(rs.getString("alt_id1_no")));
				hashMap.put("family_link_no", checkForNull(rs.getString("family_link_no")));
				hashMap.put("blood_grp", checkForNull(rs.getString("blood_grp")));
				hashMap.put("rh_factor", checkForNull(rs.getString("rh_factor")));
				//Added MMS-QH-CRF-0145.1 [IN:047497]				
				hashMap.put("hijri_birth_date", checkForNull(rs.getString("hijri_birth_date")));
				/*Below line modified for this CRF ML-MMOH-CRF-0621*/
				hashMap.put("parity_on_admission", checkForNull(rs.getString("parity_on_admission")));
				hashMap.put("resuscitated_pract_id", checkForNull(rs.getString("resuscitated_pract_id")));
				hashMap.put("resuscitated_pract_desc", checkForNull(rs.getString("resuscitated_pract_desc"))); 
				//Added by Sangeetha for ML-MMOH-CRF-0631 on 14/Aug/17
				hashMap.put("emer_regn_nb_yn", checkForNull(rs.getString("EMER_REGN_NB_YN"))); 
				hashMap.put("mother_witnessed_by1", checkForNull(rs.getString("MOTHER_WITNESSED_BY1"))); 
				hashMap.put("mother_witnessed_by2", checkForNull(rs.getString("MOTHER_WITNESSED_BY2"))); 
				hashMap.put("mother_alive_yn", checkForNull(rs.getString("MOTHER_ALIVE_YN"),"Y")); 
				hashMap.put("accession_num_nb_note", checkForNull(rs.getString("ACCESSION_NUM_NB_NOTE"))); 
				
				/*Added by Ashwini on 01-Feb-2019 for ML-MMOH-CRF-1109*/
				hashMap.put("compln_pregnancy_long_desc",checkForNull(rs.getString("compln_pregnancy_long_desc")));
				hashMap.put("compln_nr_pregnancy_long_desc",checkForNull(rs.getString("compln_nr_pregnancy_long_desc")));
				hashMap.put("compln_dely_long_desc",checkForNull(rs.getString("compln_dely_long_desc")));
				hashMap.put("nb_compln_del_long_desc",checkForNull(rs.getString("nb_compln_del_long_desc")));
				hashMap.put("dely_ind_long_desc",checkForNull(rs.getString("dely_ind_long_desc")));
				hashMap.put("proc_class_long_desc",checkForNull(rs.getString("proc_class_long_desc")));
				hashMap.put("vaginal_del_type_long_desc",checkForNull(rs.getString("vaginal_del_type_long_desc")));
				hashMap.put("dely_surg_class_long_desc",checkForNull(rs.getString("dely_surg_class_long_desc")));
				hashMap.put("cong_anomalies_long_desc",checkForNull(rs.getString("cong_anomalies_long_desc")));
				hashMap.put("q_parity1",checkForNull(rs.getString("parity1")));  //68508
				/*End ML-MMOH-CRF-1109*/
			}


			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();

			if(((String)(hashMap.get("q_outcome")==null?"":hashMap.get("q_outcome"))).equals("S")){
				String still_birth_details="select auth_practitioner_id, attendant_at_birth, autopsy_reqd_yn, mate_cond_main_cod, mate_cond_main_cod_dur, mate_cond_oth_cod, mate_cond_oth_cod_dur, mate_cond_preexist_cod, mate_cond_preexist_cod_dur, oth_rel_mate_cond_rel_cod, oth_rel_mate_cond_rel_cod_dur, cond_cau_dea_main_cod, cond_cau_dea_main_cod_dur, cond_cau_dea_oth_cod, cond_cau_dea_oth_cod_dur, cond_cau_dea_preexist_cod, cond_cau_dea_preexist_cod_dur, rel_cond_cau_dea_rel_cod, rel_cond_cau_dea_rel_cod_dur from mp_still_birth_details where patient_id='"+motherid+"'";
				pstmt	= con.prepareStatement(still_birth_details.toString());
				rs		= pstmt.executeQuery();
				if(rs!=null && rs.next()){
					hashMap.put("auth_practitioner_id", checkForNull(rs.getString("auth_practitioner_id"),""));
					hashMap.put("attendant_at_birth", checkForNull(rs.getString("attendant_at_birth"),""));
					hashMap.put("autopsy_reqd_yn", checkForNull(rs.getString("autopsy_reqd_yn"),""));
					hashMap.put("mate_cond_main_cod", checkForNull(rs.getString("mate_cond_main_cod"),""));
					hashMap.put("mate_cond_main_cod_dur", checkForNull(rs.getString("mate_cond_main_cod_dur"),""));
					hashMap.put("mate_cond_oth_cod", checkForNull(rs.getString("mate_cond_oth_cod"),""));
					hashMap.put("mate_cond_oth_cod_dur", checkForNull(rs.getString("mate_cond_oth_cod_dur"),""));
					hashMap.put("mate_cond_preexist_cod", checkForNull(rs.getString("mate_cond_preexist_cod"),""));
					hashMap.put("mate_cond_preexist_cod_dur", checkForNull(rs.getString("mate_cond_preexist_cod_dur"),""));
					hashMap.put("oth_rel_mate_cond_rel_cod", checkForNull(rs.getString("oth_rel_mate_cond_rel_cod"),""));
					hashMap.put("oth_rel_mate_cond_rel_cod_dur", checkForNull(rs.getString("oth_rel_mate_cond_rel_cod_dur"),""));
					hashMap.put("cond_cau_dea_main_cod", checkForNull(rs.getString("cond_cau_dea_main_cod"),""));
					hashMap.put("cond_cau_dea_main_cod_dur", checkForNull(rs.getString("cond_cau_dea_main_cod_dur"),""));
					hashMap.put("cond_cau_dea_oth_cod", checkForNull(rs.getString("cond_cau_dea_oth_cod"),""));
					hashMap.put("cond_cau_dea_oth_cod_dur", checkForNull(rs.getString("cond_cau_dea_oth_cod_dur"),""));
					hashMap.put("cond_cau_dea_preexist_cod", checkForNull(rs.getString("cond_cau_dea_preexist_cod"),""));
					hashMap.put("cond_cau_dea_preexist_cod_dur", checkForNull(rs.getString("cond_cau_dea_preexist_cod_dur"),""));
					hashMap.put("rel_cond_cau_dea_rel_cod", checkForNull(rs.getString("rel_cond_cau_dea_rel_cod"),""));
					hashMap.put("rel_cond_cau_dea_rel_cod_dur", checkForNull(rs.getString("rel_cond_cau_dea_rel_cod_dur"),""));
				}
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

	/*	The static methos getNewbornData retrives Newborn Baby Mother Details.
	*	@Table mp_birth_register
	*	@Returns hashMap
	*	@Throws Exception
	*/

	public static HashMap getMotherData(Connection con, Properties p, String mother_id) throws Exception
	{
		PreparedStatement pstmt		= null;
		ResultSet rs		= null;
		HashMap motherData	= null;
        String locale = p.getProperty("LOCALE");
		try	{
			motherData = new HashMap();
			
			//String sql = " SELECT decode(?, 'en', a.patient_name, nvl(a.patient_name_loc_lang, a.patient_name)) patient_name, to_char(a.date_of_birth, 'dd/mm/yyyy') mother_date_of_birth, a.relationship_to_head relation_code,mp_get_desc.mp_alternate_id_type(oth_alt_id_type,?,1) oth_alt_id_type, mp_get_desc.mp_relationship(a.relationship_to_head,?,2) relation_desc, (select round(abs(sysdate - max(TIME_OF_BIRTH))*24,0) FROM mp_birth_register WHERE mother_patient_id = ?) diffHours, a.national_id_no,a.OTH_ALT_ID_NO, a.alt_id1_no, a.alt_id1_type,a.alt_id2_no, a.alt_id2_type,a.alt_id3_no, a.alt_id3_type,a.alt_id4_no, a.alt_id4_type, a.family_org_sub_id, a.family_org_id, a.family_link_no, a.family_org_membership, a.pat_cat_code pat_cat_code, a.OTH_ALT_ID_TYPE mthr_oth_alt_id_type FROM mp_patient a WHERE a.patient_id = ? ";				
			String sql = " SELECT decode(?, 'en', a.patient_name, nvl(a.patient_name_loc_lang, a.patient_name)) patient_name, to_char(a.date_of_birth, 'dd/mm/yyyy') mother_date_of_birth, a.relationship_to_head relation_code,mp_get_desc.mp_alternate_id_type(oth_alt_id_type,?,1) oth_alt_id_type, mp_get_desc.mp_relationship(a.relationship_to_head,?,2) relation_desc, (select round(abs(sysdate - max(TIME_OF_BIRTH))*24,0) FROM mp_birth_register WHERE mother_patient_id = ?) diffHours, a.national_id_no,a.OTH_ALT_ID_NO, a.alt_id1_no, a.alt_id1_type,a.alt_id2_no, a.alt_id2_type,a.alt_id3_no, a.alt_id3_type,a.alt_id4_no, a.alt_id4_type, a.family_org_sub_id, a.family_org_id, a.family_link_no, a.family_org_membership, a.pat_cat_code pat_cat_code, a.OTH_ALT_ID_TYPE mthr_oth_alt_id_type, a.sex, CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),1) patient_age FROM mp_patient a WHERE a.patient_id = ? ";//modfiedi by Jeyachitra ML-MMOH-CRF-1759.1

			pstmt	= con.prepareStatement(sql);
			pstmt.setString(1,locale);
			pstmt.setString(2,locale);
			pstmt.setString(3,locale);
			pstmt.setString(4,mother_id);			
			pstmt.setString(5,mother_id);			

			rs	= pstmt.executeQuery();
			
			if( rs!=null && rs.next() ) {
				motherData.put("q_mother_patient_name", checkForNull(rs.getString("patient_name")));
				motherData.put("q_mother_date_of_birth",checkForNull(rs.getString("mother_date_of_birth")));
				motherData.put("relation_code",checkForNull(rs.getString("relation_code")));
				motherData.put("relation_desc",checkForNull(rs.getString("relation_desc")));
				motherData.put("diffHours",	checkForNull(rs.getString("diffHours"), "0"));
				motherData.put("mthr_alt_id1_no",	checkForNull(rs.getString("alt_id1_no")));
				motherData.put("mthr_alt_id2_no",	checkForNull(rs.getString("alt_id2_no")));
				motherData.put("mthr_alt_id3_no",	checkForNull(rs.getString("alt_id3_no")));
				motherData.put("mthr_alt_id4_no",	checkForNull(rs.getString("alt_id4_no")));
				motherData.put("mthr_nat_id_no",	checkForNull(rs.getString("national_id_no")));
				motherData.put("mthr_oth_alt_id_No",	checkForNull(rs.getString("oth_alt_id_No")));
				motherData.put("oth_alt_id_type", checkForNull(rs.getString("oth_alt_id_type")));
				motherData.put("mthr_oth_alt_id_type", checkForNull(rs.getString("mthr_oth_alt_id_type")));
				motherData.put("mthr_family_org_sub_id",	checkForNull(rs.getString("family_org_sub_id"))); 	
				motherData.put("mthr_family_org_id",	checkForNull(rs.getString("family_org_id")));			
				motherData.put("mthr_family_link_no",	checkForNull(rs.getString("family_link_no")));			
				motherData.put("mthr_family_org_membership",	checkForNull(rs.getString("family_org_membership"))); 	
				motherData.put("mthr_pat_cat_code",	checkForNull(rs.getString("pat_cat_code")));			
				motherData.put("patient_gender", checkForNull(rs.getString("sex"))); //Added by Jeyachitra ML-MMOH-CRF-1759.1 
				motherData.put("patient_age", checkForNull(rs.getString("patient_age")));  //Added by Jeyachitra ML-MMOH-CRF-1759.1
			}

			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close(); 			
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		} finally {
			//mPParamData.clear();
		}
		
		return motherData;
	}

	/*	The static methos getNewbornData retrives Newborn Baby Mother Details.
	*	@Table mp_birth_register
	*	@Returns hashMap
	*	@Throws Exception
	*/

	public static HashMap getMPParamDtls(Connection con, Properties p) throws Exception
	{
		PreparedStatement pstmt		= null;
		ResultSet rs		= null;
		HashMap mPParamData	= null;
        String locale = p.getProperty("LOCALE");
		
		try
		{
			mPParamData = new HashMap();
			//Below query modified for this CRF HSA-CRF-0182
            // Below query modified by Afruddin for ML-MMOH-CRF-1520 US0001
			//Below query modified by Ashwini on 12-Oct-2020 for ML-MMOH-CRF-1551 & ML-MMOH-CRF-1551.1
			String sql = " select nb_dflt_relnship_code,allow_nb_regn_within_days, allow_nb_regn_unit, to_char(sysdate-allow_nb_regn_within_days,'dd/mm/yyyy hh24:mi') sysdays, to_char(sysdate-allow_nb_regn_within_days/24,'dd/mm/yyyy hh24:mi') syshrs, to_char(sysdate,'dd/mm/yyyy hh24:mi') sysdatesys, to_char(sysdate,'dd/mm/yyyy') curr_date, org_member_relationship_code, family_org_id_accept_yn, family_no_link_yn, entitlement_by_pat_cat_yn, to_char(sysdate+alt_id1_exp_grace_days,'dd/mm/yyyy') alt_id1_exp_grace_days, to_char(sysdate+alt_id2_exp_grace_days,'dd/mm/yyyy') alt_id2_exp_grace_days, to_char(sysdate+alt_id3_exp_grace_days,'dd/mm/yyyy') alt_id3_exp_grace_days, to_char(sysdate+alt_id4_exp_grace_days,'dd/mm/yyyy') alt_id4_exp_grace_days, invoke_routine, nat_data_source_id, nat_id_check_digit_id, nat_id_chk_len, single_stage_nb_reg_appl_yn, data_upd_allowed_aft_final_yn, name_prefix_male_nb, name_prefix_female_nb, name_prefix_unknown_nb, name_suffix_male_nb, name_suffix_female_nb, nat_id_prompt, nat_id_length, accept_oth_alt_id_yn,accept_national_id_no_yn, patient_id_length, alt_id1_type,alt_id2_type,alt_id3_type,alt_id4_type, alt_id1_length,alt_id2_length,alt_id3_length,alt_id4_length,alt_id1_len_validation_yn, alt_id1_routine_yn, alt_id1_data_source_id, alt_id1_chk_digit_scheme, alt_id1_accept_alphanumeric_yn, min_weight, max_weight, min_chest_circum, max_chest_circum, min_head_circum, max_head_circum, min_length, max_length, min_gestation, max_gestation, pat_name_as_multipart_yn, nb_male_relnship, nb_female_relnship, nb_unknown_relnship,  nb_mother_cutoff_age, maintain_doc_or_file, race_required_yn, nb_min_gest_bet_2_dely, nat_id_accept_alphanumeric_yn, name_dervn_logic, name_dervn_logic_oth_lang, mp_get_desc.mp_alternate_id_type(alt_id1_type,?,1) alt_id1_type_desc, mp_get_desc.mp_alternate_id_type(alt_id2_type,?,1) alt_id2_type_desc, mp_get_desc.mp_alternate_id_type(alt_id3_type,?,1) alt_id3_type_desc, mp_get_desc.mp_alternate_id_type(alt_id4_type,?,1) alt_id4_type_desc,unit_of_wt_nb, unit_of_circum_nb, unit_of_chest_circum_nb, unit_of_length_nb, unit_of_gest_nb, newborn_pat_ser_grp,  nb_use_mother_ser, accept_names_for_live_birth_yn, still_born_prefix, nb_father_name_mandatory_yn, name_prefix_accept_yn, name_prefix_reqd_yn, name_suffix_accept_yn, name_suffix_reqd_yn, first_name_accept_yn, first_name_prompt, first_name_reqd_yn, second_name_accept_yn, second_name_prompt, third_name_accept_yn, third_name_prompt, family_name_accept_yn, family_name_prompt, second_name_reqd_yn, third_name_reqd_yn, family_name_reqd_yn, pat_name_as_multipart_yn, name_suffix_prompt, name_prefix_prompt, family_name_order, first_name_order, second_name_order, third_name_order, first_name_length, second_name_length, third_name_length, family_name_length, family_name_loc_lang_prompt, name_suffix_loc_lang_prompt, first_name_loc_lang_prompt, second_name_loc_lang_prompt, third_name_loc_lang_prompt, name_prefix_loc_lang_prompt, names_in_oth_lang_yn, nb_father_min_age, create_file_at_pat_regn_yn, dflt_race_nat_setup_nb_as_per, citizen_nationality_code, default_race_code, (SELECT dflt_nb_regn_blng_class FROM bl_mp_param) dflt_nb_regn_blng_class, (SELECT name_prefix_loc_lang FROM mp_name_prefix where name_prefix = name_prefix_male_nb AND prefix_sex IN ('M', 'B')) name_pfx_loc_lang_male_nb, (SELECT name_prefix_loc_lang FROM mp_name_prefix where name_prefix = name_prefix_female_nb AND prefix_sex IN ('F', 'B')) name_pfx_loc_lang_female_nb, (SELECT name_prefix_loc_lang FROM mp_name_prefix where name_prefix = name_prefix_unknown_nb AND prefix_sex IN ('U', 'B')) name_pfx_loc_lang_unknown_nb, (SELECT name_suffix_loc_lang FROM mp_name_suffix where name_suffix = name_suffix_male_nb and baby_suffix_yn='Y' AND BABY_SEX IN ('M', 'B')) name_sfx_loc_lang_male_nb, (SELECT name_suffix_loc_lang FROM mp_name_suffix where name_suffix = name_suffix_female_nb and baby_suffix_yn='Y' AND BABY_SEX IN ('F', 'B')) name_sfx_loc_lang_female_nb,name_dervn_logic_long,name_dervn_logic_oth_lang_long,nb_mother_dtls_update_yn,name_dervn_logic_nb,name_dervn_logic_nb_sb,allow_ext_nb_regn_within_days from mp_param_lang_vw where module_id = 'MP' and language_id = ? ";

			pstmt	= con.prepareStatement(sql);
			pstmt.setString(1,locale);
			pstmt.setString(2,locale);
			pstmt.setString(3,locale);
			pstmt.setString(4,locale);
			pstmt.setString(5,locale);

			rs	= pstmt.executeQuery();	
			
			if( rs!=null && rs.next() ) {

				mPParamData.put("nb_dflt_relnship_code", rs.getString("nb_dflt_relnship_code"));
				mPParamData.put("allow_nb_regn_within_days", rs.getString("allow_nb_regn_within_days"));
				mPParamData.put("allow_nb_regn_unit", rs.getString("allow_nb_regn_unit"));

				String allow_nb_regn_unit = checkForNull(rs.getString("allow_nb_regn_unit"));
				if(allow_nb_regn_unit.equals("D"))
				{
					mPParamData.put("sysdays_reg",checkForNull(rs.getString("sysdays")));
				}
				else if(allow_nb_regn_unit.equals("H"))
				{
					mPParamData.put("sysdays_reg",checkForNull(rs.getString("syshrs")));
					
				}

				//mPParamData.put("sysdays", checkForNull(rs.getString("sysdays")));
				//mPParamData.put("syshrs", checkForNull(rs.getString("syshrs")));
				mPParamData.put("sysdatesys", checkForNull(rs.getString("sysdatesys")));
				mPParamData.put("curr_date", checkForNull(rs.getString("curr_date")));
				mPParamData.put("org_member_relationship_code",	checkForNull(rs.getString("org_member_relationship_code")));
				mPParamData.put("family_org_id_accept_yn",	checkForNull(rs.getString("family_org_id_accept_yn")));
				mPParamData.put("family_no_link_yn", checkForNull(rs.getString("family_no_link_yn")));
				mPParamData.put("entitlement_by_pat_cat_yn", checkForNull(rs.getString("entitlement_by_pat_cat_yn")));
				mPParamData.put("alt_id1_exp_grace_days", checkForNull(rs.getString("alt_id1_exp_grace_days")));
				mPParamData.put("alt_id2_exp_grace_days", checkForNull(rs.getString("alt_id2_exp_grace_days")));
				mPParamData.put("alt_id3_exp_grace_days", checkForNull(rs.getString("alt_id3_exp_grace_days")));
				mPParamData.put("alt_id4_exp_grace_days", checkForNull(rs.getString("alt_id4_exp_grace_days")));

				mPParamData.put("invoke_routine", checkForNull(rs.getString("invoke_routine")));
				mPParamData.put("nat_id_check_digit_id", checkForNull(rs.getString("nat_id_check_digit_id")));
				mPParamData.put("nat_id_chk_len", checkForNull(rs.getString("nat_id_chk_len")));
				mPParamData.put("single_stage_nb_reg_appl_yn", checkForNull(rs.getString("single_stage_nb_reg_appl_yn"),"N"));
				mPParamData.put("data_upd_allowed_aft_final_yn", checkForNull(rs.getString("data_upd_allowed_aft_final_yn")));
				mPParamData.put("name_prefix_male_nb", checkForNull(rs.getString("name_prefix_male_nb")));

				mPParamData.put("name_prefix_female_nb", checkForNull(rs.getString("name_prefix_female_nb")));
				mPParamData.put("name_prefix_unknown_nb", checkForNull(rs.getString("name_prefix_unknown_nb"))); //Added by Afruddin for ML-MMOH-CRF-1520 US 0001
				mPParamData.put("name_suffix_male_nb", checkForNull(rs.getString("name_suffix_male_nb")));
				mPParamData.put("name_suffix_female_nb", checkForNull(rs.getString("name_suffix_female_nb")));
				mPParamData.put("nat_id_prompt", checkForNull(rs.getString("nat_id_prompt")));
				mPParamData.put("nat_id_length", checkForNull(rs.getString("nat_id_length")));
                mPParamData.put("accept_national_id_no_yn", checkForNull(rs.getString("accept_national_id_no_yn")));
				mPParamData.put("accept_oth_alt_id_yn", checkForNull(rs.getString("accept_oth_alt_id_yn")));
				mPParamData.put("patient_id_length", checkForNull(rs.getString("patient_id_length")));
				mPParamData.put("alt_id1_type", checkForNull(rs.getString("alt_id1_type")));
				mPParamData.put("alt_id2_type", checkForNull(rs.getString("alt_id2_type")));
				mPParamData.put("alt_id3_type", checkForNull(rs.getString("alt_id3_type")));
				mPParamData.put("alt_id4_type", checkForNull(rs.getString("alt_id4_type")));
				mPParamData.put("alt_id1_length", checkForNull(rs.getString("alt_id1_length")));
				mPParamData.put("alt_id2_length", checkForNull(rs.getString("alt_id2_length")));
				mPParamData.put("alt_id3_length", checkForNull(rs.getString("alt_id3_length")));
				mPParamData.put("alt_id4_length", checkForNull(rs.getString("alt_id4_length")));
				mPParamData.put("alt_id1_len_validation_yn", checkForNull(rs.getString("alt_id1_len_validation_yn")));
				mPParamData.put("alt_id1_routine_yn", checkForNull(rs.getString("alt_id1_routine_yn")));
				mPParamData.put("alt_id1_data_source_id", checkForNull(rs.getString("alt_id1_data_source_id")));
				mPParamData.put("alt_id1_chk_digit_scheme", checkForNull(rs.getString("alt_id1_chk_digit_scheme")));

				mPParamData.put("alt_id1_type_desc", checkForNull(rs.getString("alt_id1_type_desc")));
				mPParamData.put("alt_id2_type_desc", checkForNull(rs.getString("alt_id2_type_desc")));
				mPParamData.put("alt_id3_type_desc", checkForNull(rs.getString("alt_id3_type_desc")));
				mPParamData.put("alt_id4_type_desc", checkForNull(rs.getString("alt_id4_type_desc")));

				mPParamData.put("alt_id1_accept_alphanumeric_yn", checkForNull(rs.getString("alt_id1_accept_alphanumeric_yn")));

				mPParamData.put("min_weight", rs.getString("min_weight"));
				mPParamData.put("max_weight", rs.getString("max_weight"));
				mPParamData.put("min_chest_circum", rs.getString("min_chest_circum"));
				mPParamData.put("max_chest_circum", rs.getString("max_chest_circum"));
				mPParamData.put("min_head_circum", rs.getString("min_head_circum"));
				mPParamData.put("max_head_circum", rs.getString("max_head_circum"));

				mPParamData.put("min_length", rs.getString("min_length"));
				mPParamData.put("max_length", rs.getString("max_length"));
				mPParamData.put("min_gestation", rs.getString("min_gestation"));
				mPParamData.put("max_gestation", rs.getString("max_gestation"));
				mPParamData.put("pat_name_as_multipart_yn", rs.getString("pat_name_as_multipart_yn"));
				mPParamData.put("nb_male_relnship", rs.getString("nb_male_relnship")); 

				mPParamData.put("nb_male_relnship", checkForNull(rs.getString("nb_male_relnship")));
				mPParamData.put("nb_female_relnship", checkForNull(rs.getString("nb_female_relnship")));
				mPParamData.put("nb_unknown_relnship", checkForNull(rs.getString("nb_unknown_relnship")));

				mPParamData.put("nb_mother_cutoff_age", checkForNull(rs.getString("nb_mother_cutoff_age")));
				mPParamData.put("maintain_doc_or_file", checkForNull(rs.getString("maintain_doc_or_file")));
				mPParamData.put("race_required_yn", checkForNull(rs.getString("race_required_yn")));

				mPParamData.put("nb_min_gest_bet_2_dely", rs.getString("nb_min_gest_bet_2_dely"));
				mPParamData.put("nat_id_accept_alphanumeric_yn", checkForNull(rs.getString("nat_id_accept_alphanumeric_yn")));
				mPParamData.put("name_dervn_logic", checkForNull(rs.getString("name_dervn_logic")));
				mPParamData.put("name_dervn_logic_long", checkForNull(rs.getString("name_dervn_logic_long")));
				mPParamData.put("name_dervn_logic_oth_lang", checkForNull(rs.getString("name_dervn_logic_oth_lang")));
				mPParamData.put("name_dervn_logic_oth_lang_long", checkForNull(rs.getString("name_dervn_logic_oth_lang_long")));

				mPParamData.put("unit_of_wt_nb", rs.getString("unit_of_wt_nb"));
				mPParamData.put("unit_of_circum_nb", rs.getString("unit_of_circum_nb"));
				mPParamData.put("unit_of_chest_circum_nb", rs.getString("unit_of_chest_circum_nb"));
				mPParamData.put("unit_of_length_nb", rs.getString("unit_of_length_nb"));
				mPParamData.put("unit_of_gest_nb", rs.getString("unit_of_gest_nb"));
				mPParamData.put("newborn_pat_ser_grp", rs.getString("newborn_pat_ser_grp"));
				mPParamData.put("allow_ext_nb_regn_within_days", rs.getString("allow_ext_nb_regn_within_days"));
				mPParamData.put("nb_use_mother_ser", rs.getString("nb_use_mother_ser"));
				mPParamData.put("accept_names_for_live_birth_yn", rs.getString("accept_names_for_live_birth_yn"));
				mPParamData.put("still_born_prefix", rs.getString("still_born_prefix"));
				mPParamData.put("nb_father_name_mandatory_yn", rs.getString("nb_father_name_mandatory_yn"));

				mPParamData.put("name_prefix_accept_yn", rs.getString("name_prefix_accept_yn"));
				mPParamData.put("name_prefix_reqd_yn", rs.getString("name_prefix_reqd_yn"));
				mPParamData.put("name_suffix_accept_yn", rs.getString("name_suffix_accept_yn"));
				mPParamData.put("name_suffix_reqd_yn", rs.getString("name_suffix_reqd_yn"));
				mPParamData.put("first_name_accept_yn", rs.getString("first_name_accept_yn"));
				mPParamData.put("first_name_prompt", rs.getString("first_name_prompt"));
				mPParamData.put("first_name_reqd_yn", rs.getString("first_name_reqd_yn"));
				mPParamData.put("second_name_accept_yn", rs.getString("second_name_accept_yn"));
				mPParamData.put("second_name_prompt", rs.getString("second_name_prompt"));
				mPParamData.put("third_name_accept_yn", rs.getString("third_name_accept_yn"));
				mPParamData.put("third_name_prompt", rs.getString("third_name_prompt"));
				mPParamData.put("family_name_accept_yn", rs.getString("family_name_accept_yn"));
				mPParamData.put("family_name_prompt", rs.getString("family_name_prompt"));
				mPParamData.put("second_name_reqd_yn", rs.getString("second_name_reqd_yn"));
				mPParamData.put("third_name_reqd_yn", rs.getString("third_name_reqd_yn"));
				mPParamData.put("family_name_reqd_yn", rs.getString("family_name_reqd_yn"));
				mPParamData.put("pat_name_as_multipart_yn", rs.getString("pat_name_as_multipart_yn"));
				mPParamData.put("name_suffix_prompt", rs.getString("name_suffix_prompt"));
				mPParamData.put("name_prefix_prompt", rs.getString("name_prefix_prompt"));
				mPParamData.put("family_name_order", rs.getString("family_name_order"));
				mPParamData.put("first_name_order", rs.getString("first_name_order"));
				mPParamData.put("second_name_order", rs.getString("second_name_order"));
				mPParamData.put("third_name_order", rs.getString("third_name_order"));

				mPParamData.put("first_name_length", rs.getString("first_name_length"));
				mPParamData.put("second_name_length", rs.getString("second_name_length"));
				mPParamData.put("third_name_length", rs.getString("third_name_length"));
				mPParamData.put("family_name_length", rs.getString("family_name_length"));
				mPParamData.put("family_name_loc_lang_prompt", rs.getString("family_name_loc_lang_prompt"));
				//mPParamData.put("pat_name_in_loc_lang_reqd_yn", rs.getString("pat_name_in_loc_lang_reqd_yn"));
				mPParamData.put("name_suffix_loc_lang_prompt", rs.getString("name_suffix_loc_lang_prompt"));
				mPParamData.put("first_name_loc_lang_prompt", rs.getString("first_name_loc_lang_prompt"));
				mPParamData.put("second_name_loc_lang_prompt", rs.getString("second_name_loc_lang_prompt"));
				mPParamData.put("third_name_loc_lang_prompt", rs.getString("third_name_loc_lang_prompt"));
				mPParamData.put("name_prefix_loc_lang_prompt", rs.getString("name_prefix_loc_lang_prompt"));
				mPParamData.put("names_in_oth_lang_yn", rs.getString("names_in_oth_lang_yn"));

				mPParamData.put("dflt_nb_regn_blng_class", rs.getString("dflt_nb_regn_blng_class"));
				mPParamData.put("nb_father_min_age", rs.getString("nb_father_min_age"));
				mPParamData.put("create_file_at_pat_regn_yn", rs.getString("create_file_at_pat_regn_yn"));

				mPParamData.put("dflt_race_nat_setup_nb_as_per", rs.getString("dflt_race_nat_setup_nb_as_per"));
				mPParamData.put("citizen_nationality_code", rs.getString("citizen_nationality_code"));
				mPParamData.put("default_race_code", rs.getString("default_race_code"));

				mPParamData.put("name_pfx_loc_lang_male_nb", rs.getString("name_pfx_loc_lang_male_nb"));
				mPParamData.put("name_pfx_loc_lang_female_nb", rs.getString("name_pfx_loc_lang_female_nb"));
				mPParamData.put("name_pfx_loc_lang_unknown_nb", rs.getString("name_pfx_loc_lang_unknown_nb")); //Added by Afruddin for ML-MMOH-CRF-1520 US 0001
				mPParamData.put("name_sfx_loc_lang_male_nb", rs.getString("name_sfx_loc_lang_male_nb"));
				mPParamData.put("name_sfx_loc_lang_female_nb", rs.getString("name_sfx_loc_lang_female_nb"));
				mPParamData.put("nb_mother_dtls_update_yn", rs.getString("nb_mother_dtls_update_yn")); //Added for this CRF HSA-CRF-0182
				mPParamData.put("name_dervn_logic_nb", rs.getString("name_dervn_logic_nb"));//Added by Ashwini on 12-Oct-2020 for ML-MMOH-CRF-1551
				mPParamData.put("name_dervn_logic_nb_sb", rs.getString("name_dervn_logic_nb_sb"));//Added by Ashwini on 12-Oct-2020 for ML-MMOH-CRF-1551.1
			}			

			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close(); 			
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		} finally {
			//mPParamData.clear();
		}
		
		return mPParamData;
	}
	
   /*	The static method getMaxNoOfBirths retrives the maximum number of birthes of the mother.
	*	@Table mp_birth_register
	*	@Returns hashMap1
	*	@Throws Exception
	*/
	public static HashMap getMaxNoOfBirths(String mother_patient_id, Connection con) throws Exception
	{
		Statement stmt		= null;
		ResultSet rs		= null;
		HashMap hashMap1	= null;

		try
		{
			hashMap1 = new HashMap();
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT max(no_of_births) no_of_births, round(abs(sysdate - max(TIME_OF_BIRTH))*24,0) diffHours FROM mp_birth_register WHERE mother_patient_id = '"+mother_patient_id+"'"); 
			
			if(rs != null && rs.next()) 
			{
				hashMap1.put("q_no_of_birth",	checkForNull(rs.getString("no_of_births"), "1"));
			}
			else
			{
				hashMap1.put("q_no_of_birth",	"1");
			}
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}
		return hashMap1;
	}

   /*	The static method getNBMotherDtls retrives the Name of the Patient AND Newborn baby Mother 		 Date of Birth.
	*	@Table mp_patient
	*	@Returns hashMap2
	*	@Throws Exception
	*/
	public static HashMap getNBMotherDtls(String mother_patient_id, Connection con, java.util.Properties p) throws Exception
	{
		Statement stmt		= null;
		ResultSet rs		= null;
		HashMap hashMap2	= null;
		String locale = p.getProperty("LOCALE");
		
		try
		{
			hashMap2 = new HashMap();
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT decode('"+locale+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name)) patient_name, to_char(date_of_birth, 'dd/mm/yyyy') mother_date_of_birth FROM mp_patient WHERE patient_id = '"+mother_patient_id+"'"); 
			
			if(rs != null && rs.next()) {
				hashMap2.put("q_mother_patient_name", checkForNull(rs.getString("patient_name")));
				hashMap2.put("q_mother_date_of_birth",checkForNull(rs.getString("mother_date_of_birth")));
			}
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		catch(Exception e3)
		{
			e3.printStackTrace();
		}
		return hashMap2;
	}
	
   /*	The static method getIPInstalledYNSysDate retrives whether IP Module is Installed OR Not and		 System Date/Time.
    *	@Called in NewbornRegistrationMain.jsp & MaintainBirthRegisterMain.jsp files.
	*	@Table sm_module
	*	@Returns hashMap3
	*	@Throws Exception
	*/
	public static HashMap getIPInstalledYNSysDate(Connection con,Properties p) throws Exception
	{
		Statement stmt		= null;
		ResultSet rs		= null;
		HashMap hashMap3	= null;
		try
		{
			hashMap3 = new HashMap();
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT install_yn, to_char(sysdate,'dd/mm/yyyy hh24:mi') dttm FROM sm_module WHERE module_id = 'IP'"); 
			
			if(rs != null && rs.next()) {
				hashMap3.put("ip_install_yn",		checkForNull(rs.getString("install_yn")));
				hashMap3.put("system_date_time",	checkForNull(rs.getString("dttm")));
			}
			if(rs != null) rs.close();
		}
		catch(Exception e3)
		{
			e3.printStackTrace();
		}
		return hashMap3;
	}

   /*	The static method getprocClassShortDesc retrives Proc Class short desccription. 
	*	@Table mp_proc_classification
	*	@Returns hashMap4
	*	@Throws Exception
	*/
	public static HashMap getprocClassShortDesc(String proc_class_code, Connection con,Properties p) throws Exception
	{
		Statement stmt		= null;
		ResultSet rs		= null;
		HashMap hashMap4	= null;
        String locale = p.getProperty("LOCALE");
		 
		try
		{
			hashMap4 = new HashMap();
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT short_desc FROM mp_proc_classification_lang_vw WHERE proc_class_code='"+proc_class_code+"' AND language_id='"+locale+"' "); 
			if(rs != null && rs.next()) {
				hashMap4.put("q_proc_class_desc", checkForNull(rs.getString("short_desc")));
			} else {
				hashMap4.put("q_proc_class_desc", "");
			}
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		catch(Exception e3)
		{
			e3.printStackTrace();
		}
		return hashMap4;
	}

	/*	The static method getprocVaginalDelyTypeShortDesc retrives Vaginal Dely Type short 				desccription. 
	*	@Table mp_vaginal_dely_type
	*	@Returns hashMap5
	*	@Throws Exception
	*/
	public static HashMap getprocVaginalDelyTypeShortDesc(String q_vaginal_del_type_code,Connection con,Properties p) throws Exception
	{
		Statement stmt		= null;
		ResultSet rs		= null;
		HashMap hashMap5	= null;
        String locale = p.getProperty("LOCALE");
		
		try
		{
			hashMap5 = new HashMap();
			
			stmt = con.createStatement();
			
			rs = stmt.executeQuery("SELECT short_desc FROM mp_vaginal_dely_type_lang_vw WHERE vag_dely_type = '"+q_vaginal_del_type_code+"' AND language_id='"+locale+"' "); 
			if(rs != null && rs.next()) {
				hashMap5.put("q_vaginal_del_type_desc",	checkForNull(rs.getString("short_desc")));
			} else {
				hashMap5.put("q_vaginal_del_type_desc",	"");
			}
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}
		return hashMap5;
	}

	/*	The static method getprocDelySurgShortDesc retrives Dely Surg Class short desccription. 
	*	@Table mp_dely_surg_classification
	*	@Returns hashMap6
	*	@Throws Exception
	*/
	public static HashMap getprocDelySurgShortDesc(String q_del_serv_class,Connection con,Properties p) throws Exception
	{
		Statement stmt		= null;
		ResultSet rs		= null;
		HashMap hashMap6	= null;
        String locale = p.getProperty("LOCALE");
		
 
		try
		{
			hashMap6 = new HashMap();
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT short_desc FROM MP_DELY_SURG_CLFN_LANG_VW WHERE dely_surg_class_code = '"+q_del_serv_class+"' AND language_id='"+locale+"' "); 
			
			if(rs != null && rs.next()) {
				hashMap6.put("q_del_serv_desc",	checkForNull(rs.getString("short_desc")));
			} else {
				hashMap6.put("q_del_serv_desc",	"");
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

	/*	The static method getBirthPlaceLongDesc retrives Dely Birth Place long desccription. 
	*	@Table mp_birth_place
	*	@Returns hashMap7
	*	@Throws Exception
	*/
	public static HashMap getBirthPlaceLongDesc(String q_Birth_place_code,Connection con,Properties p) throws Exception
	{
		Statement stmt		= null;
		ResultSet rs		= null;
		HashMap hashMap7	= null;
        String locale = p.getProperty("LOCALE");
		
		try
		{
			hashMap7 = new HashMap();
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT long_desc FROM mp_birth_place_lang_vw WHERE birth_place_code  = '"+q_Birth_place_code+"' AND language_id='"+locale+"' "); 
			
			if(rs != null && rs.next()) {
				hashMap7.put("q_Birth_place_desc",	checkForNull(rs.getString("long_desc")));
			} else {
				hashMap7.put("q_Birth_place_desc",	"");
			}
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}
		return hashMap7;
	}

	/*	The static method getPractitionerName retrives Practitioner Name. 
	*	@Table am_practitioner
	*	@Returns hashMap8
	*	@Throws Exception
	*/
	public static HashMap getPractitionerName(String q_attend_physician_id,Connection con,Properties p) throws Exception
	{
		Statement stmt		= null;
		ResultSet rs		= null;
		HashMap hashMap8	= null;
        String locale = p.getProperty("LOCALE");
		
		try
		{
			hashMap8 = new HashMap();
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT practitioner_name FROM am_practitioner_lang_vw WHERE practitioner_id = '"+q_attend_physician_id+"' and language_id='"+locale+"'"); 
			
			if(rs != null && rs.next()) {
				hashMap8.put("practitioner_name",	checkForNull(rs.getString("practitioner_name")));
			} else {
				hashMap8.put("practitioner_name", "");
			}
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}
		return hashMap8;
	}

   	/*	The static method getIPOpenEncounter retrives Mother Nursing Unit Code, Mother Bed Number. 
	*	@Table ip_open_encounter
	*	@Returns hashMap10
	*	@Throws Exception
	*/
	public static HashMap getIPOpenEncounter(String facilityId,String motherencounterid,Connection con,Properties p) throws Exception
	{
		Statement stmt		= null;
		ResultSet rs		= null;
		HashMap hashMap10	= null;

		try
		{
			hashMap10 = new HashMap();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT b.pseudo_bed_yn, a.nursing_unit_code, a.bed_num FROM ip_open_encounter a, ip_nursing_unit_bed b WHERE a.facility_id = '"+facilityId+"' AND a.encounter_id = '"+motherencounterid+"' and a.facility_id = b.facility_id and a.nursing_unit_code = b.nursing_unit_Code and a.bed_num = b.bed_no"); 
			
			if(rs != null && rs.next()) {
				hashMap10.put("mother_nursing_unit_code",checkForNull(rs.getString("nursing_unit_code")));
				hashMap10.put("mother_bed_no",	checkForNull(rs.getString("bed_num")));
				hashMap10.put("pseudo_bed_yn",	checkForNull(rs.getString("pseudo_bed_yn")));
			} else {
				hashMap10.put("mother_nursing_unit_code", "");
				hashMap10.put("mother_bed_no",	"");
				hashMap10.put("pseudo_bed_yn",	"");
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

	/*	The static method getIPNursingUnitBedNO retrives Baby Bed Number. 
	*	bed_no will have the Baby Bed Number if assigned previously 
	*	@Table ip_nursing_unit_bed
	*	@Returns hashMap11
	*	@Throws Exception
	*/
	public static HashMap getIPNursingUnitBedNO(String facilityId,String mother_bed_no,String q_patient_id,Connection con) throws Exception
	{
		Statement stmt		= null;
		ResultSet rs		= null;
		HashMap hashMap11	= null;

		try
		{
			hashMap11 = new HashMap();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT bed_no FROM ip_nursing_unit_bed WHERE facility_id = '"+facilityId+"' AND main_bed_no = '"+mother_bed_no+"' AND occupying_patient_id = '"+q_patient_id+"' "); 
			
			if(rs != null && rs.next()) {
				hashMap11.put("old_bed_number",checkForNull(rs.getString("bed_no")));
			} else {
				hashMap11.put("old_bed_number", "");
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

	/*	The static method getMPParamData retrives DAa MP Parameter Date. 
	*	@Table mp_param
	*	@Returns hashMap12
	*	@Throws Exception
	*/
	public static HashMap getMPParamData(String module_id, String table_name , String function, Connection con,Properties p) throws Exception
	{
		Statement stmt		= null;
		ResultSet rs		= null;
		HashMap hashMap12	= null;
        String locale = p.getProperty("LOCALE");
		
		try
		{
			hashMap12 = new HashMap();
			
			stmt = con.createStatement();
			if(function.equals("MNB"))
			{
				if(table_name.equals("mp_param")) {
					rs = stmt.executeQuery("SELECT nvl(min_weight,0) min_weight, nvl(max_weight,0) max_weight, nvl(min_chest_circum,0) min_chest_circum, nvl(max_chest_circum,0) max_chest_circum, nvl(min_head_circum,0) min_head_circum, nvl(max_head_circum,0) max_head_circum, nvl(min_length,0) min_length, nvl(max_length,0) max_length, nvl(min_gestation,0) min_gestation, nvl(max_gestation,0) max_gestation, nvl(pat_name_as_multipart_yn,'') pat_name_as_multipart_yn, nvl(nb_male_relnship,'') nb_male_relnship, nvl(nb_female_relnship,'') nb_female_relnship, nvl(nb_unknown_relnship,'') nb_unknown_relnship, patient_id_length, nb_mother_cutoff_age, maintain_doc_or_file FROM mp_param_lang_vw WHERE language_id='"+locale+"' and module_id = '"+module_id+"'"); 

					if(rs != null && rs.next()) {
						hashMap12.put("min_weight",	checkForNull(rs.getString("min_weight")));
						hashMap12.put("max_weight",	checkForNull(rs.getString("max_weight")));
						hashMap12.put("min_chest_circum",checkForNull(rs.getString("min_chest_circum")));
						hashMap12.put("max_chest_circum",checkForNull(rs.getString("max_chest_circum")));
						hashMap12.put("min_head_circum",	checkForNull(rs.getString("min_head_circum")));
						hashMap12.put("max_head_circum",	checkForNull(rs.getString("max_head_circum")));
						hashMap12.put("min_length",		checkForNull(rs.getString("min_length")));
						hashMap12.put("max_length",		checkForNull(rs.getString("max_length")));
						hashMap12.put("min_gestation",	checkForNull(rs.getString("min_gestation")));
						hashMap12.put("max_gestation",	checkForNull(rs.getString("max_gestation")));
						hashMap12.put("pat_name_as_multipart_yn",checkForNull(rs.getString("pat_name_as_multipart_yn")));
						hashMap12.put("nb_male_relnship",checkForNull(rs.getString("nb_male_relnship")));
						hashMap12.put("nb_female_relnship",checkForNull(rs.getString("nb_female_relnship")));
						hashMap12.put("nb_unknown_relnship",checkForNull(rs.getString("nb_unknown_relnship")));
						hashMap12.put("nb_mother_cutoff_age",checkForNull(rs.getString("nb_mother_cutoff_age")));
						hashMap12.put("patient_id_length",checkForNull(rs.getString("patient_id_length"),"0"));
						hashMap12.put("maintain_doc_or_file",checkForNull(rs.getString("maintain_doc_or_file"),"F"));
					   
					}
				} else if(table_name.equals("mp_param1")) {
					rs = stmt.executeQuery("SELECT nvl(allow_nb_regn_unit,'H') allow_nb_regn_unit, nvl(allow_nb_regn_within_days,0) allow_nb_regn_within_days, nat_id_prompt, nat_id_length, alt_id1_type, alt_id1_length, accept_oth_alt_id_yn, b.long_desc father_alt_id1_desc, alt_id1_len_validation_yn, alt_id1_routine_yn, alt_id1_data_source_id, alt_id1_chk_digit_scheme, alt_id1_accept_alphanumeric_yn FROM mp_param_lang_vw a, mp_alternate_id_type_lang_vw b WHERE a.alt_id1_type = b.alt_id_type and  a.language_id='"+locale+"' and b.language_id='"+locale+"'"); 

					if(rs != null && rs.next()) {
						hashMap12.put("cd1",checkForNull(rs.getString("allow_nb_regn_unit")));
						hashMap12.put("cd2",checkForNull(rs.getString("allow_nb_regn_within_days"),"0"));
						hashMap12.put("nat_id_prompt",checkForNull(rs.getString("nat_id_prompt")));
						hashMap12.put("nat_id_length",checkForNull(rs.getString("nat_id_length")));
						hashMap12.put("Accept_oth_alt_id_yn",checkForNull(rs.getString("accept_oth_alt_id_yn"),"N"));
						hashMap12.put("alt_id1_type",checkForNull(rs.getString("alt_id1_type")));
						hashMap12.put("alt_id1_length",checkForNull(rs.getString("alt_id1_length")));
						hashMap12.put("father_alt_id1_desc",checkForNull(rs.getString("father_alt_id1_desc")));
						hashMap12.put("alt_id1_len_validation_yn",checkForNull(rs.getString("alt_id1_len_validation_yn")));
						hashMap12.put("alt_id1_routine_yn",checkForNull(rs.getString("alt_id1_routine_yn")));
						hashMap12.put("alt_id1_data_source_id",checkForNull(rs.getString("alt_id1_data_source_id")));
						hashMap12.put("alt_id1_chk_digit_scheme",checkForNull(rs.getString("alt_id1_chk_digit_scheme")));
						hashMap12.put("alt_id1_accept_alphanumeric_yn",checkForNull(rs.getString("alt_id1_accept_alphanumeric_yn")));
					}
				} 
			}
			else if(function.equals("NB"))
			{
				if(table_name.equals("mp_param3")) 
				{
					rs = stmt.executeQuery("SELECT nvl(min_weight, 0) min_weight, nvl(max_weight, 0) max_weight, nvl(min_chest_circum, 0) min_chest_circum, nvl(max_chest_circum, 0) max_chest_circum, nvl(min_head_circum, 0) min_head_circum, nvl(max_head_circum, 0) max_head_circum, nvl(min_length, 0) min_length, nvl(max_length, 0) max_length, nvl(min_gestation, 0) min_gestation, nvl(max_gestation, 0) max_gestation, nvl(pat_name_as_multipart_yn, '') pat_name_as_multipart_yn, nvl(nb_male_relnship, '') nb_male_relnship,nat_id_accept_alphanumeric_yn,nvl(nb_female_relnship, '') nb_female_relnship, nvl(nb_unknown_relnship, '') nb_unknown_relnship, name_dervn_logic, name_dervn_logic_oth_lang FROM mp_param_lang_vw WHERE language_id='"+locale+"' and module_id = '"+module_id+"'"); 

					if(rs != null && rs.next()) {
						hashMap12.put("min_weight",	checkForNull(rs.getString("min_weight")));
						hashMap12.put("max_weight",	checkForNull(rs.getString("max_weight")));
						hashMap12.put("min_chest_circum",checkForNull(rs.getString("min_chest_circum")));
						hashMap12.put("max_chest_circum",checkForNull(rs.getString("max_chest_circum")));
						hashMap12.put("min_head_circum",checkForNull(rs.getString("min_head_circum")));
						hashMap12.put("max_head_circum",checkForNull(rs.getString("max_head_circum")));
						hashMap12.put("min_length",	checkForNull(rs.getString("min_length")));
						hashMap12.put("max_length",	checkForNull(rs.getString("max_length")));
						hashMap12.put("min_gestation",	checkForNull(rs.getString("min_gestation")));
						hashMap12.put("max_gestation",	checkForNull(rs.getString("max_gestation")));
						hashMap12.put("pat_name_as_multipart_yn",checkForNull(rs.getString("pat_name_as_multipart_yn")));
						hashMap12.put("nb_male_relnship",checkForNull(rs.getString("nb_male_relnship")));
						hashMap12.put("nb_female_relnship",checkForNull(rs.getString("nb_female_relnship")));
						hashMap12.put("nb_unknown_relnship",checkForNull(rs.getString("nb_unknown_relnship")));
						hashMap12.put("nat_id_accept_alphanumeric_yn",checkForNull(rs.getString("nat_id_accept_alphanumeric_yn")));

						hashMap12.put("name_dervn_logic",checkForNull(rs.getString("name_dervn_logic")));  		hashMap12.put("name_dervn_logic_oth_lang",checkForNull(rs.getString("name_dervn_logic_oth_lang")));
					}
				}
				if(table_name.equals("mp_param4")) 
				{
					rs = stmt.executeQuery("SELECT nvl(nb_min_gest_bet_2_dely,0) nb_min_gest_bet_2_dely, maintain_doc_or_file FROM mp_param_lang_vw where module_id = 'MP' and language_id='"+locale+"'"); 

					if(rs != null && rs.next()) {
						hashMap12.put("nb_min_gest_bet_2_dely",checkForNull(rs.getString("nb_min_gest_bet_2_dely")));
						hashMap12.put("maintain_doc_or_file",checkForNull(rs.getString("maintain_doc_or_file"),"F"));
					}
				}
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
	
	/*	The static method getPatSerGrpCode retrives Short Description of the specidied Patient Series 	Group Code.
	*	@Table mp_pat_ser_grp
	*	@Returns hashMap13
	*	@Throws Exception
	*/
	public static HashMap getPatSerGrpCode(String q_pat_ser_grp_code,Connection con,Properties p) throws Exception
	{
		Statement stmt		= null;
		ResultSet rs		= null;
		HashMap hashMap13	= null;
        String locale = p.getProperty("LOCALE");
		

		try
		{
			hashMap13 = new HashMap();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT short_desc FROM mp_pat_ser_grp_lang_vw WHERE pat_ser_grp_code = '"+q_pat_ser_grp_code+"' and language_id='"+locale+"'"); 
			
			if(rs != null && rs.next()) {
				hashMap13.put("pat_ser_grp_short_desc",	checkForNull(rs.getString("short_desc")));
			} else {
				hashMap13.put("pat_ser_grp_short_desc",	"");
			}
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}
		return hashMap13;
	}

	/*	The static method getNodeType retrives Node Type.
	*	@Table mp_nod_type
	*	@Returns hashMap14
	*	@Throws Exception
	*/
	public static HashMap getNodeType(String q_type_delivery,Connection con,Properties p) throws Exception
	{
		Statement stmt		= null;
		ResultSet rs		= null;
		HashMap hashMap14	= null;
        String locale = p.getProperty("LOCALE");
		

		try
		{
			hashMap14 = new HashMap();
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT nod_type FROM mp_nod_type_lang_vw WHERE nod_type =  '"+q_type_delivery+"' and language_id="+locale+"'"); 
			
			if(rs != null && rs.next()) {
				hashMap14.put("code1",	checkForNull(rs.getString("nod_type")));
			} else {
				hashMap14.put("code1",	"");
			}
			
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}
		return hashMap14;
	}
	
	/*	The static method getPractitionerNameTitle retrives Node Type.
	*	@Table am_practitioner
	*	@Returns hashMap15
	*	@Throws Exception
	*/
	public static HashMap getPractitionerNameTitle(String q_Umb_cord_cut_by,Connection con,Properties p) throws Exception
	{
		Statement stmt		= null;
		ResultSet rs		= null;
		HashMap hashMap15	= null;
        String locale = p.getProperty("LOCALE");
		

		try
		{
			hashMap15 = new HashMap();
			 
 
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT am_get_desc.am_position(POSITION_CODE,'"+locale+"',1) job_title, practitioner_name FROM am_practitioner_lang_vw WHERE practitioner_id = '"+q_Umb_cord_cut_by+"' and language_id = '"+locale+"'"); 
			
			if(rs != null && rs.next()) {
				hashMap15.put("job_title",	checkForNull(rs.getString("job_title")));
				hashMap15.put("practitioner_name",	checkForNull(rs.getString("practitioner_name")));
			} 
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}
		return hashMap15;
	}

	/*	The static method getDfltNBRegnBlngClass retrives Node Type.
	*	@Called in NewbornRegistrationMain.jsp file.
	*	@Table bl_mp_param
	*	@Returns hashMap16
	*	@Throws Exception
	*/
	public static HashMap getDfltNBRegnBlngClass(Connection con) throws Exception
	{
		Statement stmt		= null;
		ResultSet rs		= null;
		HashMap hashMap16	= null;

		try
		{
			hashMap16 = new HashMap();
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT dflt_nb_regn_blng_class FROM bl_mp_param"); 
			
			if(rs != null && rs.next()) {
				hashMap16.put("dflt_nb_regn_blng_class",checkForNull(rs.getString("dflt_nb_regn_blng_class")));
			} 
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}
		return hashMap16;
	}
	
	/*	The static method getMPBirthRegisterData retrives Node Type.
	*	@Called in NewbornRegistrationMain.jsp file.
	*	@Table mp_birth_register
	*	@Returns hashMap17
	*	@Throws Exception
	*/
	public static HashMap getMPBirthRegisterData(String motherid, String table, Connection con,Properties p) throws Exception
	{
		Statement stmt		= null;
		ResultSet rs		= null;
		HashMap hashMap17	= null;
        String locale = p.getProperty("LOCALE");
		

		try
		{
			hashMap17 = new HashMap();
			stmt = con.createStatement();
			if(table.equals("mp_birth_register"))
			{
				rs = stmt.executeQuery("SELECT round(abs(sysdate - max(TIME_OF_BIRTH))*24,0) diffHours FROM mp_birth_register WHERE mother_patient_id = '"+motherid+"' "); 
			
				if(rs != null && rs.next()) {
					hashMap17.put("diffHours",	checkForNull(rs.getString("diffHours"), "0"));
				}
			}
			else if(table.equals("mp_birth_register1")) 
			{
				rs = stmt.executeQuery("SELECT max(no_of_births) no_of_births, max(gestational_period) gestational_period, max(gestational_period_in_days) gestational_period_in_days, max(birth_order) birth_order, max(parity) parity, max(parity1) parity1, max(gravida) gravida FROM mp_birth_register WHERE no_of_multi_babies_regd > 0 AND mother_patient_id = '"+motherid+"' "); 
			
				if(rs != null && rs.next()) {
					
					hashMap17.put("q_no_of_birth",	checkForNull(rs.getString("no_of_births"),"0"));
					hashMap17.put("q_gestational_period",checkForNull(rs.getString("gestational_period")));
					hashMap17.put("q_gestational_period_days",checkForNull(rs.getString("gestational_period_in_days")));
					hashMap17.put("q_birth_order",	checkForNull(rs.getString("birth_order")));		
					hashMap17.put("q_parity",		checkForNull(rs.getString("parity")));
					hashMap17.put("q_parity1",		checkForNull(rs.getString("parity1")));
					hashMap17.put("q_gravida",		checkForNull(rs.getString("gravida")));
				}
			}
			else if(table.equals("mp_birth_register2")){
				rs = stmt.executeQuery("SELECT remarks q_remarks ,NVL(father_patient_id,'') father_patient_id,NVL(father_name,'') father_name,  NVL(father_national_id_no,'') father_national_id_no,NVL(father_oth_alt_id_type,'') father_oth_alt_id_type, MP_GET_DESC.MP_ALTERNATE_ID_TYPE(a.father_oth_alt_id_type,'"+locale+"','1') q_father_oth_alt_id_type_desc, NVL(father_nationality_code,  '') father_nationality_code, MP_GET_DESC.MP_COUNTRY(a.father_nationality_code,'"+locale+"','3') q_father_nationality_desc, NVL(father_ethnic_group_code, '') father_ethnic_group_code, MP_GET_DESC.MP_RACE(a.father_ethnic_group_code,'"+locale+"','1') q_race_desc, NVL(father_religion_code,'') father_religion_code, MP_GET_DESC.MP_RELIGION(a.father_religion_code,'"+locale+"','2') q_father_religion_desc,father_gove_employee_yn, NVL(father_ocpn_class_code,'') father_ocpn_class_code,  MP_GET_DESC.MP_OCCUPATION_CLASS(a.father_ocpn_class_code,'"+locale+"','1') q_father_occupation_class_desc, NVL(father_ocpn_code,'') father_ocpn_code, MP_GET_DESC.MP_OCCUPATION(a.father_ocpn_code,'"+locale+"','1') q_occupation_desc, NVL(father_ocpn_desc,'') father_ocpn_desc, NVL(father_remarks,'') father_remarks,  father_gove_employee_yn, father_oth_alt_id_no, father_alt_id1_no FROM  mp_birth_register a WHERE mother_patient_id = '"+motherid+"'  AND  patient_id = (SELECT MAX(patient_id) FROM mp_birth_register WHERE mother_patient_id = '"+motherid+"' ) "); 			
				if(rs != null && rs.next()) {
					hashMap17.put("q_remarks",	checkForNull(rs.getString("q_remarks")));
					hashMap17.put("q_father_patient_id",checkForNull(rs.getString("father_patient_id")));
					hashMap17.put("q_father_name",	checkForNull(rs.getString("father_name")));
					hashMap17.put("q_father_national_id_no",checkForNull(rs.getString("father_national_id_no")));
					hashMap17.put("q_father_oth_alt_id_type",checkForNull(rs.getString("father_oth_alt_id_type")));	
					hashMap17.put("q_FATHER_OTH_ALT_ID_NO",checkForNull(rs.getString("father_oth_alt_id_no")));						
					hashMap17.put("q_father_nationality_code",checkForNull(rs.getString("father_nationality_code")));
					hashMap17.put("q_race_code",checkForNull(rs.getString("father_ethnic_group_code")));
					hashMap17.put("q_father_religion_code",checkForNull(rs.getString("father_religion_code")));
					hashMap17.put("q_father_ocpn_class_code",checkForNull(rs.getString("father_ocpn_class_code")));
					hashMap17.put("q_father_ocpn_code",checkForNull(rs.getString("father_ocpn_code")));
					hashMap17.put("q_father_ocpn_desc",checkForNull(rs.getString("father_ocpn_desc")));
					hashMap17.put("q_father_remarks",checkForNull(rs.getString("father_remarks")));
					hashMap17.put("q_father_govemp",checkForNull(rs.getString("father_gove_employee_yn")));
					hashMap17.put("q_father_oth_alt_id_type_desc",checkForNull(rs.getString("q_father_oth_alt_id_type_desc")));
					hashMap17.put("q_father_nationality_desc",checkForNull(rs.getString("q_father_nationality_desc")));
					hashMap17.put("q_race_desc",	checkForNull(rs.getString("q_race_desc")));
					hashMap17.put("q_father_religion_desc",checkForNull(rs.getString("q_father_religion_desc")));
					hashMap17.put("q_father_occupation_class_desc",checkForNull(rs.getString("q_father_occupation_class_desc")));
					hashMap17.put("q_occupation_desc",checkForNull(rs.getString("q_occupation_desc")));
					hashMap17.put("father_alt_id1_no_value", checkForNull(rs.getString("father_alt_id1_no")));
				}
			}
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}
		return hashMap17;
	}
	
	/*	The static method getAltID1No retrives Alternate ID1 Number.
	*	@Called in NewbornRegistrationMain.jsp file.
	*	@Table mp_patient
	*	@Returns hashMap18
	*	@Throws Exception
	*/
	public static HashMap getAltID1No(String motherid, Connection con) throws Exception
	{
		Statement stmt		= null;
		ResultSet rs		= null;
		HashMap hashMap18	= null;
        
		try
		{
			hashMap18 = new HashMap();
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT alt_id1_no FROM mp_patient WHERE patient_id = '"+motherid+"'"); 
			
			if(rs != null && rs.next()) {
				hashMap18.put("alt_id1_no", checkForNull(rs.getString("alt_id1_no")));
			} else {
				hashMap18.put("alt_id1_no", "");
			}
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}
		return hashMap18;
	}

	/*	The static method getAltIDType retrives Alternate ID Number.
	*	@Called in NewbornRegistrationMain.jsp file.
	*	@Table mp_alternate_id_type
	*	@Returns hashMap19
	*	@Throws Exception
	*/
	public static HashMap getAltIDType(String alt_id_type, Connection con,Properties p) throws Exception
	{
		Statement stmt		= null;
		ResultSet rs		= null;
		HashMap hashMap19	= null;
        String locale = p.getProperty("LOCALE");
		

		try
		{
			hashMap19 = new HashMap();
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT alt_id_type, long_desc short_desc FROM mp_alternate_id_type_lang_vw alt_id_type = '"+alt_id_type+"' AND language_id = '"+locale+"' "); 
			
			if(rs != null && rs.next()) {
				hashMap19.put("alt_id_type", checkForNull(rs.getString("alt_id_type")));
				hashMap19.put("short_desc", checkForNull(rs.getString("short_desc")));
			} else {
				hashMap19.put("alt_id_type", "");
				hashMap19.put("short_desc", "");
			}
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}
		return hashMap19;
	}

	/*	The static method getMPParamAltIDTypeData retrives data from ma_param and 						mp_alternate_id_type.  
	*	@Called in NewbornRegistrationMain.jsp file.
	*	@Table mp_param, mp_alternate_id_type
	*	@Returns hashMap19
	*	@Throws Exception
	*/
		public static HashMap getMPParamAltIDTypeData(Connection con,Properties p) throws Exception {
		PreparedStatement pstmt1		= null;
		ResultSet rs33					= null;
		StringBuffer SelectSQLString	= null;
		String locale = p.getProperty("LOCALE");
		
		HashMap hashMap20				= new HashMap();
		try {
			SelectSQLString = new StringBuffer();
			SelectSQLString.append("SELECT nvl(allow_nb_regn_unit,'H') allow_nb_regn_unit, nvl(allow_nb_regn_within_days,0) allow_nb_regn_within_days, nat_id_prompt, nat_id_length, accept_oth_alt_id_yn, patient_id_length, alt_id1_type, b.long_desc father_alt_id1_desc, alt_id1_length, alt_id1_len_validation_yn, alt_id1_routine_yn, alt_id1_data_source_id, alt_id1_chk_digit_scheme, alt_id1_accept_alphanumeric_yn FROM mp_param_lang_vw a, mp_alternate_id_type_lang_vw b WHERE a.alt_id1_type = b.alt_id_type AND b.language_id = '"+locale+"' AND a.language_id = '"+locale+"' AND a.module_id='MP'");
			
			pstmt1	= con.prepareStatement(SelectSQLString.toString());
			rs33	= pstmt1.executeQuery();
			
			if(rs33 != null && rs33.next()) { 
				hashMap20.put("allow_nb_regn_unit",checkForNull(rs33.getString("allow_nb_regn_unit")));
				hashMap20.put("allow_nb_regn_within_days",checkForNull(rs33.getString("allow_nb_regn_within_days"),"0"));
				hashMap20.put("nat_id_prompt",	checkForNull(rs33.getString("nat_id_prompt")));
				hashMap20.put("nat_id_length",	checkForNull(rs33.getString("nat_id_length")));
				hashMap20.put("accept_oth_alt_id_yn",checkForNull(rs33.getString("accept_oth_alt_id_yn"),"N"));
				hashMap20.put("patient_id_length",checkForNull(rs33.getString("patient_id_length"),"0"));
				hashMap20.put("alt_id1_type",	checkForNull(rs33.getString("alt_id1_type")));
				hashMap20.put("father_alt_id1_desc",checkForNull(rs33.getString("father_alt_id1_desc")));
				hashMap20.put("alt_id1_length",		checkForNull(rs33.getString("alt_id1_length")));
				hashMap20.put("alt_id1_len_validation_yn",checkForNull(rs33.getString("alt_id1_len_validation_yn")));
				hashMap20.put("alt_id1_routine_yn",checkForNull(rs33.getString("alt_id1_routine_yn")));
				hashMap20.put("alt_id1_data_source_id",checkForNull(rs33.getString("alt_id1_data_source_id")));
				hashMap20.put("alt_id1_chk_digit_scheme",checkForNull(rs33.getString("alt_id1_chk_digit_scheme")));
				hashMap20.put("alt_id1_accept_alphanumeric_yn",checkForNull(rs33.getString("alt_id1_accept_alphanumeric_yn")));
			}
			if(rs33 != null) rs33.close();
			if(pstmt1 != null) pstmt1.close();
		}
		catch(Exception e1) {
			e1.printStackTrace();
		}
		return hashMap20;
	}
	
	/*	The static method getMPCountryDesc retrives Country Long Descriptiopn based on the Country Code
    *	@Called in NewbornRegistrationMain.jsp files.
	*	@Table mp_country
	*	@Returns hashMap21
	*	@Throws Exception
	*/
	public static HashMap getMPCountryDesc(String temp10, Connection con,Properties p) throws Exception
	{
		Statement stmt		= null;
		ResultSet rs		= null;
		HashMap hashMap21	= null;
        String locale = p.getProperty("LOCALE");
		 
		try
		{
			hashMap21 = new HashMap();
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT country_code, long_desc FROM mp_country_lang_vw WHERE country_code = '"+temp10+"' AND language_id = '"+locale+"'  ORDER BY 2"); 
			
			if(rs != null && rs.next()) {
				hashMap21.put("country_code",	checkForNull(rs.getString("country_code")));
				hashMap21.put("long_desc",		checkForNull(rs.getString("long_desc")));
			}
			else
			{
				hashMap21.put("country_code",	"");
				hashMap21.put("long_desc",		"");
			}
			if(rs != null) rs.close();
		}
		catch(Exception e3)
		{
			e3.printStackTrace();
		}
		return hashMap21;
	}
	
	/*	The static method getMPRaceDesc retrives Country Long Descriptiopn based on the Country Code
    *	@Called in NewbornRegistrationMain.jsp files.
	*	@Table mp_race
	*	@Returns hashMap22
	*	@Throws Exception
	*/
	public static HashMap getMPRaceDesc(String temp11, Connection con,Properties p) throws Exception
	{
		Statement stmt		= null;
		ResultSet rs		= null;
		HashMap hashMap22	= null;
        String locale = p.getProperty("LOCALE");
		
		try
		{
			hashMap22 = new HashMap();
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT race_code, long_desc FROM mp_race_lang_vw WHERE race_code = '"+temp11+"' AND language_id = '"+locale+"'  ORDER BY 2"); 
			
			if(rs != null && rs.next()) {
				hashMap22.put("race_code",	checkForNull(rs.getString("race_code")));
				hashMap22.put("long_desc",		checkForNull(rs.getString("long_desc")));
			}
			else
			{
				hashMap22.put("race_code",	"");
				hashMap22.put("long_desc",	"");
			}
			if(rs != null) rs.close();
		}
		catch(Exception e3)
		{
			e3.printStackTrace();
		}
		return hashMap22;
	}

	/*	The static method getMPRaligionDesc retrives Raligion Long Descriptiopn based on the Raligion 	Code
    *	@Called in NewbornRegistrationMain.jsp file.
	*	@Table mp_religion
	*	@Returns hashMap23
	*	@Throws Exception
	*/
	public static HashMap getMPRaligionDesc(String temp13, Connection con,Properties p) throws Exception
	{
		Statement stmt		= null;
		ResultSet rs		= null;
		HashMap hashMap23	= null;
        String locale = p.getProperty("LOCALE");
		
		try
		{
			hashMap23 = new HashMap();
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT relgn_code, short_desc FROM mp_religion_lang_vw WHERE relgn_code = '"+temp13+"' AND language_id = '"+locale+"'  ORDER BY 2'"); 
			
			if(rs != null && rs.next()) {
				hashMap23.put("relgn_code",	checkForNull(rs.getString("relgn_code")));
				hashMap23.put("long_desc",		checkForNull(rs.getString("long_desc")));
			}
			else
			{
				hashMap23.put("relgn_code",	"");
				hashMap23.put("long_desc",	"");
			}
			if(rs != null) rs.close();
		}
		catch(Exception e3)
		{
			e3.printStackTrace();
		}
		return hashMap23;
	}
	
	/*	The static method getMPOccupClassDesc retrives Occup Class Short Descriptiopn based on the 		Occup Class Code
    *	@Called in NewbornRegistrationMain.jsp file.
	*	@Table mp_occupation_class
	*	@Returns hashMap24
	*	@Throws Exception
	*/
	public static HashMap getMPOccupClassDesc(String temp14, Connection con,Properties p) throws Exception
	{
		Statement stmt		= null;
		ResultSet rs		= null;
		HashMap hashMap24	= null;
        String locale = p.getProperty("LOCALE");
		

		try
		{
			hashMap24 = new HashMap();
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT ocpn_class_code, long_desc short_desc FROM mp_occupation_class_lang_vw WHERE ocpn_class_code = '"+temp14+"'  AND language_id = '"+locale+"' ORDER BY 2'"); 
			
			if(rs != null && rs.next()) {
				hashMap24.put("ocpn_class_code",	checkForNull(rs.getString("ocpn_class_code")));
				hashMap24.put("short_desc",		checkForNull(rs.getString("short_desc")));
			}
			else
			{
				hashMap24.put("ocpn_class_code",	"");
				hashMap24.put("short_desc",			"");
			}
			if(rs != null) rs.close();
		}
		catch(Exception e3)
		{
			e3.printStackTrace();
		}
		return hashMap24;
	}
	
	/*	The static method getMPOccupDesc retrives Occup Short Descriptiopn based on the 				Occup Code
    *	@Called in NewbornRegistrationMain.jsp file.
	*	@Table mp_occupation
	*	@Returns hashMap25
	*	@Throws Exception
	*/
	public static HashMap getMPOccupDesc(String temp15, Connection con,Properties p) throws Exception
	{
		Statement stmt		= null;
		ResultSet rs		= null;
		HashMap hashMap25	= null;
        String locale = p.getProperty("LOCALE");
		
		try
		{
			hashMap25 = new HashMap();
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT ocpn_code, short_desc FROM mp_occupation_lang_vw WHERE eff_status = 'E' AND ocpn_class_code = '"+temp15+"' AND language_id = '"+locale+"'  ORDER BY 2"); 
			
			if(rs != null && rs.next()) {
				hashMap25.put("ocpn_code",	checkForNull(rs.getString("ocpn_code")));
				hashMap25.put("short_desc",		checkForNull(rs.getString("short_desc")));
			}
			else
			{
				hashMap25.put("ocpn_code",	"");
				hashMap25.put("short_desc",	"");
			}
			if(rs != null) rs.close();
		}
		catch(Exception e3)
		{
			e3.printStackTrace();
		}
		return hashMap25;
	}


	/*	The static method getPatSerGroupGenId retrives Patiebt Series Group Code and Generate Patient 	ID Yes/No flage values.  
	*	@Called in MaintainBirthRegistrationMain.jsp file.
	*	@Table mp_pat_ser_grp
	*	@Returns array_list
	*	@Throws Exception
	*/

	public static ArrayList getPatSerGroupCodeGenId(Connection con,Properties p) throws Exception
	{
		Statement stmt	= null;
		ResultSet rs	= null;
		ArrayList array_list = null;
		String locale = p.getProperty("LOCALE");
		

		
		try
		{
			array_list = new ArrayList();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT pat_ser_grp_code, gen_pat_id_yn FROM mp_pat_ser_grp_lang_vw where language_id='"+locale+"'"); 
			while(rs != null && rs.next()) {
				array_list.add(checkForNull(rs.getString("pat_ser_grp_code")));
				array_list.add(checkForNull(rs.getString("gen_pat_id_yn")));
			}
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		catch(Exception e4)
		{
			e4.printStackTrace();
		}

		return array_list;
	}

	/*	The static method getNodeTypeShortDesc retrives Node Type, Short Description.
	*	@Called in MaintainBirthRegisterMain.jsp, NewbornRegistrationMain.jsp files.
	*	@Table mp_nod_type
	*	@Returns array_list1
	*	@Throws Exception
	*/

	public static ArrayList getNodeTypeShortDesc(Connection con,Properties p) throws Exception
	{
		Statement stmt	= null;
		ResultSet rs	= null;
		ArrayList array_list1 = null; 
		String locale = p.getProperty("LOCALE");
		

		try
		{
			array_list1 = new ArrayList();
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT nod_type, short_desc, delivery_indicator FROM mp_nod_type_lang_vw where eff_status='E' AND language_id = '"+locale+"'  ORDER BY 2"); 
			//rs = stmt.executeQuery("SELECT nod_type, short_desc, delivery_indicator FROM mp_nod_type where eff_status='E' ORDER BY 2"); 
			while(rs != null && rs.next()) {
				array_list1.add(checkForNull(rs.getString("nod_type")));
				array_list1.add(checkForNull(rs.getString("short_desc")));
				array_list1.add(checkForNull(rs.getString("delivery_indicator")));
			}
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();
		}
		catch(Exception e4)
		{
			e4.printStackTrace();
		}

		return array_list1;
	}

	/*	The static method getPractitionerNameID retrives Practitioner Name, Practitioner ID.
	*	Called in MaintainBirthRegistration.jsp, NewbornRegistration.jsp files.
	*	@View am_pract_for_facility_vw
	*	@Returns array_list2
	*	@Throws Exception
	*/

	public static ArrayList getPractitionerNameID(String facilityId,Connection con,Properties p) throws Exception
	{
		Statement stmt	= null;
		ResultSet rs	= null;
		ArrayList array_list2 = null; 
		String locale = p.getProperty("LOCALE");
		
		try
		{
			array_list2 = new ArrayList();
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT a.Practitioner_Id, b.practitoner_name FROM am_pract_for_facility a, am_practitioner_lang_vw b WHERE a.operating_facility_id = '"+facilityId+"' AND a.practitioner_id = b.practitioner_id and b.pract_type IN ('MW','NS')  AND a.eff_status = 'E' and b.language_id = '"+locale+"' ORDER BY 2"); 
			while(rs != null && rs.next()) {
				array_list2.add(checkForNull(rs.getString("Practitioner_Id")));
				array_list2.add(checkForNull(rs.getString("practitioner_name")));
			}
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		catch(Exception e4)
		{
			e4.printStackTrace();
		}

		return array_list2;
	}

	/*	The static method getComplnDeliveryCodeDesc retrives Compln Delivery Code & Desccription. 
	*	Called in MaintainBirthRegistration.jsp, NewbornRegistration.jsp files.
	*	@Table mp_compln_delivery
	*	@Returns array_list3
	*	@Throws Exception
	*/

	public static ArrayList getComplnDeliveryCodeDesc(Connection con,Properties p) throws Exception
	{
		Statement stmt	= null;
		ResultSet rs	= null;
		ArrayList array_list3 = null; 
		String locale = p.getProperty("LOCALE");
		
		try
		{
			array_list3 = new ArrayList();
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT compln_dely_code, short_desc FROM mp_compln_delivery_lang_vw WHERE eff_status = 'E' AND language_id = '"+locale+"'  ORDER BY 2"); 

			while(rs != null && rs.next()) {
				array_list3.add(checkForNull(rs.getString("compln_dely_code")));
				array_list3.add(checkForNull(rs.getString("short_desc")));
			}
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();
		}
		catch(Exception e4)
		{
			e4.printStackTrace();
		}

		return array_list3;
	}

	/*	The static method getComplnDeliveryCodeDesc retrives Compln Delivery Code & Desccription. 
	*	Called in MaintainBirthRegistration.jsp, NewbornRegistration.jsp files.
	*	@Table mp_compln_delivery
	*	@Returns array_list3
	*	@Throws Exception
	*/

	public static ArrayList getComplnsLabourCodeDesc(Connection con,Properties p,String labourType) throws Exception
	{
		Statement stmt	= null;
		ResultSet rs	= null;
		ArrayList array_list3 = null; 
		String locale = p.getProperty("LOCALE");
		
		try
		{
			array_list3 = new ArrayList(); 			
			stmt = con.createStatement();
			
			//Modified by Ashwini on 01-Feb-2019 for ML-MMOH-CRF-1109
			if(labourType.equals("First")) {
				rs = stmt.executeQuery("SELECT compln_dely_code, short_desc, long_desc FROM mp_compln_delivery_lang_vw WHERE eff_status = 'E' AND language_id = '"+locale+"' and complns_in_1st_stage_labour_yn = 'Y' and COMPLN_DELY_TYPE='M' ORDER BY 2"); 	
			} else if(labourType.equals("Second")) {
				rs = stmt.executeQuery("SELECT compln_dely_code, short_desc, long_desc FROM mp_compln_delivery_lang_vw WHERE eff_status = 'E' AND language_id = '"+locale+"' and complns_in_2nd_stage_labour_yn = 'Y' and COMPLN_DELY_TYPE='M' ORDER BY 2"); 	
			} else if(labourType.equals("Third")) {
				rs = stmt.executeQuery("SELECT compln_dely_code, short_desc, long_desc FROM mp_compln_delivery_lang_vw WHERE eff_status = 'E' AND language_id = '"+locale+"' and complns_in_3rd_stage_labour_yn = 'Y' and COMPLN_DELY_TYPE='M' ORDER BY 2"); 	
			}

			//rs = stmt.executeQuery("SELECT compln_dely_code, short_desc FROM mp_compln_delivery_lang_vw WHERE eff_status = 'E' AND language_id = '"+locale+"'  ORDER BY 2"); 

			while(rs != null && rs.next()) {
				array_list3.add(checkForNull(rs.getString("compln_dely_code")));
				array_list3.add(checkForNull(rs.getString("short_desc")));
				//Added by Ashwini on 01-Feb-2019 for ML-MMOH-CRF-1109
				array_list3.add(checkForNull(rs.getString("long_desc")));
			}
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();
		}
		catch(Exception e4)
		{
			e4.printStackTrace();
		}

		return array_list3;
	}

	/*	The static method getDeliveryIndicationCodeDesc retrives Delivery Indication Code & 			Desccription. 
	*	Called in MaintainBirthRegistration.jsp, NewbornRegistration.jsp files.
	*	@Table mp_delivery_indication
	*	@Returns array_list4
	*	@Throws Exception
	*/

	public static ArrayList getDeliveryIndicationCodeDesc(Connection con,Properties p) throws Exception
	{   
		Statement stmt	= null;
		ResultSet rs	= null;
		ArrayList array_list4 = null; 
		String locale = p.getProperty("LOCALE");
		
		try
		{
			array_list4 = new ArrayList();
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT dely_ind_code, short_desc FROM MP_DLVRY_INDICATION_LANG_VW WHERE eff_status = 'E'  AND language_id = '"+locale+"' ORDER BY 2"); 
			while(rs != null && rs.next()) {
				array_list4.add(checkForNull(rs.getString("dely_ind_code")));
				array_list4.add(checkForNull(rs.getString("short_desc")));
			}
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		catch(Exception e4)
		{
			e4.printStackTrace();
		}

		return array_list4;
	}

	/*	The static method getClinicNursingUnitCodeDesc retrives Clinic Code / Nursing Unit Code & Short		Desccription. 
	*	@Table op_clinic, ip_nursing_unit
	*	@Returns array_list5
	*	@Throws Exception
	*/

	public static ArrayList getClinicNursingUnitCodeDesc(String facilityId, String param, Connection con,Properties p) throws Exception 
	{
		Statement stmt	= null;
		ResultSet rs	= null;
		ArrayList array_list5 = null; 
		String locale = p.getProperty("LOCALE");
		
		
		try {
			array_list5 = new ArrayList();
			
			stmt = con.createStatement();
			if(param.equals("C"))
			{
				rs = stmt.executeQuery("SELECT long_desc short_desc, clinic_code FROM op_clinic_lang_vw WHERE facility_id ='"+facilityId+"' AND eff_status = 'E' AND level_of_care_ind = 'A' AND care_locn_type_ind = 'C' and language_id='"+locale+"' ORDER BY short_desc"); 
			} else if(param.equals("E")) {
				rs = stmt.executeQuery("SELECT long_desc short_desc, clinic_code FROM op_clinic_lang_vw WHERE facility_id = '"+facilityId+"'  AND eff_status = 'E' AND level_of_care_ind = 'E' AND care_locn_type_ind = 'C'  and  language_id='"+locale+"' ORDER BY short_desc"); 
				
			} else if(param.equals("D")) {
				rs = stmt.executeQuery("SELECT long_desc short_desc, clinic_code FROM op_clinic_lang_vw WHERE facility_id = '"+facilityId+"' AND EFF_STATUS = 'E' AND LEVEL_OF_CARE_IND = 'A' AND care_locn_type_ind = 'D' and  language_id='"+locale+"'  ORDER BY short_desc"); 
			} else if(param.equals("N")) {
				rs = stmt.executeQuery("SELECT long_desc short_desc, nursing_unit_code clinic_code FROM ip_nursing_unit_lang_vw WHERE facility_id = '"+facilityId+"' AND eff_status = 'E' AND patient_class = 'IP' and language_id='"+locale+"' ORDER BY short_desc"); 
			}
			/*Added by Ashwini on 27-Jun-2018 for ML-MMOH-CRF-0833*/
			else if(param.equals("O")) {
				rs = stmt.executeQuery("SELECT oper_room_code clinic_code, short_desc FROM ot_oper_room_lang_vw WHERE language_id = '"+locale+"' AND NVL (status, 'E') = 'E' AND operating_facility_id = '"+facilityId+"' ORDER BY short_desc"); 
			}
			else if(param.equals("P")) {
				rs = stmt.executeQuery("SELECT clinic_code, long_desc short_desc FROM op_clinic_lang_vw a WHERE facility_id = '"+facilityId+"' AND language_id = '"+locale+"' AND eff_status = 'E' AND clinic_type = 'E' ORDER BY short_desc"); 
			}
			else if(param.equals("W")) {
				rs = stmt.executeQuery("SELECT clinic_code, short_desc FROM rd_clinic_lang_vw WHERE language_id = '"+locale+"' AND NVL (status, 'E') = 'E' AND operating_facility_id = '"+facilityId+"' ORDER BY short_desc"); 
			}
			else if(param.equals("R")) {
				rs = stmt.executeQuery("SELECT room_num clinic_code, short_desc FROM am_facility_room_lang_vw WHERE language_id = '"+locale+"' AND eff_status = 'E' AND operating_facility_id = '"+facilityId+"' AND room_type = 'R' ORDER BY short_desc"); 
			}
			/*End ML-MMOH-CRF-0833*/

			while(rs != null && rs.next()) {
				array_list5.add(checkForNull(rs.getString("clinic_code")));
				array_list5.add(checkForNull(rs.getString("short_desc")));
			}
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		catch(Exception e4)
		{
			e4.printStackTrace();
		}

		return array_list5;
	}

	/*	The static method getCongenitalAnomaliesCodeDesc retrives Congenital Anomalies Code & Short		Desccription. 
	*	Called in MaintainBirthRegistration.jsp, NewbornRegistration.jsp files.
	*	@Table mp_congenital_anomalies
	*	@Returns array_list6
	*	@Throws Exception
	*/

	public static ArrayList getCongenitalAnomaliesCodeDesc(Connection con,Properties p) throws Exception
	{
		Statement stmt	= null;
		ResultSet rs	= null;
		ArrayList array_list6 = null; 
		String locale = p.getProperty("LOCALE");
		
		try
		{
			array_list6 = new ArrayList();
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT cong_anomalies_code, short_desc FROM MP_CONG_ANOMALIES_LANG_VW WHERE eff_status = 'E' AND language_id = '"+locale+"'  ORDER BY 2"); 
			while(rs != null && rs.next()) {
				array_list6.add(checkForNull(rs.getString("cong_anomalies_code")));
				array_list6.add(checkForNull(rs.getString("short_desc")));
			}
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();
		}
		catch(Exception e4)
		{
			e4.printStackTrace();
		}

		return array_list6;
	}

	/*	The static method getAlternateIDTypeDesc retrives Alternate ID Type Type & Short Desccription.
	*	Called in MaintainBirthRegistration.jsp, NewbornRegistration.jsp files.
	*	@Table mp_alternate_id_type
	*	@Returns array_list7
	*	@Throws Exception
	*/

	public static ArrayList getAlternateIDTypeDesc(Connection con,Properties p) throws Exception
	{
		Statement stmt	= null;
		ResultSet rs	= null;
		ArrayList array_list7 = null; 
		String locale = p.getProperty("LOCALE");
		

		try
		{
			array_list7 = new ArrayList();
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT alt_id_type, INITCAP(long_desc) short_desc FROM mp_alternate_id_type_lang_vw where alt_id_type NOT IN (SELECT alt_id1_type FROM mp_param UNION SELECT nvl(alt_id2_type,1) FROM mp_param UNION SELECT nvl(alt_id3_type,2) FROM mp_param UNION SELECT nvl(alt_id4_type,3) FROM mp_param) AND language_id='"+locale+"' and eff_status = 'E' ORDER BY 2"); 
			while(rs != null && rs.next()) {
				array_list7.add(checkForNull(rs.getString("alt_id_type")));
				array_list7.add(checkForNull(rs.getString("short_desc")));
			}
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();
		}
		catch(Exception e4)
		{
			e4.printStackTrace();
		}

		return array_list7;
	}

	/*	The static method getCountryCodeLongDesc retrives Country Code & Long Desccription. 
	*	Called in MaintainBirthRegistration.jsp, NewbornRegistration.jsp files.
	*	@Table mp_country
	*	@Returns array_list8
	*	@Throws Exception
	*/

	public static ArrayList getCountryCodeLongDesc(Connection con,Properties p) throws Exception
	{
		Statement stmt	= null;
		ResultSet rs	= null;
		ArrayList array_list8 = null; 
        String locale = p.getProperty("LOCALE");
		 
		
		try
		{
			array_list8 = new ArrayList();
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT country_code, long_desc FROM mp_country_lang_vw WHERE eff_status = 'E' AND language_id = '"+locale+"' order by 2");
			while(rs != null && rs.next()) {
				array_list8.add(checkForNull(rs.getString("country_code")));
				array_list8.add(checkForNull(rs.getString("long_desc")));
			}
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			
		}
		catch(Exception e4)
		{
			e4.printStackTrace();
		}

		return array_list8;
	}

	/*	The static method getRaceCodeLongDesc retrives Race Code & Long Desccription. 
	*	Called in MaintainBirthRegistration.jsp, NewbornRegistration.jsp files.
	*	@Table mp_race
	*	@Returns array_list9
	*	@Throws Exception
	*/

	public static ArrayList getRaceCodeLongDesc(Connection con,Properties p) throws Exception
	{
		Statement stmt	= null;
		ResultSet rs	= null;
		ArrayList array_list9 = null; 
		String locale = p.getProperty("LOCALE");
		 
		try
		{
			array_list9 = new ArrayList();
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT race_code, long_desc FROM mp_race_lang_vw WHERE eff_status = 'E' AND language_id = '"+locale+"'  ORDER BY 2"); 
			while(rs != null && rs.next()) {
				array_list9.add(checkForNull(rs.getString("race_code")));
				array_list9.add(checkForNull(rs.getString("long_desc")));
			}
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			
		}
		catch(Exception e4)
		{
			e4.printStackTrace();
		}

		return array_list9;
	}

	/*	The static method getReligionCodeShortDesc retrives Religion Code & Short Desccription. 
	*	Called in MaintainBirthRegistration.jsp, NewbornRegistration.jsp files.
	*	@Table mp_religion
	*	@Returns array_list10
	*	@Throws Exception
	*/

	public static ArrayList getReligionCodeShortDesc(Connection con,Properties p) throws Exception
	{
		Statement stmt	= null;
		ResultSet rs	= null;
		ArrayList array_list10 = null; 
        String locale = p.getProperty("LOCALE");
		
		
		try
		{
			array_list10 = new ArrayList();
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT relgn_code, short_desc FROM mp_religion_lang_vw WHERE eff_status = 'E'  AND language_id = '"+locale+"' ORDER BY 2");  
			while(rs != null && rs.next()) {
				array_list10.add(checkForNull(rs.getString("relgn_code")));
				array_list10.add(checkForNull(rs.getString("short_desc")));
			}
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			
		}
		catch(Exception e4)
		{
			e4.printStackTrace();
		}

		return array_list10;
	}

	/*	The static method getOccupationClassCodeShortDesc retrives Occupation Class Code & Short  		Desccription. 
	*	Called in MaintainBirthRegistration.jsp, NewbornRegistration.jsp files.
	*	@Table mp_occupation_class
	*	@Returns array_list11
	*	@Throws Exception
	*/

	public static ArrayList getOccupationClassCodeShortDesc(Connection con,Properties p) throws Exception
	{
		Statement stmt	= null;
		ResultSet rs	= null;
		ArrayList array_list11 = null;
		String locale = p.getProperty("LOCALE");
		
		
		try
		{
			array_list11 = new ArrayList();
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT ocpn_class_code, long_desc short_desc FROM mp_occupation_class_lang_vw WHERE eff_status = 'E'  AND language_id = '"+locale+"' ORDER BY 2");  
			while(rs != null && rs.next()) {
				array_list11.add(checkForNull(rs.getString("ocpn_class_code")));
				array_list11.add(checkForNull(rs.getString("short_desc")));
			}
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			
		}
		catch(Exception e4)
		{
			e4.printStackTrace();
		}

		return array_list11;
	}

	/*	The static method getOccupationCodeShortDesc retrives Occupation Code & Short Desccription. 
	*	@Table mp_occupation
	*	@Returns array_list12
	*	@Throws Exception
	*/

	public static ArrayList getOccupationCodeShortDesc(String q_FATHER_OCPN_CLASS_CODE, Connection con,Properties p) throws Exception
	{
		Statement stmt	= null;
		ResultSet rs	= null;
		ArrayList array_list12 = null; 
		String locale = p.getProperty("LOCALE");
		
		try
		{
			array_list12 = new ArrayList();
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT ocpn_code, short_desc FROM mp_occupation_lang_vw WHERE eff_status = 'E' AND ocpn_class_code = '"+q_FATHER_OCPN_CLASS_CODE+"' AND language_id = '"+locale+"'  ORDER BY 2"); 
			while(rs != null && rs.next()) {
				array_list12.add(checkForNull(rs.getString("ocpn_code")));
				array_list12.add(checkForNull(rs.getString("short_desc")));
			}
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			
		}
		catch(Exception e4)
		{
			e4.printStackTrace();
		}

		return array_list12;
	}

	/*	The static method getPatSerGroupGenIdPrefixReqd retrives Patiebt Series Group Code and Generate Patient 	ID Yes/No flage values.  
	*	@Called in NewbornRegistrationMain.jsp file.
	*	@Table mp_pat_ser_grp
	*	@Returns array_list13
	*	@Throws Exception
	*/

	public static ArrayList getPatSerGroupGenIdPrefixReqd(Connection con,Properties p) throws Exception
	{
		Statement stmt	= null;
		ResultSet rs	= null;
		ArrayList array_list13 = null; 
	

		try
		{
			array_list13 = new ArrayList();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT pat_ser_grp_code, gen_pat_id_yn, prefix_reqd_yn FROM mp_pat_ser_grp"); 
			while(rs != null && rs.next()) {
				array_list13.add(checkForNull(rs.getString("pat_ser_grp_code")));
				array_list13.add(checkForNull(rs.getString("gen_pat_id_yn")));
				array_list13.add(checkForNull(rs.getString("prefix_reqd_yn")));
			}
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		catch(Exception e4)
		{
			e4.printStackTrace();
		}

		return array_list13;
	}

/*	The static method getPatSerGroupGenIdPrefixReqd retrives Patiebt Series Group Code and Generate Patient 	ID Yes/No flage values.  
	*	@Called in NewbornRegistrationMain.jsp file.
	*	@Table mp_pat_ser_grp
	*	@Returns array_list13
	*	@Throws Exception
	*/

	public static ArrayList getRelationship(Connection con,Properties p) throws Exception
	{
		Statement statement	= null;
		ResultSet resultset	= null;
		ArrayList array_list14 = null; 
		String locale = p.getProperty("LOCALE");
		

		try
		{
			array_list14 = new ArrayList();
			statement = con.createStatement();
			resultset = statement.executeQuery("SELECT relationship_code, INITCAP(short_desc) short_desc FROM mp_relationship_lang_vw WHERE eff_status = 'E' and language_id='"+locale+"' ORDER BY 2"); 
			while( resultset.next()){
				
			array_list14.add(checkForNull(resultset.getString("short_desc")));
            array_list14.add(checkForNull(resultset.getString("relationship_code")));
			}

                if(resultset != null)
                    resultset.close();
				if(statement != null) statement.close();
		}
		catch(Exception e4)
		{
			e4.printStackTrace();
		}

		return array_list14;
	}
	 /*	The static method getNewBornRelation retrives Defualt Newborn Relation value from mp_param table
	*	@Table mp_birth_register
	*	@Returns hashMap1
	*	@Throws Exception
	*/
	public static HashMap getNewBornRelation(Connection con,Properties p) throws Exception
	{
		Statement stmt		= null;
		ResultSet rs		= null;
		HashMap hashMap26	= null;
		String locale = p.getProperty("LOCALE");

		try
		{
			hashMap26 = new HashMap();
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT nb_female_relnship, (SELECT short_desc  FROM mp_relationship_lang_vw  WHERE relationship_code = nb_female_relnship and language_id='"+locale+"') female_relation_desc,nb_male_relnship,(SELECT short_desc    FROM mp_relationship_lang_vw  WHERE relationship_code = nb_male_relnship and language_id='"+locale+"') male_relation_desc, nb_unknown_relnship,(SELECT short_desc  FROM mp_relationship_lang_vw  WHERE relationship_code = nb_unknown_relnship and language_id='"+locale+"') unknown_relation_desc  FROM mp_param_lang_vw where module_id = 'MP' and language_id='"+locale+"'"); 
			
			if(rs != null && rs.next()) 
			{
				hashMap26.put("nb_female_relnship",checkForNull(rs.getString("nb_female_relnship")));
				hashMap26.put("female_relation_desc",checkForNull(rs.getString("female_relation_desc")));
				hashMap26.put("nb_male_relnship",checkForNull(rs.getString("nb_male_relnship")));
				hashMap26.put("male_relation_desc",checkForNull(rs.getString("male_relation_desc")));
				hashMap26.put("nb_unknown_relnship",checkForNull(rs.getString("nb_unknown_relnship")));
				hashMap26.put("unknown_relation_desc",checkForNull(rs.getString("unknown_relation_desc")));
			}
			
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}
		return hashMap26;
	}

     /*	The static method getNewBornRelMandatory Tells whether the Relation of Organisation head to the Newborn is Madatory or not
	*	@Table mp_birth_register
	*	@Returns Boolean
	*	@Throws Exception
	*/
	public static HashMap getNewBornRelMandatory(Connection con,Properties p) throws Exception
	{
		Statement stmt		= null;
		ResultSet rs		= null;
		//boolean flag		= false;
		//String family_org_id_accept_yn	= "";
		//String family_no_link_yn		= "";
		HashMap hash_15=null;
		try
		{
			hash_15=new HashMap();			
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT ORG_MEMBER_RELATIONSHIP_CODE,FAMILY_ORG_ID_ACCEPT_YN,FAMILY_NO_LINK_YN,entitlement_by_pat_cat_yn,to_char(sysdate+alt_id1_exp_grace_days,'dd/mm/yyyy') alt_id1_exp_grace_days,to_char(sysdate+alt_id2_exp_grace_days,'dd/mm/yyyy') alt_id2_exp_grace_days,to_char(sysdate+alt_id3_exp_grace_days,'dd/mm/yyyy') alt_id3_exp_grace_days,to_char(sysdate+alt_id4_exp_grace_days,'dd/mm/yyyy') alt_id4_exp_grace_days,invoke_routine,nat_data_source_id,nat_id_check_digit_id,nat_id_chk_len,single_stage_nb_reg_appl_yn,data_upd_allowed_aft_final_yn,name_prefix_male_nb,name_prefix_female_nb,name_suffix_male_nb,name_suffix_female_nb  FROM mp_param where module_id='MP'"); 
			
			if(rs != null && rs.next()) 
			{
               hash_15.put("FAMILY_ORG_ID_ACCEPT_YN",checkForNull(rs.getString("FAMILY_ORG_ID_ACCEPT_YN")));
               hash_15.put("FAMILY_NO_LINK_YN",checkForNull(rs.getString("FAMILY_NO_LINK_YN")));
               hash_15.put("entitlement_by_pat_cat_yn",checkForNull(rs.getString("entitlement_by_pat_cat_yn")));
               hash_15.put("ORG_MEMBER_RELATIONSHIP_CODE",checkForNull(rs.getString("ORG_MEMBER_RELATIONSHIP_CODE")));
			   hash_15.put("alt_id1_exp_grace_days",checkForNull(rs.getString("alt_id1_exp_grace_days")));
			   hash_15.put("alt_id2_exp_grace_days",checkForNull(rs.getString("alt_id2_exp_grace_days")));
			   hash_15.put("alt_id3_exp_grace_days",checkForNull(rs.getString("alt_id3_exp_grace_days")));
			   hash_15.put("alt_id4_exp_grace_days",checkForNull(rs.getString("alt_id4_exp_grace_days")));
			   hash_15.put("invoke_routine",checkForNull(rs.getString("invoke_routine")));
			   hash_15.put("nat_data_source_id",checkForNull(rs.getString("nat_data_source_id")));
			   hash_15.put("nat_id_check_digit_id",checkForNull(rs.getString("nat_id_check_digit_id")));
			   hash_15.put("nat_id_chk_len",checkForNull(rs.getString("nat_id_chk_len")));
			   hash_15.put("single_stage_nb_reg_appl_yn",checkForNull(rs.getString("single_stage_nb_reg_appl_yn")));
			   hash_15.put("data_upd_allowed_aft_final_yn",checkForNull(rs.getString("data_upd_allowed_aft_final_yn")));
			   hash_15.put("name_prefix_male_nb",checkForNull(rs.getString("name_prefix_male_nb")));
			   hash_15.put("name_prefix_female_nb",checkForNull(rs.getString("name_prefix_female_nb")));
			   hash_15.put("name_suffix_male_nb",checkForNull(rs.getString("name_suffix_male_nb")));
			   hash_15.put("name_suffix_female_nb",checkForNull(rs.getString("name_suffix_female_nb")));
			}
			
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return hash_15;
	}
	/*	The static method getPatCatogery gives the Patient Category from table
	*	@mp_pat_category_deriv_rule and mp_patient
	*	@Returns Boolean
	*	@Throws Exception
	*/
	public static ArrayList getPatCatogery(Connection con,String patient_id,String name_prefix,String relationship_to_head,Properties p) throws Exception
	{
		Statement stmt			= null;
		ResultSet rs			= null;
		//boolean flag			= false;
        ArrayList array_list15	= null;
		String locale = p.getProperty("LOCALE");
		name_prefix=singleToDoubleQuotes(name_prefix);
		
		try
		{
			array_list15 = new ArrayList();			
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery("SELECT entitlement_by_pat_cat_yn,family_org_id_accept_yn  FROM mp_param"); 
			String family_org_id_accept_yn="";
			String entitlement_by_pat_cat_yn="";

			if(rs != null && rs.next()) 
			{
               family_org_id_accept_yn=checkForNull(rs.getString("FAMILY_ORG_ID_ACCEPT_YN"));
               entitlement_by_pat_cat_yn=checkForNull(rs.getString("entitlement_by_pat_cat_yn"));
			}
			if(rs != null) rs.close();
			if(entitlement_by_pat_cat_yn.equals("Y") && family_org_id_accept_yn.equals("Y"))
			{
				String sql="select FAMILY_ORG_MEMBERSHIP from mp_patient where patient_id='"+patient_id+"'";
				String family_org_membership="";
				rs=stmt.executeQuery(sql);
                if(rs != null && rs.next()) 
			    {
               		family_org_membership=checkForNull(rs.getString("FAMILY_ORG_MEMBERSHIP"));
			    }
                if(rs != null) rs.close();
				String sql1="";
				//family_org_membership="2"; Commented By Sudhakar
                if(family_org_membership.equals("4"))
				{
					 sql1="select a.PAT_CAT_CODE,b.short_desc patcategory from mp_pat_category_deriv_rule a,mp_pat_category_lang_vw b where a.pat_cat_code=b.pat_cat_code and a.MEMBERSHIP_TYPE='4' and a.FAMILY_ORG_ID like '%*NA%' and a.FAMILY_ORG_SUB_ID like '%*NA%' and b.language_id='"+locale+"' and a.RELATIONSHIP_CODE like '%*ALL%'";
					 rs=stmt.executeQuery(sql1);
					 while(rs.next())
					 {
						  array_list15.add(checkForNull(rs.getString("patcategory")));
					      array_list15.add(checkForNull(rs.getString("PAT_CAT_CODE")));
					 }
					 if(rs!=null)rs.close();
					 
				}
				if(family_org_membership.equals("1")){
					String tsql1="select name_prefix,family_org_membership,family_org_sub_id,family_org_id,relationship_to_head from mp_patient where patient_id='"+patient_id+"'";
					String family_org_sub_id="";
					String family_org_id="";
					rs=stmt.executeQuery(tsql1);
					if(rs.next()){
                      family_org_sub_id=rs.getString("FAMILY_ORG_SUB_ID");
                      family_org_id=rs.getString("FAMILY_ORG_ID");
					}
					if(rs != null) rs.close();
					sql="select a.pat_cat_code,b.short_desc patcategory from mp_pat_category_deriv_rule a,mp_pat_category_lang_vw b where a.pat_cat_code=b.pat_cat_code and a.membership_type='1' and a.family_org_id = '"+family_org_id+"' and a.name_prefix='"+name_prefix+"' and a.family_org_sub_id ='"+family_org_sub_id+"'  and a.relationship_code = '"+relationship_to_head+"'and b.language_id='"+locale+"' ";
					rs=stmt.executeQuery(sql);
					rs.last();
					int  maxrecord = rs.getRow();
					rs.beforeFirst();
					if(maxrecord>0){
						while(rs.next()){
							array_list15.add(checkForNull(rs.getString("patcategory")));
							array_list15.add(checkForNull(rs.getString("PAT_CAT_CODE")));
						 }
						 if(rs != null) rs.close();
					}else{ 
						String sqlnorec="select a.pat_cat_code,b.short_desc patcategory from mp_pat_category_deriv_rule a,mp_pat_category_lang_vw b where a.pat_cat_code=b.pat_cat_code and a.membership_type='1' and a.family_org_id = '"+family_org_id+"' and a.name_prefix='"+name_prefix+"' and a.family_org_sub_id ='"+family_org_sub_id+"' and a.relationship_code ='*ALL' and b.language_id='"+locale+"'";
						rs=stmt.executeQuery(sqlnorec);
						rs.last();
						maxrecord = rs.getRow();
						rs.beforeFirst();
						if(maxrecord>0){
							while(rs.next()){
								array_list15.add(checkForNull(rs.getString("patcategory")));
								array_list15.add(checkForNull(rs.getString("PAT_CAT_CODE")));
							 }
						}else{
							sqlnorec="select a.pat_cat_code,b.short_desc patcategory from mp_pat_category_deriv_rule a,mp_pat_category_lang_vw b where a.pat_cat_code=b.pat_cat_code and a.membership_type='1' and a.family_org_id = '"+family_org_id+"' and a.name_prefix='*ALL' and a.family_org_sub_id ='"+family_org_sub_id+"' and a.relationship_code ='"+relationship_to_head+"' and b.language_id='"+locale+"'";
							rs=stmt.executeQuery(sqlnorec);
							rs.last();
							maxrecord = rs.getRow();
							rs.beforeFirst();
							if(maxrecord>0){
								while(rs.next()){
									array_list15.add(checkForNull(rs.getString("patcategory")));
									array_list15.add(checkForNull(rs.getString("PAT_CAT_CODE")));
								 }
							}else{
								sqlnorec="select a.pat_cat_code,b.short_desc patcategory from mp_pat_category_deriv_rule a,mp_pat_category_lang_vw b where a.pat_cat_code=b.pat_cat_code and a.membership_type='1' and a.family_org_id = '"+family_org_id+"' and a.name_prefix='*ALL' and a.family_org_sub_id ='"+family_org_sub_id+"' and a.relationship_code ='*ALL' and b.language_id='"+locale+"'";
								rs=stmt.executeQuery(sqlnorec);
								rs.last();
								maxrecord = rs.getRow();
								rs.beforeFirst();
								if(maxrecord>0){
									while(rs.next()){
										array_list15.add(checkForNull(rs.getString("patcategory")));
										array_list15.add(checkForNull(rs.getString("PAT_CAT_CODE")));
									 }
								}else{
									sqlnorec="select a.pat_cat_code,b.short_desc patcategory from mp_pat_category_deriv_rule a,mp_pat_category_lang_vw b where a.pat_cat_code=b.pat_cat_code and a.membership_type='1' and a.family_org_id = '"+family_org_id+"' and a.name_prefix='"+name_prefix+"' and a.family_org_sub_id ='*ALL' and a.relationship_code ='"+relationship_to_head+"' and b.language_id='"+locale+"'";
									rs=stmt.executeQuery(sqlnorec);
									rs.last();
									maxrecord = rs.getRow();
									rs.beforeFirst();
									if(maxrecord>0){
										while(rs.next()){
											array_list15.add(checkForNull(rs.getString("patcategory")));
											array_list15.add(checkForNull(rs.getString("PAT_CAT_CODE")));
										 }
									}else{
										sqlnorec="select a.pat_cat_code,b.short_desc patcategory from mp_pat_category_deriv_rule a,mp_pat_category_lang_vw b where a.pat_cat_code=b.pat_cat_code and a.membership_type='1' and a.family_org_id = '"+family_org_id+"' and a.name_prefix='"+name_prefix+"' and a.family_org_sub_id ='*ALL' and a.relationship_code ='*ALL' and b.language_id='"+locale+"'";
										rs=stmt.executeQuery(sqlnorec);
										rs.last();
										maxrecord = rs.getRow();
										rs.beforeFirst();
										if(maxrecord>0){
											while(rs.next()){
												array_list15.add(checkForNull(rs.getString("patcategory")));
												array_list15.add(checkForNull(rs.getString("PAT_CAT_CODE")));
											 }
										}else{
											sqlnorec="select a.pat_cat_code,b.short_desc patcategory from mp_pat_category_deriv_rule a,mp_pat_category_lang_vw b where a.pat_cat_code=b.pat_cat_code and a.membership_type='1' and a.family_org_id = '"+family_org_id+"' and a.name_prefix='*ALL' and a.family_org_sub_id ='*ALL' and a.relationship_code ='"+relationship_to_head+"' and b.language_id='"+locale+"'";
											rs=stmt.executeQuery(sqlnorec);
											rs.last();
											maxrecord = rs.getRow();
											rs.beforeFirst();
											if(maxrecord>0){
												while(rs.next()){
													array_list15.add(checkForNull(rs.getString("patcategory")));
													array_list15.add(checkForNull(rs.getString("PAT_CAT_CODE")));
												 }
											}else{
												sqlnorec="select a.pat_cat_code,b.short_desc patcategory from mp_pat_category_deriv_rule a,mp_pat_category_lang_vw b where a.pat_cat_code=b.pat_cat_code and a.membership_type='1' and a.family_org_id = '"+family_org_id+"' and a.name_prefix='*ALL' and a.family_org_sub_id ='*ALL' and a.relationship_code ='*ALL' and b.language_id='"+locale+"'";
												rs=stmt.executeQuery(sqlnorec);
												rs.last();
												maxrecord = rs.getRow();
												rs.beforeFirst();
												if(maxrecord>0){
													while(rs.next()){
														array_list15.add(checkForNull(rs.getString("patcategory")));
														array_list15.add(checkForNull(rs.getString("PAT_CAT_CODE")));
													 }
												}else{
													sqlnorec="select a.pat_cat_code,b.short_desc patcategory from mp_pat_category_deriv_rule a,mp_pat_category_lang_vw b where a.pat_cat_code=b.pat_cat_code and a.membership_type='1' and a.family_org_id = '*ALL' and a.name_prefix='"+name_prefix+"' and a.family_org_sub_id ='*ALL' and a.relationship_code ='"+relationship_to_head+"' and b.language_id='"+locale+"'";
													rs=stmt.executeQuery(sqlnorec);
													rs.last();
													maxrecord = rs.getRow();
													rs.beforeFirst();
													if(maxrecord>0){
														while(rs.next()){
															array_list15.add(checkForNull(rs.getString("patcategory")));
															array_list15.add(checkForNull(rs.getString("PAT_CAT_CODE")));
														 }
													}else{
														sqlnorec="select a.pat_cat_code,b.short_desc patcategory from mp_pat_category_deriv_rule a,mp_pat_category_lang_vw b where a.pat_cat_code=b.pat_cat_code and a.membership_type='1' and a.family_org_id = '*ALL' and a.name_prefix='"+name_prefix+"' and a.family_org_sub_id ='*ALL' and a.relationship_code ='*ALL' and b.language_id='"+locale+"'";
														rs=stmt.executeQuery(sqlnorec);
														rs.last();
														maxrecord = rs.getRow();
														rs.beforeFirst();
														if(maxrecord>0){
															while(rs.next()){
																array_list15.add(checkForNull(rs.getString("patcategory")));
																array_list15.add(checkForNull(rs.getString("PAT_CAT_CODE")));
															 }
														}else{
															sqlnorec="select a.pat_cat_code,b.short_desc patcategory from mp_pat_category_deriv_rule a,mp_pat_category_lang_vw b where a.pat_cat_code=b.pat_cat_code and a.membership_type='1' and a.family_org_id = '*ALL' and a.name_prefix='*ALL' and a.family_org_sub_id ='*ALL' and a.relationship_code ='"+relationship_to_head+"' and b.language_id='"+locale+"'";
															rs=stmt.executeQuery(sqlnorec);
															rs.last();
															maxrecord = rs.getRow();
															rs.beforeFirst();
															if(maxrecord>0){
																while(rs.next()){
																	array_list15.add(checkForNull(rs.getString("patcategory")));
																	array_list15.add(checkForNull(rs.getString("PAT_CAT_CODE")));
																 }
															}else{
																sqlnorec="select a.pat_cat_code,b.short_desc patcategory from mp_pat_category_deriv_rule a,mp_pat_category_lang_vw b where a.pat_cat_code=b.pat_cat_code and a.membership_type='1' and a.family_org_id = '*ALL' and a.name_prefix='*ALL' and a.family_org_sub_id ='*ALL' and a.relationship_code ='*ALL' and b.language_id='"+locale+"'";
																rs=stmt.executeQuery(sqlnorec);
																rs.last();
																maxrecord = rs.getRow();
																rs.beforeFirst();
																if(maxrecord>0){
																	while(rs.next()){
																		array_list15.add(checkForNull(rs.getString("patcategory")));
																		array_list15.add(checkForNull(rs.getString("PAT_CAT_CODE")));
																	 }
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					 }
				}if(family_org_membership.equals("2") || family_org_membership.equals("3")){
					String tsql1="select name_prefix,family_org_membership,family_org_sub_id,family_org_id,relationship_to_head from mp_patient where patient_id='"+patient_id+"'";
					String family_org_sub_id="";
					String family_org_id="";
					rs=stmt.executeQuery(tsql1);
					if(rs.next())
					{
                      family_org_sub_id=rs.getString("FAMILY_ORG_SUB_ID");
                      family_org_id=rs.getString("FAMILY_ORG_ID");
					}
					if(rs != null) rs.close();
					sql="select a.pat_cat_code,b.short_desc patcategory from mp_pat_category_deriv_rule a,mp_pat_category_lang_vw b where a.pat_cat_code=b.pat_cat_code and (a.membership_type='2' or a.membership_type='3') and a.family_org_id = '"+family_org_id+"' and a.name_prefix='"+name_prefix+"' and a.family_org_sub_id ='"+family_org_sub_id+"'  and a.relationship_code = '"+relationship_to_head+"' and b.language_id='"+locale+"'";
					rs=stmt.executeQuery(sql);
					rs.last();
					int maxrecord = rs.getRow();
					rs.beforeFirst();
					if(maxrecord>0){
						while(rs.next()){
							array_list15.add(checkForNull(rs.getString("patcategory")));
							array_list15.add(checkForNull(rs.getString("PAT_CAT_CODE")));
						}
					}else{ 
						String sqlnorec="select a.pat_cat_code,b.short_desc patcategory from mp_pat_category_deriv_rule a,mp_pat_category_lang_vw b where a.pat_cat_code=b.pat_cat_code and (a.membership_type='2' or a.membership_type='3') and a.family_org_id = '"+family_org_id+"' and a.name_prefix='"+name_prefix+"' and a.family_org_sub_id ='"+family_org_sub_id+"' and a.relationship_code ='*ALL' and b.language_id='"+locale+"'";
						rs=stmt.executeQuery(sqlnorec);
						rs.last();
						maxrecord = rs.getRow();
						rs.beforeFirst();
						if(maxrecord>0){
							while(rs.next()){
								array_list15.add(checkForNull(rs.getString("patcategory")));
								array_list15.add(checkForNull(rs.getString("PAT_CAT_CODE")));
							 }
						}else{
							sqlnorec="select a.pat_cat_code,b.short_desc patcategory from mp_pat_category_deriv_rule a,mp_pat_category_lang_vw b where a.pat_cat_code=b.pat_cat_code and (a.membership_type='2' or a.membership_type='3') and a.family_org_id = '"+family_org_id+"' and a.name_prefix='*ALL' and a.family_org_sub_id ='"+family_org_sub_id+"' and a.relationship_code = '"+relationship_to_head+"' and b.language_id='"+locale+"'";
							rs=stmt.executeQuery(sqlnorec);
							rs.last();
							maxrecord = rs.getRow();
							rs.beforeFirst();
							if(maxrecord>0){
								while(rs.next()){
									array_list15.add(checkForNull(rs.getString("patcategory")));
									array_list15.add(checkForNull(rs.getString("PAT_CAT_CODE")));
								 }
							}else{
								sqlnorec="select a.pat_cat_code,b.short_desc patcategory from mp_pat_category_deriv_rule a,mp_pat_category_lang_vw b where a.pat_cat_code=b.pat_cat_code and (a.membership_type='2' or a.membership_type='3') and a.family_org_id = '"+family_org_id+"' and a.name_prefix='*ALL' and a.family_org_sub_id ='"+family_org_sub_id+"' and a.relationship_code = '*ALL' and b.language_id='"+locale+"'";
								rs=stmt.executeQuery(sqlnorec);
								rs.last();
								maxrecord = rs.getRow();
								rs.beforeFirst();
								if(maxrecord>0){
									while(rs.next()){
										array_list15.add(checkForNull(rs.getString("patcategory")));
										array_list15.add(checkForNull(rs.getString("PAT_CAT_CODE")));
									 }
								}else{
									sqlnorec="select a.pat_cat_code,b.short_desc patcategory from mp_pat_category_deriv_rule a,mp_pat_category_lang_vw b where a.pat_cat_code=b.pat_cat_code and (a.membership_type='2' or a.membership_type='3') and a.family_org_id = '"+family_org_id+"' and a.name_prefix='"+name_prefix+"' and a.family_org_sub_id ='*ALL' and a.relationship_code = '"+relationship_to_head+"' and b.language_id='"+locale+"'";
									rs=stmt.executeQuery(sqlnorec);
									rs.last();
									maxrecord = rs.getRow();
									rs.beforeFirst();
									if(maxrecord>0){
										while(rs.next()){
											array_list15.add(checkForNull(rs.getString("patcategory")));
											array_list15.add(checkForNull(rs.getString("PAT_CAT_CODE")));
										 }
									}else{
										sqlnorec="select a.pat_cat_code,b.short_desc patcategory from mp_pat_category_deriv_rule a,mp_pat_category_lang_vw b where a.pat_cat_code=b.pat_cat_code and (a.membership_type='2' or a.membership_type='3') and a.family_org_id = '"+family_org_id+"' and a.name_prefix='"+name_prefix+"' and a.family_org_sub_id ='*ALL' and a.relationship_code = '*ALL' and b.language_id='"+locale+"'";
										rs=stmt.executeQuery(sqlnorec);
										rs.last();
										maxrecord = rs.getRow();
										rs.beforeFirst();
										if(maxrecord>0){
											while(rs.next()){
												array_list15.add(checkForNull(rs.getString("patcategory")));
												array_list15.add(checkForNull(rs.getString("PAT_CAT_CODE")));
											 }
										}else{
											sqlnorec="select a.pat_cat_code,b.short_desc patcategory from mp_pat_category_deriv_rule a,mp_pat_category_lang_vw b where a.pat_cat_code=b.pat_cat_code and (a.membership_type='2' or a.membership_type='3') and a.family_org_id = '"+family_org_id+"' and a.name_prefix='*ALL' and a.family_org_sub_id ='*ALL' and a.relationship_code = '"+relationship_to_head+"' and b.language_id='"+locale+"'";
											rs=stmt.executeQuery(sqlnorec);
											rs.last();
											maxrecord = rs.getRow();
											rs.beforeFirst();
											if(maxrecord>0){
												while(rs.next()){
													array_list15.add(checkForNull(rs.getString("patcategory")));
													array_list15.add(checkForNull(rs.getString("PAT_CAT_CODE")));
												 }
											}else{
												sqlnorec="select a.pat_cat_code,b.short_desc patcategory from mp_pat_category_deriv_rule a,mp_pat_category_lang_vw b where a.pat_cat_code=b.pat_cat_code and (a.membership_type='2' or a.membership_type='3') and a.family_org_id = '"+family_org_id+"' and a.name_prefix='*ALL' and a.family_org_sub_id ='*ALL' and a.relationship_code = '*ALL' and b.language_id='"+locale+"'";
												rs=stmt.executeQuery(sqlnorec);
												rs.last();
												maxrecord = rs.getRow();
												rs.beforeFirst();
												if(maxrecord>0){
													while(rs.next()){
														array_list15.add(checkForNull(rs.getString("patcategory")));
														array_list15.add(checkForNull(rs.getString("PAT_CAT_CODE")));
													 }
												}else{
													sqlnorec="select a.pat_cat_code,b.short_desc patcategory from mp_pat_category_deriv_rule a,mp_pat_category_lang_vw b where a.pat_cat_code=b.pat_cat_code and (a.membership_type='2' or a.membership_type='3') and a.family_org_id = '*ALL' and a.name_prefix='"+name_prefix+"' and a.family_org_sub_id ='*ALL' and a.relationship_code = '"+relationship_to_head+"' and b.language_id='"+locale+"'";
													rs=stmt.executeQuery(sqlnorec);
													rs.last();
													maxrecord = rs.getRow();
													rs.beforeFirst();
													if(maxrecord>0){
														while(rs.next()){
															array_list15.add(checkForNull(rs.getString("patcategory")));
															array_list15.add(checkForNull(rs.getString("PAT_CAT_CODE")));
														 }
													}else{
														sqlnorec="select a.pat_cat_code,b.short_desc patcategory from mp_pat_category_deriv_rule a,mp_pat_category_lang_vw b where a.pat_cat_code=b.pat_cat_code and (a.membership_type='2' or a.membership_type='3') and a.family_org_id = '*ALL' and a.name_prefix='"+name_prefix+"' and a.family_org_sub_id ='*ALL' and a.relationship_code = '*ALL' and b.language_id='"+locale+"'";
														rs=stmt.executeQuery(sqlnorec);
														rs.last();
														maxrecord = rs.getRow();
														rs.beforeFirst();
														if(maxrecord>0){
															while(rs.next()){
																array_list15.add(checkForNull(rs.getString("patcategory")));
																array_list15.add(checkForNull(rs.getString("PAT_CAT_CODE")));
															 }
														}else{
															sqlnorec="select a.pat_cat_code,b.short_desc patcategory from mp_pat_category_deriv_rule a,mp_pat_category_lang_vw b where a.pat_cat_code=b.pat_cat_code and (a.membership_type='2' or a.membership_type='3') and a.family_org_id = '*ALL' and a.name_prefix='*ALL' and a.family_org_sub_id ='*ALL' and a.relationship_code = '"+relationship_to_head+"' and b.language_id='"+locale+"'";
															rs=stmt.executeQuery(sqlnorec);
															rs.last();
															maxrecord = rs.getRow();
															rs.beforeFirst();
															if(maxrecord>0){
																while(rs.next()){
																	array_list15.add(checkForNull(rs.getString("patcategory")));
																	array_list15.add(checkForNull(rs.getString("PAT_CAT_CODE")));
																 }
															}else{
																sqlnorec="select a.pat_cat_code,b.short_desc patcategory from mp_pat_category_deriv_rule a,mp_pat_category_lang_vw b where a.pat_cat_code=b.pat_cat_code and (a.membership_type='2' or a.membership_type='3') and a.family_org_id = '*ALL' and a.name_prefix='*ALL' and a.family_org_sub_id ='*ALL' and a.relationship_code = '*ALL' and b.language_id='"+locale+"'";
																rs=stmt.executeQuery(sqlnorec);
																rs.last();
																maxrecord = rs.getRow();
																rs.beforeFirst();
																if(maxrecord>0){
																	while(rs.next()){
																		array_list15.add(checkForNull(rs.getString("patcategory")));
																		array_list15.add(checkForNull(rs.getString("PAT_CAT_CODE")));
																	 }
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}//end of 2 nad 3 family org
		    }
		}catch(Exception e){
			e.printStackTrace();
		}
		return array_list15;
	}
	////
	public static HashMap getExpcatdate(Connection con,String pat_code_date,Properties p) throws Exception
	{ 
		Statement stmt		= null;
		ResultSet rs		= null;
		HashMap hash_16=null;
		try
		{
			hash_16=new HashMap();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select to_char(sysdate,'dd/mm/yyyy') sysdate11,to_char(sysdate+EXP_PERIOD_IN_DAYS,'dd/mm/yyyy') sysadd, EXP_VAL_APPL_YN, EXP_PERIOD_IN_DAYS from mp_pat_category where PAT_CAT_CODE='"+pat_code_date+"'"); 
			
			if(rs != null && rs.next()) 
			{
               hash_16.put("sysdate11",checkForNull(rs.getString("sysdate11")));
               hash_16.put("sysadd",checkForNull(rs.getString("sysadd")));
               hash_16.put("EXP_PERIOD_IN_DAYS",checkForNull(rs.getString("EXP_PERIOD_IN_DAYS")));
               hash_16.put("EXP_VAL_APPL_YN",checkForNull(rs.getString("EXP_VAL_APPL_YN")));
			}
			
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return hash_16;
	}
	/*	The static method getAllowNewBornDate Checks whether the given BirthDate lies Between the MP Parameter or not
    *	@Called in NewbornRegistrationMain.jsp file.
	*	@Table mp_occupation
	*	@Returns hashMap25
	*	@Throws Exception
	*/
	public static HashMap getAllowNewBornDate(Connection con,Properties p) throws Exception
	{
		Statement stmt		= null;
		ResultSet rs		= null;
		HashMap hash16      = null;
		//String reqDate="";
 
		try
		{
			hash16=new HashMap();
			stmt = con.createStatement();

			rs = stmt.executeQuery("select allow_nb_regn_within_days,allow_nb_regn_unit,to_char(sysdate-allow_nb_regn_within_days,'dd/mm/yyyy hh24:mi') sysdays,to_char(sysdate-allow_nb_regn_within_days/24,'dd/mm/yyyy hh24:mi') syshrs,to_char(sysdate,'dd/mm/yyyy hh24:mi') sysdatesys  from mp_param where module_id='MP'"); 
			
			if(rs != null && rs.next()) {
				hash16.put("allow_nb_regn_within_days",checkForNull(rs.getString("allow_nb_regn_within_days")));
				hash16.put("sysdatesys",checkForNull(rs.getString("sysdatesys")));
				String allow_nb_regn_unit=checkForNull(rs.getString("allow_nb_regn_unit"));
				if(allow_nb_regn_unit.equals("D"))
				{
					hash16.put("sysdays_reg",checkForNull(rs.getString("sysdays")));
				}
				else if(allow_nb_regn_unit.equals("H"))
				{
					hash16.put("sysdays_reg",checkForNull(rs.getString("syshrs")));
					
				}
			}

				
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		catch(Exception e3)
		{
			e3.printStackTrace();
		}
		return hash16;
	}
	/*	The static method getMPOccupDesc retrives Occup Short Descriptiopn based on the 				Occup Code
    *	@Called in NewbornRegistrationMain.jsp file.
	*	@Table mp_occupation
	*	@Returns hashMap25
	*	@Throws Exception
	*/
	public static HashMap getRelationMother(Connection con,String patient_id,Properties p) throws Exception
	{
		Statement stmt		= null;
		ResultSet rs		= null;
		HashMap hash17      = null;
		String locale = p.getProperty("LOCALE");
		

		//String reqDate="";

		try
		{
			
			hash17=new HashMap();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT  a.relationship_to_head relation_code, b.short_desc relation_desc  FROM mp_patient a, mp_relationship_lang_vw b WHERE b.relationship_code = a.relationship_to_head   AND a.patient_id='"+patient_id+"' and b.language_id='"+locale+"'"); 
			if(rs != null && rs.next()) {
				hash17.put("relation_code",checkForNull(rs.getString("relation_code")));
				hash17.put("relation_desc",checkForNull(rs.getString("relation_desc")));
				
				
			}

				
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		catch(Exception e3)
		{
			e3.printStackTrace();
		}
		return hash17;
	}
	/*	The static method getMemberDetails retrives Membership details for the Newborn from the Mother
    *	@Called in NewbornRegistrationMain.jsp file.
	*	@Returns hashMap25
	*	@Throws Exception
	*/
	public static HashMap getMemberDetails(Connection con,String patient_id,Properties p) throws Exception
	{
		Statement stmt		= null;
		ResultSet rs		= null;
		HashMap hash17      = null;
		//String reqDate="";
		try
		{
			
			hash17=new HashMap();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select family_no_link_yn, family_org_id_accept_yn,race_required_yn from mp_param"); 
			String family_no_link_yn="";
			String family_org_id_accept_yn="";
			String race_required_yn="";
			if(rs != null && rs.next()) {
				
			 	
			family_no_link_yn=checkForNull(rs.getString("family_no_link_yn"));
			family_org_id_accept_yn=checkForNull(rs.getString("family_org_id_accept_yn"));
			race_required_yn=checkForNull(rs.getString("race_required_yn"));
			
			hash17.put("family_no_link_yn",family_no_link_yn);
			hash17.put("family_org_id_accept_yn",family_org_id_accept_yn);
			hash17.put("race_required_yn",race_required_yn);
						
			}
			if(rs != null) rs.close();
			if(family_org_id_accept_yn.equals("Y")){
				String details="select family_org_sub_id,FAMILY_ORG_ID, FAMILY_ORG_MEMBERSHIP,ALT_ID1_NO, FAMILY_LINK_NO from mp_patient where patient_id='"+patient_id+"'";
				rs=stmt.executeQuery(details);
				if(rs.next()){
					hash17.put("FAMILY_ORG_ID",checkForNull(rs.getString("FAMILY_ORG_ID")));
				    hash17.put("FAMILY_ORG_MEMBERSHIP",checkForNull(rs.getString("FAMILY_ORG_MEMBERSHIP")));
				    hash17.put("ALT_ID1_NO",checkForNull(rs.getString("ALT_ID1_NO")));
				    hash17.put("FAMILY_ORG_SUB_ID",checkForNull(rs.getString("family_org_sub_id")));
					hash17.put("HeadPatientid",checkForNull(rs.getString("FAMILY_LINK_NO")));
				}if(rs != null) rs.close();

			}
	
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			
		}
		catch(Exception e3)
		{
			e3.printStackTrace();
		}
		return hash17;
	}

	/*	The static method getNewBornInMaintain retrieves 
    *	@Called in NewbornRegistrationMain.jsp file.
	*	@Table mp_patient
	*	@Returns hashMap25
	*	@Throws Exception
	*/
	public static HashMap getNewBornInMaintain(Connection con,String patient_id) throws Exception
	{
		Statement stmt		= null;
		ResultSet rs		= null;
		HashMap hash16      = null;
		
		try
		{
			
			hash16=new HashMap();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT pat_cat_code,name_prefix,RELATIONSHIP_TO_HEAD,to_char(PAT_CAT_CODE_EXP_DATE,'dd/mm/yyyy') PAT_CAT_CODE_EXP_DATE FROM mp_patient where patient_id='"+patient_id+"'"); 
			
			
			if(rs != null && rs.next()) {
				hash16.put("pat_cat_code",checkForNull(rs.getString("pat_cat_code")));
				hash16.put("RELATIONSHIP_TO_HEAD",checkForNull(rs.getString("RELATIONSHIP_TO_HEAD")));
								
				hash16.put("name_prefix",checkForNull(rs.getString("name_prefix")));
				
				hash16.put("PAT_CAT_CODE_EXP_DATE",checkForNull(rs.getString("PAT_CAT_CODE_EXP_DATE")));
					
				
			}

				
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		catch(Exception e3)
		{
			e3.printStackTrace();
		}
		return hash16;
	}

	/*	The static method getNurseName retrieves 
    *	@Called in NewbornRegistrationMain.jsp file.
	*	@Table am_pract_for_facility_vw
	*	@Returns hashMap25
	*	@Throws Exception
	*/
	public static HashMap getNurseName(Connection con,String pract_id,String facilityId,Properties p) throws Exception
	{
		Statement stmt		= null;
		ResultSet rs		= null;
		HashMap hash17      = null;
		
		try
		{
			
			hash17=new HashMap();
			stmt = con.createStatement();
			//rs = stmt.executeQuery("SELECT a.Practitioner_Id, b.practitioner_name FROM am_pract_for_facility a, am_practitioner b WHERE a.operating_facility_id = '"+facilityId+"' AND a.practitioner_id = b.practitioner_id and b.pract_type IN ('MW','NS')  AND eff_status = 'E' and a.Practitioner_Id='"+pract_id+"' ORDER BY 2");
			rs = stmt.executeQuery("SELECT a.Practitioner_Id, b.practitioner_name FROM am_pract_for_facility a, am_practitioner b WHERE a.facility_id = '"+facilityId+"' AND a.practitioner_id = b.practitioner_id and b.pract_type IN ('MW','NS')  AND a.eff_status = 'E'  AND b.eff_status = 'E' and a.Practitioner_Id='"+pract_id+"' ORDER BY 2");
			
			
			if(rs != null && rs.next()) {
				hash17.put("Practitioner_Id",checkForNull(rs.getString("Practitioner_Id")));
				hash17.put("practitioner_name",checkForNull(rs.getString("practitioner_name")));
			}
				
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		catch(Exception e3)
		{
			e3.printStackTrace();
		}
		return hash17;
	}

/*	The static method getNurseName retrieves 
    *	@Called in NewbornRegistrationMain.jsp file.
	*	@Table am_pract_for_facility_vw
	*	@Returns hashMap25
	*	@Throws Exception
	*/
	public static HashMap getCompDelivary(Connection con,String compdel_id,Properties p) throws Exception
	{
		Statement stmt		= null;
		ResultSet rs		= null;
		HashMap hash18      = null;
		String locale = p.getProperty("LOCALE");
		

		try
		{
			
			hash18=new HashMap();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT compln_dely_code, short_desc FROM mp_compln_delivery_lang_vw WHERE eff_status = 'E' and compln_dely_code='"+compdel_id+"' and language_id='"+locale+"' ORDER BY 2");
	  		
			
			if(rs != null && rs.next()) {
				hash18.put("compln_dely_code",checkForNull(rs.getString("compln_dely_code")));
				hash18.put("short_desc",checkForNull(rs.getString("short_desc")));
								
									
				
			}

				
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		catch(Exception e3)
		{
			e3.printStackTrace();
		}
		return hash18;
	}

	/*	The static method getNurseName retrieves 
    *	@Called in NewbornRegistrationMain.jsp file.
	*	@Table am_pract_for_facility_vw
	*	@Returns hashMap25
	*	@Throws Exception
	*/
	public static HashMap getCompPregnancy(Connection con,String comppreg_id,Properties p) throws Exception
	{
		Statement stmt		= null;
		ResultSet rs		= null;
		HashMap hash18      = null;
		String locale = p.getProperty("LOCALE");		

		try
		{ 			
			hash18=new HashMap();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT compln_pregnancy_code, short_desc FROM mp_compln_pregnancy_lang_vw WHERE eff_status = 'E' and compln_pregnancy_code = '"+comppreg_id+"' and language_id='"+locale+"' ORDER BY 2"); 
			
			if(rs != null && rs.next()) {
				hash18.put("compln_pregnancy_code",checkForNull(rs.getString("compln_pregnancy_code")));
				hash18.put("short_desc",checkForNull(rs.getString("short_desc")));	
			} 
			
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		catch(Exception e3)
		{
			e3.printStackTrace();
		}
		return hash18;
	}

	/*	The static method getNurseName retrieves 
    *	@Called in NewbornRegistrationMain.jsp file.
	*	@Table am_pract_for_facility_vw
	*	@Returns hashMap25
	*	@Throws Exception
	*/
	public static HashMap getDelIndiaction(Connection con,String delindiaction_id,Properties p) throws Exception
	{
		Statement stmt		= null;
		ResultSet rs		= null;
		HashMap hash19      = null;
		String locale = p.getProperty("LOCALE");
		

		try
		{
			
			hash19=new HashMap();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT dely_ind_code, short_desc FROM MP_DLVRY_INDICATION_LANG_VW    WHERE eff_status = 'E'  and dely_ind_code='"+delindiaction_id+"' and language_id='"+locale+"'");
			
			
			if(rs != null && rs.next()) {
				hash19.put("dely_ind_code",checkForNull(rs.getString("dely_ind_code")));
				hash19.put("short_desc",checkForNull(rs.getString("short_desc")));
								
									
				
			}

				
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		catch(Exception e3)
		{
			e3.printStackTrace();
		}
		return hash19;
	}

/*	The static method getCongAnal_desc retrieves 
    *	@Called in NewbornRegistrationMain.jsp file.
	*	@Table mp_congenital_anomalies
	*	@Returns hashMap25
	*	@Throws Exception
	*/
	public static HashMap getCongAnal_desc(Connection con,String cananal_id,Properties p) throws Exception
	{
		Statement stmt		= null;
		ResultSet rs		= null;
		HashMap hash20      = null;
		String locale = p.getProperty("LOCALE");
		

		try
		{
			
			hash20=new HashMap();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT cong_anomalies_code, short_desc FROM mp_cong_anomalies_lang_vw  WHERE eff_status = 'E' and cong_anomalies_code='"+cananal_id+"' and language_id='"+locale+"'");
			
			
			if(rs != null && rs.next()) {
				hash20.put("cong_anomalies_code",checkForNull(rs.getString("cong_anomalies_code")));
				hash20.put("short_desc",checkForNull(rs.getString("short_desc")));
								
				
			}

				
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		catch(Exception e3)
		{
			e3.printStackTrace();
		}
		return hash20;
	}
	//Below line Added for HSA-CRF-0182
	public static String getMutipleBirthPatientId(String motherid, Connection con, Properties p,String mother_patient_id,String finalized_mult_birth_yn) throws Exception
	{
	   	PreparedStatement pstmt		= null;
		ResultSet rs				= null;	
	   //Added incident [54168]
		String finalized_yn="N";
		int no_of_births=0;
		//int maxpat=0;
		int no_of_multi_babies_regd=0;
		int birth_cycle_no=0;
		//Added incident [54168]
			pstmt	= con.prepareStatement("select finalized_yn,no_of_births,mc_cycle_no from mp_birth_register where patient_id='"+motherid+"' and MOTHER_PATIENT_ID='"+mother_patient_id+"'");
			rs		= pstmt.executeQuery();
            if(rs != null && rs.next()){
			finalized_yn=rs.getString("finalized_yn"); 			
			no_of_births=rs.getInt("no_of_births");
			birth_cycle_no=rs.getInt("mc_cycle_no");
            }            			
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			//if(finalized_yn.equals("Y")){	
            if(finalized_yn.equals("Y") && finalized_mult_birth_yn.equals("N")){		
			//pstmt	= con.prepareStatement("select max(patient_id) patientid, min(no_of_multi_babies_regd) no_of_multi_babies_regd from mp_birth_register where MOTHER_PATIENT_ID='"+mother_patient_id+"' and multiple_birth_yn='Y'");
			String query1="select max(patient_id) patientid, min(no_of_multi_babies_regd) no_of_multi_babies_regd from mp_birth_register where MOTHER_PATIENT_ID='"+mother_patient_id+"' and multiple_birth_yn='Y' and mc_cycle_no="+birth_cycle_no;
			pstmt= con.prepareStatement(query1);
			rs= pstmt.executeQuery();
            if(rs != null && rs.next()){			
			no_of_multi_babies_regd=rs.getInt("no_of_multi_babies_regd");			
			//if(maxpat<=no_of_births && no_of_multi_babies_regd>0)
			if(no_of_multi_babies_regd>0)motherid=rs.getString("patientid"); 	
            			
            }           				
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			}			
			//End [54168]			
			
			
			return motherid;
	
	}
	//End HSA-CRF-0182
//Added by Ajay Hatwate for ML-MMOH-CRF-1959.1 
	public static String getFinalizationStatus(String patient_id,String mother_patient_id, Connection con, Properties p) throws Exception
	{
	   	PreparedStatement pstmt		= null;
		ResultSet rs				= null;	
		String finalized_yn="N";
			pstmt	= con.prepareStatement("select finalized_yn from mp_birth_register where patient_id='"+patient_id+"' and MOTHER_PATIENT_ID='"+mother_patient_id+"'");
			rs		= pstmt.executeQuery();
            if(rs != null && rs.next()){
            	finalized_yn=checkForNull(rs.getString("finalized_yn"),"N"); 			
            }            			
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			return finalized_yn;
	}//End of ML-MMOH-CRF-1759.1
	public static String checkForNull(String inputString)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
	public static String singleToDoubleQuotes(String strDB)
	{
		/*String strModified="";
		try
		{
			if((strDB != null) ||(strDB !=""))
			{
				StringBuffer stringbuffer = new StringBuffer(strDB);
				int i = 0;
				for(int j = 0; strDB.indexOf('\'', i) != -1; j++)
				{
					i = strDB.indexOf('\'', i);
					stringbuffer.insert(i + j, "'");
					i++;
				}
				strModified=stringbuffer.toString();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return strModified;
		*/
		return strDB.replaceAll("'","''");

	}
}
