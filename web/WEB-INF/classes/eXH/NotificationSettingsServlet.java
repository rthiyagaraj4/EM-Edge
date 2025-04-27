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
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Properties;
import java.util.Collections;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import org.json.simple.JSONValue;
import webbeans.eCommon.*;

public class NotificationSettingsServlet extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
		doPost(request, response);
	}
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    { 
		HttpSession session = request.getSession(false);

		String locale = ((Properties) session.getAttribute("jdbc")).getProperty("LOCALE");
		String requestType = request.getParameter("requestType");

		Properties p = (Properties) session.getAttribute("jdbc");
		String userID = p.getProperty("login_user");
		String userPassword = p.getProperty("login_password");

		System.out.println("requestURI " + request.getRequestURI());
		System.out.println("requestURL " + request.getRequestURL());
		System.out.println("pathInfo " + request.getPathInfo());
		System.out.println("servletPath " + request.getServletPath());
		System.out.println("servletPath " + request.getRealPath("/"));
		System.out.println("contextrealpath " + getServletContext().getRealPath("/"));
		System.out.println("userID " + userID);
		System.out.println("userPassword " + userPassword);
		System.out.println("requestType " + requestType);
		System.out.println("eventType " + request.getParameter("eventType"));
		System.out.println("messageType " + request.getParameter("messageType"));
		System.out.println("session " + session);
		System.out.println("locale " + locale);

		if("SEARCH_CRITERIA".equals(requestType))
		{
			request.setAttribute("messageTypes", getMessageTypes());
			request.setAttribute("eventTypes", getEventTypes(request.getParameter("messageType")));
			session.getServletContext().getRequestDispatcher("/eXH/jsp/NotificationSearchCriteria.jsp").forward(request, response);
		}
		else if("RECIPIENT_LIST".equals(requestType))
		{
			getRecipientList(request, session);
			session.getServletContext().getRequestDispatcher("/eXH/jsp/Notification.jsp").forward(request, response);
		}
		else if("CRITERIA_CHANGE".equals(requestType))
		{
			session.removeAttribute("xhNotificationRecipientDtls");
			getRecipientList(request, session);
			session.getServletContext().getRequestDispatcher("/eXH/jsp/Notification.jsp").forward(request, response);
		}
		else if("SAVE".equals(requestType))
		{
			pageNavigation(request, session, Collections.EMPTY_LIST);
			String statusMessage = saveSettings((Map<String, String>)session.getAttribute("xhNotificationRecipientDtls"), locale);
			request.setAttribute("statusMessage", statusMessage);
			session.getServletContext().getRequestDispatcher("/eXH/jsp/NotificationSettingsDispResult.jsp?stMessage="+statusMessage).forward(request, response);
		}
		else if("GET_EVENTS".equals(requestType))
		{
			String messageType = request.getParameter("messageType");
			String events = getEventsJSON(messageType);

			PrintWriter responseWriter = response.getWriter();
			responseWriter.write(events);
			responseWriter.flush();
			responseWriter.close();
		}
    }

	public String saveSettings(Map<String, String> requestParams, String locale)
	{
		Connection dbConn = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;

		String statusMessage = null;
		String qry = "UPDATE xm_event_notify_recipients SET eff_status = ?, em_contact_mode = ?, language_id = ?, template_id = ? WHERE event_type = ? and RECEIPIENT_TYPE = ? and RECEIPIENT_DEPENDENCY = ? and contact_mode = ?";
		try
		{
			dbConn = ConnectionManager.getConnection();
			pstmt = dbConn.prepareStatement(qry);

			for(Map.Entry<String, String> param : requestParams.entrySet())
			{
				String key = param.getKey();

				if(key.endsWith("-RCPT_STATUS"))
				{
					String keyCommonAttr = key.substring(0, key.indexOf("-RCPT_STATUS")); // Primary key combination
					String[] keyElements = key.split("-");
					System.out.println("PSTMT Values " + param.getValue() + " " + keyElements[0] + " " + keyElements[1] + " " + keyElements[2] + " " + keyElements[3]);
					pstmt.setString(1, param.getValue());
					pstmt.setString(2, requestParams.get(keyCommonAttr + "-RCPT_CONTACT_MODE"));
					pstmt.setString(3, requestParams.get(keyCommonAttr + "-NOTIF_LANG"));
					pstmt.setString(4, requestParams.get(keyCommonAttr + "-TEMPLATE_ID"));
					pstmt.setString(5, keyElements[0]);
					pstmt.setString(6, keyElements[1]);
					pstmt.setString(7, keyElements[2]);
					pstmt.setString(8, keyElements[3]);
					pstmt.addBatch();
				}
			}
			int [] result = pstmt.executeBatch();
			boolean status = true;

			for(int i : result)
			{
				if(i == Statement.EXECUTE_FAILED)
				{
					dbConn.rollback();
					status = false;
				}
				else dbConn.commit();
			}

			System.out.println("STATUS SAVE "+status);

			if(status) statusMessage = XHUtil.getMessage("0", locale);
			else statusMessage = XHUtil.getMessage("1", locale);
		}
		catch (Exception exp)
		{
			System.out.println("(NotificationSettings:getMessageTypes) Exception - " + exp.getMessage());
			exp.printStackTrace(System.err);
		}
		finally
		{
			XHUtil.closeDBResources(resultSet, pstmt, dbConn);
		}

		return statusMessage;
	}

	public List<List<String>> getRecipientList(HttpServletRequest request, HttpSession session)
	{
		Connection dbConn = null;
		
		List<List<String>> recipientsList = Collections.EMPTY_LIST;
		
		String qry = "SELECT a.event_type, receipient_type, receipient_dependency, contact_type, contact_mode, eff_status,"
						+ " a.event_type || '-' || receipient_type || '-' || receipient_dependency || '-' || contact_mode key, template_id, attachment_id, em_contact_mode, event_name, language_id FROM xm_event_notify_recipients a, xh_event_type b where a.event_type = b.event_type";
		try
		{
			dbConn = ConnectionManager.getConnection(request);
			String eventType = request.getParameter("eventType");
			String messageType = request.getParameter("messageType");

			if(eventType != null && !eventType.equals(""))
			{
				qry += " AND a.event_type = '" + eventType + "'";
			}
			else if(messageType != null && !messageType.equals(""))
			{
				qry += " AND a.event_type IN (SELECT event_type FROM xh_event_type WHERE message_type = '" + messageType + "')";
			}

			System.out.println("qry "+qry);
			request.setAttribute(XHQueryRender.strQueryId, "NOTIFICATION_RECIPIENTS");
			request.setAttribute("query", qry);
			request.setAttribute(XHQueryRender.col, "12");
			request.setAttribute(XHQueryRender.maxRec, "15");
			HashMap resultsQry = XHQueryRender.getResults(request, session, dbConn);

			recipientsList = (ArrayList)resultsQry.get("qry_result");
			String previous = ((Boolean)resultsQry.get("previous")) == true ? "Previous" : "";
			String next = ((Boolean)resultsQry.get("next")) == true ? "Next" : "";

			request.setAttribute("previousPage", previous);
			request.setAttribute("nextPage", next);
			request.setAttribute("templateFolder", XHUtil.singleParamExeQry("SELECT template_folder FROM xm_param"));
			request.setAttribute("languages", getSMLanguages(dbConn));

			pageNavigation(request, session, recipientsList);
			XHUtil.addGUIRowClassName(recipientsList);
		}
		catch (Exception exp)
		{
			System.out.println("(FilterRuleSettings:getRawColumnElements) Exception - " + exp.getMessage());
			exp.printStackTrace(System.err);
		}
		finally
		{
			request.setAttribute("recipientList", recipientsList);
			XHUtil.closeDBResources(null, null, dbConn);
		}
		return recipientsList;
	}

	public Map<String, String> getMessageTypes()
	{
		Connection dbConn = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		
		Map<String, String> messageTypes = new LinkedHashMap<String, String>();
		String qry = "SELECT DISTINCT a.message_type, a.description FROM xh_message_type a, xh_event_type b, xm_event_notify_recipients c WHERE a.message_type = b.message_type AND b.event_type = c.event_type ORDER BY a.description";
		try
		{
			dbConn = ConnectionManager.getConnection();
			pstmt = dbConn.prepareStatement(qry);
			resultSet = pstmt.executeQuery();

			messageTypes.put("", "Select");
			while(resultSet.next())
			{
				messageTypes.put(resultSet.getString("message_type"), resultSet.getString("description"));
			}
			System.out.println("messageTypes "+messageTypes);
		}
		catch (Exception exp)
		{
			System.out.println("(NotificationSettings:getMessageTypes) Exception - " + exp.getMessage());
			exp.printStackTrace(System.err);
		}
		finally
		{
			XHUtil.closeDBResources(resultSet, pstmt, dbConn);
		}
		return messageTypes;
	}

	public Map<String, String> getEventTypes(String messageType)
	{
		Connection dbConn = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		
		Map<String, String> eventTypes = new LinkedHashMap<String, String>();
		String qry = "SELECT DISTINCT a.event_type, a.event_type || '-' || a.event_name description FROM xh_event_type a, xm_event_notify_recipients b WHERE a.message_type = '"+ messageType +"' AND a.event_type = b.event_type ORDER BY a.event_type";
		String qryNoMsgType = "SELECT DISTINCT a.event_type, a.event_type || '-' || a.event_name description FROM xh_event_type a, xm_event_notify_recipients b WHERE a.event_type = b.event_type ORDER BY a.event_type";
		try
		{
			System.out.println("messageType"+messageType+"1");
			if(messageType == null || messageType.equals("")) qry = qryNoMsgType;

			dbConn = ConnectionManager.getConnection();
			pstmt = dbConn.prepareStatement(qry);
			resultSet = pstmt.executeQuery();

			eventTypes.put("", "Select");
			while(resultSet.next())
			{
				eventTypes.put(resultSet.getString("event_type"), resultSet.getString("description"));
			}
			System.out.println("eventTypes "+eventTypes);
		}
		catch (Exception exp)
		{
			System.out.println("(NotificationSettings:getMessageTypes) Exception - " + exp.getMessage());
			exp.printStackTrace(System.err);
		}
		finally
		{
			XHUtil.closeDBResources(resultSet, pstmt, dbConn);
		}
		return eventTypes;
	}

	/**
	 * Stores all the request params in session which will used while saving the schedule from front end.
	 * and modifies recipientsList to indicate whether the recipient is currently enabled or not by comparing database values & session values
	 * if called from saveSchedule method recipientList will be empty
	 */
	private void pageNavigation(HttpServletRequest request, HttpSession session, List<List<String>> recipientsList)
	{
		Map<String, String> recipientDetails = (Map<String, String>)session.getAttribute("xhNotificationRecipientDtls");

		if(recipientDetails == null) recipientDetails = XHUtil.getRequestParams(request);
		else recipientDetails.putAll(XHUtil.getRequestParams(request));

		for(List<String> recipient : recipientsList)
		{
			String recipientKey = recipient.get(6) + "-RCPT_STATUS";
			String dbRecipientStatus = recipient.get(5);
			String guiRecipientStatus = recipientDetails.get(recipientKey);
			
			if((guiRecipientStatus == null && "E".equals(dbRecipientStatus)) || "E".equals(guiRecipientStatus))
			{
				recipient.add("CHECKED"); // to make checkbox enabled in GUI by default
			}
			else recipient.add("");

			System.out.println("recipientKey "+recipientKey);
			System.out.println("dbRecipientStatus "+dbRecipientStatus);
			System.out.println("guiRecipientStatus "+guiRecipientStatus);
		}

		System.out.println("recipientDetails "+recipientDetails);
		session.setAttribute("xhNotificationRecipientDtls", recipientDetails); // resetting this session variable in NotificationSettingsMain.jsp
	}

	private String getEventsJSON(String messageType)
	{
		Map<String, String> events = getEventTypes(messageType);
		String eventListJSON = JSONValue.toJSONString(events);
		return eventListJSON;
	}

	private Map<String, String> getSMLanguages(Connection dbConn) throws Exception
	{
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		
		Map<String, String> languages = new LinkedHashMap<String, String>();
		String qry = "SELECT language_id, short_name FROM sm_language_vw ORDER BY short_name";
		try
		{
			pstmt = dbConn.prepareStatement(qry);
			resultSet = pstmt.executeQuery();
			while(resultSet.next())
			{
				languages.put(resultSet.getString("language_id"), resultSet.getString("short_name"));
			}
			System.out.println("languages "+languages);
		}
		catch (Exception exp)
		{
			throw exp;
		}
		finally
		{
			XHUtil.closeDBResources(resultSet, pstmt, null);
		}
		return languages;
	}
}
