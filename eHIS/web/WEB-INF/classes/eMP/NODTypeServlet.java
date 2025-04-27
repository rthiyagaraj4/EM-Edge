/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/****** Last Modified Date Time 9/22/2005 11:25 AM *****/
package eMP;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;

import eCommon.SingleTabHandler.*;

import eCommon.XSSRequestWrapper;//Added by Kamatchi S for security issue against COMMON-ICN-0187

public class NODTypeServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	java.util.Properties p;
	
	String nodtype;
	String longdesc ;
	String shortdesc ;
	String effstatus ;
	String client_ip_address ;
    String facilityId;
    String delivery_indicator;
	
	HttpSession session;
	
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
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			//Added by Kamatchi S for security issue against COMMON-ICN-0187
			req = new XSSRequestWrapper(req);
			res.addHeader("X-XSS-Protection", "1; mode=block");
			res.addHeader("X-Content-Type-Options", "nosniff");
			//Added by Kamatchi S for security issue against COMMON-ICN-0187 END
			this.out = res.getWriter();
			String operation = req.getParameter("function_name");

			if ( operation.equals("insert")) insertNODType(req, res);
			if ( operation.equals("modify")) modifyNODType(req, res);
		}
		catch(Exception e)
		{
			//out.println(e.toString());
			e.printStackTrace();
		}
	}

	private void modifyNODType(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			nodtype=req.getParameter("nod_type");
			longdesc = req.getParameter("long_desc");
			shortdesc = req.getParameter("short_desc");
			effstatus = req.getParameter("eff_status");
			delivery_indicator = req.getParameter("DELIVERY_INDICATOR");
			
			if ( effstatus == null || effstatus.equals("null"))
				effstatus="D";
			
			String addedById = p.getProperty( "login_user" ) ;
			String modifiedById = addedById ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;
			
				HashMap tabdata=new HashMap();
				tabdata.put("long_desc",longdesc);
				tabdata.put("short_desc",shortdesc);
				tabdata.put("eff_status",effstatus);

				tabdata.put("modified_by_id",modifiedById);
				tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
				tabdata.put("modified_facility_id",modifiedFacilityId);
				tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
				tabdata.put("DELIVERY_INDICATOR",delivery_indicator );

				HashMap condflds=new HashMap();
				condflds.put("nod_type",nodtype);

			boolean local_ejbs = isLocalEJB();
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = condflds;
			argArray[3] = "MP_NOD_TYPE";

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass(); ;
			paramArray[1] = tabdata.getClass();
			paramArray[2] = condflds.getClass();
			paramArray[3] = String.class;
			
			java.util.HashMap results = (HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			
			argArray = null;
			paramArray = null;
			tabdata.clear();
			
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error") ;
			String error_value = "0" ;
			condflds.clear();
			results.clear();
			if ( inserted )
			{
			 error_value = "1" ;
			 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8") + "&err_value=" + error_value );
			}
			else
			{
			 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error, "UTF-8") );
			}
			
		}
		catch ( Exception e )
		{
			/* out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			out.println( nodtype+ " "+shortdesc + " "+effstatus); */
			e.printStackTrace();
		}
	}

	private void insertNODType(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			nodtype=req.getParameter("nod_type");
			longdesc = req.getParameter("long_desc");
			shortdesc = req.getParameter("short_desc");
			effstatus = req.getParameter("eff_status");
			delivery_indicator = req.getParameter("DELIVERY_INDICATOR");
			if ( effstatus == null || effstatus.equals("null"))
				effstatus="D";

			String addedById = p.getProperty( "login_user" ) ;
			String modifiedById = addedById ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

				HashMap tabdata=new HashMap();
				tabdata.put("nod_type",nodtype);
				tabdata.put("long_desc",longdesc);
				tabdata.put("short_desc",shortdesc);
				tabdata.put("eff_status",effstatus);

				tabdata.put("added_by_id",addedById);
				tabdata.put("added_date",new  java.sql.Timestamp(System.currentTimeMillis()));
				tabdata.put("added_facility_id", facilityId);
				tabdata.put("added_at_ws_no",addedAtWorkstation);
				tabdata.put("modified_by_id",modifiedById);
				tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
				tabdata.put("modified_facility_id",modifiedFacilityId);
				tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
				tabdata.put("DELIVERY_INDICATOR",delivery_indicator );

				String dupflds[]={"nod_type"};

			boolean local_ejbs = isLocalEJB();
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = dupflds;
			argArray[3] = "mp_nod_type";

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass(); ;
			paramArray[1] = tabdata.getClass();
			paramArray[2] = dupflds.getClass();
			paramArray[3] = String.class;
			
			java.util.HashMap results = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			
			argArray = null;
			paramArray = null;
			tabdata.clear();

			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error") ;
			String error_value = "0" ;
			results.clear();
			if ( inserted )
			{
				error_value = "1" ;
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8") + "&err_value=" + error_value );
			}
			else
			{
				
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error, "UTF-8") );
			}
			
			}
			catch ( Exception e )
			{
				/* out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
				out.println( "Values sent are : <br>" ) ;
				out.println( nodtype+ " "+longdesc + " "+shortdesc + " "+ effstatus ); */
				e.printStackTrace();
		}
	}
	
	boolean isLocalEJB(){
		ServletContext context = getServletConfig().getServletContext();
		if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			return true;
		else
			return false;
	}
}
