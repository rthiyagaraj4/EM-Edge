/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/****** Last Modified Date Time 9/22/2005 10:50 AM *****/
package eMP;

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

public class StdOtherNameServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	PrintWriter out;
	java.util.Properties p;

	String other_name;
	String other_name_loc_lang;
	String eff_status;
	String facilityId ;
	String client_ip_address ;
	String locale			= "" ;

	HttpSession session;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;

		this.facilityId = (String) session.getValue( "facility_id" ) ;
		client_ip_address =  p.getProperty("client_ip_address");
		locale = p.getProperty("LOCALE");

		try
		{
			this.out = res.getWriter();
			String operation = req.getParameter("function_name");

			if ( operation.equals("insert") )   insertStdOtherName(req, res);
			if ( operation.equals("modify"))  modifyStdOtherName(req, res);
		}
		catch(Exception e)
		{
			//out.println(e.toString());
			e.printStackTrace();
		}
	}

	private void insertStdOtherName(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			other_name						=req.getParameter("other_name");
			other_name_loc_lang			=req.getParameter("oth_in_oth_lang");
			eff_status						    =req.getParameter("eff_status");

			if ( eff_status == null )
				 eff_status = "D";

			if(other_name == null || other_name.equals("null"))other_name="";
			if(other_name_loc_lang == null || other_name_loc_lang.equals("null"))other_name_loc_lang="";

			/*if(!(other_name_loc_lang.equals("")))
			{
				InputStreamReader reader = new InputStreamReader( new ByteArrayInputStream( other_name_loc_lang.getBytes()), "windows-1256" ) ;
				other_name_loc_lang = (new BufferedReader(reader)).readLine() ;
			}*/

			String addedById = p.getProperty( "login_user" ) ;
			String modifiedById = addedById ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			Connection con = null;
			ResultSet rs = null ;
			PreparedStatement pstmt=null;
			try
			{
				if(other_name != null)
				{
					con = ConnectionManager.getConnection(req);
					pstmt=con.prepareStatement("select * from mp_std_other_name where upper(other_name) = upper(?)" );
					
					pstmt.setString(1,other_name);
					rs = pstmt.executeQuery() ;

					if(!rs.next())
					{
						HashMap tabdata=new HashMap();
						tabdata.put("other_name",other_name);
						tabdata.put("other_name_loc_lang",other_name_loc_lang);
						tabdata.put("eff_status",eff_status);

						tabdata.put("added_by_id",addedById);
						tabdata.put("added_date",new  java.sql.Timestamp(System.currentTimeMillis()));
						tabdata.put("added_facility_id", facilityId);
						tabdata.put("added_at_ws_no",addedAtWorkstation);
						tabdata.put("modified_by_id",modifiedById);
						tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
						tabdata.put("modified_facility_id",modifiedFacilityId);
						tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

						String dupflds[]={"other_name"};

						boolean local_ejbs = isLocalEJB();
						Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
						Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

						Object argArray[] = new Object[4];
						argArray[0] = p;
						argArray[1] = tabdata;
						argArray[2] = dupflds;
						argArray[3] = "mp_std_other_name";

						Class [] paramArray = new Class[4];
						paramArray[0] = p.getClass(); ;
						paramArray[1] = tabdata.getClass();
						paramArray[2] = dupflds.getClass();
						paramArray[3] = String.class;
						
						java.util.HashMap results = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
						(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
						
						argArray = null;
						paramArray = null;
						tabdata.clear();

						boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

						String error = (String) results.get("error") ;
						String error_value = "0" ;
						if ( inserted )
						{
							 error_value = "1" ;
						}
						 results.clear();
						res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8") + "&err_value=" + error_value );
						
				   }
				   else
				   {
						
						String error_value="0";
							MessageManager mm = new MessageManager();
							final java.util.Hashtable message = mm.getMessage( locale,"CODE_ALREADY_EXISTS","Common") ;
							String msg =  (String) message.get("message");
							message.clear();
							res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( msg , "UTF-8" ) + "&err_value=" + error_value );
					}
			  }	
			 
			}
			catch(Exception e){}
			finally
		    {
			    if (rs!=null) rs.close();
			    if (pstmt!=null) pstmt.close();
				if(con != null) ConnectionManager.returnConnection(con,req);
		    }
		}
	   catch ( Exception e )
	   {
			//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			//out.println( "Values sent are : <br>" ) ;
			e.printStackTrace();
	   }	   
	}

	private void modifyStdOtherName(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			other_name						=req.getParameter("other_name");
			other_name_loc_lang		=req.getParameter("oth_in_oth_lang");
			eff_status						    =req.getParameter("eff_status");

			if ( eff_status == null )
				 eff_status="D";

			if(other_name == null || other_name.equals("null"))other_name="";
			if(other_name_loc_lang == null || other_name_loc_lang.equals("null"))other_name_loc_lang="";
			
		/*	if(!(other_name_loc_lang.equals("")))
			{
				InputStreamReader reader = new InputStreamReader( new ByteArrayInputStream( other_name_loc_lang.getBytes()), "windows-1256" ) ;
				other_name_loc_lang = (new BufferedReader(reader)).readLine() ;
			}*/


			String addedById = p.getProperty( "login_user" ) ;
			String modifiedById = addedById ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			HashMap tabdata=new HashMap();
				tabdata.put("other_name",other_name);
				tabdata.put("other_name_loc_lang",other_name_loc_lang);
				tabdata.put("eff_status",eff_status);

				tabdata.put("modified_by_id",modifiedById);
				tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
				tabdata.put("modified_facility_id",modifiedFacilityId);
				tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

				HashMap condflds=new HashMap();
				condflds.put("other_name",other_name);

			boolean local_ejbs = isLocalEJB();
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = condflds;
			argArray[3] = "mp_std_other_name";

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass(); ;
			paramArray[1] = tabdata.getClass();
			paramArray[2] = condflds.getClass();
			paramArray[3] = String.class;
			
			java.util.HashMap results = (HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			
			argArray = null;
			paramArray = null;
			tabdata.clear();

			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error") ;
			String error_value = "0" ;
			if ( inserted )
			{
			 error_value = "1" ;
			}
			condflds.clear();
			 results.clear();
			 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8") + "&err_value=" + error_value );

			 
		}
		catch ( Exception e )
		{
			//out.println("<h3> Exception raise by Servlet ... Record Not Modified </h3> Foll: Error Received : "+e.toString());
			//out.println( "Values sent are : <br>" ) ;
			e.printStackTrace();
		}
	}
	
	boolean isLocalEJB(){
		ServletContext context = getServletConfig().getServletContext();
		if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			return true;
		else
			return false;
	}
}
