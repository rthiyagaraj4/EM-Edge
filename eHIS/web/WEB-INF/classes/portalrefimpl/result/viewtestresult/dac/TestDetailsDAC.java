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
package portalrefimpl.result.viewtestresult.dac;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import portalrefimpl.PortalHelper;
import portalrefimpl.common.CommonConstants;
import portalrefimpl.common.message.MessageContainer;
import portalrefimpl.common.response.ErrorInfo;
import portalrefimpl.result.viewtestresult.request.TestDetailsRequest;
import portalrefimpl.result.viewtestresult.response.TestDetails;
import portalrefimpl.result.viewtestresult.response.TestDetailsResponse;
import portalrefimpl.result.viewtestresult.svc.TestDetailsConstant;




/**
 * @author GRamamoorthy
 *
 */
public class TestDetailsDAC {

	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public TestDetailsResponse getTestDetails(TestDetailsRequest request){
		// initialize the response object
		TestDetailsResponse response = new TestDetailsResponse();
		// initialize the error object and set it in the response
		/*ErrorInfo errorInfo = new ErrorInfo();*/
		ErrorInfo errorInfo = null;
		/*errorInfo.setErrorCode(ErrorInfo.SUCCESS_CODE);
		response.setErrorInfo(errorInfo);*/
		int errorCode = ErrorInfo.SUCCESS_CODE;
		String errorMessage = null;
		
		// this is the only data that we need from the request
		String patientId = request.getPatientId();
		int recordCount = request.getRecordCount();
		
		// contains the SQL query
		StringBuffer queryBuff = new StringBuffer();
		queryBuff.append("SELECT   A.ORDER_ID \"ORDER NO\", ");
		queryBuff.append("F.FACILITY_NAME \"LOCATION\", ");
		queryBuff.append("C.SHORT_DESC \"RESULT_TYPE\", ");
		queryBuff.append("B.CATALOG_DESC \"ORDER\", a.ord_date_time \"ORDER_DATE\", a.ord_pract_id \"PRACT_ID\", AM_GET_DESC.AM_PRACTITIONER (a.ord_pract_id, 'en', '1' ) \"ORDERED_BY\", D.SHORT_DESC \"STATUS\" ");
		queryBuff.append("FROM OR_ORDER A, OR_ORDER_LINE B, OR_ORDER_CATEGORY C, OR_ORDER_STATUS_CODE D, PR_ENCOUNTER E, SM_FACILITY_PARAM_VW F ");
		queryBuff.append("WHERE A.PATIENT_ID = '"+patientId+"' AND B.ORDER_LINE_STATUS = 'CD' AND A.ORDER_ID = B.ORDER_ID AND A.ORDER_CATEGORY = C.ORDER_CATEGORY AND B.ORDER_LINE_STATUS = D.ORDER_STATUS_CODE AND A.ENCOUNTER_ID = E.ENCOUNTER_ID AND A.ORDERING_FACILITY_ID = F.FACILITY_ID and A.ORDER_CATEGORY in ('LB','RD') and rownum <= "+recordCount+" ORDER BY A.ord_date_time DESC");
		// get the connection
		Connection conn = PortalHelper.getConnection();
		// safe check
		if(conn == null){
			errorCode = CommonConstants.DBCONNECTION_FAILURE_ERRORCODE;
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.COMMON_MODULE_NAME, errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			response.addError(errorInfo);
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
			if(rs == null){
				errorCode = TestDetailsConstant.TESTRESULTDETAILS_NULLRESULTSET_ERRORCODE;
				errorMessage = MessageContainer.getInstance()
						.getDisplayMessage(
								CommonConstants.VIEWTESTRESULTS_MODULE_NAME,
								errorCode);
				errorInfo = new ErrorInfo();
				errorInfo.setErrorCode(errorCode);
				errorInfo.setErrorMessage(errorMessage);
				response.addError(errorInfo);
				return response;
			}
			// get the list of test results and if it is empty
			// then flag an error
			testDetailsList = getTestDetailsList(rs);
			if(testDetailsList.isEmpty()){
				errorCode = TestDetailsConstant.TESTRESULTDETAILS_DATANOTFOUND_ERRORCODE;
				errorMessage = MessageContainer.getInstance()
						.getDisplayMessage(
								CommonConstants.VIEWTESTRESULTS_MODULE_NAME,
								errorCode);
				errorInfo = new ErrorInfo();
				errorInfo.setErrorCode(errorCode);
				errorInfo.setErrorMessage(errorMessage);
				response.addError(errorInfo);
				return response;
			}else{
				errorInfo = new ErrorInfo();
				errorInfo.setErrorCode(ErrorInfo.SUCCESS_CODE);
				response.addError(errorInfo);
			}
			// all is well now - set the list to the response
			response.setTestDetailsList(testDetailsList);
		} catch (SQLException e) {
			/*System.out.println("exception while obtaining test data "+e.getMessage());*/
			errorInfo = new ErrorInfo();
			errorCode = TestDetailsConstant.TESTRESULTDETAILS_SQLEXCEPTION_ERRORCODE;
			errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(
							CommonConstants.VIEWTESTRESULTS_MODULE_NAME,
							errorCode);
			errorInfo.setErrorCode(errorCode);
			/*errorMessage = ErrorInfo.EXCEPTION_MESSAGE;*/
			/*errorMessage = MessageFormat.format(errorMessage,
					new Object[] { e.getMessage() });*/
			errorInfo.setErrorMessage(errorMessage);
			response.addError(errorInfo);
			/*return response;*/
		}finally{
			PortalHelper.closeResources(conn, stmt, rs);
			/*if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					// cannot do much
				}
			}
			if(stmt != null){
				try {
					stmt.close();
				} catch (SQLException e) {
					// cannot do much
				}
			}
			conn = null;*/
		}
		
	/*	// set the error info object to the response
		// for the time being an error info object with positive
		// result is set
		errorInfo.setErrorCode(ErrorInfo.SUCCESS_CODE);*/
		
		return response;
	}
		
	/**
	 * 
	 * @param rs
	 * @return
	 */
	private List<TestDetails> getTestDetailsList(ResultSet rs) throws SQLException {
		List<TestDetails> testDetailsList = new ArrayList<TestDetails>();
		// vars used in the method
		TestDetails testDetails = null;
		String orderNo = null;
		String location = null;;
		String resultType = null;
		String order = null;
		Date orderDate = null;
		String practId = null;
		String practName = null;
		String status = null;
		/*try {*/
			while(rs.next()){
				// get the data required
				orderNo = rs.getString("ORDER NO");
				location = rs.getString("LOCATION");
				resultType = rs.getString("RESULT_TYPE");
				order = rs.getString("ORDER");
				orderDate = rs.getTimestamp("ORDER_DATE");
				practId = rs.getString("PRACT_ID");
				practName = rs.getString("ORDERED_BY");
				status = rs.getString("STATUS");
				// initialize the testdetails object
				// and set the data
				testDetails = new TestDetails();
				testDetails.setLocation(location);
				testDetails.setOrder(order);
				testDetails.setOrderDate(orderDate);
				testDetails.setOrderNo(orderNo);
				testDetails.setPractId(practId);
				testDetails.setPractName(practName);
				testDetails.setResultType(resultType);
				testDetails.setStatus(status);
				// finally add the testdetails object to list
				testDetailsList.add(testDetails);
			}
		/*} catch (SQLException e) {
			*//**
			 * TODO
			 * need to handle this with logging
			 *//*
			System.out.println("exception while retrieving test detail records "+e.getMessage());
		}*/
		
		return testDetailsList;
	}
	
}
