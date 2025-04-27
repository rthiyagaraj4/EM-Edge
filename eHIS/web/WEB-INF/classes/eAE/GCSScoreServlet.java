/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/* ***
   *** This Servlet is used for GCS Code Setup
   *** */

package eAE;

import java.sql.*;
import java.io.*;
import java.util.*;
import java.text.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;

import eCommon.SingleTabHandler.*;

public class GCSScoreServlet extends HttpServlet implements SingleThreadModel{
	PrintWriter out;
	String facilityId;
	HttpSession session;
	Properties p;
	String client_ip_address;

	boolean inserted		= false;
	String mode;
  
	

	String module_id		= "AE";
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException{
		    req.setCharacterEncoding("UTF-8");
	        res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
		try	{

			session 					= req.getSession(true);
			this.facilityId = (String) session.getValue( "facility_id" ) ;
			this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		    this.client_ip_address = p.getProperty("client_ip_address");

			

			 mode 						= req.getParameter("mode");
			 mode 						= (mode == null)?"":mode;
			if(mode.equalsIgnoreCase("INSERT"))
			     insertGCSScore(req,res);
            else 
			     modifyGCSScore(req,res);
		}catch(Exception e){
					e.printStackTrace();
			}
	}

 private void  insertGCSScore(HttpServletRequest req, HttpServletResponse res){
  try{
    	String addedById			= p.getProperty( "login_user" ) ;
    	String addedDate			= dateFormat.format( new java.util.Date() ) ;
		String modifiedById			= addedById ;
		String modifiedDate			= addedDate ;
		String addedFacilityId		= facilityId;
		String modifiedFacilityId	= addedFacilityId ;
		String addedAtWorkstation	= client_ip_address;
		String modifiedAtWorkstation= addedAtWorkstation ;

		java.sql.Date added_date1	= java.sql.Date.valueOf( addedDate ) ;
		java.sql.Date added_date	= new java.sql.Date(added_date1.parse(added_date1.toLocaleString())-(added_date1.getTimezoneOffset()*60*1000) ) ;
		java.sql.Date modified_date1= java.sql.Date.valueOf(modifiedDate ) ;
	    java.sql.Date modified_date = new java.sql.Date(modified_date1.parse(modified_date1.toLocaleString())-(modified_date1.getTimezoneOffset()*60*1000) ) ; 

		java.util.HashMap tabdata=new HashMap();
				tabdata.put("MODULE_ID",module_id);
				tabdata.put("GCS_RESPONSE_CODE_ER","ER");
				tabdata.put("ER_GCS_CODE1",req.getParameter("er_code"+0) == null?"":req.getParameter("er_code"+0));
				tabdata.put("ER_GCS_CODE1_SCORE",req.getParameter("er_gcs_code1_weight"+0) == null?"":req.getParameter("er_gcs_code1_weight"+0));
				tabdata.put("ER_GCS_CODE2",req.getParameter("er_code"+1) == null?"":req.getParameter("er_code"+1));
				tabdata.put("ER_GCS_CODE2_SCORE",req.getParameter("er_gcs_code1_weight"+1) == null?"":req.getParameter("er_gcs_code1_weight"+1));
				tabdata.put("ER_GCS_CODE3",req.getParameter("er_code"+2) == null?"":req.getParameter("er_code"+2));
				tabdata.put("ER_GCS_CODE3_SCORE",req.getParameter("er_gcs_code1_weight"+2) == null?"":req.getParameter("er_gcs_code1_weight"+2));
				tabdata.put("ER_GCS_CODE4",req.getParameter("er_code"+3) == null?"":req.getParameter("er_code"+3));
				tabdata.put("ER_GCS_CODE4_SCORE",req.getParameter("er_gcs_code1_weight"+3) == null?"":req.getParameter("er_gcs_code1_weight"+3));
				tabdata.put("GCS_RESPONSE_CODE_VR","VR");
				tabdata.put("VR_GCS_CODE1",
req.getParameter("vr_code"+0) == null?"":req.getParameter("vr_code"+0));
				tabdata.put("VR_GCS_CODE1_SCORE",
req.getParameter("vr_gcs_code1_weight"+0) == null?"":req.getParameter("vr_gcs_code1_weight"+0));
				tabdata.put("VR_GCS_CODE2",
req.getParameter("vr_code"+1) == null?"":req.getParameter("vr_code"+1));
				tabdata.put("VR_GCS_CODE2_SCORE",
req.getParameter("vr_gcs_code1_weight"+1) == null?"":req.getParameter("vr_gcs_code1_weight"+1));
				tabdata.put("VR_GCS_CODE3",
req.getParameter("vr_code"+2) == null?"":req.getParameter("vr_code"+2));
				tabdata.put("VR_GCS_CODE3_SCORE",
req.getParameter("vr_gcs_code1_weight"+2) == null?"":req.getParameter("vr_gcs_code1_weight"+2));
				tabdata.put("VR_GCS_CODE4",
req.getParameter("vr_code"+3) == null?"":req.getParameter("vr_code"+3));
				tabdata.put("VR_GCS_CODE4_SCORE",
req.getParameter("vr_gcs_code1_weight"+3) == null?"":req.getParameter("vr_gcs_code1_weight"+3));
				tabdata.put("VR_GCS_CODE5",
req.getParameter("vr_code"+4) == null?"":req.getParameter("vr_code"+4));
				tabdata.put("VR_GCS_CODE5_SCORE",
req.getParameter("vr_gcs_code1_weight"+4) == null?"":req.getParameter("vr_gcs_code1_weight"+4));
				tabdata.put("GCS_RESPONSE_CODE_MR","MR");
				tabdata.put("MR_GCS_CODE1",
req.getParameter("mr_code"+0) == null?"":req.getParameter("mr_code"+0));
				tabdata.put("MR_GCS_CODE1_SCORE",req.getParameter("mr_gcs_code1_weight"+0) == null?"":req.getParameter("mr_gcs_code1_weight"+0));
				tabdata.put("MR_GCS_CODE2",
req.getParameter("mr_code"+1) == null?"":req.getParameter("mr_code"+1));
				tabdata.put("MR_GCS_CODE2_SCORE",req.getParameter("mr_gcs_code1_weight"+1) == null?"":req.getParameter("mr_gcs_code1_weight"+1));
				tabdata.put("MR_GCS_CODE3",
req.getParameter("mr_code"+2) == null?"":req.getParameter("mr_code"+2));
				tabdata.put("MR_GCS_CODE3_SCORE",req.getParameter("mr_gcs_code1_weight"+2) == null?"":req.getParameter("mr_gcs_code1_weight"+2));
				tabdata.put("MR_GCS_CODE4",
req.getParameter("mr_code"+3) == null?"":req.getParameter("mr_code"+3));
				tabdata.put("MR_GCS_CODE4_SCORE",req.getParameter("mr_gcs_code1_weight"+3) == null?"":req.getParameter("mr_gcs_code1_weight"+3));
				tabdata.put("MR_GCS_CODE5",
req.getParameter("mr_code"+4) == null?"":req.getParameter("mr_code"+4));
				tabdata.put("MR_GCS_CODE5_SCORE",req.getParameter("mr_gcs_code1_weight"+4) == null?"":req.getParameter("mr_gcs_code1_weight"+4));
				tabdata.put("MR_GCS_CODE6",
req.getParameter("mr_code"+5) == null?"":req.getParameter("mr_code"+5));
				tabdata.put("MR_GCS_CODE6_SCORE",req.getParameter("mr_gcs_code1_weight"+5) == null?"":req.getParameter("mr_gcs_code1_weight"+5));
				tabdata.put("ADDED_BY_ID",addedById);
				tabdata.put("ADDED_DATE",added_date);
				tabdata.put("ADDED_AT_WS_NO",addedAtWorkstation);
				tabdata.put("ADDED_FACILITY_ID", facilityId);
				tabdata.put("MODIFIED_BY_ID",modifiedById);
				tabdata.put("MODIFIED_DATE",modified_date);
				tabdata.put("MODIFIED_FACILITY_ID",modifiedFacilityId);
				tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );
        
   			String dupflds[]={"MODULE_ID"};
		try{
			boolean local_ejbs = false;
			String tablename ="AE_GCS_SCORE";

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = dupflds;
			argArray[3] = tablename;

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = dupflds.getClass();
			paramArray[3] = tablename.getClass();


			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

				inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
				String error = (String) results.get("error") ;
				String error_value = "0" ;
	    		   if ( inserted )
				   {
					    error_value= "1";
		     			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8"  ) + "&err_value=" + error_value );
	        	   }
		     	   else
		     	   {
						res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8"  ) + "&err_value=" + error_value );
		     	   }
				   tabdata.clear();
				   results.clear();
		     }catch(Exception e)
                {
				 e.printStackTrace();
	              //out.println("From Servlet--Calling EJB:"+e);
				  String error = "Error "   + e;
				  String error_value = "0" ;
			      res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8"  ) + "&err_value=" + error_value );                  
	            }
	  }catch ( Exception e )
      {
		e.printStackTrace();
		//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
      }
  } // End of the insertGCSScore

 private void  modifyGCSScore(HttpServletRequest req, HttpServletResponse res){
  try{
		String addedById			= p.getProperty( "login_user" ) ;
		String addedDate			= dateFormat.format( new java.util.Date() ) ;
		String modifiedById			= addedById ;
		String modifiedDate			= addedDate ;
		String addedFacilityId		= facilityId;
		String modifiedFacilityId	= addedFacilityId ;
		String addedAtWorkstation	=client_ip_address;
		String modifiedAtWorkstation= addedAtWorkstation ;
		java.sql.Date modified_date1= java.sql.Date.valueOf(modifiedDate ) ;
	    java.sql.Date modified_date = new java.sql.Date(modified_date1.parse(modified_date1.toLocaleString())-(modified_date1.getTimezoneOffset()*60*1000) ) ; 

		java.util.HashMap tabdata=new HashMap();
		tabdata.put("GCS_RESPONSE_CODE_ER","ER");
		tabdata.put("ER_GCS_CODE1",req.getParameter("er_code"+0) == null?"":req.getParameter("er_code"+0));
		tabdata.put("ER_GCS_CODE1_SCORE",req.getParameter("er_gcs_code1_weight"+0) == null?"":req.getParameter("er_gcs_code1_weight"+0));
		tabdata.put("ER_GCS_CODE2",req.getParameter("er_code"+1) == null?"":req.getParameter("er_code"+1));
		tabdata.put("ER_GCS_CODE2_SCORE",req.getParameter("er_gcs_code1_weight"+1) == null?"":req.getParameter("er_gcs_code1_weight"+1));
		tabdata.put("ER_GCS_CODE3",req.getParameter("er_code"+2) == null?"":req.getParameter("er_code"+2));
		tabdata.put("ER_GCS_CODE3_SCORE",req.getParameter("er_gcs_code1_weight"+2) == null?"":req.getParameter("er_gcs_code1_weight"+2));
		tabdata.put("ER_GCS_CODE4",req.getParameter("er_code"+3) == null?"":req.getParameter("er_code"+3));
		tabdata.put("ER_GCS_CODE4_SCORE",req.getParameter("er_gcs_code1_weight"+3) == null?"":req.getParameter("er_gcs_code1_weight"+3));
		tabdata.put("GCS_RESPONSE_CODE_VR","VR");
		tabdata.put("VR_GCS_CODE1",
req.getParameter("vr_code"+0) == null?"":req.getParameter("vr_code"+0));
		tabdata.put("VR_GCS_CODE1_SCORE",
req.getParameter("vr_gcs_code1_weight"+0) == null?"":req.getParameter("vr_gcs_code1_weight"+0));
		tabdata.put("VR_GCS_CODE2",
req.getParameter("vr_code"+1) == null?"":req.getParameter("vr_code"+1));
		tabdata.put("VR_GCS_CODE2_SCORE",
req.getParameter("vr_gcs_code1_weight"+1) == null?"":req.getParameter("vr_gcs_code1_weight"+1));
		tabdata.put("VR_GCS_CODE3",
req.getParameter("vr_code"+2) == null?"":req.getParameter("vr_code"+2));
		tabdata.put("VR_GCS_CODE3_SCORE",
req.getParameter("vr_gcs_code1_weight"+2) == null?"":req.getParameter("vr_gcs_code1_weight"+2));
		tabdata.put("VR_GCS_CODE4",
req.getParameter("vr_code"+3) == null?"":req.getParameter("vr_code"+3));
		tabdata.put("VR_GCS_CODE4_SCORE",
req.getParameter("vr_gcs_code1_weight"+3) == null?"":req.getParameter("vr_gcs_code1_weight"+3));
		tabdata.put("VR_GCS_CODE5",
req.getParameter("vr_code"+4) == null?"":req.getParameter("vr_code"+4));
		tabdata.put("VR_GCS_CODE5_SCORE",
req.getParameter("vr_gcs_code1_weight"+4) == null?"":req.getParameter("vr_gcs_code1_weight"+4));
		tabdata.put("GCS_RESPONSE_CODE_MR","MR");
		tabdata.put("MR_GCS_CODE1",
req.getParameter("mr_code"+0) == null?"":req.getParameter("mr_code"+0));
		tabdata.put("MR_GCS_CODE1_SCORE",req.getParameter("mr_gcs_code1_weight"+0) == null?"":req.getParameter("mr_gcs_code1_weight"+0));
		tabdata.put("MR_GCS_CODE2",
req.getParameter("mr_code"+1) == null?"":req.getParameter("mr_code"+1));
		tabdata.put("MR_GCS_CODE2_SCORE",req.getParameter("mr_gcs_code1_weight"+1) == null?"":req.getParameter("mr_gcs_code1_weight"+1));
		tabdata.put("MR_GCS_CODE3",
req.getParameter("mr_code"+2) == null?"":req.getParameter("mr_code"+2));
		tabdata.put("MR_GCS_CODE3_SCORE",req.getParameter("mr_gcs_code1_weight"+2) == null?"":req.getParameter("mr_gcs_code1_weight"+2));
		tabdata.put("MR_GCS_CODE4",
req.getParameter("mr_code"+3) == null?"":req.getParameter("mr_code"+3));
		tabdata.put("MR_GCS_CODE4_SCORE",req.getParameter("mr_gcs_code1_weight"+3) == null?"":req.getParameter("mr_gcs_code1_weight"+3));
		tabdata.put("MR_GCS_CODE5",
req.getParameter("mr_code"+4) == null?"":req.getParameter("mr_code"+4));
		tabdata.put("MR_GCS_CODE5_SCORE",req.getParameter("mr_gcs_code1_weight"+4) == null?"":req.getParameter("mr_gcs_code1_weight"+4));
		tabdata.put("MR_GCS_CODE6",
req.getParameter("mr_code"+5) == null?"":req.getParameter("mr_code"+5));
		tabdata.put("MR_GCS_CODE6_SCORE",req.getParameter("mr_gcs_code1_weight"+5) == null?"":req.getParameter("mr_gcs_code1_weight"+5));
		tabdata.put("MODIFIED_BY_ID",modifiedById);
		tabdata.put("MODIFIED_DATE",modified_date);
		tabdata.put("MODIFIED_FACILITY_ID",modifiedFacilityId);
		tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );
        
	   java.util.HashMap condflds=new HashMap();
			condflds.put("MODULE_ID",module_id);

		try{

			boolean local_ejbs = false;
			String tablename ="AE_GCS_SCORE";

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = condflds;
			argArray[3] = tablename;

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = condflds.getClass();
			paramArray[3] = tablename.getClass();


			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
				String error = (String) results.get("error") ;
				String error_value = "0" ;
				out.println("error "+error+" inserted "+inserted);
	    		   if ( inserted )
				   {
					    error_value= "1";
		     			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8"  ) + "&err_value=" + error_value );
	        	   }
		     	   else
		     	   {
						res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8"  ) + "&err_value=" + error_value );
		     	   }
				   tabdata.clear();
				   condflds.clear();
				   results.clear(); 
		     }catch(Exception e)
                {
	              //out.println("From Servlet--Calling EJB:"+e);
                  e.printStackTrace();
				  String error = "Error ";
				  String error_value = "0" ;
			      res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8"  ) + "&err_value=" + error_value );                  
	            }
	  }catch ( Exception e )
      {
		e.printStackTrace();
		//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
      }
  } // End of the modify GCSScore
} // End of the Class
