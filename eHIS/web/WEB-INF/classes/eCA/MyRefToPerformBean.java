/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History      	Name        	Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------
01/02/2018	  IN062606		  Sharanraj 	    01/02/2018      Ramesh  	    ML-MMOH-CRF-0726
-------------------------------------------------------------------------------------------------------------------------------
*/
package eCA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import eCommon.Common.*;
import webbeans.eCommon.*; 


public class MyRefToPerformBean extends CommonAdapter implements java.io.Serializable  {
	public ArrayList getMyrefDetails(String clinicianId,String locale,String facilityId,String search,String from_date,String to_date,String patientid,String orderBy,String reOrder,String anchorID) throws Exception {
		Connection connection 		= null;	
		PreparedStatement pstmt1 = null;
		ResultSet rs1 = null;
		ArrayList allEventCode =  new ArrayList();
		StringBuffer sql = new StringBuffer();
		
		String desc="";
		try
		{
			connection =  ConnectionManager.getConnection();
			if (search.equals("C")) {
				sql.append("SELECT A.referral_date,B.PATIENT_NAME, A.referral_id,  A.BEDSIDE_REF_REVIEW_STATUS, CA_REF_LETTER_NOTES_REC_YN, CA_GET_AGE_IN_HRS (b.date_of_birth,b.DECEASED_DATE) AGE, decode(B.SEX, 'M','Male','F','Female','U','Unknown','') sex, A.PATIENT_ID, case when a.status ='C' THEN 'C' when open_chart_yn='N' then 'P' when A.unAssigned_yn='N' THEN 'U' ELSE A.STATUS END  STATUS, A.unAssigned_yn, B.DATE_OF_BIRTH actual_dob, C.PATIENT_CLASS, C.ENCOUNTER_ID EPISODE_ID,A.FACILITY_ID FACILITY_ID, CA_GET_PATIENT_CURR_STATUS(C.FACILITY_ID,C.PATIENT_ID,C.ENCOUNTER_ID,C.PATIENT_CLASS,?)  patient_status, C.PRIORITY_ZONE,  C.ASSIGN_CARE_LOCN_CODE, case when C.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(C.FACILITY_ID, C.ASSIGN_CARE_LOCN_CODE,?,'2') else op_get_desc.op_clinic(C.FACILITY_ID, C.ASSIGN_CARE_LOCN_CODE,?,'2') end  LOCATION_DETAILS, to_char(C.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') visit_adm_date, to_char(C.DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') DISCHARGE_DATE_TIME, to_char(SYSDATE,'hh24:mi:ss') QRYTIME, C.ASSIGN_BED_NUM  BED_NO, C.ASSIGN_ROOM_NUM  ROOM_NO, C.ATTEND_PRACTITIONER_ID, NVL (am_get_desc.am_practitioner (C.ATTEND_PRACTITIONER_ID, ?, '2'), '') attend_pract_name, A.confirm_yn, A.open_chart_yn,ca_ae_get_priority_zone_color(C.PRIORITY_ZONE,'en') ae_zone_color,A.BEDSIDE_REFERRAL_YN  FROM (SELECT referral_date,REFERRAL_ID, BEDSIDE_REF_REVIEW_STATUS, FROM_FACILITY_ID FACILITY_ID, patient_id, NVL(CLOSE_ENCOUNTER_ID,FROM_ENCOUNTER_ID) ENCOUNTER_ID, STATUS, nvl2(TO_PRACT_ID,'Y','N') unAssigned_yn, (Case when BEDSIDE_REFERRAL_YN = 'Y' OR CLOSE_ENCOUNTER_ID is not null  then 'Y' else 'N' end ) open_chart_yn, (Case when STATUS='C' then 'N' else 'Y' end)   confirm_yn,BEDSIDE_REFERRAL_YN, CA_REF_LETTER_NOTES_REC_YN FROM PR_REFERRAL_REGISTER WHERE TO_FACILITY_ID = ? AND REFERRAL_DATE BETWEEN TO_DATE(?,'dd/mm/yyyy') AND TO_DATE(?,'dd/mm/yyyy')+.9999 and 'Y'= CA_GET_REF_STATUS(referral_date) AND PATIENT_ID = NVL('',PATIENT_ID) AND FROM_PRACT_ID = ? and status='O') A , MP_PATIENT B , PR_ENCOUNTER C WHERE B.PATIENT_ID = A.PATIENT_ID AND C.FACILITY_ID(+) = A.FACILITY_ID AND C.ENCOUNTER_ID(+) = A.ENCOUNTER_ID");
			} else {
				sql.append("SELECT A.referral_date,B.PATIENT_NAME, A.referral_id,  A.BEDSIDE_REF_REVIEW_STATUS, CA_REF_LETTER_NOTES_REC_YN, CA_GET_AGE_IN_HRS (b.date_of_birth,b.DECEASED_DATE) AGE, decode(B.SEX, 'M','Male','F','Female','U','Unknown','') sex, A.PATIENT_ID, case when a.status ='C' THEN 'C' when open_chart_yn='N' then 'P' when A.unAssigned_yn='N' THEN 'U' ELSE A.STATUS END  STATUS, A.unAssigned_yn, B.DATE_OF_BIRTH actual_dob, C.PATIENT_CLASS, C.ENCOUNTER_ID EPISODE_ID,A.FACILITY_ID FACILITY_ID, CA_GET_PATIENT_CURR_STATUS(C.FACILITY_ID,C.PATIENT_ID,C.ENCOUNTER_ID,C.PATIENT_CLASS,?)  patient_status, C.PRIORITY_ZONE,  C.ASSIGN_CARE_LOCN_CODE, case when C.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(C.FACILITY_ID, C.ASSIGN_CARE_LOCN_CODE,?,'2') else op_get_desc.op_clinic(C.FACILITY_ID, C.ASSIGN_CARE_LOCN_CODE,?,'2') end  LOCATION_DETAILS, to_char(C.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') visit_adm_date, to_char(C.DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') DISCHARGE_DATE_TIME, to_char(SYSDATE,'hh24:mi:ss') QRYTIME, C.ASSIGN_BED_NUM  BED_NO, C.ASSIGN_ROOM_NUM  ROOM_NO, C.ATTEND_PRACTITIONER_ID, NVL (am_get_desc.am_practitioner (C.ATTEND_PRACTITIONER_ID, ?, '2'), '') attend_pract_name, A.confirm_yn, A.open_chart_yn,ca_ae_get_priority_zone_color(C.PRIORITY_ZONE,'en') ae_zone_color,A.BEDSIDE_REFERRAL_YN  FROM (SELECT referral_date,REFERRAL_ID, BEDSIDE_REF_REVIEW_STATUS, FROM_FACILITY_ID FACILITY_ID, patient_id, NVL(CLOSE_ENCOUNTER_ID,FROM_ENCOUNTER_ID) ENCOUNTER_ID, STATUS, nvl2(TO_PRACT_ID,'Y','N') unAssigned_yn, (Case when BEDSIDE_REFERRAL_YN = 'Y' OR CLOSE_ENCOUNTER_ID is not null  then 'Y' else 'N' end ) open_chart_yn, (Case when STATUS='C' then 'N' else 'Y' end)   confirm_yn,BEDSIDE_REFERRAL_YN, CA_REF_LETTER_NOTES_REC_YN FROM PR_REFERRAL_REGISTER WHERE TO_FACILITY_ID = ? AND referral_date BETWEEN trunc(SYSDATE - 7) AND SYSDATE AND 'Y' = CA_GET_REF_STATUS(referral_date) AND PATIENT_ID = NVL('',PATIENT_ID) AND FROM_PRACT_ID = ? and status='O' ) A , MP_PATIENT B , PR_ENCOUNTER C WHERE B.PATIENT_ID = A.PATIENT_ID AND C.FACILITY_ID(+) = A.FACILITY_ID AND C.ENCOUNTER_ID(+) = A.ENCOUNTER_ID");
			}
			if (!patientid.equals("")) {
				sql.append(" AND A.PATIENT_ID  = ?");
			}
			
		
			
			if(reOrder.equals("2"))
			{
				desc=" desc";
			}
			if(orderBy.equals("PC"))
			{
				sql.append(" Order By PATIENT_CLASS ");
				sql.append(desc);
			}
			else if(orderBy.equals("LOC"))
			{
				sql.append(" order By LOCATION_DETAILS ");
				sql.append(desc);
			}
			else if(orderBy.equals("PN"))
			{
				sql.append(" order By PATIENT_NAME ");
				sql.append(desc);
			}
			else if(orderBy.equals("AGE"))
			{
				if(reOrder.equals("1"))
				{
					sql.append(" order By actual_dob desc ");
				}
				else
				{
					sql.append(" order By actual_dob ");
				}
			}
			else if(orderBy.equals("SEX"))
			{
				sql.append(" order By sex ");
				sql.append(desc);
			}
			else if(orderBy.equals("PID"))
			{
				sql.append(" order By PATIENT_ID ");
				sql.append(desc);
			}
			else if(orderBy.equals("AD"))
			{
				sql.append(" order By VISIT_ADM_DATE_TIME ");
				sql.append(desc);
			}
			else if(orderBy.equals("RS"))
			{
				sql.append(" order By STATUS ");
				sql.append(desc);
			}
			else if(orderBy.equals("BN"))
			{
				sql.append(" order By BED_NO ");
				sql.append(desc);
			}
			else if(orderBy.equals("RID"))
			{
				sql.append(" order By referral_id ");
				sql.append(desc);
			}
			else if(orderBy.equals("AP"))
			{
				sql.append(" order By attend_pract_name ");
				sql.append(desc);
			}
			else if(orderBy.equals("DD"))
			{
				sql.append(" order By C.DISCHARGE_DATE_TIME");
				sql.append(desc);
			}
			else if(orderBy.equals("RN"))
			{
				sql.append(" order By ROOM_NO");
				sql.append(desc);
			}
			
			pstmt1 = connection.prepareStatement(sql.toString());
			pstmt1.setString(1, clinicianId);
			pstmt1.setString(2, locale);
			pstmt1.setString(3, locale);
			pstmt1.setString(4, locale);
			pstmt1.setString(5, facilityId);
			if (search.equals("C")) {
				pstmt1.setString(6, from_date);
				pstmt1.setString(7, to_date);
				pstmt1.setString(8, clinicianId);
			} else {
				pstmt1.setString(6, clinicianId);
			}
			if (!patientid.equals("")) {
				pstmt1.setString(9, patientid);
			}
			rs1 = pstmt1.executeQuery();
			while(rs1.next())
			{
				allEventCode.add(checkForNull(rs1.getString("PATIENT_CLASS"), ""));
				allEventCode.add(checkForNull(rs1.getString("STATUS"),""));
				allEventCode.add(checkForNull(rs1.getString("EPISODE_ID"),""));
				allEventCode.add(checkForNull(rs1.getString("FACILITY_ID"),""));
				allEventCode.add(checkForNull(rs1.getString("LOCATION_DETAILS"),""));
				allEventCode.add(checkForNull(rs1.getString("PATIENT_NAME"),""));
				allEventCode.add(checkForNull(rs1.getString("REFERRAL_ID"),""));
				allEventCode.add(checkForNull(rs1.getString("AGE"),""));
				allEventCode.add(checkForNull(rs1.getString("SEX"),""));
				allEventCode.add(checkForNull(rs1.getString("PATIENT_ID"),""));
				allEventCode.add(checkForNull(rs1.getString("VISIT_ADM_DATE"),""));
				allEventCode.add(checkForNull(rs1.getString("ROOM_NO"),""));
				allEventCode.add(checkForNull(rs1.getString("BED_NO"),""));
				allEventCode.add(checkForNull(rs1.getString("ATTEND_PRACT_NAME"),""));
				allEventCode.add(checkForNull(rs1.getString("patient_id"),""));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(rs1 !=null) rs1.close();
			if(pstmt1 !=null) pstmt1.close();
			if(connection != null) connection.close();
		}
		return allEventCode;
	}
}
