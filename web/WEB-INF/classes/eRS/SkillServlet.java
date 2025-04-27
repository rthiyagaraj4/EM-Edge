/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eRS;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import eCommon.Common.*;
import webbeans.eCommon.*;
import eCommon.SingleTabHandler.*;
import java.net.URLEncoder;


public class SkillServlet extends HttpServlet{

	private ServletConfig config = null;
	HttpSession session = null;
	PrintWriter out = null;
	String facility_id = "";
	Properties p = new Properties();
	String client_ip_address = "";
	String error_value ="0";
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	String skill_code = "";
	String skill_desc = "";
	String skill_expl_text= "";
	String eff_status="";
	String added_by_id = "";
	boolean inserted= false;
	
	public void init(ServletConfig config)throws ServletException{
		super.init(config);
		this.config = config;
	}

	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException	{
		doPost(request,response);
	}
	/*************************************************************************/

	public synchronized void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException	{

		session = request.getSession(false);
		facility_id = (String)session.getAttribute("facility_id");
		this.p = (java.util.Properties) session.getAttribute( "jdbc" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");		

		try{
			
			request.setCharacterEncoding("UTF-8");
		    response.setContentType("text/html;charset=UTF-8"); 

			out = response.getWriter();
			String mode = request.getParameter("mode");

			if ( mode.equals("1")) insert(request, response);
			if ( mode.equals("2")) modify(request, response);

		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	/**************************************************/
	public void insert(HttpServletRequest request,HttpServletResponse response)throws Exception{
		try{	
			HashMap tabData=new HashMap();
			added_by_id 	= p.getProperty( "login_user" ) ;
			String addeddate = dateFormat.format( new java.util.Date() ) ;

			skill_code = request.getParameter("skill_code")==null ? "":request.getParameter("skill_code");
			skill_desc = request.getParameter("skill_desc")==null ? "":request.getParameter("skill_desc");
			skill_expl_text = request.getParameter("skill_expl_text")==null ? "":request.getParameter("skill_expl_text");
			eff_status = request.getParameter("eff_status")==null ? "D":request.getParameter("eff_status");

			tabData.put("skill_code",skill_code);
			tabData.put("skill_desc",skill_desc);
			tabData.put("skill_expl_text",skill_expl_text);
			tabData.put("eff_status",eff_status);
			tabData.put("ADDED_BY_ID", added_by_id);
			tabData.put("ADDED_DATE", addeddate);
			tabData.put("ADDED_AT_WS_NO",  client_ip_address);
			tabData.put("ADDED_FACILITY_ID",  facility_id);
			tabData.put("MODIFIED_BY_ID", added_by_id);
			tabData.put("MODIFIED_DATE", addeddate);
			tabData.put("MODIFIED_AT_WS_NO", client_ip_address);
			tabData.put("MODIFIED_FACILITY_ID", facility_id);
			
			String dupflds[]={"skill_code"};

			try{
				boolean local_ejbs = false;
				ServletContext context = getServletConfig().getServletContext();
				if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				local_ejbs = true;
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
				Object argArray[] = new Object[4];
				String table_name="rs_skill";
				argArray[0] =p;
				argArray[1] =tabData;
				argArray[2] =dupflds;
				argArray[3] =table_name;

				Class [] paramArray = new Class[4];
				paramArray[0] =p.getClass();
				paramArray[1] =tabData.getClass();
				paramArray[2] =dupflds.getClass();
				paramArray[3] =table_name.getClass();
				
				HashMap results = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

				String error = (String) results.get("error") ;

	    		   if ( inserted ){
					    error_value= "1";
		     			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );
	        	   }
		     	   else{
						response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );
		     	   }
		     }
			 catch(Exception e){
                  e.printStackTrace();
				  String error = "Error ";
			      response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );
	            }
	  }
	  catch ( Exception e ){
		e.printStackTrace();
		out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
      }
  } // End insert

/**************************************************/
	public void modify(HttpServletRequest request,HttpServletResponse response)throws Exception{
		try{	
			HashMap tabData=new HashMap();
			added_by_id 	= p.getProperty( "login_user" ) ;
			String mfddate = dateFormat.format( new java.util.Date() ) ;

			skill_code = request.getParameter("skill_code")==null ? "":request.getParameter("skill_code");
			skill_desc = request.getParameter("skill_desc")==null ? "":request.getParameter("skill_desc");
			skill_expl_text = request.getParameter("skill_expl_text")==null ? "":request.getParameter("skill_expl_text");
			eff_status = request.getParameter("eff_status")==null ? "D":request.getParameter("eff_status");
	
			tabData.put("skill_code",skill_code);
			tabData.put("skill_desc",skill_desc);
			tabData.put("skill_expl_text",skill_expl_text);
			tabData.put("eff_status",eff_status);
			
			tabData.put("MODIFIED_BY_ID", added_by_id);
			tabData.put("MODIFIED_DATE", mfddate);
			tabData.put("MODIFIED_AT_WS_NO", client_ip_address);
			tabData.put("MODIFIED_FACILITY_ID", facility_id);
					
			HashMap condflds=new HashMap();
			condflds.put("skill_code",skill_code);

			try{
				boolean local_ejbs = false;
				ServletContext context = getServletConfig().getServletContext();
				if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				local_ejbs = true;
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
				Object argArray[] = new Object[4];
				String table_name="rs_skill";
				argArray[0] =p;
				argArray[1] =tabData;
				argArray[2] =condflds;
				argArray[3] =table_name;

				Class [] paramArray = new Class[4];
				paramArray[0] =p.getClass();
				paramArray[1] =tabData.getClass();
				paramArray[2] =condflds.getClass();
				paramArray[3] =table_name.getClass();
				
				HashMap results = (HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

				inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
				String error = (String) results.get("error") ;

	    		   if ( inserted ){
					    error_value= "1";
		     			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );
	        	   }
		     	   else{
						response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );
		     	   }
		     }
			 catch(Exception e){
                  e.printStackTrace();
				  String error = "Error ";
			      response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );
	            }
	  }
	  catch ( Exception e ){
		e.printStackTrace();
		out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
      }
  } // End modify 
}		
