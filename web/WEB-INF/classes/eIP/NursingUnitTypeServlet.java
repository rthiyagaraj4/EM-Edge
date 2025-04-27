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
import java.util.Properties;
import java.util.HashMap;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;

import eCommon.SingleTabHandler.*;

public class NursingUnitTypeServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{			 
	PrintWriter out;
	Properties	p;
	String sStyle;
	String		longDesc ;
	String		shortDesc ;
	String		effectiveStatus ;
	String		facilityId ;
	String		client_ip_address ;

	String		nursingunittypecode;
	String		depositapplyn ;
	String		addldepyn;
	Connection	con			= null;
	String		addedById	= "";
	Timestamp	added_date	= new Timestamp(System.currentTimeMillis() );
	HttpSession session;
	HashMap		tabdata		= new HashMap();

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		this.out = res.getWriter();
		res.setContentType("text/html;charset=UTF-8");
		out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link><script language='javascript' src='/eCIS/mp/js/Occupation.js'></script></head><frameset rows='60,*,50'><frame name='commontoolbarFrame' src='../eCommon/jsp/commonToolbar.jsp?function_name=Occupation' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		session					= req.getSession(false);
		this.p					= (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId			= (String) session.getValue( "facility_id" ) ;
		sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		client_ip_address		= p.getProperty("client_ip_address");
		addedById				= p.getProperty( "login_user" ) ;
		nursingunittypecode		= checkForNull(req.getParameter("Type"));
		longDesc				= checkForNull(req.getParameter("long_desc"));
		shortDesc				= checkForNull(req.getParameter("short_desc"));
		depositapplyn			= checkForNull(req.getParameter("deposit_appl_yn"));
		addldepyn				= checkForNull(req.getParameter("addl_dep_yn"));
		effectiveStatus			= checkForNull(req.getParameter("eff_status"));

		if (depositapplyn.equals(""))			depositapplyn="N";
		if (addldepyn.equals(""))				addldepyn="N";
		if (effectiveStatus.equals(""))			effectiveStatus="D";
//		if (setup_bl_dtls_in_ip_yn.equals(""))	setup_bl_dtls_in_ip_yn="N";
		try
		{
			String operation = req.getParameter("function");

			if ( operation.equals("insert") )   insertNurseType(res);
			if ( operation.equals("modify"))    modifyNurseType(req, res);
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

	private void modifyNurseType(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{	
			con		= ConnectionManager.getConnection(req);
			tabdata.put("nursing_unit_type_code",nursingunittypecode);
			tabdata.put("long_desc",longDesc);
			tabdata.put("short_desc",shortDesc);
			tabdata.put("eff_status",effectiveStatus);
			tabdata.put("modified_by_id",addedById);
			tabdata.put("modified_date",added_date);
			tabdata.put("modified_facility_id",facilityId);
			tabdata.put("modified_at_ws_no",client_ip_address );

			HashMap condflds	=	new HashMap();
			condflds.put("nursing_unit_type_code",nursingunittypecode);

			String  table_name	=	"ip_nursing_unit_type";
			boolean local_ejbs = false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

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

			boolean inserted	= (((Boolean) results.get( "status" )).booleanValue() ) ;
			String	error		= (String) results.get("error") ;
			String	error_value	= "0" ;

			if ( inserted )
			{
				 error_value		= "1" ;
				 //Enhancements required
				 /*if(setup_bl_dtls_in_ip_yn.equals("Y"))
				 {
					 HashMap tabdata_bl	= new HashMap();
					 ResultSet rs		= null;
					 Statement stmt		= null;
					 stmt				= con.createStatement();
					 try
					 {
						StringBuffer sql = new StringBuffer();
						 sql.append("select * from bl_ip_nursing_unit_type where nursing_unit_type_code ='"+nursingunittypecode+"' ");
						 rs=stmt.executeQuery(sql.toString());
						 if(rs!=null )
						 {
							if(rs.next())
							{
								tabdata_bl.put("deposit_appl_yn",depositapplyn);
								tabdata_bl.put("addl_dep_yn",addldepyn);
								tabdata_bl.put("modified_by_id",addedById);
								tabdata_bl.put("modified_date",added_date);
								tabdata_bl.put("modified_facility_id",facilityId);
								tabdata_bl.put("modified_at_ws_no",client_ip_address );

								table_name	= "bl_ip_nursing_unit_type";
								argArray[0] = p;
								argArray[1] = tabdata_bl;
								argArray[2] = condflds;
								argArray[3] = table_name;

								paramArray[0] = p.getClass();
								paramArray[1] = tabdata_bl.getClass();
								paramArray[2] = condflds.getClass();
								paramArray[3] = table_name.getClass();

								final java.util.HashMap results_bl_update = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
								(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
							}
							else
							{
								tabdata_bl.put("nursing_unit_type_code",nursingunittypecode);
								tabdata_bl.put("deposit_appl_yn",depositapplyn);
								tabdata_bl.put("addl_dep_yn",addldepyn);
								tabdata_bl.put("added_by_id",addedById);
								tabdata_bl.put("added_date",added_date);
								tabdata_bl.put("added_facility_id", facilityId);
								tabdata_bl.put("added_at_ws_no",client_ip_address);
								tabdata_bl.put("modified_by_id",addedById);
								tabdata_bl.put("modified_date",added_date);
								tabdata_bl.put("modified_facility_id",facilityId);
								tabdata_bl.put("modified_at_ws_no",client_ip_address );

								String dupflds[]={"nursing_unit_type_code"};
								
								table_name = "bl_ip_nursing_unit_type";
								
								argArray[0] = p;
								argArray[1] = tabdata_bl;
								argArray[2] = dupflds;
								argArray[3] = table_name;
								
								paramArray[0] = p.getClass();
								paramArray[1] = tabdata_bl.getClass();
								paramArray[2] = dupflds.getClass();
								paramArray[3] = table_name.getClass();

								final java.util.HashMap results_bl_insert1 = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
								(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
							}
						}
					}
					catch(Exception e)
					{
						out.println(e.toString());
					}
					finally
					{
						if(stmt!=null)		stmt.close();
						if(rs!=null)		rs.close();
					}
				}*/

				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
			}
			else
			{
				error = (String) results.get("error") ;
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error, "UTF-8" ) );
			}
	
			results.clear();
			condflds.clear();
			tabdata.clear();

		}catch ( Exception e )
		{
			e.printStackTrace();
		}
		finally
		{
			if(con!= null)
			{
				ConnectionManager.returnConnection(con,req);
			}
		}
	}

	private void insertNurseType(HttpServletResponse res)
	{
		try
		{
			tabdata = new HashMap();
			tabdata.put("nursing_unit_type_code",nursingunittypecode);
			tabdata.put("long_desc",longDesc);
			tabdata.put("short_desc",shortDesc);
			tabdata.put("eff_status",effectiveStatus);
			tabdata.put("added_by_id",addedById);
			tabdata.put("added_date",added_date);
			tabdata.put("added_facility_id", facilityId);
			tabdata.put("added_at_ws_no",client_ip_address);
			tabdata.put("modified_by_id",addedById);
			tabdata.put("modified_date",added_date);
			tabdata.put("modified_facility_id",facilityId);
			tabdata.put("modified_at_ws_no",client_ip_address );

			String dupflds[]={"nursing_unit_type_code"};
			String table_name	= "ip_nursing_unit_type";
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

			boolean inserted	= (((Boolean) results.get( "status" )).booleanValue()) ;
			String error		= (String) results.get("error") ;
			String error_value	= "0" ;

			if ( inserted )
			{
				error_value = "1" ;
				//Enhancements required
				/*if(setup_bl_dtls_in_ip_yn.equals("Y"))
				{
					HashMap tabdata_bl=new HashMap();

					tabdata_bl.put("nursing_unit_type_code",nursingunittypecode);
					tabdata_bl.put("deposit_appl_yn",depositapplyn);
					tabdata_bl.put("addl_dep_yn",addldepyn);
					tabdata_bl.put("added_by_id",addedById);
					tabdata_bl.put("added_date",added_date);
					tabdata_bl.put("added_facility_id", facilityId);
					tabdata_bl.put("added_at_ws_no",client_ip_address);
					tabdata_bl.put("modified_by_id",addedById);
					tabdata_bl.put("modified_date",added_date);
					tabdata_bl.put("modified_facility_id",facilityId);
					tabdata_bl.put("modified_at_ws_no",client_ip_address );

					table_name = "bl_ip_nursing_unit_type";
					argArray[0] = p;
					argArray[1] = tabdata;
					argArray[2] = dupflds;
					argArray[3] = table_name;

					paramArray[0] = p.getClass();
					paramArray[1] = tabdata.getClass();
					paramArray[2] = dupflds.getClass();
					paramArray[3] = table_name.getClass();

					java.util.HashMap results_bl_insert = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
					(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				}*/
				 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
			}
			else
			{
				 error = (String) results.get("error") ;
				 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error, "UTF-8" ) );
			}
		
			results.clear();
			tabdata.clear();
		}catch ( Exception e )
		{
			e.printStackTrace();

		}
	}
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
}
