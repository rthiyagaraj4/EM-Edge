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
import eFM.FMAutoTrackOutToIPW.* ;

//public class  extends javax.servlet.http.HttpServlet	

public class FMAutoTrackOutToIPWServlet extends HttpServlet implements SingleThreadModel
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
	String preferred_date		= "";
	String issue_user		= "";
	String from_nursing_unit		= "";
	String to_nursing_unit		= "";
	String p_fm_pract_id	= "";
	String p_to_pract_id	= "";
	String p_print_card		= "";
	String locale			= "" ;
	String autotrack_upon_confirm_pl_yn			= "" ;
    String p_gender="";
	String p_pull_list_no="";
	String print_pulled_list="N";
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

		HashMap htIPW	  =	new java.util.HashMap();

		try
        {	
			session				=	request.getSession(false);
			p					=	(java.util.Properties) session.getValue( "jdbc" ) ;
			locale = p.getProperty("LOCALE");
			login_facility_id	=	(String) session.getValue("facility_id");
			login_user_id		=	(String) session.getValue("login_user");
			addedAtWorkstation  = p.getProperty("client_ip_address");

      autotrack_upon_confirm_pl_yn = (String) ( request.getAttribute("autotrack_upon_confirm_pl_yn")==null ? "N" : request.getAttribute("autotrack_upon_confirm_pl_yn"));

			Connection con	=	null;
			con									=	ConnectionManager.getConnection(request);
			
			if(!autotrack_upon_confirm_pl_yn.equals("Y"))
			{
			iss_locn_code		=	request.getParameter("iss_locn_code");
			iss_locn_iden		=	request.getParameter("iss_locn_iden");
			iss_mr_locn			=	request.getParameter("iss_locn_mryn");
			preferred_date			=	request.getParameter("preferred_date");
			issue_user			=	request.getParameter("issue_user");
			from_nursing_unit			=	request.getParameter("from_nursing_unit");
			to_nursing_unit			=	request.getParameter("to_nursing_unit");
			p_print_card		=	request.getParameter("print_card");
			}
			else
			{
			iss_locn_code		=	(String) request.getAttribute("iss_locn_code");
			//iss_locn_iden		=	(String) request.getAttribute("iss_locn_iden");
			//iss_mr_locn			=	(String) request.getAttribute("iss_locn_mryn");
			preferred_date			=	(String) request.getAttribute("preferred_date");
			issue_user			=	(String) request.getAttribute("issue_user");
			from_nursing_unit			=	(String) request.getAttribute("from_nursing_unit");
			to_nursing_unit			=	(String) request.getAttribute("to_nursing_unit");
			p_print_card		=	(String) request.getAttribute("print_card");
            p_fm_pract_id  =	(String) request.getAttribute("p_fm_pract_id");
			 p_to_pract_id  =	(String) request.getAttribute("p_to_pract_id");
			 p_gender  =	(String) request.getAttribute("p_gender");
			 p_pull_list_no  =	(String) request.getAttribute("p_pull_list_no");
			 print_pulled_list  =	(String) request.getAttribute("print_pulled_list");
					
			}
			
			
/*
			if (preferred_date != null)
			{
				preferred_date=DateUtils.convertDate(preferred_date,"DMY",locale,"en");
			}
*/
			if (p_print_card==null)
			{
				p_print_card="N";
			}
			
			 if(p_fm_pract_id==null)  
			{ 
			 p_fm_pract_id="";
			}
			if(p_to_pract_id==null)  
			{	
			p_to_pract_id="";
			}
			if(p_gender==null)   
			{
			p_gender="";
			}
			if(p_pull_list_no==null)   
			{
			p_pull_list_no="";
			}
			if(print_pulled_list==null)  
			{
			print_pulled_list="N";
			}
					try
			{
				htIPW.put ( "login_facility_id", login_facility_id );
				htIPW.put ( "login_user_id", login_user_id );
				htIPW.put ( "addedAtWorkstation", addedAtWorkstation );
				htIPW.put ( "p_iss_locn_code", iss_locn_code );
				htIPW.put ( "p_iss_locn_iden", iss_locn_iden );
				htIPW.put ( "p_iss_mr_locn", iss_mr_locn );
				htIPW.put ( "p_preferred_date", preferred_date );
				htIPW.put ( "p_issue_user", issue_user );
				htIPW.put ( "p_from_nursing_unit", from_nursing_unit );
				htIPW.put ( "p_to_nursing_unit", to_nursing_unit );
				htIPW.put ( "locale", locale );
			}														
			catch(Exception e)
			{
				out.println("Exception while putting HashMap datas!"+e);
				e.printStackTrace();
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
					
					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/FMAutoTrackOutToIPW",FMAutoTrackOutToIPWHome.class,local_ejbs);
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
					
					Object argArray[] = new Object[2];
					argArray[0] = p;
					argArray[1] = htIPW;
					
					
					Class [] paramArray = new Class[2];
					paramArray[0] = p.getClass();
					paramArray[1] = htIPW.getClass();
					
					java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("createIPW",paramArray)).invoke(busObj,argArray);
					(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
					
					inserted	=	(((Boolean) results.get( "status" )).booleanValue()) ;
					error_msg	=	(String)	results.get("error") ;
					error_val	=	(String)	results.get("errorval");
					results.clear();
					htIPW.clear();
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}

		

			/*	if ( inserted )
				{			
					con.commit();
					if (p_print_card.equals("Y"))
					{
					ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;

					ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport( login_facility_id, "FM","FMBATRCI") ;
					report1.addParameter( "p_facility_id",	login_facility_id ) ;
					report1.addParameter("p_user_name",login_user_id);
					report1.addParameter("p_report_id","FMBATRCI");
					report1.addParameter("p_fm_nursing_unit_code",from_nursing_unit);
					report1.addParameter("p_to_nursing_unit_code",to_nursing_unit);
					report1.addParameter("p_fm_pract_id",p_fm_pract_id);
					report1.addParameter("p_to_pract_id",p_to_pract_id);
					report1.addParameter("p_gender","A");
					report1.addParameter("p_preferred_date",preferred_date);
					report1.addParameter("p_module_id","FM");
					report1.addParameter("P_T_NAME","FM_IP_AUTO_TRACK_LOG");	
					report1.addParameter("p_call_from","AUTO_TRACK");
					onlineReports.add( report1) ;

					String ReportOutput = onlineReports.execute( request, response );
					out.println(ReportOutput);

					}
				
				} */
                   if (inserted)
				    {	
				if(!autotrack_upon_confirm_pl_yn.equals("Y"))
					{
				if (p_print_card.equals("Y"))
					{
			
			out.println("<script>parent.frames(1).doOnlineReportPrintingTrackout('"+error_msg+"','"+error_val+"','"+login_facility_id+"','"+login_user_id+"','"+from_nursing_unit+"','"+to_nursing_unit+"','"+p_fm_pract_id+"','"+p_to_pract_id+"','"+preferred_date+"','"+iss_locn_code+"');</script>");	
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
					} else if(autotrack_upon_confirm_pl_yn.equals("Y"))
					{
				
				     java.util.Hashtable message1 = MessageManager.getMessage(locale, "RECORD_MODIFIED", "SM");
					 error_msg	=	(String) message1.get("message");
				    	message1.clear();	
					
					 response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error_msg,"UTF-8" )+"&err_value=1" );
					// out.println("<script>parent.frames(1).frames(1).doOnlineReportPrinting('"+error_msg+"','"+from_nursing_unit+"','"+to_nursing_unit+"','"+p_fm_pract_id+"','"+p_to_pract_id+"','"+p_gender+"','"+preferred_date+"','"+p_pull_list_no+"','"+iss_locn_code+"','"+issue_user+"','"+print_pulled_list+"','"+p_print_card+"');</script>");
				}
					else{
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
					e.printStackTrace();
			}
			finally
			{				
				ConnectionManager.returnConnection(con, request);			
			}
        } 
		catch(Exception e)
		{
			e.printStackTrace();
		} 

    } // end of method createAutoTrackout

} // end of class FMConfirmReceiptFilesServlet 
