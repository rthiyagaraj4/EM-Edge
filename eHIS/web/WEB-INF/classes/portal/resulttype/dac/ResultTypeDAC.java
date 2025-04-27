/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package portal.resulttype.dac;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import portal.common.response.ErrorInfo;
import portal.resulttype.request.ResultTypeRequest;
import portal.resulttype.response.ResultType;
import portal.resulttype.response.ResultTypeResponse;
import portal.tools.ErrorMessageUtil;
import portal.tools.PortalHelper;
import portal.tools.ResultTypeConstants;

public class ResultTypeDAC {

	private static Logger logger = Logger
			.getLogger(ResultTypeDAC.class.getName());

	// static query
	private static final String query = "select order_category,short_desc from or_order_category";

	// instance variables
	private ErrorInfo errorInfo;
	private ResultTypeResponse response;

	/**
	 * This method fetches the facilities from EM DB for patient portal
	 * application home page
	 * 
	 * @param request
	 * @return
	 */
	public ResultTypeResponse getResultTypes(ResultTypeRequest request) {
		logger.info("Entering the method :getResultTypes");
		List<ResultType> resultTypeList = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		conn = PortalHelper.getConnection();
		if (conn == null) {
			errorInfo = ErrorMessageUtil.getErrorMessage(
					ResultTypeConstants.MODULE_NAME,
					ErrorInfo.RESULTTYPE_CONNECTION_FAILURE_CODE);
			logger.info("Connection is null in the method :getResultTypes");
		} else {
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(query);
				if (rs != null) {
					resultTypeList = getResultTypeList(rs);
				}
				if (resultTypeList == null || resultTypeList.isEmpty()) {
					errorInfo = ErrorMessageUtil.getErrorMessage(
							ResultTypeConstants.MODULE_NAME,
							ErrorInfo.RESULTTYPE_NO_DB_DATA_RETURNED_CODE);
					logger.info("No list values in the method :getResultTypes");
				} else {
					errorInfo = ErrorMessageUtil.getErrorMessage(
							ResultTypeConstants.MODULE_NAME,
							ErrorInfo.SUCCESS_CODE);
				}
			} catch (SQLException e) {
				errorInfo = ErrorMessageUtil.getErrorMessage(
						ResultTypeConstants.MODULE_NAME,
						ErrorInfo.RESULTTYPE_SQLEXCEPTION_CODE, e.getMessage());
				logger.error("Exception in the method :getResultTypes : msg:"
						+ e.getStackTrace().toString());
				// logger.log(Priority.toPriority(Priority.ERROR_INT),
				// e.getMessage(), e);
				logger.fatal(
						"Exception in the method :getResultTypes : stack trace: ",
						e);
			} finally {
				PortalHelper.closeResources(conn, stmt, rs);
				conn = null;
			}
		}
		response.setErrorInfo(errorInfo);
		response.setResultTypeList(resultTypeList);
		logger.info("Leaving the method :getResultTypes");
		return response;
	}

	/**
	 * This method gets the list of facilities from result
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private List<ResultType> getResultTypeList(ResultSet rs) throws SQLException {
		List<ResultType> resultTypeList = new ArrayList<ResultType>();
		while (rs.next()) {
			resultTypeList.add(new ResultType(rs.getString("order_category"), rs
					.getString("short_desc")));
		}
		return resultTypeList;
	}

	/**
	 * @param response
	 *            the response to set
	 */
	public void setResponse(ResultTypeResponse response) {
		this.response = response;
	}


}
