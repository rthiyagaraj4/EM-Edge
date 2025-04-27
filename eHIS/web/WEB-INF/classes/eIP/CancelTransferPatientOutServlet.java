/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIP;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;

import eIP.IPCancelTransferPatientOut.* ;

public class CancelTransferPatientOutServlet extends javax.servlet.http.HttpServlet 
implements SingleThreadModel
{
	PrintWriter out;
	java.util.Properties p;
	String facilityId;
	String client_ip_address ;
	public void init(ServletConfig config) throws ServletException	
	{
		super.init(config);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException
	{   req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		HttpSession session		= req.getSession(false);
		this.facilityId			= (String)session.getValue("facility_id") ;
		this.p					= (java.util.Properties) session.getValue( "jdbc" ) ;
		this.client_ip_address	= p.getProperty("client_ip_address");
		try 
		{
			this.out = res.getWriter();
			IPCancelTransferPatientOut(req);
		}
		catch (Exception e)	
		{
			e.printStackTrace();
		}
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		try
		{
			doPost(req,res);
		}
		catch(Exception e)	{	}
	}
	private void IPCancelTransferPatientOut(HttpServletRequest req)	
	{
		try 
		{
			String error		= "";
			HashMap hashData	= new HashMap();
			hashData.put("facilityId",facilityId);
			hashData.put("patientid",checkForNull(req.getParameter("patient_id")));
			hashData.put("encounterid",checkForNull(req.getParameter("encounter_id")));
			hashData.put("bed_booking_ref_no",checkForNull(req.getParameter("TFR_REQ_REF_NO")));
			hashData.put("cancel_reason",checkForNull(req.getParameter("cancel_reason")));
			hashData.put("client_ip_address",client_ip_address);
			hashData.put("practid",checkForNull(req.getParameter("practid")));
			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/IPCancelTransferPatientOut",IPCancelTransferPatientOutHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = hashData;
			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = hashData.getClass();
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertCancelTransferPatientOut",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			boolean inserted	= ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			error				= (String) results.get("error") ;
			if(error.lastIndexOf("<br>") >= 0)
			error				= error.substring(0,error.indexOf("<br>"));
			if(inserted)
			{ 
				 out.println("<script>alert('"+error+"')</script>");
				 out.println("<script>top.window.document.getElementById('dialog_tag').close();</script>");
			}
			else
				out.print("<script>alert('"+error+"')</script>");

		 hashData.clear();
		 results.clear();
		} 
		catch ( Exception e ) 
		{
			e.printStackTrace();
		}
	}
	public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}
}
