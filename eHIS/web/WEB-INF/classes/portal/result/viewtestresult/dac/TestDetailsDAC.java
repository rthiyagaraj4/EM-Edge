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
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import portal.common.response.ErrorInfo;
import portal.result.viewtestresult.request.TestDetailsRequest;
import portal.result.viewtestresult.response.TestDetails;
import portal.result.viewtestresult.response.TestDetailsResponse;
import portal.tools.PortalHelper;


/**
 * This class is used for creating the method to retrieve information about TestResults
 * based on patientId and the OrderDate. If the orderDate is not specified then the 
 * TestResults are picked up for the last 6 months
 * 
 * @author skrishnared2
 *
 */
public class TestDetailsDAC {

	// instance variables
	TestDetailsResponse response;
	ErrorInfo errorInfo;
	
	/**
	 * This is the persistance class to query test results from the database
	 * 
	 * @param request - instance of TestDetailsRequest
	 * @return TestDetailsResponse
	 */
	public TestDetailsResponse getTestDetails(TestDetailsRequest request){
		
		// initialize the error object and set it in the response
		response.setErrorInfo(errorInfo);
		
		// this is the only data that we need from the request
		String patientId = request.getPatientId();
		int resultLen = request.getResultSetSize();
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
			           " and a.order_Category in ('LB','RD') " + 
			           " and b.order_line_status not in ('CN','DC','FC') " ;	
		
		String noOfRows = " and rownum <= " + resultLen;
		String cond1 = " and a.patient_id = '" + patientId + "' ";
		String cond2 = "";
		if(orderId != null && orderId.trim().length() > 0) {
			cond2 = " and a.ordeR_id like Upper('%&p_Order_id%') ";
		}
		String cond3 = "";
		if(location != null && location.trim().length() > 0) {
			cond3 = " and a.source_code = '" + location + "' "; 
		}
		String cond4 = "";
		if(resultType != null && resultType.trim().length() > 0) {
			cond4 = " and a.order_Category = '" + resultType + "' ";
		}
		String cond5 = "";
		if(fromDate != null && fromDate.trim().length() > 0 && toDate != null && toDate.trim().length() > 0) {
			cond5 = " and a.ord_date_time between to_date(NVL('" + fromDate + "' ,'01/10/1000'), 'DD/MM/YYYY') and to_date(NVL('" + toDate + "','01/01/1000'), 'DD/MM/YYYY') + 0.0999 ";
		} else {
			cond5 = " and a.ord_date_time between to_date(to_char(sysdate,'DD/MM/YYYY'), 'DD/MM/YYYY') and to_date(to_char(sysdate-182,'DD/MM/YYYY'), 'DD/MM/YYYY') + 0.0999 ";
		}
		
		queryBuff.append(query);
		queryBuff.append(cond1);
		queryBuff.append(cond2);
		queryBuff.append(cond3);
		queryBuff.append(cond4);
		queryBuff.append(cond5);
		if(resultLen != 0) {
			queryBuff.append(noOfRows);
		}
		
		System.out.println("queryBuff.toString() : "  + queryBuff.toString());
		
		// get the connection
		Connection conn = PortalHelper.getConnection();
		// safe check
		if(conn == null){
			errorInfo.setErrorCode(ErrorInfo.CONNECTION_FAILURE_CODE);
		// TODO the message is being set temporarily
			errorInfo.setErrorMessage("Could not get connection");
			return response;
		}
		// initialize the list which will contain the data
		List<TestDetails> testDetailsList = new ArrayList<TestDetails>();
		// execute the query and get the data
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(queryBuff.toString());
			if(rs != null){
				testDetailsList = getTestDetailsList(rs);
				response.setTestDetailsList(testDetailsList);
			}
			else {
				errorInfo.setErrorCode(ErrorInfo.NO_DB_DATA_RETURNED_CODE);
				//errorInfo.setErrorMessage(ErrorInfo.)
				return response;
			}
		} catch (SQLException e) {
			/**
			 * TODO
			 * need to handle this with logging
			 */
			System.out.println("exception while obtaining test data "+e.getMessage());
			errorInfo.setErrorCode(ErrorInfo.SQLEXCEPTION_CODE);
			String errorMessage = "Exception while retrieving test details";
			errorMessage = MessageFormat.format(errorMessage,
					new Object[] { e.getMessage() });
			errorInfo.setErrorMessage(errorMessage);
			return response;
		}finally{
			PortalHelper.closeResources(conn, stmt, rs);
			conn = null;
		}
		
		// set the error info object to the response
		// for the time being an error info object with positive
		// result is set
		errorInfo.setErrorCode(ErrorInfo.SUCCESS_CODE);
		
		return response;
	}
		
	/**
	 * This method will create the TestDetails object from ResultSet
	 * 
	 * @param rs
	 * @return
	 */
	private List<TestDetails> getTestDetailsList(ResultSet rs){
		List<TestDetails> testDetailsList = new ArrayList<TestDetails>();
		// vars used in the method
		TestDetails testDetails = null;
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
				testDetails = new TestDetails();
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
			System.out.println("exception while retrieving test detail records "+e.getMessage());
		}
		
		return testDetailsList;
	}
	
	/**
	 * @param response the response to set
	 */
	public void setResponse(TestDetailsResponse response) {
		this.response = response;
	}

	/**
	 * @param errorInfo the errorInfo to set
	 */
	public void setErrorInfo(ErrorInfo errorInfo) {
		this.errorInfo = errorInfo;
	}
	
}
