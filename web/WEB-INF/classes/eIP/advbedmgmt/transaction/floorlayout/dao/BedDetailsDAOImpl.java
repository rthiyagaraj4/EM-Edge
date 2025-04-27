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
package eIP.advbedmgmt.transaction.floorlayout.dao;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Struct;
import java.sql.Types;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import webbeans.eCommon.ConnectionManager;
import eCommon.Common.CommonAdapter;
import eIP.advbedmgmt.GBMConstants;
import eIP.advbedmgmt.common.CommonConstants;
import eIP.advbedmgmt.common.CommonResourceConstants;
import eIP.advbedmgmt.common.ErrorConstants;
import eIP.advbedmgmt.common.model.BasicBed;
import eIP.advbedmgmt.common.model.BasicRoom;
import eIP.advbedmgmt.common.model.Bed;
import eIP.advbedmgmt.common.model.Patient;
import eIP.advbedmgmt.common.model.Practitioner;
import eIP.advbedmgmt.common.model.Room;
import eIP.advbedmgmt.common.resourcebundle.BundleManager;
import eIP.advbedmgmt.common.response.ErrorInfo;
import eIP.advbedmgmt.transaction.BedHelper;
import eIP.advbedmgmt.transaction.floorlayout.FloorLayoutConstants;
import eIP.advbedmgmt.transaction.floorlayout.FloorLayoutResourceConstants;
import eIP.advbedmgmt.transaction.floorlayout.request.BasicBedDetailsRequest;
import eIP.advbedmgmt.transaction.floorlayout.request.BedIconRequest;
import eIP.advbedmgmt.transaction.floorlayout.request.BedStatusRequest;
import eIP.advbedmgmt.transaction.floorlayout.response.BasicBedDetailsResponse;
import eIP.advbedmgmt.transaction.floorlayout.response.BedIconResponse;
import eIP.advbedmgmt.transaction.floorlayout.response.BedIconSection;
import eIP.advbedmgmt.transaction.floorlayout.response.BedStatusResponse;
import eIP.advbedmgmt.transaction.floorlayout.response.RoomForBedIconSection;

/**
 * This is the DAO implementation class for getting bed details This class
 * implements BedDetailsDAO interface
 * 
 * @author GRamamoorthy
 * 
 */
public class BedDetailsDAOImpl implements BedDetailsDAO {

	/**
	 * This method gets the basic bed details the bed details will have room
	 * details (room number, room dimensions), bed details (bed number,
	 * occupying patient details, practitioner details) This will not contain
	 * the bed statuses
	 * 
	 * @param request
	 * @return
	 */
	public BasicBedDetailsResponse getBasicBedDetails(
			BasicBedDetailsRequest request) {
		BasicBedDetailsResponse response = new BasicBedDetailsResponse();
		ErrorInfo errorInfo = null;
		int errorCode = ErrorInfo.SUCCESS_CODE;
		String errorMessage = null;

		// initialize the logger
		Logger loggerInst = Logger.getLogger("APPLICATION_LOG");
		StringBuilder logMessage = new StringBuilder();
		// get the connection
		Connection conn = getConnection();// ConnectionManager.getConnection();
		// safe check
		if (conn == null) {
			errorCode = ErrorInfo.DATABASE_CONNECTION_FAILURE_CODE;
			// logging done here
			logMessage.append(GBMConstants.GBM_MODULE_IDENTIFIER).append(":");
			logMessage
					.append("Could not get basic bed details. Cause = Could not get connection to database");
			if (loggerInst != null) {
				loggerInst.fatal(logMessage.toString());
			}

			// get the error message from resource bundle through bundle manager
			errorMessage = BundleManager
					.getInstance()
					.getDisplayMessageFromBundle(
							ErrorInfo.DATABASE_CONNECTION_FAILURE_CODE,
							CommonResourceConstants.COMMON_RESOURCES_FILE_CLASSPATH);
			
			// code written to get the specific message for this
			// operation and then add it to the original message
			String specificErrorMessage = BundleManager
					.getInstance()
					.getDisplayMessageFromBundle(
							FloorLayoutResourceConstants.BASIC_BED_DETAILS_CONNECTION_ERROR_KEY,
							FloorLayoutResourceConstants.FLOOR_LAYOUT_RESOURCE_MESSAGE_FILE_PATH); 
			
			errorMessage = MessageFormat.format(errorMessage, specificErrorMessage);
			
			// form the error info object and set it to response
			errorInfo = new ErrorInfo(errorCode, errorMessage);
			response.addError(errorInfo);
			return response;
		}
		// get the SQL query to be executed and execute it
		String sqlQuery = getBasicBedDetailsQuery(request);
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		try {
			prepStmt = conn.prepareStatement(sqlQuery);
			setDataInStatement(prepStmt, request);
			rs = prepStmt.executeQuery();
			// safe check
			if (rs == null) {
				errorCode = ErrorConstants.BASIC_BED_DETAILS_NULL_RESULTSET_ERRORCODE;//FloorLayoutConstants.BASIC_BED_DETAILS_NULL_RESULTSET_ERRORCODE;
				// logging done here
				logMessage.append(GBMConstants.GBM_MODULE_IDENTIFIER).append(
						":");
				logMessage
						.append("Could not get basic bed details. Cause = Result set is null");
				if (loggerInst != null) {
					loggerInst.fatal(logMessage.toString());
				}

				// obtain the error message
				errorMessage = BundleManager
						.getInstance()
						.getDisplayMessageFromBundle(
								errorCode,
								FloorLayoutResourceConstants.FLOOR_LAYOUT_RESOURCE_MESSAGE_FILE_PATH);
				errorInfo = new ErrorInfo(errorCode, errorMessage);
				response.addError(errorInfo);
				return response;
			}
			// call the method which will set data to the response object
			setDataInResponse(rs, response);
			
			// call the method to set the back ground color of
			// the rooms which are part of the response
			setRoomsWithBackgroundColor(response,conn,loggerInst);

		} catch (SQLException e) {
			// logging done here
			logMessage.append(GBMConstants.GBM_MODULE_IDENTIFIER).append(":");
			logMessage
					.append("Could not get basic bed details. Cause = SQLException. Exception message = ")
					.append(e.getMessage());
			if (loggerInst != null) {
				loggerInst.fatal(logMessage.toString());
			}

			errorCode = ErrorConstants.BASIC_BED_DETAILS_SQLEXCEPTION_ERRORCODE;// FloorLayoutConstants.BASIC_BED_DETAILS_SQLEXCEPTION_ERRORCODE;
			// obtain the error message
			errorMessage = BundleManager
					.getInstance()
					.getDisplayMessageFromBundle(
							errorCode,
							FloorLayoutResourceConstants.FLOOR_LAYOUT_RESOURCE_MESSAGE_FILE_PATH);
			// add error info to response
			errorInfo = new ErrorInfo(errorCode, errorMessage);
			response.addError(errorInfo);
			return response;
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// cannot do much
				}
			}
			if (prepStmt != null) {
				try {
					prepStmt.close();
				} catch (SQLException e) {
					// cannot do much
				}
			}
			if (conn != null) {
				ConnectionManager.returnConnection(conn);
			}
		}

		return response;
	}

	/**
	 * This method forms the SQL query to get the basic bed details
	 * 
	 * @param request
	 * @return
	 */
	private String getBasicBedDetailsQuery(BasicBedDetailsRequest request) {
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder
				.append("select a.FACILITY_ID, a.NURSING_UNIT_CODE,a.BED_NO, a.BED_CLASS_CODE, a.BED_TYPE_CODE, ");
		queryBuilder
				.append("a.ROOM_NO,am_get_desc.AM_FACILITY_ROOM(a.facility_id, a.room_no,?,'2') room_num_desc,a.PSEUDO_BED_YN, ");
		queryBuilder
				.append("a.SPECIALTY_CODE,a.OCCUPYING_PATIENT_ID,a.OCCUPIED_UNTIL_DATE_TIME,a.CURRENT_STATUS, ");
		queryBuilder
				.append("a.MAIN_BED_NO, a.MOTHERS_PATIENT_ID,a.MOTHERS_ENCOUNTER_ID,a.EFF_STATUS,a.BED_LEFT_POSITION, ");
		queryBuilder.append("a.BED_TOP_POSITION,a.BED_HEIGHT,a.BED_WIDTH, ");
		queryBuilder
				.append("b.ROOM_LEFT_POSITION,b.ROOM_TOP_POSITION,b.ROOM_HEIGHT,b.ROOM_WIDTH, ");
		queryBuilder
				.append("c.encounter_id,c.Attend_Practitioner_Id,Am_Get_desc.AM_PRACTITIONER(c.Attend_Practitioner_Id,?,'1') practitioner_name ");
		queryBuilder
				.append(",d.patient_name,nvl(d.patient_name_loc_lang,d.patient_name) patient_name_loc_lang ");
		queryBuilder.append(",d.sex,get_age(d.date_of_birth) age ");
		
		// query segment added to get the bed status and the booking type
		// this is needed for calculating transaction allowed status
		queryBuilder.append(",( ");
		queryBuilder.append("	    CASE   ");
		queryBuilder.append("	        WHEN a.occupying_patient_id IS NOT NULL THEN 'O'  ");
		queryBuilder.append("	        WHEN e.booking_type IS NULL THEN 'A'  ");
		queryBuilder.append("	        WHEN e.booking_type in ('N','B','L','T','D') THEN 'B' ");
		queryBuilder.append("	        ELSE 'U'        ");
		queryBuilder.append("	    END ");
		queryBuilder.append("	) bed_status ");
		queryBuilder.append("	,e.booking_type ");
		
		
		queryBuilder.append("from ");
		queryBuilder.append("IP_NURSING_UNIT_BED a, ip_nursing_unit_room b, ");
		queryBuilder.append("IP_OPEN_ENCOUNTER c,MP_PATIENT d  ");
		// query segment added to include the table 
		queryBuilder.append(",IP_BED_BOOKING e ");
		
		queryBuilder.append("where ");
		// realigned the where clauses for better performance
		queryBuilder.append("a.ROOM_NO = b.ROOM_NO and ");
		queryBuilder.append("a.OCCUPYING_PATIENT_ID = c.Patient_Id (+) and ");
		queryBuilder.append("a.OCCUPYING_PATIENT_ID = d.Patient_Id (+) and ");
		queryBuilder.append("a.nursing_unit_code=? AND ");
		queryBuilder.append("a.bed_no LIKE ?  and ");
		queryBuilder.append("a.facility_id = ? and ");
		//queryBuilder.append("a.BED_LEFT_POSITION is not null and ");
		queryBuilder.append("b.ROOM_LEFT_POSITION is not null and ");
		// new clauses added to filter with IP_BED_BOOKING 
		queryBuilder.append("a.facility_id  =  e.facility_id  (+)  AND ");
		queryBuilder.append("a.OCCUPYING_PATIENT_ID = e.Patient_Id (+) and ");        
		queryBuilder.append("a.nursing_unit_code = e.req_nursing_unit_code  (+)  AND ");
		queryBuilder.append("a.bed_no  = e.req_bed_no  (+) ");
	
		return queryBuilder.toString();
	}

	
	
	/**
	 * This method sets data to the prepared statement instance based on the
	 * input request object
	 * 
	 * @param prepStmt
	 * @param request
	 * @throws SQLException
	 */
	private void setDataInStatement(PreparedStatement prepStmt,
			BasicBedDetailsRequest request) throws SQLException {
		// used to set data at specific index
		int index = 1;
		
		// first set language
		String locale = request.getLocale();
		prepStmt.setString(index, locale);
		index++;
		prepStmt.setString(index, locale);
		index++;
		
		// set the nursing unit code
		String nursingUnitCode = request.getNursingUnitCode();
		prepStmt.setString(index, nursingUnitCode);
		index++;
		// next comes bed number
		String bedNumber = request.getBedNumber();
		prepStmt.setString(index, bedNumber);
		index++;
		// facility id at the last
		String facilityId = request.getFacilityId();
		prepStmt.setString(index, facilityId);
	}

	/**
	 * This method gets data from the result set and sets it in the response
	 * object
	 * 
	 * @param rs
	 * @param response
	 * @throws SQLException
	 */
	private void setDataInResponse(ResultSet rs,
			BasicBedDetailsResponse response) throws SQLException {
		// initialize the list which will store the data
		List<Room> rooms = new ArrayList<Room>();

		// local vars
		// room related
		String facilityId = null;
		String nursingUnitCode = null;
		String roomNumber = null;
		String roomDesc = null;
		int roomLeftPosition = 0;
		int roomTopPosition = 0;
		int roomHeight = 0;
		int roomWidth = 0;
		// bed related
		String bedNumber = null;

		int bedLeftPosition = 0;
		int bedTopPosition = 0;
		int bedHeight = 0;
		int bedWidth = 0;
		String bedClassCode = null;
		String bedTypeCode = null;
		String specialtyCode = null;
		String pseudoBedYN = null;
		boolean pseudoBed = false;
		String currentStatus = null;
		String effStatus = null;
		
		String bedStat = null;
		String bookingType = null;
		final String DEFAULT_TRNS_ALLOWED = "Y";
		final String TRNS_ALLOWED_NO = "N";
		String trnsAllowed = null;

		Room room = null;
		List<Bed> beds = null;
		Bed bed = null;
		// holds the current room
		Room tempRoom = null;
		// iterate through the result set and get data
		while (rs.next()) {
			// get data for room
			facilityId = rs.getString("FACILITY_ID");
			nursingUnitCode = rs.getString("NURSING_UNIT_CODE");
			roomNumber = rs.getString("ROOM_NO");
			roomDesc = rs.getString("ROOM_NUM_DESC");
			roomLeftPosition = rs.getInt("ROOM_LEFT_POSITION");
			roomTopPosition = rs.getInt("ROOM_TOP_POSITION");
			roomHeight = rs.getInt("ROOM_HEIGHT");
			roomWidth = rs.getInt("ROOM_WIDTH");
			// create room instance
			room = new Room(facilityId, nursingUnitCode, roomNumber, roomDesc,
					roomLeftPosition, roomTopPosition, roomHeight, roomWidth);
			// there is a need to check if a room object already exists for this
			// record
			// if so, get it and add a new bed object in it
			if (rooms.contains(room)) {
				// exception handling is not done for below code
				// since if the rooms list contains the room instance
				// then valid index and room instance will be obtained
				int index = rooms.indexOf(room);
				tempRoom = rooms.get(index);
				beds = tempRoom.getBeds();
			} else {
				// just making sure that temproom is always the current room
				tempRoom = room;
				rooms.add(room);
				beds = new ArrayList<Bed>();
				room.setBeds(beds);
			}
			// get the data for bed
			bedNumber = rs.getString("BED_NO");

			bedLeftPosition = rs.getInt("BED_LEFT_POSITION");
			bedTopPosition = rs.getInt("BED_TOP_POSITION");
			bedHeight = rs.getInt("BED_HEIGHT");
			bedWidth = rs.getInt("BED_WIDTH");
			
			// bed dimensions have to be valid
			if(bedHeight == 0 && bedWidth == 0){
				continue;
			}
			
			// create bed instance and add it to beds list
			// the bed instance is created with most necessary data
			bed = new Bed(bedNumber, bedLeftPosition, bedTopPosition,
					bedHeight, bedWidth);
			beds.add(bed);

			// also set other data in bed instance
			bedClassCode = rs.getString("BED_CLASS_CODE");
			bedTypeCode = rs.getString("BED_TYPE_CODE");
			specialtyCode = rs.getString("SPECIALTY_CODE");
			pseudoBedYN = rs.getString("PSEUDO_BED_YN");
			if ("Y".equals(pseudoBedYN)) {
				pseudoBed = true;
			}
			currentStatus = rs.getString("CURRENT_STATUS");
			effStatus = rs.getString("EFF_STATUS");
			bed.setBedClassCode(bedClassCode);
			bed.setBedTypeCode(bedTypeCode);
			bed.setSpecialtyCode(specialtyCode);
			bed.setPsuedoBed(pseudoBed);
			bed.setCurrentStatus(currentStatus);
			bed.setEffectiveStatus(effStatus);
			
			// need to get new parameters like bed status, booking type
			bedStat = rs.getString("bed_status");
			bookingType = rs.getString("booking_type");
			// transaction allowed is always set to "Y" for every bed by default
			trnsAllowed = DEFAULT_TRNS_ALLOWED;
			// transaction allowed is set to "N" only under the below scenario
			if ((bookingType != null && bookingType.equals("N"))
					&& (bedStat != null && bedStat.equals("B"))) {
				trnsAllowed = TRNS_ALLOWED_NO;
			}
			
			// set the extra params
			bed.setBedStat(bedStat);
			bed.setBookingType(bookingType);
			bed.setTrnsAllowed(trnsAllowed);

			// get the patient details and set it to bed instance
			Patient patientDetails = getPatientDetails(rs);
			bed.setPatientDetails(patientDetails);
		}

		// finally set the rooms list to the response object
		response.setRooms(rooms);
		// also set a success errorinfo object to response
		ErrorInfo errorInfo = new ErrorInfo(ErrorInfo.SUCCESS_CODE, null);
		response.addError(errorInfo);
	}

	/**
	 * This method gets patient related data from result set and returns an
	 * instance of patient object with data
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private Patient getPatientDetails(ResultSet rs) throws SQLException {
		// patient related
		String patientId = null;
		String patientName = null;
		String patientDisplayName = null;
		String patientGender = null;
		String patientAge = null;
		Date occupiedUntilDateTime = null;
		String encounterId = null;

		// now patient details
		patientId = rs.getString("OCCUPYING_PATIENT_ID");
		patientId = CommonAdapter.checkForNull(patientId);
		patientName = rs.getString("PATIENT_NAME");
		patientName = CommonAdapter.checkForNull(patientName);
		patientDisplayName = rs.getString("PATIENT_NAME_LOC_LANG");
		patientDisplayName = CommonAdapter.checkForNull(patientDisplayName);
		encounterId = rs.getString("ENCOUNTER_ID");
		encounterId = CommonAdapter.checkForNull(encounterId);
		patientGender = rs.getString("SEX");
		patientGender = CommonAdapter.checkForNull(patientGender);
		patientAge = rs.getString("AGE");
		patientAge = CommonAdapter.checkForNull(patientAge);
		occupiedUntilDateTime = rs.getTimestamp("OCCUPIED_UNTIL_DATE_TIME");

		// instantiate patient object
		Patient patientDetails = new Patient(patientId, patientName,
				patientDisplayName);
		patientDetails.setGender(patientGender);
		patientDetails.setAge(patientAge);
		patientDetails.setEncounterId(encounterId);
		patientDetails.setOccupiedUntilDateTime(occupiedUntilDateTime);

		// now practitioner level data
		// instantiate practitioner object and set it to patient details
		String practId = rs.getString("ATTEND_PRACTITIONER_ID");
		String practName = rs.getString("PRACTITIONER_NAME");
		Practitioner practitionerDetails = new Practitioner(practId, practName);

		patientDetails.setPractitionerDetails(practitionerDetails);

		return patientDetails;
	}
	
	/**
	 * This method will set the rooms in the basic bed details with
	 * back ground color 
	 * @param response
	 * @param conn
	 */
	private void setRoomsWithBackgroundColor(BasicBedDetailsResponse response,
			Connection conn,Logger loggerInst) {
		// do the entire operation only when the response is successful
		if(response.isSuccessful()){
			List<Room> rooms = response.getRooms();
			if(rooms != null && !rooms.isEmpty()){
				// call the method to get the room back ground color
				String roomBackgndColor = getRoomBackgroundColor(conn,loggerInst);
				// iterate through rooms and set the back ground color
				for(Room room: rooms){
					room.setRoomBackgndColor(roomBackgndColor);
				}
			}
		}
	}
	
	/**
	 * This method will get the room back ground color
	 * @param conn
	 * @return
	 */
	private String getRoomBackgroundColor(Connection conn, Logger loggerInst) {
		String roomBackgroundColor = null;

		String sqlQuery = "select backgndcolor from GBM_COLOR_CONFIG where stat = 'ROOM_BCKGND'";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlQuery);
			if (rs == null) {
				if (loggerInst != null) {
					String message = "Could not obtain room background color - resultset is null.";
					loggerInst.debug(message);
				}
				roomBackgroundColor = FloorLayoutConstants.ROOM_DEFAULT_BACKGND_COLOR;
				return roomBackgroundColor;
			}

			if (rs.next()) {
				roomBackgroundColor = rs
						.getString(FloorLayoutConstants.ROOM_BACKGROUND_COL_NAME);
			}

		} catch (SQLException sqlEx) {
			// cannot do much
			// log
			if (loggerInst != null) {
				String message = "Could not obtain room background color";
				loggerInst.debug(message);
			}

			roomBackgroundColor = FloorLayoutConstants.ROOM_DEFAULT_BACKGND_COLOR;
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// cannot do much
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// cannot do much
				}
			}
		}

		return roomBackgroundColor;
	}
	

	/**
	 * 
	 * @return
	 */
	private Connection getConnection() {
		Connection conn = ConnectionManager.getConnection();
		/*
		 * Connection conn = null; try {
		 * Class.forName("oracle.jdbc.driver.OracleDriver"); } catch
		 * (ClassNotFoundException e) { e.printStackTrace(); return conn; }
		 * String userName = "appluser"; userName = "IBAEHIS"; String password =
		 * "appluser"; password = "IBAEHIS"; try { conn =
		 * DriverManager.getConnection(
		 * "jdbc:oracle:thin:@130.78.62.59:1521:srdv", userName, password);
		 * System.out.println("successful in getting connection"); } catch
		 * (SQLException e) {
		 * System.out.println("Could not get connection - program terminates");
		 * }
		 */

		return conn;
	}

	/**
	 * Method to close the connection
	 */
	private void closeConnection(Connection conn) {
		ConnectionManager.returnConnection(conn);
	}

	/**
	 * This method gets the status of individual beds
	 */
	public BedStatusResponse getBedStatus(BedStatusRequest request) {
		// initialize response
		BedStatusResponse response = new BedStatusResponse();
		ErrorInfo errorInfo = null;
		int errorCode = ErrorInfo.SUCCESS_CODE;
		String errorMessage = null;

		// initialize logger
		Logger loggerInst = Logger.getLogger("APPLICATION_LOG");
		StringBuilder logMessage = new StringBuilder();

		Connection conn = getConnection();// ConnectionManager.getConnection();
		// safe check
		if (conn == null) {
			errorCode = ErrorInfo.DATABASE_CONNECTION_FAILURE_CODE;
			// log it
			logMessage.append(GBMConstants.GBM_MODULE_IDENTIFIER).append(":");
			logMessage
					.append("Could not get bed statuses. Cause = Could not get connection to database");
			if (loggerInst != null) {
				loggerInst.fatal(logMessage.toString());
			}

			errorMessage = BundleManager
					.getInstance()
					.getDisplayMessageFromBundle(
							ErrorInfo.DATABASE_CONNECTION_FAILURE_CODE,
							CommonResourceConstants.COMMON_RESOURCES_FILE_CLASSPATH);
			
			// code written to get the specific message for this
			// operation and then add it to the original message
			String specificErrorMessage = BundleManager
					.getInstance()
					.getDisplayMessageFromBundle(
							FloorLayoutResourceConstants.BED_STAT_CONNECTION_ERROR_KEY,
							FloorLayoutResourceConstants.FLOOR_LAYOUT_RESOURCE_MESSAGE_FILE_PATH);

			errorMessage = MessageFormat.format(errorMessage,
					specificErrorMessage);
			
			// form error object
			errorInfo = new ErrorInfo(errorCode, errorMessage);
			response.addError(errorInfo);
			return response;
		}

		String spCallString = "{call GBM_GET_BED_STATUS_PKG.GBM_GET_BED_STATUSES(?,?,?,?,?)}";
		CallableStatement callStmt = null;
		try {
			callStmt = conn.prepareCall(spCallString);
			setDataInCallStmtForBedStatus(callStmt, request);
			callStmt.execute();
			processBedStatusData(response, callStmt, request, loggerInst);
		} catch (SQLException e) {
			// log and set error in response
			errorCode = ErrorConstants.BED_STATUS_SQLEXCEPTION_ERRORCODE;// FloorLayoutConstants.BED_STATUS_SQLEXCEPTION_ERRORCODE;
			if (loggerInst != null) {
				logMessage.append(GBMConstants.GBM_MODULE_IDENTIFIER).append(
						":");
				String resourceMessage = BundleManager
						.getInstance()
						.getLogMessageFromBundle(
								errorCode,
								FloorLayoutResourceConstants.FLOOR_LAYOUT_RESOURCE_MESSAGE_FILE_PATH);
				resourceMessage = MessageFormat.format(resourceMessage,
						new Object[] { e.getMessage() });
				logMessage.append(resourceMessage);
				loggerInst.fatal(logMessage.toString());
			}

			// obtain the error message
			errorMessage = BundleManager
					.getInstance()
					.getDisplayMessageFromBundle(
							errorCode,
							FloorLayoutResourceConstants.FLOOR_LAYOUT_RESOURCE_MESSAGE_FILE_PATH);
			// add error info to response
			errorInfo = new ErrorInfo(errorCode, errorMessage);
			response.addError(errorInfo);
			return response;
		} finally {
			if (callStmt != null) {
				try {
					callStmt.close();
				} catch (SQLException e) {
					// not much can be done
				}
			}
			closeConnection(conn);
		}

		return response;
	}

	/**
	 * This method registers the input and output parameters in the callable
	 * statement using data from the request object
	 * 
	 * @param callStmt
	 * @param request
	 * @throws SQLException
	 */
	private void setDataInCallStmtForBedStatus(CallableStatement callStmt,
			BedStatusRequest request) throws SQLException {
		// set all inputs first
		int index = 1;
		String facId = request.getFacilityId();
		callStmt.setString(index, facId);
		index++;
		String nuCode = request.getNursingUnitCode();
		callStmt.setString(index, nuCode);
		index++;
		String bedNum = request.getBedNumber();
		callStmt.setString(index, bedNum);
		index++;

		// output parameters
		callStmt.registerOutParameter(index, Types.ARRAY,
				"GBM_OP_BED_STAT_WITH_ROOM_TAB");
		index++;
		callStmt.registerOutParameter(index, Types.VARCHAR);

	}

	/**
	 * This method processes data to the bed status response
	 * 
	 * @param response
	 * @param callStmt
	 * @param request
	 * @param loggerInst
	 * @throws SQLException
	 */
	private void processBedStatusData(BedStatusResponse response,
			CallableStatement callStmt, BedStatusRequest request,
			Logger loggerInst) throws SQLException {

		final int ERROR_MSG_INDEX = 5;
		final int OP_INDEX = 4;

		String spExecuteMessage = null;
		spExecuteMessage = callStmt.getString(ERROR_MSG_INDEX);
		// error scenario
		ErrorInfo errorInfo = null;
		int errorCode = ErrorInfo.SUCCESS_CODE;
		String errorMessage = null;
		if (spExecuteMessage != null && !spExecuteMessage.trim().equals("")) {
			// log and set error in response
			errorCode = ErrorConstants.BED_STATUS_SP_EXECUTE_ERRORCODE;// FloorLayoutConstants.BED_STATUS_SP_EXECUTE_ERRORCODE;

			if (loggerInst != null) {
				String resourceMessage = BundleManager
						.getInstance()
						.getLogMessageFromBundle(
								errorCode,
								FloorLayoutResourceConstants.FLOOR_LAYOUT_RESOURCE_MESSAGE_FILE_PATH);
				resourceMessage = MessageFormat.format(resourceMessage,
						new Object[] { spExecuteMessage });
				loggerInst.error(resourceMessage);
			}

			errorMessage = BundleManager
					.getInstance()
					.getDisplayMessageFromBundle(
							errorCode,
							FloorLayoutResourceConstants.FLOOR_LAYOUT_RESOURCE_MESSAGE_FILE_PATH);
			errorInfo = new ErrorInfo(errorCode, errorMessage);
			response.addError(errorInfo);
			return;
		}

		int numBeds = request.getBedCount();

		// stores rooms
		List<BasicRoom> roomList = new ArrayList<BasicRoom>();
		BasicRoom room = null;
		List<BasicBed> bedList = null;
		BasicBed bedInst = null;

		// get data from callable statement
		Object opObj = callStmt.getObject(OP_INDEX);
		if (opObj instanceof Array) {
			Array opArr = (Array) opObj;
			Object val = opArr.getArray(1, numBeds);
			Object[] valArr = null;
			if (val instanceof Object[]) {
				valArr = (Object[]) val;
				Object valArrChild = null;
				Struct structObj = null;
				Object[] structAttributes = null;
				int valArrLen = valArr.length;
				for (int count = 0; count < valArrLen; count++) {
					valArrChild = valArr[count];
					if (valArrChild instanceof Struct) {
						structObj = (Struct) valArrChild;
						structAttributes = structObj.getAttributes();
						// safe way
						if (structAttributes == null) {
							continue;
						}

						// get room instance
						room = getRoom(structAttributes, request);
						// add the room instance if valid
						if (!room.isValid()) {
							continue;
						}

						if (!roomList.contains(room)) {
							roomList.add(room);
							bedList = new ArrayList<BasicBed>();
							room.setBedList(bedList);
						} else {
							// get the room instance from the list
							// and then get the bed list 
							int index = roomList.indexOf(room);
							room = roomList.get(index);
							bedList = room.getBedList();
						}

						// now add the bed instance to list
						bedInst = BedHelper.getBedInstance(structAttributes);
						bedList.add(bedInst);
					}
				}
			}
		}

		// safe check
		if (roomList.isEmpty()) {
			// log and set error in response
			errorCode = ErrorConstants.BED_STATUS_EMPTY_ROOMLIST_ERRORCODE;// FloorLayoutConstants.BED_STATUS_EMPTY_ROOMLIST_ERRORCODE;

			if (loggerInst != null) {
				String resourceMessage = BundleManager
						.getInstance()
						.getLogMessageFromBundle(
								errorCode,
								FloorLayoutResourceConstants.FLOOR_LAYOUT_RESOURCE_MESSAGE_FILE_PATH);
				loggerInst.error(resourceMessage);
			}

			errorMessage = BundleManager
					.getInstance()
					.getDisplayMessageFromBundle(
							errorCode,
							FloorLayoutResourceConstants.FLOOR_LAYOUT_RESOURCE_MESSAGE_FILE_PATH);
			errorInfo = new ErrorInfo(errorCode, errorMessage);
			response.addError(errorInfo);
		} else {
			response.setRoomList(roomList);
			errorInfo = new ErrorInfo(ErrorInfo.SUCCESS_CODE, null);
			response.addError(errorInfo);
		}

	}

	/**
	 * This method creates an instance of BasicRoom class and returns it The
	 * object[] passed here is not null
	 * 
	 * @param structAttributes
	 * @param request
	 * @return
	 */
	private BasicRoom getRoom(Object[] structAttributes,
			BedStatusRequest request) {
		BasicRoom room = new BasicRoom();

		// set facility id and nursing unit code
		String facilityId = request.getFacilityId();
		String nuCode = request.getNursingUnitCode();
		room.setFacilityId(facilityId);
		room.setNursingUnitCode(nuCode);

		// get room number after a basic validity check
		int attrLen = structAttributes.length;
		if (attrLen < CommonConstants.TOTAL_STATUS_IDENTIFIERS_COUNT) {
			room.setValid(false);
			return room;
		}

		String roomNumber = (String) structAttributes[CommonConstants.BED_STAT_ROOM_NUM_INDEX];
		room.setRoomNumber(roomNumber);

		return room;
	}

	/**
	 * This method gets the icon section of individual beds
	 */
	public BedIconResponse getBedIconSection(BedIconRequest request) {
		// initialize response
		BedIconResponse response = new BedIconResponse();
		ErrorInfo errorInfo = null;
		int errorCode = ErrorInfo.SUCCESS_CODE;
		String errorMessage = null;

		// initialize logger
		Logger loggerInst = Logger.getLogger("APPLICATION_LOG");
		StringBuilder logMessage = new StringBuilder();

		Connection conn = getConnection();// ConnectionManager.getConnection();
		// safe check
		if (conn == null) {
			errorCode = ErrorInfo.DATABASE_CONNECTION_FAILURE_CODE;
			// log it
			logMessage.append(GBMConstants.GBM_MODULE_IDENTIFIER).append(":");
			logMessage
					.append("Could not get bed icon section details. Cause = Could not get connection to database");
			if (loggerInst != null) {
				loggerInst.fatal(logMessage.toString());
			}

			errorMessage = BundleManager
					.getInstance()
					.getDisplayMessageFromBundle(
							ErrorInfo.DATABASE_CONNECTION_FAILURE_CODE,
							CommonResourceConstants.COMMON_RESOURCES_FILE_CLASSPATH);
			// code written to get the specific message for this
			// operation and then add it to the original message
			String specificErrorMessage = BundleManager
					.getInstance()
					.getDisplayMessageFromBundle(
							FloorLayoutResourceConstants.BED_ICON_SECT_CONNECTION_ERROR_KEY,
							FloorLayoutResourceConstants.FLOOR_LAYOUT_RESOURCE_MESSAGE_FILE_PATH);

			errorMessage = MessageFormat.format(errorMessage,
					specificErrorMessage);
			
			// form error object
			errorInfo = new ErrorInfo(errorCode, errorMessage);
			response.addError(errorInfo);
			return response;
		}

		String spCallString = "{call GBM_GET_BED_ICON_STAT_PKG.GBM_GET_BED_ICON_STATUSES(?,?,?,?,?,?,?)}";
		CallableStatement callStmt = null;
		try {
			callStmt = conn.prepareCall(spCallString);
			setDataInCStmtForBedIconSection(callStmt, request);
			callStmt.execute();
			processBedIconSectionData(response, request, callStmt, loggerInst);
		} catch (SQLException e) {
			// log and set error in response
			errorCode = ErrorConstants.BED_ICON_SECTION_SQLEXCEPTION_ERRORCODE;// FloorLayoutConstants.BED_ICON_SECTION_SQLEXCEPTION_ERRORCODE;
			if (loggerInst != null) {
				logMessage.append(GBMConstants.GBM_MODULE_IDENTIFIER).append(
						":");
				String resourceMessage = BundleManager
						.getInstance()
						.getLogMessageFromBundle(
								errorCode,
								FloorLayoutResourceConstants.FLOOR_LAYOUT_RESOURCE_MESSAGE_FILE_PATH);
				resourceMessage = MessageFormat.format(resourceMessage,
						new Object[] { e.getMessage() });
				logMessage.append(resourceMessage);
				loggerInst.fatal(logMessage.toString());
			}

			// obtain the error message
			errorMessage = BundleManager
					.getInstance()
					.getDisplayMessageFromBundle(
							errorCode,
							FloorLayoutResourceConstants.FLOOR_LAYOUT_RESOURCE_MESSAGE_FILE_PATH);
			// add error info to response
			errorInfo = new ErrorInfo(errorCode, errorMessage);
			response.addError(errorInfo);
		} finally {
			if (callStmt != null) {
				try {
					callStmt.close();
				} catch (SQLException e) {
					// not much can be done
				}
			}
			closeConnection(conn);
		}

		return response;
	}

	/**
	 * This method sets data to the callable statement used for retrieving bed
	 * icon section data
	 * 
	 * @param callStmt
	 * @param request
	 * @throws SQLException
	 */
	private void setDataInCStmtForBedIconSection(CallableStatement callStmt,
			BedIconRequest request) throws SQLException {
		// set all inputs first
		int index = 1;
		String facId = request.getFacilityId();
		callStmt.setString(index, facId);
		index++;
		String nuCode = request.getNursingUnitCode();
		callStmt.setString(index, nuCode);
		index++;
		String bedNum = request.getBedNumber();
		callStmt.setString(index, bedNum);
		index++;
		String blOper = request.getBlOperational();
		callStmt.setString(index, blOper);
		index++;

		String langId = request.getLangId();
		callStmt.setString(index, langId);
		index++;
		
		// output parameters
		callStmt.registerOutParameter(index, Types.ARRAY,
				"GBM_OP_BED_ICON_STAT_TAB");
		index++;
		callStmt.registerOutParameter(index, Types.VARCHAR);
	}

	/**
	 * This method processes bed icon section data
	 * 
	 * @param response
	 * @param request
	 * @param callStmt
	 * @param loggerInst
	 * @throws SQLException
	 */
	private void processBedIconSectionData(BedIconResponse response,
			BedIconRequest request, CallableStatement callStmt,
			Logger loggerInst) throws SQLException {

		final int ERROR_MSG_INDEX = 7;
		final int OP_INDEX = 6;

		String spExecuteMessage = null;
		spExecuteMessage = callStmt.getString(ERROR_MSG_INDEX);
		// error objects declaration
		ErrorInfo errorInfo = null;
		int errorCode = ErrorInfo.SUCCESS_CODE;
		String errorMessage = null;
		// error scenario
		if (spExecuteMessage != null && !spExecuteMessage.trim().equals("")) {
			// log and set error in response
			errorCode = ErrorConstants.BED_ICON_SECTION_SP_EXECUTE_ERRORCODE;// FloorLayoutConstants.BED_ICON_SECTION_SP_EXECUTE_ERRORCODE;

			if (loggerInst != null) {
				String resourceMessage = BundleManager
						.getInstance()
						.getLogMessageFromBundle(
								errorCode,
								FloorLayoutResourceConstants.FLOOR_LAYOUT_RESOURCE_MESSAGE_FILE_PATH);
				resourceMessage = MessageFormat.format(resourceMessage,
						new Object[] { spExecuteMessage });
				loggerInst.error(resourceMessage);
			}

			errorMessage = BundleManager
					.getInstance()
					.getDisplayMessageFromBundle(
							errorCode,
							FloorLayoutResourceConstants.FLOOR_LAYOUT_RESOURCE_MESSAGE_FILE_PATH);
			errorInfo = new ErrorInfo(errorCode, errorMessage);
			response.addError(errorInfo);
			return;
		}

		List<RoomForBedIconSection> rooms = new ArrayList<RoomForBedIconSection>();
		RoomForBedIconSection room = null;
		List<BedIconSection> beds = null;
		BedIconSection bed = null;

		// get data from callable statement
		Object opObj = callStmt.getObject(OP_INDEX);
		if (opObj instanceof Array) {
			Array opArr = (Array) opObj;
			Object val = opArr.getArray();
			Object[] valArr = null;
			if (val instanceof Object[]) {
				valArr = (Object[]) val;
				Object valArrChild = null;
				Struct structObj = null;
				Object[] structAttributes = null;
				int valArrLen = valArr.length;
				for (int count = 0; count < valArrLen; count++) {
					valArrChild = valArr[count];
					if (valArrChild instanceof Struct) {
						structObj = (Struct) valArrChild;
						structAttributes = structObj.getAttributes();
						// safe way
						if (structAttributes == null) {
							continue;
						}

						// get room instance
						room = getRoomForIconSection(structAttributes, request);
						// add the room instance if valid
						if (!room.isValid()) {
							continue;
						}

						if (!rooms.contains(room)) {
							rooms.add(room);
							beds = new ArrayList<BedIconSection>();
							room.setBedIcons(beds);
						} else {
							// get the room instance from the list
							// and then get the bed list 
							int index = rooms.indexOf(room);
							room = rooms.get(index);
							beds = room.getBedIcons();
						}

						bed = BedHelper.getBedIconSection(structAttributes);
						beds.add(bed);
					}
				}
			}
		}

		// check for no data
		if (rooms.isEmpty()) {
			// log and set error in response
			errorCode = ErrorConstants.BED_ICON_SECTION_NO_DATA_ERRORCODE;// FloorLayoutConstants.BED_ICON_SECTION_NO_DATA_ERRORCODE;

			if (loggerInst != null) {
				String resourceMessage = BundleManager
						.getInstance()
						.getLogMessageFromBundle(
								errorCode,
								FloorLayoutResourceConstants.FLOOR_LAYOUT_RESOURCE_MESSAGE_FILE_PATH);
				loggerInst.error(resourceMessage);
			}

			errorMessage = BundleManager
					.getInstance()
					.getDisplayMessageFromBundle(
							errorCode,
							FloorLayoutResourceConstants.FLOOR_LAYOUT_RESOURCE_MESSAGE_FILE_PATH);
		}
		response.setRooms(rooms);
		// now add the error info object to response
		errorInfo = new ErrorInfo(errorCode, errorMessage);
		response.addError(errorInfo);

	}

	/**
	 * This method gets an instance of RoomForIconSection given the attributes
	 * and the bed icon request
	 * 
	 * @param structAttributes
	 * @param request
	 * @return
	 */
	private RoomForBedIconSection getRoomForIconSection(
			Object[] structAttributes, BedIconRequest request) {
		RoomForBedIconSection room = new RoomForBedIconSection();

		// set facility id and nursing unit code
		String facilityId = request.getFacilityId();
		String nuCode = request.getNursingUnitCode();
		room.setFacilityId(facilityId);
		room.setNursingUnitCode(nuCode);

		// get room number after a basic validity check
		int attrLen = structAttributes.length;
		if (attrLen < FloorLayoutConstants.BED_ICON_SECTION_TOT_INDEX) {
			room.setValid(false);
			return room;
		}

		String roomNumber = (String) structAttributes[FloorLayoutConstants.BED_ICON_SECTION_ROOM_NUM_INDEX];
		room.setRoomNumber(roomNumber);

		return room;
	}

}
