/***************************************************************************************************************
 * Author   :   Ravindranath.O
 * Desc     :	
 ***************************************************************************************************************/
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

public class NotificationConsentServlet extends HttpServlet
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

		if("CONSENT_INFO".equals(requestType) || "CREATE".equals(requestType))
		{
			request.setAttribute("recipientTypes", DAOUtil.getInstance().getValuesMap(null, XHSQLSet.getSQL("NOTIFICATION_RECIPIENTS_TYPE")));
		}

		if("CONSENT_INFO".equals(requestType))
		{
			String patientID = request.getParameter("patientID");
			request.setAttribute("notificationConsentInfo", getNotificationConsentInfo(patientID, request));
			request.setAttribute("mode", "U");
			request.getRequestDispatcher("/eXH/jsp/NotificationConsent.jsp").forward(request, response);
		}
		else if("SAVE".equals(requestType))
		{
			String statusMessage = saveNotificationConsentInfo(XHUtil.getRequestParams(request), locale);
			request.setAttribute("statusMessage", statusMessage);
			request.getRequestDispatcher("/eXH/jsp/NotificationConsentDispResult.jsp?stMessage="+statusMessage).forward(request, response);
		}
		else if("DELETE".equals(requestType))
		{
			String patientID = request.getParameter("patientID");
			String statusMessage = deleteNotificationType(patientID, locale);
			request.setAttribute("statusMessage", statusMessage);
			request.getRequestDispatcher("/eXH/jsp/NotificationConsentDispResult.jsp?stMessage="+statusMessage).forward(request, response);
		}
		else if("CREATE".equals(requestType))
		{
			request.getRequestDispatcher("/eXH/jsp/NotificationConsent.jsp").forward(request, response);
		}
		else if("QUERY".equals(requestType))
		{
			request.setAttribute("notificationConsents", getNotificationConsentList(request, session));
			request.getRequestDispatcher("/eXH/jsp/NotificationConsentQueryResult.jsp").forward(request, response);
		}
		else if("MAIN".equals(requestType))
		{
			request.getRequestDispatcher("/eXH/jsp/NotificationConsentMain.jsp").forward(request, response);
		}
    }

	private List<List<String>> getNotificationConsentList(HttpServletRequest request, HttpSession session)
	{
		Connection dbConn = null;
		
		List<List<String>> notificationConsentList = null;
		
		try
		{
			dbConn = ConnectionManager.getConnection(request);
			String patientID = request.getParameter("patientID");
			
			request.setAttribute(XHQueryRender.strQueryId, "NOTIFICATION_CONSENT");
			request.setAttribute(XHQueryRender.col, "9");
			request.setAttribute(XHQueryRender.maxRec, "10");
			request.setAttribute("patientID", XHDBAdapter.checkNull(patientID));
			request.setAttribute("languages", DAOUtil.getInstance().getSMLanguages(dbConn));
			
			HashMap resultsQry = XHQueryRender.getResults(request, session, dbConn);

			notificationConsentList = (ArrayList)resultsQry.get("qry_result");
			String previous = ((Boolean)resultsQry.get("previous")) == true ? "Previous" : "";
			String next = ((Boolean)resultsQry.get("next")) == true ? "Next" : "";

			request.setAttribute("previousPage", previous);
			request.setAttribute("nextPage", next);

			XHUtil.addGUIRowClassName(notificationConsentList);
			System.out.println("notificationConsentList "+notificationConsentList);
		}
		catch (Exception exp)
		{
			System.out.println("(NotificationConsentServlet:notificationConsentList) Exception - " + exp.getMessage());
			exp.printStackTrace(System.err);
		}
		finally
		{
			XHUtil.closeDBResources(null, null, dbConn);
		}
		return notificationConsentList;
	}

	private Map<String, String> getNotificationConsentInfo(String uniqueID, HttpServletRequest request)
	{
		Connection dbConn = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		
		Map<String, String> notificationConsentInfo = new HashMap<String, String>();
		String qry = "SELECT patient_id, receipient_type, receipient_dependency, contact_type, contact_mode, eff_status, sms_events, mail_events, language_id"
						+ " FROM xm_event_notify_recipients_pat WHERE patient_id = ?";
		try
		{
			dbConn = ConnectionManager.getConnection();
			pstmt = dbConn.prepareStatement(qry);
			pstmt.setString(1, uniqueID);
			resultSet = pstmt.executeQuery();

			if(resultSet.next())
			{
				notificationConsentInfo.put("patientID", resultSet.getString("patient_id"));
				notificationConsentInfo.put("recipientType", resultSet.getString("receipient_type"));
				notificationConsentInfo.put("recipientDependency", resultSet.getString("receipient_dependency"));
				notificationConsentInfo.put("contactType", resultSet.getString("contact_type"));
				notificationConsentInfo.put("contactMode", resultSet.getString("contact_mode"));
				notificationConsentInfo.put("eventType", resultSet.getString("event_type"));
				notificationConsentInfo.put("languageID", resultSet.getString("language_id"));
				notificationConsentInfo.put("status", resultSet.getString("eff_status").equals("E") ? "CHECKED":"");
			}
			
			System.out.println("notificationConsentInfo "+notificationConsentInfo);
		}
		catch (Exception exp)
		{
			System.out.println("(NotificationConsentServlet:getNotificationConsentInfo) Exception - " + exp.getMessage());
			System.out.println("(NotificationConsentServlet:getNotificationConsentInfo) ID - " + uniqueID);
			exp.printStackTrace(System.err);
		}
		finally
		{
			XHUtil.closeDBResources(resultSet, pstmt, dbConn);
		}
		return notificationConsentInfo;
	}

	private String saveNotificationConsentInfo(Map<String, String> requestParams, String locale)
	{
		Connection dbConn = null;
		PreparedStatement pstmt = null;

		String statusMessage = null;
		String qry = "INSERT INTO xm_notification_type_code (type_class, short_desc, eff_status, type_code)"
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
			System.out.println("(NotificationConsentServlet:saveNotificationTypeInfo) Exception - " + exp.getMessage());
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
			System.out.println("(NotificationConsentServlet:deleteNotificationType) Exception - " + exp.getMessage());
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