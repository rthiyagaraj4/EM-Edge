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
 *		FileName : ServiceServlet.java
 *		Version	 : 3
 *		Date	 : 14-2-05	
**/

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.net.*;

import eCommon.SingleTabHandler.*;

public class ServiceServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;

	String ancillaryyn;
	String medicalyn;
	String servicecode;
	String longDesc ;
	String shortDesc ;
	String effectiveStatus ;
	String facilityId ;
	String client_ip_address ;
	//String serviceURL;
	//String objectName;
	java.util.Properties p;
	HttpSession session;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		session = req.getSession(false);		
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");
		
		try
		{
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			String operation = req.getParameter("function");
			
			if ( operation.equals("insert") )   insertService(req, res);
			if ( operation.equals("modify"))    modifyService(req, res);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}



	private void modifyService(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			servicecode=req.getParameter("service_code");
			longDesc  = req.getParameter("long_desc");
			shortDesc = req.getParameter("short_desc");
			medicalyn = req.getParameter("medical_yn");
			if ( medicalyn==null)
				 medicalyn="N";

			ancillaryyn = req.getParameter("ancillary_yn");
			if ( ancillaryyn==null )
			     ancillaryyn="N";

			effectiveStatus = req.getParameter("eff_status");
			if ( effectiveStatus == null )
				 effectiveStatus="D";

			String addedById = p.getProperty( "login_user" ) ;
			String addedDate = dateFormat.format( new java.util.Date() ) ;
			String modifiedById = addedById ;
			String modifiedDate = addedDate ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			java.sql.Date modified_date1 = java.sql.Date.valueOf( modifiedDate ) ;
			java.sql.Date modified_date = new java.sql.Date(modified_date1.parse(modified_date1.toLocaleString())-(modified_date1.getTimezoneOffset()*60*1000) ) ;

			HashMap tabdata=new HashMap();
			tabdata.put("service_code",servicecode);
			tabdata.put("long_desc",longDesc);
			tabdata.put("short_desc",shortDesc);
			tabdata.put("medical_yn",medicalyn);
			tabdata.put("ancillary_yn",ancillaryyn);
			tabdata.put("eff_status",effectiveStatus);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",modified_date);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

			HashMap condflds=new HashMap();
			condflds.put("service_code",servicecode);

			
			/*InitialContext context = new InitialContext();
			Object homeObject = context.lookup("java:comp/env/SingleTabHandler");
			final SingleTabHandlerManagerHome singleTabHandlerManagerHome  = (SingleTabHandlerManagerHome) PortableRemoteObject.narrow(homeObject ,SingleTabHandlerManagerHome.class);
			final SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singleTabHandlerManagerHome.create();
			final java.util.HashMap results = singleTabHandlerManagerRemote.update(p,tabdata,condflds,"am_service");*/

			//Approach via the ServiceLocator and Reflection
			boolean local_ejbs = false;
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
		/*	Object argArray[] = new Object[1];
			String table_name="am_service";

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
				String table_name="am_service";
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
					 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8") + "&err_value=" + error_value );
				}
				else
				{
					 error = (String) results.get("error") ;
					 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8") );
				}
				tabdata.clear();
			condflds.clear();
			results.clear();
		}
		catch ( Exception e )
		{
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			out.println( servicecode+ " "+longDesc + " "+shortDesc + " "+ effectiveStatus );
		}
	}

	private void insertService(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			servicecode=req.getParameter("service_code");
			longDesc  = req.getParameter("long_desc");
			shortDesc = req.getParameter("short_desc");
			medicalyn = req.getParameter("medical_yn");
			if ( medicalyn==null)
				 medicalyn="N";
			ancillaryyn = req.getParameter("ancillary_yn");
			if ( ancillaryyn == null )
				 ancillaryyn="N";
			effectiveStatus = req.getParameter("eff_status");
			if ( effectiveStatus == null )
				 effectiveStatus="D";

			String addedById = p.getProperty( "login_user" ) ;
			String addedDate = dateFormat.format( new java.util.Date() ) ;
			String modifiedById = addedById ;
			String modifiedDate = addedDate ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			java.sql.Date added_date1 = java.sql.Date.valueOf( addedDate ) ;
			java.sql.Date modified_date1 = java.sql.Date.valueOf(modifiedDate ) ;

			java.sql.Date added_date = new java.sql.Date(added_date1.parse(added_date1.toLocaleString())-(added_date1.getTimezoneOffset()*60*1000) ) ;
			java.sql.Date modified_date = new java.sql.Date(modified_date1.parse(modified_date1.toLocaleString())-(modified_date1.getTimezoneOffset()*60*1000) ) ;

			HashMap tabdata=new HashMap();
			tabdata.put("service_code",servicecode);
			tabdata.put("long_desc",longDesc);
			tabdata.put("short_desc",shortDesc);
			tabdata.put("medical_yn",medicalyn);
			tabdata.put("ancillary_yn",ancillaryyn);
			tabdata.put("eff_status",effectiveStatus);
			tabdata.put("added_by_id",addedById);
			tabdata.put("added_date",added_date);
			tabdata.put("added_facility_id", facilityId);
			tabdata.put("added_at_ws_no",addedAtWorkstation);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",modified_date);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

			String dupflds[]={"service_code"};

		
			/*InitialContext context = new InitialContext();
			Object homeObject = context.lookup("java:comp/env/SingleTabHandler");
			final SingleTabHandlerManagerHome singleTabHandlerManagerHome  = (SingleTabHandlerManagerHome) PortableRemoteObject.narrow(homeObject ,SingleTabHandlerManagerHome.class);
			final SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singleTabHandlerManagerHome.create();
			final java.util.HashMap results = singleTabHandlerManagerRemote.insert(p,tabdata,dupflds,"am_service");*/


			//Approach via the ServiceLocator and Reflection
			boolean local_ejbs = false;
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
		/*	Object argArray[] = new Object[1];
			String table_name="am_service";

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
					String table_name="am_service";
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
			     res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
			}
			else
			{
			     error = (String) results.get("error") ;
			     res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" ) );
			}
			tabdata.clear();
			results.clear();
		}
		catch ( Exception e )
		{
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			out.println( servicecode+ " "+longDesc + " "+shortDesc +" "+medicalyn+" "+ ancillaryyn+" "+ effectiveStatus );
		}
	}

}
