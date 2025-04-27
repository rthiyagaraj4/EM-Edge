/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Rev.Date	Rev.Name 		Description
--------------------------------------------------------------------------------------------------------------
26/11/2014	IN050580		Nijitha 								MO-CRF-20080
05/12/2014	IN052859		Nijitha									MO-CRF-20080 						
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/
package eCA;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import eOR.Common.OrRepository;

import webbeans.eCommon.ConnectionManager;

public class CARefferralNotesBean implements Serializable{
	
	 private String encounter_id        		= null ;
	 private String patient_id          		= null ;
	 protected String locale;
	 private String clinician_id = null;
	 private String resp_id = null;
	 private String login_user_id = null;
	 private String other_unsigned_yn = null;
	 private String facility_id = null;
	 private String speciality_code = null;
	 private String status = null;
	 private String location_code = null;
	 private String period_from = null;
	 private String period_to = null;
	 private String forward_to_facility = null;
	 private String to_specialty_code = null;
	 private String patient_class = null;
	 private String referral_status =null;
	 
	 public String getreferralStatus() {
		return referral_status;
	}

	public void setReferralStatus(String referral_status) {
		this.referral_status = referral_status;
	} 
	 
	public String getpatientClass() {
		return patient_class;
	}

	public void setPatientClass(String patient_class) {
		this.patient_class = patient_class;
	}  
	 
	public String gettoSpecialityCode() {
		return to_specialty_code;
	}

	public void setToSpecialityCode(String to_specialty_code) {
		this.to_specialty_code = to_specialty_code;
	} 
	 
	public String getForwardToFacility() {
		return forward_to_facility;
	}

	public void setForwardToFacility(String forward_to_facility) {
		this.forward_to_facility = forward_to_facility;
	}
	  

	public String getEncounter_id() {
		return encounter_id;
	}

	public void setEncounter_id(String encounter_id) {
		this.encounter_id = encounter_id;
	}

	public String getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(String patient_id) {
		this.patient_id = patient_id;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getClinician_id() {
		return clinician_id;
	}

	public void setClinician_id(String clinician_id) {
		this.clinician_id = clinician_id;
	}

	public String getResp_id() {
		return resp_id;
	}

	public void setResp_id(String resp_id) {
		this.resp_id = resp_id;
	}

	public String getLogin_user_id() {
		return login_user_id;
	}

	public void setLogin_user_id(String login_user_id) {
		this.login_user_id = login_user_id;
	}

	public String getOther_unsigned_yn() {
		return other_unsigned_yn;
	}

	public void setOther_unsigned_yn(String other_unsigned_yn) {
		this.other_unsigned_yn = other_unsigned_yn;
	}

	public String getFacility_id() {
		return facility_id;
	}

	public void setFacility_id(String facility_id) {
		this.facility_id = facility_id;
	}

	public String getSpeciality_code() {
		return speciality_code;
	}

	public void setSpeciality_code(String speciality_code) {
		this.speciality_code = speciality_code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLocation_code() {
		return location_code;
	}

	public void setLocation_code(String location_code) {
		this.location_code = location_code;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public List getRefferalNotesForPract(String key){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<String> referralNotes = null;
		HashMap<String, List<String>> referralNotesMap = new HashMap<String, List<String>>();
		List<String> referralKey = new ArrayList();
		List referralData = new ArrayList();
		StringBuffer sql = new StringBuffer();
		
		int colIndex = 0;
		int recordCnt = 0;
		StringTokenizer request_date_time_new = null;		
		String dateVal = "";
		List referralNotesDate = new ArrayList();
		
		try {		
			sql.append(" SELECT c.note_type,ca_get_desc.ca_note_type (c.note_type, ?,'1') note_type_desc,nvl2(c.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, a.facility_id, a.accession_num,TO_CHAR (a.request_date_time, 'dd/mm/yyyy hh24:mi') request_date_time,decode(c.PATIENT_CLASS,'XT',get_patient.get_line_detail(c.patient_id,?), get_patient.get_line_detail (c.facility_id, c.encounter_id, ? ) ) pline, b.privilege_type, c.patient_id patient_id, c.encounter_id encounter_id, a.action_comment subject, DECODE (c.patient_class, 'OP', 'O', 'EM', 'O', 'I') episode_type, DECODE (a.action_type, 'RS', 'Response', 'RV', 'Request',  'SN','Pending Signature','Forwarded to Specialty' ) action_type, a.action_by_group_code action_group_code, a.action_by_type action_by_type, am_get_desc.am_speciality (a.action_by_group_code,?,1) action_group_desc,c.patient_class patient_class,c.event_status,action_by_id, a.request_by_id,a.action_status,SM_GET_DESC.SM_FACILITY_PARAM(a.facility_id,?,'1') facility_name ");
			if("REFFEREDTO".equals(key))
				sql.append(", am_get_desc.am_practitioner (a.action_by_id,?, '1' ) action_by_name ");
			if("REFFEREDFROM".equals(key))
				sql.append(", am_get_desc.am_practitioner (a.request_by_id,?, '1' ) request_by_name ");
			sql.append(" , CASE WHEN h.patient_class IN ('IP', 'DC') THEN ip_get_desc.ip_nursing_unit(h.facility_id,h.assign_care_locn_code,?,'1')ELSE op_get_desc.op_clinic (h.facility_id,h.assign_care_locn_code,?,'1') END loc,TO_CHAR(a.request_date_time,'YYYYMMDDHH24MI') rec,a.action_type actiontypecode");
			sql.append(" FROM ca_encntr_note_audit_log a, ca_encntr_note c,ca_note_type_for_resp b,pr_encounter h WHERE ");
			sql.append("  h.patient_id = c.patient_id AND h.encounter_id = c.encounter_id AND ");
			if("REFFEREDFROM".equals(key))
			{
				if(!"ALL".equals(clinician_id))
					sql.append(" a.action_by_id = ? ");
				else
					sql.append(" a.action_by_id IS NOT NULL ");
			}
			//IN052859 Starts
			if("REFFEREDFROM".equals(key))
			{
				sql.append("  AND NVL(a.action_BY_TYPE,' ') !='S' ");
			}
			//IN052859 Ends
			if("REFFEREDTO".equals(key))
			{
				if(!"ALL".equals(clinician_id))
					sql.append(" a.request_by_id = ? ");
				else
					sql.append(" a.request_by_id IS NOT NULL ");
			}	
			if (!"ALL".equals(to_specialty_code))
			{
				sql.append(" AND a.ACTION_BY_GROUP_CODE = ? ");
			}
			if("REFFEREDTO".equals(key))
			{
				if (!"ALL".equals(forward_to_facility))
				{
					sql.append(" AND NVL (a.fwd_to_fac_id,DECODE ((SELECT fwd_pract_ind FROM ca_note_type WHERE note_type = b.note_type), 'A', '*A','P','*A', a.facility_id)) in (?,'*A')");
				}
			}
			if("REFFEREDFROM".equals(key))
			{
				if (!"ALL".equals(facility_id))
				{
					sql.append(" AND a.facility_id = ? ");
				}
			}
			if (!"ALL".equals(location_code))
			{
				sql.append(" AND H.ASSIGN_CARE_LOCN_CODE = ? ");
			}
			if ("ALL".equals(status))
			{
				sql.append(" AND c.event_status in ('2','3','4','5') ");
			}
			else
			{
				sql.append(" AND c.event_status = ? ");
			}	
			sql.append(" and c.accession_num=a.accession_num AND b.note_type = c.note_type AND b.resp_id = ? ");

			if(!period_from.equals("") && (!period_to.equals("")))
			{
				sql.append( " and a.request_date_time between to_date(?,'DD/MM/YYYY hh24:mi') and to_date(?,'DD/MM/YYYY hh24:mi')+.9999 ");
			}
			sql.append(" and a.action_type in ('RV','RS','FS','SN') ");
			
			if(!patient_id.equals(""))
				sql.append( "and c.patient_id =? ");
			if(!"ALL".equals(patient_class))
				sql.append( "and c.patient_class =? ");
			
			if(!"ALL".equals(referral_status))
				sql.append( "and a.action_status =? ");			
				
				
			sql.append("UNION ");
			
			sql.append(" SELECT c.note_type,ca_get_desc.ca_note_type (c.note_type, ?,'1') note_type_desc,nvl2(c.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, a.facility_id, a.accession_num,TO_CHAR (a.request_date_time, 'dd/mm/yyyy hh24:mi') request_date_time,decode(c.PATIENT_CLASS,'XT',get_patient.get_line_detail(c.patient_id,?), get_patient.get_line_detail (c.facility_id, c.encounter_id, ? ) ) pline, b.privilege_type, c.patient_id patient_id, c.encounter_id encounter_id, a.action_comment subject, DECODE (c.patient_class, 'OP', 'O', 'EM', 'O', 'I') episode_type, DECODE (a.action_type, 'RS', 'Response', 'RV', 'Request', 'SN','Pending Signature','Forwarded to Specialty' ) action_type, a.action_by_group_code action_group_code, a.action_by_type action_by_type, am_get_desc.am_speciality (a.action_by_group_code,?,1) action_group_desc,c.patient_class patient_class,c.event_status,action_by_id, a.request_by_id,a.action_status,SM_GET_DESC.SM_FACILITY_PARAM(a.facility_id,?,'1') facility_name ");
			if("REFFEREDTO".equals(key))
				sql.append(", am_get_desc.am_practitioner (a.action_by_id,?, '1' ) action_by_name ");
			if("REFFEREDFROM".equals(key))
				sql.append(", am_get_desc.am_practitioner (a.request_by_id,?, '1' ) request_by_name ");
			sql.append(" , CASE WHEN h.patient_class IN ('IP', 'DC') THEN ip_get_desc.ip_nursing_unit(h.facility_id,h.assign_care_locn_code,?,'1')ELSE op_get_desc.op_clinic (h.facility_id,h.assign_care_locn_code,?,'1') END loc,TO_CHAR(a.request_date_time,'YYYYMMDDHH24MI') rec,a.action_type actiontypecode ");
			sql.append(" FROM ca_encntr_note_audit_log a, ca_encntr_note c,ca_note_type_for_resp b,pr_encounter h WHERE ");
			sql.append("  h.patient_id = c.patient_id AND h.encounter_id = c.encounter_id AND ");
			
			if("REFFEREDTO".equals(key))
			{
				sql.append(" a.action_by_group_code =(SELECT primary_speciality_code FROM am_practitioner WHERE practitioner_id = a.request_by_id )");
			}
			if("REFFEREDFROM".equals(key))
			{
				if(!"ALL".equals(clinician_id) && !"ALL".equals(speciality_code))
					sql.append(" ? =(SELECT primary_speciality_code FROM am_practitioner WHERE practitioner_id = ? )");
				else if(!"ALL".equals(speciality_code))
					sql.append(" ? =(SELECT primary_speciality_code FROM am_practitioner WHERE practitioner_id = a.action_by_id )");
				else if(!"ALL".equals(clinician_id))
					sql.append(" a.action_by_group_code =(SELECT primary_speciality_code FROM am_practitioner WHERE practitioner_id = ? )");
				else
					sql.append(" a.action_by_group_code =(SELECT primary_speciality_code FROM am_practitioner WHERE practitioner_id = a.action_by_id )");
			}	
			if("REFFEREDTO".equals(key))
			{
				if (!"ALL".equals(forward_to_facility))
				{
					sql.append(" AND NVL (a.fwd_to_fac_id,DECODE ((SELECT fwd_pract_ind FROM ca_note_type WHERE note_type = b.note_type), 'A', '*A','P','*A', a.facility_id)) in (?,'*A')");
				}
			}
			if("REFFEREDFROM".equals(key))
			{
				if (!"ALL".equals(facility_id))
				{
					sql.append(" AND a.facility_id = ? ");
				}
			}
			if (!"ALL".equals(location_code))
			{
				sql.append(" AND H.ASSIGN_CARE_LOCN_CODE = ? ");
			}
			if ("ALL".equals(status))
			{
				sql.append(" AND c.event_status in ('2','3','4','5') ");
			}
			else
			{
				sql.append(" AND c.event_status = ? ");
			}	
			sql.append(" and c.accession_num=a.accession_num AND b.note_type = c.note_type AND b.resp_id = ? ");

			if(!period_from.equals("") && (!period_to.equals("")))
			{
				sql.append( " and a.request_date_time between to_date(?,'DD/MM/YYYY hh24:mi') and to_date(?,'DD/MM/YYYY hh24:mi')+.9999 ");
			}
			sql.append(" and a.action_type in ('RV','RS','FS','SN') ");
			
			if(!patient_id.equals(""))
			sql.append( "and c.patient_id =? ");
			
			if(!"ALL".equals(patient_class))
				sql.append( "and c.patient_class =? ");
			
			if(!"ALL".equals(referral_status))
				sql.append( "and a.action_status =? ");	
				
			sql.append(" ORDER BY 25 desc ");
			
			con = ConnectionManager.getConnection() ;
			
			pstmt = con.prepareStatement(sql.toString());
		
			pstmt.setString(++colIndex,locale);
			pstmt.setString(++colIndex,locale);
			pstmt.setString(++colIndex,locale);
			pstmt.setString(++colIndex,locale);
			pstmt.setString(++colIndex,locale);
			pstmt.setString(++colIndex,locale);
			pstmt.setString(++colIndex,locale);
			pstmt.setString(++colIndex,locale);
			if(!"ALL".equals(clinician_id))
				pstmt.setString(++colIndex,clinician_id);
			if (!"ALL".equals(to_specialty_code))
			{
				pstmt.setString(++colIndex,to_specialty_code);
			}
			if("REFFEREDTO".equals(key))
			{
				if (!"ALL".equals(forward_to_facility))
				{
					pstmt.setString(++colIndex, forward_to_facility);
				}
			}
			if("REFFEREDFROM".equals(key))
			{
				if (!"ALL".equals(facility_id))
				{
					pstmt.setString(++colIndex, facility_id);
				}		
			}
			if (!"ALL".equals(location_code))
			{
				pstmt.setString(++colIndex, location_code);
			}
			if (!"ALL".equals(status))
			{
				pstmt.setString(++colIndex, status);
			}
			pstmt.setString(++colIndex, resp_id);
			pstmt.setString(++colIndex, period_from);
			pstmt.setString(++colIndex, period_to);
			if(!patient_id.equals(""))
			{		
				pstmt.setString(++colIndex,patient_id);
			}
			if(!"ALL".equals(patient_class))
				pstmt.setString(++colIndex,patient_class);
			if(!"ALL".equals(referral_status))
				pstmt.setString(++colIndex,referral_status);	
				
			pstmt.setString(++colIndex,locale);
			pstmt.setString(++colIndex,locale);
			pstmt.setString(++colIndex,locale);
			pstmt.setString(++colIndex,locale);
			pstmt.setString(++colIndex,locale);
			pstmt.setString(++colIndex,locale);
			pstmt.setString(++colIndex,locale);
			pstmt.setString(++colIndex,locale);
			if("REFFEREDFROM".equals(key))
			{
				if(!"ALL".equals(clinician_id) && !"ALL".equals(speciality_code))
				{
					pstmt.setString(++colIndex,speciality_code);
					pstmt.setString(++colIndex,clinician_id);
				}
				else if(!"ALL".equals(speciality_code))
				{
					pstmt.setString(++colIndex,speciality_code);
				}
				else if(!"ALL".equals(clinician_id))
				{
					pstmt.setString(++colIndex,clinician_id);
				}
			}
			if("REFFEREDTO".equals(key))
			{
				if (!"ALL".equals(forward_to_facility))
				{
					pstmt.setString(++colIndex, forward_to_facility);
				}
			}
			if("REFFEREDFROM".equals(key))
			{
				if (!"ALL".equals(facility_id))
				{
					pstmt.setString(++colIndex, facility_id);
				}			
			}	
			if (!"ALL".equals(location_code))
			{
				pstmt.setString(++colIndex, location_code);
			}
			if (!"ALL".equals(status))
			{
				pstmt.setString(++colIndex, status);
			}
			pstmt.setString(++colIndex, resp_id);
			pstmt.setString(++colIndex, period_from);
			pstmt.setString(++colIndex, period_to);
			if(!patient_id.equals(""))
			{		
				pstmt.setString(++colIndex,patient_id);
			}
			if(!"ALL".equals(patient_class))
				pstmt.setString(++colIndex,patient_class);
			
			if(!"ALL".equals(referral_status))
				pstmt.setString(++colIndex,referral_status);
				
			rs = pstmt.executeQuery();
			while (rs.next()) {
				recordCnt++;
				referralNotes = new ArrayList<String>();
				referralNotes.add(rs.getString("pline"));
				referralNotes.add(rs.getString("note_type_desc"));
				referralNotes.add(rs.getString("privilege_type"));
				referralNotes.add(rs.getString("patient_id"));
				if("REFFEREDTO".equals(key))
				{
					referralNotes.add(rs.getString("action_by_name"));
				}	
				else
				{
					referralNotes.add(rs.getString("request_by_name"));
				}
				referralNotes.add(rs.getString("request_by_id"));
				referralNotes.add(rs.getString("facility_name"));
				referralNotes.add(rs.getString("action_status"));
				referralNotes.add(rs.getString("encounter_id"));
				referralNotes.add(rs.getString("loc"));
				referralNotes.add(rs.getString("action_group_desc"));
				referralNotes.add(rs.getString("action_by_type"));
				referralNotes.add(rs.getString("facility_id"));
				referralNotes.add(rs.getString("action_type"));
				referralNotes.add(rs.getString("request_date_time"));
				referralNotes.add(rs.getString("event_status"));
				referralNotes.add(rs.getString("accession_num"));
				referralNotes.add(rs.getString("actiontypecode"));
				
				request_date_time_new = new StringTokenizer(rs.getString("request_date_time")," ");
				dateVal =  request_date_time_new.nextToken();
				
				if(!referralNotesMap.containsKey(dateVal))	
				{
					referralNotesDate = new ArrayList();
					referralNotesDate.add(referralNotes);
					referralNotesMap.put(dateVal, referralNotesDate);
					referralKey.add(dateVal);
				}
				else
				{
					referralNotesDate.add(referralNotes);
					referralNotesMap.put(dateVal, referralNotesDate);
				}
					
			}
			referralData.add(referralKey);
			referralData.add(referralNotesMap);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			ConnectionManager.returnConnection(con);
		}
		return referralData;
	}
	
	public ArrayList getFacilityDetails() throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList facilityDetails	= new ArrayList() ;
		try 
		{
				connection = ConnectionManager.getConnection() ;
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_ORDER_FACILITY_SELECT") ) ;
				pstmt.setString( 1, locale);
				pstmt.setString( 2, clinician_id );

				resultSet = pstmt.executeQuery() ;
				while(resultSet.next()) {
				    String record[] = new String[2];
				    record[0] = resultSet.getString( "facility_name" );
				    record[1] = resultSet.getString( "facility_id" ) ;
					facilityDetails.add(record)  ;

				}
		} catch( Exception e )	{
			System.err.println( "Error loading values from database FACILITY" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			resultSet.close() ;
			pstmt.close()  ;
			ConnectionManager.returnConnection(connection);
		}
		return facilityDetails;
	}
	
	 public  int getPatientIdLength()throws Exception{
			int pat_length 				= 0 ;
			Connection connection		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 		= null;

			try {
					connection = ConnectionManager.getConnection() ;
					pstmt				= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_PATIENT_ID_LENGTH") ) ;
					resultSet			= pstmt.executeQuery() ;

					while ( resultSet != null && resultSet.next() ){
						pat_length		= resultSet.getInt( "patient_id_length" )  ;
					}
				} catch ( Exception e )	{
				e.printStackTrace() ;
				throw e ;
			} finally {
				resultSet.close() ;
				pstmt.close()  ;
				ConnectionManager.returnConnection(connection);
			}
			return pat_length ;
		}
	
	public String getPeriod_from() {
		return period_from;
	}

	public void setPeriod_from(String period_from) {
		this.period_from = period_from;
	}

	public String getPeriod_to() {
		return period_to;
	}

	public void setPeriod_to(String period_to) {
		this.period_to = period_to;
	}
		
}
