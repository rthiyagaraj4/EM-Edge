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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import webbeans.eCommon.*;

public class NotificationRecipientServlet extends HttpServlet
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
		System.out.println("recipient " + locale);

		if("RECIPIENT_INFO".equals(requestType))
		{
			String recipientID = request.getParameter("recipientID");
			request.setAttribute("recipientInfo", getRecipientInfo(recipientID));
			request.setAttribute("mode", "U");
			request.getRequestDispatcher("/eXH/jsp/NotificationRecipient.jsp").forward(request, response);
		}
		else if("SAVE".equals(requestType))
		{
			String statusMessage = saveRecipient(XHUtil.getRequestParams(request), locale);
			request.setAttribute("statusMessage", statusMessage);
			request.getRequestDispatcher("/eXH/jsp/NotificationRecipientDispResult.jsp?stMessage="+statusMessage).forward(request, response);
		}
		else if("DELETE".equals(requestType))
		{
			String recipientID = request.getParameter("recipientID");
			String statusMessage = deleteRecipient(recipientID, locale);
			request.setAttribute("statusMessage", statusMessage);
			request.getRequestDispatcher("/eXH/jsp/NotificationRecipientDispResult.jsp?stMessage="+statusMessage).forward(request, response);
		}
		else if("CREATE".equals(requestType))
		{
			request.getRequestDispatcher("/eXH/jsp/NotificationRecipient.jsp").forward(request, response);
		}
		else if("QUERY".equals(requestType))
		{
			request.setAttribute("recipients", getRecipients(request, session));
			request.getRequestDispatcher("/eXH/jsp/NotificationRecipientsQueryResult.jsp").forward(request, response);
		}
		else if("MAIN".equals(requestType))
		{
			request.getRequestDispatcher("/eXH/jsp/NotificationRecipientMain.jsp").forward(request, response);
		}
    }

	private List<List<String>> getRecipients(HttpServletRequest request, HttpSession session)
	{
		Connection dbConn = null;
		
		List<List<String>> recipientsList = null;
		
		try
		{
			dbConn = ConnectionManager.getConnection(request);
			String recipientID = request.getParameter("recipientID");
			String shortDesc = request.getParameter("shortDesc");
			
			request.setAttribute(XHQueryRender.strQueryId, "NOTIFICATION_RECIPIENT_ID");
			request.setAttribute(XHQueryRender.col, "15");
			request.setAttribute(XHQueryRender.maxRec, "10");
			request.setAttribute("recipientID", XHDBAdapter.checkNull(recipientID));
			request.setAttribute("shortDesc", XHDBAdapter.checkNull(shortDesc));
			
			HashMap resultsQry = XHQueryRender.getResults(request, session, dbConn);

			recipientsList = (ArrayList)resultsQry.get("qry_result");
			String previous = ((Boolean)resultsQry.get("previous")) == true ? "Previous" : "";
			String next = ((Boolean)resultsQry.get("next")) == true ? "Next" : "";

			request.setAttribute("previousPage", previous);
			request.setAttribute("nextPage", next);

			XHUtil.addGUIRowClassName(recipientsList);
			System.out.println("recipientsList "+recipientsList);
		}
		catch (Exception exp)
		{
			System.out.println("(FilterRuleSettings:getRawColumnElements) Exception - " + exp.getMessage());
			exp.printStackTrace(System.err);
		}
		finally
		{
			XHUtil.closeDBResources(null, null, dbConn);
		}
		return recipientsList;
	}

	private Map<String, String> getRecipientInfo(String recipientID)
	{
		Connection dbConn = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		
		Map<String, String> recipientInfo = new HashMap<String, String>();
		String qry = "SELECT short_desc, long_desc, communication_mode, contact_type_code, country_code, to_mail_id_s, cc_mail_id_s, bcc_mail_id_s, to_phone_number_s, to_alt_phonenumber_s, to_alt_mobilenumber_s, to_mobile_number_s, to_fax_number_s, from_maild FROM xm_recipient_id WHERE recipient_id = ?";
		try
		{
			dbConn = ConnectionManager.getConnection();
			pstmt = dbConn.prepareStatement(qry);
			pstmt.setString(1, recipientID);
			resultSet = pstmt.executeQuery();

			while(resultSet.next())
			{
				recipientInfo.put("recipientID", recipientID);
				recipientInfo.put("shortDesc", resultSet.getString("short_desc"));
				recipientInfo.put("longDesc", resultSet.getString("long_desc"));
				recipientInfo.put("communicationMode", resultSet.getString("communication_mode"));
				recipientInfo.put("contactTypeCode", resultSet.getString("contact_type_code"));
				recipientInfo.put("countryCode", resultSet.getString("country_code"));
				recipientInfo.put("toMailIDs", resultSet.getString("to_mail_id_s"));
				recipientInfo.put("ccMainIDs", resultSet.getString("cc_mail_id_s"));
				recipientInfo.put("bccMailIDs", resultSet.getString("bcc_mail_id_s"));
				recipientInfo.put("toPhoneNos", resultSet.getString("to_phone_number_s"));
				recipientInfo.put("toAltPhoneNos", resultSet.getString("to_alt_phonenumber_s"));
				recipientInfo.put("toAltMobileNos", resultSet.getString("to_alt_mobilenumber_s"));
				recipientInfo.put("toMobileNos", resultSet.getString("to_mobile_number_s"));
			//	recipientInfo.put("to_fax_number_s", resultSet.getString("to_fax_number_s"));
				recipientInfo.put("fromMailID", resultSet.getString("from_maild"));
			}
			System.out.println("recipientInfo "+recipientInfo);
		}
		catch (Exception exp)
		{
			System.out.println("(NotificationRecipientServlet:getRecipientInfo) Exception - " + exp.getMessage());
			System.out.println("(NotificationRecipientServlet:getRecipientInfo) Recipient ID - " + recipientID);
			exp.printStackTrace(System.err);
		}
		finally
		{
			XHUtil.closeDBResources(resultSet, pstmt, dbConn);
		}
		return recipientInfo;
	}

	private String saveRecipient(Map<String, String> requestParams, String locale)
	{
		Connection dbConn = null;
		PreparedStatement pstmt = null;

		String statusMessage = null;
		String qry = "INSERT INTO xm_recipient_id (short_desc, long_desc, communication_mode, contact_type_code, country_code, to_mail_id_s, cc_mail_id_s, bcc_mail_id_s, to_phone_number_s, to_alt_phonenumber_s, to_alt_mobilenumber_s, to_mobile_number_s, to_fax_number_s, from_maild, recipient_id)"
						+ " VALUES "
						+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try
		{
			if("U".equals(requestParams.get("mode")))
			{
				qry = "UPDATE xm_recipient_id SET short_desc = ?, long_desc = ?, communication_mode = ?, contact_type_code = ?, country_code = ?, to_mail_id_s = ?, cc_mail_id_s = ?, bcc_mail_id_s = ?, to_phone_number_s = ?, to_alt_phonenumber_s = ?, to_alt_mobilenumber_s = ?, to_mobile_number_s = ?, to_fax_number_s = ?, from_maild = ? WHERE recipient_id = ?";
			}
			dbConn = ConnectionManager.getConnection();
			pstmt = dbConn.prepareStatement(qry);

			pstmt.setString(1, requestParams.get("shortDesc"));
			pstmt.setString(2, requestParams.get("longDesc"));
			pstmt.setString(3, requestParams.get("communicationMode"));
			pstmt.setString(4, requestParams.get("contactTypeCode"));
			pstmt.setString(5, requestParams.get("countryCode"));
			pstmt.setString(6, requestParams.get("toMailIDs"));
			pstmt.setString(7, requestParams.get("ccMailIDs"));
			pstmt.setString(8, requestParams.get("bccMailIDs"));
			pstmt.setString(9, requestParams.get("toPhoneNos"));
			pstmt.setString(10, requestParams.get("toAltPhoneNos"));
			pstmt.setString(11, requestParams.get("toAltMobileNos"));
			pstmt.setString(12, requestParams.get("toMobileNos"));
			pstmt.setString(13, requestParams.get("toFaxNos"));
			pstmt.setString(14, requestParams.get("fromMailID"));
			pstmt.setString(15, requestParams.get("recipientID"));

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
			System.out.println("(NotificationRecipientServlet:saveNewRecipient) Exception - " + exp.getMessage());
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

	private String deleteRecipient(String recipientID, String locale)
	{
		Connection dbConn = null;
		PreparedStatement pstmt = null;

		String statusMessage = null;
		String qry = "DELETE xm_recipient_id WHERE recipient_id = ?";
		try
		{
			dbConn = ConnectionManager.getConnection();
			pstmt = dbConn.prepareStatement(qry);
			pstmt.setString(1, recipientID);

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
			System.out.println("(NotificationRecipientServlet:saveNewRecipient) Exception - " + exp.getMessage());
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
