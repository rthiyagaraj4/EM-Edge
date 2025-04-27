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
package eIP.advbedmgmt.transaction.requestfortransfer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import webbeans.eCommon.ConnectionManager;
import eIP.advbedmgmt.GBMConstants;
import eIP.advbedmgmt.transaction.requestfortransfer.RequestForTransferConstants;
import eIP.advbedmgmt.transaction.requestfortransfer.request.TransferMetatDataRequest;
import eIP.advbedmgmt.transaction.requestfortransfer.response.TransferMetaDataResponse;

/**
 * This is the DAO impl class to get the meta data required in launching the
 * request for transfer page in ABM module
 * 
 * @author GRamamoorthy
 * 
 */
public class TransferMetaDataDaoImpl {

	/**
	 * This method gets the transfer meta data needed for launching the request
	 * for transfer functionality
	 * 
	 * @param request
	 * @return
	 */
	public TransferMetaDataResponse getTransferMetaData(
			TransferMetatDataRequest request) {
		// initialize the response
		TransferMetaDataResponse response = new TransferMetaDataResponse();
		// initialize the logger
		Logger loggerInst = Logger.getLogger("APPLICATION_LOG");
		String className = this.getClass().getName();
		String logMessage = GBMConstants.GBM_MODULE_IDENTIFIER
				+ " "
				+ className
				+ ":"
				+ RequestForTransferConstants.REQUEST_FOR_TRANSFER_TRANSACTION_KEYWORD
				+ ": ";
		// safe check
		if (request == null) {
			// there is a need to log
			if (loggerInst != null) {
				logMessage += "Request to get metadata is null";
				loggerInst.warn(logMessage);
			}
			return response;
		}
		// facility id needs to be validated
		String facilityId = request.getFacilityId();
		if (facilityId == null || facilityId.trim().equals("")) {
			// there is a need to log
			if (loggerInst != null) {
				logMessage += "FacilityId in request to get metadata is null or empty";
				loggerInst.warn(logMessage);
			}
			return response;
		}

		// get the connection
		Connection conn = ConnectionManager.getConnection();
		if (conn == null) {
			// there is a need to log
			if (loggerInst != null) {
				logMessage += "Could not obtain connection to get meta data";
				loggerInst.warn(logMessage);
			}
			return response;
		}

		String sqlQuery = getQuery(request);
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		try {
			prepStmt = conn.prepareStatement(sqlQuery);
			setDataInPreparedStatement(prepStmt, request);
			rs = prepStmt.executeQuery();
			// just a safe check
			if (rs == null) {
				// need to log
				if (loggerInst != null) {
					logMessage += "Could not obtain resultset to get meta data";
					loggerInst.warn(logMessage);
				}
				return response;
			}
			setDataInResponse(rs, response);
		} catch (SQLException e) {
			// there is a need to log
			if (loggerInst != null) {
				logMessage += "SQL Exception while retrieving meta data. Exception message="+e.getMessage();
				loggerInst.warn(logMessage);
			}
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// not much can be done- logging is not needed
				}
			}

			if (prepStmt != null) {
				try {
					prepStmt.close();
				} catch (SQLException e) {
					// not much can be done- logging is not needed
				}
			}
			ConnectionManager.returnConnection(conn);
		}

		return response;
	}

	/**
	 * This method gets the SQL query needed for getting the meta data
	 * 
	 * @param request
	 * @return
	 */
	private String getQuery(TransferMetatDataRequest request) {
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder
				.append("SELECT bl_interfaced_yn, setup_bl_dtls_in_ip_yn, pat_check_in_allowed_yn, ");
		queryBuilder
				.append("priority_applicable_yn, change_bed_class_yn,deactivate_pseudo_bed_yn, ");
		queryBuilder
				.append("dflt_blk_prd_for_tfr_out,bed_block_period_normal, reserve_bed_on_tfr_yn, ");
		queryBuilder
				.append("bed_block_period_max, bed_block_period_max_type, allow_multiple_bed_for_resv_yn,max_disch_period_for_dc ");
		queryBuilder.append("FROM IP_PARAM ");
		queryBuilder.append("WHERE facility_id=?");

		return queryBuilder.toString();
	}

	/**
	 * This method sets data into the prepared statement before executing it
	 * 
	 * @param prepStmt
	 * @param request
	 * @throws SQLException
	 */
	private void setDataInPreparedStatement(PreparedStatement prepStmt,
			TransferMetatDataRequest request) throws SQLException {
		// in here, only facility id needs to be set and no checks are needed
		int index = 1;
		String facilityId = request.getFacilityId();
		prepStmt.setString(index, facilityId);
	}

	/**
	 * This method gets data from result set and sets it in the response object
	 * 
	 * @param rs
	 * @param response
	 */
	private void setDataInResponse(ResultSet rs,
			TransferMetaDataResponse response) throws SQLException {
		String blInterfacedYN = null;
		String setUpBillDtls = null;
		String patCheckInYN = null;
		String priorityStatus = null;
		String changeBedClass = null;
		String deactivatePseudoBed = null;
		int defaultBlockPeriodTransfer = 0;
		int bedBlockPeriodNormal = 0;
		String reserveBedOnTransfer = null;
		int bedBlockPeriodMax = 0;
		String bedBlockPeriodMaxType = null;
		String allowMultipleBedsForReservation = null;
		int maxDischargePeriod = 0;

		// only one record should be read
		if (rs.next()) {
			blInterfacedYN = rs
					.getString(RequestForTransferConstants.BL_INTERFACED_YN_KEY);
			setUpBillDtls = rs
					.getString(RequestForTransferConstants.SETUP_BILL_DTLS_IP_YN_KEY);
			patCheckInYN = rs
					.getString(RequestForTransferConstants.PATIENT_CHECKIN_ALLOWED_YN_KEY);
			priorityStatus = rs
					.getString(RequestForTransferConstants.PRIORITY_STATUS_KEY);
			changeBedClass = rs
					.getString(RequestForTransferConstants.CHANGE_BEDCLASS_YN_KEY);
			deactivatePseudoBed = rs
					.getString(RequestForTransferConstants.DEACTIVATE_PSEUDOBED_YN_KEY);
			defaultBlockPeriodTransfer = rs
					.getInt(RequestForTransferConstants.DEFAULT_BLOCK_PERIOD_TRANSFER_OUT);
			bedBlockPeriodNormal = rs
					.getInt(RequestForTransferConstants.BED_BLOCK_PERIOD_NORMAL_KEY);
			reserveBedOnTransfer = rs
					.getString(RequestForTransferConstants.RESERVE_BED_ON_TRANSFER_YN_KEY);
			bedBlockPeriodMax = rs
					.getInt(RequestForTransferConstants.BED_BLOCK_PERIOD_MAX_KEY);
			bedBlockPeriodMaxType = rs
					.getString(RequestForTransferConstants.BED_BLOCK_PERIOD_MAX_TYPE_KEY);
			allowMultipleBedsForReservation = rs
					.getString(RequestForTransferConstants.ALLOW_MULTIPLE_BED_FOR_RESERVATION_YN_KEY);
			maxDischargePeriod = rs
					.getInt(RequestForTransferConstants.MAX_DISCHARGE_PERIOD_FOR_DC);

			// set the data in response
			response.setBlInterfacedYN(blInterfacedYN);
			response.setSetupBillDetailsInIPYN(setUpBillDtls);
			response.setPatientCheckInAllowedYN(patCheckInYN);
			response.setPriorityStatus(priorityStatus);
			response.setChangeBedClassYN(changeBedClass);
			response.setDeactivatePseudoBedYN(deactivatePseudoBed);
			response.setDefaultBlockPeriodForTransferOut(defaultBlockPeriodTransfer);
			response.setBedBlockPeriodNormal(bedBlockPeriodNormal);
			response.setReserveBedOnTransferYN(reserveBedOnTransfer);
			response.setBedBlockPeriodMax(bedBlockPeriodMax);
			response.setBedBlockPeriodMaxType(bedBlockPeriodMaxType);
			response.setAllowMultipleBedForReservationYN(allowMultipleBedsForReservation);
			response.setMaxDischargePeriodForDC(maxDischargePeriod);
		}
	}

}
