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
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;

import eIP.IPReleaseBed.*;

public class ReleaseBedServlet extends javax.servlet.http.HttpServlet
{
	HttpSession session;
	PrintWriter	out;
	Properties p;
	String facilityId 	=	"";
	String locale		= "";

	public void init(ServletConfig config) throws ServletException	
	{
		super.init(config);
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		try
		{
			System.out.println("********* Inside Release Bed Servlet 39 ********* ");
			doPost(req,res);		
		}
		catch(Exception e)	
		{	
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		StringBuffer finalvals  = new StringBuffer();
		String str				= "";
		session					= req.getSession(false);
		String bookingtype		= "";
		String encounter_id		= "";
		String bedbookingrefno  = "";
		String reqbedno			= "";
		String reqnursingunitcode = "";
		this.p = (Properties) session.getValue( "jdbc" ) ;
		locale = p.getProperty("LOCALE");

		facilityId 	=	(String) session.getValue("facility_id");
		Connection con	=	null;
		try
		{
			con = ConnectionManager.getConnection(p);
			this.out = res.getWriter();
			RecordSet	releaseBedDetail	=	null;
			String	from	=	"",	to		=	"";
			String checkedOnes = "";
			from		=	(req.getParameter("from")==null)	?	"0"	:	req.getParameter("from");
			to			=	(req.getParameter("to")==null)		?	"0"	:	req.getParameter("to");

			releaseBedDetail	=	(webbeans.eCommon.RecordSet)	session.getAttribute("releaseBedDetail");

			if(from != null && to != null)
			{
				from	=	from.trim();
				to		=	to.trim();
				for( int i=(Integer.parseInt(from)); i<=(Integer.parseInt(to)); i++)
				{
					if(req.getParameter(("select_"+i)) != null)
					{
						checkedOnes = req.getParameter(("select_"+i));
						if(!(releaseBedDetail.containsObject(checkedOnes)))
							releaseBedDetail.putObject(checkedOnes);
					}
				}
			}
			
			System.out.println("********* Inside Release Bed Servlet 92 ********* ");

			if(releaseBedDetail.getSize() == 0)
			{
				java.util.Hashtable message = MessageManager.getMessage( locale,"NO_SELECTION","IP");
				String mesge = (String) message.get("message");
				message.clear();
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode(mesge,"UTF-8"));
			}
			else
			{
				//					finalvals = "";
				System.out.println("********* Inside Release Bed Servlet 104 releaseBedDetail.getSize() : "+releaseBedDetail.getSize());
				for(int i=0;i<releaseBedDetail.getSize();i++)
				{
					finalvals.append((String)releaseBedDetail.getObject(i)+"~");
				}
				StringTokenizer st = new StringTokenizer(finalvals.toString(),"~");
				while(st.hasMoreTokens())
				{
					str = st.nextToken();
					StringTokenizer st1 = new StringTokenizer(str,"`");
					
					while(st1.hasMoreTokens())
					{
						bookingtype = st1.nextToken();
						bedbookingrefno = st1.nextToken();
						encounter_id = st1.nextToken();
						reqbedno = st1.nextToken();
						reqnursingunitcode = st1.nextToken();
					}				

					session.removeAttribute("releaseBedDetail");
					IPReleaseBed(req, res, bookingtype, bedbookingrefno, encounter_id, reqbedno, reqnursingunitcode );
				}
			}
		}catch (Exception e)	
		{
			e.printStackTrace();
		}
		finally
		{
			if(con != null)
				ConnectionManager.returnConnection(con,p);
		}
	}


	private void IPReleaseBed(HttpServletRequest req ,HttpServletResponse res, String bookingType, String bedBookingRefno, String encounterID, String reqbedno, String reqnursingunitcode)	
	{

		try 
		{
			String error="";
			String error_value = "0" ;
			HashMap hashData	= new HashMap();
			hashData.put("encounter_id",encounterID);
			hashData.put("bookingtype",bookingType);
			hashData.put("bedbookingrefno",bedBookingRefno);
			hashData.put("reqbedno",reqbedno);
			hashData.put("reqnursingunitcode",reqnursingunitcode);
			hashData.put("facilityId",facilityId);
			hashData.put("client_ip_address",p.getProperty("client_ip_address"));
			boolean local_ejbs = false;
				
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/IPReleaseBed",IPReleaseBedHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = hashData;
			
			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = hashData.getClass();
			

			HashMap results = (HashMap)(busObj.getClass().getMethod("ReleaseBed",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			error = (String) results.get("error") ;
			error_value = "0" ;


			hashData.clear();

			if ( inserted )
			{
				error_value = "1" ;
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
			}
			else
			{
				error = (String) results.get("error") ;
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" ) );
			}
			results.clear();

		}catch(Exception e) 
		{
			e.printStackTrace();
		}
	}

}
