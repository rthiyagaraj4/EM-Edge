/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-----------------------------------------------------------------------------------------------
Date       Edit History   Name        Description
-----------------------------------------------------------------------------------------------
?             	100         	?           	created
26/01/2013    	IN030532    	Karthi L    	CA Patient List to have option to call a specific patient queue no [CRF -192]	
08/10/2013		IN041927		Karthi L		Patients in the practitioner’s homepage under Emergency patients remain 
												only up to 12 midnight
13/11/2013    	IN044956	  	Chowminya	  	Patient List by Location> thai Lang> Past visit checked >  return no record	
15/01/2014	  	MV_13012014		Vijayakumar K	Changes has been done to reduce the size of the PatListByLocationResult.jsp file
13/03/2014		IN044157		Chowminya		[AAKH CRF 0010.1]Five level Triage system AE requirement
09/02/2015		IN048463		Karthi L	
02/04/2015		IN048704		Nijitha S		HSA-CRF-175
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History    		Name        	Rev.Date		Rev.Name			Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
22/01/2016	IN057193,IN059021		Karthi L											Flag For Discharge Summary Not Done
04/02/2016	IN057201		    	Karthi L											View Forwarded Referral Letter Under Consults
21/07/2016	IN052254				Ramesh G											MMS-QH-CRF-0204	
09/08/2016	IN064836			Krishna Gowtham		09/08/2017		Ramesh G			ML-MMOH-CRF-0566.1
23/10/2017	IN064342			Krishna Gowtham		23/10/2017		Ramesh G			GHL-CRF-0468.1
26/03/2018	IN067111			Ramesh G			26/03/2018							ML-MMOH-SCF-0957
08/07/2020     IN072994          Chandrashekar raju    	08/07/2020			Ramesh G              Modified for MMS-DM-CRF-0170.1
 18/10/2023     32902             Krishna Pranay    	     19/10/2023      Ramesh G      MMS-DM-CRF-0210	
14/11/2023	51215					Ramesh												ML-MMOH-CRF-1930.2
01/31/2024   49654             Twinkle Shah    01/31/2024     Ramesh Goli      ML-MMOH-CRF-2109
04/03/2024    57520                Srinivasa N T         04/03/2024        Ramesh G     ML-MMOH-SCF-2712
09/07/2024    62822         Srinivasa  N T  	            Ramesh Goli             ML-MMOH-CRF-2069.1	
04/11/2024   70705         Gunasekar R      					                               ML-MMOH-CRF-1759

----------------------------------------------------------------------------------------------------------------------------------------------------------
*/  
package eCA;
import java.sql.*;
import java.util.*;
import javax.servlet.jsp.PageContext;
import eCommon.Common.*;
import webbeans.eCommon.*;
import eCA.Common.CaAdapter;//IN067111

public class PatListByLocationResult extends CaAdapter implements java.io.Serializable//IN067111 extends CaAdapter
{
	//PreparedStatement stmtMotherLink = null;//Checkstyle fix
	//PreparedStatement pstmtForAEPat = null;//Checkstyle fix
	//ResultSet resForAEPat = null;//Checkstyle fix
	//ResultSet rsPatList = null;//Checkstyle fix
	//PreparedStatement pstmtForSite = null;//Checkstyle fix
	//ResultSet rsSite = null;//Checkstyle fix
	public PatListByLocationResult(){}

	public  ResultSet patListByLocationResult(Connection con,HashMap qryStringHash)
	{
		PreparedStatement stmtPatList = null ;
		ResultSet rsPatList = null;//CheckStyle Fix
		
		StringBuffer strBuff_QueryString = new StringBuffer();
		StringBuffer strBuff_OPQueryString = new StringBuffer();
		StringBuffer strBuff_IPQueryString = new StringBuffer();
		StringBuffer strBuff_RPQueryString = new StringBuffer();

		try
		{
			String relnreqyn 		= (String)qryStringHash.get("Relnreqyn");
			String locationType 		= (String)qryStringHash.get("LocationType");
			String patientId 		= (String)qryStringHash.get("PatientId");
			String nationID 		= (String)qryStringHash.get("NationID");
			String queueId 		= (String)qryStringHash.get("QueueId");
			String queueStatus 		= (String)qryStringHash.get("QueueStatus");
			String groupByEpisode 		= (String)qryStringHash.get("GroupByEpisode");
			String unscheduledyn 		= (String)qryStringHash.get("Unscheduledyn");
			String checkedout 		= (String)qryStringHash.get("Checkedout");
			String past 		= (String)qryStringHash.get("Past");
			String fromvisitdate 		= (String)qryStringHash.get("Fromvisitdate");
			String tovisitdate 		= (String)qryStringHash.get("Tovisitdate");
			String viewList 		= (String)qryStringHash.get("ViewList");
			String locationCode 		= (String)qryStringHash.get("LocationCode");
			String mo_install_yn 		= (String)qryStringHash.get("Mo_install_yn");
			String attend_practId 		= (String)qryStringHash.get("Attend_practId");
			String speciality 		= (String)qryStringHash.get("Speciality");

			String visitType 		= (String)qryStringHash.get("VisitType");
			String discharged 		= (String)qryStringHash.get("Discharged");
			String fromdischargedate 		= (String)qryStringHash.get("Fromdischargedate");
			String todischargedate 		= (String)qryStringHash.get("Todischargedate");
			String adm_fromdate 		= (String)qryStringHash.get("Adm_fromdate");
			String adm_todate 		= (String)qryStringHash.get("Adm_todate");
			String locn_type 		= (String)qryStringHash.get("Locn_type");
			String reOrder 		= (String)qryStringHash.get("ReOrder");
			String orderBy 		= (String)qryStringHash.get("OrderBy");
			String groupByLocn 		= (String)qryStringHash.get("GroupByLocn");
			String sortOrder 		= (String)qryStringHash.get("SortOrder");
			String clinicianId 		= (String)qryStringHash.get("ClinicianId");
			String locale 		= (String)qryStringHash.get("Locale");
			String facility_id 		= (String)qryStringHash.get("Facility_id");
			String bedNo 		= (String)qryStringHash.get("BedNo");
			String assign_confirm_referral_yn = (String)qryStringHash.get("assign_confirm_referral_yn");//IN048704
			String virtualConsultation_yn= qryStringHash.get("virtualConsultation_yn")==null?"N":(String)qryStringHash.get("virtualConsultation_yn");//51215
			
			//49654 start.
			String default_sql="";
			PreparedStatement stmtsql = null ;
			ResultSet rs = null;
			String restrictedPractPosition="";
			default_sql = "SELECT POSITION_RESTR_YN FROM CA_CNTRL_SPL_POSITION_BY_LOC A, AM_PRACTITIONER B WHERE PRACTITIONER_ID=? AND FACILITY_ID=? AND A.POSITION_CODE=B.POSITION_CODE AND A.PRACT_TYPE=B.PRACT_TYPE";
			stmtsql = con.prepareStatement(default_sql);
			stmtsql.setString(1,clinicianId);
			stmtsql.setString(2,facility_id);
			rs = stmtsql.executeQuery();
			if(rs.next())
			{
			restrictedPractPosition =rs.getString("POSITION_RESTR_YN");
			}
			if(rs != null) rs.close();
			if(stmtsql != null) stmtsql.close();
			//49654 end
			
			//IN044956 Commentted - Start
			//adm_fromdate	=	com.ehis.util.DateUtils.convertDate(adm_fromdate,"DMY",locale,"en");
			//adm_todate		=	com.ehis.util.DateUtils.convertDate(adm_todate,"DMY",locale,"en");
			//fromdischargedate	=	com.ehis.util.DateUtils.convertDate(fromdischargedate,"DMY",locale,"en"); 
			//todischargedate		=	com.ehis.util.DateUtils.convertDate(todischargedate,"DMY",locale,"en");
			//fromvisitdate	=	com.ehis.util.DateUtils.convertDate(fromvisitdate,"DMY",locale,"en");
			//tovisitdate		=	com.ehis.util.DateUtils.convertDate(tovisitdate,"DMY",locale,"en");
			//IN044956 Commentted - End
			//strBuff_RPQueryString.append(" SELECT C.PATIENT_CLASS episode_type_desc,B.PATIENT_NAME, A.referral_id, CA_GET_AGE_IN_HRS (B.date_of_birth,B.DECEASED_DATE) AGE, decode(B.SEX, 'M','Male','F','Female','U','Unknown','') sex, A.PATIENT_ID, case when open_chart_yn='N' then 'P' when A.unAssigned_yn='N' THEN 'U' ELSE A.STATUS END  STATUS, A.unAssigned_yn, B.DATE_OF_BIRTH actual_dob, C.PATIENT_CLASS, C.ENCOUNTER_ID EPISODE_ID,C.ASSIGN_ROOM_NUM  ROOM_NO,C.ASSIGN_BED_NUM  BED_NO,CA_GET_PATIENT_CURR_STATUS(C.FACILITY_ID,C.PATIENT_ID,C.ENCOUNTER_ID,C.PATIENT_CLASS,?)  patient_status, C.PRIORITY_ZONE,  C.ASSIGN_CARE_LOCN_CODE, case when C.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(C.FACILITY_ID, C.ASSIGN_CARE_LOCN_CODE,?,'1') else op_get_desc.op_clinic(C.FACILITY_ID, C.ASSIGN_CARE_LOCN_CODE,?,'1') end  locn_name, to_char(C.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') visit_adm_date,C.VISIT_ADM_DATE_TIME adm_date1,to_char(C.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') orderbydate, to_char(C.DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') DISCHARGE_DATE_TIME, to_char(C.DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') cls_cons_date,'' queue_num, to_char(SYSDATE,'hh24:mi:ss') QRYTIME,  '' queue_status,'' appt_time,NVL (am_get_desc.am_practitioner (C.ATTEND_PRACTITIONER_ID, ?, '2'), '')  physician_name,'' splty_name, C.ATTEND_PRACTITIONER_ID, NVL (am_get_desc.am_practitioner (C.ATTEND_PRACTITIONER_ID, ?, '2'), '') attend_pract_name, A.confirm_yn, A.open_chart_yn,(SELECT COUNT (*) FROM ca_research_patient_detail c WHERE c.patient_id = a.patient_id) res_studies_cnt ,0 QMS_CALL_COUNT FROM (SELECT REFERRAL_ID, FROM_FACILITY_ID FACILITY_ID, patient_id, NVL(CLOSE_ENCOUNTER_ID,FROM_ENCOUNTER_ID) ENCOUNTER_ID, STATUS, nvl2(TO_PRACT_ID,'Y','N') unAssigned_yn, (Case when BEDSIDE_REFERRAL_YN = 'Y' OR CLOSE_ENCOUNTER_ID is not null  then 'Y' else 'N' end ) open_chart_yn, (Case when STATUS='C' then 'N' else BEDSIDE_REFERRAL_YN end)   confirm_yn FROM PR_REFERRAL_REGISTER WHERE TO_FACILITY_ID = ?  AND PATIENT_ID = NVL('',PATIENT_ID) AND bedside_referral_yn = 'Y' and  TO_PRACT_ID = ?  ");// modiifed for CRf-025 - IN030466 - For new issue
			//strBuff_RPQueryString.append(" SELECT C.PATIENT_CLASS episode_type_desc,B.PATIENT_NAME, A.referral_id, CA_GET_AGE_IN_HRS (B.date_of_birth,B.DECEASED_DATE) AGE, decode(B.SEX, 'M','Male','F','Female','U','Unknown','') sex, A.PATIENT_ID, case when open_chart_yn='N' then 'P' when A.unAssigned_yn='N' THEN 'U' ELSE A.STATUS END  STATUS, A.unAssigned_yn, B.DATE_OF_BIRTH actual_dob, C.PATIENT_CLASS, C.ENCOUNTER_ID EPISODE_ID,C.ASSIGN_ROOM_NUM  ROOM_NO,C.ASSIGN_BED_NUM  BED_NO,CA_GET_PATIENT_CURR_STATUS(C.FACILITY_ID,C.PATIENT_ID,C.ENCOUNTER_ID,C.PATIENT_CLASS,?)  patient_status, C.PRIORITY_ZONE,  C.ASSIGN_CARE_LOCN_CODE, case when C.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(C.FACILITY_ID, C.ASSIGN_CARE_LOCN_CODE,?,'1') else op_get_desc.op_clinic(C.FACILITY_ID, C.ASSIGN_CARE_LOCN_CODE,?,'1') end  locn_name, to_char(C.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') visit_adm_date,C.VISIT_ADM_DATE_TIME adm_date1,to_char(C.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') orderbydate, to_char(C.DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') DISCHARGE_DATE_TIME, to_char(C.DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') cls_cons_date,'' queue_num, to_char(SYSDATE,'hh24:mi:ss') QRYTIME,  '' queue_status,'' appt_time,NVL (am_get_desc.am_practitioner (C.ATTEND_PRACTITIONER_ID, ?, '2'), '')  physician_name,'' splty_name, C.ATTEND_PRACTITIONER_ID, NVL (am_get_desc.am_practitioner (C.ATTEND_PRACTITIONER_ID, ?, '2'), '') attend_pract_name, A.confirm_yn, A.open_chart_yn,(SELECT COUNT (*) FROM ca_research_patient_detail c WHERE c.patient_id = a.patient_id) res_studies_cnt ,0 QMS_CALL_COUNT,ca_ae_get_priority_zone_color(C.PRIORITY_ZONE,'en') ae_zone_color FROM (SELECT REFERRAL_ID, FROM_FACILITY_ID FACILITY_ID, patient_id, NVL(CLOSE_ENCOUNTER_ID,FROM_ENCOUNTER_ID) ENCOUNTER_ID, STATUS, nvl2(TO_PRACT_ID,'Y','N') unAssigned_yn, (Case when BEDSIDE_REFERRAL_YN = 'Y' OR CLOSE_ENCOUNTER_ID is not null  then 'Y' else 'N' end ) open_chart_yn, (Case when STATUS='C' then 'N' else BEDSIDE_REFERRAL_YN end)   confirm_yn FROM PR_REFERRAL_REGISTER WHERE TO_FACILITY_ID = ?  AND PATIENT_ID = NVL('',PATIENT_ID) AND bedside_referral_yn = 'Y' and  TO_PRACT_ID = ?  ");// modified for IN044157 - Commented for IN048463
			//strBuff_RPQueryString.append(" SELECT C.PATIENT_CLASS episode_type_desc,B.PATIENT_NAME, A.referral_id, A.BEDSIDE_REF_REVIEW_STATUS, CA_GET_AGE_IN_HRS (B.date_of_birth,B.DECEASED_DATE) AGE, decode(B.SEX, 'M','Male','F','Female','U','Unknown','') sex, A.PATIENT_ID, case when open_chart_yn='N' then 'P' when A.unAssigned_yn='N' THEN 'U' ELSE A.STATUS END  STATUS, A.unAssigned_yn, B.DATE_OF_BIRTH actual_dob, C.PATIENT_CLASS, C.ENCOUNTER_ID EPISODE_ID,C.ASSIGN_ROOM_NUM  ROOM_NO,C.ASSIGN_BED_NUM  BED_NO,CA_GET_PATIENT_CURR_STATUS(C.FACILITY_ID,C.PATIENT_ID,C.ENCOUNTER_ID,C.PATIENT_CLASS,?)  patient_status, C.PRIORITY_ZONE,  C.ASSIGN_CARE_LOCN_CODE, case when C.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(C.FACILITY_ID, C.ASSIGN_CARE_LOCN_CODE,?,'1') else op_get_desc.op_clinic(C.FACILITY_ID, C.ASSIGN_CARE_LOCN_CODE,?,'1') end  locn_name, to_char(C.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') visit_adm_date,C.VISIT_ADM_DATE_TIME adm_date1,to_char(C.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') orderbydate, to_char(C.DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') DISCHARGE_DATE_TIME, to_char(C.DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') cls_cons_date,'' queue_num, to_char(SYSDATE,'hh24:mi:ss') QRYTIME,  '' queue_status,'' appt_time,NVL (am_get_desc.am_practitioner (C.ATTEND_PRACTITIONER_ID, ?, '2'), '')  physician_name,'' splty_name, C.ATTEND_PRACTITIONER_ID, NVL (am_get_desc.am_practitioner (C.ATTEND_PRACTITIONER_ID, ?, '2'), '') attend_pract_name, A.confirm_yn, A.open_chart_yn,(SELECT COUNT (*) FROM ca_research_patient_detail c WHERE c.patient_id = a.patient_id) res_studies_cnt ,0 QMS_CALL_COUNT,ca_ae_get_priority_zone_color(C.PRIORITY_ZONE,'en') ae_zone_color FROM (SELECT REFERRAL_ID, BEDSIDE_REF_REVIEW_STATUS, FROM_FACILITY_ID FACILITY_ID, patient_id, NVL(CLOSE_ENCOUNTER_ID,FROM_ENCOUNTER_ID) ENCOUNTER_ID, STATUS, nvl2(TO_PRACT_ID,'Y','N') unAssigned_yn, (Case when BEDSIDE_REFERRAL_YN = 'Y' OR CLOSE_ENCOUNTER_ID is not null  then 'Y' else 'N' end ) open_chart_yn, (Case when STATUS='C' then 'N' else BEDSIDE_REFERRAL_YN end)   confirm_yn FROM PR_REFERRAL_REGISTER WHERE TO_FACILITY_ID = ?  AND PATIENT_ID = NVL('',PATIENT_ID) AND bedside_referral_yn = 'Y' and  TO_PRACT_ID = ?  ");// modified for IN048463//Commented for IN048704
			//IN048704 Starts
		//	strBuff_RPQueryString.append(" SELECT C.PATIENT_CLASS episode_type_desc,B.PATIENT_NAME, A.referral_id, A.BEDSIDE_REF_REVIEW_STATUS, CA_GET_AGE_IN_HRS (B.date_of_birth,B.DECEASED_DATE) AGE, decode(B.SEX, 'M','Male','F','Female','U','Unknown','') sex, A.PATIENT_ID, case when open_chart_yn='N' then 'P' when A.unAssigned_yn='N' THEN 'U' ELSE A.STATUS END  STATUS, A.unAssigned_yn, B.DATE_OF_BIRTH actual_dob, C.PATIENT_CLASS, C.ENCOUNTER_ID EPISODE_ID,C.ASSIGN_ROOM_NUM  ROOM_NO,C.ASSIGN_BED_NUM  BED_NO,CA_GET_PATIENT_CURR_STATUS(C.FACILITY_ID,C.PATIENT_ID,C.ENCOUNTER_ID,C.PATIENT_CLASS,?)  patient_status, C.PRIORITY_ZONE,  C.ASSIGN_CARE_LOCN_CODE, case when C.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(C.FACILITY_ID, C.ASSIGN_CARE_LOCN_CODE,?,'1') else op_get_desc.op_clinic(C.FACILITY_ID, C.ASSIGN_CARE_LOCN_CODE,?,'1') end  locn_name, to_char(C.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') visit_adm_date,C.VISIT_ADM_DATE_TIME adm_date1,to_char(C.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') orderbydate, to_char(C.DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') DISCHARGE_DATE_TIME, to_char(C.DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') cls_cons_date,'' queue_num, to_char(SYSDATE,'hh24:mi:ss') QRYTIME,  '' queue_status,'' appt_time,NVL (am_get_desc.am_practitioner (C.ATTEND_PRACTITIONER_ID, ?, '2'), '')  physician_name,'' splty_name, C.ATTEND_PRACTITIONER_ID, NVL (am_get_desc.am_practitioner (C.ATTEND_PRACTITIONER_ID, ?, '2'), '') attend_pract_name, A.confirm_yn, A.open_chart_yn,(SELECT COUNT (*) FROM ca_research_patient_detail c WHERE c.patient_id = a.patient_id) res_studies_cnt ,0 QMS_CALL_COUNT,ca_ae_get_priority_zone_color(C.PRIORITY_ZONE,'en') ae_zone_color,to_pract_id FROM (SELECT REFERRAL_ID, BEDSIDE_REF_REVIEW_STATUS, FROM_FACILITY_ID FACILITY_ID, patient_id, NVL(CLOSE_ENCOUNTER_ID,FROM_ENCOUNTER_ID) ENCOUNTER_ID, STATUS, nvl2(TO_PRACT_ID,'Y','N') unAssigned_yn, (Case when BEDSIDE_REFERRAL_YN = 'Y' OR CLOSE_ENCOUNTER_ID is not null  then 'Y' else 'N' end ) open_chart_yn, (Case when STATUS='C' then 'N' else BEDSIDE_REFERRAL_YN end)   confirm_yn,to_pract_id FROM PR_REFERRAL_REGISTER WHERE TO_FACILITY_ID = ?  AND PATIENT_ID = NVL('',PATIENT_ID) AND bedside_referral_yn = 'Y' ");//32902
			strBuff_RPQueryString.append(" SELECT C.PATIENT_CLASS episode_type_desc,B.PATIENT_NAME, A.referral_id, A.BEDSIDE_REF_REVIEW_STATUS, CA_GET_AGE_IN_HRS (B.date_of_birth,B.DECEASED_DATE) AGE, decode(B.SEX, 'M','Male','F','Female','U','Unknown','') sex, A.PATIENT_ID, case when open_chart_yn='N' then 'P' when A.unAssigned_yn='N' THEN 'U' ELSE A.STATUS END  STATUS, A.unAssigned_yn, B.DATE_OF_BIRTH actual_dob, C.PATIENT_CLASS, C.ENCOUNTER_ID EPISODE_ID,C.ASSIGN_ROOM_NUM  ROOM_NO,C.ASSIGN_BED_NUM  BED_NO,CA_GET_PATIENT_CURR_STATUS(C.FACILITY_ID,C.PATIENT_ID,C.ENCOUNTER_ID,C.PATIENT_CLASS,?)  patient_status, C.PRIORITY_ZONE,  C.ASSIGN_CARE_LOCN_CODE, case when C.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(C.FACILITY_ID, C.ASSIGN_CARE_LOCN_CODE,?,'1') else op_get_desc.op_clinic(C.FACILITY_ID, C.ASSIGN_CARE_LOCN_CODE,?,'1') end  locn_name, to_char(C.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') visit_adm_date,C.VISIT_ADM_DATE_TIME adm_date1,to_char(C.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') orderbydate, to_char(C.DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') DISCHARGE_DATE_TIME, to_char(C.DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') cls_cons_date,'' queue_num, to_char(SYSDATE,'hh24:mi:ss') QRYTIME,  '' queue_status,'' appt_time,NVL (am_get_desc.am_practitioner (C.ATTEND_PRACTITIONER_ID, ?, '2'), '')  physician_name,'' splty_name, C.ATTEND_PRACTITIONER_ID, NVL (am_get_desc.am_practitioner (C.ATTEND_PRACTITIONER_ID, ?, '2'), '') attend_pract_name, A.confirm_yn, A.open_chart_yn,(SELECT COUNT (*) FROM ca_research_patient_detail c WHERE c.patient_id = a.patient_id) res_studies_cnt ,0 QMS_CALL_COUNT,ca_ae_get_priority_zone_color(C.PRIORITY_ZONE,'en') ae_zone_color,to_pract_id,b.restrict_reinstate_yn FROM (SELECT REFERRAL_ID, BEDSIDE_REF_REVIEW_STATUS, FROM_FACILITY_ID FACILITY_ID, patient_id, NVL(CLOSE_ENCOUNTER_ID,FROM_ENCOUNTER_ID) ENCOUNTER_ID, STATUS, nvl2(TO_PRACT_ID,'Y','N') unAssigned_yn, (Case when BEDSIDE_REFERRAL_YN = 'Y' OR CLOSE_ENCOUNTER_ID is not null  then 'Y' else 'N' end ) open_chart_yn, (Case when STATUS='C' then 'N' else BEDSIDE_REFERRAL_YN end)   confirm_yn,to_pract_id FROM PR_REFERRAL_REGISTER WHERE TO_FACILITY_ID = ?  AND PATIENT_ID = NVL('',PATIENT_ID) AND bedside_referral_yn = 'Y' ");//32902
			if(assign_confirm_referral_yn.equals("Y"))
			{	
				if("N".equals(unscheduledyn))
				{
					strBuff_RPQueryString.append(" and TO_PRACT_ID = ? ");
				}
				else if("Y".equals(unscheduledyn)){
					strBuff_RPQueryString.append(" and  (TO_PRACT_ID = ? or TO_SPECIALITY_CODE IN (SELECT PRIMARY_SPECIALITY_CODE  from am_practitioner where PRACTITIONER_ID = ? union all SELECT SPECIALITY_CODE FROM AM_PRACT_SPECIALITIES WHERE FACILITY_ID = ? AND PRACTITIONER_ID = ? )) ");
				}
			}
			else
			{
				strBuff_RPQueryString.append(" and TO_PRACT_ID = ? ");
			}
			//IN048704 Ends
			if(relnreqyn.equals("Y"))
			{
				if(!assign_confirm_referral_yn.equals("Y")){//IN048704
					strBuff_RPQueryString.append(" AND (FROM_FACILITY_ID,FROM_ENCOUNTER_ID ) IN (SELECT FACILITY_ID, ENCOUNTER_ID FROM CA_ENCNTR_PRACT_RELN  WHERE FACILITY_ID = ? AND PRACTITIONER_ID = ? AND STATUS='01' AND SYSDATE BETWEEN BEGIN_DATE_TIME AND NVL(END_DATE_TIME,SYSDATE))");
				}	//IN048704

			}
			else
			{
				/***MODIFIED BY Deepa on 1/27/2010 at 12:20 PM for MF performance issue**********/
				strBuff_RPQueryString.append(" AND (FROM_FACILITY_ID,FROM_ENCOUNTER_ID ) IN (SELECT FACILITY_ID,ENCOUNTER_ID FROM PR_ENCOUNTER WHERE ADT_STATUS BETWEEN '01' AND '09' ) ");
			}
			
			strBuff_RPQueryString.append(" ) A , MP_PATIENT B , PR_ENCOUNTER C WHERE B.PATIENT_ID = A.PATIENT_ID AND C.FACILITY_ID(+) = A.FACILITY_ID AND C.ENCOUNTER_ID(+) = A.ENCOUNTER_ID ");
			
			if(!locationType.equals("Z"))
			{
				strBuff_RPQueryString.append(" AND C.PATIENT_CLASS = ?  ");
			}
			if(!patientId.equals(""))
			{
				strBuff_RPQueryString.append(" AND A.PATIENT_ID  = ? ");
			}
			strBuff_RPQueryString.append(" AND 'N'=CA_GET_RESTRICTED_PATIENTS_YN(?,b.patient_id,c.facility_id)  ");//32902
			// start 49654
			if(restrictedPractPosition.equals("Y") && attend_practId.equals("") && viewList.equals("Z"))
			{
				strBuff_RPQueryString.append("AND A.SPECIALTY_CODE IN( SELECT PRIMARY_SPECIALITY_CODE  from am_practitioner where PRACTITIONER_ID =? union all SELECT SPECIALITY_CODE FROM AM_PRACT_SPECIALITIES WHERE FACILITY_ID =? AND PRACTITIONER_ID = ?)");
			}
			// end 49654
			/***MODIFIED BY Deepa on 1/27/2010 at 12:20 PM for MF performance issue**********/
			/***
				age column in ca_op_episode_vw has been replaced with get_age (dob,NVL (deceased_date, SYSDATE))
				physician_name has been changed to am_get_desc.am_practitioner(physician_id,?,'1') 
			**/	
			//strBuff_OPQueryString.append(" select A.PATIENT_CLASS episode_type_desc,'O' episode_type,patient_id,replace(decode(?,'en',PATIENT_NAME,nvl(PATIENT_NAME_LOC_LANG,PATIENT_NAME)),'''','') patient_name,to_char(dob,'dd/mm/yyyy') dob, CA_GET_AGE_IN_HRS (dob,deceased_date) age,sex,locn_type,locn_code,OP_GET_DESC.OP_CLINIC(?,a.locn_code,?,'1') locn_name,null file_num,'&nbsp;' room_num,'&nbsp;' bed_num,nvl(physician_id,'*ALL') physician_id,AM_GET_DESC.AM_PRACTITIONER(physician_id,?,'2') physician_name,service_code splty_code,nvl(AM_GET_DESC.AM_SERVICE(service_code,?,'2') ,'&nbsp;')  splty_name,to_char(adm_visit_date,'dd/mm/yyyy hh24:mi') adm_visit_date,to_char(discharge_date_time,'dd/mm/yyyy') discharge_date_time,episode_id,visit_id,vis_adm_type_code, visit_episode_status,nvl(appt_time,'&nbsp;')appt_time,nvl(decode(queue_num,'','&nbsp;','null','&nbsp;','0','&nbsp;',queue_num),'')queue_num, nvl(queue_status,'&nbsp;')queue_status,to_char(SYSDATE,'hh24:mi:ss') QRYTIME,decode(ACTUAL_PHYSICIAN_ID,'*ALL',null,'2') ACTUAL_PHYSICIAN_ID,trunc(adm_visit_date) visit_date, null SECURITY_LEVEL, null PROTECTION_IND,(replace(PATIENT_NAME,'''','')||','|| get_age (dob,NVL (deceased_date, SYSDATE)) ||','||sex) p_line,CA_GET_PATIENT_CURR_STATUS(a.facility_id,a.patient_id,a.EPISODE_ID,a.PATIENT_CLASS,?,a.DECEASED_YN) status, PATIENT_CLASS,UNASSIGN_PATIENT_YN, adm_visit_date orderbydate,referral_id, dob actual_dob,adm_visit_date adm_date1, to_char(discharge_date_time,'dd/mm/yyyy hh24:mi') cls_cons_date,PRIORITY_ZONE,OP_GET_DESC.OP_VISIT_TYPE(?,VIS_ADM_TYPE_CODE,?,1) visit_type, (select COUNT(*) from ca_research_patient_detail c WHERE C.pATIENT_ID = A.pATIENT_ID) RES_STUDIES_CNT, (select QMS_CALL_COUNT from OP_PATIENT_QUEUE D WHERE D.PATIENT_ID = A.PATIENT_ID AND D.ENCOUNTER_ID = A.EPISODE_ID AND D.FACILITY_ID = A.FACILITY_ID) QMS_CALL_COUNT from CA_OP_EPISODE_VW a Where a.facility_id =?  ");
			//strBuff_OPQueryString.append(" select A.PATIENT_CLASS episode_type_desc,'O' episode_type,patient_id,replace(decode(?,'en',PATIENT_NAME,nvl(PATIENT_NAME_LOC_LANG,PATIENT_NAME)),'''','') patient_name,to_char(dob,'dd/mm/yyyy') dob, CA_GET_AGE_IN_HRS (dob,deceased_date) age,sex,locn_type,locn_code,OP_GET_DESC.OP_CLINIC(?,a.locn_code,?,'1') locn_name,null file_num,'&nbsp;' room_num,'&nbsp;' bed_num,nvl(physician_id,'*ALL') physician_id,AM_GET_DESC.AM_PRACTITIONER(physician_id,?,'2') physician_name,service_code splty_code,nvl(AM_GET_DESC.AM_SERVICE(service_code,?,'2') ,'&nbsp;')  splty_name,to_char(adm_visit_date,'dd/mm/yyyy hh24:mi') adm_visit_date,to_char(discharge_date_time,'dd/mm/yyyy') discharge_date_time,episode_id,visit_id,vis_adm_type_code, visit_episode_status,nvl(appt_time,'&nbsp;')appt_time,nvl(decode(queue_num,'','&nbsp;','null','&nbsp;','0','&nbsp;',queue_num),'')queue_num, nvl(queue_status,'&nbsp;')queue_status,to_char(SYSDATE,'hh24:mi:ss') QRYTIME,decode(ACTUAL_PHYSICIAN_ID,'*ALL',null,'2') ACTUAL_PHYSICIAN_ID,trunc(adm_visit_date) visit_date, null SECURITY_LEVEL, null PROTECTION_IND,(replace(PATIENT_NAME,'''','')||','|| get_age (dob,NVL (deceased_date, SYSDATE)) ||','||sex) p_line,CA_GET_PATIENT_CURR_STATUS(a.facility_id,a.patient_id,a.EPISODE_ID,a.PATIENT_CLASS,?,a.DECEASED_YN) status, PATIENT_CLASS,UNASSIGN_PATIENT_YN, adm_visit_date orderbydate,referral_id, dob actual_dob,adm_visit_date adm_date1, to_char(discharge_date_time,'dd/mm/yyyy hh24:mi') cls_cons_date,PRIORITY_ZONE,OP_GET_DESC.OP_VISIT_TYPE(?,VIS_ADM_TYPE_CODE,?,1) visit_type, (select COUNT(*) from ca_research_patient_detail c WHERE C.pATIENT_ID = A.pATIENT_ID) RES_STUDIES_CNT, (select QMS_CALL_COUNT from OP_PATIENT_QUEUE D WHERE D.PATIENT_ID = A.PATIENT_ID AND D.ENCOUNTER_ID = A.EPISODE_ID AND D.FACILITY_ID = A.FACILITY_ID) QMS_CALL_COUNT,ca_ae_get_priority_zone_color(PRIORITY_ZONE,'en') ae_zone_color from CA_OP_EPISODE_VW a Where a.facility_id =?  ");// modified for IN044157 //commented for ML-MMOH-CRF-0356 [IN057193] 
			//IN064342 starts
			//strBuff_OPQueryString.append(" select A.PATIENT_CLASS episode_type_desc,'O' episode_type,patient_id,replace(decode(?,'en',PATIENT_NAME,nvl(PATIENT_NAME_LOC_LANG,PATIENT_NAME)),'''','') patient_name,to_char(dob,'dd/mm/yyyy') dob, CA_GET_AGE_IN_HRS (dob,deceased_date) age,sex,locn_type,locn_code,OP_GET_DESC.OP_CLINIC(?,a.locn_code,?,'1') locn_name,null file_num,'&nbsp;' room_num,'&nbsp;' bed_num,nvl(physician_id,'*ALL') physician_id,AM_GET_DESC.AM_PRACTITIONER(physician_id,?,'2') physician_name,service_code splty_code,nvl(AM_GET_DESC.AM_SERVICE(service_code,?,'2') ,'&nbsp;')  splty_name,to_char(adm_visit_date,'dd/mm/yyyy hh24:mi') adm_visit_date,to_char(discharge_date_time,'dd/mm/yyyy') discharge_date_time,episode_id,visit_id,vis_adm_type_code, visit_episode_status,nvl(appt_time,'&nbsp;')appt_time,nvl(decode(queue_num,'','&nbsp;','null','&nbsp;','0','&nbsp;',queue_num),'')queue_num, nvl(queue_status,'&nbsp;')queue_status,to_char(SYSDATE,'hh24:mi:ss') QRYTIME,decode(ACTUAL_PHYSICIAN_ID,'*ALL',null,'2') ACTUAL_PHYSICIAN_ID,trunc(adm_visit_date) visit_date, null SECURITY_LEVEL, null PROTECTION_IND,(replace(PATIENT_NAME,'''','')||','|| get_age (dob,NVL (deceased_date, SYSDATE)) ||','||sex) p_line,CA_GET_PATIENT_CURR_STATUS(a.facility_id,a.patient_id,a.EPISODE_ID,a.PATIENT_CLASS,?,a.DECEASED_YN) status, PATIENT_CLASS,UNASSIGN_PATIENT_YN, adm_visit_date orderbydate,referral_id, dob actual_dob,adm_visit_date adm_date1, to_char(discharge_date_time,'dd/mm/yyyy hh24:mi') cls_cons_date,PRIORITY_ZONE,OP_GET_DESC.OP_VISIT_TYPE(?,VIS_ADM_TYPE_CODE,?,1) visit_type, (select COUNT(*) from ca_research_patient_detail c WHERE C.pATIENT_ID = A.pATIENT_ID) RES_STUDIES_CNT, (select QMS_CALL_COUNT from OP_PATIENT_QUEUE D WHERE D.PATIENT_ID = A.PATIENT_ID AND D.ENCOUNTER_ID = A.EPISODE_ID AND D.FACILITY_ID = A.FACILITY_ID) QMS_CALL_COUNT,ca_ae_get_priority_zone_color(PRIORITY_ZONE,'en') ae_zone_color, (SELECT   'Y' FROM DUAL, CA_IP_EPISODE_VW g WHERE g.ADT_STATUS = '08' AND g.DISCHARGE_DATE_TIME IS NOT NULL AND g.DISCHARGE_DATE_TIME < SYSDATE - 2 AND NOT EXISTS (SELECT 1 FROM   ca_encntr_note b, ca_note_group c, ca_note_type d WHERE b.note_type = d.note_type AND c.note_group = d.note_group_id AND c.APPL_TASK_ID = 'DISCHARGE_SUMMARY' AND b.encounter_id = g.episode_id AND b.event_status != '9' AND ROWNUM = 1) and rownum=1) PEND_DISC_SUM_YN from CA_OP_EPISODE_VW a Where a.facility_id =?  ");// modified for ML-MMOH-CRF-0356 [IN057193]  // added AND B.EVENT_STATUS  for IN059021
		//	strBuff_OPQueryString.append(" select A.PATIENT_CLASS episode_type_desc,'O' episode_type,patient_id,replace(decode(?,'en',PATIENT_NAME,nvl(PATIENT_NAME_LOC_LANG,PATIENT_NAME)),'''','') patient_name,to_char(dob,'dd/mm/yyyy') dob, CA_GET_AGE_IN_HRS (dob,deceased_date) age,sex,locn_type,locn_code,OP_GET_DESC.OP_CLINIC(?,a.locn_code,?,'1') locn_name,null file_num,'&nbsp;' room_num,'&nbsp;' bed_num,nvl(physician_id,'*ALL') physician_id,AM_GET_DESC.AM_PRACTITIONER(physician_id,?,'2') physician_name,service_code splty_code,nvl(AM_GET_DESC.AM_SERVICE(service_code,?,'2') ,'&nbsp;')  splty_name,to_char(adm_visit_date,'dd/mm/yyyy hh24:mi') adm_visit_date,to_char(discharge_date_time,'dd/mm/yyyy') discharge_date_time,episode_id,visit_id,vis_adm_type_code, visit_episode_status,nvl(appt_time,'&nbsp;')appt_time,nvl(decode(queue_num,'','&nbsp;','null','&nbsp;','0','&nbsp;',queue_num),'')queue_num, nvl(queue_status,'&nbsp;')queue_status,to_char(SYSDATE,'hh24:mi:ss') QRYTIME,decode(ACTUAL_PHYSICIAN_ID,'*ALL',null,'2') ACTUAL_PHYSICIAN_ID,trunc(adm_visit_date) visit_date, null SECURITY_LEVEL, null PROTECTION_IND,(replace(PATIENT_NAME,'''','')||','|| get_age (dob,NVL (deceased_date, SYSDATE)) ||','||sex) p_line,CA_GET_PATIENT_CURR_STATUS(a.facility_id,a.patient_id,a.EPISODE_ID,a.PATIENT_CLASS,?,a.DECEASED_YN) status, PATIENT_CLASS,UNASSIGN_PATIENT_YN, adm_visit_date orderbydate,referral_id, dob actual_dob,adm_visit_date adm_date1, to_char(discharge_date_time,'dd/mm/yyyy hh24:mi') cls_cons_date,PRIORITY_ZONE,OP_GET_DESC.OP_VISIT_TYPE(?,VIS_ADM_TYPE_CODE,?,1) visit_type, (select COUNT(*) from ca_research_patient_detail c WHERE C.pATIENT_ID = A.pATIENT_ID) RES_STUDIES_CNT, (select QMS_CALL_COUNT from OP_PATIENT_QUEUE D WHERE D.PATIENT_ID = A.PATIENT_ID AND D.ENCOUNTER_ID = A.EPISODE_ID AND D.FACILITY_ID = A.FACILITY_ID) QMS_CALL_COUNT,ca_ae_get_priority_zone_color(PRIORITY_ZONE,'en') ae_zone_color, (SELECT   'Y' FROM DUAL, CA_IP_EPISODE_VW g WHERE g.ADT_STATUS = '08' AND g.DISCHARGE_DATE_TIME IS NOT NULL AND g.DISCHARGE_DATE_TIME < SYSDATE - 2 AND NOT EXISTS (SELECT 1 FROM   ca_encntr_note b, ca_note_group c, ca_note_type d WHERE b.note_type = d.note_type AND c.note_group = d.note_group_id AND c.APPL_TASK_ID = 'DISCHARGE_SUMMARY' AND b.encounter_id = g.episode_id AND b.event_status != '9' AND ROWNUM = 1) and rownum=1) PEND_DISC_SUM_YN, 'N' pre_disg_advice_yn,oa_appt_virtual_status(a.facility_id,a.patient_id,a.episode_id,a.patient_class) virtualApptYN from CA_OP_EPISODE_VW a Where a.facility_id =?  "); //IN064342 ends
		//	strBuff_OPQueryString.append(" select A.PATIENT_CLASS episode_type_desc,'O' episode_type,patient_id,replace(decode(?,'en',PATIENT_NAME,nvl(PATIENT_NAME_LOC_LANG,PATIENT_NAME)),'''','') patient_name,to_char(dob,'dd/mm/yyyy') dob, CA_GET_AGE_IN_HRS (dob,deceased_date) age,sex,locn_type,locn_code,OP_GET_DESC.OP_CLINIC(?,a.locn_code,?,'1') locn_name,null file_num,'&nbsp;' room_num,'&nbsp;' bed_num,nvl(physician_id,'*ALL') physician_id,AM_GET_DESC.AM_PRACTITIONER(physician_id,?,'2') physician_name,service_code splty_code,nvl(AM_GET_DESC.AM_SERVICE(service_code,?,'2') ,'&nbsp;')  splty_name,to_char(adm_visit_date,'dd/mm/yyyy hh24:mi') adm_visit_date,to_char(discharge_date_time,'dd/mm/yyyy') discharge_date_time,episode_id,visit_id,vis_adm_type_code, visit_episode_status,nvl(appt_time,'&nbsp;')appt_time,nvl(decode(queue_num,'','&nbsp;','null','&nbsp;','0','&nbsp;',queue_num),'')queue_num, nvl(queue_status,'&nbsp;')queue_status,to_char(SYSDATE,'hh24:mi:ss') QRYTIME,decode(ACTUAL_PHYSICIAN_ID,'*ALL',null,'2') ACTUAL_PHYSICIAN_ID,trunc(adm_visit_date) visit_date, null SECURITY_LEVEL, null PROTECTION_IND,(replace(PATIENT_NAME,'''','')||','|| get_age (dob,NVL (deceased_date, SYSDATE)) ||','||sex) p_line,CA_GET_PATIENT_CURR_STATUS(a.facility_id,a.patient_id,a.EPISODE_ID,a.PATIENT_CLASS,?,a.DECEASED_YN) status, PATIENT_CLASS,UNASSIGN_PATIENT_YN, adm_visit_date orderbydate,referral_id, dob actual_dob,adm_visit_date adm_date1, to_char(discharge_date_time,'dd/mm/yyyy hh24:mi') cls_cons_date,PRIORITY_ZONE,OP_GET_DESC.OP_VISIT_TYPE(?,VIS_ADM_TYPE_CODE,?,1) visit_type, (select COUNT(*) from ca_research_patient_detail c WHERE C.pATIENT_ID = A.pATIENT_ID) RES_STUDIES_CNT, (select QMS_CALL_COUNT from OP_PATIENT_QUEUE D WHERE D.PATIENT_ID = A.PATIENT_ID AND D.ENCOUNTER_ID = A.EPISODE_ID AND D.FACILITY_ID = A.FACILITY_ID) QMS_CALL_COUNT,ca_ae_get_priority_zone_color(PRIORITY_ZONE,'en') ae_zone_color, 'Y' PEND_DISC_SUM_YN, 'N' pre_disg_advice_yn,oa_appt_virtual_status(a.facility_id,a.patient_id,a.episode_id,a.patient_class) virtualApptYN from CA_OP_EPISODE_VW a Where a.facility_id =?  ");
		//	strBuff_OPQueryString.append(" select A.PATIENT_CLASS episode_type_desc,'O' episode_type,patient_id,a.restrict_reinstate_yn,replace(decode(?,'en',PATIENT_NAME,nvl(PATIENT_NAME_LOC_LANG,PATIENT_NAME)),'''','') patient_name,to_char(dob,'dd/mm/yyyy') dob, CA_GET_AGE_IN_HRS (dob,deceased_date) age,sex,locn_type,locn_code,OP_GET_DESC.OP_CLINIC(?,a.locn_code,?,'1') locn_name,null file_num,'&nbsp;' room_num,'&nbsp;' bed_num,nvl(physician_id,'*ALL') physician_id,AM_GET_DESC.AM_PRACTITIONER(physician_id,?,'2') physician_name,service_code splty_code,nvl(AM_GET_DESC.AM_SERVICE(service_code,?,'2') ,'&nbsp;')  splty_name,to_char(adm_visit_date,'dd/mm/yyyy hh24:mi') adm_visit_date,to_char(discharge_date_time,'dd/mm/yyyy') discharge_date_time,episode_id,visit_id,vis_adm_type_code, visit_episode_status,nvl(appt_time,'&nbsp;')appt_time,nvl(decode(queue_num,'','&nbsp;','null','&nbsp;','0','&nbsp;',queue_num),'')queue_num, nvl(queue_status,'&nbsp;')queue_status,to_char(SYSDATE,'hh24:mi:ss') QRYTIME,decode(ACTUAL_PHYSICIAN_ID,'*ALL',null,'2') ACTUAL_PHYSICIAN_ID,trunc(adm_visit_date) visit_date, null SECURITY_LEVEL, null PROTECTION_IND,(replace(PATIENT_NAME,'''','')||','|| get_age (dob,NVL (deceased_date, SYSDATE)) ||','||sex) p_line,CA_GET_PATIENT_CURR_STATUS(a.facility_id,a.patient_id,a.EPISODE_ID,a.PATIENT_CLASS,?,a.DECEASED_YN) status, PATIENT_CLASS,UNASSIGN_PATIENT_YN, adm_visit_date orderbydate,referral_id, dob actual_dob,adm_visit_date adm_date1, to_char(discharge_date_time,'dd/mm/yyyy hh24:mi') cls_cons_date,PRIORITY_ZONE,OP_GET_DESC.OP_VISIT_TYPE(?,VIS_ADM_TYPE_CODE,?,1) visit_type, (select COUNT(*) from ca_research_patient_detail c WHERE C.pATIENT_ID = A.pATIENT_ID) RES_STUDIES_CNT, (select QMS_CALL_COUNT from OP_PATIENT_QUEUE D WHERE D.PATIENT_ID = A.PATIENT_ID AND D.ENCOUNTER_ID = A.EPISODE_ID AND D.FACILITY_ID = A.FACILITY_ID) QMS_CALL_COUNT,ca_ae_get_priority_zone_color(PRIORITY_ZONE,'en') ae_zone_color, 'Y' PEND_DISC_SUM_YN, 'N' pre_disg_advice_yn,oa_appt_virtual_status(a.facility_id,a.patient_id,a.episode_id,a.patient_class) virtualApptYN, ##C4C_STATUS_DISPLAY## from CA_OP_EPISODE_VW a Where a.facility_id =?  ");//32902
			strBuff_OPQueryString.append(" select A.PATIENT_CLASS episode_type_desc,'O' episode_type,patient_id,a.restrict_reinstate_yn,replace(decode(?,'en',PATIENT_NAME,nvl(PATIENT_NAME_LOC_LANG,PATIENT_NAME)),'''','') patient_name,to_char(dob,'dd/mm/yyyy') dob, CA_GET_AGE_IN_HRS (dob,deceased_date) age,sex,locn_type,locn_code,OP_GET_DESC.OP_CLINIC(?,a.locn_code,?,'1') locn_name,null file_num,'&nbsp;' room_num,'&nbsp;' bed_num,nvl(physician_id,'*ALL') physician_id,AM_GET_DESC.AM_PRACTITIONER(physician_id,?,'2') physician_name,service_code splty_code,nvl(AM_GET_DESC.AM_SERVICE(service_code,?,'2') ,'&nbsp;')  splty_name,to_char(adm_visit_date,'dd/mm/yyyy hh24:mi') adm_visit_date,to_char(discharge_date_time,'dd/mm/yyyy') discharge_date_time,episode_id,visit_id,vis_adm_type_code, visit_episode_status,nvl(appt_time,'&nbsp;')appt_time,nvl(decode(queue_num,'','&nbsp;','null','&nbsp;','0','&nbsp;',queue_num),'')queue_num, nvl(queue_status,'&nbsp;')queue_status,to_char(SYSDATE,'hh24:mi:ss') QRYTIME,decode(ACTUAL_PHYSICIAN_ID,'*ALL',null,'2') ACTUAL_PHYSICIAN_ID,trunc(adm_visit_date) visit_date, null SECURITY_LEVEL, null PROTECTION_IND,(replace(PATIENT_NAME,'''','')||','|| get_age (dob,NVL (deceased_date, SYSDATE)) ||','||sex) p_line,CA_GET_PATIENT_CURR_STATUS(a.facility_id,a.patient_id,a.EPISODE_ID,a.PATIENT_CLASS,?,a.DECEASED_YN) status, PATIENT_CLASS,UNASSIGN_PATIENT_YN, adm_visit_date orderbydate,referral_id, dob actual_dob,adm_visit_date adm_date1, to_char(discharge_date_time,'dd/mm/yyyy hh24:mi') cls_cons_date,PRIORITY_ZONE,OP_GET_DESC.OP_VISIT_TYPE(?,VIS_ADM_TYPE_CODE,?,1) visit_type, (select COUNT(*) from ca_research_patient_detail c WHERE C.pATIENT_ID = A.pATIENT_ID) RES_STUDIES_CNT, (select QMS_CALL_COUNT from OP_PATIENT_QUEUE D WHERE D.PATIENT_ID = A.PATIENT_ID AND D.ENCOUNTER_ID = A.EPISODE_ID AND D.FACILITY_ID = A.FACILITY_ID) QMS_CALL_COUNT,ca_ae_get_priority_zone_color(PRIORITY_ZONE,'en') ae_zone_color, 'Y' PEND_DISC_SUM_YN, 'N' pre_disg_advice_yn,oa_appt_virtual_status(a.facility_id,a.patient_id,a.episode_id,a.patient_class) virtualApptYN,  ##C4C_STATUS_DISPLAY##, ##QNUM_PAT_LIST_BY_DISPLAY##  from CA_OP_EPISODE_VW a Where a.facility_id =?  ");//ML-MMOH-CRF-2069.1

			/***MODIFIED BY Deepa on 1/27/2010 at 12:20 PM for MF performance issue**********/
			
			if (!patientId.equals(""))
				strBuff_OPQueryString.append("  and a.patient_id = ? ");
			//IN052254 Start.
			if("Y".equals(getRestrictUnsettledPatientYN())){
				strBuff_OPQueryString.append("  and 'N' = blcommonproc.unbld_outst_amt_exists_yn(a.facility_id,a.patient_id,a.episode_type,NULL,NULL,a.episode_id,NULL) ");
			}
			//IN052254 End.
			if (!nationID.equals(""))
				strBuff_OPQueryString.append(" and  a.NATIONAL_ID_NO = ? ");
			if (!queueId.equals(""))
				strBuff_OPQueryString.append(" and a.alt_id1_no=? ");
			strBuff_OPQueryString.append("  and queue_status >= nvl(DISP_IN_CA_QUEUE_AFTER,queue_status) ");

			if (queueStatus.equals(""))
			{
				strBuff_OPQueryString.append(" and a.queue_status  in ( null )   ");
			}
			else
			{
				strBuff_OPQueryString.append(" and a.queue_status  in ( "+queueStatus+" )   ");
			}
			if (groupByEpisode.equals("Y"))
			{
				strBuff_OPQueryString.append(" and a.PATIENT_CLASS =  ?   ");
			}
			if(!(unscheduledyn.equals("Y")))
			{
				strBuff_OPQueryString.append(" and ACTUAL_PHYSICIAN_ID != '*ALL'  "); 
			}
			else if(unscheduledyn.equals("Y")) 
			{
				strBuff_OPQueryString.append(" and 'Y' =  decode(nvl(ACTUAL_PHYSICIAN_ID,'*ALL'),'*ALL',CA_GET_UNASSIGN_LOCN_APPL(a.facility_id,a.UNASSIGN_PATIENT_YN,'");
				strBuff_OPQueryString.append(clinicianId);
				strBuff_OPQueryString.append("', a.locn_type, a.locn_code,a.patient_class),'Y')  ");
				
			}
			if(checkedout.equals("Y"))
			{
				/***MODIFIED BY Deepa on 1/27/2010 at 12:20 PM for MF performance issue**********/
				strBuff_OPQueryString.append("and visit_episode_status in ('00','01','02','03','04','05','06','07','09') ");
			}
			else
			{
				strBuff_OPQueryString.append(" and visit_episode_status in ('00','01','02','03','04','05','06')  ");
			}
			if (past.equals("N")||past.equals(""))
			{
				//strBuff_OPQueryString.append(" and adm_visit_date between trunc(sysdate) and trunc(sysdate)+1 "); commented for IN041927
				// added for IN041927 - Start
				if(locationType.equals("EM")) {
					strBuff_OPQueryString.append(" and adm_visit_date between trunc(sysdate-1) and trunc(sysdate)+1 ");
				}
				else {
					strBuff_OPQueryString.append(" and adm_visit_date between trunc(sysdate) and trunc(sysdate)+1 ");
				}
				// End	
			}
			else
			{
				if (!fromvisitdate.equals(""))
				{
					strBuff_OPQueryString.append( " and adm_visit_date >= to_date(?,'dd/mm/yyyy') ");
				}
				if (!tovisitdate.equals(""))
				{
					strBuff_OPQueryString.append( " and adm_visit_date <= to_date(?,'dd/mm/yyyy')+.9999 ");
				}
			}
			if(viewList.equals("S")) 
			{
				strBuff_OPQueryString.append(" and  PHYSICIAN_ID=? ");
			}
			
			if (!locationCode.equals("*ALL") )
				strBuff_OPQueryString.append(" and  LOCN_CODE =? ");	

			if(mo_install_yn.equals("Y"))
			{
				strBuff_OPQueryString.append(" AND ( NOT EXISTS(SELECT  1 FROM MO_MORTUARY_REGN WHERE PATIENT_ID=a.patient_id and BODY_PART_OBTAINED_FROM is null)) ");
			}
			if(!attend_practId.equals(""))
			{
				strBuff_OPQueryString.append(" and  PHYSICIAN_ID = ? ");
			}
			if(!speciality.equals(""))
			{
				strBuff_OPQueryString.append(" and SPECIALTY_CODE = ? ");
			}
			if(locationType.equals("OP")){
				if(!visitType.equals(""))
				{
					strBuff_OPQueryString.append(" and VIS_ADM_TYPE_CODE = ? "); // visitType
				}
			}
			//51215 Start.
			if("Y".equals(virtualConsultation_yn))
					strBuff_OPQueryString.append( " and  'Y'= oa_appt_virtual_status(a.facility_id,a.patient_id,a.episode_id,a.patient_class)");
			//51215 End.
			  strBuff_OPQueryString.append( "AND 'N' =CA_GET_RESTRICTED_PATIENTS_YN(?,a.patient_id,a.facility_id)" );	//32902
			// start 49654
				if(restrictedPractPosition.equals("Y") && attend_practId.equals("") && viewList.equals("Z"))
				{
					strBuff_OPQueryString.append("AND A.SPECIALTY_CODE IN( SELECT PRIMARY_SPECIALITY_CODE  from am_practitioner where PRACTITIONER_ID =? union all SELECT SPECIALITY_CODE FROM AM_PRACT_SPECIALITIES WHERE FACILITY_ID =? AND PRACTITIONER_ID =?)");
				}
			// end 49654
			String oPQueryStirng=strBuff_OPQueryString.toString();
			
			boolean isVirtualConsSDGSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "CA","VIRTUAL_CONSALTATION_SDG");
			if(isVirtualConsSDGSpec){
				oPQueryStirng=oPQueryStirng.replace("##C4C_STATUS_DISPLAY##"," op_patient_c4c_status_display (A.facility_id, A.patient_id, a.episode_id,A.patient_class ) C4C_STATUS_DISPLAY");
			}else{
				oPQueryStirng=oPQueryStirng.replace("##C4C_STATUS_DISPLAY##"," 'N' C4C_STATUS_DISPLAY");
			}
			//51215 End.
         
			
			//ML-MMOH-CRF-2069.1 start
			boolean qnum_patlist_bylocation = eCommon.Common.CommonBean.isSiteSpecific(con, "CA","QNUM_PATLIST_BYLOCATION");
			if(qnum_patlist_bylocation){
				oPQueryStirng=oPQueryStirng.replace("##QNUM_PAT_LIST_BY_DISPLAY##"," IBAEHIS.am_secondary_triage_qno(a.facility_id,a.episode_id) SECONDARY_TRIAGE_QUEUE_NO ");
			}else{
				oPQueryStirng=oPQueryStirng.replace("##QNUM_PAT_LIST_BY_DISPLAY##"," null SECONDARY_TRIAGE_QUEUE_NO ");
			}
			//ML-MMOH-CRF-2069.1 end

		// ==============ip query =============	
			//strBuff_IPQueryString.append("select A.PATIENT_CLASS episode_type_desc,'I' episode_type,a.patient_id,replace(decode(?,'en',PATIENT_NAME,nvl(PATIENT_NAME_LOC_LANG,PATIENT_NAME)),'''','') patient_name,to_char(a.dob,'dd/mm/yyyy') dob,NVL(a.age_hrs,a.age) age,a.sex,a.locn_type,a.CUR_WARD_CODE locn_code,IP_GET_DESC.IP_NURSING_UNIT(?,a.CUR_WARD_CODE,?,'1') locn_name,null file_num,nvl(a.CUR_ROOM_NUM,'&nbsp;')room_num,nvl(a.CUR_BED_NUM,'&nbsp;')bed_num,a.CUR_PHYSICIAN_ID physician_id,AM_GET_DESC.AM_PRACTITIONER(a.cur_physician_id,?,'2') physician_name,a.service_code splty_code,nvl(am_get_desc.am_service(a.service_code,?,'1'),'&nbsp;') splty_name,to_char(a.ADMISSION_DATE_TIME,'dd/mm/yyyy hh24:mi') adm_visit_date,to_char(a.discharge_date_time,'dd/mm/yyyy') discharge_date_time,a.episode_id,to_number('') visit_id,a.ADMISSION_TYPE_CODE vis_adm_type_code,case when a.adt_status in ('00','08') then case when a.adt_status='08' then 'DS' when a.CUR_BED_NUM is not null then 'BA' else 'AD' end when a.adt_status='01' then  case when  (select 'Y' from ip_discharge_advice where facility_id=a.facility_id and encounter_id=a.EPISODE_ID and DIS_ADV_STATUS='0' and rownum=1)='Y' then 'AP' when  (select 'Y' from PR_DIAGNOSIS_ENC_DTL where FACILITY_ID=a.facility_id and  ENCOUNTER_ID = a.EPISODE_ID  and rownum=1 and status!='E' ) = 'Y' then 'DR'  else case when a.CUR_BED_NUM is not null then 'BA' else 'AD' end end end visit_episode_status,'&nbsp;' appt_time,'&nbsp;'queue_num,a.adt_status queue_status ,to_char(SYSDATE,'hh24:mi:ss') QRYTIME, a.CUR_PHYSICIAN_ID ACTUAL_PHYSICIAN_ID ,trunc(a.ADMISSION_DATE_TIME) visit_date,null SECURITY_LEVEL, null PROTECTION_IND, (replace(decode(?,'en',PATIENT_NAME,nvl(PATIENT_NAME_LOC_LANG,PATIENT_NAME)) ,'''','')||','||nvl(a.AGE_HRS,a.age)||','||a.sex) p_line,CA_GET_PATIENT_CURR_STATUS(a.facility_id,a.patient_id,a.EPISODE_ID,a.PATIENT_CLASS,?,a.DECEASED_YN)  status, a.PATIENT_CLASS,null UNASSIGN_PATIENT_YN,a.ADMISSION_DATE_TIME orderbydate,a.referral_id, a.dob actual_dob,a.ADMISSION_DATE_TIME adm_date1, to_char(a.discharge_date_time,'dd/mm/yyyy hh24:mi') cls_cons_date, null PRIORITY_ZONE ,'' visit_type,(select COUNT(*) from ca_research_patient_detail c WHERE C.pATIENT_ID = a.pATIENT_ID) RES_STUDIES_CNT,0 QMS_CALL_COUNT "); // modified for CRF-025 - IN030466, IN030532
		//	strBuff_IPQueryString.append("select A.PATIENT_CLASS episode_type_desc,'I' episode_type,a.patient_id,replace(decode(?,'en',PATIENT_NAME,nvl(PATIENT_NAME_LOC_LANG,PATIENT_NAME)),'''','') patient_name,to_char(a.dob,'dd/mm/yyyy') dob,NVL(a.age_hrs,a.age) age,a.sex,a.locn_type,a.CUR_WARD_CODE locn_code,IP_GET_DESC.IP_NURSING_UNIT(?,a.CUR_WARD_CODE,?,'1') locn_name,null file_num,nvl(a.CUR_ROOM_NUM,'&nbsp;')room_num,nvl(a.CUR_BED_NUM,'&nbsp;')bed_num,a.CUR_PHYSICIAN_ID physician_id,AM_GET_DESC.AM_PRACTITIONER(a.cur_physician_id,?,'2') physician_name,a.service_code splty_code,nvl(am_get_desc.am_service(a.service_code,?,'1'),'&nbsp;') splty_name,to_char(a.ADMISSION_DATE_TIME,'dd/mm/yyyy hh24:mi') adm_visit_date,to_char(a.discharge_date_time,'dd/mm/yyyy') discharge_date_time,a.episode_id,to_number('') visit_id,a.ADMISSION_TYPE_CODE vis_adm_type_code,case when a.adt_status in ('00','08') then case when a.adt_status='08' then 'DS' when a.CUR_BED_NUM is not null then 'BA' else 'AD' end when a.adt_status='01' then  case when  (select 'Y' from ip_discharge_advice where facility_id=a.facility_id and encounter_id=a.EPISODE_ID and DIS_ADV_STATUS='0' and rownum=1)='Y' then 'AP' when  (select 'Y' from PR_DIAGNOSIS_ENC_DTL where FACILITY_ID=a.facility_id and  ENCOUNTER_ID = a.EPISODE_ID  and rownum=1 and status!='E' ) = 'Y' then 'DR'  else case when a.CUR_BED_NUM is not null then 'BA' else 'AD' end end end visit_episode_status,'&nbsp;' appt_time,'&nbsp;'queue_num,a.adt_status queue_status ,to_char(SYSDATE,'hh24:mi:ss') QRYTIME, a.CUR_PHYSICIAN_ID ACTUAL_PHYSICIAN_ID ,trunc(a.ADMISSION_DATE_TIME) visit_date,null SECURITY_LEVEL, null PROTECTION_IND, (replace(decode(?,'en',PATIENT_NAME,nvl(PATIENT_NAME_LOC_LANG,PATIENT_NAME)) ,'''','')||','||nvl(a.AGE_HRS,a.age)||','||a.sex) p_line,CA_GET_PATIENT_CURR_STATUS(a.facility_id,a.patient_id,a.EPISODE_ID,a.PATIENT_CLASS,?,a.DECEASED_YN)  status, a.PATIENT_CLASS,null UNASSIGN_PATIENT_YN,a.ADMISSION_DATE_TIME orderbydate,a.referral_id, a.dob actual_dob,a.ADMISSION_DATE_TIME adm_date1, to_char(a.discharge_date_time,'dd/mm/yyyy hh24:mi') cls_cons_date, null PRIORITY_ZONE ,'' visit_type,(select COUNT(*) from ca_research_patient_detail c WHERE C.pATIENT_ID = a.pATIENT_ID) RES_STUDIES_CNT,0 QMS_CALL_COUNT,'' ae_zone_color "); // modified for IN044157
			strBuff_IPQueryString.append("select A.PATIENT_CLASS episode_type_desc,'I' episode_type,a.patient_id,a.restrict_reinstate_yn,replace(decode(?,'en',PATIENT_NAME,nvl(PATIENT_NAME_LOC_LANG,PATIENT_NAME)),'''','') patient_name,to_char(a.dob,'dd/mm/yyyy') dob,NVL(a.age_hrs,a.age) age,a.sex,a.locn_type,a.CUR_WARD_CODE locn_code,IP_GET_DESC.IP_NURSING_UNIT(?,a.CUR_WARD_CODE,?,'1') locn_name,null file_num,nvl(a.CUR_ROOM_NUM,'&nbsp;')room_num,nvl(a.CUR_BED_NUM,'&nbsp;')bed_num,a.CUR_PHYSICIAN_ID physician_id,AM_GET_DESC.AM_PRACTITIONER(a.cur_physician_id,?,'2') physician_name,a.service_code splty_code,nvl(am_get_desc.am_service(a.service_code,?,'1'),'&nbsp;') splty_name,to_char(a.ADMISSION_DATE_TIME,'dd/mm/yyyy hh24:mi') adm_visit_date,to_char(a.discharge_date_time,'dd/mm/yyyy') discharge_date_time,a.episode_id,to_number('') visit_id,a.ADMISSION_TYPE_CODE vis_adm_type_code,case when a.adt_status in ('00','08') then case when a.adt_status='08' then 'DS' when a.CUR_BED_NUM is not null then 'BA' else 'AD' end when a.adt_status='01' then  case when  (select 'Y' from ip_discharge_advice where facility_id=a.facility_id and encounter_id=a.EPISODE_ID and DIS_ADV_STATUS='0' and rownum=1)='Y' then 'AP' when  (select 'Y' from PR_DIAGNOSIS_ENC_DTL where FACILITY_ID=a.facility_id and  ENCOUNTER_ID = a.EPISODE_ID  and rownum=1 and status!='E' ) = 'Y' then 'DR'  else case when a.CUR_BED_NUM is not null then 'BA' else 'AD' end end end visit_episode_status,'&nbsp;' appt_time,'&nbsp;'queue_num,a.adt_status queue_status ,to_char(SYSDATE,'hh24:mi:ss') QRYTIME, a.CUR_PHYSICIAN_ID ACTUAL_PHYSICIAN_ID ,trunc(a.ADMISSION_DATE_TIME) visit_date,null SECURITY_LEVEL, null PROTECTION_IND, (replace(decode(?,'en',PATIENT_NAME,nvl(PATIENT_NAME_LOC_LANG,PATIENT_NAME)) ,'''','')||','||nvl(a.AGE_HRS,a.age)||','||a.sex) p_line,CA_GET_PATIENT_CURR_STATUS(a.facility_id,a.patient_id,a.EPISODE_ID,a.PATIENT_CLASS,?,a.DECEASED_YN)  status, a.PATIENT_CLASS,null UNASSIGN_PATIENT_YN,a.ADMISSION_DATE_TIME orderbydate,a.referral_id, a.dob actual_dob,a.ADMISSION_DATE_TIME adm_date1, to_char(a.discharge_date_time,'dd/mm/yyyy hh24:mi') cls_cons_date, null PRIORITY_ZONE ,'' visit_type,(select COUNT(*) from ca_research_patient_detail c WHERE C.pATIENT_ID = a.pATIENT_ID) RES_STUDIES_CNT,0 QMS_CALL_COUNT,'' ae_zone_color "); // 32902
			strBuff_IPQueryString.append(", (SELECT   'Y' from dual where a.ADT_STATUS = '08' AND a.DISCHARGE_DATE_TIME IS NOT NULL AND a.DISCHARGE_DATE_TIME < SYSDATE - 2 and not exists (select 1 FROM   ca_encntr_note b, ca_note_group c, ca_note_type d WHERE b.note_type=d.note_type and c.note_group = d.note_group_id and c.APPL_TASK_ID = 'DISCHARGE_SUMMARY' AND b.encounter_id = a.episode_id AND b.event_status != '9' and rownum=1 )) PEND_DISC_SUM_YN "); //ML-MMOH-CRF-0356 [IN057193] // added AND B.EVENT_STATUS  for IN059021
			strBuff_IPQueryString.append(", ip_initiate_dis_yn(?, a.episode_id) pre_disg_advice_yn "); //IN064342
			strBuff_IPQueryString.append(", 'N' virtualApptYN ");
			strBuff_IPQueryString.append(", 'N' C4C_STATUS_DISPLAY "); //51215
			strBuff_IPQueryString.append(", null SECONDARY_TRIAGE_QUEUE_NO "); //ML-MMOH-CRF-2069.1
			if (discharged.equals("Y"))
			{
			strBuff_IPQueryString.append("from CA_IP_EPISODE_VW a");
			}
			else
			{
				
			strBuff_IPQueryString.append("from CA_IP_ACTIVE_EPISODE_VW a");
			}
			strBuff_IPQueryString.append("	Where a.facility_id =? ");
			if (!patientId.equals(""))
				strBuff_IPQueryString.append("	and a.patient_id =? ");
			
			if (!nationID.equals(""))
				strBuff_IPQueryString.append("	and  a.NATIONAL_ID_NO = ? ");
			if (!queueId.equals(""))
				strBuff_IPQueryString.append(" a.alt_id1_no = ?  ");
			if (groupByEpisode.equals("Y"))
			{
				strBuff_IPQueryString.append(" and a.PATIENT_CLASS  =  ? ");
			}
			strBuff_IPQueryString.append(" and (a.adt_status in ('01','02') ");
			if (discharged.equals("Y"))
			{
				strBuff_IPQueryString.append(" OR ( a.adt_status in ('08')  ");
				
				
				if (!fromdischargedate.equals("")&&(!todischargedate.equals("")))
				{
					strBuff_IPQueryString.append(" and discharge_date_time between to_date('");
					strBuff_IPQueryString.append(fromdischargedate);
					strBuff_IPQueryString.append("','dd/mm/yyyy')  ");
					strBuff_IPQueryString.append(" and  to_date('");
					strBuff_IPQueryString.append(todischargedate);
					strBuff_IPQueryString.append("','dd/mm/yyyy')+.9999  ");
					
				}		
				strBuff_IPQueryString.append(" ) ");
			}
			strBuff_IPQueryString.append(" ) ");
			if (!locationCode.equals("*ALL") )
				strBuff_IPQueryString.append(" and CUR_WARD_CODE =? ");
			if(viewList.equals("S")) 
			{
				strBuff_IPQueryString.append(" and CUR_PHYSICIAN_ID=? ");
			}
			if (!adm_fromdate.equals(""))
			{
				strBuff_IPQueryString.append( " and ADMISSION_DATE_TIME >= to_date(?,'dd/mm/yyyy') ");
			}
			if (!adm_todate.equals(""))
			{
				strBuff_IPQueryString.append( " and ADMISSION_DATE_TIME <= to_date(?,'dd/mm/yyyy')+.9999 ");
			}
			if(mo_install_yn.equals("Y"))
			{
				strBuff_IPQueryString.append("AND ( NOT EXISTS(SELECT  1 FROM MO_MORTUARY_REGN WHERE PATIENT_ID=a.patient_id and BODY_PART_OBTAINED_FROM is null )) ");
			}
			if(!attend_practId.equals(""))
			{
				strBuff_IPQueryString.append(" and  CUR_PHYSICIAN_ID = ? ");
			}
			if(!speciality.equals(""))
			{
				strBuff_IPQueryString.append(" and SPECIALTY_CODE = ? ");
			}
			strBuff_IPQueryString.append("AND UPPER(a.CUR_BED_NUM) LIKE UPPER(?)");//IN29412
			strBuff_IPQueryString.append( "  AND 'N' =CA_GET_RESTRICTED_PATIENTS_YN(?,a.patient_id,a.facility_id) ");//32902
			// start 49654
			if(restrictedPractPosition.equals("Y") && attend_practId.equals("") && viewList.equals("Z"))
			{
				strBuff_IPQueryString.append("AND A.SPECIALTY_CODE IN( SELECT PRIMARY_SPECIALITY_CODE  from am_practitioner where PRACTITIONER_ID =? union all SELECT SPECIALITY_CODE FROM AM_PRACT_SPECIALITIES WHERE FACILITY_ID =? AND PRACTITIONER_ID =?)");
			}
			// end 49654
			//51215 Start.
			if("Y".equals(virtualConsultation_yn))
				strBuff_IPQueryString.append( " AND 'N' ='Y'");				
			//51215 End.
			
			if(locn_type.equals("RP"))
			{
				
				strBuff_QueryString.append(strBuff_RPQueryString.toString());

			}
			else if(locationType.equals("Z"))
			{
				//5125 Start.
				//strBuff_QueryString.append(strBuff_OPQueryString.toString());
				strBuff_QueryString.append(oPQueryStirng);
				//51215 End.
				strBuff_QueryString.append(" UNION ALL ");
				strBuff_QueryString.append(strBuff_IPQueryString.toString());

			}
			else if(locationType.equals("OP")){
				//51215 Start.
				//strBuff_QueryString.append(strBuff_OPQueryString.toString());
				strBuff_QueryString.append(oPQueryStirng);
				//51215 End.
			}
			else if(locationType.equals("IP")){
				strBuff_QueryString.append(strBuff_IPQueryString.toString());		
			}
			else if(locationType.equals("EM")){
				//51215 Start.
				//strBuff_QueryString.append(strBuff_OPQueryString.toString());
				strBuff_QueryString.append(oPQueryStirng);
				//51215 End.
			}
			else if(locationType.equals("DC")){
				strBuff_QueryString.append(strBuff_IPQueryString.toString());
			}

			String desc="";
			if(reOrder.equals("2"))
			{
				desc=" desc";

			}
			if(orderBy.equals("PC"))
			{
				strBuff_QueryString.append(" Order By episode_type_desc ");
				strBuff_QueryString.append(desc);
			}
			else if(orderBy.equals("LOC"))
			{
				strBuff_QueryString.append(" Order By locn_name ");
				strBuff_QueryString.append(desc);
			}
			else if(orderBy.equals("PN"))
			{
				strBuff_QueryString.append(" Order By PATIENT_NAME ");
				strBuff_QueryString.append(desc);
			}
			else if(orderBy.equals("SAP"))
			{
				strBuff_QueryString.append(" Order By splty_name ");
				strBuff_QueryString.append(desc);
			}
			else if(orderBy.equals("DOB"))
			{
				strBuff_QueryString.append(" Order By actual_dob ");
				strBuff_QueryString.append(desc);
			}
			else if(orderBy.equals("AGE"))
			{
				if(reOrder.equals("1"))
				{
					strBuff_QueryString.append(" Order By actual_dob desc ");
				}
				else
				{
					strBuff_QueryString.append(" Order By actual_dob ");
				}
			}
			else if(orderBy.equals("SEX"))
			{
				//strBuff_QueryString.append(" Order By 7 ");sex
				//strBuff_QueryString.append(desc);
				//ML-MMOH-SCF-2712----Start
				if(reOrder.equals("1"))
				{
					strBuff_QueryString.append(" Order By sex desc ");
				}
				else
				{
					strBuff_QueryString.append(" Order By sex ");
				}
				//ML-MMOH-SCF-2712-end
			}
			else if(orderBy.equals("PID"))
			{
				strBuff_QueryString.append(" Order By 3 ");
				strBuff_QueryString.append(desc);
			}
			else if(orderBy.equals("AD"))
			{
				strBuff_QueryString.append(" Order By adm_date1 ");
				strBuff_QueryString.append(desc);
			}
			else if(orderBy.equals("RN"))
			{
				//strBuff_QueryString.append(" Order By 12 ");
				//strBuff_QueryString.append(desc);
				//ML-MMOH-SCF-2712----Start
				if(reOrder.equals("1"))
				{
					strBuff_QueryString.append(" Order By room_num desc ");
				}
				else
				{
					strBuff_QueryString.append(" Order By room_num ");
				}
				//ML-MMOH-SCF-2712-end
			}
			else if(orderBy.equals("BN"))
			{
				//strBuff_QueryString.append(" Order By 13 ");bed_num
				//strBuff_QueryString.append(desc);
				//ML-MMOH-SCF-2712----Start
				if(reOrder.equals("1"))
				{
					strBuff_QueryString.append(" Order By bed_num desc ");
				}
				else
				{
					strBuff_QueryString.append(" Order By bed_num ");
				}
				//ML-MMOH-SCF-2712-end
			}
			else if(orderBy.equals("RID"))
			{
				strBuff_QueryString.append(" Order By referral_id ");
				strBuff_QueryString.append(desc);
			}
			else if(orderBy.equals("AP"))
			{
				strBuff_QueryString.append(" Order By physician_name ");
				strBuff_QueryString.append(desc);
			}
			else if(orderBy.equals("MS"))
			{
				strBuff_QueryString.append(" Order By splty_name ");
				strBuff_QueryString.append(desc);
			}
			else if(orderBy.equals("RS"))
			{
				strBuff_QueryString.append(" order By STATUS ");
				strBuff_QueryString.append(desc);
			}
			else if(orderBy.equals("AT"))
			{
				strBuff_QueryString.append(" Order By appt_time ");
				strBuff_QueryString.append(desc);
			}
			else if(orderBy.equals("QN"))
			{
				strBuff_QueryString.append(" Order By lpad(queue_num,6,0) ");
				strBuff_QueryString.append(desc);
			}
			//ML-MMOH-CRF-2069.1 start
			else if(orderBy.equals("QN2"))
			{
				//strBuff_QueryString.append("  Order By lpad(secondary_triage_queue_no, 10, '0') ");
				strBuff_QueryString.append("  Order By TO_NUMBER(secondary_triage_queue_no) ");
				strBuff_QueryString.append(desc);
			}
			//ML-MMOH-CRF-2069.1 end
			else if(orderBy.equals("VT"))
			{
				// Uncommented by USH
				strBuff_QueryString.append(" Order By visit_type ");
				strBuff_QueryString.append(desc);
			}
			else if(orderBy.equals("VD"))
			{
				// Uncommented by USH
				strBuff_QueryString.append(" Order By orderbydate ");
				strBuff_QueryString.append(desc);
			}
			else if(orderBy.equals("QS"))
			{
				strBuff_QueryString.append(" Order By queue_status");
				strBuff_QueryString.append(desc);
			}
			else if(orderBy.equals("DD"))
			{
				//strBuff_QueryString.append(" Order By discharge_date_time");
				//strBuff_QueryString.append(desc);
				//57998-----Start
				if(reOrder.equals("1"))
				{
					strBuff_QueryString.append(" Order By a.discharge_date_time desc ");
				}
				else
				{
					strBuff_QueryString.append(" Order By a.discharge_date_time");
				}
						//57998-----end		
			}
			else if(orderBy.equals("IQS"))  // added for queue status for IP and DC
			{
			//	strBuff_QueryString.append(" Order by queue_status ");
			//	strBuff_QueryString.append(desc);
				if(reOrder.equals("1"))
				{
					strBuff_QueryString.append(" Order By visit_episode_status  desc ");
				}
				else
				{
					strBuff_QueryString.append(" Order By visit_episode_status ");
				}
				//ML-MMOH-SCF-2712-end
			}
			else if(orderBy.equals("PDA")) //added for Pre Discharge Advice Sorting in Alphabetical order for IN064342
			{
				strBuff_QueryString.append(" Order by pre_disg_advice_yn ");
				strBuff_QueryString.append(desc);
			}
			else if(groupByEpisode.equals("N") && groupByLocn.equals("N"))
			{
				if (sortOrder.equals("v"))
				{
					strBuff_QueryString.append("Order By orderbydate"); 
				}
				else if(sortOrder.equals("p"))
				{
					strBuff_QueryString.append(" Order By 4 ");
				}
				//out.println(strBuff_QueryString);
			}
			else if(groupByEpisode.equals("Y") && groupByLocn.equals("N"))
			{
				if (sortOrder.equals("v"))
				{
					strBuff_QueryString.append(" Order By lpad(queue_num,6,0),cls_cons_date,2 desc,orderbydate,28 ,4");
				}else if(sortOrder.equals("p"))
				{
					strBuff_QueryString.append(" Order By lpad(queue_num,6,0),cls_cons_date,2 desc,4,28,orderbydate");
				}
			}
			else 
			{
				if (sortOrder.equals("v"))
				{
					strBuff_QueryString.append(" Order By lpad(queue_num,6,0),cls_cons_date,2 desc,orderbydate,28 ,4");
				}else if(sortOrder.equals("p"))
				{
					strBuff_QueryString.append(" Order By lpad(queue_num,6,0),cls_cons_date,2 desc,4,28,orderbydate");
				}
			}
		
			stmtPatList = con.prepareStatement(strBuff_QueryString.toString());	
			
			if(locn_type.equals("RP"))
			{			
				int count=0;
				stmtPatList.setString(++count,clinicianId);
				stmtPatList.setString(++count,locale);
				stmtPatList.setString(++count,locale);
				stmtPatList.setString(++count,locale);
				stmtPatList.setString(++count,locale);
				stmtPatList.setString(++count,facility_id);
				//IN048704
				//stmtPatList.setString(++count,clinicianId);
				if(assign_confirm_referral_yn.equals("Y"))
				{	
					if("N".equals(unscheduledyn))
					{
						stmtPatList.setString(++count,clinicianId);
					}
					else if("Y".equals(unscheduledyn)){
						stmtPatList.setString(++count,clinicianId);
						stmtPatList.setString(++count,clinicianId);
						stmtPatList.setString(++count,facility_id);
						stmtPatList.setString(++count,clinicianId);
					}
				}
				else
				{
					stmtPatList.setString(++count,clinicianId);
				}
				//IN048704
				if(relnreqyn.equals("Y"))
				{
					if(!assign_confirm_referral_yn.equals("Y")){//IN048704
						stmtPatList.setString(++count,facility_id);
						stmtPatList.setString(++count,clinicianId);
					}//IN048704
				}
				if(!locationType.equals("Z"))
					stmtPatList.setString(++count,locationType);
				if(!patientId.equals(""))
					stmtPatList.setString(++count,patientId);
				stmtPatList.setString(++count,clinicianId);//32902
				//start 49654
				if(restrictedPractPosition.equals("Y") && attend_practId.equals("") && viewList.equals("Z"))
				{
					stmtPatList.setString(++count,clinicianId);
					stmtPatList.setString(++count,facility_id);
					stmtPatList.setString(++count,clinicianId);
				}
				//end 49654
			}
			else if(locationType.equals("Z"))
			{				
				int count=0;
				stmtPatList.setString(++count,locale);
				stmtPatList.setString(++count,facility_id);
				stmtPatList.setString(++count,locale);
				stmtPatList.setString(++count,locale);
				stmtPatList.setString(++count,locale);
				stmtPatList.setString(++count,clinicianId);
				stmtPatList.setString(++count,facility_id);
				stmtPatList.setString(++count,locale);
				stmtPatList.setString(++count,facility_id);
				if (!patientId.equals(""))
					stmtPatList.setString(++count,patientId);
				if (!nationID.equals(""))
				stmtPatList.setString(++count,nationID);
				if (!queueId.equals(""))
				stmtPatList.setString(++count,queueId);
				
				if (groupByEpisode.equals("Y"))
					stmtPatList.setString(++count,locationType);
				if (past.equals("N")||past.equals(""))
				{}
				else
				{
					if (!fromvisitdate.equals(""))
						stmtPatList.setString(++count,fromvisitdate);
					if (!tovisitdate.equals(""))
						stmtPatList.setString(++count,tovisitdate);
				}
				if(viewList.equals("S")) 
					 stmtPatList.setString(++count,clinicianId);
				if (!locationCode.equals("*ALL") )
					stmtPatList.setString(++count,locationCode);
				if(!attend_practId.equals(""))
					stmtPatList.setString(++count,attend_practId);
				if(!speciality.equals(""))
					stmtPatList.setString(++count,speciality);
				if(locationType.equals("OP"))
				{
					if(!visitType.equals(""))
						stmtPatList.setString(++count,visitType);
				}
				stmtPatList.setString(++count,clinicianId);//32902
				// start 49654
				if(restrictedPractPosition.equals("Y") && attend_practId.equals("") && viewList.equals("Z"))
				{
					stmtPatList.setString(++count,clinicianId);
					stmtPatList.setString(++count,facility_id);
					stmtPatList.setString(++count,clinicianId);
				}
				// end 49654
				stmtPatList.setString(++count,locale);
				stmtPatList.setString(++count,facility_id);
				stmtPatList.setString(++count,locale);
				stmtPatList.setString(++count,locale);
				stmtPatList.setString(++count,locale);
				//Modified by Archana on 12/3/2010 related to incident no IN025359.
				stmtPatList.setString(++count,locale);
				stmtPatList.setString(++count,clinicianId);
				
				stmtPatList.setString(++count,facility_id); //IN064342
				stmtPatList.setString(++count,facility_id);
				if (!patientId.equals(""))
					stmtPatList.setString(++count,patientId);
				if (!nationID.equals(""))
					stmtPatList.setString(++count,nationID);
				if (!queueId.equals(""))
					stmtPatList.setString(++count,queueId);
				if (groupByEpisode.equals("Y"))
				{
					stmtPatList.setString(++count,locationType);
				}		
				if (!locationCode.equals("*ALL") )
					stmtPatList.setString(++count,locationCode);
				
				if(viewList.equals("S")) 
				{
					stmtPatList.setString(++count,clinicianId);
				}
				if (!adm_fromdate.equals(""))
					stmtPatList.setString(++count,adm_fromdate);
				if (!adm_todate.equals(""))
					stmtPatList.setString(++count,adm_todate);
				
				if(!attend_practId.equals(""))
				{
					stmtPatList.setString(++count,attend_practId);
				}
				if(!speciality.equals(""))
				{
					stmtPatList.setString(++count,speciality);
				}
				stmtPatList.setString(++count,bedNo+"%");//IN29412
				stmtPatList.setString(++count,clinicianId);//32902
				// start 49654
				if(restrictedPractPosition.equals("Y") && attend_practId.equals("") && viewList.equals("Z"))
				{
					stmtPatList.setString(++count,clinicianId);
					stmtPatList.setString(++count,facility_id);
					stmtPatList.setString(++count,clinicianId);
				}
				// end  49654
			}
	 		else if(locationType.equals("OP") || locationType.equals("EM"))
			{
				int count=0;

				stmtPatList.setString(++count,locale);
				stmtPatList.setString(++count,facility_id);
				stmtPatList.setString(++count,locale);
				stmtPatList.setString(++count,locale);
				stmtPatList.setString(++count,locale);
				stmtPatList.setString(++count,clinicianId);
				//new shaiju
				stmtPatList.setString(++count,facility_id);
				stmtPatList.setString(++count,locale);
				// new shaiju
				stmtPatList.setString(++count,facility_id);
				if (!patientId.equals(""))
				{
					stmtPatList.setString(++count,patientId);
				}
				if (!nationID.equals(""))
				stmtPatList.setString(++count,nationID);
				if (!queueId.equals(""))
				stmtPatList.setString(++count,queueId);
				if (groupByEpisode.equals("Y"))
				{				
					stmtPatList.setString(++count,locationType);
				}
				if (past.equals("N")||past.equals(""))
				{
				}else
				{
					if (!fromvisitdate.equals(""))
					{					
						stmtPatList.setString(++count,fromvisitdate);
					}							
					if (!tovisitdate.equals(""))
					{
						stmtPatList.setString(++count,tovisitdate);
					}
				}
				if(viewList.equals("S")) 
				{
					 stmtPatList.setString(++count,clinicianId);
				}
				if (!locationCode.equals("*ALL") )
				{				
					stmtPatList.setString(++count,locationCode);
				}

				if(!attend_practId.equals(""))
				{				
					stmtPatList.setString(++count,attend_practId);
				}
				if(!speciality.equals(""))
				{
					stmtPatList.setString(++count,speciality);
				}
				if(locationType.equals("OP")){
					if(!visitType.equals(""))
					{
						stmtPatList.setString(++count,visitType);
					}
				}
				stmtPatList.setString(++count,clinicianId);//32902

				// start 49654
				if(restrictedPractPosition.equals("Y") && attend_practId.equals("") && viewList.equals("Z"))
				{
					stmtPatList.setString(++count,clinicianId);
					stmtPatList.setString(++count,facility_id);
					stmtPatList.setString(++count,clinicianId);
				}
				// end 49654
			}
			else if(locationType.equals("IP") || locationType.equals("DC"))
			{
				int count=0;
				stmtPatList.setString(++count,locale);
				stmtPatList.setString(++count,facility_id);
				stmtPatList.setString(++count,locale);
				stmtPatList.setString(++count,locale);
				stmtPatList.setString(++count,locale);
				stmtPatList.setString(++count,locale);
				stmtPatList.setString(++count,clinicianId);
				stmtPatList.setString(++count,facility_id); //IN064342
				stmtPatList.setString(++count,facility_id);
				if (!patientId.equals(""))
					stmtPatList.setString(++count,patientId);
				if (!nationID.equals(""))
				stmtPatList.setString(++count,nationID);
				if (!queueId.equals(""))
				stmtPatList.setString(++count,queueId);
				
				if (groupByEpisode.equals("Y"))
				{
					stmtPatList.setString(++count,locationType);
				}		
				if (!locationCode.equals("*ALL") )
					stmtPatList.setString(++count,locationCode);
				
				if(viewList.equals("S")) 
				{
					stmtPatList.setString(++count,clinicianId);
				}
				if (!adm_fromdate.equals(""))
					stmtPatList.setString(++count,adm_fromdate);						
				if (!adm_todate.equals(""))
					stmtPatList.setString(++count,adm_todate);
				
				if(!attend_practId.equals(""))
				{
					stmtPatList.setString(++count,attend_practId);
				}
				if(!speciality.equals(""))
				{
					stmtPatList.setString(++count,speciality);
				}
				
				stmtPatList.setString(++count,bedNo+"%");//IN29412
				stmtPatList.setString(++count,clinicianId);//32902
				// start 49654
				if(restrictedPractPosition.equals("Y") && attend_practId.equals("") && viewList.equals("Z"))
				{
					stmtPatList.setString(++count,clinicianId);
					stmtPatList.setString(++count,facility_id);
					stmtPatList.setString(++count,clinicianId);
				}
				// end 49654
			}
			rsPatList = stmtPatList.executeQuery();	
		
		}
		catch(Exception ex){
			ex.getMessage();
			ex.printStackTrace();
		}
	return rsPatList;
	}
	//MV_13012014 starts
	public String getMOInstallYN(Connection con)throws Exception
	{
		String qry_mo_install_yn = "select install_yn from sm_module where module_id='MO'";	
		String mo_install_yn = "";
		PreparedStatement stmtMotherLink = null;//CheckStyle fix
		ResultSet rsPatList = null;
		try
		{
			stmtMotherLink = con.prepareStatement(qry_mo_install_yn);

			rsPatList = stmtMotherLink.executeQuery();
			if(rsPatList.next())
			mo_install_yn = (rsPatList.getString("install_yn")==null?"":rsPatList.getString("install_yn"));
			if(rsPatList!=null)rsPatList.close();
			if(stmtMotherLink!=null)stmtMotherLink.close();
		}
		catch(Exception expMO){
		System.out.println("Exception in try of getMOInstallYN of PatListByLocationResult.java"+expMO.toString());
		expMO.printStackTrace();
		}
		
	return mo_install_yn;
	}
	
	public String getQueueDesc(Connection con,String facility_id,String encounterID) throws Exception
	{
	String queueDesc="";
	PreparedStatement pstmtForAEPat = null;//Checkstyle Fix
	ResultSet resForAEPat = null;//Checkstyle Fix
	pstmtForAEPat = con.prepareStatement("select b.short_desc from AE_PAT_EMERGENCY_DETAIL a, AE_PAT_PRIORITY b where a.FACILITY_ID=? AND a.ENCOUNTER_ID=? AND b.PRIORITY_CODE  = a.PAT_PRIORITY");
	try
	{
		pstmtForAEPat.setString(1,facility_id);
		pstmtForAEPat.setString(2,encounterID);

		resForAEPat = pstmtForAEPat.executeQuery();
						
		while(resForAEPat.next())
		{
			queueDesc = resForAEPat.getString(1) == null ? "&nbsp;" : resForAEPat.getString(1);
		}
		if(resForAEPat != null) resForAEPat.close();
		if(pstmtForAEPat != null) pstmtForAEPat.close();
		
	}
	catch(Exception eee)
	{
		System.out.println("Exception in try of getQueueDesc of PatListByLocationResult.java"+eee.toString());
		eee.printStackTrace();
		
	}
	
	return queueDesc;						
	}
	public String getSiteId(Connection con) throws Exception
	{
	String site_id = "";
	PreparedStatement pstmtForSite = null;//CheckStyle Fix
	ResultSet rsSite = null;//CheckStyle Fix
	try
	{
		pstmtForSite = con.prepareStatement("select site_id from sm_site_param");
		rsSite = pstmtForSite.executeQuery();
		if(rsSite.next())
			site_id = (rsSite.getString("site_id")==null?"":rsSite.getString("site_id"));

		if(rsSite!=null)rsSite.close();
		if(pstmtForSite!=null)pstmtForSite.close();		
		
	}
	catch(Exception expSI)
	{
		System.out.println("Exception in try of getSiteId of PatListByLocationResult.java"+expSI.toString());
		expSI.printStackTrace();
	}
	
	return site_id;						
	}
	//MV_13012014 ends
	// added for IN048463 - Start
	public String getLabel(PageContext pageContext,String lvalue){
		String label_desc ="";
		if(lvalue.equals("OP"))
			label_desc =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
		else if(lvalue.equals("IP"))
			label_desc =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
		else if(lvalue.equals("EM"))
			label_desc =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
		else if(lvalue.equals("DC"))
			label_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");

		else if(lvalue.equals("M") || lvalue.equals("Male") )
			label_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
		else if(lvalue.equals("F") || lvalue.equals("Female"))
			label_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
		//IN064836 starts
		//else if(lvalue.equals("U") || lvalue.equals("Unknown"))
		else if(lvalue.equals("Unknown"))
		//IN064836 ends
			label_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

		else if(lvalue.equals("C"))
			label_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.closed.label","common_labels");
		else if(lvalue.equals("O"))
			label_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.open.label","common_labels");
		else if(lvalue.equals("P"))
			label_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.PendingReferrals.label","ca_labels");
		else if(lvalue.equals("U"))
			label_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Unassigned.label","common_labels");
		
		return label_desc;
		
	}	
	public String getMultiBedSideReviewYN(String facilty_id) throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String  allow_muti_bedside_review_yn	= "N";
		try
		{
			connection =ConnectionManager.getConnection();
			pstmt = connection.prepareStatement("SELECT ALLOW_MUTI_BEDSIDE_REVIEW_YN FROM IP_PARAM WHERE FACILITY_ID = ?") ;
			pstmt.setString(1, facilty_id.trim());
			resultSet = pstmt.executeQuery() ;
			if(resultSet.next())
			{ 
				allow_muti_bedside_review_yn = resultSet.getString("ALLOW_MUTI_BEDSIDE_REVIEW_YN");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace() ;
		}
		finally
		{
			if(resultSet != null) resultSet.close();
			if(pstmt != null) pstmt.close();
			if(connection != null) connection.close();
		}
		return allow_muti_bedside_review_yn;	
	}
	// added for IN048463 - End
	//ML-MMOH-CRF-0362 [IN057201] - Start
	public String getReferralNoteFromPASYN(String facility_id) throws Exception{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String ca_record_referral_note_yn = "N";
		try
		{
			connection =ConnectionManager.getConnection();
			pstmt = connection.prepareStatement("SELECT CA_RECORD_REFERRAL_NOTE_YN FROM IP_PARAM WHERE FACILITY_ID = ?") ;
			pstmt.setString(1, facility_id.trim());
			resultSet = pstmt.executeQuery() ;
			if(resultSet.next())
			{ 
				ca_record_referral_note_yn = resultSet.getString("CA_RECORD_REFERRAL_NOTE_YN");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace() ;
		}
		finally
		{
			if(resultSet != null) resultSet.close();
			if(pstmt != null) pstmt.close();
			if(connection != null) connection.close();
		}
		return ca_record_referral_note_yn;
	}
	//ML-MMOH-CRF-0362 [IN057201] - End
	//MMS-QH-CRF-0204 [IN052254] - Start
	public String getRestrictUnsettledPatientYN() throws Exception{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String restrictUnsettledPatientYN = "N";
		try
		{
			connection =ConnectionManager.getConnection();
			pstmt = connection.prepareStatement("SELECT CA_REST_UNBILLED_PATIENT FROM CA_CONS_PARAM") ;			
			resultSet = pstmt.executeQuery() ;
			if(resultSet.next())
			{ 
				restrictUnsettledPatientYN = resultSet.getString("CA_REST_UNBILLED_PATIENT");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace() ;
		}
		finally
		{
			if(resultSet != null) resultSet.close();
			if(pstmt != null) pstmt.close();
			if(connection != null) connection.close();
		}
		return restrictUnsettledPatientYN;
	}
	//MMS-QH-CRF-0204 [IN052254] - End
	public String getLabelTxt(PageContext pageContext,String episode_type_desc, String queue_status, String visit_episode_status){
	
		if(episode_type_desc.equals("OP") || episode_type_desc.equals("EM")){
			if(queue_status.equals("01"))
				queue_status =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CheckedIn.label","common_labels");
			else if(queue_status.equals("02"))
				queue_status =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ArrivedatNS.label","ca_labels");
			else if(queue_status.equals("03"))
				queue_status =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.VitalSignRecorded.label","op_labels");
			else if(queue_status.equals("04"))
				queue_status = 		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ConsultationInProgress.label","op_labels");
			else if(queue_status.equals("05"))
				queue_status = 		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Treat/Invest.label","common_labels");
			else if(queue_status.equals("06"))
				queue_status = 		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ReturnfromInvest.label","ca_labels");
			else if(queue_status.equals("07"))
				queue_status =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CheckedOut.label","common_labels");
			else if(queue_status.equals(" "))
				queue_status = "&nbsp;";
		}else if(episode_type_desc.equals("IP") || episode_type_desc.equals("DC")){
			if(visit_episode_status.equals("BA"))
				queue_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.BedAssigned.label","ca_labels");
			else if(visit_episode_status.equals("DS"))
				queue_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.discharged.label","common_labels");
			else if(visit_episode_status.equals("DR"))
				queue_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.DiagnosisRec.label","ca_labels");
			else if(visit_episode_status.equals("AP"))
				queue_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.DAPrepared.label","ca_labels");
			else if(visit_episode_status.equals("AD"))
				queue_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Admitted.label","common_labels");
			else
				queue_status = "&nbsp;";
		}
		
		return queue_status;
		
	}	
	//Ading start for IN072994
	public ArrayList getScanCountReqForPatientClass(String patient_class,String function_id) throws Exception{
        Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList scanCountSetup    = new ArrayList();

		try
		{
			connection =ConnectionManager.getConnection();
			pstmt = connection.prepareStatement("SELECT SCAN_REQUIRED_YN,ALERT_REQUIRED_YN,REMARKS_REQUIRED_YN FROM PR_BARCODE_SCAN_SETUP WHERE FUNCTION_ID = ? AND PATIENT_CLASS =? ") ;
			pstmt.setString(1, function_id.trim());
			pstmt.setString(2, patient_class.trim());
			resultSet = pstmt.executeQuery() ;
			if(resultSet.next())
			{ 
				scanCountSetup.add(resultSet.getString("SCAN_REQUIRED_YN")==null?"N":resultSet.getString("SCAN_REQUIRED_YN"));
				scanCountSetup.add(resultSet.getString("ALERT_REQUIRED_YN")==null?"N":resultSet.getString("ALERT_REQUIRED_YN"));
				scanCountSetup.add(resultSet.getString("REMARKS_REQUIRED_YN")==null?"N":resultSet.getString("REMARKS_REQUIRED_YN"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace() ;
		}
		finally
		{
			if(resultSet != null) resultSet.close();
			if(pstmt != null) pstmt.close();
			if(connection != null) connection.close();
		}
		return scanCountSetup;	
		
	}//Ading end for IN072994

////ML-MMOH-CRF-2069.1 start 
	public String getQueueno(Connection con, String facility_id) throws Exception {
		String queueNo = "";
		PreparedStatement pstmtForEPat = null;// Checkstyle Fix
		ResultSet resForEPat = null;// Checkstyle Fix

		try {
			pstmtForEPat = con.prepareStatement("SELECT QUEUE_NO_LISTBYLOCA_YN FROM CA_PARAM");
			resForEPat = pstmtForEPat.executeQuery();

			while (resForEPat.next()) {
				queueNo = resForEPat.getString(1) == null ? "&nbsp;" : resForEPat.getString(1);
			}
			if (resForEPat != null)
				resForEPat.close();
			if (pstmtForEPat != null)
				pstmtForEPat.close();

		} catch (Exception eee) {
			System.out.println("Exception in try of getQueueno of PatListByLocationResult.java" + eee.toString());
			eee.printStackTrace();
		}
		return queueNo;
	}
	
	public String getQueueSecondary(Connection con, String facility_id) throws Exception {
		String queueSecondary = "";
		PreparedStatement pstmtForEPat = null;// Checkstyle Fix
		ResultSet resForEPat = null;// Checkstyle Fix

		try {
			pstmtForEPat = con.prepareStatement("select QUEUE_SECONDARY_TRIAGE from ae_param where OPERATING_FACILITY_ID=?");
			pstmtForEPat.setString(1,facility_id);
			resForEPat = pstmtForEPat.executeQuery();

			while (resForEPat.next()) {
				queueSecondary = resForEPat.getString(1) == null ? "&nbsp;" : resForEPat.getString(1);
			}
			if (resForEPat != null)
				resForEPat.close();
			if (pstmtForEPat != null)
				pstmtForEPat.close();

		} catch (Exception eee) {
			System.out.println("Exception in try of getQueueno of PatListByLocationResult.java" + eee.toString());
			eee.printStackTrace();
		}
		return queueSecondary;
	}
	////ML-MMOH-CRF-2069.1 end

	public int getMenstPatCount(Connection con, String patient_id) throws Exception { //70705 Start
		int p_count = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(" SELECT COUNT(patient_id) AS p_count FROM ca_mens_his_trans_dtl WHERE event_status != 'E' and patient_id = ? ");
			pstmt.setString(1,patient_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				p_count = rs.getInt(1);
			}
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return p_count;
	} //70705 End
}