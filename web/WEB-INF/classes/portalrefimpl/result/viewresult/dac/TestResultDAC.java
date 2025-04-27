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
package portalrefimpl.result.viewresult.dac;

import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import portalrefimpl.PortalConstants;
import portalrefimpl.PortalHelper;
import portalrefimpl.common.CommonConstants;
import portalrefimpl.common.message.MessageContainer;
import portalrefimpl.common.response.ErrorInfo;
import portalrefimpl.result.ResultConstants;
import portalrefimpl.result.viewresult.request.TestResultRequest;
import portalrefimpl.result.viewresult.response.TestResult;
import portalrefimpl.result.viewresult.response.TestResultResponse;

/**
 * This is the DAC class for the test result service
 * @author GRamamoorthy
 *
 */
public class TestResultDAC {

	/**
	 * This method gets the test result data
	 * @param testResultRequest
	 * @return
	 */
	public TestResultResponse getTestResult(TestResultRequest testResultRequest){
		// initialize the test result response object
		TestResultResponse testResultResponse = new TestResultResponse();
		ErrorInfo errorInfo = null;
		//errorInfo.setErrorCode(ErrorInfo.SUCCESS_CODE);
		int errorCode = ErrorInfo.SUCCESS_CODE;
		/*testResultResponse.setErrorInfo(errorInfo);*/
		
		// the SQL query 
		String sqlQuery = getTestResultSQLQuery(testResultRequest);
		
		// get the connection object
		Connection connection = PortalHelper.getConnection();
		// safe check 
		if(connection == null){
			errorCode = CommonConstants.DBCONNECTION_FAILURE_ERRORCODE;
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(CommonConstants.COMMON_MODULE_NAME,
							errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			
			testResultResponse.addError(errorInfo);
			return testResultResponse;
		}
		
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		try {
			prepStmt = connection.prepareStatement(sqlQuery);
			setDataInPreparedStatement(prepStmt,testResultRequest);
			rs = prepStmt.executeQuery();
			if(rs == null){
				errorCode = ResultConstants.TESTRESULT_RESULTSET_NOTOBTAINED_ERRORCODE;
				String errorMessage = MessageContainer.getInstance()
						.getDisplayMessage(CommonConstants.TESTRESULT_MODULE_NAME,
								errorCode);
				
				errorInfo = new ErrorInfo();
				errorInfo.setErrorCode(errorCode);
				errorInfo.setErrorMessage(errorMessage);
				
				testResultResponse.addError(errorInfo);
				return testResultResponse;
			}
			// call the method to set data in the response object
			setDataInTestResultResponse(rs, testResultResponse,
					testResultRequest);
		} catch (SQLException e) {
			errorCode = ResultConstants.TESTRESULT_SQLEXCEPTION_ERRORCODE;
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(CommonConstants.TESTRESULT_MODULE_NAME,
							errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			
			testResultResponse.addError(errorInfo);
			return testResultResponse;
		}finally{
			PortalHelper.closeResources(connection, prepStmt, rs);
		}
		
		
		return testResultResponse;
	}
	
	/**
	 * This method gets the SQL Query needed for retrieving the test result
	 * @param testResultRequest
	 * @return
	 */
	private String getTestResultSQLQuery(TestResultRequest testResultRequest){
		StringBuffer queryBuffer = new StringBuffer();
		queryBuffer.append("SELECT   result_num_prefix, DECODE (NVL (result_num_dec, '0'), '0', TO_CHAR (result_num), "); 
        queryBuffer.append("TO_CHAR (result_num, DECODE (result_num_dec, 1, '999999990.0', 2, '999999990.90', 3, '999999990.900', 4, '999999990.9000', 5, '999999990.90000', 6, '999999990.900000', 7, '999999990.9000000', 8, '999999990.90000000', 9, '999999990.90000000' ) ) ) result_num, ");
        queryBuffer.append("result_num_uom, result_str result_str, d.hist_data result_data, TO_CHAR (a.event_date, 'dd/mm/yyyy hh24:mi') reporting_date, normalcy_ind result_status, ");
        queryBuffer.append("DECODE (NVL (result_num_dec, '0'), '0', TO_CHAR (normal_low), TO_CHAR (normal_low, DECODE (result_num_dec, 1, '999999990.0', 2, '999999990.90', 3, '999999990.900', 4, '999999990.9000', 5, '999999990.90000', 6, '999999990.900000', 7, '999999990.9000000', 8, '999999990.90000000', 9, '999999990.90000000' )  )  ) normal_low, ");
        queryBuffer.append("DECODE (NVL (result_num_dec, '0'),");
        queryBuffer.append("'0', TO_CHAR (normal_high),");
        queryBuffer.append("TO_CHAR (normal_high,");
        queryBuffer.append("DECODE (result_num_dec,");
        queryBuffer.append(" 1, '999999990.0',");
        queryBuffer.append(" 2, '999999990.90',");
        queryBuffer.append(" 3, '999999990.900',");
        queryBuffer.append(" 4, '999999990.9000',");
        queryBuffer.append(" 5, '999999990.90000',");
        queryBuffer.append(" 6, '999999990.900000',");
        queryBuffer.append(" 7, '999999990.9000000',");
        queryBuffer.append(" 8, '999999990.90000000',");
        queryBuffer.append(" 9, '999999990.90000000'");
        queryBuffer.append(" ) ) ) normal_high,");
        queryBuffer.append(" critical_low, critical_high, normalcy_ind norm_abnorm_ind,");
        queryBuffer.append(" c.long_desc parent_short_desc, b.long_desc child_desc, ");
        queryBuffer.append(" hist_data_type result_desc,");
        queryBuffer.append(" a.practitioner_id practitioner_id, ");
        queryBuffer.append(" a.performed_by_id reporting_practitioner,");
        queryBuffer.append(" a.hist_rec_type hist_rec_type, a.contr_sys_id contr_sys_id,");
        queryBuffer.append(" a.accession_num accession_num,");
        queryBuffer.append(" a.contr_sys_event_code contr_sys_event_code, a.status,");
        queryBuffer.append(" a.normalcy_str, a.num_data_yn, a.event_date");  
        queryBuffer.append(" FROM cr_encounter_detail a,");
        queryBuffer.append(" cr_cln_evt_mst_lang_vw b,");
        queryBuffer.append(" cr_cln_evt_grp_lang_vw c,");
        queryBuffer.append(" cr_encounter_detail_txt d");
        queryBuffer.append(" WHERE b.hist_rec_type = a.hist_rec_type");
        queryBuffer.append(" AND b.event_code = a.event_code");
        queryBuffer.append(" AND a.event_code_type = b.event_code_type");
        queryBuffer.append(" AND a.hist_rec_type = d.hist_rec_type(+)");
        queryBuffer.append(" AND a.contr_sys_id = d.contr_sys_id(+)");
        queryBuffer.append(" AND a.accession_num = d.accession_num(+)");
        queryBuffer.append(" AND a.contr_sys_event_code = d.contr_sys_event_code(+)");
        queryBuffer.append(" AND c.hist_rec_type(+) = a.hist_rec_type");
        queryBuffer.append(" AND c.event_group(+) = a.event_group");
        queryBuffer.append(" AND c.event_group_type(+) = a.event_group_type");
        queryBuffer.append(" AND SUBSTR (request_num, INSTR (request_num, '#') + 1, 15) IN (");
        queryBuffer.append(" SELECT accession_num");
        queryBuffer.append(" FROM or_order_line ");
        queryBuffer.append(" WHERE order_id = (?) ");
        queryBuffer.append(" AND accession_num IS NOT NULL ) ");
        queryBuffer.append(" AND patient_id = (?) ");
        queryBuffer.append(" AND 'A' =");
        queryBuffer.append(" DECODE (protection_ind,");
        queryBuffer.append(" 'Z', get_task_applicability ('VIEW_CONF_RESULT', '', 'CA', 'ASSISTING DI'),");
        queryBuffer.append(" 'A'");
        queryBuffer.append(" )");
        queryBuffer.append(" AND NVL (a.status, '#') != 'S'");
        queryBuffer.append(" AND b.language_id = ?");
        queryBuffer.append(" AND c.language_id(+) = ?");
        queryBuffer.append(" ORDER BY a.event_group,");
        queryBuffer.append(" a.event_code, a.event_date DESC");
		
		return queryBuffer.toString();
	}
	
	/**
	 * This method will set the data in the preparedstatement
	 * before it is executed
	 * @param prepStmt
	 * @param testResultRequest
	 */
	private void setDataInPreparedStatement(PreparedStatement prepStmt,
			TestResultRequest testResultRequest) throws SQLException{
		// the index to be used for setting the data
		int index = 1;
		
		// set the order number
		String orderNumber = testResultRequest.getOrderNumber();
		prepStmt.setString(index, orderNumber);
		index++;
		
		// set the patient id
		String patientId = testResultRequest.getPatientId();
		prepStmt.setString(index, patientId);
		index++;
		// now locale
		String locale = testResultRequest.getLocale();
		if(locale == null || locale.trim().equals("")){
			locale = PortalConstants.DEFAULT_LOCALE;
		}
		
		// need to set the locale twice
		prepStmt.setString(index, locale);
		index++;
		prepStmt.setString(index, locale);
		
	}
	
	/**
	 * This method reads the data from the resultSet object and sets
	 * data into the test result response object
	 * @param rs
	 * @param testResultResponse
	 * @param testResultRequest TODO
	 */
	private void setDataInTestResultResponse(ResultSet rs,
			TestResultResponse testResultResponse,
			TestResultRequest testResultRequest) throws SQLException {
		// initialize the list which will store the test result
		List<TestResult> testResultList = new ArrayList<TestResult>();
		
		Date latestPublishDateTime = null;
		String resultValue = "";
		String resultUOM = "";
		String resultStr = "";
		String notesContent = "";
		String normalLow = "";
		String normalHigh = "";
		String criticalLow = "";
		String criticalHigh = "";
		String order = "";
		String practitionerId = "";
		String reportingPractitionerId = "";
		Timestamp eventDateTime = null;
		
		// iterate through the result set and get the data
		while(rs.next()){
			TestResult testResult = new TestResult();
			
			// first get result value
			resultValue = rs.getString("RESULT_NUM");
			if(resultValue == null){
				resultValue = "";
			}
			resultValue = resultValue.trim();
			testResult.setResultValue(resultValue);
			
			// result UOM
			resultUOM = rs.getString("RESULT_NUM_UOM");
			if(resultUOM == null){
				resultUOM = "";
			}
			testResult.setResultUOM(resultUOM);
			
			// result str
			resultStr = rs.getString("RESULT_STR");
			if(resultStr == null){
				resultStr = "";
			}
			testResult.setResultStrValue(resultStr);
			
			// result data - this is the notes content
			Clob clobVal = rs.getClob("RESULT_DATA");
			if(clobVal != null){
				notesContent = clobVal.getSubString(1, (int)clobVal.length());
				if(notesContent == null){
					notesContent = "";
				}
			}
			testResult.setNotesContent(notesContent);
			
			// normal range low
			normalLow = rs.getString("NORMAL_LOW");
			if(normalLow == null){
				normalLow = "";
			}
			normalLow = normalLow.trim();
			testResult.setNormalLowValue(normalLow);
			
			// normal range high
			normalHigh = rs.getString("NORMAL_HIGH");
			if(normalHigh == null){
				normalHigh = "";
			}
			normalHigh = normalHigh.trim();
			testResult.setNormalHighValue(normalHigh);
			
			// critical range low
			criticalLow = rs.getString("CRITICAL_LOW");
			if(criticalLow == null){
				criticalLow = "";
			}
			criticalLow = criticalLow.trim();
			testResult.setCriticalLowValue(criticalLow);
			
			// critical range high
			criticalHigh = rs.getString("CRITICAL_HIGH");
			if(criticalHigh == null){
				criticalHigh = "";
			}
			criticalHigh = criticalHigh.trim();
			testResult.setCriticalHighValue(criticalHigh);
			
			// order value
			order = rs.getString("CHILD_DESC");
			if(order == null){
				order = "";
			}
			testResult.setOrder(order);
			
			// publish date
			eventDateTime = rs.getTimestamp("EVENT_DATE");
			/*Calendar calendar = Calendar.getInstance();
			calendar.setTime(eventDateTime);
			publishDateTime = calendar.getTime();*/
			//publishDateTime = rs.getDate("EVENT_DATE");
			if(eventDateTime != null){
				if(latestPublishDateTime == null){
					latestPublishDateTime = eventDateTime;
				}
				// check if the latest publish date time value
				// is before the publish date time for this result
				// if so it means this result's publish date time
				// should be used for the overall order
				if(latestPublishDateTime.before(eventDateTime)){
					latestPublishDateTime = eventDateTime;
				}
				
				testResult.setResultPublishDate(eventDateTime);
			}
			
			// practitioner id
			practitionerId = rs.getString("PRACTITIONER_ID");
			if(practitionerId == null){
				practitionerId = "";
			}
			testResult.setPractitionerId(practitionerId);
			
			// reporting practitioner id
			reportingPractitionerId = rs.getString("REPORTING_PRACTITIONER");
			if(reportingPractitionerId == null){
				reportingPractitionerId = "";
			}
			testResult.setReportingPractitionerId(reportingPractitionerId);
			
			testResultList.add(testResult);
		}
		
		// now take data from request and set it to the response
		// we are doing this so that we do not execute another
		// SQL query
		String orderDesc = testResultRequest.getOrder();
		if(orderDesc == null){
			orderDesc = "";
		}
		testResultResponse.setOrder(orderDesc);
		
		String orderNumber = testResultRequest.getOrderNumber();
		if(orderNumber == null){
			orderNumber = "";
		}
		testResultResponse.setOrderNumber(orderNumber);
		
		String resultType = testResultRequest.getResultType();
		if(resultType == null){
			resultType = ResultConstants.DETAILEDRESULTS_ORDERCATEGORY_LAB_MEDIUM_KEY;
		}
		testResultResponse.setResultType(resultType);
		
		testResultResponse.setPublishDate(latestPublishDateTime);
		
		int errorCode = ErrorInfo.SUCCESS_CODE;
		String errorMessage = null;
		// check if the list has data - if not set error in the response
		if(testResultList.isEmpty()){
			errorCode = ResultConstants.TESTRESULT_DATA_NOTOBTAINED_ERRORCODE;
			// get the error message and format it to add the order number
			// also in the error message
			errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(CommonConstants.TESTRESULT_MODULE_NAME,
							errorCode);
			errorMessage = MessageFormat.format(errorMessage, new Object[]{orderNumber});
			/*ErrorInfo errorInfo = testResultResponse.getErrorInfo();*/
		}
		
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorCode(errorCode);
		errorInfo.setErrorMessage(errorMessage);
		testResultResponse.addError(errorInfo);
		
		// set the list to response object
		testResultResponse.setTestResultList(testResultList);
		
	}
	
	
}
