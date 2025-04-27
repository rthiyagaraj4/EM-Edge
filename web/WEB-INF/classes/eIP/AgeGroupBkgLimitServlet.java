/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIP;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*; 
import javax.naming.*;
import javax.rmi.*;
import java.util.*;


import eIP.IPAgeGroupBkgLimit.*;

public class AgeGroupBkgLimitServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	PrintWriter out;
	Properties p;
	String sStyle;
	String facilityId ;
	String client_ip_address ;
	HttpSession session;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		session			= req.getSession(false);
		this.p			= (Properties) session.getValue( "jdbc" ) ;
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		
		client_ip_address = p.getProperty("client_ip_address");
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		try
		{
			this.out = res.getWriter();
			AddModify(req,res);
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
			sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
			this.out = res.getWriter();
			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link><script language='javascript' src='/eCIS/ip/js/NursUnitRoom.js'></script></head><frameset rows='60,*,50'><frame name='commontoolbarFrame' src='../eCommon/jsp/commonToolbar.jsp?function_name=Rooms For Nursing Unit' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
			doPost(req,res);
		}
		catch(Exception e)	{	}
	}

	private void AddModify(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			ArrayList F = new ArrayList();
			ArrayList M = new ArrayList();
			ArrayList U = new ArrayList();
			ArrayList T = new ArrayList();
			ArrayList S = new ArrayList();
			ArrayList B = new ArrayList();
			String FF = req.getParameter("F");
			String MM = req.getParameter("M");
			String UU = req.getParameter("U");
			String TT = req.getParameter("T");
			String SS = req.getParameter("S");
			String BB = req.getParameter("B");

			out.println("FF:"+FF) ;
			out.println("MM:"+MM) ;
			out.println("UU:"+UU) ;
			out.println("TT:"+TT) ;
			out.println("SS:"+SS) ;
			out.println("BB:"+BB) ;
		
			StringTokenizer st1 = new StringTokenizer(SS,"`");
			StringTokenizer st2 =  new StringTokenizer(FF,"`");
			StringTokenizer st3 =  new StringTokenizer(MM,"`");
			StringTokenizer st4 =  new StringTokenizer(UU,"`");
			StringTokenizer st5 =  new StringTokenizer(TT,"`");
			StringTokenizer st6 =  new StringTokenizer(BB,"`");

			while(st1.hasMoreTokens())
			{
				S.add(st1.nextToken()) ;
			}

			while(st2.hasMoreTokens())
			{
				F.add(st2.nextToken()) ;
			}

			while(st3.hasMoreTokens())
			{
				M.add(st3.nextToken()) ;
			}

			while(st4.hasMoreTokens())
			{
				U.add(st4.nextToken()) ;
			}

			while(st5.hasMoreTokens())
			{
				T.add(st5.nextToken()) ;
			}

			while(st6.hasMoreTokens())
			{
				B.add(st6.nextToken()) ;
			}

				HashMap	hashData	=	new HashMap();
				hashData.put("age_group_code",checkForNull(req.getParameter("age_group_code")));
				hashData.put("facilityId",facilityId);
				hashData.put("male",M);
				hashData.put("female",F);
				hashData.put("unknown",U);
				hashData.put("total",T);
				hashData.put("select",S);
				hashData.put("beds",B);
				hashData.put("client_ip_address",client_ip_address);
				boolean local_ejbs = false;
		
				if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/IPAgeGroupBkgLimit",IPAgeGroupBkgLimitManagerHome.class,local_ejbs);
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
				
				Object argArray[] = new Object[2];
				argArray[0] = p;
				argArray[1] = hashData;
				
				Class [] paramArray = new Class[2];
				paramArray[0] = p.getClass();
				paramArray[1] = hashData.getClass();
			

				HashMap results = (HashMap)(busObj.getClass().getMethod("AddModify",paramArray)).invoke(busObj,argArray);

				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

				//boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
				String error = (String) results.get("error") ;
				//String error_value = "0" ;

				/* code changes are made for this incident 17616 date:Saturday, January 09, 2010*/

				//if ( inserted ) error_value = "1" ;
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=1" );

		F.clear();
		M.clear();
		U.clear();
		T.clear();
		S.clear();
		B.clear();
		hashData.clear();
		results.clear();

		} catch ( Exception e ) {
			e.printStackTrace();

			}
	}//E.O.Method

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}

}
