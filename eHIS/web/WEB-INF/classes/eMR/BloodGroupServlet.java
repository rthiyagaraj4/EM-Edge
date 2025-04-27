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
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;

import eCommon.SingleTabHandler.*;

import eCommon.XSSRequestWrapper;

public class BloodGroupServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	Properties p;
	String bloodgrp;
	String longDesc ;
	String shortDesc ;
	String effectiveStatus ;
	String effective_ind;
	String facilityId ;
	String client_ip_address ;
	String locale="";
	HttpSession session;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		
		req.setCharacterEncoding("UTF-8");
		
			req= new XSSRequestWrapper(req);
			res.addHeader("X-XSS-Protection", "1; mode=block");
			res.addHeader("X-Content-Type-Options", "nosniff");
		
		session = req.getSession(false);
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		this.p = (Properties) session.getValue( "jdbc" ) ;
		locale=p.getProperty("LOCALE");
		this.client_ip_address = p.getProperty("client_ip_address");

		try
		{			
			
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			String operation = req.getParameter("function");

			if ( operation.equals("insert") )   insertBloodGrp(req, res);
			if ( operation.equals("modify"))    modifyBloodGrp(req, res);

		}
		catch(Exception e)
		{
			//out.println(e.toString());
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		
		try
		{
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			
			req= new XSSRequestWrapper(req);
			res.addHeader("X-XSS-Protection", "1; mode=block");
			res.addHeader("X-Content-Type-Options", "nosniff");
			
			this.out = res.getWriter();
			String operation = req.getParameter("function");

			if ( operation.equals("insert") )   insertBloodGrp(req, res);
			if ( operation.equals("modify"))    modifyBloodGrp(req, res);
		}
		catch(Exception e)	{/* out.println(e.toString()); */	e.printStackTrace();}
	}


	private void modifyBloodGrp(HttpServletRequest req, HttpServletResponse res)
	{
		
		Connection con =null;
		String sql = "";
		String error_value = "0" ;
		String error = "";
		try
		{
			con = ConnectionManager.getConnection(req);
			con.setAutoCommit(false);
			//Statement stmt = null;
			PreparedStatement stmt		= null;
			ResultSet rset		= null;
			int count=0;
			bloodgrp =req.getParameter("blood_grp");
			longDesc = req.getParameter("long_desc");
			shortDesc = req.getParameter("short_desc");
			
			effectiveStatus = req.getParameter("eff_status");
			if ( effectiveStatus == null )
				effectiveStatus="D";
			
			effective_ind = req.getParameter("indeterminate_yn");
			if ( effective_ind == null )
				effective_ind="N";
			
			sql = "select count(*) from MR_BLOOD_GRP where INDETERMINATE_YN ='Y' AND  blood_grp <> ? ";
			
			
			//stmt = con.createStatement();
			stmt = con.prepareStatement(sql);
			stmt.setString(1,bloodgrp);
			rset = stmt.executeQuery();
			
			if(rset.next())
				count = rset.getInt(1);
			else 
				count = 0;

			if(rset!=null) rset.close();
			if(stmt!=null) stmt.close();
			

		
			if(count != 0 && effective_ind.equals("Y"))
			{				
				

				java.util.Hashtable message=MessageManager.getMessage(locale,"ONLY_ONE_BLOOD_GRP_WITH_INDETERMINATE_AS_YES","MR");
				error = (String) message.get("message") ;
				if ( message != null) message.clear();

				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode( error , "UTF-8")+"&err_value="+error_value);
			}
			else
			{

				
				String addedById = p.getProperty( "login_user" ) ;
				String addedDate = dateFormat.format( new java.util.Date() ) ;
				String modifiedById = addedById ;
				String modifiedDate = addedDate ;
				String addedFacilityId=facilityId;
				String modifiedFacilityId = addedFacilityId ;
				String addedAtWorkstation=client_ip_address;
				String modifiedAtWorkstation = addedAtWorkstation ;
				java.sql.Date modified_date = java.sql.Date.valueOf( modifiedDate ) ;

				HashMap tabdata=new HashMap();
				tabdata.put("long_desc",longDesc);
				tabdata.put("short_desc",shortDesc);
				tabdata.put("eff_status",effectiveStatus);
				tabdata.put("indeterminate_yn",effective_ind);
				tabdata.put("added_by_id",addedById);
				tabdata.put("modified_by_id",modifiedById);
				tabdata.put("modified_date",modified_date);
				tabdata.put("modified_facility_id",modifiedFacilityId);
				tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

				

				HashMap condflds=new HashMap();
				condflds.put("blood_grp",bloodgrp);

				String tableName = "MR_BLOOD_GRP";
				boolean local_ejbs = false;

				if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[] = new Object[4];
				argArray[0] = p;
				argArray[1] = tabdata;
				argArray[2] = condflds;
				argArray[3] = tableName;

				Class [] paramArray = new Class[4];
				paramArray[0] = p.getClass();
				paramArray[1] = tabdata.getClass();
				paramArray[2] = condflds.getClass();
				paramArray[3] = tableName.getClass();
	
				HashMap results = (HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

				boolean inserted	= ( ((Boolean) results.get( "status" )).booleanValue() ) ;
				error		= (String) results.get("error") ;
				
				
				if(inserted)
				{
					error_value = "1" ;
				}
				else
				{
					error = (String) results.get("error") ;
				}
				error = (String) results.get("error") ;
    			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" )+"&err_value="+error_value );
				
				if (tabdata != null) tabdata.clear();
				
				if (condflds != null) condflds.clear();	
				
				if (results != null) results.clear();
				
			}
		}
		catch ( Exception e )
		{
			/* out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			out.println( bloodgrp + " "+longDesc + " "+shortDesc + " "+ effectiveStatus ); */
			
			e.printStackTrace();
		}
		finally
		{
			 ConnectionManager.returnConnection(con,req);
		}
	}

	private void insertBloodGrp(HttpServletRequest req, HttpServletResponse res)
	{
		
		Connection con =null;
		String sql = "";
		String error_value = "0" ;
		String error = "";
		try
		{
			con = ConnectionManager.getConnection(req);
			con.setAutoCommit(false);
			Statement stmt = null;
			ResultSet rset		= null;
			int count=0;

			sql = "select count(*) from MR_BLOOD_GRP where INDETERMINATE_YN ='Y'";
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			
			if(rset.next())
				count = rset.getInt(1);
			else 
				count = 0;

			if(rset!=null) rset.close();
			if(stmt!=null) stmt.close();
			
			effective_ind = req.getParameter("indeterminate_yn");
			if ( effective_ind == null )
				effective_ind="N";
		
			if(count != 0 && effective_ind.equals("Y"))
			{				
//				error = "There should be only one record in BLOOD GROUP with INDETERMINATE ='Y'";
				java.util.Hashtable message=MessageManager.getMessage(locale,"ONLY_ONE_BLOOD_GRP_WITH_INDETERMINATE_AS_YES","MR");
				error = (String) message.get("message") ;
				if ( message != null) message.clear();

				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode( error , "UTF-8")+"&err_value="+error_value);
			}
			else
			{
				bloodgrp =req.getParameter("blood_grp");
				longDesc = req.getParameter("long_desc");
				shortDesc = req.getParameter("short_desc");
				
				effectiveStatus = req.getParameter("eff_status");
				if(effectiveStatus == null)
					effectiveStatus="D";

				


				String addedById = p.getProperty( "login_user" ) ;
				String addedDate = dateFormat.format( new java.util.Date() ) ;
				String modifiedById = addedById ;
				String modifiedDate = addedDate ;
				String addedFacilityId=facilityId;
				String modifiedFacilityId = addedFacilityId ;
				String addedAtWorkstation=client_ip_address;
				String modifiedAtWorkstation = addedAtWorkstation ;

				java.sql.Date added_date = java.sql.Date.valueOf( addedDate ) ;
				java.sql.Date modified_date = java.sql.Date.valueOf( modifiedDate ) ;

				HashMap tabdata=new HashMap();
				tabdata.put("blood_grp",bloodgrp);
				tabdata.put("long_desc",longDesc);
				tabdata.put("short_desc",shortDesc);
				tabdata.put("eff_status",effectiveStatus);
				tabdata.put("indeterminate_yn",effective_ind);
				tabdata.put("added_by_id",addedById);
				tabdata.put("added_date",added_date);
				tabdata.put("added_facility_id", facilityId);
				tabdata.put("added_at_ws_no",addedAtWorkstation);
				tabdata.put("modified_by_id",modifiedById);
				tabdata.put("modified_date",modified_date);
				tabdata.put("modified_facility_id",modifiedFacilityId);
				tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

				String dupflds[]={"blood_grp"};

				String tableName = "mr_blood_grp";
				boolean local_ejbs = false;

				if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[] = new Object[4];
				argArray[0] = p;
				argArray[1] = tabdata;
				argArray[2] = dupflds;
				argArray[3] = tableName;

				Class [] paramArray = new Class[4];
				paramArray[0] = p.getClass();
				paramArray[1] = tabdata.getClass();
				paramArray[2] = dupflds.getClass();
				paramArray[3] = tableName.getClass();

				HashMap results = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


				boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;	
	
				error = (String) results.get("error") ;
				
				if ( inserted )
				{
					error_value = "1" ;
				}
				else
				{
					error = (String) results.get("error") ;
				}

				error = (String) results.get("error");

				if (tabdata != null) tabdata.clear();		
				if (results != null) results.clear();
			
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode( error , "UTF-8")+"&err_value="+error_value);
			}

		}
		catch ( Exception e )
		{
			/* out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			out.println( bloodgrp+ " "+longDesc + " "+shortDesc +" "+ effectiveStatus ); */
			e.printStackTrace();
		}
		finally
		{
			 ConnectionManager.returnConnection(con,req);
		}
	}

}
