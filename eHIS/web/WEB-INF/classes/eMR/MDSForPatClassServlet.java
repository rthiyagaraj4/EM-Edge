/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMR;

import java.sql.*;
import java.sql.Date;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import eCommon.Common.*;
import webbeans.eCommon.*;

import eCommon.SingleTabHandler.*;

import eCommon.XSSRequestWrapper;

public class MDSForPatClassServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	PrintWriter out;
	java.util.Properties p;
	String accuracy_code="";
	String patient_class="";
	String added_by_id = "";
	String added_at_ws_no = "";
	String added_facility_id = "";
	String msg = "";
	String locale ="";
	String facilityId ;
	String client_ip_address;
	String db_action;
	String min_data_set= "";
	String mds_sub_code = "";
	String mode ;
	String applicable_to_ip_yn = "";
	String mandatory_for_ip_yn = "";
    String applicable_to_op_yn = "";                                                                               
    String mandatory_for_op_yn = "";                                                                             
    String applicable_to_em_yn = "";                                                                                
    String mandatory_for_em_yn = "";                                                                                
    String applicable_to_dc_yn = "";                                                                              
    String mandatory_for_dc_yn = "";
	/*String applicable_to_xt_yn = "";
	String mandatory_for_xt_yn = "";*/
	String ip_stage="";
	String op_stage="";
	String em_stage="";
	String dc_stage="";
	String ip_principal_diag_yn="";
	String op_principal_diag_yn="";
	String em_principal_diag_yn="";
	String dc_principal_diag_yn="";
	
	HttpSession session;

	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		try
		{
			doPost(req,res);		
		}
		catch(Exception e)	
		{	
			e.printStackTrace();
		}
	}
	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{			
		
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		client_ip_address = p.getProperty("client_ip_address");
		try
		{			
				
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			
			req= new XSSRequestWrapper(req);
			res.addHeader("X-XSS-Protection", "1; mode=block");
			res.addHeader("X-Content-Type-Options", "nosniff");
			
			this.out = res.getWriter();
			mode = req.getParameter("mode");
			applicable_to_ip_yn =checkForNull(req.getParameter("chk_ip_app"));
			mandatory_for_ip_yn = checkForNull(req.getParameter("chk_ip_man"));
			applicable_to_op_yn = checkForNull(req.getParameter("chk_op_app"));
			mandatory_for_op_yn = checkForNull(req.getParameter("chk_op_man"));
			applicable_to_em_yn = checkForNull(req.getParameter("chk_em_app"));
			mandatory_for_em_yn = checkForNull(req.getParameter("chk_em_man"));
			applicable_to_dc_yn = checkForNull(req.getParameter("chk_dc_app"));
			mandatory_for_dc_yn = checkForNull(req.getParameter("chk_dc_man"));
			
			try
			{
			if ( mode.equals("insert"))   InsertMDSForPatClassAddModify(req,res);	
			else if (mode.equals("modify")) ModifyMDSForPatClassAddModify(req,res);				
			}
			catch(Exception e)	
			{	
			e.printStackTrace();
			}

		}
		catch(Exception e)
		{
			/* out.println(e.toString()); */
			
			e.printStackTrace();
		}
	}
	private void InsertMDSForPatClassAddModify(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			min_data_set = req.getParameter("min_data");
			if(min_data_set.equals("CHRT"))
			mds_sub_code = req.getParameter("chart_desc_1");
			if(min_data_set.equals("CLIN"))
			mds_sub_code = req.getParameter("note_type_desc_1");
			if(min_data_set.equals("ORDR"))
			mds_sub_code = req.getParameter("order_category_code");
			if(min_data_set.equals("DIAG"))
			mds_sub_code = req.getParameter("termset_code");
			applicable_to_ip_yn = checkForNull(req.getParameter("chk_ip_app"));
			mandatory_for_ip_yn = checkForNull(req.getParameter("chk_ip_man"));
			applicable_to_op_yn = checkForNull(req.getParameter("chk_op_app"));
			mandatory_for_op_yn = checkForNull(req.getParameter("chk_op_man"));
			applicable_to_em_yn = checkForNull(req.getParameter("chk_em_app"));
			mandatory_for_em_yn = checkForNull(req.getParameter("chk_em_man"));
			applicable_to_dc_yn = checkForNull(req.getParameter("chk_dc_app"));
			mandatory_for_dc_yn = checkForNull(req.getParameter("chk_dc_man"));
			ip_stage= req.getParameter("ip_stage");
			if(ip_stage==null)ip_stage="ALL";
			op_stage= req.getParameter("op_stage");
			if(op_stage==null)op_stage="OC";
			em_stage= req.getParameter("em_stage");
			if(em_stage==null)em_stage="EC";
			dc_stage= req.getParameter("dc_stage");
			if(dc_stage==null)dc_stage="ALL";
			ip_principal_diag_yn= checkForNull(req.getParameter("ip_principal_diag_yn_hid"));			
			op_principal_diag_yn= checkForNull(req.getParameter("op_principal_diag_yn_hid"));			
			em_principal_diag_yn= checkForNull(req.getParameter("em_principal_diag_yn_hid"));			
			dc_principal_diag_yn= checkForNull(req.getParameter("dc_principal_diag_yn_hid"));	
			//applicable_to_xt_yn = "N";
			//mandatory_for_xt_yn = "N";
			String addedById = p.getProperty( "login_user" ) ;
			String addedDate = dateFormat.format( new java.util.Date() ) ;
			String modifiedById = addedById ;
			String modifiedDate = addedDate ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;
			
			Date added_date1 = Date.valueOf( addedDate ) ;
			Date added_date = new Date(added_date1.parse(added_date1.toLocaleString())-(added_date1.getTimezoneOffset()*60*1000) ) ;
			Date modified_date1 = Date.valueOf(modifiedDate ) ;
			Date modified_date = new Date(modified_date1.parse(modified_date1.toLocaleString())-(modified_date1.getTimezoneOffset()*60*1000) ) ; 
			
			HashMap tabdata=new HashMap();
			
			tabdata.put("mds_code",min_data_set);
			tabdata.put("term_set_id",mds_sub_code);
			tabdata.put("applicable_to_ip_yn",applicable_to_ip_yn);
			tabdata.put("mandatory_for_ip_yn",mandatory_for_ip_yn);
			tabdata.put("applicable_to_op_yn",applicable_to_op_yn);
			tabdata.put("mandatory_for_op_yn",mandatory_for_op_yn);
			tabdata.put("applicable_to_em_yn",applicable_to_em_yn);
			tabdata.put("mandatory_for_em_yn",mandatory_for_em_yn);
			tabdata.put("applicable_to_dc_yn",applicable_to_dc_yn);
			tabdata.put("mandatory_for_dc_yn",mandatory_for_dc_yn);
			//tabdata.put("applicable_to_xt_yn",applicable_to_xt_yn);
			//tabdata.put("mandatory_for_xt_yn",mandatory_for_xt_yn);
			tabdata.put("added_by_id",addedById);
			tabdata.put("added_date",added_date);
			tabdata.put("added_facility_id", facilityId);
			tabdata.put("added_at_ws_no",addedAtWorkstation);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",modified_date);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
			tabdata.put("ip_stage",ip_stage);
			tabdata.put("op_stage",op_stage);
			tabdata.put("em_stage",em_stage);
			tabdata.put("dc_stage",dc_stage);
			tabdata.put("ip_principal_diag_yn",ip_principal_diag_yn);
			tabdata.put("op_principal_diag_yn",op_principal_diag_yn);
			tabdata.put("em_principal_diag_yn",em_principal_diag_yn);
			tabdata.put("dc_principal_diag_yn",dc_principal_diag_yn);
			
			
			String dupflds[]={"mds_code","term_set_id"};
			
			String table_name="mr_mds_for_patient_class";
		

			boolean local_ejbs = false;
			ServletContext context = getServletConfig().getServletContext();
			if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
					argArray[0] =p;
				argArray[1] =tabdata;
				argArray[2] =dupflds;
				argArray[3] =table_name;

				Class [] paramArray = new Class[4];
					paramArray[0] =p.getClass();
					paramArray[1] =tabdata.getClass();
					paramArray[2] =dupflds.getClass();
					paramArray[3] =table_name.getClass();

					HashMap results = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
		
			tabdata.clear();
			
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error") ;
			String error_value = "0" ;
			if ( inserted ){
				error_value = "1" ;
			 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8")+"&err_value="+error_value );

           
			}
			else
			{
				 error = (String) results.get("error") ;
				 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error, "UTF-8" ) );
			}
			if ( results != null) results.clear();
		}
		catch (Exception e)
		{
			/* out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			out.println( min_data_set+"    "+mds_sub_code+"  "); */
			e.printStackTrace();
		}
	}
	private void ModifyMDSForPatClassAddModify(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			min_data_set = req.getParameter("min_data");
			if(min_data_set.equals("CHRT"))
			mds_sub_code = req.getParameter("chart_desc_1");
			if(min_data_set.equals("CLIN"))
			mds_sub_code = req.getParameter("note_type_desc_1");
			if(min_data_set.equals("ORDR"))
			mds_sub_code = req.getParameter("order_category_code");
			if(min_data_set.equals("DIAG"))
			mds_sub_code = req.getParameter("termset_code");
			applicable_to_ip_yn = checkForNull(req.getParameter("chk_ip_app_hid"));
			mandatory_for_ip_yn = checkForNull(req.getParameter("chk_ip_man_hid"));
			applicable_to_op_yn = checkForNull(req.getParameter("chk_op_app_hid"));
			mandatory_for_op_yn = checkForNull(req.getParameter("chk_op_man_hid"));
			applicable_to_em_yn = checkForNull(req.getParameter("chk_em_app_hid"));
			mandatory_for_em_yn = checkForNull(req.getParameter("chk_em_man_hid"));
			applicable_to_dc_yn = checkForNull(req.getParameter("chk_dc_app_hid"));
			mandatory_for_dc_yn = checkForNull(req.getParameter("chk_dc_man_hid"));
			ip_stage= req.getParameter("ip_stage");
			if(ip_stage==null)ip_stage="ALL";
			op_stage= req.getParameter("op_stage");
			if(op_stage==null)op_stage="OC";
			em_stage= req.getParameter("em_stage");
			if(em_stage==null)em_stage="EC";
			dc_stage= req.getParameter("dc_stage");
			if(dc_stage==null)dc_stage="ALL";
			ip_principal_diag_yn= checkForNull(req.getParameter("ip_principal_diag_yn_hid"));			
			op_principal_diag_yn= checkForNull(req.getParameter("op_principal_diag_yn_hid"));			
			em_principal_diag_yn= checkForNull(req.getParameter("em_principal_diag_yn_hid"));			
			dc_principal_diag_yn= checkForNull(req.getParameter("dc_principal_diag_yn_hid"));	
			//applicable_to_xt_yn = "N";
			//mandatory_for_xt_yn = "N";
			String addedById = p.getProperty( "login_user" ) ;
			String addedDate = dateFormat.format( new java.util.Date() ) ;
			String modifiedById = addedById ;
			String modifiedDate = addedDate ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;
						
			Date modified_date1 = Date.valueOf(modifiedDate ) ;
			Date modified_date = new Date(modified_date1.parse(modified_date1.toLocaleString())-(modified_date1.getTimezoneOffset()*60*1000) ) ; 
			
			HashMap tabdata=new HashMap();
			tabdata.put("mds_code",min_data_set);
			tabdata.put("term_set_id",mds_sub_code);
			tabdata.put("applicable_to_ip_yn",applicable_to_ip_yn);
			tabdata.put("mandatory_for_ip_yn",mandatory_for_ip_yn);
			tabdata.put("applicable_to_op_yn",applicable_to_op_yn);
			tabdata.put("mandatory_for_op_yn",mandatory_for_op_yn);
			tabdata.put("applicable_to_em_yn",applicable_to_em_yn);
			tabdata.put("mandatory_for_em_yn",mandatory_for_em_yn);
			tabdata.put("applicable_to_dc_yn",applicable_to_dc_yn);
			tabdata.put("mandatory_for_dc_yn",mandatory_for_dc_yn);
			//tabdata.put("applicable_to_xt_yn",applicable_to_xt_yn);
			//tabdata.put("mandatory_for_xt_yn",mandatory_for_xt_yn);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",modified_date);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
			tabdata.put("ip_stage",ip_stage);
			tabdata.put("op_stage",op_stage);
			tabdata.put("em_stage",em_stage);
			tabdata.put("dc_stage",dc_stage);
			tabdata.put("ip_principal_diag_yn",ip_principal_diag_yn);
			tabdata.put("op_principal_diag_yn",op_principal_diag_yn);
			tabdata.put("em_principal_diag_yn",em_principal_diag_yn);
			tabdata.put("dc_principal_diag_yn",dc_principal_diag_yn);

			String table_name="mr_mds_for_patient_class";

			HashMap condflds=new HashMap();
			condflds.put("mds_code",min_data_set);
			condflds.put("term_set_id",mds_sub_code);
		

			boolean local_ejbs = false;
			ServletContext context = getServletConfig().getServletContext();
			if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
					argArray[0] =p;
				argArray[1] =tabdata;
				argArray[2] =condflds;
				argArray[3] =table_name;

				Class [] paramArray = new Class[4];
					paramArray[0] =p.getClass();
					paramArray[1] =tabdata.getClass();
					paramArray[2] =condflds.getClass();
					paramArray[3] =table_name.getClass();

					HashMap results = (HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
		
			tabdata.clear();
			condflds.clear();
			
			boolean update = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error") ;
			String error_value = "0" ;
			if ( update ){
				error_value = "1" ;
			 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8")+"&err_value="+error_value );

           
			}
			else
			{
				 error = (String) results.get("error") ;
				 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error, "UTF-8" ) );
			}
			if ( results != null) results.clear();
		}
		catch (Exception e)
		{
			/* out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			out.println( min_data_set+"    "+mds_sub_code+"  "); */
			e.printStackTrace();
		}
	}


		private String checkForNull(String inputString)
		{
		return (inputString==null)	?	"N"	:	inputString;
		}


}
