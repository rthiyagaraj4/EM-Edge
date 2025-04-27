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
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;

import eCommon.SingleTabHandler.*;

public class MRAuditTrialParameterServlet extends javax.servlet.http.HttpServlet
{

	PrintWriter out;
	Properties p;
	String facilityId ;
	String client_ip_address ;

	String general_details_hist_yn = "";
	String attending_practitioner_hist_yn = "";
	String auth_practitioner_hist_yn = "";
	String brought_dead_hist_yn = "";
	//String deceased_details_hist_yn = "";
	String diagnosis_details_hist_yn = "";
	String seq_no_hist_yn = "";
	String add_diagnosis_hist_yn = "";
	String moved_from_gen_to_cod_hist_yn = "";
	String moved_from_cod_to_oth_hist_yn = "";
	String moved_from_oth_to_cod_hist_yn = "";
	String cause_of_death_remarks_hist_yn = "";
	String moved_from_cod_to_gen_hist_yn = "";
	String moved_from_oth_to_gen_hist_yn = "";
	String moved_from_gen_to_oth_hist_yn = "";
	String female_patient_details_hist_yn = "";
	String mlc_patient_details_hist_yn = "";
	String medical_legal_case_hist_yn = "";
	String pol_rep_no_hist_yn = "";
	String pol_stn_id_hist_yn = "";
	String pol_id_hist_yn = "";
	String print_details_hist_yn = "";
	String onset_date_hist_yn = "";


	HttpSession session;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;



	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		session = req.getSession(false);
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		this.p = (Properties) session.getValue( "jdbc" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");
		try
		{			
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			String operation = req.getParameter("function1");
			if ( operation.equals("insert") )   insertAuditTrailParam(req, res);
			if ( operation.equals("modify"))    modifyAuditTrailParam(req, res);
		}
		catch(Exception e)
		{
			//out.println(e.toString());
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		try
		{
			this.out = res.getWriter();	
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			String operation = req.getParameter("function1");

			if ( operation.equals("insert") )   insertAuditTrailParam(req, res);
			if ( operation.equals("modify"))    modifyAuditTrailParam(req, res);
		}
		catch(Exception e)	{	/* out.println(e.toString()); */ e.printStackTrace(); }
	}

			
	private void insertAuditTrailParam(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			
			general_details_hist_yn = req.getParameter("general_details_hist_yn")==null?"N":req.getParameter("general_details_hist_yn");
			attending_practitioner_hist_yn = req.getParameter("attending_practitioner_hist_yn")==null?"N":req.getParameter("attending_practitioner_hist_yn");
			auth_practitioner_hist_yn = req.getParameter("auth_practitioner_hist_yn")==null?"N":req.getParameter("auth_practitioner_hist_yn");
			brought_dead_hist_yn = req.getParameter("brought_dead_hist_yn")==null?"N":req.getParameter("brought_dead_hist_yn");
			//deceased_details_hist_yn = req.getParameter("deceased_details_hist_yn")==null?"N":req.getParameter("deceased_details_hist_yn");
			diagnosis_details_hist_yn = req.getParameter("diagnosis_details_hist_yn")==null?"N":req.getParameter("diagnosis_details_hist_yn");
			seq_no_hist_yn = req.getParameter("seq_no_hist_yn")==null?"N":req.getParameter("seq_no_hist_yn");
			add_diagnosis_hist_yn = req.getParameter("add_diagnosis_hist_yn")==null?"N":req.getParameter("add_diagnosis_hist_yn");
			moved_from_gen_to_cod_hist_yn = req.getParameter("moved_from_gen_to_cod_hist_yn")==null?"N":req.getParameter("moved_from_gen_to_cod_hist_yn");
			moved_from_cod_to_oth_hist_yn = req.getParameter("moved_from_cod_to_oth_hist_yn")==null?"N":req.getParameter("moved_from_cod_to_oth_hist_yn");
			moved_from_oth_to_cod_hist_yn = req.getParameter("moved_from_oth_to_cod_hist_yn")==null?"N":req.getParameter("moved_from_oth_to_cod_hist_yn");
			cause_of_death_remarks_hist_yn = req.getParameter("cause_of_death_remarks_hist_yn")==null?"N":req.getParameter("cause_of_death_remarks_hist_yn");
			moved_from_cod_to_gen_hist_yn = req.getParameter("moved_from_cod_to_gen_hist_yn")==null?"N":req.getParameter("moved_from_cod_to_gen_hist_yn");
			moved_from_oth_to_gen_hist_yn = req.getParameter("moved_from_oth_to_gen_hist_yn")==null?"N":req.getParameter("moved_from_oth_to_gen_hist_yn");
			moved_from_gen_to_oth_hist_yn = req.getParameter("moved_from_gen_to_oth_hist_yn")==null?"N":req.getParameter("moved_from_gen_to_oth_hist_yn");
			female_patient_details_hist_yn = req.getParameter("female_patient_details_hist_yn")==null?"N":req.getParameter("female_patient_details_hist_yn");
			mlc_patient_details_hist_yn = req.getParameter("mlc_patient_details_hist_yn")==null?"N":req.getParameter("mlc_patient_details_hist_yn");
			medical_legal_case_hist_yn = req.getParameter("medical_legal_case_hist_yn")==null?"N":req.getParameter("medical_legal_case_hist_yn");
			pol_rep_no_hist_yn = req.getParameter("pol_rep_no_hist_yn")==null?"N":req.getParameter("pol_rep_no_hist_yn");
			pol_stn_id_hist_yn = req.getParameter("pol_stn_id_hist_yn")==null?"N":req.getParameter("pol_stn_id_hist_yn");
			pol_id_hist_yn = req.getParameter("pol_id_hist_yn")==null?"N":req.getParameter("pol_id_hist_yn");
			print_details_hist_yn = req.getParameter("print_details_hist_yn")==null?"N":req.getParameter("print_details_hist_yn");
			onset_date_hist_yn = req.getParameter("onset_date_hist_yn")==null?"N":req.getParameter("onset_date_hist_yn");
			String addedById = p.getProperty( "login_user" ) ;
			String addedDate = dateFormat.format( new java.util.Date() ) ;
			String modifiedById = addedById ;
			String modifiedDate = addedDate ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			java.sql.Date added_date = java.sql.Date.valueOf( addedDate ) ;
			java.sql.Date modified_date = java.sql.Date.valueOf( modifiedDate ) ;

			HashMap tabdata=new HashMap();

			tabdata.put("general_details_hist_yn",general_details_hist_yn);
			tabdata.put("attending_practitioner_hist_yn",attending_practitioner_hist_yn);
			tabdata.put("auth_practitioner_hist_yn",auth_practitioner_hist_yn);
			tabdata.put("brought_in_dead_hist_yn",brought_dead_hist_yn);
			//tabdata.put("deceased_details_hist_yn",deceased_details_hist_yn);
			tabdata.put("diagnosis_details_hist_yn",diagnosis_details_hist_yn);
			tabdata.put("seq_no_hist_yn",seq_no_hist_yn);
			tabdata.put("add_diagnosis_hist_yn",add_diagnosis_hist_yn);
			tabdata.put("moved_from_gen_to_cod_hist_yn",moved_from_gen_to_cod_hist_yn);
			tabdata.put("moved_from_cod_to_oth_hist_yn",moved_from_cod_to_oth_hist_yn);
			tabdata.put("moved_from_oth_to_cod_hist_yn",moved_from_oth_to_cod_hist_yn);
			tabdata.put("cause_of_death_remarks_hist_yn",cause_of_death_remarks_hist_yn);
			tabdata.put("moved_from_cod_to_gen_hist_yn",moved_from_cod_to_gen_hist_yn);
			tabdata.put("moved_from_oth_to_gen_hist_yn",moved_from_oth_to_gen_hist_yn);
			tabdata.put("moved_from_gen_to_oth_hist_yn",moved_from_gen_to_oth_hist_yn);
			tabdata.put("female_patient_details_hist_yn",female_patient_details_hist_yn);
			tabdata.put("mlc_patient_details_hist_yn",mlc_patient_details_hist_yn);
			tabdata.put("medical_legal_case_hist_yn",medical_legal_case_hist_yn);
			tabdata.put("pol_rep_no_hist_yn",pol_rep_no_hist_yn);
			tabdata.put("pol_stn_id_hist_yn",pol_stn_id_hist_yn);
			tabdata.put("pol_id_hist_yn",pol_id_hist_yn);
			tabdata.put("print_details_hist_yn",print_details_hist_yn);
			tabdata.put("onset_date_hist_yn",onset_date_hist_yn);

			tabdata.put("added_by_id",addedById);
			tabdata.put("added_date",added_date);
			tabdata.put("added_facility_id", facilityId);
			tabdata.put("added_at_ws_no",addedAtWorkstation);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",modified_date);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );


			String dupflds[]={"added_facility_id"};

			String tableName = "MR_DEATH_REG_AUDIT_TRIAL_PARAM";
			boolean local_ejbs = false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = dupflds;
			argArray[3] = tableName;

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = dupflds.getClass();
			paramArray[3] = tableName.getClass();

			HashMap results = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			boolean inserted	= ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value="";
			if ( inserted )
			{
				error_value = "1" ;
			}
			else
			{
				error = (String) results.get("error") ;
				error_value = "0" ;
			}

		   	error = (String) results.get("error") ;
    		res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
			if ( tabdata != null) tabdata.clear();
			if ( results != null) results.clear();
		}
		catch ( Exception e )
		{
			//out.println("<h3> Exception raise by Servlet ...So Record Not Inserted</h3> Foll: Error Received : "+e.toString());
		e.printStackTrace();
		}



	}

	private void modifyAuditTrailParam(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			
			general_details_hist_yn = req.getParameter("general_details_hist_yn")==null?"N":req.getParameter("general_details_hist_yn");
			attending_practitioner_hist_yn = req.getParameter("attending_practitioner_hist_yn")==null?"N":req.getParameter("attending_practitioner_hist_yn");
			auth_practitioner_hist_yn = req.getParameter("auth_practitioner_hist_yn")==null?"N":req.getParameter("auth_practitioner_hist_yn");
			brought_dead_hist_yn = req.getParameter("brought_dead_hist_yn")==null?"N":req.getParameter("brought_dead_hist_yn");
			//deceased_details_hist_yn = req.getParameter("deceased_details_hist_yn")==null?"N":req.getParameter("deceased_details_hist_yn");
			diagnosis_details_hist_yn = req.getParameter("diagnosis_details_hist_yn")==null?"N":req.getParameter("diagnosis_details_hist_yn");
			seq_no_hist_yn = req.getParameter("seq_no_hist_yn")==null?"N":req.getParameter("seq_no_hist_yn");
			add_diagnosis_hist_yn = req.getParameter("add_diagnosis_hist_yn")==null?"N":req.getParameter("add_diagnosis_hist_yn");
			moved_from_gen_to_cod_hist_yn = req.getParameter("moved_from_gen_to_cod_hist_yn")==null?"N":req.getParameter("moved_from_gen_to_cod_hist_yn");
			moved_from_cod_to_oth_hist_yn = req.getParameter("moved_from_cod_to_oth_hist_yn")==null?"N":req.getParameter("moved_from_cod_to_oth_hist_yn");
			moved_from_oth_to_cod_hist_yn = req.getParameter("moved_from_oth_to_cod_hist_yn")==null?"N":req.getParameter("moved_from_oth_to_cod_hist_yn");
			cause_of_death_remarks_hist_yn = req.getParameter("cause_of_death_remarks_hist_yn")==null?"N":req.getParameter("cause_of_death_remarks_hist_yn");
			moved_from_cod_to_gen_hist_yn = req.getParameter("moved_from_cod_to_gen_hist_yn")==null?"N":req.getParameter("moved_from_cod_to_gen_hist_yn");
			moved_from_oth_to_gen_hist_yn = req.getParameter("moved_from_oth_to_gen_hist_yn")==null?"N":req.getParameter("moved_from_oth_to_gen_hist_yn");
			moved_from_gen_to_oth_hist_yn = req.getParameter("moved_from_gen_to_oth_hist_yn")==null?"N":req.getParameter("moved_from_gen_to_oth_hist_yn");

			female_patient_details_hist_yn = req.getParameter("female_patient_details_hist_yn")==null?"N":req.getParameter("female_patient_details_hist_yn");
			mlc_patient_details_hist_yn = req.getParameter("mlc_patient_details_hist_yn")==null?"N":req.getParameter("mlc_patient_details_hist_yn");
			medical_legal_case_hist_yn = req.getParameter("medical_legal_case_hist_yn")==null?"N":req.getParameter("medical_legal_case_hist_yn");
			pol_rep_no_hist_yn = req.getParameter("pol_rep_no_hist_yn")==null?"N":req.getParameter("pol_rep_no_hist_yn");
			pol_stn_id_hist_yn = req.getParameter("pol_stn_id_hist_yn")==null?"N":req.getParameter("pol_stn_id_hist_yn");
			pol_id_hist_yn = req.getParameter("pol_id_hist_yn")==null?"N":req.getParameter("pol_id_hist_yn");
			print_details_hist_yn = req.getParameter("print_details_hist_yn")==null?"N":req.getParameter("print_details_hist_yn");
			onset_date_hist_yn = req.getParameter("onset_date_hist_yn")==null?"N":req.getParameter("onset_date_hist_yn");

			String addedById = p.getProperty( "login_user" ) ;
			String addedDate = dateFormat.format( new java.util.Date() ) ;
			String modifiedById = addedById ;
			String modifiedDate = addedDate ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;
			java.sql.Date modified_date = java.sql.Date.valueOf( modifiedDate ) ;


			HashMap tabdata=new HashMap();

			tabdata.put("general_details_hist_yn",general_details_hist_yn);
			tabdata.put("attending_practitioner_hist_yn",attending_practitioner_hist_yn);
			tabdata.put("auth_practitioner_hist_yn",auth_practitioner_hist_yn);
			tabdata.put("brought_in_dead_hist_yn",brought_dead_hist_yn);
			//tabdata.put("deceased_details_hist_yn",deceased_details_hist_yn);
			tabdata.put("diagnosis_details_hist_yn",diagnosis_details_hist_yn);
			tabdata.put("seq_no_hist_yn",seq_no_hist_yn);
			tabdata.put("add_diagnosis_hist_yn",add_diagnosis_hist_yn);
			tabdata.put("moved_from_gen_to_cod_hist_yn",moved_from_gen_to_cod_hist_yn);
			tabdata.put("moved_from_cod_to_oth_hist_yn",moved_from_cod_to_oth_hist_yn);
			tabdata.put("moved_from_oth_to_cod_hist_yn",moved_from_oth_to_cod_hist_yn);
			tabdata.put("cause_of_death_remarks_hist_yn",cause_of_death_remarks_hist_yn);
			tabdata.put("moved_from_cod_to_gen_hist_yn",moved_from_cod_to_gen_hist_yn);
			tabdata.put("moved_from_oth_to_gen_hist_yn",moved_from_oth_to_gen_hist_yn);
			tabdata.put("moved_from_gen_to_oth_hist_yn",moved_from_gen_to_oth_hist_yn);
			tabdata.put("female_patient_details_hist_yn",female_patient_details_hist_yn);
			tabdata.put("mlc_patient_details_hist_yn",mlc_patient_details_hist_yn);
			tabdata.put("medical_legal_case_hist_yn",medical_legal_case_hist_yn);
			tabdata.put("pol_rep_no_hist_yn",pol_rep_no_hist_yn);
			tabdata.put("pol_stn_id_hist_yn",pol_stn_id_hist_yn);
			tabdata.put("pol_id_hist_yn",pol_id_hist_yn);
			tabdata.put("print_details_hist_yn",print_details_hist_yn);
			tabdata.put("onset_date_hist_yn",onset_date_hist_yn);

			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",modified_date);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
			HashMap condflds=new HashMap();
			String tableName = "MR_DEATH_REG_AUDIT_TRIAL_PARAM";
			boolean local_ejbs = false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = condflds;
			argArray[3] = tableName;

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = condflds.getClass();
			paramArray[3] = tableName.getClass();

			HashMap results = (HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			boolean inserted	= ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value="";
			if(inserted)
			{
				error_value = "1" ;
			}
			else
			{
				error_value = "0" ;
				error = (String) results.get("error") ;
			}

        	error = (String) results.get("error") ;
    		res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" )  + "&err_value=" + error_value );
			if ( tabdata != null) tabdata.clear();
			if ( results != null) results.clear();
			if ( condflds != null) condflds.clear();
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}


	}
	
	
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
}
