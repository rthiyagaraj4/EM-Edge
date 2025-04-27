/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name        	Rev.Date 		Rev.by 					Description
--------------------------------------------------------------------------------------------------------------
14/10/2019		IN071513			Ramesh G		14/10/2019		Ramesh G				ML-BRU-CRF-0585.1
06/04/2020		IN072674			Durga Natarajan	07/04/2020		Ramesh G				MMS-KH-CRF-0032
14/07/2022      33870               Twinkle Shah    21/07/2022		Ramesh G                ML-MMOH-CRF-1763
10/03/2022      36285                Hariharan k       		                                            MMs-DM-CRF-0221.v1.0(003)
16/10/2023  32902              Ranjith P R      17/10/2023		Ramesh G        MMS-DM-CRF-0210
--------------------------------------------------------------------------------------------------------------
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

public class CAParamForFacilityServlet extends javax.servlet.http.HttpServlet	
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
				insertCAParamForFactility(req, res);
			} 
			catch(Exception e) 
			{
				//out.println(e.toString());//common-icn-0181
				e.printStackTrace();
			}
	}

	private void insertCAParamForFactility(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException 
	{
		PrintWriter out;
		
		java.util.Properties p;
		
		
		String errorMsg				= "";
		String error_value			= "";
		
		String facilityId			= "" ;
		String client_ip_address	= "";
		String locale				= "";
		String mode					= "";
		
		String logo_site_facility	= "";
		String ThirdParty_Vitals_Time_Dur= "";///IN072674
		String operationalFacility 	= "";
		String pract_loc_default_yn = null;// 33870 added
		String enablePriSecProcYN= null;// 36285  added
		String hidePatForUnauthPractYN= null;// 32902  added
		String condflds[]={};
		HashMap dupflds=new HashMap();
		java.util.HashMap results = new HashMap();

		HttpSession session				= req.getSession(false);
		p								= (java.util.Properties) session.getValue( "jdbc" ) ;
		client_ip_address				= (String) p.getProperty("client_ip_address");
		locale							= (String) p.getProperty("LOCALE");
		facilityId						= (String) session.getValue( "facility_id" ) ;
		mode							= req.getParameter("mode") == null?"":req.getParameter("mode");
		
		
		operationalFacility				= req.getParameter("facility")==null?"":req.getParameter("facility");
		logo_site_facility					= req.getParameter("logo_site_facility")==null?"S":req.getParameter("logo_site_facility");	
		ThirdParty_Vitals_Time_Dur					= req.getParameter("ThirdParty_Vitals_Time_Dur")==null?"":req.getParameter("ThirdParty_Vitals_Time_Dur");	//IN072674
		out = res.getWriter();
		pract_loc_default_yn            = req.getParameter("pract_loc_default_yn")==null?"":req.getParameter("pract_loc_default_yn"); //33870 added.    		
		enablePriSecProcYN = req.getParameter("en_pri_sec_proc_yn")==null?"":req.getParameter("en_pri_sec_proc_yn"); //36285  added   		
		hidePatForUnauthPractYN= req.getParameter("hide_pat_unauth_pract_yn")==null?"":req.getParameter("hide_pat_unauth_pract_yn"); //32902  added   		
		
		try 
		{
			String addedById			= p.getProperty( "login_user" ) ;
			String modifiedById			= addedById ;
			String addedFacilityId		= facilityId;
			String modifiedFacilityId	= facilityId ;
			String addedAtWorkstation	= client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;
			
			HashMap tabdata=new HashMap();
			
			tabdata.put("facility_id",operationalFacility);
			tabdata.put("logo_site_facility",logo_site_facility);
			tabdata.put("ThirdParty_Vitals_Time_Dur",ThirdParty_Vitals_Time_Dur);//IN072674
			tabdata.put("added_by_id",addedById);
			tabdata.put("added_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("added_facility_id", addedFacilityId);
			tabdata.put("added_at_ws_no",addedAtWorkstation);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
			tabdata.put("pract_loc_default_yn", pract_loc_default_yn); //33870 added. 
			tabdata.put("en_pri_sec_proc_yn", enablePriSecProcYN); //36285  added. 
			tabdata.put("hide_pat_unauth_pract_yn", hidePatForUnauthPractYN); //32902  added. 
			
			dupflds.put("facility_id",operationalFacility);
			
			boolean local_ejbs = false;
			String table_data = "CA_PARAM_BY_FACILITY";
		
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
			//out.println("Exception in Insert Block :"+e.getMessage());//common-icn-0181
			e.printStackTrace();
		}
	}
} 