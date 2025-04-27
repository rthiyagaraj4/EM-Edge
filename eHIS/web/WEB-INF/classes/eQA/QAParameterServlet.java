/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
// Developed by Rajesh Kanna.S   1/2/2005 

/* *** *** This Servlet is used for Parameter Setup     *** */

package eQA;
import java.sql.*;
import java.io.*;
import java.util.*;
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
import eCommon.SingleTabHandler.*;

public class QAParameterServlet extends HttpServlet implements SingleThreadModel
{
	PrintWriter out;
	String facilityId;
	HttpSession session;
	Properties p;
	String client_ip_address;
	boolean inserted		= false;
	String mode				= "";
	String analyzeenc		= "";	
	String encounterstatus	= "";	
	String encounteripTo	= "";
	String encounteripFrom	= "";
	String encounteropTo	= "";
	String encounteropFrom	= "";
	String encounterdcTo	= "";
	String encounterdcFrom	= "";
	String encounteremTo	= "";
	String encounteremFrom	= "";
	String encounterxtTo	= "";
	String encounterxtFrom	= "";
	String  encollecipTo	= "";
	String  encollecipFrom	= "";
	String  encollecopTo	= "";
	String  encollecopFrom	= "";
	String  encollecdcTo	= "";
	java.util.HashMap results=null;
	String encollecdcFrom	= "";
	String encollecemTo		= "";
	String encollecemFrom	= "";
	String encollecxtTo		= "";
	String encollecxtFrom	= "";
	String error_value = "0" ;
	String error="";
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException{
	res.setContentType("text/html");
	this.out = res.getWriter();
	try	
	{
		session 				= req.getSession(true);
		this.facilityId         = (String) session.getValue( "facility_id" ) ;
		this.p                  = (java.util.Properties) session.getValue( "jdbc" ) ;
	    this.client_ip_address  = p.getProperty("client_ip_address");
		encounterstatus		    =  req.getParameter("encounterstatus");
		if(encounterstatus==null || encounterstatus.equals("") ||encounterstatus=="")
			encounterstatus	= "";
	      
		analyzeenc		=  req.getParameter("analyzeenc");
		if(analyzeenc==null || analyzeenc.equals("") ||analyzeenc=="")
		analyzeenc	= "N";
		
		encounteripTo 		=  req.getParameter("encounteripTo");
		if(encounteripTo==null || encounteripTo.equals("") ||encounteripTo=="")
		encounteripTo	= "";
		       
		encounteripFrom 		=  req.getParameter("encounteripFrom");
		if(encounteripFrom==null || encounteripFrom.equals("") ||encounteripFrom=="")
		encounteripFrom	= "";
		
		encounteropTo 		=  req.getParameter("encounteropTo");
		if(encounteropTo==null || encounteropTo.equals("") ||encounteropTo=="")
		encounteropTo	= "";
			
		encounteropFrom 		=  req.getParameter("encounteropFrom");
		if(encounteropFrom==null || encounteropFrom.equals("") ||encounteropFrom=="")
		encounteropFrom	= "";
	     		
		encounterdcTo 		=  req.getParameter("encounterdcTo");
		if(encounterdcTo==null || encounterdcTo.equals("") ||encounterdcTo=="")
		encounterdcTo	= "";
	   
		encounterdcFrom 		=  req.getParameter("encounterdcFrom");
		if(encounterdcFrom==null || encounterdcFrom.equals("") ||encounterdcFrom=="")
		encounterdcFrom	= "";

		encounteremTo 		=  req.getParameter("encounteremTo");
		if(encounteremTo==null || encounteremTo.equals("") ||encounteremTo=="")
		encounteremTo	= "";

		encounteremFrom 		=  req.getParameter("encounteremFrom");
		if(encounteremFrom==null || encounteremFrom.equals("") ||encounteremFrom=="")
		encounteremFrom	= "";

		encounterxtTo 		=  req.getParameter("encounterxtTo");
		if(encounterxtTo==null || encounterxtTo.equals("") ||encounterxtTo=="")
		encounterxtTo	= "";
	   
		encounterxtFrom 		=  req.getParameter("encounterxtFrom");
		if(encounterxtFrom==null || encounterxtFrom.equals("") ||encounterxtFrom=="")
		encounterxtFrom	= "";
	   			
		encollecipTo 		=  req.getParameter("encollecipTo");
		if(encollecipTo==null || encollecipTo.equals("") ||encollecipTo=="")
		encollecipTo	= "";
		
		encollecipFrom 		=  req.getParameter("encollecipFrom");
		if(encollecipFrom==null || encollecipFrom.equals("") ||encollecipFrom=="")
		encollecipFrom	= "";
				
		encollecopTo 		=  req.getParameter("encollecopTo");
		if(encollecopTo==null || encollecopTo.equals("") ||encollecopTo=="")
		encollecopTo	= "";
	   
		encollecopFrom 		=  req.getParameter("encollecopFrom");
		if(encollecopFrom==null || encollecopFrom.equals("") ||encollecopFrom=="")
		encollecopFrom	= "";

		encollecdcTo 		=  req.getParameter("encollecdcTo");
		if(encollecdcTo==null || encollecdcTo.equals("") ||encollecdcTo=="")
		encollecdcTo	= "";

		encollecdcFrom 		=  req.getParameter("encollecdcFrom");
		if(encollecdcFrom==null || encollecdcFrom.equals("") ||encollecdcFrom=="")
		encollecdcFrom	= "";

		encollecemTo 		=  req.getParameter("encollecemTo");
		if(encollecemTo==null || encollecemTo.equals("") ||encollecemTo=="")
		encollecemTo	= "";
		
		encollecemFrom		=  req.getParameter("encollecemFrom");
		if(encollecemFrom==null || encollecemFrom.equals("") ||encollecemFrom=="")
		encollecemFrom	= "";
	
		encollecxtTo 		=  req.getParameter("encollecxtTo");
		if(encollecxtTo==null || encollecxtTo.equals("") ||encollecxtTo=="")
		encollecxtTo	= "";
	
		encollecxtFrom		=  req.getParameter("encollecxtFrom");
		if(encollecxtFrom==null || encollecxtFrom.equals("") ||encollecxtFrom=="")
		encollecxtFrom	= "";
   		
		mode = req.getParameter("mode");
		mode = (mode == null)?"":mode;
		
		if(mode.equalsIgnoreCase("INSERT"))
			 insertParameter(res);
		else 
			 modifyParameter(res);
	}
	catch(Exception e)
	{
		out.println(e.toString());
	}
}

 private void  insertParameter( HttpServletResponse res){
  try{
    	
		String addedById			 = p.getProperty( "login_user" ) ;
    	String addedDate			 = dateFormat.format( new java.util.Date() ) ;
		String modifiedById			 = addedById ;
		String modifiedDate			 = addedDate ;
		String addedFacilityId		 = facilityId;
		String modifiedFacilityId	 = addedFacilityId ;
		String addedAtWorkstation	 = client_ip_address;
		String modifiedAtWorkstation = addedAtWorkstation ;
		java.sql.Date added_date1	 = java.sql.Date.valueOf( addedDate ) ;
		java.sql.Date added_date	 = new java.sql.Date(added_date1.parse(added_date1.toLocaleString())-(added_date1.getTimezoneOffset()*60*1000) ) ;

		java.sql.Date modified_date1 = java.sql.Date.valueOf(modifiedDate ) ;
	    java.sql.Date modified_date  = new java.sql.Date(modified_date1.parse(modified_date1.toLocaleString())-(modified_date1.getTimezoneOffset()*60*1000) ) ; 

		HashMap tabdata=new HashMap();				
		tabdata.put("DIR_REC_PRD_TO_DAYS_BACK_IP",encounteripTo);
		tabdata.put("DIR_REC_PRD_FR_DAYS_BACK_IP",encounteripFrom);
		tabdata.put("DIR_REC_PRD_TO_DAYS_BACK_DC",encounterdcTo);
		tabdata.put("DIR_REC_PRD_FR_DAYS_BACK_DC",encounterdcFrom);
		tabdata.put("DIR_REC_PRD_TO_DAYS_BACK_OP",encounteropTo);
		tabdata.put("DIR_REC_PRD_FR_DAYS_BACK_OP",encounteropFrom);
		tabdata.put("DIR_REC_PRD_TO_DAYS_BACK_EM",encounteremTo);
		tabdata.put("DIR_REC_PRD_FR_DAYS_BACK_EM",encounteremFrom);
		tabdata.put("DIR_REC_PRD_TO_DAYS_BACK_XT",encounterxtTo);
		tabdata.put("DIR_REC_PRD_FR_DAYS_BACK_XT",encounterxtFrom);
		tabdata.put("DIR_REC_ENC_STATUS",encounterstatus);
		tabdata.put("DIR_REC_INCL_ANALYZED_YN",analyzeenc);           
		tabdata.put("SYS_REC_DAYS_AFT_CLOSE_IP",encollecipTo);
		tabdata.put("SYS_REC_DAYS_AFT_CLOSE_DC",encollecdcTo);
		tabdata.put("SYS_REC_DAYS_AFT_CLOSE_OP",encollecopTo);
		tabdata.put("SYS_REC_DAYS_AFT_CLOSE_EM",encollecemTo);
		tabdata.put("SYS_REC_DAYS_AFT_CLOSE_XT",encollecxtTo);
		tabdata.put("ADDED_BY_ID",addedById);
		tabdata.put("ADDED_DATE",added_date);
		tabdata.put("ADDED_AT_WS_NO",addedAtWorkstation);
		tabdata.put("ADDED_FACILITY_ID", facilityId);
		tabdata.put("MODIFIED_BY_ID",modifiedById);
		tabdata.put("MODIFIED_DATE",modified_date);
		tabdata.put("MODIFIED_FACILITY_ID",modifiedFacilityId);
		tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );
		String dupflds[]={};
		String tabname="QA_QIND_PARAM";
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
		    error = (String) results.get("error") ;
			
			if ( inserted )
			{
				error_value= "1";
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );
			}
			else
			{
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );
			}
	  	tabdata.clear();
		results.clear();
		}
	  catch ( Exception e )
      {
 	    out.println("From Servlet--Calling EJB:"+e);
		e.printStackTrace();
		 error = "Error ";
		 error_value = "0" ;
		out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
      }
  } // End of the insertParameter

 private void  modifyParameter(HttpServletResponse res){
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
		tabdata.put("DIR_REC_PRD_TO_DAYS_BACK_IP",encounteripTo);
		tabdata.put("DIR_REC_PRD_FR_DAYS_BACK_IP",encounteripFrom);
		tabdata.put("DIR_REC_PRD_TO_DAYS_BACK_DC",encounterdcTo);
		tabdata.put("DIR_REC_PRD_FR_DAYS_BACK_DC",encounterdcFrom);
		tabdata.put("DIR_REC_PRD_TO_DAYS_BACK_OP",encounteropTo);
		tabdata.put("DIR_REC_PRD_FR_DAYS_BACK_OP",encounteropFrom);
		tabdata.put("DIR_REC_PRD_TO_DAYS_BACK_EM",encounteremTo);
		tabdata.put("DIR_REC_PRD_FR_DAYS_BACK_EM",encounteremFrom);
		tabdata.put("DIR_REC_PRD_TO_DAYS_BACK_XT",encounterxtTo);
		tabdata.put("DIR_REC_PRD_FR_DAYS_BACK_XT",encounterxtFrom);
		tabdata.put("DIR_REC_ENC_STATUS",encounterstatus);
		tabdata.put("DIR_REC_INCL_ANALYZED_YN",analyzeenc);
		tabdata.put("SYS_REC_DAYS_AFT_CLOSE_IP",encollecipTo);
		tabdata.put("SYS_REC_DAYS_AFT_CLOSE_DC",encollecdcTo);
		tabdata.put("SYS_REC_DAYS_AFT_CLOSE_OP",encollecopTo);
		tabdata.put("SYS_REC_DAYS_AFT_CLOSE_EM",encollecemTo);
		tabdata.put("SYS_REC_DAYS_AFT_CLOSE_XT",encollecxtTo);
		tabdata.put("ADDED_BY_ID",addedById);
		tabdata.put("ADDED_DATE",added_date);
		tabdata.put("ADDED_AT_WS_NO",addedAtWorkstation);
		tabdata.put("ADDED_FACILITY_ID", facilityId);
		tabdata.put("MODIFIED_BY_ID",modifiedById);
		tabdata.put("MODIFIED_DATE",modified_date);
		tabdata.put("MODIFIED_FACILITY_ID",modifiedFacilityId);
		tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );
		HashMap condflds=new HashMap();
			String tabname="QA_QIND_PARAM";
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
			 results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			 error = (String) results.get("error") ;
			 error_value = "0" ;
		    if ( inserted )
		    {
				error_value= "1";
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );
			}
			else
			{
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );
			}
	 tabdata.clear();
	 condflds.clear();
	 results.clear();
	 }
	  catch ( Exception e )
      { 
		out.println("From Servlet--Calling EJB:"+e);
		e.printStackTrace();
		 error = "Error ";
	    error_value = "0" ;
		out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
      }
  } // End of the modifyParameter
} // End of the Class 
