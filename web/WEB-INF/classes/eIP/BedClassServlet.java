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
import javax.rmi.*;
import webbeans.eCommon.*;

import eCommon.SingleTabHandler.*;

public class BedClassServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	PrintWriter out;
	java.util.Properties p;

	String bedclasscode;

	String table_name;
	int i  = 0;
	Integer noofbeds = new Integer(i);

	String client_ip_address ;
    String facilityId;
	HttpSession session;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		session				 = req.getSession(false);
		this.p				 = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId		 = (String) session.getValue( "facility_id" ) ;
		client_ip_address	 = p.getProperty("client_ip_address");

		try
		{
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out		 = res.getWriter();
			String operation = checkForNull(req.getParameter("function_name"));
			if (operation.equals("insert"))	insertBedClass(req, res);
			if (operation.equals("modify"))	modifyBedClass(req, res);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private void insertBedClass(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			bedclasscode			= checkForNull(req.getParameter("bed_class_code"));
		//	depositamountnormal		= checkForNull(req.getParameter("deposit_amt_normal"),"0");
		//	depositchargesurgery	= checkForNull(req.getParameter("deposit_charge_surgery"),"0");
		//	setup_bl_dtls_in_ip_yn	= checkForNull(req.getParameter("setup_bl_dtls_in_ip_yn"));

		//	Double depamt				 = new Double(depositamountnormal);
		//	Double depchg				 = new Double(depositchargesurgery);

			String modifiedById			 = p.getProperty( "login_user" ) ;
			String modifiedFacilityId	 = facilityId;
			String addedAtWorkstation	 = client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			Timestamp added_date		 = new Timestamp(System.currentTimeMillis() );

			HashMap tabdata=new HashMap();
			tabdata.put("bed_class_code",bedclasscode);
			tabdata.put("long_desc",checkForNull(req.getParameter("long_desc")));
			tabdata.put("short_desc",checkForNull(req.getParameter("short_desc")));
			tabdata.put("no_of_beds",noofbeds); 

			tabdata.put("ALLOW_BED_SWAP_YN",checkForNull(req.getParameter("ALLOW_BED_SWAP_YN"),"N"));
			tabdata.put("eff_status",checkForNull(req.getParameter("eff_status"),"D"));
			tabdata.put("added_by_id",modifiedById);
			tabdata.put("added_date",added_date);
			tabdata.put("added_facility_id", facilityId);
			tabdata.put("added_at_ws_no",addedAtWorkstation);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",added_date);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

			String dupflds[]={"bed_class_code"};

			table_name		   = "ip_bed_class";
			boolean local_ejbs = false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
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

			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			if ( inserted )
			{
				 error_value = "1" ;
				//Enhancements required for this
				/* if(setup_bl_dtls_in_ip_yn.equals("Y"))
				 {
					HashMap tabdata_bl=new HashMap();
					tabdata_bl.put("bed_class_code",bedclasscode);
					tabdata_bl.put("deposit_amount_normal",depamt);
					tabdata_bl.put("percent_amt_ind_surgery",checkForNull(req.getParameter("percent_amt_ind_surgery")));
					tabdata_bl.put("deposit_charge_surgery",depchg);
					tabdata_bl.put("added_by_id",modifiedById);
					tabdata_bl.put("added_date",added_date);
					tabdata_bl.put("added_facility_id", facilityId);
					tabdata_bl.put("added_at_ws_no",addedAtWorkstation);
					tabdata_bl.put("modified_by_id",modifiedById);
					tabdata_bl.put("modified_date",added_date);
					tabdata_bl.put("modified_facility_id",modifiedFacilityId);
					tabdata_bl.put("modified_at_ws_no",modifiedAtWorkstation );

					table_name	= "bl_ip_bed_class";
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
			else
			{
				 error = (String) results.get("error") ;
			}

			error = (String) results.get("error") ;

			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
			tabdata.clear();
			results.clear();
		}
		catch ( Exception e )
		{
			e.printStackTrace();

		}
	}

	private void modifyBedClass(HttpServletRequest req, HttpServletResponse res)
	{
		Connection con = null;
		try
		{
			con						= ConnectionManager.getConnection(req);
			bedclasscode			= checkForNull(req.getParameter("bed_class_code"));
		/*	depositamountnormal		= checkForNull(req.getParameter("deposit_amt_normal"),"0");
			setup_bl_dtls_in_ip_yn  = checkForNull(req.getParameter("setup_bl_dtls_in_ip_yn"));
			depositchargesurgery	= checkForNull(req.getParameter("deposit_charge_surgery"),"0");

			Double depamt				 = new Double(depositamountnormal);
			Double depchg				 = new Double(depositchargesurgery);*/
			String modifiedById			 = p.getProperty( "login_user" ) ;
			String modifiedFacilityId	 = facilityId;
			String addedAtWorkstation	 = client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			Timestamp added_date		 = new Timestamp(System.currentTimeMillis() );

			HashMap tabdata				 = new HashMap();

			tabdata.put("long_desc",checkForNull(req.getParameter("long_desc")));
			tabdata.put("short_desc",checkForNull(req.getParameter("short_desc")));
			tabdata.put("ALLOW_BED_SWAP_YN",checkForNull(req.getParameter("ALLOW_BED_SWAP_YN"),"N"));

			tabdata.put("eff_status",checkForNull(req.getParameter("eff_status"),"D"));

			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",added_date);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

			HashMap condflds   = new HashMap();
			condflds.put("bed_class_code",bedclasscode);

			table_name		   = "ip_bed_class";
			boolean local_ejbs = false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home		   = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj	   = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[]  = new Object[4];
			argArray[0]		   = p;
			argArray[1]		   = tabdata;
			argArray[2]		   = condflds;
			argArray[3]		   = table_name;

			Class [] paramArray= new Class[4];
			paramArray[0]	   = p.getClass();
			paramArray[1]	   = tabdata.getClass();
			paramArray[2]	   = condflds.getClass();
			paramArray[3]	   = table_name.getClass();

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			boolean inserted   = (((Boolean) results.get("status")).booleanValue());

			String error	   = (String) results.get("error") ;
			String error_value = "0" ;

			if ( inserted )
			{
				error_value	         = "1" ;
				
				// Enhancements required
				/*if(setup_bl_dtls_in_ip_yn.equals("Y"))
				{
					HashMap tabdata_bl	 = new HashMap();
				ResultSet rs         = null;
				Statement stmt	     = null;
				stmt				 = con.createStatement();
				 try
				 {
					 String sql = "select * from bl_ip_bed_class where bed_class_code ='"+bedclasscode+"' ";
					 out.println("inside try");
					 rs=stmt.executeQuery(sql);
					 if(rs!=null )
					 {
						if(rs.next())
						{
							 tabdata_bl.put("deposit_amount_normal",depamt);
							 tabdata_bl.put("percent_amt_ind_surgery",checkForNull(req.getParameter("percent_amt_ind_surgery")));
							 tabdata_bl.put("deposit_charge_surgery",depchg);
							 tabdata_bl.put("modified_by_id",modifiedById);
							 tabdata_bl.put("modified_date",added_date);
							 tabdata_bl.put("modified_facility_id",modifiedFacilityId);
							 tabdata_bl.put("modified_at_ws_no",modifiedAtWorkstation );

							table_name    = "bl_ip_bed_class";
							argArray[0]   = p;
							argArray[1]   = tabdata_bl;
							argArray[2]   = condflds;
							argArray[3]   = table_name;

							paramArray[0] = p.getClass();
							paramArray[1] = tabdata_bl.getClass();
							paramArray[2] = condflds.getClass();
							paramArray[3] = table_name.getClass();

							java.util.HashMap results_bl = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
							(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

						}
						else
						{
							out.println("inside insert table");
						 tabdata_bl.put("bed_class_code",bedclasscode);
						 tabdata_bl.put("deposit_amount_normal",depamt);
						 tabdata_bl.put("percent_amt_ind_surgery",checkForNull(req.getParameter("percent_amt_ind_surgery")));
						 tabdata_bl.put("deposit_charge_surgery",depchg);
						 tabdata_bl.put("added_by_id",modifiedById);
						 tabdata_bl.put("added_date",added_date);
						 tabdata_bl.put("added_facility_id", facilityId);
						 tabdata_bl.put("added_at_ws_no",addedAtWorkstation);
						 tabdata_bl.put("modified_by_id",modifiedById);
						 tabdata_bl.put("modified_date",added_date);
						 tabdata_bl.put("modified_facility_id",modifiedFacilityId);
						 tabdata_bl.put("modified_at_ws_no",modifiedAtWorkstation );

						 String dupflds[]={"bed_class_code"};

						table_name	  = "bl_ip_bed_class";
						argArray[0]   = p;
						argArray[1]   = tabdata_bl;
						argArray[2]   = dupflds;
						argArray[3]   = table_name;
					
						paramArray[0] = p.getClass();
						paramArray[1] = tabdata_bl.getClass();
						paramArray[2] = dupflds.getClass();
						paramArray[3] = table_name.getClass();
			
						java.util.HashMap results_bl = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
						(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

						}
					 }
				 }
				 catch(Exception e){}

				 finally
				 {
					 if(stmt!=null)		stmt.close();
					 if(rs!=null)		rs.close();
				 }
			   }*/
			}
			else
			{
				error = (String) results.get("error") ;
			}
        	error = (String) results.get("error") ;
    	 	res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
			tabdata.clear();
			results.clear();
			condflds.clear();
		}//E.o.Try
		catch ( Exception e )
		{
			e.printStackTrace();
		}

		finally
		{
			 ConnectionManager.returnConnection(con,req);
		}
	}//E.o.Modify

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
}//E.o.class
