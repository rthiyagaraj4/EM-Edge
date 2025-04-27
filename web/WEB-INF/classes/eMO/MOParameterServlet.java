
/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMO;
import  java.sql.*;
import  java.io.*;
import  javax.servlet.*;
import  javax.servlet.http.*;
import  javax.naming.*;
import  javax.rmi.*;
import  java.util.*;
import  eCommon.SingleTabHandler.*;

public class MOParameterServlet extends javax.servlet.http.HttpServlet	
	{
			PrintWriter out;
			java.util.Properties p;
			String facilityId ;
			String client_ip_address ;
			java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

   public void init(ServletConfig config) throws ServletException
	   {
		    super.init(config);
	   }

   public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)throws javax.servlet.ServletException,IOException
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
			String operation = req.getParameter("mode");
			if ( operation.equals("INSERT") )
				insertStorageLocation(req, res);
			if ( operation.equals("MODIFY"))
				modifyStorageLocation(req, res);
	   }
	catch (Exception e)
	   {	out.println(e.toString());
			e.printStackTrace();
	   }
	  } 
   public void doGet(HttpServletRequest req, HttpServletResponse res)throws javax.servlet.ServletException,IOException
	 {
		try
		  {
			req.setCharacterEncoding("UTF-8");
			this.out      = res.getWriter();
			res.setContentType("text/html;charset=UTF-8");
			String url    = "../eCommon/jsp/MstCodeToolbar.jsp?" ;
			String params = req.getQueryString() ;
			String source = url + params ;
            out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script language='javascript' src='../eSM/js/SiteParameter.js'></script></head><frameset rows='42,*,50'><frame name='commontoolbarFrame'	src='"+source+"' frameborder=0 scrolling='no' noresize> <frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame'	src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
		  }
		catch(Exception e)	
	      { 
			out.println(e.toString()	);
			e.printStackTrace();
		  }
	 }


   private void modifyStorageLocation(HttpServletRequest req, HttpServletResponse res)
	{
		try
		  {
            direct_regn_yn		              = req.getParameter("direct_regn_yn");
			billing_interfaced_yn		      = req.getParameter("billing_interfaced_yn");
			burial_permit_reqd_yn		      = req.getParameter("burial_permit_reqd_yn");
			/*Added by Thamizh selvi on 24th July 2017 for ML-MMOH-CRF-0689 Start*/
			police_dtls_mand_yn			      = req.getParameter("police_dtls_mand_yn") == null ? "N" : req.getParameter("police_dtls_mand_yn") ;
			bid_pat_series_code			      = req.getParameter("bid_regn_pat_series") == null ? "" : req.getParameter("bid_regn_pat_series") ;
			body_part_pat_series_code	      = req.getParameter("body_part_regn_pat_series") == null ? "" : req.getParameter("body_part_regn_pat_series") ;
			/*End*/
			record_pm_find_dtls_yn            = req.getParameter("record_pm_find_dtls_yn") == null ? "N" : req.getParameter("record_pm_find_dtls_yn") ; // added by mujafar for ML-MMOH-CRF-0880
			enable_RFID_yn = req.getParameter("enable_RFID_yn") == null ? "N" : req.getParameter("enable_RFID_yn") ; // added by mujafar for ML-MMOH-CRF-0996
		    days_to_pres_unknown_body		  = req.getParameter("days_to_pres_unknown_body");
            cut_off_prd_more_then_hrs		  = req.getParameter("cut_off_prd_more_then_hrs");
			cut_off_prd_less_then_hrs		  = req.getParameter("cut_off_prd_less_then_hrs");
			dept_code = req.getParameter("department_code");
			next_burial_permit_no = req.getParameter("next_burial_permit_no1");
			queue_refresh_interval = req.getParameter("queue_refresh_interval");
			service_code		 = req.getParameter("service_code")==null?"":req.getParameter("service_code");; //Added for Bru-HIMS-CRF-413 by Dharma on 12th Dec 2013		
			max_size_burial_permit_no		  = req.getParameter("max_size_burial_permit_no"); //Added by santhosh for ML-MMOH-CRF-1947
			datetime_claim_mand		  = req.getParameter("datetime_claim_mand"); //Added by santhosh for ML-MMOH-CRF-1948
			if(next_burial_permit_no == null) next_burial_permit_no ="1";

            if(direct_regn_yn == null)
                direct_regn_yn      = "N";
			if(billing_interfaced_yn == null)
                billing_interfaced_yn= "N";
			if(burial_permit_reqd_yn==null)
				burial_permit_reqd_yn = "N";
		    if(days_to_pres_unknown_body == null)
                days_to_pres_unknown_body= "";
            if(cut_off_prd_more_then_hrs == null)
                cut_off_prd_more_then_hrs ="";
            if(cut_off_prd_less_then_hrs == null)
                cut_off_prd_less_then_hrs= "";
			if(dept_code==null)
				dept_code = "";
			if(max_size_burial_permit_no==null)
				max_size_burial_permit_no = "";
			if(datetime_claim_mand==null)
				datetime_claim_mand = "";
			// commented as part of BRU-CRF-160.1  by Sudhakar
		//order_catalog_code_cl =req.getParameter("order_catalog_cl");
		//if(order_catalog_code_cl == null) order_catalog_code_cl ="";
	    //order_catalog_code_ml =req.getParameter("order_catalog_ml");
		//if(order_catalog_code_ml == null) order_catalog_code_ml ="";
		

			String addedById             = p.getProperty( "login_user" ) ;
			String addedDate             = dateFormat.format( new java.util.Date() ) ;
			String modifiedById          = addedById ;
			String modifiedDate          = addedDate ;
			String addedFacilityId       = facilityId;
			String modifiedFacilityId    = addedFacilityId ;
			String addedAtWorkstation    = client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;
		    java.sql.Date added_date1    = java.sql.Date.valueOf( addedDate ) ;
			java.sql.Date added_date     = new java.sql.Date(added_date1.parse(added_date1.toLocaleString())-(added_date1.getTimezoneOffset()*60*1000) ) ;
			java.sql.Date modified_date1 = java.sql.Date.valueOf(modifiedDate ) ;
			java.sql.Date modified_date  = new java.sql.Date(modified_date1.parse(modified_date1.toLocaleString())-(modified_date1.getTimezoneOffset()*60*1000) ) ;
			HashMap tabdata              =new HashMap();
			tabdata.put("FACILITY_ID",facilityId );		 
			tabdata.put("DIRECT_REGN_YN",direct_regn_yn);			  
			tabdata.put("BL_INTERFACE_YN",billing_interfaced_yn);			  
			tabdata.put("DAYS_TO_PRES_UNKNOWN_BODY",days_to_pres_unknown_body);			  
			tabdata.put("CUT_OFF_PRD_MORE_THAN_HRS",cut_off_prd_more_then_hrs);
			tabdata.put("CUT_OFF_PRD_LESS_THAN_HRS",cut_off_prd_less_then_hrs);		
			tabdata.put("DEPT_CODE",dept_code);	
			tabdata.put("NEXT_BURIAL_PERMIT_NO",next_burial_permit_no);	
			tabdata.put("ADDED_BY_ID",addedById);			 
			tabdata.put("ADDED_DATE",added_date);			 
			tabdata.put("ADDED_AT_WS_NO",addedAtWorkstation);			
			tabdata.put("ADDED_FACILITY_ID", facilityId);			
			tabdata.put("MODIFIED_BY_ID",modifiedById);		
			tabdata.put("MODIFIED_DATE",modified_date);			
			tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation);			
			tabdata.put("MODIFIED_FACILITY_ID",modifiedFacilityId );
			// commented as part of BRU-CRF-160.1  by Sudhakar
			//tabdata.put("ORDER_CATALOG_CODE_CL_PM",order_catalog_code_cl);
			//tabdata.put("ORDER_CATALOG_CODE_ML_PM",order_catalog_code_ml);
			tabdata.put("QUEUE_REFRESH_INTERVAL",queue_refresh_interval);
			tabdata.put("burial_permit_reqd_yn",burial_permit_reqd_yn);
			/*Added by Thamizh selvi on 24th July 2017 for ML-MMOH-CRF-0689 Start*/
			tabdata.put("police_dtls_reqd_yn",police_dtls_mand_yn);
			tabdata.put("pat_series_for_bid",bid_pat_series_code);
			tabdata.put("pat_series_for_body_part",body_part_pat_series_code);
			/*End*/
			tabdata.put("pm_dtls_reqd_yn",record_pm_find_dtls_yn); // added by mujafar for ML-MMOH-CRF-0880
			tabdata.put("enable_rfid_yn",enable_RFID_yn); // added by mujafar for ML-MMOH-CRF-0996
			tabdata.put("dflt_service_code",service_code); //Added for Bru-HIMS-CRF-413 by Dharma on 12th Dec 2013
			tabdata.put("MAX_SIZE_BURIAL_PERMIT_NO",max_size_burial_permit_no); //Added by santhosh for ML-MMOH-CRF-1947

			tabdata.put("DATETIME_CLAIM_MAND",datetime_claim_mand); //Added by santhosh for ML-MMOH-CRF-1948
			

			
			HashMap condflds=new HashMap();
			condflds.put("FACILITY_ID",facilityId);
			String tabname="MO_PARAMETER";
		    boolean local_ejbs = false;
		    if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
       		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
		    Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[]		   = new Object[4];
			argArray[0]			       = p;
			argArray[1]			       = tabdata;
			argArray[2]				   = condflds;
			argArray[3]				   = tabname;
			Class [] paramArray		   = new Class[4];
			paramArray[0]              = p.getClass();
			paramArray[1]			   = tabdata.getClass();
			paramArray[2]			   = condflds.getClass();
			paramArray[3]              = tabname.getClass();
		    java.util.HashMap results  = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
	 		boolean inserted           = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
     		String error               = (String) results.get("error") ;
			String error_value         = "0" ;
			if ( inserted )
			{
			 error_value = "1" ;
             res.sendRedirect("../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode(error,"UTF-8") +"&err_value="+error_value );
			}
			else
			{
				 error = (String) results.get("error") ;
				 res.sendRedirect("../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode( error,"UTF-8" )+ "&err_value=" + error_value );
			}
		tabdata.clear();
		condflds.clear();
		results.clear();
		
		}
		catch ( Exception e )
		{
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			out.println(  " "+direct_regn_yn + " "+billing_interfaced_yn +" "+ days_to_pres_unknown_body+" "+ cut_off_prd_more_then_hrs + " "+ cut_off_prd_less_then_hrs );
		}
	}

   private void insertStorageLocation(HttpServletRequest req, HttpServletResponse res)
	 {
		try
		  {
			direct_regn_yn		              = req.getParameter("direct_regn_yn");
			billing_interfaced_yn		      = req.getParameter("billing_interfaced_yn");
			burial_permit_reqd_yn		      = req.getParameter("burial_permit_reqd_yn");
			/*Added by Thamizh selvi on 24th July 2017 for ML-MMOH-CRF-0689 Start*/
			police_dtls_mand_yn			      = req.getParameter("police_dtls_mand_yn") == null ? "N" : req.getParameter("police_dtls_mand_yn") ;
			bid_pat_series_code			      = req.getParameter("bid_regn_pat_series") == null ? "" : req.getParameter("bid_regn_pat_series") ;
			body_part_pat_series_code	      = req.getParameter("body_part_regn_pat_series") == null ? "" : req.getParameter("body_part_regn_pat_series") ;
			/*End*/
			record_pm_find_dtls_yn            = req.getParameter("record_pm_find_dtls_yn") == null ? "N" : req.getParameter("record_pm_find_dtls_yn") ; // added by mujafar for ML-MMOH-CRF-0880
			enable_RFID_yn = req.getParameter("enable_RFID_yn") == null ? "N" : req.getParameter("enable_RFID_yn") ; // added by mujafar for ML-MMOH-CRF-0996
			
		    days_to_pres_unknown_body		  = req.getParameter("days_to_pres_unknown_body");
            cut_off_prd_more_then_hrs		  = req.getParameter("cut_off_prd_more_then_hrs");
			cut_off_prd_less_then_hrs		  = req.getParameter("cut_off_prd_less_then_hrs");
			max_size_burial_permit_no		  = req.getParameter("max_size_burial_permit_no"); //Added by santhosh for ML-MMOH-CRF-1947
			datetime_claim_mand		  = req.getParameter("datetime_claim_mand"); //Added by santhosh for ML-MMOH-CRF-1948
			
			dept_code = req.getParameter("department_code");
			next_burial_permit_no = req.getParameter("next_burial_permit_no1");
			if(next_burial_permit_no == null) next_burial_permit_no ="1";
			queue_refresh_interval = req.getParameter("queue_refresh_interval");
			service_code		 = req.getParameter("service_code")==null?"":req.getParameter("service_code");; //Added for Bru-HIMS-CRF-413 by Dharma on 12th Dec 2013

			if(direct_regn_yn == null)
                direct_regn_yn = "N";
			if(billing_interfaced_yn == null)
                billing_interfaced_yn= "N";
			if(burial_permit_reqd_yn==null)burial_permit_reqd_yn="N";
			if(days_to_pres_unknown_body == null)
                days_to_pres_unknown_body= "";
            if(cut_off_prd_more_then_hrs == null)
                cut_off_prd_more_then_hrs ="";
            if(cut_off_prd_less_then_hrs == null) 
                cut_off_prd_less_then_hrs= "";
            if(dept_code==null)
				dept_code = "";
			if(max_size_burial_permit_no==null)
				max_size_burial_permit_no = "";
			if(datetime_claim_mand==null)
				datetime_claim_mand = "";
				// commented as part of BRU-CRF-160.1  by Sudhakar
	    //order_catalog_code_cl =req.getParameter("order_catalog_cl");
		//if(order_catalog_code_cl == null) order_catalog_code_cl ="";
	    //order_catalog_code_ml =req.getParameter("order_catalog_ml");
		//if(order_catalog_code_ml == null) order_catalog_code_ml ="";

		
			String addedById			 = p.getProperty( "login_user" ) ;
			String addedDate			 = dateFormat.format( new java.util.Date() ) ;
			String modifiedById			 = addedById ;
			String modifiedDate			 = addedDate ;
			String addedFacilityId       = facilityId;
			String modifiedFacilityId    = addedFacilityId ;
			String addedAtWorkstation    = client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;
         	java.sql.Date added_date1    = java.sql.Date.valueOf( addedDate ) ;
			java.sql.Date added_date     = new java.sql.Date(added_date1.parse(added_date1.toLocaleString())-(added_date1.getTimezoneOffset()*60*1000) ) ;
			java.sql.Date modified_date1 = java.sql.Date.valueOf(modifiedDate ) ;
			java.sql.Date modified_date  = new java.sql.Date(modified_date1.parse(modified_date1.toLocaleString())-(modified_date1.getTimezoneOffset()*60*1000) ) ;
			HashMap tabdata=new HashMap();
			tabdata.put("FACILITY_ID",facilityId );
			tabdata.put("DIRECT_REGN_YN",direct_regn_yn);			 
			tabdata.put("BL_INTERFACE_YN",billing_interfaced_yn);			 
			tabdata.put("DAYS_TO_PRES_UNKNOWN_BODY",days_to_pres_unknown_body);			
			tabdata.put("CUT_OFF_PRD_MORE_THAN_HRS",cut_off_prd_more_then_hrs);			 
			tabdata.put("CUT_OFF_PRD_LESS_THAN_HRS",cut_off_prd_less_then_hrs);
			tabdata.put("DEPT_CODE",dept_code);
			tabdata.put("NEXT_BURIAL_PERMIT_NO",next_burial_permit_no);	
			tabdata.put("ADDED_BY_ID",addedById);			 
			tabdata.put("ADDED_DATE",added_date);			  
			tabdata.put("ADDED_AT_WS_NO",addedAtWorkstation);			
			tabdata.put("ADDED_FACILITY_ID", facilityId);			
			tabdata.put("MODIFIED_BY_ID",modifiedById);		
			tabdata.put("MODIFIED_DATE",modified_date);			
			tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation);			 
			tabdata.put("MODIFIED_FACILITY_ID",modifiedFacilityId );
			
			//tabdata.put("ORDER_CATALOG_CODE_CL_PM",order_catalog_code_cl);
			//tabdata.put("ORDER_CATALOG_CODE_ML_PM",order_catalog_code_ml);
			tabdata.put("QUEUE_REFRESH_INTERVAL",queue_refresh_interval);
			tabdata.put("burial_permit_reqd_yn",burial_permit_reqd_yn);
			/*Added by Thamizh selvi on 24th July 2017 for ML-MMOH-CRF-0689 Start*/
			tabdata.put("police_dtls_reqd_yn",police_dtls_mand_yn);
			tabdata.put("pat_series_for_bid",bid_pat_series_code);
			tabdata.put("pat_series_for_body_part",body_part_pat_series_code);
			/*End*/
			tabdata.put("pm_dtls_reqd_yn",record_pm_find_dtls_yn); // added by mujafar for ML-MMOH-CRF-0880
			tabdata.put("enable_rfid_yn",enable_RFID_yn); // added by mujafar for ML-MMOH-CRF-0996
			tabdata.put("dflt_service_code",service_code); //Added for Bru-HIMS-CRF-413 by Dharma on 12th Dec 2013
			tabdata.put("MAX_SIZE_BURIAL_PERMIT_NO",max_size_burial_permit_no); //Added by santhosh for ML-MMOH-CRF-1947
			tabdata.put("DATETIME_CLAIM_MAND",datetime_claim_mand); //Added by santhosh for ML-MMOH-CRF-1948

			String dupflds[]={"FACILITY_ID"};
			String tabname="MO_PARAMETER";
		    boolean local_ejbs = false;		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);			
			Object argArray[]         = new Object[4];
			argArray[0]               = p;
			argArray[1]               = tabdata;
			argArray[2]               = dupflds;
			argArray[3]               = tabname;
			Class [] paramArray       = new Class[4];
			paramArray[0]             = p.getClass();
			paramArray[1]             = tabdata.getClass();
			paramArray[2]             = dupflds.getClass();
			paramArray[3]             = tabname.getClass();
    		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
    		boolean inserted          = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error              = (String) results.get("error") ;
			String error_value        = "0" ;
			if ( inserted )
			{
				 error_value = "1" ;
				 res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
			}
			else
			{
				 error = (String) results.get("error") ;
				 res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" ) );
			}
		tabdata.clear();
		
		results.clear();
		
		}
		catch ( Exception e )
		{
			out.println("<h3> Exception raise by Servlet ...So Record Not Inserted </h3> Foll: Error Received : "+e.toString());
		}

	}

			String direct_regn_yn           ="";
			String billing_interfaced_yn    ="";
			String burial_permit_reqd_yn    ="";
			/*Added by Thamizh selvi on 24th July 2017 for ML-MMOH-CRF-0689 Start*/
			String police_dtls_mand_yn		="";
			String bid_pat_series_code		="";
			String body_part_pat_series_code="";
			/*End*/
			String record_pm_find_dtls_yn = ""; // added by mujafar for ML-MMOH-CRF-0880
			String enable_RFID_yn = "" ;  // added by mujafar for ML-MMOH-CRF-0996
			String days_to_pres_unknown_body="";
			String cut_off_prd_more_then_hrs="";
			String cut_off_prd_less_then_hrs="";
			String dept_code		= "";
			String order_catalog_code_cl="";
			String order_catalog_code_ml="";
			String next_burial_permit_no="";
			String queue_refresh_interval = "";
			String service_code			 = ""; //Added for Bru-HIMS-CRF-413 by Dharma on 12th Dec 2013
			String max_size_burial_permit_no = "";//Added by santhosh for ML-MMOH-CRF-1947
			String datetime_claim_mand = "";//Added by santhosh for ML-MMOH-CRF-1948
}
