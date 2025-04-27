/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
20/01/2012		CHL-CRF [IN035950]	Ramesh G	CHL-CRF [IN035950]										
-------------------------------------------------------------------------------------------------------------------------------------
*/
package eCA;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.text.*;
import eCA.RecPatChiefComplaint.*;
import eCommon.XSSRequestWrapper;

public class RecPatChiefComplaintServlet extends javax.servlet.http.HttpServlet	
{	
	public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}
	
	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		PrintWriter out = null;
		String mode = "";
		
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
req= new XSSRequestWrapper(req); //MMS-ME-SCF-0097
res.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
res.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		
		HttpSession session = req.getSession(false);	
		mode = req.getParameter("mode");
		
		try 
		{
			out = res.getWriter();

			if(mode.equals("insert"))
				 insertChiefComplaint(req,res,session,out);
			else if(mode.equals("modify"))
				 modifyChiefComplaint(req,res,session,out);


		} 
		catch (Exception e)
		{
			out.println("Exception Occured-->"+e.toString());
			e.printStackTrace();
		}
	}

private void insertChiefComplaint(HttpServletRequest req, HttpServletResponse res, HttpSession session, PrintWriter out)
{	
	java.util.Properties p		= (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale				= (String) p.getProperty("LOCALE");
	String client_ip_address	= (String) p.getProperty("client_ip_address");
	String x_facility_id		= (String)session.getValue("facility_id") ;

	String error				=	"";
	String eid					=	"";
	String x_complaint_id		=	"";
	String x_onset_date			=	"";
	String x_remarks			=	"";
	String x_complaint_details	=	"";
	String open_in_modal	=	"";
	String p_called_from_widget = "";  //CHL-CRF Start.[IN035950]
	long  x_encounter_id		=	0;

	try
	{
		x_facility_id			= req.getParameter("facility_id")==null?"":req.getParameter("facility_id");
		x_complaint_id			= req.getParameter("complaint_id")==null?"":req.getParameter("complaint_id");
		x_onset_date			= req.getParameter("onset_date")==null?"":req.getParameter("onset_date");
		x_remarks				= req.getParameter("remarks")==null?"":req.getParameter("remarks");
		eid						= req.getParameter("encounter_id")==null?"":req.getParameter("encounter_id");
        x_complaint_details		= req.getParameter("complaint_details")==null?"":req.getParameter("complaint_details");
		x_onset_date			= com.ehis.util.DateUtils.convertDate(x_onset_date,"DMYHM",locale,"en");
		open_in_modal            =  req.getParameter("open_in_modal");
		p_called_from_widget	= req.getParameter("p_called_from_widget")==null?"":req.getParameter("p_called_from_widget");  //CHL-CRF Start.[IN035950]
	    if(open_in_modal.equals(null)||open_in_modal.equals("null"))open_in_modal=""; 

	
		x_encounter_id 			= Long.parseLong(eid);
	
		boolean local_ejbs = false;
		
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/RecPatChiefComplaint",RecPatChiefComplaintHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		Object argArray[] = new Object[9];
		argArray[0] = p;
		argArray[1] = x_facility_id;
		argArray[2] = new Long(x_encounter_id);
		argArray[3] = x_complaint_id;
		argArray[4] = x_onset_date;
		argArray[5] = x_remarks;
		argArray[6] = client_ip_address;
		argArray[7] = locale;
		argArray[8] = x_complaint_details;
		
		Class paramArray[] = new Class[9];
		paramArray[0] = p.getClass();
		paramArray[1] = x_facility_id.getClass();
		paramArray[2] = new Long(x_encounter_id).getClass();
		paramArray[3] = x_complaint_id.getClass();
		paramArray[4] = x_onset_date.getClass();
		paramArray[5] = x_remarks.getClass();
		paramArray[6] = client_ip_address.getClass();
		paramArray[7] = locale.getClass();
        paramArray[8] = x_complaint_details.getClass();

		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertChiefComplaint",paramArray)).invoke(busObj,argArray);
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
		argArray = null; 
		paramArray = null;
		
		boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

		error				= (String) results.get("error") ;

		String error_value	= "0" ;
		results.clear();
	if(!open_in_modal.equals("Y"))
	{
		if(inserted)
			error_value = "1";

		//CHL-CRF Start.[IN035950]
			//res.sendRedirect("../eCA/jsp/RecPatChiefComplaintError.jsp?encounter_id="+x_encounter_id+"&err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") + "&err_value=" + error_value );
			res.sendRedirect("../eCA/jsp/RecPatChiefComplaintError.jsp?encounter_id="+x_encounter_id+"&err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") + "&err_value=" + error_value +"&p_called_from_widget="+p_called_from_widget);
		//CHL-CRF End.[IN035950]
     }
	else
	{
		//error	=	error.substring(0,error.indexOf("<br>"));
			out.println("<script>alert('"+error+"');</script>");
		if ( inserted ){
			out.println("<html><head><script language='javascript'>");
			//CHL-CRF Start.[IN035950]
				//out.println("parent.frames(0).location.href=\"../eCA/jsp/RecPatChiefComplaintResult.jsp?encounter_id="+x_encounter_id+"&open_in_modal="+open_in_modal+"\";");	
				//out.println("parent.frames(1).location.href=\"../eCA/jsp/RecPatChiefComplaintAddModify.jsp?encounter_id="+x_encounter_id+"&open_in_modal="+open_in_modal+"\";");
				out.println("parent.frames[0].location.href=\"../eCA/jsp/RecPatChiefComplaintResult.jsp?encounter_id="+x_encounter_id+"&open_in_modal="+open_in_modal+"&p_called_from_widget="+p_called_from_widget+"\";");	
				out.println("parent.frames[1].location.href=\"../eCA/jsp/RecPatChiefComplaintAddModify.jsp?encounter_id="+x_encounter_id+"&open_in_modal="+open_in_modal+"&p_called_from_widget="+p_called_from_widget+"\";");
			//CHL-CRF End.[IN035950]
			out.println("</script></html>");
		}


	}
	} 
	catch ( Exception e ) 
	{
			//out.println("Exception @ RecPatChiefComplaintServlet "+e.toString());//common-icn-0181
			
			e.printStackTrace();
    }

   finally
   {
			
   }
}

private void modifyChiefComplaint(HttpServletRequest req, HttpServletResponse res, HttpSession session, PrintWriter out)	
{
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	
	String client_ip_address	= (String) p.getProperty("client_ip_address");
	String locale				= (String) p.getProperty("LOCALE");
	
	String x_complaint_id		= "";
	String x_onset_date			= "";
	String x_remarks			= "";
	String x_facility_id		= "";
	String eid					= "";
	String err_remarks			= "";
	String x_complaint_details	= "";
	String x_error_yn	        = "";
	String open_in_modal	=	"";
	String p_called_from_widget = "";  //CHL-CRF [IN035950] 
	long  x_encounter_id= 0;

	try 
	{
			String error = "";
			
			x_facility_id	= req.getParameter("facility_id")==null?"":req.getParameter("facility_id");
			x_complaint_id	= req.getParameter("complaint_id")==null?"":req.getParameter("complaint_id");
			x_onset_date	= req.getParameter("onset_date")==null?"":req.getParameter("onset_date");
			x_remarks		= req.getParameter("remarks")==null?"":req.getParameter("remarks");
			eid				= req.getParameter("encounter_id")==null?"":req.getParameter("encounter_id");
			err_remarks		= req.getParameter("err_remarks")==null?"":req.getParameter("err_remarks");
		    x_complaint_details		= req.getParameter("complaint_details")==null?"":req.getParameter("complaint_details");
		    x_error_yn		= req.getParameter("error_yn")==null?"N":"Y";
						
			x_onset_date	= com.ehis.util.DateUtils.convertDate(x_onset_date,"DMYHM",locale,"en");
			x_encounter_id 	= Long.parseLong(eid);
			open_in_modal            =  req.getParameter("open_in_modal");
			p_called_from_widget	= req.getParameter("p_called_from_widget")==null?"":req.getParameter("p_called_from_widget"); //CHL-CRF[IN035950]
	        if(open_in_modal.equals(null)||open_in_modal.equals("null"))open_in_modal=""; 
		
			boolean local_ejbs = false;
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/RecPatChiefComplaint",RecPatChiefComplaintHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[11];
			argArray[0] = p;
			argArray[1] = x_facility_id;
			argArray[2] = new Long(x_encounter_id);
			argArray[3] = x_complaint_id;
			argArray[4] = x_onset_date;
			argArray[5] = x_remarks;
			argArray[6] = client_ip_address;
			argArray[7] = locale;
			argArray[8] = err_remarks;
            argArray[9] = x_complaint_details;
			argArray[10] = x_error_yn;
			
			Class paramArray[] = new Class[11];
			paramArray[0] = p.getClass();
			paramArray[1] = x_facility_id.getClass();
			paramArray[2] = new Long(x_encounter_id).getClass();
			paramArray[3] = x_complaint_id.getClass();
			paramArray[4] = x_onset_date.getClass();
			paramArray[5] = x_remarks.getClass();
			paramArray[6] = client_ip_address.getClass();
			paramArray[7] = locale.getClass();
			paramArray[8] = err_remarks.getClass();
			paramArray[9] = x_complaint_details.getClass();
			paramArray[10] = x_error_yn.getClass();

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("modifyChiefComplaint",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			argArray = null; 
			paramArray = null;			
			
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			error = (String) results.get("error") ;
			
			String error_value	= "0" ;

			results.clear();


			if(!open_in_modal.equals("Y"))
	        {

			  if (inserted ) 
				error_value = "1" ;

			//CHL-CRF Start.[IN035950]
				//res.sendRedirect("../eCA/jsp/RecPatChiefComplaintError.jsp?encounter_id="+x_encounter_id+"&err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") + "&err_value=" + error_value );
				res.sendRedirect("../eCA/jsp/RecPatChiefComplaintError.jsp?encounter_id="+x_encounter_id+"&err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") + "&err_value=" + error_value +"&p_called_from_widget="+p_called_from_widget);
			//CHL-CRF End.[IN035950]
		   }
		  else
	      {
		    //error	=	error.substring(0,error.indexOf("<br>"));
			out.println("<script>alert('"+error+"');</script>");
		    if (inserted )
		    {
			out.println("<html><head><script language='javascript'>");
			//CHL-CRF Start.[IN035950]
				//out.println("parent.frames(0).location.href=\"../eCA/jsp/RecPatChiefComplaintResult.jsp?encounter_id="+x_encounter_id+"&open_in_modal="+open_in_modal+"\";");	
				//out.println("parent.frames(1).location.href=\"../eCA/jsp/RecPatChiefComplaintAddModify.jsp?encounter_id="+x_encounter_id+"&open_in_modal="+open_in_modal+"\";");
				out.println("parent.frames[0].location.href=\"../eCA/jsp/RecPatChiefComplaintResult.jsp?encounter_id="+x_encounter_id+"&open_in_modal="+open_in_modal+"&p_called_from_widget="+p_called_from_widget+"\";");	
				out.println("parent.frames[1].location.href=\"../eCA/jsp/RecPatChiefComplaintAddModify.jsp?encounter_id="+x_encounter_id+"&open_in_modal="+open_in_modal+"&p_called_from_widget="+p_called_from_widget+"\";");
			//CHL-CRF End.[IN035950]
			out.println("</script></html>");
		   }
	     }						
	   } 
		catch ( Exception e ) 
		{
			//out.println(" Exception in RecPatChiefComplaintServlet MODIFY MODE"+e.toString());//common-icn-0181
			
			e.printStackTrace();
		}
	   finally
	   {
	   }
	}
}
