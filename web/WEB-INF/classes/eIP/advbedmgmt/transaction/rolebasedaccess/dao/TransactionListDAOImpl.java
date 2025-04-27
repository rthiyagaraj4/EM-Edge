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
package eIP.advbedmgmt.transaction.rolebasedaccess.dao;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Struct;
import java.sql.Types;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import eIP.advbedmgmt.GBMConstants;
import eIP.advbedmgmt.common.ErrorConstants;
import eIP.advbedmgmt.common.dao.BaseDAOImpl;
import eIP.advbedmgmt.common.resourcebundle.BundleManager;
import eIP.advbedmgmt.common.response.ErrorInfo;
import eIP.advbedmgmt.transaction.rolebasedaccess.TransactionListConstants;
import eIP.advbedmgmt.transaction.rolebasedaccess.TransactionListResourceConstants;
import eIP.advbedmgmt.transaction.rolebasedaccess.request.TransactionListRequest;
import eIP.advbedmgmt.transaction.rolebasedaccess.response.Transaction;
import eIP.advbedmgmt.transaction.rolebasedaccess.response.TransactionListResponse;

/**
 * This is the DAO impl class for getting transaction list which a user can
 * access
 * 
 * @author gramamoorthy
 * 
 */
public class TransactionListDAOImpl extends BaseDAOImpl implements
		TransactionListDAO {

	/**
	 * This method gets a list of transaction which a user can access in GBM
	 * module based on their role
	 */
	public TransactionListResponse getAccessibleTransactions(
			TransactionListRequest request) {
		TransactionListResponse response = new TransactionListResponse();
		ErrorInfo errorInfo = null;
		int errorCode = ErrorInfo.SUCCESS_CODE;
		String errorMessage = null;

		// initialize logger
		Logger loggerInst = Logger.getLogger("APPLICATION_LOG");
		StringBuilder logMessage = new StringBuilder();

		Connection conn = getConnection();// ConnectionManager.getConnection();
		// safe check
		if (conn == null) {
			handleNullConnection(response, loggerInst);
			return response;
		}

		String spCallString = "{call GBM_RBT_PKG.GBM_GET_RBT(?,?,?,?,?,?,?,?,?,?,?,?)}";
		CallableStatement callStmt = null;
		try {
			callStmt = conn.prepareCall(spCallString);
			setDataInCStmtForRBT(callStmt, request);
			callStmt.execute();
			processRBTData(callStmt, response, request, loggerInst);
		} catch (SQLException e) {
			// log and set error in response
			errorCode = ErrorConstants.RBT_SQLEXCEPTION_CODE;
			if (loggerInst != null) {
				logMessage.append(GBMConstants.GBM_MODULE_IDENTIFIER).append(
						":");
				String resourceMessage = BundleManager
						.getInstance()
						.getLogMessageFromBundle(
								errorCode,
								TransactionListResourceConstants.RBT_RESOURCE_MESSAGE_FILE_PATH);
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
							TransactionListResourceConstants.RBT_RESOURCE_MESSAGE_FILE_PATH);
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
			returnConnection(conn);
		}

		return response;
	}

	/**
	 * This method sets the data in callable statement
	 * 
	 * @param callStmt
	 * @throws SQLException
	 */
	private void setDataInCStmtForRBT(CallableStatement callStmt,
			TransactionListRequest request) throws SQLException {
		// set all inputs first
		int index = 1;
		String facId = request.getFacilityId();
		callStmt.setString(index, facId);
		index++;
		String nuCode = request.getNursingUnitCode();
		callStmt.setString(index, nuCode);
		index++;

		String respId = request.getResponsibilityId();
		callStmt.setString(index, respId);
		index++;

		/*
		 * String mainMenuId = request.getMenuId(); callStmt.setString(index,
		 * mainMenuId); index++;
		 */

		String userId = request.getUserId();
		callStmt.setString(index, userId);
		index++;

		String locnType = request.getLocationType();
		callStmt.setString(index, locnType);
		index++;

		String locnCode = request.getLocationCode();
		callStmt.setString(index, locnCode);
		index++;

		String encounterId = request.getEncounterId();
		callStmt.setString(index, encounterId);
		index++;

		String patientId = request.getPatientId();
		callStmt.setString(index, patientId);
		index++;

		String bedNumber = request.getBedNumber();
		callStmt.setString(index, bedNumber);
		index++;

		String locale = request.getLocale();
		callStmt.setString(index, locale);
		index++;

		// output parameters
		callStmt.registerOutParameter(index, Types.ARRAY, "GBM_OP_RBT_TAB");
		index++;
		callStmt.registerOutParameter(index, Types.VARCHAR);

	}

	/**
	 * This method reads data from the callable statement and sets data in the
	 * response object
	 * 
	 * @param callStmt
	 * @param response
	 * @param request
	 * @throws SQLException
	 */
	private void processRBTData(CallableStatement callStmt,
			TransactionListResponse response, TransactionListRequest request,
			Logger loggerInst) throws SQLException {
		final int ERROR_MSG_INDEX = 12;
		final int OP_INDEX = 11;

		// error objects declaration
		ErrorInfo errorInfo = null;
		int errorCode = ErrorInfo.SUCCESS_CODE;
		String errorMessage = null;

		String spExecuteMessage = null;
		spExecuteMessage = callStmt.getString(ERROR_MSG_INDEX);

		// error scenario
		if (spExecuteMessage != null && !spExecuteMessage.trim().equals("")) {
			// log and set error in response
			errorCode = ErrorConstants.RBT_NODATA_CODE;

			if (loggerInst != null) {
				String resourceMessage = BundleManager
						.getInstance()
						.getLogMessageFromBundle(
								errorCode,
								TransactionListResourceConstants.RBT_RESOURCE_MESSAGE_FILE_PATH);
				resourceMessage = MessageFormat.format(resourceMessage,
						new Object[] { spExecuteMessage });
				loggerInst.error(resourceMessage);
			}

			errorMessage = BundleManager
					.getInstance()
					.getDisplayMessageFromBundle(
							errorCode,
							TransactionListResourceConstants.RBT_RESOURCE_MESSAGE_FILE_PATH);
			errorInfo = new ErrorInfo(errorCode, errorMessage);
			response.addError(errorInfo);
			return;
		}

		Transaction transaction = null;
		List<Transaction> transactionList = new ArrayList<Transaction>();
		// var stores the length of data array
		// used to check if there is data available
		int valArrLen = 0;
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
				valArrLen = valArr.length;
				for (int count = 0; count < valArrLen; count++) {
					valArrChild = valArr[count];
					structAttributes = null;
					if (valArrChild instanceof Struct) {
						structObj = (Struct) valArrChild;
						structAttributes = structObj.getAttributes();
					}
					// safe way
					if (structAttributes == null) {
						continue;
					}

					// another safe check - this time for number
					// of data elements part of one record
					int dataLen = structAttributes.length;
					if (dataLen != TransactionListConstants.TOTAL_DATA_COUNT) {
						continue;
					}

					transaction = getTransaction(structAttributes);
					// there is a need to filter non IP transactions
					if (transaction.isInpatientModule()
							&& !transactionList.contains(transaction)) {
						transactionList.add(transaction);
					}
				}
			}
		}

		// finally check transaction list for empty
		if (transactionList.isEmpty() && (valArrLen == 0)) {
			// log and set error in response
			errorCode = ErrorConstants.BED_ICON_SECTION_NO_DATA_ERRORCODE;

			if (loggerInst != null) {
				String resourceMessage = BundleManager.getInstance()
						.getLogMessageFromBundle(errorCode, "");
				loggerInst.error(resourceMessage);
			}

			errorMessage = BundleManager.getInstance()
					.getDisplayMessageFromBundle(errorCode, "");
		}

		response.setTransactionList(transactionList);
		errorInfo = new ErrorInfo(errorCode, errorMessage);
		response.addError(errorInfo);
	}

	/**
	 * This method forms a Transaction from the input array
	 * 
	 * @param structAttributes
	 * @return
	 */
	private Transaction getTransaction(Object[] structAttributes) {
		Transaction transaction = new Transaction();

		String module = (String) structAttributes[TransactionListConstants.MODULE_ID_INDEX];
		String funcId = (String) structAttributes[TransactionListConstants.FUNCTION_ID_INDEX];
		String funcDesc = (String) structAttributes[TransactionListConstants.DESCRIPTION_INDEX];
		String exec = (String) structAttributes[TransactionListConstants.EXECUTABLE_INDEX];
		String insertAccess = (String) structAttributes[TransactionListConstants.INSERT_ACCESS_INDEX];
		String updateAccess = (String) structAttributes[TransactionListConstants.UPDATE_ACCESS_INDEX];
		String deleteAccess = (String) structAttributes[TransactionListConstants.DELETE_ACCESS_INDEX];
		String printAccess = (String) structAttributes[TransactionListConstants.PRINT_ACCESS_INDEX];
		String queryAccess = (String) structAttributes[TransactionListConstants.QUERY_ACCESS_INDEX];

		transaction.setModuleId(module);
		transaction.setFunctionId(funcId);
		transaction.setFunctionDesc(funcDesc);
		transaction.setExecutableURL(exec);
		transaction.setInsertAccessYN(insertAccess);
		transaction.setUpdateAccessYN(updateAccess);
		transaction.setDeleteAccessYN(deleteAccess);
		transaction.setPrintAccessYN(printAccess);
		transaction.setQueryOnlyAccessYN(queryAccess);

		return transaction;
	}

	/**
	 * This method returns a specific message for connection issue in RBT
	 */
	protected String getSpecMesgForConnectionIssue() {
		String message = BundleManager
				.getInstance()
				.getMessageFromResourceBundle(
						TransactionListResourceConstants.DISPLAY_CONNECTION_ERROR_KEY,
						TransactionListResourceConstants.RBT_RESOURCE_MESSAGE_FILE_PATH);
		return message;
	}

	/**
	 * This method returns the log message for connection issue in RBT
	 */
	protected String getLogMessageForConnectionIssue() {
		String message = BundleManager
				.getInstance()
				.getMessageFromResourceBundle(
						TransactionListResourceConstants.CONNECTION_ERROR_KEY,
						TransactionListResourceConstants.RBT_RESOURCE_MESSAGE_FILE_PATH);
		return message;
	}

}
