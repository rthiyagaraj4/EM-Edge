/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXH;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Properties;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import webbeans.eCommon.*;

public class DMSSimulatorServlet extends HttpServlet
{
	/**
	 * 
	 */

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
		doPost(request, response);
	}
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    { 
		HttpSession session = request.getSession(false);

		String locale = ((Properties) session.getAttribute("jdbc")).getProperty("LOCALE");
		String requestType = request.getParameter("requestType");
		Map<String, String> requestParams = XHUtil.getRequestParams(request);

		System.out.println("requestType " + requestType);
		System.out.println("session " + session);
		System.out.println("locale " + locale);

		if("COUNTER_INFO".equals(requestType))
		{
			String documentID = requestParams.get("documentID");
			String patientID = requestParams.get("patientID");
			String encounterID = requestParams.get("encounterID");
			String orderID = requestParams.get("orderID");
			request.setAttribute("documentInfo", getDocumentInfo(documentID, patientID, encounterID, locale, orderID));
			request.setAttribute("mode", "U");
			request.getRequestDispatcher("/eXH/jsp/QMSRDCounterSetup.jsp").forward(request, response);
		}
		else if("SAVE".equals(requestType))
		{
			List<String> auditInfo = ArrayAuditInfo.getArrayAuditInfo(session);
			String statusMessage = saveCounterInfo(requestParams, locale, auditInfo);
			request.setAttribute("statusMessage", statusMessage);
			request.getRequestDispatcher("/eXH/jsp/QMSRDCounterSetupDispResult.jsp?stMessage="+statusMessage).forward(request, response);
		}
		else if("CREATE".equals(requestType))
		{
			request.getRequestDispatcher("/eXH/jsp/Test.jsp").forward(request, response);
		}
		else if("QUERY".equals(requestType))
		{
			request.setAttribute("documents", getDocumentList(request, session, locale));
			request.getRequestDispatcher("/eXH/jsp/DMSSimulatorQueryResult.jsp").forward(request, response);
		}
		else if("MAIN".equals(requestType))
		{
			request.getRequestDispatcher("/eXH/jsp/QMSRDCounterSetupMain.jsp").forward(request, response);
		}
    }

	private List<List<String>> getDocumentList(HttpServletRequest request, HttpSession session, String locale)
	{
		Connection dbConn = null;
		
		List<List<String>> documentList = null;
		
		try
		{
			dbConn = ConnectionManager.getConnection(request);
			String documentID = request.getParameter("documentID");
			String patientID = request.getParameter("patientID");
			String encounterID = request.getParameter("encounterID");
			String query = "SELECT nvl(document_id,''), patient_id, ENCOUNTER_ID, DOCUMENT_TYPE, DOC_FILE_NAME FROM XH_EXTERNAL_APP_SIMULATOR";
			String whrClause = "";
			boolean isWhrClauseExists = false;
			
			if(documentID != null && !documentID.equals("")) {
				whrClause += "document_id = '" + documentID + "'";
				isWhrClauseExists = true;
			}
			
			if(patientID != null && !patientID.equals("")) {
				if(isWhrClauseExists) whrClause += " AND ";
				whrClause += "patient_id = '" + patientID + "'";
			}
			
			if(encounterID != null && !encounterID.equals("")) {
				if(isWhrClauseExists) whrClause += " AND ";
				whrClause += "encounter_id = '" + encounterID + "'";
			}
			
			if(whrClause.length() > 0) query += " AND " + whrClause;
			
			request.setAttribute(XHQueryRender.strQueryId, "DMS_SIMULATOR_DISP");
			request.setAttribute("query", query);
			request.setAttribute(XHQueryRender.col, "5");
			request.setAttribute(XHQueryRender.maxRec, "15");
			request.setAttribute("documentID", XHDBAdapter.checkNull(documentID));
			request.setAttribute("patientID", XHDBAdapter.checkNull(patientID));
			request.setAttribute("encounterID", XHDBAdapter.checkNull(encounterID));
			request.setAttribute("locale", XHDBAdapter.checkNull(locale));
			
			HashMap resultsQry = XHQueryRender.getResults(request, session, dbConn);

			documentList = (ArrayList)resultsQry.get("qry_result");
			String previous = ((Boolean)resultsQry.get("previous")) == true ? "Previous" : "";
			String next = ((Boolean)resultsQry.get("next")) == true ? "Next" : "";

			request.setAttribute("previousPage", previous);
			request.setAttribute("nextPage", next);
			System.out.println("documentList "+documentList);
			XHUtil.addGUIRowClassName(documentList);
			System.out.println("documentList "+documentList);
		}
		catch (Exception exp) {
			System.out.println("(DMSSimulatorServlet:getDocumentList) Exception - " + exp.getMessage());
			exp.printStackTrace(System.err);
		}
		finally {
			XHUtil.closeDBResources(null, null, dbConn);
		}
		return documentList;
	}

	private Map<String, String> getDocumentInfo(String documentID, String patientID, String encounterID, String locale, String orderID)
	{
		Connection dbConn = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		
		Map<String, String> documentInfo = new HashMap<String, String>();
		String qry = "SELECT PATIENT_ID, ENCOUNTER_ID, ORDER_ID, to_char(ENCOUNTER_DATE, 'dd/mm/yyyy HH24:MM:SS'), DOCUMENT_ID, DOCUMENT_TYPE, SUB_DOCUMENT_TYPE, DOC_CREATION_DATE, DOC_FILE_NAME, ENCOUNTER_STATUS, LOCATION_CODE, LOCATION_TYPE, SPECIMEN_NO, USERNAME, FACILITY_ID FROM XH_EXTERNAL_APP_SIMULATOR WHERE PATIENT_ID = ? AND ENCOUNTER_ID = ? AND DOCUMENT_ID = ? AND order_id = ?";
		try
		{
			dbConn = ConnectionManager.getConnection();
			pstmt = dbConn.prepareStatement(qry);
			pstmt.setString(1, patientID);
			pstmt.setString(2, encounterID);
			pstmt.setString(3, documentID);
			pstmt.setString(4, orderID);

			resultSet = pstmt.executeQuery();

			String logStr = "patientID ["+ patientID +"] encounterID ["+ encounterID +"] documentID ["+ documentID + "] locale ["+ locale +"] orderID ["+ orderID + "]";
			System.out.println(logStr);

			if(resultSet.next())
			{
				documentInfo.put("patientID", patientID);
				documentInfo.put("encounterID", resultSet.getString("ENCOUNTER_ID"));
				documentInfo.put("orderID", resultSet.getString("ORDER_ID"));
				documentInfo.put("encounterDate", resultSet.getString("ENCOUNTER_DATE"));
				documentInfo.put("documentID", resultSet.getString("DOCUMENT_ID"));
				documentInfo.put("documentType", resultSet.getString("DOCUMENT_TYPE"));
				documentInfo.put("encounterStatus", resultSet.getString("ENCOUNTER_STATUS"));
				documentInfo.put("locationCode", resultSet.getString("LOCATION_CODE"));
				documentInfo.put("locationType", resultSet.getString("LOCATION_TYPE"));
				documentInfo.put("specimenNo", resultSet.getString("SPECIMEN_NO"));
				documentInfo.put("facilityID", resultSet.getString("FACILITY_ID"));
			}
			System.out.println("documentInfo "+documentInfo);
		}
		catch (Exception exp) {
			System.out.println("(DMSSimulatorServlet:getDocumentInfo) Exception - " + exp.getMessage());
			System.out.println("(DMSSimulatorServlet:getDocumentInfo) Patient ID - " + patientID);
			System.out.println("(DMSSimulatorServlet:getDocumentInfo) Document ID - " + documentID);
			System.out.println("(DMSSimulatorServlet:getDocumentInfo) Doc ID - " + documentID);
			exp.printStackTrace(System.err);
		}
		finally {
			XHUtil.closeDBResources(resultSet, pstmt, dbConn);
		}
		return documentInfo;
	}

	private String saveCounterInfo(Map<String, String> requestParams, String locale, List<String> auditInfo)
	{
		Connection dbConn = null;
		PreparedStatement pstmt = null;

		String statusMessage = null;
		java.sql.Timestamp currentDate = null;
		String qry = "INSERT INTO xh_rd_servicecounter (counter_name, service_no, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id, section_code, study_location, facility_id, patient_type, added_by_id, added_date, added_at_ws_no, added_facility_id)"
						+ " VALUES "
						+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try
		{
			currentDate = new java.sql.Timestamp(System.currentTimeMillis());

			if("U".equals(requestParams.get("mode")))
			{
				qry = "UPDATE xh_rd_servicecounter SET counter_name = ?, service_no = ?, modified_by_id = ?, modified_date = ?, modified_at_ws_no = ?, modified_facility_id = ? WHERE section_code = ? AND study_location = ? AND facility_id = ?, patient_type = ?";
			}
			dbConn = ConnectionManager.getConnection();
			pstmt = dbConn.prepareStatement(qry);

			pstmt.setString(1, requestParams.get("counterName"));
			pstmt.setString(2, requestParams.get("serviceNo"));
			pstmt.setString(3, auditInfo.get(0));
			pstmt.setTimestamp(4, currentDate);
			pstmt.setString(5, auditInfo.get(1));
			pstmt.setString(6, auditInfo.get(2));
			pstmt.setString(7, requestParams.get("sectionCode"));
			pstmt.setString(8, requestParams.get("studyLocation"));
			pstmt.setString(9, requestParams.get("facilityID"));
			pstmt.setString(10, requestParams.get("patientType"));

			if(!"U".equals(requestParams.get("mode")))
			{
				pstmt.setString(11, auditInfo.get(0));
				pstmt.setTimestamp(12, currentDate);
				pstmt.setString(13, auditInfo.get(1));
				pstmt.setString(14, auditInfo.get(2));
			}

			int result = pstmt.executeUpdate();

			if(result > 0) 
			{
				dbConn.commit();
				statusMessage = XHUtil.getMessage("0", locale);
			}
			else 
			{
				dbConn.rollback();
				statusMessage = XHUtil.getMessage("1", locale);
			}
		}
		catch (Exception exp)
		{
			System.out.println("(QMSRDCounterSetupServlet:saveNewRecipient) Exception - " + exp.getMessage());
			exp.printStackTrace(System.err);
			if(exp.getMessage().contains("ORA-00001")) statusMessage = XHUtil.getLocaleMessage(locale, "RECORD_ALREADY_EXISTS", "eCommon"); // Unique constraint
			else statusMessage = XHUtil.getMessage("1", locale);
		}
		finally
		{
			XHUtil.closeDBResources(null, pstmt, dbConn);
		}

		return statusMessage;
	}

	private String deleteCounterInfo(String sectionCode, String studyLocation, String facilityID, String locale)
	{
		Connection dbConn = null;
		PreparedStatement pstmt = null;

		String statusMessage = null;
		String qry = "DELETE xh_rd_servicecounter WHERE section_code = ? AND study_location = ? AND facility_id = ?";
		try
		{
			dbConn = ConnectionManager.getConnection();
			pstmt = dbConn.prepareStatement(qry);
			pstmt.setString(1, sectionCode);
			pstmt.setString(2, studyLocation);
			pstmt.setString(3, facilityID);

			int result = pstmt.executeUpdate();

			if(result > 0) 
			{
				dbConn.commit();
				statusMessage = XHUtil.getMessage("0", locale);
			}
			else 
			{
				dbConn.rollback();
				statusMessage = XHUtil.getMessage("1", locale);
			}
		}
		catch (Exception exp)
		{
			System.out.println("(QMSRDCounterSetupServlet:deleteCounter) Exception - " + exp.getMessage());
			exp.printStackTrace(System.err);
			statusMessage = XHUtil.getMessage("1", locale);
		}
		finally
		{
			XHUtil.closeDBResources(null, pstmt, dbConn);
		}

		return statusMessage;
	}
}
