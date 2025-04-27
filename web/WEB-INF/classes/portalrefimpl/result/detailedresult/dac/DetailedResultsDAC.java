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
package portalrefimpl.result.detailedresult.dac;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import portalrefimpl.PortalHelper;
import portalrefimpl.common.CommonConstants;
import portalrefimpl.common.message.MessageContainer;
import portalrefimpl.common.response.ErrorInfo;
import portalrefimpl.homepage.HomePageConstants;
import portalrefimpl.result.ResultConstants;
import portalrefimpl.result.ResultHelper;
import portalrefimpl.result.detailedresult.request.DetailedResultsRequest;
import portalrefimpl.result.detailedresult.response.DetailedResult;
import portalrefimpl.result.detailedresult.response.DetailedResultsResponse;
import portalrefimpl.result.detailedresult.response.ResultStatus;

/**
 * This is the DAC class for getting detailed test results 
 * @author GRamamoorthy
 *
 */
public class DetailedResultsDAC {

	/**
	 * This method gets the test results to be shown in the test results
	 * main screen in the Portal application
	 * @param resultsRequest
	 * @return
	 */
	public DetailedResultsResponse getDetailedResults(DetailedResultsRequest resultsRequest){
		// initialize the response object
		DetailedResultsResponse resultsResponse = new DetailedResultsResponse();
		ErrorInfo errorInfo = null;//new ErrorInfo();
		//errorInfo.setErrorCode(ErrorInfo.SUCCESS_CODE);
		/*resultsResponse.setErrorInfo(errorInfo);*/

		Connection conn = PortalHelper.getConnection();
		// safe check for null connection
		if(conn == null){
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(CommonConstants.DBCONNECTION_FAILURE_ERRORCODE);
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(CommonConstants.COMMON_MODULE_NAME,
							CommonConstants.DBCONNECTION_FAILURE_ERRORCODE);
			errorInfo.setErrorMessage(errorMessage);
			resultsResponse.addError(errorInfo);
			return resultsResponse;
			/*return resultsResponse;*/
		}
		
		// initialize prepared statement and result set
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		// get the SQL query
		String sqlQuery = getDetailedResultsQuery(resultsRequest);
		
		try {
			prepStmt = conn.prepareStatement(sqlQuery);
			setDataInPreparedStatement(prepStmt,resultsRequest);
			rs = prepStmt.executeQuery();
			// check the result set for null
			if(rs == null){
				errorInfo = new ErrorInfo();
				errorInfo
				.setErrorCode(ResultConstants.DETAILEDTESTRESULT_NOTOBTAINED_CODE);
				String errorMessage = MessageContainer.getInstance()
						.getDisplayMessage(CommonConstants.DETAILED_TESTRESULT_MODULE_NAME,
								ResultConstants.DETAILEDTESTRESULT_NOTOBTAINED_CODE);
				errorInfo.setErrorMessage(errorMessage);
				resultsResponse.addError(errorInfo);
				return resultsResponse;
			}
			
			populateDataInDetailedTestResultResponse(rs, resultsResponse);
			
			// finally set positive response
			if(!resultsResponse.hasErrors()){
				errorInfo = new ErrorInfo();
				errorInfo.setErrorCode(ErrorInfo.SUCCESS_CODE);
				resultsResponse.addError(errorInfo);
			}
		} catch (SQLException e) {
			errorInfo = new ErrorInfo();
			errorInfo
					.setErrorCode(ResultConstants.SQLEXCEPTION_DETAILEDTESTRESULT_CODE);
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(CommonConstants.DETAILED_TESTRESULT_MODULE_NAME,
							ResultConstants.SQLEXCEPTION_DETAILEDTESTRESULT_CODE);
			errorInfo.setErrorMessage(errorMessage);
			resultsResponse.addError(errorInfo);
		}finally{
			PortalHelper.closeResources(conn, prepStmt, rs);
		}
		
		return resultsResponse;
	}
	
	/**
	 * This method returns the SQL query needed for getting test results
	 * to be shown in the test results main screen
	 * @return
	 */
	private String getDetailedResultsQuery(DetailedResultsRequest resultsRequest){
		String location = resultsRequest.getLocation();
		String orderNumber = resultsRequest.getOrderNumber();
		
		StringBuffer queryBuffer = new StringBuffer();
		queryBuffer.append("select (select short_desc from or_order_Catalog where order_Catalog_code = b.order_Catalog_code) Order_catalog_name, (select practitioner_name from am_practitioner  where practitioner_id = a.ord_pract_id) Practitioner_name, a.order_id Order_Id, decode(source_type,'C',(select short_Desc from op_clinic where facility_id = a.ORDERING_FACILITY_ID and clinic_code =a.source_code), 'N',(select short_Desc from ip_nursing_unit where facility_id = a.ORDERING_FACILITY_ID and nursing_unit_code =a.source_code), 'E', (select short_Desc from op_clinic where facility_id = a.ORDERING_FACILITY_ID and clinic_code =a.source_code), 'D',(select short_Desc from ip_nursing_unit where facility_id = a.ORDERING_FACILITY_ID and nursing_unit_code =a.source_code)) Location, (select short_desc from or_order_Category where order_Category = a.order_Category) result_type, a.ord_Date_Time ord_Date_Time, decode(b.order_line_status,'CD','Y','RS','Y', 'RA','Y','RM','Y','MA','Y','N') View_Results ");
		queryBuffer.append("from or_order a,or_ordeR_line b ");
		queryBuffer.append("where a.ordeR_id = b.order_id and a.patient_id = ? and ");
		// if order number is provided include it in query
		if(orderNumber != null && !orderNumber.trim().equals("")){
			queryBuffer.append("a.order_id =? and ");	
		}
		// check the location as well in the query
		if(location != null && !location.trim().equals("")){
			queryBuffer.append("a.ORDERING_FACILITY_ID =? and ");
		}
		
		// code added to check if the reset value is set in the request
		// this means that we need to get the initial N number of records
		// without applying the date filter
		String initialResetValue = resultsRequest.getInitialResetValue();
		if (ResultConstants.DETAILEDRESULTS_DEFAULT_INITIALRESET_VALUE
				.equalsIgnoreCase(initialResetValue)) {
			queryBuffer
					.append("a.order_Category in ('"
							+ ResultConstants.DETAILEDRESULTS_ORDERCATEGORY_LAB_KEY
							+ "','"
							+ ResultConstants.DETAILEDRESULTS_ORDERCATEGORY_RADIOLOGY_KEY
							+ "') and ");
		}else{
			// check the order category as well in the query
			queryBuffer.append("a.order_Category in (?) and ");			
		}

		queryBuffer.append("b.order_line_status not in ('CN','DC','FC')");
		
		if (ResultConstants.DETAILEDRESULTS_DEFAULT_INITIALRESET_VALUE
				.equalsIgnoreCase(initialResetValue)) {
			queryBuffer.append(" and rownum <= ");
			String detailedResultsCount = PortalHelper.getConfigPropertyValue(
					ResultConstants.DETAILEDRESULTS_RESULTROWCOUNT_KEY, true);
			if(detailedResultsCount == null || detailedResultsCount.trim().equals("")){
				detailedResultsCount = "" + ResultConstants.DETAILEDRESULTS_DEFAULT_RESULTROWCOUNT;
			}
			queryBuffer.append(detailedResultsCount);
		}else{
			queryBuffer.append(" and a.ord_date_time between to_date(?,'DD/MM/YYYY') and to_date(?,'DD/MM/YYYY') + 0.0999 ");
		}
		
		queryBuffer.append(" order by a.ord_Date_time desc");
		
		return queryBuffer.toString();
	}
	
	/**
	 * This method sets the data in prepared statement before it is executed
	 * @param prepStmt
	 * @param detailedResultsRequest
	 */
	private void setDataInPreparedStatement(PreparedStatement prepStmt,
			DetailedResultsRequest resultsRequest) throws SQLException{
		String patientId = resultsRequest.getPatientId();
		if(patientId == null){
			patientId = "";
		}
		String location = resultsRequest.getLocation();
		String orderNumber = resultsRequest.getOrderNumber();
		String orderCategory = resultsRequest.getOrderCategory();
		
		int index = 1;
		prepStmt.setString(index, patientId);
		index++;
		
		// if order number is provided include it in query
		if(orderNumber != null && !orderNumber.trim().equals("")){
			prepStmt.setString(index, orderNumber);
			index++;
		}
		
		// check the location as well in the query
		if(location != null && !location.trim().equals("")){
			prepStmt.setString(index, location);
			index++;
		}
		
		// code added to check if the reset value is set in the request
		// this means that we need to get the initial N number of records
		// without applying the date filter
		String initialResetValue = resultsRequest.getInitialResetValue();
		if (ResultConstants.DETAILEDRESULTS_DEFAULT_INITIALRESET_VALUE
				.equalsIgnoreCase(initialResetValue)) {
			return;
		}
		
		prepStmt.setString(index, orderCategory);
		index++;
		
		String fromDateString = resultsRequest.getFromDateString();
		if(fromDateString != null){
			prepStmt.setString(index, fromDateString);
			index++;
		}
		
		String toDateString = resultsRequest.getToDateString();
		if(toDateString != null){
			prepStmt.setString(index, toDateString);
			index++;
		}
		
		
	}
	
	/**
	 * This method populates data in the detailed test result response
	 * @param rs
	 * @param resultsResponse
	 * @throws SQLException
	 */
	private void populateDataInDetailedTestResultResponse(ResultSet rs,
			DetailedResultsResponse resultsResponse) throws SQLException{
		List<DetailedResult> detailedResultList = new ArrayList<DetailedResult>();
		String orderCatalogue = null;
		String orderNumber = null;
		String facility = null;
		String orderCategory = null;
		Date orderDate = null;
		String practitioner = null;
		String resultStatusString = null;
		ResultStatus resultStatus = null;
		
		DetailedResult detailedResult = null;
		// iterate through the results
		while(rs.next()){
			orderCatalogue = rs.getString("Order_catalog_name");
			orderNumber = rs.getString("Order_Id");
			practitioner = rs.getString("Practitioner_name");
			facility = rs.getString("Location");
			orderCategory = rs.getString("result_type");
			orderDate = rs.getTimestamp("ord_Date_Time");
			resultStatusString = rs.getString("View_Results");
			
			detailedResult = new DetailedResult();
			detailedResult.setLocation(facility);
			detailedResult.setOrderCatalogue(orderCatalogue);
			detailedResult.setOrderCategory(orderCategory);
			detailedResult.setOrderDate(orderDate);
			detailedResult.setOrderNumber(orderNumber);
			detailedResult.setOrderPractitioner(practitioner);
			
			resultStatus = ResultHelper
					.getResultStatus(resultStatusString);
			detailedResult.setResultStatus(resultStatus);
			
			// finally add the detailed test result object to the list
			detailedResultList.add(detailedResult);
		}
		// checking for empty data
		if(detailedResultList.isEmpty()){
			/*ErrorInfo errorInfo = resultsResponse.getErrorInfo();*/
			ErrorInfo errorInfo = new ErrorInfo();
			errorInfo
			.setErrorCode(ResultConstants.DETAILEDTESTRESULT_NOTOBTAINED_CODE);
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(CommonConstants.DETAILED_TESTRESULT_MODULE_NAME,
							ResultConstants.DETAILEDTESTRESULT_NOTOBTAINED_CODE);
			errorInfo.setErrorMessage(errorMessage);
			resultsResponse.addError(errorInfo);
		}
		
		resultsResponse.setTestResultList(detailedResultList);
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		DetailedResultsRequest resultsRequest = new DetailedResultsRequest();
		resultsRequest.setPatientId("MC00000345");
		resultsRequest.setPatientId("SO00000423");
		resultsRequest.setOrderCategory("LB");
		Date fromDate = PortalHelper.getDateFromString("28/11/2012", "dd/MM/yyyy");
		resultsRequest.setFromDate(fromDate);
		resultsRequest.setFromDateString("28/11/2012");
		
		Date toDate = new Date();
		resultsRequest.setToDate(toDate);
		resultsRequest.setToDateString("27/12/2012");
		
		DetailedResultsDAC dacInst = new DetailedResultsDAC();
		DetailedResultsResponse resultsResponse = dacInst.getDetailedResults(resultsRequest);
		System.out.println("results obtained");
	}
	
}
