/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSM;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import eSM.PrintRouting.* ;

public class PrintRoutingServlet extends javax.servlet.http.HttpServlet	{
		java.util.Properties p;
		String moduleId;
		String reportId ;
		String srl_no;
		String facilityid ;
		String destLocnType ;
		String destLocnCode ;
		String wsNo ;
		String dfltReportMode;
		String no_of_copies;
		String printer_id1;
		String from_time1;
		String printer_id2;
		String from_time2;
		String printer_id3;
		String from_time3;
		int noOfCopies;
		int srlNo;
		String facilityId ;
		String client_ip_address ;


		public void init(ServletConfig config) throws ServletException	{
			super.init(config);
			}
		public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
				throws javax.servlet.ServletException,IOException	{

				PrintWriter out = null;
				HttpSession session = req.getSession(false);
				this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
				this.facilityId = (String) session.getValue( "facility_id" ) ;
				client_ip_address = p.getProperty("client_ip_address");

				try {
						req.setCharacterEncoding("UTF-8");
						res.setContentType("text/html;charset=UTF-8");
						out = res.getWriter();
						String operation = req.getParameter("function1");

					if ( operation.equals("insert") )
						insertPrintRouting(req, res);
					if ( operation.equals("modify"))
							modifyPrintRouting(req, res);
					if(operation.equals("delete"))
						deletePrintRouting(req,res);
				}
				catch (Exception e)	{
					out.println(e.toString());
					}
				}
		public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws javax.servlet.ServletException,IOException
			{
			PrintWriter out = null;
			try	{
			
			out = res.getWriter();
			String url = "../eCommon/jsp/MstCodeToolbar.jsp?" ;
			String params = req.getQueryString() ;
			String source = url + params ;
			res.setContentType("text/html;charset=UTF-8");
			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script language='javascript' src='../eSM/js/PrintRouting.js'></script><script src='../eCommon/js/common.js' language='javascript'></script></head><frameset rows='42,*,50'><frame name='commontoolbarFrame'	src='"+source+"' frameborder=0 scrolling='no' noresize> <frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0 scrolling='no' ><frame name='messageFrame'	src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
			}
			catch(Exception e)	{	}
			}
		private void modifyPrintRouting(HttpServletRequest req, HttpServletResponse res)	{
			PrintWriter out = null;			
			try {
				out = res.getWriter();
				moduleId=req.getParameter("module_id");
				reportId = req.getParameter("report_id");
				facilityid = req.getParameter("facility_id");

				if (facilityid==null || facilityid.trim().equals(""))
				{
				facilityid="";
				}

				destLocnType = req.getParameter("dest_locn_type");

				destLocnCode = req.getParameter("dest_locn_code");

				if (destLocnCode ==null || destLocnCode.trim().equals(""))
					destLocnCode="null";


				wsNo = req.getParameter("ws_no");
				dfltReportMode = req.getParameter("dflt_report_mode");
				no_of_copies= req.getParameter("no_of_copies");
				printer_id1 = req.getParameter("printer_id");
				from_time1 = req.getParameter("from_time1");
				printer_id2 = req.getParameter("printer_id2");
				if (printer_id2==null)  printer_id2="";
				from_time2 = req.getParameter("from_time2");
				if (from_time2==null)  from_time2="";
				printer_id3= req.getParameter("printer_id3");
				if (printer_id3==null)  printer_id3="";
				from_time3 = req.getParameter("from_time3");
				if (from_time3==null)  from_time3="";

				if ( !no_of_copies.equals( "" ) )
						noOfCopies= Integer.parseInt(no_of_copies) ;
		
					boolean local_ejbs = false;
		
					if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/PrintRoutingManager",PrintRoutingManagerHome.class,local_ejbs);
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
					Integer noOfCopiesInt=new Integer(noOfCopies);
					HashMap argMap=new HashMap();
					argMap.put("p",p);
					argMap.put("moduleId",moduleId);
					argMap.put("reportId",reportId);
					argMap.put("facilityid",facilityid);
					argMap.put("destLocnType",destLocnType);
					argMap.put("destLocnCode",destLocnCode);
					argMap.put("wsNo",wsNo);
					argMap.put("dfltReportMode",dfltReportMode);
					argMap.put("noOfCopies",noOfCopiesInt);
					argMap.put("printer_id1",printer_id1);
					argMap.put("from_time1",from_time1);
					argMap.put("printer_id2",printer_id2);
					argMap.put("from_time2",from_time2);
					argMap.put("printer_id3",printer_id3);
					argMap.put("from_time3",from_time3);
					argMap.put("facilityId",facilityId);
					argMap.put("client_ip_address",client_ip_address);
					
					
					
					Object argArray[] = new Object[1];
					argArray[0] = argMap;
				
					Class [] paramArray = new Class[1];
					paramArray[0] = argMap.getClass();

				java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("updatePrintRouting",paramArray)).invoke(busObj,argArray);

				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
                 
				 argMap.clear();

				boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
				String error = (String) results.get("error") ;
				String error_value = "0" ;
							if ( inserted )
							{
								error_value = "1" ;
								res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
							}
						else
							{
								error = (String) results.get("error") ;
								res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error, "UTF-8" ) );
							}
							results.clear();
							res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) );


			} catch ( Exception e ) {
				out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
				out.println( "Values sent are : <br>" ) ;
			}
		}

		private void insertPrintRouting(HttpServletRequest req, HttpServletResponse res)	{
			PrintWriter out = null;
			
			try {
				out = res.getWriter();
			moduleId = req.getParameter("module_id");
			reportId = req.getParameter("report_id");
			facilityid = req.getParameter("facility_id");

			destLocnType = req.getParameter("dest_locn_type");
			destLocnCode = req.getParameter("dst_loc_code");
			wsNo = req.getParameter("ws_no");
			dfltReportMode = req.getParameter("dflt_report_mode");
			no_of_copies= req.getParameter("no_of_copies");
			printer_id1 = req.getParameter("printer_id");
			from_time1 = req.getParameter("from_time1");
			printer_id2 = req.getParameter("printer_id2");
			if (printer_id2==null)  printer_id2="";
			from_time2 = req.getParameter("from_time2");
			if (from_time2==null)  from_time2="";
			printer_id3= req.getParameter("printer_id3");
			if (printer_id3==null)  printer_id3="";
			from_time3 = req.getParameter("from_time3");
			if (from_time3==null)  from_time3="";

			if (facilityid==null || facilityid.trim().equals(""))
			{
			facilityid="";
			}

			if ( !no_of_copies.equals( "" ) )
						noOfCopies= Integer.parseInt(no_of_copies) ;

					boolean local_ejbs = false;
		
					if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/PrintRoutingManager",PrintRoutingManagerHome.class,local_ejbs);
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
					Integer noOfCopiesInt=new Integer(noOfCopies);
					HashMap argMap=new HashMap();
					argMap.put("p",p);
					argMap.put("moduleId",moduleId);
					argMap.put("reportId",reportId);
					argMap.put("facilityid",facilityid);
					argMap.put("destLocnType",destLocnType);
					argMap.put("destLocnCode",destLocnCode);
					argMap.put("wsNo",wsNo);
					argMap.put("dfltReportMode",dfltReportMode);
					argMap.put("noOfCopies",noOfCopiesInt);
					argMap.put("printer_id1",printer_id1);
					argMap.put("from_time1",from_time1);
					argMap.put("printer_id2",printer_id2);
					argMap.put("from_time2",from_time2);
					argMap.put("printer_id3",printer_id3);
					argMap.put("from_time3",from_time3);
					argMap.put("facilityId",facilityId);
					argMap.put("client_ip_address",client_ip_address);
					
					Object argArray[] = new Object[1];
					argArray[0] = argMap;

					Class [] paramArray = new Class[1];
					paramArray[0] = argMap.getClass();

				java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertPrintRouting",paramArray)).invoke(busObj,argArray);

				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				argMap.clear();

				boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
				String error = (String) results.get("error") ;
				String error_value = "0" ;

				if ( inserted ) {error_value = "1" ;
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
				}
				else{
				error_value = "0" ;
				error = (String) results.get("error") ;
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error, "UTF-8" )+ "&err_value=" + error_value );
				}
				results.clear();


			} catch ( Exception e ) {
				out.println(e.getMessage());
				out.println(e.toString());
				}

			}

		private void deletePrintRouting(HttpServletRequest req, HttpServletResponse res)	{
			PrintWriter out = null;
				try {
				out = res.getWriter();
				res.setContentType("text/html;charset=UTF-8");
				moduleId =req.getParameter("module_id");
				reportId = req.getParameter("report_id");
				srl_no=req.getParameter("srl_no");

				if ( !srl_no.equals( "" ) )
						srlNo= Integer.parseInt(srl_no) ;

					boolean local_ejbs = false;
		
					if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/PrintRoutingManager",PrintRoutingManagerHome.class,local_ejbs);
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
					Integer srlNoInt=new Integer(srlNo);
					HashMap argMap=new HashMap();
					argMap.put("p",p);
					argMap.put("moduleId",moduleId);
					argMap.put("reportId",reportId);
					argMap.put("srlNo",srlNoInt);
					
					
					Object argArray[] = new Object[1];
					
					argArray[0] = argMap;

					Class [] paramArray = new Class[1];
					paramArray[0] = argMap.getClass();

				java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("deletePrintRouting",paramArray)).invoke(busObj,argArray);

				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
                 
				 argMap.clear();
				boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
				String error = (String) results.get("error") ;
				String error_value = "0" ;
				if ( inserted )
							{
								error_value = "1" ;
								res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
							}
						else
							{
								error = (String) results.get("error") ;
								res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error, "UTF-8" ) );
							}results.clear();

					} catch ( Exception e ) {
						out.println(e.getMessage());
						out.println(e.toString());
						}

			}



		}
