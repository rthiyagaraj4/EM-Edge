/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMP;

import java.io.*;
import java.util.*;
import java.sql.*;
import com.ehis.util.*;

public class PatEncBannerReplacementBean implements java.io.Serializable
{

	HashMap mpPatientValues = new HashMap();

	//String sqlPatBanner = " select a. PATIENT_ID pat_id,a.patient_name pat_name, a.PATIENT_NAME_LOC_LANG pat_name_loc_lang, MP_GET_AGE_YMDH(a.date_of_birth,a.DECEASED_DATE) age, a.calculated_age_yn estd, a. ALT_ID1_NO alt_id, a. CODED_PSEUDO_NAME, mp_get_desc.MP_COUNTRY(a. NATIONALITY_CODE,?,3) nationality, a. NATIONAL_ID_NO nat_id, mp_Get_desc.Mp_pat_category(a.PAT_CAT_CODE,?,1) pat_categ, a.sex gender, (case when a.FAMILY_ORG_SUB_ID is not null then ( select FAMILY_ORG_SUB_NAME from MP_FAMILY_ORG_SUB_LANG_VW where FAMILY_ORG_ID = a.FAMILY_ORG_ID and FAMILY_ORG_SUB_ID = a.FAMILY_ORG_SUB_ID and language_id = ? ) end) Orgsubname, (case when a.FAMILY_ORG_ID is not null then ( select FAMILY_ORG_NAME from MP_FAMILY_ORG_LANG_VW where FAMILY_ORG_ID = a.FAMILY_ORG_ID and language_id = ? ) end) Orgname, nvl(c.ocpn_desc,mp_get_desc.MP_OCCUPATION(c.OCPN_CODE,?,2)) occupation, a.DECEASED_YN, a.SUSPEND_YN, a.ACTIVE_YN, DECODE(b.GOVT_OR_PVT_IND,'V','Y','N') VIP_YN,to_char(a.date_of_birth, 'dd/mm/yyyy') date_of_birth,a.eye_indicator, d.general_remarks,DECODE (TO_CHAR (a.date_of_birth, 'dd/mm'),TO_CHAR (SYSDATE, 'dd/mm'), 'BirthDay','') birth_day,DECODE (TO_CHAR (a.date_of_birth, 'dd/mm'), TO_CHAR (SYSDATE + 1, 'dd/mm'), 'BirthDay','') day_before_birthday from mp_patient a, MP_PAT_CATEGORY b,  MP_PAT_REL_CONTACTS c ,mp_pat_oth_dtls d where a.patient_id = ? and a.patient_id = c.patient_id and c.patient_id = d.patient_id and a.PAT_CAT_CODE = b.PAT_CAT_CODE(+) ";	
	/*35638	PMG2012-CRF-0009.1	Patient Banner to be displayed for external patients  below is modified by sudhakar*/
	String sqlPatBanner = " select a. PATIENT_ID pat_id,a.patient_name pat_name, a.PATIENT_NAME_LOC_LANG pat_name_loc_lang, MP_GET_AGE_YMDH(a.date_of_birth,a.DECEASED_DATE) age, a.calculated_age_yn estd, a. ALT_ID1_NO alt_id, a. CODED_PSEUDO_NAME, mp_get_desc.MP_COUNTRY(a. NATIONALITY_CODE,?,3) nationality, a. NATIONAL_ID_NO nat_id, mp_Get_desc.Mp_pat_category(a.PAT_CAT_CODE,?,1) pat_categ, a.myhix_id,a.sex gender, (case when a.FAMILY_ORG_SUB_ID is not null then ( select FAMILY_ORG_SUB_NAME from MP_FAMILY_ORG_SUB_LANG_VW where FAMILY_ORG_ID = a.FAMILY_ORG_ID and FAMILY_ORG_SUB_ID = a.FAMILY_ORG_SUB_ID and language_id = ? ) end) Orgsubname, (case when a.FAMILY_ORG_ID is not null then ( select FAMILY_ORG_NAME from MP_FAMILY_ORG_LANG_VW where FAMILY_ORG_ID = a.FAMILY_ORG_ID and language_id = ? ) end) Orgname, nvl(c.ocpn_desc,mp_get_desc.MP_OCCUPATION(c.OCPN_CODE,?,2)) occupation, a.DECEASED_YN, a.SUSPEND_YN, a.ACTIVE_YN, DECODE(b.GOVT_OR_PVT_IND,'V','Y','N') VIP_YN,to_char(a.date_of_birth, 'dd/mm/yyyy') date_of_birth,a.eye_indicator, d.general_remarks,DECODE (TO_CHAR (a.date_of_birth, 'dd/mm'),TO_CHAR (SYSDATE, 'dd/mm'), 'BirthDay','') birth_day,DECODE (TO_CHAR (a.date_of_birth, 'dd/mm'), TO_CHAR (SYSDATE + 1, 'dd/mm'), 'BirthDay','') day_before_birthday, a.mlc_yn from mp_all_patients_vw a, MP_PAT_CATEGORY b,  mp_all_pat_rel_contacts_vw c ,mp_all_pat_oth_dtls_vw d where a.patient_id = ? and a.patient_id = c.patient_id and c.patient_id = d.patient_id and a.PAT_CAT_CODE = b.PAT_CAT_CODE(+) ";

	 /*Below query was modified by venkatesh.S to get PATIENT_CLASS and room_desc on 16-Nov-2012 against SS-CRF-010*/
		String sqlEncCntxBanner = "select a.PATIENT_ID pat_id,b.PATIENT_CLASS,a.patient_name pat_name, a.PATIENT_NAME_LOC_LANG pat_name_loc_lang, MP_GET_AGE_YMDH(a.date_of_birth,a.DECEASED_DATE) age, a.calculated_age_yn estd, a. ALT_ID1_NO alt_id, a. CODED_PSEUDO_NAME, mp_get_desc.MP_COUNTRY(a.NATIONALITY_CODE,?,3) nationality, a. NATIONAL_ID_NO nat_id, mp_Get_desc.Mp_pat_category(a.PAT_CAT_CODE,?,1) pat_categ, a.sex gender, (case when a.FAMILY_ORG_SUB_ID is not null then ( select FAMILY_ORG_SUB_NAME from MP_FAMILY_ORG_SUB_LANG_VW where FAMILY_ORG_ID = a.FAMILY_ORG_ID and FAMILY_ORG_SUB_ID = a.FAMILY_ORG_SUB_ID and language_id = ? ) end) Orgsubname, (case when a.FAMILY_ORG_ID is not null then ( select FAMILY_ORG_NAME from MP_FAMILY_ORG_LANG_VW where FAMILY_ORG_ID = a.FAMILY_ORG_ID and language_id = ? ) end) Orgname, nvl(c.ocpn_desc,mp_get_desc.MP_OCCUPATION(c.OCPN_CODE,?,2)) occupation ,b.ENCOUNTER_ID enc_id,  am_get_desc.am_practitioner(b.ATTEND_PRACTITIONER_ID,?,1) attend_pract_id, case when b.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(facility_id,b.ASSIGN_CARE_LOCN_CODE,?,1) else op_get_desc.OP_CLINIC(facility_id,b.ASSIGN_CARE_LOCN_CODE,?,1) end locn, b.ASSIGN_ROOM_NUM room_num,am_get_desc.am_facility_room(?,b.assign_room_num,?,2) room_desc ,b.ASSIGN_BED_NUM bed_num, am_get_desc.am_speciality(b.SPECIALTY_CODE,?,2) splty, a.patient_id, a.DECEASED_YN, a.SUSPEND_YN, a.ACTIVE_YN, DECODE(d.GOVT_OR_PVT_IND,'V','Y','N') VIP_YN, B.EPISODE_ID BL_EPISODE_ID, B.OP_EPISODE_VISIT_NUM BL_OP_EPISODE_VISIT_NUM, (select operational_yn from sm_modules_facility where facility_id = ? and module_id = 'CP') cp_operational_yn,to_char(a.date_of_birth, 'dd/mm/yyyy') date_of_birth , a.eye_indicator, e.general_remarks,DECODE (TO_CHAR (a.date_of_birth, 'dd/mm'),TO_CHAR (SYSDATE, 'dd/mm'), 'BirthDay','') birth_day,DECODE (TO_CHAR (a.date_of_birth, 'dd/mm'), TO_CHAR (SYSDATE + 1, 'dd/mm'), 'BirthDay','') day_before_birthday, (select queue_num from op_patient_queue where encounter_id = ? and facility_id = ? and queue_status <='04' ) queue_no,TO_CHAR (b.visit_adm_date_time, 'dd/mm/yyyy hh24:mi') admit_date,(SELECT CASE WHEN x.DISCHARGE_DATE_TIME IS NULL THEN  CALCULATE_DIFF_BTWN_TWO_DATES(sysdate,x.visit_adm_date_time,'DHM') ELSE  CALCULATE_DIFF_BTWN_TWO_DATES(x.discharge_date_time,x.visit_adm_date_time,'DHM') END lengthofstay FROM pr_encounter x where x.patient_class='IP' and x.encounter_id=b.encounter_id and x.facility_id=b.facility_id) lengthofstay,am_get_desc.am_practitioner (b.admit_practitioner_id,?,1) admitting_pract,b.assign_care_locn_code P_LOCN_CODE,b.assign_care_locn_type P_LOCN_TYPE,b.OP_EPISODE_VISIT_NUM P_VISIT_ID, b.EPISODE_ID P_EPISODE_ID,b.attend_practitioner_id P_PHYSICIAN_ID,b.PATIENT_CLASS P_EPISODE_TYPE from mp_patient a, PR_ENCOUNTER B, MP_PAT_REL_CONTACTS c, MP_PAT_CATEGORY d , mp_pat_oth_dtls e where B.ENCOUNTER_ID = ? and b.facility_id = ? and a.patient_id = c.patient_id AND B.PATIENT_ID = A.PATIENT_ID and c.patient_id = e.patient_id and a.PAT_CAT_CODE = d.PAT_CAT_CODE(+) "; 	

		String sqlPatStatus = "SELECT SHORT_DESC FROM CP_DEPENDENCY_LANG WHERE LANGUAGE_ID = ? AND DEPENDENCY_CODE=(SELECT UA_DEPENDENCY_CODE FROM CP_PAT_ASSESS WHERE ASSESS_REF_NO=(SELECT MAX(ASSESS_REF_NO) FROM CP_PAT_ASSESS WHERE FACILITY_ID = ? AND ENCOUNTER_ID = ? ))";

		String  bannerStr="select * from MP_PAT_BANNER_DTL where banner_categ=?";



	public HashMap putToHash(Connection con,String applCateg, String patientId, String encounterId, String facilityId, String localeName)
	{
		
		//PreparedStatement pstmt_pat_status = null;
		PreparedStatement pstmt = null,banDtlPstmt=null;
		ResultSet banDtlRs;
		ResultSet res = null;
		HashMap mapValues = new HashMap();
		
	//	HashMap PatBannerMap = new HashMap();
		String cp_operational_yn = "N";

		localeName = (localeName == null || localeName.equals(""))?"en":localeName;
		java.util.Locale loc = new java.util.Locale(localeName);

		java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);

		java.util.ResourceBundle mp_labels = java.util.ResourceBundle.getBundle( "eMP.resources.Labels",loc);

		String patName = "";
		String patNameInLocLang = "";
		String patAge = "";
		String date_of_birth = "";
		String age_value = "";
		String altId = "";
		String nationality = "";
		String nationalityId = "";
		String patCateg = "";
		String gender = "";
		String Orgsubname = "";
		String Orgname = "";
		String orgSubOrgName = "";
		String patCccupation = "";
		String attendPract = "";
		String location = "";
		String roomNum = "";
		String room_desc="";
		String bedNum = "";
		String spltyCode = "";
		String locnRoomBed = "";
		String patientStatus = "";
		String  EstimatedAge= "";
		String unique_no="";

		String deceasedYN = "";
		String eye_indicator = "";
		 
		String general_remarks = "";
		String Day_before_BirthDay = "";
		String queue_no = "";
		String Birth_day = "";
		String activeYN = "";
		String suspended = "";
		String vipYN = "";
		String bl_episode_id = "";
		String bl_episode_visit_num = "";
		String pat_id = "";

		int PATIENT_NAME=0;
		int PATIENT_ID=0;
		int ALTERNATE_ID=0;
		int PAT_NAME_LOCAL_LANG=0;
		int AGE=0;
		int GENDER=0;
		int NATIONALITY_ID=0;
		int NATIONALITY=0;
		int OCCUPATION=0;
		int COMPANY=0;
		int PAT_CATEGORY=0;
		int ATTENDING_PRACT=0;
		int dateofbirth=0;
		int queueNoLen=0;
		String DISPLAY_LENGTH=null;
		int ADMIT_PRACT=0;
		int ADMIT_DATE=0;
		int UNIQUE_NO=0;
		
		int LENGTH_OF_STAY=0; //this line added for this CRF  Bru-HIMS-CRF-411 [IN:045316]
		String lengthofstay=""; //this line added for this CRF  Bru-HIMS-CRF-411 [IN:045316]
		String TOOL_TIP_TEXT=""; 
		
		String admitPract = "";
		String admitDate = "";
		
		//Below line added for this CRF ML-MMOH-CRF-0780
		String NEXT_OF_KIN_TOOLTIP = "";

		String MLC_YN = ""; //Added for ML-MMOH-CRF-1954 by Ajay Hatwate
		Boolean isMlcApplicable = eCommon.Common.CommonBean.isSiteSpecific(con,"MP","MARK_PATIENT_MLC");//SiteSpecific added for ML-MMOH-CRF-1954 by Ajay Hatwate
		
		
		try
		{ 
			if(applCateg.equals("P"))
			{
								
				
				pstmt = con.prepareStatement(sqlPatBanner);
				pstmt.setString(1,localeName);
				pstmt.setString(2,localeName);
				pstmt.setString(3,localeName);
				pstmt.setString(4,localeName);
				pstmt.setString(5,localeName);
				pstmt.setString(6,patientId);				
			}
			else
			{
			     
				
				pstmt = con.prepareStatement(sqlEncCntxBanner);
				pstmt.setString(1,localeName);
				pstmt.setString(2,localeName);
				pstmt.setString(3,localeName);
				pstmt.setString(4,localeName);
				pstmt.setString(5,localeName);
				pstmt.setString(6,localeName);
				pstmt.setString(7,localeName);
				pstmt.setString(8,localeName);
                pstmt.setString(9,facilityId);
                pstmt.setString(10,localeName);
				pstmt.setString(11,localeName);
				pstmt.setString(12,facilityId);      
				pstmt.setString(13,encounterId);				
				pstmt.setString(14,facilityId);
				pstmt.setString(15,localeName);				
				pstmt.setString(16,encounterId);				
				pstmt.setString(17,facilityId);			
				 
			}			

			banDtlPstmt=con.prepareStatement(bannerStr);
			banDtlPstmt.setString(1,applCateg);
			banDtlRs=banDtlPstmt.executeQuery();
			while(banDtlRs!=null && banDtlRs.next()){
				if(banDtlRs.getString("ELMT_REF").equals("PATIENT_NAME")){
					DISPLAY_LENGTH=banDtlRs.getString("DISPLAY_LENGTH")==null?"0":banDtlRs.getString("DISPLAY_LENGTH");
					PATIENT_NAME=Integer.parseInt(DISPLAY_LENGTH);		
				}else if(banDtlRs.getString("ELMT_REF").equals("PATIENT_ID")){
					DISPLAY_LENGTH=banDtlRs.getString("DISPLAY_LENGTH")==null?"0":banDtlRs.getString("DISPLAY_LENGTH");
					PATIENT_ID=Integer.parseInt(DISPLAY_LENGTH);
				}else if(banDtlRs.getString("ELMT_REF").equals("ALTERNATE_ID")){
					DISPLAY_LENGTH=banDtlRs.getString("DISPLAY_LENGTH")==null?"0":banDtlRs.getString("DISPLAY_LENGTH");
					ALTERNATE_ID=Integer.parseInt(DISPLAY_LENGTH);
				}else if(banDtlRs.getString("ELMT_REF").equals("PAT_NAME_LOCAL_LANG")){
					DISPLAY_LENGTH=banDtlRs.getString("DISPLAY_LENGTH")==null?"0":banDtlRs.getString("DISPLAY_LENGTH");
					PAT_NAME_LOCAL_LANG=Integer.parseInt(DISPLAY_LENGTH);
				}else if(banDtlRs.getString("ELMT_REF").equals("AGE")){
					DISPLAY_LENGTH=banDtlRs.getString("DISPLAY_LENGTH")==null?"0":banDtlRs.getString("DISPLAY_LENGTH");
					AGE=Integer.parseInt(DISPLAY_LENGTH);
				}else if(banDtlRs.getString("ELMT_REF").equals("GENDER")){
					DISPLAY_LENGTH=banDtlRs.getString("DISPLAY_LENGTH")==null?"0":banDtlRs.getString("DISPLAY_LENGTH");
					GENDER=Integer.parseInt(DISPLAY_LENGTH);
				}else if(banDtlRs.getString("ELMT_REF").equals("NATIONALITY_ID")){
					DISPLAY_LENGTH=banDtlRs.getString("DISPLAY_LENGTH")==null?"0":banDtlRs.getString("DISPLAY_LENGTH");
					NATIONALITY_ID=Integer.parseInt(DISPLAY_LENGTH);
				}else if(banDtlRs.getString("ELMT_REF").equals("NATIONALITY")){
					DISPLAY_LENGTH=banDtlRs.getString("DISPLAY_LENGTH")==null?"0":banDtlRs.getString("DISPLAY_LENGTH");
					NATIONALITY=Integer.parseInt(DISPLAY_LENGTH);
				}else if(banDtlRs.getString("ELMT_REF").equals("OCCUPATION")){
					DISPLAY_LENGTH=banDtlRs.getString("DISPLAY_LENGTH")==null?"0":banDtlRs.getString("DISPLAY_LENGTH");
					OCCUPATION=Integer.parseInt(DISPLAY_LENGTH);
				}else if(banDtlRs.getString("ELMT_REF").equals("COMPANY")){
					DISPLAY_LENGTH=banDtlRs.getString("DISPLAY_LENGTH")==null?"0":banDtlRs.getString("DISPLAY_LENGTH");
					COMPANY=Integer.parseInt(DISPLAY_LENGTH);
				}else if(banDtlRs.getString("ELMT_REF").equals("PAT_CATEGORY")){
					DISPLAY_LENGTH=banDtlRs.getString("DISPLAY_LENGTH")==null?"0":banDtlRs.getString("DISPLAY_LENGTH");
					PAT_CATEGORY=Integer.parseInt(DISPLAY_LENGTH);
				}else if(banDtlRs.getString("ELMT_REF").equals("ATTENDING_PRACT")){
					DISPLAY_LENGTH=banDtlRs.getString("DISPLAY_LENGTH")==null?"0":banDtlRs.getString("DISPLAY_LENGTH");
					ATTENDING_PRACT = Integer.parseInt(DISPLAY_LENGTH);
				}else if(banDtlRs.getString("ELMT_REF").equals("DATE_OF_BIRTH")){
					DISPLAY_LENGTH=banDtlRs.getString("DISPLAY_LENGTH")==null?"0":banDtlRs.getString("DISPLAY_LENGTH");
					dateofbirth = Integer.parseInt(DISPLAY_LENGTH);
				}else if(banDtlRs.getString("ELMT_REF").equals("QUEUE_NO")){
					DISPLAY_LENGTH=banDtlRs.getString("DISPLAY_LENGTH")==null?"0":banDtlRs.getString("DISPLAY_LENGTH");
					queueNoLen = Integer.parseInt(DISPLAY_LENGTH);
				}else if(banDtlRs.getString("ELMT_REF").equals("ADMIT_PRACT")){
					DISPLAY_LENGTH=banDtlRs.getString("DISPLAY_LENGTH")==null?"0":banDtlRs.getString("DISPLAY_LENGTH");
					ADMIT_PRACT = Integer.parseInt(DISPLAY_LENGTH);
				}else if(banDtlRs.getString("ELMT_REF").equals("ADMIT_DATE")){
					DISPLAY_LENGTH=banDtlRs.getString("DISPLAY_LENGTH")==null?"0":banDtlRs.getString("DISPLAY_LENGTH");
					ADMIT_DATE = Integer.parseInt(DISPLAY_LENGTH);
				}else if(banDtlRs.getString("ELMT_REF").equals("LENGTH_OF_STAY")){ //added this CRF Bru-HIMS-CRF-411 [IN:045316]				   
					DISPLAY_LENGTH=banDtlRs.getString("DISPLAY_LENGTH")==null?"0":banDtlRs.getString("DISPLAY_LENGTH");
					LENGTH_OF_STAY = Integer.parseInt(DISPLAY_LENGTH);
				}else if(banDtlRs.getString("ELMT_REF").equals("PAT_NOTES")){			   
					TOOL_TIP_TEXT=banDtlRs.getString("TOOL_TIP_TEXT")==null?"":banDtlRs.getString("TOOL_TIP_TEXT");					
				}else if(banDtlRs.getString("ELMT_REF").equals("NEXT_OF_KIN")){ //Below line added for this CRF ML-MMOH-CRF-0780			   
					NEXT_OF_KIN_TOOLTIP=banDtlRs.getString("TOOL_TIP_TEXT")==null?"":banDtlRs.getString("TOOL_TIP_TEXT");					
				}
				
				if(applCateg.equals("P"))
					{
					if(banDtlRs.getString("ELMT_REF").equals("UNIQUE_NO")){
					DISPLAY_LENGTH=banDtlRs.getString("DISPLAY_LENGTH")==null?"0":banDtlRs.getString("DISPLAY_LENGTH");
					UNIQUE_NO=Integer.parseInt(DISPLAY_LENGTH);
							}
					}

			}
			if(banDtlRs!=null)banDtlRs.close();
			res = pstmt.executeQuery();
			//while(res.next())
			if(res != null && res.next())
			{				
				patNameInLocLang = res.getString("pat_name_loc_lang") == null ? "" : res.getString("pat_name_loc_lang");
				patAge = res.getString("age") == null ? "" : res.getString("age");
				date_of_birth = res.getString("date_of_birth") == null ? "" : res.getString("date_of_birth");		 
				date_of_birth=DateUtils.convertDate(date_of_birth,"DMY","en",localeName);
		 
				patientId = res.getString("pat_id")==null?"":res.getString("pat_id");  
				
				mpPatientValues.put("PATIENT_ID",patientId); 

				if(!patAge.equals("")) {

					StringTokenizer st = new StringTokenizer(patAge," ");				

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
								//if(!ymdh_elmnt.equals("0"))
									age_value = age_value+ymdh_elmnt+"H ";
							}
							else if (ymdh_char==')') {
								//if(!ymdh_elmnt.equals("0"))
									age_value = age_value+ymdh_elmnt+") ";
							}
					}	
					
				}

				altId = res.getString("alt_id") == null ? "" : res.getString("alt_id");
				nationality = res.getString("nationality") == null ? "" : res.getString("nationality");
				nationalityId = res.getString("nat_id") == null ? "" : res.getString("nat_id");
				patCateg = res.getString("pat_categ") == null ? "" : res.getString("pat_categ");
				gender = res.getString("gender") == null ? "" : res.getString("gender");
				if(applCateg.equals("P")){
				unique_no = res.getString("myhix_id") == null ? "" : res.getString("myhix_id");
				if(unique_no!=""){
				unique_no="XX-XXX-XXX-"+unique_no.substring(unique_no.length()-4); // added by lakshmanan 21-Sep-2022 GHL-CRF-0657
				}
				}
				EstimatedAge = res.getString("estd") == null ? "" : res.getString("estd");
				
				Orgsubname = res.getString("Orgsubname") == null ? "" : res.getString("Orgsubname");
				Orgname = res.getString("Orgname") == null ? "" : res.getString("Orgname");
				patCccupation = res.getString("occupation") == null ? "" : res.getString("occupation");

				mpPatientValues.put("nationalityId",nationalityId);//Added by Thamizh selvi on 5th June 2018 against MMS-DM-CRF-0115

				if( !Orgname.equals("") && !Orgsubname.equals(""))
					orgSubOrgName = Orgname+"/"+Orgsubname;
				else if(!Orgname.equals(""))
					orgSubOrgName = Orgname;
				else if(!Orgsubname.equals(""))
					orgSubOrgName = Orgsubname;

				if(gender.equals("M")) gender = common_labels.getString("Common.male.label");	
				else if(gender.equals("F")) gender = common_labels.getString("Common.female.label");
				else if(gender.equals("U")) gender = common_labels.getString("Common.unknown.label");
				
				if(EstimatedAge.equals("Y")) 
				EstimatedAge = mp_labels.getString("eMP.Estimated.label");	
					
				else if(EstimatedAge.equals("N")) EstimatedAge="";

				patName = res.getString("pat_name") == null ? "" : res.getString("pat_name");

				if(patName.length() > PATIENT_NAME){
					patName=patName.substring(0,PATIENT_NAME);
				}
				if(patNameInLocLang.length() > PAT_NAME_LOCAL_LANG){
					patNameInLocLang=patNameInLocLang.substring(0,PAT_NAME_LOCAL_LANG);
				}
				if(patientId.length() > PATIENT_ID){
					patientId=patientId.substring(0,PATIENT_ID);
				}
				if(date_of_birth.length() > dateofbirth){
					date_of_birth=date_of_birth.substring(0,dateofbirth);
				}
								
				if(altId.length() > ALTERNATE_ID){
					altId=altId.substring(0,ALTERNATE_ID);
				}
				if(age_value.length() > AGE){
					age_value=age_value.substring(0,AGE);
				}
				if(gender.length() > GENDER){
					gender=gender.substring(0,GENDER);
				}
				if(unique_no.length() > UNIQUE_NO){
					unique_no=unique_no.substring(0,UNIQUE_NO);
				}
				
				if(nationalityId.length() > NATIONALITY_ID){
					nationalityId=nationalityId.substring(0,NATIONALITY_ID);
				}
				if(nationality.length() > NATIONALITY){
					nationality=nationality.substring(0,NATIONALITY);
				}
				if(patCccupation.length() > OCCUPATION){
					patCccupation=patCccupation.substring(0,OCCUPATION);
				}
				if(orgSubOrgName.length() > COMPANY){
					orgSubOrgName=orgSubOrgName.substring(0,COMPANY);
				}
				if(patCateg.length() > PAT_CATEGORY){
					patCateg=patCateg.substring(0,PAT_CATEGORY);
				}

				mapValues.put("~PATIENT_ID`",patientId);
				mapValues.put("~PATIENT_NAME`",patName);
				mapValues.put("~PAT_NAME_LOCAL_LANG`",patNameInLocLang);
				mapValues.put("~AGE`",age_value+""+EstimatedAge);
				mapValues.put("~ALTERNATE_ID`",altId);
				mapValues.put("~NATIONALITY`",nationality);
				mapValues.put("~NATIONALITY_ID`",nationalityId);
				mapValues.put("~PAT_CATEGORY`",patCateg);
				mapValues.put("~GENDER`",gender);
				if(applCateg.equals("P")){
				mapValues.put("~UNIQUE_NO`",unique_no);		
				}				
				mapValues.put("~DATE_OF_BIRTH`",date_of_birth);			 		
				mapValues.put("~COMPANY`",orgSubOrgName);
				mapValues.put("~OCCUPATION`",patCccupation);

				deceasedYN = res.getString("DECEASED_YN") == null?"N":res.getString("DECEASED_YN");
				eye_indicator = res.getString("eye_indicator") == null?"":res.getString("eye_indicator");
				 
				general_remarks = res.getString("general_remarks") == null?"":res.getString("general_remarks");
				Day_before_BirthDay = res.getString("Day_before_BirthDay") == null?"":res.getString("Day_before_BirthDay");				
				Birth_day = res.getString("Birth_day") == null?"":res.getString("Birth_day");
				activeYN = res.getString("ACTIVE_YN")== null?"Y":res.getString("ACTIVE_YN");
				suspended = res.getString("SUSPEND_YN")== null?"N":res.getString("SUSPEND_YN");
				vipYN = res.getString("VIP_YN")== null?"N":res.getString("VIP_YN");
				
				if(isMlcApplicable){
					if(applCateg.equals("P")){
				MLC_YN = res.getString("MLC_YN") == null ? "N" : res.getString("MLC_YN");//Added for ML-MMOH-CRF-1954
				mpPatientValues.put("MLC_YN", MLC_YN);
					mapValues.put("~MLC_YN`",MLC_YN);		
					}	
				}	
				mpPatientValues.put("DECEASED_YN",deceasedYN);
				mpPatientValues.put("ACTIVE_YN",activeYN);
				mpPatientValues.put("SUSPEND_YN",suspended);
				mpPatientValues.put("VIP_YN",vipYN);								
				mpPatientValues.put("eye_indicator",eye_indicator);								
				mpPatientValues.put("Day_before_BirthDay",Day_before_BirthDay);								
								
				mpPatientValues.put("Birth_day",Birth_day);								
				 				
				mpPatientValues.put("general_remarks",general_remarks);								
				mpPatientValues.put("EstimatedAge",EstimatedAge);	
				
					
				mpPatientValues.put("TOOL_TIP_TEXT",TOOL_TIP_TEXT);
				
				//Below line added for this CRF ML-MMOH-CRF-0780	
				mpPatientValues.put("NEXT_OF_KIN_TOOLTIP",NEXT_OF_KIN_TOOLTIP); 
				
				
				if(applCateg.equals("E"))
				{
					attendPract = res.getString("attend_pract_id") == null ? "" : res.getString("attend_pract_id");
					location = res.getString("locn") == null ? "" : res.getString("locn");
					roomNum = res.getString("room_num") == null ? "" : res.getString("room_num");
					room_desc = res.getString("room_desc") == null ? "" : res.getString("room_desc");
					bedNum = res.getString("bed_num") == null ? "" : res.getString("bed_num");
					spltyCode = res.getString("splty") == null ? "" : res.getString("splty");		
					
									
					bl_episode_id = res.getString("BL_EPISODE_ID")==null?"":res.getString("BL_EPISODE_ID");
					bl_episode_visit_num = res.getString("BL_OP_EPISODE_VISIT_NUM")==null?"":res.getString("BL_OP_EPISODE_VISIT_NUM");
					cp_operational_yn = res.getString("cp_operational_yn")==null?"N":res.getString("cp_operational_yn");
					
					
					
					
					mpPatientValues.put("BL_EPISODE_ID",bl_episode_id);
					mpPatientValues.put("BL_OP_EPISODE_VISIT_NUM",bl_episode_visit_num);
					
					
					

					queue_no = res.getString("queue_no") == null?"":res.getString("queue_no");
					
					admitPract = res.getString("admitting_pract") == null ? "" : res.getString("admitting_pract");
					admitDate = res.getString("admit_date") == null ? "" : res.getString("admit_date");
					admitDate=DateUtils.convertDate(admitDate,"DMYHM","en",localeName);
					
										
					mpPatientValues.put("P_ENCNTR_DATE",admitDate);
					
					String P_LOCN_CODE	= res.getString("P_LOCN_CODE")==null?"":res.getString("P_LOCN_CODE");
					String P_LOCN_TYPE	= res.getString("P_LOCN_TYPE")==null?"":res.getString("P_LOCN_TYPE");
					String P_VISIT_ID	= res.getString("P_VISIT_ID")==null?"":res.getString("P_VISIT_ID");
					String P_EPISODE_ID	= res.getString("P_EPISODE_ID")==null?"":res.getString("P_EPISODE_ID");
					String P_PHYSICIAN_ID	= res.getString("P_PHYSICIAN_ID")==null?"":res.getString("P_PHYSICIAN_ID");
					String P_EPISODE_TYPE	= res.getString("P_EPISODE_TYPE")==null?"":res.getString("P_EPISODE_TYPE");
					
					
					//mpPatientValues.put("length_of_stay",lengthofstay);
					
					mpPatientValues.put("P_LOCN_DESC",location);
					mpPatientValues.put("P_LOCN_CODE",P_LOCN_CODE);
					mpPatientValues.put("P_LOCN_TYPE",P_LOCN_TYPE);
					mpPatientValues.put("P_VISIT_ID",P_VISIT_ID);
					mpPatientValues.put("P_EPISODE_ID",P_EPISODE_ID);
					mpPatientValues.put("P_PHYSICIAN_ID",P_PHYSICIAN_ID);
					mpPatientValues.put("P_EPISODE_TYPE",P_EPISODE_TYPE);

                    //this line added for this CRF  Bru-HIMS-CRF-411 [IN:045316]
					lengthofstay= res.getString("lengthofstay") == null ? "" : res.getString("lengthofstay");                     
					
					if(lengthofstay.length() > LENGTH_OF_STAY){
						lengthofstay=lengthofstay.substring(0,LENGTH_OF_STAY);
					}
					
					
					
					mpPatientValues.put("LENGTH_OF_STAY",lengthofstay);
					mapValues.put("~LENGTH_OF_STAY`",lengthofstay);
					//End[IN:045316]
					
					if(queue_no.equals("0"))queue_no="";
//System.out.println("queue_no--->"+queue_no);
					if(attendPract.length() > ATTENDING_PRACT){
						attendPract=attendPract.substring(0,ATTENDING_PRACT);
					}
					
					if(queue_no.length() > queueNoLen){
						queue_no=queue_no.substring(0,queueNoLen);
					}
	//System.out.println("queue_no-333-->"+queue_no);					
					mapValues.put("~ATTENDING_PRACT`",attendPract);
					mapValues.put("~QUEUE_NO`",queue_no);
					

					if(admitPract.length() > ADMIT_PRACT){
						admitPract=admitPract.substring(0,ADMIT_PRACT);
					}
					if(admitDate.length() > ADMIT_DATE){
						admitDate=admitDate.substring(0,ADMIT_DATE);
					}
					mapValues.put("~ADMIT_PRACT`",admitPract);
					mapValues.put("~ADMIT_DATE`",admitDate);
					
					
					
					
					if(!location.equals(""))
					{
						if(!roomNum.equals("") && bedNum.equals(""))
							locnRoomBed = location+"/"+roomNum+" "+room_desc;
						else if(roomNum.equals("") && !bedNum.equals(""))
							locnRoomBed = location+"/"+bedNum;
						else if(roomNum.equals("") && bedNum.equals(""))
							locnRoomBed = location;
						else if(!roomNum.equals("") && !bedNum.equals(""))
							locnRoomBed = location+"/"+roomNum+"/"+bedNum;
					}
					else if(!roomNum.equals(""))
					{
						if(bedNum.equals(""))
							locnRoomBed = roomNum;
						else if(!bedNum.equals(""))
							locnRoomBed = roomNum+"/"+bedNum;
					}
					else if(!bedNum.equals(""))
					{
						if(roomNum.equals(""))
							locnRoomBed = bedNum;
						else if(!roomNum.equals(""))
							locnRoomBed = roomNum+"/"+bedNum;
					}
					else
						locnRoomBed = "";
					mapValues.put("~LOCN_BED_ROOM_NO`",locnRoomBed);
					mapValues.put("~SPLTY_FOR_ENC`",spltyCode);
					mapValues.put("~ENCOUNTER_ID`",encounterId);

					if(cp_operational_yn.equals("Y")) { 				
						PreparedStatement pstmt_pat_status = con.prepareStatement(sqlPatStatus);	  
						pstmt_pat_status.setString(1,localeName);
						pstmt_pat_status.setString(2,facilityId);
						pstmt_pat_status.setString(3,encounterId);
						ResultSet res_pat_status = pstmt_pat_status.executeQuery();
						if(res_pat_status.next()) {
							patientStatus = res_pat_status.getString("SHORT_DESC");
						}

						if(res_pat_status!=null)
							res_pat_status.close();
						if(pstmt_pat_status!=null)
							pstmt_pat_status.close();							
					}

					mapValues.put("~PATIENT_STATUS`",patientStatus); 		
			//System.out.println("mapValues-loop-->"+mapValues);		
					
				}
			}

			if(res != null) res.close();
			if(pstmt != null) pstmt.close();

		}//end of try
		catch(Exception e)
		{
			e.printStackTrace(System.err);
		}
		//System.out.println("mapValues---->"+mapValues);		
		//System.out.println("mpPatientValues---->"+mpPatientValues);
		return mapValues;
		
	}

	public HashMap getMpPatientValues() {
		return mpPatientValues;
	}

	public StringBuffer replaceVariables(String values, HashMap valueMap)
	{
		StringBuffer patLineValues = new StringBuffer();
		String subStrValOne = "";
		String subStrValTwo = "";
		String subStrReplacedVal = "";	
		int tilde_index = 0;
		int grv_index = 0;
		int loop_cnt = 0;
//System.out.println("values--->"+values);
//System.out.println("valueMap--->"+valueMap);
		while(values.indexOf("~",tilde_index)!=-1)
		{
			try
			{
				grv_index = values.indexOf("~",tilde_index);	
				if(loop_cnt == 0){				
					subStrValOne = values.substring(tilde_index,grv_index);
					
				}
				else
					subStrValOne = values.substring(tilde_index+1,grv_index);
				patLineValues.append(subStrValOne);
				tilde_index = values.indexOf("`",grv_index);
				
				subStrValTwo = values.substring(grv_index,tilde_index+1);
				
				subStrReplacedVal = checkForNull((String)valueMap.get(subStrValTwo));
				
				patLineValues.append(subStrReplacedVal);								
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}			
			loop_cnt++;	
		}

		if(values.indexOf("~",tilde_index)==-1)
		{
			patLineValues.append(values.substring(tilde_index+1));
		}
		return patLineValues; 		
	}//end of method
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
}//end of class
