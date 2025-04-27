/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 *  
 */
package eIPAD.chartsummary.pendingschedule.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import eIPAD.chartsummary.pendingschedule.dao.PendingScheduleDAO;
import eIPAD.chartsummary.pendingschedule.healthobject.PendingScheduleHO;
import eIPAD.chartsummary.pendingschedule.request.PendingScheduleRequest;
import eIPAD.chartsummary.pendingschedule.response.PendingScheduleResponse;
import eIPAD.chartsummary.common.daoimpl.GenericDAOImpl;
import eIPAD.chartsummary.common.response.ErrorInfo;
import eIPAD.chartsummary.common.response.Errors;

/**
 * @author SaraswathiR
 *
 */
public class PendingScheduleDAOImpl extends GenericDAOImpl implements PendingScheduleDAO  {
	


	/* (non-Javadoc)
	 * @see eIPAD.chartsummary.pendingschedule.dao.PendingScheduleDAO#getPendingSchedule(eIPAD.chartsummary.pendingschedule.request.PendingScheduleRequest)
	 */
	public PendingScheduleResponse getPendingSchedule(PendingScheduleRequest request) {
		
		String locale = (request.getPatientContext().getLocale() == null || request.getPatientContext().getLocale() == "") ? "en": request.getPatientContext().getLocale();
		String facilityId = request.getFacilityId();
		String patientID = request.getPatientId();
		PendingScheduleResponse response = new PendingScheduleResponse();
		ArrayList<PendingScheduleHO> pendingScheduleList = new ArrayList<PendingScheduleHO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ErrorInfo errorInfo = new ErrorInfo();
		try{
			String pendingScheduleQuery = "select TO_CHAR(APPT_DATE,'DD/MM/YYYY')APPT_DATE_STR,TO_CHAR(APPT_SLAB_FROM_TIME,'HH24:MI') FROM_TIME_STR, TO_CHAR(APPT_SLAB_TO_TIME ,'HH24:MI') TO_TIME_STR,(CASE WHEN a.clinic_code IS NOT NULL THEN OP_GET_DESC.OP_CLINIC(a.facility_id,a.clinic_code,?,'1') END )LOCATION_DESC,(CASE WHEN a.clinic_code IS NOT NULL THEN (SELECT x.short_desc FROM am_speciality_LANG_vW x, op_clinic y WHERE x.speciality_code = y.speciality_code AND y.facility_id = a.facility_id AND y.clinic_code = a.clinic_code AND X.LANGUAGE_ID = ? ) END ) SPECIALITY_DESC, DECODE(RESOURCE_CLASS,'P','Practitioner','R','Room','Others')||'/'|| case when RESOURCE_CLASS='P' then am_get_desc.am_practitioner(PRACTITIONER_ID,?,'1') when RESOURCE_CLASS='R' then am_get_desc.AM_FACILITY_ROOM(a.FACILITY_ID,a.PRACTITIONER_ID,?,'1') else am_get_desc.AM_RESOURCE(a.FACILITY_ID,a.PRACTITIONER_ID,?,'1') end  resource_name, APPT_REF_NO,(select count(appt_ref_no) from oa_resource_for_appt where appt_ref_no = a.appt_ref_no  and oa_resource_for_appt.FACILITY_ID=a.FACILITY_ID) sec_resource_cnt from oa_appt_vw A where A.FACILITY_ID= ? AND A.PATIENT_ID=? AND  A.APPT_DATE>=trunc(sysdate) and ((ORDER_ID is not null and exists (select 1 from or_order_line where ORDER_ID = a.ORDER_ID and ORDER_LINE_NUM = a.ORDER_LINE_NUM and order_line_status NOT IN (SELECT order_status_code FROM or_order_status_code 	WHERE order_status_type IN (SELECT order_status_type FROM OR_STATUS_APPLICABILITY WHERE OPER_OR_GROUP_REF= 'EXT_COMPL_ORD') or order_status_type in ('99','96','97','93'))))OR ORDER_ID is null) and appt_status = '1' ORDER BY A.APPT_DATE, A.APPT_SLAB_FROM_TIME";
			con = createConnection();
			if(con == null){
				errorInfo.setErrorType(Errors.COMMON_CONNECTION_FAILURE,locale);
				response.getErrorsList().add(errorInfo);
				return response;
			}
			else{
				pstmt=con.prepareStatement(pendingScheduleQuery);
				pstmt.setString(1,locale);
				pstmt.setString(2,locale);
				pstmt.setString(3,locale);
				pstmt.setString(4,locale);
				pstmt.setString(5,locale);
				pstmt.setString(6,facilityId);
				pstmt.setString(7,patientID);
				rs = pstmt.executeQuery();
				if(rs == null){
					errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
					return response;
				}
				else{
					String appt_date_str = ""; 
					String pend_sche = "";
					String from_time_str = "";
					String to_time_str = "";
					String classValue = "";	
					String location_desc = "";
					String currdate = "";
					String speciality_desc = "";
					String resource_name = "";
					String appt_ref_no = "";
					int sec_resource_cnt = 0;
					
					while(rs.next())
					{					
						appt_date_str =	rs.getString("APPT_DATE_STR")== null ? "" : rs.getString("APPT_DATE_STR");
						from_time_str =	rs.getString("FROM_TIME_STR")== null ? "" : rs.getString("FROM_TIME_STR");
						to_time_str = rs.getString("TO_TIME_STR") == null ? "" : rs.getString("TO_TIME_STR");
						location_desc =	rs.getString("LOCATION_DESC") == null ? "" : rs.getString("LOCATION_DESC");
						speciality_desc	= rs.getString("SPECIALITY_DESC") == null ? "" : rs.getString("SPECIALITY_DESC");
						resource_name =	rs.getString("resource_name") == null ? "" : rs.getString("resource_name");
						appt_ref_no	= rs.getString("APPT_REF_NO") == null ? "" : rs.getString("APPT_REF_NO"); 
						sec_resource_cnt = rs.getInt("sec_resource_cnt");
						appt_date_str = com.ehis.util.DateUtils.convertDate(appt_date_str,"DMY","en",locale);
						
						PendingScheduleHO pendingScheduleHO = new PendingScheduleHO();
						pendingScheduleHO.setAppointmentDate(appt_date_str);
						pendingScheduleHO.setFromTime(from_time_str);
						pendingScheduleHO.setToTime(to_time_str);
						pendingScheduleHO.setLocationDesc(location_desc);
						pendingScheduleHO.setSpecialityDesc(speciality_desc);
						pendingScheduleHO.setResourceName(resource_name);
						pendingScheduleHO.setAppointmentRefNo(appt_ref_no);
						pendingScheduleHO.setSecResourceCount(sec_resource_cnt);
						pendingScheduleList.add(pendingScheduleHO);
						
					}
					
					if(pendingScheduleList.size() <= 0){
						errorInfo.setErrorType(Errors.COMMON_EMPTY_DATA,locale);
						response.getErrorsList().add(errorInfo);
						return response;
					}
					else{
						response.setPendingSchedules(pendingScheduleList);
					}
				}
			}
			
		}
		catch(SQLException e){
			System.out.println("A database exception occurred while fetching pending schedules" +e);
			errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
			response.getErrorsList().add(errorInfo);
		}
		finally{
			int conCloseFailure = closeConnection(con,pstmt,rs);
		}
		
		return response;
	}

}
