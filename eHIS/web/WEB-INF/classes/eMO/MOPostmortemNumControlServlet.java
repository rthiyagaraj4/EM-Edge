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

public class MOPostmortemNumControlServlet extends HttpServlet 
{
	PrintWriter out;
	String facilityId;
	HttpSession session;
	Properties p;
	String client_ip_address;
	boolean inserted= false;
	String mode;
	String start_num            ="";                    
	String next_num				="";
	String max_num				="";
	String asso_dtls_reqd_yn    ="N";						
	String prefix_facility_id_yn="N";
	String suffix_facility_id_yn="N";
	String prefix_year_yn       ="N";
	String suffix_year_yn       ="N";
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
			session 			= req.getSession(true);
			this.facilityId = (String) session.getValue( "facility_id" ) ;
			this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		    this.client_ip_address = p.getProperty("client_ip_address");
			start_num = req.getParameter("start_num");
			next_num = req.getParameter("next_num");
			max_num = req.getParameter("end_num");
			asso_dtls_reqd_yn = req.getParameter("post_associate_details");
			if(asso_dtls_reqd_yn==null)
			asso_dtls_reqd_yn = "N";
			prefix_facility_id_yn = req.getParameter("prefix_facility_id_yn");
			if(prefix_facility_id_yn==null) prefix_facility_id_yn = "N";
			suffix_facility_id_yn = req.getParameter("suffix_facility_id_yn");
			if(suffix_facility_id_yn==null) suffix_facility_id_yn = "N";
			prefix_year_yn = req.getParameter("prefix_year_yn");
			if(prefix_year_yn==null) prefix_year_yn = "N";
			suffix_year_yn = req.getParameter("suffix_year_yn");
			if(suffix_year_yn==null) suffix_year_yn = "N";
			mode =  req.getParameter("mode");
			mode = (mode == null)?"":mode;
			if(mode.equalsIgnoreCase("INSERT"))
			 insertMOPostmortem(res);
            else 
			 modifyMOPostmortem(res);
		}catch(Exception e)
		{
		 out.println(e.toString());
	    }
	}

    private void  insertMOPostmortem(HttpServletResponse res){
        try
			{
			
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
			tabdata.put("FACILITY_ID",facilityId);
			tabdata.put("START_NUM",start_num);
			tabdata.put("NEXT_NUM",next_num);
			tabdata.put("MAX_NUM",max_num);
			tabdata.put("ASSO_DTLS_REQD_YN",asso_dtls_reqd_yn);					
			tabdata.put("PREFIX_FACILITY_ID_YN",prefix_facility_id_yn);
			tabdata.put("SUFFIX_FACILITY_ID_YN",suffix_facility_id_yn);
			tabdata.put("PREFIX_YEAR_YN",prefix_year_yn);
			tabdata.put("SUFFIX_YEAR_YN",suffix_year_yn);
			tabdata.put("ADDED_BY_ID",addedById);
			tabdata.put("ADDED_DATE",added_date);
			tabdata.put("ADDED_AT_WS_NO",addedAtWorkstation);
			tabdata.put("ADDED_FACILITY_ID", facilityId);	
			tabdata.put("MODIFIED_BY_ID",modifiedById);
			tabdata.put("MODIFIED_DATE",modified_date);
			tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );
			tabdata.put("MODIFIED_FACILITY_ID",modifiedFacilityId);				     
			String dupflds[]={"FACILITY_ID"};
			String tabname="MO_POSTMORTEM_NUM_CONTROL";
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
	  }catch ( Exception e )
      {			
		e.printStackTrace();
		out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
      }
  } 

    private void  modifyMOPostmortem(HttpServletResponse res){
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
			tabdata.put("FACILITY_ID",facilityId);
			tabdata.put("START_NUM",start_num);
			tabdata.put("NEXT_NUM",next_num);
			tabdata.put("MAX_NUM",max_num);
			tabdata.put("ASSO_DTLS_REQD_YN",asso_dtls_reqd_yn);						
			tabdata.put("PREFIX_FACILITY_ID_YN",prefix_facility_id_yn);
			tabdata.put("SUFFIX_FACILITY_ID_YN",suffix_facility_id_yn);
			tabdata.put("PREFIX_YEAR_YN",prefix_year_yn);
			tabdata.put("SUFFIX_YEAR_YN",suffix_year_yn);
			tabdata.put("ADDED_BY_ID",addedById);
			tabdata.put("ADDED_DATE",added_date);
			tabdata.put("ADDED_AT_WS_NO",addedAtWorkstation);						
			tabdata.put("ADDED_FACILITY_ID", facilityId);	
			tabdata.put("MODIFIED_BY_ID",modifiedById);
			tabdata.put("MODIFIED_DATE",modified_date);
			tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );
			tabdata.put("MODIFIED_FACILITY_ID",modifiedFacilityId);					
			HashMap condflds=new HashMap();
			condflds.put("FACILITY_ID",facilityId);
			String tabname="MO_POSTMORTEM_NUM_CONTROL";
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
	  }catch ( Exception e )
      {
		e.printStackTrace();
		out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
      }
  } 
} 
