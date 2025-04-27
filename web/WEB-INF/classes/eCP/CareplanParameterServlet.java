/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//This file is saved on 18/10/2005.


package eCP;

import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
//import javax.naming.*;
//import javax.rmi.*;
import java.net.*;
import webbeans.eCommon.*;

import eCommon.SingleTabHandler.*;

public class CareplanParameterServlet extends HttpServlet
{
	PrintWriter out;
	java.util.Properties prop;
	HttpSession session;
	private ServletConfig config=null;

	String discr_msr_code = "";       
	String medn_admn_code = "";
	String term_code_yn = "";
	String case_type_yn = "";
	String goal_dfn_lvl;
	String cp_scope;
	String cp_acc;

	String modified_by_id = "";
	String modifiedDate = "";
	String modified_facility_id = "";

	String client_ip_address = "";
		
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" );

    public void init(ServletConfig config)throws ServletException{

		super.init(config);
		this.config = config;
	}

//end of init()

	public  void doPost(HttpServletRequest request, HttpServletResponse response)throws javax.servlet.ServletException,IOException
		{
		this.out = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		session = request.getSession(false);

		this.prop = (java.util.Properties)session.getAttribute("jdbc");
		this.modified_facility_id = (String)session.getAttribute("facility_id");
		client_ip_address = this.prop.getProperty("client_ip_address");
		modified_by_id = (prop.getProperty("login_user")==null)?"":prop.getProperty("login_user");
		modifiedDate = dateFormat.format(new java.util.Date());
		
		try
		{
			modify(request,response);
		}
		catch(Exception e){
			out.println("Exception in try of doPost() of AccuracyServlet.java"+e);
		}
	}//end of doPost()

public  void doGet(HttpServletRequest request,HttpServletResponse response) throws javax.servlet.ServletException,IOException{
	try{
		this.out = response.getWriter();
		response.setContentType("text/html");

		doPost(request,response);
	}
	catch(Exception e){
		out.println("Exception in doGet() of AccuracyServlet.java" +e);
	}
}//end of doGet()

//*******************************************************************************
	public void modify(HttpServletRequest request,HttpServletResponse response)throws Exception{
		try{	

			HashMap Careplanmodifyvalues=new HashMap();
			
			discr_msr_code = request.getParameter("discr_measr_code")==null?"": request.getParameter("discr_measr_code");
			medn_admn_code = request.getParameter("med_adm_code")==null ? "": request.getParameter("med_adm_code");
			term_code_yn = request.getParameter("term_code_yn")==null ? "N":"Y";
			case_type_yn = request.getParameter("case_type_yn")==null ? "N":"Y";
			goal_dfn_lvl = request.getParameter("goal_dfn_lvl")==null ? "":request.getParameter("goal_dfn_lvl");
			cp_scope = request.getParameter("cp_scope")==null ? "":request.getParameter("cp_scope");
			cp_acc = request.getParameter("cp_acc")==null ? "":request.getParameter("cp_acc");
			
			Careplanmodifyvalues.put("DISCR_MSR_FOR_DEPENDENCY",discr_msr_code);
			Careplanmodifyvalues.put("MEDN_ADMN_INTERVENTION_CODE",medn_admn_code);
			Careplanmodifyvalues.put("MULTIPLE_LIB_FOR_TERM_CODE_YN",term_code_yn);
			Careplanmodifyvalues.put("MULTIPLE_LIB_FOR_CASE_TYPE_YN",case_type_yn);
			
			Careplanmodifyvalues.put("MODIFIED_BY_ID", modified_by_id);
			Careplanmodifyvalues.put("MODIFIED_DATE", modifiedDate);
			Careplanmodifyvalues.put("MODIFIED_AT_WS_NO", client_ip_address);
			Careplanmodifyvalues.put("MODIFIED_FACILITY_ID", modified_facility_id);
			Careplanmodifyvalues.put("GOAL_DEFN_LEVEL", goal_dfn_lvl);	
			Careplanmodifyvalues.put("CARE_PLAN_SCOPE", cp_scope);	
			Careplanmodifyvalues.put("ACCURACY_FOR_CARE_PLANS", cp_acc);	

			HashMap condflds=new HashMap();
			condflds.put("MODULE_ID","CP");

			try{
				/*InitialContext context = new InitialContext();
				Object homeObject = context.lookup("java:comp/env/SingleTabHandler");
				final SingleTabHandlerManagerHome singleTabHandlerManagerHome  = (SingleTabHandlerManagerHome) PortableRemoteObject.narrow(homeObject ,SingleTabHandlerManagerHome.class);
				final SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singleTabHandlerManagerHome.create();

				final java.util.HashMap results = singleTabHandlerManagerRemote.update(prop,Careplanmodifyvalues,condflds,"cp_parameter");
				*/
			boolean local_ejbs = false;
			ServletContext context = getServletConfig().getServletContext();
			if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[4];
			String table_name="cp_parameter";
			argArray[0] =prop;
			argArray[1] =Careplanmodifyvalues;
			argArray[2] =condflds;
			argArray[3] =table_name;

			Class [] paramArray = new Class[4];
			paramArray[0] =prop.getClass();
			paramArray[1] =Careplanmodifyvalues.getClass();
			paramArray[2] =condflds.getClass();
			paramArray[3] =table_name.getClass();
			
			HashMap results = (HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

				boolean updated = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
				String error = (String) results.get("error");
				String error_value = "0" ;

	    		   if ( updated )
				   {
					    error_value= "1";
		     			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
	        	   }
		     	   else
		     	   {
						response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8") + "&err_value=" + error_value );
		     	   }
		     }catch(Exception e)
                {
	              out.println("From Servlet--Calling EJB:"+e);
                  e.printStackTrace();
				  String error = "Error ";
				  String error_value = "0" ;
			      response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
	            }
	  }catch ( Exception e )
      {
		e.printStackTrace();
		out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
      }
  } // End modify
}
