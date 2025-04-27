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
import javax.rmi.*;
import webbeans.eCommon.*;

import eIP.IPCancelTransfer.* ;

public class CancelTransferServlet extends javax.servlet.http.HttpServlet 
{
	PrintWriter out;	
	java.util.Properties props;

	String strFacilityId;
	String client_ip_address ;

public void init(ServletConfig config) throws ServletException	{
	super.init(config);
}

public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
throws javax.servlet.ServletException,IOException
{
	out = null;	
	props = null;

	strFacilityId		= "";
	client_ip_address	= "";

	HttpSession session = req.getSession(false);
	this.strFacilityId  = (String)session.getValue("facility_id") ;
	this.props = (java.util.Properties) session.getValue( "jdbc" ) ;
	this.client_ip_address = props.getProperty("client_ip_address");
	req.setCharacterEncoding("UTF-8");
	res.setContentType("text/html;charset=UTF-8");
	try 
	{
		this.out = res.getWriter();
		

		IPCancelTransfer(req);
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

private void IPCancelTransfer(HttpServletRequest req)	{
try {
	String error="";

	java.util.HashMap hashData = new java.util.HashMap();
	hashData.put("strFacilityId",strFacilityId);
	hashData.put("strPatientId",checkForNull(req.getParameter("patient_id")));
	hashData.put("strSrlNo",checkForNull(req.getParameter("hdnSrlNo")));
	hashData.put("strEncounterId",checkForNull(req.getParameter("encounter_id")));
	hashData.put("strFrNursingUnitCode",checkForNull(req.getParameter("fr_nursing_unit_code")));
	hashData.put("strToNursingUnitCode",checkForNull(req.getParameter("nursing_unit")));
	hashData.put("strFrSpecialityCode",checkForNull(req.getParameter("fr_speciality_code")));
	hashData.put("strFrBedClass",checkForNull(req.getParameter("fr_bed_class")));
	hashData.put("strToBedNo",checkForNull(req.getParameter("to_bed_no")));
	hashData.put("strFrBedNo",checkForNull(req.getParameter("fr_bed_no")));
	hashData.put("strFrRoomNo",checkForNull(req.getParameter("fr_room_no")));
	hashData.put("strToRoomNo",checkForNull(req.getParameter("to_room_no")));
	hashData.put("client_ip_address",client_ip_address);
	hashData.put("strCancelReasonCode",checkForNull(req.getParameter("sltReasonForCancel")));
	hashData.put("strToPractitionerid,",checkForNull(req.getParameter("practid")));

	hashData.put("patientgender",checkForNull(req.getParameter("gender")));
	hashData.put("dateofbirth",checkForNull(req.getParameter("dateofbirth")));

	boolean local_ejbs = false;

	if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

	Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/IPCancelTransfer",IPCancelTransferHome.class,local_ejbs);
	Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
	
	Object argArray[] = new Object[2];
	argArray[0] = props;
	argArray[1] = hashData;
	
	Class [] paramArray = new Class[2];
	paramArray[0] = props.getClass();
	paramArray[1] = hashData.getClass();
	
	java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("updateIPCancelTransfer",paramArray)).invoke(busObj,argArray);

	(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
		
	boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
	error = (String) results.get("error") ;
	String strMessage = (String)results.get("message") ;
	
			 if(error.lastIndexOf("<br>")>=0)	
				 error = error.substring(0,error.indexOf("<br>"));
			 if(strMessage.lastIndexOf("<br>")>=0)	
				 strMessage = strMessage.substring(0,strMessage.indexOf("<br>"));

			 if(inserted){
							out.print("<script>alert(\""+strMessage+"\")</script>");	
						 out.print("<script>window.close();</script>");
				}
			 else
				 	out.println("<script>alert(\""+error+"\");</script>");
	
		hashData.clear();
		results.clear();
		} catch ( Exception e ) {
				 	e.printStackTrace();
		}
	}
	public static String checkForNull(String inputString)
	{
	 return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
	 return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}

}
