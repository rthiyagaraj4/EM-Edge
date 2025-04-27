/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAM;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;

import eCommon.SingleTabHandler.*;

public class EquipmentOtherResourceTypesServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;

	java.util.Properties p;
	String client_ip_address ;

	String resource_class;
	String resource_type;
	String long_desc;
	String short_desc;
	String eff_status;
	String facilityId;

	HttpSession session;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		client_ip_address = p.getProperty("client_ip_address");

		try
		{
			res.setContentType("text/html");
			this.out = res.getWriter();
			String operation = req.getParameter("function");

			if ( operation.equals("insert") ) insertEqpOthResourceTypes(req, res);
			if ( operation.equals("modify"))  modifyEqpOthResourceTypes(req, res);
	
		}catch(Exception e)
		{
			out.println(e.toString());
		}
	}

	/*public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
	
	}*/

	/* The function modifyEqpOthResourceTypes() is used to update the records in the database table am_resource_type; this function is calling the EJB singleTabHandlerManagerRemote() in update mode with the modified values which are in hashtable,Long description,Short description and effective status and the database table where the values to be modified.  ---  Srijagadeesh, 6-8-2004. */

	private void modifyEqpOthResourceTypes(HttpServletRequest req, HttpServletResponse res)
	{

		try
		{
			resource_class = req.getParameter("resource_class");
			if(resource_class.equals("Equipment")) resource_class="E";
			  else resource_class="O";
			resource_type = req.getParameter("resource_type");
			long_desc = req.getParameter("long_desc");
			short_desc = req.getParameter("short_desc");
			eff_status = req.getParameter("eff_status");
			if(eff_status==null) eff_status="D";

			String addedById = p.getProperty( "login_user" ) ;
			String addedDate = dateFormat.format( new java.util.Date() ) ;
			String modifiedById = addedById ;
			String modifiedDate = addedDate ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;
			//java.sql.Date added_date = java.sql.Date.valueOf( addedDate ) ;
			java.sql.Date modified_date = java.sql.Date.valueOf( modifiedDate ) ;

			HashMap tabdata=new HashMap();

			tabdata.put("resource_class",resource_class);
			tabdata.put("resource_type",resource_type);
			tabdata.put("long_desc",long_desc);
			tabdata.put("short_desc",short_desc);
			tabdata.put("eff_status",eff_status);

			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",modified_date);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

			HashMap condflds=new HashMap();
			condflds.put("resource_class",resource_class);
			condflds.put("resource_type",resource_type);

		/*	java.util.HashMap env = (java.util.HashMap)session.getValue("env");
			env.put( Context.URL_PKG_PREFIXES, "oracle.aurora.jndi" ) ;*/

			/*InitialContext context = new InitialContext();
			Object homeObject = context.lookup("java:comp/env/SingleTabHandler");
			SingleTabHandlerManagerHome singleTabHandlerManagerHome  = (SingleTabHandlerManagerHome) PortableRemoteObject.narrow(homeObject ,SingleTabHandlerManagerHome.class);
			SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singleTabHandlerManagerHome.create();
			java.util.Hashtable results = singleTabHandlerManagerRemote.update(p,tabdata,condflds,"am_resource_type"); */


			 boolean local_ejbs = false;
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);



			/*HashMap hashmap = new HashMap();
				hashmap.put("p",p);
				hashmap.put("tabdata",tabdata);
				hashmap.put("condflds",condflds);
					String table_name="am_resource_type";
				hashmap.put("table_name",table_name);
				
				Object argArray[] = new Object[1];
				argArray[0] =hashmap;
			
			

				Class [] paramArray = new Class[1];
				paramArray[0] =hashmap.getClass();*/


						Object argArray[] = new Object[4];
				//argArray[0] =hashmap;
				argArray[0] =p;
				argArray[1] =tabdata;
				argArray[2] =condflds;
				String table_name="am_resource_type";
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
				 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  ) + "&err_value=" + error_value );
			}
			else
			{
				 error = (String) results.get("error") ;
				 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8"  ) );
			}
			tabdata.clear();
            condflds.clear();
			results.clear();

		}catch(Exception e)
		{
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			out.println(resource_class+"|"+resource_type+"|"+long_desc+"|"+short_desc+"|"+eff_status+"<br>");
		}
	
	}

	/* The function insertEqpOthResourceTypes() is used to insert records in the database table am_resource_type; this function is calling the EJB singleTabHandlerManagerRemote() in insert mode with the values which are in hashtable,resource class,resource type, long description, short description, effective status and the database table where the values to be inserted.  ---  Srijagadeesh, 6-8-2004. */
	
	private void insertEqpOthResourceTypes(HttpServletRequest req, HttpServletResponse res)
	{

		try
		{
			resource_class = req.getParameter("resource_class");
			resource_type = req.getParameter("resource_type");
			long_desc = req.getParameter("long_desc");
			short_desc = req.getParameter("short_desc");
			eff_status = req.getParameter("eff_status");
			if(eff_status==null) eff_status="D";

			String addedById = p.getProperty( "login_user" ) ;
			String addedDate = dateFormat.format( new java.util.Date() ) ;
			String modifiedById = addedById ;
			String modifiedDate = addedDate ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;
			java.sql.Date added_date = java.sql.Date.valueOf( addedDate ) ;
			java.sql.Date modified_date = java.sql.Date.valueOf( modifiedDate ) ;

			HashMap tabdata=new HashMap();

			
			tabdata.put("resource_class",resource_class);
			tabdata.put("resource_type",resource_type);
			tabdata.put("long_desc",long_desc);
			tabdata.put("short_desc",short_desc);
			tabdata.put("eff_status",eff_status);

			tabdata.put("added_by_id",addedById);
			tabdata.put("added_date",added_date);
			tabdata.put("added_facility_id", facilityId);
			tabdata.put("added_at_ws_no",addedAtWorkstation);

			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",modified_date);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

			String dupflds[]={"resource_class","resource_type"};


		/*	InitialContext context = new InitialContext();
			Object homeObject = context.lookup("java:comp/env/SingleTabHandler");
			SingleTabHandlerManagerHome singleTabHandlerManagerHome  = (SingleTabHandlerManagerHome) PortableRemoteObject.narrow(homeObject ,SingleTabHandlerManagerHome.class);
			SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singleTabHandlerManagerHome.create();
			java.util.Hashtable results = singleTabHandlerManagerRemote.insert(p,tabdata,dupflds,"am_resource_type"); */


			 boolean local_ejbs = false;
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);



			
			/*	HashMap hashmap = new HashMap();
				hashmap.put("p",p);
				hashmap.put("tabdata",tabdata);
				hashmap.put("dupflds",dupflds);
				String table_name="am_resource_type";
				hashmap.put("table_name",table_name);
				
				Object argArray[] = new Object[1];
				argArray[0] =hashmap;
			
			

				Class [] paramArray = new Class[1];
				paramArray[0] =hashmap.getClass();*/

					Object argArray[] = new Object[4];
				//argArray[0] =hashmap;
					String table_name="am_resource_type";
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
				 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8" ) + "&err_value=" + error_value );
				 
			}
			else
			{
				 error = (String) results.get("error") ;
				 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8"  ) );
				
			}
			tabdata.clear();
            results.clear();
		}
		catch(Exception e)
		{
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			out.println(resource_class+"|"+resource_type+"|"+long_desc+"|"+short_desc+"|"+eff_status+"<br>");
		}
	}
}
