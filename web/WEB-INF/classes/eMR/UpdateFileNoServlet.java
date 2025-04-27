/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMR;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Properties;
import java.util.HashMap;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;

import eCommon.SingleTabHandler.*;

public class UpdateFileNoServlet extends javax.servlet.http.HttpServlet
{	 
	PrintWriter out;
	Properties	p;
	String sStyle;
	String		old_file_no ;
	String		facilityId ;
	String		client_ip_address ;
	String		file_no;
	Connection	con			= null;
	String		addedById	= "";
	Timestamp	added_date	= new Timestamp(System.currentTimeMillis() );
	HttpSession session;
	HashMap		tabdata		= new HashMap();

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		this.out = res.getWriter();
		res.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		session					= req.getSession(false);
		this.p					= (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId			= (String) session.getValue( "facility_id" ) ;
		sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		client_ip_address		= p.getProperty("client_ip_address");
		addedById				= p.getProperty( "login_user" ) ;
		old_file_no				= checkForNull(req.getParameter("old_file_no"));
		file_no		        = checkForNull(req.getParameter("fileno"));
	
		try
		{
			String operation = "modify";
			
			if ( operation.equals("modify"))    modifyFileNo(req, res);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		try
		{
			doPost(req,res);		
		}
		catch(Exception e)	
		{	
			e.printStackTrace();
		}
	}

	private void modifyFileNo(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{	
			con		= ConnectionManager.getConnection(req);
			tabdata.put("old_file_no",old_file_no);
			tabdata.put("modified_by_id",addedById);
			tabdata.put("modified_date",added_date);
			tabdata.put("modified_facility_id",facilityId);
			tabdata.put("modified_at_ws_no",client_ip_address );

			HashMap condflds	=	new HashMap();
			condflds.put("file_no",file_no);
	

			String  table_name	=	"mr_pat_file_index";
			boolean local_ejbs = false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

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

			boolean inserted	= (((Boolean) results.get( "status" )).booleanValue() ) ;
			String	error		= (String) results.get("error") ;
			String	error_value	= "0" ;

			if ( inserted )
			{
		    error_value		= "1" ;
		    out.println("<script>alert(parent.frames[0].getMessage('RECORD_INSERTED','SM'));</script>");
		    out.println("<script>parent.frames[2].location.reload();</script>");
		    out.println("<script>parent.frames[3].location.href='../eCommon/jsp/error.jsp'</script>");
			}
			else
			{
				error = (String) results.get("error") ;
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error, "UTF-8" ) );
			}
	
			results.clear();
			condflds.clear();
			tabdata.clear();

		}catch ( Exception e )
		{
			e.printStackTrace();
		}
		finally
		{
			if(con!= null)
			{
				ConnectionManager.returnConnection(con,req);
			}
		}
	}

	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
} 
