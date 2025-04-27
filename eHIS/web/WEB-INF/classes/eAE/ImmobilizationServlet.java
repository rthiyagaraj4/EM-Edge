/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAE;

import java.sql.*;
import java.io.*;
import java.util.*;
import java.text.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;

import eCommon.SingleTabHandler.*;

public class ImmobilizationServlet extends HttpServlet implements SingleThreadModel{
	PrintWriter out;
	String facilityId;
	HttpSession session;
	Properties p;
	String client_ip_address;

	boolean inserted		= false;
	String mode;
	String immobilization_code;            
	String long_desc;    
	String short_desc;   
	String eff_status;                                        
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config); 
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException{
		    req.setCharacterEncoding("UTF-8");
	        res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
		try	{

			session 						= req.getSession(true);
			this.facilityId = (String) session.getValue( "facility_id" ) ;
			this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		    this.client_ip_address = p.getProperty("client_ip_address");
            
			immobilization_code 				=  req.getParameter("immobilization_code");
			immobilization_code 				= (immobilization_code == null)?"":immobilization_code;
			long_desc						=  req.getParameter("long_desc");
			long_desc						= (long_desc == null)?"":long_desc;
			short_desc 						=  req.getParameter("short_desc");
			short_desc 						= (short_desc == null)?"":short_desc;
			eff_status 						=  req.getParameter("eff_status");
			if(eff_status==null || eff_status.equals("") || eff_status=="")
			eff_status						= "D";
			mode 							=  req.getParameter("mode");
			mode 							= (mode == null)?"":mode;
			if(mode.equalsIgnoreCase("INSERT"))
			{
			     insertImmobilization(res);
			}
            else 
			{
			     modifyImmobilization(res);
			}
		}catch(Exception e){
					e.printStackTrace();
			}
	}

 private void  insertImmobilization( HttpServletResponse res){
  try{
    	String addedById			= p.getProperty( "login_user" ) ;
    	String addedDate			= dateFormat.format( new java.util.Date() ) ;
		String modifiedById			= addedById ;
		String modifiedDate			= addedDate ;
		String addedFacilityId		= facilityId;
		String modifiedFacilityId	= addedFacilityId ;
		String addedAtWorkstation	=client_ip_address;
		String modifiedAtWorkstation= addedAtWorkstation ;
		java.sql.Date added_date1	= java.sql.Date.valueOf( addedDate ) ;
		java.sql.Date added_date	= new java.sql.Date(added_date1.parse(added_date1.toLocaleString())-(added_date1.getTimezoneOffset()*60*1000) ) ;

		java.sql.Date modified_date1= java.sql.Date.valueOf(modifiedDate ) ;
	    java.sql.Date modified_date = new java.sql.Date(modified_date1.parse(modified_date1.toLocaleString())-(modified_date1.getTimezoneOffset()*60*1000) ) ; 

		java.util.HashMap tabdata=new HashMap();
				tabdata.put("IMMOBILIZATION_CODE",immobilization_code);
				tabdata.put("LONG_DESC",long_desc);
				tabdata.put("SHORT_DESC",short_desc);
				tabdata.put("EFF_STATUS",eff_status);

				tabdata.put("ADDED_BY_ID",addedById);
				tabdata.put("ADDED_DATE",added_date);
				tabdata.put("ADDED_AT_WS_NO",addedAtWorkstation);
				tabdata.put("ADDED_FACILITY_ID", facilityId);
				tabdata.put("MODIFIED_BY_ID",modifiedById);
				tabdata.put("MODIFIED_DATE",modified_date);
				tabdata.put("MODIFIED_FACILITY_ID",modifiedFacilityId);
				tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );
        
   			String dupflds[]={"IMMOBILIZATION_CODE"};
		try{

			boolean local_ejbs = false;
			String tablename ="AE_IMMOBILIZATION";

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = dupflds;
			argArray[3] = tablename;

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = dupflds.getClass();
			paramArray[3] = tablename.getClass();


			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			   if ( inserted )
			   {
					error_value= "1";
					res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8"  ) + "&err_value=" + error_value );
			   }
			   else
			   {
					res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8"  ) + "&err_value=" + error_value );
			   }
			   tabdata.clear();
			   results.clear();
		     }catch(Exception e)
                {
	              //out.println("From Servlet--Calling EJB:"+e);
                  e.printStackTrace();
				  String error = "Error ";
				  String error_value = "0" ;
			      res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8"  ) + "&err_value=" + error_value );                  
	            }
	  }catch ( Exception e )
      {
		e.printStackTrace();
		//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
      }
  } // End of the insertParameter

 private void  modifyImmobilization(HttpServletResponse res){
  try{
        
		String addedById			= p.getProperty( "login_user" ) ;
		String addedDate			= dateFormat.format( new java.util.Date() ) ;
		String modifiedById			= addedById ;
		String modifiedDate			= addedDate ;
		String addedFacilityId		= facilityId;
		String modifiedFacilityId	= addedFacilityId ;
		String addedAtWorkstation	=client_ip_address;
		String modifiedAtWorkstation= addedAtWorkstation ;
		java.sql.Date modified_date1= java.sql.Date.valueOf(modifiedDate ) ;
	    java.sql.Date modified_date = new java.sql.Date(modified_date1.parse(modified_date1.toLocaleString())-(modified_date1.getTimezoneOffset()*60*1000) ) ; 

		java.util.HashMap tabdata=new HashMap();
		tabdata.put("LONG_DESC",long_desc);
		tabdata.put("SHORT_DESC",short_desc);
		tabdata.put("EFF_STATUS",eff_status);

		tabdata.put("MODIFIED_BY_ID",modifiedById);
		tabdata.put("MODIFIED_DATE",modified_date);
		tabdata.put("MODIFIED_FACILITY_ID",modifiedFacilityId);
		tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );

		java.util.HashMap condflds=new HashMap();
		condflds.put("IMMOBILIZATION_CODE",immobilization_code);
				
		try{
            boolean local_ejbs = false;
			String tablename ="AE_IMMOBILIZATION";

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = condflds;
			argArray[3] = tablename;

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = condflds.getClass();
			paramArray[3] = tablename.getClass();


			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error") ;
			String error_value = "0" ;

			   if ( inserted ) 
			   {
					error_value= "1";
					res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8"  ) + "&err_value=" + error_value );
			   }
			   else
			   {
					res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8"  ) + "&err_value=" + error_value );
			   }
			   tabdata.clear();
			   condflds.clear();
			   results.clear();
		     }catch(Exception e)
                {
	              //out.println("From Servlet--Calling EJB:"+e);
                  e.printStackTrace();
				  String error = "Error ";
				  String error_value = "0" ;
			      res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8"  ) + "&err_value=" + error_value );                  
	            }
	  }catch ( Exception e )
      {
		e.printStackTrace();
		//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
      }
  } // End of the modifyImmobilization
} // End of the Class
