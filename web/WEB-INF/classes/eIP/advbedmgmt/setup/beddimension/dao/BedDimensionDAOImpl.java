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
package eIP.advbedmgmt.setup.beddimension.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.MessageFormat;

import org.apache.log4j.Logger;

import eIP.advbedmgmt.GBMConstants;
import eIP.advbedmgmt.common.CommonResourceConstants;
import eIP.advbedmgmt.common.ErrorConstants;
import eIP.advbedmgmt.common.dao.BaseDAOImpl;
import eIP.advbedmgmt.common.resourcebundle.BundleManager;
import eIP.advbedmgmt.common.response.ErrorInfo;
import eIP.advbedmgmt.setup.beddimension.BedDimensionConstants;
import eIP.advbedmgmt.setup.beddimension.BedDimensionResourceConstants;
import eIP.advbedmgmt.setup.beddimension.request.RetrieveDimensionRequest;
import eIP.advbedmgmt.setup.beddimension.request.SaveDimensionRequest;
import eIP.advbedmgmt.setup.beddimension.response.RetrieveDimensionResponse;
import eIP.advbedmgmt.setup.beddimension.response.SaveDimensionResponse;

/**
 * This is the DAO implementation class for bed dimensions
 * This class extends BaseDAOImpl and implements BedDimensionDAO
 * @author GRamamoorthy
 *
 */
public class BedDimensionDAOImpl extends BaseDAOImpl implements BedDimensionDAO {

	/**
	 * This method retrieves the bed dimensions
	 */
	public RetrieveDimensionResponse getDimensions(
			RetrieveDimensionRequest request) {
		// initializing response 
		RetrieveDimensionResponse response = new RetrieveDimensionResponse();
		ErrorInfo errorInfo = null;
		int errorCode = ErrorInfo.SUCCESS_CODE;
		String errorMessage = null;
		
		// initialize the logger
		Logger loggerInst = Logger.getLogger("APPLICATION_LOG");
		StringBuilder logMessage = new StringBuilder();
		// connection thingy
		Connection conn = getConnection();
		if(conn == null){
			handleNullConnection(response, loggerInst);
			return response;
		}
		
		String sqlQuery = getRetrieveDimensionSQLQuery(request);
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		try {
			prepStmt = conn.prepareStatement(sqlQuery);
			rs = prepStmt.executeQuery();
			// safe check
			if(rs == null){
				errorCode = ErrorConstants.RETRIEVE_DIM_NULLRESULTSET_CODE;
				// log the exception
				if (loggerInst != null) {
					logMessage.append(GBMConstants.GBM_MODULE_IDENTIFIER).append(
							":");
					String message = BundleManager
							.getInstance()
							.getLogMessageFromBundle(
									errorCode,
									BedDimensionResourceConstants.RESOURCE_BUNDLE_FILE_PATH);
					logMessage.append(message);
					loggerInst.fatal(logMessage.toString());
				}
				// set error to response
				errorMessage = BundleManager
						.getInstance()
						.getDisplayMessageFromBundle(
								errorCode,
								BedDimensionResourceConstants.RESOURCE_BUNDLE_FILE_PATH);
				errorInfo = new ErrorInfo(errorCode, errorMessage);
				response.addError(errorInfo);
				return response;
			}
			
			setDataInRetrDimResponse(rs,response,request);
			
		} catch (SQLException e) {
			errorCode = ErrorConstants.RETRIEVE_DIM_SQLEXCEPTION_CODE;
			// log the exception
			if (loggerInst != null) {
				logMessage.append(GBMConstants.GBM_MODULE_IDENTIFIER).append(
						":");
				String message = BundleManager
						.getInstance()
						.getLogMessageFromBundle(
								errorCode,
								BedDimensionResourceConstants.RESOURCE_BUNDLE_FILE_PATH);
				message = MessageFormat.format(message, new Object[]{e.getMessage()});
				logMessage.append(message);
				loggerInst.fatal(logMessage.toString());
			}
			// set error to response
			errorMessage = BundleManager
					.getInstance()
					.getDisplayMessageFromBundle(
							errorCode,
							BedDimensionResourceConstants.RESOURCE_BUNDLE_FILE_PATH);
			errorInfo = new ErrorInfo(errorCode, errorMessage);
			response.addError(errorInfo);
			return response;
			
		}finally{
			//closeResources(rs, prepStmt, conn);// Commented for CheckStyle
			/*Added for CheckStyle*/
			if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				// cannot do much
			}
				}
			if(prepStmt != null){
			try {
				prepStmt.close();
			} catch (SQLException e) {
				// cannot do much
			}
		}
			
			if (conn != null) {
				returnConnection(conn);
			}
			/*Added for CheckStyle*/
		}
		
		return response;
	}
	
	/**
	 * This method returns the module specific error message
	 * in connection issue scenario
	 */
	protected String getSpecMesgForConnectionIssue() {
		String specificErrorMessage = BundleManager
				.getInstance()
				.getDisplayMessageFromBundle(
						BedDimensionResourceConstants.DISPLAY_RETRIEVE_DIM_CONNECTION_ERROR_KEY,
						BedDimensionResourceConstants.RESOURCE_BUNDLE_FILE_PATH);
		
		return specificErrorMessage;
	}

	/**
	 * This method returns the SQL query used to retrieve the bed dimensions
	 * @param request
	 * @return
	 */
	private String getRetrieveDimensionSQLQuery(RetrieveDimensionRequest request){
		StringBuffer queryBuff = new StringBuffer();
		queryBuff.append("select dim_type,dim_value from GBM_BED_DIM_CONFIG");
		
		return queryBuff.toString();
	}
	
	/**
	 * This method sets the data in the response
	 * @param rs
	 * @param response
	 * @param request
	 * @throws SQLException
	 */
	private void setDataInRetrDimResponse(ResultSet rs,
			RetrieveDimensionResponse response, RetrieveDimensionRequest request)
			throws SQLException {
		String dimType = null;
		int dimValue = 0;
		// var to know whether the result set has data
		int rowCnt = 0;
		
		while(rs.next()){
			dimType = rs.getString(BedDimensionConstants.DIMENSION_TYPE_COLUMN_NAME);
			dimValue = rs.getInt(BedDimensionConstants.DIMENSION_VALUE_COLUMN_NAME);
			
			rowCnt++;
			
			if(BedDimensionConstants.MIN_WIDTH_DIM_TYPE.equals(dimType)){
				response.setMinWidth(dimValue);
			}else if(BedDimensionConstants.MIN_HEIGHT_DIM_TYPE.equals(dimType)){
				response.setMinHeight(dimValue);
			}else if(BedDimensionConstants.MAX_WIDTH_DIM_TYPE.equals(dimType)){
				response.setMaxWidth(dimValue);
			}else if(BedDimensionConstants.MAX_HEIGHT_DIM_TYPE.equals(dimType)){
				response.setMaxHeight(dimValue);
			}else if(BedDimensionConstants.WIDTH_DIM_TYPE.equals(dimType)){
				response.setWidth(dimValue);
			}else if(BedDimensionConstants.HEIGHT_DIM_TYPE.equals(dimType)){
				response.setHeight(dimValue);
			}
		}
		
		ErrorInfo errorInfo = null;
		int errorCode = ErrorInfo.SUCCESS_CODE;
		String errorMessage = null;
		// no data scenario
		if(rowCnt == 0){
			errorCode = ErrorConstants.RETRIEVE_DIM_NODATA_CODE;
			errorMessage = BundleManager
					.getInstance()
					.getDisplayMessageFromBundle(
							errorCode,
							BedDimensionResourceConstants.RESOURCE_BUNDLE_FILE_PATH);
		}
		
		errorInfo = new ErrorInfo(errorCode, errorMessage);
		response.addError(errorInfo);
		
	}
	
	
	
	/**
	 * This method saves bed dimensions
	 */
	public SaveDimensionResponse saveDimensions(SaveDimensionRequest request) {
		// initialize the response
		SaveDimensionResponse response = new SaveDimensionResponse();
		ErrorInfo errorInfo = null;
		int errorCode = ErrorInfo.SUCCESS_CODE;
		String errorMessage = null;
		
		// initialize the logger
		Logger loggerInst = Logger.getLogger("APPLICATION_LOG");
		
		// connection
		Connection conn = getConnection();
		// safe check
		if(conn == null){
			//handleNullConnection(response, loggerInst);
			errorCode = ErrorInfo.DATABASE_CONNECTION_FAILURE_CODE;
			StringBuilder logMessage = new StringBuilder();
			if (loggerInst != null) {
				// logging done here
				logMessage.append(GBMConstants.GBM_MODULE_IDENTIFIER).append(
						":");
				logMessage
						.append("Could not save bed legend. Cause = Could not get connection to database");
				loggerInst.fatal(logMessage.toString());
			}

			// get the error message from resource bundle through bundle manager
			errorMessage = BundleManager
					.getInstance()
					.getDisplayMessageFromBundle(
							ErrorInfo.DATABASE_CONNECTION_FAILURE_CODE,
							CommonResourceConstants.COMMON_RESOURCES_FILE_CLASSPATH);

			String specificErrorMessage = BundleManager
					.getInstance()
					.getDisplayMessageFromBundle(
							BedDimensionResourceConstants.DISPLAY_RETRIEVE_DIM_CONNECTION_ERROR_KEY,
							BedDimensionResourceConstants.RESOURCE_BUNDLE_FILE_PATH);
			errorMessage = MessageFormat.format(errorMessage,
					specificErrorMessage);

			// form the error info object and set it to response
			errorInfo = new ErrorInfo(errorCode, errorMessage);
			response.addError(errorInfo);
			
			return response;
		}
		
		
		
		String query = getSaveDimensionQuery(request);
		CallableStatement callStmt = null;
		try {
			conn.setAutoCommit(false);
			callStmt = conn.prepareCall(query);
			prepCStmtForSaveDimension(request, callStmt);
			callStmt.execute();
			processSaveDimensionData(callStmt, response, request, loggerInst);
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// not much can be done
			}
			errorCode = ErrorConstants.SAVE_DIM_SQLEXCEPTION_CODE;
			if(loggerInst != null){
				String logMessage = null;
				logMessage = BundleManager
						.getInstance()
						.getLogMessageFromBundle(
								errorCode,
								BedDimensionResourceConstants.RESOURCE_BUNDLE_FILE_PATH);
				loggerInst.fatal(logMessage);
			}
			
			errorMessage = BundleManager
					.getInstance()
					.getDisplayMessageFromBundle(
							errorCode,
							BedDimensionResourceConstants.RESOURCE_BUNDLE_FILE_PATH);
			errorInfo = new ErrorInfo(errorCode, errorMessage);
			response.addError(errorInfo);
			return response;
		}finally{
		//closeResources(callStmt, conn);// Commented for CheckStyle
			/*Added for CheckStyle*/
			if(callStmt != null){
			try {
				callStmt.close();
			} catch (SQLException e) {
				// cannot do much
			}
				}
			
			if (conn != null) {
				returnConnection(conn);
			}
			/*Added for CheckStyle*/
		}
		
		return response;
	}
	
	/**
	 * This method returns the query for save dimension
	 * it is a sp call
	 * @param request
	 * @return
	 */
	private String getSaveDimensionQuery(SaveDimensionRequest request){
		String spCall = "{call GBM_BED_DIM_PKG.GBM_SAVE_BED_DIMENSION(?,?,?,?,?)}";
		return spCall;
	}
	
	/**
	 * This method prepares the callable statement for saving dimension
	 * @param request
	 * @param callStmt
	 */
	private void prepCStmtForSaveDimension(SaveDimensionRequest request,
			CallableStatement callStmt) throws SQLException {
		int index = 1;
		// register the inputs
		int width = request.getWidth();
		callStmt.setInt(index, width);
		index++;
		
		int height = request.getHeight();
		callStmt.setInt(index, height);
		index++;
		
		// register the outputs
		callStmt.registerOutParameter(index, Types.INTEGER);
		index++;
		callStmt.registerOutParameter(index, Types.INTEGER);
		index++;
		callStmt.registerOutParameter(index, Types.VARCHAR);
		
	}
	
	/**
	 * This method processes the save dimension response 
	 * @param callStmt
	 * @param response
	 * @param request
	 */
	private void processSaveDimensionData(CallableStatement callStmt,
			SaveDimensionResponse response, SaveDimensionRequest request,
			Logger loggerInst) throws SQLException {
		final int OP_WIDTH_INDEX = 3;
		final int OP_HEIGHT_INDEX = 4;
		final int OP_ERR_MESSAGE_INDEX = 5;
		
		String spErrorMessage = callStmt.getString(OP_ERR_MESSAGE_INDEX);
		int widthRowCnt = callStmt.getInt(OP_WIDTH_INDEX);
		int heightRowCnt = callStmt.getInt(OP_HEIGHT_INDEX);
		
		int errorCode = ErrorInfo.SUCCESS_CODE;
		String errorMessage = null;
		String logMessage = null;
		// handle errors if any
		// width row count and/or height row count should not be 0
		// also error message should not be not empty
		if ((widthRowCnt == 0 || heightRowCnt == 0)
				|| (spErrorMessage != null && !spErrorMessage.trim().equals(""))) {
			errorCode = ErrorConstants.SAVE_DIM_UPDATE_FAIL_CODE;
			errorMessage = BundleManager
					.getInstance()
					.getDisplayMessageFromBundle(
							errorCode,
							BedDimensionResourceConstants.RESOURCE_BUNDLE_FILE_PATH);
			// log message
			if(loggerInst != null){
				logMessage = BundleManager.getInstance().getLogMessageFromBundle(
						errorCode,
						BedDimensionResourceConstants.RESOURCE_BUNDLE_FILE_PATH);
				final String LOG_MESG_WIDTH_ISSUE = "Width could not be saved.";
				final String LOG_MESG_HEIGHT_ISSUE = "Height could not be saved.";
				
				if(widthRowCnt == 0){
					logMessage = MessageFormat.format(logMessage, LOG_MESG_WIDTH_ISSUE);
				}else if(heightRowCnt == 0){
					logMessage = MessageFormat.format(logMessage, LOG_MESG_HEIGHT_ISSUE);
				}else if(spErrorMessage != null && !spErrorMessage.trim().equals("")){
					logMessage = MessageFormat.format(logMessage, spErrorMessage);
				}
				loggerInst.error(logMessage);
			}
		}
		
		// set errorinfo to response
		ErrorInfo errorInfo = new ErrorInfo(errorCode, errorMessage);
		response.addError(errorInfo);
		
	}

	/**
	 *  This method is used for getting specific message for
	 *  bed dimension sub module
	 */
	protected String getLogMessageForConnectionIssue() {
		return "";
	}
	

}
