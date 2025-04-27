/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//This file is saved on 18/10/2005.


package eCP;

import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
//import javax.naming.*;
//import javax.rmi.*;
import java.net.*;
import webbeans.eCommon.*;

import eCommon.SingleTabHandler.*;

public class DependencyServlet extends HttpServlet
{
	PrintWriter out;
	java.util.Properties prop;
	HttpSession session;
	private ServletConfig config=null;


	String dependency_code = "";
	String long_desc = "";
	String short_desc = "";
	String dependency_level="";
	String reassessment_interval="";
	String reassessment_unit="";
	String guideline = "";
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
	
	HashMap DependencyValues=new HashMap();

	public void init(ServletConfig config)throws ServletException{

		super.init(config);
		this.config = config;
	}

//end of init()

	public  void doPost(HttpServletRequest request, HttpServletResponse response)throws javax.servlet.ServletException,IOException
		{
		this.out = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		session = request.getSession(false);

		this.prop = (java.util.Properties)session.getAttribute("jdbc");
		this.added_facility_id = (String)session.getAttribute("facility_id");

		client_ip_address = this.prop.getProperty("client_ip_address");
		modified_by_id = (prop.getProperty("login_user")==null)?"":prop.getProperty("login_user");
		modified_facility_id		= (this.added_facility_id==null)?"":this.added_facility_id;
		modified_at_ws_no   = (client_ip_address==null)?"":client_ip_address;

		
		try{

			mode = request.getParameter("mode")==null?"":request.getParameter("mode");
			if(mode.equals("1")) insert(request,response);
     		if(mode.equals("2")) modify(request,response);
		}
		catch(Exception e){
			out.println("Exception in try of doPost() of DependencyServlet.java"+e);
		}
	}//end of doPost()

public  void doGet(HttpServletRequest request,HttpServletResponse response) throws javax.servlet.ServletException,IOException{
	try{
		this.out = response.getWriter();
		response.setContentType("text/html");

		doPost(request,response);
	}
	catch(Exception e){
		out.println("Exception in doGet() of DependencyServlet.java"+e);
	}
}//end of doGet()

//***********Start of Insert************************

private void insert(HttpServletRequest request,HttpServletResponse response){
	try{
		added_by_id = (prop.getProperty("login_user")==null)?"":prop.getProperty("login_user");
		added_facility_id = (this.added_facility_id == null)?"":this.added_facility_id; 
		added_at_ws_no = (client_ip_address == null)?"":client_ip_address; 

		dependency_code = request.getParameter("Dependency_code")==null?"":request.getParameter("Dependency_code");  
		long_desc = request.getParameter("Dependency_Longdesc")==null?"":request.getParameter("Dependency_Longdesc");
		short_desc = request.getParameter("Dependency_Shortdesc")==null?"":request.getParameter("Dependency_Shortdesc");
		dependency_level = request.getParameter("Dependency_Level")==null?"":request.getParameter("Dependency_Level");
		reassessment_interval = request.getParameter("Reassessment_Interval")==null?"":request.getParameter("Reassessment_Interval");
		reassessment_unit = request.getParameter("Reassessment_Unit")==null?"":request.getParameter("Reassessment_Unit");
		guideline = request.getParameter("guideline")==null?"D":request.getParameter("guideline");
		eff_status = request.getParameter("eff_status_yn")==null?"D":request.getParameter("eff_status_yn");

        DependencyValues.put("DEPENDENCY_CODE",dependency_code);
        DependencyValues.put("LONG_DESC",long_desc);
        DependencyValues.put("SHORT_DESC",short_desc);
        DependencyValues.put("DEPENDENCY_LEVEL",dependency_level);
        DependencyValues.put("REASSESSMENT_INTERVAL",reassessment_interval);
        DependencyValues.put("REASSESSMENT_INTERVAL_UNIT",reassessment_unit);
		DependencyValues.put("GUIDELINE",guideline);
        DependencyValues.put("EFF_STATUS",eff_status);
		DependencyValues.put("ADDED_BY_ID",added_by_id);
        DependencyValues.put("ADDED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
        DependencyValues.put("ADDED_AT_WS_NO",added_at_ws_no);
        DependencyValues.put("ADDED_FACILITY_ID",added_facility_id);
        DependencyValues.put("MODIFIED_BY_ID",modified_by_id);
        DependencyValues.put("MODIFIED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
        DependencyValues.put("MODIFIED_AT_WS_NO",modified_at_ws_no);
        DependencyValues.put("MODIFIED_FACILITY_ID",modified_facility_id);

		String dupfields[] = {"DEPENDENCY_CODE"};
		try
		{
		/*Context context = new InitialContext();
		Object homeobj = context.lookup("java:comp/env/SingleTabHandler");
		SingleTabHandlerManagerHome singletabhandlermanagerhome = (SingleTabHandlerManagerHome) PortableRemoteObject.narrow(homeobj,SingleTabHandlerManagerHome.class);
		final SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singletabhandlermanagerhome.create();

		final java.util.HashMap results = singleTabHandlerManagerRemote.insert(prop,DependencyValues,dupfields,"CP_DEPENDENCY");*/

			boolean local_ejbs = false;
			ServletContext context = getServletConfig().getServletContext();
			if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[4];
			String table_name="CP_DEPENDENCY";
			argArray[0] =prop;
			argArray[1] =DependencyValues;
			argArray[2] =dupfields;
			argArray[3] =table_name;

			Class [] paramArray = new Class[4];
			paramArray[0] =prop.getClass();
			paramArray[1] =DependencyValues.getClass();
			paramArray[2] =dupfields.getClass();
			paramArray[3] =table_name.getClass();
			
			HashMap results = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

		boolean inserted = (((Boolean)results.get("status")).booleanValue());
        String error = (String) results.get("error") ;
         if ( inserted )
				   {
					    error_value= "1";
		     			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
	        	   }
		     	   else
		     	   {
					  response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
		     	   }

		}
		catch(Exception exp)
		{
		          out.println("From Servlet--Calling EJB:"+exp);
                  exp.printStackTrace();
				  String error = "Error ";
				  String error_value = "0" ;
			      response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
		}
	}
		catch(Exception e){
		out.println("<h3> Exception raised by Servlet ...So Record Not inserted </h3> Foll: Error Received : "+e.toString());
	}//end of catch
}//end of insert

//*******************************************************************************
public void modify(HttpServletRequest request,HttpServletResponse response)throws Exception
	{
		try{	

			added_by_id 	= prop.getProperty( "login_user" ) ;
			added_facility_id=(String)session.getAttribute("facility_id");

			modified_by_id	= added_by_id ;
			added_at_ws_no	= client_ip_address;
		    modified_at_ws_no= added_at_ws_no ;
			modified_facility_id = added_facility_id ;

		dependency_code = request.getParameter("Dependency_code")==null?"":request.getParameter("Dependency_code");  
		long_desc = request.getParameter("Dependency_Longdesc")==null?"":request.getParameter("Dependency_Longdesc");
		short_desc = request.getParameter("Dependency_Shortdesc")==null?"":request.getParameter("Dependency_Shortdesc");
		dependency_level = request.getParameter("Dependency_Level1")==null?"":request.getParameter("Dependency_Level1");
		reassessment_interval = request.getParameter("Reassessment_Interval")==null?"":request.getParameter("Reassessment_Interval");
		reassessment_unit = request.getParameter("Reassessment_Unit1")==null?"":request.getParameter("Reassessment_Unit1");
		guideline = request.getParameter("guideline")==null?"D":request.getParameter("guideline");
		eff_status = request.getParameter("eff_status_yn")==null?"D":request.getParameter("eff_status_yn");

		HashMap DependencyModifyValues=new HashMap();


	    DependencyModifyValues.put("DEPENDENCY_CODE",dependency_code);
        DependencyModifyValues.put("LONG_DESC",long_desc);
        DependencyModifyValues.put("SHORT_DESC",short_desc);
        DependencyModifyValues.put("DEPENDENCY_LEVEL",dependency_level);
        DependencyModifyValues.put("REASSESSMENT_INTERVAL",reassessment_interval);
        DependencyModifyValues.put("REASSESSMENT_INTERVAL_UNIT",reassessment_unit);
		DependencyModifyValues.put("GUIDELINE",guideline);
        DependencyModifyValues.put("EFF_STATUS",eff_status);
		DependencyModifyValues.put("ADDED_BY_ID",added_by_id);
        DependencyModifyValues.put("ADDED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
        DependencyModifyValues.put("ADDED_AT_WS_NO",added_at_ws_no);
        DependencyModifyValues.put("ADDED_FACILITY_ID",added_facility_id);
        DependencyModifyValues.put("MODIFIED_BY_ID",modified_by_id);
        DependencyModifyValues.put("MODIFIED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
        DependencyModifyValues.put("MODIFIED_AT_WS_NO",modified_at_ws_no);
        DependencyModifyValues.put("MODIFIED_FACILITY_ID",modified_facility_id);


		HashMap pkfields=new HashMap();
		pkfields.put("DEPENDENCY_CODE",dependency_code);

		try
		{
		/*Context context = new InitialContext();
		Object homeobj = context.lookup("java:comp/env/SingleTabHandler");
		SingleTabHandlerManagerHome singletabhandlermanagerhome = (SingleTabHandlerManagerHome) PortableRemoteObject.narrow(homeobj,SingleTabHandlerManagerHome.class);
		final SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singletabhandlermanagerhome.create();

		final java.util.HashMap results = singleTabHandlerManagerRemote.update(prop,DependencyModifyValues,pkfields,"CP_DEPENDENCY");*/

		boolean local_ejbs = false;
		ServletContext context = getServletConfig().getServletContext();
		if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
		local_ejbs = true;
		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		Object argArray[] = new Object[4];
		String table_name="CP_DEPENDENCY";
		argArray[0] =prop;
		argArray[1] =DependencyModifyValues;
		argArray[2] =pkfields;
		argArray[3] =table_name;

		Class [] paramArray = new Class[4];
		paramArray[0] =prop.getClass();
		paramArray[1] =DependencyModifyValues.getClass();
		paramArray[2] =pkfields.getClass();
		paramArray[3] =table_name.getClass();
			
			HashMap results = (HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

		boolean updated = (((Boolean)results.get("status")).booleanValue());
        String error = (String) results.get("error") ;
         if ( updated )
				   {
					   
					    error_value= "1";
		     			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
	        	   }
		     	   else
		     	   {
					   response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") + "&err_value=" + error_value );
		     	   }

		}
		catch(Exception exp)
		{
		          out.println("From Servlet--Calling EJB:"+exp);
                  exp.printStackTrace();
				  String error = "Error ";
				  String error_value = "0" ;
			      response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
		}
	}
		catch(Exception e){
		out.println("<h3> Exception raised by Servlet ...So Record Not inserted </h3> Foll: Error Received : "+e.toString());
	}//end of catch
}
}
