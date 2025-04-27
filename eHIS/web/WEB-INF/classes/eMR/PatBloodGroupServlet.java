/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMR;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;

import eCommon.SingleTabHandler.*;

public class PatBloodGroupServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	Properties p;
	String PatientId;
	String BloodGroup;
	String RhFactor ;
	String G6pdMarker;
	String SiccMarker;
	String facilityId ;
	String client_ip_address ;

	HttpSession session;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
	String called_from	=	"";

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized  void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		session = req.getSession(false);
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		this.p = (Properties) session.getValue( "jdbc" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");

		try
		{			
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			modifyPatBloodGroup(req, res);
		}
		catch(Exception e)
		{
			//out.println(e.toString());
			e.printStackTrace();
		}
	}

	private void modifyPatBloodGroup(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			PatientId=req.getParameter("patientid");
			BloodGroup=req.getParameter("blood_group");
			RhFactor=req.getParameter("rf_code");
			G6pdMarker=req.getParameter("g6pd_marker");
			SiccMarker=req.getParameter("sicc_marker");
			if (G6pdMarker==null) G6pdMarker="";
			if (SiccMarker==null) SiccMarker="";
			called_from	=	(req.getParameter("called_from")==null)	?	""	:	req.getParameter("called_from");

			String modifiedById = p.getProperty( "login_user" ) ;
			String modifiedFacilityId = facilityId;
			String modifiedAtWorkstation = client_ip_address ;
			java.sql.Date modified_date = java.sql.Date.valueOf( dateFormat.format( new java.util.Date() ) ) ;

			HashMap tabdata=new HashMap();
			tabdata.put("blood_grp",BloodGroup);
			tabdata.put("rh_factor",RhFactor);
			tabdata.put("g6pd_marker",G6pdMarker);
			tabdata.put("sicc_marker",SiccMarker);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",modified_date);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

			HashMap condflds=new HashMap();
			condflds.put("patient_id",PatientId);

			String tableName = "MP_PAT_OTH_DTLS";
			boolean local_ejbs = false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = condflds;
			argArray[3] = tableName;

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = condflds.getClass();
			paramArray[3] = tableName.getClass();

			HashMap results = (HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			if ( inserted )
			{
				error_value = "1" ;
			}
			if(called_from.equals("CA"))
			{
				res.sendRedirect("../eCA/jsp/CAError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value="+error_value);
			}
			else
			{
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value="+error_value);
			}
			if ( tabdata != null) tabdata.clear();
			if ( results != null) results.clear();
			if ( condflds != null) condflds.clear();
		}
		catch ( Exception e )
		{
			/* out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ; */
			e.printStackTrace();
		}
	}
}
