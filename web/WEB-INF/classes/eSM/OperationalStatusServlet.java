/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSM;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;
import eCommon.SingleTabHandler.*;

public class OperationalStatusServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	PrintWriter out;
	java.util.Properties p; 

	String facility				;
	String client_ip_address 	;
	String operational_modules	;
	Connection con ;
	PreparedStatement pstmt = null ;
	ResultSet rs = null;	

	HttpSession session;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		session 		= req.getSession(false) ;
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		out = res.getWriter() ;
		p = ( java.util.Properties ) session.getValue( "jdbc" ) ;
		client_ip_address = p.getProperty("client_ip_address");
		facility	= req.getParameter( "facility" ) ;
		operational_modules = req.getParameter( "opermodules" ) ;
		
			
		insertUpdateOperValues( req, res );

	}


	private void insertUpdateOperValues(HttpServletRequest req, HttpServletResponse res)
	{try
		{   String addedById = p.getProperty( "login_user" ) ;
			Timestamp  tsTime = new Timestamp(System.currentTimeMillis() );
			boolean inserted = false;
			String error = "";
			String error_value = "";
			Object argArray[]=new Object[4];	
			String table_name="";
			Class [] paramArray=new Class[4];;
			con = ConnectionManager.getConnection(req);
			int rec_count = 0;
			try
			{	java.util.HashMap results=null;
				pstmt = con.prepareStatement("SELECT count(*) FROM SM_MODULES_FACILITY WHERE FACILITY_ID = '"+facility+"' ");
				rs = pstmt.executeQuery();
				if(rs.next()) rec_count = rs.getInt(1);
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(rec_count == 0 && operational_modules.length() > 0)
				{	HashMap tabledata=new HashMap();
					tabledata.put("FACILITY_ID",facility);
					tabledata.put("ADDED_BY_ID",addedById);
					tabledata.put("ADDED_DATE",tsTime);
					tabledata.put("ADDED_AT_WS_NO",client_ip_address);
					tabledata.put("MODIFIED_BY_ID",addedById);
					tabledata.put("MODIFIED_DATE",tsTime);
					tabledata.put("MODIFIED_AT_WS_NO",client_ip_address);
					
					String dupfields[]={"MODULE_ID","FACILITY_ID"};			
					boolean local_ejbs = false;
					if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
					StringTokenizer stoken = new StringTokenizer(operational_modules,"$");
					String Modules = stoken.nextToken();
					String Flags = stoken.nextToken();
					StringTokenizer smodtoken = new StringTokenizer(Modules,"|");
					
					StringTokenizer sflagtoken = new StringTokenizer(Flags,"|");
					while(smodtoken.hasMoreTokens() && sflagtoken.hasMoreTokens())
					{	tabledata.put("MODULE_ID",smodtoken.nextToken());
						tabledata.put("OPERATIONAL_YN",sflagtoken.nextToken());
						table_name="SM_MODULES_FACILITY";
						
						argArray[0] = p;
						argArray[1] = tabledata;
						argArray[2] = dupfields;
						argArray[3] = table_name;
						paramArray[0] = p.getClass();
						paramArray[1] = tabledata.getClass();
						paramArray[2] = dupfields.getClass();
						paramArray[3] = table_name.getClass();
					 results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
					(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
					inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
					error = (String) results.get("error") ;
					error_value = "0" ;
				  
				  }
				   tabledata.clear();
					results.clear();
					}
				else if(rec_count > 0 && operational_modules.length() > 0)
				{	HashMap tabledata=new HashMap();
					HashMap condfields = new HashMap();
					boolean local_ejbs = false;
					if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
					StringTokenizer stoken = new StringTokenizer(operational_modules,"$");
					String Modules = stoken.nextToken();
					String Flags = stoken.nextToken();
					StringTokenizer smodtoken = new StringTokenizer(Modules,"|");
					StringTokenizer sflagtoken = new StringTokenizer(Flags,"|");
					
					

					while(smodtoken.hasMoreTokens() && sflagtoken.hasMoreTokens())
					{	 tabledata.clear();
						String flagtoken	=sflagtoken.nextToken();
						String modtoken	=smodtoken.nextToken();
			            
					/******************* added later********************************************************/			
						//The facility may not have the module....so do not update or insert*/
						pstmt = con.prepareStatement("SELECT count(*) FROM SM_MODULES_FACILITY WHERE MODULE_ID = '"+modtoken+"' and FACILITY_ID='"+facility+"' ");
						
						rs = pstmt.executeQuery();
						if(rs.next()) rec_count = rs.getInt(1);
						if(rs!=null) rs.close();
				        if(pstmt!=null) pstmt.close();
						if(rec_count!=0)
						{	tabledata.put("OPERATIONAL_YN",flagtoken);
							tabledata.put("MODIFIED_BY_ID",addedById);
							tabledata.put("MODIFIED_DATE",tsTime);
							tabledata.put("MODIFIED_AT_WS_NO",client_ip_address);
                           
    						condfields.put("FACILITY_ID",facility);
							condfields.put("MODULE_ID",modtoken);				
							table_name="SM_MODULES_FACILITY";
							argArray[0] = p;
							argArray[1] = tabledata;
							argArray[2] = condfields;
							argArray[3] = table_name;
							paramArray[0] = p.getClass();
							paramArray[1] = tabledata.getClass();
							paramArray[2] = condfields.getClass();
							paramArray[3] = table_name.getClass();
						 results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
							(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
							inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
							error = (String) results.get("error") ;
							error_value = "0" ;
						//tabledata.clear();
						condfields.clear();
						}//inner if rec_count!=0
						else
						{ 

							tabledata.put("MODULE_ID",modtoken);
							tabledata.put("FACILITY_ID",facility);
							tabledata.put("OPERATIONAL_YN",flagtoken);
							tabledata.put("ADDED_BY_ID",addedById);
							tabledata.put("ADDED_DATE",tsTime);
							tabledata.put("ADDED_AT_WS_NO",client_ip_address);
							tabledata.put("MODIFIED_BY_ID",addedById);
							tabledata.put("MODIFIED_DATE",tsTime);
							tabledata.put("MODIFIED_AT_WS_NO",client_ip_address);
						
						String dupfields[]={"MODULE_ID","FACILITY_ID"};
					    	table_name="SM_MODULES_FACILITY";
							argArray[0] = p;
							argArray[1] = tabledata;
							argArray[2] = dupfields;
							argArray[3] = table_name;
							paramArray[0] = p.getClass();
							paramArray[1] = tabledata.getClass();
							paramArray[2] = dupfields.getClass();
							paramArray[3] = table_name.getClass();
				        results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
						(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
						inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
						error = (String) results.get("error") ;
						
						error_value = "0" ;
						results.clear();
					 
					}
				/********************************** addition ends***********************************************/
					}  tabledata.clear();
					   condfields.clear();
					   results.clear();//while inner
				}	//else if rec_count>0
			}
			catch(Exception e)
			{	out.println(e.toString());	}
			finally
			{   	if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if( con != null ) ConnectionManager.returnConnection(con,req);
			}
			if ( inserted )  error_value = "1" ;
			else error_value = "0" ;
		res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
	}
	catch ( Exception e )
	{	out.println( e.getMessage() );	}
	}
}
