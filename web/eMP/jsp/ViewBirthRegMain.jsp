<!DOCTYPE html>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import="java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,java.util.HashMap,java.util.Properties, java.util.ArrayList, java.text.SimpleDateFormat, com.ehis.util.*, webbeans.eCommon.ConnectionManager,eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
 
 <% 
	//Properties p		= (java.util.Properties) session.getValue("jdbc");
	
    request.setCharacterEncoding("UTF-8");
	Connection con	= null;
	String patient_id				= checkForNull(request.getParameter("Patient_ID"));//mother Patient ID
	//String outcome					= checkForNull(request.getParameter("outcome"));

	PreparedStatement pstmt=null;
	ResultSet rs=null,rs1=null;
	//String sql1 = "";
	//String facilityId       = (String) session.getValue("facility_id");

	//Below line added for this CRF ML-MMOH-CRF-0621	
	ResultSet rset			= null;
	PreparedStatement stmt	= null;
	String national_id="",  other_alter_id ="", nat_other_alter_id="", nat_other_alter_legend="", national_id_no="";
	//End ML-MMOH-CRF-0621
	    
	HashMap hashMap_param				= new HashMap();
    HashMap hashMap_detls				= new HashMap();
	String locale			= (String)session.getAttribute("LOCALE"); 


	/*String mp_param_sql="select NAME_PREFIX_ACCEPT_YN, FIRST_NAME_ACCEPT_YN, SECOND_NAME_ACCEPT_YN, THIRD_NAME_ACCEPT_YN, FAMILY_NAME_ACCEPT_YN, NAME_SUFFIX_ACCEPT_YN,NAME_PREFIX_PROMPT, FIRST_NAME_PROMPT, SECOND_NAME_PROMPT, THIRD_NAME_PROMPT, FAMILY_NAME_PROMPT, NAME_SUFFIX_PROMPT,NAMES_IN_OTH_LANG_YN,NAME_PREFIX_LOC_LANG_PROMPT, FIRST_NAME_LOC_LANG_PROMPT, SECOND_NAME_LOC_LANG_PROMPT, THIRD_NAME_LOC_LANG_PROMPT, FAMILY_NAME_LOC_LANG_PROMPT, NAME_SUFFIX_LOC_LANG_PROMPT,ACCEPT_NATIONAL_ID_NO_YN,NAT_ID_PROMPT,ALT_ID1_TYPE, DECODE (UNIT_OF_WT_NB, 'K', 'Kg', 'L', 'Lb') UNIT_OF_WT_NB, DECODE (UNIT_OF_CIRCUM_NB, 'C', 'Cm', 'I', 'In' ) UNIT_OF_CIRCUM_NB, DECODE (UNIT_OF_CHEST_CIRCUM_NB, 'C', 'Cm', 'I', 'In' ) UNIT_OF_CHEST_CIRCUM_NB, DECODE (UNIT_OF_LENGTH_NB, 'C', 'Cm', 'I', 'In') UNIT_OF_LENGTH_NB, UNIT_OF_GEST_NB  from mp_param "; 	*/
	
	/*Above line commented and below line added for this CRF ML-MMOH-CRF-0621*/
	String mp_param_sql="select NAME_PREFIX_ACCEPT_YN, FIRST_NAME_ACCEPT_YN, SECOND_NAME_ACCEPT_YN, THIRD_NAME_ACCEPT_YN, FAMILY_NAME_ACCEPT_YN, NAME_SUFFIX_ACCEPT_YN,NAME_PREFIX_PROMPT, FIRST_NAME_PROMPT, SECOND_NAME_PROMPT, THIRD_NAME_PROMPT, FAMILY_NAME_PROMPT, NAME_SUFFIX_PROMPT,NAMES_IN_OTH_LANG_YN,NAME_PREFIX_LOC_LANG_PROMPT, FIRST_NAME_LOC_LANG_PROMPT, SECOND_NAME_LOC_LANG_PROMPT, THIRD_NAME_LOC_LANG_PROMPT, FAMILY_NAME_LOC_LANG_PROMPT, NAME_SUFFIX_LOC_LANG_PROMPT,ACCEPT_NATIONAL_ID_NO_YN,NAT_ID_PROMPT,ALT_ID1_TYPE, DECODE (UNIT_OF_WT_NB, 'K', 'Kg', 'L', 'Lb') UNIT_OF_WT_NB, DECODE (UNIT_OF_CIRCUM_NB, 'C', 'Cm', 'I', 'In' ) UNIT_OF_CIRCUM_NB, DECODE (UNIT_OF_CHEST_CIRCUM_NB, 'C', 'Cm', 'I', 'In' ) UNIT_OF_CHEST_CIRCUM_NB, DECODE (UNIT_OF_LENGTH_NB, 'C', 'Cm', 'I', 'In') UNIT_OF_LENGTH_NB, UNIT_OF_GEST_NB, mp_get_desc.mp_alternate_id_type(alt_id1_type,'"+locale+"',1) alt_id1_type_desc, mp_get_desc.mp_alternate_id_type(alt_id2_type,'"+locale+"',1) alt_id2_type_desc, mp_get_desc.mp_alternate_id_type(alt_id3_type,'"+locale+"',1) alt_id3_type_desc, mp_get_desc.mp_alternate_id_type(alt_id4_type,'"+locale+"',1) alt_id4_type_desc,accept_oth_alt_id_yn from mp_param_lang_vw where module_id = 'MP' and language_id ='"+locale+"'"; 
	
	

	//String dtls_sql="select MOTHER_PATIENT_ID,MOTHER_PATIENT_NAME,MOTHER_NATIONAL_ID_NO,DELIVERY_TYPE,GESTATIONAL_PERIOD,GESTATIONAL_UNIT,GESTATIONAL_PERIOD_IN_DAYS,PHYSICIAN_NAME ,UMB_CORD_CUT_BY_NAME,NVL(UMB_CORD_CUT_BY_NAME, UMB_CORD_CUT_BY)UMB_CORD_CUT_BY,CONG_ANOM_DESC,ADMINISTERED_BY,ADMINISTERED_DESIGNATION,to_char(BCG_VACC_ADMN_DATE,'dd/mm/yyyy hh24:mi') BCG_VACC_ADMN_DATE,NB_SEX,NB_BIRTH_DATE,NB_BIRTH_TIME,OUTCOME,WEIGHT,WEIGHT_UNIT,HEAD_CIRCUMFERENCE,CIRCUMFERENCE_UNIT,CHEST_CIRCUMFERENCE,CHEST_CIRCUM_UNIT,LENGTH,LENGTH_UNIT,APGAR_SCORE_IN_1_MIN,APGAR_SCORE_IN_5_MINS,APGAR_SCORE_IN_10_MINS,decode(PATENCY_OF_ANUS_YN,'Yes','Patent','No','Not Patent') PATENCY_OF_ANUS_YN,BORN_WHERE,VITAMIN_K_YN VITK_N_HEPB_GIVEN_YN,HEPB_YN,BCG_YN,HEPB_YN,HEPB_YN,GRAVIDA,PARITY,FEEDING,STOOLS,COMPLN_DELY_DESC,UMBILICAL_CORD_STATUS,INDICATOR_MARK, BORN_AT_LOCN_TYPE_DESC BORN_AT, decode(MULTIPLE_BIRTH_YN,'Y','Yes','N','No') MULTIPLE_BIRTH_YN, POLIO_N_BCG_GIVEN_YN,NAME_SUFFIX,REMARKS,BIRTH_CERTIFICATE_NO,BIRTH_PLACE_DESC,VAGINAL_DELY_TYPE_DESC,DELY_IND_DESC,VACCINATION_SITE,VITAK_VACC_SITE,VITAK_ADMINISTERED_BY,VITAK_ADMINISTERED_DESIG, to_char(VITK_VACC_ADMN_DATE,'dd/mm/yyyy hh24:mi') VITK_VACC_ADMN_DATE,HEPB_VACC_SITE,HEPB_ADMINISTERED_BY,HEPB_ADMINISTERED_DESIG,to_char(HEPB_VACC_ADMN_DATE,'dd/mm/yyyy hh24:mi') HEPB_VACC_ADMN_DATE,NB_COMPLN_DELY_DESC,NO_OF_BIRTHS,FATHER_PATIENT_ID,FATHER_PATIENT_NAME,FATHER_NATIONAL_ID_NO,FATHER_ALT_ID1_TYPE_DESC FATHER_ALT_ID1_TYPE ,FATHER_ALT_ID1_NO,FATHER_NAT_DESC,ETH_GRP_DESC FATHER_RACE_DESC,OTH_ALT_ID_DESC,FATHER_OTH_ALT_ID_NO,RELGN_DESC, decode(FATHER_GOVE_EMPLOYEE_YN,'Y','Yes','N','No') FATHER_GOVE_EMPLOYEE_YN, OCPN_CLASS_DESC,OCPN_DESC,FATHER_OCPN_DESC,NAME_PREFIX_LOC_LANG,NAME_SUFFIX_LOC_LANG,FATHER_PATIENT_NAME_LOC_LANG,MOTHER_PATIENT_NAME_LOC_LANG,NB_PATIENT_NAME_LOC_LANG,COMPLNS_1ST_STAGE_LABOUR_CODE, COMPLNS_2ND_STAGE_LABOUR_CODE, COMPLNS_3RD_STAGE_LABOUR_CODE, COMPLN_PREGNANCY_CODE, COMPLN_PREGNANCY_DESC, COMPLN_NR_PREGNANCY_CODE, COMPLN_NR_PREGNANCY_DESC,decode( HEART_RATE_IN_1_MIN,'0','Absent (0)','1','Below 100 bpm (1)','2','Above 100 bpm (2)')HEART_RATE_IN_1_MIN, decode( HEART_RATE_IN_5_MIN,'0','Absent (0)','1','Below 100 bpm (1)','2','Above 100 bpm (2)')HEART_RATE_IN_5_MIN,decode( HEART_RATE_IN_10_MIN,'0','Absent (0)','1','Below 100 bpm (1)','2','Above 100 bpm (2)')HEART_RATE_IN_10_MIN, decode( BREATHING_IN_1_MIN,'0','Absent (0)','1','Slow,irregular (1)','2','Good,crying (2)') BREATHING_IN_1_MIN, decode( BREATHING_IN_5_MIN,'0','Absent (0) ','1','Slow,irregular (1) ','2','Good,crying (2)') BREATHING_IN_5_MIN, decode( BREATHING_IN_10_MIN,'0','Absent (0)','1','Slow,irregular (1) ','2','Good,crying (2)') BREATHING_IN_10_MIN, decode( GRIMACE_IN_1_MIN,'0','No Grimace (0)','1','Facial Grimace (1) ','2','Sneeze, cough, pulls away (2)')  GRIMACE_IN_1_MIN, decode( GRIMACE_IN_5_MIN,'0','No Grimace (0)','1','Facial Grimace (1)','2','Sneeze, cough, pulls away (2)')  GRIMACE_IN_5_MIN, decode( GRIMACE_IN_10_MIN,'0','No Grimace (0)','1','Facial Grimace (1)','2','Sneeze, cough, pulls away(2)') GRIMACE_IN_10_MIN, decode( ACTIVITY_IN_1_MIN,'0','Absent (0)','1','Arms & legs extended (1)','2','Active movement with flexed arms & legs (2)')  ACTIVITY_IN_1_MIN, decode( ACTIVITY_IN_5_MIN,'0','Absent (0)','1','Arms & legs extended (1)','2','Active movement with flexed arms & legs (2)')  ACTIVITY_IN_5_MIN, decode( ACTIVITY_IN_10_MIN,'0','Absent (0)','1','Arms & legs extended (1)','2','Active movement with flexed arms & legs (2)')  ACTIVITY_IN_10_MIN, decode( APPEARANCE_IN_1_MIN,'0','Blue-gray pale all over (0)','1','Pink body and blue extremities (1)','2','Normal over entire body - Completely pink (2)')  APPEARANCE_IN_1_MIN,decode( APPEARANCE_IN_5_MIN,'0','Blue-gray pale all over (0)','1','Pink body and blue extremities (1)','2','Normal over entire body - Completely pink (2)')   APPEARANCE_IN_5_MIN, decode( APPEARANCE_IN_10_MIN,'0','Blue-gray pale all over (0)','1','Pink body and blue extremities (1)','2','Normal over entire body - Completely pink (2)')  APPEARANCE_IN_10_MIN, NB_NAME_PREFIX, NB_FIRST_NAME, NB_SECOND_NAME, NB_THIRD_NAME, NB_FAMILY_NAME_PREFIX, NB_FAMILY_NAME, NB_NAME_SUFFIX, NB_NAME_PREFIX_LOC_LANG, NB_FIRST_NAME_LOC_LANG, NB_SECOND_NAME_LOC_LANG, NB_THIRD_NAME_LOC_LANG, NB_FAMILY_NAME_LOC_LANG, NB_NAME_SUFFIX_LOC_LANG, FATHER_NAME_PREFIX, FATHER_FIRST_NAME, FATHER_SECOND_NAME, FATHER_THIRD_NAME, FATHER_FAMILY_NAME_PREFIX, FATHER_FAMILY_NAME, FATHER_NAME_SUFFIX, FATHER_NAME_PREFIX_LOC_LANG, FATHER_FIRST_NAME_LOC_LANG, FATHER_SECOND_NAME_LOC_LANG, FATHER_THIRD_NAME_LOC_LANG, FATHER_FAMILY_NAME_LOC_LANG, FATHER_NAME_SUFFIX_LOC_LANG,MIDWIFE_NAME,COMPLNS_1ST_STAGE_LABOUR_DESC,COMPLNS_2ND_STAGE_LABOUR_DESC,COMPLNS_3RD_STAGE_LABOUR_DESC,PROC_CLASS_DESC,DELY_SURG_CLASS_DESC,NB_PATIENT_NAME,FATHER_REMARKS,NB_RELATION_TO_HEAD,OUTCOME,BORN_AT_LOCN_DESC ANT_CARE_LOCN_DESC,NB_BLOOD_GRP_DESC NB_BLOOD_GRP,NB_RH_FACTOR_DESC NB_RH_FACTOR,NB_COMPLN_DELY_DESC from mp_birth_register_vw where PATIENT_ID  ='"+patient_id+"'";
	//String dtls_sql="select MOTHER_PATIENT_ID,MOTHER_PATIENT_NAME,MOTHER_NATIONAL_ID_NO,DELIVERY_TYPE,GESTATIONAL_PERIOD,GESTATIONAL_UNIT,GESTATIONAL_PERIOD_IN_DAYS,PHYSICIAN_NAME ,UMB_CORD_CUT_BY_NAME,NVL(UMB_CORD_CUT_BY_NAME, UMB_CORD_CUT_BY)UMB_CORD_CUT_BY,CONG_ANOM_DESC,ADMINISTERED_BY,ADMINISTERED_DESIGNATION,to_char(BCG_VACC_ADMN_DATE,'dd/mm/yyyy hh24:mi') BCG_VACC_ADMN_DATE,NB_SEX,NB_BIRTH_DATE,NB_BIRTH_TIME,OUTCOME,WEIGHT,WEIGHT_UNIT,HEAD_CIRCUMFERENCE,CIRCUMFERENCE_UNIT,CHEST_CIRCUMFERENCE,CHEST_CIRCUM_UNIT,LENGTH,LENGTH_UNIT,APGAR_SCORE_IN_1_MIN,APGAR_SCORE_IN_5_MINS,APGAR_SCORE_IN_10_MINS,decode(PATENCY_OF_ANUS_YN,'Yes','Patent','No','Not Patent') PATENCY_OF_ANUS_YN,BORN_WHERE,VITAMIN_K_YN VITK_N_HEPB_GIVEN_YN,HEPB_YN,BCG_YN,HEPB_YN,HEPB_YN,GRAVIDA,PARITY,FEEDING,STOOLS,COMPLN_DELY_DESC,UMBILICAL_CORD_STATUS,INDICATOR_MARK, BORN_AT_LOCN_TYPE_DESC BORN_AT, decode(MULTIPLE_BIRTH_YN,'Y','Yes','N','No') MULTIPLE_BIRTH_YN, POLIO_N_BCG_GIVEN_YN,NAME_SUFFIX,REMARKS,BIRTH_CERTIFICATE_NO,BIRTH_PLACE_DESC,VAGINAL_DELY_TYPE_DESC,DELY_IND_DESC,VACCINATION_SITE,VITAK_VACC_SITE,VITAK_ADMINISTERED_BY,VITAK_ADMINISTERED_DESIG, to_char(VITK_VACC_ADMN_DATE,'dd/mm/yyyy hh24:mi') VITK_VACC_ADMN_DATE,HEPB_VACC_SITE,HEPB_ADMINISTERED_BY,HEPB_ADMINISTERED_DESIG,to_char(HEPB_VACC_ADMN_DATE,'dd/mm/yyyy hh24:mi') HEPB_VACC_ADMN_DATE,NB_COMPLN_DELY_DESC,NO_OF_BIRTHS,FATHER_PATIENT_ID,FATHER_PATIENT_NAME,FATHER_NATIONAL_ID_NO,FATHER_ALT_ID1_TYPE_DESC FATHER_ALT_ID1_TYPE ,FATHER_ALT_ID1_NO,FATHER_NAT_DESC,ETH_GRP_DESC FATHER_RACE_DESC,OTH_ALT_ID_DESC,FATHER_OTH_ALT_ID_NO,RELGN_DESC, decode(FATHER_GOVE_EMPLOYEE_YN,'Y','Yes','N','No') FATHER_GOVE_EMPLOYEE_YN, OCPN_CLASS_DESC,OCPN_DESC,FATHER_OCPN_DESC,NAME_PREFIX_LOC_LANG,NAME_SUFFIX_LOC_LANG,FATHER_PATIENT_NAME_LOC_LANG,MOTHER_PATIENT_NAME_LOC_LANG,NB_PATIENT_NAME_LOC_LANG,COMPLNS_1ST_STAGE_LABOUR_CODE, COMPLNS_2ND_STAGE_LABOUR_CODE, COMPLNS_3RD_STAGE_LABOUR_CODE, COMPLN_PREGNANCY_CODE, COMPLN_PREGNANCY_DESC, COMPLN_NR_PREGNANCY_CODE, COMPLN_NR_PREGNANCY_DESC,HEART_RATE_IN_1_MIN,HEART_RATE_IN_5_MIN,HEART_RATE_IN_10_MIN,BREATHING_IN_1_MIN,BREATHING_IN_5_MIN,BREATHING_IN_10_MIN,GRIMACE_IN_1_MIN,GRIMACE_IN_5_MIN,GRIMACE_IN_10_MIN,ACTIVITY_IN_1_MIN,ACTIVITY_IN_5_MIN,ACTIVITY_IN_10_MIN,APPEARANCE_IN_1_MIN,APPEARANCE_IN_5_MIN,APPEARANCE_IN_10_MIN, NB_NAME_PREFIX, NB_FIRST_NAME, NB_SECOND_NAME, NB_THIRD_NAME, NB_FAMILY_NAME_PREFIX, NB_FAMILY_NAME, NB_NAME_SUFFIX, NB_NAME_PREFIX_LOC_LANG, NB_FIRST_NAME_LOC_LANG, NB_SECOND_NAME_LOC_LANG, NB_THIRD_NAME_LOC_LANG, NB_FAMILY_NAME_LOC_LANG, NB_NAME_SUFFIX_LOC_LANG, FATHER_NAME_PREFIX, FATHER_FIRST_NAME, FATHER_SECOND_NAME, FATHER_THIRD_NAME, FATHER_FAMILY_NAME_PREFIX, FATHER_FAMILY_NAME, FATHER_NAME_SUFFIX, FATHER_NAME_PREFIX_LOC_LANG, FATHER_FIRST_NAME_LOC_LANG, FATHER_SECOND_NAME_LOC_LANG, FATHER_THIRD_NAME_LOC_LANG, FATHER_FAMILY_NAME_LOC_LANG, FATHER_NAME_SUFFIX_LOC_LANG,MIDWIFE_NAME,COMPLNS_1ST_STAGE_LABOUR_DESC,COMPLNS_2ND_STAGE_LABOUR_DESC,COMPLNS_3RD_STAGE_LABOUR_DESC,PROC_CLASS_DESC,DELY_SURG_CLASS_DESC,NB_PATIENT_NAME,FATHER_REMARKS,NB_RELATION_TO_HEAD,OUTCOME,BORN_AT_LOCN_DESC ANT_CARE_LOCN_DESC,NB_BLOOD_GRP_DESC NB_BLOOD_GRP,NB_RH_FACTOR_DESC NB_RH_FACTOR,NB_COMPLN_DELY_DESC from mp_birth_register_vw where PATIENT_ID  ='"+patient_id+"'";
	/*Below query modofied for this CRF  MMS-QH-CRF-0145.1 [IN:047497]*/
    /*Below query modified for this CRF ML-MMOH-CRF-0621*/	
	String dtls_sql="select MOTHER_PATIENT_ID,MOTHER_PATIENT_NAME,MOTHER_NATIONAL_ID_NO,alt_id1_no,alt_id2_no,alt_id3_no,alt_id4_no,mother_alt_id1_no,mother_alt_id2_no,mother_alt_id3_no,mother_alt_id4_no,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(alt_id1_type,'"+locale+"','1')m_alt_id1_type,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(alt_id2_type,'"+locale+"','1')m_alt_id2_type,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(alt_id3_type,'"+locale+"','1')m_alt_id3_type,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(alt_id4_type,'"+locale+"','1')m_alt_id4_type,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(mother_alt_id1_type,'"+locale+"','1')mother_alt_id1_type,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(mother_alt_id2_type,'"+locale+"','1')mother_alt_id2_type,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(mother_alt_id3_type,'"+locale+"','1')mother_alt_id3_type,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(mother_alt_id4_type,'"+locale+"','1')mother_alt_id4_type,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(mother_oth_alt_id_type,'"+locale+"','1')mother_oth_alt_id_type,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(oth_alt_id_type,'"+locale+"','1')m_oth_alt_id_type,oth_alt_id_no m_oth_alt_id_no,mother_oth_alt_id_no,DELIVERY_TYPE,GESTATIONAL_PERIOD,GESTATIONAL_UNIT,GESTATIONAL_PERIOD_IN_DAYS,PHYSICIAN_NAME ,UMB_CORD_CUT_BY_NAME,NVL(UMB_CORD_CUT_BY_NAME, UMB_CORD_CUT_BY)UMB_CORD_CUT_BY,CONG_ANOM_DESC,ADMINISTERED_BY,ADMINISTERED_DESIGNATION,to_char(BCG_VACC_ADMN_DATE,'dd/mm/yyyy hh24:mi') BCG_VACC_ADMN_DATE,NB_SEX,NB_BIRTH_DATE,NB_BIRTH_TIME,OUTCOME,WEIGHT,WEIGHT_UNIT,HEAD_CIRCUMFERENCE,CIRCUMFERENCE_UNIT,CHEST_CIRCUMFERENCE,CHEST_CIRCUM_UNIT,LENGTH,LENGTH_UNIT,APGAR_SCORE_IN_1_MIN,APGAR_SCORE_IN_5_MINS,APGAR_SCORE_IN_10_MINS,decode(PATENCY_OF_ANUS_YN,'Yes','Patent','No','Not Patent') PATENCY_OF_ANUS_YN,BORN_WHERE,VITAMIN_K_YN VITK_N_HEPB_GIVEN_YN,HEPB_YN,BCG_YN,HEPB_YN,HEPB_YN,GRAVIDA,PARITY,FEEDING,STOOLS,COMPLN_DELY_DESC,UMBILICAL_CORD_STATUS,INDICATOR_MARK, BORN_AT_LOCN_TYPE_DESC BORN_AT, decode(MULTIPLE_BIRTH_YN,'Y','Yes','N','No') MULTIPLE_BIRTH_YN, POLIO_N_BCG_GIVEN_YN,NAME_SUFFIX,REMARKS,BIRTH_CERTIFICATE_NO,BIRTH_PLACE_DESC,VAGINAL_DELY_TYPE_DESC,DELY_IND_DESC,VACCINATION_SITE,VITAK_VACC_SITE,VITAK_ADMINISTERED_BY,VITAK_ADMINISTERED_DESIG, to_char(VITK_VACC_ADMN_DATE,'dd/mm/yyyy hh24:mi') VITK_VACC_ADMN_DATE,HEPB_VACC_SITE,HEPB_ADMINISTERED_BY,HEPB_ADMINISTERED_DESIG,to_char(HEPB_VACC_ADMN_DATE,'dd/mm/yyyy hh24:mi') HEPB_VACC_ADMN_DATE,NB_COMPLN_DELY_DESC,NO_OF_BIRTHS,FATHER_PATIENT_ID,FATHER_PATIENT_NAME,FATHER_NATIONAL_ID_NO, MP_GET_DESC.MP_ALTERNATE_ID_TYPE(father_alt_id1_type,'"+locale+"','1')FATHER_ALT_ID1_TYPE,FATHER_ALT_ID1_NO,FATHER_ALT_ID2_NO,FATHER_ALT_ID3_NO,FATHER_ALT_ID4_NO,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(father_alt_id2_type,'"+locale+"','1')FATHER_ALT_ID2_TYPE,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(father_alt_id3_type,'"+locale+"','1')FATHER_ALT_ID3_TYPE,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(father_alt_id4_type,'"+locale+"','1')FATHER_ALT_ID4_TYPE,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(father_oth_alt_id_type,'"+locale+"','1')father_oth_alt_id_type,FATHER_NAT_DESC,ETH_GRP_DESC FATHER_RACE_DESC,FATHER_OTH_ALT_ID_NO,RELGN_DESC, decode(FATHER_GOVE_EMPLOYEE_YN,'Y','Yes','N','No') FATHER_GOVE_EMPLOYEE_YN, OCPN_CLASS_DESC,OCPN_DESC,FATHER_OCPN_DESC,NAME_PREFIX_LOC_LANG,NAME_SUFFIX_LOC_LANG,FATHER_PATIENT_NAME_LOC_LANG,MOTHER_PATIENT_NAME_LOC_LANG,NB_PATIENT_NAME_LOC_LANG,COMPLNS_1ST_STAGE_LABOUR_CODE, COMPLNS_2ND_STAGE_LABOUR_CODE, COMPLNS_3RD_STAGE_LABOUR_CODE, COMPLN_PREGNANCY_CODE, COMPLN_PREGNANCY_DESC, COMPLN_NR_PREGNANCY_CODE, COMPLN_NR_PREGNANCY_DESC,HEART_RATE_IN_1_MIN,HEART_RATE_IN_5_MIN,HEART_RATE_IN_10_MIN,BREATHING_IN_1_MIN,BREATHING_IN_5_MIN,BREATHING_IN_10_MIN,GRIMACE_IN_1_MIN,GRIMACE_IN_5_MIN,GRIMACE_IN_10_MIN,ACTIVITY_IN_1_MIN,ACTIVITY_IN_5_MIN,ACTIVITY_IN_10_MIN,APPEARANCE_IN_1_MIN,APPEARANCE_IN_5_MIN,APPEARANCE_IN_10_MIN, NB_NAME_PREFIX, NB_FIRST_NAME, NB_SECOND_NAME, NB_THIRD_NAME, NB_FAMILY_NAME_PREFIX, NB_FAMILY_NAME, NB_NAME_SUFFIX, NB_NAME_PREFIX_LOC_LANG, NB_FIRST_NAME_LOC_LANG, NB_SECOND_NAME_LOC_LANG, NB_THIRD_NAME_LOC_LANG, NB_FAMILY_NAME_LOC_LANG, NB_NAME_SUFFIX_LOC_LANG, FATHER_NAME_PREFIX, FATHER_FIRST_NAME, FATHER_SECOND_NAME, FATHER_THIRD_NAME, FATHER_FAMILY_NAME_PREFIX, FATHER_FAMILY_NAME, FATHER_NAME_SUFFIX, FATHER_NAME_PREFIX_LOC_LANG, FATHER_FIRST_NAME_LOC_LANG, FATHER_SECOND_NAME_LOC_LANG, FATHER_THIRD_NAME_LOC_LANG, FATHER_FAMILY_NAME_LOC_LANG, FATHER_NAME_SUFFIX_LOC_LANG,MIDWIFE_NAME,COMPLNS_1ST_STAGE_LABOUR_DESC,COMPLNS_2ND_STAGE_LABOUR_DESC,COMPLNS_3RD_STAGE_LABOUR_DESC,PROC_CLASS_DESC,DELY_SURG_CLASS_DESC,NB_PATIENT_NAME,FATHER_REMARKS,NB_RELATION_TO_HEAD,OUTCOME,BORN_AT_LOCN_DESC ANT_CARE_LOCN_DESC,NB_BLOOD_GRP_DESC NB_BLOOD_GRP,NB_RH_FACTOR_DESC NB_RH_FACTOR,NB_COMPLN_DELY_DESC,hijri_birth_date, AM_GET_DESC.AM_PRACTITIONER(PATENCY_OF_ANUS_CHECKED_BY,'"+locale+"',1) PATENCY_OF_ANUS_CHECKED_BY,parity_on_admission,resuscitated_pract_id,am_get_desc.am_practitioner(resuscitated_pract_id,'"+locale+"',1) resuscitated_pract_desc,attend_physician_id,MOTHER_WITNESSED_BY1,MOTHER_WITNESSED_BY2,MOTHER_ALIVE_YN, COMPLN_PREGNANCY_LONG_DESC, COMPLN_NR_PREGNANCY_LONG_DESC, COMPLNS_1ST_STAGE_LONG_DESC, COMPLNS_2ND_STAGE_LONG_DESC, COMPLNS_3RD_STAGE_LONG_DESC, COMPLN_DELY_LONG_DESC, NB_COMPLN_DEL_LONG_DESC, DELY_IND_LONG_DESC, PROC_CLASS_LONG_DESC, VAGINAL_DEL_TYPE_LONG_DESC, DELY_SURG_CLASS_LONG_DESC, CONG_ANOMALIES_LONG_DESC from mp_birth_register_lang_vw where PATIENT_ID  ='"+patient_id+"' AND language_id = '"+locale+"'"; 
	/*Modified by Rameswar on 20-Jan-16 for ML-MMOH-CRF-0382*/
	//Modified by Ashwini on 01-Feb-2019 for ML-MMOH-CRF-1109
		String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
		<title><fmt:message key="eMP.viewbirthregdtls.label" bundle="${mp_labels}"/></title>
		<html>
		<head>
			<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
			<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
			<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
			<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
			<Script src="../../eCommon/js/messages.js" language="JavaScript"></Script>
			<script src='../../eCommon/js/common.js' language='javascript'></script>
			<script src='../../eCommon/js/dchk.js' language='javascript'></script>
			<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
			<script src='../../eMP/js/NewbornRegistration.js' language='javascript'></script>
			<script src='../../eMP/js/NewbornRegistration1.js' language='javascript'></script>
			<script src='../../eMP/js/NewbornRegistration2.js' language='javascript'></script>
			<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
			<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
			<Script src="../../eCommon/js/calScript/hj/calendar.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

			<style type = 'text/css'>

				div#mother_dtls {					
					display:inline;
				}			

				div#father_dtls {	
					display:inline;
				} 			

				div#newborn_dtls {					
					display:inline;
				}

				div#vaccin_dtls {					
					display:inline;
				}

				span#mother_dtls_link {					
					cursor:pointer;
					color:white;
					font-size:15px;
					font-weight:bold;
				}

				span#father_dtls_link {					
					cursor:pointer;
					color:white;
					font-size:15px;
					font-weight:bold;
				} 
				
				span#newborn_dtls_link {					
					cursor:pointer;
					color:white;
					font-size:15px;
					font-weight:bold;
				}

				span#vaccin_dtls_link {					
					cursor:pointer;
					color:white;
					font-size:15px;
					font-weight:bold;
				}
				
			</style>
			<script>

			function apgarLink(obj)
			{
				var apgarLinkValue=document.getElementById("apgar_dtls_name").value;
				if(obj.value=="+"){
					obj.value="-";
					document.getElementById('apgarDivID').style.visibility="visible";
					document.getElementById('apgarDivID').style.display="";
					document.getElementById('apgarDivID').style.display="inline";
				}else{
					obj.value="+";
					document.getElementById('apgarDivID').style.visibility="hidden";
					document.getElementById('apgarDivID').style.display="None";
				}
			}
			</script>

			<script>
				function tab_click1(id,id1){
					tab_click(id);
				}

				function expandCollapse(calledFrom) {					

					if(calledFrom == 'MD') {

						if(document.getElementById('mother_dtls').style.display == '')
							document.getElementById('mother_dtls').style.display='inline';

						if(document.getElementById('mother_dtls').style.display == 'inline') {
							document.getElementById('mother_dtls').style.display='none';	
							document.getElementById('mother_dtls_link').innerHTML="<input type='button' class='button' value='+'>";											
						} else {
							document.getElementById('mother_dtls').style.display='inline';		
							document.getElementById('mother_dtls_link').innerHTML="<input type='button' class='button' value='-'>"; 							
						} 	
						
					} else if(calledFrom == 'FD') {
 
						if(document.getElementById('father_dtls').style.display == '')
							document.getElementById('father_dtls').style.display='inline';

						if(document.getElementById('father_dtls').style.display == 'inline') {
							document.getElementById('father_dtls').style.display='none';
							document.getElementById('father_dtls_link').innerHTML="<input type='button' class='button' value='+'>";							
						} else {
							document.getElementById('father_dtls').style.display='inline';		
							document.getElementById('father_dtls_link').innerHTML="<input type='button' class='button' value='-'>";							
						}	
						
					} else if(calledFrom == 'ND') {

						if(document.getElementById('newborn_dtls').style.display == '')
							document.getElementById('newborn_dtls').style.display='inline';

						if(document.getElementById('newborn_dtls').style.display == 'inline') {
							document.getElementById('newborn_dtls').style.display='none';							
							document.getElementById('newborn_dtls_link').innerHTML="<input type='button' class='button' value='+'>"; 							
						} else {
							document.getElementById('newborn_dtls').style.display='inline';		
							document.getElementById('newborn_dtls_link').innerHTML="<input type='button' class='button' value='-'>"; 							
						} 	
						
					} else if(calledFrom == 'VD') {

						if(document.getElementById('vaccin_dtls').style.display == '')
							document.getElementById('vaccin_dtls').style.display='inline';  

						if(document.getElementById('vaccin_dtls').style.display == 'inline') {
							document.getElementById('vaccin_dtls').style.display='none';							
							document.getElementById('vaccin_dtls_link').innerHTML="<input type='button' class='button' value='+'>";							
						} else {
							document.getElementById('vaccin_dtls').style.display='inline';		
							document.getElementById('vaccin_dtls_link').innerHTML="<input type='button' class='button' value='-'>"; 							
						} 	
						
					}
				}
	</script>

	<body  OnMouseDown="CodeArrest()" onKeyDown="lockKey()">

	
	<%//out.println(mp_param_sql);

	try{
		con = ConnectionManager.getConnection(request);
//below line added for this CRF Hijri MMS-QH-CRF-0145.1
String hijri_birth_date=""; String Date_Of_Birth="";  
Boolean hijirisitespecifApplicable = CommonBean.isSiteSpecific(con, "MP","CAL_HIJ_APP");	
//End MMS-QH-CRF-0145.1

Boolean isLabelChangeApplicable = CommonBean.isSiteSpecific(con, "IP","GRAVIDA_PARITY_LEGEND_CHG");//Added by Rameswar on 23rd June 2015 against HSA-CRF-0223 IN050565

Boolean isNewBornChngsAppl = CommonBean.isSiteSpecific(con, "IP","REG_NEW_BORN_FOR_IP_FLD_CHNGS");//Added by Ashwini on 11-Jul-2018 for ML-MMOH-CRF-0898.2

Boolean isMotherAliveAppl = CommonBean.isSiteSpecific(con, "MP","MOTHER_ALIVE_APPL");

Boolean isModifyLongShortDescAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MP","MODIFY_LONG_SHORT_DESC");//Added by Ashwini on 24-Jan-2019 for ML-MMOH-CRF-1109

    //Below line added for this CRF ML-MMOH-CRF-0621
	 Boolean isRegNewbornApplicable = CommonBean.isSiteSpecific(con, "MP","REG_NEWBORN_FOR_IP");
	 String attend_physician_id="";
	 //End ML-MMOH-CRF-0621

		pstmt = con.prepareStatement(mp_param_sql);
		rs=pstmt.executeQuery();


		while(rs.next()){
			hashMap_param.put("NAME_PREFIX_ACCEPT_YN",checkForNull(rs.getString("NAME_PREFIX_ACCEPT_YN")));
			hashMap_param.put("FIRST_NAME_ACCEPT_YN",checkForNull(rs.getString("FIRST_NAME_ACCEPT_YN")));
			hashMap_param.put("SECOND_NAME_ACCEPT_YN",checkForNull(rs.getString("SECOND_NAME_ACCEPT_YN")));
			hashMap_param.put("THIRD_NAME_ACCEPT_YN",checkForNull(rs.getString("THIRD_NAME_ACCEPT_YN")));
			hashMap_param.put("FAMILY_NAME_ACCEPT_YN",checkForNull(rs.getString("FAMILY_NAME_ACCEPT_YN")));
			hashMap_param.put("NAME_SUFFIX_ACCEPT_YN",checkForNull(rs.getString("NAME_SUFFIX_ACCEPT_YN")));
			hashMap_param.put("NAME_PREFIX_PROMPT",checkForNull(rs.getString("NAME_PREFIX_PROMPT")));
			hashMap_param.put("FIRST_NAME_PROMPT",checkForNull(rs.getString("FIRST_NAME_PROMPT")));
			hashMap_param.put("SECOND_NAME_PROMPT",checkForNull(rs.getString("SECOND_NAME_PROMPT")));
			hashMap_param.put("THIRD_NAME_PROMPT",checkForNull(rs.getString("THIRD_NAME_PROMPT")));
			hashMap_param.put("FAMILY_NAME_PROMPT",checkForNull(rs.getString("FAMILY_NAME_PROMPT")));
			hashMap_param.put("NAME_SUFFIX_PROMPT",checkForNull(rs.getString("NAME_SUFFIX_PROMPT")));
			hashMap_param.put("NAMES_IN_OTH_LANG_YN",checkForNull(rs.getString("NAMES_IN_OTH_LANG_YN")));
			hashMap_param.put("NAME_PREFIX_LOC_LANG_PROMPT",checkForNull(rs.getString("NAME_PREFIX_LOC_LANG_PROMPT")));
			hashMap_param.put("FIRST_NAME_LOC_LANG_PROMPT",checkForNull(rs.getString("FIRST_NAME_LOC_LANG_PROMPT")));
			hashMap_param.put("SECOND_NAME_LOC_LANG_PROMPT",checkForNull(rs.getString("SECOND_NAME_LOC_LANG_PROMPT")));
			hashMap_param.put("THIRD_NAME_LOC_LANG_PROMPT",checkForNull(rs.getString("THIRD_NAME_LOC_LANG_PROMPT")));
			hashMap_param.put("FAMILY_NAME_LOC_LANG_PROMPT",checkForNull(rs.getString("FAMILY_NAME_LOC_LANG_PROMPT")));
			hashMap_param.put("NAME_SUFFIX_LOC_LANG_PROMPT",checkForNull(rs.getString("NAME_SUFFIX_LOC_LANG_PROMPT")));
			hashMap_param.put("ACCEPT_NATIONAL_ID_NO_YN",checkForNull(rs.getString("ACCEPT_NATIONAL_ID_NO_YN")));
			hashMap_param.put("NAT_ID_PROMPT",checkForNull(rs.getString("NAT_ID_PROMPT")));
			hashMap_param.put("ALT_ID1_TYPE",checkForNull(rs.getString("ALT_ID1_TYPE")));

			hashMap_param.put("UNIT_OF_WT_NB",checkForNull(rs.getString("UNIT_OF_WT_NB")));
			hashMap_param.put("UNIT_OF_CIRCUM_NB",checkForNull(rs.getString("UNIT_OF_CIRCUM_NB")));
			hashMap_param.put("UNIT_OF_CHEST_CIRCUM_NB",checkForNull(rs.getString("UNIT_OF_CHEST_CIRCUM_NB")));
			hashMap_param.put("UNIT_OF_LENGTH_NB",checkForNull(rs.getString("UNIT_OF_LENGTH_NB")));
			hashMap_param.put("UNIT_OF_GEST_NB",checkForNull(rs.getString("UNIT_OF_GEST_NB")));
			
			/*Below line added for this CRF ML-MMOH-CRF-0621*/
			hashMap_param.put("alt_id1_type_desc",checkForNull(rs.getString("alt_id1_type_desc")));
			hashMap_param.put("alt_id2_type_desc",checkForNull(rs.getString("alt_id2_type_desc")));
			hashMap_param.put("alt_id3_type_desc",checkForNull(rs.getString("alt_id3_type_desc")));
			hashMap_param.put("alt_id4_type_desc",checkForNull(rs.getString("alt_id4_type_desc")));
			hashMap_param.put("accept_oth_alt_id_yn",checkForNull(rs.getString("accept_oth_alt_id_yn")));
           //End ML-MMOH-CRF-0621			
			
		}
		
		//out.println(hashMap_param.size());
		
		pstmt.close();
		//out.println(dtls_sql);
		
		
 
		pstmt = con.prepareStatement(dtls_sql);
		rs1=pstmt.executeQuery();

    if (rs1 !=null && rs1.next()){
      
			
			hashMap_detls.put("MOTHER_PATIENT_ID",checkForNull(rs1.getString("MOTHER_PATIENT_ID")));
			hashMap_detls.put("MOTHER_PATIENT_NAME",checkForNull(rs1.getString("MOTHER_PATIENT_NAME")));
			hashMap_detls.put("MOTHER_NATIONAL_ID_NO",checkForNull(rs1.getString("MOTHER_NATIONAL_ID_NO")));
			hashMap_detls.put("m_alt_id1_no",checkForNull(rs1.getString("alt_id1_no")));
			hashMap_detls.put("m_alt_id2_no",checkForNull(rs1.getString("alt_id2_no")));
			hashMap_detls.put("m_alt_id3_no",checkForNull(rs1.getString("alt_id3_no")));
			hashMap_detls.put("m_alt_id4_no",checkForNull(rs1.getString("alt_id4_no")));
			hashMap_detls.put("mother_alt_id1_no",checkForNull(rs1.getString("mother_alt_id1_no")));
			hashMap_detls.put("mother_alt_id2_no",checkForNull(rs1.getString("mother_alt_id2_no")));
			hashMap_detls.put("mother_alt_id3_no",checkForNull(rs1.getString("mother_alt_id3_no")));
			hashMap_detls.put("mother_alt_id4_no",checkForNull(rs1.getString("mother_alt_id4_no")));
			hashMap_detls.put("m_alt_id1_type",checkForNull(rs1.getString("m_alt_id1_type")));
			hashMap_detls.put("m_alt_id2_type",checkForNull(rs1.getString("m_alt_id2_type")));
			hashMap_detls.put("m_alt_id3_type",checkForNull(rs1.getString("m_alt_id3_type")));
			hashMap_detls.put("m_alt_id4_type",checkForNull(rs1.getString("m_alt_id4_type")));
			hashMap_detls.put("mother_alt_id1_type",checkForNull(rs1.getString("mother_alt_id1_type")));
			hashMap_detls.put("mother_alt_id2_type",checkForNull(rs1.getString("mother_alt_id2_type")));
			hashMap_detls.put("mother_alt_id3_type",checkForNull(rs1.getString("mother_alt_id3_type")));
			hashMap_detls.put("mother_alt_id4_type",checkForNull(rs1.getString("mother_alt_id4_type")));
			hashMap_detls.put("mother_oth_alt_id_no",checkForNull(rs1.getString("mother_oth_alt_id_no")));
			hashMap_detls.put("mother_oth_alt_id_type",checkForNull(rs1.getString("mother_oth_alt_id_type")));
			hashMap_detls.put("m_oth_alt_id_no",checkForNull(rs1.getString("m_oth_alt_id_no")));
			hashMap_detls.put("m_oth_alt_id_type",checkForNull(rs1.getString("m_oth_alt_id_type")));
			
			hashMap_detls.put("DELIVERY_TYPE",checkForNull(rs1.getString("DELIVERY_TYPE")));
			hashMap_detls.put("GESTATIONAL_PERIOD",checkForNull(rs1.getString("GESTATIONAL_PERIOD")));
			hashMap_detls.put("GESTATIONAL_UNIT",checkForNull(rs1.getString("GESTATIONAL_UNIT")));
			hashMap_detls.put("GESTATIONAL_PERIOD_IN_DAYS",checkForNull(rs1.getString("GESTATIONAL_PERIOD_IN_DAYS")));
			hashMap_detls.put("PHYSICIAN_NAME",checkForNull(rs1.getString("PHYSICIAN_NAME")));
			hashMap_detls.put("UMB_CORD_CUT_BY",checkForNull(rs1.getString("UMB_CORD_CUT_BY")));
			/*Added by Rameswar on 20-Jan-16 for ML-MMOH-CRF-0382*/
			hashMap_detls.put("PATENCY_OF_ANUS_CHECKED_BY",checkForNull(rs1.getString("PATENCY_OF_ANUS_CHECKED_BY")));
			
			hashMap_detls.put("CONG_ANOM_DESC",checkForNull(rs1.getString("CONG_ANOM_DESC")));
			hashMap_detls.put("ADMINISTERED_BY",checkForNull(rs1.getString("ADMINISTERED_BY")));
			hashMap_detls.put("ADMINISTERED_DESIGNATION",checkForNull(rs1.getString("ADMINISTERED_DESIGNATION")));
			
			//hashMap_detls.put("BCG_VACC_ADMN_DATE",checkForNull(rs1.getString("BCG_VACC_ADMN_DATE")));Commented by Rameswar on 30-Sep-15
			hashMap_detls.put("BCG_VACC_ADMN_DATE",DateUtils.convertDate(checkForNull(rs1.getString("BCG_VACC_ADMN_DATE")),"DMYHM","en",locale));//Modified by Rameswar on 30-Sep-15 for Leap Year Issue 
			

			hashMap_detls.put("NB_SEX",checkForNull(rs1.getString("NB_SEX")));
			//hashMap_detls.put("NB_BIRTH_DATE",checkForNull(rs1.getString("NB_BIRTH_DATE")));
			Date_Of_Birth=checkForNull(rs1.getString("NB_BIRTH_DATE"));
			Date_Of_Birth=DateUtils.convertDate(Date_Of_Birth,"DMY","en",locale);//Added by Rameswar on 30-Sep-15 for Leap Year Issue 
			
			hashMap_detls.put("NB_BIRTH_DATE",Date_Of_Birth);
			
			hashMap_detls.put("NB_BIRTH_TIME",checkForNull(rs1.getString("NB_BIRTH_TIME")));
			hashMap_detls.put("OUTCOME",checkForNull(rs1.getString("OUTCOME")));
			hashMap_detls.put("WEIGHT",checkForNull(rs1.getString("WEIGHT")));
			hashMap_detls.put("ANT_CARE_LOCN_DESC",checkForNull(rs1.getString("ANT_CARE_LOCN_DESC")));
			hashMap_detls.put("NB_BLOOD_GRP",checkForNull(rs1.getString("NB_BLOOD_GRP")));
			hashMap_detls.put("NB_RH_FACTOR",checkForNull(rs1.getString("NB_RH_FACTOR")));

			hashMap_detls.put("WEIGHT_UNIT",checkForNull(rs1.getString("WEIGHT_UNIT")));
			hashMap_detls.put("HEAD_CIRCUMFERENCE",checkForNull(rs1.getString("HEAD_CIRCUMFERENCE")));
			hashMap_detls.put("CIRCUMFERENCE_UNIT",checkForNull(rs1.getString("CIRCUMFERENCE_UNIT")));
			hashMap_detls.put("CHEST_CIRCUMFERENCE",checkForNull(rs1.getString("CHEST_CIRCUMFERENCE")));
			hashMap_detls.put("CHEST_CIRCUM_UNIT",checkForNull(rs1.getString("CHEST_CIRCUM_UNIT")));
			hashMap_detls.put("LENGTH",checkForNull(rs1.getString("LENGTH")));
			hashMap_detls.put("LENGTH_UNIT",checkForNull(rs1.getString("LENGTH_UNIT")));

			hashMap_detls.put("APGAR_SCORE_IN_1_MIN",checkForNull(rs1.getString("APGAR_SCORE_IN_1_MIN")));
			hashMap_detls.put("APGAR_SCORE_IN_5_MINS",checkForNull(rs1.getString("APGAR_SCORE_IN_5_MINS")));
			hashMap_detls.put("APGAR_SCORE_IN_10_MINS",checkForNull(rs1.getString("APGAR_SCORE_IN_10_MINS")));
			hashMap_detls.put("PATENCY_OF_ANUS_YN",checkForNull(rs1.getString("PATENCY_OF_ANUS_YN")));
			hashMap_detls.put("BORN_WHERE",checkForNull(rs1.getString("BORN_WHERE")));
			hashMap_detls.put("VITK_N_HEPB_GIVEN_YN",checkForNull(rs1.getString("VITK_N_HEPB_GIVEN_YN")));
			hashMap_detls.put("HEPB_YN",checkForNull(rs1.getString("HEPB_YN")));
			hashMap_detls.put("BCG_YN",checkForNull(rs1.getString("BCG_YN")));
			hashMap_detls.put("GRAVIDA",checkForNull(rs1.getString("GRAVIDA")));
			hashMap_detls.put("PARITY",checkForNull(rs1.getString("PARITY")));
			hashMap_detls.put("FEEDING",checkForNull(rs1.getString("FEEDING")));
			hashMap_detls.put("STOOLS",checkForNull(rs1.getString("STOOLS")));
			hashMap_detls.put("COMPLN_DELY_DESC",checkForNull(rs1.getString("COMPLN_DELY_DESC")));
			hashMap_detls.put("UMBILICAL_CORD_STATUS",checkForNull(rs1.getString("UMBILICAL_CORD_STATUS")));
			hashMap_detls.put("INDICATOR_MARK",checkForNull(rs1.getString("INDICATOR_MARK")));
			hashMap_detls.put("BORN_AT",checkForNull(rs1.getString("BORN_AT")));
			hashMap_detls.put("MULTIPLE_BIRTH_YN",checkForNull(rs1.getString("MULTIPLE_BIRTH_YN")));
			hashMap_detls.put("POLIO_N_BCG_GIVEN_YN",checkForNull(rs1.getString("POLIO_N_BCG_GIVEN_YN")));
			hashMap_detls.put("NAME_SUFFIX",checkForNull(rs1.getString("NAME_SUFFIX")));
			hashMap_detls.put("REMARKS",checkForNull(rs1.getString("REMARKS")));
			hashMap_detls.put("BIRTH_CERTIFICATE_NO",checkForNull(rs1.getString("BIRTH_CERTIFICATE_NO")));
			hashMap_detls.put("BIRTH_PLACE_DESC",checkForNull(rs1.getString("BIRTH_PLACE_DESC")));
			hashMap_detls.put("VAGINAL_DELY_TYPE_DESC",checkForNull(rs1.getString("VAGINAL_DELY_TYPE_DESC")));
			hashMap_detls.put("DELY_IND_DESC",checkForNull(rs1.getString("DELY_IND_DESC")));
			hashMap_detls.put("VACCINATION_SITE",checkForNull(rs1.getString("VACCINATION_SITE")));
			hashMap_detls.put("VITAK_VACC_SITE",checkForNull(rs1.getString("VITAK_VACC_SITE")));
			hashMap_detls.put("VITAK_ADMINISTERED_BY",checkForNull(rs1.getString("VITAK_ADMINISTERED_BY")));
			hashMap_detls.put("VITAK_ADMINISTERED_DESIG",checkForNull(rs1.getString("VITAK_ADMINISTERED_DESIG")));

			//hashMap_detls.put("VITK_VACC_ADMN_DATE",checkForNull(rs1.getString("VITK_VACC_ADMN_DATE")));Commented by Rameswar on 30-Sep-15
			hashMap_detls.put("VITK_VACC_ADMN_DATE",DateUtils.convertDate(checkForNull(rs1.getString("VITK_VACC_ADMN_DATE")),"DMYHM","en",locale));//Modified by Rameswar on 30-Sep-15 for Leap Year Issue

			hashMap_detls.put("HEPB_VACC_SITE",checkForNull(rs1.getString("HEPB_VACC_SITE")));
			hashMap_detls.put("HEPB_ADMINISTERED_BY",checkForNull(rs1.getString("HEPB_ADMINISTERED_BY")));
			hashMap_detls.put("HEPB_ADMINISTERED_DESIG",checkForNull(rs1.getString("HEPB_ADMINISTERED_DESIG")));

			//hashMap_detls.put("HEPB_VACC_ADMN_DATE",checkForNull(rs1.getString("HEPB_VACC_ADMN_DATE"))); Commented by Rameswar on 30-Sep-15
			hashMap_detls.put("HEPB_VACC_ADMN_DATE",DateUtils.convertDate(checkForNull(rs1.getString("HEPB_VACC_ADMN_DATE")),"DMYHM","en",locale));//Modified by Rameswar on 30-Sep-15 for Leap Year Issue
			//Added by Ashwini on 11-Jul-2018 for ML-MMOH-CRF-0898.2
			hashMap_detls.put("MOTHER_WITNESSED_BY1",checkForNull(rs1.getString("MOTHER_WITNESSED_BY1")));
			hashMap_detls.put("MOTHER_WITNESSED_BY2",checkForNull(rs1.getString("MOTHER_WITNESSED_BY2")));
			String mother_alive_yn = checkForNull(rs1.getString("MOTHER_ALIVE_YN"));

			hashMap_detls.put("NB_COMPLN_DELY_DESC",checkForNull(rs1.getString("NB_COMPLN_DELY_DESC")));
			hashMap_detls.put("NO_OF_BIRTHS",checkForNull(rs1.getString("NO_OF_BIRTHS")));
			hashMap_detls.put("FATHER_PATIENT_ID",checkForNull(rs1.getString("FATHER_PATIENT_ID")));
			hashMap_detls.put("FATHER_PATIENT_NAME",checkForNull(rs1.getString("FATHER_PATIENT_NAME")));
			hashMap_detls.put("FATHER_NATIONAL_ID_NO",checkForNull(rs1.getString("FATHER_NATIONAL_ID_NO")));
			hashMap_detls.put("FATHER_ALT_ID1_TYPE",checkForNull(rs1.getString("FATHER_ALT_ID1_TYPE")));
			hashMap_detls.put("FATHER_ALT_ID2_TYPE",checkForNull(rs1.getString("FATHER_ALT_ID2_TYPE")));
			hashMap_detls.put("FATHER_ALT_ID3_TYPE",checkForNull(rs1.getString("FATHER_ALT_ID3_TYPE")));
			hashMap_detls.put("FATHER_ALT_ID4_TYPE",checkForNull(rs1.getString("FATHER_ALT_ID4_TYPE")));
			hashMap_detls.put("FATHER_ALT_ID1_NO",checkForNull(rs1.getString("FATHER_ALT_ID1_NO")));
			hashMap_detls.put("FATHER_ALT_ID2_NO",checkForNull(rs1.getString("FATHER_ALT_ID2_NO")));
			hashMap_detls.put("FATHER_ALT_ID3_NO",checkForNull(rs1.getString("FATHER_ALT_ID3_NO")));
			hashMap_detls.put("FATHER_ALT_ID4_NO",checkForNull(rs1.getString("FATHER_ALT_ID4_NO")));
			hashMap_detls.put("FATHER_NAT_DESC",checkForNull(rs1.getString("FATHER_NAT_DESC")));
			hashMap_detls.put("father_oth_alt_id_type",checkForNull(rs1.getString("father_oth_alt_id_type")));
			hashMap_detls.put("FATHER_RACE_DESC",checkForNull(rs1.getString("FATHER_RACE_DESC")));
			//hashMap_detls.put("OTH_ALT_ID_DESC",checkForNull(rs1.getString("OTH_ALT_ID_DESC")));
			hashMap_detls.put("FATHER_OTH_ALT_ID_NO",checkForNull(rs1.getString("FATHER_OTH_ALT_ID_NO")));
			hashMap_detls.put("RELGN_DESC",checkForNull(rs1.getString("RELGN_DESC")));
			hashMap_detls.put("FATHER_GOVE_EMPLOYEE_YN",checkForNull(rs1.getString("FATHER_GOVE_EMPLOYEE_YN")));
			hashMap_detls.put("OCPN_CLASS_DESC",checkForNull(rs1.getString("OCPN_CLASS_DESC")));
			hashMap_detls.put("OCPN_DESC",checkForNull(rs1.getString("OCPN_DESC")));
			hashMap_detls.put("FATHER_OCPN_DESC",checkForNull(rs1.getString("FATHER_OCPN_DESC")));
			hashMap_detls.put("NAME_PREFIX_LOC_LANG",checkForNull(rs1.getString("NAME_PREFIX_LOC_LANG")));
			hashMap_detls.put("NAME_SUFFIX_LOC_LANG",checkForNull(rs1.getString("NAME_SUFFIX_LOC_LANG")));
			hashMap_detls.put("FATHER_PATIENT_NAME_LOC_LANG",checkForNull(rs1.getString("FATHER_PATIENT_NAME_LOC_LANG")));
			hashMap_detls.put("MOTHER_PATIENT_NAME_LOC_LANG",checkForNull(rs1.getString("MOTHER_PATIENT_NAME_LOC_LANG")));
			hashMap_detls.put("NB_PATIENT_NAME_LOC_LANG",checkForNull(rs1.getString("NB_PATIENT_NAME_LOC_LANG")));
			hashMap_detls.put("COMPLNS_1ST_STAGE_LABOUR_CODE",checkForNull(rs1.getString("COMPLNS_1ST_STAGE_LABOUR_CODE")));
			hashMap_detls.put("COMPLNS_2ND_STAGE_LABOUR_CODE",checkForNull(rs1.getString("COMPLNS_2ND_STAGE_LABOUR_CODE")));
			hashMap_detls.put("COMPLNS_3RD_STAGE_LABOUR_CODE",checkForNull(rs1.getString("COMPLNS_3RD_STAGE_LABOUR_CODE")));
			hashMap_detls.put("COMPLN_PREGNANCY_CODE",checkForNull(rs1.getString("COMPLN_PREGNANCY_CODE")));
			hashMap_detls.put("COMPLN_PREGNANCY_DESC",checkForNull(rs1.getString("COMPLN_PREGNANCY_DESC")));
			hashMap_detls.put("COMPLN_NR_PREGNANCY_CODE",checkForNull(rs1.getString("COMPLN_NR_PREGNANCY_CODE")));
			hashMap_detls.put("COMPLN_NR_PREGNANCY_DESC",checkForNull(rs1.getString("COMPLN_NR_PREGNANCY_DESC")));
			/*Added by Ashwini on 01-Feb-2019 for ML-MMOH-CRF-1109*/
			hashMap_detls.put("COMPLN_PREGNANCY_LONG_DESC",checkForNull(rs1.getString("COMPLN_PREGNANCY_LONG_DESC")));
			hashMap_detls.put("COMPLN_NR_PREGNANCY_LONG_DESC",checkForNull(rs1.getString("COMPLN_NR_PREGNANCY_LONG_DESC")));
			hashMap_detls.put("COMPLNS_1ST_STAGE_LONG_DESC",checkForNull(rs1.getString("COMPLNS_1ST_STAGE_LONG_DESC")));
			hashMap_detls.put("COMPLNS_2ND_STAGE_LONG_DESC",checkForNull(rs1.getString("COMPLNS_2ND_STAGE_LONG_DESC")));
			hashMap_detls.put("COMPLNS_3RD_STAGE_LONG_DESC",checkForNull(rs1.getString("COMPLNS_3RD_STAGE_LONG_DESC")));
			hashMap_detls.put("COMPLN_DELY_LONG_DESC",checkForNull(rs1.getString("COMPLN_DELY_LONG_DESC")));
			hashMap_detls.put("NB_COMPLN_DEL_LONG_DESC",checkForNull(rs1.getString("NB_COMPLN_DEL_LONG_DESC")));
			hashMap_detls.put("DELY_IND_LONG_DESC",checkForNull(rs1.getString("DELY_IND_LONG_DESC")));
			hashMap_detls.put("PROC_CLASS_LONG_DESC",checkForNull(rs1.getString("PROC_CLASS_LONG_DESC")));
			hashMap_detls.put("VAGINAL_DEL_TYPE_LONG_DESC",checkForNull(rs1.getString("VAGINAL_DEL_TYPE_LONG_DESC")));
			hashMap_detls.put("DELY_SURG_CLASS_LONG_DESC",checkForNull(rs1.getString("DELY_SURG_CLASS_LONG_DESC")));
			hashMap_detls.put("CONG_ANOMALIES_LONG_DESC",checkForNull(rs1.getString("CONG_ANOMALIES_LONG_DESC")));
			/*End ML-MMOH-CRF-1109*/

			String heart_rate_in_1_min=checkForNull(rs1.getString("HEART_RATE_IN_1_MIN"));
			if(heart_rate_in_1_min.equals("0")){
				heart_rate_in_1_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Absent.label","mp_labels")+"(0)";
			}else if(heart_rate_in_1_min.equals("1")){
				heart_rate_in_1_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Below100bpm.label","mp_labels")+"(1)";
			}else if(heart_rate_in_1_min.equals("2")){
				heart_rate_in_1_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Above100bpm.label","mp_labels")+"(2)";
			}
			String heart_rate_in_5_min=checkForNull(rs1.getString("HEART_RATE_IN_5_MIN"));
			if(heart_rate_in_5_min.equals("0")){
				heart_rate_in_5_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Absent.label","mp_labels")+"(0)";
			}else if(heart_rate_in_5_min.equals("1")){
				heart_rate_in_5_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Below100bpm.label","mp_labels")+"(1)";
			}else if(heart_rate_in_5_min.equals("2")){
				heart_rate_in_5_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Above100bpm.label","mp_labels")+"(2)";
			}
			String heart_rate_in_10_min=checkForNull(rs1.getString("HEART_RATE_IN_10_MIN"));
			if(!heart_rate_in_10_min.equals("")){
				if(heart_rate_in_10_min.equals("0")){
					heart_rate_in_10_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Absent.label","mp_labels")+"(0)";
				}else if(heart_rate_in_10_min.equals("1")){
					heart_rate_in_10_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Below100bpm.label","mp_labels")+"(1)";
				}else if(heart_rate_in_10_min.equals("2")){
					heart_rate_in_10_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Above100bpm.label","mp_labels")+"(2)";
				}
			}


			String breathing_in_1_min=checkForNull(rs1.getString("BREATHING_IN_1_MIN"));
			if(breathing_in_1_min.equals("0")){
				breathing_in_1_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Absent.label","mp_labels")+"(0)";
			}else if(breathing_in_1_min.equals("1")){
				breathing_in_1_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Slowirregular.label","mp_labels")+"(1)";
			}else if(breathing_in_1_min.equals("2")){
				breathing_in_1_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.GoodCrying.label","mp_labels")+"(2)";
			}
			String breathing_in_5_min=checkForNull(rs1.getString("BREATHING_IN_5_MIN"));
			if(breathing_in_5_min.equals("0")){
				breathing_in_5_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Absent.label","mp_labels")+"(0)";
			}else if(breathing_in_5_min.equals("1")){
				breathing_in_5_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Slowirregular.label","mp_labels")+"(1)";
			}else if(breathing_in_5_min.equals("2")){
				breathing_in_5_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.GoodCrying.label","mp_labels")+"(2)";
			}
			String breathing_in_10_min=checkForNull(rs1.getString("BREATHING_IN_10_MIN"));
			if(!breathing_in_10_min.equals("")){
				if(breathing_in_10_min.equals("0")){
					breathing_in_10_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Absent.label","mp_labels")+"(0)";
				}else if(breathing_in_10_min.equals("1")){
					breathing_in_10_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Slowirregular.label","mp_labels")+"(1)";
				}else if(breathing_in_10_min.equals("2")){
					breathing_in_10_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.GoodCrying.label","mp_labels")+"(2)";
				}
			}

			String grimace_in_1_min=checkForNull(rs1.getString("GRIMACE_IN_1_MIN"));
			if(grimace_in_1_min.equals("0")){
				grimace_in_1_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.NoResponse.label","mp_labels")+"(0)";
			}else if(grimace_in_1_min.equals("1")){
				grimace_in_1_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Facialgrimace.label","mp_labels")+"(1)";
			}else if(grimace_in_1_min.equals("2")){
				grimace_in_1_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Sneezecoughpullsaway.label","mp_labels")+"(2)";
			}
			String grimace_in_5_min=checkForNull(rs1.getString("GRIMACE_IN_5_MIN"));
			if(grimace_in_5_min.equals("0")){
				grimace_in_5_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.NoResponse.label","mp_labels")+"(0)";
			}else if(grimace_in_5_min.equals("1")){
				grimace_in_5_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Facialgrimace.label","mp_labels")+"(1)";
			}else if(grimace_in_5_min.equals("2")){
				grimace_in_5_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Sneezecoughpullsaway.label","mp_labels")+"(2)";
			}
			String grimace_in_10_min=checkForNull(rs1.getString("GRIMACE_IN_10_MIN"));
			if(!grimace_in_10_min.equals("")){
				if(grimace_in_10_min.equals("0")){
					grimace_in_10_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.NoResponse.label","mp_labels")+"(0)";
				}else if(grimace_in_10_min.equals("1")){
					grimace_in_10_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Facialgrimace.label","mp_labels")+"(1)";
				}else if(grimace_in_10_min.equals("2")){
					grimace_in_10_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Sneezecoughpullsaway.label","mp_labels")+"(2)";
				}
			}

			String activity_in_1_min=checkForNull(rs1.getString("ACTIVITY_IN_1_MIN"));
			if(activity_in_1_min.equals("0")){
				activity_in_1_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Absent.label","mp_labels")+"(0)";
			}else if(activity_in_1_min.equals("1")){
				activity_in_1_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Armslegsextended.label","mp_labels")+"(1)";
			}else if(activity_in_1_min.equals("2")){
				activity_in_1_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Activemovementwithflexedarmslegs.label","mp_labels")+"(2)";
			}
			String activity_in_5_min=checkForNull(rs1.getString("ACTIVITY_IN_5_MIN"));
			if(activity_in_5_min.equals("0")){
				activity_in_5_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Absent.label","mp_labels")+"(0)";
			}else if(activity_in_5_min.equals("1")){
				activity_in_5_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Armslegsextended.label","mp_labels")+"(1)";
			}else if(activity_in_5_min.equals("2")){
				activity_in_5_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Activemovementwithflexedarmslegs.label","mp_labels")+"(2)";
			}
			String activity_in_10_min=checkForNull(rs1.getString("ACTIVITY_IN_10_MIN"));
			if(!activity_in_10_min.equals("")){
				if(activity_in_10_min.equals("0")){
					activity_in_10_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Absent.label","mp_labels")+"(0)";
				}else if(activity_in_10_min.equals("1")){
					activity_in_10_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Armslegsextended.label","mp_labels")+"(1)";
				}else if(activity_in_10_min.equals("2")){
					activity_in_10_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Activemovementwithflexedarmslegs.label","mp_labels")+"(2)";
				}
			}

			String appearance_in_1_min=checkForNull(rs1.getString("APPEARANCE_IN_1_MIN"));
			if(appearance_in_1_min.equals("0")){
				appearance_in_1_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Blue-graypaleallover.label","mp_labels")+"(0)";
			}else if(appearance_in_1_min.equals("1")){
				appearance_in_1_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Pinkbodyandblueextremities.label","mp_labels")+"(1)";
			}else if(appearance_in_1_min.equals("2")){
				appearance_in_1_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Normaloverentirebody-completelypink.label","mp_labels")+"(2)";
			}
			String appearance_in_5_min=checkForNull(rs1.getString("APPEARANCE_IN_5_MIN"));
			if(appearance_in_5_min.equals("0")){
				appearance_in_5_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Blue-graypaleallover.label","mp_labels")+"(0)";
			}else if(appearance_in_5_min.equals("1")){
				appearance_in_5_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Pinkbodyandblueextremities.label","mp_labels")+"(1)";
			}else if(appearance_in_5_min.equals("2")){
				appearance_in_5_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Normaloverentirebody-completelypink.label","mp_labels")+"(2)";
			}
			String appearance_in_10_min=checkForNull(rs1.getString("APPEARANCE_IN_10_MIN"));
			if(!appearance_in_10_min.equals("")){
				if(appearance_in_10_min.equals("0")){
					appearance_in_10_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Blue-graypaleallover.label","mp_labels")+"(0)";
				}else if(appearance_in_10_min.equals("1")){
					appearance_in_10_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Pinkbodyandblueextremities.label","mp_labels")+"(1)";
				}else if(appearance_in_10_min.equals("2")){
					appearance_in_10_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Normaloverentirebody-completelypink.label","mp_labels")+"(2)";
				}
			}

			hashMap_detls.put("HEART_RATE_IN_1_MIN",heart_rate_in_1_min);
			hashMap_detls.put("HEART_RATE_IN_5_MIN",heart_rate_in_5_min);
			hashMap_detls.put("HEART_RATE_IN_10_MIN",heart_rate_in_10_min);
			hashMap_detls.put("BREATHING_IN_1_MIN",breathing_in_1_min);
			hashMap_detls.put("BREATHING_IN_5_MIN",breathing_in_5_min);
			hashMap_detls.put("BREATHING_IN_10_MIN",breathing_in_10_min);
			hashMap_detls.put("GRIMACE_IN_1_MIN",grimace_in_1_min);
			hashMap_detls.put("GRIMACE_IN_5_MIN",grimace_in_5_min);
			hashMap_detls.put("GRIMACE_IN_10_MIN",grimace_in_10_min);
			hashMap_detls.put("ACTIVITY_IN_1_MIN",activity_in_1_min);
			hashMap_detls.put("ACTIVITY_IN_5_MIN",activity_in_5_min);
			hashMap_detls.put("ACTIVITY_IN_10_MIN",activity_in_10_min);
			hashMap_detls.put("APPEARANCE_IN_1_MIN",appearance_in_1_min);
			hashMap_detls.put("APPEARANCE_IN_5_MIN",appearance_in_5_min);
			hashMap_detls.put("APPEARANCE_IN_10_MIN",appearance_in_10_min);
			hashMap_detls.put("NB_NAME_PREFIX",checkForNull(rs1.getString("NB_NAME_PREFIX")));
			hashMap_detls.put("NB_FIRST_NAME",checkForNull(rs1.getString("NB_FIRST_NAME")));
			hashMap_detls.put("NB_SECOND_NAME",checkForNull(rs1.getString("NB_SECOND_NAME"))); 
			hashMap_detls.put("NB_THIRD_NAME",checkForNull(rs1.getString("NB_THIRD_NAME")));
			hashMap_detls.put("NB_FAMILY_NAME_PREFIX",checkForNull(rs1.getString("NB_FAMILY_NAME_PREFIX")));
			hashMap_detls.put("NB_FAMILY_NAME",checkForNull(rs1.getString("NB_FAMILY_NAME")));
			hashMap_detls.put("NB_NAME_SUFFIX",checkForNull(rs1.getString("NB_NAME_SUFFIX")));
			hashMap_detls.put("NB_NAME_PREFIX_LOC_LANG",checkForNull(rs1.getString("NB_NAME_PREFIX_LOC_LANG")));
			hashMap_detls.put("NB_FIRST_NAME_LOC_LANG",checkForNull(rs1.getString("NB_FIRST_NAME_LOC_LANG")));
			hashMap_detls.put("NB_SECOND_NAME_LOC_LANG",checkForNull(rs1.getString("NB_SECOND_NAME_LOC_LANG")));
			hashMap_detls.put("NB_THIRD_NAME_LOC_LANG",checkForNull(rs1.getString("NB_THIRD_NAME_LOC_LANG")));
			hashMap_detls.put("NB_FAMILY_NAME_LOC_LANG",checkForNull(rs1.getString("NB_FAMILY_NAME_LOC_LANG")));
			hashMap_detls.put("NB_NAME_SUFFIX_LOC_LANG",checkForNull(rs1.getString("NB_NAME_SUFFIX_LOC_LANG")));
			hashMap_detls.put("FATHER_NAME_PREFIX",checkForNull(rs1.getString("FATHER_NAME_PREFIX")));
			hashMap_detls.put("FATHER_FIRST_NAME",checkForNull(rs1.getString("FATHER_FIRST_NAME")));
			hashMap_detls.put("FATHER_SECOND_NAME",checkForNull(rs1.getString("FATHER_SECOND_NAME")));
			hashMap_detls.put("FATHER_THIRD_NAME",checkForNull(rs1.getString("FATHER_THIRD_NAME")));
			hashMap_detls.put("FATHER_FAMILY_NAME_PREFIX",checkForNull(rs1.getString("FATHER_FAMILY_NAME_PREFIX")));
			hashMap_detls.put("FATHER_FAMILY_NAME",checkForNull(rs1.getString("FATHER_FAMILY_NAME")));
			hashMap_detls.put("FATHER_NAME_SUFFIX",checkForNull(rs1.getString("FATHER_NAME_SUFFIX")));
			hashMap_detls.put("FATHER_NAME_PREFIX_LOC_LANG",checkForNull(rs1.getString("FATHER_NAME_PREFIX_LOC_LANG")));
			hashMap_detls.put("FATHER_FIRST_NAME_LOC_LANG",checkForNull(rs1.getString("FATHER_FIRST_NAME_LOC_LANG")));
			hashMap_detls.put("FATHER_SECOND_NAME_LOC_LANG",checkForNull(rs1.getString("FATHER_SECOND_NAME_LOC_LANG")));
			hashMap_detls.put("FATHER_THIRD_NAME_LOC_LANG",checkForNull(rs1.getString("FATHER_THIRD_NAME_LOC_LANG")));
			hashMap_detls.put("FATHER_FAMILY_NAME_LOC_LANG",checkForNull(rs1.getString("FATHER_FAMILY_NAME_LOC_LANG")));
			hashMap_detls.put("FATHER_NAME_SUFFIX_LOC_LANG",checkForNull(rs1.getString("FATHER_NAME_SUFFIX_LOC_LANG")));
			hashMap_detls.put("MIDWIFE_NAME",checkForNull(rs1.getString("MIDWIFE_NAME")));
			hashMap_detls.put("COMPLNS_1ST_STAGE_LABOUR_DESC",checkForNull(rs1.getString("COMPLNS_1ST_STAGE_LABOUR_DESC")));
			hashMap_detls.put("COMPLNS_2ND_STAGE_LABOUR_DESC",checkForNull(rs1.getString("COMPLNS_2ND_STAGE_LABOUR_DESC")));
			hashMap_detls.put("COMPLNS_3RD_STAGE_LABOUR_DESC",checkForNull(rs1.getString("COMPLNS_3RD_STAGE_LABOUR_DESC")));
			hashMap_detls.put("PROC_CLASS_DESC",checkForNull(rs1.getString("PROC_CLASS_DESC")));
			hashMap_detls.put("DELY_SURG_CLASS_DESC",checkForNull(rs1.getString("DELY_SURG_CLASS_DESC")));
			hashMap_detls.put("NB_PATIENT_NAME",checkForNull(rs1.getString("NB_PATIENT_NAME")));
			hashMap_detls.put("FATHER_REMARKS",checkForNull(rs1.getString("FATHER_REMARKS")));
			hashMap_detls.put("NB_RELATION_TO_HEAD",checkForNull(rs1.getString("NB_RELATION_TO_HEAD")));
			hashMap_detls.put("OUTCOME",checkForNull(rs1.getString("OUTCOME")));
			hashMap_detls.put("NB_COMPLN_DELY_DESC",checkForNull(rs1.getString("NB_COMPLN_DELY_DESC")));
			
			//below line added for this CRFCRF MMS-QH-CRF-0145.1 [IN:047497]
            hijri_birth_date	=checkForNull(rs1.getString("hijri_birth_date"));		
			hashMap_detls.put("hijri_birth_date",hijri_birth_date);
			
			//Below line added for this CRF ML-MMOH-CRF-0621
			hashMap_detls.put("parity_on_admission",checkForNull(rs1.getString("parity_on_admission")));
			hashMap_detls.put("resuscitated_pract_id",checkForNull(rs1.getString("resuscitated_pract_id")));
			hashMap_detls.put("resuscitated_pract_desc",checkForNull(rs1.getString("resuscitated_pract_desc"))); 
			attend_physician_id=checkForNull(rs1.getString("attend_physician_id")); 			
		if(!attend_physician_id.equals("") && isRegNewbornApplicable){			
			national_id_no=(String)hashMap_param.get("NAT_ID_PROMPT");
			StringBuffer natstrBuffer=new StringBuffer("select national_id_num, oth_alt_id_no from am_practitioner where practitioner_id ='");	
			natstrBuffer.append(attend_physician_id).append("'");		    
			stmt = con.prepareStatement(natstrBuffer.toString());			
			rset = stmt.executeQuery();			
			if(rset!=null && rset.next()){		
				national_id=rset.getString("national_id_num")==null?"":rset.getString("national_id_num");
				other_alter_id=rset.getString("oth_alt_id_no")==null?"":rset.getString("oth_alt_id_no"); 
			}			
		 if(!national_id.equals("")){
				if(national_id_no.equals("")){
						nat_other_alter_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.NationalIDNo.label","am_labels");
				}else{
						nat_other_alter_legend=national_id_no;	
				 }
				 
				nat_other_alter_id=national_id;					 
		 }else if(national_id.equals("") && !other_alter_id.equals("")){
					   nat_other_alter_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.OtherAltNo.label","mp_labels"); 
					   nat_other_alter_id=other_alter_id;
					 
		}
		  if(rset!=null) rset.close();
		  if(stmt!=null) stmt.close();
}	
				
//End this CRF ML-MMOH-CRF-0621
			
			


			
		
		//out.println(hashMap_detls.size());

		%>

			<form name='NewbornRegistration_form' id='NewbornRegistration_form' action='../../servlet/eMP.NewbornRegistrationServlet' method='post' target='messageFrame' onSubmit="return getNewBornRegnValues('pat_id')">

			<table width="100%" cellpadding='3' cellspacing=0 border='0'>
				<tr><td>
					<table id='mother_tab' width="100%" cellpadding='3' cellspacing=0 border='0'>
						<tr> 
							<td colspan='4' class='COLUMNHEADER'><span id='mother_dtls_link' onClick='javascript:expandCollapse("MD")'><input type='button' class='button' value='-' name='mother_button' id='mother_button'></span>&nbsp;<fmt:message key="eMP.motherdetails.label" bundle="${mp_labels}"/></td>
							
						</tr>
					</table>
				</td></tr>
				<tr><td>
				<div id='mother_dtls'>
					<table width="100%" cellpadding='3' cellspacing=0 border='0'>
				
					<tr>
					<td class='label'  width='25%' ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
					<td class='querydata' width='25%'><b><%=(String)hashMap_detls.get("MOTHER_PATIENT_ID")%></b></td>
					<td class='label'  width='25%' ><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
					<td class='querydata' width='25%'><b><%=(String)hashMap_detls.get("MOTHER_PATIENT_NAME")%></b></td>
					</tr>
				
					<%
/*Below line added for this CRF ML-MMOH-CRF-0621*/
if(isRegNewbornApplicable){			
String alt_id1_type_desc=checkForNull((String) hashMap_param.get("alt_id1_type_desc"));
String alt_id2_type_desc=checkForNull((String) hashMap_param.get("alt_id2_type_desc"));
String alt_id3_type_desc=checkForNull((String) hashMap_param.get("alt_id3_type_desc"));
String alt_id4_type_desc=checkForNull((String) hashMap_param.get("alt_id4_type_desc"));
String accept_oth_alt_id_yn=checkForNull((String) hashMap_param.get("accept_oth_alt_id_yn"));
String accept_national_id_no_yn=checkForNull((String) hashMap_param.get("ACCEPT_NATIONAL_ID_NO_YN"));
String nat_id_prompt=checkForNull((String) hashMap_param.get("NAT_ID_PROMPT"));

/*String alt_id1_no =checkForNull((String)hashMap_detls.get("mother_alt_id1_no"));
String alt_id2_no =checkForNull((String)hashMap_detls.get("mother_alt_id2_no")); 
String alt_id3_no =checkForNull((String)hashMap_detls.get("mother_alt_id3_no"));  
String alt_id4_no =checkForNull((String)hashMap_detls.get("alt_id4_no"));  
String m_oth_alt_id_no =checkForNull((String)hashMap_detls.get("mother_oth_alt_id_no"));  */

String alt_id1_no =checkForNull((String)hashMap_detls.get("m_alt_id1_no"));
String alt_id2_no =checkForNull((String)hashMap_detls.get("m_alt_id2_no")); 
String alt_id3_no =checkForNull((String)hashMap_detls.get("m_alt_id3_no"));
String m_oth_alt_id_no =checkForNull((String)hashMap_detls.get("m_oth_alt_id_no"));  


if(accept_national_id_no_yn.equals("Y")){		
%>					
          <tr>		       
	<% if(!nat_id_prompt.equals("")){  %>
					  <td class='label' height="25"><%=nat_id_prompt%>&nbsp;</td>
					  <td class='QUERYDATA' height="25"><%=(String)hashMap_detls.get("MOTHER_NATIONAL_ID_NO")%>&nbsp;</td>
    <% }else {%>
			          <td class='label' >&nbsp;</td>
					  <td class='QUERYDATA' >&nbsp;</td>
	 <%}%>
				      <td class='label'>&nbsp;</td>
				      <td class='QUERYDATA'>&nbsp;</td>  				
			</tr> 
<%}%>			
<tr>			     
			<td class='label' height="25" ><%if(!alt_id1_type_desc.equals("")){%><fmt:message key="eMP.mothers.label" bundle="${mp_labels}"/> <%=alt_id1_type_desc%></td><input type = 'hidden' name ='alt_id_type_desc' value='<%=alt_id1_type_desc%>'> <%}if(alt_id1_type_desc.equals("")&&!alt_id2_type_desc.equals("")){%><%=alt_id2_type_desc%> <%} if(alt_id1_type_desc.equals("")&&alt_id2_type_desc.equals("") && !alt_id3_type_desc.equals("")){%><%=alt_id3_type_desc%><%}if(alt_id1_type_desc.equals("")&&alt_id2_type_desc.equals("") && alt_id3_type_desc.equals("") && accept_oth_alt_id_yn.equals("Y")){%><fmt:message key="eMP.OtherAltNo.label" bundle="${common_labels}"/> <%}%>
			 <td class='QUERYDATA' height="25"><%if(!alt_id1_type_desc.equals("")){%><%=alt_id1_no%><%}if(alt_id1_type_desc.equals("")&&!alt_id2_type_desc.equals("")){%><%=alt_id2_no%><%}if(alt_id1_type_desc.equals("")&&alt_id2_type_desc.equals("") && !alt_id3_type_desc.equals("")){%><%=alt_id3_no%><%} if(alt_id1_type_desc.equals("")&&alt_id2_type_desc.equals("") && alt_id3_type_desc.equals("") && accept_oth_alt_id_yn.equals("Y")){%><%=m_oth_alt_id_no%><%}%></td>			
			<%
			  if((!alt_id1_type_desc.equals("") && !alt_id2_type_desc.equals("") && (accept_oth_alt_id_yn.equals("N") || accept_oth_alt_id_yn.equals("Y"))) && (alt_id3_type_desc.equals("") || !alt_id3_type_desc.equals("") ) ){%>
					  <td class='label' height="25"><%=alt_id2_type_desc%>&nbsp;</td>
					  <td class='QUERYDATA' height="25"><%=alt_id2_no%>&nbsp;</td>
            <% }
			if((!alt_id1_type_desc.equals("") && alt_id2_type_desc.equals("") &&!alt_id3_type_desc.equals("") && (accept_oth_alt_id_yn.equals("N") ||accept_oth_alt_id_yn.equals("Y")) )){
			%>
					  <td class='label' height="25"><%=alt_id3_type_desc%>&nbsp;</td>
					  <td class='QUERYDATA' height="25"><%=alt_id3_no%>&nbsp;</td>
            <% } if((!alt_id1_type_desc.equals("") && alt_id2_type_desc.equals("") && alt_id3_type_desc.equals("") && accept_oth_alt_id_yn.equals("Y")) || (alt_id1_type_desc.equals("") && !alt_id2_type_desc.equals("") && alt_id3_type_desc.equals("") && accept_oth_alt_id_yn.equals("Y")) || (alt_id1_type_desc.equals("") && alt_id2_type_desc.equals("") && !alt_id3_type_desc.equals("") && accept_oth_alt_id_yn.equals("Y")) ){%>
					  <td  class="label"  height="25"><fmt:message key="eMP.OtherAltNo.label" bundle="${common_labels}"/></td>
					  <td class='QUERYDATA'  height="25"><%=m_oth_alt_id_no%>&nbsp;</td>
			          
			   <% } %>
			   
			   <tr> 
			
			   <% 
                if((!alt_id1_type_desc.equals("") && !alt_id2_type_desc.equals("") && !alt_id3_type_desc.equals("")) || ((!alt_id1_type_desc.equals("") && !alt_id2_type_desc.equals("") && alt_id3_type_desc.equals("") && accept_oth_alt_id_yn.equals("Y")) || (alt_id1_type_desc.equals("") && !!alt_id2_type_desc.equals("") && !alt_id3_type_desc.equals("") && accept_oth_alt_id_yn.equals("Y")) || (!alt_id1_type_desc.equals("") && alt_id2_type_desc.equals("") && !alt_id3_type_desc.equals("") && accept_oth_alt_id_yn.equals("Y")) ) ){   
               
			   %>
			   <td class='label' height="25"><%if(!alt_id1_type_desc.equals("") && !alt_id2_type_desc.equals("") && !alt_id3_type_desc.equals("")){%><%=alt_id3_type_desc%><%}else {%><fmt:message key="eMP.OtherAltNo.label" bundle="${common_labels}"/><%}%> </td>
					  <td class='QUERYDATA' height="25"><%if(!alt_id1_type_desc.equals("") && !alt_id2_type_desc.equals("") && !alt_id3_type_desc.equals("")){%><%=alt_id3_no%><%}else{%><%=m_oth_alt_id_no%><%}%>&nbsp;</td>
			   <% } if(!alt_id1_type_desc.equals("") && !alt_id2_type_desc.equals("") && !alt_id3_type_desc.equals("") && accept_oth_alt_id_yn.equals("Y")){%>
					  <td  class="label"  height="25"><fmt:message key="eMP.OtherAltNo.label" bundle="${common_labels}"/></td>
					  <td class='QUERYDATA'  height="25"><%=m_oth_alt_id_no%>&nbsp;</td>
			          
			   <% } %>
			   </tr>					
					
					<%}else{%>
					
						<tr>
					<td class='label' width='25%'><fmt:message key="eMP.mothers.label" bundle="${mp_labels}"/>&nbsp;<%=(String)hashMap_param.get("NAT_ID_PROMPT")%></td>
					<td class='querydata' width='75%' colspan=3><b><%=(String)hashMap_detls.get("MOTHER_NATIONAL_ID_NO")%></td>
					</td>
					</tr>
					
					<tr> 
					<td class='label'  width='25%'  ><%if((String)hashMap_detls.get("mother_alt_id1_type")!="")%><%=(String)hashMap_detls.get("mother_alt_id1_type")%><%else%><%=(String)hashMap_detls.get("m_alt_id1_type")%> </td>
					<td class='querydata' width='25%'><b><%if((String)hashMap_detls.get("mother_alt_id1_no")!="")%><%=(String)hashMap_detls.get("mother_alt_id1_no")%><%else%><%=(String)hashMap_detls.get("m_alt_id1_no")%></b></td> 
					<td class='label'  width='25%'  ><%if((String)hashMap_detls.get("mother_alt_id2_type")!="")%><%=(String)hashMap_detls.get("mother_alt_id2_type")%><%else%><%=(String)hashMap_detls.get("m_alt_id2_type")%></td>
					<td class='querydata' width='25%'><b><%if((String)hashMap_detls.get("mother_alt_id2_no")!="")%><%=(String)hashMap_detls.get("mother_alt_id2_no")%><%else%><%=(String)hashMap_detls.get("m_alt_id2_no")%></b></td> 
					</tr>
					<tr> 
					<td class='label'  width='25%'  ><%if((String)hashMap_detls.get("mother_alt_id3_type")!="")%><%=(String)hashMap_detls.get("mother_alt_id3_type")%><%else%><%=(String)hashMap_detls.get("m_alt_id3_type")%></td>
					<td class='querydata' width='25%'><b><%if((String)hashMap_detls.get("mother_alt_id3_no")!="")%><%=(String)hashMap_detls.get("mother_alt_id3_no")%><%else%><%=(String)hashMap_detls.get("m_alt_id3_no")%></b></td> 
					<td class='label'  width='25%'  ><%if((String)hashMap_detls.get("mother_alt_id4_type")!="")%><%=(String)hashMap_detls.get("mother_alt_id4_type")%><%else%><%=(String)hashMap_detls.get("m_alt_id4_type")%></td>
					<td class='querydata' width='25%'><b><%if((String)hashMap_detls.get("mother_alt_id4_no")!="")%><%=(String)hashMap_detls.get("mother_alt_id4_no")%><%else%><%=(String)hashMap_detls.get("m_alt_id4_no")%></b></td> 
					</tr>
					<tr>
					<td class='label'  width='25%'  ><%if((String)hashMap_detls.get("mother_oth_alt_id_type")!="")%><%=(String)hashMap_detls.get("mother_oth_alt_id_type")%><%else%><%=(String)hashMap_detls.get("m_oth_alt_id_type")%></td>
					<td class='querydata' width='25%'><b><%if((String)hashMap_detls.get("mother_oth_alt_id_no")!="")%><%=(String)hashMap_detls.get("mother_oth_alt_id_no")%><%else%><%=(String)hashMap_detls.get("m_oth_alt_id_no")%></b></td> 
					</tr>
					<%}
					  //End this CRF ML-MMOH-CRF-0621
					%>
					<tr>
					<td class='label' width='25%' ><fmt:message key="eMP.MultipleBirth.label" bundle="${mp_labels}"/></td>
					<td class='querydata' width='25%'><b><%=(String)hashMap_detls.get("MULTIPLE_BIRTH_YN")%><b></b></td>
					<td class='label'   width='25%'><fmt:message key="Common.NoofBirths.label" bundle="${common_labels}"/></td>
					<td class='querydata' width='25%'><b><%=(String)hashMap_detls.get("NO_OF_BIRTHS")%></b></td>
					<tr>
					<td class='label'  width='25%' ><fmt:message key="eMP.Gestation.label" bundle="${mp_labels}"/> </td>

					<%
						if(((String)hashMap_param.get("UNIT_OF_GEST_NB")).equals("W")) {
						
					%>

					<td class='querydata' width='25%'><b><%=checkForNull1(((String)hashMap_detls.get("GESTATIONAL_PERIOD")),"0")%>&nbsp;</b><fmt:message key="Common.weeks.label" bundle="${common_labels}"/>&nbsp;&nbsp;<b><%=checkForNull1(((String)hashMap_detls.get("GESTATIONAL_PERIOD_IN_DAYS")),"0")%>&nbsp;</b><fmt:message key="Common.days.label" bundle="${common_labels}"/></td>

					<% } else if(((String)hashMap_param.get("UNIT_OF_GEST_NB")).equals("D")) {%>

					<td class='querydata' width='25%'><b><%=checkForNull1(((String)hashMap_detls.get("GESTATIONAL_PERIOD")),"0")%>&nbsp;
					</b><fmt:message key="Common.days.label" bundle="${common_labels}"/></td>

					<%
					
						}						
					%>


					<td class='label'  width='25%'><fmt:message key="eMP.DeliveryType.label" bundle="${mp_labels}"/></td>
					<td class='querydata' width='25%'><b><%=(String)hashMap_detls.get("DELIVERY_TYPE")%></b></td>
					</tr>
					<tr>
					<%
					/*Below line modified for this CRF ML-MMOH-CRF-0621*/
					if(isLabelChangeApplicable || isRegNewbornApplicable){%><!--Added by Rameswar on 07th July 2015 against HSA-CRF-0223 IN050565-->
					<td class='label' width='25%' ><fmt:message key="eMP.GravidaOnAdmission.label" bundle="${mp_labels}"/></td>
					<%}else{%>
					<td class='label' width='25%' ><fmt:message key="eMP.Gravida.label" bundle="${mp_labels}"/></td>
					<%}%>
					<td class='querydata' width='25%'><b><%=(String)hashMap_detls.get("GRAVIDA")%></b></td>
					<%if(isLabelChangeApplicable || isRegNewbornApplicable){%><!--Added by Rameswar on 07th July 2015 against HSA-CRF-0223 IN050565-->
					<td class='label'   width='25%'><fmt:message key="eMP.ParityOnAdmission.label" bundle="${mp_labels}"/></td>
					<%}else{%>
					<td class='label'   width='25%'><fmt:message key="eMP.Parity.label" bundle="${mp_labels}"/></td>
					<%}%>
					<td class='querydata' width='25%'><b><%=(String)hashMap_detls.get("PARITY")%> &nbsp; <%if(isRegNewbornApplicable){%><%=(String)hashMap_detls.get("parity_on_admission")%><%}
					//End this CRF ML-MMOH-CRF-0621
					%></b></td>
					</tr>
					<!--Modified by Ashwini on 11-Jul-2018 for ML-MMOH-CRF-0898.2-->
					<tr>
					<td class='label' width='25%'><%if(isNewBornChngsAppl){%><fmt:message key="Common.ConductedBy.label" bundle="${common_labels}"/><%}else{%><fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/><%}%></td>
					<td class='querydata' width='25%'><b><%=(String)hashMap_detls.get("PHYSICIAN_NAME")%></b></td>
					<td class='label' width='25%'><%if(isNewBornChngsAppl){%><fmt:message key="eIP.AssistedBy.label" bundle="${ip_labels}"/><%}else{%><fmt:message key="eMP.AttendingNurse.label" bundle="${mp_labels}"/><%}%></td>
					<td class='querydata' width='25%'><b><%=(String)hashMap_detls.get("MIDWIFE_NAME")%></b></td>
					</tr>
					<%if(isNewBornChngsAppl){%>
					<tr>
					<td class='label' width='25%'><fmt:message key="eIP.WitnessedBy1.label" bundle="${ip_labels}"/></td>
					<td class='querydata' width='25%' style='word-wrap:break-word;width:300px'><b><%=(String)hashMap_detls.get("MOTHER_WITNESSED_BY1")%></b></td>
					<td class='label' width='25%'><fmt:message key="eIP.WitnessedBy2.label" bundle="${ip_labels}"/></td>
					<td class='querydata' width='25%' style='word-wrap:break-word;width:300px'><b><%=(String)hashMap_detls.get("MOTHER_WITNESSED_BY2")%></b></td>
					</tr>
					<%}%>
					<!--End ML-MMOH-CRF-0898.2-->
					<!--Below line added for this CRF ML-MMOH-CRF-0621-->
					<%if(isRegNewbornApplicable){%>
					<tr>
					<td class='label' width='25%'><%=nat_other_alter_legend%>&nbsp;
					<td class='querydata' width='25%'><b><%=nat_other_alter_id%>&nbsp;</b></td>
					<td class='label' width='25%' >&nbsp;</td>
					<td class='querydata' width='25%'>&nbsp;</td>
					</tr>
                    <%}%>					
					<!--End ML-MMOH-CRF-0621-->					
					<tr>
					<!--Modified by Ashwini on 01-Feb-2019 for ML-MMOH-CRF-1109-->
					<td class='label'  width='25%'  ><fmt:message key="eMP.ComplicationsRelatedPregnancy.label" bundle="${mp_labels}"/></td>
					<td class='querydata' width='25%' style='word-wrap:break-word;width:300px;'><b><%=(String)hashMap_detls.get("COMPLN_PREGNANCY_LONG_DESC")%></b></td>
					<td class='label'  width='25%'  ><fmt:message key="eMP.ComplicationsNotRelatedPregnancy.label" bundle="${mp_labels}"/></td>
					<td class='querydata' width='25%' style='word-wrap:break-word;width:300px;'><b><%=(String)hashMap_detls.get("COMPLN_NR_PREGNANCY_LONG_DESC")%></b></td>
					</tr>
					 <tr>
					<td class='label'  width='25%'  ><fmt:message key="eMP.Complicationsin1stStage.label" bundle="${mp_labels}"/></td>
					<td class='querydata' width='25%' style='word-wrap:break-word;width:300px;'><b><%=(String)hashMap_detls.get("COMPLNS_1ST_STAGE_LONG_DESC")%></b></td>
					<td class='label'  width='25%'  ><fmt:message key="eMP.Complicationsin2ndStage.label" bundle="${mp_labels}"/></td>
					<td class='querydata' width='25%' style='word-wrap:break-word;width:300px;'><b><%=(String)hashMap_detls.get("COMPLNS_2ND_STAGE_LONG_DESC")%></b></td>
					</tr>
					 <tr>
					<td class='label'  width='25%'  ><fmt:message key="eMP.Complicationsin3rdStage.label" bundle="${mp_labels}"/></td>
					<td class='querydata' width='25%' style='word-wrap:break-word;width:300px;'><b><%=(String)hashMap_detls.get("COMPLNS_3RD_STAGE_LONG_DESC")%></b></td>
					<!--Modified by Ashwini on 01-Feb-2019 for ML-MMOH-CRF-1109-->
					<td class='label'  width='25%'  ><%if(isModifyLongShortDescAppl){%><fmt:message key="eMP.OperativeComplications.label" bundle="${mp_labels}"/><%}else{%><fmt:message key="eMP.CompofDelivery.label" bundle="${mp_labels}"/><%}%></td>
					<td class='querydata' width='25%' style='word-wrap:break-word;width:300px;'><b><%=(String)hashMap_detls.get("COMPLN_DELY_LONG_DESC")%></b></td>
					</tr>
					 <tr>
					<!--Modified by Ashwini on 01-Feb-2019 for ML-MMOH-CRF-1109-->
					<td class='label'  width='25%'  ><%if(isModifyLongShortDescAppl){%><fmt:message key="eMP.IndicationsForOperativeDelivery.label" bundle="${mp_labels}"/><%}else{%><fmt:message key="eMP.DeliveryIndication.label" bundle="${mp_labels}"/><%}%></td>
					<td class='querydata' width='25%' style='word-wrap:break-word;width:300px;'><b><%=(String)hashMap_detls.get("DELY_IND_LONG_DESC")%></b></td>
					<td class='label'  width='25%'  ><fmt:message key="eMP.ProcedureClassification.label" bundle="${mp_labels}"/></td>
					<td class='querydata' width='25%' style='word-wrap:break-word;width:300px;'><b><%=(String)hashMap_detls.get("PROC_CLASS_LONG_DESC")%></b></td>
					</tr>
					 <tr>
					<td class='label'  width='25%'  ><fmt:message key="eMP.VaginalDeliveryType.label" bundle="${mp_labels}"/></td>
					<td class='querydata' width='25%' style='word-wrap:break-word;width:300px;'><b><%=(String)hashMap_detls.get("VAGINAL_DEL_TYPE_LONG_DESC")%></b></td>
					<!--Modified by Ashwini on 01-Feb-2019 for ML-MMOH-CRF-1109-->
					<td class='label'  width='25%'  ><%if(isModifyLongShortDescAppl){%><fmt:message key="eMP.DeliverySurgClass.label" bundle="${mp_labels}"/><%}else{%><fmt:message key="eMP.DeliverySurgicalClassification.label" bundle="${mp_labels}"/><%}%></td>
					<td class='querydata' width='25%' style='word-wrap:break-word;width:300px;'><b><%=(String)hashMap_detls.get("DELY_SURG_CLASS_LONG_DESC")%></b></td>
					</tr>
					 <tr>
					<td class='label'  width='25%'  ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
					<td class='querydata' width='75%' colspan=3><b><%=(String)hashMap_detls.get("REMARKS")%></b></td>
					</tr>
					<!--Added by Ashwini on 11-Jul-2018 for ML-MMOH-CRF-0898.2-->
					<%if(isNewBornChngsAppl || isMotherAliveAppl){%>
					<tr>
					<td class='label' width='25%'><fmt:message key="eCA.Alive.label" bundle="${ca_labels}"/></td>
					<td class='querydata' width='25%'><b><%if("Y".equals(mother_alive_yn)){%><fmt:message key="Common.yes.label" bundle="${common_labels}"/><%}else if("N".equals(mother_alive_yn)){%><fmt:message key="Common.no.label" bundle="${common_labels}"/><%}%></b></td>
					</tr>
					<%}%>
					<!--End ML-MMOH-CRF-0898.2-->
				</table>
				</div>
				</td></tr> 
			
			<tr><td>		
			<table id='father_tab' width="100%" cellpadding='3' cellspacing=0 border=0 >	
				<tr><td colspan='4' class='COLUMNHEADER'><span id='father_dtls_link' onClick='javascript:expandCollapse("FD")'><input type='button' class='button' value='-' name='father_button' id='father_button'></span>&nbsp;<fmt:message key="eMP.fatherdetails.label" bundle="${mp_labels}"/></td></tr>
			</table>
			<tr><td>
			<div id='father_dtls'>
			<table width="100%" cellpadding='3' cellspacing=0 border=0 >	
			 <tr>
			<td class='label'  width='25%'  ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
			<td class='querydata' width='25%'><b><%=(String)hashMap_detls.get("FATHER_PATIENT_ID")%></b></td>
			<td class='label'  width='25%'  ><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
			<td class='querydata' width='25%'><b><%=(String)hashMap_detls.get("FATHER_PATIENT_NAME")%></b></td>
			</tr>
			<tr>
			<td colspan=4 align="left">
			<table border=0 cellpadding='1' cellspacing=0 width="100%" align="left">
			<tr>
			<%
			String a1=	(String) hashMap_param.get("NAME_PREFIX_ACCEPT_YN");	
			String a2=	(String) hashMap_param.get("FIRST_NAME_ACCEPT_YN");		
			String a3=	(String) hashMap_param.get("SECOND_NAME_ACCEPT_YN");		
			String a4=	(String) hashMap_param.get("THIRD_NAME_ACCEPT_YN");		
			String a5=	(String) hashMap_param.get("FAMILY_NAME_ACCEPT_YN");		
			String a6=	(String) hashMap_param.get("NAME_SUFFIX_ACCEPT_YN");		
			String p1=	(String) hashMap_param.get("NAME_PREFIX_PROMPT");		
			String p2=	(String) hashMap_param.get("FIRST_NAME_PROMPT");		
			String p3=	(String) hashMap_param.get("SECOND_NAME_PROMPT");		
			String p4=	(String) hashMap_param.get("THIRD_NAME_PROMPT");		
			String p5=	(String) hashMap_param.get("FAMILY_NAME_PROMPT");	
			String p6=	(String) hashMap_param.get("NAME_SUFFIX_PROMPT");		
			String oth1=(String) hashMap_param.get("NAMES_IN_OTH_LANG_YN");		
			String op1=	(String) hashMap_param.get("NAME_PREFIX_LOC_LANG_PROMPT");		
			String op2=	(String) hashMap_param.get("FIRST_NAME_LOC_LANG_PROMPT");	
			String op3=	(String) hashMap_param.get("SECOND_NAME_LOC_LANG_PROMPT");		
			String op4=	(String) hashMap_param.get("THIRD_NAME_LOC_LANG_PROMPT");		
			String op5=	(String) hashMap_param.get("FAMILY_NAME_LOC_LANG_PROMPT");		
			String op6=	(String) hashMap_param.get("NAME_SUFFIX_LOC_LANG_PROMPT");		


			out.println("<td class='label'  width='15%'>&nbsp;");
			if(a1.equals("Y")){
				out.println(p1);
			}
			out.println("</td>");

			out.println("<td class='label'  width='15%'>&nbsp;");
			if(a2.equals("Y")){
				out.println(p2);
			}
			out.println("</td>");

			out.println("<td class='label'  width='15%'>&nbsp;");
			if(a3.equals("Y")){
				out.println(p3);
			}
			out.println("</td>");

			out.println("<td class='label'  width='15%'>&nbsp;");
			if(a4.equals("Y")){
				out.println(p4);
			}
			out.println("</td>");

			out.println("<td class='label'  width='15%'>&nbsp;");
			if(a5.equals("Y")){
				out.println(p5);
			}
			out.println("</td>");

			out.println("<td class='label'  width='15%'>&nbsp;");
			if(a6.equals("Y")){
				out.println(p6);
			}
			out.println("</td>");
				
			%>	
			
			</tr>
			<tr>
			
			<%
			out.println("<td class='querydata'  width='15%'>&nbsp;");
			if(a1.equals("Y")){
				out.println((String)hashMap_detls.get("FATHER_NAME_PREFIX"));
			}
			out.println("</td>");

			out.println("<td class='querydata'  width='15%'>&nbsp;");
			if(a2.equals("Y")){
				out.println((String)hashMap_detls.get("FATHER_FIRST_NAME"));
			}
			out.println("</td>");

			out.println("<td class='querydata'  width='15%'>&nbsp;");
			if(a3.equals("Y")){
				out.println((String)hashMap_detls.get("FATHER_SECOND_NAME"));
			}
			out.println("</td>");

			out.println("<td class='querydata'  width='15%'>&nbsp;");
			if(a4.equals("Y")){
				out.println((String)hashMap_detls.get("FATHER_THIRD_NAME"));
			}
			out.println("</td>");

			out.println("<td class='querydata'  width='15%'>&nbsp;");
			if(a5.equals("Y")){
				out.println((String)hashMap_detls.get("FATHER_FAMILY_NAME"));
			}
			out.println("</td>");

			out.println("<td class='querydata'  width='15%'>&nbsp;");
			if(a6.equals("Y")){
				out.println((String)hashMap_detls.get("FATHER_NAME_SUFFIX"));
			}
			out.println("</td>");

			%>
			</tr>
			<tr>
			
			<%
			if(oth1.equals("Y")){
				out.println("<td class='label'  width='15%'>&nbsp;");
				if(a1.equals("Y")){
					out.println(op1);
				}
				out.println("</td>");

				out.println("<td class='label'  width='15%'>&nbsp;");
				if(a2.equals("Y")){
					out.println(op2);
				}
				out.println("</td>");

				out.println("<td class='label'  width='15%'>&nbsp;");
				if(a3.equals("Y")){
					out.println(op3);
				}
				out.println("</td>");

				out.println("<td class='label'  width='15%'>&nbsp;");
				if(a4.equals("Y")){
					out.println(op4);
				}
				out.println("</td>");

				out.println("<td class='label'  width='15%'>&nbsp;");
				if(a5.equals("Y")){
					out.println(op5);
				}
				out.println("</td>");

				out.println("<td class='label'   width='15%''>&nbsp;");
				if(a6.equals("Y")){
					out.println(op6);
				}
				out.println("</td>");
			}
			%>
			</tr>
			<tr>
			<%
			if(oth1.equals("Y")){
				out.println("<td class='querydata'  width='15%'>&nbsp;");
				if(a1.equals("Y")){
					out.println((String)hashMap_detls.get("FATHER_NAME_PREFIX_LOC_LANG"));
				}
				out.println("</td>");

				out.println("<td class='querydata'  width='15%'>&nbsp;");
				if(a2.equals("Y")){
					out.println((String)hashMap_detls.get("FATHER_FIRST_NAME_LOC_LANG"));
				}
				out.println("</td>");

				out.println("<td class='querydata'  width='15%'>&nbsp;");
				if(a3.equals("Y")){
					out.println((String)hashMap_detls.get("FATHER_SECOND_NAME_LOC_LANG"));
				}
				out.println("</td>");

				out.println("<td class='querydata'  width='15%'>&nbsp;");
				if(a4.equals("Y")){
					out.println((String)hashMap_detls.get("FATHER_THIRD_NAME_LOC_LANG"));
				}
				out.println("</td>");

				out.println("<td class='querydata'  width='15%'>&nbsp;");
				if(a5.equals("Y")){
					out.println((String)hashMap_detls.get("FATHER_FAMILY_NAME_LOC_LANG"));
				}
				out.println("</td>");

				out.println("<td class='querydata'  width='15%'>&nbsp;");
				if(a6.equals("Y")){
					out.println((String)hashMap_detls.get("FATHER_NAME_SUFFIX_LOC_LANG"));
				}
				out.println("</td>");
				
				
			}
			%>
			</tr>
			</table>
			<tr>
			<td class='label'  width='25%'  ><%=(String)hashMap_param.get("NAT_ID_PROMPT")%></td>
			<td class='querydata' width='75%' colspan=3><b><%=(String)hashMap_detls.get("FATHER_NATIONAL_ID_NO")%></td>
			</tr>
			<tr> 
			<td class='label'  width='25%'  ><%=(String)hashMap_detls.get("FATHER_ALT_ID1_TYPE")%></td>
			<td class='querydata' width='25%'><b><%=(String)hashMap_detls.get("FATHER_ALT_ID1_NO")%></b></td> 
			<td class='label'  width='25%'  ><%=(String)hashMap_detls.get("FATHER_ALT_ID2_TYPE")%></td>
			<td class='querydata' width='25%'><b><%=(String)hashMap_detls.get("FATHER_ALT_ID2_NO")%></b></td> 
			</tr>
			<tr> 
			<td class='label'  width='25%'  ><%=(String)hashMap_detls.get("FATHER_ALT_ID3_TYPE")%></td>
			<td class='querydata' width='25%'><b><%=(String)hashMap_detls.get("FATHER_ALT_ID3_NO")%></b></td> 
			<td class='label'  width='25%'  ><%=(String)hashMap_detls.get("FATHER_ALT_ID4_TYPE")%></td>
			<td class='querydata' width='25%'><b><%=(String)hashMap_detls.get("FATHER_ALT_ID4_NO")%></b></td> 
			</tr>
			<tr>
			<td class='label'  width='25%' ><%=(String)hashMap_detls.get("father_oth_alt_id_type")%></td>
			<td class='querydata' width='25%'><b><%=(String)hashMap_detls.get("FATHER_OTH_ALT_ID_NO")%></b></td> 
			<!--<td class='label'  width='25%'><fmt:message key="Common.otheraltid.label" bundle="${common_labels}"/> </td> 
			<td class='querydata' width='25%'><b><%=(String)hashMap_detls.get("OTH_ALT_ID_DESC")%> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=(String)hashMap_detls.get("FATHER_OTH_ALT_ID_NO")%></b></td>-->
			</tr>
			<tr>
			<td  class='label'  width='25%'><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></td>

			<td class='querydata' width='25%'><b><%=(String)hashMap_detls.get("FATHER_NAT_DESC")%></b></td>
			<td class='label' width='25%'><fmt:message key="Common.race.label" bundle="${common_labels}"/> </td>
			<td class='querydata' width='25%'><b><%=(String)hashMap_detls.get("FATHER_RACE_DESC")%></b></td> 
			</tr>
			<tr>
			<td class='label'  width='25%'><fmt:message key="eMP.GovtEmployee.label" bundle="${mp_labels}"/> </td>
			<td class='querydata'width='25%' ><b><%=(String)hashMap_detls.get("FATHER_GOVE_EMPLOYEE_YN")%></b></td>
			<td class='label' width='25%'><fmt:message key="Common.religion.label" bundle="${common_labels}"/> </td>
			<td class='querydata' width='25%'><b><%=(String)hashMap_detls.get("RELGN_DESC")%></b></td>
			</tr>
			<tr>
			<td class='label'  width='25%'  ><fmt:message key="eMP.OccupationClass.label" bundle="${mp_labels}"/></td>
			<td class='querydata' width='25%'><b><%=(String)hashMap_detls.get("OCPN_CLASS_DESC")%></b></td>
			<td class='label' width='25%'><fmt:message key="eMP.occupation.label" bundle="${mp_labels}"/>  </td>
			<td class='querydata' width='25%'><%=(String)hashMap_detls.get("OCPN_DESC")%>&nbsp;<%=(String)hashMap_detls.get("FATHER_OCPN_DESC")%></td>
			</tr>
			 <tr>
					<td class='label'  width='25%'  ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
					<td class='querydata' width='75%' colspan=3><b><%=(String)hashMap_detls.get("FATHER_REMARKS")%></b></td>
					</tr>
			</tr>				
				</table>
				</td>
				</tr>
				</table>

			</div>
			</td></tr>
			<tr><td colspan=4>		
			<table id='nb_tab' width="100%" cellpadding='3' cellspacing=0 border=1 >	
				<tr><td colspan='4' class='COLUMNHEADER'><span id = 'newborn_dtls_link' onClick='javascript:expandCollapse("ND")'><input type='button' class='button' value='-' name='nb_button' id='nb_button'></span>&nbsp;<fmt:message key="eMP.newborndetails.label" bundle="${mp_labels}"/></td></tr>
			</table>
			<tr><td colspan=4>
			<div id='newborn_dtls'>
			<table width="100%" cellpadding='3' cellspacing=0 border=0 >	
			<tr>
					<td class='label' width='25%'><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
					<td class='querydata' width='75%' colspan=3><b><%=(String)hashMap_detls.get("NB_PATIENT_NAME")%></b></td>
			</tr>	
						<tr>
			<td colspan=6 align="left">
			<table border=0 cellpadding='1' cellspacing=0 width="100%" align="left">
			<tr>
			<%
			out.println("<td class='label'  width='15%'>&nbsp;");
			if(a1.equals("Y")){
				out.println(p1);
			}
			out.println("</td>");

			out.println("<td class='label'  width='15%'>&nbsp;");
			if(a2.equals("Y")){
				out.println(p2);
			}
			out.println("</td>");

			out.println("<td class='label'  width='15%'>&nbsp;");
			if(a3.equals("Y")){
				out.println(p3);
			}
			out.println("</td>");

			out.println("<td class='label'  width='15%'>&nbsp;");
			if(a4.equals("Y")){
				out.println(p4);
			}
			out.println("</td>");

			out.println("<td class='label'  width='15%'>&nbsp;");
			if(a5.equals("Y")){
				out.println(p5);
			}
			out.println("</td>");

			out.println("<td class='label'  width='15%'>&nbsp;");
			if(a6.equals("Y")){
				out.println(p6);
			}
			out.println("</td>");
				
			%>	
			
			</tr>
			<tr>
			
			<%
			out.println("<td class='querydata'  width='15%'>&nbsp;");
			if(a1.equals("Y")){
				out.println((String)hashMap_detls.get("NB_NAME_PREFIX"));
			}
			out.println("</td>");

			out.println("<td class='querydata'  width='15%'>&nbsp;");
			if(a2.equals("Y")){
				out.println((String)hashMap_detls.get("NB_FIRST_NAME"));
			}
			out.println("</td>");

			out.println("<td class='querydata'  width='15%'>&nbsp;");
			if(a3.equals("Y")){
				out.println((String)hashMap_detls.get("NB_SECOND_NAME"));
			}
			out.println("</td>");

			out.println("<td class='querydata'  width='15%'>&nbsp;");
			if(a4.equals("Y")){
				out.println((String)hashMap_detls.get("NB_THIRD_NAME"));
			}
			out.println("</td>");

			out.println("<td class='querydata'  width='15%'>&nbsp;");
			if(a5.equals("Y")){
				out.println((String)hashMap_detls.get("NB_FAMILY_NAME"));
			}
			out.println("</td>");

			out.println("<td class='querydata'  width='15%'>&nbsp;");
			if(a6.equals("Y")){
				out.println((String)hashMap_detls.get("NB_NAME_SUFFIX"));
			}
			out.println("</td>");

			%>
			</tr>
			<tr>
			
			<%
			if(oth1.equals("Y")){
				out.println("<td class='label'  width='15%'>&nbsp;");
				if(a1.equals("Y")){
					out.println(op1);
				}
				out.println("</td>");

				out.println("<td class='label'  width='15%'>&nbsp;");
				if(a2.equals("Y")){
					out.println(op2);
				}
				out.println("</td>");

				out.println("<td class='label'  width='15%'>&nbsp;");
				if(a3.equals("Y")){
					out.println(op3);
				}
				out.println("</td>");

				out.println("<td class='label'  width='15%'>&nbsp;");
				if(a4.equals("Y")){
					out.println(op4);
				}
				out.println("</td>");

				out.println("<td class='label'  width='15%'>&nbsp;");
				if(a5.equals("Y")){
					out.println(op5);
				}
				out.println("</td>");

				out.println("<td class='label'  width='15%'>&nbsp;");
				if(a6.equals("Y")){
					out.println(op6);
				}
				out.println("</td>");
			}
			%>
			</tr>
			<tr>
			<%
			if(oth1.equals("Y")){
				out.println("<td class='querydata'  width='15%'>&nbsp;");
				if(a1.equals("Y")){
					out.println((String)hashMap_detls.get("NB_NAME_PREFIX_LOC_LANG"));
				}
				out.println("</td>");

				out.println("<td class='querydata'  width='15%'>&nbsp;");
				if(a2.equals("Y")){
					out.println((String)hashMap_detls.get("NB_FIRST_NAME_LOC_LANG"));
				}
				out.println("</td>");

				out.println("<td class='querydata'  width='15%'>&nbsp;");
				if(a3.equals("Y")){
					out.println((String)hashMap_detls.get("NB_SECOND_NAME_LOC_LANG"));
				}
				out.println("</td>");

				out.println("<td class='querydata'  width='15%'>&nbsp;");
				if(a4.equals("Y")){
					out.println((String)hashMap_detls.get("NB_THIRD_NAME_LOC_LANG"));
				}
				out.println("</td>");

				out.println("<td class='querydata'  width='15%'>&nbsp;");
				if(a5.equals("Y")){
					out.println((String)hashMap_detls.get("NB_FAMILY_NAME_LOC_LANG"));
				}
				out.println("</td>");

				out.println("<td class='querydata'  width='15%'>&nbsp;");
				if(a6.equals("Y")){
					out.println((String)hashMap_detls.get("NB_NAME_SUFFIX_LOC_LANG"));
				}
				out.println("</td>");
				
				
			}
			%>
			</tr>
			</table>
			<tr>
			<!-- <td colspan=4> <table border=1 cellpadding='3' cellspacing=0 width="100%">
			<tr> -->
			<!-- Below line modified for this CRF MMS-QH-CRF-0145.1 [IN:047497] -->
			<td class='label'  width='18%'  ><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
			<td class='querydata' width='18%'><b><%=(String)hashMap_detls.get("NB_SEX")%></b></td>
			<td class='label' width='18%'><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/>  </td>
			<td class="label" width='46%' colspan='3'><b><%=(String)hashMap_detls.get("NB_BIRTH_DATE")%></b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eMP.Birth.label" bundle="${mp_labels}"/>&nbsp;<fmt:message key="Common.time.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;<b><%=(String)hashMap_detls.get("NB_BIRTH_TIME")%></b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%if(hijirisitespecifApplicable){%><fmt:message key="eMP.Hijri.label" bundle="${mp_labels}"/>&nbsp;&nbsp;&nbsp;<b><span id="hiji_date_display"><%=(String)hashMap_detls.get("hijri_birth_date")%></span></b><%}%></td>
			
			</tr>
			<!-- </table>
			</td>
			</tr> -->
			<tr>
			<td class="label"  width='25%'><fmt:message key="Common.bloodgroup.label" bundle="${common_labels}"/></td>
			<td class='querydata'  width='25%'><b><%=(String)hashMap_detls.get("NB_BLOOD_GRP")%></b></td>
			<td class="label"  width='25%' ><fmt:message key="eMR.RHDFactor.label" bundle="${mr_labels}"/></td>
			<td class='querydata'  width='25%'><b><%=(String)hashMap_detls.get("NB_RH_FACTOR")%></b></td>
			</tr>

				
				<tr>
			<td class="label"  width='25%'><fmt:message key="Common.relationship.label" bundle="${common_labels}"/></td>
			<td class='querydata'  width='25%'><b><%=(String)hashMap_detls.get("NB_RELATION_TO_HEAD")%></b></td>
			<td class="label"  width='25%' ><fmt:message key="Common.outcome.label" bundle="${common_labels}"/></td>
			<!-- <td class='querydata'  width='25%'><b><%=(String)hashMap_detls.get("OUTCOME")%></b> -->
			</td>
			<%
			String outcome1=	(String)hashMap_detls.get("OUTCOME");	
				if(outcome1.equals("Still Born"))
				{%>
					<td class='label'  width='10%' ><input type='button' class='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.StillBirthDtls.label","mp_labels")%>' name='still_birth_dtl' onClick='javascript:stillBirthWindowQuery()'></td>
				<%}else{ if(isLabelChangeApplicable){%>
				<td class='querydata'  width='25%'><b><fmt:message key="eMP.Alive.label" bundle="${mp_labels}"/></b></td> <!--Added by Rameswar on 23rd June 2015 against HSA-CRF-0223 IN050565 -->
				<%}else{%>
				<td class='querydata'  width='25%'><b><fmt:message key="eMP.Live.label" bundle="${mp_labels}"/></b></td>
				<%}}%>
			</tr>
            
			<tr>
			<td class="label"  width='25%'><fmt:message key="eMP.IndicatorMark.label" bundle="${mp_labels}"/></td>
			<td class='querydata'  width='25%'><b><%=(String)hashMap_detls.get("INDICATOR_MARK")%></b></td>
			<td class="label"   width='25%'><fmt:message key="eMP.BornWhere.label" bundle="${mp_labels}"/></td>			
			<% String born_where=(String)hashMap_detls.get("BORN_WHERE");			
			if(born_where.equals("In Facility")){%>
				<td class='querydata'  width='25%'><b><fmt:message key="eMP.InFacility.label" bundle="${mp_labels}"/></b></td>
			<%} else if(born_where.equals("Home")){	%>
				<td class='querydata'  width='25%'><b><fmt:message key="Common.home.label" bundle="${common_labels}"/></b></td>
            <%} else if(born_where.equals("Ambulance")){	%>
				<td class='querydata'  width='25%'><b><fmt:message key="eMP.Ambulance.label" bundle="${mp_labels}"/></b></td>
			<%}else if(born_where.equals("Other Mode of Transport")){%>
				<td class='querydata'  width='25%'><b><fmt:message key="eMP.OtherModesofTpt.label" bundle="${mp_labels}"/></b></td>
			<%}else if(born_where.equals("Born Before Arrival")){%>
				<td class='querydata'  width='25%'><b><fmt:message key="eMP.BornBeforeArrival.label" bundle="${mp_labels}"/></b></td>
				<%}else{%>
				<td class='querydata'  width='25%'><b>&nbsp;</b></td>
			<%}%>
			</tr>
			<tr>
			<td class="label"  width='25%'><fmt:message key="eMP.Bornat.label" bundle="${mp_labels}"/></td>			
			<% String born_at=(String)hashMap_detls.get("BORN_AT");			
			if(born_at.equals("Clinic")){%>
				<td class='querydata'  width='25%'><b><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></b></td>
			<%} else if(born_at.equals("Nursing Unit")){	%>
				<td class='querydata'  width='25%'><b><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></b></td>
            <%} else if(born_at.equals("DayCare Unit")){	%>
				<td class='querydata'  width='25%'><b><fmt:message key="Common.DaycareUnit.label" bundle="${common_labels}"/></b></td>
			<%}else if(born_at.equals("Emergency")){%>
				<td class='querydata'  width='25%'><b><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></b></td>
			<%}
			/*Added by Ashwini on 27-Jun-2018 for ML-MMOH-CRF-0833*/
			else if(born_at.equals("OT Specific")){%>
				<td class='querydata'  width='25%'><b><fmt:message key="eOP.OTSpecific.label" bundle="${op_labels}"/></b></td>
			<%}else if(born_at.equals("Procedure Unit")){%>
				<td class='querydata'  width='25%'><b><fmt:message key="Common.ProcedureUnit.label" bundle="${common_labels}"/></b></td>
			<%}else if(born_at.equals("Radiology Wing")){%>
				<td class='querydata'  width='25%'><b><fmt:message key="Common.RadiologyWing.label" bundle="${common_labels}"/></b></td>
			<%}else if(born_at.equals("Room")){%>
				<td class='querydata'  width='25%'><b><fmt:message key="Common.room.label" bundle="${common_labels}"/></b></td>
			<%}else{%>
				<td class='querydata'  width='25%'><b>&nbsp;</b></td>
			<%}%>


			<td class="label"   width='25%'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
			<td class='querydata'  width='25%'><b><%=(String)hashMap_detls.get("ANT_CARE_LOCN_DESC")%></b></td>
			</tr>
			<tr>
			<td class="label"  width='25%'><fmt:message key="Common.birthPlace.label" bundle="${common_labels}"/></td>
			<td class='querydata'  width='25%'><b><%=(String)hashMap_detls.get("BIRTH_PLACE_DESC")%></b></td>
			<td class="label"  width='25%'><fmt:message key="eMP.BirthCertificateNo.label" bundle="${mp_labels}"/></td>
			<td class='querydata'  width='25%'><b><%=(String)hashMap_detls.get("BIRTH_CERTIFICATE_NO")%></b></td>
			</tr>
			<tr>
			<td class="label"  width='25%'><fmt:message key="eMP.BirthWeight.label" bundle="${mp_labels}"/></td>
			<td class='querydata'  width='25%'><b><%=(String)hashMap_detls.get("WEIGHT")%></b><%=(String)hashMap_param.get("UNIT_OF_WT_NB")%></td>
			<td class="label"  width='25%'><fmt:message key="eMP.LengthofBaby.label" bundle="${mp_labels}"/></td>
			<td class='querydata'  width='25%'><b><%=(String)hashMap_detls.get("LENGTH")%></b><%=(String)hashMap_param.get("UNIT_OF_LENGTH_NB")%></td>
			</tr>
					<tr>
			<td class="label"  width='25%'><fmt:message key="Common.HeadCircumference.label" bundle="${common_labels}"/></td>
			<td class='querydata'  width='25%'><b><%=(String)hashMap_detls.get("HEAD_CIRCUMFERENCE")%></b><%=(String)hashMap_param.get("UNIT_OF_CIRCUM_NB")%></td>
			<td class="label"  width='25%'><fmt:message key="eMP.ChestCirumference.label" bundle="${mp_labels}"/></td>
			<td class='querydata' width='25%'><b><%=(String)hashMap_detls.get("CHEST_CIRCUMFERENCE")%></b><%=(String)hashMap_param.get("UNIT_OF_CHEST_CIRCUM_NB")%></td>
			</tr>
			<!-- <tr>
			<td colspan=4>
			<table border=0 cellpadding='3' cellspacing=0 width="100%"> -->
			<tr>
			<td class="label" ><fmt:message key="Common.ApgarScore.label" bundle="${common_labels}"/><span id = 'apgar_dtls_link' ><input type='button' class='button' value="+" name="apgar_dtls_name" id="apgar_dtls_name" onClick='javascript:apgarLink(this)'></span></td>
			<td class='querydata' ><b><%=(String)hashMap_detls.get("APGAR_SCORE_IN_1_MIN")%></b><!-- </td>
				
			<td class="label"> --><span class='label'>&nbsp;&nbsp;<fmt:message key="eMP.in1Min.label" bundle="${mp_labels}"/></span></td>
				
			<td class='querydata' ><b>&nbsp;<%=(String)hashMap_detls.get("APGAR_SCORE_IN_5_MINS")%></b><!-- </td>
				
			<td class="label"> --><span class='label'>&nbsp;&nbsp;<fmt:message key="eMP.in5Min.label" bundle="${mp_labels}"/></span></td>
				
			<td class='querydata' ><b><%=(String)hashMap_detls.get("APGAR_SCORE_IN_10_MINS")%></b><!-- </td>
				
			<td class="label"> --><span class='label'>&nbsp;&nbsp;<fmt:message key="eMP.in10Min.label" bundle="${mp_labels}"/></span></td>			
			</tr>
			<tbody id='apgarDivID' style="visibility:hidden;display:none">
			<tr>
			<td class="label" width='25%'><fmt:message key="eMP.Activity.label" bundle="${mp_labels}"/></td>
			<td class='querydata' width='25%'><b><%=(String)hashMap_detls.get("ACTIVITY_IN_1_MIN")%></b></td>
			<td class='querydata' width='25%'><b>&nbsp;<%=(String)hashMap_detls.get("ACTIVITY_IN_5_MIN")%></b></td>
			<td class='querydata' width='25%'><b><%=(String)hashMap_detls.get("ACTIVITY_IN_10_MIN")%></b></td>
			</tr>
			<tr>
			<td class="label" width='25%'><fmt:message key="eMP.Pulse.label" bundle="${mp_labels}"/></td>
			<td class='querydata' width='25%'><b><%=(String)hashMap_detls.get("HEART_RATE_IN_1_MIN")%></b></td>
			<td class='querydata' width='25%'><b>&nbsp;<%=(String)hashMap_detls.get("HEART_RATE_IN_5_MIN")%></b></td>
			<td class='querydata' width='25%'><b><%=(String)hashMap_detls.get("HEART_RATE_IN_10_MIN")%></b></td>
			</tr>
			<tr>
			<td class="label" width='25%'><fmt:message key="eMP.Grimace.label" bundle="${mp_labels}"/></td>
			<td class='querydata' width='25%' ><b><%=(String)hashMap_detls.get("GRIMACE_IN_1_MIN")%></b></td>
			<td class='querydata' width='25%' ><b>&nbsp;<%=(String)hashMap_detls.get("GRIMACE_IN_5_MIN")%></b></td>
			<td class='querydata' width='25%'><b><%=(String)hashMap_detls.get("GRIMACE_IN_10_MIN")%></b></td>
			</tr>
			<tr>
			<td class="label" width='25%'><fmt:message key="eMP.Appearance.label" bundle="${mp_labels}"/></td>
			<td class='querydata' width='25%'><b><%=(String)hashMap_detls.get("APPEARANCE_IN_1_MIN")%></b></td>
			<td class='querydata' width='25%'><b>&nbsp;<%=(String)hashMap_detls.get("APPEARANCE_IN_5_MIN")%></b></td>
			<td class='querydata' width='25%'><b><%=(String)hashMap_detls.get("APPEARANCE_IN_10_MIN")%></b></td>
			</tr>
			<tr>
			<td class="label" width='25%'><fmt:message key="eMP.Respiration.label" bundle="${mp_labels}"/></td>
			<td class='querydata' width='25%'><b><%=(String)hashMap_detls.get("BREATHING_IN_1_MIN")%></b></td>
			<td class='querydata' width='25%'><b>&nbsp;<%=(String)hashMap_detls.get("BREATHING_IN_5_MIN")%></b></td>
			<td class='querydata' width='25%'><b><%=(String)hashMap_detls.get("BREATHING_IN_10_MIN")%></b></td>				
			</tr>
			</tbody>
			<tr>
			<td class="label"  width='25%'><fmt:message key="eMP.UmbilicalCord.label" bundle="${mp_labels}"/></td>
			<% String umbilical_cord_status=(String)hashMap_detls.get("UMBILICAL_CORD_STATUS");
			if(umbilical_cord_status.equals("Normal")){%>
				<td class='querydata'  width='25%'><b><fmt:message key="Common.Normal.label" bundle="${common_labels}"/></b></td>
			<%} else if(umbilical_cord_status.equals("Stump")){	%>
				<td class='querydata'  width='25%'><b><fmt:message key="eMP.Stump.label" bundle="${mp_labels}"/></b></td>
            <%} else if(umbilical_cord_status.equals("Other")){	%>
				<td class='querydata'  width='25%'><b><fmt:message key="Common.other.label" bundle="${common_labels}"/></b></td>
			<%}else{%>
				<td class='querydata'  width='25%'><b>&nbsp;</b></td>
			<%}%>
			
			<td class="label"  width='25%'><fmt:message key="eMP.UmbCordCutBy.label" bundle="${mp_labels}"/></td>
			<td class='querydata'  width='25%' nowrap><b><%=(String)hashMap_detls.get("UMB_CORD_CUT_BY")%></b></td>
			</tr>
				<tr>
			<td class="label"  width='25%'><fmt:message key="eMP.Feeding.label" bundle="${mp_labels}"/></td>
			<%String feeding = (String)hashMap_detls.get("FEEDING");
			if(feeding.equals("T")){%>
				<td class='querydata'  width='25%'><b><fmt:message key="eMP.Breast.label" bundle="${mp_labels}"/></b></td>
			<%} else if(feeding.equals("B")){	%>
				<td class='querydata'  width='25%'><b><fmt:message key="eMP.Bottle.label" bundle="${mp_labels}"/></b></td>
            <%} else if(feeding.equals("O")){	%>
				<td class='querydata'  width='25%'><b><fmt:message key="Common.other.label" bundle="${common_labels}"/></b></td>
			<%}else{%>
			<td class='querydata'  width='25%'><b>&nbsp;</b></td>
			<%}%>

			<td class="label"  width='25%'><fmt:message key="eMP.PatencyofAnus.label" bundle="${mp_labels}"/></td>			
			<%String patency_of_anus_yn = (String)hashMap_detls.get("PATENCY_OF_ANUS_YN");			
			if(patency_of_anus_yn.equals("Patent")){%>
				<td class='querydata'  width='25%'><b><fmt:message key="eMP.Patent.label" bundle="${mp_labels}"/></b></td>
			<%} else if(patency_of_anus_yn.equals("Not Patent")){	%>
				<td class='querydata'  width='25%'><b><fmt:message key="eMP.NotPatent.label" bundle="${mp_labels}"/></b></td>            
			<%}else{%>
				<td class='querydata'  width='25%'><b>&nbsp;</b></td>
			<%}%>
			</tr>
				<tr>
			<td class="label"  width='25%'><fmt:message key="eMP.CongenitalAnomalies.label" bundle="${mp_labels}"/></td>
			<td class='querydata'  width='25%' style='word-wrap:break-word;width:300px;'><b><%=(String)hashMap_detls.get("CONG_ANOMALIES_LONG_DESC")%></b></td>
			<!--Added by Rameswar on 20-Jan-16 for ML-MMOH-CRF-0382-->
			<td class="label"  width='25%'><fmt:message key="eMP.PatencyofAnusCheckedBy.label" bundle="${mp_labels}"/></td>
			<td class='querydata'  width='25%' nowrap><b><%=(String)hashMap_detls.get("PATENCY_OF_ANUS_CHECKED_BY")%></b></td> 
			<!--Added by Rameswar on 20-Jan-16 for ML-MMOH-CRF-0382-->
			</tr>

				<tr>
			<td class="label"  width='25%'><fmt:message key="eMP.Stools.label" bundle="${mp_labels}"/></td>
			<%String stools = (String)hashMap_detls.get("STOOLS");
			if(stools.equals("M")){%>
				<td class='querydata'  width='25%'><b><fmt:message key="eMP.Meconium.label" bundle="${mp_labels}"/></b></td>
			<%} else if(stools.equals("Y")){	%>
				<td class='querydata'  width='25%'><b><fmt:message key="eMP.YellowSoft.label" bundle="${mp_labels}"/></b></td>
            <%} else if(stools.equals("O")){	%>
				<td class='querydata'  width='25%'><b><fmt:message key="Common.other.label" bundle="${common_labels}"/></b></td>
			<%}else{%><td></td><%}%>
			<td class="label"  width='25%'><fmt:message key="eMP.FetusCompofDelivery.label" bundle="${mp_labels}"/></td>
			<!--Modified by Ashwini on 01-Feb-2019 for ML-MMOH-CRF-1109-->
			<td class='querydata'  width='25%' style='word-wrap:break-word;width:300px;'><b><%=(String)hashMap_detls.get("NB_COMPLN_DEL_LONG_DESC")%></b></td>
			</tr>
			  <%/*Below line added for this CRF ML-MMOH-CRF-0621*/
			  if(isRegNewbornApplicable){%>
				<tr>
				<td class="label"  width='25%'><fmt:message key="eMP.Resuscitated.label" bundle="${mp_labels}"/></td>			
				<td class='querydata'  width='25%'><b><%=(String)hashMap_detls.get("resuscitated_pract_desc")%></b></td>			
			<td class="label"  width='25%'>&nbsp;</td>
			<td class='querydata'  width='25%'>&nbsp;</td>
			</tr>
			<%}%>
			</table>
			</td></tr> 

			<tr><td colspan=4>		
			<table id='vcc_tab' width="100%" cellpadding='3' cellspacing=0 border=0 >	
				<tr><td colspan='4' class='COLUMNHEADER'><span id = 'vaccin_dtls_link' onClick='javascript:expandCollapse("VD")'><input type='button' class='button' value='-' name='vacc_button' id='vacc_button'></span>&nbsp<fmt:message key="eMP.vaccinationdetails.label" bundle="${mp_labels}"/></td></tr>
			</table>
			<div>
			<tr><td colspan=4>
			<div id='vaccin_dtls'>
			<table width="100%" cellpadding='3' cellspacing=0 border=0 >	
			<tr>
				<td class='label'   width='15%'></td>
				<td class='label'   width='5%'></td>
				<td class='label'   width='20%'><fmt:message key="eMP.VaccSite.label" bundle="${mp_labels}"/></td>
				<td class='label'   width='20%'><fmt:message key="Common.AdministeredBy.label" bundle="${common_labels}"/></td>
				<td class='label'   width='20%'><fmt:message key="Common.designation.label" bundle="${common_labels}"/></td>
				<td class='label'  width='20%'><fmt:message key="Common.AdmissionDateTime.label" bundle="${common_labels}"/></td>
			</tr>
			<tr>
					<td class='label'     width='15%'><fmt:message key="eMP.BCG.label" bundle="${mp_labels}"/></td>
					<td class='querydata'  width='5%'><b><%=(String)hashMap_detls.get("BCG_YN")%></b></td>
					<td class='querydata'  width='20%'><b><%=(String)hashMap_detls.get("VACCINATION_SITE")%></b></td>
					<td class='querydata'  width='20%'><b><%=(String)hashMap_detls.get("ADMINISTERED_BY")%></b></td>
					<td class='querydata'  width='20%'><b><%=(String)hashMap_detls.get("ADMINISTERED_DESIGNATION")%></b></td>
					<td class='querydata'  width='20%'><b><%=(String)hashMap_detls.get("BCG_VACC_ADMN_DATE")%></b></td>
			</tr>
				<tr>
					<td class='label'      width='15%'><fmt:message key="eMP.VitaminK.label" bundle="${mp_labels}"/></td>
					<td class='querydata'  width='5%'><b><%=(String)hashMap_detls.get("VITK_N_HEPB_GIVEN_YN")%></b></td>
					<td class='querydata'  width='20%'><b><%=(String)hashMap_detls.get("VITAK_VACC_SITE")%></b></td>
					<td class='querydata'  width='20%'><b><%=(String)hashMap_detls.get("VITAK_ADMINISTERED_BY")%></b></td>
					<td class='querydata'  width='20%'><b><%=(String)hashMap_detls.get("VITAK_ADMINISTERED_DESIG")%></b></td>
					<td class='querydata'  width='20%'><b><%=(String)hashMap_detls.get("VITK_VACC_ADMN_DATE")%></b></td>

			<tr>
					<td class='label'  width='15%'><fmt:message key="eMP.HepatitisB.label" bundle="${mp_labels}"/></td>
					<td class='querydata' width='5%'><b><%=(String)hashMap_detls.get("HEPB_YN")%></b></td>
					<td class='querydata'  width='20%'><b><%=(String)hashMap_detls.get("HEPB_VACC_SITE")%></b></td>
					<td class='querydata'  width='20%'><b><%=(String)hashMap_detls.get("HEPB_ADMINISTERED_BY")%></b></td>
					<td class='querydata'  width='20%'><b><%=(String)hashMap_detls.get("HEPB_ADMINISTERED_DESIG")%></b></td>
				<td class='querydata'  width='20%'><b><%=(String)hashMap_detls.get("HEPB_VACC_ADMN_DATE")%></b></td>
			</tr>
			</table>
			</div>
			</td>
			</tr>
			</table>
			</div>
			</td></tr>
			</table>
	    <input type='hidden' name='patient_id' id='patient_id' value="<%=patient_id%>">
		
<!--Added for MMS-QH-CRF-0145.1-->
<script>		
if(<%=hijirisitespecifApplicable%>&&'<%=hijri_birth_date%>'==""){ 
var hijDay=convertToHij('<%=Date_Of_Birth%>'); 
document.getElementById('hiji_date_display').innerHTML=hijDay;
}
if("<%=isRegNewbornApplicable%>"=="true" && document.getElementById('father_dtls_link')!=null){
	     document.getElementById('father_dtls_link').onclick();          
	}
</script>
<!--MMS-QH-CRF-0145.1 -->
      </form>
	</body>
</html>
		<%
	}else{
				out.println("<script>alert(getMessage('BIRTH_REG_NOT_APPLICABLE','MP'));</script>");
	}
	}
	catch(Exception e)
	{
		out.println("Exception in main"+e);
		e.printStackTrace();
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	} 
%>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}

	public static String checkForNull1(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null")) || (inputString.equals(""))) ? defaultValue : inputString);
	}
%>

