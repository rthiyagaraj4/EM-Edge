/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMR;

import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
import java.net.*;
import webbeans.eCommon.*;

import eCommon.SingleTabHandler.*;

public class AccuracyServlet extends HttpServlet
{
	PrintWriter out;
	java.util.Properties prop;
	HttpSession session;
	private ServletConfig config=null;

	String accuracy_code = "";
	String long_desc = "";
	String short_desc = "";
	String accuracy_indicator="";
	String eff_status = "";
	String added_by_id = "";
	String added_at_ws_no = "";
	String added_facility_id = "";
	String modified_by_id = "";
	String modified_at_ws_no = "";
	String modified_facility_id = "";
	String client_ip_address = "";
	String mode = "";
	String error_value = "0";
	
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" );

    HashMap AccuracyValues=new HashMap();

	public void init(ServletConfig config)throws ServletException{

		super.init(config);
		this.config = config;
	}

	public synchronized void doPost(HttpServletRequest request, HttpServletResponse response)throws javax.servlet.ServletException,IOException
	{
		this.out = response.getWriter();
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		session = request.getSession(false);
		this.prop = (java.util.Properties)session.getValue("jdbc");
		this.added_facility_id = (String)session.getValue("facility_id");
		client_ip_address = this.prop.getProperty("client_ip_address");
		modified_by_id = (prop.getProperty("login_user")==null)?"":prop.getProperty("login_user");
		modified_facility_id		= (this.added_facility_id==null)?"":this.added_facility_id;
		modified_at_ws_no   = (client_ip_address==null)?"":client_ip_address;
		try
		{
			mode = request.getParameter("mode")==null?"":request.getParameter("mode");
			if(mode.equals("1")) insert(request,response);
			if(mode.equals("2")) modify(request,response);
		}
		catch(Exception e){
			//out.println("Exception in try of doPost() of AccuracyServlet.java"+e);
			e.printStackTrace();
		}
	}//end of doPost()

	public synchronized void doGet(HttpServletRequest request,HttpServletResponse response) throws javax.servlet.ServletException,IOException
	{
		try
		{
			this.out = response.getWriter();
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			doPost(request,response);
		}
		catch(Exception e){
			//out.println("Exception in doGet() of AccuracyServlet.java"+e);
			e.printStackTrace();
		}
	}//end of doGet()

//***********Start of Insert************************

private void insert(HttpServletRequest request,HttpServletResponse response)
{
	try
	{
		added_by_id = (prop.getProperty("login_user")==null)?"":prop.getProperty("login_user");
		added_facility_id = (this.added_facility_id == null)?"":this.added_facility_id; 
		added_at_ws_no = (client_ip_address == null)?"":client_ip_address; 

		accuracy_code = request.getParameter("Accuracy_code")==null?"":request.getParameter("Accuracy_code");  
		long_desc = request.getParameter("Accuracy_Longdesc")==null?"":request.getParameter("Accuracy_Longdesc");
		short_desc = request.getParameter("Accuracy_Shortdesc")==null?"":request.getParameter("Accuracy_Shortdesc");
		accuracy_indicator = request.getParameter("Indicator")==null?"":request.getParameter("Indicator");
		eff_status = request.getParameter("eff_status_yn")==null?"D":request.getParameter("eff_status_yn");
        
        AccuracyValues.put("ACCURACY_CODE",accuracy_code);
        AccuracyValues.put("LONG_DESC",long_desc);
        AccuracyValues.put("SHORT_DESC",short_desc);
        AccuracyValues.put("ACCURACY_INDICATOR",accuracy_indicator);
        AccuracyValues.put("EFF_STATUS",eff_status);
		AccuracyValues.put("ADDED_BY_ID",added_by_id);
        AccuracyValues.put("ADDED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
        AccuracyValues.put("ADDED_AT_WS_NO",added_at_ws_no);
        AccuracyValues.put("ADDED_FACILITY_ID",added_facility_id);
        AccuracyValues.put("MODIFIED_BY_ID",modified_by_id);
        AccuracyValues.put("MODIFIED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
        AccuracyValues.put("MODIFIED_AT_WS_NO",modified_at_ws_no);
        AccuracyValues.put("MODIFIED_FACILITY_ID",modified_facility_id);
		String dupfields[] = {"ACCURACY_CODE"};
		String tabname="MR_ACCURACY";
		try
		{
			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[4];
			argArray[0] = prop;
			argArray[1] = AccuracyValues;
			argArray[2] = dupfields;
			argArray[3] = tabname;
			Class [] paramArray = new Class[4];
			paramArray[0] = prop.getClass();
			paramArray[1] = AccuracyValues.getClass();
			paramArray[2] = dupfields.getClass();
			paramArray[3] = tabname.getClass();
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			boolean inserted = (((Boolean)results.get("status")).booleanValue());
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
   			if ( results != null ) results.clear();
		 }
		 catch(Exception exp)
		 {
			// out.println("From Servlet--Calling EJB:"+exp);
			  exp.printStackTrace();
			  String error = "Error ";
			  String error_value = "0" ;
			  response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
		 }
	}
	catch(Exception e)
	{
		//out.println("<h3> Exception raised by Servlet ...So Record Not inserted </h3> Foll: Error Received : "+e.toString());
		e.printStackTrace();
	}//end of catch
}//end of insert

//*******************************************************************************
	public void modify(HttpServletRequest request,HttpServletResponse response)throws Exception
	{
		try
		{	
			HashMap Accuracymodifyvalues=new HashMap();
			added_by_id 	= prop.getProperty( "login_user" ) ;
			added_facility_id=(String)session.getValue("facility_id");
			String mfddate = dateFormat.format( new java.util.Date() ) ;

			modified_by_id	= added_by_id ;
			added_at_ws_no	= client_ip_address;
		    modified_at_ws_no= added_at_ws_no ;
			modified_facility_id = added_facility_id ;

			accuracy_code = request.getParameter("Accuracy_code")==null ? "":request.getParameter("Accuracy_code");
			short_desc = request.getParameter("Accuracy_Shortdesc")==null ? "":request.getParameter("Accuracy_Shortdesc");
			long_desc = request.getParameter("Accuracy_Longdesc")==null ? "":request.getParameter("Accuracy_Longdesc");
			accuracy_indicator = request.getParameter("Indicator1")==null ? "":request.getParameter("Indicator1");
			eff_status = request.getParameter("eff_status_yn")==null ? "D":request.getParameter("eff_status_yn");

			Accuracymodifyvalues.put("ACCURACY_CODE",accuracy_code);
			Accuracymodifyvalues.put("LONG_DESC",long_desc);
			Accuracymodifyvalues.put("SHORT_DESC",short_desc);
			Accuracymodifyvalues.put("ACCURACY_INDICATOR",accuracy_indicator);
			Accuracymodifyvalues.put("EFF_STATUS",eff_status);
			
			Accuracymodifyvalues.put("MODIFIED_BY_ID", added_by_id);
			Accuracymodifyvalues.put("MODIFIED_DATE", mfddate);
			Accuracymodifyvalues.put("MODIFIED_AT_WS_NO", client_ip_address);
			Accuracymodifyvalues.put("MODIFIED_FACILITY_ID", modified_facility_id);
					
			HashMap pkfields=new HashMap();
			pkfields.put("ACCURACY_CODE",accuracy_code);

			try{
				String tabname="mr_accuracy";
				boolean local_ejbs = false;
				if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
				Object argArray[] = new Object[4];
				argArray[0] = prop;
				argArray[1] = Accuracymodifyvalues;
				argArray[2] = pkfields;
				argArray[3] = tabname;

				Class [] paramArray = new Class[4];
				paramArray[0] = prop.getClass();
				paramArray[1] = Accuracymodifyvalues.getClass();
				paramArray[2] = pkfields.getClass();
				paramArray[3] = tabname.getClass();

				java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
				String error_value = "0" ;
				String error = (String) results.get("error") ;
				boolean updated = (((Boolean)results.get("status")).booleanValue());
	    		if ( updated )
				{
					    error_value= "1";
		     			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
	        	}
		     	else
		     	{
						response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
		     	}
   			   if ( results != null ) results.clear();
		     }
			 catch(Exception e)
             {
	              //out.println("From Servlet--Calling EJB:"+e);
                  e.printStackTrace();
				  String error = "Error ";
				  String error_value = "0" ;
			      response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
	        }

			if ( Accuracymodifyvalues != null ) Accuracymodifyvalues.clear();
			if ( pkfields != null ) pkfields.clear();
	  }
	  catch ( Exception e )
      {
		e.printStackTrace();
		//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
      }
  } // End modify
}
