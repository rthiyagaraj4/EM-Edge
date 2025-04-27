/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eFM;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;    
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import eFM.FMReceiveFileAtMRD.*;

public class FMReceiveFileAtMRDServlet extends javax.servlet.http.HttpServlet	
{
	PrintWriter out;
	Properties p;

	String facilityId			= "";
	String client_ip_address	= "";
	String locale			= "" ;
	String file_stat			= "" ;
	
	public void init(ServletConfig config) throws ServletException	
	{
		super.init(config);
	}
	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
			throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		HttpSession session		= req.getSession(false);
		this.p						= (Properties) session.getValue( "jdbc" ) ;
		locale						= p.getProperty("LOCALE");
		this.facilityId			= (String)session.getValue("facility_id") ;
		this.client_ip_address	= p.getProperty("client_ip_address");
		
		try 
		{
			this.out			= res.getWriter();
			String operation	= req.getParameter("functionval");
			if(operation.equals("modify"))
			modifyReceiveFileAtMRD(req, res,locale);
		} catch(Exception e1) {
			out.println("Exception in doPost e1 :"+e1.toString());
			e1.printStackTrace();
		}
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res)
		throws javax.servlet.ServletException,IOException
	{
		try	
		{
			this.out = res.getWriter();
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link></head><frameset rows='60,*,50'><frame name='commontoolbarFrame'	src='../eCommon/jsp/MstCodeToolbar.jsp?function_name=Name Prefix' frameborder=0 scrolling='no' noresize> <frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame'	src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
		}catch(Exception e2){ 
			out.println("Exception in doGet e2 :"+e2.toString());
			e2.printStackTrace();
		}
	}
	private void modifyReceiveFileAtMRD(HttpServletRequest req, HttpServletResponse res, String locale)	
	{
		try 
		{
			HashMap hashmap = new HashMap();
			file_stat =req.getParameter("FILE_STAT");
			if(file_stat == null)
				file_stat="";
			//hashmap.put("p_outst_facility"	    , req.getParameter("p_outst_facility") == null ? "" : req.getParameter("p_outst_facility"));
			hashmap.put("p_return_date_time"	    , req.getParameter("p_returndatetime") == null ? "" : req.getParameter("p_returndatetime"));
			hashmap.put("p_returned_by"			    , req.getParameter("p_returned_by") == null ? "" : req.getParameter("p_returned_by"));
			hashmap.put("p_narration"			    ,  req.getParameter("p_narration") == null ? "" : req.getParameter("p_narration"));
			hashmap.put("p_file_nos"			    , req.getParameter("p_file_nos") == null ? "" : req.getParameter("p_file_nos"));
			hashmap.put("facilityId"			    , facilityId);
			hashmap.put("client_ip_address"		    , client_ip_address);
			hashmap.put("mrd_receipt_remarks"	    , req.getParameter("rem_recnum_value") == null ? "" : req.getParameter("rem_recnum_value"));			
			hashmap.put("dflt_archive_fs_locn_code"	, req.getParameter("dflt_archive_fs_locn_code") == null ? "" : req.getParameter("dflt_archive_fs_locn_code"));			
			hashmap.put("locale"		    , locale);
			hashmap.put("file_stat"		    , file_stat);
			
			boolean local_ejbs = false;
			if((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			
			Object home   = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/FMReceiveFileAtMRD",ReceiveFileAtMRDHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = hashmap;
			
			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = hashmap.getClass();
			
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertReceiveFileAtMRD",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			
			boolean inserted	= (((Boolean) results.get( "status" )).booleanValue()) ;
			String error		= (String) results.get("error") ;
			String error_value	= "0" ;
			hashmap.clear();
			results.clear();

				if(inserted){error_value = "1";}
			if(error_value.equals("0"))
			{
     		out.println("<script>parent.frames(2).callerrorpage1('"+error+"');</script>");	
	  
			} else{
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
			}
		
		}catch(Exception e3)
		{
			out.println("Exception in main try block e3 :"+e3.toString());
			e3.printStackTrace();
		}
	}
}
