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

public class FMNarrationServlet extends HttpServlet implements SingleThreadModel
{
	PrintWriter out;	
	HttpSession session;
	Properties p;
	String facilityId;
	String client_ip_address;

	String narr_code;
	String narr_long_desc ;
	String narr_short_desc ;
	String effective_status ;
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
			session 				= req.getSession(true);
			this.p 				= (java.util.Properties) session.getValue("jdbc") ;
			facilityId 			= (String) session.getValue( "facility_id" ) ;
			client_ip_address 	= p.getProperty("client_ip_address");
			locale = p.getProperty("LOCALE");
			narr_code			= req.getParameter("narrcode");
			narr_long_desc		= req.getParameter("narrlongdesc");
			narr_short_desc		= req.getParameter("narrshortdesc");
			effective_status	= req.getParameter("effstatus");
			if ( effective_status == null )
				effective_status="D";

			String operation = req.getParameter("operation");

			if ( operation.equals("insert") )
				createNarration(req, res,locale);
			if ( operation.equals("modify"))
				modifyNarration(req, res,locale);

		}catch(Exception e)
			{
				out.println(e.toString());
			}
	}

	private void  createNarration(HttpServletRequest req, HttpServletResponse res, String locale)
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
			tabdata.put("NARRATION_CODE",narr_code);
			tabdata.put("LONG_DESC",narr_long_desc);
			tabdata.put("SHORT_DESC",narr_short_desc);
			tabdata.put("EFF_STATUS",effective_status);

			tabdata.put("ADDED_BY_ID",addedById);
			tabdata.put("ADDED_DATE",DateTime);
			tabdata.put("ADDED_AT_WS_NO",addedAtWorkstation);
			tabdata.put("ADDED_FACILITY_ID", facilityId);
			tabdata.put("MODIFIED_BY_ID",modifiedById);
			tabdata.put("MODIFIED_DATE",DateTime);
			tabdata.put("MODIFIED_FACILITY_ID",modifiedFacilityId);
			tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );
			//tabdata.put("locale",locale );

			String dupflds[]={"NARRATION_CODE"};
			String table_name ="FM_NARRATION";
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
			out.println( narr_code+"  "+narr_long_desc+"  "+narr_short_desc+"  "+ effective_status );
		}
	} // End of the insert

	private void  modifyNarration(HttpServletRequest req, HttpServletResponse res, String locale)
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
			tabdata.put("LONG_DESC",narr_long_desc);
			tabdata.put("SHORT_DESC",narr_short_desc);
			tabdata.put("EFF_STATUS",effective_status);

			tabdata.put("MODIFIED_BY_ID",modifiedById);
			tabdata.put("MODIFIED_DATE",DateTime);
			tabdata.put("MODIFIED_FACILITY_ID",modifiedFacilityId);
			tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );
			//tabdata.put("locale",locale );

			HashMap condflds=new HashMap();
			condflds.put("NARRATION_CODE",narr_code);
			String table_name ="FM_NARRATION";

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
			out.println( narr_code+"  "+narr_long_desc+"  "+narr_short_desc+"  "+ effective_status );
		}
	} // End of the modify
} // End of the Class
