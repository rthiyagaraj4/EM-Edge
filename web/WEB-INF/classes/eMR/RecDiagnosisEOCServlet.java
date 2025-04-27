/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMR;
import eMR.RecDiagnosis.*;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.text.*;

public class RecDiagnosisEOCServlet extends javax.servlet.http.HttpServlet	
{
	PrintWriter out;
	Properties p;
	
	//Hashtable env;
	
	String mode				="";
	String code_set			="";			
	String diagprob_code="";	String x_facility_id			="";
	String diag_Description="";String client_ip_address	="";
	String onset_date		="";	
	String Practitioner_Id ="";	String relationship_id		=""; 
	String Locn_Code		="";	String Locn_Type			="";
	String Patient_Id		="";	String Encounter_Id		="";
	String patient_class	="";
	String sex					="";   
	String dob					="";
	String occur_srl_no_hid	="";		
	String episode_id		=""; String eposide_desc		="";
	String primary_yn		="";	String significant_yn		="";
	String include_yn		="";
	HashMap tabdata=new HashMap();

	public void init(ServletConfig config) throws ServletException	
	{
		super.init(config);
	}
	
	public synchronized void doGet(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException
	{
		doPost(req,res);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		HttpSession session		= req.getSession(false);
		this.x_facility_id				= (String)session.getValue("facility_id") ;
		this.p							= (Properties) session.getValue( "jdbc" ) ;
		this.client_ip_address		= this.p.getProperty("client_ip_address");
		//env								= (Hashtable) session.getValue( "env" ) ;
		
		try 
		{
			Practitioner_Id		 = checkForNull(req.getParameter("Practitioner_Id"));
			relationship_id		= checkForNull(req.getParameter("relationship_id"));
			Locn_Code			= checkForNull(req.getParameter("Locn_Code"));
			Locn_Type			= checkForNull(req.getParameter("Locn_Type"));
			Patient_Id				= checkForNull(req.getParameter("Patient_Id"));
			patient_class			= checkForNull(req.getParameter("patient_class"));
			Encounter_Id			= checkForNull(req.getParameter("Encounter_Id"));
			code_set				= checkForNull(req.getParameter("code_set"));
			diagprob_code		= checkForNull(req.getParameter("diagprob_code"));
			diag_Description	= checkForNull(req.getParameter("diagprob_desc"));
			sex						= checkForNull(req.getParameter("sex"));
			dob						= checkForNull(req.getParameter("dob"));
			episode_id				= checkForNull(req.getParameter("episode_id"));
			eposide_desc		= checkForNull(req.getParameter("eposide_desc"));
			primary_yn			= checkForNull(req.getParameter("primary_yn"));
			significant_yn		= checkForNull(req.getParameter("significant_yn"));
			include_yn				= checkForNull(req.getParameter("include_yn"));
			
			tabdata.put("x_facility_id",x_facility_id);
			tabdata.put("client_ip_address",client_ip_address);
			tabdata.put("Practitioner_Id",Practitioner_Id);
			tabdata.put("relationship_id",relationship_id);
			tabdata.put("Locn_Code",Locn_Code);
			tabdata.put("Locn_Type",Locn_Type);
			tabdata.put("Patient_Id",Patient_Id);
			tabdata.put("Encounter_Id",Encounter_Id);
			tabdata.put("code_set",code_set);
			tabdata.put("diagprob_code",diagprob_code);
			tabdata.put("episode_id",episode_id);
			tabdata.put("eposide_desc",eposide_desc);
			tabdata.put("primary_yn",primary_yn);
			tabdata.put("significant_yn",significant_yn);
			tabdata.put("include_yn",include_yn);
		
			insertRecDiagnosisEOC(req, res);
		}
		catch (Exception e)
		{
			out.println("Exception Occured-->"+e.toString());
		}
		finally{
			if ( tabdata != null) tabdata.clear();
		}
	}
	/**
	INSERT**/
	private void insertRecDiagnosisEOC(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			req = req;
			
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			InitialContext context =  new InitialContext() ;
			Object homeObject = context.lookup("java:comp/env/RecDiagnosis");
			RecDiagnosisHome RecDiagnosisHome = (RecDiagnosisHome) PortableRemoteObject.narrow (homeObject,RecDiagnosisHome.class);
			RecDiagnosisRemote RecDiagnosisRemote = RecDiagnosisHome.create();
			HashMap results=new HashMap();
			results = RecDiagnosisRemote.insertRecDiagnosisEOCare(p,tabdata);
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue());
		
			String error	="";
			String error_value = "0" ;
			String flag="";
			if ( inserted )
			{
				error_value = "1" ;
				flag= (String) results.get("diff_flaf") ;
				error= (String) results.get("message") ;
				
				if(!mode.equals("modify"))
					occur_srl_no_hid= (String) results.get("occur_srl_no");
				res.sendRedirect("../eMR/jsp/RecDiagnosiserror.jsp?function_id=EOC&Patient_Id="+Patient_Id+"&patient_class="+patient_class+"&Encounter_Id="+Encounter_Id+"&mode="+mode+"&flag="+flag+"&term_set_id="+code_set+"&term_set_code="+diagprob_code+"&diag_Description="+diag_Description+"&onset_date="+onset_date+"&Practitioner_Id="+Practitioner_Id+"&Locn_Code="+Locn_Code+"&relationship_id="+relationship_id+"&Locn_Type="+Locn_Type+"&sex="+sex+"&dob="+dob+"&occur_srl_no="+occur_srl_no_hid+"&error=" + java.net.URLEncoder.encode( error, "UTF-8" )+ "&err_value=" + error_value );
			}
			else
			{
				error = (String) results.get("error") ;	res.sendRedirect("../eMR/jsp/RecDiagnosiserror.jsp?function_id=EOC&Patient_Id="+Patient_Id+"&patient_class="+patient_class+"&Encounter_Id="+Encounter_Id+"&term_set_id="+code_set+"&Practitioner_Id="+Practitioner_Id+"&Locn_Code="+Locn_Code+"&relationship_id="+relationship_id+"&Locn_Type="+Locn_Type+"&sex="+sex+"&dob="+dob+"&error=" + java.net.URLEncoder.encode( error, "UTF-8" )+ "&err_value=" + error_value  );
			}
			if ( results != null) results.clear();
		} 
		catch ( Exception e ) 
		{
			e.printStackTrace();
		}
	}
	public static String checkForNull(String s)
    {
        return s != null && !s.equals("null") ? s : "";
    }
}
