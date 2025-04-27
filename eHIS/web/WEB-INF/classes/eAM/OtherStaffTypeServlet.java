/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAM;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import eCommon.Common.*;
import eCommon.SingleTabHandler.*;
import webbeans.eCommon.*;


public class OtherStaffTypeServlet extends HttpServlet implements SingleThreadModel{

	private ServletConfig config = null;
	PrintWriter out = null;
	HttpSession session = null;
	String facility_id = "";
	Properties p = new Properties();
	String client_ip_address = "";
	boolean inserted= false;

	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd") ;

	String OTHER_STAFF_TYPE = "";
	String LONG_DESC = "";
	String SHORT_DESC= "";
	String EFF_STATUS = "";
	String ADDED_BY_ID = "";
	String ADDED_AT_WS_NO = "";
	String ADDED_FACILITY_ID = "";
	String MODIFIED_BY_ID = "";
	String MODIFIED_AT_WS_NO = "";
	String MODIFIED_FACILITY_ID = "";
	

	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		this.config = config;
	}
	/**************************************************************************/
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		doPost(request,response);
	}
	/**************************************************************************/
	public synchronized void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
	
		session = request.getSession(false);
		this.facility_id = (String) session.getAttribute( "facility_id" ) ;
		this.p = (java.util.Properties) session.getAttribute( "jdbc" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");

		try{
			response.setContentType("text/html");
			out = response.getWriter();

			String mode = request.getParameter("mode");
			if ( mode.equals("1"))
				insert(request, response);

			else if( mode.equals("2"))
				modify(request, response);

		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**************************************************************************/

	public void insert(HttpServletRequest request,HttpServletResponse response) throws Exception{

		HashMap tabData=new HashMap();


		try{
			String addeddate = dateFormat.format( new java.util.Date() ) ;

			session = request.getSession(false);
			facility_id = (String) session.getAttribute( "facility_id" ) ;
			p = (java.util.Properties) session.getAttribute( "jdbc" ) ;
			client_ip_address = p.getProperty("client_ip_address");

			ADDED_BY_ID					= p.getProperty( "login_user" ) ;
			ADDED_AT_WS_NO			= client_ip_address;
			ADDED_FACILITY_ID		= facility_id;
			MODIFIED_BY_ID			= ADDED_BY_ID ;
			MODIFIED_AT_WS_NO	= ADDED_AT_WS_NO ;
			MODIFIED_FACILITY_ID = facility_id ;
		
			OTHER_STAFF_TYPE = request.getParameter("StaffTypeCode")==null ? "":request.getParameter("StaffTypeCode");
			LONG_DESC = request.getParameter("LongDescription")==null ? "":request.getParameter("LongDescription");
			SHORT_DESC = request. getParameter("ShortDescription")==null ? "":request.getParameter("ShortDescription");
			EFF_STATUS = request.getParameter("eff_status")==null ? "D":request.getParameter("eff_status");

			
			
			tabData.put("other_staff_type",OTHER_STAFF_TYPE);
			tabData.put("long_desc",LONG_DESC);
			tabData.put("short_desc",SHORT_DESC);
			tabData.put("eff_status",EFF_STATUS);

			tabData.put("ADDED_BY_ID", ADDED_BY_ID);
			tabData.put("ADDED_DATE", addeddate);
			tabData.put("ADDED_AT_WS_NO",  ADDED_AT_WS_NO);
			tabData.put("ADDED_FACILITY_ID",  ADDED_FACILITY_ID);
			tabData.put("MODIFIED_BY_ID", MODIFIED_BY_ID);
			tabData.put("MODIFIED_DATE", addeddate);
			tabData.put("MODIFIED_AT_WS_NO", MODIFIED_AT_WS_NO);
			tabData.put("MODIFIED_FACILITY_ID", MODIFIED_FACILITY_ID);

			String dupflds[]={"other_staff_type"};

			try{

			boolean local_ejbs = false;
			ServletContext context = getServletConfig().getServletContext();
			if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[4];
			String table_name="am_other_staff_type";
			argArray[0] =p;
			argArray[1] =tabData;
			argArray[2] =dupflds;
			argArray[3] =table_name;

			Class [] paramArray = new Class[4];
			paramArray[0] =p.getClass();
			paramArray[1] =tabData.getClass();
			paramArray[2] =dupflds.getClass();
			paramArray[3] =table_name.getClass();
			
			HashMap results = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
				String error = (String) results.get("error") ;
				String error_value = "0" ;

	    		   if(inserted){
					    error_value= "1";
		     			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  ) + "&err_value=" + error_value );
	        	   }
		     	   else{
						response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  ) + "&err_value=" + error_value );
		     	   }
				   tabData.clear();
			       results.clear();
		     }catch(Exception e){

                  e.printStackTrace();
				  String error = "Error ";
				  String error_value = "0" ;
			      response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  ) + "&err_value=" + error_value );
	            }

	  }catch ( Exception e ){
		e.printStackTrace();
		out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
      }
	}

	//End of Insert
	/**************************************************************************/
	public void modify(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		HashMap tabData=new HashMap();

		try{
			String addeddate = dateFormat.format( new java.util.Date() ) ;

			session = request.getSession(false);
			facility_id = (String) session.getAttribute( "facility_id" ) ;
			p = (java.util.Properties) session.getAttribute( "jdbc" ) ;
			client_ip_address = p.getProperty("client_ip_address");

			ADDED_BY_ID					= p.getProperty( "login_user" ) ;
			ADDED_AT_WS_NO			= client_ip_address;
			ADDED_FACILITY_ID		= facility_id;
			MODIFIED_BY_ID			= ADDED_BY_ID ;
			MODIFIED_AT_WS_NO	= ADDED_AT_WS_NO ;
			MODIFIED_FACILITY_ID = facility_id ;

			OTHER_STAFF_TYPE = request.getParameter("StaffTypeCode")==null ? "":request.getParameter("StaffTypeCode");
			LONG_DESC = request.getParameter("LongDescription")==null ? "":request.getParameter("LongDescription");
			SHORT_DESC = request. getParameter("ShortDescription")==null ? "":request.getParameter("ShortDescription");
			EFF_STATUS = request.getParameter("eff_status")==null ? "D":request.getParameter("eff_status");
			
			tabData.put("other_staff_type",OTHER_STAFF_TYPE);
			tabData.put("long_desc",LONG_DESC);
			tabData.put("short_desc",SHORT_DESC);
			tabData.put("eff_status",EFF_STATUS);

			tabData.put("MODIFIED_BY_ID", MODIFIED_BY_ID);
			tabData.put("MODIFIED_DATE", addeddate);
			tabData.put("MODIFIED_AT_WS_NO", MODIFIED_AT_WS_NO);
			tabData.put("MODIFIED_FACILITY_ID", MODIFIED_FACILITY_ID);
			
			HashMap condflds=new HashMap();
			condflds.put("other_staff_type",OTHER_STAFF_TYPE);

			try{

			boolean local_ejbs = false;
			ServletContext context = getServletConfig().getServletContext();
			if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[4];
			String table_name="am_other_staff_type";
			argArray[0] =p;
			argArray[1] =tabData;
			argArray[2] =condflds;
			argArray[3] =table_name;

			Class [] paramArray = new Class[4];
			paramArray[0] =p.getClass();
			paramArray[1] =tabData.getClass();
			paramArray[2] =condflds.getClass();
			paramArray[3] =table_name.getClass();
			
			HashMap results = (HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
				String error = (String) results.get("error") ;
				String error_value = "0" ;

	    		   if(inserted){
					    error_value= "1";
		     			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  ) + "&err_value=" + error_value );
	        	   }
		     	   else{
						response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  ) + "&err_value=" + error_value );
		     	   }
				   tabData.clear();
			        condflds.clear();
			       results.clear();
		     }catch(Exception e){
                  e.printStackTrace();
				  String error = "Error ";
				  String error_value = "0" ;
			      response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  ) + "&err_value=" + error_value );
	            }
	  }catch ( Exception e ){
		e.printStackTrace();
		out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
      }
	}//end of modification
/**************************************************************************/
}
