/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAM;
/**
 *		FileName : TradeNameServlet.java
 *		Version	 : 3
 *		Date	 : 15-2-05	
**/

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import eCommon.XSSRequestWrapper;
import eCommon.SingleTabHandler.*;

public class TradeNameServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	java.util.Properties p;
	
	String facilityId ="";
	String client_ip_address="" ;
	String serviceURL="";
	
	String tradeid="";
	String longname="";
	String shortname="";
	String Manufacturer="";
	String drug = "";
	String effectiveStatus="" ;

	HttpSession session;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req= new XSSRequestWrapper(req);
		res.addHeader("X-XSS-Protection", "1; mode=block");
		res.addHeader("X-Content-Type-Options", "nosniff");
		res.setContentType("text/html");
		out = res.getWriter();
		session = req.getSession(false);
		p = (java.util.Properties) session.getValue( "jdbc" ) ;
		
		facilityId = (String) session.getValue( "facility_id" ) ;
		if(facilityId==null) facilityId="";
		
		client_ip_address = p.getProperty("client_ip_address");
		if(client_ip_address ==null) client_ip_address ="";
		
		serviceURL=(String) session.getValue("serviceURL");
		if(serviceURL==null) serviceURL="";


		try
		{			
			String operation = req.getParameter("function1");
			
			if ( operation.equals("insert"))   insertTradeName(req, res);
			if ( operation.equals("modify"))   modifyTradeName(req, res);
			
		}
		catch(Exception e)
		{
			out.println(e.toString());
		}
	}
	
	private void modifyTradeName(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			tradeid = req.getParameter("tradeid");
			if(tradeid==null) tradeid="";
			longname = req.getParameter("long_name");
			if(longname==null) longname="";
			shortname = req.getParameter("short_name");
			if(shortname==null) shortname="";
			drug = req.getParameter("drug");
			if(drug==null) drug="N";
			Manufacturer = req.getParameter("Manufacturer");
			if(Manufacturer==null) Manufacturer="";
			effectiveStatus = req.getParameter("eff_status");
			if ( effectiveStatus == null )
				effectiveStatus="D";

			String addedById = p.getProperty( "login_user" ) ;
			if(addedById==null) addedById="";
			String addedDate = dateFormat.format( new java.util.Date() ) ;
			if(addedDate ==null) addedDate="";
			String modifiedById = addedById ;
			if(modifiedById==null) modifiedById="";
			String modifiedDate = addedDate ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;
		

			HashMap tabdata=new HashMap();
				tabdata.put("EFF_STATUS",effectiveStatus);
				tabdata.put("TRADE_ID", tradeid);
				tabdata.put("LONG_NAME",longname);
				tabdata.put("SHORT_NAME",shortname);
				tabdata.put("MANUFACTURER_ID",Manufacturer);
				tabdata.put("DRUG_YN",drug);

				tabdata.put("MODIFIED_BY_ID",modifiedById);
				tabdata.put("MODIFIED_DATE",modifiedDate);
				tabdata.put("MODIFIED_AT_WS_NO", modifiedAtWorkstation);
				tabdata.put("MODIFIED_FACILITY_ID", modifiedFacilityId);

			HashMap condflds=new HashMap();
				condflds.put("TRADE_ID",tradeid);

			/*Context context =  new InitialContext();
			Object homeObject = context.lookup("java:comp/env/SingleTabHandler");
			SingleTabHandlerManagerHome singleTabHandlerManagerHome=(SingleTabHandlerManagerHome)PortableRemoteObject.narrow(homeObject,  SingleTabHandlerManagerHome.class);

			final SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singleTabHandlerManagerHome.create();

			final java.util.Hashtable results = singleTabHandlerManagerRemote.update(p,tabdata,condflds,"AM_TRADE_NAME");*/

			//Approach via the ServiceLocator and Reflection
			boolean local_ejbs = false;
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
		/*	Object argArray[] = new Object[4];
			String table_name="AM_TRADE_NAME";
			HashMap hashmap=new HashMap();
			hashmap.put("p",p);
			hashmap.put("tabdata",tabdata);
			hashmap.put("condflds",condflds);
			hashmap.put("table_name",table_name);

			argArray[0] = hashmap;
						
			Class [] paramArray = new Class[1];
			paramArray[0] = hashmap.getClass();*/


						Object argArray[] = new Object[4];
				//argArray[0] =hashmap;
				String table_name="AM_TRADE_NAME";
				argArray[0] =p;
				argArray[1] =tabdata;
				argArray[2] =condflds;
				argArray[3] =table_name;

				Class [] paramArray = new Class[4];
				//paramArray[0] =hashmap.getClass();
					paramArray[0] =p.getClass();
					paramArray[1] =tabdata.getClass();
					paramArray[2] =condflds.getClass();
					paramArray[3] =table_name.getClass();


			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error") ;
						String error_value = "0" ;
						if ( inserted )
						{
						 error_value = "1" ;
						}
						else
						{
						 error = (String) results.get("error") ;
						}

        	error = (String) results.get("error") ;
    		res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  )+"&err_value="+error_value );
			tabdata.clear();
			condflds.clear();
			results.clear();
		}
		
		catch ( Exception e )
		{
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			
			
		}
	}

	private void insertTradeName(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			tradeid = req.getParameter("tradeid");
			if(tradeid==null) tradeid="";
			longname = req.getParameter("long_name");
			if(longname==null) longname="";
			shortname = req.getParameter("short_name");
			if(shortname==null) shortname="";
			drug = req.getParameter("drug");
			if(drug==null) drug="N";
			Manufacturer = req.getParameter("Manufacturer");
			if(Manufacturer==null) Manufacturer="";
			effectiveStatus = req.getParameter("eff_status");
			if ( effectiveStatus == null )
				effectiveStatus="D";

			String addedById = p.getProperty( "login_user" ) ;
			if(addedById==null) addedById="";
			String addedDate = dateFormat.format( new java.util.Date() ) ;
			if(addedDate ==null) addedDate="";

			String modifiedById = addedById ;
			String modifiedDate = addedDate ;
			if(modifiedById==null) modifiedById="";
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			HashMap tabdata=new HashMap();
				tabdata.put("EFF_STATUS",effectiveStatus);
				tabdata.put("TRADE_ID", tradeid);
				tabdata.put("LONG_NAME",longname);
				tabdata.put("SHORT_NAME",shortname);
				tabdata.put("MANUFACTURER_ID",Manufacturer);
				tabdata.put("DRUG_YN",drug);
				
				tabdata.put("ADDED_BY_ID",addedById);
				tabdata.put("ADDED_DATE",addedDate);
				tabdata.put("ADDED_AT_WS_NO",addedAtWorkstation);
				tabdata.put("ADDED_FACILITY_ID",addedFacilityId);

				tabdata.put("MODIFIED_BY_ID",modifiedById);
				tabdata.put("MODIFIED_DATE",modifiedDate);
				tabdata.put("MODIFIED_AT_WS_NO", modifiedAtWorkstation);
				tabdata.put("MODIFIED_FACILITY_ID", modifiedFacilityId);

			String dupflds[]={"TRADE_ID"};

			/*Context context =  new InitialContext(  ) ;
			Object homeObject = context.lookup("java:comp/env/SingleTabHandler");
			SingleTabHandlerManagerHome singleTabHandlerManagerHome=(SingleTabHandlerManagerHome)PortableRemoteObject.narrow(homeObject,  SingleTabHandlerManagerHome.class);
			final SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singleTabHandlerManagerHome.create();

			final java.util.Hashtable results = singleTabHandlerManagerRemote.insert(p,tabdata,dupflds,"AM_TRADE_NAME");*/

			//Approach via the ServiceLocator and Reflection
			boolean local_ejbs = false;
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
		/*	Object argArray[] = new Object[4];
			String table_name="AM_TRADE_NAME";

			HashMap hashmap=new HashMap();
			hashmap.put("p",p);
			hashmap.put("tabdata",tabdata);
			hashmap.put("dupflds",dupflds);
			hashmap.put("table_name",table_name);

			argArray[0] = hashmap;
						
			Class [] paramArray = new Class[1];
			paramArray[0] = hashmap.getClass();*/


				Object argArray[] = new Object[4];
				//argArray[0] =hashmap;
				String table_name="AM_TRADE_NAME";		
				argArray[0] =p;
				argArray[1] =tabdata;
				argArray[2] =dupflds;
				argArray[3] =table_name;

				Class [] paramArray = new Class[4];
				//paramArray[0] =hashmap.getClass();
					paramArray[0] =p.getClass();
					paramArray[1] =tabdata.getClass();
					paramArray[2] =dupflds.getClass();
					paramArray[3] =table_name.getClass();


			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error") ;
						String error_value = "0" ;
						if ( inserted )
						{
						 error_value = "1" ;
						  res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  ) + "&err_value=" + error_value );
						}
						else
						{
						 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error ,"UTF-8" ) );
						}
						tabdata.clear();
						results.clear();

		}
		catch ( Exception e )
		{
			out.println("<h3> Exception raise by Servlet ...So Record Not Inserted </h3> Foll: Error Received : "+e.toString());
		}
	}

}
