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
import java.net.*;
import eFM.FMFileTypeforFSLocn.*; 

public class FMFileTypeforFSLocnServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel //
{
	
	PrintWriter out;
	Properties p;

	String fs_locn_code			= ""; 
	String facilityId			= "";
	String client_ip_address	= "";
	String locale			= "" ;
	String dflt_index="";
	String tot_count="";
	int cnt=0;
	HttpSession session;

	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}
   
	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
			
		session				= req.getSession(false);
		this.p				= (Properties) session.getValue( "jdbc" ) ;
		this.facilityId		= (String) session.getValue( "facility_id" ) ;
		client_ip_address	= p.getProperty("client_ip_address");
		locale = p.getProperty("LOCALE");
		try
		{
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			SpecialityAddModify(req,res,locale);
		}catch(Exception e1){out.println("exception in doGet e1 :"+e1.toString());}
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
			
		try
		{
			this.out = res.getWriter();
			res.setContentType("text/html");
			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script language='javascript' src='../../eFM/js/FMFileTypeforFSLocn.js'></script></head><frameset rows='60,*,50'><frame name='commontoolbarFrame' src='../eCommon/jsp/MstCodeToolbar.jsp?function_name=File Type for FS Location' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
		}catch(Exception e2){out.println("exception in doGet e2 :"+ e2.toString());}
	}
	/*
	   This method is used to insert/Update File Type details .These details are put into one
	   HashMap and passed it as a parameter to EJB (FMFileTypeforFSLocnManager).This EJB returns HashMap and get the
	   status from that hashmap and set error_value is '1' if the status is true otherwise '0'
	   Based on this value It will display appropriate Message either Success or Failure.
	*/
	private void SpecialityAddModify(HttpServletRequest req, HttpServletResponse res,String locale)
	{
		try
		{
				
            HashMap tabdata					= new HashMap();           
			RecordSet FMFileTypeforFSLocn	= null; 

            String checkedOnes = "";          
            String from = "",to = "";
               
			fs_locn_code = req.getParameter("fs_locn_code");
		    dflt_index   = req.getParameter("dflt_index");
			tot_count = req.getParameter("count");
              	cnt			          = Integer.parseInt(tot_count);
				if(fs_locn_code == null) fs_locn_code = "";
        	if(dflt_index == null || dflt_index.equals("")) dflt_index ="0";
			if(tot_count == null || tot_count.equals("")) tot_count ="0";
		
        	
			tabdata.put("fs_locn_code",fs_locn_code);

            from = (req.getParameter("from")==null)?"0":req.getParameter("from");
            to	 = (req.getParameter("to")==null)?"0":req.getParameter("to");

			FMFileTypeforFSLocn=(webbeans.eCommon.RecordSet)session.getAttribute("FMFileTypeforFSLocn"); //
   		//	if(cnt != null && to != null)
 			//{
				from	= from.trim();
				to		= to.trim();				
				
				for(int i=0;i<cnt; i++)
				{
					if(req.getParameter(("chk"+i)) != null)
				    {
						checkedOnes = req.getParameter(("chk"+i));
						if(!(FMFileTypeforFSLocn.containsObject(checkedOnes))) 
						{
							FMFileTypeforFSLocn.putObject(checkedOnes); 
						}
					}
				}
			//}
			for(int i=0;i<FMFileTypeforFSLocn.getSize();i++) 
			{
				tabdata.put(("chk"+i), (String)FMFileTypeforFSLocn.getObject(i) ); 
 			}

			String slCount					= ""+FMFileTypeforFSLocn.getSize(); 
	        String addedById				= p.getProperty( "login_user" ) ;
	        String addedDate				= dateFormat.format( new java.util.Date() ) ;
	        String modifiedById				= addedById ;
	        String modifiedFacilityId		= facilityId ;
	        String addedAtWorkstation		= client_ip_address;
	        String modifiedAtWorkstation	= addedAtWorkstation ;

			java.sql.Date added_date1 = java.sql.Date.valueOf( addedDate ) ;
            java.sql.Date added_date  = new java.sql.Date(added_date1.parse(added_date1.toLocaleString())-(added_date1.getTimezoneOffset()*60*1000) ) ;
            	
			tabdata.put("facilityId"			, facilityId);
            tabdata.put("added_date"			, added_date);
            tabdata.put("modified_by_id"		, modifiedById);
            tabdata.put("modified_date"			, new  java.sql.Timestamp(System.currentTimeMillis()));
            tabdata.put("modified_facility_id"	, modifiedFacilityId);
            tabdata.put("modified_at_ws_no"		, modifiedAtWorkstation );
            tabdata.put("totCount"				, new Integer(slCount));
            tabdata.put("dflt_index"				, new Integer(dflt_index));
			tabdata.put("locale"				,locale );

			boolean local_ejbs = false;
			if((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
				
			Object home   = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/FMFileTypeforFSLocn",FMFileTypeforFSLocnManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
				
			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = tabdata;
			
			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("SpecialityAddModify",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			boolean inserted = (((Boolean) results.get( "status" )).booleanValue());
			String error	 = (String) results.get("error") ;
			String error_value = "0" ;
			tabdata.clear();
			results.clear();
			
			inserted = true;
			if(inserted) error_value = "1" ;
			
			out.println("<html><script>location.href =\"../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value + "\"</script><body class='message'></html>");
		}catch (Exception e3)
		{
			out.println("Exception in main try block e3 :"+ e3.getMessage());
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e3.toString());
		}
	}//E.O.Method
}
