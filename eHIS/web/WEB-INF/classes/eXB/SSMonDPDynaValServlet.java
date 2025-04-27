/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXB;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Date;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;

import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.*;
import eXB.XBDBAdapter;
import eXH.XHUtil;

public class SSMonDPDynaValServlet extends HttpServlet
{
	public void doPost (HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException 
	{
		request.setCharacterEncoding("UTF-8");
   	    response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		Properties p = (Properties) session.getValue("jdbc");	

		XMLStringParser xmlObj = new XMLStringParser();
		Hashtable hash = (Hashtable)xmlObj.parseXMLString(request);
		hash = (Hashtable)hash.get("SEARCH") ;		

		String actionReq = XBDBAdapter.checkNull((String)hash.get("actionReq"));
		HashMap<String,String> result_hm = null;

		if("AUTH".equals(actionReq))
		{
			String userID = XBDBAdapter.checkNull((String)hash.get("userID"));
			String password = XBDBAdapter.checkNull((String)hash.get("password"));
			result_hm = validateUser(userID, password, p);
		}	
		
		hash.clear();

		out.println((String)result_hm.get("status"));		   	
	}

	public HashMap<String,String> processReq(String funcSelected, String locale, String facilityID, String actionParam, String jobNo, HttpServletRequest request)
	{    
		Connection connection = null;
		CallableStatement ostmt = null;
		Statement stmt = null;
		String message_text2 = "";
		String status = "";
		String exceptions = "";	
		String statusCode = "";
		String storedProc = "{ call xhjob.process_job(?,?,?,?,?,?,?,?,?,?) }";
		String jobWhatStr = "XBSSINT.PROCESSMAIN('" + facilityID + "');";
		HashMap<String,String> result_hm = new HashMap<String,String>();
		MessageManager mm = new MessageManager();
	
		try
		{
			if(connection == null) connection = ConnectionManager.getConnection();
			if("C".equals(funcSelected)) jobWhatStr = "xbssint.process_delete_ss();";
			else if("D".equals(funcSelected)) jobWhatStr = "xbssint.ssupload_data;";
			String custCode = null;
			String opdDate = null;
			
			if("P".equals(funcSelected) || "C".equals(funcSelected) || "D".equals(funcSelected))
			{
				ostmt = connection.prepareCall(storedProc); 
				ostmt.setString(1, actionParam);
				ostmt.setString(2, "0");		 
				ostmt.setString(3, jobNo);
				ostmt.setString(4, "0");
				ostmt.setString(5, jobWhatStr);
				ostmt.setString(6, "0");
				ostmt.setTimestamp(7, new java.sql.Timestamp((new Date()).getTime()));
				ostmt.setString(8, "0.0001"); // for running the job immediately
				ostmt.registerOutParameter(9,java.sql.Types.VARCHAR);
				ostmt.registerOutParameter(10,java.sql.Types.VARCHAR);
				ostmt.execute();

				statusCode = ostmt.getString(9);	
				message_text2 = ostmt.getString(10);
			}
			else if("OPD".equals(funcSelected))
			{
				storedProc = "{ call xbssint.e11_event_creation(?,?,?,?,?) }";

				custCode = request.getParameter("custCode");
				opdDate = XHUtil.convertDateFormat(request.getParameter("opdDate"), "MM/yyyy", "yyyyMM");

				ostmt = connection.prepareCall(storedProc); 
				ostmt.setString(1, facilityID);
				ostmt.setString(2, custCode);
				ostmt.setString(3, opdDate);				
				ostmt.registerOutParameter(4,java.sql.Types.VARCHAR);
				ostmt.registerOutParameter(5,java.sql.Types.VARCHAR);
				ostmt.execute();

				statusCode = ostmt.getString(4);	
				message_text2 = ostmt.getString(5);
			}
			else if("DE".equals(funcSelected)) // deleting process errors
			{
				String query = "DELETE xf_ss_int_error_log";

				stmt = connection.createStatement();
				int recCount = stmt.executeUpdate(query);
				if(recCount > 0) statusCode = "0";
				else statusCode = "1";
			}

			if("0".equals(statusCode))
			{
				final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
				status = ((String) mesg.get("message"));
				mesg.clear();
			}
			else
			{
				System.out.println("(SSMonDPDynaValServlet:statusCode) : " + statusCode);
				System.out.println("(SSMonDPDynaValServlet:message_text2) : " + message_text2);
				System.out.println("(SSMonDPDynaValServlet:Function) : " + funcSelected);

				if("OPD".equals(funcSelected))
				{
					System.out.println("(SSMonDPDynaValServlet:Customer code) : " + custCode);
					System.out.println("(SSMonDPDynaValServlet:OPD Month/Year) : " + opdDate);
					status = message_text2;
				}
				else
				{
					final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
					status = ((String) mesg.get("message"));	
					mesg.clear();
				}
			}
			connection.commit();
		}
		catch(Exception ex)
		{ 
			System.out.println("Error in calling dbrelated statements in processReq method of SSMonDPDynaValServlet  :"+ex.toString());
			exceptions = exceptions + "3" + "*" + ex.toString();
			ex.printStackTrace(System.err);
		}
		finally
		{
			try
			{
				if(ostmt != null) ostmt.close();
				if(stmt != null) stmt.close();
				if(connection != null) ConnectionManager.returnConnection(connection);			
			}
			catch (Exception exp)
			{
			}			
		}				 

		result_hm.put("exceptions",exceptions);
		result_hm.put("status",status);
		result_hm.put("statusCode",statusCode);

		return result_hm;  
	}

	private synchronized HashMap<String,String> validateUser(String userID, String password, Properties prop)
	{
		Statement stmt = null;
		Statement authSTMT = null;
		ResultSet rs = null;
		ResultSet authRS = null;
		Connection dbConn = null;

		String xfUserChkQry = "SELECT 1 FROM xf_ss_priv_default_values WHERE auth_process_user_id = UPPER('" + userID + "')";
		String authUserQry = "SELECT 1 FROM sm_appl_user WHERE appl_user_id = UPPER('"+ userID +"') AND app_password.decrypt(PIN_NO) = '"+ password +"'";
		String status = null;

		HashMap<String,String> result_hm = new HashMap<String,String>();
		MessageManager mm = new MessageManager();

		try
		{
			String locale = prop.getProperty("LOCALE");
			dbConn = ConnectionManager.getConnection(prop);
			stmt = dbConn.createStatement();
			rs = stmt.executeQuery(xfUserChkQry);			

			if(rs.next())
			{
				authSTMT = dbConn.createStatement();
				authRS = authSTMT.executeQuery(authUserQry);
				if(authRS.next())
				{
					status = "VALID";		
				}
				else
				{
					final java.util.Hashtable mesg = mm.getMessage(locale, "INVALID_VALUE", "COMMON") ;
					String temp = MessageManager.getLabel(locale, "eXH.AUTH_USER_ID.Label", "XH") 
								+ "/"
								+ MessageManager.getLabel(locale, "Common.PIN.label", "Common");
					status = ((String) mesg.get("message")).replace("#", temp);
					mesg.clear();
				}
			}
			else
			{
				final java.util.Hashtable mesg = mm.getMessage(locale, "INVALID_VALUE", "COMMON") ;
				status = ((String) mesg.get("message")).replace("#", MessageManager.getLabel(locale, "eXH.AUTH_USER_ID.Label", "XH"));
				mesg.clear();
			}
		}
		catch (Exception exp)
		{
			exp.printStackTrace(System.err);
		}
		finally
		{
			result_hm.put("status",status);
			try
			{
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(authRS != null) authRS.close();
				if(authSTMT != null) authSTMT.close();
				if(dbConn != null) ConnectionManager.returnConnection(dbConn);
			}
			catch(Exception fexp)
			{
				fexp.printStackTrace(System.err);
			}			
		}
		return result_hm;
	}
}
