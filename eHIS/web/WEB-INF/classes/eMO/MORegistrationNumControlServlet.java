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

public class MORegistrationNumControlServlet extends HttpServlet 
	{
		PrintWriter out;
		String      facilityId;
		HttpSession session;
		Properties  p;
		String      client_ip_address;
		boolean     inserted		= false;
		String      mode;
		String mortuary_start_num;                    
		String mortuary_next_num;                              
		String mortuary_max_num; 
		String asso_dtls_reqd_yn;						
		String prefix_facility_id;					
		String suffix_facility_id;					
		String prefix_year;				
		String suffix_year;	
		java.sql.Date added_date=null;
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

    public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		this.out = res.getWriter();
	  try
		{
		session 			            = req.getSession(true);
		this.facilityId                 = (String) session.getValue( "facility_id" ) ;
		this.p                          = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.client_ip_address          = p.getProperty("client_ip_address");
		mortuary_start_num				= req.getParameter("mortuary_start_num");
		mortuary_start_num	            = (mortuary_start_num == null)?"":mortuary_start_num;				
		//mortuary_next_num also retreiving the same value from "mortuary_start_num" becoz both the place we have to show same values.
		mortuary_next_num 				= req.getParameter("mortuary_next_num");
		mortuary_next_num 	            = (mortuary_next_num == null)?"":mortuary_next_num;					
		mortuary_max_num 				= req.getParameter("mortuary_max_num");
		mortuary_max_num 				= (mortuary_max_num == null)?"":mortuary_max_num;
		asso_dtls_reqd_yn		        = req.getParameter("asso_dtls_reqd_yn");
		if(asso_dtls_reqd_yn == null || asso_dtls_reqd_yn.equals("")||asso_dtls_reqd_yn=="")
		asso_dtls_reqd_yn	            = "N";		
		prefix_facility_id			    =  req.getParameter("prefix_facility_id");
		if(prefix_facility_id == null || prefix_facility_id.equals("")|| prefix_facility_id=="")
		prefix_facility_id	            = "N"; 		  
		suffix_facility_id			    =  req.getParameter("suffix_facility_id");
		if(suffix_facility_id == null || suffix_facility_id.equals("")|| suffix_facility_id=="")
		suffix_facility_id	            = "N";
		prefix_year						=  req.getParameter("prefix_year");
		if(prefix_year == null || prefix_year.equals("")|| prefix_year=="")
		prefix_year	                    = "N";
		suffix_year						=  req.getParameter("suffix_year");
		if(suffix_year == null || suffix_year.equals("")|| suffix_year=="")
		suffix_year	                    = "N";
		//---------------end
		mode 							=  req.getParameter("mode");
		mode 							= (mode == null)?"":mode;
				
		if(mode.equalsIgnoreCase("INSERT"))
			 insertMORegistration(res);
		else 
			 modifyMORegistration(res);

	  }
	  catch(Exception e)
		{
		out.println(e.toString());
		}
	}

    private void  insertMORegistration(HttpServletResponse res){
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
		 added_date	= new java.sql.Date(added_date1.parse(added_date1.toLocaleString())-(added_date1.getTimezoneOffset()*60*1000) ) ;
		java.sql.Date modified_date1= java.sql.Date.valueOf(modifiedDate ) ;
	    java.sql.Date modified_date = new java.sql.Date(modified_date1.parse(modified_date1.toLocaleString())-(modified_date1.getTimezoneOffset()*60*1000) ) ; 
		HashMap tabdata             =new HashMap();
		tabdata.put("FACILITY_ID",facilityId);
		tabdata.put("START_NUM",mortuary_start_num);
		tabdata.put("NEXT_NUM",	mortuary_next_num);
		tabdata.put("MAX_NUM",mortuary_max_num);
		tabdata.put("ASSO_DTLS_REQD_YN",asso_dtls_reqd_yn);				
		tabdata.put("PREFIX_FACILITY_ID_YN",prefix_facility_id);
		tabdata.put("SUFFIX_FACILITY_ID_YN",suffix_facility_id);
		tabdata.put("PREFIX_YEAR_YN",prefix_year);
		tabdata.put("SUFFIX_YEAR_YN",suffix_year);
		tabdata.put("ADDED_BY_ID",addedById);
		tabdata.put("ADDED_DATE",added_date);
		tabdata.put("ADDED_AT_WS_NO",addedAtWorkstation);
		tabdata.put("ADDED_FACILITY_ID", facilityId);	
		tabdata.put("MODIFIED_BY_ID",modifiedById);
		tabdata.put("MODIFIED_DATE",modified_date);
		tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );
		tabdata.put("MODIFIED_FACILITY_ID",modifiedFacilityId);
		String dupflds[]          ={"FACILITY_ID"};					
		String tabname            ="MO_REGN_NUM_CONTROL";
		boolean local_ejbs        = false;
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
		Object home               = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
		Object busObj             = (home.getClass().getMethod("create",null)).invoke(home,null);
		Object argArray[]         = new Object[4];
		argArray[0]               = p;
		argArray[1]               = tabdata;
		argArray[2]               = dupflds;
		argArray[3]               = tabname;
		Class [] paramArray       = new Class[4];
		paramArray[0]             = p.getClass();
		paramArray[1]             = tabdata.getClass();
		paramArray[2]             = dupflds.getClass();
		paramArray[3]             = tabname.getClass();	
		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
		inserted              = ( ((Boolean) results.get( "status" )).booleanValue() ) ;				
		String error          = (String) results.get("error") ;						
		String error_value    = "0" ;
			if ( inserted )
			 {
				error_value= "1";
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
			 }
			else
			 {
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
			 }
		  tabdata.clear();
		  results.clear();
			 
			 }
	  catch ( Exception e )
      {			
		e.printStackTrace();
		out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
      }
  } 
    private void  modifyMORegistration(HttpServletResponse res){
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
		 added_date	= new java.sql.Date(added_date1.parse(added_date1.toLocaleString())-(added_date1.getTimezoneOffset()*60*1000) ) ;
		java.sql.Date modified_date1= java.sql.Date.valueOf(modifiedDate ) ;
	    java.sql.Date modified_date = new java.sql.Date(modified_date1.parse(modified_date1.toLocaleString())-(modified_date1.getTimezoneOffset()*60*1000) ) ; 

		HashMap tabdata=new HashMap();

				tabdata.put("FACILITY_ID",facilityId);
				tabdata.put("START_NUM",mortuary_start_num);				
				tabdata.put("NEXT_NUM",mortuary_next_num);
				tabdata.put("MAX_NUM",mortuary_max_num);
				tabdata.put("ASSO_DTLS_REQD_YN",asso_dtls_reqd_yn);					
				tabdata.put("PREFIX_FACILITY_ID_YN",prefix_facility_id);
				tabdata.put("SUFFIX_FACILITY_ID_YN",suffix_facility_id);
				tabdata.put("PREFIX_YEAR_YN",prefix_year);
				tabdata.put("SUFFIX_YEAR_YN",suffix_year);
				tabdata.put("MODIFIED_BY_ID",modifiedById);
				tabdata.put("MODIFIED_DATE",modified_date);
				tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );
				tabdata.put("MODIFIED_FACILITY_ID",modifiedFacilityId);				
		        HashMap condflds=new HashMap();
				condflds.put("FACILITY_ID",facilityId);
				String tabname="MO_REGN_NUM_CONTROL";
		        boolean local_ejbs = false;
				if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
				Object argArray[]     = new Object[4];
				argArray[0]           = p;
				argArray[1]           = tabdata;
				argArray[2]           = condflds;
				argArray[3]           = tabname;
				Class [] paramArray   = new Class[4];
				paramArray[0]         = p.getClass();
				paramArray[1]         = tabdata.getClass();
				paramArray[2]         = condflds.getClass();
				paramArray[3]         = tabname.getClass();	

			    java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			    inserted                  = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
				String error          = (String) results.get("error") ;
				String error_value    = "0" ;
		  		   if ( inserted )
				   {
					    error_value= "1";
		     			res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
	        	   }
		     	   else
		     	   {
						res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
		     	   }
			argArray = null;
			paramArray = null;
			tabdata.clear();
			results.clear();
			condflds.clear();      
	  }
	  catch ( Exception e )
      {
		e.printStackTrace();
		out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
      }
  } 
} 
