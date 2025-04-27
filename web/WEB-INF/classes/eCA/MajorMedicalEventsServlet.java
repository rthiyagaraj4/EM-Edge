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
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.MessageManager;
import eCommon.XSSRequestWrapper;
import eCommon.SingleTabHandler.*;

public class MajorMedicalEventsServlet extends javax.servlet.http.HttpServlet
{	
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		HttpSession session;
		PrintWriter out;
		session = req.getSession(false);	
	
		try
		{
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
req= new XSSRequestWrapper(req); //MOHE-SCF-0153
res.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
res.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			out = res.getWriter();
			String operation = req.getParameter("mode");
						
			if ( operation.equals("insert") )   insert(req, res,session,out);
			if ( operation.equals("modify"))    modify(req, res,session,out);

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private void modify(HttpServletRequest req, HttpServletResponse res, HttpSession session, PrintWriter out)
	{
		String facilityId = "";
		String client_ip_address = "";
		String patient_id = "";
		String med_event_type_code = "";
		String event_sdate = "";
		String event_edate = "";
		String event_details = "";
		String event_confirmed_flag = "";
		String called_from = "";
		java.util.Properties p = null;

		try
		{
			facilityId			= (String) session.getValue( "facility_id" ) ;
			
			p = (java.util.Properties) session.getValue( "jdbc" ) ;
			client_ip_address	= (String) p.getProperty("client_ip_address");
			String locale		= (String) p.getProperty("LOCALE");
			patient_id =req.getParameter("patient_id");
			med_event_type_code =req.getParameter("med_event_type_code1");
			event_sdate = req.getParameter("event_sdate");
			event_edate = req.getParameter("event_edate");
			if(event_edate==null) event_edate="";
			event_details = req.getParameter("event_details");
			event_confirmed_flag = req.getParameter("confirmed");
			if ( event_confirmed_flag == null )
			event_confirmed_flag="N";
			called_from	=	(req.getParameter("called_from")==null)	?	""	:	req.getParameter("called_from");
			
			event_sdate		= com.ehis.util.DateUtils.convertDate(event_sdate,"DMY",locale,"en");
			event_edate		= com.ehis.util.DateUtils.convertDate(event_edate,"DMY",locale,"en");


			String addedById = p.getProperty( "login_user" ) ;
			//String addedDate = dateFormat.format( new java.util.Date() ) ;
			String modifiedById = addedById ;
			//String modifiedDate = addedDate ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			//java.sql.Date added_date1 = java.sql.Date.valueOf( addedDate ) ;
			//java.sql.Date modified_date1 = java.sql.Date.valueOf(modifiedDate ) ;

			//java.sql.Date added_date = new java.sql.Date(added_date1.parse(added_date1.toLocaleString())-(added_date1.getTimezoneOffset()*60*1000) ) ;
//			java.sql.Date modified_date = new java.sql.Date(modified_date1.parse(modified_date1.toLocaleString())-(modified_date1.getTimezoneOffset()*60*1000) ) ;

			java.sql.Date event_edate2=null;

			if(!event_edate.equals(""))
			{

				StringTokenizer st = new StringTokenizer(event_edate,"/");
				String d1="";
				String d2="";
				String d3="";
				while(st.hasMoreTokens())
				{
					d1=st.nextToken();
					d2=st.nextToken();
					d3=st.nextToken();
				}
				String s=d3+"-"+d2+"-"+d1;
				java.sql.Date event_edate1 = java.sql.Date.valueOf(s);
				event_edate2 = new java.sql.Date(event_edate1.parse(event_edate1.toLocaleString())+(event_edate1.getTimezoneOffset()*60*1000) ) ;
			}

			java.sql.Date event_sdate2=null;
			java.sql.Date event_sdate1=null;

			if(!event_sdate.equals(""))
			{
				StringTokenizer st1 = new StringTokenizer(event_sdate,"/");
				String d11="";
				String d21="";
				String d31="";
				while(st1.hasMoreTokens())
				{
					d11=st1.nextToken();
					d21=st1.nextToken();
					d31=st1.nextToken();
				}
				String s1=d31+"-"+d21+"-"+d11;
				event_sdate1 = java.sql.Date.valueOf(s1);
				event_sdate2 = new java.sql.Date(event_sdate1.parse(event_sdate1.toLocaleString())+(event_sdate1.getTimezoneOffset()*60*1000) ) ;
			}

			HashMap tabdata=new HashMap();
			tabdata.put("event_sdate",event_sdate2);

			if(!event_edate.equals(""))
				tabdata.put("event_edate",event_edate2);
			else
				tabdata.put("event_edate","");

			tabdata.put("event_details",event_details);
			tabdata.put("event_confirmed_flag",event_confirmed_flag);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

			HashMap condflds=new HashMap();
			condflds.put("patient_id",patient_id);
			condflds.put("med_event_type_code",med_event_type_code);
			condflds.put("event_sdate",event_sdate1);

		boolean local_ejbs = false;
		String table_data="mr_med_event_log";
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
		Object argArray[] = new Object[4];
		argArray[0] = p;
		argArray[1] = tabdata;
		argArray[2] = condflds;
		argArray[3] = table_data;

		Class [] paramArray = new Class[4];
		paramArray[0] = p.getClass();
		paramArray[1] = tabdata.getClass();
		paramArray[2] = condflds.getClass();
		paramArray[3] = table_data.getClass();

		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);

		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
		tabdata.clear();
		condflds.clear();
			argArray = null;
			paramArray = null;

			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error") ;
			results.clear();
			String error_value = "0" ;

			if ( inserted )
				error_value = "1" ;
			
			if(called_from.equals("CA"))
				res.sendRedirect("../eCA/jsp/CAError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") + "&err_value="+error_value);
			else
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") + "&err_value="+error_value);
		}
		catch ( Exception e )
		{
			//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			
			//out.println( "Values sent are : <br>" ) ;//common-icn-0181
			e.printStackTrace();
			out.println( 	patient_id+" "+med_event_type_code+" "+event_sdate+" "+event_edate+" "+event_details+" "+	event_confirmed_flag  );
		}
	}

	private void insert(HttpServletRequest req, HttpServletResponse res, HttpSession session, PrintWriter out)
	{
		String facilityId = "";
		String client_ip_address = "";
		String patient_id = "";
		String med_event_type_code = "";
		String event_sdate = "";
		String event_edate = "";
		String event_details = "";
		String event_confirmed_flag = "";
		String called_from = "";
		java.util.Properties p = null;

		try
		{

			facilityId = (String) session.getValue( "facility_id" ) ;	
			p = (java.util.Properties) session.getValue( "jdbc" ) ;
			client_ip_address = p.getProperty("client_ip_address");
			String locale		= (String) p.getProperty("LOCALE");


			patient_id =(req.getParameter("patient_id")==null)?"":req.getParameter("patient_id");

			med_event_type_code =(req.getParameter("med_event_type_code")==null)?"":req.getParameter("med_event_type_code");

			event_sdate = (req.getParameter("event_sdate")==null)?"":req.getParameter("event_sdate");


			event_edate = (req.getParameter("event_edate")==null)?"":req.getParameter("event_edate");


			event_details = (req.getParameter("event_details")==null)?"":req.getParameter("event_details");


			event_confirmed_flag = (req.getParameter("confirmed")==null)?"N":req.getParameter("confirmed");


			called_from	=	(req.getParameter("called_from")==null)?"":req.getParameter("called_from");
			
			event_sdate		= com.ehis.util.DateUtils.convertDate(event_sdate,"DMY",locale,"en");
			event_edate		= com.ehis.util.DateUtils.convertDate(event_edate,"DMY",locale,"en");

			String addedById = p.getProperty( "login_user" ) ;
			String modifiedById = addedById ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			java.sql.Date event_edate1 = null;

			if(!event_edate.equals(""))
			{
				StringTokenizer st = new StringTokenizer(event_edate,"/");
				String d1="";
				String d2="";
				String d3="";
				while(st.hasMoreTokens())
				{
					d1=st.nextToken();
					d2=st.nextToken();
					d3=st.nextToken();
				}
				String s=d3+"-"+d2+"-"+d1;
				event_edate1 = java.sql.Date.valueOf(s);
			}

			java.sql.Date event_sdate1=null;
			if(!event_sdate.equals(""))
			{
				StringTokenizer st1 = new StringTokenizer(event_sdate,"/");
				String d11="";
				String d21="";
				String d31="";
				while(st1.hasMoreTokens())
				{
					d11=st1.nextToken();
					d21=st1.nextToken();
					d31=st1.nextToken();
				}
				String s1=d31+"-"+d21+"-"+d11;
				event_sdate1 = java.sql.Date.valueOf(s1);
			}

			HashMap tabdata=new HashMap();
			tabdata.put("patient_id",patient_id);
			tabdata.put("med_event_type_code",med_event_type_code);
			if(!event_sdate.equals(""))
			tabdata.put("event_sdate",event_sdate1);
			if(!event_edate.equals(""))
			tabdata.put("event_edate",event_edate1);
			tabdata.put("event_details",event_details);
			tabdata.put("event_confirmed_flag",event_confirmed_flag);
			tabdata.put("ADDED_BY_ID",addedById);
			tabdata.put("ADDED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("ADDED_FACILITY_ID", facilityId);
			tabdata.put("ADDED_AT_WS_NO",addedAtWorkstation);
			tabdata.put("MODIFIED_BY_ID",modifiedById);
			tabdata.put("MODIFIED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("MODIFIED_FACILITY_ID",modifiedFacilityId);
			tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );

			String dupflds[]={"patient_id","med_event_type_code","event_sdate"};
			
		boolean local_ejbs = false;
		String table_data = "mr_med_event_log";
		
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
		Object argArray[] = new Object[4];
		argArray[0] = p;
		argArray[1] = tabdata;
		argArray[2] = dupflds;
		argArray[3] = table_data;


		Class [] paramArray = new Class[4];
		paramArray[0] = p.getClass();
		paramArray[1] = tabdata.getClass();
		paramArray[2] = dupflds.getClass();
		paramArray[3] = table_data.getClass();

		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);

		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
		tabdata.clear();
			argArray = null;
			paramArray = null;
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;


			String error = (String) results.get("error") ;
			results.clear();
			String error_value = "0" ;
			if ( inserted )
			{
				error_value = "1" ;
			}
			if(called_from.equals("CA"))
			{
				res.sendRedirect("../eCA/jsp/CAError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") + "&err_value="+error_value);
			}
			else
			{
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") + "&err_value="+error_value);
			}
		}
		catch ( Exception e )
		{

			//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());//common-icn-0181
			
			out.println( "Values sent are : <br>" ) ;
			e.printStackTrace();
			out.println( 	patient_id+" "+med_event_type_code+" "+event_sdate+" "+event_edate+" "+event_details+" "+	event_confirmed_flag  );
		}
	}
}
