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

public class TrainingServlet extends HttpServlet{

	private ServletConfig config = null;
	PrintWriter out = null;
	HttpSession session = null;
	String facility_id = "";
	Properties p = new Properties();
	String client_ip_address = "";
	String error_value ="0";
	boolean inserted= false;

	String training_code="";
	String training_desc="";
	String training_expl_text="";
	String eff_status="";
	String added_by_id = "";
	
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;	

	public void init(ServletConfig config) throws ServletException{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException{

	
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");

		this.out = res.getWriter();
		try{

			session = req.getSession(false);
			this.facility_id = (String) session.getAttribute( "facility_id" ) ;
			this.p = (java.util.Properties) session.getAttribute( "jdbc" ) ;
			this.client_ip_address = p.getProperty("client_ip_address");

			training_code=req.getParameter("training_code")==null ? "":req.getParameter("training_code");
			training_desc=req.getParameter("training_desc")==null ? "":req.getParameter("training_desc");
			training_expl_text=req.getParameter("training_expl_text")==null ? "":req.getParameter("training_expl_text");
			eff_status=req.getParameter("eff_status")==null ? "D":req.getParameter("eff_status");
			String operation = req.getParameter("operation_type");
			if ( operation.equals("insert"))
				insertOperation( res);
			if ( operation.equals("modify")) 
				modifyOperation( res);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void insertOperation(HttpServletResponse res) throws Exception{
				
		try{

			String addeddate = dateFormat.format( new java.util.Date() ) ;
			facility_id = (String) session.getAttribute( "facility_id" ) ;
			added_by_id 	= p.getProperty( "login_user" ) ;

			HashMap tabData=new HashMap();

			tabData.put("training_code",training_code);
			tabData.put("training_desc",training_desc);
			tabData.put("training_expl_text",training_expl_text);
			tabData.put("eff_status",eff_status);
			tabData.put("ADDED_BY_ID", added_by_id);
			tabData.put("ADDED_DATE", addeddate);
			tabData.put("ADDED_AT_WS_NO",  client_ip_address);
			tabData.put("ADDED_FACILITY_ID",  facility_id);
			tabData.put("MODIFIED_BY_ID", added_by_id);
			tabData.put("MODIFIED_DATE", addeddate);
			tabData.put("MODIFIED_AT_WS_NO", client_ip_address);
			tabData.put("MODIFIED_FACILITY_ID", facility_id);

			String dupflds[]={"training_code"};

			try{
				boolean local_ejbs = false;
				ServletContext context = getServletConfig().getServletContext();
				if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				local_ejbs = true;
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
				Object argArray[] = new Object[4];
				String table_name="rs_training";
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

				inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
				String error = (String) results.get("error") ;
	    		if ( inserted ){
					error_value= "1";
					res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );
				}
		     	else{
					res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );
				}
		     }
			 catch(Exception e){
                  e.printStackTrace();
				  String error = "Error ";
			      res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );
	            }
		}
		catch ( Exception e ){
			e.printStackTrace();
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
		}
	} //End of Insert

	public void modifyOperation(HttpServletResponse res) throws Exception{

		try{
			String addeddate = dateFormat.format( new java.util.Date() ) ;
			facility_id = (String) session.getAttribute( "facility_id" ); 


			added_by_id 	= p.getProperty( "login_user" ) ;
		
			HashMap tabData=new HashMap();

			tabData.put("training_desc",training_desc);
			tabData.put("training_expl_text",training_expl_text);
			tabData.put("eff_status",eff_status);
			tabData.put("MODIFIED_BY_ID", added_by_id);
			tabData.put("MODIFIED_DATE", addeddate);
			tabData.put("MODIFIED_AT_WS_NO", client_ip_address);
			tabData.put("MODIFIED_FACILITY_ID", facility_id);
			HashMap condflds=new HashMap();
			condflds.put("training_code",training_code);

			try{
				
				boolean local_ejbs = false;
				ServletContext context = getServletConfig().getServletContext();
				if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				local_ejbs = true;
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
				Object argArray[] = new Object[4];
				String table_name="rs_training";
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
					res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );
			   }
			   else{
					res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );
			   }
					   
			}
			catch(Exception e){
				e.printStackTrace();
				String error = "Error ";
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );
			}
		}
		catch ( Exception e ){
			e.printStackTrace();
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
		}
	  } // End of the modifyParameter
  }		
