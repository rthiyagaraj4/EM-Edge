/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/****** Last Modified Date Time 9/22/2005 11:18 AM  *****/
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

import eCommon.XSSRequestWrapper;//Added by Kamatchi S for security issue against COMMON-ICN-0187

public class FacilityLevelServlet extends HttpServlet 
{
	PrintWriter out;
	java.util.Properties p;
	
	String Facility_Id = "";
	String Chart = "";
	String Numbering ="";
	String terminal_digit_count;
	String terminal_digit1_position;
	String terminal_digit2_position;
	String terminal_digit3_position;
	String terminal_digit4_position;
	String terminal_digit5_position;
	String facilityId;
	String client_ip_address;
	
	public void init(ServletConfig config) throws ServletException	
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
					throws javax.servlet.ServletException,IOException 
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		//Added by Kamatchi S for security issue against COMMON-ICN-0187
		req = new XSSRequestWrapper(req);
		res.addHeader("X-XSS-Protection", "1; mode=block");
		res.addHeader("X-Content-Type-Options", "nosniff");
		//Added by Kamatchi S for security issue against COMMON-ICN-0187 END
		HttpSession session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");
	
		String operation = req.getParameter("function1");
		try
		{
			this.out = res.getWriter();

			if ( operation.equals("insert") )  insertFacilityLevel(req, res);
			if ( operation.equals("modify")) modifyFacilityLevel(req, res);
			if ( operation.equals("delete")) deleteFacilityLevel(req, res);
			
		}
		catch (Exception e)	
		{
			  //out.println(e.toString());
			  e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res)
 	throws javax.servlet.ServletException,IOException
	{
		try	
		{
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			String url = "../eCommon/jsp/MstCodeToolbar.jsp?" ;
			String params = req.getQueryString() ;
			String source = url + params ;

			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script language='javascript' src='../eMP/js/FacilityLevel.js'></script></head><frameset rows='42,*,50'><frame name='commontoolbarFrame'	src='"+source+"' frameborder=0 scrolling='no' noresize> <frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame'	src='../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
		}
		catch(Exception e)	{	}
	}

	private void insertFacilityLevel(HttpServletRequest req, HttpServletResponse res)	
	{
		try 
		{
			Facility_Id = req.getParameter("Facility_Name");
			Chart = req.getParameter("ChartMaintenance");
			Numbering = req.getParameter("Numbering");
			
//The following lines are to be removed when the table is modified:
		  terminal_digit_count = req.getParameter("terminal_digit_count");
		  if(terminal_digit_count==null)terminal_digit_count="";
		  terminal_digit1_position = req.getParameter("terminal_digit1_position");
  		  if(terminal_digit1_position==null)terminal_digit1_position="";
		  terminal_digit2_position = req.getParameter("terminal_digit2_position");
		  if(terminal_digit2_position==null)terminal_digit2_position="";
		  terminal_digit3_position = req.getParameter("terminal_digit3_position");
		  if(terminal_digit3_position==null)terminal_digit3_position="";
		  terminal_digit4_position = req.getParameter("terminal_digit4_position");
		  if(terminal_digit4_position==null)terminal_digit4_position="";
		  terminal_digit5_position = req.getParameter("terminal_digit5_position");
  		  if(terminal_digit5_position==null)terminal_digit5_position="";
//upto this line


			String addedById = p.getProperty( "login_user" ) ;
			String modifiedById = addedById ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			HashMap tabdata=new HashMap();
			tabdata.put("facility_id",Facility_Id);
			tabdata.put("single_or_multi_files_ind",Chart);
			tabdata.put("separate_file_no_yn",Numbering);
			tabdata.put("Billing_Interface_Yn","N");
			tabdata.put("added_by_id",addedById);
			tabdata.put("added_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("added_facility_id", facilityId);
			tabdata.put("added_at_ws_no",addedAtWorkstation);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
//The following lines are to be removed when the table is modified:
            tabdata.put("terminal_digit_count",terminal_digit_count);
			tabdata.put("terminal_digit1_position",terminal_digit1_position );
            tabdata.put("terminal_digit2_position",terminal_digit2_position );
            tabdata.put("terminal_digit3_position",terminal_digit3_position );
            tabdata.put("terminal_digit4_position",terminal_digit4_position );
            tabdata.put("terminal_digit5_position",terminal_digit5_position );
//upto here

			String dupflds[]={"facility_id"};
            
			boolean local_ejbs = isLocalEJB();
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = dupflds;
			argArray[3] = "MP_PARAM_FOR_FACILITY";

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
				

				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error, "UTF-8") + "&err_value=" + error_value );
			}

			
		}
		catch ( Exception e )
		{
			//out.println("<h3> Exception raise by Servlet ...So Record Not Inserted </h3> Foll: Error Received : "+e.toString());
			e.printStackTrace();
		}
	}

	private void modifyFacilityLevel(HttpServletRequest req, HttpServletResponse res)	
	{
		try 
		{
			Facility_Id = req.getParameter("Facility_Id");
			Chart = req.getParameter("ChartMaintenance");
			Numbering = req.getParameter("Numbering");
			
//The following lines are to be removed when the table is modified:
		  terminal_digit_count = req.getParameter("terminal_digit_count");
		  terminal_digit1_position = req.getParameter("terminal_digit1_position");
		  terminal_digit2_position = req.getParameter("terminal_digit2_position");
		  terminal_digit3_position = req.getParameter("terminal_digit3_position");
		  terminal_digit4_position = req.getParameter("terminal_digit4_position");
		  terminal_digit5_position = req.getParameter("terminal_digit5_position");
//upto here

			String addedById = p.getProperty( "login_user" ) ;
			String modifiedById = addedById ;
			String modifiedFacilityId = facilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			HashMap tabdata=new HashMap();
			tabdata.put("single_or_multi_files_ind",Chart);
			tabdata.put("separate_file_no_yn",Numbering);
			
//The following lines are to be removed when the table is modified:
            tabdata.put("terminal_digit_count",terminal_digit_count);
			tabdata.put("terminal_digit1_position",terminal_digit1_position );
            tabdata.put("terminal_digit2_position",terminal_digit2_position );
            tabdata.put("terminal_digit3_position",terminal_digit3_position );
            tabdata.put("terminal_digit4_position",terminal_digit4_position );
            tabdata.put("terminal_digit5_position",terminal_digit5_position );
//upto here

			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
			
			HashMap condflds=new HashMap();
			condflds.put("facility_id",Facility_Id);

			boolean local_ejbs = isLocalEJB();
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = condflds;
			argArray[3] = "MP_PARAM_FOR_FACILITY";

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass(); ;
			paramArray[1] = tabdata.getClass();
			paramArray[2] = condflds.getClass();
			paramArray[3] = String.class;
			
			java.util.HashMap results = (HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			
			tabdata.clear();
			condflds.clear();
			results.clear();
			String error_value = "0" ;
			if ( inserted )
			{
				 error_value = "1" ;
				 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8") + "&err_value=" + error_value );
			}
			else
			{
				
				 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode( error, "UTF-8") );
			}

			
		} 
		catch ( Exception e ) 
		{
				//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
				e.printStackTrace();
		}
	}
	private void deleteFacilityLevel(HttpServletRequest req, HttpServletResponse res)	
	{
		try 
		{
			res.setContentType("text/html");
			Facility_Id = req.getParameter("Facility_Id");

			
			HashMap delflds=new HashMap();
			delflds.put("FACILITY_ID",Facility_Id);

			boolean local_ejbs = isLocalEJB();
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[3];
			argArray[0] = p;
			argArray[1] = delflds;
			argArray[2] = "MP_PARAM_FOR_FACILITY";

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
			/* out.println(e.getMessage());
			out.println(e.toString()); */
			e.printStackTrace();
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
