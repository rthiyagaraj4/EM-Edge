/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eFM;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import com.ehis.util.*;

import eFM.FMAutoTrackOutToOPD.* ;

//public class  extends javax.servlet.http.HttpServlet	

public class FMAutoTrackOutToOPDServlet extends HttpServlet implements SingleThreadModel
{
	HttpSession				session	=	null;
    java.io.PrintWriter		out		=	null;
    java.util.Properties	p		=	null;

	String login_facility_id  =	"";
	String login_user_id	  = "";
	String addedAtWorkstation = "";

	String iss_locn_code	= "";
	String iss_locn_iden	= "";
	String iss_mr_locn		= "";
	String appt_date		= "";
	String issue_user		= "";
	String from_clinic		= "";
	String to_clinic		= "";
	String p_fm_pract_id	= "";
	String p_to_pract_id	= "";
	String p_print_card		= "";
	String locale			= "" ;
	String autotrack_upon_confirm_pl_yn			= "" ;
	String appt_date2	= "";
    String iss_locn_code_cmb = "";
   /* Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 20th 2014 Start*/
    String start_time		 = "";
    String end_time			 = "";
    /* Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 20th 2014 End*/ 
	public void init(ServletConfig config) throws ServletException	
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest request, HttpServletResponse response)
        throws javax.servlet.ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		try 
		{
			this.out = response.getWriter();
            createAutoTrackout(request,response);
		}
		catch(Exception e)
		{
			out.println("Exception@Servlet:1 : "+e);
		}
    }

	public void doGet(HttpServletRequest request, HttpServletResponse response)
 	throws javax.servlet.ServletException,IOException
	{
		try	
		{
			this.out = response.getWriter();
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			out.println ("<html><head>");
			out.println ("<link rel='stylesheet' type='text/css' href='../eCommon/html/IeStyle.css'></link>");
			out.println ("<body class='MESSAGE'>");
		}
		catch(Exception e)	{	
		out.println("Exception in doGet method :"+e.toString());
		}
	}
		
	private void createAutoTrackout(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException
	{
		response.setContentType("text/html");

		HashMap htOPD	  =	new java.util.HashMap();

		try
        {	
			session				=	request.getSession(false);
			p					=	(java.util.Properties) session.getValue( "jdbc" ) ;
			locale = p.getProperty("LOCALE");
			login_facility_id	=	(String) session.getValue("facility_id");
			login_user_id		=	(String) session.getValue("login_user");
			addedAtWorkstation  = p.getProperty("client_ip_address");

			autotrack_upon_confirm_pl_yn = (String) ( request.getAttribute("autotrack_upon_confirm_pl_yn")==null ? "N" : request.getAttribute("autotrack_upon_confirm_pl_yn"));
		if(!autotrack_upon_confirm_pl_yn.equals("Y"))
		{
			iss_locn_code		=	request.getParameter("iss_locn_code");
			iss_locn_iden		=	request.getParameter("iss_locn_iden");
			iss_mr_locn			=	request.getParameter("iss_locn_mryn");
			appt_date			=	request.getParameter("appt_date");
			issue_user			=	request.getParameter("issue_user");
			from_clinic			=	request.getParameter("from_clinic");
			to_clinic			=	request.getParameter("to_clinic");
			p_print_card		=	request.getParameter("print_card");
			/* Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 20th 2014 Start*/
			start_time			=   (request.getParameter("start_time")=="" || request.getParameter("start_time")==null)?request.getParameter("start_time"):request.getParameter("start_time");
			end_time			=   (request.getParameter("end_time")=="" || request.getParameter("end_time")==null)?request.getParameter("end_time"):request.getParameter("end_time");
			/* Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 20th 2014 End*/
		
		}
		else
		{
			iss_locn_code		=	(String) request.getAttribute("iss_locn_code");
			iss_locn_iden		=	(String) request.getAttribute("iss_locn_iden");
			iss_mr_locn			=	(String) request.getAttribute("iss_locn_mryn");
			appt_date			=	(String) request.getAttribute("appt_date");
			issue_user			=	(String) request.getAttribute("issue_user");
			from_clinic			=	(String) request.getAttribute("from_clinic");
			to_clinic			=	(String) request.getAttribute("to_clinic");
			p_print_card		=	(String) request.getAttribute("print_card");
			/* Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 20th 2014 Start*/
			if(!request.getAttribute("start_time").equals(""))
				start_time			=   (String) request.getAttribute("start_time");
			if(!request.getAttribute("end_time").equals(""))
				end_time			=   (String) request.getAttribute("end_time");
			/* Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 20th 2014 End*/
		}
			
	 
	/*
			if (appt_date != null)
			{
				appt_date=DateUtils.convertDate(appt_date,"DMY",locale,"en");
			}
			else
				appt_date="";
	*/
 
	
			if (from_clinic==null || from_clinic.equals("null"))
			{
				from_clinic="";
			}

			if (to_clinic==null || to_clinic.equals("null"))
			{
				to_clinic="";
			}			
			

			if (p_print_card==null)
			{
				p_print_card="N";
			}

			try
			{
				htOPD.put ( "login_facility_id", login_facility_id );
				htOPD.put ( "login_user_id", login_user_id );
				htOPD.put ( "addedAtWorkstation", addedAtWorkstation );
				htOPD.put ( "p_iss_locn_code", iss_locn_code );
				htOPD.put ( "p_iss_locn_iden", iss_locn_iden );
				htOPD.put ( "p_iss_mr_locn", iss_mr_locn );
				htOPD.put ( "p_appt_date", appt_date );
				htOPD.put ( "p_issue_user", issue_user );
				htOPD.put ( "p_from_clinic", from_clinic );
				htOPD.put ( "p_to_clinic", to_clinic );
				htOPD.put ( "locale", locale );
			    htOPD.put ( "iss_locn_code_cmb", iss_locn_code_cmb );
			    /* Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 20th 2014 Start*/
			    htOPD.put ( "start_time", start_time );
			    htOPD.put ( "end_time", end_time );
			    /* Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 20th 2014 End*/
			}														
			catch(Exception e)
			{
				out.println("Exception while putting HashMap datas!"+e);
				out.flush();
				return;
			}

			try
			{				
				boolean inserted = false;
				String error_msg="",error_val = "";

			
				try
				{
					boolean local_ejbs = false;
					if((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
					
					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/FMAutoTrackOutToOPD",FMAutoTrackOutToOPDHome.class,local_ejbs);
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
					
					Object argArray[] = new Object[2];
					argArray[0] = p;
					argArray[1] = htOPD;
					
					
					Class [] paramArray = new Class[2];
					paramArray[0] = p.getClass();
					paramArray[1] = htOPD.getClass();
					
					
					java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("createOPD",paramArray)).invoke(busObj,argArray);
					(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
					
					inserted	=	(((Boolean) results.get( "status" )).booleanValue()) ;
					error_msg	=	(String)	results.get("error") ;
					error_val	=	(String)	results.get("errorval");
					results.clear();
					htOPD.clear();
				}
				catch(Exception e)
				{
					out.println("Exception@recordingEJB : "+e);
					out.println(e.toString());
				}

				
			
				if ( inserted )
				{	
					
					if(!autotrack_upon_confirm_pl_yn.equals("Y"))
					{
		
					if (p_print_card.equals("Y"))
					{

			out.println("<script>parent.frames(1).doOnlineReportPrintingTrackout('"+error_msg+"','"+error_val+"','"+login_facility_id+"','"+login_user_id+"','"+from_clinic+"','"+to_clinic+"','"+p_fm_pract_id+"','"+p_to_pract_id+"','"+appt_date+"','"+iss_locn_code+"');</script>");	
				
					}else{

       if (error_val.equals("1"))
				{
					response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error_msg,"UTF-8" )+"&err_value=1" );
				}
				else
				{
					response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error_msg,"UTF-8" )+"&err_value=0" );
				}


					}
					}else{
       if (error_val.equals("1"))
				{
					response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error_msg,"UTF-8" )+"&err_value=1" );
				}
				else
				{
					response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error_msg,"UTF-8" )+"&err_value=0" );
				}


					}
				
				}else{

     if (error_val.equals("1"))
				{
					response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error_msg,"UTF-8" )+"&err_value=1" );
				}
				else
				{
					response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error_msg,"UTF-8" )+"&err_value=0" );
				}


				}
		
			}
			catch(Exception e)
			{
				out.println("Exception while accessing EJB for Updating Records!"+e);
			}
        } 
		catch(Exception e)
		{
			out.println("Exception@Insert:1 : "+e);
			out.println(e.toString());
		} 

    } // end of method createAutoTrackout
	
} // end of class FMConfirmReceiptFilesServlet 
