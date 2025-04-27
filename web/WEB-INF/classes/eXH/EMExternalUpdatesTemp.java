/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXH;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webbeans.eCommon.ConnectionManager;

public class EMExternalUpdatesTemp extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
		doPost(request, response);
	}
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    { 
		try
		{
			HttpSession session = request.getSession(false);

			if(session != null) {
			}
			String queryString = "";

			Enumeration<String> parameterNames = request.getParameterNames();
			while(parameterNames.hasMoreElements()) 
			{
				String paramName = parameterNames.nextElement();
				String paramValue = XHDBAdapter.checkNull(request.getParameter(paramName));
				queryString += paramName + " = " + paramValue;
			}
			
		//	String statusMessage = saveExternalAppCallDtls(reqParams, locale);
			PrintWriter responseWriter = response.getWriter();
			responseWriter.write(queryString);
			responseWriter.flush();
			responseWriter.close();
		}
		catch (Exception exp) {
			exp.printStackTrace(System.err);
		}
    }
	private String saveExternalAppCallDtls(Map<String, String> reqParams, String locale) {
		Connection dbConn = null;
		PreparedStatement pstmt = null;

		String statusMessage = null;
		String qry = "INSERT INTO xh_external_app_simulator (PATIENT_ID, ENCOUNTER_ID, ORDER_ID, ENCOUNTER_DATE, DOCUMENT_TYPE, ENCOUNTER_STATUS, LOCATION_CODE, LOCATION_TYPE, SPECIMEN_NO, FACILITY_ID)"
						+ " VALUES "
						+ "(?,?,?,?,?,?,?,?,?,?)";
		try
		{
			dbConn = ConnectionManager.getConnection();
			
			if("INTERFACE_SIM".equals(reqParams.get("callFrom"))) {
				pstmt = dbConn.prepareStatement(qry);
				pstmt.setString(1, reqParams.get("P_PATIENT_ID"));
				pstmt.setString(2, reqParams.get("P_EPISODE_ID"));
				pstmt.setString(3, reqParams.get("P_ORDER_ID"));
				pstmt.setTimestamp(4, convertStrToTimestamp(reqParams.get("P_ENCNTR_DATE"), reqParams.get("callFrom")));
				pstmt.setString(5, reqParams.get("P_DOC_TYPE"));
				pstmt.setString(6, reqParams.get("P_ENC_STATUS"));
				pstmt.setString(7, reqParams.get("P_LOCN_CODE"));
				pstmt.setString(8, reqParams.get("P_LOCN_TYPE"));
				pstmt.setString(9, reqParams.get("P_SPECIMEN_NO"));
				pstmt.setString(10, reqParams.get("P_FACILITY_ID"));
			}
			else {
				qry = "UPDATE xh_external_app_simulator SET DOCUMENT_ID = ?, SUB_DOCUMENT_TYPE = ?, DOC_CREATION_DATE = ?, DOC_FILE_NAME = ? WHERE PATIENT_ID = ? AND ENCOUNTER_ID = ? AND ORDER_ID = ? AND FACILITY_ID = ?";
				
				pstmt = dbConn.prepareStatement(qry);
				pstmt.setString(1, reqParams.get("documentID"));
				pstmt.setString(2, reqParams.get("subDocumentType"));
				pstmt.setTimestamp(3, convertStrToTimestamp(reqParams.get("docCreationDate"), reqParams.get("callFrom")));
				pstmt.setString(4, reqParams.get("fileName"));
				pstmt.setString(5, reqParams.get("patientID"));
				pstmt.setString(6, reqParams.get("encounterID"));
				pstmt.setString(7, reqParams.get("orderID"));
				pstmt.setString(8, reqParams.get("facilityID"));
			}

			int result = pstmt.executeUpdate();

			if(result > 0) {
				dbConn.commit();
				statusMessage = "success";
			}
			else {
				dbConn.rollback();
				statusMessage = XHUtil.getMessage("1", locale);
			}
		}
		catch (Exception exp) {
			System.out.println("(ExternalApplicationSimulator:saveExternalAppCallDtls) Exception - " + exp.getMessage());
			exp.printStackTrace(System.err);
			if(exp.getMessage().contains("ORA-00001")) statusMessage = XHUtil.getLocaleMessage(locale, "RECORD_ALREADY_EXISTS", "eCommon"); // Unique constraint
			else statusMessage = XHUtil.getMessage("1", locale);
		}
		finally {
			XHUtil.closeDBResources(null, pstmt, dbConn);
		}
		return statusMessage;
	}
	
	public static Timestamp convertStrToTimestamp(String date, String callFrom) throws Exception
	{
		String format = "yyyyMMddhhmmss";
		if("INTERFACE_SIM".equals(callFrom)) {
			format = "dd/MM/yyyy hh:mm";
		}
		System.out.println("date "+date);
		date = XHUtil.convertDateFormat(date, format, "yyyy-MM-dd hh:mm:ss.SSS");
		System.out.println("date "+date);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
		java.util.Date parsedDate = dateFormat.parse(date);
		java.sql.Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
		return timestamp;
	}
}
