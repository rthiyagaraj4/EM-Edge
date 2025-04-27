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
import javax.rmi.*;
import java.util.*;

import eCommon.SingleTabHandler.*;

public class DischargeTypeServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	PrintWriter out;
	java.util.Properties p;

	String p_discharge_type_code;
	String p_deceased_yn;
	String p_maternal_death;
	String p_eff_status;
	String p_blocking_type_code="";
	String p_block_ind	="";
	String facilityId ;
	String table_name ;
	String client_ip_address ;

	HttpSession session;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		client_ip_address = p.getProperty("client_ip_address");

		try
		{
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			String operation = checkForNull(req.getParameter("function_name"));

			if ( operation.equals("insert") )   insertDischargeType(req, res);
			if ( operation.equals("modify") )    modifyDischargeType(req, res);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private void insertDischargeType(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			p_discharge_type_code	= checkForNull(req.getParameter("discharge_type_code"));
		//	p_short_desc			= checkForNull(req.getParameter("short_desc"));
			p_block_ind				= checkForNull(req.getParameter("block_indicate"));
			p_maternal_death		= checkForNull(req.getParameter("maternal_death_yn_hid"),"N");
			p_eff_status			= checkForNull(req.getParameter("eff_status"),"D");
			p_blocking_type_code	= checkForNull(req.getParameter("blocking_type"));

			if(p_block_ind.equals("DS"))
			{
				p_deceased_yn="Y";
			}
			else
			{
				p_deceased_yn="N";
			}

			if ( p_maternal_death == null ||p_maternal_death.equals(""))
				 p_maternal_death="N";

			if ( p_eff_status == null ||(p_eff_status ==""))
				 p_eff_status="D";

			String addedById			= p.getProperty( "login_user" ) ;
			String modifiedById			= addedById ;
			String modifiedFacilityId		= facilityId;
			String addedAtWorkstation	= client_ip_address;
			String modifiedAtWorkstation= addedAtWorkstation ;

			Timestamp added_date = new Timestamp(System.currentTimeMillis() );
			Timestamp modified_date = new Timestamp(System.currentTimeMillis() );

				HashMap tabdata=new HashMap();
				tabdata.put("discharge_type_code",p_discharge_type_code);
				tabdata.put("short_desc",checkForNull(req.getParameter("short_desc")));
				tabdata.put("long_desc",checkForNull(req.getParameter("long_desc")));
				tabdata.put("deceased_yn",p_deceased_yn);
				tabdata.put("MATERNAL_DEATH_YN",p_maternal_death);
				tabdata.put("eff_status",p_eff_status);
				tabdata.put("blocking_type_code",p_blocking_type_code);
				tabdata.put("INDICATOR",p_block_ind);
				tabdata.put("added_by_id",addedById);
				tabdata.put("added_date",added_date);
				tabdata.put("added_facility_id", facilityId);
				tabdata.put("added_at_ws_no",addedAtWorkstation);
				tabdata.put("modified_by_id",modifiedById);
				tabdata.put("modified_date",modified_date);
				tabdata.put("modified_facility_id",modifiedFacilityId);
				tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
				
				String dupflds[]={"discharge_type_code"};

			table_name			= "ip_discharge_type";
			boolean local_ejbs	= false;

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
			{
						 error_value = "1" ;
			}
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
			
			tabdata.clear();
			results.clear();
	   }
	   catch ( Exception e )
	   {
			e.printStackTrace();
	   }
	}

	private void modifyDischargeType(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			p_discharge_type_code		= checkForNull(req.getParameter("discharge_type_code"));
		//	p_short_desc				= checkForNull(req.getParameter("short_desc"));
			
			p_maternal_death			= checkForNull(req.getParameter("maternal_death_yn_hid"),"");
			p_eff_status				= checkForNull(req.getParameter("eff_status"),"D");
			p_blocking_type_code		= checkForNull(req.getParameter("blocking_type"));
			
			if(p_blocking_type_code==null)
			p_blocking_type_code = checkForNull(req.getParameter("hid_blocking_type"));

			//block_indicate added by kishore on 9/28/2004
			p_block_ind					= checkForNull(req.getParameter("block_indicate"));
			if(p_block_ind==null)
			 p_block_ind = checkForNull(req.getParameter("hid_block_indicate"),"N");

			if(p_block_ind.equals("DS"))
			{
				p_deceased_yn="Y";
			}
			else
			{
				p_deceased_yn="N";
			}

			//String addedById				= p.getProperty( "login_user" ) ;
			String modifiedById				= p.getProperty( "login_user" ) ; ;
			String modifiedFacilityId		= facilityId;
			String addedAtWorkstation		= client_ip_address;
			String modifiedAtWorkstation	= addedAtWorkstation ;

			Timestamp modified_date = new Timestamp(System.currentTimeMillis() );

			HashMap tabdata=new HashMap();
			tabdata.put("short_desc",checkForNull(req.getParameter("short_desc")));
			tabdata.put("long_desc",checkForNull(req.getParameter("long_desc")));
			tabdata.put("deceased_yn",p_deceased_yn);
			tabdata.put("MATERNAL_DEATH_YN",p_maternal_death);
			tabdata.put("eff_status",p_eff_status);
			tabdata.put("blocking_type_code",p_blocking_type_code);
			tabdata.put("INDICATOR",p_block_ind);
			//tabdata.put("added_by_id",addedById);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",modified_date);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

			HashMap condflds=new HashMap();
			condflds.put("discharge_type_code",p_discharge_type_code);

			table_name			= "ip_discharge_type";
			boolean local_ejbs	= false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0]   = p;
			argArray[1]   = tabdata;
			argArray[2]   = condflds;
			argArray[3]   = table_name;

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
			{
				error_value = "1" ;
			}
			 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );

			 tabdata.clear();
			 condflds.clear();
			 results.clear();
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
}
