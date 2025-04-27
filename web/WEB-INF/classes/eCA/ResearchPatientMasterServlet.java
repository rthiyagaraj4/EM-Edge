/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eCA;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.util.Date.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;

import eCommon.SingleTabHandler.*;

public class ResearchPatientMasterServlet extends javax.servlet.http.HttpServlet
{
	         
 public  void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");	
		PrintWriter out = null;
		try
		{
			out = res.getWriter();
			String mode =(req.getParameter("mode")==null)?"":req.getParameter("mode");
			if (mode.trim().equalsIgnoreCase("insert"))   insert(req, res, out);
			//out.println("<script>alert('mode :"+mode+"');</script>");
			if (mode.trim().equalsIgnoreCase("modify"))   modify(req, res, out);
		}//try1
		catch(Exception e)
		{
			out.println("Exception in try1 of ResearchPatientMasterServlet.java: "+e.toString());
			e.printStackTrace();
		}
	}
public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		PrintWriter out = null;
		try
		{
			out = res.getWriter();
			doPost(req,res);		
		}
		catch(Exception e)	
		{	
			out.println("Exception in invoking doPost Method");
			e.printStackTrace();
		}
	}
	
	private void insert(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
	{
		try
		{
			java.util.Properties p;

			String research_categ_id = "";
			String research_categ_desc = "";
			String eff_status = "";
			String facilityId		="";
			String client_ip_address	= "";
			String addedById			= "";
			String addedDate			= "";
			String addedAtWorkstation	= "";
			String addedFacilityId		= "";
			String modifiedById			= "";
			String modifiedAtWorkstation= "";
			HttpSession session;
			session = req.getSession(false);
			p = (Properties)session.getValue("jdbc") ;
			facilityId = (String)session.getValue( "facility_id" ) ;
			client_ip_address = p.getProperty("client_ip_address");
			modifiedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;           
			modifiedAtWorkstation   = (client_ip_address==null)?"":client_ip_address;  
			java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
			addedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;
			addedDate = dateFormat.format( new java.util.Date() ) ;
			addedFacilityId		= (facilityId == null)?"":facilityId;  
			addedAtWorkstation	= (client_ip_address == null)?"":client_ip_address; 
		    //added_date1	 = java.sql.Date.valueOf( addedDate ) ;
			//modified_date1 = java.sql.Date.valueOf(modifiedDate ) ;
//			added_date = new java.sql.Date(added_date1.parse(added_date1.toLocaleString())-(added_date1.getTimezoneOffset()*60*1000) ) ;
//			modified_date = new java.sql.Date(modified_date1.parse(modified_date1.toLocaleString())-(modified_date1.getTimezoneOffset()*60*1000) ) ;
			research_categ_id=req.getParameter("research_categ_id");
			if(research_categ_id == null) research_categ_id="";
			research_categ_desc=req.getParameter("research_categ_desc");
			if(research_categ_desc == null) research_categ_desc="";
			eff_status=req.getParameter("eff_status");
			if(eff_status == null)	eff_status="";
			eff_status 	= (eff_status.equals(""))?"D":eff_status ;

			HashMap tabdata = new HashMap(); 
			tabdata.put("research_categ_id",research_categ_id);
			tabdata.put("research_categ_desc",research_categ_desc);
			tabdata.put("eff_status",eff_status);
			if(addedById == null) addedById="";
			if(addedDate == null) addedDate="";
			if(facilityId == null ) facilityId="";
			if(addedFacilityId == null ) addedFacilityId="";
			if(addedAtWorkstation == null) addedAtWorkstation="";
			if(modifiedById == null) modifiedById="";
			if(modifiedAtWorkstation == null || modifiedAtWorkstation.equals("null") )
				modifiedAtWorkstation="";
			tabdata.put("ADDED_BY_ID",addedById);
			tabdata.put("ADDED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("ADDED_FACILITY_ID", addedFacilityId);
			tabdata.put("ADDED_AT_WS_NO",addedAtWorkstation);
			tabdata.put("MODIFIED_BY_ID",modifiedById);
			tabdata.put("MODIFIED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("MODIFIED_FACILITY_ID",addedFacilityId);
			tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );
			String dupflds[]={"research_categ_id"};
			/*Context context =  new InitialContext();
			Object homeObject = context.lookup("java:comp/env/SingleTabHandler");
			SingleTabHandlerManagerHome singleTabHandlerManagerHome=(SingleTabHandlerManagerHome)PortableRemoteObject.narrow(homeObject,  SingleTabHandlerManagerHome.class);
			final SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singleTabHandlerManagerHome.create();
			final java.util.Hashtable results = singleTabHandlerManagerRemote.insert(p,tabdata,dupflds,"ca_research_category");*/


			boolean local_ejbs = false;
			String tabname="ca_research_category";
		
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

		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
		tabdata.clear();
			boolean inserted = ( ((Boolean) results.get("status")).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			if ( inserted )
			{
				error_value = "1" ;
			}
			results.clear();
			out.println("error :"+error);
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+error_value);
		}//end of try block
		catch ( Exception e )
		{
			//out.println("<h3> Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : "+e.toString());//common-icn-0181
			e.printStackTrace();
		}
	}//end of insert 
	private void modify(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
	{
		try
		{
			java.util.Properties p;

			String research_categ_id = "";
			String research_categ_desc = "";
			String eff_status = "";
			String facilityId		="";
			String client_ip_address	= "";
			String addedById			= "";
			String addedDate			= "";
			String addedAtWorkstation	= "";
			String addedFacilityId		= "";
			String modifiedById			= "";
			String modifiedAtWorkstation= "";
			HttpSession session;
			session = req.getSession(false);
			p = (Properties)session.getValue("jdbc") ;
			facilityId = (String)session.getValue( "facility_id" ) ;
			client_ip_address = p.getProperty("client_ip_address");
			modifiedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;           
			modifiedAtWorkstation   = (client_ip_address==null)?"":client_ip_address;  
			java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
			addedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;
			addedDate = dateFormat.format( new java.util.Date() ) ;
			addedFacilityId		= (facilityId == null)?"":facilityId;  
			addedAtWorkstation	= (client_ip_address == null)?"":client_ip_address; 
		    //added_date1	 = java.sql.Date.valueOf( addedDate ) ;
			//modified_date1 = java.sql.Date.valueOf(modifiedDate ) ;
//			added_date = new java.sql.Date(added_date1.parse(added_date1.toLocaleString())-(added_date1.getTimezoneOffset()*60*1000) ) ;
//			modified_date = new java.sql.Date(modified_date1.parse(modified_date1.toLocaleString())-(modified_date1.getTimezoneOffset()*60*1000) ) ;
			research_categ_id=req.getParameter("research_categ_id1");
			if(research_categ_id == null) research_categ_id="";
			eff_status=req.getParameter("eff_status");
			if(eff_status == null) eff_status="";
			eff_status 	= (eff_status.equals(""))?"D":eff_status ;
			if(eff_status.equals("E"))
			{
				research_categ_desc=req.getParameter("research_categ_desc1");
				if(research_categ_desc == null) research_categ_desc="";
			}
			else
			{
				research_categ_desc=req.getParameter("research_categ_desc1");
				if(research_categ_desc == null) research_categ_desc="";
			}
			HashMap tabdata = new HashMap(); 
			tabdata.put("research_categ_id",research_categ_id);
			tabdata.put("research_categ_desc",research_categ_desc);
			tabdata.put("eff_status",eff_status);
			if(addedById == null) addedById="";
			if(addedDate == null) addedDate="";
			if(facilityId == null ) facilityId="";
			if(addedFacilityId == null ) addedFacilityId="";
			if(addedAtWorkstation == null) addedAtWorkstation="";
			if(modifiedById == null) modifiedById="";
			if(modifiedAtWorkstation == null || modifiedAtWorkstation.equals("null") )
				modifiedAtWorkstation="";
			tabdata.put("ADDED_BY_ID",addedById);
			tabdata.put("ADDED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("ADDED_FACILITY_ID", addedFacilityId);
			tabdata.put("ADDED_AT_WS_NO",addedAtWorkstation);
			tabdata.put("MODIFIED_BY_ID",modifiedById);
			tabdata.put("MODIFIED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("MODIFIED_FACILITY_ID",addedFacilityId);
			tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );
			HashMap condflds=new HashMap();
			condflds.put("research_categ_id",research_categ_id);
			
			/*Context context =  new InitialContext() ;
			Object homeObject = context.lookup("java:comp/env/SingleTabHandler");
			SingleTabHandlerManagerHome singleTabHandlerManagerHome=(SingleTabHandlerManagerHome)PortableRemoteObject.narrow(homeObject,
			SingleTabHandlerManagerHome.class);
			final SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singleTabHandlerManagerHome.create();
			final java.util.Hashtable results = singleTabHandlerManagerRemote.update(p,tabdata,condflds,"ca_research_category");*/
			
			boolean local_ejbs = false;
			String tabname="ca_research_category";
		
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

		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
		tabdata.clear();
		condflds.clear();
			
			boolean modified = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			if ( modified )
			{
				 error_value = "1" ;
			}
			results.clear();
	   		out.println("error:"+error);
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") +"&err_value="+error_value);
		}//end of try
		catch ( Exception e )
		{
			//out.println("<h3> Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : "+e.toString());//common-icn-0181
			e.printStackTrace();
		}
	}//end of modify
}
