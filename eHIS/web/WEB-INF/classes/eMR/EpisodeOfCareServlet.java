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
import eCommon.Common.*;
import webbeans.eCommon.*;
import  eCommon.SingleTabHandler.*;
import java.net.URLEncoder;

public class EpisodeOfCareServlet extends HttpServlet{

	private ServletConfig config = null;
	HttpSession session = null;
	PrintWriter out = null;
	String facility_id = "";
	Properties prop = new Properties();
	String client_ip_address = "";
	//String error_value ="";
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	String eoc_code = "";
	String short_desc = "";
	String long_desc= "";
	String eff_status="";
	String added_by_id = "";
	//String added_at_ws_no = "";
	//String added_facility_id = "";
	//String modified_by_id= "";
	//String modified_date = "";
	//String modified_at_ws_no = "";
	//String modified_facility_id= "";
	boolean inserted= false;
	
	public void init(ServletConfig config)throws ServletException{
		super.init(config);
		this.config = config;
	}

	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException	{
		doPost(request,response);
	}
	/*************************************************************************/

	public synchronized void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException	{

		session = request.getSession(false);
		facility_id = (String)session.getValue("facility_id");
		this.prop = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.client_ip_address = prop.getProperty("client_ip_address");		

		try{			
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			out = response.getWriter();
			String mode = request.getParameter("mode");

			if ( mode.equals("1")) insert(request, response);
			if ( mode.equals("2")) modify(request, response);

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**************************************************/
	public void insert(HttpServletRequest request,HttpServletResponse response)throws Exception{
		try{	
			HashMap tabData=new HashMap();
			added_by_id 	= prop.getProperty( "login_user" ) ;
			String addeddate = dateFormat.format( new java.util.Date() ) ;

			//modified_by_id	= added_by_id ;
			//added_at_ws_no	= client_ip_address;
			//added_facility_id= facility_id;
			//modified_at_ws_no= added_at_ws_no ;
			//modified_facility_id = facility_id ;

			eoc_code = request.getParameter("eoc_code")==null ? "":request.getParameter("eoc_code");
			short_desc = request.getParameter("episode_short_desc")==null ? "":request.getParameter("episode_short_desc");
			long_desc = request.getParameter("episode_long_desc")==null ? "":request.getParameter("episode_long_desc");
			eff_status = request.getParameter("eff_status")==null ? "D":request.getParameter("eff_status");

			tabData.put("eoc_code",eoc_code);
			tabData.put("long_desc",long_desc);
			tabData.put("short_desc",short_desc);
			tabData.put("eff_status",eff_status);
			tabData.put("ADDED_BY_ID", added_by_id);
			tabData.put("ADDED_DATE", addeddate);
			tabData.put("ADDED_AT_WS_NO",  client_ip_address);
			tabData.put("ADDED_FACILITY_ID",  facility_id);
			tabData.put("MODIFIED_BY_ID", added_by_id);
			tabData.put("MODIFIED_DATE", addeddate);
			tabData.put("MODIFIED_AT_WS_NO", client_ip_address);
			tabData.put("MODIFIED_FACILITY_ID", facility_id);
			
			String dupfields[]={"eoc_code"};
			String tabname="MR_EPISODE_OF_CARE";
			try{
				/*InitialContext context = new InitialContext();
				Object homeObject = context.lookup("java:comp/env/SingleTabHandler");
				final SingleTabHandlerManagerHome singleTabHandlerManagerHome  = (SingleTabHandlerManagerHome) PortableRemoteObject.narrow(homeObject ,SingleTabHandlerManagerHome.class);
				final SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singleTabHandlerManagerHome.create();

				final java.util.Hashtable results = singleTabHandlerManagerRemote.insert(p,tabData,dupflds,"MR_EPISODE_OF_CARE");
				*/
				boolean local_ejbs = false;
			
				if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
				Object argArray[] = new Object[4];
				argArray[0] = prop;
				argArray[1] = tabData;
				argArray[2] = dupfields;
				argArray[3] = tabname;

				Class [] paramArray = new Class[4];
				paramArray[0] = prop.getClass();
				paramArray[1] = tabData.getClass();
				paramArray[2] = dupfields.getClass();
				paramArray[3] = tabname.getClass();

				java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
				String error = (String) results.get("error") ;
				String error_value = "0" ;

	    		   if ( inserted )
				   {
					    error_value= "1";
		     			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
	        	   }
		     	   else
		     	   {
						response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
		     	   }
   				if (results != null) results.clear();	
		     }catch(Exception e)
                {
	              out.println("From Servlet--Calling EJB:"+e);
                  e.printStackTrace();
				  String error = "Error ";
				  String error_value = "0" ;
			      response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
	            }
				if (tabData != null) tabData.clear();	
	  }catch ( Exception e )
      {
		e.printStackTrace();
		out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
      }
  } // End insert

/**************************************************/
	public void modify(HttpServletRequest request,HttpServletResponse response)throws Exception{
		try{	
			HashMap tabData=new HashMap();
			added_by_id 	= prop.getProperty( "login_user" ) ;
			String mfddate = dateFormat.format( new java.util.Date() ) ;

			eoc_code = request.getParameter("eoc_code")==null ? "":request.getParameter("eoc_code");
			short_desc = request.getParameter("episode_short_desc")==null ? "":request.getParameter("episode_short_desc");
			long_desc = request.getParameter("episode_long_desc")==null ? "":request.getParameter("episode_long_desc");
			eff_status = request.getParameter("eff_status")==null ? "D":request.getParameter("eff_status");

			tabData.put("eoc_code",eoc_code);
			tabData.put("long_desc",long_desc);
			tabData.put("short_desc",short_desc);
			tabData.put("eff_status",eff_status);
			
			tabData.put("MODIFIED_BY_ID", added_by_id);
			tabData.put("MODIFIED_DATE", mfddate);
			tabData.put("MODIFIED_AT_WS_NO", client_ip_address);
			tabData.put("MODIFIED_FACILITY_ID", facility_id);
					
			HashMap pkfields=new HashMap();
			pkfields.put("eoc_code",eoc_code);
			String tabname="MR_EPISODE_OF_CARE";
			try{
				/*InitialContext context = new InitialContext();
				Object homeObject = context.lookup("java:comp/env/SingleTabHandler");
				final SingleTabHandlerManagerHome singleTabHandlerManagerHome  = (SingleTabHandlerManagerHome) PortableRemoteObject.narrow(homeObject ,SingleTabHandlerManagerHome.class);
				final SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singleTabHandlerManagerHome.create();

				final java.util.Hashtable results = singleTabHandlerManagerRemote.update(p,tabData,condflds,"MR_EPISODE_OF_CARE");*/
				boolean local_ejbs = false;
			
				if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);

				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[] = new Object[4];
				argArray[0] = prop;
				argArray[1] = tabData;
				argArray[2] = pkfields;
				argArray[3] = tabname;

				Class [] paramArray = new Class[4];
				paramArray[0] = prop.getClass();
				paramArray[1] = tabData.getClass();
				paramArray[2] = pkfields.getClass();
				paramArray[3] = tabname.getClass();

				java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
				String error_value = "0" ;

				//boolean updated = (((Boolean)results.get("status")).booleanValue());
				inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
				String error = (String) results.get("error") ;

	    		   if ( inserted )
				   {
					    error_value= "1";
		     			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
	        	   }
		     	   else
		     	   {
						response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
		     	   }
	   				if (results != null) results.clear();	
		     }catch(Exception e)
                {
	              out.println("From Servlet--Calling EJB:"+e);
                  e.printStackTrace();
				  String error = "Error ";
				  String error_value = "0" ;
			      response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
	            }
				if (tabData != null) tabData.clear();	
				if (pkfields != null) pkfields.clear();	
	  }catch ( Exception e )
      {
		e.printStackTrace();
		out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
      }
  } // End modify
}

		
