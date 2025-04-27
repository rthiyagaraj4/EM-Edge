/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/****** Last Modified Date Time 9/22/2005 12:02 PM ******/
package eMP;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import eCommon.SingleTabHandler.*;
import webbeans.eCommon.*;

public class PatSearchForResultsServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	java.util.Properties p=null;
	
	String long_desc ="";
	String select1="" ;
	String client_ip_address="" ;
	String order1="";
	String field_name="";

	HttpSession session	=	null;
	
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		try
		{
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
	
		client_ip_address = p.getProperty("client_ip_address");
	
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		this.out = res.getWriter();
		String operation = req.getParameter("function");

		if ( operation.equals("modify"))    modifyPatSearchForResult(req, res);
		}
		catch(Exception e)
		{
			out.println("exception 1 "+e);
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		try
		{
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();


			String url = "../eCommon/jsp/MstCodeToolbar.jsp?" ;
			String params = req.getQueryString() ;
			String source = url + params ;

			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script language='javascript' src='../eMP/js/PatSearchForResult.js'></script></head><frameset rows='42,*,50'><frame name='commontoolbarFrame'	src='"+source+"' frameborder=0 scrolling='no' noresize> <frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame'	src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
		}
		catch(Exception e)	{	}
	}

	private void modifyPatSearchForResult(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
		
			field_name   = req.getParameter( "fld_nm") == null ? "" : req.getParameter("fld_nm") ;
			long_desc   = req.getParameter( "long_desc") == null ? "" : req.getParameter("long_desc") ;
			order1   = req.getParameter( "order1") == null ? "" : req.getParameter("order1") ;
			select1   = req.getParameter( "select1") == null ? "N" : req.getParameter("select1") ;

			
				String addedById = p.getProperty( "login_user" ) ;
				String modifiedById = addedById ;
				String addedAtWorkstation=client_ip_address;
				String modifiedAtWorkstation = addedAtWorkstation ;



				HashMap tabdata=new HashMap();
				tabdata.put("field_desc",long_desc);
				tabdata.put("field_select",select1);
				tabdata.put("field_order",order1);

				tabdata.put("modified_by_id",modifiedById);
				tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
				tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

				HashMap condflds=new HashMap();
				condflds.put("field_name",field_name);

				boolean local_ejbs = isLocalEJB();
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[] = new Object[4];
				argArray[0] = p;
				argArray[1] = tabdata;
				argArray[2] = condflds;
				argArray[3] = "MP_PAT_SEARCH_RESULT";

				Class [] paramArray = new Class[4];
				paramArray[0] = p.getClass(); ;
				paramArray[1] = tabdata.getClass();
				paramArray[2] = condflds.getClass();
				paramArray[3] = String.class;
				
				java.util.HashMap results = (HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				boolean inserted = (((Boolean) results.get( "status" )).booleanValue());

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
				    res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8") + "&err_value=" + error_value ); //res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode( error, "UTF-8") );
				}

		}
		catch ( Exception e )
		{
			//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			//out.println( "Values sent are : <br>" ) ;
			//out.println( "desc "+long_desc+" select "+select1+" order "+order1 name "+field_name) ;
			e.printStackTrace(); // Added by lakshmanan for security issue ID 169518505 on 30-08-2023
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
