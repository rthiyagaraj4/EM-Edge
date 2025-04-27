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
import eCommon.SingleTabHandler.*;

public class MedicalServiceGrpServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	PrintWriter out;
	java.util.Properties p;
	
	String table_name;
	String client_ip_address ;
    String facilityId;
	HttpSession session;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		try
		{
			doPost(req,res);		
		}
		catch(Exception e)	
		{	
			e.printStackTrace();
		}
	}


	public  void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		session				 = req.getSession(false);
		this.p				 = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId		 = (String) session.getValue( "facility_id" ) ;
		client_ip_address	 = p.getProperty("client_ip_address");

		try
		{
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out		 = res.getWriter();
			String operation = req.getParameter("function_name");

			if (operation.equals("insert"))	insertNursingUnit(req, res);
			if (operation.equals("modify"))	modifyNursingUnit(req, res);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private void insertNursingUnit(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			String addedById			 = p.getProperty( "login_user" ) ;
			String modifiedById			 = addedById ;
			String addedFacilityId		 = facilityId;
			String modifiedFacilityId	 = addedFacilityId ;
			String addedAtWorkstation    = client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			Timestamp added_date		 = new Timestamp(System.currentTimeMillis() );
			Timestamp modified_date		 = new Timestamp(System.currentTimeMillis() );

			HashMap tabdata = new HashMap();
			tabdata.put("facility_id",facilityId);
			tabdata.put("med_ser_grp_code",checkForNull(req.getParameter("med_ser_grp_code")));
			tabdata.put("long_desc",checkForNull(req.getParameter("long_desc")));
			tabdata.put("short_desc",checkForNull(req.getParameter("short_desc")));
			tabdata.put("max_no_of_dly_booking",checkForNull(req.getParameter("max_no_of_dly_booking"),"0"));
			tabdata.put("max_no_of_mthly_booking",checkForNull(req.getParameter("max_no_of_mthly_booking"),"0"));
			tabdata.put("generate_num_yn",checkForNull(req.getParameter("generate_num_yn"),"N"));
			//tabdata.put("APPL_PATIENT_CLASS",checkForNull(req.getParameter("applicable_to")));
			tabdata.put("prefix_required_yn",checkForNull(req.getParameter("prefix_required_yn"),"N"));
			tabdata.put("next_seq_no",checkForNull(req.getParameter("next_seq_no"),"0"));
			tabdata.put("max_seq_no",checkForNull(req.getParameter("max_seq_no"),"0"));
			tabdata.put("eff_status",checkForNull(req.getParameter("eff_status"),"D"));

			tabdata.put("added_by_id",addedById);
			tabdata.put("added_date",added_date);
			tabdata.put("added_facility_id", facilityId);
			tabdata.put("added_at_ws_no",addedAtWorkstation);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",modified_date);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

			String dupflds[]={"med_ser_grp_code","facility_id"};
			
			table_name			= "ip_medical_service_group";
			boolean local_ejbs	= false;
			
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home   = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = dupflds;
			argArray[3] = table_name;

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = dupflds.getClass();
			paramArray[3] = table_name.getClass();
		
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			boolean inserted   = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error	   = (String) results.get("error") ;
			String error_value = "0" ;

			if ( inserted )
			{
				error_value	   = "1" ;
			}
			else
			{
				 error = (String) results.get("error") ;
			}
			error = (String) results.get("error") ;
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
		
			tabdata.clear();
			results.clear();
		}catch ( Exception e )
		{
			e.printStackTrace();
		}
	}


	private void modifyNursingUnit(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{

			String addedById			 = p.getProperty( "login_user" ) ;
			String modifiedById			 = addedById ;
			String addedFacilityId		 = facilityId;
			String modifiedFacilityId	 = addedFacilityId ;
			String addedAtWorkstation	 = client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			Timestamp modified_date		 = new Timestamp(System.currentTimeMillis() );

			HashMap tabdata = new HashMap();
			tabdata.put("long_desc",checkForNull(req.getParameter("long_desc")));
			tabdata.put("short_desc",checkForNull(req.getParameter("short_desc")));
			tabdata.put("max_no_of_dly_booking",checkForNull(req.getParameter("max_no_of_dly_booking"),"0"));
			tabdata.put("max_no_of_mthly_booking",checkForNull(req.getParameter("max_no_of_mthly_booking"),"0"));
			//tabdata.put("APPL_PATIENT_CLASS",checkForNull(req.getParameter("applicable_to")));
			tabdata.put("eff_status",checkForNull(req.getParameter("eff_status"),"D"));
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",modified_date);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

			HashMap condflds = new HashMap();
			condflds.put("med_ser_grp_code",checkForNull(req.getParameter("med_ser_grp_code")));
			condflds.put("facility_id",facilityId);

			table_name			= "ip_medical_service_group";
			boolean local_ejbs	= false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				local_ejbs = true;

			Object home   = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = condflds;
			argArray[3] = table_name;

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = condflds.getClass();
			paramArray[3] = table_name.getClass();
		
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			boolean inserted   = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error	   = (String) results.get("error") ;
			String error_value = "0" ;

			if ( inserted )
				error_value = "1" ;
			else
				error = (String) results.get("error") ;

			error = (String) results.get("error") ;
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );

			condflds.clear();
			results.clear();
			tabdata.clear();

		}catch ( Exception e )
		{
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
