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
import webbeans.eCommon.*;

import eCommon.SingleTabHandler.*;

public class QADiagProcForIndicator extends HttpServlet implements SingleThreadModel{
	PrintWriter out;
	String facilityId;
	HttpSession session;
	Connection con=null;
	Properties p;
	String client_ip_address;
    Statement stmt=null;
	ResultSet rst=null;
	boolean inserted		= false;
	String mode="";
	String schema_type="";	
	String	qind_indicator="";
	String diag_proc="";
	String  diagproccode="";
	java.util.HashMap results=null;

	//String module_id		= "QA";
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException{

			res.setContentType("text/html");
			this.out = res.getWriter();
		try	{
    
			session 					= req.getSession(true);
			this.facilityId = (String) session.getValue( "facility_id" ) ;
			this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		    this.client_ip_address = p.getProperty("client_ip_address");
         
           
			schema_type		=  req.getParameter("schema_type");
			if(schema_type	==null || schema_type	.equals("") ||schema_type	=="")
			schema_type	= "";
			qind_indicator		=  req.getParameter("qind_indicator");
			if(qind_indicator==null || qind_indicator.equals("") || qind_indicator=="")
		 	qind_indicator= "";
			
			diag_proc 		=  req.getParameter("diag_proc_ind");
			if(diag_proc==null || diag_proc.equals("") ||diag_proc=="")
			diag_proc	= "";
		  diagproccode 		=  req.getParameter("diagproccode");
			if(diagproccode==null || diagproccode.equals("") ||diagproccode=="")
			diagproccode	= "";
	       
		   mode 						= req.getParameter("mode");
			mode 						= (mode == null)?"":mode;
		
			if(mode.equalsIgnoreCase("I"))
			     insertParameter(req,res);
           // else 
			 //   modifyParameter(req,res);
		}catch(Exception e){
						out.println(e.toString());
			}
	}

 private void  insertParameter(HttpServletRequest req, HttpServletResponse res){
  try{
    	String addedById			= p.getProperty( "login_user" ) ;
    	String addedDate			= dateFormat.format( new java.util.Date() ) ;
		String modifiedById			= addedById ;
		String modifiedDate			= addedDate ;
		String addedFacilityId		= facilityId;
		String modifiedFacilityId	= addedFacilityId ;
		String addedAtWorkstation	= client_ip_address;
		String modifiedAtWorkstation= addedAtWorkstation ;
	    String sql="";
		//sql="select  *  from QA_QIND_CLIND_DIAG_PROC where QIND_CLIND_ID='"+qind_indicator+"' and DIAG_PROC_IND='"+diag_proc+ "' and SCHEME_TYPE='"+schema_type+ "' and DIAG_PROC_CODE='"+diagproccode+"'";
		sql="select  *  from QA_QIND_CLIND_DIAG_PROC where QIND_CLIND_ID='"+qind_indicator+"'  and DIAG_PROC_CODE='"+diagproccode+"'";
		con = ConnectionManager.getConnection(req); 
		java.sql.Date added_date1	= java.sql.Date.valueOf( addedDate ) ;
		java.sql.Date added_date	= new java.sql.Date(added_date1.parse(added_date1.toLocaleString())-(added_date1.getTimezoneOffset()*60*1000) ) ;
        
		java.sql.Date modified_date1= java.sql.Date.valueOf(modifiedDate ) ;
	    java.sql.Date modified_date = new java.sql.Date(modified_date1.parse(modified_date1.toLocaleString())-(modified_date1.getTimezoneOffset()*60*1000) ) ; 

		HashMap tabdata=new HashMap();
				
			tabdata.put("QIND_CLIND_ID",qind_indicator);
			tabdata.put("DIAG_PROC_IND",diag_proc);
			tabdata.put("SCHEME_TYPE",schema_type);
			tabdata.put("DIAG_PROC_CODE",diagproccode);
			tabdata.put("ADDED_BY_ID",addedById);
			tabdata.put("ADDED_DATE",added_date);
			tabdata.put("ADDED_AT_WS_NO",addedAtWorkstation);
			tabdata.put("ADDED_FACILITY_ID",facilityId);
			tabdata.put("MODIFIED_BY_ID",modifiedById);
			tabdata.put("MODIFIED_DATE",modified_date);
			tabdata.put("MODIFIED_FACILITY_ID",modifiedFacilityId);
			tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation);
			String dupflds[]={};
		stmt=con.createStatement();
		 rst=stmt.executeQuery(sql);
        if(!(rst.next()))
	  {

		try{
				//InitialContext context = new InitialContext();
				//Object homeObject = context.lookup("java:comp/env/SingleTabHandler");
				//final SingleTabHandlerManagerHome singleTabHandlerManagerHome  = (SingleTabHandlerManagerHome) PortableRemoteObject.narrow(homeObject ,SingleTabHandlerManagerHome.class);
				//final SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singleTabHandlerManagerHome.create();
				//final java.util.Hashtable results = singleTabHandlerManagerRemote.insert(p,tabdata,dupflds,"QA_QIND_CLIND_DIAG_PROC");

				String tabname="QA_QIND_CLIND_DIAG_PROC";
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

				 results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);

				inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
				String error = (String) results.get("error") ;
				String error_value = "0" ;
	    		   if ( inserted )
				   {
					    error_value= "1";
		     			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );
	        	   }
		     	   else
		     	   {
						res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );
		     	   }
		     }catch(Exception e)
                {
	              out.println("From Servlet--Calling EJB:"+e);
                  e.printStackTrace();
				  String error = "Error ";
				  String error_value = "0" ;
			  res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );
	            }
	  }
	  else
	  {
	  	  String error = "APP-002005 Record Already Exists... ";
		  String error_value = "1" ;
		 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );

	  }

		if(rst!=null)rst.close();
		if(stmt!=null) stmt.close();
	  tabdata.clear();
	  results.clear();
	  }catch ( Exception e )
      {
		e.printStackTrace();
		out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
      }
	  finally
			{
		    	ConnectionManager.returnConnection(con,req);
			}
  } // End of the insertParameter

  // End of the modifyParameter
// End of the Class



private void  modifyParameter(HttpServletRequest req, HttpServletResponse res){
  try{
    	String addedById			= p.getProperty( "login_user" ) ;
    	String addedDate			= dateFormat.format( new java.util.Date() ) ;
		String modifiedById			= addedById ;
		String modifiedDate			= addedDate ;
		String addedFacilityId		= facilityId;
		String modifiedFacilityId	= addedFacilityId ;
		String addedAtWorkstation	= client_ip_address;
		String modifiedAtWorkstation= addedAtWorkstation ;
	    String sql="";
	//	sql="select  *  from QA_QIND_CLIND_DIAG_PROC where QIND_CLIND_ID='"+qind_indicator+"' and DIAG_PROC_IND='"+diag_proc+ "' and SCHEME_TYPE='"+schema_type+ "' and DIAG_PROC_CODE='"+diagproccode+"'";
	sql="select  *  from QA_QIND_CLIND_DIAG_PROC where QIND_CLIND_ID='"+qind_indicator+"'  and DIAG_PROC_CODE='"+diagproccode+"'";
		con = ConnectionManager.getConnection(req); 
       java.sql.Date added_date1	= java.sql.Date.valueOf( addedDate ) ;
		java.sql.Date added_date	= new java.sql.Date(added_date1.parse(added_date1.toLocaleString())-(added_date1.getTimezoneOffset()*60*1000) ) ;
        
		java.sql.Date modified_date1= java.sql.Date.valueOf(modifiedDate ) ;
	    java.sql.Date modified_date = new java.sql.Date(modified_date1.parse(modified_date1.toLocaleString())-(modified_date1.getTimezoneOffset()*60*1000) ) ; 

		HashMap tabdata=new HashMap();
			
		tabdata.put("QIND_CLIND_ID",qind_indicator);
		tabdata.put("DIAG_PROC_IND",diag_proc);
		tabdata.put("SCHEME_TYPE",schema_type);
		tabdata.put("DIAG_PROC_CODE",diagproccode);
		tabdata.put("ADDED_BY_ID",addedById);
		tabdata.put("ADDED_DATE",added_date);
		tabdata.put("ADDED_AT_WS_NO",addedAtWorkstation);
		tabdata.put("ADDED_FACILITY_ID",facilityId);
		tabdata.put("MODIFIED_BY_ID",modifiedById);
		tabdata.put("MODIFIED_DATE",modified_date);
		tabdata.put("MODIFIED_FACILITY_ID",modifiedFacilityId);
		tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation);
		HashMap condFlds=new HashMap();
		tabdata.put("QIND_CLIND_ID",qind_indicator);
		tabdata.put("DIAG_PROC_IND",diag_proc);
		tabdata.put("SCHEME_TYPE",schema_type);
		stmt=con.createStatement();
		rst=stmt.executeQuery(sql);
        if(!(rst.next()))
	  {

		try{
				//InitialContext context = new InitialContext();
				//Object homeObject = context.lookup("java:comp/env/SingleTabHandler");
				//final SingleTabHandlerManagerHome singleTabHandlerManagerHome  = (SingleTabHandlerManagerHome) PortableRemoteObject.narrow(homeObject ,SingleTabHandlerManagerHome.class);
				//final SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singleTabHandlerManagerHome.create();
				//final java.util.Hashtable results = singleTabHandlerManagerRemote.update(p,tabdata,condFlds,"QA_QIND_CLIND_DIAG_PROC");

				String tabname="QA_QIND_CLIND_DIAG_PROC";
				boolean local_ejbs = false;
				if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
				Object argArray[] = new Object[4];
				argArray[0] = p;
				argArray[1] = tabdata;
				argArray[2] = condFlds;
				argArray[3] = tabname;
				Class [] paramArray = new Class[4];
				paramArray[0] = p.getClass();
				paramArray[1] = tabdata.getClass();
				paramArray[2] = condFlds.getClass();
				paramArray[3] = tabname.getClass();
				java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);

				inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
				String error = (String) results.get("error") ;
				String error_value = "0" ;
	    		   if ( inserted )
				   {
					    error_value= "1";
		     			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );
	        	   }
		     	   else
		     	   {
						res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );
		     	   }
		     }catch(Exception e)
                {
	              out.println("From Servlet--Calling EJB:"+e);
                  e.printStackTrace();
				  String error = "Error ";
				  String error_value = "0" ;
			  res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );
	            }
	  }
	  else
	  {
	  	  String error = "APP-SM0002 Operation Completed Successfully ....";
		  String error_value = "1" ;
		 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );

	  }
	  tabdata.clear();
	  condFlds.clear();	
	  results.clear();
	  }catch ( Exception e )
      {
		e.printStackTrace();
		out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
      }
	  finally
			{
			try
				{
 			if(rst!=null)rst.close();
			if(stmt!=null) stmt.close();
			
			ConnectionManager.returnConnection(con,req);
			}
			catch(Exception e)
				{
				System.out.println("Error"+e);
				}
			}

  } // End of the insertParameter

  // End of the modifyParameter
}
