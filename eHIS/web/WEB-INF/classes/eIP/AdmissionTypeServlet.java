/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIP;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import eCommon.SingleTabHandler.*;

public class AdmissionTypeServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	PrintWriter out;
	Properties p;

	String p_admission_type_code;
	//String setup_bl_dtls_in_ip_yn;
	String facilityId ;
	String client_ip_address ;
	String table_name;
	HttpSession session;

	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		session			  = req.getSession(false);
		this.p			  = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId   = (String) session.getValue( "facility_id" ) ;
		client_ip_address = p.getProperty("client_ip_address");
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		try
		{
			this.out = res.getWriter();
	
			String operation = req.getParameter("function_name");
				if(operation == null) operation="modify";

			if ( operation.equals("insert") )   insertAdmissionType(req);
			if ( operation.equals("modify"))    modifyAdmissionType(req);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		try
		{
			doPost(req,res);
		}
		catch(Exception e)	{	}
	}

	private void insertAdmissionType(HttpServletRequest req)
	{
		try
		{

			p_admission_type_code  = checkForNull(req.getParameter("admission_type_code"));

			String modifiedById			 = p.getProperty( "login_user" ) ;
			String modifiedFacilityId		 = facilityId;
			String modifiedAtWorkstation	 = client_ip_address;

			Timestamp added_date	= new Timestamp(System.currentTimeMillis() );

				HashMap tabdata=new HashMap();
				tabdata.put("admission_type_code",p_admission_type_code);
				tabdata.put("short_desc",checkForNull(req.getParameter("short_desc")));
				tabdata.put("long_desc",checkForNull(req.getParameter("long_desc")));
				tabdata.put("patient_class",checkForNull(req.getParameter("patient_class")));
				tabdata.put("eff_status",checkForNull(req.getParameter("eff_status"),"D"));
				tabdata.put("adm_type_ind",checkForNull(req.getParameter("admn_type_ind")));

				tabdata.put("added_by_id",modifiedById);
				tabdata.put("added_date",added_date);
				tabdata.put("added_facility_id", facilityId);
				tabdata.put("added_at_ws_no",modifiedAtWorkstation);
				tabdata.put("modified_by_id",modifiedById);
				tabdata.put("modified_date",added_date);
				tabdata.put("modified_facility_id",modifiedFacilityId);
				tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

				String dupflds[]={"admission_type_code"};

			

			table_name			= "ip_admission_type";
			boolean local_ejbs	= false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home   = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = dupflds;
			argArray[3] = table_name;

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = dupflds.getClass();
			paramArray[3] = table_name.getClass();
		
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			boolean inserted   = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error	   = (String) results.get("error") ;
			String error_value = "0" ;
				if ( inserted )
				{
						 error_value		   = "1" ;
							
							//Enhancements required
							/*if(setup_bl_dtls_in_ip_yn.equals("Y"))
							{
								HashMap tabdata_bl = new HashMap();
								tabdata_bl.put("admission_type_code",p_admission_type_code);
								tabdata_bl.put("rounding_fee_yn",checkForNull(req.getParameter("rounding_fee"),"N"));
								tabdata_bl.put("consumable_fee_yn",checkForNull(req.getParameter("consumable_fee"),"N"));
								tabdata_bl.put("adm_wkup_fee_yn",checkForNull(req.getParameter("work_up"),"N"));
								tabdata_bl.put("rdng_blng_serv_code",checkForNull(req.getParameter("billingservcode_rounding")));
								tabdata_bl.put("cons_blng_serv_code",checkForNull(req.getParameter("billingservcode_consumable")));
								tabdata_bl.put("wkup_blng_serv_code",checkForNull(req.getParameter("billingservcode_workup")));
								tabdata_bl.put("added_by_id",modifiedById);
								tabdata_bl.put("added_date",added_date);
								tabdata_bl.put("added_facility_id", facilityId);
								tabdata_bl.put("added_at_ws_no",modifiedAtWorkstation);
								tabdata_bl.put("modified_by_id",modifiedById);
								tabdata_bl.put("modified_date",added_date);
								tabdata_bl.put("modified_facility_id",modifiedFacilityId);
								tabdata_bl.put("modified_at_ws_no",modifiedAtWorkstation );


								table_name	= "bl_ip_admission_type";
								argArray[0] = p;
								argArray[1] = tabdata_bl;
								argArray[2] = dupflds;
								argArray[3] = table_name;
							
								paramArray[0] = p.getClass();
								paramArray[1] = tabdata_bl.getClass();
								paramArray[2] = dupflds.getClass();
								paramArray[3] = table_name.getClass();
							
								java.util.HashMap results_bl = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
								(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
										}*/
							}
		error = (String) results.get("error") ;
		out.println("<html><script>location.href =\"../eCommon/jsp/MstCodeError.jsp?err_num="+ java.net.URLEncoder.encode(error, "UTF-8")+" &err_value="+error_value+"\"</script><body class='message'></html>");

		tabdata.clear();
		results.clear();

	   }
	   catch ( Exception e )
	   {
			e.printStackTrace();
	   }
	}

private void modifyAdmissionType(HttpServletRequest req)
{
	try
	{
		p_admission_type_code	= checkForNull(req.getParameter("admission_type_code"));

		String modifiedById				= p.getProperty( "login_user" ) ;
		String addedDate				= dateFormat.format( new java.util.Date() ) ;
		String modifiedFacilityId		= facilityId;
		String modifiedAtWorkstation		= client_ip_address;
		java.sql.Date added_date1		= java.sql.Date.valueOf( addedDate ) ;

		java.sql.Date added_date	= new java.sql.Date(added_date1.parse(added_date1.toLocaleString())-(added_date1.getTimezoneOffset()*60*1000) ) ;

			HashMap tabdata=new HashMap();

			tabdata.put("short_desc",checkForNull(req.getParameter("short_desc")));
			tabdata.put("long_desc",checkForNull(req.getParameter("long_desc")));
			tabdata.put("patient_class",checkForNull(req.getParameter("patient_class")));
			tabdata.put("eff_status",checkForNull(req.getParameter("eff_status"),"D"));
			tabdata.put("adm_type_ind",checkForNull(req.getParameter("admn_type_ind")));
			tabdata.put("added_by_id",modifiedById);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",added_date);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

			HashMap condflds = new HashMap();
			condflds.put("admission_type_code",p_admission_type_code);

		  

		table_name			= "ip_admission_type";
		boolean local_ejbs	= false;
		
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			local_ejbs = true;

		Object home   = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		Object argArray[] = new Object[4];
		argArray[0] = p;
		argArray[1] = tabdata;
		argArray[2] = condflds;
		argArray[3] = table_name;

		Class [] paramArray = new Class[4];
		paramArray[0] = p.getClass();
		paramArray[1] = tabdata.getClass();
		paramArray[2] = condflds.getClass();
		paramArray[3] = table_name.getClass();

		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

		  boolean inserted	 = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
		  String error		 = (String) results.get("error") ;
		  String error_value = "0" ;

		  if ( inserted )
			{
			 error_value = "1" ;

			
			// Enhancements required
			 /*if(setup_bl_dtls_in_ip_yn.equals("Y"))
			 {
				  HashMap tabdata_bl = new HashMap();
				 ResultSet rs   = null;
				 Statement stmt	= null;
				 Connection con = null;

				 try
				 {
					 con				= ConnectionManager.getConnection(req);
					 stmt				= con.createStatement();
					 StringBuffer sql   = new StringBuffer(); 
					 sql.append("select * from bl_ip_admission_type where admission_type_code ='"+p_admission_type_code+"'");
					 rs=stmt.executeQuery(sql.toString());

					 if(rs!=null )
					 {
						if(rs.next())
						{
							tabdata_bl.put("rounding_fee_yn",checkForNull(req.getParameter("rounding_fee"),"N"));
							tabdata_bl.put("consumable_fee_yn",checkForNull(req.getParameter("consumable_fee"),"N"));
							tabdata_bl.put("adm_wkup_fee_yn",checkForNull(req.getParameter("work_up"),"N"));
							tabdata_bl.put("rdng_blng_serv_code",checkForNull(req.getParameter("billingservcode_rounding")));
							tabdata_bl.put("cons_blng_serv_code",checkForNull(req.getParameter("billingservcode_consumable")));
							tabdata_bl.put("wkup_blng_serv_code",checkForNull(req.getParameter("billingservcode_workup")));
							tabdata_bl.put("modified_by_id",modifiedById);
							tabdata_bl.put("modified_date",added_date);
							tabdata_bl.put("modified_facility_id",modifiedFacilityId);
							tabdata_bl.put("modified_at_ws_no",modifiedAtWorkstation );

							table_name	= "bl_ip_admission_type";
							argArray[0] = p;
							argArray[1] = tabdata_bl;
							argArray[2] = condflds;
							argArray[3] = table_name;

							paramArray[0] = p.getClass();
							paramArray[1] = tabdata_bl.getClass();
							paramArray[2] = condflds.getClass();
							paramArray[3] = table_name.getClass();

							java.util.HashMap results_bl_update = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
							(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

						}
						else
						{
							tabdata_bl.put("admission_type_code",p_admission_type_code);
							tabdata_bl.put("rounding_fee_yn",checkForNull(req.getParameter("rounding_fee"),"N"));
							tabdata_bl.put("consumable_fee_yn",checkForNull(req.getParameter("consumable_fee"),"N"));
							tabdata_bl.put("adm_wkup_fee_yn",checkForNull(req.getParameter("work_up"),"N"));
							tabdata_bl.put("rdng_blng_serv_code",checkForNull(req.getParameter("billingservcode_rounding")));
							tabdata_bl.put("cons_blng_serv_code",checkForNull(req.getParameter("billingservcode_consumable")));
							tabdata_bl.put("wkup_blng_serv_code",checkForNull(req.getParameter("billingservcode_workup")));
							tabdata_bl.put("added_by_id",modifiedById);
							tabdata_bl.put("added_date",added_date);
							tabdata_bl.put("added_facility_id", facilityId);
							tabdata_bl.put("added_at_ws_no",modifiedAtWorkstation);
							tabdata_bl.put("modified_by_id",modifiedById);
							tabdata_bl.put("modified_date",added_date);
							tabdata_bl.put("modified_facility_id",modifiedFacilityId);
							tabdata_bl.put("modified_at_ws_no",modifiedAtWorkstation );

							String dupflds[]={"admission_type_code"};

							table_name	= "bl_ip_admission_type";
							argArray[0] = p;
							argArray[1] = tabdata_bl;
							argArray[2] = dupflds;
							argArray[3] = table_name;

							paramArray[0] = p.getClass();
							paramArray[1] = tabdata_bl.getClass();
							paramArray[2] = dupflds.getClass();
							paramArray[3] = table_name.getClass();

							java.util.HashMap results_bl_insert1 = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
							(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);							

							//boolean inserted1 = ( ((Boolean) results_bl_insert1.get( "status" )).booleanValue() ) ;
						}
					 }
				 if(stmt!=null)		stmt.close();
				 if(rs!=null)		rs.close();
				 }
				 catch(Exception e)
					 {
						out.print(e);
					 }

				 finally
				 {
					 ConnectionManager.returnConnection(con,req);
				 }
			}*/
			}
			else
			{
			 error = (String) results.get("error") ;
			}
	error = (String) results.get("error") ;
	out.println("<html><script>location.href =\"../eCommon/jsp/MstCodeError.jsp?err_num="+ java.net.URLEncoder.encode(error, "UTF-8")+" &err_value="+error_value+"\"</script><body class='message'></html>");

		tabdata.clear();
		results.clear();
		condflds.clear();

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
