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

public class AEPriorityZoneServlet extends HttpServlet implements SingleThreadModel{
	PrintWriter out;
	String facilityId;
	HttpSession session; 
	Properties p;
	String client_ip_address; 

	boolean inserted		= false; 
	String mode;
	String priority_zone;            
	String priority_zone_desc;    
	String priority_zone_tab_desc;   
	/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 27th 2014 Start*/
	String priority_zone_color;
	String five_level_triage_appl_yn;
	String waiting_time;
	String waiting_time_color;
	/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 27th 2014 End*/
	String eff_status;
	//Added by Shanmukh on 10th-SEPT-2018 for MMS-DM-CRF-0147
	String isPriorityZoneAppl;
	
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
            
			priority_zone 	=  req.getParameter("priority_zone")==null?"":req.getParameter("priority_zone");			 
			priority_zone_desc		=  req.getParameter("priority_zone_desc")==null?"":req.getParameter("priority_zone_desc");
			 
			priority_zone_tab_desc 		=  req.getParameter("priority_zone_tab_desc")==null?"":req.getParameter("priority_zone_tab_desc");
			//Added by Shanmukh on 10th-SEPT-2018 for MMS-DM-CRF-0147
			eff_status 		=  req.getParameter("eff_status")==null?"E":req.getParameter("eff_status");
			isPriorityZoneAppl= req.getParameter("isPriorityZoneAppl")==null?"":req.getParameter("isPriorityZoneAppl");
			
			/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 27th 2014 Start*/
			priority_zone_color 	=  req.getParameter("priority_zone_color")==null?"":req.getParameter("priority_zone_color");
			five_level_triage_appl_yn	= req.getParameter("five_level_triage_appl_yn")==null ?"N":req.getParameter("five_level_triage_appl_yn");
			/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 27th 2014 End*/
			mode =  req.getParameter("mode")==null?"":req.getParameter("mode");

			waiting_time 	=  req.getParameter("waiting_time")==null?"":req.getParameter("waiting_time");
			waiting_time_color	= req.getParameter("waiting_time_color")==null ?"#FFFFFF":req.getParameter("waiting_time_color");
			
			if(mode.equalsIgnoreCase("MODIFY")){
			     modifypriorityzone(res);
			}
          
		}catch(Exception e){
			e.printStackTrace();
		}
	} //End of doPost
/*
 private void  insertpriorityzone( HttpServletResponse res){
  try{
    	String addedById	      = p.getProperty( "login_user" ) ;
    	String addedDate	      = dateFormat.format( new java.util.Date() ) ;
	String modifiedById	      = addedById ;
	String modifiedDate	      = addedDate ;
	String addedFacilityId	      = facilityId;
	String modifiedFacilityId     = addedFacilityId ;
	String addedAtWorkstation     = client_ip_address;
	String modifiedAtWorkstation  = addedAtWorkstation ;

	java.sql.Date added_date1     = java.sql.Date.valueOf( addedDate ) ;
	java.sql.Date added_date      = new java.sql.Date(added_date1.parse(added_date1.toLocaleString())-(added_date1.getTimezoneOffset()*60*1000) ) ;
	java.sql.Date modified_date1= java.sql.Date.valueOf(modifiedDate ) ;
        java.sql.Date modified_date = new java.sql.Date(modified_date1.parse(modified_date1.toLocaleString())-(modified_date1.getTimezoneOffset()*60*1000) ) ; 

	java.util.HashMap tabdata=new HashMap();
	tabdata.put("PRIORITY_ZONE",priority_zone);
	tabdata.put("PRIORITY_ZONE_DESC",priority_zone_desc);
	tabdata.put("PRIORITY_ZONE_TAB_DESC",priority_zone_tab_desc);
	tabdata.put("EFF_STATUS",eff_status);
	tabdata.put("ADDED_BY_ID",addedById);
	tabdata.put("ADDED_DATE",added_date);
	tabdata.put("ADDED_AT_WS_NO",addedAtWorkstation);
	tabdata.put("ADDED_FACILITY_ID", facilityId);
	tabdata.put("MODIFIED_BY_ID",modifiedById);
	tabdata.put("MODIFIED_DATE",modified_date);
	tabdata.put("MODIFIED_FACILITY_ID",modifiedFacilityId);
	tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );
	String dupflds[]={"PRIORITY_ZONE"};

	try{
		boolean local_ejbs = false;
		String tablename ="AE_PRIORITY_ZONE";
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
 	        if ( inserted ) {
			error_value= "1";
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8"  ) + "&err_value=" + error_value );
		}
		else{
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8"  ) + "&err_value=" + error_value );
		}
		tabdata.clear();
        results.clear();
	}catch(Exception e){
		out.println("From Servlet--Calling EJB:"+e);
		e.printStackTrace();
		String error = "Error ";
		String error_value = "0" ;
		res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8"  ) + "&err_value=" + error_value );                  
	}
	}catch ( Exception e ){
		e.printStackTrace();
		out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
        }
  } // End of the insertParameter
*/
 private void  modifypriorityzone(HttpServletResponse res){
 try{
   
	String addedById	       = p.getProperty( "login_user" ) ;
	String addedDate	       = dateFormat.format( new java.util.Date() ) ;
	String modifiedById	       = addedById ;
	String modifiedDate	       = addedDate ;
	String addedFacilityId	       = facilityId;
	String modifiedFacilityId      = addedFacilityId ;
	String addedAtWorkstation      =client_ip_address;
	String modifiedAtWorkstation   = addedAtWorkstation ;
	java.sql.Date modified_date1= java.sql.Date.valueOf(modifiedDate ) ;
	java.sql.Date modified_date = new java.sql.Date(modified_date1.parse(modified_date1.toLocaleString())-(modified_date1.getTimezoneOffset()*60*1000) ) ; 
	java.util.HashMap tabdata=new HashMap();
	
	tabdata.put("PRIORITY_ZONE_DESC",priority_zone_desc);
	tabdata.put("PRIORITY_ZONE_TAB_DESC",priority_zone_tab_desc);
	tabdata.put("MODIFIED_BY_ID",modifiedById);
	tabdata.put("MODIFIED_DATE",modified_date);
	tabdata.put("MODIFIED_FACILITY_ID",modifiedFacilityId);
	tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );
	tabdata.put("WAITING_TIME",waiting_time );
	tabdata.put("WAITING_TIME_COLOR",waiting_time_color );
	java.util.HashMap condflds=new HashMap();
	condflds.put("PRIORITY_ZONE",priority_zone);
	/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 27th 2014 Start*/
	
 if(five_level_triage_appl_yn.equals("Y")){
	 	tabdata.put("PRIORITY_ZONE_COLOR",priority_zone_color);
		
	}//Added by Shanmukh on 10th-SEPT-2018 for MMS-DM-CRF-0147
	if(isPriorityZoneAppl.equals("true")){
		tabdata.put("EFF_STATUS",eff_status);
		
	}
	/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 27th 2014 End*/
	try{
		boolean local_ejbs = false;
		String tablename ="AE_PRIORITY_ZONE";
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
                if ( inserted ) {
			error_value= "1";
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8"  ) + "&err_value=" + error_value );
		}
		else {
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8"  ) + "&err_value=" + error_value );
		}
		tabdata.clear();
		condflds.clear();
        results.clear(); 
	}catch(Exception e){
		//out.println("From Servlet--Calling EJB:"+e);
                e.printStackTrace();
		String error = "Error ";
		String error_value = "0" ;
		res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8"  ) + "&err_value=" + error_value );                  
	}
	}catch ( Exception e ){
		e.printStackTrace();
		//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
	}
  } // End of the modifydisastertype
} // End of the Class
