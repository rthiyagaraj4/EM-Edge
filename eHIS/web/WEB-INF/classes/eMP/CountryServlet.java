/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/***** Last Modified Date 9/22/2005 11:13 AM *******/
package eMP;

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

public class CountryServlet extends HttpServlet	
{
	PrintWriter out;
	java.util.Properties p;

	String countrycode;
	String longName ;
	String shortName ;
	String longDesc ;
	String effectiveDateFrom ;
	String effectiveDateTo ;
	String effectiveStatus ;
	String facilityId ;
	String client_ip_address ;
	//<!--added by Himanshu Saxena for ML-MMOH-CRF-1930 (U3) on 19-04-2023  -->
	String telephone_country_code;

	public void init(ServletConfig servletconfig) throws ServletException
	{
		super.init(servletconfig);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
        throws javax.servlet.ServletException,IOException
	{
		HttpSession session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		client_ip_address			= p.getProperty("client_ip_address");
	
		try
		{
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			req = new XSSRequestWrapper(req);
			this.out = res.getWriter();
			String operation = req.getParameter("function");

			if ( operation.equals("insert") )
				insertCountry(req, res);
			if ( operation.equals("modify"))
				modifyCountry(req, res);
		}
		catch (Exception e)
		{
			out.println(e.toString());
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res)
 	throws javax.servlet.ServletException,IOException
	{
		try
		{
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();						
			String url = "../eCommon/jsp/MstCodeToolbar.jsp?" ;
			String params = req.getQueryString() ;
			String source = url + params ;
			
			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script language='javascript' src='../eMP/js/Country.js'></script></head><frameset rows='42,*,50'><frame name='commontoolbarFrame'	src='"+source+"' frameborder=0 scrolling='no' noresize> <frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame'	src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
		}
		catch(Exception e)	{	}
	}

	private void modifyCountry(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			countrycode		= req.getParameter("country_code");
			longName		= req.getParameter("long_name");
			shortName		= req.getParameter("short_name");
			longDesc		= req.getParameter("long_desc");
			
			//<!--added by Himanshu Saxena for ML-MMOH-CRF-1930 (U3) on 19-04-2023  -->
			telephone_country_code    = req.getParameter("telephone_country_code");
			
			effectiveStatus = req.getParameter("eff_status");
			if ( effectiveStatus == null )
				effectiveStatus="D";

			String addedById = p.getProperty( "login_user" ) ;
			
			String modifiedById = addedById ;

			String modifiedFacilityId = facilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			HashMap tabdata=new HashMap();
			tabdata.put("long_name",longName);
			tabdata.put("short_name",shortName);
			tabdata.put("long_desc",longDesc);
			tabdata.put("eff_status",effectiveStatus);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
			
			//<!--added by Himanshu Saxena for ML-MMOH-CRF-1930 (U3) on 19-04-2023  -->
			tabdata.put("TELEPHONE_CODE",telephone_country_code );

			HashMap condflds=new HashMap();
			condflds.put("COUNTRY_CODE",countrycode);

			boolean local_ejbs = isLocalEJB();
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = condflds;
			argArray[3] = "MP_COUNTRY";

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass(); ;
			paramArray[1] = tabdata.getClass();
			paramArray[2] = condflds.getClass();
			paramArray[3] = String.class;
			
			java.util.HashMap results = (HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			tabdata.clear();
			condflds.clear();
			results.clear();

			if ( inserted )
			{
				 error_value = "1" ;
				 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8") + "&err_value=" + error_value );
			}
			else
			{
				 
				 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode( error,"UTF-8" ) );
			}

			
		}
		catch ( Exception e )
		{
			// out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			// out.println( "Values sent are : <br>" ) ;
			// out.println( countrycode + " "+longName + " "+shortName+" "+longDesc +" "+ effectiveDateFrom+" "+ effectiveDateTo + " "+ effectiveStatus );
			e.printStackTrace(); // Added by lakshmanan for security issue ID 169529918 on 12-09-2023
		}
	}

	private void insertCountry(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			countrycode		= req.getParameter("country_code");
			longName		= req.getParameter("long_name");
			shortName		= req.getParameter("short_name");
			longDesc		= req.getParameter("long_desc");
			effectiveStatus = req.getParameter("eff_status");

			//<!--added by Himanshu Saxena for ML-MMOH-CRF-1930 (U3) on 19-04-2023  -->
			telephone_country_code    = req.getParameter("telephone_country_code");

			if ( effectiveStatus == null )
					effectiveStatus="D";

			String addedById = p.getProperty( "login_user" ) ;
			String modifiedById = addedById ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			HashMap tabdata=new HashMap();
			tabdata.put("country_code",countrycode);
			tabdata.put("long_name",longName);
			tabdata.put("short_name",shortName);
			tabdata.put("long_desc",longDesc);
			tabdata.put("eff_status",effectiveStatus);
			tabdata.put("added_by_id",addedById);
			tabdata.put("added_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("added_facility_id", facilityId);
			tabdata.put("added_at_ws_no",addedAtWorkstation);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
			
			//<!--added by Himanshu Saxena for ML-MMOH-CRF-1930 (U3) on 19-04-2023  -->
			tabdata.put("TELEPHONE_CODE",telephone_country_code );

			String dupflds[]={"country_code"};

			boolean local_ejbs = isLocalEJB();
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = dupflds;
			argArray[3] = "MP_COUNTRY";

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass(); ;
			paramArray[1] = tabdata.getClass();
			paramArray[2] = dupflds.getClass();
			paramArray[3] = String.class;
			
			java.util.HashMap results = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
		
			tabdata.clear();
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error") ;
			String error_value = "0" ;
			results.clear();
			if ( inserted )
			{
				 error_value = "1" ;
				 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
			}
			else
			{
				 
				 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" ) );
			}

			
		}
		catch ( Exception e )
		{
			//out.println("<h3> Exception raise by Servlet ...So Record Not Inserted </h3> Foll: Error Received : "+e.toString());

			//out.println( countrycode + " "+longName+" "+shortName+" "+longDesc +"  "+ effectiveStatus);
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
