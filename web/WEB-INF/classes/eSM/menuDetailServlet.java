/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSM;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.net.URLEncoder;
import eSM.menuDetail.* ;

public class menuDetailServlet extends javax.servlet.http.HttpServlet	{

PrintWriter out;
Properties p;
String menus[];
String facilityId ;
public void init(ServletConfig config) throws ServletException	{
	super.init(config);
}


public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
        throws javax.servlet.ServletException,IOException {
		HttpSession session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId = (String) session.getValue( "facility_id" ) ;
  	try {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		this.out = res.getWriter();
		String operation = req.getParameter("function");

	if ( operation.equals("insert") )
		insertmenuDetail(req);
	}
	catch (Exception e)	{
		out.println(e.toString());
		}
	}

private void insertmenuDetail(HttpServletRequest req)	{
	try {
			menus = req.getParameterValues("hiddenlist");
			if(menus==null) {
				menus=new String[1];
				menus[0]="";
			}
			
				boolean local_ejbs = false;
		
				if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/menuDetailManager",menuDetailManagerHome.class,local_ejbs);
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
				HashMap argMap=new HashMap();
				argMap.put("p",p);
				argMap.put("menu_id",req.getParameter("Menu")== null ?"":req.getParameter("Menu"));
				argMap.put("module_id",req.getParameter("Module")== null ?"":req.getParameter("Module"));
				argMap.put("menus",menus);
				argMap.put("facilityId",facilityId);
				argMap.put("client_ip_address",p.getProperty("client_ip_address")== null ?"":p.getProperty("client_ip_address"));
				
				
				Object argArray[] = new Object[1];
				argArray[0] = argMap;

				Class [] paramArray = new Class[1];
				paramArray[0] = argMap.getClass();

				java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertmenuDetail",paramArray)).invoke(busObj,argArray);

				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

				boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
				String error = (String) results.get("error") ;
				String error_value = "0" ;
				argMap.clear();
				results.clear();

				if ( inserted ) error_value = "1" ;
  out.println("<html><script>location.href =\"../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(error, "UTF-8") + "&err_value=" + error_value + "\"</script><body class='message'></html>");

			
			
	} catch ( Exception e ) {
		out.println(e.getMessage());
		out.println(e.toString());
	}
}
} 
