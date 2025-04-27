/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Rev.Date	Rev.Name 		Description
--------------------------------------------------------------------------------------------------------------
26/11/2014	IN050580		Nijitha 								MO-CRF-20080
																				
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/
package eCA;

import javax.naming.*;
import javax.ejb.*;
import javax.rmi.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.rmi.*;
import java.sql.*;

import eCA.ReviewNotes.*;
import webbeans.eCommon.*;


public class ReviewNotesServlet extends javax.servlet.http.HttpServlet
{
	public void init(ServletConfig config) throws ServletException	
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		HttpSession				session			=	null;
		PrintWriter				out				=	null;

		try
		{
			out = res.getWriter();
			session = req.getSession(false);			
			insertReviewNotes(req,session,out);
		}
		catch (Exception e)	{
			out.println("In post "+e);
			e.printStackTrace();
		}
	}

	private void insertReviewNotes(HttpServletRequest req, HttpSession session, PrintWriter out)	
	{
		java.util.Properties	p				=	null;
		p = (java.util.Properties) session.getValue("jdbc") ;
		String	locale	= (String) p.getProperty("LOCALE");
		java.util.HashMap htReviewNotesProp	=	new	java.util.HashMap();
		String	login_user_id		=	"",		login_at_ws_no		=	"";
		String	 final_values =	"";
		String	 facility_id =	"";
		String	 requested_to =	"";
		
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


		try
		{
			final_values	=	req.getParameter("final_values")==null?"":req.getParameter("final_values");		
			facility_id		=	req.getParameter("facility_id")==null?"":req.getParameter("facility_id");
			requested_to = req.getParameter("requested_to");
		    if(requested_to==null)
			requested_to = "P";
			login_at_ws_no	=	req.getRemoteAddr();
			
			login_user_id	=	(String)	session.getValue("login_user");
	
			htReviewNotesProp.put	(	"final_values",		final_values	);
			htReviewNotesProp.put	(	"facility_id",		facility_id		);
			htReviewNotesProp.put	(	"login_user_id",	login_user_id	);
			htReviewNotesProp.put	(	"login_at_ws_no",	login_at_ws_no	);
			htReviewNotesProp.put	(	"locale",	locale	);

			boolean local_ejbs = false;
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/ReviewNotes",ReviewNotesHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = htReviewNotesProp;
			
			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = htReviewNotesProp.getClass();


			
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertReviewNotes",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			htReviewNotesProp.clear();

			paramArray=null;
			argArray=null;
			
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			results.clear();

			out.println("<html><link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link>");
			out.println("<BODY CLASS='MESSAGE'>");
			out.println(error);

			if(inserted)
			{
				out.println("<script language=\"javascript\">");
				out.println("if(top.content.workAreaFrame.refferalTrackingNotesRefferedFrom!=undefined && top.content.workAreaFrame.refferalTrackingNotesRefferedFrom!=null ){");
				out.println("top.content.workAreaFrame.refferalTrackingNotesRefferedFrom.onSuccess()");
				out.println("}");
				out.println("else{");
				out.println("top.content.workAreaFrame.ReviewNotesCriteriaFrame.onSuccess()");  
				out.println("}");//IN050580			
				out.println("</script>");
			}
		
				out.println("</BODY></html>");
		}
		catch ( Exception e )
		{
			e.printStackTrace();
			//out.println("<html><link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link>");
			//out.println("<BODY CLASS='MESSAGE'>");
			//out.println(e);//common-icn-0181
			out.println("</BODY></html>");
		}
	}
}//E.O.CLass
