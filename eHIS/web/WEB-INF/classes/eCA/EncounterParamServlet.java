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
Date			Edit History	Name			Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------------
01/04/2015		IN048704		Karthi L							 			Bed Side Referral 									
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
import eCommon.SingleTabHandler.*;

public class EncounterParamServlet extends javax.servlet.http.HttpServlet	
{

public void init(ServletConfig config) throws ServletException	
{
	super.init(config);
}

public void doPost(HttpServletRequest req, HttpServletResponse res)
        throws javax.servlet.ServletException,IOException
{

		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		
		try
		{
			out = res.getWriter();
			insertEncounterParam(req, res);
		} 
		catch(Exception e) 
		{
			//out.println(e.toString());//common-icn-0181
			e.printStackTrace();
		}
}

private void insertEncounterParam(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException 
{
		PrintWriter out;
		
		java.util.Properties p;
		
		String tab_Menu				= "N";
		String days_bkwd_dischg		= "";
		String errorMsg				= "";
		String error_value			= "";
		String days_bkwd_visit		= "";
		String reln_reqd_yn			= "";
		String facilityId			= "" ;
		String client_ip_address	= "";
		String locale				= "";
		String mode					= "";
		String assign_confirm_yn	= "N";// IN048704 
		String condflds[]={};
		String remarks_relationships_yn = "N";//0605

		HashMap dupflds=new HashMap();
		java.util.HashMap results = new HashMap();

		HttpSession session				= req.getSession(false);
		p								= (java.util.Properties) session.getValue( "jdbc" ) ;
		client_ip_address				= (String) p.getProperty("client_ip_address");
		locale							= (String) p.getProperty("LOCALE");
		facilityId						= (String) session.getValue( "facility_id" ) ;
		mode							= req.getParameter("mode");
		tab_Menu						= req.getParameter("chkTabMenu");
		
		if(tab_Menu == null)
			tab_Menu = "N";
		else
			tab_Menu = "Y";

		out = res.getWriter();
		
		try 
		{
					days_bkwd_visit			= req.getParameter("days_bkwd_visit");
					days_bkwd_dischg		= req.getParameter("days_bkwd_dischg");
					reln_reqd_yn			= req.getParameter("reln_reqd_yn");
					assign_confirm_yn		= req.getParameter("assign_confirm_referral_yn")==null?"N":req.getParameter("assign_confirm_referral_yn"); // IN048704
					remarks_relationships_yn = req.getParameter("remarks_relationships_yn")==null?"N":req.getParameter("remarks_relationships_yn"); //0605
					if(reln_reqd_yn == null || reln_reqd_yn.equals(""))
						reln_reqd_yn="N";

					int ilDays_bkwd_visit		= Integer.parseInt(days_bkwd_visit);
					int ilDays_bkwd_dischg		= Integer.parseInt(days_bkwd_dischg);

					String addedById			= p.getProperty( "login_user" ) ;
					String modifiedById			= addedById ;
					String addedFacilityId		= facilityId;
					String modifiedFacilityId	= facilityId ;
					String addedAtWorkstation	= client_ip_address;
					String modifiedAtWorkstation = addedAtWorkstation ;
					
					HashMap tabdata=new HashMap();

					tabdata.put("days_backward_visits",new Integer(ilDays_bkwd_visit));
					tabdata.put("days_backward_discharges",new Integer(ilDays_bkwd_dischg));
					tabdata.put("establish_reln_req_yn",reln_reqd_yn);
					tabdata.put("added_by_id",addedById);
					tabdata.put("added_date",new  java.sql.Timestamp(System.currentTimeMillis()));
					tabdata.put("added_facility_id", addedFacilityId);
					tabdata.put("added_at_ws_no",addedAtWorkstation);
					tabdata.put("modified_by_id",modifiedById);
					tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
					tabdata.put("modified_facility_id",modifiedFacilityId);
					tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
					tabdata.put("TAB_MENU_YN",tab_Menu );
					tabdata.put("assgn_conf_ref_yn", assign_confirm_yn); // IN048704
					tabdata.put("remarks_relationships_yn", remarks_relationships_yn); //0605
					dupflds.put("module_id","CA");
					
					boolean local_ejbs = false;
					String table_data = "CA_ENCNTR_PARAM";
		
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
		Object argArray[] = new Object[4];
		argArray[0] = p;
		argArray[1] = tabdata;

		if(mode.equals("insert"))
			argArray[2] = condflds;
		else  if(mode.equals("update"))
			argArray[2] = dupflds;

		argArray[3] = table_data ;

		Class [] paramArray = new Class[4];
		paramArray[0] = p.getClass();
		paramArray[1] = tabdata.getClass();

		if(mode.equals("insert"))
			paramArray[2] = condflds.getClass();
		else if (mode.equals("update"))
			paramArray[2] = dupflds.getClass();

		paramArray[3] = table_data.getClass();
		
		if(mode.equals("insert"))
				results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
		else if(mode.equals("update"))
				results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);

		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			dupflds.clear();
			tabdata.clear();
			argArray = null;
			paramArray = null;

			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			errorMsg = (String) results.get("error") ;
			
			results.clear();
			error_value = "0" ;
			
			if ( inserted ) 
				error_value = "1" ;
			
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( errorMsg,"UTF-8" ) + "&err_value=" + error_value );
		} 
		catch ( Exception e ) 
		{
			//out.println("Exception in Insert Block :"+e.getMessage());
			//out.println("Exception in Insert Block :"+e.toString());//common-icn-0181
			e.printStackTrace();
		}
	}
}
