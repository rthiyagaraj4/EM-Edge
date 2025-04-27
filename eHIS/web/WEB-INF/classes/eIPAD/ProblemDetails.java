/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD;
import java.io.* ;
import java.util.* ;
import java.sql.*;

import javax.rmi.* ;
import javax.naming.* ;
import javax.servlet.*;
import javax.servlet.http.*;

import eIPAD.HealthObjects.* ;
import eCommon.Common.*;
import webbeans.eCommon.*;

public class ProblemDetails implements java.io.Serializable {
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;

	public List<Problem> getProblem(PatientContext oPatientContext) throws Exception {
		List<Problem> oProblemList = new ArrayList<Problem>() ;
		if(oPatientContext != null && oPatientContext.request != null)
		{
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			Statement stmt				= null;
			ResultSet resultSet 			= null;
			String locale = "en";
			StringBuffer sqlStr = new StringBuffer("");
			String facility_id= ""; //(String)session.getValue("facility_id");
			String clinicianId = "" ;//(String)session.getValue("ca_practitioner_id");
			String strPracType = "";
			String strRowCount = "";
			String strPatientId = "";
			String strEncounterId = "";
			HttpServletRequest request = oPatientContext.request;
			
			if(oPatientContext.sFacilityId  != null && !oPatientContext.sFacilityId.equals(""))
			{
				facility_id = oPatientContext.sFacilityId;
			}
			if(oPatientContext.sClinicianId != null && !oPatientContext.sClinicianId.equals("") )
			{
				clinicianId  = oPatientContext.sClinicianId;
			}
			if(oPatientContext.sPracType != null && !oPatientContext.sPracType.equals(""))
			{
				strPracType = oPatientContext.sPracType;
			}
			if(oPatientContext.sPatientId != null && !oPatientContext.sPatientId.equals(""))
			{
				strPatientId = oPatientContext.sPatientId;
			}
			if(oPatientContext.sEncounterId != null && !oPatientContext.sEncounterId.equals(""))
			{
				strEncounterId = oPatientContext.sEncounterId;
			}
			
			sqlStr.append("select Description,Accuracy,Severity,currenstate,count(*) over() TOTL_ROW_CNT from  ( (SELECT mr_get_desc.mr_term_code(a.term_set_id,a.term_code,'" + locale + "' , '2') Description,");
			sqlStr.append("(SELECT mr_get_desc.mr_accuracy(a.curr_accuracy_code,'" + locale + "', '2') short_desc  FROM MR_ACCURACY WHERE accuracy_code = a.curr_accuracy_code ) Accuracy,");
			sqlStr.append("DECODE(a.curr_severity,'D','Moderate','L','Mild','S','Severe','E','Extreme') Severity,'diagnosis' as currenstate FROM PR_DIAGNOSIS a, MR_TERM_SET b, MR_TERM_CODE c, PR_DIAGNOSIS_ENC_DTL e ");
			sqlStr.append("WHERE a.patient_id = '" + strPatientId + "' AND a.patient_id = e.patient_id AND a.term_set_id = e.term_set_id AND a.occur_srl_no = e.occur_srl_no AND a.term_code = e.term_code AND a.onset_facility_id = e.facility_id AND a.onset_encounter_id = e.encounter_id");
			sqlStr.append(" AND EXISTS (SELECT 1 FROM MR_TERM_SET_FOR_FACILITY WHERE facility_id ='" + facility_id  + "' AND term_set_id  = a.term_set_id ) AND EXISTS");
			sqlStr.append("(SELECT 1 FROM MR_TERM_SET_FOR_PRACT_TYPE WHERE pract_type = '" + strPracType + "'");
			sqlStr.append(" AND term_set_id =a.term_set_id ) AND EXISTS (SELECT 1 FROM MR_TERM_SET_FOR_SPECIALTY WHERE specialty_code IN (SELECT specialty_code FROM PR_ENCOUNTER WHERE facility_id = '" + facility_id + "'   AND encounter_id = '" + strEncounterId + "' ) AND term_set_id=a.term_set_id ) AND (EXISTS (SELECT 1 FROM MR_TERM_SET_FOR_PRACT ib");
			sqlStr.append(" WHERE practitioner_id= '" + clinicianId + "' AND term_set_id = a.term_set_id ) OR NOT EXISTS (SELECT 1 FROM MR_TERM_SET_FOR_PRACT WHERE practitioner_id = '" + clinicianId + "'   )) AND b.term_set_id(+) = a.term_set_id AND c.term_set_id(+) = a.term_set_id AND c.term_code(+)=a.term_code )");
			sqlStr.append(" UNION ");
			sqlStr.append("( SELECT A.complaint_desc Description,   null as Accuracy,   null as Severity, 'problems' as currenstate FROM ca_encntr_chief_complaint a");
			sqlStr.append(" WHERE a.facility_id= '" + facility_id + "' AND a.encounter_id = '" + strEncounterId + "' AND NOT EXISTS (SELECT 1 FROM PR_DIAGNOSIS_COMPL_ENC_DTL b WHERE   b.ENCOUNTER_ID = '" + strEncounterId + "' AND b.FACILITY_ID = '" + facility_id + "' AND b.complaint_id  =a.complaint_id ) ) ) a");
	
	
			
	
			try {
				    connection	= ConnectionManager.getConnection(request) ;
					if(connection != null)
					{
						stmt = connection.createStatement();
					}
					
				
					if(stmt != null)
						resultSet = stmt.executeQuery(sqlStr.toString());
					while ( resultSet != null && resultSet.next() ) {
						Problem oProblem = new Problem();
						oProblem.setsProblemDesc(((resultSet.getString("Description") != null) ?resultSet.getString("Description") : "")) ;
						oProblem.setsProblemAccuracy(((resultSet.getString("Accuracy") != null) ?resultSet.getString("Accuracy") : "")) ;
						oProblem.setsProblemSevereity(((resultSet.getString("Severity") != null) ?resultSet.getString("Severity") : ""));
						oProblem.setScurrenstate(((resultSet.getString("currenstate") != null) ?resultSet.getString("currenstate") : ""));
						oProblem.setsCount(((resultSet.getString("TOTL_ROW_CNT") != null) ?resultSet.getString("TOTL_ROW_CNT") : "0")) ;
						oProblemList.add(oProblem);
				}
			} catch ( Exception e )	{
				e.printStackTrace() ;
				throw e ;
			} finally {
					 if ( resultSet != null ) resultSet.close() ;	
					 if ( stmt != null ) stmt.close() ;
					 ConnectionManager.returnConnection(connection,request);
			 
			}
		}
		return oProblemList;
		
	}

	public List<Problem> getProblemDetails(PatientContext oPatientContext) throws Exception {
		List<Problem> oProblemList = new ArrayList<Problem>() ;
		if(oPatientContext != null && oPatientContext.request != null)
		{
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			Statement stmt				= null;
			ResultSet resultSet 			= null;
			String locale = "en";
			StringBuffer sqlStr = new StringBuffer("");
			String facility_id= ""; //(String)session.getValue("facility_id");
			String clinicianId = "" ;//(String)session.getValue("ca_practitioner_id");
			String strPracType = "";
			String strRowCount = "";
			String strPatientId = "";
			String strEncounterId = "";
			HttpServletRequest request = oPatientContext.request;
			
			if(oPatientContext.sFacilityId  != null && !oPatientContext.sFacilityId.equals(""))
			{
				facility_id = oPatientContext.sFacilityId;
			}
			if(oPatientContext.sClinicianId != null && !oPatientContext.sClinicianId.equals("") )
			{
				clinicianId  = oPatientContext.sClinicianId;
			}
			if(oPatientContext.sPracType != null && !oPatientContext.sPracType.equals(""))
			{
				strPracType = oPatientContext.sPracType;
			}
			if(oPatientContext.sPatientId != null && !oPatientContext.sPatientId.equals(""))
			{
				strPatientId = oPatientContext.sPatientId;
			}
			if(oPatientContext.sEncounterId != null && !oPatientContext.sEncounterId.equals(""))
			{
				strEncounterId = oPatientContext.sEncounterId;
			}
		   /*
			sqlStr.append("SELECT encounter_id, diagnosisproblem, description, recorded_by, added_date, onsetdate, datetime, severity, accuracy, status, currenstate ");	
			sqlStr.append("FROM ((SELECT NULL AS encounter_id, a.complaint_id diagnosisproblem, complaint_desc description, added_by_id recorded_by, added_date, TO_CHAR (a.added_date, 'dd/mm/yyyy hh24:mi') onsetdate, "); 
			sqlStr.append("NULL AS datetime, NULL AS severity, NULL AS accuracy, NULL AS status, 'problems' AS currenstate FROM ca_encntr_chief_complaint a WHERE a.facility_id = '" + facility_id  + "' AND a.encounter_id = '" + strEncounterId + "')");
			sqlStr.append(" UNION ");
			sqlStr.append("(SELECT e.encounter_id encounter_id, a.term_code diagnosisproblem, a.term_code_short_desc description, a.curr_practitioner_id recorded_by, e.recorded_date_time added_date, TO_CHAR (e.recorded_date_time, ");    
			sqlStr.append(" 'dd/mm/yyyy hh24:mi:ss') onsetdate, TO_CHAR (a.onset_date, 'dd/mm/yyyy') datetime, DECODE (a.curr_severity, 'D', 'Moderate', 'L', 'Mild', 'S', 'Severe', 'E', 'Extreme' ) severity, (SELECT mr_get_desc.mr_accuracy "); 
			sqlStr.append("(a.curr_accuracy_code, '" + locale + "', '2' ) short_desc FROM mr_accuracy WHERE accuracy_code = a.curr_accuracy_code) accuracy, DECODE (a.curr_status, 'A', 'Active', 'R', 'Resolved', 'X', 'Revoked', 'E', 'In Error' ) status, ");
			sqlStr.append("'diagnosis' AS currenstate FROM pr_diagnosis a, mr_term_set b, mr_term_code c, pr_diagnosis_enc_dtl e  WHERE a.patient_id = '" + strPatientId + "' AND a.patient_id = e.patient_id AND a.term_set_id = e.term_set_id AND a.occur_srl_no = e.occur_srl_no ");
			sqlStr.append("AND a.term_code = e.term_code AND a.onset_facility_id = e.facility_id AND a.onset_encounter_id = e.encounter_id AND EXISTS ( SELECT 1 FROM mr_term_set_for_facility WHERE facility_id = '" + facility_id  + "' AND term_set_id = a.term_set_id) AND EXISTS ( SELECT 1 ");
			sqlStr.append("FROM mr_term_set_for_pract_type WHERE pract_type = '" + strPracType + "' AND term_set_id = a.term_set_id) AND EXISTS ( SELECT 1 FROM mr_term_set_for_specialty WHERE specialty_code IN ( SELECT specialty_code FROM pr_encounter  WHERE facility_id = '" + facility_id  + "' AND encounter_id = '" + strEncounterId + "') ");
			sqlStr.append("AND term_set_id = a.term_set_id) AND ( EXISTS ( SELECT 1 FROM mr_term_set_for_pract ib WHERE practitioner_id = '" + clinicianId + "' AND term_set_id = a.term_set_id) OR NOT EXISTS (SELECT 1 FROM mr_term_set_for_pract WHERE practitioner_id = '" + clinicianId + "')) AND b.term_set_id(+) = a.term_set_id AND c.term_set_id(+) = a.term_set_id AND c.term_code(+) = a.term_code))");
			sqlStr.append("	ORDER BY added_date DESC ");	
			*/	
			sqlStr.append("SELECT encounter_id, diagnosisproblem, description, recorded_by, added_date, onsetdate, datetime, severity, accuracy, status, currenstate ");	
			sqlStr.append("FROM ((SELECT NULL AS encounter_id, a.complaint_id diagnosisproblem, complaint_desc description, added_by_id recorded_by, added_date, TO_CHAR (a.added_date, 'dd/mm/yyyy') onsetdate, "); 
			sqlStr.append("NULL AS datetime, NULL AS severity, NULL AS accuracy, NULL AS status, 'problems' AS currenstate FROM ca_encntr_chief_complaint a WHERE a.facility_id = '" + facility_id  + "' AND a.encounter_id = '" + strEncounterId + "')");
			sqlStr.append(" UNION ");
			sqlStr.append("(SELECT e.encounter_id encounter_id, a.term_code diagnosisproblem, a.term_code_short_desc description, a.curr_practitioner_id recorded_by, e.recorded_date_time added_date, TO_CHAR (a.onset_date, 'dd/mm/yyyy') onsetdate, TO_CHAR (e.recorded_date_time, ");    
			sqlStr.append(" 'dd/mm/yyyy hh24:mi:ss') datetime,  DECODE (a.curr_severity, 'D', 'Moderate', 'L', 'Mild', 'S', 'Severe', 'E', 'Extreme' ) severity, (SELECT mr_get_desc.mr_accuracy "); 
			sqlStr.append("(a.curr_accuracy_code, '" + locale + "', '2' ) short_desc FROM mr_accuracy WHERE accuracy_code = a.curr_accuracy_code) accuracy, DECODE (a.curr_status, 'A', 'Active', 'R', 'Resolved', 'X', 'Revoked', 'E', 'In Error' ) status, ");
			sqlStr.append("'diagnosis' AS currenstate FROM pr_diagnosis a, mr_term_set b, mr_term_code c, pr_diagnosis_enc_dtl e  WHERE a.patient_id = '" + strPatientId + "' AND a.patient_id = e.patient_id AND a.term_set_id = e.term_set_id AND a.occur_srl_no = e.occur_srl_no ");
			sqlStr.append("AND a.term_code = e.term_code AND a.onset_facility_id = e.facility_id AND a.onset_encounter_id = e.encounter_id AND EXISTS ( SELECT 1 FROM mr_term_set_for_facility WHERE facility_id = '" + facility_id  + "' AND term_set_id = a.term_set_id) AND EXISTS ( SELECT 1 ");
			sqlStr.append("FROM mr_term_set_for_pract_type WHERE pract_type = '" + strPracType + "' AND term_set_id = a.term_set_id) AND EXISTS ( SELECT 1 FROM mr_term_set_for_specialty WHERE specialty_code IN ( SELECT specialty_code FROM pr_encounter  WHERE facility_id = '" + facility_id  + "' AND encounter_id = '" + strEncounterId + "') ");
			sqlStr.append("AND term_set_id = a.term_set_id) AND ( EXISTS ( SELECT 1 FROM mr_term_set_for_pract ib WHERE practitioner_id = '" + clinicianId + "' AND term_set_id = a.term_set_id) OR NOT EXISTS (SELECT 1 FROM mr_term_set_for_pract WHERE practitioner_id = '" + clinicianId + "')) AND b.term_set_id(+) = a.term_set_id AND c.term_set_id(+) = a.term_set_id AND c.term_code(+) = a.term_code))");
			sqlStr.append("	ORDER BY added_date DESC ");	
			try {
				    connection	= ConnectionManager.getConnection(request) ;
					if(connection != null)
					{
						stmt = connection.createStatement();
					}
					
				
					if(stmt != null)
						resultSet = stmt.executeQuery(sqlStr.toString());
					while ( resultSet != null && resultSet.next() ) {
						
						
						
						Problem oProblem = new Problem();
						oProblem.setsEncounterID(((resultSet.getString("encounter_id") != null) ?resultSet.getString("encounter_id") : ""));
						oProblem.setsDiagnosisProblem(((resultSet.getString("diagnosisproblem") != null) ?resultSet.getString("diagnosisproblem") : "") );
						oProblem.setsProblemDesc(((resultSet.getString("description") != null) ?resultSet.getString("description") : "") );
						oProblem.setsPracName(((resultSet.getString("recorded_by") != null) ?resultSet.getString("recorded_by") : ""));
						oProblem.setsAddedDate(((resultSet.getString("added_date") != null) ?resultSet.getString("added_date") : ""));
						oProblem.setsOnsetDate(((resultSet.getString("onsetdate") != null) ?resultSet.getString("onsetdate") : ""));
						oProblem.setsDateTime(((resultSet.getString("datetime") != null) ?resultSet.getString("datetime") : ""));
                        oProblem.setsProblemSevereity(((resultSet.getString("severity") != null) ?resultSet.getString("severity") : ""));
						oProblem.setsProblemAccuracy(((resultSet.getString("accuracy") != null) ?resultSet.getString("accuracy") : ""));
						oProblem.setsStatus(((resultSet.getString("status") != null) ?resultSet.getString("status") : ""));
						oProblem.setScurrenstate(((resultSet.getString("currenstate") != null) ?resultSet.getString("currenstate") : ""));
						
						
						
						oProblemList.add(oProblem);
				}
			} catch ( Exception e )	{
				System.out.println(sqlStr.toString());
				e.printStackTrace() ;
				throw e ;
			} finally {
					 if ( resultSet != null ) resultSet.close() ;	
					 if ( stmt != null ) stmt.close() ;
					 ConnectionManager.returnConnection(connection,request);
			 
			}
		}
		return oProblemList;
		
	}
}
