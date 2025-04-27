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
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import portalrefimpl.PortalHelper;
import portalrefimpl.common.CommonConstants;
import portalrefimpl.common.message.MessageContainer;
import portalrefimpl.common.response.ErrorInfo;
import portalrefimpl.schedule.createappointment.CreateAppointmentConstants;
import portalrefimpl.schedule.createappointment.request.PractitionerRequest;
import portalrefimpl.schedule.createappointment.response.PractitionerModel;
import portalrefimpl.schedule.createappointment.response.PractitionerResponse;

/**
 * This is the DAC class for practitioner service
 * @author GRamamoorthy
 *
 */
public class PractitionerDAC {
	
	/**
	 * This method gets the practitioners 
	 * The request object passed to this method contains the speciality id
	 * for which we need to get the practitioners
	 * @param practitionerRequest
	 * @return
	 */
	public PractitionerResponse getPractitionerList(PractitionerRequest practitionerRequest){
		// initialize the response object and the errorinfo object
		PractitionerResponse practitionerResponse = new PractitionerResponse();
		/*ErrorInfo errorInfo = new ErrorInfo();*/
		ErrorInfo errorInfo = null;
		int errorCode = ErrorInfo.SUCCESS_CODE;
		String errorMessage = null;
		/*practitionerResponse.setErrorInfo(errorInfo);*/
		
		// stores the SQL query 
		String sqlQuery = getPractitionerQuery(practitionerRequest);
		
		// initialize the connection
		Connection conn = PortalHelper.getConnection();
		// safe check
		if(conn == null){
			errorInfo = new ErrorInfo();
			errorCode = CreateAppointmentConstants.PRACTITIONER_CONNECTION_PROBLEM_ERRORCODE;
			errorInfo.setErrorCode(errorCode);
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.CREATE_APPOINTMENT_MODULE_NAME, errorCode);
			errorInfo.setErrorMessage(errorMessage);
			practitionerResponse.addError(errorInfo);
			return practitionerResponse;
		}
		
		// initialize the preparedstatement and result object
		// to get data from back ground
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		try {
			prepStmt = conn.prepareStatement(sqlQuery);
			setDataInPreparedStatment(prepStmt,practitionerRequest);
			rs = prepStmt.executeQuery();
			if(rs != null){
				populateDataInPractitionerResponse(rs, practitionerResponse,
						practitionerRequest);
				// call the method to populate other practitioner data
				// only if the response is successful till this time
				if(practitionerResponse.isSuccessful()){
					populateOtherDataInPractitionerResponse(conn,
							practitionerResponse, practitionerRequest);
				}
				/*errorInfo = practitionerResponse.getErrorInfo();
				if(ErrorInfo.SUCCESS_CODE == errorInfo.getErrorCode()){
					populateOtherDataInPractitionerResponse(conn,
							practitionerResponse, practitionerRequest);	
				}else{
					System.out.println("failure in getting practitioner list");
				}*/
			}else{
				errorInfo = new ErrorInfo();
				errorCode = CreateAppointmentConstants.PRACTITIONER_RESULTSET_NULL_ERRORCODE;
				errorInfo.setErrorCode(errorCode);
				errorMessage = MessageContainer.getInstance()
						.getDisplayMessage(
								CommonConstants.CREATE_APPOINTMENT_MODULE_NAME,
								errorCode);
				errorInfo.setErrorMessage(errorMessage);
				practitionerResponse.addError(errorInfo);
				/*return practitionerResponse;*/
			}
			
		} catch (SQLException e) {
			errorInfo = new ErrorInfo();
			errorCode = CreateAppointmentConstants.PRACTITIONER_SQLEXCEPTION_PROBLEM_ERRORCODE;
			errorInfo.setErrorCode(errorCode);
			errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(
							CommonConstants.CREATE_APPOINTMENT_MODULE_NAME,
							errorCode);
			errorInfo.setErrorMessage(errorMessage);
			practitionerResponse.addError(errorInfo);
			/*return practitionerResponse;*/
		}finally{
			PortalHelper.closeResources(conn, prepStmt, rs);
			/*try {
				if(prepStmt != null) {
					prepStmt.close();
				} 
			} catch (Exception e) {
				System.out.println("Failed to close the Statement object");
			}
			try {
				if(rs != null) {
					rs.close();
				} 
			} catch (Exception e) {
				System.out.println("Failed to close the ResultSet object");
			}
			conn = null;*/
		}
		
		
		return practitionerResponse;
	}
	
	/**
	 * This method returns the SQL query needed for getting the practitioner list
	 * @param practitionerRequest
	 * @return
	 */
	private String getPractitionerQuery(PractitionerRequest practitionerRequest){
//		String locale = practitionerRequest.getLocale();
		
		// stores the SQL query 
		StringBuffer queryBuff = new StringBuffer();
		/*queryBuff.append("SELECT PRACTITIONER_ID practitioner_id, PRACTITIONER_NAME practitioner_name,	am_get_desc.am_pract_type(pract_type,'");
		queryBuff.append(locale);
		queryBuff.append("',2) practitioner_type,am_get_desc.AM_SPECIALITY(primary_speciality_code,'");
		queryBuff.append(locale);
		queryBuff.append("',2) primary_speciality,am_get_desc.AM_POSITION(a.POSITION_CODE, '");
		queryBuff.append(locale);
		queryBuff.append("','1') job_title_desc,a.position_code job_title ,gender");
		queryBuff.append(" FROM  AM_PRACT_ALL_SPLTY_VW a ");
		queryBuff.append(" WHERE ");
		queryBuff.append(" SPECIALTY_CODE=nvl(?,SPECIALTY_CODE) AND ");
		queryBuff.append(" UPPER(pract_type) LIKE UPPER(NVL(?,pract_type)) AND ");
		// primary speciality code is the same as the speciality code
		// hence there is no need to check with this column
		queryBuff.append(" UPPER(primary_speciality_code) LIKE UPPER(NVL(?,primary_speciality_code)) AND ");
		queryBuff.append(" (UPPER(practitioner_id) LIKE UPPER(NVL(?,practitioner_id)) OR ");
		queryBuff.append(" UPPER(practitioner_name) LIKE UPPER(NVL(?,practitioner_name)))	AND ");
		queryBuff.append(" gender LIKE NVL(UPPER(?),gender) ");
		// position code is also not required
		queryBuff.append(" and upper(nvl(POSITION_CODE,'123')) like upper(nvl(?,nvl(POSITION_CODE,'123')))");
		queryBuff.append(" order by practitioner_name");*/
		
		// updated to get the latest SQL query
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
		// the catch here is that the time value is stored as date column
		// where the time value alone is correct
		// there is a need to combine the clinic_date column and the start
		// and end time values and compare their values to get the 
		// practitioners with the correct schedule
	/*	queryBuff.append(" AND ( ");
		
		queryBuff.append(" TO_DATE(TO_CHAR(clinic_date,'DD/MM/YYYY') || ' ' || TO_CHAR(MIN_SLOT_SLAB_START_TIME,'HH24:MI:SS'),'DD/MM/YYYY HH24:MI:SS') < TO_DATE(?,'DD/MM/YYYY HH24:MI:SS') ");
		queryBuff.append(" AND "); 
		queryBuff.append(" TO_DATE(TO_CHAR(clinic_date,'DD/MM/YYYY') || ' ' || TO_CHAR(MIN_SLOT_SLAB_END_TIME,'HH24:MI:SS'),'DD/MM/YYYY HH24:MI:SS') > TO_DATE(?,'DD/MM/YYYY HH24:MI:SS') ");
		
		queryBuff.append(" TO_DATE(TO_CHAR(clinic_date,'DD/MM/YYYY') || ' ' || TO_CHAR(MIN_SLOT_SLAB_START_TIME,'HH24:MI:SS'),'DD/MM/YYYY HH24:MI:SS') < ? ");
		queryBuff.append(" AND "); 
		queryBuff.append(" TO_DATE(TO_CHAR(clinic_date,'DD/MM/YYYY') || ' ' || TO_CHAR(MIN_SLOT_SLAB_END_TIME,'HH24:MI:SS'),'DD/MM/YYYY HH24:MI:SS') > ? ");
		
		queryBuff.append(" )");*/   
		
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
		
		
		return queryBuff.toString();
	}
	
	
	/**
	 * This method sets the data in the preparedstatement object
	 * This is needed before the prepared statement is executed
	 * @param prepStmt
	 * @param practitionerRequest
	 */
	private void setDataInPreparedStatment(PreparedStatement prepStmt,
			PractitionerRequest practitionerRequest) throws SQLException{
		int paramIndex = 1;
		
		// first 9 parameters are language
		final int LANGUAGEID_COUNT = 9;
		String language = practitionerRequest.getLocale();
		for(;paramIndex <= LANGUAGEID_COUNT;paramIndex++){
			prepStmt.setString(paramIndex, language);
		}
		
		// get facility id
		String facilityId = practitionerRequest.getFacilityId();
		prepStmt.setString(paramIndex,facilityId);
		paramIndex++;
		
		// preferred date has to be set twice
		String preferredFromDateAsString = practitionerRequest.getPreferredFromDateAsString();
		prepStmt.setString(paramIndex, preferredFromDateAsString);
		paramIndex++;
		String preferredToDateAsString = practitionerRequest.getPreferredToDateAsString();
		prepStmt.setString(paramIndex, preferredToDateAsString);
		paramIndex++;
		
		// now comes preferred date and time combined
		// this also has to be set twice
		// start time
		/*String preferredDateTimeAsString = preferredDateAsString;
		String startTime = practitionerRequest.getPreferredStartTime();
		preferredDateTimeAsString += " "+startTime;
		Date dateTime = PortalHelper.getDateFromString(preferredDateTimeAsString, "dd/MM/yyyy HH:mm:ss");
		java.sql.Timestamp dateVal = new java.sql.Timestamp(dateTime.getTime());
		//prepStmt.setTimestamp(paramIndex, dateVal);
		//paramIndex++;
		
		// end time
		preferredDateTimeAsString = preferredDateAsString;
		String endTime = practitionerRequest.getPreferredEndTime();
		preferredDateTimeAsString += " "+endTime;
		dateTime = PortalHelper.getDateFromString(preferredDateTimeAsString, "dd/MM/yyyy HH:mm:ss");
		dateVal = new java.sql.Timestamp(dateTime.getTime());
		//prepStmt.setTimestamp(paramIndex, dateVal);
		//paramIndex++;
*/		
		// practitioner id - this has to be set twice
		String practitionerId = practitionerRequest.getPractitionerId();
		prepStmt.setString(paramIndex, practitionerId);
		paramIndex++;
		prepStmt.setString(paramIndex, practitionerId);
		paramIndex++;
		
		// position code
		String positionCode = practitionerRequest.getPositionCode();
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
		String specialityCode = practitionerRequest.getSpecialityCode();
		prepStmt.setString(paramIndex,specialityCode);
		paramIndex++;
		prepStmt.setString(paramIndex,specialityCode);
		paramIndex++;
		
		// clinic code
		String clinicCode = practitionerRequest.getClinicCode();
		prepStmt.setString(paramIndex,clinicCode);
		paramIndex++;
		
		// care location type indicator
		String careLocationIndicator = practitionerRequest.getCareLocationIndicator();
		prepStmt.setString(paramIndex,careLocationIndicator);
		paramIndex++;
		
		// resource class
		String resourceClass = practitionerRequest.getResourceClass();
		prepStmt.setString(paramIndex,resourceClass);
		paramIndex++;
		
		// catalog code twice over
		String catalogCode = practitionerRequest.getCatalogCode();
		prepStmt.setString(paramIndex,catalogCode);
		paramIndex++;
		prepStmt.setString(paramIndex,catalogCode);
		paramIndex++;
		prepStmt.setString(paramIndex,catalogCode);
		paramIndex++;
		
		// visit type
		String visitType = practitionerRequest.getVisitType();
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
		String oprStnId = practitionerRequest.getOperationStandardId();
		prepStmt.setString(paramIndex,oprStnId);
		paramIndex++;
				
	}
	
	/**
	 * This method populates the practitioner data in the response object
	 * by reading the result set object
	 * @param rs
	 * @param practitionerResponse
	 * @param practitionerRequest TODO
	 */
	private void populateDataInPractitionerResponse(ResultSet rs,
			PractitionerResponse practitionerResponse,
			PractitionerRequest practitionerRequest) throws SQLException {
		// local vars to be used
		String practitionerId = null;
		String practitionerName = null;
		String practitionerFullName = null;
		// clinic code should be returned as part of the response
		String clinicCode = null;
		/*String practitionerType = null;
		String primarySpeciality = null;
		String position = null;
		String jobTitle = null;
		String gender = null;*/
		// specialty will be the same for all practitioners
		// hence get this from the request
		// the same will be set to all the practitioner model objects
		String specialty = practitionerRequest.getSpecialityCode();
		String specialtyDesc = practitionerRequest.getSpecialityDesc();
		String facilityDesc = practitionerRequest.getFacilityDesc();
		
		
		/*ErrorInfo errorInfo = new ErrorInfo();*/
		ErrorInfo errorInfo = null;
		/*practitionerResponse.setErrorInfo(errorInfo);*/
		
		PractitionerModel practitionerModel = null;
		List<PractitionerModel> practitionerModelList = new ArrayList<PractitionerModel>();
		Timestamp startSlabTime = null;
		Timestamp endSlabTime = null;
		int maxPatientsPerDay = 0;
		
		List<String> practitionerList = new ArrayList<String>();
		
		// iterate through the result set and form
		// practitionermodel instances and add
		// it to the list
		while(rs.next()){
			// get only the practitioner id, practitioner full name and 
			// practitioner name here
			practitionerId = rs
					.getString(CreateAppointmentConstants.PRACTITIONERID_KEY);
			practitionerFullName = rs.getString(CreateAppointmentConstants.PRACTITIONERFULLNAME_KEY);
			practitionerName = rs.getString(CreateAppointmentConstants.PRACTITIONERNAME_KEY);
			
			// safe checks - ignore records if the actual data is obtained like this
			if(practitionerName == null || practitionerFullName == null){
				continue;
			}
			if (CreateAppointmentConstants.INVALID_PRACTITIONER_IDENTIFIER
					.equalsIgnoreCase(practitionerName)
					|| CreateAppointmentConstants.INVALID_PRACTITIONER_IDENTIFIER
							.equalsIgnoreCase(practitionerFullName)) {
				continue;
			}
			
			// there is a need to get the start slot time and end slot time
			// and then manually check if the slots do contain the preferred time
			// given by the user
			startSlabTime = rs.getTimestamp(CreateAppointmentConstants.MIN_SLOTSLAB_START_TIME);
			endSlabTime = rs.getTimestamp(CreateAppointmentConstants.MIN_SLOTSLAB_END_TIME);
			maxPatientsPerDay = rs.getInt(CreateAppointmentConstants.MAX_PATIENT_DAY);
			// get the clinic code from result set
			clinicCode = rs.getString(CreateAppointmentConstants.CLINIC_CODE);
			// check if the list contains the practitioner id - if so,
			// then we do not need to add the practitioner once again
			if(practitionerList.contains(practitionerId)){
				continue;
			}
			
			// if this record is not matching then ignore
			if (!isTimeInSlotRange(startSlabTime, endSlabTime,
					maxPatientsPerDay, practitionerRequest)) {
				continue;
			}
			// this is only for temp purpose - add the practitioner id to the list
			// this list will be used to filter the records
			practitionerList.add(practitionerId);
			
			practitionerModel = new PractitionerModel();
			practitionerModel.setPractitionerId(practitionerId);
			practitionerModel.setPractitionerName(practitionerName);
			practitionerModel.setPractitionerFullName(practitionerFullName);
			practitionerModel.setSpecialityCode(specialty);
			practitionerModel.setSpecialityDesc(specialtyDesc);
			practitionerModel.setFacilityDesc(facilityDesc);
			// add the clinic code to the model object
			practitionerModel.setClinicCode(clinicCode);
			/*practitionerId = rs
					.getString(CreateAppointmentConstants.PRACTITIONERID_KEY);
			practitionerName = rs.getString(CreateAppointmentConstants.PRACTITIONERNAME_KEY);
			practitionerType = rs.getString(CreateAppointmentConstants.PRACTITIONERTYPE_KEY);
			primarySpeciality = rs.getString(CreateAppointmentConstants.PRIMARYSPECIALITY_KEY);
			position = rs.getString(CreateAppointmentConstants.POSITION_KEY);
			jobTitle = rs.getString(CreateAppointmentConstants.JOBTITLE_KEY);
			gender = rs.getString(CreateAppointmentConstants.GENDER_KEY);*/
			
			
			/*practitionerModel = new PractitionerModel(practitionerId,
					practitionerName, practitionerType, primarySpeciality,
					position, jobTitle, gender);*/
			
			practitionerModelList.add(practitionerModel);
		}
		
		// check if the list is empty - if so, no data is obtained
		// so set an error message accordingly
		if(practitionerModelList.isEmpty()){
			int errorCode = CreateAppointmentConstants.PRACTITIONER_LIST_EMPTY_DATA_CODE;
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(
							CommonConstants.CREATE_APPOINTMENT_MODULE_NAME,
							errorCode);
			errorInfo.setErrorMessage(errorMessage);
			
			practitionerResponse.addError(errorInfo);
		}
		else{
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(ErrorInfo.SUCCESS_CODE);
			practitionerResponse.addError(errorInfo);
		}
		practitionerResponse.setPractitionerModelList(practitionerModelList);
	}
	
	/**
	 * This method populates data like practitioner gender,
	 * practitioner position, job title, specialty description
	 * 
	 * This method is needed since the main query used
	 * to get practitioner list does not the above mentioned
	 * data
	 * @param practitionerResponse
	 */
	private void populateOtherDataInPractitionerResponse(
			Connection conn,
			PractitionerResponse practitionerResponse,
			PractitionerRequest practitionerRequest) throws SQLException{
		// here the practitioner model list will be non empty
		List<PractitionerModel> practitionerModelList = practitionerResponse
				.getPractitionerModelList();
		StringBuffer practIdBuffer = new StringBuffer();
		String practId = null;
		// iterate through the practitioner model
		// and form the practitioner ids needed for sql query
		for(PractitionerModel practModel : practitionerModelList){
			practId = practModel.getPractitionerId();
			practIdBuffer.append("'");
			practIdBuffer.append(practId);
			practIdBuffer.append("'");
			practIdBuffer.append(",");
		}
		// remove the last ","
		int buffLen = practIdBuffer.length();
		if(buffLen > 0){
			practIdBuffer.delete(buffLen-1, buffLen);
		}
		
		// SQL query to be executed
		String sqlQuery = "select a.practitioner_id,a.gender,a.job_title,a.position_code,b.long_desc specialty_long_desc,b.short_desc specialty_short_desc from AM_PRACT_ALL_SPLTY_VW a,am_speciality b where a.practitioner_id in ("+practIdBuffer.toString()+") and a.facility_id='"+practitionerRequest.getFacilityId()+"' and a.specialty_code=b.speciality_code and b.speciality_code = '"+practitionerRequest.getSpecialityCode()+"'";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sqlQuery);
		// resultset should not be null - still if it is so in extremely rare cases,
		// throw an exception
		if(rs == null){
			throw new SQLException();
		}
		
		String practitionerId = null;
		PractitionerModel practitionerModel = null;
		String gender = null;
		String jobTitle = null;
		String positionCode = null;
		String specialtyLongDesc = null;
		String specialtyShortDesc = null;
		// iterate through the result set and get the practitioner data
		while(rs.next()){
			// reset the model instance for every result record
			practitionerModel = null;
			practitionerId = rs.getString("practitioner_id");
			// there is a need to get the practitioner model object
			// which should be updated with more data
			// hence there is an iteration on the practitioner model list
			for(PractitionerModel practModel : practitionerModelList){
				if(practModel.getPractitionerId().equalsIgnoreCase(practitionerId)){
					practitionerModel = practModel;
					break;
				}
			}
			// very rare scenario - still code to handle it
			if(practitionerModel == null){
				continue;
			}
			
			gender = rs.getString("gender");
			jobTitle = rs.getString("job_title");
			positionCode = rs.getString("position_code");
			specialtyLongDesc = rs.getString("specialty_long_desc");
			specialtyShortDesc = rs.getString("specialty_short_desc");
			
			practitionerModel.setGender(gender);
			practitionerModel.setJobTitle(jobTitle);
			practitionerModel.setPosition(positionCode);
			practitionerModel.setSpecialityLongDesc(specialtyLongDesc);
			practitionerModel.setSpecialityShortDesc(specialtyShortDesc);
		}
	}
	
	/**
	 * 
	 * @param startSlotTime
	 * @param endSlotTime
	 * @param practitionerRequest
	 * @return
	 */
	private boolean isTimeInSlotRange(Timestamp startSlotTime,
			Timestamp endSlotTime, int maxPatientsPerDay,
			PractitionerRequest practitionerRequest) {
		boolean inRange = false;
		
		Calendar startSlotCal = Calendar.getInstance();
		startSlotCal.setTimeInMillis(startSlotTime.getTime());
		int startSlotHrs = startSlotCal.get(Calendar.HOUR_OF_DAY);
		int startSlotMin = startSlotCal.get(Calendar.MINUTE);
		
		Calendar endSlotCal = Calendar.getInstance();
		// initially set the start time itself as the time to end slot calendar
		endSlotCal.setTimeInMillis(startSlotTime.getTime());
		// now calculate the end time in hrs and min
		// this will be start time + (no of slots * time per slot)
		long timeDiff = endSlotTime.getTime() - startSlotTime.getTime();
		if(timeDiff > 0){
			int diffHrs = (int)timeDiff / (CreateAppointmentConstants.NUMBER_OF_MILLIS_IN_HR);
			int diffMin = (int)timeDiff - (diffHrs * CreateAppointmentConstants.NUMBER_OF_MILLIS_IN_HR);
			
			endSlotCal.add(Calendar.HOUR_OF_DAY, diffHrs);
			endSlotCal.add(Calendar.MINUTE, diffMin);
		}
		
		int endSlotHrs = endSlotCal.get(Calendar.HOUR_OF_DAY);
		int endSlotMin = endSlotCal.get(Calendar.MINUTE);
		
		String startTime = practitionerRequest.getPreferredStartTime();
		int startHours = getHours(startTime);
		int startMin = getMinutes(startTime);
		
		String endTime = practitionerRequest.getPreferredEndTime();
		int endHours = getHours(endTime);
		int endMin = getMinutes(endTime);
		
		boolean startTimeInRange = false;
		if(startSlotHrs < startHours){
			startTimeInRange = true;
		}else if((startSlotHrs == startHours) && (startSlotMin <= startMin)){
			startTimeInRange = true;
		}
		
		boolean endTimeInRange = false;
		if(endSlotHrs > endHours){
			endTimeInRange = true;
		}else if((endSlotHrs == endHours) && (endSlotMin >= endMin)){
			endTimeInRange = true;
		}
		
		inRange = startTimeInRange && endTimeInRange;
		
		return inRange;
	}
	
	/**
	 * 
	 * @param timeAsString
	 * @return
	 */
	private int getHours(String timeAsString){
		int hours = 0;
		if(timeAsString == null || timeAsString.trim().equals("")){
			return hours;
		}
		
		String delimiter = CreateAppointmentConstants.TIMESLOT_HOUR_DELIMITER;
		//int hrIndex = timeAsString.indexOf(".") ;
		int hrIndex = timeAsString.indexOf(delimiter) ;
		if(hrIndex > 0){
			String hrs = timeAsString.substring(0, hrIndex);
			try {
				hours = Integer.parseInt(hrs);
			} catch (NumberFormatException e) {
				hours = 0;
			}
		}
		return hours;
	}
	
	/**
	 * 
	 * @param timeAsString
	 * @return
	 */
	private int getMinutes(String timeAsString){
		int min = 0;
		if(timeAsString == null || timeAsString.trim().equals("")){
			return min;
		}
		
		String delimiter = CreateAppointmentConstants.TIMESLOT_HOUR_DELIMITER;
		/*int minIndex = timeAsString.lastIndexOf(".");*/
		int minIndex = timeAsString.lastIndexOf(delimiter);
		if(minIndex > 0){
			String mins = timeAsString.substring(minIndex + 1, timeAsString.length());
			try {
				min = Integer.parseInt(mins);
			} catch (NumberFormatException e) {
				min = 0;
			}
		}
		
		return min;
	}
	
	
	/*public static void main(String[] args){
		
		String preferredDateTimeAsString = "28/02/2013 10:00:00";
		Date fromDateTime = PortalHelper.getDateFromString(preferredDateTimeAsString, "dd/MM/yyyy hh:mm:ss");
		
		
		PractitionerDAC dacInst = new PractitionerDAC();
		
		PractitionerRequest request = new PractitionerRequest();
		
		PractitionerResponse response = null;
		
		request.setFacilityId("HS");
		request.setPractitionerId("");
		request.setPositionCode("");
		request.setLocale("en");
		request.setClinicCode("");
		request.setCareLocationIndicator("");
		request.setResourceClass("P");
		request.setCatalogCode("");
		request.setVisitType("");
		request.setOperationStandardId("ALL");
		request.setPreferredFromDateAsString("15/03/2013");
		request.setPreferredFromDateAsString("18/03/2013");
		request.setPreferredFromDateAsString("15/04/2013");
		request.setPreferredToDateAsString("13/04/2013");
		request.setPreferredToDateAsString("16/04/2013");
		request.setPreferredToDateAsString("14/05/2013");
		request.setPreferredStartTime("10:30:00");
		request.setPreferredStartTime("10.30");
		request.setPreferredStartTime("13:30");
		request.setPreferredEndTime("11:30:00");
		request.setPreferredEndTime("11.30");
		request.setPreferredEndTime("14:30");
		
		request.setGender("%");
		request.setPractitionerId("%");
		request.setPractitionerName("%");
		request.setPractitionerType("%");
		request.setPrimarySpecialityCode("%");
		request.setPositionCode("%");
		// 1 speciality code = "123"
		request.setSpecialityCode("123");
		request.setSpecialityCode("BDU");
		
		// 1 speciality code = "123"
		request.setSpecialityCode("25");
		
		// 2 speciality code "22"
		request.setSpecialityCode("123");
		
		//request.setSpecialityCode("BDU");
		long beforeCallTime = System.currentTimeMillis();
		System.out.println("time before making the call ="+beforeCallTime);
		
		response = dacInst.getPractitionerList(request);
		response.printResults();
		long afterCallTime = System.currentTimeMillis();
		System.out.println("time after the call ="+afterCallTime);
		
		System.out.println("Total time taken for the call ="+(afterCallTime - beforeCallTime));
		//System.out.println("obtained the response");
	}*/
	
	
}
