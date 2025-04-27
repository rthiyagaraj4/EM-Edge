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

public class ICDCodeServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	Properties p;
	String client_ip_address ;
	String long_title;
	String gender_ind;
	String diag_srl_no;
	String code_ind;
	String code_type;
	String age_spec;
	String sensitive;
	String notifiable;
	String facilityId;
	String diag_code_scheme_desc;
	String diag_code_scheme;
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
			modifyICDCode(req);
		}
		catch(Exception e)
		{
		//	out.println(e.toString());
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
			this.out = res.getWriter();
			modifyICDCode(req);
		}
		catch(Exception e)	{	/* out.println(e.toString()); */ e.printStackTrace();	}
	}


	private void modifyICDCode(HttpServletRequest req)
	{
		try
		{
			long_title=req.getParameter("long_title");
			diag_srl_no=req.getParameter("diag_srl_no");
			code_ind=req.getParameter("code_ind");
			gender_ind=req.getParameter("gender_spec");
			code_type=req.getParameter("ctype");
			age_spec=req.getParameter("age_spec");
			sensitive=req.getParameter("sensitive");
			notifiable=req.getParameter("notifiable");
			diag_code_scheme_desc=req.getParameter("diag_desc");

			
			if(long_title == null || long_title.equals("null")) long_title="";
			if(sensitive == null || sensitive.equals("null")) sensitive="";
			if(notifiable == null || notifiable.equals("null")) notifiable="";
			if(diag_code_scheme_desc == null || diag_code_scheme_desc.equals("null")) diag_code_scheme_desc="";
			
			if(code_type.equals("D") && diag_code_scheme_desc.equals("ICD10"))
				diag_code_scheme = "1";
			else if(code_type.equals("D") && diag_code_scheme_desc.equals("ICD9-CM"))
				diag_code_scheme = "2";
			else if(code_type.equals("O") && diag_code_scheme_desc.equals("ICD10"))
				diag_code_scheme = "1";
			else if(code_type.equals("O") && diag_code_scheme_desc.equals("ICD9-CM"))
				diag_code_scheme = "4";
			

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
			tabdata.put("long_desc",long_title);
			tabdata.put("code_indicator",code_ind);
			tabdata.put("record_type",code_type);
			tabdata.put("gender_spec_ind",gender_ind);
			tabdata.put("age_spec_ind",age_spec);
			tabdata.put("sensitive_yn",sensitive);
			tabdata.put("notifiable_yn",notifiable);
			tabdata.put("diag_code_scheme",diag_code_scheme);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",modified_date);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
			


			HashMap condflds=new HashMap();
			condflds.put("diag_srl_no",diag_srl_no);


			String tableName = "MR_ICD_CODE";
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
			if ( inserted )
			{
				out.println("<script>alert('"+error.substring(0,error.length()-4)+"');parent.window.close();</script>");
			}
			else
			{
				 out.println("<script>alert('"+error.substring(0,error.length()-4)+"');</script>");
			}
			if ( tabdata != null) tabdata.clear();
			if ( results != null) results.clear();
			if ( condflds != null) condflds.clear();
		}
		catch ( Exception e )
		{
			//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
		
		e.printStackTrace();
		}
	}

}
