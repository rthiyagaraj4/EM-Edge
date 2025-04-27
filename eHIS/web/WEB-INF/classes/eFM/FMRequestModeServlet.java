/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eFM;

import java.sql.*;
import java.io.*;
import java.util.*;
import java.text.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;

import eCommon.SingleTabHandler.*;

public class FMRequestModeServlet extends HttpServlet implements SingleThreadModel
{
	PrintWriter out;
	HttpSession session;
	Properties p;
	String facilityId;
	String client_ip_address;

	String req_mode;
	String long_desc ;
	String short_desc ;
	String eff_status ;
	String locale			= "" ;

	boolean inserted		= false;	

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		this.out = res.getWriter();
		try	
		{
			session 			= req.getSession(true);
			this.p 				= (java.util.Properties) session.getValue("jdbc") ;
			locale = p.getProperty("LOCALE");
			facilityId 			= (String) session.getValue( "facility_id" ) ;
			client_ip_address 	= p.getProperty("client_ip_address");

			req_mode = req.getParameter("req_mode");
            long_desc = req.getParameter("long_desc");
            short_desc = req.getParameter("short_desc");
            eff_status = req.getParameter("eff_status");
			if ( eff_status == null )
				eff_status="D";

			String operation = req.getParameter("operation");

			if ( operation.equals("insert") )
				createReqMode(req, res, locale);
			if ( operation.equals("modify"))
				modifyReqMode(req, res, locale);

		}catch(Exception e)
			{
				out.println(e.toString());
			}
	}

	private void  createReqMode(HttpServletRequest req, HttpServletResponse res, String locale)
	{
		try
		{
			String addedById			= p.getProperty( "login_user" ) ;
			String modifiedById			= addedById ;	
			String addedFacilityId		= facilityId;
			String modifiedFacilityId	= addedFacilityId ;
			String addedAtWorkstation	=client_ip_address;
			String modifiedAtWorkstation= addedAtWorkstation ;

			Timestamp  DateTime = new Timestamp(System.currentTimeMillis() );

			HashMap tabdata=new HashMap();
			tabdata.put("req_mode", req_mode);
            tabdata.put("long_desc", long_desc);
            tabdata.put("short_desc", short_desc);
            tabdata.put("eff_status", eff_status);

			tabdata.put("ADDED_BY_ID",addedById);
			tabdata.put("ADDED_DATE",DateTime);
			tabdata.put("ADDED_AT_WS_NO",addedAtWorkstation);
			tabdata.put("ADDED_FACILITY_ID", facilityId);
			tabdata.put("MODIFIED_BY_ID",modifiedById);
			tabdata.put("MODIFIED_DATE",DateTime);
			tabdata.put("MODIFIED_FACILITY_ID",modifiedFacilityId);
			tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );
			//tabdata.put("locale",locale );

			String dupflds[]={"req_mode"};
			String table_name ="fm_manual_request_mode";

			try
			{
		
				boolean local_ejbs = false;
				if((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
					
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

				inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
				String error = (String) results.get("error") ;
				String error_value = "0" ;
				tabdata.clear();				
				results.clear();
			
	    		   if ( inserted )
				   {
					    error_value= "1";
		     			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
	        	   }
		     	   else
		     	   {
						res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
		     	   }
		    }catch(Exception e)
            {
				  out.println("From Servlet--Calling EJB:"+e);
                  e.printStackTrace();
				  String error = "Error ";
				  String error_value = "0" ;
			      res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );    
		     }
		}catch ( Exception e )
		{
			e.printStackTrace();
			out.println("<h3> Exception raise by Servlet ...So Record Not Inserted </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			out.println( req_mode+"  "+long_desc+"  "+short_desc+"  "+ eff_status );
		}
	} // End of the insert

	private void  modifyReqMode(HttpServletRequest req, HttpServletResponse res, String locale)
	{
		try
		{
			String addedById			= p.getProperty( "login_user" ) ;	
			String modifiedById			= addedById ;
			String addedFacilityId		= facilityId;
			String modifiedFacilityId	= addedFacilityId ;
			String addedAtWorkstation	=client_ip_address;
			String modifiedAtWorkstation= addedAtWorkstation ;


			Timestamp  DateTime = new Timestamp(System.currentTimeMillis() );

			HashMap tabdata=new HashMap();
			tabdata.put("long_desc", long_desc);
            tabdata.put("short_desc", short_desc);
            tabdata.put("eff_status", eff_status);

			tabdata.put("MODIFIED_BY_ID",modifiedById);
			tabdata.put("MODIFIED_DATE",DateTime);
			tabdata.put("MODIFIED_FACILITY_ID",modifiedFacilityId);
			tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );
			//tabdata.put("locale",locale );

			HashMap condflds=new HashMap();
			condflds.put("req_mode", req_mode);
			String table_name ="fm_manual_request_mode";

			try
			{
		
				boolean local_ejbs = false;
				if((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
					
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
				inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

				String error = (String) results.get("error") ;
				String error_value = "0" ;
				tabdata.clear();
				condflds.clear();
				results.clear();
				out.println("error"+error);	
	    		   if ( inserted )
				   {
					    error_value= "1";
		     			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
	        	   }
		     	   else
		     	   {
						res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
		     	   }
		    }catch(Exception e)
            {
	              out.println("From Servlet--Calling EJB:"+e);
                  e.printStackTrace();
				  String error = "Error ";
				  String error_value = "0" ;
			      res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );                  
	        }
		}catch ( Exception e )
		{
			e.printStackTrace();
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			out.println(req_mode + " " + long_desc + " " + short_desc + " " + eff_status);
		}
	} // End of the modify
} // End of the Class
