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

public class CADefineMenuServlet extends javax.servlet.http.HttpServlet
{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		PrintWriter out = null;
						   	       
		try
		{
			out = res.getWriter();

			String mode =(req.getParameter("mode")==null)?"":req.getParameter("mode");
			
			if (mode.trim().equalsIgnoreCase("insert"))   insert(req, res, out);
			if (mode.trim().equalsIgnoreCase("modify"))   modify(req, res, out);
		}
		catch(Exception e)
		{
			out.println(e.toString());
			e.printStackTrace();
		}
	}

	private String getMessage(String locale, String messageId, String moduleId)
	{
		java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
		return(mesg) ;
	}


	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		try
		{
			out = res.getWriter();
			doPost(req, res);		
		}
		catch(Exception e)	
		{	
			out.println("Exception in invoking doPost Method");
			e.printStackTrace();
		}
	}
	/********************************** insert *************************************/

	private void insert(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
	{
		java.util.Properties p;

		String menu_id						= "";
		String root_menu_yn					= "";
		String short_desc					= "";
		String long_desc					= "";	
		String eff_status					= "";
		String desktop_yn					= "";
		String paitent_chart				= "";

		String facilityId					="";
		String client_ip_address			= "";
		String addedById					= "";
		String addedDate					= "";
		String addedAtWorkstation	 		= "";
		String addedFacilityId				= "";
		String modifiedById					= "";
		String modifiedAtWorkstation		= "";
		
		HttpSession session;
		session = req.getSession(false);

		p						= (Properties)session.getValue("jdbc") ;
		String locale			= (String) p.getProperty("LOCALE");
		facilityId				= (String)session.getValue( "facility_id" ) ;
		client_ip_address		= p.getProperty("client_ip_address");
		modifiedById			= (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;           
		modifiedAtWorkstation   = (client_ip_address==null)?"":client_ip_address;           

		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
		
		try
		{
			addedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;
			addedDate = dateFormat.format( new java.util.Date() ) ;
			addedFacilityId		= (facilityId == null)?"":facilityId;  
			addedAtWorkstation	= (client_ip_address == null)?"":client_ip_address; 
			menu_id=req.getParameter("menu_id");

			if(menu_id == null)
				menu_id="";
			
			root_menu_yn=req.getParameter("root_menu_yn");
			
			if(root_menu_yn == null)
				root_menu_yn="";
			
			root_menu_yn 	= (root_menu_yn.equals(""))?"N":root_menu_yn ;
			
			short_desc=req.getParameter("short_desc");
			
			if(short_desc == null)
				short_desc="";
			long_desc=req.getParameter("long_desc");
			
			if(long_desc == null)
				long_desc="";
			
			eff_status=req.getParameter("eff_status");
			
			if(eff_status == null)
				eff_status="";
			
			eff_status 	= (eff_status.equals(""))?"D":eff_status ;
			
			desktop_yn=req.getParameter("desktop_yn");
			
			if(desktop_yn == null)
				desktop_yn="";
			desktop_yn 	= (desktop_yn.equals(""))?"N":desktop_yn ;
			
			paitent_chart=req.getParameter("paitent_chart");
			
			if(paitent_chart == null)
				paitent_chart="";
			
			paitent_chart 	= (paitent_chart.equals(""))?"N":paitent_chart ;

			HashMap tabdata = new HashMap(); 				
			tabdata.put("MENU_ID",menu_id);
			tabdata.put("ROOT_MENU_YN",root_menu_yn);
			tabdata.put("SHORT_DESC",short_desc);
			tabdata.put("LONG_DESC",long_desc);
			tabdata.put("EFF_STATUS",eff_status);
			tabdata.put("DESKTOP_YN",desktop_yn);
			tabdata.put("PATIENT_CHART_YN",paitent_chart);
			
			if(addedById == null)			addedById="";
			if(addedDate == null)			addedDate="";
			if(facilityId == null)			facilityId="";
			if(addedFacilityId == null)		addedFacilityId="";
			if(addedAtWorkstation == null)	addedAtWorkstation="";
			if(modifiedById == null)		modifiedById="";
			
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
		
			String dupflds[]={"MENU_ID"};
			
			boolean local_ejbs = false;

			String tablename = "ca_menu_header";
			
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = dupflds;
			argArray[3] = tablename;

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = dupflds.getClass();
			paramArray[3] = tablename.getClass();

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			argArray = null;
			paramArray = null;
			tabdata.clear();

			boolean inserted = ( ((Boolean) results.get("status")).booleanValue() ) ;

			String error_value = "0" ;
			String error = "";
			
			if ( inserted )
			{
				error_value = "1" ;
				error = getMessage(locale, "RECORD_INSERTED","CA");
			}
			else
				error = (String) results.get("error") ;

			results.clear();

			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") +"&err_value="+error_value);
		}
		catch ( Exception e )
		{
			//out.println("<h3> Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : "+e.toString());//common-icn-0181
			e.printStackTrace();
		}
	}

/***************************** modify ****************************************/

	private void modify(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
	{
		java.util.Properties p;

		String menu_id						= "";
		String root_menu_yn					= "";
		String short_desc					= "";
		String long_desc					= "";	
		String eff_status					= "";
		String desktop_yn					= "";
		String paitent_chart				="";
		String facilityId					="";
		String client_ip_address			= "";
		String addedById					= "";
		String addedDate					= "";
		String addedAtWorkstation	 		= "";
		String addedFacilityId				= "";
		String modifiedById					= "";
		String modifiedAtWorkstation		= "";
		

		HttpSession session;
		
		session					= req.getSession(false);
		p						= (Properties)session.getValue("jdbc") ;
		facilityId				= (String)session.getValue( "facility_id" ) ;
		client_ip_address		= p.getProperty("client_ip_address");
		modifiedById			= (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;           
		modifiedAtWorkstation   = (client_ip_address==null)?"":client_ip_address;           

		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
		try
		{
			addedById				= (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;
			addedDate				= dateFormat.format( new java.util.Date() ) ;
			addedFacilityId			= (facilityId == null)?"":facilityId;  
			addedAtWorkstation		= (client_ip_address == null)?"":client_ip_address; 

			menu_id=req.getParameter("menu_id1");
			
			if(menu_id == null)	menu_id="";
			
			root_menu_yn=req.getParameter("root_menu_yn");
			
			if(root_menu_yn == null)	root_menu_yn="N";

			short_desc=req.getParameter("short_desc");
			
			if(short_desc == null)
				short_desc="";
			
			long_desc=req.getParameter("long_desc");
			
			if(long_desc == null)
				long_desc="";
			
			eff_status=req.getParameter("eff_status");
			
			if(eff_status == null)
				eff_status="";
			
			eff_status 	= (eff_status.equals(""))?"D":eff_status ;
			
			desktop_yn ="";
			
			desktop_yn=req.getParameter("desktop_yn");
			
			if(desktop_yn == null)
				desktop_yn="";
			
			desktop_yn 	= (desktop_yn.equals(""))?"N":desktop_yn ;

			paitent_chart="";
			
			paitent_chart=req.getParameter("paitent_chart");
			
			if(paitent_chart == null)
				paitent_chart="";
			
			paitent_chart 	= (paitent_chart.equals(""))?"N":paitent_chart ;
			
			HashMap tabdata = new HashMap();
			
			tabdata.put("MENU_ID",menu_id);
			tabdata.put("ROOT_MENU_YN",root_menu_yn);
			tabdata.put("SHORT_DESC",short_desc);
			tabdata.put("LONG_DESC",long_desc);
			tabdata.put("EFF_STATUS",eff_status);
			tabdata.put("DESKTOP_YN",desktop_yn);
			tabdata.put("PATIENT_CHART_YN",paitent_chart);
			
			if(addedDate == null)
				addedDate="";
			
			if(facilityId == null)
				facilityId="";
			
			if(addedFacilityId == null)
				addedFacilityId="";
			
			if(addedAtWorkstation == null)
				addedAtWorkstation="";
			
			if(modifiedById == null  )
				modifiedById="";
			
			if(modifiedAtWorkstation == null)
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
			condflds.put("menu_id",menu_id);
			
			
			boolean local_ejbs = false;
			
			String tablename = "ca_menu_header";

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = condflds;
			argArray[3] = tablename;

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = condflds.getClass();
			paramArray[3] = tablename.getClass();

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
	
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			argArray = null;
			paramArray = null;
			tabdata.clear();
			condflds.clear();

			boolean modified = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error") ;
			String error_value = "0" ;
			
			if ( modified )
				 error_value = "1" ;

			results.clear();
			
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+error_value);
		}//end of try
		catch ( Exception e )
		{
			//out.println("<h3> Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : "+e.toString());//common-icn-0181
			e.printStackTrace();
		}
	}//end of modify
}//end 
