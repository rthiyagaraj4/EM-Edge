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
package portalrefimpl.schedule.createappointment.dac;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import portalrefimpl.PortalHelper;
import portalrefimpl.common.CommonConstants;
import portalrefimpl.common.message.MessageContainer;
import portalrefimpl.common.response.ErrorInfo;
import portalrefimpl.schedule.ScheduleHelper;
import portalrefimpl.schedule.createappointment.CreateAppointmentConstants;
import portalrefimpl.schedule.createappointment.request.PractitionerScheduleRequest;
import portalrefimpl.schedule.createappointment.response.PractitionerScheduleResponse;
import portalrefimpl.schedule.createappointment.response.Schedule;

/**
 * This is the DAC class for retrieving practitioner schedule
 * This DAC class is used in the practitioner schedule service
 * @author GRamamoorthy
 *
 */
public class PractitionerScheduleDAC {

	/**
	 * This method retrieves the practitioner schedule
	 * based on the practitioner schedule request object
	 * 
	 * @param practitionerScheduleRequest
	 * @return
	 */
	public PractitionerScheduleResponse getPractitionerSchedule(
			PractitionerScheduleRequest practitionerScheduleRequest) {
		// initialize the response
		PractitionerScheduleResponse practitionerScheduleResponse = new PractitionerScheduleResponse();
		/*ErrorInfo errorInfo = new ErrorInfo();*/
		ErrorInfo errorInfo = null;
		int errorCode = ErrorInfo.SUCCESS_CODE;
		String errorMessage = null;
		/*practitionerScheduleResponse.setErrorInfo(errorInfo);*/
		// form the SQL query
		String sqlQuery = getPractitionerScheduleQuery();
		
		// get the connection and initialize statements
		Connection conn = PortalHelper.getConnection();
		// safe check
		if(conn == null){
			errorCode = CommonConstants.DBCONNECTION_FAILURE_ERRORCODE;
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(CommonConstants.COMMON_MODULE_NAME,
							errorCode);
			errorInfo.setErrorMessage(errorMessage);
			
			practitionerScheduleResponse.addError(errorInfo);
			return practitionerScheduleResponse;
		}
		
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		// now execute the query to get the result
		try{
			prepStmt = conn.prepareStatement(sqlQuery);
			setDataInPreparedStatement(prepStmt,practitionerScheduleRequest);
			rs = prepStmt.executeQuery();
			// just a safe check
			if(rs == null){
				errorInfo = new ErrorInfo();
				errorCode = CreateAppointmentConstants.PRACTITIONERSCHEDULE_NULLRESULTSET_ERRORCODE;
				errorInfo.setErrorCode(errorCode);
				errorMessage = MessageContainer.getInstance()
						.getDisplayMessage(
								CommonConstants.CREATE_APPOINTMENT_MODULE_NAME,
								errorCode);
				errorInfo.setErrorMessage(errorMessage);
				practitionerScheduleResponse.addError(errorInfo);
				return practitionerScheduleResponse;
			}
			practitionerScheduleResponse
					.setPractitionerId(practitionerScheduleRequest
							.getPractitionerId());
			// now process the resultset
			setDataInPractitionerScheduleResponse(rs,
					practitionerScheduleResponse);
		}catch(SQLException sqlEx){
			errorInfo = new ErrorInfo();
			errorCode = CreateAppointmentConstants.PRACTITIONERSCHEDULE_SQLEXCEPTION_ERRORCODE;
			errorInfo.setErrorCode(errorCode);
			errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(
							CommonConstants.CREATE_APPOINTMENT_MODULE_NAME,
							errorCode);
			errorInfo.setErrorMessage(errorMessage);
			practitionerScheduleResponse.addError(errorInfo);
			/*return practitionerScheduleResponse;*/
		}finally{
			PortalHelper.closeResources(conn, prepStmt, rs);
		}
		
		return practitionerScheduleResponse;
	}
	
	/**
	 * This method gets the SQL query for getting practitioner schedule information
	 * @return
	 */
	private String getPractitionerScheduleQuery(){
		StringBuffer queryBuff = new StringBuffer();
		
		queryBuff.append("select practitioner_id,practitioner_name,clinic_date,clinic_name,max_patients_per_day,min_slot_slab_start_time,min_slot_slab_end_time from");
		queryBuff.append("(");
		queryBuff.append(" SELECT clinic_code, OP_GET_DESC.OP_CLINIC(FACILITY_ID, CLINIC_CODE, ?, '2') clinic_name, ");
		queryBuff.append(" INITCAP (OP_GET_DESC.OP_CLINIC(FACILITY_ID, CLINIC_CODE, ?, '1')) clinic_long_name, ");
		queryBuff.append(" NVL (practitioner_id, '~') practitioner_id, ");
		queryBuff.append(" NVL (INITCAP ( ");
		queryBuff.append(" decode(RESOURCE_CLASS, ");
		queryBuff.append("    'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID ,?, '1'), ");
		queryBuff.append(" 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID, ?, '1'), ");
		queryBuff.append(" AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID, ?, '1'))), ");
		queryBuff.append(" 'Not Identified' ");
		queryBuff.append(" ) practitioner_full_name, ");
		queryBuff.append(" NVL (INITCAP (");
		queryBuff.append(" decode(RESOURCE_CLASS, ");
		queryBuff.append(" 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID, ?, '2'), ");
		queryBuff.append(" 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID, ?, '2'),");
		queryBuff.append(" AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID, ?, '2'))), ");
		queryBuff.append(" 'Not Identified' ");
		queryBuff.append(" ) practitioner_name, ");
		queryBuff.append(" nvl(decode(resource_class, 'P', (SELECT position_desc FROM am_practitioner_lang_vw ");
		queryBuff.append(" WHERE practitioner_id = a.practitioner_id ");
		queryBuff.append(" AND language_id     = ?), ");
		queryBuff.append(" '~'), '~') pract_position, ");
		queryBuff.append(" reason_code, clinic_date, schedule_status, ");
		queryBuff.append(" max_patients_per_day max_patients_per_day, ");
		queryBuff.append(" time_table_type, ");
		queryBuff.append(" DECODE (time_table_type, ");
		queryBuff.append(" '1', NVL (total_follow_up, 0) ");
		queryBuff.append(" + NVL (total_routine, 0) ");
		queryBuff.append(" + NVL (total_series, 0) ");
		queryBuff.append(" + NVL (total_consult, 0) ");
		queryBuff.append(" + NVL (total_emergency, 0) ");
		queryBuff.append(" + NVL (total_first_visit, 0) ");
		queryBuff.append(" + NVL (total_first_visits_blocked, 0) ");
		queryBuff.append(" + NVL (total_other_visits_blocked, 0), ");
		queryBuff.append(" total_slots_booked ");
		queryBuff.append(" ) total_slots_booked, ");
		queryBuff.append(" max_over_booking, total_slots_overbooked, ");
		queryBuff.append(" max_forced_in_booking, total_forced_in_booked, ");
		queryBuff.append(" care_locn_type_ind, ");
		queryBuff.append(" resource_class, ");
		queryBuff.append(" min_slot_slab_start_time, ");
		queryBuff.append(" min_slot_slab_end_time ");
		queryBuff.append(" FROM oa_clinic_schedule a ");
		queryBuff.append(" WHERE facility_id = ? ");
		queryBuff.append(" AND clinic_date BETWEEN TO_DATE (?, 'DD/MM/YYYY') ");
		queryBuff.append(" AND TO_DATE (?  , 'DD/MM/YYYY') ");
		queryBuff.append(" AND primary_resource_yn = 'Y' ");
		queryBuff.append(" AND ( ? IS NULL ");
		queryBuff.append(" OR (     practitioner_id = ? ");
		queryBuff.append(" AND ( ? is null ");
		queryBuff.append(" OR EXISTS ");
		queryBuff.append(" ( ");
		queryBuff.append(" SELECT 1 FROM am_practitioner_lang_vw ");
		queryBuff.append(" WHERE practitioner_id = ? ");
		queryBuff.append(" AND language_id     = ? ");
		queryBuff.append(" AND position_code   = ? ");
		queryBuff.append(" ) ");
		queryBuff.append(" ) ");
		queryBuff.append(" ) ");
		queryBuff.append(" ) ");
		queryBuff.append(" AND EXISTS ( ");
		queryBuff.append(" SELECT clinic_code ");
		queryBuff.append(" FROM op_clinic ");
		queryBuff.append(" WHERE allow_appt_yn = 'Y' ");
		queryBuff.append(" AND eff_status    = 'E' ");
		queryBuff.append(" AND facility_id   = ? ");
		queryBuff.append(" AND clinic_code   = a.clinic_code ");
		queryBuff.append(" AND (speciality_code = ? or ? is null) ");
		queryBuff.append(" AND clinic_code        = NVL (?, clinic_code) ");
		queryBuff.append(" AND care_locn_type_ind = NVL (?, care_locn_type_ind) ");
		queryBuff.append(" AND resource_class     = NVL (?, resource_class) ");
		queryBuff.append(" ) ");
		queryBuff.append(" AND ( ? IS NULL OR EXISTS ( ");
		queryBuff.append(" SELECT 1 ");
		queryBuff.append(" FROM op_catalog_for_clinic z ");
		queryBuff.append(" WHERE z.facility_id = a.facility_id ");
		queryBuff.append(" AND z.clinic_code = a.clinic_code ");
		queryBuff.append(" AND ((z.order_catalog_code = ?) ");
		queryBuff.append(" OR EXISTS ( ");
		queryBuff.append(" SELECT 1 FROM or_order_set_component ");
		queryBuff.append(" WHERE order_set_code = z.order_catalog_code ");
		queryBuff.append(" AND order_catalog_code = ? ) ");
		queryBuff.append(" ) ) ) ");
		queryBuff.append(" AND ( ? IS NULL OR EXISTS ( ");
		queryBuff.append(" SELECT clinic_code ");
		queryBuff.append(" FROM op_visit_type_for_clinic ");
		queryBuff.append(" WHERE visit_type_code = ? ");
		queryBuff.append(" AND facility_id = ? ");
		queryBuff.append(" AND clinic_code = a.clinic_code) ");
		queryBuff.append(" ) ");
		queryBuff.append(" AND EXISTS ( SELECT locn_code ");
		queryBuff.append(" FROM am_os_user_locn_access_vw ");
		queryBuff.append(" WHERE facility_id  = ? ");
		queryBuff.append(" AND oper_stn_id  = ? ");                    
		queryBuff.append(" AND locn_code    = a.clinic_code ");
		queryBuff.append(" AND (    book_appt_yn = 'Y' OR book_appt_wo_pid_yn = 'Y' OR obook_appt_yn = 'Y' ");
		queryBuff.append(" OR book_appt_across_catg_yn = 'Y' OR tfr_appt_yn = 'Y' ");
		queryBuff.append(" OR tfr_appt_across_catg_yn = 'Y'  OR canc_appt_yn = 'Y' ");
		queryBuff.append(" ) ");
		queryBuff.append(" ) ");
		queryBuff.append(" ORDER BY clinic_name, practitioner_name ");
		queryBuff.append(" , practitioner_id, clinic_date ");
		
		queryBuff.append(")");
		queryBuff.append(" group by practitioner_id,practitioner_name,clinic_date,clinic_name,max_patients_per_day,min_slot_slab_start_time,min_slot_slab_end_time ");
		queryBuff.append(" order by clinic_date");
		
		return queryBuff.toString();
	}
	
	/**
	 * This method sets the data in the preparedstatement object
	 * @param practitionerScheduleRequest
	 * @throws SQLException
	 */
	private void setDataInPreparedStatement(PreparedStatement prepStmt,
			PractitionerScheduleRequest practitionerScheduleRequest)
			throws SQLException {
		int paramIndex = 1;
		
		// first 9 parameters are language
		final int LANGUAGEID_COUNT = 9;
		String language = practitionerScheduleRequest.getLocale();
		for(;paramIndex <= LANGUAGEID_COUNT;paramIndex++){
			prepStmt.setString(paramIndex, language);
		}
		
		// get facility id
		String facilityId = practitionerScheduleRequest.getFacilityId();
		prepStmt.setString(paramIndex,facilityId);
		paramIndex++;
		
		// preferred date has to be set twice
		String preferredFromDateAsString = practitionerScheduleRequest.getPreferredFromDateAsString();
		prepStmt.setString(paramIndex, preferredFromDateAsString);
		paramIndex++;
		String preferredToDateAsString = practitionerScheduleRequest.getPreferredToDateAsString();
		prepStmt.setString(paramIndex, preferredToDateAsString);
		paramIndex++;
		
		
		// practitioner id - this has to be set twice
		String practitionerId = practitionerScheduleRequest.getPractitionerId();
		prepStmt.setString(paramIndex, practitionerId);
		paramIndex++;
		prepStmt.setString(paramIndex, practitionerId);
		paramIndex++;
		
		// position code
		String positionCode = practitionerScheduleRequest.getPositionCode();
		prepStmt.setString(paramIndex, positionCode);
		paramIndex++;
		
		// practitioner id
		prepStmt.setString(paramIndex, practitionerId);
		paramIndex++;
		
		// language
		prepStmt.setString(paramIndex, language);
		paramIndex++;
		
		// position code
		prepStmt.setString(paramIndex, positionCode);
		paramIndex++;
		
		// facility id once again
		prepStmt.setString(paramIndex,facilityId);
		paramIndex++;
		
		// speciality code twice over
		String specialityCode = practitionerScheduleRequest.getSpecialityCode();
		prepStmt.setString(paramIndex,specialityCode);
		paramIndex++;
		prepStmt.setString(paramIndex,specialityCode);
		paramIndex++;
		
		// clinic code
		String clinicCode = practitionerScheduleRequest.getClinicCode();
		prepStmt.setString(paramIndex,clinicCode);
		paramIndex++;
		
		// care location type indicator
		String careLocationIndicator = practitionerScheduleRequest.getCareLocationIndicator();
		prepStmt.setString(paramIndex,careLocationIndicator);
		paramIndex++;
		
		// resource class
		String resourceClass = practitionerScheduleRequest.getResourceClass();
		prepStmt.setString(paramIndex,resourceClass);
		paramIndex++;
		
		// catalog code twice over
		String catalogCode = practitionerScheduleRequest.getCatalogCode();
		prepStmt.setString(paramIndex,catalogCode);
		paramIndex++;
		prepStmt.setString(paramIndex,catalogCode);
		paramIndex++;
		prepStmt.setString(paramIndex,catalogCode);
		paramIndex++;
		
		// visit type
		String visitType = practitionerScheduleRequest.getVisitType();
		prepStmt.setString(paramIndex,visitType);
		paramIndex++;
		prepStmt.setString(paramIndex,visitType);
		paramIndex++;
		
		// facility id twice over
		prepStmt.setString(paramIndex,facilityId);
		paramIndex++;
		prepStmt.setString(paramIndex,facilityId);
		paramIndex++;
		
		// operation standard id
		String oprStnId = practitionerScheduleRequest.getOperationStandardId();
		prepStmt.setString(paramIndex,oprStnId);
		paramIndex++;
	}
	
	/**
	 * This method sets the data in the practitioner schedule response
	 * by reading from the result set
	 * @param rs
	 * @param practitionerScheduleResponse
	 * @throws SQLException
	 */
	private void setDataInPractitionerScheduleResponse(ResultSet rs,
			PractitionerScheduleResponse practitionerScheduleResponse)
			throws SQLException {
		// local vars to be used
		String practitionerId = null;
		
		int maxPatientsPerDay = 0;
		Timestamp minSlotSlabStartTime = null;
		Timestamp minSlotSlabEndTime = null;
		
		List<Schedule> scheduleList = new ArrayList<Schedule>();
		String slotStartTime = null;
		String slotEndTime = null;
		Date scheduleDate = null;
		// iterate through the result set and form
		// practitioner schedule instances and add
		// it to a list
		while(rs.next()){
			/*practitionerId = rs
					.getString(CreateAppointmentConstants.PRACTITIONERID_KEY);*/
			maxPatientsPerDay = rs.getInt(CreateAppointmentConstants.MAX_PATIENT_DAY);
			minSlotSlabStartTime = rs.getTimestamp(CreateAppointmentConstants.MIN_SLOTSLAB_START_TIME);
			minSlotSlabEndTime = rs.getTimestamp(CreateAppointmentConstants.MIN_SLOTSLAB_END_TIME);
			scheduleDate = rs.getDate(CreateAppointmentConstants.CLINIC_DATE);
			// call the method to change the date in a format 
			// that is required by the application
			scheduleDate = ScheduleHelper.getDateInApplicationFormat(scheduleDate);
			
			if(minSlotSlabStartTime == null || minSlotSlabEndTime == null){
				slotStartTime = "";	
				slotEndTime = "";
			}else{
				slotStartTime = PortalHelper.getDateAsString(
						minSlotSlabStartTime,
						CreateAppointmentConstants.TIME_DISPLAY_FORMAT);
				slotEndTime = getEndSlotTime(minSlotSlabEndTime,
						minSlotSlabStartTime, maxPatientsPerDay);
						
			}
			// form the schedule object and add it to the list
			Schedule schedule = new Schedule();
			schedule.setScheduleDate(scheduleDate);
			schedule.setStartTime(slotStartTime);
			schedule.setEndTime(slotEndTime);
			
			scheduleList.add(schedule);
		}
		practitionerScheduleResponse.setScheduleList(scheduleList);
		// check for empty list - it implies no schedule for this practitioner
		// flag an error
		/*ErrorInfo errorInfo = practitionerScheduleResponse.getErrorInfo();*/
		ErrorInfo errorInfo = null;
		if(scheduleList.isEmpty()){
			errorInfo = new ErrorInfo();
			int errorCode = CreateAppointmentConstants.PRACTITIONERSCHEDULE_NOSCHEDULE_ERRORCODE;
			errorInfo.setErrorCode(errorCode);
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(
							CommonConstants.CREATE_APPOINTMENT_MODULE_NAME,
							errorCode);
			errorInfo.setErrorMessage(errorMessage);
		}else{
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(ErrorInfo.SUCCESS_CODE);
		}
		practitionerScheduleResponse.addError(errorInfo);
	}
	
	/**
	 * 
	 * @param minSlotSlabEndTime
	 * @param minSlotSlabStartTime
	 * @param maxPatientsPerDay
	 * @return
	 */
	private String getEndSlotTime(Timestamp minSlotSlabEndTime,
			Timestamp minSlotSlabStartTime, int maxPatientsPerDay) {
		StringBuffer endSlotTimeBuffer = new StringBuffer();
		
		Calendar startSlotCal = Calendar.getInstance();
		startSlotCal.setTimeInMillis(minSlotSlabStartTime.getTime());
		
		Calendar endSlotCal = Calendar.getInstance();
		// initially set the start time itself as the time to end slot calendar
		endSlotCal.setTimeInMillis(minSlotSlabStartTime.getTime());
		// now calculate the end time in hrs and min
		// this will be start time + (no of slots * time per slot)
		long timeDiff = minSlotSlabEndTime.getTime() - minSlotSlabStartTime.getTime();
		if(timeDiff > 0){
			int diffHrs = (int)timeDiff / (CreateAppointmentConstants.NUMBER_OF_MILLIS_IN_HR);
			int diffMin = 0;
			if(diffHrs >0){
				diffMin = (int)timeDiff - (diffHrs * CreateAppointmentConstants.NUMBER_OF_MILLIS_IN_HR);	
			}else{
				diffMin = (int) (timeDiff / (CreateAppointmentConstants.NUMBER_OF_MILLIS_IN_SEC * CreateAppointmentConstants.NUMBER_OF_SEC_IN_MIN));
			}
			
			int totalDiffMin = (diffHrs * CreateAppointmentConstants.NUMBER_OF_MIN_IN_HR ) + diffMin;
			int totalMin = totalDiffMin * maxPatientsPerDay;
			diffHrs = totalMin / CreateAppointmentConstants.NUMBER_OF_MIN_IN_HR;
			if(diffHrs > 0) {
				diffMin = totalMin - (diffHrs * CreateAppointmentConstants.NUMBER_OF_MIN_IN_HR);
			}else{
				diffMin = totalMin;
			}
			
			endSlotCal.add(Calendar.HOUR_OF_DAY, diffHrs);
			endSlotCal.add(Calendar.MINUTE, diffMin);
		}
		// get the end hours and the minutes - this is the data
		// that is required
		int endSlotHrs = endSlotCal.get(Calendar.HOUR_OF_DAY);
		int endSlotMin = endSlotCal.get(Calendar.MINUTE);
		// finally put the end slot time to the buffer
		endSlotTimeBuffer.append(getDisplayValue(endSlotHrs));
		endSlotTimeBuffer.append(CreateAppointmentConstants.TIME_DISPLAY_DELIMITER);
		endSlotTimeBuffer.append(getDisplayValue(endSlotMin));
		
		return endSlotTimeBuffer.toString();
	}
	
	/**
	 * This method will convert the integer value to String value
	 * which should be in the format specified
	 * @param intValue
	 * @return
	 */
	private String getDisplayValue(int intValue){
		String displayValue = null;
		final String format = "%02d";
		try {
			displayValue = String.format(format,new Integer(intValue));
		} catch (Exception e) {
			displayValue = intValue+"";
		}
		return displayValue;
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		// initialize the request object
		PractitionerScheduleRequest request = new PractitionerScheduleRequest();
		
		request.setFacilityId("HS");
		request.setPractitionerId("AZAMUDDIN");
		request.setPositionCode("");
		request.setLocale("en");
		request.setClinicCode("");
		request.setCareLocationIndicator("");
		request.setResourceClass("P");
		request.setCatalogCode("");
		request.setVisitType("");
		request.setOperationStandardId("ALL");
		request.setPreferredDateAsString("20/03/2013");
		/*request.setPreferredFromDateAsString("19/03/2013");
		request.setPreferredToDateAsString("18/04/2013");*/
		request.setPreferredStartTime("10:30:00");
		request.setPreferredStartTime("10:30");
		request.setPreferredEndTime("11:30:00");
		request.setPreferredEndTime("11:30");
		// 1 speciality code "22"
		request.setSpecialityCode("22");
		
		// 2 practitioner id - AKBARS
		//request.setPractitionerId("AKBARS");
		
		// 3 practitioner id - AFNIZAR
		//request.setPractitionerId("AFNIZAR");
		
		request.setPractitionerId("299355");
		
		long beforeCallTime = System.currentTimeMillis();
		System.out.println("time before making the call ="+beforeCallTime);
		
		PractitionerScheduleDAC dacInst = new PractitionerScheduleDAC();
		PractitionerScheduleResponse response = dacInst.getPractitionerSchedule(request);
		long afterCallTime = System.currentTimeMillis();
		System.out.println("time after the call ="+afterCallTime);
		System.out.println("Total time taken for the call ="+(afterCallTime - beforeCallTime));
		// print the results
		response.printResult();
		
	}
	
}
