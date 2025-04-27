/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eFM;

import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import javax.rmi.*;
import javax.naming.*;
import javax.ejb.*;
import eFM.FMAssignStorageLocation.*;
//import eFM.FMUtilities;
import webbeans.eCommon.*;

public class FMAssignStorageLocationServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	String locale			= "" ;

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,java.io.IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		java.io.PrintWriter out		= response.getWriter();

		HttpSession session = request.getSession(false);

		Properties p		= (Properties) session.getValue( "jdbc" ) ;
		locale = p.getProperty("LOCALE");
		String client_ip_address	=  p.getProperty("client_ip_address");
		
		Connection con				=	null;
		PreparedStatement pstmt		=	null;
		ResultSet rs				=	null;

		HashMap	htLocn		= new HashMap();		
		HashMap htRecord	= new HashMap();
	
		String locn_identity = "",narration_code = "",holder_name = "";
		String facility_id = "",main_code = "",CBValStr = "",LocnValStr = "";
		String error = "", error_value = "";
		String sql_query = "";
		boolean inserted = false;

		try
		{
			con										=	ConnectionManager.getConnection(request);
			facility_id								=	(String)session.getValue("facility_id");
			webbeans.eCommon.RecordSet recordSet	=	(RecordSet)session.getValue("recordSet");			

			sql_query="select locn_identity, narration_code, holder_name, mr_locn_yn from fm_storage_locn where FS_LOCN_CODE= ? and facility_id= ? and eff_status='E' ";
			pstmt = con.prepareStatement(sql_query);

			main_code			=	request.getParameter("locn_code_main");
			CBValStr			=	request.getParameter("CBValStr");
			LocnValStr			=   request.getParameter("LocnValStr");			

			if(main_code == null || main_code.equals("null")) main_code="";
			if(CBValStr == null || CBValStr.equals("null")) CBValStr="";
			if(LocnValStr == null || LocnValStr.equals("null")) LocnValStr="";
			
			if(main_code.equals(""))
			{	
				StringTokenizer stoken_code = new StringTokenizer(LocnValStr,"~");
				int count_code	= stoken_code.countTokens();
				for(int i=0;i<count_code;i++)
				{
					String locn_code	=	stoken_code.nextToken();
					htLocn.put("locn_code"+i,locn_code);
				}
				for(int j=0; j<htLocn.size(); j++)
				{
					String code_value			= (String)htLocn.get("locn_code"+j);
					StringTokenizer split_code	= new StringTokenizer(code_value,"|");
					String code					= split_code.nextToken();
					String value				= split_code.nextToken();
					String index_val			= code.substring(12);
					int index					= Integer.parseInt(index_val);
					
					pstmt.setString(1, value);
					pstmt.setString(2, facility_id);
					rs = pstmt.executeQuery();
					if(rs != null)
					{
						while(rs.next())
						{
							locn_identity	=	rs.getString("locn_identity");
							narration_code	=	rs.getString("narration_code");
							holder_name		=	rs.getString("holder_name");
							if(locn_identity == null)	locn_identity="";
							if(narration_code == null)	narration_code="";
							if(holder_name == null)		holder_name="";
						}
					} if(rs != null) rs.close();
					
					htRecord			=	(java.util.HashMap)	recordSet.getObject(index);
					
					htRecord.put("associate_yn"		,	"Y");
					htRecord.put("fn_locn_code"		,	value);
					htRecord.put("locn_identity"	,	locn_identity);
					htRecord.put("narration_code"	,	narration_code);
					htRecord.put("holder_name"		,	holder_name);
					htRecord.put("locale"		,	locale);

					recordSet.setObject((index),htRecord);
				}
				
				boolean local_ejbs = false;
				if((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
				
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/FMAssignStorageLocation",FMAssignStorageLocationHome.class,local_ejbs);
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
				
				Object argArray[] = new Object[4];
				argArray[0] = p;
				argArray[1] = recordSet;
				argArray[2] = facility_id;
				argArray[3] = client_ip_address;
				
				Class [] paramArray = new Class[4];
				paramArray[0] = p.getClass();
				paramArray[1] = recordSet.getClass();
				paramArray[2] = facility_id.getClass();
				paramArray[3] = client_ip_address.getClass();
				
				java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertFMAssignLocn",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				
				inserted	= ( ((Boolean) results.get( "status" )).booleanValue() ) ;
				error		= (String) results.get("error") ;				
				results.clear();

				if(inserted)
				{
					error_value="1";
					response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" )+ "&err_value=" + error_value );
				}
				else
				{
					error_value="0";
					response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" )+ "&err_value=" + error_value );
				}				
			}
			else if(!(main_code.equals("")))
			{			
				pstmt.setString(1, main_code);
				pstmt.setString(2, facility_id);
				rs = pstmt.executeQuery();
				if(rs != null)
				{
					while(rs.next())
					{
						locn_identity	=	rs.getString("locn_identity");
						narration_code	=	rs.getString("narration_code");
						holder_name		=	rs.getString("holder_name");
						
						if(locn_identity == null)	locn_identity="";
						if(narration_code == null)	narration_code="";
						if(holder_name == null)		holder_name="";
					}
				}

				int row_count	= recordSet.getSize();
				for(int k=0; k<row_count; k++)
				{
					htRecord			=	(java.util.HashMap)	recordSet.getObject(k);
					
					htRecord.put("associate_yn"		,	"Y");
					htRecord.put("fn_locn_code"		,	main_code);
					htRecord.put("locn_identity"	,	locn_identity);
					htRecord.put("narration_code"	,	narration_code);
					htRecord.put("holder_name"		,	holder_name);
					htRecord.put("locale"		,	locale);
					recordSet.setObject(k,htRecord);
				}
				
				boolean local_ejbs = false;
				if((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
				
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/FMAssignStorageLocation",FMAssignStorageLocationHome.class,local_ejbs);
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
				
				Object argArray[] = new Object[4];
				argArray[0] = p;
				argArray[1] = recordSet;
				argArray[2] = facility_id;
				argArray[3] = client_ip_address;
				
				Class [] paramArray = new Class[4];
				paramArray[0] = p.getClass();
				paramArray[1] = recordSet.getClass();
				paramArray[2] = facility_id.getClass();
				paramArray[3] = client_ip_address.getClass();
				
				java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertFMAssignLocn",paramArray)).invoke(busObj,argArray);
				
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				
				inserted	= ( ((Boolean) results.get( "status" )).booleanValue() ) ;
				error		= (String) results.get("error") ;				
				results.clear();
				if(inserted)
				{
					error_value="1";
					response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" )+ "&err_value=" + error_value );
				}
				else
				{
					error_value="0";
					response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" )+ "&err_value=" + error_value );
				}
				
			}
		htLocn.clear();
		htRecord.clear();
		if(rs != null) rs.close();
		if(pstmt != null)pstmt.close();
		}catch(Exception e3)
		{
			out.println("Exception in main try :"+e3);
		}
		finally
		{				
			ConnectionManager.returnConnection(con, request);			
		}
	}//end of doPost
}//end of Main class
