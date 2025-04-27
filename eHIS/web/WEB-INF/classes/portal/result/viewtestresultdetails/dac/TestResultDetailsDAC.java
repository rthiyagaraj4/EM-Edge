/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package portal.result.viewtestresultdetails.dac;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import portal.common.response.ErrorInfo;
import portal.result.viewtestresultdetails.request.TestResultDetailsRequest;
import portal.result.viewtestresultdetails.response.TestResultDetails;
import portal.result.viewtestresultdetails.response.TestResultDetailsResponse;
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
public class TestResultDetailsDAC {

	// instance variables
	TestResultDetailsResponse response;
	ErrorInfo errorInfo;
	private static Logger logger = Logger.getLogger(TestResultDetailsDAC.class.getName());
	/**
	 * This is the persistence class to query test results from the database
	 * 
	 * @param request - instance of TestDetailsRequest
	 * @return TestDetailsResponse
	 */
	public TestResultDetailsResponse getTestResultDetails(TestResultDetailsRequest request){
		
		// initialize the error object and set it in the response
		/*TestResultDetailsResponse response = new TestResultDetailsResponse();
		ErrorInfo errorInfo = null;*/
		response.setErrorInfo(errorInfo);
		logger.info("Entering the method  getTestResultDetails:");
		// this is the only data that we need from the request
		String patientId = request.getPatientId();
		String orderId = request.getOrderId();
		String location = request.getLocation();
		String resultType = request.getResultType();
		String fromDate = request.getOrderFromDate();
		String toDate = request.getOrderToDate();
		
		// contains the SQL query
		StringBuffer queryBuff = new StringBuffer();

		String query = "select a.patient_id, (select short_desc from or_order_Catalog where order_Catalog_code = b.order_Catalog_code) Order_catalog_name, " +
			           " (select practitioner_name from am_practitioner  where practitioner_id = a.ord_pract_id) Practitioner_name, " +
			           " a.order_id Order_Id, " +
			           " decode(source_type,'C',(select short_Desc from op_clinic where facility_id = a.ORDERING_FACILITY_ID and clinic_code =a.source_code), " +
			                       " 'N',(select short_Desc from ip_nursing_unit where facility_id = a.ORDERING_FACILITY_ID and nursing_unit_code =a.source_code), " +
			                       " 'E', (select short_Desc from op_clinic where facility_id = a.ORDERING_FACILITY_ID and clinic_code =a.source_code), " +
			                       " 'D',(select short_Desc from ip_nursing_unit where facility_id = a.ORDERING_FACILITY_ID and nursing_unit_code =a.source_code)) Location, " +
			           " (select short_desc from or_order_Category where order_Category = a.order_Category) result_type, " + 
			           " to_timestamp(to_char(a.ord_Date_Time,'DD/MM/YYYY hh24:mi'),'DD/MM/YYYY hh24:mi') ord_Date_Time, " +
			           " decode(b.order_line_status,'CD','Y','RS','Y', 'RA','Y','RM','Y','MA','Y','N') View_Results " +  
			           " from or_order a,or_ordeR_line b "+ 
			           " where a.ordeR_id = b.order_id " +
			           " and b.order_line_status not in ('CN','DC','FC') " ;	
		
		String cond1 = " and a.patient_id = '" + patientId + "' ";
		String cond2 = "";
		if(orderId != null && orderId.trim().length() > 0) {
			orderId = orderId.toUpperCase();
			cond2 = " and a.ordeR_id like Upper('%"+orderId+"%') ";
		}
		String cond3 = "";
		if(location != null && location.trim().length() > 0) {
			cond3 = " and a.ORDERING_FACILITY_ID = '" + location + "' "; 
		}
		String cond4 = "";
		if(resultType != null && resultType.trim().length() > 0) {
			cond4 = " and a.order_Category = '" + resultType + "' ";
		}else{
			cond4 =  " and a.order_Category in ('LB','RD') ";
		}
		String cond5 = "";
		if(fromDate != null && fromDate.trim().length() > 0 && toDate != null && toDate.trim().length() > 0) {
			cond5 = " and a.ord_date_time between to_date(NVL('" + fromDate + "' ,'01/10/1000'), 'DD/MM/YYYY') and to_date(NVL('" + toDate + "','01/01/1000'), 'DD/MM/YYYY') + 0.999 ";
		} else if(fromDate != null && fromDate.trim().length() > 0) {
			cond5 = " and a.ord_date_time between to_date(NVL('" + fromDate + "' ,'01/10/1000'), 'DD/MM/YYYY') and to_date(to_char(sysdate,'DD/MM/YYYY'), 'DD/MM/YYYY') + 0.999 ";
		} else if(toDate != null && toDate.trim().length() > 0) {
			cond5 = " and a.ord_date_time <= to_date(NVL('" + toDate + "','01/01/1000'), 'DD/MM/YYYY') + 0.999 ";
		}  else {
			cond5 = " and a.ord_date_time <= sysdate ";
		}
		
		queryBuff.append(query);
		queryBuff.append(cond1);
		queryBuff.append(cond2);
		queryBuff.append(cond3);
		queryBuff.append(cond4);
		queryBuff.append(cond5);
		
		
		logger.info("queryBuff.toString() : "  + queryBuff.toString());
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		// get the connection
		conn = PortalHelper.getConnection();
		// safe check
		if(conn == null){
			logger.fatal("Connection is null :");
			errorInfo = ErrorMessageUtil.getErrorMessage(TestDetailsConstant.TESTRESULTDETAILS_MODULE_NAME, ErrorInfo.TESTRESULTDETAILS_CONNECTION_FAILURE_CODE);
			response.setErrorInfo(errorInfo);
			logger.info("Connection is null in the method getTestResultDetails");
			return response;
		}
		// initialize the list which will contain the data
		List<TestResultDetails> testResultDetailsList = new ArrayList<TestResultDetails>();
		// execute the query and get the data
		try {
		
			stmt = conn.createStatement();
			rs = stmt.executeQuery(queryBuff.toString());
			if(rs != null){
				testResultDetailsList = getTestResultDetailsList(rs);
				if(testResultDetailsList == null || testResultDetailsList.isEmpty() ){
					errorInfo = ErrorMessageUtil.getErrorMessage(TestDetailsConstant.TESTRESULTDETAILS_MODULE_NAME, ErrorInfo.TESTRESULTDETAILS_NO_DB_DATA_RETURNED_CODE);	
					logger.info("NO DB data in the method getTestResultDetails");
				} else {
					response.setTestResultDetailsList(testResultDetailsList);
					// set the error info object to the response
					// for the time being an error info object with positive
					// result is set
					errorInfo = ErrorMessageUtil.getErrorMessage(TestDetailsConstant.TESTRESULTDETAILS_MODULE_NAME, ErrorInfo.SUCCESS_CODE);
					logger.info("SUCCESS in the method getTestResultDetails");
				}				
			}
			else {
				errorInfo = ErrorMessageUtil.getErrorMessage(TestDetailsConstant.TESTRESULTDETAILS_MODULE_NAME, ErrorInfo.TESTRESULTDETAILS_NO_DB_DATA_RETURNED_CODE);
				logger.info("NO DB data in the method getTestResultDetails");
				response.setErrorInfo(errorInfo);
				return response;
			}
		} catch (SQLException e) {
			/**
			 * TODO
			 * need to handle this with logging
			 */
			e.printStackTrace();
			logger.fatal("Exception in DAC :", e);
			errorInfo = ErrorMessageUtil.getErrorMessage(TestDetailsConstant.TESTRESULTDETAILS_MODULE_NAME,	ErrorInfo.TESTRESULTDETAILS_SQLEXCEPTION_CODE, e.getMessage());
			System.out.println("----------errorInfo : "+errorInfo.toString());
			response.setErrorInfo(errorInfo);
		}finally{
			PortalHelper.closeResources(conn, stmt, rs);
			conn = null;
		}
		
		// set the error info object to the response
		// for the time being an error info object with positive
		// result is set
		response.setErrorInfo(errorInfo);
		return response;
	}
		
	/**
	 * This method will create the TestDetails object from ResultSet
	 * 
	 * @param rs
	 * @return
	 */
	@SuppressWarnings("deprecation")
	private List<TestResultDetails> getTestResultDetailsList(ResultSet rs){
		List<TestResultDetails> testDetailsList = new ArrayList<TestResultDetails>();
		// vars used in the method
		TestResultDetails testDetails = null;
		String orderNo = null;
		String location = null;;
		String resultType = null;
		String order = null;
		Timestamp orderDate = null;
		String practName = null;
		String status = null;
		try {
			while(rs.next()){
				// get the data required
				orderNo = rs.getString("Order_Id");
				location = rs.getString("Location");
				resultType = rs.getString("result_type");
				order = rs.getString("Order_catalog_name");
				orderDate = rs.getTimestamp("ord_Date_Time");
				practName = rs.getString("Practitioner_name");
				status = rs.getString("View_Results");
				
				// initialize the testdetails object
				// and set the data
				testDetails = new TestResultDetails();
				testDetails.setOrderNo(orderNo);
				testDetails.setLocation(location);
				testDetails.setResultType(resultType);
				testDetails.setOrderDesc(order);
				testDetails.setPractName(practName);
				testDetails.setOrderDate(orderDate.toLocaleString());
				testDetails.setStatus(status);

				// finally add the testdetails object to list
				testDetailsList.add(testDetails);
			}
		} catch (SQLException e) {
			/**
			 * TODO
			 * need to handle this with logging
			 */
			logger.fatal("Exception in DAC :", e);
			System.out.println("exception while retrieving test detail records "+e.getMessage());
		}
		
		return testDetailsList;
	}
	
	/**
	 * @param response the response to set
	 */
	public void setResponse(TestResultDetailsResponse response) {
		this.response = response;
	}

	/**
	 * @param errorInfo the errorInfo to set
	 */
	public void setErrorInfo(ErrorInfo errorInfo) {
		this.errorInfo = errorInfo;
	}
	
}
