/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/****** Last Modified Date Time 9/22/2005 11:23 AM *****/
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

public class MpInternalReqRepRuleServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	java.util.Properties p;

	String reportId;
	String printReqYN;
	String pSeriesCode;
	String client_ip_address ;

	public void init(ServletConfig config) throws ServletException	
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
        throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		HttpSession session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		client_ip_address = p.getProperty("client_ip_address");
		
		try 
		{
			this.out = res.getWriter();
			String operation = req.getParameter("function_name");

			if ( operation.equals("insert") )
				insertMpInternalReqRepRule(req, res);
			if ( operation.equals("delete"))
				deleteMpInternalReqRepRule(req, res);
		}
		catch (Exception e)	
		{
			out.println(e.toString());
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

			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script language='javascript' src='../eMP/js/MpInternalReqRepRule.js'></script></head><frameset rows='42,*,50'><frame name='commontoolbarFrame'	src='"+source+"' frameborder=0 scrolling='no' noresize> <frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame'	src='../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");

		} catch(Exception e)	{	}
	}

	private void insertMpInternalReqRepRule(HttpServletRequest req, HttpServletResponse res)	
	{
		try 
		{
			reportId= req.getParameter("report_id");
			pSeriesCode = req.getParameter("pat_ser_grp_code");
			printReqYN=req.getParameter("print_req_yn");

			String addedById = p.getProperty( "login_user" ) ;
			String modifiedById = addedById ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			HashMap tabdata=new HashMap();
			tabdata.put("report_id",reportId);
			tabdata.put("pat_ser_grp_code",pSeriesCode);
			tabdata.put("print_reqd_yn",printReqYN);
			tabdata.put("added_by_id",addedById);
			tabdata.put("added_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("added_at_ws_no",addedAtWorkstation);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

			String dupflds[]={"report_id","pat_ser_grp_code"};
            
			boolean local_ejbs = isLocalEJB();
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = dupflds;
			argArray[3] = "MP_ONLINE_REPORTS";

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass(); ;
			paramArray[1] = tabdata.getClass();
			paramArray[2] = dupflds.getClass();
			paramArray[3] = String.class;
			
			java.util.HashMap results = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error") ;
			String error_value = "0" ;
			tabdata.clear();
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
			//out.println("<h3> Exception raise by Servlet ...So Record Not Inserted </h3> Foll: Error Received : "+e.toString());
			e.printStackTrace(); // Added by lakshmanan for security issue ID 169522722 on 28-08-2023
		}
	}

	private void deleteMpInternalReqRepRule(HttpServletRequest req, HttpServletResponse res)	
	{
		try 
		{
			res.setContentType("text/html");
			reportId=req.getParameter("report_id");
			pSeriesCode= req.getParameter("pat_ser_grp_code");

			HashMap delflds=new HashMap();
			delflds.put("report_id",reportId);
			delflds.put("pat_ser_grp_code",pSeriesCode);

			boolean local_ejbs = isLocalEJB();
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[3];
			argArray[0] = p;
			argArray[1] = delflds;
			argArray[2] = "MP_ONLINE_REPORTS";

			Class [] paramArray = new Class[3];
			paramArray[0] = p.getClass(); ;
			paramArray[1] = delflds.getClass();
			paramArray[2] = String.class;
			
			java.util.HashMap results = (HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			boolean deleted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error") ;
			String error_value = "0" ;
			delflds.clear();
			results.clear();
			if ( deleted )
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
			//out.println(e.getMessage());
			//out.println(e.toString());
			e.printStackTrace(); // Added by lakshmanan for security issue ID 169512943 on 28-08-2023
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

