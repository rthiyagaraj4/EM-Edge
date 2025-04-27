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

public class NotificationTypeSetupServlet extends HttpServlet
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

		if("NOTIFICATION_TYPE_INFO".equals(requestType))
		{
			String typeCode = request.getParameter("typeCode");
			request.setAttribute("notificationTypeInfo", getNotificationTypeInfo(typeCode));
			request.setAttribute("mode", "U");
			request.getRequestDispatcher("/eXH/jsp/NotificationTypeSetup.jsp").forward(request, response);
		}
		else if("SAVE".equals(requestType))
		{
			String statusMessage = saveNotificationTypeInfo(XHUtil.getRequestParams(request), locale);
			request.setAttribute("statusMessage", statusMessage);
			request.getRequestDispatcher("/eXH/jsp/NotificationTypeSetupDispResult.jsp?stMessage="+statusMessage).forward(request, response);
		}
		else if("DELETE".equals(requestType))
		{
			String typeCode = request.getParameter("typeCode");
			String statusMessage = deleteNotificationType(typeCode, locale);
			request.setAttribute("statusMessage", statusMessage);
			request.getRequestDispatcher("/eXH/jsp/NotificationTypeSetupDispResult.jsp?stMessage="+statusMessage).forward(request, response);
		}
		else if("CREATE".equals(requestType))
		{
			request.getRequestDispatcher("/eXH/jsp/NotificationTypeSetup.jsp").forward(request, response);
		}
		else if("QUERY".equals(requestType))
		{
			request.setAttribute("notificationTypes", getNotificationTypeList(request, session));
			request.getRequestDispatcher("/eXH/jsp/NotificationTypeSetupQueryResult.jsp").forward(request, response);
		}
		else if("MAIN".equals(requestType))
		{
			request.getRequestDispatcher("/eXH/jsp/NotificationTypeSetupMain.jsp").forward(request, response);
		}
    }

	private List<List<String>> getNotificationTypeList(HttpServletRequest request, HttpSession session)
	{
		Connection dbConn = null;
		
		List<List<String>> notificationTypeList = null;
		
		try
		{
			dbConn = ConnectionManager.getConnection(request);
			String typeCode = request.getParameter("typeCode");
			String shortDesc = request.getParameter("shortDesc");
			
			request.setAttribute(XHQueryRender.strQueryId, "NOTIFICATION_TYPE_SETUP");
			request.setAttribute(XHQueryRender.col, "4");
			request.setAttribute(XHQueryRender.maxRec, "10");
			request.setAttribute("typeCode", XHDBAdapter.checkNull(typeCode));
			request.setAttribute("shortDesc", XHDBAdapter.checkNull(shortDesc));
			
			HashMap resultsQry = XHQueryRender.getResults(request, session, dbConn);

			notificationTypeList = (ArrayList)resultsQry.get("qry_result");
			String previous = ((Boolean)resultsQry.get("previous")) == true ? "Previous" : "";
			String next = ((Boolean)resultsQry.get("next")) == true ? "Next" : "";

			request.setAttribute("previousPage", previous);
			request.setAttribute("nextPage", next);

			XHUtil.addGUIRowClassName(notificationTypeList);
			System.out.println("notificationTypeList "+notificationTypeList);
		}
		catch (Exception exp)
		{
			System.out.println("(NotificationTypeSetupServlet:getNotificationTypeList) Exception - " + exp.getMessage());
			exp.printStackTrace(System.err);
		}
		finally
		{
			XHUtil.closeDBResources(null, null, dbConn);
		}
		return notificationTypeList;
	}

	private Map<String, String> getNotificationTypeInfo(String typeCode)
	{
		Connection dbConn = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		
		Map<String, String> notificationTypeInfo = new HashMap<String, String>();
		String qry = "SELECT type_class, type_code, short_desc, eff_status FROM xm_notification_type_code WHERE type_code = ?";
		try
		{
			dbConn = ConnectionManager.getConnection();
			pstmt = dbConn.prepareStatement(qry);
			pstmt.setString(1, typeCode);
			resultSet = pstmt.executeQuery();

			if(resultSet.next())
			{
				notificationTypeInfo.put("typeCode", typeCode);
				notificationTypeInfo.put("typeClass", resultSet.getString("type_class"));
				notificationTypeInfo.put("shortDesc", resultSet.getString("short_desc"));
				notificationTypeInfo.put("effStatus", resultSet.getString("eff_status").equals("E") ? "CHECKED":"");
			}
			System.out.println("notificationTypeInfo "+notificationTypeInfo);
		}
		catch (Exception exp)
		{
			System.out.println("(NotificationTypeSetupServlet:getNotificationTypeInfo) Exception - " + exp.getMessage());
			System.out.println("(NotificationTypeSetupServlet:getNotificationTypeInfo) Type Code - " + typeCode);
			exp.printStackTrace(System.err);
		}
		finally
		{
			XHUtil.closeDBResources(resultSet, pstmt, dbConn);
		}
		return notificationTypeInfo;
	}

	private String saveNotificationTypeInfo(Map<String, String> requestParams, String locale)
	{
		Connection dbConn = null;
		PreparedStatement pstmt = null;

		String statusMessage = null;
		String qry = "INSERT INTO xm_notification_type_code (short_desc, eff_status, type_class, type_code)"
						+ " VALUES "
						+ "(?,?,?,?)";
		try
		{
			if("U".equals(requestParams.get("mode")))
			{
				qry = "UPDATE xm_notification_type_code SET short_desc = ?, eff_status = ?, type_class = ? WHERE type_code = ?";
			}
			dbConn = ConnectionManager.getConnection();
			pstmt = dbConn.prepareStatement(qry);

			pstmt.setString(1, requestParams.get("shortDesc"));
			pstmt.setString(2, requestParams.get("effStatus"));
			pstmt.setString(3, requestParams.get("typeClass"));
			pstmt.setString(4, requestParams.get("typeCode"));

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
			System.out.println("(NotificationTypeSetupServlet:saveNotificationTypeInfo) Exception - " + exp.getMessage());
			System.out.println("(NotificationTypeSetupServlet:saveNotificationTypeInfo) requestParams - " + requestParams);
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

	private String deleteNotificationType(String typeCode, String locale)
	{
		Connection dbConn = null;
		PreparedStatement pstmt = null;

		String statusMessage = null;
		String qry = "DELETE xm_notification_type_code WHERE type_code = ?";
		try
		{
			dbConn = ConnectionManager.getConnection();
			pstmt = dbConn.prepareStatement(qry);
			pstmt.setString(1, typeCode);

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
			System.out.println("(NotificationTypeSetupServlet:deleteNotificationType) Exception - " + exp.getMessage());
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
