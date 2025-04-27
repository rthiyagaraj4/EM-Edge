/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package portal.result.viewtestresultreport.dac;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Logger;

import portal.common.response.ErrorInfo;
import portal.result.viewtestresultreport.request.TestReportRequest;
import portal.result.viewtestresultreport.response.Report;
import portal.result.viewtestresultreport.response.TestReportResponse;
import portal.tools.ErrorMessageUtil;
import portal.tools.PortalHelper;
import portal.tools.TestReportConstant;

/**
 * This class is used for retrieving information about TestReport based on
 * patientId and the OrderId.
 * 
 * @author vkodancha
 * 
 */
public class TestReportDAC {

	// instance variables
	TestReportResponse response;
	ErrorInfo errorInfo;
	public static final String query;
	public static SimpleDateFormat sdf = new SimpleDateFormat(
			"dd/MM/yyyy HH:mm");
	private static Logger logger = Logger.getLogger(TestReportDAC.class
			.getName());

	static {
		query = getSQLQueryForTestReport();
	}

	/**
	 * This method is used to query test report details from the database
	 * 
	 * @param request
	 *            - instance of TestReportRequest
	 * @return TestReportResponse
	 */
	public TestReportResponse getTestReport(TestReportRequest request) {

		logger.info("Entering the method :getTestReport");
		// String query =
		boolean isListAvailable = false;
		response.setReportList(new ArrayList<Report>());
		// get the connection
		Connection conn = PortalHelper.getConnection();
		// safe check
		if (conn == null) {
			errorInfo = ErrorMessageUtil.getErrorMessage(
					TestReportConstant.MODULE_NAME,
					ErrorInfo.TESTREPORT_CONNECTION_FAILURE_CODE);
			response.setErrorInfo(errorInfo);
			logger.info("Connection is null in the method :getTestReport");
			return response;
		}
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			logger.info("Query for the method : getTestReport : " + query);
			// execute the query and get the data
			// filling response with request
			setResponseWithRequest(request);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, request.getOrderId());
			pstmt.setString(2, request.getPatientId());
			pstmt.setString(3, request.getLanguage());
			pstmt.setString(4, request.getLanguage());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				isListAvailable = true;
				response.addToReportList(getReport(rs));
				
			}
			if (!isListAvailable) {
				errorInfo = ErrorMessageUtil.getErrorMessage(
						TestReportConstant.MODULE_NAME,
						ErrorInfo.TESTREPORT_NO_DB_DATA_RETURNED_CODE);
				response.setErrorInfo(errorInfo);
				logger.info("Connection is null in the method :getTestReport");
			} else {
				errorInfo = ErrorMessageUtil.getErrorMessage(
						TestReportConstant.MODULE_NAME, ErrorInfo.SUCCESS_CODE);
				response.setErrorInfo(errorInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			errorInfo = ErrorMessageUtil.getErrorMessage(
					TestReportConstant.MODULE_NAME,
					ErrorInfo.TESTREPORT_SQLEXCEPTION_CODE, e.getMessage());
			response.setErrorInfo(errorInfo);
			logger.error("Exception in the method :getTestReport : msg:"
					+ e.getStackTrace().toString());
			// logger.log(Priority.toPriority(Priority.ERROR_INT),
			// e.getMessage(), e);
			logger.fatal(
					"Exception in the method :getTestReport : stack trace: ", e);
			return response;
		}

		return response;
	}

	/**
	 * This method is used to set each report data from result set
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private Report getReport(ResultSet rs) throws SQLException {
		Report report = new Report();
		report.setResultNumber(rs.getString("result_num"));
		report.setResultNumberUom(rs.getString("result_num_uom"));
		report.setResultStr(rs.getString("result_str"));
		report.setResultData(rs.getString("result_data"));
		report.setReportingDate(rs.getString("reporting_date"));
		report.setNormalLow(rs.getString("normal_low"));
		report.setNormalHigh(rs.getString("normal_high"));
		report.setCriticalLow(rs.getString("critical_low"));
		report.setCriticalHigh(rs.getString("critical_high"));
		report.setNormalAbnormalInd(rs.getString("norm_abnorm_ind"));
		report.setReportCaption(rs.getString("child_desc"));
		report.setPractitionerId(rs.getString("practitioner_id"));
		report.setReportingPractitionerId(rs
				.getString("reporting_practitioner"));
		report.setAccesssionNumber(rs.getString("accession_num"));
		report.setNumDataYnInd(rs.getString("num_data_yn"));
		report.setStatus(rs.getString("status"));
		report.setNormalacyStr(rs.getString("normalcy_str"));
		report.setOrderType(rs.getString("contr_sys_id"));
		report.setResultType(rs.getString("result_desc"));

		// This method checks the oder date and set it accordingly
		checkAndSetOrderDate(report.getReportingDate());

		return report;
	}

	/**
	 * This class is used to get the order date and time of test response
	 * 
	 * @param reportingDate
	 * @throws ParseException
	 */
	private void checkAndSetOrderDate(String reportingDate) {
		if ((response.getOrderDateandTime() == null || response
				.getOrderDateandTime().trim().isEmpty())
				&& (reportingDate != null && !reportingDate.trim().isEmpty())) {
			response.setOrderDateandTime(reportingDate);
		} else {
			try {
				Date reportDate = sdf.parse(reportingDate);
				Date responseDate = sdf.parse(response.getOrderDateandTime());
				if (reportDate.compareTo(responseDate) > 0) {
					response.setOrderDateandTime(reportingDate);
				}
			} catch (ParseException e) {
				logger.error("Exception in the method :getTestReport : msg:"
						+ e.getStackTrace().toString());
				logger.fatal(
						"Exception in the method :getTestReport : stack trace: ",
						e);
			}
		}

	}

	/**
	 * This method gets the String from String buffer for Test Report
	 * 
	 * @return
	 */
	public static String getSQLQueryForTestReport() {
		StringBuffer queryBuffer = new StringBuffer();
		queryBuffer.append(" SELECT ");
		queryBuffer.append(getDecodeNVLQueryFormat("result_num_dec",
				"result_num"));
		queryBuffer.append(" result_num_uom, ");
		queryBuffer.append(" result_str result_str, ");
		queryBuffer.append(" d.hist_data result_data, ");
		queryBuffer
				.append(" TO_CHAR (a.event_date, 'dd/mm/yyyy hh24:mi') reporting_date, ");
		queryBuffer.append(getDecodeNVLQueryFormat("result_num_dec",
				"normal_low"));
		queryBuffer.append(getDecodeNVLQueryFormat("result_num_dec",
				"normal_high"));
		queryBuffer.append(" critical_low, ");
		queryBuffer.append(" critical_high, ");
		queryBuffer.append(" normalcy_ind norm_abnorm_ind, ");
		queryBuffer.append("  b.long_desc child_desc, ");
		queryBuffer.append("  hist_data_type result_desc, ");
		queryBuffer.append("  a.practitioner_id practitioner_id, ");
		queryBuffer.append("  a.performed_by_id reporting_practitioner, ");
		// queryBuffer.append("  a.contr_sys_id contr_sys_id, ");
		queryBuffer.append("  a.accession_num accession_num, ");
		// queryBuffer.append("  a.contr_sys_event_code contr_sys_event_code, ");
		queryBuffer.append("  a.status status, ");
		queryBuffer.append("  a.normalcy_str normalcy_str, ");
		queryBuffer.append("  a.num_data_yn num_data_yn, ");
		queryBuffer.append("  a.contr_sys_id contr_sys_id ");
		// From Clause
		queryBuffer.append(" FROM cr_encounter_detail a, ");
		queryBuffer.append(" cr_cln_evt_mst_lang_vw b, ");
		queryBuffer.append(" cr_cln_evt_grp_lang_vw c, ");
		queryBuffer.append(" cr_encounter_detail_txt d ");

		// Where Clause
		queryBuffer.append(" WHERE b.hist_rec_type = a.hist_rec_type ");
		queryBuffer.append(" AND b.event_code = a.event_code ");
		queryBuffer.append(" AND a.event_code_type = b.event_code_type ");
		queryBuffer.append(" AND a.hist_rec_type = d.hist_rec_type(+) ");
		queryBuffer.append(" AND a.contr_sys_id = d.contr_sys_id(+) ");
		queryBuffer.append(" AND a.accession_num = d.accession_num(+) ");
		queryBuffer
				.append(" AND a.contr_sys_event_code = d.contr_sys_event_code(+) ");
		queryBuffer.append(" AND c.hist_rec_type(+) = a.hist_rec_type ");
		queryBuffer.append(" AND c.event_group(+) = a.event_group ");
		queryBuffer.append(" AND c.event_group_type(+) = a.event_group_type ");
		queryBuffer
				.append(" AND SUBSTR (request_num, INSTR (request_num, '#') + 1, 15) IN ( ");
		queryBuffer
				.append(" SELECT accession_num FROM or_order_line WHERE order_id = (?) ");
		queryBuffer.append(" and accession_num IS NOT NULL "); /*
																 * and rownum
																 * <=1
																 */
		queryBuffer.append(") ");
		queryBuffer.append(" AND patient_id = (?) ");
		queryBuffer
				.append(" AND 'A' = DECODE (protection_ind,  'Z', get_task_applicability ('VIEW_CONF_RESULT', '', 'CA', 'ASSISTING DI'), 'A' ) ");
		queryBuffer.append(" AND NVL (a.status, '#') != 'S' ");
		queryBuffer.append(" AND b.language_id = ? ");
		queryBuffer.append(" AND c.language_id(+) = ? ");
		queryBuffer
				.append(" ORDER BY a.event_group, a.event_code, a.event_date DESC ");
		return queryBuffer.toString();
	}

	/**
	 * This method is used by method getSQLQueryForTestReport
	 * 
	 * @param colName_desc
	 * @param colName
	 * @return
	 */
	public static String getDecodeNVLQueryFormat(String colName_desc,
			String colName) {
		StringBuffer queryBuffer = new StringBuffer();
		// queryBuffer.append(" DECODE (NVL (result_num_dec, '0'), ");
		queryBuffer.append(" DECODE (NVL (" + colName_desc + ", '0'), ");
		queryBuffer.append("  '0', TO_CHAR (" + colName + "), ");
		// queryBuffer.append(" TO_CHAR (result_num, ");
		queryBuffer.append(" TO_CHAR ( " + colName + ", ");
		queryBuffer.append(" DECODE (result_num_dec, ");
		queryBuffer.append(" 1, '999999990.0', ");
		queryBuffer.append(" 2, '999999990.90', ");
		queryBuffer.append(" 3, '999999990.900', ");
		queryBuffer.append(" 4, '999999990.9000', ");
		queryBuffer.append(" 5, '999999990.90000', ");
		queryBuffer.append(" 6, '999999990.900000', ");
		queryBuffer.append(" 7, '999999990.9000000', ");
		queryBuffer.append(" 8, '999999990.90000000', ");
		queryBuffer.append(" 9, '999999990.90000000' ");
		queryBuffer.append("       ) ");
		queryBuffer.append(" ) ");
		// queryBuffer.append(" ) result_num, " );
		queryBuffer.append(" ) " + colName + ", ");
		return queryBuffer.toString();
	}

	/**
	 * This method sets the response with request content
	 * 
	 * @param request
	 */
	private void setResponseWithRequest(TestReportRequest request) {
		response.setOrder(request.getOrder());
		response.setOrderNo(request.getOrderId());
		response.setResultType(request.getResultType());
	}

	/**
	 * @param response
	 *            the response to set
	 */
	public void setResponse(TestReportResponse response) {
		this.response = response;
		// This is added as the list was not resetting
		// we are adding to the existing list in DAC method
		//this.response.setReportList(new ArrayList<Report>());
	}

}
