/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMO;

import java.sql.*;
import java.io.*;
import java.util.*;
import java.text.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;

import eCommon.SingleTabHandler.*;

public class MOBedForAreaServlet extends HttpServlet implements SingleThreadModel
{
	PrintWriter out;
	String facilityId;
	HttpSession session;
	Properties p;
	String client_ip_address;
	boolean inserted		= false;
	String mode;
	String area_code;            
	String bed_no;        
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
    		area_code 					=  req.getParameter("area_code");
			area_code 					= (area_code == null)?"":area_code;
			bed_no				=  req.getParameter("bed_no");
			bed_no				= (bed_no == null)?"":bed_no;
			eff_status 						=  req.getParameter("eff_status");
			if(eff_status==null || eff_status.equals("") || eff_status=="")
			eff_status						= "D";
			mode 							=  req.getParameter("function");
			mode 							= (mode == null)?"":mode;
			if(mode.equalsIgnoreCase("insert"))
		     insertBedForArea(res);
            if(mode.equalsIgnoreCase("modify"))
		     modifyBedForArea(res);

		}catch(Exception e){
						out.println(e.toString());
			}
	}

 private void  insertBedForArea(HttpServletResponse res){
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

		        HashMap tabdata=new HashMap();
				tabdata.put("AREA_CODE",area_code);
				tabdata.put("BED_NO",bed_no);
				tabdata.put("FACILITY_ID",facilityId);
				tabdata.put("EFF_STATUS",eff_status);
				tabdata.put("ADDED_BY_ID",addedById);
				tabdata.put("ADDED_DATE",added_date);
				tabdata.put("ADDED_AT_WS_NO",addedAtWorkstation);
				tabdata.put("ADDED_FACILITY_ID", facilityId);
				tabdata.put("MODIFIED_BY_ID",modifiedById);
				tabdata.put("MODIFIED_DATE",modified_date);
				tabdata.put("MODIFIED_FACILITY_ID",modifiedFacilityId);
				tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );
                String dupflds[]={"AREA_CODE","BED_NO","FACILITY_ID"};
			    String tabname="MO_BED_FOR_AREA";
		        boolean local_ejbs = false;
		
				if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
		        Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
		        Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
         		
				Object argArray[] = new Object[4];
		        argArray[0] = p;
		        argArray[1] = tabdata;
		        argArray[2] = dupflds;
		        argArray[3] = tabname;

				Class [] paramArray = new Class[4];
				paramArray[0] = p.getClass();
				paramArray[1] = tabdata.getClass();
				paramArray[2] = dupflds.getClass();
				paramArray[3] = tabname.getClass();

	        	java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
	
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
		  
	       }catch ( Exception e )
      {
		e.printStackTrace();
		out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
      }
  } // End of the insertParameter

 private void  modifyBedForArea(HttpServletResponse res){

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

		HashMap tabdata=new HashMap();
		tabdata.put("EFF_STATUS",eff_status);
		tabdata.put("MODIFIED_BY_ID",modifiedById);
		tabdata.put("MODIFIED_DATE",modified_date);
		tabdata.put("MODIFIED_FACILITY_ID",modifiedFacilityId);
		tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );

		HashMap condflds=new HashMap();
		condflds.put("AREA_CODE",area_code);
		condflds.put("BED_NO",bed_no);
		condflds.put("FACILITY_ID",facilityId);

        String tabname="MO_BED_FOR_AREA";
		boolean local_ejbs = false;

		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		Object argArray[] = new Object[4];
		argArray[0] = p;
		argArray[1] = tabdata;
		argArray[2] = condflds;
		argArray[3] = tabname;

		Class [] paramArray = new Class[4];
		paramArray[0] = p.getClass();
		paramArray[1] = tabdata.getClass();
		paramArray[2] = condflds.getClass();
		paramArray[3] = tabname.getClass();

		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
	 	inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
		String error = (String) results.get("error") ;
		String error_value = "0" ;
	    
		 if ( inserted )
	     {
			    error_value= "1";
	   			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
	     }
	     else
	     {
			    res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
	   	 }
		argArray = null;
		paramArray = null;
		tabdata.clear();
		results.clear();
		condflds.clear();     
	  }catch ( Exception e )
      {
		e.printStackTrace();
		out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
      }
  } // End of the modifyParameter
} // End of the Class

