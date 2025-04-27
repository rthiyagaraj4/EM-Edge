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
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import eCA.SectionForNoteType.*;
import webbeans.eCommon.ConnectionManager;

public class SectionForNoteTypeServlet extends javax.servlet.http.HttpServlet
{
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		try
		{
			out = response.getWriter();
			insertSecForNoteType(request,response, out);
		}
		catch(Exception e)
		{
			out.println("Exception in try of doPost() of SectionForNoteTypeServlet.java "+e.toString());
			
			e.printStackTrace();
		}
	}

	private void insertSecForNoteType(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
	{
		java.util.Properties p;
		
		String facilityId			= "" ;
		String client_ip_address	= "";
		String note_type			= "";
		String sec_hdg_code			= "";
		String note_seq_num			= "";
		String chief_comp			= "";
		String countOfRows			= "";

		HttpSession session;

		java.util.HashMap valueMap = new java.util.HashMap();
		
		session = request.getSession(false);
		
		p						= (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale			= (String) p.getProperty("LOCALE");
		facilityId				= (String) session.getValue( "facility_id" ) ;
		client_ip_address		= (String) p.getProperty("client_ip_address");
		

		try
		{
			note_type		= request.getParameter("note_type") == null ? "" : request.getParameter("note_type");
			
			countOfRows		= request.getParameter("countOfRows") == null ? "" : request.getParameter("countOfRows");

		
			valueMap.put("locale",locale);
			valueMap.put("note_type",note_type);			
			valueMap.put("facility_id",facilityId);
			valueMap.put("client_ip_address",client_ip_address);
			valueMap.put("countOfRows",countOfRows);
		
			int i = Integer.parseInt(countOfRows);
			
			for(int j=0;j<i;j++)
			{
				sec_hdg_code = request.getParameter("sec_heading_code"+j) == null ? "" : request.getParameter("sec_heading_code"+j);
				note_seq_num = request.getParameter("seq_num_text"+j) == null ? "" : request.getParameter("seq_num_text"+j);
				chief_comp = request.getParameter("chief_complaint"+j) == null ? "N" : request.getParameter("chief_complaint"+j);
				valueMap.put("sec_hdg_code"+j,sec_hdg_code);
				valueMap.put("note_seq_num"+j,note_seq_num);
				valueMap.put("chief_comp"+j,chief_comp);
			}
			
			boolean local_ejbs = false;
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home		= com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SectionForNoteType",SectionForNoteTypeHome.class,local_ejbs);
			Object busObj	= (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = valueMap;
			
			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = valueMap.getClass();

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertSecForNoteType",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			valueMap.clear();

			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error")==null?"":(String) results.get("error") ;
			
			results.clear();
			
			String error_value = "0" ;

			if ( inserted ) 
				error_value = "1" ;

			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") + "&err_value=" + error_value );
		}
		catch(Exception e)
		{
			//out.println("Exception in try of SectionForNoteTypeServlet.java"+e.toString());//common-icn-0181
			
			e.printStackTrace();
		}
	}
};
