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

public class TransferTypeServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	PrintWriter out;
	java.util.Properties p;
	String p_transfer_type_code;
	String facilityId ;
	String sStyle;
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
		try
		{
			this.out = res.getWriter();
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link><script language='javascript' src='/eCIS/ip/js/NursUnitRoom.js'></script></head><frameset rows='60,*,50'><frame name='commontoolbarFrame' src='../eCommon/jsp/commonToolbar.jsp?function_name=Rooms For Nursing Unit' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
		}
		catch(Exception e)	{	e.printStackTrace();	}

		session			= req.getSession(false);
		this.p			= (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		client_ip_address = p.getProperty("client_ip_address");

		try
		{
			String operation = req.getParameter("function_name");

			if ( operation.equals("insert") )   insertTransferType(req, res);
			if ( operation.equals("modify"))    modifyTransferType(req, res);
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
		catch(Exception e)	
		{	
			e.printStackTrace();
		}
	}

	private void insertTransferType(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			p_transfer_type_code	= checkForNull(req.getParameter("transfer_type_code"));
//			setup_bl_dtls_in_ip_yn = checkForDefault(req.getParameter("setup_bl_dtls_in_ip_yn"),"N");

			String addedById = p.getProperty( "login_user" ) ;
			String modifiedById = addedById ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			Timestamp added_date = new Timestamp(System.currentTimeMillis() );
			Timestamp modified_date = new Timestamp(System.currentTimeMillis() );

			HashMap tabdata=new HashMap();
			tabdata.put("transfer_type_code",p_transfer_type_code);
			tabdata.put("short_desc",checkForNull(req.getParameter("short_desc")));
			tabdata.put("long_desc",checkForNull(req.getParameter("long_desc")));
			tabdata.put("eff_status",checkForDefault(req.getParameter("eff_status"),"D"));

			tabdata.put("informed_dtls_mand_yn",checkForDefault(req.getParameter("informd_dtls_yn"),"N"));//Added by Thamizh selvi on 5th May 2017 for ML-MMOH-CRF-0617

			tabdata.put("blocking_type_code",checkForNull(req.getParameter("blocking_type")));
			tabdata.put("added_by_id",addedById);
			tabdata.put("added_date",added_date);
			tabdata.put("added_facility_id", facilityId);
			tabdata.put("added_at_ws_no",addedAtWorkstation);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",modified_date);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
			String dupflds[]={"transfer_type_code"};

			table_name			= "ip_transfer_type";
			boolean local_ejbs	= false;
			
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
			results.clear();
			String error_value = "0" ;
			if ( inserted )
			{
				 error_value = "1" ;
				 // Enhancements required
				  /*if(setup_bl_dtls_in_ip_yn.equals("Y"))
					 {
						HashMap tabdata_bl=new HashMap();
						tabdata_bl.put("transfer_type_code",p_transfer_type_code);
						tabdata_bl.put("charge_yn",checkForDefault(req.getParameter("charge"),"N"));
						tabdata_bl.put("added_by_id",addedById);
						tabdata_bl.put("added_date",added_date);
						tabdata_bl.put("added_facility_id", facilityId);
						tabdata_bl.put("added_at_ws_no",addedAtWorkstation);
						tabdata_bl.put("modified_by_id",modifiedById);
						tabdata_bl.put("modified_date",modified_date);
						tabdata_bl.put("modified_facility_id",modifiedFacilityId);
						tabdata_bl.put("modified_at_ws_no",modifiedAtWorkstation );
						tabdata.put("blocking_type_code",checkForNull(req.getParameter("hid_block_type")));
						
						table_name    = "bl_ip_transfer_type";
						argArray[0]   = p;
						argArray[1]   = tabdata_bl;
						argArray[2]   = dupflds;
						argArray[3]	  = table_name;
					
						paramArray[0] = p.getClass();
						paramArray[1] = tabdata_bl.getClass();
						paramArray[2] = dupflds.getClass();
						paramArray[3] = table_name.getClass();
					
						java.util.HashMap results_bl = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
						(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
						
						}*/
				}
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
	   
		   tabdata.clear();
	   }catch ( Exception e )
	   {
			e.printStackTrace();
	   }
	}

private void modifyTransferType(HttpServletRequest req, HttpServletResponse res)
{
//	Connection con = null;
	try
	{
//		con = ConnectionManager.getConnection(req);
		p_transfer_type_code = checkForNull(req.getParameter("transfer_type_code"));
//		setup_bl_dtls_in_ip_yn = checkForDefault(req.getParameter("setup_bl_dtls_in_ip_yn"),"N");

		String addedById			 = p.getProperty( "login_user" ) ;
	//	String addedDate			 = dateFormat.format( new java.util.Date() ) ;
		String modifiedById			 = addedById ;
		String modifiedDate			 = dateFormat.format( new java.util.Date() ) ;
		String addedFacilityId		 = facilityId;
		String modifiedFacilityId	 = addedFacilityId ;
		String addedAtWorkstation    = client_ip_address;
		String modifiedAtWorkstation = addedAtWorkstation ;

	//	java.sql.Date added_date1	 = java.sql.Date.valueOf( addedDate ) ;
		java.sql.Date modified_date1 = java.sql.Date.valueOf(modifiedDate ) ;

	//	java.sql.Date added_date	 = new java.sql.Date(added_date1.parse(added_date1.toLocaleString())-(added_date1.getTimezoneOffset()*60*1000) ) ;
		java.sql.Date modified_date  = new java.sql.Date(modified_date1.parse(modified_date1.toLocaleString())-(modified_date1.getTimezoneOffset()*60*1000) ) ;

		HashMap tabdata=new HashMap();
		tabdata.put("short_desc",checkForNull(req.getParameter("short_desc")));
		tabdata.put("long_desc",checkForNull(req.getParameter("long_desc")));
		tabdata.put("eff_status",checkForDefault(req.getParameter("eff_status"),"D"));

		tabdata.put("informed_dtls_mand_yn",checkForDefault(req.getParameter("informd_dtls_yn"),"N")); //Added by Thamizh selvi on 5th May 2017 for ML-MMOH-CRF-0617

		tabdata.put("blocking_type_code",checkForNull(req.getParameter("blocking_type")));
		tabdata.put("added_by_id",addedById);
		tabdata.put("modified_by_id",modifiedById);
		tabdata.put("modified_date",modified_date);
		tabdata.put("modified_facility_id",modifiedFacilityId);
		tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

		HashMap condflds=new HashMap();
		condflds.put("transfer_type_code",p_transfer_type_code);
			
		table_name			= "ip_transfer_type";
		boolean local_ejbs	= false;
		
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
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

		boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
		String error = (String) results.get("error") ;
		String error_value = "0" ;

		if(inserted)
		{
			error_value		= "1" ;
		 
		//Enhancements Required
		 /*if(setup_bl_dtls_in_ip_yn.equals("Y"))
		 {
			HashMap tabdata_bl = new HashMap();
		 stmt				= con.createStatement();
			 try
			 {
				 StringBuffer sql   = new StringBuffer(); 
				 sql.append("select * from bl_ip_transfer_type where transfer_type_code ='"+p_transfer_type_code+"' ");
				 out.println("inside try");
				 rs=stmt.executeQuery(sql.toString());
				 if(rs!=null )
				 {
					if(rs.next())
					{
					tabdata_bl.put("charge_yn",checkForDefault(req.getParameter("charge"),"N"));
					tabdata_bl.put("modified_by_id",modifiedById);
					tabdata_bl.put("modified_date",modified_date);
					tabdata_bl.put("modified_facility_id",modifiedFacilityId);
					tabdata_bl.put("modified_at_ws_no",modifiedAtWorkstation );
					table_name	= "bl_ip_transfer_type";
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

					tabdata_bl.put("transfer_type_code",p_transfer_type_code);
					tabdata_bl.put("charge_yn",checkForDefault(req.getParameter("charge"),"N"));
					tabdata_bl.put("added_by_id",addedById);
					tabdata_bl.put("added_date",added_date);
					tabdata_bl.put("added_facility_id", facilityId);
					tabdata_bl.put("added_at_ws_no",addedAtWorkstation);
					tabdata_bl.put("modified_by_id",modifiedById);
					tabdata_bl.put("modified_date",modified_date);
					tabdata_bl.put("modified_facility_id",modifiedFacilityId);
					tabdata_bl.put("modified_at_ws_no",modifiedAtWorkstation );
					tabdata_bl.put("blocking_type_code",checkForNull(req.getParameter("hid_block_type")));

					String dupflds[]={"transfer_type_code"};

					table_name	= "bl_ip_transfer_type";
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

					}
				 }
			 }
			 catch(Exception e){out.print("Error"+e);}

			 finally
			 {
				 if(stmt!=null)		stmt.close();
				 if(rs!=null)		rs.close();
			 }
		}*/

			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );

		}
		else
		{
			 error = (String) results.get("error") ;
			 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error, "UTF-8" ) );
		}
	
		tabdata.clear();
		condflds.clear();
		results.clear();

	}catch ( Exception e )
	{
		e.printStackTrace();
	}
	finally
	{
//		ConnectionManager.returnConnection(con,req);
	}

}//E.o.Modify

	// Added by Sridhar R on 2 MARCH 2005.. thesse functions will chk for null value & return empty String...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}

	public static String checkForDefault(String inputString, String Default)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? Default : inputString);
	}

}
