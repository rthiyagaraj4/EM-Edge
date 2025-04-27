/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXI;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.*;
import webbeans.eCommon.ConnectionManager;
import eXH.*;

/**
 * Servlet used to process custom monitoring requests
 */
public class MonitorItemsServlet extends HttpServlet
{ 
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{		
		try
		{			
			String statusMsg = processRequest(request);
			response.setContentType("text/html;charset=UTF-8");	
			PrintWriter out = response.getWriter();
			out.print(statusMsg);
			out.flush();
			out.close();
		}
		catch(Exception exp)
		{
			exp.printStackTrace(System.err);
		}

	}

	private String processRequest(HttpServletRequest request)
	{
		Connection connection = null;
		CallableStatement cstmt = null;
		String retMsg = "";
		String trxNo = "";
		String facilityID = "";
		String machineName = "";
		String modifiedByID = "";
		String locale = "";

		try
		{
			HttpSession session = request.getSession(false);
			Properties p = (Properties) session.getAttribute("jdbc");
			locale = p.getProperty("LOCALE");
			trxNo = request.getParameter("trxNo");
			facilityID = (String) session.getAttribute("facility_id");
			machineName = p.getProperty("client_ip_address");
			modifiedByID = p.getProperty("login_user");

			connection = ConnectionManager.getConnection(request);
			cstmt = connection.prepareCall("{call xg_prc.xi_srr_sapinv_reload(?,?,?,?,?,?)}");
			cstmt.setString(1, trxNo);
			cstmt.setString(2, facilityID);
			cstmt.setString(3, machineName);
			cstmt.setString(4, modifiedByID);
			cstmt.registerOutParameter(5, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(6, java.sql.Types.VARCHAR);
			cstmt.execute();
			String status = cstmt.getString(5);
			String errMsg = cstmt.getString(6);
			if("E".equals(status)) 
			{
				retMsg = XHUtil.getMessage("1", locale);
				System.out.println("(MonitorItemsServlet:processRequest) Reload error: "+errMsg);
			}
			else retMsg = XHUtil.getMessage("0", locale);
		}
		catch(Exception exp)
		{
			retMsg = XHUtil.getMessage("1", locale);
			System.out.println("(MonitorItemsServlet:processRequest) TransactionNo: " + trxNo);
			System.out.println("(MonitorItemsServlet:processRequest) Facility ID: " + facilityID);
			System.out.println("(MonitorItemsServlet:processRequest) Machine Name: " + machineName);
			System.out.println("(MonitorItemsServlet:processRequest) Modified ID: " + modifiedByID);
			System.out.println("(MonitorItemsServlet:processRequest) Exception: " + exp);
			exp.printStackTrace(System.err);
		}
		finally
		{
			XHUtil.closeDBResources(null, cstmt, connection);
		}	
		return retMsg;
	}

}
