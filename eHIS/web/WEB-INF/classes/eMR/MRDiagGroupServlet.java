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
import webbeans.eCommon.*;


import eCommon.SingleTabHandler.*;

public class MRDiagGroupServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	Properties p;
	String AllergyType;

	String longDesc ;
	String shortDesc ;
	String effectiveStatus ;
	String facilityId ;
	String client_ip_address ;
	String diag_group_code ="";
	String long_desc ="";
	String diag_code_scheme ="";
	String speciality_code ="";
	String facility_id ="";
	String practitioner_id ="";
	String group_type  ="";
	String locale="";
	Connection con ;

	HttpSession session;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		session = req.getSession(false);
		this.facilityId = (String) session.getValue( "facility_id" );
        this.p = (Properties) session.getValue( "jdbc" );
		this.client_ip_address = p.getProperty("client_ip_address");
		locale = p.getProperty("LOCALE");	

		try
		{			
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			String operation = req.getParameter("function_name");
			if(operation.equals("insert"))	insertDiagGroup(req, res);
			if(operation.equals("modify"))  modifyDiagGroup(req, res);
			if(operation.equals("delete"))  deleteDiagGroup(req, res);
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
			String operation = req.getParameter("function_name");
			if(operation.equals("insert"))	insertDiagGroup(req, res);
			if(operation.equals("modify"))  modifyDiagGroup(req, res);
			if(operation.equals("delete"))  deleteDiagGroup(req, res);
		}
		catch(Exception e)	{	/* out.println(e.toString()); */ 	e.printStackTrace(); }
	}


	private void modifyDiagGroup(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			group_type = 	req.getParameter("group_type");
			if(group_type == null) group_type="";
			diag_group_code = 	req.getParameter("diag_group_code");
			if(diag_group_code == null) diag_group_code="";

			long_desc = 				req.getParameter("long_desc");
			if(long_desc == null) long_desc="";
			diag_code_scheme = req.getParameter("diag_code_scheme");
			if(diag_code_scheme == null) diag_code_scheme="";
			speciality_code = 	req.getParameter("speciality_code");
			if(speciality_code == null) speciality_code="";
			facility_id = 			req.getParameter("facility_id");
			if(facility_id == null) facility_id="";
			practitioner_id = req.getParameter("practitioner_id");
			if(practitioner_id == null) practitioner_id="";

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
			tabdata.put("DIAG_GROUP_DESC",long_desc);
			tabdata.put("SPECIALITY_CODE",speciality_code);
			tabdata.put("FACILITY_ID",facility_id);
			tabdata.put("PRACTITIONER_ID",practitioner_id);
			tabdata.put("MODIFIED_BY_ID",modifiedById);
			tabdata.put("MODIFIED_DATE",modified_date);
			tabdata.put("MODIFIED_FACILITY_ID",modifiedFacilityId);
			tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );

			HashMap condflds=new HashMap();
			condflds.put("GROUP_TYPE",group_type);
			condflds.put("DIAG_GROUP_CODE",diag_group_code);
			condflds.put("DIAG_CODE_SCHEME",diag_code_scheme);

			String tableName = "MR_DIAG_GROUP";
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
			String error_value = "0" ;
			if ( inserted )
			{
				error_value = "1" ;
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) +"&err_value="+error_value);
			}
			else
			{
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) +"&err_value="+error_value);
			}
			if ( tabdata != null) tabdata.clear();
			if ( results != null) results.clear();
			if ( condflds != null) condflds.clear();
		}
		catch ( Exception e )
		{
			/* out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			out.println( AllergyType + " "+longDesc + " "+shortDesc + " "+ effectiveStatus ); */
			
				e.printStackTrace();
		}
	}

	private void insertDiagGroup(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			group_type = 	req.getParameter("group_type");
			if(group_type == null) group_type="";
			diag_group_code = 	req.getParameter("diag_group_code");
			if(diag_group_code == null) diag_group_code="";
			long_desc = 				req.getParameter("long_desc");
			if(long_desc == null) long_desc="";
			diag_code_scheme = req.getParameter("diag_code_scheme");
			if(diag_code_scheme == null) diag_code_scheme="";
			speciality_code = 	req.getParameter("speciality_code");
			if(speciality_code == null) speciality_code="";
			facility_id = 			req.getParameter("facility_id");
			if(facility_id == null) facility_id="";
			practitioner_id = req.getParameter("practitioner_id");
			if(practitioner_id == null) practitioner_id="";

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
			tabdata.put("GROUP_TYPE",group_type);
			tabdata.put("DIAG_GROUP_CODE",diag_group_code);
			tabdata.put("DIAG_GROUP_DESC",long_desc);
			tabdata.put("DIAG_CODE_SCHEME",diag_code_scheme);
			tabdata.put("SPECIALITY_CODE",speciality_code);
			tabdata.put("FACILITY_ID",facility_id);
			tabdata.put("PRACTITIONER_ID",practitioner_id);
			tabdata.put("ADDED_BY_ID",addedById);
			tabdata.put("ADDED_DATE",added_date);
			tabdata.put("ADDED_FACILITY_ID", facilityId);
			tabdata.put("ADDED_AT_WS_NO",addedAtWorkstation);
			tabdata.put("MODIFIED_BY_ID",modifiedById);
			tabdata.put("MODIFIED_DATE",modified_date);
			tabdata.put("MODIFIED_FACILITY_ID",modifiedFacilityId);
			tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );

			String dupflds[]={"GROUP_TYPE","DIAG_GROUP_CODE","DIAG_CODE_SCHEME"};

			String tableName = "MR_DIAG_GROUP";
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
			String error_value = "0" ;
			if ( inserted )
			{
				error_value = "1" ;
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
			}
			else
			{
				error = (String) results.get("error") ;
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error, "UTF-8" ) );
			}
			if ( tabdata != null) tabdata.clear();
			if ( results != null) results.clear();
		}
		catch ( Exception e )
		{
			/* out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			out.println( AllergyType + " "+longDesc + " "+shortDesc +" "+ effectiveStatus ); */
			e.printStackTrace();
		}
	}

	private void deleteDiagGroup(HttpServletRequest req, HttpServletResponse res)
	{
		PreparedStatement pslPrepStmt1 = null;
		PreparedStatement pslPrepStmt2 = null;
		try
		{
			diag_group_code = 	req.getParameter("diag_group_code");
			if(diag_group_code == null) diag_group_code="";

			group_type = 	req.getParameter("group_type");
			if(group_type== null) group_type="";

			diag_code_scheme = req.getParameter("diag_code_scheme");
			if(diag_code_scheme == null) diag_code_scheme="";
			con = ConnectionManager.getConnection(req);
			
			String delSql1="";
			if(group_type.equals("P")&&diag_code_scheme.equals("3"))		
				delSql1=" delete from MR_PROC_GROUP_DTL where DIAG_GROUP_CODE ='"+diag_group_code+"'";
			else			
				delSql1=" delete from MR_DIAG_GROUP_DTL where DIAG_GROUP_CODE ='"+diag_group_code+"'";
			
			String delSql2=" delete from mr_diag_group  where group_type = '"+group_type+"' and   DIAG_GROUP_CODE ='"+diag_group_code+"' and DIAG_CODE_SCHEME ='"+diag_code_scheme+"'";
			
			pslPrepStmt1 = con.prepareStatement(delSql1);
			pslPrepStmt2 = con.prepareStatement(delSql2);
			
			int ilStatus =0;
			ilStatus =pslPrepStmt1.executeUpdate();
			ilStatus=pslPrepStmt2.executeUpdate();

			String s20 = "";
			if(ilStatus >=1)
			{
				con.commit();
				Hashtable hashtable1 = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
				s20 = (String)hashtable1.get("message");
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(s20,"UTF-8") + "&err_value=1");
				if ( hashtable1 != null ) hashtable1.clear();
			}else
			{
				con.rollback();
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(s20,"UTF-8") + "&err_value=1");
			}
			if(pslPrepStmt1 != null)pslPrepStmt1.close();
			if(pslPrepStmt2 != null)pslPrepStmt2.close();
		}catch ( Exception e )
		{
			/* out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			out.println( AllergyType + " "+longDesc + " "+shortDesc +" "+ effectiveStatus ); */
			e.printStackTrace();
		}
		finally
		{
			ConnectionManager.returnConnection(con, req);
		}
	}
}
