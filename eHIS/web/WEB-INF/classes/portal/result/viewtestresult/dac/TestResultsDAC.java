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
package portal.result.viewtestresult.dac;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import portal.common.response.ErrorInfo;
import portal.result.viewtestresult.request.TestResultRequest;
import portal.result.viewtestresult.response.TestResult;
import portal.result.viewtestresult.response.TestResultResponse;
import portal.tools.ErrorMessageUtil;
import portal.tools.PortalHelper;
import portal.tools.TestDetailsConstant;


/**
 * This class is used for creating the method to retrieve information about TestResults
 * based on patientId and the OrderDate. If the orderDate is not specified then the 
 * TestResults are picked up for the last 6 months
 * 
 * @author skrishnared2
 *
 */
public class TestResultsDAC {

	private static Logger logger = Logger
			.getLogger(TestResultsDAC.class.getName());
	// instance variables
	TestResultResponse response;
	ErrorInfo errorInfo;
	
	/**
	 * This is the persistance class to query test results from the database
	 * 
	 * @param request - instance of TestDetailsRequest
	 * @return TestDetailsResponse
	 */
	public TestResultResponse getTestDetails(TestResultRequest request){
		logger.info("Entering the method :getTestDetails");
		// initialize the error object and set it in the response
		response.setErrorInfo(errorInfo);
		
		// this is the only data that we need from the request
		String patientId = request.getPatientId();
		int resultLen = request.getResultSetSize();
		
		// contains the SQL query
		StringBuffer queryBuff = new StringBuffer();

		String query = "select a.patient_id, (select short_desc from or_order_Catalog where order_Catalog_code = b.order_Catalog_code) Order_catalog_name, " +
			           " (select practitioner_name from am_practitioner  where practitioner_id = a.ord_pract_id) Practitioner_name, " +
			           " a.order_id Order_Id, " +
			           " (select short_desc from or_order_Category where order_Category = a.order_Category) result_type, " + 
			           " to_timestamp(to_char(a.ord_Date_Time,'DD/MM/YYYY hh24:mi'),'DD/MM/YYYY hh24:mi') ord_Date_Time " +
			           " from or_order a,or_ordeR_line b "+ 
			           " where a.ordeR_id = b.order_id " +
			           " and a.order_Category in ('LB','RD') " + 
			           " and b.order_line_status not in ('CN','DC','FC') " ;	
		
		String noOfRows = " and rownum <= " + resultLen;
		String cond1 = " and a.patient_id = '" + patientId + "' ";
		String cond2 = " and a.ord_date_time <= sysdate";
		String cond3 = " and b.order_line_status in ('CD','RS','RA','RM','MA') ";
		
		queryBuff.append(query);
		queryBuff.append(cond1);
		queryBuff.append(cond2);
		queryBuff.append(cond3);
		if(resultLen != 0) {
			queryBuff.append(noOfRows);
		}
		queryBuff.append(" order by a.ord_Date_time");
		logger.debug("queryBuff.toString() : "  + queryBuff.toString());
		
		// get the connection
		Connection conn = PortalHelper.getConnection();
		// safe check
		if(conn == null){
			errorInfo = ErrorMessageUtil.getErrorMessage(TestDetailsConstant.MODULE_NAME, ErrorInfo.HOME_TEST_CONNECTION_FAILURE_CODE);		
			logger.info("Connection is null in the method :getTestDetails");
		} else {
			// initialize the list which will contain the data
			List<TestResult> testDetailsList = new ArrayList<TestResult>();
			// execute the query and get the data
			Statement stmt = null;
			ResultSet rs = null;
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(queryBuff.toString());
				if(rs != null){
					testDetailsList = getTestDetailsList(rs);
					if(testDetailsList == null || testDetailsList != null && testDetailsList.isEmpty() ){
						errorInfo = ErrorMessageUtil.getErrorMessage(TestDetailsConstant.MODULE_NAME, ErrorInfo.HOME_TEST_NO_DB_DATA_RETURNED_CODE);
						logger.info("No DB Data in the method :getTestDetails");
					} else {
						response.setTestDetailsList(testDetailsList);
						// set the error info object to the response
						// for the time being an error info object with positive
						// result is set
						errorInfo = ErrorMessageUtil.getErrorMessage(TestDetailsConstant.MODULE_NAME, ErrorInfo.SUCCESS_CODE);
						logger.debug("Success the method :getTestDetails");
					}
				}
				else {
					errorInfo = ErrorMessageUtil.getErrorMessage(TestDetailsConstant.MODULE_NAME, ErrorInfo.HOME_TEST_NO_DB_DATA_RETURNED_CODE);
					logger.info("No DB Data in the method :getTestDetails");
				}
			} catch (SQLException e) {
				/**
				 * TODO
				 * need to handle this with logging
				 */
				e.printStackTrace();
				logger.error("Exception in the method :getTestDetails : msg:"
						+ e.getStackTrace().toString());
				// logger.log(Priority.toPriority(Priority.ERROR_INT),
				// e.getMessage(), e);
				logger.fatal(
						"Exception in the method :getTestDetails : stack trace: ",
						e);
				errorInfo = ErrorMessageUtil.getErrorMessage(TestDetailsConstant.MODULE_NAME,	ErrorInfo.HOME_TEST_SQLEXCEPTION_CODE, e.getMessage());
			}finally{
				PortalHelper.closeResources(conn, stmt, rs);
				conn = null;
			}
		}
		response.setErrorInfo(errorInfo);
		logger.info("Leaving the method :getTestDetails");
		return response;
	}
		
	/**
	 * This method will create the TestDetails object from ResultSet
	 * 
	 * @param rs
	 * @return
	 */
	private List<TestResult> getTestDetailsList(ResultSet rs){
		List<TestResult> testDetailsList = new ArrayList<TestResult>();
		// vars used in the method
		TestResult testDetails = null;
		String orderNo = null;
		String resultType = null;
		String order = null;
		Timestamp orderDate = null;
		String practName = null;
		
		try {
			while(rs.next()){
				// get the data required
				orderNo = rs.getString("Order_Id");
				resultType = rs.getString("result_type");
				order = rs.getString("Order_catalog_name");
				orderDate = rs.getTimestamp("ord_Date_Time");
				practName = rs.getString("Practitioner_name");
				
				// initialize the testdetails object
				// and set the data
				testDetails = new TestResult();
				testDetails.setOrderNo(orderNo);
				testDetails.setResultType(resultType);
				testDetails.setOrderDesc(order);
				testDetails.setPractName(practName);
				testDetails.setOrderDate(orderDate.toLocaleString());

				// finally add the testdetails object to list
				testDetailsList.add(testDetails);
			}
		} catch (SQLException e) {
			logger.error("Exception in the method :getTestDetailsList : msg:"
					+ e.getStackTrace().toString());
			// logger.log(Priority.toPriority(Priority.ERROR_INT),
			// e.getMessage(), e);
			logger.fatal(
					"Exception in the method :getTestDetailsList : stack trace: ",
					e);
		}
		
		return testDetailsList;
	}
	
	/**
	 * @param response the response to set
	 */
	public void setResponse(TestResultResponse response) {
		this.response = response;
	}

	/**
	 * @param errorInfo the errorInfo to set
	 */
	public void setErrorInfo(ErrorInfo errorInfo) {
		this.errorInfo = errorInfo;
	}	
}
