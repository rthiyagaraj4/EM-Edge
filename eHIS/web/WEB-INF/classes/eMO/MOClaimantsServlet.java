/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMO;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import eCommon.SingleTabHandler.*;

public class MOClaimantsServlet extends javax.servlet.http.HttpServlet	{
PrintWriter out;
java.util.Properties p;
String CLAIMANT_TYPE_CODE     = "";
String LONG_DESC              = "";
String SHORT_DESC             = "";
String CLAIMANT_TYPE          = "";
String EFF_STATUS             = "";
String ADD_LINE1              = "";
String ADD_LINE2              = "";
String ADD_LINE3              = "";
String ADD_LINE4              = "";
String POSTAL_CODE            = "";
String COUNTRY_CODE           = "";
String RES_TOWN_CODE          ="";
String RES_AREA_CODE          ="";       
String REGION_CODE            ="";

String TEL_NO                 = ""; 
String TLX_NO                 = ""; 
String FAX_NO                 = "";	
String EMAIL_ID               = ""; 
String WEBSITE                = ""; 
String facilityId ;
String client_ip_address ;

java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

public void init(ServletConfig config) throws ServletException
{
   super.init(config);
}

public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
throws javax.servlet.ServletException,IOException
{
	req.setCharacterEncoding("UTF-8");
	res.setContentType("text/html;charset=UTF-8");
	HttpSession session = req.getSession(false);
	this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
	this.facilityId = (String) session.getValue( "facility_id" ) ;
	this.client_ip_address = p.getProperty("client_ip_address");
try
{
	this.out = res.getWriter();
	String operation = req.getParameter("operation");
	if ( operation.equals("insert") )
	insertStorageLocation(req, res);
	if ( operation.equals("modify"))
	modifyStorageLocation(req, res);
}
catch (Exception e)
{
	out.println(e.toString());
}
}

public void doGet(HttpServletRequest req, HttpServletResponse res)
throws javax.servlet.ServletException,IOException
{
	try
		{
			req.setCharacterEncoding("UTF-8");
			this.out = res.getWriter();
			res.setContentType("text/html;charset=UTF-8");

			String url = "../eCommon/jsp/MstCodeToolbar.jsp?" ;
			String params = req.getQueryString() ;
			String source = url + params ;

			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script language='javascript' src='../eSM/js/SiteParameter.js'></script></head><frameset rows='42,*,50'><frame name='commontoolbarFrame'	src='"+source+"' frameborder=0 scrolling='no' noresize> <frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame'	src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
		}
		catch(Exception e)	{	}
}


	private void modifyStorageLocation(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{         
			      
			 CLAIMANT_TYPE_CODE = req.getParameter("claimant__type_code");
			if(CLAIMANT_TYPE_CODE == null) CLAIMANT_TYPE_CODE = "";

            LONG_DESC = req.getParameter("long_desc");
			if(LONG_DESC == null) LONG_DESC = "";
			
			SHORT_DESC = req.getParameter("short_desc");
			if(SHORT_DESC == null) SHORT_DESC = "";

			CLAIMANT_TYPE = req.getParameter("Claimants_type");
			if(CLAIMANT_TYPE == null) CLAIMANT_TYPE = "";

			EFF_STATUS = req.getParameter("eff_status");
			if(EFF_STATUS == null) EFF_STATUS = "D";

            ADD_LINE1 = req.getParameter("add_ln1");
			if(ADD_LINE1 == null) ADD_LINE1 = "";

            ADD_LINE2 = req.getParameter("add_ln2");
			if(ADD_LINE2 == null) ADD_LINE2 = "";

			ADD_LINE3 = req.getParameter("add_ln3");
			if(ADD_LINE3 == null) ADD_LINE3 = "";

			ADD_LINE4 = req.getParameter("add_ln4");
			if(ADD_LINE4 == null) ADD_LINE4 = "";

			POSTAL_CODE = req.getParameter("m_postal_code");
			if(POSTAL_CODE == null) POSTAL_CODE = "";
            RES_TOWN_CODE= req.getParameter("m_town");
			if(RES_TOWN_CODE == null) RES_TOWN_CODE = "";
			RES_AREA_CODE= req.getParameter("m_area");
			if(RES_AREA_CODE == null) RES_AREA_CODE = "";
			REGION_CODE = req.getParameter("m_region");
			if(REGION_CODE == null) REGION_CODE = "";
			COUNTRY_CODE = req.getParameter("country_code");
			if(COUNTRY_CODE == null) COUNTRY_CODE= "";

            TEL_NO =req.getParameter("tel_no");
			if(TEL_NO == null) TEL_NO = "";

			TLX_NO = req.getParameter("tlx_no");
			if(TLX_NO == null) TLX_NO = "";

			FAX_NO = req.getParameter("fax_no");
			if(FAX_NO == null) FAX_NO = "";
            
			EMAIL_ID = req.getParameter("email");
			if(EMAIL_ID == null) EMAIL_ID = "";

            WEBSITE =req.getParameter("website");
			if(WEBSITE == null) WEBSITE = "";


			String addedById = p.getProperty( "login_user" ) ;
			String addedDate = dateFormat.format( new java.util.Date() ) ;
			String modifiedById = addedById ;
			String modifiedDate = addedDate ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;
			java.sql.Date added_date1 = java.sql.Date.valueOf( addedDate ) ;
			java.sql.Date added_date = new java.sql.Date(added_date1.parse(added_date1.toLocaleString())-(added_date1.getTimezoneOffset()*60*1000) ) ;
			java.sql.Date modified_date1 = java.sql.Date.valueOf(modifiedDate ) ;
			java.sql.Date modified_date = new java.sql.Date(modified_date1.parse(modified_date1.toLocaleString())-(modified_date1.getTimezoneOffset()*60*1000) ) ;

			HashMap tabdata=new HashMap();			   
			tabdata.put("CLAIMANT_TYPE_CODE",CLAIMANT_TYPE_CODE);			  
			tabdata.put("LONG_DESC",LONG_DESC);				
			tabdata.put("SHORT_DESC",SHORT_DESC);			
			tabdata.put("RES_TOWN_CODE",RES_TOWN_CODE);
			tabdata.put("RES_AREA_CODE",RES_AREA_CODE);
			tabdata.put("REGION_CODE",REGION_CODE);			  
			tabdata.put("CLAIMANT_TYPE",CLAIMANT_TYPE);
			tabdata.put("EFF_STATUS",EFF_STATUS);
			tabdata.put("ADD_LINE1",ADD_LINE1);			  
			tabdata.put("ADD_LINE2",ADD_LINE2);				
			tabdata.put("ADD_LINE3",ADD_LINE3);			
			tabdata.put("ADD_LINE4",ADD_LINE4);
			tabdata.put("POSTAL_CODE",POSTAL_CODE);
			tabdata.put("COUNTRY_CODE",COUNTRY_CODE);
			tabdata.put("TEL_NO",TEL_NO);
			tabdata.put("TLX_NO",TLX_NO);
			tabdata.put("FAX_NO",FAX_NO);
			tabdata.put("EMAIL_ID",EMAIL_ID);
			tabdata.put("WEBSITE",WEBSITE);
			tabdata.put("ADDED_BY_ID",addedById);			 
			tabdata.put("ADDED_DATE",added_date);			 
			tabdata.put("ADDED_AT_WS_NO",addedAtWorkstation);			
			tabdata.put("ADDED_FACILITY_ID", facilityId);			
			tabdata.put("MODIFIED_BY_ID",modifiedById);		
			tabdata.put("MODIFIED_DATE",modified_date);			
			tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation);			
			tabdata.put("MODIFIED_FACILITY_ID",modifiedFacilityId );		
			
		//	String dupflds[]={"CLAIMANT_TYPE_CODE"};
			
			HashMap condflds=new HashMap();
			condflds.put("CLAIMANT_TYPE_CODE",CLAIMANT_TYPE_CODE);

			String tabname="MO_CLAIMANT_TYPE";
			boolean local_ejbs = false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = condflds;
			argArray[3] = tabname;

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = condflds.getClass();
			paramArray[3] = tabname.getClass();

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;

			if ( inserted )
			{
					error_value = "1" ;
					res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(error,"UTF-8") +"&err_value="+error_value );

			}
			else
			{
				 error = (String) results.get("error") ;
				 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode( error,"UTF-8" )+ "&err_value=" + error_value );
			}
	 
        argArray = null;
		paramArray = null;
		tabdata.clear();
		results.clear();
		condflds.clear();
	 }
		catch ( Exception e )
		{
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			//out.println(  " "+direct_regn_yn + " "+billing_interfaced_yn +" "+ days_to_pres_unknown_body+" "+ cut_off_prd_more_then_hrs + " "+ cut_off_prd_less_then_hrs );
		}
	}

	private void insertStorageLocation(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{

			  
			 CLAIMANT_TYPE_CODE = req.getParameter("claimant__type_code");
			if(CLAIMANT_TYPE_CODE == null) CLAIMANT_TYPE_CODE = "";
			
            LONG_DESC = req.getParameter("long_desc");
			if(LONG_DESC == null) LONG_DESC = "";
			
			SHORT_DESC = req.getParameter("short_desc");
			if(SHORT_DESC == null) SHORT_DESC = "";

			CLAIMANT_TYPE = req.getParameter("Claimants_type");
			if(CLAIMANT_TYPE == null) CLAIMANT_TYPE = "";

			EFF_STATUS = req.getParameter("eff_status");
			if(EFF_STATUS == null) EFF_STATUS = "D";

            ADD_LINE1 = req.getParameter("add_ln1");
			if(ADD_LINE1 == null) ADD_LINE1 = "";

            ADD_LINE2 = req.getParameter("add_ln2");
			if(ADD_LINE2 == null) ADD_LINE2 = "";

			ADD_LINE3 = req.getParameter("add_ln3");
			if(ADD_LINE3 == null) ADD_LINE3 = "";

			ADD_LINE4 = req.getParameter("add_ln4");
			if(ADD_LINE4 == null) ADD_LINE4 = "";

			POSTAL_CODE = req.getParameter("m_postal_code");
			if(POSTAL_CODE == null) POSTAL_CODE = "";

			COUNTRY_CODE = req.getParameter("country_code");
			if(COUNTRY_CODE == null) COUNTRY_CODE= "";

            TEL_NO =req.getParameter("tel_no");
			if(TEL_NO == null) TEL_NO = "";

			TLX_NO = req.getParameter("tlx_no");
			if(TLX_NO == null) TLX_NO = "";

			FAX_NO = req.getParameter("fax_no");
			if(FAX_NO == null) FAX_NO = "";
            
			EMAIL_ID = req.getParameter("email");
			if(EMAIL_ID == null) EMAIL_ID = "";

            WEBSITE =req.getParameter("website");
			if(WEBSITE == null) WEBSITE = "";

            RES_TOWN_CODE= req.getParameter("m_town");
			if(RES_TOWN_CODE == null) RES_TOWN_CODE = "";
			RES_AREA_CODE= req.getParameter("m_area");
			if(RES_AREA_CODE == null) RES_AREA_CODE = "";
			REGION_CODE = req.getParameter("m_region");
			if(REGION_CODE == null) REGION_CODE = "";
			
 
			String addedById = p.getProperty( "login_user" ) ;
			String addedDate = dateFormat.format( new java.util.Date() ) ;
			String modifiedById = addedById ;
			String modifiedDate = addedDate ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;           
			java.sql.Date added_date1 = java.sql.Date.valueOf( addedDate ) ;
			java.sql.Date added_date = new java.sql.Date(added_date1.parse(added_date1.toLocaleString())-(added_date1.getTimezoneOffset()*60*1000) ) ;
			java.sql.Date modified_date1 = java.sql.Date.valueOf(modifiedDate ) ;
			java.sql.Date modified_date = new java.sql.Date(modified_date1.parse(modified_date1.toLocaleString())-(modified_date1.getTimezoneOffset()*60*1000) ) ;

			HashMap tabdata=new HashMap();			   
			tabdata.put("CLAIMANT_TYPE_CODE",CLAIMANT_TYPE_CODE);			  
			tabdata.put("LONG_DESC",LONG_DESC);				
			tabdata.put("SHORT_DESC",SHORT_DESC);			
			tabdata.put("CLAIMANT_TYPE",CLAIMANT_TYPE);
			tabdata.put("EFF_STATUS",EFF_STATUS);
			tabdata.put("RES_TOWN_CODE",RES_TOWN_CODE);
			tabdata.put("RES_AREA_CODE",RES_AREA_CODE);
			tabdata.put("REGION_CODE",REGION_CODE);			  
			tabdata.put("ADD_LINE1",ADD_LINE1);			  
			tabdata.put("ADD_LINE2",ADD_LINE2);				
			tabdata.put("ADD_LINE3",ADD_LINE3);			
			tabdata.put("ADD_LINE4",ADD_LINE4);
			tabdata.put("POSTAL_CODE",POSTAL_CODE);
			tabdata.put("COUNTRY_CODE",COUNTRY_CODE);
			tabdata.put("TEL_NO",TEL_NO);
			tabdata.put("TLX_NO",TLX_NO);
			tabdata.put("FAX_NO",FAX_NO);
			tabdata.put("EMAIL_ID",EMAIL_ID);
			tabdata.put("WEBSITE",WEBSITE);
			tabdata.put("ADDED_BY_ID",addedById);			 
			tabdata.put("ADDED_DATE",added_date);			 
			tabdata.put("ADDED_AT_WS_NO",addedAtWorkstation);			
			tabdata.put("ADDED_FACILITY_ID", facilityId);			
			tabdata.put("MODIFIED_BY_ID",modifiedById);		
			tabdata.put("MODIFIED_DATE",modified_date);			
			tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation);			
			tabdata.put("MODIFIED_FACILITY_ID",modifiedFacilityId );	
					
			String dupflds[]={"CLAIMANT_TYPE_CODE"};
			String tabname="MO_CLAIMANT_TYPE";
			boolean local_ejbs = false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = dupflds;
			argArray[3] = tabname;

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = dupflds.getClass();
			paramArray[3] = tabname.getClass();

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);

    		boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error") ;
			String error_value = "0" ;

			if ( inserted )
			{
				 error_value = "1" ;
				 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
			}
			else
			{
				 error = (String) results.get("error") ;
				 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" ) );
			}
		tabdata.clear();
		results.clear();
		}
		catch ( Exception e )
		{
			out.println("<h3> Exception raise by Servlet ...So Record Not Inserted </h3> Foll: Error Received : "+e.toString());
		}

	}

    
  
}
