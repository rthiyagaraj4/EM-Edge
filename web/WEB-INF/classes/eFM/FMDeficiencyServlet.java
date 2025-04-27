/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eFM;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import eCommon.SingleTabHandler.*;

public class FMDeficiencyServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	PrintWriter out;	
	java.util.Properties p;
	String deficiency_code="", long_desc="", short_desc="", eff_status="";
	String facilityId ="";
	String client_ip_address="" ;	
	HttpSession session;	
	String locale			= "" ;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		locale = p.getProperty("LOCALE");
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		this.client_ip_address =  p.getProperty("client_ip_address");		

		try
		{
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			String operation = req.getParameter("operation");
			

			if ( operation.equals("insert") )   insertFMDeficiency(req, res, locale);
			if ( operation.equals("modify"))    modifyFMDeficiency(req, res, locale);


		}
		catch(Exception e)
		{
			out.println(e.toString());
		}
	}

	private void modifyFMDeficiency(HttpServletRequest req, HttpServletResponse res, String locale)
	{
		try
		{
			deficiency_code	=	req.getParameter("deficiency_code");
			long_desc		=	req.getParameter("long_desc");
			short_desc		=	req.getParameter("short_desc");
			eff_status		=	req.getParameter("eff_status");

			if ( eff_status == null )
				eff_status="D";

			String addedById = p.getProperty( "login_user" ) ;		
			String modifiedById = addedById ;		
			String modifiedFacilityId = facilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			HashMap tabdata=new HashMap();
			tabdata.put("long_desc",long_desc);
			tabdata.put("short_desc",short_desc);
			tabdata.put("eff_status",eff_status);			
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
			//tabdata.put("locale",locale );

			HashMap condflds=new HashMap();
			condflds.put("deficiency_code",deficiency_code);
			String table_name ="fm_deficiency";

			
			boolean local_ejbs = false;
			if((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
				
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Object argArray[] = new Object[4];
				argArray[0] = p;
				argArray[1] = tabdata;
				argArray[2] = condflds;
				argArray[3] = table_name;
					
					
			Class [] paramArray = new Class[4];
				paramArray[0] = p.getClass();
				paramArray[1] = tabdata.getClass();
				paramArray[2] = condflds.getClass();
				paramArray[3] = table_name.getClass();
					
					
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
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
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
			}
			else
			{
				// Line commented to fix null pointer exception against IN017659 on 28/12/2009 by Ganesh P
				// error = (String) results.get("error") ;
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" ) );
			}
			
		}
		catch ( Exception e )
		{
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			out.println( deficiency_code+ " "+long_desc + " "+short_desc + " "+ eff_status );
			out.println(e.toString());
		}
	}

    private void insertFMDeficiency(HttpServletRequest req, HttpServletResponse res, String locale)
	{
		try
		{
			deficiency_code=req.getParameter("deficiency_code");
			long_desc = req.getParameter("long_desc");
			short_desc = req.getParameter("short_desc");
			eff_status = req.getParameter("eff_status");
				
			if ( deficiency_code == null )
				deficiency_code="";
			if ( long_desc == null )
				long_desc="";
			if ( short_desc == null )
				short_desc="";
			if ( eff_status == null )
				eff_status="D";

			String addedById = p.getProperty( "login_user" ) ;
			String modifiedById = addedById ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			HashMap tabdata=new HashMap();
			tabdata.put("deficiency_code",deficiency_code);
			tabdata.put("long_desc",long_desc);
			tabdata.put("short_desc",short_desc);
			tabdata.put("eff_status",eff_status);

			tabdata.put("added_by_id",addedById);
			tabdata.put("added_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("added_facility_id", facilityId);
			tabdata.put("added_at_ws_no",addedAtWorkstation);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
			//tabdata.put("locale",locale );

			String dupflds[]={"deficiency_code"};
			String table_name ="fm_deficiency";

        
			boolean local_ejbs = false;
			if((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
					
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
		
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
				Object argArray[] = new Object[4];
					argArray[0] = p;
					argArray[1] = tabdata;
					argArray[2] = dupflds;
					argArray[3] = table_name;
										
				Class [] paramArray = new Class[4];
					paramArray[0] = p.getClass();
					paramArray[1] = tabdata.getClass();
					paramArray[2] = dupflds.getClass();
					paramArray[3] = table_name.getClass();

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
		
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value="0";
			tabdata.clear();			
			results.clear();

			if (inserted)
			{
				error_value = "1" ;
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
			}	
			else
			{
				// Line commented to fix null pointer exception against IN017659 on 28/12/2009 by Ganesh P
				//	error = (String) results.get("error") ;
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode(error,"UTF-8" ) );
			}
		}
		catch ( Exception e )
		{
			out.println("<h3> Exception raise by Servlet ...So Record Not Created </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			out.println( deficiency_code+ " "+long_desc + " "+short_desc +" "+ eff_status );
			out.println(e.toString());
		}
	}
}



