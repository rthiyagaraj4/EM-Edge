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

public class QMSRDCounterSetupServlet extends HttpServlet
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

		System.out.println("requestType " + requestType);
		System.out.println("session " + session);
		System.out.println("locale " + locale);

		if("COUNTER_INFO".equals(requestType))
		{
			String sectionCode = request.getParameter("sectionCode");
			String studyLocation = request.getParameter("studyLocation");
			String facilityID = request.getParameter("facilityID");
			request.setAttribute("counterInfo", getCounterInfo(sectionCode, studyLocation, facilityID, locale));
			request.setAttribute("mode", "U");
			request.getRequestDispatcher("/eXH/jsp/QMSRDCounterSetup.jsp").forward(request, response);
		}
		else if("SAVE".equals(requestType))
		{
			List<String> auditInfo = ArrayAuditInfo.getArrayAuditInfo(session);
			String statusMessage = saveCounterInfo(XHUtil.getRequestParams(request), locale, auditInfo);
			request.setAttribute("statusMessage", statusMessage);
			request.getRequestDispatcher("/eXH/jsp/QMSRDCounterSetupDispResult.jsp?stMessage="+statusMessage).forward(request, response);
		}
		else if("DELETE".equals(requestType))
		{
			String sectionCode = request.getParameter("sectionCode");
			String studyLocation = request.getParameter("studyLocation");
			String facilityID = request.getParameter("facilityID");
			String statusMessage = deleteCounterInfo(sectionCode, studyLocation, facilityID, locale);
			request.setAttribute("statusMessage", statusMessage);
			request.getRequestDispatcher("/eXH/jsp/QMSRDCounterSetupDispResult.jsp?stMessage="+statusMessage).forward(request, response);
		}
		else if("CREATE".equals(requestType))
		{
			request.getRequestDispatcher("/eXH/jsp/QMSRDCounterSetup.jsp").forward(request, response);
		}
		else if("QUERY".equals(requestType))
		{
			request.setAttribute("counters", getCounterList(request, session, locale));
			request.getRequestDispatcher("/eXH/jsp/QMSRDCounterSetupQueryResult.jsp").forward(request, response);
		}
		else if("MAIN".equals(requestType))
		{
			request.getRequestDispatcher("/eXH/jsp/QMSRDCounterSetupMain.jsp").forward(request, response);
		}
    }

	private List<List<String>> getCounterList(HttpServletRequest request, HttpSession session, String locale)
	{
		Connection dbConn = null;
		
		List<List<String>> counterList = null;
		
		try
		{
			dbConn = ConnectionManager.getConnection(request);
			String sectionCode = request.getParameter("sectionCode");
			String studyLocation = request.getParameter("studyLocation");
			String facilityID = request.getParameter("facilityID");
			
			request.setAttribute(XHQueryRender.strQueryId, "QMS_RD_COUNTER_SETUP");
			request.setAttribute(XHQueryRender.col, "8");
			request.setAttribute(XHQueryRender.maxRec, "10");
			request.setAttribute("sectionCode", XHDBAdapter.checkNull(sectionCode));
			request.setAttribute("studyLocation", XHDBAdapter.checkNull(studyLocation));
			request.setAttribute("facilityID", XHDBAdapter.checkNull(facilityID));
			request.setAttribute("locale", XHDBAdapter.checkNull(locale));
			
			HashMap resultsQry = XHQueryRender.getResults(request, session, dbConn);

			counterList = (ArrayList)resultsQry.get("qry_result");
			String previous = ((Boolean)resultsQry.get("previous")) == true ? "Previous" : "";
			String next = ((Boolean)resultsQry.get("next")) == true ? "Next" : "";

			request.setAttribute("previousPage", previous);
			request.setAttribute("nextPage", next);

			XHUtil.addGUIRowClassName(counterList);
			System.out.println("counterList "+counterList);
		}
		catch (Exception exp)
		{
			System.out.println("(QMSRDCounterSetupServlet:getCounterList) Exception - " + exp.getMessage());
			exp.printStackTrace(System.err);
		}
		finally
		{
			XHUtil.closeDBResources(null, null, dbConn);
		}
		return counterList;
	}

	private Map<String, String> getCounterInfo(String sectionCode, String studyLocation, String facilityID, String locale)
	{
		Connection dbConn = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		
		Map<String, String> counterInfo = new HashMap<String, String>();
		String qry = "SELECT x.section_code, rds.short_desc sec_desc, counter_name, service_no, study_location, rdc.short_desc study_loc_desc, x.facility_id, facility_name FROM xh_rd_servicecounter x, sm_facility_param s, rd_section_lang_vw rds, rd_clinic_lang_vw rdc WHERE x.section_code = ? AND x.study_location = ? AND x.facility_id = ? AND x.section_code = rds.section_code AND rds.language_id = ? AND x.study_location = rdc.clinic_code AND rdc.language_id = ? AND x.facility_id = s.facility_id";
		try
		{
			dbConn = ConnectionManager.getConnection();
			pstmt = dbConn.prepareStatement(qry);
			pstmt.setString(1, sectionCode);
			pstmt.setString(2, studyLocation);
			pstmt.setString(3, facilityID);
			pstmt.setString(4, locale);
			pstmt.setString(5, locale);
			resultSet = pstmt.executeQuery();

			System.out.println("sectioncode "+ sectionCode);
			System.out.println("studyLocation "+ studyLocation);
			System.out.println("facilityID "+ facilityID);
			System.out.println("locale "+ locale);

			if(resultSet.next())
			{
				counterInfo.put("sectionCode", sectionCode);
				counterInfo.put("sectionDesc", resultSet.getString("sec_desc"));
				counterInfo.put("counterName", resultSet.getString("counter_name"));
				counterInfo.put("serviceNo", resultSet.getString("service_no"));
				counterInfo.put("studyLocation", resultSet.getString("study_location"));
				counterInfo.put("studyLocationDesc", resultSet.getString("study_loc_desc"));
				counterInfo.put("facilityID", resultSet.getString("facility_id"));
				counterInfo.put("facilityName", resultSet.getString("facility_name"));
			}
			System.out.println("counterInfo "+counterInfo);
		}
		catch (Exception exp)
		{
			System.out.println("(QMSRDCounterSetupServlet:getCounterInfo) Exception - " + exp.getMessage());
			System.out.println("(QMSRDCounterSetupServlet:getCounterInfo) Section Code - " + sectionCode);
			System.out.println("(QMSRDCounterSetupServlet:getCounterInfo) Study Location - " + studyLocation);
			exp.printStackTrace(System.err);
		}
		finally
		{
			XHUtil.closeDBResources(resultSet, pstmt, dbConn);
		}
		return counterInfo;
	}

	private String saveCounterInfo(Map<String, String> requestParams, String locale, List<String> auditInfo)
	{
		Connection dbConn = null;
		PreparedStatement pstmt = null;

		String statusMessage = null;
		java.sql.Timestamp currentDate = null;
		String qry = "INSERT INTO xh_rd_servicecounter (counter_name, service_no, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id, section_code, study_location, facility_id, added_by_id, added_date, added_at_ws_no, added_facility_id)"
						+ " VALUES "
						+ "(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try
		{
			currentDate = new java.sql.Timestamp(System.currentTimeMillis());

			if("U".equals(requestParams.get("mode")))
			{
				qry = "UPDATE xh_rd_servicecounter SET counter_name = ?, service_no = ?, modified_by_id = ?, modified_date = ?, modified_at_ws_no = ?, modified_facility_id = ? WHERE section_code = ? AND study_location = ? AND facility_id = ?";
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

			if(!"U".equals(requestParams.get("mode")))
			{
				pstmt.setString(10, auditInfo.get(0));
				pstmt.setTimestamp(11, currentDate);
				pstmt.setString(12, auditInfo.get(1));
				pstmt.setString(13, auditInfo.get(2));
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
