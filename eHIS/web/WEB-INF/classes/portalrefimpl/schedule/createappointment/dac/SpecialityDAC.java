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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import portalrefimpl.PortalHelper;
import portalrefimpl.common.CommonConstants;
import portalrefimpl.common.message.MessageContainer;
import portalrefimpl.common.response.ErrorInfo;
import portalrefimpl.schedule.ScheduleConstants;
import portalrefimpl.schedule.createappointment.request.SpecialityRequest;
import portalrefimpl.schedule.createappointment.response.SpecialityModel;
import portalrefimpl.schedule.createappointment.response.SpecialityResponse;

/**
 * This is the DAC class for getting the list of specialities
 * 
 * @author GRamamoorthy
 *
 */
public class SpecialityDAC {

	/**
	 * This method gets the list of specialities
	 * given a request object which contains the facility id
	 * @param specialityRequest
	 * @return
	 */
	public SpecialityResponse getSpecialityList(SpecialityRequest specialityRequest){
		// initialize the response object and the errorInfo object
		SpecialityResponse specialityResponse = new SpecialityResponse();
		/*ErrorInfo errorInfo = new ErrorInfo();
		specialityResponse.setErrorInfo(errorInfo);*/
		
		ErrorInfo errorInfo = null;

		// get the facility from the request - we have to get
		// the list of specialities for this facility
		/*
		 * Commenting out Facility ID because Speciality list should be regardless of the Facility 
		 * String facilityId = specialityRequest.getFacilityId();
		 */

		// initialize the SQL query
		StringBuffer queryBuff = new StringBuffer();

		/*Commenting since Speciality list should be regardless of the Facility
		queryBuff.append("select am_get_desc.AM_SPECIALITY(speciality_code,'en',2) short_desc,speciality_code from am_speciality where  eff_status='E' and speciality_code  in (select speciality_code from op_clinic where facility_id='"); 
		queryBuff.append(facilityId); 
		queryBuff.append("' and clinic_code in (Select clinic_code from op_clinic a, am_locn_for_oper_stn b where  a.facility_id='"); 
		queryBuff.append(facilityId); 
		queryBuff.append("' and a.facility_id=b.facility_id and a.clinic_code=b.locn_code and a.allow_appt_yn ='Y' and a.level_of_care_ind = 'A' and a.eff_status='E' and b.oper_stn_id='ALL' and b.eff_status='E'))  order by short_desc");
		 */

		queryBuff.append("select am_get_desc.AM_SPECIALITY(speciality_code,'en',2) short_desc,speciality_code from am_speciality where  eff_status='E' and speciality_code  in (select speciality_code from op_clinic where");
		queryBuff.append(" clinic_code in (Select clinic_code from op_clinic a, am_locn_for_oper_stn b where ");
		queryBuff.append(" a.facility_id=b.facility_id and a.clinic_code=b.locn_code and a.allow_appt_yn ='Y' and a.level_of_care_ind = 'A' and a.eff_status='E' and b.oper_stn_id='ALL' and b.eff_status='E'))  order by short_desc");

		// initialize the connection object
		Connection conn = PortalHelper.getConnection();
				
		// safe check
		if (conn == null) {
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(ScheduleConstants.SPECIALITY_LIST_EMPTY_DATA_CODE);
			String errorMessage = MessageContainer.getInstance().getDisplayMessage(CommonConstants.CREATE_APPOINTMENT_MODULE_NAME,
					ScheduleConstants.SPECIALITY_LIST_EMPTY_DATA_CODE);
			errorInfo.setErrorMessage(errorMessage);
			specialityResponse.addError(errorInfo);
			return specialityResponse;
		}
		
		// initialize the statement and result object
		// for execution of the SQL query
		Statement stmt = null;
		ResultSet rs = null;
		// local vars for use
		List<SpecialityModel> modelList = new ArrayList<SpecialityModel>();
		SpecialityModel specialityModel = null;
		String shortDesc = null;
		String specialityCode = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(queryBuff.toString());
			if(rs != null){
				// iterate through the result set
				// and fill the speciality model list
				while(rs.next()){
					shortDesc = rs.getString("SHORT_DESC");
					specialityCode = rs.getString("SPECIALITY_CODE");
					
					specialityModel = new SpecialityModel(shortDesc,specialityCode);
					modelList.add(specialityModel);
				}
				
				/**
				 * check the size of the model list
				 * if it is zero, then we need to form the
				 * error code and error message
				 */
				if(modelList.isEmpty()){
					errorInfo = new ErrorInfo();
					errorInfo.setErrorCode(ScheduleConstants.SPECIALITY_LIST_EMPTY_DATA_CODE);
					String errorMessage = MessageContainer.getInstance().getDisplayMessage(CommonConstants.CREATE_APPOINTMENT_MODULE_NAME,
							ScheduleConstants.SPECIALITY_LIST_EMPTY_DATA_CODE);
					errorInfo.setErrorMessage(errorMessage);
					specialityResponse.addError(errorInfo);
					return specialityResponse;
				}
				
				specialityResponse.setSpecialityList(modelList);
				// set the model list to the response object
				errorInfo = new ErrorInfo();
				errorInfo.setErrorCode(ErrorInfo.SUCCESS_CODE);
				specialityResponse.addError(errorInfo);
			} else {
				errorInfo = new ErrorInfo();
				errorInfo.setErrorCode(ScheduleConstants.SPECIALITY_LIST_EMPTY_DATA_CODE);
				String errorMessage = MessageContainer.getInstance().getDisplayMessage(CommonConstants.CREATE_APPOINTMENT_MODULE_NAME,
						ScheduleConstants.SPECIALITY_LIST_EMPTY_DATA_CODE);
				errorInfo.setErrorMessage(errorMessage);
				specialityResponse.addError(errorInfo);
				return specialityResponse;
			}
		} catch (SQLException e) {
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(ScheduleConstants.SPECIALITY_LIST_EMPTY_DATA_CODE);
			String errorMessage = MessageContainer.getInstance().getDisplayMessage(CommonConstants.CREATE_APPOINTMENT_MODULE_NAME,
					ScheduleConstants.SPECIALITY_LIST_EMPTY_DATA_CODE);
			errorInfo.setErrorMessage(errorMessage);
			specialityResponse.addError(errorInfo);
			return specialityResponse;
		} finally {
			PortalHelper.closeResources(conn, stmt, rs);
			/*if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			
			if(stmt != null){
				try {
					stmt.close();
				} catch (SQLException e) {
				}
			}
			conn = null;*/
		}
		
		return specialityResponse;
	}
	
}
