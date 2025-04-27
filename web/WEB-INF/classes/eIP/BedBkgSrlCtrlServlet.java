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

public class BedBkgSrlCtrlServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	PrintWriter out;
	java.util.Properties p;
	String gensrlnum;
	String sStyle;	
	String facilityId ;
	String table_name;
	String client_ip_address ;
	HttpSession session;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		session				= req.getSession(false);
		this.p				= (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId		= (String) session.getValue( "facility_id" ) ;
		client_ip_address	= p.getProperty("client_ip_address");

		try
		{
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			String operation = req.getParameter("function_name");
			out.print(operation);
			if ( operation.equals("insert") )   insertBedBkgSrl(req, res);
			if ( operation.equals("delete"))	deleteBedBkgSrl(req, res);
			if ( operation.equals("modify"))	modifyBedBkgSrl(req, res);

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		try
		{
			this.out	= res.getWriter();
			
			sStyle		= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link><script language='javascript' src='/eCIS/ip/js/NursUnitRoom.js'></script></head><frameset rows='60,*,50'><frame name='commontoolbarFrame' src='../eCommon/jsp/commonToolbar.jsp?function_name=Rooms For Nursing Unit' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
			doPost(req,res);
		}
		catch(Exception e)	{	e.printStackTrace();}
	}
	private void insertBedBkgSrl(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			gensrlnum		= checkForNull(req.getParameter("gen_srl_num"),"N");
			gensrlnum		= "Y";

			String addedById			= p.getProperty( "login_user" ) ;
			String addedAtWorkstation	= client_ip_address;
			Timestamp added_date		= new Timestamp(System.currentTimeMillis() );
			Timestamp modified_date		= new Timestamp(System.currentTimeMillis() );
			HashMap   tabdata			= new HashMap();

			out.println(facilityId);
			tabdata.put("FACILITY_ID",facilityId);
			tabdata.put("BOOKING_TYPE",checkForNull(req.getParameter("booking_type")));
			tabdata.put("GEN_BOOKING_SRL_YN",gensrlnum);
			tabdata.put("NEXT_BOOKING_SRL_NO",checkForNull(req.getParameter("nxt_srl_no"),"null"));
			tabdata.put("MAX_BOOKING_SRL_NO",checkForNull(req.getParameter("max_srl_no"),"null"));
			tabdata.put("added_by_id",addedById);
			tabdata.put("added_date",added_date);
			tabdata.put("added_facility_id", facilityId);
			tabdata.put("added_at_ws_no",addedAtWorkstation);
			tabdata.put("modified_by_id",addedById);
			tabdata.put("modified_date",modified_date);
			tabdata.put("modified_facility_id",facilityId);
			tabdata.put("modified_at_ws_no",addedAtWorkstation );

			String dupflds[]={"FACILITY_ID","BOOKING_TYPE"};

			table_name		   = "ip_bed_booking_srl_ctrl";
			boolean local_ejbs = false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
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

			 boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			 String error = (String) results.get("error") ;
			 String error_value = "0" ;
			 if ( inserted )
				error_value = "1" ;
			else
				error = (String) results.get("error") ;
			error = (String) results.get("error") ;
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );

			tabdata.clear();
			results.clear();
	   }
	   catch ( Exception e )
	   {
			e.printStackTrace();
	   }
	}

	/******** Delete Function*************/

	private void deleteBedBkgSrl(HttpServletRequest req, HttpServletResponse res)
	{
		try 
		{
			res.setContentType("text/html;charset=UTF-8");

			gensrlnum		= checkForNull(req.getParameter("gen_srl_num"));

			HashMap delflds	= new HashMap();
			delflds.put("booking_type",checkForNull(req.getParameter("booking_type")));
			delflds.put("next_booking_srl_no",checkForNull(req.getParameter("nxt_srl_no")));
			delflds.put("max_booking_srl_no",checkForNull(req.getParameter("max_srl_no")));
			delflds.put("eff_status",checkForNull(req.getParameter("eff_status")));
			delflds.put("facility_id",checkForNull(req.getParameter("operating_facility_id")));

			table_name		   = "ip_bed_booking_srl_ctrl";
			boolean local_ejbs = false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = delflds;
			
			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = delflds.getClass();
			
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			if ( inserted )
				error_value = "1" ;
			else
			    error = (String) results.get("error") ;
			error = (String) results.get("error") ;
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
			delflds.clear();
			results.clear();

		} 
		catch ( Exception e )
		{
			e.printStackTrace();
		}
  }

  /***** Modify Function******/

  		private void modifyBedBkgSrl(HttpServletRequest req, HttpServletResponse res)
  		{
  			try
  			{
				gensrlnum    = checkForNull(req.getParameter("gen_srl_num"),"Y");

				String addedById			= p.getProperty( "login_user" ) ;
  				String addedAtWorkstation	= client_ip_address;
  				Timestamp added_date		= new Timestamp(System.currentTimeMillis() );
				Timestamp modified_date		= new Timestamp(System.currentTimeMillis() );
				HashMap tabdata=new HashMap();

				tabdata.put("NEXT_BOOKING_SRL_NO",checkForNull(req.getParameter("nxt_srl_no"),"null"));
				tabdata.put("MAX_BOOKING_SRL_NO",checkForNull(req.getParameter("max_srl_no"),"null"));
				tabdata.put("added_by_id",addedById);
				tabdata.put("added_date",added_date);
				tabdata.put("added_facility_id", facilityId);
				tabdata.put("added_at_ws_no",addedAtWorkstation);
				tabdata.put("modified_by_id",addedById);
				tabdata.put("modified_date",modified_date);
				tabdata.put("modified_facility_id",facilityId);
				tabdata.put("modified_at_ws_no",addedAtWorkstation );

				HashMap condflds=new HashMap();
				condflds.put("FACILITY_ID",facilityId);
				condflds.put("BOOKING_TYPE",checkForNull(req.getParameter("booking_type")));

				table_name		   = "ip_bed_booking_srl_ctrl";
				boolean local_ejbs = false;

				if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
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
  				boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
  				String error = (String) results.get("error") ;
  				String error_value = "0" ;
  				if ( inserted )
  					 error_value = "1" ;
  				else
  					 error = (String) results.get("error") ;
  				error = (String) results.get("error") ;
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
				
				condflds.clear();
				tabdata.clear();
				results.clear();
  			}
  			catch ( Exception e )
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
