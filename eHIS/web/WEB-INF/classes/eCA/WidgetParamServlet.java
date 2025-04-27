/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Rev.Date 	Rev.Name	Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           						created
15/09/2012   IN035950	  Nijithas	     						CHL_CRF
21/03/2014	 IN034513	  Vijayakumar K 						SS-CRF-0007 In the patient Chart Clinician Access, the previous 
																Encounters were grouped by specialty in eHIS version 5x. This enabled the doctors to view the details of their desired specialty. With the upgrade, this grouping has been removed.
---------------------------------------------------------------------------------------------------------------
*/
package eCA;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import eCommon.XSSRequestWrapper;
import eCommon.SingleTabHandler.*;

public class WidgetParamServlet extends javax.servlet.http.HttpServlet
{
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
        throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
req= new XSSRequestWrapper(req); //MOHE-SCF-0153
res.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
res.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		PrintWriter out = null;

		try
		{
			out = res.getWriter();
			insertWidgetParam(req, res, out);
		}
		catch(Exception e)
		{
			out.println("Exception in Main Block : "+e.toString());
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		PrintWriter out = null;
		try
		{
			out = res.getWriter();
			doPost(req, res);

			String url = "../eCommon/jsp/MstCodeToolbar.jsp?" ;
			String params = req.getQueryString() ;
			String source = url + params ;
			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/ecis.css'></link> <script src='../../eCommon/js/common.js' language='javascript'></script> <script language='javascript' src='../eMP/js/ActiveInactive.js'></script></head><frameset rows='42,*,50'><frame name='commontoolbarFrame'	src='"+source+"' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");

	} catch(Exception e)
{	}
}

private void insertWidgetParam(HttpServletRequest req, HttpServletResponse res, PrintWriter out)	{

	java.util.Properties p;

	String module_id				= "CA";
	
	String mode						= "";
	String facilityId				= "" ;
	String client_ip_address		= "";
	String locale					= "";
	String errorMsg					= "";
	String error_value				= "";
	// ends here.

	HttpSession session			= req.getSession(false);

	p					= (java.util.Properties) session.getValue( "jdbc" ) ;
	locale				= (String) p.getProperty("LOCALE");
	facilityId			= (String) session.getValue( "facility_id" ) ;
	client_ip_address	= p.getProperty("client_ip_address");
	mode				= req.getParameter("mode") != null ? req.getParameter("mode") : "";
	
	String widget_ThemeIcon_yn = null;
	String widget_Theme_yn = null;
	String widget_Icon_yn = null;
	String enc_grp_by_splty_yn = null;//IN034513
	try
	{

		try
		{
			
			widget_ThemeIcon_yn = req.getParameter("widget_ThemeIcon_yn");//IN029712
			widget_Theme_yn = req.getParameter("widget_Theme_yn");//IN029712
			widget_Icon_yn = req.getParameter("widget_Icon_yn");//IN029712
			enc_grp_by_splty_yn = req.getParameter("enc_grp_by_splty_yn");//IN034513

			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		
//		String addedById				=	(String) p.getProperty( "login_user" ) ;  //Common-ICN-0092  
		
		HashMap tabdata					=	new HashMap();

		String condflds[]={};

		java.util.HashMap results = new HashMap();
		HashMap dupflds=new HashMap();

		tabdata.put("module_id",module_id);

		tabdata.put("WIDGET_THEME_ICON_YN",widget_ThemeIcon_yn);
		tabdata.put("WIDGET_THEME_YN",widget_Theme_yn);
		tabdata.put("WIDGET_ICON_YN",widget_Icon_yn);
		tabdata.put("ENC_GRP_BY_SPLTY_YN",enc_grp_by_splty_yn);//IN034513
		
		
		dupflds.put("module_id","CA");

		boolean local_ejbs = false;
		String table_data = "CA_WIDGET_PARAM";

		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
			local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		Object argArray[] = new Object[4];
		argArray[0] = p;
		argArray[1] = tabdata;

		if(mode.equals("insert"))
			argArray[2] = condflds;
		else  if(mode.equals("update"))
			argArray[2] = dupflds;

		argArray[3] = table_data ;

		Class [] paramArray = new Class[4];
		paramArray[0] = p.getClass();
		paramArray[1] = tabdata.getClass();

		if(mode.equals("insert"))
			paramArray[2] = condflds.getClass();
		else if (mode.equals("update"))
			paramArray[2] = dupflds.getClass();

		paramArray[3] = table_data.getClass();

		if(mode.equals("insert"))
		 results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
		else if(mode.equals("update"))
			 results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);

		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

		tabdata.clear();
		dupflds.clear();
		argArray = null;
		paramArray = null;

		boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
		errorMsg = (String) results.get("error") ;
		results.clear();
		error_value = "0" ;

		if ( inserted )
			error_value = "1" ;

		res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( errorMsg ,"UTF-8") + "&err_value=" + error_value );
	}
	catch ( Exception e )
	{
		//out.println("Exception occured at Insert Block  : "+e.toString());//common-icn-0181
		e.printStackTrace();
	}
	}
}
