/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/***** Last Modified Date 9/21/2005 4:18 PM *******/
package eMP;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import javax.naming.*;
import javax.rmi.*;
import java.sql.*;
import java.util.*;

import eCommon.SingleTabHandler.*;


public class ActivateInactivatePatientServlet extends HttpServlet 
{
	public void init(ServletConfig config) throws ServletException	
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException 
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		HttpSession session = req.getSession(false);
		Properties p = (java.util.Properties) session.getValue("jdbc") ;
		PrintWriter out=null;
		try 
		{
			out = res.getWriter();
			String Action = req.getParameter("Action")==null ? "" : req.getParameter("Action");
			String Reason = req.getParameter("Reason")==null ? "" : req.getParameter("Reason");
		
			String Active_Yn="";
			String Status_Remarks="";
			if(Action.equals("Active")) 
			{
				Active_Yn = "Y" ;
				Status_Remarks = req.getParameter("Activate_Remarks")==null ? "" : req.getParameter("Activate_Remarks");
			}
			else 
			{
				Active_Yn ="N" ;
				Status_Remarks = req.getParameter("Inactivate_Remarks")==null ? "" : req.getParameter("Inactivate_Remarks");
			}

			HashMap tabdata = new HashMap();

			tabdata.put("Active_Yn",Active_Yn);
			tabdata.put("inact_act_reason_code",Reason);
			tabdata.put("inact_act_remarks",Status_Remarks);
			tabdata.put("modified_by_id",p.getProperty( "login_user"));
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",(String) session.getValue( "facility_id"));
			tabdata.put("modified_at_ws_no",p.getProperty("client_ip_address") );

			HashMap condflds=new HashMap();
			condflds.put("patient_id",req.getParameter("Patient_Id")==null ? "" : req.getParameter("Patient_Id"));
			boolean local_ejbs = isLocalEJB();
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = condflds;
			argArray[3] = "mp_patient";

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass(); ;
			paramArray[1] = tabdata.getClass();
			paramArray[2] = condflds.getClass();
			paramArray[3] = String.class;
			
			java.util.HashMap results = (HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			
			argArray = null;
			paramArray = null;
			tabdata.clear();
			condflds.clear();

			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			results.clear();
			if(inserted)
			{
				String error_num = " " ;
			 	res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + error_num + "&err_value=1");
			}
			else
			{
				 res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error, "UTF-8") );
			}

			
		}
		catch (Exception e)	
		{
			/* out.println(e.getMessage());
			out.println(e.toString()); */
			e.printStackTrace();
		}
	}	
	boolean isLocalEJB()
	{
		ServletContext context = getServletConfig().getServletContext();

		if((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
