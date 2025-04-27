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
public class PendingScheduleDetails implements java.io.Serializable{
	public List<PendingSchedules> getPendingSchedules(PatientContext oPatientContext) throws Exception {
		List<PendingSchedules> oPendingSchedulesList = new ArrayList<PendingSchedules>() ;
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
			sqlStr.append("SELECT appt_date_str,from_time_str,to_time_str,location_desc, resource_name, COUNT(*) OVER() TOTL_ROW_CNT FROM ");
			sqlStr.append("(SELECT   TO_CHAR (appt_date, 'DD/MM/YYYY') appt_date_str,TO_CHAR (appt_slab_from_time, 'HH24:MI') from_time_str,TO_CHAR (appt_slab_to_time, 'HH24:MI') to_time_str,");
			sqlStr.append(" (CASE WHEN a.clinic_code IS NOT NULL THEN op_get_desc.op_clinic (a.facility_id, a.clinic_code,'" + locale+ "','1' ) END ) location_desc,(CASE WHEN a.clinic_code IS NOT NULL ");
			sqlStr.append(" THEN (SELECT x.short_desc FROM am_speciality_lang_vw x, op_clinic y  WHERE x.speciality_code = y.speciality_code AND y.facility_id = a.facility_id AND y.clinic_code = a.clinic_code AND x.language_id = '" + locale+ "')");
			sqlStr.append(" END  ) speciality_desc,DECODE (resource_class,'P', 'Practitioner', 'R', 'Room','Others'  ) || '/'|| CASE WHEN resource_class = 'P' THEN am_get_desc.am_practitioner (practitioner_id, '" + locale+ "', '1') WHEN resource_class = 'R'");
			sqlStr.append(" THEN am_get_desc.am_facility_room (a.facility_id,a.practitioner_id,'" + locale+ "', '1' ) ELSE am_get_desc.am_resource (a.facility_id,a.practitioner_id,  '" + locale+ "','1') END resource_name, appt_ref_no, (SELECT COUNT (appt_ref_no) FROM oa_resource_for_appt ");
			sqlStr.append(" WHERE appt_ref_no = a.appt_ref_no AND oa_resource_for_appt.facility_id = a.facility_id)  sec_resource_cnt FROM oa_appt_vw a WHERE a.facility_id = '" + facility_id + "' AND a.patient_id = '" + strPatientId + "'  AND a.appt_date >= TRUNC (SYSDATE) AND ( ( order_id IS NOT NULL ");
			sqlStr.append(" AND EXISTS (  SELECT 1  FROM or_order_line WHERE order_id = a.order_id AND order_line_num = a.order_line_num AND order_line_status NOT IN ( SELECT order_status_code FROM or_order_status_code  WHERE order_status_type IN (SELECT order_status_type  FROM or_status_applicability  WHERE oper_or_group_ref = ");
			sqlStr.append(" 'EXT_COMPL_ORD') OR order_status_type IN ('99', '96', '97', '93'))) ) OR order_id IS NULL) AND appt_status = '1' ORDER BY a.appt_date, a.appt_slab_from_time)");
			try {
				    connection	= ConnectionManager.getConnection(request) ;
					if(connection != null)
					{
						stmt = connection.createStatement();
					}
					
				
					if(stmt != null)
						resultSet = stmt.executeQuery(sqlStr.toString());
					while ( resultSet != null && resultSet.next() ) {
						
						PendingSchedules oPendingSchedules = new PendingSchedules();
						
						oPendingSchedules.setsApptDate(((resultSet.getString("appt_date_str") != null) ?resultSet.getString("appt_date_str") : "") );
						oPendingSchedules.setsFromTime(((resultSet.getString("from_time_str") != null) ?resultSet.getString("from_time_str") : "") );
						oPendingSchedules.setsToTime(((resultSet.getString("to_time_str") != null) ?resultSet.getString("to_time_str") : "") );
						oPendingSchedules.setsLocationDesc(((resultSet.getString("location_desc") != null) ?resultSet.getString("location_desc") : "") );
						oPendingSchedules.setsResourceName(((resultSet.getString("resource_name") != null) ?resultSet.getString("resource_name") : "") );
						oPendingSchedules.setsPendingScheduleCount(((resultSet.getString("TOTL_ROW_CNT") != null) ?resultSet.getString("TOTL_ROW_CNT") : "") );
						oPendingSchedulesList.add(oPendingSchedules);
						
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
		return oPendingSchedulesList;
	}
	public List<PendingSchedules> getPendingSchedulesDetails(PatientContext oPatientContext) throws Exception {
		List<PendingSchedules> oPendingSchedulesList = new ArrayList<PendingSchedules>() ;
		if(oPatientContext != null && oPatientContext.request != null )
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
			//HttpSession session = oPatientContext.session;
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
			
			sqlStr.append("SELECT TO_CHAR (appt_date, 'DD/MM/YYYY') ||' ' || TO_CHAR (appt_slab_from_time, 'HH24:MI')  || ' to ' || TO_CHAR (appt_slab_to_time, 'HH24:MI') Date_Time, ");
			sqlStr.append(" DECODE (CARE_LOCN_TYPE_IND,'C', 'Clinic', 'D', 'Daycare Unit', 'E', 'Procedure Unit') || ' / '|| (CASE WHEN a.clinic_code IS NOT NULL THEN op_get_desc.op_clinic (a.facility_id, ");
			sqlStr.append(" a.clinic_code,'" + locale+ "','1') END ) location, DECODE (resource_class,'P','Practitioner','R','Room','Others')|| ' / '|| CASE WHEN resource_class = 'P' THEN am_get_desc.am_practitioner (practitioner_id, '" + locale+ "', '1') ");
			sqlStr.append(" WHEN resource_class = 'R' THEN am_get_desc.am_facility_room (a.facility_id,a.practitioner_id,'" + locale+ "','1' ) ELSE am_get_desc.am_resource (a.facility_id,a.practitioner_id,'" + locale+ "','1') END resource_name, ");
			sqlStr.append(" (CASE WHEN a.clinic_code IS NOT NULL THEN (SELECT x.short_desc FROM am_speciality_lang_vw x, op_clinic y WHERE x.speciality_code = y.speciality_code AND y.facility_id = a.facility_id ");
			sqlStr.append("	AND y.clinic_code = a.clinic_code AND x.language_id = '" + locale+ "') END	) speciality, A.VISIT_TYPE_SHORT_DESC Visit_Type, a.appt_ref_no Appoiment_Number FROM oa_appt_vw a WHERE a.facility_id = '" + facility_id + "' ");
			sqlStr.append("	AND a.patient_id = '" + strPatientId + "' AND a.appt_date >= TRUNC (SYSDATE) AND ( (order_id IS NOT NULL AND EXISTS (SELECT 1 FROM or_order_line WHERE order_id = a.order_id AND order_line_num = a.order_line_num ");	
			sqlStr.append(" AND order_line_status NOT IN (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN (SELECT order_status_type FROM or_status_applicability WHERE oper_or_group_ref = 'EXT_COMPL_ORD') ");			
			sqlStr.append(" OR order_status_type IN	('99', '96', '97', '93')))) OR order_id IS NULL	) AND appt_status = '1' ORDER BY a.appt_date, a.appt_slab_from_time ");
			
			
			
			
			try {
				    connection	= ConnectionManager.getConnection(request) ;
					if(connection != null)
					{
						stmt = connection.createStatement();
					}
					
				
					if(stmt != null)
						resultSet = stmt.executeQuery(sqlStr.toString());
					while ( resultSet != null && resultSet.next() ) {
						
						PendingSchedules oPendingSchedules = new PendingSchedules();
						oPendingSchedules.setsDateTime(((resultSet.getString("Date_Time") != null) ?resultSet.getString("Date_Time") : "")) ;
						oPendingSchedules.setsLocation(((resultSet.getString("location") != null) ?resultSet.getString("location") : "")) ;
						oPendingSchedules.setsResourceName(((resultSet.getString("resource_name") != null) ?resultSet.getString("resource_name") : "")) ;
						oPendingSchedules.setsSpeciality(((resultSet.getString("speciality") != null) ?resultSet.getString("speciality") : "")) ;
						oPendingSchedules.setsVisitType(((resultSet.getString("Visit_Type") != null) ?resultSet.getString("Visit_Type") : "") );
						oPendingSchedules.setsAppointmentNumber(((resultSet.getString("Appoiment_Number") != null) ?resultSet.getString("Appoiment_Number") : "")) ;		
						oPendingSchedulesList.add(oPendingSchedules);
						
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
		return oPendingSchedulesList;
	}
}
